package com.sambaash.platform.portlet.legalandcontract.util;

import com.liferay.portal.kernel.search.HitsOpenSearchImpl;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.sambaash.platform.srv.legalandcontract.model.Agency;

public class AgencyOpenSearchImpl extends HitsOpenSearchImpl {

	public static final String SEARCH_PATH = "/c/agency/open_search";

	public static final String TITLE = "Agency Search: ";

	@Override
	public Indexer getIndexer() {
		return IndexerRegistryUtil.getIndexer(Agency.class);
	}

	@Override
	public String getPortletId() {
		return AgencyIndexer.PORTLET_ID;
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
