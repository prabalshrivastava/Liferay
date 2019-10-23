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

package com.sambaash.platform.srv.spsocialprofile.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;

import java.util.List;

/**
 * The persistence utility for the social profile service. This utility wraps {@link SocialProfilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfilePersistence
 * @see SocialProfilePersistenceImpl
 * @generated
 */
public class SocialProfileUtil {
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
	public static void clearCache(SocialProfile socialProfile) {
		getPersistence().clearCache(socialProfile);
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
	public static List<SocialProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SocialProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SocialProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SocialProfile update(SocialProfile socialProfile)
		throws SystemException {
		return getPersistence().update(socialProfile);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SocialProfile update(SocialProfile socialProfile,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(socialProfile, serviceContext);
	}

	/**
	* Returns all the social profiles where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the social profiles where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of social profiles
	* @param end the upper bound of the range of social profiles (not inclusive)
	* @return the range of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the social profiles where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of social profiles
	* @param end the upper bound of the range of social profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first social profile in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first social profile in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last social profile in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last social profile in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the social profiles before and after the current social profile in the ordered set where uuid = &#63;.
	*
	* @param userId the primary key of the current social profile
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a social profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile[] findByUuid_PrevAndNext(
		long userId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence()
				   .findByUuid_PrevAndNext(userId, uuid, orderByComparator);
	}

	/**
	* Removes all the social profiles where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of social profiles where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the social profile where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the social profile where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the social profile where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the social profile where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the social profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of social profiles where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the social profiles where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the social profiles where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of social profiles
	* @param end the upper bound of the range of social profiles (not inclusive)
	* @return the range of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the social profiles where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of social profiles
	* @param end the upper bound of the range of social profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first social profile in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first social profile in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last social profile in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last social profile in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the social profiles before and after the current social profile in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param userId the primary key of the current social profile
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a social profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile[] findByUuid_C_PrevAndNext(
		long userId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(userId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the social profiles where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of social profiles where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns the social profile where companyId = &#63; and userId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException} if it could not be found.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByUserIdAndCompanyId(
		long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence().findByUserIdAndCompanyId(companyId, userId);
	}

	/**
	* Returns the social profile where companyId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByUserIdAndCompanyId(
		long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserIdAndCompanyId(companyId, userId);
	}

	/**
	* Returns the social profile where companyId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByUserIdAndCompanyId(
		long companyId, long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdAndCompanyId(companyId, userId,
			retrieveFromCache);
	}

	/**
	* Removes the social profile where companyId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the social profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile removeByUserIdAndCompanyId(
		long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence().removeByUserIdAndCompanyId(companyId, userId);
	}

	/**
	* Returns the number of social profiles where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the number of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdAndCompanyId(long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserIdAndCompanyId(companyId, userId);
	}

	/**
	* Returns the social profile where companyId = &#63; and userId = &#63; and userRegistrationStatus = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException} if it could not be found.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param userRegistrationStatus the user registration status
	* @return the matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByUserIdCompIdAndRegStatus(
		long companyId, long userId, java.lang.String userRegistrationStatus)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence()
				   .findByUserIdCompIdAndRegStatus(companyId, userId,
			userRegistrationStatus);
	}

	/**
	* Returns the social profile where companyId = &#63; and userId = &#63; and userRegistrationStatus = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param userRegistrationStatus the user registration status
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByUserIdCompIdAndRegStatus(
		long companyId, long userId, java.lang.String userRegistrationStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdCompIdAndRegStatus(companyId, userId,
			userRegistrationStatus);
	}

	/**
	* Returns the social profile where companyId = &#63; and userId = &#63; and userRegistrationStatus = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param userRegistrationStatus the user registration status
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByUserIdCompIdAndRegStatus(
		long companyId, long userId, java.lang.String userRegistrationStatus,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdCompIdAndRegStatus(companyId, userId,
			userRegistrationStatus, retrieveFromCache);
	}

	/**
	* Removes the social profile where companyId = &#63; and userId = &#63; and userRegistrationStatus = &#63; from the database.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param userRegistrationStatus the user registration status
	* @return the social profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile removeByUserIdCompIdAndRegStatus(
		long companyId, long userId, java.lang.String userRegistrationStatus)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence()
				   .removeByUserIdCompIdAndRegStatus(companyId, userId,
			userRegistrationStatus);
	}

	/**
	* Returns the number of social profiles where companyId = &#63; and userId = &#63; and userRegistrationStatus = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param userRegistrationStatus the user registration status
	* @return the number of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdCompIdAndRegStatus(long companyId,
		long userId, java.lang.String userRegistrationStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByUserIdCompIdAndRegStatus(companyId, userId,
			userRegistrationStatus);
	}

	/**
	* Returns all the social profiles where memberPackage = &#63;.
	*
	* @param memberPackage the member package
	* @return the matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByMemberPackageId(
		long memberPackage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMemberPackageId(memberPackage);
	}

	/**
	* Returns a range of all the social profiles where memberPackage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param memberPackage the member package
	* @param start the lower bound of the range of social profiles
	* @param end the upper bound of the range of social profiles (not inclusive)
	* @return the range of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByMemberPackageId(
		long memberPackage, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMemberPackageId(memberPackage, start, end);
	}

	/**
	* Returns an ordered range of all the social profiles where memberPackage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param memberPackage the member package
	* @param start the lower bound of the range of social profiles
	* @param end the upper bound of the range of social profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByMemberPackageId(
		long memberPackage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMemberPackageId(memberPackage, start, end,
			orderByComparator);
	}

	/**
	* Returns the first social profile in the ordered set where memberPackage = &#63;.
	*
	* @param memberPackage the member package
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByMemberPackageId_First(
		long memberPackage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence()
				   .findByMemberPackageId_First(memberPackage, orderByComparator);
	}

	/**
	* Returns the first social profile in the ordered set where memberPackage = &#63;.
	*
	* @param memberPackage the member package
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByMemberPackageId_First(
		long memberPackage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMemberPackageId_First(memberPackage,
			orderByComparator);
	}

	/**
	* Returns the last social profile in the ordered set where memberPackage = &#63;.
	*
	* @param memberPackage the member package
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByMemberPackageId_Last(
		long memberPackage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence()
				   .findByMemberPackageId_Last(memberPackage, orderByComparator);
	}

	/**
	* Returns the last social profile in the ordered set where memberPackage = &#63;.
	*
	* @param memberPackage the member package
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByMemberPackageId_Last(
		long memberPackage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMemberPackageId_Last(memberPackage, orderByComparator);
	}

	/**
	* Returns the social profiles before and after the current social profile in the ordered set where memberPackage = &#63;.
	*
	* @param userId the primary key of the current social profile
	* @param memberPackage the member package
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a social profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile[] findByMemberPackageId_PrevAndNext(
		long userId, long memberPackage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence()
				   .findByMemberPackageId_PrevAndNext(userId, memberPackage,
			orderByComparator);
	}

	/**
	* Removes all the social profiles where memberPackage = &#63; from the database.
	*
	* @param memberPackage the member package
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMemberPackageId(long memberPackage)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMemberPackageId(memberPackage);
	}

	/**
	* Returns the number of social profiles where memberPackage = &#63;.
	*
	* @param memberPackage the member package
	* @return the number of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMemberPackageId(long memberPackage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMemberPackageId(memberPackage);
	}

	/**
	* Returns all the social profiles where userType = &#63; and userRegistrationStatus = &#63;.
	*
	* @param userType the user type
	* @param userRegistrationStatus the user registration status
	* @return the matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUserTypeAndRegStatus(
		java.lang.String userType, java.lang.String userRegistrationStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserTypeAndRegStatus(userType, userRegistrationStatus);
	}

	/**
	* Returns a range of all the social profiles where userType = &#63; and userRegistrationStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userType the user type
	* @param userRegistrationStatus the user registration status
	* @param start the lower bound of the range of social profiles
	* @param end the upper bound of the range of social profiles (not inclusive)
	* @return the range of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUserTypeAndRegStatus(
		java.lang.String userType, java.lang.String userRegistrationStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserTypeAndRegStatus(userType,
			userRegistrationStatus, start, end);
	}

	/**
	* Returns an ordered range of all the social profiles where userType = &#63; and userRegistrationStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userType the user type
	* @param userRegistrationStatus the user registration status
	* @param start the lower bound of the range of social profiles
	* @param end the upper bound of the range of social profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUserTypeAndRegStatus(
		java.lang.String userType, java.lang.String userRegistrationStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserTypeAndRegStatus(userType,
			userRegistrationStatus, start, end, orderByComparator);
	}

	/**
	* Returns the first social profile in the ordered set where userType = &#63; and userRegistrationStatus = &#63;.
	*
	* @param userType the user type
	* @param userRegistrationStatus the user registration status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByUserTypeAndRegStatus_First(
		java.lang.String userType, java.lang.String userRegistrationStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence()
				   .findByUserTypeAndRegStatus_First(userType,
			userRegistrationStatus, orderByComparator);
	}

	/**
	* Returns the first social profile in the ordered set where userType = &#63; and userRegistrationStatus = &#63;.
	*
	* @param userType the user type
	* @param userRegistrationStatus the user registration status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByUserTypeAndRegStatus_First(
		java.lang.String userType, java.lang.String userRegistrationStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserTypeAndRegStatus_First(userType,
			userRegistrationStatus, orderByComparator);
	}

	/**
	* Returns the last social profile in the ordered set where userType = &#63; and userRegistrationStatus = &#63;.
	*
	* @param userType the user type
	* @param userRegistrationStatus the user registration status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByUserTypeAndRegStatus_Last(
		java.lang.String userType, java.lang.String userRegistrationStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence()
				   .findByUserTypeAndRegStatus_Last(userType,
			userRegistrationStatus, orderByComparator);
	}

	/**
	* Returns the last social profile in the ordered set where userType = &#63; and userRegistrationStatus = &#63;.
	*
	* @param userType the user type
	* @param userRegistrationStatus the user registration status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByUserTypeAndRegStatus_Last(
		java.lang.String userType, java.lang.String userRegistrationStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserTypeAndRegStatus_Last(userType,
			userRegistrationStatus, orderByComparator);
	}

	/**
	* Returns the social profiles before and after the current social profile in the ordered set where userType = &#63; and userRegistrationStatus = &#63;.
	*
	* @param userId the primary key of the current social profile
	* @param userType the user type
	* @param userRegistrationStatus the user registration status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a social profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile[] findByUserTypeAndRegStatus_PrevAndNext(
		long userId, java.lang.String userType,
		java.lang.String userRegistrationStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence()
				   .findByUserTypeAndRegStatus_PrevAndNext(userId, userType,
			userRegistrationStatus, orderByComparator);
	}

	/**
	* Removes all the social profiles where userType = &#63; and userRegistrationStatus = &#63; from the database.
	*
	* @param userType the user type
	* @param userRegistrationStatus the user registration status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserTypeAndRegStatus(java.lang.String userType,
		java.lang.String userRegistrationStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByUserTypeAndRegStatus(userType, userRegistrationStatus);
	}

	/**
	* Returns the number of social profiles where userType = &#63; and userRegistrationStatus = &#63;.
	*
	* @param userType the user type
	* @param userRegistrationStatus the user registration status
	* @return the number of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserTypeAndRegStatus(java.lang.String userType,
		java.lang.String userRegistrationStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByUserTypeAndRegStatus(userType, userRegistrationStatus);
	}

	/**
	* Returns the social profile where companyId = &#63; and twitterId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException} if it could not be found.
	*
	* @param companyId the company ID
	* @param twitterId the twitter ID
	* @return the matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByTwitterId(
		long companyId, java.lang.String twitterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence().findByTwitterId(companyId, twitterId);
	}

	/**
	* Returns the social profile where companyId = &#63; and twitterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param twitterId the twitter ID
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByTwitterId(
		long companyId, java.lang.String twitterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTwitterId(companyId, twitterId);
	}

	/**
	* Returns the social profile where companyId = &#63; and twitterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param twitterId the twitter ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByTwitterId(
		long companyId, java.lang.String twitterId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTwitterId(companyId, twitterId, retrieveFromCache);
	}

	/**
	* Removes the social profile where companyId = &#63; and twitterId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param twitterId the twitter ID
	* @return the social profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile removeByTwitterId(
		long companyId, java.lang.String twitterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence().removeByTwitterId(companyId, twitterId);
	}

	/**
	* Returns the number of social profiles where companyId = &#63; and twitterId = &#63;.
	*
	* @param companyId the company ID
	* @param twitterId the twitter ID
	* @return the number of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTwitterId(long companyId,
		java.lang.String twitterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTwitterId(companyId, twitterId);
	}

	/**
	* Returns the social profile where companyId = &#63; and linkedinId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException} if it could not be found.
	*
	* @param companyId the company ID
	* @param linkedinId the linkedin ID
	* @return the matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByLinkedinId(
		long companyId, java.lang.String linkedinId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence().findByLinkedinId(companyId, linkedinId);
	}

	/**
	* Returns the social profile where companyId = &#63; and linkedinId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param linkedinId the linkedin ID
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByLinkedinId(
		long companyId, java.lang.String linkedinId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLinkedinId(companyId, linkedinId);
	}

	/**
	* Returns the social profile where companyId = &#63; and linkedinId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param linkedinId the linkedin ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByLinkedinId(
		long companyId, java.lang.String linkedinId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLinkedinId(companyId, linkedinId, retrieveFromCache);
	}

	/**
	* Removes the social profile where companyId = &#63; and linkedinId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param linkedinId the linkedin ID
	* @return the social profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile removeByLinkedinId(
		long companyId, java.lang.String linkedinId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence().removeByLinkedinId(companyId, linkedinId);
	}

	/**
	* Returns the number of social profiles where companyId = &#63; and linkedinId = &#63;.
	*
	* @param companyId the company ID
	* @param linkedinId the linkedin ID
	* @return the number of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLinkedinId(long companyId,
		java.lang.String linkedinId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLinkedinId(companyId, linkedinId);
	}

	/**
	* Returns the social profile where companyId = &#63; and yahooId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException} if it could not be found.
	*
	* @param companyId the company ID
	* @param yahooId the yahoo ID
	* @return the matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByYahooId(
		long companyId, java.lang.String yahooId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence().findByYahooId(companyId, yahooId);
	}

	/**
	* Returns the social profile where companyId = &#63; and yahooId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param yahooId the yahoo ID
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByYahooId(
		long companyId, java.lang.String yahooId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByYahooId(companyId, yahooId);
	}

	/**
	* Returns the social profile where companyId = &#63; and yahooId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param yahooId the yahoo ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByYahooId(
		long companyId, java.lang.String yahooId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByYahooId(companyId, yahooId, retrieveFromCache);
	}

	/**
	* Removes the social profile where companyId = &#63; and yahooId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param yahooId the yahoo ID
	* @return the social profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile removeByYahooId(
		long companyId, java.lang.String yahooId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence().removeByYahooId(companyId, yahooId);
	}

	/**
	* Returns the number of social profiles where companyId = &#63; and yahooId = &#63;.
	*
	* @param companyId the company ID
	* @param yahooId the yahoo ID
	* @return the number of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByYahooId(long companyId, java.lang.String yahooId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByYahooId(companyId, yahooId);
	}

	/**
	* Returns the social profile where companyId = &#63; and googleId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException} if it could not be found.
	*
	* @param companyId the company ID
	* @param googleId the google ID
	* @return the matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByGoogleId(
		long companyId, java.lang.String googleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence().findByGoogleId(companyId, googleId);
	}

	/**
	* Returns the social profile where companyId = &#63; and googleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param googleId the google ID
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByGoogleId(
		long companyId, java.lang.String googleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGoogleId(companyId, googleId);
	}

	/**
	* Returns the social profile where companyId = &#63; and googleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param googleId the google ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByGoogleId(
		long companyId, java.lang.String googleId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGoogleId(companyId, googleId, retrieveFromCache);
	}

	/**
	* Removes the social profile where companyId = &#63; and googleId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param googleId the google ID
	* @return the social profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile removeByGoogleId(
		long companyId, java.lang.String googleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence().removeByGoogleId(companyId, googleId);
	}

	/**
	* Returns the number of social profiles where companyId = &#63; and googleId = &#63;.
	*
	* @param companyId the company ID
	* @param googleId the google ID
	* @return the number of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGoogleId(long companyId, java.lang.String googleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGoogleId(companyId, googleId);
	}

	/**
	* Caches the social profile in the entity cache if it is enabled.
	*
	* @param socialProfile the social profile
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile) {
		getPersistence().cacheResult(socialProfile);
	}

	/**
	* Caches the social profiles in the entity cache if it is enabled.
	*
	* @param socialProfiles the social profiles
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> socialProfiles) {
		getPersistence().cacheResult(socialProfiles);
	}

	/**
	* Creates a new social profile with the primary key. Does not add the social profile to the database.
	*
	* @param userId the primary key for the new social profile
	* @return the new social profile
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile create(
		long userId) {
		return getPersistence().create(userId);
	}

	/**
	* Removes the social profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the social profile
	* @return the social profile that was removed
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a social profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile remove(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence().remove(userId);
	}

	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile updateImpl(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(socialProfile);
	}

	/**
	* Returns the social profile with the primary key or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException} if it could not be found.
	*
	* @param userId the primary key of the social profile
	* @return the social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a social profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByPrimaryKey(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		return getPersistence().findByPrimaryKey(userId);
	}

	/**
	* Returns the social profile with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the social profile
	* @return the social profile, or <code>null</code> if a social profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByPrimaryKey(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userId);
	}

	/**
	* Returns all the social profiles.
	*
	* @return the social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the social profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of social profiles
	* @param end the upper bound of the range of social profiles (not inclusive)
	* @return the range of social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the social profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of social profiles
	* @param end the upper bound of the range of social profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the social profiles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of social profiles.
	*
	* @return the number of social profiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SocialProfilePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SocialProfilePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spsocialprofile.service.ClpSerializer.getServletContextName(),
					SocialProfilePersistence.class.getName());

			ReferenceRegistry.registerReference(SocialProfileUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SocialProfilePersistence persistence) {
	}

	private static SocialProfilePersistence _persistence;
}