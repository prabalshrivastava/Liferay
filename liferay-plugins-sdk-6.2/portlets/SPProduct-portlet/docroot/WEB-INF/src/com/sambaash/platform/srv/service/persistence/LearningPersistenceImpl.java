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

import com.sambaash.platform.srv.NoSuchLearningException;
import com.sambaash.platform.srv.model.Learning;
import com.sambaash.platform.srv.model.impl.LearningImpl;
import com.sambaash.platform.srv.model.impl.LearningModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the learning service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see LearningPersistence
 * @see LearningUtil
 * @generated
 */
public class LearningPersistenceImpl extends BasePersistenceImpl<Learning>
	implements LearningPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LearningUtil} to access the learning persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LearningImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LearningModelImpl.ENTITY_CACHE_ENABLED,
			LearningModelImpl.FINDER_CACHE_ENABLED, LearningImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LearningModelImpl.ENTITY_CACHE_ENABLED,
			LearningModelImpl.FINDER_CACHE_ENABLED, LearningImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LearningModelImpl.ENTITY_CACHE_ENABLED,
			LearningModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LearningPersistenceImpl() {
		setModelClass(Learning.class);
	}

	/**
	 * Caches the learning in the entity cache if it is enabled.
	 *
	 * @param learning the learning
	 */
	@Override
	public void cacheResult(Learning learning) {
		EntityCacheUtil.putResult(LearningModelImpl.ENTITY_CACHE_ENABLED,
			LearningImpl.class, learning.getPrimaryKey(), learning);

		learning.resetOriginalValues();
	}

	/**
	 * Caches the learnings in the entity cache if it is enabled.
	 *
	 * @param learnings the learnings
	 */
	@Override
	public void cacheResult(List<Learning> learnings) {
		for (Learning learning : learnings) {
			if (EntityCacheUtil.getResult(
						LearningModelImpl.ENTITY_CACHE_ENABLED,
						LearningImpl.class, learning.getPrimaryKey()) == null) {
				cacheResult(learning);
			}
			else {
				learning.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all learnings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LearningImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LearningImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the learning.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Learning learning) {
		EntityCacheUtil.removeResult(LearningModelImpl.ENTITY_CACHE_ENABLED,
			LearningImpl.class, learning.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Learning> learnings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Learning learning : learnings) {
			EntityCacheUtil.removeResult(LearningModelImpl.ENTITY_CACHE_ENABLED,
				LearningImpl.class, learning.getPrimaryKey());
		}
	}

	/**
	 * Creates a new learning with the primary key. Does not add the learning to the database.
	 *
	 * @param spLearningId the primary key for the new learning
	 * @return the new learning
	 */
	@Override
	public Learning create(long spLearningId) {
		Learning learning = new LearningImpl();

		learning.setNew(true);
		learning.setPrimaryKey(spLearningId);

		return learning;
	}

	/**
	 * Removes the learning with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spLearningId the primary key of the learning
	 * @return the learning that was removed
	 * @throws com.sambaash.platform.srv.NoSuchLearningException if a learning with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Learning remove(long spLearningId)
		throws NoSuchLearningException, SystemException {
		return remove((Serializable)spLearningId);
	}

	/**
	 * Removes the learning with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the learning
	 * @return the learning that was removed
	 * @throws com.sambaash.platform.srv.NoSuchLearningException if a learning with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Learning remove(Serializable primaryKey)
		throws NoSuchLearningException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Learning learning = (Learning)session.get(LearningImpl.class,
					primaryKey);

			if (learning == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLearningException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(learning);
		}
		catch (NoSuchLearningException nsee) {
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
	protected Learning removeImpl(Learning learning) throws SystemException {
		learning = toUnwrappedModel(learning);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(learning)) {
				learning = (Learning)session.get(LearningImpl.class,
						learning.getPrimaryKeyObj());
			}

			if (learning != null) {
				session.delete(learning);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (learning != null) {
			clearCache(learning);
		}

		return learning;
	}

	@Override
	public Learning updateImpl(
		com.sambaash.platform.srv.model.Learning learning)
		throws SystemException {
		learning = toUnwrappedModel(learning);

		boolean isNew = learning.isNew();

		Session session = null;

		try {
			session = openSession();

			if (learning.isNew()) {
				session.save(learning);

				learning.setNew(false);
			}
			else {
				session.merge(learning);
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

		EntityCacheUtil.putResult(LearningModelImpl.ENTITY_CACHE_ENABLED,
			LearningImpl.class, learning.getPrimaryKey(), learning);

		return learning;
	}

	protected Learning toUnwrappedModel(Learning learning) {
		if (learning instanceof LearningImpl) {
			return learning;
		}

		LearningImpl learningImpl = new LearningImpl();

		learningImpl.setNew(learning.isNew());
		learningImpl.setPrimaryKey(learning.getPrimaryKey());

		learningImpl.setSpLearningId(learning.getSpLearningId());
		learningImpl.setGroupId(learning.getGroupId());
		learningImpl.setCompanyId(learning.getCompanyId());
		learningImpl.setUserId(learning.getUserId());
		learningImpl.setUserName(learning.getUserName());
		learningImpl.setCreateDate(learning.getCreateDate());
		learningImpl.setModifiedDate(learning.getModifiedDate());
		learningImpl.setSpCourseId(learning.getSpCourseId());
		learningImpl.setIntro(learning.getIntro());
		learningImpl.setOptionTitle(learning.getOptionTitle());
		learningImpl.setOption1(learning.getOption1());
		learningImpl.setOption2(learning.getOption2());
		learningImpl.setNote(learning.getNote());

		return learningImpl;
	}

	/**
	 * Returns the learning with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the learning
	 * @return the learning
	 * @throws com.sambaash.platform.srv.NoSuchLearningException if a learning with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Learning findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLearningException, SystemException {
		Learning learning = fetchByPrimaryKey(primaryKey);

		if (learning == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLearningException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return learning;
	}

	/**
	 * Returns the learning with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchLearningException} if it could not be found.
	 *
	 * @param spLearningId the primary key of the learning
	 * @return the learning
	 * @throws com.sambaash.platform.srv.NoSuchLearningException if a learning with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Learning findByPrimaryKey(long spLearningId)
		throws NoSuchLearningException, SystemException {
		return findByPrimaryKey((Serializable)spLearningId);
	}

	/**
	 * Returns the learning with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the learning
	 * @return the learning, or <code>null</code> if a learning with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Learning fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Learning learning = (Learning)EntityCacheUtil.getResult(LearningModelImpl.ENTITY_CACHE_ENABLED,
				LearningImpl.class, primaryKey);

		if (learning == _nullLearning) {
			return null;
		}

		if (learning == null) {
			Session session = null;

			try {
				session = openSession();

				learning = (Learning)session.get(LearningImpl.class, primaryKey);

				if (learning != null) {
					cacheResult(learning);
				}
				else {
					EntityCacheUtil.putResult(LearningModelImpl.ENTITY_CACHE_ENABLED,
						LearningImpl.class, primaryKey, _nullLearning);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LearningModelImpl.ENTITY_CACHE_ENABLED,
					LearningImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return learning;
	}

	/**
	 * Returns the learning with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spLearningId the primary key of the learning
	 * @return the learning, or <code>null</code> if a learning with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Learning fetchByPrimaryKey(long spLearningId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spLearningId);
	}

	/**
	 * Returns all the learnings.
	 *
	 * @return the learnings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Learning> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the learnings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.LearningModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of learnings
	 * @param end the upper bound of the range of learnings (not inclusive)
	 * @return the range of learnings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Learning> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the learnings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.LearningModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of learnings
	 * @param end the upper bound of the range of learnings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of learnings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Learning> findAll(int start, int end,
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

		List<Learning> list = (List<Learning>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEARNING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEARNING;

				if (pagination) {
					sql = sql.concat(LearningModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Learning>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Learning>(list);
				}
				else {
					list = (List<Learning>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the learnings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Learning learning : findAll()) {
			remove(learning);
		}
	}

	/**
	 * Returns the number of learnings.
	 *
	 * @return the number of learnings
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

				Query q = session.createQuery(_SQL_COUNT_LEARNING);

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
	 * Initializes the learning persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.Learning")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Learning>> listenersList = new ArrayList<ModelListener<Learning>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Learning>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LearningImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEARNING = "SELECT learning FROM Learning learning";
	private static final String _SQL_COUNT_LEARNING = "SELECT COUNT(learning) FROM Learning learning";
	private static final String _ORDER_BY_ENTITY_ALIAS = "learning.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Learning exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LearningPersistenceImpl.class);
	private static Learning _nullLearning = new LearningImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Learning> toCacheModel() {
				return _nullLearningCacheModel;
			}
		};

	private static CacheModel<Learning> _nullLearningCacheModel = new CacheModel<Learning>() {
			@Override
			public Learning toEntityModel() {
				return _nullLearning;
			}
		};
}