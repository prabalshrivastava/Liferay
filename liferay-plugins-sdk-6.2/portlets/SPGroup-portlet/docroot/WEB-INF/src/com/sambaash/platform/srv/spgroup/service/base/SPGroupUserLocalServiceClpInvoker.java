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

package com.sambaash.platform.srv.spgroup.service.base;

import com.sambaash.platform.srv.spgroup.service.SPGroupUserLocalServiceUtil;

import java.util.Arrays;

/**
 * @author harini
 * @generated
 */
public class SPGroupUserLocalServiceClpInvoker {
	public SPGroupUserLocalServiceClpInvoker() {
		_methodName0 = "addSPGroupUser";

		_methodParameterTypes0 = new String[] {
				"com.sambaash.platform.srv.spgroup.model.SPGroupUser"
			};

		_methodName1 = "createSPGroupUser";

		_methodParameterTypes1 = new String[] {
				"com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK"
			};

		_methodName2 = "deleteSPGroupUser";

		_methodParameterTypes2 = new String[] {
				"com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK"
			};

		_methodName3 = "deleteSPGroupUser";

		_methodParameterTypes3 = new String[] {
				"com.sambaash.platform.srv.spgroup.model.SPGroupUser"
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

		_methodName10 = "fetchSPGroupUser";

		_methodParameterTypes10 = new String[] {
				"com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK"
			};

		_methodName11 = "getSPGroupUser";

		_methodParameterTypes11 = new String[] {
				"com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK"
			};

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getSPGroupUsers";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getSPGroupUsersCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateSPGroupUser";

		_methodParameterTypes15 = new String[] {
				"com.sambaash.platform.srv.spgroup.model.SPGroupUser"
			};

		_methodName40 = "getBeanIdentifier";

		_methodParameterTypes40 = new String[] {  };

		_methodName41 = "setBeanIdentifier";

		_methodParameterTypes41 = new String[] { "java.lang.String" };

		_methodName46 = "addSPGroupUser";

		_methodParameterTypes46 = new String[] {
				"long", "long", "int", "int", "java.lang.Long", "java.lang.Long"
			};

		_methodName47 = "countBySPGroupId";

		_methodParameterTypes47 = new String[] { "long" };

		_methodName48 = "countBySPGroupIdAndRole";

		_methodParameterTypes48 = new String[] { "long", "int" };

		_methodName49 = "countBySPGroupIdAndStatus";

		_methodParameterTypes49 = new String[] { "long", "int" };

		_methodName50 = "countByUserId";

		_methodParameterTypes50 = new String[] { "long" };

		_methodName51 = "countByUserIdAndGroupIdAndStatus";

		_methodParameterTypes51 = new String[] { "long", "long", "int" };

		_methodName52 = "countByUserIdAndStatus";

		_methodParameterTypes52 = new String[] { "long", "int" };

		_methodName53 = "deleteSPGroupUser";

		_methodParameterTypes53 = new String[] { "long", "long" };

		_methodName54 = "fetchByUserIdAndGroupIdAndStatus";

		_methodParameterTypes54 = new String[] { "long", "long", "int" };

		_methodName55 = "fetchByUserIdAndGroupIdAndStatus";

		_methodParameterTypes55 = new String[] { "long", "long", "int", "boolean" };

		_methodName56 = "findBySPGroupId";

		_methodParameterTypes56 = new String[] { "long" };

		_methodName57 = "findBySPGroupId";

		_methodParameterTypes57 = new String[] { "long", "int", "int" };

		_methodName58 = "findBySPGroupId";

		_methodParameterTypes58 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName59 = "findBySPGroupId_First";

		_methodParameterTypes59 = new String[] {
				"long", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName60 = "findBySPGroupId_Last";

		_methodParameterTypes60 = new String[] {
				"long", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName61 = "findBySPGroupId_PrevAndNext";

		_methodParameterTypes61 = new String[] {
				"com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK",
				"long", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName62 = "findBySPGroupIdAndRole";

		_methodParameterTypes62 = new String[] { "long", "int" };

		_methodName63 = "findBySPGroupIdAndRole";

		_methodParameterTypes63 = new String[] { "long", "int", "int", "int" };

		_methodName64 = "findBySPGroupIdAndRole";

		_methodParameterTypes64 = new String[] {
				"long", "int", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName65 = "findBySPGroupIdAndStatus";

		_methodParameterTypes65 = new String[] { "long", "int" };

		_methodName66 = "findBySPGroupIdAndStatus";

		_methodParameterTypes66 = new String[] { "long", "int", "int", "int" };

		_methodName67 = "findBySPGroupIdAndStatus";

		_methodParameterTypes67 = new String[] {
				"long", "int", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName68 = "findBySPGroupIdAndStatus_First";

		_methodParameterTypes68 = new String[] {
				"long", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName69 = "findBySPGroupIdAndStatus_Last";

		_methodParameterTypes69 = new String[] {
				"long", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName70 = "findBySPGroupIdAndStatus_PrevAndNext";

		_methodParameterTypes70 = new String[] {
				"com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK",
				"long", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName71 = "findByUserId";

		_methodParameterTypes71 = new String[] { "long" };

		_methodName72 = "findByUserId";

		_methodParameterTypes72 = new String[] { "long", "int", "int" };

		_methodName73 = "findByUserId";

		_methodParameterTypes73 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName74 = "findByUserId_First";

		_methodParameterTypes74 = new String[] {
				"long", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName75 = "findByUserId_Last";

		_methodParameterTypes75 = new String[] {
				"long", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName76 = "findByUserId_PrevAndNext";

		_methodParameterTypes76 = new String[] {
				"com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK",
				"long", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName77 = "findByUserIdAndGroupIdAndStatus";

		_methodParameterTypes77 = new String[] { "long", "long", "int" };

		_methodName78 = "findByUserIdAndStatus";

		_methodParameterTypes78 = new String[] { "long", "int" };

		_methodName79 = "findByUserIdAndStatus";

		_methodParameterTypes79 = new String[] { "long", "int", "int", "int" };

		_methodName80 = "findByUserIdAndStatus";

		_methodParameterTypes80 = new String[] {
				"long", "int", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName81 = "findByUserIdAndStatus_First";

		_methodParameterTypes81 = new String[] {
				"long", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName82 = "findByUserIdAndStatus_Last";

		_methodParameterTypes82 = new String[] {
				"long", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName83 = "findByUserIdAndStatus_PrevAndNext";

		_methodParameterTypes83 = new String[] {
				"com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK",
				"long", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName84 = "updateSPGroupUser";

		_methodParameterTypes84 = new String[] { "long", "long", "int", "int" };

		_methodName85 = "updateSPGroupUserRole";

		_methodParameterTypes85 = new String[] { "long", "long", "int" };

		_methodName86 = "updateSPGroupUserStatus";

		_methodParameterTypes86 = new String[] { "long", "long", "int" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.addSPGroupUser((com.sambaash.platform.srv.spgroup.model.SPGroupUser)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.createSPGroupUser((com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.deleteSPGroupUser((com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.deleteSPGroupUser((com.sambaash.platform.srv.spgroup.model.SPGroupUser)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.fetchSPGroupUser((com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.getSPGroupUser((com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.getSPGroupUsers(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.getSPGroupUsersCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.updateSPGroupUser((com.sambaash.platform.srv.spgroup.model.SPGroupUser)arguments[0]);
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName41.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
			SPGroupUserLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.addSPGroupUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				(java.lang.Long)arguments[4], (java.lang.Long)arguments[5]);
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.countBySPGroupId(((Long)arguments[0]).longValue());
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.countBySPGroupIdAndRole(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.countBySPGroupIdAndStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.countByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.countByUserIdAndGroupIdAndStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.countByUserIdAndStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			SPGroupUserLocalServiceUtil.deleteSPGroupUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.fetchByUserIdAndGroupIdAndStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.fetchByUserIdAndGroupIdAndStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Boolean)arguments[3]).booleanValue());
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findBySPGroupId(((Long)arguments[0]).longValue());
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findBySPGroupId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findBySPGroupId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findBySPGroupId_First(((Long)arguments[0]).longValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[1]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findBySPGroupId_Last(((Long)arguments[0]).longValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[1]);
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findBySPGroupId_PrevAndNext((com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK)arguments[0],
				((Long)arguments[1]).longValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findBySPGroupIdAndRole(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findBySPGroupIdAndRole(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findBySPGroupIdAndRole(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[4]);
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findBySPGroupIdAndStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findBySPGroupIdAndStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findBySPGroupIdAndStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[4]);
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findBySPGroupIdAndStatus_First(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findBySPGroupIdAndStatus_Last(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findBySPGroupIdAndStatus_PrevAndNext((com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK)arguments[0],
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findByUserId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findByUserId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findByUserId_First(((Long)arguments[0]).longValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[1]);
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findByUserId_Last(((Long)arguments[0]).longValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[1]);
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findByUserId_PrevAndNext((com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK)arguments[0],
				((Long)arguments[1]).longValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findByUserIdAndGroupIdAndStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findByUserIdAndStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findByUserIdAndStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findByUserIdAndStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[4]);
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findByUserIdAndStatus_First(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findByUserIdAndStatus_Last(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.findByUserIdAndStatus_PrevAndNext((com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK)arguments[0],
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.updateSPGroupUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.updateSPGroupUserRole(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return SPGroupUserLocalServiceUtil.updateSPGroupUserStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
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
	private String _methodName40;
	private String[] _methodParameterTypes40;
	private String _methodName41;
	private String[] _methodParameterTypes41;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName60;
	private String[] _methodParameterTypes60;
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
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName69;
	private String[] _methodParameterTypes69;
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
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
	private String _methodName78;
	private String[] _methodParameterTypes78;
	private String _methodName79;
	private String[] _methodParameterTypes79;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName83;
	private String[] _methodParameterTypes83;
	private String _methodName84;
	private String[] _methodParameterTypes84;
	private String _methodName85;
	private String[] _methodParameterTypes85;
	private String _methodName86;
	private String[] _methodParameterTypes86;
}