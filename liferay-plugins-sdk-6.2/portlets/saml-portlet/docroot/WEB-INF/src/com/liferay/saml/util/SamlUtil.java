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

package com.liferay.saml.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.DynamicServletRequest;
import com.liferay.portal.kernel.struts.LastPath;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.saml.metadata.MetadataManagerUtil;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.opensaml.common.binding.SAMLMessageContext;
import org.opensaml.saml2.core.AuthnRequest;
import org.opensaml.saml2.metadata.AssertionConsumerService;
import org.opensaml.saml2.metadata.EntitiesDescriptor;
import org.opensaml.saml2.metadata.EntityDescriptor;
import org.opensaml.saml2.metadata.IDPSSODescriptor;
import org.opensaml.saml2.metadata.SPSSODescriptor;
import org.opensaml.saml2.metadata.SSODescriptor;
import org.opensaml.saml2.metadata.SingleLogoutService;
import org.opensaml.saml2.metadata.SingleSignOnService;
import org.opensaml.saml2.metadata.provider.MetadataProviderException;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.util.DatatypeHelper;

/**
 * @author Mika Koivisto
 */
public class SamlUtil extends SamlConfigUtil {

	public static enum PrimaryKeyAttributeType {
		SCREEN_NAME("screenName"),
		EMAIL_ADDRESS("emailAddress"),
		UUID("uuid");
		
		private PrimaryKeyAttributeType(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return this.value;
		}
		
		public boolean isEqual(String value) {
			return this.value.equals(value);
		}
		
		private String value;
	}
	
	/**
	 * @deprecated
	 * @author bill
	 *
	 */
	public static enum UserAttribute {
		SCREEN_NAME("screenName"),
		FIRST_NAME("firstName"),
		LAST_NAME("lastName"),
		EMAIL_ADDRESS("emailAddress"),
		UUID("uuid");
		
		private UserAttribute(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return this.value;
		}
		
		public boolean isEqual(String value) {
			return this.value.equals(value);
		}
		
		private String value;
	}

	// FIXME:
	public static AssertionConsumerService
			getAssertionConsumerServiceForBinding(
				SPSSODescriptor spSsoDescriptor, String binding)
		throws MetadataProviderException {

		AssertionConsumerService assertionConsumerService =
			spSsoDescriptor.getDefaultAssertionConsumerService();

		if (binding.equals(assertionConsumerService.getBinding())) {
			return assertionConsumerService;
		}

		List<AssertionConsumerService> assertionConsumerServices =
			spSsoDescriptor.getAssertionConsumerServices();

		for (AssertionConsumerService curAssertionConsumerService :
				assertionConsumerServices) {

			if (binding.equals(curAssertionConsumerService.getBinding())) {
				return curAssertionConsumerService;
			}
		}

		throw new MetadataProviderException(
			"Binding " + binding + " is not supported");
	}
	public static String getAssertionConsumerServiceLink(long groupId) {
		return SAML_ACS_LINK + groupId;
	}

	public static String getAuthRedirect(long groupId, String relay) {
		return String.format("%s?groupId=%s&redirect=%s", SAML_AUTH_REDIRECT, groupId, relay);
	}

	// FIXME:
	public static EntityDescriptor getEntityDescriptorById(
		String entityId, EntitiesDescriptor descriptor) {

		List<EntityDescriptor> entityDescriptors =
			descriptor.getEntityDescriptors();

		if ((entityDescriptors != null) && !entityDescriptors.isEmpty()) {
			for (EntityDescriptor entityDescriptor : entityDescriptors) {
				if (DatatypeHelper.safeEquals(
						entityDescriptor.getEntityID(), entityId)) {

					return entityDescriptor;
				}
			}
		}

		return null;
	}
	
	public static Map<String, String> getEmptyAttributesMap() {
		Map<String, String> map = new LinkedHashMap<String, String>();
//		for (final UserAttribute attribute : UserAttribute.values()) {
//			map.put(attribute.getValue(), StringPool.BLANK);
//		}
		for (String attributeName : MetadataManagerUtil.getAttributeNames(0, null)) {
			map.put(attributeName, StringPool.BLANK);
		}
		return map;
	}

