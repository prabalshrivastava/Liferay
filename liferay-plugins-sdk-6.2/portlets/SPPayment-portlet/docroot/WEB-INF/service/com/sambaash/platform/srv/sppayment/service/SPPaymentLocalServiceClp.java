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

package com.sambaash.platform.srv.sppayment.service;

import com.liferay.portal.service.InvokableLocalService;

/**
 * @author pradeep
 * @generated
 */
public class SPPaymentLocalServiceClp implements SPPaymentLocalService {
	public SPPaymentLocalServiceClp(InvokableLocalService invokableLocalService) {
		_invokableLocalService = invokableLocalService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "chargePayment";

		_methodParameterTypes3 = new String[] { "javax.portlet.PortletRequest" };

		_methodName4 = "refundPayment";

		_methodParameterTypes4 = new String[] { "javax.portlet.PortletRequest" };

		_methodName5 = "chargePayment";

		_methodParameterTypes5 = new String[] { "java.util.Map" };

		_methodName6 = "refundPayment";

		_methodParameterTypes6 = new String[] { "java.util.Map" };
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
	public com.sambaash.platform.model.payment.ChargeStatus chargePayment(
		javax.portlet.PortletRequest request) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] { ClpSerializer.translateInput(request) });
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

		return (com.sambaash.platform.model.payment.ChargeStatus)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.model.payment.ChargeStatus refundPayment(
		javax.portlet.PortletRequest request) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName4,
					_methodParameterTypes4,
					new Object[] { ClpSerializer.translateInput(request) });
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

		return (com.sambaash.platform.model.payment.ChargeStatus)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.model.payment.ChargeStatus chargePayment(
		java.util.Map<java.lang.String, java.lang.Object> requestMap) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] { ClpSerializer.translateInput(requestMap) });
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

		return (com.sambaash.platform.model.payment.ChargeStatus)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.model.payment.ChargeStatus refundPayment(
		java.util.Map<java.lang.String, java.lang.Object> requestMap) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] { ClpSerializer.translateInput(requestMap) });
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

		return (com.sambaash.platform.model.payment.ChargeStatus)ClpSerializer.translateOutput(returnObj);
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
}