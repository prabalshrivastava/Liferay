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

package com.liferay.saml.admin.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropertiesParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.saml.CertificateKeyPasswordException;
import com.liferay.saml.credential.KeyStoreManagerUtil;
import com.liferay.saml.metadata.MetadataManagerUtil;
import com.liferay.saml.model.SamlIdpSpConnection;
import com.liferay.saml.service.SamlIdpSpConnectionLocalServiceUtil;
import com.liferay.saml.service.SamlSpIdpConnectionLocalServiceUtil;
import com.liferay.saml.util.CertificateUtil;
import com.liferay.saml.util.PortletPropsKeys;
import com.liferay.saml.util.SamlConfigUtil;
import com.liferay.saml.util.SamlUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.InputStream;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.xml.security.utils.Base64;
import org.bouncycastle.asn1.x500.X500Name;
import org.opensaml.common.xml.SAMLConstants;
import org.opensaml.saml2.metadata.IDPSSODescriptor;
import org.opensaml.saml2.metadata.provider.MetadataProvider;
import org.opensaml.xml.security.x509.X509Credential;

/**
 * @author Mika Koivisto
 */
public class AdminPortlet extends MVCPortlet {

	public void deleteSamlIdpSpConnection(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long samlIdpSpConnectionId = ParamUtil.getLong(
			actionRequest, "samlIdpSpConnectionId");

		SamlIdpSpConnectionLocalServiceUtil.deleteSamlIdpSpConnection(
			samlIdpSpConnectionId);
	}

