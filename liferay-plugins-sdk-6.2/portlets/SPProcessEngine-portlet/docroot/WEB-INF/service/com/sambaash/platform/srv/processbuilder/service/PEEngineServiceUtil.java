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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for PEEngine. This utility wraps
 * {@link com.sambaash.platform.srv.processbuilder.service.impl.PEEngineServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author nareshchebolu
 * @see PEEngineService
 * @see com.sambaash.platform.srv.processbuilder.service.base.PEEngineServiceBaseImpl
 * @see com.sambaash.platform.srv.processbuilder.service.impl.PEEngineServiceImpl
 * @generated
 */
public class PEEngineServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.processbuilder.service.impl.PEEngineServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void runProcessEngineUsingFormId(long classNameId,
		long classPK, long processId, long formId, java.lang.String formData,
		java.util.Map<java.lang.String, java.lang.String[]> params) {
		getService()
			.runProcessEngineUsingFormId(classNameId, classPK, processId,
			formId, formData, params);
	}

	public static void runPEProductApp(long classNameId, long classPK,
		long processId, long formId, java.lang.String countryName,
		java.lang.String formData) {
		getService()
			.runPEProductApp(classNameId, classPK, processId, formId,
			countryName, formData);
	}

	public static void runPEProductAppDefaultEntity(long classNameId,
		long processId, long formId, java.lang.String countryName,
		java.lang.String formData) {
		getService()
			.runPEProductAppDefaultEntity(classNameId, processId, formId,
			countryName, formData);
	}

	public static java.lang.String helloWorld(java.lang.String worldName) {
		return getService().helloWorld(worldName);
	}

	public static java.lang.String helloWorld2(java.lang.String worldName) {
		return getService().helloWorld2(worldName);
	}

	public static com.liferay.portal.kernel.json.JSONObject runCheckForPreviousSubmissions(
		long loggedInUserId, java.lang.String emailAddress, long processId,
		long entityClassId, long entityId) {
		return getService()
				   .runCheckForPreviousSubmissions(loggedInUserId,
			emailAddress, processId, entityClassId, entityId);
	}

	public static com.liferay.portal.kernel.json.JSONObject fetchStateData(
		long processStateId) {
		return getService().fetchStateData(processStateId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getProcessDefinitions() {
		return getService().getProcessDefinitions();
	}

	public static com.liferay.portal.kernel.json.JSONArray getProcessStages() {
		return getService().getProcessStages();
	}

	public static com.liferay.portal.kernel.json.JSONArray getUserApplications(
		java.lang.String userEmail, long processId, long entityClassId,
		long entityId, int activeStatus) {
		return getService()
				   .getUserApplications(userEmail, processId, entityClassId,
			entityId, activeStatus);
	}

	public static void clearService() {
		_service = null;
	}

	public static PEEngineService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PEEngineService.class.getName());

			if (invokableService instanceof PEEngineService) {
				_service = (PEEngineService)invokableService;
			}
			else {
				_service = new PEEngineServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(PEEngineServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PEEngineService service) {
	}

	private static PEEngineService _service;
}