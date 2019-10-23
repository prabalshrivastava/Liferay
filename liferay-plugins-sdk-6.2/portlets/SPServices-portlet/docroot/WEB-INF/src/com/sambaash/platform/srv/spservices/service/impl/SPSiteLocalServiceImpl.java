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

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.security.util.PasswordUtil;
import com.sambaash.platform.srv.spservices.model.SPSite;
import com.sambaash.platform.srv.spservices.model.SPUserType;
import com.sambaash.platform.srv.spservices.service.SPSiteLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPUserTypeLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.base.SPSiteLocalServiceBaseImpl;

/**
 * The implementation of the s p site local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.spservices.service.SPSiteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.spservices.service.base.SPSiteLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.SPSiteLocalServiceUtil
 */
public class SPSiteLocalServiceImpl extends SPSiteLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.spservices.service.SPSiteLocalServiceUtil} to access the s p site local service.
	 */
	private static Log _log = LogFactoryUtil.getLog(SPSiteLocalServiceImpl.class);
			
	
	
	public void addOrUpdateSPSiteUser(long companyId, long groupId, long authAccessId, 
			long userId, long layoutSetId, long virtualHostId, String loginType,
			String plainPassword, String encryptedPassword ) {
		
		addOrUpdateSPSiteUser(companyId, groupId, authAccessId, 
				userId, layoutSetId, virtualHostId, loginType,
				plainPassword, encryptedPassword, 100);
	}
	
	public void addOrUpdateSPSiteUser(long companyId, long groupId, long authAccessId, 
			long userId, long layoutSetId, long virtualHostId, String loginType,
			String plainPassword, String encryptedPassword, long userTypeId) 
	{
		SPSite spSiteUser = null;
//		SPUserType spUserType = null;
		List<SPSite> siteUserList;
		boolean updateExistingEntryWithEmptyAuthAccessId = false;
		try {
			switch (loginType) {
				case SambaashConstants.SP_USER_BY_DOMAIN_LOGIN:
					// should actually be only 1 record by domain
					siteUserList = SPSiteLocalServiceUtil.findByUserIdAndVirtualHostId(userId, virtualHostId);					
					break;
	
				case SambaashConstants.SP_USER_BY_SPSITE_LOGIN:
					// can support multiple auth access (e.g. multiple exam body)
					// therefore our only concern is entry for specific auth access id
					siteUserList = SPSiteLocalServiceUtil.findByUserIdAndAuthAccessId(userId, authAccessId);
					updateExistingEntryWithEmptyAuthAccessId = true;
					break;
					
				case SambaashConstants.SP_DEFAULT_LIFERAY_LOGIN:
					// Liferay is one to one only
					siteUserList = SPSiteLocalServiceUtil.findByUserId(userId); 
					break;
				default:  
					siteUserList = Collections.emptyList();
					break;
			}
			if (!siteUserList.isEmpty()) {
				spSiteUser = siteUserList.get(0);
			}
			
			if (updateExistingEntryWithEmptyAuthAccessId && spSiteUser == null) {
				List<SPSite> currentUserAccessList = SPSiteLocalServiceUtil.findByUserId(userId);
				for(SPSite a: currentUserAccessList) {
					if (a.getAuthAccessId()==0) {
						// user entry with empty auth access id
						spSiteUser = a;
						break;
					}
				}
			}
			
			boolean createNewRecord = (spSiteUser == null);
			
			Date now = new Date();
			long spSiteId;
			if (createNewRecord) {
				spSiteId = CounterLocalServiceUtil.increment("SPSite");
				spSiteUser = createSPSite(spSiteId);
				spSiteUser.setActive(true);
				spSiteUser.setCreateDate(now);
				spSiteUser.setGroupId(groupId);
				spSiteUser.setCompanyId(companyId);
			} else {
				spSiteId = spSiteUser.getSpSiteId();
				spSiteUser.setModifiedDate(now);
			}
			spSiteUser.setLayoutSetId(layoutSetId);
			spSiteUser.setVirtualHostId(virtualHostId);
			spSiteUser.setUserId(userId);
			spSiteUser.setAuthAccessId(authAccessId);
			spSiteUser.setLoginType(Long.parseLong(loginType));
			if (plainPassword != null && !"".equals(plainPassword)) {
				// this is to allow different password per configured site, based on Liferay encryption
				spSiteUser.setPassword(PasswordUtil.encryptPassword(plainPassword, encryptedPassword));
			} else {
				spSiteUser.setPassword(encryptedPassword);	// set same password as liferay user
			}
			SPSiteLocalServiceUtil.updateSPSite(spSiteUser);

			// find by userType
			List<SPUserType> userTypeList = SPUserTypeLocalServiceUtil.findBySpSiteIdAndUserTypeId(spSiteId, userTypeId);
			if (Validator.isNotNull(userTypeList) && userTypeList.isEmpty()) {
				// add SPUserType entry
				long spUserTypeId = CounterLocalServiceUtil.increment("SPUserType");
				SPUserType spUserType = SPUserTypeLocalServiceUtil.createSPUserType(spUserTypeId);
				spUserType.setCreatedDate(now);
				spUserType.setCompanyId(companyId);
				spUserType.setGroupId(groupId);
				spUserType.setUserTypeId(userTypeId); 
				spUserType.setSpSiteId(spSiteUser.getSpSiteId());
				spUserType.setUserStatusId(0);
				spUserType.setUserId(userId);
				SPUserTypeLocalServiceUtil.addSPUserType(spUserType);
			}
		} catch (Exception e) {
			_log.error(e);
		}
		
	}

	public List<SPSite> findByUserIdAndVirtualHostId(long userId, long virtualHostId) {
		List<SPSite> siteUserList = Collections.emptyList();
		try {
			siteUserList = spSitePersistence.findByUserIdAndVirtualHostId(userId, virtualHostId);			
		} catch (Exception e) {
			_log.error("Failed search for SPSite userId="+userId+", virtualHostId="+virtualHostId, e);			
		}
		return siteUserList;
	}
	
	public boolean hasExistingDomainEntry(long userId, long virtualHostId) {
		return !findByUserIdAndVirtualHostId(userId, virtualHostId).isEmpty();
	}

	public List<SPSite> findByUserIdAndAuthAccessId(long userId, long authAccessId) {
		List<SPSite> siteUserList = Collections.emptyList();
		try {
			siteUserList = spSitePersistence.findByUserIdAndAuthAccessId(userId, authAccessId);
		} catch (Exception e) {
			_log.error("Failed search for SPSite userId="+userId+", authAccessId="+authAccessId, e);
		}
		return siteUserList;
	}

	public boolean hasExistingAuthAccessEntry(long userId, long authAccessId) {
		return !findByUserIdAndAuthAccessId(userId, authAccessId).isEmpty();
	}
	
	public List<SPSite> findByUserId(long userId) {
		List<SPSite> siteUserList = Collections.emptyList();
		try {
			siteUserList = spSitePersistence.findByUserId(userId);
		} catch (Exception e) {
			_log.error("Failed search for SPSite userId="+userId, e);
		}
		return siteUserList;
	}

}
