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

import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends;

/**
 * The persistence interface for the social profile friends service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfileFriendsPersistenceImpl
 * @see SocialProfileFriendsUtil
 * @generated
 */
public interface SocialProfileFriendsPersistence extends BasePersistence<SocialProfileFriends> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SocialProfileFriendsUtil} to access the social profile friends persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the social profile friendses where companyId = &#63; and belongsToUserId = &#63;.
	*
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @return the matching social profile friendses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends> findByUserId(
		long companyId, long belongsToUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the social profile friendses where companyId = &#63; and belongsToUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileFriendsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @param start the lower bound of the range of social profile friendses
	* @param end the upper bound of the range of social profile friendses (not inclusive)
	* @return the range of matching social profile friendses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends> findByUserId(
		long companyId, long belongsToUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the social profile friendses where companyId = &#63; and belongsToUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileFriendsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @param start the lower bound of the range of social profile friendses
	* @param end the upper bound of the range of social profile friendses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching social profile friendses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends> findByUserId(
		long companyId, long belongsToUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first social profile friends in the ordered set where companyId = &#63; and belongsToUserId = &#63;.
	*
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile friends
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException if a matching social profile friends could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends findByUserId_First(
		long companyId, long belongsToUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException;

	/**
	* Returns the first social profile friends in the ordered set where companyId = &#63; and belongsToUserId = &#63;.
	*
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile friends, or <code>null</code> if a matching social profile friends could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends fetchByUserId_First(
		long companyId, long belongsToUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last social profile friends in the ordered set where companyId = &#63; and belongsToUserId = &#63;.
	*
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile friends
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException if a matching social profile friends could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends findByUserId_Last(
		long companyId, long belongsToUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException;

	/**
	* Returns the last social profile friends in the ordered set where companyId = &#63; and belongsToUserId = &#63;.
	*
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile friends, or <code>null</code> if a matching social profile friends could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends fetchByUserId_Last(
		long companyId, long belongsToUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile friendses before and after the current social profile friends in the ordered set where companyId = &#63; and belongsToUserId = &#63;.
	*
	* @param socialProfileFriendsId the primary key of the current social profile friends
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next social profile friends
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException if a social profile friends with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends[] findByUserId_PrevAndNext(
		long socialProfileFriendsId, long companyId, long belongsToUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException;

	/**
	* Removes all the social profile friendses where companyId = &#63; and belongsToUserId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long companyId, long belongsToUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of social profile friendses where companyId = &#63; and belongsToUserId = &#63;.
	*
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @return the number of matching social profile friendses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long companyId, long belongsToUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the social profile friendses where companyId = &#63; and belongsToUserId = &#63; and socialNetworkType = &#63;.
	*
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @param socialNetworkType the social network type
	* @return the matching social profile friendses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends> findByUserIdAndSocialNetworkType(
		long companyId, long belongsToUserId, int socialNetworkType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the social profile friendses where companyId = &#63; and belongsToUserId = &#63; and socialNetworkType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileFriendsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @param socialNetworkType the social network type
	* @param start the lower bound of the range of social profile friendses
	* @param end the upper bound of the range of social profile friendses (not inclusive)
	* @return the range of matching social profile friendses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends> findByUserIdAndSocialNetworkType(
		long companyId, long belongsToUserId, int socialNetworkType, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the social profile friendses where companyId = &#63; and belongsToUserId = &#63; and socialNetworkType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileFriendsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @param socialNetworkType the social network type
	* @param start the lower bound of the range of social profile friendses
	* @param end the upper bound of the range of social profile friendses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching social profile friendses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends> findByUserIdAndSocialNetworkType(
		long companyId, long belongsToUserId, int socialNetworkType, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first social profile friends in the ordered set where companyId = &#63; and belongsToUserId = &#63; and socialNetworkType = &#63;.
	*
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @param socialNetworkType the social network type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile friends
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException if a matching social profile friends could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends findByUserIdAndSocialNetworkType_First(
		long companyId, long belongsToUserId, int socialNetworkType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException;

	/**
	* Returns the first social profile friends in the ordered set where companyId = &#63; and belongsToUserId = &#63; and socialNetworkType = &#63;.
	*
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @param socialNetworkType the social network type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile friends, or <code>null</code> if a matching social profile friends could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends fetchByUserIdAndSocialNetworkType_First(
		long companyId, long belongsToUserId, int socialNetworkType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last social profile friends in the ordered set where companyId = &#63; and belongsToUserId = &#63; and socialNetworkType = &#63;.
	*
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @param socialNetworkType the social network type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile friends
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException if a matching social profile friends could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends findByUserIdAndSocialNetworkType_Last(
		long companyId, long belongsToUserId, int socialNetworkType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException;

	/**
	* Returns the last social profile friends in the ordered set where companyId = &#63; and belongsToUserId = &#63; and socialNetworkType = &#63;.
	*
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @param socialNetworkType the social network type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile friends, or <code>null</code> if a matching social profile friends could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends fetchByUserIdAndSocialNetworkType_Last(
		long companyId, long belongsToUserId, int socialNetworkType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile friendses before and after the current social profile friends in the ordered set where companyId = &#63; and belongsToUserId = &#63; and socialNetworkType = &#63;.
	*
	* @param socialProfileFriendsId the primary key of the current social profile friends
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @param socialNetworkType the social network type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next social profile friends
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException if a social profile friends with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends[] findByUserIdAndSocialNetworkType_PrevAndNext(
		long socialProfileFriendsId, long companyId, long belongsToUserId,
		int socialNetworkType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException;

	/**
	* Removes all the social profile friendses where companyId = &#63; and belongsToUserId = &#63; and socialNetworkType = &#63; from the database.
	*
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @param socialNetworkType the social network type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserIdAndSocialNetworkType(long companyId,
		long belongsToUserId, int socialNetworkType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of social profile friendses where companyId = &#63; and belongsToUserId = &#63; and socialNetworkType = &#63;.
	*
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @param socialNetworkType the social network type
	* @return the number of matching social profile friendses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdAndSocialNetworkType(long companyId,
		long belongsToUserId, int socialNetworkType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile friends where companyId = &#63; and belongsToUserId = &#63; and socialNetworkProfileId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException} if it could not be found.
	*
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @param socialNetworkProfileId the social network profile ID
	* @return the matching social profile friends
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException if a matching social profile friends could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends findByUserIdAndSNProfileId(
		long companyId, long belongsToUserId, long socialNetworkProfileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException;

	/**
	* Returns the social profile friends where companyId = &#63; and belongsToUserId = &#63; and socialNetworkProfileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @param socialNetworkProfileId the social network profile ID
	* @return the matching social profile friends, or <code>null</code> if a matching social profile friends could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends fetchByUserIdAndSNProfileId(
		long companyId, long belongsToUserId, long socialNetworkProfileId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile friends where companyId = &#63; and belongsToUserId = &#63; and socialNetworkProfileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @param socialNetworkProfileId the social network profile ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching social profile friends, or <code>null</code> if a matching social profile friends could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends fetchByUserIdAndSNProfileId(
		long companyId, long belongsToUserId, long socialNetworkProfileId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the social profile friends where companyId = &#63; and belongsToUserId = &#63; and socialNetworkProfileId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @param socialNetworkProfileId the social network profile ID
	* @return the social profile friends that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends removeByUserIdAndSNProfileId(
		long companyId, long belongsToUserId, long socialNetworkProfileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException;

	/**
	* Returns the number of social profile friendses where companyId = &#63; and belongsToUserId = &#63; and socialNetworkProfileId = &#63;.
	*
	* @param companyId the company ID
	* @param belongsToUserId the belongs to user ID
	* @param socialNetworkProfileId the social network profile ID
	* @return the number of matching social profile friendses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdAndSNProfileId(long companyId,
		long belongsToUserId, long socialNetworkProfileId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the social profile friends in the entity cache if it is enabled.
	*
	* @param socialProfileFriends the social profile friends
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends socialProfileFriends);

	/**
	* Caches the social profile friendses in the entity cache if it is enabled.
	*
	* @param socialProfileFriendses the social profile friendses
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends> socialProfileFriendses);

	/**
	* Creates a new social profile friends with the primary key. Does not add the social profile friends to the database.
	*
	* @param socialProfileFriendsId the primary key for the new social profile friends
	* @return the new social profile friends
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends create(
		long socialProfileFriendsId);

	/**
	* Removes the social profile friends with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param socialProfileFriendsId the primary key of the social profile friends
	* @return the social profile friends that was removed
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException if a social profile friends with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends remove(
		long socialProfileFriendsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException;

	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends updateImpl(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends socialProfileFriends)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile friends with the primary key or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException} if it could not be found.
	*
	* @param socialProfileFriendsId the primary key of the social profile friends
	* @return the social profile friends
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException if a social profile friends with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends findByPrimaryKey(
		long socialProfileFriendsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException;

	/**
	* Returns the social profile friends with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param socialProfileFriendsId the primary key of the social profile friends
	* @return the social profile friends, or <code>null</code> if a social profile friends with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends fetchByPrimaryKey(
		long socialProfileFriendsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the social profile friendses.
	*
	* @return the social profile friendses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the social profile friendses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileFriendsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of social profile friendses
	* @param end the upper bound of the range of social profile friendses (not inclusive)
	* @return the range of social profile friendses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the social profile friendses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileFriendsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of social profile friendses
	* @param end the upper bound of the range of social profile friendses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of social profile friendses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the social profile friendses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of social profile friendses.
	*
	* @return the number of social profile friendses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}