	// FIXME:
	public static EntityDescriptor getEntityDescriptorById(
		String entityId, XMLObject metadata) {

		if (metadata instanceof EntityDescriptor) {
			EntityDescriptor entityDescriptor = (EntityDescriptor)metadata;

			if (DatatypeHelper.safeEquals(
					entityDescriptor.getEntityID(), entityId)) {

				return entityDescriptor;
			}
		}
		else if (metadata instanceof EntitiesDescriptor) {
			return getEntityDescriptorById(
				entityId, (EntitiesDescriptor)metadata);
		}

		return null;
	}
	
	public static long getGroupId(HttpServletRequest request) {
		
		if (_log.isDebugEnabled()) {
			_log.debug("getGroupId: path = " + getRequestPath(request));
			for (Enumeration<String> keys = request.getParameterNames(); keys.hasMoreElements(); ) {
				String key = keys.nextElement();
				String value = request.getParameter(key);
				_log.debug("\t" + key + " = " + value.substring(0, Math.min(100, value.length())));
			}
		}
		
		long groupId = 0L;
		if (_isSamlRequest(request)) {
			if (isLoginRequest(request)) {
				try {
					groupId = _getGroupIdFromPath(request);
				} catch (Exception e) {}
				if (groupId == 0L) {
					try {
						groupId = _getGroupIdFromParms(request, GROUP_ID);	
					} catch (Exception e) {}
				}
				if (groupId == 0L) {
					try {
						groupId = _getGroupIdFromFriendlyURL(request);
					} catch (Exception e) {}
				}
			}
			else if (isLogoutRequest(request)) {
				try {
					groupId = PortalUtil.getScopeGroupId(request);
				} catch (Exception e) {}
				if (groupId == 0L)
					groupId = _getGroupIdFromFriendlyURL(request);
			}
			else if (isMetadataRequest(request)) {
				groupId = _getGroupIdFromParms(request, GROUP_ID);
			}
			else if (isAssertionConsumerServiceRequest(request)) {
				groupId = _getGroupIdFromURL(request, SAML_ACS_LINK);
			}
			else if (isAuthRedirectRequest(request)) {
				groupId = _getGroupIdFromParms(request, GROUP_ID);
			}
			else if (isSingleSignOnRequest(request)) {
				try {
					groupId = PortalUtil.getCompany(request).getGroup().getGroupId();
				} catch (Exception e) {}
			}
			else if (isSingleLogoutServiceRedirectRequest(request)) {
				groupId = _getGroupIdFromURL(request, SAML_SLO_REDIRECT);
			}
			else if (isSingleLogoutServiceLogoutRequest(request)) {
				groupId = _getGroupIdFromURL(request, SAML_SLO_LOGOUT);
			}
			else if (isSingleLogoutServiceSoapRequest(request)) {
				groupId = _getGroupIdFromURL(request, SAML_SLO_SOAP);
			}
			else {
				groupId = _getGroupIdFromParms(request, GROUP_ID);
				if (groupId == 0L) {
					try {
						groupId = PortalUtil.getScopeGroupId(request);
					} catch (Exception e) {}
				}
			}
			if (groupId == 0L) {
				try {
					groupId = PortalUtil.getCompany(request).getGroup().getGroupId();
				} catch (Exception e) {}
			}
		}
		else {
			try {
				groupId = _getGroupIdFromPath(request);
			} catch (Exception e) {}
		}
		
		return groupId;
	}
	
	public static String getKeystoreCredentialPassword(
			long companyId) {
		try {
			long groupId = CompanyLocalServiceUtil
					.getCompany(companyId)
					.getGroup()
					.getGroupId();
			return getKeystoreCredentialPassword(companyId, groupId);
		} catch (Exception e) {
			_log.error("Unable to get keystore credential password for company ID " + companyId + ".  " + e);
			return null;
		}
	}
	
	public static String getKeystoreCredentialPassword(
			long companyId, long groupId) {

		return getString(
				companyId,
				groupId,
				PortletPropsKeys.SAML_KEYSTORE_PASSWORD);
	}

