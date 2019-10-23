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

package com.sambaash.platform.srv.spinbox.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link IBMessageDetailService}.
 *
 * @author nareshchebolu
 * @see IBMessageDetailService
 * @generated
 */
public class IBMessageDetailServiceWrapper implements IBMessageDetailService,
	ServiceWrapper<IBMessageDetailService> {
	public IBMessageDetailServiceWrapper(
		IBMessageDetailService ibMessageDetailService) {
		_ibMessageDetailService = ibMessageDetailService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _ibMessageDetailService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ibMessageDetailService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _ibMessageDetailService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail addMessageDetail(
		long messageId, long receiverId, java.lang.String receiveBy,
		java.util.Date receiveDate, java.lang.String category,
		boolean archived, java.util.Date updateDate, java.lang.String updateBy,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageDetailService.addMessageDetail(messageId, receiverId,
			receiveBy, receiveDate, category, archived, updateDate, updateBy,
			receiverMsgStatus, senderMsgStatus);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public IBMessageDetailService getWrappedIBMessageDetailService() {
		return _ibMessageDetailService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedIBMessageDetailService(
		IBMessageDetailService ibMessageDetailService) {
		_ibMessageDetailService = ibMessageDetailService;
	}

	@Override
	public IBMessageDetailService getWrappedService() {
		return _ibMessageDetailService;
	}

	@Override
	public void setWrappedService(IBMessageDetailService ibMessageDetailService) {
		_ibMessageDetailService = ibMessageDetailService;
	}

	private IBMessageDetailService _ibMessageDetailService;
}