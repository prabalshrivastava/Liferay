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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer;

/**
 * The persistence interface for the s p payment customer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPPaymentCustomerPersistenceImpl
 * @see SPPaymentCustomerUtil
 * @generated
 */
public interface SPPaymentCustomerPersistence extends BasePersistence<SPPaymentCustomer> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPPaymentCustomerUtil} to access the s p payment customer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the s p payment customer where groupId = &#63; and emailAddress = &#63; or throws a {@link com.sambaash.platform.srv.sppayment.NoSuchCustomerException} if it could not be found.
	*
	* @param groupId the group ID
	* @param emailAddress the email address
	* @return the matching s p payment customer
	* @throws com.sambaash.platform.srv.sppayment.NoSuchCustomerException if a matching s p payment customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer findByEmailAddress(
		long groupId, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sppayment.NoSuchCustomerException;

	/**
	* Returns the s p payment customer where groupId = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param emailAddress the email address
	* @return the matching s p payment customer, or <code>null</code> if a matching s p payment customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer fetchByEmailAddress(
		long groupId, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p payment customer where groupId = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param emailAddress the email address
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p payment customer, or <code>null</code> if a matching s p payment customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer fetchByEmailAddress(
		long groupId, java.lang.String emailAddress, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p payment customer where groupId = &#63; and emailAddress = &#63; from the database.
	*
	* @param groupId the group ID
	* @param emailAddress the email address
	* @return the s p payment customer that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer removeByEmailAddress(
		long groupId, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sppayment.NoSuchCustomerException;

	/**
	* Returns the number of s p payment customers where groupId = &#63; and emailAddress = &#63;.
	*
	* @param groupId the group ID
	* @param emailAddress the email address
	* @return the number of matching s p payment customers
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmailAddress(long groupId, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p payment customer in the entity cache if it is enabled.
	*
	* @param spPaymentCustomer the s p payment customer
	*/
	public void cacheResult(
		com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer spPaymentCustomer);

	/**
	* Caches the s p payment customers in the entity cache if it is enabled.
	*
	* @param spPaymentCustomers the s p payment customers
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer> spPaymentCustomers);

	/**
	* Creates a new s p payment customer with the primary key. Does not add the s p payment customer to the database.
	*
	* @param sPPaymentCustomerId the primary key for the new s p payment customer
	* @return the new s p payment customer
	*/
	public com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer create(
		long sPPaymentCustomerId);

	/**
	* Removes the s p payment customer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sPPaymentCustomerId the primary key of the s p payment customer
	* @return the s p payment customer that was removed
	* @throws com.sambaash.platform.srv.sppayment.NoSuchCustomerException if a s p payment customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer remove(
		long sPPaymentCustomerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sppayment.NoSuchCustomerException;

	public com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer updateImpl(
		com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer spPaymentCustomer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p payment customer with the primary key or throws a {@link com.sambaash.platform.srv.sppayment.NoSuchCustomerException} if it could not be found.
	*
	* @param sPPaymentCustomerId the primary key of the s p payment customer
	* @return the s p payment customer
	* @throws com.sambaash.platform.srv.sppayment.NoSuchCustomerException if a s p payment customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer findByPrimaryKey(
		long sPPaymentCustomerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sppayment.NoSuchCustomerException;

	/**
	* Returns the s p payment customer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sPPaymentCustomerId the primary key of the s p payment customer
	* @return the s p payment customer, or <code>null</code> if a s p payment customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer fetchByPrimaryKey(
		long sPPaymentCustomerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p payment customers.
	*
	* @return the s p payment customers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p payment customers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p payment customers.
	*
	* @return the number of s p payment customers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}