package com.sambaash.platform.spmicroservice.api.wrapper.ems;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.spmicroservice.api.BaseEmsMicroservice;

public class CandidateMicroservice extends BaseEmsMicroservice {

	public CandidateMicroservice(long scopeGroupId) {
		super(scopeGroupId);
	}

	private static final Log LOGGER = LogFactoryUtil.getLog(CandidateMicroservice.class);
			
	@Override
	protected Log logger() {
		return LOGGER;
	}

	@Override
	protected String getClientId() {
		return "Candidate";
	}

	@Override
	protected String getRootContext() {
		return "candidate";
	}

	public JSONObject validate(JSONObject candidate) {
		String url = constructGatewayUrl("/validate");
		return toJsonObject(execServiceApi(false, url, MediaType.APPLICATION_JSON, 
				HttpMethod.POST, candidate.toString()));
	}

	public JSONObject create(JSONObject candidate) {
		String url = constructGatewayUrl("/new");
		return toJsonObject(execServiceApi(false, url, MediaType.APPLICATION_JSON, 
				HttpMethod.POST, candidate.toString()));
	}
	
	public JSONObject update(JSONObject candidate, String storageId) {
		String url = constructGatewayUrl(String.format("/edit/%s", storageId));
		return toJsonObject(execServiceApi(false, url, MediaType.APPLICATION_JSON, 
				HttpMethod.PUT, candidate.toString()));
	}
	
}
