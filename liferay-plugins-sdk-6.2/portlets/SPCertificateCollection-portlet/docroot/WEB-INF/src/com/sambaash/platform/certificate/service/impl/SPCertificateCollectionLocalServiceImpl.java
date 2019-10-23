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

package com.sambaash.platform.certificate.service.impl;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.certificate.service.base.SPCertificateCollectionLocalServiceBaseImpl;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the s p certificate collection local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.certificate.service.SPCertificateCollectionLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author keyur.kalariya
 * @see com.sambaash.platform.certificate.service.base.SPCertificateCollectionLocalServiceBaseImpl
 * @see com.sambaash.platform.certificate.service.SPCertificateCollectionLocalServiceUtil
 */
public class SPCertificateCollectionLocalServiceImpl extends
		SPCertificateCollectionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform
	 * .certificate.service.SPCertificateCollectionLocalServiceUtil} to access
	 * the s p certificate collection local service.
	 */

	private static final Log _log = LogFactoryUtil
			.getLog(SPCertificateCollectionLocalServiceImpl.class);
	private static String error = "error";

	private static String formType = "formType";
	private static String restUriSize = "&size=";
	private static String requestURL = "Request URL";
	private static String restUriLimit = "limit";

	
	public class APICall {
		long userId = 0;
		long siteId = 0;
		PortletRequest req;
		HttpHeaders headers;
		HttpEntity<String> httprequest;
		RestTemplate restTemplate;
		String baseUrl = StringPool.BLANK;

		public APICall(PortletRequest request) {
			try {
				this.req = request;
				userId = PortalUtil.getUserId(request);
				siteId = PortalUtil.getScopeGroupId(request);
				headers = new HttpHeaders();
				headers.add("X-SCOPEGROUP-ID",
						StringPool.BLANK + SambaashUtil.getScopeGroupId(siteId));
				headers.add("X-USER-ID", StringPool.BLANK + userId);
				restTemplate = new RestTemplate();
				baseUrl = SambaashUtil.getParameter(
						SambaashConstants.API_STORAGE_ENGINE_BASEURL,
						SambaashConstants.DEFAULT_GROUP_ID_LONG);

			} catch (PortalException | SystemException e1) {
				_log.error(e1);
			}

		}

		public APICall(long userId, long siteId) throws PortalException {
			headers = new HttpHeaders();
			headers.add("X-SCOPEGROUP-ID",
					StringPool.BLANK + SambaashUtil.getScopeGroupId(siteId));
			headers.add("X-USER-ID", StringPool.BLANK + userId);
			restTemplate = new RestTemplate();
			baseUrl = SambaashUtil.getParameter(
					SambaashConstants.API_STORAGE_ENGINE_BASEURL,
					SambaashConstants.DEFAULT_GROUP_ID_LONG);

		}

		private String exchange(String subUrl, HttpMethod method) {
			String response = StringPool.BLANK;
			httprequest = new HttpEntity<>(headers);
			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<String> httpresponse = restTemplate.exchange(
						uri, method, httprequest, String.class);
				response = httpresponse.getBody();

			} catch (Exception e) {
				_log.debug(baseUrl + subUrl);
			}

			return response;
		}

		private String postForObject(String data, String subUrl) {
			String response = "0";
			try {
				headers.setContentType(MediaType.APPLICATION_JSON);
				httprequest = new HttpEntity<>(data, headers);
				response = restTemplate.postForObject(baseUrl + subUrl,
						httprequest, String.class);
				return response;

			} catch (Exception e) {
				_log.error(requestURL + baseUrl + subUrl);
				_log.error(e);
				return response;
			}
		}

		private String putForObject(String data, String subUrl) {
			String response = "0";
			try {
				headers.setContentType(MediaType.APPLICATION_JSON);
				HttpMethod method = HttpMethod.PUT;
				httprequest = new HttpEntity<>(data, headers);
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<String> httpresponse = restTemplate.exchange(
						uri, method, httprequest, String.class);
				response = httpresponse.getBody();
				return response;
			} catch (Exception e) {
				_log.error(requestURL + baseUrl + subUrl);
				_log.error(e);
				return response;
			}
		}

	}

	public String convertToAPIModel(ResourceRequest resourceRequest,
			String modelData, String existingData) throws JSONException {
		JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(modelData);
		JSONObject jsonModelExistingData = JSONFactoryUtil
				.createJSONObject(existingData);

		return FormIOToModelJSON(resourceRequest, jsonModelData,
				jsonModelExistingData).toString();

	}

	public JSONObject FormIOToModelJSON(ResourceRequest resourceRequest,
			JSONObject inp, JSONObject jsonModelExistingData) {
		try {
			List<String> columns = getMicroserviceModelColumnList(
					resourceRequest, inp.getString("ModelName"));
			if (columns.size() <= 1)
				return No_Op_FormIOToModelJSON(inp, jsonModelExistingData);
			if (jsonModelExistingData.toString().equals("{}")) {
				JSONObject contentJson = JSONFactoryUtil.createJSONObject();
				contentJson.put("Status", "Active");
				jsonModelExistingData.put("contentJson", contentJson);
			}
			org.json.JSONObject in = new org.json.JSONObject(inp.toString());
			for (int i = 0; i < in.names().length(); i++) {
				if (columns.contains(in.names().getString(i))) {

					jsonModelExistingData.getJSONObject("contentJson").put(
							in.names().getString(i),
							in.getString(in.names().getString(i)));

					Object json = in.get(in.names().getString(i));
					if (json instanceof org.json.JSONArray) {
						jsonModelExistingData.getJSONObject("contentJson").put(
								in.names().getString(i),
								inp.getJSONArray(in.names().getString(i)));
					} else {
						jsonModelExistingData.getJSONObject("contentJson").put(
								in.names().getString(i),
								in.getString(in.names().getString(i)));
					}
				}
			}
		} catch (Exception e) {

		}

		return jsonModelExistingData;

	}

	protected JSONObject No_Op_FormIOToModelJSON(JSONObject in,
			JSONObject jsonModelExistingData) {
		JSONObject apiJsonModelData = JSONFactoryUtil.createJSONObject();
		apiJsonModelData.put("contentJson", in.toString());
		return apiJsonModelData;
	}

	public List<String> getMicroserviceModelColumnList(
			ResourceRequest resourceRequest, String modelName) {
		String response = null;
		String existingData = null;
		String[] tempArray = null;
		try {
			String subUrl = modelName.toLowerCase() + "/getColumns";
			response = new APICall(resourceRequest).exchange(subUrl,
					HttpMethod.GET);
			tempArray = response.split(",");

		} catch (Exception e) {
			// _log.error(e);
			response = e.toString();
		}
		return (Arrays.asList(tempArray));

	}

	public String getElasticSearchListing(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {

		String response = null;
		try {
			String data = resourceRequest.getParameter("data");
			_log.debug(data);
			if (data != null && data != StringPool.BLANK) {
				JSONObject jsonModelData = JSONFactoryUtil
						.createJSONObject(data);
				String limit = jsonModelData.getString(restUriLimit);
				String model = jsonModelData.getString(formType).toLowerCase();
				String page = jsonModelData.getString("page");
				String conditions = jsonModelData.getString("conditions");
				JSONArray filters = jsonModelData.getJSONArray("filterdata");

				String filterString = jsonModelData.getString("filterdata");

				String subUrl = model + "/elasticsearch?" + "page=" + page
						+ restUriSize + limit;
				JSONArray jsonTerms = JSONFactoryUtil.createJSONArray();

				response = new APICall(resourceRequest).postForObject(
						filterString, subUrl);
			}
		} catch (Exception e) {
			_log.error(e);
			response = error;
		}
		return response;

	}

	public String scannedDataRecord(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		String response = StringPool.BLANK;
		try {
			String modeldata = resourceRequest.getParameter("data");

			String subUrl = "/certificate/edit";
			String apiModelData = convertToAPIModel(resourceRequest, modeldata,
					null);
			response = new APICall(resourceRequest).postForObject(apiModelData,
					subUrl);
		} catch (Exception e) {
			_log.error(e);
		}
		return response;

	}
}