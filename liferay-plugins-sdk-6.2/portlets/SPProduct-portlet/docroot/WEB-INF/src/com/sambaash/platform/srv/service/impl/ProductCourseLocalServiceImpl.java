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

import com.sambaash.platform.srv.service.base.ProductCourseLocalServiceBaseImpl;

/**
 * The implementation of the product course local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.service.ProductCourseLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.ProductCourseLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.ProductCourseLocalServiceUtil
 */
public class ProductCourseLocalServiceImpl
	extends ProductCourseLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.service.ProductCourseLocalServiceUtil} to access the product course local service.
	 */
	
	public java.util.List<com.sambaash.platform.srv.model.ProductCourse> findByCourseIdAndGroupId(
			long spCourseId, long groupId)
			throws com.liferay.portal.kernel.exception.SystemException{
		return productCoursePersistence.findByCourseIdAndGroupId(spCourseId, groupId);
	}
	
	public void clearCache() {
		productCoursePersistence.clearCache();
	}
	
}