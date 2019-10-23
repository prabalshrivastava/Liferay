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

package com.sambaash.platform.srv.processbuilder.service.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.sambaash.platform.srv.processbuilder.model.PERuleSet;
import com.sambaash.platform.srv.processbuilder.service.base.PERuleSetLocalServiceBaseImpl;
import com.sambaash.platform.srv.processbuilder.service.persistence.PERuleSetUtil;

import java.util.List;

/**
 * The implementation of the p e rule set local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.processbuilder.service.PERuleSetLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author RASP
 * @see com.sambaash.platform.srv.processbuilder.service.base.PERuleSetLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.processbuilder.service.PERuleSetLocalServiceUtil
 */
public class PERuleSetLocalServiceImpl extends PERuleSetLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.processbuilder.service.PERuleSetLocalServiceUtil} to access the p e rule set local service.
	 */
	public List<PERuleSet> findByComponentType(String type) throws SystemException {
		return PERuleSetUtil.findByComponentType(type);
	}
}