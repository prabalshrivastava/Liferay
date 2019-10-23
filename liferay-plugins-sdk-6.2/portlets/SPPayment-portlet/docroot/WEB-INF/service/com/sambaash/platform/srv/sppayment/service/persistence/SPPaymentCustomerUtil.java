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

import com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer;

import java.util.List;

/**
 * The persistence utility for the s p payment customer service. This utility wraps {@link SPPaymentCustomerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPPaymentCustomerPersistence
 * @see SPPaymentCustomerPersistenceImpl
 * @generated
 */
public class SPPaymentCustomerUtil {
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
	public static void clearCache(SPPaymentCustomer spPaymentCustomer) {
		getPersistence().clearCache(spPaymentCustomer);
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
	public static List<SPPaymentCustomer> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPPaymentCustomer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPPaymentCustomer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPPaymentCustomer update(SPPaymentCustomer spPaymentCustomer)
		throws SystemException {
		return getPersistence().update(spPaymentCustomer);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPPaymentCustomer update(
		SPPaymentCustomer spPaymentCustomer, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(spPaymentCustomer, serviceContext);
	}

	/**
	* Returns the s p payment customer where groupId = &#63; and emailAddress = &#63; or throws a {@link com.sambaash.platform.srv.sppayment.NoSuchCustomerException} if it could not be found.
	*
	* @param groupId the group ID
	* @param emailAddress the email address
	* @return the matching s p payment customer
	* @throws com.sambaash.platform.srv.sppayment.NoSuchCustomerException if a matching s p payment customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer findByEmailAddress(
		long groupId, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sppayment.NoSuchCustomerException {
		return getPersistence().findByEmailAddress(groupId, emailAddress);
	}

	/**
	* Returns the s p payment customer where groupId = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param emailAddress the email address
	* @return the matching s p payment customer, or <code>null</code> if a matching s p payment customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer fetchByEmailAddress(
		long groupId, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmailAddress(groupId, emailAddress);
	}

	/**
	* Returns the s p payment customer where groupId = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param emailAddress the email address
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p payment customer, or <code>null</code> if a matching s p payment customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer fetchByEmailAddress(
		long groupId, java.lang.String emailAddress, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmailAddress(groupId, emailAddress, retrieveFromCache);
	}

	/**
	* Removes the s p payment customer where groupId = &#63; and emailAddress = &#63; from the database.
	*
	* @param groupId the group ID
	* @param emailAddress the email address
	* @return the s p payment customer that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer removeByEmailAddress(
		long groupId, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sppayment.NoSuchCustomerException {
		return getPersistence().removeByEmailAddress(groupId, emailAddress);
	}

	/**
	* Returns the number of s p payment customers where groupId = &#63; and emailAddress = &#63;.
	*
	* @param groupId the group ID
	* @param emailAddress the email address
	* @return the number of matching s p payment customers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmailAddress(long groupId,
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmailAddress(groupId, emailAddress);
	}

	/**
	* Caches the s p payment customer in the entity cache if it is enabled.
	*
	* @param spPaymentCustomer the s p payment customer
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer spPaymentCustomer) {
		getPersistence().cacheResult(spPaymentCustomer);
	}

	/**
	* Caches the s p payment customers in the entity cache if it is enabled.
	*
	* @param spPaymentCustomers the s p payment customers
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer> spPaymentCustomers) {
		getPersistence().cacheResult(spPaymentCustomers);
	}

	/**
	* Creates a new s p payment customer with the primary key. Does not add the s p payment customer to the database.
	*
	* @param sPPaymentCustomerId the primary key for the new s p payment customer
	* @return the new s p payment customer
	*/
	public static com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer create(
		long sPPaymentCustomerId) {
		return getPersistence().create(sPPaymentCustomerId);
	}

	/**
	* Removes the s p payment customer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sPPaymentCustomerId the primary key of the s p payment customer
	* @return the s p payment customer that was removed
	* @throws com.sambaash.platform.srv.sppayment.NoSuchCustomerException if a s p payment customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer remove(
		long sPPaymentCustomerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sppayment.NoSuchCustomerException {
		return getPersistence().remove(sPPaymentCustomerId);
	}

	public static com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer updateImpl(
		com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer spPaymentCustomer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spPaymentCustomer);
	}

	/**
	* Returns the s p payment customer with the primary key or throws a {@link com.sambaash.platform.srv.sppayment.NoSuchCustomerException} if it could not be found.
	*
	* @param sPPaymentCustomerId the primary key of the s p payment customer
	* @return the s p payment customer
	* @throws com.sambaash.platform.srv.sppayment.NoSuchCustomerException if a s p payment customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer findByPrimaryKey(
		long sPPaymentCustomerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sppayment.NoSuchCustomerException {
		return getPersistence().findByPrimaryKey(sPPaymentCustomerId);
	}

	/**
	* Returns the s p payment customer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sPPaymentCustomerId the primary key of the s p payment customer
	* @return the s p payment customer, or <code>null</code> if a s p payment customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer fetchByPrimaryKey(
		long sPPaymentCustomerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(sPPaymentCustomerId);
	}

	/**
	* Returns all the s p payment customers.
	*
	* @return the s p payment customers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p payment customers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sppayment.model.impl.SPPaymentCustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p payment customers
	* @param end the upper bound of the range of s p payment customers (not inclusive)
	* @return the range of s p payment customers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p payment customers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sppayment.model.impl.SPPaymentCustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p payment customers
	* @param end the upper bound of the range of s p payment customers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p payment customers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p payment customers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p payment customers.
	*
	* @return the number of s p payment customers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPPaymentCustomerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPPaymentCustomerPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.sppayment.service.ClpSerializer.getServletContextName(),
					SPPaymentCustomerPersistence.class.getName());

			ReferenceRegistry.registerReference(SPPaymentCustomerUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPPaymentCustomerPersistence persistence) {
	}

	private static SPPaymentCustomerPersistence _persistence;
}