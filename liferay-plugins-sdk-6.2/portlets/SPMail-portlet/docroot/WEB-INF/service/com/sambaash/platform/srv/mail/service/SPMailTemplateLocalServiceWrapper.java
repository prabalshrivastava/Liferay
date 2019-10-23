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
 * Provides a wrapper for {@link SPMailTemplateLocalService}.
 *
 * @author gauravvijayvergia
 * @see SPMailTemplateLocalService
 * @generated
 */
public class SPMailTemplateLocalServiceWrapper
	implements SPMailTemplateLocalService,
		ServiceWrapper<SPMailTemplateLocalService> {
	public SPMailTemplateLocalServiceWrapper(
		SPMailTemplateLocalService spMailTemplateLocalService) {
		_spMailTemplateLocalService = spMailTemplateLocalService;
	}

	/**
	* Adds the s p mail template to the database. Also notifies the appropriate model listeners.
	*
	* @param spMailTemplate the s p mail template
	* @return the s p mail template that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailTemplate addSPMailTemplate(
		com.sambaash.platform.srv.mail.model.SPMailTemplate spMailTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateLocalService.addSPMailTemplate(spMailTemplate);
	}

	/**
	* Creates a new s p mail template with the primary key. Does not add the s p mail template to the database.
	*
	* @param spMailTemplateId the primary key for the new s p mail template
	* @return the new s p mail template
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailTemplate createSPMailTemplate(
		long spMailTemplateId) {
		return _spMailTemplateLocalService.createSPMailTemplate(spMailTemplateId);
	}

	/**
	* Deletes the s p mail template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailTemplateId the primary key of the s p mail template
	* @return the s p mail template that was removed
	* @throws PortalException if a s p mail template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailTemplate deleteSPMailTemplate(
		long spMailTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateLocalService.deleteSPMailTemplate(spMailTemplateId);
	}

	/**
	* Deletes the s p mail template from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailTemplate the s p mail template
	* @return the s p mail template that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailTemplate deleteSPMailTemplate(
		com.sambaash.platform.srv.mail.model.SPMailTemplate spMailTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateLocalService.deleteSPMailTemplate(spMailTemplate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spMailTemplateLocalService.dynamicQuery();
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
		return _spMailTemplateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spMailTemplateLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spMailTemplateLocalService.dynamicQuery(dynamicQuery, start,
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
		return _spMailTemplateLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spMailTemplateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailTemplate fetchSPMailTemplate(
		long spMailTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateLocalService.fetchSPMailTemplate(spMailTemplateId);
	}

	/**
	* Returns the s p mail template with the primary key.
	*
	* @param spMailTemplateId the primary key of the s p mail template
	* @return the s p mail template
	* @throws PortalException if a s p mail template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailTemplate getSPMailTemplate(
		long spMailTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateLocalService.getSPMailTemplate(spMailTemplateId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p mail templates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail templates
	* @param end the upper bound of the range of s p mail templates (not inclusive)
	* @return the range of s p mail templates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplate> getSPMailTemplates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateLocalService.getSPMailTemplates(start, end);
	}

	/**
	* Returns the number of s p mail templates.
	*
	* @return the number of s p mail templates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPMailTemplatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateLocalService.getSPMailTemplatesCount();
	}

	/**
	* Updates the s p mail template in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spMailTemplate the s p mail template
	* @return the s p mail template that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailTemplate updateSPMailTemplate(
		com.sambaash.platform.srv.mail.model.SPMailTemplate spMailTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateLocalService.updateSPMailTemplate(spMailTemplate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spMailTemplateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spMailTemplateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spMailTemplateLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void addCustomSPMailTemplate(
		com.sambaash.platform.srv.mail.model.SPMailTemplate spMailTemplate) {
		_spMailTemplateLocalService.addCustomSPMailTemplate(spMailTemplate);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplate> findByparentTempalteId(
		long parentTempalteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateLocalService.findByparentTempalteId(parentTempalteId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplate> findByStatus(
		boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateLocalService.findByStatus(status);
	}

	@Override
	public com.sambaash.platform.model.MailMessage getMailMessage(
		java.lang.String parameter, long scopeGroupId, boolean hmtlFormat) {
		return _spMailTemplateLocalService.getMailMessage(parameter,
			scopeGroupId, hmtlFormat);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use
	* {@link com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil}
	* to access the s p mail template local service.
	*/
	@Override
	public com.sambaash.platform.srv.mail.model.SPMailTemplate getSPMailTemplate(
		java.lang.String parameter, long scopeGroupId) {
		return _spMailTemplateLocalService.getSPMailTemplate(parameter,
			scopeGroupId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailTemplate> getTemplates()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateLocalService.getTemplates();
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailTemplate getTemplateByName(
		java.lang.String templateName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateLocalService.getTemplateByName(templateName);
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailTemplate getTemplateByName(
		long productTypeId, long subProductTypeId, java.lang.String templateName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateLocalService.getTemplateByName(productTypeId,
			subProductTypeId, templateName);
	}

	@Override
	public void sendAdHocEmaills(java.lang.String userIdsStr, long templateId) {
		_spMailTemplateLocalService.sendAdHocEmaills(userIdsStr, templateId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPMailTemplateLocalService getWrappedSPMailTemplateLocalService() {
		return _spMailTemplateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPMailTemplateLocalService(
		SPMailTemplateLocalService spMailTemplateLocalService) {
		_spMailTemplateLocalService = spMailTemplateLocalService;
	}

	@Override
	public SPMailTemplateLocalService getWrappedService() {
		return _spMailTemplateLocalService;
	}

	@Override
	public void setWrappedService(
		SPMailTemplateLocalService spMailTemplateLocalService) {
		_spMailTemplateLocalService = spMailTemplateLocalService;
	}

	private SPMailTemplateLocalService _spMailTemplateLocalService;
}