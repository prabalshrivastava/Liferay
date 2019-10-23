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

package com.sambaash.platform.srv.spmicroservice.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for RulesMicroservice. This utility wraps
 * {@link com.sambaash.platform.srv.spmicroservice.service.impl.RulesMicroserviceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author glenn
 * @see RulesMicroserviceLocalService
 * @see com.sambaash.platform.srv.spmicroservice.service.base.RulesMicroserviceLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spmicroservice.service.impl.RulesMicroserviceLocalServiceImpl
 * @generated
 */
public class RulesMicroserviceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spmicroservice.service.impl.RulesMicroserviceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.liferay.portal.kernel.json.JSONArray fetchRuleSetTypes(
		boolean fullInfo) {
		return getService().fetchRuleSetTypes(fullInfo);
	}

	public static com.liferay.portal.kernel.json.JSONArray fetchListOptionByName(
		boolean fullInfo, java.lang.String[] name) {
		return getService().fetchListOptionByName(fullInfo, name);
	}

	public static com.liferay.portal.kernel.json.JSONArray getRuleSetListing(
		boolean fullInfo) {
		return getService().getRuleSetListing(fullInfo);
	}

	public static com.liferay.portal.kernel.json.JSONArray getPERuleSets(
		boolean includeRules, java.lang.String ruleSetTypes) {
		return getService().getPERuleSets(includeRules, ruleSetTypes);
	}

	public static com.liferay.portal.kernel.json.JSONObject getRuleSet(
		java.lang.Long ruleSetId) {
		return getService().getRuleSet(ruleSetId);
	}

	public static com.liferay.portal.kernel.json.JSONObject deleteRuleSet(
		java.lang.Long ruleSetId) {
		return getService().deleteRuleSet(ruleSetId);
	}

	public static com.liferay.portal.kernel.json.JSONArray evaluateRuleSet(
		long ruleSetId,
		com.liferay.portal.kernel.json.JSONObject dataMapToEvalTheRuleset) {
		return getService().evaluateRuleSet(ruleSetId, dataMapToEvalTheRuleset);
	}

	public static com.liferay.portal.kernel.json.JSONObject saveRuleSet(
		com.liferay.portal.kernel.json.JSONObject ruleSetJson) {
		return getService().saveRuleSet(ruleSetJson);
	}

	public static void clearService() {
		_service = null;
	}

	public static RulesMicroserviceLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					RulesMicroserviceLocalService.class.getName());

			if (invokableLocalService instanceof RulesMicroserviceLocalService) {
				_service = (RulesMicroserviceLocalService)invokableLocalService;
			}
			else {
				_service = new RulesMicroserviceLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(RulesMicroserviceLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(RulesMicroserviceLocalService service) {
	}

	private static RulesMicroserviceLocalService _service;
}