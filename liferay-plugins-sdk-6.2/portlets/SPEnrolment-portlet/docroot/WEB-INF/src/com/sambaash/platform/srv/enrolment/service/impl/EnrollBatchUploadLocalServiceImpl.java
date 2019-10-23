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

package com.sambaash.platform.srv.enrolment.service.impl;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ResourceRequest;

import org.apache.poi.ss.usermodel.Row;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload;
import com.sambaash.platform.srv.enrolment.service.base.EnrollBatchUploadLocalServiceBaseImpl;
import com.sambaash.platform.srv.enrolment.service.persistence.EnrollBatchUploadUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the enroll batch upload local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.enrolment.service.EnrollBatchUploadLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Baxture
 * @see com.sambaash.platform.srv.enrolment.service.base.EnrollBatchUploadLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.enrolment.service.EnrollBatchUploadLocalServiceUtil
 */
public class EnrollBatchUploadLocalServiceImpl
	extends EnrollBatchUploadLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.enrolment.service.EnrollBatchUploadLocalServiceUtil} to access the enroll batch upload local service.
	 */
	private static final Log _log = LogFactoryUtil.getLog(EnrollBatchUploadLocalServiceImpl.class);
	private static String error = "error";
	private static String formStorageId = "formStorageId";
	private static String formType = "formType";
	private static String sortBy = "sortBy";
	private static String restUriGet = "/get/";
	private static String restUriSize = "&size=";
	private static String requestURL = "Request URL";
	private static String restUriContentType = "ContentType:";
	private static String restUriLimit = "limit";
	RestTemplate restTemplate = new RestTemplate();
	
	public class APICall {
		long userId = 0;
		long siteId = 0;
		HttpHeaders headers;
		HttpEntity<String> httprequest;
		String baseUrl = "";
		
		public APICall(ResourceRequest request) {
				userId = PortalUtil.getUserId(request);
				try {
					siteId = PortalUtil.getScopeGroupId(request);
				} catch (PortalException | SystemException e) {
					_log.error(e.getMessage());
				}
				headers = new HttpHeaders();
				headers.add("X-SCOPEGROUP-ID", "" + SambaashUtil.getScopeGroupId(siteId));
				headers.add("X-USER-ID", "" + userId);
				baseUrl = SambaashUtil.getParameter(SambaashConstants.API_STORAGE_ENGINE_BASEURL,
						SambaashConstants.DEFAULT_GROUP_ID_LONG);

			

		}
		public APICall(ActionRequest request) {
			
			userId = PortalUtil.getUserId(request);
			try {
				siteId = PortalUtil.getScopeGroupId(request);
			} catch (PortalException | SystemException e) {
				_log.error(e.getMessage());
			}
			headers = new HttpHeaders();
			headers.add("X-SCOPEGROUP-ID", "" + SambaashUtil.getScopeGroupId(siteId));
			headers.add("X-USER-ID", "" + userId);
			baseUrl = SambaashUtil.getParameter(SambaashConstants.API_STORAGE_ENGINE_BASEURL,
					SambaashConstants.DEFAULT_GROUP_ID_LONG);

		

	}

		public APICall(long userId, long siteId) throws PortalException {
			headers = new HttpHeaders();
			headers.add("X-SCOPEGROUP-ID", "" + SambaashUtil.getScopeGroupId(siteId));
			headers.add("X-USER-ID", "" + userId);
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

		@SuppressWarnings({ "rawtypes", "unchecked" })
		private Map downloadFile(String subUrl, HttpMethod method) {
			Map response = new HashMap<>();
			httprequest = new HttpEntity<>(headers);
			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<byte[]> httpresponse = restTemplate.exchange(uri, method, httprequest, byte[].class);
				_log.debug(requestURL + baseUrl + subUrl);
				response.put("content", httpresponse.getBody());
				response.put("contentType", httpresponse.getHeaders().getContentType());
			} catch (Exception e) {
				_log.error(requestURL + baseUrl + subUrl);
				_log.error(e);
			}

			return response;
		}

		private String putForObject(String data, String subUrl) {
			String response = "0";
			try {
				headers.setContentType(MediaType.APPLICATION_JSON);
				HttpMethod method = HttpMethod.PUT;
				httprequest = new HttpEntity<>(data, headers);
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<String> httpresponse = restTemplate.exchange(uri, method, httprequest, String.class);
				response = httpresponse.getBody();
				return response;
			} catch (Exception e) {
				_log.error(requestURL + baseUrl + subUrl);
				_log.error(e);
				return response;
			}
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
		private String uploadObjectNew(File file, String fileName,long companyId,String semester,String formId, String subUrl, String downloadUrlPattern) {
			String response = "0";
			try {
				LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
				FileSystemResource value = new FileSystemResource(file);
				map.add("filename", fileName);
				map.add("file", value);
				map.add("companyId", String.valueOf(companyId));
				map.add("formId", formId);
				map.add("semester", semester);
				if (Validator.isNotNull(downloadUrlPattern)) {
					map.add("downloadUrlPattern", downloadUrlPattern);
				}
				headers.setContentType(MediaType.MULTIPART_FORM_DATA);
				HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);

				ResponseEntity<String> httpresponse = restTemplate.exchange(baseUrl + subUrl, HttpMethod.POST,
						requestEntity, String.class);
				response = httpresponse.getBody();
				return response;

			} catch (Exception e) {
				_log.error(e);
				return response;
			}
		}

		

		

	}
	
	public EnrollBatchUpload addEnrollUploadStat(String uploadTransactId, String errorField, String errorReason,
			long userId, long uploadedRecId) throws SystemException {
		
		EnrollBatchUpload enrollUploadStat = enrollBatchUploadPersistence.create(CounterLocalServiceUtil.increment());
		
		enrollUploadStat.setUploadTransactId(uploadTransactId);
		enrollUploadStat.setErrorField(errorField);
		enrollUploadStat.setErrorReason(errorReason);
		enrollUploadStat.setUserId(userId);
		enrollUploadStat.setCreateDate(new Date());
		enrollUploadStat.setModifiedDate(new Date());
		enrollUploadStat.setUploadedRecId(uploadedRecId);
		
		enrollUploadStat = enrollBatchUploadPersistence.update(enrollUploadStat);
		
		return enrollUploadStat;
		
	}
	
	public List<EnrollBatchUpload> findByUploadTransactId(
			java.lang.String uploadTransactId)
			throws com.liferay.portal.kernel.exception.SystemException {
			return EnrollBatchUploadUtil.findByUploadTransactId(uploadTransactId);
		}
	
	public void deleteAllLocations(){
	    try{
	    	EnrollBatchUploadUtil.removeAll();
	    }catch(Exception ex){
	        // Log exception here.
	    }
	}
	public String handleBatchUploadFile(ActionRequest request, ActionResponse response) {

		JSONObject retObj = JSONFactoryUtil.createJSONObject();
		JSONArray objArr = JSONFactoryUtil.createJSONArray();
		
		List<String> dataColumns = new ArrayList<>();
		String objResponse = "";
		Row row = null;
		JSONObject fields = JSONFactoryUtil.createJSONObject();
		JSONObject parentFields = JSONFactoryUtil.createJSONObject();
		JSONObject childFields = JSONFactoryUtil.createJSONObject();
		//fields.toString()
		try {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
			File file1 = uploadRequest.getFile("myFile");
			String fileName = uploadRequest.getFileName("myFile");
			long companyId = PortalUtil.getCompanyId(request);
			String semester = uploadRequest.getParameter("semester");
			String formId = uploadRequest.getParameter("formId");
			String downloadUrlPattern = "";
			JSONObject obj1 = JSONFactoryUtil.createJSONObject();
			String modelName = uploadRequest.getParameter("formType").toLowerCase();
			String subUrl = modelName + "/newbatch";

			objResponse = new APICall(request).uploadObjectNew(file1, fileName,companyId,semester,formId, subUrl, downloadUrlPattern);
			if (Validator.isNotNull(objResponse)) {
				objArr.put(JSONFactoryUtil.createJSONObject(objResponse));

			} else {
				obj1.put("error", "Error uploading the file.");
			}
			retObj.put("result", objArr);
			retObj.put("data", objArr.getJSONObject(0));
			objResponse = retObj.toString();
			//response.getWriter().write(retObj.toString());
			//response.setRenderParameter("result", retObj.toString());

		} catch (JSONException e1) {
			_log.error(e1);
		}
		return objResponse;
	}
}