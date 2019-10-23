package com.sambaash.platform.sociallogin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.LiveApi;
import org.scribe.oauth.OAuthService;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.sociallogin.util.SocialLoginConstants;
import com.sambaash.platform.sociallogin.util.SocialLoginUtils;

public class MicrosoftOAuthActionCmd extends BaseStrutsAction {
	private static final int SOCIAL_NETWORK = 4;
	private static Log _log = LogFactoryUtil
			.getLog(MicrosoftOAuthActionCmd.class);

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		_log.debug("Execute MicrosoftOAuthAction start");

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");

		long companyId = themeDisplay.getCompanyId();


		_log.debug("Obtaining Expando fields");

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
				+ "/c/portal/microsoft_social_login_token";

		_log.debug("Microsoft login process start");

		_log.debug("Create OAuth service object");

		OAuthService service = new ServiceBuilder().provider(LiveApi.class)
				.apiKey(clientId).apiSecret(clientSecret)
				.scope("wl.emails wl.basic").callback(redirect).build();

		_log.debug("Send user to authorization url");

		response.sendRedirect(service
				.getAuthorizationUrl(SocialLoginConstants.EMPTY_TOKEN));

		return super.execute(request, response);
	}
}