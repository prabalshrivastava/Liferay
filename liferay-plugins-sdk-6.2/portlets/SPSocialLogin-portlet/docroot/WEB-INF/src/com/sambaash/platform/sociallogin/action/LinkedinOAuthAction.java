package com.sambaash.platform.sociallogin.action;

import javax.portlet.PortletMode;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.LinkedInApi;
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
import com.liferay.portal.kernel.util.HttpUtil;
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

public class LinkedinOAuthAction extends BaseStrutsAction {
	private static final int SOCIAL_NETWORK = 3;
	private static Log _log = LogFactoryUtil.getLog(LinkedinOAuthAction.class);

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		_log.debug("Execute LinkedinOAuthAction start");

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");

		long companyId = themeDisplay.getCompanyId();

		_log.debug("Obtaining Expando fields");

		String clientId = StringPool.BLANK;
		String clientSecret = StringPool.BLANK;

		boolean loginEnabled = false;

		loginEnabled = SocialLoginUtils.isLoginEnabled(companyId, SOCIAL_NETWORK);
		clientId = SocialLoginUtils.getClientId(companyId, 3);
		clientSecret = SocialLoginUtils.getClientSecret(companyId, SOCIAL_NETWORK);
		_log.debug("Using Instance Portal Settings");

		if (!loginEnabled) {
			String error = "Error. Linkedin Login Disabled";
			_log.error(error);
			throw new Exception(error);
		}

		if ((Validator.isNull(clientId)) || (Validator.isNull(clientSecret))) {
			_log.error(SocialLoginConstants.ERROR_CLIENT_ID_SECRET_KEY);
			throw new Exception(SocialLoginConstants.ERROR_CLIENT_ID_SECRET_KEY);
		}

		_log.debug("Using CLIENT ID => " + clientId);
		_log.debug("Using CLIENT SECRET => " + clientSecret);

		String cmd = ParamUtil.getString(request, "cmd");

		String state = ParamUtil.getString(request, "redirect");

		String redirect = PortalUtil.getPortalURL(request) + SocialLoginConstants.LINKEDIN_REDIRECT_URI + "&state=";

		if (Validator.isNotNull(state)) {
			redirect += state;
		} else {
			redirect += SambaashUtil.getPostLoginRedirectUrl(themeDisplay, themeDisplay.getUserId());
		}

