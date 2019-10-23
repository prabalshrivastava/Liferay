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

package com.sambaash.platform.srv.feedback.service.persistence;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.feedback.NoSuchSPFeedbackException;
import com.sambaash.platform.srv.feedback.model.SPFeedback;
import com.sambaash.platform.srv.feedback.model.impl.SPFeedbackImpl;
import com.sambaash.platform.srv.feedback.model.impl.SPFeedbackModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p feedback service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPFeedbackPersistence
 * @see SPFeedbackUtil
 * @generated
 */
public class SPFeedbackPersistenceImpl extends BasePersistenceImpl<SPFeedback>
	implements SPFeedbackPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPFeedbackUtil} to access the s p feedback persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPFeedbackImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SPFeedbackModelImpl.FINDER_CACHE_ENABLED, SPFeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SPFeedbackModelImpl.FINDER_CACHE_ENABLED, SPFeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SPFeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SPFeedbackPersistenceImpl() {
		setModelClass(SPFeedback.class);
	}

	/**
	 * Caches the s p feedback in the entity cache if it is enabled.
	 *
	 * @param spFeedback the s p feedback
	 */
	@Override
	public void cacheResult(SPFeedback spFeedback) {
		EntityCacheUtil.putResult(SPFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SPFeedbackImpl.class, spFeedback.getPrimaryKey(), spFeedback);

		spFeedback.resetOriginalValues();
	}

	/**
	 * Caches the s p feedbacks in the entity cache if it is enabled.
	 *
	 * @param spFeedbacks the s p feedbacks
	 */
	@Override
	public void cacheResult(List<SPFeedback> spFeedbacks) {
		for (SPFeedback spFeedback : spFeedbacks) {
			if (EntityCacheUtil.getResult(
						SPFeedbackModelImpl.ENTITY_CACHE_ENABLED,
						SPFeedbackImpl.class, spFeedback.getPrimaryKey()) == null) {
				cacheResult(spFeedback);
			}
			else {
				spFeedback.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p feedbacks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPFeedbackImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPFeedbackImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p feedback.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPFeedback spFeedback) {
		EntityCacheUtil.removeResult(SPFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SPFeedbackImpl.class, spFeedback.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SPFeedback> spFeedbacks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPFeedback spFeedback : spFeedbacks) {
			EntityCacheUtil.removeResult(SPFeedbackModelImpl.ENTITY_CACHE_ENABLED,
				SPFeedbackImpl.class, spFeedback.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s p feedback with the primary key. Does not add the s p feedback to the database.
	 *
	 * @param spFeedbackId the primary key for the new s p feedback
	 * @return the new s p feedback
	 */
	@Override
	public SPFeedback create(long spFeedbackId) {
		SPFeedback spFeedback = new SPFeedbackImpl();

		spFeedback.setNew(true);
		spFeedback.setPrimaryKey(spFeedbackId);

		return spFeedback;
	}

	/**
	 * Removes the s p feedback with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spFeedbackId the primary key of the s p feedback
	 * @return the s p feedback that was removed
	 * @throws com.sambaash.platform.srv.feedback.NoSuchSPFeedbackException if a s p feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPFeedback remove(long spFeedbackId)
		throws NoSuchSPFeedbackException, SystemException {
		return remove((Serializable)spFeedbackId);
	}

	/**
	 * Removes the s p feedback with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p feedback
	 * @return the s p feedback that was removed
	 * @throws com.sambaash.platform.srv.feedback.NoSuchSPFeedbackException if a s p feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPFeedback remove(Serializable primaryKey)
		throws NoSuchSPFeedbackException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPFeedback spFeedback = (SPFeedback)session.get(SPFeedbackImpl.class,
					primaryKey);

			if (spFeedback == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPFeedbackException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spFeedback);
		}
		catch (NoSuchSPFeedbackException nsee) {
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
	protected SPFeedback removeImpl(SPFeedback spFeedback)
		throws SystemException {
		spFeedback = toUnwrappedModel(spFeedback);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spFeedback)) {
				spFeedback = (SPFeedback)session.get(SPFeedbackImpl.class,
						spFeedback.getPrimaryKeyObj());
			}

			if (spFeedback != null) {
				session.delete(spFeedback);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spFeedback != null) {
			clearCache(spFeedback);
		}

		return spFeedback;
	}

	@Override
	public SPFeedback updateImpl(
		com.sambaash.platform.srv.feedback.model.SPFeedback spFeedback)
		throws SystemException {
		spFeedback = toUnwrappedModel(spFeedback);

		boolean isNew = spFeedback.isNew();

		Session session = null;

		try {
			session = openSession();

			if (spFeedback.isNew()) {
				session.save(spFeedback);

				spFeedback.setNew(false);
			}
			else {
				session.merge(spFeedback);
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

		EntityCacheUtil.putResult(SPFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SPFeedbackImpl.class, spFeedback.getPrimaryKey(), spFeedback);

		return spFeedback;
	}

	protected SPFeedback toUnwrappedModel(SPFeedback spFeedback) {
		if (spFeedback instanceof SPFeedbackImpl) {
			return spFeedback;
		}

		SPFeedbackImpl spFeedbackImpl = new SPFeedbackImpl();

		spFeedbackImpl.setNew(spFeedback.isNew());
		spFeedbackImpl.setPrimaryKey(spFeedback.getPrimaryKey());

		spFeedbackImpl.setSpFeedbackId(spFeedback.getSpFeedbackId());
		spFeedbackImpl.setGroupId(spFeedback.getGroupId());
		spFeedbackImpl.setCompanyId(spFeedback.getCompanyId());
		spFeedbackImpl.setUserId(spFeedback.getUserId());
		spFeedbackImpl.setUserName(spFeedback.getUserName());
		spFeedbackImpl.setCreateDate(spFeedback.getCreateDate());
		spFeedbackImpl.setModifiedDate(spFeedback.getModifiedDate());
		spFeedbackImpl.setType(spFeedback.getType());
		spFeedbackImpl.setDescription(spFeedback.getDescription());

		return spFeedbackImpl;
	}

	/**
	 * Returns the s p feedback with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p feedback
	 * @return the s p feedback
	 * @throws com.sambaash.platform.srv.feedback.NoSuchSPFeedbackException if a s p feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPFeedback findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPFeedbackException, SystemException {
		SPFeedback spFeedback = fetchByPrimaryKey(primaryKey);

		if (spFeedback == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPFeedbackException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spFeedback;
	}

	/**
	 * Returns the s p feedback with the primary key or throws a {@link com.sambaash.platform.srv.feedback.NoSuchSPFeedbackException} if it could not be found.
	 *
	 * @param spFeedbackId the primary key of the s p feedback
	 * @return the s p feedback
	 * @throws com.sambaash.platform.srv.feedback.NoSuchSPFeedbackException if a s p feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPFeedback findByPrimaryKey(long spFeedbackId)
		throws NoSuchSPFeedbackException, SystemException {
		return findByPrimaryKey((Serializable)spFeedbackId);
	}

	/**
	 * Returns the s p feedback with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p feedback
	 * @return the s p feedback, or <code>null</code> if a s p feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPFeedback fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPFeedback spFeedback = (SPFeedback)EntityCacheUtil.getResult(SPFeedbackModelImpl.ENTITY_CACHE_ENABLED,
				SPFeedbackImpl.class, primaryKey);

		if (spFeedback == _nullSPFeedback) {
			return null;
		}

		if (spFeedback == null) {
			Session session = null;

			try {
				session = openSession();

				spFeedback = (SPFeedback)session.get(SPFeedbackImpl.class,
						primaryKey);

				if (spFeedback != null) {
					cacheResult(spFeedback);
				}
				else {
					EntityCacheUtil.putResult(SPFeedbackModelImpl.ENTITY_CACHE_ENABLED,
						SPFeedbackImpl.class, primaryKey, _nullSPFeedback);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPFeedbackModelImpl.ENTITY_CACHE_ENABLED,
					SPFeedbackImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spFeedback;
	}

	/**
	 * Returns the s p feedback with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spFeedbackId the primary key of the s p feedback
	 * @return the s p feedback, or <code>null</code> if a s p feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPFeedback fetchByPrimaryKey(long spFeedbackId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spFeedbackId);
	}

	/**
	 * Returns all the s p feedbacks.
	 *
	 * @return the s p feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPFeedback> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p feedbacks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.feedback.model.impl.SPFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p feedbacks
	 * @param end the upper bound of the range of s p feedbacks (not inclusive)
	 * @return the range of s p feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPFeedback> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p feedbacks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.feedback.model.impl.SPFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p feedbacks
	 * @param end the upper bound of the range of s p feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPFeedback> findAll(int start, int end,
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

		List<SPFeedback> list = (List<SPFeedback>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPFEEDBACK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPFEEDBACK;

				if (pagination) {
					sql = sql.concat(SPFeedbackModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPFeedback>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPFeedback>(list);
				}
				else {
					list = (List<SPFeedback>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p feedbacks from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPFeedback spFeedback : findAll()) {
			remove(spFeedback);
		}
	}

	/**
	 * Returns the number of s p feedbacks.
	 *
	 * @return the number of s p feedbacks
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

				Query q = session.createQuery(_SQL_COUNT_SPFEEDBACK);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the s p feedback persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.feedback.model.SPFeedback")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPFeedback>> listenersList = new ArrayList<ModelListener<SPFeedback>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPFeedback>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPFeedbackImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPFEEDBACK = "SELECT spFeedback FROM SPFeedback spFeedback";
	private static final String _SQL_COUNT_SPFEEDBACK = "SELECT COUNT(spFeedback) FROM SPFeedback spFeedback";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spFeedback.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPFeedback exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPFeedbackPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
	private static SPFeedback _nullSPFeedback = new SPFeedbackImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPFeedback> toCacheModel() {
				return _nullSPFeedbackCacheModel;
			}
		};

	private static CacheModel<SPFeedback> _nullSPFeedbackCacheModel = new CacheModel<SPFeedback>() {
			@Override
			public SPFeedback toEntityModel() {
				return _nullSPFeedback;
			}
		};
}