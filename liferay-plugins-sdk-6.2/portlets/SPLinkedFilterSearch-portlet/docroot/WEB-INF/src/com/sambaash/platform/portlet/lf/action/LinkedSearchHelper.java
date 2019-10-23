package com.sambaash.platform.portlet.lf.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.util.ThumbnailUtil;

public class LinkedSearchHelper {

	private static Log _log = LogFactoryUtil.getLog(LinkedSearchHelper.class);

	public static JSONObject handleLoadChildsAndSearch(PortletRequest request) {
		JSONObject responseData = JSONFactoryUtil.createJSONObject();
		PortletPreferences prefs = request.getPreferences();
		boolean firstRequest = ParamUtil.getBoolean(request, "firstRequest");
		boolean linkedFilterEnabled = GetterUtil.getBoolean(prefs.getValue(
				"enableLinkedFilter", "false"));
		boolean ivdFilterEnabled = GetterUtil.getBoolean(prefs.getValue(
				"enableIvdFilter", "false"));

		if (linkedFilterEnabled) {
			boolean fromUrl = ParamUtil.getBoolean(request, "fromUrl");
			boolean loadChilds = ParamUtil.getBoolean(request, "loadChilds");
			if (fromUrl) {
				FiltersRenderHelper.loadLinkedFilters(request, responseData);
			}
			if (loadChilds) { // upon clicking any category under linked filter
				FiltersRenderHelper.prepareChildCategories(responseData,
						request);
			} else if (ParamUtil.getBoolean(request, "loadFirstLevel")) { // First
																			// request
																			// and
																			// url
																			// filters
																			// are
																			// not
																			// present
				FiltersRenderHelper.loadFirstLevelFilter(responseData, prefs);
			}
		}
		if (ivdFilterEnabled) {
			if (firstRequest) {
				try {
					FiltersRenderHelper
							.prepareIvdFilters(request, responseData);
				} catch (SystemException e) {
					responseData
							.put("error",
									"Error while creating filters. Please contact administrator");
				}
			}
		}

		try {
			handleSearch(request, responseData);
		} catch (Exception ex) {
			responseData.put("error", "Error while fetchng search results");
		}
		return responseData;
	}

	public static JSONObject handleSearch(PortletRequest request,
			JSONObject responseData) throws SearchException, ParseException,
			SystemException {
		Hits results = prepareSearchContextAndSearch(request);
		responseData.put("total", results.getLength());
		// convert to list
		List<Document> searchResultsDocs = convertToList(results);
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences prefs = request.getPreferences();
		long spzVocId = GetterUtil.getLong(prefs.getValue(
				"specializationVocId", "0"));

		PortletURL portletURL = getDetailUrl(request);
		// JSONObject obj = JSONFactoryUtil.createJSONObject();
		JSONArray results1 = JSONFactoryUtil.createJSONArray();
		JSONObject result;
		String entryClassPk;
		String imgUrl;
		long imgId;
		long frameworkImageId;
		for (Document doc : searchResultsDocs) {
			result = JSONFactoryUtil.createJSONObject();
			entryClassPk = doc.get(Field.ENTRY_CLASS_PK);
			if (portletURL != null) {
				portletURL.setParameter("productId", entryClassPk);
				result.put("detailsLink", portletURL.toString());
			}

			// product logo
			imgId = GetterUtil.getLong(doc.get("productImageId"));
			try {
				if (imgId > 0) {
					imgUrl = ThumbnailUtil.getThumbnailUrl(
							DLAppServiceUtil.getFileEntry(imgId),
							themeDisplay.getPathThemeImages(),
							themeDisplay.getPortalURL(),
							themeDisplay.getPathContext(), 2);
					result.put("logoUrl", imgUrl);
				}
			} catch (Exception e) {
				_log.error("Error while constructing thumbnail url "
						+ e.getMessage());
			}
			// framework logo
			frameworkImageId = GetterUtil.getLong(doc.get("frameworkImageId"));
			try {
				if (frameworkImageId > 0) {
					// LHSUPPORT-350 hard coded the framework image for
					// predefined products due to urgent request from lithan
					if (entryClassPk.equalsIgnoreCase("1738")
							|| entryClassPk.equalsIgnoreCase("1755")
							|| entryClassPk.equalsIgnoreCase("1741")
							|| entryClassPk.equalsIgnoreCase("1603")
							|| entryClassPk.equalsIgnoreCase("1602")) {
						imgUrl = "/documents/12720/120504/logo-01.png?version=1.0";
					} else {
						imgUrl = ThumbnailUtil
								.getThumbnailUrl(DLAppServiceUtil
										.getFileEntry(frameworkImageId),
										themeDisplay.getPathThemeImages(),
										themeDisplay.getPortalURL(),
										themeDisplay.getPathContext(), 1);
					}
					result.put("frameworkLogoUrl", imgUrl);
				}
			} catch (Exception e) {
				_log.error("Error while constructing thumbnail url "
						+ e.getMessage());
			}
			try {
				String[] catIds = doc.getValues(Field.ASSET_CATEGORY_IDS);
				StringBuilder sb = new StringBuilder();
				for (String tempCatId : catIds) {
					long catId = GetterUtil.getLong(tempCatId);
					AssetCategory category = AssetCategoryLocalServiceUtil
							.getAssetCategory(catId);
					if (spzVocId != category.getVocabularyId()) {
						continue;
					}
					if (sb.length() > 0) {
						sb.append(StringPool.COMMA);
						sb.append(category.getName());
					} else {
						sb.append(category.getName());
					}
				}
				result.put("specialization", sb.toString());

			} catch (Exception ex) {
				_log.error("Error while getting asset category names");
			}

			result.put("type", doc.get("courseType"));
			result.put("productName", doc.get("productName"));
			String displayDesc = doc.get("courseDescription");
			if (Validator.isNotNull(displayDesc)) {
				if (displayDesc.length() > 250) {
					displayDesc = displayDesc.substring(0, 250) + "...";
				}
			}
			result.put("desc", displayDesc);
			double duration = GetterUtil.getDouble(doc.get("courseDuration"));
			result.put("duration", doc.get("courseDuration"));
			if (duration == 1) {
				result.put("durationUnit", "");
			} else {
				result.put("durationUnit", "");
			}
			int count = GetterUtil.getInteger(doc.get("moduleCount"));
			if (count == 1) {
				result.put("moduleLabel", "module");
			} else {
				result.put("moduleLabel", "modules");
			}
			result.put("moduleCount", count);

			results1.put(result);
		}
		responseData.put("searchResults", results1);
		return responseData;
	}

