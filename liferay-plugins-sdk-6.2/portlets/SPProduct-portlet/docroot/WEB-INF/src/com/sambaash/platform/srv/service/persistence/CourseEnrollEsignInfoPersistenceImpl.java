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

import com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException;
import com.sambaash.platform.srv.model.CourseEnrollEsignInfo;
import com.sambaash.platform.srv.model.impl.CourseEnrollEsignInfoImpl;
import com.sambaash.platform.srv.model.impl.CourseEnrollEsignInfoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the course enroll esign info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseEnrollEsignInfoPersistence
 * @see CourseEnrollEsignInfoUtil
 * @generated
 */
public class CourseEnrollEsignInfoPersistenceImpl extends BasePersistenceImpl<CourseEnrollEsignInfo>
	implements CourseEnrollEsignInfoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CourseEnrollEsignInfoUtil} to access the course enroll esign info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CourseEnrollEsignInfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CourseEnrollEsignInfoModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollEsignInfoModelImpl.FINDER_CACHE_ENABLED,
			CourseEnrollEsignInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CourseEnrollEsignInfoModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollEsignInfoModelImpl.FINDER_CACHE_ENABLED,
			CourseEnrollEsignInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CourseEnrollEsignInfoModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollEsignInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_SIGNERID = new FinderPath(CourseEnrollEsignInfoModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollEsignInfoModelImpl.FINDER_CACHE_ENABLED,
			CourseEnrollEsignInfoImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBySignerId", new String[] { String.class.getName() },
			CourseEnrollEsignInfoModelImpl.SIGNERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SIGNERID = new FinderPath(CourseEnrollEsignInfoModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollEsignInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySignerId",
			new String[] { String.class.getName() });

	/**
	 * Returns the course enroll esign info where signerId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException} if it could not be found.
	 *
	 * @param signerId the signer ID
	 * @return the matching course enroll esign info
	 * @throws com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException if a matching course enroll esign info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollEsignInfo findBySignerId(String signerId)
		throws NoSuchCourseEnrollEsignInfoException, SystemException {
		CourseEnrollEsignInfo courseEnrollEsignInfo = fetchBySignerId(signerId);

		if (courseEnrollEsignInfo == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("signerId=");
			msg.append(signerId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCourseEnrollEsignInfoException(msg.toString());
		}

		return courseEnrollEsignInfo;
	}

	/**
	 * Returns the course enroll esign info where signerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param signerId the signer ID
	 * @return the matching course enroll esign info, or <code>null</code> if a matching course enroll esign info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollEsignInfo fetchBySignerId(String signerId)
		throws SystemException {
		return fetchBySignerId(signerId, true);
	}

	/**
	 * Returns the course enroll esign info where signerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param signerId the signer ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching course enroll esign info, or <code>null</code> if a matching course enroll esign info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollEsignInfo fetchBySignerId(String signerId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { signerId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SIGNERID,
					finderArgs, this);
		}

		if (result instanceof CourseEnrollEsignInfo) {
			CourseEnrollEsignInfo courseEnrollEsignInfo = (CourseEnrollEsignInfo)result;

			if (!Validator.equals(signerId, courseEnrollEsignInfo.getSignerId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_COURSEENROLLESIGNINFO_WHERE);

			boolean bindSignerId = false;

			if (signerId == null) {
				query.append(_FINDER_COLUMN_SIGNERID_SIGNERID_1);
			}
			else if (signerId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SIGNERID_SIGNERID_3);
			}
			else {
				bindSignerId = true;

				query.append(_FINDER_COLUMN_SIGNERID_SIGNERID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSignerId) {
					qPos.add(signerId);
				}

				List<CourseEnrollEsignInfo> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SIGNERID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CourseEnrollEsignInfoPersistenceImpl.fetchBySignerId(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					CourseEnrollEsignInfo courseEnrollEsignInfo = list.get(0);

					result = courseEnrollEsignInfo;

					cacheResult(courseEnrollEsignInfo);

					if ((courseEnrollEsignInfo.getSignerId() == null) ||
							!courseEnrollEsignInfo.getSignerId().equals(signerId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SIGNERID,
							finderArgs, courseEnrollEsignInfo);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SIGNERID,
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
			return (CourseEnrollEsignInfo)result;
		}
	}

	/**
	 * Removes the course enroll esign info where signerId = &#63; from the database.
	 *
	 * @param signerId the signer ID
	 * @return the course enroll esign info that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollEsignInfo removeBySignerId(String signerId)
		throws NoSuchCourseEnrollEsignInfoException, SystemException {
		CourseEnrollEsignInfo courseEnrollEsignInfo = findBySignerId(signerId);

		return remove(courseEnrollEsignInfo);
	}

	/**
	 * Returns the number of course enroll esign infos where signerId = &#63;.
	 *
	 * @param signerId the signer ID
	 * @return the number of matching course enroll esign infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySignerId(String signerId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SIGNERID;

		Object[] finderArgs = new Object[] { signerId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSEENROLLESIGNINFO_WHERE);

			boolean bindSignerId = false;

			if (signerId == null) {
				query.append(_FINDER_COLUMN_SIGNERID_SIGNERID_1);
			}
			else if (signerId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SIGNERID_SIGNERID_3);
			}
			else {
				bindSignerId = true;

				query.append(_FINDER_COLUMN_SIGNERID_SIGNERID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSignerId) {
					qPos.add(signerId);
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

	private static final String _FINDER_COLUMN_SIGNERID_SIGNERID_1 = "courseEnrollEsignInfo.signerId IS NULL";
	private static final String _FINDER_COLUMN_SIGNERID_SIGNERID_2 = "courseEnrollEsignInfo.signerId = ?";
	private static final String _FINDER_COLUMN_SIGNERID_SIGNERID_3 = "(courseEnrollEsignInfo.signerId IS NULL OR courseEnrollEsignInfo.signerId = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PACKAGEID = new FinderPath(CourseEnrollEsignInfoModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollEsignInfoModelImpl.FINDER_CACHE_ENABLED,
			CourseEnrollEsignInfoImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPackageId", new String[] { String.class.getName() },
			CourseEnrollEsignInfoModelImpl.PACKAGEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PACKAGEID = new FinderPath(CourseEnrollEsignInfoModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollEsignInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPackageId",
			new String[] { String.class.getName() });

	/**
	 * Returns the course enroll esign info where packageId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException} if it could not be found.
	 *
	 * @param packageId the package ID
	 * @return the matching course enroll esign info
	 * @throws com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException if a matching course enroll esign info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollEsignInfo findByPackageId(String packageId)
		throws NoSuchCourseEnrollEsignInfoException, SystemException {
		CourseEnrollEsignInfo courseEnrollEsignInfo = fetchByPackageId(packageId);

		if (courseEnrollEsignInfo == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("packageId=");
			msg.append(packageId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCourseEnrollEsignInfoException(msg.toString());
		}

		return courseEnrollEsignInfo;
	}

	/**
	 * Returns the course enroll esign info where packageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param packageId the package ID
	 * @return the matching course enroll esign info, or <code>null</code> if a matching course enroll esign info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollEsignInfo fetchByPackageId(String packageId)
		throws SystemException {
		return fetchByPackageId(packageId, true);
	}

	/**
	 * Returns the course enroll esign info where packageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param packageId the package ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching course enroll esign info, or <code>null</code> if a matching course enroll esign info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollEsignInfo fetchByPackageId(String packageId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { packageId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PACKAGEID,
					finderArgs, this);
		}

		if (result instanceof CourseEnrollEsignInfo) {
			CourseEnrollEsignInfo courseEnrollEsignInfo = (CourseEnrollEsignInfo)result;

			if (!Validator.equals(packageId,
						courseEnrollEsignInfo.getPackageId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_COURSEENROLLESIGNINFO_WHERE);

			boolean bindPackageId = false;

			if (packageId == null) {
				query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_1);
			}
			else if (packageId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_3);
			}
			else {
				bindPackageId = true;

				query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPackageId) {
					qPos.add(packageId);
				}

				List<CourseEnrollEsignInfo> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PACKAGEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CourseEnrollEsignInfoPersistenceImpl.fetchByPackageId(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					CourseEnrollEsignInfo courseEnrollEsignInfo = list.get(0);

					result = courseEnrollEsignInfo;

					cacheResult(courseEnrollEsignInfo);

					if ((courseEnrollEsignInfo.getPackageId() == null) ||
							!courseEnrollEsignInfo.getPackageId()
													  .equals(packageId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PACKAGEID,
							finderArgs, courseEnrollEsignInfo);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PACKAGEID,
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
			return (CourseEnrollEsignInfo)result;
		}
	}

	/**
	 * Removes the course enroll esign info where packageId = &#63; from the database.
	 *
	 * @param packageId the package ID
	 * @return the course enroll esign info that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollEsignInfo removeByPackageId(String packageId)
		throws NoSuchCourseEnrollEsignInfoException, SystemException {
		CourseEnrollEsignInfo courseEnrollEsignInfo = findByPackageId(packageId);

		return remove(courseEnrollEsignInfo);
	}

	/**
	 * Returns the number of course enroll esign infos where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @return the number of matching course enroll esign infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPackageId(String packageId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PACKAGEID;

		Object[] finderArgs = new Object[] { packageId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSEENROLLESIGNINFO_WHERE);

			boolean bindPackageId = false;

			if (packageId == null) {
				query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_1);
			}
			else if (packageId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_3);
			}
			else {
				bindPackageId = true;

				query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPackageId) {
					qPos.add(packageId);
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

	private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_1 = "courseEnrollEsignInfo.packageId IS NULL";
	private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_2 = "courseEnrollEsignInfo.packageId = ?";
	private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_3 = "(courseEnrollEsignInfo.packageId IS NULL OR courseEnrollEsignInfo.packageId = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_DOCUMENTID = new FinderPath(CourseEnrollEsignInfoModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollEsignInfoModelImpl.FINDER_CACHE_ENABLED,
			CourseEnrollEsignInfoImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByDocumentId", new String[] { String.class.getName() },
			CourseEnrollEsignInfoModelImpl.DOCUMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DOCUMENTID = new FinderPath(CourseEnrollEsignInfoModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollEsignInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocumentId",
			new String[] { String.class.getName() });

	/**
	 * Returns the course enroll esign info where documentId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException} if it could not be found.
	 *
	 * @param documentId the document ID
	 * @return the matching course enroll esign info
	 * @throws com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException if a matching course enroll esign info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollEsignInfo findByDocumentId(String documentId)
		throws NoSuchCourseEnrollEsignInfoException, SystemException {
		CourseEnrollEsignInfo courseEnrollEsignInfo = fetchByDocumentId(documentId);

		if (courseEnrollEsignInfo == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("documentId=");
			msg.append(documentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCourseEnrollEsignInfoException(msg.toString());
		}

		return courseEnrollEsignInfo;
	}

	/**
	 * Returns the course enroll esign info where documentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param documentId the document ID
	 * @return the matching course enroll esign info, or <code>null</code> if a matching course enroll esign info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollEsignInfo fetchByDocumentId(String documentId)
		throws SystemException {
		return fetchByDocumentId(documentId, true);
	}

	/**
	 * Returns the course enroll esign info where documentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param documentId the document ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching course enroll esign info, or <code>null</code> if a matching course enroll esign info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollEsignInfo fetchByDocumentId(String documentId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { documentId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_DOCUMENTID,
					finderArgs, this);
		}

		if (result instanceof CourseEnrollEsignInfo) {
			CourseEnrollEsignInfo courseEnrollEsignInfo = (CourseEnrollEsignInfo)result;

			if (!Validator.equals(documentId,
						courseEnrollEsignInfo.getDocumentId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_COURSEENROLLESIGNINFO_WHERE);

			boolean bindDocumentId = false;

			if (documentId == null) {
				query.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_1);
			}
			else if (documentId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_3);
			}
			else {
				bindDocumentId = true;

				query.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDocumentId) {
					qPos.add(documentId);
				}

				List<CourseEnrollEsignInfo> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DOCUMENTID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CourseEnrollEsignInfoPersistenceImpl.fetchByDocumentId(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					CourseEnrollEsignInfo courseEnrollEsignInfo = list.get(0);

					result = courseEnrollEsignInfo;

					cacheResult(courseEnrollEsignInfo);

					if ((courseEnrollEsignInfo.getDocumentId() == null) ||
							!courseEnrollEsignInfo.getDocumentId()
													  .equals(documentId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DOCUMENTID,
							finderArgs, courseEnrollEsignInfo);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DOCUMENTID,
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
			return (CourseEnrollEsignInfo)result;
		}
	}

	/**
	 * Removes the course enroll esign info where documentId = &#63; from the database.
	 *
	 * @param documentId the document ID
	 * @return the course enroll esign info that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollEsignInfo removeByDocumentId(String documentId)
		throws NoSuchCourseEnrollEsignInfoException, SystemException {
		CourseEnrollEsignInfo courseEnrollEsignInfo = findByDocumentId(documentId);

		return remove(courseEnrollEsignInfo);
	}

	/**
	 * Returns the number of course enroll esign infos where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the number of matching course enroll esign infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDocumentId(String documentId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DOCUMENTID;

		Object[] finderArgs = new Object[] { documentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSEENROLLESIGNINFO_WHERE);

			boolean bindDocumentId = false;

			if (documentId == null) {
				query.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_1);
			}
			else if (documentId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_3);
			}
			else {
				bindDocumentId = true;

				query.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDocumentId) {
					qPos.add(documentId);
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

	private static final String _FINDER_COLUMN_DOCUMENTID_DOCUMENTID_1 = "courseEnrollEsignInfo.documentId IS NULL";
	private static final String _FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2 = "courseEnrollEsignInfo.documentId = ?";
	private static final String _FINDER_COLUMN_DOCUMENTID_DOCUMENTID_3 = "(courseEnrollEsignInfo.documentId IS NULL OR courseEnrollEsignInfo.documentId = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROCESSSTATEID = new FinderPath(CourseEnrollEsignInfoModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollEsignInfoModelImpl.FINDER_CACHE_ENABLED,
			CourseEnrollEsignInfoImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByProcessStateId", new String[] { Long.class.getName() },
			CourseEnrollEsignInfoModelImpl.SPPEPROCESSSTATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROCESSSTATEID = new FinderPath(CourseEnrollEsignInfoModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollEsignInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProcessStateId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the course enroll esign info where spPEProcessStateId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException} if it could not be found.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @return the matching course enroll esign info
	 * @throws com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException if a matching course enroll esign info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollEsignInfo findByProcessStateId(long spPEProcessStateId)
		throws NoSuchCourseEnrollEsignInfoException, SystemException {
		CourseEnrollEsignInfo courseEnrollEsignInfo = fetchByProcessStateId(spPEProcessStateId);

		if (courseEnrollEsignInfo == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("spPEProcessStateId=");
			msg.append(spPEProcessStateId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCourseEnrollEsignInfoException(msg.toString());
		}

		return courseEnrollEsignInfo;
	}

	/**
	 * Returns the course enroll esign info where spPEProcessStateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @return the matching course enroll esign info, or <code>null</code> if a matching course enroll esign info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollEsignInfo fetchByProcessStateId(long spPEProcessStateId)
		throws SystemException {
		return fetchByProcessStateId(spPEProcessStateId, true);
	}

	/**
	 * Returns the course enroll esign info where spPEProcessStateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching course enroll esign info, or <code>null</code> if a matching course enroll esign info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollEsignInfo fetchByProcessStateId(
		long spPEProcessStateId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { spPEProcessStateId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PROCESSSTATEID,
					finderArgs, this);
		}

		if (result instanceof CourseEnrollEsignInfo) {
			CourseEnrollEsignInfo courseEnrollEsignInfo = (CourseEnrollEsignInfo)result;

			if ((spPEProcessStateId != courseEnrollEsignInfo.getSpPEProcessStateId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_COURSEENROLLESIGNINFO_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTATEID_SPPEPROCESSSTATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessStateId);

				List<CourseEnrollEsignInfo> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSSTATEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CourseEnrollEsignInfoPersistenceImpl.fetchByProcessStateId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					CourseEnrollEsignInfo courseEnrollEsignInfo = list.get(0);

					result = courseEnrollEsignInfo;

					cacheResult(courseEnrollEsignInfo);

					if ((courseEnrollEsignInfo.getSpPEProcessStateId() != spPEProcessStateId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSSTATEID,
							finderArgs, courseEnrollEsignInfo);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROCESSSTATEID,
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
			return (CourseEnrollEsignInfo)result;
		}
	}

	/**
	 * Removes the course enroll esign info where spPEProcessStateId = &#63; from the database.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @return the course enroll esign info that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollEsignInfo removeByProcessStateId(long spPEProcessStateId)
		throws NoSuchCourseEnrollEsignInfoException, SystemException {
		CourseEnrollEsignInfo courseEnrollEsignInfo = findByProcessStateId(spPEProcessStateId);

		return remove(courseEnrollEsignInfo);
	}

	/**
	 * Returns the number of course enroll esign infos where spPEProcessStateId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @return the number of matching course enroll esign infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProcessStateId(long spPEProcessStateId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROCESSSTATEID;

		Object[] finderArgs = new Object[] { spPEProcessStateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSEENROLLESIGNINFO_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTATEID_SPPEPROCESSSTATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessStateId);

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

	private static final String _FINDER_COLUMN_PROCESSSTATEID_SPPEPROCESSSTATEID_2 =
		"courseEnrollEsignInfo.spPEProcessStateId = ?";

	public CourseEnrollEsignInfoPersistenceImpl() {
		setModelClass(CourseEnrollEsignInfo.class);
	}

	/**
	 * Caches the course enroll esign info in the entity cache if it is enabled.
	 *
	 * @param courseEnrollEsignInfo the course enroll esign info
	 */
	@Override
	public void cacheResult(CourseEnrollEsignInfo courseEnrollEsignInfo) {
		EntityCacheUtil.putResult(CourseEnrollEsignInfoModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollEsignInfoImpl.class,
			courseEnrollEsignInfo.getPrimaryKey(), courseEnrollEsignInfo);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SIGNERID,
			new Object[] { courseEnrollEsignInfo.getSignerId() },
			courseEnrollEsignInfo);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PACKAGEID,
			new Object[] { courseEnrollEsignInfo.getPackageId() },
			courseEnrollEsignInfo);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DOCUMENTID,
			new Object[] { courseEnrollEsignInfo.getDocumentId() },
			courseEnrollEsignInfo);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSSTATEID,
			new Object[] { courseEnrollEsignInfo.getSpPEProcessStateId() },
			courseEnrollEsignInfo);

		courseEnrollEsignInfo.resetOriginalValues();
	}

	/**
	 * Caches the course enroll esign infos in the entity cache if it is enabled.
	 *
	 * @param courseEnrollEsignInfos the course enroll esign infos
	 */
	@Override
	public void cacheResult(List<CourseEnrollEsignInfo> courseEnrollEsignInfos) {
		for (CourseEnrollEsignInfo courseEnrollEsignInfo : courseEnrollEsignInfos) {
			if (EntityCacheUtil.getResult(
						CourseEnrollEsignInfoModelImpl.ENTITY_CACHE_ENABLED,
						CourseEnrollEsignInfoImpl.class,
						courseEnrollEsignInfo.getPrimaryKey()) == null) {
				cacheResult(courseEnrollEsignInfo);
			}
			else {
				courseEnrollEsignInfo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all course enroll esign infos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CourseEnrollEsignInfoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CourseEnrollEsignInfoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the course enroll esign info.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CourseEnrollEsignInfo courseEnrollEsignInfo) {
		EntityCacheUtil.removeResult(CourseEnrollEsignInfoModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollEsignInfoImpl.class,
			courseEnrollEsignInfo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(courseEnrollEsignInfo);
	}

	@Override
	public void clearCache(List<CourseEnrollEsignInfo> courseEnrollEsignInfos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CourseEnrollEsignInfo courseEnrollEsignInfo : courseEnrollEsignInfos) {
			EntityCacheUtil.removeResult(CourseEnrollEsignInfoModelImpl.ENTITY_CACHE_ENABLED,
				CourseEnrollEsignInfoImpl.class,
				courseEnrollEsignInfo.getPrimaryKey());

			clearUniqueFindersCache(courseEnrollEsignInfo);
		}
	}

	protected void cacheUniqueFindersCache(
		CourseEnrollEsignInfo courseEnrollEsignInfo) {
		if (courseEnrollEsignInfo.isNew()) {
			Object[] args = new Object[] { courseEnrollEsignInfo.getSignerId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SIGNERID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SIGNERID, args,
				courseEnrollEsignInfo);

			args = new Object[] { courseEnrollEsignInfo.getPackageId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PACKAGEID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PACKAGEID, args,
				courseEnrollEsignInfo);

			args = new Object[] { courseEnrollEsignInfo.getDocumentId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DOCUMENTID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DOCUMENTID, args,
				courseEnrollEsignInfo);

			args = new Object[] { courseEnrollEsignInfo.getSpPEProcessStateId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROCESSSTATEID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSSTATEID,
				args, courseEnrollEsignInfo);
		}
		else {
			CourseEnrollEsignInfoModelImpl courseEnrollEsignInfoModelImpl = (CourseEnrollEsignInfoModelImpl)courseEnrollEsignInfo;

			if ((courseEnrollEsignInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SIGNERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { courseEnrollEsignInfo.getSignerId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SIGNERID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SIGNERID, args,
					courseEnrollEsignInfo);
			}

			if ((courseEnrollEsignInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PACKAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseEnrollEsignInfo.getPackageId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PACKAGEID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PACKAGEID, args,
					courseEnrollEsignInfo);
			}

			if ((courseEnrollEsignInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_DOCUMENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseEnrollEsignInfo.getDocumentId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DOCUMENTID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DOCUMENTID,
					args, courseEnrollEsignInfo);
			}

			if ((courseEnrollEsignInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PROCESSSTATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseEnrollEsignInfo.getSpPEProcessStateId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROCESSSTATEID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSSTATEID,
					args, courseEnrollEsignInfo);
			}
		}
	}

	protected void clearUniqueFindersCache(
		CourseEnrollEsignInfo courseEnrollEsignInfo) {
		CourseEnrollEsignInfoModelImpl courseEnrollEsignInfoModelImpl = (CourseEnrollEsignInfoModelImpl)courseEnrollEsignInfo;

		Object[] args = new Object[] { courseEnrollEsignInfo.getSignerId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SIGNERID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SIGNERID, args);

		if ((courseEnrollEsignInfoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SIGNERID.getColumnBitmask()) != 0) {
			args = new Object[] {
					courseEnrollEsignInfoModelImpl.getOriginalSignerId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SIGNERID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SIGNERID, args);
		}

		args = new Object[] { courseEnrollEsignInfo.getPackageId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PACKAGEID, args);

		if ((courseEnrollEsignInfoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PACKAGEID.getColumnBitmask()) != 0) {
			args = new Object[] {
					courseEnrollEsignInfoModelImpl.getOriginalPackageId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PACKAGEID, args);
		}

		args = new Object[] { courseEnrollEsignInfo.getDocumentId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOCUMENTID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DOCUMENTID, args);

		if ((courseEnrollEsignInfoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_DOCUMENTID.getColumnBitmask()) != 0) {
			args = new Object[] {
					courseEnrollEsignInfoModelImpl.getOriginalDocumentId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOCUMENTID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DOCUMENTID, args);
		}

		args = new Object[] { courseEnrollEsignInfo.getSpPEProcessStateId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTATEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROCESSSTATEID, args);

		if ((courseEnrollEsignInfoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROCESSSTATEID.getColumnBitmask()) != 0) {
			args = new Object[] {
					courseEnrollEsignInfoModelImpl.getOriginalSpPEProcessStateId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTATEID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROCESSSTATEID,
				args);
		}
	}

	/**
	 * Creates a new course enroll esign info with the primary key. Does not add the course enroll esign info to the database.
	 *
	 * @param spEsignInfoId the primary key for the new course enroll esign info
	 * @return the new course enroll esign info
	 */
	@Override
	public CourseEnrollEsignInfo create(long spEsignInfoId) {
		CourseEnrollEsignInfo courseEnrollEsignInfo = new CourseEnrollEsignInfoImpl();

		courseEnrollEsignInfo.setNew(true);
		courseEnrollEsignInfo.setPrimaryKey(spEsignInfoId);

		return courseEnrollEsignInfo;
	}

	/**
	 * Removes the course enroll esign info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spEsignInfoId the primary key of the course enroll esign info
	 * @return the course enroll esign info that was removed
	 * @throws com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException if a course enroll esign info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollEsignInfo remove(long spEsignInfoId)
		throws NoSuchCourseEnrollEsignInfoException, SystemException {
		return remove((Serializable)spEsignInfoId);
	}

	/**
	 * Removes the course enroll esign info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the course enroll esign info
	 * @return the course enroll esign info that was removed
	 * @throws com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException if a course enroll esign info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollEsignInfo remove(Serializable primaryKey)
		throws NoSuchCourseEnrollEsignInfoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CourseEnrollEsignInfo courseEnrollEsignInfo = (CourseEnrollEsignInfo)session.get(CourseEnrollEsignInfoImpl.class,
					primaryKey);

			if (courseEnrollEsignInfo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCourseEnrollEsignInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(courseEnrollEsignInfo);
		}
		catch (NoSuchCourseEnrollEsignInfoException nsee) {
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
	protected CourseEnrollEsignInfo removeImpl(
		CourseEnrollEsignInfo courseEnrollEsignInfo) throws SystemException {
		courseEnrollEsignInfo = toUnwrappedModel(courseEnrollEsignInfo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(courseEnrollEsignInfo)) {
				courseEnrollEsignInfo = (CourseEnrollEsignInfo)session.get(CourseEnrollEsignInfoImpl.class,
						courseEnrollEsignInfo.getPrimaryKeyObj());
			}

			if (courseEnrollEsignInfo != null) {
				session.delete(courseEnrollEsignInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (courseEnrollEsignInfo != null) {
			clearCache(courseEnrollEsignInfo);
		}

		return courseEnrollEsignInfo;
	}

	@Override
	public CourseEnrollEsignInfo updateImpl(
		com.sambaash.platform.srv.model.CourseEnrollEsignInfo courseEnrollEsignInfo)
		throws SystemException {
		courseEnrollEsignInfo = toUnwrappedModel(courseEnrollEsignInfo);

		boolean isNew = courseEnrollEsignInfo.isNew();

		Session session = null;

		try {
			session = openSession();

			if (courseEnrollEsignInfo.isNew()) {
				session.save(courseEnrollEsignInfo);

				courseEnrollEsignInfo.setNew(false);
			}
			else {
				session.merge(courseEnrollEsignInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CourseEnrollEsignInfoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(CourseEnrollEsignInfoModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollEsignInfoImpl.class,
			courseEnrollEsignInfo.getPrimaryKey(), courseEnrollEsignInfo);

		clearUniqueFindersCache(courseEnrollEsignInfo);
		cacheUniqueFindersCache(courseEnrollEsignInfo);

		return courseEnrollEsignInfo;
	}

	protected CourseEnrollEsignInfo toUnwrappedModel(
		CourseEnrollEsignInfo courseEnrollEsignInfo) {
		if (courseEnrollEsignInfo instanceof CourseEnrollEsignInfoImpl) {
			return courseEnrollEsignInfo;
		}

		CourseEnrollEsignInfoImpl courseEnrollEsignInfoImpl = new CourseEnrollEsignInfoImpl();

		courseEnrollEsignInfoImpl.setNew(courseEnrollEsignInfo.isNew());
		courseEnrollEsignInfoImpl.setPrimaryKey(courseEnrollEsignInfo.getPrimaryKey());

		courseEnrollEsignInfoImpl.setSpEsignInfoId(courseEnrollEsignInfo.getSpEsignInfoId());
		courseEnrollEsignInfoImpl.setGroupId(courseEnrollEsignInfo.getGroupId());
		courseEnrollEsignInfoImpl.setCompanyId(courseEnrollEsignInfo.getCompanyId());
		courseEnrollEsignInfoImpl.setUserId(courseEnrollEsignInfo.getUserId());
		courseEnrollEsignInfoImpl.setUserName(courseEnrollEsignInfo.getUserName());
		courseEnrollEsignInfoImpl.setCreateDate(courseEnrollEsignInfo.getCreateDate());
		courseEnrollEsignInfoImpl.setModifiedDate(courseEnrollEsignInfo.getModifiedDate());
		courseEnrollEsignInfoImpl.setSignerId(courseEnrollEsignInfo.getSignerId());
		courseEnrollEsignInfoImpl.setPackageId(courseEnrollEsignInfo.getPackageId());
		courseEnrollEsignInfoImpl.setDocumentId(courseEnrollEsignInfo.getDocumentId());
		courseEnrollEsignInfoImpl.setLastGeneratedUrl(courseEnrollEsignInfo.getLastGeneratedUrl());
		courseEnrollEsignInfoImpl.setSpPEProcessStateId(courseEnrollEsignInfo.getSpPEProcessStateId());
		courseEnrollEsignInfoImpl.setExtraInfo(courseEnrollEsignInfo.getExtraInfo());

		return courseEnrollEsignInfoImpl;
	}

	/**
	 * Returns the course enroll esign info with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the course enroll esign info
	 * @return the course enroll esign info
	 * @throws com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException if a course enroll esign info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollEsignInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCourseEnrollEsignInfoException, SystemException {
		CourseEnrollEsignInfo courseEnrollEsignInfo = fetchByPrimaryKey(primaryKey);

		if (courseEnrollEsignInfo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCourseEnrollEsignInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return courseEnrollEsignInfo;
	}

	/**
	 * Returns the course enroll esign info with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException} if it could not be found.
	 *
	 * @param spEsignInfoId the primary key of the course enroll esign info
	 * @return the course enroll esign info
	 * @throws com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException if a course enroll esign info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollEsignInfo findByPrimaryKey(long spEsignInfoId)
		throws NoSuchCourseEnrollEsignInfoException, SystemException {
		return findByPrimaryKey((Serializable)spEsignInfoId);
	}

	/**
	 * Returns the course enroll esign info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the course enroll esign info
	 * @return the course enroll esign info, or <code>null</code> if a course enroll esign info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollEsignInfo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CourseEnrollEsignInfo courseEnrollEsignInfo = (CourseEnrollEsignInfo)EntityCacheUtil.getResult(CourseEnrollEsignInfoModelImpl.ENTITY_CACHE_ENABLED,
				CourseEnrollEsignInfoImpl.class, primaryKey);

		if (courseEnrollEsignInfo == _nullCourseEnrollEsignInfo) {
			return null;
		}

		if (courseEnrollEsignInfo == null) {
			Session session = null;

			try {
				session = openSession();

				courseEnrollEsignInfo = (CourseEnrollEsignInfo)session.get(CourseEnrollEsignInfoImpl.class,
						primaryKey);

				if (courseEnrollEsignInfo != null) {
					cacheResult(courseEnrollEsignInfo);
				}
				else {
					EntityCacheUtil.putResult(CourseEnrollEsignInfoModelImpl.ENTITY_CACHE_ENABLED,
						CourseEnrollEsignInfoImpl.class, primaryKey,
						_nullCourseEnrollEsignInfo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CourseEnrollEsignInfoModelImpl.ENTITY_CACHE_ENABLED,
					CourseEnrollEsignInfoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return courseEnrollEsignInfo;
	}

	/**
	 * Returns the course enroll esign info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spEsignInfoId the primary key of the course enroll esign info
	 * @return the course enroll esign info, or <code>null</code> if a course enroll esign info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollEsignInfo fetchByPrimaryKey(long spEsignInfoId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spEsignInfoId);
	}

	/**
	 * Returns all the course enroll esign infos.
	 *
	 * @return the course enroll esign infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseEnrollEsignInfo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the course enroll esign infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseEnrollEsignInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of course enroll esign infos
	 * @param end the upper bound of the range of course enroll esign infos (not inclusive)
	 * @return the range of course enroll esign infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseEnrollEsignInfo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the course enroll esign infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseEnrollEsignInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of course enroll esign infos
	 * @param end the upper bound of the range of course enroll esign infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of course enroll esign infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseEnrollEsignInfo> findAll(int start, int end,
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

		List<CourseEnrollEsignInfo> list = (List<CourseEnrollEsignInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COURSEENROLLESIGNINFO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COURSEENROLLESIGNINFO;

				if (pagination) {
					sql = sql.concat(CourseEnrollEsignInfoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CourseEnrollEsignInfo>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseEnrollEsignInfo>(list);
				}
				else {
					list = (List<CourseEnrollEsignInfo>)QueryUtil.list(q,
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
	 * Removes all the course enroll esign infos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CourseEnrollEsignInfo courseEnrollEsignInfo : findAll()) {
			remove(courseEnrollEsignInfo);
		}
	}

	/**
	 * Returns the number of course enroll esign infos.
	 *
	 * @return the number of course enroll esign infos
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

				Query q = session.createQuery(_SQL_COUNT_COURSEENROLLESIGNINFO);

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
	 * Initializes the course enroll esign info persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.CourseEnrollEsignInfo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CourseEnrollEsignInfo>> listenersList = new ArrayList<ModelListener<CourseEnrollEsignInfo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CourseEnrollEsignInfo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CourseEnrollEsignInfoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COURSEENROLLESIGNINFO = "SELECT courseEnrollEsignInfo FROM CourseEnrollEsignInfo courseEnrollEsignInfo";
	private static final String _SQL_SELECT_COURSEENROLLESIGNINFO_WHERE = "SELECT courseEnrollEsignInfo FROM CourseEnrollEsignInfo courseEnrollEsignInfo WHERE ";
	private static final String _SQL_COUNT_COURSEENROLLESIGNINFO = "SELECT COUNT(courseEnrollEsignInfo) FROM CourseEnrollEsignInfo courseEnrollEsignInfo";
	private static final String _SQL_COUNT_COURSEENROLLESIGNINFO_WHERE = "SELECT COUNT(courseEnrollEsignInfo) FROM CourseEnrollEsignInfo courseEnrollEsignInfo WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "courseEnrollEsignInfo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CourseEnrollEsignInfo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CourseEnrollEsignInfo exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CourseEnrollEsignInfoPersistenceImpl.class);
	private static CourseEnrollEsignInfo _nullCourseEnrollEsignInfo = new CourseEnrollEsignInfoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CourseEnrollEsignInfo> toCacheModel() {
				return _nullCourseEnrollEsignInfoCacheModel;
			}
		};

	private static CacheModel<CourseEnrollEsignInfo> _nullCourseEnrollEsignInfoCacheModel =
		new CacheModel<CourseEnrollEsignInfo>() {
			@Override
			public CourseEnrollEsignInfo toEntityModel() {
				return _nullCourseEnrollEsignInfo;
			}
		};
}