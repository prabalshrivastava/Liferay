package com.sambaash.platform.spmicroservice.api.wrapper.ems;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.model.microservice.pricing.dto.PriceCalculationInputDto;
import com.sambaash.platform.spmicroservice.api.BaseEmsMicroservice;

public class PricingMicroservice extends BaseEmsMicroservice {

	public PricingMicroservice(long scopeGroupId) {
		super(scopeGroupId);
	}

	private static final Log LOGGER = LogFactoryUtil.getLog(PricingMicroservice.class);
			
	@Override
	protected Log logger() {
		return LOGGER;
	}

	@Override
	protected String getClientId() {
		return "Pricing Engine";
	}

	@Override
	protected String getRootContext() {
		return "pricing";
	}

	public JSONArray getPricing(PriceCalculationInputDto inputDto) {
		String url = constructGatewayUrl("");
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString=mapper.writeValueAsString(inputDto);			
		} catch (Exception e) {
			jsonString=JSONFactoryUtil.looseSerialize(inputDto,"priceSchemeCode","subjects");
		}
		return toJsonArray(execServiceApi(false, url, MediaType.APPLICATION_JSON, 
				HttpMethod.POST, jsonString));
	}
}
