package com.sambaash.platform.portlet.legalandcontract.schedular;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.portlet.legalandcontract.permissions.LegalPermissionUtil;
import com.sambaash.platform.portlet.legalandcontract.search.LitigationSearch;
import com.sambaash.platform.portlet.legalandcontract.util.LitigationConstants;
import com.sambaash.platform.portlet.legalandcontract.util.Utils;
import com.sambaash.platform.srv.legalandcontract.model.Litigation;
import com.sambaash.platform.srv.legalandcontract.model.Trademarks;
import com.sambaash.platform.srv.legalandcontract.service.LitigationLocalServiceUtil;
import com.sambaash.platform.srv.legalandcontract.service.TrademarksLocalServiceUtil;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class RDLMailHelper {
	
	
	private static Log _log = LogFactoryUtil.getLog(RDLMailHelper.class);
	
	public static void sendMails() throws Exception {
		Set<User> usersSet = getAuthorizedUsersOnMailNotifications();
		long companyId = PortalUtil.getDefaultCompanyId();
		sendMailsToUsers(companyId,usersSet,true); 
	}
	public static void sendMailsToUsersHavingRole(long companyId,String rolesStr){
		if(Validator.isNotNull(rolesStr)){
			Set<User>users = new LinkedHashSet<User>();
			String roles[] = rolesStr.split(StringPool.COMMA);
			for (String roleName : roles) {
				users.addAll(LegalPermissionUtil.getUsersHavingRole(companyId, roleName.trim()));
			}
			try {
				sendMailsToUsers(companyId, users,false);
			} catch (Exception e) {
				_log.error("Error while sending mails", e);
			}
		}
	}
	public static void sendMailsToUsers(long companyId,Set<User> usersSet, boolean countryMatchingRequired) throws Exception{
		_log.debug("SendMails: start");
		Map<Integer,List<Litigation>> litMap = getRDLMeetingDeadlines(companyId);
		if(Validator.isNotNull(litMap) && litMap.size() > 0){
			try {
				Set<User>defaultUsers = LegalPermissionUtil.getDefaultUsersToSendMails(companyId);
				long trademarkId ;
				String applicationNo = StringPool.BLANK;
				String country =  StringPool.BLANK;
				String detailsUrl;
				String fromName = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
						PropsKeys.ADMIN_EMAIL_FROM_NAME);

				String fromAddress = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
						PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
				SPMailTemplate mailTemplate = getMailTemplateRDL();
				String subject;
				String mailBodyFormat;
				if(Validator.isNotNull(mailTemplate)){
					mailBodyFormat = mailTemplate.getHtmlContent();
					subject = mailTemplate.getSubject();
				}else{
					mailBodyFormat = getDefaultMailBodyRDL();
					subject = "Contentious Proceeding Response Deadline Alert";
				}
				String content ;
				Set<String>noAdminsSet = new LinkedHashSet<String>();
				for(Integer days: litMap.keySet()){
					List<Litigation> litigations = litMap.get(days);
					if(Validator.isNotNull(litigations)){
						for (Litigation litigation : litigations) {
							MailMessage mailMessage = null;
							try {
								mailMessage = new MailMessage();
								trademarkId = litigation.getSpTrademarksId();
								Trademarks trademarks = TrademarksLocalServiceUtil.getTrademarks(trademarkId);
								applicationNo = trademarks.getApplicationNo();
								country = trademarks.getCountry();
								detailsUrl = Utils.getLitigationDetailsFriendlyUrl(litigation.getSpLitigationId());
								_log.debug("Detail Url " + detailsUrl);

								// TODO: Hard coded for testing purpose
								mailMessage.setFromAddress(fromAddress);
								mailMessage.setFromName(fromName);
								mailMessage.setSubject(subject);
								content = formatTemplateRDL(mailBodyFormat, litigation.getFiledBy(),
										trademarks.getApplicationNo(), country, String.valueOf(days), detailsUrl);
								mailMessage.setHtmlBody(content);
								mailMessage.setHtmlFormat(true);

								// mailMessage.setToAddress("naresh.chebolu@sambaash.com");
								_log.debug("Mail Message " + mailMessage.toString());
								mailMessage.setBccAddress("naresh.chebolu@sambaash.com");
							} catch (Exception ex) {
								_log.error("Error while preparing mail " + ex.getMessage());
								continue;
							}
							boolean adminFound = false;
							for (User user : usersSet) {
								// dont mail here for default users.
								if(defaultUsers.contains(user)){
									continue;
								}
								boolean sendMail = false;
								try {
									if(countryMatchingRequired){
										if(isTMCountryMatchingEsnCountry(user, country)){
											sendMail = true;
											adminFound = true;
										}else{
											_log.debug("User ESN country not matched with trademark country");
										}
									}else{
										sendMail = true;
										adminFound = true;
									}
									if(sendMail){
										_log.debug("Sending mail for " + user.getEmailAddress() + " Litigaiton Id = "
												+ litigation.getSpLitigationId() + " trademarkApp=" + applicationNo + "country="
												+ country);
										mailMessage.setToAddress(user.getEmailAddress());
										SPMailLocalServiceUtil.sendMail(mailMessage);
									}
								} catch (Exception e) {
									_log.error("Error while sending mail " ,e);
								}
							}
							
							// If the admin is not available for the trademarks belongs to some country, then notify the legal administrators.
							if(!adminFound){
								try {
										boolean added = noAdminsSet.add(country);
										if(added){
											_log.debug("No Admin Found for the Country " + country + ". Lets notify the legal admins");
											sendMailsAboutNoAdmins(fromName, fromAddress, country, defaultUsers);
										}
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
							
							// Mail to default users
							for (User user : defaultUsers) {
								try {
									_log.debug("Sending mail for to default user " + user.getEmailAddress() + " Litigaiton Id = "
											+ litigation.getSpLitigationId() + " trademarkApp=" + applicationNo + "country="
											+ country);
									mailMessage.setToAddress(user.getEmailAddress());
									SPMailLocalServiceUtil.sendMail(mailMessage);
								
								} catch (Exception e) {
									_log.error("Error while sending mail " ,e);
								}
							}
						}
					}
				}
		
		} catch(Exception e) {
			_log.error(e);
		}
	  }else{
		  _log.debug("No litigations to alert");
	  }
	}
	
	private static void sendMailsAboutNoAdmins(String fromName,String fromAddress, String country,Set<User>defaultUsers){
		try {
			if (Validator.isNotNull(defaultUsers) && !defaultUsers.isEmpty()) {
				_log.debug("Preparing mail about no admin found - country " + country);
				SPMailTemplate template = getMailTemplateNoAdminFound();
				String subject = StringPool.BLANK;
				String contentFormat = StringPool.BLANK;

				if (Validator.isNotNull(template)) {
					subject = template.getSubject();
					contentFormat = template.getHtmlContent();
				}
				if (Validator.isNull(subject)) {
					subject = "No Admin Found";
				}
				if (Validator.isNull(contentFormat)) {
					contentFormat = getDefaultMailBodyNoAdmin();
				}

				String content = formatMailTemplateNoAdmin(contentFormat, country);
				MailMessage mailMessage = new MailMessage();
				mailMessage.setFromAddress(fromAddress);
				mailMessage.setFromName(fromName);
				mailMessage.setSubject(subject);
				mailMessage.setHtmlBody(content);
				mailMessage.setHtmlFormat(true);
				for (User user : defaultUsers) {
					mailMessage.setToAddress(user.getEmailAddress());
					mailMessage.setBccAddress("naresh.chebolu@sambaash.com");
					_log.debug("Sending mail about no admin found " + mailMessage);
					SPMailLocalServiceUtil.sendMail(mailMessage);
				}

			}
		} catch (Exception e) {
			_log.error("Error while preparing and sending mail to default users ", e);
		}
	}
	
	
	private static boolean isTMCountryMatchingEsnCountry(User user, String tmCountry){
		boolean matching = false;
		if(Validator.isNotNull(user)){
			try {
					String esnCountry = SambaashUtil.getUserCountry(user.getUserId());
					if(esnCountry.trim().equalsIgnoreCase(tmCountry.trim())){
						matching = true;
					}
			} catch (Exception e) {
				_log.error("Error while checking coutry matching");
			}
		}
		return matching;
	}
	
	private static List<Integer> getAlertBeforeList(){
		long vocId = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.LITIGATION_ALERT_BEFOR_VOC_ID, 0));
		List<AssetCategory> categories = Utils.getCategories(vocId);
		List<Integer> daysList = new ArrayList<Integer>();
		for (AssetCategory categ: categories) {
			int days = GetterUtil.getInteger(categ.getName());
			daysList.add(days);
		}
		return daysList;
	}
	private static Map<Integer,List<Litigation>> getRDLMeetingDeadlines(long companyId) throws PortalException, SystemException{
		Map<Integer,List<Litigation>> map = new HashMap<Integer, List<Litigation>>();
		List<Litigation>litigatinList ;
		
		List<Integer> daysList = getAlertBeforeList();
		for(Integer days: daysList){
			_log.debug("getting litigations having deadline in "+ days );
			Map<String,Document>litRdlMap = LitigationSearch.getRDLsInDays(days, companyId, true,true);
			
			if(Validator.isNotNull(litRdlMap) && litRdlMap.size() > 0){
				_log.debug("Litigation having deadlines in "+ days + "  size =" + litRdlMap.size());
				litigatinList = new ArrayList<Litigation>();
				for(String litId:litRdlMap.keySet()){
					try{
						_log.debug("Getting litigation from db " + litId);
						Litigation litgation = LitigationLocalServiceUtil.getLitigation(GetterUtil.getLong(litId));
						litigatinList.add(litgation);
					}catch(Exception ex){
						_log.error("Error while getting litigation with id " + litId);
					}
				}
				
				map.put(days, litigatinList);
			}else{
				_log.debug("Litigation having deadlines in "+ days + "  size =0" );
			}
		}
		return map;
	}
	
	private static Set<User> getAuthorizedUsersOnMailNotifications() throws PortalException, SystemException{
		List<String>actions = new ArrayList<String>();
		actions.add(LitigationConstants.ACTION_KEY_ADD_LITIGATION);
		actions.add(LitigationConstants.ACTION_KEY_EDIT_LITIGATION);
		List<Role> permRoles = LegalPermissionUtil.getRolesHavingAnyPermissionsOnPortlet(LitigationConstants.PORTLET_ID, actions);
		Set<User> usersSet = new HashSet<User>();
		for(Role role: permRoles){
			List<User> userList = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
			usersSet.addAll(userList);
		}
		
		return usersSet;

	}

	long getTimeDiffInDays(Date date1,Date date2){
		long diffInMillies = date1.getTime() - date2.getTime();
	    return TimeUnit.DAYS.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}
	
	private static SPMailTemplate getMailTemplateRDL() {

		String templateId = SambaashUtil.getParameter(SambaashConstants.LITIGATION_ALERT_MAIL_TEMPLATE_ID,
				Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID));
		SPMailTemplate template = null;
		try {
			template = SPMailTemplateLocalServiceUtil.getSPMailTemplate(Long.parseLong(templateId));
		} catch (NumberFormatException e) {
			_log.error(e);
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		return template;
	}
	
	private static SPMailTemplate getMailTemplateNoAdminFound() {
		
		String templateId = SambaashUtil.getParameter(SambaashConstants.LEGAL_MAIL_TEMPLATE_ID_CP_COUNTRY_NO_ADMIN_FOUND,
				Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID));
		SPMailTemplate template = null;
		try {
			template = SPMailTemplateLocalServiceUtil.getSPMailTemplate(Long.parseLong(templateId));
		} catch (NumberFormatException e) {
			_log.error(e);
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		return template;
	}
	
	private static String getDefaultMailBodyRDL(){
		StringBuilder sb = new StringBuilder();
		sb.append("Dear Administrator, <br><br><p>The Response Deadline for Contentious Proceeding with [$FILED_BY$] for Trademark Application Number : [$TM_APP_NO$] in Country : [$COUNTRY$] is due" 
				+ " in [$DAYS$] days. Please click [$DETAILS_LINK$] to view the details");
		sb.append("<br><br>This is a system generated email and do not reply to this email.<br><br>");
		sb.append("Regards,<br>");
		sb.append("Menarini Asia-Pacific");
		
		return sb.toString();
	}
	
	private static String getDefaultMailBodyNoAdmin() {
		StringBuilder sb = new StringBuilder();
		sb.append("Dear Administrator, <br><br><p>No administrator found for the Contentious Proceedings belonging to [$COUNTRY$].");
		sb.append("<br><br>");
		sb.append("Please setup administrator.");
		sb.append("<br><br></p>");
		sb.append("This is a system generated email and do not reply to this email.");
		sb.append("<br><br>");
		sb.append("Regards,<br>");
		sb.append("Menarini Trademarks Database");
		sb.append("a href=\"https://connect.menariniapac.com/\">https://connect.menariniapac.com/</a");
		
		return sb.toString();
	}
	
	private static String formatTemplateRDL(String content, String filedBy, String tmAppNo, String country,
			String days, String detailUrl) {
		return StringUtil.replace(content, new String[] { "[$FILED_BY$]", "[$TM_APP_NO$]", "[$COUNTRY$]",
				"[$DAYS$]", "[$DETAILS_LINK$]" }, new String[] { filedBy,
				tmAppNo, country, days, detailUrl });
	}
	
	private static String formatMailTemplateNoAdmin(String content,String country) {
		return StringUtil.replace(content, new String[] { "[$COUNTRY$]" }, new String[] { country });
	}

}
