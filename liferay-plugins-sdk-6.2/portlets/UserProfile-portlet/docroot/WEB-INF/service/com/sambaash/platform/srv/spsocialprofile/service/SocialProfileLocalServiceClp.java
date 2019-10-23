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

package com.sambaash.platform.srv.spsocialprofile.service;

import com.liferay.portal.service.InvokableLocalService;

/**
 * @author gauravvijayvergia
 * @generated
 */
public class SocialProfileLocalServiceClp implements SocialProfileLocalService {
	public SocialProfileLocalServiceClp(
		InvokableLocalService invokableLocalService) {
		_invokableLocalService = invokableLocalService;

		_methodName0 = "addSocialProfile";

		_methodParameterTypes0 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName1 = "createSocialProfile";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteSocialProfile";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteSocialProfile";

		_methodParameterTypes3 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
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

		_methodName10 = "fetchSocialProfile";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchSocialProfileByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchSocialProfileByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getSocialProfile";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getSocialProfileByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getSocialProfileByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getSocialProfiles";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getSocialProfilesCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateSocialProfile";

		_methodParameterTypes19 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName20 = "getBeanIdentifier";

		_methodParameterTypes20 = new String[] {  };

		_methodName21 = "setBeanIdentifier";

		_methodParameterTypes21 = new String[] { "java.lang.String" };

		_methodName23 = "findBymemberPackageId";

		_methodParameterTypes23 = new String[] { "java.lang.String" };

		_methodName24 = "getIndProfilePublicUrl";

		_methodParameterTypes24 = new String[] { "long", "long", "long" };

		_methodName25 = "getIndProfilePrivateUrl";

		_methodParameterTypes25 = new String[] { "long", "long", "long" };

		_methodName26 = "getIndProfileLandingUrl";

		_methodParameterTypes26 = new String[] { "long", "long", "long" };

		_methodName27 = "getCorpProfilePublicUrl";

		_methodParameterTypes27 = new String[] { "long", "long", "long" };

		_methodName28 = "getCorpProfilePrivateUrl";

		_methodParameterTypes28 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName29 = "getCorpProfileLandingUrl";

		_methodParameterTypes29 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName30 = "addSocialProfileForIndividualUser";

		_methodParameterTypes30 = new String[] {
				"long", "java.lang.String", "long"
			};

		_methodName31 = "addSocialProfileForCorporate";

		_methodParameterTypes31 = new String[] {
				"long", "java.lang.String", "long"
			};

		_methodName32 = "incrementProfileViewCount";

		_methodParameterTypes32 = new String[] { "long", "long" };

		_methodName33 = "getProfileViewCount";

		_methodParameterTypes33 = new String[] { "long", "long" };

		_methodName34 = "findByuserIdCompIdAndRegStatus";

		_methodParameterTypes34 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName35 = "isIndividualUser";

		_methodParameterTypes35 = new String[] { "long", "long" };

		_methodName36 = "updateSocialProfileAndTags";

		_methodParameterTypes36 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"java.lang.String[][]", "long"
			};

		_methodName37 = "getUserScreenName";

		_methodParameterTypes37 = new String[] { "long" };

		_methodName38 = "getSocialProfile";

		_methodParameterTypes38 = new String[] { "long", "long" };

		_methodName39 = "reIndex";

		_methodParameterTypes39 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName40 = "updateSocialProfile_No_Indexing";

		_methodParameterTypes40 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName41 = "addOrUpdateAsset";

		_methodParameterTypes41 = new String[] {
				"long", "long",
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"long[][]", "java.lang.String[][]", "boolean"
			};

		_methodName42 = "addOrUpdateSocialProfile";

