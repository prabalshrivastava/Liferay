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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.spshopping.model.SPPackageItems;

/**
 * The persistence interface for the s p package items service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPPackageItemsPersistenceImpl
 * @see SPPackageItemsUtil
 * @generated
 */
public interface SPPackageItemsPersistence extends BasePersistence<SPPackageItems> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPPackageItemsUtil} to access the s p package items persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p package itemses where packageId = &#63;.
	*
	* @param packageId the package ID
	* @return the matching s p package itemses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPPackageItems> findBypackageId(
		long packageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p package itemses where packageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPPackageItemsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param packageId the package ID
	* @param start the lower bound of the range of s p package itemses
	* @param end the upper bound of the range of s p package itemses (not inclusive)
	* @return the range of matching s p package itemses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPPackageItems> findBypackageId(
		long packageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p package itemses where packageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPPackageItemsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param packageId the package ID
	* @param start the lower bound of the range of s p package itemses
	* @param end the upper bound of the range of s p package itemses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p package itemses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPPackageItems> findBypackageId(
		long packageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p package items in the ordered set where packageId = &#63;.
	*
	* @param packageId the package ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p package items
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException if a matching s p package items could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPPackageItems findBypackageId_First(
		long packageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException;

	/**
	* Returns the first s p package items in the ordered set where packageId = &#63;.
	*
	* @param packageId the package ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p package items, or <code>null</code> if a matching s p package items could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPPackageItems fetchBypackageId_First(
		long packageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p package items in the ordered set where packageId = &#63;.
	*
	* @param packageId the package ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p package items
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException if a matching s p package items could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPPackageItems findBypackageId_Last(
		long packageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException;

	/**
	* Returns the last s p package items in the ordered set where packageId = &#63;.
	*
	* @param packageId the package ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p package items, or <code>null</code> if a matching s p package items could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPPackageItems fetchBypackageId_Last(
		long packageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p package itemses before and after the current s p package items in the ordered set where packageId = &#63;.
	*
	* @param spPackageItemsId the primary key of the current s p package items
	* @param packageId the package ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p package items
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException if a s p package items with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPPackageItems[] findBypackageId_PrevAndNext(
		long spPackageItemsId, long packageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException;

	/**
	* Removes all the s p package itemses where packageId = &#63; from the database.
	*
	* @param packageId the package ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBypackageId(long packageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p package itemses where packageId = &#63;.
	*
	* @param packageId the package ID
	* @return the number of matching s p package itemses
	* @throws SystemException if a system exception occurred
	*/
	public int countBypackageId(long packageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p package itemses where itemId = &#63;.
	*
	* @param itemId the item ID
	* @return the matching s p package itemses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPPackageItems> findByItemId(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p package itemses where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPPackageItemsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemId the item ID
	* @param start the lower bound of the range of s p package itemses
	* @param end the upper bound of the range of s p package itemses (not inclusive)
	* @return the range of matching s p package itemses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPPackageItems> findByItemId(
		long itemId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p package itemses where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPPackageItemsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemId the item ID
	* @param start the lower bound of the range of s p package itemses
	* @param end the upper bound of the range of s p package itemses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p package itemses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPPackageItems> findByItemId(
		long itemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p package items in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p package items
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException if a matching s p package items could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPPackageItems findByItemId_First(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException;

	/**
	* Returns the first s p package items in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p package items, or <code>null</code> if a matching s p package items could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPPackageItems fetchByItemId_First(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p package items in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p package items
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException if a matching s p package items could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPPackageItems findByItemId_Last(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException;

	/**
	* Returns the last s p package items in the ordered set where itemId = &#63;.
	*
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p package items, or <code>null</code> if a matching s p package items could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPPackageItems fetchByItemId_Last(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p package itemses before and after the current s p package items in the ordered set where itemId = &#63;.
	*
	* @param spPackageItemsId the primary key of the current s p package items
	* @param itemId the item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p package items
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException if a s p package items with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPPackageItems[] findByItemId_PrevAndNext(
		long spPackageItemsId, long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException;

	/**
	* Removes all the s p package itemses where itemId = &#63; from the database.
	*
	* @param itemId the item ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByItemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p package itemses where itemId = &#63;.
	*
	* @param itemId the item ID
	* @return the number of matching s p package itemses
	* @throws SystemException if a system exception occurred
	*/
	public int countByItemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p package items in the entity cache if it is enabled.
	*
	* @param spPackageItems the s p package items
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spshopping.model.SPPackageItems spPackageItems);

	/**
	* Caches the s p package itemses in the entity cache if it is enabled.
	*
	* @param spPackageItemses the s p package itemses
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spshopping.model.SPPackageItems> spPackageItemses);

	/**
	* Creates a new s p package items with the primary key. Does not add the s p package items to the database.
	*
	* @param spPackageItemsId the primary key for the new s p package items
	* @return the new s p package items
	*/
	public com.sambaash.platform.srv.spshopping.model.SPPackageItems create(
		long spPackageItemsId);

	/**
	* Removes the s p package items with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPackageItemsId the primary key of the s p package items
	* @return the s p package items that was removed
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException if a s p package items with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPPackageItems remove(
		long spPackageItemsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException;

	public com.sambaash.platform.srv.spshopping.model.SPPackageItems updateImpl(
		com.sambaash.platform.srv.spshopping.model.SPPackageItems spPackageItems)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p package items with the primary key or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException} if it could not be found.
	*
	* @param spPackageItemsId the primary key of the s p package items
	* @return the s p package items
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException if a s p package items with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPPackageItems findByPrimaryKey(
		long spPackageItemsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException;

	/**
	* Returns the s p package items with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spPackageItemsId the primary key of the s p package items
	* @return the s p package items, or <code>null</code> if a s p package items with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPPackageItems fetchByPrimaryKey(
		long spPackageItemsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p package itemses.
	*
	* @return the s p package itemses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPPackageItems> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPPackageItems> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p package itemses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPPackageItemsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p package itemses
	* @param end the upper bound of the range of s p package itemses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p package itemses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPPackageItems> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p package itemses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p package itemses.
	*
	* @return the number of s p package itemses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}