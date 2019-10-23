package com.sambaash.platform.portlet.spsc.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.HitsOpenSearchImpl;

//import com.sambaash.platform.servicecomponent.indexer.Indexer;

public class ServiceComponentGroupOpenSearchImpl extends HitsOpenSearchImpl {

		private static Log _log = LogFactoryUtil.getLog(ServiceComponentGroupOpenSearchImpl.class);

		public static final String SEARCH_PATH = "/c/spsc/open_search";

		    	public static final String TITLE = "Service Component Group Search: ";

		    	public String getSearchPath() {
		    		_log.info("getSearchPath:"+SEARCH_PATH);
		    		return SEARCH_PATH;
		    	}

		    	public String getTitle(String keywords) {
		    		_log.info("getTitle:"+keywords);
		    		return TITLE + keywords;
		    	}

				@Override
				public String getPortletId() {
					// TODO Auto-generated method stub
					//return Indexer.PORTLET_ID;
					return null;
				}

				public Hits getHits(long companyId, long groupId, long userId, String keywords,
						int start, int end) throws Exception {
					// TODO Auto-generated method stub
					_log.info("getHits:"+companyId);

					//return ServiceHelper.search(companyId, groupId, userId, 0, keywords, start, end);
				return null;
				}
				
}
