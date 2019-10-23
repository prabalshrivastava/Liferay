<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@ include file="/html/init.jsp" %>

<%-- <portlet:actionURL var="seatingPlanLink">
		<portlet:param name="action" value="<%=ExamConstant.SCHEDULE_FACILITY_LINK%>"/>
</portlet:actionURL> --%>

<portlet:renderURL var="seatingPlanLink">
		<portlet:param name="jspPage" value="/html/seatingplan/createSettingPlan.jsp" />
</portlet:renderURL>

<portlet:renderURL var="homePage">
  <portlet:param name="jspPage" value="/html/seatingplan/view.jsp" />
</portlet:renderURL>

<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>

<div class="newPortlets">
	<%
		if (PermissionUtil.canAddModel((PortletRequest) request.getAttribute("javax.portlet.request"))) {
	%>
	<%
		String dashBoardLink = SambaashUtil.getDashBoard();
	%>
	<%@ include file="/html/common/header.jsp" %>

	<div class="formContainer container formio-form">
		<aui:row>
			<aui:col cssClass="text-center">
				<div class="seatingPlan">
					<img src="<%=request.getContextPath()%>/images/hall-2-x.png">
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
						placeholder="Choose a Session Schedule" onChange="createSeating(this.value);">
						<aui:option value="" hidden="true">
							Choose a Session Schedule...
						</aui:option>
					</aui:select>
				</div>
			</aui:col>
		</aui:row>
		
</div>
<%
	}
%>

<script type="text/javascript">
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var mode = "view";
var homeUrl = "<%=homePage%>";
</script>


<script type="text/javascript">
var examSeatingUrl = "<%=seatingPlanLink%>";
	function createSeating(schedule) {
		location.href = examSeatingUrl + "&schedule=" + schedule;
	}
</script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/exam.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>