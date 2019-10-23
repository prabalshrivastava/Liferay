<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
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
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<link rel='stylesheet'
	href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>

<%
	String formStorageId = request.getParameter("storageId");
    
%>
<portlet:defineObjects />
<%
	String baseUrl = portletPreferences.getValue("baseUrlPref", "");
	ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	Long groupId = td.getLayout().getGroupId();
	String dashboardLink = SambaashUtil.getParameter("dashboard.link", groupId);
	String vocabularyURL = SambaashUtil.getParameter(SambaashConstants.API_VOCABULARY_URL, groupId);
	String dashBoardLink = SambaashUtil.getDashBoard();
	String countryListUrl = SambaashUtil.getParameter(SambaashConstants.API_COUNTRYLIST_URL,SambaashConstants.DEFAULT_GROUP_ID_LONG);

%>
<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>
<%@ taglib uri="/tld/sp-formio" prefix="sp-formio"%>
<portlet:defineObjects />
<portlet:renderURL var="list">
	<portlet:param name="jspPage" value="/html/schedule/list.jsp" />
</portlet:renderURL>

<script>
var namespace = "<portlet:namespace/>";
</script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/schedule.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"">
</script>

<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center">
						<h2><span>SCHEDULE SETUP</span></h2>
					</aui:col>
					<aui:col span="2" cssClass="text-right">
						<a href="<%= dashBoardLink %>" title="Back to Home">Back to Home</a>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>




	<div class="sheduleSetup">
		<div class="formRoot">
		<div class="innerFormRoot">
		<div class="formContainer container formio-form">
			<div class="formSection">
				<form class="aui" id="schedule_form" name="schedule_form" action="">
					<div class="alert" role="showAlert" id="alert_msg" style="display: none;"> </div>
					<aui:row>
						<aui:col span="12">
							<div style="visibility: visible; position: relative; float: right;"
								id="yui_patched_v3_11_0_1_1544779247468_794">
								<p id="formStatus" class="formStatus">Draft</p>
							</div>
							<aui:row>
								<aui:col span="6" cssClass="choices  formio-choices">
									<div class="form-group has-error">
										<label class="control-label">Schedule Category <span class="star">*</span></label>
										 
										<aui:select name="" id="scheduleCategory"
											cssClass="form-control" onChange="GenerateSubjectCode()"
											label="">
										</aui:select>
										 <div class="formio-errors invalid-feedback hide"><p class="help-block">Schedule Category is required</p></div>
									</div>
								</aui:col>
								<aui:col span="6" cssClass="choices formio-choices">
									<div class="form-group has-error">
										<label class="control-label">Schedule Status <span class="star">*</span></label>
										<aui:select name="" id="scheduleStatus" cssClass="form-control">
										</aui:select>
										<div class="formio-errors invalid-feedback hide"><p class="help-block">Schedule Status is required</p></div>
									</div>
								</aui:col>
								
							</aui:row>
							<aui:row>
								<aui:col span="6" >
									<div class="form-group ">
										<div class="choices formio-choices">
										<label class="control-label">Schedule Sub-Category</label>
										<aui:select name="" id="scheduleSubCategory"
											cssClass="form-control">
	                                   
										</aui:select>
										</div>	
										<!-- <div class="formio-errors invalid-feedback hide"><p class="help-block">Schedule Sub-Category is required</p></div> -->									 
									</div>
								
								</aui:col>
								<aui:col span="6" cssClass="formio-component-textfield ">
									<div class="form-group has-error ">
										<label class="control-label">Schedule Code<span class="star">*</span></label>
										<aui:input type="text" name="" id="scheduleCode"
											cssClass="form-control is-invalid"  onkeypress="return AvoidSpace(event)"
											placeholder="Enter a code for the schedule" onChange="validatevalue();"/>	
											<div class="formio-errors invalid-feedback hide" ><p class="help-block">Schedule Code is required</p></div>										
									</div>									
								</aui:col>
	
							</aui:row>
							<aui:row>
								<aui:col span="6" cssClass="formio-component-textfield">
									<div class="form-group has-error">
										<label class="control-label vhidden1">Schedule Name <span class="star">*</span></label>
										<aui:input type="text" name="" id="scheduleName"
											cssClass="form-control"
											placeholder="Enter a name for the schedule" onChange="validatevalue();"/>
											<div class="formio-errors invalid-feedback hide" ><p class="help-block">Schedule Name is required</p></div>
									</div>
								</aui:col>
								<aui:col span="6" cssClass="form-group formio-component-datetime">
									<aui:col span="6">
										<div class="form-group has-error">
											<label class="control-label">From Date <span class="star">*</span></label>
											<aui:input type="text" name="" cssClass="form-control flatpickr-input"
												id="startDate" placeholder="dd/mm/yyyy" autocomplete="off" onChange="validatevalue();"/>
											<span class="input-group-addon" style="cursor: pointer"><i
												class="glyphicon glyphicon-calendar"></i></span> 
												<div class="formio-errors invalid-feedback hide"><p class="help-block">Schedule From Date is required</p></div>
										</div>
	
									</aui:col>
									<aui:col span="6">
										<div class="form-group has-error">
											<label class="control-label dnone">To Date</label>
											<aui:input type="text" name="" cssClass="form-control"
												id="endDate" placeholder="dd/mm/yyyy" autocomplete="off"/>
											<span class="input-group-addon" style="cursor: pointer"><i
												class="glyphicon glyphicon-calendar"></i></span>
											<div class="formio-errors invalid-feedback hide"><p class="help-block">Schedule To Date is required</p></div>
										</div>
									</aui:col>
								</aui:col>
	
							</aui:row>
							<aui:row>
								<aui:col span="6" cssClass="formio-component-textfield">
									<div class="form-group">
										<label class="control-label">Session Type</label>
										<aui:select type="text" name="" id="sessionType"
											cssClass="form-control" onChange="fillTimings(this);">
										</aui:select>
									</div>
								</aui:col>
								<aui:col span="6" cssClass="formio-component-datetime">
									<aui:col span="6">
										<div class="form-group has-error">
											<label class="control-label">From Time</label>
											<aui:input type="text" name=""
												cssClass="form-control timepicker" id="startTime"
												placeholder="00:00" autocomplete="off"/>
											<span class="input-group-addon" style="cursor: pointer"><i
												class="glyphicon glyphicon-time"></i></span>
											<div class="formio-errors invalid-feedback hide"><p class="help-block">Schedule From Time is required</p></div>
										</div>
									</aui:col>
									<aui:col span="6">
										<div class="form-group has-error">
											<label class="control-label dnone">To Time</label>
											<aui:input type="text" name=""
												cssClass="form-control timepicker" id="endTime"
												placeholder="00:00" autocomplete="off"/>
											<span class="input-group-addon" style="cursor: pointer"><i
												class="glyphicon glyphicon-time"></i></span>
											<div class="formio-errors invalid-feedback hide"><p class="help-block">Schedule To Time is required</p></div>
										</div>
									</aui:col>
								</aui:col>
							</aui:row>
							
							<aui:row>
								<aui:col span="6" cssClass="choices  formio-choices">
									<div class="form-group has-error">
										<label class="control-label">Country <span class="star">*</span></label>
										 
										<aui:select name="" id="scheduleCountry"
											cssClass="form-control" onChange="getHolidayList(this)" label="">
										</aui:select>
										 <div class="formio-errors invalid-feedback hide"><p class="help-block">Schedule Country is required</p></div>
									</div>
								</aui:col>
							</aui:row>
							<aui:row id="briefing_reporting" style="display: none" disabled = "true">
	
								<aui:col span="6" cssClass="choices formio-choices" >
									<div class="form-group">
										<label class="control-label">Reporting:  Mins before Schedule Start Time </label>
										<aui:input type="number" name="" id="minBeforeScheduleStart"
											cssClass="form-control" min = "0" value="0"/>
									</div>
								</aui:col>
								<aui:col span="6" cssClass="choices  formio-choices">
									<div class="form-group">
										<label class="control-label">Mins After Schedule End Time</label>
										<aui:input type="number" name="" id="minAfterScheduleEnd"
											cssClass="form-control" min = "0" value = "0"/>
									</div>
								</aui:col>
							</aui:row>
							
							<aui:row>
								<aui:col span="6">
									<div class="form-group">
										<label class="control-label">Repeat</label>
										<div class="input-group">
											<div class="form-check radio">
												<aui:input name="radio" label="<span></span>Yes" id="radio1"
													onclick="ShowHideDiv()" type="radio" value="Yes" />
											</div>
											<div class="form-check radio">
												<aui:input name="radio" label="<span></span>No" id="radio2"
													onclick="ShowHideDiv()" type="radio" value="No" checked="true"/>
											</div>
											
										</div>
									</div>
								</aui:col>
								<aui:col span="6">
									<div class="form-group">
										<label class="control-label">Overlapping Ranges?</label>
										<div class="input-group">
											<div class="form-check radio">
												<aui:input name="overlappingradio" label="<span></span>Yes"
													id="radio3" type="radio" value="Yes" />
											</div>
											<div class="form-check radio">
												<aui:input name="overlappingradio" label="<span></span>No"
													id="radio4" type="radio" value="No" checked="true"/>
											</div>
											<div class="form-check radio">
												<aui:input name="overlappingradio"
													label="<span></span>Not Applicable" id="radio5" type="radio"
													value="Not Applicable" />
	
											</div>
										</div>
									</div>
								</aui:col>
							</aui:row>
	
	                        
	                        
	                  <!-- pop up success -->
							<div class="yui3-skin-sam">
								<div id="sucess-popup" hidden="true" class="modalpopupBox">
									<div id="sucess-popup-box" class="modalpopupContent">
										<form class="formContainer">
											<aui:row>
												<aui:col span="12">
													<h3 id="success-msg">Schedule Updated Sucessfully!</h3>
												</aui:col>

											</aui:row>
											<aui:row>
												<aui:col span="12" cssClass="userAction">
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
  


							<aui:row>
								<aui:col>
									<div class="dashed-box " style="display: none"
										id="repeat_period">
										<aui:row>
											<aui:col span="6" cssClass="choices formio-choices">
												<div class="form-group">
													<label class="control-label">Repeat Period</label>
													<aui:select name="" cssClass="form-control" id="drp_value"
														onchange="run()">
													</aui:select>
												</div>
											</aui:col>
											<aui:col span="6" cssClass="formio-component-textfield "
												id="every">
												<div class="form-group">
													<label class="control-label">Repeat Every</label>
													<aui:select type="text" name="" id="repeatEvery"
														cssClass="form-control" placeholder="" />
												</div>
											</aui:col>
										</aui:row>
	
	
	
										<div class="input-group dayOptions" style="display: none"
											id="weekly">
											<div class="form-group">
												<div class="form-check radio">
													<aui:input name="day" label="<span>M</span>" id="m"
														type="radio" value="M" />
												</div>
												<div class="form-check radio">
													<aui:input name="day" label="<span>T</span>" id="t"
														type="radio" value="T" />
												</div>
												<div class="form-check radio">
													<aui:input name="day" label="<span>W</span>" id="w"
														type="radio" value="W" />
												</div>
												<div class="form-check radio">
													<aui:input name="day" label="<span>T</span>" id="th"
														type="radio" value="T" />
												</div>
												<div class="form-check radio">
													<aui:input name="day" label="<span>F</span>" id="f"
														type="radio" value="F" />
												</div>
												<div class="form-check radio">
													<aui:input name="day" label="<span>S</span>" id="sat"
														type="radio" value="S" />
												</div>
												<div class="form-check radio">
													<aui:input name="day" label="<span>S</span>" id="sun"
														type="radio" value="S" />
												</div>
											</div>
										</div>
	
										<aui:row>
											<aui:col span="6" id="monthly" style="display:none;">
												<div class="form-group">
													<label class="control-label">Repeat On</label>
													<div class="input-group">
														<div class="form-check radio">
															<aui:input name="repeatOn"
																label="<span></span>Day of the Month" id="repeaton1"
																type="radio" value="Yes" />
														</div>
														<div class="form-check radio">
															<aui:input name="repeatOn"
																label="<span></span>Day of the Week" id="repeaton2"
																type="radio" value="No" />
														</div>
													</div>
													<aui:col span="12">
														<aui:col span="6"
															cssClass="choices form-group formio-choices">
															<aui:select name="" cssClass="form-control"
																id="dayOfMonth">
																<aui:option value="First">First</aui:option>
																<aui:option value="Second">Second</aui:option>
																<aui:option value="Third">Third</aui:option>
																<aui:option value="Fourth">Fourth</aui:option>
																<aui:option value="Fifth">Fifth</aui:option>
																<aui:option value="Sixth">Sixth</aui:option>
															</aui:select>
														</aui:col>
														<aui:col span="6"
															cssClass="choices form-group formio-choices">
															<aui:select name="" cssClass="form-control" id="dayOfWeek">
																<aui:option value="Monday">Monday</aui:option>
																<aui:option value="Tuesday">Tuesday</aui:option>
																<aui:option value="Wednesday">Wednesday</aui:option>
																<aui:option value="Thursday">Thursday</aui:option>
																<aui:option value="Friday">Friday</aui:option>
																<aui:option value="Saturday">Saturday</aui:option>
																<aui:option value="Sunday">Sunday</aui:option>
															</aui:select>
														</aui:col>
													</aui:col>
												</div>
											</aui:col>
	
	
	
	
											<aui:col span="12"
												cssClass="endsOptions formio-component-textfield" id="daily">
												<div class="form-group">
													<label class="control-label">Ends</label>
	
													<div class="input-group">
														<div class="form-check radio">
															<aui:input name="ends" label="<span></span>Never"
																id="radio13" type="radio" value="Never" />
														</div>
														<div class="form-check radio">
															<ul class="after-ul">
																<li><aui:input name="ends"
																		label="<span></span>After" id="radio14" type="radio"
																		value="After" /></li>
																<li><aui:input type="text" name=""
																		cssClass="form-control" id="occurence" /><span>Occurences</span></li>
															</ul>
														</div>
														<div class="form-check formio-component-datetime radio">
															<div class="form-group">
																<aui:input name="ends" label="<span></span>On"
																	id="radio15" type="radio" value="On" />
															</div>
															<div class="form-group">
																<input type="text" name="" class="form-control"
																	id="<portlet:namespace/>endOn" placeholder="dd/mm/yyyy" autocomplete="off"/>
																<span class="input-group-addon" style="cursor: pointer"><i
																	class="glyphicon glyphicon-calendar"></i></span>
															</div>
														</div>
													</div>
												</div>
											</aui:col>
										</aui:row>
										<aui:row>
											<aui:col span="12" cssClass="text-center">
												<div class="repeatDaily" id="text_changed">Repeats
													every 2 weeks on Thursday, until September 23, 2018</div>
											</aui:col>
										</aui:row>
									</div>
								</aui:col>
							</aui:row>
	
							<aui:row>
								<aui:col span="12">
									<div class="subShedule dashed-box">
										<div class="subSheduleHolder" id="subSheduleHolder">
											<div class="sheduleContainer" id="sheduleContainer"
												style="margin-top: 5px">
												<h3 class="header toggler-header-collapsed">
													<div style="display: inline-block;">Schedule</div>
													<ul class="nav">
														<li><a href="javascript:void(0);"
															class="btn removeBtn" onclick="RemoveSubSchedule(this)">Remove</a></li>
														<li><a href="javascript:void(0);" class="saveIcon"
															onclick="CopySubSchedule(this)">Save</a></li>
														<li><a href="javascript:void(0);"  onClick="collapsOrExpand(this)" class="expandCollapse minusIcon"></a></li>
													</ul>
												</h3>
	
												<div
													class="subSheduleContent content toggler-conte nt-collapsed">
													<aui:row>
														<aui:col span="12" cssClass="formio-component-textfield">
															<label class="control-label subjectProgrammeName" id="subjectProgrammeName" >Subject Code and Subject Name</label>
															<aui:select name="" id="subjectProgramme"
																cssClass="form-control subjectProgramme">
															</aui:select>
														</aui:col>
													</aui:row>
													<aui:row>
														<aui:col span="6" cssClass="formio-component-datetime">
																<ul>
																	<li>
																		<div class="form-group">
																			<label class="control-label">From Date</label>
																			<aui:input type="text" name=""
																		cssClass="form-control subDate subStartDate" 
																		placeholder="dd/mm/yyyy" autocomplete="off"/>
																			<span class="input-group-addon" style="cursor: pointer"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																		</div>
																	</li>
																	<li>-</li>
																	<li><div class="form-group">
																	<label class="control-label dnone">To Date</label>
																	<aui:input type="text" name=""
																		cssClass="form-control subDate subEndDate" 
																		placeholder="dd/mm/yyyy" autocomplete="off"/>
																	<span class="input-group-addon" style="cursor: pointer"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div></li>
																</ul>
														
														</aui:col>
														<aui:col span="6" cssClass="formio-component-datetime">
															<ul>
																	<li>
																		<div class="form-group">
																	<label class="control-label">From Time</label>
																	<aui:input type="text" name=""
																		cssClass="form-control timepicker startTime"
																		id="startTime" placeholder="00:00" autocomplete="off"/>
																	<span class="input-group-addon" style="cursor: pointer"><i
																		class="glyphicon glyphicon-time"></i></span>
	
																</div>
																	</li>
																	<li>-</li>
																	<li><div class="form-group">
																	<label class="control-label dnone">End Time</label>
																	<aui:input type="text" name=""
																		cssClass="form-control timepicker endTime" id="endTime"
																		placeholder="00:00" autocomplete="off"/>
																	<span class="input-group-addon" style="cursor: pointer"><i
																		class="glyphicon glyphicon-time"></i></span>
																</div></li>
																</ul>
															
														</aui:col>
	
													</aui:row>
													<label style="display: none;" id="subScheduleID" class="subScheduleID"></label> 
													<label style="display: none;" id="SubStatus" class="SubStatus"></label>
													<label style="display: none;" id="Visible" class="Visible"></label>
												</div>
											</div>
	
										</div>
									</div>
	
	
								</aui:col>
	
							</aui:row>
	
	
	
							<aui:row cssClass="posRelative">
								<aui:col span="12" cssClass="text-center">
								<button type="button" class="addSubFacilityBtn  toggler-header-collapsed"  onClick="AddSubSchedule()"><span>+</span>ADD ANOTHER SUB SCHEDULE</span></button>
									<!-- <aui:button cssClass="addSubFacilityBtn"
										value="ADD ANOTHER SUB SCHEDULE" onClick="AddSubSchedule()"></aui:button> -->
								</aui:col>
							</aui:row>
							
							
							
							<div class="row userAction">
								
									<div class="col-sm-12 text-center">
										<button type="button" id="saveDraft" class="btn btn-primary btn-md saveDraft"
											onclick="saveDraftFields(this)">SAVE DRAFT</button> 
										<button type="button" id="save" class="btn btn-primary"
											onclick="validateFields(this)" name = "update">UPDATE</button>

										<button type="button" class="btn btn-reactive"
											style="display: none" onclick="Active(this)" action="reactive" name = "reactive">REACTIVATE</button>
										<button type="button" class="btn btn-deactive"
											onclick="Deactive(this)" action="deactive" name = "deactive" id="deactive">DEACTIVATE</button>

										<button type="button" id="clear" onclick="resetForm(this);" 
											class="btn btn-default">CLEAR</button>

										<button type="button" onclick="goBack();"
											class="btn btn-default">CANCEL</button>
									</div>
								</div>
							</div>
						
						
						
							
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
		</div></div>
	</div>


	<div id="sucess-popup" hidden="true" class="modalpopupBox">
		<div id="sucess-popup-box" class="modalpopupContent">
			<form class="formContainer" action="">
				<aui:row>
					<aui:col span="12">
						<h3>Schedule Created succesffuly</h3>
					</aui:col>

				</aui:row>
				<aui:row>
					<aui:col span="12" cssClass="userAction" >
						<button class="btn btn-default popup-confirm-archive pull-left"
							onClick="reloadPage()" type="button">Start Again</button>
						<button class="btn cancel btn-primary popup-cancel pull-right">GO Back</button>
					</aui:col>
				</aui:row>

			</form>
		</div>
	</div>
	
		<div id="sucess-popup1" hidden="true" class="modalpopupBox">
		<div id="sucess-popup-box1" class="modalpopupContent">
			<form class="formContainer" action="">
				<aui:row>
					<aui:col span="12">
						<h3>Schedule saved to Draft</h3>
					</aui:col>

				</aui:row>
				<aui:row>
					<aui:col span="12" cssClass="userAction" >
						<button class="btn btn-default popup-confirm-archive pull-left"
							onClick="reloadPage()" type="button">Start Again</button>
						<button class="btn cancel btn-primary popup-cancel pull-right">Go Back</button>
					</aui:col>
				</aui:row>

			</form>
		</div>
	</div>

