package com.sambaash.platform.pe.helpers;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PERequestData;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.util.SambaashUtil;

public class PEUrlHelper {

	public String addToSendRedirect(String url) {
		// ThemeDisplay themeDisplay = ds.getThemeDisplay();
		// SambaashUtil.getSignInURL returning signing url which is not as per
		// standard, Hence changing it to read from spparameteres
		// String signin =
		// SambaashUtil.getSignInURL(themeDisplay.getScopeGroupId(),
		// themeDisplay, true);
		// String signin =
		// SambaashUtil.getSignInUrlFromSPParamDefaultGrp(themeDisplay);
		return addToSendRedirect(requestData.getSignInUrl(), url);
	}

	public static String addToSendRedirect(String signInUrl, String actualUrl) {
		// ThemeDisplay themeDisplay = ds.getThemeDisplay();
		// SambaashUtil.getSignInURL returning signing url which is not as per
		// standard, Hence changing it to read from spparameteres
		// String signin =
		// SambaashUtil.getSignInURL(themeDisplay.getScopeGroupId(),
		// themeDisplay, true);
		// String signin =
		// SambaashUtil.getSignInUrlFromSPParamDefaultGrp(themeDisplay);
		// return HttpUtil.addParameter(signInUrl, "redirect", actualUrl);
		return actualUrl;
	}

	public String getListingPageUrl() {

		/*
		 * if (requestData.getCurPlid() > 0) { return getCurrentPageName(); }
		 */
		String pageName = StringPool.BLANK;
		PEProcess process = ds.getProcess();
		try {
			if (ds.isSupervisorLoggedInUser()) {
				pageName = process.getSupervisorPageName();
			} else if (ds.isAgentLoggedInUser()) {
				pageName = process.getAgentPageName();
			} else if (ds.isApplicantLoggedInUser()) {
				pageName = process.getUserPageName();
			} else {
				pageName = process.getApproverPageName();
			}

		} catch (Exception e) {
			_log.error(e);
		}
		return pageName;

	}

	public String getFormattedListingPageURL() {

		String url = StringPool.BLANK;

		try {
			if (ds.isApplicantLoggedInUser()) {

				if (requestData.isPrivateLayout()) {
					url = url + "/group/" + requestData.getGroupName();
				} else {
					url = url + "/web/" + requestData.getGroupName();
				}
			} else {

				url = SambaashUtil.getBackOfficeURL(ds.getProcess().getProductTypeId(),
						ds.getProcess().getSubProductTypeId(), requestData.getPortalUrl());

			}
		} catch (Exception e) {
			_log.error(e);
		}

		if (_log.isDebugEnabled()) {
			_log.debug("getFormattedListingPageURL : " + url + getListingPageUrl());
		}

		return url + getListingPageUrl();

	}

	public String getApplicationDisplayUrl() {
		return getApplicationDisplayUrl(0);
	}

	public String getApplicationDisplayUrl(long statusTypeId) {
		String url = StringPool.BLANK;
		try {

			if (_log.isDebugEnabled()) {
				_log.debug(" ds.isSupervisorLoggedInUser() : " + ds.isSupervisorLoggedInUser()
						+ " : ds.isAgentLoggedInUser() : " + ds.isAgentLoggedInUser()
						+ " : ds.isApplicantLoggedInUser() : " + ds.isApplicantLoggedInUser());
			}

			if (ds.isSupervisorLoggedInUser()) {
				url = getUrlDisplayProcessStateSupervisor(statusTypeId);
			} else if (ds.isAgentLoggedInUser()) {
				url = getUrlDisplayProcessStateAgent(statusTypeId);
			} else if (ds.isApplicantLoggedInUser()) {
				url = getUrlDisplayProcessStateUser(statusTypeId);
			} else {
				url = getUrlDisplayProcessStateOfficer(statusTypeId);
			}
		} catch (SystemException e) {
			_log.error(e);
		}

		return url;
	}

	public String getApplicationDisplayFriendlyUrl() {
		return getApplicationDisplayFriendlyUrl(0);
	}

	public String getApplicationDisplayFriendlyUrl(long statusTypeId) {
		String url = StringPool.BLANK;
		try {
			if (requestData.getCurPlid() > 0) {
				url = getFriendlyUrlProcessStateDisplay(getCurrentPageName(), statusTypeId);
			} else if (ds.isSupervisorLoggedInUser()) {
				url = getFriendlyUrlDisplayProcessStateSupervisor(statusTypeId);
			} else if (ds.isAgentLoggedInUser()) {
				url = getFriendlyUrlDisplayProcessStateAgent(statusTypeId);
			} else if (ds.isApplicantLoggedInUser()) {
				url = getFriendlyUrlDisplayProcessStateUser(statusTypeId);
			} else {
				url = getFriendlyUrlDisplayProcessStateOfficer(statusTypeId);
			}
		} catch (SystemException e) {
			_log.error(e);
		}

		return url;
	}

