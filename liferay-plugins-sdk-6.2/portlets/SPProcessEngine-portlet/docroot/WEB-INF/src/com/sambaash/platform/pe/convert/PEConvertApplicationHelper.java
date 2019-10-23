package com.sambaash.platform.pe.convert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.bind.JAXBException;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.constant.FormConstants;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.cache.PEProcessCache;
import com.sambaash.platform.pe.cache.PEProcessDirectory;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.exception.PEConfigException;
import com.sambaash.platform.pe.exception.PEProcessStateException;
import com.sambaash.platform.pe.helpers.PEProcessStateHelper;
import com.sambaash.platform.pe.jaxb.PEForm;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.FormBuilderLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEEngineLocalServiceUtil;

public class PEConvertApplicationHelper {

	private PEDataSource ds;
	private PEDS convertDS;
	
	/** * Configuration data takes below format
	     {
	    	fieldMap :[
					       {
					          srcField :"firstName",
					          destField :"firstName",
					          type:"text"
					       },
					       {
					          srcField :"lastName",
					          destField :"lastName",
					          type:"text"
					       }
	    			]
		 }

	 **/
	private JSONObject config;
	private long targetProcessId;
	private long targetEntityId;
	private long targetEntityClassId;
	
	private JSONArray newFormFields;
	private Map<String,File> files;
	
	private PEConvertApplicationHelper(PEDataSource ds,PEDS conversionSource,JSONObject config,long targetProcessId,long targetEntityClassId,long targetEntityId){
		this.ds  = ds;
		this.convertDS = conversionSource;
		this.config = config;
		this.targetProcessId = targetProcessId;
		this.targetEntityClassId = targetEntityClassId;
		this.targetEntityId = targetEntityId;
	}
	
	public static PEConvertApplicationHelper getInstance(PEDataSource ds,PEDS conversionSource,JSONObject config,long targetProcessId,long targetEntityClassId,long targetEntityId){
		return new PEConvertApplicationHelper(ds,conversionSource,config, targetProcessId,targetEntityClassId,targetEntityId);
	}
	
	public PEProcessState convert(boolean linkNewOldProcessStates) throws PEConfigException, FileNotFoundException, PortalException, SystemException, JAXBException, PEProcessStateException{
		_log.debug("Preparing form data to submit to form builder");
		String response = submitDataToFormBuilder();
		_log.debug("Call to Form Builder is completed.");
		_log.debug("Preparing data to submit to process engine");
		PEProcessDirectory directory = PEProcessCache.getInstance().getProcessDirectory(targetProcessId);
		PEForm form = directory.getFirstForm();
		_log.debug("Identified the target form from target process. Form " + form);
		PEProcessState old = ds.getProcessState();
		JSONObject obj  = JSONFactoryUtil.createJSONObject(response);
		_log.debug("Submiting the data  to Process Engine");
		Map<String,String[]>params = new LinkedHashMap<String, String[]>();
		params.put(PEConstants.PARAM_SUPPRESS_MAIL_NOTIFICATIONS, new String[]{String.valueOf(ds.isSuppressMailNotifications())});
		PEProcessState newProcessState = PEEngineLocalServiceUtil.runProcessEngineUsingFormId(targetEntityClassId,targetEntityId, targetProcessId, form.getFormId(), obj.getString(FormConstants.kEY_OUTPUT),params);
		_log.debug("Process Engine execution completed.newProcessState " + newProcessState);
		if(linkNewOldProcessStates){
			_log.debug("Creating the link between new and old process states");
			old.setConvertedToProcessStateId(newProcessState.getSpPEProcessStateId());
			newProcessState.setConvertedFromProcessStateId(old.getSpPEProcessStateId());
			PEProcessStateHelper.updateProcessState(old, ds.getRequestData());
		}
		newProcessState.setUserIdSupervisor(old.getUserIdSupervisor());
		newProcessState.setUserIdAgent(old.getUserIdAgent());
		PEProcessStateHelper.updateProcessState(newProcessState, ds.getRequestData());
		
		User user = UserLocalServiceUtil.getUser(old.getUserIdProcess());
		user.setEmailAddressVerified(true);
		UserLocalServiceUtil.updateUser(user);
		
		
		_log.debug(" *****Conversion Successfully Done.. New Process State Id = " + newProcessState.getSpPEProcessStateId());
		return newProcessState;
	}
	
