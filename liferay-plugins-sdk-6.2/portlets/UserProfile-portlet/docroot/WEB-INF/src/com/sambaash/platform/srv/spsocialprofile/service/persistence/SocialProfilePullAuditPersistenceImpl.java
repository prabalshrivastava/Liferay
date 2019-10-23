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

package com.sambaash.platform.srv.spsocialprofile.service.persistence;

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

import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfilePullAuditException;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit;
import com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfilePullAuditImpl;
import com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfilePullAuditModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the social profile pull audit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfilePullAuditPersistence
 * @see SocialProfilePullAuditUtil
 * @generated
 */
public class SocialProfilePullAuditPersistenceImpl extends BasePersistenceImpl<SocialProfilePullAudit>
	implements SocialProfilePullAuditPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SocialProfilePullAuditUtil} to access the social profile pull audit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SocialProfilePullAuditImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SocialProfilePullAuditModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfilePullAuditModelImpl.FINDER_CACHE_ENABLED,
			SocialProfilePullAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SocialProfilePullAuditModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfilePullAuditModelImpl.FINDER_CACHE_ENABLED,
			SocialProfilePullAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SocialProfilePullAuditModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfilePullAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_USERIDANDSOCIALNETWORKPROFILEID =
		new FinderPath(SocialProfilePullAuditModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfilePullAuditModelImpl.FINDER_CACHE_ENABLED,
			SocialProfilePullAuditImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserIdAndSocialNetworkProfileId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			SocialProfilePullAuditModelImpl.COMPANYID_COLUMN_BITMASK |
			SocialProfilePullAuditModelImpl.USERID_COLUMN_BITMASK |
			SocialProfilePullAuditModelImpl.SOCIALNETWORKPROFILEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDSOCIALNETWORKPROFILEID =
		new FinderPath(SocialProfilePullAuditModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfilePullAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndSocialNetworkProfileId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the social profile pull audit where companyId = &#63; and userId = &#63; and socialNetworkProfileId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfilePullAuditException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param socialNetworkProfileId the social network profile ID
	 * @return the matching social profile pull audit
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfilePullAuditException if a matching social profile pull audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfilePullAudit findByUserIdAndSocialNetworkProfileId(
		long companyId, long userId, long socialNetworkProfileId)
		throws NoSuchSocialProfilePullAuditException, SystemException {
		SocialProfilePullAudit socialProfilePullAudit = fetchByUserIdAndSocialNetworkProfileId(companyId,
				userId, socialNetworkProfileId);

		if (socialProfilePullAudit == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(", socialNetworkProfileId=");
			msg.append(socialNetworkProfileId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSocialProfilePullAuditException(msg.toString());
		}

		return socialProfilePullAudit;
	}

	/**
	 * Returns the social profile pull audit where companyId = &#63; and userId = &#63; and socialNetworkProfileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param socialNetworkProfileId the social network profile ID
	 * @return the matching social profile pull audit, or <code>null</code> if a matching social profile pull audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfilePullAudit fetchByUserIdAndSocialNetworkProfileId(
		long companyId, long userId, long socialNetworkProfileId)
		throws SystemException {
		return fetchByUserIdAndSocialNetworkProfileId(companyId, userId,
			socialNetworkProfileId, true);
	}

	/**
	 * Returns the social profile pull audit where companyId = &#63; and userId = &#63; and socialNetworkProfileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param socialNetworkProfileId the social network profile ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching social profile pull audit, or <code>null</code> if a matching social profile pull audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfilePullAudit fetchByUserIdAndSocialNetworkProfileId(
		long companyId, long userId, long socialNetworkProfileId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, userId, socialNetworkProfileId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERIDANDSOCIALNETWORKPROFILEID,
					finderArgs, this);
		}

		if (result instanceof SocialProfilePullAudit) {
			SocialProfilePullAudit socialProfilePullAudit = (SocialProfilePullAudit)result;

			if ((companyId != socialProfilePullAudit.getCompanyId()) ||
					(userId != socialProfilePullAudit.getUserId()) ||
					(socialNetworkProfileId != socialProfilePullAudit.getSocialNetworkProfileId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_SOCIALPROFILEPULLAUDIT_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDSOCIALNETWORKPROFILEID_COMPANYID_2);

			query.append(_FINDER_COLUMN_USERIDANDSOCIALNETWORKPROFILEID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDANDSOCIALNETWORKPROFILEID_SOCIALNETWORKPROFILEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(userId);

				qPos.add(socialNetworkProfileId);

				List<SocialProfilePullAudit> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDSOCIALNETWORKPROFILEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SocialProfilePullAuditPersistenceImpl.fetchByUserIdAndSocialNetworkProfileId(long, long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SocialProfilePullAudit socialProfilePullAudit = list.get(0);

					result = socialProfilePullAudit;

					cacheResult(socialProfilePullAudit);

					if ((socialProfilePullAudit.getCompanyId() != companyId) ||
							(socialProfilePullAudit.getUserId() != userId) ||
							(socialProfilePullAudit.getSocialNetworkProfileId() != socialNetworkProfileId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDSOCIALNETWORKPROFILEID,
							finderArgs, socialProfilePullAudit);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDSOCIALNETWORKPROFILEID,
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
			return (SocialProfilePullAudit)result;
		}
	}

	/**
	 * Removes the social profile pull audit where companyId = &#63; and userId = &#63; and socialNetworkProfileId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param socialNetworkProfileId the social network profile ID
	 * @return the social profile pull audit that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfilePullAudit removeByUserIdAndSocialNetworkProfileId(
		long companyId, long userId, long socialNetworkProfileId)
		throws NoSuchSocialProfilePullAuditException, SystemException {
		SocialProfilePullAudit socialProfilePullAudit = findByUserIdAndSocialNetworkProfileId(companyId,
				userId, socialNetworkProfileId);

		return remove(socialProfilePullAudit);
	}

	/**
	 * Returns the number of social profile pull audits where companyId = &#63; and userId = &#63; and socialNetworkProfileId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param socialNetworkProfileId the social network profile ID
	 * @return the number of matching social profile pull audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdAndSocialNetworkProfileId(long companyId,
		long userId, long socialNetworkProfileId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDSOCIALNETWORKPROFILEID;

		Object[] finderArgs = new Object[] {
				companyId, userId, socialNetworkProfileId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SOCIALPROFILEPULLAUDIT_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDSOCIALNETWORKPROFILEID_COMPANYID_2);

			query.append(_FINDER_COLUMN_USERIDANDSOCIALNETWORKPROFILEID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDANDSOCIALNETWORKPROFILEID_SOCIALNETWORKPROFILEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(userId);

				qPos.add(socialNetworkProfileId);

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

	private static final String _FINDER_COLUMN_USERIDANDSOCIALNETWORKPROFILEID_COMPANYID_2 =
		"socialProfilePullAudit.companyId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDSOCIALNETWORKPROFILEID_USERID_2 =
		"socialProfilePullAudit.id.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDSOCIALNETWORKPROFILEID_SOCIALNETWORKPROFILEID_2 =
		"socialProfilePullAudit.id.socialNetworkProfileId = ?";

	public SocialProfilePullAuditPersistenceImpl() {
		setModelClass(SocialProfilePullAudit.class);
	}

	/**
	 * Caches the social profile pull audit in the entity cache if it is enabled.
	 *
	 * @param socialProfilePullAudit the social profile pull audit
	 */
	@Override
	public void cacheResult(SocialProfilePullAudit socialProfilePullAudit) {
		EntityCacheUtil.putResult(SocialProfilePullAuditModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfilePullAuditImpl.class,
			socialProfilePullAudit.getPrimaryKey(), socialProfilePullAudit);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDSOCIALNETWORKPROFILEID,
			new Object[] {
				socialProfilePullAudit.getCompanyId(),
				socialProfilePullAudit.getUserId(),
				socialProfilePullAudit.getSocialNetworkProfileId()
			}, socialProfilePullAudit);

		socialProfilePullAudit.resetOriginalValues();
	}

	/**
	 * Caches the social profile pull audits in the entity cache if it is enabled.
	 *
	 * @param socialProfilePullAudits the social profile pull audits
	 */
	@Override
	public void cacheResult(
		List<SocialProfilePullAudit> socialProfilePullAudits) {
		for (SocialProfilePullAudit socialProfilePullAudit : socialProfilePullAudits) {
			if (EntityCacheUtil.getResult(
						SocialProfilePullAuditModelImpl.ENTITY_CACHE_ENABLED,
						SocialProfilePullAuditImpl.class,
						socialProfilePullAudit.getPrimaryKey()) == null) {
				cacheResult(socialProfilePullAudit);
			}
			else {
				socialProfilePullAudit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all social profile pull audits.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SocialProfilePullAuditImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SocialProfilePullAuditImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the social profile pull audit.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SocialProfilePullAudit socialProfilePullAudit) {
		EntityCacheUtil.removeResult(SocialProfilePullAuditModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfilePullAuditImpl.class,
			socialProfilePullAudit.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(socialProfilePullAudit);
	}

	@Override
	public void clearCache(List<SocialProfilePullAudit> socialProfilePullAudits) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SocialProfilePullAudit socialProfilePullAudit : socialProfilePullAudits) {
			EntityCacheUtil.removeResult(SocialProfilePullAuditModelImpl.ENTITY_CACHE_ENABLED,
				SocialProfilePullAuditImpl.class,
				socialProfilePullAudit.getPrimaryKey());

			clearUniqueFindersCache(socialProfilePullAudit);
		}
	}

	protected void cacheUniqueFindersCache(
		SocialProfilePullAudit socialProfilePullAudit) {
		if (socialProfilePullAudit.isNew()) {
			Object[] args = new Object[] {
					socialProfilePullAudit.getCompanyId(),
					socialProfilePullAudit.getUserId(),
					socialProfilePullAudit.getSocialNetworkProfileId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDSOCIALNETWORKPROFILEID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDSOCIALNETWORKPROFILEID,
				args, socialProfilePullAudit);
		}
		else {
			SocialProfilePullAuditModelImpl socialProfilePullAuditModelImpl = (SocialProfilePullAuditModelImpl)socialProfilePullAudit;

			if ((socialProfilePullAuditModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERIDANDSOCIALNETWORKPROFILEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfilePullAudit.getCompanyId(),
						socialProfilePullAudit.getUserId(),
						socialProfilePullAudit.getSocialNetworkProfileId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDSOCIALNETWORKPROFILEID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDSOCIALNETWORKPROFILEID,
					args, socialProfilePullAudit);
			}
		}
	}

	protected void clearUniqueFindersCache(
		SocialProfilePullAudit socialProfilePullAudit) {
		SocialProfilePullAuditModelImpl socialProfilePullAuditModelImpl = (SocialProfilePullAuditModelImpl)socialProfilePullAudit;

		Object[] args = new Object[] {
				socialProfilePullAudit.getCompanyId(),
				socialProfilePullAudit.getUserId(),
				socialProfilePullAudit.getSocialNetworkProfileId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDSOCIALNETWORKPROFILEID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDSOCIALNETWORKPROFILEID,
			args);

		if ((socialProfilePullAuditModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERIDANDSOCIALNETWORKPROFILEID.getColumnBitmask()) != 0) {
			args = new Object[] {
					socialProfilePullAuditModelImpl.getOriginalCompanyId(),
					socialProfilePullAuditModelImpl.getOriginalUserId(),
					socialProfilePullAuditModelImpl.getOriginalSocialNetworkProfileId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDSOCIALNETWORKPROFILEID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDSOCIALNETWORKPROFILEID,
				args);
		}
	}

	/**
	 * Creates a new social profile pull audit with the primary key. Does not add the social profile pull audit to the database.
	 *
	 * @param socialProfilePullAuditPK the primary key for the new social profile pull audit
	 * @return the new social profile pull audit
	 */
	@Override
	public SocialProfilePullAudit create(
		SocialProfilePullAuditPK socialProfilePullAuditPK) {
		SocialProfilePullAudit socialProfilePullAudit = new SocialProfilePullAuditImpl();

		socialProfilePullAudit.setNew(true);
		socialProfilePullAudit.setPrimaryKey(socialProfilePullAuditPK);

		return socialProfilePullAudit;
	}

	/**
	 * Removes the social profile pull audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param socialProfilePullAuditPK the primary key of the social profile pull audit
	 * @return the social profile pull audit that was removed
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfilePullAuditException if a social profile pull audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfilePullAudit remove(
		SocialProfilePullAuditPK socialProfilePullAuditPK)
		throws NoSuchSocialProfilePullAuditException, SystemException {
		return remove((Serializable)socialProfilePullAuditPK);
	}

	/**
	 * Removes the social profile pull audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the social profile pull audit
	 * @return the social profile pull audit that was removed
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfilePullAuditException if a social profile pull audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfilePullAudit remove(Serializable primaryKey)
		throws NoSuchSocialProfilePullAuditException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SocialProfilePullAudit socialProfilePullAudit = (SocialProfilePullAudit)session.get(SocialProfilePullAuditImpl.class,
					primaryKey);

			if (socialProfilePullAudit == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSocialProfilePullAuditException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(socialProfilePullAudit);
		}
		catch (NoSuchSocialProfilePullAuditException nsee) {
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
	protected SocialProfilePullAudit removeImpl(
		SocialProfilePullAudit socialProfilePullAudit)
		throws SystemException {
		socialProfilePullAudit = toUnwrappedModel(socialProfilePullAudit);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(socialProfilePullAudit)) {
				socialProfilePullAudit = (SocialProfilePullAudit)session.get(SocialProfilePullAuditImpl.class,
						socialProfilePullAudit.getPrimaryKeyObj());
			}

			if (socialProfilePullAudit != null) {
				session.delete(socialProfilePullAudit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (socialProfilePullAudit != null) {
			clearCache(socialProfilePullAudit);
		}

		return socialProfilePullAudit;
	}

	@Override
	public SocialProfilePullAudit updateImpl(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit socialProfilePullAudit)
		throws SystemException {
		socialProfilePullAudit = toUnwrappedModel(socialProfilePullAudit);

		boolean isNew = socialProfilePullAudit.isNew();

		Session session = null;

		try {
			session = openSession();

			if (socialProfilePullAudit.isNew()) {
				session.save(socialProfilePullAudit);

				socialProfilePullAudit.setNew(false);
			}
			else {
				session.merge(socialProfilePullAudit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SocialProfilePullAuditModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(SocialProfilePullAuditModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfilePullAuditImpl.class,
			socialProfilePullAudit.getPrimaryKey(), socialProfilePullAudit);

		clearUniqueFindersCache(socialProfilePullAudit);
		cacheUniqueFindersCache(socialProfilePullAudit);

		return socialProfilePullAudit;
	}

	protected SocialProfilePullAudit toUnwrappedModel(
		SocialProfilePullAudit socialProfilePullAudit) {
		if (socialProfilePullAudit instanceof SocialProfilePullAuditImpl) {
			return socialProfilePullAudit;
		}

		SocialProfilePullAuditImpl socialProfilePullAuditImpl = new SocialProfilePullAuditImpl();

		socialProfilePullAuditImpl.setNew(socialProfilePullAudit.isNew());
		socialProfilePullAuditImpl.setPrimaryKey(socialProfilePullAudit.getPrimaryKey());

		socialProfilePullAuditImpl.setUserId(socialProfilePullAudit.getUserId());
		socialProfilePullAuditImpl.setSocialNetworkProfileId(socialProfilePullAudit.getSocialNetworkProfileId());
		socialProfilePullAuditImpl.setCompanyId(socialProfilePullAudit.getCompanyId());
		socialProfilePullAuditImpl.setCreateDate(socialProfilePullAudit.getCreateDate());
		socialProfilePullAuditImpl.setLastQueriedDate(socialProfilePullAudit.getLastQueriedDate());

		return socialProfilePullAuditImpl;
	}

	/**
	 * Returns the social profile pull audit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the social profile pull audit
	 * @return the social profile pull audit
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfilePullAuditException if a social profile pull audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfilePullAudit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSocialProfilePullAuditException, SystemException {
		SocialProfilePullAudit socialProfilePullAudit = fetchByPrimaryKey(primaryKey);

		if (socialProfilePullAudit == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSocialProfilePullAuditException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return socialProfilePullAudit;
	}

	/**
	 * Returns the social profile pull audit with the primary key or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfilePullAuditException} if it could not be found.
	 *
	 * @param socialProfilePullAuditPK the primary key of the social profile pull audit
	 * @return the social profile pull audit
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfilePullAuditException if a social profile pull audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfilePullAudit findByPrimaryKey(
		SocialProfilePullAuditPK socialProfilePullAuditPK)
		throws NoSuchSocialProfilePullAuditException, SystemException {
		return findByPrimaryKey((Serializable)socialProfilePullAuditPK);
	}

	/**
	 * Returns the social profile pull audit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the social profile pull audit
	 * @return the social profile pull audit, or <code>null</code> if a social profile pull audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfilePullAudit fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SocialProfilePullAudit socialProfilePullAudit = (SocialProfilePullAudit)EntityCacheUtil.getResult(SocialProfilePullAuditModelImpl.ENTITY_CACHE_ENABLED,
				SocialProfilePullAuditImpl.class, primaryKey);

		if (socialProfilePullAudit == _nullSocialProfilePullAudit) {
			return null;
		}

		if (socialProfilePullAudit == null) {
			Session session = null;

			try {
				session = openSession();

				socialProfilePullAudit = (SocialProfilePullAudit)session.get(SocialProfilePullAuditImpl.class,
						primaryKey);

				if (socialProfilePullAudit != null) {
					cacheResult(socialProfilePullAudit);
				}
				else {
					EntityCacheUtil.putResult(SocialProfilePullAuditModelImpl.ENTITY_CACHE_ENABLED,
						SocialProfilePullAuditImpl.class, primaryKey,
						_nullSocialProfilePullAudit);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SocialProfilePullAuditModelImpl.ENTITY_CACHE_ENABLED,
					SocialProfilePullAuditImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return socialProfilePullAudit;
	}

	/**
	 * Returns the social profile pull audit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param socialProfilePullAuditPK the primary key of the social profile pull audit
	 * @return the social profile pull audit, or <code>null</code> if a social profile pull audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfilePullAudit fetchByPrimaryKey(
		SocialProfilePullAuditPK socialProfilePullAuditPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)socialProfilePullAuditPK);
	}

	/**
	 * Returns all the social profile pull audits.
	 *
	 * @return the social profile pull audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfilePullAudit> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social profile pull audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfilePullAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of social profile pull audits
	 * @param end the upper bound of the range of social profile pull audits (not inclusive)
	 * @return the range of social profile pull audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfilePullAudit> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the social profile pull audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfilePullAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of social profile pull audits
	 * @param end the upper bound of the range of social profile pull audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of social profile pull audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfilePullAudit> findAll(int start, int end,
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

		List<SocialProfilePullAudit> list = (List<SocialProfilePullAudit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SOCIALPROFILEPULLAUDIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SOCIALPROFILEPULLAUDIT;

				if (pagination) {
					sql = sql.concat(SocialProfilePullAuditModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SocialProfilePullAudit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SocialProfilePullAudit>(list);
				}
				else {
					list = (List<SocialProfilePullAudit>)QueryUtil.list(q,
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
	 * Removes all the social profile pull audits from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SocialProfilePullAudit socialProfilePullAudit : findAll()) {
			remove(socialProfilePullAudit);
		}
	}

	/**
	 * Returns the number of social profile pull audits.
	 *
	 * @return the number of social profile pull audits
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

				Query q = session.createQuery(_SQL_COUNT_SOCIALPROFILEPULLAUDIT);

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
	 * Initializes the social profile pull audit persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SocialProfilePullAudit>> listenersList = new ArrayList<ModelListener<SocialProfilePullAudit>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SocialProfilePullAudit>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SocialProfilePullAuditImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SOCIALPROFILEPULLAUDIT = "SELECT socialProfilePullAudit FROM SocialProfilePullAudit socialProfilePullAudit";
	private static final String _SQL_SELECT_SOCIALPROFILEPULLAUDIT_WHERE = "SELECT socialProfilePullAudit FROM SocialProfilePullAudit socialProfilePullAudit WHERE ";
	private static final String _SQL_COUNT_SOCIALPROFILEPULLAUDIT = "SELECT COUNT(socialProfilePullAudit) FROM SocialProfilePullAudit socialProfilePullAudit";
	private static final String _SQL_COUNT_SOCIALPROFILEPULLAUDIT_WHERE = "SELECT COUNT(socialProfilePullAudit) FROM SocialProfilePullAudit socialProfilePullAudit WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "socialProfilePullAudit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SocialProfilePullAudit exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SocialProfilePullAudit exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SocialProfilePullAuditPersistenceImpl.class);
	private static SocialProfilePullAudit _nullSocialProfilePullAudit = new SocialProfilePullAuditImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SocialProfilePullAudit> toCacheModel() {
				return _nullSocialProfilePullAuditCacheModel;
			}
		};

	private static CacheModel<SocialProfilePullAudit> _nullSocialProfilePullAuditCacheModel =
		new CacheModel<SocialProfilePullAudit>() {
			@Override
			public SocialProfilePullAudit toEntityModel() {
				return _nullSocialProfilePullAudit;
			}
		};
}