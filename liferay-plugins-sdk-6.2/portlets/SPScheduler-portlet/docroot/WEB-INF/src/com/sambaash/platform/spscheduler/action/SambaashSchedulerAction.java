package com.sambaash.platform.spscheduler.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequestWrapper;

import com.liferay.portal.kernel.dao.search.ResultRow;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.auth.AuthTokenUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.SPScheduleJobStatus;
import com.sambaash.platform.constant.SPSchedulerConstants;
import com.sambaash.platform.spscheduler.impl.SPSchedulerUtil;
import com.sambaash.platform.srv.spscheduler.model.SPJobEntry;
import com.sambaash.platform.srv.spscheduler.service.SPJobEntryLocalServiceUtil;
import com.sambaash.platform.util.wrapper.HttpServletRequestWrapperExtended;

import net.redhogs.cronparser.CronExpressionDescriptor;

/**
 * Portlet implementation class SambaashSchedulerAction
 */
public class SambaashSchedulerAction extends MVCPortlet {

	private static Log logger = LogFactoryUtil.getLog(SambaashSchedulerAction.class);

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<String> headerNames = new ArrayList<String>();
		headerNames.add("Job Id");
		headerNames.add("Job Name");
		headerNames.add("Job Class");
		headerNames.add("Portlet Id");
		headerNames.add("Cron Expression");
		headerNames.add("Created");
		headerNames.add("Last Updated");
		headerNames.add("Status");
		headerNames.add("Status Message");
		headerNames.add("Actions");

		PortletURL portletURL = getRenderUrl(SPSchedulerConstants.PORTLET_ID, renderRequest, themeDisplay);

