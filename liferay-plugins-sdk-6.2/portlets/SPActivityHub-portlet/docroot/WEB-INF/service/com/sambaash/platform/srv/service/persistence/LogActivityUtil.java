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

import com.sambaash.platform.srv.model.LogActivity;

import java.util.List;

/**
 * The persistence utility for the log activity service. This utility wraps {@link LogActivityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author aishwarya
 * @see LogActivityPersistence
 * @see LogActivityPersistenceImpl
 * @generated
 */
public class LogActivityUtil {
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
	public static void clearCache(LogActivity logActivity) {
		getPersistence().clearCache(logActivity);
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
	public static List<LogActivity> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LogActivity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LogActivity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LogActivity update(LogActivity logActivity)
		throws SystemException {
		return getPersistence().update(logActivity);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LogActivity update(LogActivity logActivity,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(logActivity, serviceContext);
	}

	/**
	* Returns the log activity where entityClassId = &#63; and entityId = &#63; and parentLogActivityId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchLogActivityException} if it could not be found.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param parentLogActivityId the parent log activity ID
	* @return the matching log activity
	* @throws com.sambaash.platform.srv.NoSuchLogActivityException if a matching log activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.LogActivity findByentityClassIdEntityIdParentLogActivityId(
		long entityClassId, long entityId, long parentLogActivityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchLogActivityException {
		return getPersistence()
				   .findByentityClassIdEntityIdParentLogActivityId(entityClassId,
			entityId, parentLogActivityId);
	}

	/**
	* Returns the log activity where entityClassId = &#63; and entityId = &#63; and parentLogActivityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param parentLogActivityId the parent log activity ID
	* @return the matching log activity, or <code>null</code> if a matching log activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.LogActivity fetchByentityClassIdEntityIdParentLogActivityId(
		long entityClassId, long entityId, long parentLogActivityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByentityClassIdEntityIdParentLogActivityId(entityClassId,
			entityId, parentLogActivityId);
	}

	/**
	* Returns the log activity where entityClassId = &#63; and entityId = &#63; and parentLogActivityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param parentLogActivityId the parent log activity ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching log activity, or <code>null</code> if a matching log activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.LogActivity fetchByentityClassIdEntityIdParentLogActivityId(
		long entityClassId, long entityId, long parentLogActivityId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByentityClassIdEntityIdParentLogActivityId(entityClassId,
			entityId, parentLogActivityId, retrieveFromCache);
	}

	/**
	* Removes the log activity where entityClassId = &#63; and entityId = &#63; and parentLogActivityId = &#63; from the database.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param parentLogActivityId the parent log activity ID
	* @return the log activity that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.LogActivity removeByentityClassIdEntityIdParentLogActivityId(
		long entityClassId, long entityId, long parentLogActivityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchLogActivityException {
		return getPersistence()
				   .removeByentityClassIdEntityIdParentLogActivityId(entityClassId,
			entityId, parentLogActivityId);
	}

	/**
	* Returns the number of log activities where entityClassId = &#63; and entityId = &#63; and parentLogActivityId = &#63;.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param parentLogActivityId the parent log activity ID
	* @return the number of matching log activities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByentityClassIdEntityIdParentLogActivityId(
		long entityClassId, long entityId, long parentLogActivityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByentityClassIdEntityIdParentLogActivityId(entityClassId,
			entityId, parentLogActivityId);
	}

	/**
	* Caches the log activity in the entity cache if it is enabled.
	*
	* @param logActivity the log activity
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.model.LogActivity logActivity) {
		getPersistence().cacheResult(logActivity);
	}

	/**
	* Caches the log activities in the entity cache if it is enabled.
	*
	* @param logActivities the log activities
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.LogActivity> logActivities) {
		getPersistence().cacheResult(logActivities);
	}

	/**
	* Creates a new log activity with the primary key. Does not add the log activity to the database.
	*
	* @param spLogActivityId the primary key for the new log activity
	* @return the new log activity
	*/
	public static com.sambaash.platform.srv.model.LogActivity create(
		long spLogActivityId) {
		return getPersistence().create(spLogActivityId);
	}

	/**
	* Removes the log activity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spLogActivityId the primary key of the log activity
	* @return the log activity that was removed
	* @throws com.sambaash.platform.srv.NoSuchLogActivityException if a log activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.LogActivity remove(
		long spLogActivityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchLogActivityException {
		return getPersistence().remove(spLogActivityId);
	}

	public static com.sambaash.platform.srv.model.LogActivity updateImpl(
		com.sambaash.platform.srv.model.LogActivity logActivity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(logActivity);
	}

	/**
	* Returns the log activity with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchLogActivityException} if it could not be found.
	*
	* @param spLogActivityId the primary key of the log activity
	* @return the log activity
	* @throws com.sambaash.platform.srv.NoSuchLogActivityException if a log activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.LogActivity findByPrimaryKey(
		long spLogActivityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchLogActivityException {
		return getPersistence().findByPrimaryKey(spLogActivityId);
	}

	/**
	* Returns the log activity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spLogActivityId the primary key of the log activity
	* @return the log activity, or <code>null</code> if a log activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.LogActivity fetchByPrimaryKey(
		long spLogActivityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spLogActivityId);
	}

	/**
	* Returns all the log activities.
	*
	* @return the log activities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.LogActivity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the log activities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.LogActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of log activities
	* @param end the upper bound of the range of log activities (not inclusive)
	* @return the range of log activities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.LogActivity> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the log activities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.LogActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of log activities
	* @param end the upper bound of the range of log activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of log activities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.LogActivity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the log activities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of log activities.
	*
	* @return the number of log activities
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LogActivityPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LogActivityPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.service.ClpSerializer.getServletContextName(),
					LogActivityPersistence.class.getName());

			ReferenceRegistry.registerReference(LogActivityUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LogActivityPersistence persistence) {
	}

	private static LogActivityPersistence _persistence;
}