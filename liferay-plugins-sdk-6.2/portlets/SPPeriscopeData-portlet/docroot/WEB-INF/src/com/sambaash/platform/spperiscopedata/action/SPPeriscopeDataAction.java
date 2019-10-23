package com.sambaash.platform.spperiscopedata.action;

import static com.sambaash.platform.spperiscopedata.SPPeriscopeDataConstant.API_KEY;
import static com.sambaash.platform.spperiscopedata.SPPeriscopeDataConstant.EMBED_VERSION;
import static com.sambaash.platform.spperiscopedata.SPPeriscopeDataConstant.NAV_CONFIG;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.SPSchedulerConstants;
import com.sambaash.platform.spperiscopedata.SPPeriscopeDataConstant;
import com.sambaash.platform.spperiscopedata.builder.PeriscopedataRequestBuilder;
import com.sambaash.platform.spperiscopedata.builder.PeriscopedataRequestBuilder.APIOptions;
import com.sambaash.platform.spperiscopedata.listener.SPFinanceDataReport;
import com.sambaash.platform.spperiscopedata.util.PeriscopedataUtil;
import com.sambaash.platform.srv.spscheduler.model.SPJobEntry;
import com.sambaash.platform.srv.spscheduler.service.SPJobEntryLocalServiceUtil;
import com.sambaash.platform.util.JSONUtil;

/**
 * Portlet implementation class SPPeriscopeDataAction
 */
