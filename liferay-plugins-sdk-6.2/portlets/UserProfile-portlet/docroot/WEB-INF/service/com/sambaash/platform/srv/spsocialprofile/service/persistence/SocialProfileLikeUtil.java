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

import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike;

import java.util.List;

/**
 * The persistence utility for the social profile like service. This utility wraps {@link SocialProfileLikePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfileLikePersistence
 * @see SocialProfileLikePersistenceImpl
 * @generated
 */
public class SocialProfileLikeUtil {
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
	public static void clearCache(SocialProfileLike socialProfileLike) {
		getPersistence().clearCache(socialProfileLike);
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
	public static List<SocialProfileLike> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SocialProfileLike> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SocialProfileLike> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SocialProfileLike update(SocialProfileLike socialProfileLike)
		throws SystemException {
		return getPersistence().update(socialProfileLike);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SocialProfileLike update(
		SocialProfileLike socialProfileLike, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(socialProfileLike, serviceContext);
	}

	/**
	* Returns all the social profile likes where socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	*
	* @param socialNetworkProfileId the social network profile ID
	* @param socialNetworkType the social network type
	* @return the matching social profile likes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike> findBySocialNetworkProfileId(
		long socialNetworkProfileId, int socialNetworkType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySocialNetworkProfileId(socialNetworkProfileId,
			socialNetworkType);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike> findBySocialNetworkProfileId(
		long socialNetworkProfileId, int socialNetworkType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySocialNetworkProfileId(socialNetworkProfileId,
			socialNetworkType, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike> findBySocialNetworkProfileId(
		long socialNetworkProfileId, int socialNetworkType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySocialNetworkProfileId(socialNetworkProfileId,
			socialNetworkType, start, end, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike findBySocialNetworkProfileId_First(
		long socialNetworkProfileId, int socialNetworkType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException {
		return getPersistence()
				   .findBySocialNetworkProfileId_First(socialNetworkProfileId,
			socialNetworkType, orderByComparator);
	}

	/**
	* Returns the first social profile like in the ordered set where socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	*
	* @param socialNetworkProfileId the social network profile ID
	* @param socialNetworkType the social network type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile like, or <code>null</code> if a matching social profile like could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike fetchBySocialNetworkProfileId_First(
		long socialNetworkProfileId, int socialNetworkType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySocialNetworkProfileId_First(socialNetworkProfileId,
			socialNetworkType, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike findBySocialNetworkProfileId_Last(
		long socialNetworkProfileId, int socialNetworkType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException {
		return getPersistence()
				   .findBySocialNetworkProfileId_Last(socialNetworkProfileId,
			socialNetworkType, orderByComparator);
	}

	/**
	* Returns the last social profile like in the ordered set where socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	*
	* @param socialNetworkProfileId the social network profile ID
	* @param socialNetworkType the social network type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile like, or <code>null</code> if a matching social profile like could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike fetchBySocialNetworkProfileId_Last(
		long socialNetworkProfileId, int socialNetworkType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySocialNetworkProfileId_Last(socialNetworkProfileId,
			socialNetworkType, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike[] findBySocialNetworkProfileId_PrevAndNext(
		long socialProfileLikeId, long socialNetworkProfileId,
		int socialNetworkType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException {
		return getPersistence()
				   .findBySocialNetworkProfileId_PrevAndNext(socialProfileLikeId,
			socialNetworkProfileId, socialNetworkType, orderByComparator);
	}

	/**
	* Removes all the social profile likes where socialNetworkProfileId = &#63; and socialNetworkType = &#63; from the database.
	*
	* @param socialNetworkProfileId the social network profile ID
	* @param socialNetworkType the social network type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySocialNetworkProfileId(
		long socialNetworkProfileId, int socialNetworkType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeBySocialNetworkProfileId(socialNetworkProfileId,
			socialNetworkType);
	}

	/**
	* Returns the number of social profile likes where socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	*
	* @param socialNetworkProfileId the social network profile ID
	* @param socialNetworkType the social network type
	* @return the number of matching social profile likes
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySocialNetworkProfileId(
		long socialNetworkProfileId, int socialNetworkType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBySocialNetworkProfileId(socialNetworkProfileId,
			socialNetworkType);
	}

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
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike findByLikeIdAndSocialNetworkProfileId(
		long socialNetworkLikeId, long socialNetworkProfileId,
		int socialNetworkType)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException {
		return getPersistence()
				   .findByLikeIdAndSocialNetworkProfileId(socialNetworkLikeId,
			socialNetworkProfileId, socialNetworkType);
	}

	/**
	* Returns the social profile like where socialNetworkLikeId = &#63; and socialNetworkProfileId = &#63; and socialNetworkType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param socialNetworkLikeId the social network like ID
	* @param socialNetworkProfileId the social network profile ID
	* @param socialNetworkType the social network type
	* @return the matching social profile like, or <code>null</code> if a matching social profile like could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike fetchByLikeIdAndSocialNetworkProfileId(
		long socialNetworkLikeId, long socialNetworkProfileId,
		int socialNetworkType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLikeIdAndSocialNetworkProfileId(socialNetworkLikeId,
			socialNetworkProfileId, socialNetworkType);
	}

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
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike fetchByLikeIdAndSocialNetworkProfileId(
		long socialNetworkLikeId, long socialNetworkProfileId,
		int socialNetworkType, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLikeIdAndSocialNetworkProfileId(socialNetworkLikeId,
			socialNetworkProfileId, socialNetworkType, retrieveFromCache);
	}

	/**
	* Removes the social profile like where socialNetworkLikeId = &#63; and socialNetworkProfileId = &#63; and socialNetworkType = &#63; from the database.
	*
	* @param socialNetworkLikeId the social network like ID
	* @param socialNetworkProfileId the social network profile ID
	* @param socialNetworkType the social network type
	* @return the social profile like that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike removeByLikeIdAndSocialNetworkProfileId(
		long socialNetworkLikeId, long socialNetworkProfileId,
		int socialNetworkType)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException {
		return getPersistence()
				   .removeByLikeIdAndSocialNetworkProfileId(socialNetworkLikeId,
			socialNetworkProfileId, socialNetworkType);
	}

	/**
	* Returns the number of social profile likes where socialNetworkLikeId = &#63; and socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	*
	* @param socialNetworkLikeId the social network like ID
	* @param socialNetworkProfileId the social network profile ID
	* @param socialNetworkType the social network type
	* @return the number of matching social profile likes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLikeIdAndSocialNetworkProfileId(
		long socialNetworkLikeId, long socialNetworkProfileId,
		int socialNetworkType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByLikeIdAndSocialNetworkProfileId(socialNetworkLikeId,
			socialNetworkProfileId, socialNetworkType);
	}

	/**
	* Caches the social profile like in the entity cache if it is enabled.
	*
	* @param socialProfileLike the social profile like
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike socialProfileLike) {
		getPersistence().cacheResult(socialProfileLike);
	}

	/**
	* Caches the social profile likes in the entity cache if it is enabled.
	*
	* @param socialProfileLikes the social profile likes
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike> socialProfileLikes) {
		getPersistence().cacheResult(socialProfileLikes);
	}

	/**
	* Creates a new social profile like with the primary key. Does not add the social profile like to the database.
	*
	* @param socialProfileLikeId the primary key for the new social profile like
	* @return the new social profile like
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike create(
		long socialProfileLikeId) {
		return getPersistence().create(socialProfileLikeId);
	}

	/**
	* Removes the social profile like with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param socialProfileLikeId the primary key of the social profile like
	* @return the social profile like that was removed
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException if a social profile like with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike remove(
		long socialProfileLikeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException {
		return getPersistence().remove(socialProfileLikeId);
	}

	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike updateImpl(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike socialProfileLike)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(socialProfileLike);
	}

	/**
	* Returns the social profile like with the primary key or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException} if it could not be found.
	*
	* @param socialProfileLikeId the primary key of the social profile like
	* @return the social profile like
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException if a social profile like with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike findByPrimaryKey(
		long socialProfileLikeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException {
		return getPersistence().findByPrimaryKey(socialProfileLikeId);
	}

	/**
	* Returns the social profile like with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param socialProfileLikeId the primary key of the social profile like
	* @return the social profile like, or <code>null</code> if a social profile like with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike fetchByPrimaryKey(
		long socialProfileLikeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(socialProfileLikeId);
	}

	/**
	* Returns all the social profile likes.
	*
	* @return the social profile likes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the social profile likes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of social profile likes.
	*
	* @return the number of social profile likes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SocialProfileLikePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SocialProfileLikePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spsocialprofile.service.ClpSerializer.getServletContextName(),
					SocialProfileLikePersistence.class.getName());

			ReferenceRegistry.registerReference(SocialProfileLikeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SocialProfileLikePersistence persistence) {
	}

	private static SocialProfileLikePersistence _persistence;
}