package com.sambaash.platform.sociallogin.action;

import javax.portlet.PortletMode;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.FacebookApi;
import org.scribe.builder.api.FacebookCustomApi;
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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.sambaash.platform.sociallogin.util.SocialLoginConstants;
import com.sambaash.platform.sociallogin.util.SocialLoginUtils;
import com.sambaash.platform.util.SambaashUtil;

public class FacebookOAuthAction extends BaseStrutsAction {
	private static final int SOCIAL_NETWORK = 1;
	private static Log _log = LogFactoryUtil.getLog(FacebookOAuthAction.class);

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		_log.debug("Execute FacebookOAuthAction start");

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");

		long companyId = themeDisplay.getCompanyId();

		_log.debug("Obtaining Expando fields");

		String clientId = "";
		String clientSecret = "";

		boolean loginEnabled = false;

		loginEnabled = SocialLoginUtils.isLoginEnabled(companyId, SOCIAL_NETWORK);
		clientId = SocialLoginUtils.getClientId(companyId, SOCIAL_NETWORK);
		clientSecret = SocialLoginUtils.getClientSecret(companyId, SOCIAL_NETWORK);

		if (!loginEnabled) {
			String error = "Error. Facebook Login Disabled";
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
		String redirect = PortalUtil.getPortalURL(request) + SocialLoginConstants.FACEBOOK_REDIRECT_URI;

		if (Validator.isNull(state)) {
			state = SambaashUtil.getPostLoginRedirectUrl(themeDisplay, themeDisplay.getUserId());
		}

		request.getSession().setAttribute("postLoginRedirectUrl", state);

		if (cmd.equals("login")) {
			_log.debug("Facebook login process start");

			_log.debug("Create OAuth service object");

			OAuthService service = new ServiceBuilder().provider(FacebookApi.class).apiKey(clientId)
					.apiSecret(clientSecret).scope("email").callback(redirect).build();

			_log.debug("Get RequestToken");

			String authorizationUrl = service.getAuthorizationUrl(SocialLoginConstants.EMPTY_TOKEN);

			_log.debug("Send user to authorization url");

			response.sendRedirect(authorizationUrl);
		} else if (cmd.equals("token")) {
			_log.debug("Facebook login request token start");

			OAuthService service = new ServiceBuilder().provider(FacebookCustomApi.class).apiKey(clientId)
					.apiSecret(clientSecret).scope("email").callback(redirect).build();

			_log.debug("Recieve Verifier from Request");

			String verifier = request.getParameter("code");

			if (Validator.isNotNull(verifier)) {
				_log.debug("Verifier received succefully!");

				_log.debug("Trade the Request Token and Verfier for the Access Token : " + verifier);

				Token accessToken = service.getAccessToken(SocialLoginConstants.EMPTY_TOKEN, new Verifier(verifier));

				_log.debug("AccessToken Received");

				_log.debug("Request Facebook Resource URL");

				OAuthRequest oauthRequest = new OAuthRequest(Verb.GET, SocialLoginConstants.FACEBOOK_RESOURCE_URL);
				service.signRequest(accessToken, oauthRequest);
				Response oauthResponse = oauthRequest.send();

				_log.debug("Request done!");

				_log.debug("Parsing JSON response");

				JSONObject json = JSONFactoryUtil.createJSONObject(oauthResponse.getBody());

				_log.debug("JSON response : " + json.toString());

				String firstName = json.getString(SocialLoginConstants.FACEBOOK_FIELD_FIRSTNAME);
				String lastName = json.getString(SocialLoginConstants.FACEBOOK_FIELD_LASTNAME);
				String emailAddress = json.getString(SocialLoginConstants.FACEBOOK_FIELD_EMAIL);
				// String id = json.getString("id");
				String profileUrl = json.getString("link");

				JSONObject picture = json.getJSONObject(SocialLoginConstants.FACEBOOK_FIELD_PICTURE);
				String pictureUrl = picture.getJSONObject("data").getString("url");

				// String picR =
				// "https://graph.facebook.com/{id}/picture?width=9999";
				// pictureUrl = picR.replace("{id}", id);

				_log.debug("Obtain Liferay User");

				HttpSession session = request.getSession();

				User user = getLiferayUserByFacebook(request, session, companyId, emailAddress, firstName, lastName,
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

	protected User getLiferayUserByFacebook(HttpServletRequest request, HttpSession session, long companyId,
			String emailAddress, String firstName, String lastName, String gender, String pictureUrl, String profileUrl)
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
				session.setAttribute(SocialLoginConstants.FACEBOOK_SESSION_ATTRIBUTE_EMAIL, emailAddress);
			}

			_log.debug("User found, Updating");

			user = SocialLoginUtils.updateUser(user, emailAddress, firstName, lastName, gender, pictureUrl, profileUrl);
		} else {
			_log.debug("User not found, Creating");

			user = SocialLoginUtils.addUser(session, companyId, emailAddress, firstName, lastName, gender,
					SocialLoginConstants.FACEBOOK_SESSION_ATTRIBUTE_EMAIL, pictureUrl, profileUrl);
		}

		SambaashUtil.sendWelcomeEmail(request, user);

		return user;
	}

	protected void sendLoginRedirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");

		PortletURL portletURL = PortletURLFactoryUtil.create(request, "164", themeDisplay.getPlid(), "RENDER_PHASE");

		String state = (String) request.getSession().getAttribute("postLoginRedirectUrl");

		portletURL.setWindowState(LiferayWindowState.POP_UP);

		portletURL.setParameter("struts_action", "/login/login_redirect");

		if (Validator.isNotNull(state)) {
			portletURL.setParameter("redirect", state);
		}

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