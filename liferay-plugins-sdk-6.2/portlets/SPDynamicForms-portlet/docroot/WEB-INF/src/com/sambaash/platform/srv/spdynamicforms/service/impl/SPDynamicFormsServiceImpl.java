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

package com.sambaash.platform.srv.spdynamicforms.service.impl;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage;
import com.sambaash.platform.srv.spdynamicforms.service.SPDynamicFormsLocalServiceUtil;
import com.sambaash.platform.srv.spdynamicforms.service.SPFormStorageLocalServiceUtil;
import com.sambaash.platform.srv.spdynamicforms.service.base.SPDynamicFormsServiceBaseImpl;

/**
 * The implementation of the s p dynamic forms remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.spdynamicforms.service.SPDynamicFormsService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author glenn
 * @see com.sambaash.platform.srv.spdynamicforms.service.base.SPDynamicFormsServiceBaseImpl
 * @see com.sambaash.platform.srv.spdynamicforms.service.SPDynamicFormsServiceUtil
 */
public class SPDynamicFormsServiceImpl extends SPDynamicFormsServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.spdynamicforms.service.SPDynamicFormsServiceUtil} to access the s p dynamic forms remote service.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(SPDynamicFormsServiceImpl.class);
			
	public JSONObject persistFormStorage(long userId, long formId, long formStorageId, String jsonString) {
		try {
			return JSONFactoryUtil.createJSONObject(SPDynamicFormsLocalServiceUtil.handlePersist(userId, formId, formStorageId, jsonString));
		} catch (Exception e) {
			LOG.error(e);
			return JSONFactoryUtil.createJSONObject();
		}
	}

	public JSONObject getFormStorage(long formStorageId) {
		try {
			SPFormStorage data = SPFormStorageLocalServiceUtil.getSPFormStorage(formStorageId);
			return JSONFactoryUtil.createJSONObject(data.getContent());
		} catch (Exception e) {
			LOG.error(e);
			return JSONFactoryUtil.createJSONObject();
		}
	}
	
}