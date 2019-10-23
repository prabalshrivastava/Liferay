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

package com.sambaash.platform.srv.mail.service.base;

import com.sambaash.platform.srv.mail.service.SPMailCampaignSubscribersLocalServiceUtil;

import java.util.Arrays;

/**
 * @author gauravvijayvergia
 * @generated
 */
public class SPMailCampaignSubscribersLocalServiceClpInvoker {
	public SPMailCampaignSubscribersLocalServiceClpInvoker() {
		_methodName0 = "addSPMailCampaignSubscribers";

		_methodParameterTypes0 = new String[] {
				"com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers"
			};

		_methodName1 = "createSPMailCampaignSubscribers";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteSPMailCampaignSubscribers";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteSPMailCampaignSubscribers";

		_methodParameterTypes3 = new String[] {
				"com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers"
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

		_methodName10 = "fetchSPMailCampaignSubscribers";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getSPMailCampaignSubscribers";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getSPMailCampaignSubscriberses";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getSPMailCampaignSubscribersesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateSPMailCampaignSubscribers";

		_methodParameterTypes15 = new String[] {
				"com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers"
			};

		_methodName72 = "getBeanIdentifier";

		_methodParameterTypes72 = new String[] {  };

		_methodName73 = "setBeanIdentifier";

		_methodParameterTypes73 = new String[] { "java.lang.String" };

		_methodName78 = "addNewsLetterCampaignSubscriber";

		_methodParameterTypes78 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"boolean", "long"
			};

		_methodName79 = "clearCache";

		_methodParameterTypes79 = new String[] {  };

		_methodName80 = "countByCampaignId";

		_methodParameterTypes80 = new String[] { "long" };

		_methodName81 = "countByCampaignIdAndMailType";

		_methodParameterTypes81 = new String[] { "long", "int" };

		_methodName82 = "countByCampaignIdAndOpened";

		_methodParameterTypes82 = new String[] { "long", "boolean" };

		_methodName83 = "countByCampaignIdMailTypeAndOpened";

		_methodParameterTypes83 = new String[] { "long", "int", "boolean" };

		_methodName84 = "countByCampaignIdMailTypeAndStatus";

		_methodParameterTypes84 = new String[] { "long", "int", "int" };

		_methodName85 = "countOpenedMailByCountry";

		_methodParameterTypes85 = new String[] { "long", "int" };

		_methodName86 = "findByCampaignId";

		_methodParameterTypes86 = new String[] { "long" };

		_methodName87 = "findByCampaignId";

		_methodParameterTypes87 = new String[] { "long", "int", "int" };

		_methodName88 = "findByCampaignIdAndEmailAddress";

		_methodParameterTypes88 = new String[] { "long", "java.lang.String" };

		_methodName89 = "findByCampaignIdAndFirstName";

		_methodParameterTypes89 = new String[] { "long", "java.lang.String" };

		_methodName90 = "findByCampaignIdAndLastName";

		_methodParameterTypes90 = new String[] { "long", "java.lang.String" };

		_methodName91 = "findByCampaignIdAndMailType";

		_methodParameterTypes91 = new String[] { "long", "int" };

		_methodName92 = "findByCampaignIdAndMailType";

		_methodParameterTypes92 = new String[] { "long", "int", "int", "int" };

		_methodName93 = "findByCampaignIdAndOpened";

		_methodParameterTypes93 = new String[] { "long", "boolean" };

		_methodName94 = "findByCampaignIdAndOpened";

		_methodParameterTypes94 = new String[] { "long", "boolean", "int", "int" };

		_methodName95 = "findByCampaignIdMailTypeAndEmailAddress";

		_methodParameterTypes95 = new String[] { "long", "int", "java.lang.String" };

		_methodName96 = "findByCampaignIdMailTypeAndFirstName";

		_methodParameterTypes96 = new String[] { "long", "int", "java.lang.String" };

		_methodName97 = "findByCampaignIdMailTypeAndLastName";

		_methodParameterTypes97 = new String[] { "long", "int", "java.lang.String" };

		_methodName98 = "findByCampaignIdMailTypeAndOpened";

		_methodParameterTypes98 = new String[] { "long", "int", "boolean" };

		_methodName99 = "findByCampaignIdMailTypeAndOpened";

		_methodParameterTypes99 = new String[] {
				"long", "int", "boolean", "int", "int"
			};

		_methodName100 = "findByCampaignIdMailTypeAndStatus";

		_methodParameterTypes100 = new String[] { "long", "int", "int" };

		_methodName101 = "findByCampaignIdMailTypeOpenedAndEmailAddress";

		_methodParameterTypes101 = new String[] {
				"long", "int", "boolean", "java.lang.String"
			};

		_methodName102 = "findByCampaignIdMailTypeOpenedAndFirstName";

		_methodParameterTypes102 = new String[] {
				"long", "int", "boolean", "java.lang.String"
			};

		_methodName103 = "findByCampaignIdMailTypeOpenedAndLastName";

		_methodParameterTypes103 = new String[] {
				"long", "int", "boolean", "java.lang.String"
			};

		_methodName104 = "findByCampaignIdOpenedAndEmailAddress";

		_methodParameterTypes104 = new String[] {
				"long", "boolean", "java.lang.String"
			};

		_methodName105 = "findByCampaignIdOpenedAndFirstName";

		_methodParameterTypes105 = new String[] {
				"long", "boolean", "java.lang.String"
			};

		_methodName106 = "findByCampaignIdOpenedAndLastName";

		_methodParameterTypes106 = new String[] {
				"long", "boolean", "java.lang.String"
			};

		_methodName107 = "findByEmailAddress";

		_methodParameterTypes107 = new String[] { "java.lang.String" };

		_methodName108 = "findByEmailAddress";

		_methodParameterTypes108 = new String[] { "java.lang.String", "int", "int" };

		_methodName109 = "findByMessageId";

		_methodParameterTypes109 = new String[] { "java.lang.String" };

		_methodName110 = "findByUserId";

		_methodParameterTypes110 = new String[] { "long" };

		_methodName111 = "countByUserIdAndOpened";

		_methodParameterTypes111 = new String[] { "long", "boolean" };

		_methodName112 = "updateSubscriber";

		_methodParameterTypes112 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName114 = "create";

		_methodParameterTypes114 = new String[] {  };

		_methodName115 = "addSubscriber";

		_methodParameterTypes115 = new String[] {
				"long", "long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.addSPMailCampaignSubscribers((com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.createSPMailCampaignSubscribers(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.deleteSPMailCampaignSubscribers(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.deleteSPMailCampaignSubscribers((com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.fetchSPMailCampaignSubscribers(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.getSPMailCampaignSubscribers(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.getSPMailCampaignSubscriberses(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.getSPMailCampaignSubscribersesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.updateSPMailCampaignSubscribers((com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers)arguments[0]);
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			SPMailCampaignSubscribersLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.addNewsLetterCampaignSubscriber((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Boolean)arguments[3]).booleanValue(),
				((Long)arguments[4]).longValue());
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			SPMailCampaignSubscribersLocalServiceUtil.clearCache();

			return null;
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.countByCampaignId(((Long)arguments[0]).longValue());
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.countByCampaignIdAndMailType(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.countByCampaignIdAndOpened(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.countByCampaignIdMailTypeAndOpened(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.countByCampaignIdMailTypeAndStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.countOpenedMailByCountry(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByCampaignId(((Long)arguments[0]).longValue());
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByCampaignId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdAndEmailAddress(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdAndFirstName(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdAndLastName(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdAndMailType(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdAndMailType(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName93.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdAndOpened(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName94.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdAndOpened(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName95.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdMailTypeAndEmailAddress(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName96.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes96, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdMailTypeAndFirstName(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName97.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes97, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdMailTypeAndLastName(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName98.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdMailTypeAndOpened(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName99.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes99, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdMailTypeAndOpened(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName100.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes100, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdMailTypeAndStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName101.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes101, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdMailTypeOpenedAndEmailAddress(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue(),
				(java.lang.String)arguments[3]);
		}

		if (_methodName102.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes102, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdMailTypeOpenedAndFirstName(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue(),
				(java.lang.String)arguments[3]);
		}

		if (_methodName103.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes103, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdMailTypeOpenedAndLastName(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue(),
				(java.lang.String)arguments[3]);
		}

		if (_methodName104.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes104, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdOpenedAndEmailAddress(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName105.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes105, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdOpenedAndFirstName(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName106.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes106, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByCampaignIdOpenedAndLastName(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName107.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes107, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByEmailAddress((java.lang.String)arguments[0]);
		}

		if (_methodName108.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes108, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByEmailAddress((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName109.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes109, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByMessageId((java.lang.String)arguments[0]);
		}

		if (_methodName110.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.findByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName111.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes111, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.countByUserIdAndOpened(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName112.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes112, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.updateSubscriber(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName114.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes114, parameterTypes)) {
			return SPMailCampaignSubscribersLocalServiceUtil.create();
		}

		if (_methodName115.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes115, parameterTypes)) {
			SPMailCampaignSubscribersLocalServiceUtil.addSubscriber(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5]);

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
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
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
	private String _methodName111;
	private String[] _methodParameterTypes111;
	private String _methodName112;
	private String[] _methodParameterTypes112;
	private String _methodName114;
	private String[] _methodParameterTypes114;
	private String _methodName115;
	private String[] _methodParameterTypes115;
}