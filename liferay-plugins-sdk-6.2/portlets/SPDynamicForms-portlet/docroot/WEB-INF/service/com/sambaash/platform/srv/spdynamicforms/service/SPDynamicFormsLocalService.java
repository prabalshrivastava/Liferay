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

package com.sambaash.platform.srv.spdynamicforms.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service interface for SPDynamicForms. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author glenn
 * @see SPDynamicFormsLocalServiceUtil
 * @see com.sambaash.platform.srv.spdynamicforms.service.base.SPDynamicFormsLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spdynamicforms.service.impl.SPDynamicFormsLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SPDynamicFormsLocalService extends BaseLocalService,
	InvokableLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPDynamicFormsLocalServiceUtil} to access the s p dynamic forms local service. Add custom service methods to {@link com.sambaash.platform.srv.spdynamicforms.service.impl.SPDynamicFormsLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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

	public com.liferay.portal.kernel.json.JSONObject retrieveLoadParam(
		javax.portlet.RenderRequest renderRequest);

	public void handleLoadData(javax.portlet.ResourceRequest request,
		javax.portlet.ResourceResponse response);

	public void handlePersist(javax.portlet.ResourceRequest request,
		javax.portlet.ResourceResponse response);

	public java.lang.String persistFormJsonData(
		com.liferay.portal.theme.ThemeDisplay themeDisplay, long formId,
		java.lang.Long formStorageId,
		com.liferay.portal.kernel.json.JSONObject formJsonData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String handlePersist(long userId, long formId,
		long formStorageId, java.lang.String jsonString);

	public void handleFileUpload(javax.portlet.ResourceRequest request,
		javax.portlet.ResourceResponse response);
}