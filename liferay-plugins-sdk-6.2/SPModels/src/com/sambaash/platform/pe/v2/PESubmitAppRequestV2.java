package com.sambaash.platform.pe.v2;

import java.util.Map;
import javax.portlet.PortletRequest;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

public class PESubmitAppRequestV2 {
	private final long nodeId;
	private final long processId;
 	private final long entityId;
 	private final long userId;
 	private boolean supressMailNotifications;
 	private final long entityClassId;
 	private final Map<Long, JSONObject> formDataByNodeMap;
 	private final ThemeDisplay themeDisplay;
 	private final PortletRequest request;
 	private boolean enableSingleSubmission;
 	
 	public PESubmitAppRequestV2(PortletRequest request, long nodeId, long userId,long processId, long entityId, Map<Long, JSONObject> formDataByNodeMap, long entityClassId){
 		this.nodeId = nodeId;
 		this.userId = userId;
 		this.processId = processId;
 		this.entityId = entityId;
 		this.entityClassId = entityClassId;
 		this.formDataByNodeMap = formDataByNodeMap;
 		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
 		this.themeDisplay = themeDisplay;
 		this.request = request;
 	}

	public long getEntityClassId() {
		return entityClassId;
	}

	public long getProcessId() {
		return processId;
	}

	public long getEntityId() {
		return entityId;
	}

	
	public long getUserId() {
		return userId;
	}

	public boolean isSupressMailNotifications() {
		return supressMailNotifications;
	}

	public void setSupressMailNotifications(boolean supressMailNotifications) {
		this.supressMailNotifications = supressMailNotifications;
	}

	public ThemeDisplay getThemeDisplay() {
		return themeDisplay;
	}

	public long getNodeId() {
		return nodeId;
	}

	public Map<Long, JSONObject> getFormDataByNodeMap() {
		return formDataByNodeMap;
	}

	public PortletRequest getRequest() {
		return request;
	}

	public boolean isEnableSingleSubmission() {
		return enableSingleSubmission;
	}

	public void setEnableSingleSubmission(boolean enableSingleSubmission) {
		this.enableSingleSubmission = enableSingleSubmission;
	}
	
}
