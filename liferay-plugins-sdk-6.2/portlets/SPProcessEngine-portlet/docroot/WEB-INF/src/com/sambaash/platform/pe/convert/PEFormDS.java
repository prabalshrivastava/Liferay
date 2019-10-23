package com.sambaash.platform.pe.convert;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.constant.FormConstants;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.helpers.PEUploadHelper;
import com.sambaash.platform.pe.jaxb.PEForm;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
import com.sambaash.platform.srv.processbuilder.service.FormBuilderLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalServiceUtil;

public class PEFormDS extends PEDS{

	public static String KEY_FULL_URL = "fullUrl";
	private PEDataSource ds;
	private PEForm formNode;
	private JSONArray stepData ;
	
	/** data object constructed by parsing the data in key, value  format so that accessing the data will be easy and faster **/
	private JSONObject data;
	
	/** attachmentsInfo contains extra info for attachments like complete url to attachment. This object caches all the info so that repeated calls to form
	    builder can be reduced.*/
	private Map<String,JSONArray> attachmentsInfo;
	
	private boolean isValid;
	private PEProcessAudit audit;

	public PEFormDS(PEDataSource ds, PEForm formNode) throws PortalException, SystemException{
		this.ds = ds;
		this.formNode = formNode;
		init();
	}
	
	public void init() throws PortalException, SystemException{
		try {
			 audit = PEProcessAuditLocalServiceUtil.findLatestByProcessStateIdNodeId(ds.getProcessState().getSpPEProcessStateId(), formNode.getNodeId());
			JSONObject form = JSONFactoryUtil.createJSONObject(audit.getData1());
			JSONObject content = JSONFactoryUtil.createJSONObject(form.getString(FormConstants.KEY_CONTENT));
			stepData = JSONFactoryUtil.createJSONArray(content.getString(FormConstants.KEY_STEP_1));
			createDataMap();
			setValid(true);
		} catch (Exception e) {
			_log.error("Error while fetching data from Audit.PEProcessStateId " + ds.getProcessState().getSpPEProcessStateId());
			_log.error(e);
			setValid(false);
		}
	}
	
	public String[] getDropdownValues(String fieldId){
		return new String[]{};
	}
	
	public String[] getCheckboxValues(String fieldId){
		String arrayStr = getValue(fieldId);
		if(Validator.isNotNull(arrayStr)){
			try{
				 JSONArray valuesArray = JSONFactoryUtil.createJSONArray(arrayStr);
				 String[] values = new String[valuesArray.length()];
				 for(int i = 0 ; i < valuesArray.length(); i++){
					 JSONObject obj = valuesArray.getJSONObject(i);
					 values[i] = obj.getString(FormConstants.KEY_VALUE);
				 }
				 return values;
			}catch(Exception ex){
				_log.error(ex);
			}
		}
		return new String[]{};
	}
	
