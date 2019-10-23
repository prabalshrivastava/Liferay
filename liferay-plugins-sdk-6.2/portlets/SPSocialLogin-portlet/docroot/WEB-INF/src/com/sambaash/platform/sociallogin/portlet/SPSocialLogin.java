package com.sambaash.platform.sociallogin.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Company;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.sociallogin.util.SocialLoginConstants;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class SPSocialLogin
 */
public class SPSocialLogin extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(SPSocialLogin.class);
	
	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");
		long companyId = themeDisplay.getCompanyId();

		String socialLoginSkin = ParamUtil.getString(actionRequest, "skin");

		if (Validator.isNull(socialLoginSkin)) {
			socialLoginSkin = SocialLoginConstants.SOCIALLOGIN_SKIN_TYPE_1;
		}

		boolean socialLoginSkinEnableLiferayLogin = ParamUtil.getBoolean(actionRequest, "enableLiferayLogin");

		boolean googleLoginEnabled = ParamUtil.getBoolean(actionRequest, SocialLoginConstants.GOOGLE_LOGIN_ENABLED);
		String googleLoginClientId = ParamUtil.getString(actionRequest, SocialLoginConstants.GOOGLE_LOGIN_CLIENT_ID);
		String googleLoginClientSecret = ParamUtil.getString(actionRequest,
				SocialLoginConstants.GOOGLE_LOGIN_CLIENT_SECRET);

		String googleLoginHostedDomain = ParamUtil.getString(actionRequest,
				SocialLoginConstants.GOOGLE_LOGIN_HOSTED_DOMAIN);

		boolean facebookLoginEnabled = ParamUtil.getBoolean(actionRequest, SocialLoginConstants.FACEBOOK_LOGIN_ENABLED);
		String facebookLoginClientId = ParamUtil.getString(actionRequest,
				SocialLoginConstants.FACEBOOK_LOGIN_CLIENT_ID);
		String facebookLoginClientSecret = ParamUtil.getString(actionRequest,
				SocialLoginConstants.FACEBOOK_LOGIN_CLIENT_SECRET);

		boolean twitterLoginEnabled = ParamUtil.getBoolean(actionRequest, SocialLoginConstants.TWITTER_LOGIN_ENABLED);
		String twitterLoginClientId = ParamUtil.getString(actionRequest, SocialLoginConstants.TWITTER_LOGIN_CLIENT_ID);
		String twitterLoginClientSecret = ParamUtil.getString(actionRequest,
				SocialLoginConstants.TWITTER_LOGIN_CLIENT_SECRET);

		boolean linkedinLoginEnabled = ParamUtil.getBoolean(actionRequest, SocialLoginConstants.LINKEDIN_LOGIN_ENABLED);
		String linkedinLoginClientId = ParamUtil.getString(actionRequest,
				SocialLoginConstants.LINKEDIN_LOGIN_CLIENT_ID);
		String linkedinLoginClientSecret = ParamUtil.getString(actionRequest,
				SocialLoginConstants.LINKEDIN_LOGIN_CLIENT_SECRET);

		boolean microsoftLoginEnabled = ParamUtil.getBoolean(actionRequest,
				SocialLoginConstants.MICROSOFT_LOGIN_ENABLED);
		String microsoftLoginClientId = ParamUtil.getString(actionRequest,
				SocialLoginConstants.MICROSOFT_LOGIN_CLIENT_ID);
		String microsoftLoginClientSecret = ParamUtil.getString(actionRequest,
				SocialLoginConstants.MICROSOFT_LOGIN_CLIENT_SECRET);
		try {

			setExpandoValue(companyId, "skin", socialLoginSkin);
			setExpandoValue(companyId, "enableLiferayLogin", socialLoginSkinEnableLiferayLogin);

			setExpandoValue(companyId, SocialLoginConstants.GOOGLE_LOGIN_ENABLED, googleLoginEnabled);
			setExpandoValue(companyId, SocialLoginConstants.GOOGLE_LOGIN_CLIENT_ID, googleLoginClientId);
			setExpandoValue(companyId, SocialLoginConstants.GOOGLE_LOGIN_CLIENT_SECRET, googleLoginClientSecret);
			setExpandoValue(companyId, SocialLoginConstants.GOOGLE_LOGIN_HOSTED_DOMAIN, googleLoginHostedDomain);

			setExpandoValue(companyId, SocialLoginConstants.FACEBOOK_LOGIN_ENABLED, facebookLoginEnabled);
			setExpandoValue(companyId, SocialLoginConstants.FACEBOOK_LOGIN_CLIENT_ID, facebookLoginClientId);
			setExpandoValue(companyId, SocialLoginConstants.FACEBOOK_LOGIN_CLIENT_SECRET, facebookLoginClientSecret);

			setExpandoValue(companyId, SocialLoginConstants.TWITTER_LOGIN_ENABLED, twitterLoginEnabled);
			setExpandoValue(companyId, SocialLoginConstants.TWITTER_LOGIN_CLIENT_ID, twitterLoginClientId);
			setExpandoValue(companyId, SocialLoginConstants.TWITTER_LOGIN_CLIENT_SECRET, twitterLoginClientSecret);

			setExpandoValue(companyId, SocialLoginConstants.LINKEDIN_LOGIN_ENABLED, linkedinLoginEnabled);
			setExpandoValue(companyId, SocialLoginConstants.LINKEDIN_LOGIN_CLIENT_ID, linkedinLoginClientId);
			setExpandoValue(companyId, SocialLoginConstants.LINKEDIN_LOGIN_CLIENT_SECRET, linkedinLoginClientSecret);

			setExpandoValue(companyId, SocialLoginConstants.MICROSOFT_LOGIN_ENABLED, microsoftLoginEnabled);
			setExpandoValue(companyId, SocialLoginConstants.MICROSOFT_LOGIN_CLIENT_ID, microsoftLoginClientId);
			setExpandoValue(companyId, SocialLoginConstants.MICROSOFT_LOGIN_CLIENT_SECRET, microsoftLoginClientSecret);
		} catch (PortalException e) {
			_log.error(e.getMessage());

		} catch (SystemException e) {
			_log.error(e.getMessage());

		}
	}

	private void setExpandoValue(long companyId, String expandoField, boolean value)
			throws PortalException, SystemException {
		ExpandoValueLocalServiceUtil.addValue(companyId, Company.class.getName(),
				SocialLoginConstants.SOCIALLOGIN_EXPANDO_TABLE, expandoField, companyId, value);
	}

	private void setExpandoValue(long companyId, String expandoField, String value)
			throws PortalException, SystemException {
		ExpandoValueLocalServiceUtil.addValue(companyId, Company.class.getName(),
				SocialLoginConstants.SOCIALLOGIN_EXPANDO_TABLE, expandoField, companyId, value);
	}

}
