/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.sambaash.platform.srv.service.impl;

import java.util.List;

import com.sambaash.platform.srv.model.ModuleCertificate;
import com.sambaash.platform.srv.service.ModuleCertificateLocalServiceUtil;
import com.sambaash.platform.srv.service.base.ModuleCertificateLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the module certificate local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.service.ModuleCertificateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.ModuleCertificateLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.ModuleCertificateLocalServiceUtil
 */
public class ModuleCertificateLocalServiceImpl
	extends ModuleCertificateLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.service.ModuleCertificateLocalServiceUtil} to access the module certificate local service.
	 */
	public List<ModuleCertificate> findByModuleIdAndGroupId(long spModuleId, long groupId) throws SystemException{
		return moduleCertificatePersistence.findByModuleIdAndGroupId(spModuleId, groupId);
	}
	
	public void clearCache() {
		moduleCertificatePersistence.clearCache();
	}
	
	public ModuleCertificate create() throws SystemException{
		long moduleCertificateId = CounterLocalServiceUtil.increment("ModuleCertificate.class");
		ModuleCertificate moduleCertificateUnit = ModuleCertificateLocalServiceUtil
				.createModuleCertificate(moduleCertificateId);
		return moduleCertificateUnit;
	}
}