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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.spservices.NoSuchSPLdapMappingException;
import com.sambaash.platform.srv.spservices.model.SPLdapMapping;
import com.sambaash.platform.srv.spservices.model.impl.SPLdapMappingImpl;
import com.sambaash.platform.srv.spservices.model.impl.SPLdapMappingModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p ldap mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPLdapMappingPersistence
 * @see SPLdapMappingUtil
 * @generated
 */
public class SPLdapMappingPersistenceImpl extends BasePersistenceImpl<SPLdapMapping>
	implements SPLdapMappingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPLdapMappingUtil} to access the s p ldap mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPLdapMappingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPLdapMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPLdapMappingModelImpl.FINDER_CACHE_ENABLED,
			SPLdapMappingImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPLdapMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPLdapMappingModelImpl.FINDER_CACHE_ENABLED,
			SPLdapMappingImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPLdapMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPLdapMappingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_COUNTRYDEPARTMENTANDLEGALENTITY =
		new FinderPath(SPLdapMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPLdapMappingModelImpl.FINDER_CACHE_ENABLED,
			SPLdapMappingImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCountryDepartmentAndLegalEntity",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			SPLdapMappingModelImpl.LDAPCOUNTRY_COLUMN_BITMASK |
			SPLdapMappingModelImpl.LDAPDEPARTMENT_COLUMN_BITMASK |
			SPLdapMappingModelImpl.LDAPCOMPANY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRYDEPARTMENTANDLEGALENTITY =
		new FinderPath(SPLdapMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPLdapMappingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCountryDepartmentAndLegalEntity",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the s p ldap mapping where ldapCountry = &#63; and ldapDepartment = &#63; and ldapCompany = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPLdapMappingException} if it could not be found.
	 *
	 * @param ldapCountry the ldap country
	 * @param ldapDepartment the ldap department
	 * @param ldapCompany the ldap company
	 * @return the matching s p ldap mapping
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLdapMappingException if a matching s p ldap mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLdapMapping findByCountryDepartmentAndLegalEntity(
		String ldapCountry, String ldapDepartment, String ldapCompany)
		throws NoSuchSPLdapMappingException, SystemException {
		SPLdapMapping spLdapMapping = fetchByCountryDepartmentAndLegalEntity(ldapCountry,
				ldapDepartment, ldapCompany);

		if (spLdapMapping == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ldapCountry=");
			msg.append(ldapCountry);

			msg.append(", ldapDepartment=");
			msg.append(ldapDepartment);

			msg.append(", ldapCompany=");
			msg.append(ldapCompany);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSPLdapMappingException(msg.toString());
		}

		return spLdapMapping;
	}

	/**
	 * Returns the s p ldap mapping where ldapCountry = &#63; and ldapDepartment = &#63; and ldapCompany = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ldapCountry the ldap country
	 * @param ldapDepartment the ldap department
	 * @param ldapCompany the ldap company
	 * @return the matching s p ldap mapping, or <code>null</code> if a matching s p ldap mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLdapMapping fetchByCountryDepartmentAndLegalEntity(
		String ldapCountry, String ldapDepartment, String ldapCompany)
		throws SystemException {
		return fetchByCountryDepartmentAndLegalEntity(ldapCountry,
			ldapDepartment, ldapCompany, true);
	}

	/**
	 * Returns the s p ldap mapping where ldapCountry = &#63; and ldapDepartment = &#63; and ldapCompany = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ldapCountry the ldap country
	 * @param ldapDepartment the ldap department
	 * @param ldapCompany the ldap company
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p ldap mapping, or <code>null</code> if a matching s p ldap mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLdapMapping fetchByCountryDepartmentAndLegalEntity(
		String ldapCountry, String ldapDepartment, String ldapCompany,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				ldapCountry, ldapDepartment, ldapCompany
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COUNTRYDEPARTMENTANDLEGALENTITY,
					finderArgs, this);
		}

		if (result instanceof SPLdapMapping) {
			SPLdapMapping spLdapMapping = (SPLdapMapping)result;

			if (!Validator.equals(ldapCountry, spLdapMapping.getLdapCountry()) ||
					!Validator.equals(ldapDepartment,
						spLdapMapping.getLdapDepartment()) ||
					!Validator.equals(ldapCompany,
						spLdapMapping.getLdapCompany())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_SPLDAPMAPPING_WHERE);

			boolean bindLdapCountry = false;

			if (ldapCountry == null) {
				query.append(_FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPCOUNTRY_1);
			}
			else if (ldapCountry.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPCOUNTRY_3);
			}
			else {
				bindLdapCountry = true;

				query.append(_FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPCOUNTRY_2);
			}

			boolean bindLdapDepartment = false;

			if (ldapDepartment == null) {
				query.append(_FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPDEPARTMENT_1);
			}
			else if (ldapDepartment.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPDEPARTMENT_3);
			}
			else {
				bindLdapDepartment = true;

				query.append(_FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPDEPARTMENT_2);
			}

			boolean bindLdapCompany = false;

			if (ldapCompany == null) {
				query.append(_FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPCOMPANY_1);
			}
			else if (ldapCompany.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPCOMPANY_3);
			}
			else {
				bindLdapCompany = true;

				query.append(_FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPCOMPANY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLdapCountry) {
					qPos.add(ldapCountry);
				}

				if (bindLdapDepartment) {
					qPos.add(ldapDepartment);
				}

				if (bindLdapCompany) {
					qPos.add(ldapCompany);
				}

				List<SPLdapMapping> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYDEPARTMENTANDLEGALENTITY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SPLdapMappingPersistenceImpl.fetchByCountryDepartmentAndLegalEntity(String, String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SPLdapMapping spLdapMapping = list.get(0);

					result = spLdapMapping;

					cacheResult(spLdapMapping);

					if ((spLdapMapping.getLdapCountry() == null) ||
							!spLdapMapping.getLdapCountry().equals(ldapCountry) ||
							(spLdapMapping.getLdapDepartment() == null) ||
							!spLdapMapping.getLdapDepartment()
											  .equals(ldapDepartment) ||
							(spLdapMapping.getLdapCompany() == null) ||
							!spLdapMapping.getLdapCompany().equals(ldapCompany)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYDEPARTMENTANDLEGALENTITY,
							finderArgs, spLdapMapping);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COUNTRYDEPARTMENTANDLEGALENTITY,
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
			return (SPLdapMapping)result;
		}
	}

	/**
	 * Removes the s p ldap mapping where ldapCountry = &#63; and ldapDepartment = &#63; and ldapCompany = &#63; from the database.
	 *
	 * @param ldapCountry the ldap country
	 * @param ldapDepartment the ldap department
	 * @param ldapCompany the ldap company
	 * @return the s p ldap mapping that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLdapMapping removeByCountryDepartmentAndLegalEntity(
		String ldapCountry, String ldapDepartment, String ldapCompany)
		throws NoSuchSPLdapMappingException, SystemException {
		SPLdapMapping spLdapMapping = findByCountryDepartmentAndLegalEntity(ldapCountry,
				ldapDepartment, ldapCompany);

		return remove(spLdapMapping);
	}

	/**
	 * Returns the number of s p ldap mappings where ldapCountry = &#63; and ldapDepartment = &#63; and ldapCompany = &#63;.
	 *
	 * @param ldapCountry the ldap country
	 * @param ldapDepartment the ldap department
	 * @param ldapCompany the ldap company
	 * @return the number of matching s p ldap mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCountryDepartmentAndLegalEntity(String ldapCountry,
		String ldapDepartment, String ldapCompany) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNTRYDEPARTMENTANDLEGALENTITY;

		Object[] finderArgs = new Object[] {
				ldapCountry, ldapDepartment, ldapCompany
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPLDAPMAPPING_WHERE);

			boolean bindLdapCountry = false;

			if (ldapCountry == null) {
				query.append(_FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPCOUNTRY_1);
			}
			else if (ldapCountry.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPCOUNTRY_3);
			}
			else {
				bindLdapCountry = true;

				query.append(_FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPCOUNTRY_2);
			}

			boolean bindLdapDepartment = false;

			if (ldapDepartment == null) {
				query.append(_FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPDEPARTMENT_1);
			}
			else if (ldapDepartment.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPDEPARTMENT_3);
			}
			else {
				bindLdapDepartment = true;

				query.append(_FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPDEPARTMENT_2);
			}

			boolean bindLdapCompany = false;

			if (ldapCompany == null) {
				query.append(_FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPCOMPANY_1);
			}
			else if (ldapCompany.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPCOMPANY_3);
			}
			else {
				bindLdapCompany = true;

				query.append(_FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPCOMPANY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLdapCountry) {
					qPos.add(ldapCountry);
				}

				if (bindLdapDepartment) {
					qPos.add(ldapDepartment);
				}

				if (bindLdapCompany) {
					qPos.add(ldapCompany);
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

	private static final String _FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPCOUNTRY_1 =
		"spLdapMapping.ldapCountry IS NULL AND ";
	private static final String _FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPCOUNTRY_2 =
		"spLdapMapping.ldapCountry = ? AND ";
	private static final String _FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPCOUNTRY_3 =
		"(spLdapMapping.ldapCountry IS NULL OR spLdapMapping.ldapCountry = '') AND ";
	private static final String _FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPDEPARTMENT_1 =
		"spLdapMapping.ldapDepartment IS NULL AND ";
	private static final String _FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPDEPARTMENT_2 =
		"spLdapMapping.ldapDepartment = ? AND ";
	private static final String _FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPDEPARTMENT_3 =
		"(spLdapMapping.ldapDepartment IS NULL OR spLdapMapping.ldapDepartment = '') AND ";
	private static final String _FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPCOMPANY_1 =
		"spLdapMapping.ldapCompany IS NULL";
	private static final String _FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPCOMPANY_2 =
		"spLdapMapping.ldapCompany = ?";
	private static final String _FINDER_COLUMN_COUNTRYDEPARTMENTANDLEGALENTITY_LDAPCOMPANY_3 =
		"(spLdapMapping.ldapCompany IS NULL OR spLdapMapping.ldapCompany = '')";

	public SPLdapMappingPersistenceImpl() {
		setModelClass(SPLdapMapping.class);
	}

	/**
	 * Caches the s p ldap mapping in the entity cache if it is enabled.
	 *
	 * @param spLdapMapping the s p ldap mapping
	 */
	@Override
	public void cacheResult(SPLdapMapping spLdapMapping) {
		EntityCacheUtil.putResult(SPLdapMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPLdapMappingImpl.class, spLdapMapping.getPrimaryKey(),
			spLdapMapping);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYDEPARTMENTANDLEGALENTITY,
			new Object[] {
				spLdapMapping.getLdapCountry(),
				spLdapMapping.getLdapDepartment(),
				spLdapMapping.getLdapCompany()
			}, spLdapMapping);

		spLdapMapping.resetOriginalValues();
	}

	/**
	 * Caches the s p ldap mappings in the entity cache if it is enabled.
	 *
	 * @param spLdapMappings the s p ldap mappings
	 */
	@Override
	public void cacheResult(List<SPLdapMapping> spLdapMappings) {
		for (SPLdapMapping spLdapMapping : spLdapMappings) {
			if (EntityCacheUtil.getResult(
						SPLdapMappingModelImpl.ENTITY_CACHE_ENABLED,
						SPLdapMappingImpl.class, spLdapMapping.getPrimaryKey()) == null) {
				cacheResult(spLdapMapping);
			}
			else {
				spLdapMapping.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p ldap mappings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPLdapMappingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPLdapMappingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p ldap mapping.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPLdapMapping spLdapMapping) {
		EntityCacheUtil.removeResult(SPLdapMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPLdapMappingImpl.class, spLdapMapping.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spLdapMapping);
	}

	@Override
	public void clearCache(List<SPLdapMapping> spLdapMappings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPLdapMapping spLdapMapping : spLdapMappings) {
			EntityCacheUtil.removeResult(SPLdapMappingModelImpl.ENTITY_CACHE_ENABLED,
				SPLdapMappingImpl.class, spLdapMapping.getPrimaryKey());

			clearUniqueFindersCache(spLdapMapping);
		}
	}

	protected void cacheUniqueFindersCache(SPLdapMapping spLdapMapping) {
		if (spLdapMapping.isNew()) {
			Object[] args = new Object[] {
					spLdapMapping.getLdapCountry(),
					spLdapMapping.getLdapDepartment(),
					spLdapMapping.getLdapCompany()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COUNTRYDEPARTMENTANDLEGALENTITY,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYDEPARTMENTANDLEGALENTITY,
				args, spLdapMapping);
		}
		else {
			SPLdapMappingModelImpl spLdapMappingModelImpl = (SPLdapMappingModelImpl)spLdapMapping;

			if ((spLdapMappingModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COUNTRYDEPARTMENTANDLEGALENTITY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spLdapMapping.getLdapCountry(),
						spLdapMapping.getLdapDepartment(),
						spLdapMapping.getLdapCompany()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COUNTRYDEPARTMENTANDLEGALENTITY,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYDEPARTMENTANDLEGALENTITY,
					args, spLdapMapping);
			}
		}
	}

	protected void clearUniqueFindersCache(SPLdapMapping spLdapMapping) {
		SPLdapMappingModelImpl spLdapMappingModelImpl = (SPLdapMappingModelImpl)spLdapMapping;

		Object[] args = new Object[] {
				spLdapMapping.getLdapCountry(),
				spLdapMapping.getLdapDepartment(),
				spLdapMapping.getLdapCompany()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYDEPARTMENTANDLEGALENTITY,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COUNTRYDEPARTMENTANDLEGALENTITY,
			args);

		if ((spLdapMappingModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COUNTRYDEPARTMENTANDLEGALENTITY.getColumnBitmask()) != 0) {
			args = new Object[] {
					spLdapMappingModelImpl.getOriginalLdapCountry(),
					spLdapMappingModelImpl.getOriginalLdapDepartment(),
					spLdapMappingModelImpl.getOriginalLdapCompany()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYDEPARTMENTANDLEGALENTITY,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COUNTRYDEPARTMENTANDLEGALENTITY,
				args);
		}
	}

	/**
	 * Creates a new s p ldap mapping with the primary key. Does not add the s p ldap mapping to the database.
	 *
	 * @param spLdapMappingId the primary key for the new s p ldap mapping
	 * @return the new s p ldap mapping
	 */
	@Override
	public SPLdapMapping create(long spLdapMappingId) {
		SPLdapMapping spLdapMapping = new SPLdapMappingImpl();

		spLdapMapping.setNew(true);
		spLdapMapping.setPrimaryKey(spLdapMappingId);

		return spLdapMapping;
	}

	/**
	 * Removes the s p ldap mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spLdapMappingId the primary key of the s p ldap mapping
	 * @return the s p ldap mapping that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLdapMappingException if a s p ldap mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLdapMapping remove(long spLdapMappingId)
		throws NoSuchSPLdapMappingException, SystemException {
		return remove((Serializable)spLdapMappingId);
	}

	/**
	 * Removes the s p ldap mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p ldap mapping
	 * @return the s p ldap mapping that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLdapMappingException if a s p ldap mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLdapMapping remove(Serializable primaryKey)
		throws NoSuchSPLdapMappingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPLdapMapping spLdapMapping = (SPLdapMapping)session.get(SPLdapMappingImpl.class,
					primaryKey);

			if (spLdapMapping == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPLdapMappingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spLdapMapping);
		}
		catch (NoSuchSPLdapMappingException nsee) {
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
	protected SPLdapMapping removeImpl(SPLdapMapping spLdapMapping)
		throws SystemException {
		spLdapMapping = toUnwrappedModel(spLdapMapping);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spLdapMapping)) {
				spLdapMapping = (SPLdapMapping)session.get(SPLdapMappingImpl.class,
						spLdapMapping.getPrimaryKeyObj());
			}

			if (spLdapMapping != null) {
				session.delete(spLdapMapping);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spLdapMapping != null) {
			clearCache(spLdapMapping);
		}

		return spLdapMapping;
	}

	@Override
	public SPLdapMapping updateImpl(
		com.sambaash.platform.srv.spservices.model.SPLdapMapping spLdapMapping)
		throws SystemException {
		spLdapMapping = toUnwrappedModel(spLdapMapping);

		boolean isNew = spLdapMapping.isNew();

		Session session = null;

		try {
			session = openSession();

			if (spLdapMapping.isNew()) {
				session.save(spLdapMapping);

				spLdapMapping.setNew(false);
			}
			else {
				session.merge(spLdapMapping);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPLdapMappingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(SPLdapMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPLdapMappingImpl.class, spLdapMapping.getPrimaryKey(),
			spLdapMapping);

		clearUniqueFindersCache(spLdapMapping);
		cacheUniqueFindersCache(spLdapMapping);

		return spLdapMapping;
	}

	protected SPLdapMapping toUnwrappedModel(SPLdapMapping spLdapMapping) {
		if (spLdapMapping instanceof SPLdapMappingImpl) {
			return spLdapMapping;
		}

		SPLdapMappingImpl spLdapMappingImpl = new SPLdapMappingImpl();

		spLdapMappingImpl.setNew(spLdapMapping.isNew());
		spLdapMappingImpl.setPrimaryKey(spLdapMapping.getPrimaryKey());

		spLdapMappingImpl.setSpLdapMappingId(spLdapMapping.getSpLdapMappingId());
		spLdapMappingImpl.setGroupId(spLdapMapping.getGroupId());
		spLdapMappingImpl.setCompanyId(spLdapMapping.getCompanyId());
		spLdapMappingImpl.setUserId(spLdapMapping.getUserId());
		spLdapMappingImpl.setUserName(spLdapMapping.getUserName());
		spLdapMappingImpl.setCreateDate(spLdapMapping.getCreateDate());
		spLdapMappingImpl.setModifiedDate(spLdapMapping.getModifiedDate());
		spLdapMappingImpl.setCountryId(spLdapMapping.getCountryId());
		spLdapMappingImpl.setDepartmentId(spLdapMapping.getDepartmentId());
		spLdapMappingImpl.setCountryDepartmentId(spLdapMapping.getCountryDepartmentId());
		spLdapMappingImpl.setLdapCountry(spLdapMapping.getLdapCountry());
		spLdapMappingImpl.setLdapDepartment(spLdapMapping.getLdapDepartment());
		spLdapMappingImpl.setLdapCompany(spLdapMapping.getLdapCompany());
		spLdapMappingImpl.setDefaultRoleId(spLdapMapping.getDefaultRoleId());

		return spLdapMappingImpl;
	}

	/**
	 * Returns the s p ldap mapping with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p ldap mapping
	 * @return the s p ldap mapping
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLdapMappingException if a s p ldap mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLdapMapping findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPLdapMappingException, SystemException {
		SPLdapMapping spLdapMapping = fetchByPrimaryKey(primaryKey);

		if (spLdapMapping == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPLdapMappingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spLdapMapping;
	}

	/**
	 * Returns the s p ldap mapping with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPLdapMappingException} if it could not be found.
	 *
	 * @param spLdapMappingId the primary key of the s p ldap mapping
	 * @return the s p ldap mapping
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLdapMappingException if a s p ldap mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLdapMapping findByPrimaryKey(long spLdapMappingId)
		throws NoSuchSPLdapMappingException, SystemException {
		return findByPrimaryKey((Serializable)spLdapMappingId);
	}

	/**
	 * Returns the s p ldap mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p ldap mapping
	 * @return the s p ldap mapping, or <code>null</code> if a s p ldap mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLdapMapping fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPLdapMapping spLdapMapping = (SPLdapMapping)EntityCacheUtil.getResult(SPLdapMappingModelImpl.ENTITY_CACHE_ENABLED,
				SPLdapMappingImpl.class, primaryKey);

		if (spLdapMapping == _nullSPLdapMapping) {
			return null;
		}

		if (spLdapMapping == null) {
			Session session = null;

			try {
				session = openSession();

				spLdapMapping = (SPLdapMapping)session.get(SPLdapMappingImpl.class,
						primaryKey);

				if (spLdapMapping != null) {
					cacheResult(spLdapMapping);
				}
				else {
					EntityCacheUtil.putResult(SPLdapMappingModelImpl.ENTITY_CACHE_ENABLED,
						SPLdapMappingImpl.class, primaryKey, _nullSPLdapMapping);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPLdapMappingModelImpl.ENTITY_CACHE_ENABLED,
					SPLdapMappingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spLdapMapping;
	}

	/**
	 * Returns the s p ldap mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spLdapMappingId the primary key of the s p ldap mapping
	 * @return the s p ldap mapping, or <code>null</code> if a s p ldap mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLdapMapping fetchByPrimaryKey(long spLdapMappingId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spLdapMappingId);
	}

	/**
	 * Returns all the s p ldap mappings.
	 *
	 * @return the s p ldap mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPLdapMapping> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p ldap mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLdapMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p ldap mappings
	 * @param end the upper bound of the range of s p ldap mappings (not inclusive)
	 * @return the range of s p ldap mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPLdapMapping> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p ldap mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLdapMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p ldap mappings
	 * @param end the upper bound of the range of s p ldap mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p ldap mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPLdapMapping> findAll(int start, int end,
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

		List<SPLdapMapping> list = (List<SPLdapMapping>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPLDAPMAPPING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPLDAPMAPPING;

				if (pagination) {
					sql = sql.concat(SPLdapMappingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPLdapMapping>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPLdapMapping>(list);
				}
				else {
					list = (List<SPLdapMapping>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p ldap mappings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPLdapMapping spLdapMapping : findAll()) {
			remove(spLdapMapping);
		}
	}

	/**
	 * Returns the number of s p ldap mappings.
	 *
	 * @return the number of s p ldap mappings
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

				Query q = session.createQuery(_SQL_COUNT_SPLDAPMAPPING);

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
	 * Initializes the s p ldap mapping persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spservices.model.SPLdapMapping")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPLdapMapping>> listenersList = new ArrayList<ModelListener<SPLdapMapping>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPLdapMapping>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPLdapMappingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPLDAPMAPPING = "SELECT spLdapMapping FROM SPLdapMapping spLdapMapping";
	private static final String _SQL_SELECT_SPLDAPMAPPING_WHERE = "SELECT spLdapMapping FROM SPLdapMapping spLdapMapping WHERE ";
	private static final String _SQL_COUNT_SPLDAPMAPPING = "SELECT COUNT(spLdapMapping) FROM SPLdapMapping spLdapMapping";
	private static final String _SQL_COUNT_SPLDAPMAPPING_WHERE = "SELECT COUNT(spLdapMapping) FROM SPLdapMapping spLdapMapping WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spLdapMapping.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPLdapMapping exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPLdapMapping exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPLdapMappingPersistenceImpl.class);
	private static SPLdapMapping _nullSPLdapMapping = new SPLdapMappingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPLdapMapping> toCacheModel() {
				return _nullSPLdapMappingCacheModel;
			}
		};

	private static CacheModel<SPLdapMapping> _nullSPLdapMappingCacheModel = new CacheModel<SPLdapMapping>() {
			@Override
			public SPLdapMapping toEntityModel() {
				return _nullSPLdapMapping;
			}
		};
}