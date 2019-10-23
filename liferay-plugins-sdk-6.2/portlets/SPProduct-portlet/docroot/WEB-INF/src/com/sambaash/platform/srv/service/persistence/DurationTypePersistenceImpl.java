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

import com.sambaash.platform.srv.NoSuchDurationTypeException;
import com.sambaash.platform.srv.model.DurationType;
import com.sambaash.platform.srv.model.impl.DurationTypeImpl;
import com.sambaash.platform.srv.model.impl.DurationTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the duration type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see DurationTypePersistence
 * @see DurationTypeUtil
 * @generated
 */
public class DurationTypePersistenceImpl extends BasePersistenceImpl<DurationType>
	implements DurationTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DurationTypeUtil} to access the duration type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DurationTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DurationTypeModelImpl.ENTITY_CACHE_ENABLED,
			DurationTypeModelImpl.FINDER_CACHE_ENABLED, DurationTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DurationTypeModelImpl.ENTITY_CACHE_ENABLED,
			DurationTypeModelImpl.FINDER_CACHE_ENABLED, DurationTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DurationTypeModelImpl.ENTITY_CACHE_ENABLED,
			DurationTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public DurationTypePersistenceImpl() {
		setModelClass(DurationType.class);
	}

	/**
	 * Caches the duration type in the entity cache if it is enabled.
	 *
	 * @param durationType the duration type
	 */
	@Override
	public void cacheResult(DurationType durationType) {
		EntityCacheUtil.putResult(DurationTypeModelImpl.ENTITY_CACHE_ENABLED,
			DurationTypeImpl.class, durationType.getPrimaryKey(), durationType);

		durationType.resetOriginalValues();
	}

	/**
	 * Caches the duration types in the entity cache if it is enabled.
	 *
	 * @param durationTypes the duration types
	 */
	@Override
	public void cacheResult(List<DurationType> durationTypes) {
		for (DurationType durationType : durationTypes) {
			if (EntityCacheUtil.getResult(
						DurationTypeModelImpl.ENTITY_CACHE_ENABLED,
						DurationTypeImpl.class, durationType.getPrimaryKey()) == null) {
				cacheResult(durationType);
			}
			else {
				durationType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all duration types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DurationTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DurationTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the duration type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DurationType durationType) {
		EntityCacheUtil.removeResult(DurationTypeModelImpl.ENTITY_CACHE_ENABLED,
			DurationTypeImpl.class, durationType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DurationType> durationTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DurationType durationType : durationTypes) {
			EntityCacheUtil.removeResult(DurationTypeModelImpl.ENTITY_CACHE_ENABLED,
				DurationTypeImpl.class, durationType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new duration type with the primary key. Does not add the duration type to the database.
	 *
	 * @param spDurationTypeId the primary key for the new duration type
	 * @return the new duration type
	 */
	@Override
	public DurationType create(long spDurationTypeId) {
		DurationType durationType = new DurationTypeImpl();

		durationType.setNew(true);
		durationType.setPrimaryKey(spDurationTypeId);

		return durationType;
	}

	/**
	 * Removes the duration type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spDurationTypeId the primary key of the duration type
	 * @return the duration type that was removed
	 * @throws com.sambaash.platform.srv.NoSuchDurationTypeException if a duration type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DurationType remove(long spDurationTypeId)
		throws NoSuchDurationTypeException, SystemException {
		return remove((Serializable)spDurationTypeId);
	}

	/**
	 * Removes the duration type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the duration type
	 * @return the duration type that was removed
	 * @throws com.sambaash.platform.srv.NoSuchDurationTypeException if a duration type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DurationType remove(Serializable primaryKey)
		throws NoSuchDurationTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DurationType durationType = (DurationType)session.get(DurationTypeImpl.class,
					primaryKey);

			if (durationType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDurationTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(durationType);
		}
		catch (NoSuchDurationTypeException nsee) {
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
	protected DurationType removeImpl(DurationType durationType)
		throws SystemException {
		durationType = toUnwrappedModel(durationType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(durationType)) {
				durationType = (DurationType)session.get(DurationTypeImpl.class,
						durationType.getPrimaryKeyObj());
			}

			if (durationType != null) {
				session.delete(durationType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (durationType != null) {
			clearCache(durationType);
		}

		return durationType;
	}

	@Override
	public DurationType updateImpl(
		com.sambaash.platform.srv.model.DurationType durationType)
		throws SystemException {
		durationType = toUnwrappedModel(durationType);

		boolean isNew = durationType.isNew();

		Session session = null;

		try {
			session = openSession();

			if (durationType.isNew()) {
				session.save(durationType);

				durationType.setNew(false);
			}
			else {
				session.merge(durationType);
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

		EntityCacheUtil.putResult(DurationTypeModelImpl.ENTITY_CACHE_ENABLED,
			DurationTypeImpl.class, durationType.getPrimaryKey(), durationType);

		return durationType;
	}

	protected DurationType toUnwrappedModel(DurationType durationType) {
		if (durationType instanceof DurationTypeImpl) {
			return durationType;
		}

		DurationTypeImpl durationTypeImpl = new DurationTypeImpl();

		durationTypeImpl.setNew(durationType.isNew());
		durationTypeImpl.setPrimaryKey(durationType.getPrimaryKey());

		durationTypeImpl.setSpDurationTypeId(durationType.getSpDurationTypeId());
		durationTypeImpl.setGroupId(durationType.getGroupId());
		durationTypeImpl.setCompanyId(durationType.getCompanyId());
		durationTypeImpl.setUserId(durationType.getUserId());
		durationTypeImpl.setUserName(durationType.getUserName());
		durationTypeImpl.setCreateDate(durationType.getCreateDate());
		durationTypeImpl.setModifiedDate(durationType.getModifiedDate());
		durationTypeImpl.setSpLearningDurationId(durationType.getSpLearningDurationId());
		durationTypeImpl.setSpCourseId(durationType.getSpCourseId());
		durationTypeImpl.setTitle1(durationType.getTitle1());
		durationTypeImpl.setDuration1(durationType.getDuration1());
		durationTypeImpl.setTitle2(durationType.getTitle2());
		durationTypeImpl.setDuration2(durationType.getDuration2());

		return durationTypeImpl;
	}

	/**
	 * Returns the duration type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the duration type
	 * @return the duration type
	 * @throws com.sambaash.platform.srv.NoSuchDurationTypeException if a duration type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DurationType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDurationTypeException, SystemException {
		DurationType durationType = fetchByPrimaryKey(primaryKey);

		if (durationType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDurationTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return durationType;
	}

	/**
	 * Returns the duration type with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchDurationTypeException} if it could not be found.
	 *
	 * @param spDurationTypeId the primary key of the duration type
	 * @return the duration type
	 * @throws com.sambaash.platform.srv.NoSuchDurationTypeException if a duration type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DurationType findByPrimaryKey(long spDurationTypeId)
		throws NoSuchDurationTypeException, SystemException {
		return findByPrimaryKey((Serializable)spDurationTypeId);
	}

	/**
	 * Returns the duration type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the duration type
	 * @return the duration type, or <code>null</code> if a duration type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DurationType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DurationType durationType = (DurationType)EntityCacheUtil.getResult(DurationTypeModelImpl.ENTITY_CACHE_ENABLED,
				DurationTypeImpl.class, primaryKey);

		if (durationType == _nullDurationType) {
			return null;
		}

		if (durationType == null) {
			Session session = null;

			try {
				session = openSession();

				durationType = (DurationType)session.get(DurationTypeImpl.class,
						primaryKey);

				if (durationType != null) {
					cacheResult(durationType);
				}
				else {
					EntityCacheUtil.putResult(DurationTypeModelImpl.ENTITY_CACHE_ENABLED,
						DurationTypeImpl.class, primaryKey, _nullDurationType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DurationTypeModelImpl.ENTITY_CACHE_ENABLED,
					DurationTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return durationType;
	}

	/**
	 * Returns the duration type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spDurationTypeId the primary key of the duration type
	 * @return the duration type, or <code>null</code> if a duration type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DurationType fetchByPrimaryKey(long spDurationTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spDurationTypeId);
	}

	/**
	 * Returns all the duration types.
	 *
	 * @return the duration types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DurationType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the duration types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.DurationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of duration types
	 * @param end the upper bound of the range of duration types (not inclusive)
	 * @return the range of duration types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DurationType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the duration types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.DurationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of duration types
	 * @param end the upper bound of the range of duration types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of duration types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DurationType> findAll(int start, int end,
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

		List<DurationType> list = (List<DurationType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DURATIONTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DURATIONTYPE;

				if (pagination) {
					sql = sql.concat(DurationTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DurationType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DurationType>(list);
				}
				else {
					list = (List<DurationType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the duration types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DurationType durationType : findAll()) {
			remove(durationType);
		}
	}

	/**
	 * Returns the number of duration types.
	 *
	 * @return the number of duration types
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

				Query q = session.createQuery(_SQL_COUNT_DURATIONTYPE);

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
	 * Initializes the duration type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.DurationType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DurationType>> listenersList = new ArrayList<ModelListener<DurationType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DurationType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DurationTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DURATIONTYPE = "SELECT durationType FROM DurationType durationType";
	private static final String _SQL_COUNT_DURATIONTYPE = "SELECT COUNT(durationType) FROM DurationType durationType";
	private static final String _ORDER_BY_ENTITY_ALIAS = "durationType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DurationType exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DurationTypePersistenceImpl.class);
	private static DurationType _nullDurationType = new DurationTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DurationType> toCacheModel() {
				return _nullDurationTypeCacheModel;
			}
		};

	private static CacheModel<DurationType> _nullDurationTypeCacheModel = new CacheModel<DurationType>() {
			@Override
			public DurationType toEntityModel() {
				return _nullDurationType;
			}
		};
}