<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>

<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<%@ taglib	uri="/tld/sp-formio" prefix="sp-formio"%>  
<portlet:defineObjects />
<liferay-theme:defineObjects />

<% if(PermissionUtil.canEditModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
<%
String formId = portletPreferences.getValue(SystemSetupConstants.PREF_HTML_FORM_ID, "1720");
String formType = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME, "Candidate");
String dashBoardLink = SambaashUtil.getDashBoard();

String storageId = request.getParameter("storageId");
String userId = String.valueOf(themeDisplay.getUserId());
if(storageId != null && !storageId.equalsIgnoreCase("")){
	userId = storageId;
}
%>

<div class="newPortlets">	
<div class="subHeader"> 
	<div class="container">
		<div class="inner-container">
			<aui:row>
				<aui:col span="10" cssClass="text-center"><h2><span>UPLOAD DOCUMENT</span></h2></aui:col>
				<aui:col span="2" cssClass="text-right"><a href="<%= dashBoardLink %>" title="Back to Home">Back to Home</aui:a></aui:col>
			</aui:row>
		</div>
	</div>
</div>

<c:set var="formId" value="<%= formId %>"/>
<c:set var="formType" value='<%= formType %>' />
<c:set var="formStorageId" value='<%= userId %>' />

<div class="formRoot">
		<div class="innerFormRoot">

			<sp-formio:FormIO cssClass="formContainer" modelName ="${formType}" formId="${formId}" readOnly="false" formStorageId="0"  />
		</div>
	</div>


<div>
<h3>Important Guidelines</h3>
<div>
FORMAT : For a document, the acceptable file formats are .doc, .docs,& .pdf; For an image, the acceptable formats are .jpg & .png
</div>
<div>
FILE SIZE : For a document, the file size should not exceed beyond 1Mb; For an image, the file size should not exceed more than 5Mb.
</div>

</div>


</div>
<script type="text/javascript">
var mode = "create";
var userId = "<%= userId %>";
function afterFormLoadedFormIOForm(thisInstance){
	getDocumentId(thisInstance);
	thisInstance.components.Namespace.setValue(namespace);
}
function validateFormIOForm(thisInstance){
	
	var formdata = thisInstance.form.submission.data;
	console.log(formdata);
	//checkEmailAddress();
	if(formdata.FirstName == ""){
		thisInstance.form.setAlert("","Please Fill up First Name");
	}
	else{
		thisInstance.customSubmission(thisInstance.form.submission);
	}
}
function getDocumentId(thisInstance){
	var data1 = {};
	data1.formStorageId = userId;
	data1.formType = "candidatedocument";
	AUI().use('aui-io-request-deprecated', 'aui-base', function(A) {
		var _data = {};
		_data[namespace + 'formStorageId'] =  data1.formStorageId;
		_data[namespace + 'formType'] = data1.formType;
		_data[namespace + 'action'] = "loadData";
		if (data1) {
			_data[namespace + 'data'] = JSON.stringify(data1);

		}
		A.io.request(ajaxUrl, {
			dataType : 'json',
			method : 'GET',
			data : _data,
			on : {
				success : function() {
					 var response = this.get("responseData");
					if(response.contentJson.InfoDocumentId != undefined){
	             		   thisInstance.components.DocumentId.setValue(response.contentJson.InfoDocumentId);
	             	   }
				},
				failure : function() {

				}
			}
		});
	});
	
}
</script>
<% } %>