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

package com.sambaash.platform.srv.processbuilder.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FormBuilderService}.
 *
 * @author nareshchebolu
 * @see FormBuilderService
 * @generated
 */
public class FormBuilderServiceWrapper implements FormBuilderService,
	ServiceWrapper<FormBuilderService> {
	public FormBuilderServiceWrapper(FormBuilderService formBuilderService) {
		_formBuilderService = formBuilderService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _formBuilderService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_formBuilderService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _formBuilderService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.lang.String getFormSchema(long userId, long formId) {
		return _formBuilderService.getFormSchema(userId, formId);
	}

	@Override
	public java.lang.String getFormSchemas(long userId,
		java.lang.String formIdsCommaSeparated) {
		return _formBuilderService.getFormSchemas(userId, formIdsCommaSeparated);
	}

	@Override
	public java.lang.String getFormsList(long userId) {
		return _formBuilderService.getFormsList(userId);
	}

	@Override
	public java.lang.String getV2FormsList() {
		return _formBuilderService.getV2FormsList();
	}

	@Override
	public java.lang.String getV2FormsSchema(long userId, long formId) {
		return _formBuilderService.getV2FormsSchema(userId, formId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getRoles(long companyId) {
		return _formBuilderService.getRoles(companyId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FormBuilderService getWrappedFormBuilderService() {
		return _formBuilderService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFormBuilderService(
		FormBuilderService formBuilderService) {
		_formBuilderService = formBuilderService;
	}

	@Override
	public FormBuilderService getWrappedService() {
		return _formBuilderService;
	}

	@Override
	public void setWrappedService(FormBuilderService formBuilderService) {
		_formBuilderService = formBuilderService;
	}

	private FormBuilderService _formBuilderService;
}