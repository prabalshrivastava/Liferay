<%@page import="com.liferay.portal.theme.ThemeDisplay"%>

<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
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
<style>
#addnew {
	display: none
}
</style>
<%@
taglib	uri="/tld/sp-formio" prefix="sp-formio"%>  
<portlet:defineObjects />

<% if(PermissionUtil.canViewListing( (PortletRequest) request.getAttribute("javax.portlet.request"))){ 
String modelName = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME, SystemSetupConstants.DEFAULTMODELAME);
ThemeDisplay td  = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
%>
<c:set var="formType" value='<%= modelName %>' />

<script>
var config = {
		createPage: "/html/invigilatorapplication/create.jsp",
	    editPage: "/html/invigilatorapplication/edit.jsp",
	    detailPage: "/html/invigilatorapplication/view.jsp",
	    prepareClaimPage: "/html/invigilatorapplication/prepare-claim.jsp"
	};
var basePage = "<%= td.getURLPortal() %>/";
</script>

<sp-formio:Listing cssClass="formContainer" modelName="${formType}" />

<% } %>	

<script>

var masterprofilepage = "/profile-summary";
function addNewRecord(d){
	AUI().use('liferay-portlet-url', function(A) {
	    var e =  Liferay.PortletURL.createRenderURL();
	    e.options.basePortletURL = baseUrl;
	    jspPage = config.createPage;
	    e.setParameter("formTypeName", modelName);
	    e.setParameter("jspPage", jspPage);
	    e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
	    e.setWindowState("normal");
	    //window.location.href = e.toString();
	    var pattern = /__/g;
	    var dd = e.toString();
	    window.location.href = dd.replace(pattern,"_").replace(/invigilatorlisting/g, 'invigilatorapplication');
	   
	 });
}

function doAction(action,d) {
	AUI().use('liferay-portlet-url', function(A) {
	   var c = findAncestor(d, "Row");
	   var a = [];
	   for (var b = 0; b < c.childElementCount; b++) {
	       a.push(c.children[b].textContent.trim())
	   }
	   var e =  Liferay.PortletURL.createRenderURL();
	   e.options.basePortletURL = baseUrl;
	   if(action == 'masterview'){
		   openMaterView(a[0]);
	   }
	   else{
		   if(action == 'edit'){
			   e.setParameter("jspPage", config.editPage);   
		   }else if(action == 'detail'){
			   e.setParameter("jspPage", config.detailPage);   
		   }else if(action == 'copy'){
			   e.setParameter("jspPage", config.copyPage);   
		   }
		   e.setParameter("formTypeName", modelName);
		   e.setParameter("storageId", a[0]);
		   e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
		   e.setWindowState("normal");
		   console.log(e.toString());
		   window.location.href =  e.toString().replace(/invigilatorlisting/g, 'invigilatorapplication');
	   }
	});
}
var ajaxUrl = ajaxurl;
var mode = "view";
function openMaterView(storageId){
	
	var data1 = {"formStorageId":storageId};
	ajaxCallAPI('GET','fetchScreenName',data1,
	 	function() {
			
              var response = this.get("responseData");
              
              if (_.isEmpty(response)) {
                  console.log("error");
                  
              } else {
            	  window.location.href = basePage + response;
              }
          },
          function() {
              
   		});
	
}

if(document.readyState == 'complete') {
	init();
} else {
	window.addEventListener('load', init);
}
function init() {
	var listingMenus = document.getElementsByClassName("listingPopover");
	for(var i in listingMenus) {
		console.log("listingMenus[i] : "+listingMenus[i].tagName);
		if(listingMenus[i].tagName == "DIV") {
			var listingMenu = listingMenus[i].getElementsByTagName("ul")[0];
			listingMenu.innerHTML = '<li><img src="/html/images/details.png" alt="Prepare Claims"><a href="javascript:void(0);" onclick="openPrepareClaimsScreen(this);">Prepare Claims</a></li>' + listingMenu.innerHTML;
		}
	}
}
function openPrepareClaimsScreen(d) {
	AUI().use('liferay-portlet-url', function(A) {
		var c = findAncestor(d, "Row");
		var a = [];
		for (var b = 0; b < c.childElementCount; b++) {
			a.push(c.children[b].textContent.trim())
		}
		var e =  Liferay.PortletURL.createRenderURL();
		e.options.basePortletURL = baseUrl;
		e.setParameter("jspPage", config.prepareClaimPage);   
		e.setParameter("formTypeName", modelName);
		e.setParameter("storageId", a[0]);
		e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
		e.setWindowState("normal");
		window.location.href =  e.toString().replace(/invigilatorlisting/g, 'invigilatorapplication');
	});
}
<%
if(PermissionUtil.canAddModel(renderRequest)) {
    %>document.getElementById("addnew").style.display = "block";<%
}
%>
</script>