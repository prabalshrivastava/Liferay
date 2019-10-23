package com.sambaash.platform.spperiscopedata.util;

import java.util.Arrays;
import java.util.List;

import javax.portlet.PortletPreferences;

import org.apache.commons.lang.StringUtils;

import com.sambaash.platform.spperiscopedata.SPPeriscopeDataConstant;
import com.sambaash.platform.spperiscopedata.builder.PeriscopedataRequestBuilder;
import com.sambaash.platform.spperiscopedata.builder.PeriscopedataRequestBuilder.APIOptions;

public class PeriscopedataUtil {
	public static final PeriscopedataRequestBuilder getPeriscopedataRequestBuilder(PortletPreferences portletPreferences) {
		return getPeriscopedataRequestBuilder(portletPreferences, 0, null);
	}	
	public static final PeriscopedataRequestBuilder getPeriscopedataRequestBuilder(PortletPreferences portletPreferences, long targetDashboardId, String filtersShown) {		
		
		String apiKey = portletPreferences.getValue(SPPeriscopeDataConstant.API_KEY, "");
		String dashboardId = (targetDashboardId>0) ? String.valueOf(targetDashboardId) : portletPreferences.getValue(SPPeriscopeDataConstant.DASHBOARD_ID, "0");
		String version = portletPreferences.getValue(SPPeriscopeDataConstant.EMBED_VERSION, "v2");
		String visibleFilters = StringUtils.isNotEmpty(filtersShown) 
				? filtersShown 
				: portletPreferences.getValue(SPPeriscopeDataConstant.VISIBLE_FILTER_LIST, "");
		
		PeriscopedataRequestBuilder builder = new PeriscopedataRequestBuilder(apiKey, Long.parseLong(dashboardId));
		if (StringUtils.isNotEmpty(visibleFilters)) {
			List<String> filterList = Arrays.asList(visibleFilters.split(","));
			for (int i=0; i<filterList.size(); i++) {
				filterList.set(i, filterList.get(i).trim());
			}
			String filtersArrStr = "[\"" + StringUtils.join(filterList.toArray(new String[0]),"\",\"") + "\"]";
			builder.setParameter(APIOptions.VISIBLE_FILTERS, filtersArrStr);		
		}
		builder.setParameter(APIOptions.EMBED_VERSION, version);
		
		return builder;
	}
}
