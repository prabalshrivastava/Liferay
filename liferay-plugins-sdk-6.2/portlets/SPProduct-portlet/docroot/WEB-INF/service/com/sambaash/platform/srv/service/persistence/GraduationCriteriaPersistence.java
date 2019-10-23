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

import com.sambaash.platform.srv.model.GraduationCriteria;

/**
 * The persistence interface for the graduation criteria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see GraduationCriteriaPersistenceImpl
 * @see GraduationCriteriaUtil
 * @generated
 */
public interface GraduationCriteriaPersistence extends BasePersistence<GraduationCriteria> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GraduationCriteriaUtil} to access the graduation criteria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the graduation criterias where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching graduation criterias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.GraduationCriteria> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the graduation criterias where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.GraduationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of graduation criterias
	* @param end the upper bound of the range of graduation criterias (not inclusive)
	* @return the range of matching graduation criterias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.GraduationCriteria> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the graduation criterias where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.GraduationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of graduation criterias
	* @param end the upper bound of the range of graduation criterias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching graduation criterias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.GraduationCriteria> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first graduation criteria in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching graduation criteria
	* @throws com.sambaash.platform.srv.NoSuchGraduationCriteriaException if a matching graduation criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.GraduationCriteria findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchGraduationCriteriaException;

	/**
	* Returns the first graduation criteria in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching graduation criteria, or <code>null</code> if a matching graduation criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.GraduationCriteria fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last graduation criteria in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching graduation criteria
	* @throws com.sambaash.platform.srv.NoSuchGraduationCriteriaException if a matching graduation criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.GraduationCriteria findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchGraduationCriteriaException;

	/**
	* Returns the last graduation criteria in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching graduation criteria, or <code>null</code> if a matching graduation criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.GraduationCriteria fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the graduation criterias before and after the current graduation criteria in the ordered set where groupId = &#63;.
	*
	* @param spGraduationCriteriaId the primary key of the current graduation criteria
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next graduation criteria
	* @throws com.sambaash.platform.srv.NoSuchGraduationCriteriaException if a graduation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.GraduationCriteria[] findByGroupId_PrevAndNext(
		long spGraduationCriteriaId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchGraduationCriteriaException;

	/**
	* Removes all the graduation criterias where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of graduation criterias where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching graduation criterias
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the graduation criterias where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @return the matching graduation criterias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.GraduationCriteria> findByCourseIdAndGroupId(
		long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the graduation criterias where spCourseId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.GraduationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param start the lower bound of the range of graduation criterias
	* @param end the upper bound of the range of graduation criterias (not inclusive)
	* @return the range of matching graduation criterias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.GraduationCriteria> findByCourseIdAndGroupId(
		long spCourseId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the graduation criterias where spCourseId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.GraduationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param start the lower bound of the range of graduation criterias
	* @param end the upper bound of the range of graduation criterias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching graduation criterias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.GraduationCriteria> findByCourseIdAndGroupId(
		long spCourseId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first graduation criteria in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching graduation criteria
	* @throws com.sambaash.platform.srv.NoSuchGraduationCriteriaException if a matching graduation criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.GraduationCriteria findByCourseIdAndGroupId_First(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchGraduationCriteriaException;

	/**
	* Returns the first graduation criteria in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching graduation criteria, or <code>null</code> if a matching graduation criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.GraduationCriteria fetchByCourseIdAndGroupId_First(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last graduation criteria in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching graduation criteria
	* @throws com.sambaash.platform.srv.NoSuchGraduationCriteriaException if a matching graduation criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.GraduationCriteria findByCourseIdAndGroupId_Last(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchGraduationCriteriaException;

	/**
	* Returns the last graduation criteria in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching graduation criteria, or <code>null</code> if a matching graduation criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.GraduationCriteria fetchByCourseIdAndGroupId_Last(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the graduation criterias before and after the current graduation criteria in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spGraduationCriteriaId the primary key of the current graduation criteria
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next graduation criteria
	* @throws com.sambaash.platform.srv.NoSuchGraduationCriteriaException if a graduation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.GraduationCriteria[] findByCourseIdAndGroupId_PrevAndNext(
		long spGraduationCriteriaId, long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchGraduationCriteriaException;

	/**
	* Removes all the graduation criterias where spCourseId = &#63; and groupId = &#63; from the database.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCourseIdAndGroupId(long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of graduation criterias where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @return the number of matching graduation criterias
	* @throws SystemException if a system exception occurred
	*/
	public int countByCourseIdAndGroupId(long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the graduation criteria in the entity cache if it is enabled.
	*
	* @param graduationCriteria the graduation criteria
	*/
	public void cacheResult(
		com.sambaash.platform.srv.model.GraduationCriteria graduationCriteria);

	/**
	* Caches the graduation criterias in the entity cache if it is enabled.
	*
	* @param graduationCriterias the graduation criterias
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.GraduationCriteria> graduationCriterias);

	/**
	* Creates a new graduation criteria with the primary key. Does not add the graduation criteria to the database.
	*
	* @param spGraduationCriteriaId the primary key for the new graduation criteria
	* @return the new graduation criteria
	*/
	public com.sambaash.platform.srv.model.GraduationCriteria create(
		long spGraduationCriteriaId);

	/**
	* Removes the graduation criteria with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spGraduationCriteriaId the primary key of the graduation criteria
	* @return the graduation criteria that was removed
	* @throws com.sambaash.platform.srv.NoSuchGraduationCriteriaException if a graduation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.GraduationCriteria remove(
		long spGraduationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchGraduationCriteriaException;

	public com.sambaash.platform.srv.model.GraduationCriteria updateImpl(
		com.sambaash.platform.srv.model.GraduationCriteria graduationCriteria)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the graduation criteria with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchGraduationCriteriaException} if it could not be found.
	*
	* @param spGraduationCriteriaId the primary key of the graduation criteria
	* @return the graduation criteria
	* @throws com.sambaash.platform.srv.NoSuchGraduationCriteriaException if a graduation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.GraduationCriteria findByPrimaryKey(
		long spGraduationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchGraduationCriteriaException;

	/**
	* Returns the graduation criteria with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spGraduationCriteriaId the primary key of the graduation criteria
	* @return the graduation criteria, or <code>null</code> if a graduation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.GraduationCriteria fetchByPrimaryKey(
		long spGraduationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the graduation criterias.
	*
	* @return the graduation criterias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.GraduationCriteria> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the graduation criterias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.GraduationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of graduation criterias
	* @param end the upper bound of the range of graduation criterias (not inclusive)
	* @return the range of graduation criterias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.GraduationCriteria> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the graduation criterias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.GraduationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of graduation criterias
	* @param end the upper bound of the range of graduation criterias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of graduation criterias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.GraduationCriteria> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the graduation criterias from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of graduation criterias.
	*
	* @return the number of graduation criterias
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}