	public static String getKeystoreCredential(
			long companyId) {
		try {
			long groupId = CompanyLocalServiceUtil
					.getCompany(companyId)
					.getGroup()
					.getGroupId();
				return getKeystoreCredential(companyId, groupId);
		} catch (Exception e) {
			_log.error("Unable to get keystore credential for company ID " + companyId + ".  " + e);
			return null;
		}
	}

	public static String getKeystoreCredential(
			long companyId, long groupId) {
		
		return getString(
			companyId,
			groupId,
			PortletPropsKeys.SAML_ENTITY_ID);
	}

//	public static String getLoginLink(long groupId) {
//		return SAML_LOGIN + groupId;
//	}
	
//	public static String getLogoutLink(long groupId) {
//		return SAML_LOGOUT; // + groupId;
//	}
	
	public static String getIdpMetadataLink() {
		return SAML_METADATA;
	}
	
	public static String getRequestPath(HttpServletRequest request) {
		String requestURI = request.getRequestURI();

		String contextPath = request.getContextPath();

		if (Validator.isNotNull(contextPath) &&
			!contextPath.equals(StringPool.SLASH)) {

			requestURI = requestURI.substring(contextPath.length());
		}

		Matcher matcher = _pattern.matcher(requestURI);

		return matcher.replaceFirst(StringPool.BLANK);
	}

	public static String getRole(long companyId) {
		try {
			long groupId = GroupLocalServiceUtil.getCompanyGroup(companyId).getGroupId();
			return getString(companyId, groupId, PortletPropsKeys.SAML_ROLE);
		} catch (Exception e) {
			_log.error("Unable to get saml role for company with ID " + companyId + ">  " + e);
		}
		return null;
	}
	
	public static String getSingleLogoutServiceRedirectLink(long groupId) {
		return SAML_SLO_REDIRECT + groupId;
	}

	public static String getSingleLogoutServiceSoapLink(long groupId) {
		return SAML_SLO_SOAP + groupId;
	}

//	public static String getSingleSignOutLink(long groupId) {
//		return SAML_SSO + "?" + GROUP_ID + "=" + groupId;
//	}
	
	public static String getSingleSignOnLink() {
		return SAML_SSO;
	}
	
	// FIXME:
	public static SingleLogoutService getSingleLogoutServiceForBinding(
			SSODescriptor ssoDescriptor, String binding)
		throws MetadataProviderException {

		List<SingleLogoutService> singleLogoutServices =
			ssoDescriptor.getSingleLogoutServices();

		for (SingleLogoutService singleLogoutService : singleLogoutServices) {
			if (binding.equals(singleLogoutService.getBinding())) {
				return singleLogoutService;
			}
		}

		throw new MetadataProviderException(
			"Binding " + binding + " is not supported");
	}
	
	public static String getSingleLogoutServiceLogoutLink(long groupId) {
		return SAML_SLO_LOGOUT + groupId;
	}

	// FIXME:
	public static SingleSignOnService getSingleSignOnServiceForBinding(
			IDPSSODescriptor idpSsoDescriptor, String binding)
		throws MetadataProviderException {

		List<SingleSignOnService> singleSignOnServices =
			idpSsoDescriptor.getSingleSignOnServices();

		for (SingleSignOnService singleSignOnService : singleSignOnServices) {
			if (binding.equals(singleSignOnService.getBinding())) {
				return singleSignOnService;
			}
		}

		throw new MetadataProviderException(
			"Binding " + binding + " is not supported");
	}
	
	public static String getSpMetadataLink(long companyId, long groupId) {
		return SAML_METADATA + "?" + GROUP_ID + "=" + groupId;
	}
	
	public static boolean isAssertionConsumerServiceRequest(HttpServletRequest request) {
		return getRequestPath(request).startsWith(SAML_ACS_LINK);
	}
	
	public static boolean isAuthRedirectRequest(HttpServletRequest request) {
		return getRequestPath(request).startsWith(SAML_AUTH_REDIRECT);
	}

