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
 * Provides a wrapper for {@link FrameworkLocalService}.
 *
 * @author gauravvijayvergia
 * @see FrameworkLocalService
 * @generated
 */
public class FrameworkLocalServiceWrapper implements FrameworkLocalService,
	ServiceWrapper<FrameworkLocalService> {
	public FrameworkLocalServiceWrapper(
		FrameworkLocalService frameworkLocalService) {
		_frameworkLocalService = frameworkLocalService;
	}

	/**
	* Adds the framework to the database. Also notifies the appropriate model listeners.
	*
	* @param framework the framework
	* @return the framework that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Framework addFramework(
		com.sambaash.platform.srv.model.Framework framework)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _frameworkLocalService.addFramework(framework);
	}

	/**
	* Creates a new framework with the primary key. Does not add the framework to the database.
	*
	* @param spFrameworkId the primary key for the new framework
	* @return the new framework
	*/
	@Override
	public com.sambaash.platform.srv.model.Framework createFramework(
		long spFrameworkId) {
		return _frameworkLocalService.createFramework(spFrameworkId);
	}

	/**
	* Deletes the framework with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spFrameworkId the primary key of the framework
	* @return the framework that was removed
	* @throws PortalException if a framework with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Framework deleteFramework(
		long spFrameworkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _frameworkLocalService.deleteFramework(spFrameworkId);
	}

	/**
	* Deletes the framework from the database. Also notifies the appropriate model listeners.
	*
	* @param framework the framework
	* @return the framework that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Framework deleteFramework(
		com.sambaash.platform.srv.model.Framework framework)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _frameworkLocalService.deleteFramework(framework);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _frameworkLocalService.dynamicQuery();
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
		return _frameworkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _frameworkLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _frameworkLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _frameworkLocalService.dynamicQueryCount(dynamicQuery);
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
		return _frameworkLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.sambaash.platform.srv.model.Framework fetchFramework(
		long spFrameworkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _frameworkLocalService.fetchFramework(spFrameworkId);
	}

	/**
	* Returns the framework with the primary key.
	*
	* @param spFrameworkId the primary key of the framework
	* @return the framework
	* @throws PortalException if a framework with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Framework getFramework(
		long spFrameworkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _frameworkLocalService.getFramework(spFrameworkId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _frameworkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the frameworks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of frameworks
	* @param end the upper bound of the range of frameworks (not inclusive)
	* @return the range of frameworks
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.model.Framework> getFrameworks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _frameworkLocalService.getFrameworks(start, end);
	}

	/**
	* Returns the number of frameworks.
	*
	* @return the number of frameworks
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFrameworksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _frameworkLocalService.getFrameworksCount();
	}

	/**
	* Updates the framework in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param framework the framework
	* @return the framework that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.Framework updateFramework(
		com.sambaash.platform.srv.model.Framework framework)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _frameworkLocalService.updateFramework(framework);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _frameworkLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_frameworkLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _frameworkLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.sambaash.platform.srv.model.Framework create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _frameworkLocalService.create();
	}

	@Override
	public void clearCache() {
		_frameworkLocalService.clearCache();
	}

	@Override
	public com.sambaash.platform.srv.model.Framework findByFramworkCode(
		java.lang.String frameworkCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFrameworkException {
		return _frameworkLocalService.findByFramworkCode(frameworkCode);
	}

	@Override
	public com.sambaash.platform.srv.model.Framework findByNameAndGroupId(
		java.lang.String frameworkName, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFrameworkException {
		return _frameworkLocalService.findByNameAndGroupId(frameworkName,
			groupId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FrameworkLocalService getWrappedFrameworkLocalService() {
		return _frameworkLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFrameworkLocalService(
		FrameworkLocalService frameworkLocalService) {
		_frameworkLocalService = frameworkLocalService;
	}

	@Override
	public FrameworkLocalService getWrappedService() {
		return _frameworkLocalService;
	}

	@Override
	public void setWrappedService(FrameworkLocalService frameworkLocalService) {
		_frameworkLocalService = frameworkLocalService;
	}

	private FrameworkLocalService _frameworkLocalService;
}