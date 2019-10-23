/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.saml.resolver;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.security.ldap.PortalLDAPImporterUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.saml.metadata.MetadataManagerUtil;
import com.liferay.saml.model.SamlSpIdpConnection;
import com.liferay.saml.service.SamlSpIdpConnectionLocalServiceUtil;
import com.liferay.saml.util.SamlUtil;
import com.liferay.util.PwdGenerator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.opensaml.common.SAMLObject;
import org.opensaml.common.binding.SAMLMessageContext;
import org.opensaml.saml2.core.Assertion;
import org.opensaml.saml2.core.Attribute;
import org.opensaml.saml2.core.AttributeStatement;
import org.opensaml.saml2.core.NameID;
import org.opensaml.saml2.core.NameIDType;
import org.opensaml.saml2.core.Response;
import org.w3c.dom.Element;

/**
 * @author Mika Koivisto
 */
public class DefaultUserResolver implements UserResolver {


	public User resolveUser(
			long companyId,
			long groupId,
			Assertion assertion,
			SAMLMessageContext<Response, SAMLObject, NameID> samlMessageContext,
			ServiceContext serviceContext)
		throws Exception {
		_log.debug("resolveUser");

		User user = null;

		String subjectNameIdentifier = getSubjectNameIdentifier(
			companyId, assertion, samlMessageContext);
		_log.debug("subjectNameIdentifier = " + subjectNameIdentifier);
		SubjectNameType subjectNameIdentifierType = getSubjectNameIdentifierType(
			companyId, assertion, samlMessageContext);
		_log.debug("subjectnameIdentifierType = " + subjectNameIdentifierType);

		if (SamlUtil.isLDAPImportEnabled(companyId, groupId)) {
			user = importLdapUser(
				companyId, subjectNameIdentifier, subjectNameIdentifierType);
		}

		if (user == null) {
			try {
				return importUser(
					companyId, groupId, subjectNameIdentifier, 
					subjectNameIdentifierType, assertion, 
					samlMessageContext, serviceContext);
			} catch (Exception e) {
				_log.error("Error resolving user.", e);
				throw e;
			}
		}

		return user;
	}

	protected User addUser(
			long companyId, long groupId, 
			Map<String, String> attributesMap,
			ServiceContext serviceContext)
		throws PortalException, SystemException {
		_log.debug(String.format("Add user with screen name %s in company %s and group %s", attributesMap.get("screenName"), companyId, groupId));

		long creatorUserId = 0;
		boolean autoPassword = true;
		String password1 = PwdGenerator.getPassword();
		String password2 = password1;
		boolean autoScreenName = false;
		String screenName = verifyScreenName(companyId, attributesMap.get("screenName"), 0);
		String emailAddress = attributesMap.get("emailAddress");
		long facebookId = 0;
		String openId = StringPool.BLANK;
		Locale locale = serviceContext.getLocale();
		String firstName = attributesMap.get("firstName");
		String middleName = StringPool.BLANK;
		String lastName = attributesMap.get("lastName");
		int prefixId = 0;
		int suffixId = 0;
		boolean male = true;
		int birthdayMonth = Calendar.JANUARY;
		int birthdayDay = 1;
		int birthdayYear = 1970;
		String jobTitle = StringPool.BLANK;
		long[] groupIds = new long[] {groupId};
		long[] organizationIds = null;
		long[] roleIds = null;
		long[] userGroupIds = null;
		boolean sendEmail = false;

		
		String uuid = attributesMap.get("uuid");

		serviceContext.setUuid(uuid);

		User user = UserLocalServiceUtil.addUser(
			creatorUserId, companyId, autoPassword, password1, password2,
			autoScreenName, screenName, emailAddress, facebookId, openId,
			locale, firstName, middleName, lastName, prefixId, suffixId, male,
			birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds,
			organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);

		try {
			Group group = GroupLocalServiceUtil.getGroup(groupId);
			long[] orgIds = new long[] {group.getOrganizationId()};
			UserLocalServiceUtil.updateOrganizations(
					user.getUserId(),
					orgIds, 
					serviceContext);
		} catch (Exception e) {
			_log.error("Error updating user's organization. " + e);
		}
		UserLocalServiceUtil.updatePasswordReset(user.getUserId(), false);

		UserLocalServiceUtil.updateEmailAddressVerified(user.getUserId(), true);

		return user;
	}

