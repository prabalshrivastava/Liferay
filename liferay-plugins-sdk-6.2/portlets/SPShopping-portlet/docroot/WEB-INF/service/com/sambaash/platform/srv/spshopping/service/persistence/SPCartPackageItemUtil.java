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

package com.sambaash.platform.srv.spshopping.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.spshopping.model.SPCartPackageItem;

import java.util.List;

/**
 * The persistence utility for the s p cart package item service. This utility wraps {@link SPCartPackageItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPCartPackageItemPersistence
 * @see SPCartPackageItemPersistenceImpl
 * @generated
 */
public class SPCartPackageItemUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(SPCartPackageItem spCartPackageItem) {
		getPersistence().clearCache(spCartPackageItem);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SPCartPackageItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPCartPackageItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPCartPackageItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPCartPackageItem update(SPCartPackageItem spCartPackageItem)
		throws SystemException {
		return getPersistence().update(spCartPackageItem);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPCartPackageItem update(
		SPCartPackageItem spCartPackageItem, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(spCartPackageItem, serviceContext);
	}

	/**
	* Returns all the s p cart package items where spCartPackageId = &#63;.
	*
	* @param spCartPackageId the sp cart package ID
	* @return the matching s p cart package items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPCartPackageItem> findBySPCartPackageId(
		long spCartPackageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySPCartPackageId(spCartPackageId);
	}

	/**
	* Returns a range of all the s p cart package items where spCartPackageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCartPackageId the sp cart package ID
	* @param start the lower bound of the range of s p cart package items
	* @param end the upper bound of the range of s p cart package items (not inclusive)
	* @return the range of matching s p cart package items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPCartPackageItem> findBySPCartPackageId(
		long spCartPackageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySPCartPackageId(spCartPackageId, start, end);
	}

	/**
	* Returns an ordered range of all the s p cart package items where spCartPackageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCartPackageId the sp cart package ID
	* @param start the lower bound of the range of s p cart package items
	* @param end the upper bound of the range of s p cart package items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p cart package items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPCartPackageItem> findBySPCartPackageId(
		long spCartPackageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySPCartPackageId(spCartPackageId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p cart package item in the ordered set where spCartPackageId = &#63;.
	*
	* @param spCartPackageId the sp cart package ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p cart package item
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageItemException if a matching s p cart package item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPCartPackageItem findBySPCartPackageId_First(
		long spCartPackageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageItemException {
		return getPersistence()
				   .findBySPCartPackageId_First(spCartPackageId,
			orderByComparator);
	}

	/**
	* Returns the first s p cart package item in the ordered set where spCartPackageId = &#63;.
	*
	* @param spCartPackageId the sp cart package ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p cart package item, or <code>null</code> if a matching s p cart package item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPCartPackageItem fetchBySPCartPackageId_First(
		long spCartPackageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySPCartPackageId_First(spCartPackageId,
			orderByComparator);
	}

	/**
	* Returns the last s p cart package item in the ordered set where spCartPackageId = &#63;.
	*
	* @param spCartPackageId the sp cart package ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p cart package item
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageItemException if a matching s p cart package item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPCartPackageItem findBySPCartPackageId_Last(
		long spCartPackageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageItemException {
		return getPersistence()
				   .findBySPCartPackageId_Last(spCartPackageId,
			orderByComparator);
	}

	/**
	* Returns the last s p cart package item in the ordered set where spCartPackageId = &#63;.
	*
	* @param spCartPackageId the sp cart package ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p cart package item, or <code>null</code> if a matching s p cart package item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPCartPackageItem fetchBySPCartPackageId_Last(
		long spCartPackageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySPCartPackageId_Last(spCartPackageId,
			orderByComparator);
	}

	/**
	* Returns the s p cart package items before and after the current s p cart package item in the ordered set where spCartPackageId = &#63;.
	*
	* @param spCartPackageItemId the primary key of the current s p cart package item
	* @param spCartPackageId the sp cart package ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p cart package item
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageItemException if a s p cart package item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPCartPackageItem[] findBySPCartPackageId_PrevAndNext(
		long spCartPackageItemId, long spCartPackageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageItemException {
		return getPersistence()
				   .findBySPCartPackageId_PrevAndNext(spCartPackageItemId,
			spCartPackageId, orderByComparator);
	}

	/**
	* Removes all the s p cart package items where spCartPackageId = &#63; from the database.
	*
	* @param spCartPackageId the sp cart package ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySPCartPackageId(long spCartPackageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySPCartPackageId(spCartPackageId);
	}

	/**
	* Returns the number of s p cart package items where spCartPackageId = &#63;.
	*
	* @param spCartPackageId the sp cart package ID
	* @return the number of matching s p cart package items
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySPCartPackageId(long spCartPackageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySPCartPackageId(spCartPackageId);
	}

	/**
	* Caches the s p cart package item in the entity cache if it is enabled.
	*
	* @param spCartPackageItem the s p cart package item
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spshopping.model.SPCartPackageItem spCartPackageItem) {
		getPersistence().cacheResult(spCartPackageItem);
	}

	/**
	* Caches the s p cart package items in the entity cache if it is enabled.
	*
	* @param spCartPackageItems the s p cart package items
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spshopping.model.SPCartPackageItem> spCartPackageItems) {
		getPersistence().cacheResult(spCartPackageItems);
	}

	/**
	* Creates a new s p cart package item with the primary key. Does not add the s p cart package item to the database.
	*
	* @param spCartPackageItemId the primary key for the new s p cart package item
	* @return the new s p cart package item
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPCartPackageItem create(
		long spCartPackageItemId) {
		return getPersistence().create(spCartPackageItemId);
	}

	/**
	* Removes the s p cart package item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spCartPackageItemId the primary key of the s p cart package item
	* @return the s p cart package item that was removed
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageItemException if a s p cart package item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPCartPackageItem remove(
		long spCartPackageItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageItemException {
		return getPersistence().remove(spCartPackageItemId);
	}

	public static com.sambaash.platform.srv.spshopping.model.SPCartPackageItem updateImpl(
		com.sambaash.platform.srv.spshopping.model.SPCartPackageItem spCartPackageItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spCartPackageItem);
	}

	/**
	* Returns the s p cart package item with the primary key or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageItemException} if it could not be found.
	*
	* @param spCartPackageItemId the primary key of the s p cart package item
	* @return the s p cart package item
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageItemException if a s p cart package item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPCartPackageItem findByPrimaryKey(
		long spCartPackageItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageItemException {
		return getPersistence().findByPrimaryKey(spCartPackageItemId);
	}

	/**
	* Returns the s p cart package item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spCartPackageItemId the primary key of the s p cart package item
	* @return the s p cart package item, or <code>null</code> if a s p cart package item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPCartPackageItem fetchByPrimaryKey(
		long spCartPackageItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spCartPackageItemId);
	}

	/**
	* Returns all the s p cart package items.
	*
	* @return the s p cart package items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPCartPackageItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p cart package items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p cart package items
	* @param end the upper bound of the range of s p cart package items (not inclusive)
	* @return the range of s p cart package items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPCartPackageItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p cart package items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p cart package items
	* @param end the upper bound of the range of s p cart package items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p cart package items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPCartPackageItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p cart package items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p cart package items.
	*
	* @return the number of s p cart package items
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPCartPackageItemPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPCartPackageItemPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spshopping.service.ClpSerializer.getServletContextName(),
					SPCartPackageItemPersistence.class.getName());

			ReferenceRegistry.registerReference(SPCartPackageItemUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPCartPackageItemPersistence persistence) {
	}

	private static SPCartPackageItemPersistence _persistence;
}