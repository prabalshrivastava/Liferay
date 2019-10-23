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

package com.sambaash.platform.srv.spshopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPSellingPackageLocalService}.
 *
 * @author pradeep
 * @see SPSellingPackageLocalService
 * @generated
 */
public class SPSellingPackageLocalServiceWrapper
	implements SPSellingPackageLocalService,
		ServiceWrapper<SPSellingPackageLocalService> {
	public SPSellingPackageLocalServiceWrapper(
		SPSellingPackageLocalService spSellingPackageLocalService) {
		_spSellingPackageLocalService = spSellingPackageLocalService;
	}

	/**
	* Adds the s p selling package to the database. Also notifies the appropriate model listeners.
	*
	* @param spSellingPackage the s p selling package
	* @return the s p selling package that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingPackage addSPSellingPackage(
		com.sambaash.platform.srv.spshopping.model.SPSellingPackage spSellingPackage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSellingPackageLocalService.addSPSellingPackage(spSellingPackage);
	}

	/**
	* Creates a new s p selling package with the primary key. Does not add the s p selling package to the database.
	*
	* @param spSellingPackageId the primary key for the new s p selling package
	* @return the new s p selling package
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingPackage createSPSellingPackage(
		long spSellingPackageId) {
		return _spSellingPackageLocalService.createSPSellingPackage(spSellingPackageId);
	}

	/**
	* Deletes the s p selling package with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spSellingPackageId the primary key of the s p selling package
	* @return the s p selling package that was removed
	* @throws PortalException if a s p selling package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingPackage deleteSPSellingPackage(
		long spSellingPackageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSellingPackageLocalService.deleteSPSellingPackage(spSellingPackageId);
	}

	/**
	* Deletes the s p selling package from the database. Also notifies the appropriate model listeners.
	*
	* @param spSellingPackage the s p selling package
	* @return the s p selling package that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingPackage deleteSPSellingPackage(
		com.sambaash.platform.srv.spshopping.model.SPSellingPackage spSellingPackage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSellingPackageLocalService.deleteSPSellingPackage(spSellingPackage);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spSellingPackageLocalService.dynamicQuery();
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
		return _spSellingPackageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spSellingPackageLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spSellingPackageLocalService.dynamicQuery(dynamicQuery, start,
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
		return _spSellingPackageLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spSellingPackageLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingPackage fetchSPSellingPackage(
		long spSellingPackageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSellingPackageLocalService.fetchSPSellingPackage(spSellingPackageId);
	}

	/**
	* Returns the s p selling package with the primary key.
	*
	* @param spSellingPackageId the primary key of the s p selling package
	* @return the s p selling package
	* @throws PortalException if a s p selling package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingPackage getSPSellingPackage(
		long spSellingPackageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSellingPackageLocalService.getSPSellingPackage(spSellingPackageId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSellingPackageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p selling packages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p selling packages
	* @param end the upper bound of the range of s p selling packages (not inclusive)
	* @return the range of s p selling packages
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPackage> getSPSellingPackages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSellingPackageLocalService.getSPSellingPackages(start, end);
	}

	/**
	* Returns the number of s p selling packages.
	*
	* @return the number of s p selling packages
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPSellingPackagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSellingPackageLocalService.getSPSellingPackagesCount();
	}

	/**
	* Updates the s p selling package in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spSellingPackage the s p selling package
	* @return the s p selling package that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingPackage updateSPSellingPackage(
		com.sambaash.platform.srv.spshopping.model.SPSellingPackage spSellingPackage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSellingPackageLocalService.updateSPSellingPackage(spSellingPackage);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spSellingPackageLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spSellingPackageLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spSellingPackageLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPackage> findSPSellingPackage(
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSellingPackageLocalService.findSPSellingPackage(active);
	}

	@Override
	public java.lang.Boolean hasPromoCode(long spSellingPackageId) {
		return _spSellingPackageLocalService.hasPromoCode(spSellingPackageId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPSellingPackageLocalService getWrappedSPSellingPackageLocalService() {
		return _spSellingPackageLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPSellingPackageLocalService(
		SPSellingPackageLocalService spSellingPackageLocalService) {
		_spSellingPackageLocalService = spSellingPackageLocalService;
	}

	@Override
	public SPSellingPackageLocalService getWrappedService() {
		return _spSellingPackageLocalService;
	}

	@Override
	public void setWrappedService(
		SPSellingPackageLocalService spSellingPackageLocalService) {
		_spSellingPackageLocalService = spSellingPackageLocalService;
	}

	private SPSellingPackageLocalService _spSellingPackageLocalService;
}