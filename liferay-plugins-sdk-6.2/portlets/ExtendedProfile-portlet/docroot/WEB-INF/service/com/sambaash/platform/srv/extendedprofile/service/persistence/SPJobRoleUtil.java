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

package com.sambaash.platform.srv.extendedprofile.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.extendedprofile.model.SPJobRole;

import java.util.List;

/**
 * The persistence utility for the s p job role service. This utility wraps {@link SPJobRolePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPJobRolePersistence
 * @see SPJobRolePersistenceImpl
 * @generated
 */
public class SPJobRoleUtil {
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
	public static void clearCache(SPJobRole spJobRole) {
		getPersistence().clearCache(spJobRole);
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
	public static List<SPJobRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPJobRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPJobRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPJobRole update(SPJobRole spJobRole)
		throws SystemException {
		return getPersistence().update(spJobRole);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPJobRole update(SPJobRole spJobRole,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spJobRole, serviceContext);
	}

	/**
	* Returns the s p job role where userId = &#63; or throws a {@link com.sambaash.platform.srv.extendedprofile.NoSuchSPJobRoleException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching s p job role
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPJobRoleException if a matching s p job role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPJobRole findByJobRole(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPJobRoleException {
		return getPersistence().findByJobRole(userId);
	}

	/**
	* Returns the s p job role where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching s p job role, or <code>null</code> if a matching s p job role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPJobRole fetchByJobRole(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByJobRole(userId);
	}

	/**
	* Returns the s p job role where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p job role, or <code>null</code> if a matching s p job role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPJobRole fetchByJobRole(
		long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByJobRole(userId, retrieveFromCache);
	}

	/**
	* Removes the s p job role where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the s p job role that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPJobRole removeByJobRole(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPJobRoleException {
		return getPersistence().removeByJobRole(userId);
	}

	/**
	* Returns the number of s p job roles where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching s p job roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByJobRole(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByJobRole(userId);
	}

	/**
	* Caches the s p job role in the entity cache if it is enabled.
	*
	* @param spJobRole the s p job role
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.extendedprofile.model.SPJobRole spJobRole) {
		getPersistence().cacheResult(spJobRole);
	}

	/**
	* Caches the s p job roles in the entity cache if it is enabled.
	*
	* @param spJobRoles the s p job roles
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPJobRole> spJobRoles) {
		getPersistence().cacheResult(spJobRoles);
	}

	/**
	* Creates a new s p job role with the primary key. Does not add the s p job role to the database.
	*
	* @param spJobRoleId the primary key for the new s p job role
	* @return the new s p job role
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPJobRole create(
		long spJobRoleId) {
		return getPersistence().create(spJobRoleId);
	}

	/**
	* Removes the s p job role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spJobRoleId the primary key of the s p job role
	* @return the s p job role that was removed
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPJobRoleException if a s p job role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPJobRole remove(
		long spJobRoleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPJobRoleException {
		return getPersistence().remove(spJobRoleId);
	}

	public static com.sambaash.platform.srv.extendedprofile.model.SPJobRole updateImpl(
		com.sambaash.platform.srv.extendedprofile.model.SPJobRole spJobRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spJobRole);
	}

	/**
	* Returns the s p job role with the primary key or throws a {@link com.sambaash.platform.srv.extendedprofile.NoSuchSPJobRoleException} if it could not be found.
	*
	* @param spJobRoleId the primary key of the s p job role
	* @return the s p job role
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPJobRoleException if a s p job role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPJobRole findByPrimaryKey(
		long spJobRoleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPJobRoleException {
		return getPersistence().findByPrimaryKey(spJobRoleId);
	}

	/**
	* Returns the s p job role with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spJobRoleId the primary key of the s p job role
	* @return the s p job role, or <code>null</code> if a s p job role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPJobRole fetchByPrimaryKey(
		long spJobRoleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spJobRoleId);
	}

	/**
	* Returns all the s p job roles.
	*
	* @return the s p job roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPJobRole> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p job roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPJobRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p job roles
	* @param end the upper bound of the range of s p job roles (not inclusive)
	* @return the range of s p job roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPJobRole> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p job roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPJobRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p job roles
	* @param end the upper bound of the range of s p job roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p job roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPJobRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p job roles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p job roles.
	*
	* @return the number of s p job roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPJobRolePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPJobRolePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.extendedprofile.service.ClpSerializer.getServletContextName(),
					SPJobRolePersistence.class.getName());

			ReferenceRegistry.registerReference(SPJobRoleUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPJobRolePersistence persistence) {
	}

	private static SPJobRolePersistence _persistence;
}