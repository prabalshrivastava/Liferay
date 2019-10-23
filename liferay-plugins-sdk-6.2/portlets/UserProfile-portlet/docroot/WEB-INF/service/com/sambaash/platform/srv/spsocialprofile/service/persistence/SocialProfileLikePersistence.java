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

import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike;

/**
 * The persistence interface for the social profile like service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfileLikePersistenceImpl
 * @see SocialProfileLikeUtil
 * @generated
 */
public interface SocialProfileLikePersistence extends BasePersistence<SocialProfileLike> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SocialProfileLikeUtil} to access the social profile like persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the social profile likes where socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	*
	* @param socialNetworkProfileId the social network profile ID
	* @param socialNetworkType the social network type
	* @return the matching social profile likes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike> findBySocialNetworkProfileId(
		long socialNetworkProfileId, int socialNetworkType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the social profile likes where socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileLikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param socialNetworkProfileId the social network profile ID
	* @param socialNetworkType the social network type
	* @param start the lower bound of the range of social profile likes
	* @param end the upper bound of the range of social profile likes (not inclusive)
	* @return the range of matching social profile likes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike> findBySocialNetworkProfileId(
		long socialNetworkProfileId, int socialNetworkType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the social profile likes where socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileLikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param socialNetworkProfileId the social network profile ID
	* @param socialNetworkType the social network type
	* @param start the lower bound of the range of social profile likes
	* @param end the upper bound of the range of social profile likes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching social profile likes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike> findBySocialNetworkProfileId(
		long socialNetworkProfileId, int socialNetworkType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first social profile like in the ordered set where socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	*
	* @param socialNetworkProfileId the social network profile ID
	* @param socialNetworkType the social network type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile like
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException if a matching social profile like could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike findBySocialNetworkProfileId_First(
		long socialNetworkProfileId, int socialNetworkType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException;

	/**
	* Returns the first social profile like in the ordered set where socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	*
	* @param socialNetworkProfileId the social network profile ID
	* @param socialNetworkType the social network type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile like, or <code>null</code> if a matching social profile like could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike fetchBySocialNetworkProfileId_First(
		long socialNetworkProfileId, int socialNetworkType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last social profile like in the ordered set where socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	*
	* @param socialNetworkProfileId the social network profile ID
	* @param socialNetworkType the social network type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile like
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException if a matching social profile like could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike findBySocialNetworkProfileId_Last(
		long socialNetworkProfileId, int socialNetworkType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException;

	/**
	* Returns the last social profile like in the ordered set where socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	*
	* @param socialNetworkProfileId the social network profile ID
	* @param socialNetworkType the social network type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile like, or <code>null</code> if a matching social profile like could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike fetchBySocialNetworkProfileId_Last(
		long socialNetworkProfileId, int socialNetworkType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile likes before and after the current social profile like in the ordered set where socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	*
	* @param socialProfileLikeId the primary key of the current social profile like
	* @param socialNetworkProfileId the social network profile ID
	* @param socialNetworkType the social network type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next social profile like
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException if a social profile like with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike[] findBySocialNetworkProfileId_PrevAndNext(
		long socialProfileLikeId, long socialNetworkProfileId,
		int socialNetworkType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException;

	/**
	* Removes all the social profile likes where socialNetworkProfileId = &#63; and socialNetworkType = &#63; from the database.
	*
	* @param socialNetworkProfileId the social network profile ID
	* @param socialNetworkType the social network type
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySocialNetworkProfileId(long socialNetworkProfileId,
		int socialNetworkType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of social profile likes where socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	*
	* @param socialNetworkProfileId the social network profile ID
	* @param socialNetworkType the social network type
	* @return the number of matching social profile likes
	* @throws SystemException if a system exception occurred
	*/
	public int countBySocialNetworkProfileId(long socialNetworkProfileId,
		int socialNetworkType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile like where socialNetworkLikeId = &#63; and socialNetworkProfileId = &#63; and socialNetworkType = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException} if it could not be found.
	*
	* @param socialNetworkLikeId the social network like ID
	* @param socialNetworkProfileId the social network profile ID
	* @param socialNetworkType the social network type
	* @return the matching social profile like
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException if a matching social profile like could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike findByLikeIdAndSocialNetworkProfileId(
		long socialNetworkLikeId, long socialNetworkProfileId,
		int socialNetworkType)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException;

	/**
	* Returns the social profile like where socialNetworkLikeId = &#63; and socialNetworkProfileId = &#63; and socialNetworkType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param socialNetworkLikeId the social network like ID
	* @param socialNetworkProfileId the social network profile ID
	* @param socialNetworkType the social network type
	* @return the matching social profile like, or <code>null</code> if a matching social profile like could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike fetchByLikeIdAndSocialNetworkProfileId(
		long socialNetworkLikeId, long socialNetworkProfileId,
		int socialNetworkType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile like where socialNetworkLikeId = &#63; and socialNetworkProfileId = &#63; and socialNetworkType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param socialNetworkLikeId the social network like ID
	* @param socialNetworkProfileId the social network profile ID
	* @param socialNetworkType the social network type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching social profile like, or <code>null</code> if a matching social profile like could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike fetchByLikeIdAndSocialNetworkProfileId(
		long socialNetworkLikeId, long socialNetworkProfileId,
		int socialNetworkType, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the social profile like where socialNetworkLikeId = &#63; and socialNetworkProfileId = &#63; and socialNetworkType = &#63; from the database.
	*
	* @param socialNetworkLikeId the social network like ID
	* @param socialNetworkProfileId the social network profile ID
	* @param socialNetworkType the social network type
	* @return the social profile like that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike removeByLikeIdAndSocialNetworkProfileId(
		long socialNetworkLikeId, long socialNetworkProfileId,
		int socialNetworkType)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException;

	/**
	* Returns the number of social profile likes where socialNetworkLikeId = &#63; and socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	*
	* @param socialNetworkLikeId the social network like ID
	* @param socialNetworkProfileId the social network profile ID
	* @param socialNetworkType the social network type
	* @return the number of matching social profile likes
	* @throws SystemException if a system exception occurred
	*/
	public int countByLikeIdAndSocialNetworkProfileId(
		long socialNetworkLikeId, long socialNetworkProfileId,
		int socialNetworkType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the social profile like in the entity cache if it is enabled.
	*
	* @param socialProfileLike the social profile like
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike socialProfileLike);

	/**
	* Caches the social profile likes in the entity cache if it is enabled.
	*
	* @param socialProfileLikes the social profile likes
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike> socialProfileLikes);

	/**
	* Creates a new social profile like with the primary key. Does not add the social profile like to the database.
	*
	* @param socialProfileLikeId the primary key for the new social profile like
	* @return the new social profile like
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike create(
		long socialProfileLikeId);

	/**
	* Removes the social profile like with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param socialProfileLikeId the primary key of the social profile like
	* @return the social profile like that was removed
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException if a social profile like with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike remove(
		long socialProfileLikeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException;

	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike updateImpl(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike socialProfileLike)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile like with the primary key or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException} if it could not be found.
	*
	* @param socialProfileLikeId the primary key of the social profile like
	* @return the social profile like
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException if a social profile like with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike findByPrimaryKey(
		long socialProfileLikeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException;

	/**
	* Returns the social profile like with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param socialProfileLikeId the primary key of the social profile like
	* @return the social profile like, or <code>null</code> if a social profile like with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike fetchByPrimaryKey(
		long socialProfileLikeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the social profile likes.
	*
	* @return the social profile likes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the social profile likes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileLikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of social profile likes
	* @param end the upper bound of the range of social profile likes (not inclusive)
	* @return the range of social profile likes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the social profile likes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileLikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of social profile likes
	* @param end the upper bound of the range of social profile likes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of social profile likes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the social profile likes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of social profile likes.
	*
	* @return the number of social profile likes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}