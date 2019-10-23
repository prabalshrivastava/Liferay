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
import com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;
import com.sambaash.platform.srv.spservices.model.SPSiteSetup;
import com.sambaash.platform.srv.spservices.service.base.SPSiteSetupLocalServiceBaseImpl;
import com.sambaash.platform.srv.spservices.service.persistence.SPSiteSetupUtil;

/**
 * The implementation of the s p site setup local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.spservices.service.SPSiteSetupLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.spservices.service.base.SPSiteSetupLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.SPSiteSetupLocalServiceUtil
 */
public class SPSiteSetupLocalServiceImpl extends SPSiteSetupLocalServiceBaseImpl {
	
	private static Log _log = LogFactoryUtil.getLog(SPSiteSetupLocalServiceImpl.class);
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.spservices.service.SPSiteSetupLocalServiceUtil} to access the s p site setup local service.
	 */
	
	public List<SPSiteSetup> findBySubProductId(long subProductId) throws SystemException {
		return SPSiteSetupUtil.findBySubProductId(subProductId);
	}
	
	public List<SPSiteSetup> findByProductId(long productId) throws SystemException {
		return SPSiteSetupUtil.findByProductId(productId);
	}

	public List<SPSiteSetup> findByVirtualHostId(long virtualHostId) throws SystemException {
		return SPSiteSetupUtil.findByVirtualHostId(virtualHostId);
	}
	
	public List<SPSiteSetup> findByBackOfficeVirtualHostId(long virtualHostId) throws SystemException {
		return SPSiteSetupUtil.findByBackOfficeVirtualHostId(virtualHostId);
	}
	
	public SPSiteSetup findByProductIdAndSubProductId(long productId, long subProductId) throws SystemException {
		try {
			return SPSiteSetupUtil.findByProductIdAndSubProductId(productId, subProductId);
		} catch (NoSuchSPSiteSetupException e) {
			_log.error("No SPSiteSetup found for productId : " + productId + " : subProductId : " + subProductId);
		}
		return null;
	}
}