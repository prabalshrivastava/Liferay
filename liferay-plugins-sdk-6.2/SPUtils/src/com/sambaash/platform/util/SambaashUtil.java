package com.sambaash.platform.util;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.NoSuchCompanyException;
import com.liferay.portal.NoSuchRoleException;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.cache.SingleVMPoolUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.servlet.DirectServletRegistryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.AuditedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.model.VirtualHost;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.LayoutServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.VirtualHostLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.SubscriptionSender;
import com.liferay.portal.webserver.WebServerServletTokenUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.liferay.portlet.expando.service.permission.ExpandoColumnPermissionUtil;
import com.liferay.portlet.trash.util.TrashUtil;
import com.sambaash.platform.comparator.RoleComparatorByOrder;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.constant.SambaashConstants.DOCUMENTLIBRARY;
import com.sambaash.platform.model.Candidate;
import com.sambaash.platform.model.Invigilator;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.model.Persona;
import com.sambaash.platform.model.ProfileType;
import com.sambaash.platform.model.StrartupProfileBean;
import com.sambaash.platform.security.util.SPAuthenticationUtil;
import com.sambaash.platform.service.FetchLocalServiceUtil;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.spservices.NoSuchSPParameterException;
import com.sambaash.platform.srv.spservices.model.SPLdapProfile;
import com.sambaash.platform.srv.spservices.model.SPListType;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.model.SPSiteSetup;
import com.sambaash.platform.srv.spservices.service.SPLdapProfileLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPSiteSetupLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.model.SPATOContacts;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.SPATOContactsLocalServiceUtil;

/**
 * @author gauravvijayvergia
 *
 */
public class SambaashUtil {

	private static Log _log = LogFactoryUtil.getLog(SambaashUtil.class);

	/*
	 * Used in SPParameterLocalServiceImpl.findBySPParameterGroupIdAndName() and
	 * SocialProfileLocalServiceImpl.addUserPlatform() to get the company id of
	 * current user as fix for VD-50
	 */
	public static Long getCurrentCompanyId() {
		try {
			Long id = CompanyThreadLocal.getCompanyId();
			if (id == null || id.longValue() <= 0) {
				id = PortalUtil.getDefaultCompanyId();
			}
			return id;
		} catch (Exception e) {
			_log.error("Unable to get current company id. Returning -1.", e);
			return -1L;
		}
	}

	/**
	 * @param companyId
	 * @param scopeGroupId
	 * @return
	 */
	public static String getPortalURL(long companyId, long scopeGroupId) {

		String virtualHost = StringPool.BLANK;
		String port = StringPool.BLANK;
		StringBuffer sb = new StringBuffer();
		try {
			virtualHost = getVirtualHost(scopeGroupId);
			port = getParameter(SambaashConstants.PORT, scopeGroupId);

			if (Http.HTTPS.equals(PropsUtil.get(PropsKeys.WEB_SERVER_PROTOCOL))) {
				sb.append(Http.HTTPS_WITH_SLASH);
			} else {
				sb.append(Http.HTTP_WITH_SLASH);
			}
			if (Validator.isNotNull(virtualHost)) {
				sb.append(virtualHost);
			} else {
				try {
					Company company = CompanyLocalServiceUtil.getCompanyById(companyId);
					if (company != null) {
						sb.append(company.getVirtualHostname());
					}
				} catch (NoSuchCompanyException nsce) {
					_log.info("No such company exist with primary key: " + companyId);
				}
			}

			if (Validator.isNotNull(port)) {
				sb.append(StringPool.COLON).append(port);
			}

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		return sb.toString();
	}

	public static boolean isSupportRole(long scopeGroupId, long userId) {

		return checkRoleAccess(SambaashConstants.DEFAULT_SUPPORT_ROLEIDS, scopeGroupId, userId);
	}

	public static boolean isAdmin(long scopeGroupId, long userId) {

		return checkRoleAccess(SambaashConstants.DEFAULT_ADMIN_ROLEIDS, scopeGroupId, userId);
	}

	public static long getAdminUserId() {
		String userIdString = getParameter(SambaashConstants.PARAM.ID_ADMIN_USER,
				Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID));
		if (Validator.isNotNull(userIdString)) {
			String[] userIdArray = userIdString.split(StringPool.COMMA);
			if (userIdArray.length > 0 && Validator.isNumber(userIdArray[0])) {
				return Long.parseLong(userIdArray[0]);
			}
		}

		return 10196;
	}

	public static boolean isReportRole(long scopeGroupId, long userId) {

		return checkRoleAccess(SambaashConstants.DEFAULT_REPORT_ROLEIDS, scopeGroupId, userId);
	}

	public static boolean isContentEditor(long scopeGroupId, long userId) {

		return checkRoleAccess(SambaashConstants.DEFAULT_CONTENTEDITOR_ROLEIDS, scopeGroupId, userId);
	}

	public static boolean isShoppingCatalogAdmin(long scopeGroupId, long userId) {

		return checkRoleAccess(SambaashConstants.DEFAULT_SHOPPING_ADMIN_ROLEIDS, scopeGroupId, userId);
	}

	public static boolean showNotificationIconOnDockbar() {
		String value = getParameter(SambaashConstants.USE_DEFAULT_LIFERAY_NOTIFICATION_DOCKBAR,
				PortalUtil.getDefaultCompanyId());
		return StringPool.TRUE.equalsIgnoreCase(value) ? true : false;
	}

	public static boolean checkRoleAccess(String spParameter, long scopeGroupId, long userId) {
		return checkRoleAccess(scopeGroupId, userId, getParameter(spParameter, scopeGroupId));
	}

	public static boolean checkRoleAccess(long scopeGroupId, long userId, String roleIdString) {

		boolean checkRoleAccess = false;
		try {
			String[] roleIdArray = roleIdString.split(StringPool.COMMA);
			List<Long> roleIdList = new ArrayList<Long>();
			for (int i = 0; i < roleIdArray.length; i++) {
				if (Validator.isNotNull(roleIdArray[i])) {
					try {
						long roleId = Long.valueOf(roleIdArray[i]);
						roleIdList.add(roleId);
					} catch (NumberFormatException nfe) {
						_log.info("Catch NumberFormatException. " + nfe.getMessage());
					}
				}
			}

			List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(userId, scopeGroupId);
			for (UserGroupRole ugr : userGroupRoles) {
				if (roleIdList.contains(ugr.getRoleId())) {
					checkRoleAccess = true;
					break;
				}
			}

			if (checkRoleAccess) {
				return true;
			}

			List<Role> userRoles = RoleLocalServiceUtil.getUserRoles(userId);
			for (Role ur : userRoles) {
				if (roleIdList.contains(ur.getRoleId())) {
					checkRoleAccess = true;
					break;
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		return checkRoleAccess;
	}

	/**
	 * @param key
	 * @param groupId
	 * @return
	 */
	public static String getParameter(String key, long groupId) {
		String value = StringPool.BLANK;
		try {
			SPParameter parameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(groupId, key);
			value = parameter.getValue();
		} catch (NoSuchSPParameterException e) {
			_log.info("No such spparameter exist with key: " + key + " groupId: " + groupId);
		} catch (Exception e) {
			_log.error("Exception getting SPParameter ==" + e.getMessage());
		}
		return value;
	}

	public static void saveSPParameter(String paramName, String paramValue) {
		saveSPParameter(0L, paramName, paramValue);
	}

	public static void saveSPParameter(Long groupId, String paramName, String paramValue) {
		SPParameter spparm;
		try {
			spparm = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(groupId, paramName);
			spparm.setValue(paramValue);
			SPParameterLocalServiceUtil.updateSPParameter(spparm);
			SPParameterLocalServiceUtil.clearSPParameterPool(groupId, paramName);
		} catch (NoSuchSPParameterException e) {
		} catch (SystemException e) {
		}
	}

	public static URL getDocumentUrl(long companyId, long scopeGroupId, String uuid) throws MalformedURLException {

		String portalUrl = getPortalURL(companyId, scopeGroupId);
		StringBuffer sb = new StringBuffer();
		return new URL(sb.append(portalUrl).append(StringPool.FORWARD_SLASH).append(DOCUMENTLIBRARY.DOCUMENT_ROOT)
				.append(StringPool.FORWARD_SLASH).append(scopeGroupId).append(StringPool.FORWARD_SLASH).append(uuid)
				.toString());
	}

	public static List<AssetCategory> getCategory(long groupId, String vocabularyName) throws SystemException {

		try {

			String vocabularyValue = "";
			SPParameter param = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(groupId, vocabularyName);

			if (param != null) {
				vocabularyValue = param.getValue();

			}

			AssetVocabulary vocab = AssetVocabularyLocalServiceUtil.getGroupVocabulary(groupId, vocabularyValue);
			int noOfCategories = AssetCategoryLocalServiceUtil.getAssetCategoriesCount();
			List<AssetCategory> categories = AssetCategoryLocalServiceUtil
					.getVocabularyRootCategories(vocab.getVocabularyId(), 0, noOfCategories, null);
			return categories;
		} catch (PortalException e) {
			_log.error(" Error getting the Categories with key [" + vocabularyName + "] ===" + e.getMessage());
		} catch (SystemException e) {
			_log.error(" Error getting the Categories with key [" + vocabularyName + "] ===" + e.getMessage());
		}

		return null;
	}

	public static User getLoggedInUser(Long loggedInUserId) throws PortalException, SystemException {

		return UserLocalServiceUtil.getUser(loggedInUserId);
	}

	public static boolean isCommunitySuperUser(RenderRequest renderRequest) {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

			SPParameter param = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(
					themeDisplay.getScopeGroupId(), SambaashConstants.ROLE.COMMUNITY_SUPER_USER);
			String roleName = "";
			if (param != null) {
				roleName = param.getValue();
			}
			long userId = themeDisplay.getUserId();
			List<Role> roles = RoleLocalServiceUtil.getUserRoles(userId);
			for (Role role : roles) {
				if (roleName.equalsIgnoreCase(role.getName())) {
					return true;
				}
			}
		} catch (SystemException e) {
			_log.error("Error checking admin role" + e.getMessage());
		} catch (NoSuchSPParameterException e) {
			_log.error("Error checking admin role" + e.getMessage());
		}

		return false;
	}

	public static String getCommunityName(long scopeGroupId) {

		try {
			Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);
			return group.getName();
		} catch (Exception e) {
			_log.error("Error getting community name. Returning empty string");
			return StringPool.BLANK;
		}
	}

	public static String getCommunityPath(long scopeGroupId) {

		try {
			String virtualhost = getParameter(SambaashConstants.VIRTUALHOST, scopeGroupId);
			Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);
			if (Validator.isNotNull(virtualhost) && !"localhost".equalsIgnoreCase(virtualhost)) {
				return StringPool.BLANK;
			} else {
				return "/web" + StringPool.FORWARD_SLASH + group.getName();
			}
		} catch (Exception e) {
			_log.error("Error getting community name. Returning empty string");
			return "";
		}
	}

