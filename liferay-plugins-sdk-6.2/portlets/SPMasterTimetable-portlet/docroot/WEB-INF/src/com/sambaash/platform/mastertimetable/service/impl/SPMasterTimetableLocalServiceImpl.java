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

package com.sambaash.platform.mastertimetable.service.impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletSession;
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
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.mastertimetable.service.base.SPMasterTimetableLocalServiceBaseImpl;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the s p master timetable local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.mastertimetable.service.SPMasterTimetableLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gaurav.kapadiya
 * @see com.sambaash.platform.mastertimetable.service.base.SPMasterTimetableLocalServiceBaseImpl
 * @see com.sambaash.platform.mastertimetable.service.SPMasterTimetableLocalServiceUtil
 */
public class SPMasterTimetableLocalServiceImpl extends SPMasterTimetableLocalServiceBaseImpl {

    private static final String TITLES = "titles";
    private static final String LAST_MODIFIED_DATE = "lastModifiedDate";
    private static final String CREATED_DATE = "createdDate";
    private static final String START_DATE = "startDate";
    private static final String END_DATE = "endDate";
    private static final String LAST_MODIFIED_BY = "lastModifiedBy";
    private static final String CREATED_BY = "createdBy";
    private static final String SESSION_CURRENTQUERY = "currentquery";
    private static final String CONTENT_JSON_PREFIX = "contentJson.";
    private static final String CONDITIONS = "conditions";
    private static final String ELASTIC_SEARCH = "/elasticsearch?";
    private static final String PAGE_EQUAL = "page=";

    private static final Log _log = LogFactoryUtil.getLog(SPMasterTimetableLocalServiceImpl.class);
    private static String error = "error";
    private static String formType = "formType";
    private static String restUriSize = "&size=";
    private static String requestURL = "Request URL";
    private static String restUriLimit = "limit";

    public class APICall {
        long userId = 0;
        long siteId = 0;
        ResourceRequest req;
        HttpHeaders headers;
        HttpEntity<String> httprequest;
        RestTemplate restTemplate;
        String baseUrl = StringPool.BLANK;

