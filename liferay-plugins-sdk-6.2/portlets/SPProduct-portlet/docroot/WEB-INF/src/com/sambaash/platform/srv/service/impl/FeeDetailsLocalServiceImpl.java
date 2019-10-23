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
import com.sambaash.platform.srv.NoSuchFeeDetailsException;
import com.sambaash.platform.srv.model.FeeDetails;
import com.sambaash.platform.srv.service.FeeDetailsLocalServiceUtil;
import com.sambaash.platform.srv.service.base.FeeDetailsLocalServiceBaseImpl;
import com.sambaash.platform.srv.service.persistence.FeeDetailsUtil;

/**
 * The implementation of the fee details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.service.FeeDetailsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.FeeDetailsLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.FeeDetailsLocalServiceUtil
 */
public class FeeDetailsLocalServiceImpl extends FeeDetailsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.service.FeeDetailsLocalServiceUtil} to access
	 * the fee details local service.
	 */

	public java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByCourseIdAndGroupId(long spCourseId,
			long groupId) throws com.liferay.portal.kernel.exception.SystemException {
		return feeDetailsPersistence.findByCourseIdAndGroupId(spCourseId, groupId);
	}
	
	public java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByFundIdAndSpCourseId(long fundId,
			long spCourseId) throws com.liferay.portal.kernel.exception.SystemException {
		return feeDetailsPersistence.findByFundIdAndSpCourseId(fundId, spCourseId);
	}
	
	public java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByFeeTypeAndCourseId(long feeType,
			long spCourseId) throws com.liferay.portal.kernel.exception.SystemException {
		return feeDetailsPersistence.findByFeeTypeAndCourseId(feeType, spCourseId);
	}
	
	public FeeDetails findByCourseIdFundIdFeeType(long courseId,
			long fundId,long feeTypeId) throws com.liferay.portal.kernel.exception.SystemException, NoSuchFeeDetailsException {
		return feeDetailsPersistence.findBycourseIdFundIdFeeType(courseId, fundId, feeTypeId);
	}
		
		public java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByFundId(long fundId) throws com.liferay.portal.kernel.exception.SystemException {
		return feeDetailsPersistence.findByFundId(fundId);
	}

	public void clearCache() {
		feeDetailsPersistence.clearCache();
	}
	public FeeDetails create() throws SystemException{
		long feeDetailId = CounterLocalServiceUtil.increment("FeeDetails.class");
		
		FeeDetails feeDetails = FeeDetailsLocalServiceUtil.createFeeDetails(feeDetailId);
		return feeDetails;

	}
	public FeeDetails findByFundIdFeeType(long fundId,long feeType) throws SystemException, NoSuchFeeDetailsException {
		return FeeDetailsUtil.findByfundIdFeeType(fundId, feeType);
	}
}