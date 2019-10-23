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

package com.sambaash.platform.finance.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ArrayUtils;
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
import com.liferay.portal.NoSuchUserException;
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
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.service.persistence.GroupUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.finance.constants.FinanceConstants;
import com.sambaash.platform.finance.service.base.SPFinanceLocalServiceBaseImpl;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.model.microservicemodel.MicroServiceModel;
import com.sambaash.platform.service.FetchLocalServiceUtil;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPListType;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the s p finance local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.finance.service.SPFinanceLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author abhishek.upadhyay
 * @see com.sambaash.platform.finance.service.base.SPFinanceLocalServiceBaseImpl
 * @see com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil
 */
public class SPFinanceLocalServiceImpl extends SPFinanceLocalServiceBaseImpl {
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
	private static final String ELASTIC_SEARCH = "/elasticsearch?";
	private static final String CATEGORY_TYPE = "CategoryType";
	private static final String CONDITIONS = "conditions";
	private static final String PAGE_EQUAL = "page=";
	private static final String FUNC_COMP_KEY = "finance.referencenumber.functionalcomponent";
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
	private static final String TEMPLATE_BUCKET_URL = "https://s3-ap-southeast-1.amazonaws.com/wattabyte.sambaash/";
	private static final String CACHE_CONTROL_PROP = "no-cache,no-store";
	private static final String TELLER_NAME = "TellerName";
	private static final String LOR_REPORT_MODEL = "lorreport";
	private static final String REMARKS_MODEL = "invoiceremarks";
	private static final String TRANSACTION_MODEL = "transactionmaster";
	private static final String PRODUCT_TYPE_SUBTYPE = "ProductTypeSubType";
	private static final String ID_NAME = "IdName";
	private static final String CATEGORY_MAP = "categoryMap";
	private static final String RECEIPT_CODE = "RE";
	private static final String VOID = "void";
	private static final String CANCEL = "cancel";
	private static final String RETURN = "return";
	private static final String USER_ID = "UserId";
	private static final String DCC_REPORT_MODEL = "dccreport";
	private static final String DCC_SUBMITTED_BY = "submittedBy";
	private static final String DCC_ACKNOWLEDGED_BY_AA = "acknowledgedByAa";
	private static final String DCC_ACKNOWLEDGED_BY_FND = "acknowledgedByFnd";
	private static final String REMARK = "remark";
	private static final String FILTERS = "filters";
	private static final String SUBMITTED_CLAIM_MODEL = "submittedclaim";
	
	private static final Log _log = LogFactoryUtil.getLog(SPFinanceLocalServiceImpl.class);

	private static String formType = "formType";
	private static String sortBy = "sortBy";
	private static String restUriGet = "/get/";
	private static String restUriSize = "&size=";
	private static String requestURL = "Request URL";
	private static String restUriLimit = "limit";
	private static String sort = "sort";
	private static String status = "status";
	private static String valueStr = "value";
	private static String translation = "translation";

	private static Map<String, String[]> modelToColumnMap = new HashMap();
	private static Map<String, String[]> columnToKeyMap = new HashMap();
	private static Map<String, String[]> customColumnMap = new HashMap();

