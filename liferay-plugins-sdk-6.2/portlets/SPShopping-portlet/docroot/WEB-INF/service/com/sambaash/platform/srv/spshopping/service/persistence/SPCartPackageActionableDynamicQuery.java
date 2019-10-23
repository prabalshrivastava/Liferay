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

package com.sambaash.platform.srv.spshopping.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sambaash.platform.srv.spshopping.model.SPCartPackage;
import com.sambaash.platform.srv.spshopping.service.SPCartPackageLocalServiceUtil;

/**
 * @author pradeep
 * @generated
 */
public abstract class SPCartPackageActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public SPCartPackageActionableDynamicQuery() throws SystemException {
		setBaseLocalService(SPCartPackageLocalServiceUtil.getService());
		setClass(SPCartPackage.class);

		setClassLoader(com.sambaash.platform.srv.spshopping.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("spCartPackageId");
	}
}