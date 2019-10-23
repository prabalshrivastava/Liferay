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

package com.sambaash.platform.srv.spsocialprofile.service.impl;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.portlet.ResourceRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.DuplicateUserScreenNameException;
import com.liferay.portal.NoSuchRoleException;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.UserScreenNameException;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.EmailAddress;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.model.Website;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.EmailAddressLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PhoneLocalServiceUtil;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.service.WebsiteLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.SubscriptionSender;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.constant.SambaashConstants.REGISTRATION;
import com.sambaash.platform.model.AddressMap;
import com.sambaash.platform.model.ProfileType;
import com.sambaash.platform.model.SPAddress;
import com.sambaash.platform.portlet.socialprofile.util.ProfileConstants;
import com.sambaash.platform.portlet.socialprofile.util.UserProfileUtil;
import com.sambaash.platform.portlet.socialprofile.util.XMLManipulator;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.spservices.NoSuchSPParameterException;
import com.sambaash.platform.srv.spservices.model.SPListType;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.model.SPUserTypeConfig;
import com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPUserTypeConfigLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException;
import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail;
import com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar;
import com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileBaseImpl;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileDetailLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.service.UserAvailabilityCalendarLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.service.base.SocialProfileLocalServiceBaseImpl;
import com.sambaash.platform.srv.spsocialprofile.service.persistence.SocialProfileUtil;
import com.sambaash.platform.util.PermissionUtil;
import com.sambaash.platform.util.SambaashHtmlUtil;
import com.sambaash.platform.util.SambaashUtil;

public class SocialProfileLocalServiceImpl extends SocialProfileLocalServiceBaseImpl {

	private static Log _log = LogFactoryUtil.getLog(SocialProfileLocalServiceImpl.class);

	private static String SHIPPING_OR_BILLING_ADDRESS = "shipping_or_billing_address";
	public static final String PORTLET_ID = "UserProfile_WAR_UserProfileportlet";

	public List<SocialProfile> findBymemberPackageId(String memberPackage) throws SystemException {
		return SocialProfileUtil.findByMemberPackageId(Long.valueOf(memberPackage));
	}