	public void downloadCertificate(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {
		
		long companyId = PortalUtil.getCompanyId(resourceRequest);
		long groupId = PortalUtil.getScopeGroupId(resourceRequest);

		X509Credential x509Credential =
			(X509Credential)MetadataManagerUtil.getSigningCredential(companyId, groupId);

		if (x509Credential == null) {
			return;
		}

		X509Certificate x509Certificate = x509Credential.getEntityCertificate();

		StringBundler sb = new StringBundler(3);

		sb.append("-----BEGIN CERTIFICATE-----\r\n");
		sb.append(Base64.encode(x509Certificate.getEncoded(), 76));
		sb.append("\r\n-----END CERTIFICATE-----");

		String content = sb.toString();

		PortletResponseUtil.sendFile(
			resourceRequest, resourceResponse,
			MetadataManagerUtil.getLocalEntityId(companyId, groupId) + ".pem", content.getBytes(),
			ContentTypes.TEXT_PLAIN);
	}


	public void serveResource(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		try {
			downloadCertificate(resourceRequest, resourceResponse);
		}
		catch (Exception e) {
			_log.error("Unable to send certificate", e);
		}
	}

	public void updateCertificate(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long companyId = PortalUtil.getCompanyId(actionRequest);
		long groupId = PortalUtil.getScopeGroupId(actionRequest);

		UnicodeProperties properties = getProperties(actionRequest);

//		String entityId = MetadataManagerUtil.getLocalEntityId(companyId, groupId);
		String entityId = SamlUtil.getKeystoreCredential(companyId, groupId);

		String certificateKeyPassword = properties.getProperty(PortletPropsKeys.SAML_KEYSTORE_PASSWORD);

		if (Validator.isNull(certificateKeyPassword)) {
			throw new CertificateKeyPasswordException();
		}

		String commonName = properties.getProperty(PortletPropsKeys.CERTIFICATE_COMMON_NAME);
		String organization = properties.getProperty(PortletPropsKeys.CERTIFICATE_ORGANIZATION);
		String organizationUnit = properties.getProperty(PortletPropsKeys.CERTIFICATE_ORGANIZATION_UNIT);
		String locality = properties.getProperty(PortletPropsKeys.CERTIFICATE_LOCALITY);
		String state = properties.getProperty(PortletPropsKeys.CERTIFICATE_STATE);
		String country = properties.getProperty(PortletPropsKeys.CERTIFICATE_COUNTRY);

		X500Name subjectX500Name = CertificateUtil.createX500Name(
			commonName, organization, organizationUnit, locality, state,
			country);

		String keyAlgorithm = properties.getProperty(PortletPropsKeys.CERTIFICATE_ALGORITHM);
		int keyLength = 0;
		try {
			keyLength = Integer.parseInt(properties.getProperty(PortletPropsKeys.CERTIFICATE_KEY_LENGTH));
		} catch (Exception e) {
			_log.warn(e.getClass().getName() + ": " + e.getMessage());
		}

		KeyPair keyPair = CertificateUtil.generateKeyPair(
			keyAlgorithm, keyLength);

		Date startDate = new Date(System.currentTimeMillis());

		int validityDays = 0;
		try {
			validityDays = Integer.parseInt(properties.getProperty(PortletPropsKeys.CERTIFICATE_VALIDITY_DAYS));
		} catch (Exception e) {
			_log.warn(e.getClass().getName() + ": " + e.getMessage());
		}

		Date endDate = new Date(startDate.getTime() + validityDays * Time.DAY);

		X509Certificate x509Certificate = CertificateUtil.generateCertificate(
			keyPair, subjectX500Name, subjectX500Name, startDate, endDate,
			"SHA1with" + keyAlgorithm);

		KeyStore.PrivateKeyEntry privateKeyEntry = new KeyStore.PrivateKeyEntry(
			keyPair.getPrivate(), new Certificate[] {x509Certificate});

		KeyStore keyStore = KeyStoreManagerUtil.getKeyStore();

		keyStore.setEntry(
			entityId, privateKeyEntry,
			new KeyStore.PasswordProtection(
				certificateKeyPassword.toCharArray()));

		KeyStoreManagerUtil.saveKeyStore(keyStore);

		updateProperties(actionRequest, properties);
	}

	public void updateGeneral(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long companyId = PortalUtil.getCompanyId(actionRequest);
		long groupId = PortalUtil.getScopeGroupId(actionRequest);
		
		UnicodeProperties properties = getProperties(actionRequest);

		boolean enabled = GetterUtil.getBoolean(
			properties.getProperty(PortletPropsKeys.SAML_ENABLED));
		
		boolean debugEnabled = GetterUtil.getBoolean(
			properties.getProperty(PortletPropsKeys.SAML_DEBUG_ENABLED));
		
		// Add the property back in as 'false' is usually just the absence of the value and
		// thus does not get saved into the configuration.
		properties.setProperty(PortletPropsKeys.SAML_ENABLED, Boolean.toString(enabled));
		properties.setProperty(PortletPropsKeys.SAML_DEBUG_ENABLED, Boolean.toString(debugEnabled));

		if (enabled && (MetadataManagerUtil.getSigningCredential(companyId, groupId) == null)) {
			SessionErrors.add(actionRequest, "certificateInvalid");

			return;
		}

		String samlRole = properties.getProperty(
			PortletPropsKeys.SAML_ROLE, StringPool.BLANK);

		if (enabled && samlRole.equals("sp")) {
			String defaultIdpEntityId =
				MetadataManagerUtil.getDefaultIdpEntityId(companyId, groupId);

			MetadataProvider metadataProvider =
				MetadataManagerUtil.getMetadataProvider(companyId, groupId);

			if (Validator.isNull(defaultIdpEntityId) ||
				(metadataProvider.getRole(
					defaultIdpEntityId, IDPSSODescriptor.DEFAULT_ELEMENT_NAME,
					SAMLConstants.SAML20P_NS) == null)) {

				SessionErrors.add(actionRequest, "identityProviderInvalid");

				return;
			}
		}

		String currentEntityId = MetadataManagerUtil.getLocalEntityId(companyId, groupId);

		String newEntityId = properties.getProperty(
			PortletPropsKeys.SAML_ENTITY_ID);

		if (Validator.isNotNull(currentEntityId) &&
			!currentEntityId.equalsIgnoreCase(newEntityId)) {

			KeyStore keyStore = KeyStoreManagerUtil.getKeyStore();

			keyStore.deleteEntry(currentEntityId);

			KeyStoreManagerUtil.saveKeyStore(keyStore);
		}

		updateProperties(actionRequest, properties);
	}

	public void updateGlobal(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		UnicodeProperties properties = getProperties(actionRequest);

		updateProperties(actionRequest, properties);
	}

	public void updateIdentityProvider(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		UnicodeProperties properties = getProperties(actionRequest);

		String nameIdentifierAttributeType = ParamUtil.getString(
			actionRequest, "nameIdentifierAttributeType");

		if (Validator.isNotNull(nameIdentifierAttributeType)) {
			String nameIdentifierAttribute = properties.getProperty(
				PortletPropsKeys.SAML_IDP_METADATA_NAME_ID_ATTRIBUTE);

			nameIdentifierAttribute =
				nameIdentifierAttributeType + ":" + nameIdentifierAttribute;

			properties.setProperty(
				PortletPropsKeys.SAML_IDP_METADATA_NAME_ID_ATTRIBUTE,
				nameIdentifierAttribute);
		}

		updateProperties(actionRequest, properties);
	}

	public void updateIdentityProviderConnection(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		UploadPortletRequest uploadPortletRequest =
			PortalUtil.getUploadPortletRequest(actionRequest);

		long samlSpIdpConnectionId = ParamUtil.getLong(
			uploadPortletRequest, "samlSpIdpConnectionId");

		String samlIdpEntityId = ParamUtil.getString(
			uploadPortletRequest, "samlIdpEntityId");
		boolean assertionSignatureRequired = ParamUtil.getBoolean(
			uploadPortletRequest, "assertionSignatureRequired");
		long clockSkew = ParamUtil.getLong(uploadPortletRequest, "clockSkew");
		boolean enabled = true;
		boolean ldapImportEnabled = ParamUtil.getBoolean(
			uploadPortletRequest, "ldapImportEnabled");
		String metadataUrl = ParamUtil.getString(
			uploadPortletRequest, "metadataUrl");
		InputStream metadataXmlInputStream =
			uploadPortletRequest.getFileAsStream("metadataXml");
		String name = ParamUtil.getString(uploadPortletRequest, "name");
		String nameIdFormat = ParamUtil.getString(
			uploadPortletRequest, "nameIdFormat");
		boolean signAuthnRequest = ParamUtil.getBoolean(
			uploadPortletRequest, "signAuthnRequest");
		String keepAliveUrl = ParamUtil.getString(
			uploadPortletRequest, "keepAliveUrl");
		String primaryKeyType = ParamUtil.getString(
				uploadPortletRequest, "matchType");
		String primaryKeyAttribute = ParamUtil.getString(
				uploadPortletRequest, "primaryKeyAttribute");
		
		Map<String, String> userAttributeMap = SamlUtil.getEmptyAttributesMap();
		for (final String attribute : userAttributeMap.keySet()) {
			String attributeValue = ParamUtil.getString(
					uploadPortletRequest,
					"userAttributeMapping-" + attribute);
			userAttributeMap.put(attribute, attributeValue);
		}

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			actionRequest);
		serviceContext.setCompanyId(PortalUtil.getCompanyId(actionRequest));
		serviceContext.setScopeGroupId(PortalUtil.getScopeGroupId(actionRequest));
		serviceContext.setUserId(PortalUtil.getUserId(actionRequest));

		if (samlSpIdpConnectionId <= 0) {
			if (_log.isDebugEnabled()) {
				_log.debug(String.format("Create IdP connection values with entity ID = %s, metadataURL = %s", 
						samlIdpEntityId, metadataUrl));
			}
			SamlSpIdpConnectionLocalServiceUtil.addSamlSpIdpConnection(
				samlIdpEntityId, assertionSignatureRequired, clockSkew, enabled,
				ldapImportEnabled, metadataUrl, metadataXmlInputStream, name,
				nameIdFormat, signAuthnRequest, primaryKeyType, primaryKeyAttribute, 
				userAttributeMap, keepAliveUrl, serviceContext);
		}
		else {
			if (_log.isDebugEnabled()) {
				_log.debug(String.format("Update IdP connection values with entity ID = %s, metadataURL = %s", 
						samlIdpEntityId, metadataUrl));
			}
			SamlSpIdpConnectionLocalServiceUtil.updateSamlSpIdpConnection(
				samlSpIdpConnectionId, samlIdpEntityId,
				assertionSignatureRequired, clockSkew, enabled,
				ldapImportEnabled, metadataUrl, metadataXmlInputStream, name,
				nameIdFormat, signAuthnRequest, primaryKeyType, primaryKeyAttribute, 
				userAttributeMap, keepAliveUrl, serviceContext);
		}

		UnicodeProperties properties = new UnicodeProperties();

		properties.setProperty(
			PortletPropsKeys.SAML_SP_DEFAULT_IDP_ENTITY_ID, samlIdpEntityId);

		updateProperties(actionRequest, properties);
	}

