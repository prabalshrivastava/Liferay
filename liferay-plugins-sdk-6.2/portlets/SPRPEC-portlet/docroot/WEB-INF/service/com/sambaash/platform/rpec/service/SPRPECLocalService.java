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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service interface for SPRPEC. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author gaurav.kapadiya
 * @see SPRPECLocalServiceUtil
 * @see com.sambaash.platform.rpec.service.base.SPRPECLocalServiceBaseImpl
 * @see com.sambaash.platform.rpec.service.impl.SPRPECLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SPRPECLocalService extends BaseLocalService,
	InvokableLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPRPECLocalServiceUtil} to access the s p r p e c local service. Add custom service methods to {@link com.sambaash.platform.rpec.service.impl.SPRPECLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getCompetenceType(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getCompetenceSubjects(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	public void notifyByEmail();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getGridData(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getElasticsearchData(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getCompetenceSubjectsQuestions(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	public java.lang.String createRPECRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	public java.lang.String createRemarks(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	public java.lang.String checkCompetencyProficiency(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	public java.lang.String updateRPECRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String fetchRPECRemarks(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	public java.lang.String updateRPECStatus(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUserType(java.lang.String canRole,
		java.lang.String relcRole, java.lang.String trainingRole,
		java.lang.String mentor, java.lang.Long userIdForRole);

	public void exportRowToExcelFile(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getMicroserviceModelColumnTitleMap(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.lang.String> getMicroserviceModelColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName);

	public java.lang.String archiveRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	public java.lang.String candidateProfile(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getCandidateListOfMentor(
		long mentorId, long siteId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getCandidateListOfTp(
		long mentorId, long siteId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getCandidateListOfInternalUser(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);
}