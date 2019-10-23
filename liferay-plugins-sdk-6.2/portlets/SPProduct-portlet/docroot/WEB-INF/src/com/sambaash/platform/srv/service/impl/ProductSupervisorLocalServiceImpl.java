/**
s * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.product.util.SPProductConstants;
import com.sambaash.platform.srv.model.ProductSupervisor;
import com.sambaash.platform.srv.service.ProductSupervisorLocalServiceUtil;
import com.sambaash.platform.srv.service.base.ProductSupervisorLocalServiceBaseImpl;

/**
 * The implementation of the product supervisor local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.service.ProductSupervisorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.ProductSupervisorLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.ProductSupervisorLocalServiceUtil
 */
public class ProductSupervisorLocalServiceImpl
	extends ProductSupervisorLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.service.ProductSupervisorLocalServiceUtil} to access the product supervisor local service.
	 */
	
	/**
	 *  This method returns the supervisor id using the parameteres passed.
	 *  
	 *    If countryName is empty it will be ignored
	 *    If countryId is 0, it will be ignored
	 *    If productId is 0, it will be ignored.
	 *    
	 *    Atleast one of the three parameteres must have valid value
	 * 
	 * @param countryName
	 * @param countryId
	 * @param productId
	 * @return
	 * @throws SystemException 
	 */
	@SuppressWarnings("unchecked")
	public long getSupervisor(String countryName,long countryId,long productId) throws SystemException{
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(ProductSupervisor.class, PortletClassLoaderUtil.getClassLoader(SPProductConstants.PORTLET_ID));
		
		if(Validator.isNotNull(countryName)){
			query.add(RestrictionsFactoryUtil.eq("countryName", countryName));
		}

		if(countryId > 0){
				query.add(RestrictionsFactoryUtil.eq("countryId", countryId));
		}
		
		if(productId > 0){
			query.add(RestrictionsFactoryUtil.eq("productId", productId));
		}
		
		List<ProductSupervisor> list = ProductSupervisorLocalServiceUtil.dynamicQuery(query);
		if(!list.isEmpty()){
			ProductSupervisor ps = list.get(0);
			return ps.getSupervisorId();
		}
		return 0;
	}
}