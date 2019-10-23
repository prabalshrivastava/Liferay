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

package com.sambaash.platform.srv.spblogs.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPBlogsLocalService}.
 *
 * @author nebrawski
 * @see SPBlogsLocalService
 * @generated
 */
public class SPBlogsLocalServiceWrapper implements SPBlogsLocalService,
	ServiceWrapper<SPBlogsLocalService> {
	public SPBlogsLocalServiceWrapper(SPBlogsLocalService spBlogsLocalService) {
		_spBlogsLocalService = spBlogsLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spBlogsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spBlogsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spBlogsLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.lang.String retrieveBlogImageUrl(long blogId) {
		return _spBlogsLocalService.retrieveBlogImageUrl(blogId);
	}

	@Override
	public java.lang.String retrieveImageUrlFromHtml(java.lang.String content) {
		return _spBlogsLocalService.retrieveImageUrlFromHtml(content);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPBlogsLocalService getWrappedSPBlogsLocalService() {
		return _spBlogsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPBlogsLocalService(
		SPBlogsLocalService spBlogsLocalService) {
		_spBlogsLocalService = spBlogsLocalService;
	}

	@Override
	public SPBlogsLocalService getWrappedService() {
		return _spBlogsLocalService;
	}

	@Override
	public void setWrappedService(SPBlogsLocalService spBlogsLocalService) {
		_spBlogsLocalService = spBlogsLocalService;
	}

	private SPBlogsLocalService _spBlogsLocalService;
}