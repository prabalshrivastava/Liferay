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

package com.sambaash.platform.srv.spinbox.service.base;

import com.sambaash.platform.srv.spinbox.service.IBMessageDetailLocalServiceUtil;

import java.util.Arrays;

/**
 * @author nareshchebolu
 * @generated
 */
public class IBMessageDetailLocalServiceClpInvoker {
	public IBMessageDetailLocalServiceClpInvoker() {
		_methodName0 = "addIBMessageDetail";

		_methodParameterTypes0 = new String[] {
				"com.sambaash.platform.srv.spinbox.model.IBMessageDetail"
			};

		_methodName1 = "createIBMessageDetail";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteIBMessageDetail";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteIBMessageDetail";

		_methodParameterTypes3 = new String[] {
				"com.sambaash.platform.srv.spinbox.model.IBMessageDetail"
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

		_methodName10 = "fetchIBMessageDetail";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getIBMessageDetail";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getIBMessageDetails";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getIBMessageDetailsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateIBMessageDetail";

		_methodParameterTypes15 = new String[] {
				"com.sambaash.platform.srv.spinbox.model.IBMessageDetail"
			};

		_methodName40 = "getBeanIdentifier";

		_methodParameterTypes40 = new String[] {  };

		_methodName41 = "setBeanIdentifier";

		_methodParameterTypes41 = new String[] { "java.lang.String" };

		_methodName46 = "addMessageDetail";

		_methodParameterTypes46 = new String[] {
				"long", "long", "java.lang.String", "java.util.Date",
				"java.lang.String", "boolean", "java.util.Date",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "long"
			};

		_methodName47 = "findByReceiverIdmessageId";

		_methodParameterTypes47 = new String[] { "long", "long" };

		_methodName48 = "findByReceId";

		_methodParameterTypes48 = new String[] { "long", "boolean" };

		_methodName49 = "findByReceId";

		_methodParameterTypes49 = new String[] { "long", "boolean", "int", "int" };

		_methodName50 = "findByReceId";

		_methodParameterTypes50 = new String[] {
				"long", "boolean", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName51 = "findByReceIdAndRms";

		_methodParameterTypes51 = new String[] {
				"long", "boolean", "java.lang.String"
			};

		_methodName52 = "findByReceIdAndRms";

		_methodParameterTypes52 = new String[] {
				"long", "boolean", "java.lang.String", "int", "int"
			};

		_methodName53 = "findByReceIdAndRms";

		_methodParameterTypes53 = new String[] {
				"long", "boolean", "java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName54 = "findByReceIdAndSms";

		_methodParameterTypes54 = new String[] {
				"long", "boolean", "java.lang.String"
			};

		_methodName55 = "findByReceIdAndSms";

		_methodParameterTypes55 = new String[] {
				"long", "boolean", "java.lang.String", "int", "int"
			};

		_methodName56 = "findByReceIdAndSms";

		_methodParameterTypes56 = new String[] {
				"long", "boolean", "java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName57 = "findByReceIdRmsAndSms";

		_methodParameterTypes57 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String"
			};

		_methodName58 = "findByReceIdRmsAndSms";

		_methodParameterTypes58 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String", "int",
				"int"
			};

		_methodName59 = "findByReceIdRmsAndSms";

		_methodParameterTypes59 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String", "int",
				"int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName60 = "findByReceIdAndCty";

		_methodParameterTypes60 = new String[] {
				"long", "boolean", "java.lang.String"
			};

		_methodName61 = "findByReceIdAndCty";

		_methodParameterTypes61 = new String[] {
				"long", "boolean", "java.lang.String", "int", "int"
			};

		_methodName62 = "findByReceIdAndCty";

		_methodParameterTypes62 = new String[] {
				"long", "boolean", "java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName63 = "findByReceIdCtyAndRms";

		_methodParameterTypes63 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String"
			};

		_methodName64 = "findByReceIdCtyAndRms";

		_methodParameterTypes64 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String", "int",
				"int"
			};

		_methodName65 = "findByReceIdCtyAndRms";

		_methodParameterTypes65 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String", "int",
				"int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName66 = "findByReceIdCtyAndSms";

		_methodParameterTypes66 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String"
			};

		_methodName67 = "findByReceIdCtyAndSms";

		_methodParameterTypes67 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String", "int",
				"int"
			};

