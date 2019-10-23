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

package com.sambaash.platform.srv.genericupload.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for BatchUpload. This utility wraps
 * {@link com.sambaash.platform.srv.genericupload.service.impl.BatchUploadLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author biswo
 * @see BatchUploadLocalService
 * @see com.sambaash.platform.srv.genericupload.service.base.BatchUploadLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.genericupload.service.impl.BatchUploadLocalServiceImpl
 * @generated
 */
public class BatchUploadLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.genericupload.service.impl.BatchUploadLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static void handleBatchUpload(
		javax.portlet.ResourceRequest request,
		javax.portlet.ResourceResponse response) {
		getService().handleBatchUpload(request, response);
	}

	public static java.lang.String handleBatchUploadFile(
		javax.portlet.ActionRequest request,
		javax.portlet.ActionResponse response) {
		return getService().handleBatchUploadFile(request, response);
	}

	public static java.lang.String getCellValue(
		org.apache.poi.ss.usermodel.Cell cell) {
		return getService().getCellValue(cell);
	}

	public static void clearService() {
		_service = null;
	}

	public static BatchUploadLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BatchUploadLocalService.class.getName());

			if (invokableLocalService instanceof BatchUploadLocalService) {
				_service = (BatchUploadLocalService)invokableLocalService;
			}
			else {
				_service = new BatchUploadLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BatchUploadLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BatchUploadLocalService service) {
	}

	private static BatchUploadLocalService _service;
}