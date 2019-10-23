package com.sambaash.platform.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.ProtectedServletRequest;
import com.liferay.portal.kernel.struts.LastPath;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.login.hook.events.PostLoginRedirectAction;
import com.sambaash.platform.util.CookieUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Tracks user activity and does the following<br>
 * <li>If matches with action configs, add cookies suer-next-path &
 * user-next-path-forget; used after user login. <li>If matches with page
 * configs, add cookies user-last-path & user-last-path-forget<br>
 * <br>
 * 
 * Redirects to signin page in case a login is required.<br>
 * 
 * Note: Action configs are given more precedence than page<br>
 * 
 * <br>
 * Use "Login Redirect Settings" in site settings to change the configuration
 * 
 * @see PostLoginRedirectAction
 */
public class UserActivityFilter implements Filter {

	private static final Log logger = LogFactoryUtil
			.getLog(UserActivityFilter.class);

	String SIGN_IN_URL = "signin";
	private static Boolean read = false;

	private static boolean hasLoaded = false;
	private Map<Long, List<RedirectConfig>> pagesConfig = null;
	private Map<Long, List<RedirectConfig>> actionConfig = null;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		boolean redirectNeeded = false;

		try {
			// only ProtectedServletRequest will have liferay related attributes
			if (!(request instanceof ProtectedServletRequest)) {
				return;
			}

			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			long scopeGroupId = PortalUtil.getScopeGroupId(httpRequest);

			// TODO: add proper fix. On saving settings, need to reload the
			// configs
			String value = GetterUtil.getString(request
					.getParameter("_165_modifiedSections"));
			if (value.contains("_165_loginRedirectSettings")) {
				hasLoaded = false;
			}

			if (scopeGroupId == 0)
				return;

			// if enabled
			Boolean enabled = GetterUtil.getBoolean(SambaashUtil.getParameter(
					SambaashConstants.SITE_SETTINGS.ACTIVITY_BASED_REDIRECT,
					scopeGroupId));

			if (!enabled) {
				if (logger.isDebugEnabled())
					logger.debug(SambaashConstants.SITE_SETTINGS.ACTIVITY_BASED_REDIRECT
							+ " is disabled ");
				return;
			}

			if (fromSignInPage(httpRequest)) {
				forgetUrlsIfNeeded(httpRequest, httpResponse);
				return;
			}

			if (!hasLoaded) {
				if (logger.isDebugEnabled())
					logger.debug("Page and Action Configs not found, trying to cache");
				pagesConfig = new HashMap<Long, List<RedirectConfig>>();
				actionConfig = new HashMap<Long, List<RedirectConfig>>();
				// although there is one chcek already, another is needed after
				// reading a synchronized block
				read = false;
				synchronized (this) {
					if (!read)
						readConfig((HttpServletRequest) request, pagesConfig,
								actionConfig);
					read = true;
				}
				hasLoaded = true;
			}

			// start processing
			redirectNeeded = processRequest(httpRequest, httpResponse,
					pagesConfig, actionConfig);

			if (redirectNeeded) {
				((HttpServletResponse) response)
						.sendRedirect("/" + SIGN_IN_URL);
			}
		} catch (Exception e) {
			logger.error("Error processing user activity", e);
		} finally {
			if (!redirectNeeded)
				filterChain.doFilter(request, response);
		}

	}

	private boolean fromSignInPage(HttpServletRequest request) {
		String referer = request.getHeader("referer");
		if (referer == null || !referer.toLowerCase().contains(SIGN_IN_URL))
			return false;
		if (referer.indexOf("?") > 0)
			referer = referer.substring(0, referer.indexOf("?"));

		if (referer.endsWith(SIGN_IN_URL))
			return true;
		return false;
	}

	private void forgetUrlsIfNeeded(HttpServletRequest request,
			HttpServletResponse response) {

		Boolean lastPathForget = GetterUtil.getBoolean(CookieUtil.get(request,
				SambaashConstants.SITE_SETTINGS.USER_LAST_PATH_FORGET));
		if (lastPathForget) {
			expireCookie(request, response,
					SambaashConstants.SITE_SETTINGS.USER_LAST_PATH_FORGET);
			expireCookie(request, response,
					SambaashConstants.SITE_SETTINGS.USER_LAST_PATH);
		}

		Boolean nextPathForget = GetterUtil.getBoolean(CookieUtil.get(request,
				SambaashConstants.SITE_SETTINGS.USER_NEXT_PATH_FORGET));
		if (nextPathForget) {
			expireCookie(request, response,
					SambaashConstants.SITE_SETTINGS.USER_NEXT_PATH_FORGET);
			expireCookie(request, response,
					SambaashConstants.SITE_SETTINGS.USER_NEXT_PATH);
		}
	}

	private boolean processRequest(HttpServletRequest request,
			HttpServletResponse response,
			Map<Long, List<RedirectConfig>> pagesConfig,
			Map<Long, List<RedirectConfig>> actionConfig) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		String requestedUrl = getRequestedUrl(request, themeDisplay);
		if (Validator.isNull(requestedUrl))
			return false;
		boolean redirect = handleActions(request, response, actionConfig,
				requestedUrl);
		boolean redirect1 = handlePageUrls(request, response, pagesConfig,
				requestedUrl);
		return ((redirect || redirect1) && !themeDisplay.isSignedIn()) ? true
				: false;
	}

	private String getRequestedUrl(HttpServletRequest request,
			ThemeDisplay themeDisplay) {
		LastPath lastPath = (LastPath) request.getAttribute(WebKeys.LAST_PATH);
		if (Validator.isNull(lastPath))
			return null;
		Group scopeGroup = themeDisplay.getScopeGroup();
		String path = lastPath.getPath();

		path = path.replaceAll("^/" + scopeGroup.getName(), "");
		path = path.replaceAll("^/", "");
		return path;
	}

	private boolean handleActions(HttpServletRequest request,
			HttpServletResponse response,
			Map<Long, List<RedirectConfig>> actionsConfig, String requestedUrl)
			throws Exception {
		boolean matchFound = false;
		Long groupId = PortalUtil.getScopeGroupId(request);
		String fullUrl = PortalUtil.getCurrentURL(request);
		Map<String, String[]> parameterMap = request.getParameterMap();
		if (Validator.isNull(actionsConfig))
			return false;
		List<RedirectConfig> list = actionsConfig.get(groupId);
		if (Validator.isNull(list))
			return false;
		for (RedirectConfig redirectConfig : list) {
			if (Validator.isNull(redirectConfig))
				return false;

			if (!requestedUrl.toLowerCase().startsWith(
					redirectConfig.getActionUrl().toLowerCase()))
				continue;

			for (Entry<String, String> entry : redirectConfig.getParams()
					.entrySet()) {
				if (!parameterMap.containsKey(entry.getKey())) {
					matchFound = false;
					break;
				}

				String value = GetterUtil.getString(request.getParameter(entry
						.getKey()));
				if (!value.equalsIgnoreCase(entry.getValue())) {
					matchFound = false;
					break;
				}
			}

			if (matchFound) {
				addCookie(request, response,
						SambaashConstants.SITE_SETTINGS.USER_NEXT_PATH, fullUrl);
				addCookie(request, response,
						SambaashConstants.SITE_SETTINGS.USER_NEXT_PATH_FORGET,
						"" + redirectConfig.isForgetAfterProcess());
				return redirectConfig.isLoginRequired();
			}
		}
		return false;
	}

	private boolean handlePageUrls(HttpServletRequest request,
			HttpServletResponse response,
			Map<Long, List<RedirectConfig>> pagesConfig, String requestedUrl)
			throws Exception {
		Long groupId = PortalUtil.getScopeGroupId(request);
		String fullUrl = PortalUtil.getCurrentURL(request);
		if (Validator.isNull(pagesConfig) || Validator.isNull(pagesConfig.get(groupId)))
			return false;
		for (RedirectConfig redirectConfig : pagesConfig.get(groupId)) {
			if (!requestedUrl.toLowerCase().startsWith(
					redirectConfig.getActionUrl().toLowerCase()))
				continue;
			addCookie(request, response,
					SambaashConstants.SITE_SETTINGS.USER_LAST_PATH, fullUrl);
			addCookie(request, response,
					SambaashConstants.SITE_SETTINGS.USER_LAST_PATH_FORGET, ""
							+ redirectConfig.isForgetAfterProcess());
			return redirectConfig.isLoginRequired();
		}
		return false;
	}

	private void readConfig(HttpServletRequest request,
			Map<Long, List<RedirectConfig>> pagesConfig,
			Map<Long, List<RedirectConfig>> actionsConfig) {
		try {
			List<Company> companies = CompanyLocalServiceUtil
					.getCompanies(false);
			for (Company company : companies) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(GroupConstants.TYPE_SITE_OPEN);
				LinkedHashMap<String, Object> queryParams = new LinkedHashMap<String, Object>();
				queryParams.put("types", list);

				List<Group> groups = GroupLocalServiceUtil.search(
						company.getCompanyId(), queryParams, -1, -1);
				if (logger.isDebugEnabled())
					logger.debug("Found groups : " + groups);

				for (Group group : groups) {
					if (group.getName().equalsIgnoreCase("guest"))
						continue;
					try {
						readGroupConfig(request, group, pagesConfig,
								actionsConfig);
					} catch (Exception ee) {
						logger.error("Error while creating actions map for group = "
								+ group);
					}
				}

				logger.info(" ------ REDIRECT CONFIG -------");
				logger.info(pagesConfig);
				logger.info(actionsConfig);
				logger.info(" -----------------------------");
			}
		} catch (SystemException e) {
			logger.error("Error initializing configuration", e);
		}
	}

	private void readGroupConfig(HttpServletRequest request, Group group,
			Map<Long, List<RedirectConfig>> pagesConfig,
			Map<Long, List<RedirectConfig>> actionsConfig) throws Exception {

		long groupId = group.getGroupId();
		JSONArray arr = null;
		// page config
		String pageUrls = getSPParam(groupId,
				SambaashConstants.SITE_SETTINGS.LOGIN_REDIRECT_PAGES);

		if (logger.isDebugEnabled())
			logger.debug(SambaashConstants.SITE_SETTINGS.LOGIN_REDIRECT_PAGES
					+ " = " + pageUrls);

		if (Validator.isNotNull(pageUrls)) {
			arr = JSONFactoryUtil.createJSONArray(pageUrls);
			List<RedirectConfig> confs = new ArrayList<RedirectConfig>();
			for (int i = 0; i < arr.length(); i++) {
				JSONObject obj = arr.getJSONObject(i);
				String url = obj
						.getString(SambaashConstants.SITE_SETTINGS.ATTR_PG_REDIRECT_ACTION_PAGE);
				boolean forgetAfterProcess = GetterUtil
						.getBoolean(obj
								.getString(SambaashConstants.SITE_SETTINGS.ATTR_PG_REDIRECT_FORGET));
				boolean loginRequired = GetterUtil
						.getBoolean(obj
								.getString(SambaashConstants.SITE_SETTINGS.ATTR_PG_LOGIN_REQUIRED));
				RedirectConfig conf = new RedirectConfig();
				conf.setActionUrl(url);
				conf.setForgetAfterProcess(forgetAfterProcess);
				conf.setLoginRequired(loginRequired);
				confs.add(conf);
			}
			pagesConfig.put(groupId, confs);
		}

		// action config
		String actions = getSPParam(groupId,
				SambaashConstants.SITE_SETTINGS.LOGIN_REDIRECT_ACTIONS);
		if (logger.isDebugEnabled())
			logger.debug(SambaashConstants.SITE_SETTINGS.LOGIN_REDIRECT_ACTIONS
					+ " = " + actions);

		if (Validator.isNull(actions))
			return;
		arr = JSONFactoryUtil.createJSONArray(actions);
		List<RedirectConfig> actionConfigs = new ArrayList<RedirectConfig>();
		if (Validator.isNull(arr) || arr.length() == 0)
			return;

		for (int i = 0; i < arr.length(); i++) {
			JSONObject obj = arr.getJSONObject(i);
			String url = obj
					.getString(SambaashConstants.SITE_SETTINGS.ATTR_ACT_REDIRECT_ACTION_PAGE);
			String paramString = obj
					.getString(SambaashConstants.SITE_SETTINGS.ATTR_ACT_REDIRECT_ACTION_PARAMS);
			boolean forgetAfterProcess = GetterUtil
					.getBoolean(obj
							.getString(SambaashConstants.SITE_SETTINGS.ATTR_ACT_REDIRECT_FORGET));
			boolean loginRequired = GetterUtil
					.getBoolean(obj
							.getString(SambaashConstants.SITE_SETTINGS.ATTR_ACT_LOGIN_REQUIRED));
			RedirectConfig conf = new RedirectConfig();
			conf.setActionUrl(url);
			conf.setForgetAfterProcess(forgetAfterProcess);
			conf.setLoginRequired(loginRequired);

			Map<String, String> params = new HashMap<String, String>();
			RedirectConfig actionConfig = new RedirectConfig();
			actionConfig.setActionUrl(url);
			actionConfig.setParams(params);

			for (String pair : paramString.split("&")) {
				params.put(pair.split("=")[0], pair.split("=")[1]);
			}
			actionConfigs.add(actionConfig);
		}
		actionsConfig.put(groupId, actionConfigs);
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

	private String getSPParam(long groupId, String key) {
		return GetterUtil.getString(SambaashUtil.getParameter(key, groupId));
	}

	private void addCookie(ServletRequest request, ServletResponse response,
			String key, String value) {
		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge((int) (Time.YEAR / 1000));
		cookie.setPath("/");
		CookieUtil.addCookie((HttpServletRequest) request,
				(HttpServletResponse) response, cookie);
	}

	private void expireCookie(ServletRequest request, ServletResponse response,
			String key) {
		Cookie cookie = new Cookie(key, "");
		cookie.setMaxAge(0);
		cookie.setPath("/");
		CookieUtil.addCookie((HttpServletRequest) request,
				(HttpServletResponse) response, cookie);
	}

	class RedirectConfig {

		private String actionUrl;
		private boolean isLoginRequired;
		private boolean forgetAfterProcess;
		private Map<String, String> params;

		public String getActionUrl() {
			return actionUrl;
		}

		public void setActionUrl(String actionUrl) {
			this.actionUrl = actionUrl;
		}

		public Map<String, String> getParams() {
			return params;
		}

		public void setParams(Map<String, String> params) {
			this.params = params;
		}

		public boolean isLoginRequired() {
			return isLoginRequired;
		}

		public void setLoginRequired(boolean isLoginRequired) {
			this.isLoginRequired = isLoginRequired;
		}

		public boolean isForgetAfterProcess() {
			return forgetAfterProcess;
		}

		public void setForgetAfterProcess(boolean forgetAfterProcess) {
			this.forgetAfterProcess = forgetAfterProcess;
		}

		@Override
		public String toString() {
			return "ActionConfig [actionUrl=" + actionUrl + ", params="
					+ params + "]";
		}
	}

}