	public String submitDataToFormBuilder() throws PEConfigException, JAXBException, FileNotFoundException, PortalException, SystemException{
		PEProcessDirectory directory = PEProcessCache.getInstance().getProcessDirectory(targetProcessId);
		PEForm form = directory.getFirstForm();
		
		parse(config);

		JSONObject formData = JSONFactoryUtil.createJSONObject();
		formData.put("step1", newFormFields);
		if(_log.isDebugEnabled()){
			_log.debug("FormData to Be Submitted to form builder  " + formData.toString());
		}

		String response ;
		if(!files.isEmpty()){
			response = FormBuilderLocalServiceUtil.submitFormDataMultipart(form.getFormId(), formData.toString(), ds.getRequestData().getUserId(), files);
		}else{
			response = FormBuilderLocalServiceUtil.submitFormData(form.getFormId(), formData.toString(), ds.getRequestData().getUserId());
		}
		_log.debug("Response fro form builder  " + response);
		return response;
	}
	
	
	/**
	 * Method used to return fields in json format understanable by form builder
	 * 
	 * @param config
	 * @throws JSONException
	 */
	public void parse(JSONObject config) throws JSONException{
		_log.debug("Preparing the data to submit to form builder");
		PESubmitApplicationHelper formSubmitHelper = new PESubmitApplicationHelper();
		newFormFields = JSONFactoryUtil.createJSONArray();
		files = new LinkedHashMap<>();

		JSONArray fieldMap = JSONFactoryUtil.createJSONArray(config.getString("fieldMap"));
		int length = fieldMap.length();
		for( int i = 0; i < length ; i++){
			JSONObject fieldConfig = fieldMap.getJSONObject(i);
			String srcField = fieldConfig.getString("srcField");
			String destField = fieldConfig.getString("destField");
			String type = fieldConfig.getString("type");
			
			JSONObject formField = null;  
			String value;String[] vlaues ;
			switch(type){
				case "text":
					 String srcFieldType = fieldConfig.getString("srcFieldType");
					 if(srcFieldType.equalsIgnoreCase("select")){
						 String srcValueTypeToCopy = fieldConfig.getString("srcValueTypeToCopy");
						 if(srcValueTypeToCopy.equalsIgnoreCase("text")){
							 value = convertDS.getDisplayText(srcField);
						 }else{
							 value = convertDS.getSimpleValue(srcField);
						 }
					 }else{
						 value = convertDS.getValue(srcField);
					 }
					 formField = PESubmitApplicationHelper.getJsonForTextField(destField, value);
					 break;
				case "textArea" : 
					 value = convertDS.getValue(srcField);
					formField = PESubmitApplicationHelper.getJsonForTextArea(destField, value); 
					break;
				case "select" :
					vlaues = convertDS.getDropdownValues(srcField);
					formField = PESubmitApplicationHelper.getJsonForDropdown(destField, vlaues, StringPool.BLANK);
					break;
				case "file"  :
					File file = convertDS.getFile(srcField);
					if(file != null){
						formField = PESubmitApplicationHelper.getJsonForInputFile(destField, file.getName());
						files.put(destField, file);
					}
					break;
				case "checkbox" :
					value = fieldConfig.getString("value");
					if(Validator.isNotNull(value)){
						formField = PESubmitApplicationHelper.getJsonForCheckboxUsingJsonArrayStr(destField, value);
					}else{
						vlaues = convertDS.getCheckboxValues(srcField);
						formField = PESubmitApplicationHelper.getJsonForCheckbox(destField, vlaues);
					}
					break;
					
				default:
			}
			
			if(formField != null){
				newFormFields.put(formField);
			}
			
		}
		if(_log.isDebugEnabled()){
			_log.debug("Prepared the data to submit to form builder.New Fields " + newFormFields.toString());
		}
	}
	
	
	private static Log _log = LogFactoryUtil
			.getLog(PEConvertApplicationHelper.class.getName());
}
