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
 * The extended model interface for the SPCartPackage service. Represents a row in the &quot;SPCartPackage&quot; database table, with each column mapped to a property of this class.
 *
 * @author pradeep
 * @see SPCartPackageModel
 * @see com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageImpl
 * @see com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageModelImpl
 * @generated
 */
public interface SPCartPackage extends SPCartPackageModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.math.BigDecimal getInitialPriceAmount();

	public void setInitialPriceAmount(java.math.BigDecimal initialPriceAmount);

	public java.math.BigDecimal getTotalPriceAmount();

	public void setTotalPriceAmount(java.math.BigDecimal totalPriceAmount);

	public java.math.BigDecimal getDiscountAmount();

	public void setDiscountAmount(java.math.BigDecimal discount);
}