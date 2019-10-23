<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>

<%@ page import="com.sambaash.platform.srv.spservices.model.SPUserType" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>

<script type="text/babel" src='/html/js/sp/class/ConfigForm.js'></script>

<%
	long declarationFormId = Long.parseLong((String) request.getAttribute("declarationId"));
	SPUserType spUserType = (SPUserType) request.getAttribute("spUserType");
	long spUserTypeId;
	long spUserId;
	if (spUserType != null && declarationFormId > 0) {
		spUserTypeId = spUserType.getSpUserTypeId();
		spUserId = spUserType.getUserId();
%>
		<div class="newPortlets">
			<div id='declarationFormio' class="formContainer container" ></div>
		</div>
		
		<aui:script use="aui-base,aui-node,aui-io-request">
			Formio.setPlatformAuth("<%= AuthTokenUtil.getToken(request) %>");
			var userInfo = <%= SambaashUtil.getUserInfo(themeDisplay).toString() %>;
			var p_auth =  "<%= AuthTokenUtil.getToken(request) %>";
			var apiUrl = '<%= SambaashUtil.getFormV2BaseUrl() %>';
		
			AUI().on('domready', function () {
				var formInstance = new ConfigForm(p_auth, apiUrl, 'declarationFormio', <%=declarationFormId%>, 0, 
						'', '<portlet:namespace/>', userInfo,
						<%= SambaashUtil.getScopeGroupId(themeDisplay.getScopeGroupId()) %>
				);	
		
		        window.SPConfigControl = new SPFormController(formInstance);
		        formInstance.load({
		        	persistData: function(formInstance, formData) {
		        		console.log("sp declaration custom persist", <%=declarationFormId%>, <%=spUserTypeId%>, <%=spUserId%>, formData);
		        		Liferay.Service(
						  '/SPServices-portlet.spusertype/save-user-declaration',
						  {
						    spUserTypeId: <%=spUserTypeId%>,
						    userId: <%=spUserId%>,
						    formId: <%=declarationFormId%>,
						    declarationJsonString: JSON.stringify(formData)
						  },
						  function(obj) {
						    console.log('Saved Declaration', '<%=referer%>', obj);
						    window.location.href = '<%=referer%>';
						  }
						);
		        	}
		        });
			});
		
		</aui:script>
<%	
	}
%>