package com.sambaash.platform.sociallogin.action;

import java.util.List;
import java.util.Scanner;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
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
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.sambaash.platform.sociallogin.util.SocialLoginConstants;
import com.sambaash.platform.sociallogin.util.SocialLoginUtils;
import com.sambaash.platform.util.SambaashUtil;

public class TwitterOAuthAction extends BaseStrutsAction {
	public static final int SOCIAL_NETWORK = 2;
	private static Log _log = LogFactoryUtil.getLog(TwitterOAuthAction.class);

	@SuppressWarnings("resource")
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		_log.debug("Execute TwitterOAuthAction start");

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");

		long companyId = themeDisplay.getCompanyId();

		_log.debug("Obtaining Expando fields");

		String clientId = StringPool.BLANK;
		String clientSecret = StringPool.BLANK;

		boolean loginEnabled = false;

		loginEnabled = SocialLoginUtils.isLoginEnabled(companyId, SOCIAL_NETWORK);
		clientId = SocialLoginUtils.getClientId(companyId, SOCIAL_NETWORK);
		clientSecret = SocialLoginUtils.getClientSecret(companyId, SOCIAL_NETWORK);
		_log.debug("Using Instance Portal Settings");

		if (!loginEnabled) {
			String error = "Error. Twitter Login Disabled";
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

		String redirect = PortalUtil.getPortalURL(request) + SocialLoginConstants.TWITTER_REDIRECT_URI;

		if (cmd.equals("login")) {
			_log.debug("Twitter Login process Start");

			_log.debug("Create OAuth service object");

			OAuthService service = new ServiceBuilder().provider(TwitterApi.class).apiKey(clientId)
					.apiSecret(clientSecret).callback(redirect).build();

			_log.debug("Get RequestToken");

			Token requestToken = service.getRequestToken();

			_log.debug("Send user to authorization url");

			response.sendRedirect(service.getAuthorizationUrl(requestToken));

			request.getSession().setAttribute("requestToken", requestToken);
		} else if (cmd.equals("token")) {
			_log.debug("Twitter login request token start");

			OAuthService service = new ServiceBuilder().provider(TwitterApi.class).apiKey(clientId)
					.apiSecret(clientSecret).build();

			_log.debug("Recieve Verifier from Request");

			Token requestToken = (Token) request.getSession().getAttribute("requestToken");

			String verifier = request.getParameter("oauth_verifier");

			if ((Validator.isNotNull(requestToken) & Validator.isNotNull(verifier))) {
				_log.debug("Verifier received succefully!");

				_log.debug("Trade the Request Token and Verfier for the Access Token");

				Token accessToken = service.getAccessToken(requestToken, new Verifier(verifier));

				_log.debug("AccessToken Received");

				_log.debug("Request Twitter Resource URL");

				OAuthRequest resourceRequest = new OAuthRequest(Verb.GET, SocialLoginConstants.TWITTER_RESOURCE_URL);
				service.signRequest(accessToken, resourceRequest);
				Response resourceResponse = resourceRequest.send();
				String strBody = resourceResponse.getBody();

				_log.debug("Request done!");

				_log.debug("Parsing JSON response");

				JSONObject json = JSONFactoryUtil.createJSONObject(strBody);

				_log.debug(" JSON response : " + json.toString());

				String completeName = json.getString("name");

				String firstName = StringPool.BLANK;
				StringBuilder lastNameBuilder = new StringBuilder();
				Scanner tokenizer = new Scanner(completeName);
				boolean first = true;
				while (tokenizer.hasNext()) {
					if (first) {
						firstName = tokenizer.next();
						first = false;
					} else {
						lastNameBuilder.append(tokenizer.next() + " ");
					}
				}

				String lastName = lastNameBuilder.toString().trim();
				String screenName = json.getString(SocialLoginConstants.TWITTER_FIELD_SCREENNAME);
				String twitterId = json.getString(SocialLoginConstants.TWITTER_FIELD_TWITTERID);
				String pictureUrl = json.getString(SocialLoginConstants.TWITTER_FIELD_PICTURE);
				pictureUrl = pictureUrl.replace("_normal", StringPool.BLANK);

				_log.debug("pictureUrl : " + pictureUrl);

				_log.debug("Obtain Liferay User");

				ExpandoTable expandoTable = ExpandoTableLocalServiceUtil.getTable(themeDisplay.getCompanyId(),
						User.class.getName(), SocialLoginConstants.SOCIALLOGIN_EXPANDO_TABLE);

				ExpandoColumn expandoColumn = ExpandoColumnLocalServiceUtil.getColumn(expandoTable.getTableId(),
						SocialLoginConstants.TWITTER_USER_ID);

				List<ExpandoValue> expandoValues = ExpandoValueLocalServiceUtil.getColumnValues(
						expandoColumn.getCompanyId(), User.class.getName(),
						SocialLoginConstants.SOCIALLOGIN_EXPANDO_TABLE, SocialLoginConstants.TWITTER_USER_ID,
						twitterId, -1, -1);

				HttpSession session = request.getSession();

				int usersCount = expandoValues.size();

				if (usersCount == 1) {
					_log.debug("Twitter user found");

					ExpandoValue expandoValue = (ExpandoValue) expandoValues.get(0);

					long userId = expandoValue.getClassPK();

					User user = UserLocalServiceUtil.getUser(userId);

					if (Validator.isNotNull(user)) {
						SambaashUtil.sendWelcomeEmail(request, user);
					}

					session.setAttribute(SocialLoginConstants.TWITTER_SESSION_ATTRIBUTE_ID,
							Long.valueOf(user.getUserId()));

					_log.debug("Send to Login");

					sendLoginRedirect(request, response);
				} else if (usersCount > 1) {
					_log.debug("More than 1 user with this twitter id... ");
				} else {
					_log.debug("Twitter user not found. Create for the first time");

					session.setAttribute(SocialLoginConstants.TWITTER_SESSION_LOGINPENDING, Boolean.TRUE);

					redirectCreateAccount(request, response, themeDisplay, firstName, lastName, screenName, twitterId,
							pictureUrl);
				}
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

	protected void redirectCreateAccount(HttpServletRequest request, HttpServletResponse response,
			ThemeDisplay themeDisplay, String firstName, String lastName, String screenName, String twitterId,
			String pictureUrl) throws Exception {

		String createAccountURL = PortalUtil.getCreateAccountURL(request, themeDisplay);

		createAccountURL = HttpUtil.setParameter(createAccountURL, SocialLoginConstants.TWITTER_FIELD_FIRSTNAME,
				firstName);
		createAccountURL = HttpUtil.setParameter(createAccountURL, SocialLoginConstants.TWITTER_FIELD_LASTNAME,
				lastName);
		createAccountURL = HttpUtil.setParameter(createAccountURL, SocialLoginConstants.TWITTER_FIELD_SCREENNAME,
				screenName);
		createAccountURL = HttpUtil.setParameter(createAccountURL, SocialLoginConstants.TWITTERID, twitterId);
		createAccountURL = HttpUtil.setParameter(createAccountURL, SocialLoginConstants.TWITTER_FIELD_PICTURE_URL,
				pictureUrl);

		response.sendRedirect(createAccountURL);
	}

	protected void sendLoginRedirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");

		PortletURL portletURL = PortletURLFactoryUtil.create(request, "164", themeDisplay.getPlid(), "RENDER_PHASE");

		portletURL.setWindowState(LiferayWindowState.POP_UP);

		portletURL.setParameter("struts_action", "/login/login_redirect");

		response.sendRedirect(portletURL.toString());
	}
}