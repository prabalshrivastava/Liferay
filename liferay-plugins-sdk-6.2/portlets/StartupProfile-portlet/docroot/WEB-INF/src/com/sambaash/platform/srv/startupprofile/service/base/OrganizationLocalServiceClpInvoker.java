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

package com.sambaash.platform.srv.startupprofile.service.base;

import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;

import java.util.Arrays;

/**
 * @author pradeep
 * @generated
 */
public class OrganizationLocalServiceClpInvoker {
	public OrganizationLocalServiceClpInvoker() {
		_methodName0 = "addOrganization";

		_methodParameterTypes0 = new String[] {
				"com.sambaash.platform.srv.startupprofile.model.Organization"
			};

		_methodName1 = "createOrganization";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteOrganization";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteOrganization";

		_methodParameterTypes3 = new String[] {
				"com.sambaash.platform.srv.startupprofile.model.Organization"
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

		_methodName10 = "fetchOrganization";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchOrganizationByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchOrganizationByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getOrganization";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getOrganizationByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getOrganizationByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getOrganizations";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getOrganizationsCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateOrganization";

		_methodParameterTypes19 = new String[] {
				"com.sambaash.platform.srv.startupprofile.model.Organization"
			};

		_methodName124 = "getBeanIdentifier";

		_methodParameterTypes124 = new String[] {  };

		_methodName125 = "setBeanIdentifier";

		_methodParameterTypes125 = new String[] { "java.lang.String" };

		_methodName130 = "create";

		_methodParameterTypes130 = new String[] {  };

		_methodName131 = "persistData";

		_methodParameterTypes131 = new String[] {
				"java.util.Map", "java.util.Map", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName132 = "getCurrentUserBaseOrganization";

		_methodParameterTypes132 = new String[] { "long" };

		_methodName133 = "getLoggedInUserId";

		_methodParameterTypes133 = new String[] {  };

		_methodName134 = "addPrincipalDetails";

		_methodParameterTypes134 = new String[] { "java.lang.String" };

		_methodName135 = "addPrincipalDetails";

		_methodParameterTypes135 = new String[] {
				"com.liferay.portal.kernel.json.JSONObject"
			};

		_methodName136 = "addMentorToApplication";

		_methodParameterTypes136 = new String[] { "java.lang.String" };

		_methodName137 = "removeRole";

		_methodParameterTypes137 = new String[] { "long" };

		_methodName139 = "updatePrinciples";

		_methodParameterTypes139 = new String[] { "java.lang.String" };

		_methodName140 = "updateEmployeeInfo";

		_methodParameterTypes140 = new String[] { "java.lang.String" };

		_methodName141 = "updateAccreditation";

		_methodParameterTypes141 = new String[] { "java.lang.String" };

		_methodName144 = "updateAssets";

		_methodParameterTypes144 = new String[] {
				"long",
				"com.sambaash.platform.srv.startupprofile.model.Organization",
				"long[][]"
			};

		_methodName145 = "updateAssets";

		_methodParameterTypes145 = new String[] {
				"long",
				"com.sambaash.platform.srv.startupprofile.model.Organization",
				"long[][]", "java.lang.String[][]"
			};

		_methodName146 = "getAllActiveOrganizations";

		_methodParameterTypes146 = new String[] {  };

		_methodName147 = "createOrgDataMap";

		_methodParameterTypes147 = new String[] { "long" };

		_methodName148 = "clearCache";

		_methodParameterTypes148 = new String[] {
				"com.sambaash.platform.srv.startupprofile.model.Organization"
			};

		_methodName149 = "getOfficeAddresses";

		_methodParameterTypes149 = new String[] { "long" };

		_methodName150 = "getOfficeHeadQuaterAddress";

		_methodParameterTypes150 = new String[] { "long" };

		_methodName151 = "reIndex";

		_methodParameterTypes151 = new String[] {
				"com.sambaash.platform.srv.startupprofile.model.Organization"
			};

		_methodName152 = "getFundingRounds";

		_methodParameterTypes152 = new String[] { "long" };

		_methodName153 = "getContacts";

		_methodParameterTypes153 = new String[] { "long" };

		_methodName154 = "getAddresses";

		_methodParameterTypes154 = new String[] { "long" };

		_methodName155 = "getQuestionnaire";

		_methodParameterTypes155 = new String[] { "long" };

		_methodName156 = "getAccreditation";

		_methodParameterTypes156 = new String[] { "long" };

		_methodName157 = "getGuidelines";

		_methodParameterTypes157 = new String[] { "long" };

		_methodName158 = "getMentors";

		_methodParameterTypes158 = new String[] { "long" };

		_methodName159 = "getApprovedMentors";

		_methodParameterTypes159 = new String[] { "long" };

		_methodName160 = "getEmployeeInfo";

		_methodParameterTypes160 = new String[] { "long" };

		_methodName161 = "getSPATOContacts";

		_methodParameterTypes161 = new String[] { "long" };

		_methodName162 = "getATODocuments";

		_methodParameterTypes162 = new String[] { "long" };

		_methodName163 = "getFounders";

		_methodParameterTypes163 = new String[] { "long" };

		_methodName164 = "getBoardAndAdvisory";

		_methodParameterTypes164 = new String[] { "long" };

		_methodName165 = "getTeamMembers";

		_methodParameterTypes165 = new String[] { "long" };

		_methodName166 = "getFilledBy";

		_methodParameterTypes166 = new String[] { "long" };

		_methodName167 = "getCompetitors";

		_methodParameterTypes167 = new String[] { "long" };

		_methodName168 = "getInvestors";

		_methodParameterTypes168 = new String[] { "long" };

		_methodName171 = "isOrganizationExistsWithName";

		_methodParameterTypes171 = new String[] { "java.lang.String" };

		_methodName172 = "findByUENNumber";

		_methodParameterTypes172 = new String[] { "java.lang.String" };

		_methodName173 = "isOrganizationExistsWithUEN";

		_methodParameterTypes173 = new String[] { "java.lang.String" };

		_methodName174 = "findByName";

		_methodParameterTypes174 = new String[] { "java.lang.String" };

		_methodName175 = "getUserOrganizations";

		_methodParameterTypes175 = new String[] { "java.lang.Long" };

		_methodName176 = "displayFriendlyURL";

		_methodParameterTypes176 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay", "long"
			};

		_methodName177 = "applicationFriendlyURL";

		_methodParameterTypes177 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay"
			};

		_methodName178 = "applicationFriendlyURL";

		_methodParameterTypes178 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay", "long"
			};

