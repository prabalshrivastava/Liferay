package com.sambaash.platform.pe;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.xml.bind.JAXBException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.cache.PEProcessCache;
import com.sambaash.platform.pe.cache.PEProcessDirectory;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.exception.PEConfigException;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.exception.PEProcessStateException;
import com.sambaash.platform.pe.handlers.PEFormSaveHandler;
import com.sambaash.platform.pe.handlers.PEFormV2SaveHandler;
import com.sambaash.platform.pe.handlers.PEJSPSaveHandler;
import com.sambaash.platform.pe.helpers.PEAuditHelper;
import com.sambaash.platform.pe.helpers.PEHelper;
import com.sambaash.platform.pe.helpers.PEOutputHelper;
import com.sambaash.platform.pe.helpers.PEProcessHelper;
import com.sambaash.platform.pe.helpers.PEProcessStateHelper;
import com.sambaash.platform.pe.jaxb.PEDataSubmittable;
import com.sambaash.platform.pe.jaxb.PEForm;
import com.sambaash.platform.pe.jaxb.PEFormV2;
import com.sambaash.platform.pe.jaxb.PEJSP;
import com.sambaash.platform.pe.jaxb.PENodeSubType;
import com.sambaash.platform.pe.jaxb.PEProcessableNode;
import com.sambaash.platform.pe.jaxb.PEProcessableNodeOutput;
import com.sambaash.platform.pe.jsp.PEJSPHelper;
import com.sambaash.platform.pe.jsp.PEJSPRegistry;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStatusTypeLocalServiceUtil;
import com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
public class ProcessEngineImpl implements ProcessEngine {

	private static Log _log = LogFactoryUtil.getLog(ProcessEngineImpl.class);

	@Override
	public PEOutput executeByProcessStateId(long processStateId, long requestedStatusTypeId, PortletRequest request,
			PortletResponse response) throws SystemException {
		_log.debug("processStateId = " + processStateId + "requestedprocessStateId" + requestedStatusTypeId);
		PEProcessState processState = null;
		PEOutput output = null;
		try {
			processState = PEProcessStateLocalServiceUtil.getPEProcessState(processStateId);
			PERequestData requestData = PERequestData.getRequestData(request);
			return execute(processState, requestedStatusTypeId, requestData,request,response);
		} catch (PortalException e) {
			output = PEOutputHelper.buildOutputError(PEErrors.format(PEErrors.PROCESS_STATE_NOT_FOUND_ARGS,
					processStateId));
			return output;
		}
	}

	@Override
	public PEOutput executeByProcessStateId(long processStateId, long requestedStatusTypeId, PERequestData requestData) throws SystemException {
		_log.debug("processStateId = " + processStateId + "requestedprocessStateId" + requestedStatusTypeId);
		PEProcessState processState = null;
		PEOutput output = null;
		try {
			processState = PEProcessStateLocalServiceUtil.getPEProcessState(processStateId);
			return execute(processState, requestedStatusTypeId, requestData);
		} catch (PortalException e) {
			output = PEOutputHelper.buildOutputError(PEErrors.format(PEErrors.PROCESS_STATE_NOT_FOUND_ARGS,
					processStateId));
			return output;
		}
	}

