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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ConfigurationProperty. This utility wraps
 * {@link com.wtberks.configuration.service.impl.ConfigurationPropertyLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author liferay
 * @see ConfigurationPropertyLocalService
 * @see com.wtberks.configuration.service.base.ConfigurationPropertyLocalServiceBaseImpl
 * @see com.wtberks.configuration.service.impl.ConfigurationPropertyLocalServiceImpl
 * @generated
 */
public class ConfigurationPropertyLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.wtberks.configuration.service.impl.ConfigurationPropertyLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the configuration property to the database. Also notifies the appropriate model listeners.
	*
	* @param configurationProperty the configuration property
	* @return the configuration property that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.wtberks.configuration.model.ConfigurationProperty addConfigurationProperty(
		com.wtberks.configuration.model.ConfigurationProperty configurationProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addConfigurationProperty(configurationProperty);
	}

	/**
	* Creates a new configuration property with the primary key. Does not add the configuration property to the database.
	*
	* @param configurationPropertyId the primary key for the new configuration property
	* @return the new configuration property
	*/
	public static com.wtberks.configuration.model.ConfigurationProperty createConfigurationProperty(
		long configurationPropertyId) {
		return getService().createConfigurationProperty(configurationPropertyId);
	}

	/**
	* Deletes the configuration property with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param configurationPropertyId the primary key of the configuration property
	* @return the configuration property that was removed
	* @throws PortalException if a configuration property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.wtberks.configuration.model.ConfigurationProperty deleteConfigurationProperty(
		long configurationPropertyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteConfigurationProperty(configurationPropertyId);
	}

	/**
	* Deletes the configuration property from the database. Also notifies the appropriate model listeners.
	*
	* @param configurationProperty the configuration property
	* @return the configuration property that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.wtberks.configuration.model.ConfigurationProperty deleteConfigurationProperty(
		com.wtberks.configuration.model.ConfigurationProperty configurationProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteConfigurationProperty(configurationProperty);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.wtberks.configuration.model.ConfigurationProperty fetchConfigurationProperty(
		long configurationPropertyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchConfigurationProperty(configurationPropertyId);
	}

	/**
	* Returns the configuration property with the matching UUID and company.
	*
	* @param uuid the configuration property's UUID
	* @param companyId the primary key of the company
	* @return the matching configuration property, or <code>null</code> if a matching configuration property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.wtberks.configuration.model.ConfigurationProperty fetchConfigurationPropertyByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchConfigurationPropertyByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the configuration property matching the UUID and group.
	*
	* @param uuid the configuration property's UUID
	* @param groupId the primary key of the group
	* @return the matching configuration property, or <code>null</code> if a matching configuration property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.wtberks.configuration.model.ConfigurationProperty fetchConfigurationPropertyByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchConfigurationPropertyByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the configuration property with the primary key.
	*
	* @param configurationPropertyId the primary key of the configuration property
	* @return the configuration property
	* @throws PortalException if a configuration property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.wtberks.configuration.model.ConfigurationProperty getConfigurationProperty(
		long configurationPropertyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getConfigurationProperty(configurationPropertyId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static com.wtberks.configuration.model.ConfigurationProperty getConfigurationPropertyByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getConfigurationPropertyByUuidAndCompanyId(uuid, companyId);
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
	public static com.wtberks.configuration.model.ConfigurationProperty getConfigurationPropertyByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getConfigurationPropertyByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<com.wtberks.configuration.model.ConfigurationProperty> getConfigurationProperties(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getConfigurationProperties(start, end);
	}

	/**
	* Returns the number of configuration properties.
	*
	* @return the number of configuration properties
	* @throws SystemException if a system exception occurred
	*/
	public static int getConfigurationPropertiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getConfigurationPropertiesCount();
	}

	/**
	* Updates the configuration property in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param configurationProperty the configuration property
	* @return the configuration property that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.wtberks.configuration.model.ConfigurationProperty updateConfigurationProperty(
		com.wtberks.configuration.model.ConfigurationProperty configurationProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateConfigurationProperty(configurationProperty);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.lang.String getString(long companyId, long groupId,
		java.lang.String key) {
		return getService().getString(companyId, groupId, key);
	}

	public static java.lang.String getString(long companyId, long groupId,
		java.lang.String key, boolean localGroupOnly) {
		return getService().getString(companyId, groupId, key, localGroupOnly);
	}

	public static java.lang.String getString(long userId, long companyId,
		long groupId, java.lang.String key, java.lang.String defaultValue) {
		return getService()
				   .getString(userId, companyId, groupId, key, defaultValue);
	}

	public static java.lang.String getString(long userId, long companyId,
		long groupId, java.lang.String key, java.lang.String defaultValue,
		boolean localGroupOnly) {
		return getService()
				   .getString(userId, companyId, groupId, key, defaultValue,
			localGroupOnly);
	}

	public static java.lang.Boolean getBoolean(long companyId, long groupId,
		java.lang.String key) {
		return getService().getBoolean(companyId, groupId, key);
	}

	public static java.lang.Boolean getBoolean(long companyId, long groupId,
		java.lang.String key, boolean localGroupOnly) {
		return getService().getBoolean(companyId, groupId, key, localGroupOnly);
	}

	public static java.lang.Boolean getBoolean(long userId, long companyId,
		long groupId, java.lang.String key, java.lang.Boolean defaultValue) {
		return getService()
				   .getBoolean(userId, companyId, groupId, key, defaultValue);
	}

	public static java.lang.Boolean getBoolean(long userId, long companyId,
		long groupId, java.lang.String key, java.lang.Boolean defaultValue,
		boolean localGroupOnly) {
		return getService()
				   .getBoolean(userId, companyId, groupId, key, defaultValue,
			localGroupOnly);
	}

	public static java.lang.Integer getInteger(long companyId, long groupId,
		java.lang.String key) {
		return getService().getInteger(companyId, groupId, key);
	}

	public static java.lang.Integer getInteger(long companyId, long groupId,
		java.lang.String key, boolean localGroupOnly) {
		return getService().getInteger(companyId, groupId, key, localGroupOnly);
	}

	public static java.lang.Integer getInteger(long userId, long companyId,
		long groupId, java.lang.String key, java.lang.Integer defaultValue) {
		return getService()
				   .getInteger(userId, companyId, groupId, key, defaultValue);
	}

	public static java.lang.Integer getInteger(long userId, long companyId,
		long groupId, java.lang.String key, java.lang.Integer defaultValue,
		boolean localGroupOnly) {
		return getService()
				   .getInteger(userId, companyId, groupId, key, defaultValue,
			localGroupOnly);
	}

	public static void setString(long userId, long companyId, long groupId,
		java.lang.String key, java.lang.String value) {
		getService().setString(userId, companyId, groupId, key, value);
	}

	public static void setBoolean(long userId, long companyId, long groupId,
		java.lang.String key, java.lang.Boolean value) {
		getService().setBoolean(userId, companyId, groupId, key, value);
	}

	public static void setInteger(long userId, long companyId, long groupId,
		java.lang.String key, java.lang.Integer value) {
		getService().setInteger(userId, companyId, groupId, key, value);
	}

	public static void clearService() {
		_service = null;
	}

	public static ConfigurationPropertyLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ConfigurationPropertyLocalService.class.getName());

			if (invokableLocalService instanceof ConfigurationPropertyLocalService) {
				_service = (ConfigurationPropertyLocalService)invokableLocalService;
			}
			else {
				_service = new ConfigurationPropertyLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ConfigurationPropertyLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ConfigurationPropertyLocalService service) {
	}

	private static ConfigurationPropertyLocalService _service;
}