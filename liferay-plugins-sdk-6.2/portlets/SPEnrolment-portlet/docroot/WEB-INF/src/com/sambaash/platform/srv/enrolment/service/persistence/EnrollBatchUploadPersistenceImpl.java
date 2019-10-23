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

package com.sambaash.platform.srv.enrolment.service.persistence;

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

import com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException;
import com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload;
import com.sambaash.platform.srv.enrolment.model.impl.EnrollBatchUploadImpl;
import com.sambaash.platform.srv.enrolment.model.impl.EnrollBatchUploadModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the enroll batch upload service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Baxture
 * @see EnrollBatchUploadPersistence
 * @see EnrollBatchUploadUtil
 * @generated
 */
public class EnrollBatchUploadPersistenceImpl extends BasePersistenceImpl<EnrollBatchUpload>
	implements EnrollBatchUploadPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EnrollBatchUploadUtil} to access the enroll batch upload persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EnrollBatchUploadImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EnrollBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
			EnrollBatchUploadModelImpl.FINDER_CACHE_ENABLED,
			EnrollBatchUploadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EnrollBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
			EnrollBatchUploadModelImpl.FINDER_CACHE_ENABLED,
			EnrollBatchUploadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EnrollBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
			EnrollBatchUploadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UPLOADTRANSACTID =
		new FinderPath(EnrollBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
			EnrollBatchUploadModelImpl.FINDER_CACHE_ENABLED,
			EnrollBatchUploadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUploadTransactId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPLOADTRANSACTID =
		new FinderPath(EnrollBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
			EnrollBatchUploadModelImpl.FINDER_CACHE_ENABLED,
			EnrollBatchUploadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUploadTransactId", new String[] { String.class.getName() },
			EnrollBatchUploadModelImpl.UPLOADTRANSACTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UPLOADTRANSACTID = new FinderPath(EnrollBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
			EnrollBatchUploadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUploadTransactId", new String[] { String.class.getName() });

	/**
	 * Returns all the enroll batch uploads where uploadTransactId = &#63;.
	 *
	 * @param uploadTransactId the upload transact ID
	 * @return the matching enroll batch uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnrollBatchUpload> findByUploadTransactId(
		String uploadTransactId) throws SystemException {
		return findByUploadTransactId(uploadTransactId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enroll batch uploads where uploadTransactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.enrolment.model.impl.EnrollBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uploadTransactId the upload transact ID
	 * @param start the lower bound of the range of enroll batch uploads
	 * @param end the upper bound of the range of enroll batch uploads (not inclusive)
	 * @return the range of matching enroll batch uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnrollBatchUpload> findByUploadTransactId(
		String uploadTransactId, int start, int end) throws SystemException {
		return findByUploadTransactId(uploadTransactId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the enroll batch uploads where uploadTransactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.enrolment.model.impl.EnrollBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uploadTransactId the upload transact ID
	 * @param start the lower bound of the range of enroll batch uploads
	 * @param end the upper bound of the range of enroll batch uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching enroll batch uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnrollBatchUpload> findByUploadTransactId(
		String uploadTransactId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPLOADTRANSACTID;
			finderArgs = new Object[] { uploadTransactId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UPLOADTRANSACTID;
			finderArgs = new Object[] {
					uploadTransactId,
					
					start, end, orderByComparator
				};
		}

		List<EnrollBatchUpload> list = (List<EnrollBatchUpload>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EnrollBatchUpload enrollBatchUpload : list) {
				if (!Validator.equals(uploadTransactId,
							enrollBatchUpload.getUploadTransactId())) {
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

			query.append(_SQL_SELECT_ENROLLBATCHUPLOAD_WHERE);

			boolean bindUploadTransactId = false;

			if (uploadTransactId == null) {
				query.append(_FINDER_COLUMN_UPLOADTRANSACTID_UPLOADTRANSACTID_1);
			}
			else if (uploadTransactId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UPLOADTRANSACTID_UPLOADTRANSACTID_3);
			}
			else {
				bindUploadTransactId = true;

				query.append(_FINDER_COLUMN_UPLOADTRANSACTID_UPLOADTRANSACTID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EnrollBatchUploadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUploadTransactId) {
					qPos.add(uploadTransactId);
				}

				if (!pagination) {
					list = (List<EnrollBatchUpload>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EnrollBatchUpload>(list);
				}
				else {
					list = (List<EnrollBatchUpload>)QueryUtil.list(q,
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
	 * Returns the first enroll batch upload in the ordered set where uploadTransactId = &#63;.
	 *
	 * @param uploadTransactId the upload transact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching enroll batch upload
	 * @throws com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException if a matching enroll batch upload could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollBatchUpload findByUploadTransactId_First(
		String uploadTransactId, OrderByComparator orderByComparator)
		throws NoSuchEnrollBatchUploadException, SystemException {
		EnrollBatchUpload enrollBatchUpload = fetchByUploadTransactId_First(uploadTransactId,
				orderByComparator);

		if (enrollBatchUpload != null) {
			return enrollBatchUpload;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uploadTransactId=");
		msg.append(uploadTransactId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnrollBatchUploadException(msg.toString());
	}

	/**
	 * Returns the first enroll batch upload in the ordered set where uploadTransactId = &#63;.
	 *
	 * @param uploadTransactId the upload transact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching enroll batch upload, or <code>null</code> if a matching enroll batch upload could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollBatchUpload fetchByUploadTransactId_First(
		String uploadTransactId, OrderByComparator orderByComparator)
		throws SystemException {
		List<EnrollBatchUpload> list = findByUploadTransactId(uploadTransactId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last enroll batch upload in the ordered set where uploadTransactId = &#63;.
	 *
	 * @param uploadTransactId the upload transact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching enroll batch upload
	 * @throws com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException if a matching enroll batch upload could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollBatchUpload findByUploadTransactId_Last(
		String uploadTransactId, OrderByComparator orderByComparator)
		throws NoSuchEnrollBatchUploadException, SystemException {
		EnrollBatchUpload enrollBatchUpload = fetchByUploadTransactId_Last(uploadTransactId,
				orderByComparator);

		if (enrollBatchUpload != null) {
			return enrollBatchUpload;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uploadTransactId=");
		msg.append(uploadTransactId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEnrollBatchUploadException(msg.toString());
	}

	/**
	 * Returns the last enroll batch upload in the ordered set where uploadTransactId = &#63;.
	 *
	 * @param uploadTransactId the upload transact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching enroll batch upload, or <code>null</code> if a matching enroll batch upload could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollBatchUpload fetchByUploadTransactId_Last(
		String uploadTransactId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUploadTransactId(uploadTransactId);

		if (count == 0) {
			return null;
		}

		List<EnrollBatchUpload> list = findByUploadTransactId(uploadTransactId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the enroll batch uploads before and after the current enroll batch upload in the ordered set where uploadTransactId = &#63;.
	 *
	 * @param uploadStatId the primary key of the current enroll batch upload
	 * @param uploadTransactId the upload transact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next enroll batch upload
	 * @throws com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException if a enroll batch upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollBatchUpload[] findByUploadTransactId_PrevAndNext(
		long uploadStatId, String uploadTransactId,
		OrderByComparator orderByComparator)
		throws NoSuchEnrollBatchUploadException, SystemException {
		EnrollBatchUpload enrollBatchUpload = findByPrimaryKey(uploadStatId);

		Session session = null;

		try {
			session = openSession();

			EnrollBatchUpload[] array = new EnrollBatchUploadImpl[3];

			array[0] = getByUploadTransactId_PrevAndNext(session,
					enrollBatchUpload, uploadTransactId, orderByComparator, true);

			array[1] = enrollBatchUpload;

			array[2] = getByUploadTransactId_PrevAndNext(session,
					enrollBatchUpload, uploadTransactId, orderByComparator,
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

	protected EnrollBatchUpload getByUploadTransactId_PrevAndNext(
		Session session, EnrollBatchUpload enrollBatchUpload,
		String uploadTransactId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENROLLBATCHUPLOAD_WHERE);

		boolean bindUploadTransactId = false;

		if (uploadTransactId == null) {
			query.append(_FINDER_COLUMN_UPLOADTRANSACTID_UPLOADTRANSACTID_1);
		}
		else if (uploadTransactId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UPLOADTRANSACTID_UPLOADTRANSACTID_3);
		}
		else {
			bindUploadTransactId = true;

			query.append(_FINDER_COLUMN_UPLOADTRANSACTID_UPLOADTRANSACTID_2);
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
			query.append(EnrollBatchUploadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUploadTransactId) {
			qPos.add(uploadTransactId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(enrollBatchUpload);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EnrollBatchUpload> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the enroll batch uploads where uploadTransactId = &#63; from the database.
	 *
	 * @param uploadTransactId the upload transact ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUploadTransactId(String uploadTransactId)
		throws SystemException {
		for (EnrollBatchUpload enrollBatchUpload : findByUploadTransactId(
				uploadTransactId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(enrollBatchUpload);
		}
	}

	/**
	 * Returns the number of enroll batch uploads where uploadTransactId = &#63;.
	 *
	 * @param uploadTransactId the upload transact ID
	 * @return the number of matching enroll batch uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUploadTransactId(String uploadTransactId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UPLOADTRANSACTID;

		Object[] finderArgs = new Object[] { uploadTransactId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENROLLBATCHUPLOAD_WHERE);

			boolean bindUploadTransactId = false;

			if (uploadTransactId == null) {
				query.append(_FINDER_COLUMN_UPLOADTRANSACTID_UPLOADTRANSACTID_1);
			}
			else if (uploadTransactId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UPLOADTRANSACTID_UPLOADTRANSACTID_3);
			}
			else {
				bindUploadTransactId = true;

				query.append(_FINDER_COLUMN_UPLOADTRANSACTID_UPLOADTRANSACTID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUploadTransactId) {
					qPos.add(uploadTransactId);
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

	private static final String _FINDER_COLUMN_UPLOADTRANSACTID_UPLOADTRANSACTID_1 =
		"enrollBatchUpload.uploadTransactId IS NULL";
	private static final String _FINDER_COLUMN_UPLOADTRANSACTID_UPLOADTRANSACTID_2 =
		"enrollBatchUpload.uploadTransactId = ?";
	private static final String _FINDER_COLUMN_UPLOADTRANSACTID_UPLOADTRANSACTID_3 =
		"(enrollBatchUpload.uploadTransactId IS NULL OR enrollBatchUpload.uploadTransactId = '')";

	public EnrollBatchUploadPersistenceImpl() {
		setModelClass(EnrollBatchUpload.class);
	}

	/**
	 * Caches the enroll batch upload in the entity cache if it is enabled.
	 *
	 * @param enrollBatchUpload the enroll batch upload
	 */
	@Override
	public void cacheResult(EnrollBatchUpload enrollBatchUpload) {
		EntityCacheUtil.putResult(EnrollBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
			EnrollBatchUploadImpl.class, enrollBatchUpload.getPrimaryKey(),
			enrollBatchUpload);

		enrollBatchUpload.resetOriginalValues();
	}

	/**
	 * Caches the enroll batch uploads in the entity cache if it is enabled.
	 *
	 * @param enrollBatchUploads the enroll batch uploads
	 */
	@Override
	public void cacheResult(List<EnrollBatchUpload> enrollBatchUploads) {
		for (EnrollBatchUpload enrollBatchUpload : enrollBatchUploads) {
			if (EntityCacheUtil.getResult(
						EnrollBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
						EnrollBatchUploadImpl.class,
						enrollBatchUpload.getPrimaryKey()) == null) {
				cacheResult(enrollBatchUpload);
			}
			else {
				enrollBatchUpload.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all enroll batch uploads.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EnrollBatchUploadImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EnrollBatchUploadImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the enroll batch upload.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EnrollBatchUpload enrollBatchUpload) {
		EntityCacheUtil.removeResult(EnrollBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
			EnrollBatchUploadImpl.class, enrollBatchUpload.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EnrollBatchUpload> enrollBatchUploads) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EnrollBatchUpload enrollBatchUpload : enrollBatchUploads) {
			EntityCacheUtil.removeResult(EnrollBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
				EnrollBatchUploadImpl.class, enrollBatchUpload.getPrimaryKey());
		}
	}

	/**
	 * Creates a new enroll batch upload with the primary key. Does not add the enroll batch upload to the database.
	 *
	 * @param uploadStatId the primary key for the new enroll batch upload
	 * @return the new enroll batch upload
	 */
	@Override
	public EnrollBatchUpload create(long uploadStatId) {
		EnrollBatchUpload enrollBatchUpload = new EnrollBatchUploadImpl();

		enrollBatchUpload.setNew(true);
		enrollBatchUpload.setPrimaryKey(uploadStatId);

		return enrollBatchUpload;
	}

	/**
	 * Removes the enroll batch upload with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param uploadStatId the primary key of the enroll batch upload
	 * @return the enroll batch upload that was removed
	 * @throws com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException if a enroll batch upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollBatchUpload remove(long uploadStatId)
		throws NoSuchEnrollBatchUploadException, SystemException {
		return remove((Serializable)uploadStatId);
	}

	/**
	 * Removes the enroll batch upload with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the enroll batch upload
	 * @return the enroll batch upload that was removed
	 * @throws com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException if a enroll batch upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollBatchUpload remove(Serializable primaryKey)
		throws NoSuchEnrollBatchUploadException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EnrollBatchUpload enrollBatchUpload = (EnrollBatchUpload)session.get(EnrollBatchUploadImpl.class,
					primaryKey);

			if (enrollBatchUpload == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEnrollBatchUploadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(enrollBatchUpload);
		}
		catch (NoSuchEnrollBatchUploadException nsee) {
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
	protected EnrollBatchUpload removeImpl(EnrollBatchUpload enrollBatchUpload)
		throws SystemException {
		enrollBatchUpload = toUnwrappedModel(enrollBatchUpload);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(enrollBatchUpload)) {
				enrollBatchUpload = (EnrollBatchUpload)session.get(EnrollBatchUploadImpl.class,
						enrollBatchUpload.getPrimaryKeyObj());
			}

			if (enrollBatchUpload != null) {
				session.delete(enrollBatchUpload);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (enrollBatchUpload != null) {
			clearCache(enrollBatchUpload);
		}

		return enrollBatchUpload;
	}

	@Override
	public EnrollBatchUpload updateImpl(
		com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload enrollBatchUpload)
		throws SystemException {
		enrollBatchUpload = toUnwrappedModel(enrollBatchUpload);

		boolean isNew = enrollBatchUpload.isNew();

		EnrollBatchUploadModelImpl enrollBatchUploadModelImpl = (EnrollBatchUploadModelImpl)enrollBatchUpload;

		Session session = null;

		try {
			session = openSession();

			if (enrollBatchUpload.isNew()) {
				session.save(enrollBatchUpload);

				enrollBatchUpload.setNew(false);
			}
			else {
				session.merge(enrollBatchUpload);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EnrollBatchUploadModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((enrollBatchUploadModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPLOADTRANSACTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enrollBatchUploadModelImpl.getOriginalUploadTransactId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UPLOADTRANSACTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPLOADTRANSACTID,
					args);

				args = new Object[] {
						enrollBatchUploadModelImpl.getUploadTransactId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UPLOADTRANSACTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPLOADTRANSACTID,
					args);
			}
		}

		EntityCacheUtil.putResult(EnrollBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
			EnrollBatchUploadImpl.class, enrollBatchUpload.getPrimaryKey(),
			enrollBatchUpload);

		return enrollBatchUpload;
	}

	protected EnrollBatchUpload toUnwrappedModel(
		EnrollBatchUpload enrollBatchUpload) {
		if (enrollBatchUpload instanceof EnrollBatchUploadImpl) {
			return enrollBatchUpload;
		}

		EnrollBatchUploadImpl enrollBatchUploadImpl = new EnrollBatchUploadImpl();

		enrollBatchUploadImpl.setNew(enrollBatchUpload.isNew());
		enrollBatchUploadImpl.setPrimaryKey(enrollBatchUpload.getPrimaryKey());

		enrollBatchUploadImpl.setUploadStatId(enrollBatchUpload.getUploadStatId());
		enrollBatchUploadImpl.setUploadTransactId(enrollBatchUpload.getUploadTransactId());
		enrollBatchUploadImpl.setErrorField(enrollBatchUpload.getErrorField());
		enrollBatchUploadImpl.setErrorReason(enrollBatchUpload.getErrorReason());
		enrollBatchUploadImpl.setUploadedRecId(enrollBatchUpload.getUploadedRecId());
		enrollBatchUploadImpl.setUserId(enrollBatchUpload.getUserId());
		enrollBatchUploadImpl.setCreateDate(enrollBatchUpload.getCreateDate());
		enrollBatchUploadImpl.setModifiedDate(enrollBatchUpload.getModifiedDate());

		return enrollBatchUploadImpl;
	}

	/**
	 * Returns the enroll batch upload with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the enroll batch upload
	 * @return the enroll batch upload
	 * @throws com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException if a enroll batch upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollBatchUpload findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEnrollBatchUploadException, SystemException {
		EnrollBatchUpload enrollBatchUpload = fetchByPrimaryKey(primaryKey);

		if (enrollBatchUpload == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEnrollBatchUploadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return enrollBatchUpload;
	}

	/**
	 * Returns the enroll batch upload with the primary key or throws a {@link com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException} if it could not be found.
	 *
	 * @param uploadStatId the primary key of the enroll batch upload
	 * @return the enroll batch upload
	 * @throws com.sambaash.platform.srv.enrolment.NoSuchEnrollBatchUploadException if a enroll batch upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollBatchUpload findByPrimaryKey(long uploadStatId)
		throws NoSuchEnrollBatchUploadException, SystemException {
		return findByPrimaryKey((Serializable)uploadStatId);
	}

	/**
	 * Returns the enroll batch upload with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the enroll batch upload
	 * @return the enroll batch upload, or <code>null</code> if a enroll batch upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollBatchUpload fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EnrollBatchUpload enrollBatchUpload = (EnrollBatchUpload)EntityCacheUtil.getResult(EnrollBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
				EnrollBatchUploadImpl.class, primaryKey);

		if (enrollBatchUpload == _nullEnrollBatchUpload) {
			return null;
		}

		if (enrollBatchUpload == null) {
			Session session = null;

			try {
				session = openSession();

				enrollBatchUpload = (EnrollBatchUpload)session.get(EnrollBatchUploadImpl.class,
						primaryKey);

				if (enrollBatchUpload != null) {
					cacheResult(enrollBatchUpload);
				}
				else {
					EntityCacheUtil.putResult(EnrollBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
						EnrollBatchUploadImpl.class, primaryKey,
						_nullEnrollBatchUpload);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EnrollBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
					EnrollBatchUploadImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return enrollBatchUpload;
	}

	/**
	 * Returns the enroll batch upload with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param uploadStatId the primary key of the enroll batch upload
	 * @return the enroll batch upload, or <code>null</code> if a enroll batch upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollBatchUpload fetchByPrimaryKey(long uploadStatId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)uploadStatId);
	}

	/**
	 * Returns all the enroll batch uploads.
	 *
	 * @return the enroll batch uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnrollBatchUpload> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enroll batch uploads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.enrolment.model.impl.EnrollBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of enroll batch uploads
	 * @param end the upper bound of the range of enroll batch uploads (not inclusive)
	 * @return the range of enroll batch uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnrollBatchUpload> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the enroll batch uploads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.enrolment.model.impl.EnrollBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of enroll batch uploads
	 * @param end the upper bound of the range of enroll batch uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of enroll batch uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnrollBatchUpload> findAll(int start, int end,
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

		List<EnrollBatchUpload> list = (List<EnrollBatchUpload>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ENROLLBATCHUPLOAD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ENROLLBATCHUPLOAD;

				if (pagination) {
					sql = sql.concat(EnrollBatchUploadModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EnrollBatchUpload>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EnrollBatchUpload>(list);
				}
				else {
					list = (List<EnrollBatchUpload>)QueryUtil.list(q,
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
	 * Removes all the enroll batch uploads from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EnrollBatchUpload enrollBatchUpload : findAll()) {
			remove(enrollBatchUpload);
		}
	}

	/**
	 * Returns the number of enroll batch uploads.
	 *
	 * @return the number of enroll batch uploads
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

				Query q = session.createQuery(_SQL_COUNT_ENROLLBATCHUPLOAD);

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
	 * Initializes the enroll batch upload persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EnrollBatchUpload>> listenersList = new ArrayList<ModelListener<EnrollBatchUpload>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EnrollBatchUpload>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EnrollBatchUploadImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ENROLLBATCHUPLOAD = "SELECT enrollBatchUpload FROM EnrollBatchUpload enrollBatchUpload";
	private static final String _SQL_SELECT_ENROLLBATCHUPLOAD_WHERE = "SELECT enrollBatchUpload FROM EnrollBatchUpload enrollBatchUpload WHERE ";
	private static final String _SQL_COUNT_ENROLLBATCHUPLOAD = "SELECT COUNT(enrollBatchUpload) FROM EnrollBatchUpload enrollBatchUpload";
	private static final String _SQL_COUNT_ENROLLBATCHUPLOAD_WHERE = "SELECT COUNT(enrollBatchUpload) FROM EnrollBatchUpload enrollBatchUpload WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "enrollBatchUpload.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EnrollBatchUpload exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EnrollBatchUpload exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EnrollBatchUploadPersistenceImpl.class);
	private static EnrollBatchUpload _nullEnrollBatchUpload = new EnrollBatchUploadImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EnrollBatchUpload> toCacheModel() {
				return _nullEnrollBatchUploadCacheModel;
			}
		};

	private static CacheModel<EnrollBatchUpload> _nullEnrollBatchUploadCacheModel =
		new CacheModel<EnrollBatchUpload>() {
			@Override
			public EnrollBatchUpload toEntityModel() {
				return _nullEnrollBatchUpload;
			}
		};
}