		_methodName179 = "editFriendlyURL";

		_methodParameterTypes179 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay", "long"
			};

		_methodName180 = "createFriendlyURL";

		_methodParameterTypes180 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay"
			};

		_methodName181 = "exportStartupDetails";

		_methodParameterTypes181 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay",
				"com.sambaash.platform.srv.startupprofile.model.Organization",
				"com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant"
			};

		_methodName182 = "canUpdateStartup";

		_methodParameterTypes182 = new String[] {
				"javax.portlet.PortletRequest", "long"
			};

		_methodName183 = "organizationHasCategoryName";

		_methodParameterTypes183 = new String[] { "long", "java.lang.String" };

		_methodName184 = "getAllATO";

		_methodParameterTypes184 = new String[] {  };

		_methodName185 = "getATOExpiryPeriodParam";

		_methodParameterTypes185 = new String[] {  };

		_methodName186 = "getATOExpiryAdvanceNoticeParam";

		_methodParameterTypes186 = new String[] {  };

		_methodName187 = "getATOPostExpiryNoticeParam";

		_methodParameterTypes187 = new String[] {  };

		_methodName188 = "getATOsForExpiryNotification";

		_methodParameterTypes188 = new String[] {  };

		_methodName189 = "getAllExpiredATOs";

		_methodParameterTypes189 = new String[] {  };

		_methodName190 = "updateATOAsExpired";

		_methodParameterTypes190 = new String[] { "long" };

		_methodName191 = "updateATOInactive";

		_methodParameterTypes191 = new String[] { "long" };

		_methodName192 = "approveATO";

		_methodParameterTypes192 = new String[] { "long" };

		_methodName193 = "approveATOByUserId";

		_methodParameterTypes193 = new String[] { "long" };

		_methodName194 = "transferOwnership";

		_methodParameterTypes194 = new String[] { "java.lang.Long" };

		_methodName195 = "removeTPandSCfromATO";

		_methodParameterTypes195 = new String[] { "long" };

		_methodName196 = "isUserLinkedToOrganization";

		_methodParameterTypes196 = new String[] { "java.lang.String" };

		_methodName197 = "isUserLinkedToOrganization";

		_methodParameterTypes197 = new String[] { "java.lang.String", "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return OrganizationLocalServiceUtil.addOrganization((com.sambaash.platform.srv.startupprofile.model.Organization)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return OrganizationLocalServiceUtil.createOrganization(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return OrganizationLocalServiceUtil.deleteOrganization(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return OrganizationLocalServiceUtil.deleteOrganization((com.sambaash.platform.srv.startupprofile.model.Organization)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return OrganizationLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return OrganizationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return OrganizationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return OrganizationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return OrganizationLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return OrganizationLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return OrganizationLocalServiceUtil.fetchOrganization(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return OrganizationLocalServiceUtil.fetchOrganizationByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return OrganizationLocalServiceUtil.fetchOrganizationByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return OrganizationLocalServiceUtil.getOrganization(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return OrganizationLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return OrganizationLocalServiceUtil.getOrganizationByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return OrganizationLocalServiceUtil.getOrganizationByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return OrganizationLocalServiceUtil.getOrganizations(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return OrganizationLocalServiceUtil.getOrganizationsCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return OrganizationLocalServiceUtil.updateOrganization((com.sambaash.platform.srv.startupprofile.model.Organization)arguments[0]);
		}

		if (_methodName124.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes124, parameterTypes)) {
			return OrganizationLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName125.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes125, parameterTypes)) {
			OrganizationLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName130.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes130, parameterTypes)) {
			return OrganizationLocalServiceUtil.create();
		}

		if (_methodName131.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes131, parameterTypes)) {
			return OrganizationLocalServiceUtil.persistData((java.util.Map<java.lang.String, java.lang.String>)arguments[0],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[1],
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4]);
		}

		if (_methodName132.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes132, parameterTypes)) {
			return OrganizationLocalServiceUtil.getCurrentUserBaseOrganization(((Long)arguments[0]).longValue());
		}

		if (_methodName133.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes133, parameterTypes)) {
			return OrganizationLocalServiceUtil.getLoggedInUserId();
		}

		if (_methodName134.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes134, parameterTypes)) {
			return OrganizationLocalServiceUtil.addPrincipalDetails((java.lang.String)arguments[0]);
		}

		if (_methodName135.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes135, parameterTypes)) {
			return OrganizationLocalServiceUtil.addPrincipalDetails((com.liferay.portal.kernel.json.JSONObject)arguments[0]);
		}

		if (_methodName136.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes136, parameterTypes)) {
			return OrganizationLocalServiceUtil.addMentorToApplication((java.lang.String)arguments[0]);
		}

		if (_methodName137.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes137, parameterTypes)) {
			OrganizationLocalServiceUtil.removeRole(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName139.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes139, parameterTypes)) {
			return OrganizationLocalServiceUtil.updatePrinciples((java.lang.String)arguments[0]);
		}

		if (_methodName140.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes140, parameterTypes)) {
			return OrganizationLocalServiceUtil.updateEmployeeInfo((java.lang.String)arguments[0]);
		}

		if (_methodName141.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes141, parameterTypes)) {
			return OrganizationLocalServiceUtil.updateAccreditation((java.lang.String)arguments[0]);
		}

		if (_methodName144.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
			OrganizationLocalServiceUtil.updateAssets(((Long)arguments[0]).longValue(),
				(com.sambaash.platform.srv.startupprofile.model.Organization)arguments[1],
				(long[])arguments[2]);

			return null;
		}

		if (_methodName145.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
			OrganizationLocalServiceUtil.updateAssets(((Long)arguments[0]).longValue(),
				(com.sambaash.platform.srv.startupprofile.model.Organization)arguments[1],
				(long[])arguments[2], (java.lang.String[])arguments[3]);

			return null;
		}

		if (_methodName146.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes146, parameterTypes)) {
			return OrganizationLocalServiceUtil.getAllActiveOrganizations();
		}

		if (_methodName147.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes147, parameterTypes)) {
			return OrganizationLocalServiceUtil.createOrgDataMap(((Long)arguments[0]).longValue());
		}

		if (_methodName148.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes148, parameterTypes)) {
			OrganizationLocalServiceUtil.clearCache((com.sambaash.platform.srv.startupprofile.model.Organization)arguments[0]);

			return null;
		}

		if (_methodName149.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes149, parameterTypes)) {
			return OrganizationLocalServiceUtil.getOfficeAddresses(((Long)arguments[0]).longValue());
		}

		if (_methodName150.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes150, parameterTypes)) {
			return OrganizationLocalServiceUtil.getOfficeHeadQuaterAddress(((Long)arguments[0]).longValue());
		}

		if (_methodName151.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes151, parameterTypes)) {
			OrganizationLocalServiceUtil.reIndex((com.sambaash.platform.srv.startupprofile.model.Organization)arguments[0]);

			return null;
		}

		if (_methodName152.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes152, parameterTypes)) {
			return OrganizationLocalServiceUtil.getFundingRounds(((Long)arguments[0]).longValue());
		}

		if (_methodName153.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes153, parameterTypes)) {
			return OrganizationLocalServiceUtil.getContacts(((Long)arguments[0]).longValue());
		}

		if (_methodName154.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes154, parameterTypes)) {
			return OrganizationLocalServiceUtil.getAddresses(((Long)arguments[0]).longValue());
		}

		if (_methodName155.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes155, parameterTypes)) {
			return OrganizationLocalServiceUtil.getQuestionnaire(((Long)arguments[0]).longValue());
		}

		if (_methodName156.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes156, parameterTypes)) {
			return OrganizationLocalServiceUtil.getAccreditation(((Long)arguments[0]).longValue());
		}

		if (_methodName157.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes157, parameterTypes)) {
			return OrganizationLocalServiceUtil.getGuidelines(((Long)arguments[0]).longValue());
		}

		if (_methodName158.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes158, parameterTypes)) {
			return OrganizationLocalServiceUtil.getMentors(((Long)arguments[0]).longValue());
		}

		if (_methodName159.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes159, parameterTypes)) {
			return OrganizationLocalServiceUtil.getApprovedMentors(((Long)arguments[0]).longValue());
		}

		if (_methodName160.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes160, parameterTypes)) {
			return OrganizationLocalServiceUtil.getEmployeeInfo(((Long)arguments[0]).longValue());
		}

		if (_methodName161.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes161, parameterTypes)) {
			return OrganizationLocalServiceUtil.getSPATOContacts(((Long)arguments[0]).longValue());
		}

		if (_methodName162.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
			return OrganizationLocalServiceUtil.getATODocuments(((Long)arguments[0]).longValue());
		}

		if (_methodName163.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
			return OrganizationLocalServiceUtil.getFounders(((Long)arguments[0]).longValue());
		}

		if (_methodName164.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes164, parameterTypes)) {
			return OrganizationLocalServiceUtil.getBoardAndAdvisory(((Long)arguments[0]).longValue());
		}

		if (_methodName165.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes165, parameterTypes)) {
			return OrganizationLocalServiceUtil.getTeamMembers(((Long)arguments[0]).longValue());
		}

		if (_methodName166.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
			return OrganizationLocalServiceUtil.getFilledBy(((Long)arguments[0]).longValue());
		}

		if (_methodName167.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
			return OrganizationLocalServiceUtil.getCompetitors(((Long)arguments[0]).longValue());
		}

		if (_methodName168.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
			return OrganizationLocalServiceUtil.getInvestors(((Long)arguments[0]).longValue());
		}

		if (_methodName171.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
			return OrganizationLocalServiceUtil.isOrganizationExistsWithName((java.lang.String)arguments[0]);
		}

		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
			return OrganizationLocalServiceUtil.findByUENNumber((java.lang.String)arguments[0]);
		}

		if (_methodName173.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
			return OrganizationLocalServiceUtil.isOrganizationExistsWithUEN((java.lang.String)arguments[0]);
		}

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
			return OrganizationLocalServiceUtil.findByName((java.lang.String)arguments[0]);
		}

		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
			return OrganizationLocalServiceUtil.getUserOrganizations((java.lang.Long)arguments[0]);
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return OrganizationLocalServiceUtil.displayFriendlyURL((com.liferay.portal.theme.ThemeDisplay)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			return OrganizationLocalServiceUtil.applicationFriendlyURL((com.liferay.portal.theme.ThemeDisplay)arguments[0]);
		}

		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
			return OrganizationLocalServiceUtil.applicationFriendlyURL((com.liferay.portal.theme.ThemeDisplay)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName179.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
			return OrganizationLocalServiceUtil.editFriendlyURL((com.liferay.portal.theme.ThemeDisplay)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
			return OrganizationLocalServiceUtil.createFriendlyURL((com.liferay.portal.theme.ThemeDisplay)arguments[0]);
		}

		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
			return OrganizationLocalServiceUtil.exportStartupDetails((com.liferay.portal.theme.ThemeDisplay)arguments[0],
				(com.sambaash.platform.srv.startupprofile.model.Organization)arguments[1],
				(com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant)arguments[2]);
		}

		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			return OrganizationLocalServiceUtil.canUpdateStartup((javax.portlet.PortletRequest)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName183.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
			return OrganizationLocalServiceUtil.organizationHasCategoryName(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return OrganizationLocalServiceUtil.getAllATO();
		}

		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
			return OrganizationLocalServiceUtil.getATOExpiryPeriodParam();
		}

		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
			return OrganizationLocalServiceUtil.getATOExpiryAdvanceNoticeParam();
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			return OrganizationLocalServiceUtil.getATOPostExpiryNoticeParam();
		}

		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
			return OrganizationLocalServiceUtil.getATOsForExpiryNotification();
		}

		if (_methodName189.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
			return OrganizationLocalServiceUtil.getAllExpiredATOs();
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return OrganizationLocalServiceUtil.updateATOAsExpired(((Long)arguments[0]).longValue());
		}

		if (_methodName191.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
			return OrganizationLocalServiceUtil.updateATOInactive(((Long)arguments[0]).longValue());
		}

		if (_methodName192.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
			return OrganizationLocalServiceUtil.approveATO(((Long)arguments[0]).longValue());
		}

		if (_methodName193.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
			return OrganizationLocalServiceUtil.approveATOByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName194.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes194, parameterTypes)) {
			OrganizationLocalServiceUtil.transferOwnership((java.lang.Long)arguments[0]);

			return null;
		}

		if (_methodName195.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes195, parameterTypes)) {
			return OrganizationLocalServiceUtil.removeTPandSCfromATO(((Long)arguments[0]).longValue());
		}

		if (_methodName196.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes196, parameterTypes)) {
			return OrganizationLocalServiceUtil.isUserLinkedToOrganization((java.lang.String)arguments[0]);
		}

		if (_methodName197.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes197, parameterTypes)) {
			return OrganizationLocalServiceUtil.isUserLinkedToOrganization((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
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
	private String _methodName124;
	private String[] _methodParameterTypes124;
	private String _methodName125;
	private String[] _methodParameterTypes125;
	private String _methodName130;
	private String[] _methodParameterTypes130;
	private String _methodName131;
	private String[] _methodParameterTypes131;
	private String _methodName132;
	private String[] _methodParameterTypes132;
	private String _methodName133;
	private String[] _methodParameterTypes133;
	private String _methodName134;
	private String[] _methodParameterTypes134;
	private String _methodName135;
	private String[] _methodParameterTypes135;
	private String _methodName136;
	private String[] _methodParameterTypes136;
	private String _methodName137;
	private String[] _methodParameterTypes137;
	private String _methodName139;
	private String[] _methodParameterTypes139;
	private String _methodName140;
	private String[] _methodParameterTypes140;
	private String _methodName141;
	private String[] _methodParameterTypes141;
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
	private String _methodName157;
	private String[] _methodParameterTypes157;
	private String _methodName158;
	private String[] _methodParameterTypes158;
	private String _methodName159;
	private String[] _methodParameterTypes159;
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
	private String _methodName171;
	private String[] _methodParameterTypes171;
	private String _methodName172;
	private String[] _methodParameterTypes172;
	private String _methodName173;
	private String[] _methodParameterTypes173;
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
	private String _methodName180;
	private String[] _methodParameterTypes180;
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
	private String _methodName186;
	private String[] _methodParameterTypes186;
	private String _methodName187;
	private String[] _methodParameterTypes187;
	private String _methodName188;
	private String[] _methodParameterTypes188;
	private String _methodName189;
	private String[] _methodParameterTypes189;
	private String _methodName190;
	private String[] _methodParameterTypes190;
	private String _methodName191;
	private String[] _methodParameterTypes191;
	private String _methodName192;
	private String[] _methodParameterTypes192;
	private String _methodName193;
	private String[] _methodParameterTypes193;
	private String _methodName194;
	private String[] _methodParameterTypes194;
	private String _methodName195;
	private String[] _methodParameterTypes195;
	private String _methodName196;
	private String[] _methodParameterTypes196;
	private String _methodName197;
	private String[] _methodParameterTypes197;
}