		_methodParameterTypes42 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"com.liferay.portal.model.User", "boolean", "long"
			};

		_methodName43 = "addOrUpdateSocialProfile";

		_methodParameterTypes43 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"com.liferay.portal.model.User", "boolean", "long", "boolean"
			};

		_methodName44 = "updateBirthday";

		_methodParameterTypes44 = new String[] {
				"com.liferay.portal.model.User", "java.util.Date"
			};

		_methodName45 = "updateGender";

		_methodParameterTypes45 = new String[] {
				"com.liferay.portal.model.User", "java.lang.String"
			};

		_methodName46 = "updateSingleNodeField";

		_methodParameterTypes46 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName47 = "deleteXMLInstance";

		_methodParameterTypes47 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName48 = "deleteAllWorkHistory";

		_methodParameterTypes48 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName49 = "addOrUpdateWorkHistory";

		_methodParameterTypes49 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"long", "java.util.Map"
			};

		_methodName50 = "addOrUpdateWorkHistoryFromFormData";

		_methodParameterTypes50 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"long", "java.util.Map"
			};

		_methodName51 = "getUserWorkHistoryDetails";

		_methodParameterTypes51 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName52 = "getUserTransactionHistoryDetails";

		_methodParameterTypes52 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"java.lang.String", "java.lang.String", "java.lang.String[][]"
			};

		_methodName53 = "addNetworkInfo";

		_methodParameterTypes53 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName54 = "addOrUpdateAvailability";

		_methodParameterTypes54 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"long", "java.util.Map"
			};

		_methodName55 = "addOrUpdateDynamicSection";

		_methodParameterTypes55 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"long", "java.util.Map"
			};

		_methodName56 = "addOrUpdateDynamicSection";

		_methodParameterTypes56 = new String[] {
				"java.lang.String", "java.lang.String",
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"long", "java.util.Map"
			};

		_methodName57 = "updateUser";

		_methodParameterTypes57 = new String[] { "com.liferay.portal.model.User" };

		_methodName58 = "updateUserScreenName";

		_methodParameterTypes58 = new String[] { "long", "java.lang.String" };

		_methodName59 = "getUserWebSites";

		_methodParameterTypes59 = new String[] { "long", "long" };

		_methodName60 = "getUserPhoneList";

		_methodParameterTypes60 = new String[] { "long", "long" };

		_methodName61 = "getContacts";

		_methodParameterTypes61 = new String[] { "long", "long" };

		_methodName62 = "getUserEmailAddressList";

		_methodParameterTypes62 = new String[] { "long", "long" };

		_methodName63 = "getUserAddresses";

		_methodParameterTypes63 = new String[] { "long", "long" };

		_methodName64 = "updateWebsites";

		_methodParameterTypes64 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"java.util.List"
			};

		_methodName65 = "updateContactInfo";

		_methodParameterTypes65 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"java.util.List"
			};

		_methodName66 = "updateNetworkInfo";

		_methodParameterTypes66 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"java.util.List"
			};

		_methodName67 = "updateEmailAddresses";

		_methodParameterTypes67 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"java.util.List"
			};

		_methodName68 = "updateAddress";

		_methodParameterTypes68 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"java.util.List"
			};

		_methodName69 = "updateMobileNo";

		_methodParameterTypes69 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"java.util.List"
			};

		_methodName70 = "updateLocationAndMobileNo";

		_methodParameterTypes70 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"java.util.List"
			};

		_methodName71 = "updateXMLFromSocialProfile";

		_methodParameterTypes71 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName72 = "updatePersonalInfoWhenReg";

		_methodParameterTypes72 = new String[] {
				"com.liferay.portal.model.User",
				"com.liferay.portal.kernel.json.JSONObject"
			};

		_methodName73 = "updatePersonalInfo";

		_methodParameterTypes73 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"com.liferay.portal.model.User"
			};

		_methodName74 = "transformSocialProfileXML";

		_methodParameterTypes74 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"com.liferay.portal.model.User"
			};

		_methodName75 = "saveContactInfoXMLData";

		_methodParameterTypes75 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"java.lang.String", "java.lang.String"
			};

		_methodName76 = "updateUserNetworkInfoFromSocialProfile";

		_methodParameterTypes76 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName77 = "addSocialProfileDetail";

		_methodParameterTypes77 = new String[] {
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String"
			};

		_methodName78 = "getExpertiseTags";

		_methodParameterTypes78 = new String[] {  };

		_methodName79 = "getExpertiseTags";

		_methodParameterTypes79 = new String[] { "long" };

		_methodName80 = "getProfileCompletion";

		_methodParameterTypes80 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName81 = "saveAvailabilityInfo";

		_methodParameterTypes81 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName82 = "saveWorkHistorySorted";

		_methodParameterTypes82 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"java.lang.String"
			};

		_methodName83 = "updateSPParameter";

		_methodParameterTypes83 = new String[] {
				"java.lang.String", "long", "java.lang.String",
				"java.lang.String"
			};

		_methodName84 = "findByUserTypeAndRegStatus";

		_methodParameterTypes84 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName85 = "findByUserTypeAndRegStatus";

		_methodParameterTypes85 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName86 = "findByUserTypeAndRegStatus";

		_methodParameterTypes86 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName87 = "findByU1_S1_S_E";

		_methodParameterTypes87 = new String[] {
				"java.lang.String", "boolean", "int", "int"
			};

		_methodName88 = "getFieldValue";

		_methodParameterTypes88 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName89 = "findSocialProfileLocation";

		_methodParameterTypes89 = new String[] {  };

		_methodName90 = "addOrUpdateProfileSPListTypes";

		_methodParameterTypes90 = new String[] {
				"java.lang.String", "java.lang.String[][]", "long"
			};

		_methodName91 = "updateWorkHistoryRelatedProjects";

		_methodParameterTypes91 = new String[] {
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String", "java.lang.String", "int"
			};

		_methodName92 = "refreshAllSocialProfileXML";

		_methodParameterTypes92 = new String[] {
				"long", "javax.portlet.ResourceRequest"
			};

		_methodName93 = "refreshSocialProfileXML";

		_methodParameterTypes93 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long",
				"javax.portlet.ResourceRequest"
			};

		_methodName94 = "addAddress";

		_methodParameterTypes94 = new String[] { "java.lang.String" };

		_methodName95 = "getAddress";

		_methodParameterTypes95 = new String[] { "java.lang.String" };

		_methodName96 = "getAssetCategories";

		_methodParameterTypes96 = new String[] { "long", "long" };

		_methodName97 = "addAsMentor";

		_methodParameterTypes97 = new String[] {
				"com.liferay.portal.model.User",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName98 = "addAssetVocabulary";

		_methodParameterTypes98 = new String[] {
				"long", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName99 = "findByTwitterId";

		_methodParameterTypes99 = new String[] { "long", "java.lang.String" };

		_methodName100 = "findByLinkedinId";

		_methodParameterTypes100 = new String[] { "long", "java.lang.String" };

		_methodName101 = "findByYahooId";

		_methodParameterTypes101 = new String[] { "long", "java.lang.String" };

		_methodName102 = "findByGoogleId";

		_methodParameterTypes102 = new String[] { "long", "java.lang.String" };

		_methodName103 = "fetchSocialProfileDBColNames";

		_methodParameterTypes103 = new String[] {  };

		_methodName104 = "addUserPlatform";

		_methodParameterTypes104 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName105 = "sendPasswordEmail";

		_methodParameterTypes105 = new String[] {
				"com.liferay.portal.model.User", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName106 = "sendWelcomeEmail";

		_methodParameterTypes106 = new String[] {
				"com.liferay.portal.model.User",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName107 = "updateProfileType";

		_methodParameterTypes107 = new String[] {
				"com.liferay.portal.model.User",
				"com.sambaash.platform.model.ProfileType",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName108 = "addAssetCategory";

		_methodParameterTypes108 = new String[] {
				"long", "long", "java.lang.String", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName109 = "getIndexableFieldsMap";

		_methodParameterTypes109 = new String[] { "long" };

		_methodName110 = "getProfileFields";

		_methodParameterTypes110 = new String[] { "java.lang.String" };

		_methodName111 = "EducationStringValue";

		_methodParameterTypes111 = new String[] { "java.lang.String" };

		_methodName112 = "EmploymentStatusValue";

		_methodParameterTypes112 = new String[] { "java.lang.String" };

		_methodName113 = "mergeFormJsonToProfile";

		_methodParameterTypes113 = new String[] {
				"java.lang.String", "long", "long"
			};

		_methodName114 = "addOrUpdateDynamicSectionWithFormData";

		_methodParameterTypes114 = new String[] {
				"java.lang.String", "java.lang.String",
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"long", "java.util.Map", "java.lang.String"
			};

		_methodName115 = "saveProfileInfo";

		_methodParameterTypes115 = new String[] {
				"java.lang.String", "java.lang.String",
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"com.liferay.portal.model.User", "long"
			};

		_methodName116 = "getAssetTags";

		_methodParameterTypes116 = new String[] { "java.lang.String" };

		_methodName117 = "getFormFieldValue";

		_methodParameterTypes117 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName118 = "getUsersList";

		_methodParameterTypes118 = new String[] { "long", "int", "int" };
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile addSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName0,
					_methodParameterTypes0,
					new Object[] { ClpSerializer.translateInput(socialProfile) });
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

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile createSocialProfile(
		long userId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName1,
					_methodParameterTypes1, new Object[] { userId });
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

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile deleteSocialProfile(
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName2,
					_methodParameterTypes2, new Object[] { userId });
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

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile deleteSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] { ClpSerializer.translateInput(socialProfile) });
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

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
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
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchSocialProfile(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName10,
					_methodParameterTypes10, new Object[] { userId });
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

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchSocialProfileByUuidAndCompanyId(
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

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile fetchSocialProfileByUuidAndGroupId(
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

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile getSocialProfile(
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName13,
					_methodParameterTypes13, new Object[] { userId });
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

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
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
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile getSocialProfileByUuidAndCompanyId(
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

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile getSocialProfileByUuidAndGroupId(
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

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> getSocialProfiles(
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

		return (java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int getSocialProfilesCount()
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
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile updateSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName19,
					_methodParameterTypes19,
					new Object[] { ClpSerializer.translateInput(socialProfile) });
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

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
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
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findBymemberPackageId(
		java.lang.String memberPackage)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName23,
					_methodParameterTypes23,
					new Object[] { ClpSerializer.translateInput(memberPackage) });
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

		return (java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getIndProfilePublicUrl(long companyId,
		long scopeGroupId, long userId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName24,
					_methodParameterTypes24,
					new Object[] { companyId, scopeGroupId, userId });
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
	public java.lang.String getIndProfilePrivateUrl(long companyId,
		long scopeGroupId, long userId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName25,
					_methodParameterTypes25,
					new Object[] { companyId, scopeGroupId, userId });
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
	public java.lang.String getIndProfileLandingUrl(long companyId,
		long scopeGroupId, long userId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName26,
					_methodParameterTypes26,
					new Object[] { companyId, scopeGroupId, userId });
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
	public java.lang.String getCorpProfilePublicUrl(long companyId,
		long scopeGroupId, long userId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName27,
					_methodParameterTypes27,
					new Object[] { companyId, scopeGroupId, userId });
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
	public java.lang.String getCorpProfilePrivateUrl(long companyId,
		long scopeGroupId, java.lang.String userId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName28,
					_methodParameterTypes28,
					new Object[] {
						companyId,
						
					scopeGroupId,
						
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
	public java.lang.String getCorpProfileLandingUrl(long companyId,
		long scopeGroupId, java.lang.String userId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName29,
					_methodParameterTypes29,
					new Object[] {
						companyId,
						
					scopeGroupId,
						
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
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile addSocialProfileForIndividualUser(
		long userId, java.lang.String emailAddress, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName30,
					_methodParameterTypes30,
					new Object[] {
						userId,
						
					ClpSerializer.translateInput(emailAddress),
						
					companyId
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

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile addSocialProfileForCorporate(
		long userId, java.lang.String emailAddress, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName31,
					_methodParameterTypes31,
					new Object[] {
						userId,
						
					ClpSerializer.translateInput(emailAddress),
						
					companyId
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

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int incrementProfileViewCount(long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName32,
					_methodParameterTypes32, new Object[] { userId, companyId });
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
	public int getProfileViewCount(long userId, long companyId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName33,
					_methodParameterTypes33, new Object[] { userId, companyId });
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
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByuserIdCompIdAndRegStatus(
		long userId, long companyId, java.lang.String userRegistrationStatus) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName34,
					_methodParameterTypes34,
					new Object[] {
						userId,
						
					companyId,
						
					ClpSerializer.translateInput(userRegistrationStatus)
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

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public boolean isIndividualUser(long userId, long companyId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName35,
					_methodParameterTypes35, new Object[] { userId, companyId });
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
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile updateSocialProfileAndTags(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profile,
		java.lang.String[] assetTagNames, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName36,
					_methodParameterTypes36,
					new Object[] {
						ClpSerializer.translateInput(profile),
						
					ClpSerializer.translateInput(assetTagNames),
						
					groupId
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

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getUserScreenName(long userId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName37,
					_methodParameterTypes37, new Object[] { userId });
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
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile getSocialProfile(
		long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName38,
					_methodParameterTypes38, new Object[] { userId, companyId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException) {
				throw (com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void reIndex(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profile)
		throws com.liferay.portal.kernel.search.SearchException {
		try {
			_invokableLocalService.invokeMethod(_methodName39,
				_methodParameterTypes39,
				new Object[] { ClpSerializer.translateInput(profile) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.search.SearchException) {
				throw (com.liferay.portal.kernel.search.SearchException)t;
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
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile updateSocialProfile_No_Indexing(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profile)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName40,
					_methodParameterTypes40,
					new Object[] { ClpSerializer.translateInput(profile) });
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

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portlet.asset.model.AssetEntry addOrUpdateAsset(
		long userId, long groupId,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profile,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		boolean visible)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName41,
					_methodParameterTypes41,
					new Object[] {
						userId,
						
					groupId,
						
					ClpSerializer.translateInput(profile),
						
					ClpSerializer.translateInput(assetCategoryIds),
						
					ClpSerializer.translateInput(assetTagNames),
						
					visible
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

		return (com.liferay.portlet.asset.model.AssetEntry)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile addOrUpdateSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		com.liferay.portal.model.User user, boolean booleanMerge,
		long scopeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName42,
					_methodParameterTypes42,
					new Object[] {
						ClpSerializer.translateInput(socialProfile),
						
					ClpSerializer.translateInput(user),
						
					booleanMerge,
						
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

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile addOrUpdateSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		com.liferay.portal.model.User user, boolean booleanMerge,
		long scopeGroupId, boolean fromListener)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName43,
					_methodParameterTypes43,
					new Object[] {
						ClpSerializer.translateInput(socialProfile),
						
					ClpSerializer.translateInput(user),
						
					booleanMerge,
						
					scopeGroupId,
						
					fromListener
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

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void updateBirthday(com.liferay.portal.model.User user,
		java.util.Date birthday)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName44,
				_methodParameterTypes44,
				new Object[] {
					ClpSerializer.translateInput(user),
					
				ClpSerializer.translateInput(birthday)
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
	}

	@Override
	public void updateGender(com.liferay.portal.model.User user,
		java.lang.String gender)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName45,
				_methodParameterTypes45,
				new Object[] {
					ClpSerializer.translateInput(user),
					
				ClpSerializer.translateInput(gender)
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
	}

	@Override
	public java.lang.String updateSingleNodeField(java.lang.String xml,
		java.lang.String nodeToUpdate, java.lang.String val)
		throws java.lang.Exception {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName46,
					_methodParameterTypes46,
					new Object[] {
						ClpSerializer.translateInput(xml),
						
					ClpSerializer.translateInput(nodeToUpdate),
						
					ClpSerializer.translateInput(val)
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int deleteXMLInstance(java.lang.String categoryName,
		java.lang.String categoryDetails, java.lang.String instance,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName47,
					_methodParameterTypes47,
					new Object[] {
						ClpSerializer.translateInput(categoryName),
						
					ClpSerializer.translateInput(categoryDetails),
						
					ClpSerializer.translateInput(instance),
						
					ClpSerializer.translateInput(profileUser)
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
	public void deleteAllWorkHistory(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser) {
		try {
			_invokableLocalService.invokeMethod(_methodName48,
				_methodParameterTypes48,
				new Object[] { ClpSerializer.translateInput(profileUser) });
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
	public void addOrUpdateWorkHistory(java.lang.String categoryName,
		java.lang.String categoryDetails, java.lang.String instance,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		long scopeGroupId,
		java.util.Map<java.lang.String, java.lang.String> details) {
		try {
			_invokableLocalService.invokeMethod(_methodName49,
				_methodParameterTypes49,
				new Object[] {
					ClpSerializer.translateInput(categoryName),
					
				ClpSerializer.translateInput(categoryDetails),
					
				ClpSerializer.translateInput(instance),
					
				ClpSerializer.translateInput(profileUser),
					
				scopeGroupId,
					
				ClpSerializer.translateInput(details)
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
	public void addOrUpdateWorkHistoryFromFormData(
		java.lang.String categoryName, java.lang.String categoryDetails,
		java.lang.String instance,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		long scopeGroupId,
		java.util.Map<java.lang.String, java.lang.String> details) {
		try {
			_invokableLocalService.invokeMethod(_methodName50,
				_methodParameterTypes50,
				new Object[] {
					ClpSerializer.translateInput(categoryName),
					
				ClpSerializer.translateInput(categoryDetails),
					
				ClpSerializer.translateInput(instance),
					
				ClpSerializer.translateInput(profileUser),
					
				scopeGroupId,
					
				ClpSerializer.translateInput(details)
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
	public com.liferay.portal.kernel.json.JSONObject getUserWorkHistoryDetails(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName51,
					_methodParameterTypes51,
					new Object[] { ClpSerializer.translateInput(profileUser) });
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
	public com.liferay.portal.kernel.json.JSONObject getUserTransactionHistoryDetails(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		java.lang.String formName, java.lang.String formTagName,
		java.lang.String[] formFields) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName52,
					_methodParameterTypes52,
					new Object[] {
						ClpSerializer.translateInput(profileUser),
						
					ClpSerializer.translateInput(formName),
						
					ClpSerializer.translateInput(formTagName),
						
					ClpSerializer.translateInput(formFields)
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

		return (com.liferay.portal.kernel.json.JSONObject)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile addNetworkInfo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.lang.String categoryName, java.lang.String categoryDetail,
		java.lang.String value) throws java.lang.Exception {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName53,
					_methodParameterTypes53,
					new Object[] {
						ClpSerializer.translateInput(socialProfile),
						
					ClpSerializer.translateInput(categoryName),
						
					ClpSerializer.translateInput(categoryDetail),
						
					ClpSerializer.translateInput(value)
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

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void addOrUpdateAvailability(java.lang.String categoryName,
		java.lang.String categoryDetails, java.lang.String instance,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		long groupId, java.util.Map<java.lang.String, java.lang.String> details) {
		try {
			_invokableLocalService.invokeMethod(_methodName54,
				_methodParameterTypes54,
				new Object[] {
					ClpSerializer.translateInput(categoryName),
					
				ClpSerializer.translateInput(categoryDetails),
					
				ClpSerializer.translateInput(instance),
					
				ClpSerializer.translateInput(profileUser),
					
				groupId,
					
				ClpSerializer.translateInput(details)
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
	public void addOrUpdateDynamicSection(java.lang.String categoryName,
		java.lang.String categoryDetails, java.lang.String instance,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		long groupId, java.util.Map<java.lang.String, java.lang.String> details) {
		try {
			_invokableLocalService.invokeMethod(_methodName55,
				_methodParameterTypes55,
				new Object[] {
					ClpSerializer.translateInput(categoryName),
					
				ClpSerializer.translateInput(categoryDetails),
					
				ClpSerializer.translateInput(instance),
					
				ClpSerializer.translateInput(profileUser),
					
				groupId,
					
				ClpSerializer.translateInput(details)
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
	public void addOrUpdateDynamicSection(java.lang.String categoryName,
		java.lang.String categoryDetails,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		long groupId, java.util.Map<java.lang.String, java.lang.String> details) {
		try {
			_invokableLocalService.invokeMethod(_methodName56,
				_methodParameterTypes56,
				new Object[] {
					ClpSerializer.translateInput(categoryName),
					
				ClpSerializer.translateInput(categoryDetails),
					
				ClpSerializer.translateInput(profileUser),
					
				groupId,
					
				ClpSerializer.translateInput(details)
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
	public com.liferay.portal.model.User updateUser(
		com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName57,
					_methodParameterTypes57,
					new Object[] { ClpSerializer.translateInput(user) });
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

		return (com.liferay.portal.model.User)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void updateUserScreenName(long userId, java.lang.String newScreenName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName58,
				_methodParameterTypes58,
				new Object[] { userId, ClpSerializer.translateInput(
						newScreenName) });
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
	public java.util.List<com.liferay.portal.model.Website> getUserWebSites(
		long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName59,
					_methodParameterTypes59, new Object[] { userId, companyId });
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

		return (java.util.List<com.liferay.portal.model.Website>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.liferay.portal.model.Phone> getUserPhoneList(
		long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName60,
					_methodParameterTypes60, new Object[] { userId, companyId });
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

		return (java.util.List<com.liferay.portal.model.Phone>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.liferay.portal.model.Contact> getContacts(
		long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName61,
					_methodParameterTypes61, new Object[] { userId, companyId });
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

		return (java.util.List<com.liferay.portal.model.Contact>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.liferay.portal.model.EmailAddress> getUserEmailAddressList(
		long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName62,
					_methodParameterTypes62, new Object[] { userId, companyId });
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

		return (java.util.List<com.liferay.portal.model.EmailAddress>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.liferay.portal.model.Address> getUserAddresses(
		long userId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName63,
					_methodParameterTypes63, new Object[] { userId, companyId });
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

		return (java.util.List<com.liferay.portal.model.Address>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void updateWebsites(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.Website> websites)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName64,
				_methodParameterTypes64,
				new Object[] {
					ClpSerializer.translateInput(socialProfile),
					
				ClpSerializer.translateInput(websites)
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
	}

	@Override
	public void updateContactInfo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.Phone> phoneNumbers)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName65,
				_methodParameterTypes65,
				new Object[] {
					ClpSerializer.translateInput(socialProfile),
					
				ClpSerializer.translateInput(phoneNumbers)
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
	}

	@Override
	public void updateNetworkInfo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.Contact> contactList)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName66,
				_methodParameterTypes66,
				new Object[] {
					ClpSerializer.translateInput(socialProfile),
					
				ClpSerializer.translateInput(contactList)
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
	}

	@Override
	public void updateEmailAddresses(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.EmailAddress> emailAddresses)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName67,
				_methodParameterTypes67,
				new Object[] {
					ClpSerializer.translateInput(socialProfile),
					
				ClpSerializer.translateInput(emailAddresses)
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
	}

	@Override
	public void updateAddress(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.Address> addresses)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName68,
				_methodParameterTypes68,
				new Object[] {
					ClpSerializer.translateInput(socialProfile),
					
				ClpSerializer.translateInput(addresses)
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
	}

	@Override
	public void updateMobileNo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.Phone> phoneNumbers)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName69,
				_methodParameterTypes69,
				new Object[] {
					ClpSerializer.translateInput(socialProfile),
					
				ClpSerializer.translateInput(phoneNumbers)
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
	}

	@Override
	public void updateLocationAndMobileNo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		java.util.List<com.liferay.portal.model.Phone> phoneNumbers)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName70,
				_methodParameterTypes70,
				new Object[] {
					ClpSerializer.translateInput(socialProfile),
					
				ClpSerializer.translateInput(phoneNumbers)
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
	}

	@Override
	public void updateXMLFromSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName71,
				_methodParameterTypes71,
				new Object[] { ClpSerializer.translateInput(socialProfile) });
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
	}

	@Override
	public void updatePersonalInfoWhenReg(com.liferay.portal.model.User user,
		com.liferay.portal.kernel.json.JSONObject extraFieldsJSONObject)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName72,
				_methodParameterTypes72,
				new Object[] {
					ClpSerializer.translateInput(user),
					
				ClpSerializer.translateInput(extraFieldsJSONObject)
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
	}

	@Override
	public void updatePersonalInfo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName73,
				_methodParameterTypes73,
				new Object[] {
					ClpSerializer.translateInput(socialProfile),
					
				ClpSerializer.translateInput(user)
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
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile transformSocialProfileXML(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile,
		com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName74,
					_methodParameterTypes74,
					new Object[] {
						ClpSerializer.translateInput(socialProfile),
						
					ClpSerializer.translateInput(user)
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

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void saveContactInfoXMLData(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		java.lang.String sData, java.lang.String categoryName) {
		try {
			_invokableLocalService.invokeMethod(_methodName75,
				_methodParameterTypes75,
				new Object[] {
					ClpSerializer.translateInput(profileUser),
					
				ClpSerializer.translateInput(sData),
					
				ClpSerializer.translateInput(categoryName)
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
	public com.liferay.portal.model.Contact updateUserNetworkInfoFromSocialProfile(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName76,
					_methodParameterTypes76,
					new Object[] { ClpSerializer.translateInput(socialProfile) });
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

		return (com.liferay.portal.model.Contact)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void addSocialProfileDetail(java.lang.String companyName,
		java.lang.String jobId, long userId, java.lang.String projectList) {
		try {
			_invokableLocalService.invokeMethod(_methodName77,
				_methodParameterTypes77,
				new Object[] {
					ClpSerializer.translateInput(companyName),
					
				ClpSerializer.translateInput(jobId),
					
				userId,
					
				ClpSerializer.translateInput(projectList)
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
	public java.lang.String getExpertiseTags() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName78,
					_methodParameterTypes78, new Object[] {  });
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
	public java.lang.String getExpertiseTags(long userId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName79,
					_methodParameterTypes79, new Object[] { userId });
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
	public java.lang.String getProfileCompletion(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName80,
					_methodParameterTypes80,
					new Object[] { ClpSerializer.translateInput(profileUser) });
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
	public void saveAvailabilityInfo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser) {
		try {
			_invokableLocalService.invokeMethod(_methodName81,
				_methodParameterTypes81,
				new Object[] { ClpSerializer.translateInput(profileUser) });
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
	public void saveWorkHistorySorted(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		java.lang.String sortedXml) {
		try {
			_invokableLocalService.invokeMethod(_methodName82,
				_methodParameterTypes82,
				new Object[] {
					ClpSerializer.translateInput(profileUser),
					
				ClpSerializer.translateInput(sortedXml)
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
	public void updateSPParameter(java.lang.String key, long groupId,
		java.lang.String value, java.lang.String description) {
		try {
			_invokableLocalService.invokeMethod(_methodName83,
				_methodParameterTypes83,
				new Object[] {
					ClpSerializer.translateInput(key),
					
				groupId,
					
				ClpSerializer.translateInput(value),
					
				ClpSerializer.translateInput(description)
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
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUserTypeAndRegStatus(
		java.lang.String userType, java.lang.String userRegistrationStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName84,
					_methodParameterTypes84,
					new Object[] {
						ClpSerializer.translateInput(userType),
						
					ClpSerializer.translateInput(userRegistrationStatus)
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

		return (java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUserTypeAndRegStatus(
		java.lang.String userType, java.lang.String userRegistrationStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName85,
					_methodParameterTypes85,
					new Object[] {
						ClpSerializer.translateInput(userType),
						
					ClpSerializer.translateInput(userRegistrationStatus),
						
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

		return (java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByUserTypeAndRegStatus(
		java.lang.String userType, java.lang.String userRegistrationStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName86,
					_methodParameterTypes86,
					new Object[] {
						ClpSerializer.translateInput(userType),
						
					ClpSerializer.translateInput(userRegistrationStatus),
						
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

		return (java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> findByU1_S1_S_E(
		java.lang.String userRegistrationStatus, boolean active, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName87,
					_methodParameterTypes87,
					new Object[] {
						ClpSerializer.translateInput(userRegistrationStatus),
						
					active,
						
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

		return (java.util.List<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getFieldValue(long userId, java.lang.String xml,
		java.lang.String fieldName) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName88,
					_methodParameterTypes88,
					new Object[] {
						userId,
						
					ClpSerializer.translateInput(xml),
						
					ClpSerializer.translateInput(fieldName)
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
	public java.lang.String findSocialProfileLocation()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName89,
					_methodParameterTypes89, new Object[] {  });
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void addOrUpdateProfileSPListTypes(java.lang.String key,
		java.lang.String[] arrSPList, long scopeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName90,
				_methodParameterTypes90,
				new Object[] {
					ClpSerializer.translateInput(key),
					
				ClpSerializer.translateInput(arrSPList),
					
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
	}

	@Override
	public void updateWorkHistoryRelatedProjects(java.lang.String companyName,
		java.lang.String companyId, long userId, java.lang.String url,
		java.lang.String addOrDelete, int start) {
		try {
			_invokableLocalService.invokeMethod(_methodName91,
				_methodParameterTypes91,
				new Object[] {
					ClpSerializer.translateInput(companyName),
					
				ClpSerializer.translateInput(companyId),
					
				userId,
					
				ClpSerializer.translateInput(url),
					
				ClpSerializer.translateInput(addOrDelete),
					
				start
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
	public void refreshAllSocialProfileXML(long scopeGroupId,
		javax.portlet.ResourceRequest request) {
		try {
			_invokableLocalService.invokeMethod(_methodName92,
				_methodParameterTypes92,
				new Object[] { scopeGroupId, ClpSerializer.translateInput(
						request) });
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
	public void refreshSocialProfileXML(java.lang.String category,
		java.lang.String categoryDetails, long scopeGroupId, long userId,
		javax.portlet.ResourceRequest request) {
		try {
			_invokableLocalService.invokeMethod(_methodName93,
				_methodParameterTypes93,
				new Object[] {
					ClpSerializer.translateInput(category),
					
				ClpSerializer.translateInput(categoryDetails),
					
				scopeGroupId,
					
				userId,
					
				ClpSerializer.translateInput(request)
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
	public java.lang.String addAddress(java.lang.String addressXml) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName94,
					_methodParameterTypes94,
					new Object[] { ClpSerializer.translateInput(addressXml) });
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
	public java.lang.String getAddress(java.lang.String emailAddress) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName95,
					_methodParameterTypes95,
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.liferay.portlet.asset.model.AssetCategory> getAssetCategories(
		long scopeGroupId, long vocabularyId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName96,
					_methodParameterTypes96,
					new Object[] { scopeGroupId, vocabularyId });
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

		return (java.util.List<com.liferay.portlet.asset.model.AssetCategory>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void addAsMentor(com.liferay.portal.model.User user,
		com.liferay.portal.service.ServiceContext serviceContext) {
		try {
			_invokableLocalService.invokeMethod(_methodName97,
				_methodParameterTypes97,
				new Object[] {
					ClpSerializer.translateInput(user),
					
				ClpSerializer.translateInput(serviceContext)
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
	public com.liferay.portlet.asset.model.AssetVocabulary addAssetVocabulary(
		long userId, java.lang.String title,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName98,
					_methodParameterTypes98,
					new Object[] {
						userId,
						
					ClpSerializer.translateInput(title),
						
					ClpSerializer.translateInput(serviceContext)
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

		return (com.liferay.portlet.asset.model.AssetVocabulary)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByTwitterId(
		long companyId, java.lang.String twitterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName99,
					_methodParameterTypes99,
					new Object[] {
						companyId,
						
					ClpSerializer.translateInput(twitterId)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException) {
				throw (com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByLinkedinId(
		long companyId, java.lang.String linkedinId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName100,
					_methodParameterTypes100,
					new Object[] {
						companyId,
						
					ClpSerializer.translateInput(linkedinId)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException) {
				throw (com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByYahooId(
		long companyId, java.lang.String yahooId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName101,
					_methodParameterTypes101,
					new Object[] {
						companyId,
						
					ClpSerializer.translateInput(yahooId)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException) {
				throw (com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile findByGoogleId(
		long companyId, java.lang.String googleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName102,
					_methodParameterTypes102,
					new Object[] {
						companyId,
						
					ClpSerializer.translateInput(googleId)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException) {
				throw (com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.ArrayList<java.lang.String> fetchSocialProfileDBColNames() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName103,
					_methodParameterTypes103, new Object[] {  });
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

		return (java.util.ArrayList<java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.model.User addUserPlatform(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String emailAddress, java.lang.String password,
		boolean passwordEmail,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName104,
					_methodParameterTypes104,
					new Object[] {
						ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(emailAddress),
						
					ClpSerializer.translateInput(password),
						
					passwordEmail,
						
					ClpSerializer.translateInput(serviceContext)
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
	public void sendPasswordEmail(com.liferay.portal.model.User user,
		java.lang.String password,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName105,
				_methodParameterTypes105,
				new Object[] {
					ClpSerializer.translateInput(user),
					
				ClpSerializer.translateInput(password),
					
				ClpSerializer.translateInput(serviceContext)
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
	}

	@Override
	public void sendWelcomeEmail(com.liferay.portal.model.User user,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName106,
				_methodParameterTypes106,
				new Object[] {
					ClpSerializer.translateInput(user),
					
				ClpSerializer.translateInput(serviceContext)
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
	}

	@Override
	public void updateProfileType(com.liferay.portal.model.User user,
		com.sambaash.platform.model.ProfileType profileType,
		com.liferay.portal.service.ServiceContext serviceContext) {
		try {
			_invokableLocalService.invokeMethod(_methodName107,
				_methodParameterTypes107,
				new Object[] {
					ClpSerializer.translateInput(user),
					
				ClpSerializer.translateInput(profileType),
					
				ClpSerializer.translateInput(serviceContext)
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
	public com.liferay.portlet.asset.model.AssetCategory addAssetCategory(
		long userId, long parentCategoryId, java.lang.String title,
		long vocabularyId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName108,
					_methodParameterTypes108,
					new Object[] {
						userId,
						
					parentCategoryId,
						
					ClpSerializer.translateInput(title),
						
					vocabularyId,
						
					ClpSerializer.translateInput(serviceContext)
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

		return (com.liferay.portlet.asset.model.AssetCategory)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getIndexableFieldsMap(
		long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName109,
					_methodParameterTypes109, new Object[] { companyId });
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

		return (java.util.Map<java.lang.String, java.util.List<java.lang.String>>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public org.w3c.dom.NodeList getProfileFields(java.lang.String userId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName110,
					_methodParameterTypes110,
					new Object[] { ClpSerializer.translateInput(userId) });
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

		return (org.w3c.dom.NodeList)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String EducationStringValue(java.lang.String i) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName111,
					_methodParameterTypes111,
					new Object[] { ClpSerializer.translateInput(i) });
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
	public java.lang.String EmploymentStatusValue(java.lang.String i) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName112,
					_methodParameterTypes112,
					new Object[] { ClpSerializer.translateInput(i) });
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
	public void mergeFormJsonToProfile(java.lang.String jsonArrStr,
		long companyId, long groupId) {
		try {
			_invokableLocalService.invokeMethod(_methodName113,
				_methodParameterTypes113,
				new Object[] {
					ClpSerializer.translateInput(jsonArrStr),
					
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
	public void addOrUpdateDynamicSectionWithFormData(
		java.lang.String categoryName, java.lang.String categoryDetails,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		long groupId,
		java.util.Map<java.lang.String, java.lang.String> details,
		java.lang.String instance1) {
		try {
			_invokableLocalService.invokeMethod(_methodName114,
				_methodParameterTypes114,
				new Object[] {
					ClpSerializer.translateInput(categoryName),
					
				ClpSerializer.translateInput(categoryDetails),
					
				ClpSerializer.translateInput(profileUser),
					
				groupId,
					
				ClpSerializer.translateInput(details),
					
				ClpSerializer.translateInput(instance1)
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
	public java.lang.String saveProfileInfo(java.lang.String fieldName,
		java.lang.String value,
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile profileUser,
		com.liferay.portal.model.User user, long scopeGroupId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName115,
					_methodParameterTypes115,
					new Object[] {
						ClpSerializer.translateInput(fieldName),
						
					ClpSerializer.translateInput(value),
						
					ClpSerializer.translateInput(profileUser),
						
					ClpSerializer.translateInput(user),
						
					scopeGroupId
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
	public java.lang.String[] getAssetTags(java.lang.String expertise) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName116,
					_methodParameterTypes116,
					new Object[] { ClpSerializer.translateInput(expertise) });
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

		return (java.lang.String[])ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getFormFieldValue(long userId,
		java.lang.String formName, java.lang.String fieldName) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName117,
					_methodParameterTypes117,
					new Object[] {
						userId,
						
					ClpSerializer.translateInput(formName),
						
					ClpSerializer.translateInput(fieldName)
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
	public java.util.List<com.liferay.portal.model.User> getUsersList(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName118,
					_methodParameterTypes118,
					new Object[] { companyId, start, end });
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

		return (java.util.List<com.liferay.portal.model.User>)ClpSerializer.translateOutput(returnObj);
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
	private String _methodName113;
	private String[] _methodParameterTypes113;
	private String _methodName114;
	private String[] _methodParameterTypes114;
	private String _methodName115;
	private String[] _methodParameterTypes115;
	private String _methodName116;
	private String[] _methodParameterTypes116;
	private String _methodName117;
	private String[] _methodParameterTypes117;
	private String _methodName118;
	private String[] _methodParameterTypes118;
}