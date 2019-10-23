<%@ include file="/html/init.jsp"%>

<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>

<portlet:renderURL var="homePage">
	<portlet:param name="jspPage" value="/html/seatingplan/view.jsp" />
</portlet:renderURL>

<portlet:renderURL var="seatingAssignment">
	<portlet:param name="jspPage" value="/html/seatingplan/seatingAssignment.jsp" />
</portlet:renderURL>

<div class="newPortlets">
	<%
		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		String seatingPlanInstanceId = httpReq.getParameter("SeatingPlanInstanceId");
String scheduleCode = request.getParameter("scheduleCode");
String facilityCode = request.getParameter("facilityCode");
String subFacilityCode = request.getParameter("subFacilityCode");
String scheduleId = request.getParameter("scheduleId");
String facilityId = request.getParameter("facilityId");
String subFacilityId = request.getParameter("subFacilityId");
		if (PermissionUtil.canAddModel((PortletRequest) request.getAttribute("javax.portlet.request"))) {
	%>
	<%
		String dashBoardLink = SambaashUtil.getDashBoard();
	%>
	<%@ include file="/html/common/headerSeatingAssignment.jsp"%>
	<link rel='stylesheet' type="text/css"
		href='<%=request.getContextPath()%>/css/jquery-ui.css?minifierType=css'></link>
	<link rel='stylesheet' type="text/css"
		href='<%=request.getContextPath()%>/css/customiseSeats.css?minifierType=css'></link>

<style>
select {
	-webkit-appearance: none !important;
}
.assign-marker-label {
	background-color: #eee;
	border-radius: 50px;
}
.assign-marker-round {
	width: 20px;
	height: 20px;
	background-color: #gray;
	display: inline-block;
	border-radius: 50%;
	left: 5px;
	top: 5px;
	position: relative;
	margin-right: 10px;
}
.assign-marker-row {
	margin-top: 10px;
}
.panel-title-div {
	background-image: linear-gradient(#fff, #eee);
}
.panel-title-no {
	display: inline-block;
	font-size: 20px;
	height: 40px;
	width: 40px;
	background-color: #3856a8;
	padding: 10px 13px;
	color: white;
	border-radius: 10px 0px 0px 0px;
    left: -5px;
    position: relative;
}
.panel-title-text {
	display: inline-block;
	margin: 10px;
	font-size: 18px;
}
.font-color-blue {
	color: #0f349f !important;
	font-weight: 600 !important;
}
.aui hr {
	margin-bottom: 10px;
	margin-top: 0px;
}
.aui .newPortlets .formio-form {
	padding-top: 30px;
}
.aui table {
	margin-bottom: 20px;
}
.assignmarker-bottom {
	display: inline-block;
	float: left;
	margin: 10px;
	max-width: 450px;
}
.assignmarker-label-bottom {
	display: inline-block;
	margin-left: 10px;
}
.seat-error-span{
    float: left;
    top: -20px;
    position: relative;
    color: #f0465b;
    line-height: 1em;
}
.input-border-error{
	border: 2px solid #f0465b !important;
}
.btn-primary{
    padding-left: 20px !important;
    padding-right: 20px !important;
    padding-top: 10px !important;
    padding-bottom: 10px !important;
}
.custom-panel-col{
    min-height: 384px !important;
    border: 5px solid #f7f9fc;
    border-radius: 15px;
    background: white;
    padding: 12px 24px 12px 6px;
}
.pnl-btn{
margin: 0px !important;
}
.popover{
	width: 240px;
	line-height: 15px;
}
.aui table td:last-child {
    padding: 8px 0px 8px 15px;
}
.Invigilators {
  width: 35px;
  height: 35px;
  object-fit: contain;
}
.label-image {
  width: 18px;
  height: 18px;
  object-fit: contain;
}
.customScrollBar::-webkit-scrollbar-track {
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
    border-radius: 5px;
    box-shadow: 0 0 8px 0 #c8d2e7;
    background-color: #ccd5e9;
}
.customScrollBar::-webkit-scrollbar-thumb {
    border-radius: 5px;
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
    border-radius: 5px;
    box-shadow: 0 0 8px 0 #c8d2e7;
    background-color: #fcfdff;
}
.customScrollBar::-webkit-scrollbar {
    width: 7px;
    background-color: #f5f5f5;
}
</style>
	<div id="seatingAssignment" class="seatingAssignment">
		<div id="load-assign-marker-style-tag"></div>
	<div align="center" style="margin: 2% 0%;">
		<div style="display: inline-block;">
			<button id="autoButton" onclick="actionDialogue('auto')" class="btn btn-default pnl-btn">Auto</button>
			<button id="manualButton" onclick="swithcPanel('manual')" class="btn btn-default pnl-btn">Manual</button>
		</div>
	</div>
		<div style="margin: 2% 5%;">
			<aui:row>
				<aui:col span="4" cssClass="custom-panel-col manualPanel" onmouseenter="disabledManualPanel()">
					<aui:row>
						<aui:col span="12">
							<div class="form-group">
								<label class="control-label font-color-blue"><img src="<%=request.getContextPath()%>/images/candidates.png" srcset="<%=request.getContextPath()%>/images/candidates@2x.png 2x, <%=request.getContextPath()%>/images/candidates@3x.png 3x" class="label-image">&nbsp;&nbsp;CANDIDATE</label>
								<hr />
							</div>
						</aui:col>
						<aui:col span="12">
							<div class="form-group">
								<label class="control-label">Candidate Name</label>

								<select name="" id="candidateName"
									class="form-control candidateName"
									placeholder="Choose a candidate" >
									<option value="" >
										Choose a candidate...
									</option>
								</select>
							</div>
						</aui:col>
						<aui:col span="4">
							<div class="form-group">
								<label class="control-label">Desk No</label> <input
									type="text" name="candidateDeskNo" id="candidateDeskNo"
									class="candidateDeskNo" onchange="$('#invalidSeatError').css('display','none');" />
									<div id="invalidSeatError" class="help-block error" style="display: none;">Invalid Seat</div>
							</div>
						</aui:col>
						<aui:col span="2" style="padding-top:25px;">
							<label style="float: right;">
								<input name="removeCandidateCheck"
									onclick="clickedRemoveCandidate(this)" id="removeCandidateCheck" class="removeCandidateCheck" type="checkbox" />
							</label>
						</aui:col>
						<aui:col span="5">
							<label class="control-label" style="padding-top: 15px; font-size: 12px; font-weight: 600;">Remove candidate from this
									seating plan</label>
						</aui:col>
						<aui:col>
							<button id="saveCandidateButton" type="button" style="margin-left:0px !important; padding-left: 20px !important; padding-right: 20px !important; padding-top: 10px !important; padding-bottom: 10px !important;" class="btn btn-primary" onclick="saveAssignCandidateSeat()">SAVE</button>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="12">
							<div class="form-group">
							<br>
								<label class="control-label font-color-blue"><img src="<%=request.getContextPath()%>/images/invigilators.png" srcset="<%=request.getContextPath()%>/images/invigilators@2x.png 2x,<%=request.getContextPath()%>/images/invigilators@3x.png 3x" class="label-image">&nbsp;&nbsp;INVIGILATOR</label>
								<hr />
							</div>
						</aui:col>
						<aui:col span="12">
							<div class="form-group">
								<label class="control-label">Invigilator Name</label>

								<select name="" id="invigilatorName"
									class="form-control invigilatorName" onchange="showInvDetails();">
									<option value="" >
										Choose an invigilator...
									</option>
								</select>
							</div>
						</aui:col>
						<aui:col span="12">
							<div class="form-group">
								<label class="control-label">Assignment Type</label> <input
									type="radio" checked="checked" onclick="switchAssignmentType('assignmentTypeRow')" name="assignmentType" id="assignmentTypeRow"
									class="assignmentType" value="byrow" /> By Row <input
									type="radio" onclick="switchAssignmentType('assignmentTypeSeat')" name="assignmentType" id="assignmentTypeSeat"
									class="assignmentType" value="customrange" /> Custom Range
							</div>
						</aui:col>
						<aui:col span="12" cssClass="assignmentTypeRowDiv">
							<div class="form-group">
								<label class="control-label">Row Number(s)</label> <input
									type="text" name="rowNumbers" id="rowNumbers"
									class="rowNumbers" placeholder="e.g 1,2" />
							</div>
						</aui:col>
						<aui:col span="12" cssClass="assignmentTypeSeatDiv" style="display:none;">
							<div class="form-group">
								<label class="control-label">Manages Desk(s)</label> <input
									type="text" name="managesDesk" id="managesDesk"
									class="managesDesk" placeholder="e.g 1-6,11-13" />
							</div>
						</aui:col>
						
						<aui:col span="1">
							<label>
								<input name="removeInvigilatorCheck"
									onclick="clickedRemoveInvigilator(this)" id="removeInvigilatorCheck" class="removeInvigilatorCheck" type="checkbox" />
							</label>
						</aui:col>
						<aui:col span="10">
							<label class="control-label" style="font-size: 12px; font-weight: 600;">Remove invigilator from
									this seating plan</label>
						</aui:col>
						<aui:col>
							<button type="button" style="margin-left:0px !important; padding-left: 20px !important; padding-right: 20px !important; padding-top: 10px !important; padding-bottom: 10px !important;" class="btn btn-primary" onclick="saveAssignInvigilatorSeat()">SAVE</button>
						</aui:col>
					</aui:row>
				</aui:col>
				<aui:col span="8" cssClass="custom-panel-col autoPanel" style="padding: 0px;">

						<div class="panel-title-div" align="center" style="border-radius: 10px 0px 0px 0px;">
							<div id="panelTitleText" align="left" class="panel-title-text">CUSTOMISE SEATS</div>
							<div id="panelTitleTextRight" class="panel-title-text" style="float: right;"></div>
						</div>
						<div id="seatingSetup" class="seatingSetup"></div>
						
						<div align="center" style="margin: 2% 0%;" onmouseenter="disabledDetailButton()">
							<div style="display: inline-block;">
								<button id="candidateDetailsButton" onclick="allDetails('candidate')" class="btn btn-default"><img src="<%=request.getContextPath()%>/images/candidates.png" srcset="<%=request.getContextPath()%>/images/candidates@2x.png 2x, <%=request.getContextPath()%>/images/candidates@3x.png 3x" class="label-image"> &nbsp; CANDIDATE DETAILS</button>
								<button id="invisilatorDetailsButton" onclick="allDetails('invisilator')" class="btn btn-default"><img src="<%=request.getContextPath()%>/images/invigilators.png" srcset="<%=request.getContextPath()%>/images/invigilators@2x.png 2x,<%=request.getContextPath()%>/images/invigilators@3x.png 3x" class="label-image">&nbsp; INVIGILATOR DETAILS</button>
							</div>
						</div>

						<div style="font-size: 12px; display: flow-root; background-image: linear-gradient(#fff, #eee);">
							<div id="assignMarkerBottom" class="assignmarker-bottom" ></div>
							<div style="float: right; margin: 10px;">
								Total Capacity : <span id="totalCapicitySeats"
									style="color: #3fc6a8">100</span>&nbsp;&nbsp; Available : <span
									id="totalAvailableSeats" style="color: #3fc6a8">57</span>
							</div>
						</div>
						
				</aui:col>
			</aui:row>
		</div>

		<aui:row cssClass="userAction" style="margin-bottom: 20px;" >
			<aui:col span="12">
				<button type="button" class="btn btn-default" id="draft"
					onClick="saveSeatingAssignment('draft')">Save Draft</button>
			
				<button type="button" style="padding-left: 20px !important; padding-right: 20px !important; padding-top: 10px !important; padding-bottom: 10px !important;" class="btn btn-primary" id="publish"
					onClick="saveSeatingAssignment('submit')">CONFIRM ASSIGNMENT</button>
			
				<button type="button" onclick="actionDialogue('reset');"
					class="btn btn-default">Reset</button>
			
				<button type="button" onclick="actionDialogue('cancel');" class="btn btn-default">Cancel</button>
			</aui:col>
		</aui:row>
		
	</div>
	
	
<div class="yui3-skin-sam reset-action-dialog" >
	<div id="assign-seat-details-dialog" hidden="true" class="modalpopupBox" style="left:inherit; right: 0px; top:45px !important; max-height: 100vh;height: 100vh;">
		<div id="assign-seat-details-dialog-box" class="modalpopupContent" style="min-width: 500px;max-height: 100vh;height: 100vh;">
			<h4 id="detailsFor" style="display: inline-block; position: relative; top: -35px;"> &nbsp;&nbsp;<i class="fa fa-user"></i>&nbsp;Candidates</h4>
			<div class="customScrollBar" style="overflow:auto; max-height: 80vh; margin-top: -20px;">
				<table id="detailsDataTable" style="margin:auto;width: 100%;">
				</table>
			</div>
		</div>
	</div>
</div>


<div class="yui3-skin-sam reset-action-dialog">
	<div id="action-dialog" hidden="true" class="modalpopupBox">
		<div id="action-dialog-box" class="modalpopupContent">
			<form class="formContainer" action="">
				<aui:row>
					<aui:col span="12">
						<div id="inactive1-success-box">
						    <h2 id="action_title" style="font-weight: 700;">Reset for Approval?</h2>
						    <h4 id="action_msg" style="font-weight: 200;">Are you sure you want to discard all
							changes that were made?</h4>
						</div>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12">
						<button type="button"
							class="btn-primary popup-submit-action pull-left">Yes</button>
						<button type="button"
							class="btn cancel lightbluebtn popup-cancel-action pull-right">No</button>
					</aui:col>
				</aui:row>
			</form>
		</div>
	</div>
</div>

<div class="yui3-skin-sam success-action-dialog">
	<div id="sucess-popup" hidden="true" class="modalpopupBox">
		<div id="sucess-popup-box" class="modalpopupContent">
			<form class="formContainer" action="">
				<aui:row>
					<aui:col span="12">
						<h3 id="success-msg" style="line-height: 25px; padding-top: 12px">Seating assignment done successfully!</h3>
						<br />
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="2">
					</aui:col>
					<aui:col span="9">
						<a id="backToMainScreen"><button  type="button" style="background-color: #eff4fb !important; color: #0f349f !important; font-weight: 700 !important;width: 210px;"
							class="btn-primary pull-left popup-submit-action" >BACK TO MAIN SETUP</button></a>
					</aui:col>
				</aui:row>
			</form>
		</div>
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
var seatingAssignmentURL = "<%=seatingAssignment%>";
var spliId = "<%=seatingPlanInstanceId%>";
var scheduleCodeReq = "<%=scheduleCode%>";
var facilityCodeReq ="<%=facilityCode%>";
var subFacilityCodeReq = "<%=subFacilityCode%>";
var scheduleIdReq = "<%=scheduleId%>";
var facilityIdReq ="<%=facilityId%>";
var subFacilityIdReq = "<%=subFacilityId%>";
var doPopOverCheck = false;
var seatingLayoutParameterPost = {};
var invisilatorUsed = {};
var statusOfAssignment = "";
</script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-ui.min.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/customiseSeats.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>

<script type="text/javascript">
showLoading(true);
loadAssignMarkers();
function setDash(v){
	return v==undefined || v == "" ? "-" : v ;
}
getEID("seatingAssignment").style="display:none;";

if (spliId == "null") {
    var data = {};
    data.formType = "seatingplaninstance";
    data.conditions = ["facilityId=" + facilityIdReq, "subFacilityId=" + subFacilityIdReq, "scheduleId=" + scheduleIdReq, "size=" + 2147483647];
    ajaxCallAPI(
        'GET',
        "searchList",
        data,
        function() {
            var data = this.get("responseData");
            if (data && data.hasOwnProperty("content") && data.content.length > 0) {
                spliId = data.content[data.content.length-1].storageId;
                fetchSeatingPlanInstance();
            }
        },
        function() {
            displayMessage('danger',
                "Error in persisting dynamic form data.");
        });
} else {
    fetchSeatingPlanInstance();
}
//Assign seat start
//UI Function STart
function clickedRemoveCandidate(t) {
	$("#invalidSeatError").css("display","none");
 if ($("#removeCandidateCheck").is(":checked")) {
     $("#candidateDeskNo").val("");
     $("#candidateDeskNo").attr("disabled", "");
 } else {
     $("#candidateDeskNo").attr("disabled", null);
 }
}
function clickedRemoveInvigilator(t) {
 if ($("#removeInvigilatorCheck").is(":checked")) {
     $("#managesDesk").val("");
     $("#managesDesk").attr("disabled", "");
     $("#rowNumbers").val("");
     $("#rowNumbers").attr("disabled", "");
     $("#assignmentTypeRow").attr("disabled", "");
     $("#assignmentTypeSeat").attr("disabled", "");
 } else {
     $("#assignmentTypeRow").attr("disabled", null);
     $("#assignmentTypeSeat").attr("disabled", null);
     $("#rowNumbers").attr("disabled", null);
     $("#managesDesk").attr("disabled", null);
 }
}
function removeAllAsignment() {
 $("span[assignmarker='green']").removeAttr("candid");
 $("span[assignmarker='green']").removeAttr("invsid");
 $("span[assignmarker='#8bdb7c']").removeAttr("candid");
 $("span[assignmarker='#8bdb7c']").removeAttr("invsid");
 assignCand = [];
 userSeatAssign = {
     "candidate": {},
     "invisilator": {}
 };
}
function swithcPanel(a) {
 if (a == 'auto') {
     $("#manualButton").attr("style", "color:#0f349f !important; background-color:#eff4fb !important");
     $("#autoButton").attr("style", "color:#eff4fb !important; background-color:#0f349f !important");
     $(".manualPanel").removeClass("span4");
     $(".manualPanel").css("display", "none");
     $(".autoPanel").removeClass("span8");
     $(".autoPanel").addClass("span12");
     seatingPlanInstance["CandidateSeatAutoAssignment"] = 'auto';
     currentPanel = "auto";
     autoSaveAll();
 } else if (a == 'manual') {
     $("#autoButton").attr("style", "color:#0f349f !important; background-color:#eff4fb !important");
     $("#manualButton").attr("style", "color:#eff4fb !important; background-color:#0f349f !important");
     $(".autoPanel").removeClass("span12");
     $(".autoPanel").addClass("span8");
     $(".manualPanel").addClass("span4");
     $(".manualPanel").css("display", "");
     seatingPlanInstance["CandidateSeatAutoAssignment"] = 'manual';
     currentPanel = "manual";
 }
}
function switchAssignmentType(a) {
 if (a == 'assignmentTypeRow') {
     $(".assignmentTypeRowDiv").css("display", "");
     $(".assignmentTypeSeatDiv").css("display", "none");
 } else if (a == 'assignmentTypeSeat') {
     $(".assignmentTypeRowDiv").css("display", "none");
     $(".assignmentTypeSeatDiv").css("display", "");
 }
}
function preparedDropdownAsPerSeatSelection(seatId) {
 var seatData = assignSeats[seatId];
 var subject = seatData["subjectId"];
 var candidateList = subjectWiseCandidates[subject];
}
function doPopOver() {
 doPopOverCheck = true;
 YUI().use(
     'aui-popover',
     function(Y) {
         var trigger = Y.all('[assignmarker="green"]');
         var popover = new Y.Popover({
             align: {
                 node: trigger,
                 points: [Y.WidgetPositionAlign.BC, Y.WidgetPositionAlign.TC]
             },
             bodyContent: '<table style="margin:0px;"><tr><td>CANDIDATE <br/> <b id="candidatePopupText"></b></td><tr><td>SEAT ALLOCATED <br/> <b id="seatAllocatedPopupText"></b></td><tr><td>SUBJECT <br/> <b id="subjectPopupText"></b></td><tr><td>DURATION <br/> <b id="durationPopupText"></b></td><tr><td>INVIGILATOR ASSIGNED <br/> <b id="invisilatorPopupText"></b></td></tr></table>',
             headerContent: '',
             position: 'left'
         }).render();
         trigger.on(
             "mouseenter",
             function(a) {
            	 var clientY = a.clientY>=350?(a.pageY-270):a.pageY;
            	 var clientX = a.clientX<=185?a.pageX:(a.pageX-182);
                 popover._posNode.setAttribute("style", "display: block;left: " + clientX + "px !important; top: " + (clientY + 10) + "px !important;");
                 if (!popoverState) {
                     popover.set('visible', true);
                     popoverState = true;
                     var prefix = seatingPlanInstance.hasOwnProperty("DeskNoFormat")?seatingPlanInstance.DeskNoFormat:"";
                     var canId = a._currentTarget.getAttribute("candid");
                     var CRNNumber = canId != null && candidateDetails.hasOwnProperty(canId) && candidateDetails[canId].hasOwnProperty("CRNNumber") ? ("[" + candidateDetails[canId]["CRNNumber"] + "]") : "";
                     document.getElementById("candidatePopupText").innerHTML = canId != null && candidateDetails.hasOwnProperty(canId)? (CRNNumber + candidateDetails[a._currentTarget.getAttribute("candid")]["FullName"]) : "-";
                     document.getElementById("seatAllocatedPopupText").innerHTML = a._currentTarget.getAttribute("deskno") != null ? prefix+a._currentTarget.getAttribute("deskno") : "-";
                     document.getElementById("subjectPopupText").innerHTML = a._currentTarget.getAttribute("subjectid") != null ? "[" + a._currentTarget.getAttribute("subjectid") + "] " + subjects[a._currentTarget.getAttribute("subjectid")].SubjectTitle : "-";
                     document.getElementById("durationPopupText").innerHTML = a._currentTarget.getAttribute("subjectid") != null && subjects.hasOwnProperty(a._currentTarget.getAttribute("subjectid")) ? (subjects[a._currentTarget.getAttribute("subjectid")]["FTime"] + " - " + subjects[a._currentTarget.getAttribute("subjectid")]["TTime"]) : "-";
                     document.getElementById("invisilatorPopupText").innerHTML = a._currentTarget.getAttribute("invsid") != null ? invigilatorList[a._currentTarget.getAttribute("invsid")]["FullName"] : "-";
                 }
             }
         );
         trigger.on(
             'mouseleave',
             function() {
                 popover.set('visible', false);
                 popoverState = false;
             }
         );
     }
 );
}
//doPopOver();
function populateCandidateDetails() {
 var hp = "<tr><th>Candidate No. + Name</th><th>Subject Taken</th><th>Seat Assigned</th></tr>";
 for (var d = 1; d <= $("span[assignmarker='green']").length; d++) {
     var canDetail = "-";
     var subDetail = "-";
     var prefix = seatingPlanInstance.hasOwnProperty("DeskNoFormat")?seatingPlanInstance.DeskNoFormat:"";
     if ($("span[deskno='" + d + "']").attr("candid") != undefined) {
         if (candidateDetails.hasOwnProperty($("span[deskno='" + d + "']").attr("candid"))) {
             var canId = $("span[deskno='" + d + "']").attr("candid");
             var CRNNumber = candidateDetails.hasOwnProperty(canId) && candidateDetails[canId].hasOwnProperty("CRNNumber") ? ("[" + candidateDetails[canId]["CRNNumber"] + "]") : "";
             canDetail = "" + CRNNumber + " " + candidateDetails[$("span[deskno='" + d + "']").attr("candid")]["FullName"];
         }
     }
     if ($("span[deskno='" + d + "']").attr("subjectid") != undefined) {
         if (subjects.hasOwnProperty($("span[deskno='" + d + "']").attr("subjectid"))) {
             subDetail = "[" + $("span[deskno='" + d + "']").attr("subjectid") + "] " + subjects[$("span[deskno='" + d + "']").attr("subjectid")]["SubjectTitle"];
         }
     }
     hp = hp + "<tr><td>" + canDetail + "</td><td>" + subDetail + "</td><td>" + prefix + d + "</td></tr>";
 }
 return hp;
}
function populateInvisilatorDetails() {
 var htmlPrepare = "<tr><th> Name</th><th>Type</th></tr>";
 for (var inv in assignedInvisilators) {
     htmlPrepare = htmlPrepare + "<tr><td>" + invigilatorList[inv]["FullName"] + "</td><td>" + invigilatorList[inv]["AppointType"] + "</td></tr>";
 }
 console.log("htmlPrepare === " + htmlPrepare);
 return htmlPrepare;
}
var slideLeft = -500;
var slideInterval;
function allDetails(a) {
 var htmlData = "";
 if (a == "candidate") {
     $("#detailsFor").html('&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/images/candidates.png" srcset="<%=request.getContextPath()%>/images/candidates@2x.png 2x, <%=request.getContextPath()%>/images/candidates@3x.png 3x" class="Invigilators">&nbsp;Candidates');
     htmlData = populateCandidateDetails();
 } else if (a == "invisilator") {
     $("#detailsFor").html('&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/images/invigilators.png" srcset="<%=request.getContextPath()%>/images/invigilators@2x.png 2x,<%=request.getContextPath()%>/images/invigilators@3x.png 3x" class="Invigilators">&nbsp;Invigilator');
     htmlData = populateInvisilatorDetails();
 }
 $("#detailsDataTable").html(htmlData);
 AUI().use(
     'aui-base',
     function(A) {
         A.one("#assign-seat-details-dialog").set('hidden', false);
         YUI().use(
             'aui-modal',
             function(Y) {
                 $("#assign-seat-details-dialog").attr("style", "left:inferit; right: -500px; top:45px !important; max-height: 100vh;");
                 var modal = new Y.Modal({
                     boundingBox: "#assign-seat-details-dialog",
                     contentBox: "#assign-seat-details-dialog-box",
                     headerContent: '',
                     centered: true,
                     destroyOnHide: false,
                     modal: true,
                     resizable: false,
                     draggable: true,
                 }).render();
                 $("#assign-seat-details-dialog").attr("style", "left:inferit; right: -500px; top:45px !important; max-height: 100vh;");
                 slideInterval = setInterval(function() {
                     slideLeft = slideLeft + 25;
                     if (slideLeft <= 0) {
                         $("#assign-seat-details-dialog").attr("style", "left:inherit; right: " + slideLeft + "px; top:45px !important; max-height: 100vh;margin-right: 0px;");
                         $(".yui3-widget-mask").css("display", "none");
                     }
                     if (slideLeft >= 0) {
                         debugger;
                         clearInterval(slideInterval);
                         slideLeft = -500;
                     }
                 }, 20);
                 Y.one('.close').on('click', function() {
                     modal.hide();
                     modal = null;
                 });
             });
     });
}
//popup
function actionDialogue(action) {
 var popupdiv = "#action-dialog";
 var popupdivbox = "#action-dialog-box";
 if (action == "auto") {
     document.getElementById("action_title").innerHTML = "Are you sure you want to discard all changes?";
 } else if (action == "manual") {
     document.getElementById("action_title").innerHTML = "Are you sure you want to discard all changes?";
 } else if (action == "reset") {
     document.getElementById("action_title").innerHTML = "Do you want to Reset?";
     //$("#action-dialog").addClass("modalpopupBoxWarning");
 } else if (action == "cancel") {
     document.getElementById("action_title").innerHTML = "Do you want to Cancel?";
     //$("#action-dialog").addClass("modalpopupBoxWarning");
 } else if (action == "submit") {
     document.getElementById("success-msg").innerHTML = "Seating assignment confirmed!";
     document.getElementById("backToMainScreen").href = homeUrl;
     popupdiv = "#sucess-popup";
     popupdivbox = "#sucess-popup-box";
 }
 else if (action == "draft") {
		document.getElementById("success-msg").innerHTML = "Seating assignment saved as draft!";
		document.getElementById("backToMainScreen").href = homeUrl;
		popupdiv = "#sucess-popup";
		popupdivbox = "#sucess-popup-box";
 }
 AUI().use('aui-base',
	function(A) {
		A.one(popupdiv).set('hidden', false);
		YUI().use('aui-modal',
		function(Y) {
			var modal = new Y.Modal({
				boundingBox: popupdiv,
				contentBox: popupdivbox,
				headerContent: '',
				centered: true,
				destroyOnHide: false,
				modal: true,
				resizable: false,
				draggable: true,
			}).render();
			Y.one('.close').on('click', function() {
				modal.hide();
				modal = null;
			});
			Y.one('.popup-cancel-action').on('click', function() {
				console.log("popup-cancel-action...");
				modal.hide();
				modal = null;
			});
			Y.one('.popup-submit-action').on('click',
			function() {
				console.log("popup-submit-action...");
				modal.hide();
				modal = null;
				if (action == "auto") {
					removeAllAsignment();
					swithcPanel('auto')
				} else if (action == "manual") {
					//removeAllAsignment();
					swithcPanel('manual')
				} else if (action == "reset") {
					window.location = seatingAssignmentURL +
						"&SeatingPlanInstanceId=" +
						spliId;
				} else if (action == "cancel") {
					window.location = homeUrl;
				} else if (action == "submit") {
					window.location = homeUrl;
				} else if (action == "draft") {
					window.location = homeUrl;
				}
			});
		});
	});
}
setTimeout(function() {
 if (!doPopOverCheck) {
     doPopOver();
 }
 getEID("seatingAssignment").style = "";
 showLoading(false);
}, 10000);
//UI Function End
function fetchScheduleDetail(schId) {
 var fData = {};
 fData.formStorageId = schId;
 fData.formType = "schedule";
 ajaxCallAPI(
     'GET',
     "loadData",
     fData,
     function() {
         var schData = this.get("responseData");
         if (data.error) {
         } else {
             //responseData = contentdata.content;
             if (schData.hasOwnProperty("contentJson")) {
                 scheduleDetail = schData.contentJson;
             }
         }
     },
     function() {});
}
function saveSeatingAssignment(action) {
 showLoading(true);
 var modelName = "seatingplanlayout";
 var data = {};
 data.formType = modelName;
 data.seatingPlanInstace = spliId;
 data.actionType = "removedbyinstanceid";
 ajaxCall('GET', 'removeUserAssignedSeat', ajaxUrl, data,
	function() {
	 gAction = action;
	 if(action=="draft"){
		 seatingPlanInstance.AssignSeatStatus = "Draft";
	 }
	 else if(action=="submit"){
		 seatingPlanInstance.AssignSeatStatus = "Active";
	 }
		saveSeatingPlanInstance();
	},
	function() {
	});
}
/*
function recursivePost(ua, no) {
 if (ua.length == no) {
     showLoading(false);
     actionDialogue('submit');
     return;
 }
 var formData = ua[no];
 formData.formType = "userseatassign";
 ajaxCallAPI('POST', 'persist', formData, function() {
     var data = this.get("responseData");
     console.log(data);
     setTimeout(function() {
         no++;
         recursivePost(ua, no);
     }, 500)
 }, function() {
 });
}
*/
function autoSaveAllOld() {
 for (var subj in subjectWiseCandidate) {
     var i = 0;
     var candArray = subjectWiseCandidate[subj];
     $("span[subjectid='" + subj + "']").each(function() {
         if (i < candArray.length) {
             var deskno = $(this).attr("deskno");
             var seatId = $(this).attr("userassignseat");
             $(this).attr("candid", candArray[i]);
             assignCand.push(candArray[i]);
             userSeatAssign.candidate[seatId] = {
                 "AssignSeatId": seatId,
                 "UserType": "0",
                 "UserId": candArray[i],
                 "SeatingPlanInstanceId": spliId,
                 "userSeatAssignId": seatId + "_" + spliId + "_0"
             }
             i++;
         }
     });
 }
}

function checkOverlap(candid, sub){
	if(candid == undefined || candid=="" || sub == undefined || sub==""){
		eValid = true;
	}
	
	var eValid=false;
	if($("span[candid='"+candid+"']").length>0){
		var iFTime = subjects[sub]["FTime"];
		var iTTime = subjects[sub]["TTime"];
		$("span[candid='"+candid+"']").each(function(){
			var sub1 = $(this).attr("subjectid");
			var jFTime = subjects[sub1]["FTime"];
			var jTTime = subjects[sub1]["TTime"];
			if(TimeDifference(iFTime,jFTime)>=0&&TimeDifference(iTTime,jFTime)<=0){
				eValid = true;
			}else if(TimeDifference(iFTime,jTTime)>=0&&TimeDifference(iTTime,jTTime)<=0){
				eValid = true;
			}
		});
	}
	return eValid;
}
function autoSaveAll(){
	var invigilatorId = "";
	for(var k in invigilatorList){
		if(k != undefined){
			invigilatorId = k;
			break;
		}
	}
	 var subStack = {};
	for (var i = 1; i <= $("span[deskno]").length; i++) {
	     var sub = $("span[deskno='" + i + "']").attr("subjectid");
	     if (sub != undefined && subjectWiseCandidate.hasOwnProperty(sub)) {
	         if (!subStack.hasOwnProperty(sub)) {
	             subStack[sub] = 0;
	         }
	         if(subjectWiseCandidate[sub].length>subStack[sub]){
		         if(checkOverlap(subjectWiseCandidate[sub][subStack[sub]], sub)){
		        	 subStack[sub] = parseInt(subStack[sub]) + 1;
		        	 i = i - 1;
		         }else{
			         $("span[deskno='" + i + "']").attr("candid", subjectWiseCandidate[sub][subStack[sub]]);
	        	     subStack[sub] = parseInt(subStack[sub]) + 1;
		         }
	         }
	     }
         $("span[deskno='" + i + "']").attr("invsid", invigilatorId);
         if(i == $("span[deskno]").length){
        	 var invData = {};
	    	 invData["type"] = "assignmentTypeSeat";
	    	 invData["value"] = "1-"+$("span[deskno]").length;
	    	 invisilatorUsed[invigilatorId] = invData;
	    	 assignedInvisilators[invigilatorId] = invigilatorList[invigilatorId];
         }
	}
}
function autoSaveAllV1() {
 var subStack = {};
 var curSubj = "_";
 for (var i = 1; i < $("span[deskno]").length; i++) {
     var sub = $("span[deskno='" + i + "']").attr("subjectid");
     if (sub != undefined && subjectWiseCandidate.hasOwnProperty(sub)) {
         if (!subStack.hasOwnProperty(sub)) {
             subStack[sub] = 0;
         }
         if (parseInt(subStack[sub]) <= (subjectWiseCandidate[sub].length - 1)) {
             if (assignCand.indexOf(subjectWiseCandidate[sub][subStack[sub]]) == -1) {
                 $("span[deskno='" + i + "']").attr("candid", subjectWiseCandidate[sub][subStack[sub]]);
                 var seatId = $("span[deskno='" + i + "']").attr("userassignseat");
                 assignCand.push(subjectWiseCandidate[sub][subStack[sub]]);
                 userSeatAssign.candidate[seatId] = {
                     "AssignSeatId": seatId,
                     "UserType": "0",
                     "UserId": subjectWiseCandidate[sub][subStack[sub]],
                     "SeatingPlanInstanceId": spliId,
                     "userSeatAssignId": seatId + "_" + spliId + "_0"
                 }
                 subStack[sub] = parseInt(subStack[sub]) + 1;
             }
         }
     }
 }
}

function showInvDetails(){
	var invId = $("#invigilatorName").val();
	$("#rowNumbers").val("");
	$("#managesDesk").val("");
	if(invId != "" && invisilatorUsed.hasOwnProperty(invId)){
		switchAssignmentType(invisilatorUsed[invId]['type']);
		if(invisilatorUsed[invId]['type']=="assignmentTypeRow"){
			$("#assignmentTypeRow").prop("checked",true);
			$("#rowNumbers").val(invisilatorUsed[invId]['value']);
		}else{
			$("#assignmentTypeSeat").prop("checked",true);
			$("#managesDesk").val(invisilatorUsed[invId]['value']);
		}
	}
	
}

function saveAssignInvigilatorSeat() {
 var invId = $("#invigilatorName").val();
 if (invId != "") {
     $("span[invsid='" + invId + "']").each(function() {
         $(this).removeAttr("invsid");
     });
     if ($("#removeInvigilatorCheck").is(":checked")) {
         delete assignedInvisilators[invId];
         delete invisilatorUsed[invId];
         for (var k in userSeatAssign.invisilator) {
             var u = userSeatAssign.invisilator[k];
             if (k != undefined && u != undefined && u.hasOwnProperty("UserId") && u.UserId == invId) {
                 delete userSeatAssign.invisilator[k];
             }
         }
     } else {
    	 var invData = {};
         if ($("#assignmentTypeRow").is(":checked")) {
        	 invData["type"] = "assignmentTypeRow";
        	 invData["value"] = $("#rowNumbers").val();
             var rows = $("#rowNumbers").val() != "" ? $("#rowNumbers").val().split(",") : [];
             for (var i = 0; i < rows.length; i++) {
                 //var row = parseInt(rows[i].replace(/R/g,""))
                 var row = parseInt(rows[i]);
                 $("td[row=" + row + "]").each(function() {
                     var thisSeat = $(this).children(".actualSeat");
                     if ($(thisSeat).attr("deskno") != undefined) {
                         $(thisSeat).attr("invsid", invId);
                         var seatId = $(thisSeat).attr("userassignseat");
                         if (seatId != undefined) {
                             userSeatAssign.invisilator[seatId] = {
                                 "AssignSeatId": seatId,
                                 "UserType": "1",
                                 "UserId": invId,
                                 "SeatingPlanInstanceId": spliId,
                                 "userSeatAssignId": seatId + "_" + spliId + "_1"
                             }
                             assignedInvisilators[invId] = invigilatorList[invId];
                         }
                     }
                 });
             }
         } else {
        	 invData["type"] = "assignmentTypeSeat";
        	 invData["value"] = $("#managesDesk").val();
             var seats = $("#managesDesk").val() != "" ? $("#managesDesk").val().split(",") : [];
             for (var i = 0; i < seats.length; i++) {
                 var seatRange = seats[i].split("-");
                 for (var k = 0; k < seatRange.length; k++) {
                     for (var s = parseInt(seatRange[k]); s <= parseInt(seatRange[seatRange.length - 1]); s++) {
                         $("span[deskno='" + s + "']").attr("invsid", invId);
                         var seatId = $("span[deskno=" + s + "]").attr("userassignseat");
                         if (seatId != undefined) {
                             userSeatAssign.invisilator[seatId] = {
                                 "AssignSeatId": seatId,
                                 "UserType": "1",
                                 "UserId": invId,
                                 "SeatingPlanInstanceId": spliId,
                                 "userSeatAssignId": seatId + "_" + spliId + "_1"
                             }
                             assignedInvisilators[invId] = invigilatorList[invId];
                         }
                     }
                 }
             }
         }
         invisilatorUsed[invId] = invData;
     }
 }
 otherDetails["invisilatorDetails"] = invisilatorUsed;
 $("#invigilatorName").val("");
 $("#rowNumbers").val("");
 $("#managesDesk").val("");
 $("#rowNumbers").removeAttr("disabled");
 $("#managesDesk").removeAttr("disabled");
 $("#removeInvigilatorCheck").prop("checked", false);
 $("#assignmentTypeRow").attr("disabled", null);
 $("#assignmentTypeSeat").attr("disabled", null);
 $("#rowNumbers").attr("disabled", null);
 $("#managesDesk").attr("disabled", null);
}
function saveAssignCandidateSeat() {
	var isError = false;
 $("#invalidSeatError").css("display","none");
 var deskno = $("#candidateDeskNo").val();
 var candId = $("#candidateName").val();
 var seatId = $("span[deskno='" + deskno + "']").attr("userassignseat");
 if (candId != "") {
     if ($("#removeCandidateCheck").is(":checked")) {

         $("span[candid='" + candId + "']").each(function() {
             $(this).removeAttr("candid");
         });
         $("span[deskno='" + deskno + "']").removeAttr("candid");
         if (assignCand.indexOf(candId) > 0) {
             assignCand.splice(assignCand.indexOf(candId), 1);
         }
         if (candidateIds.indexOf(candId) > 0) {
             candidateIds.splice(candidateIds.indexOf(candId), 1);
         }
         if (candidateDetails.hasOwnProperty(candId)) {
             delete candidateDetails[candId];
         }
         if (userSeatAssign.candidate.hasOwnProperty(seatId)) {
             delete userSeatAssign.candidate[seatId];
         } else {
             for (var k in userSeatAssign.candidate) {
                 var u = userSeatAssign.candidate[k];
                 if (k != undefined && u != undefined && u.hasOwnProperty("UserId") && u.UserId == candId) {
                     delete userSeatAssign.candidate[k];
                 }
             }
         }
     } else {
    	 var subId = $("span[deskno='" + deskno + "']").attr("subjectid");
    	 if(candId == $("span[deskno='" + deskno + "']").attr("candid")){
    		 $("#invalidSeatError").css("display","none");
    	 }
    	 else if(subId == undefined){
    		 $("#invalidSeatError").css("display","");
    	 }
    	 else if(subId != undefined && subjectWiseCandidate.hasOwnProperty(subId) && subjectWiseCandidate[subId].indexOf(candId)>=0){
    			var iFTime = subjects[subId]["FTime"];
   				var iTTime = subjects[subId]["TTime"];
   				$("span[candid='"+candId+"']").each(function(){
   					var eValid = false;
   					var sub1 = $(this).attr("subjectid");
   					var jFTime = subjects[sub1]["FTime"];
   					var jTTime = subjects[sub1]["TTime"];
   					if(TimeDifference(iFTime,jFTime)>=0&&TimeDifference(iTTime,jFTime)<=0){
   						eValid = true;
   					}else if(TimeDifference(iFTime,jTTime)>=0&&TimeDifference(iTTime,jTTime)<=0){
   						eValid = true;
   					}
   					if(eValid){
   						$(this).removeAttr("candid");
   					}
   				});
   				$("span[deskno='" + deskno + "']").attr("candid", candId);
   				assignCand.push(candId);
   				userSeatAssign.candidate[seatId] = {
   		             "AssignSeatId": seatId,
   		             "UserType": "0",
   		             "UserId": candId,
   		             "SeatingPlanInstanceId": spliId,
   		             "userSeatAssignId": seatId + "_" + spliId + "_0"
   		         }
    	 }else{
    		 $("#invalidSeatError").css("display","");
    		 isError = true;
    	 }
     }
 }
 if(!isError){
	 var htmlOptions = "<option value=''>Choose a candidate...</option>";
	 $("#candidateName").html(htmlOptions);
	 $("#candidateName").val("");
	 $("#candidateDeskNo").val("");
	 $("#removeCandidateCheck").prop("checked", false);
	 $("#candidateDeskNo").attr("disabled", null);
 }
}
function populateCandidatesBySubject(subId, candId) {
 var htmlOptions = "<option value=''>Choose a candidate...</option>";
 if (subjectWiseCandidate.hasOwnProperty(subId)) {
     var candList = subjectWiseCandidate[subId];
     for (var i = 0; i < candList.length; i++) {
    	 if (candId != candList[i]) {
         	if (!checkOverlap(candList[i], subId) && candidateDetails.hasOwnProperty(candList[i])) {
	             htmlOptions = htmlOptions + "<option value='" + candList[i] + "'>" + candidateDetails[candList[i]]["FullName"] + "</option>";
             }
         }
     }
     if (candId != "" && candidateDetails.hasOwnProperty(candId)) {
         htmlOptions = htmlOptions + "<option selected='selected' value='" + candId + "'>" + candidateDetails[candId]["FullName"] + "</option>";
     }
 }
 $("#candidateName").html(htmlOptions);
}
function populateInvisilators() {
 var htmlOpt = "<option value=''>Choose a invigilators...</option>";
 for (var inv in invigilatorList) {
     htmlOpt = htmlOpt + "<option value='" + inv + "'>" + invigilatorList[inv]["FullName"] + "</option>";
 }
 $("#invigilatorName").html(htmlOpt);
}
function fetchCandidatesRecursive(no) {
 if (no == candidateIds.length) {
     return false;
 }
 var filter = {};
 //filter.conditions = [ "userId="+candidateIds[no]];
 filter.formStorageId = candidateIds[no];
 filter.formType = "candidate";
 ajaxCallAPI(
     'GET',
     "loadData",
     filter,
     function() {
         var candData = this.get("responseData");
         if (candData == null || candData.error) {
             displayMessage('danger', candData.error, 3000);
         } else {
             if (candData.hasOwnProperty("contentJson") && candData.contentJson.hasOwnProperty("FullName")) {
                 candidateDetails[candData.storageId] = candData.contentJson;
             }
         }
         no++;
         fetchCandidatesRecursive(no);
         /*
         setTimeout(function(){
         	no++;
         	fetchCandidatesRecursive(no);
         }, 500);
         */
     },
     function() {
     });
}

function transformation(data) {
 var dataArray = data.content;
 for (var i = 0; i < dataArray.length; i++) {
     var obj = dataArray[i];
     var contentJson = obj.contentJson;
     if (obj.hasOwnProperty("enrolmentStatus")
 			&& (obj.enrolmentStatus.toLocaleLowerCase() == "confirmed"
 				|| obj.enrolmentStatus.toLocaleLowerCase() == "notified" 
 				|| obj.enrolmentStatus.toLocaleLowerCase() == "verified")
 			&& contentJson.hasOwnProperty("subjects")) {
         for (var j = 0; j < contentJson.subjects.length; j++) {
             var sub = contentJson.subjects[j];
             if (subjects.hasOwnProperty(sub.SubjectCode)) {
                 subjects[sub.SubjectCode]["SubjectCode"] = sub.SubjectCode;
                 subjects[sub.SubjectCode]["SubjectTitle"] = sub.SubjectTitle;
                 subjects[sub.SubjectCode]["SubjectType"] = sub.SubjectType;
                 //subjectArr.push(sub);
                 if (subjectWiseObject.hasOwnProperty(sub.SubjectCode)) {
                     subjectWiseObject[sub.SubjectCode].push(obj);
                 } else {
                     subjectWiseObject[sub.SubjectCode] = [obj];
                 }
                 if (obj.hasOwnProperty("candidateId") && obj.candidateId != "") {
                     if (subjectWiseCandidate.hasOwnProperty(sub.SubjectCode)) {
                         if (subjectWiseCandidate[sub.SubjectCode].indexOf(obj.candidateId) == -1) {
                             subjectWiseCandidate[sub.SubjectCode].push(obj.candidateId);
                         }
                     } else {
                         subjectWiseCandidate[sub.SubjectCode] = [obj.candidateId];
                     }
                 }
             }
         }

         if (obj.hasOwnProperty("candidateId") && obj.candidateId != "" && candidateIds.indexOf(obj.candidateId) == -1) {
             candidateIds.push(obj.candidateId);
             var name = setDash(obj.contentJson.FullName)!="-"?setDash(obj.contentJson.FullName):(setDash(obj.contentJson.FirstName)!="-"?(setDash(obj.contentJson.FirstName)+(setDash(obj.contentJson.LastName)!="-"?" "+obj.contentJson.LastName:"")):setDash(obj.contentJson.LastName));
             var CRNNumber = "";
             
             if(obj.contentJson.hasOwnProperty("SrnNumber") && obj.contentJson.SrnNumber.toString()!=""){
            	 CRNNumber = obj.contentJson.SrnNumber.toString();
             }
             else{
            	 CRNNumber = obj.contentJson.CRNNumber;
             }
             candidateDetails[obj.candidateId] = {enrolmentId:obj.enrolmentId, programmeCode:obj.programmeCode,CRNNumber:setDash(CRNNumber), FullName:name, CandidateId:obj.contentJson.CandidateId};
         }
     }
 }
 filterSubjectWiseCandidate();
}
function loadEnrolmentsBySchedule(sch) {
 var filter = {};
 filter.conditions = ["scheduleCode=" + sch, "size=" + 2147483647];
 filter.formType = "enrolment";
 ajaxCallAPI(
     'GET',
     "searchList",
     filter,
     function() {
         var subData = this.get("responseData");
         transformation(subData);
         //fetchCandidatesRecursive(0);
         console.log("contentdata : " + JSON.stringify(contentdata));
     },
     function() {
     });
}
function loadSeatingPlan(id) {
 var filter = {};
 //filter.formStorageId = id ;
 filter.formType = "seatingplan";
 filter.conditions = ["contentJson.Facility=" + SPInstance.FacilityId, "contentJson.SubFacility=" + SPInstance.SubFacilityId, "size=" + 2147483647];
 ajaxCallAPI(
     'GET',
     "searchList",
     filter,
     function() {
         var data = this.get("responseData");
         if (data.content.length > 0) {
             currentSeatingPlan = data.content[0];
             data = data.content[0].contentJson;
             allowOverrideAutoAssign = data.AllowToOverrideSeatAutoAssignment;
             isAutoAssignSeatToCandidate = data.CandidateSeatAutoAssignment == "Auto" ? true : false;
             switchAssignmentType('assignmentTypeRow');
             if(seatingPlanInstance!=undefined && (statusOfAssignment=="Active" || statusOfAssignment=="Draft") && seatingPlanInstance.hasOwnProperty("CandidateSeatAutoAssignment")){
            	 data["CandidateSeatAutoAssignment"] = seatingPlanInstance["CandidateSeatAutoAssignment"];
            	 data["AllowToOverrideSeatAutoAssignment"] = seatingPlanInstance["AllowToOverrideSeatAutoAssignment"];
             }else{
            	 seatingPlanInstance["CandidateSeatAutoAssignment"] = data["CandidateSeatAutoAssignment"];
            	 seatingPlanInstance["AllowToOverrideSeatAutoAssignment"] = data["AllowToOverrideSeatAutoAssignment"];
             }

             if (data.CandidateSeatAutoAssignment == "Auto") {
            	 showLoading(true);
                 setTimeout(function() {
                	 showLoading(false);
                     swithcPanel("auto");
                 }, 10000);
                 if (!data.AllowToOverrideSeatAutoAssignment) {
                     $("#manualButton").attr("disabled", true);
                 }
             } else {
                 swithcPanel("manual");
                 $("#autoButton").attr("disabled", true);
             }
         } else {
             swithcPanel("manual");
             $("#autoButton").attr("disabled", true);
         }
     },
     function() {
     }
 );
}
function loadSPLParameters(id) {
 var filter = {};
 filter.conditions = ["seatLayoutId=" + id, "size=" + 2147483647];
 filter.formType = "seatingplanlayoutparameters";
 ajaxCallAPI('GET', "searchList", filter, function() {
     var SPLPData = this.get("responseData");
     if (SPLPData.error) {
         displayMessage('danger', SPLPData.error, 3000);
     } else {
         for (var i = 0; i < SPLPData.content.length; i++) {
             var SPLPObj = SPLPData.content[i];
             var seats = SPLPObj.assignSeats;
             for (var s = 0; s < seats.length; s++) {
                 var seat = seats[s];
                 $("#seatTD_" + seat.noColumn + "_" + seat.noRow + " .actualSeat").attr("subjectid", SPLPObj.subjectId.storageId);
                 $("#seatTD_" + seat.noColumn + "_" + seat.noRow + " .actualSeat").attr("userassignseat", seat.storageId);
                 for (var u = 0; u < seat.users.length; u++) {
                     var user = seat.users[u];
                     if (user.userType == "0") {
                         $("#seatTD_" + seat.noColumn + "_" + seat.noRow + " .actualSeat").attr("candid", user.userId.storageId);
                         userSeatAssign.candidate[seat.storageId] = {
                             "AssignSeatId": seat.storageId,
                             "UserType": "0",
                             "UserId": user.userId.storageId,
                             "SeatingPlanInstanceId": spliId,
                             "userSeatAssignId": seat.storageId + "_" + spliId + "_0"
                         };
                         assignCand.push(user.userId.storageId);
                     } else if (user.userType == "1") {
                         $("#seatTD_" + seat.noColumn + "_" + seat.noRow + " .actualSeat").attr("invsid", user.userId.storageId);
                         userSeatAssign.invisilator[seat.storageId] = {
                             "AssignSeatId": seat.storageId,
                             "UserType": "1",
                             "UserId": user.userId.storageId,
                             "SeatingPlanInstanceId": spliId,
                             "userSeatAssignId": seat.storageId + "_" + spliId + "_1"
                         };
                         assignedInvisilators[user.userId.storageId] = invigilatorList[user.userId.storageId];
                     }
                 }
             }
         }
     }
 }, function() {
 });
}
function fetchUserSeatAssignBySPI(mId) {
 var data = {};
 data.formType = "userseatassign";
 data.conditions = ["SeatingPlanInstanceId=" + mId, "size=" + 2147483647];
 ajaxCallAPI(
     'GET',
     "searchList",
     data,
     function() {
         var iData = this.get("responseData");
         if (iData.error) {
             displayMessage('danger', iData.error, 3000);
         } else {
             for (var i = 0; i < iData.content.length; i++) {
                 var obj = iData.content[i];
                 if (obj.userType == "0") {
                     $("span[userassignseat='" + obj.contentJson.AssignSeatId + "']").attr("candid", obj.contentJson.UserId);
                     userSeatAssign.candidate[obj.contentJson.AssignSeatId] = obj.contentJson;
                 } else if (obj.userType == "1") {
                     $("span[userassignseat='" + obj.contentJson.AssignSeatId + "']").attr("invsid", obj.contentJson.UserId);
                     userSeatAssign.invisilator[obj.contentJson.AssignSeatId] = obj.contentJson;
                 }
             }
         }
     },
     function() {
         displayMessage('danger',
             "Error in persisting dynamic form data.", 3000);
     });
}


function assignInvByRows(invId, rows){
	var rows = rows.split(",");
	for (var i = 0; i < rows.length; i++) {
        //var row = parseInt(rows[i].replace(/R/g,""))
        var row = parseInt(rows[i]);
        $("td[row=" + row + "]").each(function() {
            var thisSeat = $(this).children(".actualSeat");
            if ($(thisSeat).attr("deskno") != undefined) {
                $(thisSeat).attr("invsid", invId);
                var seatId = $(thisSeat).attr("userassignseat");
                if (seatId != undefined) {
                    userSeatAssign.invisilator[seatId] = {
                        "AssignSeatId": seatId,
                        "UserType": "1",
                        "UserId": invId,
                        "SeatingPlanInstanceId": spliId,
                        "userSeatAssignId": seatId + "_" + spliId + "_1"
                    }
                    assignedInvisilators[invId] = invigilatorList[invId];
                }
            }
        });
    }
}

function assignInvBySeat(invId, seats){
	var seats = seats.split(",");
    for (var i = 0; i < seats.length; i++) {
        var seatRange = seats[i].split("-");
        for (var k = 0; k < seatRange.length; k++) {
            for (var s = parseInt(seatRange[k]); s <= parseInt(seatRange[seatRange.length - 1]); s++) {
                $("span[deskno='" + s + "']").attr("invsid", invId);
                var seatId = $("span[deskno=" + s + "]").attr("userassignseat");
                if (seatId != undefined) {
                    userSeatAssign.invisilator[seatId] = {
                        "AssignSeatId": seatId,
                        "UserType": "1",
                        "UserId": invId,
                        "SeatingPlanInstanceId": spliId,
                        "userSeatAssignId": seatId + "_" + spliId + "_1"
                    }
                    assignedInvisilators[invId] = invigilatorList[invId];
                }
            }
        }
    }
}

function fetchSeatingPlanInstance() {
 var data = {};
 data.conditions = ["storageId=" + spliId, "size=" + 1];
 data.formType = "seatingplaninstance";
 ajaxCallAPI(
     'GET',
     "searchList",
     data,
     function() {
         data = this.get("responseData");
         contentdata = this.get("responseData");
         console.log("contentdata : " + JSON.stringify(contentdata));
         if (data.error || !data.hasOwnProperty("content") || data.content.length==0) {
             displayMessage('danger', data.error, 3000);
         } 
         else {
             //responseData = contentdata.content;
			 data = data.content[0];
             if (data.hasOwnProperty("contentJson")) {
                 SPInstance = data.contentJson;
                 deskFormat = SPInstance.DeskNoFormat;
                 seatingPlanInstance = SPInstance;
         		 checkPreviousData(SPInstance.ScheduleId);
                 loadSubjectsBySchedule(SPInstance.ScheduleId);
                 seatingPlanInstanceChanges = SPInstance;
                 SeatPlanStatus = SPInstance.SeatPlanStatus;
                 initSeatingLayout(SPInstance.NoOfRows,
                     SPInstance.NoOfColumns, "seatingSetup");
                 populateSeatSelectDropdown(SPInstance.NoOfRows,
                     "fromRow");
                 populateSeatSelectDropdown(SPInstance.NoOfRows, "toRow");
                 populateSeatSelectDropdown(SPInstance.NoOfColumns,
                     "fromColumn");
                 populateSeatSelectDropdown(SPInstance.NoOfColumns,
                     "toColumn");
                 $("#totalCapicitySeats").html(
                     SPInstance.NoOfRows * SPInstance.NoOfColumns);
                 $("#totalAvailableSeats").html(
                     SPInstance.NoOfRows * SPInstance.NoOfColumns);
                 //loadEnrolmentsBySchedule(SPInstance.ScheduleId);
                 fetchInvigilators(SPInstance.ScheduleId);
                 //fetchInvigilators("Monash:2019(1)");
                 $("#panelTitleText").html(SPInstance.ScheduleId);
                 //loadSPLayout(spliId);
                 statusOfAssignment = data.assignSeatStatus;
                 if (data.assignSeatStatus == "Active") {
                     $("#draft").css("display", "none");
                 }else{
                	 $("#draft").css("display", "");
                 }
                 loadSeatingPlan(SPInstance.SeatingPlanId);
                 //fetchUserSeatAssignBySPI(data.modelId);
                 spliIdModel = data.modelId;
					if(seatingPlanInstance.hasOwnProperty("seatingPlanLayouts")){
						var SPLData = seatingPlanInstance.seatingPlanLayouts;
						var showSeatNo = false;
						for (var i = 0; i < SPLData.length; i++) {
							var spl = SPLData[i];
							prepareAssignMarkers(spl.AssignMarkerContent);
							loadAssignMarkerToSeat(spl.FromRow, spl.ToRow, spl.FromCol, spl.ToCol, spl.AssignMarker);
							var arr = spl.SeatingPlanLayoutId.split("_");
							arr.pop();
							var splayoutid = arr.join("_");
							seatingPlanLayout[splayoutid] = spl;
							if (spl.AssignMarker == "green" || spl.AssignMarker == "#8bdb7c") {
								snd = spl.SeatNoDirection;
								seatLayoutId = spl.SeatingPlanLayoutId;
								changeSeatNoDirection({value : snd});
								provideDeskNo(parseInt(SPInstance.NoOfRows)*parseInt(SPInstance.NoOfColumns));
								if(snd == "downright" || snd == "downsnakeright" || snd == "upright" || snd == "upsnakeright" || snd == "leftdown" || snd == "leftsnakedown" || snd == "rightdown" || snd == "rightsnakedown"){
									for(var i=1;i<=$("[deskno]").length;i++){
										var prefix = seatingPlanInstance.hasOwnProperty("DeskNoFormat")?seatingPlanInstance.DeskNoFormat:"";
										$("[deskno="+i+"]").parent().children(".deskNo").html(prefix+($("[deskno]").length-(i-1)));
										$("[deskno="+i+"]").attr("udeskno", ($("[deskno]").length-(i-1)));
									}
									for(var i=1;i<=$("[udeskno]").length;i++){
										$("[udeskno="+i+"]").attr("deskno", i);
									}
								}
								if(spl.hasOwnProperty("seatingPlanLayoutParameters") && spl.seatingPlanLayoutParameters.length>0){
									for(var k=0;k<spl.seatingPlanLayoutParameters.length;k++){
										layoutParameters[spl.seatingPlanLayoutParameters[k]["SubjectId"]] = spl.seatingPlanLayoutParameters[k];
										var seats = spl.seatingPlanLayoutParameters[k].hasOwnProperty("assignSeats")?spl.seatingPlanLayoutParameters[k].assignSeats:[];
										for(var s=0;s<seats.length;s++){
											var seat = seats[s];
							                 $("#seatTD_" + seat.Column + "_" + seat.Row + " .actualSeat").attr("subjectid", seat.SubjectId);
							                 $("#seatTD_" + seat.Column + "_" + seat.Row + " .actualSeat").attr("userassignseat", seat.seatId);
											 if(data.assignSeatStatus == "Active" || data.assignSeatStatus == "Draft" ){
												 if(seat.hasOwnProperty("UserAssignSeats") && seat.UserAssignSeats.length>0){
													 for(var u=0;u<seat.UserAssignSeats.length;u++){
														 var usa = seat.UserAssignSeats[u];
														 if (usa.UserType == "0") {
															 $("#seatTD_" + seat.Column + "_" + seat.Row + " .actualSeat").attr("candid", usa.UserId);
														 }
														 else if(usa.UserType == "1"){
															 $("#seatTD_" + seat.Column + "_" + seat.Row + " .actualSeat").attr("invsid", usa.UserId);
														 }
													 }
												 }
											 }else{
												 seat["UserAssignSeats"] = [];
											 }
										}
									}
								}
							}
						}
					}
					
					if((data.assignSeatStatus == "Active" || data.assignSeatStatus == "Draft") && seatingPlanInstance.hasOwnProperty("otherDetails")){
						if(seatingPlanInstance.otherDetails.hasOwnProperty("invisilatorDetails")){
							invisilatorUsed = seatingPlanInstance.otherDetails.invisilatorDetails;
							for(var i in invisilatorUsed){
								if(i != undefined && i != "" ){
									if(invisilatorUsed[i].type == "assignmentTypeRow"){
										assignInvByRows(i, invisilatorUsed[i].value);
										assignedInvisilators[i] = invigilatorList[i];
									}
									else{
										assignInvBySeat(i, invisilatorUsed[i].value)
										assignedInvisilators[i] = invigilatorList[i];
									}
								}
							}
						}
						otherDetails = seatingPlanInstance.otherDetails;
					}
                 }
             }
         },
	     function() {
	         displayMessage('danger',
	             "Error in persisting dynamic form data.");
	         showLoading(false);
	     });
}
function fetchInvigilators(schedule) {
 console.log("Schedule === " + schedule);
 var data = {};
 data.formType = "invigilatorappointment";
 data.conditions = ["scheduleId=" + schedule, "size=" + 2147483647];
 ajaxCallAPI(
     'GET',
     "searchList",
     data,
     function() {
         var iData = this.get("responseData");
         var responseData = [];
         if (iData.error) {
             displayMessage('danger', iData.error, 3000);
         } else {
             for (var i = 0; i < iData.content.length; i++) {
                 invigilatorList[iData.content[i].contentJson.UserId] = iData.content[i].contentJson;
             }
             populateInvisilators();
         }
         console.log("contentdata Response : " + JSON.stringify(responseData));
     },
     function() {
         displayMessage('danger',
             "Error in persisting dynamic form data.", 3000);
     });
}
function disabledManualPanel(){
	if($('.ui-selected').length>0){
		$("#candidateName").attr("disabled", false);
		$("#candidateDeskNo").attr("disabled", false);
		$("#removeCandidateCheck").attr("disabled", false);
		$("#saveCandidateButton").attr("disabled", false);
	}else{
		$("#candidateName").attr("disabled", true);
		$("#candidateDeskNo").attr("disabled", true);
		$("#removeCandidateCheck").attr("disabled", true);
		$("#saveCandidateButton").attr("disabled", true);
	}
}
function disabledDetailButton(){
	if($("span[candid]").length>0){
		$("#candidateDetailsButton").attr("disabled", false);
	}else{
		$("#candidateDetailsButton").attr("disabled", true);
	}
	if($("span[invsid]").length>0){
		$("#invisilatorDetailsButton").attr("disabled", false);
	}else{
		$("#invisilatorDetailsButton").attr("disabled", true);
	}
}
//Assign seat end
/*
* $(".ui-selected").on("click", function(){ $(this).removeClass("ui-selected");
* });
*/
</script>