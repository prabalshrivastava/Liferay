package com.sambaash.platform.portlet.pe.listener;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PERequestData;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.helpers.PEOutputHelper;
import com.sambaash.platform.portlet.pe.constants.SPProcessStateConstants;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType;
import com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.persistence.PEProcessStatusTypeUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class SPPEProcessAuditListener extends BaseModelListener<PEProcessAudit> {
	private static final Log _log = LogFactoryUtil.getLog(SPPEProcessAuditListener.class);

	@Override
	public void onAfterCreate(PEProcessAudit processAudit) throws ModelListenerException {
		notifyPEProcessAuditActivity(SPProcessStateConstants.NOTIFICATION_TYPE_CREATED, processAudit);
	}

	protected void notifyPEProcessAuditActivity(int type, PEProcessAudit processAudit) {

		long userId = processAudit.getUserId();

		PEProcess pEProcess = null;
		
		try {
			if (processAudit.getType().equalsIgnoreCase("mail")) {

				String assignedTo = processAudit.getField1();
				long assignedToUserId = 0;
				if (Validator.isEmailAddress(assignedTo)) {
					try {
						assignedToUserId = UserLocalServiceUtil.getUserIdByEmailAddress(processAudit.getCompanyId(),
								assignedTo);
					} catch (NoSuchUserException e) {
						_log.error(e);
					}
				} else if (Validator.isNumber(assignedTo)) {
					assignedToUserId = Long.parseLong(assignedTo);
				}
				if (assignedToUserId != 0) {
					pEProcess = PEProcessLocalServiceUtil.getPEProcess(processAudit.getSpPEProcessId());
					String pageName = pEProcess.getApproverPageName();
					PEProcessState state = PEProcessStateLocalServiceUtil.getPEProcessState(processAudit.getSpPEProcessStateId());
					boolean isApplicant = (state.getUserIdProcess() == assignedToUserId);
					JSONObject field1 = JSONFactoryUtil.createJSONObject(processAudit.getData1());
					String title = field1.getString("subject");
					String statusTypeParam = "/0";
					if (isApplicant) {
						statusTypeParam = getStatusTypeParam(state);
						pageName = pEProcess.getUserPageName();
					} else {
						// only if Candidate Name is not on the title itself, append it
						if (!title.contains(UserLocalServiceUtil.getUser(state.getUserIdProcess()).getFullName())) {
							title += " - " + UserLocalServiceUtil.getUser(state.getUserIdProcess()).getFullName();							
						}
					}
					String link = pageName + "/-/process/view/" + processAudit.getSpPEProcessStateId() + statusTypeParam;
					if (isApplicant && !pageName.startsWith("http")) {
						String portalUrl = SambaashUtil.getPortalURL(pEProcess.getCompanyId(), pEProcess.getGroupId());
						_log.debug("portalUrl -> "+portalUrl);
						link = SambaashUtil.getSPSiteURL(pEProcess.getProductTypeId(),
								pEProcess.getSubProductTypeId(), portalUrl, false) + link;	
						_log.debug("applicant notification link -> "+link);
					}
					org.json.JSONObject stateData = new org.json.JSONObject(state.getData());
					String actionLinkParam = String.format("mail_%d.actionLink", processAudit.getNodeId());
					if (stateData.has(actionLinkParam)) {
						PERequestData requestData = PERequestData.getRequestDataUsingProcessStateId(state.getSpPEProcessStateId(), false);
						PEDataSource dataSource = PEOutputHelper.prepareDataSource(requestData, state);
						link = dataSource.replaceTokensInData(stateData.getString(actionLinkParam), true);
						_log.info("Override notification link -> "+link);
					}

					_log.debug("addTimelineActivity link -> "+link);
					SystemLocalServiceUtil.addTimelineActivity(link, "View Details", title,
							pEProcess.getEntityTitle(), StringPool.BLANK, processAudit.getStatus(), userId,
							pEProcess.getName(), pEProcess.getEntityTitle(),
							String.valueOf(pEProcess.getSubProductTypeId()), StringPool.BLANK,
							String.valueOf(assignedToUserId), SambaashUtil.getScopeGroupId(processAudit.getGroupId()));

				} else {
					_log.error(String.format("Failed to add timeline activity %s", processAudit.toString()));
				}
			}
		} catch (Exception e) { // to catch runtime as well
			_log.error("Unable to add timeline activity", e);
		}

	}

	private String getStatusTypeParam(PEProcessState state) throws SystemException {
		PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(state);
		String peTimelineStatusType = dataAdapter.getDataFromProcessState("peTimelineStatusType");
		if (StringUtils.isNotEmpty(peTimelineStatusType)) {
			PEProcessStatusType currentStatus = PEProcessStatusTypeUtil.fetchByPrimaryKey(state.getStatusTypeId());
			PEProcessStatusType notifStatus = PEProcessStatusTypeUtil.fetchByPrimaryKey(Long.parseLong(peTimelineStatusType));
			if (currentStatus.getSeqNo() > notifStatus.getSeqNo()) {
				// already pass the notification step, then it can set this specific step in the link
				return String.format("/%d", notifStatus.getSpPEProcessStatusTypeId());
			}
		}
		return "/0";
	}

}
