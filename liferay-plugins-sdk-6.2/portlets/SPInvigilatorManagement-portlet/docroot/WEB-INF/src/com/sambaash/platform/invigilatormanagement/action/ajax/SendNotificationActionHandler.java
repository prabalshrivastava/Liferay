package com.sambaash.platform.invigilatormanagement.action.ajax;

import java.awt.AWTKeyStroke;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.lang3.time.DateUtils;

import com.liferay.mail.model.FileAttachment;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.constant.SystemSetupConstants;
import com.sambaash.platform.invigilatormanagement.notification.InvigilatorNotificationHandler;
import com.sambaash.platform.invigilatormanagement.service.InvigilatorLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

public class SendNotificationActionHandler implements ServeResourceActionHandler {

	private Log log = LogFactoryUtil.getLog(SendNotificationActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		System.out.println("Called SendNotificationActionHandler" );
		InvigilatorLocalServiceUtil.updateAppointmentStatus(request,response);
		System.out.println("Called updateAppointmentStatus" );
		//sendEmail(request);
		
		//sendNotification(request);
		
		
		try {
			response.getWriter().write("Notified");
		} catch (IOException e) {
			log.error(e.toString());
		}
	}

	private void sendEmail(ResourceRequest request) {
		User loggedInUser = (User) request.getAttribute(WebKeys.USER);
		String output = "";// formType
		User user;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
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
	
			String mailTemplateIdParameter = "template.id.appointment.created.notification";
	
			mailMessage = SPMailTemplateLocalServiceUtil.getMailMessage(mailTemplateIdParameter,
					serviceContext.getScopeGroupId(), true);
	
			if (mailMessage != null) {
				subject = mailMessage.getSubject();
				body = mailMessage.getHtmlBody();
			}
			
			
			JSONObject appointDateObj = dataObj.getJSONObject("appointData");
			JSONObject scheduleData = dataObj.getJSONObject("scheduleData").getJSONObject("contentJson");
			JSONObject briefingScheduleData = dataObj.getJSONObject("briefingScheduleData").getJSONObject("contentJson");
			String sessionType = scheduleData.getString("SessionType");
			HashMap<String,JSONObject> priceSchemesMap = new HashMap<String,JSONObject>();
			String priceSchemes = dataObj.getString("priceSchemes");
			JSONArray priceSchemesArr = JSONFactoryUtil.createJSONArray(priceSchemes);
			JSONArray keys = appointDateObj.names ();
			
			JSONObject priceScheme = JSONFactoryUtil.createJSONObject();
			JSONArray subSchemeDetails = JSONFactoryUtil.createJSONArray();
			HashMap<String,JSONObject> subPriceSchemesMap = new HashMap<String,JSONObject>();
			if(priceSchemesArr.length() > 0){
				for(int i=0; i < priceSchemesArr.length(); i++){
	            	
	            	priceSchemesMap.put(priceSchemesArr.getJSONObject(i).getString("PricingType"), priceSchemesArr.getJSONObject(i));
	            }
				
				String subPriceSchemes = dataObj.getString("subPriceSchemes");
				JSONArray subPriceSchemesArr = JSONFactoryUtil.createJSONArray(subPriceSchemes);
				for(int i=0; i < subPriceSchemesArr.length(); i++){
	            	
					subPriceSchemesMap.put(subPriceSchemesArr.getJSONObject(i).getString("SubPriceSchemeCode"), subPriceSchemesArr.getJSONObject(i));
	            }
				
				if(priceSchemesMap.containsKey("BriefingRate")){
			    	priceScheme = priceSchemesMap.get("BriefingRate");
			    }
				subSchemeDetails = priceScheme.getJSONArray("SubSchemeDetails");
				if(priceSchemesMap.containsKey("SessionRate") || priceSchemesMap.containsKey("DayRate")){
			    	if(sessionType.equalsIgnoreCase("Full Day")){
			    		priceScheme = priceSchemesMap.get("DayRate");
			    	}else {
			    		priceScheme = priceSchemesMap.get("SessionRate");
			    	}
			    }
			}else{
				log.error("No Price Scheme Linked to this Schedule");
			}
			
			
			for (int i = 0; i < keys.length (); ++i) {
				JSONObject subPriceScheme = JSONFactoryUtil.createJSONObject();
			    String key = keys.getString (i); // Here's your key
			    log.debug("appointDateObj " + appointDateObj);
			    
			    JSONArray value = appointDateObj.getJSONArray(key); // Here's your value
			    
			    //value.getJSONObject(0).getString("EmailAddress")   biswojit.mohapatra@sambaash.com
			    user = UserLocalServiceUtil.getUserByEmailAddress(companyId,value.getJSONObject(0).getString("EmailAddress"));
			    String toName = user.getFullName();
				String toAddress = user.getEmailAddress();
			    JSONObject invigilatorDetail = dataObj.getJSONObject("appointData").getJSONArray(key).getJSONObject(0);
			    
			    String amount = "0";
			    String briefingAmount = "0";
			    String briefingFees = "";
			    String fees = "";
			    String examSchedule = "";
			    
			    if(subSchemeDetails.length() > 0){
				    for(int j = 0; j < subSchemeDetails.length();j++){
				    	String priceSubSchemeId = subSchemeDetails.getJSONObject(j).getString("priceSubSchemeId");
				    	if(subPriceSchemesMap.containsKey(priceSubSchemeId)){
					    	subPriceScheme = subPriceSchemesMap.get(priceSubSchemeId);
					    	if(subPriceScheme.getString("PriceType").equals("BriefingRate")){
					    		if(subPriceScheme.getString("PriceSubType").equals(value.getJSONObject(0).getString("AppointType"))){
					    			briefingAmount = subSchemeDetails.getJSONObject(j).getString("amount");
					    			briefingFees += "<tr>"+subPriceScheme.getString("PriceSubType")+"<td >"+briefingAmount+"</td><td>"+subPriceScheme.getString("PriceType")+"</td></tr>";
					    		}
					    	}
					    }
				    }
			    }
			    
			    
			    
			    for(int k = 0; k < value.length();k++){
				    for(int j = 0; j < subSchemeDetails.length();j++){
				    	String priceSubSchemeId = subSchemeDetails.getJSONObject(j).getString("priceSubSchemeId");
				    	if(subPriceSchemesMap.containsKey(priceSubSchemeId)){
					    	subPriceScheme = subPriceSchemesMap.get(priceSubSchemeId);
				    		if(subPriceScheme.getString("PriceType").equals(priceScheme.getString("PricingType"))){
					    		if(subPriceScheme.getString("PriceSubType").equals(value.getJSONObject(k).getString("AppointType"))){
					    			amount = subSchemeDetails.getJSONObject(j).getString("amount");
					    			fees += "<tr><td style='border: 1px solid;'>"+subPriceScheme.getString("PriceSubType")+"</td><td style='border: 1px solid;'>"+amount+"</td><td style='border: 1px solid;'>"+subPriceScheme.getString("PriceType")+"</td></tr>";
					    		}
					    	}	
					    }
				    	
				    }
				    examSchedule += "<tr><td style='border: 1px solid;'>"+value.getJSONObject(k).getString("Date")+"</td><td style='border: 1px solid;'>"+value.getJSONObject(k).getString("Session")+
	    					"</td><td style='border: 1px solid;'>"+ value.getJSONObject(k).getString("AppointType") +"</td><td style='border: 1px solid;'>"+value.getJSONObject(k).getString("ReportingTime")+
	    					"</td><td style='border: 1px solid;'>"+scheduleData.getString("EndTime")+"</td><td style='border: 1px solid;'>"+dataObj.getString("leadName")+
	    					"</td><td style='border: 1px solid;'>"+value.getJSONObject(k).getString("FacilityName")+"</td></tr>";
			    }
			    fees += "";
			    
			    body = body.replace("[$Schedule$]", scheduleData.getString("Name"));
			    body = body.replace("[$InvigilatorID$]", invigilatorDetail.getString("InvigilatorGenID"));
			    String pattern = "dd-MMM-yyyy";
			    SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern);
			    String date = simpleDateFormat.format(new Date());
			    body = body.replace("[$CurrentDate$]",date);
			    body = body.replace("[$InvigilatorFullName$]", toName);
			    body = body.replace("[$House/BlockNo$]", invigilatorDetail.getString("HouseBlockNo"));
			    body = body.replace("[$StreetName$]", invigilatorDetail.getString("StreetName"));
			    body = body.replace("[$UnitNo$]", invigilatorDetail.getString("UnitNo"));
			    body = body.replace("[$BuildingName$]", invigilatorDetail.getString("BuildingName"));
			    body = body.replace("[$Country$]", invigilatorDetail.getString("Country"));
			    body = body.replace("[$PostalCode$]", invigilatorDetail.getString("PostalCode"));
			    body = body.replace("[$Salutation$]", invigilatorDetail.getString("Salutation"));
			    body = body.replace("[$ExamBody$]", "UOL");
			    
			    String portalURLpref = request.getPreferences().getValue(SystemSetupConstants.PREF_BASE_URL, "");
			    body = body.replace("[$PortalURL$]", portalURLpref);
			    
			    body = body.replace("[$BriefingPaymentRate$]", briefingAmount);
			    body = body.replace("[$BriefingPricingType$]", "BriefingRate");
			    
			    String briefingStartDate = "";
			    String briefingStartTime = "";
			    String briefingEndTime = "";
			    DateFormat sdf = new SimpleDateFormat("hh:mm");
			    Date briefingReportTime = null;
			    if(briefingScheduleData !=null){
			    	briefingStartDate = briefingScheduleData.getString("StartDate");
			    	briefingStartTime = briefingScheduleData.getString("StartTime");
			    	briefingEndTime	= briefingScheduleData.getString("EndTime");
			    	try {
						Date startTime = sdf.parse(briefingScheduleData.getString("StartTime"));
						briefingReportTime = DateUtils.addMinutes(startTime, (-1 )* briefingScheduleData.getInt("MinBeforeScheduleStart")); //add minute
					} catch (Exception e) {
						log.error(e.toString());
					}
			    }
			    
			    body = body.replace("[$BriefingScheduleDate$]", briefingStartDate);
			    body = body.replace("[$BriefingSchedulefromtime$]", briefingStartTime);
			    body = body.replace("[$Scheduletotime$]", briefingEndTime);
			    
			    
			    
			    if(briefingReportTime != null){
			    	body = body.replace("[$BriefingReportingTime$]",sdf.format(briefingReportTime));
			    }else{
			    	body = body.replace("[$BriefingReportingTime$]","");
			    }
			    body = body.replace("[$BriefingSubFacility$]", invigilatorDetail.getString("SUBFacilityName"));
			    body = body.replace("[$BriefingAddress$]", invigilatorDetail.getString("FacilityName"));
			    
			    body = body.replace("[$InvigilationFees$]", fees);
			    
			    body = body.replace("[$AcceptanceDeadline$]", dataObj.getString("deadlineDate"));
			    
			    body = body.replace("[$Session$]", dataObj.getString("Session"));
			    body = body.replace("[$ReportingStartTime$]", scheduleData.getString("StartTime"));
			    body = body.replace("[$EstimateEndTime$]", scheduleData.getString("EndTime"));
			    body = body.replace("[$LeadName$]", dataObj.getString("leadName"));
			    body = body.replace("[$FacilityName$]", invigilatorDetail.getString("FacilityName"));
			    
			    
			    body = body.replace("[$ExamSchedule$]", examSchedule);
			   
			    body = body.replace("[$FROM$]", fromName);
			    String ccAddress = loggedInUser.getEmailAddress();
			    
				mailMessage.setFromAddress(fromAddress);
				mailMessage.setFromName(fromName);
				mailMessage.setToAddress(toAddress);
				mailMessage.setCcAddress(ccAddress);
				mailMessage.setHtmlBody(body);
				
				List<FileAttachment> fileAttachments = new ArrayList<FileAttachment>();
				FileAttachment arg0 = new FileAttachment();
				URL u;

				File file = null;
				try {
					u = new URL("https://s3-ap-southeast-1.amazonaws.com/wattabyte.sambaash/local//examSchedule/SCH-INVIGILATOR-01/ExamSchedule5821019716322292086.pdf");
					InputStream in = u.openStream();
					file = new File("a.pdf");
		            copyInputStreamToFile(in, file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				arg0.setFile(file);
				arg0.setFileName("Schedule.pdf");
				fileAttachments.add(arg0);
				mailMessage.setMultiPart(true);
				mailMessage.setFileAttachments(fileAttachments);

				SPMailLocalServiceUtil.sendMail(mailMessage);
				
				
				String manageAppointmentUrlPref = request.getPreferences().getValue("manageAppointmentUrlPref", "/group/rc/manage-appointment");
				String manageAppointmentAdminUrlPref = request.getPreferences().getValue("manageAppointmentAdminUrlPref", "/update-appointment");
				SystemLocalServiceUtil.addTimelineActivity(manageAppointmentUrlPref
						, "Details",
						"Contract For Service",
				        StringPool.BLANK, StringPool.BLANK, "Completed", themeDisplay.getUserId(), "Invigilation Notification",
				        "Appointment", StringPool.BLANK, StringPool.BLANK, "" + user.getUserId() ,
				        themeDisplay.getScopeGroupId());
				
				
				SystemLocalServiceUtil.addTimelineActivity(manageAppointmentAdminUrlPref
						, "Details",
						"Contract For Service for " + user.getFirstName()+ " " + user.getLastName() ,
				        StringPool.BLANK, StringPool.BLANK, "Completed", themeDisplay.getUserId(), "Invigilation Notification",
				        "Appointment", StringPool.BLANK, StringPool.BLANK, "" + loggedInUser.getUserId() ,
				        themeDisplay.getScopeGroupId());
				
			}
			
		} catch (PortalException e) {
			log.error(e.toString());
		} catch (SystemException e) {
			log.error(e.toString());
		}
		
	}
	private static void copyInputStreamToFile(InputStream inputStream, File file) 
			throws IOException {

	        try (FileOutputStream outputStream = new FileOutputStream(file)) {

	            int read;
	            byte[] bytes = new byte[1024];

	            while ((read = inputStream.read(bytes)) != -1) {
	                outputStream.write(bytes, 0, read);
	            }

				// commons-io
	            //IOUtils.copy(inputStream, outputStream);

	        }

	    }
	private void sendNotification(ResourceRequest request) {
		try {

			List<User> users = UserLocalServiceUtil.getUsers(0,
					UserLocalServiceUtil.getUsersCount());
			ServiceContext serviceContext = ServiceContextFactory
					.getInstance(request);
			String notificationText = "Appointment Notification";
			for (User user : users) {
				JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
				payloadJSON.put("userId", user.getUserId());
				// payloadJSON.put("customEntityId",user.getUserId());
				payloadJSON.put("notificationText", notificationText);
				UserNotificationEventLocalServiceUtil.addUserNotificationEvent(
						user.getUserId(),
						InvigilatorNotificationHandler.PORTLET_ID,
						(new Date()).getTime(), user.getUserId(),
						payloadJSON.toString(), false, serviceContext);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}

	
}
