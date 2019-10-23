<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
String certificateCommonName = SamlConfigUtil.getString(companyId, groupId, PortletPropsKeys.CERTIFICATE_COMMON_NAME);
String certificateCountry = SamlConfigUtil.getString(companyId, groupId, PortletPropsKeys.CERTIFICATE_COUNTRY);
String certificateLocality = SamlConfigUtil.getString(companyId, groupId, PortletPropsKeys.CERTIFICATE_LOCALITY);
String certificateKeyAlgorithm = SamlConfigUtil.getString(companyId, groupId, PortletPropsKeys.CERTIFICATE_ALGORITHM, "RSA");
String certificateKeyLength = SamlConfigUtil.getString(companyId, groupId, PortletPropsKeys.CERTIFICATE_KEY_LENGTH, "2048");
String certificateOrganization = SamlConfigUtil.getString(companyId, groupId, PortletPropsKeys.CERTIFICATE_ORGANIZATION);
String certificateOrganizationUnit = SamlConfigUtil.getString(companyId, groupId, PortletPropsKeys.CERTIFICATE_ORGANIZATION_UNIT);
String certificateState = SamlConfigUtil.getString(companyId, groupId, PortletPropsKeys.CERTIFICATE_STATE);
String certificateValidityDays = SamlConfigUtil.getString(companyId, groupId, PortletPropsKeys.CERTIFICATE_VALIDITY_DAYS, "356");

String entityId = SamlUtil.getKeystoreCredential(companyId, groupId);

X509Credential x509Credential = null;
X509Certificate x509Certificate = null;

try {
	x509Credential = 
			(X509Credential)MetadataManagerUtil.getSigningCredential(companyId, groupId);

	if (x509Credential != null) {
		x509Certificate = x509Credential.getEntityCertificate();
	}
}
catch (Exception e) {
	_log.error(e.getMessage());
}
%>

<portlet:actionURL name="updateGeneral" var="updateGeneralURL">
	<portlet:param name="tabs1" value="general" />
</portlet:actionURL>