	protected List<Attribute> getAttributes(
			Assertion assertion,
			SAMLMessageContext<Response, SAMLObject, NameID>
				samlMessageContext) {
		_log.debug("getAttributes");

		List<Attribute> attributes = new ArrayList<Attribute>();

		for (AttributeStatement attributeStatement :
				assertion.getAttributeStatements()) {

			attributes.addAll(attributeStatement.getAttributes());
		}

		return attributes;
	}

	protected Map<String, String> getAttributesMap(
		long companyId,
		long groupId,
		String nameId,
		List<Attribute> attributes,
		SAMLMessageContext<Response, SAMLObject, NameID> samlMessageContext) {
		_log.debug("getAttributesMap");

//		String peerEntityId = samlMessageContext.getPeerEntityId();

		Map<String, String> attributeMap = new HashMap<String, String>();

		try {
			Map<String, String> mappings =
				MetadataManagerUtil.getUserAttributeMap(companyId, groupId);


			for (Map.Entry<String, String> mapping : mappings.entrySet()) {
				String attributeName = mapping.getKey();
				String attributeFormat = mapping.getValue();
				attributeMap.put(attributeName, this.formatAttribute(attributeFormat, attributes, nameId));
			}
		}
		catch (Exception e) {
		}

		return attributeMap;
	}

	protected String getSubjectNameIdentifier(
		long companyId, Assertion assertion,
		SAMLMessageContext<Response, SAMLObject, NameID> samlMessageContext) {

		NameID nameId = samlMessageContext.getSubjectNameIdentifier();

		return nameId.getValue();
	}

	protected SubjectNameType getSubjectNameIdentifierType(
		long companyId, Assertion assertion,
		SAMLMessageContext<Response, SAMLObject, NameID> samlMessageContext) {

		NameID nameId = samlMessageContext.getSubjectNameIdentifier();

		String format = nameId.getFormat();

		if (SubjectNameType.UNSPECIFIED.isEqual(format))
			return SubjectNameType.UNSPECIFIED;
		else if (SubjectNameType.EMAIL_ADDRESS.isEqual(format))
			return SubjectNameType.EMAIL_ADDRESS;
		else if (SubjectNameType.ENTITY.isEqual(format))
			return SubjectNameType.ENTITY;
		else if (SubjectNameType.ENCRYPTED.isEqual(format))
			return SubjectNameType.ENCRYPTED;
		else if (SubjectNameType.KERBEROS.isEqual(format))
			return SubjectNameType.KERBEROS;
		else if (SubjectNameType.PERSISTENT.isEqual(format))
			return SubjectNameType.PERSISTENT;
		else if (SubjectNameType.TRANSIENT.isEqual(format))
			return SubjectNameType.TRANSIENT;
		else if (SubjectNameType.WIN_DOMAIN.isEqual(format))
			return SubjectNameType.WIN_DOMAIN;
		else if (SubjectNameType.X509.isEqual(format))
			return SubjectNameType.X509;
		else 
			return SubjectNameType.UNSPECIFIED;

	}

	protected User getUser(
			long companyId, long groupId, String subjectNameIdentifier,
			SubjectNameType subjectNameIdentifierType, Map<String, String> attributesMap)
		throws PortalException, SystemException {
		_log.debug("getUser");

		SamlSpIdpConnection idpConnection = 
				SamlSpIdpConnectionLocalServiceUtil.getSamlSpIdpConnection(companyId, groupId);

		// The subjectNameIdentifier can be either an email address or any number of other types 
		// that we do not really handle.  
		
		// If the nameIdentifier type is email
		if (SubjectNameType.EMAIL_ADDRESS == subjectNameIdentifierType) {
			_log.debug("the subject name identifier is email");
			// Should we use the nameidentifier to find the user
			if ("nameid".equalsIgnoreCase(idpConnection.getPrimaryKeyType())) {
				_log.debug("And we should use the subject name identifier to find the use by email address");
		try {

				return UserLocalServiceUtil.getUserByEmailAddress(
					companyId, subjectNameIdentifier);
			}
				catch (NoSuchUserException nsue) {
				}

				return null;
			}
		}

		// We need to find the user using an attribute.
		String attributeName = idpConnection.getPrimaryKeyAttribute();
		_log.debug(String.format("We need to find the user using the attribute '%s'.", attributeName));
		try {
			if (attributeName.equalsIgnoreCase(EMAIL_ADDRESS)) {
				
				return UserLocalServiceUtil.getUserByEmailAddress(
					companyId, 
					attributesMap.get(attributeName));
			}
			else if (attributeName.equalsIgnoreCase(SCREEN_NAME)) {

				return UserLocalServiceUtil.getUserByScreenName(
						companyId, 
						attributesMap.get(attributeName));
			}
			else if (attributeName.equalsIgnoreCase(UUID)) {

				return UserLocalServiceUtil.getUserByUuid(
						attributesMap.get(attributeName));
			}
		}
		catch (NoSuchUserException nsue) {
		}

		return null;
	}

