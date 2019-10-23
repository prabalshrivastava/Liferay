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

package com.sambaash.platform.systemmodelsetup.service;

import com.liferay.portal.service.InvokableService;

/**
 * @author biswo
 * @generated
 */
public class SystemServiceClp implements SystemService {
	public SystemServiceClp(InvokableService invokableService) {
		_invokableService = invokableService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "getCategory";

		_methodParameterTypes3 = new String[] { "java.lang.String", "long" };

		_methodName4 = "getModelList";

		_methodParameterTypes4 = new String[] {
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String", "java.lang.String"
			};

		_methodName5 = "getModelList";

		_methodParameterTypes5 = new String[] {
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String", "java.lang.String", "int"
			};

		_methodName6 = "getModelList";

		_methodParameterTypes6 = new String[] {
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String"
			};

		_methodName7 = "getUserByEmail";

		_methodParameterTypes7 = new String[] { "long", "java.lang.String" };

		_methodName8 = "createRecord";

		_methodParameterTypes8 = new String[] {
				"java.lang.String", "long", "long", "java.lang.String"
			};

		_methodName9 = "createRecordNew";

		_methodParameterTypes9 = new String[] {
				"long", "long", "long", "java.lang.String"
			};

		_methodName10 = "updateRecordFromProcessState";

		_methodParameterTypes10 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName11 = "createRecordFromProcessState";

		_methodParameterTypes11 = new String[] { "java.lang.String" };

		_methodName12 = "getRecord";

		_methodParameterTypes12 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long"
			};

		_methodName13 = "getActiveSchedules";

		_methodParameterTypes13 = new String[] { "long", "java.lang.String" };

		_methodName14 = "getPrepareClaimSchedules";

		_methodParameterTypes14 = new String[] { "long", "java.lang.String" };

		_methodName15 = "getSchedulesForEnroledProgramme";

		_methodParameterTypes15 = new String[] { "long", "long", "long" };

		_methodName16 = "getProgrammeEnroled";

		_methodParameterTypes16 = new String[] { "long", "long", "long" };

		_methodName17 = "getCandidateCurrentAto";

		_methodParameterTypes17 = new String[] { "long", "long", "long" };

		_methodName18 = "getModules";

		_methodParameterTypes18 = new String[] { "long", "long", "long" };

		_methodName19 = "createUser";

		_methodParameterTypes19 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName20 = "getRoleDetails";

		_methodParameterTypes20 = new String[] { "long", "java.lang.String" };

		_methodName21 = "addUserRecord";

