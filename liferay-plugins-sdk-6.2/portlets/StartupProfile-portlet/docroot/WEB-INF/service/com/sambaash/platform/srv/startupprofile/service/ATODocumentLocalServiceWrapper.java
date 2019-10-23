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
 * Provides a wrapper for {@link ATODocumentLocalService}.
 *
 * @author pradeep
 * @see ATODocumentLocalService
 * @generated
 */
public class ATODocumentLocalServiceWrapper implements ATODocumentLocalService,
	ServiceWrapper<ATODocumentLocalService> {
	public ATODocumentLocalServiceWrapper(
		ATODocumentLocalService atoDocumentLocalService) {
		_atoDocumentLocalService = atoDocumentLocalService;
	}

	/**
	* Adds the a t o document to the database. Also notifies the appropriate model listeners.
	*
	* @param atoDocument the a t o document
	* @return the a t o document that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.ATODocument addATODocument(
		com.sambaash.platform.srv.startupprofile.model.ATODocument atoDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atoDocumentLocalService.addATODocument(atoDocument);
	}

	/**
	* Creates a new a t o document with the primary key. Does not add the a t o document to the database.
	*
	* @param atoDocumentId the primary key for the new a t o document
	* @return the new a t o document
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.ATODocument createATODocument(
		long atoDocumentId) {
		return _atoDocumentLocalService.createATODocument(atoDocumentId);
	}

	/**
	* Deletes the a t o document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param atoDocumentId the primary key of the a t o document
	* @return the a t o document that was removed
	* @throws PortalException if a a t o document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.ATODocument deleteATODocument(
		long atoDocumentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _atoDocumentLocalService.deleteATODocument(atoDocumentId);
	}

	/**
	* Deletes the a t o document from the database. Also notifies the appropriate model listeners.
	*
	* @param atoDocument the a t o document
	* @return the a t o document that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.ATODocument deleteATODocument(
		com.sambaash.platform.srv.startupprofile.model.ATODocument atoDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atoDocumentLocalService.deleteATODocument(atoDocument);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _atoDocumentLocalService.dynamicQuery();
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
		return _atoDocumentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _atoDocumentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _atoDocumentLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _atoDocumentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _atoDocumentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.ATODocument fetchATODocument(
		long atoDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atoDocumentLocalService.fetchATODocument(atoDocumentId);
	}

	/**
	* Returns the a t o document with the primary key.
	*
	* @param atoDocumentId the primary key of the a t o document
	* @return the a t o document
	* @throws PortalException if a a t o document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.ATODocument getATODocument(
		long atoDocumentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _atoDocumentLocalService.getATODocument(atoDocumentId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _atoDocumentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the a t o documents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ATODocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of a t o documents
	* @param end the upper bound of the range of a t o documents (not inclusive)
	* @return the range of a t o documents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> getATODocuments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atoDocumentLocalService.getATODocuments(start, end);
	}

	/**
	* Returns the number of a t o documents.
	*
	* @return the number of a t o documents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getATODocumentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atoDocumentLocalService.getATODocumentsCount();
	}

	/**
	* Updates the a t o document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param atoDocument the a t o document
	* @return the a t o document that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.ATODocument updateATODocument(
		com.sambaash.platform.srv.startupprofile.model.ATODocument atoDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _atoDocumentLocalService.updateATODocument(atoDocument);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _atoDocumentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_atoDocumentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _atoDocumentLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByOrganizationId(
		long organizationId) {
		return _atoDocumentLocalService.findByOrganizationId(organizationId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ATODocument> findByOrganizationAndDocumentType(
		long organizationId, java.lang.String documentType) {
		return _atoDocumentLocalService.findByOrganizationAndDocumentType(organizationId,
			documentType);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ATODocumentLocalService getWrappedATODocumentLocalService() {
		return _atoDocumentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedATODocumentLocalService(
		ATODocumentLocalService atoDocumentLocalService) {
		_atoDocumentLocalService = atoDocumentLocalService;
	}

	@Override
	public ATODocumentLocalService getWrappedService() {
		return _atoDocumentLocalService;
	}

	@Override
	public void setWrappedService(
		ATODocumentLocalService atoDocumentLocalService) {
		_atoDocumentLocalService = atoDocumentLocalService;
	}

	private ATODocumentLocalService _atoDocumentLocalService;
}