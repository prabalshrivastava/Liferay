package com.sambaash.platform.portlet.spjob.util;

import java.util.Date;
import java.util.List;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.HitsOpenSearchImpl;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.ratings.model.RatingsStats;
import com.liferay.portlet.ratings.service.RatingsStatsLocalServiceUtil;
import com.sambaash.platform.srv.spjob.model.SPJob;
import com.sambaash.platform.util.SambaashUtil;
public class SPJobOpenSearchImpl extends HitsOpenSearchImpl {

	public static final String TITLE = "Jobs Search: ";

	@Override
	public Indexer getIndexer() {
		return IndexerRegistryUtil.getIndexer(SPJob.class);
	}

	@Override
	public String getPortletId() {
		return SPJobIndexer.PORTLET_ID;
	}

	@Override
	public String getSearchPath() {
		return SEARCH_PATH;
	}

	@Override
	public String getTitle(String keywords) {
		return TITLE + keywords;
	}

	@Override
	public String search(
			HttpServletRequest request, long groupId, long userId,
			String keywords, int startPage, int itemsPerPage, String format)
		throws SearchException {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);

			SearchContext searchContext = SearchContextFactory.getInstance(
				request);

			searchContext.setAttribute("paginationType", "more");

			if (groupId == 0) {
				searchContext.setGroupIds(null);
			}
			else {
				searchContext.setGroupIds(new long[] {groupId});
			}

			int end = startPage * itemsPerPage;

			searchContext.setEnd(end);

			Layout layout = themeDisplay.getLayout();

			Group layoutGroup = layout.getGroup();

			if (!layoutGroup.isStagingGroup() &&
				!layoutGroup.isControlPanel()) {

				searchContext.setIncludeStagingGroups(false);
			}

			searchContext.setKeywords(keywords);
			searchContext.setScopeStrict(false);

			int start = (startPage * itemsPerPage) - itemsPerPage;

			searchContext.setStart(start);

			searchContext.setUserId(userId);

			Indexer indexer = getIndexer();

			if (indexer == null) {
				Portlet portlet = PortletLocalServiceUtil.getPortletById(
					themeDisplay.getCompanyId(), getPortletId());

				List<Indexer> indexers = portlet.getIndexerInstances();

				indexer = indexers.get(0);
			}

			Hits results = indexer.search(searchContext);

			String[] queryTerms = results.getQueryTerms();

			int total = results.getLength();

			Object[] values = addSearchResults(
				queryTerms, keywords, startPage, itemsPerPage, total, start,
				getTitle(keywords), getSearchPath(), format, themeDisplay);

			com.liferay.portal.kernel.xml.Document doc =
				(com.liferay.portal.kernel.xml.Document)values[0];
			Element root = (Element)values[1];

			for (int i = 0; i < results.getDocs().length; i++) {
				Document result = results.doc(i);

				String portletId = getPortletId();

				if (Validator.isNull(portletId)) {
					portletId = result.get(Field.PORTLET_ID);
				}

				String snippet = results.snippet(i);

				long resultGroupId = GetterUtil.getLong(
					result.get(Field.GROUP_ID));

				if (resultGroupId == 0) {
					resultGroupId = themeDisplay.getScopeGroupId();
				}

				long resultScopeGroupId = GetterUtil.getLong(
					result.get(Field.SCOPE_GROUP_ID));

				if (resultScopeGroupId == 0) {
					resultScopeGroupId = themeDisplay.getScopeGroupId();
				}

				PortletURL portletURL = getPortletURL(
					request, portletId, resultScopeGroupId);

				Summary summary = getSummary(
					indexer, result, themeDisplay.getLocale(), snippet,
					portletURL);

				String title = summary.getTitle();

				String url = getURL(themeDisplay.getCompanyId(), resultScopeGroupId, result.get(Field.ENTRY_CLASS_PK));

				if (Validator.isNull(url)) {
					url = getURL(
						themeDisplay, resultScopeGroupId, result, portletURL);
				}

				Date modifiedDate = result.getDate(Field.MODIFIED_DATE);
				String content = summary.getContent();

				String[] tags = new String[0];

				Field assetTagNamesField = result.getFields().get(
					Field.ASSET_TAG_NAMES);

				if (assetTagNamesField != null) {
					tags = assetTagNamesField.getValues();
				}

				double ratings = 0.0;

				String entryClassName = result.get(Field.ENTRY_CLASS_NAME);
				long entryClassPK = GetterUtil.getLong(
					result.get(Field.ENTRY_CLASS_PK));

				if ((Validator.isNotNull(entryClassName)) &&
					(entryClassPK > 0)) {

					RatingsStats stats = RatingsStatsLocalServiceUtil.getStats(
						entryClassName, entryClassPK);

					ratings = stats.getTotalScore();
				}

				double score = results.score(i);

				addSearchResult(
					root, resultGroupId, resultScopeGroupId, entryClassName,
					entryClassPK, title, url, modifiedDate, content, tags,
					ratings, score, format);
			}

			if (_log.isDebugEnabled()) {
				_log.debug("Return\n" + doc.asXML());
			}

			return doc.asXML();
		}
		catch (Exception e) {
			throw new SearchException(e);
		}
	}

	private String getURL(long companyId, long groupId, String jobId) {
		String paramUrl = SambaashUtil.getParameter(SPJobConstants.JOBS.JOBS_DETAILS_URL, groupId);
		String jobDetailURL = SambaashUtil.getPortalURL(companyId, groupId);
		jobDetailURL += paramUrl + jobId;
		return jobDetailURL;
	} public static final String SEARCH_PATH = "/c/jobs/open_search";

	private static Log _log = LogFactoryUtil
			.getLog(SPJobOpenSearchImpl.class);

}