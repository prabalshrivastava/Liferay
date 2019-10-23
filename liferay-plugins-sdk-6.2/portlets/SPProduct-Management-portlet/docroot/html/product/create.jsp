<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
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
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2"></script>
<%@ taglib	uri="/tld/sp-formio" prefix="sp-formio"%> 
<portlet:defineObjects />

<portlet:renderURL var="programmeListing">
	<portlet:param name="jspPage"
		value="/html/product/list.jsp" />
</portlet:renderURL>


<% if(PermissionUtil.canAddModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
<%
String preference = renderRequest.getPreferences().getValue("preference","");
JSONObject prefData = JSONFactoryUtil.createJSONObject(preference);
String mixedModelName = prefData.getString("model1",""); 
String 	modelName = "";

String[] stringArray = mixedModelName.split(",");
if(stringArray.length > 1 &&  stringArray[1].split("-").length > 0){
	modelName = stringArray[1].split("-")[0];
}

if(request.getParameter("formTypeName") != "" && request.getParameter("formTypeName") != null){
	modelName = request.getParameter("formTypeName");
}

String formId = stringArray[0];
String baseUrl = portletPreferences.getValue("baseUrlPref", "");
String dashBoardLink = SambaashUtil.getDashBoard();
%>
<style>
	.aui .newPortlets .form-group {
  		margin-bottom: 15px;
	}
</style>
<div class="newPortlets">
<div class="subHeader">
	<div class="container">
		<div class="inner-container">
			<aui:row>
				<aui:col span="10" cssClass="text-center"><h2><span><%= modelName.toUpperCase() %> SETUP</span></h2></aui:col>
				<aui:col span="2" cssClass="text-right"><a href="<%= dashBoardLink %>" title="Back to Home">Back to Home</a></aui:col>
			</aui:row>
		</div>
	</div>
</div>
<c:set var="formId" value="<%= formId %>"/>
<c:set var="formType" value='<%= request.getParameter("formTypeName") %>' />
	<div class="formRoot">
		<div class="innerFormRoot">
			<sp-formio:FormIO cssClass="formContainer"  modelName ="${formType}" formId="${formId}" readOnly="false" formStorageId="0"  />
		</div>
	</div>
</div>
<script type="text/javascript">

var mode = "create";
var formId =  "<%= formId %>";
var baseUrl = "<%= baseUrl %>";
function validateFormIOForm(thisInstance){
	thisInstance.customSubmission(thisInstance.form.submission);
}
function afterFormLoadedFormIOForm(thisInstance){
	thisInstance.components.Namespace.setValue(namespace);
}
function afterFormSubmissionFormIOForm(thisInstance){
	
	if(thisInstance.components.Status.value != "Active"){
		var status = thisInstance.form.submission.data.Status;
		var msg = "";
		var boundingBox = "#sucess-popup";
		var contentBox = "#sucess-popup-box";
		var formTypeStr = thisInstance.formType.replace(/([a-zA-Z])(?=[A-Z])/g, '$1 ');
		if(actionPerformed == "Draft"){
			msg = thisInstance.formType + " saved to Draft";
		}else if(formStorageId == "0"){
			msg = formTypeStr + " Created!";
		}
		else if(actionPerformed == "Activated"){
			msg = formTypeStr + " Activated!";
			boundingBox = "#activation-success";
	    	contentBox = "#active-success-box";
		}
		else if(actionPerformed == "Deactivated" ){
			msg = formTypeStr + " Deactivated!";
			boundingBox = "#deactivation-success";
	    	contentBox = "#inactive-success-box";
		}
		else {
			msg = formTypeStr + " Updated!";
		}
		document.getElementById('success-msg').innerHTML = msg;  
		AUI().use('aui-base', function(A) {
			
	        A.one(boundingBox).set('hidden', false);
	        
	        YUI().use('aui-modal', function(Y) {
	           var modal = new Y.Modal({
	                           boundingBox: boundingBox,
	                           contentBox: contentBox,
	                           headerContent: '',
	                           centered: true,
	                           destroyOnHide: false,
	                           modal: true,
	                           resizable: false,
	                           draggable: false,
	            }).render();
	           Y.all('.close').on(
		         	      'click',
		         	      function() {
		         	    	reload();
		         	        modal.hide();
		         	      }
		         	    );
	        });

	    });
	}else{
		AUI().use('liferay-portlet-url', function(A) {
		    var e =  Liferay.PortletURL.createRenderURL();
		    e.options.basePortletURL = baseUrl;
		    jspPage = "/html/product/success.jsp";
		    e.setParameter("jspPage", jspPage);
		    e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
		    e.setWindowState("normal");
		    //window.location.href = e.toString();
		    var pattern = /__/g;
		    var dd = e.toString();
		    window.location.href = dd.replace(pattern,"_");
		 });
	}
	
}
</script>
<% } %>
