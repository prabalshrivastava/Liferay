<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="javax.portlet.PortletPreferences"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %>



<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />


<%
	String accessKeyId = GetterUtil.getString(portletPreferences
			.getValue("accessKeyId", ""));
	String secretAccessKey = GetterUtil.getString(portletPreferences
			.getValue("secretAccessKey", ""));
	String bucketName = GetterUtil.getString(portletPreferences
			.getValue("bucketName", ""));
	String logFilePath = GetterUtil.getString(portletPreferences
			.getValue("logFilePath", ""));
	String cronExpression = GetterUtil.getString(portletPreferences
			.getValue("cronExpression", ""));
	String rootFolder = GetterUtil.getString(portletPreferences
			.getValue("rootFolder", "")); 
	boolean creationDate = GetterUtil.getBoolean(portletPreferences.getValue("creationDate", StringPool.TRUE));
	boolean deleteFile = GetterUtil.getBoolean(portletPreferences.getValue("deleteFile", StringPool.TRUE));
%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationURL" />
<div id="formContainer">

	<aui:form action="<%=configurationURL%>" method="post" name="fm" id="fm">
		<aui:input name="<%=Constants.CMD%>" type="hidden"
			value="<%=Constants.UPDATE%>" />


		<aui:input label="Access Key ID" name="preferences--accessKeyId--" type="text"
			value="<%=accessKeyId%>"></aui:input>
		<aui:input label="Secret Access Key" name="preferences--secretAccessKey--"
			type="text" value="<%=secretAccessKey%>"></aui:input>
		<aui:input label="Bucket Name" name="preferences--bucketName--" type="text"
			value="<%=bucketName%>"></aui:input>
		<aui:input label="Root Folder" name="preferences--rootFolder--" type="text"
			value="<%=rootFolder%>" required="true"></aui:input>
		<aui:input label="Log File Path" id="logFilePath" name="preferences--logFilePath--" type="text"
			value="<%=logFilePath%>"></aui:input>
		<aui:input label="Cron Expression" name="preferences--cronExpression--" type="text"
			value="<%=cronExpression%>"></aui:input>
		<aui:input label="Creation Date" name="preferences--creationDate--" type="checkbox" 
			value="<%=creationDate%>"></aui:input>
		<aui:input label="Delete File" name="preferences--deleteFile--" type="checkbox" 
			value="<%=deleteFile%>"></aui:input>
		<aui:button-row>
			<aui:button type="button" onClick="validateFilePattern()" id="save" name="save" value="Save" />	
		</aui:button-row>
		
	</aui:form>
</div>

<liferay-portlet:resourceURL portletName="${param.portletResource}" var="ajaxUrl">
</liferay-portlet:resourceURL>

<script type="text/javascript">

var pns1 = "<portlet:namespace/>"
var pns = "<portlet:namespace/>logFilePath";
var pns2 = "<portlet:namespace/>creationDate";


function validateFilePattern(){
	var logFile = document.getElementById(pns).value;
	var createDate = document.getElementById(pns2).value;
    AUI().use('aui-io-request', function(A){
        A.io.request('<%=ajaxUrl.toString()%>', {
               method: 'POST',
               dataType: 'json',
               data:{
            	   "logFilePath": logFile,
            	   "creationDate": createDate
               },
               on: {
                    success: function() {
                    	
                    	if(this.get('responseData').result === "Details saved successfully"){
                    		document.getElementById(pns1+"fm").submit();
                    	} else{
                    		alert(this.get('responseData').result);
                    	}
                    },
               		failure: function() {
               			
               		}
               }
            });
    });
	}



</script>


