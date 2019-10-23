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

package com.sambaash.platform.srv.enrolment.service.impl;

import java.util.Date;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords;
import com.sambaash.platform.srv.enrolment.service.base.EnrollUploadedTempRecordsLocalServiceBaseImpl;

/**
 * The implementation of the enroll uploaded temp records local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.enrolment.service.EnrollUploadedTempRecordsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Baxture
 * @see com.sambaash.platform.srv.enrolment.service.base.EnrollUploadedTempRecordsLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.enrolment.service.EnrollUploadedTempRecordsLocalServiceUtil
 */
public class EnrollUploadedTempRecordsLocalServiceImpl
	extends EnrollUploadedTempRecordsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.enrolment.service.EnrollUploadedTempRecordsLocalServiceUtil} to access the enroll uploaded temp records local service.
	 */
	public EnrollUploadedTempRecords addEnrollUploadStat(String uploadTransactId, String dob, String gender,
			long userId,String name, String sprCode, String title, String email) throws SystemException {
		
		EnrollUploadedTempRecords enrollUploadStat = enrollUploadedTempRecordsPersistence.create(CounterLocalServiceUtil.increment());
		
		enrollUploadStat.setUploadTransactId(uploadTransactId);
		enrollUploadStat.setDateofBirth(dob);
		enrollUploadStat.setGender(gender);
		enrollUploadStat.setFullOfficialName(name);
		enrollUploadStat.setTitle(title);
		enrollUploadStat.setSprCode(sprCode);
		enrollUploadStat.setEmail(email);
		enrollUploadStat.setUserId(userId);
		enrollUploadStat.setCreateDate(new Date());
		enrollUploadStat.setModifiedDate(new Date());
		
		enrollUploadStat = enrollUploadedTempRecordsPersistence.update(enrollUploadStat);
		
		return enrollUploadStat;
		
	}
}