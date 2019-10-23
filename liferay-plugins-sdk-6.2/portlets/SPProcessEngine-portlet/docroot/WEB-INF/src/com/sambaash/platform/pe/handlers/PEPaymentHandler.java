package com.sambaash.platform.pe.handlers;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.model.payment.ChargeStatus;
import com.sambaash.platform.model.payment.exception.PaymentException;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PESimpleOutput;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.jaxb.PEJSP;
import com.sambaash.platform.pe.jaxb.PEPayment;
import com.sambaash.platform.pe.jaxb.PEProcessableNodeOutput;
import com.sambaash.platform.pe.jsp.PEJSPHelper;
import com.sambaash.platform.pe.jsp.PEJSPRegistry;
import com.sambaash.platform.pe.payment.PEPaymentHelper;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.model.PERuleSet;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PERuleSetLocalServiceUtil;
import com.sambaash.platform.srv.sppayment.service.SPPaymentLocalServiceUtil;

/**
 *  Action : Submit
 *  This class handles submit actions from payment jsp page.
 *  
 *  Submit let the flow go to the next next node. Whereas save just save's the data and current node Id won't be changed
 *
 */
public class PEPaymentHandler extends PEMultiOutputNodeHandlerImpl {

	public PEPaymentHandler(PEPayment node, PEDataSource ds) {
		super(node, ds);
	}

	@Override
	public PEProcessableNodeOutput process() {
		PEProcessableNodeOutput output = new PEProcessableNodeOutput();
		try {
			PEPayment payNode = (PEPayment)node;
			PERuleSet ruleset = PERuleSetLocalServiceUtil.fetchPERuleSet(payNode.getRuleSetId());
			PEPaymentHelper payHelper = new PEPaymentHelper(ds, payNode);
			if(ds.isSubmitRequest() || ds.isForceSubmit()){
				_log.debug("PEPaymentHandler submit handler started.");
				// This is to tag the jsp to the status type.
				ds.setNodeIdDataSubmitted(payNode.getNodeId());

				//saving logic , including validations
				PESimpleOutput simpleOutput = null;
				if(payHelper != null){
					simpleOutput = payHelper.save();
				}
				// checking for errors
				if(simpleOutput.errorExists() || simpleOutput.validationMsgsExists()){
					output.setError(simpleOutput.getError());
					output.setValidationMsgs(simpleOutput.getValidationMsgs());
					return output;
				}
				// Everything ok.. Next node to proceed
				long nextNodeId = getNextNodeId(processState, ds);
				proceedToNextNode(output, nextNodeId);
//				output.setNextNodeId(nextNodeId);
//				output.setCanProceedToNext(true);
				_log.debug("PEPaymentHandler submit handler done.");
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

	private static Log _log = LogFactoryUtil.getLog(PEPaymentHandler.class);

}