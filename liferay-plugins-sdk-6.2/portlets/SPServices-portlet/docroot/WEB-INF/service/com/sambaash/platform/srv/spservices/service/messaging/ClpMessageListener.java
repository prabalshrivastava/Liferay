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

package com.sambaash.platform.srv.spservices.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.sambaash.platform.srv.spservices.service.ClpSerializer;
import com.sambaash.platform.srv.spservices.service.MembershipPackageAddonServicesLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.MembershipPackageGrpServicesLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.MembershipPackageIndServicesLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.MembershipPackageLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.MembershipPackagePromotionCodeLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.MembershipPackageServicesRolesLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.MembershipSubscribedServicesLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.MembershipSubscriptionAddonServicesLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.MembershipSubscriptionLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPApiAuditLogsLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPAuditLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPIPGeoLocationLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPLdapMappingLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPLdapProfileLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPLikesLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPListTypeServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPSiteLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPSiteSetupLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPUserTypeConfigLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPUserTypeLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPUserTypeServiceUtil;
import com.sambaash.platform.srv.spservices.service.ServiceComponentGroupLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.ServiceComponentsLocalServiceUtil;

/**
 * @author gauravvijayvergia
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
			MembershipPackageLocalServiceUtil.clearService();

			MembershipPackageAddonServicesLocalServiceUtil.clearService();

			MembershipPackageGrpServicesLocalServiceUtil.clearService();

			MembershipPackageIndServicesLocalServiceUtil.clearService();

			MembershipPackagePromotionCodeLocalServiceUtil.clearService();

			MembershipPackageServicesRolesLocalServiceUtil.clearService();

			MembershipSubscribedServicesLocalServiceUtil.clearService();

			MembershipSubscriptionLocalServiceUtil.clearService();

			MembershipSubscriptionAddonServicesLocalServiceUtil.clearService();

			ServiceComponentGroupLocalServiceUtil.clearService();

			ServiceComponentsLocalServiceUtil.clearService();

			SPApiAuditLogsLocalServiceUtil.clearService();

			SPAuditLocalServiceUtil.clearService();

			SPIPGeoLocationLocalServiceUtil.clearService();

			SPLdapMappingLocalServiceUtil.clearService();

			SPLdapProfileLocalServiceUtil.clearService();

			SPLikesLocalServiceUtil.clearService();

			SPListTypeLocalServiceUtil.clearService();

			SPListTypeServiceUtil.clearService();
			SPParameterLocalServiceUtil.clearService();

			SPSiteLocalServiceUtil.clearService();

			SPSiteSetupLocalServiceUtil.clearService();

			SPUserTypeLocalServiceUtil.clearService();

			SPUserTypeServiceUtil.clearService();
			SPUserTypeConfigLocalServiceUtil.clearService();
		}
	}
}