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
import com.sambaash.platform.pe.jsp.PEJSPHelper;
import com.sambaash.platform.pe.jsp.PEJSPRegistry;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
import com.sambaash.platform.srv.processbuilder.model.PERuleSet;
import com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PERuleSetLocalServiceUtil;

/**
 * Action: Save
 * 
 * This class handles saving of the data submitted from jsp pages.
 * 
 * Check {@link PEFormSaveHandler} for handling data submitted from forms ( formloader)
 * 
 * @author nareshchebolu
 *
 */
public class PEJSPSaveHandler {


	private PEDataSource ds;
	private PEJSP jspNode;
	
	public static PEJSPSaveHandler getInstance(PEDataSource ds,PEJSP jspNode){
		return new PEJSPSaveHandler(ds,jspNode);
	}
	
	private PEJSPSaveHandler(PEDataSource ds,PEJSP jspNode) {
		this.jspNode = jspNode;
		this.ds = ds;
	}

	public PEOutput save() throws SystemException, PEException{

		// Checking permissions for saving
		PEDataNodePermissnHelper helper = PEDataNodePermissnHelper.getInstance(ds, jspNode);
		boolean canEdit  = helper.canEdit();
		if(!canEdit){
			throw new PEException(PEErrors.FORM_JSP_SAVE_ERROR_UNAUTHORIZED);
		}
		
		long rulesetId = jspNode.getRuleSetId();
		PERuleSet ruleset = PERuleSetLocalServiceUtil.fetchPERuleSet(rulesetId);
		PESimpleOutput simpleOutput = null;
		//Dispatch the request to respective JSP save handler
		PEJSPHelper jspHelper = PEJSPRegistry.getRegistry().getJspHelper(ruleset, ds, jspNode);
		PEOutput output;
		if(jspHelper != null){
			simpleOutput = jspHelper.save();
			PEProcessAudit audit = PEProcessAuditLocalServiceUtil.findLatestByProcessStateIdNodeId(ds.getProcessState().getSpPEProcessStateId(), jspNode.getNodeId());
			output = PEOutputHelper.getOutputHelper(ds).buildOutput(audit);
		}else{
			_log.error("No handler for saving JSP ComponentId=" + ruleset.getComponentId() + ". RulesetId="+rulesetId);
			output = PEOutputHelper.buildOutputError(PEErrors.JSP_SAVE_ERROR_NO_HANDLER);
		}
		
		
		return output;
	}
	
	private static Log _log = LogFactoryUtil.getLog(PEJSPSaveHandler.class);

}
