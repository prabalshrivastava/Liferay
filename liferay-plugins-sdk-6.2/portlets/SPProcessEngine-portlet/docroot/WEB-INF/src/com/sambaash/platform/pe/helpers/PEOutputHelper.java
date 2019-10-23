package com.sambaash.platform.pe.helpers;

import java.util.Arrays;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PEError;
import com.sambaash.platform.pe.PEOutput;
import com.sambaash.platform.pe.PERequestData;
import com.sambaash.platform.pe.PESimpleOutput;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.jaxb.PEDataSubmittable;
import com.sambaash.platform.pe.jaxb.PEDisplayable;
import com.sambaash.platform.pe.jaxb.PEProcessableNode;
import com.sambaash.platform.pe.jaxb.PEProcessableNodeOutput;
import com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStage;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType;
import com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStageLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStatusTypeLocalServiceUtil;
public class PEOutputHelper {

	private static Log _log = LogFactoryUtil.getLog(PEOutputHelper.class);
	
	public static final List<String> CURRENT_STEP_STATUSES = Arrays.asList(PEConstantsGlobal.STATUS_STARTED, PEConstantsGlobal.STATUS_INPROGRESS, PEConstantsGlobal.STATUS_OFFLINE);

	public static PEDataSource prepareDataSource(PERequestData requestData, PEProcessState processState) throws PEException, SystemException {
		PEDataSource dataSource = new PEDataSource(requestData, processState);
		return dataSource;
	}

	private PEProcessState processState;
	private PEOutput output = new PEOutput();
	private PEDataSource ds;
	
	private PEOutputHelper(PEDataSource ds) {
		this.processState = ds.getProcessState();
		this.ds = ds;
		output.setProcessState(processState);
		output.setDataSource(ds);
		PEUrlHelper urlHelper = PEUrlHelper.getUrlHelper(ds);//ds.getUrlHelper();
		output.setUrlToListPage(urlHelper.getListingPageUrl());
	}
	
	public static PEOutputHelper getOutputHelper(PEDataSource ds){
		return new PEOutputHelper(ds);
	}

	public void fillAccess() throws SystemException {
		boolean isAgent = ds.isAgentLoggedInUser();
		output.setCanApprove(canApprove());
		output.setAgent(isAgent);
	}

	//check if it is already approved/rejected, if so dont enable the button
	private boolean canApprove() {
		boolean canApprove = false;

		if (PEConstantsGlobal.STATUS_PENDING.equalsIgnoreCase(processState.getStatus())) {
			PEProcessStatusType statusType = ds.getStatusTypeRequested();
			try {
				if(statusType == null){
					if( ds.isCurrentStatusApproverLoggedInUser()){
						canApprove = true;
					}
				}else if (statusType.getSpPEProcessStatusTypeId() == processState.getStatusTypeId() && ds.isCurrentStatusApproverLoggedInUser()) {
					canApprove = true;
				}else {
					// not the current status.. so dont give access to approve
				}
			} catch (SystemException e) {
				_log.error(e);
			}
		}

		return canApprove;
	}
	
	public PEOutput buildOutput(String msg){
		output.setMsg(msg);
		return output;
	}
	public PEOutput buildOutputError(String msg){
		output.addValidationMsg(msg);
		return output;
	}

	
	// buildoutput methods constructs output object required by jsp to display to the user.
	// Hence these methods must not throw any exception and hence while updating PEProcessState, it must be safe update

	public PEOutput buildOutput(PEProcessableNode node) throws SystemException {

		// check if completed process

		if (Validator.isNull(node)) {
			// for node = null
			output = buildOutput(PEErrors.NODE_NOT_FOUND);
		}else if (node.isDisplayable()) {
			fillOutputForDisplayableNode(node);
		}else {
			output = buildOutput(PEErrors.DISPLAYABLE_NOT_FOUND);
		}
		if (!ds.isFirstRequest()) {
			output.setProcessState(processState);
		}

		return output;
	}

