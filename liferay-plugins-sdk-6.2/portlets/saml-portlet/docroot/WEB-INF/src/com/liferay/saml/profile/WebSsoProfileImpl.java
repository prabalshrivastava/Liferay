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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.saml.AssertionException;
import com.liferay.saml.AudienceException;
import com.liferay.saml.DestinationException;
import com.liferay.saml.ExpiredException;
import com.liferay.saml.InResponseToException;
import com.liferay.saml.IssuerException;
import com.liferay.saml.NoSuchIdpSpSessionException;
import com.liferay.saml.ReplayException;
import com.liferay.saml.SamlException;
import com.liferay.saml.SamlSsoRequestContext;
import com.liferay.saml.SignatureException;
import com.liferay.saml.StatusException;
import com.liferay.saml.SubjectException;
import com.liferay.saml.binding.SamlBinding;
import com.liferay.saml.metadata.MetadataManagerUtil;
import com.liferay.saml.model.SamlIdpSsoSession;
import com.liferay.saml.model.SamlSpAuthRequest;
import com.liferay.saml.model.SamlSpMessage;
import com.liferay.saml.model.SamlSpSession;
import com.liferay.saml.resolver.AttributeResolver;
import com.liferay.saml.resolver.AttributeResolverFactory;
import com.liferay.saml.resolver.NameIdResolver;
import com.liferay.saml.resolver.NameIdResolverFactory;
import com.liferay.saml.resolver.UserResolverUtil;
import com.liferay.saml.service.SamlIdpSpSessionLocalServiceUtil;
import com.liferay.saml.service.SamlIdpSsoSessionLocalServiceUtil;
import com.liferay.saml.service.SamlSpAuthRequestLocalServiceUtil;
import com.liferay.saml.service.SamlSpMessageLocalServiceUtil;
import com.liferay.saml.service.SamlSpSessionLocalServiceUtil;
import com.liferay.saml.util.OpenSamlUtil;
import com.liferay.saml.util.PortletPropsKeys;
import com.liferay.saml.util.PortletWebKeys;
import com.liferay.saml.util.SamlConfigUtil;
import com.liferay.saml.util.SamlUtil;
import com.sambaash.platform.saml.util.SamlUserUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.opensaml.common.SAMLObject;
import org.opensaml.common.SAMLVersion;
import org.opensaml.common.binding.SAMLMessageContext;
import org.opensaml.common.xml.SAMLConstants;
import org.opensaml.saml2.core.Assertion;
import org.opensaml.saml2.core.Attribute;
import org.opensaml.saml2.core.AttributeStatement;
import org.opensaml.saml2.core.Audience;
import org.opensaml.saml2.core.AudienceRestriction;
import org.opensaml.saml2.core.AuthnContext;
import org.opensaml.saml2.core.AuthnContextClassRef;
import org.opensaml.saml2.core.AuthnRequest;
import org.opensaml.saml2.core.AuthnStatement;
import org.opensaml.saml2.core.Conditions;
import org.opensaml.saml2.core.Issuer;
import org.opensaml.saml2.core.NameID;
import org.opensaml.saml2.core.NameIDPolicy;
import org.opensaml.saml2.core.NameIDType;
import org.opensaml.saml2.core.Response;
import org.opensaml.saml2.core.Status;
import org.opensaml.saml2.core.StatusCode;
import org.opensaml.saml2.core.Subject;
import org.opensaml.saml2.core.SubjectConfirmation;
import org.opensaml.saml2.core.SubjectConfirmationData;
import org.opensaml.saml2.metadata.AssertionConsumerService;
import org.opensaml.saml2.metadata.IDPSSODescriptor;
import org.opensaml.saml2.metadata.SPSSODescriptor;
import org.opensaml.saml2.metadata.SingleSignOnService;
import org.opensaml.security.MetadataCriteria;
import org.opensaml.security.SAMLSignatureProfileValidator;
import org.opensaml.ws.transport.http.HttpServletRequestAdapter;
import org.opensaml.ws.transport.http.HttpServletResponseAdapter;
import org.opensaml.xml.security.CriteriaSet;
import org.opensaml.xml.security.SecurityException;
import org.opensaml.xml.security.credential.Credential;
import org.opensaml.xml.security.credential.UsageType;
import org.opensaml.xml.security.criteria.EntityIDCriteria;
import org.opensaml.xml.security.criteria.UsageCriteria;
import org.opensaml.xml.security.trust.TrustEngine;
import org.opensaml.xml.signature.Signature;
import org.opensaml.xml.signature.SignatureTrustEngine;

/**
 * @author Mika Koivisto
 */
public class WebSsoProfileImpl extends BaseProfile implements WebSsoProfile {


