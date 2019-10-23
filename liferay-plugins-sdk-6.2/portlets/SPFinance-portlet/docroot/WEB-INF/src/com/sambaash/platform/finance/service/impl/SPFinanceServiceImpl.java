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

package com.sambaash.platform.finance.service.impl;

import com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil;
import com.sambaash.platform.finance.service.base.SPFinanceServiceBaseImpl;

/**
 * The implementation of the s p finance remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.finance.service.SPFinanceService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author abhishek.upadhyay
 * @see com.sambaash.platform.finance.service.base.SPFinanceServiceBaseImpl
 * @see com.sambaash.platform.finance.service.SPFinanceServiceUtil
 */
public class SPFinanceServiceImpl extends SPFinanceServiceBaseImpl {
	
	public String generateReferenceNumber(long scopeGroupId, String productType, String productSubType, String functionalComponent, 
			String categoryType, String clientType) {
		return SPFinanceLocalServiceUtil.generateReferenceNumber(scopeGroupId, productType, productSubType, functionalComponent, categoryType, clientType);
	}
	
	public String saveTransactionData(long scopeGroupId, String productType, String productSubType, String functionalComponent, 
			String categoryType, String clientType, String txnDate, String source, String componentRefNumber, String txnType, String title, String description, 
			String dueDate, String valueDate,String creditDate, String transactionDetailJson, String paymentDetailJson) {
		return SPFinanceLocalServiceUtil.saveTransactionData(scopeGroupId, productType, productSubType, functionalComponent, categoryType, 
				clientType, txnDate, source, componentRefNumber, txnType, title, description, dueDate, valueDate, creditDate, transactionDetailJson, paymentDetailJson);
	}
	
	public String saveCreditBalance(long scopeGroupId, Long creditBalanceAmt, String status, String usereId, String userName, String userType)  {
		return SPFinanceLocalServiceUtil.saveCreditBalance(scopeGroupId, creditBalanceAmt, status, usereId, userName, userType) ;
	}
	
}