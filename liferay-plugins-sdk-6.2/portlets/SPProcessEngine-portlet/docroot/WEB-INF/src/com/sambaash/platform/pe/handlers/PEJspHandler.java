package com.sambaash.platform.pe.handlers;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PESimpleOutput;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.jaxb.PEJSP;
import com.sambaash.platform.pe.jaxb.PEProcessableNodeOutput;
import com.sambaash.platform.pe.jsp.PEJSPHelper;
import com.sambaash.platform.pe.jsp.PEJSPRegistry;

/**
 *  Action : Submit
 *  This class handles submit actions from jsp pages.
 *  
 *  Submit let the flow go to the next next node. Whereas save just save's the data and current node Id won't be changed
 * @author nareshchebolu
 *
 */
public class PEJspHandler extends PEMultiOutputNodeHandlerImpl {

	public PEJspHandler(PEJSP node, PEDataSource ds) {
		super(node, ds);
	}

	@Override
	public PEProcessableNodeOutput process() {
		PEProcessableNodeOutput output = new PEProcessableNodeOutput();
		try {
			PEJSP jsp = (PEJSP)node;
			PEJSPHelper jspHelper = PEJSPRegistry.getRegistry().getJspHelper(ds, jsp);
			if(ds.isSubmitRequest() || ds.isForceSubmit()){
				// This is to tag the jsp to the status type.
				ds.setNodeIdDataSubmitted(jsp.getNodeId());

				//saving logic , including validations
				PESimpleOutput simpleOutput = null;
				if(jspHelper != null){
					simpleOutput = jspHelper.save();
				}
				// checking for errors
				if(simpleOutput.errorExists() || simpleOutput.validationMsgsExists()){
					output.setError(simpleOutput.getError());
					output.setValidationMsgs(simpleOutput.getValidationMsgs());
					return output;
				}
				// Everyithing ok.. Next node to proceed
				long nextNodeId = determineNextNodeId(jsp);
				proceedToNextNode(output, nextNodeId);
			} else if(jspHelper.isExternalDataSubmission()){
				boolean traversed = jspHelper.isCompleted();
				if(traversed){
					
					// this case can happen if submit is handled by external system and we can not determin the submit action.
					jspHelper.extraCallBackAfterSubmit();
					jspHelper.auditExternalDataSubmission();
					output.setCanProceedToNext(jspHelper.isCompleted());
					long nextNodeId = determineNextNodeId(jsp);
					proceedToNextNode(output, nextNodeId, false);
				}else{
					output.setCanProceedToNext(false);
				}
			} else{
				// looks this node not yet traversed.
				output.setCanProceedToNext(false);
			}
		}catch (Exception ex) {
			output = new PEProcessableNodeOutput();
			output.setError(PEErrors.AUDIT_JSP);
			_log.error("Error while auditing form submit ", ex);
		}
		return output;
	}

	private long determineNextNodeId(PEJSP jsp) throws PortalException, SystemException {
		long nextNodeId;
		if (PEConstants.RULE_VERSION_2.equals(jsp.getRuleVersion())) {
			nextNodeId = getNextNodeIdV2(processState, ds);
		} else {
			nextNodeId = getNextNodeId(processState, ds);
		}
		return nextNodeId;
	}

	private static Log _log = LogFactoryUtil.getLog(PEJspHandler.class);

}