        public APICall(ResourceRequest request) {
            try {
                this.req = request;
                userId = PortalUtil.getUserId(request);
                siteId = PortalUtil.getScopeGroupId(request);
                headers = new HttpHeaders();
                headers.add("X-SCOPEGROUP-ID", StringPool.BLANK + SambaashUtil.getScopeGroupId(siteId));
                headers.add("X-USER-ID", StringPool.BLANK + userId);
                restTemplate = new RestTemplate();
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
            restTemplate = new RestTemplate();
            baseUrl = SambaashUtil.getParameter(SambaashConstants.API_STORAGE_ENGINE_BASEURL,
                    SambaashConstants.DEFAULT_GROUP_ID_LONG);
        }

        private String exchange(String subUrl, HttpMethod method) {
            String response = StringPool.BLANK;
            httprequest = new HttpEntity<>(headers);
            try {
                URI uri = URI.create(baseUrl + subUrl);
                ResponseEntity<String> httpresponse = restTemplate.exchange(uri, method, httprequest, String.class);
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

    }

    public String getFilterColumnHeader(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
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
            String modelNameMicroService = resourceRequest.getParameter(formType);
            String model = modelNameMicroService.toLowerCase();
            List<String> filterColumns = getMicroserviceModelFilterColumnList(resourceRequest, modelNameMicroService);
            StringBuilder sbColumns = new StringBuilder("?");
            for (String filterColumn : filterColumns) {
                if (!sbColumns.toString().equals("?")) {
                    sbColumns.append("&");
                }
                sbColumns.append("columns=contentJson.");
                sbColumns.append(filterColumn);
            }
            for (String nonModelFilterColumn : nonModelFilterColumns) {
                if (!sbColumns.toString().equals("?")) {
                    sbColumns.append("&");
                }
                sbColumns.append("columns=");
                sbColumns.append(nonModelFilterColumn);
            }
            String subUrl = model + "/distinct/" + sbColumns.toString();
            response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
            Map<String, String> allModelColumnTitles = getMicroserviceModelColumnTitleMap(resourceRequest,
                    modelNameMicroService);
            JSONObject distinct = JSONFactoryUtil.createJSONObject(response);
            JSONObject obj = JSONFactoryUtil.createJSONObject();
            JSONArray datepicker = JSONFactoryUtil.createJSONArray();
            JSONObject titles = JSONFactoryUtil.createJSONObject();

            for (String datePickerColumn : datePickerColumns) {
                datepicker.put(datePickerColumn);
            }
            for (Map.Entry modelColumnTitle : allModelColumnTitles.entrySet()) {
                titles.put(CONTENT_JSON_PREFIX + (String) modelColumnTitle.getKey(),
                        (String) modelColumnTitle.getValue());
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

    public List<String> getMicroserviceModelFilterColumnList(ResourceRequest resourceRequest, String modelName) {

        String response = null;
        String[] tempArray = null;
        try {
            String subUrl = modelName.toLowerCase() + "/getFilterColumns";
            response = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);
            tempArray = response.split(",");
        } catch (Exception e) {
            _log.error(e);
            response = e.toString();
        }
        return (Arrays.asList(tempArray));

    }

    public Map<String, String> getMicroserviceModelColumnTitleMap(ResourceRequest resourceRequest, String modelName) {

        Map<String, String> map = new HashMap<>();
        String response = null;
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
            _log.error(e);
            response = e.toString();
        }
        return map;
    }

    public String getElasticSearchListing(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
        String response = null;
        try {
            String data = resourceRequest.getParameter("data");
            if (data != null && data != StringPool.BLANK) {
                JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(data);
                String limit = jsonModelData.getString(restUriLimit);
                String model = jsonModelData.getString(formType).toLowerCase();
                String page = jsonModelData.getString("page");
                String selectedCategories = jsonModelData.getString("selectedCategory");
                JSONArray conditions = jsonModelData.getJSONArray(CONDITIONS);
                JSONArray filters = jsonModelData.getJSONArray("filterdata");
                JSONArray sortArray = jsonModelData.getJSONArray("sortby");
                String subUrl = model + ELASTIC_SEARCH + PAGE_EQUAL + page + restUriSize + limit;
                JSONObject jsonElasticSearchQuery = JSONFactoryUtil.createJSONObject();
                prepareConditions(conditions, jsonElasticSearchQuery);
                prepareFilters(filters, resourceRequest, jsonElasticSearchQuery);
                if (sortArray != null && sortArray.length() > 0) {
                    jsonElasticSearchQuery.put("sortby", sortArray);
                }
                if (selectedCategories != null && selectedCategories != StringPool.BLANK) {
                    jsonElasticSearchQuery.put("selectedCategories", selectedCategories);
                }
                saveCurrentQuery(jsonElasticSearchQuery.toString(), resourceRequest);
                response = new APICall(resourceRequest).postForObject(jsonElasticSearchQuery.toString(), subUrl);

            } else {
                _log.debug("Search request was empty" + data);
            }
        } catch (Exception e) {
            _log.error(e);
            response = e.getMessage();
        }
        return response;
    }

    private void prepareConditions(JSONArray conditions, JSONObject jsonElasticSearchQuery) {
        if (conditions != null && conditions.length() > 0) {
            jsonElasticSearchQuery.put(CONDITIONS, conditions);
        }
    }

    private void prepareFilters(JSONArray filters, ResourceRequest resourceRequest, JSONObject jsonElasticSearchQuery)
            throws JSONException {
        if (filters == null) {
            filters = JSONFactoryUtil.createJSONArray();
        }
        jsonElasticSearchQuery.put("filters", filters);
    }

    public void saveCurrentQuery(String query, ResourceRequest resourceRequest) {
        PortletSession session = resourceRequest.getPortletSession();
        session.setAttribute(SESSION_CURRENTQUERY, query, PortletSession.PORTLET_SCOPE);
    }

}