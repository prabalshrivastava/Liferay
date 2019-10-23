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

package com.sambaash.platform.srv.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.model.ConversationUser;

/**
 * The persistence interface for the conversation user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author aishwarya
 * @see ConversationUserPersistenceImpl
 * @see ConversationUserUtil
 * @generated
 */
public interface ConversationUserPersistence extends BasePersistence<ConversationUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ConversationUserUtil} to access the conversation user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the conversation users where sentToUserId = &#63; and status = &#63; and entityClassId = &#63; and entityId = &#63;.
	*
	* @param sentToUserId the sent to user ID
	* @param status the status
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @return the matching conversation users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ConversationUser> findBysentToUserIdStatusEntityClassIdEntityId(
		long sentToUserId, long status, long entityClassId, long entityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the conversation users where sentToUserId = &#63; and status = &#63; and entityClassId = &#63; and entityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sentToUserId the sent to user ID
	* @param status the status
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param start the lower bound of the range of conversation users
	* @param end the upper bound of the range of conversation users (not inclusive)
	* @return the range of matching conversation users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ConversationUser> findBysentToUserIdStatusEntityClassIdEntityId(
		long sentToUserId, long status, long entityClassId, long entityId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the conversation users where sentToUserId = &#63; and status = &#63; and entityClassId = &#63; and entityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sentToUserId the sent to user ID
	* @param status the status
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param start the lower bound of the range of conversation users
	* @param end the upper bound of the range of conversation users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching conversation users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ConversationUser> findBysentToUserIdStatusEntityClassIdEntityId(
		long sentToUserId, long status, long entityClassId, long entityId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first conversation user in the ordered set where sentToUserId = &#63; and status = &#63; and entityClassId = &#63; and entityId = &#63;.
	*
	* @param sentToUserId the sent to user ID
	* @param status the status
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching conversation user
	* @throws com.sambaash.platform.srv.NoSuchConversationUserException if a matching conversation user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ConversationUser findBysentToUserIdStatusEntityClassIdEntityId_First(
		long sentToUserId, long status, long entityClassId, long entityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationUserException;

	/**
	* Returns the first conversation user in the ordered set where sentToUserId = &#63; and status = &#63; and entityClassId = &#63; and entityId = &#63;.
	*
	* @param sentToUserId the sent to user ID
	* @param status the status
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching conversation user, or <code>null</code> if a matching conversation user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ConversationUser fetchBysentToUserIdStatusEntityClassIdEntityId_First(
		long sentToUserId, long status, long entityClassId, long entityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last conversation user in the ordered set where sentToUserId = &#63; and status = &#63; and entityClassId = &#63; and entityId = &#63;.
	*
	* @param sentToUserId the sent to user ID
	* @param status the status
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching conversation user
	* @throws com.sambaash.platform.srv.NoSuchConversationUserException if a matching conversation user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ConversationUser findBysentToUserIdStatusEntityClassIdEntityId_Last(
		long sentToUserId, long status, long entityClassId, long entityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationUserException;

	/**
	* Returns the last conversation user in the ordered set where sentToUserId = &#63; and status = &#63; and entityClassId = &#63; and entityId = &#63;.
	*
	* @param sentToUserId the sent to user ID
	* @param status the status
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching conversation user, or <code>null</code> if a matching conversation user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ConversationUser fetchBysentToUserIdStatusEntityClassIdEntityId_Last(
		long sentToUserId, long status, long entityClassId, long entityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the conversation users before and after the current conversation user in the ordered set where sentToUserId = &#63; and status = &#63; and entityClassId = &#63; and entityId = &#63;.
	*
	* @param spConversationUserId the primary key of the current conversation user
	* @param sentToUserId the sent to user ID
	* @param status the status
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next conversation user
	* @throws com.sambaash.platform.srv.NoSuchConversationUserException if a conversation user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ConversationUser[] findBysentToUserIdStatusEntityClassIdEntityId_PrevAndNext(
		long spConversationUserId, long sentToUserId, long status,
		long entityClassId, long entityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationUserException;

	/**
	* Returns all the conversation users where sentToUserId = any &#63; and status = &#63; and entityClassId = &#63; and entityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sentToUserIds the sent to user IDs
	* @param status the status
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @return the matching conversation users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ConversationUser> findBysentToUserIdStatusEntityClassIdEntityId(
		long[] sentToUserIds, long status, long entityClassId, long entityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the conversation users where sentToUserId = any &#63; and status = &#63; and entityClassId = &#63; and entityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sentToUserIds the sent to user IDs
	* @param status the status
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param start the lower bound of the range of conversation users
	* @param end the upper bound of the range of conversation users (not inclusive)
	* @return the range of matching conversation users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ConversationUser> findBysentToUserIdStatusEntityClassIdEntityId(
		long[] sentToUserIds, long status, long entityClassId, long entityId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the conversation users where sentToUserId = any &#63; and status = &#63; and entityClassId = &#63; and entityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sentToUserIds the sent to user IDs
	* @param status the status
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param start the lower bound of the range of conversation users
	* @param end the upper bound of the range of conversation users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching conversation users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ConversationUser> findBysentToUserIdStatusEntityClassIdEntityId(
		long[] sentToUserIds, long status, long entityClassId, long entityId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the conversation users where sentToUserId = &#63; and status = &#63; and entityClassId = &#63; and entityId = &#63; from the database.
	*
	* @param sentToUserId the sent to user ID
	* @param status the status
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBysentToUserIdStatusEntityClassIdEntityId(
		long sentToUserId, long status, long entityClassId, long entityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of conversation users where sentToUserId = &#63; and status = &#63; and entityClassId = &#63; and entityId = &#63;.
	*
	* @param sentToUserId the sent to user ID
	* @param status the status
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @return the number of matching conversation users
	* @throws SystemException if a system exception occurred
	*/
	public int countBysentToUserIdStatusEntityClassIdEntityId(
		long sentToUserId, long status, long entityClassId, long entityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of conversation users where sentToUserId = any &#63; and status = &#63; and entityClassId = &#63; and entityId = &#63;.
	*
	* @param sentToUserIds the sent to user IDs
	* @param status the status
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @return the number of matching conversation users
	* @throws SystemException if a system exception occurred
	*/
	public int countBysentToUserIdStatusEntityClassIdEntityId(
		long[] sentToUserIds, long status, long entityClassId, long entityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the conversation users where spConversationId = &#63;.
	*
	* @param spConversationId the sp conversation ID
	* @return the matching conversation users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ConversationUser> findByspConversationId(
		long spConversationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the conversation users where spConversationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spConversationId the sp conversation ID
	* @param start the lower bound of the range of conversation users
	* @param end the upper bound of the range of conversation users (not inclusive)
	* @return the range of matching conversation users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ConversationUser> findByspConversationId(
		long spConversationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the conversation users where spConversationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spConversationId the sp conversation ID
	* @param start the lower bound of the range of conversation users
	* @param end the upper bound of the range of conversation users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching conversation users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ConversationUser> findByspConversationId(
		long spConversationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first conversation user in the ordered set where spConversationId = &#63;.
	*
	* @param spConversationId the sp conversation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching conversation user
	* @throws com.sambaash.platform.srv.NoSuchConversationUserException if a matching conversation user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ConversationUser findByspConversationId_First(
		long spConversationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationUserException;

	/**
	* Returns the first conversation user in the ordered set where spConversationId = &#63;.
	*
	* @param spConversationId the sp conversation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching conversation user, or <code>null</code> if a matching conversation user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ConversationUser fetchByspConversationId_First(
		long spConversationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last conversation user in the ordered set where spConversationId = &#63;.
	*
	* @param spConversationId the sp conversation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching conversation user
	* @throws com.sambaash.platform.srv.NoSuchConversationUserException if a matching conversation user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ConversationUser findByspConversationId_Last(
		long spConversationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationUserException;

	/**
	* Returns the last conversation user in the ordered set where spConversationId = &#63;.
	*
	* @param spConversationId the sp conversation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching conversation user, or <code>null</code> if a matching conversation user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ConversationUser fetchByspConversationId_Last(
		long spConversationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the conversation users before and after the current conversation user in the ordered set where spConversationId = &#63;.
	*
	* @param spConversationUserId the primary key of the current conversation user
	* @param spConversationId the sp conversation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next conversation user
	* @throws com.sambaash.platform.srv.NoSuchConversationUserException if a conversation user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ConversationUser[] findByspConversationId_PrevAndNext(
		long spConversationUserId, long spConversationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationUserException;

	/**
	* Removes all the conversation users where spConversationId = &#63; from the database.
	*
	* @param spConversationId the sp conversation ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByspConversationId(long spConversationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of conversation users where spConversationId = &#63;.
	*
	* @param spConversationId the sp conversation ID
	* @return the number of matching conversation users
	* @throws SystemException if a system exception occurred
	*/
	public int countByspConversationId(long spConversationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the conversation user in the entity cache if it is enabled.
	*
	* @param conversationUser the conversation user
	*/
	public void cacheResult(
		com.sambaash.platform.srv.model.ConversationUser conversationUser);

	/**
	* Caches the conversation users in the entity cache if it is enabled.
	*
	* @param conversationUsers the conversation users
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.ConversationUser> conversationUsers);

	/**
	* Creates a new conversation user with the primary key. Does not add the conversation user to the database.
	*
	* @param spConversationUserId the primary key for the new conversation user
	* @return the new conversation user
	*/
	public com.sambaash.platform.srv.model.ConversationUser create(
		long spConversationUserId);

	/**
	* Removes the conversation user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spConversationUserId the primary key of the conversation user
	* @return the conversation user that was removed
	* @throws com.sambaash.platform.srv.NoSuchConversationUserException if a conversation user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ConversationUser remove(
		long spConversationUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationUserException;

	public com.sambaash.platform.srv.model.ConversationUser updateImpl(
		com.sambaash.platform.srv.model.ConversationUser conversationUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the conversation user with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchConversationUserException} if it could not be found.
	*
	* @param spConversationUserId the primary key of the conversation user
	* @return the conversation user
	* @throws com.sambaash.platform.srv.NoSuchConversationUserException if a conversation user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ConversationUser findByPrimaryKey(
		long spConversationUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationUserException;

	/**
	* Returns the conversation user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spConversationUserId the primary key of the conversation user
	* @return the conversation user, or <code>null</code> if a conversation user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ConversationUser fetchByPrimaryKey(
		long spConversationUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the conversation users.
	*
	* @return the conversation users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ConversationUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the conversation users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of conversation users
	* @param end the upper bound of the range of conversation users (not inclusive)
	* @return the range of conversation users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ConversationUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the conversation users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of conversation users
	* @param end the upper bound of the range of conversation users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of conversation users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ConversationUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the conversation users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of conversation users.
	*
	* @return the number of conversation users
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}