	/**
	 *Classpk,processId and themedisplay.getUserid sufficient to create processstate .
	 *
	 */
	@Override
	public PEOutput executeByEntityIdProcessId(long entityClassId,long entityId, long processId, long requestedStatusTypeId,
			PortletRequest request, PortletResponse response) throws SystemException {
		PEProcessState processState = null;
		PEOutput output = null;
		PEProcess process = null;

		_log.debug("classpk = " + entityId + " process id = "+processId);
		try {
			PEProcessDirectory dirc = PEProcessCache.getInstance().getProcessDirectory(processId);

			if (Validator.isNull(dirc)) {
				output = PEOutputHelper.buildOutputError(PEErrors.CONFIG_ERROR_PROCESS_DEFINITON);
				return output;
			}

			process = dirc.getProcess();
		} catch (PEConfigException | JAXBException e) {
			_log.error(e);
			output = PEOutputHelper.buildOutputError(PEErrors.CONFIG_ERROR_PROCESS_DEFINITON);
			return output;
		}

		// Guest processstate will have userIdProcess value zero. CreateAccount
		// action is responsible for updating processState to have actual userId
		// who is owning the process

		PERequestData requestData = PERequestData.getRequestData(request);
		try {
			processState = PEProcessStateHelper.getProcessState(entityClassId,entityId, process, requestData);
		} catch (PEException e) {
			return PEOutputHelper.buildOutputError(e);
		}
		output = execute(processState, requestedStatusTypeId, requestData);
		output.setClassPk(entityId);
		output.setProcessId(processId);
		output.setClassNameId(processState.getEntityClassId());
		return output;
	}
	/**
	 *Classpk,processId and themedisplay.getUserid sufficient to create processstate .
	 *
	 */
	@Override
	public PEOutput executeByEntityIdProcessId(long entityClassId,long entityId, long processId,long requestedStatusTypeId,PERequestData requestData) throws SystemException {
		PEProcessState processState = null;
		PEOutput output = null;
		PEProcess process = null;
		
		_log.debug("classpk = " + entityId + " process id = "+processId);
		try {
			PEProcessDirectory dirc = PEProcessCache.getInstance().getProcessDirectory(processId);
			
			if (Validator.isNull(dirc)) {
				output = PEOutputHelper.buildOutputError(PEErrors.CONFIG_ERROR_PROCESS_DEFINITON);
				return output;
			}
			
			process = dirc.getProcess();
		} catch (PEConfigException | JAXBException e) {
			_log.error(e);
			output = PEOutputHelper.buildOutputError(PEErrors.CONFIG_ERROR_PROCESS_DEFINITON);
			return output;
		}
		
		// Guest processstate will have userIdProcess value zero. CreateAccount
		// action is responsible for updating processState to have actual userId
		// who is owning the process
		
		try {
			processState = PEProcessStateHelper.getProcessState(entityClassId,entityId, process, requestData);
		} catch (PEException e) {
			return PEOutputHelper.buildOutputError(e);
		}
		output = execute(processState, requestedStatusTypeId, requestData);
		output.setClassPk(entityId);
		output.setProcessId(processId);
		output.setClassNameId(processState.getEntityClassId());
		return output;
	}
	
	@Override
	public PEOutput execute(PEProcessState processState, long requestedStatusTypeId, PERequestData requestData)  {
		// Initializing the required data
		boolean lockObtained = PEProcessStateHelper.obtainLock(processState,requestData);
		if(lockObtained){
			if(!processState.isNew()){
				processState = PEProcessStateLocalServiceUtil.clearCacheAndGetProcessState(processState);
			}
			try {
				return executeEngine(processState,requestedStatusTypeId,requestData,null,null);
			} catch (SystemException e) {
				PEOutput output = PEOutputHelper.buildOutputError(PEErrors.SYSTEM_ERROR);
				return output;
			}finally{
				PEProcessStateHelper.unLockApplicationAndSave(processState, requestData);
			}
		}else{
			return PEOutputHelper.buildOutputError(PEErrors.UNABLE_TO_GET_LOCK);
		}
				
	}
	
	@Override
	public PEOutput execute(PEProcessState processState, long requestedStatusTypeId, PERequestData requestData,PortletRequest request,PortletResponse response)  {
		// Initializing the required data
		boolean lockObtained = PEProcessStateHelper.obtainLock(processState,requestData);
		if(lockObtained){
			if(!processState.isNew()){
				processState = PEProcessStateLocalServiceUtil.clearCacheAndGetProcessState(processState);
			}
			try {
				return executeEngine(processState,requestedStatusTypeId,requestData,request, response);
			} catch (SystemException e) {
				PEOutput output = PEOutputHelper.buildOutputError(PEErrors.SYSTEM_ERROR);
				return output;
			}finally{
				PEProcessStateHelper.unLockApplicationAndSave(processState, requestData);
			}
		}else{
			return PEOutputHelper.buildOutputError(PEErrors.UNABLE_TO_GET_LOCK);
		}
				
	}

