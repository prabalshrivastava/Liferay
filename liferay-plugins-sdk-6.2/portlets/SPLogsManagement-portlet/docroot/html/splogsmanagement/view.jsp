<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.portlet.WindowState"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="javax.portlet.PortletPreferences"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>

<portlet:defineObjects />
<%
	String cronExpression = GetterUtil.getString(portletPreferences
			.getValue("cronExpression", ""));
%>

<liferay-ui:error key="unauthorized.s3.accesKey"
	message="Please enter a valid Access Key ID." />
<liferay-ui:error key="unauthorized.s3.secretKey"
	message="Please enter a valid Secret Access Key." />
<liferay-ui:error key="unauthorized.s3.bucketName"
	message="Please enter a valid Bucket name." />

<aui:input type="text" name="status" value="${status}" label="Next Schedule" size="100" disabled="true"/>



<portlet:actionURL var="scheduleLogsActionURL" name="scheduleLogs">
</portlet:actionURL>
<portlet:actionURL var="unScheduleLogsActionURL" name="unScheduleLogs">
</portlet:actionURL>
<%-- <portlet:renderURL portletMode="view" var="viewURL" /> --%>

	<aui:button-row>
		<aui:button type="button" value="Schedule" name="scheduleLogs"
			id="scheduleLogs" disabled="${buttonState1}" onClick="<%=scheduleLogsActionURL%>" />
		<aui:button type="button" value="Unschedule" name="unScheduleLogs"
			id="unScheduleLogs" disabled="${buttonState2}"
			onClick="<%=unScheduleLogsActionURL%>" />
	</aui:button-row>

