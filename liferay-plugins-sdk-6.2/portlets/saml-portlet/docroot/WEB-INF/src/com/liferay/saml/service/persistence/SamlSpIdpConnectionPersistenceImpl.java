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

package com.liferay.saml.service.persistence;

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

import com.liferay.saml.NoSuchSpIdpConnectionException;
import com.liferay.saml.model.SamlSpIdpConnection;
import com.liferay.saml.model.impl.SamlSpIdpConnectionImpl;
import com.liferay.saml.model.impl.SamlSpIdpConnectionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the saml sp idp connection service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mika Koivisto, W. Berks
 * @see SamlSpIdpConnectionPersistence
 * @see SamlSpIdpConnectionUtil
 * @generated
 */
public class SamlSpIdpConnectionPersistenceImpl extends BasePersistenceImpl<SamlSpIdpConnection>
	implements SamlSpIdpConnectionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SamlSpIdpConnectionUtil} to access the saml sp idp connection persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SamlSpIdpConnectionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SamlSpIdpConnectionModelImpl.ENTITY_CACHE_ENABLED,
			SamlSpIdpConnectionModelImpl.FINDER_CACHE_ENABLED,
			SamlSpIdpConnectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SamlSpIdpConnectionModelImpl.ENTITY_CACHE_ENABLED,
			SamlSpIdpConnectionModelImpl.FINDER_CACHE_ENABLED,
			SamlSpIdpConnectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SamlSpIdpConnectionModelImpl.ENTITY_CACHE_ENABLED,
			SamlSpIdpConnectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_COMPANYIDGROUPID = new FinderPath(SamlSpIdpConnectionModelImpl.ENTITY_CACHE_ENABLED,
			SamlSpIdpConnectionModelImpl.FINDER_CACHE_ENABLED,
			SamlSpIdpConnectionImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCompanyIdGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SamlSpIdpConnectionModelImpl.COMPANYID_COLUMN_BITMASK |
			SamlSpIdpConnectionModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYIDGROUPID = new FinderPath(SamlSpIdpConnectionModelImpl.ENTITY_CACHE_ENABLED,
			SamlSpIdpConnectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyIdGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the saml sp idp connection where companyId = &#63; and groupId = &#63; or throws a {@link com.liferay.saml.NoSuchSpIdpConnectionException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching saml sp idp connection
	 * @throws com.liferay.saml.NoSuchSpIdpConnectionException if a matching saml sp idp connection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SamlSpIdpConnection findByCompanyIdGroupId(long companyId,
		long groupId) throws NoSuchSpIdpConnectionException, SystemException {
		SamlSpIdpConnection samlSpIdpConnection = fetchByCompanyIdGroupId(companyId,
				groupId);

		if (samlSpIdpConnection == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSpIdpConnectionException(msg.toString());
		}

		return samlSpIdpConnection;
	}

	/**
	 * Returns the saml sp idp connection where companyId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching saml sp idp connection, or <code>null</code> if a matching saml sp idp connection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SamlSpIdpConnection fetchByCompanyIdGroupId(long companyId,
		long groupId) throws SystemException {
		return fetchByCompanyIdGroupId(companyId, groupId, true);
	}

	/**
	 * Returns the saml sp idp connection where companyId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching saml sp idp connection, or <code>null</code> if a matching saml sp idp connection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SamlSpIdpConnection fetchByCompanyIdGroupId(long companyId,
		long groupId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COMPANYIDGROUPID,
					finderArgs, this);
		}

		if (result instanceof SamlSpIdpConnection) {
			SamlSpIdpConnection samlSpIdpConnection = (SamlSpIdpConnection)result;

			if ((companyId != samlSpIdpConnection.getCompanyId()) ||
					(groupId != samlSpIdpConnection.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SAMLSPIDPCONNECTION_WHERE);

			query.append(_FINDER_COLUMN_COMPANYIDGROUPID_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYIDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				List<SamlSpIdpConnection> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYIDGROUPID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SamlSpIdpConnectionPersistenceImpl.fetchByCompanyIdGroupId(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SamlSpIdpConnection samlSpIdpConnection = list.get(0);

					result = samlSpIdpConnection;

					cacheResult(samlSpIdpConnection);

					if ((samlSpIdpConnection.getCompanyId() != companyId) ||
							(samlSpIdpConnection.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYIDGROUPID,
							finderArgs, samlSpIdpConnection);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COMPANYIDGROUPID,
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
			return (SamlSpIdpConnection)result;
		}
	}

	/**
	 * Removes the saml sp idp connection where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the saml sp idp connection that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SamlSpIdpConnection removeByCompanyIdGroupId(long companyId,
		long groupId) throws NoSuchSpIdpConnectionException, SystemException {
		SamlSpIdpConnection samlSpIdpConnection = findByCompanyIdGroupId(companyId,
				groupId);

		return remove(samlSpIdpConnection);
	}

	/**
	 * Returns the number of saml sp idp connections where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching saml sp idp connections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyIdGroupId(long companyId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYIDGROUPID;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SAMLSPIDPCONNECTION_WHERE);

			query.append(_FINDER_COLUMN_COMPANYIDGROUPID_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYIDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_COMPANYIDGROUPID_COMPANYID_2 = "samlSpIdpConnection.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYIDGROUPID_GROUPID_2 = "samlSpIdpConnection.groupId = ?";

	public SamlSpIdpConnectionPersistenceImpl() {
		setModelClass(SamlSpIdpConnection.class);
	}

	/**
	 * Caches the saml sp idp connection in the entity cache if it is enabled.
	 *
	 * @param samlSpIdpConnection the saml sp idp connection
	 */
	@Override
	public void cacheResult(SamlSpIdpConnection samlSpIdpConnection) {
		EntityCacheUtil.putResult(SamlSpIdpConnectionModelImpl.ENTITY_CACHE_ENABLED,
			SamlSpIdpConnectionImpl.class, samlSpIdpConnection.getPrimaryKey(),
			samlSpIdpConnection);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYIDGROUPID,
			new Object[] {
				samlSpIdpConnection.getCompanyId(),
				samlSpIdpConnection.getGroupId()
			}, samlSpIdpConnection);

		samlSpIdpConnection.resetOriginalValues();
	}

	/**
	 * Caches the saml sp idp connections in the entity cache if it is enabled.
	 *
	 * @param samlSpIdpConnections the saml sp idp connections
	 */
	@Override
	public void cacheResult(List<SamlSpIdpConnection> samlSpIdpConnections) {
		for (SamlSpIdpConnection samlSpIdpConnection : samlSpIdpConnections) {
			if (EntityCacheUtil.getResult(
						SamlSpIdpConnectionModelImpl.ENTITY_CACHE_ENABLED,
						SamlSpIdpConnectionImpl.class,
						samlSpIdpConnection.getPrimaryKey()) == null) {
				cacheResult(samlSpIdpConnection);
			}
			else {
				samlSpIdpConnection.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all saml sp idp connections.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SamlSpIdpConnectionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SamlSpIdpConnectionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the saml sp idp connection.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SamlSpIdpConnection samlSpIdpConnection) {
		EntityCacheUtil.removeResult(SamlSpIdpConnectionModelImpl.ENTITY_CACHE_ENABLED,
			SamlSpIdpConnectionImpl.class, samlSpIdpConnection.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(samlSpIdpConnection);
	}

	@Override
	public void clearCache(List<SamlSpIdpConnection> samlSpIdpConnections) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SamlSpIdpConnection samlSpIdpConnection : samlSpIdpConnections) {
			EntityCacheUtil.removeResult(SamlSpIdpConnectionModelImpl.ENTITY_CACHE_ENABLED,
				SamlSpIdpConnectionImpl.class,
				samlSpIdpConnection.getPrimaryKey());

			clearUniqueFindersCache(samlSpIdpConnection);
		}
	}

	protected void cacheUniqueFindersCache(
		SamlSpIdpConnection samlSpIdpConnection) {
		if (samlSpIdpConnection.isNew()) {
			Object[] args = new Object[] {
					samlSpIdpConnection.getCompanyId(),
					samlSpIdpConnection.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYIDGROUPID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYIDGROUPID,
				args, samlSpIdpConnection);
		}
		else {
			SamlSpIdpConnectionModelImpl samlSpIdpConnectionModelImpl = (SamlSpIdpConnectionModelImpl)samlSpIdpConnection;

			if ((samlSpIdpConnectionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COMPANYIDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						samlSpIdpConnection.getCompanyId(),
						samlSpIdpConnection.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYIDGROUPID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYIDGROUPID,
					args, samlSpIdpConnection);
			}
		}
	}

	protected void clearUniqueFindersCache(
		SamlSpIdpConnection samlSpIdpConnection) {
		SamlSpIdpConnectionModelImpl samlSpIdpConnectionModelImpl = (SamlSpIdpConnectionModelImpl)samlSpIdpConnection;

		Object[] args = new Object[] {
				samlSpIdpConnection.getCompanyId(),
				samlSpIdpConnection.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDGROUPID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COMPANYIDGROUPID, args);

		if ((samlSpIdpConnectionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COMPANYIDGROUPID.getColumnBitmask()) != 0) {
			args = new Object[] {
					samlSpIdpConnectionModelImpl.getOriginalCompanyId(),
					samlSpIdpConnectionModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDGROUPID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COMPANYIDGROUPID,
				args);
		}
	}

	/**
	 * Creates a new saml sp idp connection with the primary key. Does not add the saml sp idp connection to the database.
	 *
	 * @param samlSpIdpConnectionId the primary key for the new saml sp idp connection
	 * @return the new saml sp idp connection
	 */
	@Override
	public SamlSpIdpConnection create(long samlSpIdpConnectionId) {
		SamlSpIdpConnection samlSpIdpConnection = new SamlSpIdpConnectionImpl();

		samlSpIdpConnection.setNew(true);
		samlSpIdpConnection.setPrimaryKey(samlSpIdpConnectionId);

		return samlSpIdpConnection;
	}

	/**
	 * Removes the saml sp idp connection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param samlSpIdpConnectionId the primary key of the saml sp idp connection
	 * @return the saml sp idp connection that was removed
	 * @throws com.liferay.saml.NoSuchSpIdpConnectionException if a saml sp idp connection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SamlSpIdpConnection remove(long samlSpIdpConnectionId)
		throws NoSuchSpIdpConnectionException, SystemException {
		return remove((Serializable)samlSpIdpConnectionId);
	}

	/**
	 * Removes the saml sp idp connection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the saml sp idp connection
	 * @return the saml sp idp connection that was removed
	 * @throws com.liferay.saml.NoSuchSpIdpConnectionException if a saml sp idp connection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SamlSpIdpConnection remove(Serializable primaryKey)
		throws NoSuchSpIdpConnectionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SamlSpIdpConnection samlSpIdpConnection = (SamlSpIdpConnection)session.get(SamlSpIdpConnectionImpl.class,
					primaryKey);

			if (samlSpIdpConnection == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSpIdpConnectionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(samlSpIdpConnection);
		}
		catch (NoSuchSpIdpConnectionException nsee) {
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
	protected SamlSpIdpConnection removeImpl(
		SamlSpIdpConnection samlSpIdpConnection) throws SystemException {
		samlSpIdpConnection = toUnwrappedModel(samlSpIdpConnection);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(samlSpIdpConnection)) {
				samlSpIdpConnection = (SamlSpIdpConnection)session.get(SamlSpIdpConnectionImpl.class,
						samlSpIdpConnection.getPrimaryKeyObj());
			}

			if (samlSpIdpConnection != null) {
				session.delete(samlSpIdpConnection);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (samlSpIdpConnection != null) {
			clearCache(samlSpIdpConnection);
		}

		return samlSpIdpConnection;
	}

	@Override
	public SamlSpIdpConnection updateImpl(
		com.liferay.saml.model.SamlSpIdpConnection samlSpIdpConnection)
		throws SystemException {
		samlSpIdpConnection = toUnwrappedModel(samlSpIdpConnection);

		boolean isNew = samlSpIdpConnection.isNew();

		Session session = null;

		try {
			session = openSession();

			if (samlSpIdpConnection.isNew()) {
				session.save(samlSpIdpConnection);

				samlSpIdpConnection.setNew(false);
			}
			else {
				session.merge(samlSpIdpConnection);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SamlSpIdpConnectionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(SamlSpIdpConnectionModelImpl.ENTITY_CACHE_ENABLED,
			SamlSpIdpConnectionImpl.class, samlSpIdpConnection.getPrimaryKey(),
			samlSpIdpConnection);

		clearUniqueFindersCache(samlSpIdpConnection);
		cacheUniqueFindersCache(samlSpIdpConnection);

		return samlSpIdpConnection;
	}

	protected SamlSpIdpConnection toUnwrappedModel(
		SamlSpIdpConnection samlSpIdpConnection) {
		if (samlSpIdpConnection instanceof SamlSpIdpConnectionImpl) {
			return samlSpIdpConnection;
		}

		SamlSpIdpConnectionImpl samlSpIdpConnectionImpl = new SamlSpIdpConnectionImpl();

		samlSpIdpConnectionImpl.setNew(samlSpIdpConnection.isNew());
		samlSpIdpConnectionImpl.setPrimaryKey(samlSpIdpConnection.getPrimaryKey());

		samlSpIdpConnectionImpl.setSamlSpIdpConnectionId(samlSpIdpConnection.getSamlSpIdpConnectionId());
		samlSpIdpConnectionImpl.setCompanyId(samlSpIdpConnection.getCompanyId());
		samlSpIdpConnectionImpl.setGroupId(samlSpIdpConnection.getGroupId());
		samlSpIdpConnectionImpl.setUserId(samlSpIdpConnection.getUserId());
		samlSpIdpConnectionImpl.setUserName(samlSpIdpConnection.getUserName());
		samlSpIdpConnectionImpl.setCreateDate(samlSpIdpConnection.getCreateDate());
		samlSpIdpConnectionImpl.setModifiedDate(samlSpIdpConnection.getModifiedDate());
		samlSpIdpConnectionImpl.setSamlIdpEntityId(samlSpIdpConnection.getSamlIdpEntityId());
		samlSpIdpConnectionImpl.setAssertionSignatureRequired(samlSpIdpConnection.isAssertionSignatureRequired());
		samlSpIdpConnectionImpl.setClockSkew(samlSpIdpConnection.getClockSkew());
		samlSpIdpConnectionImpl.setEnabled(samlSpIdpConnection.isEnabled());
		samlSpIdpConnectionImpl.setLdapImportEnabled(samlSpIdpConnection.isLdapImportEnabled());
		samlSpIdpConnectionImpl.setMetadataUrl(samlSpIdpConnection.getMetadataUrl());
		samlSpIdpConnectionImpl.setMetadataXml(samlSpIdpConnection.getMetadataXml());
		samlSpIdpConnectionImpl.setMetadataUpdatedDate(samlSpIdpConnection.getMetadataUpdatedDate());
		samlSpIdpConnectionImpl.setName(samlSpIdpConnection.getName());
		samlSpIdpConnectionImpl.setNameIdFormat(samlSpIdpConnection.getNameIdFormat());
		samlSpIdpConnectionImpl.setSignAuthnRequest(samlSpIdpConnection.isSignAuthnRequest());
		samlSpIdpConnectionImpl.setUserAttributeMappings(samlSpIdpConnection.getUserAttributeMappings());
		samlSpIdpConnectionImpl.setKeepAliveUrl(samlSpIdpConnection.getKeepAliveUrl());
		samlSpIdpConnectionImpl.setPrimaryKeyType(samlSpIdpConnection.getPrimaryKeyType());
		samlSpIdpConnectionImpl.setPrimaryKeyAttribute(samlSpIdpConnection.getPrimaryKeyAttribute());

		return samlSpIdpConnectionImpl;
	}

	/**
	 * Returns the saml sp idp connection with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the saml sp idp connection
	 * @return the saml sp idp connection
	 * @throws com.liferay.saml.NoSuchSpIdpConnectionException if a saml sp idp connection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SamlSpIdpConnection findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSpIdpConnectionException, SystemException {
		SamlSpIdpConnection samlSpIdpConnection = fetchByPrimaryKey(primaryKey);

		if (samlSpIdpConnection == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSpIdpConnectionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return samlSpIdpConnection;
	}

	/**
	 * Returns the saml sp idp connection with the primary key or throws a {@link com.liferay.saml.NoSuchSpIdpConnectionException} if it could not be found.
	 *
	 * @param samlSpIdpConnectionId the primary key of the saml sp idp connection
	 * @return the saml sp idp connection
	 * @throws com.liferay.saml.NoSuchSpIdpConnectionException if a saml sp idp connection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SamlSpIdpConnection findByPrimaryKey(long samlSpIdpConnectionId)
		throws NoSuchSpIdpConnectionException, SystemException {
		return findByPrimaryKey((Serializable)samlSpIdpConnectionId);
	}

	/**
	 * Returns the saml sp idp connection with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the saml sp idp connection
	 * @return the saml sp idp connection, or <code>null</code> if a saml sp idp connection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SamlSpIdpConnection fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SamlSpIdpConnection samlSpIdpConnection = (SamlSpIdpConnection)EntityCacheUtil.getResult(SamlSpIdpConnectionModelImpl.ENTITY_CACHE_ENABLED,
				SamlSpIdpConnectionImpl.class, primaryKey);

		if (samlSpIdpConnection == _nullSamlSpIdpConnection) {
			return null;
		}

		if (samlSpIdpConnection == null) {
			Session session = null;

			try {
				session = openSession();

				samlSpIdpConnection = (SamlSpIdpConnection)session.get(SamlSpIdpConnectionImpl.class,
						primaryKey);

				if (samlSpIdpConnection != null) {
					cacheResult(samlSpIdpConnection);
				}
				else {
					EntityCacheUtil.putResult(SamlSpIdpConnectionModelImpl.ENTITY_CACHE_ENABLED,
						SamlSpIdpConnectionImpl.class, primaryKey,
						_nullSamlSpIdpConnection);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SamlSpIdpConnectionModelImpl.ENTITY_CACHE_ENABLED,
					SamlSpIdpConnectionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return samlSpIdpConnection;
	}

	/**
	 * Returns the saml sp idp connection with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param samlSpIdpConnectionId the primary key of the saml sp idp connection
	 * @return the saml sp idp connection, or <code>null</code> if a saml sp idp connection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SamlSpIdpConnection fetchByPrimaryKey(long samlSpIdpConnectionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)samlSpIdpConnectionId);
	}

	/**
	 * Returns all the saml sp idp connections.
	 *
	 * @return the saml sp idp connections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SamlSpIdpConnection> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the saml sp idp connections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.saml.model.impl.SamlSpIdpConnectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of saml sp idp connections
	 * @param end the upper bound of the range of saml sp idp connections (not inclusive)
	 * @return the range of saml sp idp connections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SamlSpIdpConnection> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the saml sp idp connections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.saml.model.impl.SamlSpIdpConnectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of saml sp idp connections
	 * @param end the upper bound of the range of saml sp idp connections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of saml sp idp connections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SamlSpIdpConnection> findAll(int start, int end,
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

		List<SamlSpIdpConnection> list = (List<SamlSpIdpConnection>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SAMLSPIDPCONNECTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SAMLSPIDPCONNECTION;

				if (pagination) {
					sql = sql.concat(SamlSpIdpConnectionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SamlSpIdpConnection>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SamlSpIdpConnection>(list);
				}
				else {
					list = (List<SamlSpIdpConnection>)QueryUtil.list(q,
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
	 * Removes all the saml sp idp connections from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SamlSpIdpConnection samlSpIdpConnection : findAll()) {
			remove(samlSpIdpConnection);
		}
	}

	/**
	 * Returns the number of saml sp idp connections.
	 *
	 * @return the number of saml sp idp connections
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

				Query q = session.createQuery(_SQL_COUNT_SAMLSPIDPCONNECTION);

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
	 * Initializes the saml sp idp connection persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.saml.model.SamlSpIdpConnection")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SamlSpIdpConnection>> listenersList = new ArrayList<ModelListener<SamlSpIdpConnection>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SamlSpIdpConnection>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SamlSpIdpConnectionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SAMLSPIDPCONNECTION = "SELECT samlSpIdpConnection FROM SamlSpIdpConnection samlSpIdpConnection";
	private static final String _SQL_SELECT_SAMLSPIDPCONNECTION_WHERE = "SELECT samlSpIdpConnection FROM SamlSpIdpConnection samlSpIdpConnection WHERE ";
	private static final String _SQL_COUNT_SAMLSPIDPCONNECTION = "SELECT COUNT(samlSpIdpConnection) FROM SamlSpIdpConnection samlSpIdpConnection";
	private static final String _SQL_COUNT_SAMLSPIDPCONNECTION_WHERE = "SELECT COUNT(samlSpIdpConnection) FROM SamlSpIdpConnection samlSpIdpConnection WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "samlSpIdpConnection.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SamlSpIdpConnection exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SamlSpIdpConnection exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SamlSpIdpConnectionPersistenceImpl.class);
	private static SamlSpIdpConnection _nullSamlSpIdpConnection = new SamlSpIdpConnectionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SamlSpIdpConnection> toCacheModel() {
				return _nullSamlSpIdpConnectionCacheModel;
			}
		};

	private static CacheModel<SamlSpIdpConnection> _nullSamlSpIdpConnectionCacheModel =
		new CacheModel<SamlSpIdpConnection>() {
			@Override
			public SamlSpIdpConnection toEntityModel() {
				return _nullSamlSpIdpConnection;
			}
		};
}