		if (cmd.equals("login")) {
			_log.debug("Linkedin login process start");

			_log.debug("Create OAuth service object");

			OAuthService service = new ServiceBuilder().provider(LinkedInApi.class).apiKey(clientId)
					.apiSecret(clientSecret).scope(SocialLoginConstants.LINKEDIN_SCOPES_LOGIN).callback(redirect)
					.build();

			_log.debug("Get RequestToken");

			Token requestToken = service.getRequestToken();

			_log.debug("Send user to authorization url");

			response.sendRedirect(service.getAuthorizationUrl(requestToken));

			request.getSession().setAttribute("requestToken", requestToken);
		} else if (cmd.equals("token")) {
			_log.debug("Linkedin login request token start");

			OAuthService service = new ServiceBuilder().provider(LinkedInApi.class).apiKey(clientId)
					.apiSecret(clientSecret).scope("r_fullprofile r_emailaddress").build();

			_log.debug("Recieve Verifier from Request");

			Token requestToken = (Token) request.getSession().getAttribute("requestToken");

			String verifier = request.getParameter("oauth_verifier");

			if ((Validator.isNotNull(requestToken) & Validator.isNotNull(verifier))) {
				_log.debug("Verifier received succefully!");

				_log.debug("Trade the Request Token and Verfier for the Access Token");

				Token accessToken = service.getAccessToken(requestToken, new Verifier(verifier));

				_log.debug("AccessToken Received");

				_log.debug("Linkedin Resource URL");

				OAuthRequest resourceRequest = new OAuthRequest(Verb.GET, HttpUtil.addParameter(
						SocialLoginConstants.LINKEDIN_RESOURCE_URL1, "format", "json"));
				service.signRequest(accessToken, resourceRequest);
				Response resourceResponse = resourceRequest.send();
				JSONObject json1 = JSONFactoryUtil.createJSONObject(resourceResponse.getBody());

				_log.debug("json1 response : " + json1.toString());

				OAuthRequest resourceRequest2 = new OAuthRequest(Verb.GET, HttpUtil.addParameter(
						SocialLoginConstants.LINKEDIN_RESOURCE_URL2, "format", "json"));
				service.signRequest(accessToken, resourceRequest2);
				Response resourceResponse2 = resourceRequest2.send();
				String emailAddress = resourceResponse2.getBody();
				emailAddress = emailAddress.replaceAll("\"", StringPool.BLANK);

				_log.debug("Request done!");

				_log.debug("Parsing JSON response");

				String firstName = json1.getString(SocialLoginConstants.LINKEDIN_FIELD_FIRSTNAME);
				String lastName = json1.getString(SocialLoginConstants.LINKEDIN_FIELD_LASTNAME);
				String pictureUrl = json1.getString(SocialLoginConstants.LINKEDIN_FIELD_PICTURE);

				JSONObject picture = json1.getJSONObject("pictureUrls");

				String profileUrl = picture.getString("values");

				_log.debug("Obtain Liferay User");

				HttpSession session = request.getSession();

				User user = getLiferayUserByLinkedin(request, session, companyId, emailAddress, firstName, lastName,
						null, pictureUrl, profileUrl);

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
				_log.error("Access denied");

				sendLoginRedirect(request, response);

				return null;
			}
		}

		return super.execute(request, response);
	}

	protected User getLiferayUserByLinkedin(HttpServletRequest request, HttpSession session, long companyId,
			String emailAddress, String firstName, String lastName, String gender, String pictureurl, String profileUrl)
			throws Exception {
		if (Validator.isNull(emailAddress)) {
			return null;
		}

		User user = UserLocalServiceUtil.fetchUserByEmailAddress(companyId, emailAddress);

		if (user != null) {

			if (user.getStatus() == 6) {
				user.setEmailAddress(emailAddress);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				return user;
			} else {
				session.setAttribute(SocialLoginConstants.LINKEDIN_SESSION_ATTRIBUTE_EMAIL, emailAddress);
			}

			_log.debug("User found, Updating");

			user = SocialLoginUtils.updateUser(user, emailAddress, firstName, lastName, gender, pictureurl, profileUrl);
		} else {
			_log.debug("User not found, Creating");

			user = SocialLoginUtils.addUser(session, companyId, emailAddress, firstName, lastName, gender,
					SocialLoginConstants.LINKEDIN_SESSION_ATTRIBUTE_EMAIL, pictureurl, profileUrl);
		}

		SambaashUtil.sendWelcomeEmail(request, user);

		return user;
	}

	protected void sendLoginRedirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");

		PortletURL portletURL = PortletURLFactoryUtil.create(request, "164", themeDisplay.getPlid(), "RENDER_PHASE");

		String state = ParamUtil.getString(request, "state");

		portletURL.setWindowState(LiferayWindowState.POP_UP);

		portletURL.setParameter("struts_action", "/login/login_redirect");

		portletURL.setParameter("redirect", state);

		response.sendRedirect(portletURL.toString());
	}

	protected void redirectUpdateAccount(HttpServletRequest request, HttpServletResponse response, User user)
			throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");

		PortletURL portletURL = PortletURLFactoryUtil.create(request, "58", themeDisplay.getPlid(), "RENDER_PHASE");

		portletURL.setParameter("saveLastPath", Boolean.FALSE.toString());
		portletURL.setParameter("struts_action", "/login/update_account");

		PortletURL redirectURL = PortletURLFactoryUtil.create(request, "164", themeDisplay.getPlid(), "RENDER_PHASE");

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