	private void fillOutputForDisplayableNode(PEProcessableNode node) throws SystemException {
		if (node.isDisplayable()) {
			// if the node is displayable
			PEDisplayable displayable = (PEDisplayable)node;
			displayable.fillOutput(output);
			
			output.setNodeId(node.getNodeId());
			
			if(node.isDataSubmittable()){
				PEDataSubmittable submittable = (PEDataSubmittable)node;
				PEDataNodePermissnHelper permHelper = PEDataNodePermissnHelper.getInstance(ds, submittable);
				output.setCanEdit(permHelper.canEdit());
				if(PEProcessHelper.canSubmitData(ds, submittable)){
					output.setCanSubmit(true);
					if (PEProcessHelper.isForm(node) || PEProcessHelper.isFormV2(node)) {
						// Applicable only for form. 
						// As of now form builder does not have support for multiple buttons ( like save and submit)
						// So First time when form is submitted, it's always considered as submit.
						output.setAction(PEConstantsGlobal.ACTION_SUBMIT);
					}
				}else{
					String msg = submittable.getWaitMsg();
					msg = Validator.isNotNull(msg) ? msg : "The application yet to complete by concerning person";
					output.setMsg(msg);
				}
				PEProcessAudit audit = PEProcessAuditLocalServiceUtil.getLatestAudit(ds.getProcessState().getSpPEProcessStateId(), node.getNodeId());
				if(audit == null){
					_log.debug("Looks no audit record exist. ProcessStateId="+ds.getProcessState().getSpPEProcessStateId() + " nodeId =" + node.getNodeId());
				}
				output.setAudit(audit);
				fillLastSaveDetails(audit);
			}
			
			fillInfo();
		}
	}

	private void fillInfo() throws SystemException {
		boolean canShowProgress = canShowProcessProgress();

		PEProcess process = ds.getProcess();
		if (canShowProgress || process.isEnableFirstStepProgress()) {
			output.setShowHeader(process.isShowHeader() && ds.getApplicant() != null);
			output.setEnableFirstStepProgress(process.isEnableFirstStepProgress());
			output.setOrientation(process.getOrientation());
			output.setStatusTypes(getProcessStatusTypeList(ds.getStatusTypeRequested()));
			if (ds.getApplicant() != null) {
			output.setFullNameProcessUser(ds.getFullNameApplicant());
			output.setEntityName(ds.getPeEntity().getName());
			output.setEmailProcessUser(ds.getEmailApplicant());
			}
			if (Validator.isNull(ds.getRequestData().getShowProcessProgress()) || ds.getRequestData().getShowProcessProgress().equalsIgnoreCase("1")){
				output.setShowProcessProgress(true);
			}else{
				output.setShowProcessProgress(false);
			}
		}
		
		
		output.setAgent(ds.isAgentLoggedInUser());
	}
	public PEOutput buildOutput(PEError error) {
		error = Validator.isNotNull(error) ? error : PEErrors.NO_OUTPUT;
		output.setError(error);
		updateProcessStateErrorSafe(error);
		output.setProcessState(processState);
		return output;
	}

	private void updateProcessStateErrorSafe(PEError error) {
		if (Validator.isNotNull(error) && !ds.isFirstRequest() ) {
			PEProcessStateHelper.updateErrorSafe(processState, error,ds.getRequestData());
		}
	}

	public static PEOutput buildOutputError(PEError error) {
		PEOutput output = new PEOutput();
		error = Validator.isNotNull(error) ? error : PEErrors.NO_OUTPUT;
		output.setError(error);
		return output;
	}
	public static PEOutput buildOutputError(PEException exception) {
		return buildOutputError(exception.getError());
	}

	// building output using result from processable node

	public PEOutput buildOutputErrorCase(PEProcessableNodeOutput nodeOutput, PEProcessableNode userSubmitedNode) throws SystemException {
		if (nodeOutput.errorExists()) {
			buildOutput(nodeOutput.getError());
			output.setValidationMsgs(nodeOutput.getValidationMsgs());

		}else if (nodeOutput.validationMsgsExists()) {
			output.setValidationMsgs(nodeOutput.getValidationMsgs());
		}

		// it must be displayale

		if (userSubmitedNode.isDisplayable()) {

			// if the node is displayable

			fillOutputForDisplayableNode(userSubmitedNode);
		}else {
			//output = buildOutput(processState,PEErrors.DISPLAYABLE_NOT_FOUND);
		}

		output.setProcessState(processState);
		return output;
	}

	public static boolean isCompletedProcess(PEProcessState processState) {
		//TODO: implementation
		return false;
	}

