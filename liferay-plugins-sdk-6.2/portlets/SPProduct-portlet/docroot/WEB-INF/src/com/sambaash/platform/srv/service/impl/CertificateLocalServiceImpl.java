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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.srv.NoSuchCertificateException;
import com.sambaash.platform.srv.model.Certificate;
import com.sambaash.platform.srv.service.CertificateLocalServiceUtil;
import com.sambaash.platform.srv.service.base.CertificateLocalServiceBaseImpl;

/**
 * The implementation of the certificate local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.service.CertificateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.CertificateLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.CertificateLocalServiceUtil
 */
public class CertificateLocalServiceImpl extends CertificateLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.service.CertificateLocalServiceUtil} to access the certificate local service.
	 */
	
	public Certificate create() throws SystemException{
		long certificateId = CounterLocalServiceUtil.increment("Certificate.class");
		Certificate certificate = CertificateLocalServiceUtil.createCertificate(certificateId);
		return certificate;
	}
	
	public void clearCache() {
		certificatePersistence.clearCache();
	}
	
	public List<Certificate> findByCertificateCode(String certificateCode) throws SystemException, NoSuchCertificateException{
		return certificatePersistence.findBycertificateCode(certificateCode);
	}
	
	public Certificate findByCertificateNameAndGroupId(String certificateName, long groupId) throws SystemException, NoSuchCertificateException{
		return certificatePersistence.findByCertificateNameAndGroupId(certificateName, groupId);
	}
	
}