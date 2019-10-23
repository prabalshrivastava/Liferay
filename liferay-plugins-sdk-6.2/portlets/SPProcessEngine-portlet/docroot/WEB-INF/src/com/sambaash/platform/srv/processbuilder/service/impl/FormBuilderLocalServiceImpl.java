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

package com.sambaash.platform.srv.processbuilder.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.VirtualHost;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.service.VirtualHostLocalServiceUtil;
import com.sambaash.platform.constant.FormConstants;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.pe.jaxb.PEForm;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.srv.processbuilder.service.base.FormBuilderLocalServiceBaseImpl;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the form builder local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.processbuilder.service.FormBuilderLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.srv.processbuilder.service.base.FormBuilderLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.processbuilder.service.FormBuilderLocalServiceUtil
 */
public class FormBuilderLocalServiceImpl extends FormBuilderLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.processbuilder.service.FormBuilderLocalServiceUtil} to access the form builder local service.
	 */
	
	private String getUrlParameter(String name){
		String param = SambaashUtil.getParameter(name, SambaashConstants.DEFAULT_GROUP_ID_LONG);
		if(Validator.isNull(param)){
			// Log the error
			_log.error("**Form Url Parameter is Null**. Name =" + name);
		}
		return param;
	}
	/**
	 *  Returns the URL to fetch form schema for single form.
	 *  URL will have place holders for params required by form builder 
	 * @return
	 */
	public String getUrlTemplateFormSchema(){
		return getUrlParameter(SambaashConstants.API_FORM_BUILDER_GET_FORM_SCHEMA);
	}
	
	/**
	 * Returns URL to fetch form schema for multiple forms
	 * URL will have place holders for params required by form builder
	 * @return
	 */
	public String getUrlTemplateFormSchemas(){
		return getUrlParameter(SambaashConstants.API_FORM_BUILDER_GET_FORM_SCHEMAS);
	}
	
	/**
	 *  Returns URL to fetch list of form
	 *  URL will have place holders for params required by form builder
	 */
	public String getUrlTemplateFormsList(){
		return getUrlParameter(SambaashConstants.API_FORM_BUILDER_GET_FORM_LIST);
	}

	public String getUrlTemplateFormStorageList(){
		return getUrlParameter(SambaashConstants.API_FORM_BUILDER_GET_FORM_STORAGE_LIST);
	}

	/**
	 * This url template used for loading form which is submitted earlier.
	 * Each submitted form gets storage id.
	 * @return
	 */
	public String getUrlTemplateLoadFormWithStorageId(){
		return getUrlParameter(SambaashConstants.API_FORM_BUILDER_LOAD_FORM_WITH_STORAGE_ID);
	}

	/**
	 * This url template used for loading fresh form
	 * 
	 * @return
	 */
	public String getUrlTemplateLoadFormWithOutStorageId(){
		return getUrlParameter(SambaashConstants.API_FORM_BUILDER_LOAD_FORM_WITHOUT_STORAGE_ID);
	}
	
	/**
	 * Method used to get url for  attachment info
	 * @return
	 */
	public String getUrlTemplateAttachmentSInfo(){
		return getUrlParameter(SambaashConstants.API_FORM_BUILDER_GET_ATTACHMENTS_INFO);
	}
	
	/**
	 * Method to get url for loading the form
	 */
	public String getUrlFormLoad(long formId, long processId, long entityId, long entityClassId){
		String url = getUrlParameter(SambaashConstants.API_FORM_BUILDER_LOAD_FORM);
		url = StringUtil.replace(url, new String[]{"[FORM_ID]","[PROCESS_ID]","[ENTITY_ID]","[ENTITY_CLASS_ID]"}, new String[]{String.valueOf(formId),String.valueOf(processId),String.valueOf(entityId),String.valueOf(entityClassId)});
		return url;
	}
	
	/**
	 * Returns URL to fetch form schema for single form
	 * 
	 * @param applicationId
	 * @param authToke
	 * @param userId
	 * @param formIds
	 * @return
	 */
	public String getUrlFormSchema(String applicationId, String authToke,long userId, long formId){
		String url = getUrlTemplateFormSchema();
		url = StringUtil.replace(url, new String[]{"[APPLICATION_ID]","[AUTHTOKEN]","[USER_ID]","[FORM_ID]"}, new String[]{applicationId,authToke,String.valueOf(userId),String.valueOf(formId)});
		return url;
	}
	/**
	 * Returns URL to fetch form schema for multiple forms
	 * 
	 * @param applicationId
	 * @param authToke
	 * @param userId
	 * @param formIds
	 * @return
	 */
	public String getUrlFormSchemas(String applicationId, String authToke,long userId, String formIds){
		String url = getUrlTemplateFormSchemas();
		url = StringUtil.replace(url, new String[]{"[APPLICATION_ID]","[AUTHTOKEN]","[USER_ID]","[FORM_IDS]"}, new String[]{applicationId,authToke,String.valueOf(userId),formIds});
		return url;
	}

	/**
	 * Returns URL to get list of forms
	 * 
	 * @param applicationId
	 * @param authToke
	 * @param userId
	 * @param formIds
	 * @return
	 */
	public String getUrlFormsList(String applicationId, String authToke,long userId, String hostName){
		String url = getUrlTemplateFormsList();
		url = StringUtil.replace(url, new String[]{"[APPLICATION_ID]","[AUTHTOKEN]","[USER_ID]","[HOST_NAME]"}, new String[]{applicationId,authToke,String.valueOf(userId),hostName});
		return url;
	}

	public String getUrlFormStorageList(String applicationId, String authToke,String storageIds){
		String url = getUrlTemplateFormStorageList();
		url = StringUtil.replace(url, new String[]{"[APPLICATION_ID]","[AUTHTOKEN]","[STORAGE_IDS]"}, new String[]{applicationId,authToke,storageIds});
		return url;
	}
	
	public String getUrlLoadFormWithStorageId(long userId, long formId, long storageId,boolean canEdit,Map<String,String>extraParams){
		String url = getUrlTemplateLoadFormWithStorageId();
		boolean disbaled = !canEdit;
		url = StringUtil.replace(url, new String[]{"[USER_ID]","[FORM_ID]","[STORAGE_ID]","[DISABLED]"}, 
				new String[]{String.valueOf(userId),String.valueOf(formId),String.valueOf(storageId),String.valueOf(disbaled)});
		if(extraParams != null){
			for (Entry<String,String> entry : extraParams.entrySet()) {
				url = HttpUtil.addParameter(url, entry.getKey(), entry.getValue());
			}
		}
		return url;
	}
	public String getUrlLoadFormWithOutStorageId(long formId,Map<String,String>extraParams){
		String url = getUrlTemplateLoadFormWithOutStorageId();
		url = StringUtil.replace(url, new String[]{"[FORM_ID]"}, 
				new String[]{String.valueOf(formId)});
		if(extraParams != null){
			for (Entry<String,String> entry : extraParams.entrySet()) {
				url = HttpUtil.addParameter(url, entry.getKey(), entry.getValue());
			}
		}
		return url;
	}
	
	/**
	 * Url to lock/unlock form.
	 * 
	 */
	public String getUrlLockForm(){
		return getUrlParameter(SambaashConstants.API_FORM_BUILDER_LOCK_FORM);
	}	
	
	/**
	 * Url to add form data.
	 * 
	 */
	public String getUrlAddFormData(){
		return getUrlParameter(SambaashConstants.API_FORM_BUILDER_ADD_FORM_DATA);
	}
	/**
	 * Url to add multipart form data.
	 * 
	 */
	public String getUrlAddFormDataMultipart(){
		return getUrlParameter(SambaashConstants.API_FORM_BUILDER_ADD_FORM_DATA_MULTIPART);
	}
	public String getUrlAddFormDataMultipartBulkUpload(){
		return getUrlParameter(SambaashConstants.API_FORM_BUILDER_ADD_FORM_DATA_MULTIPART_BULK_UPLOAD);
	}
	public String getUrlAttachmentPrefix(){
		return getUrlParameter(SambaashConstants.API_FORM_BUILDER_GET_ATTACHMENT_URL_PREFIX);
	}

	public String getUrlAttachmentSInfo(String applicationId, String authToke,long userId, long storageId){
		String url = getUrlTemplateAttachmentSInfo();
		url = StringUtil.replace(url, new String[]{"[APPLICATION_ID]","[AUTHTOKEN]","[USER_ID]","[STORAGE_ID]"}, new String[]{applicationId,authToke,String.valueOf(userId),String.valueOf(storageId)});
		return url;
	}
	
	public String constructAttachmentUrl(String prefix,String suffix){
		//String prefix = getUrlAttachmentPrefix();
		String url = StringPool.BLANK;
		if(prefix.endsWith(StringPool.FORWARD_SLASH)){
			url = prefix + suffix;
		}else{
			url = prefix + StringPool.FORWARD_SLASH + suffix;
		}
		return url;
	}
	
	public String getAttachmentSInfo(long userId, long storageId){
		RestTemplate restTemplate = new RestTemplate();
		String response = StringPool.BLANK;
		try {
			//TODO: Hardcoded. Have to replace with correct solution
			String applicaitonId = "4687559";
			String authToken = "app-form-v1";
			
			String url = getUrlAttachmentSInfo(applicaitonId,authToken,userId,storageId);
			
		    response = restTemplate.getForEntity(url, String.class).getBody();
		    
		} catch (Exception e) {
			_log.error(e);
		}
		return response;
	}
	
	/**
	 *  Method used to submit data to form builder.
	 *  
	 *  Usually data submission happens from web-browser where undlying javascript will create required json format and submits the request to formbuilder directly.
	 *  Below method is useful when we want to submit request from server side.
	 *  
	 *  Submitting the forms does not have any uploads.(input type =file)
	 *  
	 * 
	 * @param formId
	 * @param json
	 * @param userId
	 * @return
	 */
	public String submitFormData(long formId,String json,long userId){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("applicationId","forms-app-v1" );
		map.add("authToken",String.valueOf(4687559) );
		map.add("formId",String.valueOf(formId) );
		map.add("formData",json );
		map.add("userId", String.valueOf(userId) );

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.postForEntity( getUrlAddFormData(), request , String.class );
		
		return response.getBody();
	}
	
	/**
	 *  Method used to lock form.
	 *  
	 * 
	 * @param formId
	 * @param lock
	 * @param userId
	 * @return
	 */
	public String submitFormData(long formId, Boolean lock,long userId){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("applicationId","forms-app-v1" );
		map.add("authToken",String.valueOf(4687559) );
		map.add("formId",String.valueOf(formId) );
		map.add("lock",String.valueOf(lock));
		map.add("userId", String.valueOf(userId) );

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.postForEntity( getUrlLockForm(), request , String.class );
		
		return response.getBody();
	}
	
	
	/**
	 *  Method used to submit data to form builder.
	 *  
	 *  Usually data submission happens from web-browser where undlying javascript will create required json format and submits the request to formbuilder directly.
	 *  Below method is useful when we want to submit request from server side.
	 *  
	 *  Submitting the multipart form data
	 *  
	 * 
	 * @param formId
	 * @param json
	 * @param userId
	 * @param filesList  - list of files to be uploaded. Key is field Id
	 * @return
	 */
	public  String submitFormDataMultipart(long formId,String json,long userId, Map<String,File> filesList) throws FileNotFoundException{
		 HttpHeaders headers = new HttpHeaders();
       headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		
		MultiValueMap<String, Object> map= new LinkedMultiValueMap<String, Object>();
		map.add("formId",String.valueOf(formId) );
		map.add("hdnjson",json );
		map.add("userId", String.valueOf(userId) );
		map.add("applicationId","forms-app-v1" );
		map.add("authToken",String.valueOf(4687559) );
		
		//TODO: InputStreamResource is not working hence using FileSystemResource
		//InputStreamResource resource = new InputStreamResource(new FileInputStream(new File("/Users/nareshchebolu/Downloads/SLA_Report_sambaash Mar 2016.xls")));
		//map.add("file_10",   resource);
		for (Entry<String,File> entry : filesList.entrySet()) {
			map.add(entry.getKey(), new FileSystemResource(entry.getValue()));
		}
		
		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String,Object>>(map, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		String url = getUrlAddFormDataMultipart(); 
		ResponseEntity<String> response = restTemplate.postForEntity(url , request , String.class );
		
		return response.getBody();
	}
	
	
	/**
	 *  Method used to submit data to form builder.File upload field can be either single or multiple file 
	 *  
	 *  Usually data submission happens from web-browser where undlying javascript will create required json format and submits the request to formbuilder directly.
	 *  Below method is useful when we want to submit request from server side.
	 *  
	 *  Submitting the multipart form data
	 *  
	 * 
	 * @param formId
	 * @param json
	 * @param userId
	 * @param filesList  - list of files to be uploaded. Key is field Id
	 * @return
	 */
	public  String submitFormDataMultipartMultipleFiles(long formId,String json,long userId, Map<String,List<File>> filesList) throws FileNotFoundException{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		
		
		MultiValueMap<String, Object> map= new LinkedMultiValueMap<String, Object>();
		map.add("formId",String.valueOf(formId) );
		map.add("hdnjson",json );
		map.add("userId", String.valueOf(userId) );
		map.add("applicationId","forms-app-v1" );
		map.add("authToken",String.valueOf(4687559) );
		
		//TODO: InputStreamResource is not working hence using FileSystemResource
		//InputStreamResource resource = new InputStreamResource(new FileInputStream(new File("/Users/nareshchebolu/Downloads/SLA_Report_sambaash Mar 2016.xls")));
		//map.add("file_10",   resource);
		for (Entry<String,List<File>> entry : filesList.entrySet()) {
			 String fieldId = entry.getKey();
			 List<File>fileList = entry.getValue();
			 for (File file : fileList) {
				 map.add(fieldId, new FileSystemResource(file));
			}
		}
		
		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String,Object>>(map, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		String url = getUrlAddFormDataMultipart(); 
		ResponseEntity<String> response = restTemplate.postForEntity(url , request , String.class );
		
		return response.getBody();
	}
	
	
	/**
	 *  Method used to submit data to form builder.
	 *  
	 *  Usually data submission happens from web-browser where undlying javascript will create required json format and submits the request to formbuilder directly.
	 *  Below method is useful when we want to submit request from server side.
	 *  
	 *  Submitting the multipart form data
	 *  
	 * 
	 * @param formId
	 * @param json
	 * @param userId
	 * @param filesList  - list of files to be uploaded. Key is field Id
	 * @return
	 */
	public  String submitFormDataMultipartBulkRegistration(long processId, long entityClassId, long formId, long userId, File file) throws FileNotFoundException{
		 HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		
		MultiValueMap<String, Object> map= new LinkedMultiValueMap<String, Object>();
		map.add("userId", String.valueOf(userId) );
		map.add("applicationId","forms-app-v1" );
		map.add("authToken",String.valueOf(4687559) );
		map.add("processId", processId );
		map.add("formId", formId );
		map.add("entityClassId", entityClassId );	
		map.add("entityId", "" );
		map.add("countryName", "" );
		map.add("source", "" );
		map.add("url", "" );
		
		
		//TODO: InputStreamResource is not working hence using FileSystemResource
		//InputStreamResource resource = new InputStreamResource(new FileInputStream(new File("/Users/nareshchebolu/Downloads/SLA_Report_sambaash Mar 2016.xls")));
		//map.add("file_10",   resource);
		map.add("uploadFile", new FileSystemResource(file));
		
		
		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String,Object>>(map, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		String url = getUrlAddFormDataMultipartBulkUpload(); 
		ResponseEntity<String> response = restTemplate.postForEntity(url , request , String.class );
		
		return response.getBody();
	}
	
	/**
	 *  Method used to return form schema for given form id
	 * 
	 * @param userId
	 * @param formId
	 * @return
	 */
	public JSONArray getFormSchema(long userId,long formId){
		JSONArray response = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			//TODO: Hardcoded. Have to replace with correct solution
			String applicaitonId = "app-form-v1";
			String authToken = "1231";
			
			String url = getUrlFormSchema(applicaitonId,authToken,userId, formId);
			
		    String str = restTemplate.getForEntity(url, String.class).getBody();
		    JSONObject formSchema = JSONFactoryUtil.createJSONObject(str);
		    
		    response = JSONFactoryUtil.createJSONArray(formSchema.getString(FormConstants.KEY_HTML_FORM_SCHEMA));
		    
		} catch (Exception e) {
			
			response = JSONFactoryUtil.createJSONArray();
		}
		return response;
	}
	
	/**
	 *  Method used to return form schema for multple form ids
	 * 
	 * @param userId
	 * @param formIdsCommaSeparated comma separated ids
	 * @return
	 */
	public JSONArray getFormSchemas(long userId,String formIdsCommaSeparated){
		JSONArray response = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			//TODO: Hardcoded. Have to replace with correct solution
			String applicaitonId = "app-form-v1";
			String authToken = "1231";
			
			String url = getUrlFormSchemas(applicaitonId,authToken,userId, formIdsCommaSeparated);
			
			String str = restTemplate.getForEntity(url, String.class).getBody();
			
			response = JSONFactoryUtil.createJSONArray(str);
			
		} catch (Exception e) {
			_log.error(e);
			response = JSONFactoryUtil.createJSONArray();
		}
		return response;
	}
	/**
	 * Method used to fetch form storages for given storage ids
	 */
	public JSONArray getFormStorages(String storageIdsCommaSeparated){
		JSONArray response = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			//TODO: Hardcoded. Have to replace with correct solution
			String applicaitonId = "app-form-v1";
			String authToken = "1231";
			
			String url = getUrlFormStorageList(applicaitonId, authToken, storageIdsCommaSeparated);
			
			String str = restTemplate.getForEntity(url, String.class).getBody();
			
			response = JSONFactoryUtil.createJSONArray(str);
			
		} catch (Exception e) {
			_log.error(e);
			response = JSONFactoryUtil.createJSONArray();
		}
		return response;
	}
	/**
	 * To get list of forms available in form builder
	 * 
	 * @param userId
	 * @param formIds
	 * @return
	 */
	public JSONArray getFormsList(long userId){
		JSONArray response = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			//TODO: Hardcoded. Have to replace with correct solution
			String applicaitonId = "app-form-v1";
			String authToken = "=B^DF56@FRED";
			String hostName = StringPool.BLANK;
			try {
				VirtualHost vh = VirtualHostLocalServiceUtil.getVirtualHost(CompanyThreadLocal.getCompanyId(), 0);
				hostName = vh.getHostname();
			}catch (Exception e) {
				
			}
			String url = getUrlFormsList(applicaitonId,authToken,userId, hostName);
			String str = restTemplate.getForEntity(url, String.class).getBody();
			
			response = JSONFactoryUtil.createJSONArray(str);
			
		} catch (Exception e) {
			_log.error(e);
			response = JSONFactoryUtil.createJSONArray();
		}
		return response;
	}
	public JSONArray getFormsListV2(){
		JSONArray response = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			//TODO: Hardcoded. Have to replace with correct solution //.API_FORM_BUILDER_V2_BASEURL
			String url = SambaashUtil.getFormV2BaseUrl() + "/systemtemplate/list?applicationId=app-form-v2";
//			String url = "https://api.forms.sambaash.com/v2/forms/systemtemplate/list?applicationId=app-form-v2";
			String str = restTemplate.getForEntity(url, String.class).getBody();
			response = JSONFactoryUtil.createJSONArray(str);
			
		} catch (Exception e) {
			_log.error(e);
			response = JSONFactoryUtil.createJSONArray();
		}
		return response;
	}
	
	/*
	 * Can generically use to retrieve data list response from Forms V2 controller.
	 * Example:  getV2FormsArrayData("/list") to retrieve all the v2 forms for this project
	 */
	public JSONArray getV2FormsArrayData(String requestMappingUrl, Map<String, String> params){
		JSONArray response = null;
		String url = getUrlParameter("sp.microservice.form.baseurl") + requestMappingUrl;
		RestTemplate restTemplate = new RestTemplate();
		try {
			HttpEntity<?> request;
			if (params != null && params.size() > 0) {
				request = newRequestWithParamsAndToken(params);
			} else {
				request = newRequestWithToken();
			}
			
			String str = restTemplate.exchange(url, HttpMethod.GET, request, String.class).getBody();
			response = JSONFactoryUtil.createJSONArray(str);
		} catch (Exception e) {
			_log.error("Error invoking "+url, e);
			response = JSONFactoryUtil.createJSONArray();
		}
		return response;
	}
	
	public JSONObject getV2FormsData(String requestMappingUrl, Map<String, String> params){
		JSONObject response = null;
		String url = getUrlParameter("sp.microservice.form.baseurl") + requestMappingUrl;
		RestTemplate restTemplate = new RestTemplate();
		try {
			HttpEntity<?> request;
			if (params != null && params.size() > 0) {
				request = newRequestWithParamsAndToken(params);
			} else {
				request = newRequestWithToken();
			}
			
			String str = restTemplate.exchange(url, HttpMethod.GET, request, String.class).getBody();
			response = JSONFactoryUtil.createJSONObject(str);
		} catch (Exception e) {
			_log.error("Error invoking "+url, e);
			response = JSONFactoryUtil.createJSONObject();
		}
		return response;
	}
	
	private HttpEntity<String> newRequestWithToken() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.set("Authorization", "Bearer "+getUrlParameter("sp.microservice.token"));

		return new HttpEntity<String>(headers);
	}
	
	private HttpEntity<MultiValueMap<String, String>> newRequestWithParamsAndToken(Map<String, String> params) {
		MultiValueMap paramMap = new LinkedMultiValueMap<String, String>();
		paramMap.putAll(params);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.set("Authorization", "Bearer "+getUrlParameter("sp.microservice.token"));
		
		return new HttpEntity<MultiValueMap<String, String>>(paramMap, headers);
	}
	
	
	public JSONObject createFormCopy(String formId){
		JSONObject response = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			String applicationId = "app-form-v2";
			String authToken = "=B^DF56@FRED";
			String url = SambaashUtil.getFormV2BaseUrl() + "/systemtemplate/copy?applicationId="+applicationId+"&authToken=="+authToken+"&formId="+formId+"&virtualHost=Lithan";
			String str = restTemplate.getForEntity(url, String.class).getBody();
			response = JSONFactoryUtil.createJSONObject(str);
			
		} catch (Exception e) {
			_log.error(e);
			response = JSONFactoryUtil.createJSONObject();
		}
		return response;
	}
	
	private static final Log _log = LogFactoryUtil.getLog(FormBuilderLocalServiceImpl.class);
}