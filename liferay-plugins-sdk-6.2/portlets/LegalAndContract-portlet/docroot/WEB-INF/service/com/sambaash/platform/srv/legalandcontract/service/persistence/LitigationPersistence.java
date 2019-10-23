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

package com.sambaash.platform.srv.legalandcontract.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.legalandcontract.model.Litigation;

/**
 * The persistence interface for the litigation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see LitigationPersistenceImpl
 * @see LitigationUtil
 * @generated
 */
public interface LitigationPersistence extends BasePersistence<Litigation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LitigationUtil} to access the litigation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the litigations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching litigations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.Litigation> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the litigations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.LitigationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of litigations
	* @param end the upper bound of the range of litigations (not inclusive)
	* @return the range of matching litigations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.Litigation> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the litigations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.LitigationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of litigations
	* @param end the upper bound of the range of litigations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching litigations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.Litigation> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first litigation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching litigation
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException if a matching litigation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Litigation findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException;

	/**
	* Returns the first litigation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching litigation, or <code>null</code> if a matching litigation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Litigation fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last litigation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching litigation
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException if a matching litigation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Litigation findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException;

	/**
	* Returns the last litigation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching litigation, or <code>null</code> if a matching litigation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Litigation fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the litigations before and after the current litigation in the ordered set where uuid = &#63;.
	*
	* @param spLitigationId the primary key of the current litigation
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next litigation
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException if a litigation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Litigation[] findByUuid_PrevAndNext(
		long spLitigationId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException;

	/**
	* Removes all the litigations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of litigations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching litigations
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the litigation where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching litigation
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException if a matching litigation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Litigation findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException;

	/**
	* Returns the litigation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching litigation, or <code>null</code> if a matching litigation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Litigation fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the litigation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching litigation, or <code>null</code> if a matching litigation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Litigation fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the litigation where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the litigation that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Litigation removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException;

	/**
	* Returns the number of litigations where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching litigations
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the litigations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching litigations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.Litigation> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the litigations where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.LitigationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of litigations
	* @param end the upper bound of the range of litigations (not inclusive)
	* @return the range of matching litigations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.Litigation> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the litigations where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.LitigationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of litigations
	* @param end the upper bound of the range of litigations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching litigations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.Litigation> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first litigation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching litigation
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException if a matching litigation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Litigation findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException;

	/**
	* Returns the first litigation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching litigation, or <code>null</code> if a matching litigation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Litigation fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last litigation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching litigation
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException if a matching litigation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Litigation findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException;

	/**
	* Returns the last litigation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching litigation, or <code>null</code> if a matching litigation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Litigation fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the litigations before and after the current litigation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spLitigationId the primary key of the current litigation
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next litigation
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException if a litigation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Litigation[] findByUuid_C_PrevAndNext(
		long spLitigationId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException;

	/**
	* Removes all the litigations where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of litigations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching litigations
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the litigation in the entity cache if it is enabled.
	*
	* @param litigation the litigation
	*/
	public void cacheResult(
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation);

	/**
	* Caches the litigations in the entity cache if it is enabled.
	*
	* @param litigations the litigations
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.legalandcontract.model.Litigation> litigations);

	/**
	* Creates a new litigation with the primary key. Does not add the litigation to the database.
	*
	* @param spLitigationId the primary key for the new litigation
	* @return the new litigation
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Litigation create(
		long spLitigationId);

	/**
	* Removes the litigation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spLitigationId the primary key of the litigation
	* @return the litigation that was removed
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException if a litigation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Litigation remove(
		long spLitigationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException;

	public com.sambaash.platform.srv.legalandcontract.model.Litigation updateImpl(
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the litigation with the primary key or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException} if it could not be found.
	*
	* @param spLitigationId the primary key of the litigation
	* @return the litigation
	* @throws com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException if a litigation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Litigation findByPrimaryKey(
		long spLitigationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException;

	/**
	* Returns the litigation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spLitigationId the primary key of the litigation
	* @return the litigation, or <code>null</code> if a litigation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.legalandcontract.model.Litigation fetchByPrimaryKey(
		long spLitigationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the litigations.
	*
	* @return the litigations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.Litigation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the litigations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.LitigationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of litigations
	* @param end the upper bound of the range of litigations (not inclusive)
	* @return the range of litigations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.Litigation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the litigations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.LitigationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of litigations
	* @param end the upper bound of the range of litigations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of litigations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.legalandcontract.model.Litigation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the litigations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of litigations.
	*
	* @return the number of litigations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}