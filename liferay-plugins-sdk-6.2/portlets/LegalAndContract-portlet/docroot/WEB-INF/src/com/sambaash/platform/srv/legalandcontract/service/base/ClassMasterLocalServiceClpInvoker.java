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

package com.sambaash.platform.srv.legalandcontract.service.base;

import com.sambaash.platform.srv.legalandcontract.service.ClassMasterLocalServiceUtil;

import java.util.Arrays;

/**
 * @author nareshchebolu
 * @generated
 */
public class ClassMasterLocalServiceClpInvoker {
	public ClassMasterLocalServiceClpInvoker() {
		_methodName0 = "addClassMaster";

		_methodParameterTypes0 = new String[] {
				"com.sambaash.platform.srv.legalandcontract.model.ClassMaster"
			};

		_methodName1 = "createClassMaster";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteClassMaster";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteClassMaster";

		_methodParameterTypes3 = new String[] {
				"com.sambaash.platform.srv.legalandcontract.model.ClassMaster"
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

		_methodName10 = "fetchClassMaster";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchClassMasterByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchClassMasterByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getClassMaster";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getClassMasterByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getClassMasterByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getClassMasters";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getClassMastersCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateClassMaster";

		_methodParameterTypes19 = new String[] {
				"com.sambaash.platform.srv.legalandcontract.model.ClassMaster"
			};

		_methodName98 = "getBeanIdentifier";

		_methodParameterTypes98 = new String[] {  };

		_methodName99 = "setBeanIdentifier";

		_methodParameterTypes99 = new String[] { "java.lang.String" };

		_methodName104 = "addNewClass";

		_methodParameterTypes104 = new String[] {
				"long",
				"com.sambaash.platform.srv.legalandcontract.model.ClassMaster",
				"long[][]"
			};

		_methodName105 = "addClass";

		_methodParameterTypes105 = new String[] {
				"long",
				"com.sambaash.platform.srv.legalandcontract.model.ClassMaster",
				"long[][]"
			};

		_methodName106 = "addNewClassVersion";

		_methodParameterTypes106 = new String[] {
				"long", "long",
				"com.sambaash.platform.srv.legalandcontract.model.ClassMaster",
				"long[][]"
			};

		_methodName107 = "addNewClassVersion";

		_methodParameterTypes107 = new String[] {
				"long",
				"com.sambaash.platform.srv.legalandcontract.model.ClassMaster",
				"com.sambaash.platform.srv.legalandcontract.model.ClassMaster",
				"long[][]"
			};

		_methodName108 = "getNewClassMaster";

		_methodParameterTypes108 = new String[] {  };

		_methodName110 = "updateAsset";

		_methodParameterTypes110 = new String[] {
				"long",
				"com.sambaash.platform.srv.legalandcontract.model.ClassMaster",
				"long[][]", "java.lang.String[][]", "long[][]"
			};

		_methodName111 = "findByCodeCountry";

		_methodParameterTypes111 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName112 = "getLatestClassByCodeCountry";

		_methodParameterTypes112 = new String[] {
				"java.lang.String", "java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ClassMasterLocalServiceUtil.addClassMaster((com.sambaash.platform.srv.legalandcontract.model.ClassMaster)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ClassMasterLocalServiceUtil.createClassMaster(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ClassMasterLocalServiceUtil.deleteClassMaster(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ClassMasterLocalServiceUtil.deleteClassMaster((com.sambaash.platform.srv.legalandcontract.model.ClassMaster)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ClassMasterLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ClassMasterLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ClassMasterLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ClassMasterLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ClassMasterLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ClassMasterLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ClassMasterLocalServiceUtil.fetchClassMaster(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ClassMasterLocalServiceUtil.fetchClassMasterByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ClassMasterLocalServiceUtil.fetchClassMasterByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ClassMasterLocalServiceUtil.getClassMaster(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ClassMasterLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ClassMasterLocalServiceUtil.getClassMasterByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ClassMasterLocalServiceUtil.getClassMasterByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ClassMasterLocalServiceUtil.getClassMasters(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return ClassMasterLocalServiceUtil.getClassMastersCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return ClassMasterLocalServiceUtil.updateClassMaster((com.sambaash.platform.srv.legalandcontract.model.ClassMaster)arguments[0]);
		}

		if (_methodName98.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
			return ClassMasterLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName99.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes99, parameterTypes)) {
			ClassMasterLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName104.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes104, parameterTypes)) {
			ClassMasterLocalServiceUtil.addNewClass(((Long)arguments[0]).longValue(),
				(com.sambaash.platform.srv.legalandcontract.model.ClassMaster)arguments[1],
				(long[])arguments[2]);

			return null;
		}

		if (_methodName105.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes105, parameterTypes)) {
			ClassMasterLocalServiceUtil.addClass(((Long)arguments[0]).longValue(),
				(com.sambaash.platform.srv.legalandcontract.model.ClassMaster)arguments[1],
				(long[])arguments[2]);

			return null;
		}

		if (_methodName106.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes106, parameterTypes)) {
			ClassMasterLocalServiceUtil.addNewClassVersion(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(com.sambaash.platform.srv.legalandcontract.model.ClassMaster)arguments[2],
				(long[])arguments[3]);

			return null;
		}

		if (_methodName107.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes107, parameterTypes)) {
			ClassMasterLocalServiceUtil.addNewClassVersion(((Long)arguments[0]).longValue(),
				(com.sambaash.platform.srv.legalandcontract.model.ClassMaster)arguments[1],
				(com.sambaash.platform.srv.legalandcontract.model.ClassMaster)arguments[2],
				(long[])arguments[3]);

			return null;
		}

		if (_methodName108.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes108, parameterTypes)) {
			return ClassMasterLocalServiceUtil.getNewClassMaster();
		}

		if (_methodName110.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
			ClassMasterLocalServiceUtil.updateAsset(((Long)arguments[0]).longValue(),
				(com.sambaash.platform.srv.legalandcontract.model.ClassMaster)arguments[1],
				(long[])arguments[2], (java.lang.String[])arguments[3],
				(long[])arguments[4]);

			return null;
		}

		if (_methodName111.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes111, parameterTypes)) {
			return ClassMasterLocalServiceUtil.findByCodeCountry((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName112.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes112, parameterTypes)) {
			return ClassMasterLocalServiceUtil.getLatestClassByCodeCountry((java.lang.String)arguments[0],
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
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
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
	private String _methodName110;
	private String[] _methodParameterTypes110;
	private String _methodName111;
	private String[] _methodParameterTypes111;
	private String _methodName112;
	private String[] _methodParameterTypes112;
}