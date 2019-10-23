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

package com.sambaash.platform.srv.graph.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPNeoforjService}.
 *
 * @author harini
 * @see SPNeoforjService
 * @generated
 */
public class SPNeoforjServiceWrapper implements SPNeoforjService,
	ServiceWrapper<SPNeoforjService> {
	public SPNeoforjServiceWrapper(SPNeoforjService spNeoforjService) {
		_spNeoforjService = spNeoforjService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spNeoforjService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spNeoforjService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spNeoforjService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.lang.String follow(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityId) {
		return _spNeoforjService.follow(companyId, groupId, layoutSetId,
			action, startUserId, endEntityClassName, endEntityId);
	}

	@Override
	public boolean isFollowing(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId, long startUserId,
		java.lang.String endEntityClassName, long endEntityId) {
		return _spNeoforjService.isFollowing(companyId, groupId, layoutSetId,
			startUserId, endEntityClassName, endEntityId);
	}

	@Override
	public java.lang.String like(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityId) {
		return _spNeoforjService.like(companyId, groupId, layoutSetId, action,
			startUserId, endEntityClassName, endEntityId);
	}

	@Override
	public boolean isLiking(java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, long startUserId,
		java.lang.String endEntityClassName, long endEntityId) {
		return _spNeoforjService.isLiking(companyId, groupId, layoutSetId,
			startUserId, endEntityClassName, endEntityId);
	}

	@Override
	public int findUsersWhoLikeCount(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String endEntityClassName, java.lang.Long endEntityId) {
		return _spNeoforjService.findUsersWhoLikeCount(companyId, groupId,
			layoutSetId, endEntityClassName, endEntityId);
	}

	@Override
	public java.lang.String join(java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK, int type,
		int status, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId) {
		return _spNeoforjService.join(action, startUserId, endEntityClassName,
			endEntityClassPK, type, status, companyId, groupId, layoutSetId);
	}

	@Override
	public boolean isJoined(java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK) {
		return _spNeoforjService.isJoined(companyId, groupId, layoutSetId,
			startUserId, endEntityClassName, endEntityClassPK);
	}

	@Override
	public java.lang.String updateJoinGraph(
		com.sambaash.platform.model.spneo4j.form.JoinGraphForm joinGraphForm) {
		return _spNeoforjService.updateJoinGraph(joinGraphForm);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPNeoforjService getWrappedSPNeoforjService() {
		return _spNeoforjService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPNeoforjService(SPNeoforjService spNeoforjService) {
		_spNeoforjService = spNeoforjService;
	}

	@Override
	public SPNeoforjService getWrappedService() {
		return _spNeoforjService;
	}

	@Override
	public void setWrappedService(SPNeoforjService spNeoforjService) {
		_spNeoforjService = spNeoforjService;
	}

	private SPNeoforjService _spNeoforjService;
}