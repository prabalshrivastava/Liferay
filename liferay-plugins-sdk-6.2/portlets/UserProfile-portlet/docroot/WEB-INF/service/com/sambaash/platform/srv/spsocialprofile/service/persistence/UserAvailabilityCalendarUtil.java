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

import com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar;

import java.util.List;

/**
 * The persistence utility for the user availability calendar service. This utility wraps {@link UserAvailabilityCalendarPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see UserAvailabilityCalendarPersistence
 * @see UserAvailabilityCalendarPersistenceImpl
 * @generated
 */
public class UserAvailabilityCalendarUtil {
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
	public static void clearCache(
		UserAvailabilityCalendar userAvailabilityCalendar) {
		getPersistence().clearCache(userAvailabilityCalendar);
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
	public static List<UserAvailabilityCalendar> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserAvailabilityCalendar> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserAvailabilityCalendar> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static UserAvailabilityCalendar update(
		UserAvailabilityCalendar userAvailabilityCalendar)
		throws SystemException {
		return getPersistence().update(userAvailabilityCalendar);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static UserAvailabilityCalendar update(
		UserAvailabilityCalendar userAvailabilityCalendar,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(userAvailabilityCalendar, serviceContext);
	}

	/**
	* Returns all the user availability calendars where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the matching user availability calendars
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar> findByUserIdAndCompanyId(
		long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdAndCompanyId(companyId, userId);
	}

	/**
	* Returns a range of all the user availability calendars where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.UserAvailabilityCalendarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param start the lower bound of the range of user availability calendars
	* @param end the upper bound of the range of user availability calendars (not inclusive)
	* @return the range of matching user availability calendars
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar> findByUserIdAndCompanyId(
		long companyId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdAndCompanyId(companyId, userId, start, end);
	}

	/**
	* Returns an ordered range of all the user availability calendars where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.UserAvailabilityCalendarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param start the lower bound of the range of user availability calendars
	* @param end the upper bound of the range of user availability calendars (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user availability calendars
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar> findByUserIdAndCompanyId(
		long companyId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdAndCompanyId(companyId, userId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first user availability calendar in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user availability calendar
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchUserAvailabilityCalendarException if a matching user availability calendar could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar findByUserIdAndCompanyId_First(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchUserAvailabilityCalendarException {
		return getPersistence()
				   .findByUserIdAndCompanyId_First(companyId, userId,
			orderByComparator);
	}

	/**
	* Returns the first user availability calendar in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user availability calendar, or <code>null</code> if a matching user availability calendar could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar fetchByUserIdAndCompanyId_First(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdAndCompanyId_First(companyId, userId,
			orderByComparator);
	}

	/**
	* Returns the last user availability calendar in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user availability calendar
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchUserAvailabilityCalendarException if a matching user availability calendar could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar findByUserIdAndCompanyId_Last(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchUserAvailabilityCalendarException {
		return getPersistence()
				   .findByUserIdAndCompanyId_Last(companyId, userId,
			orderByComparator);
	}

	/**
	* Returns the last user availability calendar in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user availability calendar, or <code>null</code> if a matching user availability calendar could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar fetchByUserIdAndCompanyId_Last(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdAndCompanyId_Last(companyId, userId,
			orderByComparator);
	}

	/**
	* Returns the user availability calendars before and after the current user availability calendar in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param userAvailabilityCalendarId the primary key of the current user availability calendar
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user availability calendar
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchUserAvailabilityCalendarException if a user availability calendar with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar[] findByUserIdAndCompanyId_PrevAndNext(
		long userAvailabilityCalendarId, long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchUserAvailabilityCalendarException {
		return getPersistence()
				   .findByUserIdAndCompanyId_PrevAndNext(userAvailabilityCalendarId,
			companyId, userId, orderByComparator);
	}

	/**
	* Removes all the user availability calendars where companyId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserIdAndCompanyId(long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserIdAndCompanyId(companyId, userId);
	}

	/**
	* Returns the number of user availability calendars where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the number of matching user availability calendars
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdAndCompanyId(long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserIdAndCompanyId(companyId, userId);
	}

	/**
	* Caches the user availability calendar in the entity cache if it is enabled.
	*
	* @param userAvailabilityCalendar the user availability calendar
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar userAvailabilityCalendar) {
		getPersistence().cacheResult(userAvailabilityCalendar);
	}

	/**
	* Caches the user availability calendars in the entity cache if it is enabled.
	*
	* @param userAvailabilityCalendars the user availability calendars
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar> userAvailabilityCalendars) {
		getPersistence().cacheResult(userAvailabilityCalendars);
	}

	/**
	* Creates a new user availability calendar with the primary key. Does not add the user availability calendar to the database.
	*
	* @param userAvailabilityCalendarId the primary key for the new user availability calendar
	* @return the new user availability calendar
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar create(
		long userAvailabilityCalendarId) {
		return getPersistence().create(userAvailabilityCalendarId);
	}

	/**
	* Removes the user availability calendar with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userAvailabilityCalendarId the primary key of the user availability calendar
	* @return the user availability calendar that was removed
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchUserAvailabilityCalendarException if a user availability calendar with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar remove(
		long userAvailabilityCalendarId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchUserAvailabilityCalendarException {
		return getPersistence().remove(userAvailabilityCalendarId);
	}

	public static com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar updateImpl(
		com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar userAvailabilityCalendar)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userAvailabilityCalendar);
	}

	/**
	* Returns the user availability calendar with the primary key or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchUserAvailabilityCalendarException} if it could not be found.
	*
	* @param userAvailabilityCalendarId the primary key of the user availability calendar
	* @return the user availability calendar
	* @throws com.sambaash.platform.srv.spsocialprofile.NoSuchUserAvailabilityCalendarException if a user availability calendar with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar findByPrimaryKey(
		long userAvailabilityCalendarId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchUserAvailabilityCalendarException {
		return getPersistence().findByPrimaryKey(userAvailabilityCalendarId);
	}

	/**
	* Returns the user availability calendar with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userAvailabilityCalendarId the primary key of the user availability calendar
	* @return the user availability calendar, or <code>null</code> if a user availability calendar with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar fetchByPrimaryKey(
		long userAvailabilityCalendarId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userAvailabilityCalendarId);
	}

	/**
	* Returns all the user availability calendars.
	*
	* @return the user availability calendars
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user availability calendars.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.UserAvailabilityCalendarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user availability calendars
	* @param end the upper bound of the range of user availability calendars (not inclusive)
	* @return the range of user availability calendars
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user availability calendars.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.UserAvailabilityCalendarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user availability calendars
	* @param end the upper bound of the range of user availability calendars (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user availability calendars
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user availability calendars from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user availability calendars.
	*
	* @return the number of user availability calendars
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserAvailabilityCalendarPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserAvailabilityCalendarPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spsocialprofile.service.ClpSerializer.getServletContextName(),
					UserAvailabilityCalendarPersistence.class.getName());

			ReferenceRegistry.registerReference(UserAvailabilityCalendarUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UserAvailabilityCalendarPersistence persistence) {
	}

	private static UserAvailabilityCalendarPersistence _persistence;
}