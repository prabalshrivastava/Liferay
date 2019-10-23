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

import com.sambaash.platform.srv.spshopping.model.SPSellingPrice;

/**
 * The persistence interface for the s p selling price service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPSellingPricePersistenceImpl
 * @see SPSellingPriceUtil
 * @generated
 */
public interface SPSellingPricePersistence extends BasePersistence<SPSellingPrice> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPSellingPriceUtil} to access the s p selling price persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p selling prices where priceRefId = &#63;.
	*
	* @param priceRefId the price ref ID
	* @return the matching s p selling prices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPrice> findBysellingItemId(
		long priceRefId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p selling prices where priceRefId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param priceRefId the price ref ID
	* @param start the lower bound of the range of s p selling prices
	* @param end the upper bound of the range of s p selling prices (not inclusive)
	* @return the range of matching s p selling prices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPrice> findBysellingItemId(
		long priceRefId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p selling prices where priceRefId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param priceRefId the price ref ID
	* @param start the lower bound of the range of s p selling prices
	* @param end the upper bound of the range of s p selling prices (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p selling prices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPrice> findBysellingItemId(
		long priceRefId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p selling price in the ordered set where priceRefId = &#63;.
	*
	* @param priceRefId the price ref ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p selling price
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException if a matching s p selling price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice findBysellingItemId_First(
		long priceRefId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException;

	/**
	* Returns the first s p selling price in the ordered set where priceRefId = &#63;.
	*
	* @param priceRefId the price ref ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p selling price, or <code>null</code> if a matching s p selling price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice fetchBysellingItemId_First(
		long priceRefId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p selling price in the ordered set where priceRefId = &#63;.
	*
	* @param priceRefId the price ref ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p selling price
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException if a matching s p selling price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice findBysellingItemId_Last(
		long priceRefId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException;

	/**
	* Returns the last s p selling price in the ordered set where priceRefId = &#63;.
	*
	* @param priceRefId the price ref ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p selling price, or <code>null</code> if a matching s p selling price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice fetchBysellingItemId_Last(
		long priceRefId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p selling prices before and after the current s p selling price in the ordered set where priceRefId = &#63;.
	*
	* @param spSellingPriceId the primary key of the current s p selling price
	* @param priceRefId the price ref ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p selling price
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException if a s p selling price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice[] findBysellingItemId_PrevAndNext(
		long spSellingPriceId, long priceRefId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException;

	/**
	* Removes all the s p selling prices where priceRefId = &#63; from the database.
	*
	* @param priceRefId the price ref ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBysellingItemId(long priceRefId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p selling prices where priceRefId = &#63;.
	*
	* @param priceRefId the price ref ID
	* @return the number of matching s p selling prices
	* @throws SystemException if a system exception occurred
	*/
	public int countBysellingItemId(long priceRefId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p selling price where priceRefId = &#63; or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException} if it could not be found.
	*
	* @param priceRefId the price ref ID
	* @return the matching s p selling price
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException if a matching s p selling price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice findBysellingPackageId(
		long priceRefId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException;

	/**
	* Returns the s p selling price where priceRefId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param priceRefId the price ref ID
	* @return the matching s p selling price, or <code>null</code> if a matching s p selling price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice fetchBysellingPackageId(
		long priceRefId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p selling price where priceRefId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param priceRefId the price ref ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p selling price, or <code>null</code> if a matching s p selling price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice fetchBysellingPackageId(
		long priceRefId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p selling price where priceRefId = &#63; from the database.
	*
	* @param priceRefId the price ref ID
	* @return the s p selling price that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice removeBysellingPackageId(
		long priceRefId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException;

	/**
	* Returns the number of s p selling prices where priceRefId = &#63;.
	*
	* @param priceRefId the price ref ID
	* @return the number of matching s p selling prices
	* @throws SystemException if a system exception occurred
	*/
	public int countBysellingPackageId(long priceRefId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p selling price in the entity cache if it is enabled.
	*
	* @param spSellingPrice the s p selling price
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spshopping.model.SPSellingPrice spSellingPrice);

	/**
	* Caches the s p selling prices in the entity cache if it is enabled.
	*
	* @param spSellingPrices the s p selling prices
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPrice> spSellingPrices);

	/**
	* Creates a new s p selling price with the primary key. Does not add the s p selling price to the database.
	*
	* @param spSellingPriceId the primary key for the new s p selling price
	* @return the new s p selling price
	*/
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice create(
		long spSellingPriceId);

	/**
	* Removes the s p selling price with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spSellingPriceId the primary key of the s p selling price
	* @return the s p selling price that was removed
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException if a s p selling price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice remove(
		long spSellingPriceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException;

	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice updateImpl(
		com.sambaash.platform.srv.spshopping.model.SPSellingPrice spSellingPrice)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p selling price with the primary key or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException} if it could not be found.
	*
	* @param spSellingPriceId the primary key of the s p selling price
	* @return the s p selling price
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException if a s p selling price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice findByPrimaryKey(
		long spSellingPriceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException;

	/**
	* Returns the s p selling price with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spSellingPriceId the primary key of the s p selling price
	* @return the s p selling price, or <code>null</code> if a s p selling price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice fetchByPrimaryKey(
		long spSellingPriceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p selling prices.
	*
	* @return the s p selling prices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPrice> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p selling prices.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p selling prices
	* @param end the upper bound of the range of s p selling prices (not inclusive)
	* @return the range of s p selling prices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPrice> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p selling prices.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p selling prices
	* @param end the upper bound of the range of s p selling prices (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p selling prices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPrice> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p selling prices from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p selling prices.
	*
	* @return the number of s p selling prices
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}