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

package com.sambaash.platform.srv.spdynamicforms.service.persistence;

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

import com.sambaash.platform.srv.spdynamicforms.NoSuchSPFormAttachmentsException;
import com.sambaash.platform.srv.spdynamicforms.model.SPFormAttachments;
import com.sambaash.platform.srv.spdynamicforms.model.impl.SPFormAttachmentsImpl;
import com.sambaash.platform.srv.spdynamicforms.model.impl.SPFormAttachmentsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p form attachments service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author glenn
 * @see SPFormAttachmentsPersistence
 * @see SPFormAttachmentsUtil
 * @generated
 */
public class SPFormAttachmentsPersistenceImpl extends BasePersistenceImpl<SPFormAttachments>
	implements SPFormAttachmentsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPFormAttachmentsUtil} to access the s p form attachments persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPFormAttachmentsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPFormAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
			SPFormAttachmentsModelImpl.FINDER_CACHE_ENABLED,
			SPFormAttachmentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPFormAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
			SPFormAttachmentsModelImpl.FINDER_CACHE_ENABLED,
			SPFormAttachmentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPFormAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
			SPFormAttachmentsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SPFormAttachmentsPersistenceImpl() {
		setModelClass(SPFormAttachments.class);
	}

	/**
	 * Caches the s p form attachments in the entity cache if it is enabled.
	 *
	 * @param spFormAttachments the s p form attachments
	 */
	@Override
	public void cacheResult(SPFormAttachments spFormAttachments) {
		EntityCacheUtil.putResult(SPFormAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
			SPFormAttachmentsImpl.class, spFormAttachments.getPrimaryKey(),
			spFormAttachments);

		spFormAttachments.resetOriginalValues();
	}

	/**
	 * Caches the s p form attachmentses in the entity cache if it is enabled.
	 *
	 * @param spFormAttachmentses the s p form attachmentses
	 */
	@Override
	public void cacheResult(List<SPFormAttachments> spFormAttachmentses) {
		for (SPFormAttachments spFormAttachments : spFormAttachmentses) {
			if (EntityCacheUtil.getResult(
						SPFormAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
						SPFormAttachmentsImpl.class,
						spFormAttachments.getPrimaryKey()) == null) {
				cacheResult(spFormAttachments);
			}
			else {
				spFormAttachments.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p form attachmentses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPFormAttachmentsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPFormAttachmentsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p form attachments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPFormAttachments spFormAttachments) {
		EntityCacheUtil.removeResult(SPFormAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
			SPFormAttachmentsImpl.class, spFormAttachments.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SPFormAttachments> spFormAttachmentses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPFormAttachments spFormAttachments : spFormAttachmentses) {
			EntityCacheUtil.removeResult(SPFormAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
				SPFormAttachmentsImpl.class, spFormAttachments.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s p form attachments with the primary key. Does not add the s p form attachments to the database.
	 *
	 * @param spFormAttachmentsId the primary key for the new s p form attachments
	 * @return the new s p form attachments
	 */
	@Override
	public SPFormAttachments create(long spFormAttachmentsId) {
		SPFormAttachments spFormAttachments = new SPFormAttachmentsImpl();

		spFormAttachments.setNew(true);
		spFormAttachments.setPrimaryKey(spFormAttachmentsId);

		return spFormAttachments;
	}

	/**
	 * Removes the s p form attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spFormAttachmentsId the primary key of the s p form attachments
	 * @return the s p form attachments that was removed
	 * @throws com.sambaash.platform.srv.spdynamicforms.NoSuchSPFormAttachmentsException if a s p form attachments with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPFormAttachments remove(long spFormAttachmentsId)
		throws NoSuchSPFormAttachmentsException, SystemException {
		return remove((Serializable)spFormAttachmentsId);
	}

	/**
	 * Removes the s p form attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p form attachments
	 * @return the s p form attachments that was removed
	 * @throws com.sambaash.platform.srv.spdynamicforms.NoSuchSPFormAttachmentsException if a s p form attachments with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPFormAttachments remove(Serializable primaryKey)
		throws NoSuchSPFormAttachmentsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPFormAttachments spFormAttachments = (SPFormAttachments)session.get(SPFormAttachmentsImpl.class,
					primaryKey);

			if (spFormAttachments == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPFormAttachmentsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spFormAttachments);
		}
		catch (NoSuchSPFormAttachmentsException nsee) {
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
	protected SPFormAttachments removeImpl(SPFormAttachments spFormAttachments)
		throws SystemException {
		spFormAttachments = toUnwrappedModel(spFormAttachments);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spFormAttachments)) {
				spFormAttachments = (SPFormAttachments)session.get(SPFormAttachmentsImpl.class,
						spFormAttachments.getPrimaryKeyObj());
			}

			if (spFormAttachments != null) {
				session.delete(spFormAttachments);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spFormAttachments != null) {
			clearCache(spFormAttachments);
		}

		return spFormAttachments;
	}

	@Override
	public SPFormAttachments updateImpl(
		com.sambaash.platform.srv.spdynamicforms.model.SPFormAttachments spFormAttachments)
		throws SystemException {
		spFormAttachments = toUnwrappedModel(spFormAttachments);

		boolean isNew = spFormAttachments.isNew();

		Session session = null;

		try {
			session = openSession();

			if (spFormAttachments.isNew()) {
				session.save(spFormAttachments);

				spFormAttachments.setNew(false);
			}
			else {
				session.merge(spFormAttachments);
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

		EntityCacheUtil.putResult(SPFormAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
			SPFormAttachmentsImpl.class, spFormAttachments.getPrimaryKey(),
			spFormAttachments);

		return spFormAttachments;
	}

	protected SPFormAttachments toUnwrappedModel(
		SPFormAttachments spFormAttachments) {
		if (spFormAttachments instanceof SPFormAttachmentsImpl) {
			return spFormAttachments;
		}

		SPFormAttachmentsImpl spFormAttachmentsImpl = new SPFormAttachmentsImpl();

		spFormAttachmentsImpl.setNew(spFormAttachments.isNew());
		spFormAttachmentsImpl.setPrimaryKey(spFormAttachments.getPrimaryKey());

		spFormAttachmentsImpl.setSpFormAttachmentsId(spFormAttachments.getSpFormAttachmentsId());
		spFormAttachmentsImpl.setGroupId(spFormAttachments.getGroupId());
		spFormAttachmentsImpl.setCompanyId(spFormAttachments.getCompanyId());
		spFormAttachmentsImpl.setUserId(spFormAttachments.getUserId());
		spFormAttachmentsImpl.setUserName(spFormAttachments.getUserName());
		spFormAttachmentsImpl.setCreateDate(spFormAttachments.getCreateDate());
		spFormAttachmentsImpl.setModifiedDate(spFormAttachments.getModifiedDate());
		spFormAttachmentsImpl.setFormStorageId(spFormAttachments.getFormStorageId());
		spFormAttachmentsImpl.setDataKey(spFormAttachments.getDataKey());
		spFormAttachmentsImpl.setName(spFormAttachments.getName());
		spFormAttachmentsImpl.setUrl(spFormAttachments.getUrl());
		spFormAttachmentsImpl.setVersion(spFormAttachments.getVersion());

		return spFormAttachmentsImpl;
	}

	/**
	 * Returns the s p form attachments with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p form attachments
	 * @return the s p form attachments
	 * @throws com.sambaash.platform.srv.spdynamicforms.NoSuchSPFormAttachmentsException if a s p form attachments with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPFormAttachments findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPFormAttachmentsException, SystemException {
		SPFormAttachments spFormAttachments = fetchByPrimaryKey(primaryKey);

		if (spFormAttachments == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPFormAttachmentsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spFormAttachments;
	}

	/**
	 * Returns the s p form attachments with the primary key or throws a {@link com.sambaash.platform.srv.spdynamicforms.NoSuchSPFormAttachmentsException} if it could not be found.
	 *
	 * @param spFormAttachmentsId the primary key of the s p form attachments
	 * @return the s p form attachments
	 * @throws com.sambaash.platform.srv.spdynamicforms.NoSuchSPFormAttachmentsException if a s p form attachments with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPFormAttachments findByPrimaryKey(long spFormAttachmentsId)
		throws NoSuchSPFormAttachmentsException, SystemException {
		return findByPrimaryKey((Serializable)spFormAttachmentsId);
	}

	/**
	 * Returns the s p form attachments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p form attachments
	 * @return the s p form attachments, or <code>null</code> if a s p form attachments with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPFormAttachments fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPFormAttachments spFormAttachments = (SPFormAttachments)EntityCacheUtil.getResult(SPFormAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
				SPFormAttachmentsImpl.class, primaryKey);

		if (spFormAttachments == _nullSPFormAttachments) {
			return null;
		}

		if (spFormAttachments == null) {
			Session session = null;

			try {
				session = openSession();

				spFormAttachments = (SPFormAttachments)session.get(SPFormAttachmentsImpl.class,
						primaryKey);

				if (spFormAttachments != null) {
					cacheResult(spFormAttachments);
				}
				else {
					EntityCacheUtil.putResult(SPFormAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
						SPFormAttachmentsImpl.class, primaryKey,
						_nullSPFormAttachments);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPFormAttachmentsModelImpl.ENTITY_CACHE_ENABLED,
					SPFormAttachmentsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spFormAttachments;
	}

	/**
	 * Returns the s p form attachments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spFormAttachmentsId the primary key of the s p form attachments
	 * @return the s p form attachments, or <code>null</code> if a s p form attachments with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPFormAttachments fetchByPrimaryKey(long spFormAttachmentsId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spFormAttachmentsId);
	}

	/**
	 * Returns all the s p form attachmentses.
	 *
	 * @return the s p form attachmentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPFormAttachments> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p form attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdynamicforms.model.impl.SPFormAttachmentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p form attachmentses
	 * @param end the upper bound of the range of s p form attachmentses (not inclusive)
	 * @return the range of s p form attachmentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPFormAttachments> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p form attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdynamicforms.model.impl.SPFormAttachmentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p form attachmentses
	 * @param end the upper bound of the range of s p form attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p form attachmentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPFormAttachments> findAll(int start, int end,
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

		List<SPFormAttachments> list = (List<SPFormAttachments>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPFORMATTACHMENTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPFORMATTACHMENTS;

				if (pagination) {
					sql = sql.concat(SPFormAttachmentsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPFormAttachments>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPFormAttachments>(list);
				}
				else {
					list = (List<SPFormAttachments>)QueryUtil.list(q,
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
	 * Removes all the s p form attachmentses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPFormAttachments spFormAttachments : findAll()) {
			remove(spFormAttachments);
		}
	}

	/**
	 * Returns the number of s p form attachmentses.
	 *
	 * @return the number of s p form attachmentses
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

				Query q = session.createQuery(_SQL_COUNT_SPFORMATTACHMENTS);

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
	 * Initializes the s p form attachments persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spdynamicforms.model.SPFormAttachments")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPFormAttachments>> listenersList = new ArrayList<ModelListener<SPFormAttachments>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPFormAttachments>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPFormAttachmentsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPFORMATTACHMENTS = "SELECT spFormAttachments FROM SPFormAttachments spFormAttachments";
	private static final String _SQL_COUNT_SPFORMATTACHMENTS = "SELECT COUNT(spFormAttachments) FROM SPFormAttachments spFormAttachments";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spFormAttachments.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPFormAttachments exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPFormAttachmentsPersistenceImpl.class);
	private static SPFormAttachments _nullSPFormAttachments = new SPFormAttachmentsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPFormAttachments> toCacheModel() {
				return _nullSPFormAttachmentsCacheModel;
			}
		};

	private static CacheModel<SPFormAttachments> _nullSPFormAttachmentsCacheModel =
		new CacheModel<SPFormAttachments>() {
			@Override
			public SPFormAttachments toEntityModel() {
				return _nullSPFormAttachments;
			}
		};
}