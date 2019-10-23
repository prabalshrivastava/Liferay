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
import com.liferay.portal.kernel.search.Field;
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
import com.sambaash.platform.portlet.legalandcontract.search.TrademarksSearch;
import com.sambaash.platform.portlet.legalandcontract.util.TrademarksConstants;
import com.sambaash.platform.portlet.legalandcontract.util.Utils;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class RenewalAlertMailHelper {

	private static Log _log = LogFactoryUtil.getLog(RenewalAlertMailHelper.class);

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
	public static void sendMailsToUsers(long companyId,Set<User> usersSet,boolean countryMatchingRequired) throws Exception {
		Map<Integer, List<Document>> trademarksMap = getPendingRenewalTrademarks(companyId);
		if (Validator.isNotNull(trademarksMap) && trademarksMap.size() > 0) {
			// ResourcePermissionLocalServiceUtil.hasResourcePermission(companyId,
			// name, scope, primKey, roleId, actionId)
			try {
			/*	List<Role> permRoles = LegalPermissionUtil.getRolesHavingAddEditTrademarksPermission();
				Set<User> usersSet = new HashSet<User>();
				for (Role role : permRoles) {
					List<User> userList = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
					usersSet.addAll(userList);
				} */

				
				Set<User>defaultUsers = LegalPermissionUtil.getDefaultUsersToSendMails(companyId);
				SPMailTemplate mailTemplate = getMailTemplateTMExpiry();
				String mailBodyFormat;
				String subject;

				if (Validator.isNull(mailTemplate)) {
					mailBodyFormat = getDefaultMailBodyTMExpiry();
					subject = "Trademark Expiry Date Alert";
				} else {
					mailBodyFormat = mailTemplate.getHtmlContent();
					subject = mailTemplate.getSubject();
				}

				String trademarkId;
				String applicationNo = StringPool.BLANK;
				String country = StringPool.BLANK;
				String trademarkDetailsUrl;
				String trademark;
				List<Long> catIds;
				String classCodes;
				String regOwner;
				String expireDate;
				String fromName = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
						PropsKeys.ADMIN_EMAIL_FROM_NAME);

				String fromAddress = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
						PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
				long classCodeVocId = GetterUtil.getLong(SambaashUtil.getParameter(
						SambaashConstants.TRADEMARKS_CLASS_CODE_VOC_ID, 0));
				long registeredOwnerVocId = GetterUtil.getLong(SambaashUtil.getParameter(
						SambaashConstants.TRADEMARKS_REGISTERED_OWNER_VOC_ID, 0));
				Set<String>noAdminsSet = new LinkedHashSet<String>();
				for (Integer days : trademarksMap.keySet()) {
					List<Document> trademarks = trademarksMap.get(days);
					if (Validator.isNotNull(trademarks)) {
						for (Document doc : trademarks) {
							MailMessage mailMessage = new MailMessage();
							try {
								trademarkId = GetterUtil.getString(doc.get(Field.ENTRY_CLASS_PK));
								// regNum =
								// GetterUtil.getString(doc.get(TrademarksConstants.REGISTRATION_NUMBER));
								applicationNo = GetterUtil.getString(doc.get(TrademarksConstants.APPLICATION_NO));
								country = GetterUtil.getString(doc.get(TrademarksConstants.COUNTRY));
								trademark = GetterUtil.getString(doc.get(TrademarksConstants.TRADEMARK));
								trademarkDetailsUrl = Utils.getTrademarkDetailsFriendlyUrl(trademarkId);
								catIds = Utils.getCategoryIds(doc);
								classCodes = TrademarksSearch.getClassCodes(classCodeVocId, catIds);
								regOwner = Utils.getCategoryName(registeredOwnerVocId, catIds);
								expireDate = Utils.getDateStrYMD(doc, TrademarksConstants.EXPIRY_DATE);
								mailMessage.setFromAddress(fromAddress);
								mailMessage.setFromName(fromName);
								mailMessage.setSubject(subject);
								mailMessage.setHtmlBody(formatMailTemplateTMExpiry(mailBodyFormat, trademark, String.valueOf(days),
										applicationNo, classCodes, regOwner, expireDate, trademarkDetailsUrl));
								mailMessage.setHtmlFormat(true);	
							} catch (Exception e) {
								_log.error("Error while preparing mail " ,e);
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
											// Pass all the checks if countryMatchingRequired is not required
											sendMail = true;
											adminFound = true;
										}
										if(sendMail){
											_log.debug("Preparing Email message  for " + user.getEmailAddress() + " trademarkApp="
													+ applicationNo + "country=" + country);
											//HARD coding for testing purposes
											//mailMessage.setToAddress("gaurav.vijayvergia@sambaash.com");
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
									_log.debug("Preparing Email message  for " + user.getEmailAddress() + " trademarkApp="
											+ applicationNo + "country=" + country);
									mailMessage.setToAddress(user.getEmailAddress());
									mailMessage.setBccAddress("naresh.chebolu@sambaash.com");
									SPMailLocalServiceUtil.sendMail(mailMessage);
								} catch (Exception e) {
									_log.error("Error while sending mail " ,e);
								}
							}
						}
					}
				}

			} catch (Exception e) {
				_log.error(e);
			}
		} else {
			_log.debug("No Trademarks to alert");
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
	

	private static List<Integer> getPendingRenewalList() {
		long vocId = GetterUtil
				.getLong(SambaashUtil.getParameter(SambaashConstants.TRADEMARKS_RENEWAL_ALERT_VOC_ID, 0));
		List<AssetCategory> categories = Utils.getCategories(vocId);
		List<Integer> daysList = new ArrayList<Integer>();
		for (AssetCategory categ : categories) {
			int days = GetterUtil.getInteger(categ.getName());
			daysList.add(days);
		}
		return daysList;
	}

	private static Map<Integer, List<Document>> getPendingRenewalTrademarks(long companyId) throws PortalException,
			SystemException {
		Map<Integer, List<Document>> map = new HashMap<Integer, List<Document>>();

		List<Integer> daysList = getPendingRenewalList();
		for (Integer days : daysList) {
			List<Document> docs = TrademarksSearch.getTrademarksExpiresOnDay(days, companyId,true);
			if (docs.size() > 0) {
				map.put(days, docs);
			}
		}
		return map;
	}

	private static Set<User> getAuthorizedUsersOnMailNotifications() throws PortalException, SystemException {
		List<String> actions = new ArrayList<String>();
		actions.add(TrademarksConstants.ACTION_KEY_ADD_TRADEMARK);
		actions.add(TrademarksConstants.ACTION_KEY_EDIT_TRADEMARK);
		List<Role> permRoles = LegalPermissionUtil.getRolesHavingAnyPermissionsOnPortlet(
				TrademarksConstants.PORTLET_ID, actions);
		Set<User> usersSet = new HashSet<User>();
		for (Role role : permRoles) {
			List<User> userList = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
			usersSet.addAll(userList);
		}

		return usersSet;

	}

	long getTimeDiffInDays(Date date1, Date date2) {
		long diffInMillies = date1.getTime() - date2.getTime();
		return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}

	private static SPMailTemplate getMailTemplateTMExpiry() {

		String templateId = SambaashUtil.getParameter(SambaashConstants.TM_EXPIRE_ALERT_MAIL_TEMPLATE_ID,
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
		
		String templateId = SambaashUtil.getParameter(SambaashConstants.LEGAL_MAIL_TEMPLATE_ID_TM_COUNTRY_NO_ADMIN_FOUND,
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

	private static String getDefaultMailBodyTMExpiry() {
		StringBuilder sb = new StringBuilder();
		sb.append("Dear Administrator, <br><br><p>The Response Deadline for [$TRADEMARK$] is due for renewal in [$DAYS$] days.");
		sb.append("<br><br>");
		sb.append("Trademark Application No: [$APP_NO$] ");
		sb.append("<br>");
		sb.append("For Class(es) : [$CLASS_NUMBERS$] ");
		sb.append("<br>");
		sb.append("In the name of : [$TM_OWNER$] ");
		sb.append("<br>");
		sb.append("Expiry Date : [$EXPIRY_DATE$] ");
		sb.append("<br><br>");
		sb.append("Please click [$DETAILS_LINK$] to view the details");
		sb.append("<br><br>");
		sb.append("This is a system generated email and do not reply to this email.");
		sb.append("<br><br>");
		sb.append("Regards,<br>");
		sb.append("Menarini Trademarks Database");
		sb.append("a href=\"https://connect.menariniapac.com/\">https://connect.menariniapac.com/</a");

		return sb.toString();
	}
	private static String getDefaultMailBodyNoAdmin() {
		StringBuilder sb = new StringBuilder();
		sb.append("Dear Administrator, <br><br><p>No administrator found for the trademarks belonging to [$COUNTRY$].");
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

	private static String formatMailTemplateTMExpiry(String content, String trademark, String days, String appNo,
			String classNumbers, String tmOwner, String expiryDate, String detailUrl) {
		return StringUtil.replace(content, new String[] { "[$TRADEMARK$]", "[$DAYS$]", "[$APP_NO$]",
				"[$CLASS_NUMBERS$]", "[$TM_OWNER$]", "[$EXPIRY_DATE$]", "[$DETAILS_LINK$]" }, new String[] { trademark,
				days, appNo, classNumbers, tmOwner, expiryDate, detailUrl });
	}
	private static String formatMailTemplateNoAdmin(String content,String country) {
		return StringUtil.replace(content, new String[] { "[$COUNTRY$]" }, new String[] { country });
	}

}