</div>


<script type="text/javascript">
	//subShedule dashed-box
	var ajaxUrl = "${resourceURL}";
	var mode = "edit";
	var formStorageId = "<%=formStorageId%>";
	formStorageId =   decodeURIComponent(formStorageId);
    var vocabularyURL = "<%=vocabularyURL%>";
    var baseUrl = "<%=baseUrl%>";
    var countryListUrl = "<%= countryListUrl %>";
	var subSheduleHolder = document.getElementById('subSheduleHolder');
	var sheduleBase = document.getElementsByClassName('sheduleContainer')[0];
	var scheduleCategory = document.getElementsByClassName(namespace
			+ "scheduleCategory")[0];

	var subjectProgramme = document.getElementsByClassName(namespace
			+ "subjectProgramme")[0];

	document.getElementById("text_changed").innerHTML = "";
	while (subSheduleHolder.hasChildNodes()) {
		subSheduleHolder.removeChild(subSheduleHolder.lastChild);
	}
	
	AUI().use('event-base', function(A) {
		A.on('domready', function() {			
			loadDefaultData();
		/* 	setInterval(function() {
				checkForm();
			}, 1000); */
		});
	});
	GenerateSubjectCode();
</script>
<style>
.formStatus {
	width: 90px;
	padding: 2px 10px;
	text-align: center;
	border-radius: 15px;
	float: po;
	position: absolute;
	top: -25px;
	right: 0;
}

.form_active {
	background: #8bdb7c;
}

.form_inactive {
	background: #ffc48b;
}

.form_draft {
	background: #dfe3e8;
}

.form_blacklist {
	background: black;
	color: white;
}
</style>