	public String getUrlDisplayProcessStateOfficer() {
		return getUrlDisplayProcessStateOfficer(0);
	}

	public String getUrlDisplayProcessStateUser() {
		return getUrlDisplayProcessStateUser(0);
	}

	public String getUrlDisplayProcessStateAgent() {
		return getUrlDisplayProcessStateAgent(0);
	}

	public String getUrlDisplayProcessStateSupervisor() {
		return getUrlDisplayProcessStateSupervisor(0);
	}

	public String getUrlDisplayProcessStateOfficer(long statusTypeId) {
		String pageName = StringPool.BLANK;
		PEProcess process = ds.getProcess();
		pageName = process.getApproverPageName();
		String url = getUrlProcessStateDisplay(pageName, statusTypeId, false);

		return url;
	}

	public String getUrlDisplayProcessStateUser(long statusTypeId) {
		String pageName = StringPool.BLANK;
		PEProcess process = ds.getProcess();
		pageName = process.getUserPageName();
		String url = getUrlProcessStateDisplay(pageName, statusTypeId, true);

		return url;
	}

	public String getUrlDisplayProcessStateAgent(long statusTypeId) {
		String pageName = StringPool.BLANK;
		PEProcess process = ds.getProcess();
		pageName = process.getAgentPageName();
		String url = getUrlProcessStateDisplay(pageName, statusTypeId, false);

		return url;
	}

	public String getUrlDisplayProcessStateSupervisor(long statusTypeId) {
		String pageName = StringPool.BLANK;
		PEProcess process = ds.getProcess();
		pageName = process.getSupervisorPageName();
		String url = getUrlProcessStateDisplay(pageName, statusTypeId, false);

		return url;
	}

	public String getFriendlyUrlDisplayProcessStateOfficer() {
		return getFriendlyUrlDisplayProcessStateOfficer(0);
	}

	public String getFriendlyUrlDisplayProcessStateUser() {
		return getFriendlyUrlDisplayProcessStateUser(0);
	}

	public String getFriendlyUrlDisplayProcessStateAgent() {
		return getFriendlyUrlDisplayProcessStateAgent(0);
	}

	public String getFriendlyUrlDisplayProcessStateSupervisor() {
		return getFriendlyUrlDisplayProcessStateSupervisor(0);
	}

	public String getFriendlyUrlDisplayProcessStateOfficer(long statusTypeId) {
		String pageName = StringPool.BLANK;
		PEProcess process = ds.getProcess();
		pageName = process.getApproverPageName();
		String url = getFriendlyUrlProcessStateDisplay(pageName, statusTypeId);

		return url;
	}

	public String getFriendlyUrlDisplayProcessStateUser(long statusTypeId) {
		String pageName = StringPool.BLANK;
		PEProcess process = ds.getProcess();
		pageName = process.getUserPageName();
		String url = getFriendlyUrlProcessStateDisplay(pageName, statusTypeId);

		return url;
	}

	public String getFriendlyUrlDisplayProcessStateAgent(long statusTypeId) {
		String pageName = StringPool.BLANK;
		PEProcess process = ds.getProcess();
		pageName = process.getAgentPageName();
		String url = getFriendlyUrlProcessStateDisplay(pageName, statusTypeId);

		return url;
	}

	public String getFriendlyUrlDisplayProcessStateSupervisor(long statusTypeId) {
		String pageName = StringPool.BLANK;
		PEProcess process = ds.getProcess();
		pageName = process.getSupervisorPageName();
		String url = getFriendlyUrlProcessStateDisplay(pageName, statusTypeId);

		return url;
	}

	public String getCurrentPageName() {
		String pageName = StringPool.BLANK;
		try {
			pageName = LayoutLocalServiceUtil.getLayout(requestData.getCurPlid()).getFriendlyURL();
		} catch (PortalException | SystemException e) {
			_log.error(e);
		}

		return pageName;
	}

