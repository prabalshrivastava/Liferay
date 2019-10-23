package com.sambaash.platform.pe.handlers;

import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.jaxb.PEProcessableNodeOutput;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
public abstract class PENodeHandlerImpl implements PENodeHandler {
	public PENodeHandlerImpl(PEDataSource ds) {
		this.ds = ds;
		this.processState = ds.getProcessState();
	} 
	
	protected PEProcessState processState;

	protected PEDataSource ds;

	// default handling with consideration of re-processing
	protected void proceedToNextNode(PEProcessableNodeOutput output, long nextNodeId) {
		proceedToNextNode(output, nextNodeId, true);
	}	
	protected void proceedToNextNode(PEProcessableNodeOutput output, long nextNodeId, boolean proceedToEnabled) {
		PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(ds.getProcessState());
		boolean isReprocessing = Boolean.parseBoolean(dataAdapter.getDataFromProcessState(PEConstants.PE_REPROCESSING));
		if (isReprocessing && !ds.getDirectory().getNode(nextNodeId).isReprocessable()) {
			// is re-processing but next node is not marked for re-processing
			if (proceedToEnabled) { output.setCanProceedToNext(false); }
			output.addValidationMsg(PEConstants.REPROCESSING_STOPPED_MSG);
			// remove re-processing state
			dataAdapter.store(PEConstants.PE_REPROCESSING, "false");
		} else {
			if (proceedToEnabled) { output.setCanProceedToNext(true); }
			output.setNextNodeId(nextNodeId);
		}
	}
}