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

package com.sambaash.platform.srv.spservices.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPListTypeService}.
 *
 * @author gauravvijayvergia
 * @see SPListTypeService
 * @generated
 */
public class SPListTypeServiceWrapper implements SPListTypeService,
	ServiceWrapper<SPListTypeService> {
	public SPListTypeServiceWrapper(SPListTypeService spListTypeService) {
		_spListTypeService = spListTypeService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spListTypeService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spListTypeService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spListTypeService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> getListByKey(
		java.lang.String key, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spListTypeService.getListByKey(key, groupId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> getSPListTypeByCategoryIdGroupId(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spListTypeService.getSPListTypeByCategoryIdGroupId(groupId,
			categoryId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPListTypeService getWrappedSPListTypeService() {
		return _spListTypeService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPListTypeService(SPListTypeService spListTypeService) {
		_spListTypeService = spListTypeService;
	}

	@Override
	public SPListTypeService getWrappedService() {
		return _spListTypeService;
	}

	@Override
	public void setWrappedService(SPListTypeService spListTypeService) {
		_spListTypeService = spListTypeService;
	}

	private SPListTypeService _spListTypeService;
}