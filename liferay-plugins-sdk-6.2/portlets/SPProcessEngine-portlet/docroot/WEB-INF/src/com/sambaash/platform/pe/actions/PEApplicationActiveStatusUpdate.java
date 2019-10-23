package com.sambaash.platform.pe.actions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.jaxb.PECustomActionNode;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;

/**
 * This action is used to update activeStatus of current application.
 * Usually used for making the application InActive in case
 * we want to allow user to submit another application when
 * "Enable Single Submission" is set.
 * Like in Admission when Candidate did not meet criteria initially.
 * Then he can submit new Admission again later.
 * Hence, default configuration is set to activeStatus = 0.
 * 
 * Configuration { "activeStatus" : 1 || 0 }
 *
 */
public class PEApplicationActiveStatusUpdate extends PECustomActionImpl {
	private static final Log LOGGER = LogFactoryUtil.getLog(PEApplicationActiveStatusUpdate.class);

	public PEApplicationActiveStatusUpdate(PEDataSource ds, PECustomActionNode actionNode) {
		super(ds, actionNode);
	}

	@Override
	public PEActionResult perform() {

		JSONObject config;
		try {
			PEProcessState processState = ds.getProcessState();
			if (Validator.isNotNull(actionNode.getConfiguration())) {
				config = JSONFactoryUtil.createJSONObject(actionNode
						.getConfiguration());
				int activeStatus = config.getInt("activeStatus");
				LOGGER.info(String.format("Attempting to set active status of application %d to %d", processState.getSpPEProcessStateId(), activeStatus));
				processState.setActiveStatus(activeStatus);
				PEProcessStateLocalServiceUtil.updatePEProcessState(processState);
				processState = PEProcessStateLocalServiceUtil.clearCacheAndGetProcessState(processState);
				Indexer indexer = IndexerRegistryUtil.getIndexer(PEProcessState.class.getName());
				indexer.reindex(processState);
				ds.setProcessState(processState);
				LOGGER.info(String.format("Updated application %d to activeStatus %d", processState.getSpPEProcessStateId(), activeStatus));
			} else {
				return getActionResultFailure(String.format("Error while updating active status of application %d", processState.getSpPEProcessStateId()));
			}
		} catch (SystemException | PortalException e) {
			LOGGER.error(e);
			return getActionResultFailure("Error while updating active status. Invalid Configuration data");
		}

		return getActionResultSuccess();
	}

}
