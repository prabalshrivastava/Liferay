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

package com.sambaash.platform.srv.spchallenge.service.impl;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.sambaash.platform.spchallenge.helper.SPChallengeConstants;
import com.sambaash.platform.srv.spchallenge.model.SPChallenge;
import com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant;
import com.sambaash.platform.srv.spchallenge.service.base.SPChallengeApplicantLocalServiceBaseImpl;
import com.sambaash.platform.srv.spchallenge.service.persistence.SPChallengeApplicantUtil;

/**
 * The implementation of the s p challenge applicant local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.spchallenge.service.SPChallengeApplicantLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author pradeep
 * @see com.sambaash.platform.srv.spchallenge.service.base.SPChallengeApplicantLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spchallenge.service.SPChallengeApplicantLocalServiceUtil
 */
public class SPChallengeApplicantLocalServiceImpl extends
		SPChallengeApplicantLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform
	 * .srv.spchallenge.service.SPChallengeApplicantLocalServiceUtil} to access
	 * the s p challenge applicant local service.
	 */
	private static Log logger = LogFactoryUtil
			.getLog(SPChallengeApplicantLocalServiceImpl.class);

	public List<SPChallengeApplicant> findByApplicantRefId(long applicantRefId)
			throws SystemException {
		return SPChallengeApplicantUtil.findByApplicantRefId(applicantRefId);
	}

	public void updateAssets(long userId, SPChallengeApplicant applicant,
			long[] assetCategoryIds) throws PortalException, SystemException {

		boolean visible = true;

		assetEntryLocalService.updateEntry(userId, applicant.getGroupId(),
				SPChallengeApplicant.class.getName(),
				applicant.getSpChallengeApplicantId(), applicant.getUuid(), 0,
				assetCategoryIds, null, visible, null, null,
				applicant.getCreateDate(), null, ContentTypes.TEXT_HTML, null,
				null, null, null, null, 0, 0, null, false);
	}

	public List<SPChallenge> getAppliedChallenges(long orgId) {

		List<SPChallenge> list = null;
		try {
			DynamicQuery dynaQuery = null;
			dynaQuery = DynamicQueryFactoryUtil.forClass(SPChallenge.class,
					PortletClassLoaderUtil
							.getClassLoader(SPChallengeConstants.PORTLET_ID));
			dynaQuery.add(PropertyFactoryUtil.forName("spChallengeId").in(
					DynamicQueryFactoryUtil
							.forClass(SPChallengeApplicant.class,
									this.getClass().getClassLoader())
							.add(PropertyFactoryUtil.forName("applicantRefId")
									.eq(orgId))
							.setProjection(
									ProjectionFactoryUtil
											.property("spChallengeId"))));

			list = dynamicQuery(dynaQuery);
		} catch (Exception e) {
			logger.error("Error retrieving Challenges", e);
		}
		return list;
	}

	public List<SPChallengeApplicant> findBySPChallengeId(long spChallengeId){
		List<SPChallengeApplicant>  applicants = null;
		try {
			  applicants = SPChallengeApplicantUtil.findBySPChallengeId(spChallengeId);
		} catch (Exception e) {
			logger.error("Error retrieving applicants", e);
		}
		return applicants;
	}
	
	public SPChallengeApplicant findByChallengeIdApplicantRefId(long spChallengeId,long applicantRefId){
		SPChallengeApplicant applicant = null;
		try {
			applicant = SPChallengeApplicantUtil
					.findByChallengeIdApplicantRefId(spChallengeId,
							applicantRefId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return applicant;
	}
}