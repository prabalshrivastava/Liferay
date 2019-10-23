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

import com.sambaash.platform.srv.spshopping.model.SPTax;

import java.util.List;

/**
 * The persistence utility for the s p tax service. This utility wraps {@link SPTaxPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPTaxPersistence
 * @see SPTaxPersistenceImpl
 * @generated
 */
public class SPTaxUtil {
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
	public static void clearCache(SPTax spTax) {
		getPersistence().clearCache(spTax);
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
	public static List<SPTax> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPTax> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPTax> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPTax update(SPTax spTax) throws SystemException {
		return getPersistence().update(spTax);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPTax update(SPTax spTax, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(spTax, serviceContext);
	}

	/**
	* Returns the s p tax where currencyCode = &#63; or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPTaxException} if it could not be found.
	*
	* @param currencyCode the currency code
	* @return the matching s p tax
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPTaxException if a matching s p tax could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPTax findBycurrencyCode(
		java.lang.String currencyCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPTaxException {
		return getPersistence().findBycurrencyCode(currencyCode);
	}

	/**
	* Returns the s p tax where currencyCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param currencyCode the currency code
	* @return the matching s p tax, or <code>null</code> if a matching s p tax could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPTax fetchBycurrencyCode(
		java.lang.String currencyCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBycurrencyCode(currencyCode);
	}

	/**
	* Returns the s p tax where currencyCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param currencyCode the currency code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p tax, or <code>null</code> if a matching s p tax could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPTax fetchBycurrencyCode(
		java.lang.String currencyCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycurrencyCode(currencyCode, retrieveFromCache);
	}

	/**
	* Removes the s p tax where currencyCode = &#63; from the database.
	*
	* @param currencyCode the currency code
	* @return the s p tax that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPTax removeBycurrencyCode(
		java.lang.String currencyCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPTaxException {
		return getPersistence().removeBycurrencyCode(currencyCode);
	}

	/**
	* Returns the number of s p taxs where currencyCode = &#63;.
	*
	* @param currencyCode the currency code
	* @return the number of matching s p taxs
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycurrencyCode(java.lang.String currencyCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBycurrencyCode(currencyCode);
	}

	/**
	* Caches the s p tax in the entity cache if it is enabled.
	*
	* @param spTax the s p tax
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spshopping.model.SPTax spTax) {
		getPersistence().cacheResult(spTax);
	}

	/**
	* Caches the s p taxs in the entity cache if it is enabled.
	*
	* @param spTaxs the s p taxs
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spshopping.model.SPTax> spTaxs) {
		getPersistence().cacheResult(spTaxs);
	}

	/**
	* Creates a new s p tax with the primary key. Does not add the s p tax to the database.
	*
	* @param spTaxId the primary key for the new s p tax
	* @return the new s p tax
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPTax create(
		long spTaxId) {
		return getPersistence().create(spTaxId);
	}

	/**
	* Removes the s p tax with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spTaxId the primary key of the s p tax
	* @return the s p tax that was removed
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPTaxException if a s p tax with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPTax remove(
		long spTaxId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPTaxException {
		return getPersistence().remove(spTaxId);
	}

	public static com.sambaash.platform.srv.spshopping.model.SPTax updateImpl(
		com.sambaash.platform.srv.spshopping.model.SPTax spTax)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spTax);
	}

	/**
	* Returns the s p tax with the primary key or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPTaxException} if it could not be found.
	*
	* @param spTaxId the primary key of the s p tax
	* @return the s p tax
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPTaxException if a s p tax with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPTax findByPrimaryKey(
		long spTaxId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPTaxException {
		return getPersistence().findByPrimaryKey(spTaxId);
	}

	/**
	* Returns the s p tax with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spTaxId the primary key of the s p tax
	* @return the s p tax, or <code>null</code> if a s p tax with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spshopping.model.SPTax fetchByPrimaryKey(
		long spTaxId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spTaxId);
	}

	/**
	* Returns all the s p taxs.
	*
	* @return the s p taxs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPTax> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p taxs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPTaxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p taxs
	* @param end the upper bound of the range of s p taxs (not inclusive)
	* @return the range of s p taxs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPTax> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p taxs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPTaxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p taxs
	* @param end the upper bound of the range of s p taxs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p taxs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spshopping.model.SPTax> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p taxs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p taxs.
	*
	* @return the number of s p taxs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPTaxPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPTaxPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spshopping.service.ClpSerializer.getServletContextName(),
					SPTaxPersistence.class.getName());

			ReferenceRegistry.registerReference(SPTaxUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPTaxPersistence persistence) {
	}

	private static SPTaxPersistence _persistence;
}