<%@page import="com.sambaash.platform.srv.processbuilder.service.PEEngineServiceUtil"%>
<%@page import="com.sambaash.platform.pe.jaxb.PEFormV2"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sambaash.platform.pe.helpers.PEUrlHelper"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.sambaash.platform.session.SPAuthContext"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.sambaash.platform.pe.helpers.PEProcessHelper"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.sambaash.platform.pe.PEDataSource"%>
<%@page import="com.sambaash.platform.pe.constants.PEConstants"%>
<%@page import="com.sambaash.platform.pe.PEOutput"%>
<%@page import="java.util.Calendar"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>

<%@ include file="init.jsp" %>
<style>
.aui .newPortlets .formContainer .formio-choices .form-control {
    height: auto !important;
}
</style>
<%
	PEOutput output =(PEOutput) renderRequest.getAttribute(PEConstants.ATTR_OUTPUT);
	String formId = String.valueOf(output.getFormV2Id());
	String formStorageId = String.valueOf(output.getStorageId());
	if (output.getAudit()!=null) {
		formStorageId = JSONFactoryUtil.createJSONObject(output.getAudit().getData1()).getString("formStorageId");
	}
	boolean canEdit = output.getProcessState().isNew() || output.isCanEdit();
	String readOnly = String.valueOf(!canEdit);
	long processStateId = 0;
	long userIdProcess = 0;
	if (output.getProcessState() != null && output.getProcessState().getUserIdProcess() != 0) {
		processStateId = output.getProcessState().getSpPEProcessStateId();
		userIdProcess = output.getProcessState().getUserIdProcess();
	}
	long processId = output.getProcessId();
	PEDataSource datasource = output.getDataSource();
	String cancelUrl = PEUrlHelper.getUrlHelper(datasource).getFormattedListingPageURL();
	boolean reprocessingHalted = !output.getValidationMsgs().isEmpty() && PEConstants.REPROCESSING_STOPPED_MSG.equals(output.getValidationMsgs().get(0));
	long _scopeGroupId = SambaashUtil.getScopeGroupId(themeDisplay.getScopeGroupId());
	String _firstName = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest)).getParameter("firstName");
	String _lastName = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest)).getParameter("lastName");
	String _emailAddress = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest)).getParameter("emailAddress");
	String _applicantId = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest)).getParameter("applicantId");
	String _applicationTranCode = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest)).getParameter("applicationTranCode");
	PEFormV2 node = (PEFormV2) datasource.getDirectory().getNode(output.getNodeId());
	boolean isCurrentNode = output.getProcessState().getNodeId() == node.getNodeId();
	String _mode = output.isCanEdit() && !node.isReprocessable() && !isCurrentNode ? "save" :
			(output.isCanEdit() || output.isCanSubmit()) && !reprocessingHalted ? output.getAction() 
			: "view";
	// single submission on first page only
// 	boolean isSingleSubmission = node.getNodeId() == 1 && datasource.getProcess().isEnableSingleSubmission();
	boolean isSingleSubmission = _mode.equals("submit") && datasource.getProcess().isEnableSingleSubmission() && datasource.isFirstRequest();
%>

<portlet:resourceURL var="resourceURL" >
	<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
</portlet:resourceURL>

<jsp:include page="/html/formData.jsp"></jsp:include>

<div class="newPortlets">
	<div id='formio' class="formContainer container" ></div>
</div>

<aui:script use="aui-base,aui-node,aui-io-request">
	
	AUI().on('domready', function () {
		var namespace = '<portlet:namespace/>';
		var userInfo = <%= SambaashUtil.getUserInfo(themeDisplay).toString() %>;
		var apiUrl = '<%= SambaashUtil.getFormV2BaseUrl() %>';
		var formId = "<%= formId %>";
		var formStorageId = "<%= formStorageId %>";
		var ajaxUrl =  "<%=resourceURL%>";
		var p_auth =  "<%= AuthTokenUtil.getToken(request) %>";
		var _mode = "<%= _mode %>";
		var _onBehalfOfFirstName = "<%= StringUtils.isEmpty(_firstName) ? "" : _firstName %>";
		var _onBehalfOfLastName = "<%= StringUtils.isEmpty(_lastName) ? "" : _lastName %>";
		var _onBehalfOfEmail = "<%= StringUtils.isEmpty(_emailAddress) ? "" : _emailAddress %>";
		var _onBehalfOfApplicantId = "<%= StringUtils.isEmpty(_applicantId) ? "" : _applicantId %>";
		var _applicationTranCode = "<%= StringUtils.isEmpty(_applicationTranCode) ? "" : _applicationTranCode %>";
		
		console.log("formStorageId="+formStorageId);
		var _option = {
				readOnly: <%= !(output.isCanEdit() || output.isCanSubmit()) || reprocessingHalted %>
		};
		console.log(">>> Loading form v2", _mode);
		Formio.setPlatformAuth("<%= AuthTokenUtil.getToken(request) %>");
		setTimeout( () => {
			var formInstance = new SPProcessEngineForm(p_auth, apiUrl, 'formio', formId, formStorageId, ajaxUrl, namespace, userInfo,
				<%= processId %>, "<%= processStateId %>", "<%= output.getNodeId() %>", 
				"<%= output.getClassPk() %>", "<%= output.getClassNameId() %>", _mode,"<%= cancelUrl%>"
				, <%= _scopeGroupId %>, <%= userIdProcess %>, <%= isSingleSubmission %>);	
				
	        window.SPFormControl = new SPFormController(formInstance);
	        formInstance.load(_option);
	        if (_mode == "view") {
	            formInstance.on("formPopulated", function() {
	            	AUI().all(".editRow, .removeRow")._nodes.forEach(function(n){ n.style.display="none"; });
	            });
	        }
	        formInstance.on("formLoaded", function() {
	            if (_onBehalfOfEmail) {
	    			console.log("Got application on behalf of", _onBehalfOfEmail, _onBehalfOfFirstName, _onBehalfOfLastName);
		        	SPFormControl.setValue("_APPLICANT_FIRST_NAME", _onBehalfOfFirstName, true, true);
		        	SPFormControl.setValue("_APPLICANT_LAST_NAME", _onBehalfOfLastName, true, true);
		        	SPFormControl.setValue("_APPLICANT_EMAIL", _onBehalfOfEmail, true, true);
		        	try {
		        		// try to set for hidden component assumed to be in the form
		            	if (_onBehalfOfApplicantId) {
		            		SPFormControl.setValue("_USER_ID_PROCESS", _onBehalfOfApplicantId, true, true);
		            	}
		               	SPFormControl.setValue("firstName", _onBehalfOfFirstName, true, true);
		            	SPFormControl.setValue("lastName", _onBehalfOfLastName, true, true);
		            	SPFormControl.setValue("emailAddress", _onBehalfOfEmail, true, true);
		        	} catch (e) {
		        		console.log("error setting applicant details", e);
		        	}
	            }
	            if (_applicationTranCode) {
	            	try {
	            		// try to set for hidden component assumed to be in the form
	                	SPFormControl.setValue("applicationTranCode", _applicationTranCode, true, true);
	            	} catch (e) {
	            		console.log("error setting applicationTranCode", e);
	            	}
	            }
	        });
		});
        
	});
	
</aui:script>