		_methodParameterTypes21 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "boolean"
			};

		_methodName22 = "addUserRecord";

		_methodParameterTypes22 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "boolean", "java.lang.String", "long"
			};

		_methodName23 = "assignRolesToUser";

		_methodParameterTypes23 = new String[] { "long", "long[][]" };

		_methodName24 = "deleteRoleFromUser";

		_methodParameterTypes24 = new String[] { "long", "long" };

		_methodName25 = "checkIfUserHasRole";

		_methodParameterTypes25 = new String[] {
				"long", "long", "java.lang.String", "boolean"
			};

		_methodName26 = "deleteUserRecord";

		_methodParameterTypes26 = new String[] { "long" };

		_methodName27 = "removeTPandSCfromATO";

		_methodParameterTypes27 = new String[] { "long" };

		_methodName28 = "checkExemptionEligibility";

		_methodParameterTypes28 = new String[] {
				"java.lang.String", "long", "long"
			};

		_methodName29 = "checkExemptionEligibility";

		_methodParameterTypes29 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName30 = "addAdmissionRecord";

		_methodParameterTypes30 = new String[] {
				"java.lang.String", "long", "long", "java.lang.String"
			};

		_methodName31 = "addExemptionRecord";

		_methodParameterTypes31 = new String[] {
				"java.lang.String", "long", "long", "java.lang.String"
			};

		_methodName32 = "createEnrolmentRecord";

		_methodParameterTypes32 = new String[] {
				"java.lang.String", "long", "long", "java.lang.String"
			};

		_methodName33 = "getEntityLink";

		_methodParameterTypes33 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.Boolean"
			};

		_methodName34 = "decode";

		_methodParameterTypes34 = new String[] { "java.lang.String" };

		_methodName35 = "createUser";

		_methodParameterTypes35 = new String[] { "java.lang.String" };

		_methodName36 = "addTimelineActivity";

		_methodParameterTypes36 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName37 = "updateUser";

		_methodParameterTypes37 = new String[] { "java.lang.String" };
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
	public com.liferay.portal.kernel.json.JSONArray getCategory(
		java.lang.String vocabularyName, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException, org.json.JSONException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] {
						ClpSerializer.translateInput(vocabularyName),
						
					groupId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.liferay.portal.kernel.json.JSONException) {
				throw (com.liferay.portal.kernel.json.JSONException)t;
			}

			if (t instanceof org.json.JSONException) {
				throw (org.json.JSONException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.json.JSONArray)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getModelList(
		java.lang.String modelName, java.lang.String fieldList, long groupId,
		java.lang.String matchJsonString, java.lang.String sortString)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException, org.json.JSONException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName4,
					_methodParameterTypes4,
					new Object[] {
						ClpSerializer.translateInput(modelName),
						
					ClpSerializer.translateInput(fieldList),
						
					groupId,
						
					ClpSerializer.translateInput(matchJsonString),
						
					ClpSerializer.translateInput(sortString)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.liferay.portal.kernel.json.JSONException) {
				throw (com.liferay.portal.kernel.json.JSONException)t;
			}

			if (t instanceof org.json.JSONException) {
				throw (org.json.JSONException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.json.JSONArray)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getModelList(
		java.lang.String modelName, java.lang.String fieldList, long groupId,
		java.lang.String matchJsonString, java.lang.String sortString,
		int pageSize)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException, org.json.JSONException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] {
						ClpSerializer.translateInput(modelName),
						
					ClpSerializer.translateInput(fieldList),
						
					groupId,
						
					ClpSerializer.translateInput(matchJsonString),
						
					ClpSerializer.translateInput(sortString),
						
					pageSize
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.liferay.portal.kernel.json.JSONException) {
				throw (com.liferay.portal.kernel.json.JSONException)t;
			}

			if (t instanceof org.json.JSONException) {
				throw (org.json.JSONException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.json.JSONArray)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getModelList(
		java.lang.String modelName, java.lang.String fieldList, long groupId,
		java.lang.String matchJsonString)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException, org.json.JSONException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] {
						ClpSerializer.translateInput(modelName),
						
					ClpSerializer.translateInput(fieldList),
						
					groupId,
						
					ClpSerializer.translateInput(matchJsonString)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.liferay.portal.kernel.json.JSONException) {
				throw (com.liferay.portal.kernel.json.JSONException)t;
			}

			if (t instanceof org.json.JSONException) {
				throw (org.json.JSONException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.json.JSONArray)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.model.User getUserByEmail(long companyId,
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] {
						companyId,
						
					ClpSerializer.translateInput(emailAddress)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.model.User)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String createRecord(java.lang.String modeldata,
		long userId, long siteId, java.lang.String model) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName8,
					_methodParameterTypes8,
					new Object[] {
						ClpSerializer.translateInput(modeldata),
						
					userId,
						
					siteId,
						
					ClpSerializer.translateInput(model)
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
	public java.lang.String createRecordNew(long processStateId, long userId,
		long siteId, java.lang.String model) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] {
						processStateId,
						
					userId,
						
					siteId,
						
					ClpSerializer.translateInput(model)
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
	public java.lang.String updateRecordFromProcessState(
		java.lang.String processStateId, java.lang.String userId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName10,
					_methodParameterTypes10,
					new Object[] {
						ClpSerializer.translateInput(processStateId),
						
					ClpSerializer.translateInput(userId)
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
	public java.lang.String createRecordFromProcessState(
		java.lang.String processStateId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName11,
					_methodParameterTypes11,
					new Object[] { ClpSerializer.translateInput(processStateId) });
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
	public java.lang.String getRecord(java.lang.String storageId,
		java.lang.String model, long userId, long siteId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName12,
					_methodParameterTypes12,
					new Object[] {
						ClpSerializer.translateInput(storageId),
						
					ClpSerializer.translateInput(model),
						
					userId,
						
					siteId
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
	public com.liferay.portal.kernel.json.JSONArray getActiveSchedules(
		long siteId, java.lang.String category) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName13,
					_methodParameterTypes13,
					new Object[] { siteId, ClpSerializer.translateInput(
							category) });
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

		return (com.liferay.portal.kernel.json.JSONArray)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getPrepareClaimSchedules(
		long siteId, java.lang.String invigilatorId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName14,
					_methodParameterTypes14,
					new Object[] {
						siteId,
						
					ClpSerializer.translateInput(invigilatorId)
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

		return (com.liferay.portal.kernel.json.JSONArray)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getSchedulesForEnroledProgramme(
		long candidateId, long userId, long siteId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName15,
					_methodParameterTypes15,
					new Object[] { candidateId, userId, siteId });
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

		return (com.liferay.portal.kernel.json.JSONArray)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getProgrammeEnroled(
		long candidateId, long userId, long siteId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName16,
					_methodParameterTypes16,
					new Object[] { candidateId, userId, siteId });
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

		return (com.liferay.portal.kernel.json.JSONObject)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getCandidateCurrentAto(long candidateId,
		long userId, long siteId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName17,
					_methodParameterTypes17,
					new Object[] { candidateId, userId, siteId });
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
	public com.liferay.portal.kernel.json.JSONArray getModules(
		long candidateId, long userId, long siteId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName18,
					_methodParameterTypes18,
					new Object[] { candidateId, userId, siteId });
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

		return (com.liferay.portal.kernel.json.JSONArray)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.model.User createUser(java.lang.String apiKey,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String emailAdddress) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName19,
					_methodParameterTypes19,
					new Object[] {
						ClpSerializer.translateInput(apiKey),
						
					ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(emailAdddress)
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

		return (com.liferay.portal.model.User)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.model.Role getRoleDetails(long companyId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName20,
					_methodParameterTypes20,
					new Object[] { companyId, ClpSerializer.translateInput(name) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.model.Role)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.model.User addUserRecord(
		java.lang.String apiKey, java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAdddress,
		boolean sendPasswordEmail) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName21,
					_methodParameterTypes21,
					new Object[] {
						ClpSerializer.translateInput(apiKey),
						
					ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(emailAdddress),
						
					sendPasswordEmail
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

		return (com.liferay.portal.model.User)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.model.User addUserRecord(
		java.lang.String apiKey, java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAdddress,
		boolean sendPasswordEmail, java.lang.String userType, long virtualHostId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName22,
					_methodParameterTypes22,
					new Object[] {
						ClpSerializer.translateInput(apiKey),
						
					ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(emailAdddress),
						
					sendPasswordEmail,
						
					ClpSerializer.translateInput(userType),
						
					virtualHostId
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

		return (com.liferay.portal.model.User)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void assignRolesToUser(long userId, long[] roleIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableService.invokeMethod(_methodName23,
				_methodParameterTypes23,
				new Object[] { userId, ClpSerializer.translateInput(roleIds) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

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
	public void deleteRoleFromUser(long roleId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableService.invokeMethod(_methodName24,
				_methodParameterTypes24, new Object[] { roleId, userId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

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
	public boolean checkIfUserHasRole(long userId, long companyId,
		java.lang.String name, boolean inherited)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName25,
					_methodParameterTypes25,
					new Object[] {
						userId,
						
					companyId,
						
					ClpSerializer.translateInput(name),
						
					inherited
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

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
	public void deleteUserRecord(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableService.invokeMethod(_methodName26,
				_methodParameterTypes26, new Object[] { userId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

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
	public void removeTPandSCfromATO(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableService.invokeMethod(_methodName27,
				_methodParameterTypes27, new Object[] { userId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

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
	public com.liferay.portal.kernel.json.JSONObject checkExemptionEligibility(
		java.lang.String candidateId, long userId, long siteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName28,
					_methodParameterTypes28,
					new Object[] {
						ClpSerializer.translateInput(candidateId),
						
					userId,
						
					siteId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.json.JSONObject)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject checkExemptionEligibility(
		long siteId, long candidateId, java.lang.String applicationTranCode)
		throws com.liferay.portal.kernel.exception.PortalException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName29,
					_methodParameterTypes29,
					new Object[] {
						siteId,
						
					candidateId,
						
					ClpSerializer.translateInput(applicationTranCode)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.json.JSONObject)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String addAdmissionRecord(java.lang.String modeldata,
		long userId, long siteId, java.lang.String model)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName30,
					_methodParameterTypes30,
					new Object[] {
						ClpSerializer.translateInput(modeldata),
						
					userId,
						
					siteId,
						
					ClpSerializer.translateInput(model)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

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
	public java.lang.String addExemptionRecord(java.lang.String modeldata,
		long userId, long siteId, java.lang.String model)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName31,
					_methodParameterTypes31,
					new Object[] {
						ClpSerializer.translateInput(modeldata),
						
					userId,
						
					siteId,
						
					ClpSerializer.translateInput(model)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

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
	public java.lang.String createEnrolmentRecord(java.lang.String modeldata,
		long userId, long siteId, java.lang.String model) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName32,
					_methodParameterTypes32,
					new Object[] {
						ClpSerializer.translateInput(modeldata),
						
					userId,
						
					siteId,
						
					ClpSerializer.translateInput(model)
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
	public com.liferay.portal.kernel.json.JSONArray getEntityLink(
		long groupId, java.lang.String queryByExampleJsonString,
		java.lang.String returnFieldList,
		java.lang.String retrieveModelDetails, java.lang.Boolean flatten)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException, org.json.JSONException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName33,
					_methodParameterTypes33,
					new Object[] {
						groupId,
						
					ClpSerializer.translateInput(queryByExampleJsonString),
						
					ClpSerializer.translateInput(returnFieldList),
						
					ClpSerializer.translateInput(retrieveModelDetails),
						
					ClpSerializer.translateInput(flatten)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.liferay.portal.kernel.json.JSONException) {
				throw (com.liferay.portal.kernel.json.JSONException)t;
			}

			if (t instanceof org.json.JSONException) {
				throw (org.json.JSONException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.json.JSONArray)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String decode(java.lang.String url) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName34,
					_methodParameterTypes34,
					new Object[] { ClpSerializer.translateInput(url) });
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
	public com.liferay.portal.kernel.json.JSONObject createUser(
		java.lang.String inputJson) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName35,
					_methodParameterTypes35,
					new Object[] { ClpSerializer.translateInput(inputJson) });
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

		return (com.liferay.portal.kernel.json.JSONObject)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void addTimelineActivity(java.lang.String actionLink,
		java.lang.String actionLabel, java.lang.String title,
		java.lang.String description, java.lang.String imagePath,
		java.lang.String status, long createdByUserId,
		java.lang.String activityType, java.lang.String category,
		java.lang.String subProductId, java.lang.String content,
		java.lang.String assignedTo, long groupId) {
		try {
			_invokableService.invokeMethod(_methodName36,
				_methodParameterTypes36,
				new Object[] {
					ClpSerializer.translateInput(actionLink),
					
				ClpSerializer.translateInput(actionLabel),
					
				ClpSerializer.translateInput(title),
					
				ClpSerializer.translateInput(description),
					
				ClpSerializer.translateInput(imagePath),
					
				ClpSerializer.translateInput(status),
					
				createdByUserId,
					
				ClpSerializer.translateInput(activityType),
					
				ClpSerializer.translateInput(category),
					
				ClpSerializer.translateInput(subProductId),
					
				ClpSerializer.translateInput(content),
					
				ClpSerializer.translateInput(assignedTo),
					
				groupId
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
	}

	@Override
	public boolean updateUser(java.lang.String emailAddress) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName37,
					_methodParameterTypes37,
					new Object[] { ClpSerializer.translateInput(emailAddress) });
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
	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName31;
	private String[] _methodParameterTypes31;
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName33;
	private String[] _methodParameterTypes33;
	private String _methodName34;
	private String[] _methodParameterTypes34;
	private String _methodName35;
	private String[] _methodParameterTypes35;
	private String _methodName36;
	private String[] _methodParameterTypes36;
	private String _methodName37;
	private String[] _methodParameterTypes37;
}