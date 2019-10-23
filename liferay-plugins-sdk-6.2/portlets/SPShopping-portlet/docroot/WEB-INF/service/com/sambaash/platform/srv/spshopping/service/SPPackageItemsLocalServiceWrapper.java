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
 * Provides a wrapper for {@link SPPackageItemsLocalService}.
 *
 * @author pradeep
 * @see SPPackageItemsLocalService
 * @generated
 */
public class SPPackageItemsLocalServiceWrapper
	implements SPPackageItemsLocalService,
		ServiceWrapper<SPPackageItemsLocalService> {
	public SPPackageItemsLocalServiceWrapper(
		SPPackageItemsLocalService spPackageItemsLocalService) {
		_spPackageItemsLocalService = spPackageItemsLocalService;
	}

	/**
	* Adds the s p package items to the database. Also notifies the appropriate model listeners.
	*
	* @param spPackageItems the s p package items
	* @return the s p package items that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPPackageItems addSPPackageItems(
		com.sambaash.platform.srv.spshopping.model.SPPackageItems spPackageItems)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spPackageItemsLocalService.addSPPackageItems(spPackageItems);
	}

	/**
	* Creates a new s p package items with the primary key. Does not add the s p package items to the database.
	*
	* @param spPackageItemsId the primary key for the new s p package items
	* @return the new s p package items
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPPackageItems createSPPackageItems(
		long spPackageItemsId) {
		return _spPackageItemsLocalService.createSPPackageItems(spPackageItemsId);
	}

	/**
	* Deletes the s p package items with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPackageItemsId the primary key of the s p package items
	* @return the s p package items that was removed
	* @throws PortalException if a s p package items with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPPackageItems deleteSPPackageItems(
		long spPackageItemsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spPackageItemsLocalService.deleteSPPackageItems(spPackageItemsId);
	}

	/**
	* Deletes the s p package items from the database. Also notifies the appropriate model listeners.
	*
	* @param spPackageItems the s p package items
	* @return the s p package items that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPPackageItems deleteSPPackageItems(
		com.sambaash.platform.srv.spshopping.model.SPPackageItems spPackageItems)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spPackageItemsLocalService.deleteSPPackageItems(spPackageItems);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spPackageItemsLocalService.dynamicQuery();
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
		return _spPackageItemsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPPackageItemsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spPackageItemsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPPackageItemsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spPackageItemsLocalService.dynamicQuery(dynamicQuery, start,
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
		return _spPackageItemsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spPackageItemsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPPackageItems fetchSPPackageItems(
		long spPackageItemsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spPackageItemsLocalService.fetchSPPackageItems(spPackageItemsId);
	}

	/**
	* Returns the s p package items with the primary key.
	*
	* @param spPackageItemsId the primary key of the s p package items
	* @return the s p package items
	* @throws PortalException if a s p package items with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPPackageItems getSPPackageItems(
		long spPackageItemsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spPackageItemsLocalService.getSPPackageItems(spPackageItemsId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spPackageItemsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p package itemses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPPackageItemsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p package itemses
	* @param end the upper bound of the range of s p package itemses (not inclusive)
	* @return the range of s p package itemses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPPackageItems> getSPPackageItemses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spPackageItemsLocalService.getSPPackageItemses(start, end);
	}

	/**
	* Returns the number of s p package itemses.
	*
	* @return the number of s p package itemses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPPackageItemsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spPackageItemsLocalService.getSPPackageItemsesCount();
	}

	/**
	* Updates the s p package items in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spPackageItems the s p package items
	* @return the s p package items that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPPackageItems updateSPPackageItems(
		com.sambaash.platform.srv.spshopping.model.SPPackageItems spPackageItems)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spPackageItemsLocalService.updateSPPackageItems(spPackageItems);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spPackageItemsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spPackageItemsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spPackageItemsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPPackageItems> findByPackageId(
		long packageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spPackageItemsLocalService.findByPackageId(packageId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPPackageItemsLocalService getWrappedSPPackageItemsLocalService() {
		return _spPackageItemsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPPackageItemsLocalService(
		SPPackageItemsLocalService spPackageItemsLocalService) {
		_spPackageItemsLocalService = spPackageItemsLocalService;
	}

	@Override
	public SPPackageItemsLocalService getWrappedService() {
		return _spPackageItemsLocalService;
	}

	@Override
	public void setWrappedService(
		SPPackageItemsLocalService spPackageItemsLocalService) {
		_spPackageItemsLocalService = spPackageItemsLocalService;
	}

	private SPPackageItemsLocalService _spPackageItemsLocalService;
}