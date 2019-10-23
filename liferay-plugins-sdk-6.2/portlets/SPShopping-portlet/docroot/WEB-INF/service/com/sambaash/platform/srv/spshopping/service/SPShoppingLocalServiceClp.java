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

package com.sambaash.platform.srv.spshopping.service;

import com.liferay.portal.service.InvokableLocalService;

/**
 * @author pradeep
 * @generated
 */
public class SPShoppingLocalServiceClp implements SPShoppingLocalService {
	public SPShoppingLocalServiceClp(
		InvokableLocalService invokableLocalService) {
		_invokableLocalService = invokableLocalService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "addProductCatalog";

		_methodParameterTypes3 = new String[] {
				"long", "long", "long", "java.lang.String", "long", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName4 = "addProductInventory";

		_methodParameterTypes4 = new String[] {
				"long", "long", "long", "java.lang.String", "long", "long",
				"java.util.Date", "java.util.Date", "int"
			};

		_methodName5 = "retrieveProductInventory";

		_methodParameterTypes5 = new String[] { "long", "long" };

		_methodName6 = "retrieveRemainingInventory";

		_methodParameterTypes6 = new String[] { "long", "long" };

		_methodName7 = "hasEnoughInventory";

		_methodParameterTypes7 = new String[] { "long", "long", "int" };

		_methodName8 = "addProductPrice";

		_methodParameterTypes8 = new String[] {
				"long", "long", "long", "java.lang.String", "long", "long",
				"java.lang.String", "java.math.BigDecimal"
			};

		_methodName9 = "createPaymentCart";

		_methodParameterTypes9 = new String[] {
				"long", "long", "long", "java.lang.String", "java.lang.String",
				"long", "java.math.BigDecimal", "java.lang.String"
			};

		_methodName10 = "createPaymentCart";

		_methodParameterTypes10 = new String[] {
				"long", "long", "long", "java.lang.String", "java.lang.String",
				"long", "java.math.BigDecimal", "java.lang.String", "int"
			};

		_methodName11 = "retrievePakageWithEnoughInventory";

		_methodParameterTypes11 = new String[] { "long", "long", "int" };

		_methodName12 = "confirmPayment";

		_methodParameterTypes12 = new String[] { "long", "int" };

		_methodName13 = "rejectPayment";

		_methodParameterTypes13 = new String[] { "long" };
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName0,
					_methodParameterTypes0, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableLocalService.invokeMethod(_methodName1,
				_methodParameterTypes1,
				new Object[] { ClpSerializer.translateInput(beanIdentifier) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public long addProductCatalog(long companyId, long groupId, long userId,
		java.lang.String userName, long classNameId, long classPk,
		java.lang.String title, java.lang.String itemCode,
		java.lang.String shortDesc, java.lang.String longDesc) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] {
						companyId,
						
					groupId,
						
					userId,
						
					ClpSerializer.translateInput(userName),
						
					classNameId,
						
					classPk,
						
					ClpSerializer.translateInput(title),
						
					ClpSerializer.translateInput(itemCode),
						
					ClpSerializer.translateInput(shortDesc),
						
					ClpSerializer.translateInput(longDesc)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	@Override
	public void addProductInventory(long companyId, long groupId, long userId,
		java.lang.String userName, long classNameId, long classPk,
		java.util.Date startDate, java.util.Date endDate, int quantity) {
		try {
			_invokableLocalService.invokeMethod(_methodName4,
				_methodParameterTypes4,
				new Object[] {
					companyId,
					
				groupId,
					
				userId,
					
				ClpSerializer.translateInput(userName),
					
				classNameId,
					
				classPk,
					
				ClpSerializer.translateInput(startDate),
					
				ClpSerializer.translateInput(endDate),
					
				quantity
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray retrieveProductInventory(
		long classNameId, long classPk) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] { classNameId, classPk });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.json.JSONArray)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int retrieveRemainingInventory(long classNameId, long classPk) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] { classNameId, classPk });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public boolean hasEnoughInventory(long classNameId, long classPk,
		int inventoryNeeded) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] { classNameId, classPk, inventoryNeeded });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public long addProductPrice(long companyId, long groupId, long userId,
		java.lang.String userName, long classNameId, long classPk,
		java.lang.String currencyCode, java.math.BigDecimal price) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName8,
					_methodParameterTypes8,
					new Object[] {
						companyId,
						
					groupId,
						
					userId,
						
					ClpSerializer.translateInput(userName),
						
					classNameId,
						
					classPk,
						
					ClpSerializer.translateInput(currencyCode),
						
					ClpSerializer.translateInput(price)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	@Override
	public long createPaymentCart(long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String payItemClassName,
		long payItemClassPk, java.math.BigDecimal payAmount,
		java.lang.String payCcy) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] {
						companyId,
						
					groupId,
						
					userId,
						
					ClpSerializer.translateInput(userName),
						
					ClpSerializer.translateInput(payItemClassName),
						
					payItemClassPk,
						
					ClpSerializer.translateInput(payAmount),
						
					ClpSerializer.translateInput(payCcy)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	@Override
	public long createPaymentCart(long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String payItemClassName,
		long payItemClassPk, java.math.BigDecimal payAmount,
		java.lang.String payCcy, int quantity) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName10,
					_methodParameterTypes10,
					new Object[] {
						companyId,
						
					groupId,
						
					userId,
						
					ClpSerializer.translateInput(userName),
						
					ClpSerializer.translateInput(payItemClassName),
						
					payItemClassPk,
						
					ClpSerializer.translateInput(payAmount),
						
					ClpSerializer.translateInput(payCcy),
						
					quantity
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	@Override
	public long retrievePakageWithEnoughInventory(long classNameId,
		long classPk, int qty) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName11,
					_methodParameterTypes11,
					new Object[] { classNameId, classPk, qty });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	@Override
	public void confirmPayment(long cartId, int confirmedQty) {
		try {
			_invokableLocalService.invokeMethod(_methodName12,
				_methodParameterTypes12, new Object[] { cartId, confirmedQty });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void rejectPayment(long cartId) {
		try {
			_invokableLocalService.invokeMethod(_methodName13,
				_methodParameterTypes13, new Object[] { cartId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	private InvokableLocalService _invokableLocalService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
}