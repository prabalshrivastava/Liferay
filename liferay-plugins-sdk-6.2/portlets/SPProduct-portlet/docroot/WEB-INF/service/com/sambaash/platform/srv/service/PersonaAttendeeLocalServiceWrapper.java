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

package com.sambaash.platform.srv.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PersonaAttendeeLocalService}.
 *
 * @author gauravvijayvergia
 * @see PersonaAttendeeLocalService
 * @generated
 */
public class PersonaAttendeeLocalServiceWrapper
	implements PersonaAttendeeLocalService,
		ServiceWrapper<PersonaAttendeeLocalService> {
	public PersonaAttendeeLocalServiceWrapper(
		PersonaAttendeeLocalService personaAttendeeLocalService) {
		_personaAttendeeLocalService = personaAttendeeLocalService;
	}

	/**
	* Adds the persona attendee to the database. Also notifies the appropriate model listeners.
	*
	* @param personaAttendee the persona attendee
	* @return the persona attendee that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.PersonaAttendee addPersonaAttendee(
		com.sambaash.platform.srv.model.PersonaAttendee personaAttendee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _personaAttendeeLocalService.addPersonaAttendee(personaAttendee);
	}

	/**
	* Creates a new persona attendee with the primary key. Does not add the persona attendee to the database.
	*
	* @param spPersonaAttendeeId the primary key for the new persona attendee
	* @return the new persona attendee
	*/
	@Override
	public com.sambaash.platform.srv.model.PersonaAttendee createPersonaAttendee(
		long spPersonaAttendeeId) {
		return _personaAttendeeLocalService.createPersonaAttendee(spPersonaAttendeeId);
	}

	/**
	* Deletes the persona attendee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPersonaAttendeeId the primary key of the persona attendee
	* @return the persona attendee that was removed
	* @throws PortalException if a persona attendee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.PersonaAttendee deletePersonaAttendee(
		long spPersonaAttendeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _personaAttendeeLocalService.deletePersonaAttendee(spPersonaAttendeeId);
	}

	/**
	* Deletes the persona attendee from the database. Also notifies the appropriate model listeners.
	*
	* @param personaAttendee the persona attendee
	* @return the persona attendee that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.PersonaAttendee deletePersonaAttendee(
		com.sambaash.platform.srv.model.PersonaAttendee personaAttendee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _personaAttendeeLocalService.deletePersonaAttendee(personaAttendee);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _personaAttendeeLocalService.dynamicQuery();
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
		return _personaAttendeeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.PersonaAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _personaAttendeeLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.PersonaAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _personaAttendeeLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _personaAttendeeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _personaAttendeeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.model.PersonaAttendee fetchPersonaAttendee(
		long spPersonaAttendeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _personaAttendeeLocalService.fetchPersonaAttendee(spPersonaAttendeeId);
	}

	/**
	* Returns the persona attendee with the primary key.
	*
	* @param spPersonaAttendeeId the primary key of the persona attendee
	* @return the persona attendee
	* @throws PortalException if a persona attendee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.PersonaAttendee getPersonaAttendee(
		long spPersonaAttendeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _personaAttendeeLocalService.getPersonaAttendee(spPersonaAttendeeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _personaAttendeeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the persona attendees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.PersonaAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of persona attendees
	* @param end the upper bound of the range of persona attendees (not inclusive)
	* @return the range of persona attendees
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.model.PersonaAttendee> getPersonaAttendees(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _personaAttendeeLocalService.getPersonaAttendees(start, end);
	}

	/**
	* Returns the number of persona attendees.
	*
	* @return the number of persona attendees
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPersonaAttendeesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _personaAttendeeLocalService.getPersonaAttendeesCount();
	}

	/**
	* Updates the persona attendee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param personaAttendee the persona attendee
	* @return the persona attendee that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.PersonaAttendee updatePersonaAttendee(
		com.sambaash.platform.srv.model.PersonaAttendee personaAttendee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _personaAttendeeLocalService.updatePersonaAttendee(personaAttendee);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _personaAttendeeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_personaAttendeeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _personaAttendeeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.model.PersonaAttendee> findByCourseIdAndGroupId(
		long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _personaAttendeeLocalService.findByCourseIdAndGroupId(spCourseId,
			groupId);
	}

	@Override
	public void clearCache() {
		_personaAttendeeLocalService.clearCache();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PersonaAttendeeLocalService getWrappedPersonaAttendeeLocalService() {
		return _personaAttendeeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPersonaAttendeeLocalService(
		PersonaAttendeeLocalService personaAttendeeLocalService) {
		_personaAttendeeLocalService = personaAttendeeLocalService;
	}

	@Override
	public PersonaAttendeeLocalService getWrappedService() {
		return _personaAttendeeLocalService;
	}

	@Override
	public void setWrappedService(
		PersonaAttendeeLocalService personaAttendeeLocalService) {
		_personaAttendeeLocalService = personaAttendeeLocalService;
	}

	private PersonaAttendeeLocalService _personaAttendeeLocalService;
}