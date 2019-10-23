package com.sambaash.platform.pe.adapter;

import java.util.Map;

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
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;

public class PEProcessStateDataAdapter {

	private PEProcessState processState ;
	private JSONObject dataJson;
	
	private PEProcessStateDataAdapter(PEProcessState processState){
		this.processState = processState;
		prepareJson(processState.getData());
	}
	
	private void prepareJson(String dataStr){
		try {
			dataJson= Validator.isNotNull(dataStr) ? JSONFactoryUtil.createJSONObject(dataStr): JSONFactoryUtil.createJSONObject();
		} catch (JSONException e) {
			_log.error("Error while parsing processstate data to jsonformat" + e);
			dataJson = JSONFactoryUtil.createJSONObject();
		}
	}
	
	public void refreshProcessStateData(String data){
		prepareJson(data);
	}

	public static PEProcessStateDataAdapter getProcessStateDataAdapter(PEProcessState processState){
		return new PEProcessStateDataAdapter(processState);
	}
	
	public String getDataFromProcessState(String fieldName) {
		return getDataFromProcessState(fieldName,false);
	}
	/**
	 *  Returns the display text.
	 *  If mulitple values exist,then text of first value is returned.
	 * @param fieldName
	 * @return
	 */
	public String getSimpleDisplayText(String fieldName){
		String str = getDataFromProcessState(fieldName);
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
	/**
	 *  Returns the value.
	 *  If multiple values exists, then first value will be returned
	 *  
	 * @param fieldName
	 * @return
	 */
	public String getSimpleValue(String fieldName){
		String str = getDataFromProcessState(fieldName);
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
	// in case field value is json array, use this method
	public JSONArray getDataJsonArray(String fieldName){
		JSONObject dataTemp;
		JSONArray array;
		try {
			// create new objeect from process state data, because here the return value is object type.
			// whoever calls this method can modify the array returned which should not affect the actual process state data.
			dataTemp= JSONFactoryUtil.createJSONObject(processState.getData());
			array = dataTemp.getJSONArray(fieldName);
		} catch (JSONException e) {
			_log.error("Error while parsing processstate data to jsonformat" + e);
			array = JSONFactoryUtil.createJSONArray();
		} 
		return array;
	}
	// Get the attachment filename
	public String getAttachedFileName(String fieldName){
		String fileName  = StringPool.BLANK;
		try {
			JSONArray array = JSONFactoryUtil.createJSONArray(this.dataJson.getString(fieldName));//getDataJsonArray(fieldName);
			 if(array!= null && array.length() > 0){
				JSONObject obj = array.getJSONObject(0);
				fileName = obj.getString(FormConstants.KEY_VALUE);
			}
		} catch (Exception e) {
			_log.error("Error while determing whether file exists or not ",e);
		}
		
		return fileName;
	}
	
	// check if attachment file exists
	public boolean isAttachhmentExists(String fieldName){
		String fileName = getAttachedFileName(fieldName);
		if(fileName.length() > 0){
			return true;
		}
		return false;
	}
	
	// if refresh flag is true, then it will freshly creates jsonobject from processstate data object
	// Send refresh = true, in case if  processstate data object got modified after data adapter creation
	public String getDataFromProcessState(String fieldName,boolean refreshData) {
		if(refreshData){
			prepareJson(processState.getData());
		}
		//this field used by rules engine
		if (PEConstantsGlobal.STATUS.equalsIgnoreCase(fieldName)) {
			return processState.getStatus();
		}

		//this field used by rules engine
		if (PEConstantsGlobal.STATUS_TYPE_ID.equalsIgnoreCase(fieldName)) {
			//TODO: return StatusType corresponding to statustypeid
			return processState.getStatus();
		}

		return GetterUtil.getString(dataJson.getString(fieldName));
	}
	
	public void store(String fieldName,String value){
		if(Validator.isNotNull(fieldName)){
			try {
				if (value.startsWith("{") && value.endsWith("}")) {
					dataJson.put(fieldName, JSONFactoryUtil.createJSONObject(value));
				} else if (value.startsWith("[") && value.endsWith("]")) {
					dataJson.put(fieldName, JSONFactoryUtil.createJSONArray(value));
				} else {
					dataJson.put(fieldName, value);
				}
			} catch (Exception e) {
				dataJson.put(fieldName, value);
			}
			processState.setData(dataJson.toString());
		}
	}
	public void store(Map<String,String>dataMap) throws JSONException{
		for (Map.Entry<String, String> entry : dataMap.entrySet()) {
			if(Validator.isNotNull(entry.getKey())){
				dataJson.put(entry.getKey(), entry.getValue());
			}
		}
		processState.setData(dataJson.toString());
	}
	
	private static final Log _log = LogFactoryUtil.getLog(PEProcessStateDataAdapter.class);
}
