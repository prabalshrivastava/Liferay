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
 * Provides a wrapper for {@link SPSellingItemLocalService}.
 *
 * @author pradeep
 * @see SPSellingItemLocalService
 * @generated
 */
public class SPSellingItemLocalServiceWrapper
	implements SPSellingItemLocalService,
		ServiceWrapper<SPSellingItemLocalService> {
	public SPSellingItemLocalServiceWrapper(
		SPSellingItemLocalService spSellingItemLocalService) {
		_spSellingItemLocalService = spSellingItemLocalService;
	}

	/**
	* Adds the s p selling item to the database. Also notifies the appropriate model listeners.
	*
	* @param spSellingItem the s p selling item
	* @return the s p selling item that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingItem addSPSellingItem(
		com.sambaash.platform.srv.spshopping.model.SPSellingItem spSellingItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSellingItemLocalService.addSPSellingItem(spSellingItem);
	}

	/**
	* Creates a new s p selling item with the primary key. Does not add the s p selling item to the database.
	*
	* @param spSellingItemId the primary key for the new s p selling item
	* @return the new s p selling item
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingItem createSPSellingItem(
		long spSellingItemId) {
		return _spSellingItemLocalService.createSPSellingItem(spSellingItemId);
	}

	/**
	* Deletes the s p selling item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spSellingItemId the primary key of the s p selling item
	* @return the s p selling item that was removed
	* @throws PortalException if a s p selling item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingItem deleteSPSellingItem(
		long spSellingItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSellingItemLocalService.deleteSPSellingItem(spSellingItemId);
	}

	/**
	* Deletes the s p selling item from the database. Also notifies the appropriate model listeners.
	*
	* @param spSellingItem the s p selling item
	* @return the s p selling item that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingItem deleteSPSellingItem(
		com.sambaash.platform.srv.spshopping.model.SPSellingItem spSellingItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSellingItemLocalService.deleteSPSellingItem(spSellingItem);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spSellingItemLocalService.dynamicQuery();
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
		return _spSellingItemLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spSellingItemLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spSellingItemLocalService.dynamicQuery(dynamicQuery, start,
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
		return _spSellingItemLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spSellingItemLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingItem fetchSPSellingItem(
		long spSellingItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSellingItemLocalService.fetchSPSellingItem(spSellingItemId);
	}

	/**
	* Returns the s p selling item with the primary key.
	*
	* @param spSellingItemId the primary key of the s p selling item
	* @return the s p selling item
	* @throws PortalException if a s p selling item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingItem getSPSellingItem(
		long spSellingItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSellingItemLocalService.getSPSellingItem(spSellingItemId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSellingItemLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p selling items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p selling items
	* @param end the upper bound of the range of s p selling items (not inclusive)
	* @return the range of s p selling items
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingItem> getSPSellingItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSellingItemLocalService.getSPSellingItems(start, end);
	}

	/**
	* Returns the number of s p selling items.
	*
	* @return the number of s p selling items
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPSellingItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSellingItemLocalService.getSPSellingItemsCount();
	}

	/**
	* Updates the s p selling item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spSellingItem the s p selling item
	* @return the s p selling item that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingItem updateSPSellingItem(
		com.sambaash.platform.srv.spshopping.model.SPSellingItem spSellingItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSellingItemLocalService.updateSPSellingItem(spSellingItem);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spSellingItemLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spSellingItemLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spSellingItemLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingItem> findSPSellingItems(
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSellingItemLocalService.findSPSellingItems(active);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPSellingItemLocalService getWrappedSPSellingItemLocalService() {
		return _spSellingItemLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPSellingItemLocalService(
		SPSellingItemLocalService spSellingItemLocalService) {
		_spSellingItemLocalService = spSellingItemLocalService;
	}

	@Override
	public SPSellingItemLocalService getWrappedService() {
		return _spSellingItemLocalService;
	}

	@Override
	public void setWrappedService(
		SPSellingItemLocalService spSellingItemLocalService) {
		_spSellingItemLocalService = spSellingItemLocalService;
	}

	private SPSellingItemLocalService _spSellingItemLocalService;
}