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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.NoSuchPersonaAttendeeException;
import com.sambaash.platform.srv.model.PersonaAttendee;
import com.sambaash.platform.srv.model.impl.PersonaAttendeeImpl;
import com.sambaash.platform.srv.model.impl.PersonaAttendeeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the persona attendee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see PersonaAttendeePersistence
 * @see PersonaAttendeeUtil
 * @generated
 */
public class PersonaAttendeePersistenceImpl extends BasePersistenceImpl<PersonaAttendee>
	implements PersonaAttendeePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PersonaAttendeeUtil} to access the persona attendee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PersonaAttendeeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PersonaAttendeeModelImpl.ENTITY_CACHE_ENABLED,
			PersonaAttendeeModelImpl.FINDER_CACHE_ENABLED,
			PersonaAttendeeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PersonaAttendeeModelImpl.ENTITY_CACHE_ENABLED,
			PersonaAttendeeModelImpl.FINDER_CACHE_ENABLED,
			PersonaAttendeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PersonaAttendeeModelImpl.ENTITY_CACHE_ENABLED,
			PersonaAttendeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(PersonaAttendeeModelImpl.ENTITY_CACHE_ENABLED,
			PersonaAttendeeModelImpl.FINDER_CACHE_ENABLED,
			PersonaAttendeeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(PersonaAttendeeModelImpl.ENTITY_CACHE_ENABLED,
			PersonaAttendeeModelImpl.FINDER_CACHE_ENABLED,
			PersonaAttendeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			PersonaAttendeeModelImpl.GROUPID_COLUMN_BITMASK |
			PersonaAttendeeModelImpl.SPPERSONAID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(PersonaAttendeeModelImpl.ENTITY_CACHE_ENABLED,
			PersonaAttendeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the persona attendees where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching persona attendees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PersonaAttendee> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the persona attendees where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.PersonaAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of persona attendees
	 * @param end the upper bound of the range of persona attendees (not inclusive)
	 * @return the range of matching persona attendees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PersonaAttendee> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the persona attendees where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.PersonaAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of persona attendees
	 * @param end the upper bound of the range of persona attendees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persona attendees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PersonaAttendee> findByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<PersonaAttendee> list = (List<PersonaAttendee>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PersonaAttendee personaAttendee : list) {
				if ((groupId != personaAttendee.getGroupId())) {
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

			query.append(_SQL_SELECT_PERSONAATTENDEE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PersonaAttendeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<PersonaAttendee>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PersonaAttendee>(list);
				}
				else {
					list = (List<PersonaAttendee>)QueryUtil.list(q,
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
	 * Returns the first persona attendee in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona attendee
	 * @throws com.sambaash.platform.srv.NoSuchPersonaAttendeeException if a matching persona attendee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PersonaAttendee findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPersonaAttendeeException, SystemException {
		PersonaAttendee personaAttendee = fetchByGroupId_First(groupId,
				orderByComparator);

		if (personaAttendee != null) {
			return personaAttendee;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPersonaAttendeeException(msg.toString());
	}

	/**
	 * Returns the first persona attendee in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona attendee, or <code>null</code> if a matching persona attendee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PersonaAttendee fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PersonaAttendee> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persona attendee in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona attendee
	 * @throws com.sambaash.platform.srv.NoSuchPersonaAttendeeException if a matching persona attendee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PersonaAttendee findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPersonaAttendeeException, SystemException {
		PersonaAttendee personaAttendee = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (personaAttendee != null) {
			return personaAttendee;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPersonaAttendeeException(msg.toString());
	}

	/**
	 * Returns the last persona attendee in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona attendee, or <code>null</code> if a matching persona attendee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PersonaAttendee fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<PersonaAttendee> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the persona attendees before and after the current persona attendee in the ordered set where groupId = &#63;.
	 *
	 * @param spPersonaAttendeeId the primary key of the current persona attendee
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persona attendee
	 * @throws com.sambaash.platform.srv.NoSuchPersonaAttendeeException if a persona attendee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PersonaAttendee[] findByGroupId_PrevAndNext(
		long spPersonaAttendeeId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPersonaAttendeeException, SystemException {
		PersonaAttendee personaAttendee = findByPrimaryKey(spPersonaAttendeeId);

		Session session = null;

		try {
			session = openSession();

			PersonaAttendee[] array = new PersonaAttendeeImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, personaAttendee,
					groupId, orderByComparator, true);

			array[1] = personaAttendee;

			array[2] = getByGroupId_PrevAndNext(session, personaAttendee,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PersonaAttendee getByGroupId_PrevAndNext(Session session,
		PersonaAttendee personaAttendee, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PERSONAATTENDEE_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(PersonaAttendeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(personaAttendee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PersonaAttendee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the persona attendees where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (PersonaAttendee personaAttendee : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(personaAttendee);
		}
	}

	/**
	 * Returns the number of persona attendees where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching persona attendees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PERSONAATTENDEE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "personaAttendee.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSONAIDANDGROUPID =
		new FinderPath(PersonaAttendeeModelImpl.ENTITY_CACHE_ENABLED,
			PersonaAttendeeModelImpl.FINDER_CACHE_ENABLED,
			PersonaAttendeeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPersonaIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONAIDANDGROUPID =
		new FinderPath(PersonaAttendeeModelImpl.ENTITY_CACHE_ENABLED,
			PersonaAttendeeModelImpl.FINDER_CACHE_ENABLED,
			PersonaAttendeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPersonaIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			PersonaAttendeeModelImpl.SPPERSONAID_COLUMN_BITMASK |
			PersonaAttendeeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PERSONAIDANDGROUPID = new FinderPath(PersonaAttendeeModelImpl.ENTITY_CACHE_ENABLED,
			PersonaAttendeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPersonaIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the persona attendees where spPersonaId = &#63; and groupId = &#63;.
	 *
	 * @param spPersonaId the sp persona ID
	 * @param groupId the group ID
	 * @return the matching persona attendees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PersonaAttendee> findByPersonaIdAndGroupId(long spPersonaId,
		long groupId) throws SystemException {
		return findByPersonaIdAndGroupId(spPersonaId, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the persona attendees where spPersonaId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.PersonaAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPersonaId the sp persona ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of persona attendees
	 * @param end the upper bound of the range of persona attendees (not inclusive)
	 * @return the range of matching persona attendees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PersonaAttendee> findByPersonaIdAndGroupId(long spPersonaId,
		long groupId, int start, int end) throws SystemException {
		return findByPersonaIdAndGroupId(spPersonaId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the persona attendees where spPersonaId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.PersonaAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPersonaId the sp persona ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of persona attendees
	 * @param end the upper bound of the range of persona attendees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persona attendees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PersonaAttendee> findByPersonaIdAndGroupId(long spPersonaId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONAIDANDGROUPID;
			finderArgs = new Object[] { spPersonaId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSONAIDANDGROUPID;
			finderArgs = new Object[] {
					spPersonaId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<PersonaAttendee> list = (List<PersonaAttendee>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PersonaAttendee personaAttendee : list) {
				if ((spPersonaId != personaAttendee.getSpPersonaId()) ||
						(groupId != personaAttendee.getGroupId())) {
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

			query.append(_SQL_SELECT_PERSONAATTENDEE_WHERE);

			query.append(_FINDER_COLUMN_PERSONAIDANDGROUPID_SPPERSONAID_2);

			query.append(_FINDER_COLUMN_PERSONAIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PersonaAttendeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPersonaId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<PersonaAttendee>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PersonaAttendee>(list);
				}
				else {
					list = (List<PersonaAttendee>)QueryUtil.list(q,
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
	 * Returns the first persona attendee in the ordered set where spPersonaId = &#63; and groupId = &#63;.
	 *
	 * @param spPersonaId the sp persona ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona attendee
	 * @throws com.sambaash.platform.srv.NoSuchPersonaAttendeeException if a matching persona attendee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PersonaAttendee findByPersonaIdAndGroupId_First(long spPersonaId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchPersonaAttendeeException, SystemException {
		PersonaAttendee personaAttendee = fetchByPersonaIdAndGroupId_First(spPersonaId,
				groupId, orderByComparator);

		if (personaAttendee != null) {
			return personaAttendee;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPersonaId=");
		msg.append(spPersonaId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPersonaAttendeeException(msg.toString());
	}

	/**
	 * Returns the first persona attendee in the ordered set where spPersonaId = &#63; and groupId = &#63;.
	 *
	 * @param spPersonaId the sp persona ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona attendee, or <code>null</code> if a matching persona attendee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PersonaAttendee fetchByPersonaIdAndGroupId_First(long spPersonaId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<PersonaAttendee> list = findByPersonaIdAndGroupId(spPersonaId,
				groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persona attendee in the ordered set where spPersonaId = &#63; and groupId = &#63;.
	 *
	 * @param spPersonaId the sp persona ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona attendee
	 * @throws com.sambaash.platform.srv.NoSuchPersonaAttendeeException if a matching persona attendee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PersonaAttendee findByPersonaIdAndGroupId_Last(long spPersonaId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchPersonaAttendeeException, SystemException {
		PersonaAttendee personaAttendee = fetchByPersonaIdAndGroupId_Last(spPersonaId,
				groupId, orderByComparator);

		if (personaAttendee != null) {
			return personaAttendee;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPersonaId=");
		msg.append(spPersonaId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPersonaAttendeeException(msg.toString());
	}

	/**
	 * Returns the last persona attendee in the ordered set where spPersonaId = &#63; and groupId = &#63;.
	 *
	 * @param spPersonaId the sp persona ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona attendee, or <code>null</code> if a matching persona attendee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PersonaAttendee fetchByPersonaIdAndGroupId_Last(long spPersonaId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPersonaIdAndGroupId(spPersonaId, groupId);

		if (count == 0) {
			return null;
		}

		List<PersonaAttendee> list = findByPersonaIdAndGroupId(spPersonaId,
				groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the persona attendees before and after the current persona attendee in the ordered set where spPersonaId = &#63; and groupId = &#63;.
	 *
	 * @param spPersonaAttendeeId the primary key of the current persona attendee
	 * @param spPersonaId the sp persona ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persona attendee
	 * @throws com.sambaash.platform.srv.NoSuchPersonaAttendeeException if a persona attendee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PersonaAttendee[] findByPersonaIdAndGroupId_PrevAndNext(
		long spPersonaAttendeeId, long spPersonaId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPersonaAttendeeException, SystemException {
		PersonaAttendee personaAttendee = findByPrimaryKey(spPersonaAttendeeId);

		Session session = null;

		try {
			session = openSession();

			PersonaAttendee[] array = new PersonaAttendeeImpl[3];

			array[0] = getByPersonaIdAndGroupId_PrevAndNext(session,
					personaAttendee, spPersonaId, groupId, orderByComparator,
					true);

			array[1] = personaAttendee;

			array[2] = getByPersonaIdAndGroupId_PrevAndNext(session,
					personaAttendee, spPersonaId, groupId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PersonaAttendee getByPersonaIdAndGroupId_PrevAndNext(
		Session session, PersonaAttendee personaAttendee, long spPersonaId,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PERSONAATTENDEE_WHERE);

		query.append(_FINDER_COLUMN_PERSONAIDANDGROUPID_SPPERSONAID_2);

		query.append(_FINDER_COLUMN_PERSONAIDANDGROUPID_GROUPID_2);

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
			query.append(PersonaAttendeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spPersonaId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(personaAttendee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PersonaAttendee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the persona attendees where spPersonaId = &#63; and groupId = &#63; from the database.
	 *
	 * @param spPersonaId the sp persona ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPersonaIdAndGroupId(long spPersonaId, long groupId)
		throws SystemException {
		for (PersonaAttendee personaAttendee : findByPersonaIdAndGroupId(
				spPersonaId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(personaAttendee);
		}
	}

	/**
	 * Returns the number of persona attendees where spPersonaId = &#63; and groupId = &#63;.
	 *
	 * @param spPersonaId the sp persona ID
	 * @param groupId the group ID
	 * @return the number of matching persona attendees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPersonaIdAndGroupId(long spPersonaId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PERSONAIDANDGROUPID;

		Object[] finderArgs = new Object[] { spPersonaId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PERSONAATTENDEE_WHERE);

			query.append(_FINDER_COLUMN_PERSONAIDANDGROUPID_SPPERSONAID_2);

			query.append(_FINDER_COLUMN_PERSONAIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPersonaId);

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

	private static final String _FINDER_COLUMN_PERSONAIDANDGROUPID_SPPERSONAID_2 =
		"personaAttendee.spPersonaId = ? AND ";
	private static final String _FINDER_COLUMN_PERSONAIDANDGROUPID_GROUPID_2 = "personaAttendee.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDANDGROUPID =
		new FinderPath(PersonaAttendeeModelImpl.ENTITY_CACHE_ENABLED,
			PersonaAttendeeModelImpl.FINDER_CACHE_ENABLED,
			PersonaAttendeeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCourseIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID =
		new FinderPath(PersonaAttendeeModelImpl.ENTITY_CACHE_ENABLED,
			PersonaAttendeeModelImpl.FINDER_CACHE_ENABLED,
			PersonaAttendeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCourseIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			PersonaAttendeeModelImpl.SPCOURSEID_COLUMN_BITMASK |
			PersonaAttendeeModelImpl.GROUPID_COLUMN_BITMASK |
			PersonaAttendeeModelImpl.SPPERSONAID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID = new FinderPath(PersonaAttendeeModelImpl.ENTITY_CACHE_ENABLED,
			PersonaAttendeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCourseIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the persona attendees where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @return the matching persona attendees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PersonaAttendee> findByCourseIdAndGroupId(long spCourseId,
		long groupId) throws SystemException {
		return findByCourseIdAndGroupId(spCourseId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the persona attendees where spCourseId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.PersonaAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of persona attendees
	 * @param end the upper bound of the range of persona attendees (not inclusive)
	 * @return the range of matching persona attendees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PersonaAttendee> findByCourseIdAndGroupId(long spCourseId,
		long groupId, int start, int end) throws SystemException {
		return findByCourseIdAndGroupId(spCourseId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the persona attendees where spCourseId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.PersonaAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of persona attendees
	 * @param end the upper bound of the range of persona attendees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persona attendees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PersonaAttendee> findByCourseIdAndGroupId(long spCourseId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID;
			finderArgs = new Object[] { spCourseId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDANDGROUPID;
			finderArgs = new Object[] {
					spCourseId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<PersonaAttendee> list = (List<PersonaAttendee>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PersonaAttendee personaAttendee : list) {
				if ((spCourseId != personaAttendee.getSpCourseId()) ||
						(groupId != personaAttendee.getGroupId())) {
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

			query.append(_SQL_SELECT_PERSONAATTENDEE_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PersonaAttendeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCourseId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<PersonaAttendee>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PersonaAttendee>(list);
				}
				else {
					list = (List<PersonaAttendee>)QueryUtil.list(q,
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
	 * Returns the first persona attendee in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona attendee
	 * @throws com.sambaash.platform.srv.NoSuchPersonaAttendeeException if a matching persona attendee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PersonaAttendee findByCourseIdAndGroupId_First(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchPersonaAttendeeException, SystemException {
		PersonaAttendee personaAttendee = fetchByCourseIdAndGroupId_First(spCourseId,
				groupId, orderByComparator);

		if (personaAttendee != null) {
			return personaAttendee;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPersonaAttendeeException(msg.toString());
	}

	/**
	 * Returns the first persona attendee in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persona attendee, or <code>null</code> if a matching persona attendee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PersonaAttendee fetchByCourseIdAndGroupId_First(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<PersonaAttendee> list = findByCourseIdAndGroupId(spCourseId,
				groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persona attendee in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona attendee
	 * @throws com.sambaash.platform.srv.NoSuchPersonaAttendeeException if a matching persona attendee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PersonaAttendee findByCourseIdAndGroupId_Last(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchPersonaAttendeeException, SystemException {
		PersonaAttendee personaAttendee = fetchByCourseIdAndGroupId_Last(spCourseId,
				groupId, orderByComparator);

		if (personaAttendee != null) {
			return personaAttendee;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPersonaAttendeeException(msg.toString());
	}

	/**
	 * Returns the last persona attendee in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persona attendee, or <code>null</code> if a matching persona attendee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PersonaAttendee fetchByCourseIdAndGroupId_Last(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCourseIdAndGroupId(spCourseId, groupId);

		if (count == 0) {
			return null;
		}

		List<PersonaAttendee> list = findByCourseIdAndGroupId(spCourseId,
				groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the persona attendees before and after the current persona attendee in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spPersonaAttendeeId the primary key of the current persona attendee
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persona attendee
	 * @throws com.sambaash.platform.srv.NoSuchPersonaAttendeeException if a persona attendee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PersonaAttendee[] findByCourseIdAndGroupId_PrevAndNext(
		long spPersonaAttendeeId, long spCourseId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPersonaAttendeeException, SystemException {
		PersonaAttendee personaAttendee = findByPrimaryKey(spPersonaAttendeeId);

		Session session = null;

		try {
			session = openSession();

			PersonaAttendee[] array = new PersonaAttendeeImpl[3];

			array[0] = getByCourseIdAndGroupId_PrevAndNext(session,
					personaAttendee, spCourseId, groupId, orderByComparator,
					true);

			array[1] = personaAttendee;

			array[2] = getByCourseIdAndGroupId_PrevAndNext(session,
					personaAttendee, spCourseId, groupId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PersonaAttendee getByCourseIdAndGroupId_PrevAndNext(
		Session session, PersonaAttendee personaAttendee, long spCourseId,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PERSONAATTENDEE_WHERE);

		query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2);

		query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2);

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
			query.append(PersonaAttendeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spCourseId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(personaAttendee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PersonaAttendee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the persona attendees where spCourseId = &#63; and groupId = &#63; from the database.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCourseIdAndGroupId(long spCourseId, long groupId)
		throws SystemException {
		for (PersonaAttendee personaAttendee : findByCourseIdAndGroupId(
				spCourseId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(personaAttendee);
		}
	}

	/**
	 * Returns the number of persona attendees where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @return the number of matching persona attendees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCourseIdAndGroupId(long spCourseId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID;

		Object[] finderArgs = new Object[] { spCourseId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PERSONAATTENDEE_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCourseId);

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

	private static final String _FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2 = "personaAttendee.spCourseId = ? AND ";
	private static final String _FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2 = "personaAttendee.groupId = ?";

	public PersonaAttendeePersistenceImpl() {
		setModelClass(PersonaAttendee.class);
	}

	/**
	 * Caches the persona attendee in the entity cache if it is enabled.
	 *
	 * @param personaAttendee the persona attendee
	 */
	@Override
	public void cacheResult(PersonaAttendee personaAttendee) {
		EntityCacheUtil.putResult(PersonaAttendeeModelImpl.ENTITY_CACHE_ENABLED,
			PersonaAttendeeImpl.class, personaAttendee.getPrimaryKey(),
			personaAttendee);

		personaAttendee.resetOriginalValues();
	}

	/**
	 * Caches the persona attendees in the entity cache if it is enabled.
	 *
	 * @param personaAttendees the persona attendees
	 */
	@Override
	public void cacheResult(List<PersonaAttendee> personaAttendees) {
		for (PersonaAttendee personaAttendee : personaAttendees) {
			if (EntityCacheUtil.getResult(
						PersonaAttendeeModelImpl.ENTITY_CACHE_ENABLED,
						PersonaAttendeeImpl.class,
						personaAttendee.getPrimaryKey()) == null) {
				cacheResult(personaAttendee);
			}
			else {
				personaAttendee.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all persona attendees.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PersonaAttendeeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PersonaAttendeeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the persona attendee.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PersonaAttendee personaAttendee) {
		EntityCacheUtil.removeResult(PersonaAttendeeModelImpl.ENTITY_CACHE_ENABLED,
			PersonaAttendeeImpl.class, personaAttendee.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PersonaAttendee> personaAttendees) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PersonaAttendee personaAttendee : personaAttendees) {
			EntityCacheUtil.removeResult(PersonaAttendeeModelImpl.ENTITY_CACHE_ENABLED,
				PersonaAttendeeImpl.class, personaAttendee.getPrimaryKey());
		}
	}

	/**
	 * Creates a new persona attendee with the primary key. Does not add the persona attendee to the database.
	 *
	 * @param spPersonaAttendeeId the primary key for the new persona attendee
	 * @return the new persona attendee
	 */
	@Override
	public PersonaAttendee create(long spPersonaAttendeeId) {
		PersonaAttendee personaAttendee = new PersonaAttendeeImpl();

		personaAttendee.setNew(true);
		personaAttendee.setPrimaryKey(spPersonaAttendeeId);

		return personaAttendee;
	}

	/**
	 * Removes the persona attendee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spPersonaAttendeeId the primary key of the persona attendee
	 * @return the persona attendee that was removed
	 * @throws com.sambaash.platform.srv.NoSuchPersonaAttendeeException if a persona attendee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PersonaAttendee remove(long spPersonaAttendeeId)
		throws NoSuchPersonaAttendeeException, SystemException {
		return remove((Serializable)spPersonaAttendeeId);
	}

	/**
	 * Removes the persona attendee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the persona attendee
	 * @return the persona attendee that was removed
	 * @throws com.sambaash.platform.srv.NoSuchPersonaAttendeeException if a persona attendee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PersonaAttendee remove(Serializable primaryKey)
		throws NoSuchPersonaAttendeeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PersonaAttendee personaAttendee = (PersonaAttendee)session.get(PersonaAttendeeImpl.class,
					primaryKey);

			if (personaAttendee == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPersonaAttendeeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(personaAttendee);
		}
		catch (NoSuchPersonaAttendeeException nsee) {
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
	protected PersonaAttendee removeImpl(PersonaAttendee personaAttendee)
		throws SystemException {
		personaAttendee = toUnwrappedModel(personaAttendee);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(personaAttendee)) {
				personaAttendee = (PersonaAttendee)session.get(PersonaAttendeeImpl.class,
						personaAttendee.getPrimaryKeyObj());
			}

			if (personaAttendee != null) {
				session.delete(personaAttendee);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (personaAttendee != null) {
			clearCache(personaAttendee);
		}

		return personaAttendee;
	}

	@Override
	public PersonaAttendee updateImpl(
		com.sambaash.platform.srv.model.PersonaAttendee personaAttendee)
		throws SystemException {
		personaAttendee = toUnwrappedModel(personaAttendee);

		boolean isNew = personaAttendee.isNew();

		PersonaAttendeeModelImpl personaAttendeeModelImpl = (PersonaAttendeeModelImpl)personaAttendee;

		Session session = null;

		try {
			session = openSession();

			if (personaAttendee.isNew()) {
				session.save(personaAttendee);

				personaAttendee.setNew(false);
			}
			else {
				session.merge(personaAttendee);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PersonaAttendeeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((personaAttendeeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						personaAttendeeModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { personaAttendeeModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((personaAttendeeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONAIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						personaAttendeeModelImpl.getOriginalSpPersonaId(),
						personaAttendeeModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERSONAIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONAIDANDGROUPID,
					args);

				args = new Object[] {
						personaAttendeeModelImpl.getSpPersonaId(),
						personaAttendeeModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERSONAIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONAIDANDGROUPID,
					args);
			}

			if ((personaAttendeeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						personaAttendeeModelImpl.getOriginalSpCourseId(),
						personaAttendeeModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID,
					args);

				args = new Object[] {
						personaAttendeeModelImpl.getSpCourseId(),
						personaAttendeeModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(PersonaAttendeeModelImpl.ENTITY_CACHE_ENABLED,
			PersonaAttendeeImpl.class, personaAttendee.getPrimaryKey(),
			personaAttendee);

		return personaAttendee;
	}

	protected PersonaAttendee toUnwrappedModel(PersonaAttendee personaAttendee) {
		if (personaAttendee instanceof PersonaAttendeeImpl) {
			return personaAttendee;
		}

		PersonaAttendeeImpl personaAttendeeImpl = new PersonaAttendeeImpl();

		personaAttendeeImpl.setNew(personaAttendee.isNew());
		personaAttendeeImpl.setPrimaryKey(personaAttendee.getPrimaryKey());

		personaAttendeeImpl.setSpPersonaAttendeeId(personaAttendee.getSpPersonaAttendeeId());
		personaAttendeeImpl.setGroupId(personaAttendee.getGroupId());
		personaAttendeeImpl.setCompanyId(personaAttendee.getCompanyId());
		personaAttendeeImpl.setUserId(personaAttendee.getUserId());
		personaAttendeeImpl.setUserName(personaAttendee.getUserName());
		personaAttendeeImpl.setCreateDate(personaAttendee.getCreateDate());
		personaAttendeeImpl.setModifiedDate(personaAttendee.getModifiedDate());
		personaAttendeeImpl.setDescription(personaAttendee.getDescription());
		personaAttendeeImpl.setImageId(personaAttendee.getImageId());
		personaAttendeeImpl.setSpPersonaId(personaAttendee.getSpPersonaId());
		personaAttendeeImpl.setSpCourseId(personaAttendee.getSpCourseId());

		return personaAttendeeImpl;
	}

	/**
	 * Returns the persona attendee with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the persona attendee
	 * @return the persona attendee
	 * @throws com.sambaash.platform.srv.NoSuchPersonaAttendeeException if a persona attendee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PersonaAttendee findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPersonaAttendeeException, SystemException {
		PersonaAttendee personaAttendee = fetchByPrimaryKey(primaryKey);

		if (personaAttendee == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPersonaAttendeeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return personaAttendee;
	}

	/**
	 * Returns the persona attendee with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchPersonaAttendeeException} if it could not be found.
	 *
	 * @param spPersonaAttendeeId the primary key of the persona attendee
	 * @return the persona attendee
	 * @throws com.sambaash.platform.srv.NoSuchPersonaAttendeeException if a persona attendee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PersonaAttendee findByPrimaryKey(long spPersonaAttendeeId)
		throws NoSuchPersonaAttendeeException, SystemException {
		return findByPrimaryKey((Serializable)spPersonaAttendeeId);
	}

	/**
	 * Returns the persona attendee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the persona attendee
	 * @return the persona attendee, or <code>null</code> if a persona attendee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PersonaAttendee fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PersonaAttendee personaAttendee = (PersonaAttendee)EntityCacheUtil.getResult(PersonaAttendeeModelImpl.ENTITY_CACHE_ENABLED,
				PersonaAttendeeImpl.class, primaryKey);

		if (personaAttendee == _nullPersonaAttendee) {
			return null;
		}

		if (personaAttendee == null) {
			Session session = null;

			try {
				session = openSession();

				personaAttendee = (PersonaAttendee)session.get(PersonaAttendeeImpl.class,
						primaryKey);

				if (personaAttendee != null) {
					cacheResult(personaAttendee);
				}
				else {
					EntityCacheUtil.putResult(PersonaAttendeeModelImpl.ENTITY_CACHE_ENABLED,
						PersonaAttendeeImpl.class, primaryKey,
						_nullPersonaAttendee);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PersonaAttendeeModelImpl.ENTITY_CACHE_ENABLED,
					PersonaAttendeeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return personaAttendee;
	}

	/**
	 * Returns the persona attendee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spPersonaAttendeeId the primary key of the persona attendee
	 * @return the persona attendee, or <code>null</code> if a persona attendee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PersonaAttendee fetchByPrimaryKey(long spPersonaAttendeeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spPersonaAttendeeId);
	}

	/**
	 * Returns all the persona attendees.
	 *
	 * @return the persona attendees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PersonaAttendee> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the persona attendees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.PersonaAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persona attendees
	 * @param end the upper bound of the range of persona attendees (not inclusive)
	 * @return the range of persona attendees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PersonaAttendee> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the persona attendees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.PersonaAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persona attendees
	 * @param end the upper bound of the range of persona attendees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persona attendees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PersonaAttendee> findAll(int start, int end,
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

		List<PersonaAttendee> list = (List<PersonaAttendee>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PERSONAATTENDEE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PERSONAATTENDEE;

				if (pagination) {
					sql = sql.concat(PersonaAttendeeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PersonaAttendee>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PersonaAttendee>(list);
				}
				else {
					list = (List<PersonaAttendee>)QueryUtil.list(q,
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
	 * Removes all the persona attendees from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PersonaAttendee personaAttendee : findAll()) {
			remove(personaAttendee);
		}
	}

	/**
	 * Returns the number of persona attendees.
	 *
	 * @return the number of persona attendees
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

				Query q = session.createQuery(_SQL_COUNT_PERSONAATTENDEE);

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
	 * Initializes the persona attendee persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.PersonaAttendee")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PersonaAttendee>> listenersList = new ArrayList<ModelListener<PersonaAttendee>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PersonaAttendee>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PersonaAttendeeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PERSONAATTENDEE = "SELECT personaAttendee FROM PersonaAttendee personaAttendee";
	private static final String _SQL_SELECT_PERSONAATTENDEE_WHERE = "SELECT personaAttendee FROM PersonaAttendee personaAttendee WHERE ";
	private static final String _SQL_COUNT_PERSONAATTENDEE = "SELECT COUNT(personaAttendee) FROM PersonaAttendee personaAttendee";
	private static final String _SQL_COUNT_PERSONAATTENDEE_WHERE = "SELECT COUNT(personaAttendee) FROM PersonaAttendee personaAttendee WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "personaAttendee.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PersonaAttendee exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PersonaAttendee exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PersonaAttendeePersistenceImpl.class);
	private static PersonaAttendee _nullPersonaAttendee = new PersonaAttendeeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PersonaAttendee> toCacheModel() {
				return _nullPersonaAttendeeCacheModel;
			}
		};

	private static CacheModel<PersonaAttendee> _nullPersonaAttendeeCacheModel = new CacheModel<PersonaAttendee>() {
			@Override
			public PersonaAttendee toEntityModel() {
				return _nullPersonaAttendee;
			}
		};
}