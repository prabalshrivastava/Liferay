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

import com.sambaash.platform.srv.spshopping.model.SPSellingPrice;

import java.util.List;

/**
 * The persistence utility for the s p selling price service. This utility wraps {@link SPSellingPricePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPSellingPricePersistence
 * @see SPSellingPricePersistenceImpl
 * @generated
 */
public class SPSellingPriceUtil {
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
	public static void clearCache(SPSellingPrice spSellingPrice) {
		getPersistence().clearCache(spSellingPrice);
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
	public static List<SPSellingPrice> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPSellingPrice> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPSellingPrice> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPSellingPrice update(SPSellingPrice spSellingPrice)
		throws SystemException {
		return getPersistence().update(spSellingPrice);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPSellingPrice update(SPSellingPrice spSellingPrice,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spSellingPrice, serviceContext);
	}

	/**
	* Returns all the s p selling prices where priceRefId = &#63;.
	*
	* @param priceRefId the price ref ID
	* @return the matching s p selling prices
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPrice> findBysellingItemId(
		long priceRefId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBysellingItemId(priceRefId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPrice> findBysellingItemId(
		long priceRefId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBysellingItemId(priceRefId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPrice> findBysellingItemId(
		long priceRefId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysellingItemId(priceRefId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p selling price in the ordered set where priceRefId = &#63;.
	*
	* @param priceRefId the price ref ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p selling price
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException if a matching s p selling price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPrice findBysellingItemId_First(
		long priceRefId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException {
		return getPersistence()
				   .findBysellingItemId_First(priceRefId, orderByComparator);
	}

	/**
	* Returns the first s p selling price in the ordered set where priceRefId = &#63;.
	*
	* @param priceRefId the price ref ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p selling price, or <code>null</code> if a matching s p selling price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPrice fetchBysellingItemId_First(
		long priceRefId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBysellingItemId_First(priceRefId, orderByComparator);
	}

	/**
	* Returns the last s p selling price in the ordered set where priceRefId = &#63;.
	*
	* @param priceRefId the price ref ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p selling price
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException if a matching s p selling price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPrice findBysellingItemId_Last(
		long priceRefId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException {
		return getPersistence()
				   .findBysellingItemId_Last(priceRefId, orderByComparator);
	}

	/**
	* Returns the last s p selling price in the ordered set where priceRefId = &#63;.
	*
	* @param priceRefId the price ref ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p selling price, or <code>null</code> if a matching s p selling price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPrice fetchBysellingItemId_Last(
		long priceRefId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBysellingItemId_Last(priceRefId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPrice[] findBysellingItemId_PrevAndNext(
		long spSellingPriceId, long priceRefId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException {
		return getPersistence()
				   .findBysellingItemId_PrevAndNext(spSellingPriceId,
			priceRefId, orderByComparator);
	}

	/**
	* Removes all the s p selling prices where priceRefId = &#63; from the database.
	*
	* @param priceRefId the price ref ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBysellingItemId(long priceRefId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBysellingItemId(priceRefId);
	}

	/**
	* Returns the number of s p selling prices where priceRefId = &#63;.
	*
	* @param priceRefId the price ref ID
	* @return the number of matching s p selling prices
	* @throws SystemException if a system exception occurred
	*/
	public static int countBysellingItemId(long priceRefId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBysellingItemId(priceRefId);
	}

	/**
	* Returns the s p selling price where priceRefId = &#63; or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException} if it could not be found.
	*
	* @param priceRefId the price ref ID
	* @return the matching s p selling price
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException if a matching s p selling price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPrice findBysellingPackageId(
		long priceRefId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException {
		return getPersistence().findBysellingPackageId(priceRefId);
	}

	/**
	* Returns the s p selling price where priceRefId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param priceRefId the price ref ID
	* @return the matching s p selling price, or <code>null</code> if a matching s p selling price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPrice fetchBysellingPackageId(
		long priceRefId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBysellingPackageId(priceRefId);
	}

	/**
	* Returns the s p selling price where priceRefId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param priceRefId the price ref ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p selling price, or <code>null</code> if a matching s p selling price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPrice fetchBysellingPackageId(
		long priceRefId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBysellingPackageId(priceRefId, retrieveFromCache);
	}

	/**
	* Removes the s p selling price where priceRefId = &#63; from the database.
	*
	* @param priceRefId the price ref ID
	* @return the s p selling price that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPrice removeBysellingPackageId(
		long priceRefId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException {
		return getPersistence().removeBysellingPackageId(priceRefId);
	}

	/**
	* Returns the number of s p selling prices where priceRefId = &#63;.
	*
	* @param priceRefId the price ref ID
	* @return the number of matching s p selling prices
	* @throws SystemException if a system exception occurred
	*/
	public static int countBysellingPackageId(long priceRefId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBysellingPackageId(priceRefId);
	}

	/**
	* Caches the s p selling price in the entity cache if it is enabled.
	*
	* @param spSellingPrice the s p selling price
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spshopping.model.SPSellingPrice spSellingPrice) {
		getPersistence().cacheResult(spSellingPrice);
	}

	/**
	* Caches the s p selling prices in the entity cache if it is enabled.
	*
	* @param spSellingPrices the s p selling prices
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPrice> spSellingPrices) {
		getPersistence().cacheResult(spSellingPrices);
	}

	/**
	* Creates a new s p selling price with the primary key. Does not add the s p selling price to the database.
	*
	* @param spSellingPriceId the primary key for the new s p selling price
	* @return the new s p selling price
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPrice create(
		long spSellingPriceId) {
		return getPersistence().create(spSellingPriceId);
	}

	/**
	* Removes the s p selling price with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spSellingPriceId the primary key of the s p selling price
	* @return the s p selling price that was removed
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException if a s p selling price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPrice remove(
		long spSellingPriceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException {
		return getPersistence().remove(spSellingPriceId);
	}

	public static com.sambaash.platform.srv.spshopping.model.SPSellingPrice updateImpl(
		com.sambaash.platform.srv.spshopping.model.SPSellingPrice spSellingPrice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spSellingPrice);
	}

	/**
	* Returns the s p selling price with the primary key or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException} if it could not be found.
	*
	* @param spSellingPriceId the primary key of the s p selling price
	* @return the s p selling price
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException if a s p selling price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPrice findByPrimaryKey(
		long spSellingPriceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException {
		return getPersistence().findByPrimaryKey(spSellingPriceId);
	}

	/**
	* Returns the s p selling price with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spSellingPriceId the primary key of the s p selling price
	* @return the s p selling price, or <code>null</code> if a s p selling price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPSellingPrice fetchByPrimaryKey(
		long spSellingPriceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spSellingPriceId);
	}

	/**
	* Returns all the s p selling prices.
	*
	* @return the s p selling prices
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPrice> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPrice> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPrice> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p selling prices from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p selling prices.
	*
	* @return the number of s p selling prices
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPSellingPricePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPSellingPricePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spshopping.service.ClpSerializer.getServletContextName(),
					SPSellingPricePersistence.class.getName());

			ReferenceRegistry.registerReference(SPSellingPriceUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPSellingPricePersistence persistence) {
	}

	private static SPSellingPricePersistence _persistence;
}