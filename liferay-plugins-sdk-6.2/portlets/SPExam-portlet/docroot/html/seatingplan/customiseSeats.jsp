<%@ include file="/html/init.jsp"%>

<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>
<portlet:renderURL var="homePage">
	<portlet:param name="jspPage" value="/html/seatingplan/view.jsp" />
</portlet:renderURL>

<portlet:renderURL var="customiseSeats">
	<portlet:param name="jspPage"
		value="/html/seatingplan/customiseSeats.jsp" />
</portlet:renderURL>

<portlet:renderURL var="seatingLayoutSetup">
	<portlet:param name="jspPage"
		value="/html/seatinglayout/list.jsp" />
</portlet:renderURL>

<div class="newPortlets">
	<%
		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		String seatingPlanInstanceId = httpReq.getParameter("SeatingPlanInstanceId");
		String baseUrl = portletPreferences.getValue("baseUrlPref", "");
		String seatingPlanScreenId = httpReq.getParameter("ScreenId") != null
				? httpReq.getParameter("ScreenId")
				: "0";
		if (PermissionUtil.canAddModel((PortletRequest) request.getAttribute("javax.portlet.request"))) {
	%>
	<%
		String dashBoardLink = SambaashUtil.getDashBoard();
	%>
	<%@ include file="/html/common/headerSeatingPlan.jsp"%>
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
</style>
	<div class="customiseSeatsPage ">
		<div id="load-assign-marker-style-tag"></div>
		<div class="formContainer container formio-form"
			style="background-color: #f7f9fc;">
			<aui:row style="background-color: white">
				<aui:col span="4">
					<aui:row cssClass="customiseSeats">
						<aui:col span="12">
						</aui:col>
						<aui:col span="12">
							<div class="form-group">
								<label class="control-label font-color-blue">ASSIGN
									MARKER</label>
								<hr />
								<select onmouseenter="if($('.ui-selected').length>0){ $(this).attr('disabled', false); } else { $(this).attr('disabled', 'disabled'); }" name="" id="assignMarker" class="form-control"
									placeholder="Choose a Marker"
									onChange="changeAssignMarker(this);">
									<option value=''>Choose a Marker...</option>
									<option value='green'>Available Seats</option>
									<option value='grey'>Unavailable Seats</option>
									</select>
							</div>
						</aui:col>
						<aui:col span="12">

							<div class="form-group">
								<br /> <label class="control-label font-color-blue">EXISTING
									MARKERS</label>
								<hr />
								<div id="viewAllAssignMarkers"></div>
							</div>
						</aui:col>
						<aui:col>
							<div class="form-group">
								<br /> <label class="control-label font-color-blue">SELECT
									SEATS</label>
								<hr />
								<span>&nbsp;&nbsp;&nbsp;Rows</span><br /> <select
									name="fromRow" id="fromRow" class="seatSelectByInput"><option
										value="">Choose one</option></select> &nbsp;-&nbsp; <select
									class="seatSelectByInput" name="toRow" id="toRow"><option
										value="">Choose one</option></select>
								<div class="error" id="rowRangeErrorText"></div>
								<br />
								<span>&nbsp;&nbsp;&nbsp;Column</span><br /> <select
									name="fromColumn" class="seatSelectByInput" id="fromColumn"><option
										value="">Choose one</option></select> &nbsp;-&nbsp; <select
									class="seatSelectByInput" name="toColumn" id="toColumn"><option
										value="">Choose one</option></select>
								<div class="error" id="columnRangeErrorText"></div>
								<br />
							</div>
							<center>
								<button id="selectSeats" class="btn btn-default"
									onClick="selectSeats(this.value)">Select</button>
								&nbsp;
								<button id="resetSeats" class="btn btn-default"
									onClick="resetSeats(this.value)">Reset</button>
							</center>
						</aui:col>
						<aui:col>
							<div class="form-group">
								<br /> <label class="control-label font-color-blue">SEAT
									NUMBERING DIRECTION</label>
								<hr />
								<aui:select name="" id="searNoDirection" cssClass="form-control"
									placeholder="Choose direction..."
									onChange="changeSeatNoDirection(this);">
									<aui:option value="" hidden="true">
										Choose direction...
									</aui:option>
									<aui:option value="down">Down (Start from Left)</aui:option>
									<aui:option value="downsnake">Snake Down (Start from Left)</aui:option>
									<aui:option value="up">Up (Start from Left)</aui:option>
									<aui:option value="upsnake">Snake Up (Start from Left)</aui:option>
									<aui:option value="left">Left (Start from Top)</aui:option>
									<aui:option value="leftsnake">Snake Left (Start from Top)</aui:option>
									<aui:option value="right">Right (Start from Top)</aui:option>
									<aui:option value="rightsnake">Snake Right (Start from Top)</aui:option>
									<aui:option value="downright">Down (Start from Right)</aui:option>
									<aui:option value="downsnakeright">Snake Down (Start from Right)</aui:option>
									<aui:option value="upright">Up (Start from Right)</aui:option>
									<aui:option value="upsnakeright">Snake Up (Start from Right)</aui:option>
									<aui:option value="leftdown">Left (Start from Bottom)</aui:option>
									<aui:option value="leftsnakedown">Snake Left (Start from Bottom)</aui:option>
									<aui:option value="rightdown">Right (Start from Bottom)</aui:option>
									<aui:option value="rightsnakedown">Snake Right (Start from Bottom)</aui:option>
									<!--
									<aui:option value="down">Downward</aui:option>
									<aui:option value="downsnake">Downward Snake</aui:option>
									<aui:option value="up">Upward</aui:option>
									<aui:option value="upsnake">Upward Snake</aui:option>
									<aui:option value="left">Left</aui:option>
									<aui:option value="leftsnake">Left Snake</aui:option>
									<aui:option value="right">Right</aui:option>
									<aui:option value="rightsnake">Right Snake</aui:option>
									<aui:option value="downright">Downward</aui:option>
									<aui:option value="downsnakeright">Downward Snake</aui:option>
									<aui:option value="upright">Upward</aui:option>
									<aui:option value="upsnakeright">Upward Snake</aui:option>
									<aui:option value="leftdown">Left</aui:option>
									<aui:option value="leftsnakedown">Left Snake</aui:option>
									<aui:option value="rightdown">Right</aui:option>
									<aui:option value="rightsnakedown">Right Snake</aui:option> 
									 -->
								</aui:select>
							</div>
						</aui:col>
					</aui:row>
					<aui:row cssClass="seatingConfiguration" style="display:none;">
						<aui:col span="12">
						</aui:col>
						<aui:col span="12">
							<div class="form-group">
								<label class="control-label font-color-blue">SEATING
									CONFIGURATION</label>
								<hr />
							</div>
						</aui:col>
						<aui:col span="12" cssClass="addNewSubject" id="addNewSubject">
						</aui:col>
						<aui:col span="12">
							<aui:row>
								<aui:col span="12" cssClass="text-center">
									<aui:button cssClass="btn greenbtn" id="addNewSubject"
										value="Add Subject" onClick="addNewSubject()"></aui:button>
								</aui:col>
							</aui:row>
						</aui:col>
					</aui:row>
				</aui:col>
				<aui:col span="8">
					<div style="border-left: 5px solid #f7f9fc; margin-left: 20px;">
						<div class="panel-title-div" style="border-left: 5px solid #f7f9fc;">
							<div id="panelTitleNo" class="panel-title-no">2</div>
							<div id="panelTitleText" class="panel-title-text">CUSTOMISE SEATS</div>
							<div id="panelTitleTextRight" class="panel-title-text" style="float: right;">[UOL:2018]</div>
						</div>
						<div id="seatingSetup" class="seatingSetup"></div>
						<div
							style="font-size: 12px; display: flow-root; background-image: linear-gradient(#fff, #eee);">
							<div id="assignMarkerBottom" class="assignmarker-bottom"
								style="display: none;"></div>
							<div style="float: right; margin: 10px;">
								Total Capacity : <span id="totalCapicitySeats"
									style="color: #3fc6a8">100</span>&nbsp;&nbsp; Available : <span
									id="totalAvailableSeats" style="color: #3fc6a8">57</span>
							</div>
						</div>
					</div>
				</aui:col>
			</aui:row>
			<br />
		</div>

		<aui:row cssClass="userAction">
			<aui:col span="12">
					<button type="button" style="" class="btn btn-default" id="saveAsDraft"
						onClick="saveAsDraft()">Save Draft</button>
				
					<button type="button" class="btn btn-default" id="customiseLayout"
						onClick="goBack();"
						style="background: #0f349f !important; color: #ffffff !important;">Customise
						Layout</button>
					<button type="button" class="btn btn-default"
						id="customiseSeatsButton" onClick="gAction='backToCustomizeSeats';actionDialogue('backToCustomizeSeats');"
						style="display: none; background: #0f349f !important; color: #ffffff !important;">Customise
						Seats</button>
					<button type="button" style="display: none;" class="btn btn-default" id="saveAsDraftTemplate"
						onClick="saveAsDraftTemplate()">Save Draft</button>
				
					<button type="button" class="btn btn-default" id="generateSeatNo"
						onClick="gAction='submit';postSeatingPlanLayout('submit')"
						style="background: #0f349f !important; color: #ffffff !important;">Generate
						Seat Numbers</button>
					<button type="button" class="btn btn-default" id="generateSeatNoPublish"
						onClick="gAction='publish';postSeatingPlanLayout('publish')"
						style="display: none;background: #0f349f !important; color: #ffffff !important;">PUBLISH</button>
					<button type="button" class="btn btn-default" id="subjectSave" disabled="disabled"
						onClick="validateData('Active')"
						style="display: none; background: #0f349f !important; color: #ffffff !important;">Save</button>
				
					<button type="button" id="resetButton" style="" onclick="gAction='reset';actionDialogue('reset');"
						class="btn btn-default">Reset</button>
					<button id="cancelButtonTemplate" type="button" style="display: none;" onclick="gAction='cancel';actionDialogue('cancel');"
						class="btn btn-default">Cancel</button>
				
					<button id="cancelButton" type="button" style="" onclick="gAction='cancel';actionDialogue('cancel');"
						class="btn btn-default">Cancel</button>
				</aui:col>
		</aui:row>
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
						<button id="yesAlertButton" type="button"
							class="btn-primary popup-submit-action pull-left">Yes</button>
						<button id="noAlertButton" type="button"
							class="btn cancel lightbluebtn popup-cancel-action pull-right">No</button>
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
	
<div class="yui3-skin-sam success-action-dialog">
	<div id="sucess-popup" hidden="true" class="modalpopupBox">
		<div id="sucess-popup-box" class="modalpopupContent">
			<form class="formContainer" action="">
				<aui:row>
					<aui:col span="12">
						<h3 id="success-msg" style="line-height: 25px; padding-top: 12px">Seating plan created successfully !</h3>
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
</div>


<%
	}
