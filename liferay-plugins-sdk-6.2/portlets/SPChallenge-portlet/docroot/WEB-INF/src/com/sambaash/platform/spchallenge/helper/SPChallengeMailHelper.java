package com.sambaash.platform.spchallenge.helper;

import javax.portlet.PortletConfig;
import javax.portlet.ResourceRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.spchallenge.model.SPChallenge;
import com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant;
import com.sambaash.platform.srv.spchallenge.service.SPChallengeLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.util.LabelUtil;
import com.sambaash.platform.util.SambaashUtil;

public class SPChallengeMailHelper {

	public static void sendMailForApplicationResponse(Document applicationDoc,ThemeDisplay themeDisplay, ResourceRequest resourceRequest) throws Exception{
		logger.debug("In sendMailForApplicationResponse applicant = " + applicationDoc.get(SPChallengeConstants.CHALLENGE_APPLICANT_ID));
		boolean alertsEnabled = mailAlertsEnable();
		logger.debug("Mail Alerts Enabled " + alertsEnabled);
		if(alertsEnabled){
			logger.debug("Alerts are enabled. Mail preparation started ");
			try {
				int applicationStatus = Integer.parseInt(applicationDoc.get(SPChallengeConstants.APPLICATION_STATUS));
				SPMailTemplate mailTemplate = getApplicationResponseMailTemplate(applicationStatus);
				String subject = StringPool.BLANK;
				String body = StringPool.BLANK;
				if(Validator.isNotNull(mailTemplate)){
					subject = mailTemplate.getSubject();
					body = mailTemplate.getHtmlContent();
				}
				if(Validator.isNull(subject)){
					subject = getApplicationResponseDefaultSubject(applicationStatus,themeDisplay,resourceRequest);
				}
				if(Validator.isNull(body)){
					body = getApplicationDefaultMailBody(applicationStatus);
				}
				MailMessage mailMessage = new MailMessage();
				mailMessage.setSubject(subject);
				mailMessage.setFromAddress(getFromEmail());
				mailMessage.setFromName(getFromName());
				String orgEmailAddress = applicationDoc.get(SPChallengeConstants.ORGANIZATION_OWNER);
				mailMessage.setToAddress(orgEmailAddress);
				User user = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(), orgEmailAddress);
				body = formatApplicationTemplate(body, user.getFirstName(), applicationDoc.get(SPChallengeConstants.CHALLENGE_NAME));
				mailMessage.setHtmlBody(body);
				mailMessage.setHtmlFormat(true);
				logger.debug("Sending mail to " + applicationDoc.get(SPChallengeConstants.ORGANIZATION_NAME) +" Mail = " + mailMessage);
				SPMailLocalServiceUtil.sendMail(mailMessage);
			} catch (Exception e) {
				logger.error("Error while sending mail to applicant " + e.getMessage());
			}
		
		}
	}	
	
	public static void sendMailToApplicant(SPChallengeApplicant applicant,ThemeDisplay themeDisplay, ResourceRequest resourceRequest) throws Exception{
		logger.debug("In sendMailToApplicant applicant = " + applicant);
		SPChallenge challenge = null;
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		String mailSubject = LabelUtil.getLabel(portletConfig,themeDisplay,"label.application.received");
		if(Validator.isNull(applicant)){
			logger.error("Applicant is null");
			throw new  IllegalArgumentException("Applicant is null");
		}
		try {
			challenge = SPChallengeLocalServiceUtil.getSPChallenge(applicant.getSpChallengeId());
		} catch (Exception e1) {
			logger.error("Error while getting challenge, challenge id " + applicant.getSpChallengeId());
			throw e1;
		}
		boolean alertsEnabled = mailAlertsEnable();
		logger.debug("Mail Alerts Enabled " + alertsEnabled);
		if(alertsEnabled){
			logger.debug("Alerts are enabled. Mail preparation started ");
			try {
				SPMailTemplate mailTemplate = getApplicantMailTemplate();
				String subject = StringPool.BLANK;
				String body = StringPool.BLANK;
				if(Validator.isNotNull(mailTemplate)){
					subject = mailTemplate.getSubject();
					body = mailTemplate.getHtmlContent();
				}
				if(Validator.isNull(subject)){
					subject = getApplicantDefaultSubject(mailSubject);
				}
				if(Validator.isNull(body)){
					body = getApplicantDefaultMailBody();
				}
				MailMessage mailMessage = new MailMessage();
				mailMessage.setSubject(subject);
				mailMessage.setFromAddress(getFromEmail());
				mailMessage.setFromName(getFromName());
				User user = UserLocalServiceUtil.getUser(applicant.getUserId());
				mailMessage.setToAddress(user.getEmailAddress());
				String challengeDetailUrl = themeDisplay.getPortalURL()
						+ SPChallengeHelper
								.displayChallengeFriendlyURL(
										themeDisplay,
										challenge.getSpChallengeId(),
										StringPool.DASH);
				String applicationDetailUrl = themeDisplay.getPortalURL()
						+ SPChallengeHelper.displayApplicationFriendlyURL(
								themeDisplay,
								applicant.getSpChallengeApplicantId());
				body = formatApplicantTemplate(body, user.getFirstName(), challenge.getName(),challengeDetailUrl, applicationDetailUrl);
				mailMessage.setHtmlBody(body);
				mailMessage.setHtmlFormat(true);
				//mailMessage.setBccAddress("naresh.chebolu@sambaash.com");;
				logger.debug("Sending mail to " + applicant.getUserId() +" Mail = " + mailMessage);
				SPMailLocalServiceUtil.sendMail(mailMessage);
			} catch (Exception e) {
				logger.error("Error while sending mail to applicant " + e.getMessage());
			}
		
		}
	}
	public static void sendMailToChallengeCreator(SPChallengeApplicant applicant,ThemeDisplay themeDisplay) throws Exception{

		logger.debug("In sendMailToApplicant applicant = " + applicant);
		boolean alertsEnabled = mailAlertsEnable();
		logger.debug("Mail Alerts Enabled " + alertsEnabled);
		SPChallenge challenge = null;
		if(Validator.isNull(applicant)){
			logger.error("Applicant is null");
			throw new  IllegalArgumentException("Applicant is null");
		}
		try {
			challenge = SPChallengeLocalServiceUtil.getSPChallenge(applicant.getSpChallengeId());
		} catch (Exception e1) {
			logger.error("Error while getting challenge, challenge id " + applicant.getSpChallengeId());
			throw e1;
		}
		if(alertsEnabled){
			logger.debug("Alerts are enabled. Mail preparation started ");
			try {
				long orgId = applicant.getApplicantRefId();
				Organization org = OrganizationLocalServiceUtil.getOrganization(orgId);
				String orgDetailUrl = SPChallengeHelper.displayStartupProfileFriendlyURL(themeDisplay, orgId);
				String challengeDetailUrl = SPChallengeHelper.displayChallengeFriendlyURL(themeDisplay, challenge.getSpChallengeId(), StringPool.DASH);
				String applicationDetailUrl = SPChallengeHelper.displayApplicationFriendlyURL(themeDisplay, applicant.getSpChallengeApplicantId());
				
				SPMailTemplate mailTemplate = geChallengeCreatorMailTemplate();
				String subject = StringPool.BLANK;
				String body = StringPool.BLANK;
				if(Validator.isNotNull(mailTemplate)){
					subject = mailTemplate.getSubject();
					body = mailTemplate.getHtmlContent();
				}
				if(Validator.isNull(subject)){
					 subject = getChallengeCreatorDefaultSubject();
				}
				if(Validator.isNull(body)){
					body = getChallengeCreatorDefaultMailBody();
				}
				subject = formatCreatorSubject(subject, org.getName());
				MailMessage mailMessage = new MailMessage();
				mailMessage.setSubject(subject);
				mailMessage.setFromAddress(getFromEmail());
				mailMessage.setFromName(getFromName());
				mailMessage.setHtmlFormat(true);
				//TODO: get email string 
				String emailStr = challenge.getNotifyTo();
				String []emailIds = emailStr.split(StringPool.SEMICOLON);
				//mailMessage.setBccAddress("naresh.chebolu@sambaash.com");;
				// send mail to creator of the challenge
				try{
					User user = UserLocalServiceUtil.getUser(challenge.getUserId()); 
					mailMessage.setToAddress(user.getEmailAddress());
					SPMailLocalServiceUtil.sendMail(mailMessage);
				}catch(Exception ex){
					logger.error("Error while sending mail to creator of the challenge ");
				}
			
				for(String email:emailIds){
					if(Validator.isNotNull(email)){
						try{
							User notifier = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(), email);
							body = formatCreatorTemplate(body, notifier.getFirstName(), org.getName(), challenge.getName(), orgDetailUrl, applicationDetailUrl, challengeDetailUrl);
							mailMessage.setHtmlBody(body);
							logger.debug("Sending mail to " + email +" Mail = " + mailMessage);
							mailMessage.setToAddress(email);
							SPMailLocalServiceUtil.sendMail(mailMessage);
							
						}catch(Exception ex){
							logger.error("Error while sending mail to  " +email);
						}
					}
				}
				
			} catch (Exception e) {
				logger.error("Error while sending mail  " , e);
			}
		
		}
	}
	
	private static String getFromName(){
		String fromName = StringPool.BLANK ;
		try {
			 fromName = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_NAME);
		} catch (Exception e) {
			logger.error("Error while getting fromName");
		}
		if(Validator.isNull(fromName)){
			// TODO: fill fromName
			fromName = "";
		}
		
		return fromName;
	}
	private static String getFromEmail(){
		String fromAddress = StringPool.BLANK ;
		try {
			fromAddress = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
		} catch (Exception e) {
			logger.error("Error while getting fromAddress");
		}
		if(Validator.isNull(fromAddress)){
			// TODO: fill fromAddress
			fromAddress = "";
		}
		
		return fromAddress;
	}
	
	private static SPMailTemplate getApplicationResponseMailTemplate(int applicationStatus) {
		String paramName = applicationStatus == SPChallengeConstants.APPLICATION_ACCEPTED
				? SambaashConstants.MAIL_TEMPLATE_ID_CHALLENGE_APPLICANT_ACCEPTED
				: SambaashConstants.MAIL_TEMPLATE_ID_CHALLENGE_APPLICANT_REJECTED;
		switch (applicationStatus) {
		case SPChallengeConstants.APPLICATION_ACCEPTED:
			paramName = SambaashConstants.MAIL_TEMPLATE_ID_CHALLENGE_APPLICANT_ACCEPTED;
			break;
		case SPChallengeConstants.APPLICATION_REJECTED:
			paramName = SambaashConstants.MAIL_TEMPLATE_ID_CHALLENGE_APPLICANT_REJECTED;
			break;
		case SPChallengeConstants.APPLICATION_KEEP_IN_VIEW:
			paramName = SambaashConstants.MAIL_TEMPLATE_ID_CHALLENGE_APPLICANT_KEEP_IN_VIEW;
			break;
		default:
			break;
		}

		String templateId = SambaashUtil.getParameter(paramName,Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID));
		SPMailTemplate template = null;
		try {
			template = SPMailTemplateLocalServiceUtil.getSPMailTemplate(GetterUtil.getLong(templateId));
		}  catch (Exception e) {
			logger.error("Error while getting Application response mail template" ,e);
		} 
		return template;
	}

	private static SPMailTemplate getApplicantMailTemplate() {

		String templateId = SambaashUtil.getParameter(SambaashConstants.MAIL_TEMPLATE_ID_CHALLENGE_APPLICANT,
				Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID));
		SPMailTemplate template = null;
		try {
			template = SPMailTemplateLocalServiceUtil.getSPMailTemplate(GetterUtil.getLong(templateId));
		}  catch (Exception e) {
			logger.error("Error while getting Applicant mail template" ,e);
		} 
		return template;
	}
	private static boolean mailAlertsEnable() {
		
		return GetterUtil.getBoolean(SambaashUtil.getParameter(SambaashConstants.CHALLENGE_MAIL_ALERTS_ENABLED,
				Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID)));
	
	}
	private static SPMailTemplate geChallengeCreatorMailTemplate() {
		
		String templateId = SambaashUtil.getParameter(SambaashConstants.MAIL_TEMPLATE_ID_CHALLENGE_CREATOR,
				Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID));
		SPMailTemplate template = null;
		try {
			template = SPMailTemplateLocalServiceUtil.getSPMailTemplate(GetterUtil.getLong(templateId));
		} catch (Exception e) {
			logger.error("Error while getting Challenge creator mail template" ,e);
		} 
		return template;
	}

	private static String getApplicationResponseDefaultSubject(int applicationStatus, ThemeDisplay themeDisplay, ResourceRequest resourceRequest){
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		String appAccepted = LabelUtil.getLabel(portletConfig,themeDisplay,"label.application.accepted");
		String apprejected = LabelUtil.getLabel(portletConfig,themeDisplay,"label.application.rejected");
		
		return applicationStatus == SPChallengeConstants.APPLICATION_ACCEPTED
				? appAccepted
				: apprejected;
	}
	private static String getApplicantDefaultSubject(String mailSubject){
		return mailSubject;
	}
	private static String getChallengeCreatorDefaultSubject(){
		return " [$STARTUP_NAME$] : Challenge Submission";
	}
	private static String getApplicantDefaultMailBodyOld(){
		StringBuilder sb = new StringBuilder();
		sb.append("Dear [$USER_NAME$], <br>");
		sb.append("You have applied for challenge.<br>");
		sb.append("Click <a href='[$CHALLENGE_DETAIL_URL$]'>here</a> for challenge details.<br>");
		sb.append("Click <a href='[$APPLICATION_DETAIL_URL$]'>here</a> for your application details.");
		sb.append("Regards,");
		return sb.toString();
	}
	private static String getChallengeCreatorDefaultMailBodyOld(){
		StringBuilder sb = new StringBuilder();
		sb.append("Dear Team, <br>");
		sb.append("New application received for challenge.<br>");
		sb.append("Click <a href='[$STARTUP_DETAIL_URL$]'>here</a> for startup details.<br>");
		sb.append("Click <a href='[$APPLICATION_DETAIL_URL$]'>here</a> for application details.");
		sb.append("Click <a href='[$CHALLENGE_DETAIL_URL$]'>here</a> for challenge details.");
		sb.append("Regards,");
		return sb.toString();
	}
	private static String getApplicationDefaultMailBody(int applicationStatus){
		StringBuilder sb = new StringBuilder();
		sb.append("<p>Dear [$TO_NAME$],</p>");
		if (applicationStatus == SPChallengeConstants.APPLICATION_ACCEPTED) {
			sb.append("<p>Congratulations! We are glad to inform you that your application for <strong>[$BRIEF_NAME$]</strong> had been <strong>accepted</strong>.</p>");
			sb.append("<p>We look forward to working with you on this project.</p>");			
		} else {
			sb.append("<p>We are sorry to inform you that your application for <strong>[$BRIEF_NAME$]</strong> had been <strong>rejected</strong>.</p>");
			sb.append("<p>We appreciate your effort on applying for this brief.</p>");			
		}
		sb.append("<p>Note: This is a computer generated email&nbsp;and you can't reply to this email address.</p>");
		sb.append("<br>");
		sb.append("The Foundry Crew");
		return sb.toString();
	}
	private static String getApplicantDefaultMailBody(){
		StringBuilder sb = new StringBuilder();
		sb.append("Dear [$USER_NAME$],<br>");
		sb.append("Thank you very much for submitting an entry to apply for [$CHALLENGE_TITLE$] challenge. Your application has been received, and we�ll respond within 3 weeks of the closing date.<br>");
		sb.append("Below are the details of your application:<br>");
		sb.append("Click <a href='[$CHALLENGE_DETAIL_URL$]'>here</a> for the challenge details.<br>");
		sb.append("Click <a href='[$APPLICATION_DETAIL_URL$]'>here</a> for your application details.<br>");
		sb.append("The Foundry Crew");
		return sb.toString();
	}
	private static String getChallengeCreatorDefaultMailBody(){
		StringBuilder sb = new StringBuilder();
		sb.append("Dear [$USER_NAME$],");
		sb.append("The following applicant [$STARTUP_NAME$] has applied for this challenge [$CHALLENGE_TITLE$].<br>");
		sb.append("Below are the details of the application:<br>");
		sb.append("Applicant	:	<a href='[$STARTUP_DETAIL_URL$]'>here</a><br>");
		sb.append("Application Details	:	<a href='[$APPLICATION_DETAIL_URL$]'>here</a><br>");
		sb.append("Challenge Details	:	<a href='[$CHALLENGE_DETAIL_URL$]'>here</a><br>");
		sb.append("The Foundry Crew");
		return sb.toString();
	}
	private static String formatApplicationTemplate(String content, String toName, String briefName) {
		return StringUtil.replace(content, new String[] { "[$TO_NAME$]", "[$BRIEF_NAME$]" },
				new String[] { toName, briefName });
	}
	private static String formatApplicantTemplate(String content, String firstName, String challengeTitle, String challengerDetailUrl, String applicationDetailUrl) {
		return StringUtil.replace(content, new String[] { "[$USER_NAME$]", "[$CHALLENGE_TITLE$]","[$CHALLENGE_DETAIL_URL$]", "[$APPLICATION_DETAIL_URL$]" },
				new String[] { firstName, challengeTitle,challengerDetailUrl, applicationDetailUrl });
	}
	private static String formatCreatorTemplate(String content,String firstName,String startupName,String challengeTitle,
			String startupDetailUrl, String applicationDetailUrl, String challengeDetailUrl) {
		return StringUtil.replace(content, new String[] {"[$USER_NAME$]", "[$STARTUP_NAME$]", "[$CHALLENGE_TITLE$]", "[$STARTUP_DETAIL_URL$]" ,"[$APPLICATION_DETAIL_URL$]","[$CHALLENGE_DETAIL_URL$]" }, 
				new String[] { firstName,startupName,challengeTitle,startupDetailUrl,	applicationDetailUrl, challengeDetailUrl });
	}
	private static String formatCreatorSubject(String content,String startupName) {
		return StringUtil.replace(content, new String[] {"[$STARTUP_NAME$]"},new String[] { startupName});
	}
		
		
	private static final Log logger = LogFactoryUtil.getLog(SPChallengeMailHelper.class);
}