		_methodName68 = "findByReceIdCtyAndSms";

		_methodParameterTypes68 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String", "int",
				"int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName69 = "findByReceIdCtyRmsAndSms";

		_methodParameterTypes69 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName70 = "findByReceIdCtyRmsAndSms";

		_methodParameterTypes70 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int"
			};

		_methodName71 = "findByReceIdCtyRmsAndSms";

		_methodParameterTypes71 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName72 = "findByCorpId";

		_methodParameterTypes72 = new String[] { "long", "boolean" };

		_methodName73 = "findByCorpId";

		_methodParameterTypes73 = new String[] { "long", "boolean", "int", "int" };

		_methodName74 = "findByCorpId";

		_methodParameterTypes74 = new String[] {
				"long", "boolean", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName75 = "findByCorpIdAndRms";

		_methodParameterTypes75 = new String[] {
				"long", "boolean", "java.lang.String"
			};

		_methodName76 = "findByCorpIdAndRms";

		_methodParameterTypes76 = new String[] {
				"long", "boolean", "java.lang.String", "int", "int"
			};

		_methodName77 = "findByCorpIdAndRms";

		_methodParameterTypes77 = new String[] {
				"long", "boolean", "java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName78 = "findByCorpIdAndSms";

		_methodParameterTypes78 = new String[] {
				"long", "boolean", "java.lang.String"
			};

		_methodName79 = "findByCorpIdAndSms";

		_methodParameterTypes79 = new String[] {
				"long", "boolean", "java.lang.String", "int", "int"
			};

		_methodName80 = "findByCorpIdAndSms";

		_methodParameterTypes80 = new String[] {
				"long", "boolean", "java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName81 = "findByCorpIdRmsAndSms";

		_methodParameterTypes81 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String"
			};

		_methodName82 = "findByCorpIdRmsAndSms";

		_methodParameterTypes82 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String", "int",
				"int"
			};

		_methodName83 = "findByCorpIdRmsAndSms";

		_methodParameterTypes83 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String", "int",
				"int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName84 = "findByCorpIdAndCty";

		_methodParameterTypes84 = new String[] {
				"long", "boolean", "java.lang.String"
			};

		_methodName85 = "findByCorpIdAndCty";

		_methodParameterTypes85 = new String[] {
				"long", "boolean", "java.lang.String", "int", "int"
			};

		_methodName86 = "findByCorpIdAndCty";

		_methodParameterTypes86 = new String[] {
				"long", "boolean", "java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName87 = "findByCorpIdCtyAndRms";

		_methodParameterTypes87 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String"
			};

		_methodName88 = "findByCorpIdCtyAndRms";

		_methodParameterTypes88 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String", "int",
				"int"
			};

		_methodName89 = "findByCorpIdCtyAndRms";

		_methodParameterTypes89 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String", "int",
				"int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName90 = "findByCorpIdCtyAndSms";

		_methodParameterTypes90 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String"
			};

		_methodName91 = "findByCorpIdCtyAndSms";

		_methodParameterTypes91 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String", "int",
				"int"
			};

		_methodName92 = "findByCorpIdCtyAndSms";

		_methodParameterTypes92 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String", "int",
				"int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName93 = "findByCorpIdCtyRmsAndSms";

		_methodParameterTypes93 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName94 = "findByCorpIdCtyRmsAndSms";

		_methodParameterTypes94 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int"
			};

		_methodName95 = "findByCorpIdCtyRmsAndSms";

		_methodParameterTypes95 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName96 = "getAvailableMDListByReceiveId";

		_methodParameterTypes96 = new String[] {
				"com.liferay.portal.model.User", "long", "boolean",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int", "java.lang.String", "long"
			};

		_methodName97 = "getAvailableMDListByReceiveId";

		_methodParameterTypes97 = new String[] {
				"com.liferay.portal.model.User", "long", "boolean",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int", "com.liferay.portal.kernel.util.OrderByComparator",
				"long"
			};

		_methodName98 = "getAvailableMDListByCorpProfileId";

		_methodParameterTypes98 = new String[] {
				"com.liferay.portal.model.User", "long", "boolean",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int", "com.liferay.portal.kernel.util.OrderByComparator",
				"long"
			};

		_methodName99 = "findByMessageId";

		_methodParameterTypes99 = new String[] { "long" };

		_methodName100 = "findByMessageId";

		_methodParameterTypes100 = new String[] { "long", "int", "int" };

		_methodName101 = "findByMessageId";

		_methodParameterTypes101 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.addIBMessageDetail((com.sambaash.platform.srv.spinbox.model.IBMessageDetail)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.createIBMessageDetail(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.deleteIBMessageDetail(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.deleteIBMessageDetail((com.sambaash.platform.srv.spinbox.model.IBMessageDetail)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.fetchIBMessageDetail(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.getIBMessageDetail(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.getIBMessageDetails(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.getIBMessageDetailsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.updateIBMessageDetail((com.sambaash.platform.srv.spinbox.model.IBMessageDetail)arguments[0]);
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName41.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
			IBMessageDetailLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.addMessageDetail(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				(java.lang.String)arguments[4],
				((Boolean)arguments[5]).booleanValue(),
				(java.util.Date)arguments[6], (java.lang.String)arguments[7],
				(java.lang.String)arguments[8], (java.lang.String)arguments[9],
				(java.lang.String)arguments[10],
				((Long)arguments[11]).longValue(),
				((Long)arguments[12]).longValue());
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceiverIdmessageId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[4]);
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceIdAndRms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceIdAndRms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceIdAndRms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[5]);
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceIdAndSms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceIdAndSms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceIdAndSms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[5]);
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceIdRmsAndSms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceIdRmsAndSms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceIdRmsAndSms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[6]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceIdAndCty(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceIdAndCty(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceIdAndCty(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[5]);
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceIdCtyAndRms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceIdCtyAndRms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceIdCtyAndRms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[6]);
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceIdCtyAndSms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceIdCtyAndSms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceIdCtyAndSms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[6]);
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceIdCtyRmsAndSms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4]);
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceIdCtyRmsAndSms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4],
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue());
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByReceIdCtyRmsAndSms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4],
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[7]);
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByCorpId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByCorpId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByCorpId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[4]);
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByCorpIdAndRms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByCorpIdAndRms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByCorpIdAndRms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[5]);
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByCorpIdAndSms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByCorpIdAndSms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByCorpIdAndSms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[5]);
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByCorpIdRmsAndSms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByCorpIdRmsAndSms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByCorpIdRmsAndSms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[6]);
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByCorpIdAndCty(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByCorpIdAndCty(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByCorpIdAndCty(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[5]);
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByCorpIdCtyAndRms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByCorpIdCtyAndRms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByCorpIdCtyAndRms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[6]);
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByCorpIdCtyAndSms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByCorpIdCtyAndSms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByCorpIdCtyAndSms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[6]);
		}

		if (_methodName93.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByCorpIdCtyRmsAndSms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4]);
		}

		if (_methodName94.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByCorpIdCtyRmsAndSms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4],
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue());
		}

		if (_methodName95.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByCorpIdCtyRmsAndSms(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4],
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[7]);
		}

		if (_methodName96.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes96, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.getAvailableMDListByReceiveId((com.liferay.portal.model.User)arguments[0],
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5],
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue(),
				(java.lang.String)arguments[8], ((Long)arguments[9]).longValue());
		}

		if (_methodName97.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes97, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.getAvailableMDListByReceiveId((com.liferay.portal.model.User)arguments[0],
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5],
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[8],
				((Long)arguments[9]).longValue());
		}

		if (_methodName98.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.getAvailableMDListByCorpProfileId((com.liferay.portal.model.User)arguments[0],
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5],
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[8],
				((Long)arguments[9]).longValue());
		}

		if (_methodName99.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes99, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByMessageId(((Long)arguments[0]).longValue());
		}

		if (_methodName100.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes100, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByMessageId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName101.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes101, parameterTypes)) {
			return IBMessageDetailLocalServiceUtil.findByMessageId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
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
	private String _methodName87;
	private String[] _methodParameterTypes87;
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
}