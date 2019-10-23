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

package com.sambaash.platform.srv.startupprofile.service.persistence;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException;
import com.sambaash.platform.srv.startupprofile.model.SPATOContacts;
import com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsImpl;
import com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p a t o contacts service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPATOContactsPersistence
 * @see SPATOContactsUtil
 * @generated
 */
public class SPATOContactsPersistenceImpl extends BasePersistenceImpl<SPATOContacts>
	implements SPATOContactsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPATOContactsUtil} to access the s p a t o contacts persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPATOContactsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPATOContactsModelImpl.ENTITY_CACHE_ENABLED,
			SPATOContactsModelImpl.FINDER_CACHE_ENABLED,
			SPATOContactsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPATOContactsModelImpl.ENTITY_CACHE_ENABLED,
			SPATOContactsModelImpl.FINDER_CACHE_ENABLED,
			SPATOContactsImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPATOContactsModelImpl.ENTITY_CACHE_ENABLED,
			SPATOContactsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(SPATOContactsModelImpl.ENTITY_CACHE_ENABLED,
			SPATOContactsModelImpl.FINDER_CACHE_ENABLED,
			SPATOContactsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOrganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(SPATOContactsModelImpl.ENTITY_CACHE_ENABLED,
			SPATOContactsModelImpl.FINDER_CACHE_ENABLED,
			SPATOContactsImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByOrganizationId", new String[] { Long.class.getName() },
			SPATOContactsModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONID = new FinderPath(SPATOContactsModelImpl.ENTITY_CACHE_ENABLED,
			SPATOContactsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganizationId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p a t o contactses where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching s p a t o contactses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPATOContacts> findByOrganizationId(long organizationId)
		throws SystemException {
		return findByOrganizationId(organizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p a t o contactses where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of s p a t o contactses
	 * @param end the upper bound of the range of s p a t o contactses (not inclusive)
	 * @return the range of matching s p a t o contactses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPATOContacts> findByOrganizationId(long organizationId,
		int start, int end) throws SystemException {
		return findByOrganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p a t o contactses where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of s p a t o contactses
	 * @param end the upper bound of the range of s p a t o contactses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p a t o contactses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPATOContacts> findByOrganizationId(long organizationId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID;
			finderArgs = new Object[] { organizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID;
			finderArgs = new Object[] {
					organizationId,
					
					start, end, orderByComparator
				};
		}

		List<SPATOContacts> list = (List<SPATOContacts>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPATOContacts spatoContacts : list) {
				if ((organizationId != spatoContacts.getOrganizationId())) {
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

			query.append(_SQL_SELECT_SPATOCONTACTS_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPATOContactsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (!pagination) {
					list = (List<SPATOContacts>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPATOContacts>(list);
				}
				else {
					list = (List<SPATOContacts>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p a t o contacts in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p a t o contacts
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a matching s p a t o contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPATOContacts findByOrganizationId_First(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchSPATOContactsException, SystemException {
		SPATOContacts spatoContacts = fetchByOrganizationId_First(organizationId,
				orderByComparator);

		if (spatoContacts != null) {
			return spatoContacts;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPATOContactsException(msg.toString());
	}

	/**
	 * Returns the first s p a t o contacts in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p a t o contacts, or <code>null</code> if a matching s p a t o contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPATOContacts fetchByOrganizationId_First(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPATOContacts> list = findByOrganizationId(organizationId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p a t o contacts in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p a t o contacts
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a matching s p a t o contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPATOContacts findByOrganizationId_Last(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchSPATOContactsException, SystemException {
		SPATOContacts spatoContacts = fetchByOrganizationId_Last(organizationId,
				orderByComparator);

		if (spatoContacts != null) {
			return spatoContacts;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPATOContactsException(msg.toString());
	}

	/**
	 * Returns the last s p a t o contacts in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p a t o contacts, or <code>null</code> if a matching s p a t o contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPATOContacts fetchByOrganizationId_Last(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOrganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<SPATOContacts> list = findByOrganizationId(organizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p a t o contactses before and after the current s p a t o contacts in the ordered set where organizationId = &#63;.
	 *
	 * @param spATOContactId the primary key of the current s p a t o contacts
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p a t o contacts
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a s p a t o contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPATOContacts[] findByOrganizationId_PrevAndNext(
		long spATOContactId, long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchSPATOContactsException, SystemException {
		SPATOContacts spatoContacts = findByPrimaryKey(spATOContactId);

		Session session = null;

		try {
			session = openSession();

			SPATOContacts[] array = new SPATOContactsImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(session, spatoContacts,
					organizationId, orderByComparator, true);

			array[1] = spatoContacts;

			array[2] = getByOrganizationId_PrevAndNext(session, spatoContacts,
					organizationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPATOContacts getByOrganizationId_PrevAndNext(Session session,
		SPATOContacts spatoContacts, long organizationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPATOCONTACTS_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

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
			query.append(SPATOContactsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spatoContacts);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPATOContacts> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p a t o contactses where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganizationId(long organizationId)
		throws SystemException {
		for (SPATOContacts spatoContacts : findByOrganizationId(
				organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spatoContacts);
		}
	}

	/**
	 * Returns the number of s p a t o contactses where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching s p a t o contactses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrganizationId(long organizationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATIONID;

		Object[] finderArgs = new Object[] { organizationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPATOCONTACTS_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

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

	private static final String _FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2 = "spatoContacts.organizationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRIMARYPRINCIPALUSERID =
		new FinderPath(SPATOContactsModelImpl.ENTITY_CACHE_ENABLED,
			SPATOContactsModelImpl.FINDER_CACHE_ENABLED,
			SPATOContactsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPrimaryPrincipalUserId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIMARYPRINCIPALUSERID =
		new FinderPath(SPATOContactsModelImpl.ENTITY_CACHE_ENABLED,
			SPATOContactsModelImpl.FINDER_CACHE_ENABLED,
			SPATOContactsImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPrimaryPrincipalUserId",
			new String[] { String.class.getName() },
			SPATOContactsModelImpl.PRIMARYPRINCIPALUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRIMARYPRINCIPALUSERID = new FinderPath(SPATOContactsModelImpl.ENTITY_CACHE_ENABLED,
			SPATOContactsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPrimaryPrincipalUserId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p a t o contactses where primaryPrincipalUserId = &#63;.
	 *
	 * @param primaryPrincipalUserId the primary principal user ID
	 * @return the matching s p a t o contactses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPATOContacts> findByPrimaryPrincipalUserId(
		String primaryPrincipalUserId) throws SystemException {
		return findByPrimaryPrincipalUserId(primaryPrincipalUserId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p a t o contactses where primaryPrincipalUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param primaryPrincipalUserId the primary principal user ID
	 * @param start the lower bound of the range of s p a t o contactses
	 * @param end the upper bound of the range of s p a t o contactses (not inclusive)
	 * @return the range of matching s p a t o contactses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPATOContacts> findByPrimaryPrincipalUserId(
		String primaryPrincipalUserId, int start, int end)
		throws SystemException {
		return findByPrimaryPrincipalUserId(primaryPrincipalUserId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the s p a t o contactses where primaryPrincipalUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param primaryPrincipalUserId the primary principal user ID
	 * @param start the lower bound of the range of s p a t o contactses
	 * @param end the upper bound of the range of s p a t o contactses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p a t o contactses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPATOContacts> findByPrimaryPrincipalUserId(
		String primaryPrincipalUserId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIMARYPRINCIPALUSERID;
			finderArgs = new Object[] { primaryPrincipalUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PRIMARYPRINCIPALUSERID;
			finderArgs = new Object[] {
					primaryPrincipalUserId,
					
					start, end, orderByComparator
				};
		}

		List<SPATOContacts> list = (List<SPATOContacts>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPATOContacts spatoContacts : list) {
				if (!Validator.equals(primaryPrincipalUserId,
							spatoContacts.getPrimaryPrincipalUserId())) {
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

			query.append(_SQL_SELECT_SPATOCONTACTS_WHERE);

			boolean bindPrimaryPrincipalUserId = false;

			if (primaryPrincipalUserId == null) {
				query.append(_FINDER_COLUMN_PRIMARYPRINCIPALUSERID_PRIMARYPRINCIPALUSERID_1);
			}
			else if (primaryPrincipalUserId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PRIMARYPRINCIPALUSERID_PRIMARYPRINCIPALUSERID_3);
			}
			else {
				bindPrimaryPrincipalUserId = true;

				query.append(_FINDER_COLUMN_PRIMARYPRINCIPALUSERID_PRIMARYPRINCIPALUSERID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPATOContactsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPrimaryPrincipalUserId) {
					qPos.add(primaryPrincipalUserId);
				}

				if (!pagination) {
					list = (List<SPATOContacts>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPATOContacts>(list);
				}
				else {
					list = (List<SPATOContacts>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p a t o contacts in the ordered set where primaryPrincipalUserId = &#63;.
	 *
	 * @param primaryPrincipalUserId the primary principal user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p a t o contacts
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a matching s p a t o contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPATOContacts findByPrimaryPrincipalUserId_First(
		String primaryPrincipalUserId, OrderByComparator orderByComparator)
		throws NoSuchSPATOContactsException, SystemException {
		SPATOContacts spatoContacts = fetchByPrimaryPrincipalUserId_First(primaryPrincipalUserId,
				orderByComparator);

		if (spatoContacts != null) {
			return spatoContacts;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("primaryPrincipalUserId=");
		msg.append(primaryPrincipalUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPATOContactsException(msg.toString());
	}

	/**
	 * Returns the first s p a t o contacts in the ordered set where primaryPrincipalUserId = &#63;.
	 *
	 * @param primaryPrincipalUserId the primary principal user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p a t o contacts, or <code>null</code> if a matching s p a t o contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPATOContacts fetchByPrimaryPrincipalUserId_First(
		String primaryPrincipalUserId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPATOContacts> list = findByPrimaryPrincipalUserId(primaryPrincipalUserId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p a t o contacts in the ordered set where primaryPrincipalUserId = &#63;.
	 *
	 * @param primaryPrincipalUserId the primary principal user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p a t o contacts
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a matching s p a t o contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPATOContacts findByPrimaryPrincipalUserId_Last(
		String primaryPrincipalUserId, OrderByComparator orderByComparator)
		throws NoSuchSPATOContactsException, SystemException {
		SPATOContacts spatoContacts = fetchByPrimaryPrincipalUserId_Last(primaryPrincipalUserId,
				orderByComparator);

		if (spatoContacts != null) {
			return spatoContacts;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("primaryPrincipalUserId=");
		msg.append(primaryPrincipalUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPATOContactsException(msg.toString());
	}

	/**
	 * Returns the last s p a t o contacts in the ordered set where primaryPrincipalUserId = &#63;.
	 *
	 * @param primaryPrincipalUserId the primary principal user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p a t o contacts, or <code>null</code> if a matching s p a t o contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPATOContacts fetchByPrimaryPrincipalUserId_Last(
		String primaryPrincipalUserId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPrimaryPrincipalUserId(primaryPrincipalUserId);

		if (count == 0) {
			return null;
		}

		List<SPATOContacts> list = findByPrimaryPrincipalUserId(primaryPrincipalUserId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p a t o contactses before and after the current s p a t o contacts in the ordered set where primaryPrincipalUserId = &#63;.
	 *
	 * @param spATOContactId the primary key of the current s p a t o contacts
	 * @param primaryPrincipalUserId the primary principal user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p a t o contacts
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a s p a t o contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPATOContacts[] findByPrimaryPrincipalUserId_PrevAndNext(
		long spATOContactId, String primaryPrincipalUserId,
		OrderByComparator orderByComparator)
		throws NoSuchSPATOContactsException, SystemException {
		SPATOContacts spatoContacts = findByPrimaryKey(spATOContactId);

		Session session = null;

		try {
			session = openSession();

			SPATOContacts[] array = new SPATOContactsImpl[3];

			array[0] = getByPrimaryPrincipalUserId_PrevAndNext(session,
					spatoContacts, primaryPrincipalUserId, orderByComparator,
					true);

			array[1] = spatoContacts;

			array[2] = getByPrimaryPrincipalUserId_PrevAndNext(session,
					spatoContacts, primaryPrincipalUserId, orderByComparator,
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

	protected SPATOContacts getByPrimaryPrincipalUserId_PrevAndNext(
		Session session, SPATOContacts spatoContacts,
		String primaryPrincipalUserId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPATOCONTACTS_WHERE);

		boolean bindPrimaryPrincipalUserId = false;

		if (primaryPrincipalUserId == null) {
			query.append(_FINDER_COLUMN_PRIMARYPRINCIPALUSERID_PRIMARYPRINCIPALUSERID_1);
		}
		else if (primaryPrincipalUserId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PRIMARYPRINCIPALUSERID_PRIMARYPRINCIPALUSERID_3);
		}
		else {
			bindPrimaryPrincipalUserId = true;

			query.append(_FINDER_COLUMN_PRIMARYPRINCIPALUSERID_PRIMARYPRINCIPALUSERID_2);
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
			query.append(SPATOContactsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPrimaryPrincipalUserId) {
			qPos.add(primaryPrincipalUserId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spatoContacts);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPATOContacts> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p a t o contactses where primaryPrincipalUserId = &#63; from the database.
	 *
	 * @param primaryPrincipalUserId the primary principal user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPrimaryPrincipalUserId(String primaryPrincipalUserId)
		throws SystemException {
		for (SPATOContacts spatoContacts : findByPrimaryPrincipalUserId(
				primaryPrincipalUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(spatoContacts);
		}
	}

	/**
	 * Returns the number of s p a t o contactses where primaryPrincipalUserId = &#63;.
	 *
	 * @param primaryPrincipalUserId the primary principal user ID
	 * @return the number of matching s p a t o contactses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPrimaryPrincipalUserId(String primaryPrincipalUserId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PRIMARYPRINCIPALUSERID;

		Object[] finderArgs = new Object[] { primaryPrincipalUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPATOCONTACTS_WHERE);

			boolean bindPrimaryPrincipalUserId = false;

			if (primaryPrincipalUserId == null) {
				query.append(_FINDER_COLUMN_PRIMARYPRINCIPALUSERID_PRIMARYPRINCIPALUSERID_1);
			}
			else if (primaryPrincipalUserId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PRIMARYPRINCIPALUSERID_PRIMARYPRINCIPALUSERID_3);
			}
			else {
				bindPrimaryPrincipalUserId = true;

				query.append(_FINDER_COLUMN_PRIMARYPRINCIPALUSERID_PRIMARYPRINCIPALUSERID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPrimaryPrincipalUserId) {
					qPos.add(primaryPrincipalUserId);
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

	private static final String _FINDER_COLUMN_PRIMARYPRINCIPALUSERID_PRIMARYPRINCIPALUSERID_1 =
		"spatoContacts.primaryPrincipalUserId IS NULL";
	private static final String _FINDER_COLUMN_PRIMARYPRINCIPALUSERID_PRIMARYPRINCIPALUSERID_2 =
		"spatoContacts.primaryPrincipalUserId = ?";
	private static final String _FINDER_COLUMN_PRIMARYPRINCIPALUSERID_PRIMARYPRINCIPALUSERID_3 =
		"(spatoContacts.primaryPrincipalUserId IS NULL OR spatoContacts.primaryPrincipalUserId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SECONDARYPRINCIPALUSERID =
		new FinderPath(SPATOContactsModelImpl.ENTITY_CACHE_ENABLED,
			SPATOContactsModelImpl.FINDER_CACHE_ENABLED,
			SPATOContactsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySecondaryPrincipalUserId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SECONDARYPRINCIPALUSERID =
		new FinderPath(SPATOContactsModelImpl.ENTITY_CACHE_ENABLED,
			SPATOContactsModelImpl.FINDER_CACHE_ENABLED,
			SPATOContactsImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySecondaryPrincipalUserId",
			new String[] { String.class.getName() },
			SPATOContactsModelImpl.SECONDARYPRINCIPALUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SECONDARYPRINCIPALUSERID =
		new FinderPath(SPATOContactsModelImpl.ENTITY_CACHE_ENABLED,
			SPATOContactsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySecondaryPrincipalUserId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p a t o contactses where secondaryPrincipalUserId = &#63;.
	 *
	 * @param secondaryPrincipalUserId the secondary principal user ID
	 * @return the matching s p a t o contactses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPATOContacts> findBySecondaryPrincipalUserId(
		String secondaryPrincipalUserId) throws SystemException {
		return findBySecondaryPrincipalUserId(secondaryPrincipalUserId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p a t o contactses where secondaryPrincipalUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param secondaryPrincipalUserId the secondary principal user ID
	 * @param start the lower bound of the range of s p a t o contactses
	 * @param end the upper bound of the range of s p a t o contactses (not inclusive)
	 * @return the range of matching s p a t o contactses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPATOContacts> findBySecondaryPrincipalUserId(
		String secondaryPrincipalUserId, int start, int end)
		throws SystemException {
		return findBySecondaryPrincipalUserId(secondaryPrincipalUserId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the s p a t o contactses where secondaryPrincipalUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param secondaryPrincipalUserId the secondary principal user ID
	 * @param start the lower bound of the range of s p a t o contactses
	 * @param end the upper bound of the range of s p a t o contactses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p a t o contactses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPATOContacts> findBySecondaryPrincipalUserId(
		String secondaryPrincipalUserId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SECONDARYPRINCIPALUSERID;
			finderArgs = new Object[] { secondaryPrincipalUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SECONDARYPRINCIPALUSERID;
			finderArgs = new Object[] {
					secondaryPrincipalUserId,
					
					start, end, orderByComparator
				};
		}

		List<SPATOContacts> list = (List<SPATOContacts>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPATOContacts spatoContacts : list) {
				if (!Validator.equals(secondaryPrincipalUserId,
							spatoContacts.getSecondaryPrincipalUserId())) {
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

			query.append(_SQL_SELECT_SPATOCONTACTS_WHERE);

			boolean bindSecondaryPrincipalUserId = false;

			if (secondaryPrincipalUserId == null) {
				query.append(_FINDER_COLUMN_SECONDARYPRINCIPALUSERID_SECONDARYPRINCIPALUSERID_1);
			}
			else if (secondaryPrincipalUserId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SECONDARYPRINCIPALUSERID_SECONDARYPRINCIPALUSERID_3);
			}
			else {
				bindSecondaryPrincipalUserId = true;

				query.append(_FINDER_COLUMN_SECONDARYPRINCIPALUSERID_SECONDARYPRINCIPALUSERID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPATOContactsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSecondaryPrincipalUserId) {
					qPos.add(secondaryPrincipalUserId);
				}

				if (!pagination) {
					list = (List<SPATOContacts>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPATOContacts>(list);
				}
				else {
					list = (List<SPATOContacts>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p a t o contacts in the ordered set where secondaryPrincipalUserId = &#63;.
	 *
	 * @param secondaryPrincipalUserId the secondary principal user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p a t o contacts
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a matching s p a t o contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPATOContacts findBySecondaryPrincipalUserId_First(
		String secondaryPrincipalUserId, OrderByComparator orderByComparator)
		throws NoSuchSPATOContactsException, SystemException {
		SPATOContacts spatoContacts = fetchBySecondaryPrincipalUserId_First(secondaryPrincipalUserId,
				orderByComparator);

		if (spatoContacts != null) {
			return spatoContacts;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("secondaryPrincipalUserId=");
		msg.append(secondaryPrincipalUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPATOContactsException(msg.toString());
	}

	/**
	 * Returns the first s p a t o contacts in the ordered set where secondaryPrincipalUserId = &#63;.
	 *
	 * @param secondaryPrincipalUserId the secondary principal user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p a t o contacts, or <code>null</code> if a matching s p a t o contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPATOContacts fetchBySecondaryPrincipalUserId_First(
		String secondaryPrincipalUserId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPATOContacts> list = findBySecondaryPrincipalUserId(secondaryPrincipalUserId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p a t o contacts in the ordered set where secondaryPrincipalUserId = &#63;.
	 *
	 * @param secondaryPrincipalUserId the secondary principal user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p a t o contacts
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a matching s p a t o contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPATOContacts findBySecondaryPrincipalUserId_Last(
		String secondaryPrincipalUserId, OrderByComparator orderByComparator)
		throws NoSuchSPATOContactsException, SystemException {
		SPATOContacts spatoContacts = fetchBySecondaryPrincipalUserId_Last(secondaryPrincipalUserId,
				orderByComparator);

		if (spatoContacts != null) {
			return spatoContacts;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("secondaryPrincipalUserId=");
		msg.append(secondaryPrincipalUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPATOContactsException(msg.toString());
	}

	/**
	 * Returns the last s p a t o contacts in the ordered set where secondaryPrincipalUserId = &#63;.
	 *
	 * @param secondaryPrincipalUserId the secondary principal user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p a t o contacts, or <code>null</code> if a matching s p a t o contacts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPATOContacts fetchBySecondaryPrincipalUserId_Last(
		String secondaryPrincipalUserId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBySecondaryPrincipalUserId(secondaryPrincipalUserId);

		if (count == 0) {
			return null;
		}

		List<SPATOContacts> list = findBySecondaryPrincipalUserId(secondaryPrincipalUserId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p a t o contactses before and after the current s p a t o contacts in the ordered set where secondaryPrincipalUserId = &#63;.
	 *
	 * @param spATOContactId the primary key of the current s p a t o contacts
	 * @param secondaryPrincipalUserId the secondary principal user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p a t o contacts
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a s p a t o contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPATOContacts[] findBySecondaryPrincipalUserId_PrevAndNext(
		long spATOContactId, String secondaryPrincipalUserId,
		OrderByComparator orderByComparator)
		throws NoSuchSPATOContactsException, SystemException {
		SPATOContacts spatoContacts = findByPrimaryKey(spATOContactId);

		Session session = null;

		try {
			session = openSession();

			SPATOContacts[] array = new SPATOContactsImpl[3];

			array[0] = getBySecondaryPrincipalUserId_PrevAndNext(session,
					spatoContacts, secondaryPrincipalUserId, orderByComparator,
					true);

			array[1] = spatoContacts;

			array[2] = getBySecondaryPrincipalUserId_PrevAndNext(session,
					spatoContacts, secondaryPrincipalUserId, orderByComparator,
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

	protected SPATOContacts getBySecondaryPrincipalUserId_PrevAndNext(
		Session session, SPATOContacts spatoContacts,
		String secondaryPrincipalUserId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPATOCONTACTS_WHERE);

		boolean bindSecondaryPrincipalUserId = false;

		if (secondaryPrincipalUserId == null) {
			query.append(_FINDER_COLUMN_SECONDARYPRINCIPALUSERID_SECONDARYPRINCIPALUSERID_1);
		}
		else if (secondaryPrincipalUserId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_SECONDARYPRINCIPALUSERID_SECONDARYPRINCIPALUSERID_3);
		}
		else {
			bindSecondaryPrincipalUserId = true;

			query.append(_FINDER_COLUMN_SECONDARYPRINCIPALUSERID_SECONDARYPRINCIPALUSERID_2);
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
			query.append(SPATOContactsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindSecondaryPrincipalUserId) {
			qPos.add(secondaryPrincipalUserId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spatoContacts);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPATOContacts> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p a t o contactses where secondaryPrincipalUserId = &#63; from the database.
	 *
	 * @param secondaryPrincipalUserId the secondary principal user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySecondaryPrincipalUserId(
		String secondaryPrincipalUserId) throws SystemException {
		for (SPATOContacts spatoContacts : findBySecondaryPrincipalUserId(
				secondaryPrincipalUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(spatoContacts);
		}
	}

	/**
	 * Returns the number of s p a t o contactses where secondaryPrincipalUserId = &#63;.
	 *
	 * @param secondaryPrincipalUserId the secondary principal user ID
	 * @return the number of matching s p a t o contactses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySecondaryPrincipalUserId(String secondaryPrincipalUserId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SECONDARYPRINCIPALUSERID;

		Object[] finderArgs = new Object[] { secondaryPrincipalUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPATOCONTACTS_WHERE);

			boolean bindSecondaryPrincipalUserId = false;

			if (secondaryPrincipalUserId == null) {
				query.append(_FINDER_COLUMN_SECONDARYPRINCIPALUSERID_SECONDARYPRINCIPALUSERID_1);
			}
			else if (secondaryPrincipalUserId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SECONDARYPRINCIPALUSERID_SECONDARYPRINCIPALUSERID_3);
			}
			else {
				bindSecondaryPrincipalUserId = true;

				query.append(_FINDER_COLUMN_SECONDARYPRINCIPALUSERID_SECONDARYPRINCIPALUSERID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSecondaryPrincipalUserId) {
					qPos.add(secondaryPrincipalUserId);
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

	private static final String _FINDER_COLUMN_SECONDARYPRINCIPALUSERID_SECONDARYPRINCIPALUSERID_1 =
		"spatoContacts.secondaryPrincipalUserId IS NULL";
	private static final String _FINDER_COLUMN_SECONDARYPRINCIPALUSERID_SECONDARYPRINCIPALUSERID_2 =
		"spatoContacts.secondaryPrincipalUserId = ?";
	private static final String _FINDER_COLUMN_SECONDARYPRINCIPALUSERID_SECONDARYPRINCIPALUSERID_3 =
		"(spatoContacts.secondaryPrincipalUserId IS NULL OR spatoContacts.secondaryPrincipalUserId = '')";

	public SPATOContactsPersistenceImpl() {
		setModelClass(SPATOContacts.class);
	}

	/**
	 * Caches the s p a t o contacts in the entity cache if it is enabled.
	 *
	 * @param spatoContacts the s p a t o contacts
	 */
	@Override
	public void cacheResult(SPATOContacts spatoContacts) {
		EntityCacheUtil.putResult(SPATOContactsModelImpl.ENTITY_CACHE_ENABLED,
			SPATOContactsImpl.class, spatoContacts.getPrimaryKey(),
			spatoContacts);

		spatoContacts.resetOriginalValues();
	}

	/**
	 * Caches the s p a t o contactses in the entity cache if it is enabled.
	 *
	 * @param spatoContactses the s p a t o contactses
	 */
	@Override
	public void cacheResult(List<SPATOContacts> spatoContactses) {
		for (SPATOContacts spatoContacts : spatoContactses) {
			if (EntityCacheUtil.getResult(
						SPATOContactsModelImpl.ENTITY_CACHE_ENABLED,
						SPATOContactsImpl.class, spatoContacts.getPrimaryKey()) == null) {
				cacheResult(spatoContacts);
			}
			else {
				spatoContacts.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p a t o contactses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPATOContactsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPATOContactsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p a t o contacts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPATOContacts spatoContacts) {
		EntityCacheUtil.removeResult(SPATOContactsModelImpl.ENTITY_CACHE_ENABLED,
			SPATOContactsImpl.class, spatoContacts.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SPATOContacts> spatoContactses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPATOContacts spatoContacts : spatoContactses) {
			EntityCacheUtil.removeResult(SPATOContactsModelImpl.ENTITY_CACHE_ENABLED,
				SPATOContactsImpl.class, spatoContacts.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s p a t o contacts with the primary key. Does not add the s p a t o contacts to the database.
	 *
	 * @param spATOContactId the primary key for the new s p a t o contacts
	 * @return the new s p a t o contacts
	 */
	@Override
	public SPATOContacts create(long spATOContactId) {
		SPATOContacts spatoContacts = new SPATOContactsImpl();

		spatoContacts.setNew(true);
		spatoContacts.setPrimaryKey(spATOContactId);

		return spatoContacts;
	}

	/**
	 * Removes the s p a t o contacts with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spATOContactId the primary key of the s p a t o contacts
	 * @return the s p a t o contacts that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a s p a t o contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPATOContacts remove(long spATOContactId)
		throws NoSuchSPATOContactsException, SystemException {
		return remove((Serializable)spATOContactId);
	}

	/**
	 * Removes the s p a t o contacts with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p a t o contacts
	 * @return the s p a t o contacts that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a s p a t o contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPATOContacts remove(Serializable primaryKey)
		throws NoSuchSPATOContactsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPATOContacts spatoContacts = (SPATOContacts)session.get(SPATOContactsImpl.class,
					primaryKey);

			if (spatoContacts == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPATOContactsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spatoContacts);
		}
		catch (NoSuchSPATOContactsException nsee) {
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
	protected SPATOContacts removeImpl(SPATOContacts spatoContacts)
		throws SystemException {
		spatoContacts = toUnwrappedModel(spatoContacts);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spatoContacts)) {
				spatoContacts = (SPATOContacts)session.get(SPATOContactsImpl.class,
						spatoContacts.getPrimaryKeyObj());
			}

			if (spatoContacts != null) {
				session.delete(spatoContacts);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spatoContacts != null) {
			clearCache(spatoContacts);
		}

		return spatoContacts;
	}

	@Override
	public SPATOContacts updateImpl(
		com.sambaash.platform.srv.startupprofile.model.SPATOContacts spatoContacts)
		throws SystemException {
		spatoContacts = toUnwrappedModel(spatoContacts);

		boolean isNew = spatoContacts.isNew();

		SPATOContactsModelImpl spatoContactsModelImpl = (SPATOContactsModelImpl)spatoContacts;

		Session session = null;

		try {
			session = openSession();

			if (spatoContacts.isNew()) {
				session.save(spatoContacts);

				spatoContacts.setNew(false);
			}
			else {
				session.merge(spatoContacts);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPATOContactsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spatoContactsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spatoContactsModelImpl.getOriginalOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);

				args = new Object[] { spatoContactsModelImpl.getOrganizationId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);
			}

			if ((spatoContactsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIMARYPRINCIPALUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spatoContactsModelImpl.getOriginalPrimaryPrincipalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRIMARYPRINCIPALUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIMARYPRINCIPALUSERID,
					args);

				args = new Object[] {
						spatoContactsModelImpl.getPrimaryPrincipalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRIMARYPRINCIPALUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIMARYPRINCIPALUSERID,
					args);
			}

			if ((spatoContactsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SECONDARYPRINCIPALUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spatoContactsModelImpl.getOriginalSecondaryPrincipalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SECONDARYPRINCIPALUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SECONDARYPRINCIPALUSERID,
					args);

				args = new Object[] {
						spatoContactsModelImpl.getSecondaryPrincipalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SECONDARYPRINCIPALUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SECONDARYPRINCIPALUSERID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPATOContactsModelImpl.ENTITY_CACHE_ENABLED,
			SPATOContactsImpl.class, spatoContacts.getPrimaryKey(),
			spatoContacts);

		return spatoContacts;
	}

	protected SPATOContacts toUnwrappedModel(SPATOContacts spatoContacts) {
		if (spatoContacts instanceof SPATOContactsImpl) {
			return spatoContacts;
		}

		SPATOContactsImpl spatoContactsImpl = new SPATOContactsImpl();

		spatoContactsImpl.setNew(spatoContacts.isNew());
		spatoContactsImpl.setPrimaryKey(spatoContacts.getPrimaryKey());

		spatoContactsImpl.setSpATOContactId(spatoContacts.getSpATOContactId());
		spatoContactsImpl.setGroupId(spatoContacts.getGroupId());
		spatoContactsImpl.setOrganizationId(spatoContacts.getOrganizationId());
		spatoContactsImpl.setUserId(spatoContacts.getUserId());
		spatoContactsImpl.setFirstName(spatoContacts.getFirstName());
		spatoContactsImpl.setLastName(spatoContacts.getLastName());
		spatoContactsImpl.setCreateDate(spatoContacts.getCreateDate());
		spatoContactsImpl.setModifiedDate(spatoContacts.getModifiedDate());
		spatoContactsImpl.setPrimaryPrincipalUserId(spatoContacts.getPrimaryPrincipalUserId());
		spatoContactsImpl.setSecondaryPrincipalUserId(spatoContacts.getSecondaryPrincipalUserId());

		return spatoContactsImpl;
	}

	/**
	 * Returns the s p a t o contacts with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p a t o contacts
	 * @return the s p a t o contacts
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a s p a t o contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPATOContacts findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPATOContactsException, SystemException {
		SPATOContacts spatoContacts = fetchByPrimaryKey(primaryKey);

		if (spatoContacts == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPATOContactsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spatoContacts;
	}

	/**
	 * Returns the s p a t o contacts with the primary key or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException} if it could not be found.
	 *
	 * @param spATOContactId the primary key of the s p a t o contacts
	 * @return the s p a t o contacts
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchSPATOContactsException if a s p a t o contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPATOContacts findByPrimaryKey(long spATOContactId)
		throws NoSuchSPATOContactsException, SystemException {
		return findByPrimaryKey((Serializable)spATOContactId);
	}

	/**
	 * Returns the s p a t o contacts with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p a t o contacts
	 * @return the s p a t o contacts, or <code>null</code> if a s p a t o contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPATOContacts fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPATOContacts spatoContacts = (SPATOContacts)EntityCacheUtil.getResult(SPATOContactsModelImpl.ENTITY_CACHE_ENABLED,
				SPATOContactsImpl.class, primaryKey);

		if (spatoContacts == _nullSPATOContacts) {
			return null;
		}

		if (spatoContacts == null) {
			Session session = null;

			try {
				session = openSession();

				spatoContacts = (SPATOContacts)session.get(SPATOContactsImpl.class,
						primaryKey);

				if (spatoContacts != null) {
					cacheResult(spatoContacts);
				}
				else {
					EntityCacheUtil.putResult(SPATOContactsModelImpl.ENTITY_CACHE_ENABLED,
						SPATOContactsImpl.class, primaryKey, _nullSPATOContacts);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPATOContactsModelImpl.ENTITY_CACHE_ENABLED,
					SPATOContactsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spatoContacts;
	}

	/**
	 * Returns the s p a t o contacts with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spATOContactId the primary key of the s p a t o contacts
	 * @return the s p a t o contacts, or <code>null</code> if a s p a t o contacts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPATOContacts fetchByPrimaryKey(long spATOContactId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spATOContactId);
	}

	/**
	 * Returns all the s p a t o contactses.
	 *
	 * @return the s p a t o contactses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPATOContacts> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p a t o contactses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p a t o contactses
	 * @param end the upper bound of the range of s p a t o contactses (not inclusive)
	 * @return the range of s p a t o contactses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPATOContacts> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p a t o contactses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p a t o contactses
	 * @param end the upper bound of the range of s p a t o contactses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p a t o contactses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPATOContacts> findAll(int start, int end,
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

		List<SPATOContacts> list = (List<SPATOContacts>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPATOCONTACTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPATOCONTACTS;

				if (pagination) {
					sql = sql.concat(SPATOContactsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPATOContacts>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPATOContacts>(list);
				}
				else {
					list = (List<SPATOContacts>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p a t o contactses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPATOContacts spatoContacts : findAll()) {
			remove(spatoContacts);
		}
	}

	/**
	 * Returns the number of s p a t o contactses.
	 *
	 * @return the number of s p a t o contactses
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

				Query q = session.createQuery(_SQL_COUNT_SPATOCONTACTS);

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
	 * Initializes the s p a t o contacts persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.startupprofile.model.SPATOContacts")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPATOContacts>> listenersList = new ArrayList<ModelListener<SPATOContacts>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPATOContacts>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPATOContactsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPATOCONTACTS = "SELECT spatoContacts FROM SPATOContacts spatoContacts";
	private static final String _SQL_SELECT_SPATOCONTACTS_WHERE = "SELECT spatoContacts FROM SPATOContacts spatoContacts WHERE ";
	private static final String _SQL_COUNT_SPATOCONTACTS = "SELECT COUNT(spatoContacts) FROM SPATOContacts spatoContacts";
	private static final String _SQL_COUNT_SPATOCONTACTS_WHERE = "SELECT COUNT(spatoContacts) FROM SPATOContacts spatoContacts WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spatoContacts.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPATOContacts exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPATOContacts exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPATOContactsPersistenceImpl.class);
	private static SPATOContacts _nullSPATOContacts = new SPATOContactsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPATOContacts> toCacheModel() {
				return _nullSPATOContactsCacheModel;
			}
		};

	private static CacheModel<SPATOContacts> _nullSPATOContactsCacheModel = new CacheModel<SPATOContacts>() {
			@Override
			public SPATOContacts toEntityModel() {
				return _nullSPATOContacts;
			}
		};
}