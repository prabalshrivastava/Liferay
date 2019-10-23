package com.sambaash.platform.portlet.advancedsearch.action;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.compat.portal.model.UserConstants;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.OpenSearch;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.comparator.PortletTitleComparator;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.expando.util.ExpandoBridgeIndexerUtil;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageDisplay;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.model.MBTreeWalker;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.constant.SambaashConstants.REGISTRATION;
import com.sambaash.platform.model.ProfileType;
import com.sambaash.platform.portlet.advancedsearch.util.ASUtil;
import com.sambaash.platform.portlet.advancedsearch.wrapper.ASWrapper;
import com.sambaash.platform.portlet.advancedsearch.wrapper.AvailablePortletWrapper;
import com.sambaash.platform.portlet.advancedsearch.wrapper.SPDiscussionWrapper;
import com.sambaash.platform.srv.filter.model.SPSearchFilter;
import com.sambaash.platform.srv.filter.service.SPSearchFilterLocalServiceUtil;
import com.sambaash.platform.srv.spasset.NoSuchTypeException;
import com.sambaash.platform.srv.spasset.model.SPAssetEntry;
import com.sambaash.platform.srv.spasset.model.SPAssetType;
import com.sambaash.platform.srv.spasset.service.SPAssetTypeLocalServiceUtil;
import com.sambaash.platform.srv.spgroup.model.SPGroup;
import com.sambaash.platform.srv.spgroup.model.SPGroupUser;
import com.sambaash.platform.srv.spgroup.service.SPGroupUserLocalServiceUtil;
import com.sambaash.platform.srv.spjob.model.SPJob;
import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.util.OmnitureUtil;
import com.sambaash.platform.util.SambaashUtil;
//import sambaash.platform.srv.corporate.model.CorporateProfile;
//import sambaash.platform.srv.membershippackage.model.MembershipPackage;
//import sambaash.platform.srv.membershippackage.service.MembershipPackageLocalServiceUtil;

/**
 * Portlet implementation class AdvancedSearchAction
 */
