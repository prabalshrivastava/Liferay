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
 * The extended model implementation for the SPCartPackage service. Represents a row in the &quot;SP_CART_PACKAGE&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.spshopping.model.SPCartPackage} interface.
 * </p>
 *
 * @author pradeep
 */
public class SPCartPackageImpl extends SPCartPackageBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a s p cart package model instance should use the {@link com.sambaash.platform.srv.spshopping.model.SPCartPackage} interface instead.
	 */
	public SPCartPackageImpl() {
	}

	/*
	 * When retrieving or setting amount field values, use the method prefixed with Amount instead.
	 */

	public BigDecimal getInitialPriceAmount() {
		// TODO Auto-generated method stub
		return new BigDecimal(super.getInitialPrice());
	}

	public void setInitialPriceAmount(BigDecimal initialPriceAmount) {
		// TODO Auto-generated method stub
		super.setInitialPrice(initialPriceAmount.toString());
	}

	public BigDecimal getTotalPriceAmount() {
		// TODO Auto-generated method stub
		return new BigDecimal(super.getTotalPrice());
	}

	public void setTotalPriceAmount(BigDecimal totalPriceAmount) {
		// TODO Auto-generated method stub
		super.setTotalPrice(totalPriceAmount.toString());
	}
	
	public BigDecimal getDiscountAmount() {
		// TODO Auto-generated method stub
		return new BigDecimal(super.getDiscount());
	}

	public void setDiscountAmount(BigDecimal discount) {
		// TODO Auto-generated method stub
		super.setDiscount(discount.toString());
	}
	
	@Override @Deprecated
	public String getInitialPrice() {
		// TODO Auto-generated method stub
		return super.getInitialPrice();
	}

	@Override @Deprecated
	public void setInitialPrice(String initialPrice) {
		// TODO Auto-generated method stub
		super.setInitialPrice(initialPrice);
	}

	@Override @Deprecated
	public String getTotalPrice() {
		// TODO Auto-generated method stub
		return super.getTotalPrice();
	}

	@Override @Deprecated
	public void setTotalPrice(String totalPrice) {
		// TODO Auto-generated method stub
		super.setTotalPrice(totalPrice);
	}

	@Override @Deprecated
	public String getDiscount() {
		// TODO Auto-generated method stub
		return super.getDiscount();
	}

	@Override @Deprecated
	public void setDiscount(String discount) {
		// TODO Auto-generated method stub
		super.setDiscount(discount);
	}
	
}