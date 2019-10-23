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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.spshopping.NoSuchSPTaxException;
import com.sambaash.platform.srv.spshopping.model.SPTax;
import com.sambaash.platform.srv.spshopping.model.impl.SPTaxImpl;
import com.sambaash.platform.srv.spshopping.model.impl.SPTaxModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p tax service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPTaxPersistence
 * @see SPTaxUtil
 * @generated
 */
public class SPTaxPersistenceImpl extends BasePersistenceImpl<SPTax>
	implements SPTaxPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPTaxUtil} to access the s p tax persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPTaxImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPTaxModelImpl.ENTITY_CACHE_ENABLED,
			SPTaxModelImpl.FINDER_CACHE_ENABLED, SPTaxImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPTaxModelImpl.ENTITY_CACHE_ENABLED,
			SPTaxModelImpl.FINDER_CACHE_ENABLED, SPTaxImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPTaxModelImpl.ENTITY_CACHE_ENABLED,
			SPTaxModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CURRENCYCODE = new FinderPath(SPTaxModelImpl.ENTITY_CACHE_ENABLED,
			SPTaxModelImpl.FINDER_CACHE_ENABLED, SPTaxImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBycurrencyCode",
			new String[] { String.class.getName() },
			SPTaxModelImpl.CURRENCYCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CURRENCYCODE = new FinderPath(SPTaxModelImpl.ENTITY_CACHE_ENABLED,
			SPTaxModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycurrencyCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the s p tax where currencyCode = &#63; or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPTaxException} if it could not be found.
	 *
	 * @param currencyCode the currency code
	 * @return the matching s p tax
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPTaxException if a matching s p tax could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTax findBycurrencyCode(String currencyCode)
		throws NoSuchSPTaxException, SystemException {
		SPTax spTax = fetchBycurrencyCode(currencyCode);

		if (spTax == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("currencyCode=");
			msg.append(currencyCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSPTaxException(msg.toString());
		}

		return spTax;
	}

	/**
	 * Returns the s p tax where currencyCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param currencyCode the currency code
	 * @return the matching s p tax, or <code>null</code> if a matching s p tax could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTax fetchBycurrencyCode(String currencyCode)
		throws SystemException {
		return fetchBycurrencyCode(currencyCode, true);
	}

	/**
	 * Returns the s p tax where currencyCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param currencyCode the currency code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p tax, or <code>null</code> if a matching s p tax could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTax fetchBycurrencyCode(String currencyCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { currencyCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CURRENCYCODE,
					finderArgs, this);
		}

		if (result instanceof SPTax) {
			SPTax spTax = (SPTax)result;

			if (!Validator.equals(currencyCode, spTax.getCurrencyCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SPTAX_WHERE);

			boolean bindCurrencyCode = false;

			if (currencyCode == null) {
				query.append(_FINDER_COLUMN_CURRENCYCODE_CURRENCYCODE_1);
			}
			else if (currencyCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CURRENCYCODE_CURRENCYCODE_3);
			}
			else {
				bindCurrencyCode = true;

				query.append(_FINDER_COLUMN_CURRENCYCODE_CURRENCYCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCurrencyCode) {
					qPos.add(currencyCode);
				}

				List<SPTax> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CURRENCYCODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SPTaxPersistenceImpl.fetchBycurrencyCode(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SPTax spTax = list.get(0);

					result = spTax;

					cacheResult(spTax);

					if ((spTax.getCurrencyCode() == null) ||
							!spTax.getCurrencyCode().equals(currencyCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CURRENCYCODE,
							finderArgs, spTax);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CURRENCYCODE,
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
			return (SPTax)result;
		}
	}

	/**
	 * Removes the s p tax where currencyCode = &#63; from the database.
	 *
	 * @param currencyCode the currency code
	 * @return the s p tax that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTax removeBycurrencyCode(String currencyCode)
		throws NoSuchSPTaxException, SystemException {
		SPTax spTax = findBycurrencyCode(currencyCode);

		return remove(spTax);
	}

	/**
	 * Returns the number of s p taxs where currencyCode = &#63;.
	 *
	 * @param currencyCode the currency code
	 * @return the number of matching s p taxs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBycurrencyCode(String currencyCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CURRENCYCODE;

		Object[] finderArgs = new Object[] { currencyCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPTAX_WHERE);

			boolean bindCurrencyCode = false;

			if (currencyCode == null) {
				query.append(_FINDER_COLUMN_CURRENCYCODE_CURRENCYCODE_1);
			}
			else if (currencyCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CURRENCYCODE_CURRENCYCODE_3);
			}
			else {
				bindCurrencyCode = true;

				query.append(_FINDER_COLUMN_CURRENCYCODE_CURRENCYCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCurrencyCode) {
					qPos.add(currencyCode);
				}

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

	private static final String _FINDER_COLUMN_CURRENCYCODE_CURRENCYCODE_1 = "spTax.currencyCode IS NULL";
	private static final String _FINDER_COLUMN_CURRENCYCODE_CURRENCYCODE_2 = "spTax.currencyCode = ?";
	private static final String _FINDER_COLUMN_CURRENCYCODE_CURRENCYCODE_3 = "(spTax.currencyCode IS NULL OR spTax.currencyCode = '')";

	public SPTaxPersistenceImpl() {
		setModelClass(SPTax.class);
	}

	/**
	 * Caches the s p tax in the entity cache if it is enabled.
	 *
	 * @param spTax the s p tax
	 */
	@Override
	public void cacheResult(SPTax spTax) {
		EntityCacheUtil.putResult(SPTaxModelImpl.ENTITY_CACHE_ENABLED,
			SPTaxImpl.class, spTax.getPrimaryKey(), spTax);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CURRENCYCODE,
			new Object[] { spTax.getCurrencyCode() }, spTax);

		spTax.resetOriginalValues();
	}

	/**
	 * Caches the s p taxs in the entity cache if it is enabled.
	 *
	 * @param spTaxs the s p taxs
	 */
	@Override
	public void cacheResult(List<SPTax> spTaxs) {
		for (SPTax spTax : spTaxs) {
			if (EntityCacheUtil.getResult(SPTaxModelImpl.ENTITY_CACHE_ENABLED,
						SPTaxImpl.class, spTax.getPrimaryKey()) == null) {
				cacheResult(spTax);
			}
			else {
				spTax.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p taxs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPTaxImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPTaxImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p tax.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPTax spTax) {
		EntityCacheUtil.removeResult(SPTaxModelImpl.ENTITY_CACHE_ENABLED,
			SPTaxImpl.class, spTax.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spTax);
	}

	@Override
	public void clearCache(List<SPTax> spTaxs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPTax spTax : spTaxs) {
			EntityCacheUtil.removeResult(SPTaxModelImpl.ENTITY_CACHE_ENABLED,
				SPTaxImpl.class, spTax.getPrimaryKey());

			clearUniqueFindersCache(spTax);
		}
	}

	protected void cacheUniqueFindersCache(SPTax spTax) {
		if (spTax.isNew()) {
			Object[] args = new Object[] { spTax.getCurrencyCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CURRENCYCODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CURRENCYCODE, args,
				spTax);
		}
		else {
			SPTaxModelImpl spTaxModelImpl = (SPTaxModelImpl)spTax;

			if ((spTaxModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CURRENCYCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { spTax.getCurrencyCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CURRENCYCODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CURRENCYCODE,
					args, spTax);
			}
		}
	}

	protected void clearUniqueFindersCache(SPTax spTax) {
		SPTaxModelImpl spTaxModelImpl = (SPTaxModelImpl)spTax;

		Object[] args = new Object[] { spTax.getCurrencyCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CURRENCYCODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CURRENCYCODE, args);

		if ((spTaxModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CURRENCYCODE.getColumnBitmask()) != 0) {
			args = new Object[] { spTaxModelImpl.getOriginalCurrencyCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CURRENCYCODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CURRENCYCODE, args);
		}
	}

	/**
	 * Creates a new s p tax with the primary key. Does not add the s p tax to the database.
	 *
	 * @param spTaxId the primary key for the new s p tax
	 * @return the new s p tax
	 */
	@Override
	public SPTax create(long spTaxId) {
		SPTax spTax = new SPTaxImpl();

		spTax.setNew(true);
		spTax.setPrimaryKey(spTaxId);

		return spTax;
	}

	/**
	 * Removes the s p tax with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spTaxId the primary key of the s p tax
	 * @return the s p tax that was removed
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPTaxException if a s p tax with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTax remove(long spTaxId)
		throws NoSuchSPTaxException, SystemException {
		return remove((Serializable)spTaxId);
	}

	/**
	 * Removes the s p tax with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p tax
	 * @return the s p tax that was removed
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPTaxException if a s p tax with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTax remove(Serializable primaryKey)
		throws NoSuchSPTaxException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPTax spTax = (SPTax)session.get(SPTaxImpl.class, primaryKey);

			if (spTax == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPTaxException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spTax);
		}
		catch (NoSuchSPTaxException nsee) {
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
	protected SPTax removeImpl(SPTax spTax) throws SystemException {
		spTax = toUnwrappedModel(spTax);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spTax)) {
				spTax = (SPTax)session.get(SPTaxImpl.class,
						spTax.getPrimaryKeyObj());
			}

			if (spTax != null) {
				session.delete(spTax);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spTax != null) {
			clearCache(spTax);
		}

		return spTax;
	}

	@Override
	public SPTax updateImpl(
		com.sambaash.platform.srv.spshopping.model.SPTax spTax)
		throws SystemException {
		spTax = toUnwrappedModel(spTax);

		boolean isNew = spTax.isNew();

		Session session = null;

		try {
			session = openSession();

			if (spTax.isNew()) {
				session.save(spTax);

				spTax.setNew(false);
			}
			else {
				session.merge(spTax);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPTaxModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(SPTaxModelImpl.ENTITY_CACHE_ENABLED,
			SPTaxImpl.class, spTax.getPrimaryKey(), spTax);

		clearUniqueFindersCache(spTax);
		cacheUniqueFindersCache(spTax);

		return spTax;
	}

	protected SPTax toUnwrappedModel(SPTax spTax) {
		if (spTax instanceof SPTaxImpl) {
			return spTax;
		}

		SPTaxImpl spTaxImpl = new SPTaxImpl();

		spTaxImpl.setNew(spTax.isNew());
		spTaxImpl.setPrimaryKey(spTax.getPrimaryKey());

		spTaxImpl.setSpTaxId(spTax.getSpTaxId());
		spTaxImpl.setGroupId(spTax.getGroupId());
		spTaxImpl.setCurrencyCode(spTax.getCurrencyCode());
		spTaxImpl.setTaxName(spTax.getTaxName());
		spTaxImpl.setTaxValue(spTax.getTaxValue());
		spTaxImpl.setCompanyId(spTax.getCompanyId());
		spTaxImpl.setUserId(spTax.getUserId());
		spTaxImpl.setUserName(spTax.getUserName());
		spTaxImpl.setCreateDate(spTax.getCreateDate());
		spTaxImpl.setModifiedDate(spTax.getModifiedDate());

		return spTaxImpl;
	}

	/**
	 * Returns the s p tax with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p tax
	 * @return the s p tax
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPTaxException if a s p tax with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTax findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPTaxException, SystemException {
		SPTax spTax = fetchByPrimaryKey(primaryKey);

		if (spTax == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPTaxException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spTax;
	}

	/**
	 * Returns the s p tax with the primary key or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPTaxException} if it could not be found.
	 *
	 * @param spTaxId the primary key of the s p tax
	 * @return the s p tax
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPTaxException if a s p tax with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTax findByPrimaryKey(long spTaxId)
		throws NoSuchSPTaxException, SystemException {
		return findByPrimaryKey((Serializable)spTaxId);
	}

	/**
	 * Returns the s p tax with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p tax
	 * @return the s p tax, or <code>null</code> if a s p tax with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTax fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPTax spTax = (SPTax)EntityCacheUtil.getResult(SPTaxModelImpl.ENTITY_CACHE_ENABLED,
				SPTaxImpl.class, primaryKey);

		if (spTax == _nullSPTax) {
			return null;
		}

		if (spTax == null) {
			Session session = null;

			try {
				session = openSession();

				spTax = (SPTax)session.get(SPTaxImpl.class, primaryKey);

				if (spTax != null) {
					cacheResult(spTax);
				}
				else {
					EntityCacheUtil.putResult(SPTaxModelImpl.ENTITY_CACHE_ENABLED,
						SPTaxImpl.class, primaryKey, _nullSPTax);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPTaxModelImpl.ENTITY_CACHE_ENABLED,
					SPTaxImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spTax;
	}

	/**
	 * Returns the s p tax with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spTaxId the primary key of the s p tax
	 * @return the s p tax, or <code>null</code> if a s p tax with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTax fetchByPrimaryKey(long spTaxId) throws SystemException {
		return fetchByPrimaryKey((Serializable)spTaxId);
	}

	/**
	 * Returns all the s p taxs.
	 *
	 * @return the s p taxs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPTax> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p taxs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPTaxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p taxs
	 * @param end the upper bound of the range of s p taxs (not inclusive)
	 * @return the range of s p taxs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPTax> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p taxs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPTaxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p taxs
	 * @param end the upper bound of the range of s p taxs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p taxs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPTax> findAll(int start, int end,
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

		List<SPTax> list = (List<SPTax>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPTAX);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPTAX;

				if (pagination) {
					sql = sql.concat(SPTaxModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPTax>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPTax>(list);
				}
				else {
					list = (List<SPTax>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the s p taxs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPTax spTax : findAll()) {
			remove(spTax);
		}
	}

	/**
	 * Returns the number of s p taxs.
	 *
	 * @return the number of s p taxs
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

				Query q = session.createQuery(_SQL_COUNT_SPTAX);

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
	 * Initializes the s p tax persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spshopping.model.SPTax")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPTax>> listenersList = new ArrayList<ModelListener<SPTax>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPTax>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPTaxImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPTAX = "SELECT spTax FROM SPTax spTax";
	private static final String _SQL_SELECT_SPTAX_WHERE = "SELECT spTax FROM SPTax spTax WHERE ";
	private static final String _SQL_COUNT_SPTAX = "SELECT COUNT(spTax) FROM SPTax spTax";
	private static final String _SQL_COUNT_SPTAX_WHERE = "SELECT COUNT(spTax) FROM SPTax spTax WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spTax.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPTax exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPTax exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPTaxPersistenceImpl.class);
	private static SPTax _nullSPTax = new SPTaxImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPTax> toCacheModel() {
				return _nullSPTaxCacheModel;
			}
		};

	private static CacheModel<SPTax> _nullSPTaxCacheModel = new CacheModel<SPTax>() {
			@Override
			public SPTax toEntityModel() {
				return _nullSPTax;
			}
		};
}