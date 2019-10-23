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

package com.sambaash.platform.srv.spsocialprofile.service.base;

import com.sambaash.platform.srv.spsocialprofile.service.UserAvailabilityCalendarLocalServiceUtil;

import java.util.Arrays;

/**
 * @author gauravvijayvergia
 * @generated
 */
public class UserAvailabilityCalendarLocalServiceClpInvoker {
	public UserAvailabilityCalendarLocalServiceClpInvoker() {
		_methodName0 = "addUserAvailabilityCalendar";

		_methodParameterTypes0 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar"
			};

		_methodName1 = "createUserAvailabilityCalendar";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteUserAvailabilityCalendar";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteUserAvailabilityCalendar";

		_methodParameterTypes3 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchUserAvailabilityCalendar";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getUserAvailabilityCalendar";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getUserAvailabilityCalendars";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getUserAvailabilityCalendarsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateUserAvailabilityCalendar";

		_methodParameterTypes15 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar"
			};

		_methodName64 = "getBeanIdentifier";

		_methodParameterTypes64 = new String[] {  };

		_methodName65 = "setBeanIdentifier";

		_methodParameterTypes65 = new String[] { "java.lang.String" };

		_methodName70 = "addUserAvailabilityCalendar";

		_methodParameterTypes70 = new String[] {
				"long", "long", "java.lang.String", "java.util.Date",
				"java.util.Date"
			};

		_methodName71 = "deleteUserAvailabilityInfo";

		_methodParameterTypes71 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar"
			};

		_methodName72 = "delUserAvailabilityCalendar";

		_methodParameterTypes72 = new String[] { "long" };

		_methodName73 = "getActiveCalendarListByUserId";

		_methodParameterTypes73 = new String[] {
				"java.lang.Long", "java.lang.Long"
			};

		_methodName74 = "getUserAvailabilityList";

		_methodParameterTypes74 = new String[] {
				"java.lang.Long", "java.lang.Long"
			};

		_methodName75 = "updateUserAvailabilityCal";

		_methodParameterTypes75 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return UserAvailabilityCalendarLocalServiceUtil.addUserAvailabilityCalendar((com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return UserAvailabilityCalendarLocalServiceUtil.createUserAvailabilityCalendar(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return UserAvailabilityCalendarLocalServiceUtil.deleteUserAvailabilityCalendar(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return UserAvailabilityCalendarLocalServiceUtil.deleteUserAvailabilityCalendar((com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return UserAvailabilityCalendarLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return UserAvailabilityCalendarLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return UserAvailabilityCalendarLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return UserAvailabilityCalendarLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return UserAvailabilityCalendarLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return UserAvailabilityCalendarLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return UserAvailabilityCalendarLocalServiceUtil.fetchUserAvailabilityCalendar(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return UserAvailabilityCalendarLocalServiceUtil.getUserAvailabilityCalendar(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return UserAvailabilityCalendarLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return UserAvailabilityCalendarLocalServiceUtil.getUserAvailabilityCalendars(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return UserAvailabilityCalendarLocalServiceUtil.getUserAvailabilityCalendarsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return UserAvailabilityCalendarLocalServiceUtil.updateUserAvailabilityCalendar((com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar)arguments[0]);
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return UserAvailabilityCalendarLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			UserAvailabilityCalendarLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return UserAvailabilityCalendarLocalServiceUtil.addUserAvailabilityCalendar(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				(java.util.Date)arguments[4]);
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			UserAvailabilityCalendarLocalServiceUtil.deleteUserAvailabilityInfo((com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar)arguments[0]);

			return null;
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			UserAvailabilityCalendarLocalServiceUtil.delUserAvailabilityCalendar(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return UserAvailabilityCalendarLocalServiceUtil.getActiveCalendarListByUserId((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1]);
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return UserAvailabilityCalendarLocalServiceUtil.getUserAvailabilityList((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1]);
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			UserAvailabilityCalendarLocalServiceUtil.updateUserAvailabilityCal((com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar)arguments[0]);

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
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
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName64;
	private String[] _methodParameterTypes64;
	private String _methodName65;
	private String[] _methodParameterTypes65;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
}