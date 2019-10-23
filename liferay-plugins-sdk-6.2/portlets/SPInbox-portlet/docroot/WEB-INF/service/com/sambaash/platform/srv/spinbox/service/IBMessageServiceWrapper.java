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
 * Provides a wrapper for {@link IBMessageService}.
 *
 * @author nareshchebolu
 * @see IBMessageService
 * @generated
 */
public class IBMessageServiceWrapper implements IBMessageService,
	ServiceWrapper<IBMessageService> {
	public IBMessageServiceWrapper(IBMessageService ibMessageService) {
		_ibMessageService = ibMessageService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _ibMessageService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ibMessageService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _ibMessageService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessage addMessage(
		java.lang.String uuid, long parentMessageId, long groupId,
		long companyId, java.lang.String subject, java.lang.String content,
		java.util.Date createDate, java.lang.String from, java.lang.String to,
		java.lang.String createBy, java.lang.String createByUserId,
		boolean isAllowOpen, boolean isDraft, java.lang.String draftStatus,
		boolean isSentMeCopy)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ibMessageService.addMessage(uuid, parentMessageId, groupId,
			companyId, subject, content, createDate, from, to, createBy,
			createByUserId, isAllowOpen, isDraft, draftStatus, isSentMeCopy);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public IBMessageService getWrappedIBMessageService() {
		return _ibMessageService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedIBMessageService(IBMessageService ibMessageService) {
		_ibMessageService = ibMessageService;
	}

	@Override
	public IBMessageService getWrappedService() {
		return _ibMessageService;
	}

	@Override
	public void setWrappedService(IBMessageService ibMessageService) {
		_ibMessageService = ibMessageService;
	}

	private IBMessageService _ibMessageService;
}