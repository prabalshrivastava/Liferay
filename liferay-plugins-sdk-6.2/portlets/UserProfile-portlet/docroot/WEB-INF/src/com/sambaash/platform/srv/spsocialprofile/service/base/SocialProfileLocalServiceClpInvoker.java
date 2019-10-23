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

package com.sambaash.platform.srv.spsocialprofile.service.base;

import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;

import java.util.Arrays;

/**
 * @author gauravvijayvergia
 * @generated
 */
public class SocialProfileLocalServiceClpInvoker {
	public SocialProfileLocalServiceClpInvoker() {
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

		_methodName74 = "getBeanIdentifier";

		_methodParameterTypes74 = new String[] {  };

		_methodName75 = "setBeanIdentifier";

		_methodParameterTypes75 = new String[] { "java.lang.String" };

		_methodName80 = "findBymemberPackageId";

		_methodParameterTypes80 = new String[] { "java.lang.String" };

		_methodName81 = "getIndProfilePublicUrl";

		_methodParameterTypes81 = new String[] { "long", "long", "long" };

		_methodName82 = "getIndProfilePrivateUrl";

		_methodParameterTypes82 = new String[] { "long", "long", "long" };

		_methodName83 = "getIndProfileLandingUrl";

		_methodParameterTypes83 = new String[] { "long", "long", "long" };

		_methodName84 = "getCorpProfilePublicUrl";

		_methodParameterTypes84 = new String[] { "long", "long", "long" };

		_methodName85 = "getCorpProfilePrivateUrl";

		_methodParameterTypes85 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName86 = "getCorpProfileLandingUrl";

		_methodParameterTypes86 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName87 = "addSocialProfileForIndividualUser";

		_methodParameterTypes87 = new String[] {
				"long", "java.lang.String", "long"
			};

		_methodName88 = "addSocialProfileForCorporate";

		_methodParameterTypes88 = new String[] {
				"long", "java.lang.String", "long"
			};

		_methodName89 = "incrementProfileViewCount";

		_methodParameterTypes89 = new String[] { "long", "long" };

		_methodName90 = "getProfileViewCount";

		_methodParameterTypes90 = new String[] { "long", "long" };

		_methodName91 = "findByuserIdCompIdAndRegStatus";

		_methodParameterTypes91 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName92 = "isIndividualUser";

		_methodParameterTypes92 = new String[] { "long", "long" };

		_methodName93 = "updateSocialProfileAndTags";

		_methodParameterTypes93 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"java.lang.String[][]", "long"
			};

		_methodName94 = "getUserScreenName";

		_methodParameterTypes94 = new String[] { "long" };

		_methodName95 = "getSocialProfile";

		_methodParameterTypes95 = new String[] { "long", "long" };

		_methodName96 = "updateSocialProfile";

		_methodParameterTypes96 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName97 = "reIndex";

		_methodParameterTypes97 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName98 = "updateSocialProfile_No_Indexing";

		_methodParameterTypes98 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName99 = "addOrUpdateAsset";

		_methodParameterTypes99 = new String[] {
				"long", "long",
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"long[][]", "java.lang.String[][]", "boolean"
			};

		_methodName100 = "addOrUpdateSocialProfile";

