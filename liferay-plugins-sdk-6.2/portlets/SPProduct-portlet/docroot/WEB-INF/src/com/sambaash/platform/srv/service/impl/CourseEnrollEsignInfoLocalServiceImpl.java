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

import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException;
import com.sambaash.platform.srv.model.CourseEnrollEsignInfo;
import com.sambaash.platform.srv.service.base.CourseEnrollEsignInfoLocalServiceBaseImpl;
import com.sambaash.platform.srv.service.persistence.CourseEnrollEsignInfoUtil;

/**
 * The implementation of the course enroll esign info local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.service.CourseEnrollEsignInfoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.CourseEnrollEsignInfoLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.CourseEnrollEsignInfoLocalServiceUtil
 */
public class CourseEnrollEsignInfoLocalServiceImpl
	extends CourseEnrollEsignInfoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.service.CourseEnrollEsignInfoLocalServiceUtil} to access the course enroll esign info local service.
	 */
	public CourseEnrollEsignInfo create() throws SystemException {
		CourseEnrollEsignInfo esignInfo = courseEnrollEsignInfoPersistence.create(counterLocalService.increment("CourseEnrollEsignInfo"));
		return esignInfo;
	}
	
	public CourseEnrollEsignInfo findBySignerId(String signerId) throws SystemException, NoSuchCourseEnrollEsignInfoException{
		return CourseEnrollEsignInfoUtil.findBySignerId(signerId);
	}
	public CourseEnrollEsignInfo findByPackageId(String PackageId) throws  SystemException, NoSuchCourseEnrollEsignInfoException{
		return CourseEnrollEsignInfoUtil.findByPackageId(PackageId);
	}
	public CourseEnrollEsignInfo findByDocumentId(String DocumentId) throws  SystemException, NoSuchCourseEnrollEsignInfoException{
		return CourseEnrollEsignInfoUtil.findByDocumentId(DocumentId);
	}
	public CourseEnrollEsignInfo findByProcessStateId(long processStateId) throws  SystemException, NoSuchCourseEnrollEsignInfoException{
		return CourseEnrollEsignInfoUtil.findByProcessStateId(processStateId);
	}
}