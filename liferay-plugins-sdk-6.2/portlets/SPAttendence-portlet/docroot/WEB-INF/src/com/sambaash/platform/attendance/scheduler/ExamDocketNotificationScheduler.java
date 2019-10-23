package com.sambaash.platform.attendance.scheduler;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.sambaash.platform.attendance.ajax.SendExamDocketNotificationHandler;
import com.sambaash.platform.attendance.service.SPAttendenceLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.util.SambaashUtil;

public class ExamDocketNotificationScheduler implements MessageListener{
	private static final Log _log = LogFactoryUtil.getLog(ExamDocketNotificationScheduler.class);
	private static final String  PRODUCT_TYPE = "exam";
	private static final String PRODUCT_SUBTYPE = "sac";
	private static final String FUNCTIONAL_COMPONENT = "finance";
	private static final String CATEGORY_TYPE = "invoice";
	private static final String CLIENT_TYPE = "Individual";
	private static final long SITEID = 21424;
	private static final long USERID = 1;


	public void receive(Message message)throws MessageListenerException{
		
		
		String condition = "seatingPlanInstanceId!=''";
		String modelData = SPAttendenceLocalServiceUtil.fetchExamDocketUserListing(USERID, SITEID ,condition);
		
		try{
			JSONObject responseJsonModelData = JSONFactoryUtil.createJSONObject(modelData);
			JSONArray jsonUserExamArray = responseJsonModelData.getJSONArray("content");

			Set<String> userSet = new HashSet<>();
			if(jsonUserExamArray.length()>0){

				for(int i=0;i<jsonUserExamArray.length();i++){
					JSONObject jObject = jsonUserExamArray.getJSONObject(i);
					String uId = jObject.getJSONObject("contentJson").getString("userId");
					userSet.add(uId);
				}
				for(String user : userSet){
					
					condition = "seatingPlanInstanceId!=''&contentJson.userId="+user;

					String userModelData = SPAttendenceLocalServiceUtil.fetchExamDocketUserListing(USERID, SITEID , condition);
					JSONObject responseUserJsonModelData = JSONFactoryUtil.createJSONObject(userModelData);
					String examDocketNumber =  SPAttendenceLocalServiceUtil.generateReferenceNumber(SITEID, PRODUCT_TYPE, PRODUCT_SUBTYPE, FUNCTIONAL_COMPONENT, CATEGORY_TYPE, CLIENT_TYPE);
					JSONArray userExamJsonArray = responseUserJsonModelData.getJSONArray("content");
					JSONObject jObject = userExamJsonArray.getJSONObject(0);
					JSONObject userJsonObj = jObject.getJSONObject("userId");
					JSONObject userContentJsonObj = userJsonObj.getJSONObject("contentJson");
					String toEmailAddress = userContentJsonObj.getString("PrimaryEmailAddress");
					
					File examDocketPDF = SendExamDocketNotificationHandler.prepareExamDocketFile(userExamJsonArray,examDocketNumber);
					SendExamDocketNotificationHandler.sendExamDocketEmail(toEmailAddress, examDocketPDF);

				}

			}
		}catch(Exception e)	{
			_log.error(e);
		}
	}
}