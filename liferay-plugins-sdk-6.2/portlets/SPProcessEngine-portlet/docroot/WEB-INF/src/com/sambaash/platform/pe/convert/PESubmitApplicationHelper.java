package com.sambaash.platform.pe.convert;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.sambaash.platform.constant.FormConstants;

public class PESubmitApplicationHelper {
	
	private static final Log _log = LogFactoryUtil.getLog(PESubmitApplicationHelper.class);
	
	public static JSONObject getJsonForTextField(String id, String value){
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		obj.put(FormConstants.KEY_ID, id);
		obj.put(FormConstants.KEY_VALUE, GetterUtil.getString(value));
		return obj;
		
	}
	
	public static JSONObject getJsonForTextArea(String id, String value){
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		obj.put(FormConstants.KEY_ID, id);
		obj.put(FormConstants.KEY_VALUE, GetterUtil.getString(value));
		return obj;
		
	}
	
	public static  JSONObject getJsonForDropdown(String id, String[] values,String text){
		JSONArray list  = JSONFactoryUtil.createJSONArray();

		for (String value : values) {
			JSONObject option = JSONFactoryUtil.createJSONObject();
			option.put(FormConstants.KEY_VALUE, GetterUtil.getString(value));
			option.put(FormConstants.KEY_TEXT, text);
			list.put(option);
		}
		
		JSONObject item = JSONFactoryUtil.createJSONObject();
		item.put(FormConstants.KEY_ID, id);
		item.put(FormConstants.KEY_OPTION_LIST, list);

		return item;
	}
	
	public static JSONObject getJsonForCheckboxUsingJsonArrayStr(String id, String jsonString){
		JSONArray list;
		try {
			 list  = JSONFactoryUtil.createJSONArray(jsonString);
		} catch (JSONException e) {
			list = JSONFactoryUtil.createJSONArray();
			_log.error(e);
		}
		
		JSONObject item = JSONFactoryUtil.createJSONObject();
		item.put(FormConstants.KEY_ID, id);
		item.put(FormConstants.KEY_OPTIONS, list);
		
		return item;
		
	}
	public static JSONObject getJsonForCheckboxUsingSimpleStr(String id, String simpleStr){
		JSONObject valueObj = JSONFactoryUtil.createJSONObject();
		valueObj.put(FormConstants.KEY_VALUE, simpleStr);

		JSONArray valueArray = JSONFactoryUtil.createJSONArray();
		valueArray.put(valueObj);
		
		JSONObject item = JSONFactoryUtil.createJSONObject();
		item.put(FormConstants.KEY_ID, id);
		item.put(FormConstants.KEY_OPTIONS, valueArray);
		
		return item;
		
	}
	public static JSONObject getJsonForCheckbox(String id, String[] values){
		JSONArray list  = JSONFactoryUtil.createJSONArray();
		
		for (String value : values) {
			JSONObject option = JSONFactoryUtil.createJSONObject();
			option.put(FormConstants.KEY_VALUE, GetterUtil.getString(value));
			list.put(option);
		}
		
		JSONObject item = JSONFactoryUtil.createJSONObject();
		item.put(FormConstants.KEY_ID, id);
		item.put(FormConstants.KEY_OPTIONS, list);
		
		return item;
	}
	public static JSONObject getJsonForInputFile(String id, String value){
		JSONArray list  = JSONFactoryUtil.createJSONArray();

		JSONObject option = JSONFactoryUtil.createJSONObject();
		option.put(FormConstants.KEY_VALUE, value);
		list.put(option);
		
		JSONObject item = JSONFactoryUtil.createJSONObject();
		item.put(FormConstants.KEY_ID, id);
		item.put(FormConstants.KEY_ATTACHMENTS, list);
		
		return item;
	}
	public static JSONObject getJsonForInputFiles(String id, String[] values){
		JSONArray list  = JSONFactoryUtil.createJSONArray();
		
		for (String value : values) {
			JSONObject option = JSONFactoryUtil.createJSONObject();
			option.put(FormConstants.KEY_VALUE, value);
			list.put(option);
		}
		
		JSONObject item = JSONFactoryUtil.createJSONObject();
		item.put(FormConstants.KEY_ID, id);
		item.put(FormConstants.KEY_ATTACHMENTS, list);
		
		return item;
	}
	
}
