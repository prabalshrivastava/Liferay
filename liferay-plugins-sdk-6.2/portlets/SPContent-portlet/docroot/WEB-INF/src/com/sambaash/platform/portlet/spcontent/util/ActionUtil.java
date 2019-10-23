package com.sambaash.platform.portlet.spcontent.util;

import static com.sambaash.platform.portlet.spcontent.StatusMessage.SERVE_RESOURCE_ERROR;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.portlet.LiferayPortletMode;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.sambaash.platform.portlet.spcontent.Constant;
import com.sambaash.platform.portlet.spcontent.WebKeys;
import com.sambaash.platform.portlet.spcontent.config.TabConfigurations;
import com.sambaash.platform.portlet.spcontent.resource.IResourceServer;
import com.sambaash.platform.portlet.spcontent.resource.ServeResourceException;

public class ActionUtil {
	private static final Log LOG = LogFactoryUtil.getLog(ActionUtil.class);
	private static final Map<String, Class<? extends IResourceServer>> RESOURCE_COMMAND_MAP;

	static {
		Map<String, Class<? extends IResourceServer>> map = new HashMap<String, Class<? extends IResourceServer>>();
//		map.put(GET_MODULES_CMD, ModuleResourceServer.class);
//		map.put(GET_COURSES_CMD, CourseListResourceServer.class);
//		map.put(GET_ASSETS_CMD, CourseAssetResourceServer.class);
		RESOURCE_COMMAND_MAP = Collections.unmodifiableMap(map);
	}
	
	private ActionUtil() {
		// prevent instantiation
	}
	
	public static void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
		LOG.info("serveResource command received: " + cmd);

