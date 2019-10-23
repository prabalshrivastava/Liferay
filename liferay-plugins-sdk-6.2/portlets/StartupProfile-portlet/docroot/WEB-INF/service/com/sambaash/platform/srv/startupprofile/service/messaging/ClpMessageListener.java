/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sambaash.platform.srv.startupprofile.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.sambaash.platform.srv.startupprofile.service.ATODocumentLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.AccreditationLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.AddressLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.ApprovedMentorsLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.ClpSerializer;
import com.sambaash.platform.srv.startupprofile.service.EmployeeInfoLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.FundingRoundLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.GuidelinesLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.OrganisationRemarksLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.OrganizationServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.PersonLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.PrinciplesLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.QuestionnaireLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.ReAccreditationLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.RelationshipLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.SPATOContactsLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.SPOrgContactUsLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.StartupProfileLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.StartupProfileServiceUtil;

/**
 * @author pradeep
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			AccreditationLocalServiceUtil.clearService();

			AddressLocalServiceUtil.clearService();

			ApprovedMentorsLocalServiceUtil.clearService();

			ATODocumentLocalServiceUtil.clearService();

			EmployeeInfoLocalServiceUtil.clearService();

			FundingRoundLocalServiceUtil.clearService();

			GuidelinesLocalServiceUtil.clearService();

			OrganisationRemarksLocalServiceUtil.clearService();

			OrganizationLocalServiceUtil.clearService();

			OrganizationServiceUtil.clearService();
			PersonLocalServiceUtil.clearService();

			PrinciplesLocalServiceUtil.clearService();

			QuestionnaireLocalServiceUtil.clearService();

			ReAccreditationLocalServiceUtil.clearService();

			RelationshipLocalServiceUtil.clearService();

			SPATOContactsLocalServiceUtil.clearService();

			SPOrgContactUsLocalServiceUtil.clearService();

			StartupProfileLocalServiceUtil.clearService();

			StartupProfileServiceUtil.clearService();
		}
	}
}