	private PEOutput executeEngine(PEProcessState processState, long requestedStatusTypeId, PERequestData requestData,PortletRequest request,PortletResponse response) throws SystemException {

		PEProcessStatusType statusTypeRequested = null;
		PEOutput output = null;
		PEProcessableNodeOutput nodeOutput = null;
		PEDataSource dataSource = null; // PEHelper.prepareDataSource(request,

										// response);

		long nodeIdReceived = requestData.getNodeIdReceived();
		PEProcessDirectory directory = null;
		PEProcess process = null;
		PEOutputHelper outputHelper = null;
		boolean initial = false;
		boolean firstFormSubmission = false;
		PEProcessableNode nodeToProcess = null;
		boolean isDataNodeFromUser = false;

		try {

			// TODO: Always check if process got unpublished. if so don't let
			// new users to become part of process/ if unpublished existing
			// users remain can follow the process.. but no more new entries.

			dataSource = PEOutputHelper.prepareDataSource(requestData, processState);
			directory = dataSource.getDirectory();// PEProcessCache.getInstance().getProcessDirectory(processState.getPEProcessId());
			process = directory.getProcess();
			outputHelper = PEOutputHelper.getOutputHelper(dataSource);
			//request.setAttribute(PEConstants.ATTR_DATA_SOURCE, dataSource);
			
			_log.error("Processs Id for debugging purpose in case any error : " + process.getSpPEProcessId()
			+ " : processStateId : " + processState.getSpPEProcessStateId());
			
		} catch (PEException e) {
			output = PEOutputHelper.buildOutputError(PEErrors.CONFIG_ERROR_PROCESS_DEFINITON);
			return output;
		}
		
		// check for authorization.. 
	/*	if(!PEProcessHelper.canRunProcessEngine(requestData.getUser(), dataSource)){
			output = PEOutputHelper.buildOutputError(PEErrors.UNAUTHORIZED_USER);
			return output;
		}*/


		
		// check for closed/won or lost
		if(processState.getClosedStageId() > 0){
			
			if(requestedStatusTypeId > 0){
				output  = outputHelper.buildOutputNearestFormJsp(requestedStatusTypeId);
				return output;
			}else{
				//application is closed, so cant move ahead
				output  = outputHelper.buildOutputNearestFormJsp(processState.getStatusTypeId());
				if (Validator.isNotNull(processState.getClosedDate())){
					String closedDate = PEHelper.getDateStrddMMYYYY(processState.getClosedDate());
					output.setMsg("Application Closed on "+closedDate);
				}else{
					output.setMsg("Application Closed.");
				}
				
			}
			return output;
		}

		// check if UI will be supported or not
		if(!requestData.isSupportedDevice()){
			output = PEOutputHelper.buildOutputError(PEErrors.UNSUPPORTED_DEVICE);
			
			return output;
		}
		
		// If some status type is requested.. Let's user present status is 4 and
		// wanted to see some step (1, 2 or 3)

		if (requestedStatusTypeId != 0) {
			try {

				// user's process state

				statusTypeRequested = PEProcessStatusTypeLocalServiceUtil.getPEProcessStatusType(requestedStatusTypeId);
				dataSource.setStatusTypeRequested(statusTypeRequested);
			} catch (PortalException e) {
				_log.error("Error while fetching process state", e);
				output = outputHelper.buildOutput(PEErrors.format(PEErrors.PROCESS_STATE_NOT_FOUND_ARGS,
						requestedStatusTypeId));
				return output;
			}
		}

		// Form/Jsp data Saving logic. Save applicable only if application is valid. 
		if(nodeIdReceived > 0 && PEProcessStateHelper.isValidProcessState(processState)){
			PEProcessableNode node = directory.getNode(nodeIdReceived);
			if(dataSource.isSaveequest()){
				if(PEProcessHelper.isForm(node)){
					PEFormSaveHandler saveHandler = PEFormSaveHandler.getInstance(dataSource,(PEForm) node);
					try {
						dataSource.rememberFormDataJustSubmitted();
						return saveHandler.save();
					} catch (PEException e) {
						return PEOutputHelper.buildOutputError(e.getError());
					} catch (Exception ex) {
						_log.error("Error while saving/auditing form. Node =" + node + "processtate = " + dataSource.getProcessState(), ex);
						return PEOutputHelper.buildOutputError(PEErrors.FORM_SAVE_ERROR);
					}finally{
						PEProcessStateHelper.unlockApplication(processState);
						PEProcessStateHelper.updateProcessStateSafe(processState,requestData);
					}
				} else if(PEProcessHelper.isFormV2(node)){
						PEFormV2SaveHandler saveHandler = PEFormV2SaveHandler.getInstance(dataSource,(PEFormV2) node);
						try {
							dataSource.rememberFormDataJustSubmitted();
							return saveHandler.save();
						} catch (PEException e) {
							return PEOutputHelper.buildOutputError(e.getError());
						} catch (Exception ex) {
							_log.error("Error while saving/auditing form. Node =" + node + "processtate = " + dataSource.getProcessState(), ex);
							return PEOutputHelper.buildOutputError(PEErrors.FORM_SAVE_ERROR);
						}finally{
							PEProcessStateHelper.unlockApplication(processState);
							PEProcessStateHelper.updateProcessStateSafe(processState,requestData);
						}
				}else if(PEProcessHelper.isJSP(node)){
					PEJSPSaveHandler saveHandler = PEJSPSaveHandler.getInstance(dataSource,(PEJSP)node);
					try {
						return saveHandler.save();
					} catch (PEException e) {
						return PEOutputHelper.buildOutputError(e.getError());
					} catch (Exception ex) {
						_log.error("Error while saving/auditing jsp. Node =" + node + "processtate = " + dataSource.getProcessState(), ex);
						return PEOutputHelper.buildOutputError(PEErrors.FORM_SAVE_ERROR);
					}finally{
						PEProcessStateHelper.unlockApplication(processState);
						PEProcessStateHelper.updateProcessStateSafe(processState,requestData);
					}
					
				}
			}
		}
		// checking if request is initial. Initial requests must not create
		// processstate record in db

		if (!requestData.isSignedIn()) { // Guest

			if (nodeIdReceived == 0) { // coming first time
				initial = true;
			} else {// first time user submitting form
				firstFormSubmission = true;
			}
		} else {
			if (nodeIdReceived == 0 && processState.getNodeId() == 0) { // signed

																		// in
																		// but
																		// not
																		// yet
																		// part
																		// of
																		// the
																		// process

				initial = true;
			} else if (nodeIdReceived != 0 && processState.getNodeId() == 0) {
				firstFormSubmission = true;
			}
		}

		dataSource.setFirstRequest(initial);
		dataSource.setFirstFormSubmission(firstFormSubmission);
		long start = 0;
		try {
			start = System.currentTimeMillis();
			// Guest user interacting with process

			if (!requestData.isSignedIn()) {

				// first time opening the page linked with process..

				if (nodeIdReceived == 0) {
					nodeToProcess = directory.getStartNode();
				} else {
					isDataNodeFromUser = true;
					dataSource.rememberFormDataJustSubmitted();
					nodeToProcess = directory.getNode(nodeIdReceived);
				}
			} else {

				// if user requests previous steps

				if (Validator.isNotNull(statusTypeRequested)) {

					// show only if the step (statusTypeRequested) is already
					// completed. Below is the Conditon to know if the step is
					// completed : if requested step is less than current step
					// (OR) ( requested stp equal to current step and it's
					// approved - mean completed)

					PEProcessStatusType current = PEProcessStatusTypeLocalServiceUtil.getPEProcessStatusType(processState.getStatusTypeId());
					if (statusTypeRequested.getSeqNo() < current.getSeqNo()
							|| (statusTypeRequested.getSeqNo() == current.getSeqNo() )) {
						output = outputHelper.buildOutput(statusTypeRequested);
						if (output.isReProcessing()) {
							PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(dataSource.getProcessState());
							dataAdapter.store(PEConstants.PE_REPROCESSING, "true");
							dataAdapter.store(PEConstants.PE_PRE_REPROCESSING_NODE, String.valueOf(dataSource.getProcessState().getNodeId()));
							com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil.updatePEProcessState(dataSource.getProcessState());
						}
						return output;
					} else if (statusTypeRequested.getSeqNo() > current.getSeqNo()) {
						return outputHelper.buildOutput(PEErrors.STATUS_TYPE_NOT_TRAVERSED);
					}
				}

				
				if(!dataSource.isAgentLoggedInUser() && !dataSource.isApplicantLoggedInUser()){
					
					if(PEConstantsGlobal.STATUS_PENDING.equalsIgnoreCase(processState.getStatus())){
						output = outputHelper.buildOutputNearestFormJsp(processState.getStatusTypeId());
						return output;
					}
			/*		// if request is from approver. If the request is from register
					// screen dont process as apprver
					if (PEProcessHelper.isGlobalStatusTypeApprover(themeDisplay.getUser(), process) && initial) {
						output = outputHelper.buildOutput(StringPool.BLANK);
						return output;
					}else if (PEProcessHelper.isGlobalStatusTypeApprover(themeDisplay.getUser(), process) && !initial) {
						
						// request coming from approver, prepare output for him
						
						output = outputHelper.buildOutputNearestFormJsp(processState.getStatusTypeId());
						return output;
					} */
				}

				/*
				 * if (processState.isNew()){ // SignedIN user want to register
				 * with process, so his state will be first node of the process
				 * processState.setNodeId(directory.getStartNodeId());
				 * //PEProcessStateHelper.updateProcessState(processState);
				 * nodeToProcess = directory.getStartNode(); }else
				 */

				// just fresh process - at intial step ( if nodeIdReceived
				// contains value then request is coming from form submission so
				// request is not initial)

				if (initial) {

					// looks process not started for the user.it's new

					nodeToProcess = directory.getStartNode();
					processState.setNodeId(directory.getStartNodeId());

					// PEProcessStateHelper.updateProcessState(processState);
					// something wrong. nodeId can not be zero throw new
					// PEProcessStateException(PEErrors.USER_PROCESS_STATE_NOT_VALID);

				} else {
					long nodeId = processState.getNodeId();

					// User revisited the process page ( let's say after
					// signout), now Process engine need to start from node
					// where user stopped last time

					if (nodeIdReceived == 0) {
						nodeToProcess = directory.getNode(nodeId);

						// Last node visited was message/jsp node, so lets
						// process next node to msg node

						if (nodeToProcess.getNodeSubType() == PENodeSubType.MSG) {

							// return next node to process

							nodeOutput = nodeToProcess.process(processState, dataSource);
							nodeToProcess = directory.getNode(nodeOutput.getNextNodeId());

							// if there is no next node, then keep displaying
							// the msg.

							if (Validator.isNull(nodeToProcess)) {
								nodeToProcess = directory.getNode(nodeId);
							}
						} else {

							// otherwise, nodeId in processstate must be
							// processed

						}
						// (processState.isNew() && nodeIdReceived != 0) : this case happens either for agent or signed in user trying for new registration
					} else if ((processState.isNew() && nodeIdReceived != 0) ||
					// payment allows resubmission for refund
							(!processState.isNew() && (directory.getNode(nodeIdReceived) instanceof com.sambaash.platform.pe.jaxb.PEPayment)) ||
							(!processState.isNew() && (directory.getNode(nodeIdReceived) instanceof com.sambaash.platform.pe.jaxb.PEPaymentV2)) ||
					// pricing can be re-submitted to update in case there is new fees (e.g. late fees)
							(!processState.isNew() && (directory.getNode(nodeIdReceived) instanceof com.sambaash.platform.pe.jaxb.PEPricing)) ||
					// if process state is existing, then the user must come
					// from same node as in process state

							(!processState.isNew() && processState.getNodeId() == nodeIdReceived) ||
							(!processState.isNew() && directory.getNode(nodeIdReceived).isReprocessable()) ||
					// if the user tries to re-submit the jsp node
							 (!processState.isNew() && dataSource.isSubmitRequest() && PEProcessHelper.isJSP(directory.getNode(nodeIdReceived)))) { // here

																										// one
																										// of
																										// the
																										// case
																										// must
																										// be
																										// true
						// user is coming from some node ( form/jsp etc..).
						nodeToProcess = directory.getNode(nodeIdReceived);
						dataSource.rememberFormDataJustSubmitted();
						isDataNodeFromUser = true;

						// signed in user, submitted the form first time.. so
						// update process state to db.. (for new user process
						// state is not yet persisted.let's persiste)
						// for agent, process state must be updated once user account get's created.In PEAccountCreateHandler
						if (processState.isNew() && !dataSource.isAgentLoggedInUser()) {
							processState.setUserIdProcess(dataSource.getLoggedInUserId());
							processState.setNodeId(nodeIdReceived);
							PEProcessStateHelper.updateProcessState(processState,requestData);
						}
					} else {
						throw new PEProcessStateException(PEErrors.RECEIVED_NODE_NOT_VALID);
					}
				}
			}

			// If node is not found, return error msg

			if (Validator.isNull(nodeToProcess)) {

				// calling this method, also checks if process is completed

				output = outputHelper.buildOutput(nodeToProcess);
				return output;
			}
			
			if(isDataNodeFromUser){
				PEDataSubmittable submittable = (PEDataSubmittable)nodeToProcess;
				if(!PEProcessHelper.canSubmitData(dataSource, submittable)){
					return PEOutputHelper.buildOutputError(PEErrors.UNAUTHORIZED_FORM_SUBMIT);
				}
			}

			// At this point, we have request, response, nextnodetoprocess

			/**
			 * case 1 : nodeToProcess = startNode , Happens: when user first
			 * time visiting the process page (Applicable to both guest and
			 * signed in user) If startNode is displayable - return the node If
			 * startNode is not displayable - process it until displayable node
			 * comes.
			 *
			 * case 2 : nodeToProcess = data_collection type ( like form/jsp ),
			 * Happens : When user submits form/jsp ( Guest user can submit
			 * atmost only one form mostly the first form ) process this type of
			 * node. Processing will start from this node unitl displayable node
			 * comes.
			 *
			 * case 3 : nodeToProcess = Not displayable kind of action node
			 * Happens : only when process got stopped by some reason Processing
			 * will start from this node unitl displayable node comes.
			 *
			 */
			PEProcessableNode tempNode = nodeToProcess;
			boolean reprocessingHalted = false;
			try {
				while (tempNode != null) {
					
					if(_log.isDebugEnabled()) {
						_log.debug(String.format("nodeToProcess : %s : nodeId : %s : className %s ",tempNode.getNodeType(),
								tempNode.getNodeId(),
								tempNode.getClass().getName()));
					}

					nodeOutput = tempNode.process(processState, dataSource);

					// once node is processed check if error/validations exists, if
					// so stop processing

					if (nodeOutput.errorExists() || nodeOutput.validationMsgsExists()) {
						reprocessingHalted = !nodeOutput.getValidationMsgs().isEmpty() && PEConstants.REPROCESSING_STOPPED_MSG.equals(nodeOutput.getValidationMsgs().get(0));
						if (reprocessingHalted) {
							dataSource.getProcessState().setNodeId(Long.parseLong(dataSource.getDataFromProcessState(PEConstants.PE_PRE_REPROCESSING_NODE)));
							PEProcessStateLocalServiceUtil.updatePEProcessState(dataSource.getProcessState());
						}
						output = outputHelper.buildOutputErrorCase(nodeOutput, nodeToProcess);
						return output;
					}
					
					// Applicable only for displayable nodes
					//  True - When form/jsp data submission is done
					//  false - whe form/jsp yet to processed
					if(tempNode.isDisplayable() && !nodeOutput.isCanProceedToNext()){
						if(PEProcessHelper.isJSP(tempNode)){
							PEJSPHelper.preprocess(dataSource, (PEJSP) tempNode);
						}
						// tempnode must be displayed back
						break;
					}
					
					// update process state with the node just got processed
					// successfully.As of now not using it, may be useful in future
					// it.
					PEProcessStateHelper.updateProcessStateLastTraversedNode(tempNode, processState);

					tempNode = directory.getNode(nodeOutput.getNextNodeId());

					// update process state with next node to traverse. This node
					// will always start point whenever user revisit the process
					// page.
					PEProcessStateHelper.updateProcessStateNextNodeToProcess(tempNode, processState);
					// If it is displayable node, then break the loop. Because the node has to displayed to the user
					if(tempNode.isDisplayable()){
						if(PEProcessHelper.isJSP(tempNode)){
							PEJSPHelper.preprocess(dataSource, (PEJSP) tempNode);
						}
						break;
					}
				}

			} catch (PEException pse) {
				_log.error(pse);
				output = outputHelper.buildOutput(pse.getError());
				return output;
				// TODO: handle exception
			} catch(Exception ex){
				_log.error(ex);
				output = outputHelper.buildOutput(PEErrors.SYSTEM_ERROR);
				return output;
			}finally{
				// update the process state if it exists.
				// This is checking is required bcz processstate is created (not persisted) even if the user is
				// guest/signed in user and even when they are at begining
				
				if (PEProcessStateHelper.isValidProcessState(processState) && !dataSource.isFirstRequest()) {
					// tempNode always point to current processing node. Process State must be updated with this always.
					// Some cases for example, if there is  displayable node exists right after msg/jsp node, then the above while loop wont be processed
					// and hence process state wont be updated with correct node. So to overcome such scenarios we need to set the nodeId to tempNode.
					if(tempNode != null && tempNode.getNodeId() != processState.getNodeId() && !reprocessingHalted){
						processState.setNodeId(tempNode.getNodeId());
					}
					try{
						// reindexing social profile
						PEHelper.reindexSocialProfile(processState);
					}catch(Exception ex){
						_log.error(ex);
					}
					
					PEProcessStateHelper.unlockApplication(processState);
					// ActionDone must be true only when there is change in nodeId. This parameter used to indicate if modified date has to reset to current date.
					boolean actionDone = PEConstants.ACTION_NOT_DONE;
					if(nodeToProcess.getNodeId() != processState.getNodeId()){
						actionDone = PEConstants.ACTION_DONE;
					}
					PEProcessStateHelper.updateProcessState(processState,requestData,actionDone);
					dataSource.getAuditHelper().updatePendingAudits();
				}
			}
			output = outputHelper.buildOutput(tempNode);
			
		} catch (PEException pse) {
			_log.error(pse);
			output = outputHelper.buildOutput(pse.getError());
		}catch(Exception ex){
			_log.error(ex);
			output = outputHelper.buildOutput(PEErrors.SYSTEM_ERROR);
			return output;
		}

		
		if(_log.isDebugEnabled()) {
			long end = System.currentTimeMillis();
			_log.debug("Process Engine Time taken " + (end-start)/1000);
		}
		
		return output;
	}

