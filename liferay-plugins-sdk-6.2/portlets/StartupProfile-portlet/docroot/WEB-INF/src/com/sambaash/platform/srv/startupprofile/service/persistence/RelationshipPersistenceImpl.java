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

package com.sambaash.platform.srv.startupprofile.service.persistence;

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

import com.sambaash.platform.srv.startupprofile.NoSuchRelationshipException;
import com.sambaash.platform.srv.startupprofile.model.Relationship;
import com.sambaash.platform.srv.startupprofile.model.impl.RelationshipImpl;
import com.sambaash.platform.srv.startupprofile.model.impl.RelationshipModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the relationship service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see RelationshipPersistence
 * @see RelationshipUtil
 * @generated
 */
public class RelationshipPersistenceImpl extends BasePersistenceImpl<Relationship>
	implements RelationshipPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RelationshipUtil} to access the relationship persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RelationshipImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RelationshipModelImpl.ENTITY_CACHE_ENABLED,
			RelationshipModelImpl.FINDER_CACHE_ENABLED, RelationshipImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RelationshipModelImpl.ENTITY_CACHE_ENABLED,
			RelationshipModelImpl.FINDER_CACHE_ENABLED, RelationshipImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RelationshipModelImpl.ENTITY_CACHE_ENABLED,
			RelationshipModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public RelationshipPersistenceImpl() {
		setModelClass(Relationship.class);
	}

	/**
	 * Caches the relationship in the entity cache if it is enabled.
	 *
	 * @param relationship the relationship
	 */
	@Override
	public void cacheResult(Relationship relationship) {
		EntityCacheUtil.putResult(RelationshipModelImpl.ENTITY_CACHE_ENABLED,
			RelationshipImpl.class, relationship.getPrimaryKey(), relationship);

		relationship.resetOriginalValues();
	}

	/**
	 * Caches the relationships in the entity cache if it is enabled.
	 *
	 * @param relationships the relationships
	 */
	@Override
	public void cacheResult(List<Relationship> relationships) {
		for (Relationship relationship : relationships) {
			if (EntityCacheUtil.getResult(
						RelationshipModelImpl.ENTITY_CACHE_ENABLED,
						RelationshipImpl.class, relationship.getPrimaryKey()) == null) {
				cacheResult(relationship);
			}
			else {
				relationship.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all relationships.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RelationshipImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RelationshipImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the relationship.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Relationship relationship) {
		EntityCacheUtil.removeResult(RelationshipModelImpl.ENTITY_CACHE_ENABLED,
			RelationshipImpl.class, relationship.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Relationship> relationships) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Relationship relationship : relationships) {
			EntityCacheUtil.removeResult(RelationshipModelImpl.ENTITY_CACHE_ENABLED,
				RelationshipImpl.class, relationship.getPrimaryKey());
		}
	}

	/**
	 * Creates a new relationship with the primary key. Does not add the relationship to the database.
	 *
	 * @param relationshipId the primary key for the new relationship
	 * @return the new relationship
	 */
	@Override
	public Relationship create(long relationshipId) {
		Relationship relationship = new RelationshipImpl();

		relationship.setNew(true);
		relationship.setPrimaryKey(relationshipId);

		return relationship;
	}

	/**
	 * Removes the relationship with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param relationshipId the primary key of the relationship
	 * @return the relationship that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchRelationshipException if a relationship with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Relationship remove(long relationshipId)
		throws NoSuchRelationshipException, SystemException {
		return remove((Serializable)relationshipId);
	}

	/**
	 * Removes the relationship with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the relationship
	 * @return the relationship that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchRelationshipException if a relationship with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Relationship remove(Serializable primaryKey)
		throws NoSuchRelationshipException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Relationship relationship = (Relationship)session.get(RelationshipImpl.class,
					primaryKey);

			if (relationship == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRelationshipException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(relationship);
		}
		catch (NoSuchRelationshipException nsee) {
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
	protected Relationship removeImpl(Relationship relationship)
		throws SystemException {
		relationship = toUnwrappedModel(relationship);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(relationship)) {
				relationship = (Relationship)session.get(RelationshipImpl.class,
						relationship.getPrimaryKeyObj());
			}

			if (relationship != null) {
				session.delete(relationship);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (relationship != null) {
			clearCache(relationship);
		}

		return relationship;
	}

	@Override
	public Relationship updateImpl(
		com.sambaash.platform.srv.startupprofile.model.Relationship relationship)
		throws SystemException {
		relationship = toUnwrappedModel(relationship);

		boolean isNew = relationship.isNew();

		Session session = null;

		try {
			session = openSession();

			if (relationship.isNew()) {
				session.save(relationship);

				relationship.setNew(false);
			}
			else {
				session.merge(relationship);
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

		EntityCacheUtil.putResult(RelationshipModelImpl.ENTITY_CACHE_ENABLED,
			RelationshipImpl.class, relationship.getPrimaryKey(), relationship);

		return relationship;
	}

	protected Relationship toUnwrappedModel(Relationship relationship) {
		if (relationship instanceof RelationshipImpl) {
			return relationship;
		}

		RelationshipImpl relationshipImpl = new RelationshipImpl();

		relationshipImpl.setNew(relationship.isNew());
		relationshipImpl.setPrimaryKey(relationship.getPrimaryKey());

		relationshipImpl.setRelationshipId(relationship.getRelationshipId());
		relationshipImpl.setOrganizationId(relationship.getOrganizationId());
		relationshipImpl.setRefId(relationship.getRefId());
		relationshipImpl.setRefTypeId(relationship.getRefTypeId());
		relationshipImpl.setRelation(relationship.getRelation());
		relationshipImpl.setGroupId(relationship.getGroupId());
		relationshipImpl.setCompanyId(relationship.getCompanyId());
		relationshipImpl.setUserId(relationship.getUserId());
		relationshipImpl.setUserName(relationship.getUserName());
		relationshipImpl.setCreateDate(relationship.getCreateDate());
		relationshipImpl.setModifiedDate(relationship.getModifiedDate());
		relationshipImpl.setActive(relationship.isActive());

		return relationshipImpl;
	}

	/**
	 * Returns the relationship with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the relationship
	 * @return the relationship
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchRelationshipException if a relationship with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Relationship findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRelationshipException, SystemException {
		Relationship relationship = fetchByPrimaryKey(primaryKey);

		if (relationship == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRelationshipException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return relationship;
	}

	/**
	 * Returns the relationship with the primary key or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchRelationshipException} if it could not be found.
	 *
	 * @param relationshipId the primary key of the relationship
	 * @return the relationship
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchRelationshipException if a relationship with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Relationship findByPrimaryKey(long relationshipId)
		throws NoSuchRelationshipException, SystemException {
		return findByPrimaryKey((Serializable)relationshipId);
	}

	/**
	 * Returns the relationship with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the relationship
	 * @return the relationship, or <code>null</code> if a relationship with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Relationship fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Relationship relationship = (Relationship)EntityCacheUtil.getResult(RelationshipModelImpl.ENTITY_CACHE_ENABLED,
				RelationshipImpl.class, primaryKey);

		if (relationship == _nullRelationship) {
			return null;
		}

		if (relationship == null) {
			Session session = null;

			try {
				session = openSession();

				relationship = (Relationship)session.get(RelationshipImpl.class,
						primaryKey);

				if (relationship != null) {
					cacheResult(relationship);
				}
				else {
					EntityCacheUtil.putResult(RelationshipModelImpl.ENTITY_CACHE_ENABLED,
						RelationshipImpl.class, primaryKey, _nullRelationship);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RelationshipModelImpl.ENTITY_CACHE_ENABLED,
					RelationshipImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return relationship;
	}

	/**
	 * Returns the relationship with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param relationshipId the primary key of the relationship
	 * @return the relationship, or <code>null</code> if a relationship with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Relationship fetchByPrimaryKey(long relationshipId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)relationshipId);
	}

	/**
	 * Returns all the relationships.
	 *
	 * @return the relationships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Relationship> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the relationships.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.RelationshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of relationships
	 * @param end the upper bound of the range of relationships (not inclusive)
	 * @return the range of relationships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Relationship> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the relationships.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.RelationshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of relationships
	 * @param end the upper bound of the range of relationships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of relationships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Relationship> findAll(int start, int end,
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

		List<Relationship> list = (List<Relationship>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RELATIONSHIP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RELATIONSHIP;

				if (pagination) {
					sql = sql.concat(RelationshipModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Relationship>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Relationship>(list);
				}
				else {
					list = (List<Relationship>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the relationships from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Relationship relationship : findAll()) {
			remove(relationship);
		}
	}

	/**
	 * Returns the number of relationships.
	 *
	 * @return the number of relationships
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

				Query q = session.createQuery(_SQL_COUNT_RELATIONSHIP);

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
	 * Initializes the relationship persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.startupprofile.model.Relationship")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Relationship>> listenersList = new ArrayList<ModelListener<Relationship>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Relationship>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RelationshipImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RELATIONSHIP = "SELECT relationship FROM Relationship relationship";
	private static final String _SQL_COUNT_RELATIONSHIP = "SELECT COUNT(relationship) FROM Relationship relationship";
	private static final String _ORDER_BY_ENTITY_ALIAS = "relationship.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Relationship exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RelationshipPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active"
			});
	private static Relationship _nullRelationship = new RelationshipImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Relationship> toCacheModel() {
				return _nullRelationshipCacheModel;
			}
		};

	private static CacheModel<Relationship> _nullRelationshipCacheModel = new CacheModel<Relationship>() {
			@Override
			public Relationship toEntityModel() {
				return _nullRelationship;
			}
		};
}