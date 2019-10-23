<%@ include file="init.jsp" %>

<%@ page import="com.liferay.portal.security.auth.CompanyThreadLocal" %>
<style type="text/css">

#child-navigation {
display:none;
}

</style>

<script type="text/javascript">

function redirect_home(mpNameTo,compId,id,communityPath) {
	var msg ="Your membership package has been successfully upgraded to <b>" + mpNameTo + "</b>";
	var title="Confirmation for Membership Upgrade";
	jAlert(msg,title);
	var communityName= '<%= communityName %>';
	var locationUrl = communityPath+"/home?myProfile=dashBoard&mode=view&compId=" + compId + "&id=" + id;
	window.location = locationUrl;
}
</script>

<%

//response.sendRedirect("web/"+communityName+"/home?upgrade=true");
String mpNameTo = (String)request.getAttribute("mpNameTo");
String compId = (String)request.getAttribute("compId");
String id = (String)request.getAttribute("id");
String communityPath = SambaashUtil.getCommunityPath(groupId);
if (mpNameTo != null) {
%>

<script type="text/javascript">
redirect_home('<%= mpNameTo %>','<%= compId %>','<%= id %>','<%= communityPath %>');
</script>

<% } %>