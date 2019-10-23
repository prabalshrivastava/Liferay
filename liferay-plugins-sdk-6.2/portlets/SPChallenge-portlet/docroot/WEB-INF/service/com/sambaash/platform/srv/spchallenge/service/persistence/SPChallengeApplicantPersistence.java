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

package com.sambaash.platform.srv.spchallenge.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant;

/**
 * The persistence interface for the s p challenge applicant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPChallengeApplicantPersistenceImpl
 * @see SPChallengeApplicantUtil
 * @generated
 */
public interface SPChallengeApplicantPersistence extends BasePersistence<SPChallengeApplicant> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPChallengeApplicantUtil} to access the s p challenge applicant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p challenge applicants where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p challenge applicants where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p challenge applicants
	* @param end the upper bound of the range of s p challenge applicants (not inclusive)
	* @return the range of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p challenge applicants where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p challenge applicants
	* @param end the upper bound of the range of s p challenge applicants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p challenge applicant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException;

	/**
	* Returns the first s p challenge applicant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p challenge applicant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException;

	/**
	* Returns the last s p challenge applicant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p challenge applicants before and after the current s p challenge applicant in the ordered set where uuid = &#63;.
	*
	* @param spChallengeApplicantId the primary key of the current s p challenge applicant
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a s p challenge applicant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant[] findByUuid_PrevAndNext(
		long spChallengeApplicantId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException;

	/**
	* Removes all the s p challenge applicants where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p challenge applicants where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p challenge applicant where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spchallenge.NoSuchApplicantException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException;

	/**
	* Returns the s p challenge applicant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p challenge applicant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p challenge applicant where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the s p challenge applicant that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException;

	/**
	* Returns the number of s p challenge applicants where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p challenge applicants where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p challenge applicants where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p challenge applicants
	* @param end the upper bound of the range of s p challenge applicants (not inclusive)
	* @return the range of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p challenge applicants where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p challenge applicants
	* @param end the upper bound of the range of s p challenge applicants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p challenge applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException;

	/**
	* Returns the first s p challenge applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p challenge applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException;

	/**
	* Returns the last s p challenge applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p challenge applicants before and after the current s p challenge applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spChallengeApplicantId the primary key of the current s p challenge applicant
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a s p challenge applicant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant[] findByUuid_C_PrevAndNext(
		long spChallengeApplicantId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException;

	/**
	* Removes all the s p challenge applicants where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p challenge applicants where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p challenge applicants where applicantRefId = &#63;.
	*
	* @param applicantRefId the applicant ref ID
	* @return the matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findByApplicantRefId(
		long applicantRefId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p challenge applicants where applicantRefId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicantRefId the applicant ref ID
	* @param start the lower bound of the range of s p challenge applicants
	* @param end the upper bound of the range of s p challenge applicants (not inclusive)
	* @return the range of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findByApplicantRefId(
		long applicantRefId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p challenge applicants where applicantRefId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicantRefId the applicant ref ID
	* @param start the lower bound of the range of s p challenge applicants
	* @param end the upper bound of the range of s p challenge applicants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findByApplicantRefId(
		long applicantRefId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p challenge applicant in the ordered set where applicantRefId = &#63;.
	*
	* @param applicantRefId the applicant ref ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant findByApplicantRefId_First(
		long applicantRefId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException;

	/**
	* Returns the first s p challenge applicant in the ordered set where applicantRefId = &#63;.
	*
	* @param applicantRefId the applicant ref ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchByApplicantRefId_First(
		long applicantRefId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p challenge applicant in the ordered set where applicantRefId = &#63;.
	*
	* @param applicantRefId the applicant ref ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant findByApplicantRefId_Last(
		long applicantRefId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException;

	/**
	* Returns the last s p challenge applicant in the ordered set where applicantRefId = &#63;.
	*
	* @param applicantRefId the applicant ref ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchByApplicantRefId_Last(
		long applicantRefId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p challenge applicants before and after the current s p challenge applicant in the ordered set where applicantRefId = &#63;.
	*
	* @param spChallengeApplicantId the primary key of the current s p challenge applicant
	* @param applicantRefId the applicant ref ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a s p challenge applicant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant[] findByApplicantRefId_PrevAndNext(
		long spChallengeApplicantId, long applicantRefId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException;

	/**
	* Removes all the s p challenge applicants where applicantRefId = &#63; from the database.
	*
	* @param applicantRefId the applicant ref ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByApplicantRefId(long applicantRefId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p challenge applicants where applicantRefId = &#63;.
	*
	* @param applicantRefId the applicant ref ID
	* @return the number of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public int countByApplicantRefId(long applicantRefId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p challenge applicants where spChallengeId = &#63;.
	*
	* @param spChallengeId the sp challenge ID
	* @return the matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findBySPChallengeId(
		long spChallengeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p challenge applicants where spChallengeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spChallengeId the sp challenge ID
	* @param start the lower bound of the range of s p challenge applicants
	* @param end the upper bound of the range of s p challenge applicants (not inclusive)
	* @return the range of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findBySPChallengeId(
		long spChallengeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p challenge applicants where spChallengeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spChallengeId the sp challenge ID
	* @param start the lower bound of the range of s p challenge applicants
	* @param end the upper bound of the range of s p challenge applicants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findBySPChallengeId(
		long spChallengeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p challenge applicant in the ordered set where spChallengeId = &#63;.
	*
	* @param spChallengeId the sp challenge ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant findBySPChallengeId_First(
		long spChallengeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException;

	/**
	* Returns the first s p challenge applicant in the ordered set where spChallengeId = &#63;.
	*
	* @param spChallengeId the sp challenge ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchBySPChallengeId_First(
		long spChallengeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p challenge applicant in the ordered set where spChallengeId = &#63;.
	*
	* @param spChallengeId the sp challenge ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant findBySPChallengeId_Last(
		long spChallengeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException;

	/**
	* Returns the last s p challenge applicant in the ordered set where spChallengeId = &#63;.
	*
	* @param spChallengeId the sp challenge ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchBySPChallengeId_Last(
		long spChallengeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p challenge applicants before and after the current s p challenge applicant in the ordered set where spChallengeId = &#63;.
	*
	* @param spChallengeApplicantId the primary key of the current s p challenge applicant
	* @param spChallengeId the sp challenge ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a s p challenge applicant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant[] findBySPChallengeId_PrevAndNext(
		long spChallengeApplicantId, long spChallengeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException;

	/**
	* Removes all the s p challenge applicants where spChallengeId = &#63; from the database.
	*
	* @param spChallengeId the sp challenge ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySPChallengeId(long spChallengeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p challenge applicants where spChallengeId = &#63;.
	*
	* @param spChallengeId the sp challenge ID
	* @return the number of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public int countBySPChallengeId(long spChallengeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p challenge applicant where spChallengeId = &#63; and applicantRefId = &#63; or throws a {@link com.sambaash.platform.srv.spchallenge.NoSuchApplicantException} if it could not be found.
	*
	* @param spChallengeId the sp challenge ID
	* @param applicantRefId the applicant ref ID
	* @return the matching s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant findByChallengeIdApplicantRefId(
		long spChallengeId, long applicantRefId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException;

	/**
	* Returns the s p challenge applicant where spChallengeId = &#63; and applicantRefId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spChallengeId the sp challenge ID
	* @param applicantRefId the applicant ref ID
	* @return the matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchByChallengeIdApplicantRefId(
		long spChallengeId, long applicantRefId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p challenge applicant where spChallengeId = &#63; and applicantRefId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spChallengeId the sp challenge ID
	* @param applicantRefId the applicant ref ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchByChallengeIdApplicantRefId(
		long spChallengeId, long applicantRefId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p challenge applicant where spChallengeId = &#63; and applicantRefId = &#63; from the database.
	*
	* @param spChallengeId the sp challenge ID
	* @param applicantRefId the applicant ref ID
	* @return the s p challenge applicant that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant removeByChallengeIdApplicantRefId(
		long spChallengeId, long applicantRefId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException;

	/**
	* Returns the number of s p challenge applicants where spChallengeId = &#63; and applicantRefId = &#63;.
	*
	* @param spChallengeId the sp challenge ID
	* @param applicantRefId the applicant ref ID
	* @return the number of matching s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public int countByChallengeIdApplicantRefId(long spChallengeId,
		long applicantRefId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p challenge applicant in the entity cache if it is enabled.
	*
	* @param spChallengeApplicant the s p challenge applicant
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant spChallengeApplicant);

	/**
	* Caches the s p challenge applicants in the entity cache if it is enabled.
	*
	* @param spChallengeApplicants the s p challenge applicants
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> spChallengeApplicants);

	/**
	* Creates a new s p challenge applicant with the primary key. Does not add the s p challenge applicant to the database.
	*
	* @param spChallengeApplicantId the primary key for the new s p challenge applicant
	* @return the new s p challenge applicant
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant create(
		long spChallengeApplicantId);

	/**
	* Removes the s p challenge applicant with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spChallengeApplicantId the primary key of the s p challenge applicant
	* @return the s p challenge applicant that was removed
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a s p challenge applicant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant remove(
		long spChallengeApplicantId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException;

	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant updateImpl(
		com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant spChallengeApplicant)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p challenge applicant with the primary key or throws a {@link com.sambaash.platform.srv.spchallenge.NoSuchApplicantException} if it could not be found.
	*
	* @param spChallengeApplicantId the primary key of the s p challenge applicant
	* @return the s p challenge applicant
	* @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a s p challenge applicant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant findByPrimaryKey(
		long spChallengeApplicantId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spchallenge.NoSuchApplicantException;

	/**
	* Returns the s p challenge applicant with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spChallengeApplicantId the primary key of the s p challenge applicant
	* @return the s p challenge applicant, or <code>null</code> if a s p challenge applicant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant fetchByPrimaryKey(
		long spChallengeApplicantId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p challenge applicants.
	*
	* @return the s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p challenge applicants.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p challenge applicants
	* @param end the upper bound of the range of s p challenge applicants (not inclusive)
	* @return the range of s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p challenge applicants.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p challenge applicants
	* @param end the upper bound of the range of s p challenge applicants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p challenge applicants from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p challenge applicants.
	*
	* @return the number of s p challenge applicants
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}