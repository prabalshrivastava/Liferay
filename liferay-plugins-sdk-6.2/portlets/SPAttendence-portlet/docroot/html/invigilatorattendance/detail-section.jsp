<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="com.sambaash.platform.srv.spservices.model.SPListType"%>
<%@page import="com.fasterxml.jackson.databind.SerializationFeature"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page
	import="com.sambaash.platform.attendance.service.SPAttendenceLocalServiceUtil"%>
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

<%
	String formStorageId = request.getParameter("storageId");
    String filterData = request.getParameter("filterData");
	String dashBoardLink = SambaashUtil.getDashBoard();
	boolean notEligible = false;
	Map<String, String> claimTypes = SPAttendenceLocalServiceUtil.getSpListTypeMap("finance.payment.claimType", request);
	ObjectMapper objectMapper = new ObjectMapper();
	objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
%>
	
<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>

<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/payment.css?minifierType=css'></link>
<div class="slider" id="slider"">
	<div class="newPortlets">
		<div class="financeParameterSetup">
			<div>
				<div class="container head">
					<div style="text-align: right; width: 10%; float: right"></div>
					<div class="inner-container">

						<aui:row>
							<aui:col span="10" cssClass="text-center">
								<h2>
									<h3>CUSTOM TIME RECORDING</h3>
								</h2>
							</aui:col>
						</aui:row>
					</div>
				</div>
			</div>
			<div class="formContainer container formio-form">
				<form class="aui" id="financeParameter_form1"
					name="financeParameter_form" action="">

					<div class="alert alert-success alert-dismissible" id="saveSuccess"
						style="display: none">
						<strong>Success!</strong> Attendance captured successfully
					</div>
					<div class="alert alert-danger" id="saveError"
						style="display: none">
						<strong>Error!</strong> Time Out should be greater then Time In.
					</div>

					<aui:input name="" type="hidden" id="parameterSetupCode" />

					<!-- <p id="status" class="formStatus"/> -->
					<aui:row style="display:none" id="eligibility">
						<aui:col span="12" cssClass="control-label" style="display: flex;">
							<label cssClass="control-label" class="eligible">Not eligible for Payment</label>
							<input type="checkbox" id="isEligible" name="isEligible"
								value="<%=notEligible%>" onchange="isEligibleForPayment()"
								style="margin: 1px 0px 0px 10px;">

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
							onclick="validateFields(storageId , filterData);"
							class="btn btn-primary update" style="display: none">UPDATE</button>

						<button type="button" id="saveButton"
							onclick="validateFields(storageId, filterData);"
							class="btn btn-primary" style="display: none">SAVE</button>
					</aui:col>
					
					<aui:col span="5" cssClass="text-left">
						<button type="button" id="cancelButton" onclick="closeSlider();"
							class="btn btn-default" style="display: none">CANCEL</button>
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
</div>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/detail-section.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>

<script type="text/javascript">
debugger;
document.getElementById("loadingDiv").style.display = "inline";
document.getElementById("updateButton").style.display = "none";
document.getElementById("cancelButton").style.display = "none";
document.getElementById("saveButton").style.display = "none";
document.getElementById("saveSuccess").style.display = 'none';
document.getElementById("saveError").style.display = 'none';
var savedSuccessfully = false;
var filterData = {};
var claimTypes = <%=objectMapper.writeValueAsString(claimTypes)%>;
var namespace =  "<portlet:namespace/>";
var modelName= "" ; 
var ajaxUrl = "${resourceURL}";
var mode = "view";
var isEligible =  "<%=notEligible%>";
var storageId = "";
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
</script>