<c:choose>
	<c:when test="<%= SamlUtil.isRoleIdp(companyId) %>">
		<liferay-ui:message key="saml-role"/>: 
		<liferay-ui:message key="identity-provider" />
	</c:when>
	<c:otherwise>
		<aui:form action="<%= updateGeneralURL %>">
			<liferay-ui:error key="certificateInvalid" message="please-create-a-signing-credential-before-enabling" />
			<liferay-ui:error key="identityProviderInvalid" message="please-configure-identity-provider-before-enabling" />
			<aui:input type="hidden" name="doAsGroupId" value="<%= groupId %>" />
		
			<aui:fieldset>
				<c:if test="<%= x509Certificate != null %>">
					<aui:input 
						label="enabled" 
						name='<%= "settings--" + PortletPropsKeys.SAML_ENABLED + "--" %>' 
						type="checkbox" 
						value="<%= SamlUtil.isEnabled(companyId, groupId) %>" 
					/>
					<aui:input
						label="debug"
						name='<%= "settings--" + PortletPropsKeys.SAML_DEBUG_ENABLED + "--" %>' 
						type="checkbox"
						value="<%= SamlUtil.isDebugEnabled(companyId, groupId) %>"
					/>
				</c:if>
		
				<liferay-ui:message key="saml-role"/>: 
				<liferay-ui:message key="service-provider" />
				<br/>
				
				<aui:input 
					helpMessage="entity-id-help" 
					label="entity-id" 
					name='<%= "settings--" + PortletPropsKeys.SAML_ENTITY_ID + "--" %>' 
					required="true" 
					value="<%= entityId %>" 
				/>
			</aui:fieldset>
		
			<aui:button-row>
				<aui:button type="submit" value="save" />
			</aui:button-row>
		</aui:form>
		
		<portlet:actionURL name="updateCertificate" var="updateCertificateURL">
			<portlet:param name="tabs1" value="general" />
		</portlet:actionURL>
		
		<c:if test="<%= Validator.isNotNull(entityId) %>">
			<aui:fieldset label="certificate-and-private-key">
				<c:choose>
					<c:when test="<%= x509Certificate != null %>">
		
						<%
						Date now = new Date();
						%>
		
						<c:if test="<%= now.after(x509Certificate.getNotAfter()) %>">
							<div class="portlet-msg-alert"><liferay-ui:message arguments="<%= new Object[] {x509Certificate.getNotAfter()} %>" key="certificate-expired-on-x" /></div>
						</c:if>
		
						<dl class="property-list">
							<dt>
								<liferay-ui:message key="subject-dn" />
							</dt>
							<dd>
								<%= CertificateUtil.getSubjectName(x509Certificate) %>
							</dd>
							<dt>
								<liferay-ui:message key="serial-number" />
							</dt>
							<dd>
								<%= CertificateUtil.getSerial(x509Certificate) %>
		
								<div class="portlet-msg-info-label">
									<liferay-ui:message arguments="<%= new Object[] {x509Certificate.getNotBefore(), x509Certificate.getNotAfter()} %>" key="valid-from-x-until-x" />
								</div>
							</dd>
							<dt>
								<liferay-ui:message key="certificate-fingerprints" />
							</dt>
							<dd class="property-list">
								<dl>
									<dt>
										MD5
									</dt>
									<dd>
										<%= CertificateUtil.getFingerprint("MD5", x509Certificate) %>
									</dd>
									<dt>
										SHA1
									</dt>
									<dd>
										<%= CertificateUtil.getFingerprint("SHA1", x509Certificate) %>
									</dd>
								</dl>
							</dd>
							<dt>
								<liferay-ui:message key="signature-algorithm" />
							</dt>
							<dd>
								<%= x509Certificate.getSigAlgName() %>
							</dd>
						</dl>
		
						<portlet:resourceURL var="downloadCertificateURL" />
		
						<aui:button-row>
							<aui:button onClick='<%= renderResponse.getNamespace() + "toggleCertificateForm(true);" %>' value="replace-certificate" /> <aui:button href="<%= downloadCertificateURL %>" value="download-certificate" />
						</aui:button-row>
					</c:when>
					<c:when test="<%= (x509Certificate == null) && Validator.isNull(MetadataManagerUtil.getLocalEntityId(companyId, groupId)) %>">
						<div class="portlet-msg-info">
							<liferay-ui:message key="entity-id-must-be-set-before-private-key-and-certificate-can-be-generated" />
						</div>
					</c:when>
				</c:choose>
		
				<aui:form action="<%= updateCertificateURL %>">
					<div 
						class="<%= ((x509Certificate == null) && Validator.isNotNull(MetadataManagerUtil.getLocalEntityId(companyId, groupId))) ? "" : "hide hide" %>" 
						id="<portlet:namespace />certificateForm"
					>
						<liferay-ui:error exception="<%= CertificateKeyPasswordException.class %>" message="please-enter-a-valid-key-password" />
						<liferay-ui:error exception="<%= InvalidParameterException.class %>" message="please-enter-a-valid-key-length-and-algorithm" />
		
						<aui:input type="hidden" name="doAsGroupId" value="<%= groupId %>" />
						
						<aui:input label="common-name" name='<%= "settings--" + PortletPropsKeys.CERTIFICATE_COMMON_NAME + "--" %>' required="true" value="<%= certificateCommonName %>" />
		
						<aui:input label="organization" name='<%= "settings--" + PortletPropsKeys.CERTIFICATE_ORGANIZATION + "--" %>' required="true" value="<%= certificateOrganization %>" />
		
						<aui:input label="organization-unit" name='<%= "settings--" + PortletPropsKeys.CERTIFICATE_ORGANIZATION_UNIT + "--" %>' value="<%= certificateOrganizationUnit %>" />
		
						<aui:input label="locality" name='<%= "settings--" + PortletPropsKeys.CERTIFICATE_LOCALITY + "--" %>' value="<%= certificateLocality %>" />
		
						<aui:input label="state" name='<%= "settings--" + PortletPropsKeys.CERTIFICATE_STATE + "--" %>' value="<%= certificateState %>" />
		
						<aui:input label="country" name='<%= "settings--" + PortletPropsKeys.CERTIFICATE_COUNTRY + "--" %>' required="true" value="<%= certificateCountry %>" />
		
						<aui:input label="validity-days" name='<%= "settings--" + PortletPropsKeys.CERTIFICATE_VALIDITY_DAYS + "--" %>' required="true" value="<%= certificateValidityDays %>" />
		
						<aui:select label="key-algorithm" name='<%= "settings--" + PortletPropsKeys.CERTIFICATE_ALGORITHM + "--" %>' required="true">
							<aui:option label="rsa" selected='<%= certificateKeyAlgorithm.equals("RSA") %>' value="RSA" />
							<aui:option label="dsa" selected='<%= certificateKeyAlgorithm.equals("DSA") %>' value="DSA" />
						</aui:select>
		
						<aui:select label="key-length-bits" name='<%= "settings--" + PortletPropsKeys.CERTIFICATE_KEY_LENGTH + "--" %>' required="true">
							<aui:option label="4096" selected='<%= certificateKeyLength.equals("4096") %>' value="4096" />
							<aui:option label="2048" selected='<%= certificateKeyLength.equals("2048") %>' value="2048" />
							<aui:option label="1024" selected='<%= certificateKeyLength.equals("1024") %>' value="1024" />
							<aui:option label="512" selected='<%= certificateKeyLength.equals("512") %>' value="512" />
						</aui:select>
						<aui:input 
							label="key-password" 
							name='<%= "settings--" + PortletPropsKeys.SAML_KEYSTORE_PASSWORD +  "--" %>' 
							required="true" 
							type="text" 
							value="<%= SamlUtil.getKeystoreCredentialPassword(companyId, groupId) %>" 
						/>
						<aui:button-row>
							<aui:button type="submit" value="save" />
		
							<aui:button onClick='<%= renderResponse.getNamespace() + "toggleCertificateForm(false);" %>' value="cancel" />
						</aui:button-row>
					</div>
				</aui:form>
			</aui:fieldset>
		</c:if>
		
		<aui:script>
			Liferay.provide(
				window,
				'<portlet:namespace />toggleCertificateForm',
				function(visible) {
					var A = AUI();
		
					var certificateForm = A.one('#<portlet:namespace />certificateForm');
		
					if (certificateForm) {
						certificateForm.toggle(visible);
					}
				}
			);
		</aui:script>
	</c:otherwise>
</c:choose>

<%!
private static Log _log = LogFactoryUtil.getLog("admin.general_jsp");
%>
