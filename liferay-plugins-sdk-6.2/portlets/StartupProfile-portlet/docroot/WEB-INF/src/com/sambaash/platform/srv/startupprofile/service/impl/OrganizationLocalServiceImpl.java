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

package com.sambaash.platform.srv.startupprofile.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.portlet.PortletRequest;

import org.apache.commons.lang.StringUtils;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.util.PwdGenerator;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.security.util.SPAuthenticationUtil;
import com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.model.SPUserTypeConfig;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPUserTypeConfigLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPUserTypeLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.model.ATODocument;
import com.sambaash.platform.srv.startupprofile.model.Accreditation;
import com.sambaash.platform.srv.startupprofile.model.Address;
import com.sambaash.platform.srv.startupprofile.model.ApprovedMentors;
import com.sambaash.platform.srv.startupprofile.model.EmployeeInfo;
import com.sambaash.platform.srv.startupprofile.model.FundingRound;
import com.sambaash.platform.srv.startupprofile.model.Guidelines;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.model.Person;
import com.sambaash.platform.srv.startupprofile.model.Questionnaire;
import com.sambaash.platform.srv.startupprofile.model.Relationship;
import com.sambaash.platform.srv.startupprofile.model.SPATOContacts;
import com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs;
import com.sambaash.platform.srv.startupprofile.service.ATODocumentLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.AccreditationLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.AddressLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.ApprovedMentorsLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.EmployeeInfoLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.FundingRoundLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.GuidelinesLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.PersonLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.QuestionnaireLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.RelationshipLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.SPATOContactsLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.SPOrgContactUsLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.base.OrganizationLocalServiceBaseImpl;
import com.sambaash.platform.startupprofile.DBConstants;
import com.sambaash.platform.startupprofile.StartupConstants;
import com.sambaash.platform.startupprofile.helper.StartupFormHelper;
import com.sambaash.platform.startupprofile.helper.StartupPermissionHelper;
import com.sambaash.platform.startupprofile.helper.StartupProfileHelper;
import com.sambaash.platform.startupprofile.reports.ReportGenerator;
import com.sambaash.platform.startupprofile.reports.ReportPayload;
import com.sambaash.platform.startupprofile.reports.ReportSection;
import com.sambaash.platform.startupprofile.reports.ReportSections;
import com.sambaash.platform.util.PermissionUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the organization local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.startupprofile.service.OrganizationLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author pradeep
 * @see com.sambaash.platform.srv.startupprofile.service.base.OrganizationLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil
 */
