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

package com.sambaash.platform.srv.template.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPTemplateLocalService}.
 *
 * @author WattabyteIT
 * @see SPTemplateLocalService
 * @generated
 */
public class SPTemplateLocalServiceWrapper implements SPTemplateLocalService,
	ServiceWrapper<SPTemplateLocalService> {
	public SPTemplateLocalServiceWrapper(
		SPTemplateLocalService spTemplateLocalService) {
		_spTemplateLocalService = spTemplateLocalService;
	}

	/**
	* Adds the s p template to the database. Also notifies the appropriate model listeners.
	*
	* @param spTemplate the s p template
	* @return the s p template that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.template.model.SPTemplate addSPTemplate(
		com.sambaash.platform.srv.template.model.SPTemplate spTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spTemplateLocalService.addSPTemplate(spTemplate);
	}

	/**
	* Creates a new s p template with the primary key. Does not add the s p template to the database.
	*
	* @param spTemplateId the primary key for the new s p template
	* @return the new s p template
	*/
	@Override
	public com.sambaash.platform.srv.template.model.SPTemplate createSPTemplate(
		long spTemplateId) {
		return _spTemplateLocalService.createSPTemplate(spTemplateId);
	}

	/**
	* Deletes the s p template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spTemplateId the primary key of the s p template
	* @return the s p template that was removed
	* @throws PortalException if a s p template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.template.model.SPTemplate deleteSPTemplate(
		long spTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spTemplateLocalService.deleteSPTemplate(spTemplateId);
	}

	/**
	* Deletes the s p template from the database. Also notifies the appropriate model listeners.
	*
	* @param spTemplate the s p template
	* @return the s p template that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.template.model.SPTemplate deleteSPTemplate(
		com.sambaash.platform.srv.template.model.SPTemplate spTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spTemplateLocalService.deleteSPTemplate(spTemplate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spTemplateLocalService.dynamicQuery();
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
		return _spTemplateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spTemplateLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spTemplateLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _spTemplateLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spTemplateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.template.model.SPTemplate fetchSPTemplate(
		long spTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spTemplateLocalService.fetchSPTemplate(spTemplateId);
	}

	/**
	* Returns the s p template with the matching UUID and company.
	*
	* @param uuid the s p template's UUID
	* @param companyId the primary key of the company
	* @return the matching s p template, or <code>null</code> if a matching s p template could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.template.model.SPTemplate fetchSPTemplateByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spTemplateLocalService.fetchSPTemplateByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the s p template matching the UUID and group.
	*
	* @param uuid the s p template's UUID
	* @param groupId the primary key of the group
	* @return the matching s p template, or <code>null</code> if a matching s p template could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.template.model.SPTemplate fetchSPTemplateByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spTemplateLocalService.fetchSPTemplateByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the s p template with the primary key.
	*
	* @param spTemplateId the primary key of the s p template
	* @return the s p template
	* @throws PortalException if a s p template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.template.model.SPTemplate getSPTemplate(
		long spTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spTemplateLocalService.getSPTemplate(spTemplateId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spTemplateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the s p template with the matching UUID and company.
	*
	* @param uuid the s p template's UUID
	* @param companyId the primary key of the company
	* @return the matching s p template
	* @throws PortalException if a matching s p template could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.template.model.SPTemplate getSPTemplateByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spTemplateLocalService.getSPTemplateByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the s p template matching the UUID and group.
	*
	* @param uuid the s p template's UUID
	* @param groupId the primary key of the group
	* @return the matching s p template
	* @throws PortalException if a matching s p template could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.template.model.SPTemplate getSPTemplateByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spTemplateLocalService.getSPTemplateByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the s p templates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p templates
	* @param end the upper bound of the range of s p templates (not inclusive)
	* @return the range of s p templates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.template.model.SPTemplate> getSPTemplates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spTemplateLocalService.getSPTemplates(start, end);
	}

	/**
	* Returns the number of s p templates.
	*
	* @return the number of s p templates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPTemplatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spTemplateLocalService.getSPTemplatesCount();
	}

	/**
	* Updates the s p template in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spTemplate the s p template
	* @return the s p template that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.template.model.SPTemplate updateSPTemplate(
		com.sambaash.platform.srv.template.model.SPTemplate spTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spTemplateLocalService.updateSPTemplate(spTemplate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spTemplateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spTemplateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spTemplateLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.template.model.SPTemplate> findByTemplateName(
		java.lang.String templateName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spTemplateLocalService.findByTemplateName(templateName);
	}

	@Override
	public java.util.List getAllTemplates(java.lang.String cur,
		java.lang.String delta) {
		return _spTemplateLocalService.getAllTemplates(cur, delta);
	}

	@Override
	public int getAllTemplatesCount() {
		return _spTemplateLocalService.getAllTemplatesCount();
	}

	@Override
	public java.util.List getTemplateDetail(long templateId) {
		return _spTemplateLocalService.getTemplateDetail(templateId);
	}

	@Override
	public java.util.List getTemplateDetail(java.lang.String templateName) {
		return _spTemplateLocalService.getTemplateDetail(templateName);
	}

	@Override
	public boolean deleteTemplateComponents(long templateId) {
		return _spTemplateLocalService.deleteTemplateComponents(templateId);
	}

	@Override
	public void createTemplate(javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		_spTemplateLocalService.createTemplate(resourceRequest, resourceResponse);
	}

	@Override
	public void deleteTemplate(javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		_spTemplateLocalService.deleteTemplate(resourceRequest, resourceResponse);
	}

	@Override
	public void updateTemplate(javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		_spTemplateLocalService.updateTemplate(resourceRequest, resourceResponse);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPTemplateLocalService getWrappedSPTemplateLocalService() {
		return _spTemplateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPTemplateLocalService(
		SPTemplateLocalService spTemplateLocalService) {
		_spTemplateLocalService = spTemplateLocalService;
	}

	@Override
	public SPTemplateLocalService getWrappedService() {
		return _spTemplateLocalService;
	}

	@Override
	public void setWrappedService(SPTemplateLocalService spTemplateLocalService) {
		_spTemplateLocalService = spTemplateLocalService;
	}

	private SPTemplateLocalService _spTemplateLocalService;
}