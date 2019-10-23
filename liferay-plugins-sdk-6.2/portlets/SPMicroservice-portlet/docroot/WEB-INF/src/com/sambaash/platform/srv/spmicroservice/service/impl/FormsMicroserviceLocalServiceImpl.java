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

package com.sambaash.platform.srv.spmicroservice.service.impl;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.sambaash.platform.spmicroservice.api.wrapper.FormMicroservice;
import com.sambaash.platform.srv.spmicroservice.service.base.FormsMicroserviceLocalServiceBaseImpl;

/**
 * The implementation of the forms microservice local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.spmicroservice.service.FormsMicroserviceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author glenn
 * @see com.sambaash.platform.srv.spmicroservice.service.base.FormsMicroserviceLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spmicroservice.service.FormsMicroserviceLocalServiceUtil
 */
public class FormsMicroserviceLocalServiceImpl
	extends FormsMicroserviceLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.spmicroservice.service.FormsMicroserviceLocalServiceUtil} to access the forms microservice local service.
	 */
	private FormMicroservice formService = new FormMicroservice();
	
	public JSONArray getFormListing() {
		return formService.getFormListing();
	}	

	public JSONObject getForm(long formId) {
		return formService.getForm(formId);
	}	

	public JSONArray getFormFields(long formId, boolean includeLayout, boolean fullInfo) {
		return formService.getFormFields(formId, includeLayout, fullInfo);
	}

	public void synchroniseRole(long groupId, long roleId, String roleName) {
		formService.synchroniseRole(groupId, roleId, roleName);
	}

	public void addFormEvent(String action, String description) {
	    JSONObject eventJson = JSONFactoryUtil.createJSONObject();
	    eventJson.put("actionToDo", action);
	    eventJson.put("description", description);		
		formService.addFormEvent(eventJson);
	}	
}