<%@ include file="/html/init.jsp" %>

<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>
<portlet:renderURL var="homePage">
  <portlet:param name="jspPage" value="/html/seatingplan/view.jsp" />
</portlet:renderURL>
<portlet:renderURL var="createSettingTemplateUrl">
  <portlet:param name="jspPage" value="/html/seatingplan/customiseSeats.jsp" />
</portlet:renderURL>


<%
String baseUrl = portletPreferences.getValue("baseUrlPref", "");
/* String formStorageId = request.getParameter("storageId"); */
String scheduleCode = request.getParameter("scheduleCode");
String facilityCode = request.getParameter("facilityCode");
String subFacilityCode = request.getParameter("subFacilityCode");

String scheduleId = request.getParameter("scheduleId");
String facilityId = request.getParameter("facilityId");
String subFacilityId = request.getParameter("subFacilityId");
%>

<div class="newPortlets">
	<%
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
					<h2>SEATING PLAN</h2>
				</aui:col>
				<aui:col span="2" cssClass="text-right">
					<aui:a href="<%=homePage%>" title="Back to Dashboard">Back to Home</aui:a>
				</aui:col>
			</aui:row>
		</div>
	</div>
	
	
	<div class="seatingLayoutSetup">
	
	
				<aui:row>
					<aui:col span="12"> 
					
					<div  class="alert alert-warning"
							role="showAlert" id="alert_msg"><i class="fa fa-exclamation-circle warningReset"></i>&nbsp;&nbsp;Please note that modifying into here,will reset the Markers to its default state,in the 'Customise Seats' section</div>
						
					</aui:col>
				</aui:row>
			<aui:row>
					<aui:col span="12"> 
					
						<div class="panelTitle">
							<div class="panel-title-no">1</div>
							<div class="panel-title-text">CUSTOMISE LAYOUT</div>
							<div class="panel-title-text" style="float: right;"><%=scheduleCode %></div>
						</div>
					</aui:col>
				</aui:row> 
		
		<form class="aui" id="seatLayout_form"
				name="seatLayout_form" action="">
		<div class="formContainer container formio-form">

				<%-- <aui:input name="" type="hidden" id="seatingPlanInstanceCode" />
				<aui:input name="" type="hidden" id="facilityCode" />
				<aui:input name="" type="hidden" id="subFacilityCode" />--%>
				<aui:input name="" type="hidden" id="seatingPlanCode" /> 
				<aui:input name="" type="hidden" id="formStorageId" />
				
				<aui:row>
					<aui:col span="10" cssClass="offset1">
						<div style="display: none;" class="alert alert-danger"
							role="showAlert" id="alert_msg">Select Facility Type.</div>
						
						<aui:row>
							<aui:col span="6" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Total No of Seats/Row</label>
									
									<aui:input type="text" name="" id="noOfSeatsPerRow" onkeyup="calculateTotalSeats();"
										cssClass="form-control">
									</aui:input>
								</div>
							</aui:col>
							<aui:col span="6" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Total No of Rows</label>
									<aui:input type="text" name="" id="noOfRows" onkeyup="calculateTotalSeats();"
										cssClass="form-control">
									</aui:input>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="6" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Desk Number Prefix</label>
									<aui:input type="text" name="" id="deakNoFormat" 
										cssClass="form-control" >
									</aui:input>
								</div>
							</aui:col>
							<aui:col span="6" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Total no of available seats</label>
									<aui:input type="text" name="" id="noOfSeatsAvailable" disabled="true"
										cssClass="form-control" >
									</aui:input>
								</div>
							</aui:col>
						</aui:row>
						
					</aui:col>
				</aui:row>
					</div>	
						<aui:row cssClass="userAction">
								<aui:col span="12">
									<button type="button" class="btn btn-default" id="draft"
										onClick="validateFields('draft')">Save Draft</button>
								&nbsp;&nbsp;
									<button type="button" class="btn btn-default" id="publish" style="background: #0f349f!important;color : #eff4fb!important"
										onClick="validateFields('publish')">Customise Seats</button>
								&nbsp;&nbsp;
									<button type="button" onclick="resetDefault();"
										class="btn btn-default">Reset</button>
								&nbsp;&nbsp;
									<button type="button" onclick="goBack();"
										class="btn btn-default">Cancel</button>
								</aui:col>
						</aui:row>
			</form>
	</div>
</div>

<div id="sucess-popup" hidden="true" class="modalpopupBox">
		<div id="sucess-popup-box" class="modalpopupContent">
			<form class="formContainer" action="">
				<aui:row>
					<aui:col span="12">
						<h3 id="success-msg">Seating Layout Created</h3>
					</aui:col>

				</aui:row>
				<aui:row>
					<aui:col span="8">
						<button type="button"
							class="btn cancel btn-primary popup-cancel pull-right"
							onClick="moveToList()">Go Back</button>
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
<%
	}
%>

<script type="text/javascript">
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var mode = "view";
var homeUrl = "<%=homePage%>";
var baseUrl = "<%=baseUrl%>";
var createSettingTemplateUrl = "<%=createSettingTemplateUrl%>";

var scheduleCode = "<%=scheduleCode%>";
var facilityCode ="<%=facilityCode%>";
var subFacilityCode = "<%=subFacilityCode%>";
var scheduleId = "<%=scheduleId%>";
var facilityId ="<%=facilityId%>";
var subFacilityId = "<%=subFacilityId%>";

</script>

<script type="text/javascript">
	function createSettingTemplate(instanceId){
		location.href = createSettingTemplateUrl + "&SeatingPlanInstanceId=" + instanceId;
	}

</script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/seatingPlan.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>