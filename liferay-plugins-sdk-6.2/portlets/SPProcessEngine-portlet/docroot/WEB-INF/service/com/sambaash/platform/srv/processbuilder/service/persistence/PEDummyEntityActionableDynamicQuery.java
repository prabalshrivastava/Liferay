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

package com.sambaash.platform.srv.processbuilder.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sambaash.platform.srv.processbuilder.model.PEDummyEntity;
import com.sambaash.platform.srv.processbuilder.service.PEDummyEntityLocalServiceUtil;

/**
 * @author nareshchebolu
 * @generated
 */
public abstract class PEDummyEntityActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public PEDummyEntityActionableDynamicQuery() throws SystemException {
		setBaseLocalService(PEDummyEntityLocalServiceUtil.getService());
		setClass(PEDummyEntity.class);

		setClassLoader(com.sambaash.platform.srv.processbuilder.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("spPEDummyEntityId");
	}
}