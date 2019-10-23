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

package com.sambaash.platform.srv.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.model.ModuleFramework;

/**
 * The persistence interface for the module framework service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see ModuleFrameworkPersistenceImpl
 * @see ModuleFrameworkUtil
 * @generated
 */
public interface ModuleFrameworkPersistence extends BasePersistence<ModuleFramework> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ModuleFrameworkUtil} to access the module framework persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the module frameworks where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching module frameworks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the module frameworks where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleFrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of module frameworks
	* @param end the upper bound of the range of module frameworks (not inclusive)
	* @return the range of matching module frameworks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the module frameworks where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleFrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of module frameworks
	* @param end the upper bound of the range of module frameworks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module frameworks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first module framework in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module framework
	* @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a matching module framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleFramework findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleFrameworkException;

	/**
	* Returns the first module framework in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module framework, or <code>null</code> if a matching module framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleFramework fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last module framework in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module framework
	* @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a matching module framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleFramework findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleFrameworkException;

	/**
	* Returns the last module framework in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module framework, or <code>null</code> if a matching module framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleFramework fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the module frameworks before and after the current module framework in the ordered set where groupId = &#63;.
	*
	* @param spModuleFrameworkId the primary key of the current module framework
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next module framework
	* @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a module framework with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleFramework[] findByGroupId_PrevAndNext(
		long spModuleFrameworkId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleFrameworkException;

	/**
	* Removes all the module frameworks where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of module frameworks where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching module frameworks
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the module frameworks where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @return the matching module frameworks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findByModuleIdAndGroupId(
		long spModuleId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the module frameworks where spModuleId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleFrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param start the lower bound of the range of module frameworks
	* @param end the upper bound of the range of module frameworks (not inclusive)
	* @return the range of matching module frameworks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findByModuleIdAndGroupId(
		long spModuleId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the module frameworks where spModuleId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleFrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param start the lower bound of the range of module frameworks
	* @param end the upper bound of the range of module frameworks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module frameworks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findByModuleIdAndGroupId(
		long spModuleId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first module framework in the ordered set where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module framework
	* @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a matching module framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleFramework findByModuleIdAndGroupId_First(
		long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleFrameworkException;

	/**
	* Returns the first module framework in the ordered set where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module framework, or <code>null</code> if a matching module framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleFramework fetchByModuleIdAndGroupId_First(
		long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last module framework in the ordered set where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module framework
	* @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a matching module framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleFramework findByModuleIdAndGroupId_Last(
		long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleFrameworkException;

	/**
	* Returns the last module framework in the ordered set where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module framework, or <code>null</code> if a matching module framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleFramework fetchByModuleIdAndGroupId_Last(
		long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the module frameworks before and after the current module framework in the ordered set where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleFrameworkId the primary key of the current module framework
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next module framework
	* @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a module framework with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleFramework[] findByModuleIdAndGroupId_PrevAndNext(
		long spModuleFrameworkId, long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleFrameworkException;

	/**
	* Removes all the module frameworks where spModuleId = &#63; and groupId = &#63; from the database.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByModuleIdAndGroupId(long spModuleId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of module frameworks where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @return the number of matching module frameworks
	* @throws SystemException if a system exception occurred
	*/
	public int countByModuleIdAndGroupId(long spModuleId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the module frameworks where spFrameworkId = &#63; and groupId = &#63;.
	*
	* @param spFrameworkId the sp framework ID
	* @param groupId the group ID
	* @return the matching module frameworks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findByFrameworkIdAndGroupId(
		long spFrameworkId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the module frameworks where spFrameworkId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleFrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spFrameworkId the sp framework ID
	* @param groupId the group ID
	* @param start the lower bound of the range of module frameworks
	* @param end the upper bound of the range of module frameworks (not inclusive)
	* @return the range of matching module frameworks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findByFrameworkIdAndGroupId(
		long spFrameworkId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the module frameworks where spFrameworkId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleFrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spFrameworkId the sp framework ID
	* @param groupId the group ID
	* @param start the lower bound of the range of module frameworks
	* @param end the upper bound of the range of module frameworks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module frameworks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findByFrameworkIdAndGroupId(
		long spFrameworkId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first module framework in the ordered set where spFrameworkId = &#63; and groupId = &#63;.
	*
	* @param spFrameworkId the sp framework ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module framework
	* @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a matching module framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleFramework findByFrameworkIdAndGroupId_First(
		long spFrameworkId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleFrameworkException;

	/**
	* Returns the first module framework in the ordered set where spFrameworkId = &#63; and groupId = &#63;.
	*
	* @param spFrameworkId the sp framework ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module framework, or <code>null</code> if a matching module framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleFramework fetchByFrameworkIdAndGroupId_First(
		long spFrameworkId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last module framework in the ordered set where spFrameworkId = &#63; and groupId = &#63;.
	*
	* @param spFrameworkId the sp framework ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module framework
	* @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a matching module framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleFramework findByFrameworkIdAndGroupId_Last(
		long spFrameworkId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleFrameworkException;

	/**
	* Returns the last module framework in the ordered set where spFrameworkId = &#63; and groupId = &#63;.
	*
	* @param spFrameworkId the sp framework ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module framework, or <code>null</code> if a matching module framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleFramework fetchByFrameworkIdAndGroupId_Last(
		long spFrameworkId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the module frameworks before and after the current module framework in the ordered set where spFrameworkId = &#63; and groupId = &#63;.
	*
	* @param spModuleFrameworkId the primary key of the current module framework
	* @param spFrameworkId the sp framework ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next module framework
	* @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a module framework with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleFramework[] findByFrameworkIdAndGroupId_PrevAndNext(
		long spModuleFrameworkId, long spFrameworkId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleFrameworkException;

	/**
	* Removes all the module frameworks where spFrameworkId = &#63; and groupId = &#63; from the database.
	*
	* @param spFrameworkId the sp framework ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFrameworkIdAndGroupId(long spFrameworkId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of module frameworks where spFrameworkId = &#63; and groupId = &#63;.
	*
	* @param spFrameworkId the sp framework ID
	* @param groupId the group ID
	* @return the number of matching module frameworks
	* @throws SystemException if a system exception occurred
	*/
	public int countByFrameworkIdAndGroupId(long spFrameworkId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the module framework in the entity cache if it is enabled.
	*
	* @param moduleFramework the module framework
	*/
	public void cacheResult(
		com.sambaash.platform.srv.model.ModuleFramework moduleFramework);

	/**
	* Caches the module frameworks in the entity cache if it is enabled.
	*
	* @param moduleFrameworks the module frameworks
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.ModuleFramework> moduleFrameworks);

	/**
	* Creates a new module framework with the primary key. Does not add the module framework to the database.
	*
	* @param spModuleFrameworkId the primary key for the new module framework
	* @return the new module framework
	*/
	public com.sambaash.platform.srv.model.ModuleFramework create(
		long spModuleFrameworkId);

	/**
	* Removes the module framework with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spModuleFrameworkId the primary key of the module framework
	* @return the module framework that was removed
	* @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a module framework with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleFramework remove(
		long spModuleFrameworkId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleFrameworkException;

	public com.sambaash.platform.srv.model.ModuleFramework updateImpl(
		com.sambaash.platform.srv.model.ModuleFramework moduleFramework)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the module framework with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchModuleFrameworkException} if it could not be found.
	*
	* @param spModuleFrameworkId the primary key of the module framework
	* @return the module framework
	* @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a module framework with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleFramework findByPrimaryKey(
		long spModuleFrameworkId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleFrameworkException;

	/**
	* Returns the module framework with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spModuleFrameworkId the primary key of the module framework
	* @return the module framework, or <code>null</code> if a module framework with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleFramework fetchByPrimaryKey(
		long spModuleFrameworkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the module frameworks.
	*
	* @return the module frameworks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the module frameworks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleFrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of module frameworks
	* @param end the upper bound of the range of module frameworks (not inclusive)
	* @return the range of module frameworks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the module frameworks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleFrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of module frameworks
	* @param end the upper bound of the range of module frameworks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of module frameworks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the module frameworks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of module frameworks.
	*
	* @return the number of module frameworks
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}