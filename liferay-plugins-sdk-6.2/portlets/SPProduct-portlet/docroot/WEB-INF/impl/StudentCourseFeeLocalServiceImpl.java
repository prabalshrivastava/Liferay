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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.sambaash.platform.srv.NoSuchStudentCourseFeeException;
import com.sambaash.platform.srv.model.StudentCourseFee;
import com.sambaash.platform.srv.service.base.StudentCourseFeeLocalServiceBaseImpl;
import com.sambaash.platform.srv.service.persistence.StudentCourseFeeUtil;

/**
 * The implementation of the student course fee local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.service.StudentCourseFeeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.StudentCourseFeeLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.StudentCourseFeeLocalServiceUtil
 */
public class StudentCourseFeeLocalServiceImpl
	extends StudentCourseFeeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.service.StudentCourseFeeLocalServiceUtil} to access the student course fee local service.
	 */
	
	public List<StudentCourseFee> findByProcessStateId(long processStateId) throws SystemException{
		OrderByComparator comparator = OrderByComparatorFactoryUtil.create("StudentCourseFee", "order",true);
		return StudentCourseFeeUtil.findByprocessStateId(processStateId,-1,-1,comparator);
	}
	public StudentCourseFee findByProcessStateIdFeeType(long processStateId,String feeType) throws SystemException, NoSuchStudentCourseFeeException{
		return StudentCourseFeeUtil.findByprocessStateIdFeeType(processStateId,feeType);
	}
	
	public StudentCourseFee create() throws SystemException{
		long id = counterLocalService.increment("StudentCourseFee");
		return studentCourseFeePersistence.create(id);
	}
	
}