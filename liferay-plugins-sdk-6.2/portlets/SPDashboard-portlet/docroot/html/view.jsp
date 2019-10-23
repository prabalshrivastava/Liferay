<%@page import="org.json.JSONObject"%>
<%@include file="/html/init.jsp" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="java.util.*"%>
<%@page import="java.util.regex.*"%>
<%@page import="org.json.*" %>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>


<% 
	Map<String,String[]> mapEntries=portletPreferences.getMap();
%>
<body>
	<div class="container">
		<div class="left-pane" style="width:30%; height:80%;float:left;position:relative; background-color: white;">
			<h2>DashBoard</h2>
			<ul>
			
			</ul>
		</div>
		<div class="right-pane" style="width:60%; height:80%;float:left;position:relative;">
		
		</div>

	</div>
	
</body>


	
	
