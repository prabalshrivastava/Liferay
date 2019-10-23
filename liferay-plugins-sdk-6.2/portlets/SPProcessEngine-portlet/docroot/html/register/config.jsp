<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="com.sambaash.platform.pe.PEEntityClassRegister"%>
<%@ page import="com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil" %>
<%@ page import="com.sambaash.platform.srv.processbuilder.service.PEProcessLocalService" %>
<%@ page import="com.sambaash.platform.srv.processbuilder.model.PEProcess" %>
<%@ page import="com.liferay.portal.service.ClassNameLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.ClassName" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ include file="/html/init.jsp" %>

<%
long entityClassId = GetterUtil.getLong(portletPreferences.getValue("classNameId", "0"));
long classPk = GetterUtil.getLong(portletPreferences.getValue("classPK", "0"));
String classPKSavedCode = GetterUtil.getString(portletPreferences.getValue("classPKSavedCode", "0"));
long processId = GetterUtil.getLong(portletPreferences.getValue("processId", "0"));
String showProcessProgress = GetterUtil.getString(portletPreferences.getValue(PEConstants.SHOW_PROCESS_PROGRESS, "1"));
String enableTempStorageValidation = GetterUtil.getString(portletPreferences.getValue(PEConstants.ENABLE_TEMP_STORAGE_VALIDATION, "false"));
boolean mobileSupport = GetterUtil.getBoolean(portletPreferences.getValue(PEConstants.PREF_MOBILE_SUPPORT, ""));
String enableTempStorageValidationStepNumber = GetterUtil.getString(portletPreferences.getValue(PEConstants.ENABLE_TEMP_STORAGE_VALIDATION_STEP_NUMBER, ""));
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<div id="formContainer">

<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input id="classPKSaved" name="classPKSaved" type="hidden" value="<%= classPk %>" />
	<aui:input id="classPKSavedCode" data-id="classPKSavedCode" name="preferences--classPKSavedCode--" type="hidden" value="<%= classPKSavedCode %>" />

	<!-- Preference control goes here -->

	 <%
	     	 String OPTION = "<option value='%s' %s>%s</option>";
	  %>

	  	<aui:select name="preferences--processId--" label="process-id" data-id="processId">

		  <%
		  	  List<PEProcess> processes = PEProcessLocalServiceUtil.getPEProcesses(-1, -1);
		      out.println(String.format(OPTION, StringPool.BLANK, StringPool.BLANK, StringPool.BLANK));
		  	  for (PEProcess process :processes) {
		  		 String selected = "";
	     		 if (processId == process.getSpPEProcessId()) {
	     			 selected = "selected";
	     		 }
		  		out.println(String.format(OPTION, process.getSpPEProcessId(),selected,process.getName()));
		  	  }
		  %>

	</aui:select>
	
	<aui:select name="preferences--classNameId--" label="entity-class-name" data-id="classNameId">

		  <%
		  	  Map<Long,String>names = PEEntityClassRegister.getEntityClassNames(); 
		      out.println(String.format(OPTION, StringPool.BLANK, StringPool.BLANK, StringPool.BLANK));
		  	  for (Entry<Long,String>entry:names.entrySet()) {
		  		 String selected = "";
	     		 if (entityClassId == entry.getKey()) {
	     			 selected = "selected";
	     		 }
		  		out.println(String.format(OPTION, entry.getKey(),selected,entry.getValue()));
		  	  }
		  %>

	</aui:select>
	
	<aui:select name="preferences--showProcessProgress--" label="show-process-progress" data-id="showProcessProgress">

		      <aui:option value="1" label="Yes" selected='<%= showProcessProgress.equalsIgnoreCase("1")%>'/> 
		      <aui:option value="2" label="No" selected='<%= showProcessProgress.equalsIgnoreCase("2")%>'/> 

	</aui:select>

	<aui:select data-id="classPK" label="entity-name" name="preferences--classPK--">
	</aui:select>
	
	<aui:select name="preferences--enableTempStorageValidation--" label="enable-temp-storage-validation" data-id="enableTempStorageValidation">

		      <aui:option value="true" label="Yes" selected='<%= enableTempStorageValidation.equalsIgnoreCase("true")%>'/> 
		      <aui:option value="false" label="No" selected='<%= enableTempStorageValidation.equalsIgnoreCase("false")%>'/> 

	</aui:select>
	
	
	<aui:input name="preferences--enableTempStorageValidationStepNumber--" label="enable-temp-storage-validation-step-name" type="text" data-id="enableTempStorageValidationStepNumber" value="<%= enableTempStorageValidationStepNumber%>" />
	
	<aui:input label="mobile-support" name="preferences--mobileSupport--" type="checkbox" checked="<%= mobileSupport %>"></aui:input>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>
</div>

<liferay-portlet:resourceURL portletName="${param.portletResource}" var="ajaxUrl">
</liferay-portlet:resourceURL>

<script src="/SPProcessEngine-portlet/js/registerConfig.js"></script>
<script>
var A;
var pns;
AUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated',function(A1) {
	A = A1;
	pns ="<portlet:namespace/>";
	var ajaxUrl = "<%= ajaxUrl %>";
	var modelData = "{'limit':'99999','modelName':'Programme','page':'0','formType':'Programme','filterdata':[]}";
	var obj = new registerConfig({pns:pns, ajaxUrl:ajaxUrl,modelData:modelData});
});
</script>
