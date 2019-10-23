<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<%@ page import="com.liferay.portal.kernel.util.*" %>
<%@ page import="com.sambaash.platform.dbutility.util.DBManager" %>
<%@ page import="com.sambaash.platform.dbutility.portlet.DBUtilityPortlet" %>
<portlet:defineObjects />
<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL"/>
<liferay-portlet:resourceURL portletName="${param.portletResource}" var="testConnectionURL" />

<%  
	String server_URL = GetterUtil.getString(portletPreferences.getValue("server_URL_PrefKey", DBManager.DEFAULT_URL));
	String username = GetterUtil.getString(portletPreferences.getValue("username_PrefKey", ""));
	String password = GetterUtil.getString(portletPreferences.getValue("password_PrefKey", ""));
%>

<aui:script>
	function ajaxCall() {
		AUI().use('aui-io-request', function(A) {
			var formOption = A.one("input[data-id=formOption]");
			var server_URL = A.one("input[data-id=server_URL]");
			var username = A.one("input[data-id=username]");
			var password = A.one("input[data-id=password]");
			data = {};
			data.formOption = formOption.val();
			data.server_URL = server_URL.val();
			data.username = username.val();
			data.password = password.val();
			
			A.io.request('${testConnectionURL}', {
				method : 'post',
				data: data,
				dataType: "json",
				on : {
					success : function() {
						var res=this.get('responseData');
						if(res.status){
							alert('SQL Connection Success');
						}
						else{
							alert('SQL Connection Fail');
						}
					},
					failure : function() {
						alert('SQL Connection Fail');
					}
				}
			});
		});
	}
</aui:script>

<aui:form action="<%= configurationURL %>" method="post" name="fm">
    <aui:input name="formOption" type="hidden" value="<%=DBUtilityPortlet.FORMOPTION_CONFIGURE %>" data-id="formOption"/>
	
    <!-- Preference control goes here -->
    <aui:input name="preferences--server_URL_PrefKey--" label="Database Server URL" type="text" value="<%= server_URL %>" data-id="server_URL"/>
    <aui:input name="preferences--username_PrefKey--" label="Username" type="text" value="<%= username %>" data-id="username"/>
    <aui:input name="preferences--password_PrefKey--" label="Password" type="password" value="<%= password %>" data-id="password"/>
    
    <aui:button-row>
    	<aui:button type="button" value="Test Connection" onClick='ajaxCall()'/>
        <aui:button type="submit" />
    </aui:button-row>
</aui:form>