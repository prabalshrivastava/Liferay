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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.mail.model.SPMailUnsubscribe;

import java.util.List;

/**
 * The persistence utility for the s p mail unsubscribe service. This utility wraps {@link SPMailUnsubscribePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailUnsubscribePersistence
 * @see SPMailUnsubscribePersistenceImpl
 * @generated
 */
public class SPMailUnsubscribeUtil {
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
	public static void clearCache(SPMailUnsubscribe spMailUnsubscribe) {
		getPersistence().clearCache(spMailUnsubscribe);
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
	public static List<SPMailUnsubscribe> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPMailUnsubscribe> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPMailUnsubscribe> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPMailUnsubscribe update(SPMailUnsubscribe spMailUnsubscribe)
		throws SystemException {
		return getPersistence().update(spMailUnsubscribe);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPMailUnsubscribe update(
		SPMailUnsubscribe spMailUnsubscribe, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(spMailUnsubscribe, serviceContext);
	}

	/**
	* Returns the s p mail unsubscribe where emailAddress = &#63; and categoryId = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchUnsubscribeException} if it could not be found.
	*
	* @param emailAddress the email address
	* @param categoryId the category ID
	* @return the matching s p mail unsubscribe
	* @throws com.sambaash.platform.srv.mail.NoSuchUnsubscribeException if a matching s p mail unsubscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe findByEmailAddressAndCategoryId(
		java.lang.String emailAddress, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchUnsubscribeException {
		return getPersistence()
				   .findByEmailAddressAndCategoryId(emailAddress, categoryId);
	}

	/**
	* Returns the s p mail unsubscribe where emailAddress = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param emailAddress the email address
	* @param categoryId the category ID
	* @return the matching s p mail unsubscribe, or <code>null</code> if a matching s p mail unsubscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe fetchByEmailAddressAndCategoryId(
		java.lang.String emailAddress, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmailAddressAndCategoryId(emailAddress, categoryId);
	}

	/**
	* Returns the s p mail unsubscribe where emailAddress = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param emailAddress the email address
	* @param categoryId the category ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p mail unsubscribe, or <code>null</code> if a matching s p mail unsubscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe fetchByEmailAddressAndCategoryId(
		java.lang.String emailAddress, long categoryId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmailAddressAndCategoryId(emailAddress, categoryId,
			retrieveFromCache);
	}

	/**
	* Removes the s p mail unsubscribe where emailAddress = &#63; and categoryId = &#63; from the database.
	*
	* @param emailAddress the email address
	* @param categoryId the category ID
	* @return the s p mail unsubscribe that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe removeByEmailAddressAndCategoryId(
		java.lang.String emailAddress, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchUnsubscribeException {
		return getPersistence()
				   .removeByEmailAddressAndCategoryId(emailAddress, categoryId);
	}

	/**
	* Returns the number of s p mail unsubscribes where emailAddress = &#63; and categoryId = &#63;.
	*
	* @param emailAddress the email address
	* @param categoryId the category ID
	* @return the number of matching s p mail unsubscribes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmailAddressAndCategoryId(
		java.lang.String emailAddress, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByEmailAddressAndCategoryId(emailAddress, categoryId);
	}

	/**
	* Returns the s p mail unsubscribe where emailAddress = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchUnsubscribeException} if it could not be found.
	*
	* @param emailAddress the email address
	* @return the matching s p mail unsubscribe
	* @throws com.sambaash.platform.srv.mail.NoSuchUnsubscribeException if a matching s p mail unsubscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe findByEmailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchUnsubscribeException {
		return getPersistence().findByEmailAddress(emailAddress);
	}

	/**
	* Returns the s p mail unsubscribe where emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param emailAddress the email address
	* @return the matching s p mail unsubscribe, or <code>null</code> if a matching s p mail unsubscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe fetchByEmailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmailAddress(emailAddress);
	}

	/**
	* Returns the s p mail unsubscribe where emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param emailAddress the email address
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p mail unsubscribe, or <code>null</code> if a matching s p mail unsubscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe fetchByEmailAddress(
		java.lang.String emailAddress, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmailAddress(emailAddress, retrieveFromCache);
	}

	/**
	* Removes the s p mail unsubscribe where emailAddress = &#63; from the database.
	*
	* @param emailAddress the email address
	* @return the s p mail unsubscribe that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe removeByEmailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchUnsubscribeException {
		return getPersistence().removeByEmailAddress(emailAddress);
	}

	/**
	* Returns the number of s p mail unsubscribes where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @return the number of matching s p mail unsubscribes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmailAddress(java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmailAddress(emailAddress);
	}

	/**
	* Returns the s p mail unsubscribe where userId = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchUnsubscribeException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching s p mail unsubscribe
	* @throws com.sambaash.platform.srv.mail.NoSuchUnsubscribeException if a matching s p mail unsubscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe findByUserId(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchUnsubscribeException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns the s p mail unsubscribe where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching s p mail unsubscribe, or <code>null</code> if a matching s p mail unsubscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe fetchByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId(userId);
	}

	/**
	* Returns the s p mail unsubscribe where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p mail unsubscribe, or <code>null</code> if a matching s p mail unsubscribe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe fetchByUserId(
		long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId(userId, retrieveFromCache);
	}

	/**
	* Removes the s p mail unsubscribe where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the s p mail unsubscribe that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe removeByUserId(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchUnsubscribeException {
		return getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of s p mail unsubscribes where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching s p mail unsubscribes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Caches the s p mail unsubscribe in the entity cache if it is enabled.
	*
	* @param spMailUnsubscribe the s p mail unsubscribe
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.mail.model.SPMailUnsubscribe spMailUnsubscribe) {
		getPersistence().cacheResult(spMailUnsubscribe);
	}

	/**
	* Caches the s p mail unsubscribes in the entity cache if it is enabled.
	*
	* @param spMailUnsubscribes the s p mail unsubscribes
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.mail.model.SPMailUnsubscribe> spMailUnsubscribes) {
		getPersistence().cacheResult(spMailUnsubscribes);
	}

	/**
	* Creates a new s p mail unsubscribe with the primary key. Does not add the s p mail unsubscribe to the database.
	*
	* @param spMailUnsubscribeId the primary key for the new s p mail unsubscribe
	* @return the new s p mail unsubscribe
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe create(
		long spMailUnsubscribeId) {
		return getPersistence().create(spMailUnsubscribeId);
	}

	/**
	* Removes the s p mail unsubscribe with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailUnsubscribeId the primary key of the s p mail unsubscribe
	* @return the s p mail unsubscribe that was removed
	* @throws com.sambaash.platform.srv.mail.NoSuchUnsubscribeException if a s p mail unsubscribe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe remove(
		long spMailUnsubscribeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchUnsubscribeException {
		return getPersistence().remove(spMailUnsubscribeId);
	}

	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe updateImpl(
		com.sambaash.platform.srv.mail.model.SPMailUnsubscribe spMailUnsubscribe)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spMailUnsubscribe);
	}

	/**
	* Returns the s p mail unsubscribe with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchUnsubscribeException} if it could not be found.
	*
	* @param spMailUnsubscribeId the primary key of the s p mail unsubscribe
	* @return the s p mail unsubscribe
	* @throws com.sambaash.platform.srv.mail.NoSuchUnsubscribeException if a s p mail unsubscribe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe findByPrimaryKey(
		long spMailUnsubscribeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchUnsubscribeException {
		return getPersistence().findByPrimaryKey(spMailUnsubscribeId);
	}

	/**
	* Returns the s p mail unsubscribe with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spMailUnsubscribeId the primary key of the s p mail unsubscribe
	* @return the s p mail unsubscribe, or <code>null</code> if a s p mail unsubscribe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailUnsubscribe fetchByPrimaryKey(
		long spMailUnsubscribeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spMailUnsubscribeId);
	}

	/**
	* Returns all the s p mail unsubscribes.
	*
	* @return the s p mail unsubscribes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailUnsubscribe> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailUnsubscribe> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailUnsubscribe> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p mail unsubscribes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p mail unsubscribes.
	*
	* @return the number of s p mail unsubscribes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPMailUnsubscribePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPMailUnsubscribePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.mail.service.ClpSerializer.getServletContextName(),
					SPMailUnsubscribePersistence.class.getName());

			ReferenceRegistry.registerReference(SPMailUnsubscribeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPMailUnsubscribePersistence persistence) {
	}

	private static SPMailUnsubscribePersistence _persistence;
}