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

import com.sambaash.platform.srv.spinbox.model.IBMessageDetail;

/**
 * The persistence interface for the i b message detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see IBMessageDetailPersistenceImpl
 * @see IBMessageDetailUtil
 * @generated
 */
public interface IBMessageDetailPersistence extends BasePersistence<IBMessageDetail> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IBMessageDetailUtil} to access the i b message detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the i b message details where messageId = &#63;.
	*
	* @param messageId the message ID
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByMessageId(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b message details where messageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param messageId the message ID
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByMessageId(
		long messageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b message details where messageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param messageId the message ID
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByMessageId(
		long messageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i b message detail in the ordered set where messageId = &#63;.
	*
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByMessageId_First(
		long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the first i b message detail in the ordered set where messageId = &#63;.
	*
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByMessageId_First(
		long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i b message detail in the ordered set where messageId = &#63;.
	*
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByMessageId_Last(
		long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the last i b message detail in the ordered set where messageId = &#63;.
	*
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByMessageId_Last(
		long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where messageId = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByMessageId_PrevAndNext(
		long ibMsgDetailId, long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Removes all the i b message details where messageId = &#63; from the database.
	*
	* @param messageId the message ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMessageId(long messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b message details where messageId = &#63;.
	*
	* @param messageId the message ID
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public int countByMessageId(long messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i b message details where receiverId = &#63; and archived = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceId(
		long receiverId, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b message details where receiverId = &#63; and archived = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceId(
		long receiverId, boolean archived, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b message details where receiverId = &#63; and archived = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceId(
		long receiverId, boolean archived, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceId_First(
		long receiverId, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceId_First(
		long receiverId, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceId_Last(
		long receiverId, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceId_Last(
		long receiverId, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where receiverId = &#63; and archived = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByReceId_PrevAndNext(
		long ibMsgDetailId, long receiverId, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Removes all the i b message details where receiverId = &#63; and archived = &#63; from the database.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @throws SystemException if a system exception occurred
	*/
	public void removeByReceId(long receiverId, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b message details where receiverId = &#63; and archived = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public int countByReceId(long receiverId, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndRms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndRms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndRms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdAndRms_First(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdAndRms_First(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdAndRms_Last(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdAndRms_Last(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByReceIdAndRms_PrevAndNext(
		long ibMsgDetailId, long receiverId, boolean archived,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Removes all the i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; from the database.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByReceIdAndRms(long receiverId, boolean archived,
		java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public int countByReceIdAndRms(long receiverId, boolean archived,
		java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i b message details where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndSms(
		long receiverId, boolean archived, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b message details where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndSms(
		long receiverId, boolean archived, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b message details where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndSms(
		long receiverId, boolean archived, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdAndSms_First(
		long receiverId, boolean archived, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdAndSms_First(
		long receiverId, boolean archived, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdAndSms_Last(
		long receiverId, boolean archived, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdAndSms_Last(
		long receiverId, boolean archived, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByReceIdAndSms_PrevAndNext(
		long ibMsgDetailId, long receiverId, boolean archived,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Removes all the i b message details where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63; from the database.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByReceIdAndSms(long receiverId, boolean archived,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b message details where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public int countByReceIdAndSms(long receiverId, boolean archived,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdRmsAndSms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdRmsAndSms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdRmsAndSms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdRmsAndSms_First(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdRmsAndSms_First(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdRmsAndSms_Last(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdRmsAndSms_Last(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByReceIdRmsAndSms_PrevAndNext(
		long ibMsgDetailId, long receiverId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Removes all the i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63; from the database.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByReceIdRmsAndSms(long receiverId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public int countByReceIdRmsAndSms(long receiverId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndCty(
		long receiverId, boolean archived, java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndCty(
		long receiverId, boolean archived, java.lang.String category,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndCty(
		long receiverId, boolean archived, java.lang.String category,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdAndCty_First(
		long receiverId, boolean archived, java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdAndCty_First(
		long receiverId, boolean archived, java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdAndCty_Last(
		long receiverId, boolean archived, java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdAndCty_Last(
		long receiverId, boolean archived, java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByReceIdAndCty_PrevAndNext(
		long ibMsgDetailId, long receiverId, boolean archived,
		java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Removes all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; from the database.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @throws SystemException if a system exception occurred
	*/
	public void removeByReceIdAndCty(long receiverId, boolean archived,
		java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b message details where receiverId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public int countByReceIdAndCty(long receiverId, boolean archived,
		java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndRms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndRms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndRms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdCtyAndRms_First(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdCtyAndRms_First(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdCtyAndRms_Last(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdCtyAndRms_Last(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByReceIdCtyAndRms_PrevAndNext(
		long ibMsgDetailId, long receiverId, boolean archived,
		java.lang.String category, java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Removes all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; from the database.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByReceIdCtyAndRms(long receiverId, boolean archived,
		java.lang.String category, java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public int countByReceIdCtyAndRms(long receiverId, boolean archived,
		java.lang.String category, java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdCtyAndSms_First(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdCtyAndSms_First(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdCtyAndSms_Last(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdCtyAndSms_Last(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByReceIdCtyAndSms_PrevAndNext(
		long ibMsgDetailId, long receiverId, boolean archived,
		java.lang.String category, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Removes all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63; from the database.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByReceIdCtyAndSms(long receiverId, boolean archived,
		java.lang.String category, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public int countByReceIdCtyAndSms(long receiverId, boolean archived,
		java.lang.String category, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyRmsAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyRmsAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyRmsAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdCtyRmsAndSms_First(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdCtyRmsAndSms_First(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdCtyRmsAndSms_Last(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdCtyRmsAndSms_Last(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByReceIdCtyRmsAndSms_PrevAndNext(
		long ibMsgDetailId, long receiverId, boolean archived,
		java.lang.String category, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Removes all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63; from the database.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByReceIdCtyRmsAndSms(long receiverId, boolean archived,
		java.lang.String category, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public int countByReceIdCtyRmsAndSms(long receiverId, boolean archived,
		java.lang.String category, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b message detail where receiverId = &#63; and messageId = &#63; or throws a {@link com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException} if it could not be found.
	*
	* @param receiverId the receiver ID
	* @param messageId the message ID
	* @return the matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceiverIdmessageId(
		long receiverId, long messageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the i b message detail where receiverId = &#63; and messageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param receiverId the receiver ID
	* @param messageId the message ID
	* @return the matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceiverIdmessageId(
		long receiverId, long messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b message detail where receiverId = &#63; and messageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param receiverId the receiver ID
	* @param messageId the message ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceiverIdmessageId(
		long receiverId, long messageId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the i b message detail where receiverId = &#63; and messageId = &#63; from the database.
	*
	* @param receiverId the receiver ID
	* @param messageId the message ID
	* @return the i b message detail that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail removeByReceiverIdmessageId(
		long receiverId, long messageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the number of i b message details where receiverId = &#63; and messageId = &#63;.
	*
	* @param receiverId the receiver ID
	* @param messageId the message ID
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public int countByReceiverIdmessageId(long receiverId, long messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i b message details where corpProfileId = &#63; and archived = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpId(
		long corpProfileId, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b message details where corpProfileId = &#63; and archived = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpId(
		long corpProfileId, boolean archived, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b message details where corpProfileId = &#63; and archived = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpId(
		long corpProfileId, boolean archived, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpId_First(
		long corpProfileId, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpId_First(
		long corpProfileId, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpId_Last(
		long corpProfileId, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpId_Last(
		long corpProfileId, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByCorpId_PrevAndNext(
		long ibMsgDetailId, long corpProfileId, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Removes all the i b message details where corpProfileId = &#63; and archived = &#63; from the database.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCorpId(long corpProfileId, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b message details where corpProfileId = &#63; and archived = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public int countByCorpId(long corpProfileId, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndRms(
		long corpProfileId, boolean archived, java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndRms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndRms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdAndRms_First(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdAndRms_First(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdAndRms_Last(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdAndRms_Last(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByCorpIdAndRms_PrevAndNext(
		long ibMsgDetailId, long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Removes all the i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; from the database.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCorpIdAndRms(long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public int countByCorpIdAndRms(long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i b message details where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndSms(
		long corpProfileId, boolean archived, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b message details where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndSms(
		long corpProfileId, boolean archived, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b message details where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndSms(
		long corpProfileId, boolean archived, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdAndSms_First(
		long corpProfileId, boolean archived, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdAndSms_First(
		long corpProfileId, boolean archived, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdAndSms_Last(
		long corpProfileId, boolean archived, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdAndSms_Last(
		long corpProfileId, boolean archived, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByCorpIdAndSms_PrevAndNext(
		long ibMsgDetailId, long corpProfileId, boolean archived,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Removes all the i b message details where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63; from the database.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCorpIdAndSms(long corpProfileId, boolean archived,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b message details where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public int countByCorpIdAndSms(long corpProfileId, boolean archived,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdRmsAndSms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdRmsAndSms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdRmsAndSms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdRmsAndSms_First(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdRmsAndSms_First(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdRmsAndSms_Last(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdRmsAndSms_Last(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByCorpIdRmsAndSms_PrevAndNext(
		long ibMsgDetailId, long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Removes all the i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63; from the database.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCorpIdRmsAndSms(long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public int countByCorpIdRmsAndSms(long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndCty(
		long corpProfileId, boolean archived, java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndCty(
		long corpProfileId, boolean archived, java.lang.String category,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndCty(
		long corpProfileId, boolean archived, java.lang.String category,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdAndCty_First(
		long corpProfileId, boolean archived, java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdAndCty_First(
		long corpProfileId, boolean archived, java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdAndCty_Last(
		long corpProfileId, boolean archived, java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdAndCty_Last(
		long corpProfileId, boolean archived, java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByCorpIdAndCty_PrevAndNext(
		long ibMsgDetailId, long corpProfileId, boolean archived,
		java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Removes all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; from the database.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCorpIdAndCty(long corpProfileId, boolean archived,
		java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public int countByCorpIdAndCty(long corpProfileId, boolean archived,
		java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndRms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndRms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndRms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdCtyAndRms_First(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdCtyAndRms_First(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdCtyAndRms_Last(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdCtyAndRms_Last(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByCorpIdCtyAndRms_PrevAndNext(
		long ibMsgDetailId, long corpProfileId, boolean archived,
		java.lang.String category, java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Removes all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; from the database.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCorpIdCtyAndRms(long corpProfileId, boolean archived,
		java.lang.String category, java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public int countByCorpIdCtyAndRms(long corpProfileId, boolean archived,
		java.lang.String category, java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdCtyAndSms_First(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdCtyAndSms_First(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdCtyAndSms_Last(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdCtyAndSms_Last(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByCorpIdCtyAndSms_PrevAndNext(
		long ibMsgDetailId, long corpProfileId, boolean archived,
		java.lang.String category, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Removes all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63; from the database.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCorpIdCtyAndSms(long corpProfileId, boolean archived,
		java.lang.String category, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public int countByCorpIdCtyAndSms(long corpProfileId, boolean archived,
		java.lang.String category, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyRmsAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyRmsAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyRmsAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdCtyRmsAndSms_First(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdCtyRmsAndSms_First(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdCtyRmsAndSms_Last(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdCtyRmsAndSms_Last(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByCorpIdCtyRmsAndSms_PrevAndNext(
		long ibMsgDetailId, long corpProfileId, boolean archived,
		java.lang.String category, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Removes all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63; from the database.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCorpIdCtyRmsAndSms(long corpProfileId,
		boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public int countByCorpIdCtyRmsAndSms(long corpProfileId, boolean archived,
		java.lang.String category, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the i b message detail in the entity cache if it is enabled.
	*
	* @param ibMessageDetail the i b message detail
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spinbox.model.IBMessageDetail ibMessageDetail);

	/**
	* Caches the i b message details in the entity cache if it is enabled.
	*
	* @param ibMessageDetails the i b message details
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> ibMessageDetails);

	/**
	* Creates a new i b message detail with the primary key. Does not add the i b message detail to the database.
	*
	* @param ibMsgDetailId the primary key for the new i b message detail
	* @return the new i b message detail
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail create(
		long ibMsgDetailId);

	/**
	* Removes the i b message detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ibMsgDetailId the primary key of the i b message detail
	* @return the i b message detail that was removed
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail remove(
		long ibMsgDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail updateImpl(
		com.sambaash.platform.srv.spinbox.model.IBMessageDetail ibMessageDetail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i b message detail with the primary key or throws a {@link com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException} if it could not be found.
	*
	* @param ibMsgDetailId the primary key of the i b message detail
	* @return the i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByPrimaryKey(
		long ibMsgDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;

	/**
	* Returns the i b message detail with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ibMsgDetailId the primary key of the i b message detail
	* @return the i b message detail, or <code>null</code> if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByPrimaryKey(
		long ibMsgDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i b message details.
	*
	* @return the i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i b message details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i b message details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of i b message details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the i b message details from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i b message details.
	*
	* @return the number of i b message details
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}