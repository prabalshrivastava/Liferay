<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@ include file="/html/init.jsp"%>



<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>

<portlet:renderURL var="homePage">
	<portlet:param name="jspPage" value="/html/seatingplan/view.jsp" />
</portlet:renderURL>

<portlet:renderURL var="customiseLayoutUrl">
	<portlet:param name="jspPage"
		value="/html/seatingplan/customiseSeatLayout.jsp" />
</portlet:renderURL>

<div class="newPortlets">
	<%
		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest)); 
		String selectedSchedule=httpReq.getParameter("schedule");
		
		if (PermissionUtil.canAddModel((PortletRequest) request.getAttribute("javax.portlet.request"))) {
	%>
	<%
		String dashBoardLink = SambaashUtil.getDashBoard();
	%>
	<div style="display: none;" class="alert" role="showAlert"
		id="alert_msg"></div>
	<div class="subHeader">
		<div class="container">
			<aui:row>
				<aui:col span="10" cssClass="text-center">
					<h2>NOTIFY CERTIFICATE COLLECTION</h2>
				</aui:col>
				<aui:col span="2" cssClass="text-right">
					<aui:a href="/workspace" title="Back to Dashboard">Back to Home</aui:a>
				</aui:col>
			</aui:row>
		</div>
	</div>

	<div class="formContainer container formio-form">
		<aui:row>
			<aui:col span="12" cssClass="choices formio-choices">
				<div class="form-group">
					<label cssClass="control-label">Schedule</label>
					<aui:select name="" id="sessionSchedule" cssClass="form-control"
						placeholder="Choose a Session Schedule"
						onChange="fetchEntityLink(this.value);">
						<aui:option value="" hidden="true">
						</aui:option>

					</aui:select>
				</div>
			</aui:col>
		</aui:row>

		<br>

		<div class="Table-Layout" id="entityLinkContainer">
			<div class="Heading">
				<div class="Cell Span-width-10">
					<p><%=LabelUtil.getLabel(pageContext, themeDisplay, "certificate.candidatename")%></p>
				</div>
				<div class="Cell" id="stageClmn">
					<p><%=LabelUtil.getLabel(pageContext, themeDisplay, "certificate.idno")%></p>
				</div>
				<div class="Cell Span-width-10">
					<p><%=LabelUtil.getLabel(pageContext, themeDisplay, "certificate.srnnumber")%></p>
				</div>
				<div class="Cell Span-width-15" id="applicantClmn">
					<p><%=LabelUtil.getLabel(pageContext, themeDisplay, "certificate.Programmetitle")%></p>
				</div>
				<div class="Cell">
					<p><%=LabelUtil.getLabel(pageContext, themeDisplay, "certificate.classificationaward")%></p>
				</div>
				<div class="Cell" id="supervisorClmn">
					<p><%=LabelUtil.getLabel(pageContext, themeDisplay, "certificate.notificationstatus")%></p>
				</div>
				<div class="Cell" id="supervisorClmn">
					<p><%=LabelUtil.getLabel(pageContext, themeDisplay, "certificate.notifiedon")%></p>
				</div>
				<div class="Cell" id="supervisorClmn">
					<p>
						<input type="checkbox" id="selectAll"
							onChange="selectAllOptions();" />
					</p>
				</div>
			</div>
		</div>



		<div class="Row hide addInfo" id="sampleEntityLinkRow">
			<input id="processStateId" type="hidden" value="" /> <input
				id="processId" type="hidden" value="" />

			<div class="Cell">
				<p id="candidateName"></p>
			</div>
			<div class="Cell">
				<p id="idNumber"></p>
			</div>
			<div class="Cell">
				<p id="srnNumber"></p>
			</div>
			<div class="Cell">
				<p id="programeTitle"></p>
			</div>
			<div class="Cell">
				<p id=classificationAward></p>
			</div>
			<div class="Cell">
				<p id=notificationStatus></p>
			</div>
			<div class="Cell">
				<p id=notifiedOn></p>
			</div>
			<div class="Cell">
				<p id=selection></p>
			</div>

		</div>
		<div class="pagination" style="margin-top: 20px">
			<aui:row>
				<aui:col span="6" cssClass="text-left">
					<aui:select cssClass="itemsPerPage" name="itemsPerPage"
						onchange="reloadTable()" label="Items per page:">
						<aui:option value="5">5</aui:option>
						<aui:option value="10" selected="true">10</aui:option>
						<aui:option value="20">20</aui:option>
						<aui:option value="50">50</aui:option>
						<aui:option value="100">100</aui:option>
					</aui:select>

				</aui:col>
				<aui:col span="6" cssClass="text-right myPagination aui-pagination">
					<div id="jslarge" class="pagination myPagination pagination-large"></div>
				</aui:col>
			</aui:row>
		</div>
		<br> <br>
		<div class="enrollmentTitle">
			<aui:row>
				<aui:col cssClass="enrolledCandidates" span="4">
				</aui:col>
				<aui:col cssClass="enrolledCandidates" span="2">
					<span>Total No. Listed:</span>
					<span id="totalRec" class="candidateCount">0</span>
				</aui:col>
				<aui:col cssClass="pendingCandidatesAssignment" span="2">
					<span>Selected:</span>
					<span class="candidateCount" id="selectedCount">0</span>
				</aui:col>
			</aui:row>
		</div>
		<br> <br>
		<aui:row>
			<aui:col span="2" cssClass="choices formio-choices">
			</aui:col>
			<label cssClass="control-label">Collection Date</label>
			<aui:col span="4" cssClass="choices formio-choices">

				<div class="form-group">

					<input type="date" id="startDate" onChange="callDisable();"/ >
					<input type="hidden" id="startDateError"
						value="From date must be greater then today's date" />
					<p id="startDateErr" style="color: red"></p>


				</div>
				<div></div>
			</aui:col>
			<aui:col span="4" cssClass="choices formio-choices">

				<div class="form-group">

					<input type="date" id="endDate" onChange="callDisableOne();"/ >

					<input type="hidden" id="endDateError"
						value="To date must be greater then today's date and from date" />
					<p id="endDateErr" style="color: red"></p>

				</div>
				<div></div>

			</aui:col>
		</aui:row>

		<aui:row>
			<aui:col span="2" cssClass="choices formio-choices">
			</aui:col>

			<aui:col span="4" cssClass="choices formio-choices">

				<div class="form-group">

					<button type="button" class="btn btn-default" id="sendNotification"
						style="background: #0f349f !important; width: 278px !important; color: #eff4fb !important"
						onClick="sendNotification()">Send Collection Notification</button>

				</div>
			</aui:col>
			<aui:col span="4" cssClass="choices formio-choices">

				<div class="form-group">
					<button type="button" onClick="onCancel()" class="btn btn-default">Cancel</button>


				</div>
			</aui:col>
		</aui:row>
	</div>
</div>

<%
	}