	protected User importLdapUser(
			long companyId, String subjectNameIdentifier,
			SubjectNameType subjectNameIdentifierType)
		throws Exception {

		if (SubjectNameType.EMAIL_ADDRESS == subjectNameIdentifierType) {

			return PortalLDAPImporterUtil.importLDAPUser(
				companyId, subjectNameIdentifier, StringPool.BLANK);
		}
		else {
			return PortalLDAPImporterUtil.importLDAPUser(
				companyId, StringPool.BLANK, subjectNameIdentifier);
		}
	}

	protected User importUser(
			long companyId, long groupId, String subjectNameIdentifier,
			SubjectNameType subjectNameIdentifierType, Assertion assertion,
			SAMLMessageContext<Response, SAMLObject, NameID>
				samlMessageContext, ServiceContext serviceContext)
		throws PortalException, SystemException {
		_log.debug("importUser");

		List<Attribute> attributes = getAttributes(
			assertion, samlMessageContext);

		Map<String, String> attributesMap = getAttributesMap(
			companyId, groupId, subjectNameIdentifier,
			attributes, samlMessageContext);

		User user = getUser(
				companyId, groupId, subjectNameIdentifier, subjectNameIdentifierType, attributesMap);

		if (user != null)
			return updateUser(companyId, groupId, user, attributesMap, serviceContext);
		else
			return addUser(companyId, groupId, attributesMap, serviceContext);
	}

	protected User updateUser(
			long companyId, long groupId, 
			User user,
			Map<String, String> attributesMap,
			ServiceContext serviceContext)
		throws PortalException, SystemException {
		_log.debug(String.format("Update user with screen name %s in company %s and group %s", user.getScreenName(), companyId, groupId));

		user.setFirstName(attributesMap.get("firstName"));
		user.setLastName(attributesMap.get("lastName"));
		user.setUuid(attributesMap.get("uuid"));
		if (!user.getScreenName().equalsIgnoreCase(attributesMap.get("screenName"))) {
			user.setScreenName(verifyScreenName(companyId, attributesMap.get("screenName"), 0));
		}
		user.setEmailAddress(attributesMap.get("emailAddress"));

		UserLocalServiceUtil.updateUser(user);

//		serviceContext.setUuid(uuid);
//		User user = UserLocalServiceUtil.addUser(
//			creatorUserId, companyId, autoPassword, password1, password2,
//			autoScreenName, screenName, emailAddress, facebookId, openId,
//			locale, firstName, middleName, lastName, prefixId, suffixId, male,
//			birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds,
//			organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
//
//		UserLocalServiceUtil.updatePasswordReset(user.getUserId(), false);
//
//		UserLocalServiceUtil.updateEmailAddressVerified(user.getUserId(), true);
		
		UserLocalServiceUtil.updateGroups(
				user.getUserId(), 
				mergeIds(user.getGroupIds(), groupId), 
				serviceContext);
		
		try {
			Group group = GroupLocalServiceUtil.getGroup(groupId);
			UserLocalServiceUtil.updateOrganizations(
					user.getUserId(), 
					mergeIds(user.getOrganizationIds(), group.getOrganizationId()), 
					serviceContext);
		} catch (Exception e) {
			_log.error("Error updating user's organization. " + e);
		}

		UserLocalServiceUtil.updatePasswordReset(user.getUserId(), false);

		UserLocalServiceUtil.updateEmailAddressVerified(user.getUserId(), true);

		return user;
	}
	
