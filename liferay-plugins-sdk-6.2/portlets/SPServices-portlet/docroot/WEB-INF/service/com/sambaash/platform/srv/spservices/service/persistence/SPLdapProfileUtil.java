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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.spservices.model.SPLdapProfile;

import java.util.List;

/**
 * The persistence utility for the s p ldap profile service. This utility wraps {@link SPLdapProfilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPLdapProfilePersistence
 * @see SPLdapProfilePersistenceImpl
 * @generated
 */
public class SPLdapProfileUtil {
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
	public static void clearCache(SPLdapProfile spLdapProfile) {
		getPersistence().clearCache(spLdapProfile);
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
	public static List<SPLdapProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPLdapProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPLdapProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPLdapProfile update(SPLdapProfile spLdapProfile)
		throws SystemException {
		return getPersistence().update(spLdapProfile);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPLdapProfile update(SPLdapProfile spLdapProfile,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spLdapProfile, serviceContext);
	}

	/**
	* Returns the s p ldap profile where userId = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching s p ldap profile
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException if a matching s p ldap profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLdapProfile findByUserId(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns the s p ldap profile where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching s p ldap profile, or <code>null</code> if a matching s p ldap profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLdapProfile fetchByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId(userId);
	}

	/**
	* Returns the s p ldap profile where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p ldap profile, or <code>null</code> if a matching s p ldap profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLdapProfile fetchByUserId(
		long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId(userId, retrieveFromCache);
	}

	/**
	* Removes the s p ldap profile where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the s p ldap profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLdapProfile removeByUserId(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException {
		return getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of s p ldap profiles where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching s p ldap profiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Caches the s p ldap profile in the entity cache if it is enabled.
	*
	* @param spLdapProfile the s p ldap profile
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spservices.model.SPLdapProfile spLdapProfile) {
		getPersistence().cacheResult(spLdapProfile);
	}

	/**
	* Caches the s p ldap profiles in the entity cache if it is enabled.
	*
	* @param spLdapProfiles the s p ldap profiles
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.SPLdapProfile> spLdapProfiles) {
		getPersistence().cacheResult(spLdapProfiles);
	}

	/**
	* Creates a new s p ldap profile with the primary key. Does not add the s p ldap profile to the database.
	*
	* @param spLdapProfileId the primary key for the new s p ldap profile
	* @return the new s p ldap profile
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLdapProfile create(
		long spLdapProfileId) {
		return getPersistence().create(spLdapProfileId);
	}

	/**
	* Removes the s p ldap profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spLdapProfileId the primary key of the s p ldap profile
	* @return the s p ldap profile that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException if a s p ldap profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLdapProfile remove(
		long spLdapProfileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException {
		return getPersistence().remove(spLdapProfileId);
	}

	public static com.sambaash.platform.srv.spservices.model.SPLdapProfile updateImpl(
		com.sambaash.platform.srv.spservices.model.SPLdapProfile spLdapProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spLdapProfile);
	}

	/**
	* Returns the s p ldap profile with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException} if it could not be found.
	*
	* @param spLdapProfileId the primary key of the s p ldap profile
	* @return the s p ldap profile
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException if a s p ldap profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLdapProfile findByPrimaryKey(
		long spLdapProfileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException {
		return getPersistence().findByPrimaryKey(spLdapProfileId);
	}

	/**
	* Returns the s p ldap profile with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spLdapProfileId the primary key of the s p ldap profile
	* @return the s p ldap profile, or <code>null</code> if a s p ldap profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLdapProfile fetchByPrimaryKey(
		long spLdapProfileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spLdapProfileId);
	}

	/**
	* Returns all the s p ldap profiles.
	*
	* @return the s p ldap profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPLdapProfile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPLdapProfile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPLdapProfile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p ldap profiles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p ldap profiles.
	*
	* @return the number of s p ldap profiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPLdapProfilePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPLdapProfilePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spservices.service.ClpSerializer.getServletContextName(),
					SPLdapProfilePersistence.class.getName());

			ReferenceRegistry.registerReference(SPLdapProfileUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPLdapProfilePersistence persistence) {
	}

	private static SPLdapProfilePersistence _persistence;
}