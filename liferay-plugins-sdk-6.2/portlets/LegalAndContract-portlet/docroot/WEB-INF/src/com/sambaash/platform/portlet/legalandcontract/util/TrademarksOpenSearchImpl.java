package com.sambaash.platform.portlet.legalandcontract.util;

import com.liferay.portal.kernel.search.HitsOpenSearchImpl;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.sambaash.platform.srv.legalandcontract.model.Trademarks;

public class TrademarksOpenSearchImpl extends HitsOpenSearchImpl {

	public static final String SEARCH_PATH = "/c/trademark/open_search";

	public static final String TITLE = "Trademark Search: ";

	@Override
	public Indexer getIndexer() {
		return IndexerRegistryUtil.getIndexer(Trademarks.class);
	}

	@Override
	public String getPortletId() {
		return TrademarksIndexer.PORTLET_ID;
	}

	@Override
	public String getSearchPath() {
		return SEARCH_PATH;
	}

	@Override
	public String getTitle(String keywords) {
		return TITLE + keywords;
	}
}
