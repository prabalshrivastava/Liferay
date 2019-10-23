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

package com.sambaash.platform.srv.exam.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.model.microservicemodel.MicroServiceModel;
import com.sambaash.platform.srv.exam.service.base.SPExamLocalServiceBaseImpl;
import com.sambaash.platform.srv.spservices.model.SPListType;
import com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the s p exam local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.exam.service.SPExamLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sunil.sharma
 * @see com.sambaash.platform.srv.exam.service.base.SPExamLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.exam.service.SPExamLocalServiceUtil
 */
public class SPExamLocalServiceImpl extends SPExamLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.exam.service.SPExamLocalServiceUtil} to access the s p exam local service.
	 */
	
	private static final String TOTAL_ELEMENTS = "totalElements";
	private static final String TITLES = "titles";
	private static final String ORDER = "order";
	private static final String LAST_MODIFIED_DATE = "lastModifiedDate";
	private static final String CREATED_DATE = "createdDate";
	private static final String LAST_MODIFIED_BY = "lastModifiedBy";
	private static final String CREATED_BY = "createdBy";
	private static final String SESSION_CURRENTQUERY = "currentquery";
	private static final String SESSION_EXPORTQUERY = "exportquery";
	private static final String MICROSERVICEMODEL_PACKAGE = "com.sambaash.platform.model.microservicemodel.MicroServiceModel";
	private static final String CONTENT_JSON_PREFIX = "contentJson.";
	private static final String MODEL_PACKAGE_POSTFIX = "Model";
	private static final String MICROSERVICEMODEL_PACKAGE_PREFIX = "com.sambaash.platform.model.microservicemodel.";

	private static final Log _log = LogFactoryUtil.getLog(SPExamLocalServiceImpl.class);
	private static String error = "error";
	private static String formStorageId = "formStorageId";
	private static String formType = "formType";
	private static String sortBy = "sortBy";
	private static String restUriGet = "/get/";
	private static String restUriSize = "&size=";
	private static String requestURL = "Request URL";
	private static String restUriContentType = "ContentType:";
	private static String restUriLimit = "limit";
	private static Map<String, String[]> modelToColumnMap = new HashMap();
	private static Map<String, String[]> columnToKeyMap = new HashMap();
	
	static {
		modelToColumnMap.put("transactiondocument", new String[]{"ProductType","ProductSubType","FunctionalComponent"
				,"CategoryType","Type","AdvanceInvoice","TemplateFor"});
		modelToColumnMap.put("referencenumber", new String[]{"ProductType","ProductSubType","FunctionalComponent"
				,"CategoryType","Type","SequenceNoReset","Frequency"});
		modelToColumnMap.put("transactionmaster", new String[]{"ProductType","ProductSubType","FunctionalComponent"
				,"CategoryType","Type","NameOfPayer"});
		modelToColumnMap.put("invoiceremarks", new String[]{});
		columnToKeyMap.put("AdvanceInvoice", new String[]{"finance.transactiondocument.advanceinvoice"});
		columnToKeyMap.put("FunctionalComponent", new String[]{"finance.referencenumber.functionalcomponent"});
		columnToKeyMap.put("TemplateFor", new String[]{"finance.transactiondocument.templatefor"});
		columnToKeyMap.put("Frequency", new String[]{"finance.referencenumber.frequency"});
	}
	
	public class APICall {
		long userId = 0;
		long siteId = 0;
		PortletRequest req;
		HttpHeaders headers;
		HttpEntity<String> httprequest;
		RestTemplate restTemplate;
		String baseUrl = "";

		public APICall(PortletRequest request) {
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

		public APICall(long userId, long siteId) throws PortalException {
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
				response = httpresponse.getBody();

			} catch (Exception e) {
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
		private void downloadPdf(String data, String subUrl, HttpMethod method, ResourceRequest resourceRequest,
				ResourceResponse resourceResponse) {
			headers.setContentType(MediaType.APPLICATION_JSON);
			httprequest = new HttpEntity<>(data, headers);
			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<Resource> httpresponse = restTemplate.exchange(uri, method, httprequest, Resource.class);
				if (httpresponse.getStatusCode().equals(HttpStatus.OK)) {
					try (OutputStream out = resourceResponse.getPortletOutputStream();
							InputStream in = httpresponse.getBody().getInputStream()) {
						resourceResponse.setContentType("application/pdf");
						IOUtils.copy(in, out);
						out.flush();
						resourceResponse.flushBuffer();
					} catch (final IOException e) {
						_log.error(e);
					}
				}
			} catch (Exception e) {
				_log.error(requestURL + baseUrl + subUrl);
				_log.error(e);
			}
		}
		private void downloadObjects(String data,String subUrl, HttpMethod method, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
			headers.setContentType(MediaType.APPLICATION_JSON);
			httprequest = new HttpEntity<>(data,headers);
			XSSFWorkbook workbook = new XSSFWorkbook();
			String fileName = "download.xlsx";
			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<String> httpresponse = restTemplate.exchange(uri, method, httprequest, String.class);
				if(httpresponse.getStatusCode().equals(HttpStatus.OK)){
					
					String response2 = httpresponse.getBody();
					String model = resourceRequest.getParameter(formType).toLowerCase();
					if(modelToColumnMap.get(model) != null){
						response2 = setSPListTypeDecriptions(resourceRequest, response2, modelToColumnMap.get(model));
					}
					org.json.JSONObject responseObject = new org.json.JSONObject(response2);
					org.json.JSONArray content =   responseObject.getJSONArray("content");
					
					org.json.JSONObject exportSourceJson = new org.json.JSONObject(data);
					org.json.JSONObject jsonTitles = (org.json.JSONObject) exportSourceJson.get("titles");
			
					org.json.JSONArray jsonTitlesOrder = (org.json.JSONArray) exportSourceJson.get("order");
			        ArrayList<String> jsonOrder = new ArrayList<>();
			        for (int i = 0; i < jsonTitlesOrder.length(); i++) {
			            jsonOrder.add(jsonTitlesOrder.getString(i));
			        }
			        String[] order = jsonOrder.toArray(new String[0]);
			        XSSFSheet sheet = workbook.createSheet(fileName.replace(".xlsx", ""));
			        int rowNum = writeExcelEntityTitle(sheet, jsonTitles, order);
			        for (Integer index = 0; index < content.length(); index++) {
			        	org.json.JSONObject entityJson = content.getJSONObject(index);
			           rowNum = writeExcelEntityRow(sheet, rowNum, entityJson, order);
			        }
			        resourceResponse.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		        	resourceResponse.addProperty("Cache-Control", "max-age=3600, must-revalidate");
		        	resourceResponse.addProperty("Content-Disposition","attachment; filename="+fileName);
			        try(OutputStream outStrm = resourceResponse.getPortletOutputStream()) {
			            workbook.write(outStrm);
			        } catch (IOException e) {
			        	_log.error(e);
			        }
				}
				else{
				}
			} catch (Exception e) {
				_log.error(requestURL + baseUrl + subUrl);
				_log.error(e);
			}
			

		}
		
		private void downloadObject(String data, String subUrl, HttpMethod method, ResourceRequest resourceRequest,
				ResourceResponse resourceResponse) {
			headers.setContentType(MediaType.APPLICATION_JSON);
			httprequest = new HttpEntity<>(data, headers);
			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<Resource> httpresponse = restTemplate.exchange(uri, method, httprequest, Resource.class);
				if (httpresponse.getStatusCode().equals(HttpStatus.OK)) {
					HttpHeaders head = httpresponse.getHeaders();
					MediaType mtype = head.getContentType();
					List<String> contentDisposition = head.get("Content-Disposition");

					resourceResponse
							.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
					resourceResponse.addProperty(com.liferay.portal.kernel.servlet.HttpHeaders.CACHE_CONTROL,
							"max-age=3600, must-revalidate");
					for (String cd : contentDisposition) {
						resourceResponse.addProperty("Content-Disposition", cd);
					}
					try (OutputStream out = resourceResponse.getPortletOutputStream();
							InputStream in = httpresponse.getBody().getInputStream()) {
						Scanner s = new Scanner(in).useDelimiter("\\A");
						String ee = s.hasNext() ? s.next() : "";
						IOUtils.copy(in, out);
						out.flush();
						resourceResponse.flushBuffer();
					} catch (final IOException e) {
						_log.error(e);
					}
				}
			} catch (Exception e) {
				_log.error(requestURL + baseUrl + subUrl);
				_log.error(e);
			}
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
		
		private String uploadObjectNew(File file, String fileName, String subUrl, String downloadUrlPattern) {
			String response = "0";
			try {
				LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
				FileSystemResource value = new FileSystemResource(file);
				map.add("filename", fileName);
				map.add("file", value);
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
	private Integer writeExcelEntityTitle(XSSFSheet sheet, org.json.JSONObject entityTitles, String[] order)
			throws JSONException {

		int rowNum = 0;
		Row row = sheet.createRow(rowNum++);
		int colNum = 0;
		for (int i = 0; i < order.length; i++) {
			Cell cell = row.createCell(colNum++);
			try {
				cell.setCellValue((String) entityTitles.get(order[i]));
			} catch (org.json.JSONException e) {
				_log.error(e);
			}
		}

		return rowNum;
	}
	
	private int writeExcelEntityRow(XSSFSheet sheet, int rowNum, org.json.JSONObject entityJson, String[] order) {

		int colNum = 0;
		Row row = sheet.createRow(rowNum++);
		for (String datakey : order) {
			Cell cell = row.createCell(colNum++);
			Object field = null;
			try {
				if (datakey.contains(CONTENT_JSON_PREFIX))
					field = ((org.json.JSONObject) entityJson.get("contentJson"))
							.get(datakey.replace(CONTENT_JSON_PREFIX, ""));
				else
					field = entityJson.get(datakey);
			} catch (org.json.JSONException e) {
				_log.error(e);
			}
			if (field instanceof String) {
				cell.setCellValue((String) field);

			} else if (field instanceof Integer) {
				cell.setCellValue(String.valueOf(field));
			} else if (field != null) {
				cell.setCellValue(field.toString());
			} else {
				cell.setCellValue("");
			}

		}

		return rowNum;
	}
	
	

	public String createRecord(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = "";
		try {
			String modeldata = resourceRequest.getParameter("data");
			_log.debug("creating data" + modeldata);
			String apiModelData = convertToAPIModel(resourceRequest, modeldata, "");
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + "/new";
			_log.debug("create data" + apiModelData);
			response = new APICall(resourceRequest).postForObject(apiModelData, subUrl);
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}
	
	public String updateRecord(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = "";
		try {
			String storageId = resourceRequest.getParameter(formStorageId);
			String modeldata = resourceRequest.getParameter("data");
			_log.debug("updating data" + modeldata);
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + restUriGet + storageId;
			String existingData = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			
			String apiModelData = convertToAPIModel(resourceRequest, modeldata, existingData);
			_log.debug("update data" + apiModelData);
			URI uriStorageId = URI.create(storageId);
			subUrl = model + "/edit/" + uriStorageId;
			response = new APICall(resourceRequest).putForObject(apiModelData, subUrl);
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}
	
	public String getListing(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = null;
		try {
			String data = resourceRequest.getParameter("data");
			JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(data);
			String limit = jsonModelData.getString(restUriLimit);
			String model = jsonModelData.getString(formType).toLowerCase();
			String page = jsonModelData.getString("page");
			String sortByField = "contentJson.Status";
			if (!jsonModelData.getString(sortBy).equalsIgnoreCase("")) {
				sortByField = "contentJson." + jsonModelData.getString(sortBy);
			}

			String subUrl = model + "/list?page=" + page + restUriSize + limit + "&sort=" + sortByField;
			saveCurrentQuery("{}", resourceRequest);
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);

		} catch (Exception e) {
			_log.error(e);
			response = error;
		}
		return response;

	}	
	public void saveCurrentQuery(String query, ResourceRequest resourceRequest) {
		_log.debug("saveCurrentQuery invoked");

		PortletSession session = resourceRequest.getPortletSession();
		session.setAttribute(SESSION_CURRENTQUERY, query, PortletSession.PORTLET_SCOPE);
	}
	public String getSearchListing(PortletRequest portletRequest , PortletResponse portletResponse){

		String response = null;
		try {
			String data = (String) portletRequest.getParameter("data");
			JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(data);
			
			String limit = jsonModelData.getString(restUriLimit);
			String model = jsonModelData.getString(formType).toLowerCase();
			String page = jsonModelData.getString("page");
			String sortByField = jsonModelData.getString(sortBy);
			JSONArray conditions = jsonModelData.getJSONArray("conditions");
			JSONObject currentquery = JSONFactoryUtil.createJSONObject();

			if (!sortByField.equalsIgnoreCase("")) {
				sortByField = "contentJson." + jsonModelData.getString(sortBy);
			}
			String regexOperator = "=";
			String condition = "";
			StringBuilder bld = new StringBuilder();
			for (int i = 0; i < conditions.length(); i++) {
				bld.append(conditions.getString(i) + "&");
				String[] splitcondition = conditions.getString(i).split(regexOperator);
				currentquery.put(splitcondition[0], splitcondition[1]);
			}

			condition = bld.toString();
			
			String subUrl = model + "/search?" + condition + "page=" + page + restUriSize + limit + "&sort="
					+ sortByField;
			response = new APICall(portletRequest).exchange(subUrl, HttpMethod.GET);

		} catch (Exception e) {
			response = error;
		}
		return response;
		
	}
	
	public String fetchRecord(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = null;
		String existingData = null;
		try {
			String storageId = resourceRequest.getParameter(formStorageId);
			String model = resourceRequest.getParameter(formType);
			String subUrl = model.toLowerCase() + restUriGet + storageId;
			existingData = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			response = convertToFormModel(existingData, model);
		} catch (Exception e) {
			// _log.error(e);
			response = e.toString();
		}
		return response;
	}
	
	
	public String fetchEntityScheduleRecord(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = null;
		String existingData = null;
		try {
			String data = (String) resourceRequest.getParameter("data");
			JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(data);
			
			String model = jsonModelData.getString(formType).toLowerCase();
			String scheduleCode = jsonModelData.getString("scheduleCode");
			/*URLEncoder.encode(scheduleCode, "UTF-8");*/
			String subUrl = model.toLowerCase()+"/getEntityLink/"+URLEncoder.encode(scheduleCode, "UTF-8");
			
			existingData = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			response = existingData;
		} catch (Exception e) {
			response = e.toString();
		}
		return response;
	}
	
	public String removeUserAssignedSeats(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = null;
		String existingData = null;
		try {
			String data = (String) resourceRequest.getParameter("data");
			JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(data);
			
			String model = jsonModelData.getString(formType).toLowerCase();
			String seatingPlanInstanceId = jsonModelData.getString("seatingPlanInstace");
			String actionType = jsonModelData.getString("actionType").toLowerCase();
			String subUrl = model.toLowerCase()+"/"+actionType+"/"+seatingPlanInstanceId;
			
			existingData = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			response = existingData;
		} catch (Exception e) {
			response = e.toString();
		}
		return response;
	}
	

	public String fetchData(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		_log.error("Inside serviceImple fetchData()");
		String response = null;
		String existingData = null;
		try {
			String data = (String) resourceRequest.getParameter("data");
			_log.error(data);
			JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(data);
			String model = jsonModelData.getString(formType).toLowerCase();
			String action = jsonModelData.getString("action").toLowerCase();
			String subUrl = model.toLowerCase()+"/"+action;
			_log.error(subUrl);
			
			existingData = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			_log.error(existingData);
			response = existingData;
		} catch (Exception e) {
			_log.error(e);
			response = e.toString();
		}
		return response;
	}
	public String fetchActionData(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		_log.error("Inside serviceImple fetchActionData()");
		String response = null;
		String existingData = null;
		try {
			String data = (String) resourceRequest.getParameter("data");
			_log.error(data);
			JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(data);
			String model = jsonModelData.getString(formType).toLowerCase();
			String action = jsonModelData.getString("action").toLowerCase();
			String subUrl = model.toLowerCase()+"/"+action;
			_log.error(subUrl);
			
			existingData = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			_log.error(existingData);
			response = existingData;
		} catch (Exception e) {
			_log.error(e);
			response = e.toString();
		}
		return response;
	}
	public String convertToAPIModel(ResourceRequest resourceRequest, String modelData, String existingData)
			throws JSONException {
		JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(modelData);
		JSONObject jsonModelExistingData = JSONFactoryUtil.createJSONObject(existingData);

		return FormIOToModelJSON(resourceRequest, jsonModelData, jsonModelExistingData).toString();

	}
	
	public String convertToFormModel(String existingData, String modelName) throws JSONException {

		JSONObject jsonModelExistingData = JSONFactoryUtil.createJSONObject(existingData);
		Class<?> c = getClass();
		try {
			c = Class.forName("com.sambaash.platform.model.microservicemodel." + modelName + "Model");

		} catch (ClassNotFoundException e) {
			try {
				c = Class.forName("com.sambaash.platform.model.microservicemodel.MicroServiceModel");

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
	
	public JSONObject FormIOToModelJSON(ResourceRequest resourceRequest, JSONObject inp,
			JSONObject jsonModelExistingData) {
		try {
			List<String> columns = getMicroserviceModelColumnList(resourceRequest, inp.getString("ModelName"));
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

					jsonModelExistingData.getJSONObject("contentJson").put(in.names().getString(i),
							in.getString(in.names().getString(i)));

					Object json = in.get(in.names().getString(i));
					if (json instanceof org.json.JSONArray) {
						jsonModelExistingData.getJSONObject("contentJson").put(in.names().getString(i),
								inp.getJSONArray(in.names().getString(i)));
					} else {
						jsonModelExistingData.getJSONObject("contentJson").put(in.names().getString(i),
								in.getString(in.names().getString(i)));
					}
				}
			}
		} catch (Exception e) {

		}

		return jsonModelExistingData;

	}
	
	protected JSONObject No_Op_FormIOToModelJSON(JSONObject in, JSONObject jsonModelExistingData) {
		JSONObject apiJsonModelData = JSONFactoryUtil.createJSONObject();
		apiJsonModelData.put("contentJson", in.toString());
		return apiJsonModelData;
	}
	
	public List<String> getMicroserviceModelColumnList(ResourceRequest resourceRequest, String modelName) {
		String response = null;
		String existingData = null;
		String[] tempArray = null;
		try {
			String subUrl = modelName.toLowerCase() + "/getColumns";
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			tempArray = response.split(",");

		} catch (Exception e) {
			// _log.error(e);
			response = e.toString();
		}
		return (Arrays.asList(tempArray));

	}
	public String archiveRecord(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = null;
		try {
			String storageId = resourceRequest.getParameter(formStorageId);
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + "/archive/" + storageId;
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.DELETE);

		} catch (Exception e) {
			_log.error(e);
			response = error;
		}
		return response;
	}
	
	public String getElasticSearchListing(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = null;
		try {
			String data = resourceRequest.getParameter("data");
			_log.debug(data);
			if (data != null && data != "") {
				JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(data);
				String limit = jsonModelData.getString(restUriLimit);
				String model = jsonModelData.getString(formType).toLowerCase();
				String page = jsonModelData.getString("page");
				String conditions = jsonModelData.getString("conditions");
				JSONArray filters = jsonModelData.getJSONArray("filterdata");
				String subUrl = model + "/elasticsearch?" + "page=" + page + restUriSize + limit;
				String jsonString1 = "";
				JSONArray jsonTerms = JSONFactoryUtil.createJSONArray();
				if (!conditions.equalsIgnoreCase("")) {
					jsonString1 = "{" + "\"query_string\": {" + "\"fields\": [" + "\"contentJson.*\"],"
							+ "\"query\": \"" + conditions + "\"" + "}" + "}";
					JSONObject jsonQuery = JSONFactoryUtil.createJSONObject(jsonString1);

					jsonTerms.put(jsonQuery);
				}

				if (filters != null) {
					for (int index = 0; index < filters.length(); index++) {
						JSONObject term = filters.getJSONObject(index);
						Iterator<String> keys = term.keys();
						while (keys.hasNext()) {
							String key = keys.next();
							String value = term.getString(key);
							String jsonString2 = "{" + "\"terms\": {" + "\"" + key + ".keyword\": [\"" + value + "\"]"
									+ "}" + "}";
							JSONObject jsonTermQuery = JSONFactoryUtil.createJSONObject(jsonString2);
							jsonTerms.put(jsonTermQuery);
						}

					}
				}
				if (filters != null || conditions != null) {
					JSONObject jsonMustClause = JSONFactoryUtil.createJSONObject();
					jsonMustClause.put("must", jsonTerms);
					JSONObject jsonElasticSearchQuery = JSONFactoryUtil.createJSONObject();
					jsonElasticSearchQuery.put("bool", jsonMustClause);
					saveCurrentQuery(jsonElasticSearchQuery.toString(), resourceRequest);
					_log.debug("Posting with requestbody" + jsonElasticSearchQuery.toString());
					response = new APICall(resourceRequest).postForObject(jsonElasticSearchQuery.toString(), subUrl);
					if(modelToColumnMap.get(model) != null){
						response = setSPListTypeDecriptions(resourceRequest, response, modelToColumnMap.get(model));
					}
				}
			} else {
				_log.debug("Search request was empty" + data);
			}
		} catch (Exception e) {
			_log.error(e);
			response = error;
		}
		return response;

	}
	private String setSPListTypeDecriptions(ResourceRequest resourceRequest, String jsonDataString,
			String[] dropDownColumns) throws SystemException, JSONException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		boolean isArray = true;
		JSONObject resp = JSONFactoryUtil.createJSONObject(jsonDataString);
		if (resp.isNull("content")) {
			resp = JSONFactoryUtil.createJSONObject();
			resp.put("content", JSONFactoryUtil.createJSONArray("[" + jsonDataString + "]"));
			isArray = false;
		}
		JSONArray content = resp.getJSONArray("content");
		for (int i = 0; i < content.length(); i++) {
			try {
				populateUserNames(content.getJSONObject(i));
			} catch (Exception e1) {
				_log.error(e1);
			}
			JSONObject contentJson = content.getJSONObject(i).getJSONObject("contentJson");
			replaceValue(contentJson, dropDownColumns, themeDisplay);
		}
		if (isArray) {
			return resp.toString();
		} else {
			return resp.getJSONArray("content").getJSONObject(0).toString();
		}
	}
	private void populateUserNames(JSONObject jsonObject) throws PortalException, SystemException {
		if (!jsonObject.isNull(CREATED_BY)) {
			User user = UserLocalServiceUtil.getUserById(Long.parseLong(jsonObject.getString(CREATED_BY)));
			if(user != null) {
				jsonObject.put(CREATED_BY, user.getFirstName()+" "+user.getLastName());
			}
		}
		if (!jsonObject.isNull(LAST_MODIFIED_BY)) {
			User user = UserLocalServiceUtil.getUserById(Long.parseLong(jsonObject.getString(LAST_MODIFIED_BY)));
			if(user != null) {
				jsonObject.put(LAST_MODIFIED_BY, user.getFirstName()+" "+user.getLastName());
			}
		}
	}
	
	private void replaceValue(JSONObject contentJson, String[] dropDownColumns, ThemeDisplay themeDisplay) {
		for (String column : dropDownColumns) {
			try {
				String code = contentJson.getString(column);
				SPListType spListType = null;
				replaceNameOfPayer(contentJson, column, code);
				if (StringUtils.isNumeric(code)) {
					spListType = SPListTypeLocalServiceUtil.fetchSPListType(Long.parseLong(code));
				} else {
					spListType = replaceItemValue(column, code, themeDisplay);
				}
				if (spListType == null)
					continue;
				String desc = spListType.getDisplayName();
				if (StringUtils.isNotEmpty(desc)) {
					contentJson.put(column, desc);
				}
			} catch (Exception e) {
				_log.error(e);
			}
		}
	}
	
	private void replaceNameOfPayer(JSONObject contentJson, String column, String code)
			throws PortalException, SystemException {
		if (column.equalsIgnoreCase("NameOfPayer")) {
			User user = UserLocalServiceUtil.getUserById(Long.parseLong(code));
			if (user != null) {
				contentJson.put(column, user.getFirstName() + " " + user.getLastName());
			}
		}
	}
	
	private SPListType replaceItemValue(String column, String code, ThemeDisplay themeDisplay) throws SystemException {
		for (String key : columnToKeyMap.get(column)) {
			List<SPListType> spListTypeList = SPListTypeLocalServiceUtil.getByKey(key, themeDisplay.getScopeGroupId());
			for (SPListType spLT : spListTypeList) {
				if (spLT.getItemValue().equals(code)) {
					return spLT;
				}
			}
		}
		return null;
	}
	
	public void saveExportQuery(String querytype, String pageModelData, ResourceRequest resourceRequest)
			throws JSONException {
		_log.debug("saveExportQuery invoked");
		JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(pageModelData);
		Integer totalElements = jsonModelData.getInt(TOTAL_ELEMENTS);
		JSONObject exportquery = JSONFactoryUtil.createJSONObject("{\"exportquery\":\"" + querytype + "\"}");
		PortletSession session = resourceRequest.getPortletSession();
		String currentquery = (String) session.getAttribute(SESSION_CURRENTQUERY, PortletSession.PORTLET_SCOPE);
		JSONObject jsonCurrentQuery = JSONFactoryUtil.createJSONObject(currentquery);
		exportquery.put(querytype, jsonCurrentQuery);
		exportquery.put(TOTAL_ELEMENTS, totalElements);
		session.setAttribute(SESSION_EXPORTQUERY, exportquery.toString(), PortletSession.PORTLET_SCOPE);
	}
	
	public void exportListToExcelFile(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			_log.debug("exportListToExcelFile invoked");
			String model = resourceRequest.getParameter(formType);
			String restmodel = model.toLowerCase();
			PortletSession session = resourceRequest.getPortletSession();
			String exportquery = (String) session.getAttribute(SESSION_EXPORTQUERY, PortletSession.PORTLET_SCOPE);

			JSONObject jsonExportQuery = JSONFactoryUtil.createJSONObject(exportquery);
			int totalsize = jsonExportQuery.getInt(TOTAL_ELEMENTS);
			String subUrl = restmodel + "/global/exportData?page=0&size=" + totalsize;
			JSONObject jsonTitleOrder = getTitleOrder(resourceRequest, model);
			jsonExportQuery.put(TITLES, jsonTitleOrder.getJSONObject(TITLES));
			jsonExportQuery.put(ORDER, jsonTitleOrder.getJSONArray(ORDER));
			new APICall(resourceRequest).downloadObjects(jsonExportQuery.toString(), subUrl, HttpMethod.POST,
					resourceRequest, resourceResponse);
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	private JSONObject getTitleOrder(ResourceRequest resourceRequest, String modelName) {
		JSONObject jsonTitleOrder = JSONFactoryUtil.createJSONObject();
		JSONObject titles = JSONFactoryUtil.createJSONObject();
		JSONArray order = JSONFactoryUtil.createJSONArray();
		List<String> columnsList1 = getMicroserviceModelColumnList(resourceRequest, modelName);
		for (String column : columnsList1) {
			order.put(CONTENT_JSON_PREFIX + column);
			_log.info("order:" + column);
		}
		order.put(CREATED_BY);
		order.put(CREATED_DATE);
		order.put(LAST_MODIFIED_BY);
		order.put(LAST_MODIFIED_DATE);
		Map<String, String> allModelColumnTitles = getMicroserviceModelColumnTitleMap(resourceRequest, modelName);
		for (Map.Entry modelColumnTitle : allModelColumnTitles.entrySet()) {
			titles.put(CONTENT_JSON_PREFIX + (String) modelColumnTitle.getKey(), (String) modelColumnTitle.getValue());
			_log.info("titles:" + modelColumnTitle.getValue());
		}
		titles.put(CREATED_BY, "Created By");
		titles.put(CREATED_DATE, "Created Date");
		titles.put(LAST_MODIFIED_BY, "Last Modified By");
		titles.put(LAST_MODIFIED_DATE, "Last Modified Date");

		jsonTitleOrder.put(TITLES, titles);
		jsonTitleOrder.put(ORDER, order);
		return jsonTitleOrder;

	}
	
	public Map<String, String> getMicroserviceModelColumnTitleMap(ResourceRequest resourceRequest, String modelName) {

		Map<String, String> map = new HashMap<>();
		String response = null;
		String existingData = null;
		String[] tempArray = null;
		try {
			String subUrl = modelName.toLowerCase() + "/getColumnTitleMap";
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			response = response.substring(1, response.length() - 1);
			String[] keyValuePairs = response.split(",");
			for (String pair : keyValuePairs) {
				String[] entry = pair.split("=");
				map.put(entry[0].trim(), entry[1].trim());
			}

		} catch (Exception e) {
			response = e.toString();
		}
		return map;
	}
	public void exportPdf(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		try {
			_log.debug("exportListToExcelFile invoked");
			String formStorageId = resourceRequest.getParameter("formStorageId");
			String model = resourceRequest.getParameter(formType);
			JSONObject transactionData = null;
			if(StringUtils.isEmpty(formStorageId)){
				transactionData = JSONFactoryUtil.createJSONObject(resourceRequest.getParameter("invoicingObj"));
			}else{
				String subUrl = model.toLowerCase() + restUriGet + formStorageId;
				String existingData = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
				String response = convertToFormModel(existingData, model);
				transactionData = JSONFactoryUtil.createJSONObject(response);
			}
			long pt = transactionData.getLong("productType");
			long pst = transactionData.getLong("productSubType");
			String fc = transactionData.getString("functionalComponent");
			long ct = transactionData.getLong("categoryType");
			long type = transactionData.getLong("type");
			
			String tdUrl = "transactiondocument" + "/search?productType=" +pt+"&productSubType="+pst+"&functionalComponent="
					+fc+"&categoryType="+ct+"&type="+type+"&contentJson.Status=Active";
			String existingtdData = new APICall(resourceRequest).exchange(tdUrl, HttpMethod.GET);
			String tdResponse = convertToFormModel(existingtdData, "transactiondocument");
			JSONObject transactionObj = transactionData.getJSONObject("contentJson");
			JSONObject transactionDocObj = JSONFactoryUtil.createJSONObject(tdResponse).getJSONArray("content").getJSONObject(0).getJSONObject("contentJson");
			JSONArray transactionDocArray = transactionDocObj.getJSONArray("TransactionTemplates");
			String template = transactionDocArray.getJSONObject(0).getString("template");
			
			SPListType spListType = SPListTypeLocalServiceUtil.fetchSPListType(Long.parseLong(transactionObj.getString("Type")));
			String name = "";
			String address = "";
			if(spListType.getItemValue().equals("Corporate")) {
				com.sambaash.platform.srv.startupprofile.model.Organization organization = OrganizationLocalServiceUtil.fetchOrganization(Long.parseLong(transactionObj.getString("NameOfPayer")));
				if(organization != null)
					name = organization.getName();
			} else {
				User user = UserLocalServiceUtil.getUser(Long.parseLong(transactionObj.getString("NameOfPayer")));
				name = user.getFirstName()+" "+user.getLastName();
				Address addressObj = null;
				for(Address add : user.getAddresses()) {
					if(add.isPrimary()) {
						addressObj = add;
						break;
					}
				}
				if(addressObj!=null)
					address = addressObj.getStreet1() + ", "+addressObj.getStreet2()+", "+addressObj.getStreet3()+", "+addressObj.getCity()+", "+addressObj.getCountry()+", "+addressObj.getZip();
			}
			JSONObject data = preparePdfData(transactionObj, name, address);
			String pdfUrl = model.toLowerCase() + "/exportpdf";
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("data", data);
			jsonObject.put("templateUrl", "https://wattabyte.sambaash.s3.ap-southeast-1.amazonaws.com/21424/temp/"+template);
			new APICall(resourceRequest).downloadPdf(jsonObject.toString(), pdfUrl, HttpMethod.POST,
					resourceRequest, resourceResponse);
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	private JSONObject preparePdfData(JSONObject transactionObj, String customerName, String customerAddress) {
		JSONObject data = JSONFactoryUtil.createJSONObject();
		data.put("documentType", "TAX INVOICE");
		data.put("customerName", customerName);
		data.put("customerAddress", customerAddress);
		if(StringUtils.isEmpty(transactionObj.getString("InvoiceNo"))) {
			data.put("invoiceNo", "DRAFT");
			data.put("preview", "true");
		} else {
			data.put("invoiceNo", transactionObj.getString("InvoiceNo"));
			data.put("preview", "false");
		}
		data.put("invoiceDate", transactionObj.getString("InvoiceDate"));
		data.put("invoiceDueDate", transactionObj.getString("InvoiceDueDate"));
		data.put("page", 1);
		JSONArray array = transactionObj.getJSONArray("TransactionDetails");
		for(int i=0;i<array.length();i++) {
			JSONObject obj = array.getJSONObject(i);
			data.put("sn"+i, (i+1));
			data.put("description"+i, obj.getString("title"));
			data.put("currency"+i, obj.getString("currency"));
			data.put("unitPrice"+i, obj.getString("unitPrice"));
			data.put("quantity"+i, obj.getString("quantity"));
			data.put("gstTaxCode"+i, obj.getString("taxCode"));
			data.put("amountExclGst"+i, obj.getString("amount"));
		}
		data.put("exchangeRate", "AUD/SGD 1.01");
		data.put("totalAmountExclGst", transactionObj.getString("InvoiceAmount"));
		data.put("totalAmountInclGst", transactionObj.getString("InvoiceAmount"));
		data.put("totalInvoiceAmount", transactionObj.getString("InvoiceAmount"));
		data.put("totalInclGst", transactionObj.getString("InvoiceAmount"));
		return data;
	}
	
	public void exportRowToExcelFile(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			_log.debug("exportRowToExcelFile invoked");
			String storageId = resourceRequest.getParameter(formStorageId);
			String model = resourceRequest.getParameter(formType);
			String restmodel = model.toLowerCase();
			String subUrl = restmodel + "/export/" + storageId;
			JSONObject jsonExportQuery = JSONFactoryUtil.createJSONObject();
			JSONObject jsonTitleOrder = getTitleOrder(resourceRequest, model);
			jsonExportQuery.put(TITLES, jsonTitleOrder.getJSONObject(TITLES));
			jsonExportQuery.put(ORDER, jsonTitleOrder.getJSONArray(ORDER));
			new APICall(resourceRequest).downloadObject(jsonExportQuery.toString(), subUrl, HttpMethod.POST,
					resourceRequest, resourceResponse);

		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	
	public String getFormV2Fields(ResourceRequest resourceRequest) {

		String response = null;
		try {
			String formId = resourceRequest.getParameter("formId").toLowerCase();
			String model = "configuration";
			String subUrl = model + restUriGet + formId;
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);

		} catch (Exception e) {
			_log.error(e);
			response = error;
		}
		return response;
	}
	
	public Map fetchDocumentS3(ResourceRequest resourceRequest,String fileName) {

		Map response = null;
		byte[] bbb;
		try {
			String subUrl = "taxcode/download/"+fileName;
			response = new APICall(resourceRequest).downloadFile(subUrl, HttpMethod.GET);
			response.get("content");
			response.get("contentType");
			return response;
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}
	public void handleFileUpload(ResourceRequest request, ResourceResponse response) {

		JSONObject retObj = JSONFactoryUtil.createJSONObject();
		JSONArray objArr = JSONFactoryUtil.createJSONArray();
		_log.debug(request.getContentType());
		String objResponse = "";
		try {

			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
			File file1 = uploadRequest.getFile("templateFile");
			String fileName = uploadRequest.getParameter("fileName");
			String downloadUrlPattern = uploadRequest.getParameter("downloadUrlPattern");
			JSONObject obj1 = JSONFactoryUtil.createJSONObject();
			String modelName = uploadRequest.getParameter("formType").toLowerCase();
			String subUrl = modelName + "/uploadTemp";

			objResponse = new APICall(request).uploadObjectNew(file1, fileName, subUrl, downloadUrlPattern);
			if (Validator.isNotNull(objResponse)) {
				objArr.put(JSONFactoryUtil.createJSONObject(objResponse));

			} else {
				obj1.put("error", "Error uploading the file.");
			}
			retObj.put("result", objArr);
			retObj.put("data", objArr.getJSONObject(0));

			response.getWriter().write(retObj.toString());

		} catch (IOException | JSONException e1) {
			_log.error(e1);
		}
	}
	
	public String getFilterColumnHeader(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		_log.info("Get Filter Column Header");
		String response = null;
		List<String> nonModelFilterColumns = new ArrayList<>();
		nonModelFilterColumns.add(CREATED_BY);
		nonModelFilterColumns.add(LAST_MODIFIED_BY);
		List<String> datePickerColumns = new ArrayList<>();
		datePickerColumns.add(CREATED_DATE);
		datePickerColumns.add(LAST_MODIFIED_DATE);

		try {
			String modelNameMicroService = resourceRequest.getParameter(formType);
			String model = modelNameMicroService.toLowerCase();
			List<String> filterColumns = getMicroserviceModelFilterColumnList(resourceRequest, modelNameMicroService);
			StringBuilder sbColumns = new StringBuilder("?");
			for (String filterColumn : filterColumns) {
				if (sbColumns.toString() != "?") {
					sbColumns.append("&");
				}
				sbColumns.append("columns=contentJson.");
				sbColumns.append(filterColumn);
				_log.info("filtercolumn: " + filterColumn);
			}
			for (String nonModelFilterColumn : nonModelFilterColumns) {
				if (sbColumns.toString() != "?") {
					sbColumns.append("&");
				}
				sbColumns.append("columns=");
				sbColumns.append(nonModelFilterColumn);
				_log.info("nonmodelfiltercolumn: " + nonModelFilterColumn);
			}
			String subUrl = model + "/distinct/" + sbColumns.toString();
			_log.info("suburl: " + subUrl);
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			Map<String, String> allModelColumnTitles = getMicroserviceModelColumnTitleMap(resourceRequest,
					modelNameMicroService);
			JSONObject distinct = JSONFactoryUtil.createJSONObject(response);
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			JSONArray datepicker = JSONFactoryUtil.createJSONArray();
			JSONObject titles = JSONFactoryUtil.createJSONObject();

			JSONArray distinctCreatedBy = distinct.getJSONArray("createdBy");
			DynamicQuery studentINOperator= DynamicQueryFactoryUtil.forClass(
			User.class, PortletClassLoaderUtil.getClassLoader());
			Criterion criterion6 = null;
			ArrayList<Long> list = new ArrayList<Long>();
			for(int i =0; i < distinctCreatedBy.length(); i++){
				try{
					if(!distinctCreatedBy.getString(i).equalsIgnoreCase(null)){
						list.add( Long.valueOf(distinctCreatedBy.getString(i)));
					}
				}catch(Exception e){
					continue;
				}
			}
			
			JSONArray usersInfo = JSONFactoryUtil.createJSONArray();
			JSONObject userInfo = JSONFactoryUtil.createJSONObject();
			if(!list.isEmpty()){
				criterion6 = RestrictionsFactoryUtil.in("userId",list);
				criterion6=RestrictionsFactoryUtil.and(criterion6,RestrictionsFactoryUtil.eq("status",new Integer("0")));
				studentINOperator.add(criterion6);
				List<User> studentList8=UserLocalServiceUtil.dynamicQuery(studentINOperator);
				for(User student:studentList8){
					userInfo = JSONFactoryUtil.createJSONObject();
					userInfo.put("id", student.getUserId());
					userInfo.put("name", student.getFirstName() + " " + student.getLastName());
					usersInfo.put(userInfo);
				}
			}
			
			for (String datePickerColumn : datePickerColumns) {
				datepicker.put(datePickerColumn);
				_log.info("datepicker: " + datePickerColumn);
			}
			for (Map.Entry modelColumnTitle : allModelColumnTitles.entrySet()) {
				titles.put(CONTENT_JSON_PREFIX + (String) modelColumnTitle.getKey(),
						(String) modelColumnTitle.getValue());
				_log.info("titles:" + modelColumnTitle.getValue());
			}
			titles.put(CREATED_BY, "Created By");
			titles.put(CREATED_DATE, "Created Date");
			titles.put(LAST_MODIFIED_BY, "Last Modified By");
			titles.put(LAST_MODIFIED_DATE, "Last Modified Date");
			obj.put("userInfo", usersInfo);
			obj.put("distinct", distinct);
			obj.put("datepicker", datepicker);
			obj.put(TITLES, titles);
			return obj.toString();
		} catch (Exception e) {
			_log.error("getFilterColumnHeader exception: " + e);
			response = error;
		}
		return response;
	}
	public String processRecord(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = "";
		try {
			String data = resourceRequest.getParameter("data");
			JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(data);
			String storageId = jsonModelData.getString(formStorageId);
			String action = jsonModelData.getString("action");
			String reason = jsonModelData.getString("reason");
			String categoryMap = jsonModelData.getString("categoryMap");
			String model = jsonModelData.getString(formType).toLowerCase();
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("action", action);
			jsonObject.put("reason", reason);
			jsonObject.put("categoryMap", JSONFactoryUtil.createJSONObject(categoryMap));
			URI uriStorageId = URI.create(storageId);
			String subUrl = model + "/process/" + uriStorageId;
			response = new APICall(resourceRequest).postForObject(jsonObject.toString(), subUrl);
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}
	
	public List<String> getMicroserviceModelFilterColumnList(ResourceRequest resourceRequest, String modelName) {

		String response = null;
		String existingData = null;
		String[] tempArray = null;
		try {
			String subUrl = modelName.toLowerCase() + "/getFilterColumns";
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			tempArray = response.split(",");
		} catch (Exception e) {
			response = e.toString();
		}
		return (Arrays.asList(tempArray));

	}
}