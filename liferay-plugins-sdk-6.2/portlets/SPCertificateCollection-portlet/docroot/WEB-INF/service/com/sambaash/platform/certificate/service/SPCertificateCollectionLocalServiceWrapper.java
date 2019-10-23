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

package com.sambaash.platform.certificate.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPCertificateCollectionLocalService}.
 *
 * @author keyur.kalariya
 * @see SPCertificateCollectionLocalService
 * @generated
 */
public class SPCertificateCollectionLocalServiceWrapper
	implements SPCertificateCollectionLocalService,
		ServiceWrapper<SPCertificateCollectionLocalService> {
	public SPCertificateCollectionLocalServiceWrapper(
		SPCertificateCollectionLocalService spCertificateCollectionLocalService) {
		_spCertificateCollectionLocalService = spCertificateCollectionLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spCertificateCollectionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spCertificateCollectionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spCertificateCollectionLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.lang.String convertToAPIModel(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelData, java.lang.String existingData)
		throws com.liferay.portal.kernel.json.JSONException {
		return _spCertificateCollectionLocalService.convertToAPIModel(resourceRequest,
			modelData, existingData);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject FormIOToModelJSON(
		javax.portlet.ResourceRequest resourceRequest,
		com.liferay.portal.kernel.json.JSONObject inp,
		com.liferay.portal.kernel.json.JSONObject jsonModelExistingData) {
		return _spCertificateCollectionLocalService.FormIOToModelJSON(resourceRequest,
			inp, jsonModelExistingData);
	}

	@Override
	public java.util.List<java.lang.String> getMicroserviceModelColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return _spCertificateCollectionLocalService.getMicroserviceModelColumnList(resourceRequest,
			modelName);
	}

	@Override
	public java.lang.String getElasticSearchListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spCertificateCollectionLocalService.getElasticSearchListing(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String scannedDataRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spCertificateCollectionLocalService.scannedDataRecord(resourceRequest,
			resourceResponse);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPCertificateCollectionLocalService getWrappedSPCertificateCollectionLocalService() {
		return _spCertificateCollectionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPCertificateCollectionLocalService(
		SPCertificateCollectionLocalService spCertificateCollectionLocalService) {
		_spCertificateCollectionLocalService = spCertificateCollectionLocalService;
	}

	@Override
	public SPCertificateCollectionLocalService getWrappedService() {
		return _spCertificateCollectionLocalService;
	}

	@Override
	public void setWrappedService(
		SPCertificateCollectionLocalService spCertificateCollectionLocalService) {
		_spCertificateCollectionLocalService = spCertificateCollectionLocalService;
	}

	private SPCertificateCollectionLocalService _spCertificateCollectionLocalService;
}