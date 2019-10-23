<%@ include file="../../init.jsp"%>
<%
	long companyId = company.getCompanyId();
	Boolean googleLoginEnabled = SocialLoginUtils.isLoginEnabled(companyId, SocialLoginConstants.GOOGLE);
	String googleLoginClientId = SocialLoginUtils.getClientId(companyId, SocialLoginConstants.GOOGLE);
	String googleLoginClientSecret = SocialLoginUtils.getClientSecret(companyId, SocialLoginConstants.GOOGLE);
	String googleLoginHostedDomain = SocialLoginUtils.getGoogleLoginHostedDomain(companyId);
%>
<aui:fieldset>

	<aui:input name="googleLoginEnabled" type="checkbox"
		label="google-login-enabled"
		value='<%=(Validator.isNotNull(googleLoginEnabled) ? googleLoginEnabled : false)%>' />


	<aui:input name="googleLoginClientId" type="text"
		label="google-login-clientid" size="150"
		value='<%=(Validator.isNotNull(googleLoginClientId) ? googleLoginClientId : "")%>' />


	<aui:input name="googleLoginClientSecret" type="text"
		label="google-login-clientsecret" size="150"
		value='<%=(Validator.isNotNull(googleLoginClientSecret) ? googleLoginClientSecret : "")%>' />

	<aui:input name="googleLoginHostedDomain" type="text"
		label="google-login-hosted-domain" size="150"
		value='<%=(Validator.isNotNull(googleLoginHostedDomain) ? googleLoginHostedDomain : "")%>' />

</aui:fieldset>
