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
import com.sambaash.platform.pe.jaxb.PEPaymentV2;
import com.sambaash.platform.pe.payment.PEPaymentV2Helper;

/**
 * Action: Save
 * 
 * This class handles saving of the data submitted from jsp pages.
 * 
 * Check {@link PEFormSaveHandler} for handling data submitted from forms ( formloader)
 * 
 */
public class PEPaymentV2SaveHandler {


	private PEDataSource ds;
	private PEPaymentV2 paymentNode;
	
	public static PEPaymentV2SaveHandler getInstance(PEDataSource ds,PEPaymentV2 paymentNode){
		return new PEPaymentV2SaveHandler(ds,paymentNode);
	}
	
	private PEPaymentV2SaveHandler(PEDataSource ds,PEPaymentV2 paymentNode) {
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
		PEPaymentV2Helper jspHelper = new PEPaymentV2Helper(ds, paymentNode);
		PESimpleOutput simpleOutput = jspHelper.save();
		
		return PEOutputHelper.getOutputHelper(ds).buildOutput(simpleOutput);
	}
	
	private static Log _log = LogFactoryUtil.getLog(PEPaymentV2SaveHandler.class);

}
