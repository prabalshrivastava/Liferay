package com.sambaash.platform.portlet.spjob.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.portlet.spjob.util.SPJobFieldUtil;
import com.sambaash.platform.portlet.spjob.util.SPJobStatus;
import com.sambaash.platform.portlet.spjob.wrapper.SPJobWrapper;
import com.sambaash.platform.srv.spjob.model.SPJob;

/**
 * Portlet implementation class SPJobLocationAction
 */
public class SPJobLocationAction extends MVCPortlet {

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			PortletPreferences preferences = renderRequest.getPreferences();
			String nameOfDetailPage = preferences.getValue("nameOfDetailPage", StringPool.BLANK);
			renderRequest.setAttribute("nameOfDetailPage", nameOfDetailPage);
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			Map<String, List<SPJobWrapper>> unsortLocationJobsMap = new HashMap<String, List<SPJobWrapper>>();
//			Calendar now = Calendar.getInstance(themeDisplay.getTimeZone(), themeDisplay.getLocale());
//			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SPJob.class);
//			dynamicQuery.add(PropertyFactoryUtil.forName("status").ne(new String("Active")));
//			dynamicQuery.add(PropertyFactoryUtil.forName("closingDate").gt(now.getTime()));
//			dynamicQuery.addOrder(OrderFactoryUtil.desc("modifiedDate"));
//
//			@SuppressWarnings("unchecked")
//			List<SPJob> jobs = SPJobLocalServiceUtil.dynamicQuery(dynamicQuery);

			List<SPJobWrapper> jobWrappers = new ArrayList<SPJobWrapper>();
			try {
				SearchContext searchContext = new SearchContext();
				searchContext.setCompanyId(themeDisplay.getCompanyId());
				searchContext.setSorts(jobSorts);

				List<BooleanClause> allBooleanClauseList = new ArrayList<BooleanClause>();

				// Start -- filter out expired jobs

				Calendar now = Calendar.getInstance(themeDisplay.getTimeZone(), themeDisplay.getLocale());
				Calendar yearsLater = Calendar.getInstance(themeDisplay.getTimeZone(), themeDisplay.getLocale());
				int curYear = now.get(Calendar.YEAR);
				yearsLater.set(Calendar.YEAR, curYear + 100);

	String fromDateStr = indexerDateFormat.format(now.getTime());
	String toDateStr = indexerDateFormat.format(yearsLater.getTime());

	BooleanQuery booleanQuery = BooleanQueryFactoryUtil.create(searchContext);
	booleanQuery.addRangeTerm(SPJobFieldUtil.JOB_CLOSING_DATE, Long.valueOf(fromDateStr).longValue(), Long.valueOf(toDateStr).longValue());

				BooleanClause booleanClause = BooleanClauseFactoryUtil.create(searchContext, booleanQuery,
						BooleanClauseOccur.MUST.getName());
				allBooleanClauseList.add(booleanClause);

				booleanQuery = BooleanQueryFactoryUtil.create(searchContext);
				booleanQuery.addTerm(SPJobFieldUtil.JOB_STATUS, SPJobStatus.ACTIVE.getValue());
				booleanClause = BooleanClauseFactoryUtil.create(searchContext, booleanQuery, BooleanClauseOccur.MUST.getName());
				allBooleanClauseList.add(booleanClause);

				// end -- filter out draft jobs

				BooleanClause[] booleanClauses = new BooleanClause[allBooleanClauseList.size()];

				for (int i = 0; i < allBooleanClauseList.size(); i++) {
					booleanClauses[i] = allBooleanClauseList.get(i);
				}

				searchContext.setBooleanClauses(booleanClauses);
				Indexer indexer = IndexerRegistryUtil.getIndexer(SPJob.class.getName());

				Hits results = indexer.search(searchContext);

				for (int i = 0; i < results.getDocs().length; i++) {
					Document doc = results.doc(i);
					long jobId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
					String jobTitle = GetterUtil.getString(doc.get(Field.TITLE));
					String jobLocation = GetterUtil.getString(doc.get(SPJobFieldUtil.JOB_LOCATION));;

					SPJobWrapper jobWrapper = new SPJobWrapper();
					jobWrapper.setJobId(jobId);
					jobWrapper.setTitle(StringUtil.shorten(jobTitle, 150, "..."));
					jobWrapper.setJobLocation(jobLocation);

					jobWrappers.add(jobWrapper);
				}
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}

			for (SPJobWrapper jobWrapper : jobWrappers) {
				String location = jobWrapper.getJobLocation();

				if (unsortLocationJobsMap.containsKey(location)) {
					unsortLocationJobsMap.get(location).add(jobWrapper);
				} else {
					List<SPJobWrapper> locationJobs = new ArrayList<SPJobWrapper>();
					locationJobs.add(jobWrapper);
					unsortLocationJobsMap.put(location, locationJobs);
				}
			}

			Map<String, List<SPJobWrapper>> locationJobsMap = new TreeMap<String, List<SPJobWrapper>>(unsortLocationJobsMap);
			renderRequest.setAttribute("locationJobsMap", locationJobsMap);

			PortletPreferences preferences = renderRequest.getPreferences();
			String nameOfDetailPage = preferences.getValue("nameOfDetailPage", StringPool.BLANK);
			renderRequest.setAttribute("nameOfDetailPage", nameOfDetailPage);

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException {
		try {
			String action = ParamUtil.getString(actionRequest, "action");

			if (Constants.EDIT.equalsIgnoreCase(action)) {
				PortletPreferences preferences = actionRequest.getPreferences();
				String nameOfDetailPage = ParamUtil.getString(actionRequest, "nameOfDetailPage");
				preferences.setValue("nameOfDetailPage", nameOfDetailPage);
				preferences.store();
				actionResponse.setPortletMode(PortletMode.VIEW);
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {

		super.serveResource(resourceRequest, resourceResponse);
	}

	private static final SimpleDateFormat indexerDateFormat = new SimpleDateFormat(PropsUtil.get(PropsKeys.INDEX_DATE_FORMAT_PATTERN));

	private static Log _log = LogFactoryUtil.getLog(SPJobLocationAction.class);

	private static Sort[] jobSorts = new Sort[] { SortFactoryUtil.create(SPJobFieldUtil.JOB_CREATE_DATE, Sort.LONG_TYPE, true) };

}