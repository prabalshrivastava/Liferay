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

package com.sambaash.platform.srv.extendedprofile.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.extendedprofile.NoSuchSPJobRoleException;
import com.sambaash.platform.srv.extendedprofile.model.SPJobRole;
import com.sambaash.platform.srv.extendedprofile.model.impl.SPJobRoleImpl;
import com.sambaash.platform.srv.extendedprofile.model.impl.SPJobRoleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p job role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPJobRolePersistence
 * @see SPJobRoleUtil
 * @generated
 */
public class SPJobRolePersistenceImpl extends BasePersistenceImpl<SPJobRole>
	implements SPJobRolePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPJobRoleUtil} to access the s p job role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPJobRoleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPJobRoleModelImpl.ENTITY_CACHE_ENABLED,
			SPJobRoleModelImpl.FINDER_CACHE_ENABLED, SPJobRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPJobRoleModelImpl.ENTITY_CACHE_ENABLED,
			SPJobRoleModelImpl.FINDER_CACHE_ENABLED, SPJobRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPJobRoleModelImpl.ENTITY_CACHE_ENABLED,
			SPJobRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_JOBROLE = new FinderPath(SPJobRoleModelImpl.ENTITY_CACHE_ENABLED,
			SPJobRoleModelImpl.FINDER_CACHE_ENABLED, SPJobRoleImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByJobRole",
			new String[] { Long.class.getName() },
			SPJobRoleModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_JOBROLE = new FinderPath(SPJobRoleModelImpl.ENTITY_CACHE_ENABLED,
			SPJobRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByJobRole",
			new String[] { Long.class.getName() });

	/**
	 * Returns the s p job role where userId = &#63; or throws a {@link com.sambaash.platform.srv.extendedprofile.NoSuchSPJobRoleException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching s p job role
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPJobRoleException if a matching s p job role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobRole findByJobRole(long userId)
		throws NoSuchSPJobRoleException, SystemException {
		SPJobRole spJobRole = fetchByJobRole(userId);

		if (spJobRole == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSPJobRoleException(msg.toString());
		}

		return spJobRole;
	}

	/**
	 * Returns the s p job role where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching s p job role, or <code>null</code> if a matching s p job role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobRole fetchByJobRole(long userId) throws SystemException {
		return fetchByJobRole(userId, true);
	}

	/**
	 * Returns the s p job role where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p job role, or <code>null</code> if a matching s p job role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobRole fetchByJobRole(long userId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_JOBROLE,
					finderArgs, this);
		}

		if (result instanceof SPJobRole) {
			SPJobRole spJobRole = (SPJobRole)result;

			if ((userId != spJobRole.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SPJOBROLE_WHERE);

			query.append(_FINDER_COLUMN_JOBROLE_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<SPJobRole> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOBROLE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SPJobRolePersistenceImpl.fetchByJobRole(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SPJobRole spJobRole = list.get(0);

					result = spJobRole;

					cacheResult(spJobRole);

					if ((spJobRole.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOBROLE,
							finderArgs, spJobRole);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_JOBROLE,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (SPJobRole)result;
		}
	}

	/**
	 * Removes the s p job role where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the s p job role that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobRole removeByJobRole(long userId)
		throws NoSuchSPJobRoleException, SystemException {
		SPJobRole spJobRole = findByJobRole(userId);

		return remove(spJobRole);
	}

	/**
	 * Returns the number of s p job roles where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching s p job roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByJobRole(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_JOBROLE;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPJOBROLE_WHERE);

			query.append(_FINDER_COLUMN_JOBROLE_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_JOBROLE_USERID_2 = "spJobRole.userId = ?";

	public SPJobRolePersistenceImpl() {
		setModelClass(SPJobRole.class);
	}

	/**
	 * Caches the s p job role in the entity cache if it is enabled.
	 *
	 * @param spJobRole the s p job role
	 */
	@Override
	public void cacheResult(SPJobRole spJobRole) {
		EntityCacheUtil.putResult(SPJobRoleModelImpl.ENTITY_CACHE_ENABLED,
			SPJobRoleImpl.class, spJobRole.getPrimaryKey(), spJobRole);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOBROLE,
			new Object[] { spJobRole.getUserId() }, spJobRole);

		spJobRole.resetOriginalValues();
	}

	/**
	 * Caches the s p job roles in the entity cache if it is enabled.
	 *
	 * @param spJobRoles the s p job roles
	 */
	@Override
	public void cacheResult(List<SPJobRole> spJobRoles) {
		for (SPJobRole spJobRole : spJobRoles) {
			if (EntityCacheUtil.getResult(
						SPJobRoleModelImpl.ENTITY_CACHE_ENABLED,
						SPJobRoleImpl.class, spJobRole.getPrimaryKey()) == null) {
				cacheResult(spJobRole);
			}
			else {
				spJobRole.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p job roles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPJobRoleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPJobRoleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p job role.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPJobRole spJobRole) {
		EntityCacheUtil.removeResult(SPJobRoleModelImpl.ENTITY_CACHE_ENABLED,
			SPJobRoleImpl.class, spJobRole.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spJobRole);
	}

	@Override
	public void clearCache(List<SPJobRole> spJobRoles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPJobRole spJobRole : spJobRoles) {
			EntityCacheUtil.removeResult(SPJobRoleModelImpl.ENTITY_CACHE_ENABLED,
				SPJobRoleImpl.class, spJobRole.getPrimaryKey());

			clearUniqueFindersCache(spJobRole);
		}
	}

	protected void cacheUniqueFindersCache(SPJobRole spJobRole) {
		if (spJobRole.isNew()) {
			Object[] args = new Object[] { spJobRole.getUserId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_JOBROLE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOBROLE, args,
				spJobRole);
		}
		else {
			SPJobRoleModelImpl spJobRoleModelImpl = (SPJobRoleModelImpl)spJobRole;

			if ((spJobRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_JOBROLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { spJobRole.getUserId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_JOBROLE, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOBROLE, args,
					spJobRole);
			}
		}
	}

	protected void clearUniqueFindersCache(SPJobRole spJobRole) {
		SPJobRoleModelImpl spJobRoleModelImpl = (SPJobRoleModelImpl)spJobRole;

		Object[] args = new Object[] { spJobRole.getUserId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOBROLE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_JOBROLE, args);

		if ((spJobRoleModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_JOBROLE.getColumnBitmask()) != 0) {
			args = new Object[] { spJobRoleModelImpl.getOriginalUserId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOBROLE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_JOBROLE, args);
		}
	}

	/**
	 * Creates a new s p job role with the primary key. Does not add the s p job role to the database.
	 *
	 * @param spJobRoleId the primary key for the new s p job role
	 * @return the new s p job role
	 */
	@Override
	public SPJobRole create(long spJobRoleId) {
		SPJobRole spJobRole = new SPJobRoleImpl();

		spJobRole.setNew(true);
		spJobRole.setPrimaryKey(spJobRoleId);

		return spJobRole;
	}

	/**
	 * Removes the s p job role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spJobRoleId the primary key of the s p job role
	 * @return the s p job role that was removed
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPJobRoleException if a s p job role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobRole remove(long spJobRoleId)
		throws NoSuchSPJobRoleException, SystemException {
		return remove((Serializable)spJobRoleId);
	}

	/**
	 * Removes the s p job role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p job role
	 * @return the s p job role that was removed
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPJobRoleException if a s p job role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobRole remove(Serializable primaryKey)
		throws NoSuchSPJobRoleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPJobRole spJobRole = (SPJobRole)session.get(SPJobRoleImpl.class,
					primaryKey);

			if (spJobRole == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPJobRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spJobRole);
		}
		catch (NoSuchSPJobRoleException nsee) {
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
	protected SPJobRole removeImpl(SPJobRole spJobRole)
		throws SystemException {
		spJobRole = toUnwrappedModel(spJobRole);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spJobRole)) {
				spJobRole = (SPJobRole)session.get(SPJobRoleImpl.class,
						spJobRole.getPrimaryKeyObj());
			}

			if (spJobRole != null) {
				session.delete(spJobRole);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spJobRole != null) {
			clearCache(spJobRole);
		}

		return spJobRole;
	}

	@Override
	public SPJobRole updateImpl(
		com.sambaash.platform.srv.extendedprofile.model.SPJobRole spJobRole)
		throws SystemException {
		spJobRole = toUnwrappedModel(spJobRole);

		boolean isNew = spJobRole.isNew();

		Session session = null;

		try {
			session = openSession();

			if (spJobRole.isNew()) {
				session.save(spJobRole);

				spJobRole.setNew(false);
			}
			else {
				session.merge(spJobRole);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPJobRoleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(SPJobRoleModelImpl.ENTITY_CACHE_ENABLED,
			SPJobRoleImpl.class, spJobRole.getPrimaryKey(), spJobRole);

		clearUniqueFindersCache(spJobRole);
		cacheUniqueFindersCache(spJobRole);

		return spJobRole;
	}

	protected SPJobRole toUnwrappedModel(SPJobRole spJobRole) {
		if (spJobRole instanceof SPJobRoleImpl) {
			return spJobRole;
		}

		SPJobRoleImpl spJobRoleImpl = new SPJobRoleImpl();

		spJobRoleImpl.setNew(spJobRole.isNew());
		spJobRoleImpl.setPrimaryKey(spJobRole.getPrimaryKey());

		spJobRoleImpl.setSpJobRoleId(spJobRole.getSpJobRoleId());
		spJobRoleImpl.setGroupId(spJobRole.getGroupId());
		spJobRoleImpl.setCompanyId(spJobRole.getCompanyId());
		spJobRoleImpl.setUserId(spJobRole.getUserId());
		spJobRoleImpl.setUserName(spJobRole.getUserName());
		spJobRoleImpl.setCreateDate(spJobRole.getCreateDate());
		spJobRoleImpl.setModifiedDate(spJobRole.getModifiedDate());
		spJobRoleImpl.setFunctionalGroupId(spJobRole.getFunctionalGroupId());
		spJobRoleImpl.setJobLevelId(spJobRole.getJobLevelId());
		spJobRoleImpl.setCareerPathId(spJobRole.getCareerPathId());

		return spJobRoleImpl;
	}

	/**
	 * Returns the s p job role with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p job role
	 * @return the s p job role
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPJobRoleException if a s p job role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobRole findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPJobRoleException, SystemException {
		SPJobRole spJobRole = fetchByPrimaryKey(primaryKey);

		if (spJobRole == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPJobRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spJobRole;
	}

	/**
	 * Returns the s p job role with the primary key or throws a {@link com.sambaash.platform.srv.extendedprofile.NoSuchSPJobRoleException} if it could not be found.
	 *
	 * @param spJobRoleId the primary key of the s p job role
	 * @return the s p job role
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPJobRoleException if a s p job role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobRole findByPrimaryKey(long spJobRoleId)
		throws NoSuchSPJobRoleException, SystemException {
		return findByPrimaryKey((Serializable)spJobRoleId);
	}

	/**
	 * Returns the s p job role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p job role
	 * @return the s p job role, or <code>null</code> if a s p job role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobRole fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPJobRole spJobRole = (SPJobRole)EntityCacheUtil.getResult(SPJobRoleModelImpl.ENTITY_CACHE_ENABLED,
				SPJobRoleImpl.class, primaryKey);

		if (spJobRole == _nullSPJobRole) {
			return null;
		}

		if (spJobRole == null) {
			Session session = null;

			try {
				session = openSession();

				spJobRole = (SPJobRole)session.get(SPJobRoleImpl.class,
						primaryKey);

				if (spJobRole != null) {
					cacheResult(spJobRole);
				}
				else {
					EntityCacheUtil.putResult(SPJobRoleModelImpl.ENTITY_CACHE_ENABLED,
						SPJobRoleImpl.class, primaryKey, _nullSPJobRole);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPJobRoleModelImpl.ENTITY_CACHE_ENABLED,
					SPJobRoleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spJobRole;
	}

	/**
	 * Returns the s p job role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spJobRoleId the primary key of the s p job role
	 * @return the s p job role, or <code>null</code> if a s p job role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobRole fetchByPrimaryKey(long spJobRoleId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spJobRoleId);
	}

	/**
	 * Returns all the s p job roles.
	 *
	 * @return the s p job roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobRole> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p job roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPJobRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p job roles
	 * @param end the upper bound of the range of s p job roles (not inclusive)
	 * @return the range of s p job roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobRole> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p job roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPJobRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p job roles
	 * @param end the upper bound of the range of s p job roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p job roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobRole> findAll(int start, int end,
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

		List<SPJobRole> list = (List<SPJobRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPJOBROLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPJOBROLE;

				if (pagination) {
					sql = sql.concat(SPJobRoleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPJobRole>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPJobRole>(list);
				}
				else {
					list = (List<SPJobRole>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p job roles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPJobRole spJobRole : findAll()) {
			remove(spJobRole);
		}
	}

	/**
	 * Returns the number of s p job roles.
	 *
	 * @return the number of s p job roles
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

				Query q = session.createQuery(_SQL_COUNT_SPJOBROLE);

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
	 * Initializes the s p job role persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.extendedprofile.model.SPJobRole")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPJobRole>> listenersList = new ArrayList<ModelListener<SPJobRole>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPJobRole>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPJobRoleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPJOBROLE = "SELECT spJobRole FROM SPJobRole spJobRole";
	private static final String _SQL_SELECT_SPJOBROLE_WHERE = "SELECT spJobRole FROM SPJobRole spJobRole WHERE ";
	private static final String _SQL_COUNT_SPJOBROLE = "SELECT COUNT(spJobRole) FROM SPJobRole spJobRole";
	private static final String _SQL_COUNT_SPJOBROLE_WHERE = "SELECT COUNT(spJobRole) FROM SPJobRole spJobRole WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spJobRole.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPJobRole exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPJobRole exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPJobRolePersistenceImpl.class);
	private static SPJobRole _nullSPJobRole = new SPJobRoleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPJobRole> toCacheModel() {
				return _nullSPJobRoleCacheModel;
			}
		};

	private static CacheModel<SPJobRole> _nullSPJobRoleCacheModel = new CacheModel<SPJobRole>() {
			@Override
			public SPJobRole toEntityModel() {
				return _nullSPJobRole;
			}
		};
}