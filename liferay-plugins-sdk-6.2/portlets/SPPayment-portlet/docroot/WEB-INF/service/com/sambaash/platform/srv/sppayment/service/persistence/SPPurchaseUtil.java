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

package com.sambaash.platform.srv.sppayment.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.sppayment.model.SPPurchase;

import java.util.List;

/**
 * The persistence utility for the s p purchase service. This utility wraps {@link SPPurchasePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPPurchasePersistence
 * @see SPPurchasePersistenceImpl
 * @generated
 */
public class SPPurchaseUtil {
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
	public static void clearCache(SPPurchase spPurchase) {
		getPersistence().clearCache(spPurchase);
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
	public static List<SPPurchase> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPPurchase> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPPurchase> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPPurchase update(SPPurchase spPurchase)
		throws SystemException {
		return getPersistence().update(spPurchase);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPPurchase update(SPPurchase spPurchase,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spPurchase, serviceContext);
	}

	/**
	* Caches the s p purchase in the entity cache if it is enabled.
	*
	* @param spPurchase the s p purchase
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.sppayment.model.SPPurchase spPurchase) {
		getPersistence().cacheResult(spPurchase);
	}

	/**
	* Caches the s p purchases in the entity cache if it is enabled.
	*
	* @param spPurchases the s p purchases
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.sppayment.model.SPPurchase> spPurchases) {
		getPersistence().cacheResult(spPurchases);
	}

	/**
	* Creates a new s p purchase with the primary key. Does not add the s p purchase to the database.
	*
	* @param spPurchaseId the primary key for the new s p purchase
	* @return the new s p purchase
	*/
	public static com.sambaash.platform.srv.sppayment.model.SPPurchase create(
		long spPurchaseId) {
		return getPersistence().create(spPurchaseId);
	}

	/**
	* Removes the s p purchase with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPurchaseId the primary key of the s p purchase
	* @return the s p purchase that was removed
	* @throws com.sambaash.platform.srv.sppayment.NoSuchSPPurchaseException if a s p purchase with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sppayment.model.SPPurchase remove(
		long spPurchaseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sppayment.NoSuchSPPurchaseException {
		return getPersistence().remove(spPurchaseId);
	}

	public static com.sambaash.platform.srv.sppayment.model.SPPurchase updateImpl(
		com.sambaash.platform.srv.sppayment.model.SPPurchase spPurchase)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spPurchase);
	}

	/**
	* Returns the s p purchase with the primary key or throws a {@link com.sambaash.platform.srv.sppayment.NoSuchSPPurchaseException} if it could not be found.
	*
	* @param spPurchaseId the primary key of the s p purchase
	* @return the s p purchase
	* @throws com.sambaash.platform.srv.sppayment.NoSuchSPPurchaseException if a s p purchase with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sppayment.model.SPPurchase findByPrimaryKey(
		long spPurchaseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sppayment.NoSuchSPPurchaseException {
		return getPersistence().findByPrimaryKey(spPurchaseId);
	}

	/**
	* Returns the s p purchase with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spPurchaseId the primary key of the s p purchase
	* @return the s p purchase, or <code>null</code> if a s p purchase with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sppayment.model.SPPurchase fetchByPrimaryKey(
		long spPurchaseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spPurchaseId);
	}

	/**
	* Returns all the s p purchases.
	*
	* @return the s p purchases
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sppayment.model.SPPurchase> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p purchases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sppayment.model.impl.SPPurchaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p purchases
	* @param end the upper bound of the range of s p purchases (not inclusive)
	* @return the range of s p purchases
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sppayment.model.SPPurchase> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p purchases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sppayment.model.impl.SPPurchaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p purchases
	* @param end the upper bound of the range of s p purchases (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p purchases
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sppayment.model.SPPurchase> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p purchases from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p purchases.
	*
	* @return the number of s p purchases
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPPurchasePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPPurchasePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.sppayment.service.ClpSerializer.getServletContextName(),
					SPPurchasePersistence.class.getName());

			ReferenceRegistry.registerReference(SPPurchaseUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPPurchasePersistence persistence) {
	}

	private static SPPurchasePersistence _persistence;
}