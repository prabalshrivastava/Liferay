/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.sambaash.platform.srv.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.srv.model.Funding;
import com.sambaash.platform.srv.service.FundingLocalServiceUtil;
import com.sambaash.platform.srv.service.base.FundingLocalServiceBaseImpl;

/**
 * The implementation of the funding local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.service.FundingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.FundingLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.FundingLocalServiceUtil
 */
public class FundingLocalServiceImpl extends FundingLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.service.FundingLocalServiceUtil} to access the
	 * funding local service.
	 */

	public java.util.List<com.sambaash.platform.srv.model.Funding> findByCourseIdAndGroupId(long spCourseId,
			long groupId) throws com.liferay.portal.kernel.exception.SystemException {
		return fundingPersistence.findByCourseIdAndGroupId(spCourseId, groupId);
	}
	public java.util.List<com.sambaash.platform.srv.model.Funding> findByCourseIdOrderByFundOrder(long spCourseId) throws com.liferay.portal.kernel.exception.SystemException {
		return fundingPersistence.findByCourseId(spCourseId);
	}
	public java.util.List<com.sambaash.platform.srv.model.Funding> findBySponsorByCourseId(long sponsorBy,long spCourseId) throws com.liferay.portal.kernel.exception.SystemException {
		return fundingPersistence.findBySponsorByCourseId(sponsorBy, spCourseId);
	}
	public void clearCache() {
		fundingPersistence.clearCache();
	}
	
	public Funding create() throws SystemException{
		long fundId = CounterLocalServiceUtil.increment("Funding.class");
		Funding funding = FundingLocalServiceUtil.createFunding(fundId);
		return funding;
	}

}