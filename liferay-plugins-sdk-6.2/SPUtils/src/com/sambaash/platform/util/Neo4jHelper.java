package com.sambaash.platform.util;

import java.net.InetAddress;

import com.liferay.portal.model.VirtualHost;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.VirtualHostLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.model.spneo4j.form.BaseGraphForm;

public class Neo4jHelper {

	public static String getVirtualHost(Long companyId, Long groupId,
			Long layoutSetId) {
		String virtualHostName = "default";

		try {

			try {
				if (layoutSetId == -1L) {
					layoutSetId = LayoutSetLocalServiceUtil.getLayoutSet(
							groupId, false).getLayoutSetId();
				}
				VirtualHost virtualHost = VirtualHostLocalServiceUtil
						.getVirtualHost(companyId, 0);
				virtualHostName = virtualHost.getHostname();
			} catch (Exception e) {
				System.err.println("Error while getting vitual host "
						+ e.getMessage() + ", returning hostname ");
				// using hostname for dev env where virtual host is not set
				virtualHostName = "hostname - "
						+ InetAddress.getLocalHost().getHostName();
			}
		} catch (Exception e) {
			System.err.println("Error2 while getting vitual host "
					+ e.getMessage() + ", returning default ");

		}
		return virtualHostName;
	}

	public static void fillMandatoryFields(BaseGraphForm baseGraphObj,
			ThemeDisplay themeDisplay) {
		fillMandatoryFields(baseGraphObj, themeDisplay.getCompanyId(),
				themeDisplay.getScopeGroupId(), themeDisplay.getLayoutSet()
						.getLayoutSetId());
	}

	public static void fillMandatoryFields(BaseGraphForm baseGraphObj,
			Long companyId, Long groupId, Long layoutSetId) {
		String communityName = SambaashUtil.getCommunityName(groupId);

		baseGraphObj.setCommunityName(communityName);
		baseGraphObj.setGroupId(groupId);
//		baseGraphObj.setVirtualHost(getVirtualHost(companyId, groupId,
//				layoutSetId));
		baseGraphObj.setVirtualHost(getVirtualHost(companyId, groupId, 0L));
		baseGraphObj.setServerName(SambaashUtil.getParameter("sp-server-name", 0));
	}

}