	@Override
	public void executeAsApprover(PEProcessStatePK pk, PortletRequest request, PortletResponse response) {

		// TODO Auto-generated method stub

	}
	
	@Override
	public PEOutput approve(long processStatusId, PortletRequest request,
			PortletResponse response) {
		PEProcessState processState = null;
		PERequestData requestData = null;
		PEOutput output = null;
		// Get process state

		try {
			processState = PEProcessStateLocalServiceUtil
					.getPEProcessState(processStatusId);
		} catch (PortalException ex) {
			output = PEOutputHelper.buildOutputError(PEErrors.format(
					PEErrors.PROCESS_STATE_NOT_FOUND_ARGS, processStatusId));
			return output;
		} catch (SystemException e) {
			output = PEOutputHelper.buildOutputError(PEErrors.SYSTEM_ERROR);
			return output;
		}

		requestData = PERequestData.getRequestData(request);
	
		// Initializing the required data
		boolean lockObtained = PEProcessStateHelper.obtainLock(processState,
				requestData);
		if (lockObtained) {
			processState = PEProcessStateLocalServiceUtil
					.clearCacheAndGetProcessState(processState);
			try {
				long currentStatusTypeId = ParamUtil.getLong(request, "currentStatusTypeId");
				return executeApprove(processState, requestData,currentStatusTypeId);
			} catch (SystemException e) {
				output = PEOutputHelper
						.buildOutputError(PEErrors.SYSTEM_ERROR);
				return output;
			} finally {
				PEProcessStateHelper.unLockApplicationAndSave(processState,
						requestData);
			}
		} else {
			return PEOutputHelper.buildOutputError(PEErrors.UNABLE_TO_GET_LOCK);
		}

	}
	@Override
	public PEOutput reject(long processStatusId, PortletRequest request,
			PortletResponse response) {
		PEProcessState processState = null;
		PERequestData requestData = null;
		PEOutput output = null;
		// Get process state
		
		try {
			processState = PEProcessStateLocalServiceUtil
					.getPEProcessState(processStatusId);
		} catch (PortalException ex) {
			output = PEOutputHelper.buildOutputError(PEErrors.format(
					PEErrors.PROCESS_STATE_NOT_FOUND_ARGS, processStatusId));
			return output;
		} catch (SystemException e) {
			output = PEOutputHelper.buildOutputError(PEErrors.SYSTEM_ERROR);
			return output;
		}
		
		requestData = PERequestData.getRequestData(request);
		
		// Initializing the required data
		boolean lockObtained = PEProcessStateHelper.obtainLock(processState,
				requestData);
		if (lockObtained) {
			processState = PEProcessStateLocalServiceUtil
					.clearCacheAndGetProcessState(processState);
			try {
				long currentStatusTypeId = ParamUtil.getLong(request, "currentStatusTypeId");
				return executeReject(processState, requestData,currentStatusTypeId);
			} catch (SystemException e) {
				output = PEOutputHelper
						.buildOutputError(PEErrors.SYSTEM_ERROR);
				return output;
			} finally {
				PEProcessStateHelper.unLockApplicationAndSave(processState,
						requestData);
			}
		} else {
			return PEOutputHelper.buildOutputError(PEErrors.UNABLE_TO_GET_LOCK);
		}
		
	}


