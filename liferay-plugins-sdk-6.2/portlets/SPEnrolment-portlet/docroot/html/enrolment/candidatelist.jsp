<%@page import="com.liferay.portal.theme.ThemeDisplay"%>

<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<liferay-theme:defineObjects />

<%@
taglib	uri="/tld/sp-formio" prefix="sp-formio"%>  
<portlet:defineObjects />

<% if(PermissionUtil.canViewListing( (PortletRequest) request.getAttribute("javax.portlet.request"))){ 
	String modelName = "Candidate";
%>

<c:set var="formType" value='Candidate' />

<script>
var config = {
		createPage: "/html/enrolment/candidate.jsp",
	    editPage: "/html/enrolment/edit.jsp",
	    detailPage: "/html/enrolment/detail.jsp",
	    copyPage: "/html/enrolment/copy.jsp"
};
</script>

<sp-formio:Listing cssClass="formContainer" modelName="Candidate" />

<% } %>	
<script>
/* window.addEventListener("load", function(){
	if(document.getElementById("tableId")!=null){
		console.log("Table Availble  " + document.getElementById("tableId").rows);
		var tableRows = document.getElementById("tableId").rows;
	 if(tableRows.length>1)
			{
			var counter=0;
			for(var row in tableRows)
				if(counter>0)
				console.log("Row :: "+ counter + "  :: "+row);
			} 
		}else {
			console.log(" No Table FOune");
		}
}); */

</script>
