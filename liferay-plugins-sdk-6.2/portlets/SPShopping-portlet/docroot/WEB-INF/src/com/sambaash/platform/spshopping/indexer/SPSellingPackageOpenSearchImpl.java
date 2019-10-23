package com.sambaash.platform.spshopping.indexer;

import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.search.HitsOpenSearchImpl;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.sambaash.platform.spshopping.SPShoppingConstants;
import com.sambaash.platform.srv.spshopping.model.SPSellingPackage;

public class SPSellingPackageOpenSearchImpl extends HitsOpenSearchImpl {
	
	public static final String SEARCH_PATH = "/c/spshopping/open_search";
	
	@Override
	public Indexer getIndexer() {
		return IndexerRegistryUtil.getIndexer(SPSellingPackage.class);
	}

	@Override
	public String getPortletId() {
		return SPShoppingConstants.PORTLET_ID;
	}

	@Override
	public String getSearchPath() {
		return SEARCH_PATH;
	}

	@Override
	public String getTitle(String keywords) {
		return "Shopping Packages : " + keywords;
	}
	
	@Override
	public String search(
			HttpServletRequest request, long groupId, long userId,
			String keywords, int startPage, int itemsPerPage, String format)
		throws SearchException {
		// TODO
		return "";
	}


}
