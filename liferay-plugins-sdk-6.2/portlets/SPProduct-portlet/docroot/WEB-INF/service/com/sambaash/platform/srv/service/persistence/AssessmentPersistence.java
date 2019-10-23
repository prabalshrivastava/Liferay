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

import com.sambaash.platform.srv.model.Assessment;

/**
 * The persistence interface for the assessment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see AssessmentPersistenceImpl
 * @see AssessmentUtil
 * @generated
 */
public interface AssessmentPersistence extends BasePersistence<Assessment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AssessmentUtil} to access the assessment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the assessments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching assessments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Assessment> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.Assessment> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.Assessment> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first assessment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assessment
	* @throws com.sambaash.platform.srv.NoSuchAssessmentException if a matching assessment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Assessment findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchAssessmentException;

	/**
	* Returns the first assessment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assessment, or <code>null</code> if a matching assessment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Assessment fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last assessment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assessment
	* @throws com.sambaash.platform.srv.NoSuchAssessmentException if a matching assessment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Assessment findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchAssessmentException;

	/**
	* Returns the last assessment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assessment, or <code>null</code> if a matching assessment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Assessment fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.Assessment[] findByGroupId_PrevAndNext(
		long spAssessmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchAssessmentException;

	/**
	* Removes all the assessments where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of assessments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching assessments
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the assessments where groupId = &#63; and spModuleId = &#63;.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @return the matching assessments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Assessment> findByGroupIdAndModuleId(
		long groupId, long spModuleId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.Assessment> findByGroupIdAndModuleId(
		long groupId, long spModuleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.Assessment> findByGroupIdAndModuleId(
		long groupId, long spModuleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.Assessment findByGroupIdAndModuleId_First(
		long groupId, long spModuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchAssessmentException;

	/**
	* Returns the first assessment in the ordered set where groupId = &#63; and spModuleId = &#63;.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching assessment, or <code>null</code> if a matching assessment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Assessment fetchByGroupIdAndModuleId_First(
		long groupId, long spModuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.Assessment findByGroupIdAndModuleId_Last(
		long groupId, long spModuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchAssessmentException;

	/**
	* Returns the last assessment in the ordered set where groupId = &#63; and spModuleId = &#63;.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching assessment, or <code>null</code> if a matching assessment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Assessment fetchByGroupIdAndModuleId_Last(
		long groupId, long spModuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.Assessment[] findByGroupIdAndModuleId_PrevAndNext(
		long spAssessmentId, long groupId, long spModuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchAssessmentException;

	/**
	* Removes all the assessments where groupId = &#63; and spModuleId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupIdAndModuleId(long groupId, long spModuleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of assessments where groupId = &#63; and spModuleId = &#63;.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @return the number of matching assessments
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupIdAndModuleId(long groupId, long spModuleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the assessment in the entity cache if it is enabled.
	*
	* @param assessment the assessment
	*/
	public void cacheResult(
		com.sambaash.platform.srv.model.Assessment assessment);

	/**
	* Caches the assessments in the entity cache if it is enabled.
	*
	* @param assessments the assessments
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.Assessment> assessments);

	/**
	* Creates a new assessment with the primary key. Does not add the assessment to the database.
	*
	* @param spAssessmentId the primary key for the new assessment
	* @return the new assessment
	*/
	public com.sambaash.platform.srv.model.Assessment create(
		long spAssessmentId);

	/**
	* Removes the assessment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spAssessmentId the primary key of the assessment
	* @return the assessment that was removed
	* @throws com.sambaash.platform.srv.NoSuchAssessmentException if a assessment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Assessment remove(
		long spAssessmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchAssessmentException;

	public com.sambaash.platform.srv.model.Assessment updateImpl(
		com.sambaash.platform.srv.model.Assessment assessment)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the assessment with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchAssessmentException} if it could not be found.
	*
	* @param spAssessmentId the primary key of the assessment
	* @return the assessment
	* @throws com.sambaash.platform.srv.NoSuchAssessmentException if a assessment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Assessment findByPrimaryKey(
		long spAssessmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchAssessmentException;

	/**
	* Returns the assessment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spAssessmentId the primary key of the assessment
	* @return the assessment, or <code>null</code> if a assessment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Assessment fetchByPrimaryKey(
		long spAssessmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the assessments.
	*
	* @return the assessments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Assessment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.Assessment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.Assessment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the assessments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of assessments.
	*
	* @return the number of assessments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}