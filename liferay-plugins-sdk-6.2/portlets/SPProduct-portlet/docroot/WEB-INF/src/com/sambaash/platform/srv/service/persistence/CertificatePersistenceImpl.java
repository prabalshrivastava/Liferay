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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.NoSuchCertificateException;
import com.sambaash.platform.srv.model.Certificate;
import com.sambaash.platform.srv.model.impl.CertificateImpl;
import com.sambaash.platform.srv.model.impl.CertificateModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the certificate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see CertificatePersistence
 * @see CertificateUtil
 * @generated
 */
public class CertificatePersistenceImpl extends BasePersistenceImpl<Certificate>
	implements CertificatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CertificateUtil} to access the certificate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CertificateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, CertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, CertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, CertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, CertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			CertificateModelImpl.GROUPID_COLUMN_BITMASK |
			CertificateModelImpl.TITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the certificates where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Certificate> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the certificates where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of certificates
	 * @param end the upper bound of the range of certificates (not inclusive)
	 * @return the range of matching certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Certificate> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the certificates where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of certificates
	 * @param end the upper bound of the range of certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Certificate> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<Certificate> list = (List<Certificate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Certificate certificate : list) {
				if ((groupId != certificate.getGroupId())) {
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

			query.append(_SQL_SELECT_CERTIFICATE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CertificateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Certificate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Certificate>(list);
				}
				else {
					list = (List<Certificate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first certificate in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching certificate
	 * @throws com.sambaash.platform.srv.NoSuchCertificateException if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCertificateException, SystemException {
		Certificate certificate = fetchByGroupId_First(groupId,
				orderByComparator);

		if (certificate != null) {
			return certificate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCertificateException(msg.toString());
	}

	/**
	 * Returns the first certificate in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching certificate, or <code>null</code> if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Certificate> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last certificate in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching certificate
	 * @throws com.sambaash.platform.srv.NoSuchCertificateException if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCertificateException, SystemException {
		Certificate certificate = fetchByGroupId_Last(groupId, orderByComparator);

		if (certificate != null) {
			return certificate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCertificateException(msg.toString());
	}

	/**
	 * Returns the last certificate in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching certificate, or <code>null</code> if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Certificate> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the certificates before and after the current certificate in the ordered set where groupId = &#63;.
	 *
	 * @param spCertificatetId the primary key of the current certificate
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next certificate
	 * @throws com.sambaash.platform.srv.NoSuchCertificateException if a certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate[] findByGroupId_PrevAndNext(long spCertificatetId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCertificateException, SystemException {
		Certificate certificate = findByPrimaryKey(spCertificatetId);

		Session session = null;

		try {
			session = openSession();

			Certificate[] array = new CertificateImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, certificate, groupId,
					orderByComparator, true);

			array[1] = certificate;

			array[2] = getByGroupId_PrevAndNext(session, certificate, groupId,
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

	protected Certificate getByGroupId_PrevAndNext(Session session,
		Certificate certificate, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CERTIFICATE_WHERE);

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
			query.append(CertificateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(certificate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Certificate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the certificates where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Certificate certificate : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(certificate);
		}
	}

	/**
	 * Returns the number of certificates where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching certificates
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

			query.append(_SQL_COUNT_CERTIFICATE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "certificate.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID =
		new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, CertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCountryIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID =
		new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, CertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCountryIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			CertificateModelImpl.COUNTRYID_COLUMN_BITMASK |
			CertificateModelImpl.GROUPID_COLUMN_BITMASK |
			CertificateModelImpl.TITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPID = new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCountryIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the certificates where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @return the matching certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Certificate> findByCountryIdAndGroupId(long countryId,
		long groupId) throws SystemException {
		return findByCountryIdAndGroupId(countryId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the certificates where countryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of certificates
	 * @param end the upper bound of the range of certificates (not inclusive)
	 * @return the range of matching certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Certificate> findByCountryIdAndGroupId(long countryId,
		long groupId, int start, int end) throws SystemException {
		return findByCountryIdAndGroupId(countryId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the certificates where countryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of certificates
	 * @param end the upper bound of the range of certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Certificate> findByCountryIdAndGroupId(long countryId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID;
			finderArgs = new Object[] { countryId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID;
			finderArgs = new Object[] {
					countryId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Certificate> list = (List<Certificate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Certificate certificate : list) {
				if ((countryId != certificate.getCountryId()) ||
						(groupId != certificate.getGroupId())) {
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

			query.append(_SQL_SELECT_CERTIFICATE_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_COUNTRYID_2);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CertificateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countryId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Certificate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Certificate>(list);
				}
				else {
					list = (List<Certificate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first certificate in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching certificate
	 * @throws com.sambaash.platform.srv.NoSuchCertificateException if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate findByCountryIdAndGroupId_First(long countryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCertificateException, SystemException {
		Certificate certificate = fetchByCountryIdAndGroupId_First(countryId,
				groupId, orderByComparator);

		if (certificate != null) {
			return certificate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("countryId=");
		msg.append(countryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCertificateException(msg.toString());
	}

	/**
	 * Returns the first certificate in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching certificate, or <code>null</code> if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate fetchByCountryIdAndGroupId_First(long countryId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Certificate> list = findByCountryIdAndGroupId(countryId, groupId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last certificate in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching certificate
	 * @throws com.sambaash.platform.srv.NoSuchCertificateException if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate findByCountryIdAndGroupId_Last(long countryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCertificateException, SystemException {
		Certificate certificate = fetchByCountryIdAndGroupId_Last(countryId,
				groupId, orderByComparator);

		if (certificate != null) {
			return certificate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("countryId=");
		msg.append(countryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCertificateException(msg.toString());
	}

	/**
	 * Returns the last certificate in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching certificate, or <code>null</code> if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate fetchByCountryIdAndGroupId_Last(long countryId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCountryIdAndGroupId(countryId, groupId);

		if (count == 0) {
			return null;
		}

		List<Certificate> list = findByCountryIdAndGroupId(countryId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the certificates before and after the current certificate in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param spCertificatetId the primary key of the current certificate
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next certificate
	 * @throws com.sambaash.platform.srv.NoSuchCertificateException if a certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate[] findByCountryIdAndGroupId_PrevAndNext(
		long spCertificatetId, long countryId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCertificateException, SystemException {
		Certificate certificate = findByPrimaryKey(spCertificatetId);

		Session session = null;

		try {
			session = openSession();

			Certificate[] array = new CertificateImpl[3];

			array[0] = getByCountryIdAndGroupId_PrevAndNext(session,
					certificate, countryId, groupId, orderByComparator, true);

			array[1] = certificate;

			array[2] = getByCountryIdAndGroupId_PrevAndNext(session,
					certificate, countryId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Certificate getByCountryIdAndGroupId_PrevAndNext(
		Session session, Certificate certificate, long countryId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CERTIFICATE_WHERE);

		query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_COUNTRYID_2);

		query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_GROUPID_2);

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
			query.append(CertificateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(countryId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(certificate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Certificate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the certificates where countryId = &#63; and groupId = &#63; from the database.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCountryIdAndGroupId(long countryId, long groupId)
		throws SystemException {
		for (Certificate certificate : findByCountryIdAndGroupId(countryId,
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(certificate);
		}
	}

	/**
	 * Returns the number of certificates where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @return the number of matching certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCountryIdAndGroupId(long countryId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPID;

		Object[] finderArgs = new Object[] { countryId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CERTIFICATE_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_COUNTRYID_2);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countryId);

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

	private static final String _FINDER_COLUMN_COUNTRYIDANDGROUPID_COUNTRYID_2 = "certificate.countryId = ? AND ";
	private static final String _FINDER_COLUMN_COUNTRYIDANDGROUPID_GROUPID_2 = "certificate.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CERTIFICATECODE =
		new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, CertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycertificateCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATECODE =
		new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, CertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycertificateCode",
			new String[] { String.class.getName() },
			CertificateModelImpl.CERTIFICATECODE_COLUMN_BITMASK |
			CertificateModelImpl.TITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CERTIFICATECODE = new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBycertificateCode", new String[] { String.class.getName() });

	/**
	 * Returns all the certificates where certificateCode = &#63;.
	 *
	 * @param certificateCode the certificate code
	 * @return the matching certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Certificate> findBycertificateCode(String certificateCode)
		throws SystemException {
		return findBycertificateCode(certificateCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the certificates where certificateCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param certificateCode the certificate code
	 * @param start the lower bound of the range of certificates
	 * @param end the upper bound of the range of certificates (not inclusive)
	 * @return the range of matching certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Certificate> findBycertificateCode(String certificateCode,
		int start, int end) throws SystemException {
		return findBycertificateCode(certificateCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the certificates where certificateCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param certificateCode the certificate code
	 * @param start the lower bound of the range of certificates
	 * @param end the upper bound of the range of certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Certificate> findBycertificateCode(String certificateCode,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATECODE;
			finderArgs = new Object[] { certificateCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CERTIFICATECODE;
			finderArgs = new Object[] {
					certificateCode,
					
					start, end, orderByComparator
				};
		}

		List<Certificate> list = (List<Certificate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Certificate certificate : list) {
				if (!Validator.equals(certificateCode,
							certificate.getCertificateCode())) {
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

			query.append(_SQL_SELECT_CERTIFICATE_WHERE);

			boolean bindCertificateCode = false;

			if (certificateCode == null) {
				query.append(_FINDER_COLUMN_CERTIFICATECODE_CERTIFICATECODE_1);
			}
			else if (certificateCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CERTIFICATECODE_CERTIFICATECODE_3);
			}
			else {
				bindCertificateCode = true;

				query.append(_FINDER_COLUMN_CERTIFICATECODE_CERTIFICATECODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CertificateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCertificateCode) {
					qPos.add(certificateCode.toLowerCase());
				}

				if (!pagination) {
					list = (List<Certificate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Certificate>(list);
				}
				else {
					list = (List<Certificate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first certificate in the ordered set where certificateCode = &#63;.
	 *
	 * @param certificateCode the certificate code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching certificate
	 * @throws com.sambaash.platform.srv.NoSuchCertificateException if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate findBycertificateCode_First(String certificateCode,
		OrderByComparator orderByComparator)
		throws NoSuchCertificateException, SystemException {
		Certificate certificate = fetchBycertificateCode_First(certificateCode,
				orderByComparator);

		if (certificate != null) {
			return certificate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("certificateCode=");
		msg.append(certificateCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCertificateException(msg.toString());
	}

	/**
	 * Returns the first certificate in the ordered set where certificateCode = &#63;.
	 *
	 * @param certificateCode the certificate code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching certificate, or <code>null</code> if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate fetchBycertificateCode_First(String certificateCode,
		OrderByComparator orderByComparator) throws SystemException {
		List<Certificate> list = findBycertificateCode(certificateCode, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last certificate in the ordered set where certificateCode = &#63;.
	 *
	 * @param certificateCode the certificate code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching certificate
	 * @throws com.sambaash.platform.srv.NoSuchCertificateException if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate findBycertificateCode_Last(String certificateCode,
		OrderByComparator orderByComparator)
		throws NoSuchCertificateException, SystemException {
		Certificate certificate = fetchBycertificateCode_Last(certificateCode,
				orderByComparator);

		if (certificate != null) {
			return certificate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("certificateCode=");
		msg.append(certificateCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCertificateException(msg.toString());
	}

	/**
	 * Returns the last certificate in the ordered set where certificateCode = &#63;.
	 *
	 * @param certificateCode the certificate code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching certificate, or <code>null</code> if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate fetchBycertificateCode_Last(String certificateCode,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBycertificateCode(certificateCode);

		if (count == 0) {
			return null;
		}

		List<Certificate> list = findBycertificateCode(certificateCode,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the certificates before and after the current certificate in the ordered set where certificateCode = &#63;.
	 *
	 * @param spCertificatetId the primary key of the current certificate
	 * @param certificateCode the certificate code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next certificate
	 * @throws com.sambaash.platform.srv.NoSuchCertificateException if a certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate[] findBycertificateCode_PrevAndNext(
		long spCertificatetId, String certificateCode,
		OrderByComparator orderByComparator)
		throws NoSuchCertificateException, SystemException {
		Certificate certificate = findByPrimaryKey(spCertificatetId);

		Session session = null;

		try {
			session = openSession();

			Certificate[] array = new CertificateImpl[3];

			array[0] = getBycertificateCode_PrevAndNext(session, certificate,
					certificateCode, orderByComparator, true);

			array[1] = certificate;

			array[2] = getBycertificateCode_PrevAndNext(session, certificate,
					certificateCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Certificate getBycertificateCode_PrevAndNext(Session session,
		Certificate certificate, String certificateCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CERTIFICATE_WHERE);

		boolean bindCertificateCode = false;

		if (certificateCode == null) {
			query.append(_FINDER_COLUMN_CERTIFICATECODE_CERTIFICATECODE_1);
		}
		else if (certificateCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CERTIFICATECODE_CERTIFICATECODE_3);
		}
		else {
			bindCertificateCode = true;

			query.append(_FINDER_COLUMN_CERTIFICATECODE_CERTIFICATECODE_2);
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
			query.append(CertificateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCertificateCode) {
			qPos.add(certificateCode.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(certificate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Certificate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the certificates where certificateCode = &#63; from the database.
	 *
	 * @param certificateCode the certificate code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBycertificateCode(String certificateCode)
		throws SystemException {
		for (Certificate certificate : findBycertificateCode(certificateCode,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(certificate);
		}
	}

	/**
	 * Returns the number of certificates where certificateCode = &#63;.
	 *
	 * @param certificateCode the certificate code
	 * @return the number of matching certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBycertificateCode(String certificateCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CERTIFICATECODE;

		Object[] finderArgs = new Object[] { certificateCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CERTIFICATE_WHERE);

			boolean bindCertificateCode = false;

			if (certificateCode == null) {
				query.append(_FINDER_COLUMN_CERTIFICATECODE_CERTIFICATECODE_1);
			}
			else if (certificateCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CERTIFICATECODE_CERTIFICATECODE_3);
			}
			else {
				bindCertificateCode = true;

				query.append(_FINDER_COLUMN_CERTIFICATECODE_CERTIFICATECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCertificateCode) {
					qPos.add(certificateCode.toLowerCase());
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

	private static final String _FINDER_COLUMN_CERTIFICATECODE_CERTIFICATECODE_1 =
		"certificate.certificateCode IS NULL";
	private static final String _FINDER_COLUMN_CERTIFICATECODE_CERTIFICATECODE_2 =
		"lower(certificate.certificateCode) = ?";
	private static final String _FINDER_COLUMN_CERTIFICATECODE_CERTIFICATECODE_3 =
		"(certificate.certificateCode IS NULL OR certificate.certificateCode = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_CERTIFICATENAMEANDGROUPID =
		new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, CertificateImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCertificateNameAndGroupId",
			new String[] { String.class.getName(), Long.class.getName() },
			CertificateModelImpl.TITLE_COLUMN_BITMASK |
			CertificateModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CERTIFICATENAMEANDGROUPID =
		new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCertificateNameAndGroupId",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the certificate where title = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchCertificateException} if it could not be found.
	 *
	 * @param title the title
	 * @param groupId the group ID
	 * @return the matching certificate
	 * @throws com.sambaash.platform.srv.NoSuchCertificateException if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate findByCertificateNameAndGroupId(String title,
		long groupId) throws NoSuchCertificateException, SystemException {
		Certificate certificate = fetchByCertificateNameAndGroupId(title,
				groupId);

		if (certificate == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("title=");
			msg.append(title);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCertificateException(msg.toString());
		}

		return certificate;
	}

	/**
	 * Returns the certificate where title = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param title the title
	 * @param groupId the group ID
	 * @return the matching certificate, or <code>null</code> if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate fetchByCertificateNameAndGroupId(String title,
		long groupId) throws SystemException {
		return fetchByCertificateNameAndGroupId(title, groupId, true);
	}

	/**
	 * Returns the certificate where title = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param title the title
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching certificate, or <code>null</code> if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate fetchByCertificateNameAndGroupId(String title,
		long groupId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { title, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CERTIFICATENAMEANDGROUPID,
					finderArgs, this);
		}

		if (result instanceof Certificate) {
			Certificate certificate = (Certificate)result;

			if (!Validator.equals(title, certificate.getTitle()) ||
					(groupId != certificate.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CERTIFICATE_WHERE);

			boolean bindTitle = false;

			if (title == null) {
				query.append(_FINDER_COLUMN_CERTIFICATENAMEANDGROUPID_TITLE_1);
			}
			else if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CERTIFICATENAMEANDGROUPID_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_CERTIFICATENAMEANDGROUPID_TITLE_2);
			}

			query.append(_FINDER_COLUMN_CERTIFICATENAMEANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTitle) {
					qPos.add(title.toLowerCase());
				}

				qPos.add(groupId);

				List<Certificate> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTIFICATENAMEANDGROUPID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CertificatePersistenceImpl.fetchByCertificateNameAndGroupId(String, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Certificate certificate = list.get(0);

					result = certificate;

					cacheResult(certificate);

					if ((certificate.getTitle() == null) ||
							!certificate.getTitle().equals(title) ||
							(certificate.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTIFICATENAMEANDGROUPID,
							finderArgs, certificate);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CERTIFICATENAMEANDGROUPID,
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
			return (Certificate)result;
		}
	}

	/**
	 * Removes the certificate where title = &#63; and groupId = &#63; from the database.
	 *
	 * @param title the title
	 * @param groupId the group ID
	 * @return the certificate that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate removeByCertificateNameAndGroupId(String title,
		long groupId) throws NoSuchCertificateException, SystemException {
		Certificate certificate = findByCertificateNameAndGroupId(title, groupId);

		return remove(certificate);
	}

	/**
	 * Returns the number of certificates where title = &#63; and groupId = &#63;.
	 *
	 * @param title the title
	 * @param groupId the group ID
	 * @return the number of matching certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCertificateNameAndGroupId(String title, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CERTIFICATENAMEANDGROUPID;

		Object[] finderArgs = new Object[] { title, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CERTIFICATE_WHERE);

			boolean bindTitle = false;

			if (title == null) {
				query.append(_FINDER_COLUMN_CERTIFICATENAMEANDGROUPID_TITLE_1);
			}
			else if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CERTIFICATENAMEANDGROUPID_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_CERTIFICATENAMEANDGROUPID_TITLE_2);
			}

			query.append(_FINDER_COLUMN_CERTIFICATENAMEANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTitle) {
					qPos.add(title.toLowerCase());
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

	private static final String _FINDER_COLUMN_CERTIFICATENAMEANDGROUPID_TITLE_1 =
		"certificate.title IS NULL AND ";
	private static final String _FINDER_COLUMN_CERTIFICATENAMEANDGROUPID_TITLE_2 =
		"lower(certificate.title) = ? AND ";
	private static final String _FINDER_COLUMN_CERTIFICATENAMEANDGROUPID_TITLE_3 =
		"(certificate.title IS NULL OR certificate.title = '') AND ";
	private static final String _FINDER_COLUMN_CERTIFICATENAMEANDGROUPID_GROUPID_2 =
		"certificate.groupId = ?";

	public CertificatePersistenceImpl() {
		setModelClass(Certificate.class);
	}

	/**
	 * Caches the certificate in the entity cache if it is enabled.
	 *
	 * @param certificate the certificate
	 */
	@Override
	public void cacheResult(Certificate certificate) {
		EntityCacheUtil.putResult(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateImpl.class, certificate.getPrimaryKey(), certificate);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTIFICATENAMEANDGROUPID,
			new Object[] { certificate.getTitle(), certificate.getGroupId() },
			certificate);

		certificate.resetOriginalValues();
	}

	/**
	 * Caches the certificates in the entity cache if it is enabled.
	 *
	 * @param certificates the certificates
	 */
	@Override
	public void cacheResult(List<Certificate> certificates) {
		for (Certificate certificate : certificates) {
			if (EntityCacheUtil.getResult(
						CertificateModelImpl.ENTITY_CACHE_ENABLED,
						CertificateImpl.class, certificate.getPrimaryKey()) == null) {
				cacheResult(certificate);
			}
			else {
				certificate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all certificates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CertificateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CertificateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the certificate.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Certificate certificate) {
		EntityCacheUtil.removeResult(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateImpl.class, certificate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(certificate);
	}

	@Override
	public void clearCache(List<Certificate> certificates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Certificate certificate : certificates) {
			EntityCacheUtil.removeResult(CertificateModelImpl.ENTITY_CACHE_ENABLED,
				CertificateImpl.class, certificate.getPrimaryKey());

			clearUniqueFindersCache(certificate);
		}
	}

	protected void cacheUniqueFindersCache(Certificate certificate) {
		if (certificate.isNew()) {
			Object[] args = new Object[] {
					certificate.getTitle(), certificate.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CERTIFICATENAMEANDGROUPID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTIFICATENAMEANDGROUPID,
				args, certificate);
		}
		else {
			CertificateModelImpl certificateModelImpl = (CertificateModelImpl)certificate;

			if ((certificateModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CERTIFICATENAMEANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						certificate.getTitle(), certificate.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CERTIFICATENAMEANDGROUPID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTIFICATENAMEANDGROUPID,
					args, certificate);
			}
		}
	}

	protected void clearUniqueFindersCache(Certificate certificate) {
		CertificateModelImpl certificateModelImpl = (CertificateModelImpl)certificate;

		Object[] args = new Object[] {
				certificate.getTitle(), certificate.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATENAMEANDGROUPID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CERTIFICATENAMEANDGROUPID,
			args);

		if ((certificateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CERTIFICATENAMEANDGROUPID.getColumnBitmask()) != 0) {
			args = new Object[] {
					certificateModelImpl.getOriginalTitle(),
					certificateModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATENAMEANDGROUPID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CERTIFICATENAMEANDGROUPID,
				args);
		}
	}

	/**
	 * Creates a new certificate with the primary key. Does not add the certificate to the database.
	 *
	 * @param spCertificatetId the primary key for the new certificate
	 * @return the new certificate
	 */
	@Override
	public Certificate create(long spCertificatetId) {
		Certificate certificate = new CertificateImpl();

		certificate.setNew(true);
		certificate.setPrimaryKey(spCertificatetId);

		return certificate;
	}

	/**
	 * Removes the certificate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spCertificatetId the primary key of the certificate
	 * @return the certificate that was removed
	 * @throws com.sambaash.platform.srv.NoSuchCertificateException if a certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate remove(long spCertificatetId)
		throws NoSuchCertificateException, SystemException {
		return remove((Serializable)spCertificatetId);
	}

	/**
	 * Removes the certificate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the certificate
	 * @return the certificate that was removed
	 * @throws com.sambaash.platform.srv.NoSuchCertificateException if a certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate remove(Serializable primaryKey)
		throws NoSuchCertificateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Certificate certificate = (Certificate)session.get(CertificateImpl.class,
					primaryKey);

			if (certificate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCertificateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(certificate);
		}
		catch (NoSuchCertificateException nsee) {
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
	protected Certificate removeImpl(Certificate certificate)
		throws SystemException {
		certificate = toUnwrappedModel(certificate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(certificate)) {
				certificate = (Certificate)session.get(CertificateImpl.class,
						certificate.getPrimaryKeyObj());
			}

			if (certificate != null) {
				session.delete(certificate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (certificate != null) {
			clearCache(certificate);
		}

		return certificate;
	}

	@Override
	public Certificate updateImpl(
		com.sambaash.platform.srv.model.Certificate certificate)
		throws SystemException {
		certificate = toUnwrappedModel(certificate);

		boolean isNew = certificate.isNew();

		CertificateModelImpl certificateModelImpl = (CertificateModelImpl)certificate;

		Session session = null;

		try {
			session = openSession();

			if (certificate.isNew()) {
				session.save(certificate);

				certificate.setNew(false);
			}
			else {
				session.merge(certificate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CertificateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((certificateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						certificateModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { certificateModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((certificateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						certificateModelImpl.getOriginalCountryId(),
						certificateModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID,
					args);

				args = new Object[] {
						certificateModelImpl.getCountryId(),
						certificateModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID,
					args);
			}

			if ((certificateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						certificateModelImpl.getOriginalCertificateCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATECODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATECODE,
					args);

				args = new Object[] { certificateModelImpl.getCertificateCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATECODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATECODE,
					args);
			}
		}

		EntityCacheUtil.putResult(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateImpl.class, certificate.getPrimaryKey(), certificate);

		clearUniqueFindersCache(certificate);
		cacheUniqueFindersCache(certificate);

		return certificate;
	}

	protected Certificate toUnwrappedModel(Certificate certificate) {
		if (certificate instanceof CertificateImpl) {
			return certificate;
		}

		CertificateImpl certificateImpl = new CertificateImpl();

		certificateImpl.setNew(certificate.isNew());
		certificateImpl.setPrimaryKey(certificate.getPrimaryKey());

		certificateImpl.setSpCertificatetId(certificate.getSpCertificatetId());
		certificateImpl.setGroupId(certificate.getGroupId());
		certificateImpl.setCompanyId(certificate.getCompanyId());
		certificateImpl.setUserId(certificate.getUserId());
		certificateImpl.setUserName(certificate.getUserName());
		certificateImpl.setCreateDate(certificate.getCreateDate());
		certificateImpl.setModifiedDate(certificate.getModifiedDate());
		certificateImpl.setCountryId(certificate.getCountryId());
		certificateImpl.setCertificateCode(certificate.getCertificateCode());
		certificateImpl.setCertificateType(certificate.getCertificateType());
		certificateImpl.setTitle(certificate.getTitle());
		certificateImpl.setDescription(certificate.getDescription());
		certificateImpl.setLevel(certificate.getLevel());
		certificateImpl.setAttachmentFolderId(certificate.getAttachmentFolderId());

		return certificateImpl;
	}

	/**
	 * Returns the certificate with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the certificate
	 * @return the certificate
	 * @throws com.sambaash.platform.srv.NoSuchCertificateException if a certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCertificateException, SystemException {
		Certificate certificate = fetchByPrimaryKey(primaryKey);

		if (certificate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCertificateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return certificate;
	}

	/**
	 * Returns the certificate with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchCertificateException} if it could not be found.
	 *
	 * @param spCertificatetId the primary key of the certificate
	 * @return the certificate
	 * @throws com.sambaash.platform.srv.NoSuchCertificateException if a certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate findByPrimaryKey(long spCertificatetId)
		throws NoSuchCertificateException, SystemException {
		return findByPrimaryKey((Serializable)spCertificatetId);
	}

	/**
	 * Returns the certificate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the certificate
	 * @return the certificate, or <code>null</code> if a certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Certificate certificate = (Certificate)EntityCacheUtil.getResult(CertificateModelImpl.ENTITY_CACHE_ENABLED,
				CertificateImpl.class, primaryKey);

		if (certificate == _nullCertificate) {
			return null;
		}

		if (certificate == null) {
			Session session = null;

			try {
				session = openSession();

				certificate = (Certificate)session.get(CertificateImpl.class,
						primaryKey);

				if (certificate != null) {
					cacheResult(certificate);
				}
				else {
					EntityCacheUtil.putResult(CertificateModelImpl.ENTITY_CACHE_ENABLED,
						CertificateImpl.class, primaryKey, _nullCertificate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CertificateModelImpl.ENTITY_CACHE_ENABLED,
					CertificateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return certificate;
	}

	/**
	 * Returns the certificate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spCertificatetId the primary key of the certificate
	 * @return the certificate, or <code>null</code> if a certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate fetchByPrimaryKey(long spCertificatetId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spCertificatetId);
	}

	/**
	 * Returns all the certificates.
	 *
	 * @return the certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Certificate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the certificates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of certificates
	 * @param end the upper bound of the range of certificates (not inclusive)
	 * @return the range of certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Certificate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the certificates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of certificates
	 * @param end the upper bound of the range of certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Certificate> findAll(int start, int end,
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

		List<Certificate> list = (List<Certificate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CERTIFICATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CERTIFICATE;

				if (pagination) {
					sql = sql.concat(CertificateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Certificate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Certificate>(list);
				}
				else {
					list = (List<Certificate>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the certificates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Certificate certificate : findAll()) {
			remove(certificate);
		}
	}

	/**
	 * Returns the number of certificates.
	 *
	 * @return the number of certificates
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

				Query q = session.createQuery(_SQL_COUNT_CERTIFICATE);

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
	 * Initializes the certificate persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.Certificate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Certificate>> listenersList = new ArrayList<ModelListener<Certificate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Certificate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CertificateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CERTIFICATE = "SELECT certificate FROM Certificate certificate";
	private static final String _SQL_SELECT_CERTIFICATE_WHERE = "SELECT certificate FROM Certificate certificate WHERE ";
	private static final String _SQL_COUNT_CERTIFICATE = "SELECT COUNT(certificate) FROM Certificate certificate";
	private static final String _SQL_COUNT_CERTIFICATE_WHERE = "SELECT COUNT(certificate) FROM Certificate certificate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "certificate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Certificate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Certificate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CertificatePersistenceImpl.class);
	private static Certificate _nullCertificate = new CertificateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Certificate> toCacheModel() {
				return _nullCertificateCacheModel;
			}
		};

	private static CacheModel<Certificate> _nullCertificateCacheModel = new CacheModel<Certificate>() {
			@Override
			public Certificate toEntityModel() {
				return _nullCertificate;
			}
		};
}