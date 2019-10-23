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

package com.sambaash.platform.srv.spservices.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.spservices.model.MembershipPackage;

/**
 * The persistence interface for the membership package service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipPackagePersistenceImpl
 * @see MembershipPackageUtil
 * @generated
 */
public interface MembershipPackagePersistence extends BasePersistence<MembershipPackage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MembershipPackageUtil} to access the membership package persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the membership packages where name = &#63;.
	*
	* @param name the name
	* @return the matching membership packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackage> findByMembershipPackageName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership packages where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of membership packages
	* @param end the upper bound of the range of membership packages (not inclusive)
	* @return the range of matching membership packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackage> findByMembershipPackageName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership packages where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of membership packages
	* @param end the upper bound of the range of membership packages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackage> findByMembershipPackageName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership package in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException if a matching membership package could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackage findByMembershipPackageName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException;

	/**
	* Returns the first membership package in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package, or <code>null</code> if a matching membership package could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackage fetchByMembershipPackageName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership package in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException if a matching membership package could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackage findByMembershipPackageName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException;

	/**
	* Returns the last membership package in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package, or <code>null</code> if a matching membership package could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackage fetchByMembershipPackageName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership packages before and after the current membership package in the ordered set where name = &#63;.
	*
	* @param mpId the primary key of the current membership package
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership package
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException if a membership package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackage[] findByMembershipPackageName_PrevAndNext(
		long mpId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException;

	/**
	* Removes all the membership packages where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMembershipPackageName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership packages where name = &#63;.
	*
	* @param name the name
	* @return the number of matching membership packages
	* @throws SystemException if a system exception occurred
	*/
	public int countByMembershipPackageName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership packages where extra1 = &#63;.
	*
	* @param extra1 the extra1
	* @return the matching membership packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackage> findByRoleId(
		java.lang.String extra1)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership packages where extra1 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param extra1 the extra1
	* @param start the lower bound of the range of membership packages
	* @param end the upper bound of the range of membership packages (not inclusive)
	* @return the range of matching membership packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackage> findByRoleId(
		java.lang.String extra1, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership packages where extra1 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param extra1 the extra1
	* @param start the lower bound of the range of membership packages
	* @param end the upper bound of the range of membership packages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackage> findByRoleId(
		java.lang.String extra1, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership package in the ordered set where extra1 = &#63;.
	*
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException if a matching membership package could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackage findByRoleId_First(
		java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException;

	/**
	* Returns the first membership package in the ordered set where extra1 = &#63;.
	*
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package, or <code>null</code> if a matching membership package could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackage fetchByRoleId_First(
		java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership package in the ordered set where extra1 = &#63;.
	*
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException if a matching membership package could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackage findByRoleId_Last(
		java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException;

	/**
	* Returns the last membership package in the ordered set where extra1 = &#63;.
	*
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package, or <code>null</code> if a matching membership package could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackage fetchByRoleId_Last(
		java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership packages before and after the current membership package in the ordered set where extra1 = &#63;.
	*
	* @param mpId the primary key of the current membership package
	* @param extra1 the extra1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership package
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException if a membership package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackage[] findByRoleId_PrevAndNext(
		long mpId, java.lang.String extra1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException;

	/**
	* Removes all the membership packages where extra1 = &#63; from the database.
	*
	* @param extra1 the extra1
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRoleId(java.lang.String extra1)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership packages where extra1 = &#63;.
	*
	* @param extra1 the extra1
	* @return the number of matching membership packages
	* @throws SystemException if a system exception occurred
	*/
	public int countByRoleId(java.lang.String extra1)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership packages where type = &#63;.
	*
	* @param type the type
	* @return the matching membership packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackage> findByMembershipPackageType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership packages where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of membership packages
	* @param end the upper bound of the range of membership packages (not inclusive)
	* @return the range of matching membership packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackage> findByMembershipPackageType(
		java.lang.String type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership packages where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of membership packages
	* @param end the upper bound of the range of membership packages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackage> findByMembershipPackageType(
		java.lang.String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership package in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException if a matching membership package could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackage findByMembershipPackageType_First(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException;

	/**
	* Returns the first membership package in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package, or <code>null</code> if a matching membership package could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackage fetchByMembershipPackageType_First(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership package in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException if a matching membership package could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackage findByMembershipPackageType_Last(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException;

	/**
	* Returns the last membership package in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package, or <code>null</code> if a matching membership package could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackage fetchByMembershipPackageType_Last(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership packages before and after the current membership package in the ordered set where type = &#63;.
	*
	* @param mpId the primary key of the current membership package
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership package
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException if a membership package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackage[] findByMembershipPackageType_PrevAndNext(
		long mpId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException;

	/**
	* Removes all the membership packages where type = &#63; from the database.
	*
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMembershipPackageType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership packages where type = &#63;.
	*
	* @param type the type
	* @return the number of matching membership packages
	* @throws SystemException if a system exception occurred
	*/
	public int countByMembershipPackageType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the membership package in the entity cache if it is enabled.
	*
	* @param membershipPackage the membership package
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spservices.model.MembershipPackage membershipPackage);

	/**
	* Caches the membership packages in the entity cache if it is enabled.
	*
	* @param membershipPackages the membership packages
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackage> membershipPackages);

	/**
	* Creates a new membership package with the primary key. Does not add the membership package to the database.
	*
	* @param mpId the primary key for the new membership package
	* @return the new membership package
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackage create(
		long mpId);

	/**
	* Removes the membership package with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mpId the primary key of the membership package
	* @return the membership package that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException if a membership package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackage remove(
		long mpId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException;

	public com.sambaash.platform.srv.spservices.model.MembershipPackage updateImpl(
		com.sambaash.platform.srv.spservices.model.MembershipPackage membershipPackage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership package with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException} if it could not be found.
	*
	* @param mpId the primary key of the membership package
	* @return the membership package
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException if a membership package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackage findByPrimaryKey(
		long mpId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException;

	/**
	* Returns the membership package with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mpId the primary key of the membership package
	* @return the membership package, or <code>null</code> if a membership package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackage fetchByPrimaryKey(
		long mpId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership packages.
	*
	* @return the membership packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership packages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership packages
	* @param end the upper bound of the range of membership packages (not inclusive)
	* @return the range of membership packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership packages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership packages
	* @param end the upper bound of the range of membership packages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of membership packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the membership packages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership packages.
	*
	* @return the number of membership packages
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}