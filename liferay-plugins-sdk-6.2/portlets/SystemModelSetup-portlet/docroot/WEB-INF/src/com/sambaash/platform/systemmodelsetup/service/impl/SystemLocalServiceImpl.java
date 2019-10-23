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

package com.sambaash.platform.systemmodelsetup.service.impl;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.model.microservicemodel.MicroServiceModel;
import com.sambaash.platform.service.FetchLocalServiceUtil;
import com.sambaash.platform.systemmodelsetup.SystemModelHelper;
import com.sambaash.platform.systemmodelsetup.service.base.SystemLocalServiceBaseImpl;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the system local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.systemmodelsetup.service.SystemLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author biswo
 * @see com.sambaash.platform.systemmodelsetup.service.base.SystemLocalServiceBaseImpl
 * @see com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil
 */
public class SystemLocalServiceImpl extends SystemLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil} to
	 * access the system local service.
	 */

	private static final Log _log = LogFactoryUtil.getLog(SystemLocalServiceImpl.class);

	private static final String TOTAL_ELEMENTS = "totalElements";
	private static final String TITLES = "titles";
	private static final String ORDER = "order";
	private static final String COLUMN_LIST = "columnlist";
	private static final String LAST_MODIFIED_DATE = "lastModifiedDate";
	private static final String CREATED_DATE = "createdDate";
	private static final String LAST_MODIFIED_BY = "lastModifiedBy";
	private static final String CREATED_BY = "createdBy";
	private static final String SESSION_CURRENTQUERY = "currentquery";
	private static final String SESSION_EXPORTQUERY = "exportquery";
	private static final String CONTENT_JSON = "contentJson";
	private static final String CONTENT_JSON_PREFIX = "contentJson.";
	private static final String ELASTIC_SEARCH = "/elasticsearch?";

	private static String errorStr = "error";
	private static String formStorageIdStr = "formStorageId";
	private static String formTypeStr = "formType";
	private static String sortByStr = "sortBy";
	private static String restUriGet = "/get/";
	private static String restUriSize = "&size=";
	private static String requestURL = "Request URL";
	private static String contentStr = "content";
	private static String contentTypeStr = "contentType";
	private static String restUriLimit = "limit";
	private static String pageEqual = "page=";

	RestTemplate restTemplate = new RestTemplate();

	public class APICall {
		long userId = 0;
		long siteId = 0;
		ResourceRequest req;
		HttpHeaders headers;
		HttpEntity<String> httprequest;
		String baseUrl = StringPool.BLANK;

		public APICall(ResourceRequest request) {
			try {
				this.req = request;
				userId = PortalUtil.getUserId(request);
				siteId = PortalUtil.getScopeGroupId(request);
				headers = new HttpHeaders();
				headers.add("X-SCOPEGROUP-ID", StringPool.BLANK + SambaashUtil.getScopeGroupId(siteId));
				headers.add("X-USER-ID", StringPool.BLANK + userId);

				baseUrl = SambaashUtil.getParameter(SambaashConstants.API_STORAGE_ENGINE_BASEURL,
						SambaashConstants.DEFAULT_GROUP_ID_LONG);

			} catch (PortalException | SystemException e1) {
				_log.error(e1);
			}

		}

		public APICall(long userId, long siteId) {
			headers = new HttpHeaders();
			headers.add("X-SCOPEGROUP-ID", StringPool.BLANK + SambaashUtil.getScopeGroupId(siteId));
			headers.add("X-USER-ID", StringPool.BLANK + userId);
			baseUrl = SambaashUtil.getParameter(SambaashConstants.API_STORAGE_ENGINE_BASEURL,
					SambaashConstants.DEFAULT_GROUP_ID_LONG);

		}

		private String exchange(String subUrl, HttpMethod method) {
			String response = StringPool.BLANK;
			httprequest = new HttpEntity<>(headers);
			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<String> httpresponse = restTemplate.exchange(uri, method, httprequest, String.class);
				_log.info(baseUrl + subUrl);

				_log.debug(requestURL + baseUrl + subUrl);
				response = httpresponse.getBody();
				_log.debug(response);

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
				response.put(contentStr, httpresponse.getBody());
				response.put(contentTypeStr, httpresponse.getHeaders().getContentType());
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
				_log.debug(baseUrl + subUrl);
				_log.debug(data);
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

		private void downloadObjects(String data, String subUrl, HttpMethod method, ResourceResponse resourceResponse) {
			headers.setContentType(MediaType.APPLICATION_JSON);
			httprequest = new HttpEntity<>(data, headers);

			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<String> httpresponse = restTemplate.exchange(uri, method, httprequest, String.class);
				if (httpresponse.getStatusCode().equals(HttpStatus.OK)) {

					String response2 = httpresponse.getBody();

					SystemModelHelper.exportData(response2, data, resourceResponse);

				} else {
					_log.debug("downloadObject HTTPStatus" + httpresponse.getStatusCode().toString());
				}
			} catch (Exception e) {
				_log.error(requestURL + baseUrl + subUrl);
				_log.error(e);
			}

		}

	}

	public String createRecord(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = StringPool.BLANK;
		try {
			String modeldata = resourceRequest.getParameter("data");
			_log.debug("creating data" + modeldata);
			_log.debug("model data is " + modeldata);
			String apiModelData = convertToAPIModel(resourceRequest, modeldata, StringPool.BLANK);
			_log.debug("api model data is " + apiModelData);
			String model = resourceRequest.getParameter(formTypeStr).toLowerCase();
			String subUrl = model + "/new";
			_log.debug("create data" + apiModelData);
			response = new APICall(resourceRequest).postForObject(apiModelData, subUrl);
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}

	public String sendRequest(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = StringPool.BLANK;
		try {

			String modeldata = resourceRequest.getParameter("data");
			JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(modeldata);
			String endPoint = jsonModelData.getString("endPoint");
			_log.debug("creating data" + modeldata);
			String model = resourceRequest.getParameter(formTypeStr).toLowerCase();
			String limit = jsonModelData.getString(restUriLimit);
			String page = jsonModelData.getString("page");
			String subUrl = model + "/" + endPoint;
			if(!StringUtils.isEmpty(limit) && !StringUtils.isEmpty(page)) {
                subUrl = model + "/" + endPoint + "?page=" + page + restUriSize + limit;
            }
			response = new APICall(resourceRequest).postForObject(modeldata, subUrl);
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}

	public String multiCreateRecord(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = StringPool.BLANK;
		try {
			String modeldata = resourceRequest.getParameter("data");
			String userList = (String) resourceRequest.getAttribute("userList");

			JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(modeldata);
			jsonModelData.put("userList", userList);
			JSONObject jsonContentJSONData = JSONFactoryUtil.createJSONObject();
			jsonContentJSONData.put(CONTENT_JSON, jsonModelData);
			String model = resourceRequest.getParameter(formTypeStr).toLowerCase();
			String subUrl = StringPool.BLANK;
			_log.debug("create data" + jsonContentJSONData);
			if (resourceRequest.getParameter(formStorageIdStr).isEmpty()
					|| resourceRequest.getParameter(formStorageIdStr).equals("0")) {
				subUrl = model + "/new";
				response = new APICall(resourceRequest).postForObject(jsonContentJSONData.toString(), subUrl);
			} else {
				subUrl = model + "/edit/" + resourceRequest.getParameter(formStorageIdStr);
				response = new APICall(resourceRequest).putForObject(jsonContentJSONData.toString(), subUrl);
			}

		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}

	public String fetchElasticRecordsForGenericSearch(ResourceRequest resourceRequest, String jsonElasticSearchQuery,
			String subUrl) {

		String response = StringPool.BLANK;
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
			String storageId = resourceRequest.getParameter(formStorageIdStr);
			String model = resourceRequest.getParameter(formTypeStr);
			String subUrl = model.toLowerCase() + restUriGet + storageId;
			existingData = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			response = convertToFormModel(existingData, model);
		} catch (Exception e) {
			_log.error(e);
			response = e.toString();
		}
		return response;
	}

	public String fetchRecord(String storageId, String model, long userId, long siteId) {
		String response = null;
		String existingData = null;
		try {
			String subUrl = model.toLowerCase() + restUriGet + storageId;
			existingData = new APICall(userId, siteId).exchange(subUrl, HttpMethod.GET);
			response = convertToFormModel(existingData, model);
		} catch (Exception e) {
			_log.error(e);
			response = e.toString();
		}
		return response;
	}

	public String fetchRecordByModelId(String modelId, String model, long userId, long siteId) {
		String response = null;
		String existingData = null;
		try {
			String subUrl = model.toLowerCase() + restUriGet + "modelId/" + modelId;
			existingData = new APICall(userId, siteId).exchange(subUrl, HttpMethod.GET);
			response = convertToFormModel(existingData, model);
		} catch (Exception e) {
			_log.error(e);
			response = e.toString();
		}
		return response;
	}

	public String updateRecord(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = StringPool.BLANK;
		try {
			String storageId = resourceRequest.getParameter(formStorageIdStr);
			String modeldata = resourceRequest.getParameter("data");
			_log.debug("updating data" + modeldata);
			String model = resourceRequest.getParameter(formTypeStr).toLowerCase();
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
		JSONObject responseObj = new JSONFactoryUtil().createJSONObject();
		String[] tempArray = null;
		try {
			String subUrl = modelName.toLowerCase() + "/getFilterColumns";
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
			responseObj = new JSONFactoryUtil().createJSONObject(response);
			String columns = responseObj.getString("columns");
			tempArray = columns.split(",");
		} catch (Exception e) {
			_log.error(e);
		}
		return (Arrays.asList(tempArray));

	}

	public String getMicroserviceModelColumnTitleMap(ResourceRequest resourceRequest, String modelName) {

		String response = StringPool.BLANK;
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
			String modelName = inp.getString("ModelName");
			if (modelName.equalsIgnoreCase(StringPool.BLANK)) {
				modelName = inp.getString("formType");
			}
			List<String> columns = getMicroserviceModelColumnList(resourceRequest, modelName);

			if (columns.size() <= 1)
				return noOpFormIOToModelJSON(inp);
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
			_log.error(e.toString());
		}

		return jsonModelExistingData;

	}

	protected JSONObject noOpFormIOToModelJSON(JSONObject in) {
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
			response = errorStr;
		}
		return response;
	}

	public String getListing(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = null;
		try {
			String data = resourceRequest.getParameter("data");
			JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(data);
			String limit = jsonModelData.getString(restUriLimit);
			String model = jsonModelData.getString(formTypeStr).toLowerCase();
			String page = jsonModelData.getString("page");
			String sortByField = "contentJson.Status";
			if (!jsonModelData.getString(sortByStr).equalsIgnoreCase(StringPool.BLANK)) {
				sortByField = CONTENT_JSON_PREFIX + jsonModelData.getString(sortByStr);
			}

			String subUrl = model + "/list?page=" + page + restUriSize + limit + "&sort=" + sortByField;
			saveCurrentQuery("{}", resourceRequest);
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);

		} catch (Exception e) {
			_log.error(e);
			response = errorStr;
		}
		return response;

	}

	public String getElasticSearchListing(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = null;
		try {
			String data = resourceRequest.getParameter("data");
			_log.debug(data);
			if (Validator.isNull(data)) {
				data = (String) resourceRequest.getAttribute("data");
			}
			if (data != null && data != StringPool.BLANK) {
				JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(data);
				String limit = jsonModelData.getString(restUriLimit);
				String model = jsonModelData.getString(formTypeStr).toLowerCase();
				String page = jsonModelData.getString("page");
				JSONArray conditions = jsonModelData.getJSONArray("conditions");
				JSONArray filters = jsonModelData.getJSONArray("filterdata");
				JSONArray newFilter = jsonModelData.getJSONArray("newFilter");
				JSONArray searchIn = JSONFactoryUtil.createJSONArray();
				if (jsonModelData.has("searchIn")) {
					searchIn = jsonModelData.getJSONArray("searchIn");
				}
				JSONArray sortArray = jsonModelData.getJSONArray("sortby");

				String subUrl = model + ELASTIC_SEARCH + pageEqual + page + restUriSize + limit;

				JSONObject jsonElasticSearchQuery = JSONFactoryUtil.createJSONObject();
				if (conditions != null && conditions.length() > 0) {
					jsonElasticSearchQuery.put("conditions", conditions);
				}
				if (filters != null && filters.length() > 0) {
					jsonElasticSearchQuery.put("filters", filters);
				}
				if (newFilter != null && newFilter.length() > 0) {
					jsonElasticSearchQuery.put("newFilter", newFilter);
				}
				if (searchIn != null && searchIn.length() > 0) {
					jsonElasticSearchQuery.put("searchIn", searchIn);
				}
				if (sortArray != null && sortArray.length() > 0) {
					jsonElasticSearchQuery.put("sortby", sortArray);
				}
				saveCurrentQuery(jsonElasticSearchQuery.toString(), resourceRequest);
				_log.debug("Posting with requestbody" + jsonElasticSearchQuery.toString());
				response = new APICall(resourceRequest).postForObject(jsonElasticSearchQuery.toString(), subUrl);
			} else {
				_log.debug("Search request was empty" + data);
			}
		} catch (Exception e) {
			_log.error(e);
			response = errorStr;
		}
		return response;

	}

	public String getSearchListing(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = null;
		try {
			String data = resourceRequest.getParameter("data");
			JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(data);
			String limit = jsonModelData.getString(restUriLimit);
			String model = jsonModelData.getString(formTypeStr).toLowerCase();
			String page = jsonModelData.getString("page");
			String sortByField = jsonModelData.getString(sortByStr);
			JSONArray conditions = jsonModelData.getJSONArray("conditions");
			JSONObject currentquery = JSONFactoryUtil.createJSONObject();

			if (!sortByField.equalsIgnoreCase(StringPool.BLANK)) {
				sortByField = CONTENT_JSON_PREFIX + jsonModelData.getString(sortByStr);
			}
			String regexOperator = "=";
			String condition = StringPool.BLANK;
			StringBuilder bld = new StringBuilder();
			for (int i = 0; i < conditions.length(); i++) {
				bld.append(conditions.getString(i) + "&");
				String[] splitcondition = conditions.getString(i).split(regexOperator);
				currentquery.put(splitcondition[0], splitcondition[1]);
			}

			saveCurrentQuery(currentquery.toString(), resourceRequest);
			condition = bld.toString();
			String subUrl = model + "/search?" + condition + pageEqual + page + restUriSize + limit + "&sort="
					+ sortByField;

			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);

		} catch (Exception e) {
			_log.error(e);
			response = errorStr;
		}
		return response;

	}

	public String archiveRecord(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String response = null;
		try {
			String storageId = resourceRequest.getParameter(formStorageIdStr);
			String model = resourceRequest.getParameter(formTypeStr).toLowerCase();
			String subUrl = model + "/archive/" + storageId;
			response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.DELETE);

		} catch (Exception e) {
			_log.error(e);
			response = errorStr;
		}
		return response;
	}

	public void handleFileUpload(ResourceRequest request, ResourceResponse response) {

		JSONObject retObj = JSONFactoryUtil.createJSONObject();
		JSONArray objArr = JSONFactoryUtil.createJSONArray();
		_log.debug(request.getContentType());
		String objResponse = StringPool.BLANK;
		try {

			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
			File file1 = uploadRequest.getFile("file");
			String fileName = uploadRequest.getParameter("name");
			String downloadUrlPattern = uploadRequest.getParameter("downloadUrlPattern");
			JSONObject obj1 = JSONFactoryUtil.createJSONObject();
			String modelName = request.getParameter(formTypeStr).toLowerCase();
			String subUrl = modelName + "/uploadTemp";
			_log.debug(subUrl);

			objResponse = new APICall(request).uploadObjectNew(file1, fileName, subUrl, downloadUrlPattern);
			if (Validator.isNotNull(objResponse)) {
				objArr.put(JSONFactoryUtil.createJSONObject(objResponse));

			} else {
				obj1.put(errorStr, "Error uploading the file.");
			}
			retObj.put("result", objArr);
			retObj.put("data", objArr.getJSONObject(0));

			response.getWriter().write(retObj.toString());

		} catch (IOException | JSONException e1) {
			_log.error(e1);
		}
	}

	public void handleBatchUpload(ResourceRequest request, ResourceResponse response) {

		JSONObject retObj = JSONFactoryUtil.createJSONObject();
		JSONArray objArr = JSONFactoryUtil.createJSONArray();
		_log.debug(request.getContentType());
		String objResponse = StringPool.BLANK;
		try {

			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
			File file1 = uploadRequest.getFile("myFile");
			String fileName = uploadRequest.getFileName("myFile");
			String downloadUrlPattern = StringPool.BLANK;
			JSONObject obj1 = JSONFactoryUtil.createJSONObject();
			String modelName = request.getParameter(formTypeStr).toLowerCase();
			String subUrl = modelName + "/batchUpload";
			_log.debug(subUrl);

			objResponse = new APICall(request).uploadObjectNew(file1, fileName, subUrl, downloadUrlPattern);
			if (Validator.isNotNull(objResponse)) {
				objArr.put(JSONFactoryUtil.createJSONObject(objResponse));

			} else {
				obj1.put(errorStr, "Error uploading the file.");
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
			String modelNameMicroService = resourceRequest.getParameter(formTypeStr);
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
			String columnTitles = getMicroserviceModelColumnTitleMap(resourceRequest, modelNameMicroService);
			JSONArray allModelColumnTitlesArray = JSONFactoryUtil.createJSONArray(columnTitles);
			JSONObject distinct = JSONFactoryUtil.createJSONObject(response);
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			JSONArray datepicker = JSONFactoryUtil.createJSONArray();
			JSONObject titles = JSONFactoryUtil.createJSONObject();
			JSONArray titles1 = JSONFactoryUtil.createJSONArray();
			JSONArray distinctCreatedBy = distinct.getJSONArray(CREATED_BY);
			JSONArray distinctModifiedBy = distinct.getJSONArray(LAST_MODIFIED_BY);

			List<String> modifiedBy = new ArrayList<>();
			for (int i = 0; i < distinctModifiedBy.length(); i++) {
				modifiedBy.add(distinctModifiedBy.getString(i));

			}
			for (int i = 0; i < distinctCreatedBy.length(); i++) {
				if (!modifiedBy.contains(distinctCreatedBy.getString(i))) {
					distinctModifiedBy.put(distinctCreatedBy.getString(i));
				}

			}

			DynamicQuery studentINOperator = DynamicQueryFactoryUtil.forClass(User.class,
					PortletClassLoaderUtil.getClassLoader());
			Criterion criterion6 = null;
			ArrayList<Long> list = new ArrayList<>();
			for (int i = 0; i < distinctModifiedBy.length(); i++) {
				try {
					if (!distinctModifiedBy.getString(i).equalsIgnoreCase(null)) {
						list.add(Long.valueOf(distinctModifiedBy.getString(i)));
					}
				} catch (Exception e) {
					_log.error(e);
				}
			}
			JSONArray usersInfo = JSONFactoryUtil.createJSONArray();
			JSONObject userInfo;
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
				_log.info("datepicker: " + datePickerColumn);
			}
			for (int i = 0; i < allModelColumnTitlesArray.length(); i++) {
				JSONObject modelTitleObj = allModelColumnTitlesArray.getJSONObject(i);
				titles.put(CONTENT_JSON_PREFIX + modelTitleObj.getString("key"),
						modelTitleObj.getString("translation"));
				_log.info("titles:" + modelTitleObj.getString("translation"));

				JSONObject titleObj = JSONFactoryUtil.createJSONObject();
				titleObj.put("key", CONTENT_JSON_PREFIX + modelTitleObj.getString("key"));
				titleObj.put("value", modelTitleObj.getString("translation"));
				titles1.put(titleObj);
			}
			JSONObject titleObj = JSONFactoryUtil.createJSONObject();
			titleObj.put("key", CREATED_BY);
			titleObj.put("value", "Created By");
			titles1.put(titleObj);
			titleObj = JSONFactoryUtil.createJSONObject();
			titleObj.put("key", CREATED_DATE);
			titleObj.put("value", "Created Date");
			titles1.put(titleObj);
			titleObj = JSONFactoryUtil.createJSONObject();
			titleObj.put("key", LAST_MODIFIED_BY);
			titleObj.put("value", "Last Modified By");
			titles1.put(titleObj);
			titleObj = JSONFactoryUtil.createJSONObject();
			titleObj.put("key", LAST_MODIFIED_DATE);
			titleObj.put("value", "Last Modified Date");
			titles1.put(titleObj);

			obj.put("userInfo", usersInfo);
			obj.put("distinct", distinct);
			obj.put("datepicker", datepicker);
			obj.put(TITLES, titles1);
			return obj.toString();
		} catch (Exception e) {
			_log.error("getFilterColumnHeader exception: " + e);
			response = errorStr;
		}
		return response;
	}

	public void exportListToExcelFile(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			_log.debug("exportListToExcelFile invoked");
			String model = resourceRequest.getParameter(formTypeStr);
			String storageId = resourceRequest.getParameter(formStorageIdStr);
			String restmodel = model.toLowerCase();
			PortletSession session = resourceRequest.getPortletSession();
			String exportquery = (String) session.getAttribute(SESSION_EXPORTQUERY, PortletSession.PORTLET_SCOPE);

			JSONObject jsonExportQuery = JSONFactoryUtil.createJSONObject(exportquery);
			if (storageId != null) {

				JSONArray nn = JSONFactoryUtil.createJSONArray("[{'storageId':['" + storageId + "']}]");

				// {"filters":[{"contentJson.CurrencyCode":["CC"]}]}
				// jsonExportQuery.put("filters", nn);
				jsonExportQuery.getJSONObject("elasticsearch").put("filters", nn);
			}
			int totalsize = jsonExportQuery.getInt(TOTAL_ELEMENTS);
			String subUrl = restmodel + "/global/exportData?page=0&size=" + totalsize;
			JSONObject jsonTitleOrder = getTitleOrder(resourceRequest, model);
			jsonExportQuery.put(TITLES, jsonTitleOrder.getJSONObject(TITLES));
			jsonExportQuery.put(ORDER, jsonTitleOrder.getJSONArray(ORDER));

			String subUrl2 = "/configuration/get/" + restmodel;
			String strColumnRsp = new APICall(resourceRequest).exchange(subUrl2, HttpMethod.GET);
			String strColumn = new org.json.JSONObject(strColumnRsp).getJSONObject("contentJson")
					.getString("columnlist");
			List<String> items = Arrays.asList(strColumn.split("\\s*,\\s*"));
			jsonExportQuery.put(COLUMN_LIST, JSONFactoryUtil.createJSONArray(items.toString()));

			_log.debug("ExportList Exportquery" + jsonExportQuery.toString());
			new APICall(resourceRequest).downloadObjects(jsonExportQuery.toString(), subUrl, HttpMethod.POST,
					resourceResponse);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void exportRowToExcelFile(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			_log.debug("exportRowToExcelFile invoked");
			String storageId = resourceRequest.getParameter(formStorageIdStr);
			String model = resourceRequest.getParameter(formTypeStr);
			String restmodel = model.toLowerCase();
			String subUrl = restmodel + "/export/" + storageId;
			JSONObject jsonExportQuery = JSONFactoryUtil.createJSONObject();
			JSONObject jsonTitleOrder = getTitleOrder(resourceRequest, model);
			jsonExportQuery.put(TITLES, jsonTitleOrder.getJSONObject(TITLES));
			jsonExportQuery.put(ORDER, jsonTitleOrder.getJSONArray(ORDER));

			String subUrl2 = "/configuration/get/" + restmodel;
			String strColumnRsp = new APICall(resourceRequest).exchange(subUrl2, HttpMethod.GET);
			String strColumn = new org.json.JSONObject(strColumnRsp).getJSONObject("contentJson")
					.getString("columnlist");
			List<String> items = Arrays.asList(strColumn.split("\\s*,\\s*"));
			jsonExportQuery.put(COLUMN_LIST, JSONFactoryUtil.createJSONArray(items.toString()));

			new APICall(resourceRequest).downloadObjects(jsonExportQuery.toString(), subUrl, HttpMethod.POST,
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
		for (String column : columnsList1) {
			order.put(CONTENT_JSON_PREFIX + column);
			_log.info("order:" + column);
		}
		
		if(!modelName.equals("MasterTimeTable")){
			order.put(CREATED_BY);
			order.put(CREATED_DATE);
			order.put(LAST_MODIFIED_BY);
			order.put(LAST_MODIFIED_DATE);
		}

		String columnTitles = getMicroserviceModelColumnTitleMap(resourceRequest, modelName);
		JSONArray allModelColumnTitlesArray;
		try {
			allModelColumnTitlesArray = JSONFactoryUtil.createJSONArray(columnTitles);
			for (int i = 0; i < allModelColumnTitlesArray.length(); i++) {
				titles.put(CONTENT_JSON_PREFIX + allModelColumnTitlesArray.getJSONObject(i).getString("key"),
						allModelColumnTitlesArray.getJSONObject(i).getString("translation"));
				_log.info("titles:" + allModelColumnTitlesArray.getJSONObject(i).getString("translation"));
			}
		} catch (JSONException e) {
			_log.error(e);
		}
		
		if(!modelName.equals("MasterTimeTable")){
			titles.put(CREATED_BY, "Created By");
			titles.put(CREATED_DATE, "Created Date");
			titles.put(LAST_MODIFIED_BY, "Last Modified By");
			titles.put(LAST_MODIFIED_DATE, "Last Modified Date");
		}
		
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

	public HashMap<Long, List<Layout>> getUserLayoutsOne1(ThemeDisplay themeDisplay) {
		String navigation = FetchLocalServiceUtil.fetchRecord("1", "Navigation", 20199, 21424);
		String response = FetchLocalServiceUtil.getAllRecord("childnavigation", 20199, 21424);
		JSONArray content = JSONFactoryUtil.createJSONArray();
		JSONArray childLayouts;
		Layout childLayout;
		HashMap<Long, List<Layout>> map = new HashMap<>();
		try {
			JSONObject childNav = JSONFactoryUtil.createJSONObject(response);
			content = childNav.getJSONArray(contentStr);

		} catch (JSONException | NullPointerException e1) {
			_log.error(e1.toString());
			return map;
		}
		long layoutId;
		List<Layout> userLayouts = new ArrayList<>();
		try {
			long userId = themeDisplay.getUserId();
			JSONObject obj = JSONFactoryUtil.createJSONObject(navigation);
			JSONObject contentJson = obj.getJSONObject(CONTENT_JSON);
			JSONArray datagrid = contentJson.getJSONArray("DataGrid");

			List<Role> userRoles = getUserGroupRolesOfUser(userId);

			for (int i = 0; i < userRoles.size(); i++) {

				for (int j = 0; j < datagrid.length(); j++) {

					if (datagrid.getJSONObject(j).getJSONArray("Role").toString()
							.contains(String.valueOf(userRoles.get(i).getRoleId()))) {

						layoutId = Long.valueOf(datagrid.getJSONObject(j).getJSONObject("Layout").getString("id"));
						Layout layout = LayoutLocalServiceUtil.getLayout(themeDisplay.getScopeGroupId(), false,
								layoutId);

						if (!map.containsKey(layout.getLayoutId())) {

							userLayouts = new ArrayList<>();
							userLayouts.add(layout);

							for (int k = 0; k < content.length(); k++) {

								if (content.getJSONObject(k).getJSONObject(CONTENT_JSON)
										.getLong("ParentLayout") == layoutId) {

									childLayouts = JSONFactoryUtil.createJSONArray(content.getJSONObject(k)
											.getJSONObject(CONTENT_JSON).getString("ChildLayout"));

									for (int t = 0; t < childLayouts.length(); t++) {

										childLayout = LayoutLocalServiceUtil.getLayout(themeDisplay.getScopeGroupId(),
												false, childLayouts.getLong(t));
										userLayouts.add(childLayout);

									}
								}
							}

							map.put(layout.getLayoutId(), userLayouts);

						}
					}
				}
			}
			return map;

		} catch (PortalException | NullPointerException | SystemException e) {
			_log.error("saveCurrentQuery invoked");
			return map;
		}

	}

	public HashMap<Long, List<Layout>> getUserLayoutsOne(ThemeDisplay themeDisplay) {
		HashMap<Long, List<Layout>> map = new HashMap<>();
		try {
			long groupId = themeDisplay.getLayout().getGroupId();
			List<Layout> llayouts;
			llayouts = LayoutLocalServiceUtil.getLayouts(groupId, true);

			List<Layout> userLayouts = new ArrayList<>();
			for (Layout llayout : llayouts) {
				if (llayout.getParentLayoutId() == 0) {
					List<Layout> childLayout = LayoutLocalServiceUtil.getLayouts(groupId, true, llayout.getLayoutId());

					userLayouts = new ArrayList<>();
					if (!map.containsKey(llayout.getLayoutId())) {
						userLayouts.add(llayout);
						userLayouts.addAll(childLayout);
						map.put(llayout.getLayoutId(), userLayouts);
					}
				}

			}
			return map;
		} catch (SystemException e) {

		}
		return map;

	}

	private static List<Role> getUserGroupRolesOfUser(long userId) throws SystemException {

		return RoleLocalServiceUtil.getUserRoles(userId);

	}

	public String fetchElasticRecordsForGenericSearch(long userId, long scopeId, String jsonElasticSearchQuery,
			String subUrl) {

		String response = StringPool.BLANK;
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
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
			String modelName = uploadRequest.getParameter("formTypeName").toLowerCase();
			String storageId = uploadRequest.getParameter("record");
			String path = "temp---";
			if (storageId != null) {
				path = storageId + "---";
			}
			String subUrl = modelName + "/download/" + path + fileName;
			response = new APICall(resourceRequest).downloadFile(subUrl, HttpMethod.GET);
			return response;
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}

	public String getElasticSearchListForModel(String model, long siteId) {

		String response = null;
		try {
			String subUrl = model + ELASTIC_SEARCH + pageEqual + "0" + restUriSize + "1000";
			JSONArray jsonTerms = JSONFactoryUtil.createJSONArray();
			long userId = 1111;

			JSONObject jsonMustClause = JSONFactoryUtil.createJSONObject();
			jsonMustClause.put("must", jsonTerms);
			JSONObject jsonElasticSearchQuery = JSONFactoryUtil.createJSONObject();
			jsonElasticSearchQuery.put("bool", jsonMustClause);
			response = new APICall(userId, siteId).postForObject(jsonElasticSearchQuery.toString(), subUrl);

		} catch (Exception e) {
			_log.error(e);
			response = errorStr;
		}
		return response;

	}

	public String getElasticSearchListForModel(String model, long siteId, String matchJsonString, String sortString) {
		return getElasticSearchListForModel(model, siteId, matchJsonString, sortString, 1000);
	}
	
	public String getElasticSearchListForModel(String model, long siteId, String matchJsonString, String sortString, int pageSize) {
		String response = null;
		try {
			String subUrl = model + ELASTIC_SEARCH + pageEqual + "0" + restUriSize + pageSize;
			JSONArray jsonTerms = JSONFactoryUtil.createJSONArray();
			long userId = 1111;
			JSONObject matchObjects = JSONFactoryUtil.createJSONObject(matchJsonString);
			JSONArray newFilter = JSONFactoryUtil.createJSONArray();
			if (matchObjects.has("newFilter")) {
				newFilter = matchObjects.getJSONArray("newFilter");
			}
			Iterator<String> keys = matchObjects.keys();
			while (keys.hasNext()) {

				String key = keys.next();
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				JSONArray value = JSONFactoryUtil.createJSONArray();
				value.put(matchObjects.getString(key));

				obj.put(key, value);
				jsonTerms.put(obj);
			}

			JSONObject jsonElasticSearchQuery = JSONFactoryUtil.createJSONObject();
			jsonElasticSearchQuery.put("filters", jsonTerms);
			jsonElasticSearchQuery.put("newFilter", newFilter);
			JSONArray sortArray = JSONFactoryUtil.createJSONArray(sortString);
			if (sortArray != null && sortArray.length() > 0) {
				jsonElasticSearchQuery.put("sortby", sortArray);
			}

			response = new APICall(userId, siteId).postForObject(jsonElasticSearchQuery.toString(), subUrl);
		} catch (Exception e) {
			_log.error(e);
			response = errorStr;
		}
		return response;
	}

	// deprecated
	public String fetchEntityLink(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String existingData = null;
		try {
			String storageId = resourceRequest.getParameter(formStorageIdStr);
			String modeldata = resourceRequest.getParameter("data");
			JSONObject dataJson = JSONFactoryUtil.createJSONObject(modeldata);
			String linkType = dataJson.getString("linkType");
			String model = resourceRequest.getParameter(formTypeStr);
			String subUrl = model.toLowerCase() + "/getlink/" + storageId + "/" + linkType;
			existingData = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
		} catch (Exception e) {
			_log.error(e);
		}
		return existingData;
	}

	public String fetchEntityLinkObject(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String existingData = null;
		try {
			String storageId = resourceRequest.getParameter(formStorageIdStr);
			String modeldata = resourceRequest.getParameter("data");
			JSONObject dataJson = JSONFactoryUtil.createJSONObject(modeldata);
			String linkType = dataJson.getString("linkType");
			String model = resourceRequest.getParameter(formTypeStr);
			String subUrl = model.toLowerCase() + "/getlinkobject/" + storageId + "/" + linkType;
			existingData = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
		} catch (Exception e) {
			_log.error(e);
		}
		return existingData;
	}

	public String fetchEntityLink(String storageId, String modeldata, long userId, long siteId) {

		String existingData = null;
		try {
			// String storageId =
			// resourceRequest.getParameter(formStorageIdStr);
			// String modeldata = resourceRequest.getParameter("data");
			JSONObject dataJson = JSONFactoryUtil.createJSONObject(modeldata);
			String linkType = dataJson.getString("linkType");
			String model = dataJson.getString(formTypeStr);
			String subUrl = model.toLowerCase() + "/getlink/" + storageId + "/" + linkType;
			existingData = new APICall(userId, siteId).exchange(subUrl, HttpMethod.GET);
		} catch (Exception e) {
			_log.error(e);
		}
		return existingData;
	}

	/**
	 * @param actionLink
	 *            a String type. Upon action will lead to this link.
	 * @param actionLabel
	 *            a String type. Label to be displayed on Timeline.
	 * @param title
	 *            a String type. Title to be displayed on Timeline Activity.
	 * @param description
	 *            a String type. Description to be displayed on Timeline
	 *            Activity. Not used currently.
	 * @param imagePath
	 *            a String type. Image to be displayed on Timeline Activity. Not
	 *            used currently.
	 * @param status
	 *            a String type. Status to be displayed on Timeline Activity.
	 * @param createdByUserId
	 *            a long type. Person who is creating this Activity..
	 * @param activityType
	 *            a String type. ActivityType to be displayed on Timeline
	 *            Activity.
	 * @param category
	 *            a String type. Category to be displayed on Timeline Activity.
	 * @param subProductId
	 *            a String type. Should be fetched from SPSiteSetup
	 *            subProductId.
	 * @param content
	 *            a String type. Not used currently. Can be set blank.
	 * @param assignedTo
	 *            a String type. Person whom this activity should be assigned to
	 *            and can see it on his/her Timeline.
	 * @param groupId
	 *            a long type.
	 */
	public void addTimelineActivity(String actionLink, String actionLabel, String title, String description,
			String imagePath, String status, long createdByUserId, String activityType, String category,
			String subProductId, String content, String assignedTo, long groupId) {

		try {
			JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();

			payloadJSON.put("actionLink", actionLink);
			payloadJSON.put("actionLabel", actionLabel);

			payloadJSON.put("title", title);
			payloadJSON.put("description", description);
			payloadJSON.put("imageLink", imagePath);
			payloadJSON.put("status", status);
			payloadJSON.put("owner", String.valueOf(createdByUserId));
			payloadJSON.put("activityType", activityType);
			payloadJSON.put("category", category);
			payloadJSON.put("subProductId", subProductId);
			payloadJSON.put("content", content);
			payloadJSON.put("assignedTo", assignedTo);
			String subUrl = "activitylog/insert";

			_log.error(String.format("Payload JSON %s , groupId %s, subUrl %s ", payloadJSON.toString(),
					SambaashUtil.getScopeGroupId(groupId), subUrl));

			String response = new APICall(createdByUserId, SambaashUtil.getScopeGroupId(groupId))
					.postForObject(payloadJSON.toString(), subUrl);

			// if (_log.isDebugEnabled()) {
			_log.error(String.format("Activity API %s ", response));
			// }
		} catch (Exception e) {
			_log.error(e);
		}
	}

}
