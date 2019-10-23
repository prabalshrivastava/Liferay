<%@page import="java.util.Calendar"%>
<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
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
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet'
	href='/html/css/sp/formio.full.min.css?minifierType=css'>
<%@ taglib uri="/tld/sp-formio" prefix="sp-formio"%>
<%-- <script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script> --%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/holiday.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>
<portlet:defineObjects />

<%
	if (PermissionUtil.canEditModel((PortletRequest) request.getAttribute("javax.portlet.request"))) {
%>

<%
String vocabularyURL = SambaashUtil.getParameter(SambaashConstants.API_VOCABULARY_URL, SambaashConstants.DEFAULT_GROUP_ID_LONG);
	String countryListUrl = SambaashUtil.getParameter(SambaashConstants.API_COUNTRYLIST_URL,
				SambaashConstants.DEFAULT_GROUP_ID_LONG);
		String formStorageId = request.getParameter("storageId");
		int year = Calendar.getInstance().get(Calendar.YEAR);
		String dashBoardLink = SambaashUtil.getDashBoard();
%>
<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>
<portlet:renderURL var="holidayCalendarListing">
	<portlet:param name="jspPage"
		value="/html/holidaycalendar/list.jsp" />
</portlet:renderURL>
<div class="newPortlets">

	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center">
						<h2><span>HOLIDAY CALENDAR SETUP</span></h2>
					</aui:col>
					<aui:col span="2" cssClass="text-right">
						<a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</a>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>

	<!-- <link rel="stylesheet" type="text/css" href="styles.css"> -->
	<div class="holidayCalendar">
		<div id="modal"></div>
		<div class="formRoot">
		<div class="innerFormRoot">
		<aui:form>
			
			<div class="formContainer container null formio-form">
				<div class="holidayCalendarForm">
					<div class="row">
						<div class="col col-sm-12">


							<div class="alert alert-" role="alert" id="alert_msg"
								style="display: none">TaxCode for this Country and Start
								date Exists.</div>


							<div class="row">
								<div class="col col-sm-12">
									<label>Country</label>
									<div class="form-group formio-choices">
										<select id="inp_country" class="form-control"
											onchange="fetchHolidays()">

										</select>
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
                       

							<div class="row">
								<div class="col col-sm-4">
									<label>Year</label>
									<div class="form-group formio-component-textfield">
										<input type="text" name="year" id="inp_year" onkeypress="handleEnter(event)"
											class="form-control" onblur="fetchHolidays()" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col col-sm-12">
									<label>Exam Body </label>
									<div class="form-group formio-choices">
										<select id="inp_exam_body" class="form-control" onchange="fetchHolidays()"> 
										<option value=""></option>
										</select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col col-sm-12">
									<label>Date and Description</label>
									<div class="form-group">
										<table id="tb_DateDescription" class="aui">
											<thead>
												<tr>
													<th>Date</th>
													<th>Description</th>
													<th>Status</th>

													<th />
												</tr>
											</thead>
											<tbody>
												<tr id="table_row">
													<td><label class="v_date" id="v_date"></label></td>
													<td><label class="v_desc" id="v_desc"></label></td>
													<td><label class="v_status" id="v_status"></label></td>

													<td>
														<button type="button" class="b_edit" id="b_edit"
															onclick="editRow(this)" style="display: none">Edit</button>
														<label class="v_id_row" id="v_id_row"
														style="display: none;">0</label>
													</td>
												</tr>
											</tbody>
										</table>

									</div>
								</div>
							</div>
                               <div class="alert alert-danger" id="form-error-div" style="display:none;text-align: left;" role="alert">
							      <p>Please fix the following errors before submitting.</p>
							      <ul>
							        <li ><strong id="error_msg">Tax Code is required</strong></li>
							      </ul>
							    </div>
							<!--   activation success message -->
							<div class="yui3-skin-sam">
								<div id="activation-success1" hidden="true" class="modalpopupBox">
									<div id="active-success-box1" class="modalpopupContent">

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
							<div id="deactive-record1" hidden="true" class="modalpopupBox">
								<div id="deactive-record-box1" class="modalpopupContent">
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
											<aui:col span="12" cssClass="userAction">
												<button type="button"
													class="btn btn-default popup-confirm-deactivate pull-left"
													onclick="confirm();">Confirm</button>
												<button type="button"
													class="btn btn-primary popup-cancel-deactivate pull-right close1"
													onclick="reloadPage();">Cancel</button>
											</aui:col>
										</aui:row>
									</form>

								</div>
							</div>
						</div>
                              
							<div class="row" id="addNewDiv">
								<div class="col-sm-12">
									<div class="form-group">
										<aui:button cssClass="btn btn-primary" value="+ Add Another"
											onClick="showAddNewPopup()" id="addanother"/>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
				<div class="row" style="display: none;">
					<div class="col col-sm-6 col-sm-push-3">
						<div class="form-group">
							<div class="col col-sm-4">
								<aui:button id="bt_saveDraft" type="button" value="Save Draft"
									cssClass="btn-default"></aui:button>
							</div>
							<div class="col col-sm-4">
								<aui:button id="bt_submit" type="button" value="Save"
									cssClass="btn-primary"></aui:button>
							</div>
							<div class="col col-sm-4">
								<aui:button id="bt_clear" type="button" value="Clear"
									cssClass="btn-default"></aui:button>
							</div>
						</div>
					</div>
				</div>
			</div>

		</aui:form>
		</div></div>
	</div>


	<!-- The Modal -->
	<div class="yui3-skin-sam">
		<div id="modalBox" class="modalpopupBox" hidden="true">
			<div id="modalContent" class="modalpopupContent">
				<form class="formContainer ">
					<aui:row>
						<aui:col span="12">

							<div class="alert alert-" role="alert" id="alert_msg-popup"
								style="display: none">TaxCode for this Country and Start
								date Exists.</div>


						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="12">
							<input type="hidden" name="description" id="inp_id" />
							<div style="visibility: visible; position: relative; float: right;">
								<p id="formStatus" class="formStatus form_draft">Draft</p>
							</div>
							<label>Select Date <span class="star">*</span></label>
							<div class="form-group formio-component-textfield has-error">
								<input type="text" name="date" autocomplete="off"
									class="form-conrol" id="inp_date" onfocus="showOverlay();" onfocusout="showOverlay();"/><i class="dateIcon"></i> <input
									type="hidden" name="date" class="form-conrol" id="inp_status" />
									<div class="formio-errors invalid-feedback help-block" id="date" style="display:none">
			 				           Description is required
							     </div>
							</div>

						</aui:col>
					</aui:row>
		
					<aui:row>
						<aui:col span="12">
							<label>Enter Description <span class="star">*</span></label>
							<div class="form-group formio-component-textarea has-error">
								<textarea type="text" name="description" maxlength="100"
									class="form-conrol" id="inp_desc" onChange="validatevalue();"> </textarea>
									<div class="formio-errors invalid-feedback help-block" id="desc" style="display:none">
									Description is required
								</div>
							</div>
						</aui:col>
					</aui:row>

					<aui:row>
						<aui:col span="12" cssClass="userAction">
						 <button type="button" onclick="validateHoliday('Draft')"  id="draft" style="display:none" class="btn btn-default">SAVE DRAFT</button>
							<button type="button" onclick="validateHoliday('Active')"
								class="btn btn-primary" id="save" >Update</button>
							<button type="button" onclick="editHoliday();"
								class="btn btn-default" id="edit" style="display:none">Edit</button>
							<button type="button" onClick="DeactivationPopUp();"
								class="btn btn-warning btn-md btn-deactive" id="deactivate"
								style="display: none">Deactivate</button>
							<button type="button" onClick='Reactivation();'
								class="btn btn-success btn-md" style="display: none"
								id="reactivate">Reactivate</button>
								
							<button type="button" onclick="reset();" class="btn btn-default" id="clear">CLEAR</button>
							<button type="button" onclick="goBack();" class="btn btn-default">CANCEL</button>


						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>
</div>

<script>
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var mode = "edit";
var planList = [];
var countryListUrl = "<%=countryListUrl%>";
var formStorageId = "<%=formStorageId%>";
var vocabularyURL = "<%= vocabularyURL %>";
var formHolidayDate = "";
var holidayCalendarListing = "<%=holidayCalendarListing.toString()%>";

var tbl = document.getElementById('tb_DateDescription');
var tbody = tbl.getElementsByTagName('tbody')[0];
var tr_base = tbody.getElementsByTagName("tr")[0];
var currentYear = "<%=String.valueOf(year)%>";
	var inp_id = document.getElementById('inp_id');
	var inp_date = document.getElementById('inp_date');
	var inp_desc = document.getElementById('inp_desc');
	var inp_country = document.getElementById("inp_country");
	var inp_exam_body = document.getElementById("inp_exam_body");
	
	var inp_year = document.getElementById('inp_year');

	var readOnly = false;
	var modelName = "HolidayCalendar";
	AUI().use('event-base', function(A) {
		A.on('domready', function() {
			getCountriesList();
			loadDropdownList("Exam%20Body", document.getElementById("inp_exam_body"));    
			inp_country.disabled = "disabled";
			inp_year.disabled = "disabled";
		});
	});

	YUI().use('aui-datepicker', function(Y) {
		new Y.DatePicker({
			trigger : '#inp_date',
			mask : '%d/%m/%Y',
			popover : {
				zIndex : 1000
			},
			on : {
				selectionChange : function(event) {
					 showOverlay();
					var data = document.getElementById('date');
					data.style.display="none";
				}
			}
		});
	});
	
	function validatevalue()
	{
		var description = document.getElementById('inp_desc');
		var date = document.getElementById('inp_date');
		if (description.value != "") 
		{
			var data = document.getElementById('desc');
			data.style.display="none"
		}
	}
	
	function validateHoliday(status) {
		if(inp_desc.value == "")
		{
			var data = document.getElementById('desc'); 
			data.removeAttribute('style');
		}
		if (inp_date.value == "") {
			var data = document.getElementById('date'); 
			data.removeAttribute('style');
			showAlertDiv("Please Fill up Holiday date");
		}else if(inp_desc.value == "")
			{
				var data = document.getElementById('desc'); 
				data.removeAttribute('style');
			}
		 else {
			//hideAlert();
			var parts = inp_date.value.split("/");
			var yyyy = parts[2];
			if (yyyy != inp_year.value) {
				showAlertDiv("Holiday Date and Year Mismatch");
			} else if (currentYear > inp_year.value) {
				showAlertDiv("Cannot create Holiday for Past Year");
			} else {
				formHolidayDate = inp_date.value;

				var data1 = {
					"limit" : 4,
					"modelName" : modelName,
					"page" : 0,
					"formType" : modelName
				};
				data1.conditions = [ "contentJson.Date=" + formHolidayDate ];
				data1.sortBy = "contentJson.Date";

				ajaxCallAPI(
						'GET',
						'searchList',
						data1,
						function() {

							var response = this.get("responseData");

							if (_.isEmpty(response)) {
								console.log("error");

							} else {
								if (response.numberOfElements > 1) {
									showAlertDiv("Duplicate Record");
								} else if (response.numberOfElements == 1
										&& response.content[0].storageId != formStorageId) {
									showAlertDiv("Duplicate Record");
								} else {
									addNew(status);
								}
							}
						}, function() {

						});
			}
		}

	}
</script>
<% } %>