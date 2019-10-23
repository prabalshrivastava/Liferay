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

import com.sambaash.platform.srv.model.Conversation;

/**
 * The persistence interface for the conversation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author aishwarya
 * @see ConversationPersistenceImpl
 * @see ConversationUtil
 * @generated
 */
public interface ConversationPersistence extends BasePersistence<Conversation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ConversationUtil} to access the conversation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the conversations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Conversation> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the conversations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of conversations
	* @param end the upper bound of the range of conversations (not inclusive)
	* @return the range of matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Conversation> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the conversations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of conversations
	* @param end the upper bound of the range of conversations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Conversation> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first conversation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching conversation
	* @throws com.sambaash.platform.srv.NoSuchConversationException if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException;

	/**
	* Returns the first conversation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching conversation, or <code>null</code> if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last conversation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching conversation
	* @throws com.sambaash.platform.srv.NoSuchConversationException if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException;

	/**
	* Returns the last conversation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching conversation, or <code>null</code> if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the conversations before and after the current conversation in the ordered set where uuid = &#63;.
	*
	* @param spConversationId the primary key of the current conversation
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next conversation
	* @throws com.sambaash.platform.srv.NoSuchConversationException if a conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation[] findByUuid_PrevAndNext(
		long spConversationId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException;

	/**
	* Removes all the conversations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of conversations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the conversation where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchConversationException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching conversation
	* @throws com.sambaash.platform.srv.NoSuchConversationException if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException;

	/**
	* Returns the conversation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching conversation, or <code>null</code> if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the conversation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching conversation, or <code>null</code> if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the conversation where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the conversation that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException;

	/**
	* Returns the number of conversations where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the conversations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Conversation> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the conversations where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of conversations
	* @param end the upper bound of the range of conversations (not inclusive)
	* @return the range of matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Conversation> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the conversations where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of conversations
	* @param end the upper bound of the range of conversations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Conversation> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first conversation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching conversation
	* @throws com.sambaash.platform.srv.NoSuchConversationException if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException;

	/**
	* Returns the first conversation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching conversation, or <code>null</code> if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last conversation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching conversation
	* @throws com.sambaash.platform.srv.NoSuchConversationException if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException;

	/**
	* Returns the last conversation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching conversation, or <code>null</code> if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the conversations before and after the current conversation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spConversationId the primary key of the current conversation
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next conversation
	* @throws com.sambaash.platform.srv.NoSuchConversationException if a conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation[] findByUuid_C_PrevAndNext(
		long spConversationId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException;

	/**
	* Removes all the conversations where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of conversations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the conversation where entityClassId = &#63; and entityId = &#63; and parentConverstationId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchConversationException} if it could not be found.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param parentConverstationId the parent converstation ID
	* @return the matching conversation
	* @throws com.sambaash.platform.srv.NoSuchConversationException if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation findByentityClassIdEntityIdParentConverstationId(
		long entityClassId, long entityId, long parentConverstationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException;

	/**
	* Returns the conversation where entityClassId = &#63; and entityId = &#63; and parentConverstationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param parentConverstationId the parent converstation ID
	* @return the matching conversation, or <code>null</code> if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation fetchByentityClassIdEntityIdParentConverstationId(
		long entityClassId, long entityId, long parentConverstationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the conversation where entityClassId = &#63; and entityId = &#63; and parentConverstationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param parentConverstationId the parent converstation ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching conversation, or <code>null</code> if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation fetchByentityClassIdEntityIdParentConverstationId(
		long entityClassId, long entityId, long parentConverstationId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the conversation where entityClassId = &#63; and entityId = &#63; and parentConverstationId = &#63; from the database.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param parentConverstationId the parent converstation ID
	* @return the conversation that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation removeByentityClassIdEntityIdParentConverstationId(
		long entityClassId, long entityId, long parentConverstationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException;

	/**
	* Returns the number of conversations where entityClassId = &#63; and entityId = &#63; and parentConverstationId = &#63;.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param parentConverstationId the parent converstation ID
	* @return the number of matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public int countByentityClassIdEntityIdParentConverstationId(
		long entityClassId, long entityId, long parentConverstationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the conversations where entityClassId = &#63; and entityId = &#63; and status = &#63;.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param status the status
	* @return the matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Conversation> findByentityClassIdEntityIdStatus(
		long entityClassId, long entityId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the conversations where entityClassId = &#63; and entityId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param status the status
	* @param start the lower bound of the range of conversations
	* @param end the upper bound of the range of conversations (not inclusive)
	* @return the range of matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Conversation> findByentityClassIdEntityIdStatus(
		long entityClassId, long entityId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the conversations where entityClassId = &#63; and entityId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param status the status
	* @param start the lower bound of the range of conversations
	* @param end the upper bound of the range of conversations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Conversation> findByentityClassIdEntityIdStatus(
		long entityClassId, long entityId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first conversation in the ordered set where entityClassId = &#63; and entityId = &#63; and status = &#63;.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching conversation
	* @throws com.sambaash.platform.srv.NoSuchConversationException if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation findByentityClassIdEntityIdStatus_First(
		long entityClassId, long entityId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException;

	/**
	* Returns the first conversation in the ordered set where entityClassId = &#63; and entityId = &#63; and status = &#63;.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching conversation, or <code>null</code> if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation fetchByentityClassIdEntityIdStatus_First(
		long entityClassId, long entityId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last conversation in the ordered set where entityClassId = &#63; and entityId = &#63; and status = &#63;.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching conversation
	* @throws com.sambaash.platform.srv.NoSuchConversationException if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation findByentityClassIdEntityIdStatus_Last(
		long entityClassId, long entityId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException;

	/**
	* Returns the last conversation in the ordered set where entityClassId = &#63; and entityId = &#63; and status = &#63;.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching conversation, or <code>null</code> if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation fetchByentityClassIdEntityIdStatus_Last(
		long entityClassId, long entityId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the conversations before and after the current conversation in the ordered set where entityClassId = &#63; and entityId = &#63; and status = &#63;.
	*
	* @param spConversationId the primary key of the current conversation
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next conversation
	* @throws com.sambaash.platform.srv.NoSuchConversationException if a conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation[] findByentityClassIdEntityIdStatus_PrevAndNext(
		long spConversationId, long entityClassId, long entityId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException;

	/**
	* Removes all the conversations where entityClassId = &#63; and entityId = &#63; and status = &#63; from the database.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByentityClassIdEntityIdStatus(long entityClassId,
		long entityId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of conversations where entityClassId = &#63; and entityId = &#63; and status = &#63;.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param status the status
	* @return the number of matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public int countByentityClassIdEntityIdStatus(long entityClassId,
		long entityId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the conversations where associatedWith = &#63; and restricted = &#63; and entityId = &#63; and entityClassId = &#63; and status = &#63;.
	*
	* @param associatedWith the associated with
	* @param restricted the restricted
	* @param entityId the entity ID
	* @param entityClassId the entity class ID
	* @param status the status
	* @return the matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Conversation> findByassociatedWithRestrictedEntityIdEntityClassIdStatus(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the conversations where associatedWith = &#63; and restricted = &#63; and entityId = &#63; and entityClassId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param associatedWith the associated with
	* @param restricted the restricted
	* @param entityId the entity ID
	* @param entityClassId the entity class ID
	* @param status the status
	* @param start the lower bound of the range of conversations
	* @param end the upper bound of the range of conversations (not inclusive)
	* @return the range of matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Conversation> findByassociatedWithRestrictedEntityIdEntityClassIdStatus(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the conversations where associatedWith = &#63; and restricted = &#63; and entityId = &#63; and entityClassId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param associatedWith the associated with
	* @param restricted the restricted
	* @param entityId the entity ID
	* @param entityClassId the entity class ID
	* @param status the status
	* @param start the lower bound of the range of conversations
	* @param end the upper bound of the range of conversations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Conversation> findByassociatedWithRestrictedEntityIdEntityClassIdStatus(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first conversation in the ordered set where associatedWith = &#63; and restricted = &#63; and entityId = &#63; and entityClassId = &#63; and status = &#63;.
	*
	* @param associatedWith the associated with
	* @param restricted the restricted
	* @param entityId the entity ID
	* @param entityClassId the entity class ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching conversation
	* @throws com.sambaash.platform.srv.NoSuchConversationException if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation findByassociatedWithRestrictedEntityIdEntityClassIdStatus_First(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException;

	/**
	* Returns the first conversation in the ordered set where associatedWith = &#63; and restricted = &#63; and entityId = &#63; and entityClassId = &#63; and status = &#63;.
	*
	* @param associatedWith the associated with
	* @param restricted the restricted
	* @param entityId the entity ID
	* @param entityClassId the entity class ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching conversation, or <code>null</code> if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation fetchByassociatedWithRestrictedEntityIdEntityClassIdStatus_First(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last conversation in the ordered set where associatedWith = &#63; and restricted = &#63; and entityId = &#63; and entityClassId = &#63; and status = &#63;.
	*
	* @param associatedWith the associated with
	* @param restricted the restricted
	* @param entityId the entity ID
	* @param entityClassId the entity class ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching conversation
	* @throws com.sambaash.platform.srv.NoSuchConversationException if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation findByassociatedWithRestrictedEntityIdEntityClassIdStatus_Last(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException;

	/**
	* Returns the last conversation in the ordered set where associatedWith = &#63; and restricted = &#63; and entityId = &#63; and entityClassId = &#63; and status = &#63;.
	*
	* @param associatedWith the associated with
	* @param restricted the restricted
	* @param entityId the entity ID
	* @param entityClassId the entity class ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching conversation, or <code>null</code> if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation fetchByassociatedWithRestrictedEntityIdEntityClassIdStatus_Last(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the conversations before and after the current conversation in the ordered set where associatedWith = &#63; and restricted = &#63; and entityId = &#63; and entityClassId = &#63; and status = &#63;.
	*
	* @param spConversationId the primary key of the current conversation
	* @param associatedWith the associated with
	* @param restricted the restricted
	* @param entityId the entity ID
	* @param entityClassId the entity class ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next conversation
	* @throws com.sambaash.platform.srv.NoSuchConversationException if a conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation[] findByassociatedWithRestrictedEntityIdEntityClassIdStatus_PrevAndNext(
		long spConversationId, long associatedWith, int restricted,
		long entityId, long entityClassId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException;

	/**
	* Removes all the conversations where associatedWith = &#63; and restricted = &#63; and entityId = &#63; and entityClassId = &#63; and status = &#63; from the database.
	*
	* @param associatedWith the associated with
	* @param restricted the restricted
	* @param entityId the entity ID
	* @param entityClassId the entity class ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByassociatedWithRestrictedEntityIdEntityClassIdStatus(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of conversations where associatedWith = &#63; and restricted = &#63; and entityId = &#63; and entityClassId = &#63; and status = &#63;.
	*
	* @param associatedWith the associated with
	* @param restricted the restricted
	* @param entityId the entity ID
	* @param entityClassId the entity class ID
	* @param status the status
	* @return the number of matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public int countByassociatedWithRestrictedEntityIdEntityClassIdStatus(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the conversation in the entity cache if it is enabled.
	*
	* @param conversation the conversation
	*/
	public void cacheResult(
		com.sambaash.platform.srv.model.Conversation conversation);

	/**
	* Caches the conversations in the entity cache if it is enabled.
	*
	* @param conversations the conversations
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.Conversation> conversations);

	/**
	* Creates a new conversation with the primary key. Does not add the conversation to the database.
	*
	* @param spConversationId the primary key for the new conversation
	* @return the new conversation
	*/
	public com.sambaash.platform.srv.model.Conversation create(
		long spConversationId);

	/**
	* Removes the conversation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spConversationId the primary key of the conversation
	* @return the conversation that was removed
	* @throws com.sambaash.platform.srv.NoSuchConversationException if a conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation remove(
		long spConversationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException;

	public com.sambaash.platform.srv.model.Conversation updateImpl(
		com.sambaash.platform.srv.model.Conversation conversation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the conversation with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchConversationException} if it could not be found.
	*
	* @param spConversationId the primary key of the conversation
	* @return the conversation
	* @throws com.sambaash.platform.srv.NoSuchConversationException if a conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation findByPrimaryKey(
		long spConversationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException;

	/**
	* Returns the conversation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spConversationId the primary key of the conversation
	* @return the conversation, or <code>null</code> if a conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Conversation fetchByPrimaryKey(
		long spConversationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the conversations.
	*
	* @return the conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Conversation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the conversations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of conversations
	* @param end the upper bound of the range of conversations (not inclusive)
	* @return the range of conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Conversation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the conversations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ConversationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of conversations
	* @param end the upper bound of the range of conversations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Conversation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the conversations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of conversations.
	*
	* @return the number of conversations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}