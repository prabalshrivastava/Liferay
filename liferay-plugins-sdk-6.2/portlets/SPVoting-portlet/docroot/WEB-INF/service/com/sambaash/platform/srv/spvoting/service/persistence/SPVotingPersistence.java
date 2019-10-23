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

package com.sambaash.platform.srv.spvoting.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.spvoting.model.SPVoting;

/**
 * The persistence interface for the s p voting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPVotingPersistenceImpl
 * @see SPVotingUtil
 * @generated
 */
public interface SPVotingPersistence extends BasePersistence<SPVoting> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPVotingUtil} to access the s p voting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p votings where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p votings where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p votings
	* @param end the upper bound of the range of s p votings (not inclusive)
	* @return the range of matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p votings where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p votings
	* @param end the upper bound of the range of s p votings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p voting in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException;

	/**
	* Returns the first s p voting in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p voting in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException;

	/**
	* Returns the last s p voting in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p votings before and after the current s p voting in the ordered set where uuid = &#63;.
	*
	* @param spVotingId the primary key of the current s p voting
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a s p voting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting[] findByUuid_PrevAndNext(
		long spVotingId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException;

	/**
	* Removes all the s p votings where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p votings where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p voting where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spvoting.NoSuchSPVotingException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException;

	/**
	* Returns the s p voting where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p voting where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p voting where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the s p voting that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException;

	/**
	* Returns the number of s p votings where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p votings where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p votings where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p votings
	* @param end the upper bound of the range of s p votings (not inclusive)
	* @return the range of matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p votings where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p votings
	* @param end the upper bound of the range of s p votings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p voting in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException;

	/**
	* Returns the first s p voting in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p voting in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException;

	/**
	* Returns the last s p voting in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p votings before and after the current s p voting in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spVotingId the primary key of the current s p voting
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a s p voting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting[] findByUuid_C_PrevAndNext(
		long spVotingId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException;

	/**
	* Removes all the s p votings where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p votings where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p voting where className = &#63; and classPK = &#63; and userId = &#63; or throws a {@link com.sambaash.platform.srv.spvoting.NoSuchSPVotingException} if it could not be found.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param userId the user ID
	* @return the matching s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting findByEntryAndUserId(
		java.lang.String className, long classPK, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException;

	/**
	* Returns the s p voting where className = &#63; and classPK = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param userId the user ID
	* @return the matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting fetchByEntryAndUserId(
		java.lang.String className, long classPK, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p voting where className = &#63; and classPK = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting fetchByEntryAndUserId(
		java.lang.String className, long classPK, long userId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p voting where className = &#63; and classPK = &#63; and userId = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param userId the user ID
	* @return the s p voting that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting removeByEntryAndUserId(
		java.lang.String className, long classPK, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException;

	/**
	* Returns the number of s p votings where className = &#63; and classPK = &#63; and userId = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param userId the user ID
	* @return the number of matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public int countByEntryAndUserId(java.lang.String className, long classPK,
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p voting where className = &#63; and classPK = &#63; and ip = &#63; or throws a {@link com.sambaash.platform.srv.spvoting.NoSuchSPVotingException} if it could not be found.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param ip the ip
	* @return the matching s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting findByEntryAndIp(
		java.lang.String className, long classPK, java.lang.String ip)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException;

	/**
	* Returns the s p voting where className = &#63; and classPK = &#63; and ip = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param ip the ip
	* @return the matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting fetchByEntryAndIp(
		java.lang.String className, long classPK, java.lang.String ip)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p voting where className = &#63; and classPK = &#63; and ip = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param ip the ip
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting fetchByEntryAndIp(
		java.lang.String className, long classPK, java.lang.String ip,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p voting where className = &#63; and classPK = &#63; and ip = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param ip the ip
	* @return the s p voting that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting removeByEntryAndIp(
		java.lang.String className, long classPK, java.lang.String ip)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException;

	/**
	* Returns the number of s p votings where className = &#63; and classPK = &#63; and ip = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param ip the ip
	* @return the number of matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public int countByEntryAndIp(java.lang.String className, long classPK,
		java.lang.String ip)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p votings where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findByEntry(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p votings where className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of s p votings
	* @param end the upper bound of the range of s p votings (not inclusive)
	* @return the range of matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findByEntry(
		java.lang.String className, long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p votings where className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of s p votings
	* @param end the upper bound of the range of s p votings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findByEntry(
		java.lang.String className, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p voting in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting findByEntry_First(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException;

	/**
	* Returns the first s p voting in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting fetchByEntry_First(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p voting in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting findByEntry_Last(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException;

	/**
	* Returns the last s p voting in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting fetchByEntry_Last(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p votings before and after the current s p voting in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param spVotingId the primary key of the current s p voting
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a s p voting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting[] findByEntry_PrevAndNext(
		long spVotingId, java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException;

	/**
	* Removes all the s p votings where className = &#63; and classPK = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEntry(java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p votings where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the number of matching s p votings
	* @throws SystemException if a system exception occurred
	*/
	public int countByEntry(java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p voting in the entity cache if it is enabled.
	*
	* @param spVoting the s p voting
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spvoting.model.SPVoting spVoting);

	/**
	* Caches the s p votings in the entity cache if it is enabled.
	*
	* @param spVotings the s p votings
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> spVotings);

	/**
	* Creates a new s p voting with the primary key. Does not add the s p voting to the database.
	*
	* @param spVotingId the primary key for the new s p voting
	* @return the new s p voting
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting create(
		long spVotingId);

	/**
	* Removes the s p voting with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spVotingId the primary key of the s p voting
	* @return the s p voting that was removed
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a s p voting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting remove(
		long spVotingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException;

	public com.sambaash.platform.srv.spvoting.model.SPVoting updateImpl(
		com.sambaash.platform.srv.spvoting.model.SPVoting spVoting)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p voting with the primary key or throws a {@link com.sambaash.platform.srv.spvoting.NoSuchSPVotingException} if it could not be found.
	*
	* @param spVotingId the primary key of the s p voting
	* @return the s p voting
	* @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a s p voting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting findByPrimaryKey(
		long spVotingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException;

	/**
	* Returns the s p voting with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spVotingId the primary key of the s p voting
	* @return the s p voting, or <code>null</code> if a s p voting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spvoting.model.SPVoting fetchByPrimaryKey(
		long spVotingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p votings.
	*
	* @return the s p votings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p votings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p votings
	* @param end the upper bound of the range of s p votings (not inclusive)
	* @return the range of s p votings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p votings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p votings
	* @param end the upper bound of the range of s p votings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p votings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p votings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p votings.
	*
	* @return the number of s p votings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}