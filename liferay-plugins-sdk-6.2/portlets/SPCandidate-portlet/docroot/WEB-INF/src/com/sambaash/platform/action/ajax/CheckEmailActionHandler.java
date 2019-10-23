package com.sambaash.platform.action.ajax;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.calendar.model.Calendar;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;


public class CheckEmailActionHandler implements ServeResourceActionHandler {

	private Log log = LogFactoryUtil.getLog(CheckEmailActionHandler.class.getName());
	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		String output = "";
		String emailAddress = request.getParameter("emailId");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		JSONObject responseJson = JSONFactoryUtil.createJSONObject();
		Long companyId = CompanyThreadLocal.getCompanyId();
		try {
			User user = UserLocalServiceUtil.fetchUserByEmailAddress(companyId, emailAddress);
			ServiceContext serviceContext = new ServiceContext();
			String password = "hello9876";
			if(user == null){
				user = UserServiceUtil.addUser(companyId, false, // auto
						password, password, true, // auto
						StringPool.BLANK, // screen name
						emailAddress, Long.valueOf(0), // facebookId
						StringPool.BLANK, // open id
						LocaleUtil.getDefault(),firstName,StringPool.BLANK, lastName, // middle
						0, // prefix id
						0, // suffix id
						true, 1, 1, 1970, // birthdate
						StringPool.BLANK, // job title
						null, // group ids
						null, // organization ids
						null, // role ids
						null, // usegroup ids
						false, // send email
						serviceContext);
				
				user.setStatus(0);
				user.setEmailAddressVerified(false);
				user.setPassword(password);
				user.setPasswordEncrypted(false);
				user.setPasswordReset(true);
				UserLocalServiceUtil.updateUser(user);
				responseJson.put("userId", user.getUserId());
				responseJson.put("status", "New Email");
				
			}else{
				responseJson.put("userId", user.getUserId());
				responseJson.put("status", "Email Exists");
			}
			response.getWriter().write(responseJson.toString());
			
		} catch (SystemException | IOException | PortalException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
		
//		if(request.getParameter("emailId").isEmpty() || request.getParameter("formStorageId").equals("0")){
//			output = SystemLocalServiceUtil.createRecord(request, response);
//		}else{
//			output = SystemLocalServiceUtil.updateRecord(request, response);
//		}
//		try {
//			response.getWriter().write(output);
//		} catch (IOException e) {
//			log.error(e);
//		}
		
	}

}
