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

package com.sambaash.platform.srv.processbuilder.service;

import com.liferay.portal.service.InvokableLocalService;

/**
 * @author nareshchebolu
 * @generated
 */
public class PEEngineLocalServiceClp implements PEEngineLocalService {
	public PEEngineLocalServiceClp(InvokableLocalService invokableLocalService) {
		_invokableLocalService = invokableLocalService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "getStatusString";

		_methodParameterTypes3 = new String[] { "long", "long", "long", "long" };

		_methodName4 = "getStatusString";

		_methodParameterTypes4 = new String[] { "long" };

		_methodName5 = "runProcessEngineUsingEsignPackagId";

		_methodParameterTypes5 = new String[] { "java.lang.String" };

		_methodName6 = "runProcessEngineUsingFormId";

		_methodParameterTypes6 = new String[] {
				"long", "long", "long", "long", "java.lang.String",
				"java.util.Map"
			};

		_methodName7 = "runProcessEngineUsingFormIdWithException";

		_methodParameterTypes7 = new String[] {
				"javax.portlet.PortletRequest", "long", "long", "long", "long",
				"java.lang.String", "java.util.Map"
			};

		_methodName8 = "runProcessEngineProductApp";

		_methodParameterTypes8 = new String[] {
				"long", "long", "long", "long", "java.lang.String",
				"java.lang.String"
			};

		_methodName9 = "submitApplciaiton";

		_methodParameterTypes9 = new String[] {
				"com.sambaash.platform.pe.PESubmitAppRequest"
			};

		_methodName10 = "submitApplicationV2";

		_methodParameterTypes10 = new String[] {
				"com.sambaash.platform.pe.v2.PESubmitAppRequestV2"
			};

		_methodName11 = "getFirstFormIdToLoad";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "isAgent";

		_methodParameterTypes12 = new String[] {
				"com.liferay.portal.model.User", "long"
			};

		_methodName13 = "isSupervisor";

		_methodParameterTypes13 = new String[] {
				"com.liferay.portal.model.User", "long"
			};

		_methodName14 = "addExtraParamsToFormUrl";

		_methodParameterTypes14 = new String[] {
				"boolean", "com.liferay.portal.model.User", "long",
				"java.lang.String"
			};

		_methodName15 = "getNonDealStageIds";

		_methodParameterTypes15 = new String[] {  };

		_methodName16 = "getDealStageIds";

		_methodParameterTypes16 = new String[] {  };

		_methodName17 = "getLeadProcessId";

		_methodParameterTypes17 = new String[] {  };

		_methodName18 = "getOpportunityProcessIds";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "toLong";

		_methodParameterTypes19 = new String[] { "java.lang.String[][]" };

		_methodName20 = "isOpenApplication";

		_methodParameterTypes20 = new String[] {
				"com.sambaash.platform.srv.processbuilder.model.PEProcessState"
			};

		_methodName21 = "isRejectedApplicaiton";

		_methodParameterTypes21 = new String[] {
				"com.sambaash.platform.srv.processbuilder.model.PEProcessState"
			};

		_methodName22 = "isActiveApplicaiton";

		_methodParameterTypes22 = new String[] {
				"com.sambaash.platform.srv.processbuilder.model.PEProcessState"
			};

		_methodName23 = "isConvertedToOtherApplication";

		_methodParameterTypes23 = new String[] {
				"com.sambaash.platform.srv.processbuilder.model.PEProcessState"
			};

		_methodName24 = "getApplicationDisplayUrl";

		_methodParameterTypes24 = new String[] {
				"com.liferay.portal.model.User", "long",
				"com.liferay.portal.theme.ThemeDisplay"
			};

		_methodName25 = "getApplicationDisplayFriendlyUrl";

		_methodParameterTypes25 = new String[] {
				"com.liferay.portal.model.User", "long",
				"com.liferay.portal.theme.ThemeDisplay"
			};

		_methodName26 = "getPeEntity";

		_methodParameterTypes26 = new String[] { "long", "long" };
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName0,
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
			_invokableLocalService.invokeMethod(_methodName1,
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
	public java.lang.String getStatusString(long userIdProcess, long processId,
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] { userIdProcess, processId, classNameId, classPK });
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
	public java.lang.String getStatusString(long processStateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName4,
					_methodParameterTypes4, new Object[] { processStateId });
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
	public void runProcessEngineUsingEsignPackagId(java.lang.String packageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName5,
				_methodParameterTypes5,
				new Object[] { ClpSerializer.translateInput(packageId) });
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
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState runProcessEngineUsingFormId(
		long entityClassId, long classPK, long processId, long formId,
		java.lang.String formData,
		java.util.Map<java.lang.String, java.lang.String[]> params) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] {
						entityClassId,
						
					classPK,
						
					processId,
						
					formId,
						
					ClpSerializer.translateInput(formData),
						
					ClpSerializer.translateInput(params)
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

		return (com.sambaash.platform.srv.processbuilder.model.PEProcessState)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState runProcessEngineUsingFormIdWithException(
		javax.portlet.PortletRequest portletRequest, long entityClassId,
		long classPK, long processId, long formId, java.lang.String formData,
		java.util.Map<java.lang.String, java.lang.String[]> params)
		throws java.lang.Exception {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] {
						ClpSerializer.translateInput(portletRequest),
						
					entityClassId,
						
					classPK,
						
					processId,
						
					formId,
						
					ClpSerializer.translateInput(formData),
						
					ClpSerializer.translateInput(params)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.sambaash.platform.srv.processbuilder.model.PEProcessState)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void runProcessEngineProductApp(long entityClassId, long classPK,
		long processId, long formId, java.lang.String countryName,
		java.lang.String formData) {
		try {
			_invokableLocalService.invokeMethod(_methodName8,
				_methodParameterTypes8,
				new Object[] {
					entityClassId,
					
				classPK,
					
				processId,
					
				formId,
					
				ClpSerializer.translateInput(countryName),
					
				ClpSerializer.translateInput(formData)
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
	public com.sambaash.platform.pe.PESubmitAppResponse submitApplciaiton(
		com.sambaash.platform.pe.PESubmitAppRequest submitAppRequest) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] { ClpSerializer.translateInput(
							submitAppRequest) });
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

		return (com.sambaash.platform.pe.PESubmitAppResponse)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.pe.v2.PESubmitAppResponseV2 submitApplicationV2(
		com.sambaash.platform.pe.v2.PESubmitAppRequestV2 request) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName10,
					_methodParameterTypes10,
					new Object[] { ClpSerializer.translateInput(request) });
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

		return (com.sambaash.platform.pe.v2.PESubmitAppResponseV2)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public long getFirstFormIdToLoad(long processId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName11,
					_methodParameterTypes11, new Object[] { processId });
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

		return ((Long)returnObj).longValue();
	}

	@Override
	public boolean isAgent(com.liferay.portal.model.User user, long processId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName12,
					_methodParameterTypes12,
					new Object[] { ClpSerializer.translateInput(user), processId });
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
	public boolean isSupervisor(com.liferay.portal.model.User user,
		long processId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName13,
					_methodParameterTypes13,
					new Object[] { ClpSerializer.translateInput(user), processId });
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
	public java.lang.String addExtraParamsToFormUrl(boolean isSignedIn,
		com.liferay.portal.model.User user, long processId,
		java.lang.String urlLoadForm) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName14,
					_methodParameterTypes14,
					new Object[] {
						isSignedIn,
						
					ClpSerializer.translateInput(user),
						
					processId,
						
					ClpSerializer.translateInput(urlLoadForm)
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
	public long[] getNonDealStageIds() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName15,
					_methodParameterTypes15, new Object[] {  });
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

		return (long[])ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public long[] getDealStageIds() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName16,
					_methodParameterTypes16, new Object[] {  });
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