	public void updateServiceProvider(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		UnicodeProperties properties = getProperties(actionRequest);
		
		// Verify that the boolean values are set.  Typically, they only get
		// set when true.
		properties.setProperty(
				PortletPropsKeys.SAML_SP_ASSERTION_SIGNATURE_REQUIRED, 
				properties.getProperty(
						PortletPropsKeys.SAML_SP_ASSERTION_SIGNATURE_REQUIRED, "false"));
		properties.setProperty(
				PortletPropsKeys.SAML_SP_LDAP_IMPORT_ENABLED, 
				properties.getProperty(
						PortletPropsKeys.SAML_SP_LDAP_IMPORT_ENABLED, "false"));
		properties.setProperty(
				PortletPropsKeys.SAML_SP_SIGN_AUTHN_REQUEST, 
				properties.getProperty(
						PortletPropsKeys.SAML_SP_SIGN_AUTHN_REQUEST, "false"));
		properties.setProperty(
				PortletPropsKeys.SAML_SIGN_METADATA, 
				properties.getProperty(
						PortletPropsKeys.SAML_SIGN_METADATA, "false"));
		properties.setProperty(
				PortletPropsKeys.SAML_SSL_REQUIRED, 
				properties.getProperty(
						PortletPropsKeys.SAML_SSL_REQUIRED, "false"));
		properties.setProperty(
				PortletPropsKeys.SAML_DEFAULT_LANDING_PAGE,
				properties.getProperty(
						PortletPropsKeys.SAML_DEFAULT_LANDING_PAGE, ""));
		properties.setProperty(
				PortletPropsKeys.SAML_DO_NOT_USE_SAML_FOR_LOGOUT,
				properties.getProperty(
						PortletPropsKeys.SAML_DO_NOT_USE_SAML_FOR_LOGOUT, "false"));

		updateProperties(actionRequest, properties);
	}

