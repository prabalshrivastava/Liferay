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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;

/**
 * The persistence interface for the social profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfilePersistenceImpl
 * @see SocialProfileUtil
 * @generated
 */
public interface SocialProfilePersistence extends BasePersistence<SocialProfile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SocialProfileUtil} to access the social profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the social profiles where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first social profile in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Returns the first social profile in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last social profile in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Returns the last social profile in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile[] findByUuid_PrevAndNext(
		long userId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Removes all the social profiles where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of social profiles where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Returns the social profile where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the social profile where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the social profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Returns the number of social profiles where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the social profiles where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Returns the first social profile in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Returns the last social profile in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile[] findByUuid_C_PrevAndNext(
		long userId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Removes all the social profiles where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of social profiles where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile where companyId = &#63; and userId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException} if it could not be found.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByUserIdAndCompanyId(
		long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Returns the social profile where companyId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByUserIdAndCompanyId(
		long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile where companyId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByUserIdAndCompanyId(
		long companyId, long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the social profile where companyId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the social profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile removeByUserIdAndCompanyId(
		long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Returns the number of social profiles where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the number of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdAndCompanyId(long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByUserIdCompIdAndRegStatus(
		long companyId, long userId, java.lang.String userRegistrationStatus)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Returns the social profile where companyId = &#63; and userId = &#63; and userRegistrationStatus = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param userRegistrationStatus the user registration status
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByUserIdCompIdAndRegStatus(
		long companyId, long userId, java.lang.String userRegistrationStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByUserIdCompIdAndRegStatus(
		long companyId, long userId, java.lang.String userRegistrationStatus,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the social profile where companyId = &#63; and userId = &#63; and userRegistrationStatus = &#63; from the database.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param userRegistrationStatus the user registration status
	* @return the social profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile removeByUserIdCompIdAndRegStatus(
		long companyId, long userId, java.lang.String userRegistrationStatus)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Returns the number of social profiles where companyId = &#63; and userId = &#63; and userRegistrationStatus = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param userRegistrationStatus the user registration status
	* @return the number of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdCompIdAndRegStatus(long companyId, long userId,
		java.lang.String userRegistrationStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the social profiles where memberPackage = &#63;.
	*
	* @param memberPackage the member package
	* @return the matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByMemberPackageId(
		long memberPackage)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByMemberPackageId(
		long memberPackage, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByMemberPackageId(
		long memberPackage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first social profile in the ordered set where memberPackage = &#63;.
	*
	* @param memberPackage the member package
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByMemberPackageId_First(
		long memberPackage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Returns the first social profile in the ordered set where memberPackage = &#63;.
	*
	* @param memberPackage the member package
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByMemberPackageId_First(
		long memberPackage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last social profile in the ordered set where memberPackage = &#63;.
	*
	* @param memberPackage the member package
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByMemberPackageId_Last(
		long memberPackage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Returns the last social profile in the ordered set where memberPackage = &#63;.
	*
	* @param memberPackage the member package
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByMemberPackageId_Last(
		long memberPackage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile[] findByMemberPackageId_PrevAndNext(
		long userId, long memberPackage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Removes all the social profiles where memberPackage = &#63; from the database.
	*
	* @param memberPackage the member package
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMemberPackageId(long memberPackage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of social profiles where memberPackage = &#63;.
	*
	* @param memberPackage the member package
	* @return the number of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public int countByMemberPackageId(long memberPackage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the social profiles where userType = &#63; and userRegistrationStatus = &#63;.
	*
	* @param userType the user type
	* @param userRegistrationStatus the user registration status
	* @return the matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUserTypeAndRegStatus(
		java.lang.String userType, java.lang.String userRegistrationStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUserTypeAndRegStatus(
		java.lang.String userType, java.lang.String userRegistrationStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUserTypeAndRegStatus(
		java.lang.String userType, java.lang.String userRegistrationStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByUserTypeAndRegStatus_First(
		java.lang.String userType, java.lang.String userRegistrationStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Returns the first social profile in the ordered set where userType = &#63; and userRegistrationStatus = &#63;.
	*
	* @param userType the user type
	* @param userRegistrationStatus the user registration status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByUserTypeAndRegStatus_First(
		java.lang.String userType, java.lang.String userRegistrationStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByUserTypeAndRegStatus_Last(
		java.lang.String userType, java.lang.String userRegistrationStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Returns the last social profile in the ordered set where userType = &#63; and userRegistrationStatus = &#63;.
	*
	* @param userType the user type
	* @param userRegistrationStatus the user registration status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByUserTypeAndRegStatus_Last(
		java.lang.String userType, java.lang.String userRegistrationStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile[] findByUserTypeAndRegStatus_PrevAndNext(
		long userId, java.lang.String userType,
		java.lang.String userRegistrationStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Removes all the social profiles where userType = &#63; and userRegistrationStatus = &#63; from the database.
	*
	* @param userType the user type
	* @param userRegistrationStatus the user registration status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserTypeAndRegStatus(java.lang.String userType,
		java.lang.String userRegistrationStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of social profiles where userType = &#63; and userRegistrationStatus = &#63;.
	*
	* @param userType the user type
	* @param userRegistrationStatus the user registration status
	* @return the number of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserTypeAndRegStatus(java.lang.String userType,
		java.lang.String userRegistrationStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile where companyId = &#63; and twitterId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException} if it could not be found.
	*
	* @param companyId the company ID
	* @param twitterId the twitter ID
	* @return the matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByTwitterId(
		long companyId, java.lang.String twitterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Returns the social profile where companyId = &#63; and twitterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param twitterId the twitter ID
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByTwitterId(
		long companyId, java.lang.String twitterId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile where companyId = &#63; and twitterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param twitterId the twitter ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByTwitterId(
		long companyId, java.lang.String twitterId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the social profile where companyId = &#63; and twitterId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param twitterId the twitter ID
	* @return the social profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile removeByTwitterId(
		long companyId, java.lang.String twitterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Returns the number of social profiles where companyId = &#63; and twitterId = &#63;.
	*
	* @param companyId the company ID
	* @param twitterId the twitter ID
	* @return the number of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public int countByTwitterId(long companyId, java.lang.String twitterId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile where companyId = &#63; and linkedinId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException} if it could not be found.
	*
	* @param companyId the company ID
	* @param linkedinId the linkedin ID
	* @return the matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByLinkedinId(
		long companyId, java.lang.String linkedinId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Returns the social profile where companyId = &#63; and linkedinId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param linkedinId the linkedin ID
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByLinkedinId(
		long companyId, java.lang.String linkedinId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile where companyId = &#63; and linkedinId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param linkedinId the linkedin ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByLinkedinId(
		long companyId, java.lang.String linkedinId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the social profile where companyId = &#63; and linkedinId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param linkedinId the linkedin ID
	* @return the social profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile removeByLinkedinId(
		long companyId, java.lang.String linkedinId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Returns the number of social profiles where companyId = &#63; and linkedinId = &#63;.
	*
	* @param companyId the company ID
	* @param linkedinId the linkedin ID
	* @return the number of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public int countByLinkedinId(long companyId, java.lang.String linkedinId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile where companyId = &#63; and yahooId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException} if it could not be found.
	*
	* @param companyId the company ID
	* @param yahooId the yahoo ID
	* @return the matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByYahooId(
		long companyId, java.lang.String yahooId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Returns the social profile where companyId = &#63; and yahooId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param yahooId the yahoo ID
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByYahooId(
		long companyId, java.lang.String yahooId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile where companyId = &#63; and yahooId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param yahooId the yahoo ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByYahooId(
		long companyId, java.lang.String yahooId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the social profile where companyId = &#63; and yahooId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param yahooId the yahoo ID
	* @return the social profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile removeByYahooId(
		long companyId, java.lang.String yahooId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Returns the number of social profiles where companyId = &#63; and yahooId = &#63;.
	*
	* @param companyId the company ID
	* @param yahooId the yahoo ID
	* @return the number of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public int countByYahooId(long companyId, java.lang.String yahooId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile where companyId = &#63; and googleId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException} if it could not be found.
	*
	* @param companyId the company ID
	* @param googleId the google ID
	* @return the matching social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByGoogleId(
		long companyId, java.lang.String googleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Returns the social profile where companyId = &#63; and googleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param googleId the google ID
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByGoogleId(
		long companyId, java.lang.String googleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile where companyId = &#63; and googleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param googleId the google ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByGoogleId(
		long companyId, java.lang.String googleId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the social profile where companyId = &#63; and googleId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param googleId the google ID
	* @return the social profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile removeByGoogleId(
		long companyId, java.lang.String googleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Returns the number of social profiles where companyId = &#63; and googleId = &#63;.
	*
	* @param companyId the company ID
	* @param googleId the google ID
	* @return the number of matching social profiles
	* @throws SystemException if a system exception occurred
	*/
	public int countByGoogleId(long companyId, java.lang.String googleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the social profile in the entity cache if it is enabled.
	*
	* @param socialProfile the social profile
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile);

	/**
	* Caches the social profiles in the entity cache if it is enabled.
	*
	* @param socialProfiles the social profiles
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> socialProfiles);

	/**
	* Creates a new social profile with the primary key. Does not add the social profile to the database.
	*
	* @param userId the primary key for the new social profile
	* @return the new social profile
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile create(
		long userId);

	/**
	* Removes the social profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the social profile
	* @return the social profile that was removed
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a social profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile remove(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile updateImpl(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile with the primary key or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException} if it could not be found.
	*
	* @param userId the primary key of the social profile
	* @return the social profile
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a social profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByPrimaryKey(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;

	/**
	* Returns the social profile with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the social profile
	* @return the social profile, or <code>null</code> if a social profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchByPrimaryKey(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the social profiles.
	*
	* @return the social profiles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the social profiles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of social profiles.
	*
	* @return the number of social profiles
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}