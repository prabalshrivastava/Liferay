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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.srv.startupprofile.model.FundingRound;
import com.sambaash.platform.srv.startupprofile.service.base.FundingRoundLocalServiceBaseImpl;

/**
 * The implementation of the funding round local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.startupprofile.service.FundingRoundLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author pradeep
 * @see com.sambaash.platform.srv.startupprofile.service.base.FundingRoundLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.startupprofile.service.FundingRoundLocalServiceUtil
 */
public class FundingRoundLocalServiceImpl
	extends FundingRoundLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.startupprofile.service.FundingRoundLocalServiceUtil} to access the funding round local service.
	 */
	
	public long counterIncrement() throws SystemException{
		long id = CounterLocalServiceUtil
				.increment("FundingRound");
		return id;
		
	}
	public FundingRound create() throws SystemException{
		return fundingRoundPersistence.create(counterIncrement());
	}
}