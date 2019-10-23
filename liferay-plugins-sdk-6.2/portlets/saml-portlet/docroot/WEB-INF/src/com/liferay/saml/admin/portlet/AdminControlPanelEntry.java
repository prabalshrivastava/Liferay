/**
 * 
 */
package com.liferay.saml.admin.portlet;

import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.BaseControlPanelEntry;

/**
 * @author William Berks
 *
 */
public class AdminControlPanelEntry extends BaseControlPanelEntry {

	/* (non-Javadoc)
	 * @see com.liferay.portlet.ControlPanelEntry#isVisible(com.liferay.portal.security.permission.PermissionChecker, com.liferay.portal.model.Portlet)
	 */
	//@Override
	public boolean isVisible(PermissionChecker permissionChecker, Portlet portlet)
			throws Exception {
		
		return permissionChecker.isOmniadmin();
	}

}
