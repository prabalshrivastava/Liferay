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

package com.sambaash.platform.srv.mail.service.persistence;

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

import com.sambaash.platform.srv.mail.NoSuchSubscriberUserAgentException;
import com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent;
import com.sambaash.platform.srv.mail.model.impl.SPMailSubscriberUserAgentImpl;
import com.sambaash.platform.srv.mail.model.impl.SPMailSubscriberUserAgentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p mail subscriber user agent service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailSubscriberUserAgentPersistence
 * @see SPMailSubscriberUserAgentUtil
 * @generated
 */
public class SPMailSubscriberUserAgentPersistenceImpl
	extends BasePersistenceImpl<SPMailSubscriberUserAgent>
	implements SPMailSubscriberUserAgentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPMailSubscriberUserAgentUtil} to access the s p mail subscriber user agent persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPMailSubscriberUserAgentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPMailSubscriberUserAgentModelImpl.ENTITY_CACHE_ENABLED,
			SPMailSubscriberUserAgentModelImpl.FINDER_CACHE_ENABLED,
			SPMailSubscriberUserAgentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPMailSubscriberUserAgentModelImpl.ENTITY_CACHE_ENABLED,
			SPMailSubscriberUserAgentModelImpl.FINDER_CACHE_ENABLED,
			SPMailSubscriberUserAgentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPMailSubscriberUserAgentModelImpl.ENTITY_CACHE_ENABLED,
			SPMailSubscriberUserAgentModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CAMPAIGNIDANDSUBSCRIBERSID =
		new FinderPath(SPMailSubscriberUserAgentModelImpl.ENTITY_CACHE_ENABLED,
			SPMailSubscriberUserAgentModelImpl.FINDER_CACHE_ENABLED,
			SPMailSubscriberUserAgentImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCampaignIdAndSubscribersId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SPMailSubscriberUserAgentModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK |
			SPMailSubscriberUserAgentModelImpl.SPMAILCAMPAIGNSUBSCRIBERSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNIDANDSUBSCRIBERSID =
		new FinderPath(SPMailSubscriberUserAgentModelImpl.ENTITY_CACHE_ENABLED,
			SPMailSubscriberUserAgentModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCampaignIdAndSubscribersId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p mail subscriber user agent where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchSubscriberUserAgentException} if it could not be found.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	 * @return the matching s p mail subscriber user agent
	 * @throws com.sambaash.platform.srv.mail.NoSuchSubscriberUserAgentException if a matching s p mail subscriber user agent could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailSubscriberUserAgent findByCampaignIdAndSubscribersId(
		long spMailCampaignId, long spMailCampaignSubscribersId)
		throws NoSuchSubscriberUserAgentException, SystemException {
		SPMailSubscriberUserAgent spMailSubscriberUserAgent = fetchByCampaignIdAndSubscribersId(spMailCampaignId,
				spMailCampaignSubscribersId);

		if (spMailSubscriberUserAgent == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("spMailCampaignId=");
			msg.append(spMailCampaignId);

			msg.append(", spMailCampaignSubscribersId=");
			msg.append(spMailCampaignSubscribersId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSubscriberUserAgentException(msg.toString());
		}

		return spMailSubscriberUserAgent;
	}

	/**
	 * Returns the s p mail subscriber user agent where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	 * @return the matching s p mail subscriber user agent, or <code>null</code> if a matching s p mail subscriber user agent could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailSubscriberUserAgent fetchByCampaignIdAndSubscribersId(
		long spMailCampaignId, long spMailCampaignSubscribersId)
		throws SystemException {
		return fetchByCampaignIdAndSubscribersId(spMailCampaignId,
			spMailCampaignSubscribersId, true);
	}

	/**
	 * Returns the s p mail subscriber user agent where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p mail subscriber user agent, or <code>null</code> if a matching s p mail subscriber user agent could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailSubscriberUserAgent fetchByCampaignIdAndSubscribersId(
		long spMailCampaignId, long spMailCampaignSubscribersId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				spMailCampaignId, spMailCampaignSubscribersId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDANDSUBSCRIBERSID,
					finderArgs, this);
		}

		if (result instanceof SPMailSubscriberUserAgent) {
			SPMailSubscriberUserAgent spMailSubscriberUserAgent = (SPMailSubscriberUserAgent)result;

			if ((spMailCampaignId != spMailSubscriberUserAgent.getSpMailCampaignId()) ||
					(spMailCampaignSubscribersId != spMailSubscriberUserAgent.getSpMailCampaignSubscribersId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPMAILSUBSCRIBERUSERAGENT_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDSUBSCRIBERSID_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDSUBSCRIBERSID_SPMAILCAMPAIGNSUBSCRIBERSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(spMailCampaignSubscribersId);

				List<SPMailSubscriberUserAgent> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDANDSUBSCRIBERSID,
						finderArgs, list);
				}
				else {
					SPMailSubscriberUserAgent spMailSubscriberUserAgent = list.get(0);

					result = spMailSubscriberUserAgent;

					cacheResult(spMailSubscriberUserAgent);

					if ((spMailSubscriberUserAgent.getSpMailCampaignId() != spMailCampaignId) ||
							(spMailSubscriberUserAgent.getSpMailCampaignSubscribersId() != spMailCampaignSubscribersId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDANDSUBSCRIBERSID,
							finderArgs, spMailSubscriberUserAgent);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDANDSUBSCRIBERSID,
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
			return (SPMailSubscriberUserAgent)result;
		}
	}

	/**
	 * Removes the s p mail subscriber user agent where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	 * @return the s p mail subscriber user agent that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailSubscriberUserAgent removeByCampaignIdAndSubscribersId(
		long spMailCampaignId, long spMailCampaignSubscribersId)
		throws NoSuchSubscriberUserAgentException, SystemException {
		SPMailSubscriberUserAgent spMailSubscriberUserAgent = findByCampaignIdAndSubscribersId(spMailCampaignId,
				spMailCampaignSubscribersId);

		return remove(spMailSubscriberUserAgent);
	}

	/**
	 * Returns the number of s p mail subscriber user agents where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	 * @return the number of matching s p mail subscriber user agents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignIdAndSubscribersId(long spMailCampaignId,
		long spMailCampaignSubscribersId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNIDANDSUBSCRIBERSID;

		Object[] finderArgs = new Object[] {
				spMailCampaignId, spMailCampaignSubscribersId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPMAILSUBSCRIBERUSERAGENT_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDSUBSCRIBERSID_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDSUBSCRIBERSID_SPMAILCAMPAIGNSUBSCRIBERSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(spMailCampaignSubscribersId);

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

	private static final String _FINDER_COLUMN_CAMPAIGNIDANDSUBSCRIBERSID_SPMAILCAMPAIGNID_2 =
		"spMailSubscriberUserAgent.spMailCampaignId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDANDSUBSCRIBERSID_SPMAILCAMPAIGNSUBSCRIBERSID_2 =
		"spMailSubscriberUserAgent.spMailCampaignSubscribersId = ?";

	public SPMailSubscriberUserAgentPersistenceImpl() {
		setModelClass(SPMailSubscriberUserAgent.class);
	}

	/**
	 * Caches the s p mail subscriber user agent in the entity cache if it is enabled.
	 *
	 * @param spMailSubscriberUserAgent the s p mail subscriber user agent
	 */
	@Override
	public void cacheResult(SPMailSubscriberUserAgent spMailSubscriberUserAgent) {
		EntityCacheUtil.putResult(SPMailSubscriberUserAgentModelImpl.ENTITY_CACHE_ENABLED,
			SPMailSubscriberUserAgentImpl.class,
			spMailSubscriberUserAgent.getPrimaryKey(), spMailSubscriberUserAgent);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDANDSUBSCRIBERSID,
			new Object[] {
				spMailSubscriberUserAgent.getSpMailCampaignId(),
				spMailSubscriberUserAgent.getSpMailCampaignSubscribersId()
			}, spMailSubscriberUserAgent);

		spMailSubscriberUserAgent.resetOriginalValues();
	}

	/**
	 * Caches the s p mail subscriber user agents in the entity cache if it is enabled.
	 *
	 * @param spMailSubscriberUserAgents the s p mail subscriber user agents
	 */
	@Override
	public void cacheResult(
		List<SPMailSubscriberUserAgent> spMailSubscriberUserAgents) {
		for (SPMailSubscriberUserAgent spMailSubscriberUserAgent : spMailSubscriberUserAgents) {
			if (EntityCacheUtil.getResult(
						SPMailSubscriberUserAgentModelImpl.ENTITY_CACHE_ENABLED,
						SPMailSubscriberUserAgentImpl.class,
						spMailSubscriberUserAgent.getPrimaryKey()) == null) {
				cacheResult(spMailSubscriberUserAgent);
			}
			else {
				spMailSubscriberUserAgent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p mail subscriber user agents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPMailSubscriberUserAgentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPMailSubscriberUserAgentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p mail subscriber user agent.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPMailSubscriberUserAgent spMailSubscriberUserAgent) {
		EntityCacheUtil.removeResult(SPMailSubscriberUserAgentModelImpl.ENTITY_CACHE_ENABLED,
			SPMailSubscriberUserAgentImpl.class,
			spMailSubscriberUserAgent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spMailSubscriberUserAgent);
	}

	@Override
	public void clearCache(
		List<SPMailSubscriberUserAgent> spMailSubscriberUserAgents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPMailSubscriberUserAgent spMailSubscriberUserAgent : spMailSubscriberUserAgents) {
			EntityCacheUtil.removeResult(SPMailSubscriberUserAgentModelImpl.ENTITY_CACHE_ENABLED,
				SPMailSubscriberUserAgentImpl.class,
				spMailSubscriberUserAgent.getPrimaryKey());

			clearUniqueFindersCache(spMailSubscriberUserAgent);
		}
	}

	protected void cacheUniqueFindersCache(
		SPMailSubscriberUserAgent spMailSubscriberUserAgent) {
		if (spMailSubscriberUserAgent.isNew()) {
			Object[] args = new Object[] {
					spMailSubscriberUserAgent.getSpMailCampaignId(),
					spMailSubscriberUserAgent.getSpMailCampaignSubscribersId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDANDSUBSCRIBERSID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDANDSUBSCRIBERSID,
				args, spMailSubscriberUserAgent);
		}
		else {
			SPMailSubscriberUserAgentModelImpl spMailSubscriberUserAgentModelImpl =
				(SPMailSubscriberUserAgentModelImpl)spMailSubscriberUserAgent;

			if ((spMailSubscriberUserAgentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CAMPAIGNIDANDSUBSCRIBERSID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailSubscriberUserAgent.getSpMailCampaignId(),
						spMailSubscriberUserAgent.getSpMailCampaignSubscribersId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDANDSUBSCRIBERSID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDANDSUBSCRIBERSID,
					args, spMailSubscriberUserAgent);
			}
		}
	}

	protected void clearUniqueFindersCache(
		SPMailSubscriberUserAgent spMailSubscriberUserAgent) {
		SPMailSubscriberUserAgentModelImpl spMailSubscriberUserAgentModelImpl = (SPMailSubscriberUserAgentModelImpl)spMailSubscriberUserAgent;

		Object[] args = new Object[] {
				spMailSubscriberUserAgent.getSpMailCampaignId(),
				spMailSubscriberUserAgent.getSpMailCampaignSubscribersId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDANDSUBSCRIBERSID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDANDSUBSCRIBERSID,
			args);

		if ((spMailSubscriberUserAgentModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CAMPAIGNIDANDSUBSCRIBERSID.getColumnBitmask()) != 0) {
			args = new Object[] {
					spMailSubscriberUserAgentModelImpl.getOriginalSpMailCampaignId(),
					spMailSubscriberUserAgentModelImpl.getOriginalSpMailCampaignSubscribersId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDANDSUBSCRIBERSID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDANDSUBSCRIBERSID,
				args);
		}
	}

	/**
	 * Creates a new s p mail subscriber user agent with the primary key. Does not add the s p mail subscriber user agent to the database.
	 *
	 * @param spMailSubscriberUserAgentId the primary key for the new s p mail subscriber user agent
	 * @return the new s p mail subscriber user agent
	 */
	@Override
	public SPMailSubscriberUserAgent create(long spMailSubscriberUserAgentId) {
		SPMailSubscriberUserAgent spMailSubscriberUserAgent = new SPMailSubscriberUserAgentImpl();

		spMailSubscriberUserAgent.setNew(true);
		spMailSubscriberUserAgent.setPrimaryKey(spMailSubscriberUserAgentId);

		return spMailSubscriberUserAgent;
	}

	/**
	 * Removes the s p mail subscriber user agent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spMailSubscriberUserAgentId the primary key of the s p mail subscriber user agent
	 * @return the s p mail subscriber user agent that was removed
	 * @throws com.sambaash.platform.srv.mail.NoSuchSubscriberUserAgentException if a s p mail subscriber user agent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailSubscriberUserAgent remove(long spMailSubscriberUserAgentId)
		throws NoSuchSubscriberUserAgentException, SystemException {
		return remove((Serializable)spMailSubscriberUserAgentId);
	}

	/**
	 * Removes the s p mail subscriber user agent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p mail subscriber user agent
	 * @return the s p mail subscriber user agent that was removed
	 * @throws com.sambaash.platform.srv.mail.NoSuchSubscriberUserAgentException if a s p mail subscriber user agent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailSubscriberUserAgent remove(Serializable primaryKey)
		throws NoSuchSubscriberUserAgentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPMailSubscriberUserAgent spMailSubscriberUserAgent = (SPMailSubscriberUserAgent)session.get(SPMailSubscriberUserAgentImpl.class,
					primaryKey);

			if (spMailSubscriberUserAgent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubscriberUserAgentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spMailSubscriberUserAgent);
		}
		catch (NoSuchSubscriberUserAgentException nsee) {
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
	protected SPMailSubscriberUserAgent removeImpl(
		SPMailSubscriberUserAgent spMailSubscriberUserAgent)
		throws SystemException {
		spMailSubscriberUserAgent = toUnwrappedModel(spMailSubscriberUserAgent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spMailSubscriberUserAgent)) {
				spMailSubscriberUserAgent = (SPMailSubscriberUserAgent)session.get(SPMailSubscriberUserAgentImpl.class,
						spMailSubscriberUserAgent.getPrimaryKeyObj());
			}

			if (spMailSubscriberUserAgent != null) {
				session.delete(spMailSubscriberUserAgent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spMailSubscriberUserAgent != null) {
			clearCache(spMailSubscriberUserAgent);
		}

		return spMailSubscriberUserAgent;
	}

	@Override
	public SPMailSubscriberUserAgent updateImpl(
		com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent spMailSubscriberUserAgent)
		throws SystemException {
		spMailSubscriberUserAgent = toUnwrappedModel(spMailSubscriberUserAgent);

		boolean isNew = spMailSubscriberUserAgent.isNew();

		Session session = null;

		try {
			session = openSession();

			if (spMailSubscriberUserAgent.isNew()) {
				session.save(spMailSubscriberUserAgent);

				spMailSubscriberUserAgent.setNew(false);
			}
			else {
				session.merge(spMailSubscriberUserAgent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!SPMailSubscriberUserAgentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(SPMailSubscriberUserAgentModelImpl.ENTITY_CACHE_ENABLED,
			SPMailSubscriberUserAgentImpl.class,
			spMailSubscriberUserAgent.getPrimaryKey(), spMailSubscriberUserAgent);

		clearUniqueFindersCache(spMailSubscriberUserAgent);
		cacheUniqueFindersCache(spMailSubscriberUserAgent);

		return spMailSubscriberUserAgent;
	}

	protected SPMailSubscriberUserAgent toUnwrappedModel(
		SPMailSubscriberUserAgent spMailSubscriberUserAgent) {
		if (spMailSubscriberUserAgent instanceof SPMailSubscriberUserAgentImpl) {
			return spMailSubscriberUserAgent;
		}

		SPMailSubscriberUserAgentImpl spMailSubscriberUserAgentImpl = new SPMailSubscriberUserAgentImpl();

		spMailSubscriberUserAgentImpl.setNew(spMailSubscriberUserAgent.isNew());
		spMailSubscriberUserAgentImpl.setPrimaryKey(spMailSubscriberUserAgent.getPrimaryKey());

		spMailSubscriberUserAgentImpl.setSpMailSubscriberUserAgentId(spMailSubscriberUserAgent.getSpMailSubscriberUserAgentId());
		spMailSubscriberUserAgentImpl.setSpMailCampaignSubscribersId(spMailSubscriberUserAgent.getSpMailCampaignSubscribersId());
		spMailSubscriberUserAgentImpl.setSpMailCampaignId(spMailSubscriberUserAgent.getSpMailCampaignId());
		spMailSubscriberUserAgentImpl.setName(spMailSubscriberUserAgent.getName());
		spMailSubscriberUserAgentImpl.setType(spMailSubscriberUserAgent.getType());
		spMailSubscriberUserAgentImpl.setTypeName(spMailSubscriberUserAgent.getTypeName());
		spMailSubscriberUserAgentImpl.setDeviceCategory(spMailSubscriberUserAgent.getDeviceCategory());
		spMailSubscriberUserAgentImpl.setFamily(spMailSubscriberUserAgent.getFamily());
		spMailSubscriberUserAgentImpl.setOperatingSystem(spMailSubscriberUserAgent.getOperatingSystem());
		spMailSubscriberUserAgentImpl.setVersionNumber(spMailSubscriberUserAgent.getVersionNumber());
		spMailSubscriberUserAgentImpl.setUserAgent(spMailSubscriberUserAgent.getUserAgent());

		return spMailSubscriberUserAgentImpl;
	}

	/**
	 * Returns the s p mail subscriber user agent with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p mail subscriber user agent
	 * @return the s p mail subscriber user agent
	 * @throws com.sambaash.platform.srv.mail.NoSuchSubscriberUserAgentException if a s p mail subscriber user agent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailSubscriberUserAgent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubscriberUserAgentException, SystemException {
		SPMailSubscriberUserAgent spMailSubscriberUserAgent = fetchByPrimaryKey(primaryKey);

		if (spMailSubscriberUserAgent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubscriberUserAgentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spMailSubscriberUserAgent;
	}

	/**
	 * Returns the s p mail subscriber user agent with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchSubscriberUserAgentException} if it could not be found.
	 *
	 * @param spMailSubscriberUserAgentId the primary key of the s p mail subscriber user agent
	 * @return the s p mail subscriber user agent
	 * @throws com.sambaash.platform.srv.mail.NoSuchSubscriberUserAgentException if a s p mail subscriber user agent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailSubscriberUserAgent findByPrimaryKey(
		long spMailSubscriberUserAgentId)
		throws NoSuchSubscriberUserAgentException, SystemException {
		return findByPrimaryKey((Serializable)spMailSubscriberUserAgentId);
	}

	/**
	 * Returns the s p mail subscriber user agent with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p mail subscriber user agent
	 * @return the s p mail subscriber user agent, or <code>null</code> if a s p mail subscriber user agent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailSubscriberUserAgent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPMailSubscriberUserAgent spMailSubscriberUserAgent = (SPMailSubscriberUserAgent)EntityCacheUtil.getResult(SPMailSubscriberUserAgentModelImpl.ENTITY_CACHE_ENABLED,
				SPMailSubscriberUserAgentImpl.class, primaryKey);

		if (spMailSubscriberUserAgent == _nullSPMailSubscriberUserAgent) {
			return null;
		}

		if (spMailSubscriberUserAgent == null) {
			Session session = null;

			try {
				session = openSession();

				spMailSubscriberUserAgent = (SPMailSubscriberUserAgent)session.get(SPMailSubscriberUserAgentImpl.class,
						primaryKey);

				if (spMailSubscriberUserAgent != null) {
					cacheResult(spMailSubscriberUserAgent);
				}
				else {
					EntityCacheUtil.putResult(SPMailSubscriberUserAgentModelImpl.ENTITY_CACHE_ENABLED,
						SPMailSubscriberUserAgentImpl.class, primaryKey,
						_nullSPMailSubscriberUserAgent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPMailSubscriberUserAgentModelImpl.ENTITY_CACHE_ENABLED,
					SPMailSubscriberUserAgentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spMailSubscriberUserAgent;
	}

	/**
	 * Returns the s p mail subscriber user agent with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spMailSubscriberUserAgentId the primary key of the s p mail subscriber user agent
	 * @return the s p mail subscriber user agent, or <code>null</code> if a s p mail subscriber user agent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailSubscriberUserAgent fetchByPrimaryKey(
		long spMailSubscriberUserAgentId) throws SystemException {
		return fetchByPrimaryKey((Serializable)spMailSubscriberUserAgentId);
	}

	/**
	 * Returns all the s p mail subscriber user agents.
	 *
	 * @return the s p mail subscriber user agents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailSubscriberUserAgent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail subscriber user agents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailSubscriberUserAgentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p mail subscriber user agents
	 * @param end the upper bound of the range of s p mail subscriber user agents (not inclusive)
	 * @return the range of s p mail subscriber user agents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailSubscriberUserAgent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail subscriber user agents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailSubscriberUserAgentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p mail subscriber user agents
	 * @param end the upper bound of the range of s p mail subscriber user agents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p mail subscriber user agents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailSubscriberUserAgent> findAll(int start, int end,
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

		List<SPMailSubscriberUserAgent> list = (List<SPMailSubscriberUserAgent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPMAILSUBSCRIBERUSERAGENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPMAILSUBSCRIBERUSERAGENT;

				if (pagination) {
					sql = sql.concat(SPMailSubscriberUserAgentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPMailSubscriberUserAgent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailSubscriberUserAgent>(list);
				}
				else {
					list = (List<SPMailSubscriberUserAgent>)QueryUtil.list(q,
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
	 * Removes all the s p mail subscriber user agents from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPMailSubscriberUserAgent spMailSubscriberUserAgent : findAll()) {
			remove(spMailSubscriberUserAgent);
		}
	}

	/**
	 * Returns the number of s p mail subscriber user agents.
	 *
	 * @return the number of s p mail subscriber user agents
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

				Query q = session.createQuery(_SQL_COUNT_SPMAILSUBSCRIBERUSERAGENT);

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
	 * Initializes the s p mail subscriber user agent persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPMailSubscriberUserAgent>> listenersList = new ArrayList<ModelListener<SPMailSubscriberUserAgent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPMailSubscriberUserAgent>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPMailSubscriberUserAgentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPMAILSUBSCRIBERUSERAGENT = "SELECT spMailSubscriberUserAgent FROM SPMailSubscriberUserAgent spMailSubscriberUserAgent";
	private static final String _SQL_SELECT_SPMAILSUBSCRIBERUSERAGENT_WHERE = "SELECT spMailSubscriberUserAgent FROM SPMailSubscriberUserAgent spMailSubscriberUserAgent WHERE ";
	private static final String _SQL_COUNT_SPMAILSUBSCRIBERUSERAGENT = "SELECT COUNT(spMailSubscriberUserAgent) FROM SPMailSubscriberUserAgent spMailSubscriberUserAgent";
	private static final String _SQL_COUNT_SPMAILSUBSCRIBERUSERAGENT_WHERE = "SELECT COUNT(spMailSubscriberUserAgent) FROM SPMailSubscriberUserAgent spMailSubscriberUserAgent WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spMailSubscriberUserAgent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPMailSubscriberUserAgent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPMailSubscriberUserAgent exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPMailSubscriberUserAgentPersistenceImpl.class);
	private static SPMailSubscriberUserAgent _nullSPMailSubscriberUserAgent = new SPMailSubscriberUserAgentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPMailSubscriberUserAgent> toCacheModel() {
				return _nullSPMailSubscriberUserAgentCacheModel;
			}
		};

	private static CacheModel<SPMailSubscriberUserAgent> _nullSPMailSubscriberUserAgentCacheModel =
		new CacheModel<SPMailSubscriberUserAgent>() {
			@Override
			public SPMailSubscriberUserAgent toEntityModel() {
				return _nullSPMailSubscriberUserAgent;
			}
		};
}