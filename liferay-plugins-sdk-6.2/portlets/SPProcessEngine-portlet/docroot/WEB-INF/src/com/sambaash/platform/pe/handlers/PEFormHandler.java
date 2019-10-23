package com.sambaash.platform.pe.handlers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.adapter.PEFormDataAdapter;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.helpers.PEAuditHelper;
import com.sambaash.platform.pe.jaxb.PEDataMapping;
import com.sambaash.platform.pe.jaxb.PEDataMappingElement;
import com.sambaash.platform.pe.jaxb.PEForm;
import com.sambaash.platform.pe.jaxb.PEProcessableNodeOutput;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.model.PERuleSet;
import com.sambaash.platform.srv.processbuilder.service.PERuleSetLocalServiceUtil;

/**
 *  Used to just handle form submission
 *  This class also executes the rules associated with the form to decide 
 *  next node in the flow.
 *  
 * @author nareshchebolu
 *
 */
public class PEFormHandler extends PEMultiOutputNodeHandlerImpl {

	public PEFormHandler(PEForm node, PEDataSource ds) {
		super(node, ds);
	}

	@Override
	public PEProcessableNodeOutput process() {
		PEForm form = (PEForm)node;
		PEProcessableNodeOutput output = new PEProcessableNodeOutput();
		try {
			// responsible only submit type requests
			if(ds.isSubmitRequest()){
				
				// Get the next possible node in the flow. 
				long nextNodeId = getNextNodeId(processState, ds);
				// This is used tag the current form to status type. 
				ds.setNodeIdDataSubmitted(form.getNodeId());
				// Save the form data to process state
				long rulesetId = form.getRuleSetId();
				PERuleSet ruleset = PERuleSetLocalServiceUtil.fetchPERuleSet(rulesetId);
				saveData(form, GetterUtil.getLong(ruleset.getComponentId()),ds);
				
				proceedToNextNode(output, nextNodeId);
				// form processing is done. Make CanProceedToNext to true.
//				output.setCanProceedToNext(true);
				// Next node to process
//				output.setNextNodeId(nextNodeId);
				
				// Audit the form submission
				PEFormDataAdapter formDataAdapter = ds.getFormDataAdapter();
				PEAuditHelper auditHelper = ds.getAuditHelper();
				PEProcessAudit formAudit = auditHelper.createAuditFormSubmit(rulesetId, formDataAdapter.getFormStorageId(ruleset), node.getNodeId(),formDataAdapter.fetchFormData(ruleset).toString());
				auditHelper.updateAudit(formAudit);
			}else{
				// the current form not yet traversed. So make CanProceedToNext to false.
				output.setCanProceedToNext(false);
			}
			
		}catch (Exception ex) {
			output = new PEProcessableNodeOutput();
			output.setError(PEErrors.FORM_SAVE_ERROR);
			_log.error("Error while processing form submit ", ex);
		}
		return output;
	}

	// saving configured form fields to processstate. These fields probably accessed by some other steps in the process
	public static void saveData(PEForm form, long formId,PEDataSource ds)
			throws JSONException {
		PEDataMapping data = form.getDataMapping();
		PEFormDataAdapter formDataAdapter = ds.getFormDataAdapter();
		PEProcessState processState = ds.getProcessState();
		PEProcessStateDataAdapter processDataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(processState);
		if (data != null) {

			List<PEDataMappingElement> elmnts = data.getElmnts();

			if (elmnts != null && !elmnts.isEmpty()) {
				
				Map<String,String>dataMap = new LinkedHashMap<String, String>();
				//long formId = GetterUtil.getLong(ruleset.getComponentId());
				for (PEDataMappingElement elmnt :elmnts) {
					String fieldName = elmnt.getProcessFieldId();
					String value = formDataAdapter.getDataFromForm(formId, elmnt.getFieldId());
					dataMap.put(fieldName, value);
				}
				processDataAdapter.store(dataMap);
				
			}
		}
		
		if (ds.isFirstFormSubmission()){
			String enableTempStorageValidation = ds.getRequestData().getEnableTempStorageValidation();
			processDataAdapter.store(PEConstants.ENABLE_TEMP_STORAGE_VALIDATION, enableTempStorageValidation);
			
			String programmeCode = ds.getRequestData().getProgrammeCode();
			processDataAdapter.store("programmeCode", programmeCode);
			
			String processStateId = String.valueOf(processState.getSpPEProcessStateId());
			processDataAdapter.store("processStateId", processStateId);
			
			String userIdProcess = String.valueOf(processState.getUserIdProcess());
			processDataAdapter.store("userIdProcess", userIdProcess);
		}
		
		String scheduleModelId = String.valueOf(ds.getProcess().getScheduleModelId());
		processDataAdapter.store("scheduleModelId", scheduleModelId);
	}

	private static Log _log = LogFactoryUtil.getLog(PEFormHandler.class);

}