package com.sambaash.platform.invigilatormanagement.action.ajax;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.invigilatormanagement.service.InvigilatorLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class UpdateAppointmentActionHandler implements ServeResourceActionHandler {

	private Log log = LogFactoryUtil.getLog(UpdateAppointmentActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		String output = "";// formType
		sendUpdateNotification(request);
		output = SystemLocalServiceUtil.updateRecord(request, response);
		try {
			response.getWriter().write(output);
		} catch (IOException e) {
			log.error(e);
		}
	}

	private void sendUpdateNotification(ResourceRequest request) {
		String output = "";// formType
		User user;
		User loggedInUser = (User) request.getAttribute(WebKeys.USER);
		try {
			String data = request.getParameter("data");
			
			JSONObject dataObj = JSONFactoryUtil.createJSONObject(data);
			long companyId = CompanyThreadLocal.getCompanyId();
			user = UserLocalServiceUtil.getUserByEmailAddress(companyId, "alerts@sambaash.com");    // local
			//user = UserLocalServiceUtil.getUser(154297);    // ems.sambaash.com 
			
			String emailAddress = user.getEmailAddress();
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setScopeGroupId(user.getGroupId());
			
			String fromName = PrefsPropsUtil.getString(user.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
			String fromAddress = PrefsPropsUtil.getString(user.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
	
			
	
			String subject = null;
			String body = null;
			com.sambaash.platform.model.MailMessage mailMessage = null;
	
			String mailTemplateIdParameter = "template.id.appointment.updated.notification";
	
			mailMessage = SPMailTemplateLocalServiceUtil.getMailMessage(mailTemplateIdParameter,
					serviceContext.getScopeGroupId(), true);
	
			if (mailMessage != null) {
				subject = mailMessage.getSubject();
				body = mailMessage.getHtmlBody();
			}
			
			
			JSONArray appointDateObj = dataObj.getJSONArray("Appointment");
			
			
			for (int i = 0; i < appointDateObj.length (); ++i) {
			    //appointDateObj.getJSONObject(i).getString("UserId")   biswojit.mohapatra@sambaash.com
				if(!appointDateObj.getJSONObject(i).getString("PrevAppointType").equalsIgnoreCase( appointDateObj.getJSONObject(i).getString("AppointType"))){
				    user = UserLocalServiceUtil.getUserByEmailAddress(companyId,appointDateObj.getJSONObject(i).getString("EmailAddress"));
				    String toName = user.getFullName();
					String toAddress = user.getEmailAddress();
				    String priceResponseStr = InvigilatorLocalServiceUtil.getPriceScheme(request,appointDateObj.getJSONObject(i));
				    JSONObject priceResponse = JSONFactoryUtil.createJSONObject(priceResponseStr);
				    
				    JSONArray priceSchemes = priceResponse.getJSONArray("priceSchemes");
				    JSONArray subPriceSchemes = priceResponse.getJSONArray("subPriceSchemes");
				    HashMap<String,JSONObject> priceSchemesMap = new HashMap<String,JSONObject>();
				    HashMap<String,JSONObject> subPriceSchemesMap = new HashMap<String,JSONObject>();
				    JSONObject priceScheme = JSONFactoryUtil.createJSONObject();
				    for(int j=0; j < priceSchemes.length(); j++){
		            	
		            	priceSchemesMap.put(priceSchemes.getJSONObject(j).getString("PricingType"), priceSchemes.getJSONObject(j));
		            }
				    for(int j=0; j < subPriceSchemes.length(); j++){
		            	
						subPriceSchemesMap.put(subPriceSchemes.getJSONObject(j).getString("SubPriceSchemeCode"), subPriceSchemes.getJSONObject(j));
		            }
				    String sessionType = appointDateObj.getJSONObject(i).getString("Session");
				    if(sessionType.equalsIgnoreCase("Full Day")){
			    		priceScheme = priceSchemesMap.get("DayRate");
			    	}else {
			    		priceScheme = priceSchemesMap.get("SessionRate");
			    	}
				    JSONArray subSchemeDetails = priceScheme.getJSONArray("SubSchemeDetails");
				    String amount = "0";
				    for(int j = 0; j < subSchemeDetails.length();j++){
				    	String priceSubSchemeId = subSchemeDetails.getJSONObject(j).getString("priceSubSchemeId");
				    	if(subPriceSchemesMap.containsKey(priceSubSchemeId)){
				    		JSONObject subPriceScheme = subPriceSchemesMap.get(priceSubSchemeId);
				    		if(subPriceScheme.getString("PriceType").equals(priceScheme.getString("PricingType"))){
					    		if(subPriceScheme.getString("PriceSubType").equals( appointDateObj.getJSONObject(i).getString("AppointType"))){
					    			amount = subSchemeDetails.getJSONObject(j).getString("amount");
					    			//fees += "<tr><td>"+subPriceScheme.getString("PriceSubType")+"</td><td>"+amount+"</td><td></td><td>"+subPriceScheme.getString("PriceType")+"</td></tr>";
					    			
					    		}
					    	}	
					    }
				    }
				    body = body.replace("[$PreviousAppointmentType$]", appointDateObj.getJSONObject(i).getString("PrevAppointType"));
				    body = body.replace("[$NewAppointmentType$]", appointDateObj.getJSONObject(i).getString("AppointType"));
				    body = body.replace("[$CurrentDate$]", new Date().toString());
				    body = body.replace("[$InvigilatorFullName$]", toName);
				    body = body.replace("[$PaymentRate$]", amount);
				   
				    body = body.replace("[$FROM$]", fromName);
				    String ccAddress = loggedInUser.getEmailAddress();
					mailMessage.setFromAddress(fromAddress);
					mailMessage.setFromName(fromName);
					mailMessage.setToAddress(toAddress);
					mailMessage.setCcAddress(toAddress);
					mailMessage.setHtmlBody(body);
					SPMailLocalServiceUtil.sendMail(mailMessage);
				}
	
			}
			
		} catch (PortalException e) {
			 System.out.println("error" + e.toString());
		} catch (SystemException e) {
			System.out.println("error" + e.toString());
		}
		
	}

	
}
