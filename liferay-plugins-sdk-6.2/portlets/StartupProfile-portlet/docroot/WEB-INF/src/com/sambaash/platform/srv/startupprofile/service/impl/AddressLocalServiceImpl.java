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

package com.sambaash.platform.srv.startupprofile.service.impl;

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.srv.startupprofile.model.Address;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.service.base.AddressLocalServiceBaseImpl;

/**
 * The implementation of the address local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.startupprofile.service.AddressLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author pradeep
 * @see com.sambaash.platform.srv.startupprofile.service.base.AddressLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.startupprofile.service.AddressLocalServiceUtil
 */
public class AddressLocalServiceImpl extends AddressLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.startupprofile.service.AddressLocalServiceUtil} to access the address local service.
	 */
	
	public Address create() throws SystemException{
		long orgId = CounterLocalServiceUtil.increment("Address");
		return addressPersistence.create(orgId);
	}
	public List<Address> findByOrganizationId(long organizationId) {
		try {
			return getAddressPersistence().findByOrganizationId(organizationId);
		} catch (SystemException e) {
			return null;
		}
		
	}
	public List<Address> findByOrganizationIdAndHq(long organizationId,  boolean hq) {
		try {
			return getAddressPersistence().findByOrganizationIdAndHq(organizationId, hq);
		} catch (SystemException e) {
			return null;
		}
		
	}
	
}