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
import com.sambaash.platform.srv.NoSuchCompetencyUnitException;
import com.sambaash.platform.srv.model.CompetencyUnit;
import com.sambaash.platform.srv.service.CompetencyUnitLocalServiceUtil;
import com.sambaash.platform.srv.service.base.CompetencyUnitLocalServiceBaseImpl;

/**
 * The implementation of the competency unit local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.service.CompetencyUnitLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.CompetencyUnitLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.CompetencyUnitLocalServiceUtil
 */
public class CompetencyUnitLocalServiceImpl extends CompetencyUnitLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.service.CompetencyUnitLocalServiceUtil} to
	 * access the competency unit local service.
	 */

	public CompetencyUnit create() throws SystemException{
		long spCompetencyUnitId = CounterLocalServiceUtil.increment("CompetencyUnit.class");
		CompetencyUnit competencyUnit = CompetencyUnitLocalServiceUtil.createCompetencyUnit(spCompetencyUnitId);
		return competencyUnit;
	}
	public void clearCache() {
		competencyUnitPersistence.clearCache();
	}

	public CompetencyUnit findByCompetencyUnitCode(String competencyUnitCode)
			throws NoSuchCompetencyUnitException, SystemException {
		return competencyUnitPersistence.findByCompetencyUnitCode(competencyUnitCode);
	}

}