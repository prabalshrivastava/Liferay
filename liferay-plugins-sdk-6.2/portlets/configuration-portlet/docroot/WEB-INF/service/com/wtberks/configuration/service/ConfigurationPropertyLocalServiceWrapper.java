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

package com.wtberks.configuration.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ConfigurationPropertyLocalService}.
 *
 * @author liferay
 * @see ConfigurationPropertyLocalService
 * @generated
 */
public class ConfigurationPropertyLocalServiceWrapper
	implements ConfigurationPropertyLocalService,
		ServiceWrapper<ConfigurationPropertyLocalService> {
	public ConfigurationPropertyLocalServiceWrapper(
		ConfigurationPropertyLocalService configurationPropertyLocalService) {
		_configurationPropertyLocalService = configurationPropertyLocalService;
	}

	/**
	* Adds the configuration property to the database. Also notifies the appropriate model listeners.
	*
	* @param configurationProperty the configuration property
	* @return the configuration property that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.wtberks.configuration.model.ConfigurationProperty addConfigurationProperty(
		com.wtberks.configuration.model.ConfigurationProperty configurationProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configurationPropertyLocalService.addConfigurationProperty(configurationProperty);
	}

	/**
	* Creates a new configuration property with the primary key. Does not add the configuration property to the database.
	*
	* @param configurationPropertyId the primary key for the new configuration property
	* @return the new configuration property
	*/
	@Override
	public com.wtberks.configuration.model.ConfigurationProperty createConfigurationProperty(
		long configurationPropertyId) {
		return _configurationPropertyLocalService.createConfigurationProperty(configurationPropertyId);
	}

	/**
	* Deletes the configuration property with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param configurationPropertyId the primary key of the configuration property
	* @return the configuration property that was removed
	* @throws PortalException if a configuration property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.wtberks.configuration.model.ConfigurationProperty deleteConfigurationProperty(
		long configurationPropertyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _configurationPropertyLocalService.deleteConfigurationProperty(configurationPropertyId);
	}

	/**
	* Deletes the configuration property from the database. Also notifies the appropriate model listeners.
	*
	* @param configurationProperty the configuration property
	* @return the configuration property that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.wtberks.configuration.model.ConfigurationProperty deleteConfigurationProperty(
		com.wtberks.configuration.model.ConfigurationProperty configurationProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configurationPropertyLocalService.deleteConfigurationProperty(configurationProperty);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _configurationPropertyLocalService.dynamicQuery();
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
		return _configurationPropertyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.wtberks.configuration.model.impl.ConfigurationPropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _configurationPropertyLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.wtberks.configuration.model.impl.ConfigurationPropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _configurationPropertyLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _configurationPropertyLocalService.dynamicQueryCount(dynamicQuery);
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
		return _configurationPropertyLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.wtberks.configuration.model.ConfigurationProperty fetchConfigurationProperty(
		long configurationPropertyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configurationPropertyLocalService.fetchConfigurationProperty(configurationPropertyId);
	}

	/**
	* Returns the configuration property with the matching UUID and company.
	*
	* @param uuid the configuration property's UUID
	* @param companyId the primary key of the company
	* @return the matching configuration property, or <code>null</code> if a matching configuration property could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.wtberks.configuration.model.ConfigurationProperty fetchConfigurationPropertyByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configurationPropertyLocalService.fetchConfigurationPropertyByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the configuration property matching the UUID and group.
	*
	* @param uuid the configuration property's UUID
	* @param groupId the primary key of the group
	* @return the matching configuration property, or <code>null</code> if a matching configuration property could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.wtberks.configuration.model.ConfigurationProperty fetchConfigurationPropertyByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configurationPropertyLocalService.fetchConfigurationPropertyByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the configuration property with the primary key.
	*
	* @param configurationPropertyId the primary key of the configuration property
	* @return the configuration property
	* @throws PortalException if a configuration property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.wtberks.configuration.model.ConfigurationProperty getConfigurationProperty(
		long configurationPropertyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _configurationPropertyLocalService.getConfigurationProperty(configurationPropertyId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _configurationPropertyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the configuration property with the matching UUID and company.
	*
	* @param uuid the configuration property's UUID
	* @param companyId the primary key of the company
	* @return the matching configuration property
	* @throws PortalException if a matching configuration property could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.wtberks.configuration.model.ConfigurationProperty getConfigurationPropertyByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _configurationPropertyLocalService.getConfigurationPropertyByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the configuration property matching the UUID and group.
	*
	* @param uuid the configuration property's UUID
	* @param groupId the primary key of the group
	* @return the matching configuration property
	* @throws PortalException if a matching configuration property could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.wtberks.configuration.model.ConfigurationProperty getConfigurationPropertyByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _configurationPropertyLocalService.getConfigurationPropertyByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the configuration properties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.wtberks.configuration.model.impl.ConfigurationPropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of configuration properties
	* @param end the upper bound of the range of configuration properties (not inclusive)
	* @return the range of configuration properties
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.wtberks.configuration.model.ConfigurationProperty> getConfigurationProperties(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configurationPropertyLocalService.getConfigurationProperties(start,
			end);
	}

	/**
	* Returns the number of configuration properties.
	*
	* @return the number of configuration properties
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getConfigurationPropertiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configurationPropertyLocalService.getConfigurationPropertiesCount();
	}

	/**
	* Updates the configuration property in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param configurationProperty the configuration property
	* @return the configuration property that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.wtberks.configuration.model.ConfigurationProperty updateConfigurationProperty(
		com.wtberks.configuration.model.ConfigurationProperty configurationProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configurationPropertyLocalService.updateConfigurationProperty(configurationProperty);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _configurationPropertyLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_configurationPropertyLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _configurationPropertyLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.lang.String getString(long companyId, long groupId,
		java.lang.String key) {
		return _configurationPropertyLocalService.getString(companyId, groupId,
			key);
	}

	@Override
	public java.lang.String getString(long companyId, long groupId,
		java.lang.String key, boolean localGroupOnly) {
		return _configurationPropertyLocalService.getString(companyId, groupId,
			key, localGroupOnly);
	}

	@Override
	public java.lang.String getString(long userId, long companyId,
		long groupId, java.lang.String key, java.lang.String defaultValue) {
		return _configurationPropertyLocalService.getString(userId, companyId,
			groupId, key, defaultValue);
	}

	@Override
	public java.lang.String getString(long userId, long companyId,
		long groupId, java.lang.String key, java.lang.String defaultValue,
		boolean localGroupOnly) {
		return _configurationPropertyLocalService.getString(userId, companyId,
			groupId, key, defaultValue, localGroupOnly);
	}

	@Override
	public java.lang.Boolean getBoolean(long companyId, long groupId,
		java.lang.String key) {
		return _configurationPropertyLocalService.getBoolean(companyId,
			groupId, key);
	}

	@Override
	public java.lang.Boolean getBoolean(long companyId, long groupId,
		java.lang.String key, boolean localGroupOnly) {
		return _configurationPropertyLocalService.getBoolean(companyId,
			groupId, key, localGroupOnly);
	}

	@Override
	public java.lang.Boolean getBoolean(long userId, long companyId,
		long groupId, java.lang.String key, java.lang.Boolean defaultValue) {
		return _configurationPropertyLocalService.getBoolean(userId, companyId,
			groupId, key, defaultValue);
	}

	@Override
	public java.lang.Boolean getBoolean(long userId, long companyId,
		long groupId, java.lang.String key, java.lang.Boolean defaultValue,
		boolean localGroupOnly) {
		return _configurationPropertyLocalService.getBoolean(userId, companyId,
			groupId, key, defaultValue, localGroupOnly);
	}

	@Override
	public java.lang.Integer getInteger(long companyId, long groupId,
		java.lang.String key) {
		return _configurationPropertyLocalService.getInteger(companyId,
			groupId, key);
	}

	@Override
	public java.lang.Integer getInteger(long companyId, long groupId,
		java.lang.String key, boolean localGroupOnly) {
		return _configurationPropertyLocalService.getInteger(companyId,
			groupId, key, localGroupOnly);
	}

	@Override
	public java.lang.Integer getInteger(long userId, long companyId,
		long groupId, java.lang.String key, java.lang.Integer defaultValue) {
		return _configurationPropertyLocalService.getInteger(userId, companyId,
			groupId, key, defaultValue);
	}

	@Override
	public java.lang.Integer getInteger(long userId, long companyId,
		long groupId, java.lang.String key, java.lang.Integer defaultValue,
		boolean localGroupOnly) {
		return _configurationPropertyLocalService.getInteger(userId, companyId,
			groupId, key, defaultValue, localGroupOnly);
	}

	@Override
	public void setString(long userId, long companyId, long groupId,
		java.lang.String key, java.lang.String value) {
		_configurationPropertyLocalService.setString(userId, companyId,
			groupId, key, value);
	}

	@Override
	public void setBoolean(long userId, long companyId, long groupId,
		java.lang.String key, java.lang.Boolean value) {
		_configurationPropertyLocalService.setBoolean(userId, companyId,
			groupId, key, value);
	}

	@Override
	public void setInteger(long userId, long companyId, long groupId,
		java.lang.String key, java.lang.Integer value) {
		_configurationPropertyLocalService.setInteger(userId, companyId,
			groupId, key, value);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ConfigurationPropertyLocalService getWrappedConfigurationPropertyLocalService() {
		return _configurationPropertyLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedConfigurationPropertyLocalService(
		ConfigurationPropertyLocalService configurationPropertyLocalService) {
		_configurationPropertyLocalService = configurationPropertyLocalService;
	}

	@Override
	public ConfigurationPropertyLocalService getWrappedService() {
		return _configurationPropertyLocalService;
	}

	@Override
	public void setWrappedService(
		ConfigurationPropertyLocalService configurationPropertyLocalService) {
		_configurationPropertyLocalService = configurationPropertyLocalService;
	}

	private ConfigurationPropertyLocalService _configurationPropertyLocalService;
}