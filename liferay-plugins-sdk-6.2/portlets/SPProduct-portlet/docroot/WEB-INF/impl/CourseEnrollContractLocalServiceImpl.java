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

import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.srv.NoSuchCourseEnrollContractException;
import com.sambaash.platform.srv.model.CourseEnrollContract;
import com.sambaash.platform.srv.service.base.CourseEnrollContractLocalServiceBaseImpl;
import com.sambaash.platform.srv.service.persistence.CourseEnrollContractUtil;

/**
 * The implementation of the course enroll contract local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.service.CourseEnrollContractLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.CourseEnrollContractLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.CourseEnrollContractLocalServiceUtil
 */
public class CourseEnrollContractLocalServiceImpl
	extends CourseEnrollContractLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.service.CourseEnrollContractLocalServiceUtil} to access the course enroll contract local service.
	 */
	public List<CourseEnrollContract> findByCountryIdCourseType(String countryId, long courseType) throws SystemException {
		return CourseEnrollContractUtil.findBycountryIdCourseType(countryId, courseType);
	}
	public CourseEnrollContract findByCountryIdCourseTypeDocType(String countryId, long courseType,String docType) throws SystemException, NoSuchCourseEnrollContractException {
		return CourseEnrollContractUtil.findBycountryIdCourseTypeDocType(countryId, courseType,docType);
	}
}