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

package com.sambaash.platform.srv.service.impl;

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.srv.NoSuchMiscellaneousFeesException;
import com.sambaash.platform.srv.model.MiscellaneousFees;
import com.sambaash.platform.srv.service.MiscellaneousFeesLocalServiceUtil;
import com.sambaash.platform.srv.service.base.MiscellaneousFeesLocalServiceBaseImpl;

/**
 * The implementation of the miscellaneous fees local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.service.MiscellaneousFeesLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.MiscellaneousFeesLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.MiscellaneousFeesLocalServiceUtil
 */
public class MiscellaneousFeesLocalServiceImpl
	extends MiscellaneousFeesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.service.MiscellaneousFeesLocalServiceUtil} to access the miscellaneous fees local service.
	 */
	public List<MiscellaneousFees> findByCourseIdAndGroupId(long spCourseId,
			long groupId) throws com.liferay.portal.kernel.exception.SystemException {
		return miscellaneousFeesPersistence.findByCourseIdAndGroupId(spCourseId, groupId);
	}
	
	public MiscellaneousFees findByCourseIdFeeType(long courseId,long feeTypeId) throws NoSuchMiscellaneousFeesException, SystemException{
		return miscellaneousFeesPersistence.findByCourseIdFeeType(courseId, feeTypeId);
	}
	
	public MiscellaneousFees create() throws SystemException{
		long miscFeeDetailId = CounterLocalServiceUtil.increment("MiscellaneousFees.class");
		
		MiscellaneousFees miscellaneousFees = MiscellaneousFeesLocalServiceUtil.createMiscellaneousFees(miscFeeDetailId);
		
		return miscellaneousFees;

	}
	
	public void clearCache() {
		miscellaneousFeesPersistence.clearCache();
	}
}