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

package com.sambaash.platform.srv.processbuilder.service.persistence;

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

import com.sambaash.platform.srv.processbuilder.NoSuchPESupervisorException;
import com.sambaash.platform.srv.processbuilder.model.PESupervisor;
import com.sambaash.platform.srv.processbuilder.model.impl.PESupervisorImpl;
import com.sambaash.platform.srv.processbuilder.model.impl.PESupervisorModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the p e supervisor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see PESupervisorPersistence
 * @see PESupervisorUtil
 * @generated
 */
public class PESupervisorPersistenceImpl extends BasePersistenceImpl<PESupervisor>
	implements PESupervisorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PESupervisorUtil} to access the p e supervisor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PESupervisorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PESupervisorModelImpl.ENTITY_CACHE_ENABLED,
			PESupervisorModelImpl.FINDER_CACHE_ENABLED, PESupervisorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PESupervisorModelImpl.ENTITY_CACHE_ENABLED,
			PESupervisorModelImpl.FINDER_CACHE_ENABLED, PESupervisorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PESupervisorModelImpl.ENTITY_CACHE_ENABLED,
			PESupervisorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public PESupervisorPersistenceImpl() {
		setModelClass(PESupervisor.class);
	}

	/**
	 * Caches the p e supervisor in the entity cache if it is enabled.
	 *
	 * @param peSupervisor the p e supervisor
	 */
	@Override
	public void cacheResult(PESupervisor peSupervisor) {
		EntityCacheUtil.putResult(PESupervisorModelImpl.ENTITY_CACHE_ENABLED,
			PESupervisorImpl.class, peSupervisor.getPrimaryKey(), peSupervisor);

		peSupervisor.resetOriginalValues();
	}

	/**
	 * Caches the p e supervisors in the entity cache if it is enabled.
	 *
	 * @param peSupervisors the p e supervisors
	 */
	@Override
	public void cacheResult(List<PESupervisor> peSupervisors) {
		for (PESupervisor peSupervisor : peSupervisors) {
			if (EntityCacheUtil.getResult(
						PESupervisorModelImpl.ENTITY_CACHE_ENABLED,
						PESupervisorImpl.class, peSupervisor.getPrimaryKey()) == null) {
				cacheResult(peSupervisor);
			}
			else {
				peSupervisor.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all p e supervisors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PESupervisorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PESupervisorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the p e supervisor.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PESupervisor peSupervisor) {
		EntityCacheUtil.removeResult(PESupervisorModelImpl.ENTITY_CACHE_ENABLED,
			PESupervisorImpl.class, peSupervisor.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PESupervisor> peSupervisors) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PESupervisor peSupervisor : peSupervisors) {
			EntityCacheUtil.removeResult(PESupervisorModelImpl.ENTITY_CACHE_ENABLED,
				PESupervisorImpl.class, peSupervisor.getPrimaryKey());
		}
	}

	/**
	 * Creates a new p e supervisor with the primary key. Does not add the p e supervisor to the database.
	 *
	 * @param spPESupervisorId the primary key for the new p e supervisor
	 * @return the new p e supervisor
	 */
	@Override
	public PESupervisor create(long spPESupervisorId) {
		PESupervisor peSupervisor = new PESupervisorImpl();

		peSupervisor.setNew(true);
		peSupervisor.setPrimaryKey(spPESupervisorId);

		return peSupervisor;
	}

	/**
	 * Removes the p e supervisor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spPESupervisorId the primary key of the p e supervisor
	 * @return the p e supervisor that was removed
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPESupervisorException if a p e supervisor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PESupervisor remove(long spPESupervisorId)
		throws NoSuchPESupervisorException, SystemException {
		return remove((Serializable)spPESupervisorId);
	}

	/**
	 * Removes the p e supervisor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the p e supervisor
	 * @return the p e supervisor that was removed
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPESupervisorException if a p e supervisor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PESupervisor remove(Serializable primaryKey)
		throws NoSuchPESupervisorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PESupervisor peSupervisor = (PESupervisor)session.get(PESupervisorImpl.class,
					primaryKey);

			if (peSupervisor == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPESupervisorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(peSupervisor);
		}
		catch (NoSuchPESupervisorException nsee) {
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
	protected PESupervisor removeImpl(PESupervisor peSupervisor)
		throws SystemException {
		peSupervisor = toUnwrappedModel(peSupervisor);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(peSupervisor)) {
				peSupervisor = (PESupervisor)session.get(PESupervisorImpl.class,
						peSupervisor.getPrimaryKeyObj());
			}

			if (peSupervisor != null) {
				session.delete(peSupervisor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (peSupervisor != null) {
			clearCache(peSupervisor);
		}

		return peSupervisor;
	}

	@Override
	public PESupervisor updateImpl(
		com.sambaash.platform.srv.processbuilder.model.PESupervisor peSupervisor)
		throws SystemException {
		peSupervisor = toUnwrappedModel(peSupervisor);

		boolean isNew = peSupervisor.isNew();

		Session session = null;

		try {
			session = openSession();

			if (peSupervisor.isNew()) {
				session.save(peSupervisor);

				peSupervisor.setNew(false);
			}
			else {
				session.merge(peSupervisor);
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

		EntityCacheUtil.putResult(PESupervisorModelImpl.ENTITY_CACHE_ENABLED,
			PESupervisorImpl.class, peSupervisor.getPrimaryKey(), peSupervisor);

		return peSupervisor;
	}

	protected PESupervisor toUnwrappedModel(PESupervisor peSupervisor) {
		if (peSupervisor instanceof PESupervisorImpl) {
			return peSupervisor;
		}

		PESupervisorImpl peSupervisorImpl = new PESupervisorImpl();

		peSupervisorImpl.setNew(peSupervisor.isNew());
		peSupervisorImpl.setPrimaryKey(peSupervisor.getPrimaryKey());

		peSupervisorImpl.setSpPESupervisorId(peSupervisor.getSpPESupervisorId());
		peSupervisorImpl.setGroupId(peSupervisor.getGroupId());
		peSupervisorImpl.setCompanyId(peSupervisor.getCompanyId());
		peSupervisorImpl.setUserId(peSupervisor.getUserId());
		peSupervisorImpl.setUserName(peSupervisor.getUserName());
		peSupervisorImpl.setCreateDate(peSupervisor.getCreateDate());
		peSupervisorImpl.setModifiedDate(peSupervisor.getModifiedDate());
		peSupervisorImpl.setFilter1(peSupervisor.getFilter1());
		peSupervisorImpl.setFilter2(peSupervisor.getFilter2());
		peSupervisorImpl.setFilter3(peSupervisor.getFilter3());
		peSupervisorImpl.setFilter4(peSupervisor.getFilter4());
		peSupervisorImpl.setFilter5(peSupervisor.getFilter5());
		peSupervisorImpl.setSupervisorId(peSupervisor.getSupervisorId());

		return peSupervisorImpl;
	}

	/**
	 * Returns the p e supervisor with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the p e supervisor
	 * @return the p e supervisor
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPESupervisorException if a p e supervisor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PESupervisor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPESupervisorException, SystemException {
		PESupervisor peSupervisor = fetchByPrimaryKey(primaryKey);

		if (peSupervisor == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPESupervisorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return peSupervisor;
	}

	/**
	 * Returns the p e supervisor with the primary key or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPESupervisorException} if it could not be found.
	 *
	 * @param spPESupervisorId the primary key of the p e supervisor
	 * @return the p e supervisor
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPESupervisorException if a p e supervisor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PESupervisor findByPrimaryKey(long spPESupervisorId)
		throws NoSuchPESupervisorException, SystemException {
		return findByPrimaryKey((Serializable)spPESupervisorId);
	}

	/**
	 * Returns the p e supervisor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the p e supervisor
	 * @return the p e supervisor, or <code>null</code> if a p e supervisor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PESupervisor fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PESupervisor peSupervisor = (PESupervisor)EntityCacheUtil.getResult(PESupervisorModelImpl.ENTITY_CACHE_ENABLED,
				PESupervisorImpl.class, primaryKey);

		if (peSupervisor == _nullPESupervisor) {
			return null;
		}

		if (peSupervisor == null) {
			Session session = null;

			try {
				session = openSession();

				peSupervisor = (PESupervisor)session.get(PESupervisorImpl.class,
						primaryKey);

				if (peSupervisor != null) {
					cacheResult(peSupervisor);
				}
				else {
					EntityCacheUtil.putResult(PESupervisorModelImpl.ENTITY_CACHE_ENABLED,
						PESupervisorImpl.class, primaryKey, _nullPESupervisor);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PESupervisorModelImpl.ENTITY_CACHE_ENABLED,
					PESupervisorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return peSupervisor;
	}

	/**
	 * Returns the p e supervisor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spPESupervisorId the primary key of the p e supervisor
	 * @return the p e supervisor, or <code>null</code> if a p e supervisor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PESupervisor fetchByPrimaryKey(long spPESupervisorId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spPESupervisorId);
	}

	/**
	 * Returns all the p e supervisors.
	 *
	 * @return the p e supervisors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PESupervisor> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e supervisors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PESupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of p e supervisors
	 * @param end the upper bound of the range of p e supervisors (not inclusive)
	 * @return the range of p e supervisors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PESupervisor> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e supervisors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PESupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of p e supervisors
	 * @param end the upper bound of the range of p e supervisors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of p e supervisors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PESupervisor> findAll(int start, int end,
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

		List<PESupervisor> list = (List<PESupervisor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PESUPERVISOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PESUPERVISOR;

				if (pagination) {
					sql = sql.concat(PESupervisorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PESupervisor>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PESupervisor>(list);
				}
				else {
					list = (List<PESupervisor>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the p e supervisors from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PESupervisor peSupervisor : findAll()) {
			remove(peSupervisor);
		}
	}

	/**
	 * Returns the number of p e supervisors.
	 *
	 * @return the number of p e supervisors
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

				Query q = session.createQuery(_SQL_COUNT_PESUPERVISOR);

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
	 * Initializes the p e supervisor persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.processbuilder.model.PESupervisor")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PESupervisor>> listenersList = new ArrayList<ModelListener<PESupervisor>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PESupervisor>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PESupervisorImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PESUPERVISOR = "SELECT peSupervisor FROM PESupervisor peSupervisor";
	private static final String _SQL_COUNT_PESUPERVISOR = "SELECT COUNT(peSupervisor) FROM PESupervisor peSupervisor";
	private static final String _ORDER_BY_ENTITY_ALIAS = "peSupervisor.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PESupervisor exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PESupervisorPersistenceImpl.class);
	private static PESupervisor _nullPESupervisor = new PESupervisorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PESupervisor> toCacheModel() {
				return _nullPESupervisorCacheModel;
			}
		};

	private static CacheModel<PESupervisor> _nullPESupervisorCacheModel = new CacheModel<PESupervisor>() {
			@Override
			public PESupervisor toEntityModel() {
				return _nullPESupervisor;
			}
		};
}