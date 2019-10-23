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

import com.sambaash.platform.srv.spshopping.model.SPSellingPackage;

/**
 * The persistence interface for the s p selling package service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPSellingPackagePersistenceImpl
 * @see SPSellingPackageUtil
 * @generated
 */
public interface SPSellingPackagePersistence extends BasePersistence<SPSellingPackage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPSellingPackageUtil} to access the s p selling package persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p selling packages where active = &#63;.
	*
	* @param active the active
	* @return the matching s p selling packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPackage> findByactive(
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p selling packages where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param start the lower bound of the range of s p selling packages
	* @param end the upper bound of the range of s p selling packages (not inclusive)
	* @return the range of matching s p selling packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPackage> findByactive(
		boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p selling packages where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param start the lower bound of the range of s p selling packages
	* @param end the upper bound of the range of s p selling packages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p selling packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPackage> findByactive(
		boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p selling package in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p selling package
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPackageException if a matching s p selling package could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPSellingPackage findByactive_First(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingPackageException;

	/**
	* Returns the first s p selling package in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p selling package, or <code>null</code> if a matching s p selling package could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPSellingPackage fetchByactive_First(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p selling package in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p selling package
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPackageException if a matching s p selling package could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPSellingPackage findByactive_Last(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingPackageException;

	/**
	* Returns the last s p selling package in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p selling package, or <code>null</code> if a matching s p selling package could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPSellingPackage fetchByactive_Last(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p selling packages before and after the current s p selling package in the ordered set where active = &#63;.
	*
	* @param spSellingPackageId the primary key of the current s p selling package
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p selling package
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPackageException if a s p selling package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPSellingPackage[] findByactive_PrevAndNext(
		long spSellingPackageId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingPackageException;

	/**
	* Removes all the s p selling packages where active = &#63; from the database.
	*
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public void removeByactive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p selling packages where active = &#63;.
	*
	* @param active the active
	* @return the number of matching s p selling packages
	* @throws SystemException if a system exception occurred
	*/
	public int countByactive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p selling package in the entity cache if it is enabled.
	*
	* @param spSellingPackage the s p selling package
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spshopping.model.SPSellingPackage spSellingPackage);

	/**
	* Caches the s p selling packages in the entity cache if it is enabled.
	*
	* @param spSellingPackages the s p selling packages
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPackage> spSellingPackages);

	/**
	* Creates a new s p selling package with the primary key. Does not add the s p selling package to the database.
	*
	* @param spSellingPackageId the primary key for the new s p selling package
	* @return the new s p selling package
	*/
	public com.sambaash.platform.srv.spshopping.model.SPSellingPackage create(
		long spSellingPackageId);

	/**
	* Removes the s p selling package with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spSellingPackageId the primary key of the s p selling package
	* @return the s p selling package that was removed
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPackageException if a s p selling package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPSellingPackage remove(
		long spSellingPackageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingPackageException;

	public com.sambaash.platform.srv.spshopping.model.SPSellingPackage updateImpl(
		com.sambaash.platform.srv.spshopping.model.SPSellingPackage spSellingPackage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p selling package with the primary key or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPSellingPackageException} if it could not be found.
	*
	* @param spSellingPackageId the primary key of the s p selling package
	* @return the s p selling package
	* @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPackageException if a s p selling package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPSellingPackage findByPrimaryKey(
		long spSellingPackageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingPackageException;

	/**
	* Returns the s p selling package with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spSellingPackageId the primary key of the s p selling package
	* @return the s p selling package, or <code>null</code> if a s p selling package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spshopping.model.SPSellingPackage fetchByPrimaryKey(
		long spSellingPackageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p selling packages.
	*
	* @return the s p selling packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPackage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p selling packages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p selling packages
	* @param end the upper bound of the range of s p selling packages (not inclusive)
	* @return the range of s p selling packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPackage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p selling packages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p selling packages
	* @param end the upper bound of the range of s p selling packages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p selling packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPackage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p selling packages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p selling packages.
	*
	* @return the number of s p selling packages
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}