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

package com.sambaash.platform.srv.spmicroservice.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.sambaash.platform.srv.spmicroservice.service.CandidateMicroserviceLocalServiceUtil;
import com.sambaash.platform.srv.spmicroservice.service.ClpSerializer;
import com.sambaash.platform.srv.spmicroservice.service.EnrolmentMicroserviceLocalServiceUtil;
import com.sambaash.platform.srv.spmicroservice.service.FormsMicroserviceLocalServiceUtil;
import com.sambaash.platform.srv.spmicroservice.service.PricingMicroserviceLocalServiceUtil;
import com.sambaash.platform.srv.spmicroservice.service.RulesMicroserviceLocalServiceUtil;
import com.sambaash.platform.srv.spmicroservice.service.SPMicroserviceLocalServiceUtil;
import com.sambaash.platform.srv.spmicroservice.service.SPMicroserviceServiceUtil;
import com.sambaash.platform.srv.spmicroservice.service.SystemSetupMicroserviceLocalServiceUtil;

/**
 * @author glenn
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
			CandidateMicroserviceLocalServiceUtil.clearService();

			EnrolmentMicroserviceLocalServiceUtil.clearService();

			FormsMicroserviceLocalServiceUtil.clearService();

			PricingMicroserviceLocalServiceUtil.clearService();

			RulesMicroserviceLocalServiceUtil.clearService();

			SPMicroserviceLocalServiceUtil.clearService();

			SPMicroserviceServiceUtil.clearService();
			SystemSetupMicroserviceLocalServiceUtil.clearService();
		}
	}
}