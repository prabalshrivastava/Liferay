<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="com.sambaash.platform.srv.spservices.model.SPListType"%>
<%@page import="com.fasterxml.jackson.databind.SerializationFeature"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.sambaash.platform.attendance.service.SPAttendenceLocalServiceUtil"%>
<%@page
	import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil"%>
<%@page
	import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalService"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="/tld/sp-formio" prefix="sp-formio"%>

<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/portlet.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/main.css?minifierType=css'></link>
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>
<%-- <link rel='stylesheet' type="text/scss" href='<%=request.getContextPath()%>/css/custom.scss?minifierType=css'></link> --%>

<portlet:defineObjects />
<%
	String formStorageId = request.getParameter("storageId");
    String filterData = request.getParameter("filterData");
	String baseUrl = portletPreferences.getValue("baseUrlPref", "");
	ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	Long groupId = td.getLayout().getGroupId();
	String dashboardLink = SambaashUtil.getParameter("dashboard.link", groupId);
	String vocabularyURL = SambaashUtil.getParameter(SambaashConstants.API_VOCABULARY_URL, groupId);
	String dashBoardLink = SambaashUtil.getDashBoard();
	boolean notEligible = false;
	String modelName = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME, SystemSetupConstants.DEFAULTMODELAME);
	Map<String, String> claimTypes = SPAttendenceLocalServiceUtil.getSpListTypeMap("finance.payment.claimType", request);
	ObjectMapper objectMapper = new ObjectMapper();
	objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
%>
<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>

<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center">
						<h2>
							<h2>CUSTOM TIME RECORDING</h2>
						</h2>
					</aui:col>
					<aui:col span="2" cssClass="text-right">
						<a href="<%=dashBoardLink%>" title="Back to Dashboard">Back to
							Home</a>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>

	<div class="financeParameterSetup">
		<div class="formContainer container formio-form">
			<form class="aui" id="financeParameter_form1"
				name="financeParameter_form" action="">

				<div class="alert alert-success alert-dismissible" id="saveSuccess" style="display:none">
					<strong>Success!</strong> Attendance captured successfully
				</div>
				<div class="alert alert-danger" id="saveError" style="display:none">
					<strong>Error!</strong> Time Out should be greater then Time In.
				</div>

				<aui:input name="" type="hidden" id="parameterSetupCode" />
				<!-- <p id="status" class="formStatus"/> -->
				<aui:row>
					<aui:col span="12" cssClass="control-label" style="display: flex;">
						<%-- <aui:input name="notEligible" label="Not eligible for Payment" type="checkbox" value="<%= notEligible %>" 
						cssClass="form-control"></aui:input> --%>
						<%
							if(modelName.equalsIgnoreCase("invigilatorAttendance")){
						%>
						<label cssClass="control-label">Not eligible for Payment</label>
						<input type="checkbox" id="isEligible" name="isEligible"
							value="<%=notEligible%>" onchange="isEligibleForPayment()"
							style="margin: 1px 0px 0px 10px;">
						<%
							}
						%>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12" cssClass="">
						<div style="display: none;" class="alert alert-danger"
							role="showAlert" id="alert_msg">Enter Time In</div>
						<aui:row>
							<aui:col span="6" cssClass="choices formio-choices">
								<div class="form-group">
									<label cssClass="control-label">Time In</label>
									<aui:row>
										<aui:col span="5" cssClass="choices formio-choices">
											<aui:input type="number" name="" id="timeInHH" min="0"
												onblur="validateHour(this,'in')" cssClass="form-control"
												onkeydown="javascript: return event.keyCode === 8 || event.keyCode === 46 ? true : !isNaN(Number(event.key))"
												placeholder="hh">
												<aui:validator name="max">24</aui:validator>
											</aui:input>
											<p id="timeInHHErr" style="color: red"></p>
										</aui:col>
										<aui:col span="1" cssClass="choices formio-choices"> : </aui:col>
										<aui:col span="5" cssClass="choices formio-choices">
											<aui:input type="number" name="" id="timeInMM" min="0"
												onblur="validatemin(this,'in')" cssClass="form-control"
												onkeydown="javascript: return event.keyCode === 8 || event.keyCode === 46 ? true : !isNaN(Number(event.key))"
												placeholder="mm">
												<aui:validator name="max">60</aui:validator>
											</aui:input>
											<p id="timeInMMErr" style="color: red"></p>
										</aui:col>
									</aui:row>
								</div>
							</aui:col>
							<aui:col span="6" cssClass="choices formio-choices">
								<div class="form-group">
									<label cssClass="control-label">Time Out</label>
									<aui:row>
										<aui:col span="5" cssClass="choices formio-choices">
											<aui:input type="number" name="" id="timeOutHH" min="0"
												onblur="validateHour(this,'out')" cssClass="form-control"
												onkeydown="javascript: return event.keyCode === 8 || event.keyCode === 46 ? true : !isNaN(Number(event.key))"
												placeholder="hh">
												<aui:validator name="max">24</aui:validator>
											</aui:input>
											<p id="timeOutHHErr" style="color: red"></p>
										</aui:col>
										<aui:col span="1" cssClass="choices formio-choices"> : </aui:col>
										<aui:col span="5" cssClass="choices formio-choices">
											<aui:input type="number" name="" id="timeOutMM" min="0"
												onblur="validatemin(this,'out')" cssClass="form-control"
												onkeydown="javascript: return event.keyCode === 8 || event.keyCode === 46 ? true : !isNaN(Number(event.key))"
												placeholder="mm">
												<aui:validator name="max">60</aui:validator>
											</aui:input>
											<p id="timeOutMMErr" style="color: red"></p>
										</aui:col>
									</aui:row>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Remarks</label>
									<textarea class="field form-control" id="remarks" name=""
										placeholder="Any remarks?" rows="5"
										style="resize: none; height: 100px;"></textarea>
								</div>
							</aui:col>
						</aui:row>
					</aui:col>
				</aui:row>


			</form>
			<aui:row cssClass="userAction">
				<aui:col span="6" cssClass="text-right">
				<button type="button" id="updateButton"
						onclick="validateFields('<%=formStorageId%>' , '<%=filterData%>');"
						class="btn btn-primary update" style="display:none">UPDATE</button>
						
					<button type="button" id="saveButton"
						onclick="validateFields('<%=formStorageId%>' , '<%=filterData%>');"
						class="btn btn-primary" style="display:none">SAVE</button>
				</aui:col>
				<%-- 				<aui:col span="1" cssClass="text-right"></aui:col> --%>
				<aui:col span="5" cssClass="text-left">
					<button type="button" id="cancelButton" onclick="goBack();" class="btn btn-default"  style="display:none">CANCEL</button>
				</aui:col>
			</aui:row>
		</div>
	</div>


	<div id="sucess-popup" hidden="true" class="modalpopupBox">
		<div id="sucess-popup-box" class="modalpopupContent">
			<form class="formContainer" action="">
				<aui:row>
					<aui:col span="12">
						<h3 id="success-msg">Attendance Recorded</h3>
					</aui:col>

				</aui:row>
				<aui:row>
					<aui:col span="12">
						<button type="button"
							class="btn btn-default popup-confirm-archive pull-left"
							onClick="reloadPage()">Start Again</button>
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
</div>

