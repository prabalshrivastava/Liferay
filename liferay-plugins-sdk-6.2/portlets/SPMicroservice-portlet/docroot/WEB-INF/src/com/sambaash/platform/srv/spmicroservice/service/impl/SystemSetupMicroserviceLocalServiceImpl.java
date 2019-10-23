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
import com.liferay.portal.kernel.json.JSONObject;
import com.sambaash.platform.spmicroservice.api.wrapper.ems.EmsMicroservice;
import com.sambaash.platform.srv.spmicroservice.service.base.SystemSetupMicroserviceLocalServiceBaseImpl;

/**
 * The implementation of the system setup microservice local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.spmicroservice.service.SystemSetupMicroserviceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author glenn
 * @see com.sambaash.platform.srv.spmicroservice.service.base.SystemSetupMicroserviceLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spmicroservice.service.SystemSetupMicroserviceLocalServiceUtil
 */
public class SystemSetupMicroserviceLocalServiceImpl
	extends SystemSetupMicroserviceLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.spmicroservice.service.SystemSetupMicroserviceLocalServiceUtil} to access the system setup microservice local service.
	 */

	public JSONArray getPostalAddress(String countryCode, String postalCode) {
		EmsMicroservice service = new EmsMicroservice("system");
		return service.getPostalAddress(countryCode, postalCode);
	}
	
	public JSONObject updateContentJson(long scopeGroupId, String modelName, String storageId, String patchJsonString) {
		EmsMicroservice service = new EmsMicroservice(scopeGroupId);
		return service.updateContentJson(modelName, storageId, patchJsonString);
	}
	
}