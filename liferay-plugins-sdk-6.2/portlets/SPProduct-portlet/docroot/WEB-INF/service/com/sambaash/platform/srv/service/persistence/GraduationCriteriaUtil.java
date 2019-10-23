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

import com.sambaash.platform.srv.model.GraduationCriteria;

import java.util.List;

/**
 * The persistence utility for the graduation criteria service. This utility wraps {@link GraduationCriteriaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see GraduationCriteriaPersistence
 * @see GraduationCriteriaPersistenceImpl
 * @generated
 */
public class GraduationCriteriaUtil {
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
	public static void clearCache(GraduationCriteria graduationCriteria) {
		getPersistence().clearCache(graduationCriteria);
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
	public static List<GraduationCriteria> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GraduationCriteria> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GraduationCriteria> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GraduationCriteria update(
		GraduationCriteria graduationCriteria) throws SystemException {
		return getPersistence().update(graduationCriteria);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GraduationCriteria update(
		GraduationCriteria graduationCriteria, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(graduationCriteria, serviceContext);
	}

	/**
	* Returns all the graduation criterias where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching graduation criterias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.GraduationCriteria> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.GraduationCriteria> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.GraduationCriteria> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first graduation criteria in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching graduation criteria
	* @throws com.sambaash.platform.srv.NoSuchGraduationCriteriaException if a matching graduation criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.GraduationCriteria findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchGraduationCriteriaException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first graduation criteria in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching graduation criteria, or <code>null</code> if a matching graduation criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.GraduationCriteria fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last graduation criteria in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching graduation criteria
	* @throws com.sambaash.platform.srv.NoSuchGraduationCriteriaException if a matching graduation criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.GraduationCriteria findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchGraduationCriteriaException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last graduation criteria in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching graduation criteria, or <code>null</code> if a matching graduation criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.GraduationCriteria fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.GraduationCriteria[] findByGroupId_PrevAndNext(
		long spGraduationCriteriaId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchGraduationCriteriaException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(spGraduationCriteriaId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the graduation criterias where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of graduation criterias where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching graduation criterias
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the graduation criterias where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @return the matching graduation criterias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.GraduationCriteria> findByCourseIdAndGroupId(
		long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourseIdAndGroupId(spCourseId, groupId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.GraduationCriteria> findByCourseIdAndGroupId(
		long spCourseId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdAndGroupId(spCourseId, groupId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.GraduationCriteria> findByCourseIdAndGroupId(
		long spCourseId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdAndGroupId(spCourseId, groupId, start, end,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.GraduationCriteria findByCourseIdAndGroupId_First(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchGraduationCriteriaException {
		return getPersistence()
				   .findByCourseIdAndGroupId_First(spCourseId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first graduation criteria in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching graduation criteria, or <code>null</code> if a matching graduation criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.GraduationCriteria fetchByCourseIdAndGroupId_First(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseIdAndGroupId_First(spCourseId, groupId,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.GraduationCriteria findByCourseIdAndGroupId_Last(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchGraduationCriteriaException {
		return getPersistence()
				   .findByCourseIdAndGroupId_Last(spCourseId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last graduation criteria in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching graduation criteria, or <code>null</code> if a matching graduation criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.GraduationCriteria fetchByCourseIdAndGroupId_Last(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseIdAndGroupId_Last(spCourseId, groupId,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.GraduationCriteria[] findByCourseIdAndGroupId_PrevAndNext(
		long spGraduationCriteriaId, long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchGraduationCriteriaException {
		return getPersistence()
				   .findByCourseIdAndGroupId_PrevAndNext(spGraduationCriteriaId,
			spCourseId, groupId, orderByComparator);
	}

	/**
	* Removes all the graduation criterias where spCourseId = &#63; and groupId = &#63; from the database.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCourseIdAndGroupId(long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCourseIdAndGroupId(spCourseId, groupId);
	}

	/**
	* Returns the number of graduation criterias where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @return the number of matching graduation criterias
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCourseIdAndGroupId(long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCourseIdAndGroupId(spCourseId, groupId);
	}

	/**
	* Caches the graduation criteria in the entity cache if it is enabled.
	*
	* @param graduationCriteria the graduation criteria
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.model.GraduationCriteria graduationCriteria) {
		getPersistence().cacheResult(graduationCriteria);
	}

	/**
	* Caches the graduation criterias in the entity cache if it is enabled.
	*
	* @param graduationCriterias the graduation criterias
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.GraduationCriteria> graduationCriterias) {
		getPersistence().cacheResult(graduationCriterias);
	}

	/**
	* Creates a new graduation criteria with the primary key. Does not add the graduation criteria to the database.
	*
	* @param spGraduationCriteriaId the primary key for the new graduation criteria
	* @return the new graduation criteria
	*/
	public static com.sambaash.platform.srv.model.GraduationCriteria create(
		long spGraduationCriteriaId) {
		return getPersistence().create(spGraduationCriteriaId);
	}

	/**
	* Removes the graduation criteria with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spGraduationCriteriaId the primary key of the graduation criteria
	* @return the graduation criteria that was removed
	* @throws com.sambaash.platform.srv.NoSuchGraduationCriteriaException if a graduation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.GraduationCriteria remove(
		long spGraduationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchGraduationCriteriaException {
		return getPersistence().remove(spGraduationCriteriaId);
	}

	public static com.sambaash.platform.srv.model.GraduationCriteria updateImpl(
		com.sambaash.platform.srv.model.GraduationCriteria graduationCriteria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(graduationCriteria);
	}

	/**
	* Returns the graduation criteria with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchGraduationCriteriaException} if it could not be found.
	*
	* @param spGraduationCriteriaId the primary key of the graduation criteria
	* @return the graduation criteria
	* @throws com.sambaash.platform.srv.NoSuchGraduationCriteriaException if a graduation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.GraduationCriteria findByPrimaryKey(
		long spGraduationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchGraduationCriteriaException {
		return getPersistence().findByPrimaryKey(spGraduationCriteriaId);
	}

	/**
	* Returns the graduation criteria with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spGraduationCriteriaId the primary key of the graduation criteria
	* @return the graduation criteria, or <code>null</code> if a graduation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.GraduationCriteria fetchByPrimaryKey(
		long spGraduationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spGraduationCriteriaId);
	}

	/**
	* Returns all the graduation criterias.
	*
	* @return the graduation criterias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.GraduationCriteria> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.GraduationCriteria> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.GraduationCriteria> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the graduation criterias from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of graduation criterias.
	*
	* @return the number of graduation criterias
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GraduationCriteriaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GraduationCriteriaPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.service.ClpSerializer.getServletContextName(),
					GraduationCriteriaPersistence.class.getName());

			ReferenceRegistry.registerReference(GraduationCriteriaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GraduationCriteriaPersistence persistence) {
	}

	private static GraduationCriteriaPersistence _persistence;
}