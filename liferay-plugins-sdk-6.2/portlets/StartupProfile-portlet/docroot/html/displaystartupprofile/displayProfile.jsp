<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<%@ taglib	uri="/tld/sp-ui" prefix="sp-ui"%>
<%@ taglib uri="/tld/sp-formio" prefix="sp-formio"%>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<% String phone = StringPool.BLANK;
String email = StringPool.BLANK;
String website = StringPool.BLANK;%>
<% 
if(renderRequest.getAttribute("phone") != null)
{phone = renderRequest.getAttribute("phone").toString();}
if(renderRequest.getAttribute("email") != null)
{email = renderRequest.getAttribute("email").toString();}

if(renderRequest.getAttribute("website") != null)
{website = renderRequest.getAttribute("website").toString();}


if(renderRequest.getAttribute("coverObj") != null){
	JSONObject coverObj = (JSONObject)renderRequest.getAttribute("coverObj");
	%>
	<style>
	.aui .CorporateProfile header {
    	background: url(<%= coverObj.getString("logoUrl")  %>) no-repeat;
   	}
	</style>
	
	
	<%
}
%>
<div class="CorporateProfile">
<header>
	<ul>
		<li><a href="<%= website %>" class="logoContact"><img src="${logoUrl}" alt="logo"></a></li>
		<li>${name}  </li>
		<li><a href="<%= website %>" class="link-icon" title="<%= website %>"></a></li>
		<li>
			<ul>
				<% if(renderRequest.getAttribute("country") != null){ %>
				<li><%=renderRequest.getAttribute("country") %></li>
				<% } %>
				<% if(renderRequest.getAttribute("foundedOn") != null){   %>
				<li>Founded on <%=renderRequest.getAttribute("foundedOn")%> </li>
				<% } %>
			</ul>
		</li>
	</ul>
</header>
<div class="menu">
	<div class="container">
	<ul>
		<li class="active">About</li>
		<li><a href="<%=renderRequest.getAttribute("editFriendlyUrl")%>"  class="active">More Info</a></li>
		<li><a href="<%=renderRequest.getAttribute("editFriendlyUrl")%>"  class="btn btn-primary">Edit Profile</a></li>
	
	
	</ul>
	</div>
</div>
<div class="container">
<aui:row>
	<aui:col span="9">
		<div class="boxWhite contact">
			<h2>CONTACT DETAILS</h2>
			
			<ul>
				<% if(phone != StringPool.BLANK){ %>
				<li><a href="tel:<%= phone %>" class="contact-icon" title="<%= phone %>"><%= phone %></a></li>
				<% } if(email != StringPool.BLANK){ %>
				<li><a href="mailto:<%= email %>" class="envolope-icon" title="<%= email %>"><%= email %></a></li>
				<% } if(website != StringPool.BLANK){ %>
				<li><a href="<%= website %>" class="link-icon" title="<%= website %>"><%= website %></a></li>
				<% }%>
			</ul>
		</div>
		<div class="boxWhite">
			<h2>COMPANY BACKGROUND</h2>
			<p><%=renderRequest.getAttribute("fullDescription")%></p>
		</div>
	</aui:col>
	<aui:col span="3">
	<div class="boxWhite">
		<h2>Location</h2>
		<ul>
			<%   if(renderRequest.getAttribute("blockNo") != null){ %>
			<li><%= renderRequest.getAttribute("blockNo") %>,</li>
			<% } if(renderRequest.getAttribute("streetName") != null){ %>
			<li><%= renderRequest.getAttribute("streetName") %>,</li>
			<% } if(renderRequest.getAttribute("unitNo") != null){ %>
			<li><%= renderRequest.getAttribute("unitNo") %>,</li>
			<% } if(renderRequest.getAttribute("buildingName") != null){ %>
			<li><%= renderRequest.getAttribute("buildingName") %></li>
			<% } %>
		</ul>	
	</div>
	</aui:col>
</aui:row>
</div>
</div>
<script>

</script>