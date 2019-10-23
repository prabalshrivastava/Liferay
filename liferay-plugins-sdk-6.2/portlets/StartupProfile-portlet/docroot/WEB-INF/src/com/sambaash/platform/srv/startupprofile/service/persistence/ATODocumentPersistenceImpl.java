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

import com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException;
import com.sambaash.platform.srv.startupprofile.model.ATODocument;
import com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentImpl;
import com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the a t o document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see ATODocumentPersistence
 * @see ATODocumentUtil
 * @generated
 */
public class ATODocumentPersistenceImpl extends BasePersistenceImpl<ATODocument>
	implements ATODocumentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ATODocumentUtil} to access the a t o document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ATODocumentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ATODocumentModelImpl.ENTITY_CACHE_ENABLED,
			ATODocumentModelImpl.FINDER_CACHE_ENABLED, ATODocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ATODocumentModelImpl.ENTITY_CACHE_ENABLED,
			ATODocumentModelImpl.FINDER_CACHE_ENABLED, ATODocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ATODocumentModelImpl.ENTITY_CACHE_ENABLED,
			ATODocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ATODocumentModelImpl.ENTITY_CACHE_ENABLED,
			ATODocumentModelImpl.FINDER_CACHE_ENABLED, ATODocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ATODocumentModelImpl.ENTITY_CACHE_ENABLED,
			ATODocumentModelImpl.FINDER_CACHE_ENABLED, ATODocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ATODocumentModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ATODocumentModelImpl.ENTITY_CACHE_ENABLED,
			ATODocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the a t o documents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching a t o documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ATODocument> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the a t o documents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of a t o documents
	 * @param end the upper bound of the range of a t o documents (not inclusive)
	 * @return the range of matching a t o documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ATODocument> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the a t o documents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of a t o documents
	 * @param end the upper bound of the range of a t o documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching a t o documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ATODocument> findByUuid(String uuid, int start, int end,
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

		List<ATODocument> list = (List<ATODocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ATODocument atoDocument : list) {
				if (!Validator.equals(uuid, atoDocument.getUuid())) {
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

			query.append(_SQL_SELECT_ATODOCUMENT_WHERE);

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
				query.append(ATODocumentModelImpl.ORDER_BY_JPQL);
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
					list = (List<ATODocument>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ATODocument>(list);
				}
				else {
					list = (List<ATODocument>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first a t o document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a t o document
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a matching a t o document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchATODocumentException, SystemException {
		ATODocument atoDocument = fetchByUuid_First(uuid, orderByComparator);

		if (atoDocument != null) {
			return atoDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchATODocumentException(msg.toString());
	}

	/**
	 * Returns the first a t o document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a t o document, or <code>null</code> if a matching a t o document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ATODocument> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last a t o document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a t o document
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a matching a t o document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchATODocumentException, SystemException {
		ATODocument atoDocument = fetchByUuid_Last(uuid, orderByComparator);

		if (atoDocument != null) {
			return atoDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchATODocumentException(msg.toString());
	}

	/**
	 * Returns the last a t o document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a t o document, or <code>null</code> if a matching a t o document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ATODocument> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the a t o documents before and after the current a t o document in the ordered set where uuid = &#63;.
	 *
	 * @param atoDocumentId the primary key of the current a t o document
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next a t o document
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a a t o document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument[] findByUuid_PrevAndNext(long atoDocumentId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchATODocumentException, SystemException {
		ATODocument atoDocument = findByPrimaryKey(atoDocumentId);

		Session session = null;

		try {
			session = openSession();

			ATODocument[] array = new ATODocumentImpl[3];

			array[0] = getByUuid_PrevAndNext(session, atoDocument, uuid,
					orderByComparator, true);

			array[1] = atoDocument;

			array[2] = getByUuid_PrevAndNext(session, atoDocument, uuid,
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

	protected ATODocument getByUuid_PrevAndNext(Session session,
		ATODocument atoDocument, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATODOCUMENT_WHERE);

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
			query.append(ATODocumentModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(atoDocument);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ATODocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the a t o documents where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ATODocument atoDocument : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(atoDocument);
		}
	}

	/**
	 * Returns the number of a t o documents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching a t o documents
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

			query.append(_SQL_COUNT_ATODOCUMENT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "atoDocument.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "atoDocument.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(atoDocument.uuid IS NULL OR atoDocument.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DOCUMENTTYPE =
		new FinderPath(ATODocumentModelImpl.ENTITY_CACHE_ENABLED,
			ATODocumentModelImpl.FINDER_CACHE_ENABLED, ATODocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocumentType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENTTYPE =
		new FinderPath(ATODocumentModelImpl.ENTITY_CACHE_ENABLED,
			ATODocumentModelImpl.FINDER_CACHE_ENABLED, ATODocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDocumentType",
			new String[] { String.class.getName() },
			ATODocumentModelImpl.DOCUMENTTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DOCUMENTTYPE = new FinderPath(ATODocumentModelImpl.ENTITY_CACHE_ENABLED,
			ATODocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocumentType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the a t o documents where documentType = &#63;.
	 *
	 * @param documentType the document type
	 * @return the matching a t o documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ATODocument> findByDocumentType(String documentType)
		throws SystemException {
		return findByDocumentType(documentType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the a t o documents where documentType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documentType the document type
	 * @param start the lower bound of the range of a t o documents
	 * @param end the upper bound of the range of a t o documents (not inclusive)
	 * @return the range of matching a t o documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ATODocument> findByDocumentType(String documentType, int start,
		int end) throws SystemException {
		return findByDocumentType(documentType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the a t o documents where documentType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documentType the document type
	 * @param start the lower bound of the range of a t o documents
	 * @param end the upper bound of the range of a t o documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching a t o documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ATODocument> findByDocumentType(String documentType, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENTTYPE;
			finderArgs = new Object[] { documentType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DOCUMENTTYPE;
			finderArgs = new Object[] {
					documentType,
					
					start, end, orderByComparator
				};
		}

		List<ATODocument> list = (List<ATODocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ATODocument atoDocument : list) {
				if (!Validator.equals(documentType,
							atoDocument.getDocumentType())) {
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

			query.append(_SQL_SELECT_ATODOCUMENT_WHERE);

			boolean bindDocumentType = false;

			if (documentType == null) {
				query.append(_FINDER_COLUMN_DOCUMENTTYPE_DOCUMENTTYPE_1);
			}
			else if (documentType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DOCUMENTTYPE_DOCUMENTTYPE_3);
			}
			else {
				bindDocumentType = true;

				query.append(_FINDER_COLUMN_DOCUMENTTYPE_DOCUMENTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ATODocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDocumentType) {
					qPos.add(documentType);
				}

				if (!pagination) {
					list = (List<ATODocument>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ATODocument>(list);
				}
				else {
					list = (List<ATODocument>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first a t o document in the ordered set where documentType = &#63;.
	 *
	 * @param documentType the document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a t o document
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a matching a t o document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument findByDocumentType_First(String documentType,
		OrderByComparator orderByComparator)
		throws NoSuchATODocumentException, SystemException {
		ATODocument atoDocument = fetchByDocumentType_First(documentType,
				orderByComparator);

		if (atoDocument != null) {
			return atoDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("documentType=");
		msg.append(documentType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchATODocumentException(msg.toString());
	}

	/**
	 * Returns the first a t o document in the ordered set where documentType = &#63;.
	 *
	 * @param documentType the document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a t o document, or <code>null</code> if a matching a t o document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument fetchByDocumentType_First(String documentType,
		OrderByComparator orderByComparator) throws SystemException {
		List<ATODocument> list = findByDocumentType(documentType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last a t o document in the ordered set where documentType = &#63;.
	 *
	 * @param documentType the document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a t o document
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a matching a t o document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument findByDocumentType_Last(String documentType,
		OrderByComparator orderByComparator)
		throws NoSuchATODocumentException, SystemException {
		ATODocument atoDocument = fetchByDocumentType_Last(documentType,
				orderByComparator);

		if (atoDocument != null) {
			return atoDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("documentType=");
		msg.append(documentType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchATODocumentException(msg.toString());
	}

	/**
	 * Returns the last a t o document in the ordered set where documentType = &#63;.
	 *
	 * @param documentType the document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a t o document, or <code>null</code> if a matching a t o document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument fetchByDocumentType_Last(String documentType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDocumentType(documentType);

		if (count == 0) {
			return null;
		}

		List<ATODocument> list = findByDocumentType(documentType, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the a t o documents before and after the current a t o document in the ordered set where documentType = &#63;.
	 *
	 * @param atoDocumentId the primary key of the current a t o document
	 * @param documentType the document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next a t o document
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a a t o document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument[] findByDocumentType_PrevAndNext(long atoDocumentId,
		String documentType, OrderByComparator orderByComparator)
		throws NoSuchATODocumentException, SystemException {
		ATODocument atoDocument = findByPrimaryKey(atoDocumentId);

		Session session = null;

		try {
			session = openSession();

			ATODocument[] array = new ATODocumentImpl[3];

			array[0] = getByDocumentType_PrevAndNext(session, atoDocument,
					documentType, orderByComparator, true);

			array[1] = atoDocument;

			array[2] = getByDocumentType_PrevAndNext(session, atoDocument,
					documentType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ATODocument getByDocumentType_PrevAndNext(Session session,
		ATODocument atoDocument, String documentType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATODOCUMENT_WHERE);

		boolean bindDocumentType = false;

		if (documentType == null) {
			query.append(_FINDER_COLUMN_DOCUMENTTYPE_DOCUMENTTYPE_1);
		}
		else if (documentType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DOCUMENTTYPE_DOCUMENTTYPE_3);
		}
		else {
			bindDocumentType = true;

			query.append(_FINDER_COLUMN_DOCUMENTTYPE_DOCUMENTTYPE_2);
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
			query.append(ATODocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDocumentType) {
			qPos.add(documentType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(atoDocument);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ATODocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the a t o documents where documentType = &#63; from the database.
	 *
	 * @param documentType the document type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDocumentType(String documentType)
		throws SystemException {
		for (ATODocument atoDocument : findByDocumentType(documentType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(atoDocument);
		}
	}

	/**
	 * Returns the number of a t o documents where documentType = &#63;.
	 *
	 * @param documentType the document type
	 * @return the number of matching a t o documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDocumentType(String documentType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DOCUMENTTYPE;

		Object[] finderArgs = new Object[] { documentType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ATODOCUMENT_WHERE);

			boolean bindDocumentType = false;

			if (documentType == null) {
				query.append(_FINDER_COLUMN_DOCUMENTTYPE_DOCUMENTTYPE_1);
			}
			else if (documentType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DOCUMENTTYPE_DOCUMENTTYPE_3);
			}
			else {
				bindDocumentType = true;

				query.append(_FINDER_COLUMN_DOCUMENTTYPE_DOCUMENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDocumentType) {
					qPos.add(documentType);
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

	private static final String _FINDER_COLUMN_DOCUMENTTYPE_DOCUMENTTYPE_1 = "atoDocument.documentType IS NULL";
	private static final String _FINDER_COLUMN_DOCUMENTTYPE_DOCUMENTTYPE_2 = "atoDocument.documentType = ?";
	private static final String _FINDER_COLUMN_DOCUMENTTYPE_DOCUMENTTYPE_3 = "(atoDocument.documentType IS NULL OR atoDocument.documentType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(ATODocumentModelImpl.ENTITY_CACHE_ENABLED,
			ATODocumentModelImpl.FINDER_CACHE_ENABLED, ATODocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(ATODocumentModelImpl.ENTITY_CACHE_ENABLED,
			ATODocumentModelImpl.FINDER_CACHE_ENABLED, ATODocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrganizationId",
			new String[] { Long.class.getName() },
			ATODocumentModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONID = new FinderPath(ATODocumentModelImpl.ENTITY_CACHE_ENABLED,
			ATODocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganizationId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the a t o documents where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching a t o documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ATODocument> findByOrganizationId(long organizationId)
		throws SystemException {
		return findByOrganizationId(organizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the a t o documents where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of a t o documents
	 * @param end the upper bound of the range of a t o documents (not inclusive)
	 * @return the range of matching a t o documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ATODocument> findByOrganizationId(long organizationId,
		int start, int end) throws SystemException {
		return findByOrganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the a t o documents where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of a t o documents
	 * @param end the upper bound of the range of a t o documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching a t o documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ATODocument> findByOrganizationId(long organizationId,
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

		List<ATODocument> list = (List<ATODocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ATODocument atoDocument : list) {
				if ((organizationId != atoDocument.getOrganizationId())) {
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

			query.append(_SQL_SELECT_ATODOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ATODocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (!pagination) {
					list = (List<ATODocument>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ATODocument>(list);
				}
				else {
					list = (List<ATODocument>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first a t o document in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a t o document
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a matching a t o document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument findByOrganizationId_First(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchATODocumentException, SystemException {
		ATODocument atoDocument = fetchByOrganizationId_First(organizationId,
				orderByComparator);

		if (atoDocument != null) {
			return atoDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchATODocumentException(msg.toString());
	}

	/**
	 * Returns the first a t o document in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a t o document, or <code>null</code> if a matching a t o document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument fetchByOrganizationId_First(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ATODocument> list = findByOrganizationId(organizationId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last a t o document in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a t o document
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a matching a t o document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument findByOrganizationId_Last(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchATODocumentException, SystemException {
		ATODocument atoDocument = fetchByOrganizationId_Last(organizationId,
				orderByComparator);

		if (atoDocument != null) {
			return atoDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchATODocumentException(msg.toString());
	}

	/**
	 * Returns the last a t o document in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a t o document, or <code>null</code> if a matching a t o document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument fetchByOrganizationId_Last(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOrganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<ATODocument> list = findByOrganizationId(organizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the a t o documents before and after the current a t o document in the ordered set where organizationId = &#63;.
	 *
	 * @param atoDocumentId the primary key of the current a t o document
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next a t o document
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a a t o document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument[] findByOrganizationId_PrevAndNext(long atoDocumentId,
		long organizationId, OrderByComparator orderByComparator)
		throws NoSuchATODocumentException, SystemException {
		ATODocument atoDocument = findByPrimaryKey(atoDocumentId);

		Session session = null;

		try {
			session = openSession();

			ATODocument[] array = new ATODocumentImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(session, atoDocument,
					organizationId, orderByComparator, true);

			array[1] = atoDocument;

			array[2] = getByOrganizationId_PrevAndNext(session, atoDocument,
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

	protected ATODocument getByOrganizationId_PrevAndNext(Session session,
		ATODocument atoDocument, long organizationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATODOCUMENT_WHERE);

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
			query.append(ATODocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(atoDocument);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ATODocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the a t o documents where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganizationId(long organizationId)
		throws SystemException {
		for (ATODocument atoDocument : findByOrganizationId(organizationId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(atoDocument);
		}
	}

	/**
	 * Returns the number of a t o documents where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching a t o documents
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

			query.append(_SQL_COUNT_ATODOCUMENT_WHERE);

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

	private static final String _FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2 = "atoDocument.organizationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONANDDOCUMENTTYPE =
		new FinderPath(ATODocumentModelImpl.ENTITY_CACHE_ENABLED,
			ATODocumentModelImpl.FINDER_CACHE_ENABLED, ATODocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOrganizationAndDocumentType",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDDOCUMENTTYPE =
		new FinderPath(ATODocumentModelImpl.ENTITY_CACHE_ENABLED,
			ATODocumentModelImpl.FINDER_CACHE_ENABLED, ATODocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByOrganizationAndDocumentType",
			new String[] { Long.class.getName(), String.class.getName() },
			ATODocumentModelImpl.ORGANIZATIONID_COLUMN_BITMASK |
			ATODocumentModelImpl.DOCUMENTTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONANDDOCUMENTTYPE =
		new FinderPath(ATODocumentModelImpl.ENTITY_CACHE_ENABLED,
			ATODocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOrganizationAndDocumentType",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the a t o documents where organizationId = &#63; and documentType = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param documentType the document type
	 * @return the matching a t o documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ATODocument> findByOrganizationAndDocumentType(
		long organizationId, String documentType) throws SystemException {
		return findByOrganizationAndDocumentType(organizationId, documentType,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the a t o documents where organizationId = &#63; and documentType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param documentType the document type
	 * @param start the lower bound of the range of a t o documents
	 * @param end the upper bound of the range of a t o documents (not inclusive)
	 * @return the range of matching a t o documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ATODocument> findByOrganizationAndDocumentType(
		long organizationId, String documentType, int start, int end)
		throws SystemException {
		return findByOrganizationAndDocumentType(organizationId, documentType,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the a t o documents where organizationId = &#63; and documentType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param documentType the document type
	 * @param start the lower bound of the range of a t o documents
	 * @param end the upper bound of the range of a t o documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching a t o documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ATODocument> findByOrganizationAndDocumentType(
		long organizationId, String documentType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDDOCUMENTTYPE;
			finderArgs = new Object[] { organizationId, documentType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONANDDOCUMENTTYPE;
			finderArgs = new Object[] {
					organizationId, documentType,
					
					start, end, orderByComparator
				};
		}

		List<ATODocument> list = (List<ATODocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ATODocument atoDocument : list) {
				if ((organizationId != atoDocument.getOrganizationId()) ||
						!Validator.equals(documentType,
							atoDocument.getDocumentType())) {
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

			query.append(_SQL_SELECT_ATODOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONANDDOCUMENTTYPE_ORGANIZATIONID_2);

			boolean bindDocumentType = false;

			if (documentType == null) {
				query.append(_FINDER_COLUMN_ORGANIZATIONANDDOCUMENTTYPE_DOCUMENTTYPE_1);
			}
			else if (documentType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ORGANIZATIONANDDOCUMENTTYPE_DOCUMENTTYPE_3);
			}
			else {
				bindDocumentType = true;

				query.append(_FINDER_COLUMN_ORGANIZATIONANDDOCUMENTTYPE_DOCUMENTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ATODocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (bindDocumentType) {
					qPos.add(documentType);
				}

				if (!pagination) {
					list = (List<ATODocument>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ATODocument>(list);
				}
				else {
					list = (List<ATODocument>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first a t o document in the ordered set where organizationId = &#63; and documentType = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param documentType the document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a t o document
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a matching a t o document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument findByOrganizationAndDocumentType_First(
		long organizationId, String documentType,
		OrderByComparator orderByComparator)
		throws NoSuchATODocumentException, SystemException {
		ATODocument atoDocument = fetchByOrganizationAndDocumentType_First(organizationId,
				documentType, orderByComparator);

		if (atoDocument != null) {
			return atoDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(", documentType=");
		msg.append(documentType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchATODocumentException(msg.toString());
	}

	/**
	 * Returns the first a t o document in the ordered set where organizationId = &#63; and documentType = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param documentType the document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a t o document, or <code>null</code> if a matching a t o document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument fetchByOrganizationAndDocumentType_First(
		long organizationId, String documentType,
		OrderByComparator orderByComparator) throws SystemException {
		List<ATODocument> list = findByOrganizationAndDocumentType(organizationId,
				documentType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last a t o document in the ordered set where organizationId = &#63; and documentType = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param documentType the document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a t o document
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a matching a t o document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument findByOrganizationAndDocumentType_Last(
		long organizationId, String documentType,
		OrderByComparator orderByComparator)
		throws NoSuchATODocumentException, SystemException {
		ATODocument atoDocument = fetchByOrganizationAndDocumentType_Last(organizationId,
				documentType, orderByComparator);

		if (atoDocument != null) {
			return atoDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(", documentType=");
		msg.append(documentType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchATODocumentException(msg.toString());
	}

	/**
	 * Returns the last a t o document in the ordered set where organizationId = &#63; and documentType = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param documentType the document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a t o document, or <code>null</code> if a matching a t o document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument fetchByOrganizationAndDocumentType_Last(
		long organizationId, String documentType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOrganizationAndDocumentType(organizationId,
				documentType);

		if (count == 0) {
			return null;
		}

		List<ATODocument> list = findByOrganizationAndDocumentType(organizationId,
				documentType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the a t o documents before and after the current a t o document in the ordered set where organizationId = &#63; and documentType = &#63;.
	 *
	 * @param atoDocumentId the primary key of the current a t o document
	 * @param organizationId the organization ID
	 * @param documentType the document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next a t o document
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a a t o document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument[] findByOrganizationAndDocumentType_PrevAndNext(
		long atoDocumentId, long organizationId, String documentType,
		OrderByComparator orderByComparator)
		throws NoSuchATODocumentException, SystemException {
		ATODocument atoDocument = findByPrimaryKey(atoDocumentId);

		Session session = null;

		try {
			session = openSession();

			ATODocument[] array = new ATODocumentImpl[3];

			array[0] = getByOrganizationAndDocumentType_PrevAndNext(session,
					atoDocument, organizationId, documentType,
					orderByComparator, true);

			array[1] = atoDocument;

			array[2] = getByOrganizationAndDocumentType_PrevAndNext(session,
					atoDocument, organizationId, documentType,
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

	protected ATODocument getByOrganizationAndDocumentType_PrevAndNext(
		Session session, ATODocument atoDocument, long organizationId,
		String documentType, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATODOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATIONANDDOCUMENTTYPE_ORGANIZATIONID_2);

		boolean bindDocumentType = false;

		if (documentType == null) {
			query.append(_FINDER_COLUMN_ORGANIZATIONANDDOCUMENTTYPE_DOCUMENTTYPE_1);
		}
		else if (documentType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ORGANIZATIONANDDOCUMENTTYPE_DOCUMENTTYPE_3);
		}
		else {
			bindDocumentType = true;

			query.append(_FINDER_COLUMN_ORGANIZATIONANDDOCUMENTTYPE_DOCUMENTTYPE_2);
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
			query.append(ATODocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (bindDocumentType) {
			qPos.add(documentType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(atoDocument);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ATODocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the a t o documents where organizationId = &#63; and documentType = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param documentType the document type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganizationAndDocumentType(long organizationId,
		String documentType) throws SystemException {
		for (ATODocument atoDocument : findByOrganizationAndDocumentType(
				organizationId, documentType, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(atoDocument);
		}
	}

	/**
	 * Returns the number of a t o documents where organizationId = &#63; and documentType = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param documentType the document type
	 * @return the number of matching a t o documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrganizationAndDocumentType(long organizationId,
		String documentType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATIONANDDOCUMENTTYPE;

		Object[] finderArgs = new Object[] { organizationId, documentType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ATODOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONANDDOCUMENTTYPE_ORGANIZATIONID_2);

			boolean bindDocumentType = false;

			if (documentType == null) {
				query.append(_FINDER_COLUMN_ORGANIZATIONANDDOCUMENTTYPE_DOCUMENTTYPE_1);
			}
			else if (documentType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ORGANIZATIONANDDOCUMENTTYPE_DOCUMENTTYPE_3);
			}
			else {
				bindDocumentType = true;

				query.append(_FINDER_COLUMN_ORGANIZATIONANDDOCUMENTTYPE_DOCUMENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (bindDocumentType) {
					qPos.add(documentType);
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

	private static final String _FINDER_COLUMN_ORGANIZATIONANDDOCUMENTTYPE_ORGANIZATIONID_2 =
		"atoDocument.organizationId = ? AND ";
	private static final String _FINDER_COLUMN_ORGANIZATIONANDDOCUMENTTYPE_DOCUMENTTYPE_1 =
		"atoDocument.documentType IS NULL";
	private static final String _FINDER_COLUMN_ORGANIZATIONANDDOCUMENTTYPE_DOCUMENTTYPE_2 =
		"atoDocument.documentType = ?";
	private static final String _FINDER_COLUMN_ORGANIZATIONANDDOCUMENTTYPE_DOCUMENTTYPE_3 =
		"(atoDocument.documentType IS NULL OR atoDocument.documentType = '')";

	public ATODocumentPersistenceImpl() {
		setModelClass(ATODocument.class);
	}

	/**
	 * Caches the a t o document in the entity cache if it is enabled.
	 *
	 * @param atoDocument the a t o document
	 */
	@Override
	public void cacheResult(ATODocument atoDocument) {
		EntityCacheUtil.putResult(ATODocumentModelImpl.ENTITY_CACHE_ENABLED,
			ATODocumentImpl.class, atoDocument.getPrimaryKey(), atoDocument);

		atoDocument.resetOriginalValues();
	}

	/**
	 * Caches the a t o documents in the entity cache if it is enabled.
	 *
	 * @param atoDocuments the a t o documents
	 */
	@Override
	public void cacheResult(List<ATODocument> atoDocuments) {
		for (ATODocument atoDocument : atoDocuments) {
			if (EntityCacheUtil.getResult(
						ATODocumentModelImpl.ENTITY_CACHE_ENABLED,
						ATODocumentImpl.class, atoDocument.getPrimaryKey()) == null) {
				cacheResult(atoDocument);
			}
			else {
				atoDocument.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all a t o documents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ATODocumentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ATODocumentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the a t o document.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ATODocument atoDocument) {
		EntityCacheUtil.removeResult(ATODocumentModelImpl.ENTITY_CACHE_ENABLED,
			ATODocumentImpl.class, atoDocument.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ATODocument> atoDocuments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ATODocument atoDocument : atoDocuments) {
			EntityCacheUtil.removeResult(ATODocumentModelImpl.ENTITY_CACHE_ENABLED,
				ATODocumentImpl.class, atoDocument.getPrimaryKey());
		}
	}

	/**
	 * Creates a new a t o document with the primary key. Does not add the a t o document to the database.
	 *
	 * @param atoDocumentId the primary key for the new a t o document
	 * @return the new a t o document
	 */
	@Override
	public ATODocument create(long atoDocumentId) {
		ATODocument atoDocument = new ATODocumentImpl();

		atoDocument.setNew(true);
		atoDocument.setPrimaryKey(atoDocumentId);

		String uuid = PortalUUIDUtil.generate();

		atoDocument.setUuid(uuid);

		return atoDocument;
	}

	/**
	 * Removes the a t o document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param atoDocumentId the primary key of the a t o document
	 * @return the a t o document that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a a t o document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument remove(long atoDocumentId)
		throws NoSuchATODocumentException, SystemException {
		return remove((Serializable)atoDocumentId);
	}

	/**
	 * Removes the a t o document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the a t o document
	 * @return the a t o document that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a a t o document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument remove(Serializable primaryKey)
		throws NoSuchATODocumentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ATODocument atoDocument = (ATODocument)session.get(ATODocumentImpl.class,
					primaryKey);

			if (atoDocument == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchATODocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(atoDocument);
		}
		catch (NoSuchATODocumentException nsee) {
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
	protected ATODocument removeImpl(ATODocument atoDocument)
		throws SystemException {
		atoDocument = toUnwrappedModel(atoDocument);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(atoDocument)) {
				atoDocument = (ATODocument)session.get(ATODocumentImpl.class,
						atoDocument.getPrimaryKeyObj());
			}

			if (atoDocument != null) {
				session.delete(atoDocument);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (atoDocument != null) {
			clearCache(atoDocument);
		}

		return atoDocument;
	}

	@Override
	public ATODocument updateImpl(
		com.sambaash.platform.srv.startupprofile.model.ATODocument atoDocument)
		throws SystemException {
		atoDocument = toUnwrappedModel(atoDocument);

		boolean isNew = atoDocument.isNew();

		ATODocumentModelImpl atoDocumentModelImpl = (ATODocumentModelImpl)atoDocument;

		if (Validator.isNull(atoDocument.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			atoDocument.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (atoDocument.isNew()) {
				session.save(atoDocument);

				atoDocument.setNew(false);
			}
			else {
				session.merge(atoDocument);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ATODocumentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((atoDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						atoDocumentModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { atoDocumentModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((atoDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENTTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						atoDocumentModelImpl.getOriginalDocumentType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOCUMENTTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENTTYPE,
					args);

				args = new Object[] { atoDocumentModelImpl.getDocumentType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOCUMENTTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENTTYPE,
					args);
			}

			if ((atoDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						atoDocumentModelImpl.getOriginalOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);

				args = new Object[] { atoDocumentModelImpl.getOrganizationId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);
			}

			if ((atoDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDDOCUMENTTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						atoDocumentModelImpl.getOriginalOrganizationId(),
						atoDocumentModelImpl.getOriginalDocumentType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONANDDOCUMENTTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDDOCUMENTTYPE,
					args);

				args = new Object[] {
						atoDocumentModelImpl.getOrganizationId(),
						atoDocumentModelImpl.getDocumentType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONANDDOCUMENTTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDDOCUMENTTYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(ATODocumentModelImpl.ENTITY_CACHE_ENABLED,
			ATODocumentImpl.class, atoDocument.getPrimaryKey(), atoDocument);

		return atoDocument;
	}

	protected ATODocument toUnwrappedModel(ATODocument atoDocument) {
		if (atoDocument instanceof ATODocumentImpl) {
			return atoDocument;
		}

		ATODocumentImpl atoDocumentImpl = new ATODocumentImpl();

		atoDocumentImpl.setNew(atoDocument.isNew());
		atoDocumentImpl.setPrimaryKey(atoDocument.getPrimaryKey());

		atoDocumentImpl.setUuid(atoDocument.getUuid());
		atoDocumentImpl.setAtoDocumentId(atoDocument.getAtoDocumentId());
		atoDocumentImpl.setOrganizationId(atoDocument.getOrganizationId());
		atoDocumentImpl.setDocumentType(atoDocument.getDocumentType());
		atoDocumentImpl.setDocumentFileId(atoDocument.getDocumentFileId());

		return atoDocumentImpl;
	}

	/**
	 * Returns the a t o document with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the a t o document
	 * @return the a t o document
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a a t o document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument findByPrimaryKey(Serializable primaryKey)
		throws NoSuchATODocumentException, SystemException {
		ATODocument atoDocument = fetchByPrimaryKey(primaryKey);

		if (atoDocument == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchATODocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return atoDocument;
	}

	/**
	 * Returns the a t o document with the primary key or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException} if it could not be found.
	 *
	 * @param atoDocumentId the primary key of the a t o document
	 * @return the a t o document
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchATODocumentException if a a t o document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument findByPrimaryKey(long atoDocumentId)
		throws NoSuchATODocumentException, SystemException {
		return findByPrimaryKey((Serializable)atoDocumentId);
	}

	/**
	 * Returns the a t o document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the a t o document
	 * @return the a t o document, or <code>null</code> if a a t o document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ATODocument atoDocument = (ATODocument)EntityCacheUtil.getResult(ATODocumentModelImpl.ENTITY_CACHE_ENABLED,
				ATODocumentImpl.class, primaryKey);

		if (atoDocument == _nullATODocument) {
			return null;
		}

		if (atoDocument == null) {
			Session session = null;

			try {
				session = openSession();

				atoDocument = (ATODocument)session.get(ATODocumentImpl.class,
						primaryKey);

				if (atoDocument != null) {
					cacheResult(atoDocument);
				}
				else {
					EntityCacheUtil.putResult(ATODocumentModelImpl.ENTITY_CACHE_ENABLED,
						ATODocumentImpl.class, primaryKey, _nullATODocument);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ATODocumentModelImpl.ENTITY_CACHE_ENABLED,
					ATODocumentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return atoDocument;
	}

	/**
	 * Returns the a t o document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param atoDocumentId the primary key of the a t o document
	 * @return the a t o document, or <code>null</code> if a a t o document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ATODocument fetchByPrimaryKey(long atoDocumentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)atoDocumentId);
	}

	/**
	 * Returns all the a t o documents.
	 *
	 * @return the a t o documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ATODocument> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the a t o documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of a t o documents
	 * @param end the upper bound of the range of a t o documents (not inclusive)
	 * @return the range of a t o documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ATODocument> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the a t o documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of a t o documents
	 * @param end the upper bound of the range of a t o documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of a t o documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ATODocument> findAll(int start, int end,
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

		List<ATODocument> list = (List<ATODocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ATODOCUMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ATODOCUMENT;

				if (pagination) {
					sql = sql.concat(ATODocumentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ATODocument>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ATODocument>(list);
				}
				else {
					list = (List<ATODocument>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the a t o documents from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ATODocument atoDocument : findAll()) {
			remove(atoDocument);
		}
	}

	/**
	 * Returns the number of a t o documents.
	 *
	 * @return the number of a t o documents
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

				Query q = session.createQuery(_SQL_COUNT_ATODOCUMENT);

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
	 * Initializes the a t o document persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.startupprofile.model.ATODocument")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ATODocument>> listenersList = new ArrayList<ModelListener<ATODocument>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ATODocument>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ATODocumentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ATODOCUMENT = "SELECT atoDocument FROM ATODocument atoDocument";
	private static final String _SQL_SELECT_ATODOCUMENT_WHERE = "SELECT atoDocument FROM ATODocument atoDocument WHERE ";
	private static final String _SQL_COUNT_ATODOCUMENT = "SELECT COUNT(atoDocument) FROM ATODocument atoDocument";
	private static final String _SQL_COUNT_ATODOCUMENT_WHERE = "SELECT COUNT(atoDocument) FROM ATODocument atoDocument WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "atoDocument.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ATODocument exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ATODocument exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ATODocumentPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ATODocument _nullATODocument = new ATODocumentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ATODocument> toCacheModel() {
				return _nullATODocumentCacheModel;
			}
		};

	private static CacheModel<ATODocument> _nullATODocumentCacheModel = new CacheModel<ATODocument>() {
			@Override
			public ATODocument toEntityModel() {
				return _nullATODocument;
			}
		};
}