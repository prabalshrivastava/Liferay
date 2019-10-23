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

import com.sambaash.platform.srv.model.Activity;

/**
 * The persistence interface for the activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see ActivityPersistenceImpl
 * @see ActivityUtil
 * @generated
 */
public interface ActivityPersistence extends BasePersistence<Activity> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ActivityUtil} to access the activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the activities where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Activity> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the activities where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of activities
	* @param end the upper bound of the range of activities (not inclusive)
	* @return the range of matching activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Activity> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the activities where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of activities
	* @param end the upper bound of the range of activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Activity> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first activity in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity
	* @throws com.sambaash.platform.srv.NoSuchActivityException if a matching activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Activity findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchActivityException;

	/**
	* Returns the first activity in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity, or <code>null</code> if a matching activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Activity fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last activity in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity
	* @throws com.sambaash.platform.srv.NoSuchActivityException if a matching activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Activity findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchActivityException;

	/**
	* Returns the last activity in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity, or <code>null</code> if a matching activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Activity fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the activities before and after the current activity in the ordered set where groupId = &#63;.
	*
	* @param spActivityId the primary key of the current activity
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next activity
	* @throws com.sambaash.platform.srv.NoSuchActivityException if a activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Activity[] findByGroupId_PrevAndNext(
		long spActivityId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchActivityException;

	/**
	* Removes all the activities where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of activities where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching activities
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the activities where groupId = &#63; and spModuleId = &#63;.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @return the matching activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Activity> findByGroupIdAndModuleId(
		long groupId, long spModuleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the activities where groupId = &#63; and spModuleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @param start the lower bound of the range of activities
	* @param end the upper bound of the range of activities (not inclusive)
	* @return the range of matching activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Activity> findByGroupIdAndModuleId(
		long groupId, long spModuleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the activities where groupId = &#63; and spModuleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @param start the lower bound of the range of activities
	* @param end the upper bound of the range of activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Activity> findByGroupIdAndModuleId(
		long groupId, long spModuleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first activity in the ordered set where groupId = &#63; and spModuleId = &#63;.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity
	* @throws com.sambaash.platform.srv.NoSuchActivityException if a matching activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Activity findByGroupIdAndModuleId_First(
		long groupId, long spModuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchActivityException;

	/**
	* Returns the first activity in the ordered set where groupId = &#63; and spModuleId = &#63;.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity, or <code>null</code> if a matching activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Activity fetchByGroupIdAndModuleId_First(
		long groupId, long spModuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last activity in the ordered set where groupId = &#63; and spModuleId = &#63;.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity
	* @throws com.sambaash.platform.srv.NoSuchActivityException if a matching activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Activity findByGroupIdAndModuleId_Last(
		long groupId, long spModuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchActivityException;

	/**
	* Returns the last activity in the ordered set where groupId = &#63; and spModuleId = &#63;.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity, or <code>null</code> if a matching activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Activity fetchByGroupIdAndModuleId_Last(
		long groupId, long spModuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the activities before and after the current activity in the ordered set where groupId = &#63; and spModuleId = &#63;.
	*
	* @param spActivityId the primary key of the current activity
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next activity
	* @throws com.sambaash.platform.srv.NoSuchActivityException if a activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Activity[] findByGroupIdAndModuleId_PrevAndNext(
		long spActivityId, long groupId, long spModuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchActivityException;

	/**
	* Removes all the activities where groupId = &#63; and spModuleId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupIdAndModuleId(long groupId, long spModuleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of activities where groupId = &#63; and spModuleId = &#63;.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @return the number of matching activities
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupIdAndModuleId(long groupId, long spModuleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the activities where groupId = &#63; and spScheduleId = &#63;.
	*
	* @param groupId the group ID
	* @param spScheduleId the sp schedule ID
	* @return the matching activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Activity> findByGroupIdAndScheduleId(
		long groupId, long spScheduleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the activities where groupId = &#63; and spScheduleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param spScheduleId the sp schedule ID
	* @param start the lower bound of the range of activities
	* @param end the upper bound of the range of activities (not inclusive)
	* @return the range of matching activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Activity> findByGroupIdAndScheduleId(
		long groupId, long spScheduleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the activities where groupId = &#63; and spScheduleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param spScheduleId the sp schedule ID
	* @param start the lower bound of the range of activities
	* @param end the upper bound of the range of activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Activity> findByGroupIdAndScheduleId(
		long groupId, long spScheduleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first activity in the ordered set where groupId = &#63; and spScheduleId = &#63;.
	*
	* @param groupId the group ID
	* @param spScheduleId the sp schedule ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity
	* @throws com.sambaash.platform.srv.NoSuchActivityException if a matching activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Activity findByGroupIdAndScheduleId_First(
		long groupId, long spScheduleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchActivityException;

	/**
	* Returns the first activity in the ordered set where groupId = &#63; and spScheduleId = &#63;.
	*
	* @param groupId the group ID
	* @param spScheduleId the sp schedule ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity, or <code>null</code> if a matching activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Activity fetchByGroupIdAndScheduleId_First(
		long groupId, long spScheduleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last activity in the ordered set where groupId = &#63; and spScheduleId = &#63;.
	*
	* @param groupId the group ID
	* @param spScheduleId the sp schedule ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity
	* @throws com.sambaash.platform.srv.NoSuchActivityException if a matching activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Activity findByGroupIdAndScheduleId_Last(
		long groupId, long spScheduleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchActivityException;

	/**
	* Returns the last activity in the ordered set where groupId = &#63; and spScheduleId = &#63;.
	*
	* @param groupId the group ID
	* @param spScheduleId the sp schedule ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity, or <code>null</code> if a matching activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Activity fetchByGroupIdAndScheduleId_Last(
		long groupId, long spScheduleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the activities before and after the current activity in the ordered set where groupId = &#63; and spScheduleId = &#63;.
	*
	* @param spActivityId the primary key of the current activity
	* @param groupId the group ID
	* @param spScheduleId the sp schedule ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next activity
	* @throws com.sambaash.platform.srv.NoSuchActivityException if a activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Activity[] findByGroupIdAndScheduleId_PrevAndNext(
		long spActivityId, long groupId, long spScheduleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchActivityException;

	/**
	* Removes all the activities where groupId = &#63; and spScheduleId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param spScheduleId the sp schedule ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupIdAndScheduleId(long groupId, long spScheduleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of activities where groupId = &#63; and spScheduleId = &#63;.
	*
	* @param groupId the group ID
	* @param spScheduleId the sp schedule ID
	* @return the number of matching activities
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupIdAndScheduleId(long groupId, long spScheduleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the activity in the entity cache if it is enabled.
	*
	* @param activity the activity
	*/
	public void cacheResult(com.sambaash.platform.srv.model.Activity activity);

	/**
	* Caches the activities in the entity cache if it is enabled.
	*
	* @param activities the activities
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.Activity> activities);

	/**
	* Creates a new activity with the primary key. Does not add the activity to the database.
	*
	* @param spActivityId the primary key for the new activity
	* @return the new activity
	*/
	public com.sambaash.platform.srv.model.Activity create(long spActivityId);

	/**
	* Removes the activity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spActivityId the primary key of the activity
	* @return the activity that was removed
	* @throws com.sambaash.platform.srv.NoSuchActivityException if a activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Activity remove(long spActivityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchActivityException;

	public com.sambaash.platform.srv.model.Activity updateImpl(
		com.sambaash.platform.srv.model.Activity activity)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the activity with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchActivityException} if it could not be found.
	*
	* @param spActivityId the primary key of the activity
	* @return the activity
	* @throws com.sambaash.platform.srv.NoSuchActivityException if a activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Activity findByPrimaryKey(
		long spActivityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchActivityException;

	/**
	* Returns the activity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spActivityId the primary key of the activity
	* @return the activity, or <code>null</code> if a activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Activity fetchByPrimaryKey(
		long spActivityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the activities.
	*
	* @return the activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Activity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the activities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of activities
	* @param end the upper bound of the range of activities (not inclusive)
	* @return the range of activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Activity> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the activities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of activities
	* @param end the upper bound of the range of activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Activity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the activities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of activities.
	*
	* @return the number of activities
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}