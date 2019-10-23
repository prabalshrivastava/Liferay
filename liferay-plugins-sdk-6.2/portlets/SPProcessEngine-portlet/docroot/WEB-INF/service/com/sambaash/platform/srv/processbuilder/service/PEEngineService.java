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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for PEEngine. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author nareshchebolu
 * @see PEEngineServiceUtil
 * @see com.sambaash.platform.srv.processbuilder.service.base.PEEngineServiceBaseImpl
 * @see com.sambaash.platform.srv.processbuilder.service.impl.PEEngineServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface PEEngineService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PEEngineServiceUtil} to access the p e engine remote service. Add custom service methods to {@link com.sambaash.platform.srv.processbuilder.service.impl.PEEngineServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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

	public void runProcessEngineUsingFormId(long classNameId, long classPK,
		long processId, long formId, java.lang.String formData,
		java.util.Map<java.lang.String, java.lang.String[]> params);

	public void runPEProductApp(long classNameId, long classPK, long processId,
		long formId, java.lang.String countryName, java.lang.String formData);

	public void runPEProductAppDefaultEntity(long classNameId, long processId,
		long formId, java.lang.String countryName, java.lang.String formData);

	public java.lang.String helloWorld(java.lang.String worldName);

	public java.lang.String helloWorld2(java.lang.String worldName);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public com.liferay.portal.kernel.json.JSONObject runCheckForPreviousSubmissions(
		long loggedInUserId, java.lang.String emailAddress, long processId,
		long entityClassId, long entityId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONObject fetchStateData(
		long processStateId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getProcessDefinitions();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getProcessStages();

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getUserApplications(
		java.lang.String userEmail, long processId, long entityClassId,
		long entityId, int activeStatus);
}