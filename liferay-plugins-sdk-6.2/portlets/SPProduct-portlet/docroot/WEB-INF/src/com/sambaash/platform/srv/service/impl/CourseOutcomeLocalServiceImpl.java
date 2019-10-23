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
import com.sambaash.platform.srv.model.CourseOutcome;
import com.sambaash.platform.srv.service.CourseOutcomeLocalServiceUtil;
import com.sambaash.platform.srv.service.base.CourseOutcomeLocalServiceBaseImpl;

/**
 * The implementation of the course outcome local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.service.CourseOutcomeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.CourseOutcomeLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.CourseOutcomeLocalServiceUtil
 */
public class CourseOutcomeLocalServiceImpl
	extends CourseOutcomeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.service.CourseOutcomeLocalServiceUtil} to access the course outcome local service.
	 */
	
	public List<CourseOutcome> findByCourseIdAndGroupId(long spCourseId, long groupId) throws SystemException{
		return courseOutcomePersistence.findByCourseIdAndGroupId(spCourseId, groupId);
	}
	
	public void clearCache() {
		courseOutcomePersistence.clearCache();
	}
	
	public CourseOutcome create() throws SystemException{
		long spCourseOutcomeId = CounterLocalServiceUtil.increment("CourseOutcome.class");
		CourseOutcome courseOutcome = CourseOutcomeLocalServiceUtil.createCourseOutcome(spCourseOutcomeId);
		return courseOutcome;
	}
}