	protected String verifyScreenName(long companyId, String screenName, int increment) 
			throws PortalException {
		_log.debug(String.format("verifyScreenName(%s)", screenName));
		if (increment >= 100) throw new PortalException("Unable to generate a unique screen name");
		String screenName2 = formatScreenName(screenName, increment);
		try {
			User user = UserLocalServiceUtil.fetchUserByScreenName(companyId, screenName2);
			if (user != null)
				return verifyScreenName(companyId, screenName, increment+1);
			else {
				return screenName2;
			}
		} catch (Exception e) {
			return verifyScreenName(companyId, screenName, increment+1);
		}
	}
	
	private String formatAttribute(String format, List<Attribute> attributes, String nameId) {
		String[] parts = format.split("\\+");
		StringBuffer buf = new StringBuffer();
		for (String part : parts) {
			if (part.startsWith("\"")) {
				buf.append(part.substring(1, part.length()-1));
			}
			else if (part.startsWith("'")) {
				buf.append(part.substring(1, part.length()-1));
			}
			else if (part.equalsIgnoreCase("nameid")) {
				buf.append(nameId);
			}
			else {
				String attributeValue = this.getAttributeValue(attributes, part);
				if (Validator.isNotNull(attributeValue)) {
					buf.append(attributeValue);
				}
				else {
					_log.error("There is no attribute '" + part + "' within the attributes");
				}
			}
		}
		return buf.toString().toLowerCase();
	}
	
	private String formatScreenName(String screenName, int suffix) {
		if (suffix == 0)
			return screenName;
		else 
			return screenName + StringPool.PERIOD + suffix;
	}
	
	private String getAttributeValue(
			List<Attribute> attributes, String name) {

			for (Attribute attribute : attributes) {
				if (name.equals(attribute.getName())) {
					Element element = attribute.getDOM();

					return element.getTextContent();
				}
			}

			return null;
		}
		
	private long[] mergeIds(long[] currentIds, long newId) {
		ArrayList<Long> ids = new ArrayList<Long>();
		for (long id : currentIds) 
			ids.add(new Long(id));
		if (!ids.contains(new Long(newId)))
			ids.add(new Long(newId));
		long[] allIds = new long[ids.size()];
		for (int index = 0; index < ids.size(); index++)
			allIds[index] = ids.get(index);
		return allIds;
	}

//	private static final String _SUBJECT_NAME_TYPE_EMAIL_ADDRESS		= "emailAddress";
//	private static final String _SUBJECT_NAME_TYPE_ENTITY				= "entity";
//	private static final String _SUBJECT_NAME_TYPE_SCREENNAME 			= "screenName";
//	private static final String _SUBJECT_NAME_TYPE_UUID 				= "uuid";
//	private static final String _SUBJECT_NAME_TYPE_UNSPECIFIED			= "unspecified";
//	
//	private static final String _SUBJECT_NAME_TYPE_ENCRYPTED			= "encrypted";
//	private static final String _SUBJECT_NAME_TYPE_KERBEROS;
//	private static final String _SUBJECT_NAME_TYPE_PERSISTENT;
//	private static final String _SUBJECT_NAME_TYPE_TRANSIENT;
//	private static final String _SUBJECT_NAME_TYPE_WIN_DOMAIN_QUALIFIED;
//	private static final String _SUBJECT_NAME_TYPE_X509_SUBJECT;
	
	private enum SubjectNameType {
		EMAIL_ADDRESS(NameID.EMAIL, "emailAddress"),
		ENTITY(NameID.ENTITY, "entity"),
		ENCRYPTED(NameID.ENCRYPTED, "encrypted"),
		KERBEROS(NameID.KERBEROS, "kerberos"),
		PERSISTENT(NameID.PERSISTENT, "persistent"),
		TRANSIENT(NameID.TRANSIENT, "transient"),
		WIN_DOMAIN(NameID.WIN_DOMAIN_QUALIFIED, "winDomain"),
		X509(NameID.X509_SUBJECT, "x509Subject"),
		UNSPECIFIED(NameID.UNSPECIFIED, "unspecified");
		
		private SubjectNameType(String id, String value) {
			this.id = id;
			this.value = value;
		}
		
		public String getValue() {
			return this.value;
		}
		
		public boolean isEqual(String nameIdType) {
			return this.id.equals(nameIdType);
		}
		
		private String id;
		private String value;
	}
	
	private final static String EMAIL_ADDRESS	= "emailAddress";
	private final static String SCREEN_NAME		= "screenName";
	private final static String UUID			= "uuid";

	private final static Log _log = LogFactoryUtil.getLog(DefaultUserResolver.class);

}