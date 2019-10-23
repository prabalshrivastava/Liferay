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

import java.util.Collections;
import java.util.List;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.sambaash.platform.spmicroservice.api.wrapper.SecurityMicroservice;
import com.sambaash.platform.srv.spmicroservice.service.base.SPMicroserviceLocalServiceBaseImpl;

/**
 * The implementation of the s p microservice local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.spmicroservice.service.SPMicroserviceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author glenn
 * @see com.sambaash.platform.srv.spmicroservice.service.base.SPMicroserviceLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spmicroservice.service.SPMicroserviceLocalServiceUtil
 */
public class SPMicroserviceLocalServiceImpl
	extends SPMicroserviceLocalServiceBaseImpl {
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.spmicroservice.service.SPMicroserviceLocalServiceUtil} to access the s p microservice local service.
	 */

	private SecurityMicroservice securityService = new SecurityMicroservice();

	public String getServiceAccessToken(String clientId, String clientSecret) {
		return securityService.getServiceAccessToken(clientId,  clientSecret);
	}
	
	public List<AssetCategory> getVocabularyCategories(long vocabularyId, int start, int end) {
		try {
			return AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabularyId, start, end, null);
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}
}