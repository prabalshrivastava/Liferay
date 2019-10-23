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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service interface for CandidateMicroservice. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author glenn
 * @see CandidateMicroserviceLocalServiceUtil
 * @see com.sambaash.platform.srv.spmicroservice.service.base.CandidateMicroserviceLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spmicroservice.service.impl.CandidateMicroserviceLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CandidateMicroserviceLocalService extends BaseLocalService,
	InvokableLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CandidateMicroserviceLocalServiceUtil} to access the candidate microservice local service. Add custom service methods to {@link com.sambaash.platform.srv.spmicroservice.service.impl.CandidateMicroserviceLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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

	public com.liferay.portal.kernel.json.JSONObject validate(
		long scopeGroupId, com.liferay.portal.kernel.json.JSONObject candidate);

	public com.liferay.portal.kernel.json.JSONObject craete(long scopeGroupId,
		com.liferay.portal.kernel.json.JSONObject candidate);

	public com.liferay.portal.kernel.json.JSONObject update(long scopeGroupId,
		com.liferay.portal.kernel.json.JSONObject candidate,
		java.lang.String storageId);

	public com.liferay.portal.kernel.json.JSONObject retrieveCandidateProgrammePath(
		long scopeGroupId, java.lang.String candidateId,
		java.lang.String configJson);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getCandidateAllowedModules(
		long scopeGroupId, java.lang.Long candidateId,
		java.lang.String scheduleCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getCandidateSchedule(
		long scopeGroupId, java.lang.Long candidateId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getCandidateFailedModules(
		long scopeGroupId, java.lang.Long candidateId,
		java.lang.String scheduleCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasResults(long scopeGroupId,
		java.lang.String programmeCode, java.lang.Long candidateId);

	public com.liferay.portal.kernel.json.JSONArray allowedProgrammeScheduleToEnrol(
		long scopeGroupId, java.lang.Long candidateId);
}