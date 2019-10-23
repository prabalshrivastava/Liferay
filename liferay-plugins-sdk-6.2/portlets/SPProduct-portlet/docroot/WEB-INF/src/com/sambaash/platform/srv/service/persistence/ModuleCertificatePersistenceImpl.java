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

import com.sambaash.platform.srv.NoSuchModuleCertificateException;
import com.sambaash.platform.srv.model.ModuleCertificate;
import com.sambaash.platform.srv.model.impl.ModuleCertificateImpl;
import com.sambaash.platform.srv.model.impl.ModuleCertificateModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the module certificate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see ModuleCertificatePersistence
 * @see ModuleCertificateUtil
 * @generated
 */
public class ModuleCertificatePersistenceImpl extends BasePersistenceImpl<ModuleCertificate>
	implements ModuleCertificatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ModuleCertificateUtil} to access the module certificate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ModuleCertificateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ModuleCertificateModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCertificateModelImpl.FINDER_CACHE_ENABLED,
			ModuleCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ModuleCertificateModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCertificateModelImpl.FINDER_CACHE_ENABLED,
			ModuleCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ModuleCertificateModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCertificateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ModuleCertificateModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCertificateModelImpl.FINDER_CACHE_ENABLED,
			ModuleCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ModuleCertificateModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCertificateModelImpl.FINDER_CACHE_ENABLED,
			ModuleCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ModuleCertificateModelImpl.GROUPID_COLUMN_BITMASK |
			ModuleCertificateModelImpl.SPMODULEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ModuleCertificateModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCertificateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the module certificates where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching module certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleCertificate> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the module certificates where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of module certificates
	 * @param end the upper bound of the range of module certificates (not inclusive)
	 * @return the range of matching module certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleCertificate> findByGroupId(long groupId, int start,
		int end) throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the module certificates where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of module certificates
	 * @param end the upper bound of the range of module certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching module certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleCertificate> findByGroupId(long groupId, int start,
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

		List<ModuleCertificate> list = (List<ModuleCertificate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ModuleCertificate moduleCertificate : list) {
				if ((groupId != moduleCertificate.getGroupId())) {
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

			query.append(_SQL_SELECT_MODULECERTIFICATE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ModuleCertificateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ModuleCertificate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ModuleCertificate>(list);
				}
				else {
					list = (List<ModuleCertificate>)QueryUtil.list(q,
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
	 * Returns the first module certificate in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching module certificate
	 * @throws com.sambaash.platform.srv.NoSuchModuleCertificateException if a matching module certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCertificate findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchModuleCertificateException, SystemException {
		ModuleCertificate moduleCertificate = fetchByGroupId_First(groupId,
				orderByComparator);

		if (moduleCertificate != null) {
			return moduleCertificate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchModuleCertificateException(msg.toString());
	}

	/**
	 * Returns the first module certificate in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching module certificate, or <code>null</code> if a matching module certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCertificate fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ModuleCertificate> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last module certificate in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching module certificate
	 * @throws com.sambaash.platform.srv.NoSuchModuleCertificateException if a matching module certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCertificate findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchModuleCertificateException, SystemException {
		ModuleCertificate moduleCertificate = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (moduleCertificate != null) {
			return moduleCertificate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchModuleCertificateException(msg.toString());
	}

	/**
	 * Returns the last module certificate in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching module certificate, or <code>null</code> if a matching module certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCertificate fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ModuleCertificate> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the module certificates before and after the current module certificate in the ordered set where groupId = &#63;.
	 *
	 * @param spModuleCertificateId the primary key of the current module certificate
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next module certificate
	 * @throws com.sambaash.platform.srv.NoSuchModuleCertificateException if a module certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCertificate[] findByGroupId_PrevAndNext(
		long spModuleCertificateId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchModuleCertificateException, SystemException {
		ModuleCertificate moduleCertificate = findByPrimaryKey(spModuleCertificateId);

		Session session = null;

		try {
			session = openSession();

			ModuleCertificate[] array = new ModuleCertificateImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, moduleCertificate,
					groupId, orderByComparator, true);

			array[1] = moduleCertificate;

			array[2] = getByGroupId_PrevAndNext(session, moduleCertificate,
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

	protected ModuleCertificate getByGroupId_PrevAndNext(Session session,
		ModuleCertificate moduleCertificate, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MODULECERTIFICATE_WHERE);

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
			query.append(ModuleCertificateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(moduleCertificate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ModuleCertificate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the module certificates where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ModuleCertificate moduleCertificate : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(moduleCertificate);
		}
	}

	/**
	 * Returns the number of module certificates where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching module certificates
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

			query.append(_SQL_COUNT_MODULECERTIFICATE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "moduleCertificate.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MODULEIDANDGROUPID =
		new FinderPath(ModuleCertificateModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCertificateModelImpl.FINDER_CACHE_ENABLED,
			ModuleCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByModuleIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODULEIDANDGROUPID =
		new FinderPath(ModuleCertificateModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCertificateModelImpl.FINDER_CACHE_ENABLED,
			ModuleCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByModuleIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ModuleCertificateModelImpl.SPMODULEID_COLUMN_BITMASK |
			ModuleCertificateModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MODULEIDANDGROUPID = new FinderPath(ModuleCertificateModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCertificateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByModuleIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the module certificates where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @return the matching module certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleCertificate> findByModuleIdAndGroupId(long spModuleId,
		long groupId) throws SystemException {
		return findByModuleIdAndGroupId(spModuleId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the module certificates where spModuleId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of module certificates
	 * @param end the upper bound of the range of module certificates (not inclusive)
	 * @return the range of matching module certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleCertificate> findByModuleIdAndGroupId(long spModuleId,
		long groupId, int start, int end) throws SystemException {
		return findByModuleIdAndGroupId(spModuleId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the module certificates where spModuleId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of module certificates
	 * @param end the upper bound of the range of module certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching module certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleCertificate> findByModuleIdAndGroupId(long spModuleId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODULEIDANDGROUPID;
			finderArgs = new Object[] { spModuleId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MODULEIDANDGROUPID;
			finderArgs = new Object[] {
					spModuleId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<ModuleCertificate> list = (List<ModuleCertificate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ModuleCertificate moduleCertificate : list) {
				if ((spModuleId != moduleCertificate.getSpModuleId()) ||
						(groupId != moduleCertificate.getGroupId())) {
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

			query.append(_SQL_SELECT_MODULECERTIFICATE_WHERE);

			query.append(_FINDER_COLUMN_MODULEIDANDGROUPID_SPMODULEID_2);

			query.append(_FINDER_COLUMN_MODULEIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ModuleCertificateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spModuleId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ModuleCertificate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ModuleCertificate>(list);
				}
				else {
					list = (List<ModuleCertificate>)QueryUtil.list(q,
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
	 * Returns the first module certificate in the ordered set where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching module certificate
	 * @throws com.sambaash.platform.srv.NoSuchModuleCertificateException if a matching module certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCertificate findByModuleIdAndGroupId_First(long spModuleId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchModuleCertificateException, SystemException {
		ModuleCertificate moduleCertificate = fetchByModuleIdAndGroupId_First(spModuleId,
				groupId, orderByComparator);

		if (moduleCertificate != null) {
			return moduleCertificate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spModuleId=");
		msg.append(spModuleId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchModuleCertificateException(msg.toString());
	}

	/**
	 * Returns the first module certificate in the ordered set where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching module certificate, or <code>null</code> if a matching module certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCertificate fetchByModuleIdAndGroupId_First(long spModuleId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ModuleCertificate> list = findByModuleIdAndGroupId(spModuleId,
				groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last module certificate in the ordered set where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching module certificate
	 * @throws com.sambaash.platform.srv.NoSuchModuleCertificateException if a matching module certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCertificate findByModuleIdAndGroupId_Last(long spModuleId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchModuleCertificateException, SystemException {
		ModuleCertificate moduleCertificate = fetchByModuleIdAndGroupId_Last(spModuleId,
				groupId, orderByComparator);

		if (moduleCertificate != null) {
			return moduleCertificate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spModuleId=");
		msg.append(spModuleId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchModuleCertificateException(msg.toString());
	}

	/**
	 * Returns the last module certificate in the ordered set where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching module certificate, or <code>null</code> if a matching module certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCertificate fetchByModuleIdAndGroupId_Last(long spModuleId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByModuleIdAndGroupId(spModuleId, groupId);

		if (count == 0) {
			return null;
		}

		List<ModuleCertificate> list = findByModuleIdAndGroupId(spModuleId,
				groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the module certificates before and after the current module certificate in the ordered set where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleCertificateId the primary key of the current module certificate
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next module certificate
	 * @throws com.sambaash.platform.srv.NoSuchModuleCertificateException if a module certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCertificate[] findByModuleIdAndGroupId_PrevAndNext(
		long spModuleCertificateId, long spModuleId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchModuleCertificateException, SystemException {
		ModuleCertificate moduleCertificate = findByPrimaryKey(spModuleCertificateId);

		Session session = null;

		try {
			session = openSession();

			ModuleCertificate[] array = new ModuleCertificateImpl[3];

			array[0] = getByModuleIdAndGroupId_PrevAndNext(session,
					moduleCertificate, spModuleId, groupId, orderByComparator,
					true);

			array[1] = moduleCertificate;

			array[2] = getByModuleIdAndGroupId_PrevAndNext(session,
					moduleCertificate, spModuleId, groupId, orderByComparator,
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

	protected ModuleCertificate getByModuleIdAndGroupId_PrevAndNext(
		Session session, ModuleCertificate moduleCertificate, long spModuleId,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MODULECERTIFICATE_WHERE);

		query.append(_FINDER_COLUMN_MODULEIDANDGROUPID_SPMODULEID_2);

		query.append(_FINDER_COLUMN_MODULEIDANDGROUPID_GROUPID_2);

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
			query.append(ModuleCertificateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spModuleId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(moduleCertificate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ModuleCertificate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the module certificates where spModuleId = &#63; and groupId = &#63; from the database.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByModuleIdAndGroupId(long spModuleId, long groupId)
		throws SystemException {
		for (ModuleCertificate moduleCertificate : findByModuleIdAndGroupId(
				spModuleId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(moduleCertificate);
		}
	}

	/**
	 * Returns the number of module certificates where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @return the number of matching module certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByModuleIdAndGroupId(long spModuleId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MODULEIDANDGROUPID;

		Object[] finderArgs = new Object[] { spModuleId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MODULECERTIFICATE_WHERE);

			query.append(_FINDER_COLUMN_MODULEIDANDGROUPID_SPMODULEID_2);

			query.append(_FINDER_COLUMN_MODULEIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spModuleId);

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

	private static final String _FINDER_COLUMN_MODULEIDANDGROUPID_SPMODULEID_2 = "moduleCertificate.spModuleId = ? AND ";
	private static final String _FINDER_COLUMN_MODULEIDANDGROUPID_GROUPID_2 = "moduleCertificate.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CERTIFICATEIDANDGROUPID =
		new FinderPath(ModuleCertificateModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCertificateModelImpl.FINDER_CACHE_ENABLED,
			ModuleCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCertificateIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEIDANDGROUPID =
		new FinderPath(ModuleCertificateModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCertificateModelImpl.FINDER_CACHE_ENABLED,
			ModuleCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCertificateIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ModuleCertificateModelImpl.SPCERTIFICATETID_COLUMN_BITMASK |
			ModuleCertificateModelImpl.GROUPID_COLUMN_BITMASK |
			ModuleCertificateModelImpl.SPMODULEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CERTIFICATEIDANDGROUPID = new FinderPath(ModuleCertificateModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCertificateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCertificateIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the module certificates where spCertificatetId = &#63; and groupId = &#63;.
	 *
	 * @param spCertificatetId the sp certificatet ID
	 * @param groupId the group ID
	 * @return the matching module certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleCertificate> findByCertificateIdAndGroupId(
		long spCertificatetId, long groupId) throws SystemException {
		return findByCertificateIdAndGroupId(spCertificatetId, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the module certificates where spCertificatetId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCertificatetId the sp certificatet ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of module certificates
	 * @param end the upper bound of the range of module certificates (not inclusive)
	 * @return the range of matching module certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleCertificate> findByCertificateIdAndGroupId(
		long spCertificatetId, long groupId, int start, int end)
		throws SystemException {
		return findByCertificateIdAndGroupId(spCertificatetId, groupId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the module certificates where spCertificatetId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCertificatetId the sp certificatet ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of module certificates
	 * @param end the upper bound of the range of module certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching module certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleCertificate> findByCertificateIdAndGroupId(
		long spCertificatetId, long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEIDANDGROUPID;
			finderArgs = new Object[] { spCertificatetId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CERTIFICATEIDANDGROUPID;
			finderArgs = new Object[] {
					spCertificatetId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<ModuleCertificate> list = (List<ModuleCertificate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ModuleCertificate moduleCertificate : list) {
				if ((spCertificatetId != moduleCertificate.getSpCertificatetId()) ||
						(groupId != moduleCertificate.getGroupId())) {
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

			query.append(_SQL_SELECT_MODULECERTIFICATE_WHERE);

			query.append(_FINDER_COLUMN_CERTIFICATEIDANDGROUPID_SPCERTIFICATETID_2);

			query.append(_FINDER_COLUMN_CERTIFICATEIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ModuleCertificateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCertificatetId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ModuleCertificate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ModuleCertificate>(list);
				}
				else {
					list = (List<ModuleCertificate>)QueryUtil.list(q,
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
	 * Returns the first module certificate in the ordered set where spCertificatetId = &#63; and groupId = &#63;.
	 *
	 * @param spCertificatetId the sp certificatet ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching module certificate
	 * @throws com.sambaash.platform.srv.NoSuchModuleCertificateException if a matching module certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCertificate findByCertificateIdAndGroupId_First(
		long spCertificatetId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchModuleCertificateException, SystemException {
		ModuleCertificate moduleCertificate = fetchByCertificateIdAndGroupId_First(spCertificatetId,
				groupId, orderByComparator);

		if (moduleCertificate != null) {
			return moduleCertificate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCertificatetId=");
		msg.append(spCertificatetId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchModuleCertificateException(msg.toString());
	}

	/**
	 * Returns the first module certificate in the ordered set where spCertificatetId = &#63; and groupId = &#63;.
	 *
	 * @param spCertificatetId the sp certificatet ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching module certificate, or <code>null</code> if a matching module certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCertificate fetchByCertificateIdAndGroupId_First(
		long spCertificatetId, long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ModuleCertificate> list = findByCertificateIdAndGroupId(spCertificatetId,
				groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last module certificate in the ordered set where spCertificatetId = &#63; and groupId = &#63;.
	 *
	 * @param spCertificatetId the sp certificatet ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching module certificate
	 * @throws com.sambaash.platform.srv.NoSuchModuleCertificateException if a matching module certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCertificate findByCertificateIdAndGroupId_Last(
		long spCertificatetId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchModuleCertificateException, SystemException {
		ModuleCertificate moduleCertificate = fetchByCertificateIdAndGroupId_Last(spCertificatetId,
				groupId, orderByComparator);

		if (moduleCertificate != null) {
			return moduleCertificate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCertificatetId=");
		msg.append(spCertificatetId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchModuleCertificateException(msg.toString());
	}

	/**
	 * Returns the last module certificate in the ordered set where spCertificatetId = &#63; and groupId = &#63;.
	 *
	 * @param spCertificatetId the sp certificatet ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching module certificate, or <code>null</code> if a matching module certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCertificate fetchByCertificateIdAndGroupId_Last(
		long spCertificatetId, long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCertificateIdAndGroupId(spCertificatetId, groupId);

		if (count == 0) {
			return null;
		}

		List<ModuleCertificate> list = findByCertificateIdAndGroupId(spCertificatetId,
				groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the module certificates before and after the current module certificate in the ordered set where spCertificatetId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleCertificateId the primary key of the current module certificate
	 * @param spCertificatetId the sp certificatet ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next module certificate
	 * @throws com.sambaash.platform.srv.NoSuchModuleCertificateException if a module certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCertificate[] findByCertificateIdAndGroupId_PrevAndNext(
		long spModuleCertificateId, long spCertificatetId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchModuleCertificateException, SystemException {
		ModuleCertificate moduleCertificate = findByPrimaryKey(spModuleCertificateId);

		Session session = null;

		try {
			session = openSession();

			ModuleCertificate[] array = new ModuleCertificateImpl[3];

			array[0] = getByCertificateIdAndGroupId_PrevAndNext(session,
					moduleCertificate, spCertificatetId, groupId,
					orderByComparator, true);

			array[1] = moduleCertificate;

			array[2] = getByCertificateIdAndGroupId_PrevAndNext(session,
					moduleCertificate, spCertificatetId, groupId,
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

	protected ModuleCertificate getByCertificateIdAndGroupId_PrevAndNext(
		Session session, ModuleCertificate moduleCertificate,
		long spCertificatetId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MODULECERTIFICATE_WHERE);

		query.append(_FINDER_COLUMN_CERTIFICATEIDANDGROUPID_SPCERTIFICATETID_2);

		query.append(_FINDER_COLUMN_CERTIFICATEIDANDGROUPID_GROUPID_2);

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
			query.append(ModuleCertificateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spCertificatetId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(moduleCertificate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ModuleCertificate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the module certificates where spCertificatetId = &#63; and groupId = &#63; from the database.
	 *
	 * @param spCertificatetId the sp certificatet ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCertificateIdAndGroupId(long spCertificatetId,
		long groupId) throws SystemException {
		for (ModuleCertificate moduleCertificate : findByCertificateIdAndGroupId(
				spCertificatetId, groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(moduleCertificate);
		}
	}

	/**
	 * Returns the number of module certificates where spCertificatetId = &#63; and groupId = &#63;.
	 *
	 * @param spCertificatetId the sp certificatet ID
	 * @param groupId the group ID
	 * @return the number of matching module certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCertificateIdAndGroupId(long spCertificatetId,
		long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CERTIFICATEIDANDGROUPID;

		Object[] finderArgs = new Object[] { spCertificatetId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MODULECERTIFICATE_WHERE);

			query.append(_FINDER_COLUMN_CERTIFICATEIDANDGROUPID_SPCERTIFICATETID_2);

			query.append(_FINDER_COLUMN_CERTIFICATEIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCertificatetId);

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

	private static final String _FINDER_COLUMN_CERTIFICATEIDANDGROUPID_SPCERTIFICATETID_2 =
		"moduleCertificate.spCertificatetId = ? AND ";
	private static final String _FINDER_COLUMN_CERTIFICATEIDANDGROUPID_GROUPID_2 =
		"moduleCertificate.groupId = ?";

	public ModuleCertificatePersistenceImpl() {
		setModelClass(ModuleCertificate.class);
	}

	/**
	 * Caches the module certificate in the entity cache if it is enabled.
	 *
	 * @param moduleCertificate the module certificate
	 */
	@Override
	public void cacheResult(ModuleCertificate moduleCertificate) {
		EntityCacheUtil.putResult(ModuleCertificateModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCertificateImpl.class, moduleCertificate.getPrimaryKey(),
			moduleCertificate);

		moduleCertificate.resetOriginalValues();
	}

	/**
	 * Caches the module certificates in the entity cache if it is enabled.
	 *
	 * @param moduleCertificates the module certificates
	 */
	@Override
	public void cacheResult(List<ModuleCertificate> moduleCertificates) {
		for (ModuleCertificate moduleCertificate : moduleCertificates) {
			if (EntityCacheUtil.getResult(
						ModuleCertificateModelImpl.ENTITY_CACHE_ENABLED,
						ModuleCertificateImpl.class,
						moduleCertificate.getPrimaryKey()) == null) {
				cacheResult(moduleCertificate);
			}
			else {
				moduleCertificate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all module certificates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ModuleCertificateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ModuleCertificateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the module certificate.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ModuleCertificate moduleCertificate) {
		EntityCacheUtil.removeResult(ModuleCertificateModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCertificateImpl.class, moduleCertificate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ModuleCertificate> moduleCertificates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ModuleCertificate moduleCertificate : moduleCertificates) {
			EntityCacheUtil.removeResult(ModuleCertificateModelImpl.ENTITY_CACHE_ENABLED,
				ModuleCertificateImpl.class, moduleCertificate.getPrimaryKey());
		}
	}

	/**
	 * Creates a new module certificate with the primary key. Does not add the module certificate to the database.
	 *
	 * @param spModuleCertificateId the primary key for the new module certificate
	 * @return the new module certificate
	 */
	@Override
	public ModuleCertificate create(long spModuleCertificateId) {
		ModuleCertificate moduleCertificate = new ModuleCertificateImpl();

		moduleCertificate.setNew(true);
		moduleCertificate.setPrimaryKey(spModuleCertificateId);

		return moduleCertificate;
	}

	/**
	 * Removes the module certificate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spModuleCertificateId the primary key of the module certificate
	 * @return the module certificate that was removed
	 * @throws com.sambaash.platform.srv.NoSuchModuleCertificateException if a module certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCertificate remove(long spModuleCertificateId)
		throws NoSuchModuleCertificateException, SystemException {
		return remove((Serializable)spModuleCertificateId);
	}

	/**
	 * Removes the module certificate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the module certificate
	 * @return the module certificate that was removed
	 * @throws com.sambaash.platform.srv.NoSuchModuleCertificateException if a module certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCertificate remove(Serializable primaryKey)
		throws NoSuchModuleCertificateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ModuleCertificate moduleCertificate = (ModuleCertificate)session.get(ModuleCertificateImpl.class,
					primaryKey);

			if (moduleCertificate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchModuleCertificateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(moduleCertificate);
		}
		catch (NoSuchModuleCertificateException nsee) {
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
	protected ModuleCertificate removeImpl(ModuleCertificate moduleCertificate)
		throws SystemException {
		moduleCertificate = toUnwrappedModel(moduleCertificate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(moduleCertificate)) {
				moduleCertificate = (ModuleCertificate)session.get(ModuleCertificateImpl.class,
						moduleCertificate.getPrimaryKeyObj());
			}

			if (moduleCertificate != null) {
				session.delete(moduleCertificate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (moduleCertificate != null) {
			clearCache(moduleCertificate);
		}

		return moduleCertificate;
	}

	@Override
	public ModuleCertificate updateImpl(
		com.sambaash.platform.srv.model.ModuleCertificate moduleCertificate)
		throws SystemException {
		moduleCertificate = toUnwrappedModel(moduleCertificate);

		boolean isNew = moduleCertificate.isNew();

		ModuleCertificateModelImpl moduleCertificateModelImpl = (ModuleCertificateModelImpl)moduleCertificate;

		Session session = null;

		try {
			session = openSession();

			if (moduleCertificate.isNew()) {
				session.save(moduleCertificate);

				moduleCertificate.setNew(false);
			}
			else {
				session.merge(moduleCertificate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ModuleCertificateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((moduleCertificateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						moduleCertificateModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { moduleCertificateModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((moduleCertificateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODULEIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						moduleCertificateModelImpl.getOriginalSpModuleId(),
						moduleCertificateModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODULEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODULEIDANDGROUPID,
					args);

				args = new Object[] {
						moduleCertificateModelImpl.getSpModuleId(),
						moduleCertificateModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODULEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODULEIDANDGROUPID,
					args);
			}

			if ((moduleCertificateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						moduleCertificateModelImpl.getOriginalSpCertificatetId(),
						moduleCertificateModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEIDANDGROUPID,
					args);

				args = new Object[] {
						moduleCertificateModelImpl.getSpCertificatetId(),
						moduleCertificateModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEIDANDGROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(ModuleCertificateModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCertificateImpl.class, moduleCertificate.getPrimaryKey(),
			moduleCertificate);

		return moduleCertificate;
	}

	protected ModuleCertificate toUnwrappedModel(
		ModuleCertificate moduleCertificate) {
		if (moduleCertificate instanceof ModuleCertificateImpl) {
			return moduleCertificate;
		}

		ModuleCertificateImpl moduleCertificateImpl = new ModuleCertificateImpl();

		moduleCertificateImpl.setNew(moduleCertificate.isNew());
		moduleCertificateImpl.setPrimaryKey(moduleCertificate.getPrimaryKey());

		moduleCertificateImpl.setSpModuleCertificateId(moduleCertificate.getSpModuleCertificateId());
		moduleCertificateImpl.setGroupId(moduleCertificate.getGroupId());
		moduleCertificateImpl.setCompanyId(moduleCertificate.getCompanyId());
		moduleCertificateImpl.setUserId(moduleCertificate.getUserId());
		moduleCertificateImpl.setUserName(moduleCertificate.getUserName());
		moduleCertificateImpl.setCreateDate(moduleCertificate.getCreateDate());
		moduleCertificateImpl.setModifiedDate(moduleCertificate.getModifiedDate());
		moduleCertificateImpl.setSpModuleId(moduleCertificate.getSpModuleId());
		moduleCertificateImpl.setSpCertificatetId(moduleCertificate.getSpCertificatetId());

		return moduleCertificateImpl;
	}

	/**
	 * Returns the module certificate with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the module certificate
	 * @return the module certificate
	 * @throws com.sambaash.platform.srv.NoSuchModuleCertificateException if a module certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCertificate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModuleCertificateException, SystemException {
		ModuleCertificate moduleCertificate = fetchByPrimaryKey(primaryKey);

		if (moduleCertificate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchModuleCertificateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return moduleCertificate;
	}

	/**
	 * Returns the module certificate with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchModuleCertificateException} if it could not be found.
	 *
	 * @param spModuleCertificateId the primary key of the module certificate
	 * @return the module certificate
	 * @throws com.sambaash.platform.srv.NoSuchModuleCertificateException if a module certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCertificate findByPrimaryKey(long spModuleCertificateId)
		throws NoSuchModuleCertificateException, SystemException {
		return findByPrimaryKey((Serializable)spModuleCertificateId);
	}

	/**
	 * Returns the module certificate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the module certificate
	 * @return the module certificate, or <code>null</code> if a module certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCertificate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ModuleCertificate moduleCertificate = (ModuleCertificate)EntityCacheUtil.getResult(ModuleCertificateModelImpl.ENTITY_CACHE_ENABLED,
				ModuleCertificateImpl.class, primaryKey);

		if (moduleCertificate == _nullModuleCertificate) {
			return null;
		}

		if (moduleCertificate == null) {
			Session session = null;

			try {
				session = openSession();

				moduleCertificate = (ModuleCertificate)session.get(ModuleCertificateImpl.class,
						primaryKey);

				if (moduleCertificate != null) {
					cacheResult(moduleCertificate);
				}
				else {
					EntityCacheUtil.putResult(ModuleCertificateModelImpl.ENTITY_CACHE_ENABLED,
						ModuleCertificateImpl.class, primaryKey,
						_nullModuleCertificate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ModuleCertificateModelImpl.ENTITY_CACHE_ENABLED,
					ModuleCertificateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return moduleCertificate;
	}

	/**
	 * Returns the module certificate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spModuleCertificateId the primary key of the module certificate
	 * @return the module certificate, or <code>null</code> if a module certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCertificate fetchByPrimaryKey(long spModuleCertificateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spModuleCertificateId);
	}

	/**
	 * Returns all the module certificates.
	 *
	 * @return the module certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleCertificate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the module certificates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of module certificates
	 * @param end the upper bound of the range of module certificates (not inclusive)
	 * @return the range of module certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleCertificate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the module certificates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of module certificates
	 * @param end the upper bound of the range of module certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of module certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleCertificate> findAll(int start, int end,
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

		List<ModuleCertificate> list = (List<ModuleCertificate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MODULECERTIFICATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MODULECERTIFICATE;

				if (pagination) {
					sql = sql.concat(ModuleCertificateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ModuleCertificate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ModuleCertificate>(list);
				}
				else {
					list = (List<ModuleCertificate>)QueryUtil.list(q,
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
	 * Removes all the module certificates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ModuleCertificate moduleCertificate : findAll()) {
			remove(moduleCertificate);
		}
	}

	/**
	 * Returns the number of module certificates.
	 *
	 * @return the number of module certificates
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

				Query q = session.createQuery(_SQL_COUNT_MODULECERTIFICATE);

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
	 * Initializes the module certificate persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.ModuleCertificate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ModuleCertificate>> listenersList = new ArrayList<ModelListener<ModuleCertificate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ModuleCertificate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ModuleCertificateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MODULECERTIFICATE = "SELECT moduleCertificate FROM ModuleCertificate moduleCertificate";
	private static final String _SQL_SELECT_MODULECERTIFICATE_WHERE = "SELECT moduleCertificate FROM ModuleCertificate moduleCertificate WHERE ";
	private static final String _SQL_COUNT_MODULECERTIFICATE = "SELECT COUNT(moduleCertificate) FROM ModuleCertificate moduleCertificate";
	private static final String _SQL_COUNT_MODULECERTIFICATE_WHERE = "SELECT COUNT(moduleCertificate) FROM ModuleCertificate moduleCertificate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "moduleCertificate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ModuleCertificate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ModuleCertificate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ModuleCertificatePersistenceImpl.class);
	private static ModuleCertificate _nullModuleCertificate = new ModuleCertificateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ModuleCertificate> toCacheModel() {
				return _nullModuleCertificateCacheModel;
			}
		};

	private static CacheModel<ModuleCertificate> _nullModuleCertificateCacheModel =
		new CacheModel<ModuleCertificate>() {
			@Override
			public ModuleCertificate toEntityModel() {
				return _nullModuleCertificate;
			}
		};
}