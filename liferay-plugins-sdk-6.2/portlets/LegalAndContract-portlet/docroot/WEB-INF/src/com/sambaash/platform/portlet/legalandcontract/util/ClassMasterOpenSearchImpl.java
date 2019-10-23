package com.sambaash.platform.portlet.legalandcontract.util;

import com.liferay.portal.kernel.search.HitsOpenSearchImpl;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.sambaash.platform.srv.legalandcontract.model.ClassMaster;

public class ClassMasterOpenSearchImpl extends HitsOpenSearchImpl {

	public static final String SEARCH_PATH = "/c/classmaster/open_search";

	public static final String TITLE = "ClassMaster Search: ";

	@Override
	public Indexer getIndexer() {
		return IndexerRegistryUtil.getIndexer(ClassMaster.class);
	}

	@Override
	public String getPortletId() {
		return ClassMasterIndexer.PORTLET_ID;
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
