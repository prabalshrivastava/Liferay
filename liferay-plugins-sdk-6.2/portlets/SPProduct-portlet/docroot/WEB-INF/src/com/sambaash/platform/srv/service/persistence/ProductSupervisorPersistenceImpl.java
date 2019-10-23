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

import com.sambaash.platform.srv.NoSuchProductSupervisorException;
import com.sambaash.platform.srv.model.ProductSupervisor;
import com.sambaash.platform.srv.model.impl.ProductSupervisorImpl;
import com.sambaash.platform.srv.model.impl.ProductSupervisorModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the product supervisor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see ProductSupervisorPersistence
 * @see ProductSupervisorUtil
 * @generated
 */
public class ProductSupervisorPersistenceImpl extends BasePersistenceImpl<ProductSupervisor>
	implements ProductSupervisorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProductSupervisorUtil} to access the product supervisor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProductSupervisorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProductSupervisorModelImpl.ENTITY_CACHE_ENABLED,
			ProductSupervisorModelImpl.FINDER_CACHE_ENABLED,
			ProductSupervisorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProductSupervisorModelImpl.ENTITY_CACHE_ENABLED,
			ProductSupervisorModelImpl.FINDER_CACHE_ENABLED,
			ProductSupervisorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProductSupervisorModelImpl.ENTITY_CACHE_ENABLED,
			ProductSupervisorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ProductSupervisorPersistenceImpl() {
		setModelClass(ProductSupervisor.class);
	}

	/**
	 * Caches the product supervisor in the entity cache if it is enabled.
	 *
	 * @param productSupervisor the product supervisor
	 */
	@Override
	public void cacheResult(ProductSupervisor productSupervisor) {
		EntityCacheUtil.putResult(ProductSupervisorModelImpl.ENTITY_CACHE_ENABLED,
			ProductSupervisorImpl.class, productSupervisor.getPrimaryKey(),
			productSupervisor);

		productSupervisor.resetOriginalValues();
	}

	/**
	 * Caches the product supervisors in the entity cache if it is enabled.
	 *
	 * @param productSupervisors the product supervisors
	 */
	@Override
	public void cacheResult(List<ProductSupervisor> productSupervisors) {
		for (ProductSupervisor productSupervisor : productSupervisors) {
			if (EntityCacheUtil.getResult(
						ProductSupervisorModelImpl.ENTITY_CACHE_ENABLED,
						ProductSupervisorImpl.class,
						productSupervisor.getPrimaryKey()) == null) {
				cacheResult(productSupervisor);
			}
			else {
				productSupervisor.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all product supervisors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProductSupervisorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProductSupervisorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the product supervisor.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductSupervisor productSupervisor) {
		EntityCacheUtil.removeResult(ProductSupervisorModelImpl.ENTITY_CACHE_ENABLED,
			ProductSupervisorImpl.class, productSupervisor.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProductSupervisor> productSupervisors) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProductSupervisor productSupervisor : productSupervisors) {
			EntityCacheUtil.removeResult(ProductSupervisorModelImpl.ENTITY_CACHE_ENABLED,
				ProductSupervisorImpl.class, productSupervisor.getPrimaryKey());
		}
	}

	/**
	 * Creates a new product supervisor with the primary key. Does not add the product supervisor to the database.
	 *
	 * @param spProductSupervisorId the primary key for the new product supervisor
	 * @return the new product supervisor
	 */
	@Override
	public ProductSupervisor create(long spProductSupervisorId) {
		ProductSupervisor productSupervisor = new ProductSupervisorImpl();

		productSupervisor.setNew(true);
		productSupervisor.setPrimaryKey(spProductSupervisorId);

		return productSupervisor;
	}

	/**
	 * Removes the product supervisor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spProductSupervisorId the primary key of the product supervisor
	 * @return the product supervisor that was removed
	 * @throws com.sambaash.platform.srv.NoSuchProductSupervisorException if a product supervisor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductSupervisor remove(long spProductSupervisorId)
		throws NoSuchProductSupervisorException, SystemException {
		return remove((Serializable)spProductSupervisorId);
	}

	/**
	 * Removes the product supervisor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the product supervisor
	 * @return the product supervisor that was removed
	 * @throws com.sambaash.platform.srv.NoSuchProductSupervisorException if a product supervisor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductSupervisor remove(Serializable primaryKey)
		throws NoSuchProductSupervisorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProductSupervisor productSupervisor = (ProductSupervisor)session.get(ProductSupervisorImpl.class,
					primaryKey);

			if (productSupervisor == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductSupervisorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(productSupervisor);
		}
		catch (NoSuchProductSupervisorException nsee) {
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
	protected ProductSupervisor removeImpl(ProductSupervisor productSupervisor)
		throws SystemException {
		productSupervisor = toUnwrappedModel(productSupervisor);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(productSupervisor)) {
				productSupervisor = (ProductSupervisor)session.get(ProductSupervisorImpl.class,
						productSupervisor.getPrimaryKeyObj());
			}

			if (productSupervisor != null) {
				session.delete(productSupervisor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (productSupervisor != null) {
			clearCache(productSupervisor);
		}

		return productSupervisor;
	}

	@Override
	public ProductSupervisor updateImpl(
		com.sambaash.platform.srv.model.ProductSupervisor productSupervisor)
		throws SystemException {
		productSupervisor = toUnwrappedModel(productSupervisor);

		boolean isNew = productSupervisor.isNew();

		Session session = null;

		try {
			session = openSession();

			if (productSupervisor.isNew()) {
				session.save(productSupervisor);

				productSupervisor.setNew(false);
			}
			else {
				session.merge(productSupervisor);
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

		EntityCacheUtil.putResult(ProductSupervisorModelImpl.ENTITY_CACHE_ENABLED,
			ProductSupervisorImpl.class, productSupervisor.getPrimaryKey(),
			productSupervisor);

		return productSupervisor;
	}

	protected ProductSupervisor toUnwrappedModel(
		ProductSupervisor productSupervisor) {
		if (productSupervisor instanceof ProductSupervisorImpl) {
			return productSupervisor;
		}

		ProductSupervisorImpl productSupervisorImpl = new ProductSupervisorImpl();

		productSupervisorImpl.setNew(productSupervisor.isNew());
		productSupervisorImpl.setPrimaryKey(productSupervisor.getPrimaryKey());

		productSupervisorImpl.setSpProductSupervisorId(productSupervisor.getSpProductSupervisorId());
		productSupervisorImpl.setGroupId(productSupervisor.getGroupId());
		productSupervisorImpl.setCompanyId(productSupervisor.getCompanyId());
		productSupervisorImpl.setUserId(productSupervisor.getUserId());
		productSupervisorImpl.setUserName(productSupervisor.getUserName());
		productSupervisorImpl.setCreateDate(productSupervisor.getCreateDate());
		productSupervisorImpl.setModifiedDate(productSupervisor.getModifiedDate());
		productSupervisorImpl.setCountryName(productSupervisor.getCountryName());
		productSupervisorImpl.setCountryId(productSupervisor.getCountryId());
		productSupervisorImpl.setProductId(productSupervisor.getProductId());
		productSupervisorImpl.setSupervisorId(productSupervisor.getSupervisorId());

		return productSupervisorImpl;
	}

	/**
	 * Returns the product supervisor with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the product supervisor
	 * @return the product supervisor
	 * @throws com.sambaash.platform.srv.NoSuchProductSupervisorException if a product supervisor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductSupervisor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProductSupervisorException, SystemException {
		ProductSupervisor productSupervisor = fetchByPrimaryKey(primaryKey);

		if (productSupervisor == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProductSupervisorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return productSupervisor;
	}

	/**
	 * Returns the product supervisor with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchProductSupervisorException} if it could not be found.
	 *
	 * @param spProductSupervisorId the primary key of the product supervisor
	 * @return the product supervisor
	 * @throws com.sambaash.platform.srv.NoSuchProductSupervisorException if a product supervisor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductSupervisor findByPrimaryKey(long spProductSupervisorId)
		throws NoSuchProductSupervisorException, SystemException {
		return findByPrimaryKey((Serializable)spProductSupervisorId);
	}

	/**
	 * Returns the product supervisor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product supervisor
	 * @return the product supervisor, or <code>null</code> if a product supervisor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductSupervisor fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ProductSupervisor productSupervisor = (ProductSupervisor)EntityCacheUtil.getResult(ProductSupervisorModelImpl.ENTITY_CACHE_ENABLED,
				ProductSupervisorImpl.class, primaryKey);

		if (productSupervisor == _nullProductSupervisor) {
			return null;
		}

		if (productSupervisor == null) {
			Session session = null;

			try {
				session = openSession();

				productSupervisor = (ProductSupervisor)session.get(ProductSupervisorImpl.class,
						primaryKey);

				if (productSupervisor != null) {
					cacheResult(productSupervisor);
				}
				else {
					EntityCacheUtil.putResult(ProductSupervisorModelImpl.ENTITY_CACHE_ENABLED,
						ProductSupervisorImpl.class, primaryKey,
						_nullProductSupervisor);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ProductSupervisorModelImpl.ENTITY_CACHE_ENABLED,
					ProductSupervisorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return productSupervisor;
	}

	/**
	 * Returns the product supervisor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spProductSupervisorId the primary key of the product supervisor
	 * @return the product supervisor, or <code>null</code> if a product supervisor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductSupervisor fetchByPrimaryKey(long spProductSupervisorId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spProductSupervisorId);
	}

	/**
	 * Returns all the product supervisors.
	 *
	 * @return the product supervisors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProductSupervisor> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product supervisors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductSupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of product supervisors
	 * @param end the upper bound of the range of product supervisors (not inclusive)
	 * @return the range of product supervisors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProductSupervisor> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the product supervisors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductSupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of product supervisors
	 * @param end the upper bound of the range of product supervisors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product supervisors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProductSupervisor> findAll(int start, int end,
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

		List<ProductSupervisor> list = (List<ProductSupervisor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRODUCTSUPERVISOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTSUPERVISOR;

				if (pagination) {
					sql = sql.concat(ProductSupervisorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProductSupervisor>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProductSupervisor>(list);
				}
				else {
					list = (List<ProductSupervisor>)QueryUtil.list(q,
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
	 * Removes all the product supervisors from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ProductSupervisor productSupervisor : findAll()) {
			remove(productSupervisor);
		}
	}

	/**
	 * Returns the number of product supervisors.
	 *
	 * @return the number of product supervisors
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

				Query q = session.createQuery(_SQL_COUNT_PRODUCTSUPERVISOR);

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
	 * Initializes the product supervisor persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.ProductSupervisor")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProductSupervisor>> listenersList = new ArrayList<ModelListener<ProductSupervisor>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProductSupervisor>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProductSupervisorImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PRODUCTSUPERVISOR = "SELECT productSupervisor FROM ProductSupervisor productSupervisor";
	private static final String _SQL_COUNT_PRODUCTSUPERVISOR = "SELECT COUNT(productSupervisor) FROM ProductSupervisor productSupervisor";
	private static final String _ORDER_BY_ENTITY_ALIAS = "productSupervisor.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProductSupervisor exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProductSupervisorPersistenceImpl.class);
	private static ProductSupervisor _nullProductSupervisor = new ProductSupervisorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ProductSupervisor> toCacheModel() {
				return _nullProductSupervisorCacheModel;
			}
		};

	private static CacheModel<ProductSupervisor> _nullProductSupervisorCacheModel =
		new CacheModel<ProductSupervisor>() {
			@Override
			public ProductSupervisor toEntityModel() {
				return _nullProductSupervisor;
			}
		};
}