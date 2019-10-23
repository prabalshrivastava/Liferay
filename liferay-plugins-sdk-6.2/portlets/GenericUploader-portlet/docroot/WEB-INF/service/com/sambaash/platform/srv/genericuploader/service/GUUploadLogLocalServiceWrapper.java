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

package com.sambaash.platform.srv.genericuploader.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GUUploadLogLocalService}.
 *
 * @author nareshchebolu
 * @see GUUploadLogLocalService
 * @generated
 */
public class GUUploadLogLocalServiceWrapper implements GUUploadLogLocalService,
	ServiceWrapper<GUUploadLogLocalService> {
	public GUUploadLogLocalServiceWrapper(
		GUUploadLogLocalService guUploadLogLocalService) {
		_guUploadLogLocalService = guUploadLogLocalService;
	}

	/**
	* Adds the g u upload log to the database. Also notifies the appropriate model listeners.
	*
	* @param guUploadLog the g u upload log
	* @return the g u upload log that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.genericuploader.model.GUUploadLog addGUUploadLog(
		com.sambaash.platform.srv.genericuploader.model.GUUploadLog guUploadLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guUploadLogLocalService.addGUUploadLog(guUploadLog);
	}

	/**
	* Creates a new g u upload log with the primary key. Does not add the g u upload log to the database.
	*
	* @param SPGUUploadLogId the primary key for the new g u upload log
	* @return the new g u upload log
	*/
	@Override
	public com.sambaash.platform.srv.genericuploader.model.GUUploadLog createGUUploadLog(
		long SPGUUploadLogId) {
		return _guUploadLogLocalService.createGUUploadLog(SPGUUploadLogId);
	}

	/**
	* Deletes the g u upload log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param SPGUUploadLogId the primary key of the g u upload log
	* @return the g u upload log that was removed
	* @throws PortalException if a g u upload log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.genericuploader.model.GUUploadLog deleteGUUploadLog(
		long SPGUUploadLogId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _guUploadLogLocalService.deleteGUUploadLog(SPGUUploadLogId);
	}

	/**
	* Deletes the g u upload log from the database. Also notifies the appropriate model listeners.
	*
	* @param guUploadLog the g u upload log
	* @return the g u upload log that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.genericuploader.model.GUUploadLog deleteGUUploadLog(
		com.sambaash.platform.srv.genericuploader.model.GUUploadLog guUploadLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guUploadLogLocalService.deleteGUUploadLog(guUploadLog);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _guUploadLogLocalService.dynamicQuery();
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
		return _guUploadLogLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericuploader.model.impl.GUUploadLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _guUploadLogLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericuploader.model.impl.GUUploadLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _guUploadLogLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _guUploadLogLocalService.dynamicQueryCount(dynamicQuery);
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
		return _guUploadLogLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.genericuploader.model.GUUploadLog fetchGUUploadLog(
		long SPGUUploadLogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guUploadLogLocalService.fetchGUUploadLog(SPGUUploadLogId);
	}

	/**
	* Returns the g u upload log with the primary key.
	*
	* @param SPGUUploadLogId the primary key of the g u upload log
	* @return the g u upload log
	* @throws PortalException if a g u upload log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.genericuploader.model.GUUploadLog getGUUploadLog(
		long SPGUUploadLogId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _guUploadLogLocalService.getGUUploadLog(SPGUUploadLogId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _guUploadLogLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the g u upload logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericuploader.model.impl.GUUploadLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g u upload logs
	* @param end the upper bound of the range of g u upload logs (not inclusive)
	* @return the range of g u upload logs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.genericuploader.model.GUUploadLog> getGUUploadLogs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guUploadLogLocalService.getGUUploadLogs(start, end);
	}

	/**
	* Returns the number of g u upload logs.
	*
	* @return the number of g u upload logs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGUUploadLogsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guUploadLogLocalService.getGUUploadLogsCount();
	}

	/**
	* Updates the g u upload log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param guUploadLog the g u upload log
	* @return the g u upload log that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.genericuploader.model.GUUploadLog updateGUUploadLog(
		com.sambaash.platform.srv.genericuploader.model.GUUploadLog guUploadLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guUploadLogLocalService.updateGUUploadLog(guUploadLog);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _guUploadLogLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_guUploadLogLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _guUploadLogLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.sambaash.platform.srv.genericuploader.model.GUUploadLog create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guUploadLogLocalService.create();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GUUploadLogLocalService getWrappedGUUploadLogLocalService() {
		return _guUploadLogLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGUUploadLogLocalService(
		GUUploadLogLocalService guUploadLogLocalService) {
		_guUploadLogLocalService = guUploadLogLocalService;
	}

	@Override
	public GUUploadLogLocalService getWrappedService() {
		return _guUploadLogLocalService;
	}

	@Override
	public void setWrappedService(
		GUUploadLogLocalService guUploadLogLocalService) {
		_guUploadLogLocalService = guUploadLogLocalService;
	}

	private GUUploadLogLocalService _guUploadLogLocalService;
}