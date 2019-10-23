<%@page import="com.sambaash.platform.srv.spservices.model.SPListType"%>
<%@page import="java.util.List"%>
<%@page
	import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil"%>
<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib
	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/main.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/portlet.css?minifierType=css'></link>
<link rel='stylesheet'
	href='/html/css/sp/formio.full.min.css?minifierType=css'>
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>
<%@ taglib uri="/tld/sp-formio" prefix="sp-formio"%>
<portlet:defineObjects />

<portlet:renderURL var="seatingPlanLink">
	<portlet:param name="jspPage"
		value="/html/seatingplan/createSettingPlan.jsp" />
</portlet:renderURL>

<div class="newPortlets">
	<%
		if (PermissionUtil.canAddModel((PortletRequest) request.getAttribute("javax.portlet.request"))) {
	%>
	<%
		String dashBoardLink = SambaashUtil.getDashBoard();
	%>
	<div class="subHeader">
		<div class="container">
			<aui:row>
				<aui:col span="10" cssClass="text-center">
					<h2>SEATING PLAN SETUP</h2>
				</aui:col>
				<aui:col span="2" cssClass="text-right">
					<aui:a href="<%=dashBoardLink%>" title="Back to Dashboard">Back to Dashboard</aui:a>
				</aui:col>
			</aui:row>
		</div>
	</div>

	<div class="formContainer container formio-form">
		<aui:row>
			<aui:col cssClass="text-center">
				<div class="seatingPlan">
					<img src="<%=request.getContextPath()%>/images/seatingPlan.jpg">
				</div>
				<span class="seating-plan-setup-text">Setup a Seating Plan!</span><br>
				<span class="seating-plan-setup-started-text">Get Started by
						choosing a Session Schedule below.</span>
			</aui:col>
		</aui:row><br><br>
		
		<aui:row>
			<aui:col span="12" cssClass="choices formio-choices">
				<div class="form-group">
					<label cssClass="control-label">Session Schedule</label>
					<aui:select name="" id="sessionSchedule" cssClass="form-control"
						onChange="createSeating(this.value);">
						<aui:option value="">Choose a Session Schedule...</aui:option>
						<%
							List<SPListType> catList = SPListTypeLocalServiceUtil
													.getByKey("finance.accountingtable.productype", 21424);
											for (SPListType type : catList) {
						%>
						<aui:option value="<%=type.getItemValue()%>"><%=type.getDisplayName()%></aui:option>
						<%
							}
						%>
					</aui:select>
				</div>
			</aui:col>
		</aui:row>
	</div>
</div>
<%
	}
%>

<script type="text/javascript">
var examSeatingUrl = "<%=seatingPlanLink%>";
	function createSeating(value) {
		location.href = examSeatingUrl;
	}
</script>