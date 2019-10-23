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

package com.sambaash.platform.srv.sppayment.service.persistence;

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

import com.sambaash.platform.srv.sppayment.NoSuchSPPurchaseException;
import com.sambaash.platform.srv.sppayment.model.SPPurchase;
import com.sambaash.platform.srv.sppayment.model.impl.SPPurchaseImpl;
import com.sambaash.platform.srv.sppayment.model.impl.SPPurchaseModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p purchase service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPPurchasePersistence
 * @see SPPurchaseUtil
 * @generated
 */
public class SPPurchasePersistenceImpl extends BasePersistenceImpl<SPPurchase>
	implements SPPurchasePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPPurchaseUtil} to access the s p purchase persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPPurchaseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPPurchaseModelImpl.ENTITY_CACHE_ENABLED,
			SPPurchaseModelImpl.FINDER_CACHE_ENABLED, SPPurchaseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPPurchaseModelImpl.ENTITY_CACHE_ENABLED,
			SPPurchaseModelImpl.FINDER_CACHE_ENABLED, SPPurchaseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPPurchaseModelImpl.ENTITY_CACHE_ENABLED,
			SPPurchaseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SPPurchasePersistenceImpl() {
		setModelClass(SPPurchase.class);
	}

	/**
	 * Caches the s p purchase in the entity cache if it is enabled.
	 *
	 * @param spPurchase the s p purchase
	 */
	@Override
	public void cacheResult(SPPurchase spPurchase) {
		EntityCacheUtil.putResult(SPPurchaseModelImpl.ENTITY_CACHE_ENABLED,
			SPPurchaseImpl.class, spPurchase.getPrimaryKey(), spPurchase);

		spPurchase.resetOriginalValues();
	}

	/**
	 * Caches the s p purchases in the entity cache if it is enabled.
	 *
	 * @param spPurchases the s p purchases
	 */
	@Override
	public void cacheResult(List<SPPurchase> spPurchases) {
		for (SPPurchase spPurchase : spPurchases) {
			if (EntityCacheUtil.getResult(
						SPPurchaseModelImpl.ENTITY_CACHE_ENABLED,
						SPPurchaseImpl.class, spPurchase.getPrimaryKey()) == null) {
				cacheResult(spPurchase);
			}
			else {
				spPurchase.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p purchases.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPPurchaseImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPPurchaseImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p purchase.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPPurchase spPurchase) {
		EntityCacheUtil.removeResult(SPPurchaseModelImpl.ENTITY_CACHE_ENABLED,
			SPPurchaseImpl.class, spPurchase.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SPPurchase> spPurchases) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPPurchase spPurchase : spPurchases) {
			EntityCacheUtil.removeResult(SPPurchaseModelImpl.ENTITY_CACHE_ENABLED,
				SPPurchaseImpl.class, spPurchase.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s p purchase with the primary key. Does not add the s p purchase to the database.
	 *
	 * @param spPurchaseId the primary key for the new s p purchase
	 * @return the new s p purchase
	 */
	@Override
	public SPPurchase create(long spPurchaseId) {
		SPPurchase spPurchase = new SPPurchaseImpl();

		spPurchase.setNew(true);
		spPurchase.setPrimaryKey(spPurchaseId);

		return spPurchase;
	}

	/**
	 * Removes the s p purchase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spPurchaseId the primary key of the s p purchase
	 * @return the s p purchase that was removed
	 * @throws com.sambaash.platform.srv.sppayment.NoSuchSPPurchaseException if a s p purchase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPurchase remove(long spPurchaseId)
		throws NoSuchSPPurchaseException, SystemException {
		return remove((Serializable)spPurchaseId);
	}

	/**
	 * Removes the s p purchase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p purchase
	 * @return the s p purchase that was removed
	 * @throws com.sambaash.platform.srv.sppayment.NoSuchSPPurchaseException if a s p purchase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPurchase remove(Serializable primaryKey)
		throws NoSuchSPPurchaseException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPPurchase spPurchase = (SPPurchase)session.get(SPPurchaseImpl.class,
					primaryKey);

			if (spPurchase == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPPurchaseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spPurchase);
		}
		catch (NoSuchSPPurchaseException nsee) {
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
	protected SPPurchase removeImpl(SPPurchase spPurchase)
		throws SystemException {
		spPurchase = toUnwrappedModel(spPurchase);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spPurchase)) {
				spPurchase = (SPPurchase)session.get(SPPurchaseImpl.class,
						spPurchase.getPrimaryKeyObj());
			}

			if (spPurchase != null) {
				session.delete(spPurchase);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spPurchase != null) {
			clearCache(spPurchase);
		}

		return spPurchase;
	}

	@Override
	public SPPurchase updateImpl(
		com.sambaash.platform.srv.sppayment.model.SPPurchase spPurchase)
		throws SystemException {
		spPurchase = toUnwrappedModel(spPurchase);

		boolean isNew = spPurchase.isNew();

		Session session = null;

		try {
			session = openSession();

			if (spPurchase.isNew()) {
				session.save(spPurchase);

				spPurchase.setNew(false);
			}
			else {
				session.merge(spPurchase);
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

		EntityCacheUtil.putResult(SPPurchaseModelImpl.ENTITY_CACHE_ENABLED,
			SPPurchaseImpl.class, spPurchase.getPrimaryKey(), spPurchase);

		return spPurchase;
	}

	protected SPPurchase toUnwrappedModel(SPPurchase spPurchase) {
		if (spPurchase instanceof SPPurchaseImpl) {
			return spPurchase;
		}

		SPPurchaseImpl spPurchaseImpl = new SPPurchaseImpl();

		spPurchaseImpl.setNew(spPurchase.isNew());
		spPurchaseImpl.setPrimaryKey(spPurchase.getPrimaryKey());

		spPurchaseImpl.setSpPurchaseId(spPurchase.getSpPurchaseId());
		spPurchaseImpl.setGroupId(spPurchase.getGroupId());
		spPurchaseImpl.setCartId(spPurchase.getCartId());
		spPurchaseImpl.setExtPaymentId(spPurchase.getExtPaymentId());
		spPurchaseImpl.setExtStatus(spPurchase.getExtStatus());
		spPurchaseImpl.setExtErrorCode(spPurchase.getExtErrorCode());
		spPurchaseImpl.setExtErrorMsg(spPurchase.getExtErrorMsg());
		spPurchaseImpl.setCompanyId(spPurchase.getCompanyId());
		spPurchaseImpl.setUserId(spPurchase.getUserId());
		spPurchaseImpl.setUserName(spPurchase.getUserName());
		spPurchaseImpl.setCreateDate(spPurchase.getCreateDate());
		spPurchaseImpl.setModifiedDate(spPurchase.getModifiedDate());

		return spPurchaseImpl;
	}

	/**
	 * Returns the s p purchase with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p purchase
	 * @return the s p purchase
	 * @throws com.sambaash.platform.srv.sppayment.NoSuchSPPurchaseException if a s p purchase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPurchase findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPPurchaseException, SystemException {
		SPPurchase spPurchase = fetchByPrimaryKey(primaryKey);

		if (spPurchase == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPPurchaseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spPurchase;
	}

	/**
	 * Returns the s p purchase with the primary key or throws a {@link com.sambaash.platform.srv.sppayment.NoSuchSPPurchaseException} if it could not be found.
	 *
	 * @param spPurchaseId the primary key of the s p purchase
	 * @return the s p purchase
	 * @throws com.sambaash.platform.srv.sppayment.NoSuchSPPurchaseException if a s p purchase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPurchase findByPrimaryKey(long spPurchaseId)
		throws NoSuchSPPurchaseException, SystemException {
		return findByPrimaryKey((Serializable)spPurchaseId);
	}

	/**
	 * Returns the s p purchase with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p purchase
	 * @return the s p purchase, or <code>null</code> if a s p purchase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPurchase fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPPurchase spPurchase = (SPPurchase)EntityCacheUtil.getResult(SPPurchaseModelImpl.ENTITY_CACHE_ENABLED,
				SPPurchaseImpl.class, primaryKey);

		if (spPurchase == _nullSPPurchase) {
			return null;
		}

		if (spPurchase == null) {
			Session session = null;

			try {
				session = openSession();

				spPurchase = (SPPurchase)session.get(SPPurchaseImpl.class,
						primaryKey);

				if (spPurchase != null) {
					cacheResult(spPurchase);
				}
				else {
					EntityCacheUtil.putResult(SPPurchaseModelImpl.ENTITY_CACHE_ENABLED,
						SPPurchaseImpl.class, primaryKey, _nullSPPurchase);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPPurchaseModelImpl.ENTITY_CACHE_ENABLED,
					SPPurchaseImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spPurchase;
	}

	/**
	 * Returns the s p purchase with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spPurchaseId the primary key of the s p purchase
	 * @return the s p purchase, or <code>null</code> if a s p purchase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPurchase fetchByPrimaryKey(long spPurchaseId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spPurchaseId);
	}

	/**
	 * Returns all the s p purchases.
	 *
	 * @return the s p purchases
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPPurchase> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p purchases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sppayment.model.impl.SPPurchaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p purchases
	 * @param end the upper bound of the range of s p purchases (not inclusive)
	 * @return the range of s p purchases
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPPurchase> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p purchases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sppayment.model.impl.SPPurchaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p purchases
	 * @param end the upper bound of the range of s p purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p purchases
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPPurchase> findAll(int start, int end,
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

		List<SPPurchase> list = (List<SPPurchase>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPPURCHASE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPPURCHASE;

				if (pagination) {
					sql = sql.concat(SPPurchaseModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPPurchase>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPPurchase>(list);
				}
				else {
					list = (List<SPPurchase>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p purchases from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPPurchase spPurchase : findAll()) {
			remove(spPurchase);
		}
	}

	/**
	 * Returns the number of s p purchases.
	 *
	 * @return the number of s p purchases
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

				Query q = session.createQuery(_SQL_COUNT_SPPURCHASE);

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
	 * Initializes the s p purchase persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.sppayment.model.SPPurchase")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPPurchase>> listenersList = new ArrayList<ModelListener<SPPurchase>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPPurchase>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPPurchaseImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPPURCHASE = "SELECT spPurchase FROM SPPurchase spPurchase";
	private static final String _SQL_COUNT_SPPURCHASE = "SELECT COUNT(spPurchase) FROM SPPurchase spPurchase";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spPurchase.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPPurchase exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPPurchasePersistenceImpl.class);
	private static SPPurchase _nullSPPurchase = new SPPurchaseImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPPurchase> toCacheModel() {
				return _nullSPPurchaseCacheModel;
			}
		};

	private static CacheModel<SPPurchase> _nullSPPurchaseCacheModel = new CacheModel<SPPurchase>() {
			@Override
			public SPPurchase toEntityModel() {
				return _nullSPPurchase;
			}
		};
}