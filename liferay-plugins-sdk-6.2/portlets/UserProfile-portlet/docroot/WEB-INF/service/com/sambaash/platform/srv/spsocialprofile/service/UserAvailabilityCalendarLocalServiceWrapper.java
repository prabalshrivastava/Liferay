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

package com.sambaash.platform.srv.spsocialprofile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserAvailabilityCalendarLocalService}.
 *
 * @author gauravvijayvergia
 * @see UserAvailabilityCalendarLocalService
 * @generated
 */
public class UserAvailabilityCalendarLocalServiceWrapper
	implements UserAvailabilityCalendarLocalService,
		ServiceWrapper<UserAvailabilityCalendarLocalService> {
	public UserAvailabilityCalendarLocalServiceWrapper(
		UserAvailabilityCalendarLocalService userAvailabilityCalendarLocalService) {
		_userAvailabilityCalendarLocalService = userAvailabilityCalendarLocalService;
	}

	/**
	* Adds the user availability calendar to the database. Also notifies the appropriate model listeners.
	*
	* @param userAvailabilityCalendar the user availability calendar
	* @return the user availability calendar that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar addUserAvailabilityCalendar(
		com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar userAvailabilityCalendar)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userAvailabilityCalendarLocalService.addUserAvailabilityCalendar(userAvailabilityCalendar);
	}

	/**
	* Creates a new user availability calendar with the primary key. Does not add the user availability calendar to the database.
	*
	* @param userAvailabilityCalendarId the primary key for the new user availability calendar
	* @return the new user availability calendar
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar createUserAvailabilityCalendar(
		long userAvailabilityCalendarId) {
		return _userAvailabilityCalendarLocalService.createUserAvailabilityCalendar(userAvailabilityCalendarId);
	}

	/**
	* Deletes the user availability calendar with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userAvailabilityCalendarId the primary key of the user availability calendar
	* @return the user availability calendar that was removed
	* @throws PortalException if a user availability calendar with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar deleteUserAvailabilityCalendar(
		long userAvailabilityCalendarId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userAvailabilityCalendarLocalService.deleteUserAvailabilityCalendar(userAvailabilityCalendarId);
	}

	/**
	* Deletes the user availability calendar from the database. Also notifies the appropriate model listeners.
	*
	* @param userAvailabilityCalendar the user availability calendar
	* @return the user availability calendar that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar deleteUserAvailabilityCalendar(
		com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar userAvailabilityCalendar)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userAvailabilityCalendarLocalService.deleteUserAvailabilityCalendar(userAvailabilityCalendar);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userAvailabilityCalendarLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userAvailabilityCalendarLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.UserAvailabilityCalendarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _userAvailabilityCalendarLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.UserAvailabilityCalendarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userAvailabilityCalendarLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userAvailabilityCalendarLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userAvailabilityCalendarLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar fetchUserAvailabilityCalendar(
		long userAvailabilityCalendarId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userAvailabilityCalendarLocalService.fetchUserAvailabilityCalendar(userAvailabilityCalendarId);
	}

	/**
	* Returns the user availability calendar with the primary key.
	*
	* @param userAvailabilityCalendarId the primary key of the user availability calendar
	* @return the user availability calendar
	* @throws PortalException if a user availability calendar with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar getUserAvailabilityCalendar(
		long userAvailabilityCalendarId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userAvailabilityCalendarLocalService.getUserAvailabilityCalendar(userAvailabilityCalendarId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userAvailabilityCalendarLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar> getUserAvailabilityCalendars(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userAvailabilityCalendarLocalService.getUserAvailabilityCalendars(start,
			end);
	}

	/**
	* Returns the number of user availability calendars.
	*
	* @return the number of user availability calendars
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUserAvailabilityCalendarsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userAvailabilityCalendarLocalService.getUserAvailabilityCalendarsCount();
	}

	/**
	* Updates the user availability calendar in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userAvailabilityCalendar the user availability calendar
	* @return the user availability calendar that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar updateUserAvailabilityCalendar(
		com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar userAvailabilityCalendar)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userAvailabilityCalendarLocalService.updateUserAvailabilityCalendar(userAvailabilityCalendar);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _userAvailabilityCalendarLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userAvailabilityCalendarLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userAvailabilityCalendarLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar addUserAvailabilityCalendar(
		long userId, long companyId, java.lang.String availableFor,
		java.util.Date startDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userAvailabilityCalendarLocalService.addUserAvailabilityCalendar(userId,
			companyId, availableFor, startDate, endDate);
	}

	@Override
	public void deleteUserAvailabilityInfo(
		com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar info)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_userAvailabilityCalendarLocalService.deleteUserAvailabilityInfo(info);
	}

	@Override
	public void delUserAvailabilityCalendar(long availabilityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_userAvailabilityCalendarLocalService.delUserAvailabilityCalendar(availabilityId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar> getActiveCalendarListByUserId(
		java.lang.Long userId, java.lang.Long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userAvailabilityCalendarLocalService.getActiveCalendarListByUserId(userId,
			companyId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar> getUserAvailabilityList(
		java.lang.Long userId, java.lang.Long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userAvailabilityCalendarLocalService.getUserAvailabilityList(userId,
			companyId);
	}

	@Override
	public void updateUserAvailabilityCal(
		com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar userAvailabilityCalendar)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_userAvailabilityCalendarLocalService.updateUserAvailabilityCal(userAvailabilityCalendar);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UserAvailabilityCalendarLocalService getWrappedUserAvailabilityCalendarLocalService() {
		return _userAvailabilityCalendarLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUserAvailabilityCalendarLocalService(
		UserAvailabilityCalendarLocalService userAvailabilityCalendarLocalService) {
		_userAvailabilityCalendarLocalService = userAvailabilityCalendarLocalService;
	}

	@Override
	public UserAvailabilityCalendarLocalService getWrappedService() {
		return _userAvailabilityCalendarLocalService;
	}

	@Override
	public void setWrappedService(
		UserAvailabilityCalendarLocalService userAvailabilityCalendarLocalService) {
		_userAvailabilityCalendarLocalService = userAvailabilityCalendarLocalService;
	}

	private UserAvailabilityCalendarLocalService _userAvailabilityCalendarLocalService;
}