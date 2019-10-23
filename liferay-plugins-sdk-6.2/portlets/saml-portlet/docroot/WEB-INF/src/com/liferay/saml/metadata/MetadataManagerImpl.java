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

import com.liferay.portal.kernel.concurrent.ReadWriteLockKey;
import com.liferay.portal.kernel.concurrent.ReadWriteLockRegistry;
import com.liferay.portal.kernel.configuration.Filter;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.saml.credential.GroupCriteria;
import com.liferay.saml.model.SamlIdpSpConnection;
import com.liferay.saml.model.SamlSpIdpConnection;
import com.liferay.saml.provider.CachingChainingMetadataProvider;
import com.liferay.saml.provider.DBMetadataProvider;
import com.liferay.saml.provider.ReinitializingFilesystemMetadataProvider;
import com.liferay.saml.provider.ReinitializingHttpMetadataProvider;
import com.liferay.saml.service.SamlIdpSpConnectionLocalServiceUtil;
import com.liferay.saml.service.SamlSpIdpConnectionLocalServiceUtil;
import com.liferay.saml.util.PortletPrefsPropsUtil;
import com.liferay.saml.util.PortletPropsKeys;
import com.liferay.saml.util.PortletPropsValues;
import com.liferay.saml.util.SamlConfigUtil;
import com.liferay.saml.util.SamlUtil;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpClient;
import org.opensaml.Configuration;
import org.opensaml.common.binding.security.SAMLProtocolMessageXMLSignatureSecurityPolicyRule;
import org.opensaml.common.xml.SAMLConstants;
import org.opensaml.saml2.binding.security.SAML2HTTPPostSimpleSignRule;
import org.opensaml.saml2.binding.security.SAML2HTTPRedirectDeflateSignatureRule;
import org.opensaml.saml2.core.NameIDType;
import org.opensaml.saml2.metadata.EntityDescriptor;
import org.opensaml.saml2.metadata.provider.FilesystemMetadataProvider;
import org.opensaml.saml2.metadata.provider.HTTPMetadataProvider;
import org.opensaml.saml2.metadata.provider.MetadataProvider;
import org.opensaml.saml2.metadata.provider.MetadataProviderException;
import org.opensaml.security.MetadataCredentialResolver;
import org.opensaml.ws.security.SecurityPolicy;
import org.opensaml.ws.security.SecurityPolicyResolver;
import org.opensaml.ws.security.SecurityPolicyRule;
import org.opensaml.ws.security.provider.BasicSecurityPolicy;
import org.opensaml.ws.security.provider.HTTPRule;
import org.opensaml.ws.security.provider.MandatoryAuthenticatedMessageRule;
import org.opensaml.ws.security.provider.MandatoryIssuerRule;
import org.opensaml.ws.security.provider.StaticSecurityPolicyResolver;
import org.opensaml.xml.parse.ParserPool;
import org.opensaml.xml.security.CriteriaSet;
import org.opensaml.xml.security.SecurityConfiguration;
import org.opensaml.xml.security.SecurityException;
import org.opensaml.xml.security.credential.Credential;
import org.opensaml.xml.security.credential.CredentialResolver;
import org.opensaml.xml.security.criteria.EntityIDCriteria;
import org.opensaml.xml.security.keyinfo.KeyInfoCredentialResolver;
import org.opensaml.xml.signature.SignatureTrustEngine;
import org.opensaml.xml.signature.impl.ChainingSignatureTrustEngine;
import org.opensaml.xml.signature.impl.ExplicitKeySignatureTrustEngine;

/**
 * @author Mika Koivisto
 */
public class MetadataManagerImpl implements MetadataManager {

	public static final int SAML_IDP_ASSERTION_LIFETIME_DEFAULT = 1800;


	//@Override
	public int getAssertionLifetime(long companyId, String entityId) {
		try {
			SamlIdpSpConnection samlIdpSpConnection =
				SamlIdpSpConnectionLocalServiceUtil.getSamlIdpSpConnection(
					companyId, entityId);

			return samlIdpSpConnection.getAssertionLifetime();
		}
		catch (Exception e) {
		}

		String samlIdpAssertionLifetime = PortletPrefsPropsUtil.getString(
				companyId,
				PortletPropsKeys.SAML_IDP_ASSERTION_LIFETIME, 
				new Filter(entityId));

		return GetterUtil.getInteger(
			samlIdpAssertionLifetime, SAML_IDP_ASSERTION_LIFETIME_DEFAULT);
	}


