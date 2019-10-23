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

package com.sambaash.platform.srv.spasset.service.base;

import com.sambaash.platform.srv.spasset.service.SPAssetEntryLocalServiceUtil;

import java.util.Arrays;

/**
 * @author harini
 * @generated
 */
public class SPAssetEntryLocalServiceClpInvoker {
	public SPAssetEntryLocalServiceClpInvoker() {
		_methodName0 = "addSPAssetEntry";

		_methodParameterTypes0 = new String[] {
				"com.sambaash.platform.srv.spasset.model.SPAssetEntry"
			};

		_methodName1 = "createSPAssetEntry";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteSPAssetEntry";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteSPAssetEntry";

		_methodParameterTypes3 = new String[] {
				"com.sambaash.platform.srv.spasset.model.SPAssetEntry"
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

		_methodName10 = "fetchSPAssetEntry";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getSPAssetEntry";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getSPAssetEntries";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getSPAssetEntriesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateSPAssetEntry";

		_methodParameterTypes15 = new String[] {
				"com.sambaash.platform.srv.spasset.model.SPAssetEntry"
			};

		_methodName78 = "getBeanIdentifier";

		_methodParameterTypes78 = new String[] {  };

		_methodName79 = "setBeanIdentifier";

		_methodParameterTypes79 = new String[] { "java.lang.String" };

		_methodName84 = "addSPAssetEntry";

		_methodParameterTypes84 = new String[] {
				"long", "long", "long", "long", "java.lang.String", "long",
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "boolean",
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName85 = "updateSpAssetEntry";

		_methodParameterTypes85 = new String[] {
				"long", "long", "long", "long", "long", "java.lang.String",
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "boolean",
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName86 = "findBySpAssetEntries";

		_methodParameterTypes86 = new String[] { "long", "long" };

		_methodName87 = "findBySpAssetEntries";

		_methodParameterTypes87 = new String[] { "long", "long", "int", "int" };

		_methodName88 = "findBySpAssetEntriesStatus";

		_methodParameterTypes88 = new String[] { "long", "long", "boolean" };

		_methodName89 = "countBySpAssetEntries";

		_methodParameterTypes89 = new String[] { "long", "long" };

		_methodName90 = "fetchSPAssetEntryDBColNames";

		_methodParameterTypes90 = new String[] {  };

		_methodName91 = "fetchSPAssetEntriesByDLFolderId";

		_methodParameterTypes91 = new String[] { "long" };

		_methodName92 = "findBySpAssetTypeIdStatus";

		_methodParameterTypes92 = new String[] { "long", "long", "boolean" };

		_methodName93 = "findBySpAssetTypeIdStatus";

		_methodParameterTypes93 = new String[] {
				"long", "long", "int", "int", "boolean"
			};

		_methodName94 = "findBySpAssetTypeIdStatus";

		_methodParameterTypes94 = new String[] {
				"long", "long", "boolean", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName95 = "countBySpAssetTypeIdStatus";

		_methodParameterTypes95 = new String[] { "long", "long", "boolean" };

		_methodName96 = "findBySpAssetTypeId";

		_methodParameterTypes96 = new String[] { "long", "long" };

		_methodName97 = "findBySpAssetTypeId";

		_methodParameterTypes97 = new String[] { "long", "long", "int", "int" };

		_methodName98 = "findBySpAssetTypeId";

		_methodParameterTypes98 = new String[] {
				"long", "long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName99 = "countBySpAssetTypeId";

		_methodParameterTypes99 = new String[] { "long", "long" };

		_methodName100 = "findByUUID_G";

		_methodParameterTypes100 = new String[] { "long", "java.lang.String" };

		_methodName101 = "getSPAssetEntryByUrlTitle";

		_methodParameterTypes101 = new String[] { "java.lang.String", "long" };

		_methodName102 = "getUniqueUrlTitle";

		_methodParameterTypes102 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName103 = "addAssetEntry";

		_methodParameterTypes103 = new String[] {
				"com.sambaash.platform.srv.spasset.model.SPAssetEntry",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName104 = "updateAssetEntry";

		_methodParameterTypes104 = new String[] {
				"com.sambaash.platform.srv.spasset.model.SPAssetEntry",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName105 = "updateModelResources";

		_methodParameterTypes105 = new String[] {
				"com.sambaash.platform.srv.spasset.model.SPAssetEntry",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName106 = "addModelResource";

		_methodParameterTypes106 = new String[] {
				"com.sambaash.platform.srv.spasset.model.SPAssetEntry",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName107 = "updateSPAssetEntryStatus";

		_methodParameterTypes107 = new String[] {
				"com.sambaash.platform.srv.spasset.model.SPAssetEntry",
				"com.liferay.portal.model.User"
			};

		_methodName110 = "findSPAssetFileEntriesForGuest";

		_methodParameterTypes110 = new String[] { "long", "long", "int", "int" };

		_methodName111 = "findSPAssetFileEntries";

		_methodParameterTypes111 = new String[] {
				"long", "long", "long", "int", "int"
			};

		_methodName112 = "updateAsset";

		_methodParameterTypes112 = new String[] {
				"long", "com.sambaash.platform.srv.spasset.model.SPAssetEntry",
				"long[][]", "java.lang.String[][]"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.addSPAssetEntry((com.sambaash.platform.srv.spasset.model.SPAssetEntry)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.createSPAssetEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.deleteSPAssetEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.deleteSPAssetEntry((com.sambaash.platform.srv.spasset.model.SPAssetEntry)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.fetchSPAssetEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.getSPAssetEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.getSPAssetEntries(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.getSPAssetEntriesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.updateSPAssetEntry((com.sambaash.platform.srv.spasset.model.SPAssetEntry)arguments[0]);
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			SPAssetEntryLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.addSPAssetEntry(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4],
				((Long)arguments[5]).longValue(),
				((Long)arguments[6]).longValue(),
				(java.lang.String)arguments[7], (java.lang.String)arguments[8],
				(java.lang.String)arguments[9],
				(java.lang.String)arguments[10],
				((Boolean)arguments[11]).booleanValue(),
				(java.lang.String)arguments[12],
				(com.liferay.portal.service.ServiceContext)arguments[13]);
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.updateSpAssetEntry(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				(java.lang.String)arguments[5],
				((Long)arguments[6]).longValue(),
				((Long)arguments[7]).longValue(),
				(java.lang.String)arguments[8], (java.lang.String)arguments[9],
				(java.lang.String)arguments[10],
				(java.lang.String)arguments[11],
				((Boolean)arguments[12]).booleanValue(),
				(java.lang.String)arguments[13],
				(com.liferay.portal.service.ServiceContext)arguments[14]);
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.findBySpAssetEntries(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.findBySpAssetEntries(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.findBySpAssetEntriesStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.countBySpAssetEntries(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.fetchSPAssetEntryDBColNames();
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.fetchSPAssetEntriesByDLFolderId(((Long)arguments[0]).longValue());
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.findBySpAssetTypeIdStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName93.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.findBySpAssetTypeIdStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Boolean)arguments[4]).booleanValue());
		}

		if (_methodName94.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.findBySpAssetTypeIdStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[5]);
		}

		if (_methodName95.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.countBySpAssetTypeIdStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName96.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes96, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.findBySpAssetTypeId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName97.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes97, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.findBySpAssetTypeId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName98.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.findBySpAssetTypeId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[4]);
		}

		if (_methodName99.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes99, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.countBySpAssetTypeId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName100.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes100, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.findByUUID_G(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName101.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes101, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.getSPAssetEntryByUrlTitle((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName102.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes102, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.getUniqueUrlTitle(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName103.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes103, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.addAssetEntry((com.sambaash.platform.srv.spasset.model.SPAssetEntry)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName104.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes104, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.updateAssetEntry((com.sambaash.platform.srv.spasset.model.SPAssetEntry)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName105.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes105, parameterTypes)) {
			SPAssetEntryLocalServiceUtil.updateModelResources((com.sambaash.platform.srv.spasset.model.SPAssetEntry)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);

			return null;
		}

		if (_methodName106.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes106, parameterTypes)) {
			SPAssetEntryLocalServiceUtil.addModelResource((com.sambaash.platform.srv.spasset.model.SPAssetEntry)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);

			return null;
		}

		if (_methodName107.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes107, parameterTypes)) {
			SPAssetEntryLocalServiceUtil.updateSPAssetEntryStatus((com.sambaash.platform.srv.spasset.model.SPAssetEntry)arguments[0],
				(com.liferay.portal.model.User)arguments[1]);

			return null;
		}

		if (_methodName110.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.findSPAssetFileEntriesForGuest(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName111.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes111, parameterTypes)) {
			return SPAssetEntryLocalServiceUtil.findSPAssetFileEntries(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName112.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes112, parameterTypes)) {
			SPAssetEntryLocalServiceUtil.updateAsset(((Long)arguments[0]).longValue(),
				(com.sambaash.platform.srv.spasset.model.SPAssetEntry)arguments[1],
				(long[])arguments[2], (java.lang.String[])arguments[3]);

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
	private String _methodName78;
	private String[] _methodParameterTypes78;
	private String _methodName79;
	private String[] _methodParameterTypes79;
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
	private String _methodName110;
	private String[] _methodParameterTypes110;
	private String _methodName111;
	private String[] _methodParameterTypes111;
	private String _methodName112;
	private String[] _methodParameterTypes112;
}