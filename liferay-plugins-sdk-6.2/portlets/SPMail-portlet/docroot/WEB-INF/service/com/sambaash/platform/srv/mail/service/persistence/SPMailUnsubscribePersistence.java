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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.mail.model.SPMailUnsubscribe;

/**
 * The persistence interface for the s p mail unsubscribe service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailUnsubscribePersistenceImpl
 * @see SPMailUnsubscribeUtil
 * @generated
 */
public interface SPMailUnsubscribePersistence extends BasePersistence<SPMailUnsubscribe> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPMailUnsubscribeUtil} to access the s p mail unsubscribe persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the s p mail unsubscribe where emailAddress = &#63; and categoryId = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchUnsubscribeException} if it could not be found.
	*
	* @param emailAddress the email address
	* @param categoryId the category ID
	* @return the matching s p mail unsubscribe
	* @throws com.sambaash.platform.srv.mail.NoSuchUnsubscribeException if a matching s p mail unsubscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe findByEmailAddressAndCategoryId(
		java.lang.String emailAddress, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchUnsubscribeException;

	/**
	* Returns the s p mail unsubscribe where emailAddress = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param emailAddress the email address
	* @param categoryId the category ID
	* @return the matching s p mail unsubscribe, or <code>null</code> if a matching s p mail unsubscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe fetchByEmailAddressAndCategoryId(
		java.lang.String emailAddress, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail unsubscribe where emailAddress = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param emailAddress the email address
	* @param categoryId the category ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p mail unsubscribe, or <code>null</code> if a matching s p mail unsubscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe fetchByEmailAddressAndCategoryId(
		java.lang.String emailAddress, long categoryId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p mail unsubscribe where emailAddress = &#63; and categoryId = &#63; from the database.
	*
	* @param emailAddress the email address
	* @param categoryId the category ID
	* @return the s p mail unsubscribe that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe removeByEmailAddressAndCategoryId(
		java.lang.String emailAddress, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchUnsubscribeException;

	/**
	* Returns the number of s p mail unsubscribes where emailAddress = &#63; and categoryId = &#63;.
	*
	* @param emailAddress the email address
	* @param categoryId the category ID
	* @return the number of matching s p mail unsubscribes
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmailAddressAndCategoryId(java.lang.String emailAddress,
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail unsubscribe where emailAddress = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchUnsubscribeException} if it could not be found.
	*
	* @param emailAddress the email address
	* @return the matching s p mail unsubscribe
	* @throws com.sambaash.platform.srv.mail.NoSuchUnsubscribeException if a matching s p mail unsubscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe findByEmailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchUnsubscribeException;

	/**
	* Returns the s p mail unsubscribe where emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param emailAddress the email address
	* @return the matching s p mail unsubscribe, or <code>null</code> if a matching s p mail unsubscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe fetchByEmailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail unsubscribe where emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param emailAddress the email address
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p mail unsubscribe, or <code>null</code> if a matching s p mail unsubscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe fetchByEmailAddress(
		java.lang.String emailAddress, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p mail unsubscribe where emailAddress = &#63; from the database.
	*
	* @param emailAddress the email address
	* @return the s p mail unsubscribe that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe removeByEmailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchUnsubscribeException;

	/**
	* Returns the number of s p mail unsubscribes where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @return the number of matching s p mail unsubscribes
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmailAddress(java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail unsubscribe where userId = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchUnsubscribeException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching s p mail unsubscribe
	* @throws com.sambaash.platform.srv.mail.NoSuchUnsubscribeException if a matching s p mail unsubscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe findByUserId(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchUnsubscribeException;

	/**
	* Returns the s p mail unsubscribe where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching s p mail unsubscribe, or <code>null</code> if a matching s p mail unsubscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe fetchByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail unsubscribe where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p mail unsubscribe, or <code>null</code> if a matching s p mail unsubscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe fetchByUserId(
		long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p mail unsubscribe where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the s p mail unsubscribe that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe removeByUserId(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchUnsubscribeException;

	/**
	* Returns the number of s p mail unsubscribes where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching s p mail unsubscribes
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p mail unsubscribe in the entity cache if it is enabled.
	*
	* @param spMailUnsubscribe the s p mail unsubscribe
	*/
	public void cacheResult(
		com.sambaash.platform.srv.mail.model.SPMailUnsubscribe spMailUnsubscribe);

	/**
	* Caches the s p mail unsubscribes in the entity cache if it is enabled.
	*
	* @param spMailUnsubscribes the s p mail unsubscribes
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.mail.model.SPMailUnsubscribe> spMailUnsubscribes);

	/**
	* Creates a new s p mail unsubscribe with the primary key. Does not add the s p mail unsubscribe to the database.
	*
	* @param spMailUnsubscribeId the primary key for the new s p mail unsubscribe
	* @return the new s p mail unsubscribe
	*/
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe create(
		long spMailUnsubscribeId);

	/**
	* Removes the s p mail unsubscribe with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailUnsubscribeId the primary key of the s p mail unsubscribe
	* @return the s p mail unsubscribe that was removed
	* @throws com.sambaash.platform.srv.mail.NoSuchUnsubscribeException if a s p mail unsubscribe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe remove(
		long spMailUnsubscribeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchUnsubscribeException;

	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe updateImpl(
		com.sambaash.platform.srv.mail.model.SPMailUnsubscribe spMailUnsubscribe)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail unsubscribe with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchUnsubscribeException} if it could not be found.
	*
	* @param spMailUnsubscribeId the primary key of the s p mail unsubscribe
	* @return the s p mail unsubscribe
	* @throws com.sambaash.platform.srv.mail.NoSuchUnsubscribeException if a s p mail unsubscribe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe findByPrimaryKey(
		long spMailUnsubscribeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchUnsubscribeException;

	/**
	* Returns the s p mail unsubscribe with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spMailUnsubscribeId the primary key of the s p mail unsubscribe
	* @return the s p mail unsubscribe, or <code>null</code> if a s p mail unsubscribe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe fetchByPrimaryKey(
		long spMailUnsubscribeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail unsubscribes.
	*
	* @return the s p mail unsubscribes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailUnsubscribe> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p mail unsubscribes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailUnsubscribeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail unsubscribes
	* @param end the upper bound of the range of s p mail unsubscribes (not inclusive)
	* @return the range of s p mail unsubscribes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailUnsubscribe> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p mail unsubscribes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailUnsubscribeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail unsubscribes
	* @param end the upper bound of the range of s p mail unsubscribes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p mail unsubscribes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailUnsubscribe> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p mail unsubscribes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail unsubscribes.
	*
	* @return the number of s p mail unsubscribes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}