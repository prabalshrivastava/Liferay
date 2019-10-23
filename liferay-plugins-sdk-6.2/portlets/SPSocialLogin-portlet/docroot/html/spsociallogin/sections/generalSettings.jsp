<%@ include file="../../init.jsp" %>
<%
	long companyId = company.getCompanyId();
	String socialLoginSkin = SocialLoginUtils.getSkin(companyId);
	Boolean enableLiferayLogin = SocialLoginUtils.getEnableLiferayLogin(companyId);	
%>
<aui:fieldset>

	<aui:select name="skin" 
				id="socialLoginSkinId"
	 			label="social-login-skin"				
				helpMessage="social-login-skin-help"
				onChange = '<%= renderResponse.getNamespace() + "selectType();" %>'	>
 <%
 	List<String> listTypes = SocialLoginConstants.SOCIALLOGIN_SKIN_TYPES;	
 	for(String type : listTypes) {
 		boolean selected = socialLoginSkin.equals(type);
 %>		
         <aui:option value="<%=type%>" selected="<%=selected %>">
         	<%=LanguageUtil.get(pageContext,type)%>         	
         </aui:option>
<%
		
 	}
%>
</aui:select>			   

	<aui:input name="enableLiferayLogin"
			   type="checkbox"
			   label="enable-liferay-login"
			   helpMessage="enable-liferay-login-help"
			   disabled="<%=!socialLoginSkin.equals(SocialLoginConstants.SOCIALLOGIN_SKIN_TYPE_1) %>"
			   value='<%=(Validator.isNotNull(enableLiferayLogin) ? enableLiferayLogin : true) %>'/>
	
</aui:fieldset>
<aui:script use="aui-base">
Liferay.provide(window,
		'<portlet:namespace />selectType',
		function()	{
			var typeSelected = A.one('#<portlet:namespace />socialLoginSkinId').get('value');  			
			var enableLiferayLogin = A.one('#<portlet:namespace />enableLiferayLoginCheckbox');
			if(typeSelected == '<%=SocialLoginConstants.SOCIALLOGIN_SKIN_TYPE_1%>') {
				enableLiferayLogin.attr('disabled',false);
			} else {
				enableLiferayLogin.attr('disabled',true);
			}
		}
);
</aui:script>