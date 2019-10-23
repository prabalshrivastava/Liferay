package com.sambaash.platform.portlet.spasset.helper;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

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
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.srv.spasset.model.SPAssetEntry;

public class SPAssetHelper {

	public static String getFriendlyUrlAssetDetails(String pageName,long assetEntryId, Integer posIndex, String searchText){
		pageName = GetterUtil.getString(pageName,"assetDetails");
		String url = "";
		if(posIndex != null && searchText != null)
			url = "/%s/-/assetdetails/view/%s/%s/%s/%s";
		else 
			url = "/%s/-/assetdetails/view/%s";
		return String.format(url, pageName,assetEntryId, "", posIndex, searchText);
	}
	
	public static Hits searchGallery(PortletRequest portletRequest,
			int start, int totalDisplayResult, long spAssetTypeId, String searchText) {
		SearchContext searchContext = SearchContextFactory
				.getInstance(PortalUtil.getHttpServletRequest(portletRequest));
		searchContext.setStart(start);
		searchContext.setEnd(totalDisplayResult);
		searchContext.setKeywords(searchText);
		Sort sort = SortFactoryUtil.create(Field.CREATE_DATE, Sort.LONG_TYPE,
				true);
		Sort[] sorts = new Sort[] { sort };
		searchContext.setSorts(sorts);
		searchContext.setLike(true);

		List<BooleanClause> booleanClauseList = new ArrayList<BooleanClause>();

		BooleanQuery booleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		try {
			booleanQuery.addTerm("spAssetTypeId", spAssetTypeId);
		} catch (ParseException e) {
			
		}
		BooleanClause booleanClause = BooleanClauseFactoryUtil.create(
				searchContext, booleanQuery, BooleanClauseOccur.MUST.getName());
		booleanClauseList.add(booleanClause);

		BooleanClause[] booleanClauses = new BooleanClause[booleanClauseList
				.size()];
		for (int i = 0; i < booleanClauseList.size(); i++) {
			booleanClauses[i] = booleanClauseList.get(i);
		}
		searchContext.setBooleanClauses(booleanClauses);

		Indexer indexer = IndexerRegistryUtil.getIndexer(SPAssetEntry.class);

		try {
			Hits hits = indexer.search(searchContext);
			return hits;
		} catch (SearchException se) {
			_log.error(se);
		}

		return null;
	
	}
	public static List<Document> getGalleryListing(PortletRequest portletRequest,
			int start, int totalDisplayResult, long spAssetTypeId, String searchText) {

		
		Hits hits = searchGallery(portletRequest, start, totalDisplayResult, spAssetTypeId, searchText);
		List<Document> docs = hits.toList();

		return docs;
	}
	
	private static final Log _log = LogFactoryUtil.getLog(SPAssetHelper.class);
}
