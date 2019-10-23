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

package com.sambaash.platform.srv.spshopping.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException;
import com.sambaash.platform.srv.spshopping.model.SPSellingPrice;
import com.sambaash.platform.srv.spshopping.service.base.SPSellingPriceLocalServiceBaseImpl;

/**
 * The implementation of the s p selling price local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.spshopping.service.SPSellingPriceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author pradeep
 * @see com.sambaash.platform.srv.spshopping.service.base.SPSellingPriceLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spshopping.service.SPSellingPriceLocalServiceUtil
 */
public class SPSellingPriceLocalServiceImpl
	extends SPSellingPriceLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.spshopping.service.SPSellingPriceLocalServiceUtil} to access the s p selling price local service.
	 */
	public List<SPSellingPrice> findPriceByItemId(long spSellingItemId)
			throws SystemException {
		return spSellingPricePersistence.findBysellingItemId(spSellingItemId);
	}
	
	public SPSellingPrice findPriceByPackageId(long spSellingPackageId)
			throws SystemException, NoSuchSPSellingPriceException {
		// Different currencies have to configured in diff pacakges
		return spSellingPricePersistence.findBysellingPackageId(spSellingPackageId);
	}
}