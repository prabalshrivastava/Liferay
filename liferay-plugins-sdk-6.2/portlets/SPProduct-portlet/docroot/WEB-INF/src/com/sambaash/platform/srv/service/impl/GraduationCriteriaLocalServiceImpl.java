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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.srv.model.GraduationCriteria;
import com.sambaash.platform.srv.service.GraduationCriteriaLocalServiceUtil;
import com.sambaash.platform.srv.service.base.GraduationCriteriaLocalServiceBaseImpl;

/**
 * The implementation of the graduation criteria local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.service.GraduationCriteriaLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.GraduationCriteriaLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.GraduationCriteriaLocalServiceUtil
 */
public class GraduationCriteriaLocalServiceImpl extends GraduationCriteriaLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.service.GraduationCriteriaLocalServiceUtil} to
	 * access the graduation criteria local service.
	 */

	public java.util.List<com.sambaash.platform.srv.model.GraduationCriteria> findByCourseIdAndGroupId(long spCourseId,
			long groupId) throws com.liferay.portal.kernel.exception.SystemException {
		return graduationCriteriaPersistence.findByCourseIdAndGroupId(spCourseId, groupId);
	}

	public void clearCache() {
		graduationCriteriaPersistence.clearCache();
	}
	
	public GraduationCriteria create() throws SystemException{
		long criteriaId = CounterLocalServiceUtil.increment("GraduationCriteria.class");
		
		GraduationCriteria criteria = GraduationCriteriaLocalServiceUtil.createGraduationCriteria(criteriaId);
		return criteria;
	}

}