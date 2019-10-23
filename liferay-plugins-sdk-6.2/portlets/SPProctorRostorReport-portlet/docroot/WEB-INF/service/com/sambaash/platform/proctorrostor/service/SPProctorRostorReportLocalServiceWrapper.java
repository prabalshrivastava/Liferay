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

package com.sambaash.platform.proctorrostor.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPProctorRostorReportLocalService}.
 *
 * @author gaurav.kapadiya
 * @see SPProctorRostorReportLocalService
 * @generated
 */
public class SPProctorRostorReportLocalServiceWrapper
	implements SPProctorRostorReportLocalService,
		ServiceWrapper<SPProctorRostorReportLocalService> {
	public SPProctorRostorReportLocalServiceWrapper(
		SPProctorRostorReportLocalService spProctorRostorReportLocalService) {
		_spProctorRostorReportLocalService = spProctorRostorReportLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spProctorRostorReportLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spProctorRostorReportLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spProctorRostorReportLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.lang.String getFilterColumnHeader(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spProctorRostorReportLocalService.getFilterColumnHeader(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.util.List<java.lang.String> getMicroserviceModelFilterColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return _spProctorRostorReportLocalService.getMicroserviceModelFilterColumnList(resourceRequest,
			modelName);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getMicroserviceModelColumnTitleMap(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return _spProctorRostorReportLocalService.getMicroserviceModelColumnTitleMap(resourceRequest,
			modelName);
	}

	@Override
	public void saveCurrentQuery(java.lang.String query,
		javax.portlet.ResourceRequest resourceRequest) {
		_spProctorRostorReportLocalService.saveCurrentQuery(query,
			resourceRequest);
	}

	@Override
	public void exportPdf(javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		_spProctorRostorReportLocalService.exportPdf(resourceRequest,
			resourceResponse);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPProctorRostorReportLocalService getWrappedSPProctorRostorReportLocalService() {
		return _spProctorRostorReportLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPProctorRostorReportLocalService(
		SPProctorRostorReportLocalService spProctorRostorReportLocalService) {
		_spProctorRostorReportLocalService = spProctorRostorReportLocalService;
	}

	@Override
	public SPProctorRostorReportLocalService getWrappedService() {
		return _spProctorRostorReportLocalService;
	}

	@Override
	public void setWrappedService(
		SPProctorRostorReportLocalService spProctorRostorReportLocalService) {
		_spProctorRostorReportLocalService = spProctorRostorReportLocalService;
	}

	private SPProctorRostorReportLocalService _spProctorRostorReportLocalService;
}