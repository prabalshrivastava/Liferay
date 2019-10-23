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

package com.sambaash.platform.srv.sprating.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.sambaash.platform.portlet.sprating.helper.RatingHelper;
import com.sambaash.platform.srv.sprating.NoSuchAttrRateException;
import com.sambaash.platform.srv.sprating.model.AttrRate;
import com.sambaash.platform.srv.sprating.service.AttrRateLocalServiceUtil;
import com.sambaash.platform.srv.sprating.service.base.AttrRateLocalServiceBaseImpl;
import com.sambaash.platform.srv.sprating.service.persistence.AttrRateUtil;

/**
 * The implementation of the attr rate local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.sprating.service.AttrRateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author harini
 * @see com.sambaash.platform.srv.sprating.service.base.AttrRateLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.sprating.service.AttrRateLocalServiceUtil
 */
public class AttrRateLocalServiceImpl extends AttrRateLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.sprating.service.AttrRateLocalServiceUtil} to access the attr rate local service.
	 */
	public List<AttrRate> findByUserIdClassNameIdObjId(long userId, long classNameId, String objId) {
		try {
			return AttrRateUtil.findByUserIdClassNameIdObjId(userId, classNameId, objId);
		} catch (SystemException e) {
			_log.error("Error while getting AttrRates for userId=" + userId  + ", classNameId=" + classNameId + ", Object Id=" + objId);
		}
		return null;
	}
	public AttrRate findByUserIdRatingAttrIdObjId(long userId, long ratingAttrId,String objId) {
		try {
			//return AttrRateUtil.findByUserIdRatingAttrIdObjId(userId, objId, ratingAttrId);
			return AttrRateUtil.findByUserIdRatingAttrIdObjId(userId, ratingAttrId, objId);
		} catch (SystemException e) {
			_log.error("Error while getting AttrRates for userId=" + userId  + ", ratingAttrId=" + ratingAttrId + ", Object Id=" + objId);
		} catch (NoSuchAttrRateException e) {
			_log.error("AttrRate does not exists" + userId  + ", ratingAttrId=" + ratingAttrId + ", Object Id=" + objId);
		}
		return null;
	}
	
	public List<AttrRate> findByRatingAttrIdObjId( long ratingAttrId,String objId) {
		try {
			return AttrRateUtil.findByRatingAttrIdObjId(ratingAttrId, objId);
		} catch (SystemException e) {
			_log.error("Error while getting AttrRates for  ratingAttrId=" + ratingAttrId + ", Object Id=" + objId);
		} 
		return null;
	} 
	
	public long generateAttrRateId() throws SystemException {
		long id = counterLocalService.increment(getModelClassName());
		return id;
	}
	
	public AttrRate createAttrRate() throws SystemException{
		return AttrRateLocalServiceUtil.createAttrRate(generateAttrRateId());
	}
	
	public AttrRate addAttrRate(String objId,long ratingAttrId,long classNameId, double rateValue,long companyId,long groupId,User user) throws PortalException, SystemException{
		AttrRate attrRate;
		attrRate = createAttrRate();
		attrRate.setObjId(objId);
		attrRate.setRatingAttrId(ratingAttrId);
		attrRate.setClassNameId(classNameId);
		attrRate.setValue(rateValue);
		attrRate.setUserId(user.getUserId());
		attrRate.setCompanyId(companyId);
		attrRate.setGroupId( groupId);
		attrRate.setUserName(user.getFullName());
		attrRate.setCreateDate(RatingHelper.getTodayDate());
		attrRate.setModifiedDate(RatingHelper.getTodayDate());
		AttrRateLocalServiceUtil.addAttrRate(attrRate);
		return attrRate;
	}
	
	private static final Log _log = LogFactoryUtil.getLog(AttrRateLocalServiceImpl.class.getName());

}