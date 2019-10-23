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

package com.sambaash.platform.srv.spservices.service.persistence;

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

import com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException;
import com.sambaash.platform.srv.spservices.model.SPLdapProfile;
import com.sambaash.platform.srv.spservices.model.impl.SPLdapProfileImpl;
import com.sambaash.platform.srv.spservices.model.impl.SPLdapProfileModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p ldap profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPLdapProfilePersistence
 * @see SPLdapProfileUtil
 * @generated
 */
public class SPLdapProfilePersistenceImpl extends BasePersistenceImpl<SPLdapProfile>
	implements SPLdapProfilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPLdapProfileUtil} to access the s p ldap profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPLdapProfileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPLdapProfileModelImpl.ENTITY_CACHE_ENABLED,
			SPLdapProfileModelImpl.FINDER_CACHE_ENABLED,
			SPLdapProfileImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPLdapProfileModelImpl.ENTITY_CACHE_ENABLED,
			SPLdapProfileModelImpl.FINDER_CACHE_ENABLED,
			SPLdapProfileImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPLdapProfileModelImpl.ENTITY_CACHE_ENABLED,
			SPLdapProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(SPLdapProfileModelImpl.ENTITY_CACHE_ENABLED,
			SPLdapProfileModelImpl.FINDER_CACHE_ENABLED,
			SPLdapProfileImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByUserId",
			new String[] { Long.class.getName() },
			SPLdapProfileModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(SPLdapProfileModelImpl.ENTITY_CACHE_ENABLED,
			SPLdapProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the s p ldap profile where userId = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching s p ldap profile
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException if a matching s p ldap profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLdapProfile findByUserId(long userId)
		throws NoSuchSPLdapProfileException, SystemException {
		SPLdapProfile spLdapProfile = fetchByUserId(userId);

		if (spLdapProfile == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSPLdapProfileException(msg.toString());
		}

		return spLdapProfile;
	}

	/**
	 * Returns the s p ldap profile where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching s p ldap profile, or <code>null</code> if a matching s p ldap profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLdapProfile fetchByUserId(long userId) throws SystemException {
		return fetchByUserId(userId, true);
	}

	/**
	 * Returns the s p ldap profile where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p ldap profile, or <code>null</code> if a matching s p ldap profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLdapProfile fetchByUserId(long userId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result instanceof SPLdapProfile) {
			SPLdapProfile spLdapProfile = (SPLdapProfile)result;

			if ((userId != spLdapProfile.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SPLDAPPROFILE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<SPLdapProfile> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SPLdapProfilePersistenceImpl.fetchByUserId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SPLdapProfile spLdapProfile = list.get(0);

					result = spLdapProfile;

					cacheResult(spLdapProfile);

					if ((spLdapProfile.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, spLdapProfile);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
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
			return (SPLdapProfile)result;
		}
	}

	/**
	 * Removes the s p ldap profile where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the s p ldap profile that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLdapProfile removeByUserId(long userId)
		throws NoSuchSPLdapProfileException, SystemException {
		SPLdapProfile spLdapProfile = findByUserId(userId);

		return remove(spLdapProfile);
	}

	/**
	 * Returns the number of s p ldap profiles where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching s p ldap profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPLDAPPROFILE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "spLdapProfile.userId = ?";

	public SPLdapProfilePersistenceImpl() {
		setModelClass(SPLdapProfile.class);
	}

	/**
	 * Caches the s p ldap profile in the entity cache if it is enabled.
	 *
	 * @param spLdapProfile the s p ldap profile
	 */
	@Override
	public void cacheResult(SPLdapProfile spLdapProfile) {
		EntityCacheUtil.putResult(SPLdapProfileModelImpl.ENTITY_CACHE_ENABLED,
			SPLdapProfileImpl.class, spLdapProfile.getPrimaryKey(),
			spLdapProfile);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { spLdapProfile.getUserId() }, spLdapProfile);

		spLdapProfile.resetOriginalValues();
	}

	/**
	 * Caches the s p ldap profiles in the entity cache if it is enabled.
	 *
	 * @param spLdapProfiles the s p ldap profiles
	 */
	@Override
	public void cacheResult(List<SPLdapProfile> spLdapProfiles) {
		for (SPLdapProfile spLdapProfile : spLdapProfiles) {
			if (EntityCacheUtil.getResult(
						SPLdapProfileModelImpl.ENTITY_CACHE_ENABLED,
						SPLdapProfileImpl.class, spLdapProfile.getPrimaryKey()) == null) {
				cacheResult(spLdapProfile);
			}
			else {
				spLdapProfile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p ldap profiles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPLdapProfileImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPLdapProfileImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p ldap profile.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPLdapProfile spLdapProfile) {
		EntityCacheUtil.removeResult(SPLdapProfileModelImpl.ENTITY_CACHE_ENABLED,
			SPLdapProfileImpl.class, spLdapProfile.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spLdapProfile);
	}

	@Override
	public void clearCache(List<SPLdapProfile> spLdapProfiles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPLdapProfile spLdapProfile : spLdapProfiles) {
			EntityCacheUtil.removeResult(SPLdapProfileModelImpl.ENTITY_CACHE_ENABLED,
				SPLdapProfileImpl.class, spLdapProfile.getPrimaryKey());

			clearUniqueFindersCache(spLdapProfile);
		}
	}

	protected void cacheUniqueFindersCache(SPLdapProfile spLdapProfile) {
		if (spLdapProfile.isNew()) {
			Object[] args = new Object[] { spLdapProfile.getUserId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
				spLdapProfile);
		}
		else {
			SPLdapProfileModelImpl spLdapProfileModelImpl = (SPLdapProfileModelImpl)spLdapProfile;

			if ((spLdapProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { spLdapProfile.getUserId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
					spLdapProfile);
			}
		}
	}

	protected void clearUniqueFindersCache(SPLdapProfile spLdapProfile) {
		SPLdapProfileModelImpl spLdapProfileModelImpl = (SPLdapProfileModelImpl)spLdapProfile;

		Object[] args = new Object[] { spLdapProfile.getUserId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

		if ((spLdapProfileModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
			args = new Object[] { spLdapProfileModelImpl.getOriginalUserId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);
		}
	}

	/**
	 * Creates a new s p ldap profile with the primary key. Does not add the s p ldap profile to the database.
	 *
	 * @param spLdapProfileId the primary key for the new s p ldap profile
	 * @return the new s p ldap profile
	 */
	@Override
	public SPLdapProfile create(long spLdapProfileId) {
		SPLdapProfile spLdapProfile = new SPLdapProfileImpl();

		spLdapProfile.setNew(true);
		spLdapProfile.setPrimaryKey(spLdapProfileId);

		return spLdapProfile;
	}

	/**
	 * Removes the s p ldap profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spLdapProfileId the primary key of the s p ldap profile
	 * @return the s p ldap profile that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException if a s p ldap profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLdapProfile remove(long spLdapProfileId)
		throws NoSuchSPLdapProfileException, SystemException {
		return remove((Serializable)spLdapProfileId);
	}

	/**
	 * Removes the s p ldap profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p ldap profile
	 * @return the s p ldap profile that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException if a s p ldap profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLdapProfile remove(Serializable primaryKey)
		throws NoSuchSPLdapProfileException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPLdapProfile spLdapProfile = (SPLdapProfile)session.get(SPLdapProfileImpl.class,
					primaryKey);

			if (spLdapProfile == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPLdapProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spLdapProfile);
		}
		catch (NoSuchSPLdapProfileException nsee) {
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
	protected SPLdapProfile removeImpl(SPLdapProfile spLdapProfile)
		throws SystemException {
		spLdapProfile = toUnwrappedModel(spLdapProfile);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spLdapProfile)) {
				spLdapProfile = (SPLdapProfile)session.get(SPLdapProfileImpl.class,
						spLdapProfile.getPrimaryKeyObj());
			}

			if (spLdapProfile != null) {
				session.delete(spLdapProfile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spLdapProfile != null) {
			clearCache(spLdapProfile);
		}

		return spLdapProfile;
	}

	@Override
	public SPLdapProfile updateImpl(
		com.sambaash.platform.srv.spservices.model.SPLdapProfile spLdapProfile)
		throws SystemException {
		spLdapProfile = toUnwrappedModel(spLdapProfile);

		boolean isNew = spLdapProfile.isNew();

		Session session = null;

		try {
			session = openSession();

			if (spLdapProfile.isNew()) {
				session.save(spLdapProfile);

				spLdapProfile.setNew(false);
			}
			else {
				session.merge(spLdapProfile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPLdapProfileModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(SPLdapProfileModelImpl.ENTITY_CACHE_ENABLED,
			SPLdapProfileImpl.class, spLdapProfile.getPrimaryKey(),
			spLdapProfile);

		clearUniqueFindersCache(spLdapProfile);
		cacheUniqueFindersCache(spLdapProfile);

		return spLdapProfile;
	}

	protected SPLdapProfile toUnwrappedModel(SPLdapProfile spLdapProfile) {
		if (spLdapProfile instanceof SPLdapProfileImpl) {
			return spLdapProfile;
		}

		SPLdapProfileImpl spLdapProfileImpl = new SPLdapProfileImpl();

		spLdapProfileImpl.setNew(spLdapProfile.isNew());
		spLdapProfileImpl.setPrimaryKey(spLdapProfile.getPrimaryKey());

		spLdapProfileImpl.setSpLdapProfileId(spLdapProfile.getSpLdapProfileId());
		spLdapProfileImpl.setGroupId(spLdapProfile.getGroupId());
		spLdapProfileImpl.setCompanyId(spLdapProfile.getCompanyId());
		spLdapProfileImpl.setCreateDate(spLdapProfile.getCreateDate());
		spLdapProfileImpl.setModifiedDate(spLdapProfile.getModifiedDate());
		spLdapProfileImpl.setUserId(spLdapProfile.getUserId());
		spLdapProfileImpl.setCountryId(spLdapProfile.getCountryId());
		spLdapProfileImpl.setDepartmentId(spLdapProfile.getDepartmentId());
		spLdapProfileImpl.setGivenName(spLdapProfile.getGivenName());
		spLdapProfileImpl.setSn(spLdapProfile.getSn());
		spLdapProfileImpl.setDisplayName(spLdapProfile.getDisplayName());
		spLdapProfileImpl.setCompany(spLdapProfile.getCompany());
		spLdapProfileImpl.setDivision(spLdapProfile.getDivision());
		spLdapProfileImpl.setTitle(spLdapProfile.getTitle());
		spLdapProfileImpl.setMail(spLdapProfile.getMail());
		spLdapProfileImpl.setSamAccountName(spLdapProfile.getSamAccountName());
		spLdapProfileImpl.setEmployeeId(spLdapProfile.getEmployeeId());
		spLdapProfileImpl.setManager(spLdapProfile.getManager());
		spLdapProfileImpl.setTelephoneNumber(spLdapProfile.getTelephoneNumber());
		spLdapProfileImpl.setMobile(spLdapProfile.getMobile());
		spLdapProfileImpl.setFacsimileTelephoneNumber(spLdapProfile.getFacsimileTelephoneNumber());

		return spLdapProfileImpl;
	}

	/**
	 * Returns the s p ldap profile with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p ldap profile
	 * @return the s p ldap profile
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException if a s p ldap profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLdapProfile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPLdapProfileException, SystemException {
		SPLdapProfile spLdapProfile = fetchByPrimaryKey(primaryKey);

		if (spLdapProfile == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPLdapProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spLdapProfile;
	}

	/**
	 * Returns the s p ldap profile with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException} if it could not be found.
	 *
	 * @param spLdapProfileId the primary key of the s p ldap profile
	 * @return the s p ldap profile
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLdapProfileException if a s p ldap profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLdapProfile findByPrimaryKey(long spLdapProfileId)
		throws NoSuchSPLdapProfileException, SystemException {
		return findByPrimaryKey((Serializable)spLdapProfileId);
	}

	/**
	 * Returns the s p ldap profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p ldap profile
	 * @return the s p ldap profile, or <code>null</code> if a s p ldap profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLdapProfile fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPLdapProfile spLdapProfile = (SPLdapProfile)EntityCacheUtil.getResult(SPLdapProfileModelImpl.ENTITY_CACHE_ENABLED,
				SPLdapProfileImpl.class, primaryKey);

		if (spLdapProfile == _nullSPLdapProfile) {
			return null;
		}

		if (spLdapProfile == null) {
			Session session = null;

			try {
				session = openSession();

				spLdapProfile = (SPLdapProfile)session.get(SPLdapProfileImpl.class,
						primaryKey);

				if (spLdapProfile != null) {
					cacheResult(spLdapProfile);
				}
				else {
					EntityCacheUtil.putResult(SPLdapProfileModelImpl.ENTITY_CACHE_ENABLED,
						SPLdapProfileImpl.class, primaryKey, _nullSPLdapProfile);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPLdapProfileModelImpl.ENTITY_CACHE_ENABLED,
					SPLdapProfileImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spLdapProfile;
	}

	/**
	 * Returns the s p ldap profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spLdapProfileId the primary key of the s p ldap profile
	 * @return the s p ldap profile, or <code>null</code> if a s p ldap profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLdapProfile fetchByPrimaryKey(long spLdapProfileId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spLdapProfileId);
	}

	/**
	 * Returns all the s p ldap profiles.
	 *
	 * @return the s p ldap profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPLdapProfile> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p ldap profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLdapProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p ldap profiles
	 * @param end the upper bound of the range of s p ldap profiles (not inclusive)
	 * @return the range of s p ldap profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPLdapProfile> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p ldap profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLdapProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p ldap profiles
	 * @param end the upper bound of the range of s p ldap profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p ldap profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPLdapProfile> findAll(int start, int end,
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

		List<SPLdapProfile> list = (List<SPLdapProfile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPLDAPPROFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPLDAPPROFILE;

				if (pagination) {
					sql = sql.concat(SPLdapProfileModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPLdapProfile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPLdapProfile>(list);
				}
				else {
					list = (List<SPLdapProfile>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p ldap profiles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPLdapProfile spLdapProfile : findAll()) {
			remove(spLdapProfile);
		}
	}

	/**
	 * Returns the number of s p ldap profiles.
	 *
	 * @return the number of s p ldap profiles
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

				Query q = session.createQuery(_SQL_COUNT_SPLDAPPROFILE);

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
	 * Initializes the s p ldap profile persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spservices.model.SPLdapProfile")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPLdapProfile>> listenersList = new ArrayList<ModelListener<SPLdapProfile>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPLdapProfile>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPLdapProfileImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPLDAPPROFILE = "SELECT spLdapProfile FROM SPLdapProfile spLdapProfile";
	private static final String _SQL_SELECT_SPLDAPPROFILE_WHERE = "SELECT spLdapProfile FROM SPLdapProfile spLdapProfile WHERE ";
	private static final String _SQL_COUNT_SPLDAPPROFILE = "SELECT COUNT(spLdapProfile) FROM SPLdapProfile spLdapProfile";
	private static final String _SQL_COUNT_SPLDAPPROFILE_WHERE = "SELECT COUNT(spLdapProfile) FROM SPLdapProfile spLdapProfile WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spLdapProfile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPLdapProfile exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPLdapProfile exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPLdapProfilePersistenceImpl.class);
	private static SPLdapProfile _nullSPLdapProfile = new SPLdapProfileImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPLdapProfile> toCacheModel() {
				return _nullSPLdapProfileCacheModel;
			}
		};

	private static CacheModel<SPLdapProfile> _nullSPLdapProfileCacheModel = new CacheModel<SPLdapProfile>() {
			@Override
			public SPLdapProfile toEntityModel() {
				return _nullSPLdapProfile;
			}
		};
}