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

package com.sambaash.platform.attendance.service.impl;

import java.io.File;
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
import java.util.Scanner;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.attendance.service.base.SPAttendenceLocalServiceBaseImpl;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.constant.SystemSetupConstants;
import com.sambaash.platform.model.microservicemodel.MicroServiceModel;
import com.sambaash.platform.service.FetchLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPListType;
import com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the s p attendence local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.attendance.service.SPAttendenceLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author keyur.kalariya
 * @see com.sambaash.platform.attendance.service.base.SPAttendenceLocalServiceBaseImpl
 * @see com.sambaash.platform.attendance.service.SPAttendenceLocalServiceUtil
 */
public class SPAttendenceLocalServiceImpl extends SPAttendenceLocalServiceBaseImpl {
    private static final String CACHE_CONTROL_PROP = "max-age=00, must-revalidate";

    private static final String ERROR = "error";
    private static final String FUNC_COMP_KEY = "finance.referencenumber.functionalcomponent";
    private static final String PRODUCT_SUB_TYPE = "ProductSubType";
    private static final String PRODUCT_TYPE = "ProductType";
    private static final String FUNC_COMP = "FunctionalComponent";
    private static final String CATEGORY_TYPE = "CategoryType";

    private static final Log _log = LogFactoryUtil.getLog(SPAttendenceLocalServiceImpl.class);
    private static String formStorageId = "formStorageId";
    private static String formType = "formType";
    private static String restUriGet = "/get/";
    private static String requestURL = "Request URL";
	private static String formTypeStr = "formType";


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

        public APICall(long userId, long siteId) throws PortalException {
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
    }


    public String updateRecord(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

        String response = StringPool.BLANK;
        try {
            String storageId = resourceRequest.getParameter(formStorageId);
            String modeldata = resourceRequest.getParameter("data");
            String model = resourceRequest.getParameter(formType).toLowerCase();
            String subUrl = model + restUriGet + storageId;
            String existingData = new APICall(resourceRequest).exchange(subUrl, HttpMethod.PUT);

            String apiModelData = convertToAPIModel(resourceRequest, modeldata, existingData);
            URI uriStorageId = URI.create(storageId);
            subUrl = model + "/edit/" + uriStorageId;
            response = new APICall(resourceRequest).putForObject(apiModelData, subUrl);
        } catch (Exception e) {
            _log.error(e);
        }
        return response;
    }

    public String scannedDataRecord(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
        String response = StringPool.BLANK;
        try {
            String modeldata = resourceRequest.getParameter("data");
            org.json.JSONObject jsonObj = new org.json.JSONObject(modeldata);
            String model = jsonObj.getString("formType");
            String subUrl = model + restUriGet + "-1";
            //String existingData = new APICall(resourceRequest).exchange(subUrl, HttpMethod.GET);

           // String apiModelData = convertToAPIModel(resourceRequest, modeldata, existingData);
            subUrl = "attendance" + "/edit";
//            response = new APICall(resourceRequest).postForObject(jsonObj.toString(), subUrl);
            response = new APICall(resourceRequest).postForObject(jsonObj.toString(), subUrl);
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
            // _log.error(e);
            response = e.toString();
        }
        return (Arrays.asList(tempArray));

    }

