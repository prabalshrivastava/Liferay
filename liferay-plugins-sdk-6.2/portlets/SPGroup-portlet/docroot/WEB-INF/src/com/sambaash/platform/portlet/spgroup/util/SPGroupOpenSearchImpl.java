package com.sambaash.platform.portlet.spgroup.util;

import com.liferay.portal.kernel.search.HitsOpenSearchImpl;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.sambaash.platform.srv.spgroup.model.SPGroup;
public class SPGroupOpenSearchImpl extends HitsOpenSearchImpl {

	public static final String SEARCH_PATH = "/c/spgroup/open_search";

	public static final String TITLE = "Group Search: ";

	@Override
	public Indexer getIndexer() {
		return IndexerRegistryUtil.getIndexer(SPGroup.class);
	}

	@Override
	public String getPortletId() {
		return SPGroupIndexer.PORTLET_ID;
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