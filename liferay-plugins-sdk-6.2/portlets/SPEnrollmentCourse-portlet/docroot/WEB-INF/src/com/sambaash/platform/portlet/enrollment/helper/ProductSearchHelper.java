package com.sambaash.platform.portlet.enrollment.helper;

import java.text.ParseException;
import java.util.List;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.srv.model.Product;

public class ProductSearchHelper extends EnrollmentHelper {
	
	private static final Log _log = LogFactoryUtil.getLog(ProductSearchHelper.class);

	public static JSONObject searchProducts(PortletRequest request){
		List<Document> docsList = search(request);
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		JSONArray productsJson = JSONFactoryUtil.createJSONArray();
		JSONObject productJson;
		for(Document doc : docsList){
			productJson = JSONFactoryUtil.createJSONObject();
			// check ProductIndexer for field names fetching from document object
			productJson.put("productName", doc.get("productName"));
			productJson.put("productCode", doc.get("productCode"));
			productJson.put("productId", doc.get(Field.ENTRY_CLASS_PK));
			try {
				productJson.put("createdDate", getDateStrddMMYYYY(doc.getDate("createdDate")));
			} catch (ParseException e) {
				_log.error(e);
			}
			
			//TODO: fill more data
			productsJson.put(productJson);
		}
		obj.put("products", productsJson);
		return obj;
	}
	public static List<Document> search(PortletRequest request){
		// optional search text 
		String text = ParamUtil.getString(request, "searchText");
		
		/** Start - calculating start and edn */
		int start = ParamUtil.getInteger(request, "start", -1);
		int pageSize = ParamUtil.getInteger(request, "pageSize", 10);

		if(start < 1){
			// make sure start is valid
			start = -1;
		}

		// just to make sure, page size valid
		if(pageSize < 1 || pageSize > 500){
			pageSize =  10;
		}

		//TODO: if start = -1, make sure we are fetching documents length = pagesize
		int end = start + pageSize;
		/** End - calculating start and edn */
		
		
		/** Start preparing searchcontext */
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		
		SearchContext searchContext = new SearchContext();
		searchContext.setStart(start);
		searchContext.setEnd(end);
		searchContext.setCompanyId(themeDisplay.getCompanyId());

		Sort sort = SortFactoryUtil.create("productName",
				Sort.STRING_TYPE, false);
		Sort[] sorts = new Sort[] { sort };
		searchContext.setSorts(sorts);

		if(Validator.isNotNull(text)){
			searchContext.setKeywords(text);
		}
		/** End preparing searchcontext */
		// let's search
		Hits results = searchProducts(searchContext);
		// convert to list
		List<Document>docs = convertToList(results);
		return docs;
	}
	
	public static Hits searchProducts(SearchContext searchContext) {

		Indexer indexer = IndexerRegistryUtil.getIndexer(Product.class
				.getName());
		Hits results = null;
		try {
			results = indexer.search(searchContext);
			_log.debug("Search Query " + results.getQuery());
		} catch (SearchException e) {
			_log.error(e.getMessage(), e);
		}
		return results;
	}
}
