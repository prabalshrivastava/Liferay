package com.sambaash.platform.sociallogin.action;

import javax.portlet.PortletMode;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthBearerClientRequest;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthAuthzResponse;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.client.response.OAuthResourceResponse;
import org.apache.oltu.oauth2.common.OAuthProviderType;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.apache.oltu.oauth2.common.message.types.ResponseType;

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

public class GoogleOAuthAction extends BaseStrutsAction {
	public static final int SOCIAL_NETWORK = 0;
	private static Log _log = LogFactoryUtil.getLog(GoogleOAuthAction.class);

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		_log.error("Execute GoogleAuthAction Start");

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");

		long companyId = themeDisplay.getCompanyId();

		_log.error("Obtaining Expando fields");

		String clientId = StringPool.BLANK;
		String clientSecret = StringPool.BLANK;
		String hostedDomain = StringPool.BLANK;

		boolean loginEnabled = SocialLoginUtils.isLoginEnabled(companyId, SOCIAL_NETWORK);
		clientId = SocialLoginUtils.getClientId(companyId, SOCIAL_NETWORK);
		clientSecret = SocialLoginUtils.getClientSecret(companyId, SOCIAL_NETWORK);
		hostedDomain = SocialLoginUtils.getGoogleLoginHostedDomain(companyId);

		String allowedDomain = Validator.isNotNull(hostedDomain) ? "&hd=" + hostedDomain : StringPool.BLANK;

		if (!loginEnabled) {
			String error = "Error. Google Login Disabled";
			_log.error(error);
			throw new Exception(error);
		}

		if ((Validator.isNull(clientId)) || (Validator.isNull(clientSecret))) {
			_log.error(SocialLoginConstants.ERROR_CLIENT_ID_SECRET_KEY);
			throw new Exception(SocialLoginConstants.ERROR_CLIENT_ID_SECRET_KEY);
		}

		_log.error("Using CLIENT ID => " + clientId);
		_log.error("Using CLIENT SECRET => " + clientSecret);

		String cmd = ParamUtil.getString(request, "cmd");

		String scope = SocialLoginConstants.GOOGLE_SCOPES_LOGIN_EMAIL + StringPool.SPACE
				+ SocialLoginConstants.GOOGLE_SCOPES_LOGIN_PROFILE;

		String redirect = PortalUtil.getPortalURL(request) + SocialLoginConstants.GOOGLE_REDIRECT_URI;
		String state = ParamUtil.getString(request, "redirect");

		if (Validator.isNull(state)) {
			state = SambaashUtil.getPostLoginRedirectUrl(themeDisplay, themeDisplay.getUserId());
		}