<script type="text/javascript">
debugger;
document.getElementById("loadingDiv").style.display = "inline";
document.getElementById("updateButton").style.display = "none";
document.getElementById("cancelButton").style.display = "none";
document.getElementById("saveButton").style.display = "none";
document.getElementById("saveSuccess").style.display = 'none';
document.getElementById("saveError").style.display = 'none';

var claimTypes = <%=objectMapper.writeValueAsString(claimTypes)%>;
var namespace =  "<portlet:namespace/>";
var modelName= "<%=modelName%>";
var ajaxUrl = "${resourceURL}";
var vocabularyURL = "<%=vocabularyURL%>";
var mode = "view";
var baseUrl = "<%=baseUrl%>";
var isEligible =  "<%=notEligible%>";
var formStorageId = "<%=formStorageId%>";
var filterData = "<%=filterData%>";
	var inHhErr = false;
	var outHhErr = false;
	var inMMErr = false;
	var outMMErr = false;

	function validateHour(inputField, inOut) {
		debugger;
		if (inOut == "in") {
			document.getElementById("timeInHHErr").innerHTML = "";
			inHhErr = false;
		} else {
			document.getElementById("timeOutHHErr").innerHTML = "";
			outHhErr = false;
		}
		var isValid = inputField.value;
		if (isValid == "" && inOut == "in") {
			document.getElementById("timeInHHErr").innerHTML = "Invalid hour";
			inHhErr = true;
		} else if (isValid > 24 || isValid < 0) {
			inputField.style.borderColor = 'red';
			if (inOut == "in") {
				document.getElementById("timeInHHErr").innerHTML = "Invalid hour";
				inHhErr = true;
			} else {
				document.getElementById("timeOutHHErr").innerHTML = "Invalid hour";
				outHhErr = true;
			}
			document.getElementById("saveButton").disabled = true;
			document.getElementById("updateButton").disabled = true;

			return false;
		} else {
			inputField.style.borderColor = '#b1bed7';
		}
		if (inHhErr || outHhErr || inMMErr || outMMErr) {
			document.getElementById("saveButton").disabled = true;
			document.getElementById("updateButton").disabled = true;

		} else {
			document.getElementById("saveButton").disabled = false;
			document.getElementById("updateButton").disabled = false;
		}
	}

	function validatemin(inputField, inOut) {
		if (inOut == "in") {
			document.getElementById("timeInMMErr").innerHTML = "";
			inMMErr = false;
		} else {
			document.getElementById("timeOutMMErr").innerHTML = "";
			outMMErr = false;
		}
		debugger;
		var isValid = inputField.value;
		if (isValid == "" && inOut == "in") {
			document.getElementById("timeInMMErr").innerHTML = "Invalid minute";
			inMMErr = true;
		} else if (isValid > 60 || isValid < 0) {
			inputField.style.borderColor = 'red';
			document.getElementById("saveButton").disabled = true;
			document.getElementById("updateButton").disabled = true;
			if (inOut == "in") {
				document.getElementById("timeInMMErr").innerHTML = "Invalid minute";
				inMMErr = true;
			} else {
				if (isValid != "") {
					document.getElementById("timeOutMMErr").innerHTML = "Invalid minute";
					outMMErr = true;
				}
			}
			return false;
		} else {
			inputField.style.borderColor = '#b1bed7';
		}
		if (inHhErr || outHhErr || inMMErr || outMMErr) {
			document.getElementById("saveButton").disabled = true;
			document.getElementById("updateButton").disabled = true;
		} else {
			document.getElementById("saveButton").disabled = false;
			document.getElementById("updateButton").disabled = false;
		}
	}
	if(formStorageId == "null"){
		document.getElementById("cancelButton").style.display = "inline";
		document.getElementById("saveButton").style.display = "inline";
	}else{
	ajaxCallAPI(
			'GET',
			'fetchById',
			formStorageId,
			function() {
				debugger;
				

				var data = this.get("responseData");
				if (data != null) {
					if(document.getElementById("isEligible")){
					document.getElementById("isEligible").checked = (data.contentJson.IsPaymentEligible) ? false
							: true;}
					if (data.timeIn != null) {
						var timeIn = data.timeIn;
						var inTime = timeIn.split(":");
						document.getElementById(namespace + "timeInHH").value = inTime[0];
						document.getElementById(namespace + "timeInMM").value = inTime[1];
						document.getElementById(namespace + "timeInHH").disabled = document
								.getElementById(namespace + "timeInHH").value ? true
								: false;

						document.getElementById(namespace + "timeInMM").disabled = document
								.getElementById(namespace + "timeInMM").value ? true
								: false;
					}

					if (data.timeOut) {
						var timeOut = data.timeOut;
						var outTime = timeOut.split(":");
						document.getElementById(namespace + "timeOutHH").value = outTime[0];
						document.getElementById(namespace + "timeOutMM").value = outTime[1];

						document.getElementById(namespace + "timeOutHH").disabled = document
								.getElementById(namespace + "timeOutHH").value ? true
								: false;

						document.getElementById(namespace + "timeOutMM").disabled = document
								.getElementById(namespace + "timeOutMM").value ? true
								: false;
					}
					document.getElementById("remarks").value = data.remark
					if (data.error) {
						displayMessage('danger', data.error, 3000);
					}
					timeInHH=document.getElementById(namespace + "timeInHH").value;
					timeInMM=document.getElementById(namespace + "timeInMM").value;
					timeOutHH=document.getElementById(namespace + "timeOutHH").value;
					timeOutMM=document.getElementById(namespace + "timeOutMM").value;
					var remarks=document.getElementById("remarks").value;
					if(timeInHH !="" && timeInMM != "" && timeOutHH != "" && timeOutMM != ""){
						document.getElementById("remarks").disabled = true;
						document.getElementById("saveButton").style.display = 'inline';
						document.getElementById("cancelButton").style.display = 'inline';
						document.getElementById("saveButton").disabled = true;
					}else if(timeInHH =="" && timeInMM == "" && timeOutHH == "" && timeOutMM == "" && remarks == ""){
						document.getElementById("saveButton").style.display = 'inline';
						document.getElementById("cancelButton").style.display = 'inline';
					}else{
						document.getElementById("updateButton").style.display = 'inline';
						document.getElementById("cancelButton").style.display = 'inline';
					}
					document.getElementById("loadingDiv").style.display = "none";
				}
			}, function() {
			});
	}
</script>