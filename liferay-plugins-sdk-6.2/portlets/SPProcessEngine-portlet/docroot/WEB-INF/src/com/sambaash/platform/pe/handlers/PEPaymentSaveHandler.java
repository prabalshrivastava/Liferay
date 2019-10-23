package com.sambaash.platform.pe.handlers;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PEOutput;
import com.sambaash.platform.pe.PESimpleOutput;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.helpers.PEDataNodePermissnHelper;
import com.sambaash.platform.pe.helpers.PEOutputHelper;
import com.sambaash.platform.pe.jaxb.PEJSP;
import com.sambaash.platform.pe.jaxb.PEPayment;
import com.sambaash.platform.pe.jsp.PEJSPHelper;
import com.sambaash.platform.pe.jsp.PEJSPRegistry;
import com.sambaash.platform.pe.payment.PEPaymentHelper;
import com.sambaash.platform.srv.processbuilder.model.PERuleSet;
import com.sambaash.platform.srv.processbuilder.service.PERuleSetLocalServiceUtil;

/**
 * Action: Save
 * 
 * This class handles saving of the data submitted from jsp pages.
 * 
 * Check {@link PEFormSaveHandler} for handling data submitted from forms ( formloader)
 * 
 */
public class PEPaymentSaveHandler {


	private PEDataSource ds;
	private PEPayment paymentNode;
	
	public static PEPaymentSaveHandler getInstance(PEDataSource ds,PEPayment paymentNode){
		return new PEPaymentSaveHandler(ds,paymentNode);
	}
	
	private PEPaymentSaveHandler(PEDataSource ds,PEPayment paymentNode) {
		this.paymentNode = paymentNode;
		this.ds = ds;
	}

	public PEOutput save() throws SystemException, PEException{

		// Checking permissions for saving
		PEDataNodePermissnHelper helper = PEDataNodePermissnHelper.getInstance(ds, paymentNode);
		boolean canEdit  = helper.canEdit();
		if(!canEdit){
			throw new PEException(PEErrors.FORM_JSP_SAVE_ERROR_UNAUTHORIZED);
		}
		
		//Dispatch the request to respective JSP save handler
		PEPaymentHelper jspHelper = new PEPaymentHelper(ds, paymentNode);
		PESimpleOutput simpleOutput = jspHelper.save();
		
		return PEOutputHelper.getOutputHelper(ds).buildOutput(simpleOutput);
	}
	
	private static Log _log = LogFactoryUtil.getLog(PEPaymentSaveHandler.class);

}
