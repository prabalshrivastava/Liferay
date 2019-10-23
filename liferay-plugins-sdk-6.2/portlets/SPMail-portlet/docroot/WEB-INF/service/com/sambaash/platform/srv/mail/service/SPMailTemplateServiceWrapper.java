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

package com.sambaash.platform.srv.mail.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPMailTemplateService}.
 *
 * @author gauravvijayvergia
 * @see SPMailTemplateService
 * @generated
 */
public class SPMailTemplateServiceWrapper implements SPMailTemplateService,
	ServiceWrapper<SPMailTemplateService> {
	public SPMailTemplateServiceWrapper(
		SPMailTemplateService spMailTemplateService) {
		_spMailTemplateService = spMailTemplateService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spMailTemplateService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spMailTemplateService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spMailTemplateService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailTemplate getTemplateByName(
		java.lang.String templateName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateService.getTemplateByName(templateName);
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailTemplate getTemplateByName(
		long productTypeId, long subProductTypeId, java.lang.String templateName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailTemplateService.getTemplateByName(productTypeId,
			subProductTypeId, templateName);
	}

	@Override
	public void sendAdHocEmaills(java.lang.String userIdsStr, long templateId) {
		_spMailTemplateService.sendAdHocEmaills(userIdsStr, templateId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPMailTemplateService getWrappedSPMailTemplateService() {
		return _spMailTemplateService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPMailTemplateService(
		SPMailTemplateService spMailTemplateService) {
		_spMailTemplateService = spMailTemplateService;
	}

	@Override
	public SPMailTemplateService getWrappedService() {
		return _spMailTemplateService;
	}

	@Override
	public void setWrappedService(SPMailTemplateService spMailTemplateService) {
		_spMailTemplateService = spMailTemplateService;
	}

	private SPMailTemplateService _spMailTemplateService;
}