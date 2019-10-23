<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:resourceURL var="ajaxURL" />
<div id="myStartups" class="myStartups">
	<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.startup")%> <b><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.profiles")%></b></h2>
	<div id="mystartupsContainer" class='maxChar'>
		<div class="mystartup">
			<span id="noStartups"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.no.startups.created.yet")%></span>
			<div class="mystartup_content">
				<ul>
					
				</ul>
			</div>
		</div>
	</div>
</div>
<script src="/StartupProfile-portlet/js/mystartups.js" type="text/javascript"></script>
<script>
<%
long profileUserId = SambaashUtil.getUserIdByScreenName(
		themeDisplay.getCompanyId(), themeDisplay.getURLCurrent());

if(Validator.isNull(profileUserId))
	profileUserId = themeDisplay.getUserId();
%>
AUI().ready(function(A){
  initializeMyStartups(<%=profileUserId%>, <%=themeDisplay.getUserId()!=profileUserId%>, '<%=ajaxURL%>','<%=themeDisplay.getPathThemeImages()%>','<portlet:namespace/>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.failed.retrieve.startups")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.failed.delete.startups")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.confirm.delete.startup")%>');
});
</script>
