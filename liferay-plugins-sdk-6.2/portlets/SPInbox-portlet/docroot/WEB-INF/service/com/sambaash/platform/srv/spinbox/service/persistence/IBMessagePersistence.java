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

package com.sambaash.platform.srv.spinbox.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.spinbox.model.IBMessage;

/**
 * The persistence interface for the i b message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see IBMessagePersistenceImpl
 * @see IBMessageUtil
 * @generated
 */
public interface IBMessagePersistence extends BasePersistence<IBMessage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IBMessageUtil} to access the i b message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the i b messages where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b messages where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @return the range of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b messages where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i b message in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException;

	/**
	* Returns the first i b message in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i b message in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException;

	/**
	* Returns the last i b message in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b messages before and after the current i b message in the ordered set where uuid = &#63;.
	*
	* @param messageId the primary key of the current i b message
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage[] findByUuid_PrevAndNext(
		long messageId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException;

	/**
	* Removes all the i b messages where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b messages where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b message where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spinbox.NoSuchIBMessageException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException;

	/**
	* Returns the i b message where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b message where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the i b message where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the i b message that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException;

	/**
	* Returns the number of i b messages where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i b messages where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b messages where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @return the range of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b messages where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i b message in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException;

	/**
	* Returns the first i b message in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i b message in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException;

	/**
	* Returns the last i b message in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b messages before and after the current i b message in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param messageId the primary key of the current i b message
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage[] findByUuid_C_PrevAndNext(
		long messageId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException;

	/**
	* Removes all the i b messages where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b messages where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i b messages where createByUserId = &#63; and deleteStatus = &#63;.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @return the matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreateUserId(
		java.lang.String createByUserId, boolean deleteStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b messages where createByUserId = &#63; and deleteStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @return the range of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreateUserId(
		java.lang.String createByUserId, boolean deleteStatus, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b messages where createByUserId = &#63; and deleteStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreateUserId(
		java.lang.String createByUserId, boolean deleteStatus, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63;.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage findByCreateUserId_First(
		java.lang.String createByUserId, boolean deleteStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException;

	/**
	* Returns the first i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63;.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage fetchByCreateUserId_First(
		java.lang.String createByUserId, boolean deleteStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63;.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage findByCreateUserId_Last(
		java.lang.String createByUserId, boolean deleteStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException;

	/**
	* Returns the last i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63;.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage fetchByCreateUserId_Last(
		java.lang.String createByUserId, boolean deleteStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b messages before and after the current i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63;.
	*
	* @param messageId the primary key of the current i b message
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage[] findByCreateUserId_PrevAndNext(
		long messageId, java.lang.String createByUserId, boolean deleteStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException;

	/**
	* Removes all the i b messages where createByUserId = &#63; and deleteStatus = &#63; from the database.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCreateUserId(java.lang.String createByUserId,
		boolean deleteStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b messages where createByUserId = &#63; and deleteStatus = &#63;.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @return the number of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public int countByCreateUserId(java.lang.String createByUserId,
		boolean deleteStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i b messages where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param draft the draft
	* @return the matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreateUserIdAndDraft(
		java.lang.String createByUserId, boolean deleteStatus, boolean draft)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b messages where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @return the range of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreateUserIdAndDraft(
		java.lang.String createByUserId, boolean deleteStatus, boolean draft,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b messages where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreateUserIdAndDraft(
		java.lang.String createByUserId, boolean deleteStatus, boolean draft,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage findByCreateUserIdAndDraft_First(
		java.lang.String createByUserId, boolean deleteStatus, boolean draft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException;

	/**
	* Returns the first i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage fetchByCreateUserIdAndDraft_First(
		java.lang.String createByUserId, boolean deleteStatus, boolean draft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage findByCreateUserIdAndDraft_Last(
		java.lang.String createByUserId, boolean deleteStatus, boolean draft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException;

	/**
	* Returns the last i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage fetchByCreateUserIdAndDraft_Last(
		java.lang.String createByUserId, boolean deleteStatus, boolean draft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b messages before and after the current i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param messageId the primary key of the current i b message
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage[] findByCreateUserIdAndDraft_PrevAndNext(
		long messageId, java.lang.String createByUserId, boolean deleteStatus,
		boolean draft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException;

	/**
	* Removes all the i b messages where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63; from the database.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param draft the draft
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCreateUserIdAndDraft(java.lang.String createByUserId,
		boolean deleteStatus, boolean draft)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b messages where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param createByUserId the create by user ID
	* @param deleteStatus the delete status
	* @param draft the draft
	* @return the number of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public int countByCreateUserIdAndDraft(java.lang.String createByUserId,
		boolean deleteStatus, boolean draft)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i b messages where createBy = &#63; and deleteStatus = &#63;.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @return the matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreatorName(
		java.lang.String createBy, boolean deleteStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b messages where createBy = &#63; and deleteStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @return the range of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreatorName(
		java.lang.String createBy, boolean deleteStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b messages where createBy = &#63; and deleteStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreatorName(
		java.lang.String createBy, boolean deleteStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i b message in the ordered set where createBy = &#63; and deleteStatus = &#63;.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage findByCreatorName_First(
		java.lang.String createBy, boolean deleteStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException;

	/**
	* Returns the first i b message in the ordered set where createBy = &#63; and deleteStatus = &#63;.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage fetchByCreatorName_First(
		java.lang.String createBy, boolean deleteStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i b message in the ordered set where createBy = &#63; and deleteStatus = &#63;.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage findByCreatorName_Last(
		java.lang.String createBy, boolean deleteStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException;

	/**
	* Returns the last i b message in the ordered set where createBy = &#63; and deleteStatus = &#63;.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage fetchByCreatorName_Last(
		java.lang.String createBy, boolean deleteStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b messages before and after the current i b message in the ordered set where createBy = &#63; and deleteStatus = &#63;.
	*
	* @param messageId the primary key of the current i b message
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage[] findByCreatorName_PrevAndNext(
		long messageId, java.lang.String createBy, boolean deleteStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException;

	/**
	* Removes all the i b messages where createBy = &#63; and deleteStatus = &#63; from the database.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCreatorName(java.lang.String createBy,
		boolean deleteStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b messages where createBy = &#63; and deleteStatus = &#63;.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @return the number of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public int countByCreatorName(java.lang.String createBy,
		boolean deleteStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i b messages where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param draft the draft
	* @return the matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreatorNameAndDraft(
		java.lang.String createBy, boolean deleteStatus, boolean draft)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b messages where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @return the range of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreatorNameAndDraft(
		java.lang.String createBy, boolean deleteStatus, boolean draft,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b messages where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findByCreatorNameAndDraft(
		java.lang.String createBy, boolean deleteStatus, boolean draft,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i b message in the ordered set where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage findByCreatorNameAndDraft_First(
		java.lang.String createBy, boolean deleteStatus, boolean draft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException;

	/**
	* Returns the first i b message in the ordered set where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage fetchByCreatorNameAndDraft_First(
		java.lang.String createBy, boolean deleteStatus, boolean draft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i b message in the ordered set where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage findByCreatorNameAndDraft_Last(
		java.lang.String createBy, boolean deleteStatus, boolean draft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException;

	/**
	* Returns the last i b message in the ordered set where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message, or <code>null</code> if a matching i b message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage fetchByCreatorNameAndDraft_Last(
		java.lang.String createBy, boolean deleteStatus, boolean draft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b messages before and after the current i b message in the ordered set where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param messageId the primary key of the current i b message
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param draft the draft
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage[] findByCreatorNameAndDraft_PrevAndNext(
		long messageId, java.lang.String createBy, boolean deleteStatus,
		boolean draft,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException;

	/**
	* Removes all the i b messages where createBy = &#63; and deleteStatus = &#63; and draft = &#63; from the database.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param draft the draft
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCreatorNameAndDraft(java.lang.String createBy,
		boolean deleteStatus, boolean draft)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b messages where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	*
	* @param createBy the create by
	* @param deleteStatus the delete status
	* @param draft the draft
	* @return the number of matching i b messages
	* @throws SystemException if a system exception occurred
	*/
	public int countByCreatorNameAndDraft(java.lang.String createBy,
		boolean deleteStatus, boolean draft)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the i b message in the entity cache if it is enabled.
	*
	* @param ibMessage the i b message
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spinbox.model.IBMessage ibMessage);

	/**
	* Caches the i b messages in the entity cache if it is enabled.
	*
	* @param ibMessages the i b messages
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> ibMessages);

	/**
	* Creates a new i b message with the primary key. Does not add the i b message to the database.
	*
	* @param messageId the primary key for the new i b message
	* @return the new i b message
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage create(
		long messageId);

	/**
	* Removes the i b message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageId the primary key of the i b message
	* @return the i b message that was removed
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage remove(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException;

	public com.sambaash.platform.srv.spinbox.model.IBMessage updateImpl(
		com.sambaash.platform.srv.spinbox.model.IBMessage ibMessage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b message with the primary key or throws a {@link com.sambaash.platform.srv.spinbox.NoSuchIBMessageException} if it could not be found.
	*
	* @param messageId the primary key of the i b message
	* @return the i b message
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage findByPrimaryKey(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageException;

	/**
	* Returns the i b message with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param messageId the primary key of the i b message
	* @return the i b message, or <code>null</code> if a i b message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessage fetchByPrimaryKey(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i b messages.
	*
	* @return the i b messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @return the range of i b messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of i b messages
	* @param end the upper bound of the range of i b messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of i b messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the i b messages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b messages.
	*
	* @return the number of i b messages
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}