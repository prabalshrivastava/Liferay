<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@ page import="com.liferay.portal.model.Role" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<portlet:defineObjects />
<%



String internalRoleIds = GetterUtil.getString(portletPreferences.getValue("internalRoleIds", "0"));
String[] internalRoleIdsArr = internalRoleIds.split(",");

String externalRoleIds = GetterUtil.getString(portletPreferences.getValue("externalRoleIds", "0"));
String[] externalRoleIdsArr = externalRoleIds.split(",");


%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<div id="formContainer">

<aui:form action="<%=configurationURL%>" method="post" name="fm">
	<aui:input name="<%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" />

	<!-- Preference control goes here -->

	 <%
	 	String OPTION = "<option value='%s' %s>%s</option>";
	 	List<Role> roles = RoleLocalServiceUtil.getRoles(-1, -1);
	 %>

	  	<aui:select name="preferences--internalRoleIds--" label="Internal Roles" required="true" multiple="true">

		  <%
		  	
		  		       for (Role role :roles) {
		  		  		 String selected = "";
		  	     		 if (Arrays.asList(internalRoleIdsArr).contains(String.valueOf(role.getRoleId()))) {
		  	     			 selected = "selected";
		  	     		 }
		  		  		out.println(String.format(OPTION, role.getRoleId(), selected, role.getName()));
		  		  	  }
		  %>

	</aui:select>
	
	
	<aui:select name="preferences--externalRoleIds--" label="External Roles" required="true" multiple="true">

		  <%
		  	
		  			for (Role role :roles) {
		  		  		 String selected = "";
		  	     		 if (Arrays.asList(externalRoleIdsArr).contains(String.valueOf(role.getRoleId()))) {
		  	     			 selected = "selected";
		  	     		 }
		  	     		out.println(String.format(OPTION, role.getRoleId(), selected, role.getName()));
		  		  	  }
		  %>

	</aui:select>
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>
</div>