	private static String appendSlash(String pageName) {
		pageName = GetterUtil.getString(pageName);
		if (pageName.charAt(0) != '/') {
			pageName = "/" + pageName;
		}
		return pageName;
	}

	private static PortletURL getDetailUrl(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences prefs = request.getPreferences();
		String friendlyUrlPage = appendSlash(prefs.getValue("detailPageName",
				"product"));
		String portletId = "Product_WAR_SPProductportlet";
		Layout layout = null;
		PortletURL url = null;
		try {
			layout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
					themeDisplay.getScopeGroupId(), false, friendlyUrlPage);
			url = PortletURLFactoryUtil.create(request, portletId,
					layout.getPlid(), PortletRequest.RENDER_PHASE);
			url.setWindowState(WindowState.MAXIMIZED);
			url.setPortletMode(PortletMode.VIEW);
			url.setParameter("jspPage", "/html/detail/view.jsp");
			// url.setParameter("productId", "");
		} catch (Exception e) {
			_log.error(e);
		}
		return url;
	}

	public static Hits prepareSearchContextAndSearch(PortletRequest request)
			throws SearchException, ParseException, SystemException {
		/** Calculating start and end */
		int start = ParamUtil.getInteger(request, "start", 0);
		int pageSize = ParamUtil.getInteger(request, "pageSize", 10);

		// just to make sure, page size valid
		if (pageSize < 1 || pageSize > 500) {
			pageSize = 10;
		}
		// TODO: if start = -1, make sure we are fetching documents length =
		// pagesize
		int end = start + pageSize;
		/** End -- Calculating start and end */

		/** Start preparing searchcontext */
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		SearchContext searchContext = new SearchContext();
		searchContext.setStart(start);
		searchContext.setEnd(end);
		searchContext.setCompanyId(themeDisplay.getCompanyId());

		Sort sort = SortFactoryUtil.create("productName", Sort.STRING_TYPE,
				false);
		Sort[] sorts = new Sort[] { sort };
		searchContext.setSorts(sorts);

		List<BooleanClause> list = new ArrayList<BooleanClause>();
		BooleanClause bc = getLinkedCatIdsQuery(searchContext, request);
		if (bc != null) {
			list.add(bc);
		}
		bc = getSearchTextQuery(searchContext, request);
		if (bc != null) {
			list.add(bc);
		}
		bc = getIvdCatIdsQuery(searchContext, request);
		if (bc != null) {
			list.add(bc);
		}

		list.add(getbcPublished(searchContext));

		BooleanClause[] bcArray = list.toArray(new BooleanClause[0]);
		if (bcArray.length > 0) {
			searchContext.setBooleanClauses(bcArray);
		}

		/** End preparing searchcontext */
		// let's search
		Hits results = searchProducts(searchContext);

		return results;
	}

	public static List<Document> convertToList(Hits results) {

		Document[] docs = results.getDocs();
		List<Document> list = ListUtil.fromArray(docs);

		return list;
	}

	public static Hits searchProducts(SearchContext searchContext)
			throws SearchException {

		Indexer indexer = IndexerRegistryUtil.getIndexer(Product.class
				.getName());
		Hits results = indexer.search(searchContext);
		_log.debug("Search Query " + results.getQuery());

		return results;
	}

	private static BooleanClause getSearchTextQuery(
			SearchContext searchContext, PortletRequest request)
			throws SystemException, ParseException {
		// optional search text
		String text = ParamUtil.getString(request, "searchText").trim();
		BooleanClause bc = null;
		String[] searchableFields = { "productName_lower", "productCode",
				"countryId", "countryName_lower", "productCatgories" };

		if (Validator.isNotNull(text)) {
			BooleanQuery query = BooleanQueryFactoryUtil.create(searchContext);

			// split the text using space
			String[] splitTexts = text.split(" ");
			for (String searchField : searchableFields) {
				BooleanQuery subQuery = BooleanQueryFactoryUtil
						.create(searchContext);
				for (String splitText : splitTexts) {
					subQuery.addTerm(searchField, splitText, true,
							BooleanClauseOccur.MUST);
				}
				query.add(subQuery, BooleanClauseOccur.SHOULD);

			}
			if (query.hasClauses()) {
				bc = BooleanClauseFactoryUtil.create(searchContext, query,
						BooleanClauseOccur.MUST.getName());
			}
		}
		return bc;
	}

	private static BooleanClause getLinkedCatIdsQuery(
			SearchContext searchContext, PortletRequest request)
			throws SystemException, ParseException {
		BooleanQuery query = BooleanQueryFactoryUtil.create(searchContext);
		String catIdsStr = ParamUtil.getString(request, "catgIds");
		List<Long> catIdList = getParentChildCatgs(catIdsStr);
		for (long catId : catIdList) {
			query.addTerm(Field.ASSET_CATEGORY_IDS, catId);
		}
		BooleanClause bc = null;
		if (query.hasClauses()) {
			bc = BooleanClauseFactoryUtil.create(searchContext, query,
					BooleanClauseOccur.MUST.getName());
		}
		return bc;
	}

	private static BooleanClause getIvdCatIdsQuery(SearchContext searchContext,
			PortletRequest request) throws SystemException, ParseException {
		BooleanQuery query = BooleanQueryFactoryUtil.create(searchContext);
		/**
		 * Example: ivdCatIds = "4321,34213,4092##3219,3219##112,3421" must be
		 * translated in query format as : asset_category_ids=( (4321 OR 34213
		 * OR 4092 ) AND (3219 OR 3219) AND (112 OR 3421) )
		 */
		String allCatIds = ParamUtil.getString(request, "ivdCatIds");
		String[] activeItemsInFilter = allCatIds.split("##");
		for (String temp : activeItemsInFilter) {
			String[] catIds = temp.split(StringPool.COMMA);
			BooleanQuery subquery = BooleanQueryFactoryUtil
					.create(searchContext);
			for (String catIdTemp : catIds) {
				long catId = GetterUtil.getLong(catIdTemp);
				if (catId > 0) {
					subquery.addTerm(Field.ASSET_CATEGORY_IDS,
							String.valueOf(catId));
				}
			}
			if (subquery.hasClauses()) {
				query.add(subquery, BooleanClauseOccur.MUST);
			}
		}
		BooleanClause bc = null;
		if (query.hasClauses()) {
			bc = BooleanClauseFactoryUtil.create(searchContext, query,
					BooleanClauseOccur.MUST.getName());
		}
		return bc;
	}

	private static BooleanClause getbcPublished(SearchContext searchContext) {
		BooleanQuery query = BooleanQueryFactoryUtil.create(searchContext);
		// here status = 1 indicates published plz check
		// com.sambaash.platform.product.util.Status
		query.addRequiredTerm(Field.STATUS, 1);
		BooleanClause bc = BooleanClauseFactoryUtil.create(searchContext,
				query, BooleanClauseOccur.MUST.getName());

		return bc;
	}

	private static List<Long> getParentChildCatgs(String catIdsStr)
			throws SystemException {
		String[] temp = GetterUtil.getString(catIdsStr).split(StringPool.COMMA);
		List<Long> catIds = new ArrayList<Long>();
		for (String str : temp) {
			long catId = GetterUtil.getLong(str);
			if (catId > 0) {
				catIds.add(catId);
				loadAllChilds(catId, catIds);
			}
		}
		return catIds;
	}

	private static void loadAllChilds(long catId, List<Long> catIds)
			throws SystemException {
		List<AssetCategory> subList = AssetCategoryLocalServiceUtil
				.getChildCategories(catId);
		for (AssetCategory child : subList) {
			catIds.add(child.getCategoryId());
			loadAllChilds(child.getCategoryId(), catIds);
		}
	}

}
