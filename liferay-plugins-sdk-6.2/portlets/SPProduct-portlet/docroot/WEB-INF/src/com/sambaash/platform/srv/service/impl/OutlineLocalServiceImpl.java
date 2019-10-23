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

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.srv.model.Outline;
import com.sambaash.platform.srv.service.OutlineLocalServiceUtil;
import com.sambaash.platform.srv.service.base.OutlineLocalServiceBaseImpl;

/**
 * The implementation of the outline local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.service.OutlineLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.OutlineLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.OutlineLocalServiceUtil
 */
public class OutlineLocalServiceImpl extends OutlineLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.service.OutlineLocalServiceUtil} to access the
	 * outline local service.
	 */

	public Outline create() throws SystemException{
		long spOutlineId = CounterLocalServiceUtil.increment("Outline.class");
		Outline outline = OutlineLocalServiceUtil.createOutline(spOutlineId);
		return outline;
	}
	public List<Outline> findByGroupIdAndOutlineType(Long groupId, Long outlineType) throws SystemException {
		return outlinePersistence.findByGroupIdAndOutlineType(groupId, outlineType);
	}

	public List<Outline> findByGroupIdAndCompetencyUnitId(Long groupId, Long spCompetnectyUnitId) throws SystemException  {
		return outlinePersistence.findByGroupIdAndCompetencyUnitId(groupId, spCompetnectyUnitId);
	}

	public void clearCache() {
		outlinePersistence.clearCache();
	}

}