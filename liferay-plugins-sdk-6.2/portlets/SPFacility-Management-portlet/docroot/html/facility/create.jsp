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
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib
	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/facility.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet'
	href='/html/css/sp/formio.full.min.css?minifierType=css'>
<%@
taglib uri="/tld/sp-formio" prefix="sp-formio"%>

<portlet:defineObjects />

<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>
<%
	String formStorageId = request.getParameter("storageId");
%>
<portlet:defineObjects />
<%
	String baseUrl = portletPreferences.getValue("baseUrlPref", "");
	String vocabularyURL = SambaashUtil.getParameter(SambaashConstants.API_VOCABULARY_URL, 21424);
	String dashBoardLink = SambaashUtil.getDashBoard();
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
						<h2><span>Facility Setup</span></h2>
					</aui:col>
					<aui:col span="2" cssClass="text-right">
						<a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</a>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>


	<div class="yui3-skin-sam">
		<div id="sucess-popup1" hidden="true" class="modalpopupBox">
			<div id="sucess-popup-box1" class="modalpopupContent">
				<form class="formContainer">
					<aui:row>
						<aui:col span="12">
							<h3 id="success-msg">Draft record saved successfully</h3>
						</aui:col>

					</aui:row>
					<aui:row>
						<aui:col span="12" cssClass="userAction">
							<button class="btn btn-default popup-confirm-archive pull-left"
								type="button" onClick="reloadPage()">Start Again</button>
							<button class="btn cancel btn-primary popup-cancel pull-right" type="button" onClick="goBack()">Go Back</button>
						</aui:col>
					</aui:row>

				</form>
			</div>
		</div>
	</div>

	<div class="sheduleSetup">
		<div class="formRoot">
		<div class="innerFormRoot">
		<div id="formio" class="formContainer container null formio-form">
			<form class="facilityform" id="facilityform">
				<div class="formSection">
					
					<aui:row>
						<aui:col span="6">
							<div class="container lastModify" style="display:none">
								<ul>
									<li>Last modified by </li>
									<li><strong>Emilie Doyle</strong></li>
									<li>on</li>
									<li><strong>13/08/2018</strong></li>
								</ul>
							</div>
						</aui:col>
						<aui:col span="6">
							<div style="visibility: visible; position: relative; float: right;">
								<p id="formStatus" class="formStatus form_draft">Draft</p>
							</div>
						</aui:col>
					</aui:row>
					<div class="row">
						<div class="col-sm-12">
							<div style="display: none;" class="alert alert-danger"
								role="showAlert" id="alert_msg">Select Facility Type.</div>
							<div class="row">
								<div class="col-sm-6">
									<div class="form-group choices formio-choices">
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
											class="star">*</span></label>										
											<input type="text" maxlength="20"
												class="form-control facilityCode" id="facilityCode"
												placeholder="Enter Facility Code"
												onkeypress="return AvoidSpace(event)" onChange="validatevalue();">
											<div class="formio-errors invalid-feedback hide">
												<p class="help-block">Facility Code is required</p>
											</div>										
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6">
									<div class="form-group choices formio-choices">
										<label class="control-label">Facility Category <span
											class="star">*</span></label> <select
											class="form-control facilityCategory" id="facilityCategory">
											<option value="" disabled selected>Pick one</option>
										</select>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group formio-component-textfield has-error">
										<label class="control-label">Facility Name <span
											class="star">*</span></label> <input type="text" maxlength="50"
											class="form-control facilityName" id="facilityName"
											placeholder="Enter a name for the facility " onChange="validatevalue();">
										<div class="formio-errors invalid-feedback hide">
											<p class="help-block">Facility Name is required</p>
										</div>
									</div>
								</div>
							</div>



							<!-- pop up success -->
							<div class="yui3-skin-sam">
								<div id="sucess-popup" hidden="true" class="modalpopupBox">
									<div id="sucess-popup-box" class="modalpopupContent">
										<form class="formContainer">
											<aui:row>
												<aui:col span="12">
													<h3 id="success-msg">Facility Created!</h3>
												</aui:col>

											</aui:row>
											<aui:row>
												<aui:col span="12">
													<button
														class="btn btn-default popup-confirm-archive pull-left"
														type="button" onClick="reloadPage()">Start Again</button>
													<button
														class="btn cancel btn-primary popup-cancel pull-right"
														type="button" onClick="goBack()">Dashboard</button>
												</aui:col>
											</aui:row>

										</form>
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
												name="templateFile"
												onchange="fileChange(this); this.value=null; return false;"
												class="form-control facilityLocationMap"> 
												<span class="btn btn-default">ADD FILES</span>
												
											
										</div>
									</div>
								</div>
								
								<div class="col-sm-6">
									<div class="form-group formio-component-textfield has-error">
										<label class="control-label">Location Map URL <span
											class="star">*</span></label> <input maxlength="100" type="text"
											class="form-control facilityLocation" id="facilityLocation"
											placeholder="Enter location map url" onChange="validatevalue();">
										<div class="formio-errors invalid-feedback hide">
											<p class="help-block">Location Map Url is required</p>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<div class="form-group formio-component-textfield has-error">
										<label class="control-label">Contact Person </label> <input
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
						<label class="control-label">Seating Capacity</label>
						<input type="number" oninput="maxLengthCheck(this)" maxlength="12" class="form-control facilitySeating" id="facilitySeating" placeholder="Enter the total capacity">
					</div>
				</div> -->
							</div>
							<div class="row">
								<div class="col-sm-6">
									<div class="form-group formio-component-textfield has-error">
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
									<div class="form-group formio-component-textfield has-error">
										<label class="control-label">Contact number</label> <input
											type="number" maxlength="20"
											class="form-control facilityContactNumber"
											id="facilityContactNumber"
											placeholder="Enter the contact number" onChange="validatevalue();">
										<div class="formio-errors invalid-feedback hide">
											<p class="help-block">Contact Number is required</p>
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




							<div class="row">
								<div id="myToggler" class="col-sm-12">
									<div class="subFacilityHolder" id="subFacilityHolder">
										<div class="addSubFacility subFacilityBase facilityContainer" style="margin-top: 5px">
											<h4 class="header">
												<div style="display: inline-block;">01- Sub Facility</div>
												<!-- <button class="removeBtn" onclick="RemoveSubFecility(this)"></button>
												<button class="expandCollapse minusIcon"
													onclick="RemoveSubFecility(this)">close</button> -->
												<ul class="nav">
														<li><a href="javascript:void(0);"
															class="btn removeBtn" onclick="RemoveSubFecility(this)">Remove</a></li>
														<!-- <li><a href="javascript:void(0);" class="saveIcon"
															onclick="CopySubSchedule(this)">Save</a></li> -->
														<li><a href="javascript:void(0);" class="expandCollapse minusIcon" onClick="collapsOrExpand(this)"></a></li>
												</ul>
												<!-- <ul class="nav">
														<li><a href="javascript:void(0);"
															class="btn removeBtn" onclick="RemoveSubSchedule(this)">Remove</a></li>														
														<li><a href="javascript:void(0);" class="expandCollapse minusIcon" onClick="collapsOrExpand(this)">close</a></li>
													</ul> -->
											</h4>
											
											<label style="display: none;" id="SubFacilityID" class="SubFacilityID"></label> 
											<label style="display: none;" id="SubStatus" class="SubStatus"></label>
											<label style="display: none;" id="Visible" class="Visible"></label>
											
											<div
												class="toggleContent conte nt togg ler-content-collapsed subSheduleContent">
												<div class="row">
													<div class="col-sm-6">
														<div class="form-group formio-component-textfield">
															<label class="control-label">Sub-Facility Code</label> <input
																type="text" maxlength="20"
																class="form-control subFacilityCode"
																id="subFacilityCode"
																placeholder="Enter Sub Facility Code">
														</div>
													</div>
													<div class="col-sm-6">
														<div class="form-group formio-component-textfield">
															<label class="control-label">Sub-Facility Name</label> <input
																type="text" maxlength="50"
																class="form-control subFacilityName"
																id="subFacilityName"
																placeholder="Enter Sub Facility Name">
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-sm-6">
														<div class="form-group formio-component-textfield">
															<label class="control-label">Sub-Facility Floor /
																Unit No</label> <input type="text" maxlength="20"
																class="form-control subFacilityUnit"
																id="subFacilityUnit"
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
																	 name="templateFile"
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
																	 name="templateFile"
																	onchange="fileChange(this); this.value=null; return false;"
																	class="form-control facilityLocationMap"> 
																	<span class="btn btn-default">ADD FILES</span>
															</div>
													</div>
												</div>
												<label style="display: none;" id="subFacilityID"
													class="subFacilityID"></label> <label
													style="display: none;" id="SubStatus" class="SubStatus"></label>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12 text-center">
									<button type="button"
										class="addSubFacilityBtn  toggler-header-collapsed"
										onclick="AddSubFacility()">
										<span>+</span>ADD SUB-FACILITY</span>
									</button>
								</div>
							</div>
							<div class="row userAction">
								<div class="col-sm-12 text-center">

									 <button type="button" class="btn btn-default"
										onclick="saveDraftFields()">SAVE DRAFT</button>
										
									<button type="button" class="btn btn-primary"
										onclick="validateFields(this)" name="publish">PUBLISH</button>

									<button type="button" class="btn btn-default"
										onclick="reset(this)" name="clear">CLEAR</button>
									<button type="button" class="btn btn-default"
										onClick="goBack();" name="cancel">CANCEL</button>

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

YUI().use(
		  'aui-toggler',
		  function(Y) {
		    new Y.TogglerDelegate(
		      {
		        animated: true,
		        closeAllOnExpand: true,
		        container: '#myToggler',
		        content: '.content',
		        expanded: false,
		        header: '.header',
		        transition: {
		          duration: 0.2,
		          easing: 'cubic-bezier(0, 0.1, 0, 1)'
		        }
		      }
		    );
		  }
		);
</script>

<script>
//subShedule dashed-box
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var mode = "create";
var formStorageId = "";
var baseUrl = "<%=baseUrl%>"
var vocabularyURL = "<%=vocabularyURL%>";
var successFacilityURL = "<%=successFacility.toString()%>";
	var subFacilityHolder = document.getElementById('subFacilityHolder');
	var subFacilityBase = document.getElementsByClassName('subFacilityBase')[0];
	while (subFacilityHolder.hasChildNodes()) {
		subFacilityHolder.removeChild(subFacilityHolder.lastChild);
	}

	AUI().use('event-base', function(A) {
		A.on('domready', function() {
			loadDefaultData();
		});
	});
</script>



