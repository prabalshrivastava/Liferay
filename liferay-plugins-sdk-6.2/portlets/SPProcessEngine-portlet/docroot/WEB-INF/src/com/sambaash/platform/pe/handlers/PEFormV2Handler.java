package com.sambaash.platform.pe.handlers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.adapter.PEFormDataAdapter;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.constants.PEAuditConstants;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.helpers.PEAuditHelper;
import com.sambaash.platform.pe.helpers.PERuleSetHelper;
import com.sambaash.platform.pe.jaxb.PEDataMapping;
import com.sambaash.platform.pe.jaxb.PEDataMappingElement;
import com.sambaash.platform.pe.jaxb.PEFormV2;
import com.sambaash.platform.pe.jaxb.PEProcessableNodeOutput;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalServiceUtil;

/**
 *  Used to just handle form V2 submission
 *  This class also executes the rules associated with the form to decide 
 *  next node in the flow.
 *
 */
public class PEFormV2Handler extends PEMultiOutputNodeHandlerImpl {
	private static final Log LOGGER = LogFactoryUtil.getLog(PEFormV2Handler.class);

	public PEFormV2Handler(PEFormV2 node, PEDataSource ds) {
		super(node, ds);
	}

	@Override
	public PEProcessableNodeOutput process() {
		PEFormV2 form = (PEFormV2)node;
		PEProcessableNodeOutput output = new PEProcessableNodeOutput();
		try {
			// responsible only submit type requests
			if(ds.isSubmitRequest()){
				
				// This is used tag the current form to status type. 
				ds.setNodeIdDataSubmitted(form.getNodeId());
				// Save the form data to process state
				long rulesetId = form.getRuleSetId();
				long formId = PERuleSetHelper.getFormV2Id(rulesetId);
				PEFormDataAdapter formDataAdapter = ds.getFormDataAdapter();
//				if (formDataAdapter.fetchFormData(formId)==null) {
//					formDataAdapter.registerFormData(String.valueOf(formId), JSONFactoryUtil.createJSONObject(ds.getFormJspData()));					
//				}
				saveData(form, formId, ds);

				// Get the next possible node in the flow. 
				long nextNodeId = getNextNodeIdV2(processState, ds);
				proceedToNextNode(output, nextNodeId);
				// form processing is done. Make CanProceedToNext to true.
//				output.setCanProceedToNext(true);
				// Next node to process
//				output.setNextNodeId(nextNodeId);
				
				// Audit the form submission
				PEAuditHelper auditHelper = ds.getAuditHelper();
				PEProcessAudit formAudit = auditHelper.createAuditFormV2Submit(formId, rulesetId, formDataAdapter.getFormStorageId(formId), node.getNodeId(),formDataAdapter.fetchFormData(formId).toString());
				auditHelper.updateAudit(formAudit);
			}else{
				// the current form not yet traversed. So make CanProceedToNext to false.
				long draftStorageId = retrieveDraftStorageId();
				if (draftStorageId > 0) {
					output.setDraftStorageId(draftStorageId);
				}
				output.setCanProceedToNext(false);
			}
			
		}catch (Exception ex) {
			output = new PEProcessableNodeOutput();
			output.setError(PEErrors.FORM_SAVE_ERROR);
			LOGGER.error("Error while processing form submit ", ex);
		}
		return output;
	}

	private long retrieveDraftStorageId() {
		try {
			PEFormV2 form = (PEFormV2)node;
			PEProcessAudit draftAudit = PEProcessAuditLocalServiceUtil.findByProcessStateIdNodeIdAction(ds.getProcessState().getSpPEProcessStateId(), form.getNodeId(), PEAuditConstants.ACTION_SAVE);
			return draftAudit.getStorageId();			
		} catch (Exception e) {
			return -1;
		}
	}
	
	// saving configured form fields to processstate. These fields probably accessed by some other steps in the process
	public static void saveData(PEFormV2 form, long formId,PEDataSource ds)
			throws JSONException {
		PEDataMapping data = form.getDataMapping();
		PEFormDataAdapter formDataAdapter = ds.getFormDataAdapter();
		PEProcessState processState = ds.getProcessState();
		PEProcessStateDataAdapter processDataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(processState);
		if (data != null) {

			List<PEDataMappingElement> elmnts = data.getElmnts();

			if (elmnts != null && !elmnts.isEmpty()) {
				
				Map<String,String>dataMap = new LinkedHashMap<>();
				for (PEDataMappingElement elmnt :elmnts) {
					String fieldName = elmnt.getProcessFieldId();
					String value = formDataAdapter.getDataFromFormV2(formId, elmnt.getFieldId());
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

}