	public String getValue(String fieldId){
		return data.getString(fieldId);
	}
	// this method should return only value
	public String getSimpleValue(String fieldId){
		String str = getValue(fieldId);
		JSONArray array = null;
		try {
			array = JSONFactoryUtil.createJSONArray(str);
		} catch (JSONException e) {
			//_log.error("Error while creating json array from " + str + ". Looks it's simple string");
		}
		if(array != null){
			if(array.length() > 0){
				JSONObject obj = array.getJSONObject(0);
				return obj.getString(FormConstants.KEY_VALUE);
			}
		}else{
			return str;
		}
		return StringPool.BLANK;
	}
	// this method useful to return display text, in case selection type fields
	public String getDisplayText(String fieldId){
		String str = getValue(fieldId);
		JSONArray array = null;
		try {
			   array = JSONFactoryUtil.createJSONArray(str);
		} catch (JSONException e) {
			//_log.error("Error while creating json array from " + str + ". Looks it's simple string");
		}
		if(array != null){
			if(array.length() > 0){
				JSONObject obj = array.getJSONObject(0);
				return obj.getString(FormConstants.KEY_TEXT);
			}
		}else{
			return str;
		}
		
		return StringPool.BLANK;
	
	}
	public void createDataMap(){
		
		String tempId;
		String result = StringPool.BLANK;
		data = JSONFactoryUtil.createJSONObject();
		
		if(stepData == null) return ;
		
		for (int i = 0; i < stepData.length(); i++) {
			JSONObject field = stepData.getJSONObject(i);
			tempId = field.getString(FormConstants.KEY_ID);

			if(field.has(FormConstants.KEY_VALUE)){
				result = field.getString(FormConstants.KEY_VALUE);
			}else if(field.has(FormConstants.KEY_OPTION_LIST)){
				//TODO: restricting to save only one value but have to save all
				try {
					JSONArray optionlist = field.getJSONArray(FormConstants.KEY_OPTION_LIST);
					result = optionlist.toString();
					/*if (optionlist != null && optionlist.length() > 0) {
						result = optionlist.getJSONObject(0).getString(FormConstants.KEY_VALUE);
					}*/
				} catch (Exception e) {
					_log.error(e);
				}
			}else if(field.has(FormConstants.KEY_ATTACHMENTS)){
				try {
					JSONArray optionlist = field.getJSONArray(FormConstants.KEY_ATTACHMENTS);
					result = optionlist.toString();
				} catch (Exception e) {
					_log.error(e);
				}
			}else if(field.has(FormConstants.KEY_OPTIONS)){
				//TODO: restricting to save only one value but have to save all
				try {
					JSONArray optionlist = field.getJSONArray(FormConstants.KEY_OPTIONS);
					result = optionlist.toString();
				/*	if (optionlist != null && optionlist.length() > 0) {
						result = optionlist.getJSONObject(0).getString(FormConstants.KEY_VALUE);
					}*/
				} catch (Exception e) {
					_log.error(e);
				}
			}
			data.put(tempId, result);
		}
	}
	
	public File getFile(String fieldId) {
		JSONObject info =  getAttachmentInfo(fieldId);
		try {
			 File file =  PEUploadHelper.download(info.getString(KEY_FULL_URL),info.getString(FormConstants.KEY_ATTACHMENT_NAME));
			 return file;
		} catch (PortalException | SystemException | IOException e) {
			_log.error(e);
		}
		return null;
	}
	
	public JSONObject getAttachmentInfo(String fieldId){
		// loading on demand
		if(attachmentsInfo == null){
			loadAttachmentsInfo();
		}
		try {
			JSONArray fileArray = attachmentsInfo.get(fieldId);
			if(fileArray != null && fileArray.length() > 0){
				JSONObject info = fileArray.getJSONObject(0);
				return info;
			}
		} catch (Exception e) {
			_log.error(e);
		}
		
		return null;
	}
	
	private void loadAttachmentsInfo(){
		attachmentsInfo = new HashMap<String, JSONArray>();

		if(audit == null) return;
		

		String urlPrefix = FormBuilderLocalServiceUtil.getUrlAttachmentPrefix();
		String response = FormBuilderLocalServiceUtil.getAttachmentSInfo(ds.getProcessState().getUserIdProcess(), audit.getStorageId());
		try {
			// response is array of attachment info objects
			JSONArray responseArray = JSONFactoryUtil.createJSONArray(response);
			JSONArray infoArray = null;
			int length = responseArray.length();
			for(int i = 0 ; i < length ; i++){
				// find url for each attachment
				JSONObject info = responseArray.getJSONObject(i);
				String urlSuffix = info.getString(FormConstants.KEY_URL);
				String title = info.getString(FormConstants.KEY_ATTACHMENT_NAME);
				if(Validator.isNotNull(title)){
					String encoded = HttpUtil.encodeURL(title,true);
					urlSuffix = urlSuffix.replace(title, encoded);
					String url = FormBuilderLocalServiceUtil.constructAttachmentUrl(urlPrefix, urlSuffix);
					info.put("fullUrl", url);
					String fieldId = info.getString(FormConstants.KEY_FIELD_ID);
					infoArray = attachmentsInfo.get(fieldId);
					if(infoArray ==  null) {
						infoArray = JSONFactoryUtil.createJSONArray();
					}
					infoArray.put(info);
					attachmentsInfo.put(fieldId, infoArray);
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	private static Log _log = LogFactoryUtil.getLog(PEFormDS.class.getName());

}
