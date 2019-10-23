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

package com.sambaash.platform.srv.spshopping.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.sambaash.platform.srv.spshopping.service.ClpSerializer;
import com.sambaash.platform.srv.spshopping.service.SPCartLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPCartPackageItemLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPCartPackageLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPDiscountLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPPackageItemsLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPSellingItemLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPSellingPackageLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPSellingPriceLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPShoppingLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPShoppingServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPTaxLocalServiceUtil;

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
			SPCartLocalServiceUtil.clearService();

			SPCartPackageLocalServiceUtil.clearService();

			SPCartPackageItemLocalServiceUtil.clearService();

			SPDiscountLocalServiceUtil.clearService();

			SPPackageItemsLocalServiceUtil.clearService();

			SPSellingItemLocalServiceUtil.clearService();

			SPSellingPackageLocalServiceUtil.clearService();

			SPSellingPriceLocalServiceUtil.clearService();

			SPShoppingLocalServiceUtil.clearService();

			SPShoppingServiceUtil.clearService();
			SPTaxLocalServiceUtil.clearService();
		}
	}
}