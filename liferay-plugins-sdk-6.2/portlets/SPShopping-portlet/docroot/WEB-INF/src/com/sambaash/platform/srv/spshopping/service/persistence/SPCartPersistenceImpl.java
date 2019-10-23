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

package com.sambaash.platform.srv.spshopping.service.persistence;

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

import com.sambaash.platform.srv.spshopping.NoSuchSPCartException;
import com.sambaash.platform.srv.spshopping.model.SPCart;
import com.sambaash.platform.srv.spshopping.model.impl.SPCartImpl;
import com.sambaash.platform.srv.spshopping.model.impl.SPCartModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p cart service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPCartPersistence
 * @see SPCartUtil
 * @generated
 */
public class SPCartPersistenceImpl extends BasePersistenceImpl<SPCart>
	implements SPCartPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPCartUtil} to access the s p cart persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPCartImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPCartModelImpl.ENTITY_CACHE_ENABLED,
			SPCartModelImpl.FINDER_CACHE_ENABLED, SPCartImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPCartModelImpl.ENTITY_CACHE_ENABLED,
			SPCartModelImpl.FINDER_CACHE_ENABLED, SPCartImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPCartModelImpl.ENTITY_CACHE_ENABLED,
			SPCartModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SPCartPersistenceImpl() {
		setModelClass(SPCart.class);
	}

	/**
	 * Caches the s p cart in the entity cache if it is enabled.
	 *
	 * @param spCart the s p cart
	 */
	@Override
	public void cacheResult(SPCart spCart) {
		EntityCacheUtil.putResult(SPCartModelImpl.ENTITY_CACHE_ENABLED,
			SPCartImpl.class, spCart.getPrimaryKey(), spCart);

		spCart.resetOriginalValues();
	}

	/**
	 * Caches the s p carts in the entity cache if it is enabled.
	 *
	 * @param spCarts the s p carts
	 */
	@Override
	public void cacheResult(List<SPCart> spCarts) {
		for (SPCart spCart : spCarts) {
			if (EntityCacheUtil.getResult(
						SPCartModelImpl.ENTITY_CACHE_ENABLED, SPCartImpl.class,
						spCart.getPrimaryKey()) == null) {
				cacheResult(spCart);
			}
			else {
				spCart.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p carts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPCartImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPCartImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p cart.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPCart spCart) {
		EntityCacheUtil.removeResult(SPCartModelImpl.ENTITY_CACHE_ENABLED,
			SPCartImpl.class, spCart.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SPCart> spCarts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPCart spCart : spCarts) {
			EntityCacheUtil.removeResult(SPCartModelImpl.ENTITY_CACHE_ENABLED,
				SPCartImpl.class, spCart.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s p cart with the primary key. Does not add the s p cart to the database.
	 *
	 * @param spCartId the primary key for the new s p cart
	 * @return the new s p cart
	 */
	@Override
	public SPCart create(long spCartId) {
		SPCart spCart = new SPCartImpl();

		spCart.setNew(true);
		spCart.setPrimaryKey(spCartId);

		return spCart;
	}

	/**
	 * Removes the s p cart with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spCartId the primary key of the s p cart
	 * @return the s p cart that was removed
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartException if a s p cart with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCart remove(long spCartId)
		throws NoSuchSPCartException, SystemException {
		return remove((Serializable)spCartId);
	}

	/**
	 * Removes the s p cart with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p cart
	 * @return the s p cart that was removed
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartException if a s p cart with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCart remove(Serializable primaryKey)
		throws NoSuchSPCartException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPCart spCart = (SPCart)session.get(SPCartImpl.class, primaryKey);

			if (spCart == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPCartException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spCart);
		}
		catch (NoSuchSPCartException nsee) {
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
	protected SPCart removeImpl(SPCart spCart) throws SystemException {
		spCart = toUnwrappedModel(spCart);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spCart)) {
				spCart = (SPCart)session.get(SPCartImpl.class,
						spCart.getPrimaryKeyObj());
			}

			if (spCart != null) {
				session.delete(spCart);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spCart != null) {
			clearCache(spCart);
		}

		return spCart;
	}

	@Override
	public SPCart updateImpl(
		com.sambaash.platform.srv.spshopping.model.SPCart spCart)
		throws SystemException {
		spCart = toUnwrappedModel(spCart);

		boolean isNew = spCart.isNew();

		Session session = null;

		try {
			session = openSession();

			if (spCart.isNew()) {
				session.save(spCart);

				spCart.setNew(false);
			}
			else {
				session.merge(spCart);
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

		EntityCacheUtil.putResult(SPCartModelImpl.ENTITY_CACHE_ENABLED,
			SPCartImpl.class, spCart.getPrimaryKey(), spCart);

		return spCart;
	}

	protected SPCart toUnwrappedModel(SPCart spCart) {
		if (spCart instanceof SPCartImpl) {
			return spCart;
		}

		SPCartImpl spCartImpl = new SPCartImpl();

		spCartImpl.setNew(spCart.isNew());
		spCartImpl.setPrimaryKey(spCart.getPrimaryKey());

		spCartImpl.setSpCartId(spCart.getSpCartId());
		spCartImpl.setGroupId(spCart.getGroupId());
		spCartImpl.setDiscount(spCart.getDiscount());
		spCartImpl.setTotalPrice(spCart.getTotalPrice());
		spCartImpl.setUserRemarks(spCart.getUserRemarks());
		spCartImpl.setStatus(spCart.getStatus());
		spCartImpl.setTransactionDetails(spCart.getTransactionDetails());
		spCartImpl.setOrderPage(spCart.getOrderPage());
		spCartImpl.setRsvpDetailId(spCart.getRsvpDetailId());
		spCartImpl.setCompanyId(spCart.getCompanyId());
		spCartImpl.setUserId(spCart.getUserId());
		spCartImpl.setUserName(spCart.getUserName());
		spCartImpl.setCreateDate(spCart.getCreateDate());
		spCartImpl.setModifiedDate(spCart.getModifiedDate());

		return spCartImpl;
	}

	/**
	 * Returns the s p cart with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p cart
	 * @return the s p cart
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartException if a s p cart with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCart findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPCartException, SystemException {
		SPCart spCart = fetchByPrimaryKey(primaryKey);

		if (spCart == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPCartException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spCart;
	}

	/**
	 * Returns the s p cart with the primary key or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPCartException} if it could not be found.
	 *
	 * @param spCartId the primary key of the s p cart
	 * @return the s p cart
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartException if a s p cart with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCart findByPrimaryKey(long spCartId)
		throws NoSuchSPCartException, SystemException {
		return findByPrimaryKey((Serializable)spCartId);
	}

	/**
	 * Returns the s p cart with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p cart
	 * @return the s p cart, or <code>null</code> if a s p cart with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCart fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPCart spCart = (SPCart)EntityCacheUtil.getResult(SPCartModelImpl.ENTITY_CACHE_ENABLED,
				SPCartImpl.class, primaryKey);

		if (spCart == _nullSPCart) {
			return null;
		}

		if (spCart == null) {
			Session session = null;

			try {
				session = openSession();

				spCart = (SPCart)session.get(SPCartImpl.class, primaryKey);

				if (spCart != null) {
					cacheResult(spCart);
				}
				else {
					EntityCacheUtil.putResult(SPCartModelImpl.ENTITY_CACHE_ENABLED,
						SPCartImpl.class, primaryKey, _nullSPCart);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPCartModelImpl.ENTITY_CACHE_ENABLED,
					SPCartImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spCart;
	}

	/**
	 * Returns the s p cart with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spCartId the primary key of the s p cart
	 * @return the s p cart, or <code>null</code> if a s p cart with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCart fetchByPrimaryKey(long spCartId) throws SystemException {
		return fetchByPrimaryKey((Serializable)spCartId);
	}

	/**
	 * Returns all the s p carts.
	 *
	 * @return the s p carts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCart> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p carts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p carts
	 * @param end the upper bound of the range of s p carts (not inclusive)
	 * @return the range of s p carts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCart> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p carts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p carts
	 * @param end the upper bound of the range of s p carts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p carts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCart> findAll(int start, int end,
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

		List<SPCart> list = (List<SPCart>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPCART);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPCART;

				if (pagination) {
					sql = sql.concat(SPCartModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPCart>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPCart>(list);
				}
				else {
					list = (List<SPCart>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the s p carts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPCart spCart : findAll()) {
			remove(spCart);
		}
	}

	/**
	 * Returns the number of s p carts.
	 *
	 * @return the number of s p carts
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

				Query q = session.createQuery(_SQL_COUNT_SPCART);

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
	 * Initializes the s p cart persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spshopping.model.SPCart")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPCart>> listenersList = new ArrayList<ModelListener<SPCart>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPCart>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPCartImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPCART = "SELECT spCart FROM SPCart spCart";
	private static final String _SQL_COUNT_SPCART = "SELECT COUNT(spCart) FROM SPCart spCart";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spCart.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPCart exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPCartPersistenceImpl.class);
	private static SPCart _nullSPCart = new SPCartImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPCart> toCacheModel() {
				return _nullSPCartCacheModel;
			}
		};

	private static CacheModel<SPCart> _nullSPCartCacheModel = new CacheModel<SPCart>() {
			@Override
			public SPCart toEntityModel() {
				return _nullSPCart;
			}
		};
}