%>

<script type="text/javascript">
/* $(document).ready(function () {
	 $("#startDate").on('change', function(event) {
		   event.preventDefault();
		   document.getElementById("endDate").disabled = false;
		  /* Act on the event 
		  });
	}); */
debugger;
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var mode = "view";
var homeUrl = "<%=homePage%>";
var currentDate = new Date();
var month = currentDate.getMonth() +1;
if(month.toString().length === 1){
	var month = "0"+month;
}
var day = currentDate.getDate();
var year = currentDate.getFullYear();
var selectedSchedule="<%=selectedSchedule%>";
var today=year + '-' + month + '-' + day;
	$('#startDate').attr('min', today);
	var pageRequested = 1, totalRecords = 0, totalPages = 0;
	document.getElementById("startDate").disabled = true;
	document.getElementById("endDate").disabled = true;
	document.getElementById("sendNotification").disabled = true;
	function fetchEntityLink(schedule) {
		document.getElementById("startDate").disabled = true;
		document.getElementById("endDate").disabled = true;
		document.getElementById("sendNotification").disabled = true;
		clearDate();
		var selectedData = [];
		document.getElementById("selectedCount").innerHTML = 0;
		removeAllChild();
		selectedSchedule = schedule;
		init2();
	}
	function callDisable() {
		debugger;
		$('#endDate').attr('min', document.getElementById("startDate").value);
		document.getElementById("endDate").disabled = false;
	}
	function callDisableOne() {
		debugger;
			document.getElementById("sendNotification").disabled = false;
	}
</script>


<style>
input[type=checkbox] {
	display: block !important;;
	float: left !important;;
	/* 	opacity: 1 !important; */
}
</style>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/schedule.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/candidateCetificate.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>