	public void updateServiceProviderConnection(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		UploadPortletRequest uploadPortletRequest =
			PortalUtil.getUploadPortletRequest(actionRequest);

		long samlIdpSpConnectionId = ParamUtil.getLong(
			uploadPortletRequest, "samlIdpSpConnectionId");

		String samlSpEntityId = ParamUtil.getString(
			uploadPortletRequest, "samlSpEntityId");
		int assertionLifetime = ParamUtil.getInteger(
			uploadPortletRequest, "assertionLifetime");
		String attributeNames = ParamUtil.getString(
			uploadPortletRequest, "attributeNames");
		boolean attributesEnabled = ParamUtil.getBoolean(
			uploadPortletRequest, "attributesEnabled");
		boolean attributesNamespaceEnabled = ParamUtil.getBoolean(
			uploadPortletRequest, "attributesNamespaceEnabled");
		boolean enabled = ParamUtil.getBoolean(uploadPortletRequest, "enabled");
		String metadataUrl = ParamUtil.getString(
			uploadPortletRequest, "metadataUrl");
		InputStream metadataXmlInputStream =
			uploadPortletRequest.getFileAsStream("metadataXml");
		String name = ParamUtil.getString(uploadPortletRequest, "name");
		String nameIdAttribute = ParamUtil.getString(
			uploadPortletRequest, "nameIdAttribute");
		String nameIdFormat = ParamUtil.getString(
			uploadPortletRequest, "nameIdFormat");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				actionRequest);
		serviceContext.setCompanyId(PortalUtil.getCompanyId(actionRequest));
		serviceContext.setScopeGroupId(PortalUtil.getScopeGroupId(actionRequest));
		serviceContext.setUserId(PortalUtil.getUserId(actionRequest));

		if (samlIdpSpConnectionId <= 0) {
			SamlIdpSpConnectionLocalServiceUtil.addSamlIdpSpConnection(
				samlSpEntityId, assertionLifetime, attributeNames,
				attributesEnabled, attributesNamespaceEnabled, enabled,
				metadataUrl, metadataXmlInputStream, name, nameIdAttribute,
				nameIdFormat, serviceContext);
		}
		else {
			SamlIdpSpConnectionLocalServiceUtil.updateSamlIdpSpConnection(
				samlIdpSpConnectionId, samlSpEntityId, assertionLifetime,
				attributeNames, attributesEnabled, attributesNamespaceEnabled,
				enabled, metadataUrl, metadataXmlInputStream, name,
				nameIdAttribute, nameIdFormat, serviceContext);
		}

		String redirect = ParamUtil.getString(uploadPortletRequest, "redirect");

		if (Validator.isNotNull(redirect)) {
			redirect = PortalUtil.escapeRedirect(redirect);

			actionRequest.setAttribute(WebKeys.REDIRECT, redirect);
		}

		sendRedirect(actionRequest, actionResponse);
	}


	protected void checkPermissions(PortletRequest portletRequest)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		PermissionChecker permissionChecker =
			themeDisplay.getPermissionChecker();

		if (!permissionChecker.isCompanyAdmin()) {
			throw new PrincipalException();
		}
	}

	protected UnicodeProperties getProperties(PortletRequest portletRequest) {
		return PropertiesParamUtil.getProperties(portletRequest, "settings--");
	}


	protected boolean isSessionErrorException(Throwable cause) {
		return true;
	}

	protected void updateProperties(
			PortletRequest portletRequest, UnicodeProperties properties)
		throws Exception {
		
//		long userId = PortalUtil.getUserId(portletRequest);
		long companyId = PortalUtil.getCompanyId(portletRequest);
		long groupId = PortalUtil.getScopeGroupId(portletRequest);
		long userId = SamlUtil._getDefaultUserId(companyId);
		
		_log.trace("Update properties for group " + groupId);
		
		for (Entry<String, String> set : properties.entrySet()) {
			_log.info(String.format("Set %s to %s", set.getKey(), set.getValue()));
			SamlConfigUtil.setString(userId, companyId, groupId, set.getKey(), set.getValue());
		}

//		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
//			WebKeys.THEME_DISPLAY);
//
//		CompanyServiceUtil.updatePreferences(
//			themeDisplay.getCompanyId(), properties);
	}

	private static Log _log = LogFactoryUtil.getLog(AdminPortlet.class);

}