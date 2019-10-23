package com.sambaash.platform.portlet.socialprofile.action;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.liferay.compat.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.portlet.socialprofile.util.ProfileConstants;
import com.sambaash.platform.portlet.socialprofile.util.UserProfileUtil;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.util.SambaashHtmlUtil;
import com.sambaash.platform.util.SambaashUtil;

public class UserProfileAction extends UserProfileBase {

	private static Log _log = LogFactoryUtil.getLog(UserProfileAction.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		super.doView(renderRequest, renderResponse);

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String commmunityName = getCommunityName(themeDisplay);
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		ResourceBundle rb = getProfileResourceBundle();

		String orgFriendlyUrl = (String) renderRequest.getAttribute(SambaashConstants.PROFILE_WITH_SCREEN_NAME);
		String currentUrl = PortalUtil.getCurrentURL(httpRequest);
		String screenNameParam = httpRequest.getParameter("user");
		String	screenName = themeDisplay.getUser().getScreenName();
		long remoteUserId = themeDisplay.getUserId();
		long userProfileId = remoteUserId;
		int canEdit = 2;
		int isMentor = 0;
		String mentorUser = StringPool.BLANK;
		SocialProfile profileUser = null;
		User checkUser = null;
		HashMap<String, Object> params = new HashMap<String, Object>();
		StringWriter writer = new StringWriter();
		Result result = new javax.xml.transform.stream.StreamResult(writer);
		PortletPreferences prefs = renderRequest.getPreferences();
		String xslName = prefs.getValue("name", StringPool.BLANK);
		String formLabel = prefs.getValue("formLabel", xslName.replaceAll(StringPool.UNDERLINE, StringPool.SPACE));
		String respectiveFields = StringPool.BLANK;
		String publicFields = StringPool.BLANK;
		String defaultBillingId = StringPool.BLANK;
		String defaultShippingId = StringPool.BLANK;
		Map<String, String[]> preferences = prefs.getMap();

		try {
			if(Validator.isNotNull(screenNameParam) && !screenNameParam.isEmpty()){
				if (!screenName.equalsIgnoreCase(screenNameParam)) {
					userProfileId = UserLocalServiceUtil.getUserIdByScreenName(themeDisplay.getCompanyId(), screenNameParam);
					if (Validator.isNull(userProfileId)) {
						userProfileId = remoteUserId;
					} else {
						if (themeDisplay.isSignedIn()) {
							User user = UserLocalServiceUtil.getUser(userProfileId);
							boolean mentor = SambaashUtil.isMentor(user);
							mentorUser = user.getScreenName();
							if (mentor) {
								isMentor = 1;
							}
						}
					}
				}
			}
			profileUser = SocialProfileLocalServiceUtil.getSocialProfile(userProfileId);
		} catch (NoSuchSocialProfileException e) {
			_log.error("No such social profile existing with primary key: " + userProfileId);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		if (_log.isDebugEnabled()) {
			_log.debug(" orgFriendlyUrl : " + orgFriendlyUrl + " : currentUrl : " + currentUrl
					+ " : themeDisplay.getUser().getScreenName() : " + screenName + " : remoteUserId : " + remoteUserId
					+ " : userProfileId : " + userProfileId);
		}

		if (Validator.isNull(profileUser)) {
			return;
		}

		if (xslName.isEmpty()) {
			renderResponse.getWriter().write("Please select XSL property to use in Preferences");
			return;
		}

		// if (Validator.isNotNull(profileUser)) {
		try {
			checkUser = UserLocalServiceUtil.getUser(profileUser.getUserId());
		} catch (Exception e) {
			_log.error("No such user exist with primary key: " + userProfileId);
		}

		if (checkUser != null
				&& SambaashConstants.DEFAULT_USER_EMAIL_ADDRESS.equalsIgnoreCase(checkUser.getEmailAddress())) {

			PortletRequestDispatcher prd = getPortletContext()
					.getRequestDispatcher(PropsUtil.get(PropsKeys.DEFAULT_LANDING_PAGE_PATH));
			prd.include(renderRequest, renderResponse);

		} else {

			try {
				String viewCountIncreaseModel = SambaashUtil.getParameter(
						SambaashConstants.PROFILE_VIEW_COUNT_INCREASE_MODEL, themeDisplay.getScopeGroupId());
				boolean isAvailableIncreaseViewCount = UserProfileUtil.isAvailableIncreaseViewCount(userProfileId,
						remoteUserId, viewCountIncreaseModel, themeDisplay);
				if (isAvailableIncreaseViewCount) {
					SocialProfileLocalServiceUtil.incrementProfileViewCount(userProfileId, themeDisplay.getCompanyId());
				}
			} catch (Exception _e) {
				_log.error(_e.getMessage(), _e);
			}
			String displayField = "";
			for (Map.Entry<String, String[]> entry : preferences.entrySet()) {
				String key = entry.getKey();
				if (("name".equalsIgnoreCase(key)) || ("formedit".equalsIgnoreCase(key))) {
					continue;
				}
				String[] values = entry.getValue();
				String value = StringPool.BLANK;
				if (ArrayUtil.isNotEmpty(values) && values.length > 0) {
					value = values[0];
				}
				if (displayField.equalsIgnoreCase("default_billing_address_9")) {
					defaultBillingId = displayField;
				}
				if (displayField.equalsIgnoreCase("default_shipping_address_8")) {
					defaultShippingId = displayField;
				}
				if (Validator.isNotNull(value)) {
					if (value.indexOf("display:true") > -1) {
						if (respectiveFields.length() > 0) {
							respectiveFields += StringPool.COMMA;
						}
						displayField = key;
						respectiveFields += key;
					}
					if (value.indexOf("private:false") > -1) {
						if (publicFields.length() > 0) {
							publicFields += StringPool.COMMA;
						}
						publicFields += key;
					}
				}
			} // end for

			DocumentBuilder parser;
			String xslFile = StringPool.BLANK;
			Source xml = null;
			Source xsl = null;

			try {
				parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				String xmlInfo = SambaashHtmlUtil.unescape(profileUser.getUserInfo());
				xml = new DOMSource(parser.parse(new InputSource(new StringReader(xmlInfo))));
			} catch (ParserConfigurationException e) {
				_log.error(e.getMessage());
			} catch (SAXException e) {
				_log.error(e.getMessage());
			}

			if (_log.isDebugEnabled()) {
				_log.error("support role "
						+ SambaashUtil.isSupportRole(themeDisplay.getScopeGroupId(), themeDisplay.getUserId()));
			}

			if ((SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())
					&& userProfileId != themeDisplay.getUserId())
					|| (SambaashUtil.isReportRole(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())
							&& userProfileId != themeDisplay.getUserId())
					|| (themeDisplay.isSignedIn() && userProfileId == remoteUserId)
					|| SambaashUtil.isSupportRole(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				canEdit = 1;
			}

			PortalUtil.setPageDescription(HtmlUtil
					.stripHtml(Validator.isNotNull(profileUser.getAbout()) ? profileUser.getAbout() : StringPool.BLANK)
					.trim(), httpRequest);
			PortalUtil.setPageTitle(checkUser.getFullName(), httpRequest);

			String overlapSettings = getWorkHistoryOverlapSettings(themeDisplay.getScopeGroupId());

			params.put("validateOverlapping", overlapSettings);
			params.put("saveData", "display:block");
			params.put("communityName", commmunityName);
			params.put("resource", rb);
			params.put("displayField", respectiveFields);
			params.put("defaultBillingId", defaultBillingId);
			params.put("defaultShippingId", defaultShippingId);
			params.put("publicField", publicFields);
			params.put("can_edit", String.valueOf(canEdit));
			params.put("currentURL", getCurrentURL(themeDisplay));
			params.put("scopeGroupId", themeDisplay.getScopeGroupId());
			params.put("formLabel", formLabel);
			params.put("isMentor", String.valueOf(isMentor));
			params.put("mentorUser", mentorUser);

			try {
				xslFile = getClass().getResource(
						ProfileConstants.USER_PROFILE.XSL_PATH + xslName + ProfileConstants.USER_PROFILE.XSL_FILE_EXT)
						.getFile();
			} catch (Exception e) {
				_log.debug("Error getting xslFile from folder : " + ProfileConstants.USER_PROFILE.XSL_PATH + xslName
						+ ProfileConstants.USER_PROFILE.XSL_FILE_EXT);
			}

			try {

				if (Validator.isNull(xslFile)) {
					xslFile = getClass().getResource(ProfileConstants.USER_PROFILE.XSL_PATH + "dynamic_section"
							+ ProfileConstants.USER_PROFILE.XSL_FILE_EXT).getFile();
					params.put("section_name", xslName);
					params.put("form_name", formatFormLabel(formLabel));
				}
				xsl = SourceFromFilename(xslFile);
				transform(xml, xsl, result, params);
				renderResponse.getWriter().write(writer.toString());
			} catch (TransformerException e) {
				_log.error("Unable to transform XML: " + e.getMessage());
			}

		}
	}

	private String formatFormLabel(String formName) {

		if (Validator.isNull(formName))
			return StringPool.BLANK;

		String form = SambaashHtmlUtil.unescape(formName);
		String formLabel = StringPool.BLANK;
		String[] s = form.split(StringPool.SPACE);
		int i = 1;

		for (String str : s) {
			if (formLabel.length() == 0) {
				formLabel = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
			} else {
				if (s.length == i) {
					formLabel += "<span class=\"header-posttitle\"> " + str.substring(0, 1).toUpperCase()
							+ str.substring(1).toLowerCase() + "</span>";
				} else {
					formLabel += StringPool.SPACE + str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
				}

			}
			i++;
		}
		return formLabel.trim();
	}

	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {

		super.serveResource(request, response);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long scopeGroupId = themeDisplay.getScopeGroupId();
		boolean signedIn = themeDisplay.isSignedIn();

		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		// JSONObject obj = JSONFactoryUtil.createJSONObject();
		/*
		 * try {
		 * 
		 * AuthTokenUtil.checkCSRFToken(httpRequest,
		 * UserProfileAction.class.getName()); } catch (PortalException e1) {
		 * obj.put("status", "400"); e1.printStackTrace();
		 * response.getWriter().append(obj.toString()); return; }
		 */

		if (signedIn) {
			SocialProfile profileUser = null;
			String type = request.getParameter("type");
			String categoryName = request.getParameter("categoryName");
			String categoryDetails = request.getParameter("categoryDetails");
			String sData = request.getParameter("sData");
			String instance = request.getParameter("instance");
			String value = request.getParameter("value");
			// String postalCodeValue = request.getParameter("postalCode");
			if (Validator.isNotNull(sData) && !type.equalsIgnoreCase("saveWorkHistory")) {
				sData = HtmlUtil.stripHtml(sData);
			}

			if (Validator.isNotNull(value)) {
				value = HtmlUtil.stripHtml(value);
			}

			int startIndex = -1;
			int endIndex = -1;

			if (request.getParameter("startIndex") != null && Validator.isNumber(request.getParameter("startIndex"))) {
				startIndex = Integer.parseInt(request.getParameter("startIndex"));
			}

			if (request.getParameter("endIndex") != null && Validator.isNumber(request.getParameter("endIndex"))) {
				endIndex = Integer.parseInt(request.getParameter("endIndex"));
			}

			try {
				// profileUser =
				// SocialProfileLocalServiceUtil.getSocialProfile((themeDisplay.getUserId()));
				String currentUrl = request.getParameter("currentUrl");
				long userProfileId = SambaashUtil.getUserIdByScreenName(themeDisplay.getCompanyId(), currentUrl);
				
				if (userProfileId == 0) {
					userProfileId = themeDisplay.getUserId();
				}
				profileUser = SocialProfileLocalServiceUtil.getSocialProfile(userProfileId);

				String displayField = request.getParameter("displayField");

				if ((profileUser != null) && (type != null)) {

					User user = UserLocalServiceUtil.getUserById(profileUser.getUserId());

					if (type.equals("updateSingleNodeField")) {
						String fieldName = request.getParameter("name");
						String jsonResponse = saveProfileInfo(fieldName, value, profileUser, user, themeDisplay);
						response.getWriter().append(jsonResponse.toString());
					} else if (type.equals("getLocation")) {
						// to populate location values
						getLocationValues(response);
					} else if (type.equals("getAreaExpertise")) {
						// to populate location values
						getExpertiseValues(response);
					} else if (type.equals("addSingleInputInstance")) {
						// this is to add instances with single input box &
						// remove
						// button
						addSingleInputField(themeDisplay, categoryName, categoryDetails, instance, profileUser,
								displayField, response);
					} else if (type.equals("addMultipleInput")) {
						addMultipleInputFieldDetails(themeDisplay, categoryName, categoryDetails, instance, profileUser,
								displayField, response);
					} else if (type.equals("saveSingleInputField")) {
						// portletPreferences =
						// UserProfileUtil.getPreferencesByCategoryName(scopeGroupId,
						// instance);
						saveSingleInputField(themeDisplay, categoryName, categoryDetails, value, profileUser, user,
								instance, response);
					} else if (type.equals("migrateSocialProfile")) {
						// migrate default user
						// ProfileMigrationUtil.migrateDefaultUser(themeDisplay,
						// scopeGroupId);
						// Migrate active users
						// ProfileMigrationUtil.migrateSocialProfile(themeDisplay,
						// scopeGroupId, true);
						// Migrate inactive users
						// ProfileMigrationUtil.migrateSocialProfile(themeDisplay,
						// scopeGroupId, false);

					} else if (type.equals("removeInput")) {
						// this is to remove a newly added instance or existing
						// instance(for both single & multiple input instances)
						removeInputField(categoryName, categoryDetails, instance, response, profileUser);
						updateUIWithModifiedData(themeDisplay, categoryName, profileUser, instance, response,
								displayField);
					} else if (type.equals("editContactDetails")) {

						editContactDetails(themeDisplay, categoryName, instance, profileUser, displayField, response);

					} else if (type.equals("editWorkHistoryDetails")) {

						editWorkHistoryDetails(themeDisplay, categoryName, instance, profileUser, displayField,
								response);

					} else if (type.equals("saveContactInfo")) {

						// this is to update the xml with values newly entered
						// or
						// modified existing values
						updateContactInfoData(sData, categoryName, profileUser);

						// this is to render the modified/newly added info on
						// the
						// screen after successful save
						updateUIWithModifiedData(themeDisplay, categoryName, profileUser, instance, response,
								displayField);
					} else if (type.equals("saveAvailabilityInfo")) {

						// saveAvailabilityDetails(themeDisplay, categoryName,
						// "user_availability", instance, profileUser, user,
						// response);

						updateAvailabilityInfoData(sData, categoryName, profileUser, user, scopeGroupId);
						updateUIWithModifiedData(themeDisplay, categoryName, profileUser, instance, response,
								displayField);

					} else if (type.equals("saveWorkHistory")) {
						// saveWorkHistoryDetails(themeDisplay, categoryName,
						// "work_details", instance, profileUser, user,
						// response);
						updateWorkHistoryData(sData, categoryName, profileUser, user, scopeGroupId);
						updateUIWithModifiedData(themeDisplay, categoryName, profileUser, instance, response,
								displayField);
					} else if (type.equals("saveDynamicSectionInfo")) {
						updateDynamicSectionData(sData, categoryName, profileUser, user, scopeGroupId);
						updateUIWithModifiedData(themeDisplay, categoryName, profileUser, instance, response,
								displayField);
					} else if (type.equals("cancelInfo")) {
						// this is to remove a newly added instance or existing
						// instance(for both single & multiple input instances)
						cancelProcess(themeDisplay, categoryName, response, profileUser, displayField, instance);

					} else if (type.equals("updateUserInfoXML")) {
						_log.error("startIndex : " + startIndex + " : endIndex : " + endIndex);

						Runnable r = new ReloadProfileXmlThread(categoryName, categoryDetails, scopeGroupId,
								themeDisplay.getUserId(), request);
						new Thread(r).start();

					} else if (type.equals("updateAllUserInfoXML")) {
						_log.error("startIndex : " + startIndex + " : endIndex : " + endIndex);
						
						Runnable r = new ReloadAllProfileXmlThread(categoryName, categoryDetails, scopeGroupId,
								themeDisplay.getUserId(), request);
						new Thread(r).start();

					} else if (type.equals("sendMentorRequestMail")) {
						String currentProfileUrl = request.getParameter("currentUrl");
						String portalUrl = PortalUtil.getPortalURL(request);
						sendMentorRequestMail(themeDisplay, currentProfileUrl, portalUrl);
					}

				}
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
		} // end signedin
		super.serveResource(request, response);
	}

	private class ReloadProfileXmlThread implements Runnable {

		String categoryName = null;
		String categoryDetails = null;
		long scopeGroupId = -1L;
		long userId = -1L;
		ResourceRequest request = null;

		public ReloadProfileXmlThread(String categoryName, String categoryDetails, long scopeGroupId, long userId,
				ResourceRequest request) {
			this.categoryName = categoryName;
			this.categoryDetails = categoryDetails;
			this.scopeGroupId = scopeGroupId;
			this.userId = userId;
			this.request = request;
		}

		public void run() {
			SocialProfileLocalServiceUtil.refreshSocialProfileXML(categoryName, categoryDetails, scopeGroupId, userId,
					request);
		}

	}
	
	
	private class ReloadAllProfileXmlThread implements Runnable {

		String categoryName = null;
		String categoryDetails = null;
		long scopeGroupId = -1L;
		long userId = -1L;
		ResourceRequest request = null;

		public ReloadAllProfileXmlThread(String categoryName, String categoryDetails, long scopeGroupId, long userId,
				ResourceRequest request) {
			this.categoryName = categoryName;
			this.categoryDetails = categoryDetails;
			this.scopeGroupId = scopeGroupId;
			this.userId = userId;
			this.request = request;
		}

		public void run() {
			SocialProfileLocalServiceUtil.refreshAllSocialProfileXML(scopeGroupId,
					request);
		}

	}

	private void sendMentorRequestMail(ThemeDisplay themeDisplay, String currentProfileUrl, String portalUrl) {
		User mentor = null;
		User loggedInUser = themeDisplay.getUser();
		String fromName = StringPool.BLANK;
		String fromAddress = StringPool.BLANK;
		String applicantName = loggedInUser.getFirstName() + " " + loggedInUser.getLastName();
		String applicantProfileUrl = portalUrl + "/" + loggedInUser.getScreenName();

		_log.error("applicantProfileUrl " + applicantProfileUrl);

		String templateId = SambaashUtil.getParameter(SambaashConstants.MAIL_TEMPLATE_ID_MENTOR_APPLY,
				themeDisplay.getScopeGroupId());

		try {
			fromName = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
			fromAddress = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		if (!currentProfileUrl.endsWith(loggedInUser.getScreenName())) {
			long userProfileId = SambaashUtil.getUserIdByScreenName(themeDisplay.getCompanyId(), currentProfileUrl);
			if (Validator.isNotNull(userProfileId)) {
				try {
					mentor = UserLocalServiceUtil.getUser(userProfileId);

					// send email to mentor
					/**
					 * String[] template = getTemplate(mentor, templateId,
					 * applicantName, applicantProfileUrl, mentor, portalUrl);
					 * MailMessage mailMessage = new MailMessage();
					 * mailMessage.setFromAddress(fromAddress);
					 * mailMessage.setFromName(fromName);
					 * mailMessage.setSubject(template[0]);
					 * mailMessage.setHtmlBody(template[1]);
					 * mailMessage.setToAddress(mentor.getEmailAddress());
					 * 
					 * if (_log.isDebugEnabled()) {
					 * _log.debug(mailMessage.toString()); }
					 * 
					 * String messageId =
					 * SPMailLocalServiceUtil.sendMail(mailMessage);
					 * _log.error("mail sent " + mentor.getEmailAddress() + " :
					 * messageId : " + messageId);
					 **/
					// send email to Foundry Admin's

					try {

						Role foundryAdminRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(),
								SambaashConstants.FOUNDRY_ADMIN_ROLE);

						List<User> users = UserLocalServiceUtil.getRoleUsers(foundryAdminRole.getRoleId());

						for (User foundryAdmin : users) {
							String[] emailTemplate = getTemplate(foundryAdmin, templateId, applicantName,
									applicantProfileUrl, mentor, portalUrl);
							MailMessage mailMessage = new MailMessage();
							mailMessage.setFromAddress(fromAddress);
							mailMessage.setFromName(fromName);
							mailMessage.setSubject(emailTemplate[0]);
							mailMessage.setHtmlBody(emailTemplate[1]);
							mailMessage.setToAddress(foundryAdmin.getEmailAddress());

							if (_log.isDebugEnabled()) {
								_log.debug(mailMessage.toString());
							}

							String msgId = SPMailLocalServiceUtil.sendMail(mailMessage);
							_log.error("mail sent " + foundryAdmin.getEmailAddress() + " : msgId : " + msgId);
						}

					} catch (PortalException e) {
						_log.error(e.getMessage());
					} catch (SystemException e) {
						_log.error(e.getMessage());
					}

				} catch (Exception e) {
					_log.error("Error getting mentor values" + e.getMessage());
				}
			}
		}

	}

	private String[] getTemplate(User user, String templateId, String applicantName, String applicantProfileUrl,
			User mentor, String portalUrl) {
		String[] template = new String[2];
		try {
			long mentorTemplateId = Long.valueOf(templateId);
			if (mentorTemplateId > 0) {
				SPMailTemplate spMailTemplateForMentor = SPMailTemplateLocalServiceUtil
						.getSPMailTemplate(mentorTemplateId);
				template[0] = spMailTemplateForMentor.getSubject();
				String htmlContent = spMailTemplateForMentor.getHtmlContent();
				template[1] = StringUtil.replace(htmlContent,
						new String[] { "[$TO_FIRST_NAME$]", "[$TO_LAST_NAME$]", "[$APPLICANT_PROFILE_URL$]",
								"[$APPLICANT_NAME$]", "[$APPLICANT_EMAILADDRESS$]", "[$MENTOR_NAME$]",
								"[$MEMBER_PROFILE_URL$]", "[$MENTOR_EMAILADDRESS$]" },
						new String[] { user.getFirstName(), user.getLastName(), applicantProfileUrl, applicantName,
								user.getEmailAddress(), mentor.getFullName(),
								portalUrl + StringPool.FORWARD_SLASH + mentor.getScreenName(),
								mentor.getEmailAddress() });
			}
		} catch (Exception nfe) {
			nfe.printStackTrace();
		}
		template[0] = "Application for Mentorship";
		template[1] = "Would you like to be the mentor for " + applicantName;
		return template;
	}

}
