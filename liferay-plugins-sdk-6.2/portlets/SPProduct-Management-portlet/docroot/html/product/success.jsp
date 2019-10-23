<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>


<portlet:defineObjects />

<% String baseUrl = portletPreferences.getValue("baseUrlPref", "");


ThemeDisplay td  = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
String portletID = "subject_WAR_ProductSetupportlet";
long plid = PortalUtil.getPlidFromPortletId(td.getScopeGroupId(), portletID);
PortletURL subjectListURL = PortletURLFactoryUtil.create(request, portletID, plid, PortletRequest.RENDER_PHASE);
PortletURL addNewSubjectURL = PortletURLFactoryUtil.create(request, portletID, plid, PortletRequest.RENDER_PHASE);
PortletURL assignSubjectURL = PortletURLFactoryUtil.create(request, portletID, plid, PortletRequest.RENDER_PHASE);


addNewSubjectURL.setParameter("jspPage", "/html/subjectsetup/create.jsp");
assignSubjectURL.setParameter("jspPage", "/html/subjectsetup/entitylink.jsp");

Long groupId = td.getLayout().getGroupId();
String dashboardLink = SambaashUtil.getParameter("dashboard.link",groupId);

String preference = renderRequest.getPreferences().getValue("preference","");
JSONObject prefData = JSONFactoryUtil.createJSONObject(preference);
String numColumns = prefData.getString("numColumns",""); 
String modelName = prefData.getString("model1",""); 
if(modelName != ""){
	String[] array  = modelName.split(",");
	array = array[1].split("-");
	modelName = array[0];
}
String modelNameCol2 = prefData.getString("model2",""); 
if(modelNameCol2 != ""){
	String[] array  = modelNameCol2.split(",");
	array = array[1].split("-");
	modelNameCol2 = array[0];
}
JSONArray column1links = JSONFactoryUtil.createJSONArray(prefData.getString("column1links","[]")); 
JSONArray column2links = JSONFactoryUtil.createJSONArray(prefData.getString("column2links","[]")); 

String outerListingLink = prefData.getString("outerListingLink","");
%>

<div class="newPortlets">

<div class="subHeader">
	<div class="container">
	<div class="inner-container">
		<aui:row>
			<aui:col span="10" cssClass="text-center"><h2><span>Product Setup Success</span></h2></aui:col>
			<aui:col span="2" cssClass="text-right"><aui:a href="#link" title="Back to Home">Back to Home</aui:a></aui:col>
		</aui:row>
	</div></div>
</div>

<div class="sambaashContent">
	<div class="container progSetupSucc">
		<aui:row>
			<aui:col span="12" cssClass="text-center">
				<h3><%= modelName %> created successfully!</h3>
				<p>What would you like to do next?</p>
			</aui:col>
		</aui:row>
		<aui:row>
		<% int col = 12; String colclass="onecolumn"; if(!numColumns.equals("1")){ col = 6; colclass ="";} %>
		<c:set var="colclass" value="<%= colclass %>"/>
			<aui:col span="<%= col %>" cssClass="text-center ${colclass}">
				<div class="progSetup">
					<h4><%= modelName %></h4>
					<ul>
					
					<%
					for(int i = 0; i< column1links.length(); i++){
						String link = column1links.getJSONObject(i).getString("Link");
						String text = column1links.getJSONObject(i).getString("Text");
						%>
						<li><a href="<%= link %>" title="<%= text %>"><%= text %></a></li>
					<% } %>
					</ul>
				</div>
			</aui:col>
			<% if(!numColumns.equals("1")){ %>
			<aui:col span="6" cssClass="text-center">
				<div class="subSetup">
					<h4><%= modelNameCol2 %></h4>
					<%
					for(int i = 0; i< column2links.length(); i++){
						String link = column2links.getJSONObject(i).getString("Link");
						String text = column2links.getJSONObject(i).getString("Text");
						%>
						<a href="<%= link %>" title="<%= text %>"><%= text %></a>
					<% } %>
				</div>
			</aui:col>
			<% } %>
		</aui:row>
		<aui:row>
			<aui:col span="12" cssClass="text-center">
				OR
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="12" cssClass="text-center">
				
				<a href="<%= outerListingLink %>" class="btn btn-default" title=""><%= modelNameCol2.toUpperCase() %> LISTING</a>
			</aui:col>
		</aui:row>
	</div>
</div>
</div>