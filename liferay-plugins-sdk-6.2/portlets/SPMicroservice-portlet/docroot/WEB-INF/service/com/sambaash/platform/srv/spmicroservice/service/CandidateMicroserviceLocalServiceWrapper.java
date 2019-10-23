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
 * Provides a wrapper for {@link CandidateMicroserviceLocalService}.
 *
 * @author glenn
 * @see CandidateMicroserviceLocalService
 * @generated
 */
public class CandidateMicroserviceLocalServiceWrapper
	implements CandidateMicroserviceLocalService,
		ServiceWrapper<CandidateMicroserviceLocalService> {
	public CandidateMicroserviceLocalServiceWrapper(
		CandidateMicroserviceLocalService candidateMicroserviceLocalService) {
		_candidateMicroserviceLocalService = candidateMicroserviceLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _candidateMicroserviceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_candidateMicroserviceLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _candidateMicroserviceLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject validate(
		long scopeGroupId, com.liferay.portal.kernel.json.JSONObject candidate) {
		return _candidateMicroserviceLocalService.validate(scopeGroupId,
			candidate);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject craete(long scopeGroupId,
		com.liferay.portal.kernel.json.JSONObject candidate) {
		return _candidateMicroserviceLocalService.craete(scopeGroupId, candidate);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject update(long scopeGroupId,
		com.liferay.portal.kernel.json.JSONObject candidate,
		java.lang.String storageId) {
		return _candidateMicroserviceLocalService.update(scopeGroupId,
			candidate, storageId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject retrieveCandidateProgrammePath(
		long scopeGroupId, java.lang.String candidateId,
		java.lang.String configJson) {
		return _candidateMicroserviceLocalService.retrieveCandidateProgrammePath(scopeGroupId,
			candidateId, configJson);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getCandidateAllowedModules(
		long scopeGroupId, java.lang.Long candidateId,
		java.lang.String scheduleCode) {
		return _candidateMicroserviceLocalService.getCandidateAllowedModules(scopeGroupId,
			candidateId, scheduleCode);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getCandidateSchedule(
		long scopeGroupId, java.lang.Long candidateId) {
		return _candidateMicroserviceLocalService.getCandidateSchedule(scopeGroupId,
			candidateId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getCandidateFailedModules(
		long scopeGroupId, java.lang.Long candidateId,
		java.lang.String scheduleCode) {
		return _candidateMicroserviceLocalService.getCandidateFailedModules(scopeGroupId,
			candidateId, scheduleCode);
	}

	@Override
	public boolean hasResults(long scopeGroupId,
		java.lang.String programmeCode, java.lang.Long candidateId) {
		return _candidateMicroserviceLocalService.hasResults(scopeGroupId,
			programmeCode, candidateId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray allowedProgrammeScheduleToEnrol(
		long scopeGroupId, java.lang.Long candidateId) {
		return _candidateMicroserviceLocalService.allowedProgrammeScheduleToEnrol(scopeGroupId,
			candidateId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CandidateMicroserviceLocalService getWrappedCandidateMicroserviceLocalService() {
		return _candidateMicroserviceLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCandidateMicroserviceLocalService(
		CandidateMicroserviceLocalService candidateMicroserviceLocalService) {
		_candidateMicroserviceLocalService = candidateMicroserviceLocalService;
	}

	@Override
	public CandidateMicroserviceLocalService getWrappedService() {
		return _candidateMicroserviceLocalService;
	}

	@Override
	public void setWrappedService(
		CandidateMicroserviceLocalService candidateMicroserviceLocalService) {
		_candidateMicroserviceLocalService = candidateMicroserviceLocalService;
	}

	private CandidateMicroserviceLocalService _candidateMicroserviceLocalService;
}