	// processStatusId - Primary key in PEProcessState statusTypeId - is the
	// status to approve

	private PEOutput executeApprove(PEProcessState processState, PERequestData requestData,long currentStatusTypeId)
			throws SystemException {
		PEOutput output = null;
		// build datasource

		PEOutputHelper outputHelper = null;
		PEProcessDirectory directory = null;
		PEDataSource dataSource = null;

		// build output helper

		try {
			dataSource = PEOutputHelper.prepareDataSource(requestData, processState);
			directory = dataSource.getDirectory();
			outputHelper = PEOutputHelper.getOutputHelper(dataSource);
		} catch (PEException e1) {
			_log.error(e1);
			output = PEOutputHelper.buildOutputError(PEErrors.CONFIG_ERROR_PROCESS_DEFINITON);
			return output;
		}
		
		
		if( (currentStatusTypeId != processState.getStatusTypeId()) || !PEConstantsGlobal.STATUS_PENDING.equalsIgnoreCase(processState.getStatus()) ){
			output = PEOutputHelper.buildOutputError(PEErrors.INVALID_STATUS_CHANGE_TO_APPROVED);
			return output;
		}
		
		if(!dataSource.isCurrentStatusApproverLoggedInUser()){
			output = PEOutputHelper.buildOutputError(PEErrors.UNAUTHORIZED_APPROVE);
			return output;
		}

		try {

			String oldStatus = processState.getStatus();
			String newStatus = PEConstantsGlobal.STATUS_APPROVED;

			// update process state to approve

			processState.setStatus(newStatus);
			PEProcessStateHelper.updateProcessState(processState,requestData);

			PEProcessStatusType current = dataSource.getStatusTypeCurrent();
			outputHelper.buildOutput(current.getStatusName() + " has been approved"); // this

																			// msg
																			// indicates
																			// approval
																			// is
																			// success.

			// audit the process state change
			PEAuditHelper audit = PEAuditHelper.getAuditHelper(processState, dataSource);
			audit.logStatusChangeApproved(String.valueOf(dataSource.getLoggedInUserId()),
					processState.getStatusTypeId(), processState.getStatusTypeId(), oldStatus, newStatus,PEConstants.DEFAULT_NODE_ID);
		} catch (PEException pe) {
			output = outputHelper.buildOutput(pe.getError());
			return output;
		}

		// logic to process further action nodes. It's possible that some action
		// nodes exists after process node and those can executed after approval
		// for example, as soon as officer approves the request, next node is
		// that keeping user in another status

		// this node must be PEProcessNode

		output = afterApproveReject(outputHelper,dataSource);
		return output;
	}

