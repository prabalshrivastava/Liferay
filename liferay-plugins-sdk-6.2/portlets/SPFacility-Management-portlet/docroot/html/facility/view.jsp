<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/facility.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>
<link rel='stylesheet'
	href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<%@
   taglib uri="/tld/sp-formio" prefix="sp-formio"%>
<portlet:defineObjects />
<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>
<%
	String formStorageId = request.getParameter("storageId");
	String dashBoardLink = SambaashUtil.getDashBoard();
%>
<portlet:defineObjects />
<%
	String baseUrl = portletPreferences.getValue("baseUrlPref", "");
	String vocabularyURL = SambaashUtil.getParameter(SambaashConstants.API_VOCABULARY_URL, 21424);
%>

<portlet:renderURL var="successFacility">
	<portlet:param name="jspPage" value="/html/facility/success.jsp" />
</portlet:renderURL>

<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
			<aui:row>
				<aui:col span="10" cssClass="text-center">
					<h2><span>FACILITY SETUP</span></h2>
				</aui:col>
				<aui:col span="2" cssClass="text-right">
					<a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</a>
				</aui:col>
			</aui:row>
			</div>
		</div>
	</div>

	<div style="display: none;"
		class="showAlert showAlert-danger alert-danger" role="showAlert"
		id="alert_msg">
		<p id="error_msg">Please fix the following errors before
			submitting.</p>
	</div>

	<div class="sheduleSetup">
		<div class="formRoot">
		<div class="innerFormRoot">
		<div id="formio" class="formContainer container null formio-form">
          <form class="facilityform" id="facilityform">
			<div class="formSection">
				<div style="visibility: visible; position: relative; float: right;">
					<p id="formStatus" class="formStatus">Draft</p>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group choices formio-choices has-error">
									<label class="control-label">Facility type <span
											class="star">*</span></label> <select
										class="form-control facilityType"
										onchange="loadFacilityCategory()" id="facilityType">
										<!-- <option></option> -->
									</select>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group formio-component-textfield has-error">
									<label class="control-label">Facility Code <span
											class="star">*</span></label> <input
										type="text" maxlength="20" class="form-control facilityCode"
										id="facilityCode" placeholder="Enter Facility Code" disabled onChange="validatevalue();">
										<div class="formio-errors invalid-feedback hide">
												<p class="help-block">Facility Code is required</p>
											</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group choices formio-choices has-error">
									<label class="control-label">Facility Category<span
											class="star">*</span></label> <select
										class="form-control facilityCategory" id="facilityCategory">
									</select>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group formio-component-textfield has-error">
									<label class="control-label">Facility Name <span
											class="star">*</span></label> <input
										type="text" maxlength="50" class="form-control facilityName"
										id="facilityName" placeholder="Enter a name for the facility" onChange="validatevalue();">
										<div class="formio-errors invalid-feedback hide" >
												<p class="help-block">Facility Name is required</p>
											</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<div class="form-group formio-component-textarea">
									<label class="control-label">Address</label>
									<textarea maxlength="100" rows="" cols=""
										class="form-control facilityAddress" id="facilityAddress"
										placeholder="Enter the address"></textarea>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group formio-component-textfield">
										<label class="control-label">Upload Location Map</label>
										<input type="hidden" class="templateChanged">
										<div class="addFiles">
											<label for="file" class="template FSLocationMapName">No file selected</label>
											<input type="file" id="facilityLocationMap"
												accept="application/pdf" name="templateFile"
												onchange="fileChange(this); this.value=null; return false;"
												class="form-control facilityLocationMap"> 
												<span class="btn btn-default">ADD FILES</span>
												
											
										</div>
									</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group formio-component-textfield has-error">
									<label class="control-label">Location Map URL <span
											class="star">*</span></label> <input
										maxlength="100" type="text"
										class="form-control facilityLocation" id="facilityLocation"
										placeholder="Enter location map url" onChange="validatevalue();">
										<div class="formio-errors invalid-feedback hide" >
											<p class="help-block">Loaction Map Url is required</p>
										</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<div class="form-group formio-component-textfield">
									<label class="control-label">Contact Person</label> <input
										type="text" maxlength="100"
										class="form-control facilityContactPerson"
										id="facilityContactPerson"
										placeholder="Enter the person's name" onChange="validatevalue();">
										<div class="formio-errors invalid-feedback hide">
											<p class="help-block">Contact Person is required</p>
										</div>
								</div>
							</div>
							<!-- <div class="col-sm-6">
								<div class="form-group formio-component-textfield">
									<label class="control-label">Seating Capacity</label> <input
										type="number" oninput="maxLengthCheck(this)" maxlength="12"
										class="form-control facilitySeating" id="facilitySeating"
										placeholder="Enter the total capacity">
								</div>
							</div> -->
						</div>
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group formio-component-textfield">
									<label class="control-label">Contact Email Address</label> <input
										type="text" maxlength="100"
										class="form-control facilityContactEmail"
										id="facilityContactEmail"
										placeholder="Enter the email address" onChange="validatevalue();">
										<div class="formio-errors invalid-feedback hide">
											<p class="help-block">Contact Email is required</p>
										</div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group formio-component-textfield">
									<label class="control-label">Contact number</label> <input
										type="number" maxlength="20"
										class="form-control facilityContactNumber"
										id="facilityContactNumber"
										placeholder="Enter the contact number" onChange="validatevalue();">
										<div class="formio-errors invalid-feedback hide">
											<p class="help-block">Contact number is required</p>
										</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<div class="form-group formio-component-textarea">
									<label class="control-label">Equipment</label>
									<textarea rows="" maxlength="1000" cols=""
										class="form-control facilityEquipment" id="facilityEquipment"
										placeholder="List of all equipment available"></textarea>
								</div>
							</div>

						</div>
						<div class="row">
							<div class="col-sm-12">
								<div class="form-group formio-component-textarea">
									<label class="control-label">Remarks</label>
									<textarea rows="" maxlength="1000" cols=""
										class="form-control facilityRemarks" id="facilityRemarks"
										placeholder="Enter remarks"></textarea>
								</div>
							</div>
						</div>


						<div class="yui3-skin-sam">
							<div id="deactive-record" hidden="true" class="modalpopupBox">
								<div id="deactive-record-box" class="modalpopupContent">
									<form class="formContainer" action="">
										<aui:row>
											<aui:col span="12">
												<h3>Deactivate this record?</h3>
												<p id="deactivate_msg">Please provide your reasons for
													deactivating this record</p>
												<textarea cols="" rows="" id="deactivate_reason"></textarea>
											</aui:col>
										</aui:row>
										<aui:row>
											<aui:col span="12" class="userAction">
												<button type="button"
													class="btn btn-default popup-confirm-deactivate pull-left"
													onclick="confirm();">Confirm</button>
												<button type="button"
													class="btn btn-primary popup-cancel-deactivate pull-right close1"
													onclick="cancelbtn();">Cancel</button>
											</aui:col>
										</aui:row>
									</form>

								</div>
							</div>
						</div>

						<div class="yui3-skin-sam">
							<div id="sucess-popup" hidden="true" class="modalpopupBox">
								<div id="sucess-popup-box" class="modalpopupContent">
									<form class="formContainer">
										<aui:row>
											<aui:col span="12">
												<h3 id="success-msg">Facility Updated!</h3>
											</aui:col>

										</aui:row>
										<aui:row>
											<aui:col span="12" cssClass="userAction">
												<button
													class="btn btn-default popup-confirm-archive pull-left"
													type="button" onClick="reloadPage()">Start Again</button>
												<button
													class="btn cancel btn-primary popup-cancel pull-right" type="button" onClick="goBack()">Go Back</button>
											</aui:col>
										</aui:row>

									</form>
								</div>
							</div>
						</div>
						<div class="yui3-skin-sam">
						
							<div id="remove-popup" hidden="true" class="modalpopupBox">
								<div id="remove-popup-box" class="modalpopupContent">
									<form class="formContainer">
										<aui:row>
											<aui:col span="12">
												<h3 id="success-msg">Can't Remove this Sub-Facility</h3>
											</aui:col>

										</aui:row>
										<aui:row>
											<aui:col span="12" cssClass="userAction">
												<button class="btn btn-primary popup-confirm-archive close1"
													type="button" >Close</button>
											</aui:col>
										</aui:row>

									</form>
								</div>
							</div>
						</div>

						<!--   activation success message -->
						<div class="yui3-skin-sam">
							<div id="activation-success" hidden="true" class="modalpopupBox">
								<div id="active-success-box" class="modalpopupContent">

									<aui:row>
										<aui:col span="12">
											<h3>Activation successful!</h3>
										</aui:col>
									</aui:row>
									<aui:row>
										<aui:col span="12" cssClass="userAction">
											<button type="button"
												class="btn btn-primary cancel popup-cancel-blacklist"
												onclick="backtolist();">BACK TO LISTING</button>
										</aui:col>
									</aui:row>

								</div>
							</div>
						</div>

						<div class="yui3-skin-sam">
							<div id="deactivation-success" hidden="true"
								class="modalpopupBox">
								<div id="inactive-success-box" class="modalpopupContent">

									<aui:row>
										<aui:col span="12">
											<h3>De-activation successful!</h3>
											<p>This record will not be in use anymore</p>
										</aui:col>
									</aui:row>
									<aui:row>
										<aui:col span="12" cssClass="userAction">
											<!-- <button class="btn btn-primary popup-reactivate">Re-active</button> -->
											<button class="btn btn-primary cancel popup-reactivate"
												type="button" onClick="reloadPage()">Start Again</button>
											<button
												class="btn cancel btn-primary popup-cancel pull-right"
												type="button" onClick="moveToDashboard()">DashBoard</button>
										</aui:col>
									</aui:row>

								</div>
							</div>
						</div>
						<!--  end -->


						<div class="row">
							<div id="myToggler" class="col-sm-12">
								<div class="subFacilityHolder" id="subFacilityHolder">
									<div
										class="addSubFacility  con tent toggler-co ntent-collapsed subFacilityBase facilityContainer">

										<h4 class="header">
											<div style="display: inline-block;">01- Sub Facility</div>
											
											<ul class="nav">
														<li><a href="javascript:void(0);"
															class="btn removeBtn removeSubFacility" onclick="RemoveSubFecility(this)">Remove</a></li>
														<!-- <li><a href="javascript:void(0);" class="saveIcon"
															onclick="CopySubSchedule(this)">Save</a></li> -->
														<li><a href="javascript:void(0);" class="expandCollapse minusIcon" onClick="collapsOrExpand(this)"></a></li>
												</ul>
										</h4>
										<div class="toggleContent conte nt togg ler-content-collapsed subSheduleContent">
											<div class="row">
												<div class="col-sm-6">
													<div class="form-group formio-component-textfield">
														<label class="control-label">Sub-Facility Code</label> <input
															type="text" maxlength="20"
															class="form-control subFacilityCode" id="subFacilityCode"
															placeholder="Enter Sub Facility Code">
													</div>
												</div>
												<div class="col-sm-6">
													<div class="form-group formio-component-textfield">
														<label class="control-label">Sub-Facility Name</label> <input
															type="text" maxlength="50"
															class="form-control subFacilityName" id="subFacilityName"
															placeholder="Enter Sub Facility Name">
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-sm-6">
													<div class="form-group formio-component-textfield">
														<label class="control-label">Sub-Facility Floor /
															Unit No</label> <input type="text" maxlength="20"
															class="form-control subFacilityUnit" id="subFacilityUnit"
															placeholder="Enter Sub-Facility Floor / Unit No">
													</div>
												</div>
												<div class="col-sm-6">
													<div class="form-group formio-component-textfield">
														<label class="control-label">Seating Capacity</label> <input
															type="number" oninput="maxLengthCheck(this)"
															maxlength="12" class="form-control subFacilityCapacity"
															id="subFacilityCapacity"
															placeholder="Enter Seating Capacity">
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-sm-6">
														<div class="form-group formio-component-textfield">
															<label class="control-label">Upload Sub-Facility
																Floor Plan</label>
															<input type="hidden" class="templateChanged">
															<div class="addFiles">
																<label for="file" class="template sbFloorPlan">No file selected</label>
																<input type="file" id="facilityLocationMap"
																	accept="application/pdf" name="templateFile"
																	onchange="fileChange(this); this.value=null; return false;"
																	class="form-control facilityLocationMap"> 
																	<span class="btn btn-default">ADD FILES</span>
															</div>
														</div>
													</div>
													<div class="col-sm-6">
														<div class="form-group formio-component-textfield">
															<label class="control-label">Upload Sub-Facility
																Location Map</label>
															<input type="hidden" class="templateChanged">
															<div class="addFiles">
																<label for="file" class="template sbLocationMap">No file selected</label>
																<input type="file" id="facilityLocationMap"
																	accept="application/pdf" name="templateFile"
																	onchange="fileChange(this); this.value=null; return false;"
																	class="form-control facilityLocationMap"> 
																	<span class="btn btn-default">ADD FILES</span>
															</div>
													</div>
												</div>
											</div>
											<label style="display: none;" id="subFacilityID"
												class="subFacilityID"></label> <label style="display: none;"
												id="SubStatus" class="SubStatus"></label>
												<label style="display: none;" id="Visible" class="Visible"></label>
												<label style="display: none;" id="Visible" class="Visible"></label>
										</div>
									</div>
								</div>
							</div>
						</div>
						
						<div class="row userAction">

							<div class="col-sm-12 text-center">
								<button type="button" class="btn btn-primary" id="edit"
									onclick="editFormIoPage()">EDIT</button>
								<button type="button" class="btn btn-reactive"
									style="display: none" onclick="Active()" id="btn-reactive">REACTIVATE</button>
								<button type="button" class="btn btn-deactive" id="btn-deactive"
									style="display: none" onclick="Deactive()">DEACTIVATE</button>
								<button type="button" class="btn btn-default" id="cancel"
									onclick="goBack();">CANCEL</button>
							</div>

						</div>
					</div>
				</div>
			</div>
		</form>
		</div>
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
<script>
	YUI().use('aui-toggler', function(Y) {
		new Y.TogglerDelegate({
			animated : true,
			closeAllOnExpand : true,
			container : '#myToggler',
			content : '.content',
			expanded : false,
			header : '.header',
			transition : {
				duration : 0.2,
				easing : 'cubic-bezier(0, 0.1, 0, 1)'
			}
		});
	});
</script>
<script>
   //subShedule dashed-box
   var namespace =  "<portlet:namespace/>";
   var ajaxUrl = "${resourceURL}";
   var mode = "view";
   var formStorageId = "<%= formStorageId %>";
   var baseUrl = "<%= baseUrl %>"
   var vocabularyURL = "<%= vocabularyURL %>";
   var successFacilityURL = "<%= successFacility.toString() %>";
   var subFacilityHolder=document.getElementById('subFacilityHolder');
   var subFacilityBase=document.getElementsByClassName('subFacilityBase')[0];
   while (subFacilityHolder.hasChildNodes()) {
   	subFacilityHolder.removeChild(subFacilityHolder.lastChild);
   }
   AUI().use('event-base', function (A) {
		A.on('domready', function () {
			loadDefaultData();
			});    
		});
</script>

