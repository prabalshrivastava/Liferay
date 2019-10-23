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

package com.sambaash.platform.srv.spmicroservice.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FormsMicroserviceLocalService}.
 *
 * @author glenn
 * @see FormsMicroserviceLocalService
 * @generated
 */
public class FormsMicroserviceLocalServiceWrapper
	implements FormsMicroserviceLocalService,
		ServiceWrapper<FormsMicroserviceLocalService> {
	public FormsMicroserviceLocalServiceWrapper(
		FormsMicroserviceLocalService formsMicroserviceLocalService) {
		_formsMicroserviceLocalService = formsMicroserviceLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _formsMicroserviceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_formsMicroserviceLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _formsMicroserviceLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getFormListing() {
		return _formsMicroserviceLocalService.getFormListing();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getForm(long formId) {
		return _formsMicroserviceLocalService.getForm(formId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getFormFields(long formId,
		boolean includeLayout, boolean fullInfo) {
		return _formsMicroserviceLocalService.getFormFields(formId,
			includeLayout, fullInfo);
	}

	@Override
	public void synchroniseRole(long groupId, long roleId,
		java.lang.String roleName) {
		_formsMicroserviceLocalService.synchroniseRole(groupId, roleId, roleName);
	}

	@Override
	public void addFormEvent(java.lang.String action,
		java.lang.String description) {
		_formsMicroserviceLocalService.addFormEvent(action, description);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FormsMicroserviceLocalService getWrappedFormsMicroserviceLocalService() {
		return _formsMicroserviceLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFormsMicroserviceLocalService(
		FormsMicroserviceLocalService formsMicroserviceLocalService) {
		_formsMicroserviceLocalService = formsMicroserviceLocalService;
	}

	@Override
	public FormsMicroserviceLocalService getWrappedService() {
		return _formsMicroserviceLocalService;
	}

	@Override
	public void setWrappedService(
		FormsMicroserviceLocalService formsMicroserviceLocalService) {
		_formsMicroserviceLocalService = formsMicroserviceLocalService;
	}

	private FormsMicroserviceLocalService _formsMicroserviceLocalService;
}