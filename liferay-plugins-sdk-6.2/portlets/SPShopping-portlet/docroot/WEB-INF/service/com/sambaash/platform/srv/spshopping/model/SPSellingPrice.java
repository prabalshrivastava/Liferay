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

package com.sambaash.platform.srv.spshopping.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the SPSellingPrice service. Represents a row in the &quot;SPSellingPrice&quot; database table, with each column mapped to a property of this class.
 *
 * @author pradeep
 * @see SPSellingPriceModel
 * @see com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceImpl
 * @see com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceModelImpl
 * @generated
 */
public interface SPSellingPrice extends SPSellingPriceModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.math.BigDecimal getBasePriceAmount();

	public void setBasePriceAmount(java.math.BigDecimal basePriceAmount);

	public java.math.BigDecimal getTaxValueAmount();

	public void setTaxValueAmount(java.lang.String taxValueAmount);

	public java.math.BigDecimal getTotalPriceAmount();

	public void setTotalPriceAmount(java.math.BigDecimal totalPriceAmount);
}