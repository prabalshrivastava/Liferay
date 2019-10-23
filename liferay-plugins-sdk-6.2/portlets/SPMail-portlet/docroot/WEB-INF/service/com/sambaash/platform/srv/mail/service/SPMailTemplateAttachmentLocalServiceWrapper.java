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

package com.sambaash.platform.srv.mail.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPMailTemplateAttachmentLocalService}.
 *
 * @author gauravvijayvergia
 * @see SPMailTemplateAttachmentLocalService
 * @generated
 */
public class SPMailTemplateAttachmentLocalServiceWrapper
	implements SPMailTemplateAttachmentLocalService,
		ServiceWrapper<SPMailTemplateAttachmentLocalService> {
	public SPMailTemplateAttachmentLocalServiceWrapper(
		SPMailTemplateAttachmentLocalService spMailTemplateAttachmentLocalService) {
		_spMailTemplateAttachmentLocalService = spMailTemplateAttachmentLocalService;
	}

	/**
	* Adds the s p mail template attachment to the database. Also notifies the appropriate model listeners.
	*
	* @param spMailTemplateAttachment the s p mail template attachment
	* @return the s p mail template attachment that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment addSPMailTemplateAttachment(
		com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment spMailTemplateAttachment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateAttachmentLocalService.addSPMailTemplateAttachment(spMailTemplateAttachment);
	}

	/**
	* Creates a new s p mail template attachment with the primary key. Does not add the s p mail template attachment to the database.
	*
	* @param spTemplateAttachmentId the primary key for the new s p mail template attachment
	* @return the new s p mail template attachment
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment createSPMailTemplateAttachment(
		long spTemplateAttachmentId) {
		return _spMailTemplateAttachmentLocalService.createSPMailTemplateAttachment(spTemplateAttachmentId);
	}

	/**
	* Deletes the s p mail template attachment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spTemplateAttachmentId the primary key of the s p mail template attachment
	* @return the s p mail template attachment that was removed
	* @throws PortalException if a s p mail template attachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment deleteSPMailTemplateAttachment(
		long spTemplateAttachmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateAttachmentLocalService.deleteSPMailTemplateAttachment(spTemplateAttachmentId);
	}

	/**
	* Deletes the s p mail template attachment from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailTemplateAttachment the s p mail template attachment
	* @return the s p mail template attachment that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment deleteSPMailTemplateAttachment(
		com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment spMailTemplateAttachment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateAttachmentLocalService.deleteSPMailTemplateAttachment(spMailTemplateAttachment);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spMailTemplateAttachmentLocalService.dynamicQuery();
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
		return _spMailTemplateAttachmentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spMailTemplateAttachmentLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spMailTemplateAttachmentLocalService.dynamicQuery(dynamicQuery,
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
		return _spMailTemplateAttachmentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spMailTemplateAttachmentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment fetchSPMailTemplateAttachment(
		long spTemplateAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateAttachmentLocalService.fetchSPMailTemplateAttachment(spTemplateAttachmentId);
	}

	/**
	* Returns the s p mail template attachment with the primary key.
	*
	* @param spTemplateAttachmentId the primary key of the s p mail template attachment
	* @return the s p mail template attachment
	* @throws PortalException if a s p mail template attachment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment getSPMailTemplateAttachment(
		long spTemplateAttachmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateAttachmentLocalService.getSPMailTemplateAttachment(spTemplateAttachmentId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateAttachmentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p mail template attachments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail template attachments
	* @param end the upper bound of the range of s p mail template attachments (not inclusive)
	* @return the range of s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> getSPMailTemplateAttachments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateAttachmentLocalService.getSPMailTemplateAttachments(start,
			end);
	}

	/**
	* Returns the number of s p mail template attachments.
	*
	* @return the number of s p mail template attachments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPMailTemplateAttachmentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateAttachmentLocalService.getSPMailTemplateAttachmentsCount();
	}

	/**
	* Updates the s p mail template attachment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spMailTemplateAttachment the s p mail template attachment
	* @return the s p mail template attachment that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment updateSPMailTemplateAttachment(
		com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment spMailTemplateAttachment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateAttachmentLocalService.updateSPMailTemplateAttachment(spMailTemplateAttachment);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spMailTemplateAttachmentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spMailTemplateAttachmentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spMailTemplateAttachmentLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link com.sambaash.platform.srv.mail.service.SPMailTemplateAttachmentLocalServiceUtil} to access the s p mail template attachment local service.
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findByTemplateId(
		long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateAttachmentLocalService.findByTemplateId(templateId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findByfileEntryId(
		long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateAttachmentLocalService.findByfileEntryId(fileEntryId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> findByTemplateIdFileEntryId(
		long templateId, long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateAttachmentLocalService.findByTemplateIdFileEntryId(templateId,
			fileEntryId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPMailTemplateAttachmentLocalService getWrappedSPMailTemplateAttachmentLocalService() {
		return _spMailTemplateAttachmentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPMailTemplateAttachmentLocalService(
		SPMailTemplateAttachmentLocalService spMailTemplateAttachmentLocalService) {
		_spMailTemplateAttachmentLocalService = spMailTemplateAttachmentLocalService;
	}

	@Override
	public SPMailTemplateAttachmentLocalService getWrappedService() {
		return _spMailTemplateAttachmentLocalService;
	}

	@Override
	public void setWrappedService(
		SPMailTemplateAttachmentLocalService spMailTemplateAttachmentLocalService) {
		_spMailTemplateAttachmentLocalService = spMailTemplateAttachmentLocalService;
	}

	private SPMailTemplateAttachmentLocalService _spMailTemplateAttachmentLocalService;
}