		SearchContainer searchContainer = new SearchContainer(renderRequest, null, null,
				SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames,
				"No Scheduled Jobs Yet!");
		portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));

		try {
			List<SPJobEntry> spJobEntries = SPJobEntryLocalServiceUtil.getSPJobEntries(searchContainer.getStart(),
					searchContainer.getEnd());
			searchContainer.setTotal(SPJobEntryLocalServiceUtil.getSPJobEntriesCount());
			if (spJobEntries != null && spJobEntries.size() > 0) {
				List<ResultRow> resultRows = searchContainer.getResultRows();
				for (int i = 0; i < spJobEntries.size(); i++) {
					SPJobEntry spJobEntry = spJobEntries.get(i);
					ResultRow row = new ResultRow(spJobEntry, spJobEntry.getSpJobEntryId(), i);
					row.addText(String.valueOf(spJobEntry.getSpJobEntryId()));
					row.addText(spJobEntry.getJobName());
					row.addText(spJobEntry.getJobClass());
					row.addText(spJobEntry.getPortletId());
					row.addText(CronExpressionDescriptor.getDescription(spJobEntry.getCronExpression()));
					row.addDate(spJobEntry.getCreateDate());
					row.addDate(spJobEntry.getModifiedDate());
					row.addText(SPScheduleJobStatus.stringValue(spJobEntry.getStatus()));
					row.addText(spJobEntry.getStatusMsg());

					// actions
					StringBuilder sb = new StringBuilder();
					sb.append("<div class='jobCTA'>");
					if (spJobEntry.getStatus() == SPScheduleJobStatus.PAUSED.intValue()) {
						sb.append("<button class=\"jobResume\" onclick=\"javascript:resumeJob("
								+ spJobEntry.getSpJobEntryId() + ", '" + themeDisplay.getPortletDisplay().getId()
								+ "')\">Resume</button>");
					} else if (spJobEntry.getStatus() == SPScheduleJobStatus.ACTIVE.intValue()
							|| spJobEntry.getStatus() == SPScheduleJobStatus.RUNNING.intValue()) {
						sb.append("<button class=\"jobPause\" onclick=\"javascript:pauseJob("
								+ spJobEntry.getSpJobEntryId() + ", '" + themeDisplay.getPortletDisplay().getId()
								+ "')\">Pause</button>");
					}

					if (spJobEntry.getStatus() == SPScheduleJobStatus.ACTIVE.intValue()
							|| spJobEntry.getStatus() == SPScheduleJobStatus.PAUSED.intValue())
						sb.append("<button class=\"jobDelete\" onclick=\"javascript:deleteJob("
								+ spJobEntry.getSpJobEntryId() + ",'" + themeDisplay.getPortletDisplay().getId()
								+ "')\">Remove</button>");
					sb.append("</div>");
					row.addText(sb.toString());

					resultRows.add(row);
				}
			}
			renderRequest.setAttribute("searchContainer", searchContainer);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		super.doView(renderRequest, renderResponse);
	}

	private PortletURL getRenderUrl(String portledId, PortletRequest request, ThemeDisplay themeDisplay) {
		PortletURL portletURL = PortletURLFactoryUtil.create(request, portledId, themeDisplay.getPlid(),
				PortletRequest.RENDER_PHASE);
		portletURL.setParameter("formPage", ParamUtil.getString(request, "formPage"));
		return portletURL;
	}

	public void testRequest(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 1);
		Map<String, Object> jobData = new HashMap<String, Object>();
		jobData.put("companyId", themeDisplay.getCompanyId());
		jobData.put("groupId", themeDisplay.getScopeGroupId());
		jobData.put("userId", themeDisplay.getUserId());

		SPSchedulerUtil.schedule("sambaashscheduleraction_WAR_SPSchedulerportlet",
				"com.sambaash.platform.spscheduler.TestJob", "description", cal, "myJob", jobData);
	}
	
	
	public void testSambaashEDM(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 1);
		Map<String, Object> jobData = new HashMap<String, Object>();
		jobData.put("companyId", themeDisplay.getCompanyId());
		jobData.put("groupId", themeDisplay.getScopeGroupId());
		jobData.put("userId", themeDisplay.getUserId());
		jobData.put("campaignId","601");
		jobData.put("spMailType","10001");

		SPSchedulerUtil.schedule("SPMailCampaignCreate_WAR_SPMailportlet",
				"com.sambaash.platform.portlet.spmail.listener.SPMailCampaignJob", "description", cal, "Season's Greeting", jobData);
	}
	

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		HttpServletRequestWrapper httpRequest = new HttpServletRequestWrapperExtended(
				PortalUtil.getHttpServletRequest(resourceRequest));
		try {
			AuthTokenUtil.checkCSRFToken(httpRequest, SambaashSchedulerAction.class.getName());
		} catch (PortalException e1) {
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			obj.put(SPSchedulerConstants.ERROR_MSG, "Error Authenticating user. Please contact administrator");
			logger.error(e1.getMessage());
			resourceResponse.getWriter().write(obj.toString());
			return;
		}

		String action = ParamUtil.getString(resourceRequest, SPSchedulerConstants.ACTION);
		Long jobId = ParamUtil.getLong(resourceRequest, SPSchedulerConstants.JOB_ID);
		logger.info("action = " + action + " jobId = " + jobId);
		Boolean success = false;
		if (SPSchedulerConstants.PARAM_DELETE_JOB.equals(action)) {
			success = SPSchedulerUtil.delete(jobId);
		} else if (SPSchedulerConstants.PARAM_PAUSE_JOB.equals(action)) {
			success = SPSchedulerUtil.pause(jobId);
		} else if (SPSchedulerConstants.PARAM_RESUME_JOB.equals(action)) {
			success = SPSchedulerUtil.resume(jobId);
		} else if (SPSchedulerConstants.PARAM_RESCHEDULE_JOB.equals(action)) {
			String cron = ParamUtil.getString(resourceRequest, SPSchedulerConstants.CRON_EXPR);
			success = SPSchedulerUtil.reSchedule(jobId, cron);
		} else {
			logger.error("Invalid action code!!");
		}
		resourceResponse.getWriter().write(success.toString());
	}

}
