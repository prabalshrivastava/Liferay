package com.sambaash.platform.pe.handlers;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.AuthTokenUtil;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PEError;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.helpers.PEAuditHelper;
import com.sambaash.platform.pe.helpers.PEProcessStateHelper;
import com.sambaash.platform.pe.jaxb.PEApiNode;
import com.sambaash.platform.pe.jaxb.PEParameter;
import com.sambaash.platform.pe.jaxb.PEProcessableNodeOutput;
import com.sambaash.platform.portlet.pe.helper.ProcessStateActionHelper;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.util.SambaashUtil;
import com.sambaash.platform.util.ShortLiveTaskExecutor;
import com.sambaash.platform.util.URLUtil;

public class PEApiHandler extends PESingleOutputNodeHandler {
	private static Log _log = LogFactoryUtil.getLog(PEApiHandler.class);

	public PEApiHandler(PEApiNode node, PEDataSource ds) {
		super(node, ds);
	}

	@Override
	public PEProcessableNodeOutput process() throws SystemException, PEException {
		PEApiNode apiNode = (PEApiNode) node;

		PEProcessableNodeOutput output = new PEProcessableNodeOutput();

		String response = invokeApi(apiNode);

		try {
			PEAuditHelper audit = ds.getAuditHelper();
			audit.logApiCall(apiNode.getNodeId(), apiNode.isAsynchronous() ? "ASYNC" : "SYNC", response);
			if (!apiNode.isAsynchronous() && StringUtils.isNotEmpty(response)) {
				try {
					JSONObject respObj = JSONFactoryUtil.createJSONObject(response);
					if (respObj.has("error")) {
						PEError err = new PEError(String.format("System Error. Please contact support team. Error invoking API Node %d - %s", apiNode.getNodeId(), respObj.getString("error")));
						output.setError(err);
						return output;
					} else if (respObj.has("exception")) {
						PEError err = new PEError(String.format("System Error. Please contact support team. Error invoking API Node %d - %s : %s", apiNode.getNodeId(), respObj.getString("exception"), respObj.getString("message")));
						output.setError(err);
						return output;
					}
				} catch (Exception e) {
					// NO error info
				}
			}
		} catch (Exception ex) {
			_log.error(ex);
			output.setError(PEErrors.AUDIT_STATUS);
		}
		if (_log.isDebugEnabled()) {
			_log.debug("response in api handler " + response);
			_log.debug("response mapping " + apiNode.getResponseMapping());
		}
		if (Validator.isNotNull(apiNode.getResponseMapping()) && !response.contains("Exception")
				&& !response.equalsIgnoreCase("0") && !response.equalsIgnoreCase("{}")) {
			storeInStateData(apiNode.getResponseMapping(), ds.getProcessState(), response);
		}

		// output.setNextNodeId(apiNode.getNextNodeId());
		// output.setCanProceedToNext(true);
		proceedToNextNode(output, apiNode.getNextNodeId());

		return output;
	}

	private <T> String invokeApi(PEApiNode apiNode) throws PEException {
		String response = StringPool.BLANK;
		RestTemplate restTemplate = new RestTemplate();

		String apiUrl = URLUtil.autoResolveUrl(ds.getRequestData().getPortletRequest(), apiNode.getUrl());

		try {
			if (apiNode.isEncode()) {
				apiUrl = URLUtil.encodeUrl(ds.replaceTokensInData(apiUrl));
			} else {
				apiUrl = ds.replaceTokensInData(apiUrl);
			}
			_log.debug("Final API URL to invoke: " + apiUrl);
		} catch (Exception e) {
			throw new PEException(e.getMessage());
		}

		if (_log.isDebugEnabled()) {
			_log.debug("API processState DATA :  " + processState.getData());
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		if (apiNode.getHeader() != null) {
			for (PEParameter parameter : apiNode.getHeader().getParameters()) {
				if (Validator.isNotNull(parameter.getKey())) {
					headers.set(parameter.getKey(), parameter.getValue());
				}
			}
		}

		String requestBody = ProcessStateActionHelper.retrieveProcessData(ds, null).toString();
		if (_log.isDebugEnabled()) {
			_log.debug("API UserIdProcess is  :  " + ds.getProcessState().getUserIdProcess());
		}
		HttpEntity<String> request = newApiRequest(headers, requestBody);
		HttpMethod method = HttpMethod.valueOf(apiNode.getMethod().toUpperCase());
		if (apiNode.isAsynchronous()) {
			// exec async and don't wait
			ShortLiveTaskExecutor.getInstance().submit(new AsynchRestRunnableTask<>(apiUrl, method, request));
		} else {
			if (_log.isDebugEnabled()) {
				_log.debug("API apiUrl :  " + apiUrl);
			}
			response = restTemplate.exchange(apiUrl, method, request, String.class).getBody();
		}

		return response;
	}

	protected <T> HttpEntity<T> newApiRequest(HttpHeaders headers, T requestBody) {
		return new HttpEntity<>(requestBody, headers);
	}

	public static class AsynchRestRunnableTask<T> implements Runnable {
		private String url;
		private HttpMethod method;
		private HttpEntity<T> request;

		public AsynchRestRunnableTask(String url, HttpMethod method, HttpEntity<T> request) {
			this.url = url;
			this.method = method;
			this.request = request;
		}

		@Override
		public void run() {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.exchange(url, method, request, String.class).getBody();
		}

	}

	protected void storeInStateData(String responseMapping, PEProcessState peProcessState, String response) {
		try {
			_log.debug("storeInStateData " + response);
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray(responseMapping);

			boolean isArrayResponse = response.trim().startsWith("[");
			// for now we only take the first element of the array
			JSONObject jsonResponse;
			if (isArrayResponse) {
				jsonResponse = JSONFactoryUtil.createJSONArray(response).getJSONObject(0);
			} else {
				jsonResponse = JSONFactoryUtil.createJSONObject(response);
			}

			PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter
					.getProcessStateDataAdapter(peProcessState);
			_log.debug("jsonArray.length() " + jsonArray.length());
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObj = jsonArray.getJSONObject(i);
				String responseKey = jsonObj.getString("responseField");
				String value = getResponseValue(jsonResponse, responseKey);
				String stateDataKey = jsonObj.getString("stateDataField");
				dataAdapter.store(stateDataKey, value);
				if (_log.isDebugEnabled()) {
					_log.debug("stateDataKey " + stateDataKey);
					_log.debug("value " + value);
					_log.debug("responseKey " + responseKey);
				}
			}
			_log.debug("peProcessState in api handler " + peProcessState.getData());
			PEProcessStateHelper.updateProcessStateSafe(peProcessState, ds.getRequestData());
			_log.debug("after update in api handler " + peProcessState.getData());
		} catch (Exception e) {
			_log.error("Failed to store response in state data : " + e.getMessage());
			if (_log.isDebugEnabled()) {
				_log.debug(e);
			}
		}

	}

	private String getResponseValue(JSONObject jsonResponse, String responseKey) {
		JSONObject currObject = jsonResponse;
		JSONArray responseArray = null;
		String responseValue = null;
		for (String keyPath : responseKey.split(Pattern.quote("."))) {
			if (currObject.has(keyPath)) {
				responseValue = currObject.getString(keyPath);
				if (responseValue.startsWith("{") && responseValue.endsWith("}")) {
					// we only traverse JSON object
					currObject = currObject.getJSONObject(keyPath);
				}
			}
		}
		return responseArray != null ? responseArray.toString() : responseValue;
	}

}