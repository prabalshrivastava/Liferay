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

package com.sambaash.platform.srv.spservices.service.base;

import com.sambaash.platform.srv.spservices.service.MembershipPackageGrpServicesLocalServiceUtil;

import java.util.Arrays;

/**
 * @author gauravvijayvergia
 * @generated
 */
public class MembershipPackageGrpServicesLocalServiceClpInvoker {
	public MembershipPackageGrpServicesLocalServiceClpInvoker() {
		_methodName0 = "addMembershipPackageGrpServices";

		_methodParameterTypes0 = new String[] {
				"com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices"
			};

		_methodName1 = "createMembershipPackageGrpServices";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteMembershipPackageGrpServices";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteMembershipPackageGrpServices";

		_methodParameterTypes3 = new String[] {
				"com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices"
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

		_methodName10 = "fetchMembershipPackageGrpServices";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getMembershipPackageGrpServices";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getMembershipPackageGrpServiceses";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getMembershipPackageGrpServicesesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateMembershipPackageGrpServices";

		_methodParameterTypes15 = new String[] {
				"com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices"
			};

		_methodName126 = "getBeanIdentifier";

		_methodParameterTypes126 = new String[] {  };

		_methodName127 = "setBeanIdentifier";

		_methodParameterTypes127 = new String[] { "java.lang.String" };

		_methodName132 = "findByMembershipPackageGrpServicesScgId";

		_methodParameterTypes132 = new String[] { "java.lang.String" };

		_methodName133 = "findByMembershipPackageGrpServicesScgId";

		_methodParameterTypes133 = new String[] { "java.lang.String", "int", "int" };

		_methodName134 = "findByMembershipPackageGrpServicesScId";

		_methodParameterTypes134 = new String[] { "java.lang.String" };

		_methodName135 = "findByMembershipPackageGrpServicesScId";

		_methodParameterTypes135 = new String[] { "java.lang.String", "int", "int" };

		_methodName136 = "findByMembershipPackageGrpServicesMpId";

		_methodParameterTypes136 = new String[] { "long" };

		_methodName137 = "findByMembershipPackageGrpServicesMpId";

		_methodParameterTypes137 = new String[] { "long", "int", "int" };

		_methodName138 = "findByServiceNameMpId";

		_methodParameterTypes138 = new String[] { "long", "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return MembershipPackageGrpServicesLocalServiceUtil.addMembershipPackageGrpServices((com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return MembershipPackageGrpServicesLocalServiceUtil.createMembershipPackageGrpServices(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return MembershipPackageGrpServicesLocalServiceUtil.deleteMembershipPackageGrpServices(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return MembershipPackageGrpServicesLocalServiceUtil.deleteMembershipPackageGrpServices((com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return MembershipPackageGrpServicesLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return MembershipPackageGrpServicesLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return MembershipPackageGrpServicesLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return MembershipPackageGrpServicesLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return MembershipPackageGrpServicesLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return MembershipPackageGrpServicesLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return MembershipPackageGrpServicesLocalServiceUtil.fetchMembershipPackageGrpServices(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return MembershipPackageGrpServicesLocalServiceUtil.getMembershipPackageGrpServices(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return MembershipPackageGrpServicesLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return MembershipPackageGrpServicesLocalServiceUtil.getMembershipPackageGrpServiceses(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return MembershipPackageGrpServicesLocalServiceUtil.getMembershipPackageGrpServicesesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return MembershipPackageGrpServicesLocalServiceUtil.updateMembershipPackageGrpServices((com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices)arguments[0]);
		}

		if (_methodName126.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes126, parameterTypes)) {
			return MembershipPackageGrpServicesLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName127.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes127, parameterTypes)) {
			MembershipPackageGrpServicesLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName132.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes132, parameterTypes)) {
			return MembershipPackageGrpServicesLocalServiceUtil.findByMembershipPackageGrpServicesScgId((java.lang.String)arguments[0]);
		}

		if (_methodName133.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes133, parameterTypes)) {
			return MembershipPackageGrpServicesLocalServiceUtil.findByMembershipPackageGrpServicesScgId((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName134.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes134, parameterTypes)) {
			return MembershipPackageGrpServicesLocalServiceUtil.findByMembershipPackageGrpServicesScId((java.lang.String)arguments[0]);
		}

		if (_methodName135.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes135, parameterTypes)) {
			return MembershipPackageGrpServicesLocalServiceUtil.findByMembershipPackageGrpServicesScId((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName136.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes136, parameterTypes)) {
			return MembershipPackageGrpServicesLocalServiceUtil.findByMembershipPackageGrpServicesMpId(((Long)arguments[0]).longValue());
		}

		if (_methodName137.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes137, parameterTypes)) {
			return MembershipPackageGrpServicesLocalServiceUtil.findByMembershipPackageGrpServicesMpId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName138.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes138, parameterTypes)) {
			return MembershipPackageGrpServicesLocalServiceUtil.findByServiceNameMpId(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
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
	private String _methodName126;
	private String[] _methodParameterTypes126;
	private String _methodName127;
	private String[] _methodParameterTypes127;
	private String _methodName132;
	private String[] _methodParameterTypes132;
	private String _methodName133;
	private String[] _methodParameterTypes133;
	private String _methodName134;
	private String[] _methodParameterTypes134;
	private String _methodName135;
	private String[] _methodParameterTypes135;
	private String _methodName136;
	private String[] _methodParameterTypes136;
	private String _methodName137;
	private String[] _methodParameterTypes137;
	private String _methodName138;
	private String[] _methodParameterTypes138;
}