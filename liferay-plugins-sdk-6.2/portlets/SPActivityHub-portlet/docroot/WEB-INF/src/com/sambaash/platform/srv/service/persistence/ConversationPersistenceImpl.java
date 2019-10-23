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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.NoSuchConversationException;
import com.sambaash.platform.srv.model.Conversation;
import com.sambaash.platform.srv.model.impl.ConversationImpl;
import com.sambaash.platform.srv.model.impl.ConversationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the conversation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author aishwarya
 * @see ConversationPersistence
 * @see ConversationUtil
 * @generated
 */
public class ConversationPersistenceImpl extends BasePersistenceImpl<Conversation>
	implements ConversationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ConversationUtil} to access the conversation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ConversationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ConversationModelImpl.ENTITY_CACHE_ENABLED,
			ConversationModelImpl.FINDER_CACHE_ENABLED, ConversationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ConversationModelImpl.ENTITY_CACHE_ENABLED,
			ConversationModelImpl.FINDER_CACHE_ENABLED, ConversationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ConversationModelImpl.ENTITY_CACHE_ENABLED,
			ConversationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ConversationModelImpl.ENTITY_CACHE_ENABLED,
			ConversationModelImpl.FINDER_CACHE_ENABLED, ConversationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ConversationModelImpl.ENTITY_CACHE_ENABLED,
			ConversationModelImpl.FINDER_CACHE_ENABLED, ConversationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ConversationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ConversationModelImpl.ENTITY_CACHE_ENABLED,
			ConversationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the conversations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching conversations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Conversation> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Conversation> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Conversation> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Conversation> list = (List<Conversation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Conversation conversation : list) {
				if (!Validator.equals(uuid, conversation.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CONVERSATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ConversationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Conversation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Conversation>(list);
				}
				else {
					list = (List<Conversation>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Conversation findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchConversationException, SystemException {
		Conversation conversation = fetchByUuid_First(uuid, orderByComparator);

		if (conversation != null) {
			return conversation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConversationException(msg.toString());
	}

	/**
	 * Returns the first conversation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching conversation, or <code>null</code> if a matching conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Conversation fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Conversation> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Conversation findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchConversationException, SystemException {
		Conversation conversation = fetchByUuid_Last(uuid, orderByComparator);

		if (conversation != null) {
			return conversation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConversationException(msg.toString());
	}

	/**
	 * Returns the last conversation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching conversation, or <code>null</code> if a matching conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Conversation fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Conversation> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Conversation[] findByUuid_PrevAndNext(long spConversationId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchConversationException, SystemException {
		Conversation conversation = findByPrimaryKey(spConversationId);

		Session session = null;

		try {
			session = openSession();

			Conversation[] array = new ConversationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, conversation, uuid,
					orderByComparator, true);

			array[1] = conversation;

			array[2] = getByUuid_PrevAndNext(session, conversation, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Conversation getByUuid_PrevAndNext(Session session,
		Conversation conversation, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONVERSATION_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ConversationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(conversation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Conversation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the conversations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Conversation conversation : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(conversation);
		}
	}

	/**
	 * Returns the number of conversations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching conversations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONVERSATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "conversation.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "conversation.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(conversation.uuid IS NULL OR conversation.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ConversationModelImpl.ENTITY_CACHE_ENABLED,
			ConversationModelImpl.FINDER_CACHE_ENABLED, ConversationImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ConversationModelImpl.UUID_COLUMN_BITMASK |
			ConversationModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ConversationModelImpl.ENTITY_CACHE_ENABLED,
			ConversationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the conversation where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchConversationException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching conversation
	 * @throws com.sambaash.platform.srv.NoSuchConversationException if a matching conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Conversation findByUUID_G(String uuid, long groupId)
		throws NoSuchConversationException, SystemException {
		Conversation conversation = fetchByUUID_G(uuid, groupId);

		if (conversation == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchConversationException(msg.toString());
		}

		return conversation;
	}

	/**
	 * Returns the conversation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching conversation, or <code>null</code> if a matching conversation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Conversation fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
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
	@Override
	public Conversation fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Conversation) {
			Conversation conversation = (Conversation)result;

			if (!Validator.equals(uuid, conversation.getUuid()) ||
					(groupId != conversation.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CONVERSATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Conversation> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Conversation conversation = list.get(0);

					result = conversation;

					cacheResult(conversation);

					if ((conversation.getUuid() == null) ||
							!conversation.getUuid().equals(uuid) ||
							(conversation.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, conversation);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Conversation)result;
		}
	}

	/**
	 * Removes the conversation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the conversation that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Conversation removeByUUID_G(String uuid, long groupId)
		throws NoSuchConversationException, SystemException {
		Conversation conversation = findByUUID_G(uuid, groupId);

		return remove(conversation);
	}

	/**
	 * Returns the number of conversations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching conversations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONVERSATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "conversation.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "conversation.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(conversation.uuid IS NULL OR conversation.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "conversation.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ConversationModelImpl.ENTITY_CACHE_ENABLED,
			ConversationModelImpl.FINDER_CACHE_ENABLED, ConversationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ConversationModelImpl.ENTITY_CACHE_ENABLED,
			ConversationModelImpl.FINDER_CACHE_ENABLED, ConversationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ConversationModelImpl.UUID_COLUMN_BITMASK |
			ConversationModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ConversationModelImpl.ENTITY_CACHE_ENABLED,
			ConversationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the conversations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching conversations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Conversation> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Conversation> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Conversation> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Conversation> list = (List<Conversation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Conversation conversation : list) {
				if (!Validator.equals(uuid, conversation.getUuid()) ||
						(companyId != conversation.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CONVERSATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ConversationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Conversation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Conversation>(list);
				}
				else {
					list = (List<Conversation>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Conversation findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchConversationException, SystemException {
		Conversation conversation = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (conversation != null) {
			return conversation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConversationException(msg.toString());
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
	@Override
	public Conversation fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Conversation> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Conversation findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchConversationException, SystemException {
		Conversation conversation = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (conversation != null) {
			return conversation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConversationException(msg.toString());
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
	@Override
	public Conversation fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Conversation> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Conversation[] findByUuid_C_PrevAndNext(long spConversationId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchConversationException, SystemException {
		Conversation conversation = findByPrimaryKey(spConversationId);

		Session session = null;

		try {
			session = openSession();

			Conversation[] array = new ConversationImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, conversation, uuid,
					companyId, orderByComparator, true);

			array[1] = conversation;

			array[2] = getByUuid_C_PrevAndNext(session, conversation, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Conversation getByUuid_C_PrevAndNext(Session session,
		Conversation conversation, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONVERSATION_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ConversationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(conversation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Conversation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the conversations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (Conversation conversation : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(conversation);
		}
	}

	/**
	 * Returns the number of conversations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching conversations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONVERSATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "conversation.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "conversation.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(conversation.uuid IS NULL OR conversation.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "conversation.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID =
		new FinderPath(ConversationModelImpl.ENTITY_CACHE_ENABLED,
			ConversationModelImpl.FINDER_CACHE_ENABLED, ConversationImpl.class,
			FINDER_CLASS_NAME_ENTITY,
			"fetchByentityClassIdEntityIdParentConverstationId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			ConversationModelImpl.ENTITYCLASSID_COLUMN_BITMASK |
			ConversationModelImpl.ENTITYID_COLUMN_BITMASK |
			ConversationModelImpl.PARENTCONVERSTATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID =
		new FinderPath(ConversationModelImpl.ENTITY_CACHE_ENABLED,
			ConversationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByentityClassIdEntityIdParentConverstationId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

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
	@Override
	public Conversation findByentityClassIdEntityIdParentConverstationId(
		long entityClassId, long entityId, long parentConverstationId)
		throws NoSuchConversationException, SystemException {
		Conversation conversation = fetchByentityClassIdEntityIdParentConverstationId(entityClassId,
				entityId, parentConverstationId);

		if (conversation == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("entityClassId=");
			msg.append(entityClassId);

			msg.append(", entityId=");
			msg.append(entityId);

			msg.append(", parentConverstationId=");
			msg.append(parentConverstationId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchConversationException(msg.toString());
		}

		return conversation;
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
	@Override
	public Conversation fetchByentityClassIdEntityIdParentConverstationId(
		long entityClassId, long entityId, long parentConverstationId)
		throws SystemException {
		return fetchByentityClassIdEntityIdParentConverstationId(entityClassId,
			entityId, parentConverstationId, true);
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
	@Override
	public Conversation fetchByentityClassIdEntityIdParentConverstationId(
		long entityClassId, long entityId, long parentConverstationId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				entityClassId, entityId, parentConverstationId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID,
					finderArgs, this);
		}

		if (result instanceof Conversation) {
			Conversation conversation = (Conversation)result;

			if ((entityClassId != conversation.getEntityClassId()) ||
					(entityId != conversation.getEntityId()) ||
					(parentConverstationId != conversation.getParentConverstationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_CONVERSATION_WHERE);

			query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID_ENTITYCLASSID_2);

			query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID_ENTITYID_2);

			query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID_PARENTCONVERSTATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entityClassId);

				qPos.add(entityId);

				qPos.add(parentConverstationId);

				List<Conversation> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ConversationPersistenceImpl.fetchByentityClassIdEntityIdParentConverstationId(long, long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Conversation conversation = list.get(0);

					result = conversation;

					cacheResult(conversation);

					if ((conversation.getEntityClassId() != entityClassId) ||
							(conversation.getEntityId() != entityId) ||
							(conversation.getParentConverstationId() != parentConverstationId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID,
							finderArgs, conversation);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Conversation)result;
		}
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
	@Override
	public Conversation removeByentityClassIdEntityIdParentConverstationId(
		long entityClassId, long entityId, long parentConverstationId)
		throws NoSuchConversationException, SystemException {
		Conversation conversation = findByentityClassIdEntityIdParentConverstationId(entityClassId,
				entityId, parentConverstationId);

		return remove(conversation);
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
	@Override
	public int countByentityClassIdEntityIdParentConverstationId(
		long entityClassId, long entityId, long parentConverstationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID;

		Object[] finderArgs = new Object[] {
				entityClassId, entityId, parentConverstationId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CONVERSATION_WHERE);

			query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID_ENTITYCLASSID_2);

			query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID_ENTITYID_2);

			query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID_PARENTCONVERSTATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entityClassId);

				qPos.add(entityId);

				qPos.add(parentConverstationId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID_ENTITYCLASSID_2 =
		"conversation.entityClassId = ? AND ";
	private static final String _FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID_ENTITYID_2 =
		"conversation.entityId = ? AND ";
	private static final String _FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID_PARENTCONVERSTATIONID_2 =
		"conversation.parentConverstationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ENTITYCLASSIDENTITYIDSTATUS =
		new FinderPath(ConversationModelImpl.ENTITY_CACHE_ENABLED,
			ConversationModelImpl.FINDER_CACHE_ENABLED, ConversationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByentityClassIdEntityIdStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITYCLASSIDENTITYIDSTATUS =
		new FinderPath(ConversationModelImpl.ENTITY_CACHE_ENABLED,
			ConversationModelImpl.FINDER_CACHE_ENABLED, ConversationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByentityClassIdEntityIdStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			ConversationModelImpl.ENTITYCLASSID_COLUMN_BITMASK |
			ConversationModelImpl.ENTITYID_COLUMN_BITMASK |
			ConversationModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ENTITYCLASSIDENTITYIDSTATUS =
		new FinderPath(ConversationModelImpl.ENTITY_CACHE_ENABLED,
			ConversationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByentityClassIdEntityIdStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the conversations where entityClassId = &#63; and entityId = &#63; and status = &#63;.
	 *
	 * @param entityClassId the entity class ID
	 * @param entityId the entity ID
	 * @param status the status
	 * @return the matching conversations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Conversation> findByentityClassIdEntityIdStatus(
		long entityClassId, long entityId, int status)
		throws SystemException {
		return findByentityClassIdEntityIdStatus(entityClassId, entityId,
			status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Conversation> findByentityClassIdEntityIdStatus(
		long entityClassId, long entityId, int status, int start, int end)
		throws SystemException {
		return findByentityClassIdEntityIdStatus(entityClassId, entityId,
			status, start, end, null);
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
	@Override
	public List<Conversation> findByentityClassIdEntityIdStatus(
		long entityClassId, long entityId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITYCLASSIDENTITYIDSTATUS;
			finderArgs = new Object[] { entityClassId, entityId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ENTITYCLASSIDENTITYIDSTATUS;
			finderArgs = new Object[] {
					entityClassId, entityId, status,
					
					start, end, orderByComparator
				};
		}

		List<Conversation> list = (List<Conversation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Conversation conversation : list) {
				if ((entityClassId != conversation.getEntityClassId()) ||
						(entityId != conversation.getEntityId()) ||
						(status != conversation.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_CONVERSATION_WHERE);

			query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDSTATUS_ENTITYCLASSID_2);

			query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDSTATUS_ENTITYID_2);

			query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ConversationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entityClassId);

				qPos.add(entityId);

				qPos.add(status);

				if (!pagination) {
					list = (List<Conversation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Conversation>(list);
				}
				else {
					list = (List<Conversation>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Conversation findByentityClassIdEntityIdStatus_First(
		long entityClassId, long entityId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchConversationException, SystemException {
		Conversation conversation = fetchByentityClassIdEntityIdStatus_First(entityClassId,
				entityId, status, orderByComparator);

		if (conversation != null) {
			return conversation;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("entityClassId=");
		msg.append(entityClassId);

		msg.append(", entityId=");
		msg.append(entityId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConversationException(msg.toString());
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
	@Override
	public Conversation fetchByentityClassIdEntityIdStatus_First(
		long entityClassId, long entityId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<Conversation> list = findByentityClassIdEntityIdStatus(entityClassId,
				entityId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Conversation findByentityClassIdEntityIdStatus_Last(
		long entityClassId, long entityId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchConversationException, SystemException {
		Conversation conversation = fetchByentityClassIdEntityIdStatus_Last(entityClassId,
				entityId, status, orderByComparator);

		if (conversation != null) {
			return conversation;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("entityClassId=");
		msg.append(entityClassId);

		msg.append(", entityId=");
		msg.append(entityId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConversationException(msg.toString());
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
	@Override
	public Conversation fetchByentityClassIdEntityIdStatus_Last(
		long entityClassId, long entityId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByentityClassIdEntityIdStatus(entityClassId, entityId,
				status);

		if (count == 0) {
			return null;
		}

		List<Conversation> list = findByentityClassIdEntityIdStatus(entityClassId,
				entityId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Conversation[] findByentityClassIdEntityIdStatus_PrevAndNext(
		long spConversationId, long entityClassId, long entityId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchConversationException, SystemException {
		Conversation conversation = findByPrimaryKey(spConversationId);

		Session session = null;

		try {
			session = openSession();

			Conversation[] array = new ConversationImpl[3];

			array[0] = getByentityClassIdEntityIdStatus_PrevAndNext(session,
					conversation, entityClassId, entityId, status,
					orderByComparator, true);

			array[1] = conversation;

			array[2] = getByentityClassIdEntityIdStatus_PrevAndNext(session,
					conversation, entityClassId, entityId, status,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Conversation getByentityClassIdEntityIdStatus_PrevAndNext(
		Session session, Conversation conversation, long entityClassId,
		long entityId, int status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONVERSATION_WHERE);

		query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDSTATUS_ENTITYCLASSID_2);

		query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDSTATUS_ENTITYID_2);

		query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDSTATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ConversationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(entityClassId);

		qPos.add(entityId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(conversation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Conversation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the conversations where entityClassId = &#63; and entityId = &#63; and status = &#63; from the database.
	 *
	 * @param entityClassId the entity class ID
	 * @param entityId the entity ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByentityClassIdEntityIdStatus(long entityClassId,
		long entityId, int status) throws SystemException {
		for (Conversation conversation : findByentityClassIdEntityIdStatus(
				entityClassId, entityId, status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(conversation);
		}
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
	@Override
	public int countByentityClassIdEntityIdStatus(long entityClassId,
		long entityId, int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ENTITYCLASSIDENTITYIDSTATUS;

		Object[] finderArgs = new Object[] { entityClassId, entityId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CONVERSATION_WHERE);

			query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDSTATUS_ENTITYCLASSID_2);

			query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDSTATUS_ENTITYID_2);

			query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entityClassId);

				qPos.add(entityId);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ENTITYCLASSIDENTITYIDSTATUS_ENTITYCLASSID_2 =
		"conversation.entityClassId = ? AND ";
	private static final String _FINDER_COLUMN_ENTITYCLASSIDENTITYIDSTATUS_ENTITYID_2 =
		"conversation.entityId = ? AND ";
	private static final String _FINDER_COLUMN_ENTITYCLASSIDENTITYIDSTATUS_STATUS_2 =
		"conversation.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS =
		new FinderPath(ConversationModelImpl.ENTITY_CACHE_ENABLED,
			ConversationModelImpl.FINDER_CACHE_ENABLED, ConversationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByassociatedWithRestrictedEntityIdEntityClassIdStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS =
		new FinderPath(ConversationModelImpl.ENTITY_CACHE_ENABLED,
			ConversationModelImpl.FINDER_CACHE_ENABLED, ConversationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByassociatedWithRestrictedEntityIdEntityClassIdStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			ConversationModelImpl.ASSOCIATEDWITH_COLUMN_BITMASK |
			ConversationModelImpl.RESTRICTED_COLUMN_BITMASK |
			ConversationModelImpl.ENTITYID_COLUMN_BITMASK |
			ConversationModelImpl.ENTITYCLASSID_COLUMN_BITMASK |
			ConversationModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS =
		new FinderPath(ConversationModelImpl.ENTITY_CACHE_ENABLED,
			ConversationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByassociatedWithRestrictedEntityIdEntityClassIdStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

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
	@Override
	public List<Conversation> findByassociatedWithRestrictedEntityIdEntityClassIdStatus(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status) throws SystemException {
		return findByassociatedWithRestrictedEntityIdEntityClassIdStatus(associatedWith,
			restricted, entityId, entityClassId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Conversation> findByassociatedWithRestrictedEntityIdEntityClassIdStatus(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status, int start, int end) throws SystemException {
		return findByassociatedWithRestrictedEntityIdEntityClassIdStatus(associatedWith,
			restricted, entityId, entityClassId, status, start, end, null);
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
	@Override
	public List<Conversation> findByassociatedWithRestrictedEntityIdEntityClassIdStatus(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS;
			finderArgs = new Object[] {
					associatedWith, restricted, entityId, entityClassId, status
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS;
			finderArgs = new Object[] {
					associatedWith, restricted, entityId, entityClassId, status,
					
					start, end, orderByComparator
				};
		}

		List<Conversation> list = (List<Conversation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Conversation conversation : list) {
				if ((associatedWith != conversation.getAssociatedWith()) ||
						(restricted != conversation.getRestricted()) ||
						(entityId != conversation.getEntityId()) ||
						(entityClassId != conversation.getEntityClassId()) ||
						(status != conversation.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(7 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(7);
			}

			query.append(_SQL_SELECT_CONVERSATION_WHERE);

			query.append(_FINDER_COLUMN_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS_ASSOCIATEDWITH_2);

			query.append(_FINDER_COLUMN_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS_RESTRICTED_2);

			query.append(_FINDER_COLUMN_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS_ENTITYID_2);

			query.append(_FINDER_COLUMN_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS_ENTITYCLASSID_2);

			query.append(_FINDER_COLUMN_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ConversationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(associatedWith);

				qPos.add(restricted);

				qPos.add(entityId);

				qPos.add(entityClassId);

				qPos.add(status);

				if (!pagination) {
					list = (List<Conversation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Conversation>(list);
				}
				else {
					list = (List<Conversation>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Conversation findByassociatedWithRestrictedEntityIdEntityClassIdStatus_First(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchConversationException, SystemException {
		Conversation conversation = fetchByassociatedWithRestrictedEntityIdEntityClassIdStatus_First(associatedWith,
				restricted, entityId, entityClassId, status, orderByComparator);

		if (conversation != null) {
			return conversation;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("associatedWith=");
		msg.append(associatedWith);

		msg.append(", restricted=");
		msg.append(restricted);

		msg.append(", entityId=");
		msg.append(entityId);

		msg.append(", entityClassId=");
		msg.append(entityClassId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConversationException(msg.toString());
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
	@Override
	public Conversation fetchByassociatedWithRestrictedEntityIdEntityClassIdStatus_First(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<Conversation> list = findByassociatedWithRestrictedEntityIdEntityClassIdStatus(associatedWith,
				restricted, entityId, entityClassId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Conversation findByassociatedWithRestrictedEntityIdEntityClassIdStatus_Last(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchConversationException, SystemException {
		Conversation conversation = fetchByassociatedWithRestrictedEntityIdEntityClassIdStatus_Last(associatedWith,
				restricted, entityId, entityClassId, status, orderByComparator);

		if (conversation != null) {
			return conversation;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("associatedWith=");
		msg.append(associatedWith);

		msg.append(", restricted=");
		msg.append(restricted);

		msg.append(", entityId=");
		msg.append(entityId);

		msg.append(", entityClassId=");
		msg.append(entityClassId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConversationException(msg.toString());
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
	@Override
	public Conversation fetchByassociatedWithRestrictedEntityIdEntityClassIdStatus_Last(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByassociatedWithRestrictedEntityIdEntityClassIdStatus(associatedWith,
				restricted, entityId, entityClassId, status);

		if (count == 0) {
			return null;
		}

		List<Conversation> list = findByassociatedWithRestrictedEntityIdEntityClassIdStatus(associatedWith,
				restricted, entityId, entityClassId, status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Conversation[] findByassociatedWithRestrictedEntityIdEntityClassIdStatus_PrevAndNext(
		long spConversationId, long associatedWith, int restricted,
		long entityId, long entityClassId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchConversationException, SystemException {
		Conversation conversation = findByPrimaryKey(spConversationId);

		Session session = null;

		try {
			session = openSession();

			Conversation[] array = new ConversationImpl[3];

			array[0] = getByassociatedWithRestrictedEntityIdEntityClassIdStatus_PrevAndNext(session,
					conversation, associatedWith, restricted, entityId,
					entityClassId, status, orderByComparator, true);

			array[1] = conversation;

			array[2] = getByassociatedWithRestrictedEntityIdEntityClassIdStatus_PrevAndNext(session,
					conversation, associatedWith, restricted, entityId,
					entityClassId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Conversation getByassociatedWithRestrictedEntityIdEntityClassIdStatus_PrevAndNext(
		Session session, Conversation conversation, long associatedWith,
		int restricted, long entityId, long entityClassId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONVERSATION_WHERE);

		query.append(_FINDER_COLUMN_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS_ASSOCIATEDWITH_2);

		query.append(_FINDER_COLUMN_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS_RESTRICTED_2);

		query.append(_FINDER_COLUMN_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS_ENTITYID_2);

		query.append(_FINDER_COLUMN_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS_ENTITYCLASSID_2);

		query.append(_FINDER_COLUMN_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ConversationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(associatedWith);

		qPos.add(restricted);

		qPos.add(entityId);

		qPos.add(entityClassId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(conversation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Conversation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public void removeByassociatedWithRestrictedEntityIdEntityClassIdStatus(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status) throws SystemException {
		for (Conversation conversation : findByassociatedWithRestrictedEntityIdEntityClassIdStatus(
				associatedWith, restricted, entityId, entityClassId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(conversation);
		}
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
	@Override
	public int countByassociatedWithRestrictedEntityIdEntityClassIdStatus(
		long associatedWith, int restricted, long entityId, long entityClassId,
		int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS;

		Object[] finderArgs = new Object[] {
				associatedWith, restricted, entityId, entityClassId, status
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_CONVERSATION_WHERE);

			query.append(_FINDER_COLUMN_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS_ASSOCIATEDWITH_2);

			query.append(_FINDER_COLUMN_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS_RESTRICTED_2);

			query.append(_FINDER_COLUMN_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS_ENTITYID_2);

			query.append(_FINDER_COLUMN_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS_ENTITYCLASSID_2);

			query.append(_FINDER_COLUMN_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(associatedWith);

				qPos.add(restricted);

				qPos.add(entityId);

				qPos.add(entityClassId);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS_ASSOCIATEDWITH_2 =
		"conversation.associatedWith = ? AND ";
	private static final String _FINDER_COLUMN_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS_RESTRICTED_2 =
		"conversation.restricted = ? AND ";
	private static final String _FINDER_COLUMN_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS_ENTITYID_2 =
		"conversation.entityId = ? AND ";
	private static final String _FINDER_COLUMN_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS_ENTITYCLASSID_2 =
		"conversation.entityClassId = ? AND ";
	private static final String _FINDER_COLUMN_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS_STATUS_2 =
		"conversation.status = ?";

	public ConversationPersistenceImpl() {
		setModelClass(Conversation.class);
	}

	/**
	 * Caches the conversation in the entity cache if it is enabled.
	 *
	 * @param conversation the conversation
	 */
	@Override
	public void cacheResult(Conversation conversation) {
		EntityCacheUtil.putResult(ConversationModelImpl.ENTITY_CACHE_ENABLED,
			ConversationImpl.class, conversation.getPrimaryKey(), conversation);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { conversation.getUuid(), conversation.getGroupId() },
			conversation);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID,
			new Object[] {
				conversation.getEntityClassId(), conversation.getEntityId(),
				conversation.getParentConverstationId()
			}, conversation);

		conversation.resetOriginalValues();
	}

	/**
	 * Caches the conversations in the entity cache if it is enabled.
	 *
	 * @param conversations the conversations
	 */
	@Override
	public void cacheResult(List<Conversation> conversations) {
		for (Conversation conversation : conversations) {
			if (EntityCacheUtil.getResult(
						ConversationModelImpl.ENTITY_CACHE_ENABLED,
						ConversationImpl.class, conversation.getPrimaryKey()) == null) {
				cacheResult(conversation);
			}
			else {
				conversation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all conversations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ConversationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ConversationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the conversation.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Conversation conversation) {
		EntityCacheUtil.removeResult(ConversationModelImpl.ENTITY_CACHE_ENABLED,
			ConversationImpl.class, conversation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(conversation);
	}

	@Override
	public void clearCache(List<Conversation> conversations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Conversation conversation : conversations) {
			EntityCacheUtil.removeResult(ConversationModelImpl.ENTITY_CACHE_ENABLED,
				ConversationImpl.class, conversation.getPrimaryKey());

			clearUniqueFindersCache(conversation);
		}
	}

	protected void cacheUniqueFindersCache(Conversation conversation) {
		if (conversation.isNew()) {
			Object[] args = new Object[] {
					conversation.getUuid(), conversation.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				conversation);

			args = new Object[] {
					conversation.getEntityClassId(), conversation.getEntityId(),
					conversation.getParentConverstationId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID,
				args, conversation);
		}
		else {
			ConversationModelImpl conversationModelImpl = (ConversationModelImpl)conversation;

			if ((conversationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						conversation.getUuid(), conversation.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					conversation);
			}

			if ((conversationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						conversation.getEntityClassId(),
						conversation.getEntityId(),
						conversation.getParentConverstationId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID,
					args, conversation);
			}
		}
	}

	protected void clearUniqueFindersCache(Conversation conversation) {
		ConversationModelImpl conversationModelImpl = (ConversationModelImpl)conversation;

		Object[] args = new Object[] {
				conversation.getUuid(), conversation.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((conversationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					conversationModelImpl.getOriginalUuid(),
					conversationModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				conversation.getEntityClassId(), conversation.getEntityId(),
				conversation.getParentConverstationId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID,
			args);

		if ((conversationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID.getColumnBitmask()) != 0) {
			args = new Object[] {
					conversationModelImpl.getOriginalEntityClassId(),
					conversationModelImpl.getOriginalEntityId(),
					conversationModelImpl.getOriginalParentConverstationId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTCONVERSTATIONID,
				args);
		}
	}

	/**
	 * Creates a new conversation with the primary key. Does not add the conversation to the database.
	 *
	 * @param spConversationId the primary key for the new conversation
	 * @return the new conversation
	 */
	@Override
	public Conversation create(long spConversationId) {
		Conversation conversation = new ConversationImpl();

		conversation.setNew(true);
		conversation.setPrimaryKey(spConversationId);

		String uuid = PortalUUIDUtil.generate();

		conversation.setUuid(uuid);

		return conversation;
	}

	/**
	 * Removes the conversation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spConversationId the primary key of the conversation
	 * @return the conversation that was removed
	 * @throws com.sambaash.platform.srv.NoSuchConversationException if a conversation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Conversation remove(long spConversationId)
		throws NoSuchConversationException, SystemException {
		return remove((Serializable)spConversationId);
	}

	/**
	 * Removes the conversation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the conversation
	 * @return the conversation that was removed
	 * @throws com.sambaash.platform.srv.NoSuchConversationException if a conversation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Conversation remove(Serializable primaryKey)
		throws NoSuchConversationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Conversation conversation = (Conversation)session.get(ConversationImpl.class,
					primaryKey);

			if (conversation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConversationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(conversation);
		}
		catch (NoSuchConversationException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Conversation removeImpl(Conversation conversation)
		throws SystemException {
		conversation = toUnwrappedModel(conversation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(conversation)) {
				conversation = (Conversation)session.get(ConversationImpl.class,
						conversation.getPrimaryKeyObj());
			}

			if (conversation != null) {
				session.delete(conversation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (conversation != null) {
			clearCache(conversation);
		}

		return conversation;
	}

	@Override
	public Conversation updateImpl(
		com.sambaash.platform.srv.model.Conversation conversation)
		throws SystemException {
		conversation = toUnwrappedModel(conversation);

		boolean isNew = conversation.isNew();

		ConversationModelImpl conversationModelImpl = (ConversationModelImpl)conversation;

		if (Validator.isNull(conversation.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			conversation.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (conversation.isNew()) {
				session.save(conversation);

				conversation.setNew(false);
			}
			else {
				session.merge(conversation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ConversationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((conversationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						conversationModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { conversationModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((conversationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						conversationModelImpl.getOriginalUuid(),
						conversationModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						conversationModelImpl.getUuid(),
						conversationModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((conversationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITYCLASSIDENTITYIDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						conversationModelImpl.getOriginalEntityClassId(),
						conversationModelImpl.getOriginalEntityId(),
						conversationModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTITYCLASSIDENTITYIDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITYCLASSIDENTITYIDSTATUS,
					args);

				args = new Object[] {
						conversationModelImpl.getEntityClassId(),
						conversationModelImpl.getEntityId(),
						conversationModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTITYCLASSIDENTITYIDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITYCLASSIDENTITYIDSTATUS,
					args);
			}

			if ((conversationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						conversationModelImpl.getOriginalAssociatedWith(),
						conversationModelImpl.getOriginalRestricted(),
						conversationModelImpl.getOriginalEntityId(),
						conversationModelImpl.getOriginalEntityClassId(),
						conversationModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS,
					args);

				args = new Object[] {
						conversationModelImpl.getAssociatedWith(),
						conversationModelImpl.getRestricted(),
						conversationModelImpl.getEntityId(),
						conversationModelImpl.getEntityClassId(),
						conversationModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSOCIATEDWITHRESTRICTEDENTITYIDENTITYCLASSIDSTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(ConversationModelImpl.ENTITY_CACHE_ENABLED,
			ConversationImpl.class, conversation.getPrimaryKey(), conversation);

		clearUniqueFindersCache(conversation);
		cacheUniqueFindersCache(conversation);

		return conversation;
	}

	protected Conversation toUnwrappedModel(Conversation conversation) {
		if (conversation instanceof ConversationImpl) {
			return conversation;
		}

		ConversationImpl conversationImpl = new ConversationImpl();

		conversationImpl.setNew(conversation.isNew());
		conversationImpl.setPrimaryKey(conversation.getPrimaryKey());

		conversationImpl.setUuid(conversation.getUuid());
		conversationImpl.setSpConversationId(conversation.getSpConversationId());
		conversationImpl.setGroupId(conversation.getGroupId());
		conversationImpl.setCompanyId(conversation.getCompanyId());
		conversationImpl.setUserId(conversation.getUserId());
		conversationImpl.setUserName(conversation.getUserName());
		conversationImpl.setCreateDate(conversation.getCreateDate());
		conversationImpl.setModifiedDate(conversation.getModifiedDate());
		conversationImpl.setEntityClassId(conversation.getEntityClassId());
		conversationImpl.setEntityClassName(conversation.getEntityClassName());
		conversationImpl.setEntityId(conversation.getEntityId());
		conversationImpl.setSentByUserId(conversation.getSentByUserId());
		conversationImpl.setMessage(conversation.getMessage());
		conversationImpl.setFileEntryId(conversation.getFileEntryId());
		conversationImpl.setAssociatedWith(conversation.getAssociatedWith());
		conversationImpl.setRestricted(conversation.getRestricted());
		conversationImpl.setStatus(conversation.getStatus());
		conversationImpl.setParentConverstationId(conversation.getParentConverstationId());
		conversationImpl.setCurrentPlId(conversation.getCurrentPlId());

		return conversationImpl;
	}

	/**
	 * Returns the conversation with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the conversation
	 * @return the conversation
	 * @throws com.sambaash.platform.srv.NoSuchConversationException if a conversation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Conversation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchConversationException, SystemException {
		Conversation conversation = fetchByPrimaryKey(primaryKey);

		if (conversation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConversationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return conversation;
	}

	/**
	 * Returns the conversation with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchConversationException} if it could not be found.
	 *
	 * @param spConversationId the primary key of the conversation
	 * @return the conversation
	 * @throws com.sambaash.platform.srv.NoSuchConversationException if a conversation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Conversation findByPrimaryKey(long spConversationId)
		throws NoSuchConversationException, SystemException {
		return findByPrimaryKey((Serializable)spConversationId);
	}

	/**
	 * Returns the conversation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the conversation
	 * @return the conversation, or <code>null</code> if a conversation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Conversation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Conversation conversation = (Conversation)EntityCacheUtil.getResult(ConversationModelImpl.ENTITY_CACHE_ENABLED,
				ConversationImpl.class, primaryKey);

		if (conversation == _nullConversation) {
			return null;
		}

		if (conversation == null) {
			Session session = null;

			try {
				session = openSession();

				conversation = (Conversation)session.get(ConversationImpl.class,
						primaryKey);

				if (conversation != null) {
					cacheResult(conversation);
				}
				else {
					EntityCacheUtil.putResult(ConversationModelImpl.ENTITY_CACHE_ENABLED,
						ConversationImpl.class, primaryKey, _nullConversation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ConversationModelImpl.ENTITY_CACHE_ENABLED,
					ConversationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return conversation;
	}

	/**
	 * Returns the conversation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spConversationId the primary key of the conversation
	 * @return the conversation, or <code>null</code> if a conversation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Conversation fetchByPrimaryKey(long spConversationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spConversationId);
	}

	/**
	 * Returns all the conversations.
	 *
	 * @return the conversations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Conversation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Conversation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Conversation> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Conversation> list = (List<Conversation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONVERSATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONVERSATION;

				if (pagination) {
					sql = sql.concat(ConversationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Conversation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Conversation>(list);
				}
				else {
					list = (List<Conversation>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the conversations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Conversation conversation : findAll()) {
			remove(conversation);
		}
	}

	/**
	 * Returns the number of conversations.
	 *
	 * @return the number of conversations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONVERSATION);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the conversation persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.Conversation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Conversation>> listenersList = new ArrayList<ModelListener<Conversation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Conversation>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ConversationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONVERSATION = "SELECT conversation FROM Conversation conversation";
	private static final String _SQL_SELECT_CONVERSATION_WHERE = "SELECT conversation FROM Conversation conversation WHERE ";
	private static final String _SQL_COUNT_CONVERSATION = "SELECT COUNT(conversation) FROM Conversation conversation";
	private static final String _SQL_COUNT_CONVERSATION_WHERE = "SELECT COUNT(conversation) FROM Conversation conversation WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "conversation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Conversation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Conversation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ConversationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Conversation _nullConversation = new ConversationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Conversation> toCacheModel() {
				return _nullConversationCacheModel;
			}
		};

	private static CacheModel<Conversation> _nullConversationCacheModel = new CacheModel<Conversation>() {
			@Override
			public Conversation toEntityModel() {
				return _nullConversation;
			}
		};
}