	static {
		modelToColumnMap.put(TRANSACTION_DOCUMENT, new String[] { PRODUCT_TYPE, PRODUCT_SUB_TYPE, FUNC_COMP,
				CATEGORY_TYPE, "Type", "AdvanceInvoice", "TemplateFor" });
		modelToColumnMap.put("referencenumber", new String[] { PRODUCT_TYPE, PRODUCT_SUB_TYPE, FUNC_COMP, CATEGORY_TYPE,
				"Type", "SequenceNoReset", "Frequency" });
		modelToColumnMap.put(TRANSACTION_MODEL,
				new String[] { PRODUCT_TYPE, PRODUCT_SUB_TYPE, FUNC_COMP, CATEGORY_TYPE, "Type", NAME_OF_PAYER });
		modelToColumnMap.put(REMARKS_MODEL, new String[] {});
		modelToColumnMap.put("cashiercounter", new String[] { TELLER_NAME });
		modelToColumnMap.put("submittedclaim", new String[] { "ClaimType" });
		modelToColumnMap.put("creditbalance", new String[] { "PaymentMode" });
		columnToKeyMap.put("AdvanceInvoice", new String[] { "finance.transactiondocument.advanceinvoice" });
		columnToKeyMap.put(FUNC_COMP, new String[] { FUNC_COMP_KEY });
		columnToKeyMap.put("TemplateFor", new String[] { "finance.transactiondocument.templatefor" });
		columnToKeyMap.put("Frequency", new String[] { "finance.referencenumber.frequency" });
		columnToKeyMap.put("ClaimType", new String[] { "finance.payment.claimType" });
		columnToKeyMap.put("PaymentMode", new String[] { "finance.payment.mode" });
		customColumnMap.put(TRANSACTION_MODEL, new String[] { PRODUCT_TYPE_SUBTYPE, ID_NAME });
	}

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
			_log.debug("********userId : " + userId);
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
				_log.debug(baseUrl + subUrl);
				_log.debug(requestURL + baseUrl + subUrl);
				response = httpresponse.getBody();

			} catch (Exception e) {
				_log.debug(baseUrl + subUrl);
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
				_log.debug(baseUrl + subUrl);
				_log.debug(requestURL + baseUrl + subUrl);
				response.put(CONTENT, httpresponse.getBody());
				response.put("contentType", httpresponse.getHeaders().getContentType());
			} catch (Exception e) {
				_log.debug(baseUrl + subUrl);
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
				_log.debug(baseUrl + subUrl);
				_log.debug(data);
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
				_log.debug(baseUrl + subUrl);
				_log.debug(data);
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
				_log.debug(baseUrl + subUrl);
				if (httpresponse.getStatusCode().equals(HttpStatus.OK)) {
					_log.debug("downloadObject HTTPStatus" + httpresponse.getStatusCode().toString());
					HttpHeaders head = httpresponse.getHeaders();
					MediaType mtype = head.getContentType();
					List<String> contentDisposition = head.get(CONTENT_DISPOSITION);

					resourceResponse
							.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
					resourceResponse.addProperty(com.liferay.portal.kernel.servlet.HttpHeaders.CACHE_CONTROL,
							CACHE_CONTROL_PROP);
					_log.debug("downloadObject ContentType" + mtype.getType() + mtype.getSubtype());
					for (String cd : contentDisposition) {
						_log.debug("downloadObject Content-Disposition" + cd);
					}
					downloadObjectWriteData(resourceResponse, httpresponse);
				}
			} catch (Exception e) {
				_log.error(requestURL + baseUrl + subUrl);
				_log.error(e);
			}
		}
		
		private void downloadObjectPaymentAdvice(String data, String subUrl, HttpMethod method, ResourceResponse resourceResponse) {
			headers.setContentType(MediaType.APPLICATION_JSON);
			httprequest = new HttpEntity<>(data, headers);
			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<Resource> httpresponse = restTemplate.exchange(uri, method, httprequest, Resource.class);
				_log.debug(baseUrl + subUrl);
				if (httpresponse.getStatusCode().equals(HttpStatus.OK)) {
					_log.debug("downloadObject HTTPStatus" + httpresponse.getStatusCode().toString());
					HttpHeaders head = httpresponse.getHeaders();
					MediaType mtype = head.getContentType();
					List<String> contentDisposition = head.get(CONTENT_DISPOSITION);

					resourceResponse
							.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
					resourceResponse.addProperty(com.liferay.portal.kernel.servlet.HttpHeaders.CACHE_CONTROL,
							CACHE_CONTROL_PROP);
					_log.debug("downloadObject ContentType" + mtype.getType() + mtype.getSubtype());
					for (String cd : contentDisposition) {
						_log.debug("downloadObject Content-Disposition" + cd);
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
				IOUtils.copy(in, out);
				out.flush();
				resourceResponse.flushBuffer();
			} catch (final IOException e) {
				_log.error(e);
			}
		}

		private String preparePdf(String data, String subUrl, HttpMethod method, ResourceResponse resourceResponse) {
			headers.setContentType(MediaType.APPLICATION_JSON);
			httprequest = new HttpEntity<>(data, headers);
			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<Resource> httpresponse = restTemplate.exchange(uri, method, httprequest, Resource.class);
				_log.debug(baseUrl + subUrl + httpresponse.getStatusCode());
				if (httpresponse.getStatusCode().equals(HttpStatus.OK)) {
					resourceResponse.setContentType("application/pdf");
					resourceResponse.addProperty(com.liferay.portal.kernel.servlet.HttpHeaders.CACHE_CONTROL,
							CACHE_CONTROL_PROP);
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

		private void downloadPdf(String data, String subUrl, HttpMethod method, ResourceResponse resourceResponse) {
			headers.setContentType(MediaType.APPLICATION_JSON);
			httprequest = new HttpEntity<>(data, headers);
			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<Resource> httpresponse = restTemplate.exchange(uri, method, httprequest, Resource.class);
				_log.debug(baseUrl + subUrl + httpresponse.getStatusCode());
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
			} catch (final Exception e) {
				_log.error(e);
			}
		}

		private void downloadObjects(String data, String subUrl, HttpMethod method, ResourceRequest resourceRequest,
				ResourceResponse resourceResponse) {
			headers.setContentType(MediaType.APPLICATION_JSON);
			httprequest = new HttpEntity<>(data, headers);
			String model = resourceRequest.getParameter(formType).toLowerCase();
			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<String> httpresponse = restTemplate.exchange(uri, method, httprequest, String.class);
				_log.debug(baseUrl + subUrl);
				_log.debug("httpresponse.getStatusCode() : " + httpresponse.getStatusCode());
				if (httpresponse.getStatusCode().equals(HttpStatus.OK)) {
					String response2 = httpresponse.getBody();
					if (modelToColumnMap.get(model) != null) {
						response2 = setSPListTypeDecriptions(resourceRequest, response2, model);
					}
					exportData(response2, data, resourceResponse);
				} else {
					_log.debug("downloadObject HTTPStatus" + httpresponse.getStatusCode().toString());
				}
			} catch (Exception e) {
				_log.error(requestURL + baseUrl + subUrl);
				_log.error(e);
			}
		}
		
		private void writeDataToOs(ResourceResponse resourceResponse, XSSFWorkbook workbook) {
			try (OutputStream outStrm = resourceResponse.getPortletOutputStream()) {
				workbook.write(outStrm);
			} catch (IOException e) {
				_log.error(e);
			}
		}

		private int writeExcelEntityRow(XSSFSheet sheet, int rowNum, org.json.JSONObject entityJson, String[] order) {
			int colNum = 0;
			Row row = sheet.createRow(rowNum++);
			for (String datakey : order) {
				Cell cell = row.createCell(colNum++);
				Object field = null;
				try {
					if (datakey.contains(CONTENT_JSON_PREFIX))
						field = ((org.json.JSONObject) entityJson.get(CONTENT_JSON))
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

		private Integer writeExcelEntityTitle(XSSFSheet sheet, org.json.JSONObject entityTitles, String[] order) {
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

		private void exportData(String response2, String data, ResourceResponse resourceResponse) {
			_log.debug("data : " + data);
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
				for (int i = 0; i < jsonTitlesOrder.length(); i++) {
					jsonOrder.add(jsonTitlesOrder.getString(i));
				}
				for (int i = 0; i < contentJsonTitles.length(); i++) {
					jsonOrder.add(contentJsonTitles.getString(i));
				}
				String[] order = jsonOrder.toArray(new String[0]);
				XSSFSheet sheet = workbook.createSheet(fileName.replace(".xlsx", ""));
				// rowNum = writeExcelEntityTitle(sheet, jsonTitles, order);

				org.json.JSONArray orderFromJSONList = new org.json.JSONArray();

				for (Integer index = 0; index < content.length(); index++) {
					org.json.JSONObject orderFromJSON = new org.json.JSONObject();
					org.json.JSONObject tempObject = content.getJSONObject(index);
					for (int i = 0; i < jsonTitlesOrder.length(); i++) {
						orderFromJSON.put(jsonTitlesOrder.getString(i), ((tempObject.has(jsonTitlesOrder.getString(i)))
								? tempObject.getString(jsonTitlesOrder.getString(i)) : ""));
					}
					org.json.JSONObject contentJson = tempObject.getJSONObject("contentJson");
					for (int i = 0; i < contentJsonTitles.length(); i++) {

						orderFromJSON.put(contentJsonTitles.getString(i),
								((contentJson.has(contentJsonTitles.getString(i)))
										? contentJson.getString(contentJsonTitles.getString(i)) : ""));

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
					resourceResponse.addProperty("Cache-Control", "max-age=3600, must-revalidate");
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
				// TODO Auto-generated catch block
				_log.error(e1);
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
		
		private void downloadPdfZip(String data, String subUrl, HttpMethod method,
				ResourceResponse resourceResponse) {
			headers.setContentType(MediaType.APPLICATION_JSON);
			httprequest = new HttpEntity<>(data, headers);
			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<Resource> httpresponse = restTemplate.exchange(
						uri, method, httprequest, Resource.class);
				_log.debug("httpresponse header === " + httpresponse.getHeaders());
				_log.debug("httpresponse === " + httpresponse.getStatusCode());
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
	}

	public String createRecord(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = "";
		try {
			String modeldata = resourceRequest.getParameter("data");
			_log.debug("model data is " + modeldata);
			String apiModelData = convertToAPIModel(resourceRequest, modeldata, "");
			_log.debug("api model data is " + apiModelData);
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + "/new";
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
			_log.debug("aapi model data is " + jsonContentJSONData.toString());
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
			_log.debug("storageId : " + storageId);
			if (StringUtils.isEmpty(storageId) || "0".equals(storageId)) {
				storageId = JSONFactoryUtil.createJSONObject(resourceRequest.getParameter("data"))
						.getString(FORMSTORAGEID);
			}
			_log.debug("storageId : " + storageId);
			String model = resourceRequest.getParameter(formType);
			String indetail = resourceRequest.getParameter("indetail");
			if (StringUtils.isEmpty(indetail)) {
				indetail = JSONFactoryUtil.createJSONObject(resourceRequest.getParameter("data")).getString("indetail");
			}
			String subUrl = model.toLowerCase() + restUriGet + storageId;
			existingData = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			response = convertToFormModel(existingData, model);
			if (modelToColumnMap.get(model.toLowerCase()) != null && indetail != null && indetail.equals("true")) {
				response = setSPListTypeDecriptions(resourceRequest, response, model);
			}
			if ("dccreport".equals(model)) {

				JSONObject object = JSONFactoryUtil.createJSONObject(response);
				Long submittedBy = object.getLong("submittedBy");
				if (submittedBy > 0) {
					object.put("submittedBy", getUserName(submittedBy.toString(), ""));
				}
				Long ackAABy = object.getLong("acknowledgedByAa");
				if (ackAABy > 0) {
					object.put("acknowledgedByAa", getUserName(ackAABy.toString(), ""));
				}
				Long ackFNBy = object.getLong("acknowledgedByFnd");
				if (ackFNBy > 0) {
					object.put("acknowledgedByFnd", getUserName(ackFNBy.toString(), ""));
				}
				response = object.toString();
			}
		} catch (Exception e) {
			_log.error(e);
			response = e.toString();
		}
		return response;
	}
	
	public String fetchInvoiceReceipt(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = null;
		try {
			JSONObject dataJson = JSONFactoryUtil.createJSONObject(resourceRequest.getParameter("data"));
			String storageId = dataJson.getString(FORMSTORAGEID);
			String receiptCategoryId  = dataJson.getString("receiptCategoryId");
			String model = dataJson.getString(formType);
			_log.info("storageId : " + storageId);
			_log.info("receiptCategoryId : " + receiptCategoryId);
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			obj.put("storageIds", storageId);
			obj.put("receiptCategoryId", receiptCategoryId);
			_log.info("obj.toString() : " + obj.toString());
			String subUrl = model.toLowerCase() + "/invoice/receipt";
			response = new APICall(resourceRequest).postForObject(obj.toString(), subUrl);
		} catch (Exception e) {
			_log.error(e);
			response = e.toString();
		}
		return response;
	}
	
	public String fetchOrganizationIds(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = "";
		try {
			String modeldata = resourceRequest.getParameter("reportDto");
			_log.debug("creating data" + modeldata);
			if (StringUtils.isEmpty(modeldata)) {
				modeldata = JSONFactoryUtil.createJSONObject(resourceRequest.getParameter("data"))
						.getString("reportDto");
			}
			_log.debug("model data is " + modeldata);
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + "/getOverdueOrganizationIds";
			response = new APICall(resourceRequest).postForObject(modeldata, subUrl);
			
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}
	
	public String getReportPdfData(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = "";
		String existingData = "";
		try {
			String modeldata = resourceRequest.getParameter("reportDto");
			_log.debug("creating data" + modeldata);
			if (StringUtils.isEmpty(modeldata)) {
				modeldata = JSONFactoryUtil.createJSONObject(resourceRequest.getParameter("data"))
						.getString("reportDto");
			}
			_log.debug("model data is " + modeldata);
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + "/getReportPdfData";
			existingData = new APICall(resourceRequest).postForObject(modeldata, subUrl);
			response = convertToReportData(existingData).toString();
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}

	public String getCreditDetailByUserId(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = null;
		String existingData = null;
		try {
			String userId = resourceRequest.getParameter("userId");
			if (StringUtils.isEmpty(userId)) {
				userId = JSONFactoryUtil.createJSONObject(resourceRequest.getParameter("data")).getString("userId");
			}
			String model = resourceRequest.getParameter(formType);

			String subUrl = model.toLowerCase() + restUriGet + userId;
			existingData = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			response = convertToFormModel(existingData, model);

		} catch (Exception e) {
			_log.error(e);
			response = e.toString();
		}
		return response;
	}

	public String fetchTodayRecord(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = null;
		String existingData = null;
		try {
			String model = resourceRequest.getParameter(formType);
			String subUrl = model.toLowerCase() + "/list/1";
			existingData = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			_log.debug("existingData : " + existingData);
			response = convertToFormModel(existingData, model);
			_log.debug(response);
		} catch (Exception e) {
			_log.error(e);
			response = e.toString();
		}
		return response;
	}

	public String checkLOR(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = null;
		String existingData = null;
		try {
			String model = resourceRequest.getParameter(formType);
			String subUrl = model.toLowerCase() + "/checkLORProcessing";
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			_log.debug("response  check LOR data is " + existingData);
		} catch (Exception e) {
			_log.error(e);
			response = e.toString();
		}
		return response;
	}

	public String invoiceFilter(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = null;
		try {
			String dataJson = resourceRequest.getParameter("data");
			JSONObject dataJsonObj = JSONFactoryUtil.createJSONObject(dataJson);
			dataJsonObj.put(CATEGORY_MAP, JSONFactoryUtil.createJSONObject(dataJsonObj.getString(CATEGORY_MAP)));
			dataJsonObj.put("corporateMap", JSONFactoryUtil.createJSONObject(dataJsonObj.getString("corporateMap")));
			_log.debug("model data is " + dataJson);
			_log.debug("model data is " + dataJsonObj.toString());
			String subUrl = TRANSACTION_MODEL + "/invoicefilter";
			response = new APICall(resourceRequest).postForObject(dataJsonObj.toString(), subUrl);
			response = replaceCorporateName(response);
			_log.debug("response data is fetchReceiptInfo" + response);
		} catch (Exception e) {
			_log.error(e);
			response = e.toString();
		}
		return response;
	}

	private String replaceCorporateName(String response) throws JSONException {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray(response);
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			String name = jsonObject.getString("name");
			try {
				com.sambaash.platform.srv.startupprofile.model.Organization organization = OrganizationLocalServiceUtil
						.findByName(name);
				if (organization != null) {
					jsonObject.put("name", organization.getName());
				}
			} catch (Exception e) {
				_log.error(e);
			}
		}
		return jsonArray.toString();
	}

	public String fetchMiscFeeSchemeList(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = null;
		try {
			String priceSchemeId = resourceRequest.getParameter("priceSchemeId");
			if (StringUtils.isEmpty(priceSchemeId)) {
				priceSchemeId = JSONFactoryUtil.createJSONObject(resourceRequest.getParameter("data"))
						.getString("priceSchemeId");
			}
			String model = resourceRequest.getParameter(formType);
			String subUrl = model.toLowerCase() + "/fetchMiscFeeSchemeList/" + priceSchemeId;
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
		} catch (Exception e) {
			_log.error(e);
			response = e.toString();
		}
		return response;
	}

	public String fetchReportType(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = null;
		try {
			String model = resourceRequest.getParameter(formType);
			String subUrl = model.toLowerCase() + "/getReportType";
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
		} catch (Exception e) {
			_log.error(e);
			response = e.toString();
		}
		return response;
	}

	public String getRefundMiscFees(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = null;
		try {
			String model = resourceRequest.getParameter(formType);
			String subUrl = model.toLowerCase() + "/getRefundMiscFees";
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
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
			_log.debug("updating data" + modeldata);
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + restUriGet + storageId;
			String existingData = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			_log.debug("existingData : " + existingData);
			String apiModelData = convertToAPIModel(resourceRequest, modeldata, existingData);
			_log.debug("update data" + apiModelData);
			URI uriStorageId = URI.create(storageId);
			subUrl = model + "/edit/" + uriStorageId;
			_log.debug("subUrl : " + subUrl);
			_log.debug("apiModelData : " + apiModelData);
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

	public Map<String, String> getMicroserviceModelColumnTitleMap(ResourceRequest resourceRequest, String modelName) {
		Map<String, String> map = new HashMap<>();
		String response = null;
		try {
			String data = resourceRequest.getParameter("data");
			String catType = "";
			if (data != null) {
				catType = JSONFactoryUtil.createJSONObject(data).getString(CATEGORY_TYPE);
			}
			String subUrl = modelName.toLowerCase() + "/getColumnTitleMap?categoryType=" + catType;
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			response = response.substring(1, response.length() - 1);
			String[] keyValuePairs = response.split(",");
			for (String pair : keyValuePairs) {
				String[] entry = pair.split("=");
				map.put(entry[0].trim(), entry[1].trim());
			}
		} catch (Exception e) {
			_log.error(e);
		}
		return map;
	}

	public String getMicroserviceModelColumnTitleMapNew(ResourceRequest resourceRequest, String modelName) {
		String response = null;
		try {
			String data = resourceRequest.getParameter("data");
			String catType = "";
			if (data != null) {
				catType = JSONFactoryUtil.createJSONObject(data).getString(CATEGORY_TYPE);
			}
			String subUrl = modelName.toLowerCase() + "/getColumnTitleMap?categoryType=" + catType;
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
		try {
			String categoryMapString = jsonModelData.getString("CategoryMap");
			String sourceTypeMapString = jsonModelData.getString("SourceTypeMap");
			if (categoryMapString != null) {
				jsonModelData.put("CategoryMap", JSONFactoryUtil.createJSONObject(categoryMapString));
			}
			if (sourceTypeMapString != null) {
				jsonModelData.put("SourceTypeMap", JSONFactoryUtil.createJSONObject(sourceTypeMapString));
			}
		} catch(Exception e) {
			_log.error(e);
		}
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
			if (inp.has("ModelName") && inp.getString("ModelName").equalsIgnoreCase("transactionmaster")) {
				columns = new ArrayList<>();
			}
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
	

	public JSONObject convertToReportData(String existingData) throws JSONException {
		JSONObject jsonModelExistingData = JSONFactoryUtil.createJSONObject(existingData);
		try{
			JSONArray tableValues = jsonModelExistingData.getJSONArray("tableValues");
			JSONArray jsonAry = tableValues.getJSONArray(0);
			String[] stringArray = convertJsonArrayToStringArry(jsonAry);
			String[][] tableDatas = new String[tableValues.length()][stringArray.length];
			for(int count=0;count <tableValues.length(); count++){
				JSONArray jsonArry = tableValues.getJSONArray(count);
				tableDatas[count] = convertJsonArrayToStringArry(jsonArry);
				if(count !=0){
					setUserNameAndDetail(tableDatas[count][4], tableDatas[count][5], tableDatas, count);
				}						
			}
			jsonModelExistingData.put("tableValues",convertStringArryToJsonArray(tableDatas));
		}catch(Exception e){
			_log.error(e);
			
		}
		return jsonModelExistingData;
	}
	
	private JSONArray convertStringArryToJsonArray(String[][] stringArray){
		JSONArray array = JSONFactoryUtil.createJSONArray();
		for (String[] stringAry : stringArray) {
			array.put(convertStringArryToJSONArray(stringAry));
		}
		return array;
	}

	private JSONArray convertStringArryToJSONArray(String[] stringArray){
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (int i = 0; i < stringArray.length; i++) {
			jsonArray.put(stringArray[i]);
		}
		return jsonArray;
	}
	
	private String[] convertJsonArrayToStringArry(JSONArray jsonArray){
		String[] stringArray = new String[jsonArray.length()];
		for (int i = 0; i < jsonArray.length(); i++) {
		    stringArray[i]= jsonArray.getString(i);
		}
		return stringArray;
	}
	
	private void setUserNameAndDetail(String userId, String type, String[][] tableDatas, int count) throws SystemException, PortalException {
		try {
			if (!StringUtils.isEmpty(userId)) {
				if (type != null && type.equals("Corporate")) {
					com.sambaash.platform.srv.startupprofile.model.Organization organization = OrganizationLocalServiceUtil
							.fetchOrganization(Long.parseLong(userId));
					if (organization != null) {
						tableDatas[count][4] = organization.getName();
						tableDatas[count][5] = organization.getCorporateCode();
					}
				} else {
					User user = UserLocalServiceUtil.getUserById(Long.parseLong(userId));
					if (user != null) {
						tableDatas[count][4] = user.getFirstName() + " " + user.getLastName();
						tableDatas[count][5] = String.valueOf(user.getUserId());
					}
				}
			}
		} catch (NoSuchUserException ex) {
			_log.error(ex.getMessage());
		}
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
			String subUrl = model + "/list?page=" + page + restUriSize + limit + "&" + sort + "=" + sortByField;
			saveCurrentQuery("{}", resourceRequest);
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
		} catch (Exception e) {
			_log.error(e);
			response = ERROR;
		}
		return response;
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

	private String setSPListTypeDecriptions(ResourceRequest resourceRequest, String jsonDataString, String model)
			throws SystemException, PortalException {
		String[] dropDownColumns = modelToColumnMap.get(model.toLowerCase());
		String[] customColumns = customColumnMap.get(model.toLowerCase());
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
			} catch (Exception e1) {
				_log.error(e1);
			}
			JSONObject contentJson = content.getJSONObject(i).getJSONObject(CONTENT_JSON);
			if (customColumns != null) {
				replaceCustomColumns(contentJson, customColumns, themeDisplay, resourceRequest);
			}
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
				SPListType spListType = getSpListValue(column, contentJson, code, themeDisplay);
				if (spListType != null) {
					String desc = spListType.getDisplayName();
					if (StringUtils.isNotEmpty(desc)) {
						contentJson.put(column, desc);
					}
				}
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
		}
	}

	private SPListType getSpListValue(String column, JSONObject contentJson, String code, ThemeDisplay themeDisplay)
			throws SystemException, PortalException {
		SPListType spListType = null;
		if (column.equalsIgnoreCase(NAME_OF_PAYER) || column.equalsIgnoreCase(TELLER_NAME)) {
			replaceUserName(contentJson, column, code);
			if(column.equalsIgnoreCase(NAME_OF_PAYER) && contentJson.getString("Type").equals("Individual")){
				User user = UserLocalServiceUtil.getUserById(Long.parseLong(code));
				if (user != null && user.getAddresses()!=null && !user.getAddresses().isEmpty()) {
				Address address = user.getAddresses().get(0);
				String s1 = address.getStreet1()!=null?address.getStreet1():"";
				String s2 = address.getStreet2()!=null?address.getStreet2():"";
				String s3 = address.getStreet3()!=null?address.getStreet3():"";
				String city = address.getCity()!=null?address.getCity():"";
				String country = address.getCountry()!=null?address.getCountry().getName():"";
				String zip = address.getZip()!=null?"("+address.getZip()+")":"";
				String add = s1 + " " + s2 + " " + s3 + " " + city + " " + country + " " + zip;
					 contentJson.put("AddressOfPayer", add);
				}
				
			}
		} else if (StringUtils.isNumeric(code) && !StringUtils.isEmpty(code)) {
			spListType = SPListTypeLocalServiceUtil.fetchSPListType(Long.parseLong(code));
		} else {
			spListType = replaceItemValue(column, code, themeDisplay);
		}
		return spListType;
	}

	private void replaceCustomColumns(JSONObject contentJson, String[] customColumns, ThemeDisplay themeDisplay,
			ResourceRequest resourceRequest) {
		try {
			for (String column : customColumns) {
				if (column.equalsIgnoreCase(PRODUCT_TYPE_SUBTYPE)) {
					SPListType pt = getSpListValue(PRODUCT_TYPE, contentJson, contentJson.getString(PRODUCT_TYPE),
							themeDisplay);
					SPListType pst = getSpListValue(PRODUCT_SUB_TYPE, contentJson,
							contentJson.getString(PRODUCT_SUB_TYPE), themeDisplay);
					if (pt != null && pst != null) {
						contentJson.put(column, pt.getDisplayName() + " - " + pst.getDisplayName());
					}
				} else if (column.equalsIgnoreCase(ID_NAME)) {
					String code = contentJson.getString(NAME_OF_PAYER);
					HttpServletRequest request = ((LiferayPortletRequest) resourceRequest).getHttpServletRequest();
					Map<Long, String> typeMap = getSpListTypeIdToDisplayName("finance.accountingtable.clienttype",
							request);
					String ct = typeMap.get(Long.parseLong(contentJson.getString("Type")));
					String userName = getUserName(code, ct);
					contentJson.put(column, "[" + code + "] " + userName);
					contentJson.put(USER_ID, code);
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private String getUserName(String userId, String type) throws SystemException, PortalException {
		try {
			if (!StringUtils.isEmpty(userId)) {
				if (type != null && type.equals("Corporate")) {
					com.sambaash.platform.srv.startupprofile.model.Organization organization = OrganizationLocalServiceUtil
							.fetchOrganization(Long.parseLong(userId));
					if (organization != null) {
						return organization.getName();
					}
				} else {
					User user = UserLocalServiceUtil.getUserById(Long.parseLong(userId));
					if (user != null) {
						return user.getFirstName() + " " + user.getLastName();
					}
				}
			}
		} catch (NoSuchUserException ex) {
			_log.error(ex.getMessage());
		}
		return userId;
	}

	private void replaceUserName(JSONObject contentJson, String column, String code)
			throws SystemException, PortalException {
		String ct = contentJson.getString("Type");
		String catType = contentJson.getString(CATEGORY_TYPE);
		if (catType.equals("Receipt")) {
			JSONArray payments = contentJson.getJSONArray("PaymentDetails");
			String payerName = payments.getJSONObject(0).getString("payerName");
			contentJson.put(column, payerName);
		} else {
			contentJson.put(column, getUserName(code, ct));
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
				
				JSONArray newFilter = JSONFactoryUtil.createJSONArray();
				
				String page = jsonModelData.getString("page");
				JSONArray conditions = jsonModelData.getJSONArray(CONDITIONS);
				JSONArray filters = jsonModelData.getJSONArray("filterdata");
				JSONArray sortArray = jsonModelData.getJSONArray("sortby");
				String indetail = jsonModelData.getString("indetail");
				String subUrl = model + ELASTIC_SEARCH + PAGE_EQUAL + page + restUriSize + limit;
				JSONObject jsonElasticSearchQuery = JSONFactoryUtil.createJSONObject();
				prepareConditions(conditions, jsonElasticSearchQuery);
				prepareFilters(filters, resourceRequest, jsonElasticSearchQuery, newFilter, model);
				if (sortArray != null && sortArray.length() > 0) {
					jsonElasticSearchQuery.put("sortby", sortArray);
				}
				saveCurrentQuery(jsonElasticSearchQuery.toString(), resourceRequest);
				_log.debug("Posting with requestbody" + jsonElasticSearchQuery.toString());
				response = new APICall(resourceRequest).postForObject(jsonElasticSearchQuery.toString(), subUrl);
				if ((StringUtils.isEmpty(indetail) || indetail.equals("true"))  && modelToColumnMap.get(model.toLowerCase()) != null) {
					response = setSPListTypeDecriptions(resourceRequest, response, model);
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
	
	public String searchAdmissionRecords(ResourceRequest resourceRequest, String[] transactionCodes) {
		String response = null;
		try {
			String limit = ""+Integer.MAX_VALUE;
			String model = "atoadmission";
			String page = "0";
			String subUrl = model + ELASTIC_SEARCH + PAGE_EQUAL + page + restUriSize + limit;
			JSONObject jsonElasticSearchQuery = JSONFactoryUtil.createJSONObject();
			JSONArray filters = JSONFactoryUtil.createJSONArray();
			JSONObject filter = JSONFactoryUtil.createJSONObject();
			JSONArray codes = JSONFactoryUtil.createJSONArray();
			for(String code : transactionCodes) {
				codes.put(code);
			}
			filter.put("contentJson.InvoiceId", codes);
			filters.put(filter);
			jsonElasticSearchQuery.put(FILTERS, filters);
			_log.info("jsonElasticSearchQuery : "+jsonElasticSearchQuery.toString());
			response = new APICall(resourceRequest).postForObject(jsonElasticSearchQuery.toString(), subUrl);
			_log.info("response : "+response);
		} catch (Exception e) {
			_log.error(e);
			response = ERROR;
		}
		return response;
	}

	private void prepareConditions(JSONArray conditions, JSONObject jsonElasticSearchQuery) {
		if (conditions != null && conditions.length() > 0) {
			jsonElasticSearchQuery.put(CONDITIONS, conditions);
		}
	}

	private void prepareFilters(JSONArray filters, ResourceRequest resourceRequest, JSONObject jsonElasticSearchQuery,
			JSONArray newFilter, String model) throws JSONException {
		String catType = resourceRequest.getPreferences().getValue(FinanceConstants.PREF_CATEGORY_TYPE, "");
		if (filters == null) {
			filters = JSONFactoryUtil.createJSONArray();
		}
		if (newFilter == null) {
			newFilter = JSONFactoryUtil.createJSONArray();
		}
		HttpServletRequest request = ((LiferayPortletRequest) resourceRequest).getHttpServletRequest();
		String catId = getCategoryMap(request).get(catType);
		if (catId != null && TRANSACTION_MODEL.equalsIgnoreCase(model)) {
			filters.put(JSONFactoryUtil.createJSONObject("{\"contentJson.CategoryType\":[\"" + catId + "\"]}"));
		}
		jsonElasticSearchQuery.put(FILTERS, filters);
		jsonElasticSearchQuery.put("newFilter", newFilter);
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
			String subUrl = model + "/search?" + condition + PAGE_EQUAL + page + restUriSize + limit + "&" + sort + "="
					+ sortByField;

			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			if (modelToColumnMap.get(model.toLowerCase()) != null) {
				response = setSPListTypeDecriptions(resourceRequest, response, model);
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
			_log.debug(subUrl);

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
			
			String columnTitles = getMicroserviceModelColumnTitleMapNew(resourceRequest, modelNameMicroService);
			JSONArray allModelColumnTitlesArray = JSONFactoryUtil.createJSONArray(columnTitles);
			JSONObject distinct = JSONFactoryUtil.createJSONObject(response);
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			JSONArray datepicker = JSONFactoryUtil.createJSONArray();
			JSONObject titles = JSONFactoryUtil.createJSONObject();
			JSONArray titles1 = JSONFactoryUtil.createJSONArray();
			JSONArray distinctCreatedBy = distinct.getJSONArray(CREATED_BY);
			JSONArray distinctModifiedBy = distinct.getJSONArray(LAST_MODIFIED_BY);
			JSONObject distinctContentJson = distinct.getJSONObject(CONTENT_JSON);
			JSONArray distinctNameOfPayer = distinctContentJson.getJSONArray(NAME_OF_PAYER);

			List<String> modifiedBy = new ArrayList<>();
			for (int i = 0; i < distinctModifiedBy.length(); i++) {
				modifiedBy.add(distinctModifiedBy.getString(i));

			}
			for (int i = 0; i < distinctCreatedBy.length(); i++) {
				if (!modifiedBy.contains(distinctCreatedBy.getString(i))) {
					distinctModifiedBy.put(distinctCreatedBy.getString(i));
				}

			}
			if(distinctNameOfPayer!=null) {
				for (int i = 0; i < distinctNameOfPayer.length(); i++) {
					distinctModifiedBy.put(distinctNameOfPayer.getString(i));
	
				}
			}

			DynamicQuery studentINOperator = DynamicQueryFactoryUtil.forClass(User.class,
					PortletClassLoaderUtil.getClassLoader());
			Criterion criterion6 = null;
			ArrayList<Long> list = new ArrayList<>();
			processModifiedBy(distinctModifiedBy, list);
			JSONArray usersInfo = JSONFactoryUtil.createJSONArray();
			JSONObject userInfo;
			if (!list.isEmpty()) {
				criterion6 = RestrictionsFactoryUtil.in("userId", list);
				criterion6 = RestrictionsFactoryUtil.and(criterion6,
						RestrictionsFactoryUtil.eq(status, new Integer("0")));
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
				_log.info("datepicker: " + datePickerColumn);
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
			_log.debug("obj : " + obj.toString());
			return obj.toString();
		} catch (Exception e) {
			_log.error("getFilterColumnHeader exception: " + e);
			response = ERROR;
		}
		return response;
	}

	private void processModifiedBy(JSONArray distinctModifiedBy, ArrayList<Long> list) {
		for (int i = 0; i < distinctModifiedBy.length(); i++) {
			try {
				if (!distinctModifiedBy.getString(i).equalsIgnoreCase(null)) {
					list.add(Long.valueOf(distinctModifiedBy.getString(i)));
				}
			} catch (Exception e) {
				_log.error(e.getMessage());
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
			_log.debug("ExportList Exportquery BEFORE THE CALL === " + jsonExportQuery.toString());
			if (storageId != null) {
				JSONArray nn = JSONFactoryUtil.createJSONArray("[{'storageId':['" + storageId + "']}]");
				jsonExportQuery.getJSONObject("elasticsearch").put(FILTERS, nn);
			}
			int totalsize = jsonExportQuery.getInt(TOTAL_ELEMENTS);
			String subUrl = restmodel + "/global/exportData?page=0&size=" + totalsize;
			JSONObject jsonTitleOrder = getTitleOrder(resourceRequest, model);
			jsonExportQuery.put(TITLES, jsonTitleOrder.getJSONObject(TITLES));
			jsonExportQuery.put(ORDER, jsonTitleOrder.getJSONArray(ORDER));
			_log.debug("ExportList Exportquery" + jsonExportQuery.toString());
			new APICall(resourceRequest).downloadObjects(jsonExportQuery.toString(), subUrl, HttpMethod.POST,
					resourceRequest, resourceResponse);
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	public String exportPaymentAdvicePdf(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = "";
		try {
			String model = resourceRequest.getParameter(formType);
			String restmodel = model.toLowerCase();
			PortletSession session = resourceRequest.getPortletSession();
			String exportquery = (String) session.getAttribute(SESSION_EXPORTQUERY, PortletSession.PORTLET_SCOPE);
			JSONObject jsonExportQuery = JSONFactoryUtil.createJSONObject(exportquery);
			int totalsize = jsonExportQuery.getInt(TOTAL_ELEMENTS);
			JSONObject jsonTitleOrder = getTitleOrder(resourceRequest, model);
			jsonExportQuery.put(TITLES, jsonTitleOrder.getJSONObject(TITLES));
			jsonExportQuery.put(ORDER, jsonTitleOrder.getJSONArray(ORDER));
			String categoryMap = resourceRequest.getParameter("categoryMap");
			if (StringUtils.isEmpty(categoryMap)) {
				categoryMap = JSONFactoryUtil.createJSONObject(resourceRequest.getParameter("data"))
						.getString("categoryMap");
			}
			jsonExportQuery.put("categoryMap", categoryMap);
			String productSubtypeMap = resourceRequest.getParameter("productSubtypeMap");
			if (StringUtils.isEmpty(productSubtypeMap)) {
				productSubtypeMap = JSONFactoryUtil.createJSONObject(resourceRequest.getParameter("data"))
						.getString("productSubtypeMap");
			}
			jsonExportQuery.put("productSubtypeMap", productSubtypeMap);
			String type = resourceRequest.getParameter("type");
			if (StringUtils.isEmpty(type)) {
				type = JSONFactoryUtil.createJSONObject(resourceRequest.getParameter("data"))
						.getString("type");
			}
			jsonExportQuery.put("type", type);
			String claimMap = resourceRequest.getParameter("claimMap");
			if (StringUtils.isEmpty(claimMap)) {
				claimMap = JSONFactoryUtil.createJSONObject(resourceRequest.getParameter("data"))
						.getString("claimMap");
			}
			jsonExportQuery.put("claimMap", claimMap);
			String subUrl = restmodel + "/exportPaymentAdvicePdf?page=0&size=" + totalsize;
			_log.debug("subUrl === " + subUrl);                                          
			return new APICall(resourceRequest).preparePdf(jsonExportQuery.toString(), subUrl, HttpMethod.POST,
					resourceResponse);
			
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}
	
	public void exportPaymentAdviceExcel(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = "";
		try {
			String model = resourceRequest.getParameter(formType);
			String restmodel = model.toLowerCase();
			PortletSession session = resourceRequest.getPortletSession();
			String exportquery = (String) session.getAttribute(SESSION_EXPORTQUERY, PortletSession.PORTLET_SCOPE);
			JSONObject jsonExportQuery = JSONFactoryUtil.createJSONObject(exportquery);
			int totalsize = jsonExportQuery.getInt(TOTAL_ELEMENTS);
			JSONObject jsonTitleOrder = getTitleOrder(resourceRequest, model);
			jsonExportQuery.put(TITLES, jsonTitleOrder.getJSONObject(TITLES));
			jsonExportQuery.put(ORDER, jsonTitleOrder.getJSONArray(ORDER));
			String categoryMap = resourceRequest.getParameter("categoryMap");
			if (StringUtils.isEmpty(categoryMap)) {
				categoryMap = JSONFactoryUtil.createJSONObject(resourceRequest.getParameter("data"))
						.getString("categoryMap");
			}
			jsonExportQuery.put("categoryMap", categoryMap);		
			
			String subUrl = restmodel + "/exportPaymentAdviceExcel?page=0&size=" + totalsize;
			_log.debug("subUrl === " + subUrl);                                          
			new APICall(resourceRequest).downloadObjectPaymentAdvice(jsonExportQuery.toString(), subUrl, HttpMethod.POST,
					resourceResponse);
			
		} catch (Exception e) {
			_log.error(e);
		}
		//return response;
	}
	
	public void exportRowToExcelFile(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			_log.debug("exportRowToExcelFile invoked");
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
		List<String> columnsList1 = SystemLocalServiceUtil.getMicroserviceModelColumnList(resourceRequest, modelName);
		for (String column : columnsList1) {
			//order.put(CONTENT_JSON_PREFIX + column);
			_log.info("order:" + column);
		}
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
			// TODO Auto-generated catch block
			_log.error(e);
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
		String navigation = FetchLocalServiceUtil.fetchRecord("1", "Navigation", themeDisplay.getUserId(),
				getScopeGroupId(themeDisplay.getScopeGroupId()));
		String response = FetchLocalServiceUtil.getAllRecord("childnavigation", themeDisplay.getUserId(),
				getScopeGroupId(themeDisplay.getScopeGroupId()));
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
			APICall apiCall = new APICall(SambaashUtil.getAdminUserId(), scopeGroupId);
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

	private String populateBasicDetails(long scopeGroupId, JSONObject jsonObj, String userType) throws SystemException {
		List<SPListType> utSpListTypeList = SPListTypeLocalServiceUtil.getByKey("finance.accountingtable.clienttype",
				scopeGroupId);
		SPListType utSpListType = getSpListTypeByDisplayName(userType, utSpListTypeList);
		if (utSpListType != null) {
			jsonObj.put("UserType", utSpListType.getSpListTypeId());
		} else {
			return "Invalid user type entered !!";
		}
		return null;
	}

	private String populateBasicDetails(long scopeGroupId, JSONObject jsonObj, String productType,
			String productSubType, String functionalComponent, String categoryType, String clientType)
			throws SystemException {
		List<SPListType> ptSpListTypeList = SPListTypeLocalServiceUtil.getByKey("finance.accountingtable.productype",
				scopeGroupId);
		List<SPListType> pstSpListTypeList = SPListTypeLocalServiceUtil
				.getByKey(String.format("finance.accountingtable.%s.producsubtype",productType).toLowerCase(), scopeGroupId);
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
			String componentRefNumber, String txnType, String title, String description, String dueDate,
			String valueDate, String creditDate, String transactionDetailJson, String paymentDetailJson) {
		String errorMsg = "";
		try {
			_log.debug("1.saveTransactionData");
			APICall apiCall = new APICall(SambaashUtil.getAdminUserId(), scopeGroupId);
			String subUrl = "invoicing/new";
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
			errorMsg = populateBasicDetails(scopeGroupId, jsonObj, productType, productSubType, functionalComponent,
					categoryType, clientType);
			if (errorMsg != null) {
				return errorMsg;
			}
			jsonObj.put("TransactionMasterCode", "TMC-" + new Date().getTime());
			jsonObj.put("RequestType", "New Invoice");
			if (categoryType.equalsIgnoreCase("receipt") || categoryType.equalsIgnoreCase("credit notes")) {
				jsonObj.put("ApprovalStatus", "Approved");
				jsonObj.put("TransactionStatus", "Confirmed");
			}
			jsonObj.put("TxnDate", txnDate);
			jsonObj.put("Source", source);
			jsonObj.put("TxnType", txnType);
			jsonObj.put("Title", title);
			jsonObj.put("ComponentRefNumber", componentRefNumber);
			jsonObj.put("Description", description);
			jsonObj.put("DueDate", dueDate);
			jsonObj.put("ValueDate", valueDate);
			jsonObj.put("CreditDate", creditDate);
			_log.debug("1.saveTransactionData");
			jsonObj.put("TransactionDetails", JSONFactoryUtil.createJSONArray(transactionDetailJson));
			jsonObj.put("PaymentDetails", JSONFactoryUtil.createJSONArray(paymentDetailJson));
			JSONObject mainObj = JSONFactoryUtil.createJSONObject();
			mainObj.put(CONTENT_JSON, jsonObj);
			_log.debug("mainObj : " + mainObj.toString());
			apiCall.postForObject(mainObj.toString(), subUrl);
			return "success";
		} catch (Exception e) {
			_log.error(e);
		}
		return ERROR;
	}

	public String saveCreditBalance(long scopeGroupId, Long creditBalanceAmt, String status, String usereId,
			String userName, String userType) {
		String errorMsg = "";
		try {
			_log.debug("1.saveCreditBalance");
			APICall apiCall = new APICall(SambaashUtil.getAdminUserId(), scopeGroupId);
			String subUrl = "creditbalance/new";
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
			errorMsg = populateBasicDetails(scopeGroupId, jsonObj, userType);
			if (errorMsg != null) {
				return errorMsg;
			}
			jsonObj.put("CreditBalanceCode", "CBC-" + new Date().getTime());
			jsonObj.put("CreditBalanceAmt", creditBalanceAmt);
			jsonObj.put("Amount", creditBalanceAmt);
			jsonObj.put("Status", status);
			jsonObj.put("Type", "Credit Balance");
			jsonObj.put(USER_ID, usereId);
			jsonObj.put("UserName", userName);

			JSONObject mainObj = JSONFactoryUtil.createJSONObject();
			mainObj.put(CONTENT_JSON, jsonObj);
			_log.debug("jsonObj-- : " + jsonObj.toString());
			apiCall.postForObject(mainObj.toString(), subUrl);
			return "success";
		} catch (Exception e) {
			_log.error(e);
		}
		return ERROR;
	}

	public boolean checkRole(HttpServletRequest request, String role) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		try {
			return RoleServiceUtil.hasUserRoles(userId, themeDisplay.getCompanyId(),
					new String[] { role, ADMINISTRATOR }, true);
		} catch (PortalException | SystemException e) {
			_log.error(e);
			return false;
		}
	}

	public void downloadPdfFromServer(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String filePath = resourceRequest.getParameter("filePath");
		resourceResponse.setContentType("application/pdf");
		resourceResponse.addProperty(com.liferay.portal.kernel.servlet.HttpHeaders.CACHE_CONTROL, CACHE_CONTROL_PROP);
		try (OutputStream out = resourceResponse.getPortletOutputStream();
				InputStream in = new FileInputStream(new File(filePath))) {
			_log.debug("out " + out);
			_log.debug("================");
			IOUtils.copy(in, out);
			out.flush();
			resourceResponse.flushBuffer();
		} catch (final IOException e) {
			_log.error(e);
		}
	}

	public String preparePdf(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String data = resourceRequest.getParameter("data");
		return preparePdf(resourceRequest, resourceResponse, data);
	}
	
	public String preparePdf(ResourceRequest resourceRequest, ResourceResponse resourceResponse, String data) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			_log.debug("data : " + data);
			String pdfUrl = TRANSACTION_MODEL + "/exportpdf";
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(data);
			jsonObject.put("templateUrl", TEMPLATE_BUCKET_URL + themeDisplay.getSiteGroupId() + "/" + TRANSACTION_DOCUMENT + "model" + "/" + jsonObject.getString("templateUrl"));
			String innerData = jsonObject.getString("data");
			boolean preview = jsonObject.getBoolean("preview");
			jsonObject.put("data", JSONFactoryUtil.createJSONObject(innerData));
			jsonObject.put("preview", preview);
			_log.debug("jsonObject2 : " + jsonObject.toString());
			return new APICall(resourceRequest).preparePdf(jsonObject.toString(), pdfUrl, HttpMethod.POST,
					resourceResponse);
		} catch (Exception e) {
			_log.error(e);
		}
		return null;
	}

	public String prepareLorPdf(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			String data = resourceRequest.getParameter("data");
			JSONObject dataJsonObject = JSONFactoryUtil.createJSONObject(data);
			String storageId = dataJsonObject.getString("storageId");
			String printout = dataJsonObject.getString("printout");

			String subUrl;
			JSONObject lorJsonObj;
			JSONArray remarksJsonArrayObj = null;
			if (StringUtils.isEmpty(storageId)) {
				storageId = "null";
				String lorJsonString = dataJsonObject.getString("lorData");
				_log.debug("lorResponse : " + lorJsonString);
				lorJsonObj = JSONFactoryUtil.createJSONObject(lorJsonString);
				lorJsonObj.put("receiptIds", lorJsonObj.getString("ReceiptIds"));
			} else {
				// get lor
				subUrl = LOR_REPORT_MODEL + restUriGet + storageId;
				String existingLorData = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
				String lorResponse = convertToFormModel(existingLorData, LOR_REPORT_MODEL);
				lorJsonObj = JSONFactoryUtil.createJSONObject(lorResponse);

				// get remarks
				subUrl = REMARKS_MODEL + "/search?contentJson.ReferenceId=" + storageId;
				String remarksResponse = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
				JSONObject remarksJsonObj = JSONFactoryUtil.createJSONObject(remarksResponse);
				remarksJsonArrayObj = remarksJsonObj.getJSONArray(CONTENT);
			}

			// get receipts
			String receipts = lorJsonObj.getString("receiptIds");
			String inputString = "{'filters':[{'contentJson.TransactionMasterCode':[" + receipts + "]}]}";
			JSONObject receiptInput = JSONFactoryUtil.createJSONObject(inputString);
			subUrl = TRANSACTION_MODEL + ELASTIC_SEARCH + PAGE_EQUAL + "0" + restUriSize + Integer.MIN_VALUE;
			String receiptResponse = new APICall(resourceRequest).postForObject(receiptInput.toString(), subUrl);

			JSONObject receiptsJsonObj = JSONFactoryUtil.createJSONObject(receiptResponse);
			JSONArray receiptsJsonArrayObj = receiptsJsonObj.getJSONArray(CONTENT);

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			JSONObject userObj = JSONFactoryUtil.createJSONObject();
			JSONObject productsObj = JSONFactoryUtil.createJSONObject();
			JSONObject subProductsObj = JSONFactoryUtil.createJSONObject();
			String createdBy = lorJsonObj.getString(CREATED_BY);
			if (!StringUtils.isEmpty(createdBy)) {
				userObj.put(createdBy, getUserName(createdBy, ""));
			}

			if (remarksJsonArrayObj != null) {
				for (int i = 0; i < remarksJsonArrayObj.length(); i++) {
					JSONObject record = remarksJsonArrayObj.getJSONObject(i);
					createdBy = record.getString(CREATED_BY);
					userObj.put(createdBy, getUserName(createdBy, ""));
				}
			}
			HttpServletRequest request = ((LiferayPortletRequest) resourceRequest).getHttpServletRequest();
			Map<Long, String> productMap = getSpListTypeIdToDisplayName("finance.accountingtable.productype", request);
			Map<Long, String> typeMap = getSpListTypeIdToDisplayName("finance.accountingtable.clienttype", request);
			for (int i = 0; i < receiptsJsonArrayObj.length(); i++) {
				JSONObject record = receiptsJsonArrayObj.getJSONObject(i);
				JSONObject contentJson = record.getJSONObject(CONTENT_JSON);
				String type = typeMap.get(Long.parseLong(contentJson.getString("Type")));
				try {
					createdBy = contentJson.getString(NAME_OF_PAYER);
					userObj.put(createdBy, getUserName(createdBy, type));
				} catch (Exception e) {
					_log.error(e);
				}
				String pid = contentJson.getString(PRODUCT_TYPE);
				productsObj.put(pid, productMap.get(Long.parseLong(pid)));
				
				Map<Long, String> subProductMap = getSpListTypeIdToDisplayName("finance.accountingtable."
				            +productMap.get(Long.parseLong(pid)).toLowerCase()+".producsubtype", request);
				for(Entry<Long, String> entry : subProductMap.entrySet()) {
				    subProductsObj.put(entry.getKey().toString(), entry.getValue());
				}
			}
			jsonObject.put("users", userObj);
			jsonObject.put("products", productsObj);
			jsonObject.put("subProducts", subProductsObj);
			jsonObject.put("printout", printout);
			jsonObject.put("lorReportDto", lorJsonObj);
			String pdfUrl = LOR_REPORT_MODEL + "/exportpdf/" + storageId;
			_log.debug("jsonObject2 : " + jsonObject.toString());
			return new APICall(resourceRequest).preparePdf(jsonObject.toString(), pdfUrl, HttpMethod.POST,
					resourceResponse);
		} catch (Exception e) {
			_log.error(e);
		}
		return null;
	}

	private void sendReceiptNotification(ResourceRequest resourceRequest, String action, String storageId,
			String receiptNumber) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(resourceRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<Long> userIds = new ArrayList<>();
		JSONObject notificationData = JSONFactoryUtil.createJSONObject();
		switch (action) {
		case VOID:
			notificationData.put(FinanceConstants.NOTIFICATION_TYPE, FinanceConstants.NOTIFICATION_TYPE_VOID_RECEIPT);
			long[] approverIds = UserLocalServiceUtil.getRoleUserIds(RoleServiceUtil
					.getRole(themeDisplay.getCompanyId(), FinanceConstants.FINANCE_APPROVER_ROLE).getRoleId());
			userIds.addAll(Arrays.asList(ArrayUtils.toObject(approverIds)));
			break;
		case CANCEL:
			notificationData.put(FinanceConstants.NOTIFICATION_TYPE, FinanceConstants.NOTIFICATION_TYPE_CANCEL_RECEIPT);
			approverIds = UserLocalServiceUtil.getRoleUserIds(RoleServiceUtil
					.getRole(themeDisplay.getCompanyId(), FinanceConstants.FINANCE_APPROVER_ROLE).getRoleId());
			userIds.addAll(Arrays.asList(ArrayUtils.toObject(approverIds)));
			break;
		case RETURN:
			notificationData.put(FinanceConstants.NOTIFICATION_TYPE, FinanceConstants.NOTIFICATION_TYPE_RETURN_RECEIPT);
			JSONObject remarkData = getLatestRemark(storageId, resourceRequest);
			if (remarkData != null && remarkData.getString(CREATED_BY) != null) {
				long userId = Long.parseLong(remarkData.getString(CREATED_BY));
				userIds.add(userId);
			} else {
				_log.error("no remarks found");
				return;
			}
			break;
		default:
			return;
		}

		String baseUrl = resourceRequest.getPreferences().getValue("baseUrlPref", "");

		notificationData.put(FinanceConstants.NOTIFICATION_LINK,
				baseUrl + "?" + "p_p_id=transaction_WAR_SPFinanceportlet&p_p_lifecycle=0&"
						+ "p_p_state=normal&_transaction_WAR_SPFinanceportlet_jspPage=%2Fhtml%2Ftransaction%2Fview.jsp&"
						+ "_transaction_WAR_SPFinanceportlet_formTypeName=" + TRANSACTION_MODEL
						+ "&_transaction_WAR_SPFinanceportlet_storageId=" + storageId);
		notificationData.put(FinanceConstants.NOTIFICATION_RECEIPT_NUMBER, receiptNumber);
		notificationData.put(FinanceConstants.NOTIFICATION_TITLE, "RECEIPT HISTORY");
		for (long userId : userIds) {
			UserNotificationEventLocalServiceUtil.addUserNotificationEvent(userId,
					FinanceConstants.RECEIPT_NOTIFICATION, (new Date()).getTime(), userId, notificationData.toString(),
					false, serviceContext);
		}
	}

	private JSONObject getLatestRemark(String storageId, ResourceRequest resourceRequest) throws JSONException {
		String response = null;
		String existingData = null;
		try {
			_log.debug("storageId : " + storageId);
			String subUrl = REMARKS_MODEL.toLowerCase() + "/fetchLatestRemark/" + storageId;
			existingData = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			response = convertToFormModel(existingData, REMARKS_MODEL);
		} catch (Exception e) {
			_log.error(e);
			response = e.toString();
		}
		return JSONFactoryUtil.createJSONObject(response);
	}

	public String processRecord(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = "";
		try {
			String data = resourceRequest.getParameter("data");
			JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(data);
			String storageId = jsonModelData.getString(FORMSTORAGEID);
			String action = jsonModelData.getString("action");
			String reason = jsonModelData.getString("reason");
			String categoryType = jsonModelData.getString("categoryType");
			String creditToBalance = jsonModelData.getString("creditToBalance");
			String categoryMap = jsonModelData.getString(CATEGORY_MAP);
			String model = jsonModelData.getString(formType).toLowerCase();
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("action", action);
			jsonObject.put("reason", reason);
			jsonObject.put("creditToBalance", creditToBalance);
			jsonObject.put(CATEGORY_MAP, JSONFactoryUtil.createJSONObject(categoryMap));

			if (jsonModelData.has("valueDate")) {
				jsonObject.put("valueDate", jsonModelData.getString("valueDate"));
			}
			if (jsonModelData.has("creditDate")) {
				jsonObject.put("creditDate", jsonModelData.getString("creditDate"));
			}
			if (jsonModelData.has("paymentSetCode")) {
				jsonObject.put("paymentSetCode", jsonModelData.getString("paymentSetCode"));
			}
			URI uriStorageId = URI.create(storageId);
			String subUrl = model + "/process/" + uriStorageId;
			response = new APICall(resourceRequest).postForObject(jsonObject.toString(), subUrl);
			if (!response.equals("server error") && categoryType != null && categoryType.equals(RECEIPT_CODE)) {
				_log.debug("response : " + response);
				JSONObject respObj = JSONFactoryUtil.createJSONObject(response);
				_log.debug("ExtRefNumber : " + respObj.getJSONObject(CONTENT_JSON).getString("ExtRefNumber"));
				sendReceiptNotification(resourceRequest, action, storageId,
						respObj.getJSONObject(CONTENT_JSON).getString("ExtRefNumber"));
			}
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}

	public String processWorkFlow(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = "";
		try {
			String modeldata = resourceRequest.getParameter("processDto");
			_log.debug("creating data" + modeldata);
			if (StringUtils.isEmpty(modeldata)) {
				modeldata = JSONFactoryUtil.createJSONObject(resourceRequest.getParameter("data"))
						.getString("processDto");
			}
			if (StringUtils.isEmpty(modeldata)) {
				String data = resourceRequest.getParameter("data");
				JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(data);
				String storageId = jsonModelData.getString(FORMSTORAGEID);
				String workFlowStatus = jsonModelData.getString("workFlowStatus");
				String approvalStatus = jsonModelData.getString("approvalStatus");
				String remark = jsonModelData.getString("remark");
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("storageId", storageId);
				jsonObject.put("workFlowStatus", workFlowStatus);
				jsonObject.put("approvalStatus", approvalStatus);
				jsonObject.put("remark", remark);
				jsonObject.put("ModelName", jsonModelData.getString(formType));
				modeldata = jsonObject.toString();
			} else {
				JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(modeldata);
				String categoryMap = jsonModelData.getString(CATEGORY_MAP);
				String clientTypeMap = jsonModelData.getString("clientTypeMap");
				jsonModelData.put(CATEGORY_MAP, JSONFactoryUtil.createJSONObject(categoryMap));
				jsonModelData.put("clientTypeMap", JSONFactoryUtil.createJSONObject(clientTypeMap));
				jsonModelData.put("ModelName", jsonModelData.getString(formType));
				modeldata = jsonModelData.toString();
			}
			_log.debug("model data is " + modeldata);
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + "/process";
			response = new APICall(resourceRequest).postForObject(modeldata, subUrl);
			if (!response.equals("server error") && model.equals(SUBMITTED_CLAIM_MODEL)) {
				sendSubmittedClaimNotifications(resourceRequest, modeldata, response);
			}
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}

	public String generateReport(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		
		String response = "";
		try {
			String modeldata = resourceRequest.getParameter("reportDto");
			_log.debug("creating data" + modeldata);
			if (StringUtils.isEmpty(modeldata)) {
				modeldata = JSONFactoryUtil.createJSONObject(resourceRequest.getParameter("data"))
						.getString("reportDto");
			}
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + "/getReport";
			//response = new APICall(resourceRequest).postForObject(modeldata, subUrl);
			return new APICall(resourceRequest).preparePdf(modeldata, subUrl, HttpMethod.POST,
					resourceResponse);
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
		
	}
		
	public void generateReportZip(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		
			try {
				String modeldata = resourceRequest.getParameter("reportDto");
				_log.debug("creating data" + modeldata);
				if (StringUtils.isEmpty(modeldata)) {
					modeldata = JSONFactoryUtil.createJSONObject(resourceRequest.getParameter("data"))
							.getString("reportDto");
				}
				String model = resourceRequest.getParameter(formType).toLowerCase();
				String subUrl = model + "/getReportZip";

				new APICall(resourceRequest).downloadPdfZip(modeldata, subUrl, HttpMethod.POST,
						resourceResponse);
			} catch (Exception e) {
				_log.error(e);
			}
		
	}

	public Map<String, String> getCategoryMap(HttpServletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		return getCategoryMap(themeDisplay.getScopeGroupId());
	}

	public Map<String, String> getCategoryMap(long scopeId) {
		Map<String, String> categoryMap = new HashMap<>();
		try {
			List<SPListType> spListTypeList = SPListTypeLocalServiceUtil
					.getByKey("finance.referencenumber.categorytype", scopeId);
			for (SPListType spListType : spListTypeList) {
				categoryMap.put(spListType.getItemValue(), String.valueOf(spListType.getSpListTypeId()));
			}
		} catch (SystemException e) {
			_log.error(e);
		}
		return categoryMap;
	}
	
	public Map<String, String> getClaimMap(HttpServletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Map<String, String> map = new HashMap<>();
		try {
			List<SPListType> spListTypeList = SPListTypeLocalServiceUtil
					.getByKey("finance.payment.claimType", themeDisplay.getScopeGroupId());
			for (SPListType spListType : spListTypeList) {
				map.put(spListType.getDisplayName(), String.valueOf(spListType.getSpListTypeId()));
			}
		} catch (SystemException e) {
			_log.error(e);
		}
		return map;
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

	public Map<String, String> getFunctionalComponentDisplayMap(HttpServletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Map<String, String> map = new HashMap<>();
		try {
			List<SPListType> spListTypeList = SPListTypeLocalServiceUtil.getByKey(FUNC_COMP_KEY,
					themeDisplay.getScopeGroupId());
			for (SPListType spListType : spListTypeList) {
				map.put(spListType.getDisplayName(), spListType.getItemValue());
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
			List<SPListType> spListTypeList = SPListTypeLocalServiceUtil.getByKey("finance.accountingtable.productype",
					themeDisplay.getScopeGroupId());
			for (SPListType spListType : spListTypeList) {
				List<SPListType> list = SPListTypeLocalServiceUtil
						.getByKey("finance.accountingtable."+spListType.getItemValue().toLowerCase()+".producsubtype", themeDisplay.getScopeGroupId());
				for (SPListType subType : list) {
					map.put(subType.getItemValue(), String.valueOf(subType.getSpListTypeId()));
				}
			}
		} catch (SystemException e) {
			_log.error(e);
		}
		return map;
	}

	public Map<String, String> getSpListTypeMap(String key, HttpServletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Map<String, String> map = new HashMap<>();
		try {
			List<SPListType> spListTypeList = SPListTypeLocalServiceUtil.getByKey(key, themeDisplay.getScopeGroupId());
			for (SPListType spListType : spListTypeList) {
				map.put(spListType.getItemValue(), String.valueOf(spListType.getSpListTypeId()));
			}
		} catch (SystemException e) {
			_log.error(e);
		}
		return map;
	}

	public Map<Long, String> getSpListTypeIdToDisplayName(String key, HttpServletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Map<Long, String> map = new HashMap<>();
		try {
			List<SPListType> spListTypeList = SPListTypeLocalServiceUtil.getByKey(key, themeDisplay.getScopeGroupId());
			for (SPListType spListType : spListTypeList) {
				map.put(spListType.getSpListTypeId(), spListType.getDisplayName());
			}
		} catch (SystemException e) {
			_log.error(e);
		}
		return map;
	}

	public String stripeCharge(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = "";
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long scopeGroupId = themeDisplay.getScopeGroupId();
			
			String data = resourceRequest.getParameter("data");
			JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(data);
			String stripeToken = jsonModelData.getString("stripeToken");
			String stripeAPIKey = SambaashUtil.getParameter("stripe.secret.key", themeDisplay.getScopeGroupId());
			_log.debug("stripeAPIKey " + stripeAPIKey);
			String description = jsonModelData.getString("description");
			String amount = jsonModelData.getString("amount");
			String currency = jsonModelData.getString("currency");
			String stripeEmail = jsonModelData.getString("stripeEmail");
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("stripeAPIKey", stripeAPIKey);
			jsonObject.put("stripeToken", stripeToken);
			jsonObject.put("description", description);
			jsonObject.put("amount", amount);
			jsonObject.put("currency", currency);
			jsonObject.put("stripeEmail", stripeEmail);
			String subUrl = "/stripe/charge";
			response = new APICall(resourceRequest).postForObject(jsonObject.toString(), subUrl);
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}

	public String getWalletAmount(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = "";
		try {
			String data = resourceRequest.getParameter("data");
			JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(data);
			String clientType = jsonModelData.getString("clientType");
			HttpServletRequest request = ((LiferayPortletRequest) resourceRequest).getHttpServletRequest();
			JSONObject catObj = JSONFactoryUtil
					.createJSONObject(new org.json.JSONObject(getCategoryMap(request)).toString());
			_log.debug("map : " + catObj.toString());
			catObj.put("IN", "155");
			String subUrl = "/" + TRANSACTION_MODEL + "/walletamount/" + clientType;
			response = new APICall(resourceRequest).postForObject(catObj.toString(), subUrl);
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}

	public String getWalletListing(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = null;
		try {
			String data = resourceRequest.getParameter("data");
			JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(data);
			String model = jsonModelData.getString(formType).toLowerCase();
			String page = jsonModelData.getString("page");
			String size = jsonModelData.getString("size");
			String statusVal = jsonModelData.getString(status);
			String categoryList = jsonModelData.getString("categoryList");
			String fromDate = jsonModelData.getString("fromDate");
			String toDate = jsonModelData.getString("toDate");
			JSONObject jdata = JSONFactoryUtil.createJSONObject();
			jdata.put(status, statusVal);
			jdata.put("categoryList", categoryList);
			jdata.put("fromDate", fromDate);
			jdata.put("toDate", toDate);
			String sortByField = "";
			if (!jsonModelData.getString(sortBy).equalsIgnoreCase("")) {
				sortByField = jsonModelData.getString(sortBy);
			}
			String subUrl = model + "/filter?page=" + page + restUriSize + size + "&" + sort + "=" + sortByField;
			_log.debug(subUrl);
			_log.debug(jdata.toString());
			response = new APICall(resourceRequest).postForObject(jdata.toString(), subUrl);
			_log.debug(response);
		} catch (Exception e) {
			_log.error(e);
			response = ERROR;
		}
		return response;

	}

	public String autoCloseCounter() {
		String response = "";
		try {
			String subUrl = "cashiercounter/autoclose";
			response = new APICall(SambaashUtil.getAdminUserId(), 0).postForObject(null, subUrl);
		} catch (Exception e) {
			_log.error(e);
			return ERROR;
		}
		return response;
	}

	public String generateLorReport(String groupIds) {
		String response = "";
		try {
			SPParameter baseCurrencyParameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(0,
					"base_currency");
			Map<String, String> categoryMap = getCategoryMap(0);
			String categoryId = categoryMap.get("RE");
			String currencyCode = baseCurrencyParameter.getValue();
			String division = "Examination Bureau";
			String subUrl = "lorreport/autogenerate?categoryId=" + categoryId + "&currencyCode=" + currencyCode
					+ "&division=" + division + "&siteIds=" + groupIds;
			response = new APICall(SambaashUtil.getAdminUserId(), 0).postForObject(null, subUrl);
		} catch (Exception e) {
			_log.error(e);
			return ERROR;
		}
		return response;
	}

	public String getGroupIds() {
		StringBuilder sb = new StringBuilder();
		String result = "";
		try {
			for (Group group : GroupUtil.findAll()) {
				if (group.getType() != 0) {
					sb.append(group.getGroupId()).append(",");
				}
			}
			result = sb.deleteCharAt(sb.length() - 1).toString();
		} catch (SystemException e) {
			_log.error(e);
		}
		return result;
	}

	public long getScopeGroupId(Long siteId) {
		try {
			String scopeGroupId = SambaashUtil.getParameter(SambaashConstants.SCOPE_GROUP_ID, siteId);
			if (Validator.isNumber(scopeGroupId)) {
				return Long.parseLong(scopeGroupId);
			}
		} catch (Exception e) {
			// return passed siteId
		}

		return siteId;

	}

	public String getUploadedFileUrl(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		_log.debug("reached to getUploadedFileUrl");
		String respData = null;
		try {
			String data = resourceRequest.getParameter("data");
			_log.debug("data : " + data);
			String model = resourceRequest.getParameter(formType);
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(data);
			String url = model.toLowerCase() + "/getFile?objectKey=" + jsonObject.getString("formType") + "/"
					+ jsonObject.getString("formStorageId") + ".pdf";
			_log.debug(url);

			respData = new APICall(resourceRequest).exchange(url, HttpMethod.GET);
		} catch (Exception e) {
			_log.error(e);
		}
		_log.debug("getUploadedFileUrl -> respData : " + respData);
		return respData;
	}

	public String prepareDccPdf(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {

			_log.debug("reached to prepareDccPdf");

			String data = resourceRequest.getParameter("data");
			JSONObject dataJsonObject = JSONFactoryUtil.createJSONObject(data);
			String storageId = dataJsonObject.getString("storageId");
			String printout = dataJsonObject.getString("printout");
			String templateUrl = dataJsonObject.getString("templateUrl");
			String subUrl;
			JSONObject dccJsonObj = null;
			JSONArray remarksJsonArrayObj = null;
			if (StringUtils.isNotEmpty(storageId)) {
				// get lor
				subUrl = DCC_REPORT_MODEL + restUriGet + storageId;
				String existingLorData = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
				String dccResponse = convertToFormModel(existingLorData, DCC_REPORT_MODEL);
				dccJsonObj = JSONFactoryUtil.createJSONObject(dccResponse);

			}
			// get remarks
			subUrl = REMARKS_MODEL + "/search?contentJson.ReferenceId=" + storageId;
			String remarksResponse = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			JSONObject remarksJsonObj = JSONFactoryUtil.createJSONObject(remarksResponse);
			remarksJsonArrayObj = remarksJsonObj.getJSONArray(CONTENT);

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			JSONObject userObj = JSONFactoryUtil.createJSONObject();
			String createdBy = dccJsonObj.getString(CREATED_BY);
			if (!StringUtils.isEmpty(createdBy)) {
				userObj.put(createdBy, getUserName(createdBy, ""));
			}

			JSONObject userInfo = JSONFactoryUtil.createJSONObject();
			Long submittedBy = dccJsonObj.getLong(DCC_SUBMITTED_BY);
			_log.debug("submittedBy : " + submittedBy);
			if (submittedBy != null && submittedBy > 0) {
				userInfo.put(DCC_SUBMITTED_BY, getUserInfo(submittedBy));
			}
			Long ackByAa = dccJsonObj.getLong(DCC_ACKNOWLEDGED_BY_AA);
			_log.debug("ackByAa : " + ackByAa);
			if (ackByAa != null && ackByAa > 0) {
				userInfo.put(DCC_ACKNOWLEDGED_BY_AA, getUserInfo(ackByAa));
			}
			Long ackByFnd = dccJsonObj.getLong(DCC_ACKNOWLEDGED_BY_FND);
			if (ackByFnd != null && ackByFnd > 0) {
				userInfo.put(DCC_ACKNOWLEDGED_BY_FND, getUserInfo(ackByFnd));
			}
			JSONObject remarkJsonObj = JSONFactoryUtil.createJSONObject();
			if (remarksJsonArrayObj != null) {
				for (int i = 0; i < remarksJsonArrayObj.length(); i++) {
					JSONObject record = remarksJsonArrayObj.getJSONObject(i);
					createdBy = record.getString(CREATED_BY);
					String remark = record.getString(REMARK);
					String approvalStatus = record.getString("approvalStatus");
					String createdAt = record.getString("modelId");
					JSONObject dccRemarks = JSONFactoryUtil.createJSONObject();
					dccRemarks.put("createdBy", createdBy);
					dccRemarks.put("remark", remark);
					if (submittedBy > 0 && String.valueOf(submittedBy).equals(createdBy)
							&& "Pending AA Acknowledgement".equals(approvalStatus)) {
						dccRemarks.put("title", "Submitter/Checker's Remarks");
					} else if (ackByAa > 0 && String.valueOf(ackByAa).equals(createdBy)
							&& "Pending FND Acknowledgement".equals(approvalStatus)) {
						dccRemarks.put("title", "AA Executer's Remarks");
					} else if (ackByFnd > 0 && String.valueOf(ackByFnd).equals(createdBy)
							&& "Acknowledged".equals(approvalStatus)) {
						dccRemarks.put("title", "Approver's Remarks");
					} else {
						dccRemarks.put("title", "Remark");
					}
					remarkJsonObj.put(createdAt, dccRemarks);
				}
			}
			jsonObject.put("userInfo", userInfo);
			jsonObject.put("printout", printout);
			jsonObject.put("dccReportDto", dccJsonObj);
			jsonObject.put("dccRemarks", remarkJsonObj);
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			jsonObject.put("templateUrl", TEMPLATE_BUCKET_URL + themeDisplay.getSiteGroupId() + "/" + TRANSACTION_DOCUMENT + "model" + "/" + templateUrl);

			String pdfUrl = DCC_REPORT_MODEL + "/exportpdf/" + storageId;
			_log.debug("jsonObject2 : " + jsonObject.toString());
			return new APICall(resourceRequest).preparePdf(jsonObject.toString(), pdfUrl, HttpMethod.POST,
					resourceResponse);
		} catch (Exception e) {
			_log.error(e);
		}
		return null;
	}

	private JSONObject getUserInfo(Long userId) throws PortalException, SystemException {
		JSONObject userInfo = JSONFactoryUtil.createJSONObject();
		try {
			if (userId != null) {
				User user = UserLocalServiceUtil.getUserById(userId);
				if (user != null) {
					userInfo.put("userId", String.valueOf(user.getUserId()));
					userInfo.put("name", user.getFirstName() + " " + user.getLastName());
					userInfo.put("designation", user.getJobTitle());
				}
			}
		} catch (NoSuchUserException ex) {
			_log.error(ex.getMessage());
		}
		return userInfo;
	}
	
	public boolean[] checkUserRoles(ThemeDisplay themeDisplay) {
		boolean[] roles = { false, false, false };
		try {
			String submitterRoles = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndName(themeDisplay.getCompanyId(), FinanceConstants.SUBMITTER_ROLE_PARAM)
					.getValue();
			String verifierRoles = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndName(themeDisplay.getCompanyId(), FinanceConstants.VERIFIER_ROLE_PARAM)
					.getValue();
			String approverRoles = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndName(themeDisplay.getCompanyId(), FinanceConstants.APPROVER_ROLE_PARAM)
					.getValue();
			_log.debug("submitterRoles : " + submitterRoles);
			_log.debug("verifierRoles : " + verifierRoles);
			_log.debug("approverRoles : " + approverRoles);
			if (RoleServiceUtil.hasUserRoles(themeDisplay.getUserId(), themeDisplay.getCompanyId(),
					submitterRoles.split(","), true)) {
				roles[0] = true;
			} else if (RoleServiceUtil.hasUserRoles(themeDisplay.getUserId(), themeDisplay.getCompanyId(),
					verifierRoles.split(","), true)) {
				roles[1] = true;
			} else if (RoleServiceUtil.hasUserRoles(themeDisplay.getUserId(), themeDisplay.getCompanyId(),
					approverRoles.split(","), true)) {
				roles[2] = true;
			}
		} catch (Exception e) {
			_log.error(e);
		}
		return roles;
	}

	public void handlePendingAmendmentsClaimNotification(boolean submitter, boolean verifier, boolean approver,
			User invigilatorUser, List<List<Object>> notifyData, ThemeDisplay themeDisplay, String ws) {
		if (submitter) {
			List<Object> data = new ArrayList<>();
			List<User> users = new ArrayList<>();
			users.add(invigilatorUser);
			data.add(users);
			data.add(true);
			data.add(FinanceConstants.SUBMIT_CLAIM_RFA_MAIL_TEMPLATE);
			data.add(true);
			notifyData.add(data);
		}
		if (verifier) {
			List<Object> data = new ArrayList<>();
			data.add(getUsersByRoles(themeDisplay, FinanceConstants.SUBMITTER_ROLE_PARAM));
			data.add(true);
			data.add(FinanceConstants.SUBMIT_CLAIM_SUBMITTER_MAIL_TEMPLATE);
			data.add(true);
			notifyData.add(data);
		}
		if (approver) {
			List<Object> data = new ArrayList<>();
			if (ws.equalsIgnoreCase(FinanceConstants.SUBMITTED_FOR_VERIFICATION)) {
				// return to verifier
				data.add(getUsersByRoles(themeDisplay, FinanceConstants.VERIFIER_ROLE_PARAM));
				data.add(true);
				data.add(FinanceConstants.SUBMIT_CLAIM_VERIFIER_MAIL_TEMPLATE);
				data.add(true);
			} else {
				// return to submitter
				data.add(getUsersByRoles(themeDisplay, FinanceConstants.SUBMITTER_ROLE_PARAM));
				data.add(true);
				data.add(FinanceConstants.SUBMIT_CLAIM_SUBMITTER_MAIL_TEMPLATE);
				data.add(true);
			}
			notifyData.add(data);
		}

	}

	public void handleRejectedClaimNotification(boolean submitter, boolean verifier, boolean approver,
			User invigilatorUser, List<List<Object>> notifyData, ThemeDisplay themeDisplay) {
		if (submitter) {
			// do nothing
		}
		if (verifier) {
			List<Object> data = new ArrayList<>();
			data.add(getUsersByRoles(themeDisplay, FinanceConstants.SUBMITTER_ROLE_PARAM));
			data.add(true);
			data.add(FinanceConstants.SUBMIT_CLAIM_SUBMITTER_MAIL_TEMPLATE);
			data.add(true);
			notifyData.add(data);
		}
		if (approver) {
			List<Object> data = new ArrayList<>();
			data.add(getUsersByRoles(themeDisplay, FinanceConstants.SUBMITTER_ROLE_PARAM));
			data.add(true);
			data.add(FinanceConstants.SUBMIT_CLAIM_SUBMITTER_MAIL_TEMPLATE);
			data.add(false);
			notifyData.add(data);

			List<Object> data1 = new ArrayList<>();
			List<User> users = new ArrayList<>();
			users.add(invigilatorUser);
			data1.add(users);
			data1.add(false);
			data1.add(FinanceConstants.SUBMIT_CLAIM_REJECTED_MAIL_TEMPLATE);
			data1.add(true);
			notifyData.add(data1);
		}
	}

	public void handlePendingApprovalClaimNotification(ThemeDisplay themeDisplay, List<List<Object>> notifyData,
			boolean verifier) {
		if (verifier) {
			List<Object> data = new ArrayList<>();
			data.add(getUsersByRoles(themeDisplay, FinanceConstants.APPROVER_ROLE_PARAM));
			data.add(true);
			data.add(FinanceConstants.SUBMIT_CLAIM_APPROVER_MAIL_TEMPLATE);
			data.add(false);
			notifyData.add(data);
		}
	}

	public void handleApprovedClaimNotification(ThemeDisplay themeDisplay, List<List<Object>> notifyData, boolean approver, User invigilatorUser) throws SystemException, PortalException {
		if (approver) {
			List<Object> data = new ArrayList<>();
			List<User> users = new ArrayList<>();
			users.add(invigilatorUser);
			data.add(users);
			data.add(true);
			data.add(FinanceConstants.SUBMIT_CLAIM_APPROVED_MAIL_TEMPLATE);
			data.add(true);
			notifyData.add(data);
			
			List<Object> data1 = new ArrayList<>();
			data1.add(UserLocalServiceUtil.getRoleUsers(RoleServiceUtil
					.getRole(themeDisplay.getCompanyId(), FinanceConstants.FINANCE_SUBMITTER_ROLE).getRoleId()));
			data1.add(true);
			data1.add(FinanceConstants.SUBMIT_CLAIM_APPROVED_MAIL_TEMPLATE);
			data1.add(true);
			notifyData.add(data1);
		}
	}

	public List<User> getUsersByRoles(ThemeDisplay themeDisplay, String roleParam) {
		List<User> users = new ArrayList<>();
		try {
			String roles = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndName(themeDisplay.getCompanyId(), roleParam).getValue();
			for (String role : roles.split(",")) {
				users.addAll(UserLocalServiceUtil
						.getRoleUsers(RoleServiceUtil.getRole(themeDisplay.getCompanyId(), role).getRoleId()));
			}
		} catch (Exception e) {
			_log.error(e);
		}
		return users;
	}

	public void sendSubmittedClaimNotifications(ResourceRequest resourceRequest, String inputData, String response) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			List<List<Object>> notifyData = new ArrayList<>();
			JSONObject inputObj = JSONFactoryUtil.createJSONObject(inputData);
			JSONObject mainJson = JSONFactoryUtil.createJSONObject(response);
			JSONObject contentJson = mainJson.getJSONObject(CONTENT_JSON);
			String as = inputObj.getString("approvalStatus");
			String ws = inputObj.getString("workFlowStatus");
			String notificationMessage = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(
					themeDisplay.getScopeGroupId(), "submittedclaim.notification.message").getValue();
			String claimType = SPListTypeLocalServiceUtil.fetchSPListType(contentJson.getLong("ClaimType"))
					.getDisplayName();
			JSONObject invigilatorModel = mainJson.getJSONObject("invigilatorModel");
			long invigilatorId = invigilatorModel.getLong("userId");
			User invigilatorUser = UserLocalServiceUtil.fetchUser(invigilatorId);

			boolean[] roles = checkUserRoles(themeDisplay);
			boolean submitter = roles[0];
			boolean verifier = roles[1];
			boolean approver = roles[2];

			_log.debug("submitter : " + submitter);
			_log.debug("verifier : " + verifier);
			_log.debug("approver : " + approver);

			switch (as) {
			case FinanceConstants.PENDING_VERIFICATION:
				if (submitter) {
					List<Object> data = new ArrayList<>();
					data.add(getUsersByRoles(themeDisplay, FinanceConstants.VERIFIER_ROLE_PARAM));
					data.add(true);
					data.add(FinanceConstants.SUBMIT_CLAIM_VERIFIER_MAIL_TEMPLATE);
					data.add(false);
					notifyData.add(data);
					notificationMessage = notificationMessage.replace("[$claimStatus$]",
							contentJson.getString("WorkFlowStatus").toLowerCase());
				}
				break;
			case FinanceConstants.PENDING_AMENDMENTS:
				handlePendingAmendmentsClaimNotification(submitter, verifier, approver, invigilatorUser, notifyData,
						themeDisplay, ws);
				notificationMessage = notificationMessage.replace("[$claimStatus$]",
						FinanceConstants.RETURN_FOR_AMENDMENTS.toLowerCase());
				break;
			case FinanceConstants.REJECTED:
				handleRejectedClaimNotification(submitter, verifier, approver, invigilatorUser, notifyData,
						themeDisplay);
				notificationMessage = notificationMessage.replace("[$claimStatus$]",
						FinanceConstants.REJECTED.toLowerCase());
				break;
			case FinanceConstants.PENDING_APPROVAL:
				handlePendingApprovalClaimNotification(themeDisplay, notifyData, verifier);
				notificationMessage = notificationMessage.replace("[$claimStatus$]",
						FinanceConstants.SUBMITTED_FOR_APPROVAL.toLowerCase());
				break;
			case FinanceConstants.APPROVED:
				handleApprovedClaimNotification(themeDisplay, notifyData, approver, invigilatorUser);
				notificationMessage = notificationMessage.replace("[$claimStatus$]",
						FinanceConstants.APPROVED.toLowerCase());
				break;
			default:
				break;
			}
			notificationMessage = notificationMessage.replace("[$claimType$]", claimType);
			notificationMessage = notificationMessage.replace("[$invigilatorName$]",
					invigilatorModel.getString("fullName"));
			notificationMessage = notificationMessage.replace("[$scheduleName$]",
					mainJson.getJSONObject("scheduleModel").getString("name"));
			String detailsLink = resourceRequest.getPreferences().getValue("submitClaimDetailUrlPref", "");
			detailsLink = detailsLink.replace("[$storageId$]", inputObj.getString("storageId"));
			Map<String, String> params = new HashMap<>();
			params.put("[$TO_FULL_NAME$]", invigilatorModel.getString("fullName"));
			params.put("[$TO_FIRST_NAME$]", invigilatorModel.getString("firstName"));
			params.put("[$TO_LAST_NAME$]", invigilatorModel.getString("lastName"));
			params.put("[$CLAIM_TYPE$]", claimType);
			params.put("[$CLAIM_STATUS$]", FinanceConstants.RETURN_FOR_AMENDMENTS);
			params.put("[$SCHEDULE_NAME$]", mainJson.getJSONObject("scheduleModel").getString("name"));
			params.put("[$DETAIL_LINK$]", detailsLink);

			_log.debug("notifyData : " + notifyData.size());
			for (List<Object> data : notifyData) {
				@SuppressWarnings("unchecked")
				List<User> users = (List<User>) data.get(0);
				boolean sendNotification = (boolean) data.get(1);
				String mailTemplate = (String) data.get(2);
				boolean sendEmail = (boolean) data.get(3);

				_log.debug("sendNotification : " + sendNotification);
				_log.debug("sendEmail : " + sendEmail);
				_log.debug("mailTemplate : " + mailTemplate);

				for (User user : users) {
					_log.debug("user : " + user.getEmailAddress());
					if (sendNotification) {
						SystemLocalServiceUtil.addTimelineActivity(detailsLink, "Details", notificationMessage,
								StringPool.BLANK, StringPool.BLANK, "Completed", themeDisplay.getUserId(),
								"Submitted Claim", "Finance", StringPool.BLANK, StringPool.BLANK, "" + user.getUserId(),
								themeDisplay.getScopeGroupId());
					}
					if (sendEmail) {
						sendEmailNotification(themeDisplay, user.getEmailAddress(),
								SPParameterLocalServiceUtil
										.findBySPParameterGroupIdAndName(themeDisplay.getScopeGroupId(), mailTemplate)
										.getValue(),
								params);
					}
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void sendEmailNotification(ThemeDisplay themeDisplay, String toAddress, String templateName,
			Map<String, String> params) {
		try {
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setScopeGroupId(themeDisplay.getScopeGroupId());
			String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
			String fromAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
			SPMailTemplate spMailTemplate = SPMailTemplateLocalServiceUtil.getTemplateByName(templateName);
			com.sambaash.platform.model.MailMessage mailMessage = new MailMessage();
			mailMessage.setSubject(spMailTemplate.getSubject());
			mailMessage.setHtmlBody(spMailTemplate.getHtmlContent());
			mailMessage.setHtmlFormat(true);
			String body = mailMessage.getHtmlBody();
			for (Entry<String, String> entry : params.entrySet()) {
				body = body.replace(entry.getKey(), entry.getValue());
			}
			mailMessage.setFromAddress(fromAddress);
			mailMessage.setFromName(fromName);
			mailMessage.setToAddress(toAddress);
			mailMessage.setHtmlBody(body);
			SPMailLocalServiceUtil.sendMail(mailMessage);
		} catch (Exception e) {
			_log.error(e);
		}
	}
}