	public PEOutput buildOutputNearestFormJsp(long statusTypeId) throws SystemException {
		PEProcessStatusType statusType = null;
		try {
			 // get the statustype from master table
			statusType = PEProcessStatusTypeLocalServiceUtil.getPEProcessStatusType(statusTypeId);
		} catch (PortalException e) {
			// status type not found in master table.. handle it
			_log.error("Error while fetching status type",e);
			output.setError(PEErrors.format(PEErrors.PROCESS_STATE_NOT_FOUND_ARGS, statusTypeId));
			return output;
		}
		//return buildOutputNearestFormJsp(statusType);
		return buildOutput(statusType);
	}
	
	public static JSONObject convertToJson(PEOutput output){
		JSONObject response = JSONFactoryUtil.createJSONObject();
		if(output.getError() != null){
			response.put("error",output.getError().getMsg());
		}
		if(output.validationMsgsExists()){
			List<String>msgs = output.getValidationMsgs();
			JSONArray arrayMsgs = JSONFactoryUtil.createJSONArray();
			for (String msg : msgs) {
				arrayMsgs.put(msg);
			}
			response.put("errors", arrayMsgs);
		}
		response.put("successMsg", output.getSucessMsg());
		response.put("data", output.getDataJson());
		return response;
	}

	/**
	 * Build the output object.
	 *
	 * Fetches the form/jsp audit record for given statustypeid and builds the output
	 *
	 * @param statusTypeId
	 * @return
	 * @throws SystemException
	 */
	public PEOutput buildOutput(PEProcessStatusType statusType) throws SystemException {
		
		if (Validator.isNull(statusType)) {
			_log.error("Status type null");
			output.setError(PEErrors.STATUS_TYPE_NOT_FOUND);
			return output;
		}
		
		PEProcessAudit statusTypeAudit = null;
		try {
			statusTypeAudit = PEProcessAuditLocalServiceUtil.findStatusTypeAudit_DisplayNodeIdNotZero(statusType.getSpPEProcessStatusTypeId(), processState.getSpPEProcessStateId());
		} catch (NoSuchPEProcessAuditException e1) {
			_log.error("No audit record forund for statustypeid = " + statusType.getSpPEProcessStatusTypeId() + " process state id = " + processState.getSpPEProcessStateId());
		}
		
		/*if (Validator.isNull(statusTypeAudit)) {
			output.setError(PEErrors.format(PEErrors.AUDIT_NOT_FOUND_STATUS_TYPE_ARGS, statusType.getSpPEProcessStatusTypeId()));
			return output;
		}*/
		if(statusTypeAudit == null){
			if(statusType.getSpPEProcessStatusTypeId() == processState.getStatusTypeId()){
				output.setMsg("Details not available.");
				output.setCanApprove(canApprove());
			}
			fillInfo();
			return output;
		}
		
		
		PEProcessAuditLocalServiceUtil.clearCache();
		// it must be audit record of form/jsp
		PEProcessAudit formJspAudit = PEProcessAuditLocalServiceUtil
				.getLatestAudit(processState.getSpPEProcessStateId(),
						GetterUtil.getLong(statusTypeAudit.getField5()));
		_log.error("Audit record not found for process state id =  " + processState.getSpPEProcessStateId() + " nodeId = " + statusTypeAudit.getField5());
		if (Validator.isNotNull(formJspAudit) && statusTypeAudit.getField5() > 0) {
			return buildOutput(formJspAudit);
		}

		try {
			PEProcessStatusType current = PEProcessStatusTypeLocalServiceUtil.fetchPEProcessStatusType(processState.getStatusTypeId());
			if(statusType.getSeqNo() < current.getSeqNo()){
				output.setMsg(statusType.getStatusName() + " Approved.");
				fillLastSaveDetails(formJspAudit);
			}else{
				output.setCanApprove(canApprove());
			}
			fillInfo();
		} catch (Exception e) {
			_log.error(e);
		}
	
		return output;
	}