		return (long[])ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public long getLeadProcessId() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName17,
					_methodParameterTypes17, new Object[] {  });
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

		return ((Long)returnObj).longValue();
	}

	@Override
	public long[] getOpportunityProcessIds() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName18,
					_methodParameterTypes18, new Object[] {  });
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

		return (long[])ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public long[] toLong(java.lang.String[] strArr) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName19,
					_methodParameterTypes19,
					new Object[] { ClpSerializer.translateInput(strArr) });
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

		return (long[])ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public boolean isOpenApplication(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState processState) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName20,
					_methodParameterTypes20,
					new Object[] { ClpSerializer.translateInput(processState) });
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
	public boolean isRejectedApplicaiton(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState processState) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName21,
					_methodParameterTypes21,
					new Object[] { ClpSerializer.translateInput(processState) });
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
	public boolean isActiveApplicaiton(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState processState) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName22,
					_methodParameterTypes22,
					new Object[] { ClpSerializer.translateInput(processState) });
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
	public boolean isConvertedToOtherApplication(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState processState) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName23,
					_methodParameterTypes23,
					new Object[] { ClpSerializer.translateInput(processState) });
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
	public java.lang.String getApplicationDisplayUrl(
		com.liferay.portal.model.User loggedInUser, long processStateId,
		com.liferay.portal.theme.ThemeDisplay themedisplay) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName24,
					_methodParameterTypes24,
					new Object[] {
						ClpSerializer.translateInput(loggedInUser),
						
					processStateId,
						
					ClpSerializer.translateInput(themedisplay)
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
	public java.lang.String getApplicationDisplayFriendlyUrl(
		com.liferay.portal.model.User loggedInUser, long processStateId,
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName25,
					_methodParameterTypes25,
					new Object[] {
						ClpSerializer.translateInput(loggedInUser),
						
					processStateId,
						
					ClpSerializer.translateInput(themeDisplay)
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
	public com.sambaash.platform.pe.PEEntity getPeEntity(long classNameId,
		long classPk) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName26,
					_methodParameterTypes26,
					new Object[] { classNameId, classPk });
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

		return (com.sambaash.platform.pe.PEEntity)ClpSerializer.translateOutput(returnObj);
	}

	private InvokableLocalService _invokableLocalService;
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
}