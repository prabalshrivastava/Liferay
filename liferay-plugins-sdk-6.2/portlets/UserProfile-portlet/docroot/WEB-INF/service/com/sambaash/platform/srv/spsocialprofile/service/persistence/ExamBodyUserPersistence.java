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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser;

/**
 * The persistence interface for the exam body user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see ExamBodyUserPersistenceImpl
 * @see ExamBodyUserUtil
 * @generated
 */
public interface ExamBodyUserPersistence extends BasePersistence<ExamBodyUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExamBodyUserUtil} to access the exam body user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the exam body user where emailAddress = &#63; and examBody = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException} if it could not be found.
	*
	* @param emailAddress the email address
	* @param examBody the exam body
	* @return the matching exam body user
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException if a matching exam body user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser findByEmailAddressAndExamBody(
		java.lang.String emailAddress, java.lang.String examBody)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException;

	/**
	* Returns the exam body user where emailAddress = &#63; and examBody = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param emailAddress the email address
	* @param examBody the exam body
	* @return the matching exam body user, or <code>null</code> if a matching exam body user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser fetchByEmailAddressAndExamBody(
		java.lang.String emailAddress, java.lang.String examBody)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the exam body user where emailAddress = &#63; and examBody = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param emailAddress the email address
	* @param examBody the exam body
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching exam body user, or <code>null</code> if a matching exam body user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser fetchByEmailAddressAndExamBody(
		java.lang.String emailAddress, java.lang.String examBody,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the exam body user where emailAddress = &#63; and examBody = &#63; from the database.
	*
	* @param emailAddress the email address
	* @param examBody the exam body
	* @return the exam body user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser removeByEmailAddressAndExamBody(
		java.lang.String emailAddress, java.lang.String examBody)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException;

	/**
	* Returns the number of exam body users where emailAddress = &#63; and examBody = &#63;.
	*
	* @param emailAddress the email address
	* @param examBody the exam body
	* @return the number of matching exam body users
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmailAddressAndExamBody(java.lang.String emailAddress,
		java.lang.String examBody)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the exam body user in the entity cache if it is enabled.
	*
	* @param examBodyUser the exam body user
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser examBodyUser);

	/**
	* Caches the exam body users in the entity cache if it is enabled.
	*
	* @param examBodyUsers the exam body users
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser> examBodyUsers);

	/**
	* Creates a new exam body user with the primary key. Does not add the exam body user to the database.
	*
	* @param examBodyUserId the primary key for the new exam body user
	* @return the new exam body user
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser create(
		long examBodyUserId);

	/**
	* Removes the exam body user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param examBodyUserId the primary key of the exam body user
	* @return the exam body user that was removed
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException if a exam body user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser remove(
		long examBodyUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException;

	public com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser updateImpl(
		com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser examBodyUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the exam body user with the primary key or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException} if it could not be found.
	*
	* @param examBodyUserId the primary key of the exam body user
	* @return the exam body user
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException if a exam body user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser findByPrimaryKey(
		long examBodyUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException;

	/**
	* Returns the exam body user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param examBodyUserId the primary key of the exam body user
	* @return the exam body user, or <code>null</code> if a exam body user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser fetchByPrimaryKey(
		long examBodyUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the exam body users.
	*
	* @return the exam body users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the exam body users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of exam body users.
	*
	* @return the number of exam body users
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}