    public String convertToAPIModel(ResourceRequest resourceRequest, String modelData, String existingData)
            throws JSONException {
        JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(modelData);
        JSONObject jsonModelExistingData = JSONFactoryUtil.createJSONObject(existingData);

        return FormIOToModelJSON(resourceRequest, jsonModelData, jsonModelExistingData).toString();

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

    private static List<Role> getUserGroupRolesOfUser(long userId) throws SystemException {

        List<Role> roles = RoleLocalServiceUtil.getUserRoles(userId);

        return roles;
    }

    public String generateReferenceNumber(long scopeGroupId, String productType, String productSubType,
            String functionalComponent, String categoryType, String clientType) {
        String errorMsg = StringPool.BLANK;
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
    
    public String getElasticsearchData(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = "";
		try {
			PortletPreferences prefer = resourceRequest.getPreferences();
			String selectedUserType = prefer.getMap().get("selectedUserType")[0];
			_log.error("selectedUserType --> " + selectedUserType);
			String data = resourceRequest.getParameter("data");
			org.json.JSONObject modeldata = new org.json.JSONObject(data);
			
			org.json.JSONArray filterdata = modeldata.getJSONArray("filterdata");
			
			try{
				if(filterdata.length() > 0 && filterdata.get(0) instanceof String)
				{
					String fileDataString = filterdata.getString(0);
					if(!fileDataString.equalsIgnoreCase("undefined"))
					{
						modeldata.put("filters", new org.json.JSONArray().put(new org.json.JSONObject(fileDataString)));
					}
					else
					{
						modeldata.put("filters", new org.json.JSONArray());
					}
				}
				else{
					modeldata.put("filters", filterdata);
				}
			}catch(Exception e)
			{
				_log.error(e);
			}
			
			if(selectedUserType.equals("Invigilator"))
			{
				org.json.JSONArray filters = modeldata.getJSONArray("filters");
				org.json.JSONObject AppointmentType = new org.json.JSONObject();
				org.json.JSONArray AppointmentTypeArray = new org.json.JSONArray();
				AppointmentTypeArray.put("Invigilator");
				AppointmentType.put("contentJson.AppointmentType", AppointmentTypeArray);
				filters.put(AppointmentType);
				modeldata.put("filters", filters);
			}
			else if(selectedUserType.equals("Candidate"))
			{
				org.json.JSONArray filters = modeldata.getJSONArray("filters");
				org.json.JSONObject AppointmentType = new org.json.JSONObject();
				org.json.JSONArray AppointmentTypeArray = new org.json.JSONArray();
				AppointmentTypeArray.put("Candidate");
				AppointmentType.put("contentJson.AppointmentType", AppointmentTypeArray);
				filters.put(AppointmentType);
				modeldata.put("filters", filters);
			}
			modeldata.remove("filterdata");
			String model = resourceRequest.getParameter(formType).toLowerCase();
			String subUrl = model + "/elasticsearch?size="+modeldata.getString("limit")+"&page="+modeldata.getString("page");


			response = new APICall(resourceRequest).postForObject(modeldata.toString(), subUrl);
		} catch (Exception e) {
			_log.error(e);
		}
		return response;

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

    public String fetchExamDocketUserListing(long userId, long siteId, String condition) {

        String model = "attendance";
        String response = null;
        try {
            String subUrl = model + "/search?" + condition;
            response = new APICall(userId, siteId).exchange(subUrl, HttpMethod.GET);
        } catch (Exception e) {
            _log.error(e);
            response = ERROR;
        }
        return response;
    }

    private SPListType getSpListTypeByDisplayName(String displayName, List<SPListType> spListTypeList) {
        for (SPListType spLT : spListTypeList) {
            if (spLT.getDisplayName().equalsIgnoreCase(displayName)) {
                return spLT;
            }
        }
        return null;
    }

    public void exportPdf(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
        try {
            String data = resourceRequest.getParameter("data");
            String pdfUrl = "attendance" + "/exportpdf";
            new APICall(resourceRequest).downloadPdf(data, pdfUrl, HttpMethod.POST, resourceResponse);
        } catch (Exception e) {
            _log.error(e);
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

	public boolean hasExamDocket(String candidateNumber){
		try {
			String response = null;
			String subUrl = "attendance" + "/hasexamdocket/candidate/" + candidateNumber;
 			response = new APICall(SambaashUtil.getAdminUserId(), 0).exchange(subUrl, HttpMethod.GET);
 			if(response.equalsIgnoreCase("true")){
 				return true;
 			}
		}catch (Exception e) {
			_log.error(e);
			_log.error(e);
		}
		return false;
	}
	
	public String exportExamDocket(String candidateNumber){
		try {
			String subUrl = "attendance" + "/exportexamdocketpdf/" + candidateNumber;
			return  new APICall(SambaashUtil.getAdminUserId(), 0).preparePdf("", subUrl, HttpMethod.GET);
		} catch (Exception e) {
			_log.error(e);
			_log.error(e);
		}
		return null;
	}

	public String findByStorageId(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = StringPool.BLANK;  
		try {
	            String data = resourceRequest.getParameter("data");
	            String subUrl = "attendance" + "/getByStorageId/"+data.replace("\"", "");
	            response= new APICall(resourceRequest).exchange(subUrl,  HttpMethod.GET);
	        } catch (Exception e) {
	            _log.error(e);
	        }
		return response;	
	}

	public String sendNotification(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String response = StringPool.BLANK;  
		try {
	        	String data = resourceRequest.getParameter("data");
				org.json.JSONObject modeldata = new org.json.JSONObject(data);
	            String subUrl = "attendance" + "/sendNotification";
				response = new APICall(resourceRequest).postForObject(modeldata.toString(), subUrl);

	        } catch (Exception e) {
	            _log.error(e);
	        }
		return response;	
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

}