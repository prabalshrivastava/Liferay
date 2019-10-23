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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.extendedprofile.model.SPCompetency;

/**
 * The persistence interface for the s p competency service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPCompetencyPersistenceImpl
 * @see SPCompetencyUtil
 * @generated
 */
public interface SPCompetencyPersistence extends BasePersistence<SPCompetency> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPCompetencyUtil} to access the s p competency persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p competencies where belongsToJobRole = &#63;.
	*
	* @param belongsToJobRole the belongs to job role
	* @return the matching s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCompetencyListByJobRole(
		long belongsToJobRole)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCompetencyListByJobRole(
		long belongsToJobRole, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCompetencyListByJobRole(
		long belongsToJobRole, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p competency in the ordered set where belongsToJobRole = &#63;.
	*
	* @param belongsToJobRole the belongs to job role
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p competency
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency findByCompetencyListByJobRole_First(
		long belongsToJobRole,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException;

	/**
	* Returns the first s p competency in the ordered set where belongsToJobRole = &#63;.
	*
	* @param belongsToJobRole the belongs to job role
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p competency, or <code>null</code> if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency fetchByCompetencyListByJobRole_First(
		long belongsToJobRole,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p competency in the ordered set where belongsToJobRole = &#63;.
	*
	* @param belongsToJobRole the belongs to job role
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p competency
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency findByCompetencyListByJobRole_Last(
		long belongsToJobRole,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException;

	/**
	* Returns the last s p competency in the ordered set where belongsToJobRole = &#63;.
	*
	* @param belongsToJobRole the belongs to job role
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p competency, or <code>null</code> if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency fetchByCompetencyListByJobRole_Last(
		long belongsToJobRole,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency[] findByCompetencyListByJobRole_PrevAndNext(
		long classpk, long belongsToJobRole,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException;

	/**
	* Removes all the s p competencies where belongsToJobRole = &#63; from the database.
	*
	* @param belongsToJobRole the belongs to job role
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompetencyListByJobRole(long belongsToJobRole)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p competencies where belongsToJobRole = &#63;.
	*
	* @param belongsToJobRole the belongs to job role
	* @return the number of matching s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompetencyListByJobRole(long belongsToJobRole)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p competencies where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCompetencyList(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCompetencyList(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCompetencyList(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p competency in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p competency
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency findByCompetencyList_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException;

	/**
	* Returns the first s p competency in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p competency, or <code>null</code> if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency fetchByCompetencyList_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p competency in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p competency
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency findByCompetencyList_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException;

	/**
	* Returns the last s p competency in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p competency, or <code>null</code> if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency fetchByCompetencyList_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency[] findByCompetencyList_PrevAndNext(
		long classpk, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException;

	/**
	* Removes all the s p competencies where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompetencyList(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p competencies where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompetencyList(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency findByCategoryIdAndCompetencyId(
		long userId, long categoryId, long competencyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException;

	/**
	* Returns the s p competency where userId = &#63; and categoryId = &#63; and competencyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param categoryId the category ID
	* @param competencyId the competency ID
	* @return the matching s p competency, or <code>null</code> if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency fetchByCategoryIdAndCompetencyId(
		long userId, long categoryId, long competencyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency fetchByCategoryIdAndCompetencyId(
		long userId, long categoryId, long competencyId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p competency where userId = &#63; and categoryId = &#63; and competencyId = &#63; from the database.
	*
	* @param userId the user ID
	* @param categoryId the category ID
	* @param competencyId the competency ID
	* @return the s p competency that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency removeByCategoryIdAndCompetencyId(
		long userId, long categoryId, long competencyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException;

	/**
	* Returns the number of s p competencies where userId = &#63; and categoryId = &#63; and competencyId = &#63;.
	*
	* @param userId the user ID
	* @param categoryId the category ID
	* @param competencyId the competency ID
	* @return the number of matching s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryIdAndCompetencyId(long userId, long categoryId,
		long competencyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p competencies where userId = &#63; and categoryId = &#63;.
	*
	* @param userId the user ID
	* @param categoryId the category ID
	* @return the matching s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCategoryId(
		long userId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCategoryId(
		long userId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findByCategoryId(
		long userId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency findByCategoryId_First(
		long userId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException;

	/**
	* Returns the first s p competency in the ordered set where userId = &#63; and categoryId = &#63;.
	*
	* @param userId the user ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p competency, or <code>null</code> if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency fetchByCategoryId_First(
		long userId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency findByCategoryId_Last(
		long userId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException;

	/**
	* Returns the last s p competency in the ordered set where userId = &#63; and categoryId = &#63;.
	*
	* @param userId the user ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p competency, or <code>null</code> if a matching s p competency could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency fetchByCategoryId_Last(
		long userId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency[] findByCategoryId_PrevAndNext(
		long classpk, long userId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException;

	/**
	* Removes all the s p competencies where userId = &#63; and categoryId = &#63; from the database.
	*
	* @param userId the user ID
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryId(long userId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p competencies where userId = &#63; and categoryId = &#63;.
	*
	* @param userId the user ID
	* @param categoryId the category ID
	* @return the number of matching s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryId(long userId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p competency in the entity cache if it is enabled.
	*
	* @param spCompetency the s p competency
	*/
	public void cacheResult(
		com.sambaash.platform.srv.extendedprofile.model.SPCompetency spCompetency);

	/**
	* Caches the s p competencies in the entity cache if it is enabled.
	*
	* @param spCompetencies the s p competencies
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> spCompetencies);

	/**
	* Creates a new s p competency with the primary key. Does not add the s p competency to the database.
	*
	* @param classpk the primary key for the new s p competency
	* @return the new s p competency
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency create(
		long classpk);

	/**
	* Removes the s p competency with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param classpk the primary key of the s p competency
	* @return the s p competency that was removed
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a s p competency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency remove(
		long classpk)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException;

	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency updateImpl(
		com.sambaash.platform.srv.extendedprofile.model.SPCompetency spCompetency)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p competency with the primary key or throws a {@link com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException} if it could not be found.
	*
	* @param classpk the primary key of the s p competency
	* @return the s p competency
	* @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a s p competency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency findByPrimaryKey(
		long classpk)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException;

	/**
	* Returns the s p competency with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param classpk the primary key of the s p competency
	* @return the s p competency, or <code>null</code> if a s p competency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency fetchByPrimaryKey(
		long classpk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p competencies.
	*
	* @return the s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p competencies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p competencies.
	*
	* @return the number of s p competencies
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}