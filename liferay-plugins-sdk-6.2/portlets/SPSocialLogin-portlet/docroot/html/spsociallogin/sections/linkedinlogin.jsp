<%@ include file="../../init.jsp" %>
<%
	long companyId = company.getCompanyId();
	Boolean linkedinLoginEnabled 	  = SocialLoginUtils.isLoginEnabled(companyId, SocialLoginConstants.LINKEDIN);
	String  linkedinLoginClientId 	  = SocialLoginUtils.getClientId(companyId, SocialLoginConstants.LINKEDIN);
	String  linkedinLoginClientSecret  = SocialLoginUtils.getClientSecret(companyId, SocialLoginConstants.LINKEDIN);
%>
<aui:fieldset>

	<aui:input name="linkedinLoginEnabled"
			   type="checkbox"
			   label="linkedin-login-enabled"			   
			   value='<%=(Validator.isNotNull(linkedinLoginEnabled) ? linkedinLoginEnabled : false) %>'/>

	<aui:input name="linkedinLoginClientId"
			   type="text"
			   label="linkedin-login-clientid"
			   size="150"
			   value='<%=(Validator.isNotNull(linkedinLoginClientId) ? linkedinLoginClientId : "") %>'/>

	<aui:input name="linkedinLoginClientSecret"
			   type="text"
			   label="linkedin-login-clientsecret"
			   size="150"
			   value='<%= (Validator.isNotNull(linkedinLoginClientSecret) ? linkedinLoginClientSecret : "") %>'/>
			   
	
</aui:fieldset>
