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

import com.sambaash.platform.srv.spservices.model.SPLdapProfile;

/**
 * The persistence interface for the s p ldap profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPLdapProfilePersistenceImpl
 * @see SPLdapProfileUtil
 * @generated
 */
public interface SPLdapProfilePersistence extends BasePersistence<SPLdapProfile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPLdapProfileUtil} to access the s p ldap profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the s p ldap profile where userId = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching s p ldap profile
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException if a matching s p ldap profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPLdapProfile findByUserId(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException;

	/**
	* Returns the s p ldap profile where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching s p ldap profile, or <code>null</code> if a matching s p ldap profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPLdapProfile fetchByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p ldap profile where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p ldap profile, or <code>null</code> if a matching s p ldap profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPLdapProfile fetchByUserId(
		long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p ldap profile where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the s p ldap profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPLdapProfile removeByUserId(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException;

	/**
	* Returns the number of s p ldap profiles where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching s p ldap profiles
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p ldap profile in the entity cache if it is enabled.
	*
	* @param spLdapProfile the s p ldap profile
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spservices.model.SPLdapProfile spLdapProfile);

	/**
	* Caches the s p ldap profiles in the entity cache if it is enabled.
	*
	* @param spLdapProfiles the s p ldap profiles
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.SPLdapProfile> spLdapProfiles);

	/**
	* Creates a new s p ldap profile with the primary key. Does not add the s p ldap profile to the database.
	*
	* @param spLdapProfileId the primary key for the new s p ldap profile
	* @return the new s p ldap profile
	*/
	public com.sambaash.platform.srv.spservices.model.SPLdapProfile create(
		long spLdapProfileId);

	/**
	* Removes the s p ldap profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spLdapProfileId the primary key of the s p ldap profile
	* @return the s p ldap profile that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException if a s p ldap profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPLdapProfile remove(
		long spLdapProfileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException;

	public com.sambaash.platform.srv.spservices.model.SPLdapProfile updateImpl(
		com.sambaash.platform.srv.spservices.model.SPLdapProfile spLdapProfile)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p ldap profile with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException} if it could not be found.
	*
	* @param spLdapProfileId the primary key of the s p ldap profile
	* @return the s p ldap profile
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException if a s p ldap profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPLdapProfile findByPrimaryKey(
		long spLdapProfileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException;

	/**
	* Returns the s p ldap profile with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spLdapProfileId the primary key of the s p ldap profile
	* @return the s p ldap profile, or <code>null</code> if a s p ldap profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPLdapProfile fetchByPrimaryKey(
		long spLdapProfileId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p ldap profiles.
	*
	* @return the s p ldap profiles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPLdapProfile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p ldap profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLdapProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p ldap profiles
	* @param end the upper bound of the range of s p ldap profiles (not inclusive)
	* @return the range of s p ldap profiles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPLdapProfile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p ldap profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLdapProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p ldap profiles
	* @param end the upper bound of the range of s p ldap profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p ldap profiles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPLdapProfile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p ldap profiles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p ldap profiles.
	*
	* @return the number of s p ldap profiles
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}