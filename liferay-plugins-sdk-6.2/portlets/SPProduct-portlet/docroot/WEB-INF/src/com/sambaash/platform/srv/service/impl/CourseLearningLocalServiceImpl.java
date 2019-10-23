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
import com.sambaash.platform.srv.NoSuchCourseLearningException;
import com.sambaash.platform.srv.model.CourseLearning;
import com.sambaash.platform.srv.service.base.CourseLearningLocalServiceBaseImpl;

/**
 * The implementation of the course learning local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.service.CourseLearningLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.CourseLearningLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.CourseLearningLocalServiceUtil
 */
public class CourseLearningLocalServiceImpl
	extends CourseLearningLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.service.CourseLearningLocalServiceUtil} to access the course learning local service.
	 */
	
	public CourseLearning findByCourseId(long courseId) throws NoSuchCourseLearningException, SystemException{
		return courseLearningPersistence.findByCourseId(courseId);
	}
	
	public CourseLearning create() throws SystemException{
		CourseLearning courseLearning = courseLearningPersistence.create(counterLocalService.increment("CourseLearning"));
		return courseLearning;
	}
}