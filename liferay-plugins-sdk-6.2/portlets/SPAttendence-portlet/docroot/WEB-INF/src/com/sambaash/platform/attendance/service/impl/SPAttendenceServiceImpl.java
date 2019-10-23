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

package com.sambaash.platform.attendance.service.impl;

import com.sambaash.platform.attendance.service.SPAttendenceLocalServiceUtil;
import com.sambaash.platform.attendance.service.base.SPAttendenceServiceBaseImpl;

/**
 * The implementation of the s p attendence remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.attendance.service.SPAttendenceService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author keyur.kalariya
 * @see com.sambaash.platform.attendance.service.base.SPAttendenceServiceBaseImpl
 * @see com.sambaash.platform.attendance.service.SPAttendenceServiceUtil
 */
public class SPAttendenceServiceImpl extends SPAttendenceServiceBaseImpl {

	public String exportExamDocketByCandidateNumber(String candidateNumber) {
		String path="";
		path = SPAttendenceLocalServiceUtil.exportExamDocket(candidateNumber);
		return path;
	}
	public boolean hasExamDocket(String candidateNumber) {
		boolean result=false;
		result = SPAttendenceLocalServiceUtil.hasExamDocket(candidateNumber);
		return result;
	}


}