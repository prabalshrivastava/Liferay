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

package com.sambaash.platform.srv.spservices.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException;
import com.sambaash.platform.srv.spservices.model.SPUserTypeConfig;
import com.sambaash.platform.srv.spservices.service.base.SPUserTypeConfigLocalServiceBaseImpl;

/**
 * The implementation of the s p user type config local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.spservices.service.SPUserTypeConfigLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.spservices.service.base.SPUserTypeConfigLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.SPUserTypeConfigLocalServiceUtil
 */
public class SPUserTypeConfigLocalServiceImpl extends SPUserTypeConfigLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.spservices.service.
	 * SPUserTypeConfigLocalServiceUtil} to access the s p user type config
	 * local service.
	 */

	private static final Log _log = LogFactoryUtil.getLog(SPUserTypeConfigLocalServiceImpl.class);

	public SPUserTypeConfig findByUserTypeAndVirtualHostId(String userType, long virtualHostId) throws SystemException {
		try {
			return getSPUserTypeConfigPersistence().findByUserTypeAndVirtualHostId(userType, virtualHostId);
		} catch (NoSuchSPUserTypeConfigException e) {
			_log.error(String.format("No SPUserTypeConfig found with UserType %s and VirtualHostId %s ", userType,
					virtualHostId));
		}
		return null;
	}

	public SPUserTypeConfig findByUserTypeIdAndVirtualHostId(long userTypeId, long virtualHostId)
			throws SystemException {
		try {
			return getSPUserTypeConfigPersistence().findByUserTypeIdAndVirtualHostId(userTypeId, virtualHostId);
		} catch (NoSuchSPUserTypeConfigException e) {
			_log.error(String.format("No SPUserTypeConfig found with UserTypeId %s and VirtualHostId %s ", userTypeId,
					virtualHostId));
		}
		return null;
	}

	public List<SPUserTypeConfig> findByUserTypeId(long userTypeId) throws SystemException {

		return getSPUserTypeConfigPersistence().findByUserTypeId(userTypeId);

	}

	public List<SPUserTypeConfig> findByVirtualHostId(long virtualHostId) throws SystemException {

		return getSPUserTypeConfigPersistence().findByVirtualHostId(virtualHostId);

	}

}