	public PEOutput buildOutput(PEProcessAudit formJspAudit) {
		try {
			PEProcessableNode node = ds.getDirectory().getNode(formJspAudit.getNodeId());
			if(Validator.isNull(node)){
				output.setError(PEErrors.ERROR_WHILE_RETRIVING );
				return output;
			}else{
				// default edit action, however if reprocess is set, action should be submit
				String edittableAction = PEConstantsGlobal.ACTION_SAVE;
				if(node.isDataSubmittable()){
					PEDataSubmittable dataSubmittable = (PEDataSubmittable)node;
					dataSubmittable.fillOutput(output);
					output.setFromAudit(true);
					output.setCanApprove(canApprove());
					output.setNodeId(node.getNodeId());
					PEDataNodePermissnHelper permissnHelper = PEDataNodePermissnHelper.getInstance(ds, dataSubmittable);
					output.setCanEdit(permissnHelper.canEdit());
					
					if (permissnHelper.canEdit()){
						output.setCanSubmit(true);
						edittableAction = PEConstantsGlobal.ACTION_SUBMIT;
						if (dataSubmittable.isReprocessable()) {
							// re-process allowed, set action to submit
							output.setReProcessing(true);
						}
					}
				}
				if (PEProcessHelper.isForm(formJspAudit.getType()) || PEProcessHelper.isFormV2(formJspAudit.getType())) {
					output.setStorageId(GetterUtil.getLong(formJspAudit.getStorageId()));
					// Applicable only for form: when it is retrieved from audit it's always save.
					output.setAction(edittableAction);
					// For jsps action is controlled using save/submit buttons.
				}
				output.setAudit(formJspAudit);
				output.setSucessMsg("Success");
				fillLastSaveDetails(formJspAudit);
				fillInfo();
				return output;
			}
		} catch (Exception e) {
			_log.error("Error while fetching ruleset",e);
			output.setError(PEErrors.ERROR_WHILE_RETRIVING );
			return output;
		}
	}
	
	public PEOutput buildOutput(PESimpleOutput simpleOutput){
		output.setError(simpleOutput.getError());
		output.setValidationMsgs(simpleOutput.getValidationMsgs());
		output.setSucessMsg(simpleOutput.getSuccessMsg());
		output.setDataJson(simpleOutput.getData());
		return output;
	}
	
	private void fillLastSaveDetails(PEProcessAudit audit){
		if(audit != null){
			try {
				User user = UserLocalServiceUtil.getUser(GetterUtil.getLong(audit.getDoneBy()));
				output.setLastSaveDoneBy(user);
				output.setLastSaveDateStr(PEHelper.getDateStrddMMYYYYHMS(audit.getCreateDate()));
			} catch (PortalException | SystemException e) {
				_log.error(e);
			}
		}
	}

	private boolean canShowProcessProgress() {
		return !ds.isFirstFormSubmission() && !ds.isFirstRequest();
	}

