package com.sambaash.platform.util;

import com.liferay.portal.kernel.search.HitsOpenSearchImpl;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.sambaash.platform.srv.spasset.model.SPAssetEntry;

public class SPAssetOpenSearchImpl extends HitsOpenSearchImpl {

	public static final String SEARCH_PATH = "/c/spasset/open_search";

	public static final String TITLE = "SPAsset Search: ";

	@Override
	public Indexer getIndexer() {
		return IndexerRegistryUtil.getIndexer(SPAssetEntry.class);
	}

	@Override
	public String getPortletId() {
		return SPAssetIndexer.PORTLET_ID;
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
