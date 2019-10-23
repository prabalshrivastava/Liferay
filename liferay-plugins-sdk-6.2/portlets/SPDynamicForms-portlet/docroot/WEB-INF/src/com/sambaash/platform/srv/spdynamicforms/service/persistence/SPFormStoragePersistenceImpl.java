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

package com.sambaash.platform.srv.spdynamicforms.service.persistence;

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

import com.sambaash.platform.srv.spdynamicforms.NoSuchSPFormStorageException;
import com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage;
import com.sambaash.platform.srv.spdynamicforms.model.impl.SPFormStorageImpl;
import com.sambaash.platform.srv.spdynamicforms.model.impl.SPFormStorageModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p form storage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author glenn
 * @see SPFormStoragePersistence
 * @see SPFormStorageUtil
 * @generated
 */
public class SPFormStoragePersistenceImpl extends BasePersistenceImpl<SPFormStorage>
	implements SPFormStoragePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPFormStorageUtil} to access the s p form storage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPFormStorageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPFormStorageModelImpl.ENTITY_CACHE_ENABLED,
			SPFormStorageModelImpl.FINDER_CACHE_ENABLED,
			SPFormStorageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPFormStorageModelImpl.ENTITY_CACHE_ENABLED,
			SPFormStorageModelImpl.FINDER_CACHE_ENABLED,
			SPFormStorageImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPFormStorageModelImpl.ENTITY_CACHE_ENABLED,
			SPFormStorageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SPFormStoragePersistenceImpl() {
		setModelClass(SPFormStorage.class);
	}

	/**
	 * Caches the s p form storage in the entity cache if it is enabled.
	 *
	 * @param spFormStorage the s p form storage
	 */
	@Override
	public void cacheResult(SPFormStorage spFormStorage) {
		EntityCacheUtil.putResult(SPFormStorageModelImpl.ENTITY_CACHE_ENABLED,
			SPFormStorageImpl.class, spFormStorage.getPrimaryKey(),
			spFormStorage);

		spFormStorage.resetOriginalValues();
	}

	/**
	 * Caches the s p form storages in the entity cache if it is enabled.
	 *
	 * @param spFormStorages the s p form storages
	 */
	@Override
	public void cacheResult(List<SPFormStorage> spFormStorages) {
		for (SPFormStorage spFormStorage : spFormStorages) {
			if (EntityCacheUtil.getResult(
						SPFormStorageModelImpl.ENTITY_CACHE_ENABLED,
						SPFormStorageImpl.class, spFormStorage.getPrimaryKey()) == null) {
				cacheResult(spFormStorage);
			}
			else {
				spFormStorage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p form storages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPFormStorageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPFormStorageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p form storage.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPFormStorage spFormStorage) {
		EntityCacheUtil.removeResult(SPFormStorageModelImpl.ENTITY_CACHE_ENABLED,
			SPFormStorageImpl.class, spFormStorage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SPFormStorage> spFormStorages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPFormStorage spFormStorage : spFormStorages) {
			EntityCacheUtil.removeResult(SPFormStorageModelImpl.ENTITY_CACHE_ENABLED,
				SPFormStorageImpl.class, spFormStorage.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s p form storage with the primary key. Does not add the s p form storage to the database.
	 *
	 * @param formStorageId the primary key for the new s p form storage
	 * @return the new s p form storage
	 */
	@Override
	public SPFormStorage create(long formStorageId) {
		SPFormStorage spFormStorage = new SPFormStorageImpl();

		spFormStorage.setNew(true);
		spFormStorage.setPrimaryKey(formStorageId);

		return spFormStorage;
	}

	/**
	 * Removes the s p form storage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formStorageId the primary key of the s p form storage
	 * @return the s p form storage that was removed
	 * @throws com.sambaash.platform.srv.spdynamicforms.NoSuchSPFormStorageException if a s p form storage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPFormStorage remove(long formStorageId)
		throws NoSuchSPFormStorageException, SystemException {
		return remove((Serializable)formStorageId);
	}

	/**
	 * Removes the s p form storage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p form storage
	 * @return the s p form storage that was removed
	 * @throws com.sambaash.platform.srv.spdynamicforms.NoSuchSPFormStorageException if a s p form storage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPFormStorage remove(Serializable primaryKey)
		throws NoSuchSPFormStorageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPFormStorage spFormStorage = (SPFormStorage)session.get(SPFormStorageImpl.class,
					primaryKey);

			if (spFormStorage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPFormStorageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spFormStorage);
		}
		catch (NoSuchSPFormStorageException nsee) {
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
	protected SPFormStorage removeImpl(SPFormStorage spFormStorage)
		throws SystemException {
		spFormStorage = toUnwrappedModel(spFormStorage);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spFormStorage)) {
				spFormStorage = (SPFormStorage)session.get(SPFormStorageImpl.class,
						spFormStorage.getPrimaryKeyObj());
			}

			if (spFormStorage != null) {
				session.delete(spFormStorage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spFormStorage != null) {
			clearCache(spFormStorage);
		}

		return spFormStorage;
	}

	@Override
	public SPFormStorage updateImpl(
		com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage spFormStorage)
		throws SystemException {
		spFormStorage = toUnwrappedModel(spFormStorage);

		boolean isNew = spFormStorage.isNew();

		Session session = null;

		try {
			session = openSession();

			if (spFormStorage.isNew()) {
				session.save(spFormStorage);

				spFormStorage.setNew(false);
			}
			else {
				session.merge(spFormStorage);
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

		EntityCacheUtil.putResult(SPFormStorageModelImpl.ENTITY_CACHE_ENABLED,
			SPFormStorageImpl.class, spFormStorage.getPrimaryKey(),
			spFormStorage);

		return spFormStorage;
	}

	protected SPFormStorage toUnwrappedModel(SPFormStorage spFormStorage) {
		if (spFormStorage instanceof SPFormStorageImpl) {
			return spFormStorage;
		}

		SPFormStorageImpl spFormStorageImpl = new SPFormStorageImpl();

		spFormStorageImpl.setNew(spFormStorage.isNew());
		spFormStorageImpl.setPrimaryKey(spFormStorage.getPrimaryKey());

		spFormStorageImpl.setFormStorageId(spFormStorage.getFormStorageId());
		spFormStorageImpl.setGroupId(spFormStorage.getGroupId());
		spFormStorageImpl.setCompanyId(spFormStorage.getCompanyId());
		spFormStorageImpl.setUserId(spFormStorage.getUserId());
		spFormStorageImpl.setUserName(spFormStorage.getUserName());
		spFormStorageImpl.setCreateDate(spFormStorage.getCreateDate());
		spFormStorageImpl.setModifiedDate(spFormStorage.getModifiedDate());
		spFormStorageImpl.setApplicationId(spFormStorage.getApplicationId());
		spFormStorageImpl.setContent(spFormStorage.getContent());
		spFormStorageImpl.setHtmlFormId(spFormStorage.getHtmlFormId());
		spFormStorageImpl.setStatus(spFormStorage.getStatus());

		return spFormStorageImpl;
	}

	/**
	 * Returns the s p form storage with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p form storage
	 * @return the s p form storage
	 * @throws com.sambaash.platform.srv.spdynamicforms.NoSuchSPFormStorageException if a s p form storage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPFormStorage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPFormStorageException, SystemException {
		SPFormStorage spFormStorage = fetchByPrimaryKey(primaryKey);

		if (spFormStorage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPFormStorageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spFormStorage;
	}

	/**
	 * Returns the s p form storage with the primary key or throws a {@link com.sambaash.platform.srv.spdynamicforms.NoSuchSPFormStorageException} if it could not be found.
	 *
	 * @param formStorageId the primary key of the s p form storage
	 * @return the s p form storage
	 * @throws com.sambaash.platform.srv.spdynamicforms.NoSuchSPFormStorageException if a s p form storage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPFormStorage findByPrimaryKey(long formStorageId)
		throws NoSuchSPFormStorageException, SystemException {
		return findByPrimaryKey((Serializable)formStorageId);
	}

	/**
	 * Returns the s p form storage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p form storage
	 * @return the s p form storage, or <code>null</code> if a s p form storage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPFormStorage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPFormStorage spFormStorage = (SPFormStorage)EntityCacheUtil.getResult(SPFormStorageModelImpl.ENTITY_CACHE_ENABLED,
				SPFormStorageImpl.class, primaryKey);

		if (spFormStorage == _nullSPFormStorage) {
			return null;
		}

		if (spFormStorage == null) {
			Session session = null;

			try {
				session = openSession();

				spFormStorage = (SPFormStorage)session.get(SPFormStorageImpl.class,
						primaryKey);

				if (spFormStorage != null) {
					cacheResult(spFormStorage);
				}
				else {
					EntityCacheUtil.putResult(SPFormStorageModelImpl.ENTITY_CACHE_ENABLED,
						SPFormStorageImpl.class, primaryKey, _nullSPFormStorage);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPFormStorageModelImpl.ENTITY_CACHE_ENABLED,
					SPFormStorageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spFormStorage;
	}

	/**
	 * Returns the s p form storage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param formStorageId the primary key of the s p form storage
	 * @return the s p form storage, or <code>null</code> if a s p form storage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPFormStorage fetchByPrimaryKey(long formStorageId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)formStorageId);
	}

	/**
	 * Returns all the s p form storages.
	 *
	 * @return the s p form storages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPFormStorage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p form storages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdynamicforms.model.impl.SPFormStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p form storages
	 * @param end the upper bound of the range of s p form storages (not inclusive)
	 * @return the range of s p form storages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPFormStorage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p form storages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdynamicforms.model.impl.SPFormStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p form storages
	 * @param end the upper bound of the range of s p form storages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p form storages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPFormStorage> findAll(int start, int end,
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

		List<SPFormStorage> list = (List<SPFormStorage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPFORMSTORAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPFORMSTORAGE;

				if (pagination) {
					sql = sql.concat(SPFormStorageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPFormStorage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPFormStorage>(list);
				}
				else {
					list = (List<SPFormStorage>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p form storages from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPFormStorage spFormStorage : findAll()) {
			remove(spFormStorage);
		}
	}

	/**
	 * Returns the number of s p form storages.
	 *
	 * @return the number of s p form storages
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

				Query q = session.createQuery(_SQL_COUNT_SPFORMSTORAGE);

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
	 * Initializes the s p form storage persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPFormStorage>> listenersList = new ArrayList<ModelListener<SPFormStorage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPFormStorage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPFormStorageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPFORMSTORAGE = "SELECT spFormStorage FROM SPFormStorage spFormStorage";
	private static final String _SQL_COUNT_SPFORMSTORAGE = "SELECT COUNT(spFormStorage) FROM SPFormStorage spFormStorage";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spFormStorage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPFormStorage exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPFormStoragePersistenceImpl.class);
	private static SPFormStorage _nullSPFormStorage = new SPFormStorageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPFormStorage> toCacheModel() {
				return _nullSPFormStorageCacheModel;
			}
		};

	private static CacheModel<SPFormStorage> _nullSPFormStorageCacheModel = new CacheModel<SPFormStorage>() {
			@Override
			public SPFormStorage toEntityModel() {
				return _nullSPFormStorage;
			}
		};
}