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
public interface MetadataManager {

	public int getAssertionLifetime(long companyId, String entityId);

	public String[] getAttributeNames(long companyId, String entityId);

	public long getClockSkew(long companyId, long groupId);

	public String getDefaultIdpEntityId(long companyId, long groupId);

	public EntityDescriptor getEntityDescriptor(HttpServletRequest request)
		throws MetadataProviderException;

	public String getLocalEntityId(long companyId, long groupId);

	public MetadataProvider getMetadataProvider(long companyId, long groupId)
		throws MetadataProviderException;

	public String getNameIdAttribute(long companyId, String entityId);

	public String getNameIdFormat(long companyId, long groupId);

	public String getNameIdFormat(long companyId, long groupId, String entityId);

	public SecurityPolicyResolver getSecurityPolicyResolver(
			long companyId, long groupId,
			String communicationProfileId, boolean requireSignature)
		throws MetadataProviderException;

	public String getSessionKeepAliveURL(long companyId, long groupId, String entityId);

	public long getSessionMaximumAge(long companyId, long groupId);

	public long getSessionTimeout(long companyId, long groupId);

	public SignatureTrustEngine getSignatureTrustEngine(long companyId, long groupId)
		throws MetadataProviderException;

	public Credential getSigningCredential(long companyId, long groupId) throws SecurityException;

	public Map<String, String> getUserAttributeMap(long companyId, long groupId);

	public boolean isAttributesEnabled(long companyId, String entityId);

	public boolean isAttributesNamespaceEnabled(long companyId, String entityId);

	public boolean isSignAuthnRequests(long companyId, long groupId);

	public boolean isSignMetadata(long companyId, long groupId);

	public boolean isSSLRequired(long companyId, long groupId);

	public boolean isWantAssertionsSigned(long companyId, long groupId);

	public boolean isWantAuthnRequestSigned(long companyId);

}