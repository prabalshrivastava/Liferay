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
import com.sambaash.platform.srv.NoSuchCourseCareerException;
import com.sambaash.platform.srv.model.CourseCareer;
import com.sambaash.platform.srv.service.base.CourseCareerLocalServiceBaseImpl;

/**
 * The implementation of the course career local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.service.CourseCareerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.CourseCareerLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.CourseCareerLocalServiceUtil
 */
public class CourseCareerLocalServiceImpl
	extends CourseCareerLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.service.CourseCareerLocalServiceUtil} to access the course career local service.
	 */
	
	public CourseCareer findByCourseId(long courseId) throws  SystemException, NoSuchCourseCareerException{
		return courseCareerPersistence.findByCourseId(courseId);
	}
	
	public CourseCareer create() throws SystemException{
		CourseCareer courseCareer = courseCareerPersistence.create(counterLocalService.increment("CourseCareer"));
		return courseCareer;
	}
}