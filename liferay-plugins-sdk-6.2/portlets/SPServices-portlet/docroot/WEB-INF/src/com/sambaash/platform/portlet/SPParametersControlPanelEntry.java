package com.sambaash.platform.portlet;

import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.BaseControlPanelEntry;


/**
 * Control panel entry class SPParametersControlPanelEntry
 */
public class SPParametersControlPanelEntry extends BaseControlPanelEntry {

    @Override
    public boolean isVisible(PermissionChecker permissionChecker, Portlet portlet)
            throws Exception {
        return true;
    }

}