package com.sambaash.platform.pe.handlers;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.helpers.PEAuditHelper;
import com.sambaash.platform.pe.jaxb.PEEntityNode;
import com.sambaash.platform.pe.jaxb.PEProcessableNodeOutput;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;

public class PEEntityHandler extends PESingleOutputNodeHandler {

	private static Log _log = LogFactoryUtil.getLog(PEEntityHandler.class);

	public PEEntityHandler(PEEntityNode node, PEDataSource ds) {
		super(node, ds);
	}

	@Override
	public PEProcessableNodeOutput process() throws SystemException, PEException {
		PEEntityNode entityNode = (PEEntityNode)node;
		
		PEProcessableNodeOutput output = new PEProcessableNodeOutput();
		
		long sourceClassId = ds.getProcess().getEntityClassId();
		long sourceEntityID = ds.getProcessState().getEntityId();
		
		// check if state was already updated, then use current state info
		Long updatedClassId = ds.getProcessState().getSourceClassId();
		if (updatedClassId != null && updatedClassId > 0) {
			sourceClassId = ds.getProcessState().getEntityClassId();
		}

		try {
			updateProcessAuditEntity(entityNode, ds, sourceClassId, sourceEntityID);
			updateProcessStateEntity(entityNode, ds, sourceClassId, sourceEntityID);			
		} catch (Exception e) {
			_log.error(e);
			throw new PEException("Unable to update process entity");
		}
		
		try {
			PEAuditHelper audit = ds.getAuditHelper();
			audit.logEntityChange(String.valueOf(sourceClassId), String.valueOf(sourceEntityID), entityNode.getType(), entityNode.getIdentifier(), entityNode.getNodeId());
		}catch (Exception ex) {
			output.setError(PEErrors.AUDIT_STATUS);
		}

//		output.setNextNodeId(entityNode.getNextNodeId());
//		output.setCanProceedToNext(true);
		proceedToNextNode(output, entityNode.getNextNodeId());
		return output;
	}

	private void updateProcessAuditEntity(PEEntityNode apiNode, PEDataSource ds, long sourceClassId, long sourceEntityID) throws SystemException 
	{
		PEProcessState state = ds.getProcessState();
		List<PEProcessAudit> auditList = PEProcessAuditLocalServiceUtil.findByProcessStateId(state.getSpPEProcessStateId());
		for (PEProcessAudit audit: auditList) {
			audit.setSourceClassId(sourceClassId);
			audit.setSourceEntityID(sourceEntityID);
			audit.setEntityClassId(Long.parseLong(apiNode.getType()));
			audit.setEntityId(Long.parseLong(apiNode.getIdentifier()));
			PEProcessAuditLocalServiceUtil.updatePEProcessAudit(audit);
		}
	}

	private void updateProcessStateEntity(PEEntityNode apiNode, PEDataSource ds, long sourceClassId, long sourceEntityID) throws SystemException 
	{
		PEProcessState state = ds.getProcessState();
		state.setSourceClassId(sourceClassId);
		state.setSourceEntityID(sourceEntityID);
		state.setEntityClassId(Long.parseLong(apiNode.getType()));
		state.setEntityId(Long.parseLong(apiNode.getIdentifier()));
		PEProcessStateLocalServiceUtil.updatePEProcessState(state);
	}

}