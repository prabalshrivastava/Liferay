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

import com.sambaash.platform.srv.spservices.model.SPSite;

/**
 * The persistence interface for the s p site service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPSitePersistenceImpl
 * @see SPSiteUtil
 * @generated
 */
public interface SPSitePersistence extends BasePersistence<SPSite> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPSiteUtil} to access the s p site persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p sites where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching s p sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p sites where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p sites
	* @param end the upper bound of the range of s p sites (not inclusive)
	* @return the range of matching s p sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p sites where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p sites
	* @param end the upper bound of the range of s p sites (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p site in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteException;

	/**
	* Returns the first s p site in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site, or <code>null</code> if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p site in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteException;

	/**
	* Returns the last s p site in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site, or <code>null</code> if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p sites before and after the current s p site in the ordered set where uuid = &#63;.
	*
	* @param spSiteId the primary key of the current s p site
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p site
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a s p site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite[] findByUuid_PrevAndNext(
		long spSiteId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteException;

	/**
	* Removes all the s p sites where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p sites where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching s p sites
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p site where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPSiteException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p site
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteException;

	/**
	* Returns the s p site where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p site, or <code>null</code> if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p site where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p site, or <code>null</code> if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p site where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the s p site that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteException;

	/**
	* Returns the number of s p sites where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching s p sites
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p sites where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching s p sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p sites where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p sites
	* @param end the upper bound of the range of s p sites (not inclusive)
	* @return the range of matching s p sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p sites where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p sites
	* @param end the upper bound of the range of s p sites (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p site in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteException;

	/**
	* Returns the first s p site in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site, or <code>null</code> if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p site in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteException;

	/**
	* Returns the last s p site in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site, or <code>null</code> if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p sites before and after the current s p site in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spSiteId the primary key of the current s p site
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p site
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a s p site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite[] findByUuid_C_PrevAndNext(
		long spSiteId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteException;

	/**
	* Removes all the s p sites where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p sites where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching s p sites
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p sites where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching s p sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p sites where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of s p sites
	* @param end the upper bound of the range of s p sites (not inclusive)
	* @return the range of matching s p sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p sites where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of s p sites
	* @param end the upper bound of the range of s p sites (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p site in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteException;

	/**
	* Returns the first s p site in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site, or <code>null</code> if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p site in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteException;

	/**
	* Returns the last s p site in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site, or <code>null</code> if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p sites before and after the current s p site in the ordered set where userId = &#63;.
	*
	* @param spSiteId the primary key of the current s p site
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p site
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a s p site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite[] findByUserId_PrevAndNext(
		long spSiteId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteException;

	/**
	* Removes all the s p sites where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p sites where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching s p sites
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p sites where userId = &#63; and virtualHostId = &#63;.
	*
	* @param userId the user ID
	* @param virtualHostId the virtual host ID
	* @return the matching s p sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> findByUserIdAndVirtualHostId(
		long userId, long virtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p sites where userId = &#63; and virtualHostId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param virtualHostId the virtual host ID
	* @param start the lower bound of the range of s p sites
	* @param end the upper bound of the range of s p sites (not inclusive)
	* @return the range of matching s p sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> findByUserIdAndVirtualHostId(
		long userId, long virtualHostId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p sites where userId = &#63; and virtualHostId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param virtualHostId the virtual host ID
	* @param start the lower bound of the range of s p sites
	* @param end the upper bound of the range of s p sites (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> findByUserIdAndVirtualHostId(
		long userId, long virtualHostId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p site in the ordered set where userId = &#63; and virtualHostId = &#63;.
	*
	* @param userId the user ID
	* @param virtualHostId the virtual host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite findByUserIdAndVirtualHostId_First(
		long userId, long virtualHostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteException;

	/**
	* Returns the first s p site in the ordered set where userId = &#63; and virtualHostId = &#63;.
	*
	* @param userId the user ID
	* @param virtualHostId the virtual host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site, or <code>null</code> if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite fetchByUserIdAndVirtualHostId_First(
		long userId, long virtualHostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p site in the ordered set where userId = &#63; and virtualHostId = &#63;.
	*
	* @param userId the user ID
	* @param virtualHostId the virtual host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite findByUserIdAndVirtualHostId_Last(
		long userId, long virtualHostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteException;

	/**
	* Returns the last s p site in the ordered set where userId = &#63; and virtualHostId = &#63;.
	*
	* @param userId the user ID
	* @param virtualHostId the virtual host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site, or <code>null</code> if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite fetchByUserIdAndVirtualHostId_Last(
		long userId, long virtualHostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p sites before and after the current s p site in the ordered set where userId = &#63; and virtualHostId = &#63;.
	*
	* @param spSiteId the primary key of the current s p site
	* @param userId the user ID
	* @param virtualHostId the virtual host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p site
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a s p site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite[] findByUserIdAndVirtualHostId_PrevAndNext(
		long spSiteId, long userId, long virtualHostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteException;

	/**
	* Removes all the s p sites where userId = &#63; and virtualHostId = &#63; from the database.
	*
	* @param userId the user ID
	* @param virtualHostId the virtual host ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserIdAndVirtualHostId(long userId, long virtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p sites where userId = &#63; and virtualHostId = &#63;.
	*
	* @param userId the user ID
	* @param virtualHostId the virtual host ID
	* @return the number of matching s p sites
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdAndVirtualHostId(long userId, long virtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p sites where userId = &#63; and authAccessId = &#63;.
	*
	* @param userId the user ID
	* @param authAccessId the auth access ID
	* @return the matching s p sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> findByUserIdAndAuthAccessId(
		long userId, long authAccessId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p sites where userId = &#63; and authAccessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param authAccessId the auth access ID
	* @param start the lower bound of the range of s p sites
	* @param end the upper bound of the range of s p sites (not inclusive)
	* @return the range of matching s p sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> findByUserIdAndAuthAccessId(
		long userId, long authAccessId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p sites where userId = &#63; and authAccessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param authAccessId the auth access ID
	* @param start the lower bound of the range of s p sites
	* @param end the upper bound of the range of s p sites (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> findByUserIdAndAuthAccessId(
		long userId, long authAccessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p site in the ordered set where userId = &#63; and authAccessId = &#63;.
	*
	* @param userId the user ID
	* @param authAccessId the auth access ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite findByUserIdAndAuthAccessId_First(
		long userId, long authAccessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteException;

	/**
	* Returns the first s p site in the ordered set where userId = &#63; and authAccessId = &#63;.
	*
	* @param userId the user ID
	* @param authAccessId the auth access ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p site, or <code>null</code> if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite fetchByUserIdAndAuthAccessId_First(
		long userId, long authAccessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p site in the ordered set where userId = &#63; and authAccessId = &#63;.
	*
	* @param userId the user ID
	* @param authAccessId the auth access ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite findByUserIdAndAuthAccessId_Last(
		long userId, long authAccessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteException;

	/**
	* Returns the last s p site in the ordered set where userId = &#63; and authAccessId = &#63;.
	*
	* @param userId the user ID
	* @param authAccessId the auth access ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p site, or <code>null</code> if a matching s p site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite fetchByUserIdAndAuthAccessId_Last(
		long userId, long authAccessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p sites before and after the current s p site in the ordered set where userId = &#63; and authAccessId = &#63;.
	*
	* @param spSiteId the primary key of the current s p site
	* @param userId the user ID
	* @param authAccessId the auth access ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p site
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a s p site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite[] findByUserIdAndAuthAccessId_PrevAndNext(
		long spSiteId, long userId, long authAccessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteException;

	/**
	* Removes all the s p sites where userId = &#63; and authAccessId = &#63; from the database.
	*
	* @param userId the user ID
	* @param authAccessId the auth access ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserIdAndAuthAccessId(long userId, long authAccessId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p sites where userId = &#63; and authAccessId = &#63;.
	*
	* @param userId the user ID
	* @param authAccessId the auth access ID
	* @return the number of matching s p sites
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdAndAuthAccessId(long userId, long authAccessId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p site in the entity cache if it is enabled.
	*
	* @param spSite the s p site
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spservices.model.SPSite spSite);

	/**
	* Caches the s p sites in the entity cache if it is enabled.
	*
	* @param spSites the s p sites
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> spSites);

	/**
	* Creates a new s p site with the primary key. Does not add the s p site to the database.
	*
	* @param spSiteId the primary key for the new s p site
	* @return the new s p site
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite create(
		long spSiteId);

	/**
	* Removes the s p site with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spSiteId the primary key of the s p site
	* @return the s p site that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a s p site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite remove(
		long spSiteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteException;

	public com.sambaash.platform.srv.spservices.model.SPSite updateImpl(
		com.sambaash.platform.srv.spservices.model.SPSite spSite)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p site with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPSiteException} if it could not be found.
	*
	* @param spSiteId the primary key of the s p site
	* @return the s p site
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a s p site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite findByPrimaryKey(
		long spSiteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPSiteException;

	/**
	* Returns the s p site with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spSiteId the primary key of the s p site
	* @return the s p site, or <code>null</code> if a s p site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPSite fetchByPrimaryKey(
		long spSiteId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p sites.
	*
	* @return the s p sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p sites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p sites
	* @param end the upper bound of the range of s p sites (not inclusive)
	* @return the range of s p sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p sites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p sites
	* @param end the upper bound of the range of s p sites (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPSite> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p sites from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p sites.
	*
	* @return the number of s p sites
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}