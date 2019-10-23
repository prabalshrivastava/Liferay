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

package com.sambaash.platform.srv.graph.service;

import com.liferay.portal.service.InvokableService;

/**
 * @author harini
 * @generated
 */
public class SPNeoforjServiceClp implements SPNeoforjService {
	public SPNeoforjServiceClp(InvokableService invokableService) {
		_invokableService = invokableService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "follow";

		_methodParameterTypes3 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.String", "long", "java.lang.String", "long"
			};

		_methodName4 = "isFollowing";

		_methodParameterTypes4 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long", "long",
				"java.lang.String", "long"
			};

		_methodName5 = "like";

		_methodParameterTypes5 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.String", "long", "java.lang.String", "long"
			};

		_methodName6 = "isLiking";

		_methodParameterTypes6 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long", "long",
				"java.lang.String", "long"
			};

		_methodName7 = "findUsersWhoLikeCount";

		_methodParameterTypes7 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.String", "java.lang.Long"
			};

		_methodName8 = "join";

		_methodParameterTypes8 = new String[] {
				"java.lang.String", "long", "java.lang.String", "long", "int",
				"int", "java.lang.Long", "java.lang.Long", "java.lang.Long"
			};

		_methodName9 = "isJoined";

		_methodParameterTypes9 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long", "long",
				"java.lang.String", "long"
			};

		_methodName10 = "updateJoinGraph";

		_methodParameterTypes10 = new String[] {
				"com.sambaash.platform.model.spneo4j.form.JoinGraphForm"
			};
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName0,
					_methodParameterTypes0, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableService.invokeMethod(_methodName1,
				_methodParameterTypes1,
				new Object[] { ClpSerializer.translateInput(beanIdentifier) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public java.lang.String follow(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] {
						ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					ClpSerializer.translateInput(action),
						
					startUserId,
						
					ClpSerializer.translateInput(endEntityClassName),
						
					endEntityId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public boolean isFollowing(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId, long startUserId,
		java.lang.String endEntityClassName, long endEntityId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName4,
					_methodParameterTypes4,
					new Object[] {
						ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					startUserId,
						
					ClpSerializer.translateInput(endEntityClassName),
						
					endEntityId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public java.lang.String like(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] {
						ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					ClpSerializer.translateInput(action),
						
					startUserId,
						
					ClpSerializer.translateInput(endEntityClassName),
						
					endEntityId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public boolean isLiking(java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, long startUserId,
		java.lang.String endEntityClassName, long endEntityId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] {
						ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					startUserId,
						
					ClpSerializer.translateInput(endEntityClassName),
						
					endEntityId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public int findUsersWhoLikeCount(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String endEntityClassName, java.lang.Long endEntityId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] {
						ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					ClpSerializer.translateInput(endEntityClassName),
						
					ClpSerializer.translateInput(endEntityId)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.lang.String join(java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK, int type,
		int status, java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName8,
					_methodParameterTypes8,
					new Object[] {
						ClpSerializer.translateInput(action),
						
					startUserId,
						
					ClpSerializer.translateInput(endEntityClassName),
						
					endEntityClassPK,
						
					type,
						
					status,
						
					ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public boolean isJoined(java.lang.Long companyId, java.lang.Long groupId,
		java.lang.Long layoutSetId, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] {
						ClpSerializer.translateInput(companyId),
						
					ClpSerializer.translateInput(groupId),
						
					ClpSerializer.translateInput(layoutSetId),
						
					startUserId,
						
					ClpSerializer.translateInput(endEntityClassName),
						
					endEntityClassPK
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public java.lang.String updateJoinGraph(
		com.sambaash.platform.model.spneo4j.form.JoinGraphForm joinGraphForm) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName10,
					_methodParameterTypes10,
					new Object[] { ClpSerializer.translateInput(joinGraphForm) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	private InvokableService _invokableService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
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
}