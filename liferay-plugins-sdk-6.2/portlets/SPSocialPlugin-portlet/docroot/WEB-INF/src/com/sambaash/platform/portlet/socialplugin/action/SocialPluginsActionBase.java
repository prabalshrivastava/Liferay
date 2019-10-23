package com.sambaash.platform.portlet.socialplugin.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.oauth.model.Job;
import com.sambaash.oauth.model.Profile;
import com.sambaash.platform.portlet.socialplugin.util.SocialPluginsConstants;
import com.sambaash.platform.portlet.socialplugin.util.SocialSharingUtil;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.srv.spsocialsharing.service.SPSocialSharingLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class SocialPluginsActionBase extends MVCPortlet {

	@Override
	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		PortletPreferences prefs = renderRequest.getPreferences();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		long scopeGroupId = themeDisplay.getScopeGroupId();
		boolean isAdmin = SambaashUtil.isAdmin(scopeGroupId,
				themeDisplay.getUserId());

		renderRequest.setAttribute("facebook", SambaashUtil.getParameter(
				SocialPluginsConstants.FACEBOOK_SHARING, scopeGroupId));
		renderRequest.setAttribute("linkedin", SambaashUtil.getParameter(
				SocialPluginsConstants.LINKEDIN_SHARING, scopeGroupId));
		renderRequest.setAttribute("twitter", SambaashUtil.getParameter(
				SocialPluginsConstants.TWITTER_SHARING, scopeGroupId));
		renderRequest.setAttribute("google", SambaashUtil.getParameter(
				SocialPluginsConstants.GOOGLE_SHARING, scopeGroupId));
		renderRequest.setAttribute("yahoo", prefs.getValue("yahoo", "0"));// no
																			// auto-sharing
																			// for
																			// yahoo

		renderRequest.setAttribute("facebookAPI", SambaashUtil.getParameter(
				SocialPluginsConstants.FACEBOOK.POST, scopeGroupId));
		renderRequest.setAttribute("twitterAPI", SambaashUtil.getParameter(
				SocialPluginsConstants.TWITTER.POST, scopeGroupId));
		renderRequest.setAttribute("linkedinAPI", SambaashUtil.getParameter(
				SocialPluginsConstants.LINKEDIN.POST, scopeGroupId));

		renderRequest.setAttribute("admin", isAdmin);

		include(editTemplate, renderRequest, renderResponse);
	}

	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences prefs = actionRequest.getPreferences();
		boolean signedIn = themeDisplay.isSignedIn();
		long scopeGroupId = themeDisplay.getScopeGroupId();

		String action = actionRequest.getParameter("action");
		String facebook = ParamUtil.getString(actionRequest, "facebook_share",
				"0");
		String linkedin = ParamUtil.getString(actionRequest, "linkedin_share",
				"0");
		String twitter = ParamUtil.getString(actionRequest, "twitter_share",
				"0");
		String google = ParamUtil.getString(actionRequest, "google_share", "0");
		String yahoo = ParamUtil.getString(actionRequest, "yahoo_share", "0");

		String facebookPostApi = ParamUtil.getString(actionRequest,
				"facebook_api", "");
		String twitterPostApi = ParamUtil.getString(actionRequest,
				"twitter_api", "");
		String linkedinPostApi = ParamUtil.getString(actionRequest,
				"linkedin_api", "");

		if (signedIn) {

			if ("autoshare".equals(action)) {
				// remove preferences
				Map<String, String[]> preferences = prefs.getMap();

				for (Map.Entry<String, String[]> entry : preferences.entrySet()) {
					String key = entry.getKey();
					prefs.reset(key);
				}

				prefs.store();

				prefs.setValue("facebook", facebook);
				prefs.setValue("linkedin", linkedin);
				prefs.setValue("twitter", twitter);
				prefs.setValue("google", google);
				prefs.setValue("yahoo", yahoo);

				SocialSharingUtil.updateSPParameter(
						SocialPluginsConstants.FACEBOOK_SHARING, facebook,
						scopeGroupId);
				SocialSharingUtil.updateSPParameter(
						SocialPluginsConstants.LINKEDIN_SHARING, linkedin,
						scopeGroupId);
				SocialSharingUtil.updateSPParameter(
						SocialPluginsConstants.TWITTER_SHARING, twitter,
						scopeGroupId);
				SocialSharingUtil.updateSPParameter(
						SocialPluginsConstants.GOOGLE_SHARING, google,
						scopeGroupId);

				if (Validator.isNotNull(facebookPostApi)) {
					SocialSharingUtil.updateSPParameter(
							SocialPluginsConstants.FACEBOOK.POST,
							facebookPostApi, scopeGroupId);
				}

				if (Validator.isNotNull(twitterPostApi)) {
					SocialSharingUtil.updateSPParameter(
							SocialPluginsConstants.TWITTER.POST,
							twitterPostApi, scopeGroupId);
				}

				if (Validator.isNotNull(linkedinPostApi)) {
					SocialSharingUtil.updateSPParameter(
							SocialPluginsConstants.LINKEDIN.POST,
							linkedinPostApi, scopeGroupId);
				}

				actionResponse.setPortletMode(PortletMode.VIEW);
				prefs.store();
			}
		}

		super.processAction(actionRequest, actionResponse);
	}

	public SocialProfile updateSocialProfile(SocialProfile socialProfile,
			User user, Profile networkProfile, long groupId)
			throws PortalException, SystemException {
		long userId = socialProfile.getUserId();

		try {

			if (Validator.isNull(user)) {
				user = UserLocalServiceUtil.getUser(userId);
			}

			// date formatter
			SimpleDateFormat formatter = null;

			// update individual columns
			String location = networkProfile.getLocation();
			String about = networkProfile.getAbout();
			String firstName = networkProfile.getFirstname();
			String lastName = networkProfile.getLastname();
			String middleName = networkProfile.getMiddlename();
			String emailAddress = networkProfile.getEmail();
			String birthday = networkProfile.getBirthday();
			String gender = networkProfile.getGender();

			String resultXML = socialProfile.getUserInfo();

			if (Validator.isNotNull(location)) {
				resultXML = SocialProfileLocalServiceUtil
						.updateSingleNodeField(resultXML,
								"personal_info/location", location);
				socialProfile.setLocation(location);
			}

			if (Validator.isNotNull(about)) {
				resultXML = SocialProfileLocalServiceUtil
						.updateSingleNodeField(resultXML,
								"personal_info/about", about);
				socialProfile.setAbout(about);
			}

			if (Validator.isNotNull(firstName)) {
				resultXML = SocialProfileLocalServiceUtil
						.updateSingleNodeField(resultXML,
								"basic_info/first_name", firstName);
			}

			if (Validator.isNotNull(lastName)) {
				resultXML = SocialProfileLocalServiceUtil
						.updateSingleNodeField(resultXML,
								"basic_info/last_name", lastName);
			}

			socialProfile.setUserInfo(resultXML);// update xml
			SocialProfileLocalServiceUtil.updateSocialProfile(socialProfile);

			if (Validator.isNotNull(emailAddress)) {
				try {
					socialProfile = SocialProfileLocalServiceUtil
							.addNetworkInfo(socialProfile, "email",
									"email_url", emailAddress);
				} catch (Exception e) {
					_log.error(e.getMessage(), e);
				}
			}

			// delete all existing workhistory and replace with details from
			// social site

			List<Job> jobs = networkProfile.getWorkHistory();

			if (Validator.isNotNull(jobs) && (jobs.size() > 0)) {
				SocialProfileLocalServiceUtil
						.deleteAllWorkHistory(socialProfile);

				for (Job job : jobs) {
					String companyName = job.getCompanyName();
					String jobTitle = job.getPosition();
					String description = job.getDescription();
					Date startDate = job.getStartDate();
					Date endDate = job.getEndDate();
					formatter = new SimpleDateFormat("yyyy-MM");

					Map<String, String> workDetails = new HashMap<String, String>();
					workDetails.put("company_name", companyName);
					workDetails.put("job_title", jobTitle);
					workDetails.put("work_description", description);

					if (Validator.isNotNull(startDate))
						workDetails.put("start_date",
								formatter.format(startDate));

					if (Validator.isNotNull(endDate))
						workDetails.put("end_date", formatter.format(endDate));

					String instance = String.valueOf(new Date().getTime());

					SocialProfileLocalServiceUtil.addOrUpdateWorkHistory(
							"workhistory", "work_details", instance,
							socialProfile, groupId, workDetails);
				}
			}

			if (Validator.isNotNull(birthday)) {
				formatter = new SimpleDateFormat("MM/dd/yyyy");
				Date bday = (Date) formatter.parse(birthday);
				SocialProfileLocalServiceUtil.updateBirthday(user, bday);
			}

			if (Validator.isNotNull(gender)) {
				SocialProfileLocalServiceUtil.updateGender(user, gender);
			}

			if (Validator.isNotNull(firstName))
				user.setFirstName(firstName);

			if (Validator.isNotNull(lastName))
				user.setLastName(lastName);

			if (Validator.isNotNull(middleName))
				user.setMiddleName(middleName);

			user.setModifiedDate(new Date());

			UserLocalServiceUtil.updateUser(user);

			String pictureUrl = networkProfile.getPictureUrl();

			if (Validator.isNotNull(pictureUrl)) {
				SPSocialSharingLocalServiceUtil.saveProfileImage(pictureUrl,
						userId);
			}

		} catch (Exception e) {
			_log.error("Error encountered during profile pulling", e);
		}

		return socialProfile;
	}

	protected String getURL(HttpServletRequest httpRequest) {
		String siteURL = PortalUtil.getPortalURL(httpRequest);
		String currentUrl = PortalUtil.getCurrentURL(httpRequest);

		String page = StringUtil.extractFirst(currentUrl, '?');

		return (siteURL + page);
	}

	protected void sendJSONOutput(ResourceResponse response, String status,
			String message) {
		JSONArray jsonResult = com.liferay.portal.kernel.json.JSONFactoryUtil
				.createJSONArray();
		JSONObject jsonRow = com.liferay.portal.kernel.json.JSONFactoryUtil
				.createJSONObject();
		jsonRow.put("status", status);
		jsonRow.put("message", message);
		jsonResult.put(jsonRow);

		try {
			response.getWriter().append(jsonResult.toString());
		} catch (IOException e) {
			_log.error(e.getMessage(), e);
		}
	}

	private static Log _log = LogFactoryUtil
			.getLog(SocialPluginsActionBase.class);

}