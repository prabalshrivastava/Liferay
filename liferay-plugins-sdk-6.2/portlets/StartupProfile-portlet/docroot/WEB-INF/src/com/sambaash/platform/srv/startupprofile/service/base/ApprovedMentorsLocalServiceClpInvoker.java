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

package com.sambaash.platform.srv.startupprofile.service.base;

import com.sambaash.platform.srv.startupprofile.service.ApprovedMentorsLocalServiceUtil;

import java.util.Arrays;

/**
 * @author pradeep
 * @generated
 */
public class ApprovedMentorsLocalServiceClpInvoker {
	public ApprovedMentorsLocalServiceClpInvoker() {
		_methodName0 = "addApprovedMentors";

		_methodParameterTypes0 = new String[] {
				"com.sambaash.platform.srv.startupprofile.model.ApprovedMentors"
			};

		_methodName1 = "createApprovedMentors";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteApprovedMentors";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteApprovedMentors";

		_methodParameterTypes3 = new String[] {
				"com.sambaash.platform.srv.startupprofile.model.ApprovedMentors"
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

		_methodName10 = "fetchApprovedMentors";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getApprovedMentors";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getApprovedMentorses";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getApprovedMentorsesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateApprovedMentors";

		_methodParameterTypes15 = new String[] {
				"com.sambaash.platform.srv.startupprofile.model.ApprovedMentors"
			};

		_methodName98 = "getBeanIdentifier";

		_methodParameterTypes98 = new String[] {  };

		_methodName99 = "setBeanIdentifier";

		_methodParameterTypes99 = new String[] { "java.lang.String" };

		_methodName104 = "findByOrganizationId";

		_methodParameterTypes104 = new String[] { "long" };

		_methodName105 = "findByUserId";

		_methodParameterTypes105 = new String[] { "java.lang.String" };

		_methodName106 = "findByOrganizationAndUserId";

		_methodParameterTypes106 = new String[] { "long", "java.lang.String" };

		_methodName107 = "findApprovedMentorsByOrganizationId";

		_methodParameterTypes107 = new String[] { "long" };

		_methodName108 = "findApprovedMentorsByOrganizationIdWithOthers";

		_methodParameterTypes108 = new String[] { "long" };

		_methodName109 = "findApprovedMentorsByOrganizationIdAndStatus";

		_methodParameterTypes109 = new String[] { "long", "int" };

		_methodName110 = "findApprovedMentorsByUserIdAndStatus";

		_methodParameterTypes110 = new String[] { "long", "int" };

		_methodName111 = "findApprovedMentorsByStatus";

		_methodParameterTypes111 = new String[] { "int" };

		_methodName112 = "findMentorsByOrganizationId";

		_methodParameterTypes112 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.addApprovedMentors((com.sambaash.platform.srv.startupprofile.model.ApprovedMentors)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.createApprovedMentors(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.deleteApprovedMentors(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.deleteApprovedMentors((com.sambaash.platform.srv.startupprofile.model.ApprovedMentors)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.fetchApprovedMentors(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.getApprovedMentors(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.getApprovedMentorses(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.getApprovedMentorsesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.updateApprovedMentors((com.sambaash.platform.srv.startupprofile.model.ApprovedMentors)arguments[0]);
		}

		if (_methodName98.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName99.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes99, parameterTypes)) {
			ApprovedMentorsLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName104.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes104, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.findByOrganizationId(((Long)arguments[0]).longValue());
		}

		if (_methodName105.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes105, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.findByUserId((java.lang.String)arguments[0]);
		}

		if (_methodName106.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes106, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.findByOrganizationAndUserId(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName107.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes107, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.findApprovedMentorsByOrganizationId(((Long)arguments[0]).longValue());
		}

		if (_methodName108.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes108, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.findApprovedMentorsByOrganizationIdWithOthers(((Long)arguments[0]).longValue());
		}

		if (_methodName109.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes109, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.findApprovedMentorsByOrganizationIdAndStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName110.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.findApprovedMentorsByUserIdAndStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName111.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes111, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.findApprovedMentorsByStatus(((Integer)arguments[0]).intValue());
		}

		if (_methodName112.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes112, parameterTypes)) {
			return ApprovedMentorsLocalServiceUtil.findMentorsByOrganizationId(((Long)arguments[0]).longValue());
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
	private String _methodName98;
	private String[] _methodParameterTypes98;
	private String _methodName99;
	private String[] _methodParameterTypes99;
	private String _methodName104;
	private String[] _methodParameterTypes104;
	private String _methodName105;
	private String[] _methodParameterTypes105;
	private String _methodName106;
	private String[] _methodParameterTypes106;
	private String _methodName107;
	private String[] _methodParameterTypes107;
	private String _methodName108;
	private String[] _methodParameterTypes108;
	private String _methodName109;
	private String[] _methodParameterTypes109;
	private String _methodName110;
	private String[] _methodParameterTypes110;
	private String _methodName111;
	private String[] _methodParameterTypes111;
	private String _methodName112;
	private String[] _methodParameterTypes112;
}