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

package com.sambaash.platform.srv.validation.service.impl;

import java.util.Date;

import com.liferay.portal.kernel.json.JSONObject;
import com.sambaash.platform.srv.validation.service.SPStudentProgrammeLocalServiceUtil;
import com.sambaash.platform.srv.validation.service.base.SPStudentProgrammeServiceBaseImpl;

/**
 * The implementation of the s p student programme remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.validation.service.SPStudentProgrammeService}
 * interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.validation.service.base.SPStudentProgrammeServiceBaseImpl
 * @see com.sambaash.platform.srv.validation.service.SPStudentProgrammeServiceUtil
 */
public class SPStudentProgrammeServiceImpl extends SPStudentProgrammeServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.validation.service.
	 * SPStudentProgrammeServiceUtil} to access the s p student programme remote
	 * service.
	 */

	public String getStudentProgramme(Long scopeGroupId, String programmeCode, String nric, String emailAddress,
			Date programmeEndDate, boolean validationRequired) {
		return SPStudentProgrammeLocalServiceUtil.getStudentProgramme(scopeGroupId, programmeCode, nric, emailAddress,
				programmeEndDate, validationRequired);
	}

	public JSONObject getStudentProgramme(Long scopeGroupId, String programmeCode, String nric) {
		return SPStudentProgrammeLocalServiceUtil.getStudentProgramme(scopeGroupId, programmeCode, nric);
	}

}