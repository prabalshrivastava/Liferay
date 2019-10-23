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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BatchUploadLocalService}.
 *
 * @author biswo
 * @see BatchUploadLocalService
 * @generated
 */
public class BatchUploadLocalServiceWrapper implements BatchUploadLocalService,
	ServiceWrapper<BatchUploadLocalService> {
	public BatchUploadLocalServiceWrapper(
		BatchUploadLocalService batchUploadLocalService) {
		_batchUploadLocalService = batchUploadLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _batchUploadLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_batchUploadLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _batchUploadLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void handleBatchUpload(javax.portlet.ResourceRequest request,
		javax.portlet.ResourceResponse response) {
		_batchUploadLocalService.handleBatchUpload(request, response);
	}

	@Override
	public java.lang.String handleBatchUploadFile(
		javax.portlet.ActionRequest request,
		javax.portlet.ActionResponse response) {
		return _batchUploadLocalService.handleBatchUploadFile(request, response);
	}

	@Override
	public java.lang.String getCellValue(org.apache.poi.ss.usermodel.Cell cell) {
		return _batchUploadLocalService.getCellValue(cell);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BatchUploadLocalService getWrappedBatchUploadLocalService() {
		return _batchUploadLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBatchUploadLocalService(
		BatchUploadLocalService batchUploadLocalService) {
		_batchUploadLocalService = batchUploadLocalService;
	}

	@Override
	public BatchUploadLocalService getWrappedService() {
		return _batchUploadLocalService;
	}

	@Override
	public void setWrappedService(
		BatchUploadLocalService batchUploadLocalService) {
		_batchUploadLocalService = batchUploadLocalService;
	}

	private BatchUploadLocalService _batchUploadLocalService;
}