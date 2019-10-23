package com.sambaash.platform.spdashboard.helper;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.deploy.DeployManagerUtil;
import com.liferay.portal.kernel.plugin.PluginPackage;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.spdashboard.model.SPDashboardChild;
import com.sambaash.platform.spdashboard.model.SPDashboardRow;

public class SPDashboardHelper {

	public Collection<SPDashboardRow> readConfig(PortletRequest request) {
		Map<String, String[]> prefMap = request.getPreferences().getMap();
		Map<Integer, SPDashboardRow> configObjs = new HashMap<Integer, SPDashboardRow>();
		for (Entry<String, String[]> entry : prefMap.entrySet()) {
			String key = entry.getKey();
			// read main row
			if (key.startsWith("label_row")) {
				String mainRowId = key.split("_")[1];
				Integer index = GetterUtil.getInteger(key.replaceAll(
						"[a-z\\-_]", ""));
				SPDashboardRow row = configObjs.get(index);
				if (Validator.isNull(row)) {
					row = new SPDashboardRow();
					configObjs.put(index, row);
				}
				row.setLabel(entry.getValue()[0]);
				row.setIconUrl(prefMap.get("icon_" + mainRowId)[0]);
				row.setUrl(prefMap.get("url_" + mainRowId)[0]);
				row.setPortletWarName(prefMap.get("portlet_" + mainRowId)[0]);
				row.setPosition(GetterUtil.getInteger(prefMap.get("position_"
						+ mainRowId)[0]));
				String string = prefMap.get("role_" + mainRowId)[0];
				row.setRoleIds(GetterUtil.getLongValues(string.split(",")));
				configObjs.put(index, row);
			} else if (key.startsWith("cfglabel_row")) {
				// read child row
				String mainRowId = key.split("_")[1];
				String childRowId = key.split("_")[2];
				Integer rowIndex = GetterUtil.getInteger(mainRowId.replaceAll(
						"[a-z\\-_]", ""));
				SPDashboardRow spDashboardRow = configObjs.get(rowIndex);
				if (Validator.isNull(spDashboardRow)) {
					spDashboardRow = new SPDashboardRow();
					configObjs.put(rowIndex, spDashboardRow);
				}
				String rowId = mainRowId + "_" + childRowId;
				SPDashboardChild childRow = new SPDashboardChild();
				childRow.setLabel(entry.getValue()[0]);
				childRow.setChartType(GetterUtil.getInteger(prefMap
						.get("cfgtype_" + rowId)[0]));
				childRow.setUrl(prefMap.get("cfgurl_" + rowId)[0]);
				childRow.setAnalyticsId(GetterUtil.getLong(prefMap
						.get("cfganalytics_" + rowId)[0]));
				spDashboardRow.addChild(childRow);
			}
		}
		return configObjs.values();
	}

	public static Map<String, String> getDeployedApps() {
		List<PluginPackage> installedPluginPackages = DeployManagerUtil
				.getInstalledPluginPackages();
		Map<String, String> portletIds = new HashMap<String, String>();
		for (PluginPackage pluginPackage : installedPluginPackages) {
			if (!pluginPackage.getTypes().contains("portlet"))
				continue;
			portletIds.put(pluginPackage.getContext(), pluginPackage.getName());
		}
		return portletIds;
	}

}
