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

package com.sambaash.platform.srv.genericuploader.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.srv.genericuploader.model.GUUploadLog;
import com.sambaash.platform.srv.genericuploader.service.base.GUUploadLogLocalServiceBaseImpl;

/**
 * The implementation of the g u upload log local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.genericuploader.service.GUUploadLogLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.srv.genericuploader.service.base.GUUploadLogLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.genericuploader.service.GUUploadLogLocalServiceUtil
 */
public class GUUploadLogLocalServiceImpl extends GUUploadLogLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.genericuploader.service.GUUploadLogLocalServiceUtil} to access the g u upload log local service.
	 */
	
	public GUUploadLog create() throws SystemException{
		long id = counterLocalService.increment("GUUploadLog.class");
		return guUploadLogPersistence.create(id);
	}
}