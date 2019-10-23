package com.sambaash.gu.msg;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.sambaash.platform.srv.genericuploader.model.GUUploadLog;

/** 
 * 
 * REMEMBER this class caches errors and msgs..
 * 
 * @author nareshchebolu
 *
 */
public class GUMsgHelper {

	private final GUUploadLog uploadLog;
	JSONArray errors = null;
	JSONArray msgs = null;
	
	public GUMsgHelper(GUUploadLog uploadLog){
		this.uploadLog = uploadLog;
		try {
			errors = JSONFactoryUtil.createJSONArray(uploadLog.getErrors());
			msgs = JSONFactoryUtil.createJSONArray(uploadLog.getMsgs());
		} catch (JSONException e) {
			errors = JSONFactoryUtil.createJSONArray();
			msgs = JSONFactoryUtil.createJSONArray();
		}
	}
	
	private void handleError(JSONObject error){
		errors.put(error);
		uploadLog.setErrorCount(uploadLog.getErrorCount() + 1);
		uploadLog.setErrors(errors.toString());
	}
	
	public void createError(String msg){
		JSONObject error = GUMsgFactory.createMsg(msg);
		handleError(error);
	}
	public void createError(String msg, String sheetName){
		JSONObject error = GUMsgFactory.createMsg(msg, sheetName);
		handleError(error);
		
	}
	public void createError(String msg, String sheetName, int rowNo){
		JSONObject error = GUMsgFactory.createMsg(msg, sheetName,rowNo);
		handleError(error);
		
	}
	public void createError(String msg, String sheetName, int rowNo, String clmnName){
		JSONObject error = GUMsgFactory.createMsg(msg, sheetName,rowNo, clmnName);
		handleError(error);
	}
	
	private void handleMsg(JSONObject msgJ){
		msgs.put(msgJ);
		uploadLog.setMsgs(msgs.toString());
	}
	
	public void createMsg(String msg){
		JSONObject error = GUMsgFactory.createMsg(msg);
		handleMsg(error);
	}
	public void createMsg(String msg, String sheetName){
		JSONObject msgJ = GUMsgFactory.createMsg(msg,sheetName);
		handleMsg(msgJ);
		
	}
	public void createMsg(String msg, String sheetName, int rowNo){
		JSONObject msgJ = GUMsgFactory.createMsg(msg,sheetName,rowNo);
		handleMsg(msgJ);
		
	}
	public void createMsg(String msg, String sheetName, int rowNo, String clmnName){
		JSONObject msgJ = GUMsgFactory.createMsg(msg,sheetName,rowNo,clmnName);
		handleMsg(msgJ);
	}
	
	
}
