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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SPRPEC. This utility wraps
 * {@link com.sambaash.platform.rpec.service.impl.SPRPECLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gaurav.kapadiya
 * @see SPRPECLocalService
 * @see com.sambaash.platform.rpec.service.base.SPRPECLocalServiceBaseImpl
 * @see com.sambaash.platform.rpec.service.impl.SPRPECLocalServiceImpl
 * @generated
 */
public class SPRPECLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.rpec.service.impl.SPRPECLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static java.lang.String getCompetenceType(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().getCompetenceType(resourceRequest, resourceResponse);
	}

	public static java.lang.String getCompetenceSubjects(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService()
				   .getCompetenceSubjects(resourceRequest, resourceResponse);
	}

	public static void notifyByEmail() {
		getService().notifyByEmail();
	}

	public static java.lang.String getGridData(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().getGridData(resourceRequest, resourceResponse);
	}

	public static java.lang.String getElasticsearchData(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService()
				   .getElasticsearchData(resourceRequest, resourceResponse);
	}

	public static java.lang.String getCompetenceSubjectsQuestions(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService()
				   .getCompetenceSubjectsQuestions(resourceRequest,
			resourceResponse);
	}

	public static java.lang.String createRPECRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().createRPECRecord(resourceRequest, resourceResponse);
	}

	public static java.lang.String createRemarks(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().createRemarks(resourceRequest, resourceResponse);
	}

	public static java.lang.String checkCompetencyProficiency(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService()
				   .checkCompetencyProficiency(resourceRequest, resourceResponse);
	}

	public static java.lang.String updateRPECRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().updateRPECRecord(resourceRequest, resourceResponse);
	}

	public static java.lang.String fetchRPECRemarks(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().fetchRPECRemarks(resourceRequest, resourceResponse);
	}

	public static java.lang.String updateRPECStatus(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().updateRPECStatus(resourceRequest, resourceResponse);
	}

	public static java.lang.String getUserType(java.lang.String canRole,
		java.lang.String relcRole, java.lang.String trainingRole,
		java.lang.String mentor, java.lang.Long userIdForRole) {
		return getService()
				   .getUserType(canRole, relcRole, trainingRole, mentor,
			userIdForRole);
	}

	public static void exportRowToExcelFile(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		getService().exportRowToExcelFile(resourceRequest, resourceResponse);
	}

	public static java.lang.String getMicroserviceModelColumnTitleMap(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return getService()
				   .getMicroserviceModelColumnTitleMap(resourceRequest,
			modelName);
	}

	public static java.util.List<java.lang.String> getMicroserviceModelColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return getService()
				   .getMicroserviceModelColumnList(resourceRequest, modelName);
	}

	public static java.lang.String archiveRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().archiveRecord(resourceRequest, resourceResponse);
	}

	public static java.lang.String candidateProfile(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().candidateProfile(resourceRequest, resourceResponse);
	}

	public static com.liferay.portal.kernel.json.JSONArray getCandidateListOfMentor(
		long mentorId, long siteId) {
		return getService().getCandidateListOfMentor(mentorId, siteId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getCandidateListOfTp(
		long mentorId, long siteId) {
		return getService().getCandidateListOfTp(mentorId, siteId);
	}

	public static java.lang.String getCandidateListOfInternalUser(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService()
				   .getCandidateListOfInternalUser(resourceRequest,
			resourceResponse);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPRPECLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPRPECLocalService.class.getName());

			if (invokableLocalService instanceof SPRPECLocalService) {
				_service = (SPRPECLocalService)invokableLocalService;
			}
			else {
				_service = new SPRPECLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPRPECLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPRPECLocalService service) {
	}

	private static SPRPECLocalService _service;
}