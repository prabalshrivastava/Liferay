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

package com.sambaash.platform.srv.spshopping.service.base;

import com.sambaash.platform.srv.spshopping.service.SPShoppingLocalServiceUtil;

import java.util.Arrays;

/**
 * @author pradeep
 * @generated
 */
public class SPShoppingLocalServiceClpInvoker {
	public SPShoppingLocalServiceClpInvoker() {
		_methodName52 = "getBeanIdentifier";

		_methodParameterTypes52 = new String[] {  };

		_methodName53 = "setBeanIdentifier";

		_methodParameterTypes53 = new String[] { "java.lang.String" };

		_methodName56 = "addProductCatalog";

		_methodParameterTypes56 = new String[] {
				"long", "long", "long", "java.lang.String", "long", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName57 = "addProductInventory";

		_methodParameterTypes57 = new String[] {
				"long", "long", "long", "java.lang.String", "long", "long",
				"java.util.Date", "java.util.Date", "int"
			};

		_methodName58 = "retrieveProductInventory";

		_methodParameterTypes58 = new String[] { "long", "long" };

		_methodName59 = "retrieveRemainingInventory";

		_methodParameterTypes59 = new String[] { "long", "long" };

		_methodName61 = "hasEnoughInventory";

		_methodParameterTypes61 = new String[] { "long", "long", "int" };

		_methodName62 = "addProductPrice";

		_methodParameterTypes62 = new String[] {
				"long", "long", "long", "java.lang.String", "long", "long",
				"java.lang.String", "java.math.BigDecimal"
			};

		_methodName63 = "createPaymentCart";

		_methodParameterTypes63 = new String[] {
				"long", "long", "long", "java.lang.String", "java.lang.String",
				"long", "java.math.BigDecimal", "java.lang.String"
			};

		_methodName64 = "createPaymentCart";

		_methodParameterTypes64 = new String[] {
				"long", "long", "long", "java.lang.String", "java.lang.String",
				"long", "java.math.BigDecimal", "java.lang.String", "int"
			};

		_methodName65 = "retrievePakageWithEnoughInventory";

		_methodParameterTypes65 = new String[] { "long", "long", "int" };

		_methodName66 = "confirmPayment";

		_methodParameterTypes66 = new String[] { "long", "int" };

		_methodName67 = "rejectPayment";

		_methodParameterTypes67 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			return SPShoppingLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			SPShoppingLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return SPShoppingLocalServiceUtil.addProductCatalog(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				(java.lang.String)arguments[6], (java.lang.String)arguments[7],
				(java.lang.String)arguments[8], (java.lang.String)arguments[9]);
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			SPShoppingLocalServiceUtil.addProductInventory(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(), (java.util.Date)arguments[6],
				(java.util.Date)arguments[7], ((Integer)arguments[8]).intValue());

			return null;
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return SPShoppingLocalServiceUtil.retrieveProductInventory(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return SPShoppingLocalServiceUtil.retrieveRemainingInventory(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return SPShoppingLocalServiceUtil.hasEnoughInventory(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return SPShoppingLocalServiceUtil.addProductPrice(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				(java.lang.String)arguments[6],
				(java.math.BigDecimal)arguments[7]);
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			return SPShoppingLocalServiceUtil.createPaymentCart(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				((Long)arguments[5]).longValue(),
				(java.math.BigDecimal)arguments[6],
				(java.lang.String)arguments[7]);
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return SPShoppingLocalServiceUtil.createPaymentCart(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				((Long)arguments[5]).longValue(),
				(java.math.BigDecimal)arguments[6],
				(java.lang.String)arguments[7],
				((Integer)arguments[8]).intValue());
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			return SPShoppingLocalServiceUtil.retrievePakageWithEnoughInventory(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			SPShoppingLocalServiceUtil.confirmPayment(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());

			return null;
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			SPShoppingLocalServiceUtil.rejectPayment(((Long)arguments[0]).longValue());

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName61;
	private String[] _methodParameterTypes61;
	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
	private String _methodName64;
	private String[] _methodParameterTypes64;
	private String _methodName65;
	private String[] _methodParameterTypes65;
	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
}