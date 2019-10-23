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

package com.sambaash.platform.invigilatormanagement.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service interface for Invigilator. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Himadri
 * @see InvigilatorLocalServiceUtil
 * @see com.sambaash.platform.invigilatormanagement.service.base.InvigilatorLocalServiceBaseImpl
 * @see com.sambaash.platform.invigilatormanagement.service.impl.InvigilatorLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface InvigilatorLocalService extends BaseLocalService,
	InvokableLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InvigilatorLocalServiceUtil} to access the invigilator local service. Add custom service methods to {@link com.sambaash.platform.invigilatormanagement.service.impl.InvigilatorLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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
	public java.util.List<java.lang.String> getMicroserviceModelFilterColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUniqueList(
		javax.portlet.ResourceRequest resourceRequest);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getScheduleList(
		javax.portlet.ResourceRequest resourceRequest);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getPastAppointmentList(
		javax.portlet.ResourceRequest resourceRequest);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<java.lang.String, java.lang.String> getMicroserviceModelColumnTitleMap(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getFilterColumnHeader(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String fetchUpcommingFacilitySchedul(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getGroupNameHeader(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUniqueData(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	public java.lang.String updateAppointmentStatus(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	public java.lang.String notifyInvigilator(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	public void sendNewUserLoginDetailsEmail(
		com.liferay.portal.model.User user, java.lang.String templateName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getPriceScheme(
		javax.portlet.ResourceRequest resourceRequest,
		com.liferay.portal.kernel.json.JSONObject appointData);
}