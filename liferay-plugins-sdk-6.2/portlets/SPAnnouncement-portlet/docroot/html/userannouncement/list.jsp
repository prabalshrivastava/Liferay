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


<script>
var UserId="<%=  themeDisplay.getUserId() %>";
var filter = ["contentJson.UserId="+"<%=  themeDisplay.getUserId() %>"];
</script>

<%@
taglib	uri="/tld/sp-formio" prefix="sp-formio"%>  
<portlet:defineObjects />

<% if(PermissionUtil.canViewListing( (PortletRequest) request.getAttribute("javax.portlet.request"))){ 
String modelName = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME, SystemSetupConstants.DEFAULTMODELAME);

%>
<c:set var="formType" value='<%= modelName %>' />

<script>
var config = {
		createPage: "/html/userannouncement/create.jsp",
	    editPage: "/html/userannouncement/edit.jsp",
	    detailPage: "/html/userannouncement/view.jsp",
	    copyPage: "/html/userannouncement/copy.jsp"
	};

</script>

<sp-formio:Listing cssClass="formContainer" modelName="${formType}" />

<% } %>	
<script>
function loadList(){
    var itemsSelect = document.getElementById("<portlet:namespace/>itemsPerPage");
 	itemsPerPage = itemsSelect.options[itemsSelect.selectedIndex].value;
 	
 	var data = {"limit":itemsPerPage,"modelName":modelName,"page":(pageRequested - 1),"formType":modelName};
 	if( typeof filter != 'undefined' && filter != null ){ 
 		data.conditions = filter;
 	}
 	data.sortBy = "contentJson.Message";
 	ajaxCall('GET','searchList',ajaxurl,data,
		 function() {
                var data = this.get("responseData");
                if (_.isEmpty(data)) {
                    console.log("error");
                    
                } else {
                	tableData = data.content;
                	totalRecords = data.totalElements;
                	totalPages = data.totalPages;
                    reloadTable(tableData,false);
                    if(pageRequested == 1){
                    	drawPagination(pageRequested)
                    }
                   
                }
            },
            function() {
                
     		});
	 
 
 }


</script>