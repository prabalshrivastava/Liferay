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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RulesMicroserviceLocalService}.
 *
 * @author glenn
 * @see RulesMicroserviceLocalService
 * @generated
 */
public class RulesMicroserviceLocalServiceWrapper
	implements RulesMicroserviceLocalService,
		ServiceWrapper<RulesMicroserviceLocalService> {
	public RulesMicroserviceLocalServiceWrapper(
		RulesMicroserviceLocalService rulesMicroserviceLocalService) {
		_rulesMicroserviceLocalService = rulesMicroserviceLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _rulesMicroserviceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_rulesMicroserviceLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _rulesMicroserviceLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray fetchRuleSetTypes(
		boolean fullInfo) {
		return _rulesMicroserviceLocalService.fetchRuleSetTypes(fullInfo);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray fetchListOptionByName(
		boolean fullInfo, java.lang.String[] name) {
		return _rulesMicroserviceLocalService.fetchListOptionByName(fullInfo,
			name);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getRuleSetListing(
		boolean fullInfo) {
		return _rulesMicroserviceLocalService.getRuleSetListing(fullInfo);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getPERuleSets(
		boolean includeRules, java.lang.String ruleSetTypes) {
		return _rulesMicroserviceLocalService.getPERuleSets(includeRules,
			ruleSetTypes);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getRuleSet(
		java.lang.Long ruleSetId) {
		return _rulesMicroserviceLocalService.getRuleSet(ruleSetId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject deleteRuleSet(
		java.lang.Long ruleSetId) {
		return _rulesMicroserviceLocalService.deleteRuleSet(ruleSetId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray evaluateRuleSet(
		long ruleSetId,
		com.liferay.portal.kernel.json.JSONObject dataMapToEvalTheRuleset) {
		return _rulesMicroserviceLocalService.evaluateRuleSet(ruleSetId,
			dataMapToEvalTheRuleset);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject saveRuleSet(
		com.liferay.portal.kernel.json.JSONObject ruleSetJson) {
		return _rulesMicroserviceLocalService.saveRuleSet(ruleSetJson);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RulesMicroserviceLocalService getWrappedRulesMicroserviceLocalService() {
		return _rulesMicroserviceLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRulesMicroserviceLocalService(
		RulesMicroserviceLocalService rulesMicroserviceLocalService) {
		_rulesMicroserviceLocalService = rulesMicroserviceLocalService;
	}

	@Override
	public RulesMicroserviceLocalService getWrappedService() {
		return _rulesMicroserviceLocalService;
	}

	@Override
	public void setWrappedService(
		RulesMicroserviceLocalService rulesMicroserviceLocalService) {
		_rulesMicroserviceLocalService = rulesMicroserviceLocalService;
	}

	private RulesMicroserviceLocalService _rulesMicroserviceLocalService;
}