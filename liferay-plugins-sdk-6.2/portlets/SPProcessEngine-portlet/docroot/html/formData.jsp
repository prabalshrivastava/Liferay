<%@page import="com.sambaash.platform.constant.PEConstantsGlobal"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.sambaash.platform.pe.helpers.PEJSPDisplayHelper" %>
<%@ page import="com.sambaash.platform.pe.constants.PEConstants" %>
<%@ page import="com.sambaash.platform.pe.PEOutput" %>
<%@ include file="init.jsp" %>

<%
	PEOutput output =(PEOutput) renderRequest.getAttribute(PEConstants.ATTR_OUTPUT);

long processStateId = 0;
if (output.getProcessState() != null && output.getProcessState().getUserIdProcess() != 0) {
	processStateId = output.getProcessState().getSpPEProcessStateId();
}
%>

<portlet:actionURL name="process" var="processUrl">
</portlet:actionURL>
<aui:form action="<%= processUrl %>" name="form">
<aui:input name="formData"  type="hidden"></aui:input>
<aui:input name="processStateId"  type="hidden" value="<%= processStateId %>"></aui:input>
<aui:input name="nodeId"  type="hidden" value="<%= output.getNodeId() %>"></aui:input>
<aui:input name="classPK"  type="hidden" value="<%= output.getClassPk() %>"></aui:input>
<aui:input name="classNameId"  type="hidden" value="<%= output.getClassNameId() %>"></aui:input>
<aui:input name="processId"  type="hidden" value="<%= output.getProcessId() %>"></aui:input>
<aui:input name="actionType"  type="hidden" value="<%= output.getAction() %>"></aui:input>
</aui:form>
<script type="text/javascript">

//var pns ="<portlet:namespace/>";
function submitFormData(jsonData){
	console.log("submitFormData " + jsonData);
	/*var dataNode = A.one("#" + pns + "formData");
	var dataStr = JSON.stringify(jsonData);
	dataNode.val(dataStr);*/
	//console.log("Value set in data hidden element in form"+dataNode.val());
	setJsonDataToForm(jsonData);
	var form = A.one("#" + pns + "form");
	form.submit();
}
function submitJSP(jsonData){
	setActionAsSubmit();
	submitFormData(jsonData)
}

function setJsonDataToForm(jsonData){
	var dataNode = A.one("#" + pns + "formData");
	var dataStr = JSON.stringify(jsonData);
	dataNode.val(dataStr);
}

function getFormDataInJsonFormat(){
	var form = A.one("#" + pns + "form");
	var data = {};
	form.all("input,select,textarea").each(function(node){
		data[node.get('name')] = node.val();
	});
	return data;
}

function setActionAsSave(){
	A.one("#" + pns + "actionType").val("<%= PEConstantsGlobal.ACTION_SAVE %>");
}
function setActionAsSubmit(){
	A.one("#" + pns + "actionType").val("<%= PEConstantsGlobal.ACTION_SUBMIT %>");
}

function saveFormJspViaAjax(ajaxUrl,jsonData,task,callBackMethod){
	setJsonDataToForm(jsonData);
	setActionAsSave();
	var data = getFormDataInJsonFormat();
	data["task"] = task;  
	var contentId = "";
	startPreLoader(contentId);
	A.io.request(ajaxUrl,{
        dataType: 'json',
        method: 'POST',
        data: data,
        sync: true,
        on: {
	        complete: function(){
	        	stopPreLoader(contentId);
	        },
	        success: function() {
	            var responseData=this.get('responseData');
	            callBackMethod(responseData);
	          },
		    failure : function(){
		    	error = "Error while saving";
		    	alert(error);
		    }
        }
    });
}
</script>
<script type="text/javascript">
</script>
