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

package com.sambaash.platform.srv.spservices.service.impl;

import java.util.Date;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.ac.AccessControlled;
import com.sambaash.platform.srv.spdynamicforms.service.SPDynamicFormsServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPUserType;
import com.sambaash.platform.srv.spservices.service.base.SPUserTypeServiceBaseImpl;

/**
 * The implementation of the s p user type remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.spservices.service.SPUserTypeService}
 * interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author glenn
 * @see com.sambaash.platform.srv.spservices.service.base.SPUserTypeServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.SPUserTypeServiceUtil
 */
public class SPUserTypeServiceImpl extends SPUserTypeServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.spservices.service.SPUserTypeServiceUtil} to
	 * access the s p user type remote service.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(SPUserTypeServiceImpl.class);

	@AccessControlled(guestAccessEnabled = true)
	public String saveUserDeclaration(long spUserTypeId, long userId, long formId, String declarationJsonString) {
		try {
			SPUserType spUserType = spUserTypeLocalService.fetchSPUserType(spUserTypeId);
			JSONObject formStorageObj = SPDynamicFormsServiceUtil.persistFormStorage(spUserType.getUserId(), formId, 0, declarationJsonString);
			spUserType.setDeclarationCompleted(true);
			spUserType.setDeclarationDate(new Date().getTime());
			spUserType.setDeclarationStorageId(formStorageObj.getLong("formStorageId"));
			spUserTypeLocalService.updateSPUserType(spUserType);
			return JSONFactoryUtil.looseSerializeDeep(spUserType);
		} catch (Exception e) {
			LOG.error(e);
			return "{}";
		}
	}
}