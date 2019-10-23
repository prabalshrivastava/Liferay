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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.sambaash.platform.portlet.sprating.helper.RatingHelper;
import com.sambaash.platform.srv.sprating.model.RatingAttr;
import com.sambaash.platform.srv.sprating.service.RatingAttrLocalServiceUtil;
import com.sambaash.platform.srv.sprating.service.base.RatingAttrLocalServiceBaseImpl;
import com.sambaash.platform.srv.sprating.service.persistence.RatingAttrUtil;

/**
 * The implementation of the rating attr local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.sprating.service.RatingAttrLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author harini
 * @see com.sambaash.platform.srv.sprating.service.base.RatingAttrLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.sprating.service.RatingAttrLocalServiceUtil
 */
public class RatingAttrLocalServiceImpl extends RatingAttrLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.sprating.service.RatingAttrLocalServiceUtil} to access the rating attr local service.
	 */
	private static Log _log = LogFactoryUtil.getLog(RatingAttrLocalServiceImpl.class);

	public RatingAttr getNewRatingAttr() throws SystemException {
		RatingAttr attr = null;

		long id = counterLocalService.increment(getModelClassName());
		attr = RatingAttrLocalServiceUtil.createRatingAttr(id);
		attr.setNew(true);

		return attr;
	}
	
	public RatingAttr addRatingAttr(String name,boolean visible,double weight,long componentId,User user) throws Exception{
		RatingAttr attr = null;
		try {
			attr = getNewRatingAttr();
			attr.setRatingComponentId(componentId);
			attr.setName(name);
			attr.setVisible(visible);
			attr.setWeight(weight);
			
			attr.setCompanyId(user.getCompanyId());
			attr.setUserId(user.getUserId());
			attr.setUserName(user.getFullName());
			attr.setGroupId(user.getGroupId());
			attr.setCreateDate(RatingHelper.getTodayDate());
			attr.setModifiedDate(RatingHelper.getTodayDate());
			RatingAttrLocalServiceUtil.addRatingAttr(attr);
		} catch (Exception e) {
			_log.error("Error while adding new RatingAttr " );
			throw e;
		}
		
		return attr;
	}
	
	public long generateNewRatingAttrId() throws SystemException {
		long id = counterLocalService.increment(getModelClassName());
		return id;
	}
	
	public List<RatingAttr> findRatingAttrsByComponentId(long componentId) throws SystemException{
		return RatingAttrUtil.findByratingComponentId(componentId);
	}
}