package com.sambaash.platform.portlet.sproles.action;

import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.BaseControlPanelEntry;
public class RoleMappingControlPanelEntry extends BaseControlPanelEntry {

	@Override
	public boolean isVisible(PermissionChecker permissionChecker, Portlet portlet)
			throws Exception {
		return false;
	}

}