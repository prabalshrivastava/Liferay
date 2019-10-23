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

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.srv.model.ProductSupervisor;
import com.sambaash.platform.srv.processbuilder.model.PESupervisor;
import com.sambaash.platform.srv.processbuilder.service.PESupervisorLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.base.PESupervisorLocalServiceBaseImpl;
import com.sambaash.platform.srv.service.ProductSupervisorLocalServiceUtil;

/**
 * The implementation of the p e supervisor local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.processbuilder.service.PESupervisorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.srv.processbuilder.service.base.PESupervisorLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.processbuilder.service.PESupervisorLocalServiceUtil
 */
public class PESupervisorLocalServiceImpl
	extends PESupervisorLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.processbuilder.service.PESupervisorLocalServiceUtil} to access the p e supervisor local service.
	 */
	
	
	
	public long getSupervisor(List<Entry<String, String>>listEntry,String filterType) throws SystemException{
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(PESupervisor.class, PortletClassLoaderUtil.getClassLoader(PEConstants.PORTLET_ID));
		//Set<Entry<String,String>> set=map.entrySet();
		
		Junction junction = null;
		if(PEConstants.FILTER_TYPE_AND.equalsIgnoreCase(filterType)){
			junction = RestrictionsFactoryUtil.conjunction();
			
		}else {
			junction = RestrictionsFactoryUtil.disjunction();
		}
		
		for (Entry<String,String> entry : listEntry) {
			Criterion criterion = RestrictionsFactoryUtil.eq(entry.getKey(), entry.getValue());
			junction.add(criterion);
		}
		
		query.add(junction);
		
		List<PESupervisor> list = PESupervisorLocalServiceUtil.dynamicQuery(query);
		if(!list.isEmpty()){
			PESupervisor ps = list.get(0);
			return ps.getSupervisorId();
		}
		return 0;
	}
}