package com.sambaash.platform.pe.handlers.job.listener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.handlers.PEMailHandler;
import com.sambaash.platform.pe.jaxb.PEMail;
import com.sambaash.platform.srv.mail.service.SPEMailAuditLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class CheckATOExpiryToSendMailJob extends AbstractJobListener {
	private static final Log LOG = LogFactoryUtil.getLog(CheckATOExpiryToSendMailJob.class);

	@Override
	protected void doJobExecutionLogic() throws SystemException {
		LOG.error("Executing Job Logic of CheckATOExpiryToSendMailJob");

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		String renewalUrl = SambaashUtil.getParameter("renewal.url", SambaashConstants.DEFAULT_GROUP_ID_LONG);
		if (Validator.isNull(renewalUrl)) {
			renewalUrl = "/ato-renewal";
		}

		List<Organization> orgList = OrganizationLocalServiceUtil.getATOsForExpiryNotification();

		for (Organization org : orgList) {

			LOG.error(String.format("Sending notification to orgId %s, orgName %s", org.getOrganizationId(),
					org.getName()));

			JSONObject json = JSONFactoryUtil.createJSONObject();

			try {
				List<Object> spEMailAuditList = SPEMailAuditLocalServiceUtil.findEMailsTriggered(processStateId, nodeId,
						org.getOrganizationId());
				if (Validator.isNotNull(spEMailAuditList)) {
					LOG.error(spEMailAuditList.size());
				}

				if (Validator.isNull(spEMailAuditList) || spEMailAuditList.size() == 1) {
					json.put(PEConstants.CURRENT_TEMPLATE, String.valueOf(1));
				} else if (Validator.isNotNull(spEMailAuditList) && spEMailAuditList.size() == 2) {
					json.put(PEConstants.CURRENT_TEMPLATE, String.valueOf(2));
				} else if (Validator.isNotNull(spEMailAuditList) && spEMailAuditList.size() == 3) {
					json.put(PEConstants.CURRENT_TEMPLATE, String.valueOf(3));
				}

			} catch (Exception e) {
				LOG.error(e.getMessage());
			}

			PEMailHandler mailHandler = new PEMailHandler((PEMail) dataSource.getDirectory().getNode(nodeId),
					dataSource);
			if (Validator.isNotNull(org.getApprovalDate())) {
				Integer days = OrganizationLocalServiceUtil.getATOExpiryPeriodParam();
				Calendar orgExpiryDate = Calendar.getInstance();
				orgExpiryDate.setTime(org.getApprovalDate());
				orgExpiryDate.add(Calendar.DATE, days);
				Date expiryDate = SambaashUtil.getLastDayOfQuarter(orgExpiryDate.getTime());
				LOG.error(String.format("Approval Date %s, Expiry Date %s, Derived Expiry Date %s",
						org.getApprovalDate(), orgExpiryDate.getTime(), df.format(expiryDate)));
				json.put(PEConstants.EXPIRY_DATE, df.format(expiryDate));
			}

			json.put(PEConstants.ORGANIZATION_ID, org.getOrganizationId());
			json.put(PEConstants.ACTIVITY, StringPool.TRUE);
			json.put(PEConstants.RENEWAL_URL, renewalUrl);
			json.put(PEConstants.RENEWAL_STATUS, "Pending Renewal");
			json.put(PEConstants.TITLE, org.getName() + ": Pending Renewal Notification");

			mailHandler.setAdditionalData(json);
			mailHandler.process();
		}
	}

	// private String getCurrentTemplate(List<Object> spEMailAuditList){
	//
	// for ( spEMailAuditList)
	//
	// }

	@Override
	protected boolean canExecuteJob() {
		return true;
	}

}
