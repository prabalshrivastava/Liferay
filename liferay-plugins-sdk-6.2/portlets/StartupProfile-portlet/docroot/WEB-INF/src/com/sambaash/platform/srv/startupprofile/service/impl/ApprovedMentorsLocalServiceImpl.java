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

package com.sambaash.platform.srv.startupprofile.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.model.ApprovedMentors;
import com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsImpl;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.base.ApprovedMentorsLocalServiceBaseImpl;

/**
 * The implementation of the approved mentors local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.startupprofile.service.ApprovedMentorsLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author pradeep
 * @see com.sambaash.platform.srv.startupprofile.service.base.ApprovedMentorsLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.startupprofile.service.ApprovedMentorsLocalServiceUtil
 */
public class ApprovedMentorsLocalServiceImpl extends ApprovedMentorsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.startupprofile.service.
	 * ApprovedMentorsLocalServiceUtil} to access the approved mentors local
	 * service.
	 */
	public List<ApprovedMentors> findByOrganizationId(long organizationId) {
		try {
			return getApprovedMentorsPersistence().findByOrganizationId(organizationId);
		} catch (SystemException e) {
			return null;
		}

	}

	
	public List<ApprovedMentors> findByUserId(String userId) {
		try {
			return getApprovedMentorsPersistence().findByUserId(userId);
		} catch (SystemException e) {
			return null;
		}

	}
	
	public List<ApprovedMentors> findByOrganizationAndUserId(long organizationId, String userId) {
		try {
			return getApprovedMentorsPersistence().findByOrganizationAndUserId(organizationId, userId);
		} catch (SystemException e) {
			return null;
		}

	}

	public List<ApprovedMentors> findApprovedMentorsByOrganizationId(long organizationId) {
		try {

			List<ApprovedMentors> approvedMentorsList = getApprovedMentorsPersistence()
					.findByOrganizationIdApprovedMentors(organizationId);
			for (ApprovedMentors approvedMentor : approvedMentorsList) {
				if (Validator.isNumber(approvedMentor.getUserId())) {
					User user = UserLocalServiceUtil.fetchUser(Long.parseLong(approvedMentor.getUserId()));
					approvedMentor.setFirstName(user.getFirstName());
					approvedMentor.setLastName(user.getLastName());
				}
			}

			return approvedMentorsList;
		} catch (SystemException e) {
			return null;
		}

	}

	public List<ApprovedMentors> findApprovedMentorsByOrganizationIdWithOthers(long organizationId) {
		try {

			List<ApprovedMentors> newApprovedMentorsList = new ArrayList<>();
			List<ApprovedMentors> approvedMentorsList = getApprovedMentorsPersistence()
					.findByOrganizationIdApprovedMentors(organizationId);
			for (ApprovedMentors approvedMentor : approvedMentorsList) {
				if (Validator.isNumber(approvedMentor.getUserId())) {
					User user = UserLocalServiceUtil.fetchUser(Long.parseLong(approvedMentor.getUserId()));
					approvedMentor.setFirstName(user.getFirstName());
					approvedMentor.setLastName(user.getLastName());
				}
				newApprovedMentorsList.add(approvedMentor);
			}
			
			_log.error("Default list size : " + approvedMentorsList.size());

			ApprovedMentors others = new ApprovedMentorsImpl();
			others.setMentorId(0);
			others.setOrganizationId(organizationId);
			others.setFirstName("Others");
			others.setLastName(StringPool.PERIOD);
			newApprovedMentorsList.add(others);

			_log.error("Default list size : " + newApprovedMentorsList.size());
		
			return newApprovedMentorsList;
		} catch (SystemException e) {
			return null;
		}

	}
	
	public List<ApprovedMentors> findApprovedMentorsByOrganizationIdAndStatus(long organizationId, int status) {
		try {

			List<ApprovedMentors> approvedMentorsList = getApprovedMentorsPersistence().findByOrganizationIdStatus(organizationId, status);
			for (ApprovedMentors approvedMentor : approvedMentorsList) {
				if (Validator.isNumber(approvedMentor.getUserId())) {
					User user = UserLocalServiceUtil.fetchUser(Long.parseLong(approvedMentor.getUserId()));
					approvedMentor.setFirstName(user.getFirstName());
					approvedMentor.setLastName(user.getLastName());
				}
			}

			return approvedMentorsList;
		} catch (SystemException e) {
			return null;
		}

	}
	public List<ApprovedMentors> findApprovedMentorsByUserIdAndStatus(long userId, int status) {
		try {
			//long organizationId = Long.valueOf(OrganizationLocalServiceUtil.getCurrentUserBaseOrganization(userId));
			List<ApprovedMentors> approvedMentorsList = getApprovedMentorsPersistence().findByUserId(String.valueOf(userId));
			for (ApprovedMentors approvedMentor : approvedMentorsList) {
				if (Validator.isNumber(approvedMentor.getUserId()) && approvedMentor.getStatus() == status) {
					User user = UserLocalServiceUtil.fetchUser(Long.parseLong(approvedMentor.getUserId()));
					approvedMentor.setFirstName(user.getFirstName());
					approvedMentor.setLastName(user.getLastName());
				}
			}
			
			return approvedMentorsList;
		} catch (SystemException e) {
			return null;
		}

	}
	public List<ApprovedMentors> findApprovedMentorsByStatus(int status) {
		try {
			
			List<ApprovedMentors> approvedMentorsList = getApprovedMentorsPersistence().findByStatus(status);
			for (ApprovedMentors approvedMentor : approvedMentorsList) {
				if (Validator.isNumber(approvedMentor.getUserId())) {
					User user = UserLocalServiceUtil.fetchUser(Long.parseLong(approvedMentor.getUserId()));
					approvedMentor.setFirstName(user.getFirstName());
					approvedMentor.setLastName(user.getLastName());
					approvedMentor.setEmail(user.getEmailAddress());
				}
			}
			
			return approvedMentorsList;
		} catch (SystemException e) {
			return null;
		}

	}
	
	
	public List<ApprovedMentors> findMentorsByOrganizationId(long organizationId) {
		try {

			List<ApprovedMentors> approvedMentorsList = getApprovedMentorsPersistence().findByOrganizationId(organizationId);
			for (ApprovedMentors approvedMentor : approvedMentorsList) {
				if (Validator.isNumber(approvedMentor.getUserId())) {
					User user = UserLocalServiceUtil.fetchUser(Long.parseLong(approvedMentor.getUserId()));
					approvedMentor.setFirstName(user.getFirstName());
					approvedMentor.setLastName(user.getLastName());
				}
			}

			return approvedMentorsList;
		} catch (SystemException e) {
			return null;
		}

	}
	
	private static Log _log = LogFactoryUtil.getLog(ApprovedMentorsLocalServiceImpl.class);

}