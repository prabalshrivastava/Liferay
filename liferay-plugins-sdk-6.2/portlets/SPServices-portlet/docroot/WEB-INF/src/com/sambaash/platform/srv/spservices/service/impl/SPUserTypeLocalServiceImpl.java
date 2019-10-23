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

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.model.VirtualHost;
import com.liferay.portal.service.VirtualHostLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException;
import com.sambaash.platform.srv.spservices.model.SPSite;
import com.sambaash.platform.srv.spservices.model.SPSiteSetup;
import com.sambaash.platform.srv.spservices.model.SPUserType;
import com.sambaash.platform.srv.spservices.model.SPUserTypeConfig;
import com.sambaash.platform.srv.spservices.service.SPSiteLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPSiteSetupLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPUserTypeConfigLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPUserTypeLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.base.SPUserTypeLocalServiceBaseImpl;
import com.sambaash.platform.srv.spservices.service.persistence.SPUserTypeUtil;

/**
 * The implementation of the s p user type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.spservices.service.SPUserTypeLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.spservices.service.base.SPUserTypeLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.SPUserTypeLocalServiceUtil
 */
public class SPUserTypeLocalServiceImpl extends SPUserTypeLocalServiceBaseImpl {

	private static Log _log = LogFactoryUtil.getLog(SPUserTypeLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.spservices.service.SPUserTypeLocalServiceUtil}
	 * to access the s p user type local service.
	 */

	public List<SPUserType> findBySpSiteId(long spSiteId) throws SystemException {
		return SPUserTypeUtil.findBySpSiteId(spSiteId);
	}

	public List<SPUserType> findBySpSiteIdAndUserTypeId(long spSiteId, long userTypeId) throws SystemException {
		return SPUserTypeUtil.findBySpSiteIdAndUserTypeId(spSiteId, userTypeId);
	}

	public SPUserType findBySpSiteIdAndUserIdAndUserTypeId(long spSiteId, long userId, long userTypeId) {
		try {
			return SPUserTypeUtil.findBySpSiteIdAndUserIdAndUserTypeId(spSiteId, userId, userTypeId);
		} catch (NoSuchSPUserTypeException | SystemException e) {
			_log.error(String.format("Unable to find by spSiteId %s , userId %s , userTypeId %s , %s", spSiteId, userId,
					userTypeId, e.getMessage()));
		}

		return null;
	}

	public List<SPUserType> findBySpSiteIdAndUserId(long spSiteId, long userId) {
		try {
			return SPUserTypeUtil.findBySpSiteIdAndUserId(spSiteId, userId);
		} catch (SystemException e) {
			_log.error(
					String.format("Unable to find by spSiteId %s , userId %s , %s", spSiteId, userId, e.getMessage()));
		}

		return null;
	}
	
	public void addSPSiteAndUserType(String userType, String virtualHostId, User user, String productTypeId,
			String subProductTypeId, String password) {

		SPUserTypeConfig spUserTypeConfig;

		if (Validator.isNumber(subProductTypeId)) {
			try {
				List<SPSiteSetup> spSiteSetupList = SPSiteSetupLocalServiceUtil
						.findBySubProductId(Long.parseLong(subProductTypeId));
				if (Validator.isNotNull(spSiteSetupList) && spSiteSetupList.size() > 0) {

					VirtualHost virtualHost = VirtualHostLocalServiceUtil
							.fetchVirtualHost(Long.parseLong(virtualHostId));

					List<SPSite> spSiteList = SPSiteLocalServiceUtil.findByUserIdAndAuthAccessId(user.getUserId(),
							spSiteSetupList.get(0).getSpSiteSetupId());

					if (Validator.isNull(spSiteList) || spSiteList.size() < 1) {

						SPSiteLocalServiceUtil.addOrUpdateSPSiteUser(user.getCompanyId(),
								SambaashConstants.DEFAULT_GROUP_ID_LONG, spSiteSetupList.get(0).getSpSiteSetupId(),
								user.getUserId(), virtualHost.getLayoutSetId(), Long.parseLong(virtualHostId),
								SambaashConstants.SP_USER_BY_SPSITE_LOGIN, password, user.getPassword());

						spSiteList = SPSiteLocalServiceUtil.findByUserIdAndAuthAccessId(user.getUserId(),
								spSiteSetupList.get(0).getSpSiteSetupId());

					} else {

						try {
							spUserTypeConfig = SPUserTypeConfigLocalServiceUtil.findByUserTypeAndVirtualHostId(userType,
									Long.parseLong(virtualHostId));

							List<SPUserType> userTypeList = SPUserTypeLocalServiceUtil.findBySpSiteIdAndUserTypeId(
									spSiteList.get(0).getSpSiteId(), spUserTypeConfig.getUserTypeId());

							if (Validator.isNotNull(userTypeList) && userTypeList.isEmpty()) {
								// add SPUserType entry
								long spUserTypeId = CounterLocalServiceUtil.increment("SPUserType");
								SPUserType spUserType = SPUserTypeLocalServiceUtil.createSPUserType(spUserTypeId);
								spUserType.setCreatedDate(DateUtil.newDate());
								spUserType.setCompanyId(user.getCompanyId());
								spUserType.setGroupId(SambaashConstants.DEFAULT_GROUP_ID_LONG);
								spUserType.setUserTypeId(spUserTypeConfig.getUserTypeId());
								spUserType.setSpSiteId(spSiteList.get(0).getSpSiteId());
								spUserType.setUserStatusId(0);
								SPUserTypeLocalServiceUtil.addSPUserType(spUserType);
							}

						} catch (Exception e) {
							_log.error("Failed to add SPUserType : " + e.getMessage());
						}
					}

				}
			} catch (Exception e) {
				_log.error("Failed to add SPSite & SPUserType: " + e.getMessage());
			}

		}

	}
	
}