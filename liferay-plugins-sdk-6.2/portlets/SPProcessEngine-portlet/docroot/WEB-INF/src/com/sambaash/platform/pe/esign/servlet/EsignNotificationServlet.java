package com.sambaash.platform.pe.esign.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.course.enroll.CourseEnrollEsignHelper;
import com.sambaash.platform.srv.processbuilder.service.PEEngineLocalServiceUtil;

/**
 * It's callback servlet and is being called by esignlive api (External system). 
 * When contract signing is completed, notification will be received to this servlet from esignlive.
 * 
 * This servlet upon receiving successful response triggers the process engine.
 * 
 * Call to this servlet is configured in esignlive account settings page. 
 * 
 * @author nareshchebolu
 *
 */
public class EsignNotificationServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	private static Log _log = LogFactoryUtil.getLog(EsignNotificationServlet.class);
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		_log.info("In EsignNotificationServlet service method ");
		String key = ParamUtil.getString(request, PEConstants.PARAM_TEST_KEY);
		
		if(CourseEnrollEsignHelper.getServletTestKey().equalsIgnoreCase(key)){
			_log.info("Test key is ok");
			process(request);
		}else{
			
			_log.error("Test key test failed");
		}
		
	}
	
	private void process(HttpServletRequest request){
		// response sent by esignlive system. 
		// Please refer this link for list of events
		//http://docs.e-signlive.com/doku.php?id=esl:e-signlive_guide_event-notification&_ga=1.191833450.1988127657.1479368397#events
		JSONObject response = getResponseJson(request);
		
		if(response == null){
			_log.error("Can not proceed as Response from esinglive is not correct");
			return;
		}
		
		String name = response.getString("name");
		
		_log.debug("ESignLive Event Notification Type : "+name);
		
		if("PACKAGE_COMPLETE".equalsIgnoreCase(name)){
			String packageId = response.getString("packageId");
			try {
				PEEngineLocalServiceUtil.runProcessEngineUsingEsignPackagId(packageId);
				
			} catch (Exception e) {
				_log.error(e);
			}
		}
	}
	
	private JSONObject getResponseJson(HttpServletRequest request) {
		StringBuilder jb = new StringBuilder();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null){
				jb.append(line);
			}
		} catch (Exception e) {
			_log.error(e);
		}

		_log.debug("Response String from EsignLive " + jb.toString());
		
		try {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jb
					.toString());
			return jsonObject;
		} catch (Exception e) {
			_log.error("Unable to create json object from response string " + jb.toString(),e);
		}
		return null;
	}
}
