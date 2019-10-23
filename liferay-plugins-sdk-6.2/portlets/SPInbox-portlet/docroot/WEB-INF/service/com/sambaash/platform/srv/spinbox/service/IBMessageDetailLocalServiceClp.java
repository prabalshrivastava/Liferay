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

package com.sambaash.platform.srv.spinbox.service;

import com.liferay.portal.service.InvokableLocalService;

/**
 * @author nareshchebolu
 * @generated
 */
public class IBMessageDetailLocalServiceClp
	implements IBMessageDetailLocalService {
	public IBMessageDetailLocalServiceClp(
		InvokableLocalService invokableLocalService) {
		_invokableLocalService = invokableLocalService;

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

		_methodName16 = "getBeanIdentifier";

		_methodParameterTypes16 = new String[] {  };

		_methodName17 = "setBeanIdentifier";

		_methodParameterTypes17 = new String[] { "java.lang.String" };

		_methodName19 = "addMessageDetail";

		_methodParameterTypes19 = new String[] {
				"long", "long", "java.lang.String", "java.util.Date",
				"java.lang.String", "boolean", "java.util.Date",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "long"
			};

		_methodName20 = "findByReceiverIdmessageId";

		_methodParameterTypes20 = new String[] { "long", "long" };

		_methodName21 = "findByReceId";

		_methodParameterTypes21 = new String[] { "long", "boolean" };

		_methodName22 = "findByReceId";

		_methodParameterTypes22 = new String[] { "long", "boolean", "int", "int" };

		_methodName23 = "findByReceId";

		_methodParameterTypes23 = new String[] {
				"long", "boolean", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName24 = "findByReceIdAndRms";

		_methodParameterTypes24 = new String[] {
				"long", "boolean", "java.lang.String"
			};

		_methodName25 = "findByReceIdAndRms";

		_methodParameterTypes25 = new String[] {
				"long", "boolean", "java.lang.String", "int", "int"
			};

		_methodName26 = "findByReceIdAndRms";

		_methodParameterTypes26 = new String[] {
				"long", "boolean", "java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName27 = "findByReceIdAndSms";

		_methodParameterTypes27 = new String[] {
				"long", "boolean", "java.lang.String"
			};

		_methodName28 = "findByReceIdAndSms";

		_methodParameterTypes28 = new String[] {
				"long", "boolean", "java.lang.String", "int", "int"
			};

		_methodName29 = "findByReceIdAndSms";

		_methodParameterTypes29 = new String[] {
				"long", "boolean", "java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName30 = "findByReceIdRmsAndSms";

		_methodParameterTypes30 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String"
			};

		_methodName31 = "findByReceIdRmsAndSms";

		_methodParameterTypes31 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String", "int",
				"int"
			};

		_methodName32 = "findByReceIdRmsAndSms";

		_methodParameterTypes32 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String", "int",
				"int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName33 = "findByReceIdAndCty";

		_methodParameterTypes33 = new String[] {
				"long", "boolean", "java.lang.String"
			};

		_methodName34 = "findByReceIdAndCty";

		_methodParameterTypes34 = new String[] {
				"long", "boolean", "java.lang.String", "int", "int"
			};

		_methodName35 = "findByReceIdAndCty";

		_methodParameterTypes35 = new String[] {
				"long", "boolean", "java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName36 = "findByReceIdCtyAndRms";

		_methodParameterTypes36 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String"
			};

		_methodName37 = "findByReceIdCtyAndRms";

		_methodParameterTypes37 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String", "int",
				"int"
			};

		_methodName38 = "findByReceIdCtyAndRms";

		_methodParameterTypes38 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String", "int",
				"int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName39 = "findByReceIdCtyAndSms";

		_methodParameterTypes39 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String"
			};

		_methodName40 = "findByReceIdCtyAndSms";

		_methodParameterTypes40 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String", "int",
				"int"
			};

		_methodName41 = "findByReceIdCtyAndSms";

		_methodParameterTypes41 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String", "int",
				"int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName42 = "findByReceIdCtyRmsAndSms";

		_methodParameterTypes42 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName43 = "findByReceIdCtyRmsAndSms";

		_methodParameterTypes43 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int"
			};

		_methodName44 = "findByReceIdCtyRmsAndSms";

		_methodParameterTypes44 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName45 = "findByCorpId";

		_methodParameterTypes45 = new String[] { "long", "boolean" };

		_methodName46 = "findByCorpId";

		_methodParameterTypes46 = new String[] { "long", "boolean", "int", "int" };

		_methodName47 = "findByCorpId";

		_methodParameterTypes47 = new String[] {
				"long", "boolean", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName48 = "findByCorpIdAndRms";

		_methodParameterTypes48 = new String[] {
				"long", "boolean", "java.lang.String"
			};

		_methodName49 = "findByCorpIdAndRms";

		_methodParameterTypes49 = new String[] {
				"long", "boolean", "java.lang.String", "int", "int"
			};

		_methodName50 = "findByCorpIdAndRms";

		_methodParameterTypes50 = new String[] {
				"long", "boolean", "java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName51 = "findByCorpIdAndSms";

		_methodParameterTypes51 = new String[] {
				"long", "boolean", "java.lang.String"
			};

		_methodName52 = "findByCorpIdAndSms";

		_methodParameterTypes52 = new String[] {
				"long", "boolean", "java.lang.String", "int", "int"
			};

		_methodName53 = "findByCorpIdAndSms";

		_methodParameterTypes53 = new String[] {
				"long", "boolean", "java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName54 = "findByCorpIdRmsAndSms";

		_methodParameterTypes54 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String"
			};

		_methodName55 = "findByCorpIdRmsAndSms";

		_methodParameterTypes55 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String", "int",
				"int"
			};

		_methodName56 = "findByCorpIdRmsAndSms";

		_methodParameterTypes56 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String", "int",
				"int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName57 = "findByCorpIdAndCty";

		_methodParameterTypes57 = new String[] {
				"long", "boolean", "java.lang.String"
			};

		_methodName58 = "findByCorpIdAndCty";

		_methodParameterTypes58 = new String[] {
				"long", "boolean", "java.lang.String", "int", "int"
			};

		_methodName59 = "findByCorpIdAndCty";

		_methodParameterTypes59 = new String[] {
				"long", "boolean", "java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName60 = "findByCorpIdCtyAndRms";

		_methodParameterTypes60 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String"
			};

		_methodName61 = "findByCorpIdCtyAndRms";

		_methodParameterTypes61 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String", "int",
				"int"
			};

		_methodName62 = "findByCorpIdCtyAndRms";

		_methodParameterTypes62 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String", "int",
				"int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName63 = "findByCorpIdCtyAndSms";

		_methodParameterTypes63 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String"
			};

		_methodName64 = "findByCorpIdCtyAndSms";

		_methodParameterTypes64 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String", "int",
				"int"
			};

		_methodName65 = "findByCorpIdCtyAndSms";

		_methodParameterTypes65 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String", "int",
				"int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName66 = "findByCorpIdCtyRmsAndSms";

		_methodParameterTypes66 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName67 = "findByCorpIdCtyRmsAndSms";

		_methodParameterTypes67 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int"
			};

		_methodName68 = "findByCorpIdCtyRmsAndSms";

		_methodParameterTypes68 = new String[] {
				"long", "boolean", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName69 = "getAvailableMDListByReceiveId";

		_methodParameterTypes69 = new String[] {
				"com.liferay.portal.model.User", "long", "boolean",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int", "java.lang.String", "long"
			};

		_methodName70 = "getAvailableMDListByReceiveId";

		_methodParameterTypes70 = new String[] {
				"com.liferay.portal.model.User", "long", "boolean",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int", "com.liferay.portal.kernel.util.OrderByComparator",
				"long"
			};

		_methodName71 = "getAvailableMDListByCorpProfileId";

		_methodParameterTypes71 = new String[] {
				"com.liferay.portal.model.User", "long", "boolean",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int", "com.liferay.portal.kernel.util.OrderByComparator",
				"long"
			};

		_methodName72 = "findByMessageId";

		_methodParameterTypes72 = new String[] { "long" };

		_methodName73 = "findByMessageId";

		_methodParameterTypes73 = new String[] { "long", "int", "int" };

		_methodName74 = "findByMessageId";

		_methodParameterTypes74 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};
	}

	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail addIBMessageDetail(
		com.sambaash.platform.srv.spinbox.model.IBMessageDetail ibMessageDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName0,
					_methodParameterTypes0,
					new Object[] { ClpSerializer.translateInput(ibMessageDetail) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (com.sambaash.platform.srv.spinbox.model.IBMessageDetail)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail createIBMessageDetail(
		long ibMsgDetailId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName1,
					_methodParameterTypes1, new Object[] { ibMsgDetailId });
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

		return (com.sambaash.platform.srv.spinbox.model.IBMessageDetail)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail deleteIBMessageDetail(
		long ibMsgDetailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName2,
					_methodParameterTypes2, new Object[] { ibMsgDetailId });
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

		return (com.sambaash.platform.srv.spinbox.model.IBMessageDetail)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail deleteIBMessageDetail(
		com.sambaash.platform.srv.spinbox.model.IBMessageDetail ibMessageDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] { ClpSerializer.translateInput(ibMessageDetail) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (com.sambaash.platform.srv.spinbox.model.IBMessageDetail)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName4,
					_methodParameterTypes4, new Object[] {  });
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

		return (com.liferay.portal.kernel.dao.orm.DynamicQuery)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] { ClpSerializer.translateInput(dynamicQuery) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] {
						ClpSerializer.translateInput(dynamicQuery),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] {
						ClpSerializer.translateInput(dynamicQuery),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName8,
					_methodParameterTypes8,
					new Object[] { ClpSerializer.translateInput(dynamicQuery) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return ((Long)returnObj).longValue();
	}

	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] {
						ClpSerializer.translateInput(dynamicQuery),
						
					ClpSerializer.translateInput(projection)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return ((Long)returnObj).longValue();
	}

	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchIBMessageDetail(
		long ibMsgDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName10,
					_methodParameterTypes10, new Object[] { ibMsgDetailId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (com.sambaash.platform.srv.spinbox.model.IBMessageDetail)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail getIBMessageDetail(
		long ibMsgDetailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName11,
					_methodParameterTypes11, new Object[] { ibMsgDetailId });
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

		return (com.sambaash.platform.srv.spinbox.model.IBMessageDetail)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName12,
					_methodParameterTypes12,
					new Object[] { ClpSerializer.translateInput(primaryKeyObj) });
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

		return (com.liferay.portal.model.PersistedModel)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> getIBMessageDetails(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName13,
					_methodParameterTypes13, new Object[] { start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int getIBMessageDetailsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName14,
					_methodParameterTypes14, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return ((Integer)returnObj).intValue();
	}

	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail updateIBMessageDetail(
		com.sambaash.platform.srv.spinbox.model.IBMessageDetail ibMessageDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName15,
					_methodParameterTypes15,
					new Object[] { ClpSerializer.translateInput(ibMessageDetail) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (com.sambaash.platform.srv.spinbox.model.IBMessageDetail)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getBeanIdentifier() {
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableLocalService.invokeMethod(_methodName17,
				_methodParameterTypes17,
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
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail addMessageDetail(
		long messageId, long receiverId, java.lang.String receiveBy,
		java.util.Date receiveDate, java.lang.String category,
		boolean archived, java.util.Date updateDate, java.lang.String updateBy,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		java.lang.String status, long processId, long corpProfileId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName19,
					_methodParameterTypes19,
					new Object[] {
						messageId,
						
					receiverId,
						
					ClpSerializer.translateInput(receiveBy),
						
					ClpSerializer.translateInput(receiveDate),
						
					ClpSerializer.translateInput(category),
						
					archived,
						
					ClpSerializer.translateInput(updateDate),
						
					ClpSerializer.translateInput(updateBy),
						
					ClpSerializer.translateInput(receiverMsgStatus),
						
					ClpSerializer.translateInput(senderMsgStatus),
						
					ClpSerializer.translateInput(status),
						
					processId,
						
					corpProfileId
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

		return (com.sambaash.platform.srv.spinbox.model.IBMessageDetail)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceiverIdmessageId(
		long receiverId, long msgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName20,
					_methodParameterTypes20, new Object[] { receiverId, msgId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (com.sambaash.platform.srv.spinbox.model.IBMessageDetail)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceId(
		long receiverId, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName21,
					_methodParameterTypes21,
					new Object[] { receiverId, archived });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceId(
		long receiverId, boolean archived, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName22,
					_methodParameterTypes22,
					new Object[] { receiverId, archived, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceId(
		long receiverId, boolean archived, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName23,
					_methodParameterTypes23,
					new Object[] {
						receiverId,
						
					archived,
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndRms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName24,
					_methodParameterTypes24,
					new Object[] {
						receiverId,
						
					archived,
						
					ClpSerializer.translateInput(receiverMsgStatus)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndRms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName25,
					_methodParameterTypes25,
					new Object[] {
						receiverId,
						
					archived,
						
					ClpSerializer.translateInput(receiverMsgStatus),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndRms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName26,
					_methodParameterTypes26,
					new Object[] {
						receiverId,
						
					archived,
						
					ClpSerializer.translateInput(receiverMsgStatus),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndSms(
		long receiverId, boolean archived, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName27,
					_methodParameterTypes27,
					new Object[] {
						receiverId,
						
					archived,
						
					ClpSerializer.translateInput(senderMsgStatus)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndSms(
		long receiverId, boolean archived, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName28,
					_methodParameterTypes28,
					new Object[] {
						receiverId,
						
					archived,
						
					ClpSerializer.translateInput(senderMsgStatus),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndSms(
		long receiverId, boolean archived, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName29,
					_methodParameterTypes29,
					new Object[] {
						receiverId,
						
					archived,
						
					ClpSerializer.translateInput(senderMsgStatus),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdRmsAndSms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName30,
					_methodParameterTypes30,
					new Object[] {
						receiverId,
						
					archived,
						
					ClpSerializer.translateInput(receiverMsgStatus),
						
					ClpSerializer.translateInput(senderMsgStatus)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdRmsAndSms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName31,
					_methodParameterTypes31,
					new Object[] {
						receiverId,
						
					archived,
						
					ClpSerializer.translateInput(receiverMsgStatus),
						
					ClpSerializer.translateInput(senderMsgStatus),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdRmsAndSms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName32,
					_methodParameterTypes32,
					new Object[] {
						receiverId,
						
					archived,
						
					ClpSerializer.translateInput(receiverMsgStatus),
						
					ClpSerializer.translateInput(senderMsgStatus),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndCty(
		long receiverId, boolean archived, java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName33,
					_methodParameterTypes33,
					new Object[] {
						receiverId,
						
					archived,
						
					ClpSerializer.translateInput(category)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndCty(
		long receiverId, boolean archived, java.lang.String category,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName34,
					_methodParameterTypes34,
					new Object[] {
						receiverId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndCty(
		long receiverId, boolean archived, java.lang.String category,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName35,
					_methodParameterTypes35,
					new Object[] {
						receiverId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndRms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName36,
					_methodParameterTypes36,
					new Object[] {
						receiverId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					ClpSerializer.translateInput(receiverMsgStatus)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndRms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName37,
					_methodParameterTypes37,
					new Object[] {
						receiverId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					ClpSerializer.translateInput(receiverMsgStatus),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndRms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName38,
					_methodParameterTypes38,
					new Object[] {
						receiverId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					ClpSerializer.translateInput(receiverMsgStatus),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName39,
					_methodParameterTypes39,
					new Object[] {
						receiverId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					ClpSerializer.translateInput(senderMsgStatus)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName40,
					_methodParameterTypes40,
					new Object[] {
						receiverId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					ClpSerializer.translateInput(senderMsgStatus),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName41,
					_methodParameterTypes41,
					new Object[] {
						receiverId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					ClpSerializer.translateInput(senderMsgStatus),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyRmsAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName42,
					_methodParameterTypes42,
					new Object[] {
						receiverId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					ClpSerializer.translateInput(receiverMsgStatus),
						
					ClpSerializer.translateInput(senderMsgStatus)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyRmsAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName43,
					_methodParameterTypes43,
					new Object[] {
						receiverId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					ClpSerializer.translateInput(receiverMsgStatus),
						
					ClpSerializer.translateInput(senderMsgStatus),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyRmsAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName44,
					_methodParameterTypes44,
					new Object[] {
						receiverId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					ClpSerializer.translateInput(receiverMsgStatus),
						
					ClpSerializer.translateInput(senderMsgStatus),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpId(
		long corpProfileId, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName45,
					_methodParameterTypes45,
					new Object[] { corpProfileId, archived });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpId(
		long corpProfileId, boolean archived, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName46,
					_methodParameterTypes46,
					new Object[] { corpProfileId, archived, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpId(
		long corpProfileId, boolean archived, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName47,
					_methodParameterTypes47,
					new Object[] {
						corpProfileId,
						
					archived,
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndRms(
		long corpProfileId, boolean archived, java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName48,
					_methodParameterTypes48,
					new Object[] {
						corpProfileId,
						
					archived,
						
					ClpSerializer.translateInput(receiverMsgStatus)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndRms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName49,
					_methodParameterTypes49,
					new Object[] {
						corpProfileId,
						
					archived,
						
					ClpSerializer.translateInput(receiverMsgStatus),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndRms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName50,
					_methodParameterTypes50,
					new Object[] {
						corpProfileId,
						
					archived,
						
					ClpSerializer.translateInput(receiverMsgStatus),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndSms(
		long corpProfileId, boolean archived, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName51,
					_methodParameterTypes51,
					new Object[] {
						corpProfileId,
						
					archived,
						
					ClpSerializer.translateInput(senderMsgStatus)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndSms(
		long corpProfileId, boolean archived, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName52,
					_methodParameterTypes52,
					new Object[] {
						corpProfileId,
						
					archived,
						
					ClpSerializer.translateInput(senderMsgStatus),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndSms(
		long corpProfileId, boolean archived, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName53,
					_methodParameterTypes53,
					new Object[] {
						corpProfileId,
						
					archived,
						
					ClpSerializer.translateInput(senderMsgStatus),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdRmsAndSms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName54,
					_methodParameterTypes54,
					new Object[] {
						corpProfileId,
						
					archived,
						
					ClpSerializer.translateInput(receiverMsgStatus),
						
					ClpSerializer.translateInput(senderMsgStatus)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdRmsAndSms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName55,
					_methodParameterTypes55,
					new Object[] {
						corpProfileId,
						
					archived,
						
					ClpSerializer.translateInput(receiverMsgStatus),
						
					ClpSerializer.translateInput(senderMsgStatus),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdRmsAndSms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName56,
					_methodParameterTypes56,
					new Object[] {
						corpProfileId,
						
					archived,
						
					ClpSerializer.translateInput(receiverMsgStatus),
						
					ClpSerializer.translateInput(senderMsgStatus),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndCty(
		long corpProfileId, boolean archived, java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName57,
					_methodParameterTypes57,
					new Object[] {
						corpProfileId,
						
					archived,
						
					ClpSerializer.translateInput(category)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndCty(
		long corpProfileId, boolean archived, java.lang.String category,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName58,
					_methodParameterTypes58,
					new Object[] {
						corpProfileId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndCty(
		long corpProfileId, boolean archived, java.lang.String category,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName59,
					_methodParameterTypes59,
					new Object[] {
						corpProfileId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndRms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName60,
					_methodParameterTypes60,
					new Object[] {
						corpProfileId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					ClpSerializer.translateInput(receiverMsgStatus)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndRms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName61,
					_methodParameterTypes61,
					new Object[] {
						corpProfileId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					ClpSerializer.translateInput(receiverMsgStatus),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndRms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName62,
					_methodParameterTypes62,
					new Object[] {
						corpProfileId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					ClpSerializer.translateInput(receiverMsgStatus),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName63,
					_methodParameterTypes63,
					new Object[] {
						corpProfileId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					ClpSerializer.translateInput(senderMsgStatus)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName64,
					_methodParameterTypes64,
					new Object[] {
						corpProfileId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					ClpSerializer.translateInput(senderMsgStatus),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName65,
					_methodParameterTypes65,
					new Object[] {
						corpProfileId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					ClpSerializer.translateInput(senderMsgStatus),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyRmsAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName66,
					_methodParameterTypes66,
					new Object[] {
						corpProfileId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					ClpSerializer.translateInput(receiverMsgStatus),
						
					ClpSerializer.translateInput(senderMsgStatus)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyRmsAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName67,
					_methodParameterTypes67,
					new Object[] {
						corpProfileId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					ClpSerializer.translateInput(receiverMsgStatus),
						
					ClpSerializer.translateInput(senderMsgStatus),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyRmsAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName68,
					_methodParameterTypes68,
					new Object[] {
						corpProfileId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					ClpSerializer.translateInput(receiverMsgStatus),
						
					ClpSerializer.translateInput(senderMsgStatus),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> getAvailableMDListByReceiveId(
		com.liferay.portal.model.User user, long receiverId, boolean archived,
		java.lang.String category, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus, int start, int end,
		java.lang.String comparator, long scopeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName69,
					_methodParameterTypes69,
					new Object[] {
						ClpSerializer.translateInput(user),
						
					receiverId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					ClpSerializer.translateInput(receiverMsgStatus),
						
					ClpSerializer.translateInput(senderMsgStatus),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(comparator),
						
					scopeGroupId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> getAvailableMDListByReceiveId(
		com.liferay.portal.model.User user, long receiverId, boolean archived,
		java.lang.String category, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator,
		long scopeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName70,
					_methodParameterTypes70,
					new Object[] {
						ClpSerializer.translateInput(user),
						
					receiverId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					ClpSerializer.translateInput(receiverMsgStatus),
						
					ClpSerializer.translateInput(senderMsgStatus),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator),
						
					scopeGroupId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> getAvailableMDListByCorpProfileId(
		com.liferay.portal.model.User user, long corpProfileId,
		boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator,
		long scopeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName71,
					_methodParameterTypes71,
					new Object[] {
						ClpSerializer.translateInput(user),
						
					corpProfileId,
						
					archived,
						
					ClpSerializer.translateInput(category),
						
					ClpSerializer.translateInput(receiverMsgStatus),
						
					ClpSerializer.translateInput(senderMsgStatus),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator),
						
					scopeGroupId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByMessageId(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName72,
					_methodParameterTypes72, new Object[] { messageId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByMessageId(
		long messageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName73,
					_methodParameterTypes73,
					new Object[] { messageId, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByMessageId(
		long messageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName74,
					_methodParameterTypes74,
					new Object[] {
						messageId,
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

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

		return (java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail>)ClpSerializer.translateOutput(returnObj);
	}

	private InvokableLocalService _invokableLocalService;
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
	private String _methodName38;
	private String[] _methodParameterTypes38;
	private String _methodName39;
	private String[] _methodParameterTypes39;
	private String _methodName40;
	private String[] _methodParameterTypes40;
	private String _methodName41;
	private String[] _methodParameterTypes41;
	private String _methodName42;
	private String[] _methodParameterTypes42;
	private String _methodName43;
	private String[] _methodParameterTypes43;
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName45;
	private String[] _methodParameterTypes45;
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
}