	public JSONArray getProcessStatusTypeList(PEProcessStatusType statusTypeRequested) throws SystemException {
		JSONArray array = JSONFactoryUtil.createJSONArray();
		PEUrlHelper urlHelper = PEUrlHelper.getUrlHelper(ds);
		try {
			PEProcessStatusType currentStatusType = PEProcessStatusTypeLocalServiceUtil.fetchPEProcessStatusType(processState.getStatusTypeId());

			// as of now, thinking if user in first step(registration) full steps won't be displayed
//			if (currentStatusType == null) {
//				return array;
//			}

			PEAuditStatusRetriveHelper auditRetriever = new PEAuditStatusRetriveHelper(processState);

			// get all statustypes defined for process

			List<PEProcessStatusType> allStatusTypes = PEProcessStatusTypeLocalServiceUtil.findByProcessId(processState
					.getSpPEProcessId());

			JSONObject map;
			int seqNo = 0;
			boolean isCurrent = true;
			boolean initialStep = currentStatusType == null;
			for (PEProcessStatusType statusType : allStatusTypes) {
				if (currentStatusType == null) {
					currentStatusType = statusType;
				}
				map = JSONFactoryUtil.createJSONObject();
				PEProcessAudit auditStatusType = auditRetriever.getAuditRecord(statusType.getSpPEProcessStatusTypeId());

				// checking if statustype is applicable or not.
				// If audit record is not found and user's current status is more than the statustype then the
				// statutype is not applicable

				if (Validator.isNull(auditStatusType) && statusType.getSeqNo() < currentStatusType.getSeqNo()) {
					continue;
				}

				// each step will have one number in sequential order

				seqNo = seqNo + 1;
				map.put("name", statusType.getStatusName());
				map.put("id", statusType.getSpPEProcessStatusTypeId() );
				map.put("seqNo", seqNo);

				// Audit record found, mean it was traversed by user

				if (Validator.isNotNull(auditStatusType)) {
					if (PEConstantsGlobal.STATUS_APPROVED.equalsIgnoreCase(auditStatusType.getField4()) || PEConstantsGlobal.STATUS_REJECTED.equalsIgnoreCase(auditStatusType.getField4()) || PEConstantsGlobal.STATUS_REFUNDED.equalsIgnoreCase(auditStatusType.getField4())) {
						map.put("completed", true);
						map.put("url", urlHelper.getApplicationDisplayUrl(statusType.getSpPEProcessStatusTypeId()));
					}else if (PEConstantsGlobal.STATUS_PENDING.equalsIgnoreCase(auditStatusType.getField4()) &&
							currentStatusType.getSpPEProcessStatusTypeId() == statusType.getSpPEProcessStatusTypeId()){	// checking if the statustype is current
						map.put("completed", false);
						map.put("current", true);
						isCurrent = false;
						map.put("url", urlHelper.getApplicationDisplayUrl(statusType.getSpPEProcessStatusTypeId()));
					}else if(CURRENT_STEP_STATUSES.contains(auditStatusType.getField4()) &&
							currentStatusType.getSpPEProcessStatusTypeId() == statusType.getSpPEProcessStatusTypeId()){
						map.put("completed", false);
						map.put("current", true);
						map.put("url", urlHelper.getApplicationDisplayUrl());
						isCurrent = false;
// these are basically same criteria. So it is handled above by adding them into a list of statuses
//					}else if(PEConstantsGlobal.STATUS_STARTED.equalsIgnoreCase(auditStatusType.getField4()) &&
//							currentStatusType.getSpPEProcessStatusTypeId() == statusType.getSpPEProcessStatusTypeId()){
//						map.put("completed", false);
//						map.put("current", true);
//						map.put("url", urlHelper.getApplicationDisplayUrl());
//						isCurrent = false;
//					}else if(PEConstantsGlobal.STATUS_INPROGRESS.equalsIgnoreCase(auditStatusType.getField4()) &&
//							currentStatusType.getSpPEProcessStatusTypeId() == statusType.getSpPEProcessStatusTypeId()){
//						map.put("completed", false);
//						map.put("current", true);
//						map.put("url", urlHelper.getApplicationDisplayUrl());
//						isCurrent = false;
					}
				}else if (initialStep && ds.isFirstRequest() && isCurrent) {  // initial step (no process state record yet)
					map.put("current", true);
					isCurrent = false;
				}else if (initialStep && !ds.isFirstRequest() && isCurrent) { // next step (no process state record yet)
					map.put("completed", true);
					isCurrent = false;
				}else if (statusType.getSeqNo() < currentStatusType.getSeqNo()) {

					// mean, this step is not applicable to user
					// this case already taken care . checking if statustype is applicable or not.

				}else if (statusType.getSeqNo() > currentStatusType.getSeqNo()) {

					// mean, this step is not yet traversed by  user

					map.put("completed", false);
					// assuming next highet step is possible current step
					if(isCurrent ){
						map.put("current", true);
						map.put("url", urlHelper.getApplicationDisplayUrl());
						isCurrent = false;
					}
				}
				if(auditStatusType == null && (  PEConstantsGlobal.STATUS_STARTED.equalsIgnoreCase(processState.getStatus()) ||
						 PEConstantsGlobal.STATUS_PENDING.equalsIgnoreCase(processState.getStatus() ) || PEConstantsGlobal.STATUS_INPROGRESS.equalsIgnoreCase(processState.getStatus())) &&
						currentStatusType.getSpPEProcessStatusTypeId() == statusType.getSpPEProcessStatusTypeId()){
					map.put("completed", false);
					map.put("current", true);
					map.put("url", urlHelper.getApplicationDisplayUrl());
					isCurrent = false;
				}

				if (statusTypeRequested != null && statusTypeRequested.getSpPEProcessStatusTypeId() == statusType.getSpPEProcessStatusTypeId()) {
					map.put("requestedStatusType", true);
				}

				// stage info
				try {
					PEProcessStage stage = PEProcessStageLocalServiceUtil.getPEProcessStage(statusType.getSpPEProcessStageId());
					map.put("style",JSONFactoryUtil.createJSONObject(stage.getStyle()));
				} catch (Exception e) {
					_log.error("Error while getting process staage. stage Id " + statusType.getSpPEProcessStageId());
				}

				array.put(map);
			}

		}catch (Exception ex) {
			_log.error(ex);
		}

		return array;
	}

	public PEOutput getOutput() {
		return output;
	}

	public void setOutput(PEOutput output) {
		this.output = output;
	}
}