	public static String getCreateAccountURL(long scopeGroupId, HttpServletRequest request, ThemeDisplay themeDisplay,
			boolean liferayDefaultCreateAccountUrl) {

		try {

			if (liferayDefaultCreateAccountUrl) {
				return PortalUtil.getCreateAccountURL(request, themeDisplay);
			}

			String accountCreationPage = StringPool.FORWARD_SLASH
					+ getParameter(SambaashConstants.ACCOUNT_CREATION_PAGE, scopeGroupId);
			Layout layout = null;
			try {
				layout = LayoutLocalServiceUtil.getFriendlyURLLayout(scopeGroupId, false, accountCreationPage);
			} catch (Exception e) {
				_log.debug("Layout doesn't exist with url : " + accountCreationPage);
			}

			String url = getCommunityPath(scopeGroupId) + accountCreationPage;
			if (Validator.isNotNull(accountCreationPage) && layout != null) {
				return url;
			} else {
				return PortalUtil.getCreateAccountURL(request, themeDisplay);
			}
		} catch (Exception e) {
			_log.error("Error getting community name. Returning empty string");
			return StringPool.BLANK;
		}
	}

	public static boolean canStrangersCreateAccount(ThemeDisplay themeDisplay) {

		boolean canStrangersCreateAccount = false;
		try {
			Company company = themeDisplay.getCompany();
			canStrangersCreateAccount = company.isStrangers();
		} catch (SystemException e) {
			_log.error("Error getting portalsetting value " + e.getMessage());
		}
		return canStrangersCreateAccount;
	}

	public static String getSignInUrlFromSPParamDefaultGrp(ThemeDisplay themeDisplay) {

		return getSignInUrlFromSPParam(themeDisplay.getScopeGroupId(), themeDisplay);
	}

	public static String getSignInUrlFromSPParam(long scopeGroupId, ThemeDisplay themeDisplay) {
		String signInUrl = themeDisplay.getPortalURL();
		try {
			String signinPage = getParameter(SambaashConstants.SIGNIN_PAGE, scopeGroupId);
			String separator = StringPool.BLANK;
			if (!signInUrl.endsWith(StringPool.FORWARD_SLASH)) {
				separator = StringPool.FORWARD_SLASH;
			}
			signInUrl = signInUrl + separator + signinPage;
		} catch (Exception ex) {

		}
		return signInUrl;
	}

	public static String getSignInURL(long scopeGroupId, ThemeDisplay themeDisplay, boolean liferayDefaultLoginUrl) {

		try {

			liferayDefaultLoginUrl = true;

			if (liferayDefaultLoginUrl) {
				return themeDisplay.getURLSignIn();
			}

			String signinPage = StringPool.FORWARD_SLASH + getParameter(SambaashConstants.SIGNIN_PAGE, scopeGroupId);
			Layout layout = null;
			try {
				layout = LayoutLocalServiceUtil.getFriendlyURLLayout(scopeGroupId, false, signinPage);
			} catch (Exception e) {
				_log.debug("Layout doesn't exist with url : " + signinPage);
			}

			String url = getCommunityPath(scopeGroupId) + signinPage;
			if (Validator.isNotNull(signinPage) && layout != null) {
				return url;
			} else {
				return themeDisplay.getURLSignIn();
			}
		} catch (Exception e) {
			_log.error("Error getting community name. Returning empty string");
			return StringPool.BLANK;
		}
	}

	public static List<String> getCurrencyTypes(long groupId) {

		List<String> currencies = new ArrayList<String>();
		try {
			List<SPListType> currencyList = SPListTypeLocalServiceUtil
					.getByKey(SambaashConstants.LIST_TYPE_KEY.CURRENCY_TYPES, groupId);
			if (currencyList == null) {
				return null;
			}
			for (SPListType spListType : currencyList) {
				String type = spListType.getItemValue();
				currencies.add(type);
			}
		} catch (SystemException e) {
			_log.error("Error getting currency types");
		}

		return currencies;
	}

	public static long getLongOriginalServletRequestParam(RenderRequest renderRequest, String paramName) {

		long paramValue = 0;
		try {
			paramValue = Long.valueOf(getStringOriginalServletRequestParam(renderRequest, paramName));
		} catch (NumberFormatException nfe) {
			_log.debug("Cause NumberFormatException");
		}
		return paramValue;
	}

	public static int getIntegerOriginalServletRequestParam(RenderRequest renderRequest, String paramName) {

		int paramValue = 0;
		try {
			paramValue = Integer.valueOf(getStringOriginalServletRequestParam(renderRequest, paramName));
		} catch (NumberFormatException nfe) {
			_log.debug("Cause NumberFormatException");
		}
		return paramValue;
	}

	public static String getStringOriginalServletRequestParam(RenderRequest renderRequest, String paramName) {

		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		String paramValue = httpReq.getParameter(paramName);
		if (paramValue == null) {
			paramValue = StringPool.BLANK;
		}
		return paramValue;
	}

	public static boolean isUserActive(long userId) {

		try {
			User user = UserLocalServiceUtil.getUser(userId);
			SocialProfile socialProfile = SocialProfileLocalServiceUtil.getSocialProfile(userId);
			return isUserActive(user, socialProfile);
		} catch (Exception e) {
			_log.error(e);
		}
		return false;
	}

	public static boolean isUserActive(User user, SocialProfile socialProfile) {

		try {
			Company company = CompanyLocalServiceUtil.getCompany(PortalUtil.getDefaultCompanyId());
			return (user.isActive() && (company.isStrangersVerify() ? user.isEmailAddressVerified() : true)
					&& SambaashConstants.REGISTRATION.USER_REGISTRATION_STATUS_ACTIVE
							.equalsIgnoreCase(socialProfile.getUserRegistrationStatus())) ? true : false;
		} catch (Exception e) {
			_log.error(e);
		}

		return false;
	}

	public static String getAttribute(HttpServletRequest request, String attribute, boolean defaultValue) {

		String value = (String) request.getAttribute(attribute);

		if (Validator.isNull(value)) {
			value = StringPool.BLANK;
		}

		return value;
	}

