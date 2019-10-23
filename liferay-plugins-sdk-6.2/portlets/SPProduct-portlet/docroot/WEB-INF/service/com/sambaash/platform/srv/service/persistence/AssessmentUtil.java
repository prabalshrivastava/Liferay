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

import com.sambaash.platform.srv.model.Assessment;

import java.util.List;

/**
 * The persistence utility for the assessment service. This utility wraps {@link AssessmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see AssessmentPersistence
 * @see AssessmentPersistenceImpl
 * @generated
 */
public class AssessmentUtil {
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
	public static void clearCache(Assessment assessment) {
		getPersistence().clearCache(assessment);
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
	public static List<Assessment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Assessment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Assessment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Assessment update(Assessment assessment)
		throws SystemException {
		return getPersistence().update(assessment);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Assessment update(Assessment assessment,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(assessment, serviceContext);
	}

	/**
	* Returns all the assessments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching assessments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Assessment> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the assessments where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.AssessmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of assessments
	* @param end the upper bound of the range of assessments (not inclusive)
	* @return the range of matching assessments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Assessment> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the assessments where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.AssessmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of assessments
	* @param end the upper bound of the range of assessments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching assessments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Assessment> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first assessment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assessment
	* @throws com.sambaash.platform.srv.NoSuchAssessmentException if a matching assessment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Assessment findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchAssessmentException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first assessment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assessment, or <code>null</code> if a matching assessment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Assessment fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last assessment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assessment
	* @throws com.sambaash.platform.srv.NoSuchAssessmentException if a matching assessment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Assessment findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchAssessmentException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last assessment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assessment, or <code>null</code> if a matching assessment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Assessment fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the assessments before and after the current assessment in the ordered set where groupId = &#63;.
	*
	* @param spAssessmentId the primary key of the current assessment
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next assessment
	* @throws com.sambaash.platform.srv.NoSuchAssessmentException if a assessment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Assessment[] findByGroupId_PrevAndNext(
		long spAssessmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchAssessmentException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(spAssessmentId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the assessments where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of assessments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching assessments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the assessments where groupId = &#63; and spModuleId = &#63;.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @return the matching assessments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Assessment> findByGroupIdAndModuleId(
		long groupId, long spModuleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupIdAndModuleId(groupId, spModuleId);
	}

	/**
	* Returns a range of all the assessments where groupId = &#63; and spModuleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.AssessmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @param start the lower bound of the range of assessments
	* @param end the upper bound of the range of assessments (not inclusive)
	* @return the range of matching assessments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Assessment> findByGroupIdAndModuleId(
		long groupId, long spModuleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdAndModuleId(groupId, spModuleId, start, end);
	}

	/**
	* Returns an ordered range of all the assessments where groupId = &#63; and spModuleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.AssessmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @param start the lower bound of the range of assessments
	* @param end the upper bound of the range of assessments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching assessments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Assessment> findByGroupIdAndModuleId(
		long groupId, long spModuleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdAndModuleId(groupId, spModuleId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first assessment in the ordered set where groupId = &#63; and spModuleId = &#63;.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assessment
	* @throws com.sambaash.platform.srv.NoSuchAssessmentException if a matching assessment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Assessment findByGroupIdAndModuleId_First(
		long groupId, long spModuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchAssessmentException {
		return getPersistence()
				   .findByGroupIdAndModuleId_First(groupId, spModuleId,
			orderByComparator);
	}

	/**
	* Returns the first assessment in the ordered set where groupId = &#63; and spModuleId = &#63;.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assessment, or <code>null</code> if a matching assessment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Assessment fetchByGroupIdAndModuleId_First(
		long groupId, long spModuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdAndModuleId_First(groupId, spModuleId,
			orderByComparator);
	}

	/**
	* Returns the last assessment in the ordered set where groupId = &#63; and spModuleId = &#63;.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assessment
	* @throws com.sambaash.platform.srv.NoSuchAssessmentException if a matching assessment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Assessment findByGroupIdAndModuleId_Last(
		long groupId, long spModuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchAssessmentException {
		return getPersistence()
				   .findByGroupIdAndModuleId_Last(groupId, spModuleId,
			orderByComparator);
	}

	/**
	* Returns the last assessment in the ordered set where groupId = &#63; and spModuleId = &#63;.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assessment, or <code>null</code> if a matching assessment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Assessment fetchByGroupIdAndModuleId_Last(
		long groupId, long spModuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdAndModuleId_Last(groupId, spModuleId,
			orderByComparator);
	}

	/**
	* Returns the assessments before and after the current assessment in the ordered set where groupId = &#63; and spModuleId = &#63;.
	*
	* @param spAssessmentId the primary key of the current assessment
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next assessment
	* @throws com.sambaash.platform.srv.NoSuchAssessmentException if a assessment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Assessment[] findByGroupIdAndModuleId_PrevAndNext(
		long spAssessmentId, long groupId, long spModuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchAssessmentException {
		return getPersistence()
				   .findByGroupIdAndModuleId_PrevAndNext(spAssessmentId,
			groupId, spModuleId, orderByComparator);
	}

	/**
	* Removes all the assessments where groupId = &#63; and spModuleId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupIdAndModuleId(long groupId, long spModuleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupIdAndModuleId(groupId, spModuleId);
	}

	/**
	* Returns the number of assessments where groupId = &#63; and spModuleId = &#63;.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @return the number of matching assessments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupIdAndModuleId(long groupId, long spModuleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupIdAndModuleId(groupId, spModuleId);
	}

	/**
	* Caches the assessment in the entity cache if it is enabled.
	*
	* @param assessment the assessment
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.model.Assessment assessment) {
		getPersistence().cacheResult(assessment);
	}

	/**
	* Caches the assessments in the entity cache if it is enabled.
	*
	* @param assessments the assessments
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.Assessment> assessments) {
		getPersistence().cacheResult(assessments);
	}

	/**
	* Creates a new assessment with the primary key. Does not add the assessment to the database.
	*
	* @param spAssessmentId the primary key for the new assessment
	* @return the new assessment
	*/
	public static com.sambaash.platform.srv.model.Assessment create(
		long spAssessmentId) {
		return getPersistence().create(spAssessmentId);
	}

	/**
	* Removes the assessment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spAssessmentId the primary key of the assessment
	* @return the assessment that was removed
	* @throws com.sambaash.platform.srv.NoSuchAssessmentException if a assessment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Assessment remove(
		long spAssessmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchAssessmentException {
		return getPersistence().remove(spAssessmentId);
	}

	public static com.sambaash.platform.srv.model.Assessment updateImpl(
		com.sambaash.platform.srv.model.Assessment assessment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(assessment);
	}

	/**
	* Returns the assessment with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchAssessmentException} if it could not be found.
	*
	* @param spAssessmentId the primary key of the assessment
	* @return the assessment
	* @throws com.sambaash.platform.srv.NoSuchAssessmentException if a assessment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Assessment findByPrimaryKey(
		long spAssessmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchAssessmentException {
		return getPersistence().findByPrimaryKey(spAssessmentId);
	}

	/**
	* Returns the assessment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spAssessmentId the primary key of the assessment
	* @return the assessment, or <code>null</code> if a assessment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Assessment fetchByPrimaryKey(
		long spAssessmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spAssessmentId);
	}

	/**
	* Returns all the assessments.
	*
	* @return the assessments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Assessment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the assessments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.AssessmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of assessments
	* @param end the upper bound of the range of assessments (not inclusive)
	* @return the range of assessments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Assessment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the assessments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.AssessmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of assessments
	* @param end the upper bound of the range of assessments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of assessments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Assessment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the assessments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of assessments.
	*
	* @return the number of assessments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AssessmentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AssessmentPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.service.ClpSerializer.getServletContextName(),
					AssessmentPersistence.class.getName());

			ReferenceRegistry.registerReference(AssessmentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AssessmentPersistence persistence) {
	}

	private static AssessmentPersistence _persistence;
}