	//@Override
	public String[] getAttributeNames(long companyId, String entityId) {
		if (Validator.isNotNull(entityId)) {
			try {
				SamlIdpSpConnection samlIdpSpConnection =
					SamlIdpSpConnectionLocalServiceUtil.getSamlIdpSpConnection(
						companyId, entityId);
	
				return StringUtil.splitLines(
					samlIdpSpConnection.getAttributeNames());
			}
			catch (Exception e) {
			}
	
			String attributeNames = PortletPrefsPropsUtil.getString(
				companyId,
				PortletPropsKeys.SAML_IDP_METADATA_ATTRIBUTE_NAMES.concat(
					"[").concat(entityId).concat("]"));
	
			if (Validator.isNotNull(attributeNames)) {
				return StringUtil.splitLines(attributeNames);
			}
	
			attributeNames = PropsUtil.get(
				PortletPropsKeys.SAML_IDP_METADATA_ATTRIBUTE_NAMES,
				new Filter(entityId));
	
			if (Validator.isNotNull(attributeNames)) {
				return StringUtil.split(attributeNames);
			}
		}
		
		return PropsUtil.getArray(
			PortletPropsKeys.SAML_IDP_METADATA_ATTRIBUTE_NAMES);
	}


	//@Override
	public long getClockSkew(long companyId, long groupId) {
		if (SamlUtil.isEnabled(companyId, groupId)) {
			try {
				SamlSpIdpConnection samlSpIdpConnection =
					SamlSpIdpConnectionLocalServiceUtil.getSamlSpIdpConnection(
						companyId, groupId);
	
				return samlSpIdpConnection.getClockSkew();
			}
			catch (Exception e) {
			}
			return SamlConfigUtil.getInteger(companyId, groupId, PortletPropsKeys.SAML_SP_CLOCK_SKEW, 3000).longValue();
		}
		return 3000L;
	}


	//@Override
	public String getDefaultIdpEntityId(long companyId, long groupId) {
		return SamlConfigUtil.getString(
			companyId, groupId, PortletPropsKeys.SAML_SP_DEFAULT_IDP_ENTITY_ID);
	}


	//@Override
	public EntityDescriptor getEntityDescriptor(HttpServletRequest request)
		throws MetadataProviderException {
		long companyId = PortalUtil.getCompanyId(request);
		long groupId = SamlUtil.getGroupId(request);
		try {
			if (SamlUtil.isRoleIdp(companyId)) {
				return MetadataGeneratorUtil.buildIdpEntityDescriptor(
					request, 
					getLocalEntityId(companyId, groupId), 
					isWantAuthnRequestSigned(companyId),
					isSignMetadata(companyId, groupId), 
					isSSLRequired(companyId, groupId), 
					getSigningCredential(companyId, groupId));
			}
			else if (SamlUtil.isRoleSp(companyId)) {
				return MetadataGeneratorUtil.buildSpEntityDescriptor(
					request, 
					getLocalEntityId(companyId, groupId), 
					groupId,
					isSignAuthnRequests(companyId, groupId),
					isSignMetadata(companyId, groupId), 
					isSSLRequired(companyId, groupId), 
					isWantAssertionsSigned(companyId, groupId),
					getSigningCredential(companyId, groupId));
			}

			return null;
		}
		catch (Exception e) {
			throw new MetadataProviderException(e);
		}
	}


	//@Override
	public String getLocalEntityId(long companyId, long groupId) {
		return SamlUtil.getKeystoreCredential(
				companyId, groupId);
	}


