package com.sambaash.platform.spperiscopedata;

public class SPPeriscopeDataConstant {
	public static final String API_KEY 				= "api_key";
	public static final String EMBED_VERSION	 	= "embed_version";
	public static final String DASHBOARD_ID 		= "dashboard_id";
	public static final String VISIBLE_FILTER_LIST 	= "visible_filter_list";
	public static final String FRAME_WIDTH 			= "frame_width";
	public static final String FRAME_HEIGHT 		= "frame_height";
	public static final String NAV_CONFIG 			= "nav_config";
	
	public static final String DASHBOARD_URL 		= "dashboard_url";
	
	public static final String DRILLDOWN_NOTIFICATION= "drilldown_notification";
	public static final String DRILLDOWN_EVENT 		= "drilldown";
	public static final String DRILLDOWN_TARGET		= "destination_dashboard_id";
	public static final String DRILLDOWN_PARAMS		= "filter_values";
	public static final String DRILLDOWN_FILTER_NAME= "filter_name";
	public static final String DRILLDOWN_FILTER_VALUE= "column_value";
	
	public static final String CRONE_TYPE_ONE_TIME = "oneTime";
	public static final String CRONE_TYPE_DAILY = "daily";
	public static final String CRONE_TYPE_WEEKLY = "weekly";
	public static final String CRONE_TYPE_MONTHLY = "monthly";
	public static final String CRONE_TYPE_SEMI_YEARLY = "semiAnnual";
	public static final String CRONE_TYPE_YEARLY = "yearly";

	// every day at one'O clock,5th min, 5h sec
	public static final String CRONE_EXP_DAILY = "%s %s %s * * ?";
	public static final String CRONE_EXP_WEEKLY = "%s %s %s ? * SUN";
	public static final String CRONE_EXP_MONTHLY = "%s %s %s ? * 1L";
	public static final String CRONE_EXP_SEMI_ANNUAL = "%s %s %s ? 1/6 1L";
	public static final String CRONE_EXP_YEARLY = "%s %s %s ? 1 1L *";
	
	public static final String COMPANY_ID = "companyId";
	public static final String SCOPE_GROUP_ID = "scopeGroupId";
	public static final String USER_ID = "userId";
}
