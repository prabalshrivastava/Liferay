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

package com.sambaash.platform.srv.contactus.service.persistence;

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

import com.sambaash.platform.srv.contactus.NoSuchSPContactUsException;
import com.sambaash.platform.srv.contactus.model.SPContactUs;
import com.sambaash.platform.srv.contactus.model.impl.SPContactUsImpl;
import com.sambaash.platform.srv.contactus.model.impl.SPContactUsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p contact us service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPContactUsPersistence
 * @see SPContactUsUtil
 * @generated
 */
public class SPContactUsPersistenceImpl extends BasePersistenceImpl<SPContactUs>
	implements SPContactUsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPContactUsUtil} to access the s p contact us persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPContactUsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPContactUsModelImpl.ENTITY_CACHE_ENABLED,
			SPContactUsModelImpl.FINDER_CACHE_ENABLED, SPContactUsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPContactUsModelImpl.ENTITY_CACHE_ENABLED,
			SPContactUsModelImpl.FINDER_CACHE_ENABLED, SPContactUsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPContactUsModelImpl.ENTITY_CACHE_ENABLED,
			SPContactUsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SPContactUsPersistenceImpl() {
		setModelClass(SPContactUs.class);
	}

	/**
	 * Caches the s p contact us in the entity cache if it is enabled.
	 *
	 * @param spContactUs the s p contact us
	 */
	@Override
	public void cacheResult(SPContactUs spContactUs) {
		EntityCacheUtil.putResult(SPContactUsModelImpl.ENTITY_CACHE_ENABLED,
			SPContactUsImpl.class, spContactUs.getPrimaryKey(), spContactUs);

		spContactUs.resetOriginalValues();
	}

	/**
	 * Caches the s p contact uses in the entity cache if it is enabled.
	 *
	 * @param spContactUses the s p contact uses
	 */
	@Override
	public void cacheResult(List<SPContactUs> spContactUses) {
		for (SPContactUs spContactUs : spContactUses) {
			if (EntityCacheUtil.getResult(
						SPContactUsModelImpl.ENTITY_CACHE_ENABLED,
						SPContactUsImpl.class, spContactUs.getPrimaryKey()) == null) {
				cacheResult(spContactUs);
			}
			else {
				spContactUs.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p contact uses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPContactUsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPContactUsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p contact us.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPContactUs spContactUs) {
		EntityCacheUtil.removeResult(SPContactUsModelImpl.ENTITY_CACHE_ENABLED,
			SPContactUsImpl.class, spContactUs.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SPContactUs> spContactUses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPContactUs spContactUs : spContactUses) {
			EntityCacheUtil.removeResult(SPContactUsModelImpl.ENTITY_CACHE_ENABLED,
				SPContactUsImpl.class, spContactUs.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s p contact us with the primary key. Does not add the s p contact us to the database.
	 *
	 * @param spContactUsId the primary key for the new s p contact us
	 * @return the new s p contact us
	 */
	@Override
	public SPContactUs create(long spContactUsId) {
		SPContactUs spContactUs = new SPContactUsImpl();

		spContactUs.setNew(true);
		spContactUs.setPrimaryKey(spContactUsId);

		return spContactUs;
	}

	/**
	 * Removes the s p contact us with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spContactUsId the primary key of the s p contact us
	 * @return the s p contact us that was removed
	 * @throws com.sambaash.platform.srv.contactus.NoSuchSPContactUsException if a s p contact us with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPContactUs remove(long spContactUsId)
		throws NoSuchSPContactUsException, SystemException {
		return remove((Serializable)spContactUsId);
	}

	/**
	 * Removes the s p contact us with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p contact us
	 * @return the s p contact us that was removed
	 * @throws com.sambaash.platform.srv.contactus.NoSuchSPContactUsException if a s p contact us with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPContactUs remove(Serializable primaryKey)
		throws NoSuchSPContactUsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPContactUs spContactUs = (SPContactUs)session.get(SPContactUsImpl.class,
					primaryKey);

			if (spContactUs == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPContactUsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spContactUs);
		}
		catch (NoSuchSPContactUsException nsee) {
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
	protected SPContactUs removeImpl(SPContactUs spContactUs)
		throws SystemException {
		spContactUs = toUnwrappedModel(spContactUs);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spContactUs)) {
				spContactUs = (SPContactUs)session.get(SPContactUsImpl.class,
						spContactUs.getPrimaryKeyObj());
			}

			if (spContactUs != null) {
				session.delete(spContactUs);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spContactUs != null) {
			clearCache(spContactUs);
		}

		return spContactUs;
	}

	@Override
	public SPContactUs updateImpl(
		com.sambaash.platform.srv.contactus.model.SPContactUs spContactUs)
		throws SystemException {
		spContactUs = toUnwrappedModel(spContactUs);

		boolean isNew = spContactUs.isNew();

		Session session = null;

		try {
			session = openSession();

			if (spContactUs.isNew()) {
				session.save(spContactUs);

				spContactUs.setNew(false);
			}
			else {
				session.merge(spContactUs);
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

		EntityCacheUtil.putResult(SPContactUsModelImpl.ENTITY_CACHE_ENABLED,
			SPContactUsImpl.class, spContactUs.getPrimaryKey(), spContactUs);

		return spContactUs;
	}

	protected SPContactUs toUnwrappedModel(SPContactUs spContactUs) {
		if (spContactUs instanceof SPContactUsImpl) {
			return spContactUs;
		}

		SPContactUsImpl spContactUsImpl = new SPContactUsImpl();

		spContactUsImpl.setNew(spContactUs.isNew());
		spContactUsImpl.setPrimaryKey(spContactUs.getPrimaryKey());

		spContactUsImpl.setSpContactUsId(spContactUs.getSpContactUsId());
		spContactUsImpl.setGroupId(spContactUs.getGroupId());
		spContactUsImpl.setCompanyId(spContactUs.getCompanyId());
		spContactUsImpl.setUserId(spContactUs.getUserId());
		spContactUsImpl.setUserName(spContactUs.getUserName());
		spContactUsImpl.setCreateDate(spContactUs.getCreateDate());
		spContactUsImpl.setModifiedDate(spContactUs.getModifiedDate());
		spContactUsImpl.setName(spContactUs.getName());
		spContactUsImpl.setLastName(spContactUs.getLastName());
		spContactUsImpl.setEmailAddress(spContactUs.getEmailAddress());
		spContactUsImpl.setCategory(spContactUs.getCategory());
		spContactUsImpl.setComment(spContactUs.getComment());
		spContactUsImpl.setCountryName(spContactUs.getCountryName());
		spContactUsImpl.setContactNumber(spContactUs.getContactNumber());
		spContactUsImpl.setCompany(spContactUs.getCompany());
		spContactUsImpl.setJobTitle(spContactUs.getJobTitle());
		spContactUsImpl.setCompanyUrl(spContactUs.getCompanyUrl());
		spContactUsImpl.setNoOfEmployee(spContactUs.getNoOfEmployee());
		spContactUsImpl.setRate(spContactUs.getRate());
		spContactUsImpl.setTypeOfEnquiry(spContactUs.getTypeOfEnquiry());
		spContactUsImpl.setLocation(spContactUs.getLocation());

		return spContactUsImpl;
	}

	/**
	 * Returns the s p contact us with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p contact us
	 * @return the s p contact us
	 * @throws com.sambaash.platform.srv.contactus.NoSuchSPContactUsException if a s p contact us with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPContactUs findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPContactUsException, SystemException {
		SPContactUs spContactUs = fetchByPrimaryKey(primaryKey);

		if (spContactUs == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPContactUsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spContactUs;
	}

	/**
	 * Returns the s p contact us with the primary key or throws a {@link com.sambaash.platform.srv.contactus.NoSuchSPContactUsException} if it could not be found.
	 *
	 * @param spContactUsId the primary key of the s p contact us
	 * @return the s p contact us
	 * @throws com.sambaash.platform.srv.contactus.NoSuchSPContactUsException if a s p contact us with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPContactUs findByPrimaryKey(long spContactUsId)
		throws NoSuchSPContactUsException, SystemException {
		return findByPrimaryKey((Serializable)spContactUsId);
	}

	/**
	 * Returns the s p contact us with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p contact us
	 * @return the s p contact us, or <code>null</code> if a s p contact us with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPContactUs fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPContactUs spContactUs = (SPContactUs)EntityCacheUtil.getResult(SPContactUsModelImpl.ENTITY_CACHE_ENABLED,
				SPContactUsImpl.class, primaryKey);

		if (spContactUs == _nullSPContactUs) {
			return null;
		}

		if (spContactUs == null) {
			Session session = null;

			try {
				session = openSession();

				spContactUs = (SPContactUs)session.get(SPContactUsImpl.class,
						primaryKey);

				if (spContactUs != null) {
					cacheResult(spContactUs);
				}
				else {
					EntityCacheUtil.putResult(SPContactUsModelImpl.ENTITY_CACHE_ENABLED,
						SPContactUsImpl.class, primaryKey, _nullSPContactUs);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPContactUsModelImpl.ENTITY_CACHE_ENABLED,
					SPContactUsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spContactUs;
	}

	/**
	 * Returns the s p contact us with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spContactUsId the primary key of the s p contact us
	 * @return the s p contact us, or <code>null</code> if a s p contact us with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPContactUs fetchByPrimaryKey(long spContactUsId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spContactUsId);
	}

	/**
	 * Returns all the s p contact uses.
	 *
	 * @return the s p contact uses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPContactUs> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p contact uses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.contactus.model.impl.SPContactUsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p contact uses
	 * @param end the upper bound of the range of s p contact uses (not inclusive)
	 * @return the range of s p contact uses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPContactUs> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p contact uses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.contactus.model.impl.SPContactUsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p contact uses
	 * @param end the upper bound of the range of s p contact uses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p contact uses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPContactUs> findAll(int start, int end,
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

		List<SPContactUs> list = (List<SPContactUs>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPCONTACTUS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPCONTACTUS;

				if (pagination) {
					sql = sql.concat(SPContactUsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPContactUs>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPContactUs>(list);
				}
				else {
					list = (List<SPContactUs>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p contact uses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPContactUs spContactUs : findAll()) {
			remove(spContactUs);
		}
	}

	/**
	 * Returns the number of s p contact uses.
	 *
	 * @return the number of s p contact uses
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

				Query q = session.createQuery(_SQL_COUNT_SPCONTACTUS);

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
	 * Initializes the s p contact us persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.contactus.model.SPContactUs")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPContactUs>> listenersList = new ArrayList<ModelListener<SPContactUs>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPContactUs>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPContactUsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPCONTACTUS = "SELECT spContactUs FROM SPContactUs spContactUs";
	private static final String _SQL_COUNT_SPCONTACTUS = "SELECT COUNT(spContactUs) FROM SPContactUs spContactUs";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spContactUs.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPContactUs exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPContactUsPersistenceImpl.class);
	private static SPContactUs _nullSPContactUs = new SPContactUsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPContactUs> toCacheModel() {
				return _nullSPContactUsCacheModel;
			}
		};

	private static CacheModel<SPContactUs> _nullSPContactUsCacheModel = new CacheModel<SPContactUs>() {
			@Override
			public SPContactUs toEntityModel() {
				return _nullSPContactUs;
			}
		};
}