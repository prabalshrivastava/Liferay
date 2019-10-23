package com.sambaash.platform.pe.adapter;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.constant.FormConstants;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.model.PERuleSet;
import com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalServiceUtil;

public class PEFormDataAdapter {
	private JSONObject formsData;
	private PEProcessState processState;
	
	private static int DEFAULT_STEP_NO = 1;
	private static final String JUST_SUBMITTED_FORM_DATA = "datasubmitted";
	
	private PEFormDataAdapter(PEProcessState processState){
		this.formsData = JSONFactoryUtil.createJSONObject();
		this.processState = processState;
	}
	
	public static PEFormDataAdapter getFormDataAdapter(PEProcessState processState){
		return new PEFormDataAdapter(processState);
	}
	public String getDataFromJustSubmittedForm(String fieldId){
		return getDataFromForm(JUST_SUBMITTED_FORM_DATA, fieldId);
	}
	public String getDataFromForm(String formId, String fieldId) {
		JSONObject form = formsData.getJSONObject(formId);
		String value = StringPool.BLANK;

		if (Validator.isNotNull(form)) {
			value = getDataFromForm(form, DEFAULT_STEP_NO, fieldId);
		}else if(!JUST_SUBMITTED_FORM_DATA.equals(formId)){
			// pull the form data from form builder
			try {
				form = fetchFormData(GetterUtil.getLong(formId));
			} catch (Exception e) {
				_log.error(e);
			}
			if (Validator.isNotNull(form)) {
				// fetch the value corresponding to requested field
				value = getDataFromForm(form, DEFAULT_STEP_NO, fieldId);	
			}
		}
		return value;
	}
	
	public JSONObject fetchFormData(long formId) throws SystemException {
		JSONObject form = formsData.getJSONObject(String.valueOf(formId));
		if (Validator.isNull(form)) {
			//TODO: change to load from latest ruleset
				PEProcessAudit audit = PEProcessAuditLocalServiceUtil.findByProcessStateIdFormId(processState.getSpPEProcessStateId(), formId);
				try {
					if(audit != null){
						form = JSONFactoryUtil.createJSONObject(audit.getData1());	
					}
				} catch (JSONException e) {
					_log.error("Error : " + processState.getSpPEProcessStateId() + " : " + formId);
					_log.error(e);
				}
		}
		registerFormData(formId, form);
		return form;
	}
	
	public void registerFormData(String formId, JSONObject form) {
		formsData.put(formId, form);
	}
	
	private void registerFormData(long formId, JSONObject form) {
		registerFormData(String.valueOf(formId), form);
	}
	
	public void registerAsJustSubmitted(JSONObject data) throws PEException{
		String formId = data.getString(FormConstants.KEY_HTML_FORM_ID);
		String storageId = data.getString(FormConstants.KEY_STORAGE_ID);
		if(!Validator.isNumber(storageId)){
			throw new PEException(PEErrors.FORM_SAVE_ERROR_DATA_INVALID);
		}
		registerFormData(JUST_SUBMITTED_FORM_DATA, data);
		registerFormData(formId, data);
	}
	
	public long getFormStorageId(PERuleSet ruleset ) {
		long formId = GetterUtil.getLong(ruleset.getComponentId());
		return getFormStorageId(formId);
	}
	
	public long getFormStorageId(long formId) {
		JSONObject form = null;
		try {
			form = fetchFormData(formId);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}
		long id = 0;
		if (Validator.isNotNull(form)) {
			id = GetterUtil.getLong(form.getString(FormConstants.KEY_STORAGE_ID));
		}

		return id;
	}
	public long getFormStorageIdUsingFormId(long formId) {
		JSONObject form = null;
		try {
			form = fetchFormData(formId);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}
		long id = 0;
		if (Validator.isNotNull(form)) {
			id = GetterUtil.getLong(form.getString(FormConstants.KEY_STORAGE_ID));
		}
		return id;
	}
	
	public JSONObject fetchFormData(PERuleSet ruleset ) throws SystemException {
		long formId = GetterUtil.getLong(ruleset.getComponentId());
		JSONObject form = fetchFormData(formId);

		if (Validator.isNull(form)) {
			form = JSONFactoryUtil.createJSONObject();
		}

		return form;
	}

	/**
	 * TODO: Define example format
	 * @param form
	 * @param stepNo
	 * @param fieldName
	 */
	private static String getDataFromForm(JSONObject form, int stepNo, String fieldId) {

		JSONObject content;
		try {
			content = JSONFactoryUtil.createJSONObject(form.getString(FormConstants.KEY_CONTENT));
			JSONArray stepData = JSONFactoryUtil.createJSONArray(content.getString("step"+stepNo));
			String tempId;
			String result = StringPool.BLANK;

			for (int i = 0; i < stepData.length(); i++) {
				JSONObject field = stepData.getJSONObject(i);
				tempId = field.getString(FormConstants.KEY_ID);

				if (fieldId.equalsIgnoreCase(tempId) ) {
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
					return result;
				}
			}
		} catch (JSONException e) {
			_log.error(e);
		}catch(Exception e){
			_log.error(e);
		}

		return StringPool.BLANK;
	}

	public String getDataFromForm(long formId, String fieldName) {
		return getDataFromForm(String.valueOf(formId), fieldName);
	}
	
	public String getDataFromFormV2(long formId, String fieldName) {
		return getDataFromFormV2(String.valueOf(formId), fieldName);
	}
	public String getDataFromJustSubmittedFormV2(String fieldId){
		return getDataFromFormV2(JUST_SUBMITTED_FORM_DATA, fieldId);
	}
	public String getDataFromFormV2(String formId, String fieldId) {
		JSONObject form = formsData.getJSONObject(formId);
		String value = StringPool.BLANK;

		if (Validator.isNotNull(form)) {
			value = getDataFromFormV2(form, fieldId);
		}else if(!JUST_SUBMITTED_FORM_DATA.equals(formId)){
			// pull the form data from form builder
			try {
				form = fetchFormData(GetterUtil.getLong(formId));
			} catch (Exception e) {
				_log.error(e);
			}
			if (Validator.isNotNull(form)) {
				// fetch the value corresponding to requested field
				value = getDataFromFormV2(form, fieldId);	
			}
		}
		return value;
	}
	
	private static String getDataFromFormV2(JSONObject form, String fieldId) {
		JSONObject content;
		String result = StringPool.BLANK;
		try {
			content = JSONFactoryUtil.createJSONObject(form.getString(FormConstants.KEY_CONTENT));
			result = content.getString(fieldId);
		} catch (Exception e) {
			_log.error(e);
		}
		return result;
	}
	
	private static final Log _log = LogFactoryUtil.getLog(PEFormDataAdapter.class);
}
