package com.sambaash.platform.portlet.socialplugin.action;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.scribe.model.Token;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.oauth.SocialNetworkException;
import com.sambaash.oauth.SocialNetworkService;
import com.sambaash.oauth.model.Profile;
import com.sambaash.oauth.util.SocialNetworkServiceFactory;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.portlet.socialplugin.util.SocialPluginsConstants;
import com.sambaash.platform.portlet.socialplugin.util.SocialSharingUtil;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class SocialPluginAction
 */
public class SocialPluginAction extends SocialPluginsActionBase {

	@Override
	public void doView(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {

		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(request));
		HttpSession session = httpRequest.getSession();
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long scopeGroupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		long userId = themeDisplay.getUserId();
		boolean signedIn = SambaashUtil.isUserSignedIn(httpRequest);

		String network = ParamUtil.getString(httpRequest, "req");
		String oauth_verifier = ParamUtil.getString(httpRequest,
				"oauth_verifier");

		SessionMessages.clear(httpRequest);
		SessionErrors.clear(httpRequest);

		if (signedIn) {

			SocialProfile socialProfile = null;

			try {
				socialProfile = SocialProfileLocalServiceUtil
						.getSocialProfile(userId);
			} catch (PortalException e1) {
				_log.error(e1.getMessage(), e1);
			} catch (SystemException e1) {
				_log.error(e1.getMessage(), e1);
			}

			_log.info("oauth_verifier: " + oauth_verifier);

			if (Validator.isNotNull(oauth_verifier)
					&& Validator.isNotNull(network)) {

				if (network.equals(SocialPluginsConstants.PROVIDERS.LINKEDIN)) {
					initialiseLinkedIn(companyId, scopeGroupId, socialProfile,
							oauth_verifier, request, session);
				} else if (network
						.equals(SocialPluginsConstants.PROVIDERS.TWITTER)) {
					initialiseTwitter(companyId, scopeGroupId, socialProfile,
							oauth_verifier, request, session);
				} else if (network
						.equals(SocialPluginsConstants.PROVIDERS.YAHOO)) {
					initialiseYahoo(companyId, scopeGroupId, socialProfile,
							oauth_verifier, request, session);
				}
				if (network.equals(SocialPluginsConstants.PROVIDERS.GOOGLE)) {
					initialiseGoogle(companyId, scopeGroupId, socialProfile,
							oauth_verifier, request, session);
				}
			} else {
				initialiseFacebook(companyId, scopeGroupId, socialProfile,
						request, httpRequest);
			}
		}

		request.setAttribute("link_message",
				SocialSharingUtil
						.getMessageResourceBundle(
								SocialPluginsConstants.LINK_PROFILE_LABEL,
								scopeGroupId));
		include(viewTemplate, request, response);
	}

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response)
			throws IOException, PortletException {
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(request));
		HttpSession session = httpRequest.getSession();

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long scopeGroupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		boolean signedIn = SambaashUtil.isUserSignedIn(httpRequest);
		String network = ParamUtil.getString(httpRequest, "provider");
		SocialNetworkService service = null;

		if (!signedIn)
			return;

		SessionMessages.clear(httpRequest);
		SessionErrors.clear(httpRequest);

		if (network.equals(SocialPluginsConstants.PROVIDERS.FACEBOOK)) {

			try {
				String apiKey = PrefsPropsUtil.getString(companyId,
						PropsKeys.FACEBOOK_CONNECT_APP_ID);
				String apiSecret = PrefsPropsUtil.getString(companyId,
						PropsKeys.FACEBOOK_CONNECT_APP_SECRET);
				String permission = SambaashUtil.getParameter(
						SocialPluginsConstants.FACEBOOK.PERMISSION,
						scopeGroupId);

				boolean isAdmin = SambaashUtil.isAdmin(scopeGroupId,
						themeDisplay.getUserId());

				if (isAdmin) {
					permission += StringPool.COMMA
							+ SambaashUtil
									.getParameter(
											SocialPluginsConstants.FACEBOOK.ADMIN_PERMISSION,
											scopeGroupId);
				}

				service = SocialNetworkServiceFactory
						.getSocialNetworkService(SocialNetworkService.FACEBOOK_SERVICE);
				service.setApiKey(apiKey);
				service.setApiSecret(apiSecret);
				service.setScope(permission);

				String callbackUrl = getURL(httpRequest);

				if (Validator.isNotNull(callbackUrl)) {
					service.setCallbackUrl(callbackUrl);
				}

				sendJSONOutput(response, "100",
						service.createAuthorizationUrl());
			} catch (SocialNetworkException e) {
				_log.error(e.getMessage(), e);
				sendJSONOutput(response, "400", "error-connect");
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}

		} else if (network.equals(SocialPluginsConstants.PROVIDERS.LINKEDIN)) {

			try {
				String apiKey = SambaashUtil.getParameter(
						SambaashConstants.LINKEDIN_API_KEY, scopeGroupId);
				String apiSecret = SambaashUtil.getParameter(
						SambaashConstants.LINKEDIN_SECRET_KEY, scopeGroupId);
				service = SocialNetworkServiceFactory
						.getSocialNetworkService(SocialNetworkService.LINKEDIN_SERVICE);
				service.setApiKey(apiKey);
				service.setApiSecret(apiSecret);
				service.setCallbackUrl(getURL(httpRequest) + "?req=linkedin");
			} catch (SocialNetworkException e) {
				_log.error("Error getting network provider.");
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}

			session.setAttribute("linkedin.oauth.service", service);

			try {
				sendJSONOutput(response, "100",
						service.createAuthorizationUrl());
			} catch (SocialNetworkException e) {
				_log.error(e.getMessage(), e);
				session.removeAttribute("linkedin.oauth.service");
				sendJSONOutput(response, "400", "error-connect");
			}

		} else if (network.equals(SocialPluginsConstants.PROVIDERS.TWITTER)) {

			try {
				String apiKey = SambaashUtil.getParameter(
						SambaashConstants.TWITTER_API_KEY, scopeGroupId);
				String apiSecret = SambaashUtil.getParameter(
						SambaashConstants.TWITTER_SECRET_KEY, scopeGroupId);
				service = SocialNetworkServiceFactory
						.getSocialNetworkService(SocialNetworkService.TWITTER_SERVICE);
				service.setApiKey(apiKey);
				service.setApiSecret(apiSecret);
				service.setCallbackUrl(getURL(httpRequest) + "?req=twitter");
			} catch (SocialNetworkException e) {
				_log.error("Error getting network provider.");
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}

			session.setAttribute("twitter.oauth.service", service);

			try {
				sendJSONOutput(response, "100",
						service.createAuthorizationUrl());
			} catch (SocialNetworkException e) {
				_log.error(e.getMessage(), e);
				session.removeAttribute("twitter.oauth.service");
				sendJSONOutput(response, "400", "error-connect");
			}

		} else if (network.equals(SocialPluginsConstants.PROVIDERS.GOOGLE)) {

			try {
				String apiKey = SambaashUtil.getParameter(
						SambaashConstants.GOOGLE_API_KEY, scopeGroupId);
				String apiSecret = SambaashUtil.getParameter(
						SambaashConstants.GOOGLE_SECRET_KEY, scopeGroupId);
				String scope = SambaashUtil.getParameter(
						SambaashConstants.GOOGLE_OAUTH_SERVICE_SCOPE,
						scopeGroupId);
				service = SocialNetworkServiceFactory
						.getSocialNetworkService(SocialNetworkService.GOOGLE_SERVICE);
				service.setApiKey(apiKey);
				service.setApiSecret(apiSecret);
				service.setCallbackUrl(getURL(httpRequest) + "?req=google");
				service.setScope(scope);
			} catch (SocialNetworkException e) {
				_log.error("Error getting network provider.");
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}

			session.setAttribute("google.oauth.service", service);

			try {
				sendJSONOutput(response, "100",
						service.createAuthorizationUrl());
			} catch (SocialNetworkException e) {
				_log.error(e.getMessage(), e);
				session.removeAttribute("google.oauth.service");
				sendJSONOutput(response, "400", "error-connect");
			}

		} else if (network.equals(SocialPluginsConstants.PROVIDERS.YAHOO)) {

			try {
				String apiKey = SambaashUtil.getParameter(
						SambaashConstants.YAHOO_API_KEY, scopeGroupId);
				String apiSecret = SambaashUtil.getParameter(
						SambaashConstants.YAHOO_SECRET_KEY, scopeGroupId);
				service = SocialNetworkServiceFactory
						.getSocialNetworkService(SocialNetworkService.YAHOO_SERVICE);
				service.setApiKey(apiKey);
				service.setApiSecret(apiSecret);
				service.setCallbackUrl(getURL(httpRequest) + "?req=yahoo");
			} catch (SocialNetworkException e) {
				_log.error("Error getting network provider.");
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}

			session.setAttribute("yahoo.oauth.service", service);

			try {
				sendJSONOutput(response, "100",
						service.createAuthorizationUrl());
			} catch (SocialNetworkException e) {
				_log.error(e.getMessage(), e);
				session.removeAttribute("yahoo.oauth.service");
				sendJSONOutput(response, "400", "error-connect");
			}
		}

		super.serveResource(request, response);
	}

	private void initialiseFacebook(long companyId, long scopeGroupId,
			SocialProfile socialProfile, RenderRequest request,
			HttpServletRequest httpRequest) {
		User user = null;
		Profile profile = null;
		long userId = socialProfile.getUserId();
		String code = ParamUtil.getString(httpRequest, "code");
		String publicUrl = StringPool.BLANK;

		if (Validator.isNotNull(code)) {

			String accessToken = StringPool.BLANK;
			String secretToken = StringPool.BLANK;
			long facebookId = 0;

			try {
				String apiKey = PrefsPropsUtil.getString(companyId,
						PropsKeys.FACEBOOK_CONNECT_APP_ID);
				String apiSecret = PrefsPropsUtil.getString(companyId,
						PropsKeys.FACEBOOK_CONNECT_APP_SECRET);
				String permission = SambaashUtil.getParameter(
						SocialPluginsConstants.FACEBOOK.PERMISSION,
						scopeGroupId);
				String protectedResourceURL = SambaashUtil.getParameter(
						SocialPluginsConstants.FACEBOOK.PROFILE, scopeGroupId);

				boolean isAdmin = SambaashUtil.isAdmin(scopeGroupId, userId);

				if (isAdmin) {
					permission += StringPool.COMMA
							+ SambaashUtil
									.getParameter(
											SocialPluginsConstants.FACEBOOK.ADMIN_PERMISSION,
											scopeGroupId);
				}

				try {

					SocialNetworkService service = SocialNetworkServiceFactory
							.getSocialNetworkService(SocialNetworkService.FACEBOOK_SERVICE);
					service.setApiKey(apiKey);
					service.setApiSecret(apiSecret);
					service.setScope(permission);
					service.setServiceUrl(protectedResourceURL);

					String callbackUrl = getURL(httpRequest);

					if (Validator.isNotNull(callbackUrl)) {
						service.setCallbackUrl(callbackUrl);
					}

					service.setVerifier(code + "#_=_");

					Token t = service.getAccessToken();

					accessToken = t.getToken();
					secretToken = t.getSecret();

					profile = service.retrieveProfile();

					if ((Validator.isNotNull(profile))
							&& (Validator.isNotNull(profile.getId()))) {
						facebookId = Long.valueOf(profile.getId());
						publicUrl = profile.getPublicUrl();
						user = UserLocalServiceUtil.getUserByFacebookId(
								companyId, facebookId);
					}
				} catch (SocialNetworkException e1) {
					_log.error(e1.getMessage(), e1);
				} catch (PortalException e) {
					_log.error(e.getMessage(), e);
				}

				// check if its the same profile we were linking

				if ((user != null) && (user.getUserId() != userId)) {
					// facebook account is linked with other user
					SessionMessages.add(httpRequest, "userAlreadyExists",
							SocialSharingUtil.getMessageResourceBundle(
									SocialPluginsConstants.ALREADY_LINK_ERROR,
									scopeGroupId));
				} else if (Validator.isNotNull(accessToken) && (facebookId > 0)) {
					// store access token and facebookId
					socialProfile.setFacebookAuthToken(accessToken);
					socialProfile.setFacebookAuthSecret(secretToken);
					UserLocalServiceUtil.updateFacebookId(userId,
							Long.valueOf(facebookId));

					_log.info("facebookId: " + facebookId);
					_log.info("Access Token: " + accessToken);
					_log.info("Secret Token: " + secretToken);

					if (Validator.isNotNull(publicUrl)) {
						try {
							socialProfile = SocialProfileLocalServiceUtil
									.addNetworkInfo(socialProfile, "facebook",
											"facebook_url", publicUrl);
						} catch (Exception e) {
							_log.error(e.getMessage(), e);
						}
					}

					updateSocialProfile(socialProfile, user, profile,
							scopeGroupId);
					SessionMessages
							.add(httpRequest,
									"successConnect",
									SocialSharingUtil
											.getMessageResourceBundle(
													SocialPluginsConstants.FACEBOOK_LINK_SUCCESS,
													scopeGroupId));
				}
			} catch (SystemException e) {
				_log.error(e.getMessage(), e);
				SessionErrors.add(request, "errorConnect",
						SocialSharingUtil
								.getMessageResourceBundle(
										SocialPluginsConstants.LINK_ERROR,
										scopeGroupId));
			} catch (PortalException e) {
				_log.error(e.getMessage(), e);
				SessionErrors.add(request, "errorConnect",
						SocialSharingUtil
								.getMessageResourceBundle(
										SocialPluginsConstants.LINK_ERROR,
										scopeGroupId));
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
				SessionErrors.add(request, "errorConnect",
						SocialSharingUtil
								.getMessageResourceBundle(
										SocialPluginsConstants.LINK_ERROR,
										scopeGroupId));
			}
		}
	}

	private void initialiseGoogle(long companyId, long scopeGroupId,
			SocialProfile socialProfile, String oauth_verifier,
			RenderRequest request, HttpSession session) {
		User user = null;
		Profile profile = null;
		SocialProfile googleProfile = null;
		long userId = socialProfile.getUserId();
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(request));

		SocialNetworkService service = (SocialNetworkService) session
				.getAttribute("google.oauth.service");
		String protectedResourceURL = SambaashUtil.getParameter(
				SambaashConstants.GOOGLE_PROTECTED_RESOURCE_URL, scopeGroupId);

		String accessToken = StringPool.BLANK;
		String secretToken = StringPool.BLANK;
		String googleId = StringPool.BLANK;

		String publicUrl = StringPool.BLANK;

		try {
			try {

				if (Validator.isNull(service)) {
					try {
						String apiKey = SambaashUtil.getParameter(
								SambaashConstants.GOOGLE_API_KEY, scopeGroupId);
						String apiSecret = SambaashUtil.getParameter(
								SambaashConstants.GOOGLE_SECRET_KEY,
								scopeGroupId);
						String scope = SambaashUtil.getParameter(
								SambaashConstants.GOOGLE_OAUTH_SERVICE_SCOPE,
								scopeGroupId);
						service = SocialNetworkServiceFactory
								.getSocialNetworkService(SocialNetworkService.GOOGLE_SERVICE);
						service.setApiKey(apiKey);
						service.setApiSecret(apiSecret);
						service.setCallbackUrl(getURL(httpRequest)
								+ "?req=google");
						service.setScope(scope);
					} catch (SocialNetworkException e) {
						_log.error("Error getting network provider.");
					} catch (Exception e) {
						_log.error(e.getMessage(), e);
					}

					session.setAttribute("google.oauth.service", service);
				}

				service.setServiceUrl(protectedResourceURL);
				service.setVerifier(oauth_verifier);
				profile = service.retrieveProfile();

				if (Validator.isNotNull(profile)) {

					googleId = profile.getId();
					Token t = service.getAccessToken();
					accessToken = t.getToken();
					secretToken = t.getSecret();

					publicUrl = profile.getPublicUrl();

					_log.info("accesstoken: " + accessToken);
					_log.info("secretToken: " + secretToken);
					_log.info("googleId: " + googleId);

					if (Validator.isNotNull(googleId)) {
						googleProfile = SocialProfileLocalServiceUtil
								.findByGoogleId(companyId, googleId);
					}
				}
			} catch (PortalException e) {
				_log.error(e.getMessage(), e);
			} catch (SocialNetworkException e) {
				_log.error(e.getMessage(), e);
			}

			// check if its the same profile we were linking

			if ((googleProfile != null)
					&& (googleProfile.getUserId() != userId)) {
				SessionMessages.add(httpRequest, "userAlreadyExists",
						SocialSharingUtil.getMessageResourceBundle(
								SocialPluginsConstants.ALREADY_LINK_ERROR,
								scopeGroupId));
				// google account is google with other user
			} else if (Validator.isNotNull(accessToken)
					&& (Validator.isNotNull(googleId))) {
				// store access token and googleId
				socialProfile.setGoogleAuthToken(accessToken);
				socialProfile.setGoogleId(googleId);
				socialProfile.setGoogleAuthSecret(secretToken);

				if (Validator.isNotNull(publicUrl)) {
					try {
						socialProfile = SocialProfileLocalServiceUtil
								.addNetworkInfo(socialProfile, "websites",
										"websites_url", publicUrl);
					} catch (Exception e) {
						_log.error(e.getMessage(), e);
					}
				}

				updateSocialProfile(socialProfile, user, profile, scopeGroupId);

				SessionMessages.add(httpRequest, "successConnect",
						SocialSharingUtil.getMessageResourceBundle(
								SocialPluginsConstants.GOOGLE_LINK_SUCCESS,
								scopeGroupId));
			}
		} catch (SystemException e) {
			_log.error(e.getMessage(), e);
			SessionErrors.add(request, "errorConnect", SocialSharingUtil
					.getMessageResourceBundle(
							SocialPluginsConstants.LINK_ERROR, scopeGroupId));
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
			SessionErrors.add(request, "errorConnect", SocialSharingUtil
					.getMessageResourceBundle(
							SocialPluginsConstants.LINK_ERROR, scopeGroupId));
		}
	}

	private void initialiseLinkedIn(long companyId, long scopeGroupId,
			SocialProfile socialProfile, String oauth_verifier,
			RenderRequest request, HttpSession session) {
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(request));
		User user = null;
		Profile profile = null;
		SocialProfile linkedinProfile = null;
		long userId = socialProfile.getUserId();
		String publicUrl = StringPool.BLANK;

		SocialNetworkService service = (SocialNetworkService) session
				.getAttribute("linkedin.oauth.service");
		String accessToken = StringPool.BLANK;
		String secretToken = StringPool.BLANK;
		String linkedInId = StringPool.BLANK;

		try {
			try {
				String protectedResourceURL = SambaashUtil.getParameter(
						SambaashConstants.LINKEDIN_PROTECTED_RESOURCE_URL,
						scopeGroupId);

				if (Validator.isNull(service)) {
					try {
						String apiKey = SambaashUtil.getParameter(
								SambaashConstants.LINKEDIN_API_KEY,
								scopeGroupId);
						String apiSecret = SambaashUtil.getParameter(
								SambaashConstants.LINKEDIN_SECRET_KEY,
								scopeGroupId);
						service = SocialNetworkServiceFactory
								.getSocialNetworkService(SocialNetworkService.LINKEDIN_SERVICE);
						service.setApiKey(apiKey);
						service.setApiSecret(apiSecret);
					} catch (SocialNetworkException e) {
						_log.error("Error getting network provider.");
					} catch (Exception e) {
						_log.error(e.getMessage(), e);
					}

					session.setAttribute("linkedin.oauth.service", service);
				}

				service.setVerifier(oauth_verifier);
				service.setServiceUrl(protectedResourceURL);
				profile = service.retrieveProfile();

				if (Validator.isNotNull(profile)) {

					linkedInId = profile.getId();

					publicUrl = profile.getPublicUrl();

					Token t = service.getAccessToken();
					accessToken = t.getToken();
					secretToken = t.getSecret();

					if (Validator.isNotNull(linkedInId)) {
						linkedinProfile = SocialProfileLocalServiceUtil
								.findByLinkedinId(companyId, linkedInId);
						
					}
				}
			} catch (SocialNetworkException e1) {
				_log.error(e1.getMessage(), e1);
			} catch (PortalException e) {
				_log.error(e.getMessage(), e);
			}

			// check if its the same profile we were linking

			if ((linkedinProfile != null)
					&& (linkedinProfile.getUserId() != userId)) {
				SessionMessages.add(httpRequest, "userAlreadyExists",
						SocialSharingUtil.getMessageResourceBundle(
								SocialPluginsConstants.ALREADY_LINK_ERROR,
								scopeGroupId));
				// linkedin account is linked with other user
			} else if (Validator.isNotNull(accessToken)
					&& (Validator.isNotNull(linkedInId))) {
				// store access token and linkedinId
				socialProfile.setLinkedinAuthToken(accessToken);
				socialProfile.setLinkedinId(linkedInId);
				socialProfile.setLinkedinAuthSecret(secretToken);

				if (Validator.isNotNull(publicUrl)) {
					try {
						socialProfile = SocialProfileLocalServiceUtil
								.addNetworkInfo(socialProfile, "linkedin",
										"linkedin_url", publicUrl);
					} catch (Exception e) {
						_log.error(e.getMessage(), e);
					}
				}

				updateSocialProfile(socialProfile, user, profile, scopeGroupId);

				SessionMessages.add(httpRequest, "successConnect",
						SocialSharingUtil.getMessageResourceBundle(
								SocialPluginsConstants.LINKEDIN_LINK_SUCCESS,
								scopeGroupId));
			}
		} catch (SystemException e) {
			_log.error(e.getMessage(), e);
			SessionErrors.add(request, "errorConnect", SocialSharingUtil
					.getMessageResourceBundle(
							SocialPluginsConstants.LINK_ERROR, scopeGroupId));
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
			SessionErrors.add(request, "errorConnect", SocialSharingUtil
					.getMessageResourceBundle(
							SocialPluginsConstants.LINK_ERROR, scopeGroupId));
		}
	}

	private void initialiseTwitter(long companyId, long scopeGroupId,
			SocialProfile socialProfile, String oauth_verifier,
			RenderRequest request, HttpSession session) {
		User user = null;
		Profile profile = null;
		SocialProfile twitterProfile = null;
		long userId = socialProfile.getUserId();
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(request));

		SocialNetworkService service = (SocialNetworkService) session
				.getAttribute("twitter.oauth.service");
		String protectedResourceURL = SambaashUtil.getParameter(
				SambaashConstants.TWITTER_PROTECTED_RESOURCE_URL, scopeGroupId);

		String accessToken = StringPool.BLANK;
		String secretToken = StringPool.BLANK;
		String twitterId = StringPool.BLANK;

		String publicUrl = StringPool.BLANK;

		try {
			try {

				if (Validator.isNull(service)) {
					try {
						String apiKey = SambaashUtil
								.getParameter(
										SambaashConstants.TWITTER_API_KEY,
										scopeGroupId);
						String apiSecret = SambaashUtil.getParameter(
								SambaashConstants.TWITTER_SECRET_KEY,
								scopeGroupId);
						service = SocialNetworkServiceFactory
								.getSocialNetworkService(SocialNetworkService.TWITTER_SERVICE);
						service.setApiKey(apiKey);
						service.setApiSecret(apiSecret);
						service.setCallbackUrl(getURL(httpRequest)
								+ "?req=twitter");
					} catch (SocialNetworkException e) {
						_log.error("Error getting network provider.");
					} catch (Exception e) {
						_log.error(e.getMessage(), e);
					}

					session.setAttribute("twitter.oauth.service", service);
				}

				service.setServiceUrl(protectedResourceURL);
				service.setVerifier(oauth_verifier);
				profile = service.retrieveProfile();

				if (Validator.isNotNull(profile)) {

					twitterId = profile.getId();
					publicUrl = profile.getPublicUrl();

					Token t = service.getAccessToken();
					accessToken = t.getToken();
					secretToken = t.getSecret();

					_log.info("accesstoken: " + accessToken);
					_log.info("secretToken: " + secretToken);
					_log.info("twitterId: " + twitterId);

					if (Validator.isNotNull(twitterId)) {
						twitterProfile = SocialProfileLocalServiceUtil
								.findByTwitterId(companyId, twitterId);
					}
				}
			} catch (PortalException e) {
				_log.error(e.getMessage(), e);
			} catch (SocialNetworkException e) {
				_log.error(e.getMessage(), e);
			}

			// check if its the same profile we were linking

			if ((twitterProfile != null)
					&& (twitterProfile.getUserId() != userId)) {
				SessionMessages.add(httpRequest, "userAlreadyExists",
						SocialSharingUtil.getMessageResourceBundle(
								SocialPluginsConstants.ALREADY_LINK_ERROR,
								scopeGroupId));
				// twitter account is twitter with other user
			} else if (Validator.isNotNull(accessToken)
					&& (Validator.isNotNull(twitterId))) {
				// store access token and twitterId
				socialProfile.setTwitterAuthToken(accessToken);
				socialProfile.setTwitterId(twitterId);
				socialProfile.setTwitterAuthSecret(secretToken);

				if (Validator.isNotNull(publicUrl)) {
					try {
						socialProfile = SocialProfileLocalServiceUtil
								.addNetworkInfo(socialProfile, "twitter",
										"twitter_url", publicUrl);
					} catch (Exception e) {
						_log.error(e.getMessage(), e);
					}
				}

				updateSocialProfile(socialProfile, user, profile, scopeGroupId);

				SessionMessages.add(httpRequest, "successConnect",
						SocialSharingUtil.getMessageResourceBundle(
								SocialPluginsConstants.TWITTER_LINK_SUCCESS,
								scopeGroupId));
			}
		} catch (SystemException e) {
			_log.error(e.getMessage(), e);
			SessionErrors.add(request, "errorConnect", SocialSharingUtil
					.getMessageResourceBundle(
							SocialPluginsConstants.LINK_ERROR, scopeGroupId));
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
			SessionErrors.add(request, "errorConnect", SocialSharingUtil
					.getMessageResourceBundle(
							SocialPluginsConstants.LINK_ERROR, scopeGroupId));
		}
	}

	private void initialiseYahoo(long companyId, long scopeGroupId,
			SocialProfile socialProfile, String oauth_verifier,
			RenderRequest request, HttpSession session) {
		User user = null;
		Profile profile = null;
		SocialProfile yahooProfile = null;
		long userId = socialProfile.getUserId();
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(request));

		SocialNetworkService service = (SocialNetworkService) session
				.getAttribute("yahoo.oauth.service");
		String protectedResourceURL = SambaashUtil.getParameter(
				SambaashConstants.YAHOO_PROTECTED_RESOURCE_URL, scopeGroupId);

		String accessToken = StringPool.BLANK;
		String secretToken = StringPool.BLANK;
		String yahooId = StringPool.BLANK;

		String publicUrl = StringPool.BLANK;

		try {
			try {

				if (Validator.isNull(service)) {
					try {
						String apiKey = SambaashUtil.getParameter(
								SambaashConstants.YAHOO_API_KEY, scopeGroupId);
						String apiSecret = SambaashUtil.getParameter(
								SambaashConstants.YAHOO_SECRET_KEY,
								scopeGroupId);
						service = SocialNetworkServiceFactory
								.getSocialNetworkService(SocialNetworkService.YAHOO_SERVICE);
						service.setApiKey(apiKey);
						service.setApiSecret(apiSecret);
						service.setCallbackUrl(getURL(httpRequest)
								+ "?req=yahoo");
					} catch (SocialNetworkException e) {
						_log.error("Error getting network provider.");
					} catch (Exception e) {
						_log.error(e.getMessage(), e);
					}

					session.setAttribute("yahoo.oauth.service", service);
				}

				service.setServiceUrl(protectedResourceURL);
				service.setVerifier(oauth_verifier);
				profile = service.retrieveProfile();

				if (Validator.isNotNull(profile)) {

					yahooId = profile.getId();

					publicUrl = profile.getPublicUrl();

					Token t = service.getAccessToken();
					accessToken = t.getToken();
					secretToken = t.getSecret();

					_log.info("accesstoken: " + accessToken);
					_log.info("secretToken: " + secretToken);
					_log.info("yahooId: " + yahooId);

					if (Validator.isNotNull(yahooId)) {
						yahooProfile = SocialProfileLocalServiceUtil
								.findByYahooId(companyId, yahooId);
					}
				}
			} catch (PortalException e) {
				_log.error(e.getMessage(), e);
			} catch (SocialNetworkException e) {
				_log.error(e.getMessage(), e);
			}

			// check if its the same profile we were linking

			if ((yahooProfile != null) && (yahooProfile.getUserId() != userId)) {
				SessionMessages.add(httpRequest, "userAlreadyExists",
						SocialSharingUtil.getMessageResourceBundle(
								SocialPluginsConstants.ALREADY_LINK_ERROR,
								scopeGroupId));
				// yahoo account is yahoo with other user
			} else if (Validator.isNotNull(accessToken)
					&& (Validator.isNotNull(yahooId))) {
				// store access token and yahooId
				socialProfile.setYahooAuthToken(accessToken);
				socialProfile.setYahooId(yahooId);
				socialProfile.setYahooAuthSecret(secretToken);

				if (Validator.isNotNull(publicUrl)) {
					try {
						socialProfile = SocialProfileLocalServiceUtil
								.addNetworkInfo(socialProfile, "websites",
										"websites_url", publicUrl);
					} catch (Exception e) {
						_log.error(e.getMessage(), e);
					}
				}

				updateSocialProfile(socialProfile, user, profile, scopeGroupId);

				SessionMessages.add(httpRequest, "successConnect",
						SocialSharingUtil.getMessageResourceBundle(
								SocialPluginsConstants.YAHOO_LINK_SUCCESS,
								scopeGroupId));
			}
		} catch (SystemException e) {
			_log.error(e.getMessage(), e);
			SessionErrors.add(request, "errorConnect", SocialSharingUtil
					.getMessageResourceBundle(
							SocialPluginsConstants.LINK_ERROR, scopeGroupId));
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
			SessionErrors.add(request, "errorConnect", SocialSharingUtil
					.getMessageResourceBundle(
							SocialPluginsConstants.LINK_ERROR, scopeGroupId));
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SocialPluginAction.class);

}