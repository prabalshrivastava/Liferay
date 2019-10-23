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
 * Provides a wrapper for {@link PricingMicroserviceLocalService}.
 *
 * @author glenn
 * @see PricingMicroserviceLocalService
 * @generated
 */
public class PricingMicroserviceLocalServiceWrapper
	implements PricingMicroserviceLocalService,
		ServiceWrapper<PricingMicroserviceLocalService> {
	public PricingMicroserviceLocalServiceWrapper(
		PricingMicroserviceLocalService pricingMicroserviceLocalService) {
		_pricingMicroserviceLocalService = pricingMicroserviceLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _pricingMicroserviceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_pricingMicroserviceLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _pricingMicroserviceLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getPricing(
		long scopeGroupId,
		com.sambaash.platform.model.microservice.pricing.dto.PriceCalculationInputDto inputDto) {
		return _pricingMicroserviceLocalService.getPricing(scopeGroupId,
			inputDto);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getPEPriceSchemeLOV(
		long scopeGroupId) {
		return _pricingMicroserviceLocalService.getPEPriceSchemeLOV(scopeGroupId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getPEPriceSubSchemeLOV(
		long scopeGroupId, java.lang.String priceSchemeCode) {
		return _pricingMicroserviceLocalService.getPEPriceSubSchemeLOV(scopeGroupId,
			priceSchemeCode);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getPEPriceSchemeDetails(
		long scopeGroupId, java.lang.String priceSchemeCode) {
		return _pricingMicroserviceLocalService.getPEPriceSchemeDetails(scopeGroupId,
			priceSchemeCode);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject createPEInvoice(
		long scopeGroupId, long processStateId, long processAuditId,
		long applicantId, java.lang.Double amount, java.lang.String currency,
		long productTypeId, long productSubTypeId,
		com.liferay.portal.kernel.json.JSONArray feeDetails,
		java.lang.String applicantName, java.lang.String title,
		java.lang.String description) {
		return _pricingMicroserviceLocalService.createPEInvoice(scopeGroupId,
			processStateId, processAuditId, applicantId, amount, currency,
			productTypeId, productSubTypeId, feeDetails, applicantName, title,
			description);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getUserFees(
		long scopeGroupId, long userId, java.lang.String componentRef,
		boolean includeOutstanding, java.lang.String consolidateSourceId,
		boolean fullInfo) {
		return _pricingMicroserviceLocalService.getUserFees(scopeGroupId,
			userId, componentRef, includeOutstanding, consolidateSourceId,
			fullInfo);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getTransactionFees(
		long scopeGroupId, boolean pendingOnly,
		java.util.List<java.lang.String> transactionMasterCode) {
		return _pricingMicroserviceLocalService.getTransactionFees(scopeGroupId,
			pendingOnly, transactionMasterCode);
	}

	@Override
	public void publishStripeEvent(long scopeGroupId,
		java.lang.String eventUri, java.lang.String eventData) {
		_pricingMicroserviceLocalService.publishStripeEvent(scopeGroupId,
			eventUri, eventData);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject computeSchemeFees(
		long scopeGroupId, java.lang.String priceSchemeCode,
		java.util.List<java.lang.String> priceSubSchemeCode) {
		return _pricingMicroserviceLocalService.computeSchemeFees(scopeGroupId,
			priceSchemeCode, priceSubSchemeCode);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject computeCandidateSchemeFees(
		long scopeGroupId, java.lang.String candidateId,
		java.lang.String priceSchemeCode,
		java.util.List<java.lang.String> priceSubSchemeCode) {
		return _pricingMicroserviceLocalService.computeCandidateSchemeFees(scopeGroupId,
			candidateId, priceSchemeCode, priceSubSchemeCode);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject retrieveTransactionStatus(
		long scopeGroupId,
		java.util.List<java.lang.String> transactionMasterCode) {
		return _pricingMicroserviceLocalService.retrieveTransactionStatus(scopeGroupId,
			transactionMasterCode);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject retrievePEProgrammePriceSchemeByScheduleAndModule(
		long scopeGroupId, java.lang.String programmeCode,
		java.lang.String schedModulesParamJson) {
		return _pricingMicroserviceLocalService.retrievePEProgrammePriceSchemeByScheduleAndModule(scopeGroupId,
			programmeCode, schedModulesParamJson);
	}

	@Override
	public boolean isPaidInvoice(long scopeGroupId,
		java.lang.String invoiceNumbers) {
		return _pricingMicroserviceLocalService.isPaidInvoice(scopeGroupId,
			invoiceNumbers);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PricingMicroserviceLocalService getWrappedPricingMicroserviceLocalService() {
		return _pricingMicroserviceLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPricingMicroserviceLocalService(
		PricingMicroserviceLocalService pricingMicroserviceLocalService) {
		_pricingMicroserviceLocalService = pricingMicroserviceLocalService;
	}

	@Override
	public PricingMicroserviceLocalService getWrappedService() {
		return _pricingMicroserviceLocalService;
	}

	@Override
	public void setWrappedService(
		PricingMicroserviceLocalService pricingMicroserviceLocalService) {
		_pricingMicroserviceLocalService = pricingMicroserviceLocalService;
	}

	private PricingMicroserviceLocalService _pricingMicroserviceLocalService;
}