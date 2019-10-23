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

package com.sambaash.platform.srv.spdynamicforms.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPDynamicFormsLocalService}.
 *
 * @author glenn
 * @see SPDynamicFormsLocalService
 * @generated
 */
public class SPDynamicFormsLocalServiceWrapper
	implements SPDynamicFormsLocalService,
		ServiceWrapper<SPDynamicFormsLocalService> {
	public SPDynamicFormsLocalServiceWrapper(
		SPDynamicFormsLocalService spDynamicFormsLocalService) {
		_spDynamicFormsLocalService = spDynamicFormsLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spDynamicFormsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spDynamicFormsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spDynamicFormsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject retrieveLoadParam(
		javax.portlet.RenderRequest renderRequest) {
		return _spDynamicFormsLocalService.retrieveLoadParam(renderRequest);
	}

	@Override
	public void handleLoadData(javax.portlet.ResourceRequest request,
		javax.portlet.ResourceResponse response) {
		_spDynamicFormsLocalService.handleLoadData(request, response);
	}

	@Override
	public void handlePersist(javax.portlet.ResourceRequest request,
		javax.portlet.ResourceResponse response) {
		_spDynamicFormsLocalService.handlePersist(request, response);
	}

	@Override
	public java.lang.String persistFormJsonData(
		com.liferay.portal.theme.ThemeDisplay themeDisplay, long formId,
		java.lang.Long formStorageId,
		com.liferay.portal.kernel.json.JSONObject formJsonData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spDynamicFormsLocalService.persistFormJsonData(themeDisplay,
			formId, formStorageId, formJsonData);
	}

	@Override
	public java.lang.String handlePersist(long userId, long formId,
		long formStorageId, java.lang.String jsonString) {
		return _spDynamicFormsLocalService.handlePersist(userId, formId,
			formStorageId, jsonString);
	}

	@Override
	public void handleFileUpload(javax.portlet.ResourceRequest request,
		javax.portlet.ResourceResponse response) {
		_spDynamicFormsLocalService.handleFileUpload(request, response);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPDynamicFormsLocalService getWrappedSPDynamicFormsLocalService() {
		return _spDynamicFormsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPDynamicFormsLocalService(
		SPDynamicFormsLocalService spDynamicFormsLocalService) {
		_spDynamicFormsLocalService = spDynamicFormsLocalService;
	}

	@Override
	public SPDynamicFormsLocalService getWrappedService() {
		return _spDynamicFormsLocalService;
	}

	@Override
	public void setWrappedService(
		SPDynamicFormsLocalService spDynamicFormsLocalService) {
		_spDynamicFormsLocalService = spDynamicFormsLocalService;
	}

	private SPDynamicFormsLocalService _spDynamicFormsLocalService;
}