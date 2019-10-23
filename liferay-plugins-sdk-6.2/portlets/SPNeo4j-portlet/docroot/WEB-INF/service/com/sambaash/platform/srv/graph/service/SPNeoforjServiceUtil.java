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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for SPNeoforj. This utility wraps
 * {@link com.sambaash.platform.srv.graph.service.impl.SPNeoforjServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author harini
 * @see SPNeoforjService
 * @see com.sambaash.platform.srv.graph.service.base.SPNeoforjServiceBaseImpl
 * @see com.sambaash.platform.srv.graph.service.impl.SPNeoforjServiceImpl
 * @generated
 */
public class SPNeoforjServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.graph.service.impl.SPNeoforjServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static java.lang.String follow(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityId) {
		return getService()
				   .follow(companyId, groupId, layoutSetId, action,
			startUserId, endEntityClassName, endEntityId);
	}

	public static boolean isFollowing(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId, long startUserId,
		java.lang.String endEntityClassName, long endEntityId) {
		return getService()
				   .isFollowing(companyId, groupId, layoutSetId, startUserId,
			endEntityClassName, endEntityId);
	}

	public static java.lang.String like(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityId) {
		return getService()
				   .like(companyId, groupId, layoutSetId, action, startUserId,
			endEntityClassName, endEntityId);
	}

	public static boolean isLiking(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId, long startUserId,
		java.lang.String endEntityClassName, long endEntityId) {
		return getService()
				   .isLiking(companyId, groupId, layoutSetId, startUserId,
			endEntityClassName, endEntityId);
	}

	public static int findUsersWhoLikeCount(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String endEntityClassName, java.lang.Long endEntityId) {
		return getService()
				   .findUsersWhoLikeCount(companyId, groupId, layoutSetId,
			endEntityClassName, endEntityId);
	}

	public static java.lang.String join(java.lang.String action,
		long startUserId, java.lang.String endEntityClassName,
		long endEntityClassPK, int type, int status, java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId) {
		return getService()
				   .join(action, startUserId, endEntityClassName,
			endEntityClassPK, type, status, companyId, groupId, layoutSetId);
	}

	public static boolean isJoined(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK) {
		return getService()
				   .isJoined(companyId, groupId, layoutSetId, startUserId,
			endEntityClassName, endEntityClassPK);
	}

	public static java.lang.String updateJoinGraph(
		com.sambaash.platform.model.spneo4j.form.JoinGraphForm joinGraphForm) {
		return getService().updateJoinGraph(joinGraphForm);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPNeoforjService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPNeoforjService.class.getName());

			if (invokableService instanceof SPNeoforjService) {
				_service = (SPNeoforjService)invokableService;
			}
			else {
				_service = new SPNeoforjServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(SPNeoforjServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPNeoforjService service) {
	}

	private static SPNeoforjService _service;
}