	//@Override
	public MetadataProvider getMetadataProvider(long companyId, long groupId)
		throws MetadataProviderException {

		String key = companyId + StringPool.COLON + groupId;
		
		ReadWriteLockKey<String> readWriteLockKey = new ReadWriteLockKey<String>(
			key, true);

		Lock lock = _readWriteLockRegistry.acquireLock(readWriteLockKey);

		lock.lock();

		try {
			MetadataProvider metadataProvider = _metadataProviders.get(key);

			if (metadataProvider != null) {
				return metadataProvider;
			}

			CachingChainingMetadataProvider cachingChainingMetadataProvider =
				new CachingChainingMetadataProvider();

			metadataProvider = cachingChainingMetadataProvider;

			DBMetadataProvider dbMetadataProvider = new DBMetadataProvider(companyId, groupId);

			dbMetadataProvider.setParserPool(_parserPool);

			cachingChainingMetadataProvider.addMetadataProvider(
				dbMetadataProvider);

			String[] paths = PropsUtil.getArray(
				PortletPropsKeys.SAML_METADATA_PATHS);

			for (String path : paths) {
				if (path.startsWith("http://") || path.startsWith("https://")) {
					HTTPMetadataProvider httpMetadataProvider =
						new ReinitializingHttpMetadataProvider(
							_timer, _httpClient, path);

					httpMetadataProvider.setFailFastInitialization(false);
					httpMetadataProvider.setMaxRefreshDelay(
						PortletPropsValues.SAML_METADATA_MAX_REFRESH_DELAY);
					httpMetadataProvider.setMinRefreshDelay(
						PortletPropsValues.SAML_METADATA_MIN_REFRESH_DELAY);
					httpMetadataProvider.setParserPool(_parserPool);

					try {
						httpMetadataProvider.initialize();
					}
					catch (MetadataProviderException mpe) {
						_log.warn("Unable to initialize provider " + path);
					}

					cachingChainingMetadataProvider.addMetadataProvider(
						httpMetadataProvider);
				}
				else {
					FilesystemMetadataProvider filesystemMetadataProvider =
						new ReinitializingFilesystemMetadataProvider(
							_timer, new File(path));

					filesystemMetadataProvider.setFailFastInitialization(false);
					filesystemMetadataProvider.setMaxRefreshDelay(
						PortletPropsValues.SAML_METADATA_MAX_REFRESH_DELAY);
					filesystemMetadataProvider.setMinRefreshDelay(
						PortletPropsValues.SAML_METADATA_MIN_REFRESH_DELAY);
					filesystemMetadataProvider.setParserPool(_parserPool);

					try {
						filesystemMetadataProvider.initialize();
					}
					catch (MetadataProviderException mpe) {
						_log.warn("Unable to initialize provider " + path);
					}

					cachingChainingMetadataProvider.addMetadataProvider(
						filesystemMetadataProvider);
				}
			}

			_metadataProviders.put(key, metadataProvider);

			return metadataProvider;
		}
		finally {
			lock.unlock();

			if (readWriteLockKey != null) {
				_readWriteLockRegistry.releaseLock(readWriteLockKey);
			}
		}
	}


	//@Override
	public String getNameIdAttribute(long companyId, String entityId) {
		String nameIdAttributeName = StringPool.BLANK;

		try {
			SamlIdpSpConnection samlIdpSpConnection =
				SamlIdpSpConnectionLocalServiceUtil.getSamlIdpSpConnection(
					companyId, entityId);

			nameIdAttributeName = samlIdpSpConnection.getNameIdAttribute();
		}
		catch (Exception e) {
		}

		if (Validator.isNotNull(nameIdAttributeName)) {
			return nameIdAttributeName;
		}

		nameIdAttributeName = PortletPrefsPropsUtil.getString(
			companyId,
			PortletPropsKeys.SAML_IDP_METADATA_NAME_ID_ATTRIBUTE,
			new Filter(entityId));

		if (Validator.isNull(nameIdAttributeName)) {
			nameIdAttributeName = "emailAddress";
		}

		return nameIdAttributeName;
	}


	//@Override
	public String getNameIdFormat(long companyId, long groupId) {
		if (SamlUtil.isEnabled(companyId, groupId)) {
			try {
				SamlSpIdpConnection samlSpIdpConnection =
					SamlSpIdpConnectionLocalServiceUtil.getSamlSpIdpConnection(
						companyId, groupId);
	
				return samlSpIdpConnection.getNameIdFormat();
			}
			catch (Exception e) {
			}
		}
		return SamlConfigUtil.getString(
				companyId, 
				groupId, 
				PortletPropsKeys.SAML_SP_NAME_ID_FORMAT, 
				NameIDType.EMAIL);
	}


	//@Override
	public String getNameIdFormat(long companyId, long groupId, String entityId) {
		try {
			SamlIdpSpConnection samlIdpSpConnection =
				SamlIdpSpConnectionLocalServiceUtil.getSamlIdpSpConnection(
					companyId, entityId);

			return samlIdpSpConnection.getNameIdFormat();
		}
		catch (Exception e) {
		}

		return SamlConfigUtil.getString(
				companyId, 
				groupId, 
				PortletPropsKeys.SAML_IDP_METADATA_NAME_ID_FORMAT, 
				NameIDType.EMAIL);
	}


