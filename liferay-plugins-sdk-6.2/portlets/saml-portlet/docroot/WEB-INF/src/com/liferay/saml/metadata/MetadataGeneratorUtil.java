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

package com.liferay.saml.metadata;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.saml.CredentialException;
import com.liferay.saml.EntityIdException;
import com.liferay.saml.util.OpenSamlUtil;
import com.liferay.saml.util.SamlUtil;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.opensaml.common.xml.SAMLConstants;
import org.opensaml.saml2.metadata.AssertionConsumerService;
import org.opensaml.saml2.metadata.EntityDescriptor;
import org.opensaml.saml2.metadata.IDPSSODescriptor;
import org.opensaml.saml2.metadata.KeyDescriptor;
import org.opensaml.saml2.metadata.RoleDescriptor;
import org.opensaml.saml2.metadata.SPSSODescriptor;
import org.opensaml.saml2.metadata.SingleLogoutService;
import org.opensaml.saml2.metadata.SingleSignOnService;
import org.opensaml.xml.security.credential.Credential;
import org.opensaml.xml.security.credential.UsageType;

/**
 * @author Mika Koivisto
 */
public class MetadataGeneratorUtil {

	public static EntityDescriptor buildIdpEntityDescriptor(
			HttpServletRequest request, String entityId,
			boolean wantAuthnRequestSigned, boolean signMetadata,
			boolean requireSSL, Credential credential)
		throws Exception {

		if (Validator.isNull(entityId)) {
			throw new EntityIdException("Entity ID is required");
		}

		if (credential == null) {
			throw new CredentialException("Credential is required");
		}

		EntityDescriptor entityDescriptor =
			OpenSamlUtil.buildEntityDescriptor();

		entityDescriptor.setEntityID(entityId);

		List<RoleDescriptor> roleDescriptors =
			entityDescriptor.getRoleDescriptors();

		RoleDescriptor roleDescriptor = buildIdpSsoDescriptor(
			request, entityId, wantAuthnRequestSigned, requireSSL, credential);

		roleDescriptors.add(roleDescriptor);

		if (signMetadata) {
			OpenSamlUtil.signObject(entityDescriptor, credential);
		}

		return entityDescriptor;
	}

	public static IDPSSODescriptor buildIdpSsoDescriptor(
			HttpServletRequest request, String entityId,
			boolean wantAuthnRequestSigned, boolean requireSSL,
			Credential credential)
		throws Exception {

		long groupId = SamlUtil.getGroupId(request);
		
		IDPSSODescriptor idpSsoDescriptor =
			OpenSamlUtil.buildIdpSsoDescriptor();

		idpSsoDescriptor.addSupportedProtocol(SAMLConstants.SAML20P_NS);

		idpSsoDescriptor.setID(entityId);
		idpSsoDescriptor.setWantAuthnRequestsSigned(wantAuthnRequestSigned);

		List<KeyDescriptor> keyDescriptors =
			idpSsoDescriptor.getKeyDescriptors();

		KeyDescriptor keyDescriptor = OpenSamlUtil.buildKeyDescriptor(
			UsageType.SIGNING, OpenSamlUtil.buildKeyInfo(credential));

		keyDescriptors.add(keyDescriptor);

		List<SingleSignOnService> singleSignOnServices =
			idpSsoDescriptor.getSingleSignOnServices();

		String portalURL = PortalUtil.getPortalURL(request, requireSSL);

		SingleSignOnService singleSignOnService =
			OpenSamlUtil.buildSingleSignOnService(
				SAMLConstants.SAML2_REDIRECT_BINDING_URI,
				portalURL.concat(SamlUtil.getSingleSignOnLink()));

		singleSignOnServices.add(singleSignOnService);

		singleSignOnService =
			OpenSamlUtil.buildSingleSignOnService(
				SAMLConstants.SAML2_POST_BINDING_URI,
				portalURL.concat(SamlUtil.getSingleSignOnLink()));

		singleSignOnServices.add(singleSignOnService);

		List<SingleLogoutService> singleLogoutServices =
			idpSsoDescriptor.getSingleLogoutServices();

		SingleLogoutService singleLogoutService =
			OpenSamlUtil.buildSingleLogoutService(
				SAMLConstants.SAML2_REDIRECT_BINDING_URI,
				portalURL.concat(SamlUtil.getSingleLogoutServiceRedirectLink(groupId)));

		singleLogoutServices.add(singleLogoutService);

		return idpSsoDescriptor;
	}

