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

package com.sambaash.platform.srv.spsocialprofile.service.impl;

import java.util.Date;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser;
import com.sambaash.platform.srv.spsocialprofile.service.base.ExamBodyUserLocalServiceBaseImpl;

/**
 * The implementation of the exam body user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.spsocialprofile.service.ExamBodyUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.spsocialprofile.service.base.ExamBodyUserLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spsocialprofile.service.ExamBodyUserLocalServiceUtil
 */
public class ExamBodyUserLocalServiceImpl
	extends ExamBodyUserLocalServiceBaseImpl {
	private static Log _log = LogFactoryUtil.getLog(ExamBodyUserLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.spsocialprofile.service.ExamBodyUserLocalServiceUtil} to access the exam body user local service.
	 */
	
	public boolean isExamBodyUser(String examBody, String emailAddress) {
		try {
			com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser u = examBodyUserPersistence.findByEmailAddressAndExamBody(emailAddress, examBody);
			return u != null && u.isActive();			
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public void addOrUpdateExamBodyUser(long companyId, long groupId, String examBody, String emailAddress) {
		ExamBodyUser examBodyUser = null;
		long examBodyUserId = 0;
		try {
			examBodyUser = examBodyUserPersistence.findByEmailAddressAndExamBody(emailAddress, examBody);
		} catch (Exception e) {
			// not found, create a new entry
		}
		
		if (examBodyUser == null) {
			try {
				examBodyUserId = counterLocalService.increment("ExamBodyUser");				
				examBodyUser = createExamBodyUser(examBodyUserId);
				examBodyUser.setCreateDate(new Date());
				examBodyUser.setActive(true);
				examBodyUser.setCompanyId(companyId);
				examBodyUser.setGroupId(groupId);
			} catch (Exception e) {
				_log.error("Unable to create new User Exam Body mapping!", e);
				return;
			}
		} else {
			examBodyUser.setModifiedDate(new Date());
		}
		_log.debug("Adding Exam Body / User : "+examBody+"/"+emailAddress);
		examBodyUser.setEmailAddress(emailAddress);
		examBodyUser.setExamBody(examBody);
		
		try {
			examBodyUserPersistence.update(examBodyUser);
			examBodyUserPersistence.flush();
		} catch (Exception e) {
			_log.error("Unable to add User Exam Body mapping!", e);
		}

	}
}