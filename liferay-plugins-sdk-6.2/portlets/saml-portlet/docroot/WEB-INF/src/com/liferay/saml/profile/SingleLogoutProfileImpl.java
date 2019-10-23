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

package com.liferay.saml.profile;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.HttpMethods;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.saml.SamlException;
import com.liferay.saml.SamlSloContext;
import com.liferay.saml.SamlSloRequestInfo;
import com.liferay.saml.UnsolicitedLogoutResponseException;
import com.liferay.saml.UnsupportedBindingException;
import com.liferay.saml.binding.SamlBinding;
import com.liferay.saml.metadata.MetadataManagerUtil;
import com.liferay.saml.model.SamlIdpSpSession;
import com.liferay.saml.model.SamlIdpSsoSession;
import com.liferay.saml.model.SamlSpSession;
import com.liferay.saml.service.SamlIdpSpSessionLocalServiceUtil;
import com.liferay.saml.service.SamlIdpSsoSessionLocalServiceUtil;
import com.liferay.saml.service.SamlSpSessionLocalServiceUtil;
import com.liferay.saml.transport.HttpClientInTransport;
import com.liferay.saml.transport.HttpClientOutTransport;
import com.liferay.saml.util.JspUtil;
import com.liferay.saml.util.OpenSamlUtil;
import com.liferay.saml.util.PortletWebKeys;
import com.liferay.saml.util.SamlUtil;

import java.io.Writer;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.methods.PostMethod;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import org.opensaml.common.SAMLObject;
import org.opensaml.common.SAMLVersion;
import org.opensaml.common.binding.SAMLMessageContext;
import org.opensaml.common.xml.SAMLConstants;
import org.opensaml.saml2.core.Issuer;
import org.opensaml.saml2.core.LogoutRequest;
import org.opensaml.saml2.core.LogoutResponse;
import org.opensaml.saml2.core.NameID;
import org.opensaml.saml2.core.SessionIndex;
import org.opensaml.saml2.core.Status;
import org.opensaml.saml2.core.StatusCode;
import org.opensaml.saml2.metadata.EntityDescriptor;
import org.opensaml.saml2.metadata.IDPSSODescriptor;
import org.opensaml.saml2.metadata.SPSSODescriptor;
import org.opensaml.saml2.metadata.SSODescriptor;
import org.opensaml.saml2.metadata.SingleLogoutService;
import org.opensaml.saml2.metadata.provider.MetadataProvider;
import org.opensaml.ws.message.decoder.MessageDecoder;
import org.opensaml.ws.message.encoder.MessageEncoder;
import org.opensaml.ws.security.SecurityPolicyResolver;
import org.opensaml.ws.transport.http.HttpServletRequestAdapter;
import org.opensaml.ws.transport.http.HttpServletResponseAdapter;
import org.opensaml.xml.security.credential.Credential;

/**
 * @author Mika Koivisto
 */
