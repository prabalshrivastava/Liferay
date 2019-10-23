<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.sambaash.platform.srv.processbuilder.model.PEProcessStage"%>
<%@page import="com.sambaash.platform.srv.processbuilder.service.PEProcessStageLocalServiceUtil"%>
<%@ page import="com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil" %>
<%@ page import="com.sambaash.platform.srv.processbuilder.service.PEProcessLocalService" %>
<%@ page import="com.sambaash.platform.srv.processbuilder.model.PEProcess" %>
<%@ page import="com.liferay.portal.service.ClassNameLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.ClassName" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ include file="/html/init.jsp" %>

<%

List<PEProcessStage> stages = PEProcessStageLocalServiceUtil.getPEProcessStages(-1, -1);

String stageIds = GetterUtil.getString(portletPreferences.getValue(PEConstants.PREF_STAGE_IDS, SambaashUtil.getParameter(PEConstants.SP_PARAM_STAGES, 0)));
String[] stageIdsArr = stageIds.split(",");

%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<div id="formContainer">

<aui:form action="<%=configurationURL%>" method="post" name="fm">
	<aui:input name="<%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" />

	<!-- Preference control goes here -->

	 <%
	 	String OPTION = "<option value='%s' %s>%s</option>";
	 %>

	
	<aui:select name="preferences--stageIds--" label="stages" required="true" multiple="true">

		  <%
		  	
		  		      //out.println(String.format(OPTION, StringPool.BLANK, StringPool.BLANK, StringPool.BLANK));
		  		  	  for (PEProcessStage stage :stages) {
		  		  		 String selected = "";
		  	     		 if (Arrays.asList(stageIdsArr).contains(String.valueOf(stage.getSpPEProcessStageId()))) {
		  	     			 selected = "selected";
		  	     		 }
		  		  		out.println(String.format(OPTION, stage.getSpPEProcessStageId(),selected,stage.getName()));
		  		  	  }
		  %>

	</aui:select>
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>
</div>