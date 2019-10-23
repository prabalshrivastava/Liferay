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

package com.sambaash.platform.srv.spmicroservice.service.impl;

import java.util.List;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.sambaash.platform.model.microservice.pricing.dto.PriceCalculationInputDto;
import com.sambaash.platform.spmicroservice.api.wrapper.ems.EmsMicroservice;
import com.sambaash.platform.spmicroservice.api.wrapper.ems.PricingMicroservice;
import com.sambaash.platform.srv.spmicroservice.service.base.PricingMicroserviceLocalServiceBaseImpl;

/**
 * The implementation of the pricing microservice local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.spmicroservice.service.PricingMicroserviceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author glenn
 * @see com.sambaash.platform.srv.spmicroservice.service.base.PricingMicroserviceLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spmicroservice.service.PricingMicroserviceLocalServiceUtil
 */
public class PricingMicroserviceLocalServiceImpl
	extends PricingMicroserviceLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.spmicroservice.service.PricingMicroserviceLocalServiceUtil} to access the pricing microservice local service.
	 */
	
	public JSONArray getPricing(long scopeGroupId, PriceCalculationInputDto inputDto) {
		PricingMicroservice service = new PricingMicroservice(scopeGroupId);
		return service.getPricing(inputDto);
	}
	
	public JSONArray getPEPriceSchemeLOV(long scopeGroupId) {
		EmsMicroservice service = new EmsMicroservice(scopeGroupId);
		return service.getPEPriceSchemeLOV();
	}

	public JSONArray getPEPriceSubSchemeLOV(long scopeGroupId, String priceSchemeCode) {
		EmsMicroservice service = new EmsMicroservice(scopeGroupId);
		return service.getPEPriceSubSchemeLOV(priceSchemeCode);
	}
	
	public JSONArray getPEPriceSchemeDetails(long scopeGroupId, String priceSchemeCode) {
		EmsMicroservice service = new EmsMicroservice(scopeGroupId);
		return service.getPEPriceSchemeDetails(priceSchemeCode);
	}
	
	public JSONObject createPEInvoice(long scopeGroupId, long processStateId, long processAuditId, long applicantId, 
			Double amount, String currency, long productTypeId, long productSubTypeId,
			JSONArray feeDetails, String applicantName, String title, String description
	) {
		EmsMicroservice service = new EmsMicroservice(scopeGroupId);
		return service.createPEInvoice(processStateId, processAuditId, applicantId, 
				amount, currency, productTypeId, productSubTypeId,
				feeDetails,applicantName, title, description);
	}
	
	public JSONObject getUserFees(long scopeGroupId, long userId, String componentRef, boolean includeOutstanding, String consolidateSourceId, boolean fullInfo) {
		EmsMicroservice service = new EmsMicroservice(scopeGroupId);
		return service.getUserFees(userId, componentRef, includeOutstanding, consolidateSourceId, fullInfo);
	}

	public JSONObject getTransactionFees(long scopeGroupId, boolean pendingOnly, List<String> transactionMasterCode) {
		EmsMicroservice service = new EmsMicroservice(scopeGroupId);
		return service.getTransactionFees(pendingOnly, transactionMasterCode.toArray(new String[0]));
	}
	
	public void publishStripeEvent(long scopeGroupId, String eventUri, String eventData) {
		EmsMicroservice service = new EmsMicroservice(scopeGroupId);
		service.publishStripeEvent(eventUri, eventData);
	}

	public JSONObject computeSchemeFees(long scopeGroupId, String priceSchemeCode, List<String> priceSubSchemeCode) {
		EmsMicroservice service = new EmsMicroservice(scopeGroupId);
		return service.computeSchemeFees(priceSchemeCode, priceSubSchemeCode.toArray(new String[0]));
	}
	
	public JSONObject computeCandidateSchemeFees(long scopeGroupId, String candidateId, String priceSchemeCode, List<String> priceSubSchemeCode) {
		EmsMicroservice service = new EmsMicroservice(scopeGroupId);
		return service.computeCandidateSchemeFees(candidateId, priceSchemeCode, priceSubSchemeCode.toArray(new String[0]));
	}
	
	public JSONObject retrieveTransactionStatus(long scopeGroupId, List<String> transactionMasterCode) {
		EmsMicroservice service = new EmsMicroservice(scopeGroupId);
		return service.retrieveTransactionStatus(transactionMasterCode.toArray(new String[0]));
	}
	
	public JSONObject retrievePEProgrammePriceSchemeByScheduleAndModule(long scopeGroupId, String programmeCode, String schedModulesParamJson) {
		EmsMicroservice service = new EmsMicroservice(scopeGroupId);
		return service.retrievePEProgrammePriceSchemeByScheduleAndModule(programmeCode, schedModulesParamJson);
	}

	public boolean isPaidInvoice(long scopeGroupId, String invoiceNumbers) {
		EmsMicroservice service = new EmsMicroservice(scopeGroupId);
		return service.isPaidInvoice(invoiceNumbers);
	}

}