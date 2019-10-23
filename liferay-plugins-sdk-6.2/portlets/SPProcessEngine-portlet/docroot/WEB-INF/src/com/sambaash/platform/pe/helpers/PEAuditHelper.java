package com.sambaash.platform.pe.helpers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.constants.PEAuditConstants;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.model.PERuleSet;
import com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PERuleSetLocalServiceUtil;

public class PEAuditHelper implements PEAuditConstants {

	private List<PEProcessAudit> pendingAudits;

	public List<PEProcessAudit> getPendingAudits() {
		if (pendingAudits == null) {
			pendingAudits = new ArrayList<PEProcessAudit>();
		}

		return pendingAudits;
	}

	public void addPendingAudit(PEProcessAudit audit) {
		getPendingAudits().add(audit);
	}

	public void setPendingAudits(List<PEProcessAudit> pendingAudits) {
		this.pendingAudits = pendingAudits;
	}

	// dont invoke this method. use pedatasource.getAuditHelper
	public static PEAuditHelper getAuditHelper(PEProcessState processState, PEDataSource ds) {
		return new PEAuditHelper(processState, ds);
	}

	public PEAuditHelper(PEProcessState processState, PEDataSource ds) {
		this.processState = processState;
		this.ds = ds;
	}

	public PEProcessAudit create() {
		PEProcessAudit audit = null;
		try {
			audit = PEProcessAuditLocalServiceUtil.create(processState.getSpPEProcessStateId());
			PEHelper.fillAudit(audit, ds.getRequestData(), true);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		return audit;
	}

	// TODO: documentation

	public PEProcessAudit createAuditForm(long formId, long rulsetId, long storageId, long nodeId, String data,
			String action) throws SystemException {
		PEProcessAudit audit = create();
		audit.setType(TYPE_FORM);
		audit.setAction(action);
		audit.setNodeId(nodeId);

		audit.setDoneBy(getDoneBy());

		audit.setField1(String.valueOf(rulsetId));
		audit.setData1(data);
		// audit form id also
		if (formId <= 0) { // old impl does not pass the formId directly
			PERuleSet ruleset = PERuleSetLocalServiceUtil.fetchPERuleSet(rulsetId);
			// componentId is the formId. // dont change storing component id to
			// field2. check impl class/service xml any methods working on
			// field2
			formId = Long.parseLong(ruleset.getComponentId());
		}
		audit.setField2(String.valueOf(formId));

		audit.setStorageId(storageId);
		return audit;

	}

	public PEProcessAudit createAuditFormSubmit(long rulsetId, long storageId, long nodeId, String data)
			throws PEException {
		try {
			return createAuditForm(-1, rulsetId, storageId, nodeId, data, ACTION_SUBMIT);
		} catch (Exception ex) {
			_log.error("Error while creating audit for form submit", ex);
			PEException pee = new PEException(PEErrors.AUDIT_FORM, ex);
			throw pee;
		}
	}

	public PEProcessAudit createAuditFormSave(long rulsetId, long storageId, long nodeId, String data)
			throws PEException {
		try {
			return createAuditForm(-1, rulsetId, storageId, nodeId, data, ACTION_SAVE);
		} catch (Exception ex) {
			_log.error("Error while creating audit for form save", ex);
			PEException pee = new PEException(PEErrors.AUDIT_FORM, ex);
			throw pee;
		}
	}

	public PEProcessAudit createAuditFormV2Submit(long formId, long rulsetId, long storageId, long nodeId, String data)
			throws PEException {
		try {
			return createAuditForm(formId, rulsetId, storageId, nodeId, data, ACTION_SUBMIT);
		} catch (Exception ex) {
			_log.error("Error while creating audit for form v2 submit", ex);
			PEException pee = new PEException(PEErrors.AUDIT_FORM, ex);
			throw pee;
		}
	}

	public PEProcessAudit createAuditFormV2Save(long formId, long rulsetId, long storageId, long nodeId, String data)
			throws PEException {
		try {
			return createAuditForm(formId, rulsetId, storageId, nodeId, data, ACTION_SAVE);
		} catch (Exception ex) {
			_log.error("Error while creating audit for form v2 save", ex);
			PEException pee = new PEException(PEErrors.AUDIT_FORM, ex);
			throw pee;
		}
	}

	private String getDoneBy() {
		/*
		 * boolean isAgent =
		 * PEProcessHelper.isAgent(ds.getThemeDisplay().getUser(),
		 * ds.getProcess()); String doneBy =
		 * String.valueOf(processState.getUserIdProcess()); // actual user
		 * if(isAgent){ doneBy =
		 * String.valueOf(ds.getThemeDisplay().getUserId()); // agent id }
		 */
		String doneBy = String.valueOf(ds.getLoggedInUserId());
		return doneBy;
	}

	// TODO: documentation

	public void logAccountCreation(long nodeId) throws PEException {
		try {
			PEProcessAudit audit = create();
			audit.setType(TYPE_ACCOUNT);
			audit.setAction(ACTION_CREATE);
			audit.setNodeId(nodeId);
			// check if registration doing by agent
			audit.setDoneBy(getDoneBy());
			audit.setField1(String.valueOf(processState.getUserIdProcess()));
			// PEProcessAuditLocalServiceUtil.updatePEProcessAudit(audit);
			updateAudit(audit);
		} catch (Exception ex) {
			_log.error("Error while creating audit for account creation", ex);
			PEException pee = new PEException(PEErrors.AUDIT_STATUS, ex);
			throw pee;
		}
	}

	// TODO: documentation

	public void logFormSubmit(String doneBy, long rulsetId, long storageId, long nodeId, String data)
			throws PEException {
		try {
			PEProcessAudit audit = createAuditFormSubmit(rulsetId, storageId, nodeId, data);
			// PEProcessAuditLocalServiceUtil.updatePEProcessAudit(audit);
			updateAudit(audit);
		} catch (Exception ex) {
			_log.error("Error while creating audit for form submit", ex);
			PEException pee = new PEException(PEErrors.AUDIT_FORM, ex);
			throw pee;
		}
	}

	public void logJSPSubmit(String doneBy, long rulsetId, long nodeId, String data) throws PEException {
		try {
			logJSP(doneBy, rulsetId, nodeId, data, ACTION_SUBMIT);
		} catch (Exception ex) {
			_log.error("Error while creating audit for jsp submit", ex);
			PEException pee = new PEException(PEErrors.AUDIT_STATUS, ex);
			throw pee;
		}
	}

	public void logJSPSave(String doneBy, long rulsetId, long nodeId, String data) throws PEException {
		try {
			logJSP(doneBy, rulsetId, nodeId, data, ACTION_SAVE);
		} catch (Exception ex) {
			_log.error("Error while creating audit for jsp save", ex);
			PEException pee = new PEException(PEErrors.AUDIT_STATUS, ex);
			throw pee;
		}
	}

	public void logJSP(String doneBy, long rulsetId, long nodeId, String data, String action) throws SystemException {
		PEProcessAudit audit = create();
		audit.setType(TYPE_JSP);
		audit.setAction(action);
		audit.setDoneBy(doneBy);
		audit.setField1(String.valueOf(rulsetId));
		audit.setNodeId(nodeId);
		audit.setData1(data);
		// PEProcessAuditLocalServiceUtil.updatePEProcessAudit(audit);
		updateAudit(audit);
	}

	public void logPayment(String doneBy, long rulsetId, long nodeId, String data, String action) throws PEException {
		try {
			PEProcessAudit audit = create();
			audit.setType(TYPE_PAYMENT);
			audit.setAction(action);
			audit.setDoneBy(doneBy);
			audit.setField1(String.valueOf(rulsetId));
			audit.setNodeId(nodeId);
			audit.setData1(data);
			updateAudit(audit);
		} catch (Exception e) {
			_log.error("Error while creating audit for payment ", e);
			throw new PEException(PEErrors.AUDIT_STATUS, e);
		}
	}

	/**
	 * Example: mail / PE / sent / 43521 / User submitted interest
	 *
	 * Here type = mail, doneBy = PE, Action = sent, toUserId = 43521, content =
	 * User submitted interest
	 *
	 * @param doneBy
	 * @param toAddress
	 *            - It can be userId or emailAddress
	 * @param content
	 * @throws Exception
	 */

	public void logMail(String toAddress, String content, long nodeId) throws Exception {
		try {
			PEProcessAudit audit = create();
			audit.setType(TYPE_MAIL);
			audit.setAction(ACTION_SENT);
			audit.setDoneBy(getDoneBy());
			audit.setField1(toAddress);
			audit.setData1(content);
			audit.setNodeId(nodeId);
			// PEProcessAuditLocalServiceUtil.updatePEProcessAudit(audit);
			updateAudit(audit);
		} catch (Exception ex) {
			_log.error("Error while creating audit for mail ", ex);
			throw ex;
		}
	}

	public void logMailByPE(String toUserId, String content, long nodeId) throws Exception {
		logMail(toUserId, content, nodeId);
	}

	// TODO: documentation

	public void logMsgNode(String doneBy, long msgNodeId, String data) {
		try {
			PEProcessAudit audit = create();
			audit.setType(TYPE_MSG);
			audit.setAction(ACTION_DISPLAY);
			audit.setDoneBy(doneBy);
			audit.setField1(String.valueOf(msgNodeId));
			audit.setNodeId(msgNodeId);
			audit.setData1(data);
			// PEProcessAuditLocalServiceUtil.updatePEProcessAudit(audit);
			updateAudit(audit);
		} catch (Exception ex) {
			_log.error("Error while creating audit for msg node", ex);
		}
	}

	// TODO: documentation

	public void logProcessNode(String doneBy, long ruleSetId, long nodeId, String data) throws PEException {
		try {
			PEProcessAudit audit = create();
			audit.setType(TYPE_PROCESS);
			audit.setAction(ACTION_EXECUTE);
			audit.setDoneBy(getDoneBy());
			audit.setField1(String.valueOf(ruleSetId));
			audit.setData1(data);
			audit.setNodeId(nodeId);
			// PEProcessAuditLocalServiceUtil.updatePEProcessAudit(audit);
			updateAudit(audit);
		} catch (Exception ex) {
			_log.error("Error while creating audit for process node", ex);
			PEException pee = new PEException(PEErrors.AUDIT_STATUS, ex);
			throw pee;
		}
	}

	private static final long LOAD_FROM_PREVIOUS_LOG = -1;

	public void logStatusChangeApproved(String doneBy, long oldStatusId, long newStatusId, String oldStatus,
			String data1, long nodeId) throws PEException {
		String newStatus = PEConstantsGlobal.STATUS_APPROVED;
		logStatusChange(doneBy, oldStatusId, newStatusId, oldStatus, newStatus, data1, nodeId, LOAD_FROM_PREVIOUS_LOG);
	}

	public void logStatusChangeByPE(long oldStatusId, long newStatusId, String oldStatus, String newStatus,
			String data1, long nodeId, long nodeIdDataSubmited) throws PEException {
		logStatusChange(PEAuditConstants.DONE_BY_PE, oldStatusId, newStatusId, oldStatus, newStatus, data1, nodeId,
				nodeIdDataSubmited);
	}

	public void logStatusChangeRejected(String doneBy, long oldStatusId, long newStatusId, String oldStatus,
			String data1, long nodeId) throws PEException {
		String newStatus = PEConstantsGlobal.STATUS_REJECTED;
		logStatusChange(doneBy, oldStatusId, newStatusId, oldStatus, newStatus, data1, nodeId, LOAD_FROM_PREVIOUS_LOG);
	}

	// TODO: documentation

	private void logStatusChange(String doneBy, long oldStatusId, long newStatusId, String oldStatus, String newStatus,
			String data1, long nodeId, long nodeIdDataSubmited) throws PEException {
		try {
			PEProcessAudit audit = create();
			audit.setType(TYPE_STATUS);
			audit.setAction(ACTION_CHANGE);
			audit.setDoneBy(doneBy);
			audit.setField1(String.valueOf(oldStatusId));
			audit.setField2(String.valueOf(newStatusId));
			audit.setField3(oldStatus);
			audit.setField4(newStatus);
			audit.setData1(data1);
			audit.setNodeId(nodeId);
			if (nodeIdDataSubmited == LOAD_FROM_PREVIOUS_LOG) {
				try {
					PEProcessAudit latest = PEProcessAuditLocalServiceUtil.findLatestStatusTypeAudit(
							processState.getStatusTypeId(), processState.getSpPEProcessStateId());
					nodeIdDataSubmited = latest.getField5();
				} catch (NoSuchPEProcessAuditException e) {
					_log.error("No audit record exits for StatusTypeId = " + processState.getStatusTypeId()
							+ " ProcessStateId = " + processState.getSpPEProcessStateId());
				}
			}
			audit.setField5(nodeIdDataSubmited);
			// PEProcessAuditLocalServiceUtil.updatePEProcessAudit(audit);
			updateAudit(audit);
		} catch (Exception ex) {
			_log.error("Error while creating audit for stats change ", ex);
			PEException pee = new PEException(PEErrors.AUDIT_STATUS, ex);
			throw pee;
		}
	}

	// all audit methods should call this method to update
	public PEProcessAudit updateAudit(PEProcessAudit audit) throws SystemException {

		audit.setSpPEProcessId(processState.getSpPEProcessId());
		audit.setEntityClassId(processState.getEntityClassId());
		audit.setEntityId(processState.getEntityId());
		audit.setUserIdProcess(processState.getUserIdProcess());
		audit.setStatusTypeId(processState.getStatusTypeId());
		audit.setSpPEProcessStageId(processState.getSpPEProcessStageId());
		audit.setStatus(processState.getStatus());
		audit.setDoneBy(getDoneBy());
		audit.setUserIdSupervisor(processState.getUserIdSupervisor());
		audit.setUserIdAgent(processState.getUserIdAgent());
		// Ideally ClosedStageId is always zero
		audit.setSpPEClosedStageId(processState.getClosedStageId());
		if (processState.getUserIdProcess() > 0 && processState.getSpPEProcessStateId() > 0) {
			audit = PEProcessAuditLocalServiceUtil.updatePEProcessAudit(audit);
		} else {
			getPendingAudits().add(audit);
		}
		return audit;
	}

	public void updatePendingAudits() throws SystemException {
		Iterator<PEProcessAudit> iterator = this.getPendingAudits().iterator();
		while (iterator.hasNext()) {
			PEProcessAudit auditPending = iterator.next();
			auditPending.setSpPEProcessStateId(processState.getSpPEProcessStateId());
			auditPending.setUserIdProcess(processState.getUserIdProcess());
			if (ds.isSignedInUser()) {
				// could be sales agent
				auditPending.setDoneBy(getDoneBy());
			} else {
				// guest user.. so set actual user
				auditPending.setDoneBy(String.valueOf(processState.getUserIdProcess()));
			}
			_log.debug("Updating audit " + auditPending);
			PEProcessAuditLocalServiceUtil.updatePEProcessAudit(auditPending);
			iterator.remove();
		}

	}

	public void logEntityChange(long sourceClassId, long sourceEntityID, long newClassId, long newEntityID, long nodeId)
			throws Exception {
		logEntityChange(String.valueOf(sourceClassId), String.valueOf(sourceEntityID), String.valueOf(newClassId),
				String.valueOf(newEntityID), nodeId);
	}

	public void logEntityChange(String sourceClassId, String sourceEntityID, String newClassId, String newEntityID,
			long nodeId) throws SystemException {
		try {
			PEProcessAudit audit = create();
			audit.setType(TYPE_ENTITY);
			audit.setAction(ACTION_CHANGE);
			audit.setDoneBy(getDoneBy());
			// source
			audit.setField1(sourceClassId);
			audit.setField2(sourceEntityID);
			// new
			audit.setField3(newClassId);
			audit.setField4(newEntityID);
			audit.setNodeId(nodeId);
			updateAudit(audit);
		} catch (Exception ex) {
			_log.error("Error while creating audit for entity change ", ex);
			throw ex;
		}
	}

	public void logPricingInvoice(PEProcessAudit audit, long nodeId, String jsonDataStr) throws SystemException {
		try {
			audit.setType(TYPE_PRICING);
			audit.setAction(ACTION_SUBMIT);
			audit.setDoneBy(getDoneBy());
			audit.setField1("INVOICE");
			audit.setData1(jsonDataStr);
			audit.setNodeId(nodeId);
			updateAudit(audit);
		} catch (Exception ex) {
			_log.error("Error while creating audit for entity change ", ex);
			throw ex;
		}
	}

	public void logApiCall(long nodeId, String mode, String apiResponse) throws SystemException {
		PEProcessAudit audit = create();
		audit.setType(TYPE_API);
		audit.setAction(ACTION_EXECUTE);
		audit.setDoneBy(getDoneBy());
		audit.setNodeId(nodeId);
		audit.setData1(apiResponse);
		audit.setField1(mode); // SYNC || ASYNC
		updateAudit(audit);
	}

	private static Log _log = LogFactoryUtil.getLog(PEAuditHelper.class);

	private PEDataSource ds;
	private PEProcessState processState;

}