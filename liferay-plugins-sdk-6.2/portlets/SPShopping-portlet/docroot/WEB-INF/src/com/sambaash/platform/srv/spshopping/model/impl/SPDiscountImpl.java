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
 * The extended model implementation for the SPDiscount service. Represents a row in the &quot;SP_DISCOUNT&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.spshopping.model.SPDiscount} interface.
 * </p>
 *
 * @author pradeep
 */
public class SPDiscountImpl extends SPDiscountBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a s p discount model instance should use the {@link com.sambaash.platform.srv.spshopping.model.SPDiscount} interface instead.
	 */
	public SPDiscountImpl() {
	}

	/*
	 * When retrieving or setting amount field values, use the method prefixed with Amount instead.
	 */

	public BigDecimal getValueAmount() {
		// TODO Auto-generated method stub
		return new BigDecimal(super.getValue());
	}

	public void setValue(BigDecimal valueAmount) {
		// TODO Auto-generated method stub
		super.setValue(valueAmount.toString());
	}

	@Override  @Deprecated
	public String getValue() {
		// TODO Auto-generated method stub
		return super.getValue();
	}

	@Override  @Deprecated
	public void setValue(String value) {
		// TODO Auto-generated method stub
		super.setValue(value);
	}

	
}