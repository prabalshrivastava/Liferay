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

package com.sambaash.platform.srv.startupprofile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPATOContactsLocalService}.
 *
 * @author pradeep
 * @see SPATOContactsLocalService
 * @generated
 */
public class SPATOContactsLocalServiceWrapper
	implements SPATOContactsLocalService,
		ServiceWrapper<SPATOContactsLocalService> {
	public SPATOContactsLocalServiceWrapper(
		SPATOContactsLocalService spatoContactsLocalService) {
		_spatoContactsLocalService = spatoContactsLocalService;
	}

	/**
	* Adds the s p a t o contacts to the database. Also notifies the appropriate model listeners.
	*
	* @param spatoContacts the s p a t o contacts
	* @return the s p a t o contacts that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts addSPATOContacts(
		com.sambaash.platform.srv.startupprofile.model.SPATOContacts spatoContacts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spatoContactsLocalService.addSPATOContacts(spatoContacts);
	}

	/**
	* Creates a new s p a t o contacts with the primary key. Does not add the s p a t o contacts to the database.
	*
	* @param spATOContactId the primary key for the new s p a t o contacts
	* @return the new s p a t o contacts
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts createSPATOContacts(
		long spATOContactId) {
		return _spatoContactsLocalService.createSPATOContacts(spATOContactId);
	}

	/**
	* Deletes the s p a t o contacts with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spATOContactId the primary key of the s p a t o contacts
	* @return the s p a t o contacts that was removed
	* @throws PortalException if a s p a t o contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts deleteSPATOContacts(
		long spATOContactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spatoContactsLocalService.deleteSPATOContacts(spATOContactId);
	}

	/**
	* Deletes the s p a t o contacts from the database. Also notifies the appropriate model listeners.
	*
	* @param spatoContacts the s p a t o contacts
	* @return the s p a t o contacts that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts deleteSPATOContacts(
		com.sambaash.platform.srv.startupprofile.model.SPATOContacts spatoContacts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spatoContactsLocalService.deleteSPATOContacts(spatoContacts);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spatoContactsLocalService.dynamicQuery();
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
		return _spatoContactsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spatoContactsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spatoContactsLocalService.dynamicQuery(dynamicQuery, start,
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
		return _spatoContactsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spatoContactsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts fetchSPATOContacts(
		long spATOContactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spatoContactsLocalService.fetchSPATOContacts(spATOContactId);
	}

	/**
	* Returns the s p a t o contacts with the primary key.
	*
	* @param spATOContactId the primary key of the s p a t o contacts
	* @return the s p a t o contacts
	* @throws PortalException if a s p a t o contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts getSPATOContacts(
		long spATOContactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spatoContactsLocalService.getSPATOContacts(spATOContactId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spatoContactsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p a t o contactses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p a t o contactses
	* @param end the upper bound of the range of s p a t o contactses (not inclusive)
	* @return the range of s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> getSPATOContactses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spatoContactsLocalService.getSPATOContactses(start, end);
	}

	/**
	* Returns the number of s p a t o contactses.
	*
	* @return the number of s p a t o contactses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPATOContactsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spatoContactsLocalService.getSPATOContactsesCount();
	}

	/**
	* Updates the s p a t o contacts in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spatoContacts the s p a t o contacts
	* @return the s p a t o contacts that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts updateSPATOContacts(
		com.sambaash.platform.srv.startupprofile.model.SPATOContacts spatoContacts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spatoContactsLocalService.updateSPATOContacts(spatoContacts);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spatoContactsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spatoContactsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spatoContactsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findByOrganizationId(
		long organizationId) {
		return _spatoContactsLocalService.findByOrganizationId(organizationId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findATOTrainingPrincipalByOrganizationId(
		long organizationId) {
		return _spatoContactsLocalService.findATOTrainingPrincipalByOrganizationId(organizationId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findATOSecondaryContactByOrganizationId(
		long organizationId) {
		return _spatoContactsLocalService.findATOSecondaryContactByOrganizationId(organizationId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findATOContactsByOrganizationId(
		long organizationId) {
		return _spatoContactsLocalService.findATOContactsByOrganizationId(organizationId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findATOContactsByTrainingPrincipal(
		long userId) {
		return _spatoContactsLocalService.findATOContactsByTrainingPrincipal(userId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> findATOContactsBySecondaryContact(
		long userId) {
		return _spatoContactsLocalService.findATOContactsBySecondaryContact(userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPATOContactsLocalService getWrappedSPATOContactsLocalService() {
		return _spatoContactsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPATOContactsLocalService(
		SPATOContactsLocalService spatoContactsLocalService) {
		_spatoContactsLocalService = spatoContactsLocalService;
	}

	@Override
	public SPATOContactsLocalService getWrappedService() {
		return _spatoContactsLocalService;
	}

	@Override
	public void setWrappedService(
		SPATOContactsLocalService spatoContactsLocalService) {
		_spatoContactsLocalService = spatoContactsLocalService;
	}

	private SPATOContactsLocalService _spatoContactsLocalService;
}