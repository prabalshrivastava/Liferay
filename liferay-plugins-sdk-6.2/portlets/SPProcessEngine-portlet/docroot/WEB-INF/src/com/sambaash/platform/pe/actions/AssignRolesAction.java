package com.sambaash.platform.pe.actions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.jaxb.PECustomActionNode;

/**
 * This action is used to convert one application of one process to another
 * process
 * 
 * Configuration data takes below format { roleNames: [ "ICT Mentor",
 * "Group Creator" ] }
 * 
 * @author aishwarya
 *
 */
public class AssignRolesAction extends PECustomActionImpl {

	public AssignRolesAction(PEDataSource ds, PECustomActionNode actionNode) {
		super(ds, actionNode);
	}

	@Override
	public PEActionResult perform() {

		JSONObject config;
		try {
			if (Validator.isNotNull(actionNode.getConfiguration())) {
				config = JSONFactoryUtil.createJSONObject(actionNode
						.getConfiguration());

				JSONArray roleNamesArray = config.getJSONArray("roleNames");
				for (int i = 0; i < roleNamesArray.length(); i++) {
					Role role = RoleLocalServiceUtil.getRole(ds.getCompanyId(),
							roleNamesArray.getString(i));
					UserLocalServiceUtil.addRoleUsers(role.getRoleId(),
							new long[] { ds.getProcessState()
									.getUserIdProcess() });
				}

			} else {
				return getActionResultFailure("Error while assigning role. Invalid Configuration data");
			}
		} catch (SystemException | PortalException e) {
			_log.error(e);
			return getActionResultFailure("Error while assigning role. Invalid Configuration data");
		}

		return getActionResultSuccess();
	}

	private static Log _log = LogFactoryUtil.getLog(AssignRolesAction.class
			.getName());
}
