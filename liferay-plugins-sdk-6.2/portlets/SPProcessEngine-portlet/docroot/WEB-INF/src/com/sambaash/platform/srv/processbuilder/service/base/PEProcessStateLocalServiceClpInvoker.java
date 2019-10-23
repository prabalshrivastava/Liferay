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

package com.sambaash.platform.srv.processbuilder.service.base;

import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;

import java.util.Arrays;

/**
 * @author nareshchebolu
 * @generated
 */
public class PEProcessStateLocalServiceClpInvoker {
	public PEProcessStateLocalServiceClpInvoker() {
		_methodName0 = "addPEProcessState";

		_methodParameterTypes0 = new String[] {
				"com.sambaash.platform.srv.processbuilder.model.PEProcessState"
			};

		_methodName1 = "createPEProcessState";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deletePEProcessState";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deletePEProcessState";

		_methodParameterTypes3 = new String[] {
				"com.sambaash.platform.srv.processbuilder.model.PEProcessState"
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

		_methodName10 = "fetchPEProcessState";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchPEProcessStateByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchPEProcessStateByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getPEProcessState";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getPEProcessStateByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getPEProcessStateByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getPEProcessStates";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getPEProcessStatesCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updatePEProcessState";

		_methodParameterTypes19 = new String[] {
				"com.sambaash.platform.srv.processbuilder.model.PEProcessState"
			};

		_methodName82 = "getBeanIdentifier";

		_methodParameterTypes82 = new String[] {  };

		_methodName83 = "setBeanIdentifier";

		_methodParameterTypes83 = new String[] { "java.lang.String" };

		_methodName88 = "createWithPrimaryKeyZero";

		_methodParameterTypes88 = new String[] {  };

		_methodName89 = "create";

		_methodParameterTypes89 = new String[] {  };

		_methodName90 = "getNewPrimaryKey";

		_methodParameterTypes90 = new String[] {  };

		_methodName91 = "getOfflineFinancereport";

		_methodParameterTypes91 = new String[] {
				"java.util.Date", "java.util.Date", "java.util.Date",
				"java.util.Date", "java.util.Date", "java.util.Date"
			};

		_methodName92 = "getOnlineFinancereport";

		_methodParameterTypes92 = new String[] {
				"java.util.Date", "java.util.Date", "java.util.Date",
				"java.util.Date", "java.util.Date", "java.util.Date"
			};

		_methodName93 = "findByPEProcessStatePK";

		_methodParameterTypes93 = new String[] { "long", "long", "long" };

		_methodName94 = "findByUserIdProcessAndPEProcessId";

		_methodParameterTypes94 = new String[] { "long", "long" };

		_methodName95 = "findByProcessId";

		_methodParameterTypes95 = new String[] { "long" };

		_methodName96 = "findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus";

		_methodParameterTypes96 = new String[] {
				"long", "long", "long", "long", "int"
			};

		_methodName97 = "clearCacheAndGetProcessState";

		_methodParameterTypes97 = new String[] {
				"com.sambaash.platform.srv.processbuilder.model.PEProcessState"
			};

		_methodName98 = "getDistinctEntityIdClasseIdProcessIdList";

		_methodParameterTypes98 = new String[] {  };

		_methodName99 = "findByProcessStateLead";

		_methodParameterTypes99 = new String[] { "long[][]", "long" };

		_methodName100 = "findByProcessStateOpportunity";

		_methodParameterTypes100 = new String[] { "long[][]", "long" };

		_methodName101 = "findByuserIdProcess";

		_methodParameterTypes101 = new String[] { "long" };

		_methodName102 = "findByuserIdProcessPEProcessStageId";

		_methodParameterTypes102 = new String[] { "long", "long" };

		_methodName103 = "findByuserIdProcessPEProcessStageIdCount";

		_methodParameterTypes103 = new String[] { "long", "long" };

		_methodName104 = "updatePEProcessState";

		_methodParameterTypes104 = new String[] {
				"com.sambaash.platform.srv.processbuilder.model.PEProcessState"
			};

		_methodName105 = "getOfflineFinancereport";

		_methodParameterTypes105 = new String[] {  };

		_methodName106 = "getOnlineFinancereport";

		_methodParameterTypes106 = new String[] {  };

		_methodName107 = "getOfflineFinancereport";

		_methodParameterTypes107 = new String[] {
				"java.util.Date", "java.util.Date"
			};

		_methodName108 = "getOnlineFinancereport";

		_methodParameterTypes108 = new String[] {
				"java.util.Date", "java.util.Date"
			};

		_methodName109 = "checkForPreviousSubmissions";

		_methodParameterTypes109 = new String[] {
				"long", "java.lang.String", "long", "long", "long"
			};

		_methodName110 = "findByuserIdProcessAndPEProcessIdAndEntityClassIdAndEntityIdAndActiveStatus";

		_methodParameterTypes110 = new String[] {
				"long", "long", "long", "long", "int"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.addPEProcessState((com.sambaash.platform.srv.processbuilder.model.PEProcessState)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.createPEProcessState(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.deletePEProcessState(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.deletePEProcessState((com.sambaash.platform.srv.processbuilder.model.PEProcessState)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.fetchPEProcessState(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.fetchPEProcessStateByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.fetchPEProcessStateByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.getPEProcessState(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.getPEProcessStateByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.getPEProcessStateByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.getPEProcessStates(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.getPEProcessStatesCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.updatePEProcessState((com.sambaash.platform.srv.processbuilder.model.PEProcessState)arguments[0]);
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			PEProcessStateLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.createWithPrimaryKeyZero();
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.create();
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.getNewPrimaryKey();
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.getOfflineFinancereport((java.util.Date)arguments[0],
				(java.util.Date)arguments[1], (java.util.Date)arguments[2],
				(java.util.Date)arguments[3], (java.util.Date)arguments[4],
				(java.util.Date)arguments[5]);
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.getOnlineFinancereport((java.util.Date)arguments[0],
				(java.util.Date)arguments[1], (java.util.Date)arguments[2],
				(java.util.Date)arguments[3], (java.util.Date)arguments[4],
				(java.util.Date)arguments[5]);
		}

		if (_methodName93.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.findByPEProcessStatePK(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName94.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.findByUserIdProcessAndPEProcessId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName95.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.findByProcessId(((Long)arguments[0]).longValue());
		}

		if (_methodName96.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes96, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName97.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes97, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.clearCacheAndGetProcessState((com.sambaash.platform.srv.processbuilder.model.PEProcessState)arguments[0]);
		}

		if (_methodName98.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.getDistinctEntityIdClasseIdProcessIdList();
		}

		if (_methodName99.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes99, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.findByProcessStateLead((long[])arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName100.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes100, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.findByProcessStateOpportunity((long[])arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName101.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes101, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.findByuserIdProcess(((Long)arguments[0]).longValue());
		}

		if (_methodName102.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes102, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.findByuserIdProcessPEProcessStageId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName103.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes103, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.findByuserIdProcessPEProcessStageIdCount(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName104.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes104, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.updatePEProcessState((com.sambaash.platform.srv.processbuilder.model.PEProcessState)arguments[0]);
		}

		if (_methodName105.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes105, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.getOfflineFinancereport();
		}

		if (_methodName106.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes106, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.getOnlineFinancereport();
		}

		if (_methodName107.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes107, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.getOfflineFinancereport((java.util.Date)arguments[0],
				(java.util.Date)arguments[1]);
		}

		if (_methodName108.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes108, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.getOnlineFinancereport((java.util.Date)arguments[0],
				(java.util.Date)arguments[1]);
		}

		if (_methodName109.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes109, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.checkForPreviousSubmissions(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue());
		}

		if (_methodName110.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
			return PEProcessStateLocalServiceUtil.findByuserIdProcessAndPEProcessIdAndEntityClassIdAndEntityIdAndActiveStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue());
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
	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName83;
	private String[] _methodParameterTypes83;
	private String _methodName88;
	private String[] _methodParameterTypes88;
	private String _methodName89;
	private String[] _methodParameterTypes89;
	private String _methodName90;
	private String[] _methodParameterTypes90;
	private String _methodName91;
	private String[] _methodParameterTypes91;
	private String _methodName92;
	private String[] _methodParameterTypes92;
	private String _methodName93;
	private String[] _methodParameterTypes93;
	private String _methodName94;
	private String[] _methodParameterTypes94;
	private String _methodName95;
	private String[] _methodParameterTypes95;
	private String _methodName96;
	private String[] _methodParameterTypes96;
	private String _methodName97;
	private String[] _methodParameterTypes97;
	private String _methodName98;
	private String[] _methodParameterTypes98;
	private String _methodName99;
	private String[] _methodParameterTypes99;
	private String _methodName100;
	private String[] _methodParameterTypes100;
	private String _methodName101;
	private String[] _methodParameterTypes101;
	private String _methodName102;
	private String[] _methodParameterTypes102;
	private String _methodName103;
	private String[] _methodParameterTypes103;
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
}