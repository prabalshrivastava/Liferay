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

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPSiteSetup;
import com.sambaash.platform.srv.spservices.service.SPSiteSetupLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.model.Accreditation;
import com.sambaash.platform.srv.startupprofile.model.Address;
import com.sambaash.platform.srv.startupprofile.model.ApprovedMentors;
import com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.model.ReAccreditation;
import com.sambaash.platform.srv.startupprofile.model.Relationship;
import com.sambaash.platform.srv.startupprofile.model.SPATOContacts;
import com.sambaash.platform.srv.startupprofile.service.AccreditationLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.AddressLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.ApprovedMentorsLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.OrganisationRemarksLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.ReAccreditationLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.RelationshipLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.SPATOContactsLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.StartupProfileLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.base.StartupProfileServiceBaseImpl;
import com.sambaash.platform.startupprofile.DBConstants;
import com.sambaash.platform.util.URLUtil;

/**
 * The implementation of the startup profile remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.startupprofile.service.StartupProfileService}
 * interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author pradeep
 * @see com.sambaash.platform.srv.startupprofile.service.base.StartupProfileServiceBaseImpl
 * @see com.sambaash.platform.srv.startupprofile.service.StartupProfileServiceUtil
 */
public class StartupProfileServiceImpl extends StartupProfileServiceBaseImpl {