	public static boolean isDebugEnabled(long companyId, long groupId) {
		if (_log.isDebugEnabled()) {
			_log.debug("isDebugEnabled(" + companyId + ", " + groupId + ")");
			if (groupId == 0L) return false;
		}
		if (groupId == 0L)
			return false;
		if (_isCompanyGroup(companyId, groupId))
			return false;
		else {
			return getBoolean(
					_getDefaultUserId(companyId), 
					companyId, 
					groupId, 
					PortletPropsKeys.SAML_DEBUG_ENABLED, 
					Boolean.FALSE);
		}
	}

	public static boolean isEnabled(long companyId, long groupId) {
		if (groupId == 0L) {
			_log.debug("isEnabled(" + companyId + ", " + groupId + ") == FALSE");
			return false;
		}
		else {
			if (_log.isDebugEnabled()) {
				boolean enabled = getBoolean(
						_getDefaultUserId(companyId), 
						companyId, 
						groupId, 
						PortletPropsKeys.SAML_ENABLED, 
						Boolean.FALSE);
				_log.debug("isEnabled(" + companyId + ", " + groupId + ") == " + enabled);
				return enabled;
			}
			else
				return getBoolean(
						_getDefaultUserId(companyId), 
						companyId, 
						groupId, 
						PortletPropsKeys.SAML_ENABLED, 
						Boolean.FALSE);
		}
	}

	public static boolean isLDAPImportEnabled(long companyId, long groupId) {
		return getBoolean(companyId, groupId, PortletPropsKeys.SAML_SP_LDAP_IMPORT_ENABLED);
	}
	
	public static boolean isLoginRequest(HttpServletRequest request) {
		return getRequestPath(request).startsWith(SAML_LOGIN);
	}

	public static boolean isLogoutRequest(HttpServletRequest request) {
		return getRequestPath(request).startsWith(SAML_LOGOUT);
	}
	
	public static boolean isMetadataRequest(HttpServletRequest request) {
		return getRequestPath(request).startsWith(SAML_METADATA);
	}

	public static boolean isRoleIdp(long companyId) {
		return "idp".equals(getRole(companyId));
	}

	public static boolean isRoleSp(long companyId) {
		return "sp".equals(getRole(companyId));
	}
	
	public static boolean isSingleLogoutServiceRedirectRequest(HttpServletRequest request) {
		return getRequestPath(request).startsWith(SAML_SLO_REDIRECT);
	}
	
	public static boolean isSingleSignOnRequest(HttpServletRequest request) {
		return getRequestPath(request).startsWith(SAML_SSO);
	}
	
	public static boolean isSingleLogoutServiceSoapRequest(HttpServletRequest request) {
		return getRequestPath(request).startsWith(SAML_SLO_SOAP);
	}
	
	public static boolean isSingleLogoutServiceLogoutRequest(HttpServletRequest request) {
		return getRequestPath(request).startsWith(SAML_SLO_LOGOUT);
	}
	