public class OrganizationLocalServiceImpl extends OrganizationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform
	 * .srv.startupprofile.service.OrganizationLocalServiceUtil} to access the
	 * organization local service.
	 */

	private static Log logger = LogFactoryUtil.getLog(OrganizationLocalServiceImpl.class);

	private static String PORTLET_ID = "managestartupprofile_WAR_StartupProfileportlet";

	public Organization create() throws SystemException {
		long orgId = CounterLocalServiceUtil.increment("Organization");
		return organizationPersistence.create(orgId);
	}
	

	public Organization persistData(Map<String, String> requestParamMap, Map<String, Object> existingMap, String productTypeId, String subProductTypeId, String virtualHostId)
			throws SystemException, PortalException {

		StartupFormHelper helper = new StartupFormHelper();
		Map<String, Object> map = helper.parsedRequestData(requestParamMap, existingMap, StringPool.BLANK);

		// TODO: add logging
		long orgId = -1;
		Organization rootOrg = null;
		String password = PwdGenerator.getPassword();
		
		long groupId = Long.valueOf(map.get("auditgroupId").toString());
		
		productTypeId = (Validator.isNumber(productTypeId) && Long.parseLong(productTypeId) > 0) ? productTypeId
				: SambaashUtil.getParameter("default.producttype.id", groupId);
		subProductTypeId = (Validator.isNumber(subProductTypeId) && Long.parseLong(subProductTypeId) > 0) ? subProductTypeId
				: SambaashUtil.getParameter("default.subproducttype.id", groupId);
		virtualHostId = (Validator.isNumber(virtualHostId) && Long.parseLong(virtualHostId) > 0) ? virtualHostId
				: SambaashUtil.getParameter("default.virtualhost.id", groupId);

		logger.error(String.format("productTypeId %s, subProductTypeId %s, virtualHostId %s ", productTypeId,
				subProductTypeId, virtualHostId));
		
		try {
			Date date = new Date();
			Set<Entry<String, Object>> entrySet = map.entrySet();
			if (Validator.isNull(requestParamMap.get("orgId")))
				orgId = CounterLocalServiceUtil.increment("Organization");
			else
				orgId = Long.valueOf((String) requestParamMap.get("orgId"));
			for (Entry<String, Object> entry : entrySet) {
				if (entry.getValue() instanceof Organization) {
					Organization org = (Organization) entry.getValue();
					if (org.isNew()) {
						if (entry.getKey().startsWith(StartupConstants.ATTRIB_ORGANIZATION)) {
							org.setOrganizationId(orgId);
							org.setIsBaseOrg(true);
							org.setCompleteness(false);
							rootOrg = organizationPersistence.update(org);
							continue;
						} else {
							org.setIsBaseOrg(false);
							long relation = -1;
							long relationOrgId = CounterLocalServiceUtil.increment("Organization");
							org.setOrganizationId(relationOrgId);
							if (entry.getKey().startsWith("investor")) {
								relation = DBConstants.RELATION_INVESTOR_COMPANY;
							} else if (entry.getKey().startsWith("competitor")) {
								relation = DBConstants.RELATION_COMPETITOR;
							}
							Relationship rel = createNewRelationship(orgId, DBConstants.REF_TYPE_ORGANIZATION_ID,
									relation, date);
							rel.setRefId(relationOrgId);
							RelationshipLocalServiceUtil.updateRelationship(rel);
						}
					}
					organizationPersistence.update(org);
				} else if (entry.getValue() instanceof Address) {
					Address address = (Address) entry.getValue();
					if (address.isNew()) {
						address.setAddressId(CounterLocalServiceUtil.increment("Address"));
						address.setOrganizationId(orgId);
					}
					//if (entry.getValue().toString().contains("hq"))
					//	address.setHq(true);
					address.setActive(true);
					AddressLocalServiceUtil.updateAddress(address);
				} else if (entry.getValue() instanceof Person) {

					Person person = (Person) entry.getValue();
					if (person.isNew() && person.getMemberUserId() != -1) {
						long personId = CounterLocalServiceUtil.increment("Person");
						person.setPersonId(personId);

						long relation = -1;
						if (entry.getKey().startsWith(StartupConstants.ATTRIB_FILLED_BY)) {
							relation = DBConstants.RELATION_FILLED_BY;
						} else if (entry.getKey().startsWith(StartupConstants.ATTRIB_BOARD_MEMBER)) {
							relation = DBConstants.RELATION_BOARD_AND_ADVISORY;
						} else if (entry.getKey().startsWith(StartupConstants.ATTRIB_INVESTOR_PERSON)) {
							relation = DBConstants.RELATION_INVESTOR_PERSON;
						} else if (entry.getKey().startsWith(StartupConstants.ATTRIB_FOUNDER)) {
							relation = DBConstants.RELATION_FOUNDER;
						} else if (entry.getKey().startsWith(StartupConstants.ATTRIB_TEAM_MEMBER)) {
							relation = DBConstants.RELATION_TEAM_MEMBER;
						}
						Relationship rel = createNewRelationship(orgId, DBConstants.REF_TYPE_PERSON_ID, relation, date);
						rel.setRefId(personId);
						RelationshipLocalServiceUtil.updateRelationship(rel);
					}
					if (person.getMemberUserId() != -1)
						PersonLocalServiceUtil.updatePerson(person);

				} else if (entry.getValue() instanceof FundingRound) {
					FundingRound fundingRound = (FundingRound) entry.getValue();
					if (fundingRound.isNew()) {
						fundingRound.setOrganizationId(orgId);
						/*
						 * fundingRound.setFundingRoundId(
						 * CounterLocalServiceUtil .increment("FundingRound"));
						 */
						fundingRound.setFundingRoundId(FundingRoundLocalServiceUtil.counterIncrement());
					}
					FundingRoundLocalServiceUtil.updateFundingRound(fundingRound);
				} else if (entry.getValue() instanceof Questionnaire) {
					Questionnaire questionnaire = (Questionnaire) entry.getValue();
					if (questionnaire.isNew()) {
						questionnaire.setEntryClassPK(orgId);
						questionnaire.setEntryClassName("com.sambaash.platform.srv.startupprofile.model.Organization");
						questionnaire.setQuestionnaireId(CounterLocalServiceUtil.increment("Questionnnaire"));
					}

					QuestionnaireLocalServiceUtil.updateQuestionnaire(questionnaire);
				} else if (entry.getValue() instanceof SPOrgContactUs) {
					SPOrgContactUs contactus = (SPOrgContactUs) entry.getValue();
					if (contactus.isNew()) {
						contactus.setOrganizationId(orgId);
						contactus.setSpContactUsId(CounterLocalServiceUtil.increment("SPOrgContactUs"));
					}
					SPOrgContactUsLocalServiceUtil.updateSPOrgContactUs(contactus);
				} else if (entry.getValue() instanceof EmployeeInfo) {
					EmployeeInfo employeeinfo = (EmployeeInfo) entry.getValue();
					if (employeeinfo.isNew()) {
						employeeinfo.setEmployeeInfoId(CounterLocalServiceUtil.increment("EmployeeInfo"));
						employeeinfo.setOrganizationId(orgId);
					}
					EmployeeInfoLocalServiceUtil.updateEmployeeInfo(employeeinfo);
				} else if (entry.getValue() instanceof Guidelines) {
					Guidelines guideline = (Guidelines) entry.getValue();
					if (guideline.isNew()) {
						guideline.setGuidelineId(CounterLocalServiceUtil.increment("ApprovedMentors"));
						guideline.setOrganizationId(orgId);
					}
					GuidelinesLocalServiceUtil.updateGuidelines(guideline);
				} else if (entry.getValue() instanceof Accreditation) {
					Accreditation accreditation = (Accreditation) entry.getValue();
					if (accreditation.isNew()) {
						accreditation.setAccreditationId(CounterLocalServiceUtil.increment("Accreditation"));
						accreditation.setOrganizationId(orgId);
					}
					AccreditationLocalServiceUtil.updateAccreditation(accreditation);
				} else if (entry.getValue() instanceof SPATOContacts) {
					SPATOContacts spatoContact = (SPATOContacts) entry.getValue();
					ServiceContext serviceContext = new ServiceContext();

					//TODO: Remove hard coding for virtualhost id.
					serviceContext.setAttribute("virtualHostId", virtualHostId);
					if (spatoContact.isNew()) {
						spatoContact.setSpATOContactId(CounterLocalServiceUtil.increment("SPATOContacts"));
						spatoContact.setOrganizationId(orgId);
					}

					if (!spatoContact.getPrimaryPrincipalUserEmail().equalsIgnoreCase(StringPool.BLANK)) {
						User user = null;
						try {
							user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(),
									spatoContact.getPrimaryPrincipalUserEmail());
						} catch (NoSuchUserException e) {
							logger.debug("Email not found " + spatoContact.getPrimaryPrincipalUserEmail());
							user = this.addUser(spatoContact.getPrimaryPrincipalUserEmail(),
									spatoContact.getPrimaryPrincipalUserFirstName(),
									Validator.isNotNull(spatoContact.getPrimaryPrincipalUserLastName())
											? spatoContact.getPrimaryPrincipalUserLastName() : StringPool.PERIOD,
									password, false, virtualHostId, subProductTypeId);
							
							serviceContext.setAttribute("userType", "Training Principal");
							SocialProfileLocalServiceUtil.sendPasswordEmail(user, password, serviceContext);
							
							
							//TODO: Can't update at this point because reference is still there to the old userId. Need to add new API.
//							Organization org = OrganizationLocalServiceUtil.getOrganization(orgId);
//							org.setUserId(user.getUserId());
//							org.setModifiedDate(DateUtil.newDate());
//							OrganizationLocalServiceUtil.updateOrganization(org);
							
						}
						
						if(!String.valueOf(user.getUserId()).equalsIgnoreCase(spatoContact.getPrimaryPrincipalUserId())){
							SPUserTypeLocalServiceUtil.addSPSiteAndUserType("Training Principal", virtualHostId, user, productTypeId, subProductTypeId, password);
							assignRole("Training Principal", virtualHostId, user);
							spatoContact.setPrimaryPrincipalUserId(String.valueOf(user.getUserId()));
						}

					}
					if (!spatoContact.getSecondaryPrincipalUserEmail().equalsIgnoreCase(StringPool.BLANK)) {
						User user = null;
						try {
							user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(),
									spatoContact.getSecondaryPrincipalUserEmail());
						} catch (NoSuchUserException e) {
							logger.debug("Email not found " + spatoContact.getSecondaryPrincipalUserEmail());
							user = this.addUser(spatoContact.getSecondaryPrincipalUserEmail(),
									spatoContact.getSecondaryPrincipalUserFirstName(),
									Validator.isNotNull(spatoContact.getSecondaryPrincipalUserLastName())
											? spatoContact.getSecondaryPrincipalUserLastName() : StringPool.PERIOD,
									password, false, virtualHostId, subProductTypeId);
							serviceContext.setAttribute("userType", "Secondary Contact");
							SocialProfileLocalServiceUtil.sendPasswordEmail(user, password, serviceContext);
							
						}
						
						if(!String.valueOf(user.getUserId()).equalsIgnoreCase(spatoContact.getSecondaryPrincipalUserId())){
							SPUserTypeLocalServiceUtil.addSPSiteAndUserType("Secondary Contact", virtualHostId, user, productTypeId, subProductTypeId, password);
							assignRole("Secondary Contact", virtualHostId, user);
							spatoContact.setSecondaryPrincipalUserId(String.valueOf(user.getUserId()));
						}

					}
					SPATOContactsLocalServiceUtil.updateSPATOContacts(spatoContact);
				} else if (entry.getValue() instanceof ApprovedMentors) {
					ApprovedMentors mentor = (ApprovedMentors) entry.getValue();
					ServiceContext serviceContext = new ServiceContext();
					serviceContext.setAttribute("userType", "Mentor-Corporate");
					serviceContext.setAttribute("virtualHostId", virtualHostId); // TODO
					
					if(logger.isDebugEnabled()){
						logger.debug("entry.getValue() " + entry.getValue());
					}
					
					if (mentor.isNew()) {
						mentor.setMentorId(CounterLocalServiceUtil.increment("ApprovedMentors"));
						mentor.setOrganizationId(orgId);
						User user = null;
						
						try {
							user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(),
									mentor.getEmail());
						} catch (NoSuchUserException e) {
							logger.error("User not found for mentor, adding user " + mentor.getEmail());
							user = this.addUser(mentor.getEmail(), mentor.getFirstName(), mentor.getLastName(),
									password, false, virtualHostId, subProductTypeId);
							SocialProfileLocalServiceUtil.sendPasswordEmail(user, password, serviceContext);
						}

						if(user != null) {
							assignRole("Mentor-Corporate", virtualHostId, user);
							SPUserTypeLocalServiceUtil.addSPSiteAndUserType("Mentor To Be", virtualHostId, user, productTypeId, subProductTypeId, password);
							mentor.setUserId(String.valueOf(user.getUserId()));
							ApprovedMentorsLocalServiceUtil.updateApprovedMentors(mentor);
						} else {
							logger.error("Invalid user with email address , " + mentor.getEmail());
						}
						
						if(logger.isDebugEnabled()){
							logger.debug("Email of mentor " + mentor.getEmail());
							logger.debug("assigning role Mentor To Be to " + user.getUserId());
						}
					}
					
				} 

			}

		} catch (SystemException e) {
			logger.error("Error while saving organization information orgId" + orgId);
			throw e;
		}
		rootOrg = (rootOrg != null) ? rootOrg : (Organization) map.get(StartupConstants.ATTRIB_ORGANIZATION);
		return rootOrg;
	}

	public String getCurrentUserBaseOrganization(long currentUserId) {

		List<Organization> organizations = this.getUserOrganizations(currentUserId);
		if (organizations.size() > 0) {
			return String.valueOf(organizations.get(0).getOrganizationId());
		} else {
			logger.error("Error while fetching organizations for user " + currentUserId);
			return "0";
		}
	}

	public long getLoggedInUserId() throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		if (null == serviceContext) {
			logger.warn("ServiceContext is unavailable, returning default user");
			long companyId = PortalUtil.getDefaultCompanyId();
			long defaultUserId = UserLocalServiceUtil.getDefaultUserId(companyId);
			return defaultUserId;
		}

		return serviceContext.getUserId();
	}

	public String addPrincipalDetails(String inputString) {
		try {
			inputString = URLDecoder.decode(inputString, "UTF-8");
			JSONObject inputJson = JSONFactoryUtil.createJSONObject(inputString);
			return addPrincipalDetails(inputJson);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return "Error : " + e.getMessage();
		}
	}
	
	public String addPrincipalDetails(JSONObject inputJson) {
		long organizationId = 0;
		try {
			long userId = 0;
			String productTypeId= StringPool.BLANK;
			String subProductTypeId= StringPool.BLANK;
			if (inputJson.has("userId")) {
				userId = inputJson.getLong("userId");
			}
			
			logger.error("addPrincipalDetails inputJson " + inputJson);
			if (inputJson.has("productTypeId")) {
				productTypeId = inputJson.getString("productTypeId");
			}
			
			if (inputJson.has("subProductTypeId")) {
				subProductTypeId = inputJson.getString("subProductTypeId");
			}
			
			organizationId = Long.valueOf(getCurrentUserBaseOrganization(userId));
			String password = PwdGenerator.getPassword();
			if (organizationId > 0) {
				List<SPATOContacts> spatoContacts = SPATOContactsLocalServiceUtil
						.findATOContactsByOrganizationId(organizationId);
				SPATOContacts spatoContact;
				if (spatoContacts.size() > 0) {
					spatoContact = spatoContacts.get(0);
				} else {
					spatoContact = SPATOContactsLocalServiceUtil
							.createSPATOContacts(CounterLocalServiceUtil.increment("SPATOContacts"));
					spatoContact.setOrganizationId(organizationId);
				}
				if(inputJson.has("primaryPrincipalUserEmail") && !inputJson.getString("primaryPrincipalUserEmail").equalsIgnoreCase(StringPool.BLANK)){
				
					User user = null;
					boolean isNew = false;
					String primaryPrincipalUserEmail = inputJson.getString("primaryPrincipalUserEmail");
					try {
						user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(),
								primaryPrincipalUserEmail);
					} catch (NoSuchUserException e) {
						isNew = true;
					}	
					if (user == null) {
						user = this.addUser(primaryPrincipalUserEmail,
								inputJson.getString("primaryPrincipalUserFirstName"),
								inputJson.getString("primaryPrincipalUserLastName"), password,
								inputJson.getInt("primaryPrincipalSalutation"),
								inputJson.getString("primaryPrincipalJobTitle"),
								inputJson.getString("primaryPrincipalMobile"),false,
								inputJson.getString("virtualHostId"),subProductTypeId
								);
						
						logger.error("Added primaryPrincipalUserEmail with userId " + user.getUserId());
					}
					ServiceContext serviceContext = new ServiceContext();
					serviceContext.setAttribute("userType", "Training Principal");
					serviceContext.setAttribute("virtualHostId", inputJson.getString("virtualHostId"));
					spatoContact.setPrimaryPrincipalUserId(String.valueOf(user.getUserId()));
					//spatoContact.setPrimaryTitleId(inputJson.getInt("primaryPrincipalSalutation")); 
					//spatoContact.setPrimaryJobTitle(inputJson.getString("primaryPrincipalJobTitle"));
					//spatoContact.setPrimaryMobile(inputJson.getString("primaryPrincipalMobile"));
					
					logger.error("isNew " + isNew);
							
					SPUserTypeLocalServiceUtil.addSPSiteAndUserType("Training Principal", inputJson.getString("virtualHostId"), user, productTypeId, subProductTypeId, password);
					
					if (isNew) {
						SocialProfileLocalServiceUtil.sendPasswordEmail(user, password, serviceContext);
					} else {
						SocialProfileLocalServiceUtil.sendWelcomeEmail(user, serviceContext);
					}
					
					assignRole("Training Principal", inputJson.getString("virtualHostId"), user);
					
//					Organization org = OrganizationLocalServiceUtil.getOrganization(organizationId);
//					org.setUserId(user.getUserId());
//					org.setModifiedDate(DateUtil.newDate());
//					OrganizationLocalServiceUtil.updateOrganization(org);
					
				}
				
				if(inputJson.has("secondaryPrincipalUserEmail") && !inputJson.getString("secondaryPrincipalUserEmail").equalsIgnoreCase(StringPool.BLANK)){
					String secondaryPrincipalUserEmail = inputJson.getString("secondaryPrincipalUserEmail");
					User user = null;
					boolean isNew = false;
					try {
						user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(),
								secondaryPrincipalUserEmail);
					} catch (NoSuchUserException e) {
						isNew = true;
					}
					if (user == null) {
						user = this.addUser(secondaryPrincipalUserEmail,
								inputJson.getString("secondaryPrincipalUserFirstName"),
								inputJson.getString("secondaryPrincipalUserLastName"), password,
								inputJson.getInt("secondaryPrincipalSalutation"),
								inputJson.getString("secondaryPrincipalJobTitle"),
								inputJson.getString("secondaryPrincipalMobile"), false,
								inputJson.getString("virtualHostId"),subProductTypeId);
						
						logger.error("Added secondary contact with userId " + user.getUserId());
						
					}
					ServiceContext serviceContext = new ServiceContext();
					serviceContext.setAttribute("userType", "Secondary Contact");
					serviceContext.setAttribute("virtualHostId", inputJson.getString("virtualHostId"));
					spatoContact.setSecondaryPrincipalUserId(String.valueOf(user.getUserId()));
					//spatoContact.setSecondaryTitleId(inputJson.getInt("secondaryPrincipalSalutation"));
					//spatoContact.setSecondaryPrincipalJobTitle(inputJson.getString("secondaryPrincipalJobTitle"));
					//spatoContact.setSecondaryPrincipalMobile(inputJson.getString("secondaryPrincipalMobile"));
					
					logger.error("isNew " + isNew);
					
					SPUserTypeLocalServiceUtil.addSPSiteAndUserType("Secondary Contact", inputJson.getString("virtualHostId"), user, productTypeId, subProductTypeId, password);
					
					if (isNew) {
						SocialProfileLocalServiceUtil.sendPasswordEmail(user, password, serviceContext);
					} else {
						SocialProfileLocalServiceUtil.sendWelcomeEmail(user, serviceContext);
					}
					assignRole("Secondary Contact", inputJson.getString("virtualHostId"), user);
				} 
				if(inputJson.has("newMentors") && !inputJson.getString("newMentors").equalsIgnoreCase(StringPool.BLANK)){
					String newMentors = inputJson.getString("newMentors");
					JSONArray mentorsArray = JSONFactoryUtil.createJSONArray(newMentors);
					ServiceContext serviceContext = new ServiceContext();
					logger.error("mentors " + newMentors);
					serviceContext.setAttribute("userType", "Mentor");
					serviceContext.setAttribute("virtualHostId", inputJson.getString("virtualHostId"));
					for (int i = 0; i < mentorsArray.length(); i++) {
						logger.error("Processing mentors" + mentorsArray.toString());
						String mentorEmail = mentorsArray.getJSONObject(i).getString("mentorUserEmail");
						User user = null;
						boolean isNew = false;

						try {
							user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(),
									mentorEmail);
						} catch (NoSuchUserException e) {
							isNew = true;
						}
						if (user == null) {
							user = this.addUser(mentorEmail, mentorsArray.getJSONObject(i).getString("mentorFirstName"),
									mentorsArray.getJSONObject(i).getString("mentorLastName"), password,
									mentorsArray.getJSONObject(i).getInt("panel2Panel2DataGridPanelColumnsTitle"),
									mentorsArray.getJSONObject(i).getString("panel2Panel2DataGridPanelColumns2JobTitle"),
									mentorsArray.getJSONObject(i).getString("panel2Panel2DataGridPanelColumns3Mobilenumber"),false,
									inputJson.getString("virtualHostId"),subProductTypeId);
							logger.error("Added mentor with userId " + user.getUserId());
						}
						logger.error("mentorsCheck with userId " + user.getUserId());
						List<ApprovedMentors> mentorsCheck = ApprovedMentorsLocalServiceUtil.findApprovedMentorsByUserIdAndStatus(user.getUserId(), 1);
						logger.error("mentorsCheck with userId size " + mentorsCheck.size());
						if(mentorsCheck.size() == 0 ){

							ApprovedMentors mentors = ApprovedMentorsLocalServiceUtil
									.createApprovedMentors(CounterLocalServiceUtil.increment("ApprovedMentors"));
							mentors.setUserId(String.valueOf(user.getUserId()));
							//mentors.setSalutation(mentorsArray.getJSONObject(i).getString("panel2Panel2DataGridPanelColumnsTitle"));
							//mentors.setJobTitle(mentorsArray.getJSONObject(i).getString("panel2Panel2DataGridPanelColumns2JobTitle"));
							//mentors.setMobile(mentorsArray.getJSONObject(i).getString("panel2Panel2DataGridPanelColumns3Mobilenumber"));
							mentors.setOrganizationId(organizationId);
							mentors.setStatus(1);
							mentors.setApprovedDate(DateUtil.newDate());
							ApprovedMentorsLocalServiceUtil.updateApprovedMentors(mentors);
							logger.error("Sending email to user for mentor" + user.getUserId() + " isNew " + isNew);
	
							SPUserTypeLocalServiceUtil.addSPSiteAndUserType("Mentor", inputJson.getString("virtualHostId"), user, productTypeId, subProductTypeId, password);
							
							assignRole("Mentor", inputJson.getString("virtualHostId"), user);
							
						}
						if (isNew) {
							SocialProfileLocalServiceUtil.sendPasswordEmail(user, password, serviceContext);
						} else {
							SocialProfileLocalServiceUtil.sendWelcomeEmail(user, serviceContext);
						}
					}
				} 
				
				SPATOContactsLocalServiceUtil.updateSPATOContacts(spatoContact);
				
				if(inputJson.has("companyCountry")){
					List<Address> addresses = AddressLocalServiceUtil.findByOrganizationIdAndHq(organizationId,true);
					Address  address = null;
					if(addresses.size() > 0){
						address = addresses.get(0);
					}else{
						address =  AddressLocalServiceUtil.createAddress(CounterLocalServiceUtil.increment("Address"));
						address.setOrganizationId(organizationId);
						address.setHq(true);
					}
					try{
						PermissionUtil.initializeAdminPermissionChecker();
						Country country = CountryServiceUtil.getCountryByName(inputJson.getString("companyCountry").toLowerCase());
						address.setCountry(String.valueOf(country.getCountryId()));
					}
					catch(Exception e){
						logger.error("SecurityException fetching country " + e.toString());
					}
					address.setPostalCode(inputJson.getString("companyPostalCode"));
					address.setStreet1(inputJson.getString("buildingName"));
					address.setStreet2(inputJson.getString("streetName"));
					address.setStreet4(inputJson.getString("houseBlockNo"));
					
					AddressLocalServiceUtil.updateAddress(address);
				}
				if(inputJson.has("companyWebsite")){
					Organization org = OrganizationLocalServiceUtil.getOrganization(organizationId);
					org.setWebsite(inputJson.getString("companyWebsite"));
					org.setMobile(inputJson.getString("companyContactNumber"));
					org.setDescription(inputJson.getString("companyInfo"));
					OrganizationLocalServiceUtil.updateOrganization(org);
					
				}
				if(inputJson.has("financialStatement")){
					String documentType = "financialStatement";
					ATODocument  document = ATODocumentLocalServiceUtil.createATODocument(CounterLocalServiceUtil.increment("ATODocument"));
					document.setOrganizationId(organizationId);
					document.setDocumentType(documentType); 
					JSONArray js = JSONFactoryUtil.createJSONArray(inputJson.getString(documentType));
					
					document.setDocumentFileId(js.getJSONObject(0).getJSONObject("data").getString("fileEntryId"));
					ATODocumentLocalServiceUtil.updateATODocument(document);
				}
				if(inputJson.has("policy")){
					String documentType = "policy";
					ATODocument  document = ATODocumentLocalServiceUtil.createATODocument(CounterLocalServiceUtil.increment("ATODocument"));
					document.setOrganizationId(organizationId);
					document.setDocumentType(documentType); 
					JSONArray js = JSONFactoryUtil.createJSONArray(inputJson.getString(documentType));
					
					document.setDocumentFileId(js.getJSONObject(0).getJSONObject("data").getString("fileEntryId"));
					ATODocumentLocalServiceUtil.updateATODocument(document);
				}
				if(inputJson.has("businessConduct")){
					String documentType = "businessConduct";
					ATODocument  document = ATODocumentLocalServiceUtil.createATODocument(CounterLocalServiceUtil.increment("ATODocument"));
					document.setOrganizationId(organizationId);
					document.setDocumentType(documentType); 
					JSONArray js = JSONFactoryUtil.createJSONArray(inputJson.getString(documentType));
					
					document.setDocumentFileId(js.getJSONObject(0).getJSONObject("data").getString("fileEntryId"));
					ATODocumentLocalServiceUtil.updateATODocument(document);
				}
				if(inputJson.has("jobDescription")){
					String documentType = "jobDescription";
					ATODocument  document = ATODocumentLocalServiceUtil.createATODocument(CounterLocalServiceUtil.increment("ATODocument"));
					document.setOrganizationId(organizationId);
					document.setDocumentType(documentType); 
					JSONArray js = JSONFactoryUtil.createJSONArray(inputJson.getString(documentType));
					
					document.setDocumentFileId(js.getJSONObject(0).getJSONObject("data").getString("fileEntryId"));
					ATODocumentLocalServiceUtil.updateATODocument(document);
				}
				if(inputJson.has("appraisalForm")){
					String documentType = "appraisalForm";
					ATODocument  document = ATODocumentLocalServiceUtil.createATODocument(CounterLocalServiceUtil.increment("ATODocument"));
					document.setOrganizationId(organizationId);
					document.setDocumentType(documentType); 
					JSONArray js = JSONFactoryUtil.createJSONArray(inputJson.getString(documentType));
					
					document.setDocumentFileId(js.getJSONObject(0).getJSONObject("data").getString("fileEntryId"));
					ATODocumentLocalServiceUtil.updateATODocument(document);
				}
				if(inputJson.has("jobDescriptions")){
					String documentType = "jobDescriptions";
					ATODocument  document = ATODocumentLocalServiceUtil.createATODocument(CounterLocalServiceUtil.increment("ATODocument"));
					document.setOrganizationId(organizationId);
					document.setDocumentType(documentType); 
					JSONArray js = JSONFactoryUtil.createJSONArray(inputJson.getString(documentType));
					
					document.setDocumentFileId(js.getJSONObject(0).getJSONObject("data").getString("fileEntryId"));
					ATODocumentLocalServiceUtil.updateATODocument(document);
				}
				if(inputJson.has("businessRegistration")){
					String documentType = "businessRegistration";
					ATODocument  document = ATODocumentLocalServiceUtil.createATODocument(CounterLocalServiceUtil.increment("ATODocument"));
					document.setOrganizationId(organizationId);
					document.setDocumentType(documentType); 
					JSONArray js = JSONFactoryUtil.createJSONArray(inputJson.getString(documentType));
					
					document.setDocumentFileId(js.getJSONObject(0).getJSONObject("data").getString("fileEntryId"));
					ATODocumentLocalServiceUtil.updateATODocument(document);
				}
				if(inputJson.has("supplementary")){
					String documentType = "supplementary";
					ATODocument  document = ATODocumentLocalServiceUtil.createATODocument(CounterLocalServiceUtil.increment("ATODocument"));
					document.setOrganizationId(organizationId);
					document.setDocumentType(documentType); 
					JSONArray js = JSONFactoryUtil.createJSONArray(inputJson.getString(documentType));
					
					document.setDocumentFileId(js.getJSONObject(0).getJSONObject("data").getString("fileEntryId"));
					ATODocumentLocalServiceUtil.updateATODocument(document);
				}
				
				
				
			} else {
				return "No Base Organization found";
			}

		} catch (SystemException | PortalException e) {
			logger.error(e.getMessage());
			return "Error : " + e.getMessage();
		}
		return "Updated";
	}
	
	public String addMentorToApplication(String jsonString) {
		long organizationId = 0;
		try {
			JSONObject inputJson = JSONFactoryUtil.createJSONObject(jsonString);
			String productTypeId= StringPool.BLANK;
			String subProductTypeId= StringPool.BLANK;
			logger.debug("jsonString " + jsonString);
			if (inputJson.has("productTypeId")) {
				productTypeId = inputJson.getString("productTypeId");
			}
			
			if (inputJson.has("subProductTypeId")) {
				subProductTypeId = inputJson.getString("subProductTypeId");
			}
			if (inputJson.has("organizationId")) {
				organizationId = inputJson.getLong("organizationId");
			}
			JSONObject response = JSONFactoryUtil.createJSONObject();
			String password = PwdGenerator.getPassword();
			if (organizationId > 0) {
				
				if(inputJson.has("isExistingMentor")){
					if(inputJson.getString("isExistingMentor").equalsIgnoreCase("yes")){
						response.put("mentorUserId", inputJson.getString("MentorId"));
						
					}else if(inputJson.getString("isExistingMentor").equalsIgnoreCase("no")){
						
						ServiceContext serviceContext = new ServiceContext();
						logger.error("mentor first name " + inputJson.getString("mentorFirstName"));
						serviceContext.setAttribute("userType", "Mentor");
						serviceContext.setAttribute("virtualHostId", inputJson.getString("virtualHostId"));
						
						String mentorEmail = inputJson.getString("mentorUserEmail");
						User user = null;
						boolean isNew = false;

						try {
							user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(),
									mentorEmail);
						} catch (NoSuchUserException e) {
							isNew = true;
						}
						if (user == null) {
							user = this.addUser(mentorEmail, inputJson.getString("mentorFirstName"),
									inputJson.getString("mentorLastName"), password, false, inputJson.getString("virtualHostId"), subProductTypeId);
							logger.error("Added mentor with userId " + user.getUserId());
						}

						List <ApprovedMentors> checkexistingMentors = ApprovedMentorsLocalServiceUtil.findApprovedMentorsByUserIdAndStatus(user.getUserId(), 1);
						if(checkexistingMentors.size() == 0){
							ApprovedMentors mentors = ApprovedMentorsLocalServiceUtil
									.createApprovedMentors(CounterLocalServiceUtil.increment("ApprovedMentors"));
							mentors.setUserId(String.valueOf(user.getUserId()));
							mentors.setOrganizationId(organizationId);
							ApprovedMentorsLocalServiceUtil.updateApprovedMentors(mentors);
							logger.error("Sending email to user for mentor" + user.getUserId() + " isNew " + isNew);
	
							SPUserTypeLocalServiceUtil.addSPSiteAndUserType("Mentor", inputJson.getString("virtualHostId"), user, productTypeId, subProductTypeId, password);
							
							if (isNew) {
								SocialProfileLocalServiceUtil.sendPasswordEmail(user, password, serviceContext);
							} else {
								SocialProfileLocalServiceUtil.sendWelcomeEmail(user, serviceContext);
							}
						}
						response.put("mentorUserId", user.getUserId());
					}
				} 
				
				return response.toString();
			} else {
				return "No Base Organization found";
			}

		} catch (SystemException | PortalException e) {
			logger.error(e.getMessage());
			return "Error : " + e.getMessage();
		}
		
	}
	
	
	
	public void removeRole(long userId) {
		try {
			User user  = UserLocalServiceUtil.getUser(userId);
			List<Role> roles = user.getRoles();
			for (Role role : SambaashUtil.emptyIfNull(roles)) {
				UserLocalServiceUtil.deleteRoleUser(role.getRoleId(), user);
			}
		} catch (Exception e) {
			logger.error("Failed to remove role for user : " + userId);
		}
	}
	
	private void assignRole(String userType, String virtualHostId, User user) {

		SPUserTypeConfig spUserTypeConfig;
		logger.error("UserType " + userType + " : user id : " + user.getUserId());
		try {
			
			List<Role> roles = user.getRoles();
			
			for (Role role : SambaashUtil.emptyIfNull(roles)) {
				try {
					UserLocalServiceUtil.deleteRoleUser(role.getRoleId(), user);
				} catch (Exception e) {
					logger.error("Failed to remove role " + role.getRoleId() + " : user : " + user.getUserId());
				}
			}
			
			spUserTypeConfig = SPUserTypeConfigLocalServiceUtil.findByUserTypeAndVirtualHostId(userType,
					Long.parseLong(virtualHostId));
			
			if (Validator.isNotNull(spUserTypeConfig) && Validator.isNotNull(spUserTypeConfig.getDefauleRoleIds())) {
				logger.error("role ids " + spUserTypeConfig.getDefauleRoleIds());
				String str[] = spUserTypeConfig.getDefauleRoleIds().split(StringPool.COMMA);
				List<String> al = new ArrayList<String>();
				al = Arrays.asList(str);

				for (String roelId : SambaashUtil.emptyIfNull(al)) {
					logger.error("assigning role " + roelId + " to user id " + user.getUserId());
					try {
						UserLocalServiceUtil.addRoleUser(Long.parseLong(roelId), user.getUserId());
					} catch (NumberFormatException | SystemException e) {
						logger.error(e.getMessage());
					}
				}
			} else {
				logger.error("No default role value in SPUserTypeConfig  for " + userType);
			}
		} catch (NumberFormatException | SystemException e) {
			logger.error("Failed to assign role : " + e.getMessage());
		}

	}

	public String updatePrinciples(String inputString) {

		try {
			inputString = URLDecoder.decode(inputString, "UTF-8");
			JSONObject inputJson = JSONFactoryUtil.createJSONObject(inputString);
			long userId = 0;
			if (inputJson.has("userId")) {
				userId = inputJson.getLong("userId");
			}
			long organizationId = Long.valueOf(getCurrentUserBaseOrganization(userId));
			// List<Guidelines> guidelines =
			// GuidelinesLocalServiceUtil.findByOrganizationId(organizationId);
			// List<SPATOContacts> spatoContacts =
			// SPATOContactsLocalServiceUtil.findATOContactsByOrganizationId(organizationId);
			String moreInfo = inputJson.getString("moreInfo");
			boolean g1 = false;
			boolean g2 = false;
			boolean g3 = false;
			boolean g4 = false;
			boolean g5 = false;
			
			
			
			boolean g6 = false;
			boolean g7 = false;
			boolean g8 = false;
			for (int i = 1; i < 5; i++) {

				if (inputJson.has("p" + i + "guideline1")) {
					g1 = inputJson.getBoolean("p" + i + "guideline1");
				}
				if (inputJson.has("p" + i + "guideline2")) {
					g2 = inputJson.getBoolean("p" + i + "guideline2");
				}
				if (inputJson.has("p" + i + "guideline3")) {
					g3 = inputJson.getBoolean("p" + i + "guideline3");
				}
				if (inputJson.has("p" + i + "guideline4")) {
					g4 = inputJson.getBoolean("p" + i + "guideline4");
				}
				if (inputJson.has("p" + i + "guideline5")) {
					g5 = inputJson.getBoolean("p" + i + "guideline5");
				}
				if (inputJson.has("p" + i + "guideline6")) {
					g6 = inputJson.getBoolean("p" + i + "guideline6");
				}
				if (inputJson.has("p" + i + "guideline7")) {
					g7 = inputJson.getBoolean("p" + i + "guideline7");
				}
				if (inputJson.has("p" + i + "guideline8")) {
					g8 = inputJson.getBoolean("p" + i + "guideline8");
				}
				List<Guidelines> guidelines = GuidelinesLocalServiceUtil
						.findByOrganizationAndPrincipleId(organizationId, i);
				Guidelines guideline;
				if (guidelines != null && guidelines.size() > 0) {
					guideline = guidelines.get(0);
				} else {
					guideline = GuidelinesLocalServiceUtil
							.createGuidelines(CounterLocalServiceUtil.increment("Guidelines"));
					guideline.setOrganizationId(organizationId);
					guideline.setPrincipleId(i);
				}
				guideline.setGuideline1(g1);
				guideline.setGuideline2(g2);
				guideline.setGuideline3(g3);
				guideline.setGuideline4(g4);
				guideline.setGuideline5(g5);
				guideline.setGuideline6(g6);
				guideline.setGuideline7(g7);
				guideline.setGuideline8(g8);
				if(i == 1){
					guideline.setMoreInfo(moreInfo);
				}
				GuidelinesLocalServiceUtil.updateGuidelines(guideline);

			}

		} catch (SystemException | JSONException | UnsupportedEncodingException e) {
			logger.error(e.getMessage());
			return "Error";
		}
		return "Updated";

	}

	public String updateEmployeeInfo(String inputString) {

		try {
			inputString = URLDecoder.decode(inputString, "UTF-8");
			JSONObject inputJson = JSONFactoryUtil.createJSONObject(inputString);
			long userId = 0;
			if (inputJson.has("userId")) {
				userId = inputJson.getLong("userId");
			}
			long organizationId = Long.valueOf(getCurrentUserBaseOrganization(userId));
			List<EmployeeInfo> employeeInfos = EmployeeInfoLocalServiceUtil.findByOrganizationId(organizationId);
			EmployeeInfo employeeInfo;
			if (employeeInfos.size() > 0) {
				employeeInfo = employeeInfos.get(0);
			} else {
				employeeInfo = EmployeeInfoLocalServiceUtil
						.createEmployeeInfo(CounterLocalServiceUtil.increment("EmployeeInfo"));
				employeeInfo.setOrganizationId(organizationId);
			}
			if(!inputJson.getString("employees").equalsIgnoreCase("0")){
				employeeInfo.setEmployees(inputJson.getString("employees"));
			}
			if(!inputJson.getString("Directors").equalsIgnoreCase("0")){
				employeeInfo.setDirectors(inputJson.getString("Directors"));
			}
			if(!inputJson.getString("FinanceEmployees").equalsIgnoreCase("0")){
				employeeInfo.setFinanceEmployees(inputJson.getString("FinanceEmployees"));
			}
			if(!inputJson.getString("ProfessionalCandidates").equalsIgnoreCase("0")){
				employeeInfo.setProfessionalCandidates(inputJson.getString("ProfessionalCandidates"));
			}
			if(!inputJson.getString("FoundationCandidates").equalsIgnoreCase("0")){
				employeeInfo.setFoundationCandidates(inputJson.getString("FoundationCandidates"));
			}
			if(!inputJson.getString("AccountancyCandidates").equalsIgnoreCase("0")){
				employeeInfo.setAccountancyCandidates(inputJson.getString("AccountancyCandidates"));
			}
			if(!inputJson.getString("ISCAAccountants").equalsIgnoreCase("0")){
				employeeInfo.setISCAAccountants(inputJson.getString("ISCAAccountants"));
			}
			if(!inputJson.getString("setICASAccountants").equalsIgnoreCase("0")){
				employeeInfo.setICASAccountants(inputJson.getString("ICASAccountants"));
			}
			if(!inputJson.getString("ICAEWAccountants").equalsIgnoreCase("0")){
				employeeInfo.setICAEWAccountants(inputJson.getString("ICAEWAccountants"));
			}
			if(!inputJson.getString("CAIAccountants").equalsIgnoreCase("0")){
				employeeInfo.setCAIAccountants(inputJson.getString("CAIAccountants"));
			}
			if(!inputJson.getString("ACCAAccountants").equalsIgnoreCase("0")){
				employeeInfo.setACCAAccountants(inputJson.getString("ACCAAccountants"));
			}
			if(!inputJson.getString("CPAAccountants").equalsIgnoreCase("0")){
				employeeInfo.setCPAAccountants(inputJson.getString("CPAAccountants"));
			}
			if(!inputJson.getString("CAANZAccountants").equalsIgnoreCase("0")){
				employeeInfo.setCAANZAccountants(inputJson.getString("CAANZAccountants"));
			}
			
			if(!inputJson.getString("CPACanadaAccountants").equalsIgnoreCase("0")){
				employeeInfo.setCPACanadaAccountants(inputJson.getString("CPACanadaAccountants"));
			}
			if(!inputJson.getString("HKCPAAccountants").equalsIgnoreCase("0")){
				employeeInfo.setHKCPAAccountants(inputJson.getString("HKCPAAccountants"));
			}
			if(!inputJson.getString("SAICAAccountants").equalsIgnoreCase("0")){
				employeeInfo.setSAICAAccountants(inputJson.getString("SAICAAccountants"));
			}
			if(!inputJson.getString("JICPAAccountants").equalsIgnoreCase("0")){
				employeeInfo.setJICPAAccountants(inputJson.getString("JICPAAccountants"));
			}
			if(!inputJson.getString("AICPAAccountants").equalsIgnoreCase("0")){
				employeeInfo.setAICPAAccountants(inputJson.getString("AICPAAccountants"));
			}
			if(!inputJson.getString("CIMAAccountants").equalsIgnoreCase("0")){
				employeeInfo.setCIMAAccountants(inputJson.getString("CIMAAccountants"));
			}
			if(!inputJson.getString("OthersAccountants").equalsIgnoreCase("0")){
				employeeInfo.setOthersAccountants(inputJson.getString("OthersAccountants"));
			}
			
			EmployeeInfoLocalServiceUtil.updateEmployeeInfo(employeeInfo);

		} catch (SystemException | PortalException | UnsupportedEncodingException e) {
			logger.error(e.getMessage());
			return "Error";
		}
		return "Updated";
	}

	public String updateAccreditation(String inputString) {

		try {
			inputString = URLDecoder.decode(inputString, "UTF-8");
			JSONObject inputJson = JSONFactoryUtil.createJSONObject(inputString);
			long userId = 0;
			if (inputJson.has("userId")) {
				userId = inputJson.getLong("userId");
			}
			long organizationId = Long.valueOf(getCurrentUserBaseOrganization(userId));
			List<Accreditation> accreditations = AccreditationLocalServiceUtil.findByOrganizationId(organizationId);
			Accreditation accreditation;
			if (accreditations.size() > 0) {
				accreditation = accreditations.get(0);
			} else {
				accreditation = AccreditationLocalServiceUtil
						.createAccreditation(CounterLocalServiceUtil.increment("Accreditation"));
				accreditation.setOrganizationId(organizationId);

			}
			accreditation.setAselected(inputJson.getBoolean("aSelected"));
			accreditation.setAvalue(inputJson.getString("aValue"));
			accreditation.setBselected(inputJson.getBoolean("bSelected"));
			accreditation.setBvalue(inputJson.getString("bValue"));
			accreditation.setCselected(inputJson.getBoolean("cSelected"));
			accreditation.setCvalue(inputJson.getString("cValue"));
			accreditation.setCsamepolicy(inputJson.getBoolean("cSamepolicy"));
			accreditation.setCcompanyName(inputJson.getString("cCompanyName"));
			accreditation.setCelaborate(inputJson.getString("cElaborate"));
			accreditation.setDselected(inputJson.getBoolean("dSelected"));
			accreditation.setDvalue(inputJson.getString("dValue"));

			AccreditationLocalServiceUtil.updateAccreditation(accreditation);

		} catch (SystemException | PortalException | UnsupportedEncodingException e) {
			logger.error(e.getMessage());
			return "Error";
		}
		return "Updated";
	}
	

	protected User addUser(String emailAddress, String firstName, String lastName, String password, boolean sendEmail, String virtualHostId, String subProductTypeId) {

		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setUuid(UUID.randomUUID().toString());
		serviceContext.setCreateDate(DateUtil.newDate());

		User user = null;
		try {

			PermissionChecker orgPermissionChecker = PermissionThreadLocal.getPermissionChecker();

			PermissionUtil.initializeAdminPermissionChecker();

			logger.error("addUser Send Mail : " + sendEmail);
			user = SocialProfileLocalServiceUtil.addUserPlatform(firstName, lastName, emailAddress, password, false,
					serviceContext);
			
			PermissionThreadLocal.setPermissionChecker(orgPermissionChecker);
			
			if (StringUtils.isNotEmpty(virtualHostId)) {
				logger.error("Setting Site membership for virtualhostId " + virtualHostId);
				SPAuthenticationUtil.addSiteMembership(user.getUserId(), Long.parseLong(virtualHostId));
			}
			
			SPAuthenticationUtil.addOrUpdateSPSiteUser(Long.parseLong(virtualHostId), subProductTypeId, user, password);

		} catch (Exception e) {
			logger.error(e);
		}

		return user;
	}
	protected User addUser(String emailAddress, String firstName, String lastName, String password,int titleId,String jobTitle,String mobile, boolean sendEmail, String virtualHostId, String subProductTypeId) {

		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setUuid(UUID.randomUUID().toString());
		serviceContext.setCreateDate(DateUtil.newDate());

		User user = null;
		try {

			PermissionChecker orgPermissionChecker = PermissionThreadLocal.getPermissionChecker();

			PermissionUtil.initializeAdminPermissionChecker();

			logger.error("addUser Send Mail : " + sendEmail);
			user = SocialProfileLocalServiceUtil.addUserPlatform(firstName, lastName, emailAddress, password, false,
					serviceContext);
			Contact contact = user.getContact();
			contact.setPrefixId(titleId);
			contact.setJobTitle(jobTitle);
			contact.setSmsSn(mobile);
			ContactLocalServiceUtil.updateContact(contact);
			PermissionThreadLocal.setPermissionChecker(orgPermissionChecker);

			if (StringUtils.isNotEmpty(virtualHostId)) {
				logger.error("Setting Site membership for virtualhostId " + virtualHostId);
				SPAuthenticationUtil.addSiteMembership(user.getUserId(), Long.parseLong(virtualHostId));
			}

			SPAuthenticationUtil.addOrUpdateSPSiteUser(Long.parseLong(virtualHostId), subProductTypeId, user, password);
		} catch (Exception e) {
			logger.error(e);
		}

		return user;
	}
	public void updateAssets(long userId, Organization org, long[] assetCategoryIds)
			throws PortalException, SystemException {

		boolean visible = true;

		assetEntryLocalService.updateEntry(userId, org.getGroupId(), Organization.class.getName(),
				org.getOrganizationId(), org.getUuid(), 0, assetCategoryIds, null, visible, null, null,
				org.getCreateDate(), null, ContentTypes.TEXT_HTML, null, null, null, null, null, 0, 0, null, false);
	}

	public void updateAssets(long userId, Organization org, long[] assetCategoryIds, String[] tagNames)
			throws PortalException, SystemException {
		assetEntryLocalService.updateEntry(userId, org.getGroupId(), org.getCreateDate(), org.getModifiedDate(),
				Organization.class.getName(), org.getOrganizationId(), org.getUuid(), 0, assetCategoryIds, tagNames,
				true, null, null, null, ContentTypes.TEXT_HTML, null, null, null, null, null, 0, 0, null, false);
	}

	public List<Organization> getAllActiveOrganizations() {
		List<Organization> orgs = null;
		try {
			orgs = organizationPersistence.findBybaseOrgAndActive(true, true);
		} catch (Exception e) {
			logger.error(e);
		}
		return orgs;
	}

	public Map<String, Object> createOrgDataMap(long organizationId) throws SystemException, PortalException {
		Map<String, Object> existingMap = new HashMap<String, Object>();
		Organization org = organizationLocalService.getOrganization(organizationId);
		existingMap.put(StartupConstants.ATTRIB_ORGANIZATION, org);
		List<Address> addresses = this.getAddresses(organizationId);
		List<SPOrgContactUs> contacts = this.getContacts(organizationId);
		int i = 1;
		if (addresses != null) {
			for (Address address : addresses) {
				// if (address.isHq()) {
				// existingMap.put(StartupConstants.ATTRIB_HQ, address);
				// } else {
				// existingMap.put(StartupConstants.ATTRIB_OFFICE + i++,
				// address);
				// }
				
				if(address.isHq()){
					try {
						existingMap.put("Country",StringPool.BLANK);
						PermissionUtil.initializeAdminPermissionChecker();
						Country country = CountryServiceUtil.fetchCountry(Long.valueOf(address.getCountry()));
						String countryName = country.getName();
						existingMap.put("Country", countryName.substring(0, 1).toUpperCase() + countryName.substring(1) );
					} catch (Exception e) {
						logger.error("SecurityException fetching country " + e.toString());
					}
					
				}
				existingMap.put(StartupConstants.ATTRIB_ADDRESS + i++, address);
			}
		}
		i = 1;
		if (contacts != null) {
			for (SPOrgContactUs contact : contacts) {
				existingMap.put(StartupConstants.ATTRIB_CONTACT + i++, contact);
			}
		}
		// i = 1;
		// List<Person> persons = this.getBoardAndAdvisory(organizationId);
		// if (Validator.isNotNull(persons)) {
		// for (Person person : persons) {
		// existingMap.put(StartupConstants.ATTRIB_BOARD_MEMBER + i++,
		// person);
		// }
		// }

		i = 1;
		List<Person> persons = this.getTeamMembers(organizationId);
		if (Validator.isNotNull(persons)) {
			for (Person person : persons) {
				existingMap.put(StartupConstants.ATTRIB_TEAM_MEMBER + i++, person);
			}
		}

		List<FundingRound> frs = this.getFundingRounds(organizationId);
		i = 1;
		if (Validator.isNotNull(frs)) {
			for (FundingRound fundingRound : frs) {
				existingMap.put(StartupConstants.ATTRIB_FUNDING_ROUND + i++, fundingRound);
			}
		}

		List<Questionnaire> quess = this.getQuestionnaire(organizationId);
		i = 1;
		if (Validator.isNotNull(quess)) {
			for (Questionnaire q : quess) {
				existingMap.put(StartupConstants.ATTRIB_QUESTIONNAIRE, q);
			}
		}
		Accreditation accreditation = this.getAccreditation(organizationId);
		i = 1;
		if (Validator.isNotNull(accreditation)) {
			existingMap.put(StartupConstants.ATTRIB_ACCREDITATION, accreditation);
		}

		List<Guidelines> guidelines = this.getGuidelines(organizationId);
		i = 1;
		if (Validator.isNotNull(guidelines)) {
			for (Guidelines q : guidelines) {
				existingMap.put(StartupConstants.ATTRIB_GUIDELINES + q.getPrincipleId(), q);
			}
		}
		List<ApprovedMentors> mentors = this.getMentors(organizationId);
		i = 1;
		if (Validator.isNotNull(mentors)) {
			JSONArray ar = JSONFactoryUtil.createJSONArray();
			for (ApprovedMentors q : mentors) {
				String jsonString = JSONFactoryUtil.looseSerializeDeep(q);
				JSONObject js = JSONFactoryUtil.createJSONObject(jsonString);
				ar.put(js);
				existingMap.put(StartupConstants.ATTRIB_APPROVED_MENTORS + q.getMentorId(), q);
			}
			existingMap.put(StartupConstants.ATTRIB_APPROVED_MENTORS , mentors);
			existingMap.put("mentors" , ar);
		}
		List<ATODocument> aTODocuments = this.getATODocuments(organizationId);
		i = 1;
		
		if (Validator.isNotNull(aTODocuments)) {
			JSONArray ar = JSONFactoryUtil.createJSONArray();
			for (ATODocument q : aTODocuments) {
				String jsonString = JSONFactoryUtil.looseSerializeDeep(q);
				JSONObject js = JSONFactoryUtil.createJSONObject(jsonString);
				try{
					DLFileEntry dl = DLFileEntryLocalServiceUtil.getFileEntry(js.getLong("documentFileId"));
					String url = "/documents/" + org.getGroupId() + StringPool.SLASH + dl.getUuid();
					js.put("url", url);
					js.put("title", dl.getTitle());
					ar.put(js);
				}
				catch(Exception e){
					logger.error("file not found " + js.getLong("documentFileId"));
				}
			}
			existingMap.put(StartupConstants.ATTRIB_ATO_DOCUMENT , ar);
		}

		EmployeeInfo employmentInfo = this.getEmployeeInfo(organizationId);

		if (Validator.isNotNull(employmentInfo)) {
			existingMap.put(StartupConstants.ATTRIB_EMPLOYEE_INFO, employmentInfo);
		}

		SPATOContacts spAtoContacts = this.getSPATOContacts(organizationId);

		if (Validator.isNotNull(spAtoContacts)) {
			existingMap.put(StartupConstants.ATTRIB_SPATO_CONTACTS, spAtoContacts);
		}

		existingMap.put(StartupConstants.ATTRIB_FILLED_BY, this.getFilledBy(organizationId));

		return existingMap;
	}

	public void clearCache(Organization org) {
		organizationPersistence.clearCache(org);
	}

	@SuppressWarnings("unchecked")
	public List<Address> getOfficeAddresses(long orgId) {

		List<Address> list = null;
		try {

			DynamicQuery dynaQuery = DynamicQueryFactoryUtil.forClass(Address.class, this.getClass().getClassLoader())
					.add(PropertyFactoryUtil.forName("organizationId").eq(orgId))
					.add(PropertyFactoryUtil.forName("active").eq(true));
			list = AddressLocalServiceUtil.dynamicQuery(dynaQuery);
		} catch (Exception e) {
			logger.error("Error retrieving office addresses", e);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public Address getOfficeHeadQuaterAddress(long orgId) {
		Address hq = null;
		try {

			DynamicQuery dynaQuery = DynamicQueryFactoryUtil.forClass(Address.class, this.getClass().getClassLoader())
					.add(PropertyFactoryUtil.forName("organizationId").eq(orgId))
					.add(PropertyFactoryUtil.forName("active").eq(true))
					.add(PropertyFactoryUtil.forName("hq").eq(true));

			List<Address> list = AddressLocalServiceUtil.dynamicQuery(dynaQuery);
			if (!list.isEmpty()) {
				hq = list.get(0);
			}
		} catch (Exception e) {
			logger.error("Error while fetching office head quarters address for orgId" + orgId, e);
		}
		return hq;
	}

	public void reIndex(Organization org) {
		Indexer indexer = IndexerRegistryUtil.getIndexer(Organization.class.getName());
		if (indexer != null) {
			try {
				indexer.reindex(org);
			} catch (SearchException se) {
				logger.error("Error while indexing Startup Profile " + org, se);
			} catch (Exception se) {
				logger.error("Error while indexing Startup Profile " + org, se);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<FundingRound> getFundingRounds(long orgId) {

		List<FundingRound> list = null;
		try {
			DynamicQuery dynaQuery = DynamicQueryFactoryUtil
					.forClass(FundingRound.class, this.getClass().getClassLoader())
					.add(PropertyFactoryUtil.forName("organizationId").eq(orgId))
					.add(PropertyFactoryUtil.forName("active").eq(true));

			list = FundingRoundLocalServiceUtil.dynamicQuery(dynaQuery);
		} catch (Exception e) {
			logger.error("Error retrieving fundingrounds", e);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<SPOrgContactUs> getContacts(long orgId) {

		List<SPOrgContactUs> list = null;
		try {
			DynamicQuery dynaQuery = DynamicQueryFactoryUtil
					.forClass(SPOrgContactUs.class, this.getClass().getClassLoader())
					.add(PropertyFactoryUtil.forName("organizationId").eq(orgId));
			// .add(PropertyFactoryUtil.forName("active").eq(true)

			list = SPOrgContactUsLocalServiceUtil.dynamicQuery(dynaQuery);
		} catch (Exception e) {
			logger.error("Error retrieving fundingrounds", e);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Address> getAddresses(long orgId) {

		List<Address> list = null;
		try {
			DynamicQuery dynaQuery = DynamicQueryFactoryUtil.forClass(Address.class, this.getClass().getClassLoader())
					.add(PropertyFactoryUtil.forName("organizationId").eq(orgId))
					.add(PropertyFactoryUtil.forName("active").eq(true));

			list = AddressLocalServiceUtil.dynamicQuery(dynaQuery);
		} catch (Exception e) {
			logger.error("Error retrieving fundingrounds", e);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Questionnaire> getQuestionnaire(long orgId) {
		List<Questionnaire> list = null;
		try {
			DynamicQuery dynaQuery = DynamicQueryFactoryUtil
					.forClass(Questionnaire.class, this.getClass().getClassLoader())
					.add(PropertyFactoryUtil.forName("entryClassPK").eq(orgId))
					.add(PropertyFactoryUtil.forName("entryClassName")
							.eq("com.sambaash.platform.srv.startupprofile.model.Organization"));

			list = QuestionnaireLocalServiceUtil.dynamicQuery(dynaQuery);
		} catch (Exception e) {
			list = new ArrayList<>();
		}

		return list;
	}

	@SuppressWarnings("unchecked")
	public Accreditation getAccreditation(long orgId) {
		List<Accreditation> list = null;
		try {
			DynamicQuery dynaQuery = DynamicQueryFactoryUtil
					.forClass(Accreditation.class, this.getClass().getClassLoader())
					.add(PropertyFactoryUtil.forName("organizationId").eq(orgId));

			list = AccreditationLocalServiceUtil.dynamicQuery(dynaQuery);
		} catch (Exception e) {
			list = new ArrayList<>();
		}
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Guidelines> getGuidelines(long orgId) {
		List<Guidelines> list = null;
		try {
			DynamicQuery dynaQuery = DynamicQueryFactoryUtil
					.forClass(Guidelines.class, this.getClass().getClassLoader())
					.add(PropertyFactoryUtil.forName("organizationId").eq(orgId));

			list = GuidelinesLocalServiceUtil.dynamicQuery(dynaQuery);
		} catch (Exception e) {
			list = new ArrayList<>();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<ApprovedMentors> getMentors(long orgId) {
		List<ApprovedMentors> list = null;
		try {
			DynamicQuery dynaQuery = DynamicQueryFactoryUtil
					.forClass(ApprovedMentors.class, this.getClass().getClassLoader())
					.add(PropertyFactoryUtil.forName("organizationId").eq(orgId));

			list = ApprovedMentorsLocalServiceUtil.dynamicQuery(dynaQuery);
			for(int i = 0; i < list.size(); i++){
				User user = UserLocalServiceUtil.getUser(Long.parseLong(list.get(i).getUserId()));
				list.get(i).setFirstName(user.getFirstName());
				list.get(i).setLastName(user.getLastName());
				list.get(i).setEmail(user.getEmailAddress());
				
				list.get(i).setJobTitle(user.getContact().getJobTitle());
				list.get(i).setTitleId(user.getContact().getPrefixId());
				list.get(i).setMobile(user.getContact().getSmsSn());
			}
		} catch (Exception e) {
			list = new ArrayList<>();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<ApprovedMentors> getApprovedMentors(long orgId) {
		List<ApprovedMentors> list = null;
		try {
			DynamicQuery dynaQuery = DynamicQueryFactoryUtil
					.forClass(ApprovedMentors.class, PortletClassLoaderUtil.getClassLoader(PORTLET_ID))
					.add(PropertyFactoryUtil.forName("organizationId").eq(orgId));
			dynaQuery.add(RestrictionsFactoryUtil.eq("status", 1));
			list = ApprovedMentorsLocalServiceUtil.dynamicQuery(dynaQuery);
		} catch (Exception e) {
			list = new ArrayList<>();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public EmployeeInfo getEmployeeInfo(long orgId) {
		List<EmployeeInfo> list = null;
		try {
			DynamicQuery dynaQuery = DynamicQueryFactoryUtil
					.forClass(EmployeeInfo.class, this.getClass().getClassLoader())
					.add(PropertyFactoryUtil.forName("organizationId").eq(orgId));

			list = EmployeeInfoLocalServiceUtil.dynamicQuery(dynaQuery);
		} catch (Exception e) {
			list = new ArrayList<>();
		}
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public SPATOContacts getSPATOContacts(long orgId) {
		List<SPATOContacts> list = null;
		try {
			DynamicQuery dynaQuery = DynamicQueryFactoryUtil
					.forClass(SPATOContacts.class, this.getClass().getClassLoader())
					.add(PropertyFactoryUtil.forName("organizationId").eq(orgId));

			list = SPATOContactsLocalServiceUtil.dynamicQuery(dynaQuery);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		if (Validator.isNotNull(list) && list.size() > 0) {

			SPATOContacts spATOContact = list.get(0);
			try {
				User tp = UserLocalServiceUtil.getUser(Long.parseLong(spATOContact.getPrimaryPrincipalUserId()));
				User sc = UserLocalServiceUtil.getUser(Long.parseLong(spATOContact.getSecondaryPrincipalUserId()));

				spATOContact.setPrimaryPrincipalUserFirstName(tp.getFirstName());
				spATOContact.setPrimaryPrincipalUserLastName(tp.getLastName());
				spATOContact.setPrimaryPrincipalUserEmail(tp.getEmailAddress());
				spATOContact.setPrimaryJobTitle(tp.getContact().getJobTitle());
				spATOContact.setPrimaryTitleId(tp.getContact().getPrefixId());
				spATOContact.setPrimaryMobile(tp.getContact().getSmsSn());

				spATOContact.setSecondaryPrincipalUserFirstName(sc.getFirstName());
				spATOContact.setSecondaryPrincipalUserLastName(sc.getLastName());
				spATOContact.setSecondaryPrincipalUserEmail(sc.getEmailAddress());
				spATOContact.setSecondaryJobTitle(sc.getContact().getJobTitle());
				spATOContact.setSecondaryTitleId(sc.getContact().getPrefixId());
				spATOContact.setSecondaryMobile(sc.getContact().getSmsSn());

			} catch (NumberFormatException | PortalException | SystemException e) {
				logger.error(String.format("Failed to get user for spATOContact %s, %s ",
						spATOContact.getSpATOContactId(), e.getMessage()));
			}
			return spATOContact;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<ATODocument> getATODocuments(long orgId) {
		List<ATODocument> list = null;
		try {
			DynamicQuery dynaQuery = DynamicQueryFactoryUtil
					.forClass(ATODocument.class, this.getClass().getClassLoader())
					.add(PropertyFactoryUtil.forName("organizationId").eq(orgId));

			list = ATODocumentLocalServiceUtil.dynamicQuery(dynaQuery);
		} catch (Exception e) {
			list = new ArrayList<>();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Person> getFounders(long orgId) {
		return this.getRelation(orgId, DBConstants.RELATION_FOUNDER, DBConstants.REF_TYPE_PERSON_ID);
	}

	@SuppressWarnings("unchecked")
	public List<Person> getBoardAndAdvisory(long orgId) {
		return this.getRelation(orgId, DBConstants.RELATION_BOARD_AND_ADVISORY, DBConstants.REF_TYPE_PERSON_ID);
	}

	@SuppressWarnings("unchecked")
	public List<Person> getTeamMembers(long orgId) {
		return this.getRelation(orgId, DBConstants.RELATION_TEAM_MEMBER, DBConstants.REF_TYPE_PERSON_ID);
	}

	public Person getFilledBy(long orgId) {
		try {
			return (Person) this.getRelation(orgId, DBConstants.RELATION_FILLED_BY, DBConstants.REF_TYPE_PERSON_ID)
					.get(0);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Organization> getCompetitors(long orgId) {
		return this.getRelation(orgId, DBConstants.RELATION_COMPETITOR, DBConstants.REF_TYPE_ORGANIZATION_ID);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Object> getInvestors(long orgId) {
		List list = new ArrayList();
		// need enhancement..in future investors can be both persons and
		// companies
		// list.addAll(this.getRelation(orgId,
		// DBConstants.RELATION_INVESTOR_PERSON,
		// DBConstants.REF_TYPE_PERSON_ID));
		list.addAll(
				this.getRelation(orgId, DBConstants.RELATION_INVESTOR_COMPANY, DBConstants.REF_TYPE_ORGANIZATION_ID));
		return list;
	}

	/**
	 * @see DBConstants
	 *
	 * @param orgId
	 * @param refTypeId
	 *            e.g. person/organization
	 * @param relation
	 *            e.g. For person:- founder, investor, boardmember...for org
	 *            e.g. competitor, investor
	 * @param date
	 * @return
	 * @throws Exception
	 */
	private Relationship createNewRelationship(long orgId, long refTypeId, long relation, Date date)
			throws SystemException {
		long relId = CounterLocalServiceUtil.increment("Relationship");
		Relationship relationship = RelationshipLocalServiceUtil.createRelationship(relId);
		relationship.setActive(true);
		relationship.setCreateDate(date);
		relationship.setModifiedDate(date);
		relationship.setOrganizationId(orgId);
		relationship.setRefTypeId(refTypeId);
		relationship.setRelation(relation);
		logger.debug("creating new relation for orgId " + orgId + " -> " + relationship);
		return relationship;
	}

	@SuppressWarnings("rawtypes")
	private List getRelation(long orgId, long relation, long refTypeId) {

		List list = null;
		try {
			DynamicQuery dynaQuery = null;
			Property refProp = null;
			if (DBConstants.REF_TYPE_PERSON_ID.equals(refTypeId)) {
				dynaQuery = DynamicQueryFactoryUtil.forClass(Person.class, this.getClass().getClassLoader());
				refProp = PropertyFactoryUtil.forName("personId");
			} else {
				dynaQuery = DynamicQueryFactoryUtil.forClass(Organization.class, this.getClass().getClassLoader());
				refProp = PropertyFactoryUtil.forName("organizationId");
			}

			Criterion activeCrit = PropertyFactoryUtil.forName("active").eq(true);

			dynaQuery.add(activeCrit)
					.add(refProp
							.in(DynamicQueryFactoryUtil.forClass(Relationship.class, this.getClass().getClassLoader())
									.add(activeCrit).add(PropertyFactoryUtil.forName("relation").eq(relation))
									.add(PropertyFactoryUtil.forName("refTypeId").eq(refTypeId))
									.add(PropertyFactoryUtil.forName("organizationId").eq(orgId))
									.setProjection(ProjectionFactoryUtil.property("refId"))));

			list = FundingRoundLocalServiceUtil.dynamicQuery(dynaQuery);
		} catch (Exception e) {
			logger.error("Error retrieving fundingrounds", e);
		}
		return list;
	}

	public boolean isOrganizationExistsWithName(String orgName) {
		List<Organization> list = null;
		try {
			list = organizationPersistence.findByStartupName(orgName);
			if (list.size() > 0) {
				return true;
			}
		} catch (Exception ex) {
			logger.error("Error while check organization name", ex);
		}
		return false;
	}

	public List<Organization> findByUENNumber(String uen) {
		try {
			return organizationPersistence.findByUENNumber(uen);
		} catch (SystemException e) {
			logger.error("Error while fetching organization by uen", e);
		}
		return new ArrayList<Organization>();
	}

	public boolean isOrganizationExistsWithUEN(String uen) {
		List<Organization> list = null;
		try {
			list = organizationPersistence.findByUENNumber(uen);
			if (list.size() > 0) {
				return true;
			}
		} catch (Exception ex) {
			logger.error("Error while check organization uen", ex);
		}
		return false;
	}

	public Organization findByName(String orgName) throws SystemException {
		List<Organization> list = organizationPersistence.findByStartupName(orgName);
		if (list.size() > 0) {
			return list.get(0);
		}

		return null;
	}

	public List<Organization> getUserOrganizations(Long userId) {
		List<Organization> list = null;
		try {
			list = organizationPersistence.findByUserId(userId);
		} catch (Exception ex) {
			logger.error("Error while getting user organizations", ex);
		}
		return list;
	}

	public String displayFriendlyURL(ThemeDisplay themeDisplay, long orgId) {
		return StartupProfileHelper.displayStartupDetailsFriendlyURL(themeDisplay, orgId);
	}

	public String applicationFriendlyURL(ThemeDisplay themeDisplay) {
		long orgId = 0;
		for (Organization org : getUserOrganizations(themeDisplay.getUserId())) {
			orgId = org.getOrganizationId();
			break;
		}
		return applicationFriendlyURL(themeDisplay, orgId);
	}

	public String applicationFriendlyURL(ThemeDisplay themeDisplay, long orgId) {
		return StartupProfileHelper.displayStartupApplicationsFriendlyURL(themeDisplay, orgId);
	}

	public String editFriendlyURL(ThemeDisplay themeDisplay, long orgId) {
		return StartupProfileHelper.editStartupFriendlyURL(themeDisplay, orgId);
	}

	public String createFriendlyURL(ThemeDisplay themeDisplay) {
		return StartupProfileHelper.createStartupFriendlyURL(themeDisplay);
	}

	public String exportStartupDetails(ThemeDisplay themeDisplay, Organization org, SPChallengeApplicant applicaiton)
			throws PortalException, SystemException {

		String portalUrl = themeDisplay.getPortalURL();
		long orgId = org.getOrganizationId();
		ReportPayload payload = new ReportPayload();
		ReportGenerator generator = ReportGenerator.getPdfGenerator("startupProfileDetails");

		String fileName = StringPool.BLANK;
		ReportSections sections = null;
		ReportSection section = null;
		User user = UserLocalServiceUtil.getUser(org.getUserId());
		long[] categoryIds = StartupFormHelper.getOrgAssetCategories(orgId);
		String startupIncorporated = SambaashUtil
				.getCategoryNameForSpParamVocKey(SambaashConstants.STARTUP_INCORP_VOC_ID, categoryIds);
		String areaOfInterest = SambaashUtil.getCategoryNameForSpParamVocKey(SambaashConstants.STARTUP_CATGEORY_VOC_ID,
				categoryIds);
		String lifeCycleStage = SambaashUtil
				.getCategoryNameForSpParamVocKey(SambaashConstants.STARTUP_LIFECYCLE_STAGE_VOC_ID, categoryIds);
		String rasingFunds = SambaashUtil.getCategoryNameForSpParamVocKey(SambaashConstants.STARTUP_RAISINGFUNDS_VOC_ID,
				categoryIds);

		payload.setTimestamp(DateUtil.getCurrentDate("dd MMM yyyy HH:mm", Locale.getDefault()));
		payload.setName(org.getName());
		payload.setDescription(org.getDescription());
		payload.setLogoUrl(SambaashUtil.getDLFileUrl(themeDisplay, org.getLogoId()));
		payload.setProfileUrl(portalUrl + StartupProfileHelper.displayStartupDetailsFriendlyURL(themeDisplay, orgId));
		// payload.setAuthorLogoUrl(portalUrl +
		// "/UnileverFoundry-theme/images/Unilever-Foundry-Logo.jpg");
		String logoPath = portalUrl + themeDisplay.getLayoutSetLogo();
		payload.setAuthorLogoUrl(logoPath);

		// Challenge Applicant Details.
		if (Validator.isNotNull(applicaiton)) {
			payload.setApplicantUrl(portalUrl + StartupProfileHelper.displayApplicationFriendlyURL(themeDisplay,
					applicaiton.getSpChallengeApplicantId()));
			section = new ReportSection();
			section.add("How does your technology fit this challenge?", applicaiton.getQ1());
			section.add("What would you deliver for $50K pilot?", applicaiton.getQ2());
			section.add("What would be your long term ambition in working with Unilever on this challenge?",
					applicaiton.getQ3());
			payload.setApplication(section);

		}

		// payload.addData("Company Name", org.getName());
		payload.addData("Website", org.getWebsite());
		payload.addData("Startup Incorporated", startupIncorporated);
		payload.addData("Area of Interest", areaOfInterest);
		payload.addData("Number of Employees", String.valueOf(org.getNoOfEmployees()));
		payload.addData("Founded On", org.getFoundedOn());
		payload.addData("Share Ownership, Monies Raised (if any)", org.getProfileOutline());

		// STARTUP DESCRIPTION
		payload.addData("Snappy description of the proposition", org.getShortPitch());
		payload.addData("Customer Interaction", org.getExtras());
		payload.addData("Lifecycle Stage", lifeCycleStage);
		payload.addData("What is unique about the startup ?", org.getUniqueDesc());
		payload.addData("Videos", org.getVideos());
		payload.addData("Showcase links", org.getLinks());

		// STARTUP DEVELOPMENT STAGE
		payload.addData("Total Funding (in Euros)", org.getTotalFunds());
		payload.addData("Raising Funds ?", rasingFunds);

		// STARTUP CONTACTS
		payload.addData("Email Address", org.getEmailId());
		payload.addData("Twitter URL", org.getTwitter());
		payload.addData("LinkedIn URL", org.getLinkedIn());
		payload.addData("Crunchbase URL", org.getCrunchbase());

		// OFFICES
		List<Address> addresses = OrganizationLocalServiceUtil.getOfficeAddresses(orgId);
		sections = new ReportSections();
		sections.setName("Offices");
		if (Validator.isNotNull(addresses)) {
			for (Address address : addresses) {
				section = new ReportSection();
				String tempStr = address.getName();
				if (Validator.isNotNull(address.getStreet1())) {
					if (Validator.isNotNull(tempStr)) {
						tempStr = tempStr + ", ";
					}
					tempStr = tempStr + address.getStreet1();
				}
				if (Validator.isNotNull(address.getStreet2())) {
					if (Validator.isNotNull(tempStr)) {
						tempStr = tempStr + ", ";
					}
					tempStr = tempStr + address.getStreet2();
				}
				section.add("Address", tempStr);
				section.add("City", address.getCity());
				try {
					Country country = CountryServiceUtil.getCountry(GetterUtil.getLong(address.getCountry()));
					section.add("Country", country.getName());
				} catch (Exception ex) {
					section.add("Country", StringPool.BLANK);
				}
				section.add("Postal Code", address.getPostalCode());
				if (address.isHq()) {
					sections.addReportSection(section, 0);
				} else {
					sections.addReportSection(section);
				}
			}
		}
		payload.addReportSections(sections);

		// BOARD AND ADVISORY MEMBERS
		sections = new ReportSections();
		sections.setName("Board And Advisory Members");
		List<Person> persons = OrganizationLocalServiceUtil.getBoardAndAdvisory(orgId);
		if (Validator.isNotNull(persons)) {
			for (Person person : persons) {
				section = new ReportSection();
				section.add("Name", person.getName());
				section.add("About", person.getDescription());
				sections.addReportSection(section);
			}
		}
		payload.addReportSections(sections);

		// COMPETITORS
		List<Organization> competitors = OrganizationLocalServiceUtil.getCompetitors(orgId);
		sections = new ReportSections();
		sections.setName("Competitors");
		if (Validator.isNotNull(competitors)) {
			for (Organization organization : competitors) {
				section = new ReportSection();
				section.add("Competitor Name", organization.getName());
				section.add("About", organization.getDescription());
				sections.addReportSection(section);
			}
		}
		payload.addReportSections(sections);

		// INVESTORS
		List invs = OrganizationLocalServiceUtil.getInvestors(orgId);
		sections = new ReportSections();
		sections.setName("Investors");
		if (Validator.isNotNull(invs)) {
			for (Object obj : invs) {
				if (obj instanceof Organization) {
					section = new ReportSection();
					Organization organization = (Organization) obj;
					section.add("Name", organization.getName());
					section.add("Details", organization.getDescription());
					sections.addReportSection(section);
				} else if (obj instanceof Person) {
					// Handle person type
				}
			}
		}
		payload.addReportSections(sections);

		// FUNDING ROUNDS
		List<FundingRound> frs = OrganizationLocalServiceUtil.getFundingRounds(orgId);
		sections = new ReportSections();
		sections.setName("Funding Rounds");
		if (Validator.isNotNull(frs)) {
			for (FundingRound fr : frs) {
				section = new ReportSection();
				section.add("Funding Rounds", fr.getName());
				section.add("Additional Information", fr.getDescription());
				sections.addReportSection(section);
			}
		}
		payload.addReportSections(sections);

		// FOUNDERS & CO-FOUNDERS
		List<Person> founders = OrganizationLocalServiceUtil.getFounders(orgId);
		sections = new ReportSections();
		sections.setName("Founder & Co-Founders");
		if (Validator.isNotNull(founders)) {
			for (Person founder : founders) {
				section = new ReportSection();
				section.add("Name", founder.getName());
				section.add("Email Address", founder.getEmailId());
				section.add("About", founder.getDescription());
				sections.addReportSection(section);
			}
		}
		payload.addReportSections(sections);

		// ABOUT YOU
		Person person = OrganizationLocalServiceUtil.getFilledBy(orgId);
		if (Validator.isNotNull(person)) {
			sections = new ReportSections();
			sections.setName("Filled By");
			section = new ReportSection();
			section.add("Name", person.getName());
			section.add("Role", person.getTitle());
			section.add("Email Address", person.getEmailId());
			section.add("Mobile Number", person.getMobile());
			section.add("Skype ID", person.getSkype());
			sections.addReportSection(section);
			payload.addReportSections(sections);
		}
		try {
			fileName = StartupProfileHelper.generateExportFileName(user.getUserId(), org.getName(), ".pdf");
			generator.generateReport(payload, new File(fileName));
		} catch (Exception e) {
			logger.error("Error while creating pdf file", e);
		}

		return fileName;
	}

	public boolean canUpdateStartup(PortletRequest request, long orgId) {
		return StartupPermissionHelper.canUpdateStartup(request, orgId);
	}

	public boolean organizationHasCategoryName(long orgId, String categoryName) {
		try {
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(Organization.class.getName(),
					Long.valueOf(orgId));
			for (AssetCategory cat : assetEntry.getCategories()) {
				if (categoryName.equals(cat.getName())) {
					return true;
				}
			}
		} catch (Exception e) {
			logger.debug("Error encountered while trying to check if org has category. Returning false.", e);
		}
		return false;
	}

	public List<Organization> getAllATO() {
		try {
			DynamicQuery getATOQuery = DynamicQueryFactoryUtil.forClass(Organization.class, "org",
					PortletClassLoaderUtil.getClassLoader(PORTLET_ID));
			getATOQuery.add(RestrictionsFactoryUtil.eq("org.isATO", true));
			getATOQuery.add(RestrictionsFactoryUtil.eq("org.status", 1));
			getATOQuery.addOrder(OrderFactoryUtil.asc("org.name"));
			List<Organization> ATOs = OrganizationLocalServiceUtil.dynamicQuery(getATOQuery);
			return ATOs;
		} catch (SystemException e) {
			return null;
		}
	}

	public Integer getATOExpiryPeriodParam() {
		int expiry = 1095;
		try {
			SPParameter param = SPParameterLocalServiceUtil.findSPParameterOrAdd(StartupConstants.POST_EXPIRY_NOTICE,
					StringPool.BLANK, StartupConstants.NEXT_EXPIRY_DURATION_FROM_APPROVAL, StringPool.BLANK,
					SambaashConstants.DEFAULT_GROUP_ID_LONG);

			if (Validator.isNumber(param.getValue())) {
				expiry = Integer.parseInt(param.getValue());
			} else {
				logger.error(String.format(
						" %s spParam value has invalid expiry duration '%s'. Returning default duration as 1095 (In Days)",
						StartupConstants.NEXT_EXPIRY_DURATION_FROM_APPROVAL, param.getValue()));
			}
		} catch (Exception e) {
			logger.error(
					String.format(" %s spParam not found. Returning default duration as 1095 (In Days). Error msg %s",
							StartupConstants.NEXT_EXPIRY_DURATION_FROM_APPROVAL, e.getMessage()));
		}

		return expiry;
	}

	public Integer getATOExpiryAdvanceNoticeParam() {
		int expiry = 21;
		try {

			SPParameter param = SPParameterLocalServiceUtil.findSPParameterOrAdd(StartupConstants.POST_EXPIRY_NOTICE,
					StringPool.BLANK, StartupConstants.ADVANCE_NOTICE, StringPool.BLANK,
					SambaashConstants.DEFAULT_GROUP_ID_LONG);

			if (Validator.isNumber(param.getValue())) {
				expiry = Integer.parseInt(param.getValue());
			} else {
				logger.error(String.format(
						" %s spParam value has invalid expiry duration '%s'. Returning default duration as 21 (In Days)",
						StartupConstants.NEXT_EXPIRY_DURATION_FROM_APPROVAL, param.getValue()));
			}
		} catch (Exception e) {
			logger.error(
					String.format(" %s spParam not found. Returning default duration as 21 (In Days). Error msg %s",
							StartupConstants.NEXT_EXPIRY_DURATION_FROM_APPROVAL, e.getMessage()));
		}

		return expiry;
	}

	public Integer getATOPostExpiryNoticeParam() {
		int expiry = 1;
		try {
			SPParameter param = SPParameterLocalServiceUtil.findSPParameterOrAdd(StartupConstants.POST_EXPIRY_NOTICE,
					StringPool.BLANK, StartupConstants.POST_EXPIRY_NOTICE, StringPool.BLANK,
					SambaashConstants.DEFAULT_GROUP_ID_LONG);

			if (Validator.isNumber(param.getValue())) {
				expiry = Integer.parseInt(param.getValue());
			} else {
				logger.error(String.format(
						" %s spParam value has invalid expiry duration '%s'. Returning default duration as 1 (In Days)",
						StartupConstants.NEXT_EXPIRY_DURATION_FROM_APPROVAL, param.getValue()));
			}
		} catch (Exception e) {
			logger.error(String.format(" %s spParam not found. Returning default duration as 1 (In Days). Error msg %s",
					StartupConstants.NEXT_EXPIRY_DURATION_FROM_APPROVAL, e.getMessage()));
		}

		return expiry;
	}

	public List<Organization> getATOsForExpiryNotification() {
		try {

			Calendar currentDate = Calendar.getInstance();
			String expiryDays = "-" + getATOExpiryPeriodParam();
			currentDate.add(Calendar.DATE, Integer.parseInt(expiryDays));

			DynamicQuery getATOQuery = DynamicQueryFactoryUtil.forClass(Organization.class, "org",
					PortletClassLoaderUtil.getClassLoader(PORTLET_ID));
			getATOQuery.add(RestrictionsFactoryUtil.eq("org.isATO", true));
			getATOQuery.add(RestrictionsFactoryUtil.eq("org.isBaseOrg", true));
			getATOQuery.add(RestrictionsFactoryUtil.eq("org.status", 1));
			getATOQuery.add(RestrictionsFactoryUtil.le("org.ApprovalDate", currentDate.getTime()));

			if (logger.isDebugEnabled()) {
				logger.debug(String.format("Current Date after setting expiry period %s", currentDate.getTime(),
						getATOQuery.toString()));
			}

			return (List<Organization>) OrganizationLocalServiceUtil.dynamicQuery(getATOQuery);

		} catch (Exception e) {
			logger.error(e);
			logger.error(e.getMessage());
		}
		return null;
	}

	public List<Organization> getAllExpiredATOs() {
		try {
			DynamicQuery getATOQuery = DynamicQueryFactoryUtil.forClass(Organization.class, "org",
					PortletClassLoaderUtil.getClassLoader(PORTLET_ID));
			getATOQuery.add(RestrictionsFactoryUtil.eq("org.status", 3));
			List<Organization> ATOs = OrganizationLocalServiceUtil.dynamicQuery(getATOQuery);
			return ATOs;
		} catch (SystemException e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	public String updateATOAsExpired(long organizationId) {
		try {
			Organization org = OrganizationLocalServiceUtil.getOrganization(organizationId);
			if (org != null) {
				org.setIsATO(false);
				org.setStatus(3);
				org.setApprovalDate(null);
				org.setModifiedDate(DateUtil.newDate());
				OrganizationLocalServiceUtil.updateOrganization(org);
			} else {
				return StartupConstants.ORGANIZATION_NOT_FOUND;
			}
			return "Updated";
		} catch (SystemException | PortalException e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	public String updateATOInactive(long organizationId) {
		try {
			Organization org = OrganizationLocalServiceUtil.getOrganization(organizationId);
			if (org != null) {
				org.setStatus(0);
				org.setModifiedDate(DateUtil.newDate());
				OrganizationLocalServiceUtil.updateOrganization(org);
			} else {
				return StartupConstants.ORGANIZATION_NOT_FOUND;
			}
			return "Updated";
		} catch (SystemException | PortalException e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	public String approveATO(long organizationId) {
		try {
			Organization org = OrganizationLocalServiceUtil.getOrganization(organizationId);
			if (org != null) {
				org.setIsATO(true);
				org.setStatus(1);
				org.setModifiedDate(DateUtil.newDate());
				OrganizationLocalServiceUtil.updateOrganization(org);
			} else {
				return StartupConstants.ORGANIZATION_NOT_FOUND;
			}
			return "Updated";
		} catch (SystemException | PortalException e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	public String approveATOByUserId(long userId) {
		try {
			long organizationId = Long.valueOf(getCurrentUserBaseOrganization(userId));
			Organization org = OrganizationLocalServiceUtil.getOrganization(organizationId);
			if (org != null) {
				org.setIsATO(true);
				org.setStatus(1);
				org.setModifiedDate(DateUtil.newDate());
				org.setApprovalDate(DateUtil.newDate());
				OrganizationLocalServiceUtil.updateOrganization(org);
			} else {
				return StartupConstants.ORGANIZATION_NOT_FOUND;
			}
			return "Updated";
		} catch (SystemException | PortalException e) {
			logger.error(e.getMessage());
			return null;
		}
	}
	
	public void transferOwnership(Long userId) {
		long organizationId = Long.valueOf(getCurrentUserBaseOrganization(userId));
		Organization org;
		try {
			org = OrganizationLocalServiceUtil.getOrganization(organizationId);
			if (org != null) {
				List<SPATOContacts> orgContactsList = SPATOContactsLocalServiceUtil
						.findATOContactsByOrganizationId(organizationId);
				if (orgContactsList != null && orgContactsList.size() > 0) {
					SPATOContacts orgContact = orgContactsList.get(0);
					long trainingPrincipalUserId = Long.valueOf(orgContact.getPrimaryPrincipalUserId());
					org.setUserId(trainingPrincipalUserId);
					org.setModifiedDate(DateUtil.newDate());
					OrganizationLocalServiceUtil.updateOrganization(org);
					if(userId != trainingPrincipalUserId ){
						removeRole(userId);
					}
				}
			}
		} catch (Exception e) {
			logger.error("Failed to transfer ownership from userId : " + userId + " : " + e.getMessage());
		}
	}

	public String removeTPandSCfromATO(long userId) {
		try {
			long organizationId = Long.valueOf(getCurrentUserBaseOrganization(userId));
			Organization org = OrganizationLocalServiceUtil.getOrganization(organizationId);
			if (org != null) {
				List<SPATOContacts> orgContactsList = SPATOContactsLocalServiceUtil
						.findATOContactsByOrganizationId(organizationId);
				if (orgContactsList != null && orgContactsList.size() > 0) {
					SPATOContacts orgContact = orgContactsList.get(0);
					long trainingPrincipalUserId = Long.valueOf(orgContact.getPrimaryPrincipalUserId());
					long secondaryContactUserId = Long.valueOf(orgContact.getSecondaryPrincipalUserId());
					long companyId = PortalUtil.getDefaultCompanyId();
					Role role = RoleLocalServiceUtil.getRole(companyId, "SAC ATO");
					List<SPATOContacts> trainingPrincipalContactsList = SPATOContactsLocalServiceUtil
							.findATOContactsByTrainingPrincipal(trainingPrincipalUserId);
					if (trainingPrincipalContactsList != null && trainingPrincipalContactsList.size() > 1) {
						// update SPATOContact for this organization
						orgContact.setPrimaryPrincipalUserId(StringPool.BLANK);

					} else if (trainingPrincipalContactsList != null && trainingPrincipalContactsList.size() == 1
							&& trainingPrincipalContactsList.get(0).getOrganizationId() == organizationId) {
						// remove role
						orgContact.setPrimaryPrincipalUserId(StringPool.BLANK);
						UserLocalServiceUtil.deleteRoleUser(role.getRoleId(), trainingPrincipalUserId);
					}

					List<SPATOContacts> secondaryContactsList = SPATOContactsLocalServiceUtil
							.findATOContactsBySecondaryContact(secondaryContactUserId);
					if (secondaryContactsList != null && secondaryContactsList.size() > 1) {
						// update SPATOContact for this organization
						orgContact.setSecondaryPrincipalUserId(StringPool.BLANK);

					} else if (secondaryContactsList != null && secondaryContactsList.size() == 1
							&& secondaryContactsList.get(0).getOrganizationId() == organizationId) {
						// remove role
						orgContact.setSecondaryPrincipalUserId(StringPool.BLANK);
						UserLocalServiceUtil.deleteRoleUser(role.getRoleId(), secondaryContactUserId);
					}
					SPATOContactsLocalServiceUtil.updateSPATOContacts(orgContact);

					try {
						User user = UserLocalServiceUtil.getUserByEmailAddress(org.getCompanyId(), org.getEmailId());
						org.setUserId(user.getUserId());
						org.setModifiedDate(DateUtil.newDate());
						OrganizationLocalServiceUtil.updateOrganization(org);

						String param = SambaashUtil.getParameter("startupDefaultRole", org.getGroupId());
						Role role1 = RoleLocalServiceUtil.getRole(companyId, param);
						UserLocalServiceUtil.addRoleUser(role1.getRoleId(), user);
					} catch (Exception e) {
						logger.error("user : " + e.getMessage());
					}
				}

			} else {
				logger.debug("Organization removeTPandSCfromATO not found");
				return StartupConstants.ORGANIZATION_NOT_FOUND;
			}
			logger.debug("Executed removeTPandSCfromATO");
			return "Updated";
		} catch (SystemException | PortalException e) {
			logger.error(e.getMessage());
			return null;
		}
	}
	
	public String isUserLinkedToOrganization(String emailAddress) {
		long userId = 0;
		long companyId = PortalUtil.getDefaultCompanyId();
		try {

			userId = UserLocalServiceUtil.getUserIdByEmailAddress(companyId, emailAddress);
		} catch (PortalException | SystemException e) {
			logger.debug("exception Not Linked to any ATO " + companyId + " --- " + emailAddress);
			return "Not Linked to any ATO";
		}
		try {
			List<SPATOContacts> primarycontact = SPATOContactsLocalServiceUtil
					.findATOContactsByTrainingPrincipal(userId);
			List<SPATOContacts> secondarycontact = SPATOContactsLocalServiceUtil
					.findATOContactsBySecondaryContact(userId);
			List<ApprovedMentors> mentors = ApprovedMentorsLocalServiceUtil.findApprovedMentorsByUserIdAndStatus(userId,1);
			if ((primarycontact == null || primarycontact.size() == 0)
					&& (secondarycontact == null || secondarycontact.size() == 0)
					&& (mentors == null || mentors.size() == 0)) {
				logger.debug("Not Linked to any ATOs ");
				return "Not Linked to any ATO";
			} else {
				return "Linked to an ATO";
			}
		} catch (Exception e) {
			logger.error(e);
			return "Linked to an ATO";
		}
	}
	public String isUserLinkedToOrganization(String emailAddress,long organizationId) {
		long userId = 0;
		long companyId = PortalUtil.getDefaultCompanyId();
		try {

			userId = UserLocalServiceUtil.getUserIdByEmailAddress(companyId, emailAddress);
		} catch (PortalException | SystemException e) {
			logger.debug("exception Not Linked to any ATO " + companyId + " --- " + emailAddress);
			return "Not Linked to any ATO";
		}
		try {
			List<SPATOContacts> primarycontact = SPATOContactsLocalServiceUtil
					.findATOContactsByTrainingPrincipal(userId);
			List<SPATOContacts> secondarycontact = SPATOContactsLocalServiceUtil
					.findATOContactsBySecondaryContact(userId);
			List<ApprovedMentors> mentors = ApprovedMentorsLocalServiceUtil.findApprovedMentorsByUserIdAndStatus(userId,
					1);
			if ((primarycontact == null || primarycontact.size() == 0)
					&& (secondarycontact == null || secondarycontact.size() == 0)
					&& (mentors == null || mentors.size() == 0)) {
				logger.debug("Not Linked to any ATO");
				return "Not Linked to any ATO";
			}else if ((primarycontact.size() > 0 && primarycontact.get(0).getOrganizationId() == organizationId)
					|| (secondarycontact.size() > 0 && secondarycontact.get(0).getOrganizationId() == organizationId)
					|| (mentors.size() > 0 && mentors.get(0).getOrganizationId() == organizationId)) {
				logger.debug("Not Linked to any other ATO");
				return "Not Linked to any other ATO";
			} else {
				return "Linked to an ATO";
			}
		} catch (Exception e) {
			logger.error(e);
			return "Linked to an ATO";
		}
	}

}