		try {
			IResourceServer resourceServer = RESOURCE_COMMAND_MAP.get(cmd)
					.newInstance();
			resourceServer.serve(resourceRequest, resourceResponse);
		} catch (ServeResourceException e) {
			commonExceptionHandling(resourceRequest, e);
		} catch (InstantiationException e) {
			commonExceptionHandling(resourceRequest, e);
		} catch (IllegalAccessException e) {
			commonExceptionHandling(resourceRequest, e);
		}

	}

	private static void commonExceptionHandling(ResourceRequest resourceRequest,
			Exception e) {
		SessionErrors.add(resourceRequest.getPortletSession(),
				SERVE_RESOURCE_ERROR);
		LOG.error(e);
	}

	@SuppressWarnings("unchecked")
	public static List<AssetCategory> getVocabularyCategories(String vocabularyName) {

		List<AssetVocabulary> vocabularies = new ArrayList<>();
		List<AssetCategory> categories = new ArrayList<>();

		DynamicQuery queryVocabularies = DynamicQueryFactoryUtil.forClass(
				AssetVocabulary.class).add(
				PropertyFactoryUtil.forName("name").eq(vocabularyName)); 
		try {
			vocabularies = AssetVocabularyLocalServiceUtil.dynamicQuery( queryVocabularies, 0, 1);

			if (vocabularies.size() < 1) {
				return categories;
			}

			DynamicQuery queryCategories = DynamicQueryFactoryUtil.forClass(
					AssetCategory.class).add(
					PropertyFactoryUtil.forName("vocabularyId").eq(vocabularies.get(0).getVocabularyId())); 

			categories = AssetVocabularyLocalServiceUtil.dynamicQuery(queryCategories, 0, 100); 

		} catch (SystemException e) {
			LOG.error("Error retrieving categories for vocabulary : " + vocabularyName, e);
		}

		return categories;
	}
	
	public static long getAssetCategoryIdByName(String vocabularyName, String categoryName) {
		for (AssetCategory cat: getVocabularyCategories(vocabularyName)) {
			if (cat.getName().equals(categoryName)) {
				return cat.getCategoryId();
			}
		}
		return -1; // not found
	}
	
	public static SearchContext newSearchContext(PortletRequest request, int start, int end, String ... entryClassNames) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		SearchContext searchContext = SearchContextFactory
				.getInstance(PortalUtil.getHttpServletRequest(request));
		searchContext.setStart(start);
		searchContext.setEnd(end);
		if (entryClassNames != null && entryClassNames.length > 0) {
			searchContext.setEntryClassNames(entryClassNames);
		}
		searchContext.setGroupIds(new long[] { themeDisplay.getScopeGroupId() });
		searchContext.setCompanyId(themeDisplay.getCompanyId());
		Sort sort = SortFactoryUtil.create(Field.MODIFIED_DATE, Sort.LONG_TYPE, true);
		
		searchContext.setSorts(sort);
		
		return searchContext;
	}

	public static BooleanQuery newSearchQuery(SearchContext searchContext, long companyId, long groupId) {
		BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);
		searchQuery.addRequiredTerm(Field.COMPANY_ID, companyId);
		searchQuery.addRequiredTerm(Field.SCOPE_GROUP_ID, groupId);
		return searchQuery;
	}

	public static String generatePreferenceName(String prefName) {
		return DefaultConfigurationAction.PREFERENCES_PREFIX + prefName + StringPool.DOUBLE_DASH;
	}
	
	public static String getPreferenceValue(PortletPreferences portletPreferences, String prefName, String defaultValue) {
		return portletPreferences.getValue(prefName, defaultValue);
	}
	
	public static PortletURL newActionUrl(HttpServletRequest request, String actionMethod) {		
		try {
			PortletURL actionUrl =  newUrl(request, PortletRequest.ACTION_PHASE, LiferayWindowState.NORMAL, LiferayPortletMode.VIEW);
			actionUrl.setWindowState(LiferayWindowState.NORMAL);
			actionUrl.setPortletMode(LiferayPortletMode.VIEW);
			actionUrl.setParameter("javax.portlet.action", actionMethod);
			return actionUrl;
		} catch (PortletModeException | WindowStateException e) {
			LOG.error(e.getMessage());
		}
		return null;
	}
	
	public static PortletURL newResourceUrl(HttpServletRequest request, String resoureCommand) {		
		try {
			PortletURL resourceUrl =  newUrl(request, PortletRequest.RESOURCE_PHASE, LiferayWindowState.NORMAL, LiferayPortletMode.VIEW);
			resourceUrl.setWindowState(LiferayWindowState.NORMAL);
			resourceUrl.setPortletMode(LiferayPortletMode.VIEW);
			resourceUrl.setParameter(Constants.CMD, resoureCommand);
			return resourceUrl;
		} catch (PortletModeException | WindowStateException e) {
			LOG.error(e.getMessage());
		}
		return null;
	}
	
	public static PortletURL newRenderUrl(HttpServletRequest request, String actionMethod) {		
		try {
			PortletURL renderUrl =  newUrl(request, PortletRequest.RENDER_PHASE, LiferayWindowState.NORMAL, LiferayPortletMode.VIEW);
			renderUrl.setWindowState(LiferayWindowState.NORMAL);
			renderUrl.setPortletMode(LiferayPortletMode.VIEW);
			renderUrl.setParameter("javax.portlet.action", actionMethod);
			return renderUrl;
		} catch (PortletModeException | WindowStateException e) {
			LOG.error(e.getMessage());
		}
		return null;
	}
	
	public static PortletURL newUrl(HttpServletRequest request, String requestPhase, WindowState windowState, PortletMode portletMode) throws WindowStateException, PortletModeException {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL actionUrl =  PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), requestPhase);
		actionUrl.setWindowState(windowState);
		actionUrl.setPortletMode(portletMode);
		return actionUrl;
	}
	
	public static PortletURL newPortletURL(HttpServletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL actionUrl =  PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		try {
			actionUrl.setWindowState(LiferayWindowState.NORMAL);
			actionUrl.setPortletMode(LiferayPortletMode.VIEW);
		} catch (PortletModeException | WindowStateException e) {
			LOG.error(e.getMessage());
		}
		return actionUrl;
	}
	
	public static TabConfigurations retrieveTabConfigurations(PortletPreferences portletPreferences) {
		String tabConfigJson = ActionUtil.getPreferenceValue(portletPreferences, Constant.TAB_CONFIGURATION, "");
		return JSONFactoryUtil.looseDeserialize(tabConfigJson, TabConfigurations.class);
	}

	public static final String getImageUrlFromContent(String content) {
		String pattern = "(.*)<img(.*)src=['](.*)t=(\\d*)'[\\s](.*)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(content.replace("\"", "'"));
		if (m.find()) {
			return m.group(3) + "t=" + m.group(4);
		} else  {
			String patternNoTimestamp = "(.*)<img(.*)src=['](.*?)'[\\s](.*)";
			Pattern r2 = Pattern.compile(patternNoTimestamp);
			Matcher m2 = r2.matcher(content.replace("\"", "'"));
			if (m2.find()) {
				return m2.group(3);
			}
		}
		return "";
	}
	
}