	public static boolean isDoNotUseSamlForLogout(HttpServletRequest request) {
		try {
			long companyId = PortalUtil.getCompanyId(request);
			long groupId = getGroupId(request);
			return isDoNotUseSamlForLogout(
					companyId, 
					groupId);
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isDoNotUseSamlForLogout(long companyId, long groupId) {
		try {
			return SamlConfigUtil.getBoolean(
					companyId, 
					groupId, 
					PortletPropsKeys.SAML_DO_NOT_USE_SAML_FOR_LOGOUT);
		} catch (Exception e) {
			return false;
		}
	}
	
	// FIXME:
	public static AssertionConsumerService resolverAssertionConsumerService(
		SAMLMessageContext<AuthnRequest, ?, ?> samlMessageContext,
		String binding) {

		AuthnRequest authnRequest = samlMessageContext.getInboundSAMLMessage();

		Integer assertionConsumerServiceIndex = null;
		String assertionConsumerServiceURL = null;

		if (authnRequest != null) {
			assertionConsumerServiceIndex =
				authnRequest.getAssertionConsumerServiceIndex();
			assertionConsumerServiceURL =
				authnRequest.getAssertionConsumerServiceURL();
		}

		SPSSODescriptor spSsoDescriptor =
			(SPSSODescriptor)samlMessageContext.getPeerEntityRoleMetadata();

		for (AssertionConsumerService assertionConsumerService :
				spSsoDescriptor.getAssertionConsumerServices()) {

			if (!binding.equals(assertionConsumerService.getBinding())) {
				continue;
			}

			if ((assertionConsumerServiceIndex != null) &&
				(assertionConsumerService.getIndex().intValue() ==
					assertionConsumerServiceIndex.intValue())) {

				return assertionConsumerService;
			}
			else if (Validator.isNotNull(assertionConsumerServiceURL) &&
					 assertionConsumerServiceURL.equals(
						assertionConsumerService.getLocation())) {

				return assertionConsumerService;
			}
		}

		for (AssertionConsumerService assertionConsumerService :
				spSsoDescriptor.getAssertionConsumerServices()) {

			if (binding.equals(assertionConsumerService.getBinding())) {
				return assertionConsumerService;
			}
		}

		return null;
	}

	// FIXME:
	public static SingleLogoutService resolveSingleLogoutService(
		SSODescriptor ssoDescriptor, String preferredBinding) {

		List<SingleLogoutService> singleLogoutServices =
			ssoDescriptor.getSingleLogoutServices();

		for (SingleLogoutService singleLogoutService : singleLogoutServices) {
			if (preferredBinding.equals(singleLogoutService.getBinding())) {
				return singleLogoutService;
			}
		}

		if (!singleLogoutServices.isEmpty()) {
			return singleLogoutServices.get(0);
		}

		return null;
	}

	// FIXME:
	public static SingleSignOnService resolveSingleSignOnService(
		IDPSSODescriptor idpSsoDescriptor, String preferredBinding) {

		List<SingleSignOnService> singleSignOnServices =
			idpSsoDescriptor.getSingleSignOnServices();

		for (SingleSignOnService singleSignOnService : singleSignOnServices) {
			if (preferredBinding.equals(singleSignOnService.getBinding())) {
				return singleSignOnService;
			}
		}

		if (!singleSignOnServices.isEmpty()) {
			return singleSignOnServices.get(0);
		}

		return null;
	}
	
	public static void sendError(
			int status, Throwable t, HttpServletRequest request,
			HttpServletResponse response)
		throws IOException, ServletException {

		DynamicServletRequest dynamicRequest = new DynamicServletRequest(
			request);

		// Reset layout params or there will be an infinite loop

		dynamicRequest.setParameter("p_l_id", StringPool.BLANK);

		dynamicRequest.setParameter("groupId", StringPool.BLANK);
		dynamicRequest.setParameter("layoutId", StringPool.BLANK);
		dynamicRequest.setParameter("privateLayout", StringPool.BLANK);
		
		String exception = t.getClass().getName();
		if (Validator.isNotNull(t.getMessage()))
			exception += t.getMessage();
		
		dynamicRequest.setParameter("exception", exception);
		dynamicRequest.setParameter("samlError", StringPool.TRUE);

		PortalUtil.sendError(status, (Exception)t, dynamicRequest, response);
//		StringBundler sb = new StringBundler(4);
//		
//		sb.append("/c/portal/samlstatus?status=500&exception=");
//		sb.append(t.getClass().getName());
//		sb.append("&previousURL=");
//		sb.append(HttpUtil.encodeURL((String)request.getAttribute(WebKeys.CURRENT_URL)));
//		
//		response.sendRedirect(sb.toString());
	}

	public static long _getDefaultUserId(long companyId) {
		Long defaultUserId = _defaultUserIds.get(companyId);
		if (defaultUserId == null) {
			try {
				defaultUserId = UserLocalServiceUtil.getDefaultUserId(companyId);
			}
			catch (Exception e) {
				defaultUserId = 0L;
			}
			_defaultUserIds.put(companyId, defaultUserId);
		}
		return defaultUserId;
	}

	private static long _getGroupIdFromFriendlyURL(HttpServletRequest request) {
		ThemeDisplay themeDisplay =
				(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if (themeDisplay != null)
				return themeDisplay.getLayout().getGroupId();
		} catch (Exception e) {}
		
		try {
			LayoutSet layoutSet = 
					LayoutSetLocalServiceUtil.getLayoutSet(request.getServerName());
			return layoutSet.getGroupId();
		} catch (Exception e) {}
		
		
		long companyId = PortalUtil.getCompanyId(request);
		try {
			String redirect = request.getParameter("redirect");
			if (Validator.isNotNull(redirect))
				return _getGroupIdFromPath(companyId, redirect);
		} catch (Exception e) {}
		
		try {
			LastPath lastPath = (LastPath) request.getSession().getAttribute(WebKeys.LAST_PATH);
			
			String fullURL = (lastPath == null) ? request.getRequestURI() : lastPath.getPath();
			
			return _getGroupIdFromPath(companyId, fullURL);
		} catch (Exception e) {}
		return 0L;
	}
	
	private static long _getGroupIdFromPath(HttpServletRequest request) throws Exception {
		long companyId = PortalUtil.getCompanyId(request);
		String path = getRequestPath(request);
		return _getGroupIdFromPath(companyId, path);
	}
	
	private static long _getGroupIdFromPath(long companyId, String path) throws Exception {
		String friendlyURL = path == null ? StringPool.SLASH : path;
		
		// Does the path start with the server name
		if (friendlyURL.startsWith("http")) {
			int pos = friendlyURL.indexOf("//");
			pos = friendlyURL.indexOf(StringPool.SLASH, pos+2);
			friendlyURL = friendlyURL.substring(pos);
		}
		
		if (friendlyURL.startsWith(PUBLIC_PATH))
			friendlyURL = friendlyURL.substring(PUBLIC_PATH.length());
		else if (friendlyURL.startsWith(PRIVATE_PATH))
			friendlyURL = friendlyURL.substring(PRIVATE_PATH.length());
		
		int pos1 = friendlyURL.indexOf(StringPool.SLASH, 1);
		if (pos1 > -1) {
			friendlyURL = friendlyURL.substring(0, pos1);
		}
		return GroupLocalServiceUtil
				.getFriendlyURLGroup(companyId, friendlyURL)
				.getGroupId();
	}
	
	private static long _getGroupIdFromURL(HttpServletRequest request, String prefix) {
		long groupId = 0L;
		String groupIdStr = getRequestPath(request).substring(prefix.length());
		try {
			groupId = Long.parseLong(groupIdStr);
		} catch (Exception e) {
			_log.error("Unable to get group ID from '" + groupIdStr + "'");
		}
		return groupId;
	}
	
	private static long _getGroupIdFromParms(HttpServletRequest request, String key) {
		return GetterUtil.getLong(request.getParameter(key), 0L);
	}
	
	private static boolean _isCompanyGroup(long companyId, long groupId) {
		try {
			Company company = CompanyLocalServiceUtil.getCompany(companyId);
			return company.getGroup().getGroupId() == groupId;
		} catch (Exception e) {}
		return false;
	}
	
	private static boolean _isSamlRequest(HttpServletRequest request) {
		return getRequestPath(request).startsWith(CMD_PREFIX);
	}
	
	private final static String CMD_PREFIX			= "/c/portal/";
	private final static String SAML_PREFIX			= CMD_PREFIX + "saml/";
	private final static String SAML_LOGIN  		= CMD_PREFIX + "login";
	private final static String SAML_LOGOUT 		= CMD_PREFIX + "logout";
	private final static String SAML_METADATA 		= SAML_PREFIX + "metadata";
	private final static String SAML_ACS_LINK		= SAML_PREFIX + "acs/";
	private final static String SAML_SLO_LOGOUT		= SAML_PREFIX + "slo_logout/";
	private final static String SAML_SLO_REDIRECT	= SAML_PREFIX + "slo_redirect/";
	private final static String SAML_SLO_SOAP		= SAML_PREFIX + "slo_soap/";
	private final static String SAML_SSO			= SAML_PREFIX + "sso";
	private final static String SAML_AUTH_REDIRECT	= SAML_PREFIX + "auth_redirect";
	
	private final static String GROUP_ID			= "groupId";
	
	private final static String PUBLIC_PATH			= "/web";
	private final static String PRIVATE_PATH		= "/group";

	private static Pattern _pattern = Pattern.compile(";jsessionid=.*");
	
	private static Map<Long, Long> _defaultUserIds = new HashMap<Long, Long>();
	
	final private static Log _log = LogFactoryUtil.getLog(SamlUtil.class);

}