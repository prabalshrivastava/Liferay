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

import com.sambaash.platform.srv.spshopping.model.SPCartPackage;

/**
 * The persistence interface for the s p cart package service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPCartPackagePersistenceImpl
 * @see SPCartPackageUtil
 * @generated
 */
public interface SPCartPackagePersistence extends BasePersistence<SPCartPackage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPCartPackageUtil} to access the s p cart package persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p cart packages where cartId = &#63;.
	*
	* @param cartId the cart ID
	* @return the matching s p cart packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPCartPackage> findBycartId(
		long cartId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p cart packages where cartId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cartId the cart ID
	* @param start the lower bound of the range of s p cart packages
	* @param end the upper bound of the range of s p cart packages (not inclusive)
	* @return the range of matching s p cart packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPCartPackage> findBycartId(
		long cartId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p cart packages where cartId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cartId the cart ID
	* @param start the lower bound of the range of s p cart packages
	* @param end the upper bound of the range of s p cart packages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p cart packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPCartPackage> findBycartId(
		long cartId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p cart package in the ordered set where cartId = &#63;.
	*
	* @param cartId the cart ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p cart package
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException if a matching s p cart package could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPCartPackage findBycartId_First(
		long cartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException;

	/**
	* Returns the first s p cart package in the ordered set where cartId = &#63;.
	*
	* @param cartId the cart ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p cart package, or <code>null</code> if a matching s p cart package could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPCartPackage fetchBycartId_First(
		long cartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p cart package in the ordered set where cartId = &#63;.
	*
	* @param cartId the cart ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p cart package
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException if a matching s p cart package could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPCartPackage findBycartId_Last(
		long cartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException;

	/**
	* Returns the last s p cart package in the ordered set where cartId = &#63;.
	*
	* @param cartId the cart ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p cart package, or <code>null</code> if a matching s p cart package could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPCartPackage fetchBycartId_Last(
		long cartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p cart packages before and after the current s p cart package in the ordered set where cartId = &#63;.
	*
	* @param spCartPackageId the primary key of the current s p cart package
	* @param cartId the cart ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p cart package
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException if a s p cart package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPCartPackage[] findBycartId_PrevAndNext(
		long spCartPackageId, long cartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException;

	/**
	* Removes all the s p cart packages where cartId = &#63; from the database.
	*
	* @param cartId the cart ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBycartId(long cartId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p cart packages where cartId = &#63;.
	*
	* @param cartId the cart ID
	* @return the number of matching s p cart packages
	* @throws SystemException if a system exception occurred
	*/
	public int countBycartId(long cartId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p cart packages where packageId = &#63;.
	*
	* @param packageId the package ID
	* @return the matching s p cart packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPCartPackage> findByPackageId(
		long packageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p cart packages where packageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param packageId the package ID
	* @param start the lower bound of the range of s p cart packages
	* @param end the upper bound of the range of s p cart packages (not inclusive)
	* @return the range of matching s p cart packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPCartPackage> findByPackageId(
		long packageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p cart packages where packageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param packageId the package ID
	* @param start the lower bound of the range of s p cart packages
	* @param end the upper bound of the range of s p cart packages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p cart packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPCartPackage> findByPackageId(
		long packageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p cart package in the ordered set where packageId = &#63;.
	*
	* @param packageId the package ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p cart package
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException if a matching s p cart package could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPCartPackage findByPackageId_First(
		long packageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException;

	/**
	* Returns the first s p cart package in the ordered set where packageId = &#63;.
	*
	* @param packageId the package ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p cart package, or <code>null</code> if a matching s p cart package could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPCartPackage fetchByPackageId_First(
		long packageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p cart package in the ordered set where packageId = &#63;.
	*
	* @param packageId the package ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p cart package
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException if a matching s p cart package could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPCartPackage findByPackageId_Last(
		long packageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException;

	/**
	* Returns the last s p cart package in the ordered set where packageId = &#63;.
	*
	* @param packageId the package ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p cart package, or <code>null</code> if a matching s p cart package could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPCartPackage fetchByPackageId_Last(
		long packageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p cart packages before and after the current s p cart package in the ordered set where packageId = &#63;.
	*
	* @param spCartPackageId the primary key of the current s p cart package
	* @param packageId the package ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p cart package
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException if a s p cart package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPCartPackage[] findByPackageId_PrevAndNext(
		long spCartPackageId, long packageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException;

	/**
	* Removes all the s p cart packages where packageId = &#63; from the database.
	*
	* @param packageId the package ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPackageId(long packageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p cart packages where packageId = &#63;.
	*
	* @param packageId the package ID
	* @return the number of matching s p cart packages
	* @throws SystemException if a system exception occurred
	*/
	public int countByPackageId(long packageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p cart package in the entity cache if it is enabled.
	*
	* @param spCartPackage the s p cart package
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spshopping.model.SPCartPackage spCartPackage);

	/**
	* Caches the s p cart packages in the entity cache if it is enabled.
	*
	* @param spCartPackages the s p cart packages
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spshopping.model.SPCartPackage> spCartPackages);

	/**
	* Creates a new s p cart package with the primary key. Does not add the s p cart package to the database.
	*
	* @param spCartPackageId the primary key for the new s p cart package
	* @return the new s p cart package
	*/
	public com.sambaash.platform.srv.spshopping.model.SPCartPackage create(
		long spCartPackageId);

	/**
	* Removes the s p cart package with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spCartPackageId the primary key of the s p cart package
	* @return the s p cart package that was removed
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException if a s p cart package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPCartPackage remove(
		long spCartPackageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException;

	public com.sambaash.platform.srv.spshopping.model.SPCartPackage updateImpl(
		com.sambaash.platform.srv.spshopping.model.SPCartPackage spCartPackage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p cart package with the primary key or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException} if it could not be found.
	*
	* @param spCartPackageId the primary key of the s p cart package
	* @return the s p cart package
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException if a s p cart package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPCartPackage findByPrimaryKey(
		long spCartPackageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException;

	/**
	* Returns the s p cart package with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spCartPackageId the primary key of the s p cart package
	* @return the s p cart package, or <code>null</code> if a s p cart package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPCartPackage fetchByPrimaryKey(
		long spCartPackageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p cart packages.
	*
	* @return the s p cart packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPCartPackage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p cart packages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p cart packages
	* @param end the upper bound of the range of s p cart packages (not inclusive)
	* @return the range of s p cart packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPCartPackage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p cart packages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p cart packages
	* @param end the upper bound of the range of s p cart packages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p cart packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPCartPackage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p cart packages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p cart packages.
	*
	* @return the number of s p cart packages
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}