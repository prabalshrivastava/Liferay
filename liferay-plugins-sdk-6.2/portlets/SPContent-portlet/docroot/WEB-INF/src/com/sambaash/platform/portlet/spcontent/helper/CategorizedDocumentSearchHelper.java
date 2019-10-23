package com.sambaash.platform.portlet.spcontent.helper;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.sambaash.platform.portlet.spcontent.util.ActionUtil;

@SuppressWarnings("rawtypes")
public class CategorizedDocumentSearchHelper<T> extends AbstractDocumentSearchHelper {
	private SearchContext searchContext;
	
	@SuppressWarnings("unchecked")
	public CategorizedDocumentSearchHelper(ActionRequest actionRequest, Class<T> indexedClass) {
		super(actionRequest, indexedClass);
	}
		
	@Override
	protected SearchContext getSearchContext() {
		if (searchContext==null) {
			searchContext = ActionUtil.newSearchContext(actionRequest, -1, -1);
		}
		return searchContext;
	}

	@Override
	protected Hits doDocumentSearch(SearchContext searchContext,
			long companyId, BooleanQuery fullQuery, int start,
			int end) throws SearchException {
		Hits hits = SearchEngineUtil.search(
				searchContext.getSearchEngineId(),
				companyId, fullQuery, searchContext.getSorts()[0], start, end);
		return hits;
	}

}