	private PEOutput afterApproveReject(PEOutputHelper outputHelper, PEDataSource dataSource) {
		PEOutput output = outputHelper.getOutput();
		PEProcessState processState = dataSource.getProcessState();
		PEProcessDirectory directory = dataSource.getDirectory();
		
		PEProcessableNode node = directory.getNode(processState.getNodeId());

		if (node != null) {
			PEProcessableNode temp = node;
			boolean initial = true;
			PEProcessableNodeOutput nodeOutput = null;
//			PEProcessableNodeOutput nodeOutput = node.process(processState, dataSource);
	//		temp = directory.getNode(nodeOutput.getNextNodeId());
			try {
				// this is some specific logic written for entranceTEst step in Enrollment for Course process.
				// Entrance test does not have submit and there is no way to decide if submission done. Iam just tweaking it to work. 
				if(PEProcessHelper.isJSP(node)){
					PEJSP jsp = (PEJSP)node;
					PEJSPHelper jspHelper = PEJSPRegistry.getRegistry().getJspHelper(dataSource, jsp);
					jspHelper.setForceSubmit();
				}
				while (initial || (temp != null && !temp.isDisplayable())) {
					initial = false;
					nodeOutput = temp.process(processState, dataSource);

					// once node is processed check if error/validations exists,
					// if so stop processing

					if (nodeOutput.errorExists() || nodeOutput.validationMsgsExists()) {
						output = outputHelper.buildOutputErrorCase(nodeOutput, node);
						return output;
					}

					// update process state with the node just got processed
					// successfully.As of now not using it, may be useful in
					// future it.

					PEProcessStateHelper.updateProcessStateLastTraversedNode(temp, processState);

					temp = directory.getNode(nodeOutput.getNextNodeId());

					// update process state with next node to traverse. This
					// node will always start point whenever user revisit the
					// process page.

					PEProcessStateHelper.updateProcessStateNextNodeToProcess(temp, processState);
				}

				// output = outputHelper.buildOutput(temp);

			} catch (PEException pee) {
				_log.error(pee);
				output = outputHelper.buildOutput(pee.getError());
			} catch (Exception pee) {
				_log.error(pee);
				output = outputHelper.buildOutput(PEErrors.SYSTEM_ERROR);
			}finally{
				// required bcz processstate is created even if the user is
				// guest/signed in user and even when they are at begining
				
				if (PEProcessStateHelper.isValidProcessState(processState) && !dataSource.isFirstRequest()) {
					PEProcessStateHelper.unLockApplicationAndSave(processState, dataSource.getRequestData());
					PEProcessStateHelper.updateProcessStateSafe(processState,dataSource.getRequestData());
				}
			}
		}
		return output;
	}