%>

<script type="text/javascript">
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var mode = "view";
var homeUrl = "<%=homePage%>";
var customiseSeatsURL = "<%=customiseSeats%>";
var seatingLayoutSetupURL = "<%=seatingLayoutSetup%>";
var spliId = "<%=seatingPlanInstanceId%>";
var seatingPlanScreenId = "<%=seatingPlanScreenId%>";
var baseUrl = "<%=baseUrl%>";
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

var gAction = "";
loadAssignMarkers();
	showLoading(true);
	
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
				} else {
					//responseData = contentdata.content;
					data = data.content[0];
					if (data.hasOwnProperty("contentJson")) {
						SPInstance = data.contentJson;
						deskFormat = SPInstance.DeskNoFormat;
						seatingPlanInstance = SPInstance;
						seatingPlanInstanceChanges = SPInstance;
						SeatPlanStatus = data.seatPlanStatus;
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
						$("#totalAvailableSeats").html(0);
						if(SPInstance.hasOwnProperty("IsTemplate") && SPInstance.IsTemplate){
							$("#saveAsDraft").css("display", "none");
							$("#customiseLayout").css("display", "none");
							$("#resetButton").css("display", "none");
							$("#cancelButton").css("display", "none");
							$("#generateSeatNo").css("display", "none");
							$("#generateSeatNoPublish").css("display", "");
							$("#cancelButtonTemplate").css("display", "");
							$("#saveAsDraftTemplate").css("display", "");
							$("#panelTitleNo").css("display", "none");
							$("#panelTitleTextRight").css("display", "none");
							$("#panel-title-div").attr("align","center");
							$("#panel-title-div").css("border-left","0px");
							$("#panelTitleText").html("<span>Facility :</span><b>"+SPInstance.FacilityId+"</b>");
							$("#headerTitle").html("SEATING LAYOUT SETUP");
							//loadSPLayout(spliId);
							if(data.seatPlanStatus){
								$("#saveAsDraft").css("display", "none");
								$("#saveAsDraftTemplate").css("display", "none");
								
							}
						}
						else{
							loadSubjectsBySchedule(SPInstance.ScheduleId);
							$("#panelTitleTextRight").html(SPInstance.ScheduleId);
							//loadSPLayout(spliId);
							if(data.seatPlanStatus == "Active"){
								$("#saveAsDraft").css("display", "none");
								$("#saveAsDraftTemplate").css("display", "none");
								
							}
						}
						if((data.seatPlanStatus =="Active" || data.seatPlanStatus =="Draft") && seatingPlanInstance.hasOwnProperty("seatingPlanLayouts")){
							var SPLData = seatingPlanInstance.seatingPlanLayouts;
							var showSeatNo = false;
							for (var i=0; i < SPLData.length; i++) {
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
									showSeatNo = true;
								}
							}
							if (showSeatNo) {
								changeSeatNoDirection({
									value : snd
								});
								$("[id$='searNoDirection']").val(snd);
							}
						}
						else{
							seatingPlanInstance["seatingPlanLayouts"] = [];
						}
					}
				}
				showLoading(false);
			}, function() {
				displayMessage('danger',
						"Error in loading seating plan data.");
				showLoading(false);
			});
	function actionDialogue(action) {
		if(gAction == ""){
			return;
		}
		$("#noAlertButton").html("No");
		$("#yesAlertButton").html("Yes");
		var popupdiv = "#action-dialog";
		var popupdivbox = "#action-dialog-box";
		if (action == "backToCustomizeSeats") {
			document.getElementById("action_title").innerHTML = "Do you want move to previous step?";
			document.getElementById("action_msg").innerHTML = "You will lose all the data entered in this step. <br />Are you sure you want to continue?";

			$("#noAlertButton").html("CANCEL");
			$("#yesAlertButton").html("CONFIRM");
			// $("#action-dialog").addClass("modalpopupBoxWarning");
		} 
		else if (action == "reset") {
			document.getElementById("action_title").innerHTML = "Do you want to Reset?";
			// $("#action-dialog").addClass("modalpopupBoxWarning");
		} else if (action == "cancel") {
			document.getElementById("action_title").innerHTML = "Do you want to Cancel?";
			// $("#action-dialog").addClass("modalpopupBoxWarning");
		} else if (action == "submit") {
			document.getElementById("success-msg").innerHTML = "Seating plan created successfully!";
			document.getElementById("backToMainScreen").href = homeUrl;
			popupdiv = "#sucess-popup";
			popupdivbox = "#sucess-popup-box";
		} else if (action == "publish") {
			document.getElementById("success-msg").innerHTML = "Seating layout template created successfully!";
			document.getElementById("backToMainScreen").href = baseUrl;
			popupdiv = "#sucess-popup";
			popupdivbox = "#sucess-popup-box";
		} else if (action == "draftTemplate") {
			document.getElementById("success-msg").innerHTML = "Seating layout template  saved as draft!";
			document.getElementById("backToMainScreen").href = baseUrl;
			popupdiv = "#sucess-popup";
			popupdivbox = "#sucess-popup-box";
		
		} else if (action == "draft") {
			document.getElementById("success-msg").innerHTML = "Seating plan saved as draft!";
			document.getElementById("backToMainScreen").href = homeUrl;
			popupdiv = "#sucess-popup";
			popupdivbox = "#sucess-popup-box";
		}
		AUI().use('aui-base',
			function(A) {
				A.one(popupdiv).set('hidden', false);
				YUI()
				.use('aui-modal',
				function(Y) {
					var modal = new Y.Modal({
					boundingBox : popupdiv,
					contentBox : popupdivbox,
					headerContent : '',
					centered : true,
					destroyOnHide : false,
					modal : true,
					resizable : false,
					draggable : true,
				}).render();
					
				Y.one('.close').on('click',
				function() {
					modal.hide();
					modal = null;
				});
				
				Y.one('.popup-cancel-action').on('click',
				function() {
					console.log("popup-cancel-action...");
					modal.hide();
					modal = null;
				});
				Y.one('.popup-submit-action').on('click',
					function() {
					console.log("popup-submit-action...");
					modal.hide();
					modal = null;
					if (action == "backToCustomizeSeats"){
						backToCustomizeSeats();
					}
					else if (action == "reset") {
						window.location = customiseSeatsURL + "&SeatingPlanInstanceId=" + spliId + "&ScreenId=" + seatingPlanScreenId;
					} else if (action == "cancel") {
						if (SPInstance.hasOwnProperty("IsTemplate") && SPInstance.IsTemplate) {
							window.location = baseUrl;
						} else {
							window.location = homeUrl;
						}
					} else if (action == "submit") {
						window.location = homeUrl;
					} else if (action == "publish") {
						window.location = baseUrl;
					} else if (action == "draft") {
						if (SPInstance.hasOwnProperty("IsTemplate")&& SPInstance.IsTemplate) {
							window.location = baseUrl;
						} else {
							window.location = homeUrl;
						}
					}
				});
				
			});
		});
	}
	
</script>