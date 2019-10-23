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

package com.sambaash.platform.srv.sprating.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.sprating.model.RatingAttr;

/**
 * The persistence interface for the rating attr service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see RatingAttrPersistenceImpl
 * @see RatingAttrUtil
 * @generated
 */
public interface RatingAttrPersistence extends BasePersistence<RatingAttr> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RatingAttrUtil} to access the rating attr persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the rating attrs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sprating.model.RatingAttr> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rating attrs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of rating attrs
	* @param end the upper bound of the range of rating attrs (not inclusive)
	* @return the range of matching rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sprating.model.RatingAttr> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rating attrs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of rating attrs
	* @param end the upper bound of the range of rating attrs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sprating.model.RatingAttr> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rating attr in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rating attr
	* @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchRatingAttrException;

	/**
	* Returns the first rating attr in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rating attr, or <code>null</code> if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rating attr in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rating attr
	* @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchRatingAttrException;

	/**
	* Returns the last rating attr in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rating attr, or <code>null</code> if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rating attrs before and after the current rating attr in the ordered set where uuid = &#63;.
	*
	* @param spRatingAttrId the primary key of the current rating attr
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rating attr
	* @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a rating attr with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr[] findByUuid_PrevAndNext(
		long spRatingAttrId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchRatingAttrException;

	/**
	* Removes all the rating attrs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rating attrs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rating attr where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.sprating.NoSuchRatingAttrException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rating attr
	* @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchRatingAttrException;

	/**
	* Returns the rating attr where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rating attr, or <code>null</code> if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rating attr where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching rating attr, or <code>null</code> if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the rating attr where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the rating attr that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchRatingAttrException;

	/**
	* Returns the number of rating attrs where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rating attrs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sprating.model.RatingAttr> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rating attrs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of rating attrs
	* @param end the upper bound of the range of rating attrs (not inclusive)
	* @return the range of matching rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sprating.model.RatingAttr> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rating attrs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of rating attrs
	* @param end the upper bound of the range of rating attrs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sprating.model.RatingAttr> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rating attr in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rating attr
	* @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchRatingAttrException;

	/**
	* Returns the first rating attr in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rating attr, or <code>null</code> if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rating attr in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rating attr
	* @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchRatingAttrException;

	/**
	* Returns the last rating attr in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rating attr, or <code>null</code> if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rating attrs before and after the current rating attr in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spRatingAttrId the primary key of the current rating attr
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rating attr
	* @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a rating attr with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr[] findByUuid_C_PrevAndNext(
		long spRatingAttrId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchRatingAttrException;

	/**
	* Removes all the rating attrs where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rating attrs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rating attrs where ratingComponentId = &#63;.
	*
	* @param ratingComponentId the rating component ID
	* @return the matching rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sprating.model.RatingAttr> findByRatingComponentId_GetVisibleOnly(
		long ratingComponentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rating attrs where ratingComponentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ratingComponentId the rating component ID
	* @param start the lower bound of the range of rating attrs
	* @param end the upper bound of the range of rating attrs (not inclusive)
	* @return the range of matching rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sprating.model.RatingAttr> findByRatingComponentId_GetVisibleOnly(
		long ratingComponentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rating attrs where ratingComponentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ratingComponentId the rating component ID
	* @param start the lower bound of the range of rating attrs
	* @param end the upper bound of the range of rating attrs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sprating.model.RatingAttr> findByRatingComponentId_GetVisibleOnly(
		long ratingComponentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rating attr in the ordered set where ratingComponentId = &#63;.
	*
	* @param ratingComponentId the rating component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rating attr
	* @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr findByRatingComponentId_GetVisibleOnly_First(
		long ratingComponentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchRatingAttrException;

	/**
	* Returns the first rating attr in the ordered set where ratingComponentId = &#63;.
	*
	* @param ratingComponentId the rating component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rating attr, or <code>null</code> if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr fetchByRatingComponentId_GetVisibleOnly_First(
		long ratingComponentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rating attr in the ordered set where ratingComponentId = &#63;.
	*
	* @param ratingComponentId the rating component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rating attr
	* @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr findByRatingComponentId_GetVisibleOnly_Last(
		long ratingComponentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchRatingAttrException;

	/**
	* Returns the last rating attr in the ordered set where ratingComponentId = &#63;.
	*
	* @param ratingComponentId the rating component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rating attr, or <code>null</code> if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr fetchByRatingComponentId_GetVisibleOnly_Last(
		long ratingComponentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rating attrs before and after the current rating attr in the ordered set where ratingComponentId = &#63;.
	*
	* @param spRatingAttrId the primary key of the current rating attr
	* @param ratingComponentId the rating component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rating attr
	* @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a rating attr with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr[] findByRatingComponentId_GetVisibleOnly_PrevAndNext(
		long spRatingAttrId, long ratingComponentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchRatingAttrException;

	/**
	* Removes all the rating attrs where ratingComponentId = &#63; from the database.
	*
	* @param ratingComponentId the rating component ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRatingComponentId_GetVisibleOnly(long ratingComponentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rating attrs where ratingComponentId = &#63;.
	*
	* @param ratingComponentId the rating component ID
	* @return the number of matching rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public int countByRatingComponentId_GetVisibleOnly(long ratingComponentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rating attrs where ratingComponentId = &#63;.
	*
	* @param ratingComponentId the rating component ID
	* @return the matching rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sprating.model.RatingAttr> findByratingComponentId(
		long ratingComponentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rating attrs where ratingComponentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ratingComponentId the rating component ID
	* @param start the lower bound of the range of rating attrs
	* @param end the upper bound of the range of rating attrs (not inclusive)
	* @return the range of matching rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sprating.model.RatingAttr> findByratingComponentId(
		long ratingComponentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rating attrs where ratingComponentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ratingComponentId the rating component ID
	* @param start the lower bound of the range of rating attrs
	* @param end the upper bound of the range of rating attrs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sprating.model.RatingAttr> findByratingComponentId(
		long ratingComponentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rating attr in the ordered set where ratingComponentId = &#63;.
	*
	* @param ratingComponentId the rating component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rating attr
	* @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr findByratingComponentId_First(
		long ratingComponentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchRatingAttrException;

	/**
	* Returns the first rating attr in the ordered set where ratingComponentId = &#63;.
	*
	* @param ratingComponentId the rating component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rating attr, or <code>null</code> if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr fetchByratingComponentId_First(
		long ratingComponentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rating attr in the ordered set where ratingComponentId = &#63;.
	*
	* @param ratingComponentId the rating component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rating attr
	* @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr findByratingComponentId_Last(
		long ratingComponentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchRatingAttrException;

	/**
	* Returns the last rating attr in the ordered set where ratingComponentId = &#63;.
	*
	* @param ratingComponentId the rating component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rating attr, or <code>null</code> if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr fetchByratingComponentId_Last(
		long ratingComponentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rating attrs before and after the current rating attr in the ordered set where ratingComponentId = &#63;.
	*
	* @param spRatingAttrId the primary key of the current rating attr
	* @param ratingComponentId the rating component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rating attr
	* @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a rating attr with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr[] findByratingComponentId_PrevAndNext(
		long spRatingAttrId, long ratingComponentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchRatingAttrException;

	/**
	* Removes all the rating attrs where ratingComponentId = &#63; from the database.
	*
	* @param ratingComponentId the rating component ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByratingComponentId(long ratingComponentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rating attrs where ratingComponentId = &#63;.
	*
	* @param ratingComponentId the rating component ID
	* @return the number of matching rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public int countByratingComponentId(long ratingComponentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rating attrs where name = &#63; and ratingComponentId = &#63;.
	*
	* @param name the name
	* @param ratingComponentId the rating component ID
	* @return the matching rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sprating.model.RatingAttr> findByNameRatingComponentId(
		java.lang.String name, long ratingComponentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rating attrs where name = &#63; and ratingComponentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param ratingComponentId the rating component ID
	* @param start the lower bound of the range of rating attrs
	* @param end the upper bound of the range of rating attrs (not inclusive)
	* @return the range of matching rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sprating.model.RatingAttr> findByNameRatingComponentId(
		java.lang.String name, long ratingComponentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rating attrs where name = &#63; and ratingComponentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param ratingComponentId the rating component ID
	* @param start the lower bound of the range of rating attrs
	* @param end the upper bound of the range of rating attrs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sprating.model.RatingAttr> findByNameRatingComponentId(
		java.lang.String name, long ratingComponentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rating attr in the ordered set where name = &#63; and ratingComponentId = &#63;.
	*
	* @param name the name
	* @param ratingComponentId the rating component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rating attr
	* @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr findByNameRatingComponentId_First(
		java.lang.String name, long ratingComponentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchRatingAttrException;

	/**
	* Returns the first rating attr in the ordered set where name = &#63; and ratingComponentId = &#63;.
	*
	* @param name the name
	* @param ratingComponentId the rating component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rating attr, or <code>null</code> if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr fetchByNameRatingComponentId_First(
		java.lang.String name, long ratingComponentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rating attr in the ordered set where name = &#63; and ratingComponentId = &#63;.
	*
	* @param name the name
	* @param ratingComponentId the rating component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rating attr
	* @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr findByNameRatingComponentId_Last(
		java.lang.String name, long ratingComponentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchRatingAttrException;

	/**
	* Returns the last rating attr in the ordered set where name = &#63; and ratingComponentId = &#63;.
	*
	* @param name the name
	* @param ratingComponentId the rating component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rating attr, or <code>null</code> if a matching rating attr could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr fetchByNameRatingComponentId_Last(
		java.lang.String name, long ratingComponentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rating attrs before and after the current rating attr in the ordered set where name = &#63; and ratingComponentId = &#63;.
	*
	* @param spRatingAttrId the primary key of the current rating attr
	* @param name the name
	* @param ratingComponentId the rating component ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rating attr
	* @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a rating attr with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr[] findByNameRatingComponentId_PrevAndNext(
		long spRatingAttrId, java.lang.String name, long ratingComponentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchRatingAttrException;

	/**
	* Removes all the rating attrs where name = &#63; and ratingComponentId = &#63; from the database.
	*
	* @param name the name
	* @param ratingComponentId the rating component ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNameRatingComponentId(java.lang.String name,
		long ratingComponentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rating attrs where name = &#63; and ratingComponentId = &#63;.
	*
	* @param name the name
	* @param ratingComponentId the rating component ID
	* @return the number of matching rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public int countByNameRatingComponentId(java.lang.String name,
		long ratingComponentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the rating attr in the entity cache if it is enabled.
	*
	* @param ratingAttr the rating attr
	*/
	public void cacheResult(
		com.sambaash.platform.srv.sprating.model.RatingAttr ratingAttr);

	/**
	* Caches the rating attrs in the entity cache if it is enabled.
	*
	* @param ratingAttrs the rating attrs
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.sprating.model.RatingAttr> ratingAttrs);

	/**
	* Creates a new rating attr with the primary key. Does not add the rating attr to the database.
	*
	* @param spRatingAttrId the primary key for the new rating attr
	* @return the new rating attr
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr create(
		long spRatingAttrId);

	/**
	* Removes the rating attr with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spRatingAttrId the primary key of the rating attr
	* @return the rating attr that was removed
	* @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a rating attr with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr remove(
		long spRatingAttrId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchRatingAttrException;

	public com.sambaash.platform.srv.sprating.model.RatingAttr updateImpl(
		com.sambaash.platform.srv.sprating.model.RatingAttr ratingAttr)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rating attr with the primary key or throws a {@link com.sambaash.platform.srv.sprating.NoSuchRatingAttrException} if it could not be found.
	*
	* @param spRatingAttrId the primary key of the rating attr
	* @return the rating attr
	* @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a rating attr with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr findByPrimaryKey(
		long spRatingAttrId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.sprating.NoSuchRatingAttrException;

	/**
	* Returns the rating attr with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spRatingAttrId the primary key of the rating attr
	* @return the rating attr, or <code>null</code> if a rating attr with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.sprating.model.RatingAttr fetchByPrimaryKey(
		long spRatingAttrId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rating attrs.
	*
	* @return the rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sprating.model.RatingAttr> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rating attrs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rating attrs
	* @param end the upper bound of the range of rating attrs (not inclusive)
	* @return the range of rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sprating.model.RatingAttr> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rating attrs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rating attrs
	* @param end the upper bound of the range of rating attrs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.sprating.model.RatingAttr> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rating attrs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rating attrs.
	*
	* @return the number of rating attrs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}