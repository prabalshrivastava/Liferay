package com.sambaash.platform.pe.handlers;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PESimpleOutput;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.jaxb.PEPaymentV2;
import com.sambaash.platform.pe.jaxb.PEProcessableNodeOutput;
import com.sambaash.platform.pe.payment.PEPaymentV2Helper;

/**
 *  Action : Submit
 *  This class handles submit actions from payment jsp page.
 *  
 *  Submit let the flow go to the next next node. Whereas save just save's the data and current node Id won't be changed
 *
 */
public class PEPaymentV2Handler extends PEMultiOutputNodeHandlerImpl {

	public PEPaymentV2Handler(PEPaymentV2 node, PEDataSource ds) {
		super(node, ds);
	}

	@Override
	public PEProcessableNodeOutput process() {
		PEProcessableNodeOutput output = new PEProcessableNodeOutput();
		try {
			PEPaymentV2 payNode = (PEPaymentV2)node;
			PEPaymentV2Helper payHelper = new PEPaymentV2Helper(ds, payNode);
			if(ds.isSubmitRequest() || ds.isForceSubmit()){
				_log.debug("PEPaymentV2Handler submit handler started.");
				// This is to tag the jsp to the status type.
				ds.setNodeIdDataSubmitted(payNode.getNodeId());

				//saving logic , including validations
				PESimpleOutput simpleOutput = null;
				simpleOutput = payHelper.save();
				
				// checking for errors
				if(simpleOutput.errorExists() || simpleOutput.validationMsgsExists()){
					output.setError(simpleOutput.getError());
					output.setValidationMsgs(simpleOutput.getValidationMsgs());
					return output;
				}
				// Everything ok.. Next node to proceed
				long nextNodeId = getNextNodeIdV2(processState, ds);
				proceedToNextNode(output, nextNodeId);
//				output.setNextNodeId(nextNodeId);
//				output.setCanProceedToNext(true);
				_log.debug("PEPaymentV2Handler submit handler done.");
			} else{
				// looks this node not yet traversed.
				output.setCanProceedToNext(false);
			}
		}catch (Exception ex) {
			output = new PEProcessableNodeOutput();
			output.setError(PEErrors.AUDIT_PAYMENT);
			_log.error("Error while auditing payment submit ", ex);
		}
		return output;
	}

	private static Log _log = LogFactoryUtil.getLog(PEPaymentV2Handler.class);

}