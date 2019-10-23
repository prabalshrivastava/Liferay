package com.sambaash.platform.sociallogin.action;

import javax.portlet.PortletMode;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.LiveApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.sambaash.platform.sociallogin.util.SocialLoginConstants;
import com.sambaash.platform.sociallogin.util.SocialLoginUtils;
import com.sambaash.platform.util.SambaashUtil;

public class MicrosoftOAuthActionToken extends BaseStrutsAction {
	private static final int SOCIAL_NETWORK = 4;
	private static Log _log = LogFactoryUtil
			.getLog(MicrosoftOAuthActionToken.class);

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		_log.debug("Microsoft login request token start");

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");

		long companyId = themeDisplay.getCompanyId();

		String clientId = StringPool.BLANK;
		String clientSecret = StringPool.BLANK;

		boolean loginEnabled = false;

		loginEnabled = SocialLoginUtils.isLoginEnabled(companyId,
				SOCIAL_NETWORK);
		clientId = SocialLoginUtils.getClientId(companyId, SOCIAL_NETWORK);
		clientSecret = SocialLoginUtils.getClientSecret(companyId,
				SOCIAL_NETWORK);
		_log.debug("Using Instance Portal Settings");

		if (!loginEnabled) {
			String error = "Error. Microsoft Login Disabled";
			_log.error(error);
			throw new Exception(error);
		}

		if ((Validator.isNull(clientId)) || (Validator.isNull(clientSecret))) {
			_log.error(SocialLoginConstants.ERROR_CLIENT_ID_SECRET_KEY);
			throw new Exception(SocialLoginConstants.ERROR_CLIENT_ID_SECRET_KEY);
		}

		_log.debug("Using CLIENT ID => " + clientId);
		_log.debug("Using CLIENT SECRET => " + clientSecret);

		String redirect = PortalUtil.getPortalURL(request)
				+ SocialLoginConstants.MICROSOFT_REDIRECT_URI;

		OAuthService service = new ServiceBuilder().provider(LiveApi.class)
				.apiKey(clientId).apiSecret(clientSecret)
				.scope("wl.basic wl.emails").callback(redirect).build();

		_log.debug("Recieve Verifier from Request");

		String verifier = request.getParameter("code");

		if (Validator.isNotNull(verifier)) {
			_log.debug("Verifier received succefully!");

			_log.debug("Trade the Request Token and Verfier for the Access Token");

			Token accessToken = service.getAccessToken(
					SocialLoginConstants.EMPTY_TOKEN, new Verifier(verifier));

			_log.debug("AccessToken Received");

			_log.debug("Microsoft Resource URL");

			OAuthRequest resourceRequest = new OAuthRequest(Verb.GET,
					SocialLoginConstants.MICROSOFT_RESOURCE_URL);
			resourceRequest.addHeader("access_token", accessToken.getToken());
			service.signRequest(accessToken, resourceRequest);
			Response resourceResponse = resourceRequest.send();
			String strBody = resourceResponse.getBody();

			_log.debug("Request done!");

			_log.debug("Parsing JSON response");

			JSONObject json = JSONFactoryUtil.createJSONObject(strBody);

			_log.debug("json : " + json.toString());

			JSONObject jsonEmails = JSONFactoryUtil.createJSONObject(json
					.getString(SocialLoginConstants.MICROSOFT_FIELD_EMAIL));

			String emailAddress = jsonEmails
					.getString(SocialLoginConstants.MICROSOFT_FIELD_EMAIL_ACCOUNT);
			String firstName = json
					.getString(SocialLoginConstants.MICROSOFT_FIELD_FIRSTNAME);
			String lastName = json
					.getString(SocialLoginConstants.MICROSOFT_FIELD_LASTNAME);

			_log.debug("Obtain Liferay User");

			HttpSession session = request.getSession();

			User user = getLiferayUserByMicrosoft(request, session, companyId,
					emailAddress, firstName, lastName, null, StringPool.BLANK,
					StringPool.BLANK);

			if ((Validator.isNotNull(user)) && (user.getStatus() == 6)) {
				redirectUpdateAccount(request, response, user);
				return null;
			}

			_log.debug("Redirect to login");

			sendLoginRedirect(request, response);

			return null;
		}

		String error = ParamUtil.getString(request, "error");

		if (error.equals("access_denied")) {
			_log.error("Access Denied");

			sendLoginRedirect(request, response);

			return null;
		}

		return super.execute(request, response);
	}

	protected User getLiferayUserByMicrosoft(HttpServletRequest request, HttpSession session,
			long companyId, String emailAddress, String firstName,
			String lastName, String gender, String pictureUrl, String profileUrl)
			throws Exception {
		if (Validator.isNull(emailAddress)) {
			return null;
		}

		User user = UserLocalServiceUtil.fetchUserByEmailAddress(companyId,
				emailAddress);

		if (user != null) {
			if (user.getStatus() == 6) {
				user.setEmailAddress(emailAddress);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				return user;
			} else {
				session.setAttribute(
						SocialLoginConstants.MICROSOFT_SESSION_ATTRIBUTE_EMAIL,
						emailAddress);
			}

			_log.debug("User found, Updating");

			user = SocialLoginUtils.updateUser(user, emailAddress, firstName,
					lastName, gender, pictureUrl, profileUrl);
		} else {
			_log.debug("User not found, Creating");
			user = SocialLoginUtils.addUser(session, companyId, emailAddress,
					firstName, lastName, gender,
					SocialLoginConstants.MICROSOFT_SESSION_ATTRIBUTE_EMAIL,
					pictureUrl, profileUrl);
		}

		SambaashUtil.sendWelcomeEmail(request, user);
		
		return user;
	}

	protected void sendLoginRedirect(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");

		PortletURL portletURL = PortletURLFactoryUtil.create(request, "164",
				themeDisplay.getPlid(), "RENDER_PHASE");

		portletURL.setWindowState(LiferayWindowState.POP_UP);

		portletURL.setParameter("struts_action", "/login/login_redirect");

		response.sendRedirect(portletURL.toString());
	}

	protected void redirectUpdateAccount(HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");

		PortletURL portletURL = PortletURLFactoryUtil.create(request, "58",
				themeDisplay.getPlid(), "RENDER_PHASE");

		portletURL.setParameter("saveLastPath", Boolean.FALSE.toString());
		portletURL.setParameter("struts_action", "/login/update_account");

		PortletURL redirectURL = PortletURLFactoryUtil.create(request, "164",
				themeDisplay.getPlid(), "RENDER_PHASE");

		redirectURL.setParameter("struts_action", "/login/login_redirect");
		redirectURL.setParameter("emailAddress", user.getEmailAddress());
		redirectURL.setParameter("anonymousUser", Boolean.FALSE.toString());
		redirectURL.setPortletMode(PortletMode.VIEW);
		redirectURL.setWindowState(LiferayWindowState.POP_UP);

		portletURL.setParameter("redirect", redirectURL.toString());
		portletURL.setParameter("userId", String.valueOf(user.getUserId()));
		portletURL.setParameter("emailAddress", user.getEmailAddress());
		portletURL.setParameter("firstName", user.getFirstName());
		portletURL.setParameter("lastName", user.getLastName());
		portletURL.setPortletMode(PortletMode.VIEW);
		portletURL.setWindowState(LiferayWindowState.POP_UP);

		response.sendRedirect(portletURL.toString());
	}
}