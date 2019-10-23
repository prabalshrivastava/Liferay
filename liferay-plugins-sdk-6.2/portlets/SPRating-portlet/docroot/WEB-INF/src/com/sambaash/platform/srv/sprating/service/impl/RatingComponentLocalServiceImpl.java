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
import com.sambaash.platform.portlet.sprating.RatingConstants;
import com.sambaash.platform.portlet.sprating.helper.RatingHelper;
import com.sambaash.platform.srv.sprating.model.RatingComponent;
import com.sambaash.platform.srv.sprating.service.RatingComponentLocalServiceUtil;
import com.sambaash.platform.srv.sprating.service.base.RatingComponentLocalServiceBaseImpl;
import com.sambaash.platform.srv.sprating.service.persistence.RatingComponentUtil;

/**
 * The implementation of the rating component local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.sprating.service.RatingComponentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author harini
 * @see com.sambaash.platform.srv.sprating.service.base.RatingComponentLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.sprating.service.RatingComponentLocalServiceUtil
 */
public class RatingComponentLocalServiceImpl
	extends RatingComponentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.sprating.service.RatingComponentLocalServiceUtil} to access the rating component local service.
	 */

	public long generateNewComponentId() throws SystemException {
		long id = counterLocalService.increment(getModelClassName());
		return id;
	}
	
	public RatingComponent getNewRatingComponent() throws SystemException{
		return RatingComponentLocalServiceUtil.createRatingComponent(generateNewComponentId());
	}
	
	public RatingComponent saveRatingComponent(String name,long classNameId,User user,String action,long compId) throws Exception {
		_log.debug("In addNewRatingComponent " + name + "," + classNameId + "," +user);
		RatingComponent comp = null;
		try {
			   if(RatingConstants.ADD.equalsIgnoreCase(action)){
				   comp = getNewRatingComponent();
				   comp.setCreateDate(RatingHelper.getTodayDate());
			   }else{
				   comp = getRatingComponent(compId);
			   }
			   comp.setName(name);
			   comp.setClassNameId(classNameId);
			   
			   // Audidt fields
			   comp.setModifiedDate(RatingHelper.getTodayDate());
			   comp.setUserId(user.getUserId());
			   comp.setUserName(user.getFullName());
			   comp.setCompanyId(user.getCompanyId());
			   comp.setGroupId(user.getGroupId());
			   
			   if(RatingConstants.ADD.equalsIgnoreCase(action)){
				   RatingComponentLocalServiceUtil.addRatingComponent(comp);
			   }else{
				   RatingComponentLocalServiceUtil.updateRatingComponent(comp);
			   }
				   
			   
		} catch (Exception ex) {
			_log.error("Error while saving new RatingComponent " + ex.getMessage());
			throw ex;
		}
		return comp;
	}
	
	public List<RatingComponent> getAllRatingComponents() throws SystemException{
		List<RatingComponent> list = RatingComponentUtil.findAll();
		return list;
	}
		
	public List<RatingComponent> findByName(String name) throws SystemException{
		List<RatingComponent> list = RatingComponentUtil.findByName(name);
		return list;
	}
	public boolean isComponentNameExists(String name) throws SystemException{
		List<RatingComponent> list = RatingComponentUtil.findByName(name);
		if(list.isEmpty()){
			return false;
		}
		return true;
	}
	
	private static Log _log = LogFactoryUtil.getLog(RatingComponentLocalServiceImpl.class);
	
}