	//@Override
	public SecurityPolicyResolver getSecurityPolicyResolver(
			long companyId, long groupId,
			String communicationProfileId, boolean requireSignature)
		throws MetadataProviderException {

		SecurityPolicy securityPolicy = new BasicSecurityPolicy();

		List<SecurityPolicyRule> securityPolicyRules =
			securityPolicy.getPolicyRules();

		if (requireSignature) {
			SignatureTrustEngine signatureTrustEngine =
				getSignatureTrustEngine(companyId, groupId);

			if (communicationProfileId.equals(
					SAMLConstants.SAML2_REDIRECT_BINDING_URI)) {

				SecurityPolicyRule securityPolicyRule =
					new SAML2HTTPRedirectDeflateSignatureRule(
						signatureTrustEngine);

				securityPolicyRules.add(securityPolicyRule);
			}
			else if (communicationProfileId.equals(
						SAMLConstants.SAML2_POST_SIMPLE_SIGN_BINDING_URI)) {

				SecurityConfiguration securityConfiguration =
					Configuration.getGlobalSecurityConfiguration();

				KeyInfoCredentialResolver keyInfoCredentialResolver =
					securityConfiguration.getDefaultKeyInfoCredentialResolver();

				SecurityPolicyRule securityPolicyRule =
					new SAML2HTTPPostSimpleSignRule(
						signatureTrustEngine, _parserPool,
						keyInfoCredentialResolver);

				securityPolicyRules.add(securityPolicyRule);
			}
			else {
				SecurityPolicyRule securityPolicyRule =
					new SAMLProtocolMessageXMLSignatureSecurityPolicyRule(
						signatureTrustEngine);

				securityPolicyRules.add(securityPolicyRule);
			}

			MandatoryAuthenticatedMessageRule
				mandatoryAuthenticatedMessageRule =
					new MandatoryAuthenticatedMessageRule();

			securityPolicyRules.add(mandatoryAuthenticatedMessageRule);
		}

		HTTPRule httpRule = new HTTPRule(
			null, null, MetadataManagerUtil.isSSLRequired(companyId, groupId));

		securityPolicyRules.add(httpRule);

		MandatoryIssuerRule mandatoryIssuerRule = new MandatoryIssuerRule();

		securityPolicyRules.add(mandatoryIssuerRule);

		StaticSecurityPolicyResolver securityPolicyResolver =
			new StaticSecurityPolicyResolver(securityPolicy);

		return securityPolicyResolver;
	}


	//@Override
	public String getSessionKeepAliveURL(long companyId, long groupId, String entityId) {
		String url = SamlConfigUtil.getString(
				companyId, 
				groupId, 
				PortletPropsKeys.SAML_IDP_METADATA_SESSION_KEEP_ALIVE_URL);
		if (Validator.isNotNull(url))
			return url;
		else
			return PropsUtil.get(
				PortletPropsKeys.SAML_IDP_METADATA_SESSION_KEEP_ALIVE_URL,
				new Filter(entityId));
	}


	//@Override
	public long getSessionMaximumAge(long companyId, long groupId) {
		return SamlConfigUtil.getInteger(
				companyId,
				groupId,
				PortletPropsKeys.SAML_IDP_SESSION_MAXIMUM_AGE).longValue();
	}


	//@Override
	public long getSessionTimeout(long companyId, long groupId) {
		return SamlConfigUtil.getInteger(
				companyId,
				groupId,
				PortletPropsKeys.SAML_IDP_SESSION_TIMEOUT).longValue();
	}


	//@Override
	public SignatureTrustEngine getSignatureTrustEngine(long companyId, long groupId)
		throws MetadataProviderException {

		ChainingSignatureTrustEngine chainingSignatureTrustEngine =
			new ChainingSignatureTrustEngine();

		List<SignatureTrustEngine> signatureTrustEngines =
			chainingSignatureTrustEngine.getChain();

		MetadataCredentialResolver metadataCredentialResolver =
			new MetadataCredentialResolver(getMetadataProvider(companyId, groupId));

		SecurityConfiguration securityConfiguration =
			Configuration.getGlobalSecurityConfiguration();

		KeyInfoCredentialResolver keyInfoCredentialResolver =
			securityConfiguration.getDefaultKeyInfoCredentialResolver();

		SignatureTrustEngine signatureTrustEngine =
			new ExplicitKeySignatureTrustEngine(
				metadataCredentialResolver, keyInfoCredentialResolver);

		signatureTrustEngines.add(signatureTrustEngine);

		signatureTrustEngine = new ExplicitKeySignatureTrustEngine(
			_credentialResolver, keyInfoCredentialResolver);

		signatureTrustEngines.add(signatureTrustEngine);

		return chainingSignatureTrustEngine;
	}


	//@Override
	public Credential getSigningCredential(long companyId, long groupId) throws SecurityException {
		CriteriaSet criteriaSet = new CriteriaSet();

		String entityId = getLocalEntityId(companyId, groupId);

		if (Validator.isNull(entityId)) {
			return null;
		}

		criteriaSet.add(new EntityIDCriteria(entityId));
		try {
			Group group = GroupLocalServiceUtil.getGroup(groupId);
			criteriaSet.add(new GroupCriteria(group));
		}
		catch (Exception e) {
		}

		return _credentialResolver.resolveSingle(criteriaSet);
	}


