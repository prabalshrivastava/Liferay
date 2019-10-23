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

package com.sambaash.platform.finance.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sambaash.platform.finance.service.SPFinanceServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sambaash.platform.finance.service.SPFinanceServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author abhishek.upadhyay
 * @see SPFinanceServiceHttp
 * @see com.sambaash.platform.finance.service.SPFinanceServiceUtil
 * @generated
 */
public class SPFinanceServiceSoap {
	public static java.lang.String generateReferenceNumber(long scopeGroupId,
		java.lang.String productType, java.lang.String productSubType,
		java.lang.String functionalComponent, java.lang.String categoryType,
		java.lang.String clientType) throws RemoteException {
		try {
			java.lang.String returnValue = SPFinanceServiceUtil.generateReferenceNumber(scopeGroupId,
					productType, productSubType, functionalComponent,
					categoryType, clientType);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String saveTransactionData(long scopeGroupId,
		java.lang.String productType, java.lang.String productSubType,
		java.lang.String functionalComponent, java.lang.String categoryType,
		java.lang.String clientType, java.lang.String txnDate,
		java.lang.String source, java.lang.String componentRefNumber,
		java.lang.String txnType, java.lang.String title,
		java.lang.String description, java.lang.String dueDate,
		java.lang.String valueDate, java.lang.String creditDate,
		java.lang.String transactionDetailJson,
		java.lang.String paymentDetailJson) throws RemoteException {
		try {
			java.lang.String returnValue = SPFinanceServiceUtil.saveTransactionData(scopeGroupId,
					productType, productSubType, functionalComponent,
					categoryType, clientType, txnDate, source,
					componentRefNumber, txnType, title, description, dueDate,
					valueDate, creditDate, transactionDetailJson,
					paymentDetailJson);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String saveCreditBalance(long scopeGroupId,
		java.lang.Long creditBalanceAmt, java.lang.String status,
		java.lang.String usereId, java.lang.String userName,
		java.lang.String userType) throws RemoteException {
		try {
			java.lang.String returnValue = SPFinanceServiceUtil.saveCreditBalance(scopeGroupId,
					creditBalanceAmt, status, usereId, userName, userType);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SPFinanceServiceSoap.class);
}