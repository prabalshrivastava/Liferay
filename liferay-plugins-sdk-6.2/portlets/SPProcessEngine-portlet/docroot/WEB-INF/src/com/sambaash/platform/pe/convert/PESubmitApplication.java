package com.sambaash.platform.pe.convert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import com.liferay.compat.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.sambaash.platform.constant.FormConstants;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.pe.PEFormField;
import com.sambaash.platform.pe.PESubmitAppRequest;
import com.sambaash.platform.pe.PESubmitAppResponse;
import com.sambaash.platform.pe.cache.PEProcessCache;
import com.sambaash.platform.pe.cache.PEProcessDirectory;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.exception.PEConfigException;
import com.sambaash.platform.pe.jaxb.PEForm;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.FormBuilderLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEEngineLocalServiceUtil;

public class PESubmitApplication {

	private static final Log _log = LogFactoryUtil.getLog(PESubmitApplication.class);
	private PESubmitAppRequest submitRequest;
	private PESubmitAppResponse peresponse = new PESubmitAppResponse();
	private Map<String,List<File>> files = new LinkedHashMap<>();
	
	public PESubmitApplication(PESubmitAppRequest request){
		this.submitRequest = request;
	}
	
	public PESubmitAppResponse submit() throws PEConfigException, PortalException, SystemException, JAXBException, FileNotFoundException{
		_log.debug("Preparing form data to submit to form builder");
		String formBResponse = submitDataToFormBuilder();
		if(peresponse.getErrors().size() > 0 || Validator.isNull(formBResponse)){
			_log.debug("Errors in request. So won't be submitted to process engine");
			return peresponse;
		}
		_log.debug("Preparing data to submit to process engine");
		PEProcessDirectory directory = PEProcessCache.getInstance().getProcessDirectory(submitRequest.getProcessId());
		PEForm form = directory.getFirstForm();
		_log.debug("Identified the target form from target process. Form " + form);
		JSONObject obj  = JSONFactoryUtil.createJSONObject(formBResponse);
		_log.debug("Submiting the data  to Process Engine");
		
		Map<String,String[]>params = new LinkedHashMap<String, String[]>();
		params.put(PEConstants.PARAM_SUPPRESS_MAIL_NOTIFICATIONS, new String[]{String.valueOf(submitRequest.isSupressMailNotifications())});
		
		PEProcessState newProcessState = PEEngineLocalServiceUtil
				.runProcessEngineUsingFormId(
						submitRequest.getEntityClassId(), 
						submitRequest.getEntityId(),
						submitRequest.getProcessId(), form.getFormId(),
						obj.getString(FormConstants.kEY_OUTPUT), params);
		if( newProcessState != null && newProcessState.getSpPEProcessStateId() > 0){
			_log.debug("*** Successfully submitted application to Process Engine and execution completed.newProcessState " + newProcessState);
			
		}else{
			_log.error("*** Error while processing submit applciation" );
		}
		
		peresponse.setProcessStateId(newProcessState.getSpPEProcessStateId());
		return peresponse;
	}
	
	public String submitDataToFormBuilder() throws PEConfigException, JAXBException, PortalException, SystemException, FileNotFoundException{
		//step 1: Get the first form to submit
		PEProcessDirectory directory = PEProcessCache.getInstance().getProcessDirectory(submitRequest.getProcessId());
		PEForm form = directory.getFirstForm();

		// Step3: Prepare form fields data to submit to form
		JSONArray formFieldsData = prepareFormData(form);
		
		if(peresponse.getErrors().size() > 0){
			return "";
		}
		
		// Step4: prepare request to submit to form
		JSONObject formData = JSONFactoryUtil.createJSONObject();
		formData.put("step1", formFieldsData);
		if(_log.isDebugEnabled()){
			_log.debug("FormData to Be Submitted to form builder  " + formData.toString());
		}

		String response ;
		if(!files.isEmpty()){
			response = FormBuilderLocalServiceUtil.submitFormDataMultipartMultipleFiles(form.getFormId(), formData.toString(), submitRequest.getUserId(), files);
		}else{
			response = FormBuilderLocalServiceUtil.submitFormData(form.getFormId(), formData.toString(), submitRequest.getUserId());
		}

		//response = FormBuilderLocalServiceUtil.submitFormData(form.getFormId(), formData.toString(), submitRequest.getUserId());
		_log.debug("Response form builder  " + response);
		return response;

	}
	
	private JSONArray prepareFormData(PEForm form) throws PortalException, SystemException{
		// Get the form schema
		JSONArray formSchema = FormBuilderLocalServiceUtil.getFormSchema(submitRequest.getUserId(), form.getFormId());

		Map<String, PEFormField>  formFields = submitRequest.getFields();
		// prepare data to submit to form
		JSONArray newFormFields = JSONFactoryUtil.createJSONArray();
		for(int index = 0; index < formSchema.length() ; index++){
			JSONObject field = formSchema.getJSONObject(index);
			String fieldId = field.getString(FormConstants.KEY_ID);
			
			PEFormField formField = formFields.get(fieldId);
			
			String fieldLabel = field.getString(FormConstants.KEY_LABEL);
			String type = field.getString(FormConstants.KEY_COMPONENT);
			boolean required = field.getBoolean("required");
			if(required){
				if(formField == null || formField.getValues() == null || formField.getValues().size() == 0){
					peresponse.addError("Required field is missing: " + fieldLabel);
					continue;
				}
			}
			if(formField == null || formField.getValues() == null || formField.getValues().size() == 0){
				continue;
			}
			List<String>values = formField.getValues();
			String value = values.get(0);
			if(required){
				if(Validator.isNull(value)){
					peresponse.addError("Required field is missing: " + fieldLabel);
					continue;
				}
			}
			JSONObject formFieldJson = null;
			if("nameInput".equalsIgnoreCase(type) || "emailInput".equalsIgnoreCase(type)  || "textInput".equalsIgnoreCase(type) || "radio".equalsIgnoreCase(type) ){
				formFieldJson = PESubmitApplicationHelper.getJsonForTextField(fieldId, value);				
			}
			else if("select".equalsIgnoreCase(type)){
				formFieldJson = PESubmitApplicationHelper.getJsonForDropdown(fieldId, values.toArray(new String[]{}), StringPool.BLANK);
			}
			else if("checkbox".equalsIgnoreCase(type) ){
				formFieldJson = PESubmitApplicationHelper.getJsonForCheckbox(fieldId, values.toArray(new String[]{}));
			}
			else if("fileupload".equalsIgnoreCase(type) ){
				List<File> fileList = new ArrayList<File>();
				List<String> fileNames = new ArrayList<String>();
				for (String feIdStr : values) {
					long feId = GetterUtil.getLong(feIdStr);
					if(feId > 0){
						File file = getLocallyStoredFile(feId);
						fileNames.add(file.getName());
						fileList.add(file);
					}
				}
				formFieldJson = PESubmitApplicationHelper.getJsonForInputFiles(fieldId, fileNames.toArray(new String[]{}));
				files.put(fieldId, fileList);
			}

			if(formFieldJson != null){
				newFormFields.put(formFieldJson);
			}
		}
	
		return newFormFields;
	}
	
	
	
	
	public File getLocallyStoredFile(long feId) throws PortalException, SystemException{
		FileEntry fileEntry = DLAppServiceUtil.getFileEntry(feId);;
		File file = null;
		if(fileEntry != null){
			file = PEDS.storeFileLocally(fileEntry);
		}
		return file;
	}
}
