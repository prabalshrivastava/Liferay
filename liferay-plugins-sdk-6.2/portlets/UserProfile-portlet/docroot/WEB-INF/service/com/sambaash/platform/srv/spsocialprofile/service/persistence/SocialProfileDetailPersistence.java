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

import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail;

/**
 * The persistence interface for the social profile detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfileDetailPersistenceImpl
 * @see SocialProfileDetailUtil
 * @generated
 */
public interface SocialProfileDetailPersistence extends BasePersistence<SocialProfileDetail> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SocialProfileDetailUtil} to access the social profile detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the social profile details where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching social profile details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the social profile details where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of social profile details
	* @param end the upper bound of the range of social profile details (not inclusive)
	* @return the range of matching social profile details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the social profile details where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of social profile details
	* @param end the upper bound of the range of social profile details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching social profile details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first social profile detail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile detail
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException;

	/**
	* Returns the first social profile detail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last social profile detail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile detail
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException;

	/**
	* Returns the last social profile detail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile details before and after the current social profile detail in the ordered set where uuid = &#63;.
	*
	* @param socialProfileDetailId the primary key of the current social profile detail
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next social profile detail
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a social profile detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail[] findByUuid_PrevAndNext(
		long socialProfileDetailId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException;

	/**
	* Removes all the social profile details where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of social profile details where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching social profile details
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile detail where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching social profile detail
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException;

	/**
	* Returns the social profile detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the social profile detail where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the social profile detail that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException;

	/**
	* Returns the number of social profile details where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching social profile details
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the social profile details where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching social profile details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the social profile details where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of social profile details
	* @param end the upper bound of the range of social profile details (not inclusive)
	* @return the range of matching social profile details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the social profile details where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of social profile details
	* @param end the upper bound of the range of social profile details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching social profile details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first social profile detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile detail
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException;

	/**
	* Returns the first social profile detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last social profile detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile detail
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException;

	/**
	* Returns the last social profile detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile details before and after the current social profile detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param socialProfileDetailId the primary key of the current social profile detail
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next social profile detail
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a social profile detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail[] findByUuid_C_PrevAndNext(
		long socialProfileDetailId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException;

	/**
	* Removes all the social profile details where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of social profile details where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching social profile details
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the social profile details where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching social profile details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the social profile details where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of social profile details
	* @param end the upper bound of the range of social profile details (not inclusive)
	* @return the range of matching social profile details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the social profile details where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of social profile details
	* @param end the upper bound of the range of social profile details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching social profile details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first social profile detail in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile detail
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException;

	/**
	* Returns the first social profile detail in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last social profile detail in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile detail
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException;

	/**
	* Returns the last social profile detail in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile details before and after the current social profile detail in the ordered set where userId = &#63;.
	*
	* @param socialProfileDetailId the primary key of the current social profile detail
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next social profile detail
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a social profile detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail[] findByUserId_PrevAndNext(
		long socialProfileDetailId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException;

	/**
	* Removes all the social profile details where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of social profile details where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching social profile details
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile detail where userJobId = &#63; and userId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException} if it could not be found.
	*
	* @param userJobId the user job ID
	* @param userId the user ID
	* @return the matching social profile detail
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail findByUserIdAndUserJobId(
		java.lang.String userJobId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException;

	/**
	* Returns the social profile detail where userJobId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userJobId the user job ID
	* @param userId the user ID
	* @return the matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail fetchByUserIdAndUserJobId(
		java.lang.String userJobId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile detail where userJobId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userJobId the user job ID
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail fetchByUserIdAndUserJobId(
		java.lang.String userJobId, long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the social profile detail where userJobId = &#63; and userId = &#63; from the database.
	*
	* @param userJobId the user job ID
	* @param userId the user ID
	* @return the social profile detail that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail removeByUserIdAndUserJobId(
		java.lang.String userJobId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException;

	/**
	* Returns the number of social profile details where userJobId = &#63; and userId = &#63;.
	*
	* @param userJobId the user job ID
	* @param userId the user ID
	* @return the number of matching social profile details
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdAndUserJobId(java.lang.String userJobId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile detail where companyName = &#63; and userId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException} if it could not be found.
	*
	* @param companyName the company name
	* @param userId the user ID
	* @return the matching social profile detail
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail findByUserIdAndCompanyName(
		java.lang.String companyName, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException;

	/**
	* Returns the social profile detail where companyName = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyName the company name
	* @param userId the user ID
	* @return the matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail fetchByUserIdAndCompanyName(
		java.lang.String companyName, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile detail where companyName = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyName the company name
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail fetchByUserIdAndCompanyName(
		java.lang.String companyName, long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the social profile detail where companyName = &#63; and userId = &#63; from the database.
	*
	* @param companyName the company name
	* @param userId the user ID
	* @return the social profile detail that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail removeByUserIdAndCompanyName(
		java.lang.String companyName, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException;

	/**
	* Returns the number of social profile details where companyName = &#63; and userId = &#63;.
	*
	* @param companyName the company name
	* @param userId the user ID
	* @return the number of matching social profile details
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdAndCompanyName(java.lang.String companyName,
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the social profile detail in the entity cache if it is enabled.
	*
	* @param socialProfileDetail the social profile detail
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail socialProfileDetail);

	/**
	* Caches the social profile details in the entity cache if it is enabled.
	*
	* @param socialProfileDetails the social profile details
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail> socialProfileDetails);

	/**
	* Creates a new social profile detail with the primary key. Does not add the social profile detail to the database.
	*
	* @param socialProfileDetailId the primary key for the new social profile detail
	* @return the new social profile detail
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail create(
		long socialProfileDetailId);

	/**
	* Removes the social profile detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param socialProfileDetailId the primary key of the social profile detail
	* @return the social profile detail that was removed
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a social profile detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail remove(
		long socialProfileDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException;

	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail updateImpl(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail socialProfileDetail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the social profile detail with the primary key or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException} if it could not be found.
	*
	* @param socialProfileDetailId the primary key of the social profile detail
	* @return the social profile detail
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a social profile detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail findByPrimaryKey(
		long socialProfileDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException;

	/**
	* Returns the social profile detail with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param socialProfileDetailId the primary key of the social profile detail
	* @return the social profile detail, or <code>null</code> if a social profile detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail fetchByPrimaryKey(
		long socialProfileDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the social profile details.
	*
	* @return the social profile details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the social profile details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of social profile details
	* @param end the upper bound of the range of social profile details (not inclusive)
	* @return the range of social profile details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the social profile details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of social profile details
	* @param end the upper bound of the range of social profile details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of social profile details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the social profile details from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of social profile details.
	*
	* @return the number of social profile details
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}