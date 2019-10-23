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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException;
import com.sambaash.platform.srv.startupprofile.model.Questionnaire;
import com.sambaash.platform.srv.startupprofile.model.impl.QuestionnaireImpl;
import com.sambaash.platform.srv.startupprofile.model.impl.QuestionnaireModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the questionnaire service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see QuestionnairePersistence
 * @see QuestionnaireUtil
 * @generated
 */
public class QuestionnairePersistenceImpl extends BasePersistenceImpl<Questionnaire>
	implements QuestionnairePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link QuestionnaireUtil} to access the questionnaire persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = QuestionnaireImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(QuestionnaireModelImpl.ENTITY_CACHE_ENABLED,
			QuestionnaireModelImpl.FINDER_CACHE_ENABLED,
			QuestionnaireImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(QuestionnaireModelImpl.ENTITY_CACHE_ENABLED,
			QuestionnaireModelImpl.FINDER_CACHE_ENABLED,
			QuestionnaireImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(QuestionnaireModelImpl.ENTITY_CACHE_ENABLED,
			QuestionnaireModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_IDANDCLASS = new FinderPath(QuestionnaireModelImpl.ENTITY_CACHE_ENABLED,
			QuestionnaireModelImpl.FINDER_CACHE_ENABLED,
			QuestionnaireImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByIDAndClass",
			new String[] { Long.class.getName(), String.class.getName() },
			QuestionnaireModelImpl.ENTRYCLASSPK_COLUMN_BITMASK |
			QuestionnaireModelImpl.ENTRYCLASSNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDANDCLASS = new FinderPath(QuestionnaireModelImpl.ENTITY_CACHE_ENABLED,
			QuestionnaireModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIDAndClass",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the questionnaire where entryClassPK = &#63; and entryClassName = &#63; or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException} if it could not be found.
	 *
	 * @param entryClassPK the entry class p k
	 * @param entryClassName the entry class name
	 * @return the matching questionnaire
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException if a matching questionnaire could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Questionnaire findByIDAndClass(long entryClassPK,
		String entryClassName)
		throws NoSuchQuestionnaireException, SystemException {
		Questionnaire questionnaire = fetchByIDAndClass(entryClassPK,
				entryClassName);

		if (questionnaire == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("entryClassPK=");
			msg.append(entryClassPK);

			msg.append(", entryClassName=");
			msg.append(entryClassName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchQuestionnaireException(msg.toString());
		}

		return questionnaire;
	}

	/**
	 * Returns the questionnaire where entryClassPK = &#63; and entryClassName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param entryClassPK the entry class p k
	 * @param entryClassName the entry class name
	 * @return the matching questionnaire, or <code>null</code> if a matching questionnaire could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Questionnaire fetchByIDAndClass(long entryClassPK,
		String entryClassName) throws SystemException {
		return fetchByIDAndClass(entryClassPK, entryClassName, true);
	}

	/**
	 * Returns the questionnaire where entryClassPK = &#63; and entryClassName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param entryClassPK the entry class p k
	 * @param entryClassName the entry class name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching questionnaire, or <code>null</code> if a matching questionnaire could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Questionnaire fetchByIDAndClass(long entryClassPK,
		String entryClassName, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { entryClassPK, entryClassName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_IDANDCLASS,
					finderArgs, this);
		}

		if (result instanceof Questionnaire) {
			Questionnaire questionnaire = (Questionnaire)result;

			if ((entryClassPK != questionnaire.getEntryClassPK()) ||
					!Validator.equals(entryClassName,
						questionnaire.getEntryClassName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_QUESTIONNAIRE_WHERE);

			query.append(_FINDER_COLUMN_IDANDCLASS_ENTRYCLASSPK_2);

			boolean bindEntryClassName = false;

			if (entryClassName == null) {
				query.append(_FINDER_COLUMN_IDANDCLASS_ENTRYCLASSNAME_1);
			}
			else if (entryClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_IDANDCLASS_ENTRYCLASSNAME_3);
			}
			else {
				bindEntryClassName = true;

				query.append(_FINDER_COLUMN_IDANDCLASS_ENTRYCLASSNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entryClassPK);

				if (bindEntryClassName) {
					qPos.add(entryClassName);
				}

				List<Questionnaire> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDANDCLASS,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"QuestionnairePersistenceImpl.fetchByIDAndClass(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Questionnaire questionnaire = list.get(0);

					result = questionnaire;

					cacheResult(questionnaire);

					if ((questionnaire.getEntryClassPK() != entryClassPK) ||
							(questionnaire.getEntryClassName() == null) ||
							!questionnaire.getEntryClassName()
											  .equals(entryClassName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDANDCLASS,
							finderArgs, questionnaire);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDANDCLASS,
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
			return (Questionnaire)result;
		}
	}

	/**
	 * Removes the questionnaire where entryClassPK = &#63; and entryClassName = &#63; from the database.
	 *
	 * @param entryClassPK the entry class p k
	 * @param entryClassName the entry class name
	 * @return the questionnaire that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Questionnaire removeByIDAndClass(long entryClassPK,
		String entryClassName)
		throws NoSuchQuestionnaireException, SystemException {
		Questionnaire questionnaire = findByIDAndClass(entryClassPK,
				entryClassName);

		return remove(questionnaire);
	}

	/**
	 * Returns the number of questionnaires where entryClassPK = &#63; and entryClassName = &#63;.
	 *
	 * @param entryClassPK the entry class p k
	 * @param entryClassName the entry class name
	 * @return the number of matching questionnaires
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByIDAndClass(long entryClassPK, String entryClassName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IDANDCLASS;

		Object[] finderArgs = new Object[] { entryClassPK, entryClassName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_QUESTIONNAIRE_WHERE);

			query.append(_FINDER_COLUMN_IDANDCLASS_ENTRYCLASSPK_2);

			boolean bindEntryClassName = false;

			if (entryClassName == null) {
				query.append(_FINDER_COLUMN_IDANDCLASS_ENTRYCLASSNAME_1);
			}
			else if (entryClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_IDANDCLASS_ENTRYCLASSNAME_3);
			}
			else {
				bindEntryClassName = true;

				query.append(_FINDER_COLUMN_IDANDCLASS_ENTRYCLASSNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entryClassPK);

				if (bindEntryClassName) {
					qPos.add(entryClassName);
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

	private static final String _FINDER_COLUMN_IDANDCLASS_ENTRYCLASSPK_2 = "questionnaire.entryClassPK = ? AND ";
	private static final String _FINDER_COLUMN_IDANDCLASS_ENTRYCLASSNAME_1 = "questionnaire.entryClassName IS NULL";
	private static final String _FINDER_COLUMN_IDANDCLASS_ENTRYCLASSNAME_2 = "questionnaire.entryClassName = ?";
	private static final String _FINDER_COLUMN_IDANDCLASS_ENTRYCLASSNAME_3 = "(questionnaire.entryClassName IS NULL OR questionnaire.entryClassName = '')";

	public QuestionnairePersistenceImpl() {
		setModelClass(Questionnaire.class);
	}

	/**
	 * Caches the questionnaire in the entity cache if it is enabled.
	 *
	 * @param questionnaire the questionnaire
	 */
	@Override
	public void cacheResult(Questionnaire questionnaire) {
		EntityCacheUtil.putResult(QuestionnaireModelImpl.ENTITY_CACHE_ENABLED,
			QuestionnaireImpl.class, questionnaire.getPrimaryKey(),
			questionnaire);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDANDCLASS,
			new Object[] {
				questionnaire.getEntryClassPK(),
				questionnaire.getEntryClassName()
			}, questionnaire);

		questionnaire.resetOriginalValues();
	}

	/**
	 * Caches the questionnaires in the entity cache if it is enabled.
	 *
	 * @param questionnaires the questionnaires
	 */
	@Override
	public void cacheResult(List<Questionnaire> questionnaires) {
		for (Questionnaire questionnaire : questionnaires) {
			if (EntityCacheUtil.getResult(
						QuestionnaireModelImpl.ENTITY_CACHE_ENABLED,
						QuestionnaireImpl.class, questionnaire.getPrimaryKey()) == null) {
				cacheResult(questionnaire);
			}
			else {
				questionnaire.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all questionnaires.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(QuestionnaireImpl.class.getName());
		}

		EntityCacheUtil.clearCache(QuestionnaireImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the questionnaire.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Questionnaire questionnaire) {
		EntityCacheUtil.removeResult(QuestionnaireModelImpl.ENTITY_CACHE_ENABLED,
			QuestionnaireImpl.class, questionnaire.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(questionnaire);
	}

	@Override
	public void clearCache(List<Questionnaire> questionnaires) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Questionnaire questionnaire : questionnaires) {
			EntityCacheUtil.removeResult(QuestionnaireModelImpl.ENTITY_CACHE_ENABLED,
				QuestionnaireImpl.class, questionnaire.getPrimaryKey());

			clearUniqueFindersCache(questionnaire);
		}
	}

	protected void cacheUniqueFindersCache(Questionnaire questionnaire) {
		if (questionnaire.isNew()) {
			Object[] args = new Object[] {
					questionnaire.getEntryClassPK(),
					questionnaire.getEntryClassName()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IDANDCLASS, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDANDCLASS, args,
				questionnaire);
		}
		else {
			QuestionnaireModelImpl questionnaireModelImpl = (QuestionnaireModelImpl)questionnaire;

			if ((questionnaireModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_IDANDCLASS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						questionnaire.getEntryClassPK(),
						questionnaire.getEntryClassName()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IDANDCLASS,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDANDCLASS,
					args, questionnaire);
			}
		}
	}

	protected void clearUniqueFindersCache(Questionnaire questionnaire) {
		QuestionnaireModelImpl questionnaireModelImpl = (QuestionnaireModelImpl)questionnaire;

		Object[] args = new Object[] {
				questionnaire.getEntryClassPK(),
				questionnaire.getEntryClassName()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDANDCLASS, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDANDCLASS, args);

		if ((questionnaireModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_IDANDCLASS.getColumnBitmask()) != 0) {
			args = new Object[] {
					questionnaireModelImpl.getOriginalEntryClassPK(),
					questionnaireModelImpl.getOriginalEntryClassName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDANDCLASS, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDANDCLASS, args);
		}
	}

	/**
	 * Creates a new questionnaire with the primary key. Does not add the questionnaire to the database.
	 *
	 * @param questionnaireId the primary key for the new questionnaire
	 * @return the new questionnaire
	 */
	@Override
	public Questionnaire create(long questionnaireId) {
		Questionnaire questionnaire = new QuestionnaireImpl();

		questionnaire.setNew(true);
		questionnaire.setPrimaryKey(questionnaireId);

		return questionnaire;
	}

	/**
	 * Removes the questionnaire with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param questionnaireId the primary key of the questionnaire
	 * @return the questionnaire that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException if a questionnaire with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Questionnaire remove(long questionnaireId)
		throws NoSuchQuestionnaireException, SystemException {
		return remove((Serializable)questionnaireId);
	}

	/**
	 * Removes the questionnaire with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the questionnaire
	 * @return the questionnaire that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException if a questionnaire with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Questionnaire remove(Serializable primaryKey)
		throws NoSuchQuestionnaireException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Questionnaire questionnaire = (Questionnaire)session.get(QuestionnaireImpl.class,
					primaryKey);

			if (questionnaire == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuestionnaireException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(questionnaire);
		}
		catch (NoSuchQuestionnaireException nsee) {
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
	protected Questionnaire removeImpl(Questionnaire questionnaire)
		throws SystemException {
		questionnaire = toUnwrappedModel(questionnaire);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(questionnaire)) {
				questionnaire = (Questionnaire)session.get(QuestionnaireImpl.class,
						questionnaire.getPrimaryKeyObj());
			}

			if (questionnaire != null) {
				session.delete(questionnaire);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (questionnaire != null) {
			clearCache(questionnaire);
		}

		return questionnaire;
	}

	@Override
	public Questionnaire updateImpl(
		com.sambaash.platform.srv.startupprofile.model.Questionnaire questionnaire)
		throws SystemException {
		questionnaire = toUnwrappedModel(questionnaire);

		boolean isNew = questionnaire.isNew();

		Session session = null;

		try {
			session = openSession();

			if (questionnaire.isNew()) {
				session.save(questionnaire);

				questionnaire.setNew(false);
			}
			else {
				session.merge(questionnaire);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !QuestionnaireModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(QuestionnaireModelImpl.ENTITY_CACHE_ENABLED,
			QuestionnaireImpl.class, questionnaire.getPrimaryKey(),
			questionnaire);

		clearUniqueFindersCache(questionnaire);
		cacheUniqueFindersCache(questionnaire);

		return questionnaire;
	}

	protected Questionnaire toUnwrappedModel(Questionnaire questionnaire) {
		if (questionnaire instanceof QuestionnaireImpl) {
			return questionnaire;
		}

		QuestionnaireImpl questionnaireImpl = new QuestionnaireImpl();

		questionnaireImpl.setNew(questionnaire.isNew());
		questionnaireImpl.setPrimaryKey(questionnaire.getPrimaryKey());

		questionnaireImpl.setQuestionnaireId(questionnaire.getQuestionnaireId());
		questionnaireImpl.setEntryClassPK(questionnaire.getEntryClassPK());
		questionnaireImpl.setEntryClassName(questionnaire.getEntryClassName());
		questionnaireImpl.setAnswer1(questionnaire.getAnswer1());
		questionnaireImpl.setAnswer2(questionnaire.getAnswer2());
		questionnaireImpl.setAnswer3(questionnaire.getAnswer3());
		questionnaireImpl.setAnswer4(questionnaire.getAnswer4());
		questionnaireImpl.setAnswer5(questionnaire.getAnswer5());
		questionnaireImpl.setAnswer6(questionnaire.getAnswer6());
		questionnaireImpl.setAnswer7(questionnaire.getAnswer7());
		questionnaireImpl.setAnswer8(questionnaire.getAnswer8());
		questionnaireImpl.setAnswer9(questionnaire.getAnswer9());
		questionnaireImpl.setAnswer10(questionnaire.getAnswer10());
		questionnaireImpl.setGroupId(questionnaire.getGroupId());
		questionnaireImpl.setCompanyId(questionnaire.getCompanyId());
		questionnaireImpl.setUserId(questionnaire.getUserId());
		questionnaireImpl.setUserName(questionnaire.getUserName());
		questionnaireImpl.setCreateDate(questionnaire.getCreateDate());
		questionnaireImpl.setModifiedDate(questionnaire.getModifiedDate());

		return questionnaireImpl;
	}

	/**
	 * Returns the questionnaire with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the questionnaire
	 * @return the questionnaire
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException if a questionnaire with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Questionnaire findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQuestionnaireException, SystemException {
		Questionnaire questionnaire = fetchByPrimaryKey(primaryKey);

		if (questionnaire == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQuestionnaireException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return questionnaire;
	}

	/**
	 * Returns the questionnaire with the primary key or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException} if it could not be found.
	 *
	 * @param questionnaireId the primary key of the questionnaire
	 * @return the questionnaire
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchQuestionnaireException if a questionnaire with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Questionnaire findByPrimaryKey(long questionnaireId)
		throws NoSuchQuestionnaireException, SystemException {
		return findByPrimaryKey((Serializable)questionnaireId);
	}

	/**
	 * Returns the questionnaire with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the questionnaire
	 * @return the questionnaire, or <code>null</code> if a questionnaire with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Questionnaire fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Questionnaire questionnaire = (Questionnaire)EntityCacheUtil.getResult(QuestionnaireModelImpl.ENTITY_CACHE_ENABLED,
				QuestionnaireImpl.class, primaryKey);

		if (questionnaire == _nullQuestionnaire) {
			return null;
		}

		if (questionnaire == null) {
			Session session = null;

			try {
				session = openSession();

				questionnaire = (Questionnaire)session.get(QuestionnaireImpl.class,
						primaryKey);

				if (questionnaire != null) {
					cacheResult(questionnaire);
				}
				else {
					EntityCacheUtil.putResult(QuestionnaireModelImpl.ENTITY_CACHE_ENABLED,
						QuestionnaireImpl.class, primaryKey, _nullQuestionnaire);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(QuestionnaireModelImpl.ENTITY_CACHE_ENABLED,
					QuestionnaireImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return questionnaire;
	}

	/**
	 * Returns the questionnaire with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param questionnaireId the primary key of the questionnaire
	 * @return the questionnaire, or <code>null</code> if a questionnaire with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Questionnaire fetchByPrimaryKey(long questionnaireId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)questionnaireId);
	}

	/**
	 * Returns all the questionnaires.
	 *
	 * @return the questionnaires
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Questionnaire> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the questionnaires.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.QuestionnaireModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of questionnaires
	 * @param end the upper bound of the range of questionnaires (not inclusive)
	 * @return the range of questionnaires
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Questionnaire> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the questionnaires.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.QuestionnaireModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of questionnaires
	 * @param end the upper bound of the range of questionnaires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of questionnaires
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Questionnaire> findAll(int start, int end,
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

		List<Questionnaire> list = (List<Questionnaire>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_QUESTIONNAIRE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_QUESTIONNAIRE;

				if (pagination) {
					sql = sql.concat(QuestionnaireModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Questionnaire>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Questionnaire>(list);
				}
				else {
					list = (List<Questionnaire>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the questionnaires from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Questionnaire questionnaire : findAll()) {
			remove(questionnaire);
		}
	}

	/**
	 * Returns the number of questionnaires.
	 *
	 * @return the number of questionnaires
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

				Query q = session.createQuery(_SQL_COUNT_QUESTIONNAIRE);

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
	 * Initializes the questionnaire persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.startupprofile.model.Questionnaire")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Questionnaire>> listenersList = new ArrayList<ModelListener<Questionnaire>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Questionnaire>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(QuestionnaireImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_QUESTIONNAIRE = "SELECT questionnaire FROM Questionnaire questionnaire";
	private static final String _SQL_SELECT_QUESTIONNAIRE_WHERE = "SELECT questionnaire FROM Questionnaire questionnaire WHERE ";
	private static final String _SQL_COUNT_QUESTIONNAIRE = "SELECT COUNT(questionnaire) FROM Questionnaire questionnaire";
	private static final String _SQL_COUNT_QUESTIONNAIRE_WHERE = "SELECT COUNT(questionnaire) FROM Questionnaire questionnaire WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "questionnaire.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Questionnaire exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Questionnaire exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(QuestionnairePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"questionnaireId"
			});
	private static Questionnaire _nullQuestionnaire = new QuestionnaireImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Questionnaire> toCacheModel() {
				return _nullQuestionnaireCacheModel;
			}
		};

	private static CacheModel<Questionnaire> _nullQuestionnaireCacheModel = new CacheModel<Questionnaire>() {
			@Override
			public Questionnaire toEntityModel() {
				return _nullQuestionnaire;
			}
		};
}