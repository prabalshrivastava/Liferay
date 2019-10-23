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

package com.sambaash.platform.srv.spshopping.model.impl;

import java.math.BigDecimal;

/**
 * The extended model implementation for the SPSellingPrice service. Represents a row in the &quot;SP_SELLING_PRICE&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.spshopping.model.SPSellingPrice} interface.
 * </p>
 *
 * @author pradeep
 */
public class SPSellingPriceImpl extends SPSellingPriceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a s p selling price model instance should use the {@link com.sambaash.platform.srv.spshopping.model.SPSellingPrice} interface instead.
	 */
	public SPSellingPriceImpl() {
	}
	
	/*
	 * When retrieving or setting amount field values, use the method prefixed with Amount instead.
	 */
	public BigDecimal getBasePriceAmount() {
		return new BigDecimal(super.getBasePrice()) ;
	}

	public void setBasePriceAmount(BigDecimal basePriceAmount) {
		super.setBasePrice(basePriceAmount.toString());
	}

	public BigDecimal getTaxValueAmount() {
		return new BigDecimal(super.getTaxValue());
	}

	public void setTaxValueAmount(String taxValueAmount) {
		super.setTaxValue(taxValueAmount.toString());
	}

	public BigDecimal getTotalPriceAmount() {
		return new BigDecimal(super.getTotalPrice());
	}

	public void setTotalPriceAmount(BigDecimal totalPriceAmount) {
		super.setTotalPrice(totalPriceAmount.toString());
	}
	
	@Override @Deprecated
	public String getBasePrice() {
		return super.getBasePrice();
	}

	@Override @Deprecated
	public void setBasePrice(String basePrice) {
		super.setBasePrice(basePrice);
	}

	@Override @Deprecated
	public String getTaxValue() {
		return super.getTaxValue();
	}

	@Override @Deprecated
	public void setTaxValue(String taxValue) {
		super.setTaxValue(taxValue);
	}

	@Override @Deprecated
	public String getTotalPrice() {
		return super.getTotalPrice();
	}

	@Override @Deprecated
	public void setTotalPrice(String totalPrice) {
		super.setTotalPrice(totalPrice);
	}
	
}