	//@Override
	public void processAuthnRequest(
			HttpServletRequest request, HttpServletResponse response)
		throws PortalException, SystemException {

		try {
			doProcessAuthnRequest(request, response);
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


	//@Override
	public void processResponse(
			HttpServletRequest request, HttpServletResponse response)
		throws PortalException, SystemException {

		try {
			doProcessResponse(request, response);
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


	//@Override
	public void sendAuthnRequest(
			HttpServletRequest request, HttpServletResponse response,
			String relayState)
		throws PortalException, SystemException {

		try {
			doSendAuthnRequest(request, response, relayState);
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

	protected void addSamlSsoSession(
			HttpServletRequest request, HttpServletResponse response,
			SamlSsoRequestContext samlSsoRequestContext, NameID nameId)
		throws Exception {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			request);

		SamlIdpSsoSession samlIdpSsoSession =
			SamlIdpSsoSessionLocalServiceUtil.addSamlIdpSsoSession(
				samlSsoRequestContext.getSamlSsoSessionId(), serviceContext);

		SAMLMessageContext<AuthnRequest, Response, NameID> samlMessageContext =
			samlSsoRequestContext.getSAMLMessageContext();

		SamlIdpSpSessionLocalServiceUtil.addSamlIdpSpSession(
			samlIdpSsoSession.getSamlIdpSsoSessionId(),
			samlMessageContext.getPeerEntityId(), nameId.getFormat(),
			nameId.getValue(), serviceContext);

		Cookie cookie = new Cookie(
			PortletWebKeys.SAML_SSO_SESSION_ID,
			samlSsoRequestContext.getSamlSsoSessionId());

		cookie.setMaxAge(-1);

		if (Validator.isNull(PortalUtil.getPathContext())) {
			cookie.setPath(StringPool.SLASH);
		}
		else {
			cookie.setPath(PortalUtil.getPathContext());
		}

		cookie.setSecure(request.isSecure());

		response.addCookie(cookie);
	}

	protected SamlSsoRequestContext decodeAuthnRequest(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		HttpSession session = request.getSession();
		
		long companyId = PortalUtil.getCompanyId(request);
		long groupId = SamlUtil.getGroupId(request);

		SamlSsoRequestContext samlSsoRequestContext =
			(SamlSsoRequestContext)session.getAttribute(
				PortletWebKeys.SAML_SSO_REQUEST_CONTEXT);

		if (samlSsoRequestContext != null) {
			session.removeAttribute(PortletWebKeys.SAML_SSO_REQUEST_CONTEXT);

			SAMLMessageContext<AuthnRequest, Response, NameID>
				samlMessageContext =
					samlSsoRequestContext.getSAMLMessageContext();

			HttpServletRequestAdapter inHttpServletRequestAdapter =
				new HttpServletRequestAdapter(request);

			samlMessageContext.setInboundMessageTransport(
				inHttpServletRequestAdapter);

			HttpServletResponseAdapter outHttpServletRequestAdapter =
				new HttpServletResponseAdapter(response, request.isSecure());

			samlMessageContext.setOutboundMessageTransport(
				outHttpServletRequestAdapter);

			String samlSsoSessionId = getSamlSsoSessionId(request);

			if (Validator.isNotNull(samlSsoSessionId)) {
				samlSsoRequestContext.setSamlSsoSessionId(samlSsoSessionId);
			}
			else {
				samlSsoRequestContext.setNewSession(true);
				samlSsoRequestContext.setSamlSsoSessionId(
					generateIdentifier(30));
			}

			samlSsoRequestContext.setStage(
				SamlSsoRequestContext.STAGE_AUTHENTICATED);

			long userId = PortalUtil.getUserId(request);

			samlSsoRequestContext.setUserId(userId);

			return samlSsoRequestContext;
		}

		SAMLMessageContext<AuthnRequest, Response, NameID> samlMessageContext =
			null;

		SamlBinding samlBinding = null;

		if (request.getMethod().equalsIgnoreCase("GET")) {
			samlBinding = getSamlBinding(
				SAMLConstants.SAML2_REDIRECT_BINDING_URI);
		}
		else {
			samlBinding = getSamlBinding(SAMLConstants.SAML2_POST_BINDING_URI);
		}

		String entityId = ParamUtil.getString(request, "entityId");
		String samlRequest = ParamUtil.getString(request, "SAMLRequest");

		if (Validator.isNotNull(entityId) && Validator.isNull(samlRequest)) {
			samlMessageContext =
				(SAMLMessageContext<AuthnRequest, Response, NameID>)
					getSamlMessageContext(request, response, entityId);

			samlMessageContext.setCommunicationProfileId(
				samlBinding.getCommunicationProfileId());

			String relayState = ParamUtil.getString(request, "RelayState");

			samlMessageContext.setRelayState(relayState);
		}
		else {
			samlMessageContext =
				(SAMLMessageContext<AuthnRequest, Response, NameID>)
					decodeSamlMessage(
						request, response, samlBinding,
						MetadataManagerUtil.isWantAuthnRequestSigned(companyId));
		}

		samlSsoRequestContext = new SamlSsoRequestContext(samlMessageContext);

		String samlSsoSessionId = getSamlSsoSessionId(request);

		if (Validator.isNotNull(samlSsoSessionId)) {
			samlSsoRequestContext.setSamlSsoSessionId(samlSsoSessionId);
		}
		else {
			samlSsoRequestContext.setNewSession(true);
			samlSsoRequestContext.setSamlSsoSessionId(generateIdentifier(30));
		}

		samlSsoRequestContext.setStage(SamlSsoRequestContext.STAGE_INITIAL);

		long userId = PortalUtil.getUserId(request);

		samlSsoRequestContext.setUserId(userId);

		return samlSsoRequestContext;
	}

	protected void doProcessAuthnRequest(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		
		long companyId = PortalUtil.getCompanyId(request);
		long groupId = SamlUtil.getGroupId(request);

		SamlSsoRequestContext samlSsoRequestContext = decodeAuthnRequest(
			request, response);

		SAMLMessageContext<AuthnRequest, Response, NameID> samlMessageContext =
			samlSsoRequestContext.getSAMLMessageContext();

		AuthnRequest authnRequest = samlMessageContext.getInboundSAMLMessage();
		User user = samlSsoRequestContext.getUser();

		if ((authnRequest != null) && authnRequest.isPassive() &&
			(user == null)) {

			sendFailureResponse(
				companyId, groupId,
				samlSsoRequestContext, StatusCode.NO_PASSIVE_URI);

			return;
		}

		boolean sessionExpired = false;

		if (!samlSsoRequestContext.isNewSession()) {
			String samlSsoSessionId =
				samlSsoRequestContext.getSamlSsoSessionId();

			SamlIdpSsoSession samlIdpSsoSession =
				SamlIdpSsoSessionLocalServiceUtil.fetchSamlIdpSso(
					samlSsoSessionId);

			if (samlIdpSsoSession != null) {
				sessionExpired = samlIdpSsoSession.isExpired();
			}
			else {
				samlSsoSessionId = null;

				samlSsoRequestContext.setSamlSsoSessionId(null);
			}

			if (sessionExpired || Validator.isNull(samlSsoSessionId)) {
				Cookie cookie = new Cookie(
					PortletWebKeys.SAML_SSO_SESSION_ID, StringPool.BLANK);

				cookie.setMaxAge(0);
				cookie.setPath(StringPool.SLASH);
				cookie.setSecure(request.isSecure());

				response.addCookie(cookie);

				samlSsoRequestContext.setNewSession(true);
				samlSsoRequestContext.setSamlSsoSessionId(
					generateIdentifier(30));
			}
		}

		if (sessionExpired || (user == null) ||
			((authnRequest != null) && authnRequest.isForceAuthn() &&
			 (user != null) &&
			 (samlSsoRequestContext.getStage() ==
				 SamlSsoRequestContext.STAGE_INITIAL))) {

			boolean forceAuthn = false;

			if (sessionExpired || ((authnRequest != null) &&
				 authnRequest.isForceAuthn())) {

				forceAuthn = true;
			}

			redirectToLogin(
				request, response, samlSsoRequestContext, forceAuthn);
		}
		else {
			sendSuccessResponse(request, response, companyId, groupId, samlSsoRequestContext);
		}
	}

	protected void doProcessResponse(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		_log.debug("doProcessResponse");

		long companyId = PortalUtil.getCompanyId(request);
		long groupId = SamlUtil.getGroupId(request);
		
		_log.debug(("decode the Saml message"));
		SAMLMessageContext<Response, SAMLObject, NameID> samlMessageContext =
			(SAMLMessageContext<Response, SAMLObject, NameID>)decodeSamlMessage(
				request, 
				response,
				getSamlBinding(SAMLConstants.SAML2_POST_BINDING_URI), 
				MetadataManagerUtil.isSignAuthnRequests(companyId, groupId));

		_log.debug("Extract the response");
		Response samlResponse = samlMessageContext.getInboundSAMLMessage();

		_log.debug("Get the response status");
		Status status = samlResponse.getStatus();

		_log.debug("Get the status code");
		StatusCode statusCode = status.getStatusCode();

		_log.debug("Get the status code URI");
		String statusCodeURI = statusCode.getValue();

		_log.debug("Status code URI = " + statusCodeURI);
		if (!statusCodeURI.equals(StatusCode.SUCCESS_URI)) {
			throw new StatusException(statusCode.getValue());
		}

		_log.debug("verify in response to");
		verifyInResponseTo(samlResponse);
		_log.debug("verify destination");
		verifyDestination(samlMessageContext, samlResponse.getDestination());
		_log.debug("verify issuer");
		verifyIssuer(samlMessageContext, samlResponse.getIssuer());

		Assertion assertion = null;

		SignatureTrustEngine signatureTrustEngine =
			MetadataManagerUtil.getSignatureTrustEngine(companyId, groupId);

		List<Attribute> attributes = new ArrayList<Attribute>();

		for (Assertion curAssertion : samlResponse.getAssertions()) {
			try {
				_log.debug("verify assertion");
				verifyAssertion(
					companyId, groupId,
					curAssertion, samlMessageContext, signatureTrustEngine);
			}
			catch (SamlException samle) {
				if (_log.isDebugEnabled()) {
					_log.debug(
						"Rejecting assertion " + curAssertion.getID(), samle);
				}

				continue;
			}

			List<AuthnStatement> authnStatements =
				curAssertion.getAuthnStatements();

			if (!authnStatements.isEmpty()) {
				_log.debug("get the subject from the authnstatement");
				Subject subject = curAssertion.getSubject();

				if ((subject != null) &&
					(subject.getSubjectConfirmations() != null)) {

					for (SubjectConfirmation subjectConfirmation :
							subject.getSubjectConfirmations()) {

						if (SubjectConfirmation.METHOD_BEARER.equals(
								subjectConfirmation.getMethod())) {

							assertion = curAssertion;

							break;
						}
					}
				}
			}

			if (assertion != null) {
				_log.debug("assertion found");
				for (AttributeStatement attributeStatement :
						curAssertion.getAttributeStatements()) {

					for (Attribute attribute :
							attributeStatement.getAttributes()) {

						attributes.add(attribute);
					}
				}

				break;
			}
		}

		if (assertion == null) {
			_log.debug("assertion not found");
			throw new AssertionException(
				"Response does not contain any acceptable assertions");
		}

		_log.debug("get the nameID");
		NameID nameId = samlMessageContext.getSubjectNameIdentifier();

		if (nameId == null) {
			throw new SamlException("Name ID not present in subject");
		}

		if (_log.isDebugEnabled()) {
			_log.debug("SAML authenticated user " + nameId.getValue());
		}

		_log.debug("convert the assertion into an XML string");
		String assertionXml = OpenSamlUtil.marshallElement(assertion.getDOM());
		_log.debug("assertion = \n" + assertionXml);

		_log.debug("get the authn statements");
		List<AuthnStatement> authnStatements = assertion.getAuthnStatements();
		_log.debug(String.format("Found %s statements", authnStatements.size()));

		AuthnStatement authnStatement = authnStatements.get(0);

		_log.debug("get the session index");
		String sessionIndex = authnStatement.getSessionIndex();
		_log.debug("session index = " + sessionIndex);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			request);
		serviceContext.setCompanyId(companyId);
		serviceContext.setScopeGroupId(groupId);

		_log.debug("Resolve the user");
		User user = UserResolverUtil.resolveUser(
			companyId, groupId,
			assertion, samlMessageContext, serviceContext);
		if (user == null)
			_log.error("Unable to resolve user");

		SamlUserUtil.setLogonInformation(request, response, user);
		
		serviceContext.setUserId(user.getUserId());

		HttpSession session = request.getSession();

		SamlSpSession samlSpSession = getSamlSpSession(request);

		if (samlSpSession != null) {
			_log.debug("update saml sp session");
			SamlSpSessionLocalServiceUtil.updateSamlSpSession(
				samlSpSession.getSamlSpSessionId(),
				samlSpSession.getSamlSpSessionKey(), assertionXml,
				session.getId(), nameId.getFormat(), nameId.getValue(),
				sessionIndex, serviceContext);
		}
		else {
			_log.debug("add a saml sp session");
			String samlSpSessionKey = generateIdentifier(30);

			samlSpSession = SamlSpSessionLocalServiceUtil.addSamlSpSession(
				samlSpSessionKey, assertionXml, session.getId(),
				nameId.getFormat(), nameId.getValue(), sessionIndex,
				serviceContext);
		}

		session.setAttribute(
			PortletWebKeys.SAML_SP_SESSION_KEY,
			samlSpSession.getSamlSpSessionKey());

		Cookie cookie = new Cookie(
			PortletWebKeys.SAML_SP_SESSION_KEY,
			samlSpSession.getSamlSpSessionKey());

		cookie.setMaxAge(-1);

		if (Validator.isNull(PortalUtil.getPathContext())) {
			cookie.setPath(StringPool.SLASH);
		}
		else {
			cookie.setPath(PortalUtil.getPathContext());
		}

		cookie.setSecure(request.isSecure());

		response.addCookie(cookie);

//		StringBundler sb = new StringBundler(3);
//
//		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
//			WebKeys.THEME_DISPLAY);
//
//		sb.append(themeDisplay.getPathMain());
//
//		String relayState = PortalUtil.escapeRedirect(
//				samlMessageContext.getRelayState());
		
		String relayState = retrieveLandingPage(samlMessageContext, companyId,
				groupId);

//		sb.append(HttpUtil.encodeURL(relayState));

//		response.sendRedirect(sb.toString());
		_log.debug("redirect to " + relayState);
		response.sendRedirect(SamlUtil.getAuthRedirect(groupId, HttpUtil.encodeURL(relayState)));
	}


//	private String retrieveRelayState(
//			SAMLMessageContext<Response, SAMLObject, NameID> samlMessageContext,
//			long companyId, long groupId) {
//		String relayState = samlMessageContext.getRelayState();
//
//		if (Validator.isNull(relayState)) {
//			_log.debug("relay state is null, get the home URL");
//			relayState = SamlConfigUtil.getString(
//					companyId, groupId, 
//					PortletPropsKeys.SAML_DEFAULT_LANDING_PAGE);
//		}
//		return relayState;
//	}

	private String retrieveLandingPage(
			SAMLMessageContext<Response, SAMLObject, NameID> samlMessageContext,
			long companyId, long groupId) {
		String relayState = SamlConfigUtil.getString(
				companyId, groupId, 
				PortletPropsKeys.SAML_DEFAULT_LANDING_PAGE);

		if (Validator.isNull(relayState)) {
			_log.debug("relay state is null, get the home URL");
			relayState = samlMessageContext.getRelayState();
			if (Validator.isNull(relayState)) {
				relayState = "/";
			}
		}
		return relayState;
	}

	protected void doSendAuthnRequest(
			HttpServletRequest request, HttpServletResponse response,
			String relayState)
		throws Exception {

		_log.debug("Send an authentication request");
		long companyId = PortalUtil.getCompanyId(request);
		long groupId = SamlUtil.getGroupId(request);
		
		String entityId = MetadataManagerUtil.getDefaultIdpEntityId(companyId, groupId);
		_log.debug("The default entity ID = " + entityId);

		SAMLMessageContext<SAMLObject, AuthnRequest, SAMLObject>
			samlMessageContext =
				(SAMLMessageContext<SAMLObject, AuthnRequest, SAMLObject>)
					getSamlMessageContext(request, response, entityId);
		_log.debug("Retrieved saml message context");

		SPSSODescriptor spSsoDescriptor =
			(SPSSODescriptor)samlMessageContext.getLocalEntityRoleMetadata();
		_log.debug("Retrieved Sp sso descriptor");

		AssertionConsumerService assertionConsumerService =
			SamlUtil.getAssertionConsumerServiceForBinding(
				spSsoDescriptor, SAMLConstants.SAML2_POST_BINDING_URI);
		_log.debug("Retrieved assertion consumer service");

		IDPSSODescriptor idpSsoDescriptor =
			(IDPSSODescriptor)samlMessageContext.getPeerEntityRoleMetadata();
		_log.debug("Retrieved IdP sso descriptor");

		SingleSignOnService singleSignOnService =
			SamlUtil.resolveSingleSignOnService(
				idpSsoDescriptor, SAMLConstants.SAML2_POST_BINDING_URI);
		_log.debug("Retieved ssingle signon service");

		NameIDPolicy nameIdPolicy = OpenSamlUtil.buildNameIdPolicy();
		_log.debug("Built the name ID policy");;

		nameIdPolicy.setAllowCreate(true);
		nameIdPolicy.setFormat(MetadataManagerUtil.getNameIdFormat(companyId, groupId));

		AuthnRequest authnRequest = OpenSamlUtil.buildAuthnRequest(
			spSsoDescriptor, assertionConsumerService, singleSignOnService,
			nameIdPolicy);
		_log.debug("Built the authentication request");

		authnRequest.setID(generateIdentifier(20));

		samlMessageContext.setOutboundSAMLMessage(authnRequest);
		_log.debug("Set the authentication request as the outbound SAML message");

		if (spSsoDescriptor.isAuthnRequestsSigned() ||
			idpSsoDescriptor.getWantAuthnRequestsSigned()) {

			Credential credential = MetadataManagerUtil.getSigningCredential(companyId, groupId);
			_log.debug("Retrieved the signing credentialsa");

			samlMessageContext.setOutboundSAMLMessageSigningCredential(
				credential);
			_log.debug("Added the credentials to the outbound message");

			OpenSamlUtil.signObject(authnRequest, credential);
			_log.debug("Signed the message with the credentials");
		}

		samlMessageContext.setPeerEntityEndpoint(singleSignOnService);
		_log.debug("Set the peer entity endpoint");
		samlMessageContext.setRelayState(relayState);
		_log.debug("Set the message relay state");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			request);

		SamlSpAuthRequestLocalServiceUtil.addSamlSpAuthRequest(
			samlMessageContext.getPeerEntityId(), authnRequest.getID(),
			serviceContext);

		_log.debug("Send the message");
		sendSamlMessage(samlMessageContext);
		_log.debug("Message sent");
	}

	protected Assertion getSuccessAssertion(
		long companyId,
		long groupId,
		SamlSsoRequestContext samlSsoRequestContext,
		AssertionConsumerService assertionConsumerService, NameID nameId) {

		SAMLMessageContext<AuthnRequest, Response, NameID> samlMessageContext =
			samlSsoRequestContext.getSAMLMessageContext();

		Assertion assertion = OpenSamlUtil.buildAssertion();

		DateTime issueInstantDateTime = new DateTime(DateTimeZone.UTC);

		SubjectConfirmationData subjectConfirmationData =
			getSuccessSubjectConfirmationData(
				companyId, groupId,
				samlSsoRequestContext, assertionConsumerService,
				issueInstantDateTime);

		Conditions conditions = getSuccessConditions(
			samlSsoRequestContext, issueInstantDateTime,
			subjectConfirmationData.getNotOnOrAfter());

		assertion.setConditions(conditions);

		assertion.setID(generateIdentifier(20));
		assertion.setIssueInstant(issueInstantDateTime);

		Issuer issuer = OpenSamlUtil.buildIssuer(
			samlMessageContext.getLocalEntityId());

		assertion.setIssuer(issuer);

		Subject subject = getSuccessSubject(
			samlSsoRequestContext, assertionConsumerService, nameId,
			subjectConfirmationData);

		assertion.setSubject(subject);

		assertion.setVersion(SAMLVersion.VERSION_20);

		List<AuthnStatement> authnStatements = assertion.getAuthnStatements();

		authnStatements.add(
			getSuccessAuthnStatement(samlSsoRequestContext, assertion));

		boolean attributesEnabled = MetadataManagerUtil.isAttributesEnabled(
			companyId,
			samlMessageContext.getPeerEntityId());

		if (!attributesEnabled) {
			return assertion;
		}

		AttributeResolver attributeResolver =
			AttributeResolverFactory.getAttributeResolver(
				samlMessageContext.getPeerEntityId());

		User user = samlSsoRequestContext.getUser();

		List<Attribute> attributes = attributeResolver.resolve(
			companyId, user, samlMessageContext);

		if (attributes.isEmpty()) {
			return assertion;
		}

		List<AttributeStatement> attributeStatements =
			assertion.getAttributeStatements();

		AttributeStatement attributeStatement =
			OpenSamlUtil.buildAttributeStatement();

		attributeStatements.add(attributeStatement);

		List<Attribute> attributeStatementAttributes =
			attributeStatement.getAttributes();

		attributeStatementAttributes.addAll(attributes);

		return assertion;
	}

	protected AudienceRestriction getSuccessAudienceRestriction(
		String entityId) {

		AudienceRestriction audienceRestriction =
			OpenSamlUtil.buildAudienceRestriction();

		List<Audience> audiences = audienceRestriction.getAudiences();

		Audience audience = OpenSamlUtil.buildAudience();

		audience.setAudienceURI(entityId);

		audiences.add(audience);

		return audienceRestriction;
	}

	protected AuthnContext getSuccessAuthnContext() {
		AuthnContext authnContext = OpenSamlUtil.buildAuthnContext();

		AuthnContextClassRef authnContextClassRef =
			OpenSamlUtil.buildAuthnContextClassRef();

		authnContextClassRef.setAuthnContextClassRef(
			AuthnContext.UNSPECIFIED_AUTHN_CTX);

		authnContext.setAuthnContextClassRef(authnContextClassRef);

		return authnContext;
	}

	protected AuthnStatement getSuccessAuthnStatement(
		SamlSsoRequestContext samlSsoRequestContext, Assertion assertion) {

		AuthnStatement authnStatement = OpenSamlUtil.buildAuthnStatement();

		AuthnContext authnContext = getSuccessAuthnContext();

		authnStatement.setAuthnContext(authnContext);

		authnStatement.setAuthnInstant(assertion.getIssueInstant());
		authnStatement.setSessionIndex(
			samlSsoRequestContext.getSamlSsoSessionId());

		return authnStatement;
	}

	protected Conditions getSuccessConditions(
		SamlSsoRequestContext samlSsoRequestContext, DateTime notBeforeDateTime,
		DateTime notOnOrAfterDateTime) {

		Conditions conditions = OpenSamlUtil.buildConditions();

		conditions.setNotBefore(notBeforeDateTime);
		conditions.setNotOnOrAfter(notOnOrAfterDateTime);

		List<AudienceRestriction> audienceRestrictions =
			conditions.getAudienceRestrictions();

		SAMLMessageContext<AuthnRequest, Response, NameID> samlMessageContext =
			samlSsoRequestContext.getSAMLMessageContext();

		AudienceRestriction audienceRestriction = getSuccessAudienceRestriction(
			samlMessageContext.getPeerEntityId());

		audienceRestrictions.add(audienceRestriction);

		return conditions;
	}

	protected NameID getSuccessNameId(
			long companyId,
			long groupId,
			SamlSsoRequestContext samlSsoRequestContext)
		throws Exception {

		SAMLMessageContext<AuthnRequest, Response, NameID> samlMessageContext =
			samlSsoRequestContext.getSAMLMessageContext();

		NameIdResolver nameIDResolver = NameIdResolverFactory.getNameIdResolver(
			samlMessageContext.getPeerEntityId());

		User user = samlSsoRequestContext.getUser();

		NameIDPolicy nameIDPolicy = null;

		AuthnRequest authnRequest = samlMessageContext.getInboundSAMLMessage();

		if (authnRequest != null) {
			nameIDPolicy = authnRequest.getNameIDPolicy();
		}

		return nameIDResolver.resolve(
			user, companyId, groupId, samlMessageContext.getPeerEntityId(), nameIDPolicy);
	}

	protected Response getSuccessResponse(
		SamlSsoRequestContext samlSsoRequestContext,
		AssertionConsumerService assertionConsumerService,
		Assertion assertion) {

		Response response = OpenSamlUtil.buildResponse();

		response.setDestination(assertionConsumerService.getLocation());
		response.setID(generateIdentifier(20));

		SAMLMessageContext<AuthnRequest, Response, NameID> samlMessageContext =
			samlSsoRequestContext.getSAMLMessageContext();

		if (Validator.isNotNull(samlMessageContext.getInboundSAMLMessageId())) {
			response.setInResponseTo(
				samlMessageContext.getInboundSAMLMessageId());
		}

		response.setIssueInstant(assertion.getIssueInstant());

		Issuer issuer = OpenSamlUtil.buildIssuer(
			samlMessageContext.getLocalEntityId());

		response.setIssuer(issuer);

		StatusCode statusCode = OpenSamlUtil.buildStatusCode(
			StatusCode.SUCCESS_URI);

		Status status = OpenSamlUtil.buildStatus(statusCode);

		response.setStatus(status);

		response.setVersion(SAMLVersion.VERSION_20);

		List<Assertion> assertions = response.getAssertions();

		assertions.add(assertion);

		return response;
	}

	protected Subject getSuccessSubject(
		SamlSsoRequestContext samlSsoRequestContext,
		AssertionConsumerService assertionConsumerService, NameID nameId,
		SubjectConfirmationData subjectConfirmationData) {

		SubjectConfirmation subjectConfirmation =
			OpenSamlUtil.buildSubjectConfirmation();

		subjectConfirmation.setMethod(SubjectConfirmation.METHOD_BEARER);
		subjectConfirmation.setSubjectConfirmationData(subjectConfirmationData);

		Subject subject = OpenSamlUtil.buildSubject(nameId);

		List<SubjectConfirmation> subjectConfirmations =
			subject.getSubjectConfirmations();

		subjectConfirmations.add(subjectConfirmation);

		return subject;
	}

	protected SubjectConfirmationData getSuccessSubjectConfirmationData(
		long companyId,
		long groupId,
		SamlSsoRequestContext samlSsoRequestContext,
		AssertionConsumerService assertionConsumerService,
		DateTime issueInstantDateTime) {

		SubjectConfirmationData subjectConfirmationData =
			OpenSamlUtil.buildSubjectConfirmationData();

		subjectConfirmationData.setRecipient(
			assertionConsumerService.getLocation());

		SAMLMessageContext<AuthnRequest, Response, NameID> samlMessageContext =
			samlSsoRequestContext.getSAMLMessageContext();

		int assertionLifetime = MetadataManagerUtil.getAssertionLifetime(
			companyId, samlMessageContext.getPeerEntityId());

		DateTime notOnOrAfterDateTime = issueInstantDateTime.plusSeconds(
			assertionLifetime);

		subjectConfirmationData.setNotOnOrAfter(notOnOrAfterDateTime);

		return subjectConfirmationData;
	}

	protected void redirectToLogin(
			HttpServletRequest request, HttpServletResponse response,
			SamlSsoRequestContext samlSsoRequestContext, boolean forceAuthn)
		throws SystemException {

		HttpSession session = request.getSession();

		if (forceAuthn) {
			session.invalidate();

			session = request.getSession(true);

			session.setAttribute(
				PortletWebKeys.FORCE_REAUHENTICATION, Boolean.TRUE);
		}

		SAMLMessageContext<AuthnRequest, Response, NameID> samlMessageContext =
			samlSsoRequestContext.getSAMLMessageContext();

		samlMessageContext.setInboundMessageTransport(null);
		samlMessageContext.setOutboundMessageTransport(null);

		session.setAttribute(
			PortletWebKeys.SAML_SSO_REQUEST_CONTEXT, samlSsoRequestContext);

		response.addHeader(
			HttpHeaders.CACHE_CONTROL,
			HttpHeaders.CACHE_CONTROL_NO_CACHE_VALUE);
		response.addHeader(
			HttpHeaders.PRAGMA, HttpHeaders.PRAGMA_NO_CACHE_VALUE);

		StringBundler sb = new StringBundler(4);

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		sb.append(themeDisplay.getPathMain());
		sb.append("/portal/login?redirect=");
		sb.append(themeDisplay.getPathMain());
		sb.append("/portal/saml/sso");

		String redirect = sb.toString();

		try {
			response.sendRedirect(redirect);
		}
		catch (IOException ioe) {
			throw new SystemException(ioe);
		}
	}

	protected void sendFailureResponse(
			long companyId, long groupId,
			SamlSsoRequestContext samlSsoRequestContext, String statusURI)
		throws PortalException {

		SAMLMessageContext<AuthnRequest, Response, NameID> samlMessageContext =
			samlSsoRequestContext.getSAMLMessageContext();

		SamlBinding samlBinding = getSamlBinding(
			SAMLConstants.SAML2_POST_BINDING_URI);

		AssertionConsumerService assertionConsumerService =
			SamlUtil.resolverAssertionConsumerService(
				samlMessageContext, samlBinding.getCommunicationProfileId());

		samlMessageContext.setPeerEntityEndpoint(assertionConsumerService);

		try {
			Credential credential = MetadataManagerUtil.getSigningCredential(
					companyId, groupId);

			samlMessageContext.setOutboundSAMLMessageSigningCredential(
				credential);
		}
		catch (SecurityException se) {
			throw new SamlException(se);
		}

		Response response = OpenSamlUtil.buildResponse();

		response.setDestination(assertionConsumerService.getLocation());
		response.setInResponseTo(samlMessageContext.getInboundSAMLMessageId());

		DateTime issueInstantDateTime = new DateTime(DateTimeZone.UTC);

		response.setIssueInstant(issueInstantDateTime);

		Issuer issuer = OpenSamlUtil.buildIssuer(
			samlMessageContext.getLocalEntityId());

		response.setIssuer(issuer);

		StatusCode statusCode = OpenSamlUtil.buildStatusCode(statusURI);

		Status status = OpenSamlUtil.buildStatus(statusCode);

		response.setStatus(status);

		samlMessageContext.setOutboundSAMLMessage(response);

		sendSamlMessage(samlMessageContext);
	}

	protected void sendSuccessResponse(
			HttpServletRequest request, HttpServletResponse response,
			long companyId, long groupId,
			SamlSsoRequestContext samlSsoRequestContext)
		throws Exception {
		
		SAMLMessageContext<AuthnRequest, Response, NameID> samlMessageContext =
			samlSsoRequestContext.getSAMLMessageContext();

		SamlBinding samlBinding = getSamlBinding(
			SAMLConstants.SAML2_POST_BINDING_URI);

		AssertionConsumerService assertionConsumerService =
			SamlUtil.resolverAssertionConsumerService(
				samlMessageContext, samlBinding.getCommunicationProfileId());

		NameID nameId = getSuccessNameId(companyId, groupId,samlSsoRequestContext);

		Assertion assertion = getSuccessAssertion(
			companyId, groupId,
			samlSsoRequestContext, assertionConsumerService, nameId);

		Credential credential = MetadataManagerUtil.getSigningCredential(
				companyId, groupId);

		SPSSODescriptor spSsoDescriptor =
			(SPSSODescriptor)samlMessageContext.getPeerEntityRoleMetadata();

		if (spSsoDescriptor.getWantAssertionsSigned()) {
			OpenSamlUtil.signObject(assertion, credential);
		}

		Response samlResponse = getSuccessResponse(
			samlSsoRequestContext, assertionConsumerService, assertion);

		samlMessageContext.setOutboundSAMLMessage(samlResponse);

		samlMessageContext.setOutboundSAMLMessageSigningCredential(credential);
		samlMessageContext.setOutboundSAMLProtocol(SAMLConstants.SAML20P_NS);

		samlMessageContext.setPeerEntityEndpoint(assertionConsumerService);

		if (samlSsoRequestContext.isNewSession()) {
			addSamlSsoSession(request, response, samlSsoRequestContext, nameId);
		}
		else {
			updateSamlSsoSession(request, samlSsoRequestContext, nameId);
		}

		sendSamlMessage(samlMessageContext);
	}

	protected void updateSamlSsoSession(
			HttpServletRequest request,
			SamlSsoRequestContext samlSsoRequestContext, NameID nameId)
		throws Exception {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			request);

		SamlIdpSsoSession samlIdpSsoSession =
			SamlIdpSsoSessionLocalServiceUtil.updateModifiedDate(
				samlSsoRequestContext.getSamlSsoSessionId());

		SAMLMessageContext<AuthnRequest, Response, NameID> samlMessageContext =
			samlSsoRequestContext.getSAMLMessageContext();

		try {
			SamlIdpSpSessionLocalServiceUtil.updateModifiedDate(
				samlIdpSsoSession.getSamlIdpSsoSessionId(),
				samlMessageContext.getPeerEntityId());
		}
		catch (NoSuchIdpSpSessionException nsisse) {
			SamlIdpSpSessionLocalServiceUtil.addSamlIdpSpSession(
				samlIdpSsoSession.getSamlIdpSsoSessionId(),
				samlMessageContext.getPeerEntityId(), nameId.getFormat(),
				nameId.getValue(), serviceContext);
		}
	}

	protected void verifyAssertion(
			long companyId,
			long groupId,
			Assertion assertion,
			SAMLMessageContext<?, ?, NameID> samlMessageContext,
			TrustEngine<Signature> trustEngine)
		throws PortalException {

		verifyReplay(samlMessageContext, assertion);
		verifyIssuer(samlMessageContext, assertion.getIssuer());
		verifyAssertionSignature(
			assertion.getSignature(), samlMessageContext, trustEngine);
		verifyConditions(companyId, groupId, samlMessageContext, assertion.getConditions());
		verifySubject(companyId, groupId, samlMessageContext, assertion.getSubject());
	}

	protected void verifyAssertionSignature(
			Signature signature, SAMLMessageContext<?, ?, ?> samlMessageContext,
			TrustEngine<Signature> trustEngine)
		throws PortalException {

		SPSSODescriptor spSsoDescriptor =
			(SPSSODescriptor)samlMessageContext.getLocalEntityRoleMetadata();

		if (spSsoDescriptor.getWantAssertionsSigned()) {
			if (signature == null) {
				throw new SignatureException("SAML assertion is not signed");
			} 
			verifySignature(samlMessageContext, signature, trustEngine);
		}
	}

	protected void verifyAudienceRestrictions(
			List<AudienceRestriction> audienceRestrictions,
			SAMLMessageContext<?, ?, ?> samlMessageContext)
		throws PortalException {

		if (audienceRestrictions.isEmpty()) {
			return;
		}

		for (AudienceRestriction audienceRestriction : audienceRestrictions) {
			for (Audience audience : audienceRestriction.getAudiences()) {
				String audienceURI = audience.getAudienceURI();

				if (audienceURI.equals(samlMessageContext.getLocalEntityId())) {
					return;
				}
			}
		}

		throw new AudienceException("Unable verify audience");
	}

	protected void verifyConditions(
			long companyId,
			long groupId,
			SAMLMessageContext<?, ?, ?> samlMessageContext,
			Conditions conditions)
		throws PortalException {

		verifyAudienceRestrictions(
			conditions.getAudienceRestrictions(), samlMessageContext);
		verifyNotOnOrAfterDateTime(
			MetadataManagerUtil.getClockSkew(companyId, groupId),
			conditions.getNotOnOrAfter());
	}

	protected void verifyDestination(
			SAMLMessageContext<?, ?, ?> samlMessageContext, String destination)
		throws PortalException {

		SPSSODescriptor spSsoDescriptor =
			(SPSSODescriptor)samlMessageContext.getLocalEntityRoleMetadata();

		List<AssertionConsumerService> assertionConsumerServices =
			spSsoDescriptor.getAssertionConsumerServices();

		for (AssertionConsumerService assertionConsumerService :
				assertionConsumerServices) {

			String binding = assertionConsumerService.getBinding();

			if (destination.equals(assertionConsumerService.getLocation()) &&
				binding.equals(
					samlMessageContext.getCommunicationProfileId())) {

				return;
			}
		}

		throw new DestinationException(
			"Destination " + destination + " does not match any assertion " +
				"consumer location with binding " +
					samlMessageContext.getCommunicationProfileId());
	}

	protected void verifyInResponseTo(Response samlResponse)
		throws PortalException, SystemException {

		if (Validator.isNull(samlResponse.getInResponseTo())) {
			return;
		}

		Issuer issuer = samlResponse.getIssuer();
		String issuerEntityId = issuer.getValue();
		String inResponseTo = samlResponse.getInResponseTo();

		SamlSpAuthRequest samlSpAuthRequest =
			SamlSpAuthRequestLocalServiceUtil.fetchSamlSpAuthRequest(
				issuerEntityId, inResponseTo);

		if (samlSpAuthRequest != null) {
			SamlSpAuthRequestLocalServiceUtil.deleteSamlSpAuthRequest(
				samlSpAuthRequest);
		}
		else {
			throw new InResponseToException(
				"Response in response to " + inResponseTo + " does not match " +
					"any authentication requests");
		}
	}

	protected void verifyIssuer(
			SAMLMessageContext<?, ?, ?> samlMessageContext, Issuer issuer)
		throws PortalException {

		String issuerFormat = issuer.getFormat();

		if ((issuerFormat != null) && !issuerFormat.equals(NameIDType.ENTITY)) {
			throw new IssuerException("Invalid issuer format " + issuerFormat);
		}

		String peerEntityId = samlMessageContext.getPeerEntityId();

		if (!peerEntityId.equals(issuer.getValue())) {
			throw new IssuerException(
				"Issuer does not match expected peer entity ID " +
					peerEntityId);
		}
	}

	protected void verifyNotOnOrAfterDateTime(long clockSkew, DateTime dateTime)
		throws PortalException {

		DateTime nowDateTime = new DateTime(DateTimeZone.UTC);

		DateTime upperBoundDateTime = dateTime.plusMillis((int)clockSkew);

		if (upperBoundDateTime.isBefore(nowDateTime)) {
			throw new ExpiredException(
				"Date " + upperBoundDateTime.toString() + " is before " +
					nowDateTime.toString());
		}
	}

	protected void verifyReplay(
			SAMLMessageContext<?, ?, ?> samlMessageContext, Assertion assertion)
		throws PortalException {

		Issuer issuer = assertion.getIssuer();
		String idpEntityId = issuer.getValue();
		String messageKey = assertion.getID();
		Conditions conditions = assertion.getConditions();
		DateTime notOnOrAfter = conditions.getNotOnOrAfter();

		try {
			SamlSpMessage samlSpMessage =
				SamlSpMessageLocalServiceUtil.fetchSamlSpMessage(
					idpEntityId, messageKey);

			if ((samlSpMessage != null) && !samlSpMessage.isExpired()) {
				throw new ReplayException(
					"SAML assertion " + messageKey + " replayed from IdP " +
						idpEntityId);
			}
			else {
				if (samlSpMessage != null) {
					SamlSpMessageLocalServiceUtil.deleteSamlSpMessage(
						samlSpMessage);
				}

				ServiceContext serviceContext = new ServiceContext();

				long companyId = CompanyThreadLocal.getCompanyId();

				serviceContext.setCompanyId(companyId);

				SamlSpMessageLocalServiceUtil.addSamlSpMessage(
					idpEntityId, messageKey, notOnOrAfter.toDate(),
					serviceContext);
			}
		}
		catch (SystemException se) {
			throw new SamlException(se);
		}
	}

	protected void verifySignature(
			SAMLMessageContext<?, ?, ?> samlMessageContext, Signature signature,
			TrustEngine<Signature> trustEngine)
		throws PortalException {

		try {
			_samlSignatureProfileValidator.validate(signature);

			CriteriaSet criteriaSet = new CriteriaSet();

			criteriaSet.add(
				new EntityIDCriteria(samlMessageContext.getPeerEntityId()));
			criteriaSet.add(
				new MetadataCriteria(
					IDPSSODescriptor.DEFAULT_ELEMENT_NAME,
					SAMLConstants.SAML20P_NS));
			criteriaSet.add(new UsageCriteria(UsageType.SIGNING));

			if (!trustEngine.validate(signature, criteriaSet)) {
				throw new SignatureException("Unable validate signature trust");
			}
		}
		catch (Exception e) {
			if (e instanceof PortalException) {
				throw (PortalException)e;
			}

			throw new SignatureException("Unable to verify signature", e);
		}
	}

	protected void verifySubject(
			long companyId,
			long groupId,
			SAMLMessageContext<?, ?, NameID> samlMessageContext,
			Subject subject)
		throws PortalException {

		List<SubjectConfirmation> subjectConfirmations =
			subject.getSubjectConfirmations();

		for (SubjectConfirmation subjectConfirmation : subjectConfirmations) {
			String method = subjectConfirmation.getMethod();

			if (method.equals(SubjectConfirmation.METHOD_BEARER)) {
				SubjectConfirmationData subjectConfirmationData =
					subjectConfirmation.getSubjectConfirmationData();

				if (subjectConfirmationData == null) {
					continue;
				}

				verifyNotOnOrAfterDateTime(
					MetadataManagerUtil.getClockSkew(companyId, groupId),
					subjectConfirmationData.getNotOnOrAfter());

				if (Validator.isNull(subjectConfirmationData.getRecipient())) {
					continue;
				}
				else {
					verifyDestination(
						samlMessageContext,
						subjectConfirmationData.getRecipient());
				}

				NameID nameId = subject.getNameID();

				samlMessageContext.setSubjectNameIdentifier(nameId);

				return;
			}
		}

		throw new SubjectException("Unable to verify subject");
	}

	private static Log _log = LogFactoryUtil.getLog(WebSsoProfileImpl.class);

	private static SAMLSignatureProfileValidator
		_samlSignatureProfileValidator = new SAMLSignatureProfileValidator();

}