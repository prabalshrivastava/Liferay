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

package com.sambaash.platform.ato.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.api.client.util.IOUtils;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.ato.service.base.SPATOAdmissionLocalServiceBaseImpl;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.model.microservicemodel.MicroServiceModel;
import com.sambaash.platform.srv.spservices.model.SPListType;
import com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.util.SambaashUtil;
import com.sambaash.platform.srv.startupprofile.model.SPATOContacts;
import com.liferay.portal.model.User;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.SPATOContactsLocalServiceUtil;;



/**
 * The implementation of the s p a t o admission local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.ato.service.SPATOAdmissionLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author keyur.kalariya
 * @see com.sambaash.platform.ato.service.base.SPATOAdmissionLocalServiceBaseImpl
 * @see com.sambaash.platform.ato.service.SPATOAdmissionLocalServiceUtil
 */
public class SPATOAdmissionLocalServiceImpl extends
		SPATOAdmissionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.ato.service.SPATOAdmissionLocalServiceUtil} to
	 * access the s p a t o admission local service.
	 */
	private static final Log _log = LogFactoryUtil
			.getLog(SPATOAdmissionLocalServiceImpl.class);
	private static final String CACHE_CONTROL_PROP = "max-age=00, must-revalidate";

	private static String error = "error";
	private static String formStorageId = "formStorageId";
	private static String formType = "formType";
	private static String requestURL = "Request URL";
	private static final String ADMINISTRATOR = "Administrator";

	RestTemplate restTemplate = new RestTemplate();

	public class APICall {
		long userId = 0;
		long siteId = 0;
		HttpHeaders headers;
		HttpEntity<String> httprequest;
		String baseUrl = StringPool.BLANK;

		public APICall(ResourceRequest request) {
			userId = PortalUtil.getUserId(request);
			try {
				siteId = PortalUtil.getScopeGroupId(request);
			} catch (PortalException | SystemException e) {
				_log.error(e);
			}
			headers = new HttpHeaders();
			headers.add("X-SCOPEGROUP-ID",
					StringPool.BLANK + SambaashUtil.getScopeGroupId(siteId));
			headers.add("X-USER-ID", StringPool.BLANK + userId);
			headers.add("Cache-Control", "must-revalidate,no-cache,no-store");
			baseUrl = SambaashUtil.getParameter(
					SambaashConstants.API_STORAGE_ENGINE_BASEURL,
					SambaashConstants.DEFAULT_GROUP_ID_LONG);

		}

		public APICall(ActionRequest request) {

			userId = PortalUtil.getUserId(request);
			try {
				siteId = PortalUtil.getScopeGroupId(request);
			} catch (PortalException | SystemException e) {
				_log.error(e);
			}
			headers = new HttpHeaders();
			headers.add("X-SCOPEGROUP-ID",
					StringPool.BLANK + SambaashUtil.getScopeGroupId(siteId));
			headers.add("X-USER-ID", StringPool.BLANK + userId);
			headers.add("Cache-Control", "must-revalidate,no-cache,no-store");
			baseUrl = SambaashUtil.getParameter(
					SambaashConstants.API_STORAGE_ENGINE_BASEURL,
					SambaashConstants.DEFAULT_GROUP_ID_LONG);

		}

		public APICall(long userId, long siteId) throws PortalException {
			headers = new HttpHeaders();
			headers.add("X-SCOPEGROUP-ID",
					StringPool.BLANK + SambaashUtil.getScopeGroupId(siteId));
			headers.add("X-USER-ID", StringPool.BLANK + userId);
			headers.add("Cache-Control", "must-revalidate,no-cache,no-store");
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
				ResponseEntity<byte[]> httpresponse = restTemplate.exchange(
						uri, method, httprequest, byte[].class);
				response.put("content", httpresponse.getBody());
				response.put("contentType", httpresponse.getHeaders()
						.getContentType());
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

		private String uploadObjectNew(File file, String fileName,
				String subUrl, String formId, long companyId, long siteId,
				String atoName, Long atoId, String tranDetReq, String atoEmail,
				String componet) {
			String response = "0";
			try {
				LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
				FileSystemResource value = new FileSystemResource(file);
				map.add("filename", fileName);
				map.add("file", value);
				map.add("companyId", String.valueOf(companyId));
				map.add("formId", formId);
				map.add("siteId", String.valueOf(siteId));
				map.add("atoId", String.valueOf(atoId));
				map.add("atoName", atoName);
				map.add("atoEmail", atoEmail);
				map.add("tranDetReq", tranDetReq);
				map.add("componet", componet);

				headers.setContentType(MediaType.MULTIPART_FORM_DATA);
				HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(
						map, headers);

				ResponseEntity<String> httpresponse = restTemplate.exchange(
						baseUrl + subUrl, HttpMethod.POST, requestEntity,
						String.class);
				response = httpresponse.getBody();
				return response;

			} catch (Exception e) {
				_log.error(e);
				return response;
			}
		}

		private void downloadPdf(String data, String subUrl, HttpMethod method,
				ResourceResponse resourceResponse) {
			headers.setContentType(MediaType.APPLICATION_JSON);
			httprequest = new HttpEntity<>(data, headers);
			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<Resource> httpresponse = restTemplate.exchange(
						uri, method, httprequest, Resource.class);
				if (httpresponse.getStatusCode().equals(HttpStatus.OK)) {
					resourceResponse.setContentType("application/zip");
					resourceResponse
							.addProperty(
									com.liferay.portal.kernel.servlet.HttpHeaders.CACHE_CONTROL,
									CACHE_CONTROL_PROP);
					downloadPdfWriteData(resourceResponse, httpresponse);
				}
			} catch (Exception e) {
				_log.error(requestURL + baseUrl + subUrl);
				_log.error(e);
			}
		}

		private void downloadPdfWriteData(ResourceResponse resourceResponse,
				ResponseEntity<Resource> httpresponse) {
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

	public Map<String, String> getListOfComponent(Long groupId, String key) {
		try {

			List<SPListType> spListTypeList = SPListTypeLocalServiceUtil
					.getByKey(key, groupId);
			Map<String, String> result = new HashMap();
			if (spListTypeList.size() > 0) {

				for (SPListType spListType : spListTypeList) {
					result.put(spListType.getItemValue(),
							spListType.getDisplayName());
				}
				return result;
			}
		} catch (SystemException ex) {
			_log.error(ex);
		}
		return null;
	}

	public String handleBatchUploadFile(ActionRequest request,
			ActionResponse response, String creditTerms) {
		if (creditTerms == null) {
			PortletPreferences preferences = request.getPreferences();
			creditTerms = ParamUtil.getString(request, "creditTerms",
					StringPool.BLANK);
		}
		long siteId = 0;
		JSONObject retObj = JSONFactoryUtil.createJSONObject();
		JSONArray objArr = JSONFactoryUtil.createJSONArray();

		String objResponse = StringPool.BLANK;
		try {
			org.json.JSONObject jsonObj = new org.json.JSONObject();

			jsonObj.put(
					"FunctionalComponent",
					getSPListParamVal(
							"finance.referencenumber.functionalcomponent",
							"Ato"));
			jsonObj.put("SourceType",
					getSPListParamId("finance.transaction.sourcetype", "Ato"));
			jsonObj.put("Source", "Source");
			jsonObj.put(
					"Type",
					getSPListParamId("finance.accountingtable.clienttype",
							"Corporate"));
			jsonObj.put(
					"CategoryType",
					getSPListParamId("finance.referencenumber.categorytype",
							"Invoice"));
			jsonObj.put(
					"TxnType",
					getSPListParamId("finance.accountingtable.transactiontype",
							"Invoice"));
			jsonObj.put("CreditTerm", creditTerms);

			String tranDet = jsonObj.toString();
			UploadPortletRequest uploadRequest = PortalUtil
					.getUploadPortletRequest(request);
			File file1 = uploadRequest.getFile("myFile");
			String fileName = uploadRequest.getFileName("myFile");
			long companyId = PortalUtil.getCompanyId(request);
			siteId = PortalUtil.getScopeGroupId(request);

			String formId = uploadRequest.getParameter("formId");
			long orgId = Long.parseLong(uploadRequest.getParameter("ato")
					.toString());
			String componet = uploadRequest.getParameter("component")
					.toString();
			Organization org = (Organization) com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil
					.getOrganization(orgId);
			JSONObject obj1 = JSONFactoryUtil.createJSONObject();
			String subUrl = "atoadmission" + "/batchEnroll";

			objResponse = new APICall(request).uploadObjectNew(file1, fileName,
					subUrl, formId, companyId, siteId, org.getName(),
					org.getOrganizationId(), tranDet, org.getEmailId(),
					componet);
			if (Validator.isNotNull(objResponse)) {
				objArr.put(JSONFactoryUtil.createJSONObject(objResponse));

			} else {
				obj1.put("error", "Error uploading the file.");
			}
			retObj.put("result", objArr);
			retObj.put("data", objArr.getJSONObject(0));
			objResponse = retObj.toString();
			
			JSONArray validRecords = JSONFactoryUtil.createJSONArray();
			validRecords = JSONFactoryUtil.createJSONObject(objResponse).getJSONArray("result").getJSONObject(0).getJSONArray("validRecords");
			if(validRecords != null)
			{
				for(int i =0 ; i < validRecords.length() ; i++)
				{
					JSONObject contentJson = JSONFactoryUtil.createJSONObject(validRecords.getString(i));
					JSONObject validRecord = JSONFactoryUtil.createJSONObject(validRecords.getString(i)).getJSONObject("contentJson");
					SPATOContacts atoContacts = OrganizationLocalServiceUtil.getSPATOContacts(orgId);
					
					if(atoContacts != null)
					{
//						SystemLocalServiceUtil.addTimelineActivity("/pay-online?id="+ validRecord.getString("TransactionMasterCode"), 
//								"Pay Now", 
//								"Pay Now", 
//								"Pay now for " + validRecord.getString("CandidateName"), 
//								"", 
//								validRecord.getString("ProcessStatus"), 
//								Long.parseLong(contentJson.getString("createdBy")), 
//								"Pay Now", 
//								"Pay Now", 
//								SambaashUtil.getPageSubProductSettings(((LiferayPortletRequest)request).getHttpServletRequest()), 
//								"", 
//								String.valueOf(atoContacts.getPrimaryPrincipalUserId()), 
//								SambaashUtil.getScopeGroupId(siteId));
						
						SystemLocalServiceUtil.addTimelineActivity("/ato-sponsored-candidate", 
								"Pay Now", 
								"Pay Now", 
								"Pay now for " + validRecord.getString("CandidateName"), 
								"", 
								validRecord.getString("ProcessStatus"), 
								Long.parseLong(contentJson.getString("createdBy")), 
								"Pay Now", 
								"Pay Now", 
								SambaashUtil.getPageSubProductSettings(((LiferayPortletRequest)request).getHttpServletRequest()), 
								"", 
								String.valueOf(atoContacts.getPrimaryPrincipalUserId()), 
								SambaashUtil.getScopeGroupId(siteId));
						
//						SystemLocalServiceUtil.addTimelineActivity("/pay-online?id="+ validRecord.getString("TransactionMasterCode"), 
//								"Pay Now", 
//								"Pay Now", 
//								"Pay now for " + validRecord.getString("CandidateName"), 
//								"", 
//								validRecord.getString("ProcessStatus"), 
//								Long.parseLong(contentJson.getString("createdBy")), 
//								"Pay Now", 
//								"Pay Now", 
//								SambaashUtil.getPageSubProductSettings(((LiferayPortletRequest)request).getHttpServletRequest()), 
//								"", 
//								String.valueOf(atoContacts.getSecondaryPrincipalUserId()), 
//								SambaashUtil.getScopeGroupId(siteId));
						
						SystemLocalServiceUtil.addTimelineActivity("/ato-sponsored-candidate", 
								"Pay Now", 
								"Pay Now", 
								"Pay now for " + validRecord.getString("CandidateName"), 
								"", 
								validRecord.getString("ProcessStatus"), 
								Long.parseLong(contentJson.getString("createdBy")), 
								"Pay Now", 
								"Pay Now", 
								SambaashUtil.getPageSubProductSettings(((LiferayPortletRequest)request).getHttpServletRequest()), 
								"", 
								String.valueOf(atoContacts.getSecondaryPrincipalUserId()), 
								SambaashUtil.getScopeGroupId(siteId));
					}
				}
			}
			
		} catch (PortalException | SystemException | org.json.JSONException ex) {
			_log.error(ex);
		}
		return objResponse;
	}

	public String getSPListParamVal(String key, String displayName) {
		try {
			List<SPListType> spListTypeList = SPListTypeLocalServiceUtil
					.getByKey(key, 0);
			for (SPListType spListType : spListTypeList) {
				if (spListType.getDisplayName().equalsIgnoreCase(displayName)) {
					return spListType.getItemValue().toString();
				}
			}

		} catch (SystemException ex) {
			_log.error(ex);
		}
		return null;
	}

	public String getSPListParamId(String key, String displayName) {

		try {
			List<SPListType> spListTypeList = SPListTypeLocalServiceUtil
					.getByKey(key, 0);

			for (SPListType spListType : spListTypeList) {
				if (spListType.getDisplayName().equalsIgnoreCase(displayName)) {
					return String.valueOf(spListType.getSpListTypeId());
				}
			}

		} catch (SystemException ex) {
			_log.error(ex);
		}
		return null;
	}

	public String convertToAPIModel(ResourceRequest resourceRequest,
			String modelData, String existingData) throws JSONException {
		JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(modelData);
		JSONObject jsonModelExistingData = JSONFactoryUtil
				.createJSONObject(existingData);

		return FormIOToModelJSON(resourceRequest, jsonModelData,
				jsonModelExistingData).toString();

	}

	public String convertToFormModel(String existingData, String modelName)
			throws JSONException {

		JSONObject jsonModelExistingData = JSONFactoryUtil
				.createJSONObject(existingData);
		Class<?> c = getClass();
		try {
			c = Class.forName("com.sambaash.platform.model.microservicemodel."
					+ modelName + "Model");

		} catch (ClassNotFoundException e) {
			try {
				c = Class
						.forName("com.sambaash.platform.model.microservicemodel.MicroServiceModel");

			} catch (ClassNotFoundException e1) {
				_log.error(e1);
			}
		}
		MicroServiceModel model = new MicroServiceModel();
		try {
			model = (MicroServiceModel) c.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			_log.error(e);
		}
		return model.ModelToFormIOJSON(jsonModelExistingData).toString();

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
		String[] tempArray = null;
		try {
			String subUrl = modelName.toLowerCase() + "/getColumns";
			response = new APICall(resourceRequest).exchange(subUrl,
					HttpMethod.GET);
			tempArray = response.split(",");

		} catch (Exception e) {
			response = e.toString();
		}
		return (Arrays.asList(tempArray));

	}

	public String archiveRecord(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {

		String response = null;
		try {
			String storageId = resourceRequest.getParameter(formStorageId);
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + "/archive/" + storageId;
			response = new APICall(resourceRequest).exchange(subUrl,
					HttpMethod.DELETE);

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

			String subUrl = "/atoadmission/self-sponsor";

			response = new APICall(resourceRequest).postForObject(modeldata,
					subUrl);
		} catch (Exception e) {
			_log.error(e);
		}
		return response;

	}

	public String changeProcessStatus(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		String response = StringPool.BLANK;
		try {
			String modeldata = resourceRequest.getParameter("data");

			String subUrl = "/atoadmission/process-status";

			response = new APICall(resourceRequest).postForObject(modeldata,
					subUrl);
		} catch (Exception e) {
			_log.error(e);
		}
		return response;

	}

	public void exportPdf(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		try {
			String data = resourceRequest.getParameter("data");
			String pdfUrl = "/atoadmission/downloadpdf";

			new APICall(resourceRequest).downloadPdf(data, pdfUrl,
					HttpMethod.POST, resourceResponse);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public String sendInvoice(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		String response = StringPool.BLANK;
		try {
			String data = resourceRequest.getParameter("data");

			org.json.JSONObject jsonObj = new org.json.JSONObject(data);
			org.json.JSONArray jsoArr =jsonObj.getJSONArray("contentJson");
			for(int i=0;i<jsoArr.length();i++)
			{
				org.json.JSONObject detObj=(org.json.JSONObject)jsoArr.get(i);
				Organization org = (Organization) com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil
						.getOrganization(detObj.getLong("atoId"));
				User user = UserLocalServiceUtil.getUser(org.getUserId());
				SPATOContacts atoContacts = OrganizationLocalServiceUtil.getSPATOContacts(detObj.getLong("atoId"));
				
				if(atoContacts != null)
				{
					if(atoContacts.getPrimaryPrincipalUserId() != null)
					{
						User trainingPricipalUser = UserLocalServiceUtil.getUser(Long.parseLong(atoContacts.getPrimaryPrincipalUserId()));
						detObj.put("trainingPricipal", trainingPricipalUser.getEmailAddress());
					}
					else
					{
						detObj.put("trainingPricipal", StringUtils.EMPTY);
					}
					if(atoContacts.getSecondaryPrincipalUserId() != null)
					{
						User secondaryPrincipalUser = UserLocalServiceUtil.getUser(Long.parseLong(atoContacts.getSecondaryPrincipalUserId()));
						detObj.put("secondaryContact", secondaryPrincipalUser.getEmailAddress());
					}
					else
					{
						detObj.put("secondaryContact", StringUtils.EMPTY);
					}
					
					//detObj.put("trainingPricipal", atoContacts.getPrimaryPrincipalUserEmail());
					//detObj.put("secondaryContact", atoContacts.getSecondaryPrincipalUserEmail());
					
				}
				else
				{
					detObj.put("trainingPricipal", StringUtils.EMPTY);
					detObj.put("secondaryContact", StringUtils.EMPTY);
					
				}
				
				if(user != null)
				{
					detObj.put("CorporateAccountRepresentative", user.getEmailAddress());
				}
				else
				{
					detObj.put("CorporateAccountRepresentative", StringUtils.EMPTY);
				}
				
				
				jsoArr.put(i, detObj);
				
			}
			org.json.JSONObject reqObj=new org.json.JSONObject();
			reqObj.put("contentJson", jsoArr);
		
		
			String subUrl = "/atoadmission/sendInvoice";

			response = new APICall(resourceRequest).postForObject(reqObj.toString(), subUrl);
		} catch (Exception e) {
			_log.error(e);
		}
		return response;

	}
	
	public String sendInvoiceToCantidate(long userId, long siteId,String storageIds) {
		String response = "Success";
		try{
			String subUrl = "/atoadmission/self-sponsor/email-invoice";
			response = new APICall(userId,siteId).postForObject(storageIds, subUrl);
		} catch (Exception e) {
			response = "Error " + e.getMessage();
			_log.error(e);
		}
		return response;

	}

	public boolean isATO(HttpServletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		try {
			return RoleServiceUtil.hasUserRoles(userId,
					themeDisplay.getCompanyId(), new String[] { "ato",
							ADMINISTRATOR }, true);
		} catch (PortalException | SystemException e) {
			_log.error(e);
			return false;
		}
	}
	public String getUserType(String secondaryContact,
			String trainingRole,  Long userIdForRole) {

		try {
			String returnRole="";
			List<Role> userRole = RoleLocalServiceUtil
					.getUserRoles(userIdForRole);
			List<String> roleNameLst = new ArrayList<String>();
			for (Role role : userRole) {
				
				_log.info("user Role :: " + role.getName().toLowerCase());
				roleNameLst.add(role.getName().toLowerCase());
			}
			if (roleNameLst.contains(trainingRole.toLowerCase())) {

				returnRole+= "TrainingPrincipal,";
			} 
			if (roleNameLst.contains(secondaryContact.toLowerCase())) {

				returnRole+= "SecondaryContact";
			} 
			if(returnRole=="") {
				return "";
			}
			else
			{
				return returnRole;
			}
		} catch (Exception ex) {
			_log.error(ex);
		}
		return "";
	}

	public String getAtoName(String userType,  Long userIdForRole)
	{
		String atoName="";
		try {
			String[] typesOfuser=userType.split(",");
			for (String string : typesOfuser) {
				
			
				if(string.equalsIgnoreCase("TrainingPrincipal"))
				{
					List<SPATOContacts> contactsList=	SPATOContactsLocalServiceUtil.findATOContactsByTrainingPrincipal(userIdForRole);
					for (SPATOContacts spatoContacts : contactsList) {
						atoName+=spatoContacts.getOrganizationId()+",";
					}
					
				
				}
				if(string.equalsIgnoreCase("SecondaryContact"))
				{
					
					List<SPATOContacts> contactsList=	SPATOContactsLocalServiceUtil.findATOContactsBySecondaryContact(userIdForRole);
					for (SPATOContacts spatoContacts : contactsList) {
						atoName+=spatoContacts.getOrganizationId()+",";
					}
					
				}
			}
			return atoName;
			
		} catch (Exception ex) {
			_log.error(ex);
		}
		return "";
	}
}
