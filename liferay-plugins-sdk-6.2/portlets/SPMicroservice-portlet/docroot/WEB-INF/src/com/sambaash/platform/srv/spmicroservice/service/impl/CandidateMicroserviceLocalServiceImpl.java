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

package com.sambaash.platform.srv.spmicroservice.service.impl;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.sambaash.platform.spmicroservice.api.wrapper.ems.CandidateMicroservice;
import com.sambaash.platform.spmicroservice.api.wrapper.ems.EmsMicroservice;
import com.sambaash.platform.srv.spmicroservice.service.base.CandidateMicroserviceLocalServiceBaseImpl;

/**
 * The implementation of the candidate microservice local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.spmicroservice.service.CandidateMicroserviceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author glenn
 * @see com.sambaash.platform.srv.spmicroservice.service.base.CandidateMicroserviceLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spmicroservice.service.CandidateMicroserviceLocalServiceUtil
 */
public class CandidateMicroserviceLocalServiceImpl
	extends CandidateMicroserviceLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.spmicroservice.service.CandidateMicroserviceLocalServiceUtil} to access the candidate microservice local service.
	 */

	public JSONObject validate(long scopeGroupId, JSONObject candidate) {
		CandidateMicroservice service = new CandidateMicroservice(scopeGroupId);
		return service.validate(candidate);
	}

	public JSONObject craete(long scopeGroupId, JSONObject candidate) {
		CandidateMicroservice service = new CandidateMicroservice(scopeGroupId);
		return service.create(candidate);
	}

	public JSONObject update(long scopeGroupId, JSONObject candidate, String storageId) {
		CandidateMicroservice service = new CandidateMicroservice(scopeGroupId);
		return service.update(candidate, storageId);
	}

	public JSONObject retrieveCandidateProgrammePath(long scopeGroupId, String candidateId, String configJson) {
		EmsMicroservice service = new EmsMicroservice(scopeGroupId);
		return service.retrieveCandidateProgrammePath(candidateId, configJson);
	}

	public JSONArray getCandidateAllowedModules(long scopeGroupId, Long candidateId, String scheduleCode) {
		EmsMicroservice service = new EmsMicroservice(scopeGroupId);
		return service.getCandidateAllowedModules(candidateId, scheduleCode);
	}

	public JSONArray getCandidateSchedule(long scopeGroupId, Long candidateId) {
		EmsMicroservice service = new EmsMicroservice(scopeGroupId);
		return service.getCandidateSchedule(candidateId);
	}
	
	public JSONArray getCandidateFailedModules(long scopeGroupId, Long candidateId, String scheduleCode) {
		EmsMicroservice service = new EmsMicroservice(scopeGroupId);
		return service.getCandidateFailedModules(candidateId, scheduleCode);
	}

	public boolean hasResults(long scopeGroupId, String programmeCode, Long candidateId) {
		EmsMicroservice service = new EmsMicroservice(scopeGroupId);
		return service.hasResults(programmeCode, candidateId);
	}

	public JSONArray allowedProgrammeScheduleToEnrol(long scopeGroupId, Long candidateId) {
		EmsMicroservice service = new EmsMicroservice(scopeGroupId);
		return service.allowedProgrammeScheduleToEnrol(candidateId);
	}
}