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

package com.sambaash.platform.srv.genericuploader.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.genericuploader.NoSuchGUUploadLogException;
import com.sambaash.platform.srv.genericuploader.model.GUUploadLog;
import com.sambaash.platform.srv.genericuploader.model.impl.GUUploadLogImpl;
import com.sambaash.platform.srv.genericuploader.model.impl.GUUploadLogModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the g u upload log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see GUUploadLogPersistence
 * @see GUUploadLogUtil
 * @generated
 */
public class GUUploadLogPersistenceImpl extends BasePersistenceImpl<GUUploadLog>
	implements GUUploadLogPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GUUploadLogUtil} to access the g u upload log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GUUploadLogImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GUUploadLogModelImpl.ENTITY_CACHE_ENABLED,
			GUUploadLogModelImpl.FINDER_CACHE_ENABLED, GUUploadLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GUUploadLogModelImpl.ENTITY_CACHE_ENABLED,
			GUUploadLogModelImpl.FINDER_CACHE_ENABLED, GUUploadLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GUUploadLogModelImpl.ENTITY_CACHE_ENABLED,
			GUUploadLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public GUUploadLogPersistenceImpl() {
		setModelClass(GUUploadLog.class);
	}

	/**
	 * Caches the g u upload log in the entity cache if it is enabled.
	 *
	 * @param guUploadLog the g u upload log
	 */
	@Override
	public void cacheResult(GUUploadLog guUploadLog) {
		EntityCacheUtil.putResult(GUUploadLogModelImpl.ENTITY_CACHE_ENABLED,
			GUUploadLogImpl.class, guUploadLog.getPrimaryKey(), guUploadLog);

		guUploadLog.resetOriginalValues();
	}

	/**
	 * Caches the g u upload logs in the entity cache if it is enabled.
	 *
	 * @param guUploadLogs the g u upload logs
	 */
	@Override
	public void cacheResult(List<GUUploadLog> guUploadLogs) {
		for (GUUploadLog guUploadLog : guUploadLogs) {
			if (EntityCacheUtil.getResult(
						GUUploadLogModelImpl.ENTITY_CACHE_ENABLED,
						GUUploadLogImpl.class, guUploadLog.getPrimaryKey()) == null) {
				cacheResult(guUploadLog);
			}
			else {
				guUploadLog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g u upload logs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GUUploadLogImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GUUploadLogImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g u upload log.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GUUploadLog guUploadLog) {
		EntityCacheUtil.removeResult(GUUploadLogModelImpl.ENTITY_CACHE_ENABLED,
			GUUploadLogImpl.class, guUploadLog.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GUUploadLog> guUploadLogs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GUUploadLog guUploadLog : guUploadLogs) {
			EntityCacheUtil.removeResult(GUUploadLogModelImpl.ENTITY_CACHE_ENABLED,
				GUUploadLogImpl.class, guUploadLog.getPrimaryKey());
		}
	}

	/**
	 * Creates a new g u upload log with the primary key. Does not add the g u upload log to the database.
	 *
	 * @param SPGUUploadLogId the primary key for the new g u upload log
	 * @return the new g u upload log
	 */
	@Override
	public GUUploadLog create(long SPGUUploadLogId) {
		GUUploadLog guUploadLog = new GUUploadLogImpl();

		guUploadLog.setNew(true);
		guUploadLog.setPrimaryKey(SPGUUploadLogId);

		return guUploadLog;
	}

	/**
	 * Removes the g u upload log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param SPGUUploadLogId the primary key of the g u upload log
	 * @return the g u upload log that was removed
	 * @throws com.sambaash.platform.srv.genericuploader.NoSuchGUUploadLogException if a g u upload log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GUUploadLog remove(long SPGUUploadLogId)
		throws NoSuchGUUploadLogException, SystemException {
		return remove((Serializable)SPGUUploadLogId);
	}

	/**
	 * Removes the g u upload log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g u upload log
	 * @return the g u upload log that was removed
	 * @throws com.sambaash.platform.srv.genericuploader.NoSuchGUUploadLogException if a g u upload log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GUUploadLog remove(Serializable primaryKey)
		throws NoSuchGUUploadLogException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GUUploadLog guUploadLog = (GUUploadLog)session.get(GUUploadLogImpl.class,
					primaryKey);

			if (guUploadLog == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGUUploadLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(guUploadLog);
		}
		catch (NoSuchGUUploadLogException nsee) {
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
	protected GUUploadLog removeImpl(GUUploadLog guUploadLog)
		throws SystemException {
		guUploadLog = toUnwrappedModel(guUploadLog);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(guUploadLog)) {
				guUploadLog = (GUUploadLog)session.get(GUUploadLogImpl.class,
						guUploadLog.getPrimaryKeyObj());
			}

			if (guUploadLog != null) {
				session.delete(guUploadLog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (guUploadLog != null) {
			clearCache(guUploadLog);
		}

		return guUploadLog;
	}

	@Override
	public GUUploadLog updateImpl(
		com.sambaash.platform.srv.genericuploader.model.GUUploadLog guUploadLog)
		throws SystemException {
		guUploadLog = toUnwrappedModel(guUploadLog);

		boolean isNew = guUploadLog.isNew();

		Session session = null;

		try {
			session = openSession();

			if (guUploadLog.isNew()) {
				session.save(guUploadLog);

				guUploadLog.setNew(false);
			}
			else {
				session.merge(guUploadLog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(GUUploadLogModelImpl.ENTITY_CACHE_ENABLED,
			GUUploadLogImpl.class, guUploadLog.getPrimaryKey(), guUploadLog);

		return guUploadLog;
	}

	protected GUUploadLog toUnwrappedModel(GUUploadLog guUploadLog) {
		if (guUploadLog instanceof GUUploadLogImpl) {
			return guUploadLog;
		}

		GUUploadLogImpl guUploadLogImpl = new GUUploadLogImpl();

		guUploadLogImpl.setNew(guUploadLog.isNew());
		guUploadLogImpl.setPrimaryKey(guUploadLog.getPrimaryKey());

		guUploadLogImpl.setSPGUUploadLogId(guUploadLog.getSPGUUploadLogId());
		guUploadLogImpl.setGroupId(guUploadLog.getGroupId());
		guUploadLogImpl.setCompanyId(guUploadLog.getCompanyId());
		guUploadLogImpl.setUserId(guUploadLog.getUserId());
		guUploadLogImpl.setUserName(guUploadLog.getUserName());
		guUploadLogImpl.setCreateDate(guUploadLog.getCreateDate());
		guUploadLogImpl.setModifiedDate(guUploadLog.getModifiedDate());
		guUploadLogImpl.setSuccessCount(guUploadLog.getSuccessCount());
		guUploadLogImpl.setErrorCount(guUploadLog.getErrorCount());
		guUploadLogImpl.setStartTime(guUploadLog.getStartTime());
		guUploadLogImpl.setEndTime(guUploadLog.getEndTime());
		guUploadLogImpl.setUploadedFileEntryId(guUploadLog.getUploadedFileEntryId());
		guUploadLogImpl.setErrorFileEntryId(guUploadLog.getErrorFileEntryId());
		guUploadLogImpl.setErrors(guUploadLog.getErrors());
		guUploadLogImpl.setMsgs(guUploadLog.getMsgs());
		guUploadLogImpl.setStatus(guUploadLog.getStatus());

		return guUploadLogImpl;
	}

	/**
	 * Returns the g u upload log with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g u upload log
	 * @return the g u upload log
	 * @throws com.sambaash.platform.srv.genericuploader.NoSuchGUUploadLogException if a g u upload log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GUUploadLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGUUploadLogException, SystemException {
		GUUploadLog guUploadLog = fetchByPrimaryKey(primaryKey);

		if (guUploadLog == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGUUploadLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return guUploadLog;
	}

	/**
	 * Returns the g u upload log with the primary key or throws a {@link com.sambaash.platform.srv.genericuploader.NoSuchGUUploadLogException} if it could not be found.
	 *
	 * @param SPGUUploadLogId the primary key of the g u upload log
	 * @return the g u upload log
	 * @throws com.sambaash.platform.srv.genericuploader.NoSuchGUUploadLogException if a g u upload log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GUUploadLog findByPrimaryKey(long SPGUUploadLogId)
		throws NoSuchGUUploadLogException, SystemException {
		return findByPrimaryKey((Serializable)SPGUUploadLogId);
	}

	/**
	 * Returns the g u upload log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g u upload log
	 * @return the g u upload log, or <code>null</code> if a g u upload log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GUUploadLog fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GUUploadLog guUploadLog = (GUUploadLog)EntityCacheUtil.getResult(GUUploadLogModelImpl.ENTITY_CACHE_ENABLED,
				GUUploadLogImpl.class, primaryKey);

		if (guUploadLog == _nullGUUploadLog) {
			return null;
		}

		if (guUploadLog == null) {
			Session session = null;

			try {
				session = openSession();

				guUploadLog = (GUUploadLog)session.get(GUUploadLogImpl.class,
						primaryKey);

				if (guUploadLog != null) {
					cacheResult(guUploadLog);
				}
				else {
					EntityCacheUtil.putResult(GUUploadLogModelImpl.ENTITY_CACHE_ENABLED,
						GUUploadLogImpl.class, primaryKey, _nullGUUploadLog);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GUUploadLogModelImpl.ENTITY_CACHE_ENABLED,
					GUUploadLogImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return guUploadLog;
	}

	/**
	 * Returns the g u upload log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param SPGUUploadLogId the primary key of the g u upload log
	 * @return the g u upload log, or <code>null</code> if a g u upload log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GUUploadLog fetchByPrimaryKey(long SPGUUploadLogId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)SPGUUploadLogId);
	}

	/**
	 * Returns all the g u upload logs.
	 *
	 * @return the g u upload logs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GUUploadLog> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g u upload logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericuploader.model.impl.GUUploadLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g u upload logs
	 * @param end the upper bound of the range of g u upload logs (not inclusive)
	 * @return the range of g u upload logs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GUUploadLog> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g u upload logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericuploader.model.impl.GUUploadLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g u upload logs
	 * @param end the upper bound of the range of g u upload logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g u upload logs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GUUploadLog> findAll(int start, int end,
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

		List<GUUploadLog> list = (List<GUUploadLog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GUUPLOADLOG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GUUPLOADLOG;

				if (pagination) {
					sql = sql.concat(GUUploadLogModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GUUploadLog>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GUUploadLog>(list);
				}
				else {
					list = (List<GUUploadLog>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the g u upload logs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GUUploadLog guUploadLog : findAll()) {
			remove(guUploadLog);
		}
	}

	/**
	 * Returns the number of g u upload logs.
	 *
	 * @return the number of g u upload logs
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

				Query q = session.createQuery(_SQL_COUNT_GUUPLOADLOG);

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
	 * Initializes the g u upload log persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.genericuploader.model.GUUploadLog")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GUUploadLog>> listenersList = new ArrayList<ModelListener<GUUploadLog>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GUUploadLog>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GUUploadLogImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GUUPLOADLOG = "SELECT guUploadLog FROM GUUploadLog guUploadLog";
	private static final String _SQL_COUNT_GUUPLOADLOG = "SELECT COUNT(guUploadLog) FROM GUUploadLog guUploadLog";
	private static final String _ORDER_BY_ENTITY_ALIAS = "guUploadLog.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GUUploadLog exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GUUploadLogPersistenceImpl.class);
	private static GUUploadLog _nullGUUploadLog = new GUUploadLogImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GUUploadLog> toCacheModel() {
				return _nullGUUploadLogCacheModel;
			}
		};

	private static CacheModel<GUUploadLog> _nullGUUploadLogCacheModel = new CacheModel<GUUploadLog>() {
			@Override
			public GUUploadLog toEntityModel() {
				return _nullGUUploadLog;
			}
		};
}