public class SPPeriscopeDataAction extends MVCPortlet {
	private static Log _log = LogFactoryUtil.getLog(SPPeriscopeDataAction.class);
	private static final String portletId = "spperiscopedata_WAR_SPPeriscopeDataportlet";
	public static final String JOB_CLASS_EDM = "com.sambaash.platform.spperiscopedata.listener.SPFinanceDataReport";

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		preparePreferencesData(renderRequest, renderResponse);
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		preparePreferencesData(renderRequest, renderResponse);
		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		String action = ParamUtil.getString(resourceRequest, "action");
		if (action.equals("drilldown")) {
			doPeriscopedataDrilldown(resourceRequest, resourceResponse);
		} else if (action.equals("loadDashboard")) {
			loadPeriscopedataDashboard(resourceRequest, resourceResponse);
		}
	}

	private void loadPeriscopedataDashboard(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			JSONObject retval = (JSONObject) JSONFactoryUtil.createJSONObject();
			String menuJsonDataStr = ParamUtil.getString(resourceRequest, "menuData", "{}");
			JSONObject menuJsonData = (JSONObject) JSONFactoryUtil.createJSONObject(menuJsonDataStr);
			long targetDashboard = menuJsonData.getLong("dashboardId");
			String filtersShown = menuJsonData.getString("filters", "");
			PeriscopedataRequestBuilder builder = PeriscopedataUtil
					.getPeriscopedataRequestBuilder(resourceRequest.getPreferences(), targetDashboard, filtersShown);
			if (menuJsonData.has("filter_values")) {
				JSONArray drilldownFilters = menuJsonData.getJSONArray("filter_values");
				JSONArray filterArr = JSONFactoryUtil.createJSONArray();
				for (int i = 0; i < drilldownFilters.length(); i++) {
					JSONObject drilldownFilter = (JSONObject) drilldownFilters.getJSONObject(i);
					JSONObject filter = (JSONObject) JSONFactoryUtil.createJSONObject();
					filter.put("name", drilldownFilter.getString("filter_name"));
					filter.put("value", drilldownFilter.getString("column_value"));
					filterArr.put(filter);
				}
				if (filterArr.length() > 0) {
					builder.setParameter(APIOptions.FILTERS, filterArr.toString());
				}
			}
			if (menuJsonData.has("daterange")) {
				JSONObject dateRangeFilter = menuJsonData.getJSONObject("daterange");
				builder.setParameter(APIOptions.DATE_RANGE, dateRangeFilter.toString());
			}
			String dashboardUrl = builder.buildRequestUrl();
			retval.put("dashboardUrl", dashboardUrl);
			resourceResponse.getWriter().write(retval.toString());
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}

	private void doPeriscopedataDrilldown(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			JSONObject retval = (JSONObject) JSONFactoryUtil.createJSONObject();
			String drilldownJsonDataStr = ParamUtil.getString(resourceRequest, "drilldownData", "{}");
			JSONObject drilldownJsonData = (JSONObject) JSONFactoryUtil.createJSONObject(drilldownJsonDataStr);
			long targetDashboard = drilldownJsonData.getLong("destination_dashboard_id");
			JSONArray drilldownFilters = drilldownJsonData.getJSONArray("filter_values");
			JSONArray filterArr = JSONFactoryUtil.createJSONArray();
			List<String> filters = new ArrayList<String>();
			String dateRangeFilter = null;
			String startDateFilter = null;
			String endDateFilter = null;
			for (int i = 0; i < drilldownFilters.length(); i++) {
				JSONObject drilldownFilter = (JSONObject) drilldownFilters.getJSONObject(i);
				JSONObject filter = (JSONObject) JSONFactoryUtil.createJSONObject();
				String fiterName = drilldownFilter.getString("filter_name");
				String filterValue = drilldownFilter.getString("column_value");
				fiterName = "date_range".equals(fiterName) ? "daterange" : fiterName;
				filter.put("name", fiterName);
				filter.put("value", filterValue);
				filterArr.put(filter);
				if ("custom_range_start_date".equals(fiterName)) {
					startDateFilter = filterValue;
				} else if ("custom_range_end_date".equals(fiterName)) {
					endDateFilter = filterValue;
				} else if ("daterange".equals(fiterName)) {
					startDateFilter = filterValue;
					endDateFilter = filterValue;
				}
			}
			if (startDateFilter != null && endDateFilter != null) {
				filters.add("daterange");
				dateRangeFilter = String.format("{\"start\": \"%s\", \"end\": \"%s\"}", startDateFilter, endDateFilter);
			}
			if (drilldownJsonData.has("defaultDrilldownFilters")) {
				JSONArray defaultDrilldownFilters = drilldownJsonData.getJSONArray("defaultDrilldownFilters");
				for (int j = 0; j < defaultDrilldownFilters.length(); j++) {
					String drilldownFilter = defaultDrilldownFilters.getString(j);
					if (!filters.contains(drilldownFilter)) {
						filters.add(drilldownFilter);
					}
				}
			}
			PeriscopedataRequestBuilder builder = PeriscopedataUtil.getPeriscopedataRequestBuilder(
					resourceRequest.getPreferences(), targetDashboard,
					filters.toString().replace("[", "").replace("]", ""));
			if (filterArr.length() > 0) {
				builder.setParameter(APIOptions.FILTERS, filterArr.toString());
			}
			if (dateRangeFilter != null) {
				builder.setParameter(APIOptions.DATE_RANGE, dateRangeFilter.toString());
			}
			String drilldownUrl = builder.buildRequestUrl();
			retval.put("drilldownUrl", drilldownUrl);
			resourceResponse.getWriter().write(retval.toString());
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}

	private void preparePreferencesData(RenderRequest renderRequest, RenderResponse renderResponse) {
		PortletPreferences preferences = renderRequest.getPreferences();

		renderRequest.setAttribute(API_KEY, preferences.getValue(API_KEY, StringPool.BLANK));
		renderRequest.setAttribute(EMBED_VERSION, preferences.getValue(EMBED_VERSION, "v2"));
		renderRequest.setAttribute(NAV_CONFIG, preferences.getValue(NAV_CONFIG, StringPool.BLANK));
	}

	public void savePreferences(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		PortletPreferences preferences = actionRequest.getPreferences();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String apiKey = ParamUtil.getString(actionRequest, API_KEY, "");
		String embedVersion = ParamUtil.getString(actionRequest, EMBED_VERSION, "v2");
		String navConfig = ParamUtil.getString(actionRequest, NAV_CONFIG, StringPool.BLANK);
		String validNavConfig = JSONUtil.getFormattedJsonString(navConfig);
		preferences.setValue(API_KEY, apiKey);
		preferences.setValue(EMBED_VERSION, embedVersion);

		if (Validator.isNotNull(validNavConfig)) {
			preferences.setValue(NAV_CONFIG, validNavConfig);
		} else {
			throw new JSONException("Failed to save preference, invalid JSON");
		}

		preferences.store();

		String date = StringPool.BLANK;
		String croneType = StringPool.BLANK;
		String email = StringPool.BLANK;
		String bccEmail = StringPool.BLANK;
		Date scheduleDate = new Date();
		String navConfigStr = preferences.getValue(NAV_CONFIG, StringPool.BLANK);

		try {
			List<SPJobEntry> jobEntryList = SPJobEntryLocalServiceUtil
					.getSPJobEntryByJobNameAndJobClass("Finance Report", SPFinanceDataReport.class.getName());

			for (SPJobEntry jobEntry : jobEntryList) {
				// SchedulerUtil.unschedule(JOB_CLASS_EDM, "Finance
				// Report-"+jobEntry.getSpJobEntryId());
				SPJobEntryLocalServiceUtil.unSchedule("Finance Report", JOB_CLASS_EDM);
				// SPJobEntryLocalServiceUtil.deleteSPJobEntry(jobEntry);
			}
		} catch (Exception e) {
			_log.error(" unable to schedule or delete");
		}

		try {
			JSONObject configObj = JSONFactoryUtil.createJSONObject(navConfigStr);

			JSONArray menuArr = configObj.getJSONArray("menus");
			for (int i = 0; i < menuArr.length(); i++) {
				JSONObject menuObj = menuArr.getJSONObject(i);
				date = menuObj.getString("date");
				croneType = menuObj.getString("mailFrequency");
				email = menuObj.getString("email");
				bccEmail = menuObj.getString("bccEmail");
				_log.debug("date " + date + " croneType " + croneType + " email " + email);
			}
			String format = "dd/MM/yyyy";
			SimpleDateFormat df = new SimpleDateFormat(format);
			if (Validator.isNotNull(date)) {
				scheduleDate = df.parse(date);
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		String cornExp = getCronExp(scheduleDate, croneType);
		Calendar startTime = Calendar.getInstance();
		startTime.setTimeInMillis(scheduleDate.getTime());
		Map<String, Object> jobData = new HashMap<String, Object>();

		jobData.put(SPPeriscopeDataConstant.COMPANY_ID, themeDisplay.getCompanyId());
		jobData.put(SPPeriscopeDataConstant.SCOPE_GROUP_ID, themeDisplay.getScopeGroupId());
		jobData.put(SPPeriscopeDataConstant.USER_ID, themeDisplay.getUserId());
		jobData.put(SPSchedulerConstants.START_DATE, startTime.getTime());
		jobData.put("reportStartDate", "2018-02-13");
		jobData.put("reportEndDate", "2018-02-14");
		jobData.put("mailFrequency", croneType);
		jobData.put("toEmailAddress", email);
		jobData.put("tobccEmailAddress", bccEmail);
		SPJobEntryLocalServiceUtil.schedule(portletId, JOB_CLASS_EDM, "Finance Report", cornExp, "Finance Report",
				jobData);

		_log.debug("cornExp " + cornExp);
		actionResponse.setPortletMode(PortletMode.VIEW);
	}

	public static String getCronExp(Date scheduleDate, String croneType) {

		int dayOfWeek = 1;
		int dayOfMonth = 1;
		Calendar cal = Calendar.getInstance();

		Calendar nextSchdTime = Calendar.getInstance();
		nextSchdTime.setTime(scheduleDate);
		dayOfWeek = nextSchdTime.get(Calendar.DAY_OF_WEEK);
		dayOfMonth = nextSchdTime.get(Calendar.DAY_OF_MONTH);
		_log.debug("dayOfWeek " + dayOfWeek + " dayOfMonth " + dayOfMonth + " scheduleDate " + scheduleDate);
		String cronExp = StringPool.BLANK;

		if (SPPeriscopeDataConstant.CRONE_TYPE_DAILY.equalsIgnoreCase(croneType)) {
			cronExp = getCronExpDailly(cal);
		} else if (SPPeriscopeDataConstant.CRONE_TYPE_WEEKLY.equalsIgnoreCase(croneType)) {
			if (!(dayOfWeek >= 1 && dayOfWeek <= 7)) {
				dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			}
			cronExp = getCronExpWeekly(cal, dayOfWeek);
		} else if (SPPeriscopeDataConstant.CRONE_TYPE_MONTHLY.equalsIgnoreCase(croneType)) {
			String cronExpDayOfMonth = String.valueOf(dayOfMonth);
			if (dayOfMonth == -1) {
				// cron expression to indicate last sunday of month
				cronExpDayOfMonth = "1L";
			} else if (!(dayOfMonth >= 1 && dayOfMonth <= 31)) {
				// if the day does fall in between 1 and 31 then get from job
				// start date
				cronExpDayOfMonth = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
			}
			cronExp = getCronExpMonthly(cal, cronExpDayOfMonth);
		} else if (SPPeriscopeDataConstant.CRONE_TYPE_SEMI_YEARLY.equalsIgnoreCase(croneType)) {
			cal.add(Calendar.DATE, -365);
			cronExp = getCronExpSemiYearly(cal);
		} else if (SPPeriscopeDataConstant.CRONE_TYPE_YEARLY.equalsIgnoreCase(croneType)) {
			cronExp = getCronExpYearly(cal);
		} else if (SPPeriscopeDataConstant.CRONE_TYPE_ONE_TIME.equalsIgnoreCase(croneType)) {
			cronExp = getCronExpOnetime(cal);
		}
		return cronExp;
	}

	// daily crone
	// every day at one'O clock,5th min, 5h sec equalent crop exp 5 5 1 * * ?
	public static String getCronExpDailly(Calendar cal) {
		String exp = StringPool.BLANK;
		cal = (cal == null) ? Calendar.getInstance() : cal;
		String EXP = "%s %s %s * * ?";
		// exp = String.format(EXP, 0, 0, 0);
		// exp=String.format(EXP, cal.get(Calendar.SECOND),
		// cal.get(Calendar.MINUTE), cal.get(Calendar.HOUR_OF_DAY));
		exp = "0 59 23 1/1 * ? *";
		return exp;
	}

	// weekly cron
	// every sunday at one'O clock,5th min, 5h sec equalent crop exp 5 5 1 ? *
	// SUN
	public static String getCronExpWeekly(Calendar cal, int dayOfWeek) {
		String exp = StringPool.BLANK;
		cal = (cal == null) ? Calendar.getInstance() : cal;
		String EXP = "%s %s %s ? * %s";
		exp = String.format(EXP, 0, 59, 23, dayOfWeek);
		return exp;
	}

	// monthly cron
	// 17th of every month at one'O clock,5th min, 5h sec equalent crop exp 5 5
	// 1 17 * ?
	public static String getCronExpMonthly(Calendar cal, String cronExpDayOfMonth) {
		String exp = StringPool.BLANK;
		cal = (cal == null) ? Calendar.getInstance() : cal;
		String EXP = "%s %s %s %s * ?";
		if (cronExpDayOfMonth.toLowerCase().contains("l")) {
			EXP = "%s %s %s ? * %s";
		}
		exp = String.format(EXP, 0, 59, 23, cronExpDayOfMonth);
		return exp;
	}

	// semi-annual cron
	// every 6 months starts from feb 3rd, at one'O clock,5th min, 5h sec
	// equalent crop exp 5 5 1 3 2/6 ?
	public static String getCronExpSemiYearly(Calendar cal) {
		String exp = StringPool.BLANK;
		cal = (cal == null) ? Calendar.getInstance() : cal;
		String EXP = "%s %s %s %s %s/6 ?";
		exp = String.format(EXP, 0, 59, 23, cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1);

		return exp;
	}

	// Yearly cron
	// every year last 5th of july at one'O clock,5th min, 5h sec equalent crop
	// exp 5 5 1 5 7 ? *
	public static String getCronExpYearly(Calendar cal) {
		String exp = StringPool.BLANK;
		cal = (cal == null) ? Calendar.getInstance() : cal;
		String EXP = "%s %s %s %s %s ? *";
		exp = String.format(EXP, 0, 59, 23, cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1);
		return exp;
	}

	public static String getCronExpOnetime(Calendar cal) {
		String exp = StringPool.BLANK;
		cal = (cal == null) ? Calendar.getInstance() : cal;
		String EXP = "%s %s %s %s %s ? %s";
		exp = String.format(EXP, cal.get(Calendar.SECOND), cal.get(Calendar.MINUTE), cal.get(Calendar.HOUR_OF_DAY),
				cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR));
		return exp;
	}
}
