package com.sambaash.platform.portlet.pe.helper;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletMode;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.sambaash.platform.pe.constants.PEConstants;

public class ProcessStateDisplayHelper {

	public static String getDisplayUrlProcessState(PortletRequest request, long processStateId,
			long requestedStatusTypeId) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		// create application view url

		String url = StringPool.BLANK;
		try {
			PortletURL portletURL = PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request),
					themeDisplay.getPlid(), PortletRequest.ACTION_PHASE);
			portletURL.setWindowState(LiferayWindowState.MAXIMIZED);
			portletURL.setPortletMode(LiferayPortletMode.VIEW);
			portletURL.setParameter(PEConstants.PARAM_PROCESS_STATE_ID, String.valueOf(processStateId));
			portletURL.setParameter(PEConstants.PARAM_STATUS_TYPE_ID, String.valueOf(requestedStatusTypeId));
			portletURL.setParameter("javax.portlet.action", "displayProcessState");
			url = portletURL.toString();
		} catch (Exception ex) {
			_log.error("Error while construcing process state view url ", ex);
		}

		return url;
	}

	private static Log _log = LogFactoryUtil.getLog(ProcessStateDisplayHelper.class);

}