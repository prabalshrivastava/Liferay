package com.sambaash.platform.pe.actions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.course.enroll.CourseEnrollEsignEngine;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.jaxb.PECustomActionNode;
import com.sambaash.platform.pe.jaxb.PEJSP;

/**
 * This action is used to convert one application of one process to another
 * process
 * 
 * Configuration data takes below format { nodeId: 1 }
 * 
 * @author aishwarya
 *
 */
public class EsignPackageGenerationAction extends PECustomActionImpl {

	public EsignPackageGenerationAction(PEDataSource ds,
			PECustomActionNode actionNode) {
		super(ds, actionNode);
	}

	@Override
	public PEActionResult perform() {

		JSONObject config;
		try {
			if (Validator.isNotNull(actionNode.getConfiguration())) {
				config = JSONFactoryUtil.createJSONObject(actionNode
						.getConfiguration());

				long jspNodeId = config.getLong("nodeId");
				PEJSP jsp = (PEJSP) ds.getDirectory().getNode(jspNodeId);
				CourseEnrollEsignEngine esignEngine = new CourseEnrollEsignEngine(
						ds, jsp);
				PEProcessStateDataAdapter processStateDataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(ds.getProcessState());
				processStateDataAdapter.store("isContractReleased","true");
				// this call generates the package. We wanted package to be
				// generated upfront before going to jsp page
				esignEngine.getSignInUrl();
			} else {
				return getActionResultFailure("Error while generating contract. Invalid Configuration data");
			}
		} catch (SystemException | PortalException | PEException e) {
			_log.error(e);
			return getActionResultFailure("Error while generating contract. Invalid Configuration data");
		}

		return getActionResultSuccess();
	}

	private static Log _log = LogFactoryUtil
			.getLog(EsignPackageGenerationAction.class.getName());
}