	private static Log logger = LogFactoryUtil.getLog(StartupProfileServiceImpl.class);

	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform
	 * .srv.startupprofile.service.StartupProfileServiceUtil} to access the
	 * startup profile remote service.
	 */

	// @AccessControlled(guestAccessEnabled = true)
	public List<Organization> getAllActiveOrganizations() {
		return StartupProfileLocalServiceUtil.getAllActiveOrganizations();
	}

	@AccessControlled(guestAccessEnabled = true)
	public Organization addOrganizationDetails(long agroupid, long acompanyid, String auseremail, String aorgdesc,
			String aorgname, String aorgcode, long auserid, String ausername, String auen, String awebsite,
			String aindustrysector, String alistedco, String aaccreditationstatus, String aaccreditationby,
			String adateofaccreditation, String adateofexpiry, String alatestpaymentdate,
			String astartdateofreaccreditation, String adateofreaccdtreview, long anoofpotentialcandidates)
			throws SystemException {
		Organization org = null;

		long orgId;
		boolean isEmailExist = false;
		boolean isOrgNameExist = false;
		boolean isUENExist = false;
		try {


			if (auseremail == null || auseremail.isEmpty()) {
				throw new SystemException("userEmail is mandatory");
			}
			if (aorgname == null || aorgname.isEmpty()) {
				throw new SystemException("orgName is mandatory");
			}
			if (ausername == null || ausername.isEmpty()) {
				throw new SystemException("userName is mandatory");
			}
			if (auen == null || auen.isEmpty()) {
				throw new SystemException("uen is mandatory");
			}
			if (awebsite == null || awebsite.isEmpty()) {
				throw new SystemException("website is mandatory");
			}

			User u = UserLocalServiceUtil.fetchUserByEmailAddress(acompanyid, decode(auseremail));
			isEmailExist = (u != null);

			if (!isEmailExist) {
				throw new SystemException("No liferay User found with this email address '" + decode(auseremail) + "'");
			}

			isOrgNameExist = OrganizationLocalServiceUtil.isOrganizationExistsWithName(decode(aorgname));

			if (isOrgNameExist) {
				logger.error("Startup Profile exists with the given name, no change will be done . Returning back '");
				return OrganizationLocalServiceUtil.findByName(decode(aorgname));
			}

			isUENExist = OrganizationLocalServiceUtil.isOrganizationExistsWithUEN(decode(auen));

			if (isUENExist) {
				logger.error(String.format("Startup Profile exists with the given UEN %s , no change will be done . Returning back", auen));
				if(OrganizationLocalServiceUtil.findByUENNumber(decode(auen)).size() > 0){
					return OrganizationLocalServiceUtil.findByUENNumber(decode(auen)).get(0);
				}
				return null;
			}
			
			orgId = CounterLocalServiceUtil.increment("Organization");
			org = OrganizationLocalServiceUtil.createOrganization(orgId);

			org.setEmailId(decode(auseremail));
			org.setCorporateCode(decode(aorgcode));
			org.setCorporateType(decode(aindustrysector));
			org.setDescription(decode(aorgdesc));
			org.setCategories(decode(aindustrysector));
			org.setName(decode(aorgname));
			org.setIsBaseOrg(true);
			org.setActive(true);
			org.setUserId(auserid);
			org.setUserName(decode(ausername));
			org.setGroupId(agroupid);
			org.setCompanyId(acompanyid);
			org.setUen(auen);
			org.setCreateDate(new Date());
			org.setModifiedDate(new Date());
			org.setWebsite(decode(awebsite));
			org.setListedCo(alistedco);
			org.setNoOfPotentialCandidates(anoofpotentialcandidates);
			org = StartupProfileLocalServiceUtil.addOrganization(org);
			logger.error("org after add " + org);
			ReAccreditation accd = null;

			long accdId = CounterLocalServiceUtil.increment("ReAccreditation");
		    ReAccreditationLocalServiceUtil.createReAccreditation(accdId);
			accd = ReAccreditationLocalServiceUtil.createReAccreditation(accdId);
			accd.setOrganizationId(orgId);
			accd.setAccreditationStatus(aaccreditationstatus);
			accd.setAccreditationBy(aaccreditationby);

			DateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date dateOfAccreditation1 = new Date();
			Date dateOfExpiry1 = new Date();
			Date latestPaymentDate1 = new Date();
			Date startDateOfReaccreditation1 = new Date();
			Date dateOfReaccdtReview1 = new Date();

			try {
				if (!decode(adateofaccreditation).isEmpty()
						&& !decode(adateofaccreditation).equalsIgnoreCase("No Value")) {
					dateOfAccreditation1 = originalFormat.parse(adateofaccreditation);
					String formattedDate = targetFormat.format(dateOfAccreditation1);
					dateOfAccreditation1 = targetFormat.parse(formattedDate);
				}
				if (!decode(adateofexpiry).isEmpty() && !decode(adateofexpiry).equalsIgnoreCase("No Value")) {
					dateOfExpiry1 = originalFormat.parse(adateofexpiry);
					String formattedDate = targetFormat.format(dateOfExpiry1);
					dateOfExpiry1 = targetFormat.parse(formattedDate);
				}
				if (!decode(alatestpaymentdate).isEmpty() && !decode(alatestpaymentdate).equalsIgnoreCase("No Value")) {
					latestPaymentDate1 = originalFormat.parse(alatestpaymentdate);
					String formattedDate = targetFormat.format(latestPaymentDate1);
					latestPaymentDate1 = targetFormat.parse(formattedDate);
				}
				if (!decode(astartdateofreaccreditation).isEmpty()
						&& !decode(astartdateofreaccreditation).equalsIgnoreCase("No Value")) {
					startDateOfReaccreditation1 = originalFormat.parse(astartdateofreaccreditation);
					String formattedDate = targetFormat.format(startDateOfReaccreditation1);
					startDateOfReaccreditation1 = targetFormat.parse(formattedDate);
				}
				if (!decode(adateofreaccdtreview).isEmpty()
						&& !decode(adateofreaccdtreview).equalsIgnoreCase("No Value")) {
					dateOfReaccdtReview1 = originalFormat.parse(adateofreaccdtreview);
					String formattedDate = targetFormat.format(dateOfReaccdtReview1);
					dateOfReaccdtReview1 = targetFormat.parse(formattedDate);
				}
			} catch (Exception e) {
				logger.error("Date exception in add organization " + e.getMessage());
			}
			accd.setDateOfAccreditation(dateOfAccreditation1);
			accd.setDateOfExpiry(dateOfExpiry1);
			accd.setLatestPaymentDate(latestPaymentDate1);
			accd.setStartDateOfReaccreditation(startDateOfReaccreditation1);
			accd.setDateOfReaccdtReview(dateOfReaccdtReview1);
			
			StartupProfileLocalServiceUtil.addOrganizationReAccreditation(accd);

		} catch (SystemException e) {
			logger.error(e.getMessage());
		}
		return org;
	}

	private String decode(String string) {
		try {
			return URLDecoder.decode(string, StringPool.DEFAULT_CHARSET_NAME);
		} catch (UnsupportedEncodingException e) {
			logger.error(String.format("Failed to decode the string, %s, returning original.", string));
		}
		return string;
	}

	@AccessControlled(guestAccessEnabled = true)
	public Organization getOrganization(long groupId, long companyId, String companyName) throws SystemException {
		Organization org = null;

		org = OrganizationLocalServiceUtil.findByName(companyName);
		return org;
	}

	@AccessControlled(guestAccessEnabled = true)
	public Organization addOrganization(long groupId, long companyId, String userEmail, String orgDesc, String orgName,
			long userId, String userName, String uen, String website) throws SystemException {
		Organization org = null;

		long orgId;
		boolean isEmailExist = false;
		boolean isOrgNameExist = false;
		boolean isUENExist = false;
		try {
			orgId = CounterLocalServiceUtil.increment("Organization");
			org = OrganizationLocalServiceUtil.createOrganization(orgId);

			if (userEmail == null || userEmail.isEmpty()) {
				throw new SystemException("userEmail is mandatory");
			}
			if (orgName == null || orgName.isEmpty()) {
				throw new SystemException("orgName is mandatory");
			}
			if (userName == null || userName.isEmpty()) {
				throw new SystemException("userName is mandatory");
			}
			if (uen == null || uen.isEmpty()) {
				throw new SystemException("uen is mandatory");
			}
			if (website == null || website.isEmpty()) {
				throw new SystemException("website is mandatory");
			}

			User u = UserLocalServiceUtil.fetchUserByEmailAddress(companyId, userEmail);
			isEmailExist = (u != null);

			if (isEmailExist) {
				throw new SystemException("Startup Profile exists with the given email address '" + userEmail + "'");
			}

			isOrgNameExist = OrganizationLocalServiceUtil.isOrganizationExistsWithName(orgName);

			if (isOrgNameExist) {
				throw new SystemException("Startup Profile exists with the given name '" + orgName + "'");
			}

			isUENExist = OrganizationLocalServiceUtil.isOrganizationExistsWithUEN(uen);

			if (isUENExist) {
				throw new SystemException("Startup Profile exists with the given UEN '" + uen + "'");
			}

			org.setEmailId(userEmail);
			org.setDescription(orgDesc);
			org.setCategories("");
			org.setName(orgName);
			org.setIsBaseOrg(true);
			org.setActive(true);
			org.setUserId(userId);
			org.setUserName(userName);
			org.setGroupId(groupId);
			org.setCompanyId(companyId);
			org.setUen(uen);
			org.setCreateDate(new Date());
			org.setModifiedDate(new Date());
			org.setWebsite(website);

			return StartupProfileLocalServiceUtil.addOrganization(org);
		} catch (SystemException e) {
			throw e;
		}
	}

	@AccessControlled(guestAccessEnabled = true)
	public Organization createAtos(long sgroupId, long scompanyId, String suserEmail, String sorgDesc,
			String scompanyName, String sorgCode, long suserId, String suserName, String suen, String swebsite,
			String sindustrySector, String slistedCo) throws SystemException {
		Organization org = null;

		long orgId;
		boolean isEmailExist = false;
		boolean isOrgNameExist = false;
		boolean isUENExist = false;
		try {
			orgId = CounterLocalServiceUtil.increment("Organization");
			org = OrganizationLocalServiceUtil.createOrganization(orgId);

			if (suserEmail == null || suserEmail.isEmpty()) {
				throw new SystemException("userEmail is mandatory");
			}
			if (scompanyName == null || scompanyName.isEmpty()) {
				throw new SystemException("orgName is mandatory");
			}
			if (suserName == null || suserName.isEmpty()) {
				throw new SystemException("userName is mandatory");
			}
			if (suen == null || suen.isEmpty()) {
				throw new SystemException("uen is mandatory");
			}
			if (swebsite == null || swebsite.isEmpty()) {
				throw new SystemException("website is mandatory");
			}

			User u = UserLocalServiceUtil.fetchUserByEmailAddress(scompanyId, suserEmail);
			isEmailExist = (u != null);

			if (!isEmailExist) {
				throw new SystemException("No liferay User found with this email address '" + suserEmail + "'");
			}

			isOrgNameExist = OrganizationLocalServiceUtil.isOrganizationExistsWithName(scompanyName);

			if (isOrgNameExist) {
				throw new SystemException("Startup Profile exists with the given name '" + scompanyName + "'");
			}

			isUENExist = OrganizationLocalServiceUtil.isOrganizationExistsWithUEN(suen);

			if (isUENExist) {
				throw new SystemException("Startup Profile exists with the given UEN '" + suen + "'");
			}

			org.setEmailId(decode(suserEmail));
			org.setCorporateCode(decode(sorgCode));
			org.setCorporateType(decode(sindustrySector));
			org.setDescription(decode(sorgDesc));
			org.setCategories(decode(sindustrySector));
			org.setName(decode(scompanyName));
			org.setIsBaseOrg(true);
			org.setActive(true);
			org.setUserId(suserId);
			org.setUserName(decode(suserName));
			org.setGroupId(sgroupId);
			org.setCompanyId(scompanyId);
			org.setUen(suen);
			org.setCreateDate(new Date());
			org.setModifiedDate(new Date());
			org.setWebsite(decode(swebsite));
			org.setListedCo(slistedCo);

			org = StartupProfileLocalServiceUtil.addOrganization(org);
			logger.error("org after add createatos " + org);

		} catch (SystemException e) {
			logger.error(e.getMessage());
		}
		return org;
	}

	@AccessControlled(guestAccessEnabled = true)
	public String createAtodetails(long dgroupid, long dcompanyid, long dorgid, long duserid, String dusername,
			String dremarks, String dspatocontactsarray, String daddress, String dorgname, String dcountry,
			String dpostcode) throws SystemException {
		String failedResult = "Success";
		try {
			try {
				JSONArray remarksJsonArray = new JSONArray(decode(dremarks));
				for (int j = 0; j < remarksJsonArray.length(); j++) {
					JSONObject remarksJson = remarksJsonArray.getJSONObject(j);
					OrganisationRemarks orgRm = null;

					long orgRmId = CounterLocalServiceUtil.increment("OrganisationRemarks");
					orgRm = OrganisationRemarksLocalServiceUtil.createOrganisationRemarks(orgRmId);
					orgRm.setOrganizationId(dorgid);
					orgRm.setCompanyId(dcompanyid);
					orgRm.setGroupId(dgroupid);
					orgRm.setRemarks(remarksJson.getString("remarks"));
					orgRm.setRemarkType(remarksJson.getString("remarkType"));
					orgRm.setNotes(remarksJson.getString("notes"));
					orgRm.setUserId(duserid);
					orgRm.setUserName(dusername);
					OrganisationRemarksLocalServiceUtil.addOrganisationRemarks(orgRm);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				failedResult = "Remarks migration failed " + e.getMessage();
				logger.error(e.getMessage());
			}

			JSONObject SPATOContactsArrays = new JSONObject(decode(dspatocontactsarray));
			try {

				
				if (SPATOContactsArrays.length() > 0) {
					JSONObject SPATOContacts = new JSONObject(SPATOContactsArrays.getString("SPATOContacts"));
					SPATOContacts atoContacts = null;

					long atoContactsId = CounterLocalServiceUtil.increment("SPATOContacts");
					atoContacts = SPATOContactsLocalServiceUtil.createSPATOContacts(atoContactsId);
					atoContacts.setOrganizationId(dorgid);
					atoContacts.setGroupId(dgroupid);
					atoContacts.setPrimaryPrincipalUserId(SPATOContacts.getString("primaryPrincipalUserId"));
					atoContacts
							.setPrimaryPrincipalUserFirstName(SPATOContacts.getString("primaryPrincipalUserFirstName"));
					atoContacts
							.setPrimaryPrincipalUserLastName(SPATOContacts.getString("primaryPrincipalUserLastName"));
					atoContacts.setPrimaryPrincipalUserEmail(SPATOContacts.getString("primaryPrincipalUserEmail"));
					atoContacts.setUserId(duserid);
					atoContacts.setFirstName(dusername);
					SPATOContactsLocalServiceUtil.addSPATOContacts(atoContacts);
					
				}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					failedResult = failedResult + " SPATOContacts migration failed " + e.getMessage();
				}	

				try{
					if (SPATOContactsArrays.length() > 0) {
						JSONObject SPMentorContacts = new JSONObject(SPATOContactsArrays.getString("SPMentorContacts"));
						ApprovedMentors appMentors = null;
	
						long appMentorsId = CounterLocalServiceUtil.increment("ApprovedMentors");
						appMentors = ApprovedMentorsLocalServiceUtil.createApprovedMentors(appMentorsId);
						appMentors.setOrganizationId(dorgid);
						appMentors.setUserId(SPMentorContacts.getString("mentorUserId"));
//						appMentors.setMentorTitle(SPMentorContacts.getString("mentorTitle"));
//						appMentors.setMentorEmail(SPMentorContacts.getString("mentorEmail"));
//						appMentors.setMentorFirstName(SPMentorContacts.getString("mentorFirstName"));
//						appMentors.setMentorLastName(SPMentorContacts.getString("mentorLastName"));
	
						ApprovedMentorsLocalServiceUtil.addApprovedMentors(appMentors);
					}	

			} catch (JSONException e) {
				failedResult = failedResult + " SPMentorContacts migration failed " + e.getMessage();
				logger.error(e.getMessage());
			}

			if (!daddress.isEmpty()) {
				Address adrsObj = null;

				long adrsObjId = CounterLocalServiceUtil.increment("Address");
				adrsObj = AddressLocalServiceUtil.createAddress(adrsObjId);

				adrsObj.setCountry(dcountry);
				adrsObj.setPostalCode(dpostcode);
				adrsObj.setStreet1(daddress);
				adrsObj.setUserName(dusername);
				adrsObj.setOrganizationId(dorgid);
				adrsObj.setName(dorgname);
				adrsObj.setHq(true);
				adrsObj.setActive(true);
				AddressLocalServiceUtil.addAddress(adrsObj);
			}
		} catch (Exception e) {
			failedResult = failedResult + " Address migration failed " + e.getMessage();
			logger.error(e.getMessage());
		}
		return failedResult;
	}

	public List<User> getUsersByRole(String roleName) {
		List<User> users = new ArrayList<User>();
		try {
			Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), roleName);
			users = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return users;
	}

	@AccessControlled(guestAccessEnabled = true)
	public List<ApprovedMentors> findApprovedMentorsByOrganizationId(long organizationId) {
		Organization org;
		Organization baseOrg;
		List<ApprovedMentors> currentOrgMentors = null;
		List<ApprovedMentors> allMentors = new ArrayList<ApprovedMentors>();
		try {
			org = OrganizationLocalServiceUtil.getOrganization(organizationId);
		
			if(org != null){
				currentOrgMentors = ApprovedMentorsLocalServiceUtil.findApprovedMentorsByOrganizationId(organizationId);
				if(!org.isIsBaseOrg()){
					
					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Relationship.class,
							PortletClassLoaderUtil.getClassLoader(PEConstantsGlobal.PORTLET_ID));
					dynamicQuery.add(PropertyFactoryUtil.forName("organizationId").eq(organizationId));
					dynamicQuery.add(PropertyFactoryUtil.forName("refTypeId").eq(DBConstants.REF_TYPE_ORGANIZATION_ID));
					dynamicQuery.add(PropertyFactoryUtil.forName("relation").eq(DBConstants.RELATION_SUBSIDIARY));
					@SuppressWarnings("unchecked")
					List<Relationship> relationOrg =   RelationshipLocalServiceUtil.dynamicQuery(dynamicQuery);
					if(relationOrg != null && relationOrg.size() > 0){
						long baseOrgId = relationOrg.get(0).getRefId();
						List<ApprovedMentors> baseOrgMentors = ApprovedMentorsLocalServiceUtil.findApprovedMentorsByOrganizationId(baseOrgId);
						
						//currentOrgMentors.addAll(baseOrgMentors);
						List <String> currentMentorIds = new ArrayList<String>();
						for(ApprovedMentors mentor:currentOrgMentors)
						{
							allMentors.add(mentor);
							currentMentorIds.add(mentor.getUserId());
						}
						for(ApprovedMentors mentor:baseOrgMentors)
						{
							if(!currentMentorIds.contains(mentor.getUserId())){
								allMentors.add(mentor);
							}
						}
					}
				}else{
					return currentOrgMentors;
				}
			}
		} catch (PortalException | SystemException e) {
			logger.error(e.getMessage());
		}
		
		return allMentors;
	}

	@AccessControlled(guestAccessEnabled = true)
	public List<ApprovedMentors> findApprovedMentorsByOrganizationIdWithOthers(long organizationId) {
		return ApprovedMentorsLocalServiceUtil.findApprovedMentorsByOrganizationIdWithOthers(organizationId);
	}

	@AccessControlled(guestAccessEnabled = true)
	public List<SPATOContacts> findATOContactsByOrganizationId(long organizationId) {
		return SPATOContactsLocalServiceUtil.findATOContactsByOrganizationId(organizationId);
	}
	@AccessControlled(guestAccessEnabled = true)
	public com.liferay.portal.kernel.json.JSONObject findATOContactsByUserId(long userId) {
		long organizationId = Long.valueOf(OrganizationLocalServiceUtil.getCurrentUserBaseOrganization(userId));
		List<SPATOContacts> sPATOContacts = SPATOContactsLocalServiceUtil.findATOContactsByOrganizationId(organizationId);
		com.liferay.portal.kernel.json.JSONObject repsonse = JSONFactoryUtil.createJSONObject();
		if(sPATOContacts.size() > 0){
			repsonse.put("trainingPrincipalUserId", sPATOContacts.get(0).getPrimaryPrincipalUserId());
			repsonse.put("trainingPrincipalEmailId", sPATOContacts.get(0).getPrimaryPrincipalUserEmail());
			repsonse.put("trainingPrincipalFirstName", sPATOContacts.get(0).getPrimaryPrincipalUserFirstName());
			repsonse.put("trainingPrincipalLastName", sPATOContacts.get(0).getPrimaryPrincipalUserLastName());
			repsonse.put("secondaryContactUserId", sPATOContacts.get(0).getSecondaryPrincipalUserId());
			repsonse.put("secondaryContactEmailId", sPATOContacts.get(0).getSecondaryPrincipalUserEmail());
			repsonse.put("secondaryContactFirstName", sPATOContacts.get(0).getSecondaryPrincipalUserFirstName());
			repsonse.put("secondaryContactLastName", sPATOContacts.get(0).getSecondaryPrincipalUserLastName());
		}
		List<ApprovedMentors> mentors = ApprovedMentorsLocalServiceUtil.findApprovedMentorsByOrganizationId(organizationId);
		com.liferay.portal.kernel.json.JSONArray mentorsArray = JSONFactoryUtil.createJSONArray();
		com.liferay.portal.kernel.json.JSONObject mentorObj = JSONFactoryUtil.createJSONObject();
		
		for(int i = 0; i < mentors.size(); i++){
			mentorObj.put("mentorUserId", mentors.get(i).getUserId());
			mentorObj.put("mentorFirstName", mentors.get(i).getFirstName());
			mentorObj.put("mentorLastName", mentors.get(i).getLastName());
			mentorObj.put("mentorEmailId", mentors.get(i).getEmail());
			mentorsArray.put(mentorObj);
		}
		repsonse.put("mentors", mentorsArray);
		
		return repsonse;
	}

	@AccessControlled(guestAccessEnabled = true)
	public List<Organization> getAllATO() {
		return OrganizationLocalServiceUtil.getAllATO();
	}

	@AccessControlled(guestAccessEnabled = true)
	public String addPrincipalDetails(long processStateId) {
		// temp
		try {
			PEProcessState state = PEProcessStateLocalServiceUtil.getPEProcessState(processStateId);
			state = PEProcessStateLocalServiceUtil.clearCacheAndGetProcessState(state);
			JSONObject stateData = new JSONObject(state.getData());
			logger.debug("processStateId" + processStateId);
			logger.debug("stateData" + stateData.toString());
			JSONObject inputObj = new JSONObject();

			inputObj.put("primaryPrincipalUserEmail",
					getStateDataValue(stateData, "emailAddressTrainingPrincipal", StringPool.BLANK));
			inputObj.put("primaryPrincipalUserFirstName",
					getStateDataValue(stateData, "firstNameTrainingPrincipal", StringPool.BLANK));
			inputObj.put("primaryPrincipalUserLastName",
					getStateDataValue(stateData, "lastNameTrainingPrincipal", StringPool.BLANK));
			inputObj.put("primaryPrincipalSalutation",
					getStateDataValue(stateData, "primaryPrincipalSalutation", "0"));
			inputObj.put("primaryPrincipalJobTitle",
					getStateDataValue(stateData, "primaryPrincipalJobTitle", StringPool.BLANK));
			inputObj.put("primaryPrincipalMobile",
					getStateDataValue(stateData, "primaryPrincipalMobile", StringPool.BLANK));

			inputObj.put("secondaryPrincipalUserEmail",
					getStateDataValue(stateData, "emailAddressSecondaryContact", StringPool.BLANK));
			inputObj.put("secondaryPrincipalUserFirstName",
					getStateDataValue(stateData, "firstNameSecondaryContact", StringPool.BLANK));
			inputObj.put("secondaryPrincipalUserLastName",
					getStateDataValue(stateData, "lastNameSecondaryContact", StringPool.BLANK));
			inputObj.put("secondaryPrincipalSalutation",
					getStateDataValue(stateData, "secondaryPrincipalSalutation", "0"));
			inputObj.put("secondaryPrincipalJobTitle",
					getStateDataValue(stateData, "secondaryPrincipalJobTitle", StringPool.BLANK));
			inputObj.put("secondaryPrincipalMobile",
					getStateDataValue(stateData, "secondaryPrincipalMobile", StringPool.BLANK));
			
			
			inputObj.put("companyCountry",getStateDataValue(stateData, "companyCountry", StringPool.BLANK));
			inputObj.put("companyPostalCode",getStateDataValue(stateData, "companyPostalCode", StringPool.BLANK));
			inputObj.put("buildingName",getStateDataValue(stateData, "buildingName", StringPool.BLANK));
			inputObj.put("houseBlockNo",getStateDataValue(stateData, "houseBlockNo", StringPool.BLANK));
			inputObj.put("streetName",getStateDataValue(stateData, "streetName", StringPool.BLANK));
			inputObj.put("companyContactNumber",getStateDataValue(stateData, "companyContactNumber", StringPool.BLANK));
			inputObj.put("companyWebsite",getStateDataValue(stateData, "companyWebsite", StringPool.BLANK));
			inputObj.put("companyInfo",getStateDataValue(stateData, "companyInfo", StringPool.BLANK));
			
			inputObj.put("financialStatement",getStateDataValue(stateData, "financialStatement", StringPool.BLANK));
			inputObj.put("policy",getStateDataValue(stateData, "policy", StringPool.BLANK));
			inputObj.put("businessConduct",getStateDataValue(stateData, "businessConduct", StringPool.BLANK));
			inputObj.put("jobDescription",getStateDataValue(stateData, "jobDescription", StringPool.BLANK));
			inputObj.put("appraisalForm",getStateDataValue(stateData, "appraisalForm", StringPool.BLANK));
			inputObj.put("jobDescriptions",getStateDataValue(stateData, "jobDescriptions", StringPool.BLANK));
			inputObj.put("businessRegistration",getStateDataValue(stateData, "businessRegistration", StringPool.BLANK));
			inputObj.put("supplementary",getStateDataValue(stateData, "supplementary", StringPool.BLANK));
			
			PEProcess process = PEProcessLocalServiceUtil.getPEProcess(state.getSpPEProcessId());
			SPSiteSetup siSiteSetup = SPSiteSetupLocalServiceUtil
					.findByProductIdAndSubProductId(process.getProductTypeId(), process.getSubProductTypeId());

			inputObj.put("userId", state.getUserIdProcess());
			inputObj.put("productTypeId", String.valueOf(process.getProductTypeId()));
			inputObj.put("subProductTypeId", String.valueOf(process.getSubProductTypeId()));
			inputObj.put("virtualHostId",
					getStateDataValue(stateData, "virtualHostId", String.valueOf(siSiteSetup.getVirtualHostId())));
			inputObj.put("newMentors", getStateDataArrayValue(stateData, "mentorDataGrid"));

			return OrganizationLocalServiceUtil.addPrincipalDetails(URLUtil.encodeValue(inputObj.toString()));
		} catch (Exception e) {
			logger.error(e);
			return "";
		}
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public String addMentorToApplication(long processStateId) {
		
		try {
			PEProcessState state = PEProcessStateLocalServiceUtil.getPEProcessState(processStateId);
			state = PEProcessStateLocalServiceUtil.clearCacheAndGetProcessState(state);
			JSONObject stateData = new JSONObject(state.getData());
			JSONObject inputObj = new JSONObject();

			inputObj.put("isExistingMentor",
					getStateDataValue(stateData, "isExistingMentor", "no"));
			inputObj.put("mentorEmailAddress",
					getStateDataValue(stateData, "MentorEmailAddress", StringPool.BLANK));
			inputObj.put("mentorFirstName",
					getStateDataValue(stateData, "MentorFirstName", StringPool.BLANK));

			inputObj.put("mentorLastName",
					getStateDataValue(stateData, "MentorLastName", StringPool.BLANK));
			inputObj.put("mentorId",
					getStateDataValue(stateData, "MentorId", StringPool.BLANK));
			inputObj.put("organizationId",
					getStateDataValue(stateData, "AtoName", StringPool.BLANK));

			PEProcess process = PEProcessLocalServiceUtil.getPEProcess(state.getSpPEProcessId());
			SPSiteSetup siSiteSetup = SPSiteSetupLocalServiceUtil
					.findByProductIdAndSubProductId(process.getProductTypeId(), process.getSubProductTypeId());

			inputObj.put("userId", state.getUserIdProcess());
			inputObj.put("productTypeId", String.valueOf(process.getProductTypeId()));
			inputObj.put("subProductTypeId", String.valueOf(process.getSubProductTypeId()));
			inputObj.put("virtualHostId",
					getStateDataValue(stateData, "virtualHostId", String.valueOf(siSiteSetup.getVirtualHostId())));
			logger.debug("inputObj1 " + inputObj.toString());
			return OrganizationLocalServiceUtil.addMentorToApplication(URLUtil.encodeValue(inputObj.toString()));
		} catch (Exception e) {
			logger.error(e);
			return "";
		}
	}

	@AccessControlled(guestAccessEnabled = true)
	public String isUserLinkedToOrganization(String emailAddress) {
		
		return OrganizationLocalServiceUtil.isUserLinkedToOrganization(emailAddress);
//		long userId = 0;
//		long companyId = PortalUtil.getDefaultCompanyId();
//		try {
//
//			userId = UserLocalServiceUtil.getUserIdByEmailAddress(companyId, emailAddress);
//		} catch (PortalException | SystemException e) {
//			logger.debug("exception Not Linked to any ATO " + companyId + " --- " + emailAddress);
//			return "Not Linked to any ATO";
//		}
//		try {
//			List<SPATOContacts> primarycontact = SPATOContactsLocalServiceUtil
//					.findATOContactsByTrainingPrincipal(userId);
//			List<SPATOContacts> secondarycontact = SPATOContactsLocalServiceUtil
//					.findATOContactsBySecondaryContact(userId);
//			List<ApprovedMentors> mentors = ApprovedMentorsLocalServiceUtil.findApprovedMentorsByUserIdAndStatus(userId,
//					1);
//			if ((primarycontact == null || primarycontact.size() == 0)
//					&& (secondarycontact == null || secondarycontact.size() == 0)
//					&& (mentors == null || mentors.size() == 0)) {
//				logger.debug("Not Linked to any ATOs ");
//				return "Not Linked to any ATO";
//			} else {
//				return "Linked to an ATO";
//			}
//		} catch (Exception e) {
//			logger.error(e);
//			return "Linked to an ATO";
//		}
	}

	@AccessControlled(guestAccessEnabled = true)
	public String getATOContactDetail(long organizationId) {

		try {
			List<SPATOContacts> primarycontact = SPATOContactsLocalServiceUtil
					.findATOContactsByOrganizationId(organizationId);
			List<ApprovedMentors> mentors = ApprovedMentorsLocalServiceUtil
					.findApprovedMentorsByOrganizationId(organizationId);
			com.liferay.portal.kernel.json.JSONObject respJSON = JSONFactoryUtil.createJSONObject();
			if ((primarycontact != null && primarycontact.size() > 0)) {
				respJSON.put("trainingPrincipalUserId", primarycontact.get(0).getPrimaryPrincipalUserId());
				respJSON.put("secondaryContactUserId", primarycontact.get(0).getSecondaryPrincipalUserId());
			}
			if ((mentors != null && mentors.size() > 0)) {
				com.liferay.portal.kernel.json.JSONArray mentorArray = JSONFactoryUtil.createJSONArray();
				for (int i = 0; i < mentors.size(); i++) {
					mentorArray.put(mentors.get(i).getUserId());
				}
				respJSON.put("mentorsUserId", mentorArray);
			}
			return respJSON.toString();
		} catch (Exception e) {
			logger.error(e);
			return "Linked to an ATO";
		}
	}

	private String getStateDataValue(JSONObject stateData, String dataKey, String defaultValue) throws JSONException {
		if (stateData.has(dataKey)) {
			return stateData.getString(dataKey);
		} else {
			return defaultValue;
		}
	}

	private JSONArray getStateDataArrayValue(JSONObject stateData, String dataKey) {
		try {
			String strData = stateData.has(dataKey) ? stateData.getString(dataKey) : StringPool.BLANK;
			return StringUtils.isEmpty(strData) ? new JSONArray() : new JSONArray(strData);
		} catch (Exception e) {
			logger.error(e);
			return new JSONArray();
		}
	}

	@AccessControlled(guestAccessEnabled = true)
	public String updatePrinciples(long processStateId) {
		try {
			PEProcessState state = PEProcessStateLocalServiceUtil.getPEProcessState(processStateId);
			state = PEProcessStateLocalServiceUtil.clearCacheAndGetProcessState(state);
			JSONObject stateData = new JSONObject(state.getData());
			JSONObject inputObj = new JSONObject();

			inputObj.put("p1guideline1", getStateDataValue(stateData, "g1", "0"));
			inputObj.put("p1guideline2", getStateDataValue(stateData, "g2", "0"));
			inputObj.put("p1guideline3", getStateDataValue(stateData, "g3", "0"));
			inputObj.put("p1guideline4", getStateDataValue(stateData, "g4", "0"));
			inputObj.put("p1guideline5", getStateDataValue(stateData, "g5", "0"));
			inputObj.put("p1guideline6", getStateDataValue(stateData, "g6", "0"));
			inputObj.put("p2guideline1", getStateDataValue(stateData, "g7", "0"));
			inputObj.put("p2guideline2", getStateDataValue(stateData, "g8", "0"));
			inputObj.put("p2guideline3", getStateDataValue(stateData, "g9", "0"));
			inputObj.put("p2guideline4", getStateDataValue(stateData, "g10", "0"));
			inputObj.put("p2guideline5", getStateDataValue(stateData, "g11", "0"));
			inputObj.put("p3guideline1", getStateDataValue(stateData, "g12", "0"));
			inputObj.put("p3guideline2", getStateDataValue(stateData, "g13", "0"));
			inputObj.put("p3guideline3", getStateDataValue(stateData, "g14", "0"));
			inputObj.put("p4guideline1", getStateDataValue(stateData, "g15", "0"));
			inputObj.put("p4guideline2", getStateDataValue(stateData, "g16", "0"));
			inputObj.put("p4guideline3", getStateDataValue(stateData, "g17", "0"));
			inputObj.put("p4guideline4", getStateDataValue(stateData, "g18", "0"));
			inputObj.put("p4guideline5", getStateDataValue(stateData, "g19", "0"));
			inputObj.put("p4guideline6", getStateDataValue(stateData, "g20", "0"));
			inputObj.put("moreInfo", getStateDataValue(stateData, "moreinfo", ""));
			inputObj.put("userId", state.getUserIdProcess());
			inputObj.put("virtualHostId", getStateDataValue(stateData, "virtualHostId", "237106"));
			return OrganizationLocalServiceUtil.updatePrinciples(URLUtil.encodeValue(inputObj.toString()));
		} catch (Exception e) {
			logger.error(e);
			return "";
		}

	}

	@AccessControlled(guestAccessEnabled = true)
	public String updateEmployeeInfo(long processStateId) {

		try {
			PEProcessState state = PEProcessStateLocalServiceUtil.getPEProcessState(processStateId);
			state = PEProcessStateLocalServiceUtil.clearCacheAndGetProcessState(state);
			JSONObject stateData = new JSONObject(state.getData());
			JSONObject inputObj = new JSONObject();
			inputObj.put("employees", getStateDataValue(stateData, "employees", "0"));
			inputObj.put("Directors", getStateDataValue(stateData, "Directors", "0"));
			inputObj.put("FinanceEmployees", getStateDataValue(stateData, "FinanceEmployees", "0"));
			inputObj.put("ProfessionalCandidates", getStateDataValue(stateData, "ProfessionalCandidates", "0"));
			inputObj.put("FoundationCandidates", getStateDataValue(stateData, "FoundationCandidates", "0"));
			inputObj.put("AccountancyCandidates", getStateDataValue(stateData, "AccountancyCandidates", "0"));
			inputObj.put("ISCAAccountants", getStateDataValue(stateData, "ISCAAccountants", "0"));
			inputObj.put("ICASAccountants", getStateDataValue(stateData, "ICASAccountants", "0"));
			inputObj.put("ICAEWAccountants", getStateDataValue(stateData, "ICAEWAccountants", "0"));

			inputObj.put("CAIAccountants", getStateDataValue(stateData, "CAIAccountants", "0"));
			inputObj.put("ACCAAccountants", getStateDataValue(stateData, "ACCAAccountants", "0"));
			inputObj.put("CPAAccountants", getStateDataValue(stateData, "CPAAccountants", "0"));
			inputObj.put("CAANZAccountants", getStateDataValue(stateData, "CAANZAccountants", "0"));
			inputObj.put("CPACanadaAccountants", getStateDataValue(stateData, "CPACanadaAccountants", "0"));
			inputObj.put("HKCPAAccountants", getStateDataValue(stateData, "HKCPAAccountants", "0"));

			inputObj.put("SAICAAccountants", getStateDataValue(stateData, "SAICAAccountants", "0"));
			inputObj.put("JICPAAccountants", getStateDataValue(stateData, "JICPAAccountants", "0"));
			inputObj.put("AICPAAccountants", getStateDataValue(stateData, "AICPAAccountants", "0"));
			inputObj.put("CIMAAccountants", getStateDataValue(stateData, "CIMAAccountants", "0"));
			inputObj.put("OthersAccountants", getStateDataValue(stateData, "OthersAccountants", "0"));

			inputObj.put("userId", state.getUserIdProcess());
			inputObj.put("virtualHostId", getStateDataValue(stateData, "virtualHostId", "237106"));

			return OrganizationLocalServiceUtil.updateEmployeeInfo(URLUtil.encodeValue(inputObj.toString()));
		} catch (Exception e) {
			logger.error(e);
			return "";
		}
	}

	@AccessControlled(guestAccessEnabled = true)
	public String updateAccreditation(long processStateId) {
		try {
			PEProcessState state = PEProcessStateLocalServiceUtil.getPEProcessState(processStateId);
			state = PEProcessStateLocalServiceUtil.clearCacheAndGetProcessState(state);
			JSONObject stateData = new JSONObject(state.getData());
			JSONObject inputObj = new JSONObject();
			inputObj.put("aSelected", getStateDataValue(stateData, "aSelected", "0"));
			inputObj.put("aValue", getStateDataValue(stateData, "aValue", ""));
			inputObj.put("bSelected", getStateDataValue(stateData, "bSelected", "0"));
			inputObj.put("bValue", getStateDataValue(stateData, "bValue", ""));
			inputObj.put("cSelected", getStateDataValue(stateData, "cSelected", "0"));
			inputObj.put("cSamepolicy", getStateDataValue(stateData, "cSamepolicy", ""));
			inputObj.put("cCompanyName", getStateDataValue(stateData, "cCompanyName", ""));
			inputObj.put("cElaborate", getStateDataValue(stateData, "cElaborate", ""));
			inputObj.put("dSelected", getStateDataValue(stateData, "dSelected", "0"));
			inputObj.put("dValue", getStateDataValue(stateData, "dValue", ""));

			inputObj.put("userId", state.getUserIdProcess());
			inputObj.put("virtualHostId", getStateDataValue(stateData, "virtualHostId", "237106"));

			return OrganizationLocalServiceUtil.updateAccreditation(URLUtil.encodeValue(inputObj.toString()));
		} catch (Exception e) {
			logger.error(e);
			return "";
		}

	}

	@AccessControlled(guestAccessEnabled = true)
	public Map<String, Object> getOrganizationDetail(long organizationId) {
		try {
			return OrganizationLocalServiceUtil.createOrgDataMap(organizationId);
		} catch (PortalException e) {
			logger.error(e.getMessage());
		} catch (SystemException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@AccessControlled(guestAccessEnabled = true)
	public Map<String, Object> getOrganizationDetailByUserId(long userId) {
		try {
			String organizationId = OrganizationLocalServiceUtil.getCurrentUserBaseOrganization(userId);

			return OrganizationLocalServiceUtil.createOrgDataMap(Long.valueOf(organizationId));
		} catch (PortalException | SystemException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@AccessControlled(guestAccessEnabled = true)
	public String approveMentor(long userId) {
		try {
			List<ApprovedMentors> mentors = ApprovedMentorsLocalServiceUtil.findByUserId(String.valueOf(userId));
			for (ApprovedMentors approvedMentors : mentors) {
				approvedMentors.setStatus(1);
				approvedMentors.setApprovedDate(DateUtil.newDate());
				ApprovedMentorsLocalServiceUtil.updateApprovedMentors(approvedMentors);
			}
		} catch (SystemException e) {
			logger.error(e.getMessage());
			return "Error";
		}
		return "Success";
	}

	@AccessControlled(guestAccessEnabled = true)
	public String rejectMentor(long userId) {
		try {
			List<ApprovedMentors> mentors = ApprovedMentorsLocalServiceUtil.findByUserId(String.valueOf(userId));
			for (ApprovedMentors approvedMentors : mentors) {
				approvedMentors.setStatus(2);
				ApprovedMentorsLocalServiceUtil.updateApprovedMentors(approvedMentors);
			}
		} catch (SystemException e) {
			logger.error(e.getMessage());
			return "Error";
		}
		return "Success";
	}

	@AccessControlled(guestAccessEnabled = true)
	public String approveATO(long organizationId) {
		return OrganizationLocalServiceUtil.approveATO(organizationId);
	}

	@AccessControlled(guestAccessEnabled = true)
	public String approveATOByUserId(long userId) {
		return OrganizationLocalServiceUtil.approveATOByUserId(userId);
	}

	@AccessControlled(guestAccessEnabled = true)
	public List<ApprovedMentors> getApprovedMentors(long organizationId) {
		return ApprovedMentorsLocalServiceUtil.findApprovedMentorsByOrganizationId(organizationId);
	}

	@AccessControlled(guestAccessEnabled = true)
	public List<ApprovedMentors> getAllApprovedMentors(int status) {
		return ApprovedMentorsLocalServiceUtil.findApprovedMentorsByStatus(status);
	}

	@AccessControlled(guestAccessEnabled = true)
	public List<ApprovedMentors> findApprovedMentorsByOrganizationIdAndStatus(long organizationId, int status) {
		return ApprovedMentorsLocalServiceUtil.findApprovedMentorsByOrganizationIdAndStatus(organizationId, status);
	}

	@AccessControlled(guestAccessEnabled = true)
	public List<ApprovedMentors> findApprovedMentorsByUserIdAndStatus(long userId, int status) {
		return ApprovedMentorsLocalServiceUtil.findApprovedMentorsByUserIdAndStatus(userId, status);
	}

	@AccessControlled(guestAccessEnabled = true)
	public List<ApprovedMentors> findMentorsByOrganizationId(long organizationId) {
		return ApprovedMentorsLocalServiceUtil.findMentorsByOrganizationId(organizationId);
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public void removeRole(long userId) {
		if (!PortalUtil.isOmniadmin(userId)) {
			OrganizationLocalServiceUtil.removeRole(userId);
		}
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public void transerOwnership(Long userId){
		OrganizationLocalServiceUtil.transferOwnership(userId);
	}
	
}
