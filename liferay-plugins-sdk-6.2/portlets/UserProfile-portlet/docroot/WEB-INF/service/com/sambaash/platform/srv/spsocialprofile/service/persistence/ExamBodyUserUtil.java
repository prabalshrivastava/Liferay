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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser;

import java.util.List;

/**
 * The persistence utility for the exam body user service. This utility wraps {@link ExamBodyUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see ExamBodyUserPersistence
 * @see ExamBodyUserPersistenceImpl
 * @generated
 */
public class ExamBodyUserUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ExamBodyUser examBodyUser) {
		getPersistence().clearCache(examBodyUser);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ExamBodyUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ExamBodyUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ExamBodyUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ExamBodyUser update(ExamBodyUser examBodyUser)
		throws SystemException {
		return getPersistence().update(examBodyUser);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ExamBodyUser update(ExamBodyUser examBodyUser,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(examBodyUser, serviceContext);
	}

	/**
	* Returns the exam body user where emailAddress = &#63; and examBody = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException} if it could not be found.
	*
	* @param emailAddress the email address
	* @param examBody the exam body
	* @return the matching exam body user
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException if a matching exam body user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser findByEmailAddressAndExamBody(
		java.lang.String emailAddress, java.lang.String examBody)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException {
		return getPersistence()
				   .findByEmailAddressAndExamBody(emailAddress, examBody);
	}

	/**
	* Returns the exam body user where emailAddress = &#63; and examBody = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param emailAddress the email address
	* @param examBody the exam body
	* @return the matching exam body user, or <code>null</code> if a matching exam body user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser fetchByEmailAddressAndExamBody(
		java.lang.String emailAddress, java.lang.String examBody)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmailAddressAndExamBody(emailAddress, examBody);
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
	public static com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser fetchByEmailAddressAndExamBody(
		java.lang.String emailAddress, java.lang.String examBody,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmailAddressAndExamBody(emailAddress, examBody,
			retrieveFromCache);
	}

	/**
	* Removes the exam body user where emailAddress = &#63; and examBody = &#63; from the database.
	*
	* @param emailAddress the email address
	* @param examBody the exam body
	* @return the exam body user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser removeByEmailAddressAndExamBody(
		java.lang.String emailAddress, java.lang.String examBody)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException {
		return getPersistence()
				   .removeByEmailAddressAndExamBody(emailAddress, examBody);
	}

	/**
	* Returns the number of exam body users where emailAddress = &#63; and examBody = &#63;.
	*
	* @param emailAddress the email address
	* @param examBody the exam body
	* @return the number of matching exam body users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmailAddressAndExamBody(
		java.lang.String emailAddress, java.lang.String examBody)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByEmailAddressAndExamBody(emailAddress, examBody);
	}

	/**
	* Caches the exam body user in the entity cache if it is enabled.
	*
	* @param examBodyUser the exam body user
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser examBodyUser) {
		getPersistence().cacheResult(examBodyUser);
	}

	/**
	* Caches the exam body users in the entity cache if it is enabled.
	*
	* @param examBodyUsers the exam body users
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser> examBodyUsers) {
		getPersistence().cacheResult(examBodyUsers);
	}

	/**
	* Creates a new exam body user with the primary key. Does not add the exam body user to the database.
	*
	* @param examBodyUserId the primary key for the new exam body user
	* @return the new exam body user
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser create(
		long examBodyUserId) {
		return getPersistence().create(examBodyUserId);
	}

	/**
	* Removes the exam body user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param examBodyUserId the primary key of the exam body user
	* @return the exam body user that was removed
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException if a exam body user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser remove(
		long examBodyUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException {
		return getPersistence().remove(examBodyUserId);
	}

	public static com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser updateImpl(
		com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser examBodyUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(examBodyUser);
	}

	/**
	* Returns the exam body user with the primary key or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException} if it could not be found.
	*
	* @param examBodyUserId the primary key of the exam body user
	* @return the exam body user
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException if a exam body user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser findByPrimaryKey(
		long examBodyUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchExamBodyUserException {
		return getPersistence().findByPrimaryKey(examBodyUserId);
	}

	/**
	* Returns the exam body user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param examBodyUserId the primary key of the exam body user
	* @return the exam body user, or <code>null</code> if a exam body user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser fetchByPrimaryKey(
		long examBodyUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(examBodyUserId);
	}

	/**
	* Returns all the exam body users.
	*
	* @return the exam body users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the exam body users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of exam body users.
	*
	* @return the number of exam body users
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ExamBodyUserPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ExamBodyUserPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spsocialprofile.service.ClpSerializer.getServletContextName(),
					ExamBodyUserPersistence.class.getName());

			ReferenceRegistry.registerReference(ExamBodyUserUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ExamBodyUserPersistence persistence) {
	}

	private static ExamBodyUserPersistence _persistence;
}