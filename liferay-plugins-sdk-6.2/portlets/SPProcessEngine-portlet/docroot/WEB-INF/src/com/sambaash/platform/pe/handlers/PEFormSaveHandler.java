package com.sambaash.platform.pe.handlers;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PEError;
import com.sambaash.platform.pe.PEOutput;
import com.sambaash.platform.pe.adapter.PEFormDataAdapter;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.helpers.PEAuditHelper;
import com.sambaash.platform.pe.helpers.PEDataNodePermissnHelper;
import com.sambaash.platform.pe.helpers.PEOutputHelper;
import com.sambaash.platform.pe.jaxb.PEForm;
import com.sambaash.platform.pe.jaxb.PEProcessableNodeOutput;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
import com.sambaash.platform.srv.processbuilder.model.PERuleSet;
import com.sambaash.platform.srv.processbuilder.service.PERuleSetLocalServiceUtil;
/**
 *  Used to just save the date submitted from form node.
 *  This class wont execute the rules to decide next node as it is just save operation.
 *  
 *  Form submit handled by PEFormHandler which also decides the next node.
 *  
 * 
 * @author nareshchebolu
 *
 */
public class PEFormSaveHandler  {

	private PEDataSource ds;
	private PEForm form;
	
	public static PEFormSaveHandler getInstance(PEDataSource ds,PEForm form){
		return new PEFormSaveHandler(ds,form);
	}
	
	private PEFormSaveHandler(PEDataSource ds,PEForm form) {
		this.form = form;
		this.ds = ds;
	}

	public PEOutput save() throws PEException, SystemException, JSONException {
		// Checking permissions for saving
		PEDataNodePermissnHelper helper = PEDataNodePermissnHelper.getInstance(ds, form);
		boolean canEdit  = helper.canEdit();
		if(!canEdit){
			throw new PEException(PEErrors.FORM_JSP_SAVE_ERROR_UNAUTHORIZED);
		}
		
		// Save the form data to process state
		long rulesetId = form.getRuleSetId();
		PERuleSet ruleset = PERuleSetLocalServiceUtil.fetchPERuleSet(rulesetId);
		PEFormHandler.saveData(form, GetterUtil.getLong(ruleset.getComponentId()),ds);
		
		// Audit the form submission
		PEFormDataAdapter formDataAdapter = ds.getFormDataAdapter();
		PEAuditHelper auditHelper = ds.getAuditHelper();
		PEProcessAudit formAudit = auditHelper.createAuditFormSave(rulesetId, formDataAdapter.getFormStorageId(ruleset), form.getNodeId(),formDataAdapter.fetchFormData(ruleset).toString());
		formAudit = auditHelper.updateAudit(formAudit);
		
		// Building output 
		PEOutputHelper outputHelper = PEOutputHelper.getOutputHelper(ds);
		PEOutput output = outputHelper.buildOutput(formAudit);
		output.setSucessMsg("Form has been saved successfully");
		return output;
	}
	private static Log _log = LogFactoryUtil.getLog(PEFormSaveHandler.class);
}