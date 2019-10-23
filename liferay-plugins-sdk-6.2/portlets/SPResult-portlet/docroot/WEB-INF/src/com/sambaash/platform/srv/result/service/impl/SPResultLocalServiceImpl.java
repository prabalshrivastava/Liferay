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

package com.sambaash.platform.srv.result.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
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
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.model.microservicemodel.MicroServiceModel;
import com.sambaash.platform.result.constant.ResultConstant;
import com.sambaash.platform.service.FetchLocalServiceUtil;
import com.sambaash.platform.srv.result.service.base.SPResultLocalServiceBaseImpl;
import com.sambaash.platform.srv.spservices.model.SPListType;
import com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the s p result local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.result.service.SPResultLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sunil.sharma
 * @see com.sambaash.platform.srv.result.service.base.SPResultLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.result.service.SPResultLocalServiceUtil
 */
public class SPResultLocalServiceImpl extends SPResultLocalServiceBaseImpl {


	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil} to
	 * access the s p finance local service.
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
	private static final String CONTENT_JSON_PREFIX = "contentJson.";
	private static final String CONTENT_JSON = "contentJson";
	private static final String ELASTIC_SEARCH_old = "/elasticsearch?";
	private static final String ELASTIC_SEARCH = "/elasticsearchresultmaster?";
	private static final String CATEGORY_TYPE = "CategoryType";
	private static final String CONDITIONS = "conditions";
	private static final String PAGE_EQUAL = "page=";
	private static final String FUNC_COMP_KEY = "finance.referencenumber.functionalcomponent";
	private static final String AMOUNT = "Amount";
	private static final String NAME_OF_PAYER = "NameOfPayer";
	private static final String FORMSTORAGEID = "formStorageId";
	private static final String CONTENT = "content";
	private static final String PRODUCT_SUB_TYPE = "ProductSubType";
	private static final String PRODUCT_TYPE = "ProductType";
	private static final String FUNC_COMP = "FunctionalComponent";
	private static final String ADMINISTRATOR = "Administrator";
	private static final String ERROR = "error";
	private static final String TRANSACTION_DOCUMENT = "transactiondocument";
	private static final String CONTENT_DISPOSITION = "Content-Disposition";
	private static final String CACHE_CONTROL_PROP = "no-cache,no-store";

	private static final Log _log = LogFactoryUtil.getLog(SPResultLocalServiceImpl.class);

	private static String formType = "formType";
	private static String sortBy = "sortBy";
	private static String restUriGet = "/get/";
	private static String restUriSize = "&size=";
	private static String requestURL = "Request URL";
	private static String restUriLimit = "limit";
	private static String valueStr = "value";
	private static String translation = "translation";

	private static Map<String, String[]> modelToColumnMap = new HashMap();
	private static Map<String, String[]> columnToKeyMap = new HashMap();

	static {
		modelToColumnMap.put(TRANSACTION_DOCUMENT, new String[] { PRODUCT_TYPE, PRODUCT_SUB_TYPE, FUNC_COMP,
				CATEGORY_TYPE, "Type", "AdvanceInvoice", "TemplateFor" });
		modelToColumnMap.put("referencenumber", new String[] { PRODUCT_TYPE, PRODUCT_SUB_TYPE, FUNC_COMP, CATEGORY_TYPE,
				"Type", "SequenceNoReset", "Frequency" });
		modelToColumnMap.put("transactionmaster",
				new String[] { PRODUCT_TYPE, PRODUCT_SUB_TYPE, FUNC_COMP, CATEGORY_TYPE, "Type", NAME_OF_PAYER });
		modelToColumnMap.put("invoiceremarks", new String[] {});
		columnToKeyMap.put("AdvanceInvoice", new String[] { "finance.transactiondocument.advanceinvoice" });
		columnToKeyMap.put(FUNC_COMP, new String[] { FUNC_COMP_KEY });
		columnToKeyMap.put("TemplateFor", new String[] { "finance.transactiondocument.templatefor" });
		columnToKeyMap.put("Frequency", new String[] { "finance.referencenumber.frequency" });
	}
	RestTemplate restTemplate = new RestTemplate();
	public class APICall {
		long userId = 0;
		long siteId = 0;
		ResourceRequest req;
		HttpHeaders headers;
		HttpEntity<String> httprequest;
		
		String baseUrl = "";

		public APICall(ResourceRequest request) {
			try {
				this.req = request;
				userId = PortalUtil.getUserId(request);
				siteId = PortalUtil.getScopeGroupId(request);
				headers = new HttpHeaders();
				headers.add("X-SCOPEGROUP-ID", "" + SambaashUtil.getScopeGroupId(siteId));
				headers.add("X-USER-ID", "" + userId);
				
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
				response.put(CONTENT, httpresponse.getBody());
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

		private void downloadObject(String data, String subUrl, HttpMethod method, ResourceResponse resourceResponse) {
			headers.setContentType(MediaType.APPLICATION_JSON);
			httprequest = new HttpEntity<>(data, headers);
			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<Resource> httpresponse = restTemplate.exchange(uri, method, httprequest, Resource.class);
				if (httpresponse.getStatusCode().equals(HttpStatus.OK)) {
					HttpHeaders head = httpresponse.getHeaders();
					MediaType mtype = head.getContentType();
					List<String> contentDisposition = head.get(CONTENT_DISPOSITION);

					resourceResponse
							.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
					resourceResponse.addProperty(com.liferay.portal.kernel.servlet.HttpHeaders.CACHE_CONTROL,
							CACHE_CONTROL_PROP);
					for (String cd : contentDisposition) {
						resourceResponse.addProperty(CONTENT_DISPOSITION, cd);
					}
					downloadObjectWriteData(resourceResponse, httpresponse);
				}
			} catch (Exception e) {
				_log.error(requestURL + baseUrl + subUrl);
				_log.error(e);
			}
		}

		private void downloadObjectWriteData(ResourceResponse resourceResponse, ResponseEntity<Resource> httpresponse) {
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

		private void downloadPdf(String data, String subUrl, HttpMethod method, ResourceResponse resourceResponse) {
			headers.setContentType(MediaType.APPLICATION_JSON);
			httprequest = new HttpEntity<>(data, headers);
			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<Resource> httpresponse = restTemplate.exchange(uri, method, httprequest, Resource.class);
				if (httpresponse.getStatusCode().equals(HttpStatus.OK)) {
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
				resourceResponse.setContentType("application/pdf");
				IOUtils.copy(in, out);
				out.flush();
				resourceResponse.flushBuffer();
			} catch (final IOException e) {
				_log.error(e);
			}
		}


		private void exportData(String response2, String data, ResourceResponse resourceResponse) {
			XSSFWorkbook workbook = new XSSFWorkbook();
			String fileName = "downloadw.xlsx";
			org.json.JSONObject responseObject;
			try {
				responseObject = new org.json.JSONObject(response2);
				org.json.JSONArray content = responseObject.getJSONArray(CONTENT);

				org.json.JSONObject exportSourceJson = new org.json.JSONObject(data);

				org.json.JSONObject contentJsonData = exportSourceJson.getJSONObject("titles");

				org.json.JSONArray jsonOrderData = exportSourceJson.getJSONArray(ORDER);
				org.json.JSONArray contentJsonTitles = new org.json.JSONArray();
				org.json.JSONArray jsonTitlesOrder = new org.json.JSONArray();

				Iterator iter = contentJsonData.keys();
				while (iter.hasNext()) {
					String key = (String) iter.next();
					if (key.contains("contentJson")) {
						contentJsonTitles.put(key.replaceAll("contentJson.", ""));
					}

				}

				for (int i = 0; i < jsonOrderData.length(); i++) {
					if (!jsonOrderData.get(i).equals("contentJson.")) {
						jsonTitlesOrder.put(jsonOrderData.get(i));
					}
				}

				ArrayList<String> jsonOrder = new ArrayList<>();
				for (int i = 0; i < contentJsonTitles.length(); i++) {
					jsonOrder.add(contentJsonTitles.getString(i));
				}
				for (int i = 0; i < jsonTitlesOrder.length(); i++) {
					jsonOrder.add(jsonTitlesOrder.getString(i));
				}
				
				String[] order = jsonOrder.toArray(new String[0]);
				XSSFSheet sheet = workbook.createSheet(fileName.replace(".xlsx", ""));
				// rowNum = writeExcelEntityTitle(sheet, jsonTitles, order);

				org.json.JSONArray orderFromJSONList = new org.json.JSONArray();
				for (Integer index = 0; index < content.length(); index++) {
					org.json.JSONObject orderFromJSON = new org.json.JSONObject();
					org.json.JSONObject tempObject = content.getJSONObject(index);
					
					org.json.JSONObject contentJson = tempObject.getJSONObject("contentJson");
					for (int i = 0; i < contentJsonTitles.length(); i++) {

						orderFromJSON.put(contentJsonTitles.getString(i),
								((contentJson.has(contentJsonTitles.getString(i)))
										? contentJson.getString(contentJsonTitles.getString(i)) : ""));

					}
					for (int i = 0; i < jsonTitlesOrder.length(); i++) {
						orderFromJSON.put(jsonTitlesOrder.getString(i), ((tempObject.has(jsonTitlesOrder.getString(i)))
								? tempObject.getString(jsonTitlesOrder.getString(i)) : ""));
					}
					orderFromJSONList.put(orderFromJSON);
				}

				org.json.JSONObject entityJson = orderFromJSONList.getJSONObject(0);
				int rowNum = writeExcelEntityRow(sheet, 0, entityJson, order, 1);
				for (Integer index = 0; index < orderFromJSONList.length(); index++) {
					entityJson = orderFromJSONList.getJSONObject(index);
					rowNum = writeExcelEntityRow(sheet, rowNum, entityJson, order, 0);
				}
				OutputStream outStrm = null;
				try {
					resourceResponse
							.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
					resourceResponse.addProperty(com.liferay.portal.kernel.servlet.HttpHeaders.CACHE_CONTROL,
							CACHE_CONTROL_PROP);
					resourceResponse.addProperty(CONTENT_DISPOSITION, "attachment; filename=" + fileName);
					outStrm = resourceResponse.getPortletOutputStream();
					workbook.write(outStrm);
				} catch (IOException e) {
					_log.error(e);
				} finally {
					try {
						outStrm.flush();
						outStrm.close();
					} catch (IOException e) {
						_log.error(e);
					}
				}
			} catch (org.json.JSONException e1) {
				_log.error(e1.getMessage());
			}

		}

		private int writeExcelEntityRow(XSSFSheet sheet, int rowNum, org.json.JSONObject entityJson, String[] order,
				int key) {

			int colNum = 0;
			Row row = sheet.createRow(rowNum++);
			for (String datakey : order) {
				Cell cell = row.createCell(colNum++);
				Object field = null;
				try {
					if (datakey.contains(CONTENT_JSON_PREFIX)) {
						Iterator<?> keys = entityJson.getJSONObject(CONTENT_JSON).keys();
						while (keys.hasNext()) {
							if (key == 1) {
								field = keys.next();
							} else {
								field = entityJson.getJSONObject(CONTENT_JSON).get((String) keys.next());
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

							if (colNum < entityJson.getJSONObject(CONTENT_JSON).length() | rowNum > 2)
								cell = row.createCell(colNum++);

						}
						
					} else {
						if (key == 1) {
							field = datakey;
						} else {
							if (entityJson.has(datakey))
								field = entityJson.get(datakey);
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
				} catch (org.json.JSONException e) {
					_log.error(e);
				}

			}

			return rowNum;
		}
		
		private void populateUserNames(JSONObject jsonObject) throws PortalException, SystemException {
			if (!StringUtils.isEmpty(jsonObject.getString(CREATED_BY))
					&& NumberUtils.isNumber(jsonObject.getString(CREATED_BY))) {
				User user = UserLocalServiceUtil.getUserById(Long.parseLong(jsonObject.getString(CREATED_BY)));
				if (user != null) {
					jsonObject.put(CREATED_BY, user.getFirstName() + " " + user.getLastName());
				}
			}
			if (!StringUtils.isEmpty(jsonObject.getString(LAST_MODIFIED_BY))
					&& NumberUtils.isNumber(jsonObject.getString(LAST_MODIFIED_BY))) {
				User user = UserLocalServiceUtil.getUserById(Long.parseLong(jsonObject.getString(LAST_MODIFIED_BY)));
				if (user != null) {
					jsonObject.put(LAST_MODIFIED_BY, user.getFirstName() + " " + user.getLastName());
				}
			}
		}
		
		private void populateDateFormat(JSONObject jsonObject) throws PortalException, SystemException {
			if (!StringUtils.isEmpty(jsonObject.getString(CREATED_DATE))) {
				String dt = changeDateFormat(jsonObject.getString(CREATED_DATE), "yyyy-MM-dd'T'hh:mm:ss.SSSZ");
				jsonObject.put(CREATED_DATE, dt);
			}
			if (!StringUtils.isEmpty(jsonObject.getString(LAST_MODIFIED_DATE))) {
				jsonObject.put(LAST_MODIFIED_DATE, changeDateFormat(jsonObject.getString(LAST_MODIFIED_DATE), "yyyy-MM-dd'T'hh:mm:ss.SSSZ"));
				
			}
		}
		
		private String changeDateFormat(String date, String oldFormat){
			try {
				SimpleDateFormat f = new SimpleDateFormat(oldFormat);
				Date d = f.parse(date);
				SimpleDateFormat f2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
				return f2.format(d);
			} catch (Exception e) {
				_log.error(e.getMessage());
				return date;
			}
		}

		
		private String preparePdf(String data, String subUrl, HttpMethod method) {
			headers.setContentType(MediaType.APPLICATION_JSON);
			httprequest = new HttpEntity<>(data, headers);
			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<Resource> httpresponse = restTemplate.exchange(uri, method, httprequest, Resource.class);
				if (httpresponse.getStatusCode().equals(HttpStatus.OK)) {
					//((MimeResponse) httpresponse).setContentType("application/pdf");
					File pdfFile = File.createTempFile("" + new Date().getTime(), ".pdf");
					IOUtils.copy(httpresponse.getBody().getInputStream(), new FileOutputStream(pdfFile));
					return pdfFile.getAbsolutePath();
				}
			} catch (Exception e) {
				_log.error(requestURL + baseUrl + subUrl);
				_log.error(e);
			}
			return null;
		}
		
		private void downloadObjects(String data, String subUrl, HttpMethod method, ResourceRequest resourceRequest,
				ResourceResponse resourceResponse) {
			headers.setContentType(MediaType.APPLICATION_JSON);
			httprequest = new HttpEntity<>(data, headers);
			String model = resourceRequest.getParameter(formType).toLowerCase();
			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<String> httpresponse = restTemplate.exchange(uri, method, httprequest, String.class);
				if (httpresponse.getStatusCode().equals(HttpStatus.OK)) {
					String response2 = httpresponse.getBody();
					response2 = setSPListTypeDecriptions(resourceRequest, response2, model);
					exportData(response2, data, resourceResponse);
				} else {
				}
			} catch (Exception e) {
				_log.error(requestURL + baseUrl + subUrl);
				_log.error(e);
			}
		}
				
		private String setSPListTypeDecriptions(ResourceRequest resourceRequest, String jsonDataString, String model)
				throws SystemException, PortalException {
			boolean isArray = true;
			JSONObject resp = JSONFactoryUtil.createJSONObject(jsonDataString);
			if (resp.isNull(CONTENT)) {
				resp = JSONFactoryUtil.createJSONObject();
				resp.put(CONTENT, JSONFactoryUtil.createJSONArray("[" + jsonDataString + "]"));
				isArray = false;
			}
			JSONArray content = resp.getJSONArray(CONTENT);
			for (int i = 0; i < content.length(); i++) {
				try {
					populateUserNames(content.getJSONObject(i));
					populateDateFormat(content.getJSONObject(i));
				} catch (Exception e1) {
					_log.error(e1);
				}
			}
			if (isArray) {
				return resp.toString();
			} else {
				return resp.getJSONArray(CONTENT).getJSONObject(0).toString();
			}
		}

	
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

	public String multiCreateRecord(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = "";
		try {
			String modeldata = resourceRequest.getParameter("data");
			String userList = (String) resourceRequest.getAttribute("userList");
			_log.debug("creating data" + modeldata);
			JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(modeldata);
			jsonModelData.put("userList", userList);
			JSONObject jsonContentJSONData = JSONFactoryUtil.createJSONObject();
			jsonContentJSONData.put(CONTENT_JSON, jsonModelData);
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = "";
			_log.debug("create data" + jsonContentJSONData);
			if (resourceRequest.getParameter(FORMSTORAGEID).isEmpty()
					|| resourceRequest.getParameter(FORMSTORAGEID).equals("0")) {
				subUrl = model + "/new";
				response = new APICall(resourceRequest).postForObject(jsonContentJSONData.toString(), subUrl);
			} else {
				subUrl = model + "/edit/" + resourceRequest.getParameter(FORMSTORAGEID);
				response = new APICall(resourceRequest).putForObject(jsonContentJSONData.toString(), subUrl);
			}
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}

	public String fetchElasticRecordsForGenericSearch(ResourceRequest resourceRequest, String jsonElasticSearchQuery,
			String subUrl) {

		String response = "";
		try {
			response = new APICall(resourceRequest).postForObject(jsonElasticSearchQuery, subUrl);
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}

	public String fetchRecord(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = null;
		String existingData = null;
		try {
			String storageId = resourceRequest.getParameter(FORMSTORAGEID);

			if (StringUtils.isEmpty(storageId) || "0".equals(storageId)) {
				storageId = JSONFactoryUtil.createJSONObject(resourceRequest.getParameter("data"))
						.getString(FORMSTORAGEID);
			}
			String model = resourceRequest.getParameter(formType);
			String indetail = resourceRequest.getParameter("indetail");
			if (StringUtils.isEmpty(indetail)) {
				indetail = JSONFactoryUtil.createJSONObject(resourceRequest.getParameter("data")).getString("indetail");
			}
			String subUrl = model.toLowerCase() + restUriGet + storageId;
			existingData = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			response = convertToFormModel(existingData, model);
			if (modelToColumnMap.get(model.toLowerCase()) != null && indetail != null && indetail.equals("true")) {
				response = setSPListTypeDecriptions(resourceRequest, response,
						modelToColumnMap.get(model.toLowerCase()));
			}

		} catch (Exception e) {
			_log.error(e);
			response = e.toString();
		}
		return response;
	}

	public String updateRecord(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = "";
		try {
			String storageId = resourceRequest.getParameter(FORMSTORAGEID);
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

	public List<String> getMicroserviceModelColumnList(ResourceRequest resourceRequest, String modelName) {
		String response = null;
		String[] tempArray = null;
		try {
			String subUrl = modelName.toLowerCase() + "/getColumns";
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			tempArray = response.split(",");

		} catch (Exception e) {
			_log.error(e);
		}
		return (Arrays.asList(tempArray));

	}

	public List<String> getMicroserviceModelFilterColumnList(ResourceRequest resourceRequest, String modelName) {
		String response = null;
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		String[] tempArray = null;
		try {
			String subUrl = modelName.toLowerCase() + "/getFilterColumns";
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			responseObj = JSONFactoryUtil.createJSONObject(response);
			String columns = responseObj.getString("columns");
			tempArray = columns.split(",");
		} catch (Exception e) {
			_log.error(e);
		}
		return (Arrays.asList(tempArray));

	}

	public String getMicroserviceModelColumnTitleMap(ResourceRequest resourceRequest, String modelName) {
		String response = null;
		try {
			String subUrl = modelName.toLowerCase() + "/getColumnTitleMap";
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
		} catch (Exception e) {
			_log.error(e);
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
				return convertToModeJson(inp);
			if (jsonModelExistingData.toString().equals("{}")) {
				JSONObject contentJson = JSONFactoryUtil.createJSONObject();
				contentJson.put("Status", "Active");
				jsonModelExistingData.put(CONTENT_JSON, contentJson);
			}
			org.json.JSONObject in = new org.json.JSONObject(inp.toString());
			for (int i = 0; i < in.names().length(); i++) {
				if (columns.contains(in.names().getString(i))) {

					jsonModelExistingData.getJSONObject(CONTENT_JSON).put(in.names().getString(i),
							in.getString(in.names().getString(i)));

					Object json = in.get(in.names().getString(i));
					if (json instanceof org.json.JSONArray) {
						jsonModelExistingData.getJSONObject(CONTENT_JSON).put(in.names().getString(i),
								inp.getJSONArray(in.names().getString(i)));
					} else {
						jsonModelExistingData.getJSONObject(CONTENT_JSON).put(in.names().getString(i),
								in.getString(in.names().getString(i)));
					}
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}
		return jsonModelExistingData;

	}

	protected JSONObject convertToModeJson(JSONObject in) {
		JSONObject apiJsonModelData = JSONFactoryUtil.createJSONObject();
		apiJsonModelData.put(CONTENT_JSON, in.toString());
		return apiJsonModelData;
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
			response = ERROR;
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
				sortByField = CONTENT_JSON_PREFIX + jsonModelData.getString(sortBy);
			}

			String subUrl = model + "/list?page=" + page + restUriSize + limit + "&sort=" + sortByField;
			saveCurrentQuery("{}", resourceRequest);
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);

		} catch (Exception e) {
			_log.error(e);
			response = ERROR;
		}
		return response;

	}

	private void populateUserNames(JSONObject jsonObject) throws PortalException, SystemException {
		if (!jsonObject.isNull(CREATED_BY)) {
			User user = UserLocalServiceUtil.getUserById(Long.parseLong(jsonObject.getString(CREATED_BY)));
			if (user != null) {
				jsonObject.put(CREATED_BY, user.getFirstName() + " " + user.getLastName());
			}
		}
		if (!jsonObject.isNull(LAST_MODIFIED_BY)) {
			User user = UserLocalServiceUtil.getUserById(Long.parseLong(jsonObject.getString(LAST_MODIFIED_BY)));
			if (user != null) {
				jsonObject.put(LAST_MODIFIED_BY, user.getFirstName() + " " + user.getLastName());
			}
		}
	}
	
	private void populateDateFormat(JSONObject jsonObject) throws PortalException, SystemException {
		if (!StringUtils.isEmpty(jsonObject.getString(CREATED_DATE))) {
			jsonObject.put(CREATED_DATE, changeDateFormat(jsonObject.getString(CREATED_DATE), "yyyy-MM-dd'T'hh:mm:ss.SSSZ"));
			
		}
		if (!StringUtils.isEmpty(jsonObject.getString(LAST_MODIFIED_DATE))) {
			jsonObject.put(LAST_MODIFIED_DATE, changeDateFormat(jsonObject.getString(LAST_MODIFIED_DATE), "yyyy-MM-dd'T'hh:mm:ss.SSSZ"));
			
		}
	}
	
	private String changeDateFormat(String date, String oldFormat){
		try {
			SimpleDateFormat f = new SimpleDateFormat(oldFormat);
			Date d = f.parse(date);
			SimpleDateFormat f2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
			return f2.format(d);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		
		
	    // Format String to a dateobject with the format provided by the String.
	     // MMMM for full month name
		
		return null;
	}

	private String setSPListTypeDecriptions(ResourceRequest resourceRequest, String jsonDataString,
			String[] dropDownColumns) throws SystemException, JSONException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		boolean isArray = true;
		JSONObject resp = JSONFactoryUtil.createJSONObject(jsonDataString);
		if (resp.isNull(CONTENT)) {
			resp = JSONFactoryUtil.createJSONObject();
			resp.put(CONTENT, JSONFactoryUtil.createJSONArray("[" + jsonDataString + "]"));
			isArray = false;
		}
		JSONArray content = resp.getJSONArray(CONTENT);
		for (int i = 0; i < content.length(); i++) {
			try {
				populateUserNames(content.getJSONObject(i));
				populateDateFormat(content.getJSONObject(i));
			} catch (Exception e1) {
				_log.error(e1);
			}
			JSONObject contentJson = content.getJSONObject(i).getJSONObject(CONTENT_JSON);
			replaceValue(contentJson, dropDownColumns, themeDisplay);
		}
		if (isArray) {
			return resp.toString();
		} else {
			return resp.getJSONArray(CONTENT).getJSONObject(0).toString();
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
		if (column.equalsIgnoreCase(NAME_OF_PAYER)) {
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
				JSONArray conditions = jsonModelData.getJSONArray(CONDITIONS);
				JSONArray filters = jsonModelData.getJSONArray("filterdata");
				JSONArray sortArray = jsonModelData.getJSONArray("sortby");
				String subUrl = model + ELASTIC_SEARCH + PAGE_EQUAL + page + restUriSize + limit;
				JSONObject jsonElasticSearchQuery = JSONFactoryUtil.createJSONObject();
				prepareConditions(conditions, jsonElasticSearchQuery);
				//prepareFilters(filters, resourceRequest, jsonElasticSearchQuery);
				if (sortArray != null && sortArray.length() > 0) {
					jsonElasticSearchQuery.put("sortby", sortArray);
				}
				saveCurrentQuery(jsonElasticSearchQuery.toString(), resourceRequest);
				_log.debug("Posting with requestbody" + jsonElasticSearchQuery.toString());
				response = new APICall(resourceRequest).postForObject(jsonModelData.toString(), subUrl);
				if (modelToColumnMap.get(model.toLowerCase()) != null) {
					response = setSPListTypeDecriptions(resourceRequest, response,
							modelToColumnMap.get(model.toLowerCase()));
				}
			} else {
				_log.debug("Search request was empty" + data);
			}
		} catch (Exception e) {
			_log.error(e);
			response = ERROR;
		}
		return response;
	}

	private void prepareConditions(JSONArray conditions, JSONObject jsonElasticSearchQuery) {
		if (conditions != null && conditions.length() > 0) {
			jsonElasticSearchQuery.put(CONDITIONS, conditions);
		}else{
			conditions.put(" ");
			jsonElasticSearchQuery.put(CONDITIONS, conditions);
		}
	}

	private void prepareFilters(JSONArray filters, ResourceRequest resourceRequest, JSONObject jsonElasticSearchQuery)
			throws JSONException {
		String catType = resourceRequest.getPreferences().getValue(ResultConstant.PREF_CATEGORY_TYPE, "IN");
		if (filters == null) {
			filters = JSONFactoryUtil.createJSONArray();
		}
		HttpServletRequest request = ((LiferayPortletRequest) resourceRequest).getHttpServletRequest();
		String catId = getCategoryMap(request).get(catType);
		if (catId != null) {
			filters.put(JSONFactoryUtil.createJSONObject("{\"contentJson.CategoryType\":[\"" + catId + "\"]}"));
		}
		jsonElasticSearchQuery.put("filters", filters);
	}

	public String getSearchListing(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = null;
		try {
			String data = resourceRequest.getParameter("data");
			JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(data);
			String limit = jsonModelData.getString(restUriLimit);
			String model = jsonModelData.getString(formType).toLowerCase();
			String page = jsonModelData.getString("page");
			String sortByField = jsonModelData.getString(sortBy);
			JSONArray conditions = jsonModelData.getJSONArray(CONDITIONS);
			JSONObject currentquery = JSONFactoryUtil.createJSONObject();

			if (!sortByField.equalsIgnoreCase("")) {
				sortByField = CONTENT_JSON_PREFIX + jsonModelData.getString(sortBy);
			}
			String regexOperator = "=";
			String condition = "";
			StringBuilder bld = new StringBuilder();
			for (int i = 0; i < conditions.length(); i++) {
				bld.append(conditions.getString(i) + "&");
				String[] splitcondition = conditions.getString(i).split(regexOperator);
				currentquery.put(splitcondition[0], splitcondition[1]);
			}

			saveCurrentQuery(currentquery.toString(), resourceRequest);
			condition = bld.toString();
			String subUrl = model + "/search?" + condition + PAGE_EQUAL + page + restUriSize + limit + "&sort="
					+ sortByField;
			
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			if (modelToColumnMap.get(model.toLowerCase()) != null) {
				response = setSPListTypeDecriptions(resourceRequest, response,
						modelToColumnMap.get(model.toLowerCase()));
			}
		} catch (Exception e) {
			_log.error(e);
			response = ERROR;
		}
		return response;

	}

	public String archiveRecord(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = null;
		try {
			String storageId = resourceRequest.getParameter(FORMSTORAGEID);
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + "/archive/" + storageId;
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.DELETE);

		} catch (Exception e) {
			_log.error(e);
			response = ERROR;
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
				obj1.put(ERROR, "Error uploading the file.");
			}
			retObj.put("result", objArr);
			retObj.put("data", objArr.getJSONObject(0));

			response.getWriter().write(retObj.toString());

		} catch (IOException | JSONException e1) {
			_log.error(e1);
		}
	}
	
	public JSONObject filterDistinct(JSONObject distinct){
		if(distinct.has("contentJson")){
			Iterator iter = distinct.getJSONObject("contentJson").keys();
			while (iter.hasNext()) {
				String key = (String) iter.next();
				JSONArray dataString = distinct.getJSONObject("contentJson").getJSONArray(key);
				JSONObject distinctValues = JSONFactoryUtil.createJSONObject();
				ArrayList<String> list = new ArrayList<String>();
				JSONArray distinctData = JSONFactoryUtil.createJSONArray();
				for(int i=0; i<dataString.length();i++){
					String dataValue = dataString.getString(i);
					String[] values = dataValue.split(",");
					for(String v:values){
						if(!distinctValues.has(v.trim()) && !v.contains("[") && !v.contains("]")){
							list.add(v.trim());
						}
						distinctValues.put(v.trim(), v.trim());
					}
				}
				Collections.sort(list);
				for(String s:list){
					distinctData.put(s);
				}
				distinct.getJSONObject("contentJson").put(key, distinctData);
			}
		}
		
		return distinct;
	}

	public String getFilterColumnHeader(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
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
			}
			for (String nonModelFilterColumn : nonModelFilterColumns) {
				if (sbColumns.toString() != "?") {
					sbColumns.append("&");
				}
				sbColumns.append("columns=");
				sbColumns.append(nonModelFilterColumn);
			}
			String subUrl = model + "/distinct/" + sbColumns.toString();
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			String columnTitles = getMicroserviceModelColumnTitleMap(resourceRequest,
					modelNameMicroService);
			JSONArray allModelColumnTitlesArray = JSONFactoryUtil.createJSONArray(columnTitles);
			JSONObject distinct = JSONFactoryUtil.createJSONObject(response);
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			JSONArray datepicker = JSONFactoryUtil.createJSONArray();
			JSONObject titles = JSONFactoryUtil.createJSONObject();
			JSONArray titles1 = JSONFactoryUtil.createJSONArray();
			distinct = filterDistinct(distinct);
			JSONArray distinctCreatedBy = distinct.getJSONArray(CREATED_BY);
			DynamicQuery studentINOperator = DynamicQueryFactoryUtil.forClass(User.class,
					PortletClassLoaderUtil.getClassLoader());
			Criterion criterion6 = null;
			ArrayList<Long> list = new ArrayList<>();
			getFilterColumnHeaderTryBlock(distinctCreatedBy, list);

			JSONArray usersInfo = JSONFactoryUtil.createJSONArray();
			JSONObject userInfo = null;
			if (!list.isEmpty()) {
				criterion6 = RestrictionsFactoryUtil.in("userId", list);
				criterion6 = RestrictionsFactoryUtil.and(criterion6,
						RestrictionsFactoryUtil.eq("status", new Integer("0")));
				studentINOperator.add(criterion6);
				List<User> studentList8 = UserLocalServiceUtil.dynamicQuery(studentINOperator);
				for (User student : studentList8) {
					userInfo = JSONFactoryUtil.createJSONObject();
					userInfo.put("id", student.getUserId());
					userInfo.put("name", student.getFirstName() + " " + student.getLastName());
					usersInfo.put(userInfo);
				}
			}

			for (String datePickerColumn : datePickerColumns) {
				datepicker.put(datePickerColumn);
			}
			for (int i = 0; i < allModelColumnTitlesArray.length(); i++) {
				JSONObject modelTitleObj = allModelColumnTitlesArray.getJSONObject(i);
				titles.put(CONTENT_JSON_PREFIX + modelTitleObj.getString("key"), modelTitleObj.getString(translation));
				_log.info("titles:" + modelTitleObj.getString(translation));

				JSONObject titleObj = JSONFactoryUtil.createJSONObject();
				titleObj.put("key", CONTENT_JSON_PREFIX + modelTitleObj.getString("key"));
				titleObj.put(valueStr, modelTitleObj.getString(translation));
				titles1.put(titleObj);
			}			
			JSONObject titleObj = JSONFactoryUtil.createJSONObject();
			titleObj.put("key", CREATED_BY);
			titleObj.put(valueStr, "Created By");
			titles1.put(titleObj);
			titleObj = JSONFactoryUtil.createJSONObject();
			titleObj.put("key", CREATED_DATE);
			titleObj.put(valueStr, "Created Date");
			titles1.put(titleObj);
			titleObj = JSONFactoryUtil.createJSONObject();
			titleObj.put("key", LAST_MODIFIED_BY);
			titleObj.put(valueStr, "Last Modified By");
			titles1.put(titleObj);
			titleObj = JSONFactoryUtil.createJSONObject();
			titleObj.put("key", LAST_MODIFIED_DATE);
			titleObj.put(valueStr, "Last Modified Date");
			titles1.put(titleObj);

			obj.put("userInfo", usersInfo);
			obj.put("distinct", distinct);
			obj.put("datepicker", datepicker);
			obj.put(TITLES, titles1);
			return obj.toString();
		} catch (Exception e) {
			_log.error("getFilterColumnHeader exception: " + e);
			response = ERROR;
		}
		return response;
	}

	private void getFilterColumnHeaderTryBlock(JSONArray distinctCreatedBy, ArrayList<Long> list) {
		for (int i = 0; i < distinctCreatedBy.length(); i++) {
			try {
				if (!distinctCreatedBy.getString(i).equalsIgnoreCase(null)) {
					list.add(Long.valueOf(distinctCreatedBy.getString(i)));
				}
			} catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void exportListToExcelFile(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			_log.debug("exportListToExcelFile invoked");
			String model = resourceRequest.getParameter(formType);
			String storageId = resourceRequest.getParameter(FORMSTORAGEID);
			String restmodel = model.toLowerCase();
			PortletSession session = resourceRequest.getPortletSession();
			String exportquery = (String) session.getAttribute(SESSION_EXPORTQUERY, PortletSession.PORTLET_SCOPE);
			JSONObject jsonExportQuery = JSONFactoryUtil.createJSONObject(exportquery);
			if (storageId != null) {
				JSONArray nn = JSONFactoryUtil.createJSONArray("[{'storageId':['" + storageId + "']}]");
				jsonExportQuery.getJSONObject("elasticsearch").put("filters", nn);
			}
			
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
	
	public void exportRowToExcelFile(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try{	_log.debug("exportRowToExcelFile invoked");
			String storageId = resourceRequest.getParameter(FORMSTORAGEID);
			String model = resourceRequest.getParameter(formType);
			String restmodel = model.toLowerCase();
			String subUrl = restmodel + "/export/" + storageId;
			JSONObject jsonExportQuery = JSONFactoryUtil.createJSONObject();
			JSONObject jsonTitleOrder = getTitleOrder(resourceRequest, model);
			jsonExportQuery.put(TITLES, jsonTitleOrder.getJSONObject(TITLES));
			jsonExportQuery.put(ORDER, jsonTitleOrder.getJSONArray(ORDER));
			new APICall(resourceRequest).downloadObject(jsonExportQuery.toString(), subUrl, HttpMethod.POST,
					resourceResponse);

		} catch (Exception e) {
			_log.error(e);
		}
	}

	private JSONObject getTitleOrder(ResourceRequest resourceRequest, String modelName) {
		JSONObject jsonTitleOrder = JSONFactoryUtil.createJSONObject();
		JSONObject titles = JSONFactoryUtil.createJSONObject();
		JSONArray order = JSONFactoryUtil.createJSONArray();
		List<String> columnsList1 = getMicroserviceModelColumnList(resourceRequest, modelName);

		order.put(CREATED_BY);
		order.put(CREATED_DATE);
		order.put(LAST_MODIFIED_BY);
		order.put(LAST_MODIFIED_DATE);
		String columnTitles = SystemLocalServiceUtil.getMicroserviceModelColumnTitleMap(resourceRequest, modelName);
		JSONArray allModelColumnTitlesArray;
		try {
			allModelColumnTitlesArray = JSONFactoryUtil.createJSONArray(columnTitles);
			for (int i = 0; i < allModelColumnTitlesArray.length(); i++) {
				titles.put(CONTENT_JSON_PREFIX + allModelColumnTitlesArray.getJSONObject(i).getString("key"),
						allModelColumnTitlesArray.getJSONObject(i).getString("translation"));
				_log.info("titles:" + allModelColumnTitlesArray.getJSONObject(i).getString("translation"));
			}
		} catch (JSONException e) {
			_log.error(e.getMessage());
		}
		titles.put(CREATED_BY, "Created By");
		titles.put(CREATED_DATE, "Created Date");
		titles.put(LAST_MODIFIED_BY, "Last Modified By");
		titles.put(LAST_MODIFIED_DATE, "Last Modified Date");

		jsonTitleOrder.put(TITLES, titles);
		jsonTitleOrder.put(ORDER, order);
		return jsonTitleOrder;

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

	public void saveCurrentQuery(String query, ResourceRequest resourceRequest) {
		_log.debug("saveCurrentQuery invoked");

		PortletSession session = resourceRequest.getPortletSession();
		session.setAttribute(SESSION_CURRENTQUERY, query, PortletSession.PORTLET_SCOPE);
	}

	public Map<Long, List<Layout>> getUserLayoutsOne(ThemeDisplay themeDisplay) {
		String navigation = FetchLocalServiceUtil.fetchRecord("1", "Navigation", themeDisplay.getUserId(),SambaashUtil.getScopeGroupId(themeDisplay.getScopeGroupId()));
		String response = FetchLocalServiceUtil.getAllRecord("childnavigation", themeDisplay.getUserId(),SambaashUtil.getScopeGroupId(themeDisplay.getScopeGroupId()));
		JSONArray content = JSONFactoryUtil.createJSONArray();
		Map<Long, List<Layout>> map = new HashMap<>();
		try {
			JSONObject childNav = JSONFactoryUtil.createJSONObject(response);
			content = childNav.getJSONArray(CONTENT);
		} catch (JSONException | NullPointerException e1) {
			_log.error(e1);
			return map;
		}
		try {
			long userId = themeDisplay.getUserId();
			JSONObject obj = JSONFactoryUtil.createJSONObject(navigation);
			JSONObject contentJson = obj.getJSONObject(CONTENT_JSON);
			JSONArray datagrid = contentJson.getJSONArray("DataGrid");
			List<Role> userRoles = getUserGroupRolesOfUser(userId);
			for (int i = 0; i < userRoles.size(); i++) {
				userLayoutIterateUserRoles(datagrid, themeDisplay, userRoles.get(i), map, content);
			}
			return map;
		} catch (PortalException | NullPointerException | SystemException e) {
			_log.error("saveCurrentQuery invoked");
			return map;
		}
	}

	private void userLayoutIterateUserRoles(JSONArray datagrid, ThemeDisplay themeDisplay, Role role,
			Map<Long, List<Layout>> map, JSONArray content) throws PortalException, SystemException {
		long layoutId;
		List<Layout> userLayouts;
		for (int j = 0; j < datagrid.length(); j++) {
			if (datagrid.getJSONObject(j).getJSONArray("Role").toString().contains(String.valueOf(role.getRoleId()))) {
				layoutId = Long.valueOf(datagrid.getJSONObject(j).getJSONObject("Layout").getString("id"));
				Layout layout = LayoutLocalServiceUtil.getLayout(themeDisplay.getScopeGroupId(), false, layoutId);
				if (!map.containsKey(layout.getLayoutId())) {
					userLayouts = new ArrayList<>();
					userLayouts.add(layout);
					for (int k = 0; k < content.length(); k++) {
						userLayoutProcessContent(userLayouts, content.getJSONObject(k), layoutId, themeDisplay);
					}
					map.put(layout.getLayoutId(), userLayouts);
				}
			}
		}
	}

	private void userLayoutProcessContent(List<Layout> userLayouts, JSONObject content, long layoutId,
			ThemeDisplay themeDisplay) throws PortalException, SystemException {
		Layout childLayout;
		JSONArray childLayouts = null;
		if (content.getJSONObject(CONTENT_JSON).getLong("ParentLayout") == layoutId) {
			childLayouts = JSONFactoryUtil
					.createJSONArray(content.getJSONObject(CONTENT_JSON).getString("ChildLayout"));
			for (int t = 0; t < childLayouts.length(); t++) {
				childLayout = LayoutLocalServiceUtil.getLayout(themeDisplay.getScopeGroupId(), false,
						childLayouts.getLong(t));
				userLayouts.add(childLayout);
			}
		}
	}

	private static List<Role> getUserGroupRolesOfUser(long userId) throws SystemException {
		return RoleLocalServiceUtil.getUserRoles(userId);
	}

	public String fetchElasticRecordsForGenericSearch(long userId, long scopeId, String jsonElasticSearchQuery,
			String subUrl) {

		String response = "";
		try {
			response = new APICall(userId, scopeId).postForObject(jsonElasticSearchQuery, subUrl);
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}

	public Map fetchDocumentS3(ResourceRequest resourceRequest, String fileName) {
		Map response = null;
		try {
			String subUrl = "taxcode/download/" + fileName;
			response = new APICall(resourceRequest).downloadFile(subUrl, HttpMethod.GET);
			response.get(CONTENT);
			response.get("contentType");
			return response;
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}

	public String getElasticSearchListForModel(String model, long siteId) {

		String response = null;
		try {
			String subUrl = model + ELASTIC_SEARCH + PAGE_EQUAL + "0" + restUriSize + "1000";
			JSONArray jsonTerms = JSONFactoryUtil.createJSONArray();
			long userId = 1111;

			JSONObject jsonMustClause = JSONFactoryUtil.createJSONObject();
			jsonMustClause.put("must", jsonTerms);
			JSONObject jsonElasticSearchQuery = JSONFactoryUtil.createJSONObject();
			jsonElasticSearchQuery.put("bool", jsonMustClause);
			response = new APICall(userId, siteId).postForObject(jsonElasticSearchQuery.toString(), subUrl);

		} catch (Exception e) {
			_log.error(e);
			response = ERROR;
		}
		return response;

	}

	public String generateReferenceNumber(long scopeGroupId, String productType, String productSubType,
			String functionalComponent, String categoryType, String clientType) {
		String errorMsg = "";
		try {
			APICall apiCall = new APICall(1111, scopeGroupId);
			String subUrl = "referencenumber/generate";
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
			errorMsg = populateBasicDetails(scopeGroupId, jsonObj, productType, productSubType, functionalComponent,
					categoryType, clientType);
			if (errorMsg == null) {
				return apiCall.postForObject(jsonObj.toString(), subUrl);
			} else {
				return errorMsg;
			}
		} catch (Exception e) {
			_log.error(e);
			return e.getMessage();
		}
	}

	private SPListType getSpListTypeByDisplayName(String displayName, List<SPListType> spListTypeList) {
		for (SPListType spLT : spListTypeList) {
			if (spLT.getDisplayName().equalsIgnoreCase(displayName)) {
				return spLT;
			}
		}
		return null;
	}

	private String populateBasicDetails(long scopeGroupId, JSONObject jsonObj, String productType,
			String productSubType, String functionalComponent, String categoryType, String clientType)
			throws SystemException {
		List<SPListType> ptSpListTypeList = SPListTypeLocalServiceUtil.getByKey("finance.accountingtable.productype",
				scopeGroupId);
		List<SPListType> pstSpListTypeList = SPListTypeLocalServiceUtil
				.getByKey("finance.accountingtable.exam.producsubtype", scopeGroupId);
		List<SPListType> fcSpListTypeList = SPListTypeLocalServiceUtil.getByKey(FUNC_COMP_KEY, scopeGroupId);
		List<SPListType> ctSpListTypeList = SPListTypeLocalServiceUtil.getByKey("finance.referencenumber.categorytype",
				scopeGroupId);
		List<SPListType> tSpListTypeList = SPListTypeLocalServiceUtil.getByKey("finance.accountingtable.clienttype",
				scopeGroupId);
		SPListType ptSpListType = getSpListTypeByDisplayName(productType, ptSpListTypeList);
		SPListType pstSpListType = getSpListTypeByDisplayName(productSubType, pstSpListTypeList);
		SPListType fcSpListType = getSpListTypeByDisplayName(functionalComponent, fcSpListTypeList);
		SPListType ctSpListType = getSpListTypeByDisplayName(categoryType, ctSpListTypeList);
		SPListType tSpListType = getSpListTypeByDisplayName(clientType, tSpListTypeList);

		if (ptSpListType != null) {
			jsonObj.put(PRODUCT_TYPE, ptSpListType.getSpListTypeId());
		} else {
			return "Invalid product type entered !!";
		}

		if (pstSpListType != null) {
			jsonObj.put(PRODUCT_SUB_TYPE, pstSpListType.getSpListTypeId());
		} else {
			return "Invalid product sub-type entered !!";
		}

		if (fcSpListType != null) {
			jsonObj.put(FUNC_COMP, fcSpListType.getItemValue());
		} else {
			return "Invalid functional component entered !!";
		}

		if (ctSpListType != null) {
			jsonObj.put(CATEGORY_TYPE, ctSpListType.getSpListTypeId());
		} else {
			return "Invalid category type entered !!";
		}

		if (tSpListType != null) {
			jsonObj.put("Type", tSpListType.getSpListTypeId());
		} else {
			return "Invalid client type entered !!";
		}
		return null;
	}

	public String saveTransactionData(long scopeGroupId, String productType, String productSubType,
			String functionalComponent, String categoryType, String clientType, String txnDate, String source,
			String txnType, String title, String description, String dueDate, String valueDate, String creditDate,
			String transactionDetailJson) {
		String errorMsg = "";
		try {
			APICall apiCall = new APICall(1111, scopeGroupId);
			String subUrl = "invoicing/new";
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
			errorMsg = populateBasicDetails(scopeGroupId, jsonObj, productType, productSubType, functionalComponent,
					categoryType, clientType);
			if (errorMsg != null) {
				return errorMsg;
			}
			jsonObj.put("TransactionMasterCode", "TMC-" + new Date().getTime());
			jsonObj.put("Status", "Pending");
			jsonObj.put("TxnDate", txnDate);
			jsonObj.put("Source", source);
			jsonObj.put("TxnType", txnType);
			jsonObj.put("Title", title);
			jsonObj.put("Description", description);
			jsonObj.put("DueDate", dueDate);
			jsonObj.put("ValueDate", valueDate);
			jsonObj.put("CreditDate", creditDate);
			jsonObj.put("TransactionDetails", JSONFactoryUtil.createJSONArray(transactionDetailJson));
			JSONObject mainObj = JSONFactoryUtil.createJSONObject();
			mainObj.put(CONTENT_JSON, jsonObj);
			apiCall.postForObject(mainObj.toString(), subUrl);
			return "success";
		} catch (Exception e) {
			_log.error(e);
		}
		return ERROR;
	}

	public boolean isSubmitter(HttpServletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		try {
			return RoleServiceUtil.hasUserRoles(userId, themeDisplay.getCompanyId(),
					new String[] { "Submitter", ADMINISTRATOR }, true);
		} catch (PortalException | SystemException e) {
			_log.error(e);
			return false;
		}
	}

	public boolean isApprover(HttpServletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		try {
			return RoleServiceUtil.hasUserRoles(userId, themeDisplay.getCompanyId(),
					new String[] { "Approver", ADMINISTRATOR }, true);
		} catch (PortalException | SystemException e) {
			_log.error(e);
			return false;
		}
	}

	public void exportPdf(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			String data = resourceRequest.getParameter("data");
			JSONObject dataOnject = JSONFactoryUtil.createJSONObject(data);
            if(dataOnject.has("candidateNumber")){
            String pdfUrl = "resultmaster" + "/exportpdf/" + dataOnject.getString("candidateNumber");
            new APICall(resourceRequest).downloadPdf(data, pdfUrl, HttpMethod.GET, resourceResponse);
            }
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	public String exportTranscript(String programCode, String candidateNumber){
		try {
			String subUrl = "resultmaster" + "/exportpdf/" + programCode + "/" +candidateNumber;
			return  new APICall(SambaashUtil.getAdminUserId(), 0).preparePdf("", subUrl, HttpMethod.GET);
		} catch (Exception e) {
			_log.error(e);
			_log.error(e);
		}
		return null;
	}

	private JSONObject preparePdfData(JSONObject transactionObj, String customerName, String customerAddress) {
		JSONObject data = JSONFactoryUtil.createJSONObject();
		data.put("documentType", "TAX INVOICE");
		data.put("customerName", customerName);
		data.put("customerAddress", customerAddress);
		if (StringUtils.isEmpty(transactionObj.getString("InvoiceNo"))) {
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
		for (int i = 0; i < array.length(); i++) {
			JSONObject obj = array.getJSONObject(i);
			data.put("sn" + i, (i + 1));
			data.put("description" + i, obj.getString("title"));
			data.put("currency" + i, obj.getString("currency"));
			data.put("unitPrice" + i, obj.getString("unitPrice"));
			data.put("quantity" + i, obj.getString("quantity"));
			data.put("gstTaxCode" + i, obj.getString("taxCode"));
			data.put("amountExclGst" + i, obj.getString("amount"));
		}
		data.put("exchangeRate", "AUD/SGD 1.01");
		data.put("totalAmountExclGst", transactionObj.getString(AMOUNT));
		data.put("totalAmountInclGst", transactionObj.getString(AMOUNT));
		data.put("totalInvoiceAmount", transactionObj.getString(AMOUNT));
		data.put("totalInclGst", transactionObj.getString(AMOUNT));
		return data;
	}

	public String processRecord(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = "";
		try {
			String data = resourceRequest.getParameter("data");
			JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(data);
			String storageId = jsonModelData.getString(FORMSTORAGEID);
			String action = jsonModelData.getString("action");
			String reason = jsonModelData.getString("reason");
			String creditToBalance = jsonModelData.getString("creditToBalance");
			String categoryMap = jsonModelData.getString("categoryMap");
			String model = jsonModelData.getString(formType).toLowerCase();
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("action", action);
			jsonObject.put("reason", reason);
			jsonObject.put("creditToBalance", creditToBalance);
			jsonObject.put("categoryMap", JSONFactoryUtil.createJSONObject(categoryMap));
			URI uriStorageId = URI.create(storageId);
			String subUrl = model + "/process/" + uriStorageId;
			response = new APICall(resourceRequest).postForObject(jsonObject.toString(), subUrl);
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}

	public Map<String, String> getCategoryMap(HttpServletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Map<String, String> categoryMap = new HashMap<>();
		try {
			List<SPListType> spListTypeList = SPListTypeLocalServiceUtil
					.getByKey("finance.referencenumber.categorytype", themeDisplay.getScopeGroupId());
			for (SPListType spListType : spListTypeList) {
				categoryMap.put(spListType.getItemValue(), String.valueOf(spListType.getSpListTypeId()));
			}
		} catch (SystemException e) {
			_log.error(e);
		}
		return categoryMap;
	}

	public Map<String, String> getTransactionTypeMap(HttpServletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Map<String, String> transactionTypeMap = new HashMap<>();
		try {
			List<SPListType> spListTypeList = SPListTypeLocalServiceUtil
					.getByKey("finance.accountingtable.transactiontype", themeDisplay.getScopeGroupId());
			for (SPListType spListType : spListTypeList) {
				transactionTypeMap.put(spListType.getItemValue(), String.valueOf(spListType.getSpListTypeId()));
			}
		} catch (SystemException e) {
			_log.error(e);
		}
		return transactionTypeMap;
	}

	public Map<String, String> getClientTypeMap(HttpServletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Map<String, String> clientTypeMap = new HashMap<>();
		try {
			List<SPListType> spListTypeList = SPListTypeLocalServiceUtil.getByKey("finance.accountingtable.clienttype",
					themeDisplay.getScopeGroupId());
			for (SPListType spListType : spListTypeList) {
				clientTypeMap.put(spListType.getItemValue(), String.valueOf(spListType.getSpListTypeId()));
			}
		} catch (SystemException e) {
			_log.error(e);
		}
		return clientTypeMap;
	}

	public Map<String, String> getFunctionalComponentMap(HttpServletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Map<String, String> map = new HashMap<>();
		try {
			List<SPListType> spListTypeList = SPListTypeLocalServiceUtil.getByKey(FUNC_COMP_KEY,
					themeDisplay.getScopeGroupId());
			for (SPListType spListType : spListTypeList) {
				map.put(spListType.getItemValue(), String.valueOf(spListType.getSpListTypeId()));
			}
		} catch (SystemException e) {
			_log.error(e);
		}
		return map;
	}

	public Map<String, String> getProductTypeMap(HttpServletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Map<String, String> map = new HashMap<>();
		try {
			List<SPListType> spListTypeList = SPListTypeLocalServiceUtil.getByKey("finance.accountingtable.productype",
					themeDisplay.getScopeGroupId());
			for (SPListType spListType : spListTypeList) {
				map.put(spListType.getItemValue(), String.valueOf(spListType.getSpListTypeId()));
			}
		} catch (SystemException e) {
			_log.error(e);
		}
		return map;
	}

	public Map<String, String> getProductSubTypeMap(HttpServletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Map<String, String> map = new HashMap<>();
		try {
			List<SPListType> spListTypeList = SPListTypeLocalServiceUtil
					.getByKey("finance.accountingtable.exam.producsubtype", themeDisplay.getScopeGroupId());
			for (SPListType spListType : spListTypeList) {
				map.put(spListType.getItemValue(), String.valueOf(spListType.getSpListTypeId()));
			}
		} catch (SystemException e) {
			_log.error(e);
		}
		return map;
	}


}