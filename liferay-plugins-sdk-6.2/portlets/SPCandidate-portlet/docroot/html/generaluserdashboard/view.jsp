<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>


<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib	uri="http://liferay.com/tld/theme" prefix="theme"%><%@
taglib	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%-- <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> --%>

<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.service.RoleServiceUtil"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.model.User"%>


<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>

<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'> 
<portlet:defineObjects /> 
<theme:defineObjects />

<% User userU = themeDisplay.getUser();
long userId = userU.getUserId();
String configData = portletPreferences.getValue("config", StringPool.BLANK);

JSONObject configJson = JSONFactoryUtil.createJSONObject();
if(!configData.equalsIgnoreCase(StringPool.BLANK)){
	configJson = JSONFactoryUtil.createJSONObject(configData);
}

String CallOut1Link = renderRequest.getPreferences().getValue("CallOut1Link", StringPool.BLANK);
String CallOut2Link = renderRequest.getPreferences().getValue("CallOut2Link", StringPool.BLANK);
String CallOut3Link = renderRequest.getPreferences().getValue("CallOut3Link", StringPool.BLANK);

String Image1Link = renderRequest.getPreferences().getValue("Image1Link", request.getContextPath()+"/images/user.png");
String Image2Link = renderRequest.getPreferences().getValue("Image2Link", request.getContextPath()+"/images/invigilator.png");
String Image3Link = renderRequest.getPreferences().getValue("Image3Link", request.getContextPath()+"/images/announcement.png");

String title1 = renderRequest.getPreferences().getValue("title1", "PROFILE");
String title2 = renderRequest.getPreferences().getValue("title2", "INVIGILATOR");
String title3 = renderRequest.getPreferences().getValue("title3", "OTHER SERVICES");

String action1 = renderRequest.getPreferences().getValue("action1", "Update Now");
String action2 = renderRequest.getPreferences().getValue("action2", "Apply Now");
String action3 = renderRequest.getPreferences().getValue("action3", "Explore All");


%>

<%

List<Role> roleListOfLoggedInUser = RoleLocalServiceUtil.getUserRoles(userId);
int totalsize = 4;
for (Role roles : roleListOfLoggedInUser) {
	long roleId = roles.getRoleId();
	
	if(configJson.has("dataGrid")){
		for(int i = 0; i < configJson.getJSONArray("dataGrid").length() ; i++ ){
			JSONArray dataGrid = configJson.getJSONArray("dataGrid");
			JSONArray rolesAllowed = dataGrid.getJSONObject(i).getJSONArray("Role");
			for(int j = 0; j < rolesAllowed.length(); j++){
				if(rolesAllowed.getLong(j) == roleId){
					CallOut1Link = dataGrid.getJSONObject(i).getString("CallOut1Link");
					CallOut2Link = dataGrid.getJSONObject(i).getString("CallOut2Link");
					CallOut3Link = dataGrid.getJSONObject(i).getString("CallOut3Link");
		
					Image1Link = dataGrid.getJSONObject(i).getString("Image1Link");
					Image2Link = dataGrid.getJSONObject(i).getString("Image2Link");
					Image3Link = dataGrid.getJSONObject(i).getString("Image3Link");
					
					title1 = dataGrid.getJSONObject(i).getString("Title1");
					title2 = dataGrid.getJSONObject(i).getString("Title2");
					title3 = dataGrid.getJSONObject(i).getString("Title3");
					if(!title1.isEmpty() && !title2.isEmpty() && !title3.isEmpty()){
						totalsize = 4;
					}
					else{
						if((title1.isEmpty() && title2.isEmpty()) || (title1.isEmpty() && title3.isEmpty()) || (title2.isEmpty() && title3.isEmpty()) ){
							totalsize = 12;
						}else{
							totalsize = 6;
						}
					}
					
					action1 = dataGrid.getJSONObject(i).getString("Action1");
					action2 = dataGrid.getJSONObject(i).getString("Action2");
					action3 = dataGrid.getJSONObject(i).getString("Action3");
					break;
				}
			}
		}
	}
}
	
%>
<div class="container content bgnone">
<div class="dashboard">
<aui:row>
	<% if(!title1.isEmpty()){ %>
	<div class="span<%= totalsize %> text-center" >
		<div class="contentBox">
			<a href= "<%=CallOut1Link%>"  >
				<img src="<%=Image1Link%>" width="35" height="40" />
				<h3><%=title1%></h3>
				<p><%=action1%></p>
			
			</a>
			
		</div>
		
	</div>
	<% } %>
	<% if(!title2.isEmpty()){ %>
	<div class="span<%= totalsize %> text-center" >
		<div class="contentBox">
			<a href= "<%=CallOut2Link%>"  >
				<img src="<%=Image2Link%>" width="35" height="40" />
				<h3><%=title2%></h3>
				<p><%=action2%></p>
			</a>
		</div>
	</div>
	<% } %>
	<% if(!title3.isEmpty()){ %>
	<div class="span<%= totalsize %> text-center" >
		<div class="contentBox">
			<a href= "<%=CallOut3Link%>"  >
				<img src="<%=Image3Link%>" width="35" height="40" />
				<h3><%=title3%></h3>
				<p><%=action3%></p>	
			</a>
		</div>
	</div>
	<% } %>
</aui:row>
</div>
</div>

<script>
var configData = '<%= configData %>';

</script>