public class AdvancedSearchAction extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			PortletPreferences preferences = renderRequest.getPreferences();
			String pageItems = preferences.getValue("pageItems", "0");
			String listingStyle = preferences.getValue("listingStyle",
					_DEFAULT_LISTING_STYLE);
			renderRequest.setAttribute("pageItems", pageItems);
			renderRequest.setAttribute("listingStyle", listingStyle);
			boolean isAdmin = SambaashUtil.isAdmin(
					themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
			renderRequest.setAttribute("isAdmin", isAdmin);
			String selectedSPAssetTypeIdStr = preferences.getValue(
					"selectedSPAssetTypeId", StringPool.BLANK);
			renderRequest.setAttribute("selectedSPAssetTypeId",
					selectedSPAssetTypeIdStr);

			String defaultSelectedPortletId = preferences.getValue(
					"defaultSelectedPortletId", StringPool.BLANK);
			String disableComponentSelector = preferences.getValue(
					"disableComponentSelector", StringPool.FALSE);
			String enableAutoSearch = preferences.getValue("enableAutoSearch",
					StringPool.FALSE);
			String hideSearchBar = preferences.getValue("hideSearchBar",
					StringPool.FALSE);
			String hideResultsBar = preferences.getValue("hideResultsBar",
					StringPool.FALSE);
			String hideSearchBarHeader = preferences.getValue(
					"hideSearchBarHeader", StringPool.FALSE);
			String showAdvancedSearchBtn = preferences.getValue(
					"showAdvancedSearchBtn", StringPool.FALSE);

			String openDetailPageOnANewTab = preferences.getValue(
					"openDetailPageOnANewTab", StringPool.TRUE);

			String redirectWhileSearching = preferences.getValue(
					"redirectWhileSearching", StringPool.FALSE);

			renderRequest.setAttribute("defaultSelectedPortletId",
					defaultSelectedPortletId);
			renderRequest.setAttribute("disableComponentSelector",
					disableComponentSelector);
			renderRequest.setAttribute("enableAutoSearch", enableAutoSearch);
			renderRequest.setAttribute("hideSearchBar", hideSearchBar);
			renderRequest.setAttribute("hideResultsBar", hideResultsBar);
			renderRequest.setAttribute("hideSearchBarHeader",
					hideSearchBarHeader);
			renderRequest.setAttribute("showAdvancedSearchBtn",
					showAdvancedSearchBtn);
			renderRequest.setAttribute("openDetailPageOnANewTab",
					openDetailPageOnANewTab);
			renderRequest.setAttribute("redirectWhileSearching",
					redirectWhileSearching);

			Locale defaultLocale = LocaleUtil.getDefault();
			ServletContext servletContext = (ServletContext) renderRequest
					.getAttribute(WebKeys.CTX);
			List<Portlet> portlets = this.getEnabledOpenSearchPortlets(
					themeDisplay, servletContext, defaultLocale);

			JSONObject allSearchFieldsJSONObject = JSONFactoryUtil
					.createJSONObject();

			for (Portlet p : portlets) {
				String searchFieldsJson = preferences.getValue(
						p.getPortletId(), StringPool.BLANK);

				if (Validator.isNotNull(searchFieldsJson)) {
					JSONObject searchFieldsJSONObject = JSONFactoryUtil
							.createJSONObject(searchFieldsJson);
					allSearchFieldsJSONObject.put(p.getPortletId(),
							searchFieldsJSONObject);
				} else {
					allSearchFieldsJSONObject.put(p.getPortletId(),
							StringPool.BLANK);
				}
			}

			renderRequest.setAttribute("allSearchFieldsJSONObject",
					allSearchFieldsJSONObject.toString());

			JSONArray portletJSONArray = getPortletJSONArray(renderRequest,
					themeDisplay, preferences);
			renderRequest.setAttribute("portletJSONArray",
					portletJSONArray.toString());

			JSONObject assetVocabulariesJSONObject = JSONFactoryUtil
					.createJSONObject();
			List<AssetVocabulary> assetVocabularies = AssetVocabularyLocalServiceUtil
					.getAssetVocabularies(-1, -1);

			for (AssetVocabulary av : assetVocabularies) {
				long vocabularyId = av.getVocabularyId();
				List<AssetCategory> assetCategories = AssetCategoryLocalServiceUtil
						.getVocabularyCategories(vocabularyId, -1, -1, null);
				JSONArray assetCategoriesJSONArray = JSONFactoryUtil
						.createJSONArray();

				for (AssetCategory ac : assetCategories) {
					assetCategoriesJSONArray.put(ac.getName().trim());
				}

				assetVocabulariesJSONObject.put(String.valueOf(vocabularyId),
						assetCategoriesJSONArray);
			}

			renderRequest.setAttribute("assetVocabulariesJSONObject",
					assetVocabulariesJSONObject.toString());

			List<Country> countries = CountryServiceUtil.getCountries();
			com.sambaash.platform.portlet.advancedsearch.json.JSONObject countriesJSONObject = new com.sambaash.platform.portlet.advancedsearch.json.JSONObject();

			for (Country c : countries) {
				countriesJSONObject.put(String.valueOf(c.getCountryId()),
						c.getName());
			}

			renderRequest.setAttribute("countriesJSONObject",
					countriesJSONObject.toString());

			List<SPSearchFilter> filterNames = SPSearchFilterLocalServiceUtil
					.getSPSearchFilters(-1, -1);
			JSONObject filterJSONObject = JSONFactoryUtil.createJSONObject();

			for (SPSearchFilter ftrNames : filterNames) {
				String fName = ftrNames.getFilterName();
				JSONObject fJSONObject = JSONFactoryUtil.createJSONObject();

				if (!fName.isEmpty()) {
					fJSONObject.put("filterName", fName);
					fJSONObject.put("filterDetails",
							ftrNames.getFilterParameter());
					filterJSONObject.put(
							String.valueOf(ftrNames.getSpSearchFilterId()),
							fJSONObject);
				}
			}

			renderRequest.setAttribute("filterJSONObject",
					filterJSONObject.toString());
			renderRequest.setAttribute("filterNames", filterNames);

			if (SambaashUtil.isOmnitureEnabled()
					&& "33".equalsIgnoreCase(defaultSelectedPortletId)
					&& Boolean.parseBoolean(enableAutoSearch)) {
				HttpServletRequest req = PortalUtil
						.getHttpServletRequest(renderRequest);
				HttpServletRequest request = PortalUtil
						.getOriginalServletRequest(req);
				String searchByCategory = preferences.getValue(
						"searchByCategory", StringPool.BLANK);
				AssetVocabulary vocabulary = null;
				String contentCategory = StringPool.BLANK;
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(
						AssetCategory.class,
						PortalClassLoaderUtil.getClassLoader());
				query.add(RestrictionsFactoryUtil.ilike("name", "%"
						+ searchByCategory + "%"));

				@SuppressWarnings("unchecked")
				List<AssetCategory> assetCategories = AssetCategoryLocalServiceUtil
						.dynamicQuery(query);

				for (AssetCategory assetCategory : assetCategories) {
					vocabulary = AssetVocabularyLocalServiceUtil
							.getAssetVocabulary(assetCategory.getVocabularyId());

					if ("videos".equalsIgnoreCase(vocabulary.getName())) {
						contentCategory = "videos";
					} else {
						contentCategory = "articles";
					}

					break;
				}

				if (Validator.isNull(contentCategory)) {
					_log.error("Content category is null, hence setting default value as articles.");
					contentCategory = "articles";
				}

				SambaashUtil.setOmnitureTags(OmnitureUtil.getOmnitureTags(
						searchByCategory, contentCategory,
						SambaashConstants.PAGE_TYPE.LANDING_PAGE,
						StringPool.BLANK, StringPool.BLANK, StringPool.BLANK),
						request);
			}

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.doView(renderRequest, renderResponse);
	}

	private JSONArray getPortletJSONArray(PortletRequest requeset,
			ThemeDisplay themeDisplay, PortletPreferences preferences)
			throws SystemException {
		JSONArray portletJSONArray = JSONFactoryUtil.createJSONArray();
		Locale defaultLocale = LocaleUtil.getDefault();
		ServletContext servletContext = (ServletContext) requeset
				.getAttribute(WebKeys.CTX);
		List<Portlet> portlets = this.getEnabledOpenSearchPortlets(
				themeDisplay, servletContext, defaultLocale);

		for (Portlet portlet : portlets) {
			String portletTitle = PortalUtil.getPortletTitle(portlet,
					servletContext, defaultLocale);
			String portletId = portlet.getPortletId();
			String portletIdLabel = preferences.getValue(portletId + "_label",
					StringPool.BLANK);
			String portletIdDisabled = preferences.getValue(portletId
					+ "_disabled", StringPool.FALSE);

			if (!"true".equalsIgnoreCase(portletIdDisabled)) {
				JSONObject portletJSONObject = JSONFactoryUtil
						.createJSONObject();
				portletJSONObject.put("portletId", portletId);

				if (Validator.isNull(portletIdLabel)) {
					portletIdLabel = portletTitle;
				}

				portletJSONObject.put("portletIdLabel", portletIdLabel);
				portletJSONObject.put("portletIdDisabled", portletIdDisabled);
				portletJSONArray.put(portletJSONObject);
			}
		}

		return portletJSONArray;
	}

	private List<AvailablePortletWrapper> getAvailablePortletWrapper(
			PortletRequest requeset, ThemeDisplay themeDisplay,
			PortletPreferences preferences) throws SystemException {
		List<AvailablePortletWrapper> availablePortletWrappers = new ArrayList<AvailablePortletWrapper>();
		Locale defaultLocale = LocaleUtil.getDefault();
		ServletContext servletContext = (ServletContext) requeset
				.getAttribute(WebKeys.CTX);
		List<Portlet> portlets = this.getEnabledOpenSearchPortlets(
				themeDisplay, servletContext, defaultLocale);

		for (Portlet portlet : portlets) {
			String portletTitle = PortalUtil.getPortletTitle(portlet,
					servletContext, defaultLocale);
			String portletId = portlet.getPortletId();
			String searchFieldsJson = preferences.getValue(portletId,
					StringPool.BLANK);
			String portletIdLabel = preferences.getValue(portletId + "_label",
					StringPool.BLANK);
			String portletIdDisabled = preferences.getValue(portletId
					+ "_disabled", StringPool.FALSE);
			availablePortletWrappers.add(new AvailablePortletWrapper(
					portletTitle, portletId, portletIdLabel, searchFieldsJson,
					portletIdDisabled));
		}

		return availablePortletWrappers;
	}

	@Override
	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			PortletPreferences preferences = renderRequest.getPreferences();

			ProfileType profileType1 = ProfileType.MARKETER;
			String profileType1Name = profileType1.name();
			String profileType2Name = SambaashConstants.MENTOR;
			String isShowImage = preferences.getValue("isShowImage",
					StringPool.FALSE);
			String isShowTitle = preferences.getValue("isShowTitle",
					StringPool.FALSE);
			String titleMaxLength = preferences.getValue("titleMaxLength", "0");
			String isShowContent = preferences.getValue("isShowContent",
					StringPool.FALSE);
			String contentMaxLength = preferences.getValue("contentMaxLength",
					"0");
			String isShowAuthor = preferences.getValue("isShowAuthor",
					StringPool.FALSE);
			String isProfileType1 = preferences.getValue("isProfileType1",
					StringPool.FALSE);
			String isProfileType2 = preferences.getValue("isProfileType2",
					StringPool.FALSE);

			String pageItems = preferences.getValue("pageItems", "0");
			String listingStyle = preferences.getValue("listingStyle",
					_DEFAULT_LISTING_STYLE);

			String defaultSelectedPortletId = preferences.getValue(
					"defaultSelectedPortletId", StringPool.BLANK);
			String disableComponentSelector = preferences.getValue(
					"disableComponentSelector", StringPool.FALSE);
			String enableAutoSearch = preferences.getValue("enableAutoSearch",
					StringPool.FALSE);
			String hideSearchBar = preferences.getValue("hideSearchBar",
					StringPool.FALSE);
			String hideResultsBar = preferences.getValue("hideResultsBar",
					StringPool.FALSE);
			String hideSearchBarHeader = preferences.getValue(
					"hideSearchBarHeader", StringPool.FALSE);
			String showAdvancedSearchBtn = preferences.getValue(
					"showAdvancedSearchBtn", StringPool.FALSE);
			String openDetailPageOnANewTab = preferences.getValue(
					"openDetailPageOnANewTab", StringPool.TRUE);

			String redirectWhileSearching = preferences.getValue(
					"redirectWhileSearching", StringPool.FALSE);

			renderRequest.setAttribute("profileType1Name", profileType1Name);
			renderRequest.setAttribute("profileType2Name", profileType2Name);
			renderRequest.setAttribute("isShowImage", isShowImage);
			renderRequest.setAttribute("isShowTitle", isShowTitle);
			renderRequest.setAttribute("titleMaxLength", titleMaxLength);
			renderRequest.setAttribute("isShowContent", isShowContent);
			renderRequest.setAttribute("contentMaxLength", contentMaxLength);
			renderRequest.setAttribute("isShowAuthor", isShowAuthor);
			renderRequest.setAttribute("isProfileType1", isProfileType1);
			renderRequest.setAttribute("isProfileType2", isProfileType2);

			renderRequest.setAttribute("pageItems", pageItems);
			renderRequest.setAttribute("listingStyle", listingStyle);

			renderRequest.setAttribute("defaultSelectedPortletId",
					defaultSelectedPortletId);
			renderRequest.setAttribute("disableComponentSelector",
					disableComponentSelector);
			renderRequest.setAttribute("enableAutoSearch", enableAutoSearch);
			renderRequest.setAttribute("hideSearchBar", hideSearchBar);
			renderRequest.setAttribute("hideResultsBar", hideResultsBar);
			renderRequest.setAttribute("hideSearchBarHeader",
					hideSearchBarHeader);
			renderRequest.setAttribute("showAdvancedSearchBtn",
					showAdvancedSearchBtn);

			renderRequest.setAttribute("openDetailPageOnANewTab",
					openDetailPageOnANewTab);
			renderRequest.setAttribute("redirectWhileSearching",
					redirectWhileSearching);

			String selectedSPAssetTypeIdStr = preferences.getValue(
					"selectedSPAssetTypeId", StringPool.BLANK);
			renderRequest.setAttribute("selectedSPAssetTypeId",
					selectedSPAssetTypeIdStr);

			List<AvailablePortletWrapper> availablePortletWrappers;
			availablePortletWrappers = getAvailablePortletWrapper(
					renderRequest, themeDisplay, preferences);
			renderRequest.setAttribute("availablePortletWrappers",
					availablePortletWrappers);

			StringBuffer sb = new StringBuffer();
			List<AssetVocabulary> assetVocabularies = AssetVocabularyLocalServiceUtil
					.getAssetVocabularies(-1, -1);

			for (AssetVocabulary av : assetVocabularies) {
				sb.append(av.getName() + ": " + av.getVocabularyId() + "; ");
			}

			renderRequest
					.setAttribute("assetVocabulariesString", sb.toString());

			sb = new StringBuffer();
			// List<MembershipPackage> mps =
			// MembershipPackageLocalServiceUtil.getMembershipPackages(-1, -1);
			// for (MembershipPackage mp : mps) {
			// sb.append(mp.getName() + ": " + mp.getMpId() + "; ");
			// }

			renderRequest.setAttribute("membershipPackagesString",
					sb.toString());

			String membershipPackages = preferences.getValue(
					"membershipPackages", StringPool.BLANK);
			renderRequest
					.setAttribute("membershipPackages", membershipPackages);

			String searchByKeywords = preferences.getValue("searchByKeywords",
					StringPool.BLANK);
			renderRequest.setAttribute("searchByKeywords", searchByKeywords);

			String[] searchKeywordsFields = preferences.getValues(
					"searchKeywordsFields", new String[0]);
			StringBuffer searchKeywordsFieldSB = new StringBuffer();

			for (String searchKeywordsField : searchKeywordsFields) {
				searchKeywordsFieldSB.append(searchKeywordsField);
				searchKeywordsFieldSB.append(StringPool.SPACE);
			}

			renderRequest.setAttribute("searchKeywordsFields",
					searchKeywordsFieldSB.toString().trim());

			String searchByTag = preferences.getValue("searchByTag",
					StringPool.BLANK);
			renderRequest.setAttribute("searchByTag", searchByTag);

			String searchByCategory = preferences.getValue("searchByCategory",
					StringPool.BLANK);
			renderRequest.setAttribute("searchByCategory", searchByCategory);

			List<SPAssetType> spAssetTypes = getAssetTypes();
			renderRequest.setAttribute("spAssetTypes", spAssetTypes);

			String minItemWidth = preferences.getValue("minItemWidth", "214");
			renderRequest.setAttribute("minItemWidth", minItemWidth);

			String groupDetailPageName = preferences.getValue(
					"groupDetailPageName", "group-detail");
			renderRequest.setAttribute("groupDetailPageName",
					groupDetailPageName);

			String groupDiscussionDetailPageName = preferences.getValue(
					"groupDiscussionDetailPageName", "discussion-detail");
			renderRequest.setAttribute("groupDiscussionDetailPageName",
					groupDiscussionDetailPageName);

			String eventDetailPageName = preferences.getValue(
					"eventDetailPageName", "event-details");
			renderRequest.setAttribute("eventDetailPageName",
					eventDetailPageName);

			String downloadLocation = "/usr/sambaashplatform/";
			downloadLocation = preferences.getValue("downloadLocation",
					StringPool.BLANK);
			renderRequest.setAttribute("downloadLocation", downloadLocation);

		} catch (SystemException e) {
			_log.error(e.getMessage(), e);
		}

		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			String action = actionRequest.getParameter("action");

			if (Constants.EDIT.equalsIgnoreCase(action)) {
				PortletPreferences preferences = actionRequest.getPreferences();

				Locale defaultLocale = LocaleUtil.getDefault();
				ServletContext servletContext = (ServletContext) actionRequest
						.getAttribute(WebKeys.CTX);
				List<Portlet> portlets = this.getEnabledOpenSearchPortlets(
						themeDisplay, servletContext, defaultLocale);

				for (Portlet p : portlets) {
					String searchFieldsJson = actionRequest.getParameter(p
							.getPortletId());
					String portletIdLabel = actionRequest.getParameter(p
							.getPortletId() + "_label");
					String portletIdDisabled = actionRequest.getParameter(p
							.getPortletId() + "_disabled");
					preferences.setValue(p.getPortletId(), searchFieldsJson);
					preferences.setValue(p.getPortletId() + "_label",
							portletIdLabel);
					preferences.setValue(p.getPortletId() + "_disabled",
							portletIdDisabled);
				}

				String isShowImage = actionRequest.getParameter("isShowImage");
				String isShowTitle = actionRequest.getParameter("isShowTitle");
				String titleMaxLength = actionRequest
						.getParameter("titleMaxLength");
				String isShowContent = actionRequest
						.getParameter("isShowContent");
				String contentMaxLength = actionRequest
						.getParameter("contentMaxLength");
				String isShowAuthor = actionRequest
						.getParameter("isShowAuthor");
				String isProfileType1 = actionRequest
						.getParameter("isProfileType1");
				String isProfileType2 = actionRequest
						.getParameter("isProfileType2");

				String pageItems = actionRequest.getParameter("pageItems");
				String listingStyle = actionRequest
						.getParameter("listingStyle");

				String defaultSelectedPortletId = actionRequest
						.getParameter("defaultSelectedPortletId");
				String disableComponentSelector = actionRequest
						.getParameter("disableComponentSelector");
				String enableAutoSearch = actionRequest
						.getParameter("enableAutoSearch");
				String hideSearchBar = actionRequest
						.getParameter("hideSearchBar");
				String hideResultsBar = actionRequest
						.getParameter("hideResultsBar");
				String hideSearchBarHeader = actionRequest
						.getParameter("hideSearchBarHeader");
				String showAdvancedSearchBtn = actionRequest
						.getParameter("showAdvancedSearchBtn");

				String openDetailPageOnANewTab = actionRequest
						.getParameter("openDetailPageOnANewTab");

				String redirectWhileSearching = actionRequest
						.getParameter("redirectWhileSearching");
				String downloadLocation = actionRequest
						.getParameter("downloadLocation");

				preferences.setValue("isProfileType1", isProfileType1);
				preferences.setValue("isProfileType2", isProfileType2);
				preferences.setValue("isShowImage", isShowImage);
				preferences.setValue("isShowTitle", isShowTitle);
				preferences.setValue("titleMaxLength", titleMaxLength);
				preferences.setValue("isShowContent", isShowContent);
				preferences.setValue("contentMaxLength", contentMaxLength);
				preferences.setValue("isShowAuthor", isShowAuthor);

				preferences.setValue("pageItems", pageItems);
				preferences.setValue("listingStyle", listingStyle);

				preferences.setValue("defaultSelectedPortletId",
						defaultSelectedPortletId);
				preferences.setValue("disableComponentSelector",
						disableComponentSelector);
				preferences.setValue("enableAutoSearch", enableAutoSearch);
				preferences.setValue("hideSearchBar", hideSearchBar);
				preferences.setValue("hideResultsBar", hideResultsBar);
				preferences
						.setValue("hideSearchBarHeader", hideSearchBarHeader);
				preferences.setValue("showAdvancedSearchBtn",
						showAdvancedSearchBtn);

				preferences.setValue("openDetailPageOnANewTab",
						openDetailPageOnANewTab);
				preferences.setValue("redirectWhileSearching",
						redirectWhileSearching);
				preferences.setValue("downloadLocation", downloadLocation);

				String membershipPackages = actionRequest
						.getParameter("membershipPackages");
				preferences.setValue("membershipPackages", membershipPackages);

				String searchByKeywords = actionRequest
						.getParameter("searchByKeywords");
				String[] searchKeywordsFields = actionRequest
						.getParameterValues("searchKeywordsFields");
				preferences.setValue("searchByKeywords", searchByKeywords);

				if (searchKeywordsFields != null
						&& searchKeywordsFields.length > 0) {
					preferences.setValues("searchKeywordsFields",
							searchKeywordsFields);
				} else {
					preferences
							.setValues("searchKeywordsFields", new String[0]);
				}

				String searchByTag = actionRequest.getParameter("searchByTag");
				preferences.setValue("searchByTag", searchByTag);

				String searchByCategory = actionRequest
						.getParameter("searchByCategory");
				preferences.setValue("searchByCategory", searchByCategory);

				String selectedSPAssetTypeIdStr = actionRequest
						.getParameter("selectedSPAssetTypeId");
				preferences.setValue("selectedSPAssetTypeId",
						selectedSPAssetTypeIdStr);

				String minItemWidth = actionRequest
						.getParameter("minItemWidth");
				preferences.setValue("minItemWidth", minItemWidth);

				String groupDetailPageName = actionRequest
						.getParameter("groupDetailPageName");
				preferences
						.setValue("groupDetailPageName", groupDetailPageName);

				String groupDiscussionDetailPageName = actionRequest
						.getParameter("groupDiscussionDetailPageName");
				preferences.setValue("groupDiscussionDetailPageName",
						groupDiscussionDetailPageName);

				String eventDetailPageName = actionRequest
						.getParameter("eventDetailPageName");
				preferences
						.setValue("eventDetailPageName", eventDetailPageName);

				preferences.store();

				actionResponse.setPortletMode(PortletMode.VIEW);
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String excelPath = "";

		try {
			String action = ParamUtil.getString(resourceRequest, "action");

			if ("saveFavorite".equalsIgnoreCase(action)) {
				long searchFilterId = CounterLocalServiceUtil
						.increment("SPSearchFilter.class");
				SPSearchFilter spSearchFilter = SPSearchFilterLocalServiceUtil
						.createSPSearchFilter(searchFilterId);
				String filterParameter = ParamUtil.getString(resourceRequest,
						"filterParameter");
				String filterName = ParamUtil.getString(resourceRequest,
						"filterName");

				spSearchFilter.setFilterName(filterName);
				spSearchFilter.setFilterParameter(filterParameter);
				spSearchFilter.setUserId(themeDisplay.getUserId());

				SPSearchFilterLocalServiceUtil
						.addSPSearchFilter(spSearchFilter);

				SPSearchFilter addedFName = SPSearchFilterLocalServiceUtil
						.getSPSearchFilter(searchFilterId);
				JSONObject filterJSONObject = JSONFactoryUtil
						.createJSONObject();
				String fName = addedFName.getFilterName();

				if (!fName.isEmpty()) {
					filterJSONObject.put(
							String.valueOf(addedFName.getSpSearchFilterId()),
							fName);
				}

				resourceRequest.setAttribute("filterJSONObject",
						filterJSONObject.toString());
				resourceResponse.getWriter().write(filterJSONObject.toString());

			} else if ("updateFavorite".equalsIgnoreCase(action)) {
				String filterSelected = ParamUtil.getString(resourceRequest,
						"filterSelected");
				String filterParameter = ParamUtil.getString(resourceRequest,
						"filterParameter");
				SPSearchFilter spSearchFilter = SPSearchFilterLocalServiceUtil
						.getSPSearchFilter(Long.parseLong(filterSelected));
				spSearchFilter.setFilterParameter(filterParameter);
				SPSearchFilterLocalServiceUtil
						.updateSPSearchFilter(spSearchFilter);

			} else if ("activate".equalsIgnoreCase(action)) {
				JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
				String result = "failure";
				String replaceText = StringPool.BLANK;
				long classPK = ParamUtil.getLong(resourceRequest, "classPK");
				String text = ParamUtil.getString(resourceRequest, "text");

				if ("deactivate".equalsIgnoreCase(text)) {
					int status = WorkflowConstants.STATUS_INACTIVE;
					try {
						UserServiceUtil.updateStatus(classPK, status);
						SocialProfile socialProfile = SocialProfileLocalServiceUtil
								.getSocialProfile(classPK);
						socialProfile
								.setUserRegistrationStatus(REGISTRATION.USER_REGISTRATION_STATUS_INACTIVE);
						SocialProfileLocalServiceUtil
								.updateSocialProfile(socialProfile);
						Indexer indexer = IndexerRegistryUtil
								.getIndexer(SocialProfile.class.getName());
						indexer.reindex(socialProfile);
						result = "success";
						replaceText = "Activate";
					} catch (Exception e) {
						if (e instanceof NoSuchSocialProfileException) {

							// do nothing

						} else {
							_log.error(e.getMessage(), e);
						}
					}
				} else if ("activate".equalsIgnoreCase(text)) {
					int status = WorkflowConstants.STATUS_APPROVED;
					try {
						UserServiceUtil.updateStatus(classPK, status);
						SocialProfile socialProfile = SocialProfileLocalServiceUtil
								.getSocialProfile(classPK);
						socialProfile
								.setUserRegistrationStatus(REGISTRATION.USER_REGISTRATION_STATUS_ACTIVE);
						SocialProfileLocalServiceUtil
								.updateSocialProfile(socialProfile);
						Indexer indexer = IndexerRegistryUtil
								.getIndexer(SocialProfile.class.getName());
						indexer.reindex(socialProfile);
						result = "success";
						replaceText = "Deactivate";
					} catch (Exception e) {
						if (e instanceof NoSuchSocialProfileException) {

							// do nothing

						} else {
							_log.error(e.getMessage(), e);
						}
					}
				}

				dataJSONObject.put("result", result);
				dataJSONObject.put("replaceText", replaceText);
				resourceResponse.getWriter().write(dataJSONObject.toString());
			} else {
				portalURL = PortalUtil.getPortalURL(resourceRequest);
				Map<String, Object> paramsMap = new HashMap<String, Object>();

				PortletPreferences preferences = resourceRequest
						.getPreferences();
				String isShowImage = preferences.getValue("isShowImage",
						StringPool.BLANK);
				String isShowTitle = preferences.getValue("isShowTitle",
						StringPool.BLANK);
				String titleMaxLengthStr = preferences.getValue(
						"titleMaxLength", "0");
				String isShowContent = preferences.getValue("isShowContent",
						StringPool.BLANK);
				String contentMaxLengthStr = preferences.getValue(
						"contentMaxLength", "0");
				String isShowAuthor = preferences.getValue("isShowAuthor",
						StringPool.BLANK);
				String downloadLocation = preferences.getValue(
						"downloadLocation", StringPool.BLANK);

				String isProfileType1 = preferences.getValue("isProfileType1",
						StringPool.BLANK);
				String isProfileType2 = preferences.getValue("isProfileType2",
						StringPool.BLANK);
				paramsMap.put("isProfileType1", isProfileType1);
				paramsMap.put("isProfileType2", isProfileType2);
				paramsMap.put("downloadLocation", downloadLocation);

				String openDetailPageOnANewTab = preferences.getValue(
						"openDetailPageOnANewTab", StringPool.TRUE);

				String minItemWidthStr = preferences.getValue("minItemWidth",
						"214");
				String groupDetailPageName = preferences.getValue(
						"groupDetailPageName", "group-detail");
				String groupDiscussionDetailPageName = preferences.getValue(
						"groupDiscussionDetailPageName", "discussion-detail");
				String eventDetailPageName = preferences.getValue(
						"eventDetailPageName", "event-details");
				paramsMap.put("groupDetailPageName", groupDetailPageName);
				paramsMap.put("groupDiscussionDetailPageName",
						groupDiscussionDetailPageName);
				paramsMap.put("eventDetailPageName", eventDetailPageName);

				String membershipPackages = preferences.getValue(
						"membershipPackages", StringPool.BLANK);
				paramsMap.put("membershipPackages", membershipPackages);

				String searchByKeywords = preferences.getValue(
						"searchByKeywords", StringPool.BLANK);
				String[] searchKeywordsFields = preferences.getValues(
						"searchKeywordsFields", new String[0]);
				paramsMap.put("searchByKeywords", searchByKeywords);
				paramsMap.put("searchKeywordsFields", searchKeywordsFields);

				String searchByTag = preferences.getValue("searchByTag",
						StringPool.BLANK);
				paramsMap.put("searchByTag", searchByTag);

				String searchByCategory = preferences.getValue(
						"searchByCategory", StringPool.BLANK);
				paramsMap.put("searchByCategory", searchByCategory);

				String pageItemsStr = preferences.getValue("pageItems", "0");
				String listingStyle = preferences.getValue("listingStyle",
						_DEFAULT_LISTING_STYLE);

				String selectedSPAssetTypeIdStr = preferences.getValue(
						"selectedSPAssetTypeId", StringPool.BLANK);

				int pageItems = 0;
				int titleMaxLength = 0;
				int contentMaxLength = 0;
				long selectedSPAssetTypeId = 0;
				try {
					pageItems = Integer.valueOf(pageItemsStr);
				} catch (NumberFormatException nfe) {
					pageItems = 0;
				}

				try {
					titleMaxLength = Integer.valueOf(titleMaxLengthStr);
				} catch (NumberFormatException nfe) {
					titleMaxLength = 0;
				}

				try {
					contentMaxLength = Integer.valueOf(contentMaxLengthStr);
				} catch (NumberFormatException nfe) {
					contentMaxLength = 0;
				}

				try {
					selectedSPAssetTypeId = Long
							.valueOf(selectedSPAssetTypeIdStr);
				} catch (NumberFormatException nfe) {
					selectedSPAssetTypeId = 0;
				}

				String selectedSPAssetTypeIdStr_ = ParamUtil.getString(resourceRequest, "selectedSPAssetTypeId_");
				long selectedSPAssetTypeId_ = 0;
				try {
					selectedSPAssetTypeId_ = Long
							.valueOf(selectedSPAssetTypeIdStr_);
				} catch (NumberFormatException nfe) {

					// do nothing

				}

				if (selectedSPAssetTypeId_ > 0) {
					selectedSPAssetTypeId = selectedSPAssetTypeId_;
				}

				String bcoValue = ParamUtil.getString(resourceRequest, "bcoValue");
				paramsMap.put("bcoValue", bcoValue);

				paramsMap.put("titleMaxLength", titleMaxLength);
				paramsMap.put("contentMaxLength", contentMaxLength);
				paramsMap.put("selectedSPAssetTypeId", selectedSPAssetTypeId);

				int currentPage = ParamUtil.getInteger(resourceRequest, "currentPage");

				String download = ParamUtil.getString(resourceRequest, "download");
				String selectedPortletId = ParamUtil.getString(resourceRequest,"selectedPortletId");
				String selectedDate = ParamUtil.getString(resourceRequest,"selectedDate");

				paramsMap.put("selectedDate", selectedDate);

				String occur = ParamUtil.getString(resourceRequest,"occur");
				String clause = ParamUtil.getString(resourceRequest,"clause");
				String q = ParamUtil.getString(resourceRequest,"q");

				String indexerClassName = StringPool.BLANK;

				if (Validator.isNotNull(selectedPortletId)) {
					Portlet portlet = PortletLocalServiceUtil
							.getPortletById(selectedPortletId);

					if (portlet != null) {
						List<Indexer> indexerList = portlet
								.getIndexerInstances();

						if (indexerList != null && indexerList.size() > 0) {
							String[] classNames = indexerList.get(0)
									.getClassNames();

							if (classNames.length > 0) {
								indexerClassName = classNames[0];
							}
						}
					}
				}

				if ("true".equalsIgnoreCase(isProfileType1)
						|| "true".equalsIgnoreCase(isProfileType2)) {
					indexerClassName = User.class.getName();
				}

				int start = currentPage * pageItems;
				int end = (currentPage + 1) * pageItems;

				paramsMap.put("start", start);
				paramsMap.put("end", end);

				paramsMap.put("indexerClassName", indexerClassName);

				paramsMap.put("occur", occur);
				paramsMap.put("clause", clause);
				paramsMap.put("q", q);
				paramsMap.put("download", download);

				Map<String, Object> resultsMap = search(resourceRequest,
						themeDisplay, paramsMap);

				@SuppressWarnings("unchecked")
				List<ASWrapper> wrappers = (List<ASWrapper>) resultsMap
						.get("wrappers");
				int count = (Integer) resultsMap.get("count");
				JSONObject data = JSONFactoryUtil.createJSONObject();
				JSONArray items = JSONFactoryUtil.createJSONArray();
				JSONObject countJSONObject = JSONFactoryUtil.createJSONObject();
				countJSONObject.put("value", count);
				excelPath = String.valueOf(resultsMap.get("excelPath"));

				int minItemWidth = 214;
				try {
					minItemWidth = Integer.valueOf(minItemWidthStr);
				} catch (NumberFormatException nfe) {

					// do nothing

				}

				String wp = minItemWidth + "px";

				for (ASWrapper wrapper : wrappers) {
					JSONObject item = JSONFactoryUtil.createJSONObject();

					StringBuffer sb = new StringBuffer();

					if ("horizontal".equalsIgnoreCase(listingStyle)) {
						sb.append("<div class=\"search-stream-mosaic-block\" ");
						sb.append("style=\"width: " + wp + ";\">");
					} else if("fullhorizontal".equalsIgnoreCase(listingStyle)){
						sb.append("<div class=\"search-stream-mosaic-block fullHorizontal-Listing\" ");
						sb.append("style=\"width: " + wp + ";\">");
					}else {
						sb.append("<li class=\"search-stream-mosaic-block\"> ");
						
					}
					// sb.append("<li class=\"search-stream-mosaic-block\">");
					sb.append("<div style=\"width: 100%; position: relative;\" class=\"search-stream-mosaic-content-wrap\">");
					if (SocialProfile.class.getName().equalsIgnoreCase(indexerClassName)
							&& (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId()) || SambaashUtil
									.isSupportRole(themeDisplay.getScopeGroupId(), themeDisplay.getUserId()))) {
						sb.append("<div  class=\"search-stream-mosaic-content-actions\">");
						sb.append("<a href=\"" + wrapper.getDetailUrl() + "\" target=\"_blank\" class=\"as-profile-edit\">Edit</a> ");
						if (wrapper.isActive()) {
							sb.append("<a href=\"javascript:;\" title=\""
									+ wrapper.getClassPK()
									+ "\" class=\"as-profile-activate\">Deactivate</a>");
						} else {
							sb.append("<a href=\"javascript:;\" title=\""
									+ wrapper.getClassPK()
									+ "\" class=\"as-profile-activate\">Activate</a>");
						}

						sb.append("</div>");
					}

					if ("true".equalsIgnoreCase(isShowImage)) {
						sb.append("<div class=\"search-stream-mosaic-block-icon\">");
						sb.append("<a href=\"" + wrapper.getDetailUrl() + "\"");

						if (StringPool.TRUE
								.equalsIgnoreCase(openDetailPageOnANewTab)) {
							sb.append(" target=\"_blank\"");
						}

						sb.append(">");
						sb.append("<img alt=\"Image\" src=\"");

						if (Validator.isNotNull(wrapper.getImage())) {
							sb.append(wrapper.getImage().trim());
						} else {
							sb.append(wrapper.getImage().trim());
						}

						sb.append("\">");
						sb.append("</a>");
					} else {
						sb.append("<div class=\"search-stream-mosaic-empty-icon\">");
					}

					sb.append("</div>");

					boolean isShowGroupDiscussion = false;

					if (wrapper.getSpDiscussionWrappers() != null
							&& wrapper.getSpDiscussionWrappers().size() > 0) {
						isShowGroupDiscussion = true;
					}

					if ("true".equalsIgnoreCase(isShowImage)) {
						sb.append("<div class=\"search-stream-mosaic-block-content\">");
					} else {
						sb.append("<div class=\"search-stream-mosaic-empty-content\">");
					}

					if (isShowGroupDiscussion) {
						sb.append("<b>Discussions:</b><br/>");
						for(SPDiscussionWrapper spDiscussionWrapper : wrapper.getSpDiscussionWrappers()) {
							if (Validator.isNotNull(spDiscussionWrapper.getTitle())) {
								sb.append("<div class=\"content-title\"><a href=\"" + spDiscussionWrapper.getDetailUrl() + "\"");
								//sb.append(spDiscussionWrapper.getDetailUrl());
								if (StringPool.TRUE.equalsIgnoreCase(openDetailPageOnANewTab)) {
									sb.append(" target=\"_blank\"");
								}

								sb.append(">");
								sb.append(spDiscussionWrapper.getTitle().trim());
								sb.append("</a></div>");
							}
						}
					} else {
						if (Validator.isNotNull(wrapper.getTitle())
								&& "true".equalsIgnoreCase(isShowTitle)) {
							sb.append("<div class=\"content-title\"><a href=\""
									+ wrapper.getDetailUrl() + "\"");

							if (StringPool.TRUE
									.equalsIgnoreCase(openDetailPageOnANewTab)) {
								sb.append(" target=\"_blank\"");
							}

							sb.append(">");
							sb.append(wrapper.getTitle().trim());
							sb.append("</a></div>");
						}

						if (Validator.isNotNull(wrapper.getContent())
								&& "true".equalsIgnoreCase(isShowContent)) {
							sb.append("<div class=\"search-stream-mosaic-block-description\">");
							sb.append(wrapper.getContent().trim());
							sb.append("</div>");
						}

						if (Validator.isNotNull(wrapper.getAuthor())
								&& "true".equalsIgnoreCase(isShowAuthor)) {
							sb.append("<div class=\"search-stream-mosaic-block-author\"><a href=\"");
							sb.append(wrapper.getProfileUrl());
							sb.append("\" target=\"_blank\">");
							sb.append("<b>" + wrapper.getAuthor().trim() + "</b>");
							sb.append("</a></br> ");
							sb.append(wrapper.getDisplayDate());
							sb.append("</div>");
						}

						sb.append("</div>");
					}

					sb.append("</div>");

					if ("horizontal".equalsIgnoreCase(listingStyle)) {
						sb.append("</div>");
					} else {
						sb.append("</li>");
					}

					item.put("html", sb.toString());
					items.put(item);
				}

				data.put("items", items);
				data.put("count", countJSONObject);
				data.put("excelPath", excelPath);

				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.serveResource(resourceRequest, resourceResponse);
	}

	public Map<String, Object> search(ResourceRequest resourceRequest,
			ThemeDisplay themeDisplay, Map<String, Object> paramsMap) {
		String indexerClassName = (String) paramsMap.get("indexerClassName");
		_log.error("indexerClassName " + indexerClassName);
		String bcoValue = (String) paramsMap.get("bcoValue");

		String occur = (String) paramsMap.get("occur");
		String clause = (String) paramsMap.get("clause");
		String q = (String) paramsMap.get("q");
		String isProfileType1 = (String) paramsMap.get("isProfileType1");
		String isProfileType2 = (String) paramsMap.get("isProfileType2");

		int start = (Integer) paramsMap.get("start");
		int end = (Integer) paramsMap.get("end");
		String download = (String) paramsMap.get("download");
		Map<String, Object> resultsMap = new HashMap<String, Object>();
		int count = 0;
		List<ASWrapper> wrappers = new ArrayList<ASWrapper>(0);

		if (Validator.isNotNull(indexerClassName)) {
			try {
				SearchContext searchContext = new SearchContext();
				searchContext.setCompanyId(themeDisplay.getCompanyId());
				searchContext.setStart(start);
				searchContext.setEnd(end);
				Sort sort = SortFactoryUtil.create(Field.CREATE_DATE,
						Sort.LONG_TYPE, true);
				if (BlogsEntry.class.getName().equalsIgnoreCase(
						indexerClassName)) {
					sort = SortFactoryUtil.create("displayDate",
							Sort.LONG_TYPE, true);
				}
				Sort[] sorts = new Sort[] { sort };
				searchContext.setSorts(sorts);

				String[] occurArray = StringUtil.split(occur, StringPool.DASH);
				String[] clauseArray = StringUtil
						.split(clause, StringPool.DASH);
				String[] qArray = StringUtil.split(q, StringPool.DASH);

				int length = occurArray.length;

				if (clauseArray.length < length || qArray.length < length) {
					resultsMap.put("count", count);
					resultsMap.put("wrappers", wrappers);
					return resultsMap;
				}

				String selectedDate = (String) paramsMap.get("selectedDate");

				List<BooleanClause> booleanClauseList = new ArrayList<BooleanClause>();

				if (Validator.isNotNull(selectedDate)) {
					Calendar fromCalendar = Calendar.getInstance();
					Calendar toCalendar = Calendar.getInstance();

					if ("last_24_hours".equalsIgnoreCase(selectedDate)) {
						fromCalendar.add(Calendar.HOUR_OF_DAY, -24);
					} else if ("last_7_days".equalsIgnoreCase(selectedDate)) {
						fromCalendar.add(Calendar.DAY_OF_MONTH, -7);
					} else if ("last_30_days".equalsIgnoreCase(selectedDate)) {
						fromCalendar.add(Calendar.MONTH, -1);
					} else if ("last_365_days".equalsIgnoreCase(selectedDate)) {
						fromCalendar.add(Calendar.YEAR, -1);
					}

					String fromDateString = FastDateFormatFactoryUtil
							.getSimpleDateFormat(_DATE_FORMAT_PATTERN).format(
									fromCalendar.getTime());
					String toDateString = FastDateFormatFactoryUtil
							.getSimpleDateFormat(_DATE_FORMAT_PATTERN).format(
									toCalendar.getTime());

					BooleanQuery dateBooleanQuery = BooleanQueryFactoryUtil
							.create(searchContext);
					dateBooleanQuery.addRangeTerm(Field.MODIFIED_DATE,
							fromDateString, toDateString);
					BooleanClause dateBooleanClause = BooleanClauseFactoryUtil
							.create(searchContext, dateBooleanQuery,
									BooleanClauseOccur.MUST.getName());
					booleanClauseList.add(dateBooleanClause);
				}

				if (occurArray.length > 0) {
					BooleanQuery fullQuery = BooleanQueryFactoryUtil
							.create(searchContext);

					for (int i = 0; i < occurArray.length; i++) {
						BooleanQuery _booleanQuery = BooleanQueryFactoryUtil
								.create(searchContext);
						String _clause = clauseArray[i];
						String _q = qArray[i];

						_booleanQuery
								.addRequiredTerm(_clause, "\"" + _q + "\"");

						if ("and".equalsIgnoreCase(bcoValue)) {
							fullQuery.add(_booleanQuery,
									BooleanClauseOccur.MUST.getName());
						} else {
							fullQuery.add(_booleanQuery,
									BooleanClauseOccur.SHOULD.getName());
						}
					}

					BooleanClause _booleanClause = BooleanClauseFactoryUtil
							.create(searchContext, fullQuery,
									BooleanClauseOccur.MUST.getName());
					booleanClauseList.add(_booleanClause);
				}

				String membershipPackages = (String) paramsMap
						.get("membershipPackages");

				if (SocialProfile.class.getName().equalsIgnoreCase(
						indexerClassName)
						&& Validator.isNotNull(membershipPackages)) {
					JSONObject membershipPackagesJSONObject = JSONFactoryUtil
							.createJSONObject(membershipPackages);
					long currentUserId = themeDisplay.getUserId();
					SocialProfile socialProfile = SocialProfileLocalServiceUtil
							.getSocialProfile(currentUserId);
					long mpId = socialProfile.getMemberPackage();
					JSONArray availableMpJSONArray = membershipPackagesJSONObject
							.getJSONArray(String.valueOf(mpId));
					BooleanQuery membershipPackagesBooleanQuery = BooleanQueryFactoryUtil
							.create(searchContext);

					for (int j = 0; j < availableMpJSONArray.length(); j++) {
						long ampId = availableMpJSONArray.getLong(j);
						// MembershipPackage amp =
						// MembershipPackageLocalServiceUtil.getMembershipPackage(ampId);
						// membershipPackagesBooleanQuery.addTerm("membershipPackage",
						// amp.getName());
					}

					BooleanClause membershipPackagesBooleanClause = BooleanClauseFactoryUtil
							.create(searchContext,
									membershipPackagesBooleanQuery,
									BooleanClauseOccur.MUST.getName());
					booleanClauseList.add(membershipPackagesBooleanClause);
				}

				String searchByKeywords = (String) paramsMap
						.get("searchByKeywords");
				String[] searchKeywordsFields = (String[]) paramsMap
						.get("searchKeywordsFields");

				if (Validator.isNotNull(searchByKeywords)) {
					if (searchKeywordsFields.length > 0) {
						for (String searchKeywordsField : searchKeywordsFields) {
							BooleanQuery keywordsBooleanQuery = BooleanQueryFactoryUtil
									.create(searchContext);
							keywordsBooleanQuery.addRequiredTerm(
									searchKeywordsField, searchByKeywords);
							BooleanClause keywordsBooleanClause = BooleanClauseFactoryUtil
									.create(searchContext,
											keywordsBooleanQuery,
											BooleanClauseOccur.MUST.getName());
							booleanClauseList.add(keywordsBooleanClause);
						}
					} else {
						searchContext.setKeywords(searchByKeywords);
					}
				}

				String searchByTag = (String) paramsMap.get("searchByTag");

				if (Validator.isNotNull(searchByTag)) {
					BooleanQuery tagBooleanQuery = BooleanQueryFactoryUtil
							.create(searchContext);
					tagBooleanQuery.addRequiredTerm("assetTagNames", "\""
							+ searchByTag + "\"");
					BooleanClause tagBooleanClause = BooleanClauseFactoryUtil
							.create(searchContext, tagBooleanQuery,
									BooleanClauseOccur.MUST.getName());
					booleanClauseList.add(tagBooleanClause);
				}

				String searchByCategory = (String) paramsMap
						.get("searchByCategory");

				if (Validator.isNotNull(searchByCategory)) {
					BooleanQuery categoryBooleanQuery = BooleanQueryFactoryUtil
							.create(searchContext);
					categoryBooleanQuery.addRequiredTerm(Field.ASSET_CATEGORY_TITLES,
							"\"" + searchByCategory + "\"");
					BooleanClause categoryBooleanClause = BooleanClauseFactoryUtil
							.create(searchContext, categoryBooleanQuery,
									BooleanClauseOccur.MUST.getName());
					booleanClauseList.add(categoryBooleanClause);
				}

				if (SPAssetEntry.class.getName().equalsIgnoreCase(
						indexerClassName)) {
					long selectedSPAssetTypeId = (Long) paramsMap
							.get("selectedSPAssetTypeId");

					if (Validator.isNotNull(selectedSPAssetTypeId)) {
						BooleanQuery spAssetTypeBooleanQuery = BooleanQueryFactoryUtil
								.create(searchContext);
						spAssetTypeBooleanQuery.addRequiredTerm(
								"spAssetTypeId", "\"" + selectedSPAssetTypeId
										+ "\"");
						BooleanClause spAssetTypeBooleanClause = BooleanClauseFactoryUtil
								.create(searchContext, spAssetTypeBooleanQuery,
										BooleanClauseOccur.MUST.getName());
						booleanClauseList.add(spAssetTypeBooleanClause);
					}
				}

				if (User.class.getName().equalsIgnoreCase(indexerClassName)) {
					
//					BooleanQuery stausBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
//					stausBooleanQuery.addRequiredTerm(Field.STATUS, WorkflowConstants.STATUS_APPROVED);
//					BooleanClause statusBooleanClause = BooleanClauseFactoryUtil.create(searchContext,stausBooleanQuery,
//							BooleanClauseOccur.MUST.getName());
//					booleanClauseList.add(statusBooleanClause);

					if("true".equalsIgnoreCase(isProfileType1)){
						BooleanQuery profileType1BooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
						profileType1BooleanQuery.addRequiredTerm("profileType", ProfileType.MARKETER.getValue());
						BooleanClause profileType1BooleanClause = BooleanClauseFactoryUtil.create(searchContext,
								profileType1BooleanQuery, BooleanClauseOccur.MUST.getName());
						booleanClauseList.add(profileType1BooleanClause);
					}

					if ("true".equalsIgnoreCase(isProfileType2)) {
						BooleanQuery profileType2BooleanQuery = BooleanQueryFactoryUtil
								.create(searchContext);
						profileType2BooleanQuery.addRequiredTerm(
								ExpandoBridgeIndexerUtil
										.encodeFieldName("mentor"),
								Boolean.TRUE);
						BooleanClause profileType2BooleanClause = BooleanClauseFactoryUtil
								.create(searchContext,
										profileType2BooleanQuery,
										BooleanClauseOccur.MUST.getName());
						booleanClauseList.add(profileType2BooleanClause);
					}
				}

				if (SocialProfile.class.getName().equalsIgnoreCase(
						indexerClassName)) {
					if (!SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(),
							themeDisplay.getUserId())) {
						BooleanQuery stausBooleanQuery = BooleanQueryFactoryUtil
								.create(searchContext);
						stausBooleanQuery.addRequiredTerm(Field.STATUS,
								WorkflowConstants.STATUS_APPROVED);
						BooleanClause statusBooleanClause = BooleanClauseFactoryUtil
								.create(searchContext, stausBooleanQuery,
										BooleanClauseOccur.MUST.getName());
						booleanClauseList.add(statusBooleanClause);

						BooleanQuery registrationStatusBooleanQuery = BooleanQueryFactoryUtil
								.create(searchContext);
						registrationStatusBooleanQuery.addRequiredTerm(
								"userRegistrationStatus",
								REGISTRATION.USER_REGISTRATION_STATUS_ACTIVE);
						BooleanClause registrationStatusBooleanClause = BooleanClauseFactoryUtil
								.create(searchContext,
										registrationStatusBooleanQuery,
										BooleanClauseOccur.MUST.getName());
						booleanClauseList.add(registrationStatusBooleanClause);
					}
				}

				if (SPGroup.class.getName().equalsIgnoreCase(indexerClassName)) {
					BooleanQuery spGroupTypeBooleanQuery = BooleanQueryFactoryUtil
							.create(searchContext);

					spGroupTypeBooleanQuery.addTerm("type", 0);
					spGroupTypeBooleanQuery.addTerm("type", 1);

					BooleanClause spGroupTypeBooleanClause = BooleanClauseFactoryUtil
							.create(searchContext, spGroupTypeBooleanQuery,
									BooleanClauseOccur.SHOULD.getName());
					booleanClauseList.add(spGroupTypeBooleanClause);
					
				}
				
//				if(MBMessage.class.getName().equalsIgnoreCase(indexerClassName)) {
//					long spGroupClassId = ClassNameLocalServiceUtil.getClassNameId(SPGroup.class);
//					BooleanQuery spGroupDiscussionBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
//					spGroupDiscussionBooleanQuery.addRequiredTerm("classNameId", spGroupClassId);
//					BooleanClause spGroupDiscussionBooleanClause = BooleanClauseFactoryUtil.create(
//							spGroupDiscussionBooleanQuery, BooleanClauseOccur.MUST.getName());
//					booleanClauseList.add(spGroupDiscussionBooleanClause);
//				}

				BooleanClause[] booleanClauses = new BooleanClause[booleanClauseList.size()];
				for (int i = 0; i < booleanClauseList.size(); i++) {
					booleanClauses[i] = booleanClauseList.get(i);
				}

				searchContext.setBooleanClauses(booleanClauses);
				Hits results;
				Indexer indexer = null;

				if (MBMessage.class.getName()
						.equalsIgnoreCase(indexerClassName)) {

					// use spgroup indexer instead of mbmessage indexer

					indexer = IndexerRegistryUtil.getIndexer(SPGroup.class
							.getName());
				} else {
					indexer = IndexerRegistryUtil.getIndexer(indexerClassName);
				}

				if (Validator.isNotNull(download)) {
				if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(),
						themeDisplay.getUserId())) {
					
						if (download.trim().equalsIgnoreCase("download")) {
							_log.info("results download");
							String downloadLocation = (String) paramsMap
									.get("downloadLocation");
							searchContext.setStart(-1);
							searchContext.setEnd(-1);
							results = indexer.search(searchContext);
							HashMap<String, String> generateResult = ASUtil
									.generateSearchReport(results,
											downloadLocation,themeDisplay);
							resultsMap.put("excelPath",
									generateResult.get("excelPath"));
						}
					}
				}else{

					searchContext.setStart(start);
					searchContext.setEnd(end);
					results = indexer.search(searchContext);
					count = results.getLength();
	
					if (BlogsEntry.class.getName().equalsIgnoreCase(
							indexerClassName)) {
						wrappers = searchBlogs(themeDisplay, paramsMap, results);
					} else if (SPJob.class.getName().equalsIgnoreCase(
							indexerClassName)) {
						wrappers = searchJobs(themeDisplay, paramsMap, results);
					} else if (CalendarBooking.class.getName().equalsIgnoreCase(
							indexerClassName)) {
						wrappers = searchEvents(themeDisplay, paramsMap, results);
						/**
						 * } else if
						 * (PortfolioGallery.class.getName().equalsIgnoreCase
						 * (indexerClassName)) { wrappers =
						 * searchGallerys(themeDisplay, paramsMap, results);
						 **/
					} else if (User.class.getName().equalsIgnoreCase(indexerClassName)) {
						wrappers = searchUserByProfileType(themeDisplay, paramsMap, results);
					}	else if (SocialProfile.class.getName().equalsIgnoreCase(indexerClassName)) {
						wrappers = searchIndividualProfiles(themeDisplay, paramsMap, results);
	//				} else if (CorporateProfile.class.getName().equalsIgnoreCase(indexerClassName)) {
	//					wrappers = searchCorporateProfiles(themeDisplay, paramsMap, results);
					} else if (SPAssetEntry.class.getName().equalsIgnoreCase(indexerClassName)) {
						wrappers = searchSPAssetEntries(themeDisplay, paramsMap, results);
					} else if (SPGroup.class.getName().equalsIgnoreCase(indexerClassName)) {
						wrappers = searchSPGroups(resourceRequest, themeDisplay, paramsMap, results);
					} else if (MBMessage.class.getName().equalsIgnoreCase(indexerClassName)) {
						wrappers = searchSPGroupDiscussions(resourceRequest, themeDisplay, paramsMap, results);
					}

				}
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}
		}

		resultsMap.put("count", count);
		resultsMap.put("wrappers", wrappers);
		return resultsMap;
	}

	public List<ASWrapper> searchBlogs(ThemeDisplay themeDisplay,
			Map<String, Object> paramsMap, Hits results) {
		List<ASWrapper> wrappers = new ArrayList<ASWrapper>(0);
		int titleMaxLength = (Integer) paramsMap.get("titleMaxLength");
		int contentMaxLength = (Integer) paramsMap.get("contentMaxLength");

		try {
			for (int i = 0; i < results.getDocs().length; i++) {
				Document doc = results.doc(i);
				long classPK = GetterUtil
						.getLong(doc.get(Field.ENTRY_CLASS_PK));
				String title = GetterUtil.getString(doc.get(Field.TITLE));
				String content = GetterUtil.getString(doc.get(Field.CONTENT));
				String contentHTML = GetterUtil.getString(doc.get(Field.DESCRIPTION));
				long userId = GetterUtil.getLong(doc.get(Field.USER_ID));
				String userName = GetterUtil
						.getString(doc.get(Field.USER_NAME));

				String urlTitle = GetterUtil.getString(doc.get("urlTitle"));
				Date modifiedDate = GetterUtil.getDate(
						doc.getDate(Field.MODIFIED_DATE),
						DateFormat.getDateInstance());
				String displayDate = ASUtil.getDiaplayDate(modifiedDate);
				String image = ASUtil.getBlogImageUrl(contentHTML);

				if (Validator.isNotNull(image)
						&& image.startsWith(themeDisplay.getPortalURL())
						|| image.startsWith(StringPool.FORWARD_SLASH)) {
					if (image.indexOf(StringPool.QUESTION) != -1) {
						image = image + "&imageThumbnail=2";
					} else {
						image = image + "?imageThumbnail=2";
					}
				}

				content = HtmlUtil.stripHtml(content.trim());

				if (Validator.isNotNull(title)
						&& title.length() > titleMaxLength) {
					title = title.substring(0, titleMaxLength) + "...";
				}

				if (Validator.isNotNull(content)
						&& content.length() > contentMaxLength) {
					content = content.substring(0, contentMaxLength) + "...";
				}

				String detailUrl = ASUtil.getBlogViewDetailUrl(portalURL,
						themeDisplay.getScopeGroupId(), urlTitle);

				try {
					List<AssetCategory> assetCategories = AssetCategoryLocalServiceUtil
							.getCategories(BlogsEntry.class.getName(), classPK);
					String channel = ListUtil.toString(assetCategories,
							AssetCategory.NAME_ACCESSOR);

					if (Validator.isNotNull(channel)
							&& !(channel.indexOf(StringPool.COMMA) != -1)) {
						detailUrl = detailUrl + "?channel=" + channel.trim();
					}
				} catch (SystemException e) {

					// do nothing

				}

				String profileUrl = ASUtil.getProfileViewDetailUrl(userId);
				wrappers.add(new ASWrapper(title, detailUrl, content, image,
						userName, profileUrl, modifiedDate, displayDate));
			}

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		return wrappers;
	}

	public List<ASWrapper> searchJobs(ThemeDisplay themeDisplay,
			Map<String, Object> paramsMap, Hits results) {
		List<ASWrapper> wrappers = new ArrayList<ASWrapper>(0);
		int titleMaxLength = (Integer) paramsMap.get("titleMaxLength");
		int contentMaxLength = (Integer) paramsMap.get("contentMaxLength");
		try {
			for (int i = 0; i < results.getDocs().length; i++) {
				Document doc = results.doc(i);
				String title = GetterUtil.getString(doc.get(Field.TITLE));
				String content = GetterUtil.getString(doc
						.get(Field.DESCRIPTION));
				long userId = GetterUtil.getLong(doc.get(Field.USER_ID));
				String userName = GetterUtil
						.getString(doc.get(Field.USER_NAME));
				long classPK = GetterUtil
						.getLong(doc.get(Field.ENTRY_CLASS_PK));
				Date modifiedDate = GetterUtil.getDate(
						doc.getDate(Field.MODIFIED_DATE),
						DateFormat.getDateInstance());

				String displayDate = ASUtil.getDiaplayDate(modifiedDate);
				String image = ASUtil.getJobsImageUrl(
						themeDisplay.getCompanyId(),
						themeDisplay.getScopeGroupId(),
						GetterUtil.getString(doc.get("jobsImageDocId")));
				content = HtmlUtil.stripHtml(content.trim());

				if (Validator.isNotNull(title)
						&& title.length() > titleMaxLength) {
					title = title.substring(0, titleMaxLength) + "...";
				}

				if (Validator.isNotNull(content)
						&& content.length() > contentMaxLength) {
					content = content.substring(0, contentMaxLength) + "...";
				}

				String detailUrl = ASUtil.getJobDetailViewUrl(portalURL,
						themeDisplay.getScopeGroupId(), classPK);
				String profileUrl = ASUtil.getProfileViewDetailUrl(userId);
				wrappers.add(new ASWrapper(title, detailUrl, content, image,
						userName, profileUrl, modifiedDate, displayDate));
			}

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		return wrappers;
	}

	public List<ASWrapper> searchEvents(ThemeDisplay themeDisplay,
			Map<String, Object> paramsMap, Hits results) {
		List<ASWrapper> wrappers = new ArrayList<ASWrapper>(0);
		int titleMaxLength = (Integer) paramsMap.get("titleMaxLength");
		int contentMaxLength = (Integer) paramsMap.get("contentMaxLength");
		String eventDetailPageName = (String) paramsMap
				.get("eventDetailPageName");
		try {
			for (int i = 0; i < results.getDocs().length; i++) {
				Document doc = results.doc(i);
				String title = GetterUtil.getString(doc.get(Field.TITLE));
				String content = GetterUtil.getString(doc
						.get(Field.DESCRIPTION));
				long userId = GetterUtil.getLong(doc.get(Field.USER_ID));
				String userName = GetterUtil
						.getString(doc.get(Field.USER_NAME));
				long classPK = GetterUtil
						.getLong(doc.get(Field.ENTRY_CLASS_PK));

				Date modifiedDate = GetterUtil.getDate(
						doc.getDate(Field.MODIFIED_DATE),
						DateFormat.getDateInstance());

				String displayDate = ASUtil.getDiaplayDate(modifiedDate);
				content = HtmlUtil.stripHtml(content.trim());

				if (Validator.isNotNull(title)
						&& title.length() > titleMaxLength) {
					title = title.substring(0, titleMaxLength) + "...";
				}

				if (Validator.isNotNull(content)
						&& content.length() > contentMaxLength) {
					content = content.substring(0, contentMaxLength) + "...";
				}

				String detailUrl = eventDetailPageName + "/-/event/view_event/"
						+ classPK + "?flagDetail=false";
				List<String> images = getEventsImageMap(
						themeDisplay.getScopeGroupId(), classPK);

				String image = images.size() > 0 ? images.get(0)
						: StringPool.BLANK;

				String profileUrl = ASUtil.getProfileViewDetailUrl(userId);
				wrappers.add(new ASWrapper(title, detailUrl, content, image,
						userName, profileUrl, modifiedDate, displayDate));
			}

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		return wrappers;
	}

	private List<String> getEventsImageMap(long respositoryId, long eventId) {
		long parentFolderId = 0;
		List<String> imageUrl = new ArrayList<String>();

		try {
			Folder folder = DLAppServiceUtil.getFolder(respositoryId, 0,
					SambaashConstants.EVENTS_IMAGE_DEFAULT_FOLDER);

			if (folder != null) {
				parentFolderId = folder.getFolderId();
			}

			Folder subFolder = DLAppServiceUtil.getFolder(respositoryId,
					parentFolderId, "Events_" + eventId);

			List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(
					respositoryId, subFolder.getFolderId());

			for (FileEntry file : fileEntries) {
				imageUrl.add("/documents/" + respositoryId + "/"
						+ subFolder.getFolderId() + "/" + file.getTitle());
			}

		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		return imageUrl;
	}

	public List<ASWrapper> searchIndividualProfiles(ThemeDisplay themeDisplay,
			Map<String, Object> paramsMap, Hits results) {
		List<ASWrapper> wrappers = new ArrayList<ASWrapper>(0);
		int contentMaxLength = (Integer) paramsMap.get("contentMaxLength");
		try {
			for (int i = 0; i < results.getDocs().length; i++) {
				Document doc = results.doc(i);
				String fullName = GetterUtil.getString(doc.get("fullName"));
				String screenName = GetterUtil.getString(doc.get("screenName"));
				String aboutMe = GetterUtil.getString(doc.get("about"));
				long portraitId = GetterUtil.getLong(doc.get("portraitId"));
				String userRegistrationStatus = GetterUtil.getString(doc
						.get("userRegistrationStatus"));
				int userStatus = GetterUtil.getInteger(doc.get(Field.STATUS));
				boolean active = REGISTRATION.USER_REGISTRATION_STATUS_ACTIVE
						.equalsIgnoreCase(userRegistrationStatus)
						&& userStatus == WorkflowConstants.STATUS_APPROVED;
				long userId = GetterUtil.getLong(doc.get(Field.USER_ID));
				Date modifiedDate = GetterUtil.getDate(
						doc.getDate(Field.MODIFIED_DATE),
						DateFormat.getDateInstance());

				String displayDate = ASUtil.getDiaplayDate(modifiedDate);
				aboutMe = HtmlUtil.stripHtml(aboutMe.trim());

				if (Validator.isNotNull(aboutMe)
						&& aboutMe.length() > contentMaxLength) {
					aboutMe = aboutMe.substring(0, contentMaxLength) + "...";
				}

				String profileUrl = ASUtil
						.getIndiProfileViewDetailUrl(screenName);
				String image = UserConstants.getPortraitURL(themeDisplay.getPathImage(), true, portraitId);//ASUtil.getIndividualsUserImageUrl(portraitId);
				wrappers.add(new ASWrapper(fullName, profileUrl, aboutMe,
						image, fullName, profileUrl, modifiedDate, displayDate,
						active, userId));
			}

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		return wrappers;
	}

	public List<ASWrapper> searchUserByProfileType(ThemeDisplay themeDisplay,
			Map<String, Object> paramsMap, Hits results) {
		List<ASWrapper> wrappers = new ArrayList<ASWrapper>(0);
		int contentMaxLength = (Integer) paramsMap.get("contentMaxLength");
		try {
			for (int i = 0; i < results.getDocs().length; i++) {
				Document doc = results.doc(i);
				String fullName = GetterUtil.getString(doc.get("fullName"));
				String screenName = GetterUtil.getString(doc.get("screenName"));
				long portraitId = GetterUtil.getLong(doc.get("portraitId"));
				int userStatus = GetterUtil.getInteger(doc.get(Field.STATUS));

				long userId = GetterUtil.getLong(doc.get(Field.USER_ID));
				Date modifiedDate = GetterUtil.getDate(
						doc.getDate(Field.MODIFIED_DATE),
						DateFormat.getDateInstance());

				String displayDate = ASUtil.getDiaplayDate(modifiedDate);
				String profileUrl = ASUtil
						.getIndiProfileViewDetailUrl(screenName);
				String image = ASUtil.getIndividualsUserImageUrl(portraitId);
				wrappers.add(new ASWrapper(fullName, profileUrl,
						StringPool.BLANK, image, fullName, profileUrl,
						modifiedDate, displayDate, Boolean.TRUE, userId));
			}

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		return wrappers;
	}

	public List<ASWrapper> searchCorporateProfiles(ThemeDisplay themeDisplay,
			Map<String, Object> paramsMap, Hits results) {
		List<ASWrapper> wrappers = new ArrayList<ASWrapper>(0);
		int contentMaxLength = (Integer) paramsMap.get("contentMaxLength");
		try {
			for (int i = 0; i < results.getDocs().length; i++) {
				Document doc = results.doc(i);
				String name = GetterUtil.getString(doc.get("name"));
				String screenName = GetterUtil.getString(doc
						.get("profileScreenName"));
				String aboutCompany = GetterUtil.getString(doc
						.get("aboutCompany"));
				Date modifiedDate = GetterUtil.getDate(
						doc.getDate(Field.MODIFIED_DATE),
						DateFormat.getDateInstance());

				long docId = GetterUtil.getLong(doc.get("docId"));

				String displayDate = ASUtil.getDiaplayDate(modifiedDate);
				aboutCompany = HtmlUtil.stripHtml(aboutCompany.trim());

				if (Validator.isNotNull(aboutCompany)
						&& aboutCompany.length() > contentMaxLength) {
					aboutCompany = aboutCompany.substring(0, contentMaxLength)
							+ "...";
				}

				String profileUrl = "";//ASUtil
						//.getCorpProfileViewDetailUrl(screenName);
				String image = ASUtil.getCorporateUserImageUrl(docId,
						themeDisplay.getScopeGroupId());

				wrappers.add(new ASWrapper(name, profileUrl, aboutCompany,
						image, name, profileUrl, modifiedDate, displayDate));
			}

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		return wrappers;
	}

	public List<ASWrapper> searchSPAssetEntries(ThemeDisplay themeDisplay,
			Map<String, Object> paramsMap, Hits results) {
		long scopeGroupId = themeDisplay.getScopeGroupId();
		List<ASWrapper> wrappers = new ArrayList<ASWrapper>(0);
		int titleMaxLength = (Integer) paramsMap.get("titleMaxLength");
		int contentMaxLength = (Integer) paramsMap.get("contentMaxLength");
		try {
			for (int i = 0; i < results.getDocs().length; i++) {
				Document doc = results.doc(i);
				String title = GetterUtil.getString(doc.get(Field.TITLE));
				String description = GetterUtil.getString(doc
						.get(Field.DESCRIPTION));

				if (Validator.isNull(description)) {
					description = GetterUtil.getString(doc.get(Field.CONTENT));
				}

				long userId = GetterUtil.getLong(doc.get(Field.USER_ID));
				String userName = GetterUtil
						.getString(doc.get(Field.USER_NAME));

				String assetEntryId = GetterUtil.getString(doc
						.get("spAssetEntryId"));
				Date modifiedDate = GetterUtil.getDate(
						doc.getDate(Field.MODIFIED_DATE),
						DateFormat.getDateInstance());

				long coverFileEntryId = GetterUtil.getLong(doc
						.get("spCoverFileEntryId"));

				long spAssetTypeId = GetterUtil.getLong(doc
						.get("spAssetTypeId"));
				String detailPageName = StringPool.BLANK;
				try {
					SPAssetType spAssetType = SPAssetTypeLocalServiceUtil
							.getSPAssetType(spAssetTypeId);

					if (spAssetType != null) {
						detailPageName = spAssetType.getSpAssetTypeDetailUrl();
					}
				} catch (NoSuchTypeException nste) {

					// do nothing

				}

				String displayDate = ASUtil.getDiaplayDate(modifiedDate);
				FileEntry coverFileEntry = null;
				try {
					coverFileEntry = DLAppLocalServiceUtil
							.getFileEntry(coverFileEntryId);
				} catch (NoSuchFileEntryException nsfee) {

					// do nothing

				}

				String image = StringPool.BLANK;

				if (coverFileEntry != null) {
					image = ASUtil.getSPAssetEntryThumbnailURL(themeDisplay,
							coverFileEntry);
				}

				title = StringUtil.shorten(title, titleMaxLength);
				description = StringUtil.shorten(description, contentMaxLength);
				String detailUrl = ASUtil.getSPAssetViewDetailUrl(portalURL,
						scopeGroupId, assetEntryId, detailPageName);
				String profileUrl = ASUtil.getProfileViewDetailUrl(userId);
				wrappers.add(new ASWrapper(title, detailUrl, description,
						image, userName, profileUrl, modifiedDate, displayDate));
			}

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		return wrappers;
	}

	private List<Long> listUserGroupMembership(ThemeDisplay themeDisplay) {
		List<Long> membershipList = new ArrayList<Long>();
		try {
			for (SPGroupUser u : SPGroupUserLocalServiceUtil.findByUserId(themeDisplay.getUserId()) ) {
				membershipList.add(u.getSpGroupId());
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		return membershipList;
	}
	
	public List<ASWrapper> searchSPGroups(ResourceRequest resourceRequest,
			ThemeDisplay themeDisplay, Map<String, Object> paramsMap,
			Hits results) {
		List<ASWrapper> wrappers = new ArrayList<ASWrapper>(0);
		int titleMaxLength = (Integer) paramsMap.get("titleMaxLength");
		int contentMaxLength = (Integer) paramsMap.get("contentMaxLength");
		String groupDetailPageName = (String) paramsMap
				.get("groupDetailPageName");
		List<Long> membershipList = listUserGroupMembership(themeDisplay);
		try {
			for (int i = 0; i < results.getDocs().length; i++) {
				Document doc = results.doc(i);
				long spGroupId = GetterUtil.getLong(doc
						.get(Field.ENTRY_CLASS_PK));
				long type = GetterUtil.getLong(doc
						.get(Field.TYPE));
				if (type==2 && !membershipList.contains(spGroupId)) {
					continue;	// skip if ADMIN group and user is not a member
				}
				String title = GetterUtil.getString(doc.get(Field.TITLE));
				String description = GetterUtil.getString(doc
						.get(Field.DESCRIPTION));
				long userId = GetterUtil.getLong(doc.get(Field.USER_ID));
				String userName = GetterUtil
						.getString(doc.get(Field.USER_NAME));

				String urlTitle = GetterUtil.getString(doc.get("urlTitle"));
				String imageId = GetterUtil.getString(doc.get("imageId"));

				Date modifiedDate = GetterUtil.getDate(
						doc.getDate(Field.MODIFIED_DATE),
						DateFormat.getDateInstance());

				String displayDate = ASUtil.getDiaplayDate(modifiedDate);

				title = StringUtil.shorten(title, titleMaxLength);
				description = StringUtil.shorten(description, contentMaxLength);

				String spGroupDetailURL = StringPool.BLANK;
				try {
					Layout spGroupDetailLayout = LayoutLocalServiceUtil
							.getFriendlyURLLayout(
									themeDisplay.getScopeGroupId(), false, "/"
											+ groupDetailPageName);
					long spGroupDetailPlid = spGroupDetailLayout.getPlid();

					PortletURL spGroupDetailPortletURL = PortletURLFactoryUtil
							.create(resourceRequest,
									"SPGroupDetail_WAR_SPGroupportlet",
									spGroupDetailPlid,
									PortletRequest.RENDER_PHASE);
					spGroupDetailPortletURL
							.setWindowState(javax.portlet.WindowState.NORMAL);
					spGroupDetailPortletURL
							.setPortletMode(javax.portlet.PortletMode.VIEW);
					spGroupDetailPortletURL.setParameter("struts_action",
							"/groups/view_entry");
					spGroupDetailPortletURL.setParameter("urlTitle", urlTitle);
					spGroupDetailPortletURL.setParameter("spGroupId",
							String.valueOf(spGroupId));
					spGroupDetailURL = spGroupDetailPortletURL.toString();
				} catch (com.liferay.portal.NoSuchLayoutException e) {

					_log.error("Group detail page not set " + e.getMessage());

				}

				String profileUrl = ASUtil.getProfileViewDetailUrl(userId);
				Date now = new Date();
				String image = "/image/image_gallery?img_id=" + imageId + "&="
						+ now.getTime();
				wrappers.add(new ASWrapper(title, spGroupDetailURL,
						description, image, userName, profileUrl, modifiedDate,
						displayDate));
			}

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		return wrappers;
	}

	public List<ASWrapper> searchSPGroupDiscussions(
			ResourceRequest resourceRequest, ThemeDisplay themeDisplay,
			Map<String, Object> paramsMap, Hits results) {
		List<ASWrapper> wrappers = new ArrayList<ASWrapper>(0);
		int titleMaxLength = (Integer) paramsMap.get("titleMaxLength");
		int contentMaxLength = (Integer) paramsMap.get("contentMaxLength");
		String groupDetailPageName = (String) paramsMap
				.get("groupDetailPageName");
		String groupDiscussionDetailPageName = (String) paramsMap
				.get("groupDiscussionDetailPageName");
		try {
			for (int i = 0; i < results.getDocs().length; i++) {
				Document doc = results.doc(i);
				long spGroupId = GetterUtil.getLong(doc
						.get(Field.ENTRY_CLASS_PK));
				String title = GetterUtil.getString(doc.get(Field.TITLE));
				String description = GetterUtil.getString(doc
						.get(Field.DESCRIPTION));
				long userId = GetterUtil.getLong(doc.get(Field.USER_ID));
				String userName = GetterUtil
						.getString(doc.get(Field.USER_NAME));

				String urlTitle = GetterUtil.getString(doc.get("urlTitle"));
				String imageId = GetterUtil.getString(doc.get("imageId"));

				Date modifiedDate = GetterUtil.getDate(
						doc.getDate(Field.MODIFIED_DATE),
						DateFormat.getDateInstance());

				String displayDate = ASUtil.getDiaplayDate(modifiedDate);

				title = StringUtil.shorten(title, titleMaxLength);
				description = StringUtil.shorten(description, contentMaxLength);
				_log.debug(" group name "
						+ title
						+ " category of groups "
						+ GetterUtil.getLong(doc.get(Field.ASSET_CATEGORY_IDS))
						+ " names "
						+ GetterUtil.getLong(doc
								.get(Field.ASSET_CATEGORY_NAMES)));
				String spGroupDetailURL = StringPool.BLANK;
				try {
					Layout spGroupDetailLayout = LayoutLocalServiceUtil
							.getFriendlyURLLayout(
									themeDisplay.getScopeGroupId(), false, "/"
											+ groupDetailPageName);
					long spGroupDetailPlid = spGroupDetailLayout.getPlid();

					PortletURL spGroupDetailPortletURL = PortletURLFactoryUtil
							.create(resourceRequest,
									"SPGroupDetail_WAR_SPGroupportlet",
									spGroupDetailPlid,
									PortletRequest.RENDER_PHASE);
					spGroupDetailPortletURL
							.setWindowState(javax.portlet.WindowState.NORMAL);
					spGroupDetailPortletURL
							.setPortletMode(javax.portlet.PortletMode.VIEW);
					spGroupDetailPortletURL.setParameter("struts_action",
							"/groups/view_entry");
					spGroupDetailPortletURL.setParameter("urlTitle", urlTitle);
					spGroupDetailPortletURL.setParameter("spGroupId",
							String.valueOf(spGroupId));
					spGroupDetailURL = spGroupDetailPortletURL.toString();
				} catch (com.liferay.portal.NoSuchLayoutException e) {

					// do nothing

				}

				String profileUrl = ASUtil.getProfileViewDetailUrl(userId);
				Date now = new Date();
				String image = "/image/image_gallery?img_id=" + imageId + "&=" + now.getTime();
				
//				List<SPDiscussionWrapper> spDiscussionWrappers = getSPGroupDiscussionList(resourceRequest, themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), 
//						spGroupId, urlTitle, 0, 4, titleMaxLength, contentMaxLength, groupDiscussionDetailPageName);
				
				List<SPDiscussionWrapper> spDiscussionWrappers = getSPGroupDiscussionList(resourceRequest, themeDisplay, spGroupId, 
						titleMaxLength, contentMaxLength, groupDiscussionDetailPageName, urlTitle);
				
				wrappers.add(new ASWrapper(title, spGroupDetailURL, description, image, userName, profileUrl,
						modifiedDate, displayDate, spDiscussionWrappers));
			}

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		return wrappers;
	}
	
	
	private List<SPDiscussionWrapper> getSPGroupDiscussionList(ResourceRequest resourceRequest, ThemeDisplay themeDisplay, long classPK, int titleMaxLength, int contentMaxLength, 
			String groupDiscussionDetailPageName, String urlTitle) throws Exception {
		long scopeGroupId = themeDisplay.getScopeGroupId();
		long classNameId = ClassNameLocalServiceUtil.getClassNameId(SPGroup.class.getName());

		String threadView = PropsUtil.get(PropsKeys.DISCUSSION_THREAD_VIEW);

		MBMessageDisplay messageDisplay =
			MBMessageLocalServiceUtil.getDiscussionMessageDisplay(
				themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), SPGroup.class.getName(), classPK,
				WorkflowConstants.STATUS_ANY, threadView);

		MBThread thread = messageDisplay.getThread();
		MBTreeWalker treeWalker = messageDisplay.getTreeWalker();
		MBMessage rootMessage = null;

		if (treeWalker != null) {
			rootMessage = treeWalker.getRoot();
		}
		else {
			rootMessage = MBMessageLocalServiceUtil.getMessage(thread.getRootMessageId());
		}
		DynamicQuery dynamicQuery =
			DynamicQueryFactoryUtil.forClass(MBMessage.class, PortalClassLoaderUtil.getClassLoader());
		dynamicQuery.add(PropertyFactoryUtil.forName("messageId").ne(new Long(rootMessage.getRootMessageId())));
		dynamicQuery.add(PropertyFactoryUtil.forName("parentMessageId").eq(new Long(rootMessage.getRootMessageId())));
		dynamicQuery.add(PropertyFactoryUtil.forName("classPK").eq(new Long(classPK)));
		dynamicQuery.add(PropertyFactoryUtil.forName("classNameId").eq(new Long(classNameId)));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));

		@SuppressWarnings("unchecked")
		List<MBMessage> parentComments = MBMessageLocalServiceUtil
				.dynamicQuery(dynamicQuery, 0, 4);

		List<SPDiscussionWrapper> spDiscussionWrappers = new ArrayList<SPDiscussionWrapper>();

		for (MBMessage parentComment : parentComments) {
			String title = parentComment.getSubject();
			String description = parentComment.getBody();
			title = StringUtil.shorten(title, titleMaxLength);
			description = StringUtil.shorten(description, contentMaxLength);

			String spGroupDiscussionDetailURL = StringPool.BLANK;
			Layout spGroupDiscussionDetailLayout = null;
			try {
				spGroupDiscussionDetailLayout = LayoutLocalServiceUtil
						.getFriendlyURLLayout(scopeGroupId, false, "/"
								+ groupDiscussionDetailPageName);
			} catch (com.liferay.portal.NoSuchLayoutException e) {

				// do nothing

			}

			if (spGroupDiscussionDetailLayout != null) {
				long viewSPGroupDiscussionPlid = spGroupDiscussionDetailLayout
						.getPlid();

				PortletURL spGroupDiscussionPortletURL = com.liferay.portlet.PortletURLFactoryUtil
						.create(resourceRequest,
								"SPGroupDiscussionDetail_WAR_SPGroupportlet",
								viewSPGroupDiscussionPlid,
								javax.portlet.PortletRequest.RENDER_PHASE);
				spGroupDiscussionPortletURL
						.setWindowState(javax.portlet.WindowState.NORMAL);
				spGroupDiscussionPortletURL
						.setPortletMode(javax.portlet.PortletMode.VIEW);
				spGroupDiscussionPortletURL.setParameter("struts_action",
						"/discussions/view_discussion");
				spGroupDiscussionPortletURL.setParameter("urlTitle", urlTitle);
				spGroupDiscussionPortletURL.setParameter("spGroupId",
						String.valueOf(classPK));
				spGroupDiscussionPortletURL.setParameter("discussionId",
						String.valueOf(parentComment.getMessageId()));
				spGroupDiscussionDetailURL = spGroupDiscussionPortletURL
						.toString();
			}

			SPDiscussionWrapper spDiscussionWrapper = new SPDiscussionWrapper();
			spDiscussionWrapper.setContent(description);
			spDiscussionWrapper.setDetailUrl(spGroupDiscussionDetailURL);
			spDiscussionWrapper.setTitle(title);
			spDiscussionWrappers.add(spDiscussionWrapper);
		}

		return spDiscussionWrappers;
	}
	
	private List<Portlet> getEnabledOpenSearchPortlets(ThemeDisplay themeDisplay, ServletContext servletContext,
			Locale defaultLocale) throws SystemException {
		boolean includeSystemPortlets = false;
		List<Portlet> portlets = PortletLocalServiceUtil.getPortlets(
				themeDisplay.getCompanyId(), includeSystemPortlets, false);
		portlets = ListUtil.sort(portlets, new PortletTitleComparator(
				servletContext, defaultLocale));
		Iterator<Portlet> itr = portlets.iterator();
		while (itr.hasNext()) {
			Portlet portlet = (Portlet) itr.next();

			if (Validator.isNull(portlet.getOpenSearchClass())) {
				itr.remove();
				continue;
			}

			OpenSearch openSearch = portlet.getOpenSearchInstance();

			if (!openSearch.isEnabled()) {
				itr.remove();
				continue;
			}
		}

		return portlets;
	}

	private List<SPAssetType> getAssetTypes() {
		List<SPAssetType> assetTypes = new ArrayList<SPAssetType>();
		try {
			assetTypes = SPAssetTypeLocalServiceUtil.getSPAssetTypes(-1, -1);
		} catch (SystemException e) {
			_log.error(e.getMessage(), e);
		}

		return assetTypes;
	}

	private String portalURL = StringPool.BLANK;

	private static final String _DATE_FORMAT_PATTERN = PropsUtil
			.get("index.date.format.pattern");

	private static Log _log = LogFactoryUtil.getLog(AdvancedSearchAction.class);

	private final String _DEFAULT_LISTING_STYLE = "horizontal";

}
