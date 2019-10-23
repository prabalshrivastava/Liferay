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

package com.sambaash.platform.srv.genericupload.service.impl;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.srv.genericupload.service.base.BatchUploadLocalServiceBaseImpl;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the batch upload local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.genericupload.service.BatchUploadLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author biswo
 * @see com.sambaash.platform.srv.genericupload.service.base.BatchUploadLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.genericupload.service.BatchUploadLocalServiceUtil
 */
public class BatchUploadLocalServiceImpl extends BatchUploadLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link
     * com.sambaash.platform.srv.genericupload.service.
     * BatchUploadLocalServiceUtil} to access the batch upload local service.
     */
    private static final Log _log = LogFactoryUtil.getLog(BatchUploadLocalServiceImpl.class);

    public class APICall {
        long userId = 0;
        long siteId = 0;

        HttpHeaders headers;
        HttpEntity<String> httprequest;
        RestTemplate restTemplate;
        String baseUrl = StringPool.BLANK;

        public APICall(ResourceRequest request) {
            userId = PortalUtil.getUserId(request);
            try {
                siteId = PortalUtil.getScopeGroupId(request);
            } catch (PortalException | SystemException e) {
                _log.error(e);
            }
            headers = new HttpHeaders();
            headers.add("X-SCOPEGROUP-ID", StringPool.BLANK + SambaashUtil.getScopeGroupId(siteId));
            headers.add("X-USER-ID", StringPool.BLANK + userId);

            // Here copmpany id needs to be added
            headers.add("X-COMPANY-ID", StringPool.BLANK + SambaashUtil.getCurrentCompanyId());
            restTemplate = new RestTemplate();
            baseUrl = SambaashUtil.getParameter(SambaashConstants.API_STORAGE_ENGINE_BASEURL,
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
            headers.add("X-SCOPEGROUP-ID", StringPool.BLANK + SambaashUtil.getScopeGroupId(siteId));
            headers.add("X-USER-ID", StringPool.BLANK + userId);
            headers.add("X-COMPANY-ID", StringPool.BLANK + SambaashUtil.getCurrentCompanyId());
            restTemplate = new RestTemplate();
            baseUrl = SambaashUtil.getParameter(SambaashConstants.API_STORAGE_ENGINE_BASEURL,
                    SambaashConstants.DEFAULT_GROUP_ID_LONG);

        }

        public APICall(long userId, long siteId) throws PortalException {
            headers = new HttpHeaders();
            headers.add("X-SCOPEGROUP-ID", StringPool.BLANK + SambaashUtil.getScopeGroupId(siteId));
            headers.add("X-USER-ID", StringPool.BLANK + userId);
            headers.add("X-COMPANY-ID", StringPool.BLANK + SambaashUtil.getCurrentCompanyId());
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
                response.put("content", httpresponse.getBody());
                response.put("contentType", httpresponse.getHeaders().getContentType());
            } catch (Exception e) {
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

    }

    public void handleBatchUpload(ResourceRequest request, ResourceResponse response) {

        JSONObject retObj = JSONFactoryUtil.createJSONObject();
        JSONArray objArr = JSONFactoryUtil.createJSONArray();

        String objResponse = StringPool.BLANK;
        try {
            UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
            File file1 = uploadRequest.getFile("myFile");
            String fileName = uploadRequest.getFileName("myFile");

            String downloadUrlPattern = StringPool.BLANK;
            JSONObject obj1 = JSONFactoryUtil.createJSONObject();
            String modelName = request.getParameter("formType").toLowerCase();
            String subUrl = modelName + "/batchUpload";
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

    public String handleBatchUploadFile(ActionRequest request, ActionResponse response) {

        JSONObject retObj = JSONFactoryUtil.createJSONObject();
        JSONArray objArr = JSONFactoryUtil.createJSONArray();

        String objResponse = StringPool.BLANK;
        try {
            UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
            File file1 = uploadRequest.getFile("myFile");
            String fileName = uploadRequest.getFileName("myFile");

            String downloadUrlPattern = StringPool.BLANK;
            JSONObject obj1 = JSONFactoryUtil.createJSONObject();
            String modelName = uploadRequest.getParameter("formType").toLowerCase();
            String subUrl = modelName + "/batchUpload";

            objResponse = new APICall(request).uploadObjectNew(file1, fileName, subUrl, downloadUrlPattern);
            _log.debug(objResponse);
            if (Validator.isNotNull(objResponse)) {
                objArr.put(JSONFactoryUtil.createJSONObject(objResponse));

            } else {
                obj1.put("error", "Error uploading the file.");
                objArr.put(obj1);
            }

        } catch (JSONException e1) {
            _log.error(e1);
            retObj = JSONFactoryUtil.createJSONObject();
            retObj.put("error", "Error uploading the file.");
            objArr.put(retObj);
        }
        retObj.put("result", objArr);
        retObj.put("data", objArr.getJSONObject(0));
        objResponse = retObj.toString();
        return objResponse;
    }

    public String getCellValue(Cell cell) {
        String returnString = StringPool.BLANK;
        if (cell != null) {
            returnString = cell.toString();
        }
        return returnString;
    }
}