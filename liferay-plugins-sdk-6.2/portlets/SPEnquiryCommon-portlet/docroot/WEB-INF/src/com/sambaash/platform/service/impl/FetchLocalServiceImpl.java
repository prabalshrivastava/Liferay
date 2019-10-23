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

package com.sambaash.platform.service.impl;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.service.base.FetchLocalServiceBaseImpl;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the fetch local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.service.FetchLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author biswo
 * @see com.sambaash.platform.service.base.FetchLocalServiceBaseImpl
 * @see com.sambaash.platform.service.FetchLocalServiceUtil
 */
public class FetchLocalServiceImpl extends FetchLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.service.FetchLocalServiceUtil} to access the fetch
	 * local service.
	 */
	private static final Log _log = LogFactoryUtil.getLog(FetchLocalServiceImpl.class);
	private static String restUriGet = "/get/";

	public long getLoggedInUserId() throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		if (null == serviceContext) {
			_log.warn("ServiceContext is unavailable, returning default user");
			long companyId = PortalUtil.getDefaultCompanyId();
			long defaultUserId = UserLocalServiceUtil.getDefaultUserId(companyId);
			return defaultUserId;
		}

		return serviceContext.getUserId();
	}

	private class APICall {
		long userId = 0;
		long siteId = 0;

		HttpHeaders headers;
		HttpEntity<String> httprequest;
		RestTemplate restTemplate = new RestTemplate();
		String baseUrl = "";

		public APICall(long userId, long siteId) {
			try {
				userId = getLoggedInUserId();
				headers = new HttpHeaders();
				headers.add("X-SCOPEGROUP-ID", "" + SambaashUtil.getScopeGroupId(siteId));
				headers.add("X-USER-ID", "" + userId);
				
				baseUrl = SambaashUtil.getParameter(SambaashConstants.API_STORAGE_ENGINE_BASEURL,
						SambaashConstants.DEFAULT_GROUP_ID_LONG);
			} catch (PortalException | SystemException e1) {
				_log.error(e1);
			}

		}

		private String exchange(String subUrl, HttpMethod method) {
			String response = StringPool.BLANK;
			httprequest = new HttpEntity<>(headers);
			try {
				URI uri = URI.create(baseUrl + subUrl);
				ResponseEntity<String> httpresponse = restTemplate.exchange(uri, method, httprequest, String.class);
				response = httpresponse.getBody();
			} catch (Exception e) {
				_log.error("Request URL : " + baseUrl + subUrl);
				_log.error(e);
			}
			return response;
		}

	}

	public String fetchRecord(String storageId, String model, long userId, long siteId) {
		String response = null;
		String existingData = null;
		try {

			String subUrl = model.toLowerCase() + restUriGet + storageId;
			existingData = new APICall(userId, siteId).exchange(subUrl, HttpMethod.GET);

			response = existingData;
		} catch (Exception e) {
			_log.error(e);
			response = "error";
		}
		return response;
	}

	public String getAllRecord(String modelName, long userId, long siteId) {

		String response = null;
		try {

			String sortByField = "contentJson.Status";

			String subUrl = modelName + "/list?page=0&size=" + 100 + "&sort=" + sortByField;

			response = new APICall(userId, siteId).exchange(subUrl, HttpMethod.GET);

		} catch (Exception e) {
			_log.error(e);
			response = e.toString();
		}
		return response;

	}

}