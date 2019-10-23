package com.sambaash.platform.portlet.webcontentsearch.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.search.StringQueryFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.portlet.webcontentsearch.wrapper.WebContentSearchFilterWrapper;
import com.sambaash.platform.portlet.webcontentsearch.wrapper.WebContentSearchResultsWrapper;
import com.sambaash.platform.util.CookieUtil;

/**
 * Portlet implementation class WebcontentSearchAction
 */
public class WebcontentSearchAction extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(WebcontentSearchAction.class);

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		PortletPreferences preferences = renderRequest.getPreferences();
		HttpServletRequest req = PortalUtil.getHttpServletRequest(renderRequest);
		HttpServletRequest request = PortalUtil.getOriginalServletRequest(req);
		String searchFilterCriteriasList = preferences.getValue("searchFilterCriterias", "");
		String totalDisplayResults = preferences.getValue("totalDisplayResults", "10");
		int totalDisplayResultsN = 0;
		if (Validator.isNotNull(totalDisplayResults)) {
			totalDisplayResultsN = Integer.parseInt(totalDisplayResults);
		}
		String noOfCategories = preferences.getValue("noOfCategories", "7");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		boolean showLoadmore = false;
		boolean searchDefaultResult = true;
		List<WebContentSearchFilterWrapper> searchFilterWrappers = null;
		String selectedMainVocName = "results";

		String catg1 = request.getParameter("cat1");
		String catg2 = request.getParameter("cat2");
		String catg3 = request.getParameter("cat3");
		String catg4 = request.getParameter("cat4");

		String languageId = (String) request.getAttribute(I18N_LANGUAGE_ID);
		if (Validator.isNull(languageId)) {
			languageId = CookieUtil.get(request, "GUEST_LANGUAGE_ID");
		}

		if (Validator.isNull(catg3) && Validator.isNotNull(languageId)) {
			Locale locale = LocaleUtil.fromLanguageId(languageId);
			catg3 = locale.getLanguage(); 
			// set catg3 to null so that all entries are selected
			if (catg3.equalsIgnoreCase("en"))
				catg3 = null;
		}

		String urlParameters = catg1 + "#" + catg2 + "#" + catg3 + "#" + catg4;
		if (urlParameters.length() > 19) {
			searchDefaultResult = false;
		}
		_log.debug("urlParameters " + urlParameters.length() + " &&&& " + urlParameters);

		try {
			searchFilterWrappers = getWebContentSearchFilterWrapper(searchFilterCriteriasList, urlParameters,
					renderRequest);
			renderRequest.setAttribute("searchFilterWrappers", searchFilterWrappers);
			renderRequest.setAttribute("totalDisplayResults", totalDisplayResults);
			renderRequest.setAttribute("showLoadmore", showLoadmore);
			selectedMainVocName = (String) renderRequest.getAttribute("selectedMainVocName");

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		String searchFilterCriteriasArray[] = searchFilterCriteriasList.split("&&");
		String[] searchFilterCriterias = searchFilterCriteriasArray[1].split(",");
		String query = buildSearchQueryByUrlParamaeter(catg1, catg2, catg3, catg4);
		List<WebContentSearchResultsWrapper> webContentSearchResultsWrapperList = new ArrayList<WebContentSearchResultsWrapper>();

		_log.debug("url view query " + query);
		if (Validator.isNotNull(query)) {
			Hits results = getSearchResults(query, themeDisplay, 0, totalDisplayResultsN);
			_log.debug("results " + results.getLength());
			showLoadmore = getSearchResultsCount(query, themeDisplay, 0, totalDisplayResultsN);
			renderRequest.setAttribute("showLoadmore", showLoadmore);
			webContentSearchResultsWrapperList = getResultWrapper(results, searchFilterCriterias[0]);
			String emptyResultMsg = "There are no matching " + selectedMainVocName
					+ " under your selection. Please modify your search or feel free to browse all "
					+ selectedMainVocName + ".";
			if (!webContentSearchResultsWrapperList.isEmpty()) {
				renderRequest.setAttribute("webContentSearchResultsWrapperList", webContentSearchResultsWrapperList);
				renderRequest.setAttribute("emptyResultMsg", "");
			} else {
				renderRequest.setAttribute("emptyResultMsg", emptyResultMsg);
			}
		}

		_log.debug("results view jsp " + webContentSearchResultsWrapperList);

		renderRequest.setAttribute("searchDefaultResult", searchDefaultResult);
		renderRequest.setAttribute("noOfCategories", noOfCategories);
		preferences.setValue("searchFilterWrappers", searchFilterWrappers.toString());
		preferences.setValue("urlParameterQuery", query);
		preferences.store();
		_log.debug("searchDefaultResult " + searchDefaultResult);
		super.doView(renderRequest, renderResponse);
	}

	private String buildSearchQueryByUrlParamaeter(String catg1, String catg2, String catg3, String catg4) {

		String query1 = getQueryByCategoryName(catg1);
		String query2 = getQueryByCategoryName(catg2);
		String query3 = getQueryByCategoryName(catg3);
		String query4 = getQueryByCategoryName(catg4);
		String mainQuery = StringPool.BLANK;

		_log.debug("catg1 buildSearchQueryByUrlParamaeter " + catg1 + " attribute " + catg1);

		if (Validator.isNotNull(query1)) {
			mainQuery = query1;
		}

		if (Validator.isNotNull(query2)) {
			if (Validator.isNull(mainQuery)) {
				mainQuery = query1;
			} else {
				mainQuery = mainQuery + "  AND " + query1;
			}
		}

		if (Validator.isNotNull(query3)) {
			if (Validator.isNull(mainQuery)) {
				mainQuery = query3;
			} else {
				mainQuery = mainQuery + "  AND " + query3;
			}
		}

		if (Validator.isNotNull(query4)) {
			if (Validator.isNull(mainQuery)) {
				mainQuery = query4;
			} else {
				mainQuery = mainQuery + "  AND " + query4;
			}
		}
		_log.debug("mainQuery " + mainQuery);
		return mainQuery;

	}

	private String getQueryByCategoryName(String catg1) {

		String searchQuery = StringPool.BLANK;
		String query = StringPool.BLANK;

		if (Validator.isNotNull(catg1)) {
			DynamicQuery dQuery = DynamicQueryFactoryUtil.forClass(AssetCategory.class,
					PortalClassLoaderUtil.getClassLoader());
			dQuery.add(RestrictionsFactoryUtil.ilike("name", "%" + catg1 + "%"));

			try {
				@SuppressWarnings("unchecked")
				List<AssetCategory> assetCategories = AssetCategoryLocalServiceUtil.dynamicQuery(dQuery);
				for (AssetCategory aCatg : assetCategories) {
					if (Validator.isNull(searchQuery)) {
						searchQuery = String.valueOf(aCatg.getCategoryId());
					} else {
						searchQuery = searchQuery + " " + String.valueOf(aCatg.getCategoryId());
					}
				}
			} catch (SystemException e) {
				_log.error(e.getMessage());
			}
		}
		if (Validator.isNotNull(searchQuery)) {
			query = "( assetCategoryIds:(" + searchQuery + "))";
		}
		return query;
	}

	private List<WebContentSearchFilterWrapper> getWebContentSearchFilterWrapper(String searchFilterCriteriasList,
			String urlParameters, RenderRequest renderRequest) throws PortalException, SystemException {
		List<WebContentSearchFilterWrapper> serachFilterWrappersList = new ArrayList<WebContentSearchFilterWrapper>();
		String[] urlParamArray = urlParameters.split("#");
		String[] searchFilterCriteriasArray = searchFilterCriteriasList.split("&&");
		String catgName = StringPool.BLANK;
		String catgDesc = StringPool.BLANK;
		String catgId = StringPool.BLANK;
		renderRequest.setAttribute("selectedMainCategoryName", "");
		renderRequest.setAttribute("selectedMainCategoryDesc", "");

		for (int i = 1; i < searchFilterCriteriasArray.length; i++) {
			if (searchFilterCriteriasArray[i].contains(",")) {
				String[] searchFilterCriterias = searchFilterCriteriasArray[i].split(",");
				try {
					if (searchFilterCriterias.length > 1) {
						List<AssetCategory> asstCatg = getInterestCategories(Long.parseLong(searchFilterCriterias[0]));
						if (i < 4) {
							for (AssetCategory aCatg : asstCatg) {
								if (aCatg.getName().equalsIgnoreCase(urlParamArray[i - 1])) {
									catgName = aCatg.getName();
									catgDesc = aCatg.getDescription();
									String url = StringPool.BLANK;
									if (catgDesc.contains("#link#")) {
										String[] splitDesc = catgDesc.split("#link#");
										catgDesc = splitDesc[0].trim();
										int e = splitDesc[1].indexOf("</Description>");
										url = splitDesc[1].substring(0, e).trim();
									}
									if (i == 1) {
										renderRequest.setAttribute("selectedMainCategoryName", catgName);
										renderRequest.setAttribute("selectedMainCategoryDesc", catgDesc);
										renderRequest.setAttribute("selectedMainCategoryUrl", url);
									}
									catgId = String.valueOf(aCatg.getCategoryId());
								}
							}
						}
						AssetVocabulary assetVoc = AssetVocabularyLocalServiceUtil.getAssetVocabulary(Long
								.parseLong(searchFilterCriterias[0]));
						String vocabularyName = assetVoc.getName();
						if (i == 1) {
							renderRequest.setAttribute("selectedMainVocName", vocabularyName);
						}
						WebContentSearchFilterWrapper serachFilterWrappers = new WebContentSearchFilterWrapper(
								asstCatg, searchFilterCriterias[1], searchFilterCriterias[0], vocabularyName, catgName,
								catgDesc, catgId);
						serachFilterWrappersList.add(serachFilterWrappers);
					}
				} catch (NumberFormatException | SystemException e) {
					_log.error(e.getMessage());
				}
			}
		}

		return serachFilterWrappersList;
	}

	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		PortletPreferences preferences = renderRequest.getPreferences();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String searchFilterWrappers = preferences.getValue("searchFilterCriterias", "");
		String totalDisplayResults = preferences.getValue("totalDisplayResults", "10");
		String noOfCategories = preferences.getValue("noOfCategories", "7");
		renderRequest.setAttribute("totalDisplayResults", totalDisplayResults);
		if (Validator.isNotNull(searchFilterWrappers)) {
			renderRequest.setAttribute("isSearchFiltersSet", "true");
			renderRequest.setAttribute("searchFilterWrappers", searchFilterWrappers);
		} else {
			renderRequest.setAttribute("isSearchFiltersSet", "false");
			renderRequest.setAttribute("searchFilterWrappers", "");
		}
		try {
			renderRequest.setAttribute("assetVocabularies", getAssetVocabularies(themeDisplay.getScopeGroupId()));
		} catch (SystemException e) {
			_log.error("Errro getting Asset vocabularies " + e.getMessage());
		} catch (PortalException e) {
			_log.error("Errro getting Asset vocabularies " + e.getMessage());
		}
		renderRequest.setAttribute("noOfCategories", noOfCategories);
		super.doEdit(renderRequest, renderResponse);

	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException {
		super.processAction(actionRequest, actionResponse);
	}

	public AssetVocabulary addAssetVocabulary(long userId, String title, ActionRequest actionRequest)
			throws PortalException, SystemException {

		Map<Locale, String> titleMap = new HashMap<Locale, String>();
		titleMap.put(Locale.US, title);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(AssetVocabulary.class.getName(),
				actionRequest);
		return AssetVocabularyLocalServiceUtil.addVocabulary(userId, title, titleMap, null, null, serviceContext);
	}

	public AssetCategory addAssetCatagories(long userId, String title, long vocabularyId, ActionRequest actionRequest)
			throws PortalException, SystemException {

		Map<Locale, String> titleMap = new HashMap<Locale, String>();
		titleMap.put(Locale.US, title);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(AssetCategory.class.getName(), actionRequest);
		return AssetCategoryLocalServiceUtil.addCategory(userId, 0, titleMap, null, vocabularyId, null, serviceContext);
	}

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {
		PortletPreferences preferences = request.getPreferences();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(req);
		String action = request.getParameter("action");
		String totalDisplayResults = preferences.getValue("totalDisplayResults", "10");
		String pagination = request.getParameter("pagination");
		String query = "";// preferences.getValue("urlParameterQuery", " ");
		int paginationN = 0;
		int totalDisplayResultsN = 10;
		if (Validator.isNotNull(pagination)) {
			paginationN = Integer.parseInt(pagination);
		}
		if (Validator.isNotNull(totalDisplayResults)) {
			totalDisplayResultsN = Integer.parseInt(totalDisplayResults);
		}

		if (Constants.EDIT.equalsIgnoreCase(action)) {
			String currentUrl = PortalUtil.getCurrentURL(httpRequest);
			if (currentUrl.contains("p_p_mode=edit")) {
				currentUrl = currentUrl.replace("p_p_mode=edit&p_p_resource_id=&p_p_cacheability=cacheLevelPage",
						"p_p_mode=view");
				currentUrl = themeDisplay.getPortalURL() + currentUrl;
			}
			if (currentUrl.contains("p_p_lifecycle=2")) {
				currentUrl = currentUrl.replace("p_p_lifecycle=2", "p_p_lifecycle=0");
			}
			String searchFilterCriteriasList = request.getParameter("searchFilterCriterias");
			String noOfCatg = request.getParameter("noOfCategories");
			String totalDResults = request.getParameter("totalDisplayResults");
			preferences.setValue("searchFilterCriterias", searchFilterCriteriasList);
			preferences.setValue("totalDisplayResults", totalDResults);
			preferences.setValue("noOfCategories", noOfCatg);
			preferences.store();
			response.getWriter().write(currentUrl);
		} else if ("search".equalsIgnoreCase(action)) {
			String selectedCategories = request.getParameter("selectedCategories");
			String searchText = request.getParameter("searchText");

			String singleMainCatg = request.getParameter("singleMainCatg");
			String mainVocId = singleMainCatg;
			try {
				mainVocId = String.valueOf(AssetCategoryLocalServiceUtil.getAssetCategory(
						Long.parseLong(singleMainCatg)).getVocabularyId());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				_log.error(e.getMessage());
			} catch (PortalException e) {
				_log.error(e.getMessage());
			} catch (SystemException e) {
				_log.error(e.getMessage());
			}
			String[] selCatg = selectedCategories.split("&&");
			String fSearchQuery = searchWebContent(selCatg, themeDisplay, paginationN, totalDisplayResultsN,
					searchText, query);
			Hits results = getSearchResults(fSearchQuery, themeDisplay, paginationN, totalDisplayResultsN);
			boolean showLoadmore = getSearchResultsCount(fSearchQuery, themeDisplay, paginationN, totalDisplayResultsN);
			String resultHtml = buildResultAsHTml(results, singleMainCatg, showLoadmore, mainVocId);
			response.getWriter().write(resultHtml);
		} else if ("UrlParameterSearch".equalsIgnoreCase(action)) {
			String searchText = request.getParameter("searchText");
			String singleMainCatg = request.getParameter("singleMainCatg");
			_log.debug("url query search " + query);

			if (Validator.isNotNull(searchText)) {
				if (Validator.isNull(query)) {
					query = searchText;
				} else {
					query = query + "  AND (content:" + searchText + ")";
				}
			}
			_log.debug("url query search with text " + query);
			Hits results = null;
			boolean showLoadmore = false;
			if (Validator.isNotNull(query)) {
				results = getSearchResults(query, themeDisplay, paginationN, totalDisplayResultsN);
				showLoadmore = getSearchResultsCount(query, themeDisplay, paginationN, totalDisplayResultsN);
			}

			String resultHtml = buildResultAsHTml(results, singleMainCatg, showLoadmore, singleMainCatg);
			response.getWriter().write(resultHtml);
		}

		super.serveResource(request, response);

	}

	private String buildResultAsHTml(Hits results, String singleMainCatg, boolean showLoadmore, String mainVocId) {
		List<WebContentSearchResultsWrapper> webContentSearchResultsWrapperList = new ArrayList<WebContentSearchResultsWrapper>();
		webContentSearchResultsWrapperList = getResultWrapper(results, mainVocId);
		StringBuffer sb = new StringBuffer();
		JSONArray items = JSONFactoryUtil.createJSONArray();
		if (!webContentSearchResultsWrapperList.isEmpty()) {
			JSONObject item = JSONFactoryUtil.createJSONObject();
			for (WebContentSearchResultsWrapper webContentSearchResultsWrapper : webContentSearchResultsWrapperList) {
				sb.append("<div class=\"search-stream-mosaic-block-content block\">");
				sb.append("<div class=\"wcResult-stream-item block aui-helper-clearfix\">");
				sb.append("<div class=\"wcResult-image align-top relative overflow-hidden\">");
				sb.append("<a class='block' href=\"" + webContentSearchResultsWrapper.getLink() + "\" title=\""
						+ webContentSearchResultsWrapper.getTitle() + "\">");
				sb.append("<img class='' src=\"" + webContentSearchResultsWrapper.getImageUrl() + "\" title=\" "
						+ webContentSearchResultsWrapper.getTitle() + "\" alt=\"" + webContentSearchResultsWrapper.getTitle() + "\">");
				sb.append("</a>");
				sb.append("</div>");
				sb.append("<div class=\"wcResult-body align-top relative\">");
				sb.append("<div class=\"wcResult-header\">");
				sb.append("<a class=\"wcResult-title link\" href=\"" + webContentSearchResultsWrapper.getLink()
						+ "\" title=\"" + webContentSearchResultsWrapper.getTitle() + "\">");
				sb.append("" + webContentSearchResultsWrapper.getTitle() + "");
				sb.append("</a>");
				sb.append("<div class=\"wcResult-provider text-right\">");
				sb.append("<img alt=\"Logo\" class=\"wcResult-logo block\" src=\"" + webContentSearchResultsWrapper.getLogo()
						+ "\">");
				sb.append("<div class=\"wcResult-type block  type-" + webContentSearchResultsWrapper.getType() + "\">");
				sb.append("" + webContentSearchResultsWrapper.getType() + "");
				sb.append("</div>");
				sb.append("</div>");
				sb.append("</div>");
				sb.append("<div class=\"wcResult-desc\">");
				sb.append("" + webContentSearchResultsWrapper.getDescription() + "");
				sb.append("</div>");
				sb.append("<div class='wcResult-details font-none block'>");
				if (Validator.isNotNull(webContentSearchResultsWrapper.getDuration())) {
					sb.append("<div class=\"wcResult-duration inline-block\">");
					sb.append("" + webContentSearchResultsWrapper.getDuration() + "");
					sb.append("<span class=\"detail-label\">");
					sb.append("" + webContentSearchResultsWrapper.getDurationType() + "");
					sb.append("</span>");
					sb.append("</div>");
				}
				if (Validator.isNotNull(webContentSearchResultsWrapper.getSize())) {
					sb.append("<div class=\"wcResult-size inline-block\">");
					sb.append("" + webContentSearchResultsWrapper.getSize() + "");
					sb.append("<span class=\"detail-label\">");
					sb.append("modules");
					sb.append("</span>");
					sb.append("</div>");
				}
				sb.append("<div class=\"wcResult-splz inline-block\">");
				sb.append("" + webContentSearchResultsWrapper.getSpecialization() + "");
				sb.append("</div>");

				sb.append("</div>");

				sb.append("</div>");
				sb.append("<div class=\"wcResult-desc wcResult-mobile\">");
				sb.append("" + webContentSearchResultsWrapper.getDescription() + "");
				sb.append("</div>");
				sb.append("</div>");
				sb.append("</div>");
			}

			item.put("resultHtml", sb.toString());

			items.put(item);
		} else {
			JSONObject item = JSONFactoryUtil.createJSONObject();
			item.put("resultHtml", webContentSearchResultsWrapperList.toString());
			items.put(item);
		}
		String selectedCatgName = "";
		String selectedCatgDesc = "";
		_log.debug("singleMainCatg " + singleMainCatg);
		AssetCategory asstCatg = null;
		if (Validator.isNotNull(singleMainCatg) && !singleMainCatg.equals("0")) {
			try {
				asstCatg = AssetCategoryLocalServiceUtil.getAssetCategory(Long.parseLong(singleMainCatg));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				_log.error(e.getMessage());
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				_log.error(e.getMessage());
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				_log.error(e.getMessage());
			}
		}

		StringBuffer sb1 = new StringBuffer();
		JSONObject item = JSONFactoryUtil.createJSONObject();
		if (Validator.isNotNull(asstCatg)) {
			selectedCatgName = asstCatg.getName();
			selectedCatgDesc = asstCatg.getDescription();
			String url = StringPool.BLANK;
			if (selectedCatgDesc.contains("#link#")) {
				String[] splitDesc = selectedCatgDesc.split("#link#");
				selectedCatgDesc = splitDesc[0].trim();
				int e = splitDesc[1].indexOf("</Description>");
				url = splitDesc[1].substring(0, e).trim();
			}
			sb1.append("<div class=\"searchFilter-Category\">");
			sb1.append("<div class=\"selectedCatgName\">");
			sb1.append("" + selectedCatgName + "");
			sb1.append("</div>");
			sb1.append("<div class=\"selectedCatgDesc\">");
			sb1.append("" + selectedCatgDesc + "");
			sb1.append("</div>");
			if (Validator.isNotNull(url)) {
				sb1.append("<div class=\"selectedCatgUrl\">");
				sb1.append("<a href=\"" + url + "\">");
				sb1.append("<span>");
				sb1.append("Learn More");
				sb1.append("</span>");
				sb1.append("</a></div>");
			}
			sb1.append("</div>");
		}

		item.put("catgHtml", sb1.toString());
		items.put(item);

		_log.debug("showLoadmore " + showLoadmore);
		JSONObject itemB = JSONFactoryUtil.createJSONObject();
		itemB.put("showLoadmore", showLoadmore);
		items.put(itemB);

		// _log.debug("items " + items.toString());

		return items.toString();

	}

	@SuppressWarnings("deprecation")
	private List<WebContentSearchResultsWrapper> getResultWrapper(Hits results, String singleMainCatg) {

		List<WebContentSearchResultsWrapper> webContentSearchResultsWrapperList = new ArrayList<WebContentSearchResultsWrapper>();
		for (int i = 0; i < results.getDocs().length; i++) {
			Document doc = results.doc(i);
			String groupId = GetterUtil.getString(doc.get(Field.GROUP_ID));
			String articleId = GetterUtil.getString(doc.get("articleId"));
			String[] catgIds = doc.getValues(Field.ASSET_CATEGORY_IDS);
			String catgName = GetterUtil.getString(doc.get(Field.ASSET_CATEGORY_NAMES));
			for (int t = 0; t < catgIds.length; t++) {
				try {
					AssetCategory asstCatg = AssetCategoryLocalServiceUtil.getAssetCategory(Long.parseLong(catgIds[t]));
					long vocId = asstCatg.getVocabularyId();
					if (Long.parseLong(singleMainCatg) == vocId) {
						catgName = asstCatg.getName();
					}
				} catch (NumberFormatException e) {
					_log.error(e.getMessage());
				} catch (PortalException e) {
					_log.error(e.getMessage());
				} catch (SystemException e) {
					_log.error(e.getMessage());
				}
			}

			String title = StringPool.BLANK;
			String link = StringPool.BLANK;
			String imageUrl = StringPool.BLANK;
			String logo = StringPool.BLANK;
			String content = StringPool.BLANK;
			String size = StringPool.BLANK;
			String duration = StringPool.BLANK;
			String courseType = StringPool.BLANK;
			String durationType = StringPool.BLANK;

			JournalArticle journalArticle = null;
			try {
				journalArticle = JournalArticleLocalServiceUtil.getArticle(Long.parseLong(groupId), articleId);
				String xmlContent = journalArticle.getContent().trim();
				com.liferay.portal.kernel.xml.Document document = SAXReaderUtil.read(xmlContent);

				if (Validator.isNotNull(document
						.selectSingleNode("/root/dynamic-element/dynamic-element[@name='Image']/dynamic-content"))) {
					imageUrl = document.selectSingleNode(
							"/root/dynamic-element/dynamic-element[@name='Image']/dynamic-content").getText();
				}
				if (Validator.isNotNull(document
						.selectSingleNode("/root/dynamic-element/dynamic-element[@name='Size']/dynamic-content"))) {
					size = document.selectSingleNode(
							"/root/dynamic-element/dynamic-element[@name='Size']/dynamic-content").getText();
				}
				if (Validator.isNotNull(document
						.selectSingleNode("/root/dynamic-element/dynamic-element[@name='Duration']/dynamic-content"))) {
					duration = document.selectSingleNode(
							"/root/dynamic-element/dynamic-element[@name='Duration']/dynamic-content").getText();
				}
				if (Validator
						.isNotNull(document
								.selectSingleNode("/root/dynamic-element/dynamic-element[@name='Duration']/dynamic-element[@name='Type']/dynamic-content"))) {
					durationType = document
							.selectSingleNode(
									"/root/dynamic-element/dynamic-element[@name='Duration']/dynamic-element[@name='Type']/dynamic-content")
							.getText();
				}
				if (Validator.isNotNull(document
						.selectSingleNode("/root/dynamic-element/dynamic-element[@name='CourseType']/dynamic-content"))) {
					courseType = document.selectSingleNode(
							"/root/dynamic-element/dynamic-element[@name='CourseType']/dynamic-content").getText();
				}
				if (Validator
						.isNotNull(document
								.selectSingleNode("/root/dynamic-element/dynamic-element[@name='CourseProviderLogo']/dynamic-content"))) {
					logo = document.selectSingleNode(
							"/root/dynamic-element/dynamic-element[@name='CourseProviderLogo']/dynamic-content")
							.getText();
				}
				if (Validator.isNotNull(document
						.selectSingleNode("/root/dynamic-element/dynamic-element[@name='Link']/dynamic-content"))) {
					link = document.selectSingleNode(
							"/root/dynamic-element/dynamic-element[@name='Link']/dynamic-content").getText();
				}
				if (Validator
						.isNotNull(document
								.selectSingleNode("/root/dynamic-element/dynamic-element[@name='Description']/dynamic-content"))) {
					content = document.selectSingleNode(
							"/root/dynamic-element/dynamic-element[@name='Description']/dynamic-content").getText();
				}
				if (Validator.isNotNull(document.selectSingleNode("/root/dynamic-element/dynamic-content"))) {
					title = document.selectSingleNode("/root/dynamic-element/dynamic-content").getText();
				}

			} catch (NumberFormatException e) {
				_log.error(e.getMessage());
			} catch (PortalException e) {
				_log.error(e.getMessage());
			} catch (SystemException e) {
				_log.error(e.getMessage());
			} catch (DocumentException e) {
				_log.error(e.getMessage());
			}

			WebContentSearchResultsWrapper webContentSearchResultsWrapper = new WebContentSearchResultsWrapper(title,
					content, duration, durationType, size, courseType, catgName, link, logo, imageUrl);
			webContentSearchResultsWrapperList.add(webContentSearchResultsWrapper);
		}
		return webContentSearchResultsWrapperList;
	}

	private String searchWebContent(String[] selCatg, ThemeDisplay themeDisplay, int pagination,
			int totalDisplayResults, String searchText, String urlQuery) {

		String query = "";
		_log.debug("final searchText " + selCatg.length);
		boolean isSingle = false;
		for (int c = 0; c < selCatg.length; c++) {
			if (selCatg[c].length() > 5) {
				String[] selCatgFilter = selCatg[c].split(StringPool.COMMA);
				if ("single".equalsIgnoreCase(selCatgFilter[0])) {
					isSingle = true;
				}
				query = buildsearchQuery(selCatgFilter, query, isSingle, searchText, urlQuery);
			}
			_log.debug("final query " + query);
		}

		return query;
	}

	private Hits getSearchResults(String query, ThemeDisplay themeDisplay, int pagination, int totalDisplayResults) {

		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(themeDisplay.getCompanyId());
		_log.debug("pagination search " + pagination + totalDisplayResults);
		_log.debug("query results " + query);
		searchContext.setStart(pagination);
		searchContext.setEnd(pagination + totalDisplayResults);
		Sort sort = SortFactoryUtil.create(Field.MODIFIED_DATE, Sort.LONG_TYPE, true);
		Sort[] sorts = new Sort[] { sort };
		searchContext.setSorts(sorts);

		Hits results = null;
		Indexer indexer = null;
		indexer = IndexerRegistryUtil.getIndexer(JournalArticle.class.getName());
		_log.debug("getSearchResults " + query);
		if (Validator.isNotNull(query)) {
			String resultQFormat = "(%s)";
			query = String.format(resultQFormat, query);
			Query stringQuery = StringQueryFactoryUtil.create(query);
			// Query stringQuery =
			// StringQueryFactoryUtil.create("+(assetCategoryIds:35106)");
			BooleanClause clause = BooleanClauseFactoryUtil.create(searchContext, stringQuery,
					BooleanClauseOccur.MUST.getName());
			searchContext.setBooleanClauses(new BooleanClause[] { clause });
		}

		try {
			results = indexer.search(searchContext);
		} catch (SearchException e) {
			_log.error(e.getMessage());
		}
		// _log.debug("content1 " + results.doc(0).get("content"));
		int count = results.getLength();
		_log.debug("count " + count);
		return results;
	}

	private boolean getSearchResultsCount(String query, ThemeDisplay themeDisplay, int paginationN,
			int totalDisplayResultsN) {

		boolean showLoadmore = false;
		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(themeDisplay.getCompanyId());
		_log.debug("pagination search " + paginationN);
		_log.debug("query results " + query);
		searchContext.setStart(-1);
		searchContext.setEnd(-1);
		Sort sort = SortFactoryUtil.create(Field.MODIFIED_DATE, Sort.LONG_TYPE, true);
		Sort[] sorts = new Sort[] { sort };
		searchContext.setSorts(sorts);

		Hits resultCount = null;
		Indexer indexer = null;
		indexer = IndexerRegistryUtil.getIndexer(JournalArticle.class.getName());
		_log.debug("getSearchResults " + query);
		if (Validator.isNotNull(query)) {
			String resultQFormat = "(%s)";
			query = String.format(resultQFormat, query);
			Query stringQuery = StringQueryFactoryUtil.create(query);
			// Query stringQuery =
			// StringQueryFactoryUtil.create("+(assetCategoryIds:35106)");
			BooleanClause clause = BooleanClauseFactoryUtil.create(searchContext, stringQuery,
					BooleanClauseOccur.MUST.getName());
			searchContext.setBooleanClauses(new BooleanClause[] { clause });
		}

		try {
			resultCount = indexer.search(searchContext);
			_log.debug("resultCount " + resultCount);
		} catch (SearchException e) {
			_log.error(e.getMessage());
		}
		// _log.debug("content1 " + results.doc(0).get("content"));
		int totalCount = resultCount.getLength();
		if (totalCount > (paginationN + totalDisplayResultsN)) {
			showLoadmore = true;
		}
		_log.debug("totalCount " + totalCount + " (paginationN+totalDisplayResultsN) "
				+ (paginationN + totalDisplayResultsN) + " showLoadmore " + showLoadmore);
		return showLoadmore;
	}

	private String buildsearchQuery(String[] selCatgFilter, String query, boolean isSingle, String searchText,
			String urlQuery) {
		String queryIds = "";
		if (Validator.isNull(query)) {
			if ("single".equalsIgnoreCase(selCatgFilter[0])) {
				query = "( assetCategoryIds:(" + selCatgFilter[1] + ") )";
				_log.debug("isSingle " + isSingle);
			} else if ("singleall".equalsIgnoreCase(selCatgFilter[0])) {
				List<AssetCategory> asstCatg = null;
				try {
					asstCatg = getInterestCategories(Long.parseLong(selCatgFilter[1]));
					for (AssetCategory catgVal : asstCatg) {
						if (Validator.isNull(queryIds)) {
							queryIds = String.valueOf(catgVal.getCategoryId());
						} else {
							queryIds = queryIds + " " + String.valueOf(catgVal.getCategoryId());
							;
						}
					}
				} catch (NumberFormatException e) {
					_log.error(e.getMessage());
				} catch (SystemException e) {
					_log.error(e.getMessage());
				}
				query = "( assetCategoryIds:(" + queryIds + "))";
			} else if ("multiselect".equalsIgnoreCase(selCatgFilter[0])) {
				String query1 = "";
				for (int s = 1; s < selCatgFilter.length; s++) {
					if (Long.parseLong(selCatgFilter[s]) > 0) {
						if (Validator.isNull(query1)) {
							query1 = selCatgFilter[s];
						} else {
							query1 = query1 + "  " + selCatgFilter[s];
						}
					}
				}
				_log.debug("query1 ww " + query1);
				if (Validator.isNotNull(query1)) {
					query = "( assetCategoryIds:(" + query1 + "))";
				}
				if (!isSingle) {
					_log.debug("urlQuery " + urlQuery);
					if (Validator.isNotNull(query)) {
						if (Validator.isNotNull(urlQuery)) {
							query = query + "  AND " + urlQuery;
						}
					} else {
						if (Validator.isNotNull(urlQuery)) {
							query = urlQuery;
						}
					}
				}
			}
		} else {
			_log.debug("isSearchAll else " + isSingle);
			if ("single".equalsIgnoreCase(selCatgFilter[0])) {
				// searchBySingleCategoryId = new long[1];
				// searchBySingleCategoryId[0] =
				// Long.parseLong(selCatgFilter[1]);
				query = query + "  AND ( assetCategoryIds:(" + selCatgFilter[1] + ") )";
			} else if ("singleall".equalsIgnoreCase(selCatgFilter[0])) {
				List<AssetCategory> asstCatgs = null;
				try {
					asstCatgs = getInterestCategories(Long.parseLong(selCatgFilter[1]));
					String query1 = "";
					for (AssetCategory catgVal : asstCatgs) {
						if (Validator.isNull(queryIds)) {
							queryIds = String.valueOf(catgVal.getCategoryId());
						} else {
							queryIds = queryIds + " " + String.valueOf(catgVal.getCategoryId());
							;
						}
					}
					query1 = "( assetCategoryIds:(" + queryIds + "))";
					query = query + "  AND " + query1;
				} catch (NumberFormatException e) {
					_log.error(e.getMessage());
				} catch (SystemException e) {
					_log.error(e.getMessage());
				}
			} else if ("multiselect".equalsIgnoreCase(selCatgFilter[0])) {
				String query1 = "";
				for (int s = 1; s < selCatgFilter.length; s++) {
					if (Long.parseLong(selCatgFilter[s]) > 0) {
						if (Validator.isNull(query1)) {
							query1 = selCatgFilter[s];
						} else {
							query1 = query1 + " " + selCatgFilter[s];
						}
					}
				}
				if (Validator.isNotNull(query1)) {
					query = query + "  AND ( assetCategoryIds:(" + query1 + "))";
				}
				if (!isSingle) {
					_log.debug("urlQuery 1 " + urlQuery);
					if (Validator.isNotNull(query)) {
						if (Validator.isNotNull(urlQuery)) {
							query = query + "  AND " + urlQuery;
						}
					} else {
						if (Validator.isNotNull(urlQuery)) {
							query = urlQuery;
						}
					}
				}
			}
		}
		if (Validator.isNotNull(searchText)) {
			query = query + "  AND (content:" + searchText + ")";
		}
		_log.debug("query " + query);
		return query;
	}

	public String getAssetVocabularyName(long vocabularyId) throws Exception {

		String vName = StringPool.BLANK;
		AssetVocabulary assetVocabularies = AssetVocabularyLocalServiceUtil.getAssetVocabulary(vocabularyId);
		vName = assetVocabularies.getName();
		return vName;
	}

	public String getAssetCategoryName(long categoryId) throws Exception {

		String cName = StringPool.BLANK;
		AssetCategory assetCategories = AssetCategoryLocalServiceUtil.getAssetCategory(categoryId);
		cName = assetCategories.getName();
		return cName;
	}

	public List<AssetVocabulary> getAssetVocabularies(long scopeGroupId) throws SystemException, PortalException {
		return AssetVocabularyLocalServiceUtil.getGroupVocabularies(scopeGroupId);
	}

	public List<AssetCategory> getInterestCategories(long vocabularyId) throws SystemException {

		int noOfCategories = AssetCategoryLocalServiceUtil.getAssetCategoriesCount();
		return AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabularyId, 0, noOfCategories, null);

	}

	public static final String I18N_LANGUAGE_ID = "I18N_LANGUAGE_ID";
	public static final String DEFAULT_TABLE_NAME = "CUSTOM_FIELDS";

}
