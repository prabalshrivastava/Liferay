package com.sambaash.platform.pe.handlers.job.listener;

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
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class AnnualDeclarationJob extends AbstractJobListener {
	private static final Log LOG = LogFactoryUtil.getLog(AnnualDeclarationJob.class);

	@Override
	protected void doJobExecutionLogic() throws SystemException {
		LOG.error("Executing Job Logic of AnnualDeclarationJob");

		String renewalUrl = SambaashUtil.getParameter("renewal.url", SambaashConstants.DEFAULT_GROUP_ID_LONG);
		if (Validator.isNull(renewalUrl)) {
			renewalUrl = "/c/portal/terms_of_use";
		}

		List<Organization> orgList = OrganizationLocalServiceUtil.getAllActiveOrganizations();

		for (Organization org : orgList) {

			LOG.error(String.format("Sending notification to orgId %s, orgName %s", org.getOrganizationId(),
					org.getName()));
			JSONObject json = JSONFactoryUtil.createJSONObject();
			PEMailHandler mailHandler = new PEMailHandler((PEMail) dataSource.getDirectory().getNode(nodeId),
					dataSource);
			json.put(PEConstants.ORGANIZATION_ID, org.getOrganizationId());
			json.put(PEConstants.ACTIVITY, StringPool.TRUE);
			json.put(PEConstants.RENEWAL_URL, renewalUrl);
			json.put(PEConstants.RENEWAL_STATUS, "Annual Declaration");
			json.put(PEConstants.TITLE, org.getName() + ": Annual Declaration Notification");

			mailHandler.setAdditionalData(json);
			mailHandler.process();
		}
	}

	@Override
	protected boolean canExecuteJob() {
		return true;
	}

}