		if (cmd.equals("login")) {
			_log.error("Google Login process Start");

			_log.error("Create OAuth service object");

			OAuthClientRequest clientRequest = OAuthClientRequest.authorizationProvider(OAuthProviderType.GOOGLE)
					.setClientId(clientId).setResponseType(ResponseType.CODE.toString()).setRedirectURI(redirect)
					.setScope(scope).setState(state).buildQueryMessage();
			_log.error("Send user to authorization URL : " + clientRequest.getLocationUri() + allowedDomain);

			response.sendRedirect(clientRequest.getLocationUri() + allowedDomain);
		} else if (cmd.equals("token")) {
			_log.error("Google Login request token Start");

			OAuthAuthzResponse oar = OAuthAuthzResponse.oauthCodeAuthzResponse(request);
			String code = oar.getCode();

			_log.error("Recieve Verifier from Request");

			if (Validator.isNotNull(code)) {
				_log.error("Verifier received succefully!");

				_log.error("Trade the Request Token and Verfier for the Access Token");

				OAuthClientRequest accessRequest = OAuthClientRequest.tokenProvider(OAuthProviderType.GOOGLE)
						.setGrantType(GrantType.AUTHORIZATION_CODE).setClientId(clientId).setClientSecret(clientSecret)
						.setRedirectURI(redirect).setCode(code).buildBodyMessage();

				OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
				OAuthJSONAccessTokenResponse oAuthResponse = oAuthClient.accessToken(accessRequest, "POST");

				String accessToken = oAuthResponse.getAccessToken();
				// Long expiresIn = oAuthResponse.getExpiresIn();

				_log.error("AccessToken Received");

				_log.error("Request Google Resource URL");

				OAuthClientRequest bearerClientRequest = new OAuthBearerClientRequest(
						SocialLoginConstants.GOOGLE_RESOURCE_URL).setAccessToken(accessToken).buildQueryMessage();

				OAuthResourceResponse resourceResponse = (OAuthResourceResponse) oAuthClient.resource(
						bearerClientRequest, "GET", OAuthResourceResponse.class);
				String strBody = resourceResponse.getBody();

				_log.error("Request done!");

				_log.error("Parsing JSON response");

				HttpSession session = request.getSession();
				JSONObject json = JSONFactoryUtil.createJSONObject(strBody);

				_log.error("JSON response : " + json.toString());

				String emailAddress = json.getString(SocialLoginConstants.GOOGLE_FIELD_EMAIL);
				String firstName = json.getString(SocialLoginConstants.GOOGLE_FIELD_FIRSTNAME);
				String lastName = json.getString(SocialLoginConstants.GOOGLE_FIELD_LASTNAME);
				String gender = json.getString(SocialLoginConstants.GOOGLE_FIELD_GENDER);
				String picture = json.getString(SocialLoginConstants.GOOGLE_FIELD_PICTURE);
				String profileUrl = json.getString("link");

				_log.error("Obtain Liferay User");

				User user = getLiferayUserByGoogle(request, session, companyId, emailAddress, firstName, lastName,
						gender, picture, profileUrl, hostedDomain);

				if ((Validator.isNotNull(user)) && (user.getStatus() == 6)) {
					redirectUpdateAccount(request, response, user);
					return null;
				}

				_log.error("Redirect to login");

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

	protected User getLiferayUserByGoogle(HttpServletRequest request, HttpSession session, long companyId,
			String emailAddress, String firstName, String lastName, String gender, String pictureUrl,
			String profileUrl, String allowedDomain) throws Exception {
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
				session.setAttribute(SocialLoginConstants.GOOGLE_SESSION_ATTRIBUTE_EMAIL, emailAddress);
			}

			if (emailAddress.contains(allowedDomain) || allowedDomain == "") {
				_log.error("User found, Updating");
				user = SocialLoginUtils.updateUser(user, emailAddress, firstName, lastName, gender, pictureUrl,
						profileUrl);
			} else {
				_log.error("User email Id does not match the permitted domain");
			}
			// user = SocialLoginUtils.updateUser(user, emailAddress, firstName,
			// lastName, gender, pictureUrl, profileUrl);
		} else {
			if (emailAddress.contains(allowedDomain) || allowedDomain == "") {
				_log.error("User not found, Creating");
				user = SocialLoginUtils.addUser(session, companyId, emailAddress, firstName, lastName, gender,
						SocialLoginConstants.GOOGLE_SESSION_ATTRIBUTE_EMAIL, pictureUrl, profileUrl);
			} else {
				_log.error("User email Id does not match the permitted domain");
			}
			// user = SocialLoginUtils.addUser(session, companyId, emailAddress,
			// firstName, lastName, gender,
			// SocialLoginConstants.GOOGLE_SESSION_ATTRIBUTE_EMAIL, pictureUrl,
			// profileUrl);
		}

		SambaashUtil.sendWelcomeEmail(request, user);

		return user;
	}

	protected void sendLoginRedirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");

		PortletURL portletURL = PortletURLFactoryUtil.create(request, "58", themeDisplay.getPlid(), "RENDER_PHASE");

		portletURL.setWindowState(LiferayWindowState.POP_UP);

		String state = ParamUtil.getString(request, "state");

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