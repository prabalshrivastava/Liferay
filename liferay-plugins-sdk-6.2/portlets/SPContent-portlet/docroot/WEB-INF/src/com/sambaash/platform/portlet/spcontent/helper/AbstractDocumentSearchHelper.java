package com.sambaash.platform.portlet.spcontent.helper;

import static com.sambaash.platform.portlet.spcontent.Constant.CONTENT_PARENT_CATEGORY;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.search.StringQueryFactoryUtil;
import com.liferay.portal.kernel.search.TermQueryFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.portlet.spcontent.Constant;
import com.sambaash.platform.portlet.spcontent.WebKeys;
import com.sambaash.platform.portlet.spcontent.config.TabConfigurations;
import com.sambaash.platform.portlet.spcontent.util.ActionUtil;
import com.sambaash.platform.srv.spchallenge.model.SPChallenge;
import com.sambaash.platform.util.SearchUtils;

public abstract class AbstractDocumentSearchHelper<T> {
	private static final Log LOG = LogFactoryUtil.getLog(AbstractDocumentSearchHelper.class);
	protected ActionRequest actionRequest;
	protected Class<T> indexedClass;
	protected int currentTabIndex = -1; // this is use to flag tab content query
										// loop when content type is ALL. To
										// determine the category criteria to
										// use in each loop.
	protected long parentCatId;
	protected long catId;
	protected ThemeDisplay themeDisplay;
	protected String contentCategory;

	public AbstractDocumentSearchHelper(ActionRequest actionRequest, Class<T> indexedClass) {
		this.actionRequest = actionRequest;
		this.indexedClass = indexedClass;
		themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	}

	public void setCurrentTabIndex(int currentTabIndex) {
		this.currentTabIndex = currentTabIndex;
	}

	public List<Document> searchDocumentsByCategory() throws SystemException, SearchException, ParseException {
		List<Document> contentList = new ArrayList<>();
		PortletPreferences portletPreferences = actionRequest.getPreferences();

		String parentCategoryName = ActionUtil.getPreferenceValue(portletPreferences, CONTENT_PARENT_CATEGORY, ""); // is
																													// now
																													// the
																													// ID

		int tabIndex = (currentTabIndex > -1) ? currentTabIndex
				: ParamUtil.getInteger(actionRequest, Constant.TAB_CONTENT_INDEX);
		if (tabIndex < 0) {
			return contentList;
		}
		TabConfigurations tabConfigs = ActionUtil.retrieveTabConfigurations(portletPreferences);
		String contentVocabulary = tabConfigs.getTabs()[tabIndex].vocabulary;
		contentCategory = tabConfigs.getTabs()[tabIndex].category;

		parentCatId = Long.parseLong(parentCategoryName);
		catId = ActionUtil.getAssetCategoryIdByName(contentVocabulary, contentCategory);

		if (parentCatId > -1 && catId > -1) {

			SearchContext searchContext = getSearchContext();
			// parent category id here
			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
			BooleanQuery searchQuery = ActionUtil.newSearchQuery(searchContext, themeDisplay.getCompanyId(),
					themeDisplay.getScopeGroupId());
			searchQuery.add(TermQueryFactoryUtil.create(searchContext, Field.ENTRY_CLASS_NAME, indexedClass.getName()),
					BooleanClauseOccur.MUST);
			searchQuery.addRequiredTerm(Field.ASSET_CATEGORY_IDS, parentCatId);
			fullQuery.add(searchQuery, BooleanClauseOccur.MUST);
			// tab page category id here
			BooleanQuery categoryQuery = BooleanQueryFactoryUtil.create(searchContext);
			categoryQuery.addExactTerm(Field.ASSET_CATEGORY_IDS, catId);
			fullQuery.add(categoryQuery, BooleanClauseOccur.MUST);

			boolean activeOnly = tabConfigs.getTabs()[tabIndex].active;
			if (activeOnly && SPChallenge.class.getName().equalsIgnoreCase(indexedClass.getName())) {
				Query stringQuery = StringQueryFactoryUtil.create(SearchUtils.getActiveChallengesEndDateOnlyQuery());
				fullQuery.add(stringQuery, BooleanClauseOccur.MUST);
			} else if (activeOnly && CalendarBooking.class.getName().equalsIgnoreCase(indexedClass.getName())) {
				Query stringQuery = StringQueryFactoryUtil.create(SearchUtils.getActiveCalendarBookingOnlyQuery());
				fullQuery.add(stringQuery, BooleanClauseOccur.MUST);
			}
			
			String sortField = Field.MODIFIED_DATE;
			int sortType = Sort.LONG_TYPE;
			boolean descending = true;

			if (CalendarBooking.class.getName().equalsIgnoreCase(indexedClass.getName())) {
				sortField = "startTime";
				descending = false;
			}
			
			Sort sort = SortFactoryUtil.create(sortField, sortType, descending);
			searchContext.setSorts(sort);

			Hits hits = doDocumentSearch(searchContext, themeDisplay.getCompanyId(), fullQuery, -1, -1);

			LOG.debug("query = " + fullQuery);
			for (Document document : hits.getDocs()) {
				try {
					contentList.add(document);
				} catch (Exception e) {
					LOG.error(e);
				}
			}
		}
		return contentList;
	}

	protected abstract SearchContext getSearchContext();

	protected abstract Hits doDocumentSearch(SearchContext searchContext, long companyId, BooleanQuery fullQuery,
			int start, int end) throws SearchException;

}
