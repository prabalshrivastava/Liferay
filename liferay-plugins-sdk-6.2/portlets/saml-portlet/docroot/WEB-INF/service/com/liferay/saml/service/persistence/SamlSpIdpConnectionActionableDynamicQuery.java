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

package com.liferay.saml.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.liferay.saml.model.SamlSpIdpConnection;
import com.liferay.saml.service.SamlSpIdpConnectionLocalServiceUtil;

/**
 * @author Mika Koivisto, W. Berks
 * @generated
 */
public abstract class SamlSpIdpConnectionActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public SamlSpIdpConnectionActionableDynamicQuery()
		throws SystemException {
		setBaseLocalService(SamlSpIdpConnectionLocalServiceUtil.getService());
		setClass(SamlSpIdpConnection.class);

		setClassLoader(com.liferay.saml.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("samlSpIdpConnectionId");
	}
}