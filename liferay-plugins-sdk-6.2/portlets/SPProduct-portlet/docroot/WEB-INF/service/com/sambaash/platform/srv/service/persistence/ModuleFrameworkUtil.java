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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.model.ModuleFramework;

import java.util.List;

/**
 * The persistence utility for the module framework service. This utility wraps {@link ModuleFrameworkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see ModuleFrameworkPersistence
 * @see ModuleFrameworkPersistenceImpl
 * @generated
 */
public class ModuleFrameworkUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ModuleFramework moduleFramework) {
		getPersistence().clearCache(moduleFramework);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ModuleFramework> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ModuleFramework> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ModuleFramework> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ModuleFramework update(ModuleFramework moduleFramework)
		throws SystemException {
		return getPersistence().update(moduleFramework);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ModuleFramework update(ModuleFramework moduleFramework,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(moduleFramework, serviceContext);
	}

	/**
	* Returns all the module frameworks where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching module frameworks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first module framework in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module framework
	* @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a matching module framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleFramework findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleFrameworkException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first module framework in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module framework, or <code>null</code> if a matching module framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleFramework fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last module framework in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module framework
	* @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a matching module framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleFramework findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleFrameworkException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last module framework in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module framework, or <code>null</code> if a matching module framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleFramework fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.ModuleFramework[] findByGroupId_PrevAndNext(
		long spModuleFrameworkId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleFrameworkException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(spModuleFrameworkId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the module frameworks where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of module frameworks where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching module frameworks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the module frameworks where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @return the matching module frameworks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findByModuleIdAndGroupId(
		long spModuleId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByModuleIdAndGroupId(spModuleId, groupId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findByModuleIdAndGroupId(
		long spModuleId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdAndGroupId(spModuleId, groupId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findByModuleIdAndGroupId(
		long spModuleId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleIdAndGroupId(spModuleId, groupId, start, end,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.ModuleFramework findByModuleIdAndGroupId_First(
		long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleFrameworkException {
		return getPersistence()
				   .findByModuleIdAndGroupId_First(spModuleId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first module framework in the ordered set where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module framework, or <code>null</code> if a matching module framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleFramework fetchByModuleIdAndGroupId_First(
		long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByModuleIdAndGroupId_First(spModuleId, groupId,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.ModuleFramework findByModuleIdAndGroupId_Last(
		long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleFrameworkException {
		return getPersistence()
				   .findByModuleIdAndGroupId_Last(spModuleId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last module framework in the ordered set where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module framework, or <code>null</code> if a matching module framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleFramework fetchByModuleIdAndGroupId_Last(
		long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByModuleIdAndGroupId_Last(spModuleId, groupId,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.ModuleFramework[] findByModuleIdAndGroupId_PrevAndNext(
		long spModuleFrameworkId, long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleFrameworkException {
		return getPersistence()
				   .findByModuleIdAndGroupId_PrevAndNext(spModuleFrameworkId,
			spModuleId, groupId, orderByComparator);
	}

	/**
	* Removes all the module frameworks where spModuleId = &#63; and groupId = &#63; from the database.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByModuleIdAndGroupId(long spModuleId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByModuleIdAndGroupId(spModuleId, groupId);
	}

	/**
	* Returns the number of module frameworks where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @return the number of matching module frameworks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByModuleIdAndGroupId(long spModuleId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByModuleIdAndGroupId(spModuleId, groupId);
	}

	/**
	* Returns all the module frameworks where spFrameworkId = &#63; and groupId = &#63;.
	*
	* @param spFrameworkId the sp framework ID
	* @param groupId the group ID
	* @return the matching module frameworks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findByFrameworkIdAndGroupId(
		long spFrameworkId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFrameworkIdAndGroupId(spFrameworkId, groupId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findByFrameworkIdAndGroupId(
		long spFrameworkId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFrameworkIdAndGroupId(spFrameworkId, groupId, start,
			end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findByFrameworkIdAndGroupId(
		long spFrameworkId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFrameworkIdAndGroupId(spFrameworkId, groupId, start,
			end, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.ModuleFramework findByFrameworkIdAndGroupId_First(
		long spFrameworkId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleFrameworkException {
		return getPersistence()
				   .findByFrameworkIdAndGroupId_First(spFrameworkId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first module framework in the ordered set where spFrameworkId = &#63; and groupId = &#63;.
	*
	* @param spFrameworkId the sp framework ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module framework, or <code>null</code> if a matching module framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleFramework fetchByFrameworkIdAndGroupId_First(
		long spFrameworkId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFrameworkIdAndGroupId_First(spFrameworkId, groupId,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.ModuleFramework findByFrameworkIdAndGroupId_Last(
		long spFrameworkId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleFrameworkException {
		return getPersistence()
				   .findByFrameworkIdAndGroupId_Last(spFrameworkId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last module framework in the ordered set where spFrameworkId = &#63; and groupId = &#63;.
	*
	* @param spFrameworkId the sp framework ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module framework, or <code>null</code> if a matching module framework could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleFramework fetchByFrameworkIdAndGroupId_Last(
		long spFrameworkId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFrameworkIdAndGroupId_Last(spFrameworkId, groupId,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.ModuleFramework[] findByFrameworkIdAndGroupId_PrevAndNext(
		long spModuleFrameworkId, long spFrameworkId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleFrameworkException {
		return getPersistence()
				   .findByFrameworkIdAndGroupId_PrevAndNext(spModuleFrameworkId,
			spFrameworkId, groupId, orderByComparator);
	}

	/**
	* Removes all the module frameworks where spFrameworkId = &#63; and groupId = &#63; from the database.
	*
	* @param spFrameworkId the sp framework ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFrameworkIdAndGroupId(long spFrameworkId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFrameworkIdAndGroupId(spFrameworkId, groupId);
	}

	/**
	* Returns the number of module frameworks where spFrameworkId = &#63; and groupId = &#63;.
	*
	* @param spFrameworkId the sp framework ID
	* @param groupId the group ID
	* @return the number of matching module frameworks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFrameworkIdAndGroupId(long spFrameworkId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByFrameworkIdAndGroupId(spFrameworkId, groupId);
	}

	/**
	* Caches the module framework in the entity cache if it is enabled.
	*
	* @param moduleFramework the module framework
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.model.ModuleFramework moduleFramework) {
		getPersistence().cacheResult(moduleFramework);
	}

	/**
	* Caches the module frameworks in the entity cache if it is enabled.
	*
	* @param moduleFrameworks the module frameworks
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.ModuleFramework> moduleFrameworks) {
		getPersistence().cacheResult(moduleFrameworks);
	}

	/**
	* Creates a new module framework with the primary key. Does not add the module framework to the database.
	*
	* @param spModuleFrameworkId the primary key for the new module framework
	* @return the new module framework
	*/
	public static com.sambaash.platform.srv.model.ModuleFramework create(
		long spModuleFrameworkId) {
		return getPersistence().create(spModuleFrameworkId);
	}

	/**
	* Removes the module framework with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spModuleFrameworkId the primary key of the module framework
	* @return the module framework that was removed
	* @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a module framework with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleFramework remove(
		long spModuleFrameworkId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleFrameworkException {
		return getPersistence().remove(spModuleFrameworkId);
	}

	public static com.sambaash.platform.srv.model.ModuleFramework updateImpl(
		com.sambaash.platform.srv.model.ModuleFramework moduleFramework)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(moduleFramework);
	}

	/**
	* Returns the module framework with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchModuleFrameworkException} if it could not be found.
	*
	* @param spModuleFrameworkId the primary key of the module framework
	* @return the module framework
	* @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a module framework with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleFramework findByPrimaryKey(
		long spModuleFrameworkId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleFrameworkException {
		return getPersistence().findByPrimaryKey(spModuleFrameworkId);
	}

	/**
	* Returns the module framework with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spModuleFrameworkId the primary key of the module framework
	* @return the module framework, or <code>null</code> if a module framework with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.ModuleFramework fetchByPrimaryKey(
		long spModuleFrameworkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spModuleFrameworkId);
	}

	/**
	* Returns all the module frameworks.
	*
	* @return the module frameworks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the module frameworks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of module frameworks.
	*
	* @return the number of module frameworks
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ModuleFrameworkPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ModuleFrameworkPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.service.ClpSerializer.getServletContextName(),
					ModuleFrameworkPersistence.class.getName());

			ReferenceRegistry.registerReference(ModuleFrameworkUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ModuleFrameworkPersistence persistence) {
	}

	private static ModuleFrameworkPersistence _persistence;
}