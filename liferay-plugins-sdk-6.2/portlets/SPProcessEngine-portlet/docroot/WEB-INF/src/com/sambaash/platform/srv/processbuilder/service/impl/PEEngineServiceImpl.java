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

import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.servlet.ProcessServlet;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStage;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEEngineLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStageLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.base.PEEngineServiceBaseImpl;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * The implementation of the p e engine remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.processbuilder.service.PEEngineService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.srv.processbuilder.service.base.PEEngineServiceBaseImpl
 * @see com.sambaash.platform.srv.processbuilder.service.PEEngineServiceUtil
 */
public class PEEngineServiceImpl extends PEEngineServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.processbuilder.service.PEEngineServiceUtil} to access the p e engine remote service.
	 */
	
	private static Log _log = LogFactoryUtil.getLog(PEEngineServiceImpl.class);
	
	public void runProcessEngineUsingFormId(long classNameId,long classPK,long processId, long formId, String formData,Map<String,String[]> params){
		_log.debug("Start runProcessEngineUsingFormId : classNameId : " + classNameId + " : classPK : " + classPK + " : processId : " + processId + " : formId : " + formId + " : params : " + params + " : formData : " + formData);
		PEEngineLocalServiceUtil.runProcessEngineUsingFormId(classNameId,classPK, processId, formId, formData,params);
	}
	public void runPEProductApp(long classNameId,long classPK,long processId, long formId,String countryName, String formData){
		_log.debug("Start runPEProductApp : classNameId : " + classNameId + " : classPK : " + classPK + " : processId : " + processId + " : formId : " + formId + " : countryName : " + countryName + " : formData : " + formData);
		PEEngineLocalServiceUtil.runProcessEngineProductApp(classNameId,classPK, processId, formId, countryName, formData);
	}
	public void runPEProductAppDefaultEntity(long classNameId,long processId, long formId,String countryName, String formData){
		_log.debug("Start runPEProductAppDefaultEntity : classNameId : " + classNameId + " : processId : " + processId + " : formId : " + formId + " : countryName : " + countryName + " : formData : " + formData);
		PEEngineLocalServiceUtil.runProcessEngineProductApp(classNameId,1, processId, formId, countryName, formData);
	}
	
	public String helloWorld(String worldName) {
	    return "Hello world: " + worldName;
	}
	public String helloWorld2(String worldName) {
		return "Hello world2: " + worldName;
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public JSONObject runCheckForPreviousSubmissions(long loggedInUserId, String emailAddress, long processId, long entityClassId, long entityId) {
		_log.debug("Start PECheckForPreviousSubmissions : loggedInUserId : " + loggedInUserId + " emailAddress : " + emailAddress + " : processId : " + processId + " : entityClassId : " + entityClassId + " : entityId : " + entityId);
		return PEProcessStateLocalServiceUtil.checkForPreviousSubmissions(loggedInUserId, emailAddress,processId, entityClassId, entityId);
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public JSONObject fetchStateData(long processStateId) {
		_log.debug("Start fetchStateData : processStateId : " + processStateId);
		JSONObject json = JSONFactoryUtil.createJSONObject();
		try{
			if (Validator.isNotNull(processStateId) && processStateId > 0){
				json = JSONFactoryUtil.createJSONObject(PEProcessStateLocalServiceUtil.fetchPEProcessState(processStateId).getData());
				return json;
			} else{
				return json;
			}
		}
		catch(Exception e){
			return json;
		}
	}
	
	public JSONArray getProcessDefinitions() {
		JSONArray arr = JSONFactoryUtil.createJSONArray();
		try {
			List<PEProcess> processes = PEProcessLocalServiceUtil.getPEProcesses(-1, -1);
		  	for (PEProcess process :processes) {
		  		JSONObject p = JSONFactoryUtil.createJSONObject();
		  		p.put("id", process.getSpPEProcessId());
		  		p.put("name", process.getName());
		  		arr.put(p);
		  	}			
		} catch (Exception e) {
			_log.error("Error fetching process definitions", e);
		}
		return arr;
	}

	public JSONArray getProcessStages() {
		JSONArray arr = JSONFactoryUtil.createJSONArray();
		try {
			List<PEProcessStage> stages = PEProcessStageLocalServiceUtil.getPEProcessStages(-1, -1);
		  	for (PEProcessStage stage :stages) {
		  		JSONObject s = JSONFactoryUtil.createJSONObject();
		  		s.put("id", stage.getSpPEProcessStageId());
		  		s.put("name", stage.getName());
		  		arr.put(s);
		  	}			
		} catch (Exception e) {
			_log.error("Error fetching process stages", e);
		}
		return arr;
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getUserApplications(String userEmail, long processId, long entityClassId, long entityId, int activeStatus) {
		try {
			User u = UserLocalServiceUtil.fetchUserByEmailAddress(CompanyThreadLocal.getCompanyId(), userEmail);
			if (u==null) {
				_log.debug("No user with email address "+userEmail);
				return JSONFactoryUtil.createJSONArray();
			}
			return JSONFactoryUtil.createJSONArray(JSONFactoryUtil.looseSerializeDeep(PEProcessStateLocalServiceUtil.findByuserIdProcessAndPEProcessIdAndEntityClassIdAndEntityIdAndActiveStatus(u.getUserId(), processId, entityClassId, entityId, activeStatus)));			
		} catch (Exception e) {
			_log.error("Error retrieving user process applications", e);
			return JSONFactoryUtil.createJSONArray();
		}
	}
}