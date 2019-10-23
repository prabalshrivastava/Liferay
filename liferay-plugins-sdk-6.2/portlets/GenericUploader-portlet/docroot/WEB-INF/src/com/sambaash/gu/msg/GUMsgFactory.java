package com.sambaash.gu.msg;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class GUMsgFactory {

	
	
	public static  JSONObject createMsg(String msg){
		JSONObject error = JSONFactoryUtil.createJSONObject();
		error.put("msg", msg);
		return error;
	}
	public static JSONObject createMsg(String msg, String sheetName){
		JSONObject error = JSONFactoryUtil.createJSONObject();
		error.put("msg", msg);
		error.put("sheetName", sheetName);
		return error;
	}
	public static JSONObject createMsg(String msg, String sheetName, int rowNo){
		JSONObject error = JSONFactoryUtil.createJSONObject();
		error.put("msg", msg);
		error.put("sheetName", sheetName);
		error.put("rowNo", rowNo);
		return error;
		
	}
	public static JSONObject createMsg(String msg, String sheetName, int rowNo, String clmnName){
		JSONObject error = JSONFactoryUtil.createJSONObject();
		error.put("msg", msg);
		error.put("sheetName", sheetName);
		error.put("rowNo", rowNo);
		error.put("clmnName", clmnName);
		return error;
	}
	
}