	public static EntityDescriptor buildSpEntityDescriptor(
			HttpServletRequest request, String entityId, long groupId,
			boolean signAuthnRequests, boolean signMetadata, boolean requireSSL,
			boolean wantAssertionsSigned, Credential credential)
		throws Exception {

		EntityDescriptor entityDescriptor =
			OpenSamlUtil.buildEntityDescriptor();

		entityDescriptor.setEntityID(entityId);

		List<RoleDescriptor> roleDescriptors =
			entityDescriptor.getRoleDescriptors();

		RoleDescriptor roleDescriptor = buildSpSsoDescriptor(
			request, entityId, groupId, signAuthnRequests, requireSSL,
			wantAssertionsSigned, credential);

		roleDescriptors.add(roleDescriptor);

		if (signMetadata) {
			OpenSamlUtil.signObject(entityDescriptor, credential);
		}

		return entityDescriptor;
	}

	public static SPSSODescriptor buildSpSsoDescriptor(
			HttpServletRequest request, String entityId,
			long groupId, boolean signAuthnRequests, 
			boolean requireSSL, boolean wantAssertionsSigned, 
			Credential credential)
		throws Exception {

		SPSSODescriptor spSsoDescriptor = OpenSamlUtil.buildSpSsoDescriptor();

		spSsoDescriptor.addSupportedProtocol(SAMLConstants.SAML20P_NS);

		spSsoDescriptor.setAuthnRequestsSigned(signAuthnRequests);
		spSsoDescriptor.setID(entityId);
		spSsoDescriptor.setWantAssertionsSigned(wantAssertionsSigned);

		List<AssertionConsumerService> assertionConsumerServices =
			spSsoDescriptor.getAssertionConsumerServices();

		String portalURL = PortalUtil.getPortalURL(request, requireSSL);

		AssertionConsumerService assertionConsumerService =
			OpenSamlUtil.buildAssertionConsumerService(
				SAMLConstants.SAML2_POST_BINDING_URI, 1, true,
				portalURL.concat(SamlUtil.getAssertionConsumerServiceLink(groupId)));

		assertionConsumerServices.add(assertionConsumerService);

		List<KeyDescriptor> keyDescriptors =
			spSsoDescriptor.getKeyDescriptors();

		KeyDescriptor keyDescriptor = OpenSamlUtil.buildKeyDescriptor(
			UsageType.SIGNING, OpenSamlUtil.buildKeyInfo(credential));

		keyDescriptors.add(keyDescriptor);

		List<SingleLogoutService> singleLogoutServices =
			spSsoDescriptor.getSingleLogoutServices();

		SingleLogoutService redirectSingleLogoutService =
			OpenSamlUtil.buildSingleLogoutService(
				SAMLConstants.SAML2_REDIRECT_BINDING_URI,
				portalURL.concat(SamlUtil.getSingleLogoutServiceRedirectLink(groupId)));

		singleLogoutServices.add(redirectSingleLogoutService);

		SingleLogoutService soapSingleLogoutService =
			OpenSamlUtil.buildSingleLogoutService(
				SAMLConstants.SAML2_SOAP11_BINDING_URI,
				portalURL.concat(SamlUtil.getSingleLogoutServiceSoapLink(groupId)));

		singleLogoutServices.add(soapSingleLogoutService);

		return spSsoDescriptor;
	}

}