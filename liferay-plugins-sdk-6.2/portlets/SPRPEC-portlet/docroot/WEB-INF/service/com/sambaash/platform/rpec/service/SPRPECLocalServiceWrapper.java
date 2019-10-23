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

package com.sambaash.platform.rpec.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPRPECLocalService}.
 *
 * @author gaurav.kapadiya
 * @see SPRPECLocalService
 * @generated
 */
public class SPRPECLocalServiceWrapper implements SPRPECLocalService,
	ServiceWrapper<SPRPECLocalService> {
	public SPRPECLocalServiceWrapper(SPRPECLocalService sprpecLocalService) {
		_sprpecLocalService = sprpecLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _sprpecLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_sprpecLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _sprpecLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.lang.String getCompetenceType(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _sprpecLocalService.getCompetenceType(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String getCompetenceSubjects(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _sprpecLocalService.getCompetenceSubjects(resourceRequest,
			resourceResponse);
	}

	@Override
	public void notifyByEmail() {
		_sprpecLocalService.notifyByEmail();
	}

	@Override
	public java.lang.String getGridData(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _sprpecLocalService.getGridData(resourceRequest, resourceResponse);
	}

	@Override
	public java.lang.String getElasticsearchData(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _sprpecLocalService.getElasticsearchData(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String getCompetenceSubjectsQuestions(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _sprpecLocalService.getCompetenceSubjectsQuestions(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String createRPECRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _sprpecLocalService.createRPECRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String createRemarks(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _sprpecLocalService.createRemarks(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String checkCompetencyProficiency(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _sprpecLocalService.checkCompetencyProficiency(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String updateRPECRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _sprpecLocalService.updateRPECRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String fetchRPECRemarks(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _sprpecLocalService.fetchRPECRemarks(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String updateRPECStatus(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _sprpecLocalService.updateRPECStatus(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String getUserType(java.lang.String canRole,
		java.lang.String relcRole, java.lang.String trainingRole,
		java.lang.String mentor, java.lang.Long userIdForRole) {
		return _sprpecLocalService.getUserType(canRole, relcRole, trainingRole,
			mentor, userIdForRole);
	}

	@Override
	public void exportRowToExcelFile(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		_sprpecLocalService.exportRowToExcelFile(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String getMicroserviceModelColumnTitleMap(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return _sprpecLocalService.getMicroserviceModelColumnTitleMap(resourceRequest,
			modelName);
	}

	@Override
	public java.util.List<java.lang.String> getMicroserviceModelColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return _sprpecLocalService.getMicroserviceModelColumnList(resourceRequest,
			modelName);
	}

	@Override
	public java.lang.String archiveRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _sprpecLocalService.archiveRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String candidateProfile(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _sprpecLocalService.candidateProfile(resourceRequest,
			resourceResponse);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getCandidateListOfMentor(
		long mentorId, long siteId) {
		return _sprpecLocalService.getCandidateListOfMentor(mentorId, siteId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getCandidateListOfTp(
		long mentorId, long siteId) {
		return _sprpecLocalService.getCandidateListOfTp(mentorId, siteId);
	}

	@Override
	public java.lang.String getCandidateListOfInternalUser(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _sprpecLocalService.getCandidateListOfInternalUser(resourceRequest,
			resourceResponse);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPRPECLocalService getWrappedSPRPECLocalService() {
		return _sprpecLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPRPECLocalService(
		SPRPECLocalService sprpecLocalService) {
		_sprpecLocalService = sprpecLocalService;
	}

	@Override
	public SPRPECLocalService getWrappedService() {
		return _sprpecLocalService;
	}

	@Override
	public void setWrappedService(SPRPECLocalService sprpecLocalService) {
		_sprpecLocalService = sprpecLocalService;
	}

	private SPRPECLocalService _sprpecLocalService;
}