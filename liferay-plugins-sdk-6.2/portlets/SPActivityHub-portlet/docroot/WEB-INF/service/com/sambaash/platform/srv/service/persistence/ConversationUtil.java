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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.model.Conversation;

import java.util.List;

/**
 * The persistence utility for the conversation service. This utility wraps {@link ConversationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author aishwarya
 * @see ConversationPersistence
 * @see ConversationPersistenceImpl
 * @generated
 */
public class ConversationUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Conversation conversation) {
		getPersistence().clearCache(conversation);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Conversation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Conversation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Conversation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Conversation update(Conversation conversation)
		throws SystemException {
		return getPersistence().update(conversation);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Conversation update(Conversation conversation,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(conversation, serviceContext);
	}

	/**
	* Returns all the conversations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Conversation> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.Conversation> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.Conversation> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first conversation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching conversation
	* @throws com.sambaash.platform.srv.NoSuchConversationException if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Conversation findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first conversation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching conversation, or <code>null</code> if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Conversation fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last conversation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching conversation
	* @throws com.sambaash.platform.srv.NoSuchConversationException if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Conversation findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last conversation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching conversation, or <code>null</code> if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Conversation fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Conversation[] findByUuid_PrevAndNext(
		long spConversationId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(spConversationId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the conversations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of conversations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the conversation where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchConversationException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching conversation
	* @throws com.sambaash.platform.srv.NoSuchConversationException if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Conversation findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the conversation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching conversation, or <code>null</code> if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Conversation fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the conversation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching conversation, or <code>null</code> if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Conversation fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the conversation where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the conversation that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Conversation removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of conversations where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the conversations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Conversation> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.Conversation> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.Conversation> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Conversation findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first conversation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching conversation, or <code>null</code> if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Conversation fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Conversation findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last conversation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching conversation, or <code>null</code> if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Conversation fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Conversation[] findByUuid_C_PrevAndNext(
		long spConversationId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(spConversationId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the conversations where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of conversations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

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
	public static com.sambaash.platform.srv.model.Conversation findByentityClassIdEntityIdParentConverstationId(
		long entityClassId, long entityId, long parentConverstationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException {
		return getPersistence()
				   .findByentityClassIdEntityIdParentConverstationId(entityClassId,
			entityId, parentConverstationId);
	}

	/**
	* Returns the conversation where entityClassId = &#63; and entityId = &#63; and parentConverstationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param parentConverstationId the parent converstation ID
	* @return the matching conversation, or <code>null</code> if a matching conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Conversation fetchByentityClassIdEntityIdParentConverstationId(
		long entityClassId, long entityId, long parentConverstationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByentityClassIdEntityIdParentConverstationId(entityClassId,
			entityId, parentConverstationId);
	}

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
	public static com.sambaash.platform.srv.model.Conversation fetchByentityClassIdEntityIdParentConverstationId(
		long entityClassId, long entityId, long parentConverstationId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByentityClassIdEntityIdParentConverstationId(entityClassId,
			entityId, parentConverstationId, retrieveFromCache);
	}

	/**
	* Removes the conversation where entityClassId = &#63; and entityId = &#63; and parentConverstationId = &#63; from the database.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param parentConverstationId the parent converstation ID
	* @return the conversation that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Conversation removeByentityClassIdEntityIdParentConverstationId(
		long entityClassId, long entityId, long parentConverstationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException {
		return getPersistence()
				   .removeByentityClassIdEntityIdParentConverstationId(entityClassId,
			entityId, parentConverstationId);
	}

	/**
	* Returns the number of conversations where entityClassId = &#63; and entityId = &#63; and parentConverstationId = &#63;.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param parentConverstationId the parent converstation ID
	* @return the number of matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByentityClassIdEntityIdParentConverstationId(
		long entityClassId, long entityId, long parentConverstationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByentityClassIdEntityIdParentConverstationId(entityClassId,
			entityId, parentConverstationId);
	}

	/**
	* Returns all the conversations where entityClassId = &#63; and entityId = &#63; and status = &#63;.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param status the status
	* @return the matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Conversation> findByentityClassIdEntityIdStatus(
		long entityClassId, long entityId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByentityClassIdEntityIdStatus(entityClassId, entityId,
			status);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.Conversation> findByentityClassIdEntityIdStatus(
		long entityClassId, long entityId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByentityClassIdEntityIdStatus(entityClassId, entityId,
			status, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.Conversation> findByentityClassIdEntityIdStatus(
		long entityClassId, long entityId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByentityClassIdEntityIdStatus(entityClassId, entityId,
			status, start, end, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Conversation findByentityClassIdEntityIdStatus_First(
		long entityClassId, long entityId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException {
		return getPersistence()
				   .findByentityClassIdEntityIdStatus_First(entityClassId,
			entityId, status, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Conversation fetchByentityClassIdEntityIdStatus_First(
		long entityClassId, long entityId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByentityClassIdEntityIdStatus_First(entityClassId,
			entityId, status, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Conversation findByentityClassIdEntityIdStatus_Last(
		long entityClassId, long entityId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException {
		return getPersistence()
				   .findByentityClassIdEntityIdStatus_Last(entityClassId,
			entityId, status, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Conversation fetchByentityClassIdEntityIdStatus_Last(
		long entityClassId, long entityId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByentityClassIdEntityIdStatus_Last(entityClassId,
			entityId, status, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Conversation[] findByentityClassIdEntityIdStatus_PrevAndNext(
		long spConversationId, long entityClassId, long entityId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException {
		return getPersistence()
				   .findByentityClassIdEntityIdStatus_PrevAndNext(spConversationId,
			entityClassId, entityId, status, orderByComparator);
	}

	/**
	* Removes all the conversations where entityClassId = &#63; and entityId = &#63; and status = &#63; from the database.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByentityClassIdEntityIdStatus(long entityClassId,
		long entityId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByentityClassIdEntityIdStatus(entityClassId, entityId, status);
	}

	/**
	* Returns the number of conversations where entityClassId = &#63; and entityId = &#63; and status = &#63;.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param status the status
	* @return the number of matching conversations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByentityClassIdEntityIdStatus(long entityClassId,
		long entityId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByentityClassIdEntityIdStatus(entityClassId, entityId,
			status);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.Conversation> findByassociatedWithRestrictedEntityIdEntityClassIdStatus(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByassociatedWithRestrictedEntityIdEntityClassIdStatus(associatedWith,
			restricted, entityId, entityClassId, status);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.Conversation> findByassociatedWithRestrictedEntityIdEntityClassIdStatus(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByassociatedWithRestrictedEntityIdEntityClassIdStatus(associatedWith,
			restricted, entityId, entityClassId, status, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.Conversation> findByassociatedWithRestrictedEntityIdEntityClassIdStatus(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByassociatedWithRestrictedEntityIdEntityClassIdStatus(associatedWith,
			restricted, entityId, entityClassId, status, start, end,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Conversation findByassociatedWithRestrictedEntityIdEntityClassIdStatus_First(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException {
		return getPersistence()
				   .findByassociatedWithRestrictedEntityIdEntityClassIdStatus_First(associatedWith,
			restricted, entityId, entityClassId, status, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Conversation fetchByassociatedWithRestrictedEntityIdEntityClassIdStatus_First(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByassociatedWithRestrictedEntityIdEntityClassIdStatus_First(associatedWith,
			restricted, entityId, entityClassId, status, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Conversation findByassociatedWithRestrictedEntityIdEntityClassIdStatus_Last(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException {
		return getPersistence()
				   .findByassociatedWithRestrictedEntityIdEntityClassIdStatus_Last(associatedWith,
			restricted, entityId, entityClassId, status, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Conversation fetchByassociatedWithRestrictedEntityIdEntityClassIdStatus_Last(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByassociatedWithRestrictedEntityIdEntityClassIdStatus_Last(associatedWith,
			restricted, entityId, entityClassId, status, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.Conversation[] findByassociatedWithRestrictedEntityIdEntityClassIdStatus_PrevAndNext(
		long spConversationId, long associatedWith, int restricted,
		long entityId, long entityClassId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException {
		return getPersistence()
				   .findByassociatedWithRestrictedEntityIdEntityClassIdStatus_PrevAndNext(spConversationId,
			associatedWith, restricted, entityId, entityClassId, status,
			orderByComparator);
	}

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
	public static void removeByassociatedWithRestrictedEntityIdEntityClassIdStatus(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByassociatedWithRestrictedEntityIdEntityClassIdStatus(associatedWith,
			restricted, entityId, entityClassId, status);
	}

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
	public static int countByassociatedWithRestrictedEntityIdEntityClassIdStatus(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByassociatedWithRestrictedEntityIdEntityClassIdStatus(associatedWith,
			restricted, entityId, entityClassId, status);
	}

	/**
	* Caches the conversation in the entity cache if it is enabled.
	*
	* @param conversation the conversation
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.model.Conversation conversation) {
		getPersistence().cacheResult(conversation);
	}

	/**
	* Caches the conversations in the entity cache if it is enabled.
	*
	* @param conversations the conversations
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.Conversation> conversations) {
		getPersistence().cacheResult(conversations);
	}

	/**
	* Creates a new conversation with the primary key. Does not add the conversation to the database.
	*
	* @param spConversationId the primary key for the new conversation
	* @return the new conversation
	*/
	public static com.sambaash.platform.srv.model.Conversation create(
		long spConversationId) {
		return getPersistence().create(spConversationId);
	}

	/**
	* Removes the conversation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spConversationId the primary key of the conversation
	* @return the conversation that was removed
	* @throws com.sambaash.platform.srv.NoSuchConversationException if a conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Conversation remove(
		long spConversationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException {
		return getPersistence().remove(spConversationId);
	}

	public static com.sambaash.platform.srv.model.Conversation updateImpl(
		com.sambaash.platform.srv.model.Conversation conversation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(conversation);
	}

	/**
	* Returns the conversation with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchConversationException} if it could not be found.
	*
	* @param spConversationId the primary key of the conversation
	* @return the conversation
	* @throws com.sambaash.platform.srv.NoSuchConversationException if a conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Conversation findByPrimaryKey(
		long spConversationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchConversationException {
		return getPersistence().findByPrimaryKey(spConversationId);
	}

	/**
	* Returns the conversation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spConversationId the primary key of the conversation
	* @return the conversation, or <code>null</code> if a conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Conversation fetchByPrimaryKey(
		long spConversationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spConversationId);
	}

	/**
	* Returns all the conversations.
	*
	* @return the conversations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Conversation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.Conversation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.Conversation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the conversations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of conversations.
	*
	* @return the number of conversations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ConversationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ConversationPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.service.ClpSerializer.getServletContextName(),
					ConversationPersistence.class.getName());

			ReferenceRegistry.registerReference(ConversationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ConversationPersistence persistence) {
	}

	private static ConversationPersistence _persistence;
}