	public String getUrlProcessStateDisplay(String pageName, long statusTypeId, boolean isUser) {
		String url = StringPool.BLANK;

		String format = "%s%s/-/process/view/%s/%s";
		pageName = prefixSlash(pageName);

		String portalUrl = requestData.getPortalUrl();
		String siteName = requestData.getGroupName();

		if (!isUser) {

			try {
				portalUrl = SambaashUtil.getBackOfficeURL(ds.getProcess().getProductTypeId(),
						ds.getProcess().getSubProductTypeId(), requestData.getPortalUrl());
				if (_log.isDebugEnabled()) {
					_log.debug("Back office URL : " + portalUrl);
				}
			} catch (Exception e) {

			}
		} else {
			if (requestData.isPrivateLayout()) {

				try {
					// SPParameter parameter =
					// SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(
					// requestData.getScopeGroupId(),
					// SambaashConstants.APPLICANT_URL);
					//
					// portalUrl = parameter.getValue() + "/group/" +
					// parameter.getDescription();
					portalUrl = SambaashUtil.getSPSiteURL(ds.getProcess().getProductTypeId(),
							ds.getProcess().getSubProductTypeId(), requestData.getPortalUrl(), false);

					if (_log.isDebugEnabled()) {
						_log.debug("Front Office URL : " + portalUrl);
					}
				} catch (Exception e) {

				}

			} else {
				portalUrl = portalUrl + "/web/" + siteName;
			}
		}

		if (pageName.startsWith("http")) {
			// exception case when page setting points to specific web page
			// such as when a process when officer is expected to login to front
			// office
			url = String.format("%s/-/process/view/%s/%s", pageName,
					String.valueOf(ds.getProcessState().getSpPEProcessStateId()), String.valueOf(statusTypeId));
		} else {
			url = String.format(format, portalUrl, pageName,
					String.valueOf(ds.getProcessState().getSpPEProcessStateId()), String.valueOf(statusTypeId));
		}

		if (_log.isDebugEnabled()) {
			_log.debug("getUrlProcessStateDisplay : " + url);
		}

		// return the url
		if (ds.isSignedInUser()) {
			return url;
		} else {
			return addToSendRedirect(url);
		}
	}

	public String getFriendlyUrlProcessStateDisplay(String pageName, long statusTypeId) {
		String url = StringPool.BLANK;
		String format = "%s/%s/%s%s/-/process/view/%s/%s";
		pageName = prefixSlash(pageName);

		if (requestData.isPrivateLayout()) {
			url = String.format(format, StringPool.BLANK, "group", requestData.getGroupName(), pageName,
					String.valueOf(ds.getProcessState().getSpPEProcessStateId()), String.valueOf(statusTypeId));
		} else {
			url = String.format(format, StringPool.BLANK, "web", requestData.getGroupName(), pageName,
					String.valueOf(ds.getProcessState().getSpPEProcessStateId()), String.valueOf(statusTypeId));
		}

		if (_log.isDebugEnabled()) {
			_log.debug("getFriendlyUrlProcessStateDisplay : " + url);
		}

		// return the url
		if (ds.isSignedInUser()) {
			return url;
		} else {
			return addToSendRedirect(url);
		}
	}

	public String getUrlProcessStateListingOfficer() {
		String pageName = prefixSlash(getPageUrl());
		String url = addToSendRedirect(requestData.getPortalUrl() + pageName);

		return url;
	}

	public String getUrlProcessStateListingSupervisor() {
		String pageName = prefixSlash(getPageUrl());
		String url = addToSendRedirect(requestData.getPortalUrl() + pageName);

		return url;
	}

	public String getUrlProcessStateListingUser() {
		String pageName = prefixSlash(getPageUrl());
		String url = addToSendRedirect(requestData.getPortalUrl() + pageName);

		return url;
	}

	public String getUrlProcessStateListingAgent() {
		String pageName = prefixSlash(getPageUrl());
		String url = addToSendRedirect(requestData.getPortalUrl() + pageName);
		return url;
	}

	private String getPageUrl() {
		/*
		 * if (requestData.getCurPlid() > 0) { return getCurrentPageName(); }
		 */
		String pageName = StringPool.BLANK;
		PEProcess process = ds.getProcess();
		try {
			if (ds.isSupervisorLoggedInUser()) {
				pageName = process.getSupervisorPageName();
			} else if (ds.isAgentLoggedInUser()) {
				pageName = process.getAgentPageName();
			} else if (ds.isApplicantLoggedInUser()) {
				pageName = process.getUserPageName();
			} else {
				pageName = process.getApproverPageName();
			}

		} catch (Exception e) {
			_log.error(e);
		}
		return pageName;
	}

	private static String prefixSlash(String pageName) {
		pageName = GetterUtil.getString(pageName);

		if (pageName.charAt(0) != '/' && !pageName.startsWith("http")) {
			pageName = "/" + pageName;
		}

		return pageName;
	}

	private PEUrlHelper(PEDataSource ds) {
		this.ds = ds;
		this.requestData = ds.getRequestData();
	}

	public static PEUrlHelper getUrlHelper(PEDataSource ds) {
		return new PEUrlHelper(ds);
	}

	private static Log _log = LogFactoryUtil.getLog(PEUrlHelper.class);

	private PEDataSource ds;
	private PERequestData requestData;

}