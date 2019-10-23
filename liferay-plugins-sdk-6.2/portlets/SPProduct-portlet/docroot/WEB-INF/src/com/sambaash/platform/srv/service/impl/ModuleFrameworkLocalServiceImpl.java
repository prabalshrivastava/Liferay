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
import com.sambaash.platform.srv.model.ModuleFramework;
import com.sambaash.platform.srv.service.ModuleFrameworkLocalServiceUtil;
import com.sambaash.platform.srv.service.base.ModuleFrameworkLocalServiceBaseImpl;

/**
 * The implementation of the module framework local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.service.ModuleFrameworkLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.ModuleFrameworkLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.ModuleFrameworkLocalServiceUtil
 */
public class ModuleFrameworkLocalServiceImpl
	extends ModuleFrameworkLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.service.ModuleFrameworkLocalServiceUtil} to access the module framework local service.
	 */
	public java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findByModuleIdAndGroupId(
			long spModuleId, long groupId)
			throws com.liferay.portal.kernel.exception.SystemException{
		return moduleFrameworkPersistence.findByModuleIdAndGroupId(spModuleId, groupId);
	}
	
	public java.util.List<com.sambaash.platform.srv.model.ModuleFramework> findByFrameworkIdAndGroupId(
			long spFrameworkId, long groupId)
			throws com.liferay.portal.kernel.exception.SystemException{
		return moduleFrameworkPersistence.findByFrameworkIdAndGroupId(spFrameworkId, groupId);
	}
	
	public void clearCache() {
		moduleFrameworkPersistence.clearCache();
	}
	
	public ModuleFramework create() throws SystemException{
		long moduleFrameWorkId = CounterLocalServiceUtil.increment("ModuleFramework.class");
		return ModuleFrameworkLocalServiceUtil.createModuleFramework(moduleFrameWorkId);
	}
	
}