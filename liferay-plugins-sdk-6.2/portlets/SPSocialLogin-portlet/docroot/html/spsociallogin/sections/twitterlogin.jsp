<%@ include file="../../init.jsp" %>
<%
	long companyId = company.getCompanyId();
	Boolean twitterLoginEnabled 	  = SocialLoginUtils.isLoginEnabled(companyId, SocialLoginConstants.TWITTER);
	String  twitterLoginClientId 	  = SocialLoginUtils.getClientId(companyId, SocialLoginConstants.TWITTER);
	String  twitterLoginClientSecret  = SocialLoginUtils.getClientSecret(companyId, SocialLoginConstants.TWITTER);
%>
<aui:fieldset>


	<aui:input name="twitterLoginEnabled"
			   type="checkbox"
			   label="twitter-login-enabled"
			   value='<%=(Validator.isNotNull(twitterLoginEnabled) ? twitterLoginEnabled : false) %>'/>

	<aui:input name="twitterLoginClientId"
			   type="text"
			   label="twitter-login-clientid"
			   size="150"
			   value='<%=(Validator.isNotNull(twitterLoginClientId) ? twitterLoginClientId : "") %>'/>

	<aui:input name="twitterLoginClientSecret"
			   type="text"
			   label="twitter-login-clientsecret"
			   size="150"
			   value='<%= (Validator.isNotNull(twitterLoginClientSecret) ? twitterLoginClientSecret : "") %>'/>
			   
	
</aui:fieldset>