	public static void setOGTitle(String title, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.OG_PAGE_TITLE, title);
	}

	public static void setOGImage(String imageUrl, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.OG_PAGE_IMAGE, imageUrl);
	}

	public static void setOGAudio(String audioUrl, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.OG_PAGE_AUDIO, audioUrl);
	}

	public static void setOGVideo(String videoUrl, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.OG_PAGE_VIDEO, videoUrl);
	}

	public static void setOGVideoType(String videoType, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.OG_PAGE_VIDEO_TYPE, videoType);
	}

	public static void setOGUrl(String url, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.OG_PAGE_URL, url);
	}

	public static void setOGType(String type, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.OG_PAGE_TYPE, type);
	}

	public static void setOGSiteName(String siteName, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.OG_SITE_NAME, siteName);
	}

	public static void setFBAdmins(String fbAdmins, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.FB_ADMINS, fbAdmins);
	}

	public static void setFBAppId(String appId, HttpServletRequest request) {

		request.setAttribute(PropsKeys.FACEBOOK_CONNECT_APP_ID, appId);
	}

	public static void setOGDescription(String description, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.OG_PAGE_DESCRIPTION, description);
	}

	public static void setTwitterCard(String twitterCard, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.TWITTER_CARD, twitterCard);
	}

	public static void setTwitterSite(String twitterSite, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.TWITTER_SITE, twitterSite);
	}

	public static void setTwitterUrl(String twitterUrl, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.TWITTER_URL, twitterUrl);
	}

	public static void setTwitterTitle(String twitterTitle, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.TWITTER_TITLE, twitterTitle);
	}

	public static void setTwitterDescription(String twitterDescription, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.TWITTER_DESCRIPTION, twitterDescription);
	}

	public static void setTwitterImage(String twitterImage, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.TWITTER_IMAGE, twitterImage);
	}

	public static void setTwitterPlayer(String twitterPlayer, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.TWITTER_PLAYER, twitterPlayer);
	}

	public static void setTwitterPlayerWidth(String twitterPlayerWidth, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.TWITTER_PLAYER_WIDTH, twitterPlayerWidth);
	}

	public static void setTwitterPlayerHeight(String twitterPlayerHeight, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.TWITTER_PLAYER_HEIGHT, twitterPlayerHeight);
	}

	public static void setSchemaItempropItemtype(String schemaItempropItemtype, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.ACHEMA_ITEMPROP_ITEMTYPE, schemaItempropItemtype);
	}

	public static void setSchemaItempropThumbnail(String schemaItempropThumbnail, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.ACHEMA_ITEMPROP_THUMBNAIL, schemaItempropThumbnail);
	}

	public static void setSchemaItempropContentUrl(String schemaItempropContentUrl, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.ACHEMA_ITEMPROP_CONTENT_URL, schemaItempropContentUrl);
	}

	public static void setSchemaItempropUrl(String schemaItempropUrl, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.ACHEMA_ITEMPROP_URL, schemaItempropUrl);
	}

	public static void setSchemaItempropName(String schemaItempropName, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.ACHEMA_ITEMPROP_NAME, schemaItempropName);
	}

	public static void setSchemaItempropDescription(String schemaItempropDescription, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.ACHEMA_ITEMPROP_DESCRIPTION, schemaItempropDescription);
	}

	public static void setSchemaItempropEmbedUrl(String schemaItempropEmbedUrl, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.ACHEMA_ITEMPROP_EMBED_URL, schemaItempropEmbedUrl);
	}

	public static void setSchemaItempropPlayerType(String schemaItempropPlayerType, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.ACHEMA_ITEMPROP_PLAYER_TYPE, schemaItempropPlayerType);
	}

	public static void setSchemaItempropWidth(String schemaItempropWidth, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.ACHEMA_ITEMPROP_WIDTH, schemaItempropWidth);
	}

	public static void setSchemaItempropHeight(String schemaItempropHeight, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.ACHEMA_ITEMPROP_HEIGHT, schemaItempropHeight);
	}

	public static void setOmnitureTags(String omnitureTags, HttpServletRequest request) {

		request.setAttribute(SambaashConstants.OMNITURE.OMNITURE_TAGS, omnitureTags);
	}

	// public static final String ACHEMA_ITEMPROP_THUMBNAIL =
	// "schemaItempropThumbnail";
	//
	// public static final String ACHEMA_ITEMPROP_URL = "schemaItempropUrl";
	//
	// public static final String ACHEMA_ITEMPROP_NAME = "schemaItempropName";
	//
	// public static final String ACHEMA_ITEMPROP_DESCRIPTION =
	// "schemaItempropDescription";
	//
	// public static final String ACHEMA_ITEMPROP_PLAYER_TYPE =
	// "schemaItempropPlayerType";
	//
	// public static final String ACHEMA_ITEMPROP_WIDTH = "schemaItempropWidth";
	//
	// public static final String ACHEMA_ITEMPROP_HEIGHT =
	// "schemaItempropHeight";

	public static String getExpandoValueString(ExpandoBridge eb, String name, ThemeDisplay themeDisplay)
			throws SystemException {

		String eValue = StringPool.BLANK;
		long companyId = themeDisplay.getCompanyId();
		if (eb != null) {
			ExpandoColumn ec = ExpandoColumnLocalServiceUtil.getColumn(companyId, Layout.class.getName(),
					ExpandoTableConstants.DEFAULT_TABLE_NAME, name);
			if (ec != null) {
				ExpandoValue ev = ExpandoValueLocalServiceUtil.getValue(ec.getTableId(), ec.getColumnId(),
						eb.getClassPK());
				if (ev != null) {
					String data = ev.getData();
					if (Validator.isNotNull(data)) {
						eValue = data.substring(0, data.length());
					}
				}
			}
		}
		return eValue;
	}

	public static Serializable getLayoutExpandoValueByAttribute(ThemeDisplay themeDisplay, String name) {
		try {
			long companyId = themeDisplay.getCompanyId();

			if (themeDisplay.getLayout().getExpandoBridge().hasAttribute(name)) {
				ExpandoColumn ec = ExpandoColumnLocalServiceUtil.getColumn(companyId, Layout.class.getName(),
						ExpandoTableConstants.DEFAULT_TABLE_NAME, name);
				if (ExpandoColumnPermissionUtil.contains(themeDisplay.getPermissionChecker(), ec, ActionKeys.VIEW)) {
					if (_log.isDebugEnabled()) {
						_log.debug("has permission to view expando value");
					}
					return themeDisplay.getLayout().getExpandoBridge().getAttribute(name);
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return StringPool.BLANK;
	}

	public static Serializable getSiteExpandoValueByAttribute(ThemeDisplay themeDisplay, String name) {
		try {
			long companyId = themeDisplay.getCompanyId();

			if (themeDisplay.getSiteGroup().getExpandoBridge().hasAttribute(name)) {
				ExpandoColumn ec = ExpandoColumnLocalServiceUtil.getColumn(companyId, Group.class.getName(),
						ExpandoTableConstants.DEFAULT_TABLE_NAME, name);
				if (ExpandoColumnPermissionUtil.contains(themeDisplay.getPermissionChecker(), ec, ActionKeys.VIEW)) {
					if (_log.isDebugEnabled()) {
						_log.debug("has permission to view expando value");
					}
					return themeDisplay.getSiteGroup().getExpandoBridge().getAttribute(name);
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return StringPool.BLANK;
	}

	public static Serializable getRoleExpandoValueByAttribute(ThemeDisplay themeDisplay, Role role, String name) {
		try {
			long companyId = themeDisplay.getCompanyId();
			if (role.getExpandoBridge().hasAttribute(name)) {
				ExpandoColumn ec = ExpandoColumnLocalServiceUtil.getColumn(companyId, Role.class.getName(),
						ExpandoTableConstants.DEFAULT_TABLE_NAME, name);
				if (ExpandoColumnPermissionUtil.contains(themeDisplay.getPermissionChecker(), ec, ActionKeys.VIEW)) {
					if (_log.isDebugEnabled()) {
						_log.debug("has permission to view expando value");
					}
					return role.getExpandoBridge().getAttribute(name);
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return StringPool.BLANK;
	}

	public static boolean isUserSignedIn(HttpServletRequest request) {

		try {
			User user = null;
			Company company;

			company = PortalUtil.getCompany(request);

			try {
				user = PortalUtil.getUser(request);
			} catch (NoSuchUserException nsue) {
				_log.error(" isUserSignedIn : NoSuchUserException thrown");
			}

			if (user == null) {
				user = company.getDefaultUser();
			} else if (!user.isDefaultUser()) {
				return true;
			}
		} catch (PortalException e) {
			_log.error(" isUserSignedIn : PortalException thrown");
		} catch (SystemException e) {
			_log.error(" isUserSignedIn : SystemException thrown");
		}

		return false;
	}

	public static void sendError(String exceptionMessage, ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException {

		StringBundler sb = new StringBundler(7);

		sb.append(PortalUtil.getPathMain());
		sb.append("/portal/status?status=");
		sb.append(0);
		sb.append("&exception=");
		sb.append(exceptionMessage);
		actionResponse.sendRedirect(sb.toString());
	}

	/**
	 * @param scopeGroupId
	 * @param userId
	 * @return String dashboard url with format (/{dashboard} or
	 *         /{web/community_name/dashboard})
	 */
	public static String getDashboardUrl(long scopeGroupId, long userId) {

		String dashboardUrl = StringPool.BLANK;
		try {

			User user = UserLocalServiceUtil.getUser(userId);
			if (isMarketer(user)) {

				dashboardUrl = getCommunityPath(scopeGroupId) + StringPool.FORWARD_SLASH
						+ SambaashUtil.getParameter(SambaashConstants.DASHBOARD.MARKETER_DASHBOARD, scopeGroupId);
				_log.debug(" Individual : " + userId + " : " + " dashboardUrl  : " + dashboardUrl);

			} else if (isScout(user)) {
				dashboardUrl = getCommunityPath(scopeGroupId) + StringPool.FORWARD_SLASH
						+ SambaashUtil.getParameter(SambaashConstants.DASHBOARD.SCOUT_DASHBOARD, scopeGroupId);
			} else if (isFoundryAdmin(user)) {
				dashboardUrl = getCommunityPath(scopeGroupId) + StringPool.FORWARD_SLASH
						+ SambaashUtil.getParameter(SambaashConstants.DASHBOARD.FOUNDRY_ADMIN_DASHBOARD, scopeGroupId);
			} else if (isStartup(user)) {

				dashboardUrl = getCommunityPath(scopeGroupId) + StringPool.FORWARD_SLASH
						+ SambaashUtil.getParameter(SambaashConstants.DASHBOARD.STARTUP_DASHBOARD, scopeGroupId);
				_log.debug(" Individual : " + userId + " : " + " dashboardUrl  : " + dashboardUrl);

			} else {

				dashboardUrl = getCommunityPath(scopeGroupId) + StringPool.FORWARD_SLASH
						+ SambaashUtil.getParameter(SambaashConstants.URL.PROFILE_IND_LADNING, scopeGroupId);
				_log.debug(" Individual : " + userId + " : " + " dashboardUrl  : " + dashboardUrl);
			}
		} catch (Exception e) {
			_log.error("Unable to get dashboard url.");
		}

		return dashboardUrl;
	}

	public static void logMessage(String name, String message) {

		_log.debug(name + " : " + message);
	}

	/** MIKE **/
	public static String HtmlParser(String content) {

		// Compile the regular expression pattern for a typical HTML tag
		java.util.regex.Pattern tag = java.util.regex.Pattern.compile("<.*?>");
		java.util.regex.Matcher mtag = tag.matcher(content);

		while (mtag.find()) {
			content = mtag.replaceAll(StringPool.BLANK);
		}

		// Remove special characters, such as &nbsp; and replace litteral
		// character
		java.util.regex.Pattern sChar = java.util.regex.Pattern.compile("&.*?;");
		java.util.regex.Matcher msChar = sChar.matcher(content);

		while (msChar.find()) {
			content = msChar.replaceAll(StringPool.BLANK);
		}

		return content;
	}

	public static String getProfileImageURL(String themeDispImagePath, User user)
			throws PortalException, SystemException {

		String imgPath = themeDispImagePath;
		long portraitID = 0;
		boolean isMale = true;

		if (Validator.isNotNull(user)) {
			portraitID = user.getPortraitId();
			isMale = user.isMale();
		}

		if (isMale) {
			imgPath += "/user_male_portrait?img_id=";
		} else {
			imgPath += "/user_female_portrait?img_id=";
		}

		imgPath += portraitID + "&t=" + WebServerServletTokenUtil.getToken(portraitID);

		_log.debug("Profile Image Path: " + imgPath);
		return imgPath;
	}

	public static long getUserIdByScreenName(long companyId, String friendlyURL) {

		if (Validator.isNull(friendlyURL)) {
			return 0;
		}
		long userId = 0;
		try {
			String screenName = friendlyURL.replaceAll("/", StringPool.BLANK);
			screenName = screenName.replaceAll(" ", StringPool.PLUS);
			if (friendlyURL.contains("?user=")) {
				screenName = friendlyURL.substring(friendlyURL.indexOf("=") + 1, friendlyURL.length());
				userId = UserLocalServiceUtil.getUserIdByScreenName(companyId, screenName);
			} else {
				userId = UserLocalServiceUtil.getUserIdByScreenName(companyId, screenName);
			}

		} catch (NoSuchUserException e) {
			_log.debug("No user found with the screen name" + friendlyURL);
		} catch (PortalException e) {
			_log.error(e.getMessage());
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}
		return userId;
	}

	public static PortletURL getPortletURL(HttpServletRequest request, String portletId, long scopeGroupId)
			throws Exception {

		Layout layout = (Layout) request.getAttribute(WebKeys.LAYOUT);

		long layoutGroupId = scopeGroupId;

		if (layout != null) {
			layoutGroupId = layout.getGroupId();
		}

		long plid = LayoutServiceUtil.getDefaultPlid(layoutGroupId, scopeGroupId, false, portletId);

		if (plid == 0) {
			plid = LayoutServiceUtil.getDefaultPlid(layoutGroupId, scopeGroupId, true, portletId);
		}

		if (plid == 0) {
			if (layout != null) {
				plid = layout.getPlid();
			}
		}

		PortletURL portletURL = PortletURLFactoryUtil.create(request, portletId, plid, PortletRequest.RENDER_PHASE);

		portletURL.setWindowState(WindowState.MAXIMIZED);
		portletURL.setPortletMode(PortletMode.VIEW);

		return portletURL;
	}

	public static String getMimeType(String name) {

		String mime = "";
		if ((name != null) && (!name.isEmpty())) {
			if (name.endsWith(".pdf")) {
				mime = "application/pdf";
			} else if (name.endsWith(".xls")) {
				mime = "application/vnd.ms-excel";
			} else if (name.endsWith(".doc")) {
				mime = "application/msword";
			} else if (name.endsWith(".docx")) {
				mime = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
			} else if (name.endsWith(".eps")) {
				mime = "application/postscript";
			} else if (name.endsWith(".ppt")) {
				mime = "application/vnd.ms-powerpoint";
			} else if (name.endsWith(".pptx")) {
				mime = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
			} else if (name.endsWith(".psd")) {
				mime = "application/x-photoshop";
			} else if (name.endsWith(".ai")) {
				mime = "application/postscript";
			} else if (name.endsWith(".dxf")) {
				mime = "application/dxf";
			} else if (name.endsWith(".ps")) {
				mime = "application/postscript";
			} else if (name.endsWith(".xps")) {
				mime = "application/zip";
			} else if (name.endsWith(".ttf")) {
				mime = "application/x-font-ttf";
			}
		}
		return mime;

	}

	public static long getGroupId(long companyId) throws SystemException {

		Group group = null;
		try {
			group = GroupLocalServiceUtil.getGroup(companyId, PropsUtil.get(PropsKeys.VIRTUAL_HOSTS_DEFAULT_SITE_NAME));

		} catch (PortalException e) {
			_log.error(e.getMessage());
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		if (group == null) {
			return 0;
		}

		return group.getGroupId();
	}

	public static String getThirdPartyAppUrl(long groupId) {

		String value = StringPool.BLANK;
		try {
			SPParameter parameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(groupId,
					SambaashConstants.THIRD_PARTY_VIRTUAL_HOST);
			value = parameter.getValue();

			return "https://" + parameter.getValue();
		} catch (NoSuchSPParameterException e) {
			_log.info("No such spparameter exist with  groupId: " + groupId);
		} catch (Exception e) {
			_log.error("Exception getting SPParameter ==" + e.getMessage());
		}
		return value;
	}

	public static String getChannelPrefix() {

		String prefix = StringPool.BLANK;

		if (Validator.isNotNull(PropsUtil.get(SambaashConstants.COMETD_DEVELOPER))
				&& StringPool.TRUE.equalsIgnoreCase(PropsUtil.get(SambaashConstants.COMETD_DEVELOPER))) {
			prefix = "dev";
		} else {
			prefix = PropsUtil.get(PropsKeys.VIRTUAL_HOSTS_DEFAULT_SITE_NAME);
		}

		return StringPool.FORWARD_SLASH + prefix + StringPool.FORWARD_SLASH;

	}

	public static boolean isThirdpartyIntegrationEnabled() {

		String value = getParameter(SambaashConstants.THIRD_PARTY_INTEGRATION_ENABLED,
				PortalUtil.getDefaultCompanyId());
		return StringPool.TRUE.equalsIgnoreCase(value) ? true : false;
	}

	public static String getVirtualHost(long scopeGroupId) {

		return getParameter(SambaashConstants.VIRTUALHOST, scopeGroupId);
	}

	public static boolean isCometdEnabled() {

		boolean isEnabled = Boolean.parseBoolean(
				getParameter(SambaashConstants.COMETD_ENABLED, Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID)));
		if (_log.isDebugEnabled()) {
			_log.debug("isCometdEnabled : " + isEnabled);
		}
		return isEnabled;
	}

	public static String getValidFileName(String fileName) {

		if (Validator.isNotNull(fileName) && fileName.length() > 0 && fileName.contains(".")) {
			StringBuilder name = new StringBuilder();
			String fileN = fileName.substring(0, fileName.lastIndexOf("."));
			String extension = fileName.substring(fileName.lastIndexOf("."));
			if (Validator.isNotNull(fileN) && fileN.length() > 0) {
				for (char c : fileN.toCharArray()) {
					if (Character.isLetterOrDigit(c)) {
						name.append(c);
					}
				}

			}

			fileName = name.toString() + extension;

		}

		if (_log.isDebugEnabled()) {
			_log.debug("fileName : " + fileName);
		}

		return fileName;

	}

	public static String getPreviewURL(FileEntry fileEntry, FileVersion fileVersion, String queryString,
			boolean appendToken) {

		com.liferay.portal.kernel.util.StringBundler sb = new com.liferay.portal.kernel.util.StringBundler(13);

		sb.append("/documents/");
		sb.append(fileEntry.getRepositoryId());
		sb.append(com.liferay.portal.kernel.util.StringPool.SLASH);
		sb.append(fileEntry.getFolderId());
		sb.append(com.liferay.portal.kernel.util.StringPool.SLASH);
		sb.append(com.liferay.portal.kernel.util.HttpUtil
				.encodeURL(com.liferay.portal.kernel.util.HtmlUtil.unescape(fileEntry.getTitle()), true));
		sb.append("?version=");
		sb.append(fileVersion.getVersion());

		if (appendToken) {
			sb.append("&t=");

			java.util.Date modifiedDate = fileVersion.getModifiedDate();

			sb.append(modifiedDate.getTime());
		}

		sb.append(queryString);
		return sb.toString();
	}

	public static String getVideoSharingUrl(FileEntry fileEntry, FileVersion fileVersion, ThemeDisplay themeDisplay,
			boolean appendToken) {

		com.liferay.portal.kernel.util.StringBundler sb = new com.liferay.portal.kernel.util.StringBundler(13);
		String fileName = fileEntry.getTitle();
		sb.append(themeDisplay.getPortalURL());
		sb.append(themeDisplay.getPathContext());
		sb.append("/spasset/video/");
		sb.append(fileEntry.getRepositoryId());
		sb.append(com.liferay.portal.kernel.util.StringPool.SLASH);
		sb.append(fileEntry.getFileEntryId());
		sb.append(com.liferay.portal.kernel.util.StringPool.SLASH);
		sb.append(com.liferay.portal.kernel.util.HttpUtil.encodeURL(com.liferay.portal.kernel.util.HtmlUtil
				.unescape(fileName.substring(0, fileName.lastIndexOf(StringPool.PERIOD)) + ".mp4"), true));
		return sb.toString();
	}

	public static String getTestGroupEmail() {

		return getParameter(SambaashConstants.SPMAIL.MAIl_TEST_GROUP,
				Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID));
	}

	public static boolean isOmnitureEnabled() {

		return Boolean.parseBoolean(getParameter(SambaashConstants.OMNITURE.OMNITURE_ENABLED,
				Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID)));
	}

	public static boolean isOmnitureProduction() {

		return Boolean.parseBoolean(getParameter(SambaashConstants.OMNITURE.OMNITURE_PROD,
				Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID)));
	}

	public static String getOmnitureConstant() {

		return getParameter(SambaashConstants.OMNITURE.OMNITURE_CONSTANT,
				Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID));
	}

	public static boolean isNeo4jEnabled() {

		String enableNeo4j = getParameter(SambaashConstants.NEO4J.ENABLE_NEO4J,
				Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID));
		if (Validator.isNotNull(enableNeo4j)) {
			return Boolean.parseBoolean(enableNeo4j);
		}

		return false;
	}

	public static String getNeo4jHostUrl() {

		return getParameter(SambaashConstants.NEO4J.NEO4J_SERVICE_HOST_URL,
				Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID));
	}

	public static boolean isWebSocketEnabled() {

		String enableWebSockets = getParameter(SambaashConstants.WEBSOCKETS.ENABLE_WEBSOCKETS,
				Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID));

		if (Validator.isNotNull(enableWebSockets)) {
			return Boolean.parseBoolean(enableWebSockets);
		}

		return false;
	}

	public static String getWebSocketHostUrl() {

		return getParameter(SambaashConstants.WEBSOCKETS.WEBSOCKETS_HOST_URL,
				Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID));
	}

	public static String getSecondaryDomain() {

		return getParameter(SambaashConstants.SECONDARY_DOMAIN, Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID));
	}

	/**
	 * @param userId
	 * @return
	 */
	public static String getUserDepartment(long userId) {
		if (SambaashUtil.isLdapEnabled()) {
			try {

				SPLdapProfile spLdapProfile = SPLdapProfileLocalServiceUtil.findByUserId(userId);

				if (Validator.isNotNull(spLdapProfile)) {

					AssetCategory category = AssetCategoryLocalServiceUtil
							.getAssetCategory(spLdapProfile.getDepartmentId());
					return category.getName();

				}

			} catch (PortalException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			}
		}
		return StringPool.BLANK;
	}

	/**
	 * @param userId
	 * @return
	 */
	public static String getUserCountry(long userId) {

		if (SambaashUtil.isLdapEnabled()) {
			try {

				SPLdapProfile spLdapProfile = SPLdapProfileLocalServiceUtil.findByUserId(userId);

				if (Validator.isNotNull(spLdapProfile)) {

					AssetCategory category = AssetCategoryLocalServiceUtil
							.getAssetCategory(spLdapProfile.getCountryId());
					return category.getName();
				}

			} catch (PortalException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			}
		}
		return StringPool.BLANK;

	}

	/**
	 * @param companyId
	 * @return
	 */
	public static long getDefaultViewRoleId(long companyId) {
		try {
			return RoleLocalServiceUtil.getRole(companyId, SambaashConstants.DEFAULT_VIEW_ROLE).getRoleId();
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		return -1L;
	}

	public static boolean isSocialLoginEnabled() {
		return StringPool.TRUE.equalsIgnoreCase(SambaashUtil.getParameter(SambaashConstants.SOCIAL_LOGIN_VISIBLE,
				Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID))) ? true : false;
	}

	public static boolean isSocialShareEnabled() {
		return StringPool.TRUE.equalsIgnoreCase(SambaashUtil.getParameter(SambaashConstants.SOCIAL_BOOKMARKS_VISIBLE,
				Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID))) ? true : false;
	}

	public static boolean isCommentsEnabled() {
		return StringPool.TRUE.equalsIgnoreCase(SambaashUtil.getParameter(SambaashConstants.ENABLE_COMMENTS,
				Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID))) ? true : false;
	}

	/**
	 * @param boolean
	 * @return
	 */
	public static boolean isNonAdUser(User user) {
		boolean nonAdUser = false;
		try {
			ExpandoBridge bridge = user.getExpandoBridge();
			return (boolean) ExpandoValueLocalServiceUtil.getData(user.getCompanyId(), bridge.getClassName(),
					ExpandoTableConstants.DEFAULT_TABLE_NAME, SambaashConstants.USER.NON_AD, user.getUserId(), false);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return nonAdUser;
	}

	/**
	 * @param content
	 * @return
	 */
	public static String encrypt(String content) {
		return SPMailLocalServiceUtil.encryptLink(content);
	}

	/**
	 * @param content
	 * @return
	 */
	public static String decrypt(String content) {
		return SPMailLocalServiceUtil.decryptLink(content);
	}

	public static List<AssetCategory> getCategories(long vocabularyId) {
		List<AssetCategory> categories = new ArrayList<AssetCategory>();
		if (vocabularyId != 0) {
			try {
				categories = AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabularyId, -1, -1, null);
			} catch (SystemException e) {
				// _log.error(e.getMessage(), e);
			}
		}

		return categories;
	}

	public static List<AssetVocabulary> getAllAssetVocabularies() {
		List<AssetVocabulary> assetVocabularies = new ArrayList<AssetVocabulary>();
		try {
			assetVocabularies = AssetVocabularyLocalServiceUtil.getAssetVocabularies(-1, -1);
		} catch (SystemException e) {
			_log.error("Error while fetching vocabularies");
		}
		return assetVocabularies;
	}

	public static Map<String, String> getParameterMap(PortletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		Enumeration<String> enm = request.getParameterNames();
		while (enm.hasMoreElements()) {
			String key = enm.nextElement();
			map.put(key, request.getParameter(key));
		}
		return map;
	}

	public static boolean isMembershipPackageDisabled() {
		return StringPool.TRUE.equalsIgnoreCase(SambaashUtil.getParameter(SambaashConstants.MEMBERSHIP_PACKAGE_DISABLED,
				Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID))) ? true : false;
	}

	public static boolean isDefaultPackageEnabled() {
		return StringPool.TRUE.equalsIgnoreCase(SambaashUtil.getParameter(SambaashConstants.DEFAULT_PACKAGE_ENABLED,
				Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID))) ? true : false;
	}

	public static long getDefaultMembershipPackageId() {
		long mpId = 0;
		String paramValue = SambaashUtil.getParameter(SambaashConstants.INDIVIDUAL_DEFAULT_PACKAGE,
				Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID));
		if (Validator.isNotNull(paramValue)) {
			mpId = Long.parseLong(paramValue);
		}
		return mpId;
	}

	// public static List<ChallengeBean> getAllActiveChallenges(ThemeDisplay
	// themeDisplay) {
	// List<Document> docs =
	// SPChallengeLocalServiceUtil.getChallenges(PortalUtil.getDefaultCompanyId(),
	// -1, -1,
	// StringPool.BLANK, true);
	// List<ChallengeBean> list = new ArrayList<ChallengeBean>();
	// for (Document doc : docs) {
	// ChallengeBean bean = new ChallengeBean();
	// long challengeId = GetterUtil.getLong(doc.get("entryClassPK"));
	// bean.setName(GetterUtil.getString(doc.get("name")));
	// bean.setDescription("description");
	// bean.setChallengeId(challengeId);
	// bean.setImageUrl(getDLFileUrl(themeDisplay,
	// GetterUtil.getLong(doc.get("fileEntryId"))));
	// bean.setDetailsUrl(SPChallengeLocalServiceUtil.displayChallengeFriendlyURL(themeDisplay,
	// challengeId));
	// // bean.setEditUrl("");
	// list.add(bean);
	// }
	// return list;
	// }

	public static List<StrartupProfileBean> getUserStartupProfiles(ThemeDisplay themedisplay) {
		List<StrartupProfileBean> list = new ArrayList<StrartupProfileBean>();
		List<Organization> orgs = OrganizationLocalServiceUtil.getUserOrganizations(themedisplay.getUserId());
		List<SPATOContacts> atoContacts = SPATOContactsLocalServiceUtil.findATOContactsBySecondaryContact(themedisplay.getUserId());
		List<Organization> scOrgs = new ArrayList<Organization>();
		List<Organization> allOrgs = new ArrayList<Organization>();
		try{
			if(atoContacts != null && atoContacts.size() > 0){
				scOrgs = OrganizationLocalServiceUtil.getUserOrganizations(Long.valueOf(atoContacts.get(0).getPrimaryPrincipalUserId()));
				
				if(scOrgs != null && scOrgs.size() > 0){
					for(Organization e:scOrgs)
					{
						allOrgs.add(e);
					}
					
					//orgs.addAll(scOrgs);
				}
			}
			for(Organization e:orgs)
			{
				allOrgs.add(e);
			}
		}
		catch(Exception e){
			_log.error(e);
		}
		if (Validator.isNotNull(allOrgs)) {
			for (Organization organization : allOrgs) {
				StrartupProfileBean bean = new StrartupProfileBean();
				if (organization.getCompleteness())
					bean.setName(organization.getName());
				else
					bean.setName(organization.getName() + "(Incomplete)");
				if (organization.getName().length() >= 13)
					bean.setShortName(organization.getName().substring(0, 10) + "..");
				else
					bean.setShortName(organization.getName());
				bean.setDetailsUrl(OrganizationLocalServiceUtil.displayFriendlyURL(themedisplay,
						organization.getOrganizationId()));
				bean.setEditUrl(
						OrganizationLocalServiceUtil.editFriendlyURL(themedisplay, organization.getOrganizationId()));
				bean.setImageUrl(getDLFileUrl(themedisplay, organization.getLogoId()));
				list.add(bean);
			}
		}
		return list;
	}

	public static String getDLFileUrl(PortletRequest request, long fileEntryId) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		return getDLFileUrl(themeDisplay, fileEntryId);
	}

	public static String getDLFileIconUrl(PortletRequest request, long fileEntryId) {
		String logoUrl = getDLFileUrl(request, fileEntryId);
		if (Validator.isNotNull(logoUrl) && logoUrl.length() > 1) {
			return logoUrl + "&imageThumbNail=2";
		}
		return logoUrl;
	}

	public static String getDLFileUrl(long fileEntryId) {
		FileEntry fileEntry;
		String url = StringPool.BLANK;
		if (fileEntryId != 0) {
			try {
				// implementation taken from DLImpl.getPreviewURL
				fileEntry = DLAppServiceUtil.getFileEntry(fileEntryId);
				String portalUrl = getPortalURL(fileEntry.getCompanyId(), fileEntry.getGroupId());
				StringBundler sb = new StringBundler();

				sb.append(portalUrl);
				sb.append("/documents/");
				sb.append(fileEntry.getRepositoryId());
				sb.append(StringPool.SLASH);
				sb.append(fileEntry.getFolderId());
				sb.append(StringPool.SLASH);

				String title = fileEntry.getTitle();

				if (fileEntry.isInTrash()) {
					title = TrashUtil.getOriginalTitle(fileEntry.getTitle());
				}

				sb.append(HttpUtil.encodeURL(HtmlUtil.unescape(title)));

				sb.append(StringPool.SLASH);
				sb.append(fileEntry.getUuid());

				sb.append("?version=");
				sb.append(fileEntry.getLatestFileVersion().getVersion());

				url = sb.toString();
			} catch (Exception e1) {
				_log.error(e1);
			}
		}
		return url;
	}

	public static String getDLFileUrl(ThemeDisplay themeDisplay, long fileEntryId) {
		FileEntry fileEntry;
		String url = StringPool.BLANK;
		if (fileEntryId != 0) {
			try {
				fileEntry = DLAppServiceUtil.getFileEntry(fileEntryId);
				url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
						+ themeDisplay.getScopeGroupId() + StringPool.SLASH + fileEntry.getFolderId() + StringPool.SLASH
						+ HttpUtil.encodeURL(fileEntry.getTitle(), true) + "?version="
						+ fileEntry.getLatestFileVersion().getVersion();
			} catch (PortalException e1) {
				_log.error("Unable to generated File URL", e1);
			} catch (SystemException e1) {
				_log.error("Unable to generated File URL", e1);
			}
		}
		return url;
	}

	public static boolean isLdapEnabled() {
		try {
			return Boolean.parseBoolean(
					PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(), PropsKeys.LDAP_AUTH_ENABLED));
		} catch (Exception e) {
		}
		return false;
	}

	public static boolean isStartup(User user) {
		try {

			if (user.isDefaultUser()) {
				return false;
			}

			ExpandoBridge bridge = user.getExpandoBridge();
			if (ProfileType.STARTUP.getValue()
					.equalsIgnoreCase(((String[]) ExpandoValueLocalServiceUtil.getData(user.getCompanyId(),
							bridge.getClassName(), ExpandoTableConstants.DEFAULT_TABLE_NAME,
							SambaashConstants.PROFILE_TYPE, user.getUserId(), new String[] {}))[0])) {
				if (_log.isDebugEnabled()) {
					_log.debug(ProfileType.STARTUP.getValue());
				}
				return true;

			}
		} catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.error(e.getMessage());
			}
		}
		return false;
	}

	public static boolean isMarketer(User user) {
		try {

			if (user.isDefaultUser()) {
				return false;
			}

			ExpandoBridge bridge = user.getExpandoBridge();

			String[] pList = (String[]) ExpandoValueLocalServiceUtil.getData(user.getCompanyId(), bridge.getClassName(),
					ExpandoTableConstants.DEFAULT_TABLE_NAME, SambaashConstants.PROFILE_TYPE, user.getUserId(),
					new String[] {});
			String profileType = StringPool.BLANK;
			if (ArrayUtil.isNotEmpty(pList) && pList.length > 0) {
				profileType = pList[0];
			}

			if (ProfileType.MARKETER.getValue().equalsIgnoreCase(profileType)) {
				if (_log.isDebugEnabled()) {
					_log.debug(ProfileType.MARKETER.getValue());
				}
				return true;

			}

		} catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.error(e.getMessage());
			}
		}
		return false;
	}

	public static boolean isScout(User user) {
		try {

			if (user.isDefaultUser()) {
				return false;
			}

			ExpandoBridge bridge = user.getExpandoBridge();

			String[] pList = (String[]) ExpandoValueLocalServiceUtil.getData(user.getCompanyId(), bridge.getClassName(),
					ExpandoTableConstants.DEFAULT_TABLE_NAME, SambaashConstants.PROFILE_TYPE, user.getUserId(),
					new String[] {});
			String profileType = StringPool.BLANK;
			if (ArrayUtil.isNotEmpty(pList) && pList.length > 0) {
				profileType = pList[0];
			}

			if (ProfileType.SCOUT.getValue().equalsIgnoreCase(profileType)) {
				if (_log.isDebugEnabled()) {
					_log.debug(ProfileType.SCOUT.getValue());
				}
				return true;

			}

		} catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.error(e.getMessage());
			}
		}
		return false;
	}

	public static boolean isMentor(User user) {

		if (user.isDefaultUser()) {
			return false;
		}

		boolean isMentor = false;
		try {
			ExpandoBridge bridge = user.getExpandoBridge();

			isMentor = (boolean) ExpandoValueLocalServiceUtil.getData(user.getCompanyId(), bridge.getClassName(),
					ExpandoTableConstants.DEFAULT_TABLE_NAME, SambaashConstants.MENTOR, user.getUserId(), false);

			if (_log.isDebugEnabled()) {
				_log.debug(SambaashConstants.MENTOR + isMentor);
			}

		} catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.error(e.getMessage());
			}
		}

		return isMentor;
	}

	public static String getCategoryNameForSpParamVocKey(String vocKey, long[] categoryIds) {
		String name = StringPool.BLANK;
		try {
			List<Long> list = getLongList(categoryIds);
			long vocId = GetterUtil.getLong(SambaashUtil.getParameter(vocKey, 0));
			AssetCategory assetCategory = getCategory(vocId, list);
			if (Validator.isNotNull(assetCategory)) {
				name = assetCategory.getName();
			}
		} catch (Exception ex) {

		}
		return name;
	}

	public static List<Long> getLongList(long[] categoryIds) {
		List<Long> list = new ArrayList<Long>();
		if (Validator.isNotNull(categoryIds)) {
			for (Long long1 : categoryIds) {
				list.add(long1);
			}
		}
		return list;
	}

	public static AssetCategory getCategory(long vocId, List<Long> categoryIds) {
		// long countryVocId = GetterUtil.getLong(prefs.getValue(vocKey, "0"));
		AssetCategory assetCategory = null;
		try {
			if (Validator.isNotNull(categoryIds)) {
				for (Long l : categoryIds) {
					if (Validator.isNotNull(l)) {
						AssetCategory category = AssetCategoryLocalServiceUtil.getAssetCategory(l);
						if (category.getVocabularyId() == vocId) {
							assetCategory = category;
							break;
						}
					}
				}
			}

		} catch (Exception ex) {

		}
		return assetCategory;
	}

	public static void addCountryDeptRoles(long userId, long companyId, String country, String dept) {
		if (Validator.isNotNull(country) && Validator.isNotNull(dept)) {
			String name = StringPool.BLANK;
			name = String.format(SambaashConstants.ESN_USER_ROLE_FORMAT, country, dept);
			Role role = addRoleIfNotExist(companyId, name);
			if (userId != 0 && Validator.isNotNull(role)) {
				try {
					RoleLocalServiceUtil.addUserRoles(userId, new long[] { role.getRoleId() });
				} catch (Exception e) {
					_log.error("Error while assigning the role" + e);
				}
			}
			name = String.format(SambaashConstants.ESN_ADMIN_ROLE_FORMAT, country, dept);
			addRoleIfNotExist(companyId, name);
			name = String.format(SambaashConstants.ESN_DOC_CONTROL_ROLE_FORMAT, country, dept);
			addRoleIfNotExist(companyId, name);
		} else {
			_log.error("Country or Department is null,So cannot assign default role countr-dept-User. country = "
					+ country + " Department = " + dept);
		}
	}

	public static Role addRoleIfNotExist(long companyId, String name) {
		Role role = null;
		try {
			role = RoleLocalServiceUtil.getRole(companyId, name);
		} catch (NoSuchRoleException ex) {
			role = addRole(companyId, name);
		} catch (Exception ex) {
			_log.error(ex);
		}
		return role;
	}

	public static Role addRole(long companyId, String name) {

		Map<Locale, String> titleMap = new HashMap<Locale, String>();
		titleMap.put(Locale.US, name);
		Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
		descriptionMap.put(Locale.US, name);
		int type = RoleConstants.TYPE_REGULAR;

		try {
			// TODO: Have to work on below depricate method
			// return RoleLocalServiceUtil.addRole(0, companyId, name, titleMap,
			// descriptionMap, type);
			return RoleLocalServiceUtil.addRole(getAdminUserId(), null, 0, name, titleMap, descriptionMap, type, null,
					null);
		} catch (Exception e) {
			_log.error("Error while adding role " + e);
		}
		return null;

	}

	public static boolean isFoundryAdmin(User user) throws PortalException, SystemException {
		boolean authorized = false;
		List<Role> roles = user.getRoles();
		String temp = SambaashUtil.getParameter("foundry.admin.rolenames", 0);
		if (Validator.isNull(temp)) {
			temp = "Foundry Admin";
		}
		String[] privilegedRoles = temp.split(",");
		if (Validator.isNotNull(roles)) {
			for (Role role : roles) {
				for (String prole : privilegedRoles) {
					if (role.getName().equalsIgnoreCase(GetterUtil.getString(prole))) {
						authorized = true;
						break;
					}
				}
			}
		}

		return authorized;
	}


	public static String getEmailFromName(long companyId, SPMailTemplate spMailTemplate) {
		if (Validator.isNotNull(spMailTemplate) && Validator.isNotNull(spMailTemplate.getFromName())) {
			return spMailTemplate.getFromName();
		} else {
			try {
				return PrefsPropsUtil.getString(companyId, PropsKeys.ADMIN_EMAIL_FROM_NAME);
			} catch (SystemException e) {
				_log.error(e.getMessage());
				return StringPool.BLANK;
			}
		}
	}

	public static String getEmailFromAddress(long companyId, SPMailTemplate spMailTemplate) {
		if (Validator.isNotNull(spMailTemplate) && Validator.isNotNull(spMailTemplate.getFromAddress())) {
			return spMailTemplate.getFromAddress();
		} else {
			try {
				return PrefsPropsUtil.getString(companyId, PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
			} catch (SystemException e) {
				_log.error(e.getMessage());
				return StringPool.BLANK;
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public static void fillAudit(BaseModel baseModel, ThemeDisplay themeDisplay, boolean isNew) {
		fillAudit(baseModel, themeDisplay.getUser(), themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(),
				isNew);
	}

	public static void fillAudit(BaseModel<?> baseModel, User user, long companyId, long groupId, boolean isNew) {

		if (baseModel instanceof GroupedModel) {
			GroupedModel groupedModel = (GroupedModel) baseModel;
			groupedModel.setGroupId(groupId);
		}
		if (baseModel instanceof AuditedModel) {
			AuditedModel auditedModel = (AuditedModel) baseModel;
			Date now = new Date();
			if (isNew) {
				auditedModel.setCreateDate(now);
			}
			auditedModel.setModifiedDate(now);
			auditedModel.setUserId(user.getUserId());
			auditedModel.setUserName(user.getFullName());
			auditedModel.setCompanyId(user.getCompanyId());
		}

	}

	// For lithan country logic

	public static String getLocationBasedURL(String localeStr, HttpServletRequest request) {
		try {

			String currentUrl = PortalUtil.getCurrentURL(request);

			// if invalid language
			if (!getEnabledLanguageIds().contains(localeStr)) {
				return StringPool.SLASH;
			}

			// if root
			if (currentUrl.split(StringPool.SLASH).length == 0) {
				return StringPool.SLASH + localeStr;
			}

			String firstToken = getFirstTokenInURL(currentUrl);

			if (getEnabledLanguageIds().contains(firstToken)) {
				// if url with existing languageId
				currentUrl = currentUrl.substring(currentUrl.indexOf(firstToken) + firstToken.length());
				currentUrl = StringPool.SLASH + localeStr + StringPool.SLASH + currentUrl;
				currentUrl = currentUrl.replaceAll("\\/+", StringPool.SLASH);
				return currentUrl;
			} else {
				// if without lanauage id
				currentUrl = StringPool.SLASH + localeStr + currentUrl;
				currentUrl = currentUrl.replaceAll("\\/+", StringPool.SLASH);
				return currentUrl;
			}
		} catch (Exception e) {
			return StringPool.SLASH;
		}

	}

	private static String getFirstTokenInURL(String str) {
		String[] arr = str.split(StringPool.SLASH);
		for (String string : arr) {
			if (Validator.isNotNull(string))
				return string;
		}
		return "";
	}

	public static String getLocationFromUrl(HttpServletRequest request) {
		try {
			String currentUrl = PortalUtil.getCurrentURL(request);
			String langId = getFirstTokenInURL(currentUrl);
			if (getEnabledLanguageIds().contains(langId))
				return langId;
			else
				return "international";
		} catch (Exception e) {
			return "international";
		}
	}

	public static Set<String> getEnabledLanguageIds() {

		if (enabledLocales.size() > 0) {
			return enabledLocales;
		}

		String locales = PropsUtil.get(PropsKeys.LOCALES);
		String[] arr = locales.split(",");
		enabledLocales.addAll(Arrays.asList(arr));
		for (String localeItem : arr) {
			if (localeItem.split("_").length > 0) {
				enabledLocales.add(localeItem.split("_")[0]);
			}
		}
		return enabledLocales;
	}

	private static Set<String> enabledLocales = new HashSet<String>();

	// End

	public static String convertToDateRangeString(String startDateStr, String endDateStr, boolean showTime) {
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = new Date(GetterUtil.getLong(GetterUtil.getLong(startDateStr)));
			endDate = new Date(GetterUtil.getLong(GetterUtil.getLong(endDateStr)));
		} catch (Exception e) {
			return StringPool.BLANK;
		}
		return convertToDateRangeString(startDate, endDate, showTime);
	}

	public static String convertToDateRangeString(Date startDate, Date endDate, boolean showTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy" + (showTime ? ", hh:mm aa" : ""));
		if (Validator.isNull(startDate))
			return StringPool.BLANK;
		String result = sdf.format(startDate);

		if (Validator.isNull(endDate))
			return result;

		if (DateUtil.getDaysBetween(startDate, endDate) <= 1) {
			if (showTime) {
				result += " - ";
				result += new SimpleDateFormat("hh:mm aa").format(endDate);
			}
			return result;
		}
		result += (" - " + sdf.format(endDate));

		return result;
	}

	public static boolean LOGIN_CREATE_ACCOUNT_MIDDLE_NAME = GetterUtil
			.getBoolean(PropsUtil.get(SambaashConstants.CREATE_ACCOUNT_MIDDLE_NAME));

	public static boolean LOGIN_CREATE_ACCOUNT_LOCATION = GetterUtil
			.getBoolean(PropsUtil.get(SambaashConstants.CREATE_ACCOUNT_LOCATION));

	public static boolean LOGIN_CREATE_ACCOUNT_MOBILE_NUMBER = GetterUtil
			.getBoolean(PropsUtil.get(SambaashConstants.CREATE_ACCOUNT_MOBILE_NUMBER));

	public static boolean LOGIN_CREATE_ACCOUNT_TERMS_OF_USE = GetterUtil
			.getBoolean(PropsUtil.get(SambaashConstants.CREATE_ACCOUNT_TERMS_OF_USE));

	/**
	 * Will be used in jsp to restrict display string to specific size Example :
	 * resizeString("This is to test resize.", 10, "...") returns "This is..."
	 * 
	 * @param str
	 * @param newSize
	 * @param postfix
	 * @return
	 */
	public static String resizeString(String str, int newSize, String postfix) {
		String temp = GetterUtil.getString(str);
		postfix = GetterUtil.getString(postfix, "...");
		newSize = newSize - postfix.length();
		if (newSize > 0 && newSize < temp.length()) {
			temp = temp.substring(0, newSize);
			temp = temp + postfix;
		}
		return temp;
	}

	public static boolean isMultiTenantEnabled() {

		boolean isMultiTenantEnabled = Boolean.parseBoolean(
				getParameter(SambaashConstants.MULTI_TENANT, Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID)));
		if (_log.isDebugEnabled()) {
			_log.debug("isMultiTenantEnabled : " + isMultiTenantEnabled);
		}
		return isMultiTenantEnabled;
	}

	/**
	 * Will check if user has been assigned to the site or he is administrator
	 * otherwise user will be treated as unauthorized user.
	 * 
	 * @param themeDisplay
	 * @return
	 */
	public static boolean hasSiteAccess(ThemeDisplay themeDisplay, long userId) {
		try {
			User user = UserLocalServiceUtil.getUser(userId);

			if (_log.isDebugEnabled()) {
				_log.debug(" themeDisplay.getPermissionChecker().isOmniadmin() : "
						+ themeDisplay.getPermissionChecker().isOmniadmin() + " : isMultiTenantEnabled() : "
						+ isMultiTenantEnabled() + " : user.getGroupIds() : " + user.getGroupIds()
						+ " : themeDisplay.getScopeGroupId() : " + themeDisplay.getScopeGroupId());
			}

			if (themeDisplay.getPermissionChecker().isOmniadmin() || !isMultiTenantEnabled()
					|| ArrayUtil.contains(user.getGroupIds(), themeDisplay.getScopeGroupId())) {
				return true;
			}

		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		return false;
	}

	/**
	 * @param scopeGroupId
	 * @param userId
	 * @return String dashboard url with format (/{dashboard} or
	 *         /{web/community_name/dashboard})
	 */
	public static String getPostLoginRedirectUrl(ThemeDisplay themeDisplay, long userId) {

		String postLoginRedirectUrl = StringPool.BLANK;

		try {

			long scopeGroupId = themeDisplay.getScopeGroupId();
			User user = UserLocalServiceUtil.getUser(userId);

			try {
				List<Role> list = RoleLocalServiceUtil.getUserRoles(userId);
				RoleComparatorByOrder comparatorByOrder = new RoleComparatorByOrder(themeDisplay);
				Collections.sort(list, comparatorByOrder);

				for (Role role : list) {
					postLoginRedirectUrl = (String) SambaashUtil.getRoleExpandoValueByAttribute(themeDisplay, role,
							SambaashConstants.EXPANDO_ATTR_ROLE_REDIRECT_PAGE);
					if (Validator.isNotNull(postLoginRedirectUrl)) {
						// assuming always redirect to some page in same
						// community. So if the page name does not startwith
						// slash ,append it.
						if (!postLoginRedirectUrl.startsWith(StringPool.SLASH)) {
							postLoginRedirectUrl = StringPool.SLASH + postLoginRedirectUrl;
						}
						debugIfOn(" postLoginRedirectUrl by role redirect page: " + postLoginRedirectUrl);
						break;
					}
				}

			} catch (Exception e) {
				_log.error(e);
			}

			if (Validator.isNull(postLoginRedirectUrl)) {
				postLoginRedirectUrl = SambaashUtil.getParameter(SambaashConstants.POST_LOGIN_REDIRECT,
						themeDisplay.getScopeGroupId());
				debugIfOn(" postLoginRedirectUrl by SPParameter post.login.redirect: " + postLoginRedirectUrl);
			}

			if (Validator.isNull(postLoginRedirectUrl)) {
				if (isMarketer(user)) {
					debugIfOn("Marketer post login");
					postLoginRedirectUrl = getCommunityPath(scopeGroupId) + StringPool.FORWARD_SLASH
							+ SambaashUtil.getParameter(SambaashConstants.DASHBOARD.MARKETER_DASHBOARD, scopeGroupId);
				} else if (isScout(user)) {
					debugIfOn("Scout post login");
					postLoginRedirectUrl = getCommunityPath(scopeGroupId) + StringPool.FORWARD_SLASH
							+ SambaashUtil.getParameter(SambaashConstants.DASHBOARD.SCOUT_DASHBOARD, scopeGroupId);
				} else if (isFoundryAdmin(user)) {
					debugIfOn("Foundry Admin post login");
					postLoginRedirectUrl = getCommunityPath(scopeGroupId) + StringPool.FORWARD_SLASH + SambaashUtil
							.getParameter(SambaashConstants.DASHBOARD.FOUNDRY_ADMIN_DASHBOARD, scopeGroupId);

				} else if (isStartup(user)) {
					debugIfOn("Startup post login");
					long userOrgId = getUserOrgId(userId);
					if (userOrgId > 0) { // complete profile
						postLoginRedirectUrl = getCommunityPath(scopeGroupId) + StringPool.FORWARD_SLASH
								+ String.format("%s/-/manage-profile/view/%d",
										SambaashUtil.getParameter("startupDisplayPage", scopeGroupId), userOrgId);
					} else if (userOrgId < 0) { // incomplete profile
						postLoginRedirectUrl = getCommunityPath(scopeGroupId) + StringPool.FORWARD_SLASH
								+ String.format("%s/-/manage-profile/edit/%d",
										SambaashUtil.getParameter("startupCreatePage", scopeGroupId), userOrgId * -1);
					} else {
						postLoginRedirectUrl = getCommunityPath(scopeGroupId) + StringPool.FORWARD_SLASH + SambaashUtil
								.getParameter(SambaashConstants.DASHBOARD.STARTUP_DASHBOARD, scopeGroupId);
					}
				} else {
					debugIfOn("Default user post login");
					postLoginRedirectUrl = getCommunityPath(scopeGroupId) + StringPool.FORWARD_SLASH
							+ SambaashUtil.getParameter(SambaashConstants.URL.PROFILE_IND_LADNING, scopeGroupId);
				}
				debugIfOn(" postLoginRedirectUrl by profile type: " + postLoginRedirectUrl);
			}
		} catch (Exception e) {
			_log.error("Unable to get dashboard url.");
		}

		debugIfOn(" postLoginRedirectUrl : " + postLoginRedirectUrl);

		return postLoginRedirectUrl;
	}

	private static long getUserOrgId(long userId) {
		long orgId = 0;
		List<Organization> orgs = OrganizationLocalServiceUtil.getUserOrganizations(userId);
		if (Validator.isNotNull(orgs)) {
			for (Organization organization : orgs) {
				if (orgId == 0) { // get first org id returned
					orgId = organization.getOrganizationId() * (organization.getCompleteness() ? 1 : -1); // positive
																											// id
																											// means
																											// complete
				} else if (!organization.getCompleteness()) { // unless next org
																// is incomplete
					orgId = organization.getOrganizationId() * -1; // negative
																	// id means
																	// incomplete
				}
			}
		}
		return orgId;
	}

	public static void notifySystemAdmin(String subject, String msg) {
		try {
			String fromName = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_NAME);

			String fromAddress = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

			MailMessage mailMessage = new MailMessage();
			mailMessage.setToAddress("system-admin@sambaash.com");
			mailMessage.setSubject(subject);
			mailMessage.setBccAddress("alerts@sambaash.com");
			mailMessage.setHtmlFormat(true);
			mailMessage.setHtmlBody(msg);
			mailMessage.setFromAddress(fromAddress);
			mailMessage.setFromName(fromName);
			String messageId = SPMailLocalServiceUtil.sendMail(mailMessage);
			_log.error("messageId : " + messageId);
		} catch (Exception e) {
			_log.error("Failed to send error notification to system admin");
		}
	}

	public static boolean hasProductAccess(long scopeGroupId, long userId) {
		return checkRoleAccess(SambaashConstants.DEFAULT_PRODUCT_ROLEIDS, scopeGroupId, userId)
				|| isSupportRole(scopeGroupId, userId) || isAdmin(scopeGroupId, userId);
	}

	public static void clearAllCaches() {
		try {
			DirectServletRegistryUtil.clearServlets();
			CacheRegistryUtil.clear();
			MultiVMPoolUtil.clear();
			SingleVMPoolUtil.clear();
		} catch (Exception ex) {
			_log.error("Failed to clear caches", ex);
		}
	}

	public static String startupApplicationsFriendlyURL(ThemeDisplay themeDisplay) {
		return OrganizationLocalServiceUtil.applicationFriendlyURL(themeDisplay);
	}

	private static void debugIfOn(String debugMsg) {
		if (_log.isDebugEnabled()) {
			_log.debug(debugMsg);
		}
	}

	public static String formattedAmount(String amount) {
		return formattedAmount(amount, "###,###");
	}

	public static String formattedAmount(String amount, String format) {
		try {
			DecimalFormat df = new DecimalFormat(format);
			return df.format(Double.parseDouble(amount));
		} catch (Exception e) {
			return amount;
		}
	}

	public static boolean getUserRoleNames(long userId, long scopeGroupId, long profileUserId) {
		List<String> retList = new ArrayList<String>();
		boolean isEditProfile = false;
		if (Validator.isNotNull(userId) && userId != 0) {
			try {
				for (Role r : RoleLocalServiceUtil.getUserRoles(userId)) {
					retList.add(r.getName().toLowerCase());
				}
				if (SambaashUtil.isAdmin(scopeGroupId, userId) || retList.contains("editprofile")
						|| profileUserId == userId) {
					isEditProfile = true;
				}
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
		}
		return isEditProfile;
	}

	public static String getClassSimpleName(String className) {
		String simpleName = "";
		try {
			String[] toks = className.split(Pattern.quote("."));
			simpleName = toks[toks.length - 1];
		} catch (Exception e) {
			_log.error("Error extracting simple classname of " + className);
		}
		return simpleName;
	}

	public static boolean isShowSignIn(ThemeDisplay themeDisplay) {
		boolean isShowSignIn = true;
		try {
			String urlValues = getParameter("list.eb.pages", themeDisplay.getScopeGroupId());
			debugIfOn("urlValues " + urlValues);
			if (!urlValues.isEmpty()) {
				String[] urlValueArray = urlValues.split(",");
				String currentUrl = PortalUtil.getCurrentURL(themeDisplay.getRequest());
				debugIfOn("currentUrl PortalUtil " + currentUrl);
				for (String urlValue : urlValueArray) {
					if (currentUrl.contains("/" + urlValue + "/") || currentUrl.contains("/" + urlValue)) {
						isShowSignIn = false;
						break;
					}
				}
			}

		} catch (Exception e) {
			_log.error("Error extracting simple classname of ");
		}
		return isShowSignIn;
	}

	public static void sendWelcomeEmail(HttpServletRequest request, User user) throws SystemException {

		try {

			if (Validator.isNotNull(user) && Validator.isNull(user.getLastLoginDate())) {

				ServiceContext serviceContext = ServiceContextFactory.getInstance(request);

				if (!PrefsPropsUtil.getBoolean(user.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_ENABLED)) {

					return;
				}

				String fromName = PrefsPropsUtil.getString(user.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
				String fromAddress = PrefsPropsUtil.getString(user.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

				String toName = user.getFullName();
				String toAddress = user.getEmailAddress();

				String subject = PrefsPropsUtil.getContent(user.getCompanyId(),
						PropsKeys.ADMIN_EMAIL_USER_ADDED_SUBJECT);

				String body = PrefsPropsUtil.getContent(user.getCompanyId(),
						PropsKeys.ADMIN_EMAIL_USER_ADDED_NO_PASSWORD_BODY);

				SubscriptionSender subscriptionSender = new SubscriptionSender();

				subscriptionSender.setBody(body);
				subscriptionSender.setCompanyId(user.getCompanyId());
				subscriptionSender.setContextAttributes("[$USER_ID$]", user.getUserId(), "[$USER_PASSWORD$]",
						StringPool.BLANK, "[$USER_SCREENNAME$]", user.getScreenName());
				subscriptionSender.setFrom(fromAddress, fromName);
				subscriptionSender.setHtmlFormat(true);
				subscriptionSender.setMailId("user", user.getUserId(), System.currentTimeMillis(), StringPool.BLANK);
				subscriptionSender.setServiceContext(serviceContext);
				subscriptionSender.setSubject(subject);
				subscriptionSender.setUserId(user.getUserId());

				subscriptionSender.addRuntimeSubscribers(toAddress, toName);

				subscriptionSender.flushNotificationsAsync();

				user.setLastLoginDate(DateUtil.newDate());
				UserLocalServiceUtil.updateUser(user);

			}
		} catch (PortalException e) {
			debugIfOn("Failed to send welcome email, " + e);
		}
	}

	public static JSONObject getUserInfo(ThemeDisplay themeDisplay) {
		JSONObject userInfo = JSONFactoryUtil.createJSONObject();
		User u = themeDisplay.getUser();
		userInfo.put("userId", u.getUserId());
		userInfo.put("fullName", u.getFullName());
		userInfo.put("firstName", u.getFirstName());
		userInfo.put("lastName", u.getLastName());
		userInfo.put("companyId", CompanyThreadLocal.getCompanyId());
		userInfo.put("userEmail", u.getEmailAddress());

		try {
			userInfo.put("groupId", themeDisplay.getScopeGroupId());
			userInfo.put("groupIdms", getScopeGroupId(themeDisplay.getScopeGroupId())); // for EMS scope group id
			List<Role> userRoles = RoleLocalServiceUtil.getUserRoles(u.getUserId());
			JSONArray roles = JSONFactoryUtil.createJSONArray();
			userInfo.put("roles", roles);
			for (Role ur : userRoles) {
				roles.put(ur.getRoleId());
			}
		} catch (Exception e) {
			debugIfOn("Failed to get user info : " + e);
		}
		return userInfo;
	}

	public static String getFormV2BaseUrl() {
		String baseurl = SambaashUtil.getParameter(SambaashConstants.API_FORMV2_BASEURL, 0);
		if (Validator.isNull(baseurl)) {
			baseurl = "https://forms.sambaash.com/v2/forms";
		}
		return baseurl;
	}

	public static String getVocabularyUrl(String vocabulary) {

		String vocabularyurl = SambaashUtil.getParameter(SambaashConstants.API_VOCABULARY_URL, 0);
		if (Validator.isNull(vocabularyurl)) {
			vocabularyurl = "https://ems.sambaash.com/api/jsonws/SystemModelSetup-portlet.system/get-category/vocabulary-name/Facility%20External%20Category/group-id/21424";
		}
		vocabularyurl = vocabularyurl.replace("$VCNAME", vocabulary);
		return vocabularyurl;
	}

	public static String getDashBoard() {
		return SambaashUtil.getParameter(SambaashConstants.DASHBOARD_URL, SambaashConstants.DEFAULT_GROUP_ID_LONG);
	}

	public static String getNavigationLayouts() {
		return SambaashUtil.getParameter(SambaashConstants.DASHBOARD_URL, SambaashConstants.DEFAULT_GROUP_ID_LONG);
	}

	public static Candidate getCandidate(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String userId = String.valueOf(themeDisplay.getUserId());
		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		String storageId = httpReq.getParameter("storageId");
		if (storageId != null && !storageId.equalsIgnoreCase("")) {
			userId = storageId;
		}
		String response = FetchLocalServiceUtil.fetchRecord(userId, "Candidate", Long.valueOf(userId),
				getScopeGroupId(themeDisplay.getScopeGroupId()));
		Candidate candidate = new Candidate(response);
		return candidate;
	}

	public static Invigilator getInvigilator(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String userId = String.valueOf(themeDisplay.getUserId());
		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		String storageId = httpReq.getParameter("storageId");
		if (storageId != null && !storageId.equalsIgnoreCase("")) {
			userId = storageId;
		}
		String response = FetchLocalServiceUtil.fetchRecord(userId, "Invigilator", Long.valueOf(userId),
				getScopeGroupId(themeDisplay.getScopeGroupId()));
		Invigilator invigilator = new Invigilator(response);
		return invigilator;
	}

	public static Persona getPersona(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String loggedinUserId = String.valueOf(themeDisplay.getUserId());
		long userId = Long.valueOf(renderRequest.getParameter("userId"));
		if (userId <= 0 ) {
			userId = Long.valueOf(loggedinUserId);
		}
		String response = FetchLocalServiceUtil.fetchRecord(String.valueOf(userId), "persona/profile", userId,
				getScopeGroupId(themeDisplay.getScopeGroupId()));
		
		Persona candidate = new Persona(response, userId);
		return candidate;
	}

	public static String getSPLoginType(long companyId) {
		try {
			String loginType = PrefsPropsUtil.getString(companyId, SambaashConstants.SP_LOGIN_TYPE,
					SambaashConstants.SP_DEFAULT_LIFERAY_LOGIN);
			_log.debug("Got SP Login Type : " + loginType);
			return loginType;
		} catch (Exception e) {
			_log.error("Unable to retrieve SP Login Type!", e);
			return SambaashConstants.SP_DEFAULT_LIFERAY_LOGIN;
		}
	}

	public static boolean isStripeWebhookOn() {
		try {
			String isOnParam = SambaashUtil.getParameter("integration.stripe.webhook.on", 0);
			return "".equals(isOnParam) ? false : Boolean.parseBoolean(isOnParam);
		} catch (Exception e) {
			_log.error(e);
			return false;
		}
	}

	public static String retrieveMicroserviceDataDomain(long scopeGroupId) {
		try {
			String dataDomain = SambaashUtil.getParameter("sp.microservice.data.domain", scopeGroupId);
			return "".equals(dataDomain) ? "dev" : dataDomain;
		} catch (Exception e) {
			_log.error(e);
			return "dev";
		}
	}

	public static long getScopeGroupId(Long siteId) {
		try {
			String scopeGroupId = SambaashUtil.getParameter(SambaashConstants.SCOPE_GROUP_ID, siteId);
			if (Validator.isNumber(scopeGroupId)) {
				return Long.parseLong(scopeGroupId);
			}
		} catch (Exception e) {
			// return passed siteId
		}

		return siteId;

	}

	public static long getVirtualHostId(HttpServletRequest request) {
		return getVirtualHostId(getLayoutSet(request));
	}

	public static LayoutSet getLayoutSet(HttpServletRequest request) {
		return (LayoutSet) request.getAttribute("VIRTUAL_HOST_LAYOUT_SET");
	}

	public static String getBackOfficeURL(long productTypeId, long subProductTypeId, String portalURL) {
		return getSPSiteURL(productTypeId, subProductTypeId, portalURL, true);
	}
	
	public static String getSPSiteURL(long productTypeId, long subProductTypeId, String portalURL, boolean backOffice) {
		try {

			SPSiteSetup spSiteSetup = SPSiteSetupLocalServiceUtil.findByProductIdAndSubProductId(productTypeId,
					subProductTypeId);
			VirtualHost virtualHost = VirtualHostLocalServiceUtil
					.getVirtualHost(backOffice ? spSiteSetup.getBackOfficeVirtualHostId() : spSiteSetup.getVirtualHostId());

			StringBuilder url = new StringBuilder();
			String port = getParameter(SambaashConstants.PORT, SambaashConstants.DEFAULT_GROUP_ID_LONG);

			if (portalURL.startsWith(Http.HTTPS_WITH_SLASH)) {
				url.append(SambaashConstants.PROTOCOL_SECURE).append(virtualHost.getHostname());
			} else {
				url.append(SambaashConstants.PROTOCOL).append(virtualHost.getHostname());
			}

			if (Validator.isNotNull(port)) {
				url.append(StringPool.COLON).append(port);
			}

			if (_log.isDebugEnabled()) {
				_log.debug(String.format("getBackOfficeURL : %s", url.toString()));
			}
			return url.toString();
		} catch (Exception e) {
			_log.debug(String.format("Unable to get URL from SPSiteSetup : %s , Will return default url : %s",
					e.getMessage(), portalURL));
			return portalURL;
		}
	}

	public static long getVirtualHostId(LayoutSet layoutSet) {
		long virtualHostId = 0;
		try {
			String virtualHost = (layoutSet == null) ? null : layoutSet.getVirtualHostname();
			if (layoutSet != null && ("".equals(virtualHost) || Validator.isNull(virtualHost))) {
				virtualHost = layoutSet.getCompanyFallbackVirtualHostname();
			}
			_log.debug("Got VirtualHost -> " + virtualHost);
			virtualHostId = VirtualHostLocalServiceUtil.getVirtualHost(virtualHost).getVirtualHostId();
		} catch (Exception e) {
			_log.error("Failed to get virtualhost id!", e);
		}
		return virtualHostId;
	}

	public static String getPageSubProductSettings(HttpServletRequest request) {
		try {
			return SPAuthenticationUtil.getPageSubProductSettings(request);
		} catch (Exception e) {
			return "-1";
		}
	}
	
	public static long getProductId(HttpServletRequest request) {
		return SPAuthenticationUtil.getPageProductSetting(request);
	}
	
	
	public static long getSubProductId(HttpServletRequest request) {
		return Long.parseLong(getPageSubProductSettings(request));
	}

	public static Date getFirstDayOfQuarter(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) / 3 * 3);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}

	public static Date getLastDayOfQuarter(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) / 3 * 3 + 2);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}

	public static String getStartupSignupUrl(ThemeDisplay themeDisplay) {
		String url = getParameter("startupSignupPage", themeDisplay.getScopeGroupId());
		if (Validator.isNull(url)) {
			// default to create page
			url = getParameter("startupCreatePage", themeDisplay.getScopeGroupId());
		}
		return url;
	}
	
	public static String ordinal(int i) {
	    String[] sufixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
	    switch (i % 100) {
	    case 11:
	    case 12:
	    case 13:
	        return i + "th";
	    default:
	        return i + sufixes[i % 10];

	    }
	}
	
	public static <T> Iterable<T> emptyIfNull(Iterable<T> iterable) {
	    return iterable == null ? Collections.<T>emptyList() : iterable;
	}

}
