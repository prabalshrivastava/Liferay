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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for CandidateMicroservice. This utility wraps
 * {@link com.sambaash.platform.srv.spmicroservice.service.impl.CandidateMicroserviceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author glenn
 * @see CandidateMicroserviceLocalService
 * @see com.sambaash.platform.srv.spmicroservice.service.base.CandidateMicroserviceLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spmicroservice.service.impl.CandidateMicroserviceLocalServiceImpl
 * @generated
 */
public class CandidateMicroserviceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spmicroservice.service.impl.CandidateMicroserviceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.liferay.portal.kernel.json.JSONObject validate(
		long scopeGroupId, com.liferay.portal.kernel.json.JSONObject candidate) {
		return getService().validate(scopeGroupId, candidate);
	}

	public static com.liferay.portal.kernel.json.JSONObject craete(
		long scopeGroupId, com.liferay.portal.kernel.json.JSONObject candidate) {
		return getService().craete(scopeGroupId, candidate);
	}

	public static com.liferay.portal.kernel.json.JSONObject update(
		long scopeGroupId, com.liferay.portal.kernel.json.JSONObject candidate,
		java.lang.String storageId) {
		return getService().update(scopeGroupId, candidate, storageId);
	}

	public static com.liferay.portal.kernel.json.JSONObject retrieveCandidateProgrammePath(
		long scopeGroupId, java.lang.String candidateId,
		java.lang.String configJson) {
		return getService()
				   .retrieveCandidateProgrammePath(scopeGroupId, candidateId,
			configJson);
	}

	public static com.liferay.portal.kernel.json.JSONArray getCandidateAllowedModules(
		long scopeGroupId, java.lang.Long candidateId,
		java.lang.String scheduleCode) {
		return getService()
				   .getCandidateAllowedModules(scopeGroupId, candidateId,
			scheduleCode);
	}

	public static com.liferay.portal.kernel.json.JSONArray getCandidateSchedule(
		long scopeGroupId, java.lang.Long candidateId) {
		return getService().getCandidateSchedule(scopeGroupId, candidateId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getCandidateFailedModules(
		long scopeGroupId, java.lang.Long candidateId,
		java.lang.String scheduleCode) {
		return getService()
				   .getCandidateFailedModules(scopeGroupId, candidateId,
			scheduleCode);
	}

	public static boolean hasResults(long scopeGroupId,
		java.lang.String programmeCode, java.lang.Long candidateId) {
		return getService().hasResults(scopeGroupId, programmeCode, candidateId);
	}

	public static com.liferay.portal.kernel.json.JSONArray allowedProgrammeScheduleToEnrol(
		long scopeGroupId, java.lang.Long candidateId) {
		return getService()
				   .allowedProgrammeScheduleToEnrol(scopeGroupId, candidateId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CandidateMicroserviceLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CandidateMicroserviceLocalService.class.getName());

			if (invokableLocalService instanceof CandidateMicroserviceLocalService) {
				_service = (CandidateMicroserviceLocalService)invokableLocalService;
			}
			else {
				_service = new CandidateMicroserviceLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CandidateMicroserviceLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CandidateMicroserviceLocalService service) {
	}

	private static CandidateMicroserviceLocalService _service;
}