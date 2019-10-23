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

import com.sambaash.platform.srv.NoSuchLearningDurationException;
import com.sambaash.platform.srv.model.LearningDuration;
import com.sambaash.platform.srv.model.impl.LearningDurationImpl;
import com.sambaash.platform.srv.model.impl.LearningDurationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the learning duration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see LearningDurationPersistence
 * @see LearningDurationUtil
 * @generated
 */
public class LearningDurationPersistenceImpl extends BasePersistenceImpl<LearningDuration>
	implements LearningDurationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LearningDurationUtil} to access the learning duration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LearningDurationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LearningDurationModelImpl.ENTITY_CACHE_ENABLED,
			LearningDurationModelImpl.FINDER_CACHE_ENABLED,
			LearningDurationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LearningDurationModelImpl.ENTITY_CACHE_ENABLED,
			LearningDurationModelImpl.FINDER_CACHE_ENABLED,
			LearningDurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LearningDurationModelImpl.ENTITY_CACHE_ENABLED,
			LearningDurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LearningDurationPersistenceImpl() {
		setModelClass(LearningDuration.class);
	}

	/**
	 * Caches the learning duration in the entity cache if it is enabled.
	 *
	 * @param learningDuration the learning duration
	 */
	@Override
	public void cacheResult(LearningDuration learningDuration) {
		EntityCacheUtil.putResult(LearningDurationModelImpl.ENTITY_CACHE_ENABLED,
			LearningDurationImpl.class, learningDuration.getPrimaryKey(),
			learningDuration);

		learningDuration.resetOriginalValues();
	}

	/**
	 * Caches the learning durations in the entity cache if it is enabled.
	 *
	 * @param learningDurations the learning durations
	 */
	@Override
	public void cacheResult(List<LearningDuration> learningDurations) {
		for (LearningDuration learningDuration : learningDurations) {
			if (EntityCacheUtil.getResult(
						LearningDurationModelImpl.ENTITY_CACHE_ENABLED,
						LearningDurationImpl.class,
						learningDuration.getPrimaryKey()) == null) {
				cacheResult(learningDuration);
			}
			else {
				learningDuration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all learning durations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LearningDurationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LearningDurationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the learning duration.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LearningDuration learningDuration) {
		EntityCacheUtil.removeResult(LearningDurationModelImpl.ENTITY_CACHE_ENABLED,
			LearningDurationImpl.class, learningDuration.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LearningDuration> learningDurations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LearningDuration learningDuration : learningDurations) {
			EntityCacheUtil.removeResult(LearningDurationModelImpl.ENTITY_CACHE_ENABLED,
				LearningDurationImpl.class, learningDuration.getPrimaryKey());
		}
	}

	/**
	 * Creates a new learning duration with the primary key. Does not add the learning duration to the database.
	 *
	 * @param spLearningDurationId the primary key for the new learning duration
	 * @return the new learning duration
	 */
	@Override
	public LearningDuration create(long spLearningDurationId) {
		LearningDuration learningDuration = new LearningDurationImpl();

		learningDuration.setNew(true);
		learningDuration.setPrimaryKey(spLearningDurationId);

		return learningDuration;
	}

	/**
	 * Removes the learning duration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spLearningDurationId the primary key of the learning duration
	 * @return the learning duration that was removed
	 * @throws com.sambaash.platform.srv.NoSuchLearningDurationException if a learning duration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LearningDuration remove(long spLearningDurationId)
		throws NoSuchLearningDurationException, SystemException {
		return remove((Serializable)spLearningDurationId);
	}

	/**
	 * Removes the learning duration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the learning duration
	 * @return the learning duration that was removed
	 * @throws com.sambaash.platform.srv.NoSuchLearningDurationException if a learning duration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LearningDuration remove(Serializable primaryKey)
		throws NoSuchLearningDurationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LearningDuration learningDuration = (LearningDuration)session.get(LearningDurationImpl.class,
					primaryKey);

			if (learningDuration == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLearningDurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(learningDuration);
		}
		catch (NoSuchLearningDurationException nsee) {
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
	protected LearningDuration removeImpl(LearningDuration learningDuration)
		throws SystemException {
		learningDuration = toUnwrappedModel(learningDuration);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(learningDuration)) {
				learningDuration = (LearningDuration)session.get(LearningDurationImpl.class,
						learningDuration.getPrimaryKeyObj());
			}

			if (learningDuration != null) {
				session.delete(learningDuration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (learningDuration != null) {
			clearCache(learningDuration);
		}

		return learningDuration;
	}

	@Override
	public LearningDuration updateImpl(
		com.sambaash.platform.srv.model.LearningDuration learningDuration)
		throws SystemException {
		learningDuration = toUnwrappedModel(learningDuration);

		boolean isNew = learningDuration.isNew();

		Session session = null;

		try {
			session = openSession();

			if (learningDuration.isNew()) {
				session.save(learningDuration);

				learningDuration.setNew(false);
			}
			else {
				session.merge(learningDuration);
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

		EntityCacheUtil.putResult(LearningDurationModelImpl.ENTITY_CACHE_ENABLED,
			LearningDurationImpl.class, learningDuration.getPrimaryKey(),
			learningDuration);

		return learningDuration;
	}

	protected LearningDuration toUnwrappedModel(
		LearningDuration learningDuration) {
		if (learningDuration instanceof LearningDurationImpl) {
			return learningDuration;
		}

		LearningDurationImpl learningDurationImpl = new LearningDurationImpl();

		learningDurationImpl.setNew(learningDuration.isNew());
		learningDurationImpl.setPrimaryKey(learningDuration.getPrimaryKey());

		learningDurationImpl.setSpLearningDurationId(learningDuration.getSpLearningDurationId());
		learningDurationImpl.setGroupId(learningDuration.getGroupId());
		learningDurationImpl.setCompanyId(learningDuration.getCompanyId());
		learningDurationImpl.setUserId(learningDuration.getUserId());
		learningDurationImpl.setUserName(learningDuration.getUserName());
		learningDurationImpl.setCreateDate(learningDuration.getCreateDate());
		learningDurationImpl.setModifiedDate(learningDuration.getModifiedDate());
		learningDurationImpl.setSpCourseId(learningDuration.getSpCourseId());
		learningDurationImpl.setTitle(learningDuration.getTitle());

		return learningDurationImpl;
	}

	/**
	 * Returns the learning duration with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the learning duration
	 * @return the learning duration
	 * @throws com.sambaash.platform.srv.NoSuchLearningDurationException if a learning duration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LearningDuration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLearningDurationException, SystemException {
		LearningDuration learningDuration = fetchByPrimaryKey(primaryKey);

		if (learningDuration == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLearningDurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return learningDuration;
	}

	/**
	 * Returns the learning duration with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchLearningDurationException} if it could not be found.
	 *
	 * @param spLearningDurationId the primary key of the learning duration
	 * @return the learning duration
	 * @throws com.sambaash.platform.srv.NoSuchLearningDurationException if a learning duration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LearningDuration findByPrimaryKey(long spLearningDurationId)
		throws NoSuchLearningDurationException, SystemException {
		return findByPrimaryKey((Serializable)spLearningDurationId);
	}

	/**
	 * Returns the learning duration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the learning duration
	 * @return the learning duration, or <code>null</code> if a learning duration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LearningDuration fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LearningDuration learningDuration = (LearningDuration)EntityCacheUtil.getResult(LearningDurationModelImpl.ENTITY_CACHE_ENABLED,
				LearningDurationImpl.class, primaryKey);

		if (learningDuration == _nullLearningDuration) {
			return null;
		}

		if (learningDuration == null) {
			Session session = null;

			try {
				session = openSession();

				learningDuration = (LearningDuration)session.get(LearningDurationImpl.class,
						primaryKey);

				if (learningDuration != null) {
					cacheResult(learningDuration);
				}
				else {
					EntityCacheUtil.putResult(LearningDurationModelImpl.ENTITY_CACHE_ENABLED,
						LearningDurationImpl.class, primaryKey,
						_nullLearningDuration);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LearningDurationModelImpl.ENTITY_CACHE_ENABLED,
					LearningDurationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return learningDuration;
	}

	/**
	 * Returns the learning duration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spLearningDurationId the primary key of the learning duration
	 * @return the learning duration, or <code>null</code> if a learning duration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LearningDuration fetchByPrimaryKey(long spLearningDurationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spLearningDurationId);
	}

	/**
	 * Returns all the learning durations.
	 *
	 * @return the learning durations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LearningDuration> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the learning durations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.LearningDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of learning durations
	 * @param end the upper bound of the range of learning durations (not inclusive)
	 * @return the range of learning durations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LearningDuration> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the learning durations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.LearningDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of learning durations
	 * @param end the upper bound of the range of learning durations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of learning durations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LearningDuration> findAll(int start, int end,
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

		List<LearningDuration> list = (List<LearningDuration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEARNINGDURATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEARNINGDURATION;

				if (pagination) {
					sql = sql.concat(LearningDurationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LearningDuration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LearningDuration>(list);
				}
				else {
					list = (List<LearningDuration>)QueryUtil.list(q,
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
	 * Removes all the learning durations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LearningDuration learningDuration : findAll()) {
			remove(learningDuration);
		}
	}

	/**
	 * Returns the number of learning durations.
	 *
	 * @return the number of learning durations
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

				Query q = session.createQuery(_SQL_COUNT_LEARNINGDURATION);

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
	 * Initializes the learning duration persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.LearningDuration")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LearningDuration>> listenersList = new ArrayList<ModelListener<LearningDuration>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LearningDuration>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LearningDurationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEARNINGDURATION = "SELECT learningDuration FROM LearningDuration learningDuration";
	private static final String _SQL_COUNT_LEARNINGDURATION = "SELECT COUNT(learningDuration) FROM LearningDuration learningDuration";
	private static final String _ORDER_BY_ENTITY_ALIAS = "learningDuration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LearningDuration exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LearningDurationPersistenceImpl.class);
	private static LearningDuration _nullLearningDuration = new LearningDurationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LearningDuration> toCacheModel() {
				return _nullLearningDurationCacheModel;
			}
		};

	private static CacheModel<LearningDuration> _nullLearningDurationCacheModel = new CacheModel<LearningDuration>() {
			@Override
			public LearningDuration toEntityModel() {
				return _nullLearningDuration;
			}
		};
}