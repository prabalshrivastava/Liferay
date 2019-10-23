package com.sambaash.platform.pe.helpers;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.jaxb.PEDataSubmittable;
import com.sambaash.platform.pe.jaxb.PEProcessableNode;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.util.SambaashUtil;

/**
 * This class can be used to determine if the form/jsp is editable for logged in
 * user. Edit settings are configured in process diagram for each form/jsp node.
 * Edit settings will have set of rules. Form/Jsp is editable only if any one
 * rule is satisfied.
 * 
 * Each rule contains one or more conditions along with role's who can edit. One
 * such condition is allowing edit in given status types.
 * 
 * 
 * @author nareshchebolu
 *
 */
public class PEDataNodePermissnHelper {

	private final PEDataSource ds;
	private final PEDataSubmittable node;

	private PEDataNodePermissnHelper(PEDataSource ds, PEDataSubmittable node) {
		this.ds = ds;
		this.node = node;
	}

	public static PEDataNodePermissnHelper getInstance(PEDataSource ds, PEDataSubmittable node) {
		return new PEDataNodePermissnHelper(ds, node);
	}

	public boolean canEdit() {
		long lostStageId = GetterUtil
				.getLong(SambaashUtil.getParameter(PEConstantsGlobal.SP_PARAM_CLOSED_LOST_STAGE_ID, 0));
		final PEProcessState processState = ds.getProcessState();
		if (PEProcessStateHelper.isRejectedApplicaiton(processState) || processState.getClosedStageId() > 0
				|| !PEProcessStateHelper.isActiveApplicaiton(processState)) {
			return false;
		}
		// new process state
		if (processState.getNodeId() == 0 || processState.isNew()) {
			if (PEProcessHelper.canSubmitData(ds, node)) {
				return true;
			}
			return false;
		} else if (node.isReprocessable()) {
			// node can be re-processed, hence make editable
			return true;
		}

		// For current node, submit permission overrides edit rules
		PEProcessableNode currentNode = ds.getDirectory().getNode(processState.getNodeId());
		if (node.getNodeId() == currentNode.getNodeId()) {
			if (PEProcessHelper.canSubmitData(ds, node)) {
				return true;
			} else {
				return false;
			}
		}

		boolean canEdit = false;
		if (Validator.isNotNull(node.getEditConfiguration())) {
			try {
				JSONArray rules = JSONFactoryUtil.createJSONArray(node.getEditConfiguration());
				for (int i = 0; i < rules.length(); i++) {
					JSONObject rule = rules.getJSONObject(i);

					if (Validator.isNull(rule.getString("conditions"))) {
						continue;
					}

					JSONArray conditions = JSONFactoryUtil.createJSONArray(rule.getString("conditions"));
					if (conditions.length() == 0) {
						continue;
					}

					boolean result = true;
					for (int j = 0; j < conditions.length(); j++) {
						JSONObject condition = conditions.getJSONObject(j);
						String type = condition.getString("fieldName");
						if (PEConstants.EDIT_CONDITION_STATUS_TYPE.equalsIgnoreCase(type)) {
							result = result && checkStatusType(condition);
						}
					}

					if (result) {
						JSONArray roles = JSONFactoryUtil.createJSONArray(rule.getString("roleIds"));
						for (int j = 0; j < roles.length(); j++) {
							long roleId = roles.getLong(j);
							if (UserLocalServiceUtil.hasRoleUser(roleId, ds.getLoggedInUserId())) {
								canEdit = true;
								break;
							}
						}
					}
				}
			} catch (JSONException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			}
		}
		return canEdit;
	}

	/**
	 * To check allowed status types. When application is in one of the status
	 * types specified then edit will be allowed
	 * 
	 * @param condition
	 * @return
	 */
	private boolean checkStatusType(JSONObject condition) {
		try {
			JSONArray types = JSONFactoryUtil.createJSONArray(condition.getString("statusType"));
			PEProcessState processState = ds.getProcessState();
			for (int i = 0; i < types.length(); i++) {
				String status = types.getString(i);
				if (Validator.isNotNull(status)) {
					String details[] = status.split(StringPool.DASH);
					long statusTypeId = GetterUtil.getLong(details[0]);
					String statusStr = details[1];
					if (processState.getStatusTypeId() == statusTypeId
							&& processState.getStatus().equalsIgnoreCase(statusStr)) {
						return true;
					}
				}
			}

		} catch (Exception e) {
			_log.error(e);
		}
		return false;
	}

	private static final Log _log = LogFactoryUtil.getLog(PEDataNodePermissnHelper.class);
}
