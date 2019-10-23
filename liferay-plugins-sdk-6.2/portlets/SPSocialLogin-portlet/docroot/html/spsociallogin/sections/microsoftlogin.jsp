<%@ include file="../../init.jsp" %>
<%
	long companyId = company.getCompanyId();
	Boolean microsoftLoginEnabled 	  = SocialLoginUtils.isLoginEnabled(companyId, SocialLoginConstants.MICROSOFT);
	String  microsoftLoginClientId 	  = SocialLoginUtils.getClientId(companyId, SocialLoginConstants.MICROSOFT);
	String  microsoftLoginClientSecret  = SocialLoginUtils.getClientSecret(companyId, SocialLoginConstants.MICROSOFT);
%>
<aui:fieldset>

	<aui:input name="microsoftLoginEnabled"
			   type="checkbox"
			   label="microsoft-login-enabled"			   
			   value='<%=(Validator.isNotNull(microsoftLoginEnabled) ? microsoftLoginEnabled : false) %>'/>

	<aui:input name="microsoftLoginClientId"
			   type="text"
			   label="microsoft-login-clientid"
			   size="150"
			   value='<%=(Validator.isNotNull(microsoftLoginClientId) ? microsoftLoginClientId : "") %>'/>

	<aui:input name="microsoftLoginClientSecret"
			   type="text"
			   label="microsoft-login-clientsecret"
			   size="150"
			   value='<%= (Validator.isNotNull(microsoftLoginClientSecret) ? microsoftLoginClientSecret : "") %>'/>
			   
	
</aui:fieldset>
