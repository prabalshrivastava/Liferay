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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.startupprofile.NoSuchOrganisationRemarksException;
import com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks;
import com.sambaash.platform.srv.startupprofile.model.impl.OrganisationRemarksImpl;
import com.sambaash.platform.srv.startupprofile.model.impl.OrganisationRemarksModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the organisation remarks service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see OrganisationRemarksPersistence
 * @see OrganisationRemarksUtil
 * @generated
 */
public class OrganisationRemarksPersistenceImpl extends BasePersistenceImpl<OrganisationRemarks>
	implements OrganisationRemarksPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OrganisationRemarksUtil} to access the organisation remarks persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OrganisationRemarksImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OrganisationRemarksModelImpl.ENTITY_CACHE_ENABLED,
			OrganisationRemarksModelImpl.FINDER_CACHE_ENABLED,
			OrganisationRemarksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OrganisationRemarksModelImpl.ENTITY_CACHE_ENABLED,
			OrganisationRemarksModelImpl.FINDER_CACHE_ENABLED,
			OrganisationRemarksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrganisationRemarksModelImpl.ENTITY_CACHE_ENABLED,
			OrganisationRemarksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(OrganisationRemarksModelImpl.ENTITY_CACHE_ENABLED,
			OrganisationRemarksModelImpl.FINDER_CACHE_ENABLED,
			OrganisationRemarksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(OrganisationRemarksModelImpl.ENTITY_CACHE_ENABLED,
			OrganisationRemarksModelImpl.FINDER_CACHE_ENABLED,
			OrganisationRemarksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrganizationId",
			new String[] { Long.class.getName() },
			OrganisationRemarksModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONID = new FinderPath(OrganisationRemarksModelImpl.ENTITY_CACHE_ENABLED,
			OrganisationRemarksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganizationId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the organisation remarkses where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching organisation remarkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrganisationRemarks> findByOrganizationId(long organizationId)
		throws SystemException {
		return findByOrganizationId(organizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organisation remarkses where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganisationRemarksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of organisation remarkses
	 * @param end the upper bound of the range of organisation remarkses (not inclusive)
	 * @return the range of matching organisation remarkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrganisationRemarks> findByOrganizationId(long organizationId,
		int start, int end) throws SystemException {
		return findByOrganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organisation remarkses where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganisationRemarksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of organisation remarkses
	 * @param end the upper bound of the range of organisation remarkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organisation remarkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrganisationRemarks> findByOrganizationId(long organizationId,
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

		List<OrganisationRemarks> list = (List<OrganisationRemarks>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OrganisationRemarks organisationRemarks : list) {
				if ((organizationId != organisationRemarks.getOrganizationId())) {
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

			query.append(_SQL_SELECT_ORGANISATIONREMARKS_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OrganisationRemarksModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (!pagination) {
					list = (List<OrganisationRemarks>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OrganisationRemarks>(list);
				}
				else {
					list = (List<OrganisationRemarks>)QueryUtil.list(q,
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
	 * Returns the first organisation remarks in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organisation remarks
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganisationRemarksException if a matching organisation remarks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganisationRemarks findByOrganizationId_First(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganisationRemarksException, SystemException {
		OrganisationRemarks organisationRemarks = fetchByOrganizationId_First(organizationId,
				orderByComparator);

		if (organisationRemarks != null) {
			return organisationRemarks;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganisationRemarksException(msg.toString());
	}

	/**
	 * Returns the first organisation remarks in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organisation remarks, or <code>null</code> if a matching organisation remarks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganisationRemarks fetchByOrganizationId_First(
		long organizationId, OrderByComparator orderByComparator)
		throws SystemException {
		List<OrganisationRemarks> list = findByOrganizationId(organizationId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organisation remarks in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organisation remarks
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganisationRemarksException if a matching organisation remarks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganisationRemarks findByOrganizationId_Last(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganisationRemarksException, SystemException {
		OrganisationRemarks organisationRemarks = fetchByOrganizationId_Last(organizationId,
				orderByComparator);

		if (organisationRemarks != null) {
			return organisationRemarks;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganisationRemarksException(msg.toString());
	}

	/**
	 * Returns the last organisation remarks in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organisation remarks, or <code>null</code> if a matching organisation remarks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganisationRemarks fetchByOrganizationId_Last(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOrganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<OrganisationRemarks> list = findByOrganizationId(organizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organisation remarkses before and after the current organisation remarks in the ordered set where organizationId = &#63;.
	 *
	 * @param remarksId the primary key of the current organisation remarks
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organisation remarks
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganisationRemarksException if a organisation remarks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganisationRemarks[] findByOrganizationId_PrevAndNext(
		long remarksId, long organizationId, OrderByComparator orderByComparator)
		throws NoSuchOrganisationRemarksException, SystemException {
		OrganisationRemarks organisationRemarks = findByPrimaryKey(remarksId);

		Session session = null;

		try {
			session = openSession();

			OrganisationRemarks[] array = new OrganisationRemarksImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(session,
					organisationRemarks, organizationId, orderByComparator, true);

			array[1] = organisationRemarks;

			array[2] = getByOrganizationId_PrevAndNext(session,
					organisationRemarks, organizationId, orderByComparator,
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

	protected OrganisationRemarks getByOrganizationId_PrevAndNext(
		Session session, OrganisationRemarks organisationRemarks,
		long organizationId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ORGANISATIONREMARKS_WHERE);

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
			query.append(OrganisationRemarksModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(organisationRemarks);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OrganisationRemarks> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organisation remarkses where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganizationId(long organizationId)
		throws SystemException {
		for (OrganisationRemarks organisationRemarks : findByOrganizationId(
				organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(organisationRemarks);
		}
	}

	/**
	 * Returns the number of organisation remarkses where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching organisation remarkses
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

			query.append(_SQL_COUNT_ORGANISATIONREMARKS_WHERE);

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

	private static final String _FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2 = "organisationRemarks.organizationId = ?";

	public OrganisationRemarksPersistenceImpl() {
		setModelClass(OrganisationRemarks.class);
	}

	/**
	 * Caches the organisation remarks in the entity cache if it is enabled.
	 *
	 * @param organisationRemarks the organisation remarks
	 */
	@Override
	public void cacheResult(OrganisationRemarks organisationRemarks) {
		EntityCacheUtil.putResult(OrganisationRemarksModelImpl.ENTITY_CACHE_ENABLED,
			OrganisationRemarksImpl.class, organisationRemarks.getPrimaryKey(),
			organisationRemarks);

		organisationRemarks.resetOriginalValues();
	}

	/**
	 * Caches the organisation remarkses in the entity cache if it is enabled.
	 *
	 * @param organisationRemarkses the organisation remarkses
	 */
	@Override
	public void cacheResult(List<OrganisationRemarks> organisationRemarkses) {
		for (OrganisationRemarks organisationRemarks : organisationRemarkses) {
			if (EntityCacheUtil.getResult(
						OrganisationRemarksModelImpl.ENTITY_CACHE_ENABLED,
						OrganisationRemarksImpl.class,
						organisationRemarks.getPrimaryKey()) == null) {
				cacheResult(organisationRemarks);
			}
			else {
				organisationRemarks.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all organisation remarkses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OrganisationRemarksImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OrganisationRemarksImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the organisation remarks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OrganisationRemarks organisationRemarks) {
		EntityCacheUtil.removeResult(OrganisationRemarksModelImpl.ENTITY_CACHE_ENABLED,
			OrganisationRemarksImpl.class, organisationRemarks.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<OrganisationRemarks> organisationRemarkses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OrganisationRemarks organisationRemarks : organisationRemarkses) {
			EntityCacheUtil.removeResult(OrganisationRemarksModelImpl.ENTITY_CACHE_ENABLED,
				OrganisationRemarksImpl.class,
				organisationRemarks.getPrimaryKey());
		}
	}

	/**
	 * Creates a new organisation remarks with the primary key. Does not add the organisation remarks to the database.
	 *
	 * @param remarksId the primary key for the new organisation remarks
	 * @return the new organisation remarks
	 */
	@Override
	public OrganisationRemarks create(long remarksId) {
		OrganisationRemarks organisationRemarks = new OrganisationRemarksImpl();

		organisationRemarks.setNew(true);
		organisationRemarks.setPrimaryKey(remarksId);

		return organisationRemarks;
	}

	/**
	 * Removes the organisation remarks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param remarksId the primary key of the organisation remarks
	 * @return the organisation remarks that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganisationRemarksException if a organisation remarks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganisationRemarks remove(long remarksId)
		throws NoSuchOrganisationRemarksException, SystemException {
		return remove((Serializable)remarksId);
	}

	/**
	 * Removes the organisation remarks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the organisation remarks
	 * @return the organisation remarks that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganisationRemarksException if a organisation remarks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganisationRemarks remove(Serializable primaryKey)
		throws NoSuchOrganisationRemarksException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OrganisationRemarks organisationRemarks = (OrganisationRemarks)session.get(OrganisationRemarksImpl.class,
					primaryKey);

			if (organisationRemarks == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrganisationRemarksException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(organisationRemarks);
		}
		catch (NoSuchOrganisationRemarksException nsee) {
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
	protected OrganisationRemarks removeImpl(
		OrganisationRemarks organisationRemarks) throws SystemException {
		organisationRemarks = toUnwrappedModel(organisationRemarks);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(organisationRemarks)) {
				organisationRemarks = (OrganisationRemarks)session.get(OrganisationRemarksImpl.class,
						organisationRemarks.getPrimaryKeyObj());
			}

			if (organisationRemarks != null) {
				session.delete(organisationRemarks);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (organisationRemarks != null) {
			clearCache(organisationRemarks);
		}

		return organisationRemarks;
	}

	@Override
	public OrganisationRemarks updateImpl(
		com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks organisationRemarks)
		throws SystemException {
		organisationRemarks = toUnwrappedModel(organisationRemarks);

		boolean isNew = organisationRemarks.isNew();

		OrganisationRemarksModelImpl organisationRemarksModelImpl = (OrganisationRemarksModelImpl)organisationRemarks;

		Session session = null;

		try {
			session = openSession();

			if (organisationRemarks.isNew()) {
				session.save(organisationRemarks);

				organisationRemarks.setNew(false);
			}
			else {
				session.merge(organisationRemarks);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OrganisationRemarksModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((organisationRemarksModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						organisationRemarksModelImpl.getOriginalOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);

				args = new Object[] {
						organisationRemarksModelImpl.getOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(OrganisationRemarksModelImpl.ENTITY_CACHE_ENABLED,
			OrganisationRemarksImpl.class, organisationRemarks.getPrimaryKey(),
			organisationRemarks);

		return organisationRemarks;
	}

	protected OrganisationRemarks toUnwrappedModel(
		OrganisationRemarks organisationRemarks) {
		if (organisationRemarks instanceof OrganisationRemarksImpl) {
			return organisationRemarks;
		}

		OrganisationRemarksImpl organisationRemarksImpl = new OrganisationRemarksImpl();

		organisationRemarksImpl.setNew(organisationRemarks.isNew());
		organisationRemarksImpl.setPrimaryKey(organisationRemarks.getPrimaryKey());

		organisationRemarksImpl.setRemarksId(organisationRemarks.getRemarksId());
		organisationRemarksImpl.setOrganizationId(organisationRemarks.getOrganizationId());
		organisationRemarksImpl.setRemarkType(organisationRemarks.getRemarkType());
		organisationRemarksImpl.setRemarks(organisationRemarks.getRemarks());
		organisationRemarksImpl.setNotes(organisationRemarks.getNotes());
		organisationRemarksImpl.setGroupId(organisationRemarks.getGroupId());
		organisationRemarksImpl.setCompanyId(organisationRemarks.getCompanyId());
		organisationRemarksImpl.setUserId(organisationRemarks.getUserId());
		organisationRemarksImpl.setUserName(organisationRemarks.getUserName());
		organisationRemarksImpl.setCreateDate(organisationRemarks.getCreateDate());
		organisationRemarksImpl.setModifiedDate(organisationRemarks.getModifiedDate());

		return organisationRemarksImpl;
	}

	/**
	 * Returns the organisation remarks with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the organisation remarks
	 * @return the organisation remarks
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganisationRemarksException if a organisation remarks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganisationRemarks findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrganisationRemarksException, SystemException {
		OrganisationRemarks organisationRemarks = fetchByPrimaryKey(primaryKey);

		if (organisationRemarks == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrganisationRemarksException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return organisationRemarks;
	}

	/**
	 * Returns the organisation remarks with the primary key or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchOrganisationRemarksException} if it could not be found.
	 *
	 * @param remarksId the primary key of the organisation remarks
	 * @return the organisation remarks
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganisationRemarksException if a organisation remarks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganisationRemarks findByPrimaryKey(long remarksId)
		throws NoSuchOrganisationRemarksException, SystemException {
		return findByPrimaryKey((Serializable)remarksId);
	}

	/**
	 * Returns the organisation remarks with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the organisation remarks
	 * @return the organisation remarks, or <code>null</code> if a organisation remarks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganisationRemarks fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		OrganisationRemarks organisationRemarks = (OrganisationRemarks)EntityCacheUtil.getResult(OrganisationRemarksModelImpl.ENTITY_CACHE_ENABLED,
				OrganisationRemarksImpl.class, primaryKey);

		if (organisationRemarks == _nullOrganisationRemarks) {
			return null;
		}

		if (organisationRemarks == null) {
			Session session = null;

			try {
				session = openSession();

				organisationRemarks = (OrganisationRemarks)session.get(OrganisationRemarksImpl.class,
						primaryKey);

				if (organisationRemarks != null) {
					cacheResult(organisationRemarks);
				}
				else {
					EntityCacheUtil.putResult(OrganisationRemarksModelImpl.ENTITY_CACHE_ENABLED,
						OrganisationRemarksImpl.class, primaryKey,
						_nullOrganisationRemarks);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OrganisationRemarksModelImpl.ENTITY_CACHE_ENABLED,
					OrganisationRemarksImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return organisationRemarks;
	}

	/**
	 * Returns the organisation remarks with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param remarksId the primary key of the organisation remarks
	 * @return the organisation remarks, or <code>null</code> if a organisation remarks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganisationRemarks fetchByPrimaryKey(long remarksId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)remarksId);
	}

	/**
	 * Returns all the organisation remarkses.
	 *
	 * @return the organisation remarkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrganisationRemarks> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organisation remarkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganisationRemarksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of organisation remarkses
	 * @param end the upper bound of the range of organisation remarkses (not inclusive)
	 * @return the range of organisation remarkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrganisationRemarks> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the organisation remarkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganisationRemarksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of organisation remarkses
	 * @param end the upper bound of the range of organisation remarkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of organisation remarkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrganisationRemarks> findAll(int start, int end,
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

		List<OrganisationRemarks> list = (List<OrganisationRemarks>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ORGANISATIONREMARKS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ORGANISATIONREMARKS;

				if (pagination) {
					sql = sql.concat(OrganisationRemarksModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OrganisationRemarks>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OrganisationRemarks>(list);
				}
				else {
					list = (List<OrganisationRemarks>)QueryUtil.list(q,
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
	 * Removes all the organisation remarkses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (OrganisationRemarks organisationRemarks : findAll()) {
			remove(organisationRemarks);
		}
	}

	/**
	 * Returns the number of organisation remarkses.
	 *
	 * @return the number of organisation remarkses
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

				Query q = session.createQuery(_SQL_COUNT_ORGANISATIONREMARKS);

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
	 * Initializes the organisation remarks persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OrganisationRemarks>> listenersList = new ArrayList<ModelListener<OrganisationRemarks>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OrganisationRemarks>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OrganisationRemarksImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ORGANISATIONREMARKS = "SELECT organisationRemarks FROM OrganisationRemarks organisationRemarks";
	private static final String _SQL_SELECT_ORGANISATIONREMARKS_WHERE = "SELECT organisationRemarks FROM OrganisationRemarks organisationRemarks WHERE ";
	private static final String _SQL_COUNT_ORGANISATIONREMARKS = "SELECT COUNT(organisationRemarks) FROM OrganisationRemarks organisationRemarks";
	private static final String _SQL_COUNT_ORGANISATIONREMARKS_WHERE = "SELECT COUNT(organisationRemarks) FROM OrganisationRemarks organisationRemarks WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "organisationRemarks.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OrganisationRemarks exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No OrganisationRemarks exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OrganisationRemarksPersistenceImpl.class);
	private static OrganisationRemarks _nullOrganisationRemarks = new OrganisationRemarksImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OrganisationRemarks> toCacheModel() {
				return _nullOrganisationRemarksCacheModel;
			}
		};

	private static CacheModel<OrganisationRemarks> _nullOrganisationRemarksCacheModel =
		new CacheModel<OrganisationRemarks>() {
			@Override
			public OrganisationRemarks toEntityModel() {
				return _nullOrganisationRemarks;
			}
		};
}