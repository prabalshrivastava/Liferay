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

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.model.Role;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.base.FormBuilderServiceBaseImpl;

/**
 * The implementation of the form builder remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.processbuilder.service.FormBuilderService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.srv.processbuilder.service.base.FormBuilderServiceBaseImpl
 * @see com.sambaash.platform.srv.processbuilder.service.FormBuilderServiceUtil
 */
public class FormBuilderServiceImpl extends FormBuilderServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.processbuilder.service.FormBuilderServiceUtil} to access the form builder remote service.
	 */
	
	public String getFormSchema(long userId,long formId){
		return formBuilderLocalService.getFormSchema(userId, formId).toString();
	}
	public String getFormSchemas(long userId,String formIdsCommaSeparated){
		return formBuilderLocalService.getFormSchemas(userId, formIdsCommaSeparated).toString();
	}
	public String getFormsList(long userId){
		return formBuilderLocalService.getFormsList(userId).toString();
	}
	public String getV2FormsList(){
		return formBuilderLocalService.getV2FormsArrayData("/list", null).toString();
	}
	public String getV2FormsSchema(long userId,long formId){
		return formBuilderLocalService.getV2FormsData(String.format("/schema/%d", formId), null).toString();
	}
	public JSONArray getRoles(long companyId) {
		if (companyId==0) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		JSONArray roleList = JSONFactoryUtil.createJSONArray();
		try {
			for(Role r: RoleLocalServiceUtil.getRoles(companyId)) {
				JSONObject o = JSONFactoryUtil.createJSONObject();
				o.put("id", r.getRoleId());
				o.put("name", r.getName());
				roleList.put(o);
			}
		} catch (Exception e) {
			// NOOP
		}
		return roleList;
	}
}