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
 * Provides a wrapper for {@link PEEngineService}.
 *
 * @author nareshchebolu
 * @see PEEngineService
 * @generated
 */
public class PEEngineServiceWrapper implements PEEngineService,
	ServiceWrapper<PEEngineService> {
	public PEEngineServiceWrapper(PEEngineService peEngineService) {
		_peEngineService = peEngineService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _peEngineService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_peEngineService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _peEngineService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public void runProcessEngineUsingFormId(long classNameId, long classPK,
		long processId, long formId, java.lang.String formData,
		java.util.Map<java.lang.String, java.lang.String[]> params) {
		_peEngineService.runProcessEngineUsingFormId(classNameId, classPK,
			processId, formId, formData, params);
	}

	@Override
	public void runPEProductApp(long classNameId, long classPK, long processId,
		long formId, java.lang.String countryName, java.lang.String formData) {
		_peEngineService.runPEProductApp(classNameId, classPK, processId,
			formId, countryName, formData);
	}

	@Override
	public void runPEProductAppDefaultEntity(long classNameId, long processId,
		long formId, java.lang.String countryName, java.lang.String formData) {
		_peEngineService.runPEProductAppDefaultEntity(classNameId, processId,
			formId, countryName, formData);
	}

	@Override
	public java.lang.String helloWorld(java.lang.String worldName) {
		return _peEngineService.helloWorld(worldName);
	}

	@Override
	public java.lang.String helloWorld2(java.lang.String worldName) {
		return _peEngineService.helloWorld2(worldName);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject runCheckForPreviousSubmissions(
		long loggedInUserId, java.lang.String emailAddress, long processId,
		long entityClassId, long entityId) {
		return _peEngineService.runCheckForPreviousSubmissions(loggedInUserId,
			emailAddress, processId, entityClassId, entityId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject fetchStateData(
		long processStateId) {
		return _peEngineService.fetchStateData(processStateId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getProcessDefinitions() {
		return _peEngineService.getProcessDefinitions();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getProcessStages() {
		return _peEngineService.getProcessStages();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getUserApplications(
		java.lang.String userEmail, long processId, long entityClassId,
		long entityId, int activeStatus) {
		return _peEngineService.getUserApplications(userEmail, processId,
			entityClassId, entityId, activeStatus);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PEEngineService getWrappedPEEngineService() {
		return _peEngineService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPEEngineService(PEEngineService peEngineService) {
		_peEngineService = peEngineService;
	}

	@Override
	public PEEngineService getWrappedService() {
		return _peEngineService;
	}

	@Override
	public void setWrappedService(PEEngineService peEngineService) {
		_peEngineService = peEngineService;
	}

	private PEEngineService _peEngineService;
}