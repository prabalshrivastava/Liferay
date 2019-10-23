<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@page import="com.sambaash.platform.portlet.profile.ProfileConstants"%>
<%@page import="com.sambaash.platform.portlet.profile.util.PermissionUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>


<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css"/>
<liferay-theme:defineObjects />
<portlet:defineObjects />

<%
String userId = String.valueOf(renderRequest.getAttribute("userId"));
%>


<portlet:resourceURL var="resourceURL" />

<portlet:renderURL var="renderURL">
	<portlet:param name="<%=ProfileConstants.PARAM_LOAD_OBJECTS%>"
		value="<%=ProfileConstants.PARAM_LOAD_OBJECTS%>" />
		<portlet:param name="userId"
		value="<%=userId%>" />
</portlet:renderURL>


<!--  Header -->
    
    <div class="cm-profileView" style="margin-top:45px;" id="cm-profileView">
   
            
</div>

<script>
var namespace = "<portlet:namespace/>";
var userId = <%= userId %>;

</script>
    
    <aui:script
	use="aui-node,aui-base,aui-io-request-deprecated,liferay-util-window,aui-io-plugin-deprecated">
	var ajaxRenderUrl = '<%=renderURL%>';
	var ajaxResourceUrl = '<%=resourceURL%>';
	
	if (A.one('.missing-config')) {
		displayPopupMessage("Please use the 'configuration' menu-item to configure the portlet");
	} else {
		initializeFilters(A, ajaxRenderUrl, ajaxResourceUrl,"<portlet:namespace/>",<%=PermissionUtil.getPermittedNavConfig(themeDisplay, portletPreferences,userId)%>);
	}
	
	function displayPopupMessage(msg,titleMsg){
		titleMsg = titleMsg ? titleMsg : "Warning";
		var dialog =	Liferay.Util.Window.getWindow({
				title : titleMsg,	
				dialog: {
						bodyContent : msg,
						centered : true,
						cache: false,
						destroyOnClose: true,
						destroyOnHide: true,
						height : 250,
						width : 400,
						modal : true,
						constrain2view : true,
						toolbars:{ footer:[{label:'Ok', on: { click:function() {dialog.hide();}}}]}
					}}).render();
			
	}
</aui:script>
