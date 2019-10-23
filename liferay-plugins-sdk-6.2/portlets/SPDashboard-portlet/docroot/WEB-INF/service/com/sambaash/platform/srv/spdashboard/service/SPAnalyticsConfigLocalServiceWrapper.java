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

package com.sambaash.platform.srv.spdashboard.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPAnalyticsConfigLocalService}.
 *
 * @author pradeep
 * @see SPAnalyticsConfigLocalService
 * @generated
 */
public class SPAnalyticsConfigLocalServiceWrapper
	implements SPAnalyticsConfigLocalService,
		ServiceWrapper<SPAnalyticsConfigLocalService> {
	public SPAnalyticsConfigLocalServiceWrapper(
		SPAnalyticsConfigLocalService spAnalyticsConfigLocalService) {
		_spAnalyticsConfigLocalService = spAnalyticsConfigLocalService;
	}

	/**
	* Adds the s p analytics config to the database. Also notifies the appropriate model listeners.
	*
	* @param spAnalyticsConfig the s p analytics config
	* @return the s p analytics config that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig addSPAnalyticsConfig(
		com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig spAnalyticsConfig)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAnalyticsConfigLocalService.addSPAnalyticsConfig(spAnalyticsConfig);
	}

	/**
	* Creates a new s p analytics config with the primary key. Does not add the s p analytics config to the database.
	*
	* @param spAnalyticsConfigId the primary key for the new s p analytics config
	* @return the new s p analytics config
	*/
	@Override
	public com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig createSPAnalyticsConfig(
		long spAnalyticsConfigId) {
		return _spAnalyticsConfigLocalService.createSPAnalyticsConfig(spAnalyticsConfigId);
	}

	/**
	* Deletes the s p analytics config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spAnalyticsConfigId the primary key of the s p analytics config
	* @return the s p analytics config that was removed
	* @throws PortalException if a s p analytics config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig deleteSPAnalyticsConfig(
		long spAnalyticsConfigId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spAnalyticsConfigLocalService.deleteSPAnalyticsConfig(spAnalyticsConfigId);
	}

	/**
	* Deletes the s p analytics config from the database. Also notifies the appropriate model listeners.
	*
	* @param spAnalyticsConfig the s p analytics config
	* @return the s p analytics config that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig deleteSPAnalyticsConfig(
		com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig spAnalyticsConfig)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAnalyticsConfigLocalService.deleteSPAnalyticsConfig(spAnalyticsConfig);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spAnalyticsConfigLocalService.dynamicQuery();
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
		return _spAnalyticsConfigLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdashboard.model.impl.SPAnalyticsConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spAnalyticsConfigLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdashboard.model.impl.SPAnalyticsConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spAnalyticsConfigLocalService.dynamicQuery(dynamicQuery, start,
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
		return _spAnalyticsConfigLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spAnalyticsConfigLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig fetchSPAnalyticsConfig(
		long spAnalyticsConfigId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAnalyticsConfigLocalService.fetchSPAnalyticsConfig(spAnalyticsConfigId);
	}

	/**
	* Returns the s p analytics config with the primary key.
	*
	* @param spAnalyticsConfigId the primary key of the s p analytics config
	* @return the s p analytics config
	* @throws PortalException if a s p analytics config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig getSPAnalyticsConfig(
		long spAnalyticsConfigId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spAnalyticsConfigLocalService.getSPAnalyticsConfig(spAnalyticsConfigId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spAnalyticsConfigLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p analytics configs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdashboard.model.impl.SPAnalyticsConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p analytics configs
	* @param end the upper bound of the range of s p analytics configs (not inclusive)
	* @return the range of s p analytics configs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig> getSPAnalyticsConfigs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAnalyticsConfigLocalService.getSPAnalyticsConfigs(start, end);
	}

	/**
	* Returns the number of s p analytics configs.
	*
	* @return the number of s p analytics configs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPAnalyticsConfigsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAnalyticsConfigLocalService.getSPAnalyticsConfigsCount();
	}

	/**
	* Updates the s p analytics config in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spAnalyticsConfig the s p analytics config
	* @return the s p analytics config that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig updateSPAnalyticsConfig(
		com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig spAnalyticsConfig)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAnalyticsConfigLocalService.updateSPAnalyticsConfig(spAnalyticsConfig);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spAnalyticsConfigLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spAnalyticsConfigLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spAnalyticsConfigLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig> findByWarIdAndType(
		java.lang.String warId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAnalyticsConfigLocalService.findByWarIdAndType(warId, type);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig> findByWarId(
		java.lang.String warId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAnalyticsConfigLocalService.findByWarId(warId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPAnalyticsConfigLocalService getWrappedSPAnalyticsConfigLocalService() {
		return _spAnalyticsConfigLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPAnalyticsConfigLocalService(
		SPAnalyticsConfigLocalService spAnalyticsConfigLocalService) {
		_spAnalyticsConfigLocalService = spAnalyticsConfigLocalService;
	}

	@Override
	public SPAnalyticsConfigLocalService getWrappedService() {
		return _spAnalyticsConfigLocalService;
	}

	@Override
	public void setWrappedService(
		SPAnalyticsConfigLocalService spAnalyticsConfigLocalService) {
		_spAnalyticsConfigLocalService = spAnalyticsConfigLocalService;
	}

	private SPAnalyticsConfigLocalService _spAnalyticsConfigLocalService;
}