	// processStatusId - Primary key in PEProcessState statusTypeId - is the
	// status to approve

	public PEOutput executeReject(PEProcessState processState, PERequestData requestData,long currentStatusTypeId)
			throws SystemException {
		PEOutput output = null;
	

		PEOutputHelper outputHelper;
		PEDataSource dataSource = null;
		try {
			dataSource = PEOutputHelper.prepareDataSource(requestData, processState);
			outputHelper = PEOutputHelper.getOutputHelper(dataSource);;
		} catch (PEException e1) {
			_log.error(e1);
			output = PEOutputHelper.buildOutputError(PEErrors.CONFIG_ERROR_PROCESS_DEFINITON);
			return output;
		}

		output = outputHelper.getOutput();
		
		if( (currentStatusTypeId != processState.getStatusTypeId()) || !PEConstantsGlobal.STATUS_PENDING.equalsIgnoreCase(processState.getStatus()) ){
			output = PEOutputHelper.buildOutputError(PEErrors.INVALID_STATUS_CHANGE_TO_REJECT);
			return output;
		}
		
		if(!dataSource.isCurrentStatusApproverLoggedInUser()){
			output = PEOutputHelper.buildOutputError(PEErrors.UNAUTHORIZED_REJECT);
			return output;
		}
		
		try {

			// TODO: permission checking

			String oldStatus = processState.getStatus();
			String newStatus = PEConstantsGlobal.STATUS_REJECTED;

			if (newStatus.equalsIgnoreCase(oldStatus)) {
				output.setMsg("Application has already rejected");
				return output;
			}

			// update process state to rejected

			processState.setStatus(newStatus);
			PEProcessStateHelper.updateProcessState(processState,requestData);

			output.setMsg("Application has been rejected");

			// audit the process state change
			PEAuditHelper audit = PEAuditHelper.getAuditHelper(processState, dataSource);
			audit.logStatusChangeRejected(String.valueOf(dataSource.getLoggedInUserId()),
					processState.getStatusTypeId(), processState.getStatusTypeId(), oldStatus, newStatus,PEConstants.DEFAULT_NODE_ID);
		} catch (PEException pe) {
			output = outputHelper.buildOutput(pe.getError());
			return output;
		}

		output = afterApproveReject(outputHelper,dataSource);
		return output;
	}
}
