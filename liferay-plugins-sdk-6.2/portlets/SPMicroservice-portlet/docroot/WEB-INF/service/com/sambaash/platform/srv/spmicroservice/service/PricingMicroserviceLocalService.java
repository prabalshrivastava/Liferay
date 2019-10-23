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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service interface for PricingMicroservice. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author glenn
 * @see PricingMicroserviceLocalServiceUtil
 * @see com.sambaash.platform.srv.spmicroservice.service.base.PricingMicroserviceLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spmicroservice.service.impl.PricingMicroserviceLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface PricingMicroserviceLocalService extends BaseLocalService,
	InvokableLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PricingMicroserviceLocalServiceUtil} to access the pricing microservice local service. Add custom service methods to {@link com.sambaash.platform.srv.spmicroservice.service.impl.PricingMicroserviceLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getPricing(
		long scopeGroupId,
		com.sambaash.platform.model.microservice.pricing.dto.PriceCalculationInputDto inputDto);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getPEPriceSchemeLOV(
		long scopeGroupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getPEPriceSubSchemeLOV(
		long scopeGroupId, java.lang.String priceSchemeCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getPEPriceSchemeDetails(
		long scopeGroupId, java.lang.String priceSchemeCode);

	public com.liferay.portal.kernel.json.JSONObject createPEInvoice(
		long scopeGroupId, long processStateId, long processAuditId,
		long applicantId, java.lang.Double amount, java.lang.String currency,
		long productTypeId, long productSubTypeId,
		com.liferay.portal.kernel.json.JSONArray feeDetails,
		java.lang.String applicantName, java.lang.String title,
		java.lang.String description);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONObject getUserFees(
		long scopeGroupId, long userId, java.lang.String componentRef,
		boolean includeOutstanding, java.lang.String consolidateSourceId,
		boolean fullInfo);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONObject getTransactionFees(
		long scopeGroupId, boolean pendingOnly,
		java.util.List<java.lang.String> transactionMasterCode);

	public void publishStripeEvent(long scopeGroupId,
		java.lang.String eventUri, java.lang.String eventData);

	public com.liferay.portal.kernel.json.JSONObject computeSchemeFees(
		long scopeGroupId, java.lang.String priceSchemeCode,
		java.util.List<java.lang.String> priceSubSchemeCode);

	public com.liferay.portal.kernel.json.JSONObject computeCandidateSchemeFees(
		long scopeGroupId, java.lang.String candidateId,
		java.lang.String priceSchemeCode,
		java.util.List<java.lang.String> priceSubSchemeCode);

	public com.liferay.portal.kernel.json.JSONObject retrieveTransactionStatus(
		long scopeGroupId,
		java.util.List<java.lang.String> transactionMasterCode);

	public com.liferay.portal.kernel.json.JSONObject retrievePEProgrammePriceSchemeByScheduleAndModule(
		long scopeGroupId, java.lang.String programmeCode,
		java.lang.String schedModulesParamJson);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isPaidInvoice(long scopeGroupId,
		java.lang.String invoiceNumbers);
}