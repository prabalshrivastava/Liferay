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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.NoSuchConversationUserException;
import com.sambaash.platform.srv.model.ConversationUser;
import com.sambaash.platform.srv.model.impl.ConversationUserImpl;
import com.sambaash.platform.srv.model.impl.ConversationUserModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the conversation user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author aishwarya
 * @see ConversationUserPersistence
 * @see ConversationUserUtil
 * @generated
 */
public class ConversationUserPersistenceImpl extends BasePersistenceImpl<ConversationUser>
	implements ConversationUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ConversationUserUtil} to access the conversation user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ConversationUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ConversationUserModelImpl.ENTITY_CACHE_ENABLED,
			ConversationUserModelImpl.FINDER_CACHE_ENABLED,
			ConversationUserImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ConversationUserModelImpl.ENTITY_CACHE_ENABLED,
			ConversationUserModelImpl.FINDER_CACHE_ENABLED,
			ConversationUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ConversationUserModelImpl.ENTITY_CACHE_ENABLED,
			ConversationUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID =
		new FinderPath(ConversationUserModelImpl.ENTITY_CACHE_ENABLED,
			ConversationUserModelImpl.FINDER_CACHE_ENABLED,
			ConversationUserImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBysentToUserIdStatusEntityClassIdEntityId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID =
		new FinderPath(ConversationUserModelImpl.ENTITY_CACHE_ENABLED,
			ConversationUserModelImpl.FINDER_CACHE_ENABLED,
			ConversationUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBysentToUserIdStatusEntityClassIdEntityId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			ConversationUserModelImpl.SENTTOUSERID_COLUMN_BITMASK |
			ConversationUserModelImpl.STATUS_COLUMN_BITMASK |
			ConversationUserModelImpl.ENTITYCLASSID_COLUMN_BITMASK |
			ConversationUserModelImpl.ENTITYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID =
		new FinderPath(ConversationUserModelImpl.ENTITY_CACHE_ENABLED,
			ConversationUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysentToUserIdStatusEntityClassIdEntityId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID =
		new FinderPath(ConversationUserModelImpl.ENTITY_CACHE_ENABLED,
			ConversationUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countBysentToUserIdStatusEntityClassIdEntityId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			});

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
	@Override
	public List<ConversationUser> findBysentToUserIdStatusEntityClassIdEntityId(
		long sentToUserId, long status, long entityClassId, long entityId)
		throws SystemException {
		return findBysentToUserIdStatusEntityClassIdEntityId(sentToUserId,
			status, entityClassId, entityId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ConversationUser> findBysentToUserIdStatusEntityClassIdEntityId(
		long sentToUserId, long status, long entityClassId, long entityId,
		int start, int end) throws SystemException {
		return findBysentToUserIdStatusEntityClassIdEntityId(sentToUserId,
			status, entityClassId, entityId, start, end, null);
	}

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
	@Override
	public List<ConversationUser> findBysentToUserIdStatusEntityClassIdEntityId(
		long sentToUserId, long status, long entityClassId, long entityId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID;
			finderArgs = new Object[] {
					sentToUserId, status, entityClassId, entityId
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID;
			finderArgs = new Object[] {
					sentToUserId, status, entityClassId, entityId,
					
					start, end, orderByComparator
				};
		}

		List<ConversationUser> list = (List<ConversationUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ConversationUser conversationUser : list) {
				if ((sentToUserId != conversationUser.getSentToUserId()) ||
						(status != conversationUser.getStatus()) ||
						(entityClassId != conversationUser.getEntityClassId()) ||
						(entityId != conversationUser.getEntityId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_CONVERSATIONUSER_WHERE);

			query.append(_FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_SENTTOUSERID_2);

			query.append(_FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_STATUS_2);

			query.append(_FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_ENTITYCLASSID_2);

			query.append(_FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_ENTITYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ConversationUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sentToUserId);

				qPos.add(status);

				qPos.add(entityClassId);

				qPos.add(entityId);

				if (!pagination) {
					list = (List<ConversationUser>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConversationUser>(list);
				}
				else {
					list = (List<ConversationUser>)QueryUtil.list(q,
							getDialect(), start, end);
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
	@Override
	public ConversationUser findBysentToUserIdStatusEntityClassIdEntityId_First(
		long sentToUserId, long status, long entityClassId, long entityId,
		OrderByComparator orderByComparator)
		throws NoSuchConversationUserException, SystemException {
		ConversationUser conversationUser = fetchBysentToUserIdStatusEntityClassIdEntityId_First(sentToUserId,
				status, entityClassId, entityId, orderByComparator);

		if (conversationUser != null) {
			return conversationUser;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sentToUserId=");
		msg.append(sentToUserId);

		msg.append(", status=");
		msg.append(status);

		msg.append(", entityClassId=");
		msg.append(entityClassId);

		msg.append(", entityId=");
		msg.append(entityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConversationUserException(msg.toString());
	}

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
	@Override
	public ConversationUser fetchBysentToUserIdStatusEntityClassIdEntityId_First(
		long sentToUserId, long status, long entityClassId, long entityId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ConversationUser> list = findBysentToUserIdStatusEntityClassIdEntityId(sentToUserId,
				status, entityClassId, entityId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public ConversationUser findBysentToUserIdStatusEntityClassIdEntityId_Last(
		long sentToUserId, long status, long entityClassId, long entityId,
		OrderByComparator orderByComparator)
		throws NoSuchConversationUserException, SystemException {
		ConversationUser conversationUser = fetchBysentToUserIdStatusEntityClassIdEntityId_Last(sentToUserId,
				status, entityClassId, entityId, orderByComparator);

		if (conversationUser != null) {
			return conversationUser;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sentToUserId=");
		msg.append(sentToUserId);

		msg.append(", status=");
		msg.append(status);

		msg.append(", entityClassId=");
		msg.append(entityClassId);

		msg.append(", entityId=");
		msg.append(entityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConversationUserException(msg.toString());
	}

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
	@Override
	public ConversationUser fetchBysentToUserIdStatusEntityClassIdEntityId_Last(
		long sentToUserId, long status, long entityClassId, long entityId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBysentToUserIdStatusEntityClassIdEntityId(sentToUserId,
				status, entityClassId, entityId);

		if (count == 0) {
			return null;
		}

		List<ConversationUser> list = findBysentToUserIdStatusEntityClassIdEntityId(sentToUserId,
				status, entityClassId, entityId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public ConversationUser[] findBysentToUserIdStatusEntityClassIdEntityId_PrevAndNext(
		long spConversationUserId, long sentToUserId, long status,
		long entityClassId, long entityId, OrderByComparator orderByComparator)
		throws NoSuchConversationUserException, SystemException {
		ConversationUser conversationUser = findByPrimaryKey(spConversationUserId);

		Session session = null;

		try {
			session = openSession();

			ConversationUser[] array = new ConversationUserImpl[3];

			array[0] = getBysentToUserIdStatusEntityClassIdEntityId_PrevAndNext(session,
					conversationUser, sentToUserId, status, entityClassId,
					entityId, orderByComparator, true);

			array[1] = conversationUser;

			array[2] = getBysentToUserIdStatusEntityClassIdEntityId_PrevAndNext(session,
					conversationUser, sentToUserId, status, entityClassId,
					entityId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ConversationUser getBysentToUserIdStatusEntityClassIdEntityId_PrevAndNext(
		Session session, ConversationUser conversationUser, long sentToUserId,
		long status, long entityClassId, long entityId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONVERSATIONUSER_WHERE);

		query.append(_FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_SENTTOUSERID_2);

		query.append(_FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_STATUS_2);

		query.append(_FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_ENTITYCLASSID_2);

		query.append(_FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_ENTITYID_2);

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
			query.append(ConversationUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(sentToUserId);

		qPos.add(status);

		qPos.add(entityClassId);

		qPos.add(entityId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(conversationUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ConversationUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

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
	@Override
	public List<ConversationUser> findBysentToUserIdStatusEntityClassIdEntityId(
		long[] sentToUserIds, long status, long entityClassId, long entityId)
		throws SystemException {
		return findBysentToUserIdStatusEntityClassIdEntityId(sentToUserIds,
			status, entityClassId, entityId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ConversationUser> findBysentToUserIdStatusEntityClassIdEntityId(
		long[] sentToUserIds, long status, long entityClassId, long entityId,
		int start, int end) throws SystemException {
		return findBysentToUserIdStatusEntityClassIdEntityId(sentToUserIds,
			status, entityClassId, entityId, start, end, null);
	}

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
	@Override
	public List<ConversationUser> findBysentToUserIdStatusEntityClassIdEntityId(
		long[] sentToUserIds, long status, long entityClassId, long entityId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if ((sentToUserIds != null) && (sentToUserIds.length == 1)) {
			return findBysentToUserIdStatusEntityClassIdEntityId(sentToUserIds[0],
				status, entityClassId, entityId, start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					StringUtil.merge(sentToUserIds), status, entityClassId,
					entityId
				};
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(sentToUserIds), status, entityClassId,
					entityId,
					
					start, end, orderByComparator
				};
		}

		List<ConversationUser> list = (List<ConversationUser>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ConversationUser conversationUser : list) {
				if (!ArrayUtil.contains(sentToUserIds,
							conversationUser.getSentToUserId()) ||
						(status != conversationUser.getStatus()) ||
						(entityClassId != conversationUser.getEntityClassId()) ||
						(entityId != conversationUser.getEntityId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_CONVERSATIONUSER_WHERE);

			boolean conjunctionable = false;

			if ((sentToUserIds == null) || (sentToUserIds.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < sentToUserIds.length; i++) {
					query.append(_FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_SENTTOUSERID_5);

					if ((i + 1) < sentToUserIds.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_STATUS_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_ENTITYCLASSID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_ENTITYID_5);

			conjunctionable = true;

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ConversationUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (sentToUserIds != null) {
					qPos.add(sentToUserIds);
				}

				qPos.add(status);

				qPos.add(entityClassId);

				qPos.add(entityId);

				if (!pagination) {
					list = (List<ConversationUser>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConversationUser>(list);
				}
				else {
					list = (List<ConversationUser>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the conversation users where sentToUserId = &#63; and status = &#63; and entityClassId = &#63; and entityId = &#63; from the database.
	 *
	 * @param sentToUserId the sent to user ID
	 * @param status the status
	 * @param entityClassId the entity class ID
	 * @param entityId the entity ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBysentToUserIdStatusEntityClassIdEntityId(
		long sentToUserId, long status, long entityClassId, long entityId)
		throws SystemException {
		for (ConversationUser conversationUser : findBysentToUserIdStatusEntityClassIdEntityId(
				sentToUserId, status, entityClassId, entityId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(conversationUser);
		}
	}

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
	@Override
	public int countBysentToUserIdStatusEntityClassIdEntityId(
		long sentToUserId, long status, long entityClassId, long entityId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID;

		Object[] finderArgs = new Object[] {
				sentToUserId, status, entityClassId, entityId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_CONVERSATIONUSER_WHERE);

			query.append(_FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_SENTTOUSERID_2);

			query.append(_FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_STATUS_2);

			query.append(_FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_ENTITYCLASSID_2);

			query.append(_FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_ENTITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sentToUserId);

				qPos.add(status);

				qPos.add(entityClassId);

				qPos.add(entityId);

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
	@Override
	public int countBysentToUserIdStatusEntityClassIdEntityId(
		long[] sentToUserIds, long status, long entityClassId, long entityId)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				StringUtil.merge(sentToUserIds), status, entityClassId, entityId
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_CONVERSATIONUSER_WHERE);

			boolean conjunctionable = false;

			if ((sentToUserIds == null) || (sentToUserIds.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < sentToUserIds.length; i++) {
					query.append(_FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_SENTTOUSERID_5);

					if ((i + 1) < sentToUserIds.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_STATUS_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_ENTITYCLASSID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_ENTITYID_5);

			conjunctionable = true;

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (sentToUserIds != null) {
					qPos.add(sentToUserIds);
				}

				qPos.add(status);

				qPos.add(entityClassId);

				qPos.add(entityId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_SENTTOUSERID_2 =
		"conversationUser.sentToUserId = ? AND ";
	private static final String _FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_SENTTOUSERID_5 =
		"(" +
		removeConjunction(_FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_SENTTOUSERID_2) +
		")";
	private static final String _FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_STATUS_2 =
		"conversationUser.status = ? AND ";
	private static final String _FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_STATUS_5 =
		"(" +
		removeConjunction(_FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_STATUS_2) +
		")";
	private static final String _FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_ENTITYCLASSID_2 =
		"conversationUser.entityClassId = ? AND ";
	private static final String _FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_ENTITYCLASSID_5 =
		"(" +
		removeConjunction(_FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_ENTITYCLASSID_2) +
		")";
	private static final String _FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_ENTITYID_2 =
		"conversationUser.entityId = ?";
	private static final String _FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_ENTITYID_5 =
		"(" +
		removeConjunction(_FINDER_COLUMN_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID_ENTITYID_2) +
		")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SPCONVERSATIONID =
		new FinderPath(ConversationUserModelImpl.ENTITY_CACHE_ENABLED,
			ConversationUserModelImpl.FINDER_CACHE_ENABLED,
			ConversationUserImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByspConversationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPCONVERSATIONID =
		new FinderPath(ConversationUserModelImpl.ENTITY_CACHE_ENABLED,
			ConversationUserModelImpl.FINDER_CACHE_ENABLED,
			ConversationUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByspConversationId", new String[] { Long.class.getName() },
			ConversationUserModelImpl.SPCONVERSATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SPCONVERSATIONID = new FinderPath(ConversationUserModelImpl.ENTITY_CACHE_ENABLED,
			ConversationUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByspConversationId", new String[] { Long.class.getName() });

	/**
	 * Returns all the conversation users where spConversationId = &#63;.
	 *
	 * @param spConversationId the sp conversation ID
	 * @return the matching conversation users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConversationUser> findByspConversationId(long spConversationId)
		throws SystemException {
		return findByspConversationId(spConversationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ConversationUser> findByspConversationId(
		long spConversationId, int start, int end) throws SystemException {
		return findByspConversationId(spConversationId, start, end, null);
	}

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
	@Override
	public List<ConversationUser> findByspConversationId(
		long spConversationId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPCONVERSATIONID;
			finderArgs = new Object[] { spConversationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SPCONVERSATIONID;
			finderArgs = new Object[] {
					spConversationId,
					
					start, end, orderByComparator
				};
		}

		List<ConversationUser> list = (List<ConversationUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ConversationUser conversationUser : list) {
				if ((spConversationId != conversationUser.getSpConversationId())) {
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

			query.append(_SQL_SELECT_CONVERSATIONUSER_WHERE);

			query.append(_FINDER_COLUMN_SPCONVERSATIONID_SPCONVERSATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ConversationUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spConversationId);

				if (!pagination) {
					list = (List<ConversationUser>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConversationUser>(list);
				}
				else {
					list = (List<ConversationUser>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first conversation user in the ordered set where spConversationId = &#63;.
	 *
	 * @param spConversationId the sp conversation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching conversation user
	 * @throws com.sambaash.platform.srv.NoSuchConversationUserException if a matching conversation user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConversationUser findByspConversationId_First(
		long spConversationId, OrderByComparator orderByComparator)
		throws NoSuchConversationUserException, SystemException {
		ConversationUser conversationUser = fetchByspConversationId_First(spConversationId,
				orderByComparator);

		if (conversationUser != null) {
			return conversationUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spConversationId=");
		msg.append(spConversationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConversationUserException(msg.toString());
	}

	/**
	 * Returns the first conversation user in the ordered set where spConversationId = &#63;.
	 *
	 * @param spConversationId the sp conversation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching conversation user, or <code>null</code> if a matching conversation user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConversationUser fetchByspConversationId_First(
		long spConversationId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ConversationUser> list = findByspConversationId(spConversationId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last conversation user in the ordered set where spConversationId = &#63;.
	 *
	 * @param spConversationId the sp conversation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching conversation user
	 * @throws com.sambaash.platform.srv.NoSuchConversationUserException if a matching conversation user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConversationUser findByspConversationId_Last(long spConversationId,
		OrderByComparator orderByComparator)
		throws NoSuchConversationUserException, SystemException {
		ConversationUser conversationUser = fetchByspConversationId_Last(spConversationId,
				orderByComparator);

		if (conversationUser != null) {
			return conversationUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spConversationId=");
		msg.append(spConversationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConversationUserException(msg.toString());
	}

	/**
	 * Returns the last conversation user in the ordered set where spConversationId = &#63;.
	 *
	 * @param spConversationId the sp conversation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching conversation user, or <code>null</code> if a matching conversation user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConversationUser fetchByspConversationId_Last(
		long spConversationId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByspConversationId(spConversationId);

		if (count == 0) {
			return null;
		}

		List<ConversationUser> list = findByspConversationId(spConversationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public ConversationUser[] findByspConversationId_PrevAndNext(
		long spConversationUserId, long spConversationId,
		OrderByComparator orderByComparator)
		throws NoSuchConversationUserException, SystemException {
		ConversationUser conversationUser = findByPrimaryKey(spConversationUserId);

		Session session = null;

		try {
			session = openSession();

			ConversationUser[] array = new ConversationUserImpl[3];

			array[0] = getByspConversationId_PrevAndNext(session,
					conversationUser, spConversationId, orderByComparator, true);

			array[1] = conversationUser;

			array[2] = getByspConversationId_PrevAndNext(session,
					conversationUser, spConversationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ConversationUser getByspConversationId_PrevAndNext(
		Session session, ConversationUser conversationUser,
		long spConversationId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONVERSATIONUSER_WHERE);

		query.append(_FINDER_COLUMN_SPCONVERSATIONID_SPCONVERSATIONID_2);

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
			query.append(ConversationUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spConversationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(conversationUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ConversationUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the conversation users where spConversationId = &#63; from the database.
	 *
	 * @param spConversationId the sp conversation ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByspConversationId(long spConversationId)
		throws SystemException {
		for (ConversationUser conversationUser : findByspConversationId(
				spConversationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(conversationUser);
		}
	}

	/**
	 * Returns the number of conversation users where spConversationId = &#63;.
	 *
	 * @param spConversationId the sp conversation ID
	 * @return the number of matching conversation users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByspConversationId(long spConversationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SPCONVERSATIONID;

		Object[] finderArgs = new Object[] { spConversationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONVERSATIONUSER_WHERE);

			query.append(_FINDER_COLUMN_SPCONVERSATIONID_SPCONVERSATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spConversationId);

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

	private static final String _FINDER_COLUMN_SPCONVERSATIONID_SPCONVERSATIONID_2 =
		"conversationUser.spConversationId = ?";

	public ConversationUserPersistenceImpl() {
		setModelClass(ConversationUser.class);
	}

	/**
	 * Caches the conversation user in the entity cache if it is enabled.
	 *
	 * @param conversationUser the conversation user
	 */
	@Override
	public void cacheResult(ConversationUser conversationUser) {
		EntityCacheUtil.putResult(ConversationUserModelImpl.ENTITY_CACHE_ENABLED,
			ConversationUserImpl.class, conversationUser.getPrimaryKey(),
			conversationUser);

		conversationUser.resetOriginalValues();
	}

	/**
	 * Caches the conversation users in the entity cache if it is enabled.
	 *
	 * @param conversationUsers the conversation users
	 */
	@Override
	public void cacheResult(List<ConversationUser> conversationUsers) {
		for (ConversationUser conversationUser : conversationUsers) {
			if (EntityCacheUtil.getResult(
						ConversationUserModelImpl.ENTITY_CACHE_ENABLED,
						ConversationUserImpl.class,
						conversationUser.getPrimaryKey()) == null) {
				cacheResult(conversationUser);
			}
			else {
				conversationUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all conversation users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ConversationUserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ConversationUserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the conversation user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ConversationUser conversationUser) {
		EntityCacheUtil.removeResult(ConversationUserModelImpl.ENTITY_CACHE_ENABLED,
			ConversationUserImpl.class, conversationUser.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ConversationUser> conversationUsers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ConversationUser conversationUser : conversationUsers) {
			EntityCacheUtil.removeResult(ConversationUserModelImpl.ENTITY_CACHE_ENABLED,
				ConversationUserImpl.class, conversationUser.getPrimaryKey());
		}
	}

	/**
	 * Creates a new conversation user with the primary key. Does not add the conversation user to the database.
	 *
	 * @param spConversationUserId the primary key for the new conversation user
	 * @return the new conversation user
	 */
	@Override
	public ConversationUser create(long spConversationUserId) {
		ConversationUser conversationUser = new ConversationUserImpl();

		conversationUser.setNew(true);
		conversationUser.setPrimaryKey(spConversationUserId);

		return conversationUser;
	}

	/**
	 * Removes the conversation user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spConversationUserId the primary key of the conversation user
	 * @return the conversation user that was removed
	 * @throws com.sambaash.platform.srv.NoSuchConversationUserException if a conversation user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConversationUser remove(long spConversationUserId)
		throws NoSuchConversationUserException, SystemException {
		return remove((Serializable)spConversationUserId);
	}

	/**
	 * Removes the conversation user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the conversation user
	 * @return the conversation user that was removed
	 * @throws com.sambaash.platform.srv.NoSuchConversationUserException if a conversation user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConversationUser remove(Serializable primaryKey)
		throws NoSuchConversationUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ConversationUser conversationUser = (ConversationUser)session.get(ConversationUserImpl.class,
					primaryKey);

			if (conversationUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConversationUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(conversationUser);
		}
		catch (NoSuchConversationUserException nsee) {
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
	protected ConversationUser removeImpl(ConversationUser conversationUser)
		throws SystemException {
		conversationUser = toUnwrappedModel(conversationUser);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(conversationUser)) {
				conversationUser = (ConversationUser)session.get(ConversationUserImpl.class,
						conversationUser.getPrimaryKeyObj());
			}

			if (conversationUser != null) {
				session.delete(conversationUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (conversationUser != null) {
			clearCache(conversationUser);
		}

		return conversationUser;
	}

	@Override
	public ConversationUser updateImpl(
		com.sambaash.platform.srv.model.ConversationUser conversationUser)
		throws SystemException {
		conversationUser = toUnwrappedModel(conversationUser);

		boolean isNew = conversationUser.isNew();

		ConversationUserModelImpl conversationUserModelImpl = (ConversationUserModelImpl)conversationUser;

		Session session = null;

		try {
			session = openSession();

			if (conversationUser.isNew()) {
				session.save(conversationUser);

				conversationUser.setNew(false);
			}
			else {
				session.merge(conversationUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ConversationUserModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((conversationUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						conversationUserModelImpl.getOriginalSentToUserId(),
						conversationUserModelImpl.getOriginalStatus(),
						conversationUserModelImpl.getOriginalEntityClassId(),
						conversationUserModelImpl.getOriginalEntityId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID,
					args);

				args = new Object[] {
						conversationUserModelImpl.getSentToUserId(),
						conversationUserModelImpl.getStatus(),
						conversationUserModelImpl.getEntityClassId(),
						conversationUserModelImpl.getEntityId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SENTTOUSERIDSTATUSENTITYCLASSIDENTITYID,
					args);
			}

			if ((conversationUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPCONVERSATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						conversationUserModelImpl.getOriginalSpConversationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPCONVERSATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPCONVERSATIONID,
					args);

				args = new Object[] {
						conversationUserModelImpl.getSpConversationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPCONVERSATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPCONVERSATIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(ConversationUserModelImpl.ENTITY_CACHE_ENABLED,
			ConversationUserImpl.class, conversationUser.getPrimaryKey(),
			conversationUser);

		return conversationUser;
	}

	protected ConversationUser toUnwrappedModel(
		ConversationUser conversationUser) {
		if (conversationUser instanceof ConversationUserImpl) {
			return conversationUser;
		}

		ConversationUserImpl conversationUserImpl = new ConversationUserImpl();

		conversationUserImpl.setNew(conversationUser.isNew());
		conversationUserImpl.setPrimaryKey(conversationUser.getPrimaryKey());

		conversationUserImpl.setSpConversationUserId(conversationUser.getSpConversationUserId());
		conversationUserImpl.setSpConversationId(conversationUser.getSpConversationId());
		conversationUserImpl.setSentToUserId(conversationUser.getSentToUserId());
		conversationUserImpl.setStatus(conversationUser.getStatus());
		conversationUserImpl.setEntityClassId(conversationUser.getEntityClassId());
		conversationUserImpl.setEntityId(conversationUser.getEntityId());

		return conversationUserImpl;
	}

	/**
	 * Returns the conversation user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the conversation user
	 * @return the conversation user
	 * @throws com.sambaash.platform.srv.NoSuchConversationUserException if a conversation user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConversationUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchConversationUserException, SystemException {
		ConversationUser conversationUser = fetchByPrimaryKey(primaryKey);

		if (conversationUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConversationUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return conversationUser;
	}

	/**
	 * Returns the conversation user with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchConversationUserException} if it could not be found.
	 *
	 * @param spConversationUserId the primary key of the conversation user
	 * @return the conversation user
	 * @throws com.sambaash.platform.srv.NoSuchConversationUserException if a conversation user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConversationUser findByPrimaryKey(long spConversationUserId)
		throws NoSuchConversationUserException, SystemException {
		return findByPrimaryKey((Serializable)spConversationUserId);
	}

	/**
	 * Returns the conversation user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the conversation user
	 * @return the conversation user, or <code>null</code> if a conversation user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConversationUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ConversationUser conversationUser = (ConversationUser)EntityCacheUtil.getResult(ConversationUserModelImpl.ENTITY_CACHE_ENABLED,
				ConversationUserImpl.class, primaryKey);

		if (conversationUser == _nullConversationUser) {
			return null;
		}

		if (conversationUser == null) {
			Session session = null;

			try {
				session = openSession();

				conversationUser = (ConversationUser)session.get(ConversationUserImpl.class,
						primaryKey);

				if (conversationUser != null) {
					cacheResult(conversationUser);
				}
				else {
					EntityCacheUtil.putResult(ConversationUserModelImpl.ENTITY_CACHE_ENABLED,
						ConversationUserImpl.class, primaryKey,
						_nullConversationUser);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ConversationUserModelImpl.ENTITY_CACHE_ENABLED,
					ConversationUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return conversationUser;
	}

	/**
	 * Returns the conversation user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spConversationUserId the primary key of the conversation user
	 * @return the conversation user, or <code>null</code> if a conversation user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConversationUser fetchByPrimaryKey(long spConversationUserId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spConversationUserId);
	}

	/**
	 * Returns all the conversation users.
	 *
	 * @return the conversation users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConversationUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ConversationUser> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<ConversationUser> findAll(int start, int end,
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

		List<ConversationUser> list = (List<ConversationUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONVERSATIONUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONVERSATIONUSER;

				if (pagination) {
					sql = sql.concat(ConversationUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ConversationUser>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConversationUser>(list);
				}
				else {
					list = (List<ConversationUser>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the conversation users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ConversationUser conversationUser : findAll()) {
			remove(conversationUser);
		}
	}

	/**
	 * Returns the number of conversation users.
	 *
	 * @return the number of conversation users
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

				Query q = session.createQuery(_SQL_COUNT_CONVERSATIONUSER);

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

	/**
	 * Initializes the conversation user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.ConversationUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ConversationUser>> listenersList = new ArrayList<ModelListener<ConversationUser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ConversationUser>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ConversationUserImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONVERSATIONUSER = "SELECT conversationUser FROM ConversationUser conversationUser";
	private static final String _SQL_SELECT_CONVERSATIONUSER_WHERE = "SELECT conversationUser FROM ConversationUser conversationUser WHERE ";
	private static final String _SQL_COUNT_CONVERSATIONUSER = "SELECT COUNT(conversationUser) FROM ConversationUser conversationUser";
	private static final String _SQL_COUNT_CONVERSATIONUSER_WHERE = "SELECT COUNT(conversationUser) FROM ConversationUser conversationUser WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "conversationUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ConversationUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ConversationUser exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ConversationUserPersistenceImpl.class);
	private static ConversationUser _nullConversationUser = new ConversationUserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ConversationUser> toCacheModel() {
				return _nullConversationUserCacheModel;
			}
		};

	private static CacheModel<ConversationUser> _nullConversationUserCacheModel = new CacheModel<ConversationUser>() {
			@Override
			public ConversationUser toEntityModel() {
				return _nullConversationUser;
			}
		};
}