		_methodParameterTypes100 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"com.liferay.portal.model.User", "boolean", "long"
			};

		_methodName101 = "addOrUpdateSocialProfile";

		_methodParameterTypes101 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"com.liferay.portal.model.User", "boolean", "long", "boolean"
			};

		_methodName102 = "updateBirthday";

		_methodParameterTypes102 = new String[] {
				"com.liferay.portal.model.User", "java.util.Date"
			};

		_methodName103 = "updateGender";

		_methodParameterTypes103 = new String[] {
				"com.liferay.portal.model.User", "java.lang.String"
			};

		_methodName104 = "updateSingleNodeField";

		_methodParameterTypes104 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName105 = "deleteXMLInstance";

		_methodParameterTypes105 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName106 = "deleteAllWorkHistory";

		_methodParameterTypes106 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName107 = "addOrUpdateWorkHistory";

		_methodParameterTypes107 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"long", "java.util.Map"
			};

		_methodName108 = "addOrUpdateWorkHistoryFromFormData";

		_methodParameterTypes108 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"long", "java.util.Map"
			};

		_methodName109 = "getUserWorkHistoryDetails";

		_methodParameterTypes109 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName110 = "getUserTransactionHistoryDetails";

		_methodParameterTypes110 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"java.lang.String", "java.lang.String", "java.lang.String[][]"
			};

		_methodName111 = "addNetworkInfo";

		_methodParameterTypes111 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName112 = "addOrUpdateAvailability";

		_methodParameterTypes112 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"long", "java.util.Map"
			};

		_methodName113 = "addOrUpdateDynamicSection";

		_methodParameterTypes113 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"long", "java.util.Map"
			};

		_methodName114 = "addOrUpdateDynamicSection";

		_methodParameterTypes114 = new String[] {
				"java.lang.String", "java.lang.String",
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"long", "java.util.Map"
			};

		_methodName115 = "updateUser";

		_methodParameterTypes115 = new String[] { "com.liferay.portal.model.User" };

		_methodName116 = "updateUserScreenName";

		_methodParameterTypes116 = new String[] { "long", "java.lang.String" };

		_methodName117 = "getUserWebSites";

		_methodParameterTypes117 = new String[] { "long", "long" };

		_methodName118 = "getUserPhoneList";

		_methodParameterTypes118 = new String[] { "long", "long" };

		_methodName119 = "getContacts";

		_methodParameterTypes119 = new String[] { "long", "long" };

		_methodName120 = "getUserEmailAddressList";

		_methodParameterTypes120 = new String[] { "long", "long" };

		_methodName121 = "getUserAddresses";

		_methodParameterTypes121 = new String[] { "long", "long" };

		_methodName122 = "updateWebsites";

		_methodParameterTypes122 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"java.util.List"
			};

		_methodName123 = "updateContactInfo";

		_methodParameterTypes123 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"java.util.List"
			};

		_methodName124 = "updateNetworkInfo";

		_methodParameterTypes124 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"java.util.List"
			};

		_methodName125 = "updateEmailAddresses";

		_methodParameterTypes125 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"java.util.List"
			};

		_methodName126 = "updateAddress";

		_methodParameterTypes126 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"java.util.List"
			};

		_methodName127 = "updateMobileNo";

		_methodParameterTypes127 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"java.util.List"
			};

		_methodName128 = "updateLocationAndMobileNo";

		_methodParameterTypes128 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"java.util.List"
			};

		_methodName129 = "updateXMLFromSocialProfile";

		_methodParameterTypes129 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName130 = "updatePersonalInfoWhenReg";

		_methodParameterTypes130 = new String[] {
				"com.liferay.portal.model.User",
				"com.liferay.portal.kernel.json.JSONObject"
			};

		_methodName131 = "updatePersonalInfo";

		_methodParameterTypes131 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"com.liferay.portal.model.User"
			};

		_methodName132 = "transformSocialProfileXML";

		_methodParameterTypes132 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"com.liferay.portal.model.User"
			};

		_methodName133 = "saveContactInfoXMLData";

		_methodParameterTypes133 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"java.lang.String", "java.lang.String"
			};

		_methodName137 = "updateUserNetworkInfoFromSocialProfile";

		_methodParameterTypes137 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName139 = "addSocialProfileDetail";

		_methodParameterTypes139 = new String[] {
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String"
			};

		_methodName140 = "getExpertiseTags";

		_methodParameterTypes140 = new String[] {  };

		_methodName141 = "getExpertiseTags";

		_methodParameterTypes141 = new String[] { "long" };

		_methodName142 = "getProfileCompletion";

		_methodParameterTypes142 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName143 = "saveAvailabilityInfo";

		_methodParameterTypes143 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile"
			};

		_methodName144 = "saveWorkHistorySorted";

		_methodParameterTypes144 = new String[] {
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"java.lang.String"
			};

		_methodName145 = "updateSPParameter";

		_methodParameterTypes145 = new String[] {
				"java.lang.String", "long", "java.lang.String",
				"java.lang.String"
			};

		_methodName146 = "findByUserTypeAndRegStatus";

		_methodParameterTypes146 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName147 = "findByUserTypeAndRegStatus";

		_methodParameterTypes147 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName148 = "findByUserTypeAndRegStatus";

		_methodParameterTypes148 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName149 = "findByU1_S1_S_E";

		_methodParameterTypes149 = new String[] {
				"java.lang.String", "boolean", "int", "int"
			};

		_methodName150 = "getFieldValue";

		_methodParameterTypes150 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName151 = "findSocialProfileLocation";

		_methodParameterTypes151 = new String[] {  };

		_methodName152 = "addOrUpdateProfileSPListTypes";

		_methodParameterTypes152 = new String[] {
				"java.lang.String", "java.lang.String[][]", "long"
			};

		_methodName153 = "updateWorkHistoryRelatedProjects";

		_methodParameterTypes153 = new String[] {
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String", "java.lang.String", "int"
			};

		_methodName154 = "refreshAllSocialProfileXML";

		_methodParameterTypes154 = new String[] {
				"long", "javax.portlet.ResourceRequest"
			};

		_methodName155 = "refreshSocialProfileXML";

		_methodParameterTypes155 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long",
				"javax.portlet.ResourceRequest"
			};

		_methodName156 = "addAddress";

		_methodParameterTypes156 = new String[] { "java.lang.String" };

		_methodName158 = "getAddress";

		_methodParameterTypes158 = new String[] { "java.lang.String" };

		_methodName160 = "getAssetCategories";

		_methodParameterTypes160 = new String[] { "long", "long" };

		_methodName161 = "addAsMentor";

		_methodParameterTypes161 = new String[] {
				"com.liferay.portal.model.User",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName162 = "addAssetVocabulary";

		_methodParameterTypes162 = new String[] {
				"long", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName163 = "findByTwitterId";

		_methodParameterTypes163 = new String[] { "long", "java.lang.String" };

		_methodName164 = "findByLinkedinId";

		_methodParameterTypes164 = new String[] { "long", "java.lang.String" };

		_methodName165 = "findByYahooId";

		_methodParameterTypes165 = new String[] { "long", "java.lang.String" };

		_methodName166 = "findByGoogleId";

		_methodParameterTypes166 = new String[] { "long", "java.lang.String" };

		_methodName167 = "fetchSocialProfileDBColNames";

		_methodParameterTypes167 = new String[] {  };

		_methodName168 = "addUserPlatform";

		_methodParameterTypes168 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName169 = "sendPasswordEmail";

		_methodParameterTypes169 = new String[] {
				"com.liferay.portal.model.User", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName170 = "sendWelcomeEmail";

		_methodParameterTypes170 = new String[] {
				"com.liferay.portal.model.User",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName172 = "updateProfileType";

		_methodParameterTypes172 = new String[] {
				"com.liferay.portal.model.User",
				"com.sambaash.platform.model.ProfileType",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName174 = "addAssetCategory";

		_methodParameterTypes174 = new String[] {
				"long", "long", "java.lang.String", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName175 = "getIndexableFieldsMap";

		_methodParameterTypes175 = new String[] { "long" };

		_methodName176 = "getProfileFields";

		_methodParameterTypes176 = new String[] { "java.lang.String" };

		_methodName177 = "EducationStringValue";

		_methodParameterTypes177 = new String[] { "java.lang.String" };

		_methodName178 = "EmploymentStatusValue";

		_methodParameterTypes178 = new String[] { "java.lang.String" };

		_methodName179 = "mergeFormJsonToProfile";

		_methodParameterTypes179 = new String[] {
				"java.lang.String", "long", "long"
			};

		_methodName181 = "addOrUpdateDynamicSectionWithFormData";

		_methodParameterTypes181 = new String[] {
				"java.lang.String", "java.lang.String",
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"long", "java.util.Map", "java.lang.String"
			};

		_methodName182 = "saveProfileInfo";

		_methodParameterTypes182 = new String[] {
				"java.lang.String", "java.lang.String",
				"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile",
				"com.liferay.portal.model.User", "long"
			};

		_methodName183 = "getAssetTags";

		_methodParameterTypes183 = new String[] { "java.lang.String" };

		_methodName184 = "getFormFieldValue";

		_methodParameterTypes184 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName185 = "getUsersList";

		_methodParameterTypes185 = new String[] { "long", "int", "int" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return SocialProfileLocalServiceUtil.addSocialProfile((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return SocialProfileLocalServiceUtil.createSocialProfile(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return SocialProfileLocalServiceUtil.deleteSocialProfile(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return SocialProfileLocalServiceUtil.deleteSocialProfile((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return SocialProfileLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return SocialProfileLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return SocialProfileLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return SocialProfileLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return SocialProfileLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return SocialProfileLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return SocialProfileLocalServiceUtil.fetchSocialProfile(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return SocialProfileLocalServiceUtil.fetchSocialProfileByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return SocialProfileLocalServiceUtil.fetchSocialProfileByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getSocialProfile(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getSocialProfileByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getSocialProfileByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getSocialProfiles(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getSocialProfilesCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return SocialProfileLocalServiceUtil.updateSocialProfile((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0]);
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			SocialProfileLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return SocialProfileLocalServiceUtil.findBymemberPackageId((java.lang.String)arguments[0]);
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getIndProfilePublicUrl(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getIndProfilePrivateUrl(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getIndProfileLandingUrl(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getCorpProfilePublicUrl(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getCorpProfilePrivateUrl(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getCorpProfileLandingUrl(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return SocialProfileLocalServiceUtil.addSocialProfileForIndividualUser(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return SocialProfileLocalServiceUtil.addSocialProfileForCorporate(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			return SocialProfileLocalServiceUtil.incrementProfileViewCount(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getProfileViewCount(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			return SocialProfileLocalServiceUtil.findByuserIdCompIdAndRegStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			return SocialProfileLocalServiceUtil.isIndividualUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName93.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
			return SocialProfileLocalServiceUtil.updateSocialProfileAndTags((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0],
				(java.lang.String[])arguments[1],
				((Long)arguments[2]).longValue());
		}

		if (_methodName94.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getUserScreenName(((Long)arguments[0]).longValue());
		}

		if (_methodName95.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getSocialProfile(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName96.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes96, parameterTypes)) {
			return SocialProfileLocalServiceUtil.updateSocialProfile((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0]);
		}

		if (_methodName97.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes97, parameterTypes)) {
			SocialProfileLocalServiceUtil.reIndex((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0]);

			return null;
		}

		if (_methodName98.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
			return SocialProfileLocalServiceUtil.updateSocialProfile_No_Indexing((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0]);
		}

		if (_methodName99.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes99, parameterTypes)) {
			return SocialProfileLocalServiceUtil.addOrUpdateAsset(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[2],
				(long[])arguments[3], (java.lang.String[])arguments[4],
				((Boolean)arguments[5]).booleanValue());
		}

		if (_methodName100.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes100, parameterTypes)) {
			return SocialProfileLocalServiceUtil.addOrUpdateSocialProfile((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0],
				(com.liferay.portal.model.User)arguments[1],
				((Boolean)arguments[2]).booleanValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName101.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes101, parameterTypes)) {
			return SocialProfileLocalServiceUtil.addOrUpdateSocialProfile((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0],
				(com.liferay.portal.model.User)arguments[1],
				((Boolean)arguments[2]).booleanValue(),
				((Long)arguments[3]).longValue(),
				((Boolean)arguments[4]).booleanValue());
		}

		if (_methodName102.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes102, parameterTypes)) {
			SocialProfileLocalServiceUtil.updateBirthday((com.liferay.portal.model.User)arguments[0],
				(java.util.Date)arguments[1]);

			return null;
		}

		if (_methodName103.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes103, parameterTypes)) {
			SocialProfileLocalServiceUtil.updateGender((com.liferay.portal.model.User)arguments[0],
				(java.lang.String)arguments[1]);

			return null;
		}

		if (_methodName104.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes104, parameterTypes)) {
			return SocialProfileLocalServiceUtil.updateSingleNodeField((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName105.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes105, parameterTypes)) {
			return SocialProfileLocalServiceUtil.deleteXMLInstance((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[3]);
		}

		if (_methodName106.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes106, parameterTypes)) {
			SocialProfileLocalServiceUtil.deleteAllWorkHistory((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0]);

			return null;
		}

		if (_methodName107.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes107, parameterTypes)) {
			SocialProfileLocalServiceUtil.addOrUpdateWorkHistory((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[3],
				((Long)arguments[4]).longValue(),
				(java.util.Map<java.lang.String, java.lang.String>)arguments[5]);

			return null;
		}

		if (_methodName108.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes108, parameterTypes)) {
			SocialProfileLocalServiceUtil.addOrUpdateWorkHistoryFromFormData((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[3],
				((Long)arguments[4]).longValue(),
				(java.util.Map<java.lang.String, java.lang.String>)arguments[5]);

			return null;
		}

		if (_methodName109.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes109, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getUserWorkHistoryDetails((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0]);
		}

		if (_methodName110.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getUserTransactionHistoryDetails((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String[])arguments[3]);
		}

		if (_methodName111.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes111, parameterTypes)) {
			return SocialProfileLocalServiceUtil.addNetworkInfo((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3]);
		}

		if (_methodName112.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes112, parameterTypes)) {
			SocialProfileLocalServiceUtil.addOrUpdateAvailability((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[3],
				((Long)arguments[4]).longValue(),
				(java.util.Map<java.lang.String, java.lang.String>)arguments[5]);

			return null;
		}

		if (_methodName113.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes113, parameterTypes)) {
			SocialProfileLocalServiceUtil.addOrUpdateDynamicSection((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[3],
				((Long)arguments[4]).longValue(),
				(java.util.Map<java.lang.String, java.lang.String>)arguments[5]);

			return null;
		}

		if (_methodName114.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes114, parameterTypes)) {
			SocialProfileLocalServiceUtil.addOrUpdateDynamicSection((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				(com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[2],
				((Long)arguments[3]).longValue(),
				(java.util.Map<java.lang.String, java.lang.String>)arguments[4]);

			return null;
		}

		if (_methodName115.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes115, parameterTypes)) {
			return SocialProfileLocalServiceUtil.updateUser((com.liferay.portal.model.User)arguments[0]);
		}

		if (_methodName116.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes116, parameterTypes)) {
			SocialProfileLocalServiceUtil.updateUserScreenName(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);

			return null;
		}

		if (_methodName117.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes117, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getUserWebSites(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName118.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes118, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getUserPhoneList(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName119.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes119, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getContacts(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName120.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes120, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getUserEmailAddressList(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName121.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes121, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getUserAddresses(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName122.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes122, parameterTypes)) {
			SocialProfileLocalServiceUtil.updateWebsites((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0],
				(java.util.List<com.liferay.portal.model.Website>)arguments[1]);

			return null;
		}

		if (_methodName123.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes123, parameterTypes)) {
			SocialProfileLocalServiceUtil.updateContactInfo((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0],
				(java.util.List<com.liferay.portal.model.Phone>)arguments[1]);

			return null;
		}

		if (_methodName124.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes124, parameterTypes)) {
			SocialProfileLocalServiceUtil.updateNetworkInfo((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0],
				(java.util.List<com.liferay.portal.model.Contact>)arguments[1]);

			return null;
		}

		if (_methodName125.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes125, parameterTypes)) {
			SocialProfileLocalServiceUtil.updateEmailAddresses((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0],
				(java.util.List<com.liferay.portal.model.EmailAddress>)arguments[1]);

			return null;
		}

		if (_methodName126.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes126, parameterTypes)) {
			SocialProfileLocalServiceUtil.updateAddress((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0],
				(java.util.List<com.liferay.portal.model.Address>)arguments[1]);

			return null;
		}

		if (_methodName127.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes127, parameterTypes)) {
			SocialProfileLocalServiceUtil.updateMobileNo((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0],
				(java.util.List<com.liferay.portal.model.Phone>)arguments[1]);

			return null;
		}

		if (_methodName128.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes128, parameterTypes)) {
			SocialProfileLocalServiceUtil.updateLocationAndMobileNo((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0],
				(java.util.List<com.liferay.portal.model.Phone>)arguments[1]);

			return null;
		}

		if (_methodName129.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes129, parameterTypes)) {
			SocialProfileLocalServiceUtil.updateXMLFromSocialProfile((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0]);

			return null;
		}

		if (_methodName130.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes130, parameterTypes)) {
			SocialProfileLocalServiceUtil.updatePersonalInfoWhenReg((com.liferay.portal.model.User)arguments[0],
				(com.liferay.portal.kernel.json.JSONObject)arguments[1]);

			return null;
		}

		if (_methodName131.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes131, parameterTypes)) {
			SocialProfileLocalServiceUtil.updatePersonalInfo((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0],
				(com.liferay.portal.model.User)arguments[1]);

			return null;
		}

		if (_methodName132.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes132, parameterTypes)) {
			return SocialProfileLocalServiceUtil.transformSocialProfileXML((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0],
				(com.liferay.portal.model.User)arguments[1]);
		}

		if (_methodName133.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes133, parameterTypes)) {
			SocialProfileLocalServiceUtil.saveContactInfoXMLData((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);

			return null;
		}

		if (_methodName137.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes137, parameterTypes)) {
			return SocialProfileLocalServiceUtil.updateUserNetworkInfoFromSocialProfile((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0]);
		}

		if (_methodName139.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes139, parameterTypes)) {
			SocialProfileLocalServiceUtil.addSocialProfileDetail((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(), (java.lang.String)arguments[3]);

			return null;
		}

		if (_methodName140.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes140, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getExpertiseTags();
		}

		if (_methodName141.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes141, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getExpertiseTags(((Long)arguments[0]).longValue());
		}

		if (_methodName142.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes142, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getProfileCompletion((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0]);
		}

		if (_methodName143.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes143, parameterTypes)) {
			SocialProfileLocalServiceUtil.saveAvailabilityInfo((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0]);

			return null;
		}

		if (_methodName144.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
			SocialProfileLocalServiceUtil.saveWorkHistorySorted((com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[0],
				(java.lang.String)arguments[1]);

			return null;
		}

		if (_methodName145.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
			SocialProfileLocalServiceUtil.updateSPParameter((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);

			return null;
		}

		if (_methodName146.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes146, parameterTypes)) {
			return SocialProfileLocalServiceUtil.findByUserTypeAndRegStatus((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName147.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes147, parameterTypes)) {
			return SocialProfileLocalServiceUtil.findByUserTypeAndRegStatus((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName148.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes148, parameterTypes)) {
			return SocialProfileLocalServiceUtil.findByUserTypeAndRegStatus((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[4]);
		}

		if (_methodName149.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes149, parameterTypes)) {
			return SocialProfileLocalServiceUtil.findByU1_S1_S_E((java.lang.String)arguments[0],
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName150.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes150, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getFieldValue(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName151.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes151, parameterTypes)) {
			return SocialProfileLocalServiceUtil.findSocialProfileLocation();
		}

		if (_methodName152.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes152, parameterTypes)) {
			SocialProfileLocalServiceUtil.addOrUpdateProfileSPListTypes((java.lang.String)arguments[0],
				(java.lang.String[])arguments[1],
				((Long)arguments[2]).longValue());

			return null;
		}

		if (_methodName153.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes153, parameterTypes)) {
			SocialProfileLocalServiceUtil.updateWorkHistoryRelatedProjects((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				((Integer)arguments[5]).intValue());

			return null;
		}

		if (_methodName154.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes154, parameterTypes)) {
			SocialProfileLocalServiceUtil.refreshAllSocialProfileXML(((Long)arguments[0]).longValue(),
				(javax.portlet.ResourceRequest)arguments[1]);

			return null;
		}

		if (_methodName155.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes155, parameterTypes)) {
			SocialProfileLocalServiceUtil.refreshSocialProfileXML((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(javax.portlet.ResourceRequest)arguments[4]);

			return null;
		}

		if (_methodName156.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes156, parameterTypes)) {
			return SocialProfileLocalServiceUtil.addAddress((java.lang.String)arguments[0]);
		}

		if (_methodName158.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes158, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getAddress((java.lang.String)arguments[0]);
		}

		if (_methodName160.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes160, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getAssetCategories(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName161.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes161, parameterTypes)) {
			SocialProfileLocalServiceUtil.addAsMentor((com.liferay.portal.model.User)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);

			return null;
		}

		if (_methodName162.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
			return SocialProfileLocalServiceUtil.addAssetVocabulary(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName163.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
			return SocialProfileLocalServiceUtil.findByTwitterId(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName164.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes164, parameterTypes)) {
			return SocialProfileLocalServiceUtil.findByLinkedinId(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName165.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes165, parameterTypes)) {
			return SocialProfileLocalServiceUtil.findByYahooId(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName166.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
			return SocialProfileLocalServiceUtil.findByGoogleId(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName167.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
			return SocialProfileLocalServiceUtil.fetchSocialProfileDBColNames();
		}

		if (_methodName168.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
			return SocialProfileLocalServiceUtil.addUserPlatform((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Boolean)arguments[4]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[5]);
		}

		if (_methodName169.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
			SocialProfileLocalServiceUtil.sendPasswordEmail((com.liferay.portal.model.User)arguments[0],
				(java.lang.String)arguments[1],
				(com.liferay.portal.service.ServiceContext)arguments[2]);

			return null;
		}

		if (_methodName170.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
			SocialProfileLocalServiceUtil.sendWelcomeEmail((com.liferay.portal.model.User)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);

			return null;
		}

		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
			SocialProfileLocalServiceUtil.updateProfileType((com.liferay.portal.model.User)arguments[0],
				(com.sambaash.platform.model.ProfileType)arguments[1],
				(com.liferay.portal.service.ServiceContext)arguments[2]);

			return null;
		}

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
			return SocialProfileLocalServiceUtil.addAssetCategory(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getIndexableFieldsMap(((Long)arguments[0]).longValue());
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getProfileFields((java.lang.String)arguments[0]);
		}

		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			return SocialProfileLocalServiceUtil.EducationStringValue((java.lang.String)arguments[0]);
		}

		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
			return SocialProfileLocalServiceUtil.EmploymentStatusValue((java.lang.String)arguments[0]);
		}

		if (_methodName179.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
			SocialProfileLocalServiceUtil.mergeFormJsonToProfile((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());

			return null;
		}

		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
			SocialProfileLocalServiceUtil.addOrUpdateDynamicSectionWithFormData((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				(com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[2],
				((Long)arguments[3]).longValue(),
				(java.util.Map<java.lang.String, java.lang.String>)arguments[4],
				(java.lang.String)arguments[5]);

			return null;
		}

		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			return SocialProfileLocalServiceUtil.saveProfileInfo((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				(com.sambaash.platform.srv.spsocialprofile.model.SocialProfile)arguments[2],
				(com.liferay.portal.model.User)arguments[3],
				((Long)arguments[4]).longValue());
		}

		if (_methodName183.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getAssetTags((java.lang.String)arguments[0]);
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getFormFieldValue(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
			return SocialProfileLocalServiceUtil.getUsersList(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
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
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
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
	private String _methodName119;
	private String[] _methodParameterTypes119;
	private String _methodName120;
	private String[] _methodParameterTypes120;
	private String _methodName121;
	private String[] _methodParameterTypes121;
	private String _methodName122;
	private String[] _methodParameterTypes122;
	private String _methodName123;
	private String[] _methodParameterTypes123;
	private String _methodName124;
	private String[] _methodParameterTypes124;
	private String _methodName125;
	private String[] _methodParameterTypes125;
	private String _methodName126;
	private String[] _methodParameterTypes126;
	private String _methodName127;
	private String[] _methodParameterTypes127;
	private String _methodName128;
	private String[] _methodParameterTypes128;
	private String _methodName129;
	private String[] _methodParameterTypes129;
	private String _methodName130;
	private String[] _methodParameterTypes130;
	private String _methodName131;
	private String[] _methodParameterTypes131;
	private String _methodName132;
	private String[] _methodParameterTypes132;
	private String _methodName133;
	private String[] _methodParameterTypes133;
	private String _methodName137;
	private String[] _methodParameterTypes137;
	private String _methodName139;
	private String[] _methodParameterTypes139;
	private String _methodName140;
	private String[] _methodParameterTypes140;
	private String _methodName141;
	private String[] _methodParameterTypes141;
	private String _methodName142;
	private String[] _methodParameterTypes142;
	private String _methodName143;
	private String[] _methodParameterTypes143;
	private String _methodName144;
	private String[] _methodParameterTypes144;
	private String _methodName145;
	private String[] _methodParameterTypes145;
	private String _methodName146;
	private String[] _methodParameterTypes146;
	private String _methodName147;
	private String[] _methodParameterTypes147;
	private String _methodName148;
	private String[] _methodParameterTypes148;
	private String _methodName149;
	private String[] _methodParameterTypes149;
	private String _methodName150;
	private String[] _methodParameterTypes150;
	private String _methodName151;
	private String[] _methodParameterTypes151;
	private String _methodName152;
	private String[] _methodParameterTypes152;
	private String _methodName153;
	private String[] _methodParameterTypes153;
	private String _methodName154;
	private String[] _methodParameterTypes154;
	private String _methodName155;
	private String[] _methodParameterTypes155;
	private String _methodName156;
	private String[] _methodParameterTypes156;
	private String _methodName158;
	private String[] _methodParameterTypes158;
	private String _methodName160;
	private String[] _methodParameterTypes160;
	private String _methodName161;
	private String[] _methodParameterTypes161;
	private String _methodName162;
	private String[] _methodParameterTypes162;
	private String _methodName163;
	private String[] _methodParameterTypes163;
	private String _methodName164;
	private String[] _methodParameterTypes164;
	private String _methodName165;
	private String[] _methodParameterTypes165;
	private String _methodName166;
	private String[] _methodParameterTypes166;
	private String _methodName167;
	private String[] _methodParameterTypes167;
	private String _methodName168;
	private String[] _methodParameterTypes168;
	private String _methodName169;
	private String[] _methodParameterTypes169;
	private String _methodName170;
	private String[] _methodParameterTypes170;
	private String _methodName172;
	private String[] _methodParameterTypes172;
	private String _methodName174;
	private String[] _methodParameterTypes174;
	private String _methodName175;
	private String[] _methodParameterTypes175;
	private String _methodName176;
	private String[] _methodParameterTypes176;
	private String _methodName177;
	private String[] _methodParameterTypes177;
	private String _methodName178;
	private String[] _methodParameterTypes178;
	private String _methodName179;
	private String[] _methodParameterTypes179;
	private String _methodName181;
	private String[] _methodParameterTypes181;
	private String _methodName182;
	private String[] _methodParameterTypes182;
	private String _methodName183;
	private String[] _methodParameterTypes183;
	private String _methodName184;
	private String[] _methodParameterTypes184;
	private String _methodName185;
	private String[] _methodParameterTypes185;
}