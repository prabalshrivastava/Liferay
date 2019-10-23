<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@ include file="/html/init.jsp"%>

<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>

<portlet:renderURL var="seatingPlanLink">
		<portlet:param name="jspPage" value="/html/seatingplan/createSettingPlan.jsp" />
</portlet:renderURL>

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
	<style>
.aui body.yui3-skin-sam .yui3-widget-mask{
	z-index: 99999 !important;
    background-image: linear-gradient(to bottom,#e5e8eb,#d6dbe3);
}
.aui .modalpopupBox.modal {
    margin: auto;
    background-color: transparent!important;
    z-index: 99999!important;
}
.aui .modalpopupBox.modal .modal-content {
    position: relative;
    background-color: #fff!important;
    min-height: 350px;
    min-width: 560px;
    margin: auto;
    }
</style>
	<div class="subHeader">
		<div class="container">
			<aui:row>
				<aui:col span="10" cssClass="text-center">
					<h2>SEATING PLAN SETUP</h2>
				</aui:col>
				<aui:col span="2" cssClass="text-right">
					<aui:a href="<%=homePage%>" title="Back to Dashboard">Back to Home</aui:a>
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
		<div class="enrollmentTitle">
			<aui:row>
				<aui:col cssClass="enrolledCandidates" span="6">
					<span>Total No. of Candidates Enrolled:</span>
					<span class="candidateEnrolledCount" style="color: #3fc6a8">0</span>
				</aui:col>
				<aui:col cssClass="pendingCandidatesAssignment" span="6">
					<span>Total No. of Pending Candidate Assignment:</span>
					<span class="candidateAssignmentCount" style="color: #3fc6a8">0</span>
				</aui:col>
			</aui:row>
		</div>
		<br>
		<br>
		<div class="Table-Layout" id="entityLinkContainer">
			<div class="Heading">
				<div class="Cell">
					<p><%= LabelUtil.getLabel(pageContext, themeDisplay, "exam.facility")%></p>
				</div>
				<div class="Cell" id="stageClmn">
					<p><%= LabelUtil.getLabel(pageContext, themeDisplay, "exam.subfacility")%></p>
				</div>
				<div class="Cell">
					<p><%= LabelUtil.getLabel(pageContext, themeDisplay, "exam.seats.available")%></p>
				</div>
				<div class="Cell" id="applicantClmn">
					<p><%= LabelUtil.getLabel(pageContext, themeDisplay, "number.candidate.assigned")%></p>
				</div>
				<div class="Cell">
					<p><%= LabelUtil.getLabel(pageContext, themeDisplay, "exam.seat.plan")%></p>
				</div>
				<div class="Cell" id="supervisorClmn">
					<p><%= LabelUtil.getLabel(pageContext, themeDisplay, "exam.assign.candidate")%></p>
				</div>
			</div>
		</div>


		<div class="Row hide addInfo" id="sampleEntityLinkRow">
			<input id="processStateId" type="hidden" value="" /> <input
				id="processId" type="hidden" value="" />

			<div class="Cell">
				<p id="facility"></p>
			</div>
			<div class="Cell">
				<p id="subFacility"></p>
			</div>
			<div class="Cell">
				<p id="seatsAvailable"></p>
			</div>
			<div class="Cell">
				<p id="noOfCandidateAssigned"></p>
			</div>
			<div class="Cell" style="width: 26% !important;" ><p id="sts"></p>
				<aui:row>
					<a id="seatPlan_CREATE" href="">
								<aui:col span="12" cssClass="buttonCreate">
									<button type="button" class="btn-state btn-create" id="seatPlanCreate">Create New</button>
								</aui:col>
							</a>
							<a id="seatPlan_DRAFT" href="">
								<aui:col span="6" cssClass="buttonDraft">
									<button type="button" class="btn-state btn-update" id="seatPlanEdit" style="width: 100% !important;">Edit Draft</button>
								</aui:col>
							</a>
							<a id="seatPlan_UPDATE" href="">
								<aui:col span="6" cssClass="buttonUpdate">
									<button type="button" class="btn-state btn-update" id="seatPlanUpdate" style="width: 100% !important;">Update</button>
								</aui:col>
							</a>
							<!-- <a id="seatPlan_DELETE" href=""> -->
								<aui:col span="6" cssClass="buttonDelete">
									<button type="button" class="btn-state btn-delete"  id="seatPlanDelete" style="width: 100% !important;">Delete</button>
								</aui:col>
							<!-- </a> -->

				</aui:row>

			</div>
			<div class="Cell" style="width: 26% !important;">
				<aui:row>
					<a id="assignCandidate_CREATE" href="">
						<aui:col span="12" cssClass="buttonCreate">
							<button type="button" class="btn-state btn-create" id="assignCandidateCreate">Assign New</button>
						</aui:col>
					</a>
					<a id="assignCandidate_DRAFT" href="">
						<aui:col span="6" cssClass="buttonDraft">
							<button type="button" class="btn-state btn-update" id="assignCandidateEdit" style="width: 100% !important;">Edit Draft</button>
						</aui:col>
					</a>
					<a id="assignCandidate_UPDATE" href="">
						<aui:col span="6" cssClass="buttonUpdate">
							<button type="button" class="btn-state btn-update" id="assignCandidateUpdate" style="width: 100% !important;">Update</button>
						</aui:col>
					</a>
					<!-- <a id="assignCandidate_DELETE" href=""> -->
						<aui:col span="6" cssClass="buttonDelete">
							<button type="button" class="btn-state btn-delete" onclick="" id="assignCandidateDelete" style="width: 100% !important;">Delete</button>
						</aui:col>
					<!-- </a> -->
				</aui:row>
			</div>
		</div>
	</div>
	
	<div id="sucess-popup" hidden="true" class="modalpopupBox">
		<div id="sucess-popup-box" class="modalpopupContent">
			<form class="formContainer" action="">
				<aui:row>
					<aui:col span="12">
						
						 <span style="display:none; !important;" id="success-msg">Finance Parameter Created</span>
						<div id="inactive1-success-box">
						    <h2 style="font-weight: 700;">You will lose all the data entered in Seating Plan</h2>
						    <h4 style="font-weight: 200;">Are you sure you want to delete this plan?</h4>
						</div>
					</aui:col>

				</aui:row>
				<aui:row>
					<aui:col span="12">
						<button type="button"
							class="btn btn-default popup-confirm-archive pull-left">Confirm</button>
						<button type="button" 
							class="btn cancel btn-primary popup-cancel pull-right">Cancel</button>
					</aui:col>
				</aui:row>

			</form>
		</div>
	</div>
	
	
	<div class="loadingDiv" id="loadingDiv">
		<div class="m-blockui"
			style="position: fixed; z-index: 1031; left: 50%; top: 50%;">
			<span>Please Wait</span> <span>
				<div class="m-loader m-loader--brand"></div>
			</span>
		</div>
	</div>
</div>
	

<%
	}
	
%>

<script type="text/javascript">
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var mode = "view";
var homeUrl = "<%=homePage%>";
var selectedSchedule="<%=selectedSchedule%>";
var examSeatingUrl = "<%=seatingPlanLink%>";

function fetchEntityLink(schedule){
	selectedSchedule = schedule;
	location.href = examSeatingUrl + "&schedule=" + schedule;
}
</script>

<script type="text/javascript">
function customiseSeatlayout1(){
	AUI().ready('liferay-portlet-url', function(A){
	var renderURL = Liferay.PortletURL.createRenderURL();
	renderURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
	renderURL.setParameter("jspPage","/html/seatingplan/customiseSeatLayout.jsp");
	renderURL.setParameter("dataN", "test");
	window.location.href = renderURL;
    });
}
</script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/exam.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/examSchedule.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>