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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException;
import com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser;
import com.sambaash.platform.srv.spsocialprofile.model.impl.ExamBodyUserImpl;
import com.sambaash.platform.srv.spsocialprofile.model.impl.ExamBodyUserModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the exam body user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see ExamBodyUserPersistence
 * @see ExamBodyUserUtil
 * @generated
 */
public class ExamBodyUserPersistenceImpl extends BasePersistenceImpl<ExamBodyUser>
	implements ExamBodyUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ExamBodyUserUtil} to access the exam body user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ExamBodyUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ExamBodyUserModelImpl.ENTITY_CACHE_ENABLED,
			ExamBodyUserModelImpl.FINDER_CACHE_ENABLED, ExamBodyUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ExamBodyUserModelImpl.ENTITY_CACHE_ENABLED,
			ExamBodyUserModelImpl.FINDER_CACHE_ENABLED, ExamBodyUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ExamBodyUserModelImpl.ENTITY_CACHE_ENABLED,
			ExamBodyUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMAILADDRESSANDEXAMBODY = new FinderPath(ExamBodyUserModelImpl.ENTITY_CACHE_ENABLED,
			ExamBodyUserModelImpl.FINDER_CACHE_ENABLED, ExamBodyUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByEmailAddressAndExamBody",
			new String[] { String.class.getName(), String.class.getName() },
			ExamBodyUserModelImpl.EMAILADDRESS_COLUMN_BITMASK |
			ExamBodyUserModelImpl.EXAMBODY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILADDRESSANDEXAMBODY = new FinderPath(ExamBodyUserModelImpl.ENTITY_CACHE_ENABLED,
			ExamBodyUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEmailAddressAndExamBody",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the exam body user where emailAddress = &#63; and examBody = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException} if it could not be found.
	 *
	 * @param emailAddress the email address
	 * @param examBody the exam body
	 * @return the matching exam body user
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException if a matching exam body user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExamBodyUser findByEmailAddressAndExamBody(String emailAddress,
		String examBody) throws NoSuchExamBodyUserException, SystemException {
		ExamBodyUser examBodyUser = fetchByEmailAddressAndExamBody(emailAddress,
				examBody);

		if (examBodyUser == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("emailAddress=");
			msg.append(emailAddress);

			msg.append(", examBody=");
			msg.append(examBody);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchExamBodyUserException(msg.toString());
		}

		return examBodyUser;
	}

	/**
	 * Returns the exam body user where emailAddress = &#63; and examBody = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param emailAddress the email address
	 * @param examBody the exam body
	 * @return the matching exam body user, or <code>null</code> if a matching exam body user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExamBodyUser fetchByEmailAddressAndExamBody(String emailAddress,
		String examBody) throws SystemException {
		return fetchByEmailAddressAndExamBody(emailAddress, examBody, true);
	}

	/**
	 * Returns the exam body user where emailAddress = &#63; and examBody = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param emailAddress the email address
	 * @param examBody the exam body
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching exam body user, or <code>null</code> if a matching exam body user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExamBodyUser fetchByEmailAddressAndExamBody(String emailAddress,
		String examBody, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { emailAddress, examBody };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMAILADDRESSANDEXAMBODY,
					finderArgs, this);
		}

		if (result instanceof ExamBodyUser) {
			ExamBodyUser examBodyUser = (ExamBodyUser)result;

			if (!Validator.equals(emailAddress, examBodyUser.getEmailAddress()) ||
					!Validator.equals(examBody, examBodyUser.getExamBody())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EXAMBODYUSER_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_EMAILADDRESSANDEXAMBODY_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILADDRESSANDEXAMBODY_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAILADDRESSANDEXAMBODY_EMAILADDRESS_2);
			}

			boolean bindExamBody = false;

			if (examBody == null) {
				query.append(_FINDER_COLUMN_EMAILADDRESSANDEXAMBODY_EXAMBODY_1);
			}
			else if (examBody.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILADDRESSANDEXAMBODY_EXAMBODY_3);
			}
			else {
				bindExamBody = true;

				query.append(_FINDER_COLUMN_EMAILADDRESSANDEXAMBODY_EXAMBODY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
				}

				if (bindExamBody) {
					qPos.add(examBody);
				}

				List<ExamBodyUser> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESSANDEXAMBODY,
						finderArgs, list);
				}
				else {
					ExamBodyUser examBodyUser = list.get(0);

					result = examBodyUser;

					cacheResult(examBodyUser);

					if ((examBodyUser.getEmailAddress() == null) ||
							!examBodyUser.getEmailAddress().equals(emailAddress) ||
							(examBodyUser.getExamBody() == null) ||
							!examBodyUser.getExamBody().equals(examBody)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESSANDEXAMBODY,
							finderArgs, examBodyUser);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILADDRESSANDEXAMBODY,
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
			return (ExamBodyUser)result;
		}
	}

	/**
	 * Removes the exam body user where emailAddress = &#63; and examBody = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 * @param examBody the exam body
	 * @return the exam body user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExamBodyUser removeByEmailAddressAndExamBody(String emailAddress,
		String examBody) throws NoSuchExamBodyUserException, SystemException {
		ExamBodyUser examBodyUser = findByEmailAddressAndExamBody(emailAddress,
				examBody);

		return remove(examBodyUser);
	}

	/**
	 * Returns the number of exam body users where emailAddress = &#63; and examBody = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param examBody the exam body
	 * @return the number of matching exam body users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmailAddressAndExamBody(String emailAddress,
		String examBody) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAILADDRESSANDEXAMBODY;

		Object[] finderArgs = new Object[] { emailAddress, examBody };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EXAMBODYUSER_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_EMAILADDRESSANDEXAMBODY_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILADDRESSANDEXAMBODY_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAILADDRESSANDEXAMBODY_EMAILADDRESS_2);
			}

			boolean bindExamBody = false;

			if (examBody == null) {
				query.append(_FINDER_COLUMN_EMAILADDRESSANDEXAMBODY_EXAMBODY_1);
			}
			else if (examBody.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILADDRESSANDEXAMBODY_EXAMBODY_3);
			}
			else {
				bindExamBody = true;

				query.append(_FINDER_COLUMN_EMAILADDRESSANDEXAMBODY_EXAMBODY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
				}

				if (bindExamBody) {
					qPos.add(examBody);
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

	private static final String _FINDER_COLUMN_EMAILADDRESSANDEXAMBODY_EMAILADDRESS_1 =
		"examBodyUser.emailAddress IS NULL AND ";
	private static final String _FINDER_COLUMN_EMAILADDRESSANDEXAMBODY_EMAILADDRESS_2 =
		"examBodyUser.emailAddress = ? AND ";
	private static final String _FINDER_COLUMN_EMAILADDRESSANDEXAMBODY_EMAILADDRESS_3 =
		"(examBodyUser.emailAddress IS NULL OR examBodyUser.emailAddress = '') AND ";
	private static final String _FINDER_COLUMN_EMAILADDRESSANDEXAMBODY_EXAMBODY_1 =
		"examBodyUser.examBody IS NULL";
	private static final String _FINDER_COLUMN_EMAILADDRESSANDEXAMBODY_EXAMBODY_2 =
		"examBodyUser.examBody = ?";
	private static final String _FINDER_COLUMN_EMAILADDRESSANDEXAMBODY_EXAMBODY_3 =
		"(examBodyUser.examBody IS NULL OR examBodyUser.examBody = '')";

	public ExamBodyUserPersistenceImpl() {
		setModelClass(ExamBodyUser.class);
	}

	/**
	 * Caches the exam body user in the entity cache if it is enabled.
	 *
	 * @param examBodyUser the exam body user
	 */
	@Override
	public void cacheResult(ExamBodyUser examBodyUser) {
		EntityCacheUtil.putResult(ExamBodyUserModelImpl.ENTITY_CACHE_ENABLED,
			ExamBodyUserImpl.class, examBodyUser.getPrimaryKey(), examBodyUser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESSANDEXAMBODY,
			new Object[] {
				examBodyUser.getEmailAddress(), examBodyUser.getExamBody()
			}, examBodyUser);

		examBodyUser.resetOriginalValues();
	}

	/**
	 * Caches the exam body users in the entity cache if it is enabled.
	 *
	 * @param examBodyUsers the exam body users
	 */
	@Override
	public void cacheResult(List<ExamBodyUser> examBodyUsers) {
		for (ExamBodyUser examBodyUser : examBodyUsers) {
			if (EntityCacheUtil.getResult(
						ExamBodyUserModelImpl.ENTITY_CACHE_ENABLED,
						ExamBodyUserImpl.class, examBodyUser.getPrimaryKey()) == null) {
				cacheResult(examBodyUser);
			}
			else {
				examBodyUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all exam body users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ExamBodyUserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ExamBodyUserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the exam body user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ExamBodyUser examBodyUser) {
		EntityCacheUtil.removeResult(ExamBodyUserModelImpl.ENTITY_CACHE_ENABLED,
			ExamBodyUserImpl.class, examBodyUser.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(examBodyUser);
	}

	@Override
	public void clearCache(List<ExamBodyUser> examBodyUsers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ExamBodyUser examBodyUser : examBodyUsers) {
			EntityCacheUtil.removeResult(ExamBodyUserModelImpl.ENTITY_CACHE_ENABLED,
				ExamBodyUserImpl.class, examBodyUser.getPrimaryKey());

			clearUniqueFindersCache(examBodyUser);
		}
	}

	protected void cacheUniqueFindersCache(ExamBodyUser examBodyUser) {
		if (examBodyUser.isNew()) {
			Object[] args = new Object[] {
					examBodyUser.getEmailAddress(), examBodyUser.getExamBody()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILADDRESSANDEXAMBODY,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESSANDEXAMBODY,
				args, examBodyUser);
		}
		else {
			ExamBodyUserModelImpl examBodyUserModelImpl = (ExamBodyUserModelImpl)examBodyUser;

			if ((examBodyUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMAILADDRESSANDEXAMBODY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						examBodyUser.getEmailAddress(),
						examBodyUser.getExamBody()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILADDRESSANDEXAMBODY,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESSANDEXAMBODY,
					args, examBodyUser);
			}
		}
	}

	protected void clearUniqueFindersCache(ExamBodyUser examBodyUser) {
		ExamBodyUserModelImpl examBodyUserModelImpl = (ExamBodyUserModelImpl)examBodyUser;

		Object[] args = new Object[] {
				examBodyUser.getEmailAddress(), examBodyUser.getExamBody()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESSANDEXAMBODY,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILADDRESSANDEXAMBODY,
			args);

		if ((examBodyUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMAILADDRESSANDEXAMBODY.getColumnBitmask()) != 0) {
			args = new Object[] {
					examBodyUserModelImpl.getOriginalEmailAddress(),
					examBodyUserModelImpl.getOriginalExamBody()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESSANDEXAMBODY,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILADDRESSANDEXAMBODY,
				args);
		}
	}

	/**
	 * Creates a new exam body user with the primary key. Does not add the exam body user to the database.
	 *
	 * @param examBodyUserId the primary key for the new exam body user
	 * @return the new exam body user
	 */
	@Override
	public ExamBodyUser create(long examBodyUserId) {
		ExamBodyUser examBodyUser = new ExamBodyUserImpl();

		examBodyUser.setNew(true);
		examBodyUser.setPrimaryKey(examBodyUserId);

		return examBodyUser;
	}

	/**
	 * Removes the exam body user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param examBodyUserId the primary key of the exam body user
	 * @return the exam body user that was removed
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException if a exam body user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExamBodyUser remove(long examBodyUserId)
		throws NoSuchExamBodyUserException, SystemException {
		return remove((Serializable)examBodyUserId);
	}

	/**
	 * Removes the exam body user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the exam body user
	 * @return the exam body user that was removed
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException if a exam body user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExamBodyUser remove(Serializable primaryKey)
		throws NoSuchExamBodyUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ExamBodyUser examBodyUser = (ExamBodyUser)session.get(ExamBodyUserImpl.class,
					primaryKey);

			if (examBodyUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExamBodyUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(examBodyUser);
		}
		catch (NoSuchExamBodyUserException nsee) {
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
	protected ExamBodyUser removeImpl(ExamBodyUser examBodyUser)
		throws SystemException {
		examBodyUser = toUnwrappedModel(examBodyUser);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(examBodyUser)) {
				examBodyUser = (ExamBodyUser)session.get(ExamBodyUserImpl.class,
						examBodyUser.getPrimaryKeyObj());
			}

			if (examBodyUser != null) {
				session.delete(examBodyUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (examBodyUser != null) {
			clearCache(examBodyUser);
		}

		return examBodyUser;
	}

	@Override
	public ExamBodyUser updateImpl(
		com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser examBodyUser)
		throws SystemException {
		examBodyUser = toUnwrappedModel(examBodyUser);

		boolean isNew = examBodyUser.isNew();

		Session session = null;

		try {
			session = openSession();

			if (examBodyUser.isNew()) {
				session.save(examBodyUser);

				examBodyUser.setNew(false);
			}
			else {
				session.merge(examBodyUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ExamBodyUserModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(ExamBodyUserModelImpl.ENTITY_CACHE_ENABLED,
			ExamBodyUserImpl.class, examBodyUser.getPrimaryKey(), examBodyUser);

		clearUniqueFindersCache(examBodyUser);
		cacheUniqueFindersCache(examBodyUser);

		return examBodyUser;
	}

	protected ExamBodyUser toUnwrappedModel(ExamBodyUser examBodyUser) {
		if (examBodyUser instanceof ExamBodyUserImpl) {
			return examBodyUser;
		}

		ExamBodyUserImpl examBodyUserImpl = new ExamBodyUserImpl();

		examBodyUserImpl.setNew(examBodyUser.isNew());
		examBodyUserImpl.setPrimaryKey(examBodyUser.getPrimaryKey());

		examBodyUserImpl.setExamBodyUserId(examBodyUser.getExamBodyUserId());
		examBodyUserImpl.setGroupId(examBodyUser.getGroupId());
		examBodyUserImpl.setCompanyId(examBodyUser.getCompanyId());
		examBodyUserImpl.setCreateDate(examBodyUser.getCreateDate());
		examBodyUserImpl.setModifiedDate(examBodyUser.getModifiedDate());
		examBodyUserImpl.setEmailAddress(examBodyUser.getEmailAddress());
		examBodyUserImpl.setExamBody(examBodyUser.getExamBody());
		examBodyUserImpl.setActive(examBodyUser.isActive());

		return examBodyUserImpl;
	}

	/**
	 * Returns the exam body user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the exam body user
	 * @return the exam body user
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException if a exam body user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExamBodyUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExamBodyUserException, SystemException {
		ExamBodyUser examBodyUser = fetchByPrimaryKey(primaryKey);

		if (examBodyUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExamBodyUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return examBodyUser;
	}

	/**
	 * Returns the exam body user with the primary key or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException} if it could not be found.
	 *
	 * @param examBodyUserId the primary key of the exam body user
	 * @return the exam body user
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException if a exam body user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExamBodyUser findByPrimaryKey(long examBodyUserId)
		throws NoSuchExamBodyUserException, SystemException {
		return findByPrimaryKey((Serializable)examBodyUserId);
	}

	/**
	 * Returns the exam body user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the exam body user
	 * @return the exam body user, or <code>null</code> if a exam body user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExamBodyUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ExamBodyUser examBodyUser = (ExamBodyUser)EntityCacheUtil.getResult(ExamBodyUserModelImpl.ENTITY_CACHE_ENABLED,
				ExamBodyUserImpl.class, primaryKey);

		if (examBodyUser == _nullExamBodyUser) {
			return null;
		}

		if (examBodyUser == null) {
			Session session = null;

			try {
				session = openSession();

				examBodyUser = (ExamBodyUser)session.get(ExamBodyUserImpl.class,
						primaryKey);

				if (examBodyUser != null) {
					cacheResult(examBodyUser);
				}
				else {
					EntityCacheUtil.putResult(ExamBodyUserModelImpl.ENTITY_CACHE_ENABLED,
						ExamBodyUserImpl.class, primaryKey, _nullExamBodyUser);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ExamBodyUserModelImpl.ENTITY_CACHE_ENABLED,
					ExamBodyUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return examBodyUser;
	}

	/**
	 * Returns the exam body user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param examBodyUserId the primary key of the exam body user
	 * @return the exam body user, or <code>null</code> if a exam body user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExamBodyUser fetchByPrimaryKey(long examBodyUserId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)examBodyUserId);
	}

	/**
	 * Returns all the exam body users.
	 *
	 * @return the exam body users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExamBodyUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the exam body users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.ExamBodyUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of exam body users
	 * @param end the upper bound of the range of exam body users (not inclusive)
	 * @return the range of exam body users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExamBodyUser> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the exam body users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.ExamBodyUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of exam body users
	 * @param end the upper bound of the range of exam body users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of exam body users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExamBodyUser> findAll(int start, int end,
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

		List<ExamBodyUser> list = (List<ExamBodyUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EXAMBODYUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EXAMBODYUSER;

				if (pagination) {
					sql = sql.concat(ExamBodyUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ExamBodyUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ExamBodyUser>(list);
				}
				else {
					list = (List<ExamBodyUser>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the exam body users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ExamBodyUser examBodyUser : findAll()) {
			remove(examBodyUser);
		}
	}

	/**
	 * Returns the number of exam body users.
	 *
	 * @return the number of exam body users
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

				Query q = session.createQuery(_SQL_COUNT_EXAMBODYUSER);

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
	 * Initializes the exam body user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ExamBodyUser>> listenersList = new ArrayList<ModelListener<ExamBodyUser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ExamBodyUser>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ExamBodyUserImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EXAMBODYUSER = "SELECT examBodyUser FROM ExamBodyUser examBodyUser";
	private static final String _SQL_SELECT_EXAMBODYUSER_WHERE = "SELECT examBodyUser FROM ExamBodyUser examBodyUser WHERE ";
	private static final String _SQL_COUNT_EXAMBODYUSER = "SELECT COUNT(examBodyUser) FROM ExamBodyUser examBodyUser";
	private static final String _SQL_COUNT_EXAMBODYUSER_WHERE = "SELECT COUNT(examBodyUser) FROM ExamBodyUser examBodyUser WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "examBodyUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ExamBodyUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ExamBodyUser exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ExamBodyUserPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active"
			});
	private static ExamBodyUser _nullExamBodyUser = new ExamBodyUserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ExamBodyUser> toCacheModel() {
				return _nullExamBodyUserCacheModel;
			}
		};

	private static CacheModel<ExamBodyUser> _nullExamBodyUserCacheModel = new CacheModel<ExamBodyUser>() {
			@Override
			public ExamBodyUser toEntityModel() {
				return _nullExamBodyUser;
			}
		};
}