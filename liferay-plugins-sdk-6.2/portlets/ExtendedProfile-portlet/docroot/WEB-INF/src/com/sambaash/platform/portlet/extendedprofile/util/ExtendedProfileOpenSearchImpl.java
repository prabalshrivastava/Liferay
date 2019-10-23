package com.sambaash.platform.portlet.extendedprofile.util;

import com.liferay.portal.kernel.search.HitsOpenSearchImpl;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.sambaash.platform.srv.extendedprofile.model.SPCompetency;
public class ExtendedProfileOpenSearchImpl extends HitsOpenSearchImpl {

	public static final String SEARCH_PATH = "/c/extendedprofile/open_search";

	public static final String TITLE = "Extended Profile";

	@Override
	public Indexer getIndexer() {
		return IndexerRegistryUtil.getIndexer(SPCompetency.class);
	}

	@Override
	public String getPortletId() {
		return ExtendedProfileIndexer.PORTLET_ID;
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