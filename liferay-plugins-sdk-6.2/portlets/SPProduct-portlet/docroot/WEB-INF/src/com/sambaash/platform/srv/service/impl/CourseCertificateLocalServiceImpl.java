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

package com.sambaash.platform.srv.service.impl;

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.srv.model.CourseCertificate;
import com.sambaash.platform.srv.service.CourseCertificateLocalServiceUtil;
import com.sambaash.platform.srv.service.base.CourseCertificateLocalServiceBaseImpl;

/**
 * The implementation of the course certificate local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.service.CourseCertificateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.CourseCertificateLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.CourseCertificateLocalServiceUtil
 */
public class CourseCertificateLocalServiceImpl
	extends CourseCertificateLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.service.CourseCertificateLocalServiceUtil} to access the course certificate local service.
	 */
	
	public List<CourseCertificate> findByCourseIdAndGroupId(long spCourseId, long groupId) throws SystemException{
		return courseCertificatePersistence.findByCourseIdAndGroupId(spCourseId, groupId);
	}
	
	public void clearCache() {
		courseCertificatePersistence.clearCache();
	}
	
	public CourseCertificate create() throws SystemException{
		long courseCertificateId = CounterLocalServiceUtil.increment("CourseCertificate.class");
		CourseCertificate courseCertificateUnit = CourseCertificateLocalServiceUtil
				.createCourseCertificate(courseCertificateId);
		return courseCertificateUnit;
	}
	
}