package com.sambaash.platform.security.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Account;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.User;
import com.liferay.portal.model.VirtualHost;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.VirtualHostLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.srv.spservices.model.SPSiteSetup;
import com.sambaash.platform.srv.spservices.service.SPSiteLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPSiteSetupLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class SPAuthenticationUtil {
	private static final String STRING_ARRAY_SEPARATOR = ",";
	private static final Log LOG = LogFactoryUtil.getLog(SPAuthenticationUtil.class);
	protected static final String ORGANIZATION_NAME_SUFFIX = " LFR_ORGANIZATION";
	protected static String[] ADMIN_DEFAULT_GROUP_NAMES = StringUtil.splitLines(PropsUtil.get(PropsKeys.ADMIN_DEFAULT_GROUP_NAMES));
	protected static String[] ADMIN_DEFAULT_ORGANIZATION_GROUP_NAMES = StringUtil.splitLines(PropsUtil.get(PropsKeys.ADMIN_DEFAULT_ORGANIZATION_GROUP_NAMES));

	private SPAuthenticationUtil() {
		// only static methods
	}

	public static String getPageSubProductSettings(PortletRequest portletRequest) {
		return getPageSubProductSettings(PortalUtil.getHttpServletRequest(portletRequest));
	}

	public static String getPageSubProductSettings(HttpServletRequest request) {
		return getPageSubProductSettings((ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY));
	}

	public static String getPageSubProductSettings(ThemeDisplay themeDisplay) {
		Layout curPage = themeDisplay.getLayout();
		UnicodeProperties layoutTypeSettings = curPage.getTypeSettingsProperties();
		return GetterUtil.getString(layoutTypeSettings.getProperty("subProduct"));
	}

	public static String getPageSingleSubProductSetting(PortletRequest portletRequest) throws SystemException {
		return getPageSingleSubProductSetting(PortalUtil.getHttpServletRequest(portletRequest));
	}

	public static String getPageSingleSubProductSetting(HttpServletRequest request) throws SystemException {
		return getPageSingleSubProductSetting((ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY));
	}

	public static String getPageSingleSubProductSetting(ThemeDisplay themeDisplay) throws SystemException {
		String setting = getPageSubProductSettings(themeDisplay);
		return setting != null && setting.contains(STRING_ARRAY_SEPARATOR) ? setting.split(STRING_ARRAY_SEPARATOR)[0]
				: setting;
	}

	public static long getPageProductSetting(PortletRequest portletRequest) {
		return getPageProductSetting(PortalUtil.getHttpServletRequest(portletRequest));
	}

	public static long getPageProductSetting(HttpServletRequest request) {
		return getPageProductSetting((ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY));
	}

	public static long getPageProductSetting(ThemeDisplay themeDisplay) {
		try {
			return getSiteSetup(getPageSingleSubProductSetting(themeDisplay)).get(0).getProductId();
		} catch (Exception e) {
			LOG.error("Error getting page's product setting. " + e.toString());
			return -1;
		}
	}

	public static List<SPSiteSetup> getSiteSetup(String subProductSetting) throws SystemException {
		List<SPSiteSetup> configList = new ArrayList<>();
		if (Validator.isNotNull(subProductSetting)) {
			for (String subProductId : subProductSetting.split(STRING_ARRAY_SEPARATOR)) {
				configList.add(SPSiteSetupLocalServiceUtil.findBySubProductId(Long.parseLong(subProductId)).get(0));
			}
		}
		return configList;
	}

	public static boolean spAccountCreateValidation(User existingLiferayUser, ActionRequest actionRequest,
			long companyId) {
		long virtualHostId = 0;
		boolean valid = false;
		try {
			String spLoginType = SambaashUtil.getSPLoginType(companyId);
			switch (spLoginType) {
			case SambaashConstants.SP_USER_BY_DOMAIN_LOGIN:
				LayoutSet layoutSet = (LayoutSet) PortalUtil.getHttpServletRequest(actionRequest)
						.getAttribute("VIRTUAL_HOST_LAYOUT_SET");
				String virtualHost = (layoutSet == null) ? null : layoutSet.getVirtualHostname();
				LOG.debug("Got VirtualHost in spAccountCreationValidation -> " + virtualHost);
				virtualHostId = VirtualHostLocalServiceUtil.getVirtualHost(virtualHost).getVirtualHostId();
				LOG.debug("Got VirtualHost ID -> " + virtualHostId);
				valid = (existingLiferayUser == null) || !SPSiteLocalServiceUtil
						.hasExistingDomainEntry(existingLiferayUser.getUserId(), virtualHostId);
				break;

			case SambaashConstants.SP_USER_BY_SPSITE_LOGIN:
				HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
				String subProductIds = SambaashUtil.getPageSubProductSettings(request);
				boolean hasExisting = true;
				if (existingLiferayUser != null) {
					for (String subProductId : subProductIds.split(",")) {
						SPSiteSetup siteSetup = SPSiteSetupLocalServiceUtil
								.findBySubProductId(Long.parseLong(subProductId)).get(0);
						hasExisting = !SPSiteLocalServiceUtil.findByUserIdAndAuthAccessId(
								existingLiferayUser.getUserId(), siteSetup.getSpSiteSetupId()).isEmpty();
						if (!hasExisting) {
							// at least one sub product access is not existing,
							// stop checking the rest
							break;
						}
					}
				}
				valid = (existingLiferayUser == null) || !hasExisting;
				break;

			case SambaashConstants.SP_DEFAULT_LIFERAY_LOGIN:
				valid = (existingLiferayUser == null);
				break;

			default:
				valid = true;
			}
		} catch (Exception e) {
			LOG.error("Unable to get virtualhost!", e);
		}
		return valid;
	}

	// We will not add auto membership to current site anymore.
	// Just comment actions so callers will not be affected.
	// addOrUpdateSPSiteUser() will take care of site membership
	public static void addSiteMembership(PortletRequest request, User user) {
		addSiteMembership((ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY), user);
	}

	public static void addSiteMembership(ThemeDisplay themeDisplay, User user) {
		try {
			GroupLocalServiceUtil.addUserGroups(user.getUserId(), new long[] { themeDisplay.getScopeGroupId() });
		} catch (Exception e) {
			LOG.error("Error adding site membership.", e);
		}
	}

	public static void addSiteMembership(long userId, long virtualHostId) {
		try {
			VirtualHost virtualHost = VirtualHostLocalServiceUtil.fetchVirtualHost(virtualHostId);
			LayoutSet layoutSet = LayoutSetLocalServiceUtil.fetchLayoutSet(virtualHost.getLayoutSetId());
			GroupLocalServiceUtil.addUserGroups(userId, new long[] { layoutSet.getGroupId() });
		} catch (Exception e) {
			LOG.error("Error adding site membership.", e);
		}
	}

	public static void addSiteMembership(long userId, String subProductIds) {
		addSiteMembership(userId, subProductIds, false);
	}

	public static void addSiteMembership(long userId, String subProductIds, boolean isOfficer) {
		try {
			long[] designatedSiteMemberships = getSiteGroupIds(subProductIds, isOfficer);
			if (designatedSiteMemberships.length > 0) {
				GroupLocalServiceUtil.deleteUserGroups(userId, GroupLocalServiceUtil.getUserGroups(userId));
				GroupLocalServiceUtil.addUserGroups(userId, designatedSiteMemberships);
			}
		} catch (Exception e) {
			LOG.error("Error adding site membership.", e);
		}
	}

	public static void addOrUpdateSPSiteUser(PortletRequest actionRequest, long userId, String encryptedPassword) {
		// CreateAccountAction or login screen may be set for multiple sub
		// product
		// which will be taken from the request's Layout settings
		addOrUpdateSPSiteUser(null, actionRequest, userId, encryptedPassword);
	}

	public static void addOrUpdateSPSiteUser(String subProductId, PortletRequest actionRequest, long userId,
			String encryptedPassword) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			// in process engine, this will be set to null to user the password
			// generated for the newly created liferay user instead
			String password1 = ParamUtil.getString(actionRequest, "password1");
			HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
			LayoutSet layoutSet = SambaashUtil.getLayoutSet(request);
			long virtualHostId = SambaashUtil.getVirtualHostId(layoutSet);
			// specific subProductId can be pass like in Process Engine
			// which is always single value only
			String subProductIds = Validator.isNotNull(subProductId) ? subProductId
					: getPageSubProductSettings(request);
			for (SPSiteSetup siteSetup : getSiteSetup(subProductIds)) {
				SPSiteLocalServiceUtil.addOrUpdateSPSiteUser(themeDisplay.getCompanyId(),
						themeDisplay.getScopeGroupId(), siteSetup.getSpSiteSetupId(), userId,
						layoutSet == null ? 0 : layoutSet.getLayoutSetId(), virtualHostId,
						SambaashUtil.getSPLoginType(themeDisplay.getCompanyId()), password1, encryptedPassword);
			}
			addSiteMembership(userId, subProductIds);
		} catch (Exception e) {
			LOG.error("[1] Unable to create SPSite entry!", e);
		}
	}

	public static void addOrUpdateSPSiteUser(long virtualHostId, String subProductId, User user, String plainPassword) {
		try {
			VirtualHost virtualHost = VirtualHostLocalServiceUtil.fetchVirtualHost(virtualHostId);
			LayoutSet layoutSet = LayoutSetLocalServiceUtil.fetchLayoutSet(virtualHost.getLayoutSetId());
			for (SPSiteSetup siteSetup : getSiteSetup(subProductId)) {
				SPSiteLocalServiceUtil.addOrUpdateSPSiteUser(layoutSet.getCompanyId(), layoutSet.getGroupId(),
						siteSetup.getSpSiteSetupId(), user.getUserId(), layoutSet.getLayoutSetId(), virtualHostId,
						SambaashUtil.getSPLoginType(layoutSet.getCompanyId()),
						Validator.isNotNull(plainPassword) ? plainPassword : user.getPassword(), user.getPassword());
			}
			addSiteMembership(user.getUserId(), subProductId);
		} catch (Exception e) {
			LOG.error("[2] Unable to create SPSite entry!", e);
		}
	}

	public static long getSiteGroupId(long virtualHostId) throws SystemException {
		VirtualHost virtualHost = VirtualHostLocalServiceUtil.fetchVirtualHost(virtualHostId);
		LayoutSet layoutSet = LayoutSetLocalServiceUtil.fetchLayoutSet(virtualHost.getLayoutSetId());
		return layoutSet.getGroupId();
	}

	public static long getSiteGroupId(PortletRequest request) {
		return getSiteGroupId((ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY));
	}

	public static long getSiteGroupId(ThemeDisplay themeDisplay) {
		return themeDisplay.getScopeGroupId();
	}

	// subProductIds = comma-delimited list
	public static long[] getSiteGroupIds(String subProductIds, boolean isOfficer) throws SystemException, PortalException {
		Set<Long> siteMemberShips = new HashSet<>();
		for (SPSiteSetup siteSetup : getSiteSetup(subProductIds)) {
			LayoutSet foLayoutSet = getSPSiteSetupLayoutSet(siteSetup, false);
			if (foLayoutSet != null) {
				siteMemberShips.add(foLayoutSet.getGroupId());
			} else {
				siteMemberShips.addAll(Arrays.asList(getDefaultGroups(siteSetup)));
			}
			if (isOfficer) {
				LayoutSet boLayoutSet = getSPSiteSetupLayoutSet(siteSetup, true);
				siteMemberShips.add(boLayoutSet.getGroupId());
			}
		}
		long[] sites = new long[siteMemberShips.size()];
		int i = 0;
		for (Long siteGroupId : siteMemberShips) {
			sites[i++] = siteGroupId;
		}
		return sites;
	}

	public static LayoutSet getSPSiteSetupLayoutSet(SPSiteSetup siteSetup, boolean backEnd) throws SystemException {
		VirtualHost virtualHost = VirtualHostLocalServiceUtil
				.fetchVirtualHost(backEnd ? siteSetup.getBackOfficeVirtualHostId() : siteSetup.getVirtualHostId());
		return LayoutSetLocalServiceUtil.fetchLayoutSet(virtualHost.getLayoutSetId());
	}

	public static Long[] getDefaultGroups(SPSiteSetup siteSetup) throws PortalException, SystemException {

		Set<Long> groupIdsSet = new HashSet<Long>();

		String[] defaultGroupNames = PrefsPropsUtil.getStringArray(siteSetup.getCompanyId(),
				PropsKeys.ADMIN_DEFAULT_GROUP_NAMES, StringPool.NEW_LINE, ADMIN_DEFAULT_GROUP_NAMES);

		for (String defaultGroupName : defaultGroupNames) {
			Company company = CompanyLocalServiceUtil.fetchCompany(siteSetup.getCompanyId());

			Account account = company.getAccount();

			if (StringUtil.equalsIgnoreCase(defaultGroupName, account.getName())) {

				defaultGroupName = GroupConstants.GUEST;
			}

			Group group = GroupLocalServiceUtil.fetchGroup(siteSetup.getCompanyId(), defaultGroupName);
			groupIdsSet.add(group.getGroupId());
		}

		String[] defaultOrganizationGroupNames = PrefsPropsUtil.getStringArray(siteSetup.getCompanyId(),
				PropsKeys.ADMIN_DEFAULT_ORGANIZATION_GROUP_NAMES, StringPool.NEW_LINE,
				ADMIN_DEFAULT_ORGANIZATION_GROUP_NAMES);

		for (String defaultOrganizationGroupName : defaultOrganizationGroupNames) {
			defaultOrganizationGroupName += ORGANIZATION_NAME_SUFFIX;
			Group group = GroupLocalServiceUtil.fetchGroup(siteSetup.getCompanyId(), defaultOrganizationGroupName);
			groupIdsSet.add(group.getGroupId());
		}

		return groupIdsSet.toArray(new Long[0]);

	}

	public static final String getEnrolmentDefaultTempPassword(ThemeDisplay themeDisplay) {
		String defaultTempPw = SambaashUtil.getParameter("enrolment.default.temporary.password", themeDisplay.getScopeGroupId());
		if (defaultTempPw==null || "".equals(defaultTempPw.trim())) {
			defaultTempPw = "jkA04hcL9^";
		}
		return defaultTempPw;
	}
}
