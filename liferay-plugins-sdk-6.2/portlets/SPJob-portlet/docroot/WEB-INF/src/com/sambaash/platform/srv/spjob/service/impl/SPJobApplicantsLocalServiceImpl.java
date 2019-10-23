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

package com.sambaash.platform.srv.spjob.service.impl;

import java.util.Date;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.sambaash.platform.srv.spjob.model.SPJobApplicants;
import com.sambaash.platform.srv.spjob.service.base.SPJobApplicantsLocalServiceBaseImpl;

/**
 * The implementation of the s p job applicants local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.service.SPJobApplicantsLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author harini
 * @see com.sambaash.platform.srv.service.base.SPJobApplicantsLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.SPJobApplicantsLocalServiceUtil
 */
public class SPJobApplicantsLocalServiceImpl extends
		SPJobApplicantsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.service.SPJobApplicantsLocalServiceUtil} to
	 * access the s p job applicants local service.
	 */

	public SPJobApplicants addSPJobApplicants(long userId, long jobId,
			String firstName, String lastName, String emailAddress,
			String contactNumber, String coverLetter, long documentId,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		// Entry

		User user = userPersistence.findByPrimaryKey(userId);
		long groupId = serviceContext.getScopeGroupId();

		Date now = new Date();

		long spJobApplicantsId = counterLocalService.increment();

		SPJobApplicants spJobApplicants = spJobApplicantsPersistence
				.create(spJobApplicantsId);
		spJobApplicants.setJobId(jobId);
		spJobApplicants.setGroupId(groupId);
		spJobApplicants.setCompanyId(user.getCompanyId());
		spJobApplicants.setUserId(user.getUserId());
		spJobApplicants.setCreatedBy(user.getUserId());
		spJobApplicants.setUpdatedBy(user.getUserId());
		spJobApplicants.setCreateDate(serviceContext.getCreateDate(now));
		spJobApplicants.setModifiedDate(serviceContext.getModifiedDate(now));
		spJobApplicants.setFirstName(firstName);
		spJobApplicants.setLastName(lastName);
		spJobApplicants.setEmailAddress(emailAddress);
		spJobApplicants.setContactNumber(contactNumber);
		spJobApplicants.setCoverLetter(coverLetter);
		spJobApplicants.setExtra1(String.valueOf(documentId));

		spJobApplicantsPersistence.update(spJobApplicants);

		return spJobApplicants;
	}

}