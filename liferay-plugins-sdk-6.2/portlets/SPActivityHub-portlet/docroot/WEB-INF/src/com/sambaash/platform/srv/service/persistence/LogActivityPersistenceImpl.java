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

import com.sambaash.platform.srv.NoSuchLogActivityException;
import com.sambaash.platform.srv.model.LogActivity;
import com.sambaash.platform.srv.model.impl.LogActivityImpl;
import com.sambaash.platform.srv.model.impl.LogActivityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the log activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author aishwarya
 * @see LogActivityPersistence
 * @see LogActivityUtil
 * @generated
 */
public class LogActivityPersistenceImpl extends BasePersistenceImpl<LogActivity>
	implements LogActivityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LogActivityUtil} to access the log activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LogActivityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LogActivityModelImpl.ENTITY_CACHE_ENABLED,
			LogActivityModelImpl.FINDER_CACHE_ENABLED, LogActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LogActivityModelImpl.ENTITY_CACHE_ENABLED,
			LogActivityModelImpl.FINDER_CACHE_ENABLED, LogActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LogActivityModelImpl.ENTITY_CACHE_ENABLED,
			LogActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID =
		new FinderPath(LogActivityModelImpl.ENTITY_CACHE_ENABLED,
			LogActivityModelImpl.FINDER_CACHE_ENABLED, LogActivityImpl.class,
			FINDER_CLASS_NAME_ENTITY,
			"fetchByentityClassIdEntityIdParentLogActivityId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			LogActivityModelImpl.ENTITYCLASSID_COLUMN_BITMASK |
			LogActivityModelImpl.ENTITYID_COLUMN_BITMASK |
			LogActivityModelImpl.PARENTLOGACTIVITYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID =
		new FinderPath(LogActivityModelImpl.ENTITY_CACHE_ENABLED,
			LogActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByentityClassIdEntityIdParentLogActivityId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the log activity where entityClassId = &#63; and entityId = &#63; and parentLogActivityId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchLogActivityException} if it could not be found.
	 *
	 * @param entityClassId the entity class ID
	 * @param entityId the entity ID
	 * @param parentLogActivityId the parent log activity ID
	 * @return the matching log activity
	 * @throws com.sambaash.platform.srv.NoSuchLogActivityException if a matching log activity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogActivity findByentityClassIdEntityIdParentLogActivityId(
		long entityClassId, long entityId, long parentLogActivityId)
		throws NoSuchLogActivityException, SystemException {
		LogActivity logActivity = fetchByentityClassIdEntityIdParentLogActivityId(entityClassId,
				entityId, parentLogActivityId);

		if (logActivity == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("entityClassId=");
			msg.append(entityClassId);

			msg.append(", entityId=");
			msg.append(entityId);

			msg.append(", parentLogActivityId=");
			msg.append(parentLogActivityId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLogActivityException(msg.toString());
		}

		return logActivity;
	}

	/**
	 * Returns the log activity where entityClassId = &#63; and entityId = &#63; and parentLogActivityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param entityClassId the entity class ID
	 * @param entityId the entity ID
	 * @param parentLogActivityId the parent log activity ID
	 * @return the matching log activity, or <code>null</code> if a matching log activity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogActivity fetchByentityClassIdEntityIdParentLogActivityId(
		long entityClassId, long entityId, long parentLogActivityId)
		throws SystemException {
		return fetchByentityClassIdEntityIdParentLogActivityId(entityClassId,
			entityId, parentLogActivityId, true);
	}

	/**
	 * Returns the log activity where entityClassId = &#63; and entityId = &#63; and parentLogActivityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param entityClassId the entity class ID
	 * @param entityId the entity ID
	 * @param parentLogActivityId the parent log activity ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching log activity, or <code>null</code> if a matching log activity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogActivity fetchByentityClassIdEntityIdParentLogActivityId(
		long entityClassId, long entityId, long parentLogActivityId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				entityClassId, entityId, parentLogActivityId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID,
					finderArgs, this);
		}

		if (result instanceof LogActivity) {
			LogActivity logActivity = (LogActivity)result;

			if ((entityClassId != logActivity.getEntityClassId()) ||
					(entityId != logActivity.getEntityId()) ||
					(parentLogActivityId != logActivity.getParentLogActivityId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_LOGACTIVITY_WHERE);

			query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID_ENTITYCLASSID_2);

			query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID_ENTITYID_2);

			query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID_PARENTLOGACTIVITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entityClassId);

				qPos.add(entityId);

				qPos.add(parentLogActivityId);

				List<LogActivity> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LogActivityPersistenceImpl.fetchByentityClassIdEntityIdParentLogActivityId(long, long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LogActivity logActivity = list.get(0);

					result = logActivity;

					cacheResult(logActivity);

					if ((logActivity.getEntityClassId() != entityClassId) ||
							(logActivity.getEntityId() != entityId) ||
							(logActivity.getParentLogActivityId() != parentLogActivityId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID,
							finderArgs, logActivity);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID,
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
			return (LogActivity)result;
		}
	}

	/**
	 * Removes the log activity where entityClassId = &#63; and entityId = &#63; and parentLogActivityId = &#63; from the database.
	 *
	 * @param entityClassId the entity class ID
	 * @param entityId the entity ID
	 * @param parentLogActivityId the parent log activity ID
	 * @return the log activity that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogActivity removeByentityClassIdEntityIdParentLogActivityId(
		long entityClassId, long entityId, long parentLogActivityId)
		throws NoSuchLogActivityException, SystemException {
		LogActivity logActivity = findByentityClassIdEntityIdParentLogActivityId(entityClassId,
				entityId, parentLogActivityId);

		return remove(logActivity);
	}

	/**
	 * Returns the number of log activities where entityClassId = &#63; and entityId = &#63; and parentLogActivityId = &#63;.
	 *
	 * @param entityClassId the entity class ID
	 * @param entityId the entity ID
	 * @param parentLogActivityId the parent log activity ID
	 * @return the number of matching log activities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByentityClassIdEntityIdParentLogActivityId(
		long entityClassId, long entityId, long parentLogActivityId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID;

		Object[] finderArgs = new Object[] {
				entityClassId, entityId, parentLogActivityId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LOGACTIVITY_WHERE);

			query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID_ENTITYCLASSID_2);

			query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID_ENTITYID_2);

			query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID_PARENTLOGACTIVITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entityClassId);

				qPos.add(entityId);

				qPos.add(parentLogActivityId);

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

	private static final String _FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID_ENTITYCLASSID_2 =
		"logActivity.entityClassId = ? AND ";
	private static final String _FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID_ENTITYID_2 =
		"logActivity.entityId = ? AND ";
	private static final String _FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID_PARENTLOGACTIVITYID_2 =
		"logActivity.parentLogActivityId = ?";

	public LogActivityPersistenceImpl() {
		setModelClass(LogActivity.class);
	}

	/**
	 * Caches the log activity in the entity cache if it is enabled.
	 *
	 * @param logActivity the log activity
	 */
	@Override
	public void cacheResult(LogActivity logActivity) {
		EntityCacheUtil.putResult(LogActivityModelImpl.ENTITY_CACHE_ENABLED,
			LogActivityImpl.class, logActivity.getPrimaryKey(), logActivity);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID,
			new Object[] {
				logActivity.getEntityClassId(), logActivity.getEntityId(),
				logActivity.getParentLogActivityId()
			}, logActivity);

		logActivity.resetOriginalValues();
	}

	/**
	 * Caches the log activities in the entity cache if it is enabled.
	 *
	 * @param logActivities the log activities
	 */
	@Override
	public void cacheResult(List<LogActivity> logActivities) {
		for (LogActivity logActivity : logActivities) {
			if (EntityCacheUtil.getResult(
						LogActivityModelImpl.ENTITY_CACHE_ENABLED,
						LogActivityImpl.class, logActivity.getPrimaryKey()) == null) {
				cacheResult(logActivity);
			}
			else {
				logActivity.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all log activities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LogActivityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LogActivityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the log activity.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LogActivity logActivity) {
		EntityCacheUtil.removeResult(LogActivityModelImpl.ENTITY_CACHE_ENABLED,
			LogActivityImpl.class, logActivity.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(logActivity);
	}

	@Override
	public void clearCache(List<LogActivity> logActivities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LogActivity logActivity : logActivities) {
			EntityCacheUtil.removeResult(LogActivityModelImpl.ENTITY_CACHE_ENABLED,
				LogActivityImpl.class, logActivity.getPrimaryKey());

			clearUniqueFindersCache(logActivity);
		}
	}

	protected void cacheUniqueFindersCache(LogActivity logActivity) {
		if (logActivity.isNew()) {
			Object[] args = new Object[] {
					logActivity.getEntityClassId(), logActivity.getEntityId(),
					logActivity.getParentLogActivityId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID,
				args, logActivity);
		}
		else {
			LogActivityModelImpl logActivityModelImpl = (LogActivityModelImpl)logActivity;

			if ((logActivityModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						logActivity.getEntityClassId(),
						logActivity.getEntityId(),
						logActivity.getParentLogActivityId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID,
					args, logActivity);
			}
		}
	}

	protected void clearUniqueFindersCache(LogActivity logActivity) {
		LogActivityModelImpl logActivityModelImpl = (LogActivityModelImpl)logActivity;

		Object[] args = new Object[] {
				logActivity.getEntityClassId(), logActivity.getEntityId(),
				logActivity.getParentLogActivityId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID,
			args);

		if ((logActivityModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID.getColumnBitmask()) != 0) {
			args = new Object[] {
					logActivityModelImpl.getOriginalEntityClassId(),
					logActivityModelImpl.getOriginalEntityId(),
					logActivityModelImpl.getOriginalParentLogActivityId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTLOGACTIVITYID,
				args);
		}
	}

	/**
	 * Creates a new log activity with the primary key. Does not add the log activity to the database.
	 *
	 * @param spLogActivityId the primary key for the new log activity
	 * @return the new log activity
	 */
	@Override
	public LogActivity create(long spLogActivityId) {
		LogActivity logActivity = new LogActivityImpl();

		logActivity.setNew(true);
		logActivity.setPrimaryKey(spLogActivityId);

		return logActivity;
	}

	/**
	 * Removes the log activity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spLogActivityId the primary key of the log activity
	 * @return the log activity that was removed
	 * @throws com.sambaash.platform.srv.NoSuchLogActivityException if a log activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogActivity remove(long spLogActivityId)
		throws NoSuchLogActivityException, SystemException {
		return remove((Serializable)spLogActivityId);
	}

	/**
	 * Removes the log activity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the log activity
	 * @return the log activity that was removed
	 * @throws com.sambaash.platform.srv.NoSuchLogActivityException if a log activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogActivity remove(Serializable primaryKey)
		throws NoSuchLogActivityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LogActivity logActivity = (LogActivity)session.get(LogActivityImpl.class,
					primaryKey);

			if (logActivity == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLogActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(logActivity);
		}
		catch (NoSuchLogActivityException nsee) {
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
	protected LogActivity removeImpl(LogActivity logActivity)
		throws SystemException {
		logActivity = toUnwrappedModel(logActivity);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(logActivity)) {
				logActivity = (LogActivity)session.get(LogActivityImpl.class,
						logActivity.getPrimaryKeyObj());
			}

			if (logActivity != null) {
				session.delete(logActivity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (logActivity != null) {
			clearCache(logActivity);
		}

		return logActivity;
	}

	@Override
	public LogActivity updateImpl(
		com.sambaash.platform.srv.model.LogActivity logActivity)
		throws SystemException {
		logActivity = toUnwrappedModel(logActivity);

		boolean isNew = logActivity.isNew();

		Session session = null;

		try {
			session = openSession();

			if (logActivity.isNew()) {
				session.save(logActivity);

				logActivity.setNew(false);
			}
			else {
				session.merge(logActivity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LogActivityModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(LogActivityModelImpl.ENTITY_CACHE_ENABLED,
			LogActivityImpl.class, logActivity.getPrimaryKey(), logActivity);

		clearUniqueFindersCache(logActivity);
		cacheUniqueFindersCache(logActivity);

		return logActivity;
	}

	protected LogActivity toUnwrappedModel(LogActivity logActivity) {
		if (logActivity instanceof LogActivityImpl) {
			return logActivity;
		}

		LogActivityImpl logActivityImpl = new LogActivityImpl();

		logActivityImpl.setNew(logActivity.isNew());
		logActivityImpl.setPrimaryKey(logActivity.getPrimaryKey());

		logActivityImpl.setSpLogActivityId(logActivity.getSpLogActivityId());
		logActivityImpl.setGroupId(logActivity.getGroupId());
		logActivityImpl.setCompanyId(logActivity.getCompanyId());
		logActivityImpl.setUserId(logActivity.getUserId());
		logActivityImpl.setUserName(logActivity.getUserName());
		logActivityImpl.setCreateDate(logActivity.getCreateDate());
		logActivityImpl.setModifiedDate(logActivity.getModifiedDate());
		logActivityImpl.setEntityClassId(logActivity.getEntityClassId());
		logActivityImpl.setEntityClassName(logActivity.getEntityClassName());
		logActivityImpl.setEntityId(logActivity.getEntityId());
		logActivityImpl.setSavedByUserId(logActivity.getSavedByUserId());
		logActivityImpl.setActivityTitle(logActivity.getActivityTitle());
		logActivityImpl.setActivityType(logActivity.getActivityType());
		logActivityImpl.setActivityOutcome(logActivity.getActivityOutcome());
		logActivityImpl.setActivityDate(logActivity.getActivityDate());
		logActivityImpl.setActivityTime(logActivity.getActivityTime());
		logActivityImpl.setActivityContent(logActivity.getActivityContent());
		logActivityImpl.setFileEntryId(logActivity.getFileEntryId());
		logActivityImpl.setAssociatedWith(logActivity.getAssociatedWith());
		logActivityImpl.setStatus(logActivity.getStatus());
		logActivityImpl.setParentLogActivityId(logActivity.getParentLogActivityId());

		return logActivityImpl;
	}

	/**
	 * Returns the log activity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the log activity
	 * @return the log activity
	 * @throws com.sambaash.platform.srv.NoSuchLogActivityException if a log activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogActivity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLogActivityException, SystemException {
		LogActivity logActivity = fetchByPrimaryKey(primaryKey);

		if (logActivity == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLogActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return logActivity;
	}

	/**
	 * Returns the log activity with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchLogActivityException} if it could not be found.
	 *
	 * @param spLogActivityId the primary key of the log activity
	 * @return the log activity
	 * @throws com.sambaash.platform.srv.NoSuchLogActivityException if a log activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogActivity findByPrimaryKey(long spLogActivityId)
		throws NoSuchLogActivityException, SystemException {
		return findByPrimaryKey((Serializable)spLogActivityId);
	}

	/**
	 * Returns the log activity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the log activity
	 * @return the log activity, or <code>null</code> if a log activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogActivity fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LogActivity logActivity = (LogActivity)EntityCacheUtil.getResult(LogActivityModelImpl.ENTITY_CACHE_ENABLED,
				LogActivityImpl.class, primaryKey);

		if (logActivity == _nullLogActivity) {
			return null;
		}

		if (logActivity == null) {
			Session session = null;

			try {
				session = openSession();

				logActivity = (LogActivity)session.get(LogActivityImpl.class,
						primaryKey);

				if (logActivity != null) {
					cacheResult(logActivity);
				}
				else {
					EntityCacheUtil.putResult(LogActivityModelImpl.ENTITY_CACHE_ENABLED,
						LogActivityImpl.class, primaryKey, _nullLogActivity);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LogActivityModelImpl.ENTITY_CACHE_ENABLED,
					LogActivityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return logActivity;
	}

	/**
	 * Returns the log activity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spLogActivityId the primary key of the log activity
	 * @return the log activity, or <code>null</code> if a log activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogActivity fetchByPrimaryKey(long spLogActivityId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spLogActivityId);
	}

	/**
	 * Returns all the log activities.
	 *
	 * @return the log activities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LogActivity> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the log activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.LogActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of log activities
	 * @param end the upper bound of the range of log activities (not inclusive)
	 * @return the range of log activities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LogActivity> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the log activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.LogActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of log activities
	 * @param end the upper bound of the range of log activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of log activities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LogActivity> findAll(int start, int end,
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

		List<LogActivity> list = (List<LogActivity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LOGACTIVITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOGACTIVITY;

				if (pagination) {
					sql = sql.concat(LogActivityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LogActivity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LogActivity>(list);
				}
				else {
					list = (List<LogActivity>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the log activities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LogActivity logActivity : findAll()) {
			remove(logActivity);
		}
	}

	/**
	 * Returns the number of log activities.
	 *
	 * @return the number of log activities
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

				Query q = session.createQuery(_SQL_COUNT_LOGACTIVITY);

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
	 * Initializes the log activity persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.LogActivity")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LogActivity>> listenersList = new ArrayList<ModelListener<LogActivity>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LogActivity>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LogActivityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LOGACTIVITY = "SELECT logActivity FROM LogActivity logActivity";
	private static final String _SQL_SELECT_LOGACTIVITY_WHERE = "SELECT logActivity FROM LogActivity logActivity WHERE ";
	private static final String _SQL_COUNT_LOGACTIVITY = "SELECT COUNT(logActivity) FROM LogActivity logActivity";
	private static final String _SQL_COUNT_LOGACTIVITY_WHERE = "SELECT COUNT(logActivity) FROM LogActivity logActivity WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "logActivity.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LogActivity exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LogActivity exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LogActivityPersistenceImpl.class);
	private static LogActivity _nullLogActivity = new LogActivityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LogActivity> toCacheModel() {
				return _nullLogActivityCacheModel;
			}
		};

	private static CacheModel<LogActivity> _nullLogActivityCacheModel = new CacheModel<LogActivity>() {
			@Override
			public LogActivity toEntityModel() {
				return _nullLogActivity;
			}
		};
}