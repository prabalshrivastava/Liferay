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

package com.sambaash.platform.mastertimetable.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPMasterTimetableLocalService}.
 *
 * @author gaurav.kapadiya
 * @see SPMasterTimetableLocalService
 * @generated
 */
public class SPMasterTimetableLocalServiceWrapper
	implements SPMasterTimetableLocalService,
		ServiceWrapper<SPMasterTimetableLocalService> {
	public SPMasterTimetableLocalServiceWrapper(
		SPMasterTimetableLocalService spMasterTimetableLocalService) {
		_spMasterTimetableLocalService = spMasterTimetableLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spMasterTimetableLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spMasterTimetableLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spMasterTimetableLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.lang.String getFilterColumnHeader(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spMasterTimetableLocalService.getFilterColumnHeader(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.util.List<java.lang.String> getMicroserviceModelFilterColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return _spMasterTimetableLocalService.getMicroserviceModelFilterColumnList(resourceRequest,
			modelName);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getMicroserviceModelColumnTitleMap(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return _spMasterTimetableLocalService.getMicroserviceModelColumnTitleMap(resourceRequest,
			modelName);
	}

	@Override
	public java.lang.String getElasticSearchListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spMasterTimetableLocalService.getElasticSearchListing(resourceRequest,
			resourceResponse);
	}

	@Override
	public void saveCurrentQuery(java.lang.String query,
		javax.portlet.ResourceRequest resourceRequest) {
		_spMasterTimetableLocalService.saveCurrentQuery(query, resourceRequest);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPMasterTimetableLocalService getWrappedSPMasterTimetableLocalService() {
		return _spMasterTimetableLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPMasterTimetableLocalService(
		SPMasterTimetableLocalService spMasterTimetableLocalService) {
		_spMasterTimetableLocalService = spMasterTimetableLocalService;
	}

	@Override
	public SPMasterTimetableLocalService getWrappedService() {
		return _spMasterTimetableLocalService;
	}

	@Override
	public void setWrappedService(
		SPMasterTimetableLocalService spMasterTimetableLocalService) {
		_spMasterTimetableLocalService = spMasterTimetableLocalService;
	}

	private SPMasterTimetableLocalService _spMasterTimetableLocalService;
}