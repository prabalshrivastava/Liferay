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

import com.sambaash.platform.srv.model.Schedule;

import java.util.List;

/**
 * The persistence utility for the schedule service. This utility wraps {@link SchedulePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SchedulePersistence
 * @see SchedulePersistenceImpl
 * @generated
 */
public class ScheduleUtil {
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
	public static void clearCache(Schedule schedule) {
		getPersistence().clearCache(schedule);
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
	public static List<Schedule> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Schedule> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Schedule> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Schedule update(Schedule schedule) throws SystemException {
		return getPersistence().update(schedule);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Schedule update(Schedule schedule,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(schedule, serviceContext);
	}

	/**
	* Returns all the schedules where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching schedules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Schedule> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the schedules where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of schedules
	* @param end the upper bound of the range of schedules (not inclusive)
	* @return the range of matching schedules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Schedule> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the schedules where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of schedules
	* @param end the upper bound of the range of schedules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching schedules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Schedule> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first schedule in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching schedule
	* @throws com.sambaash.platform.srv.NoSuchScheduleException if a matching schedule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Schedule findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchScheduleException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first schedule in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching schedule, or <code>null</code> if a matching schedule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Schedule fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last schedule in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching schedule
	* @throws com.sambaash.platform.srv.NoSuchScheduleException if a matching schedule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Schedule findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchScheduleException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last schedule in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching schedule, or <code>null</code> if a matching schedule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Schedule fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the schedules before and after the current schedule in the ordered set where groupId = &#63;.
	*
	* @param spScheduleId the primary key of the current schedule
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next schedule
	* @throws com.sambaash.platform.srv.NoSuchScheduleException if a schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Schedule[] findByGroupId_PrevAndNext(
		long spScheduleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchScheduleException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(spScheduleId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the schedules where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of schedules where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching schedules
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the schedules where groupId = &#63; and spModuleId = &#63;.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @return the matching schedules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Schedule> findByGroupIdAndModuleId(
		long groupId, long spModuleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupIdAndModuleId(groupId, spModuleId);
	}

	/**
	* Returns a range of all the schedules where groupId = &#63; and spModuleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @param start the lower bound of the range of schedules
	* @param end the upper bound of the range of schedules (not inclusive)
	* @return the range of matching schedules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Schedule> findByGroupIdAndModuleId(
		long groupId, long spModuleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdAndModuleId(groupId, spModuleId, start, end);
	}

	/**
	* Returns an ordered range of all the schedules where groupId = &#63; and spModuleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @param start the lower bound of the range of schedules
	* @param end the upper bound of the range of schedules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching schedules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Schedule> findByGroupIdAndModuleId(
		long groupId, long spModuleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdAndModuleId(groupId, spModuleId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first schedule in the ordered set where groupId = &#63; and spModuleId = &#63;.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching schedule
	* @throws com.sambaash.platform.srv.NoSuchScheduleException if a matching schedule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Schedule findByGroupIdAndModuleId_First(
		long groupId, long spModuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchScheduleException {
		return getPersistence()
				   .findByGroupIdAndModuleId_First(groupId, spModuleId,
			orderByComparator);
	}

	/**
	* Returns the first schedule in the ordered set where groupId = &#63; and spModuleId = &#63;.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching schedule, or <code>null</code> if a matching schedule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Schedule fetchByGroupIdAndModuleId_First(
		long groupId, long spModuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdAndModuleId_First(groupId, spModuleId,
			orderByComparator);
	}

	/**
	* Returns the last schedule in the ordered set where groupId = &#63; and spModuleId = &#63;.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching schedule
	* @throws com.sambaash.platform.srv.NoSuchScheduleException if a matching schedule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Schedule findByGroupIdAndModuleId_Last(
		long groupId, long spModuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchScheduleException {
		return getPersistence()
				   .findByGroupIdAndModuleId_Last(groupId, spModuleId,
			orderByComparator);
	}

	/**
	* Returns the last schedule in the ordered set where groupId = &#63; and spModuleId = &#63;.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching schedule, or <code>null</code> if a matching schedule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Schedule fetchByGroupIdAndModuleId_Last(
		long groupId, long spModuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdAndModuleId_Last(groupId, spModuleId,
			orderByComparator);
	}

	/**
	* Returns the schedules before and after the current schedule in the ordered set where groupId = &#63; and spModuleId = &#63;.
	*
	* @param spScheduleId the primary key of the current schedule
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next schedule
	* @throws com.sambaash.platform.srv.NoSuchScheduleException if a schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Schedule[] findByGroupIdAndModuleId_PrevAndNext(
		long spScheduleId, long groupId, long spModuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchScheduleException {
		return getPersistence()
				   .findByGroupIdAndModuleId_PrevAndNext(spScheduleId, groupId,
			spModuleId, orderByComparator);
	}

	/**
	* Removes all the schedules where groupId = &#63; and spModuleId = &#63; from the database.
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
	* Returns the number of schedules where groupId = &#63; and spModuleId = &#63;.
	*
	* @param groupId the group ID
	* @param spModuleId the sp module ID
	* @return the number of matching schedules
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupIdAndModuleId(long groupId, long spModuleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupIdAndModuleId(groupId, spModuleId);
	}

	/**
	* Caches the schedule in the entity cache if it is enabled.
	*
	* @param schedule the schedule
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.model.Schedule schedule) {
		getPersistence().cacheResult(schedule);
	}

	/**
	* Caches the schedules in the entity cache if it is enabled.
	*
	* @param schedules the schedules
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.Schedule> schedules) {
		getPersistence().cacheResult(schedules);
	}

	/**
	* Creates a new schedule with the primary key. Does not add the schedule to the database.
	*
	* @param spScheduleId the primary key for the new schedule
	* @return the new schedule
	*/
	public static com.sambaash.platform.srv.model.Schedule create(
		long spScheduleId) {
		return getPersistence().create(spScheduleId);
	}

	/**
	* Removes the schedule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spScheduleId the primary key of the schedule
	* @return the schedule that was removed
	* @throws com.sambaash.platform.srv.NoSuchScheduleException if a schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Schedule remove(
		long spScheduleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchScheduleException {
		return getPersistence().remove(spScheduleId);
	}

	public static com.sambaash.platform.srv.model.Schedule updateImpl(
		com.sambaash.platform.srv.model.Schedule schedule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(schedule);
	}

	/**
	* Returns the schedule with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchScheduleException} if it could not be found.
	*
	* @param spScheduleId the primary key of the schedule
	* @return the schedule
	* @throws com.sambaash.platform.srv.NoSuchScheduleException if a schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Schedule findByPrimaryKey(
		long spScheduleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchScheduleException {
		return getPersistence().findByPrimaryKey(spScheduleId);
	}

	/**
	* Returns the schedule with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spScheduleId the primary key of the schedule
	* @return the schedule, or <code>null</code> if a schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Schedule fetchByPrimaryKey(
		long spScheduleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spScheduleId);
	}

	/**
	* Returns all the schedules.
	*
	* @return the schedules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Schedule> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the schedules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of schedules
	* @param end the upper bound of the range of schedules (not inclusive)
	* @return the range of schedules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Schedule> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the schedules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of schedules
	* @param end the upper bound of the range of schedules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of schedules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Schedule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the schedules from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of schedules.
	*
	* @return the number of schedules
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SchedulePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SchedulePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.service.ClpSerializer.getServletContextName(),
					SchedulePersistence.class.getName());

			ReferenceRegistry.registerReference(ScheduleUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SchedulePersistence persistence) {
	}

	private static SchedulePersistence _persistence;
}