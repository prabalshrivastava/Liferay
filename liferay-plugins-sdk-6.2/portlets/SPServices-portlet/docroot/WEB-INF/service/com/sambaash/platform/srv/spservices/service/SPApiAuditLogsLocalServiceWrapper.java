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

package com.sambaash.platform.srv.spservices.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPApiAuditLogsLocalService}.
 *
 * @author gauravvijayvergia
 * @see SPApiAuditLogsLocalService
 * @generated
 */
public class SPApiAuditLogsLocalServiceWrapper
	implements SPApiAuditLogsLocalService,
		ServiceWrapper<SPApiAuditLogsLocalService> {
	public SPApiAuditLogsLocalServiceWrapper(
		SPApiAuditLogsLocalService spApiAuditLogsLocalService) {
		_spApiAuditLogsLocalService = spApiAuditLogsLocalService;
	}

	/**
	* Adds the s p api audit logs to the database. Also notifies the appropriate model listeners.
	*
	* @param spApiAuditLogs the s p api audit logs
	* @return the s p api audit logs that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPApiAuditLogs addSPApiAuditLogs(
		com.sambaash.platform.srv.spservices.model.SPApiAuditLogs spApiAuditLogs)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spApiAuditLogsLocalService.addSPApiAuditLogs(spApiAuditLogs);
	}

	/**
	* Creates a new s p api audit logs with the primary key. Does not add the s p api audit logs to the database.
	*
	* @param spApiAuditLogsId the primary key for the new s p api audit logs
	* @return the new s p api audit logs
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPApiAuditLogs createSPApiAuditLogs(
		long spApiAuditLogsId) {
		return _spApiAuditLogsLocalService.createSPApiAuditLogs(spApiAuditLogsId);
	}

	/**
	* Deletes the s p api audit logs with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spApiAuditLogsId the primary key of the s p api audit logs
	* @return the s p api audit logs that was removed
	* @throws PortalException if a s p api audit logs with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPApiAuditLogs deleteSPApiAuditLogs(
		long spApiAuditLogsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spApiAuditLogsLocalService.deleteSPApiAuditLogs(spApiAuditLogsId);
	}

	/**
	* Deletes the s p api audit logs from the database. Also notifies the appropriate model listeners.
	*
	* @param spApiAuditLogs the s p api audit logs
	* @return the s p api audit logs that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPApiAuditLogs deleteSPApiAuditLogs(
		com.sambaash.platform.srv.spservices.model.SPApiAuditLogs spApiAuditLogs)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spApiAuditLogsLocalService.deleteSPApiAuditLogs(spApiAuditLogs);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spApiAuditLogsLocalService.dynamicQuery();
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
		return _spApiAuditLogsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPApiAuditLogsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spApiAuditLogsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPApiAuditLogsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spApiAuditLogsLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _spApiAuditLogsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spApiAuditLogsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPApiAuditLogs fetchSPApiAuditLogs(
		long spApiAuditLogsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spApiAuditLogsLocalService.fetchSPApiAuditLogs(spApiAuditLogsId);
	}

	/**
	* Returns the s p api audit logs with the matching UUID and company.
	*
	* @param uuid the s p api audit logs's UUID
	* @param companyId the primary key of the company
	* @return the matching s p api audit logs, or <code>null</code> if a matching s p api audit logs could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPApiAuditLogs fetchSPApiAuditLogsByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spApiAuditLogsLocalService.fetchSPApiAuditLogsByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the s p api audit logs matching the UUID and group.
	*
	* @param uuid the s p api audit logs's UUID
	* @param groupId the primary key of the group
	* @return the matching s p api audit logs, or <code>null</code> if a matching s p api audit logs could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPApiAuditLogs fetchSPApiAuditLogsByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spApiAuditLogsLocalService.fetchSPApiAuditLogsByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the s p api audit logs with the primary key.
	*
	* @param spApiAuditLogsId the primary key of the s p api audit logs
	* @return the s p api audit logs
	* @throws PortalException if a s p api audit logs with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPApiAuditLogs getSPApiAuditLogs(
		long spApiAuditLogsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spApiAuditLogsLocalService.getSPApiAuditLogs(spApiAuditLogsId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spApiAuditLogsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the s p api audit logs with the matching UUID and company.
	*
	* @param uuid the s p api audit logs's UUID
	* @param companyId the primary key of the company
	* @return the matching s p api audit logs
	* @throws PortalException if a matching s p api audit logs could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPApiAuditLogs getSPApiAuditLogsByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spApiAuditLogsLocalService.getSPApiAuditLogsByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the s p api audit logs matching the UUID and group.
	*
	* @param uuid the s p api audit logs's UUID
	* @param groupId the primary key of the group
	* @return the matching s p api audit logs
	* @throws PortalException if a matching s p api audit logs could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPApiAuditLogs getSPApiAuditLogsByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spApiAuditLogsLocalService.getSPApiAuditLogsByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the s p api audit logses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPApiAuditLogsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p api audit logses
	* @param end the upper bound of the range of s p api audit logses (not inclusive)
	* @return the range of s p api audit logses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPApiAuditLogs> getSPApiAuditLogses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spApiAuditLogsLocalService.getSPApiAuditLogses(start, end);
	}

	/**
	* Returns the number of s p api audit logses.
	*
	* @return the number of s p api audit logses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPApiAuditLogsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spApiAuditLogsLocalService.getSPApiAuditLogsesCount();
	}

	/**
	* Updates the s p api audit logs in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spApiAuditLogs the s p api audit logs
	* @return the s p api audit logs that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.SPApiAuditLogs updateSPApiAuditLogs(
		com.sambaash.platform.srv.spservices.model.SPApiAuditLogs spApiAuditLogs)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spApiAuditLogsLocalService.updateSPApiAuditLogs(spApiAuditLogs);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spApiAuditLogsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spApiAuditLogsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spApiAuditLogsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPApiAuditLogsLocalService getWrappedSPApiAuditLogsLocalService() {
		return _spApiAuditLogsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPApiAuditLogsLocalService(
		SPApiAuditLogsLocalService spApiAuditLogsLocalService) {
		_spApiAuditLogsLocalService = spApiAuditLogsLocalService;
	}

	@Override
	public SPApiAuditLogsLocalService getWrappedService() {
		return _spApiAuditLogsLocalService;
	}

	@Override
	public void setWrappedService(
		SPApiAuditLogsLocalService spApiAuditLogsLocalService) {
		_spApiAuditLogsLocalService = spApiAuditLogsLocalService;
	}

	private SPApiAuditLogsLocalService _spApiAuditLogsLocalService;
}