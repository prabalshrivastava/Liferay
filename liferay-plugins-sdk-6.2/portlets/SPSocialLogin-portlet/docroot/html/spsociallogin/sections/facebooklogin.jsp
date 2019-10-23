<%@ include file="../../init.jsp" %>
<%
	long companyId = company.getCompanyId();
	Boolean facebookLoginEnabled 	  = SocialLoginUtils.isLoginEnabled(companyId, SocialLoginConstants.FACEBOOK);
	String  facebookLoginClientId 	  = SocialLoginUtils.getClientId(companyId, SocialLoginConstants.FACEBOOK);
	String  facebookLoginClientSecret  = SocialLoginUtils.getClientSecret(companyId, SocialLoginConstants.FACEBOOK);
%>
<aui:fieldset>

	<aui:input name="facebookLoginEnabled"
			   type="checkbox"
			   label="facebook-login-enabled"			   
			   value='<%=(Validator.isNotNull(facebookLoginEnabled) ? facebookLoginEnabled : false) %>'/>
			   

	<aui:input name="facebookLoginClientId"
			   type="text"
			   label="facebook-login-clientid"
			   size="150"
			   value='<%=(Validator.isNotNull(facebookLoginClientId) ? facebookLoginClientId : "") %>'/>
			   

	<aui:input name="facebookLoginClientSecret"
			   type="text"
			   label="facebook-login-clientsecret"
			   size="150"
			   value='<%= (Validator.isNotNull(facebookLoginClientSecret) ? facebookLoginClientSecret : "") %>'/>
	
</aui:fieldset>
