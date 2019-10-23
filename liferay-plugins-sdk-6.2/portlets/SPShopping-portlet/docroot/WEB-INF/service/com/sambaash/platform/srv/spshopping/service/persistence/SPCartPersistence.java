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

import com.sambaash.platform.srv.spshopping.model.SPCart;

/**
 * The persistence interface for the s p cart service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPCartPersistenceImpl
 * @see SPCartUtil
 * @generated
 */
public interface SPCartPersistence extends BasePersistence<SPCart> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPCartUtil} to access the s p cart persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the s p cart in the entity cache if it is enabled.
	*
	* @param spCart the s p cart
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spshopping.model.SPCart spCart);

	/**
	* Caches the s p carts in the entity cache if it is enabled.
	*
	* @param spCarts the s p carts
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spshopping.model.SPCart> spCarts);

	/**
	* Creates a new s p cart with the primary key. Does not add the s p cart to the database.
	*
	* @param spCartId the primary key for the new s p cart
	* @return the new s p cart
	*/
	public com.sambaash.platform.srv.spshopping.model.SPCart create(
		long spCartId);

	/**
	* Removes the s p cart with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spCartId the primary key of the s p cart
	* @return the s p cart that was removed
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartException if a s p cart with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPCart remove(
		long spCartId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPCartException;

	public com.sambaash.platform.srv.spshopping.model.SPCart updateImpl(
		com.sambaash.platform.srv.spshopping.model.SPCart spCart)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p cart with the primary key or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPCartException} if it could not be found.
	*
	* @param spCartId the primary key of the s p cart
	* @return the s p cart
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartException if a s p cart with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPCart findByPrimaryKey(
		long spCartId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPCartException;

	/**
	* Returns the s p cart with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spCartId the primary key of the s p cart
	* @return the s p cart, or <code>null</code> if a s p cart with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPCart fetchByPrimaryKey(
		long spCartId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p carts.
	*
	* @return the s p carts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPCart> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p carts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p carts
	* @param end the upper bound of the range of s p carts (not inclusive)
	* @return the range of s p carts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPCart> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p carts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p carts
	* @param end the upper bound of the range of s p carts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p carts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPCart> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p carts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p carts.
	*
	* @return the number of s p carts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}