	//@Override
	public Map<String, String> getUserAttributeMap(long companyId, long groupId) {
		try {
			SamlSpIdpConnection samlSpIdpConnection =
				SamlSpIdpConnectionLocalServiceUtil.getSamlSpIdpConnection(
					companyId, groupId);

			return samlSpIdpConnection.getUserAttributeMap();
		}
		catch (Exception e) {
		}

		return SamlUtil.getEmptyAttributesMap();
	}


	//@Override
	public boolean isAttributesEnabled(long companyId, String entityId) {
		try {
			SamlIdpSpConnection samlIdpSpConnection =
				SamlIdpSpConnectionLocalServiceUtil.getSamlIdpSpConnection(
					companyId,  entityId);

			return samlIdpSpConnection.isAttributesEnabled();
		}
		catch (Exception e) {
		}

		String attributesEnabled = PortletPrefsPropsUtil.getString(
			companyId,
			PortletPropsKeys.SAML_IDP_METADATA_ATTRIBUTES_ENABLED,
			new Filter(entityId));

		return GetterUtil.getBoolean(attributesEnabled);
	}


	//@Override
	public boolean isAttributesNamespaceEnabled(long companyId, String entityId) {
		try {
			SamlIdpSpConnection samlIdpSpConnection =
				SamlIdpSpConnectionLocalServiceUtil.getSamlIdpSpConnection(
					companyId, entityId);

			return samlIdpSpConnection.isAttributesNamespaceEnabled();
		}
		catch (Exception e) {
		}

		String attributesNamespaceEnabled = PortletPrefsPropsUtil.getString(
			companyId,
			PortletPropsKeys.SAML_IDP_METADATA_ATTRIBUTES_NAMESPACE_ENABLED,
			new Filter(entityId));

		return GetterUtil.getBoolean(attributesNamespaceEnabled);
	}


	//@Override
	public boolean isSignAuthnRequests(long companyId, long groupId) {
		return SamlConfigUtil.getBoolean(
			companyId,
			groupId,
			PortletPropsKeys.SAML_SP_SIGN_AUTHN_REQUEST);
	}


	//@Override
	public boolean isSignMetadata(long companyId, long groupId) {
		return SamlConfigUtil.getBoolean(
			companyId,
			groupId,
			PortletPropsKeys.SAML_SIGN_METADATA);
	}


	//@Override
	public boolean isSSLRequired(long companyId, long groupId) {
		return SamlConfigUtil.getBoolean(
			companyId,
			groupId,
			PortletPropsKeys.SAML_SSL_REQUIRED);
	}


	//@Override
	public boolean isWantAssertionsSigned(long companyId, long groupId) {
		return SamlConfigUtil.getBoolean(
			companyId,
			groupId,
			PortletPropsKeys.SAML_SP_ASSERTION_SIGNATURE_REQUIRED);
	}


	//@Override
	public boolean isWantAuthnRequestSigned(long companyId) {
		try {
			Company company = CompanyLocalServiceUtil.getCompany(companyId);
			return SamlConfigUtil.getBoolean(
				companyId,
				company.getGroup().getGroupId(),
				PortletPropsKeys.SAML_IDP_AUTHN_REQUEST_SIGNATURE_REQUIRED);
		} catch (Exception e) {
			_log.error("Unable to get property '" + PortletPropsKeys.SAML_IDP_AUTHN_REQUEST_SIGNATURE_REQUIRED + 
					"for company ID " + companyId + ".  " + e);
		}
		return false;
	}

	public void setCredentialResolver(CredentialResolver credentialResolver) {
		_credentialResolver = credentialResolver;
	}

	public void setHttpClient(HttpClient httpClient) {
		_httpClient = httpClient;
	}

	public void setParserPool(ParserPool parserPool) {
		_parserPool = parserPool;
	}

	private static Log _log = LogFactoryUtil.getLog(MetadataManagerImpl.class);

	private CredentialResolver _credentialResolver;
	private HttpClient _httpClient;
	private ConcurrentHashMap<String, MetadataProvider> _metadataProviders =
		new ConcurrentHashMap<String, MetadataProvider>();
	private ParserPool _parserPool;
	private ReadWriteLockRegistry _readWriteLockRegistry =
		new ReadWriteLockRegistry();
	private Timer _timer = new Timer(true);

}