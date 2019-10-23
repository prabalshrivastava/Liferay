package com.sambaash.platform.pe.handlers;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PEOutput;
import com.sambaash.platform.pe.adapter.PEFormDataAdapter;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.helpers.PEAuditHelper;
import com.sambaash.platform.pe.helpers.PEDataNodePermissnHelper;
import com.sambaash.platform.pe.helpers.PEOutputHelper;
import com.sambaash.platform.pe.helpers.PERuleSetHelper;
import com.sambaash.platform.pe.jaxb.PEFormV2;
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
public class PEFormV2SaveHandler  {

	private PEDataSource ds;
	private PEFormV2 form;
	
	public static PEFormV2SaveHandler getInstance(PEDataSource ds,PEFormV2 form){
		return new PEFormV2SaveHandler(ds,form);
	}
	
	private PEFormV2SaveHandler(PEDataSource ds,PEFormV2 form) {
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
		long formId = PERuleSetHelper.getFormV2Id(rulesetId);
		PEFormV2Handler.saveData(form, formId,ds);
		
		// Audit the form submission
		PEFormDataAdapter formDataAdapter = ds.getFormDataAdapter();
		PEAuditHelper auditHelper = ds.getAuditHelper();
		PEProcessAudit formAudit = auditHelper.createAuditFormV2Save(formId, rulesetId, formDataAdapter.getFormStorageId(formId), form.getNodeId(),formDataAdapter.fetchFormData(formId).toString());
		formAudit = auditHelper.updateAudit(formAudit);

		// Building output 
		PEOutputHelper outputHelper = PEOutputHelper.getOutputHelper(ds);
		PEOutput output = outputHelper.buildOutput(formAudit);
		output.setSucessMsg("Form has been saved successfully");
		return output;
	}
	private static Log _log = LogFactoryUtil.getLog(PEFormV2SaveHandler.class);
}