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

package com.sambaash.platform.srv.spgroup.service.persistence;

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

import com.sambaash.platform.srv.spgroup.NoSuchPrefException;
import com.sambaash.platform.srv.spgroup.model.SPGroupPref;
import com.sambaash.platform.srv.spgroup.model.impl.SPGroupPrefImpl;
import com.sambaash.platform.srv.spgroup.model.impl.SPGroupPrefModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p group pref service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPGroupPrefPersistence
 * @see SPGroupPrefUtil
 * @generated
 */
public class SPGroupPrefPersistenceImpl extends BasePersistenceImpl<SPGroupPref>
	implements SPGroupPrefPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPGroupPrefUtil} to access the s p group pref persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPGroupPrefImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPGroupPrefModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupPrefModelImpl.FINDER_CACHE_ENABLED, SPGroupPrefImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPGroupPrefModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupPrefModelImpl.FINDER_CACHE_ENABLED, SPGroupPrefImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPGroupPrefModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupPrefModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SPGroupPrefPersistenceImpl() {
		setModelClass(SPGroupPref.class);
	}

	/**
	 * Caches the s p group pref in the entity cache if it is enabled.
	 *
	 * @param spGroupPref the s p group pref
	 */
	@Override
	public void cacheResult(SPGroupPref spGroupPref) {
		EntityCacheUtil.putResult(SPGroupPrefModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupPrefImpl.class, spGroupPref.getPrimaryKey(), spGroupPref);

		spGroupPref.resetOriginalValues();
	}

	/**
	 * Caches the s p group prefs in the entity cache if it is enabled.
	 *
	 * @param spGroupPrefs the s p group prefs
	 */
	@Override
	public void cacheResult(List<SPGroupPref> spGroupPrefs) {
		for (SPGroupPref spGroupPref : spGroupPrefs) {
			if (EntityCacheUtil.getResult(
						SPGroupPrefModelImpl.ENTITY_CACHE_ENABLED,
						SPGroupPrefImpl.class, spGroupPref.getPrimaryKey()) == null) {
				cacheResult(spGroupPref);
			}
			else {
				spGroupPref.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p group prefs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPGroupPrefImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPGroupPrefImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p group pref.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPGroupPref spGroupPref) {
		EntityCacheUtil.removeResult(SPGroupPrefModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupPrefImpl.class, spGroupPref.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SPGroupPref> spGroupPrefs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPGroupPref spGroupPref : spGroupPrefs) {
			EntityCacheUtil.removeResult(SPGroupPrefModelImpl.ENTITY_CACHE_ENABLED,
				SPGroupPrefImpl.class, spGroupPref.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s p group pref with the primary key. Does not add the s p group pref to the database.
	 *
	 * @param spGroupPrefId the primary key for the new s p group pref
	 * @return the new s p group pref
	 */
	@Override
	public SPGroupPref create(long spGroupPrefId) {
		SPGroupPref spGroupPref = new SPGroupPrefImpl();

		spGroupPref.setNew(true);
		spGroupPref.setPrimaryKey(spGroupPrefId);

		return spGroupPref;
	}

	/**
	 * Removes the s p group pref with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spGroupPrefId the primary key of the s p group pref
	 * @return the s p group pref that was removed
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchPrefException if a s p group pref with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupPref remove(long spGroupPrefId)
		throws NoSuchPrefException, SystemException {
		return remove((Serializable)spGroupPrefId);
	}

	/**
	 * Removes the s p group pref with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p group pref
	 * @return the s p group pref that was removed
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchPrefException if a s p group pref with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupPref remove(Serializable primaryKey)
		throws NoSuchPrefException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPGroupPref spGroupPref = (SPGroupPref)session.get(SPGroupPrefImpl.class,
					primaryKey);

			if (spGroupPref == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPrefException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spGroupPref);
		}
		catch (NoSuchPrefException nsee) {
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
	protected SPGroupPref removeImpl(SPGroupPref spGroupPref)
		throws SystemException {
		spGroupPref = toUnwrappedModel(spGroupPref);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spGroupPref)) {
				spGroupPref = (SPGroupPref)session.get(SPGroupPrefImpl.class,
						spGroupPref.getPrimaryKeyObj());
			}

			if (spGroupPref != null) {
				session.delete(spGroupPref);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spGroupPref != null) {
			clearCache(spGroupPref);
		}

		return spGroupPref;
	}

	@Override
	public SPGroupPref updateImpl(
		com.sambaash.platform.srv.spgroup.model.SPGroupPref spGroupPref)
		throws SystemException {
		spGroupPref = toUnwrappedModel(spGroupPref);

		boolean isNew = spGroupPref.isNew();

		Session session = null;

		try {
			session = openSession();

			if (spGroupPref.isNew()) {
				session.save(spGroupPref);

				spGroupPref.setNew(false);
			}
			else {
				session.merge(spGroupPref);
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

		EntityCacheUtil.putResult(SPGroupPrefModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupPrefImpl.class, spGroupPref.getPrimaryKey(), spGroupPref);

		return spGroupPref;
	}

	protected SPGroupPref toUnwrappedModel(SPGroupPref spGroupPref) {
		if (spGroupPref instanceof SPGroupPrefImpl) {
			return spGroupPref;
		}

		SPGroupPrefImpl spGroupPrefImpl = new SPGroupPrefImpl();

		spGroupPrefImpl.setNew(spGroupPref.isNew());
		spGroupPrefImpl.setPrimaryKey(spGroupPref.getPrimaryKey());

		spGroupPrefImpl.setSpGroupPrefId(spGroupPref.getSpGroupPrefId());
		spGroupPrefImpl.setGroupId(spGroupPref.getGroupId());
		spGroupPrefImpl.setCompanyId(spGroupPref.getCompanyId());
		spGroupPrefImpl.setUserId(spGroupPref.getUserId());
		spGroupPrefImpl.setUserName(spGroupPref.getUserName());
		spGroupPrefImpl.setCreateDate(spGroupPref.getCreateDate());
		spGroupPrefImpl.setModifiedDate(spGroupPref.getModifiedDate());
		spGroupPrefImpl.setDIn(spGroupPref.isDIn());
		spGroupPrefImpl.setDGoogle(spGroupPref.isDGoogle());
		spGroupPrefImpl.setDFb(spGroupPref.isDFb());
		spGroupPrefImpl.setDTw(spGroupPref.isDTw());
		spGroupPrefImpl.setCIn(spGroupPref.isCIn());
		spGroupPrefImpl.setCGoogle(spGroupPref.isCGoogle());
		spGroupPrefImpl.setCFb(spGroupPref.isCFb());
		spGroupPrefImpl.setCTw(spGroupPref.isCTw());
		spGroupPrefImpl.setEnableSubscribeToComments(spGroupPref.isEnableSubscribeToComments());
		spGroupPrefImpl.setEnableGroupUpdateNotification(spGroupPref.isEnableGroupUpdateNotification());
		spGroupPrefImpl.setEnableMemberUpdate(spGroupPref.isEnableMemberUpdate());
		spGroupPrefImpl.setEnableDiscussionUpdate(spGroupPref.isEnableDiscussionUpdate());
		spGroupPrefImpl.setUpdateFrequency(spGroupPref.getUpdateFrequency());

		return spGroupPrefImpl;
	}

	/**
	 * Returns the s p group pref with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p group pref
	 * @return the s p group pref
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchPrefException if a s p group pref with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupPref findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPrefException, SystemException {
		SPGroupPref spGroupPref = fetchByPrimaryKey(primaryKey);

		if (spGroupPref == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPrefException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spGroupPref;
	}

	/**
	 * Returns the s p group pref with the primary key or throws a {@link com.sambaash.platform.srv.spgroup.NoSuchPrefException} if it could not be found.
	 *
	 * @param spGroupPrefId the primary key of the s p group pref
	 * @return the s p group pref
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchPrefException if a s p group pref with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupPref findByPrimaryKey(long spGroupPrefId)
		throws NoSuchPrefException, SystemException {
		return findByPrimaryKey((Serializable)spGroupPrefId);
	}

	/**
	 * Returns the s p group pref with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p group pref
	 * @return the s p group pref, or <code>null</code> if a s p group pref with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupPref fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPGroupPref spGroupPref = (SPGroupPref)EntityCacheUtil.getResult(SPGroupPrefModelImpl.ENTITY_CACHE_ENABLED,
				SPGroupPrefImpl.class, primaryKey);

		if (spGroupPref == _nullSPGroupPref) {
			return null;
		}

		if (spGroupPref == null) {
			Session session = null;

			try {
				session = openSession();

				spGroupPref = (SPGroupPref)session.get(SPGroupPrefImpl.class,
						primaryKey);

				if (spGroupPref != null) {
					cacheResult(spGroupPref);
				}
				else {
					EntityCacheUtil.putResult(SPGroupPrefModelImpl.ENTITY_CACHE_ENABLED,
						SPGroupPrefImpl.class, primaryKey, _nullSPGroupPref);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPGroupPrefModelImpl.ENTITY_CACHE_ENABLED,
					SPGroupPrefImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spGroupPref;
	}

	/**
	 * Returns the s p group pref with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spGroupPrefId the primary key of the s p group pref
	 * @return the s p group pref, or <code>null</code> if a s p group pref with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupPref fetchByPrimaryKey(long spGroupPrefId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spGroupPrefId);
	}

	/**
	 * Returns all the s p group prefs.
	 *
	 * @return the s p group prefs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroupPref> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p group prefs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupPrefModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p group prefs
	 * @param end the upper bound of the range of s p group prefs (not inclusive)
	 * @return the range of s p group prefs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroupPref> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p group prefs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupPrefModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p group prefs
	 * @param end the upper bound of the range of s p group prefs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p group prefs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroupPref> findAll(int start, int end,
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

		List<SPGroupPref> list = (List<SPGroupPref>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPGROUPPREF);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPGROUPPREF;

				if (pagination) {
					sql = sql.concat(SPGroupPrefModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPGroupPref>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPGroupPref>(list);
				}
				else {
					list = (List<SPGroupPref>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p group prefs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPGroupPref spGroupPref : findAll()) {
			remove(spGroupPref);
		}
	}

	/**
	 * Returns the number of s p group prefs.
	 *
	 * @return the number of s p group prefs
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

				Query q = session.createQuery(_SQL_COUNT_SPGROUPPREF);

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
	 * Initializes the s p group pref persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spgroup.model.SPGroupPref")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPGroupPref>> listenersList = new ArrayList<ModelListener<SPGroupPref>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPGroupPref>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPGroupPrefImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPGROUPPREF = "SELECT spGroupPref FROM SPGroupPref spGroupPref";
	private static final String _SQL_COUNT_SPGROUPPREF = "SELECT COUNT(spGroupPref) FROM SPGroupPref spGroupPref";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spGroupPref.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPGroupPref exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPGroupPrefPersistenceImpl.class);
	private static SPGroupPref _nullSPGroupPref = new SPGroupPrefImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPGroupPref> toCacheModel() {
				return _nullSPGroupPrefCacheModel;
			}
		};

	private static CacheModel<SPGroupPref> _nullSPGroupPrefCacheModel = new CacheModel<SPGroupPref>() {
			@Override
			public SPGroupPref toEntityModel() {
				return _nullSPGroupPref;
			}
		};
}