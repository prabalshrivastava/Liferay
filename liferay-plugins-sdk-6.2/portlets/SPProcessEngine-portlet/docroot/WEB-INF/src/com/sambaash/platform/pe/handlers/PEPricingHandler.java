package com.sambaash.platform.pe.handlers;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PESimpleOutput;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.jaxb.PEPricing;
import com.sambaash.platform.pe.jaxb.PEProcessableNodeOutput;
import com.sambaash.platform.pe.pricing.PEPricingHelper;
import com.sambaash.platform.srv.processbuilder.model.PERuleSet;
import com.sambaash.platform.srv.processbuilder.service.PERuleSetLocalServiceUtil;

/**
 *  Action : Submit
 *  This class handles submit actions from pricing jsp page.
 *  
 *  Submit let the flow go to the next next node. Whereas save just save's the data and current node Id won't be changed
 *
 */
public class PEPricingHandler extends PEMultiOutputNodeHandlerImpl {

	private static Log _log = LogFactoryUtil.getLog(PEPricingHandler.class);

	public PEPricingHandler(PEPricing node, PEDataSource ds) {
		super(node, ds);
	}

	@Override
	public PEProcessableNodeOutput process() {
		PEProcessableNodeOutput output = new PEProcessableNodeOutput();
		try {
			PEPricing pricingNode = (PEPricing)node;
			PEPricingHelper pricingHelper = new PEPricingHelper(ds, pricingNode);
			if(ds.isSubmitRequest() || ds.isForceSubmit()){
				_log.debug("PEPricingHandler submit handler started.");
				// This is to tag the jsp to the status type.
				ds.setNodeIdDataSubmitted(pricingNode.getNodeId());

				//saving logic , including validations
				PESimpleOutput simpleOutput = new PESimpleOutput();
				if(pricingHelper != null && !pricingHelper.isCompleted()){
					simpleOutput = pricingHelper.save();
				}
				// checking for errors
				if(simpleOutput.errorExists() || simpleOutput.validationMsgsExists()){
					output.setError(simpleOutput.getError());
					output.setValidationMsgs(simpleOutput.getValidationMsgs());
					return output;
				}
				proceedToNextNode(output, pricingNode.getNextNodeId());
//				output.setNextNodeId(pricingNode.getNextNodeId());
//				output.setCanProceedToNext(true);
				PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(ds.getProcessState());
				dataAdapter.store("_lastPricingNodeSubmitted_", String.valueOf(pricingNode.getNodeId()));
				_log.debug("PEPricingHandler submit handler done.");
			} else{
				// looks this node not yet traversed.
				output.setCanProceedToNext(false);
			}
		}catch (Exception ex) {
			output = new PEProcessableNodeOutput();
			output.setError(PEErrors.AUDIT_PRICING);
			_log.error("Error while auditing pricing submit ", ex);
		}
		return output;
	}

}