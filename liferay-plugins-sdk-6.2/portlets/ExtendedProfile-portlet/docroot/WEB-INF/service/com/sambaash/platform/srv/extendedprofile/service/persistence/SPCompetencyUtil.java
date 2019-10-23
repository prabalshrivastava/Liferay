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

import com.sambaash.platform.srv.extendedprofile.model.SPCompetency;

import java.util.List;

/**
 * The persistence utility for the s p competency service. This utility wraps {@link SPCompetencyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPCompetencyPersistence
 * @see SPCompetencyPersistenceImpl
 * @generated
 */
public class SPCompetencyUtil {
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
	public static void clearCache(SPCompetency spCompetency) {
		getPersistence().clearCache(spCompetency);
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
	public static List<SPCompetency> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPCompetency> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPCompetency> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPCompetency update(SPCompetency spCompetency)
		throws SystemException {
		return getPersistence().update(spCompetency);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPCompetency update(SPCompetency spCompetency,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spCompetency, serviceContext);
	}

	/**
	* Returns all the s p competencies where belongsToJobRole = &#63;.
	*
	* @param belongsToJobRole the belongs to job role
	* @return the matching s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCompetencyListByJobRole(
		long belongsToJobRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompetencyListByJobRole(belongsToJobRole);
	}

	/**
	* Returns a range of all the s p competencies where belongsToJobRole = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCompetencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param belongsToJobRole the belongs to job role
	* @param start the lower bound of the range of s p competencies
	* @param end the upper bound of the range of s p competencies (not inclusive)
	* @return the range of matching s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCompetencyListByJobRole(
		long belongsToJobRole, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompetencyListByJobRole(belongsToJobRole, start, end);
	}

	/**
	* Returns an ordered range of all the s p competencies where belongsToJobRole = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCompetencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param belongsToJobRole the belongs to job role
	* @param start the lower bound of the range of s p competencies
	* @param end the upper bound of the range of s p competencies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCompetencyListByJobRole(
		long belongsToJobRole, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompetencyListByJobRole(belongsToJobRole, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p competency in the ordered set where belongsToJobRole = &#63;.
	*
	* @param belongsToJobRole the belongs to job role
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p competency
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCompetency findByCompetencyListByJobRole_First(
		long belongsToJobRole,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException {
		return getPersistence()
				   .findByCompetencyListByJobRole_First(belongsToJobRole,
			orderByComparator);
	}

	/**
	* Returns the first s p competency in the ordered set where belongsToJobRole = &#63;.
	*
	* @param belongsToJobRole the belongs to job role
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p competency, or <code>null</code> if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCompetency fetchByCompetencyListByJobRole_First(
		long belongsToJobRole,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompetencyListByJobRole_First(belongsToJobRole,
			orderByComparator);
	}

	/**
	* Returns the last s p competency in the ordered set where belongsToJobRole = &#63;.
	*
	* @param belongsToJobRole the belongs to job role
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p competency
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCompetency findByCompetencyListByJobRole_Last(
		long belongsToJobRole,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException {
		return getPersistence()
				   .findByCompetencyListByJobRole_Last(belongsToJobRole,
			orderByComparator);
	}

	/**
	* Returns the last s p competency in the ordered set where belongsToJobRole = &#63;.
	*
	* @param belongsToJobRole the belongs to job role
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p competency, or <code>null</code> if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCompetency fetchByCompetencyListByJobRole_Last(
		long belongsToJobRole,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompetencyListByJobRole_Last(belongsToJobRole,
			orderByComparator);
	}

	/**
	* Returns the s p competencies before and after the current s p competency in the ordered set where belongsToJobRole = &#63;.
	*
	* @param classpk the primary key of the current s p competency
	* @param belongsToJobRole the belongs to job role
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p competency
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a s p competency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCompetency[] findByCompetencyListByJobRole_PrevAndNext(
		long classpk, long belongsToJobRole,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException {
		return getPersistence()
				   .findByCompetencyListByJobRole_PrevAndNext(classpk,
			belongsToJobRole, orderByComparator);
	}

	/**
	* Removes all the s p competencies where belongsToJobRole = &#63; from the database.
	*
	* @param belongsToJobRole the belongs to job role
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompetencyListByJobRole(long belongsToJobRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompetencyListByJobRole(belongsToJobRole);
	}

	/**
	* Returns the number of s p competencies where belongsToJobRole = &#63;.
	*
	* @param belongsToJobRole the belongs to job role
	* @return the number of matching s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompetencyListByJobRole(long belongsToJobRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompetencyListByJobRole(belongsToJobRole);
	}

	/**
	* Returns all the s p competencies where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCompetencyList(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompetencyList(userId);
	}

	/**
	* Returns a range of all the s p competencies where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCompetencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of s p competencies
	* @param end the upper bound of the range of s p competencies (not inclusive)
	* @return the range of matching s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCompetencyList(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompetencyList(userId, start, end);
	}

	/**
	* Returns an ordered range of all the s p competencies where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCompetencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of s p competencies
	* @param end the upper bound of the range of s p competencies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCompetencyList(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompetencyList(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first s p competency in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p competency
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCompetency findByCompetencyList_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException {
		return getPersistence()
				   .findByCompetencyList_First(userId, orderByComparator);
	}

	/**
	* Returns the first s p competency in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p competency, or <code>null</code> if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCompetency fetchByCompetencyList_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompetencyList_First(userId, orderByComparator);
	}

	/**
	* Returns the last s p competency in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p competency
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCompetency findByCompetencyList_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException {
		return getPersistence()
				   .findByCompetencyList_Last(userId, orderByComparator);
	}

	/**
	* Returns the last s p competency in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p competency, or <code>null</code> if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCompetency fetchByCompetencyList_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompetencyList_Last(userId, orderByComparator);
	}

	/**
	* Returns the s p competencies before and after the current s p competency in the ordered set where userId = &#63;.
	*
	* @param classpk the primary key of the current s p competency
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p competency
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a s p competency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCompetency[] findByCompetencyList_PrevAndNext(
		long classpk, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException {
		return getPersistence()
				   .findByCompetencyList_PrevAndNext(classpk, userId,
			orderByComparator);
	}

	/**
	* Removes all the s p competencies where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompetencyList(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompetencyList(userId);
	}

	/**
	* Returns the number of s p competencies where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompetencyList(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompetencyList(userId);
	}

	/**
	* Returns the s p competency where userId = &#63; and categoryId = &#63; and competencyId = &#63; or throws a {@link com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException} if it could not be found.
	*
	* @param userId the user ID
	* @param categoryId the category ID
	* @param competencyId the competency ID
	* @return the matching s p competency
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCompetency findByCategoryIdAndCompetencyId(
		long userId, long categoryId, long competencyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException {
		return getPersistence()
				   .findByCategoryIdAndCompetencyId(userId, categoryId,
			competencyId);
	}

	/**
	* Returns the s p competency where userId = &#63; and categoryId = &#63; and competencyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param categoryId the category ID
	* @param competencyId the competency ID
	* @return the matching s p competency, or <code>null</code> if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCompetency fetchByCategoryIdAndCompetencyId(
		long userId, long categoryId, long competencyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryIdAndCompetencyId(userId, categoryId,
			competencyId);
	}

	/**
	* Returns the s p competency where userId = &#63; and categoryId = &#63; and competencyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param categoryId the category ID
	* @param competencyId the competency ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p competency, or <code>null</code> if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCompetency fetchByCategoryIdAndCompetencyId(
		long userId, long categoryId, long competencyId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryIdAndCompetencyId(userId, categoryId,
			competencyId, retrieveFromCache);
	}

	/**
	* Removes the s p competency where userId = &#63; and categoryId = &#63; and competencyId = &#63; from the database.
	*
	* @param userId the user ID
	* @param categoryId the category ID
	* @param competencyId the competency ID
	* @return the s p competency that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCompetency removeByCategoryIdAndCompetencyId(
		long userId, long categoryId, long competencyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException {
		return getPersistence()
				   .removeByCategoryIdAndCompetencyId(userId, categoryId,
			competencyId);
	}

	/**
	* Returns the number of s p competencies where userId = &#63; and categoryId = &#63; and competencyId = &#63;.
	*
	* @param userId the user ID
	* @param categoryId the category ID
	* @param competencyId the competency ID
	* @return the number of matching s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryIdAndCompetencyId(long userId,
		long categoryId, long competencyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCategoryIdAndCompetencyId(userId, categoryId,
			competencyId);
	}

	/**
	* Returns all the s p competencies where userId = &#63; and categoryId = &#63;.
	*
	* @param userId the user ID
	* @param categoryId the category ID
	* @return the matching s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCategoryId(
		long userId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryId(userId, categoryId);
	}

	/**
	* Returns a range of all the s p competencies where userId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCompetencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of s p competencies
	* @param end the upper bound of the range of s p competencies (not inclusive)
	* @return the range of matching s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCategoryId(
		long userId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryId(userId, categoryId, start, end);
	}

	/**
	* Returns an ordered range of all the s p competencies where userId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCompetencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of s p competencies
	* @param end the upper bound of the range of s p competencies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCategoryId(
		long userId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryId(userId, categoryId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p competency in the ordered set where userId = &#63; and categoryId = &#63;.
	*
	* @param userId the user ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p competency
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCompetency findByCategoryId_First(
		long userId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException {
		return getPersistence()
				   .findByCategoryId_First(userId, categoryId, orderByComparator);
	}

	/**
	* Returns the first s p competency in the ordered set where userId = &#63; and categoryId = &#63;.
	*
	* @param userId the user ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p competency, or <code>null</code> if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCompetency fetchByCategoryId_First(
		long userId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryId_First(userId, categoryId,
			orderByComparator);
	}

	/**
	* Returns the last s p competency in the ordered set where userId = &#63; and categoryId = &#63;.
	*
	* @param userId the user ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p competency
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCompetency findByCategoryId_Last(
		long userId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException {
		return getPersistence()
				   .findByCategoryId_Last(userId, categoryId, orderByComparator);
	}

	/**
	* Returns the last s p competency in the ordered set where userId = &#63; and categoryId = &#63;.
	*
	* @param userId the user ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p competency, or <code>null</code> if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCompetency fetchByCategoryId_Last(
		long userId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryId_Last(userId, categoryId, orderByComparator);
	}

	/**
	* Returns the s p competencies before and after the current s p competency in the ordered set where userId = &#63; and categoryId = &#63;.
	*
	* @param classpk the primary key of the current s p competency
	* @param userId the user ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p competency
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a s p competency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCompetency[] findByCategoryId_PrevAndNext(
		long classpk, long userId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException {
		return getPersistence()
				   .findByCategoryId_PrevAndNext(classpk, userId, categoryId,
			orderByComparator);
	}

	/**
	* Removes all the s p competencies where userId = &#63; and categoryId = &#63; from the database.
	*
	* @param userId the user ID
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryId(long userId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategoryId(userId, categoryId);
	}

	/**
	* Returns the number of s p competencies where userId = &#63; and categoryId = &#63;.
	*
	* @param userId the user ID
	* @param categoryId the category ID
	* @return the number of matching s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryId(long userId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategoryId(userId, categoryId);
	}

	/**
	* Caches the s p competency in the entity cache if it is enabled.
	*
	* @param spCompetency the s p competency
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.extendedprofile.model.SPCompetency spCompetency) {
		getPersistence().cacheResult(spCompetency);
	}

	/**
	* Caches the s p competencies in the entity cache if it is enabled.
	*
	* @param spCompetencies the s p competencies
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> spCompetencies) {
		getPersistence().cacheResult(spCompetencies);
	}

	/**
	* Creates a new s p competency with the primary key. Does not add the s p competency to the database.
	*
	* @param classpk the primary key for the new s p competency
	* @return the new s p competency
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCompetency create(
		long classpk) {
		return getPersistence().create(classpk);
	}

	/**
	* Removes the s p competency with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param classpk the primary key of the s p competency
	* @return the s p competency that was removed
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a s p competency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCompetency remove(
		long classpk)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException {
		return getPersistence().remove(classpk);
	}

	public static com.sambaash.platform.srv.extendedprofile.model.SPCompetency updateImpl(
		com.sambaash.platform.srv.extendedprofile.model.SPCompetency spCompetency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spCompetency);
	}

	/**
	* Returns the s p competency with the primary key or throws a {@link com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException} if it could not be found.
	*
	* @param classpk the primary key of the s p competency
	* @return the s p competency
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a s p competency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCompetency findByPrimaryKey(
		long classpk)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException {
		return getPersistence().findByPrimaryKey(classpk);
	}

	/**
	* Returns the s p competency with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param classpk the primary key of the s p competency
	* @return the s p competency, or <code>null</code> if a s p competency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.extendedprofile.model.SPCompetency fetchByPrimaryKey(
		long classpk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(classpk);
	}

	/**
	* Returns all the s p competencies.
	*
	* @return the s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p competencies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCompetencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p competencies
	* @param end the upper bound of the range of s p competencies (not inclusive)
	* @return the range of s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p competencies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCompetencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p competencies
	* @param end the upper bound of the range of s p competencies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p competencies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p competencies.
	*
	* @return the number of s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPCompetencyPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPCompetencyPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.extendedprofile.service.ClpSerializer.getServletContextName(),
					SPCompetencyPersistence.class.getName());

			ReferenceRegistry.registerReference(SPCompetencyUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPCompetencyPersistence persistence) {
	}

	private static SPCompetencyPersistence _persistence;
}