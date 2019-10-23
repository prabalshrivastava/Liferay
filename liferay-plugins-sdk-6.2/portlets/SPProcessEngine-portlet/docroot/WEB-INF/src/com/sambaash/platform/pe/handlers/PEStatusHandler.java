package com.sambaash.platform.pe.handlers;

import static com.sambaash.platform.model.payment.PaymentProvider.PAY_REFUND_IN_PROGRESS;
import static com.sambaash.platform.model.payment.PaymentProvider.PAY_REFUND_RESUME_STATE;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.exception.PEConfigException;
import com.sambaash.platform.pe.exception.PEProcessStateException;
import com.sambaash.platform.pe.helpers.PEAuditHelper;
import com.sambaash.platform.pe.helpers.PEMailHelper;
import com.sambaash.platform.pe.helpers.PEProcessStateHelper;
import com.sambaash.platform.pe.jaxb.PEProcessableNodeOutput;
import com.sambaash.platform.pe.jaxb.PEStatus;
import com.sambaash.platform.pe.payment.PEPaymentUtil;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStatusTypeLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class PEStatusHandler extends PESingleOutputNodeHandler {

	public PEStatusHandler(PEStatus node, PEDataSource ds) {
		super(node, ds);
	}

	@Override
	public PEProcessableNodeOutput process() throws PEConfigException, PEProcessStateException, SystemException {
		PEStatus status = (PEStatus) node;

		if (status.getStatusTypeId() == 0) {
			throw new PEConfigException(PEErrors.CONFIG_ERROR_STATUS_ZERO);
		}

		long oldStatusId = processState.getStatusTypeId();
		String oldStatus = processState.getStatus();

		boolean restoreLastStateAfterRefund = false;
		JSONObject lastStateJson = null;
		PEProcessStateDataAdapter dataAdapter = null;
		boolean isRefundInProgress = false;

		try {
			PEProcessStatusType statusType = PEProcessStatusTypeLocalServiceUtil
					.getPEProcessStatusType(status.getStatusTypeId());
			// setting current stage id
			processState.setSpPEProcessStageId(statusType.getSpPEProcessStageId());
			// handling for payment refund
			if (PEConstantsGlobal.STATUS_REFUNDED.equalsIgnoreCase(status.getStatus())) {
				dataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(processState);
				isRefundInProgress = "true"
						.equalsIgnoreCase(dataAdapter.getDataFromProcessState(PAY_REFUND_IN_PROGRESS));
				if (isRefundInProgress) {
					lastStateJson = JSONFactoryUtil
							.createJSONObject(dataAdapter.getDataFromProcessState(PAY_REFUND_RESUME_STATE));
					long savedStatusTypeId = Long.parseLong(lastStateJson.getString("statusTypeId"));
					PEProcessStatusType savedStatusType = PEProcessStatusTypeLocalServiceUtil
							.getPEProcessStatusType(savedStatusTypeId);
					if (savedStatusType.getSeqNo() == statusType.getSeqNo()) { // at
																				// same
																				// step,
																				// so,
																				// just
																				// do
																				// normal
																				// processing
						processState.setNodeIdLastDataSubmitted(
								Long.parseLong(lastStateJson.getString("nodeIdLastDataSubmitted")));
					} else {
						restoreLastStateAfterRefund = true; // otherwise, mark
															// to restore saved
															// state prior to
															// refund
					}
					PEPaymentUtil.clearRefundInfo(dataAdapter);
				}
			}
		} catch (PortalException e1) {
			throw new PEConfigException(PEErrors.format(PEErrors.STATUS_TYPE_NOT_FOUND_ARGS, status.getStatusTypeId()));
		}

		processState.setStatusTypeId(status.getStatusTypeId());
		processState.setStatus(status.getStatus());

		if (PEConstantsGlobal.STATUS_PENDING.equalsIgnoreCase(status.getStatus())) {
			// set the current status type approvers. these roles can
			// approve/reject this pending status
			processState.setCurrentStatusTypeApprovers(status.getApproverRoleIds());

			if (!ds.isSuppressMailNotifications()) {
				// Notify the approvers using mail
				try {
					notifyApprovers();
				} catch (Exception e) {
					_log.error("Error while notifying the approvers ", e);
				}

			}

		} else {
			// clearing any old data
			processState.setCurrentStatusTypeApprovers(StringPool.BLANK);
		}

		// do safe update. bcz if this node get's called before account creation
		// (Guest user case ) PEProcessStateHelper.updateProcessState() throws
		// exception
		// calling PEProcessStateHelper.updateProcessStateSafe will not update
		// process state for guest user. And process state will be updated once
		// user account gets created
		if (!restoreLastStateAfterRefund) {
			// defer saving of state for refund below
			PEProcessStateHelper.updateProcessStateSafe(processState, ds.getRequestData());
		}

		PEProcessableNodeOutput output = new PEProcessableNodeOutput();
		// output.setNextNodeId(status.getNextNodeId());
		proceedToNextNode(output, status.getNextNodeId());

		try {
			PEAuditHelper audit = ds.getAuditHelper();
			if (restoreLastStateAfterRefund) {
				audit.logStatusChangeByPE(status.getStatusTypeId(), status.getStatusTypeId(),
						PEConstantsGlobal.STATUS_APPROVED, PEConstantsGlobal.STATUS_REFUNDED, StringPool.BLANK,
						node.getNodeId(), -1);
				restoreSavedStateB4Refund(lastStateJson);
				PEProcessStateHelper.updateProcessStateSafe(processState, ds.getRequestData());
				output.setNextNodeId(processState.getNodeId());
			} else {
				long lastNodeIdSubmitted = ds.getNodeIdDataSubmitted();
				if (isRefundInProgress) {
					lastNodeIdSubmitted = Long.parseLong(lastStateJson.getString("nodeIdLastDataSubmitted"));
				}
				audit.logStatusChangeByPE(oldStatusId, processState.getStatusTypeId(), oldStatus,
						processState.getStatus(), StringPool.BLANK, node.getNodeId(), lastNodeIdSubmitted);
			}
			ds.setNodeIdDataSubmitted(0);
		} catch (Exception ex) {
			output.setError(PEErrors.AUDIT_STATUS);
		}

		return output;
	}

	private void restoreSavedStateB4Refund(JSONObject lastStateJson) {
		processState.setNodeId(Long.parseLong(lastStateJson.getString("nodeId")));
		processState.setNodeIdLastDataSubmitted(Long.parseLong(lastStateJson.getString("nodeIdLastDataSubmitted")));
		processState.setNodeIdLastDisplayed(Long.parseLong(lastStateJson.getString("nodeIdLastDisplayed")));
		processState.setNodeIdLastProcessed(Long.parseLong(lastStateJson.getString("nodeIdLastProcessed")));
		processState.setStatusTypeId(Long.parseLong(lastStateJson.getString("statusTypeId")));
		processState.setSpPEProcessStageId(Long.parseLong(lastStateJson.getString("spPEProcessStageId")));
		processState.setStatus(lastStateJson.getString("status"));
	}

	// Method used to send mail notifications to Approvers.
	// Approvers can be configured at each Status Type level or Process level
	private void notifyApprovers() throws SystemException {
		PEStatus status = (PEStatus) node;
		// getting the mail template
		SPMailTemplate mailTemplate = null;
		try {
			mailTemplate = SPMailTemplateLocalServiceUtil.getSPMailTemplate(status.getMailTemplateId());
		} catch (PortalException | SystemException e) {
			_log.error("Error while fetching mail template ", e);
			return;
		}

		String subjectFormat = mailTemplate.getSubject();
		String contentFormat = mailTemplate.getHtmlContent();

		// Get the mail helper. Here nodeId is required for logging purpose
		PEMailHelper mailHelper = PEMailHelper.getMailHelper(ds, status.getNodeId());

		// Status level approvers and Process level approvers
		String temp = status.getApproverRoleIds() + StringPool.COMMA + ds.getProcess().getApproveRoleIds();
		long[] roleIds = StringUtil.split(temp, StringPool.COMMA, 0l);// ArrayUtil.toLongArray(mailNode.getToRoleIds().split(StringPool.COMMA));
		_log.debug("Roles Ids to send mail : " + roleIds);
		for (long roleId : roleIds) {
			if (roleId > 0) {
				mailToOfficerRole(subjectFormat, contentFormat, roleId, mailHelper,
						SambaashUtil.getEmailFromName(ds.getCompanyId(), mailTemplate),
						SambaashUtil.getEmailFromAddress(ds.getCompanyId(), mailTemplate));
			}
		}
	}

	private void mailToOfficerRole(String subjectFormat, String contentFormat, long roleId, PEMailHelper mailHelper,
			String fromName, String fromAddress) throws SystemException {
		_log.debug("Sending mail to officer roleId " + roleId);
		List<User> officers = UserLocalServiceUtil.getRoleUsers(roleId);
		// Send mail to each user
		for (User officer : officers) {
			mailHelper.sendMailtoOfficer(officer, subjectFormat, contentFormat, fromName, fromAddress);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PEStatus.class);
}