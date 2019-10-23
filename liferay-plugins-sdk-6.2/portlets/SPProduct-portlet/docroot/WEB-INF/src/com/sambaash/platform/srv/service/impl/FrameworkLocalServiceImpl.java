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
import com.sambaash.platform.srv.NoSuchFrameworkException;
import com.sambaash.platform.srv.model.Framework;
import com.sambaash.platform.srv.service.FrameworkLocalServiceUtil;
import com.sambaash.platform.srv.service.base.FrameworkLocalServiceBaseImpl;

/**
 * The implementation of the framework local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.service.FrameworkLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.FrameworkLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.FrameworkLocalServiceUtil
 */
public class FrameworkLocalServiceImpl extends FrameworkLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.service.FrameworkLocalServiceUtil} to access the framework local service.
	 */
	
	public Framework create() throws SystemException{
		long spFrameworkId = CounterLocalServiceUtil.increment("Framework.class");
		Framework framework = FrameworkLocalServiceUtil.createFramework(spFrameworkId);
		return framework;
	}
	public void clearCache() {
		frameworkPersistence.clearCache();
	}
	
	public Framework findByFramworkCode(String frameworkCode) throws NoSuchFrameworkException, SystemException{
		return frameworkPersistence.findByFrameworkCode(frameworkCode);
	}
	
	public Framework findByNameAndGroupId(String frameworkName, long groupId) throws NoSuchFrameworkException, SystemException{
		return frameworkPersistence.findByNameAndGroupId(frameworkName, groupId);
	}
	
}