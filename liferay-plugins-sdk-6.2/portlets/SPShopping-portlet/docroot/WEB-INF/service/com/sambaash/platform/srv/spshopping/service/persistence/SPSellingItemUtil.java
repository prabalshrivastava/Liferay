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

import com.sambaash.platform.srv.spshopping.model.SPSellingItem;

import java.util.List;

/**
 * The persistence utility for the s p selling item service. This utility wraps {@link SPSellingItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPSellingItemPersistence
 * @see SPSellingItemPersistenceImpl
 * @generated
 */
public class SPSellingItemUtil {
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
	public static void clearCache(SPSellingItem spSellingItem) {
		getPersistence().clearCache(spSellingItem);
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
	public static List<SPSellingItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPSellingItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPSellingItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPSellingItem update(SPSellingItem spSellingItem)
		throws SystemException {
		return getPersistence().update(spSellingItem);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPSellingItem update(SPSellingItem spSellingItem,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spSellingItem, serviceContext);
	}

	/**
	* Returns all the s p selling items where active = &#63;.
	*
	* @param active the active
	* @return the matching s p selling items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingItem> findByactive(
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByactive(active);
	}

	/**
	* Returns a range of all the s p selling items where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param start the lower bound of the range of s p selling items
	* @param end the upper bound of the range of s p selling items (not inclusive)
	* @return the range of matching s p selling items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingItem> findByactive(
		boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByactive(active, start, end);
	}

	/**
	* Returns an ordered range of all the s p selling items where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param start the lower bound of the range of s p selling items
	* @param end the upper bound of the range of s p selling items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p selling items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingItem> findByactive(
		boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByactive(active, start, end, orderByComparator);
	}

	/**
	* Returns the first s p selling item in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p selling item
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException if a matching s p selling item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingItem findByactive_First(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException {
		return getPersistence().findByactive_First(active, orderByComparator);
	}

	/**
	* Returns the first s p selling item in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p selling item, or <code>null</code> if a matching s p selling item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingItem fetchByactive_First(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByactive_First(active, orderByComparator);
	}

	/**
	* Returns the last s p selling item in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p selling item
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException if a matching s p selling item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingItem findByactive_Last(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException {
		return getPersistence().findByactive_Last(active, orderByComparator);
	}

	/**
	* Returns the last s p selling item in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p selling item, or <code>null</code> if a matching s p selling item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingItem fetchByactive_Last(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByactive_Last(active, orderByComparator);
	}

	/**
	* Returns the s p selling items before and after the current s p selling item in the ordered set where active = &#63;.
	*
	* @param spSellingItemId the primary key of the current s p selling item
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p selling item
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException if a s p selling item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingItem[] findByactive_PrevAndNext(
		long spSellingItemId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException {
		return getPersistence()
				   .findByactive_PrevAndNext(spSellingItemId, active,
			orderByComparator);
	}

	/**
	* Removes all the s p selling items where active = &#63; from the database.
	*
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByactive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByactive(active);
	}

	/**
	* Returns the number of s p selling items where active = &#63;.
	*
	* @param active the active
	* @return the number of matching s p selling items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByactive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByactive(active);
	}

	/**
	* Returns the s p selling item where entityClassNameId = &#63; and entityClassPk = &#63; or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException} if it could not be found.
	*
	* @param entityClassNameId the entity class name ID
	* @param entityClassPk the entity class pk
	* @return the matching s p selling item
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException if a matching s p selling item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingItem findByEntityClassNameIdAndEntityClassPk(
		long entityClassNameId, long entityClassPk)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException {
		return getPersistence()
				   .findByEntityClassNameIdAndEntityClassPk(entityClassNameId,
			entityClassPk);
	}

	/**
	* Returns the s p selling item where entityClassNameId = &#63; and entityClassPk = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param entityClassNameId the entity class name ID
	* @param entityClassPk the entity class pk
	* @return the matching s p selling item, or <code>null</code> if a matching s p selling item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingItem fetchByEntityClassNameIdAndEntityClassPk(
		long entityClassNameId, long entityClassPk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEntityClassNameIdAndEntityClassPk(entityClassNameId,
			entityClassPk);
	}

	/**
	* Returns the s p selling item where entityClassNameId = &#63; and entityClassPk = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param entityClassNameId the entity class name ID
	* @param entityClassPk the entity class pk
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p selling item, or <code>null</code> if a matching s p selling item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingItem fetchByEntityClassNameIdAndEntityClassPk(
		long entityClassNameId, long entityClassPk, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEntityClassNameIdAndEntityClassPk(entityClassNameId,
			entityClassPk, retrieveFromCache);
	}

	/**
	* Removes the s p selling item where entityClassNameId = &#63; and entityClassPk = &#63; from the database.
	*
	* @param entityClassNameId the entity class name ID
	* @param entityClassPk the entity class pk
	* @return the s p selling item that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingItem removeByEntityClassNameIdAndEntityClassPk(
		long entityClassNameId, long entityClassPk)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException {
		return getPersistence()
				   .removeByEntityClassNameIdAndEntityClassPk(entityClassNameId,
			entityClassPk);
	}

	/**
	* Returns the number of s p selling items where entityClassNameId = &#63; and entityClassPk = &#63;.
	*
	* @param entityClassNameId the entity class name ID
	* @param entityClassPk the entity class pk
	* @return the number of matching s p selling items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEntityClassNameIdAndEntityClassPk(
		long entityClassNameId, long entityClassPk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByEntityClassNameIdAndEntityClassPk(entityClassNameId,
			entityClassPk);
	}

	/**
	* Caches the s p selling item in the entity cache if it is enabled.
	*
	* @param spSellingItem the s p selling item
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spshopping.model.SPSellingItem spSellingItem) {
		getPersistence().cacheResult(spSellingItem);
	}

	/**
	* Caches the s p selling items in the entity cache if it is enabled.
	*
	* @param spSellingItems the s p selling items
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingItem> spSellingItems) {
		getPersistence().cacheResult(spSellingItems);
	}

	/**
	* Creates a new s p selling item with the primary key. Does not add the s p selling item to the database.
	*
	* @param spSellingItemId the primary key for the new s p selling item
	* @return the new s p selling item
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingItem create(
		long spSellingItemId) {
		return getPersistence().create(spSellingItemId);
	}

	/**
	* Removes the s p selling item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spSellingItemId the primary key of the s p selling item
	* @return the s p selling item that was removed
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException if a s p selling item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingItem remove(
		long spSellingItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException {
		return getPersistence().remove(spSellingItemId);
	}

	public static com.sambaash.platform.srv.spshopping.model.SPSellingItem updateImpl(
		com.sambaash.platform.srv.spshopping.model.SPSellingItem spSellingItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spSellingItem);
	}

	/**
	* Returns the s p selling item with the primary key or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException} if it could not be found.
	*
	* @param spSellingItemId the primary key of the s p selling item
	* @return the s p selling item
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException if a s p selling item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingItem findByPrimaryKey(
		long spSellingItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException {
		return getPersistence().findByPrimaryKey(spSellingItemId);
	}

	/**
	* Returns the s p selling item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spSellingItemId the primary key of the s p selling item
	* @return the s p selling item, or <code>null</code> if a s p selling item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingItem fetchByPrimaryKey(
		long spSellingItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spSellingItemId);
	}

	/**
	* Returns all the s p selling items.
	*
	* @return the s p selling items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p selling items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p selling items
	* @param end the upper bound of the range of s p selling items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p selling items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p selling items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p selling items.
	*
	* @return the number of s p selling items
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPSellingItemPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPSellingItemPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spshopping.service.ClpSerializer.getServletContextName(),
					SPSellingItemPersistence.class.getName());

			ReferenceRegistry.registerReference(SPSellingItemUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPSellingItemPersistence persistence) {
	}

	private static SPSellingItemPersistence _persistence;
}