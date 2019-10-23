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

package com.sambaash.platform.srv.spsocialsharing.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing;

/**
 * The persistence interface for the s p social sharing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPSocialSharingPersistenceImpl
 * @see SPSocialSharingUtil
 * @generated
 */
public interface SPSocialSharingPersistence extends BasePersistence<SPSocialSharing> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPSocialSharingUtil} to access the s p social sharing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p social sharings where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching s p social sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p social sharings where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialsharing.model.impl.SPSocialSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p social sharings
	* @param end the upper bound of the range of s p social sharings (not inclusive)
	* @return the range of matching s p social sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p social sharings where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialsharing.model.impl.SPSocialSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p social sharings
	* @param end the upper bound of the range of s p social sharings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p social sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p social sharing in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p social sharing
	* @throws com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException if a matching s p social sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException;

	/**
	* Returns the first s p social sharing in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p social sharing, or <code>null</code> if a matching s p social sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p social sharing in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p social sharing
	* @throws com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException if a matching s p social sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException;

	/**
	* Returns the last s p social sharing in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p social sharing, or <code>null</code> if a matching s p social sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p social sharings before and after the current s p social sharing in the ordered set where uuid = &#63;.
	*
	* @param spSocialSharingId the primary key of the current s p social sharing
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p social sharing
	* @throws com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException if a s p social sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing[] findByUuid_PrevAndNext(
		long spSocialSharingId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException;

	/**
	* Removes all the s p social sharings where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p social sharings where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching s p social sharings
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p social sharing where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p social sharing
	* @throws com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException if a matching s p social sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException;

	/**
	* Returns the s p social sharing where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p social sharing, or <code>null</code> if a matching s p social sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p social sharing where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p social sharing, or <code>null</code> if a matching s p social sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p social sharing where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the s p social sharing that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException;

	/**
	* Returns the number of s p social sharings where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching s p social sharings
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p social sharings where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching s p social sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p social sharings where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialsharing.model.impl.SPSocialSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p social sharings
	* @param end the upper bound of the range of s p social sharings (not inclusive)
	* @return the range of matching s p social sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p social sharings where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialsharing.model.impl.SPSocialSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p social sharings
	* @param end the upper bound of the range of s p social sharings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p social sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p social sharing in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p social sharing
	* @throws com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException if a matching s p social sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException;

	/**
	* Returns the first s p social sharing in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p social sharing, or <code>null</code> if a matching s p social sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p social sharing in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p social sharing
	* @throws com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException if a matching s p social sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException;

	/**
	* Returns the last s p social sharing in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p social sharing, or <code>null</code> if a matching s p social sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p social sharings before and after the current s p social sharing in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spSocialSharingId the primary key of the current s p social sharing
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p social sharing
	* @throws com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException if a s p social sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing[] findByUuid_C_PrevAndNext(
		long spSocialSharingId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException;

	/**
	* Removes all the s p social sharings where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p social sharings where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching s p social sharings
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p social sharing where classNameId = &#63; and classPK = &#63; or throws a {@link com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException} if it could not be found.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching s p social sharing
	* @throws com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException if a matching s p social sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing findByclassNameIdAndClassPK(
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException;

	/**
	* Returns the s p social sharing where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching s p social sharing, or <code>null</code> if a matching s p social sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing fetchByclassNameIdAndClassPK(
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p social sharing where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p social sharing, or <code>null</code> if a matching s p social sharing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing fetchByclassNameIdAndClassPK(
		long classNameId, long classPK, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p social sharing where classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the s p social sharing that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing removeByclassNameIdAndClassPK(
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException;

	/**
	* Returns the number of s p social sharings where classNameId = &#63; and classPK = &#63;.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the number of matching s p social sharings
	* @throws SystemException if a system exception occurred
	*/
	public int countByclassNameIdAndClassPK(long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p social sharing in the entity cache if it is enabled.
	*
	* @param spSocialSharing the s p social sharing
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing spSocialSharing);

	/**
	* Caches the s p social sharings in the entity cache if it is enabled.
	*
	* @param spSocialSharings the s p social sharings
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing> spSocialSharings);

	/**
	* Creates a new s p social sharing with the primary key. Does not add the s p social sharing to the database.
	*
	* @param spSocialSharingId the primary key for the new s p social sharing
	* @return the new s p social sharing
	*/
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing create(
		long spSocialSharingId);

	/**
	* Removes the s p social sharing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spSocialSharingId the primary key of the s p social sharing
	* @return the s p social sharing that was removed
	* @throws com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException if a s p social sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing remove(
		long spSocialSharingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException;

	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing updateImpl(
		com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing spSocialSharing)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p social sharing with the primary key or throws a {@link com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException} if it could not be found.
	*
	* @param spSocialSharingId the primary key of the s p social sharing
	* @return the s p social sharing
	* @throws com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException if a s p social sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing findByPrimaryKey(
		long spSocialSharingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException;

	/**
	* Returns the s p social sharing with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spSocialSharingId the primary key of the s p social sharing
	* @return the s p social sharing, or <code>null</code> if a s p social sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing fetchByPrimaryKey(
		long spSocialSharingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p social sharings.
	*
	* @return the s p social sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p social sharings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialsharing.model.impl.SPSocialSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p social sharings
	* @param end the upper bound of the range of s p social sharings (not inclusive)
	* @return the range of s p social sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p social sharings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialsharing.model.impl.SPSocialSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p social sharings
	* @param end the upper bound of the range of s p social sharings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p social sharings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p social sharings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p social sharings.
	*
	* @return the number of s p social sharings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}