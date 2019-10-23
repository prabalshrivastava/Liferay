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

package com.sambaash.platform.srv.service.impl;

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.sambaash.platform.product.util.SPProductConstants;
import com.sambaash.platform.srv.NoSuchFeeTypeException;
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.FeeType;
import com.sambaash.platform.srv.service.CourseLocalServiceUtil;
import com.sambaash.platform.srv.service.FeeTypeLocalServiceUtil;
import com.sambaash.platform.srv.service.base.FeeTypeLocalServiceBaseImpl;

/**
 * The implementation of the fee type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.service.FeeTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.FeeTypeLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.FeeTypeLocalServiceUtil
 */
public class FeeTypeLocalServiceImpl extends FeeTypeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.service.FeeTypeLocalServiceUtil} to access the fee type local service.
	 */
	
	public List<FeeType> findByMisc(boolean misc) throws com.liferay.portal.kernel.exception.SystemException {
		return feeTypePersistence.findByMisc(misc);
	}
	
	public FeeType findByFeeType(String feeType) throws NoSuchFeeTypeException, SystemException{
		DynamicQuery dynaQuery = DynamicQueryFactoryUtil.forClass(FeeType.class,
				PortletClassLoaderUtil.getClassLoader(SPProductConstants.PORTLET_ID));
		Criterion criterion1 = RestrictionsFactoryUtil.eq("feeType", feeType);
		dynaQuery.add(criterion1);
		List<FeeType>list = feeTypeLocalService.dynamicQuery(dynaQuery);
		if(list.size() > 0){
			return list.get(0);
		}
		throw new NoSuchFeeTypeException();
		//return FeeTypeUtil.findByFeeType(feeType);
	}
	
	
	public FeeType create() throws SystemException{
		long spFeeTypeId = CounterLocalServiceUtil.increment("FeeType.class");
		FeeType feeType = FeeTypeLocalServiceUtil.createFeeType(spFeeTypeId);
		return feeType;
	}
	public void clearCache() {
		feeTypePersistence.clearCache();
	}
}