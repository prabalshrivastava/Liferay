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

package com.sambaash.platform.srv.spsocialsharing.service;

import com.liferay.portal.service.InvokableLocalService;

/**
 * @author harini
 * @generated
 */
public class SPSocialSharingLocalServiceClp
	implements SPSocialSharingLocalService {
	public SPSocialSharingLocalServiceClp(
		InvokableLocalService invokableLocalService) {
		_invokableLocalService = invokableLocalService;

		_methodName0 = "addSPSocialSharing";

		_methodParameterTypes0 = new String[] {
				"com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing"
			};

		_methodName1 = "createSPSocialSharing";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteSPSocialSharing";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteSPSocialSharing";

		_methodParameterTypes3 = new String[] {
				"com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing"
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

		_methodName10 = "fetchSPSocialSharing";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchSPSocialSharingByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchSPSocialSharingByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getSPSocialSharing";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getSPSocialSharingByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getSPSocialSharingByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getSPSocialSharings";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getSPSocialSharingsCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateSPSocialSharing";

		_methodParameterTypes19 = new String[] {
				"com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing"
			};

		_methodName20 = "getBeanIdentifier";

		_methodParameterTypes20 = new String[] {  };

		_methodName21 = "setBeanIdentifier";

		_methodParameterTypes21 = new String[] { "java.lang.String" };

		_methodName23 = "findByClassNameIdAndClassPK";

		_methodParameterTypes23 = new String[] { "long", "long" };

		_methodName24 = "postBlogToSocialNetwork";

		_methodParameterTypes24 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "long", "long",
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"com.liferay.portal.model.User"
			};

		_methodName25 = "postEventToSocialNetworks";

		_methodParameterTypes25 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "long", "long",
				"com.liferay.portal.model.User"
			};

		_methodName26 = "postGroupToSocialNetworks";

		_methodParameterTypes26 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "long", "long",
				"com.liferay.portal.model.User", "long"
			};

		_methodName27 = "postJobsToSocialNetworks";

		_methodParameterTypes27 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "long", "long",
				"com.liferay.portal.model.User"
			};

		_methodName28 = "postProfileToSocialNetwork";

		_methodParameterTypes28 = new String[] {
				"com.liferay.portal.model.User",
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName29 = "postSPAssetToSocialNetwork";

		_methodParameterTypes29 = new String[] {
				"com.sambaash.platform.srv.spasset.model.SPAssetEntry",
				"java.lang.String", "java.lang.String"
			};

		_methodName30 = "postSPGroupToSocialNetworks";

		_methodParameterTypes30 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "long", "long",
				"com.liferay.portal.model.User", "boolean", "boolean", "boolean",
				"boolean"
			};

		_methodName31 = "publishToFacebook";

		_methodParameterTypes31 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "long",
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName32 = "publishToFacebookPage";

		_methodParameterTypes32 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "long",
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName33 = "publishToLinkedIn";

		_methodParameterTypes33 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "long",
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName34 = "publishToTwitter";

		_methodParameterTypes34 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "long",
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName35 = "saveProfileImage";

		_methodParameterTypes35 = new String[] { "java.lang.String", "long" };

		_methodName36 = "sendNotificationAdmin";

		_methodParameterTypes36 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "long"
			};

		_methodName37 = "updateFacebookPageShareStatus";

		_methodParameterTypes37 = new String[] { "long", "long", "int" };

		_methodName38 = "updateFacebookShareStatus";

		_methodParameterTypes38 = new String[] { "long", "long", "int" };

		_methodName39 = "updateLinkedInShareStatus";

		_methodParameterTypes39 = new String[] { "long", "long", "int" };

		_methodName40 = "updateTwitterShareStatus";

		_methodParameterTypes40 = new String[] { "long", "long", "int" };
	}

	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing addSPSocialSharing(
		com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing spSocialSharing)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName0,
					_methodParameterTypes0,
					new Object[] { ClpSerializer.translateInput(spSocialSharing) });
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

		return (com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing createSPSocialSharing(
		long spSocialSharingId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName1,
					_methodParameterTypes1, new Object[] { spSocialSharingId });
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

		return (com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing deleteSPSocialSharing(
		long spSocialSharingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName2,
					_methodParameterTypes2, new Object[] { spSocialSharingId });
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

		return (com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing deleteSPSocialSharing(
		com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing spSocialSharing)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] { ClpSerializer.translateInput(spSocialSharing) });
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

		return (com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing)ClpSerializer.translateOutput(returnObj);
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
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing fetchSPSocialSharing(
		long spSocialSharingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName10,
					_methodParameterTypes10, new Object[] { spSocialSharingId });
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

		return (com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing fetchSPSocialSharingByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName11,
					_methodParameterTypes11,
					new Object[] { ClpSerializer.translateInput(uuid), companyId });
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

		return (com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing fetchSPSocialSharingByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName12,
					_methodParameterTypes12,
					new Object[] { ClpSerializer.translateInput(uuid), groupId });
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

		return (com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing getSPSocialSharing(
		long spSocialSharingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName13,
					_methodParameterTypes13, new Object[] { spSocialSharingId });
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

		return (com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName14,
					_methodParameterTypes14,
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
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing getSPSocialSharingByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName15,
					_methodParameterTypes15,
					new Object[] { ClpSerializer.translateInput(uuid), companyId });
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

		return (com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing getSPSocialSharingByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName16,
					_methodParameterTypes16,
					new Object[] { ClpSerializer.translateInput(uuid), groupId });
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

		return (com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing> getSPSocialSharings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName17,
					_methodParameterTypes17, new Object[] { start, end });
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

		return (java.util.List<com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int getSPSocialSharingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName18,
					_methodParameterTypes18, new Object[] {  });
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
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing updateSPSocialSharing(
		com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing spSocialSharing)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName19,
					_methodParameterTypes19,
					new Object[] { ClpSerializer.translateInput(spSocialSharing) });
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

		return (com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName20,
					_methodParameterTypes20, new Object[] {  });
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
			_invokableLocalService.invokeMethod(_methodName21,
				_methodParameterTypes21,
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
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing findByClassNameIdAndClassPK(
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName23,
					_methodParameterTypes23,
					new Object[] { classNameId, classPK });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException) {
				throw (com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void postBlogToSocialNetwork(long blogId, java.lang.String title,
		java.lang.String altMessage, java.lang.String url,
		java.lang.String imgUrl, long companyId, long groupId,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		com.liferay.portal.model.User user) {
		try {
			_invokableLocalService.invokeMethod(_methodName24,
				_methodParameterTypes24,
				new Object[] {
					blogId,
					
				ClpSerializer.translateInput(title),
					
				ClpSerializer.translateInput(altMessage),
					
				ClpSerializer.translateInput(url),
					
				ClpSerializer.translateInput(imgUrl),
					
				companyId,
					
				groupId,
					
				ClpSerializer.translateInput(socialProfile),
					
				ClpSerializer.translateInput(user)
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
	public void postEventToSocialNetworks(long eventId, java.lang.String title,
		java.lang.String altMessage, java.lang.String url,
		java.lang.String imgUrl, long companyId, long groupId,
		com.liferay.portal.model.User user) {
		try {
			_invokableLocalService.invokeMethod(_methodName25,
				_methodParameterTypes25,
				new Object[] {
					eventId,
					
				ClpSerializer.translateInput(title),
					
				ClpSerializer.translateInput(altMessage),
					
				ClpSerializer.translateInput(url),
					
				ClpSerializer.translateInput(imgUrl),
					
				companyId,
					
				groupId,
					
				ClpSerializer.translateInput(user)
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
	public void postGroupToSocialNetworks(long groupDetailId,
		java.lang.String title, java.lang.String altMessage,
		java.lang.String url, java.lang.String imgUrl, long companyId,
		long groupId, com.liferay.portal.model.User user, long classNameId) {
		try {
			_invokableLocalService.invokeMethod(_methodName26,
				_methodParameterTypes26,
				new Object[] {
					groupDetailId,
					
				ClpSerializer.translateInput(title),
					
				ClpSerializer.translateInput(altMessage),
					
				ClpSerializer.translateInput(url),
					
				ClpSerializer.translateInput(imgUrl),
					
				companyId,
					
				groupId,
					
				ClpSerializer.translateInput(user),
					
				classNameId
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
	public void postJobsToSocialNetworks(long jobId, java.lang.String title,
		java.lang.String altMessage, java.lang.String url,
		java.lang.String imgUrl, long companyId, long groupId,
		com.liferay.portal.model.User user) {
		try {
			_invokableLocalService.invokeMethod(_methodName27,
				_methodParameterTypes27,
				new Object[] {
					jobId,
					
				ClpSerializer.translateInput(title),
					
				ClpSerializer.translateInput(altMessage),
					
				ClpSerializer.translateInput(url),
					
				ClpSerializer.translateInput(imgUrl),
					
				companyId,
					
				groupId,
					
				ClpSerializer.translateInput(user)
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
	public void postProfileToSocialNetwork(com.liferay.portal.model.User user,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile) {
		try {
			_invokableLocalService.invokeMethod(_methodName28,
				_methodParameterTypes28,
				new Object[] {
					ClpSerializer.translateInput(user),
					
				ClpSerializer.translateInput(socialProfile)
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
	public void postSPAssetToSocialNetwork(
		com.sambaash.platform.srv.spasset.model.SPAssetEntry spAssetEntry,
		java.lang.String url, java.lang.String imgUrl) {
		try {
			_invokableLocalService.invokeMethod(_methodName29,
				_methodParameterTypes29,
				new Object[] {
					ClpSerializer.translateInput(spAssetEntry),
					
				ClpSerializer.translateInput(url),
					
				ClpSerializer.translateInput(imgUrl)
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
	public void postSPGroupToSocialNetworks(long classNameId, long classPK,
		java.lang.String title, java.lang.String altMessage,
		java.lang.String url, java.lang.String imgUrl, long companyId,
		long groupId, com.liferay.portal.model.User user, boolean enableFB,
		boolean enableIn, boolean enableGoogle, boolean enableTW) {
		try {
			_invokableLocalService.invokeMethod(_methodName30,
				_methodParameterTypes30,
				new Object[] {
					classNameId,
					
				classPK,
					
				ClpSerializer.translateInput(title),
					
				ClpSerializer.translateInput(altMessage),
					
				ClpSerializer.translateInput(url),
					
				ClpSerializer.translateInput(imgUrl),
					
				companyId,
					
				groupId,
					
				ClpSerializer.translateInput(user),
					
				enableFB,
					
				enableIn,
					
				enableGoogle,
					
				enableTW
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
	public int publishToFacebook(java.lang.String title,
		java.lang.String message, java.lang.String link,
		java.lang.String pictureUrl, long groupId, long companyId,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws java.lang.Exception {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName31,
					_methodParameterTypes31,
					new Object[] {
						ClpSerializer.translateInput(title),
						
					ClpSerializer.translateInput(message),
						
					ClpSerializer.translateInput(link),
						
					ClpSerializer.translateInput(pictureUrl),
						
					groupId,
						
					companyId,
						
					ClpSerializer.translateInput(socialProfile)
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

		return ((Integer)returnObj).intValue();
	}

	@Override
	public int publishToFacebookPage(java.lang.String title,
		java.lang.String message, java.lang.String link,
		java.lang.String pictureUrl, long groupId, long companyId,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws java.lang.Exception {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName32,
					_methodParameterTypes32,
					new Object[] {
						ClpSerializer.translateInput(title),
						
					ClpSerializer.translateInput(message),
						
					ClpSerializer.translateInput(link),
						
					ClpSerializer.translateInput(pictureUrl),
						
					groupId,
						
					companyId,
						
					ClpSerializer.translateInput(socialProfile)
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

		return ((Integer)returnObj).intValue();
	}

	@Override
	public int publishToLinkedIn(java.lang.String title,
		java.lang.String message, java.lang.String link,
		java.lang.String pictureUrl, long groupId, long companyId,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws java.lang.Exception {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName33,
					_methodParameterTypes33,
					new Object[] {
						ClpSerializer.translateInput(title),
						
					ClpSerializer.translateInput(message),
						
					ClpSerializer.translateInput(link),
						
					ClpSerializer.translateInput(pictureUrl),
						
					groupId,
						
					companyId,
						
					ClpSerializer.translateInput(socialProfile)
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

		return ((Integer)returnObj).intValue();
	}

	@Override
	public int publishToTwitter(java.lang.String message,
		java.lang.String link, java.lang.String pictureUrl, long groupId,
		long companyId,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws java.lang.Exception {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName34,
					_methodParameterTypes34,
					new Object[] {
						ClpSerializer.translateInput(message),
						
					ClpSerializer.translateInput(link),
						
					ClpSerializer.translateInput(pictureUrl),
						
					groupId,
						
					companyId,
						
					ClpSerializer.translateInput(socialProfile)
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

		return ((Integer)returnObj).intValue();
	}

	@Override
	public void saveProfileImage(java.lang.String pictureUrl, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.upload.UploadException {
		try {
			_invokableLocalService.invokeMethod(_methodName35,
				_methodParameterTypes35,
				new Object[] { ClpSerializer.translateInput(pictureUrl), userId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.liferay.portal.kernel.upload.UploadException) {
				throw (com.liferay.portal.kernel.upload.UploadException)t;
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
	public void sendNotificationAdmin(java.lang.String fromAddress,
		java.lang.String fromName, java.lang.String body,
		java.lang.String subject, long companyId, long groupId) {
		try {
			_invokableLocalService.invokeMethod(_methodName36,
				_methodParameterTypes36,
				new Object[] {
					ClpSerializer.translateInput(fromAddress),
					
				ClpSerializer.translateInput(fromName),
					
				ClpSerializer.translateInput(body),
					
				ClpSerializer.translateInput(subject),
					
				companyId,
					
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
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing updateFacebookPageShareStatus(
		long classNameId, long classPK, int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName37,
					_methodParameterTypes37,
					new Object[] { classNameId, classPK, status });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException) {
				throw (com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing updateFacebookShareStatus(
		long classNameId, long classPK, int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName38,
					_methodParameterTypes38,
					new Object[] { classNameId, classPK, status });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException) {
				throw (com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing updateLinkedInShareStatus(
		long classNameId, long classPK, int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName39,
					_methodParameterTypes39,
					new Object[] { classNameId, classPK, status });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException) {
				throw (com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing updateTwitterShareStatus(
		long classNameId, long classPK, int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName40,
					_methodParameterTypes40,
					new Object[] { classNameId, classPK, status });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException) {
				throw (com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing)ClpSerializer.translateOutput(returnObj);
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
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
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
}