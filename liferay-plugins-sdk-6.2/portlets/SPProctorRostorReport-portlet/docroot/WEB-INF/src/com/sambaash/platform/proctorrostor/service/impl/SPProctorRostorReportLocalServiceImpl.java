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

package com.sambaash.platform.proctorrostor.service.impl;



import com.sambaash.platform.proctorrostor.service.base.SPProctorRostorReportLocalServiceBaseImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.api.client.util.IOUtils;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.util.SambaashUtil;


/**
 * The implementation of the s p proctor rostor report local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.proctorrostor.service.SPProctorRostorReportLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gaurav.kapadiya
 * @see com.sambaash.platform.proctorrostor.service.base.SPProctorRostorReportLocalServiceBaseImpl
 * @see com.sambaash.platform.proctorrostor.service.SPProctorRostorReportLocalServiceUtil
 */
public class SPProctorRostorReportLocalServiceImpl
	extends SPProctorRostorReportLocalServiceBaseImpl {
	private static final String TITLES = "titles";
	private static final String LAST_MODIFIED_DATE = "lastModifiedDate";
	private static final String CREATED_DATE = "createdDate";
	private static final String START_DATE = "startDate";
	private static final String END_DATE = "endDate";
	private static final String LAST_MODIFIED_BY = "lastModifiedBy";
	private static final String CREATED_BY = "createdBy";
	private static final String SESSION_CURRENTQUERY = "currentquery";
	private static final String CONTENT_JSON_PREFIX = "contentJson.";
	private static final String CACHE_CONTROL_PROP = "max-age=00, must-revalidate";

	private static final Log _log = LogFactoryUtil
			.getLog(SPProctorRostorReportLocalServiceImpl.class);
	private static String error = "error";
	private static String formType = "formType";
	private static String requestURL = "Request URL";

	public class APICall {
		long userId = 0;
		long siteId = 0;
		ResourceRequest req;
		HttpHeaders headers;
		HttpEntity<String> httprequest;
		RestTemplate restTemplate;
		String baseUrl = "";

		public APICall(ResourceRequest request) {
			try {
				this.req = request;
				userId = PortalUtil.getUserId(request);
				siteId = PortalUtil.getScopeGroupId(request);
				headers = new HttpHeaders();
				headers.add("X-SCOPEGROUP-ID", "" + SambaashUtil.getScopeGroupId(siteId));
				headers.add("X-USER-ID", "" + userId);
				restTemplate = new RestTemplate();
				baseUrl = SambaashUtil.getParameter(SambaashConstants.API_STORAGE_ENGINE_BASEURL,
						SambaashConstants.DEFAULT_GROUP_ID_LONG);

			} catch (PortalException | SystemException e1) {
				_log.error(e1);
			}

		}

		public APICall(long userId, long siteId) {
			headers = new HttpHeaders();
			headers.add("X-SCOPEGROUP-ID", "" + SambaashUtil.getScopeGroupId(siteId));
			headers.add("X-USER-ID", "" + userId);
			restTemplate = new RestTemplate();
			baseUrl = SambaashUtil.getParameter(SambaashConstants.API_STORAGE_ENGINE_BASEURL,
					SambaashConstants.DEFAULT_GROUP_ID_LONG);
		}

		private String exchange(String subUrl, HttpMethod method) {
			String response = "";
			httprequest = new HttpEntity<>(headers);
			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<String> httpresponse = restTemplate.exchange(uri, method, httprequest, String.class);
				_log.debug(requestURL + baseUrl + subUrl);
				response = httpresponse.getBody();

			} catch (Exception e) {
				_log.error(requestURL + baseUrl + subUrl);
				_log.error(e);
			}

			return response;
		}


		private String postForObject(String data, String subUrl) {
			String response = "0";
			try {
				headers.setContentType(MediaType.APPLICATION_JSON);
				httprequest = new HttpEntity<>(data, headers);
				response = restTemplate.postForObject(baseUrl + subUrl, httprequest, String.class);
				return response;

			} catch (Exception e) {
				_log.error(requestURL + baseUrl + subUrl);
				_log.error(e);
				return response;
			}
		}
		
		private void downloadPdf(String data, String subUrl, HttpMethod method, ResourceResponse resourceResponse) {
			headers.setContentType(MediaType.APPLICATION_JSON);
			httprequest = new HttpEntity<>(data, headers);
			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<Resource> httpresponse = restTemplate.exchange(uri, method, httprequest, Resource.class);
				if (httpresponse.getStatusCode().equals(HttpStatus.OK)) {
					resourceResponse.setContentType("application/pdf");
					resourceResponse.addProperty(com.liferay.portal.kernel.servlet.HttpHeaders.CACHE_CONTROL,
							CACHE_CONTROL_PROP);
					downloadPdfWriteData(resourceResponse, httpresponse);
				}
			} catch (Exception e) {
				_log.error(requestURL + baseUrl + subUrl);
				_log.error(e);
			}
		}

		private void downloadPdfWriteData(ResourceResponse resourceResponse, ResponseEntity<Resource> httpresponse) {
			try (OutputStream out = resourceResponse.getPortletOutputStream();
					InputStream in = httpresponse.getBody().getInputStream()) {
				IOUtils.copy(in, out);
				out.flush();
				resourceResponse.flushBuffer();
			} catch (final IOException e) {
				_log.error(e);
			}
		}

		

	}

	public String getFilterColumnHeader(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		_log.info("Get Filter Column Header");
		String response = null;
		List<String> nonModelFilterColumns = new ArrayList<>();
		nonModelFilterColumns.add(CREATED_BY);
		nonModelFilterColumns.add(LAST_MODIFIED_BY);
		List<String> datePickerColumns = new ArrayList<>();
		
		datePickerColumns.add(CREATED_DATE);
		datePickerColumns.add(LAST_MODIFIED_DATE);
		datePickerColumns.add(START_DATE);
		datePickerColumns.add(END_DATE);

		try {
			String modelNameMicroService = resourceRequest
					.getParameter(formType);
			String model = modelNameMicroService.toLowerCase();
			List<String> filterColumns = getMicroserviceModelFilterColumnList(
					resourceRequest, modelNameMicroService);
			StringBuilder sbColumns = new StringBuilder("?");
			for (String filterColumn : filterColumns) {
				if (!sbColumns.toString().equals("?")) {
					sbColumns.append("&");
				}
				sbColumns.append("columns=contentJson.");
				sbColumns.append(filterColumn);
				_log.info("filtercolumn: " + filterColumn);
			}
			for (String nonModelFilterColumn : nonModelFilterColumns) {
				if (!sbColumns.toString().equals("?")) {
					sbColumns.append("&");
				}
				sbColumns.append("columns=");
				sbColumns.append(nonModelFilterColumn);
				_log.info("nonmodelfiltercolumn: " + nonModelFilterColumn);
			}
			String subUrl = model + "/distinct/" + sbColumns.toString();
			_log.info("suburl: " + subUrl);
			response = new APICall(resourceRequest).exchange(subUrl,
					HttpMethod.GET);
			Map<String, String> allModelColumnTitles = getMicroserviceModelColumnTitleMap(
					resourceRequest, modelNameMicroService);
			JSONObject distinct = JSONFactoryUtil.createJSONObject(response);
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			JSONArray datepicker = JSONFactoryUtil.createJSONArray();
			JSONObject titles = JSONFactoryUtil.createJSONObject();


			for (String datePickerColumn : datePickerColumns) {
				datepicker.put(datePickerColumn);
				_log.info("datepicker: " + datePickerColumn);
			}
			for (Map.Entry modelColumnTitle : allModelColumnTitles.entrySet()) {
				titles.put(
						CONTENT_JSON_PREFIX
								+ (String) modelColumnTitle.getKey(),
						(String) modelColumnTitle.getValue());
				_log.info("titles:" + modelColumnTitle.getValue());
			}
			
			JSONArray usersInfo = JSONFactoryUtil.createJSONArray();
			
			titles.put(CREATED_BY, "Created By");
			titles.put(CREATED_DATE, "Created Date");
			titles.put(LAST_MODIFIED_BY, "Last Modified By");
			titles.put(LAST_MODIFIED_DATE, "Last Modified Date");
			titles.put(START_DATE, "Start Date");
			titles.put(END_DATE, "End Date");
			obj.put("distinct", distinct);
			obj.put("datepicker", datepicker);
			obj.put("userInfo", usersInfo);
			obj.put(TITLES, titles);
			return obj.toString();
		} catch (Exception e) {
			_log.error("getFilterColumnHeader exception: " + e);
			response = error;
		}
		return response;
	}

	public List<String> getMicroserviceModelFilterColumnList(
			ResourceRequest resourceRequest, String modelName) {

		String response = null;
		String[] tempArray = null;
		try {
			String subUrl = modelName.toLowerCase() + "/getFilterColumns";
			response = new APICall(resourceRequest).exchange(subUrl,
					HttpMethod.GET);
			tempArray = response.split(",");
		} catch (Exception e) {
			 _log.error(e);
			response = e.toString();
		}
		return (Arrays.asList(tempArray));

	}

	public Map<String, String> getMicroserviceModelColumnTitleMap(
			ResourceRequest resourceRequest, String modelName) {

		Map<String, String> map = new HashMap<>();
		String response = null;
		try {
			String subUrl = modelName.toLowerCase() + "/getColumnTitleMap";
			response = new APICall(resourceRequest).exchange(subUrl,
					HttpMethod.GET);
			response = response.substring(1, response.length() - 1);
			String[] keyValuePairs = response.split(",");
			for (String pair : keyValuePairs) {
				String[] entry = pair.split("=");
				map.put(entry[0].trim(), entry[1].trim());
			}

		} catch (Exception e) {
			_log.error(e);
			response = e.toString();
		}
		return map;
	}
	
	public void saveCurrentQuery(String query, ResourceRequest resourceRequest) {
		_log.debug("saveCurrentQuery invoked");

		PortletSession session = resourceRequest.getPortletSession();
		session.setAttribute(SESSION_CURRENTQUERY, query, PortletSession.PORTLET_SCOPE);
	}
	
	public void exportPdf(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			String data = resourceRequest.getParameter("data");
			String pdfUrl = "proctorrostor" + "/exportpdf";
			new APICall(resourceRequest).downloadPdf(data, pdfUrl, HttpMethod.POST, resourceResponse);
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	


}