	public String getIndProfilePublicUrl(long companyId, long scopeGroupId, long userId) {
		try {
			SPParameter param = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(scopeGroupId,
					SambaashConstants.URL.PROFILE_IND_PUBLIC);
			return SambaashUtil.getCommunityPath(scopeGroupId) + StringPool.FORWARD_SLASH + param.getValue()
					+ "?compId=" + companyId + "&userId=" + userId;
		} catch (NoSuchSPParameterException e) {
			_log.error(SambaashConstants.URL.PROFILE_IND_PUBLIC + " doesn't exist.");
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		return null;
	}

	public String getIndProfilePrivateUrl(long companyId, long scopeGroupId, long userId) {
		try {
			SPParameter param = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(scopeGroupId,
					SambaashConstants.URL.PROFILE_IND_PRIVATE);
			return SambaashUtil.getCommunityPath(scopeGroupId) + StringPool.FORWARD_SLASH + param.getValue()
					+ "?compId=" + companyId + "&userId=" + userId;
		} catch (NoSuchSPParameterException e) {
			_log.error(SambaashConstants.URL.PROFILE_IND_PRIVATE + " doesn't exist.");
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		return null;
	}

	public String getIndProfileLandingUrl(long companyId, long scopeGroupId, long userId) {
		try {
			SPParameter param = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(scopeGroupId,
					SambaashConstants.URL.PROFILE_IND_LADNING);
			return SambaashUtil.getCommunityPath(scopeGroupId) + StringPool.FORWARD_SLASH + param.getValue()
					+ "?compId=" + companyId + "&userId=" + userId;
		} catch (NoSuchSPParameterException e) {
			_log.error(SambaashConstants.URL.PROFILE_IND_LADNING + " doesn't exist.");
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		return null;
	}

	public String getCorpProfilePublicUrl(long companyId, long scopeGroupId, long userId) {
		try {
			SPParameter param = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(scopeGroupId,
					SambaashConstants.URL.PROFILE_CORP_PUBLIC);
			return SambaashUtil.getCommunityPath(scopeGroupId) + StringPool.FORWARD_SLASH + param.getValue()
					+ "?myProfile=public&mode=view&compId=" + companyId + "&id=" + userId;

		} catch (NoSuchSPParameterException e) {
			_log.error(SambaashConstants.URL.PROFILE_CORP_PUBLIC + " doesn't exist.");
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		return null;
	}

	public String getCorpProfilePrivateUrl(long companyId, long scopeGroupId, String userId) {
		try {
			SPParameter param = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(scopeGroupId,
					SambaashConstants.URL.PROFILE_CORP_PUBLIC);
			return SambaashUtil.getCommunityPath(scopeGroupId) + StringPool.FORWARD_SLASH + param.getValue()
					+ "?myProfile=public&mode=view&compId=" + companyId + "&id=" + userId;
		} catch (NoSuchSPParameterException e) {
			_log.error(SambaashConstants.URL.PROFILE_CORP_PUBLIC + " doesn't exist.");
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		return null;
	}

	public String getCorpProfileLandingUrl(long companyId, long scopeGroupId, String userId) {
		try {
			SPParameter param = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(scopeGroupId,
					SambaashConstants.URL.PROFILE_CORP_LANDING);
			return SambaashUtil.getCommunityPath(scopeGroupId) + StringPool.FORWARD_SLASH + param.getValue()
					+ "?myProfile=public&mode=view&compId=" + companyId + "&id=" + userId;
		} catch (NoSuchSPParameterException e) {
			_log.error(SambaashConstants.URL.PROFILE_CORP_LANDING + " doesn't exist.");
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		return null;
	}

	public SocialProfile addSocialProfileForIndividualUser(long userId, String emailAddress, long companyId)
			throws SystemException {
		SocialProfile profile = socialProfilePersistence.create(userId);
		profile.setCompanyId(companyId);
		profile.setUserRegistrationStatus(REGISTRATION.USER_REGISTRATION_STATUS_INACTIVE);
		profile.setUserType(REGISTRATION.USER_TYPE_INDIVIDUAL);

		socialProfilePersistence.update(profile);

		Indexer indexer = IndexerRegistryUtil.getIndexer(SocialProfile.class.getName());
		try {
			indexer.reindex(profile);
		} catch (SearchException e) {
			_log.error(e.getMessage(), e);
		}

		return profile;
	}

	public SocialProfile addSocialProfileForCorporate(long userId, String emailAddress, long companyId)
			throws SystemException {
		SocialProfile profile;
		try {
			profile = SocialProfileUtil.findByUserIdAndCompanyId(companyId, userId);
		} catch (NoSuchSocialProfileException e) {
			_log.error(" Corporate User not added by UserListener. Adding it now ...");
			profile = socialProfilePersistence.create(userId);
		}

		//
		profile.setCompanyId(companyId);
		profile.setUserRegistrationStatus(REGISTRATION.USER_REGISTRATION_STATUS_ACTIVE);
		profile.setUserType(REGISTRATION.USER_TYPE_CORPORATE);
		profile.setUserInfo(null);
		socialProfilePersistence.update(profile);
		return profile;
	}

	public int incrementProfileViewCount(long userId, long companyId) throws SystemException {

		int count = 0;

		try {
			SocialProfile profile = SocialProfileUtil.findByUserIdAndCompanyId(companyId, userId);
			count = profile.getProfileViewCount() + 1;
			profile.setProfileViewCount(count);
			profile.setModifiedDate(new Date());
			socialProfilePersistence.update(profile);

			// update search document

			Indexer indexer = IndexerRegistryUtil.getIndexer(SocialProfile.class.getName());
			try {
				indexer.reindex(profile);
			} catch (SearchException e) {
				_log.error(e.getMessage(), e);
			}
		} catch (NoSuchSocialProfileException e) {
			_log.error(" Profile doesn't exist ");
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		return count;
	}

	public int getProfileViewCount(long userId, long companyId) {
		int count = 0;

		try {
			SocialProfile profile = SocialProfileUtil.findByUserIdAndCompanyId(companyId, userId);

			if (profile != null && "active".equalsIgnoreCase(profile.getUserRegistrationStatus())) {
				count = profile.getProfileViewCount();
			}

		} catch (NoSuchSocialProfileException e) {
			_log.error(" Profile doesn't exist ");
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		return count;
	}

	public SocialProfile findByuserIdCompIdAndRegStatus(long userId, long companyId, String userRegistrationStatus) {
		try {
			SocialProfile profile = SocialProfileUtil.findByUserIdCompIdAndRegStatus(companyId, userId,
					userRegistrationStatus);
			return profile;
		} catch (NoSuchSocialProfileException e) {
			_log.error(" Profile doesn't exist ");
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		return null;
	}

	public boolean isIndividualUser(long userId, long companyId) {
		try {
			SocialProfile profile = getSocialProfile(userId, companyId);

			if (profile != null
					&& !SambaashConstants.REGISTRATION.USER_TYPE_INDIVIDUAL.equalsIgnoreCase(profile.getUserType())) {
				return false;
			}

			return true;
		} catch (NoSuchSocialProfileException e) {
			_log.error(" Profile doesn't exist ");
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		return false;
	}

	public SocialProfile updateSocialProfileAndTags(SocialProfile profile, String[] assetTagNames, long groupId)
			throws SystemException {
		long[] assetcategory = null;

		try {
			addOrUpdateAsset(profile.getUserId(), groupId, profile, assetcategory, assetTagNames, true);
		} catch (PortalException e) {
			_log.error("Failed updating asset tags");
		}

		return profile;
	}

	public String getUserScreenName(long userId) {
		try {
			User user = (User) UserLocalServiceUtil.getUser(userId);
			return user.getScreenName();
		} catch (PortalException e) {
			_log.error("Failed in getting screen name - No user found");
		} catch (SystemException e) {
			_log.error("Failed in getting screen name - No user found");
		}

		return "";
	}

	public SocialProfile getSocialProfile(long userId, long companyId) throws SystemException,
			NoSuchSocialProfileException {
		return SocialProfileUtil.findByUserIdAndCompanyId(companyId, userId);
	}

	// TODO: remove portletprefs, no longer used

	public SocialProfile updateSocialProfile(SocialProfile profile) throws SystemException {
		try {
			socialProfilePersistence.update(profile);

			// update index only for individual

			if (profile.getUserType().equalsIgnoreCase(SambaashConstants.REGISTRATION.USER_TYPE_INDIVIDUAL)) {
				Indexer indexer = IndexerRegistryUtil.getIndexer(SocialProfile.class.getName());
				try {
					indexer.reindex(profile);
				} catch (SearchException e) {
					_log.error("Failed to reindex : NoSuchLayoutException." + e.getMessage());

					if (_log.isDebugEnabled()) {
						_log.error(e.getMessage(), e);
					}
				} catch (Exception e) {
					_log.error(e.getMessage(), e);
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}

		return profile;
	}
	public void reIndex(SocialProfile profile) throws SearchException{
		// update index only for individual
		if (profile.getUserType().equalsIgnoreCase(SambaashConstants.REGISTRATION.USER_TYPE_INDIVIDUAL)) {
			Indexer indexer = IndexerRegistryUtil.getIndexer(SocialProfile.class.getName());
			indexer.reindex(profile);
		}
	}
	public SocialProfile updateSocialProfile_No_Indexing(SocialProfile profile) throws SystemException {
		try {
			socialProfilePersistence.update(profile);
		} catch (Exception e) {
			_log.error(e);
		}
		
		return profile;
	}

	public com.liferay.portlet.asset.model.AssetEntry addOrUpdateAsset(long userId, long groupId,
			SocialProfile profile, long[] assetCategoryIds, java.lang.String[] assetTagNames, boolean visible)
			throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {

		return AssetEntryLocalServiceUtil.updateEntry(userId, groupId, SocialProfile.class.getName(),
				profile.getPrimaryKey(), null, assetTagNames);
	}

	public SocialProfile addOrUpdateSocialProfile(SocialProfile socialProfile, User user, boolean booleanMerge,
			long scopeGroupId) throws SystemException {
		return addOrUpdateSocialProfile(socialProfile, user, booleanMerge, scopeGroupId, false);
	}

	public SocialProfile addOrUpdateSocialProfile(SocialProfile socialProfile, User user, boolean booleanMerge,
			long scopeGroupId, boolean fromListener) throws SystemException {
		if (socialProfile == null) {
			SPParameter parameter;
			String xmlTemplate = StringPool.BLANK;

			try {
				parameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(scopeGroupId,
						"socialprofile.xml.template");
				xmlTemplate = parameter.getDescription();
			} catch (NoSuchSPParameterException e1) {
				_log.error("Error retrieving xml template", e1);
			}

			socialProfile = socialProfilePersistence.create(user.getUserId());
			socialProfile.setCompanyId(user.getCompanyId());
			socialProfile.setUserRegistrationStatus(REGISTRATION.USER_REGISTRATION_STATUS_INACTIVE);
			socialProfile.setUserType(REGISTRATION.USER_TYPE_INDIVIDUAL);
			socialProfile.setCreateDate(user.getCreateDate());
			socialProfile.setUserInfo(xmlTemplate);
		}

		try {

			// Naresh - 29-Oct-2014 - Added this snippet to activate user
			// account for the ldap user

			if (Boolean.parseBoolean(PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.LDAP_AUTH_ENABLED))) {
				String mpId = SambaashUtil.getParameter(SambaashConstants.DEFAULT_MEMBERSHIP_PACKAGE_ID,
						Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID));

				if (Validator.isNumber(mpId)) {
					socialProfile.setMemberPackage(Long.parseLong(mpId));
				}

				socialProfile.setUserRegistrationStatus(SambaashConstants.REGISTRATION.USER_REGISTRATION_STATUS_ACTIVE);
			}
		} catch (Exception e1) {
			_log.error(e1.getMessage(), e1);
		}

		try {
			transformSocialProfileXML(socialProfile, user);
			updatePersonalInfo(socialProfile, user);
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		socialProfile = SocialProfileLocalServiceUtil.updateSocialProfile(socialProfile);

		return socialProfile;
	}

	public void updateBirthday(User user, Date birthday) throws PortalException, SystemException {
		Contact contact = ContactLocalServiceUtil.getContact(user.getContactId());
		contact.setBirthday(birthday);
		ContactLocalServiceUtil.updateContact(contact);
	}

	public void updateGender(User user, String gender) throws PortalException, SystemException {
		Contact contact = ContactLocalServiceUtil.getContact(user.getContactId());
		String isMale = gender.toLowerCase();

		if (isMale.equals("male") || isMale.equals("1") || isMale.equals("m")) {
			contact.setMale(true);
		} else {
			contact.setMale(false);
		}

		ContactLocalServiceUtil.updateContact(contact);
	}

	public String updateSingleNodeField(String xml, String nodeToUpdate, String val) throws Exception {
		XMLManipulator manipulator = new XMLManipulator(xml);
		manipulator.setValue(val, "//" + nodeToUpdate);
		return manipulator.toString(null);
	}

	/**
	 * Deletes the node of the corresponding attributes
	 *
	 * @param categoryName
	 * @param categoryDetails
	 * @param instance
	 * @param response
	 * @param profileUser
	 * @param scopeGroupId
	 * @return deleted node position
	 */
	public int deleteXMLInstance(String categoryName, String categoryDetails, String instance, SocialProfile profileUser) {
		XMLManipulator manipulator = new XMLManipulator(profileUser.getUserInfo());

		int count = 0;

		try {
			count = manipulator.countXmlNode(categoryDetails);

			manipulator.removeNodeByAttributeValue("id", instance, categoryDetails);

			String resultXML = manipulator.toString(null);

			profileUser.setUserInfo(resultXML);

			SocialProfileLocalServiceUtil.updateSocialProfile(profileUser);

			count -= 1;
		} catch (Exception e) {
			_log.error("cannot remove the specified field with instance " + categoryName + instance + e.getMessage());
		}

		return count;
	}

	public void deleteAllWorkHistory(SocialProfile profileUser) {
		XMLManipulator manipulator = new XMLManipulator(profileUser.getUserInfo());

		try {
			manipulator.removeAllNodes("workhistory", "work_details");
			profileUser.setUserInfo(manipulator.toString(null));

			SocialProfileLocalServiceUtil.updateSocialProfile(profileUser);

			List<SocialProfileDetail> profileDetailList = SocialProfileDetailLocalServiceUtil.findByUserId(profileUser
					.getUserId());

			for (SocialProfileDetail socialProfileDetail : profileDetailList) {
				SocialProfileDetailLocalServiceUtil.deleteSocialProfileDetail(socialProfileDetail);
			}

		} catch (Exception e) {
			_log.error("Error deleting work history", e);
		}
	}

	public void addOrUpdateWorkHistory(String categoryName, String categoryDetails, String instance,
			SocialProfile profileUser, long scopeGroupId, Map<String, String> details) {
		XMLManipulator manipulator = null;
		String xmlFile = "";
		SPParameter parameter = null;

		try {
			manipulator = new XMLManipulator(profileUser.getUserInfo());

			// check if the same nodeId exists, otherwise create a new node

			String attr = manipulator.findNodeById(categoryDetails, "id", instance);

			if (attr == null) { // create new node

				try {
					parameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(scopeGroupId, categoryName
							+ ".xml.template");
					xmlFile = parameter.getDescription();
				} catch (NoSuchSPParameterException e1) {
					_log.error("Error retrieving xml template", e1);
				}

				String nodeId = instance;
				manipulator.appendXmlWithId(categoryName, xmlFile, nodeId);
				profileUser.setUserInfo(manipulator.toString(null));
			}

			// populate with values
			for (Map.Entry<String, String> work : details.entrySet()) {
				String fieldName = work.getKey();
				String fieldValue = work.getValue();
				if ((fieldName != null) && (!fieldName.equals(""))) {
					String nodeXQuery = "//workhistory/work_details[@id='" + instance + "']/" + fieldName;
					manipulator.setNodeValue(fieldValue, nodeXQuery);
				}

				if (_log.isDebugEnabled()) {
					_log.debug("Original Value : " + fieldValue);
					_log.debug("Escaped Value : " + SambaashHtmlUtil.escape(fieldValue));
					_log.debug("UnEscaped Value : " + SambaashHtmlUtil.unescape(fieldValue));
				}
			}
			
			String resultXML = manipulator.toString(null);
			profileUser.setUserInfo(resultXML);
			SocialProfileLocalServiceUtil.updateSocialProfile(profileUser);
			SocialProfileLocalServiceUtil.saveWorkHistorySorted(profileUser, resultXML);
		} catch (Exception e) {
			_log.error("Error on saveWorkHistoryDetails: " + e.getMessage());
		}
	}
	
	public void addOrUpdateWorkHistoryFromFormData(String categoryName, String categoryDetails, String instance,
			SocialProfile profileUser, long scopeGroupId, Map<String, String> details) {
		XMLManipulator manipulator = null;
		String xmlFile = "";
		SPParameter parameter = null;

		try {
			manipulator = new XMLManipulator(profileUser.getUserInfo());

			// check if the same nodeId exists, otherwise create a new node

			String attr = manipulator.findNodeById(categoryDetails, "id", instance);

			if (attr == null) { // create new node

				try {
					parameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(scopeGroupId, categoryName
							+ ".xml.template");
					xmlFile = parameter.getDescription();
				} catch (NoSuchSPParameterException e1) {
					_log.error("Error retrieving xml template", e1);
				}

				String nodeId = instance;
				manipulator.appendXmlWithId(categoryName, xmlFile, nodeId);
				profileUser.setUserInfo(manipulator.toString(null));
			}

			// populate with values
			long maxValue = 0;
			String jobTitle =  StringPool.BLANK;
			String compName =  StringPool.BLANK;
			String existJobTitle =  StringPool.BLANK;
			String existCompName =  StringPool.BLANK;
			for (Map.Entry<String, String> work : details.entrySet()) {
				if("job_title".equalsIgnoreCase(work.getKey())){
					jobTitle = work.getValue();
				}
				if("company_name".equalsIgnoreCase(work.getKey())){
					compName = work.getValue();
				}	
			}	
			
			try{
			NodeList targetNodeList = manipulator.findNodeList("//profile/workhistory/work_details");
			if (Validator.isNotNull(targetNodeList)) {
				for (int i = 0; i < targetNodeList.getLength()-1; i++) {
					Node targetNode = targetNodeList.item(i);
					String nodeid1 = targetNode.getAttributes().getNamedItem("id").getNodeValue();
					if (Long.parseLong(nodeid1) > maxValue) {
					    maxValue = Long.parseLong(nodeid1);
					}
					_log.debug("getAttributes " + targetNode.getAttributes().getNamedItem("id"));
				}
				
				NodeList targetNodeList1 = manipulator.findNodeList("//profile/workhistory/work_details[@id='" + maxValue + "']/job_title");
				existJobTitle = targetNodeList1.item(0).getTextContent();
				NodeList targetNodeList2 = manipulator.findNodeList("//profile/workhistory/work_details[@id='" + maxValue + "']/company_name");
				existCompName = targetNodeList2.item(0).getTextContent();
				_log.error("existJobTitle " + existJobTitle + " existCompName " + existCompName);
				
			}	
			}catch(Exception e){
				_log.error("Workdetail node not found " + e.getMessage());
			}
			_log.debug("maxValue " + maxValue);
			
			if(!jobTitle.equalsIgnoreCase(existJobTitle) && !compName.equalsIgnoreCase(existCompName)){
				_log.debug("updating new entry for workhistory from form data");
				for (Map.Entry<String, String> work : details.entrySet()) {
					String fieldName = work.getKey();
					String fieldValue = work.getValue();
					if ((fieldName != null) && (!fieldName.equals(""))) {
						String nodeXQuery = "//workhistory/work_details[@id='" + instance + "']/" + fieldName;
						manipulator.setNodeValue(fieldValue, nodeXQuery);
					}
	
					if (_log.isDebugEnabled()) {
						_log.debug("Original Value : " + fieldValue);
						_log.debug("Escaped Value : " + SambaashHtmlUtil.escape(fieldValue));
						_log.debug("UnEscaped Value : " + SambaashHtmlUtil.unescape(fieldValue));
					}
				}

				String resultXML = manipulator.toString(null);
				profileUser.setUserInfo(resultXML);
				SocialProfileLocalServiceUtil.updateSocialProfile(profileUser);
				SocialProfileLocalServiceUtil.saveWorkHistorySorted(profileUser, resultXML);
			}else if(compName.equalsIgnoreCase(existCompName)){
				if(!jobTitle.equalsIgnoreCase(existJobTitle)){
				_log.debug("updating new entry for workhistory from form data");
				for (Map.Entry<String, String> work : details.entrySet()) {
					String fieldName = work.getKey();
					String fieldValue = work.getValue();
					if ((fieldName != null) && (!fieldName.equals(""))) {
						String nodeXQuery = "//workhistory/work_details[@id='" + instance + "']/" + fieldName;
						manipulator.setNodeValue(fieldValue, nodeXQuery);
					}
	
					if (_log.isDebugEnabled()) {
						_log.debug("Original Value : " + fieldValue);
						_log.debug("Escaped Value : " + SambaashHtmlUtil.escape(fieldValue));
						_log.debug("UnEscaped Value : " + SambaashHtmlUtil.unescape(fieldValue));
					}
				}

				String resultXML = manipulator.toString(null);
				profileUser.setUserInfo(resultXML);
				SocialProfileLocalServiceUtil.updateSocialProfile(profileUser);
				SocialProfileLocalServiceUtil.saveWorkHistorySorted(profileUser, resultXML);
				
				}else{
					_log.error("job title from the submitted form data already exists for the entered company. Skipping profile xml update");
				}
			}else{
				_log.error("job title & company name from the submitted form data already exists. Skipping profile xml update");
			}
		} catch (Exception e) {
			_log.error("Error on saveWorkHistoryDetails: " + e.getMessage());
		}
	}
	
	public com.liferay.portal.kernel.json.JSONObject getUserWorkHistoryDetails(SocialProfile profileUser){
		XMLManipulator manipulator = new XMLManipulator(profileUser.getUserInfo());
		String jobTitle = StringPool.BLANK;
		String compName = StringPool.BLANK;
		String companyType = StringPool.BLANK;
		String startDate = StringPool.BLANK;
		String endDate = StringPool.BLANK;
		String workDescription = StringPool.BLANK;
		String industryType = StringPool.BLANK;
		com.liferay.portal.kernel.json.JSONObject jsonList = null;
		try{
			NodeList targetNodeList = manipulator.findNodeList("//profile/workhistory/work_details");
			jsonList = JSONFactoryUtil.createJSONObject();
			if (Validator.isNotNull(targetNodeList)) {
				for (int i = 0; i < targetNodeList.getLength(); i++) {
				NodeList targetNodeList1 = manipulator.findNodeList("//profile/workhistory/work_details/job_title");
				jobTitle = targetNodeList1.item(i).getTextContent();
				NodeList targetNodeList2 = manipulator.findNodeList("//profile/workhistory/work_details/company_name");
				compName = targetNodeList2.item(i).getTextContent();
				NodeList targetNodeList3 = manipulator.findNodeList("//profile/workhistory/work_details/company_type");
				companyType = targetNodeList3.item(i).getTextContent();
				NodeList targetNodeList4 = manipulator.findNodeList("//profile/workhistory/work_details/industry_type");
				industryType = targetNodeList4.item(i).getTextContent();
				NodeList targetNodeList5 = manipulator.findNodeList("//profile/workhistory/work_details/start_date");
				startDate = targetNodeList5.item(i).getTextContent();
				NodeList targetNodeList6 = manipulator.findNodeList("//profile/workhistory/work_details/end_date");
				endDate = targetNodeList6.item(i).getTextContent();
				NodeList targetNodeList7 = manipulator.findNodeList("//profile/workhistory/work_details/work_description");
				if(!targetNodeList7.item(i).getTextContent().isEmpty()){
					String descVal = HtmlUtil.unescape(targetNodeList7.item(i).getTextContent().trim());
					workDescription = descVal;
				}	
				
				SimpleDateFormat month_date = new SimpleDateFormat("MMMM yyyy", Locale.ENGLISH);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				int startDateYear = 0;
				int endDateYear = 0;
				int startDateMonth = 0;
				int endDateMonth = 0;
				if(!startDate.isEmpty()){
					Date date = sdf.parse(startDate);
					startDateYear = date.getYear();
					startDateMonth = date.getMonth();
					startDate = month_date.format(date);
				}
				if(!endDate.isEmpty() && !endDate.equalsIgnoreCase("present")){
					Date date = sdf.parse(endDate);
					endDateYear = date.getYear();
					endDateMonth = date.getMonth();
					endDate = month_date.format(date);
				}	
				if(endDate.equalsIgnoreCase("present")){
					endDate = "Present";
					endDateYear = new Date().getYear();
					endDateMonth = new Date().getMonth();
				}
				
				String workExperience = (endDateYear - startDateYear) + " years " +  (endDateMonth - startDateMonth) + " months";
				com.liferay.portal.kernel.json.JSONObject workHistoryValues = JSONFactoryUtil.createJSONObject();
				workHistoryValues.put("jobTitle", jobTitle);
				workHistoryValues.put("companyName", compName);
				workHistoryValues.put("companyType", companyType);
				workHistoryValues.put("industryType", industryType);
				workHistoryValues.put("startDate", startDate);
				workHistoryValues.put("endDate", endDate);
				workHistoryValues.put("workExperience", workExperience);
				workHistoryValues.put("workDescription", workDescription);
				jsonList.put("workhistory"+i,workHistoryValues);
				}
			}	
			}catch(Exception e){
				_log.error("Workdetail node not found " + e.getMessage());
			}
		return jsonList;
	}
	
	
	public com.liferay.portal.kernel.json.JSONObject getUserTransactionHistoryDetails(SocialProfile profileUser, String formName, String formTagName, String[] formFields){
		XMLManipulator manipulator = new XMLManipulator(profileUser.getUserInfo());
		String transactionHistroryDetail = StringPool.BLANK;
		com.liferay.portal.kernel.json.JSONObject jsonList = null;
		try{
			NodeList targetNodeList = manipulator.findNodeList("//profile/other_details/"+formName+"/"+formTagName);
			jsonList = JSONFactoryUtil.createJSONObject();
			if (Validator.isNotNull(targetNodeList)) {
				for (int i = 0; i < targetNodeList.getLength(); i++) {
					com.liferay.portal.kernel.json.JSONObject transactionHistoryValues = JSONFactoryUtil.createJSONObject();
					for (String formField : formFields){
						NodeList transactionHistroryDetailNode = manipulator.findNodeList("//profile/other_details/"+formName+"/"+formTagName+"/"+formField);
						transactionHistroryDetail = transactionHistroryDetailNode.item(i).getTextContent();
						
						if (transactionHistroryDetailNode.item(i).getAttributes().getNamedItem("fieldType").getNodeValue().equalsIgnoreCase("Calendar")){
							SimpleDateFormat month_date_year = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							if(!transactionHistroryDetail.isEmpty()){
								Date date = sdf.parse(transactionHistroryDetail);;
								transactionHistroryDetail = month_date_year.format(date);
							}
						}
						
						transactionHistoryValues.put(formField, transactionHistroryDetail);
					}
				
	
				jsonList.put("transactionHistory"+i,transactionHistoryValues);
				}
				
			}	
			}catch(Exception e){
				_log.error("TransactionHistory node not found " + e.getMessage());
			}
		return jsonList;
	}

	public SocialProfile addNetworkInfo(SocialProfile socialProfile, String categoryName, String categoryDetail,
			String value) throws Exception {
		XMLManipulator manipulator = new XMLManipulator(socialProfile.getUserInfo());

		if (categoryName.equals("messenger")) {
			String[] nameval = value.split(":");
			manipulator.appendNodeNameValue("//" + categoryName, "messenger_url", nameval[0], nameval[1]);
		} else {
			manipulator.appendNodeWithIdValue(categoryDetail, value, "//" + categoryName);
		}

		String xml = manipulator.toString(null);
		socialProfile.setUserInfo(xml);
		socialProfile = SocialProfileLocalServiceUtil.updateSocialProfile(socialProfile);

		updateUserNetworkInfoFromSocialProfile(socialProfile); // update

		// contacts_
		// table with
		// values from
		// social
		// profile

		return socialProfile;
	}

	public void addOrUpdateAvailability(String categoryName, String categoryDetails, String instance,
			SocialProfile profileUser, long groupId, Map<String, String> details) {

		XMLManipulator manipulator = null;
		String xmlFile = "";
		SPParameter parameter = null;

		try {
			manipulator = new XMLManipulator(profileUser.getUserInfo());

			// check if the same nodeId exists, otherwise create a new node

			String attr = manipulator.findNodeById(categoryDetails, "id", instance);

			if (attr == null) { // create new node
				try {
					parameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(groupId, categoryName
							+ ".xml.template");
					xmlFile = parameter.getDescription();
				} catch (NoSuchSPParameterException e1) {
					_log.error("Error retrieving xml template", e1);
				}

				String nodeId = instance;
				manipulator.appendXmlWithId(categoryName, xmlFile, nodeId);
				profileUser.setUserInfo(manipulator.toString(null));
			}

			// populate with values

			for (Map.Entry<String, String> work : details.entrySet()) {
				String fieldName = work.getKey();
				String fieldValue = work.getValue();

				if ((fieldName != null) && (!fieldName.equals(""))) {
					String nodeXQuery = "//availability_info/user_availability[@id='" + instance + "']/" + fieldName;
					manipulator.setNodeValue(fieldValue, nodeXQuery);
				}
			}

			profileUser.setUserInfo(manipulator.toString(null));

			SocialProfileLocalServiceUtil.updateSocialProfile(profileUser);
			SocialProfileLocalServiceUtil.saveAvailabilityInfo(profileUser);

		} catch (Exception e) {
			_log.error("Error on saveAvailabilityDetails: " + e.getMessage());
		}
	}

	public void addOrUpdateDynamicSection(String categoryName, String categoryDetails, String instance,
			SocialProfile profileUser, long groupId, Map<String, String> details) {

		XMLManipulator manipulator = null;
		String xmlFile = "";
		SPParameter parameter = null;

		try {
			manipulator = new XMLManipulator(profileUser.getUserInfo());

			// check if the same nodeId exists, otherwise create a new node

			String attr = manipulator.findNodeById("other_details" + StringPool.SLASH + categoryName + StringPool.SLASH
					+ categoryDetails, "id", instance);

			if (Validator.isNull(attr)) { // create new node
				try {
					parameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(groupId, categoryName
							+ ".xml.template");
					xmlFile = parameter.getDescription();
				} catch (NoSuchSPParameterException e1) {
					_log.error("Error retrieving xml template", e1);
				}

				String nodeId = instance;

				Node node = manipulator.appendXmlWithId("//other_details/" + categoryName, xmlFile, nodeId);

				if (node == null) {
					manipulator.appendNode(categoryName, "//other_details");
					manipulator.appendXmlWithId("//other_details/" + categoryName, xmlFile, nodeId);
				}

				profileUser.setUserInfo(manipulator.toString(null));
			}

			// populate with values

			for (Map.Entry<String, String> work : details.entrySet()) {
				String fieldName = work.getKey();
				String fieldValue = work.getValue();

				if ((fieldName != null) && (!fieldName.equals(""))) {
					String nodeXQuery = "//other_details/" + categoryName + "/" + categoryDetails + "[@id='" + instance
							+ "']/" + fieldName;
					manipulator.setNodeValue(fieldValue, nodeXQuery);
				}
			}

			profileUser.setUserInfo(manipulator.toString(null));
			SocialProfileLocalServiceUtil.updateSocialProfile(profileUser);

		} catch (Exception e) {
			_log.error("Error on addOrUpdateDynamicSection: " + e.getMessage());
		}
	}
	
	public void addOrUpdateDynamicSection(String categoryName, String categoryDetails,
			SocialProfile profileUser, long groupId, Map<String, String> details) {

		XMLManipulator manipulator = null;
		String xmlFile = "";
		SPParameter parameter = null;

		try {
			manipulator = new XMLManipulator(profileUser.getUserInfo());

			// check if the same nodeId exists, otherwise create a new node

			Node attr = manipulator.findNode("other_details" + StringPool.SLASH + categoryName + StringPool.SLASH
					+ categoryDetails);

			if (Validator.isNull(attr)) { // create new node
				try {
					parameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(groupId, categoryName
							+ ".xml.template");
					xmlFile = parameter.getDescription();
				} catch (NoSuchSPParameterException e1) {
					_log.error("Error retrieving xml template", e1);
				}

				Node node = manipulator.appendXml("//other_details/" + categoryName, xmlFile);

				if (node == null) {
					manipulator.appendNode(categoryName, "//other_details");
					manipulator.appendXml("//other_details/" + categoryName, xmlFile);
				}

				profileUser.setUserInfo(manipulator.toString(null));
			}

			// populate with values

			for (Map.Entry<String, String> work : details.entrySet()) {
				String fieldName = work.getKey();
				String fieldValue = work.getValue();
				_log.error("fieldName " + fieldName + " fieldValue " + fieldValue);
				if ((fieldName != null) && (!fieldName.equals(""))) {
					String nodeXQuery = "//other_details/" + categoryName + "/" + categoryDetails + "/" + fieldName;
					manipulator.setNodeValue(fieldValue, nodeXQuery);
				}
			}

			profileUser.setUserInfo(manipulator.toString(null));
			SocialProfileLocalServiceUtil.updateSocialProfile(profileUser);

		} catch (Exception e) {
			_log.error("Error on addOrUpdateDynamicSection: " + e.getMessage());
		}
	}

	public User updateUser(User user) throws SystemException {
		return userPersistence.update(user);
	}

	public void updateUserScreenName(long userId, String newScreenName) throws PortalException, SystemException {
		UserLocalServiceUtil.updateScreenName(userId, newScreenName);
	}

	@SuppressWarnings("unchecked")
	public List<Website> getUserWebSites(long userId, long companyId) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Website.class, PortalClassLoaderUtil.getClassLoader())
				.add(PropertyFactoryUtil.forName("companyId").eq(companyId))
				.add(PropertyFactoryUtil.forName("userId").eq(userId));
		List<Website> results = WebsiteLocalServiceUtil.dynamicQuery(query);
		return results;
	}

	@SuppressWarnings("unchecked")
	public List<Phone> getUserPhoneList(long userId, long companyId) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Phone.class, PortalClassLoaderUtil.getClassLoader());
		query.add(PropertyFactoryUtil.forName("userId").eq(userId));
		query.add(PropertyFactoryUtil.forName("companyId").eq(companyId));
		List<Phone> results = PhoneLocalServiceUtil.dynamicQuery(query);
		return results;
	}

	@SuppressWarnings("unchecked")
	public List<Contact> getContacts(long userId, long companyId) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Contact.class, PortalClassLoaderUtil.getClassLoader());
		query.add(PropertyFactoryUtil.forName("userId").eq(userId));
		query.add(PropertyFactoryUtil.forName("companyId").eq(companyId));
		List<Contact> results = ContactLocalServiceUtil.dynamicQuery(query);
		return results;
	}

	@SuppressWarnings("unchecked")
	public List<EmailAddress> getUserEmailAddressList(long userId, long companyId) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(EmailAddress.class,
				PortalClassLoaderUtil.getClassLoader());
		query.add(PropertyFactoryUtil.forName("userId").eq(userId));
		query.add(PropertyFactoryUtil.forName("companyId").eq(companyId));
		List<EmailAddress> results = EmailAddressLocalServiceUtil.dynamicQuery(query);
		return results;
	}

	@SuppressWarnings("unchecked")
	public List<Address> getUserAddresses(long userId, long companyId) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Address.class, PortalClassLoaderUtil.getClassLoader());
		query.add(PropertyFactoryUtil.forName("userId").eq(userId));
		query.add(PropertyFactoryUtil.forName("companyId").eq(companyId));
		List<Address> results = AddressLocalServiceUtil.dynamicQuery(query);
		return results;
	}

	public void updateWebsites(SocialProfile socialProfile, List<Website> websites) throws SystemException {

		try {
			XMLManipulator manipulator = null;
			String categoryName = "websites";
			String nodeName = "websites_url";

			if ((websites != null) && (websites.size() > 0)) {
				manipulator = new XMLManipulator(socialProfile.getUserInfo());
				manipulator.removeAllNodes("//" + categoryName, nodeName);

				for (Website website : websites) {
					String websiteURL = website.getUrl();
					manipulator.appendNodeWithIdValue(nodeName, websiteURL, "//" + categoryName);
				}

				socialProfile.setUserInfo(manipulator.toString(null));
			}

		} catch (NoSuchSocialProfileException e) {
			_log.error(" Profile doesn't exist ");
		} catch (Exception e) {
			_log.error(" Can't update social profile websites ");
		}
	}

	public void updateContactInfo(SocialProfile socialProfile, List<Phone> phoneNumbers) throws SystemException {
		try {
			XMLManipulator manipulator = null;
			String categoryName = "contact_details";
			String nodeName = "phone_details";

			if ((phoneNumbers != null) && (phoneNumbers.size() > 0)) {
				manipulator = new XMLManipulator(socialProfile.getUserInfo());
				manipulator.removeChildNodes("//" + categoryName + "/" + nodeName);
				Phone primaryPhone = (Phone) phoneNumbers.get(0);

				// Phone mobilePhone = (Phone) phoneNumbers.get(1);

				for (Phone phone : phoneNumbers) {
					if (phone.isPrimary()) {
						primaryPhone = phone;
					}
				}

				String phoneNum = primaryPhone.getNumber();
				String ext = primaryPhone.getExtension();

				manipulator.appendNodeWithValue("phone_no", phoneNum, "//" + categoryName + "/" + nodeName);
				manipulator.appendNodeWithValue("ext", ext, "//" + categoryName + "/" + nodeName);

				// manipulator.appendNodeWithValue("phone_no", phoneNum, "//" +
				// categoryName + "/" + nodeName);
				// manipulator.appendNodeWithValue("ext", ext, "//" +
				// categoryName + "/" + nodeName);

				socialProfile.setUserInfo(manipulator.toString(null));
			}

		} catch (Exception e) {
			_log.error(" Can't update social profile phones ");
		}
	}

	public void updateNetworkInfo(SocialProfile socialProfile, List<Contact> contactList) throws SystemException {
		try {
			XMLManipulator manipulator = null;

			if ((contactList != null) && (contactList.size() > 0)) {
				Contact contact = (Contact) contactList.get(0);
				manipulator = new XMLManipulator(socialProfile.getUserInfo());

				// Can only add/update single record because Contact_ liferay
				// table has only one record per user

				manipulator.findUpdateNodeValue("//twitter", "twitter_url", contact.getTwitterSn());
				manipulator.findUpdateNodeValue("//facebook", "facebook_url", contact.getFacebookSn());

				manipulator.appendNodeNameValue("//messenger", "messenger_url", "Yahoo", contact.getYmSn());
				manipulator.appendNodeNameValue("//messenger", "messenger_url", "AIM", contact.getAimSn());
				manipulator.appendNodeNameValue("//messenger", "messenger_url", "ICQ", contact.getIcqSn());
				manipulator.appendNodeNameValue("//messenger", "messenger_url", "Jabber", contact.getJabberSn());
				manipulator.appendNodeNameValue("//messenger", "messenger_url", "MSN", contact.getMsnSn());
				manipulator.appendNodeNameValue("//messenger", "messenger_url", "Skype", contact.getSkypeSn());

				socialProfile.setUserInfo(manipulator.toString(null));
			}

		} catch (Exception e) {
			_log.error(" Can't update social profile network info ");
		}
	}

	public void updateEmailAddresses(SocialProfile socialProfile, List<EmailAddress> emailAddresses)
			throws SystemException {
		try {
			XMLManipulator manipulator = null;
			String categoryName = "email";
			String nodeName = "email_url";

			if ((emailAddresses != null) && (emailAddresses.size() > 0)) {
				manipulator = new XMLManipulator(socialProfile.getUserInfo());
				manipulator.removeAllNodes("//" + categoryName, nodeName);

				for (EmailAddress emailAddress : emailAddresses) {
					manipulator.appendNodeWithValue(nodeName, emailAddress.getAddress(), "//" + categoryName);
				}

				socialProfile.setUserInfo(manipulator.toString(null));
			}

		} catch (NoSuchSocialProfileException e) {
			_log.error(" Profile doesn't exist ");
		} catch (Exception e) {
			_log.error(" Can't update social profile email addresses ");
		}
	}

	public void updateAddress(SocialProfile socialProfile, List<Address> addresses) throws SystemException {
		try {
			XMLManipulator manipulator = null;
			String categoryName = "contact_details";
			String nodeName = "address_details";

			if ((addresses != null) && (addresses.size() > 0)) {
				manipulator = new XMLManipulator(socialProfile.getUserInfo());
				manipulator.removeChildNodes("//" + categoryName + "/" + nodeName);
				Address primaryAddress = (Address) addresses.get(0);

				// find primary address index, otherwise use first record as
				// default primary address

				for (Address address : addresses) {
					if (address.isPrimary()) {
						primaryAddress = address;
					}
				}

				Country country = null;
				try {
					country = CountryServiceUtil.getCountry(primaryAddress.getCountryId());
					manipulator.appendNodeWithValue("country", country.getName(), "//" + categoryName + "/" + nodeName);
				} catch (Exception e) {
					_log.error(" country field not found " + e.getMessage());
				}

				manipulator.appendNodeWithValue("address", primaryAddress.getStreet1(), "//" + categoryName + "/"
						+ nodeName);
				manipulator.appendNodeWithValue("address1", primaryAddress.getStreet2(), "//" + categoryName + "/"
						+ nodeName);
				manipulator.appendNodeWithValue("city", primaryAddress.getCity(), "//" + categoryName + "/" + nodeName);
				manipulator.appendNodeWithValue("postal_code", primaryAddress.getZip(), "//" + categoryName + "/"
						+ nodeName);

				socialProfile.setUserInfo(manipulator.toString(null));
			}

		} catch (NoSuchSocialProfileException e) {
			_log.error(" Profile doesn't exist ");
		} catch (Exception e) {
			_log.error(" Can't update social profile address ");
		}
	}

	public void updateMobileNo(SocialProfile socialProfile, List<Phone> phoneNumbers) throws SystemException {
		try {

			XMLManipulator manipulator = null;
			String categoryName = "//contact_info/contact_details";
			String nodeName = "phone_details";

			if ((phoneNumbers != null) && (phoneNumbers.size() > 0)) {
				manipulator = new XMLManipulator(socialProfile.getUserInfo());
				manipulator.removeChildNodes(categoryName + "/" + nodeName);
				Phone mobilePhone = (Phone) phoneNumbers.get(0);

				String phoneNum = mobilePhone.getNumber();
				manipulator.appendNodeWithValue("phone_no", phoneNum, categoryName + "/" + nodeName);

				socialProfile.setUserInfo(manipulator.toString(null));
				socialProfileLocalService.updateSocialProfile(socialProfile);
			}

		} catch (NoSuchSocialProfileException e) {
			_log.error(" Profile doesn't exist ");
		} catch (Exception e) {
			_log.error(" Can't update social profile mobile no ");
		}
	}

	public void updateLocationAndMobileNo(SocialProfile socialProfile, List<Phone> phoneNumbers) throws SystemException {
		try {

			XMLManipulator manipulator = null;
			String categoryName = "//contact_info/contact_details";
			String nodeName = "phone_details";

			if ((phoneNumbers != null) && (phoneNumbers.size() > 0)) {
				manipulator = new XMLManipulator(socialProfile.getUserInfo());
				manipulator.removeChildNodes(categoryName + "/" + nodeName);
				Phone mobilePhone = (Phone) phoneNumbers.get(0);

				String phoneNum = mobilePhone.getNumber();
				manipulator.appendNodeWithValue("phone_no", phoneNum, categoryName + "/" + nodeName);
			}

			manipulator.setNodeValue(socialProfile.getLocation(), "//personal_info/location");

			socialProfile.setUserInfo(manipulator.toString(null));
			socialProfileLocalService.updateSocialProfile(socialProfile);

		} catch (NoSuchSocialProfileException e) {
			_log.error(" Profile doesn't exist ");
		} catch (Exception e) {
			_log.error(" Failed to update social profile location and mobile no. ");
		}
	}

	public void updateXMLFromSocialProfile(SocialProfile socialProfile) throws SystemException {
		try {
			XMLManipulator manipulator = new XMLManipulator(socialProfile.getUserInfo());

			// manipulator.setNodeValue(socialProfile.getTitle(),
			// "//personal_info/title");

			manipulator.setNodeValue(socialProfile.getLocation(), "//personal_info/location");
			socialProfile.setUserInfo(manipulator.toString(null));

			manipulator.setNodeValue(socialProfile.getInterest(), "//basic_info/category_1337310105844");
			socialProfile.setUserInfo(manipulator.toString(null));
			socialProfile.setInterest("");
			socialProfile.setUserInfo(manipulator.toString(null));

		} catch (NoSuchSocialProfileException e) {
			_log.error(" Profile doesn't exist ");
		} catch (Exception e) {
			_log.error(" Can't update social profile xml ");
		}
	}

	public void updatePersonalInfoWhenReg(User user, com.liferay.portal.kernel.json.JSONObject extraFieldsJSONObject)
			throws PortalException, SystemException {
		try {
			SocialProfile socialProfile = null;
			try {
				socialProfile = SocialProfileLocalServiceUtil.getSocialProfile(user.getUserId(), user.getCompanyId());

				String location = StringPool.BLANK;
				String about = StringPool.BLANK;
				String emailAddress = StringPool.BLANK;
				String publicUrl = StringPool.BLANK;
				String tempWH = StringPool.BLANK;
				String interestCategory = StringPool.BLANK;

				location = extraFieldsJSONObject.getString("location");
				about = extraFieldsJSONObject.getString("about");
				emailAddress = extraFieldsJSONObject.getString("emailAddress");

				String facebook = StringPool.BLANK;
				String linkedin = StringPool.BLANK;
				String twitter = StringPool.BLANK;
				String websites = StringPool.BLANK;
				facebook = extraFieldsJSONObject.getString("facebook");
				linkedin = extraFieldsJSONObject.getString("linkedin");
				twitter = extraFieldsJSONObject.getString("twitter");
				websites = extraFieldsJSONObject.getString("websites");

				String type = StringPool.BLANK;

				if (Validator.isNotNull(facebook)) {
					publicUrl = facebook;
					type = "facebook";
				} else if (Validator.isNotNull(linkedin)) {
					publicUrl = linkedin;
					type = "linkedin";
				} else if (Validator.isNotNull(twitter)) {
					publicUrl = twitter;
					type = "twitter";
				} else if (Validator.isNotNull(websites)) {
					publicUrl = websites;
					type = "websites";
				}

				interestCategory = extraFieldsJSONObject.getString("interest_category");
				tempWH = extraFieldsJSONObject.getString("work_histories");

				XMLManipulator manipulator = new XMLManipulator(socialProfile.getUserInfo());
				String title = user.getJobTitle();

				if (Validator.isNotNull(title)) {
					manipulator.setNodeValue(title, "//personal_info/title");
					socialProfile.setTitle(title);
				}

				if (Validator.isNotNull(location)) {
					manipulator.setNodeValue(location, "//personal_info/location");
					socialProfile.setLocation(location);
				}

				if (Validator.isNotNull(interestCategory)) {
					manipulator.setNodeValue(interestCategory, "//basic_info/category");
					socialProfile.setInterest(interestCategory);
				}

				if (Validator.isNotNull(about)) {
					manipulator.setNodeValue(about, "//personal_info/about");
					socialProfile.setAbout(about);
				}

				socialProfile.setUserInfo(manipulator.toString(null));
				socialProfile = SocialProfileLocalServiceUtil.updateSocialProfile(socialProfile);

				if (Validator.isNotNull(emailAddress)) {
					try {
						socialProfile = SocialProfileLocalServiceUtil.addNetworkInfo(socialProfile, "email",
								"email_url", emailAddress);
					} catch (Exception e) {
						_log.error(e.getMessage(), e);
					}
				}

				if (Validator.isNotNull(publicUrl)) {
					socialProfile = SocialProfileLocalServiceUtil.addNetworkInfo(socialProfile, type, type + "_url",
							publicUrl);
				}

				/**
				 * Added By : Gaurav
				 * **/

				if (Validator.isNotNull(tempWH)) {
					JSONArray workHistoriesJSONArray = JSONFactoryUtil.createJSONArray(tempWH);

					for (int i = 0; i < workHistoriesJSONArray.length(); i++) {
						JSONArray whJSONArray = workHistoriesJSONArray.getJSONArray(i);
						String companyName = StringPool.BLANK;
						String jobTitle = StringPool.BLANK;
						String workDesc = StringPool.BLANK;
						String startDate = StringPool.BLANK;
						String endDate = StringPool.BLANK;

						for (int j = 0; j < whJSONArray.length(); j++) {
							com.liferay.portal.kernel.json.JSONObject whJSONObject = whJSONArray.getJSONObject(j);

							if (Validator.isNull(companyName)) {
								companyName = whJSONObject.getString("company_name", StringPool.BLANK);
							} else if (Validator.isNull(jobTitle)) {
								jobTitle = whJSONObject.getString("job_title", StringPool.BLANK);
							} else if (Validator.isNull(workDesc)) {
								workDesc = whJSONObject.getString("work_description", StringPool.BLANK);
							} else if (Validator.isNull(startDate)) {
								startDate = whJSONObject.getString("start_date", StringPool.BLANK);
							} else if (Validator.isNull(endDate)) {
								endDate = whJSONObject.getString("end_date", StringPool.BLANK);
							}
						}

						Map<String, String> workDetails = new HashMap<String, String>();
						workDetails.put("company_name", companyName);
						workDetails.put("job_title", jobTitle);
						workDetails.put("work_description", workDesc);
						workDetails.put("start_date", startDate);
						workDetails.put("end_date", endDate);

						String instance = String.valueOf(new Date().getTime());
						SocialProfileLocalServiceUtil.addOrUpdateWorkHistory(
								"workhistory",
								"work_details",
								instance,
								socialProfile,
								GroupLocalServiceUtil.getGroup(socialProfile.getCompanyId(),
										PropsUtil.get(PropsKeys.VIRTUAL_HOSTS_DEFAULT_SITE_NAME)).getGroupId(),
								workDetails);
					}
				}

			} catch (NoSuchSocialProfileException nsspe) {

				// do nothing

			}
		} catch (Exception e) {
			_log.error("Error updating work history from social profile", e);
		}

	}

	public void updatePersonalInfo(SocialProfile socialProfile, User user) throws PortalException, SystemException {
		try {
			XMLManipulator manipulator = new XMLManipulator(socialProfile.getUserInfo());
			manipulator.setNodeValue(user.getScreenName(), "//personal_info/screen_name");
			manipulator.setNodeValue(user.getJobTitle(), "//personal_info/title");
			socialProfile.setTitle(user.getJobTitle());
			socialProfile.setModifiedDate(user.getModifiedDate());

			String gender = "0";
			String birthday = "";

			try {
				if (user.isMale()) {
					gender = "1";
				}
			} catch (Exception e) {
				_log.debug("Error getting gender from user");
			}

			try {
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				birthday = formatter.format(user.getBirthday());
			} catch (Exception e) {
				_log.debug(" Error parsing birthday ");
			}

			manipulator.setNodeValue(gender, "//basic_info/gender");
			manipulator.setNodeValue(birthday, "//basic_info/date_of_birth");

			manipulator.setNodeValue(user.getFirstName(), "//basic_info/first_name");
			manipulator.setNodeValue(user.getLastName(), "//basic_info/last_name");
			manipulator.setNodeValue(user.getGreeting(), "//basic_info/user_status");

			socialProfile.setUserInfo(manipulator.toString(null));

		} catch (Exception e) {
			_log.error(" Can't update social profile personal info ");
		}
	}

	/**
	 * Transforms XML and populate with data from user and Liferay tables
	 */
	public SocialProfile transformSocialProfileXML(SocialProfile socialProfile, User user) throws PortalException,
			SystemException {

		List<Website> websites = getUserWebSites(socialProfile.getUserId(), socialProfile.getCompanyId());
		updateWebsites(socialProfile, websites);

		List<Contact> contactList = getContacts(socialProfile.getUserId(), socialProfile.getCompanyId());
		updateNetworkInfo(socialProfile, contactList);

		List<Phone> phoneNumbers = getUserPhoneList(socialProfile.getUserId(), socialProfile.getCompanyId());
		updateContactInfo(socialProfile, phoneNumbers);

		List<Address> addresses = getUserAddresses(socialProfile.getUserId(), socialProfile.getCompanyId());
		updateAddress(socialProfile, addresses);

		List<EmailAddress> emailAddresses = getUserEmailAddressList(socialProfile.getUserId(),
				socialProfile.getCompanyId());
		updateEmailAddresses(socialProfile, emailAddresses);

		return socialProfile;
	}

	public void saveContactInfoXMLData(SocialProfile profileUser, String sData, String categoryName) {
		long userId = profileUser.getUserId();

		String userName = StringPool.BLANK;
		long companyId = 0;
		User user = null;

		try {
			user = UserLocalServiceUtil.getUser(userId);
			userName = user.getFullName();
			companyId = user.getCompanyId();
		} catch (PortalException e) {
			_log.error("User not avilable portal exception " + e.getMessage());
		} catch (SystemException e) {
			_log.error("User not avilable portal exception " + e.getMessage());
		}

		addOrUpdateUserContactAddress(sData, userId, userName, companyId);
		addOrUpdateUserContactPhoneNo(sData, userId, userName, companyId);
		try {
			SocialProfileLocalServiceUtil.updateSocialProfile(profileUser);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

	}

	protected Address addOrUpdateUserContactAddress(String data, long userId, String userName, long companyId) {

		String className = SocialProfile.class.getName();
		long classNameId = PortalUtil.getClassNameId(className);
		Address address = null;
		long addressId = 0;

		try {

			// org.json.JSONArray newJArray = new org.json.JSONArray(data);
			// JSONObject jsonObject = new JSONObject(newJArray.getString(0));

			JSONObject jsonObject = new JSONObject(data);
			List<Address> addressList = SocialProfileLocalServiceUtil.getUserAddresses(userId, companyId);

			if (!(jsonObject.getString("address").isEmpty())) {
				if (addressList.isEmpty()) {
					addressId = CounterLocalServiceUtil.increment("Address.class");
					address = AddressLocalServiceUtil.createAddress(addressId);
				} else {
					Iterator<Address> addressListItr = addressList.iterator();
					while (addressListItr.hasNext()) {
						address = addressListItr.next();
						boolean primary = address.getPrimary();

						if (primary) {
							addressId = address.getAddressId();
						}
					}
				}

				if (addressId == 0) {
					addressId = CounterLocalServiceUtil.increment("Address.class");
					address = AddressLocalServiceUtil.createAddress(addressId);
				}

				address.setAddressId(addressId);
				String cityMsg = jsonObject.getString("city");

				if ((cityMsg.equalsIgnoreCase("empty")))
					cityMsg = "";
				address.setCity(cityMsg);
				address.setClassNameId(classNameId);
				address.setClassPK(userId);
				address.setCompanyId(companyId);
				address.setUserName(userName);
				address.setUserId(userId);
				address.setPrimary(true);
				address.setCreateDate(new Date());
				address.setModifiedDate(new Date());
				address.setStreet1(jsonObject.getString("address"));
				String aMsg = jsonObject.getString("address1");
				long countryId = 0;

				if ((aMsg.equalsIgnoreCase("empty")))
					aMsg = "";
				address.setStreet2(aMsg);
				String cMsg = jsonObject.getString("country");

				if ((cMsg.equalsIgnoreCase("empty")))
					cMsg = "";

				if (!(cMsg.isEmpty())) {
					Country country = CountryServiceUtil.getCountryByName(jsonObject.getString("country"));
					countryId = country.getCountryId();
				}

				address.setStreet3(cMsg);
				address.setCountryId(countryId);
				String pMsg = jsonObject.getString("postal_code");

				if ((pMsg.equalsIgnoreCase("empty")))
					pMsg = "";
				address.setZip(pMsg);
				address.setRegionId(0);
				address.setTypeId(0);
				address.setMailing(false);
				AddressLocalServiceUtil.updateAddress(address);
			}

		} catch (Exception e) {

			// need to delete address if adding phone fails

			_log.error(e.getMessage());
		}

		return address;
	}

	protected Phone addOrUpdateUserContactPhoneNo(String data, long userId, String userName, long companyId) {
		Phone phone = null;
		String className = SocialProfile.class.getName();
		long classNameId = PortalUtil.getClassNameId(className);
		long phoneId = 0;

		try {

			// newJArray = new org.json.JSONArray(data); JSONObject jsonObject =
			// new JSONObject(newJArray.getString(0));

			JSONObject jsonObject = new JSONObject(data);
			List<Phone> phoneList = SocialProfileLocalServiceUtil.getUserPhoneList(userId, companyId);

			if (!(jsonObject.getString("phone_no").isEmpty())) {
				if (phoneList.isEmpty()) {
					phoneId = CounterLocalServiceUtil.increment("Phone.class");
					phone = PhoneLocalServiceUtil.createPhone(phoneId);
				} else {
					Iterator<Phone> phoneListItr = phoneList.iterator();
					while (phoneListItr.hasNext()) {
						phone = phoneListItr.next();
						boolean primary = phone.getPrimary();

						if (primary) {
							phoneId = phone.getPhoneId();
						}
					}
				}

				if (phoneId == 0) {
					phoneId = CounterLocalServiceUtil.increment("Phone.class");
					phone = PhoneLocalServiceUtil.createPhone(phoneId);
				}

				phone.setPhoneId(phoneId);
				phone.setClassNameId(classNameId);
				phone.setUserName(userName);
				phone.setClassPK(userId);
				phone.setUserId(userId);
				phone.setPrimary(true);
				phone.setCreateDate(new Date());
				phone.setModifiedDate(new Date());
				phone.setCompanyId(companyId);
				String pMsg = jsonObject.getString("phone_no");

				if ((pMsg.equalsIgnoreCase("empty")))
					pMsg = "";
				phone.setNumber(pMsg);
				String eMsg = jsonObject.getString("ext");

				if ((eMsg.equalsIgnoreCase("empty")))
					eMsg = "";
				phone.setExtension(eMsg);
				phone.setTypeId(0);
				PhoneLocalServiceUtil.updatePhone(phone);
			}
		} catch (JSONException e) {
			_log.error("Cannot save phone no Json exception " + e.getMessage());
		} catch (SystemException e) {
			_log.error("Cannot save phone no SystemException " + e.getMessage());
		}

		return phone;
	}

	protected List<Website> addOrUpdateUserWebsite(Map<String, String> websitesMap, long userId, long companyId) {
		String className = SocialProfile.class.getName();

		List<Website> websites = new ArrayList<Website>();

		try {
			List<Website> websiteList = SocialProfileLocalServiceUtil.getUserWebSites(userId, companyId);

			if (!websiteList.isEmpty()) {
				Iterator<Website> websiteListItr = websiteList.iterator();
				while (websiteListItr.hasNext()) {
					Website website = websiteListItr.next();
					WebsiteLocalServiceUtil.deleteWebsite(website);
				}
			}

			if (Validator.isNotNull(websitesMap)) {
				long classNameId = PortalUtil.getClassNameId(className);

				for (Entry<String, String> web : websitesMap.entrySet()) {
					String websiteUrl = web.getValue();

					long websiteId = CounterLocalServiceUtil.increment("Website.class");
					Website website = WebsiteLocalServiceUtil.createWebsite(websiteId);
					website.setWebsiteId(websiteId);
					website.setClassNameId(classNameId);
					website.setUserName("");
					website.setClassPK(userId);
					website.setUserId(userId);
					website.setPrimary(true);
					website.setCreateDate(new Date());
					website.setModifiedDate(new Date());
					website.setUrl(websiteUrl);
					website.setCompanyId(companyId);
					website.setTypeId(0);
					WebsiteLocalServiceUtil.updateWebsite(website);

					websites.add(website);
				}
			}

		} catch (SystemException e) {
			_log.error("Cannot save websiteo SystemException " + e.getMessage());
		}

		return websites;
	}

	public Contact updateUserNetworkInfoFromSocialProfile(SocialProfile socialProfile) {

		Map<String, Map<String, String>> networkMap;
		long userId = socialProfile.getUserId();
		long companyId = socialProfile.getCompanyId();
		Contact contact = null;
		User user = null;

		try {
			user = UserLocalServiceUtil.getUser(userId);
			contact = ContactLocalServiceUtil.getContact(user.getContactId());
		} catch (PortalException e) {
			_log.error(e.getMessage());
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		if (Validator.isNull(contact)) {
			return null;
		}

		try {
			networkMap = UserProfileUtil.getSocialProfileNetworkInfoMap(socialProfile);

			for (Entry<String, Map<String, String>> item : networkMap.entrySet()) {
				Map<String, String> networkinfo = item.getValue();
				String networkType = item.getKey();

				if (networkType.equalsIgnoreCase("websites")) {
					addOrUpdateUserWebsite(networkinfo, userId, companyId);
				} else if (networkType.equalsIgnoreCase("email")) {
					addOrUpdateUserEmailAddress(networkinfo, userId, companyId);
				} else {

					for (Entry<String, String> web : networkinfo.entrySet()) {
						String value = web.getValue();

						if (networkType.equalsIgnoreCase("facebook")) {
							contact.setFacebookSn(value);
						} else if (networkType.equalsIgnoreCase("twitter")) {
							contact.setTwitterSn(value);
						} else if (networkType.equalsIgnoreCase("messenger")) {
							String[] msgrArr = value.split(":");
							String msgrType = msgrArr[0];
							String msgrId = msgrArr[1];

							if (msgrType.equalsIgnoreCase("skype")) {
								contact.setSkypeSn(msgrId);
							} else if (msgrType.equalsIgnoreCase("yahoo")) {
								contact.setYmSn(msgrId);
							} else if (msgrType.equalsIgnoreCase("msn")) {
								contact.setMsnSn(msgrId);
							} else if (msgrType.equalsIgnoreCase("jabber")) {
								contact.setJabberSn(msgrId);
							}
						}
					}
				}
			}

			contact = ContactLocalServiceUtil.updateContact(contact);
		} catch (NoSuchSocialProfileException e) {
			_log.error(e.getMessage(), e);
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		} catch (SystemException e) {
			_log.error(e.getMessage(), e);
		}

		// end contact != null

		return contact;
	}

	protected List<EmailAddress> addOrUpdateUserEmailAddress(Map<String, String> emailMap, long userId, long companyId) {
		List<EmailAddress> emailAddrList = new ArrayList<EmailAddress>();
		String className = SocialProfile.class.getName();

		try {
			List<EmailAddress> emailList = SocialProfileLocalServiceUtil.getUserEmailAddressList(userId, companyId);

			if (!emailList.isEmpty()) {
				Iterator<EmailAddress> emailListItr = emailList.iterator();
				while (emailListItr.hasNext()) {
					EmailAddress email = emailListItr.next();
					EmailAddressLocalServiceUtil.deleteEmailAddress(email);
				}
			}

			if (Validator.isNotNull(emailMap)) {
				long classNameId = PortalUtil.getClassNameId(className);

				for (Entry<String, String> emailDetails : emailMap.entrySet()) {
					String address = emailDetails.getValue();
					long emailAddressId = CounterLocalServiceUtil.increment("EmailAddress.class");
					EmailAddress email = EmailAddressLocalServiceUtil.createEmailAddress(emailAddressId);
					email.setEmailAddressId(emailAddressId);
					email.setClassNameId(classNameId);
					email.setUserName("");
					email.setClassPK(userId);
					email.setUserId(userId);
					email.setPrimary(true);
					email.setCreateDate(new Date());
					email.setModifiedDate(new Date());
					email.setCompanyId(companyId);
					email.setAddress(address);
					email.setTypeId(0);
					EmailAddressLocalServiceUtil.updateEmailAddress(email);

					emailAddrList.add(email);
				}
			}

		} catch (SystemException e) {
			_log.error("Cannot save email address SystemException " + e.getMessage());
		}

		return emailAddrList;
	}

	public void addSocialProfileDetail(String companyName, String jobId, long userId, String projectList) {
		try {
			try {
				SocialProfileDetail existingUserDetail = SocialProfileDetailLocalServiceUtil.findByUserIdAndUserJobId(
						jobId, userId);

				if (existingUserDetail != null)
					socialProfileDetailLocalService.deleteSocialProfileDetail(existingUserDetail);
			} catch (NoSuchSocialProfileDetailException e) {
				_log.error("Social Profile detail not found " + companyName + " " + jobId + " " + e.getMessage());
			}

			long socialProfileDetailId = CounterLocalServiceUtil.increment();
			SocialProfileDetail socialProfileDetail = socialProfileDetailLocalService
					.createSocialProfileDetail(socialProfileDetailId);

			socialProfileDetail.setCompanyName(companyName);
			socialProfileDetail.setSocialProfileDetailId(socialProfileDetailId);
			socialProfileDetail.setUserId(userId);
			socialProfileDetail.setUserJobId(jobId);
			socialProfileDetail.setCreateDate(new Date());
			socialProfileDetail.setModifiedDate(new Date());
			SocialProfileDetailLocalServiceUtil.updateSocialProfileDetail(socialProfileDetail);

		} catch (SystemException e) {
			_log.error("Social Profile detail not added " + companyName + " " + jobId + " " + e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	public String getExpertiseTags() {
		String expertise = "";
		Set<String> assetTags = new HashSet<String>();

		long classNameId = PortalUtil.getClassNameId(SocialProfile.class.getName());
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(AssetEntry.class, PortalClassLoaderUtil.getClassLoader())
				.add(PropertyFactoryUtil.forName("classNameId").eq(classNameId));
		try {
			List<AssetEntry> results = AssetEntryLocalServiceUtil.dynamicQuery(query);

			Iterator<AssetEntry> resultsItr = results.iterator();

			while (resultsItr.hasNext()) {
				String[] expertiseArr = resultsItr.next().getTagNames();

				for (int i = 0; i < expertiseArr.length; i++) {
					String asset = expertiseArr[i];

					if (!(assetTags.contains(asset))) {
						expertise = asset + "," + expertise;
						assetTags.add(asset);
					}
				}
			}

		} catch (SystemException e) {
			_log.error("Tag for area fo expertise not found " + e.getMessage());
		}

		return expertise;
	}

	@SuppressWarnings("unchecked")
	public String getExpertiseTags(long userId) {
		String expertise = "";
		Set<String> assetTags = new HashSet<String>();

		long classNameId = PortalUtil.getClassNameId(SocialProfile.class.getName());
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(AssetEntry.class, PortalClassLoaderUtil.getClassLoader())
				.add(PropertyFactoryUtil.forName("classNameId").eq(classNameId))
				.add(PropertyFactoryUtil.forName("userId").eq(userId));
		try {
			List<AssetEntry> results = AssetEntryLocalServiceUtil.dynamicQuery(query);

			Iterator<AssetEntry> resultsItr = results.iterator();
			while (resultsItr.hasNext()) {
				String[] expertiseArr = resultsItr.next().getTagNames();

				for (int i = 0; i < expertiseArr.length; i++) {
					String asset = expertiseArr[i];

					if (!(assetTags.contains(asset))) {
						expertise = asset + "," + expertise;
						assetTags.add(asset);
					}
				}
			}

		} catch (SystemException e) {
			_log.error("Tag for area fo expertise not found " + e.getMessage());
		}

		return expertise;
	}

	public String getProfileCompletion(SocialProfile profileUser) {
		float percentageCompletion = 0f;
		try {

			// Personal Info

			Map<String, String> personalInfoMap = UserProfileUtil.getSocialProfilePersonalInfoMap(profileUser);
			int personalInfoFields = 0;
			int personalInfoFieldsWithValue = 0;

			if (personalInfoMap != null) {
				personalInfoFields = personalInfoMap.size();

				for (Map.Entry<String, String> item : personalInfoMap.entrySet()) {

					// String key = item.getKey();

					String value = item.getValue();

					if (!value.isEmpty()) {
						personalInfoFieldsWithValue += 1;
					}
				}
			}

			// Network Info

			Map<String, Map<String, String>> networkMap = UserProfileUtil.getSocialProfileNetworkInfoMap(profileUser);
			int networkFields = 0;
			int networkFieldsWithValue = 0;

			if (networkMap != null) {
				networkFields = networkMap.size();
				_log.debug("Network size: " + networkFields);

				for (Entry<String, Map<String, String>> item : networkMap.entrySet()) {
					Map<String, String> networkinfo = item.getValue();

					if (networkinfo.size() > 0) { // check if there's at least 1

						// network info

						networkFieldsWithValue += 1;
					}
				}

			}

			// Contact Info

			Map<String, Map<String, String>> contactInfoMap = UserProfileUtil
					.getSocialProfileContactInfoMap(profileUser);
			int contactInfoFields = 0;
			int contactInfoFieldsWithValue = 0;

			if (contactInfoMap != null) {
				for (Entry<String, Map<String, String>> item : contactInfoMap.entrySet()) {
					Map<String, String> contactinfo = item.getValue();
					contactInfoFields += contactinfo.size();

					for (Entry<String, String> item2 : contactinfo.entrySet()) {
						String value = item2.getValue();

						if (!value.isEmpty()) {
							contactInfoFieldsWithValue += 1;
						}
					}
				}

				_log.debug("contactInfo size: " + contactInfoFields);
			}

			// Work history

			Map<String, Map<String, String>> workHistoryMap = UserProfileUtil
					.getSocialProfileWorkHistoryMap(profileUser);
			int workHistoryFieldsSize = workHistoryMap.size(); // count instance

			// only

			_log.debug("workhistory size: " + workHistoryFieldsSize);

			// Availability Info

			Map<String, Map<String, String>> availabilityInfoMap = UserProfileUtil
					.getSocialProfilAvailabilityInfoMap(profileUser);
			int availInfoSize = availabilityInfoMap.size();

			_log.debug("availability info size: " + availInfoSize);

			// Basic Info

			Map<String, String> basicInfoMap = UserProfileUtil.getSocialProfileBasicInfoMap(profileUser);
			int basicInfoFields = 0;
			int basicInfoFieldsWithValue = 0;

			if (personalInfoMap != null) {
				basicInfoFields = personalInfoMap.size();

				for (Map.Entry<String, String> item : basicInfoMap.entrySet()) {

					// String key = item.getKey();

					String value = item.getValue();

					if (!value.isEmpty()) {
						basicInfoFieldsWithValue += 1;
					}
				}
			}

			_log.debug("basic info size: " + basicInfoFields);

			// Percentage Computation

			float totalSocialProfileFields = personalInfoFields + networkFields + contactInfoFields
					+ workHistoryFieldsSize + availInfoSize + basicInfoFields;
			float totalFieldsWithValue = personalInfoFieldsWithValue + networkFieldsWithValue
					+ contactInfoFieldsWithValue + workHistoryFieldsSize + availInfoSize + basicInfoFieldsWithValue;

			percentageCompletion = ((totalFieldsWithValue / totalSocialProfileFields) * 100);

			_log.debug("TOTAL PERCENTAGE OF PROFILE COMPLETION: " + percentageCompletion);
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

		return String.format("%.2f", percentageCompletion);
	}

	public void saveAvailabilityInfo(SocialProfile profileUser) {
		try {
			Map<String, Map<String, String>> availabilityInfoMap = UserProfileUtil
					.getSocialProfilAvailabilityInfoMap(profileUser);
			long userId = profileUser.getUserId();
			long companyId = profileUser.getCompanyId();

			List<UserAvailabilityCalendar> availList = UserAvailabilityCalendarLocalServiceUtil
					.getUserAvailabilityList(userId, companyId);

			if (availList != null) {
				for (UserAvailabilityCalendar userAvailabilityCalendar : availList) {
					UserAvailabilityCalendarLocalServiceUtil.deleteUserAvailabilityCalendar(userAvailabilityCalendar);
				}
			}

			for (Entry<String, Map<String, String>> item : availabilityInfoMap.entrySet()) {
				Map<String, String> availInfo = item.getValue();

				String availableFor = "";
				Date startDate = null;
				Date endDate = null;

				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

				for (Entry<String, String> item2 : availInfo.entrySet()) {
					String value = item2.getValue();
					String id = item2.getKey();

					try {
						if (id.equals("available_for")) {
							availableFor = value;
						} else if (id.equals("start_date")) {
							startDate = (Date) formatter.parse(value);
						} else if (id.equals("end_date")) {
							endDate = (Date) formatter.parse(value);
						}
					} catch (ParseException e) {
						_log.error("Error parsing availabilityInfoMap: " + e.getMessage());
					}

				}

				try {
					UserAvailabilityCalendarLocalServiceUtil.addUserAvailabilityCalendar(userId, companyId,
							availableFor, startDate, endDate);
				} catch (PortalException e) {
					_log.error("Unable to create UserAvailabilityCalendar " + e.getMessage());
				}
			}

		} catch (PortalException e) {
			_log.error("saveAvailabilityInfo failed: " + e.getMessage());
		} catch (SystemException e) {
			_log.error("saveAvailabilityInfo failed: " + e.getMessage());
		}
	}

	public void saveWorkHistorySorted(SocialProfile profileUser, String sortedXml) {
		long userId = profileUser.getUserId();
		String companyNames = "";
		String companyName = "";
		Map<String, String> workDetails = new HashMap<String, String>();
		String jobIds = "";
		String jobId = "";
		List<SocialProfileDetail> profileDetailList;
		try {
			XMLManipulator manipulator = new XMLManipulator(sortedXml);
			workDetails = manipulator.getCompanyNameAndId("company_name");
			jobIds = workDetails.get("JobId");
			companyNames = workDetails.get("CompanyName");
			String[] jobIdArray = jobIds.trim().split(",");
			String[] companyNameArray = companyNames.trim().split(",");

			profileDetailList = SocialProfileDetailLocalServiceUtil.findByUserId(userId);
			Iterator<SocialProfileDetail> profileDetailItr = profileDetailList.iterator();
			SocialProfileDetail profileD = null;
			while (profileDetailItr.hasNext()) {
				profileD = profileDetailItr.next();
				SocialProfileDetailLocalServiceUtil.deleteSocialProfileDetail(profileD);
			}

			for (int i = 0; i < companyNameArray.length; i++) {
				companyName = companyNameArray[i];
				jobId = jobIdArray[i];

				try {
					long socialProfileDetailId = CounterLocalServiceUtil.increment();
					SocialProfileDetail socialProfileDetail = SocialProfileDetailLocalServiceUtil
							.createSocialProfileDetail(socialProfileDetailId);

					socialProfileDetail.setCompanyName(companyName);
					socialProfileDetail.setSocialProfileDetailId(socialProfileDetailId);
					socialProfileDetail.setUserId(userId);
					socialProfileDetail.setUserJobId(jobId);
					socialProfileDetail.setCreateDate(new Date());
					socialProfileDetail.setModifiedDate(new Date());
					SocialProfileDetailLocalServiceUtil.updateSocialProfileDetail(socialProfileDetail);

					Indexer indexer = IndexerRegistryUtil.getIndexer(SocialProfile.class.getName());
					try {
						indexer.reindex(SocialProfile.class.getName(), userId);
					} catch (SearchException e) {
						_log.error(e.getMessage(), e);
					}

				} catch (SystemException e) {
					_log.error("Social Profile detail not added " + companyName + " " + jobId + " " + e.getMessage());
					profileDetailList = SocialProfileDetailLocalServiceUtil.findByUserId(userId);
					Iterator<SocialProfileDetail> pDetailItr = profileDetailList.iterator();
					SocialProfileDetail profileDet = null;
					while (pDetailItr.hasNext()) {
						profileDet = pDetailItr.next();
						SocialProfileDetailLocalServiceUtil.deleteSocialProfileDetail(profileDet);
					}
				}
			}
		} catch (SystemException e) {
			_log.error("saveWorkHistorySorted failed" + e.getMessage());
		} catch (Exception e) {
			_log.error("saveWorkHistorySorted failed" + e.getMessage());
		}

	}

	public void updateSPParameter(String key, long groupId, String value, String description) {

		try {
			SPParameter parameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(groupId, key);

			if (Validator.isNotNull(value)) {
				parameter.setValue(value);
			}

			parameter.setDescription(description);
			SPParameterLocalServiceUtil.updateSPParameter(parameter);
			SPParameterLocalServiceUtil.clearSPParameterPool(groupId, key);

		} catch (NoSuchSPParameterException e) {
			_log.debug("No such spparameter exist with key: " + key + " groupId: " + groupId);
		} catch (Exception e) {
			_log.error("Exception getting SPParameter ==" + e.getMessage());
		}

	}

	public java.util.List<SocialProfile> findByUserTypeAndRegStatus(java.lang.String userType,
			java.lang.String userRegistrationStatus) throws com.liferay.portal.kernel.exception.SystemException {

		return SocialProfileUtil.findByUserTypeAndRegStatus(userType, userRegistrationStatus);

	}

	public java.util.List<SocialProfile> findByUserTypeAndRegStatus(java.lang.String userType,
			java.lang.String userRegistrationStatus, int start, int end)
			throws com.liferay.portal.kernel.exception.SystemException {

		return SocialProfileUtil.findByUserTypeAndRegStatus(userType, userRegistrationStatus, start, end);

	}

	public java.util.List<SocialProfile> findByUserTypeAndRegStatus(java.lang.String userType,
			java.lang.String userRegistrationStatus, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
			throws com.liferay.portal.kernel.exception.SystemException {

		return SocialProfileUtil.findByUserTypeAndRegStatus(userType, userRegistrationStatus, start, end,
				orderByComparator);

	}

	public List<SocialProfile> findByU1_S1_S_E(String userRegistrationStatus, boolean active, int start, int end)
			throws SystemException {
		return socialProfileFinder.findByU1_S1_S_E(userRegistrationStatus, active, start, end);
	}

	public String getFieldValue(long userId, String xml, String fieldName) {
		StringBuffer fieldValue = new StringBuffer();
		XMLManipulator manipulator = new XMLManipulator(xml);

		try {

			// fieldValue = manipulator.findValue("//" + fieldName);

			NodeList nodes = manipulator.findNodeList("//" + fieldName);

			for (int i = 0; i < nodes.getLength(); i++) {
				Node childNode = nodes.item(i);
				String key = childNode.getNodeName();
				String value = childNode.getTextContent().trim();
				if(nodes.getLength() > 1){
					if (!key.equals("#text")) {
						fieldValue.append(value).append(StringPool.EXCLAMATION).append(StringPool.AMPERSAND);
					}
				}else{
					fieldValue.append(value).append(StringPool.SPACE);
				}
			}

		} catch (Exception e) {
			_log.error("Unable to find node: " + fieldName);
		}

		return fieldValue.toString().trim();
	}

	public String findSocialProfileLocation() throws SystemException {
		return socialProfileFinder.findSocialProfileLocation();
	}

	public void addOrUpdateProfileSPListTypes(String key, String[] arrSPList, long scopeGroupId) throws SystemException {
		String keyName = "socialprofile.";
		keyName += key + ".option.field";

		if (ArrayUtil.isNotEmpty(arrSPList)) {
			List<SPListType> spList = SPListTypeLocalServiceUtil.getByKey(keyName, scopeGroupId);

			if ((null != spList) && (spList.size() > 0)) {
				for (SPListType spListType : spList) {
					SPListTypeLocalServiceUtil.deleteSPListType(spListType);
				}
			}

			for (int i = 0; i < arrSPList.length; i++) {
				String value = arrSPList[i];
				SPListTypeLocalServiceUtil.addOrUpdateSPListType(keyName, value, i, scopeGroupId, 0);
			}
		}
	}

	public void updateWorkHistoryRelatedProjects(String companyName, String companyId, long userId, String url,
			String addOrDelete, int start) {

		XMLManipulator manipulator = null;
		SocialProfile profileuser = null;
		try {
			profileuser = SocialProfileLocalServiceUtil.getSocialProfile(userId);
		} catch (NoSuchSocialProfileDetailException e1) {
			_log.error(e1.getMessage(), e1);
		} catch (SystemException e1) {
			_log.error(e1.getMessage(), e1);
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}

		try {
			manipulator = new XMLManipulator(profileuser.getUserInfo());
			Node targetNode = manipulator.selectSingleNode("work_details", companyId);

			if (targetNode != null) {

				// Remove all of the current contents

				if (start == 0) {
					while (targetNode.hasChildNodes()) {
						targetNode.removeChild(targetNode.getFirstChild());
					}
				}

				if (addOrDelete.equalsIgnoreCase("add")) {
					Node newNode = manipulator.createSpecifiedNode(targetNode, url);

					if (newNode != null)
						targetNode.appendChild(newNode);
				} else if (addOrDelete.equalsIgnoreCase("delete")) {
					Node removedNode = manipulator.removeSpecifiedNode(targetNode, url);
					targetNode.removeChild(removedNode);
				}

				// targetNode.setTextContent(value);

				String resultXML = manipulator.toString(null);
				SocialProfile socialprofile = SocialProfileLocalServiceUtil.getSocialProfile(userId);
				socialprofile.setUserInfo(resultXML);
				SocialProfileLocalServiceUtil.updateSocialProfile(socialprofile);
			}
		} catch (Exception e) {
			_log.error("Attribute not found " + e.getMessage());
		}

	}

	
	public void refreshAllSocialProfileXML(long scopeGroupId,
			ResourceRequest request) {
		_log.info("refreshAllSocialProfileXML start....");

		
		String category, categoryDetails, xslFields = StringPool.BLANK;
		String[] xslFieldArray = null;
		// String xql = category;

		SPParameter parameter = null;
		
		String reloadAllXML = SambaashUtil.getParameter(ProfileConstants.USER_PROFILE.XSLNAMES, 0);
		String[] reloadAllXMLArr = reloadAllXML.split(",");

		List<SocialProfile> socialProfiles = null;
		try {
			socialProfiles = getSocialProfiles(-1,-1); 
			
		} catch (Exception e) {
			_log.error("No socialprofile found, unable to refresh XML");
		}

		if (socialProfiles != null) {
			_log.debug("No of Users To reload XML: " + socialProfiles.size());

			for (SocialProfile socialProfile : socialProfiles) {
				try {
					
					XMLManipulator manipulator = new XMLManipulator(socialProfile.getUserInfo());
					manipulator.cleanupXML();

				for (int j = 0; j < reloadAllXMLArr.length; j++) {
					
					category = reloadAllXMLArr[j];
					
					if(category.equalsIgnoreCase("workhistory")){
						categoryDetails = "work_details";
					}else if(category.equalsIgnoreCase("contact_info")){
						categoryDetails = "contact_details";
					}else if(category.equalsIgnoreCase("availability_info")){
						categoryDetails = "user_availability";
					}else if((category.equalsIgnoreCase("personal_info")) || category.equalsIgnoreCase("basic_info") || category.equalsIgnoreCase("network_info")){
						categoryDetails = "";
					}else{	
						categoryDetails = category + "_details";
					}
					
					xslFields = SambaashUtil.getParameter(category + ".fields", scopeGroupId);
					xslFieldArray = xslFields.split(StringPool.COMMA);
			
					for (int i = 0; i < xslFieldArray.length; i++) {
						String fieldName = xslFieldArray[i];
						Map<String, String> attributes = UserProfileUtil.getFieldAttributesMap(fieldName, request);
						_log.info("fieldName " + fieldName + " attributes " + attributes);
						String defaultNodeValue = StringPool.BLANK;

						if (Validator.isNotNull(attributes)) {
							defaultNodeValue = attributes.get("default");
						}

						try {
							if (Validator.isNull(manipulator.findNodeList("//profile/other_details"))) {// if

								// dynamic
								// section
								// parent
								// node
								// doesn't
								// exists

								manipulator.appendNode("other_details", "//profile"); // append

								// a
								// node
								// where
								// all
								// dynamic
								// section
								// will
								// be
								// appended
								// to

							}
						} catch (Exception e) {
							_log.error(e.getMessage(), e);
						}

						if (!category.equals("basic_info") && !category.equals("availability_info")
								&& !category.equals("personal_info") && !category.equals("network_info")
								&& !category.equals("contact_info") && !category.equals("workhistory")) {

							NodeList parentNodeList = manipulator.findNodeList("//other_details/" + category); // check

							// if
							// parent
							// category
							// exists

							if (Validator.isNull(parentNodeList)) { // parent

								// category
								// doesn't
								// exist, so
								// append to
								// "other_details"
								// parent
								// node

								manipulator.appendNode(category, "//other_details");
							}
						} else {
							if (category.equals("contact_info")) {
								if (fieldName.equals("phone_no") || fieldName.equals("ext")) {
									fieldName = "phone_details/" + fieldName;
								} else if (fieldName.equals("address") || fieldName.equals("address1")
										|| fieldName.equals("city") || fieldName.equals("country")
										|| fieldName.equals("postal_code")) {
									fieldName = "address_details/" + fieldName;
								}
							}
						}

						manipulator.findAndAddNodeWithValue(category, categoryDetails, fieldName, defaultNodeValue,
								attributes);
					}// end for
					
				} // end for all sections
					socialProfile.setUserInfo(manipulator.toString(null));
					SocialProfileLocalServiceUtil.updateSocialProfile(socialProfile);
					if (_log.isDebugEnabled()) {
						_log.debug("UserID: [" + socialProfile.getUserId() +  "] has been successfully reloaded.");
					}
					String email = UserLocalServiceUtil.getUser(socialProfile.getUserId()).getEmailAddress();
				} catch (PortalException e) {
					_log.error("Error reloading UserID: [" + socialProfile.getUserId() + "] " + e.getMessage(), e);
					e.printStackTrace();
				} catch (SystemException e) {
					_log.error("Error reloading UserID: [" + socialProfile.getUserId() + "] " + e.getMessage(), e);
					e.printStackTrace();
				} catch (Exception e) {
					_log.error("Error reloading UserID: [" + socialProfile.getUserId() + "] " + e.getMessage(), e);
					e.printStackTrace();
				}
			}// end for user
		}// end if

		/**
		 * Update xml templates
		 */
		for (int j = 0; j < reloadAllXMLArr.length; j++) {
			
			category = reloadAllXMLArr[j];
			
			if(category.equalsIgnoreCase("workhistory")){
				categoryDetails = "work_details";
			}else if(category.equalsIgnoreCase("contact_info")){
				categoryDetails = "contact_details";
			}else if(category.equalsIgnoreCase("availability_info")){
				categoryDetails = "user_availability";
			}else if((category.equalsIgnoreCase("personal_info")) || category.equalsIgnoreCase("basic_info") || category.equalsIgnoreCase("network_info")){
				categoryDetails = "";
			}else{	
				categoryDetails = category + "_details";
			}
		String xmlStrTemplate = StringPool.BLANK;
		String templateName = "socialprofile.xml.template";

		if ((category.equalsIgnoreCase("personal_info")) || (category.equalsIgnoreCase("basic_info"))
				|| (category.equalsIgnoreCase("network_info")) || (category.equalsIgnoreCase("contact_info"))) {
			templateName = "socialprofile.xml.template";
		} else {
			templateName = category + ".xml.template";
		}

		try {
			parameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(scopeGroupId, templateName);
			xmlStrTemplate = parameter.getDescription();
		} catch (NoSuchSPParameterException e1) {
			_log.error("Error retrieving xml template", e1);
		} catch (SystemException e) {
			_log.error("Error retrieving xml template", e);
		}

		if (Validator.isNotNull(xmlStrTemplate)) {
			XMLManipulator template = new XMLManipulator(xmlStrTemplate);

			for (int i = 0; i < xslFieldArray.length; i++) {
				String fieldName = xslFieldArray[i];
				Map<String, String> attributes = UserProfileUtil.getFieldAttributesMap(fieldName, request);
				String defaultNodeValue = "";

				// String type = "";

				if (Validator.isNotNull(attributes)) {
					defaultNodeValue = attributes.get("default");

					// type = attributes.get("fieldType");

				}

				if (Validator.isNull(categoryDetails)) {
					categoryDetails = category;
				}

				if (categoryDetails.equals("contact_details")) {
					if (fieldName.equals("phone_no") || fieldName.equals("ext")) {
						fieldName = "phone_details/" + fieldName;
					} else if (fieldName.equals("address") || fieldName.equals("address1") || fieldName.equals("city")
							|| fieldName.equals("country") || fieldName.equals("postal_code")) {
						fieldName = "address_details/" + fieldName;
					}
				}

				template.findAndAddNodeWithValue(categoryDetails, StringPool.BLANK, fieldName, defaultNodeValue,
						attributes);
			}

			try {
				updateSPParameter(templateName, scopeGroupId, categoryDetails, template.toString(null));
			} catch (Exception e) {
				_log.error("Error updating xml template", e);
			}
		}// end if Validator.isNotNull(xmlStrTemplate)
		}// end for all sections
		_log.info("refreshAllSocialProfileXML end....");
	}
	
	public void refreshSocialProfileXML(String category, String categoryDetails, long scopeGroupId, long userId,
			ResourceRequest request) {
		_log.debug("refreshSocialProfileXML start....");

		String xslFields = SambaashUtil.getParameter(category + ".fields", scopeGroupId);
		String[] xslFieldArray = xslFields.split(StringPool.COMMA);

		// String xql = category;

		SPParameter parameter = null;

		List<SocialProfile> socialProfiles = null;
		try {
			socialProfiles = getSocialProfiles(-1,-1); 
		} catch (Exception e) {
			_log.error("No socialprofile found, unable to refresh XML");
		}

		if (socialProfiles != null) {
			_log.debug("No of Users To reload XML: " + socialProfiles.size());

			for (SocialProfile socialProfile : socialProfiles) {
				try {
					XMLManipulator manipulator = new XMLManipulator(socialProfile.getUserInfo());
					manipulator.cleanupXML();

					for (int i = 0; i < xslFieldArray.length; i++) {
						String fieldName = xslFieldArray[i];
						Map<String, String> attributes = UserProfileUtil.getFieldAttributesMap(fieldName, request);
						_log.info("fieldName " + fieldName + " attributes " + attributes);
						String defaultNodeValue = StringPool.BLANK;

						if (Validator.isNotNull(attributes)) {
							defaultNodeValue = attributes.get("default");
						}

						try {
							if (manipulator.findNodeList("//profile/other_details").getLength() == 0) {// if

								// dynamic
								// section
								// parent
								// node
								// doesn't
								// exists

								manipulator.appendNode("other_details", "//profile"); // append

								// a
								// node
								// where
								// all
								// dynamic
								// section
								// will
								// be
								// appended
								// to

							}
						} catch (Exception e) {
							_log.error(e.getMessage(), e);
						}

						if (!category.equals("basic_info") && !category.equals("availability_info")
								&& !category.equals("personal_info") && !category.equals("network_info")
								&& !category.equals("contact_info") && !category.equals("workhistory")) {

							NodeList parentNodeList = manipulator.findNodeList("//other_details/" + category); // check

							// if
							// parent
							// category
							// exists

							if (parentNodeList.getLength() == 0) { // parent

								// category
								// doesn't
								// exist, so
								// append to
								// "other_details"
								// parent
								// node

								manipulator.appendNode(category, "//other_details");
							}
						} else {
							if (category.equals("contact_info")) {
								if (fieldName.equals("phone_no") || fieldName.equals("ext")) {
									fieldName = "phone_details/" + fieldName;
								} else if (fieldName.equals("address") || fieldName.equals("address1")
										|| fieldName.equals("city") || fieldName.equals("country")
										|| fieldName.equals("postal_code")) {
									fieldName = "address_details/" + fieldName;
								}
							}
						}

						manipulator.findAndAddNodeWithValue(category, categoryDetails, fieldName, defaultNodeValue,
								attributes);
					}// end for

					socialProfile.setUserInfo(manipulator.toString(null));
					SocialProfileLocalServiceUtil.updateSocialProfile(socialProfile);
					if (_log.isDebugEnabled()) {
						_log.debug("UserID: [" + socialProfile.getUserId() +  "] has been successfully reloaded.");
					}
					String email = UserLocalServiceUtil.getUser(socialProfile.getUserId()).getEmailAddress();
				} catch (PortalException e) {
					_log.error("Error reloading UserID: [" + socialProfile.getUserId() + "] " + e.getMessage(), e);
				} catch (SystemException e) {
					_log.error("Error reloading UserID: [" + socialProfile.getUserId() + "] " + e.getMessage(), e);
				} catch (Exception e) {
					_log.error("Error reloading UserID: [" + socialProfile.getUserId() + "] " + e.getMessage(), e);
				}
			}// end for user
		}// end if

		/**
		 * Update xml templates
		 */
		String xmlStrTemplate = StringPool.BLANK;
		String templateName = "socialprofile.xml.template";

		if ((category.equalsIgnoreCase("personal_info")) || (category.equalsIgnoreCase("basic_info"))
				|| (category.equalsIgnoreCase("network_info")) || (category.equalsIgnoreCase("contact_info"))) {
			templateName = "socialprofile.xml.template";
		} else {
			templateName = category + ".xml.template";
		}

		try {
			parameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(scopeGroupId, templateName);
			xmlStrTemplate = parameter.getDescription();
		} catch (NoSuchSPParameterException e1) {
			_log.error("Error retrieving xml template", e1);
		} catch (SystemException e) {
			_log.error("Error retrieving xml template", e);
		}

		if (Validator.isNotNull(xmlStrTemplate)) {
			XMLManipulator template = new XMLManipulator(xmlStrTemplate);

			for (int i = 0; i < xslFieldArray.length; i++) {
				String fieldName = xslFieldArray[i];
				Map<String, String> attributes = UserProfileUtil.getFieldAttributesMap(fieldName, request);
				String defaultNodeValue = "";

				// String type = "";

				if (Validator.isNotNull(attributes)) {
					defaultNodeValue = attributes.get("default");

					// type = attributes.get("fieldType");

				}

				if (Validator.isNull(categoryDetails)) {
					categoryDetails = category;
				}

				if (categoryDetails.equals("contact_details")) {
					if (fieldName.equals("phone_no") || fieldName.equals("ext")) {
						fieldName = "phone_details/" + fieldName;
					} else if (fieldName.equals("address") || fieldName.equals("address1") || fieldName.equals("city")
							|| fieldName.equals("country") || fieldName.equals("postal_code")) {
						fieldName = "address_details/" + fieldName;
					}
				}

				template.findAndAddNodeWithValue(categoryDetails, StringPool.BLANK, fieldName, defaultNodeValue,
						attributes);
			}

			try {
				updateSPParameter(templateName, scopeGroupId, categoryDetails, template.toString(null));
			} catch (Exception e) {
				_log.error("Error updating xml template", e);
			}
		}// end if Validator.isNotNull(xmlStrTemplate)
		_log.debug("refreshSocialProfileXML end....");
	}

	public String addAddress(String addressXml) {
		String message = "Error occured while adding or updating address ...";
		try {
			if (Validator.isNotNull(addressXml)) {
				AddressMap addressMap = null;
				String emailAddress = StringPool.BLANK;
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.parse(new InputSource(new StringReader(addressXml)));
				doc.getDocumentElement().normalize();

				NodeList nodeEmailList = doc.getElementsByTagName("EmailAddress");

				if (nodeEmailList.getLength() > 1) {
					message = "Invalid XML : multiple email address node found";
					throw new Exception(message);
				}

				Node emailNode = nodeEmailList.item(0);

				emailAddress = emailNode.getTextContent();

				_log.info("emailAddress ...." + emailAddress);

				NodeList nodeAddressList = doc.getElementsByTagName("Address");

				for (int i = 0; i < nodeAddressList.getLength(); i++) {
					if (addressMap == null) {
						addressMap = new AddressMap();
					}

					Element fstElmnt = (Element) nodeAddressList.item(i);
					NodeList childNodeList = fstElmnt.getChildNodes();
					SPAddress address = new SPAddress();

					for (int j = 0; j < childNodeList.getLength(); j++) {
						Node innerNode = childNodeList.item(j);

						if ("addressId".equalsIgnoreCase(innerNode.getNodeName())) {
							address.setAddressId(Long.parseLong(innerNode.getTextContent()));
						} else if ("firstName".equalsIgnoreCase(innerNode.getNodeName())) {
							address.setFirstName(innerNode.getTextContent());
						} else if ("lastName".equalsIgnoreCase(innerNode.getNodeName())) {
							address.setLastName(innerNode.getTextContent());
						} else if ("streetAddress".equalsIgnoreCase(innerNode.getNodeName())) {
							address.setStreetAddress(innerNode.getTextContent());
						} else if ("postalcode".equalsIgnoreCase(innerNode.getNodeName())) {
							address.setPostalCode(innerNode.getTextContent());
						} else if ("city".equalsIgnoreCase(innerNode.getNodeName())) {
							address.setCity(innerNode.getTextContent());
						} else if ("country".equalsIgnoreCase(innerNode.getNodeName())) {
							address.setCountry(CountryServiceUtil.getCountryByA2(innerNode.getTextContent()).getName());
						} else if ("phone".equalsIgnoreCase(innerNode.getNodeName())) {
							address.setPhone(innerNode.getTextContent());
						} else if ("defaultShippingAddress".equalsIgnoreCase(innerNode.getNodeName())) {
							address.setDefaultShippingAddress("Y".equalsIgnoreCase(innerNode.getTextContent()) ? true
									: false);
						} else if ("defaultBillingAddress".equalsIgnoreCase(innerNode.getNodeName())) {
							address.setDefaultBillingAddress("Y".equalsIgnoreCase(innerNode.getTextContent()) ? true
									: false);
						}

						_log.debug(innerNode.getNodeName() + " : " + innerNode.getTextContent());
					}

					addressMap.addAddress(address);
				}

				if (addressMap != null && Validator.isNotNull(emailAddress)) {
					addAddress(addressMap, emailAddress);
					message = "Address successfully added or updated ...";
				} else {
					message = "Invaid XML : Either Address Node's not found or email address is null.";
					throw new Exception(message);
				}
			}
		} catch (SAXException e) {
			_log.error(e);
		} catch (IOException e) {
			_log.error(e);
		} catch (ParserConfigurationException e) {
			_log.error(e);
		} catch (NoSuchSocialProfileException e) {
			_log.error("Profile not found to add address.");
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		} catch (Exception e) {
			_log.error("Error occured in addAddress : " + e.getMessage());
		}

		return message;

	}

	private void addAddress(AddressMap addressMap, String emailAddress) throws NoSuchSocialProfileException {
		SocialProfile profile = null;
		Map<String, SPAddress> map = addressMap.getAddressMap();

		if (Validator.isNotNull(map) && map.size() > 0) {
			try {
				User user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(), emailAddress);
				profile = SocialProfileLocalServiceUtil.getSocialProfile(user.getUserId());
			} catch (PortalException e1) {
				throw new NoSuchSocialProfileException();
			} catch (SystemException e1) {
				_log.error("SocialProfile not found for emailAddress: " + emailAddress);
				throw new NoSuchSocialProfileException();
			}

			try {
				for (Map.Entry<String, SPAddress> entry : map.entrySet()) {
					Map<String, String> details = new HashMap<String, String>();
					SPAddress address = entry.getValue();
					details.put("first_name_1", address.getFirstName());
					details.put("last_name_2", address.getLastName());
					details.put("street_address_3", address.getStreetAddress());
					details.put("postal_code_4", address.getPostalCode());
					details.put("city_5", address.getCity());
					details.put("country_6", address.getCountry());
					details.put("phone_7", address.getPhone());
					details.put("default_shipping_address_8", address.isDefaultShippingAddress() ? "Yes" : "No");
					details.put("default_billing_address_9", address.isDefaultBillingAddress() ? "Yes" : "No");
					addOrUpdateDynamicSection(SHIPPING_OR_BILLING_ADDRESS, "shipping_or_billing_address_details",
							String.valueOf(address.getAddressId()), profile,
							SambaashUtil.getGroupId(profile.getCompanyId()), details);
				}
			} catch (Exception e) {
				_log.error("Error in addBillingDetails: " + e.getMessage(), e);
			}
		}
	}

	public String getAddress(String emailAddress) {
		String message = "Error occured while retrieving address ...";

		if (Validator.isNull(emailAddress)) {
			message = "Invalid Email address.";
		}

		SocialProfile profile = null;
		AddressMap addressMap = null;

		try {
			User user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(), emailAddress);
			profile = SocialProfileLocalServiceUtil.getSocialProfile(user.getUserId());
			XMLManipulator manipulator = new XMLManipulator(profile.getUserInfo());
			addressMap = manipulator.getAddressDetails(SHIPPING_OR_BILLING_ADDRESS);
			message = transformToXmlString(addressMap, emailAddress);

		} catch (PortalException e) {
			_log.error("SocialProfile not found for emailAddress: " + emailAddress, e);
			message = "SocialProfile not found for emailAddress: " + emailAddress;
		} catch (SystemException e) {
			_log.error(e);
		}

		return message;
	}

	private String transformToXmlString(AddressMap addressMap, String emailAddress) {
		String message = "Error in creating XML String";

		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder;

			documentBuilder = documentBuilderFactory.newDocumentBuilder();

			Document document = documentBuilder.newDocument();
			Element rootElement = document.createElement("Addresses");
			document.appendChild(rootElement);

			Element em = document.createElement("EmailAddress");
			em.appendChild(document.createTextNode(emailAddress));
			rootElement.appendChild(em);

			if (addressMap != null && addressMap.size() > 0) {
				Map<String, SPAddress> map = addressMap.getAddressMap();

				for (Map.Entry<String, SPAddress> entry : map.entrySet()) {
					Element eleAddress = document.createElement("Address");
					SPAddress address = entry.getValue();

					Element eleAddressId = document.createElement("addressId");
					eleAddressId.appendChild(document.createTextNode(String.valueOf(address.getAddressId())));
					eleAddress.appendChild(eleAddressId);

					Element eleFirstName = document.createElement("firstName");
					eleFirstName.appendChild(document.createTextNode(address.getFirstName()));
					eleAddress.appendChild(eleFirstName);

					Element eleLastName = document.createElement("lastName");
					eleLastName.appendChild(document.createTextNode(address.getLastName()));
					eleAddress.appendChild(eleLastName);

					Element eleStreetAddress = document.createElement("streetAddress");
					eleStreetAddress.appendChild(document.createTextNode(address.getStreetAddress()));
					eleAddress.appendChild(eleStreetAddress);

					Element eleCity = document.createElement("city");
					eleCity.appendChild(document.createTextNode(address.getCity()));
					eleAddress.appendChild(eleCity);

					Element elePhone = document.createElement("phone");
					elePhone.appendChild(document.createTextNode(address.getPhone()));
					eleAddress.appendChild(elePhone);

					Element elePostalcode = document.createElement("postalcode");
					elePostalcode.appendChild(document.createTextNode(address.getPostalCode()));
					eleAddress.appendChild(elePostalcode);

					Element eleCountrycode = document.createElement("country");
					eleCountrycode.appendChild(document.createTextNode(CountryServiceUtil.getCountryByName(
							address.getCountry()).getA2()));
					eleAddress.appendChild(eleCountrycode);

					Element eleDefaultShippingAddress = document.createElement("defaultShippingAddress");
					eleDefaultShippingAddress.appendChild(document.createTextNode(StringPool.TRUE
							.equalsIgnoreCase(String.valueOf(address.isDefaultShippingAddress())) ? "Y" : "N"));
					eleAddress.appendChild(eleDefaultShippingAddress);

					Element eleDefaultBillingAddress = document.createElement("defaultBillingAddress");
					eleDefaultBillingAddress.appendChild(document.createTextNode(StringPool.TRUE
							.equalsIgnoreCase(String.valueOf(address.isDefaultBillingAddress())) ? "Y" : "N"));
					eleAddress.appendChild(eleDefaultBillingAddress);

					rootElement.appendChild(eleAddress);

				}
			}

			document.normalize();
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StringWriter writer = new StringWriter();
			Result result = new StreamResult(writer);
			transformer.transform(source, result);

			return writer.toString();

		} catch (ParserConfigurationException e) {
			_log.error(e);
		} catch (TransformerConfigurationException e) {
			_log.error(e);
		} catch (TransformerException e) {
			_log.error(e);
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

		return message;
	}

	public List<AssetCategory> getAssetCategories(long scopeGroupId, long vocabularyId) {
		List<AssetCategory> categories = null;
		try {
			int noOfCategories = AssetCategoryLocalServiceUtil.getAssetCategoriesCount();
			categories = AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabularyId, 0, noOfCategories, null);
		} catch (SystemException e) {
			_log.error("Unable to get asset categories: " + vocabularyId, e);
		}

		return categories;
	}

	@SuppressWarnings("deprecation")
	public void addAsMentor(User user, ServiceContext serviceContext) {
		try {
			Map<String, Serializable> expandoAttributes = new HashMap<String, Serializable>();
			expandoAttributes.put(SambaashConstants.MENTOR, true);
			serviceContext.setExpandoBridgeAttributes(expandoAttributes);
			user.setExpandoBridgeAttributes(serviceContext);
			UserLocalServiceUtil.updateUser(user);
			Role role = null;
			try {
				role = RoleLocalServiceUtil.getRole(user.getCompanyId(), SambaashConstants.MENTOR_ROLE);
			} catch (NoSuchRoleException ne) {
				_log.error("Role not found, will add " + SambaashConstants.MENTOR_ROLE);
				Map<Locale, String> titleMap = new HashMap<Locale, String>();
				titleMap.put(LocaleUtil.getDefault(), SambaashConstants.MENTOR_ROLE);

				Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
				descriptionMap.put(LocaleUtil.getDefault(), SambaashConstants.MENTOR_ROLE);

				role = RoleLocalServiceUtil.addRole(SambaashUtil.getAdminUserId(), user.getCompanyId(),
						SambaashConstants.MENTOR_ROLE, titleMap, descriptionMap, RoleConstants.TYPE_REGULAR);
			}

			if (Validator.isNotNull(role)) {
				UserLocalServiceUtil.addRoleUsers(role.getRoleId(), new long[] { user.getUserId() });
			}

		} catch (SystemException e) {
			_log.error(e);
		} catch (PortalException e) {
			_log.error(e);
		}

	}

	public AssetVocabulary addAssetVocabulary(long userId, String title, ServiceContext serviceContext)
			throws PortalException, SystemException {
		Map<Locale, String> titleMap = new HashMap<Locale, String>();
		titleMap.put(Locale.US, title);

		return AssetVocabularyLocalServiceUtil.addVocabulary(userId, title, titleMap, null, null, serviceContext);
	}

	/**
	 * Returns the social profile where companyId = &#63; and twitterId = &#63;
	 * or throws a {@link NoSuchSocialProfileException} if it could not be
	 * found.
	 *
	 * @param companyId
	 *            the company ID
	 * @param twitterId
	 *            the twitter ID
	 * @return the matching social profile
	 * @throws NoSuchSocialProfileException
	 *             if a matching social profile could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public SocialProfile findByTwitterId(long companyId, java.lang.String twitterId)
			throws com.liferay.portal.kernel.exception.SystemException, NoSuchSocialProfileException {
		return SocialProfileUtil.findByTwitterId(companyId, twitterId);
	}

	/**
	 * Returns the social profile where companyId = &#63; and linkedinId = &#63;
	 * or throws a {@link NoSuchSocialProfileException} if it could not be
	 * found.
	 *
	 * @param companyId
	 *            the company ID
	 * @param linkedinId
	 *            the linkedin ID
	 * @return the matching social profile
	 * @throws NoSuchSocialProfileException
	 *             if a matching social profile could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public SocialProfile findByLinkedinId(long companyId, java.lang.String linkedinId)
			throws com.liferay.portal.kernel.exception.SystemException, NoSuchSocialProfileException {
		return SocialProfileUtil.findByLinkedinId(companyId, linkedinId);
	}

	/**
	 * Returns the social profile where companyId = &#63; and yahooId = &#63; or
	 * throws a {@link NoSuchSocialProfileException} if it could not be found.
	 *
	 * @param companyId
	 *            the company ID
	 * @param yahooId
	 *            the yahoo ID
	 * @return the matching social profile
	 * @throws NoSuchSocialProfileException
	 *             if a matching social profile could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public SocialProfile findByYahooId(long companyId, java.lang.String yahooId)
			throws com.liferay.portal.kernel.exception.SystemException, NoSuchSocialProfileException {
		return SocialProfileUtil.findByYahooId(companyId, yahooId);
	}

	/**
	 * Returns the social profile where companyId = &#63; and googleId = &#63;
	 * or throws a {@link NoSuchSocialProfileException} if it could not be
	 * found.
	 *
	 * @param companyId
	 *            the company ID
	 * @param googleId
	 *            the google ID
	 * @return the matching social profile
	 * @throws NoSuchSocialProfileException
	 *             if a matching social profile could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public SocialProfile findByGoogleId(long companyId, java.lang.String googleId)
			throws com.liferay.portal.kernel.exception.SystemException, NoSuchSocialProfileException {
		return SocialProfileUtil.findByGoogleId(companyId, googleId);
	}

	public ArrayList<String> fetchSocialProfileDBColNames() {
		ArrayList<String> dbColNamesList = new ArrayList<String>();

		// Object[][] userTableColumns = UserImpl.TABLE_COLUMNS;

		Object[][] socialProfileTableColumns = SocialProfileBaseImpl.TABLE_COLUMNS;

		// for (Object[] outerArray : userTableColumns) {
		// dbColNamesList.add((String) outerArray[0]); }

		for (Object[] outerArray : socialProfileTableColumns) {
			dbColNamesList.add((String) outerArray[0]);
		}

		return dbColNamesList;
	}

	public User addUserPlatform(String firstName, String lastName, String emailAddress, String password,
			boolean passwordEmail, ServiceContext serviceContext) {
		try {
			User userByEmail = null;
			long companyId = SambaashUtil.getCurrentCompanyId();
			try {
				userByEmail = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
			} catch (NoSuchUserException e) {

			}

			if (userByEmail != null) {
				return userByEmail;
			} else {
				
				PermissionChecker orgPermissionChecker = PermissionThreadLocal.getPermissionChecker();

				PermissionUtil.initializeAdminPermissionChecker();
				
				User user = UserServiceUtil.addUser(companyId, false, // auto

						// password

						password, password, true, // auto

						// screen name

						StringPool.BLANK, // screen name
						emailAddress, new Long(0), // facebookId
						StringPool.BLANK, // open id
						LocaleUtil.getDefault(), firstName, StringPool.BLANK, // middle

						// name

						lastName, 0, // prefix id
						0, // suffix id
						true, 1, 1, 1970, // birthdate
						StringPool.BLANK, // job title
						null, // group ids
						null, // organization ids
						null, // role ids
						null, // usegroup ids
						false, // send email
						serviceContext);

				user.setStatus(0);
				user.setEmailAddressVerified(true);
				user.setPasswordReset(true);
				UserLocalServiceUtil.updateUser(user);

				SocialProfile socialProfile = SocialProfileLocalServiceUtil.getSocialProfile(user.getUserId());
				socialProfile.setUserRegistrationStatus(SambaashConstants.REGISTRATION.USER_REGISTRATION_STATUS_ACTIVE);

				String membershipPackage = SambaashUtil.getParameter(SambaashConstants.MP_INDIVIDUAL_DEFAULTPACKAGE_ID,
						Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID));

				if (Validator.isNotNull(membershipPackage)) {
					socialProfile.setMemberPackage(Long.parseLong(membershipPackage));
				}

				SocialProfileLocalServiceUtil.updateSocialProfile(socialProfile);
				serviceContext.setAttribute("fromContestReg", "fromContestReg");

				if (passwordEmail) {
					sendPasswordEmail(user, password, serviceContext);
				}
				
				PermissionThreadLocal.setPermissionChecker(orgPermissionChecker);

				return user;
			}

		} catch (Exception e) {
			_log.error(e);
		}

		return null;
	}

    public void sendPasswordEmail(User user, String password, ServiceContext serviceContext) throws SystemException {
        try {
            String fromName = PrefsPropsUtil.getString(user.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
            String fromAddress = PrefsPropsUtil.getString(user.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

            String toName = user.getFullName();
            String toAddress = user.getEmailAddress();

            String subject = StringPool.BLANK;
            String body = StringPool.BLANK;

            SPMailTemplate spMailTemplate;

            String userType =  serviceContext.getAttribute("userType").toString();
            String virtualHostId = serviceContext.getAttribute("virtualHostId").toString();

            _log.error("Sending Password mail template for "+ userType +" virtualHostId " + virtualHostId);
            
            if (Validator.isNotNull(userType) && Validator.isNumber(virtualHostId)) {
                SPUserTypeConfig spUserTypeConfig = SPUserTypeConfigLocalServiceUtil
                        .findByUserTypeAndVirtualHostId(userType, Long.parseLong(virtualHostId));
                String templateName = spUserTypeConfig.getAccountCreationTemplateName();
                _log.error("Sending mail template for "+ userType +" to " + user.getUserId());
                if (Validator.isNotNull(templateName)) {
                    spMailTemplate = SPMailTemplateLocalServiceUtil.getTemplateByName(templateName);
                    _log.error("mail template is "+  spMailTemplate.getTemplateName());
                    subject = spMailTemplate.getSubject();
                    body = spMailTemplate.getHtmlContent();
                    
                    if(Validator.isNotNull(spMailTemplate.getFromName())){
                    	fromName = spMailTemplate.getFromName();
                    }
                    if(Validator.isNotNull(spMailTemplate.getFromAddress())){
                    	fromAddress = spMailTemplate.getFromAddress();
                    }
                    
                    _log.error(String.format("templateName %s, templateId %s, version %s, fromName %s, fromAddress %s",
                            spMailTemplate.getTemplateName(), spMailTemplate.getSpMailTemplateId(),
                            spMailTemplate.getVersionNumber(), spMailTemplate.getFromName(), spMailTemplate.getFromAddress()));
                }
            }

            if (Validator.isNull(subject)) {
                subject = getContent(user.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_SUBJECT);
            }

            if (Validator.isNull(body)) {
                body = getContent(user.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_BODY);
            }

            SubscriptionSender subscriptionSender = new SubscriptionSender();

            subscriptionSender.setBody(body);
            subscriptionSender.setCompanyId(user.getCompanyId());
            subscriptionSender.setContextAttributes("[$USER_ID$]", user.getUserId(), "[$USER_PASSWORD$]", password,
                    "[$USER_SCREENNAME$]", user.getScreenName());
            subscriptionSender.setFrom(fromAddress, fromName);
            subscriptionSender.setHtmlFormat(true);
            subscriptionSender.setMailId("user", user.getUserId());
            subscriptionSender.setSubject(subject);
            subscriptionSender.setUserId(user.getUserId());

            subscriptionSender.addRuntimeSubscribers(toAddress, toName);

            subscriptionSender.flushNotificationsAsync();
        } catch (Exception e) {
            _log.error(e);
        }
    }
    
    
    public void sendWelcomeEmail(User user, ServiceContext serviceContext) throws SystemException {
        try {
            String fromName = PrefsPropsUtil.getString(user.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
            String fromAddress = PrefsPropsUtil.getString(user.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

            String toName = user.getFullName();
            String toAddress = user.getEmailAddress();

            String subject = StringPool.BLANK;
            String body = StringPool.BLANK;

            SPMailTemplate spMailTemplate;

            String userType = (String) serviceContext.getAttribute("userType");
            String virtualHostId = (String) serviceContext.getAttribute("virtualHostId");

            _log.error("Sending Welcome Email template for "+ userType +" virtualHostId " + virtualHostId);
            
            if (Validator.isNotNull(userType) && Validator.isNumber(virtualHostId)) {
                SPUserTypeConfig spUserTypeConfig = SPUserTypeConfigLocalServiceUtil
                        .findByUserTypeAndVirtualHostId(userType, Long.parseLong(virtualHostId));
                String templateName = spUserTypeConfig.getWelcomeTemplateName();
                _log.error("Sending mail template for "+ userType +" to " + user.getUserId());
                if (Validator.isNotNull(templateName)) {
                    spMailTemplate = SPMailTemplateLocalServiceUtil.getTemplateByName(templateName);
                    _log.error("mail template is "+  spMailTemplate.getTemplateName());
                    subject = spMailTemplate.getSubject();
                    body = spMailTemplate.getHtmlContent();
                    _log.error(String.format("templateName %s, templateId %s, version %s",
                            spMailTemplate.getTemplateName(), spMailTemplate.getSpMailTemplateId(),
                            spMailTemplate.getVersionNumber()));
                }
            }

            if (Validator.isNull(subject)) {
                subject = getContent(user.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_SUBJECT);
            }

            if (Validator.isNull(body)) {
                body = getContent(user.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_NO_PASSWORD_BODY);
            }

            SubscriptionSender subscriptionSender = new SubscriptionSender();

            subscriptionSender.setBody(body);
            subscriptionSender.setCompanyId(user.getCompanyId());
            subscriptionSender.setContextAttributes("[$USER_ID$]", user.getUserId(),
                    "[$USER_SCREENNAME$]", user.getScreenName());
            subscriptionSender.setFrom(fromAddress, fromName);
            subscriptionSender.setHtmlFormat(true);
            subscriptionSender.setMailId("user", user.getUserId());
            subscriptionSender.setSubject(subject);
            subscriptionSender.setUserId(user.getUserId());

            subscriptionSender.addRuntimeSubscribers(toAddress, toName);

            subscriptionSender.flushNotificationsAsync();
        } catch (Exception e) {
            _log.error(e);
        }
    }
    

	private String getContent(long companyId, String key) throws Exception {

		Object returnObj = PortalClassInvoker.invoke(false, _getStringMethodKey1, companyId, key);

		if (returnObj != null) {
			return (String) returnObj;
		} else {
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	public void updateProfileType(User user, ProfileType profileType, ServiceContext serviceContext) {
		try {
			if (Validator.isNotNull(profileType.getValue())) {
				Map<String, Serializable> expandoAttributes = new HashMap<String, Serializable>();
				expandoAttributes.put(SambaashConstants.PROFILE_TYPE, new String[] { profileType.getValue() });
				serviceContext.setExpandoBridgeAttributes(expandoAttributes);
				user.setExpandoBridgeAttributes(serviceContext);

				UserLocalServiceUtil.updateUser(user);

				Role role = null;

				if (!ProfileType.USER.getValue().equalsIgnoreCase(profileType.getValue())) {
					String startupRole = getDefaultStartupRole(profileType, serviceContext, profileType.name());
					try {
						role = RoleLocalServiceUtil.getRole(user.getCompanyId(), startupRole);
					} catch (NoSuchRoleException ne) {
						_log.error("Role not found, will add " + startupRole);
						Map<Locale, String> titleMap = new HashMap<Locale, String>();
						titleMap.put(LocaleUtil.getDefault(), startupRole);

						Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
						descriptionMap.put(LocaleUtil.getDefault(), startupRole);

						role = RoleLocalServiceUtil.addRole(SambaashUtil.getAdminUserId(), user.getCompanyId(),
								startupRole, titleMap, descriptionMap, RoleConstants.TYPE_REGULAR);
					}

					if (Validator.isNotNull(role)) {
						UserLocalServiceUtil.addRoleUsers(role.getRoleId(), new long[] { user.getUserId() });
					}
				}
			}

		} catch (SystemException e) {
			_log.error(e);
		} catch (PortalException e) {
			_log.error(e);
		}

	}

	private String getDefaultStartupRole(ProfileType profileType, ServiceContext serviceContext, String defaultRole) {
		String param = ProfileType.STARTUP.equals(profileType) ? "startupDefaultRole" : "startupDefaultRole."+profileType.name();
		String startupRole = SambaashUtil.getParameter(param, serviceContext.getScopeGroupId());
		return StringUtils.isEmpty(startupRole) ? defaultRole : startupRole;
	}

	public AssetCategory addAssetCategory(long userId, long parentCategoryId, String title, long vocabularyId,
			ServiceContext serviceContext) throws PortalException, SystemException {
		Map<Locale, String> titleMap = new HashMap<Locale, String>();
		titleMap.put(Locale.US, title);
		return AssetCategoryLocalServiceUtil.addCategory(userId, parentCategoryId, titleMap, null, vocabularyId, null,
				serviceContext);
	}
	
	public Map<String, List<String>> getIndexableFieldsMap(long companyId)
			throws PortalException, SystemException {

		String defaultCommunityName = PropsUtil
				.get(PropsKeys.VIRTUAL_HOSTS_DEFAULT_SITE_NAME);
		Group group = GroupLocalServiceUtil.getGroup(companyId,
				defaultCommunityName);
		long scopeGroupId = group.getGroupId();

		String profielFriendlyURL = StringPool.SLASH
				+ SambaashUtil.getParameter(SambaashConstants.URL.PROFILE_IND_PRIVATE, scopeGroupId);

		Map<String, List<String>> indexableFieldsMap = new HashMap<String, List<String>>();
		
		try {
			Layout layout = LayoutLocalServiceUtil.getFriendlyURLLayout(scopeGroupId, false, profielFriendlyURL);

			long plid = layout.getPlid();
			ClassLoader cl = PortalClassLoaderUtil.getClassLoader();
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
					.forClass(com.liferay.portal.model.PortletPreferences.class, cl);
			dynamicQuery.add(PropertyFactoryUtil.forName("plid").eq(new Long(plid)));
			dynamicQuery.add(PropertyFactoryUtil.forName("portletId").like(PORTLET_ID + "%"));

			@SuppressWarnings("unchecked")
			List<PortletPreferences> portletPreferencesList = PortletPreferencesLocalServiceUtil
					.dynamicQuery(dynamicQuery);

			for (PortletPreferences portletPreferences : portletPreferencesList) {
				List<String> indexableFields = new ArrayList<String>();
				String portletId = portletPreferences.getPortletId();
				javax.portlet.PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletPreferencesFactory()
						.getLayoutPortletSetup(layout, portletId);

				String xslName = prefs.getValue("name", "");

				if (Validator.isNull(xslName)) {
					continue;
				}

				Map<String, String[]> preferences = prefs.getMap();

				for (Map.Entry<String, String[]> entry : preferences.entrySet()) {
					String key = entry.getKey();

					if ("name".equalsIgnoreCase(key)) {
						continue;
					}

					String[] values = entry.getValue();
					String value = "";

					if (values.length > 0) {
						value = values[0];
					}

					String[] valueArray = value.split(StringPool.COMMA);

					for (int i = 0; i < valueArray.length; i++) {
						String v = valueArray[i];

						if (v.startsWith("indexable")) {
							String[] indexableStaff = v.split(StringPool.COLON);

							if (indexableStaff.length >= 2) {
								if ("true".equalsIgnoreCase(indexableStaff[1])) {
									indexableFields.add(key);
								}
							}
						}
					}
				}

				indexableFieldsMap.put(xslName, indexableFields);
				if (_log.isDebugEnabled()) {
					_log.debug("final indexable fields " + indexableFields);
				}
			}

		} catch (Exception e) {
			_log.error("Finding layout by [scopeGroupId: " + scopeGroupId + "; profielFriendlyURL: "
					+ profielFriendlyURL + "] failed");
		}

		return indexableFieldsMap;
	}
	
	public NodeList getProfileFields(String userId) {

		SocialProfile profileUser = null;
		try {
			profileUser = SocialProfileLocalServiceUtil.getSocialProfile(Long.parseLong(userId));
		} catch (NumberFormatException e) {
			_log.error(e);
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		NodeList list = null;
		if (Validator.isNotNull(profileUser)) {
			XMLManipulator manipulator = new XMLManipulator(profileUser.getUserInfo());
			list = manipulator.getXSLNodes();

		}
		return list;

	}
	
	public String EducationStringValue(String i) {
		if (i.trim().equalsIgnoreCase("Bachelor's / Honours")) {
			return "Bachelor";
		} else if (i.trim().equalsIgnoreCase("Diploma")) {
			return "Diploma";
		} else if (i.trim().equalsIgnoreCase("GCE 'A' Level")) {
			return "GCE ";
		} else if (i.trim().equalsIgnoreCase("Masters / PhD")) {
			return "Masters / PhD";
		} else if (i.trim().equalsIgnoreCase("NTC/ NITEC/ Higher NITEC")) {
			return "NTC/ NITEC/ Higher NITEC";
		} else if (i.trim().equalsIgnoreCase("PSLE and below")) {
			return "PSLE and below";
		}  else if (i.trim().equalsIgnoreCase("Secondary")) {
			return "Secondary";
		}else {
			return "Invalid status code";
		}
	}
	
	public String EmploymentStatusValue(String i) {
		if ((i.trim().contains("Employed")) && (i.trim().contains("Full time"))) {
			return "Employed - Full time";
		} else if ((i.trim().contains("Employed")) && (i.trim().contains("Part time"))) {
			return "Employed - Part time";
		} else if (i.trim().equalsIgnoreCase("Freelancer")) {
			return "Freelancer";
		} else if (i.trim().equalsIgnoreCase("Others")) {
			return "Others";
		} else if (i.trim().equalsIgnoreCase("Self-employed")) {
			return "Self-employed";
		} else if (i.trim().equalsIgnoreCase("Unemployed - seeking employment for 3 to 6 months")) {
			return "Unemployed - seeking employment for 3 to 6 months";
		}  else if (i.trim().equalsIgnoreCase("Unemployed - seeking employment for less than 3 months")) {
			return "Unemployed - seeking employment for less than 3 months";
		} else if (i.trim().equalsIgnoreCase("Unemployed - seeking employment for more than 6 months")) {
			return "Unemployed - seeking employment for more than 6 months";
		}else if (i.trim().equalsIgnoreCase("Retired")) {
			return "Retired";
		} else {
			return "Invalid status code";
		}
	}
	
	public void mergeFormJsonToProfile(String jsonArrStr,long companyId,long groupId){
		try{
			boolean isMultiInst = false;
			String emailAddress = StringPool.BLANK;
			//String xmlFieldName = StringPool.BLANK;
			String xmlSection = StringPool.BLANK;
			com.liferay.portal.kernel.json.JSONObject jObject1 = null;
			org.json.JSONArray newJArray = new org.json.JSONArray(jsonArrStr);
			SocialProfile socialProfile = null;
			User user = null;
			String instance = String.valueOf(new Date().getTime());
			String genderVal = "0";
			String eduVal = "0";
			String empVal = "0";
			boolean isRemove = true;
			Map<String, String> workDetails = new HashMap<String, String>();
			for (int i = 0; i < newJArray.length(); i++) {
				jObject1 = JSONFactoryUtil.createJSONObject(newJArray.getString(i));
				String emailAddressJSON = StringPool.BLANK;
				String gender = StringPool.BLANK;
				String edu = StringPool.BLANK;
				String xmlFieldName = StringPool.BLANK;
				for(int k = 0;k < jObject1.length();k++){
					String jsonKey = jObject1.names().getString(k);
					String jsonValue = jObject1.getString(jsonKey);
					if(ProfileConstants.ID.equalsIgnoreCase(jsonKey)){
						_log.debug("id jsonKey " + jsonKey);
						xmlFieldName = jsonValue;
					}	
					if(ProfileConstants.MULTI_INSTANCE.equalsIgnoreCase(jsonKey)){
						isMultiInst = Boolean.parseBoolean(jsonValue);
					}
					if(ProfileConstants.VALUES.equalsIgnoreCase(jsonKey)){
						org.json.JSONArray newJArray1 = new org.json.JSONArray(jsonValue);
						//com.liferay.portal.kernel.json.JSONObject jObject2 = JSONFactoryUtil.createJSONObject(newJArray1.getString(0));
						_log.debug("array length email " + newJArray1.length());
						if(newJArray1.length() >= 1){
							emailAddressJSON = newJArray1.getString(0);
						}
						_log.debug("array length " + emailAddress);
					}
					if(ProfileConstants.EMAIL_ADDRESS.equalsIgnoreCase(xmlFieldName)){
						emailAddress = emailAddressJSON;
					}
					if(ProfileConstants.GENDER.equalsIgnoreCase(xmlFieldName)){
						gender = emailAddressJSON;
						if(ProfileConstants.GENDER_MALE.equalsIgnoreCase(emailAddressJSON)){
							genderVal = "1";
						}
					}
					if(ProfileConstants.HIGHEST_EDUCATION.equalsIgnoreCase(xmlFieldName)){
						edu = emailAddressJSON;
						eduVal = EducationStringValue(emailAddressJSON);
					}
					if(ProfileConstants.EMPLOYMENT_STATUS.equalsIgnoreCase(xmlFieldName)){
						empVal = EmploymentStatusValue(emailAddressJSON);
					}
					if(ProfileConstants.SECTION_ID.equalsIgnoreCase(jsonKey)){
						xmlSection = jsonValue;
					}
					
				}
				_log.debug("multi_instance " + isMultiInst + " xmlFieldName " + xmlFieldName );
				if(!emailAddress.isEmpty()){
					user =  UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
					if(Validator.isNotNull(user)){
						socialProfile = SocialProfileLocalServiceUtil.getSocialProfile(user.getUserId());
						_log.debug("socialProfile " + socialProfile.getUserId());
					}	
				}
				
				for(int k = 0;k < jObject1.length();k++){
					String jsonKey = jObject1.names().getString(k);
					String jsonValue = jObject1.getString(jsonKey);
					if(ProfileConstants.VALUES.equalsIgnoreCase(jsonKey)){
						org.json.JSONArray newJArray1 = new org.json.JSONArray(jsonValue);
						//com.liferay.portal.kernel.json.JSONObject jObject2 = JSONFactoryUtil.createJSONObject(newJArray1.getString(0));
						String xmlFieldValue =  StringPool.BLANK;
						String[] xmlFieldValues = newJArray1.toString().split(",");
						if(newJArray1.length() >= 1){
							xmlFieldValue = newJArray1.getString(0);
						}
						if(isMultiInst && ProfileConstants.WORKHISTORY.equalsIgnoreCase(xmlSection)){
							workDetails.put(xmlFieldName, xmlFieldValue);
							_log.debug("xmlFieldName " + xmlFieldName + " xmlSection " + xmlSection + " instance " + instance + " xmlFieldValue " + xmlFieldValue);
						}else if(isMultiInst && !ProfileConstants.WORKHISTORY.equalsIgnoreCase(xmlSection)){
							_log.debug("xmlFieldName " + xmlFieldName + " xmlSection " + xmlSection + " instance " + instance + " xmlFieldValue " + xmlFieldValue);
							if(isRemove){
								socialProfile = removeDynamicSection(xmlSection,socialProfile,companyId);
								isRemove = false;
							}
							if(newJArray1.length() >= 1){
								for(int x=0;x<newJArray1.length();x++){
									Map<String, String> dynamicDetails = new HashMap<String, String>();
									String instance1 = String.valueOf(new Date().getTime());
									dynamicDetails.put(xmlFieldName, newJArray1.getString(x));
									addOrUpdateDynamicSectionWithFormData(xmlSection, xmlSection + "_details",socialProfile, groupId, dynamicDetails,instance1);
								}
							}
						}else{
							if(!xmlFieldName.equalsIgnoreCase(ProfileConstants.EMAIL_ADDRESS)){
								if(ProfileConstants.GENDER.equalsIgnoreCase(xmlFieldName)){
									xmlFieldValue = genderVal;
								}
								if(ProfileConstants.HIGHEST_EDUCATION.equalsIgnoreCase(xmlFieldName)){
									xmlFieldValue = eduVal;
								}
								if(ProfileConstants.EMPLOYMENT_STATUS.equalsIgnoreCase(xmlFieldName)){
									xmlFieldValue = empVal;
								}
								if(Validator.isNotNull(socialProfile)){
									_log.debug("xmlFieldName " + xmlFieldName + " xmlFieldValue " + xmlFieldValue);
									saveProfileInfo(xmlFieldName, xmlFieldValue,socialProfile, user, groupId);
								}
							}	
						}	
					}
				}	
			}
			addOrUpdateWorkHistoryFromFormData(ProfileConstants.WORKHISTORY, ProfileConstants.WORKHISTORY+"_details", instance,
					socialProfile, groupId,workDetails);
			
		}catch(Exception e){
			_log.error("profile xml update failed " + e.getMessage());
		}
	}
	
	private SocialProfile removeDynamicSection(String xmlSection,SocialProfile profileUser,long companyId) {
		// TODO Auto-generated method stub
		//SocialProfile socialprofile = null;
		try {
			XMLManipulator manipulator = new XMLManipulator(profileUser.getUserInfo());
			
			Node targetNode = manipulator.findNode("other_details" + StringPool.SLASH + xmlSection);

			//Node targetNode = manipulator.selectSingleNode(xmlSection, String.valueOf(companyId));

			if (targetNode != null) {

				// Remove all of the current contents

					while (targetNode.hasChildNodes()) {
						targetNode.removeChild(targetNode.getFirstChild());
					}

				String resultXML = manipulator.toString(null);
				//socialprofile = SocialProfileLocalServiceUtil.getSocialProfile(profileUser.getUserId());
				profileUser.setUserInfo(resultXML);
				SocialProfileLocalServiceUtil.updateSocialProfile(profileUser);
			}
		} catch (Exception e) {
			_log.error("Attribute not found " + e.getMessage());
		}
		return profileUser;
		
	}
	
	public void addOrUpdateDynamicSectionWithFormData(String categoryName, String categoryDetails,
			SocialProfile profileUser, long groupId, Map<String, String> details,String instance1) {

		XMLManipulator manipulator = null;
		String xmlFile = "";
		SPParameter parameter = null;

		try {
			manipulator = new XMLManipulator(profileUser.getUserInfo());

			// check if the same nodeId exists, otherwise create a new node

				Node attr = manipulator.findNode("other_details" + StringPool.SLASH + categoryName + StringPool.SLASH
						+ categoryDetails+ "[@id='" + instance1 + "']");

			if (Validator.isNull(attr)) { // create new node
				try {
					parameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(groupId, categoryName
							+ ".xml.template");
					xmlFile = parameter.getDescription();
				} catch (NoSuchSPParameterException e1) {
					_log.error("Error retrieving xml template", e1);
				}
				String nodeId = instance1;
				Node node = manipulator.appendXmlWithId("//other_details/" + categoryName, xmlFile,nodeId);
				manipulator.appendXmlWithId(categoryName, xmlFile, nodeId);
				
				if (node == null) {
					manipulator.appendNode(categoryName, "//other_details");
					manipulator.appendXmlWithId("//other_details/" + categoryName, xmlFile,nodeId);
				}
				
				profileUser.setUserInfo(manipulator.toString(null));
			}

			// populate with values

			for (Map.Entry<String, String> work : details.entrySet()) {
				String fieldName = work.getKey();
				String fieldValue = work.getValue();
				_log.error("fieldName " + fieldName + " fieldValue " + fieldValue);
				if ((fieldName != null) && (!fieldName.equals(""))) {
					String nodeXQuery = "//other_details/" + categoryName + "/" + categoryDetails + "[@id='" + instance1 + "']" + "/" + fieldName;
					manipulator.setNodeValue(fieldValue, nodeXQuery);
				}
			}

			profileUser.setUserInfo(manipulator.toString(null));
			SocialProfileLocalServiceUtil.updateSocialProfile(profileUser);

		} catch (Exception e) {
			_log.error("Error on addOrUpdateDynamicSection: " + e.getMessage());
		}
	}

	public String saveProfileInfo(String fieldName, String value,
			SocialProfile profileUser, User user, long scopeGroupId) {
		com.liferay.portal.kernel.json.JSONObject json = JSONFactoryUtil.createJSONObject();

		try {
			String resultXML = SocialProfileLocalServiceUtil
					.updateSingleNodeField(profileUser.getUserInfo(),
							fieldName, value);
			profileUser.setUserInfo(resultXML);
			String assetTags[] = null;

			if (fieldName.equalsIgnoreCase("area_of_expertise")) {
				assetTags = getAssetTags(value);
				SocialProfileLocalServiceUtil.updateSocialProfileAndTags(
						profileUser, assetTags, scopeGroupId);
				SocialProfileLocalServiceUtil.addOrUpdateSocialProfile(
						profileUser, user, false, scopeGroupId);
			} else {

				if (fieldName.equalsIgnoreCase("location")) {
					profileUser.setLocation(value);
				} else if (fieldName.equalsIgnoreCase("title")) {
					profileUser.setTitle(value);
					user.setJobTitle(value);
				} else if (fieldName.equalsIgnoreCase("about")) {
					profileUser.setAbout(value);
				} else if (fieldName.equalsIgnoreCase("interest")) {
					profileUser.setInterest(value);
				} else if (fieldName.equalsIgnoreCase("honors")) {
					profileUser.setHonors(value);
				} else if (fieldName.equalsIgnoreCase("group_association")) {
					profileUser.setGroupAssociation(value);
				} else if (fieldName.equalsIgnoreCase("about")) {
					profileUser.setAbout(value);
				} else if (fieldName.equalsIgnoreCase("screen_name")) {
					if (!user.getScreenName().equals(value)) {
						SocialProfileLocalServiceUtil.updateUserScreenName(
								user.getUserId(), value);
						user.setScreenName(value);
					}
				} else if (fieldName.equalsIgnoreCase("skills_qualification")) {
					profileUser.setSkillsQualification(value);
				} else if (fieldName.equalsIgnoreCase("training_education")) {
					profileUser.setTrainingEducation(value);
				} else if (fieldName.equalsIgnoreCase("user_status")) {
					user.setGreeting(value);
				} else if (fieldName.equalsIgnoreCase("first_name")) {
					user.setFirstName(value);
				} else if (fieldName.equalsIgnoreCase("last_name")) {
					user.setLastName(value);
				} else if (fieldName.equalsIgnoreCase("gender")) {
					SocialProfileLocalServiceUtil.updateGender(user, value);

				} else if (fieldName.equalsIgnoreCase("date_of_birth")) {
					DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
					Date bday = (Date) formatter.parse(value);
					SocialProfileLocalServiceUtil.updateBirthday(user, bday);
				}
				_log.error("Updating UserProfile");
				SocialProfileLocalServiceUtil.addOrUpdateSocialProfile(
						profileUser, user, false, scopeGroupId);
				SocialProfileLocalServiceUtil.updateUser(user);
			}
			json.put("status", "200");
			json.put("fieldValue", value);
		} catch (DuplicateUserScreenNameException e) {
			_log.error("DuplicateUserScreenNameException ");
			json.put("status", "404");
			json.put("message", "Screen name is already in use.");
		} catch (UserScreenNameException e) {
			_log.error("UserScreenNameException: " + e.getMessage());
			json.put("status", "404");
			json.put("message", "Invalid screen name.");
		} catch (SystemException e) {
			_log.error("Unable to save Social Profile Personal Info: "
					+ e.getMessage());
			json.put("status", "404");
		} catch (Exception e) {
			_log.error("Unable to save Social Profile Personal Info: "
					+ e.getMessage());
			json.put("status", "404");
		}
		return json.toString();
	}
	
	public String[] getAssetTags(String expertise) {
		String[] assetTags = null;
		String aTags = expertise;
		String[] tagsArr = aTags.trim().split(StringPool.COMMA);
		if (aTags != null && aTags != StringPool.BLANK)
			assetTags = new String[tagsArr.length];
		else
			return null;
		for (int i = 0; i < tagsArr.length; i++) {
			if (tagsArr[i].length() > 1) {
				assetTags[i] = tagsArr[i].trim();
			}
		}
		return assetTags;
	}
	
	/**
	 * Applicable for single instance sections like basic info, personal info , contact info etc..
	 * 
	 * @param userId
	 * @param formName
	 * @param fieldName
	 * @return
	 */
	public String getFormFieldValue(long userId, String formName,
			String fieldName) {
		String fieldValue = StringPool.BLANK;
		try {

			SocialProfile profileUser = SocialProfileLocalServiceUtil
					.getSocialProfile(userId);
			String userInfo = profileUser.getUserInfo();
			XMLManipulator manipulator = new XMLManipulator(userInfo);
			
			Node node = manipulator.selectNode("//" + formName + "/"
					+ fieldName);

			fieldValue = node.getTextContent();
		} catch (Exception e) {
			_log.error(e);
		}
		return fieldValue;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUsersList(long companyId, int start, int end) throws SystemException {

		List<User> list;

		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(User.class);
			Long userId = Long.valueOf(UserLocalServiceUtil.getDefaultUserId(companyId));
			Criterion defaultUser = RestrictionsFactoryUtil.eq("userId", userId);
			Criterion users = RestrictionsFactoryUtil.not(defaultUser);
			dynamicQuery.add(users);
			list = UserLocalServiceUtil.dynamicQuery(dynamicQuery, start, end);
		} catch (PortalException e) {
			_log.error(
					String.format("Error occured while removing default user from list %s. Will return default list.",
							e.getMessage()));
			list = UserLocalServiceUtil.getCompanyUsers(companyId, start, end);
		}
		return list;
	}
	
	
	private MethodKey _getStringMethodKey1 = new MethodKey(PrefsPropsUtil.class, "getContent", long.class, String.class);

}
