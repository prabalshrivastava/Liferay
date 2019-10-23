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

package com.sambaash.platform.srv.graph.service.base;

import com.sambaash.platform.srv.graph.service.SPNeoforjServiceUtil;

import java.util.Arrays;

/**
 * @author harini
 * @generated
 */
public class SPNeoforjServiceClpInvoker {
	public SPNeoforjServiceClpInvoker() {
		_methodName16 = "getBeanIdentifier";

		_methodParameterTypes16 = new String[] {  };

		_methodName17 = "setBeanIdentifier";

		_methodParameterTypes17 = new String[] { "java.lang.String" };

		_methodName20 = "follow";

		_methodParameterTypes20 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.String", "long", "java.lang.String", "long"
			};

		_methodName21 = "isFollowing";

		_methodParameterTypes21 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long", "long",
				"java.lang.String", "long"
			};

		_methodName22 = "like";

		_methodParameterTypes22 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.String", "long", "java.lang.String", "long"
			};

		_methodName23 = "isLiking";

		_methodParameterTypes23 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long", "long",
				"java.lang.String", "long"
			};

		_methodName24 = "findUsersWhoLikeCount";

		_methodParameterTypes24 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.String", "java.lang.Long"
			};

		_methodName25 = "join";

		_methodParameterTypes25 = new String[] {
				"java.lang.String", "long", "java.lang.String", "long", "int",
				"int", "java.lang.Long", "java.lang.Long", "java.lang.Long"
			};

		_methodName26 = "isJoined";

		_methodParameterTypes26 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long", "long",
				"java.lang.String", "long"
			};

		_methodName27 = "updateJoinGraph";

		_methodParameterTypes27 = new String[] {
				"com.sambaash.platform.model.spneo4j.form.JoinGraphForm"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return SPNeoforjServiceUtil.getBeanIdentifier();
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			SPNeoforjServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			return SPNeoforjServiceUtil.follow((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				(java.lang.String)arguments[5], ((Long)arguments[6]).longValue());
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			return SPNeoforjServiceUtil.isFollowing((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4], ((Long)arguments[5]).longValue());
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			return SPNeoforjServiceUtil.like((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				(java.lang.String)arguments[5], ((Long)arguments[6]).longValue());
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			return SPNeoforjServiceUtil.isLiking((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4], ((Long)arguments[5]).longValue());
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			return SPNeoforjServiceUtil.findUsersWhoLikeCount((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.String)arguments[3], (java.lang.Long)arguments[4]);
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			return SPNeoforjServiceUtil.join((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue(),
				(java.lang.Long)arguments[6], (java.lang.Long)arguments[7],
				(java.lang.Long)arguments[8]);
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return SPNeoforjServiceUtil.isJoined((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4], ((Long)arguments[5]).longValue());
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			return SPNeoforjServiceUtil.updateJoinGraph((com.sambaash.platform.model.spneo4j.form.JoinGraphForm)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
	private String _methodName22;
	private String[] _methodParameterTypes22;
	private String _methodName23;
	private String[] _methodParameterTypes23;
	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName26;
	private String[] _methodParameterTypes26;
	private String _methodName27;
	private String[] _methodParameterTypes27;
}