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
 * Provides the local service utility for PricingMicroservice. This utility wraps
 * {@link com.sambaash.platform.srv.spmicroservice.service.impl.PricingMicroserviceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author glenn
 * @see PricingMicroserviceLocalService
 * @see com.sambaash.platform.srv.spmicroservice.service.base.PricingMicroserviceLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spmicroservice.service.impl.PricingMicroserviceLocalServiceImpl
 * @generated
 */
public class PricingMicroserviceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spmicroservice.service.impl.PricingMicroserviceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.liferay.portal.kernel.json.JSONArray getPricing(
		long scopeGroupId,
		com.sambaash.platform.model.microservice.pricing.dto.PriceCalculationInputDto inputDto) {
		return getService().getPricing(scopeGroupId, inputDto);
	}

	public static com.liferay.portal.kernel.json.JSONArray getPEPriceSchemeLOV(
		long scopeGroupId) {
		return getService().getPEPriceSchemeLOV(scopeGroupId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getPEPriceSubSchemeLOV(
		long scopeGroupId, java.lang.String priceSchemeCode) {
		return getService().getPEPriceSubSchemeLOV(scopeGroupId, priceSchemeCode);
	}

	public static com.liferay.portal.kernel.json.JSONArray getPEPriceSchemeDetails(
		long scopeGroupId, java.lang.String priceSchemeCode) {
		return getService()
				   .getPEPriceSchemeDetails(scopeGroupId, priceSchemeCode);
	}

	public static com.liferay.portal.kernel.json.JSONObject createPEInvoice(
		long scopeGroupId, long processStateId, long processAuditId,
		long applicantId, java.lang.Double amount, java.lang.String currency,
		long productTypeId, long productSubTypeId,
		com.liferay.portal.kernel.json.JSONArray feeDetails,
		java.lang.String applicantName, java.lang.String title,
		java.lang.String description) {
		return getService()
				   .createPEInvoice(scopeGroupId, processStateId,
			processAuditId, applicantId, amount, currency, productTypeId,
			productSubTypeId, feeDetails, applicantName, title, description);
	}

	public static com.liferay.portal.kernel.json.JSONObject getUserFees(
		long scopeGroupId, long userId, java.lang.String componentRef,
		boolean includeOutstanding, java.lang.String consolidateSourceId,
		boolean fullInfo) {
		return getService()
				   .getUserFees(scopeGroupId, userId, componentRef,
			includeOutstanding, consolidateSourceId, fullInfo);
	}

	public static com.liferay.portal.kernel.json.JSONObject getTransactionFees(
		long scopeGroupId, boolean pendingOnly,
		java.util.List<java.lang.String> transactionMasterCode) {
		return getService()
				   .getTransactionFees(scopeGroupId, pendingOnly,
			transactionMasterCode);
	}

	public static void publishStripeEvent(long scopeGroupId,
		java.lang.String eventUri, java.lang.String eventData) {
		getService().publishStripeEvent(scopeGroupId, eventUri, eventData);
	}

	public static com.liferay.portal.kernel.json.JSONObject computeSchemeFees(
		long scopeGroupId, java.lang.String priceSchemeCode,
		java.util.List<java.lang.String> priceSubSchemeCode) {
		return getService()
				   .computeSchemeFees(scopeGroupId, priceSchemeCode,
			priceSubSchemeCode);
	}

	public static com.liferay.portal.kernel.json.JSONObject computeCandidateSchemeFees(
		long scopeGroupId, java.lang.String candidateId,
		java.lang.String priceSchemeCode,
		java.util.List<java.lang.String> priceSubSchemeCode) {
		return getService()
				   .computeCandidateSchemeFees(scopeGroupId, candidateId,
			priceSchemeCode, priceSubSchemeCode);
	}

	public static com.liferay.portal.kernel.json.JSONObject retrieveTransactionStatus(
		long scopeGroupId,
		java.util.List<java.lang.String> transactionMasterCode) {
		return getService()
				   .retrieveTransactionStatus(scopeGroupId,
			transactionMasterCode);
	}

	public static com.liferay.portal.kernel.json.JSONObject retrievePEProgrammePriceSchemeByScheduleAndModule(
		long scopeGroupId, java.lang.String programmeCode,
		java.lang.String schedModulesParamJson) {
		return getService()
				   .retrievePEProgrammePriceSchemeByScheduleAndModule(scopeGroupId,
			programmeCode, schedModulesParamJson);
	}

	public static boolean isPaidInvoice(long scopeGroupId,
		java.lang.String invoiceNumbers) {
		return getService().isPaidInvoice(scopeGroupId, invoiceNumbers);
	}

	public static void clearService() {
		_service = null;
	}

	public static PricingMicroserviceLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PricingMicroserviceLocalService.class.getName());

			if (invokableLocalService instanceof PricingMicroserviceLocalService) {
				_service = (PricingMicroserviceLocalService)invokableLocalService;
			}
			else {
				_service = new PricingMicroserviceLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PricingMicroserviceLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PricingMicroserviceLocalService service) {
	}

	private static PricingMicroserviceLocalService _service;
}