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

package com.sambaash.platform.srv.roles.service.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.sambaash.platform.srv.roles.NoSuchSPRolesException;
import com.sambaash.platform.srv.roles.model.SPRoles;
import com.sambaash.platform.srv.roles.service.base.SPRolesLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the s p roles local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.roles.service.SPRolesLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.roles.service.base.SPRolesLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.roles.service.SPRolesLocalServiceUtil
 */
public class SPRolesLocalServiceImpl extends SPRolesLocalServiceBaseImpl {
	public List<SPRoles> findByCategoryId1(long groupId, long categoryId)throws SystemException {
		return spRolesPersistence.findByCategoryId1(groupId, categoryId);
	}

	public List<SPRoles> findByCategoryId1(long groupId, long categoryId, int start, int end)throws SystemException {
		return spRolesPersistence.findByCategoryId1(groupId, categoryId, start, end);
	}

	public List<SPRoles> findByCountryCategoryId(long groupId, long userId) throws SystemException {
		return spRolesPersistence.findByCountryCategoryId(groupId, userId);
	}

	public List<SPRoles> findByCountryCategoryIdAndDepartmentCategoryId(long groupId, long countryCategoryId, long departmentCategoryId) throws SystemException {
		return spRolesPersistence.findByCountryCategoryIdAndDepartmentCategoryId(groupId, countryCategoryId, departmentCategoryId);
	}

	public List<SPRoles> findByDepartmentCategoryId(long groupId, long countryCategoryId) throws SystemException {
		return spRolesPersistence.findByDepartmentCategoryId(groupId, countryCategoryId);
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.roles.service.SPRolesLocalServiceUtil} to access the s p roles local service.
	 */

	public List<SPRoles> findByRoleId(long groupId, long roleId)throws SystemException {
		return spRolesPersistence.findByRoleId(groupId, roleId);
	}

	public List<SPRoles> findByRoleIdCategoryId1(long groupId, long roleId, long categoryId)throws SystemException {
		return spRolesPersistence.findByRoleIdCategoryId1(groupId, roleId, categoryId);
	}

	public List<SPRoles> findByRoleIdCategoryId1(long groupId, long roleId, long categoryId, int start, int end)throws SystemException {
		return spRolesPersistence.findByRoleIdCategoryId1(groupId, roleId, categoryId, start, end);
	}

	public SPRoles findByRoleIdCategoryId1AndCategoryId2(long groupId, long roleId, long categoryId1, long categoryId2)
			throws NoSuchSPRolesException, SystemException {
		return spRolesPersistence.findByRoleIdCategoryId1AndCategoryId2(groupId, roleId, categoryId1, categoryId2);
	}

	public List<SPRoles> findByRoleIdCategoryId2(long groupId, long roleId, long categoryId) throws SystemException {
		return spRolesPersistence.findByRoleIdCategoryId2(groupId, roleId, categoryId);
	}

	public List<SPRoles> findByRoleIdCategoryId2(long groupId, long roleId, long categoryId, int start, int end)throws SystemException {
		return spRolesPersistence.findByRoleIdCategoryId2(groupId, roleId, categoryId, start, end);
	}

}