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

package com.sambaash.platform.srv.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LogActivityLocalService}.
 *
 * @author aishwarya
 * @see LogActivityLocalService
 * @generated
 */
public class LogActivityLocalServiceWrapper implements LogActivityLocalService,
	ServiceWrapper<LogActivityLocalService> {
	public LogActivityLocalServiceWrapper(
		LogActivityLocalService logActivityLocalService) {
		_logActivityLocalService = logActivityLocalService;
	}

	/**
	* Adds the log activity to the database. Also notifies the appropriate model listeners.
	*
	* @param logActivity the log activity
	* @return the log activity that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.LogActivity addLogActivity(
		com.sambaash.platform.srv.model.LogActivity logActivity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logActivityLocalService.addLogActivity(logActivity);
	}

	/**
	* Creates a new log activity with the primary key. Does not add the log activity to the database.
	*
	* @param spLogActivityId the primary key for the new log activity
	* @return the new log activity
	*/
	@Override
	public com.sambaash.platform.srv.model.LogActivity createLogActivity(
		long spLogActivityId) {
		return _logActivityLocalService.createLogActivity(spLogActivityId);
	}

	/**
	* Deletes the log activity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spLogActivityId the primary key of the log activity
	* @return the log activity that was removed
	* @throws PortalException if a log activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.LogActivity deleteLogActivity(
		long spLogActivityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _logActivityLocalService.deleteLogActivity(spLogActivityId);
	}

	/**
	* Deletes the log activity from the database. Also notifies the appropriate model listeners.
	*
	* @param logActivity the log activity
	* @return the log activity that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.LogActivity deleteLogActivity(
		com.sambaash.platform.srv.model.LogActivity logActivity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logActivityLocalService.deleteLogActivity(logActivity);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _logActivityLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logActivityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.LogActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _logActivityLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.LogActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logActivityLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logActivityLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logActivityLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.model.LogActivity fetchLogActivity(
		long spLogActivityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logActivityLocalService.fetchLogActivity(spLogActivityId);
	}

	/**
	* Returns the log activity with the primary key.
	*
	* @param spLogActivityId the primary key of the log activity
	* @return the log activity
	* @throws PortalException if a log activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.LogActivity getLogActivity(
		long spLogActivityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _logActivityLocalService.getLogActivity(spLogActivityId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _logActivityLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.sambaash.platform.srv.model.LogActivity> getLogActivities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logActivityLocalService.getLogActivities(start, end);
	}

	/**
	* Returns the number of log activities.
	*
	* @return the number of log activities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLogActivitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logActivityLocalService.getLogActivitiesCount();
	}

	/**
	* Updates the log activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param logActivity the log activity
	* @return the log activity that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.LogActivity updateLogActivity(
		com.sambaash.platform.srv.model.LogActivity logActivity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logActivityLocalService.updateLogActivity(logActivity);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _logActivityLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_logActivityLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _logActivityLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.sambaash.platform.srv.model.LogActivity fetchByentityClassIdEntityIdParentLogActivityId(
		long entityClassId, long entityId, long parentLogActivityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logActivityLocalService.fetchByentityClassIdEntityIdParentLogActivityId(entityClassId,
			entityId, parentLogActivityId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LogActivityLocalService getWrappedLogActivityLocalService() {
		return _logActivityLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLogActivityLocalService(
		LogActivityLocalService logActivityLocalService) {
		_logActivityLocalService = logActivityLocalService;
	}

	@Override
	public LogActivityLocalService getWrappedService() {
		return _logActivityLocalService;
	}

	@Override
	public void setWrappedService(
		LogActivityLocalService logActivityLocalService) {
		_logActivityLocalService = logActivityLocalService;
	}

	private LogActivityLocalService _logActivityLocalService;
}