public class SingleLogoutProfileImpl
	extends BaseProfile implements SingleLogoutProfile {


	public boolean isSingleLogoutSupported(HttpServletRequest request) {
		try {
			long companyId = PortalUtil.getCompanyId(request);
			long groupId = SamlUtil.getGroupId(request);

			MetadataProvider metadataProvider =
				MetadataManagerUtil.getMetadataProvider(companyId, groupId);

			String entityId = MetadataManagerUtil.getDefaultIdpEntityId(companyId, groupId);

			EntityDescriptor entityDescriptor =
				metadataProvider.getEntityDescriptor(entityId);

			IDPSSODescriptor idpSsoDescriptor =
				entityDescriptor.getIDPSSODescriptor(SAMLConstants.SAML20P_NS);

			SingleLogoutService singleLogoutService =
				SamlUtil.resolveSingleLogoutService(
					idpSsoDescriptor, SAMLConstants.SAML2_REDIRECT_BINDING_URI);

			if (singleLogoutService != null) {
				String binding = singleLogoutService.getBinding();

				if (!binding.equals(SAMLConstants.SAML2_SOAP11_BINDING_URI)) {
					return true;
				}
			}
		}
		catch (Exception e) {
			_log.warn("Unable to verify single logout support", e);
		}

		return false;
	}


	
	public void processIdpLogout(
			HttpServletRequest request, HttpServletResponse response)
		throws PortalException, SystemException {

//		String requestPath = SamlUtil.getRequestPath(request);

		try {
			response.addHeader(
				HttpHeaders.CACHE_CONTROL,
				HttpHeaders.CACHE_CONTROL_NO_CACHE_VALUE);
			response.addHeader(
				HttpHeaders.PRAGMA, HttpHeaders.PRAGMA_NO_CACHE_VALUE);

			if (SamlUtil.isLogoutRequest(request)) {
				initiateIdpSingleLogout(request, response, null);
			}
			else if (SamlUtil.isSingleLogoutServiceLogoutRequest(request)) {
//				SamlSloContext samlSloContext = getSamlSloContext(
//					request, null);

				SamlSloContext samlSloContext = null;  // to always execute SLO
				if (samlSloContext == null) {
					redirectToLogout(request, response);

					return;
				}

				String cmd = ParamUtil.getString(request, Constants.CMD);

				if (Validator.isNull(cmd)) {
					request.setAttribute(
						PortletWebKeys.SAML_SLO_CONTEXT,
						samlSloContext.toJSONObject());

					JspUtil.dispatch(
						request, response, JspUtil.PATH_PORTAL_SAML_SLO,
						"single-sign-on");
				}
				else if (cmd.equals("logout")) {
					performIdpSpLogout(request, response, samlSloContext);
				}
				else if (cmd.equals("finish")) {
					performIdpFinishLogout(request, response, samlSloContext);
				}
				else if (cmd.equals("status")) {
					performIdpStatus(request, response, samlSloContext);
				}
			}
		}
		catch (Exception e) {
			if (e instanceof PortalException) {
				throw (PortalException)e;
			}
			else if (e instanceof SystemException) {
				throw (SystemException)e;
			}
			else {
				throw new SamlException(e);
			}
		}
	}


	public void processSingleLogout(
			HttpServletRequest request, HttpServletResponse response)
		throws PortalException, SystemException {
		_log.info("process Single Logout");

		SamlBinding samlBinding = null;

		String method = request.getMethod();
//		String requestPath = SamlUtil.getRequestPath(request);

		if (SamlUtil.isSingleLogoutServiceRedirectRequest(request) &&
			method.equalsIgnoreCase(HttpMethods.GET)) {

			samlBinding = getSamlBinding(
				SAMLConstants.SAML2_REDIRECT_BINDING_URI);
		}
		else if (SamlUtil.isSingleLogoutServiceSoapRequest(request) &&
				 method.equalsIgnoreCase(HttpMethods.POST)) {

			samlBinding = getSamlBinding(
				SAMLConstants.SAML2_SOAP11_BINDING_URI);
		}
		else {
			throw new UnsupportedBindingException();
		}

		try {
			SAMLMessageContext<?, ?, ?> samlMessageContext = decodeSamlMessage(
				request, 
				response, 
				samlBinding, 
				MetadataManagerUtil.isSignMetadata(
						PortalUtil.getCompanyId(request), 
						SamlUtil.getGroupId(request)));

			Object inboundSamlMessage =
				samlMessageContext.getInboundSAMLMessage();

			if (inboundSamlMessage instanceof LogoutRequest) {
				processSingleLogoutRequest(
					request, response,
					(SAMLMessageContext<LogoutRequest, LogoutResponse, NameID>)
						samlMessageContext);
			}
			else if (inboundSamlMessage instanceof LogoutResponse) {
				processSingleLogoutResponse(
					request, response,
					(SAMLMessageContext<LogoutResponse, ?, ?>)
						samlMessageContext);
			}
			else {
				throw new SamlException(
					"Unrecognized inbound SAML message " +
						inboundSamlMessage.getClass());
			}
		}
		catch (Exception e) {
			if (e instanceof PortalException) {
				throw (PortalException)e;
			}
			else if (e instanceof SystemException) {
				throw (SystemException)e;
			}
			else {
				throw new SamlException(e);
			}
		}
	}


	public void processSpLogout(
			HttpServletRequest request, HttpServletResponse response)
		throws PortalException, SystemException {

		try {
			sendSpLogoutRequest(request, response);
		}
		catch (Exception e) {
			if (e instanceof PortalException) {
				throw (PortalException)e;
			}
			else if (e instanceof SystemException) {
				throw (SystemException)e;
			}
			else {
				throw new SamlException(e);
			}
		}
	}

	protected void addSessionIndex(
		LogoutRequest logoutRequest, String sessionIndexString) {

		List<SessionIndex> sessionIndexes = logoutRequest.getSessionIndexes();

		SessionIndex sessionIndex = OpenSamlUtil.buildSessionIndex(
			sessionIndexString);

		sessionIndexes.add(sessionIndex);
	}

	protected SamlSloContext getSamlSloContext(
			HttpServletRequest request,
			SAMLMessageContext<LogoutRequest, LogoutResponse, NameID>
				samlMessageContext)
		throws Exception {

		HttpSession session = request.getSession();

		SamlSloContext samlSloContext =
			(SamlSloContext)session.getAttribute(
				PortletWebKeys.SAML_SLO_CONTEXT);

		String samlSsoSessionId = getSamlSsoSessionId(request);

		if (samlMessageContext != null) {
			LogoutRequest logoutRequest =
				samlMessageContext.getInboundSAMLMessage();

			List<SessionIndex> sessionIndexes =
					logoutRequest.getSessionIndexes();

			if (!sessionIndexes.isEmpty()) {
				SessionIndex sessionIndex = sessionIndexes.get(0);

				samlSsoSessionId = sessionIndex.getSessionIndex();
			}
		}

		if ((samlSloContext == null) && Validator.isNotNull(samlSsoSessionId)) {
			SamlIdpSsoSession samlIdpSsoSession =
				SamlIdpSsoSessionLocalServiceUtil.fetchSamlIdpSso(
					samlSsoSessionId);

			if (samlIdpSsoSession != null) {
				samlSloContext = new SamlSloContext(
					samlIdpSsoSession, samlMessageContext);

				samlSloContext.setSamlSsoSessionId(samlSsoSessionId);
				samlSloContext.setUserId(PortalUtil.getUserId(request));

				session.setAttribute(
					PortletWebKeys.SAML_SLO_CONTEXT, samlSloContext);
			}
		}

		return samlSloContext;
	}

	protected void initiateIdpSingleLogout(
			HttpServletRequest request, HttpServletResponse response,
			SAMLMessageContext<LogoutRequest, LogoutResponse, NameID>
				samlMessageContext)
		throws Exception {

		SamlSloContext samlSloContext = getSamlSloContext(request, null);

		if (samlSloContext != null) {
			String portalURL = PortalUtil.getPortalURL(request);
			long groupId = SamlUtil.getGroupId(request);

			String redirect = portalURL.concat(SamlUtil.getSingleLogoutServiceLogoutLink(groupId));

			response.sendRedirect(redirect);
		}
		else {
			redirectToLogout(request, response);
		}
	}

	protected void performIdpFinishLogout(
			HttpServletRequest request, HttpServletResponse response,
			SamlSloContext samlSloContext)
		throws Exception {

		if (samlSloContext.getSamlMessageContext() != null) {
			String statusCode = StatusCode.SUCCESS_URI;

			for (SamlSloRequestInfo samlRequestInfo :
					samlSloContext.getSamlSloRequestInfos()) {

				String samlRequestInfoStatusCode =
					samlRequestInfo.getStatusCode();

				if (!samlRequestInfoStatusCode.equals(StatusCode.SUCCESS_URI)) {
					statusCode = StatusCode.PARTIAL_LOGOUT_URI;

					break;
				}
			}

			sendIdpLogoutResponse(
				request, response, statusCode, samlSloContext);
		}
		else {
			redirectToLogout(request, response);
		}
	}

	// FIXME: entityId
	protected void performIdpSpLogout(
			HttpServletRequest request, HttpServletResponse response,
			SamlSloContext samlSloContext)
		throws Exception {

		String entityId = ParamUtil.getString(request, "entityId");

		SamlSloRequestInfo samlSloRequestInfo =
			samlSloContext.getSamlSloRequestInfo(entityId);

		if (samlSloRequestInfo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"Received logout request for service provider " +
						entityId + " that the user is not logged into");
			}

			JspUtil.dispatch(
				request, response, JspUtil.PATH_PORTAL_SAML_ERROR,
				"single-sign-on", true);

			return;
		}

		if (samlSloRequestInfo.getStatus() ==
				SamlSloRequestInfo.REQUEST_STATUS_SUCCESS) {

			request.setAttribute(
				PortletWebKeys.SAML_SLO_REQUEST_INFO,
				samlSloRequestInfo.toJSONObject());

			JspUtil.dispatch(
				request, response, JspUtil.PATH_PORTAL_SAML_SLO_SP_STATUS,
				"single-sign-on", true);

			return;
		}

		SAMLMessageContext<LogoutResponse, LogoutRequest, NameID>
			samlMessageContext =
				(SAMLMessageContext<LogoutResponse, LogoutRequest, NameID>)
					getSamlMessageContext(request, response, entityId);

		SPSSODescriptor spSsoDescriptor =
			(SPSSODescriptor)samlMessageContext.getPeerEntityRoleMetadata();

		SingleLogoutService singleLogoutService =
			SamlUtil.resolveSingleLogoutService(
				spSsoDescriptor, SAMLConstants.SAML2_SOAP11_BINDING_URI);

		if (singleLogoutService == null) {
			if (_log.isDebugEnabled()) {
				_log.debug("Single logout not supported by " + entityId);
			}

			samlSloRequestInfo.setStatus(
				SamlSloRequestInfo.REQUEST_STATUS_UNSUPPORTED);
			samlSloRequestInfo.setStatusCode(
				StatusCode.UNSUPPORTED_BINDING_URI);

			request.setAttribute(
				PortletWebKeys.SAML_SLO_REQUEST_INFO,
				samlSloRequestInfo.toJSONObject());

			JspUtil.dispatch(
				request, response, JspUtil.PATH_PORTAL_SAML_SLO_SP_STATUS,
				"single-sign-on", true);
		}
		else {
			try {
				sendIdpLogoutRequest(
					request, response, samlSloContext, samlSloRequestInfo);
			}
			catch (Exception e) {
				if (_log.isDebugEnabled()) {
					StringBundler sb = new StringBundler(7);

					sb.append("Unable to perform a single logout for service ");
					sb.append("provider ");
					sb.append(entityId);
					sb.append(" with binding ");
					sb.append(singleLogoutService.getBinding());
					sb.append(" to ");
					sb.append(singleLogoutService.getLocation());

					_log.debug(sb.toString(), e);
				}

				samlSloRequestInfo.setStatus(
					SamlSloRequestInfo.REQUEST_STATUS_FAILED);
				samlSloRequestInfo.setStatusCode(StatusCode.PARTIAL_LOGOUT_URI);

				request.setAttribute(
					PortletWebKeys.SAML_SLO_REQUEST_INFO,
					samlSloRequestInfo.toJSONObject());

				JspUtil.dispatch(
					request, response, JspUtil.PATH_PORTAL_SAML_SLO_SP_STATUS,
					"single-sign-on", true);
			}
		}
	}

	protected void performIdpStatus(
			HttpServletRequest request, HttpServletResponse response,
			SamlSloContext samlSloContext)
		throws Exception {

		for (SamlSloRequestInfo samlRequestInfo :
				samlSloContext.getSamlSloRequestInfos()) {

			int status = samlRequestInfo.getStatus();

			if (status == SamlSloRequestInfo.REQUEST_STATUS_INITIATED) {
				DateTime initiateDateTime = samlRequestInfo.getInitiateTime();

				DateTime expireDateTime = initiateDateTime.plusSeconds(10);

				if (expireDateTime.isBeforeNow()) {
					samlRequestInfo.setStatus(
						SamlSloRequestInfo.REQUEST_STATUS_TIMED_OUT);
					samlRequestInfo.setStatusCode(
						StatusCode.PARTIAL_LOGOUT_URI);
				}
			}
		}

		response.setContentType(ContentTypes.TEXT_JAVASCRIPT);

		Writer writer = response.getWriter();

		JSONObject jsonObject = samlSloContext.toJSONObject();

		writer.write(jsonObject.toString());
	}

	protected void processIdpLogoutRequest(
			HttpServletRequest request, HttpServletResponse response,
			SAMLMessageContext<LogoutRequest, LogoutResponse, NameID>
				samlMessageContext)
		throws Exception {

		SamlSloContext samlSloContext = getSamlSloContext(
			request, samlMessageContext);

		String binding = samlMessageContext.getCommunicationProfileId();

		if (binding.equals(SAMLConstants.SAML2_SOAP11_BINDING_URI)) {
			sendIdpLogoutResponse(
				request, response, StatusCode.UNSUPPORTED_BINDING_URI,
				samlSloContext);
		}
		else if (samlSloContext == null) {
			sendIdpLogoutResponse(
				request, response, StatusCode.UNKNOWN_PRINCIPAL_URI,
				new SamlSloContext(null, samlMessageContext));
		}
		else if (!samlSloContext.getSamlSpEntityIds().isEmpty()) {
			initiateIdpSingleLogout(request, response, samlMessageContext);
		}
		else {
			sendIdpLogoutResponse(
				request, response, StatusCode.SUCCESS_URI, samlSloContext);
		}
	}

	protected void processIdpLogoutResponse(
			HttpServletRequest request, HttpServletResponse response,
			SAMLMessageContext<LogoutResponse, ?, ?> samlMessageContext)
		throws Exception {

		SamlSloContext samlSloContext = getSamlSloContext(request, null);

		if (samlSloContext == null) {
			throw new UnsolicitedLogoutResponseException(
				"Received logout response from " +
					samlMessageContext.getPeerEntityId() +
						" without an active SSO session");
		}

		String entityId = samlMessageContext.getInboundMessageIssuer();

		SamlSloRequestInfo samlSloRequestInfo =
			samlSloContext.getSamlSloRequestInfo(entityId);

		if (samlSloRequestInfo == null) {
			throw new UnsolicitedLogoutResponseException(
				"Received unsolicited logout response from " +
					samlMessageContext.getPeerEntityId());
		}

		LogoutResponse logoutResponse =
			samlMessageContext.getInboundSAMLMessage();

		Status status = logoutResponse.getStatus();

		StatusCode statusCode = status.getStatusCode();

		samlSloRequestInfo.setStatusCode(statusCode.getValue());

		request.setAttribute(
			PortletWebKeys.SAML_SLO_REQUEST_INFO,
			samlSloRequestInfo.toJSONObject());

		JspUtil.dispatch(
			request, response, JspUtil.PATH_PORTAL_SAML_SLO_SP_STATUS,
			"single-sign-on", true);
	}

	protected void processSingleLogoutRequest(
			HttpServletRequest request, HttpServletResponse response,
			SAMLMessageContext<LogoutRequest, LogoutResponse, NameID>
				samlMessageContext)
		throws Exception {

		long companyId = PortalUtil.getCompanyId(request);

		if (SamlUtil.isRoleIdp(companyId)) {
			processIdpLogoutRequest(request, response, samlMessageContext);
		}
		else if (SamlUtil.isRoleSp(companyId)) {
			processSpLogoutRequest(request, response, samlMessageContext);
		}
	}

	protected void processSingleLogoutResponse(
			HttpServletRequest request, HttpServletResponse response,
			SAMLMessageContext<LogoutResponse, ?, ?> samlMessageContext)
		throws Exception {

		long companyId = PortalUtil.getCompanyId(request);

		if (SamlUtil.isRoleIdp(companyId)) {
			processIdpLogoutResponse(request, response, samlMessageContext);
		}
		else if (SamlUtil.isRoleSp(companyId)) {
			processSpLogoutResponse(request, response, samlMessageContext);
		}
	}

	protected void processSpLogoutRequest(
			HttpServletRequest request, HttpServletResponse response,
			SAMLMessageContext<LogoutRequest, LogoutResponse, NameID>
				samlMessageContext)
		throws Exception {

		long companyId = PortalUtil.getCompanyId(request);
		long groupId = SamlUtil.getGroupId(request);

		LogoutRequest logoutRequest =
			samlMessageContext.getInboundSAMLMessage();

		NameID nameId = logoutRequest.getNameID();

		List<SessionIndex> sessionIndexes = logoutRequest.getSessionIndexes();

		String statusCodeURI = StatusCode.SUCCESS_URI;

		if (sessionIndexes.isEmpty()) {
			List<SamlSpSession> samlSpSessions =
				SamlSpSessionLocalServiceUtil.getSamlSpSessions(
					nameId.getValue());

			if (samlSpSessions.isEmpty()) {
				statusCodeURI = StatusCode.UNKNOWN_PRINCIPAL_URI;
			}

			for (SamlSpSession samlSpSession : samlSpSessions) {
				samlSpSession.setTerminated(true);

				SamlSpSessionLocalServiceUtil.updateSamlSpSession(
					samlSpSession);
			}
		}

		for (SessionIndex sessionIndex : sessionIndexes) {
			SamlSpSession samlSpSession =
				SamlSpSessionLocalServiceUtil.fetchSamlSpSessionBySessionIndex(
					sessionIndex.getSessionIndex());

			if (samlSpSession == null) {
				statusCodeURI = StatusCode.UNKNOWN_PRINCIPAL_URI;

				continue;
			}

			if (Validator.equals(
					samlSpSession.getNameIdValue(), nameId.getValue()) &&
				Validator.equals(
					samlSpSession.getNameIdFormat(), nameId.getFormat())) {

				samlSpSession.setTerminated(true);

				SamlSpSessionLocalServiceUtil.updateSamlSpSession(
					samlSpSession);
			}
			else if (!statusCodeURI.equals(StatusCode.PARTIAL_LOGOUT_URI)) {
				statusCodeURI = StatusCode.UNKNOWN_PRINCIPAL_URI;

				continue;
			}

			if (statusCodeURI.equals(StatusCode.UNKNOWN_PRINCIPAL_URI)) {
				statusCodeURI = StatusCode.PARTIAL_LOGOUT_URI;
			}
		}

		samlMessageContext.setOutboundSAMLMessageSigningCredential(
			MetadataManagerUtil.getSigningCredential(companyId, groupId));

		LogoutResponse logoutResponse = OpenSamlUtil.buildLogoutResponse();

		samlMessageContext.setOutboundSAMLMessage(logoutResponse);

		logoutResponse.setID(generateIdentifier(20));
		logoutResponse.setInResponseTo(logoutRequest.getID());
		logoutResponse.setIssueInstant(new DateTime(DateTimeZone.UTC));

		Issuer issuer = OpenSamlUtil.buildIssuer(
			samlMessageContext.getLocalEntityId());

		logoutResponse.setIssuer(issuer);

		StatusCode statusCode = OpenSamlUtil.buildStatusCode(statusCodeURI);

		Status status = OpenSamlUtil.buildStatus(statusCode);

		logoutResponse.setStatus(status);

		logoutResponse.setVersion(SAMLVersion.VERSION_20);

		SSODescriptor ssoDescriptor =
			(SSODescriptor)samlMessageContext.getPeerEntityRoleMetadata();

		SingleLogoutService singleLogoutService =
			SamlUtil.resolveSingleLogoutService(
				ssoDescriptor, samlMessageContext.getCommunicationProfileId());

		samlMessageContext.setPeerEntityEndpoint(singleLogoutService);

		sendSamlMessage(samlMessageContext);
	}

	protected void processSpLogoutResponse(
			HttpServletRequest request, HttpServletResponse response,
			SAMLMessageContext<LogoutResponse, ?, ?> samlMessageContext)
		throws Exception {

		redirectToLogout(request, response);
	}

	protected void redirectToLogout(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		long companyId = PortalUtil.getCompanyId(request);

		if (SamlUtil.isRoleIdp(companyId)) {
			terminateSsoSession(request, response);
		}
		else if (SamlUtil.isRoleSp(companyId)) {
			terminateSpSession(request, response);
		}

		String portalURL = PortalUtil.getPortalURL(request);

		String redirect = portalURL.concat("/c/portal/logout");

		response.sendRedirect(redirect);
	}

	protected void sendAsyncLogoutRequest(
			long companyId,
			long groupId,
			SAMLMessageContext<LogoutResponse, LogoutRequest, NameID>
				samlMessageContext,
			SamlSloContext samlSloContext)
		throws Exception {

		SingleLogoutService singleLogoutService =
			(SingleLogoutService)samlMessageContext.getPeerEntityEndpoint();

		LogoutRequest logoutRequest = OpenSamlUtil.buildLogoutRequest();

		logoutRequest.setDestination(singleLogoutService.getLocation());
		logoutRequest.setID(generateIdentifier(20));
		logoutRequest.setIssueInstant(new DateTime(DateTimeZone.UTC));

		SSODescriptor ssoDescriptor =
			(SSODescriptor)samlMessageContext.getLocalEntityRoleMetadata();

		Issuer issuer = OpenSamlUtil.buildIssuer(ssoDescriptor.getID());

		logoutRequest.setIssuer(issuer);

		logoutRequest.setNameID(samlMessageContext.getSubjectNameIdentifier());

		logoutRequest.setVersion(SAMLVersion.VERSION_20);

		addSessionIndex(logoutRequest, samlSloContext.getSamlSsoSessionId());

		samlMessageContext.setOutboundSAMLMessage(logoutRequest);

		Credential credential = MetadataManagerUtil.getSigningCredential(companyId, groupId);

		samlMessageContext.setOutboundSAMLMessageSigningCredential(credential);

		samlMessageContext.setOutboundSAMLProtocol(SAMLConstants.SAML20P_NS);

		OpenSamlUtil.signObject(logoutRequest, credential);

		SamlBinding samlBinding = getSamlBinding(
			singleLogoutService.getBinding());

		MessageEncoder messageEncoder = samlBinding.getMessageEncoder();

		messageEncoder.encode(samlMessageContext);
	}

	protected void sendIdpLogoutRequest(
			HttpServletRequest request, HttpServletResponse response,
			SamlSloContext samlSloContext,
			SamlSloRequestInfo samlSloRequestInfo)
		throws Exception {

		long companyId = PortalUtil.getCompanyId(request);
		long groupId = SamlUtil.getGroupId(request);
		
		SAMLMessageContext<LogoutResponse, LogoutRequest, NameID>
			samlMessageContext =
				(SAMLMessageContext<LogoutResponse, LogoutRequest, NameID>)
					getSamlMessageContext(
						request, response, samlSloRequestInfo.getEntityId());

		SPSSODescriptor spSsoDescriptor =
			(SPSSODescriptor)
				samlMessageContext.getPeerEntityRoleMetadata();

		SingleLogoutService singleLogoutService =
			SamlUtil.resolveSingleLogoutService(
				spSsoDescriptor, SAMLConstants.SAML2_REDIRECT_BINDING_URI);

		samlMessageContext.setPeerEntityEndpoint(singleLogoutService);

		SamlIdpSpSession samlIdpSpSession =
			samlSloRequestInfo.getSamlIdpSpSession();

		NameID nameId = OpenSamlUtil.buildNameId(
			samlIdpSpSession.getNameIdFormat(),
			samlIdpSpSession.getNameIdValue());

		samlMessageContext.setSubjectNameIdentifier(nameId);

		samlSloRequestInfo.setInitiateTime(new DateTime());
		samlSloRequestInfo.setStatus(
			SamlSloRequestInfo.REQUEST_STATUS_INITIATED);

		String binding = singleLogoutService.getBinding();

		if (binding.equals(SAMLConstants.SAML2_SOAP11_BINDING_URI)) {
			String statusCode = sendSyncLogoutRequest(
				companyId, groupId,
				samlMessageContext, samlSloContext);

			samlSloRequestInfo.setStatusCode(statusCode);

			request.setAttribute(
				PortletWebKeys.SAML_SLO_REQUEST_INFO,
				samlSloRequestInfo.toJSONObject());

			JspUtil.dispatch(
				request, response, JspUtil.PATH_PORTAL_SAML_SLO_SP_STATUS,
				"single-sign-on", true);
		}
		else {
			sendAsyncLogoutRequest(companyId, groupId, samlMessageContext, samlSloContext);
		}
	}

	protected void sendIdpLogoutResponse(
			HttpServletRequest request, HttpServletResponse response,
			String statusCodeURI, SamlSloContext samlSloContext)
		throws Exception {

		long companyId = PortalUtil.getCompanyId(request);
		long groupId = SamlUtil.getGroupId(request);

		SAMLMessageContext<LogoutRequest, LogoutResponse, NameID>
			samlMessageContext = samlSloContext.getSamlMessageContext();

		LogoutResponse logoutResponse = OpenSamlUtil.buildLogoutResponse();

		SSODescriptor ssoDescriptor =
			(SSODescriptor)samlMessageContext.getPeerEntityRoleMetadata();

		SingleLogoutService singleLogoutService =
			SamlUtil.resolveSingleLogoutService(
				ssoDescriptor, samlMessageContext.getCommunicationProfileId());

		logoutResponse.setDestination(singleLogoutService.getLocation());

		logoutResponse.setID(generateIdentifier(20));

		LogoutRequest logoutRequest =
			samlMessageContext.getInboundSAMLMessage();

		logoutResponse.setInResponseTo(logoutRequest.getID());

		logoutResponse.setIssueInstant(new DateTime(DateTimeZone.UTC));

		Issuer issuer = OpenSamlUtil.buildIssuer(
			samlMessageContext.getLocalEntityId());

		logoutResponse.setIssuer(issuer);

		StatusCode statusCode = OpenSamlUtil.buildStatusCode(statusCodeURI);

		Status status = OpenSamlUtil.buildStatus(statusCode);

		logoutResponse.setStatus(status);

		logoutResponse.setVersion(SAMLVersion.VERSION_20);

		HttpServletRequestAdapter httpServletRequestAdapter =
			new HttpServletRequestAdapter(request);

		samlMessageContext.setInboundMessageTransport(
			httpServletRequestAdapter);

		HttpServletResponseAdapter httpServletResponseAdapter =
			new HttpServletResponseAdapter(response, request.isSecure());

		samlMessageContext.setOutboundMessageTransport(
			httpServletResponseAdapter);

		samlMessageContext.setOutboundSAMLMessage(logoutResponse);

		samlMessageContext.setOutboundSAMLMessageSigningCredential(
			MetadataManagerUtil.getSigningCredential(companyId, groupId));
		samlMessageContext.setOutboundSAMLProtocol(SAMLConstants.SAML20P_NS);
		samlMessageContext.setPeerEntityEndpoint(singleLogoutService);

		if (!statusCodeURI.equals(StatusCode.UNSUPPORTED_BINDING_URI)) {
			terminateSsoSession(request, response);

			HttpSession session = request.getSession();

			try {
				session.invalidate();
			}
			catch (Exception e) {
			}
		}

		sendSamlMessage(samlMessageContext);
	}

	protected void sendSpLogoutRequest(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		long companyId = PortalUtil.getCompanyId(request);
		long groupId = SamlUtil.getGroupId(request);

		SamlSpSession samlSpSession = getSamlSpSession(request);

		if ((samlSpSession == null) || samlSpSession.isTerminated()) {
			redirectToLogout(request, response);

			return;
		}

		LogoutRequest logoutRequest = OpenSamlUtil.buildLogoutRequest();

		String entityId = MetadataManagerUtil.getDefaultIdpEntityId(companyId, groupId);

		SAMLMessageContext<SAMLObject, LogoutRequest, SAMLObject>
			samlMessageContext =
				(SAMLMessageContext<SAMLObject, LogoutRequest, SAMLObject>)
					getSamlMessageContext(request, response, entityId);

		IDPSSODescriptor idpSsoDescriptor =
			(IDPSSODescriptor)samlMessageContext.getPeerEntityRoleMetadata();

		SingleLogoutService singleLogoutService =
			SamlUtil.resolveSingleLogoutService(
				idpSsoDescriptor, SAMLConstants.SAML2_REDIRECT_BINDING_URI);

		logoutRequest.setDestination(singleLogoutService.getLocation());

		logoutRequest.setID(generateIdentifier(20));

		DateTime issueInstantDateTime = new DateTime(DateTimeZone.UTC);

		logoutRequest.setIssueInstant(issueInstantDateTime);

		Issuer issuer = OpenSamlUtil.buildIssuer(
			samlMessageContext.getLocalEntityId());

		logoutRequest.setIssuer(issuer);

		String nameIdFormat = samlSpSession.getNameIdFormat();
		String nameIdValue = samlSpSession.getNameIdValue();

		NameID nameId = OpenSamlUtil.buildNameId(nameIdFormat, nameIdValue);

		logoutRequest.setNameID(nameId);

		logoutRequest.setVersion(SAMLVersion.VERSION_20);

		samlMessageContext.setOutboundSAMLMessage(logoutRequest);

		samlMessageContext.setOutboundSAMLMessageSigningCredential(
			MetadataManagerUtil.getSigningCredential(companyId, groupId));
		samlMessageContext.setPeerEntityEndpoint(singleLogoutService);

		sendSamlMessage(samlMessageContext);
	}

	protected String sendSyncLogoutRequest(
			long companyId,
			long groupId,
			SAMLMessageContext<LogoutResponse, LogoutRequest, NameID>
				samlMessageContext,
			SamlSloContext samlSloContext)
		throws Exception {

		SingleLogoutService singleLogoutService =
			(SingleLogoutService)samlMessageContext.getPeerEntityEndpoint();

		PostMethod postMethod = new PostMethod(
			singleLogoutService.getLocation());

		HttpClientInTransport httpClientInTransport = new HttpClientInTransport(
			postMethod, singleLogoutService.getLocation());

		samlMessageContext.setInboundMessageTransport(httpClientInTransport);

		HttpClientOutTransport httpClientOutTransport =
			new HttpClientOutTransport(postMethod);

		samlMessageContext.setOutboundMessageTransport(httpClientOutTransport);

		LogoutRequest logoutRequest = OpenSamlUtil.buildLogoutRequest();

		logoutRequest.setDestination(singleLogoutService.getLocation());
		logoutRequest.setID(generateIdentifier(20));
		logoutRequest.setIssueInstant(new DateTime(DateTimeZone.UTC));

		SSODescriptor ssoDescriptor =
			(SSODescriptor)samlMessageContext.getLocalEntityRoleMetadata();

		Issuer issuer = OpenSamlUtil.buildIssuer(ssoDescriptor.getID());

		logoutRequest.setIssuer(issuer);

		logoutRequest.setNameID(samlMessageContext.getSubjectNameIdentifier());

		logoutRequest.setVersion(SAMLVersion.VERSION_20);

		addSessionIndex(logoutRequest, samlSloContext.getSamlSsoSessionId());

		samlMessageContext.setOutboundSAMLMessage(logoutRequest);

		Credential credential = MetadataManagerUtil.getSigningCredential(companyId, groupId);

		samlMessageContext.setOutboundSAMLMessageSigningCredential(credential);

		samlMessageContext.setOutboundSAMLProtocol(SAMLConstants.SAML20P_NS);

		OpenSamlUtil.signObject(logoutRequest, credential);

		SamlBinding samlBinding = getSamlBinding(
			SAMLConstants.SAML2_SOAP11_BINDING_URI);

		MessageEncoder messageEncoder = samlBinding.getMessageEncoder();

		messageEncoder.encode(samlMessageContext);

		SecurityPolicyResolver securityPolicyResolver =
			MetadataManagerUtil.getSecurityPolicyResolver(
				companyId, groupId,
				samlBinding.getCommunicationProfileId(), true);

		samlMessageContext.setSecurityPolicyResolver(securityPolicyResolver);

		MessageDecoder messageDecoder = samlBinding.getMessageDecoder();

		messageDecoder.decode(samlMessageContext);

		LogoutResponse logoutResponse =
			samlMessageContext.getInboundSAMLMessage();

		Status status = logoutResponse.getStatus();

		StatusCode statusCode = status.getStatusCode();

		return statusCode.getValue();
	}

	protected void terminateSpSession(
		HttpServletRequest request, HttpServletResponse response) {

		try {
			SamlSpSession samlSpSession = getSamlSpSession(request);

			if (samlSpSession != null) {
				SamlSpSessionLocalServiceUtil.deleteSamlSpSession(
					samlSpSession);

				Cookie cookie = new Cookie(
					PortletWebKeys.SAML_SP_SESSION_KEY, StringPool.BLANK);

				cookie.setMaxAge(0);

				if (Validator.isNull(PortalUtil.getPathContext())) {
					cookie.setPath(StringPool.SLASH);
				}
				else {
					cookie.setPath(PortalUtil.getPathContext());
				}

				cookie.setSecure(request.isSecure());

				response.addCookie(cookie);
			}
		}
		catch (SystemException se) {
			_log.error(se, se);
		}
	}

	protected void terminateSsoSession(
		HttpServletRequest request, HttpServletResponse response) {

		String samlSsoSessionId = getSamlSsoSessionId(request);

		if (Validator.isNotNull(samlSsoSessionId)) {
			try {
				SamlIdpSsoSession samlIdpSsoSession =
					SamlIdpSsoSessionLocalServiceUtil.fetchSamlIdpSso(
						samlSsoSessionId);

				if (samlIdpSsoSession != null) {
					SamlIdpSsoSessionLocalServiceUtil.deleteSamlIdpSsoSession(
						samlIdpSsoSession);

					List<SamlIdpSpSession> samlIdpSpSessions =
						SamlIdpSpSessionLocalServiceUtil.getSamlIdpSpSessions(
							samlIdpSsoSession.getSamlIdpSsoSessionId());

					for (SamlIdpSpSession samlIdpSpSession :
							samlIdpSpSessions) {

						SamlIdpSpSessionLocalServiceUtil.deleteSamlIdpSpSession(
							samlIdpSpSession);
					}
				}
			}
			catch (SystemException se) {
				_log.error(se, se);
			}
		}

		Cookie cookie = new Cookie(
			PortletWebKeys.SAML_SSO_SESSION_ID, StringPool.BLANK);

		cookie.setMaxAge(0);

		if (Validator.isNull(PortalUtil.getPathContext())) {
			cookie.setPath(StringPool.SLASH);
		}
		else {
			cookie.setPath(PortalUtil.getPathContext());
		}

		cookie.setSecure(request.isSecure());

		response.addCookie(cookie);
	}

	private static Log _log = LogFactoryUtil.getLog(
		SingleLogoutProfileImpl.class);

}