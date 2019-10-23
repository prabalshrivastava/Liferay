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

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.opensaml.saml2.metadata.EntityDescriptor;
import org.opensaml.saml2.metadata.provider.MetadataProvider;
import org.opensaml.saml2.metadata.provider.MetadataProviderException;
import org.opensaml.ws.security.SecurityPolicyResolver;
import org.opensaml.xml.security.SecurityException;
import org.opensaml.xml.security.credential.Credential;
import org.opensaml.xml.signature.SignatureTrustEngine;

/**
 * @author Mika Koivisto
 */
public class MetadataManagerUtil {

	public static int getAssertionLifetime(long companyId, String entityId) {
		return getMetadataManager().getAssertionLifetime(companyId, entityId);
	}

	public static String[] getAttributeNames(long companyId, String entityId) {
		return getMetadataManager().getAttributeNames(companyId, entityId);
	}

	public static long getClockSkew(long companyId, long groupId) {
		return getMetadataManager().getClockSkew(companyId, groupId);
	}

	public static String getDefaultIdpEntityId(long companyId, long groupId) {
		return getMetadataManager().getDefaultIdpEntityId(companyId, groupId);
	}

	public static EntityDescriptor getEntityDescriptor(
			HttpServletRequest request)
		throws MetadataProviderException {

		return getMetadataManager().getEntityDescriptor(request);
	}

	public static String getLocalEntityId(long companyId, long groupId) {
		return getMetadataManager().getLocalEntityId(companyId, groupId);
	}

	public static MetadataManager getMetadataManager() {
		return _metadataManager;
	}

	public static MetadataProvider getMetadataProvider(long companyId, long groupId)
		throws MetadataProviderException {

		return getMetadataManager().getMetadataProvider(companyId, groupId);
	}

	public static String getNameIdAttribute(long companyId, String entityId) {
		return getMetadataManager().getNameIdAttribute(companyId, entityId);
	}

	public static String getNameIdFormat(long companyId, long groupId) {
		return getMetadataManager().getNameIdFormat(companyId, groupId);
	}

	public static String getNameIdFormat(long companyId, long groupId, String entityId) {
		return getMetadataManager().getNameIdFormat(companyId, groupId, entityId);
	}

	public static SecurityPolicyResolver getSecurityPolicyResolver(
			long companyId, long groupId, 
			String communicationProfileId, boolean requireSignature)
		throws MetadataProviderException {

		return getMetadataManager().getSecurityPolicyResolver(
				companyId, groupId,
				communicationProfileId, requireSignature);
	}

	public static String getSessionKeepAliveURL(long companyId, long groupId, String entityId) {
		return getMetadataManager().getSessionKeepAliveURL(companyId, groupId, entityId);
	}

	public static long getSessionMaximumAge(long companyId, long groupId) {
		return getMetadataManager().getSessionMaximumAge(companyId, groupId);
	}

	public static long getSessionTimeout(long companyId, long groupId) {
		return getMetadataManager().getSessionTimeout(companyId, groupId);
	}

	public static SignatureTrustEngine getSignatureTrustEngine(long companyId, long groupId)
		throws MetadataProviderException {

		return getMetadataManager().getSignatureTrustEngine(companyId, groupId);
	}

	public static Credential getSigningCredential(long companyId, long groupId) throws SecurityException {
		return getMetadataManager().getSigningCredential(companyId, groupId);
	}

	public static Map<String, String> getUserAttributeMap(long companyId, long groupId) {
		return getMetadataManager().getUserAttributeMap(companyId, groupId);
	}

	public static boolean isAttributesEnabled(long companyId, String entityId) {
		return getMetadataManager().isAttributesEnabled(companyId, entityId);
	}

	public static boolean isAttributesNamespaceEnabled(long companyId, String entityId) {
		return getMetadataManager().isAttributesNamespaceEnabled(companyId, entityId);
	}

	public static boolean isSignAuthnRequests(long companyId, long groupId) {
		return getMetadataManager().isSignAuthnRequests(companyId, groupId);
	}

	public static boolean isSignMetadata(long companyId, long groupId) {
		return getMetadataManager().isSignMetadata(companyId, groupId);
	}

	public static boolean isSSLRequired(long companyId, long groupId) {
		return getMetadataManager().isSSLRequired(companyId, groupId);
	}

	public static boolean isWantAssertionsSigned(long companyId, long groupId) {
		return getMetadataManager().isWantAssertionsSigned(companyId, groupId);
	}

	public static boolean isWantAuthnRequestSigned(long companyId) {
		return getMetadataManager().isWantAuthnRequestSigned(companyId);
	}

	public void setMetadataManager(MetadataManager metadataManager) {
		_metadataManager = metadataManager;
	}

	private static MetadataManager _metadataManager;

}