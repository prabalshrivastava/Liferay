
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet'
	href='/html/css/sp/formio.full.min.css?minifierType=css'>
<style type="text/css">
@IMPORT url("");
</style>
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>
<%@ taglib uri="/tld/sp-formio" prefix="sp-formio"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
	if (PermissionUtil.canEditModel((PortletRequest) request.getAttribute("javax.portlet.request"))) {
%>
<%
	String formId = portletPreferences.getValue(SystemSetupConstants.PREF_HTML_FORM_ID, "");
	String formType = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME,
			"InvigilatorAppointment");
	String dashBoardLink = SambaashUtil.getDashBoard();
	String storageId = request.getParameter("storageId");
	String baseUrl = portletPreferences.getValue("baseUrlPref", "");
	//String formStorageId  = request.getParameter("storageId");
	ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	String userId = String.valueOf(td.getUserId());
	String formStorageId = userId;
	String countryListUrl = SambaashUtil.getParameter(SambaashConstants.API_COUNTRYLIST_URL,
			SambaashConstants.DEFAULT_GROUP_ID_LONG);
	Long groupId = td.getLayout().getGroupId();
	String vocabularyURL = SambaashUtil.getParameter(SambaashConstants.API_VOCABULARY_URL, groupId);
	if (storageId != null && !storageId.equalsIgnoreCase("")) {
		userId = storageId;
	}
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
					<h2><span>Notify Appointment</span></h2>
				</aui:col>
				<aui:col span="2" cssClass="text-right">
					<a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</a>
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
				<form id="myform" action="">
					<div class="row">
						
							<div class="col-sm-6">
								<label>Schedule (Programme)</label> 
								<select id="programmeSchedule" onChange="getAppointDataOnInvigilator()"></select>
							</div>
							<div class="col-sm-6">
								<label>Schedule (Briefing)</label> 
								<select id="briefingschedule" onChange="getBriefingScheduleData()"></select>
							</div>
						
					</div>
					<div class="row">
						<div class="col col-sm-12">
							<table id="DateDescription" class="aui">
								<thead>
									<tr>
										<th>Invigilator</th>
										<th>Appointment Type</th>
										<th>Invi. Date</th>
										<th>Inv. Session Type</th>
										<th><input class="checked1" onchange="checkAll(this)"
											type="checkbox" id="" value="" /></th>
									</tr>
								</thead>
								<tbody>
									<tr id="table_row" class="table_row" style="display: none">
										<td><label class="Invigilator">Inv Name</label></td>
										<td><label class="appointType">Inv Name</label></td>
										<td><label class="invDate">8:00-12:00</label></td>
										<td><label class="invSessioinType">12-12-2018</label></td>
										<td><input class="checked" onclick='onChecked1(this)'
											type="checkbox" id="" value="" name="test" /></td>
										
										<td></td>
									</tr>
								</tbody>
							</table>
						
						</div>
					</div>
					
					
					<!--  Noification pop up success -->
					<div class="yui3-skin-sam">
						<div id="sucess-popup" hidden="true" class="modalpopupBox">
							<div id="sucess-popup-box" class="modalpopupContent">			
								<aui:row>
									<aui:col span="12">
										<h3 id="success-msg">Notification sent successfully!</h3>
									</aui:col>			
								</aui:row>
								<aui:row>
									<aui:col span="12" cssClass="text-center userAction">
										<button class="btn btn-default popup-confirm-archive "
											type="button" onClick="reloadPage()">Start Again</button>
										<button class="btn cancel btn-primary popup-cancel pull-right"
											type="button" onClick="moveToDashboard()">DashBoard</button> 
									</aui:col>
								</aui:row>
			
			
							</div>
						</div>
					</div>

		<!-- ------------end---------------- -->
					
					
					
					
					<div class="row">
						<div class="col col-sm-6 col-sm-push-3">
							<div class="form-group formio-component-datetime">
								<label cssClass="control-label">Acceptance Deadline</label>
								<aui:input type="text" name="" cssClass="form-control startDate"
									id="startDate" autoComplete = "off" placeholder="dd/mm/yyyy" />
								<span class="input-group-addon" style="cursor: pointer"><i
									class="glyphicon glyphicon-calendar"></i></span>
							</div>
						</div>
					</div>
					<div clss="row">
						<div class="col col-sm-12 ">
							<div class="available">
								<ul>
									<li>Total Listed: <span id="available" class="available">0</span></li>
									<li>Selected: <span id="selected" class="selected">0</span></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col col-sm-12 userAction">
							<button type="button" class="btn btn-primary close1" id="sendBtn"
								onclick="sendNotification(this)">SEND APPOINTMENT LETTER</button>
							<button type="button" class="btn btn-primary" onclick= "moveToDashboard()">CANCEL</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		</div></div>
	</div>
	
	
	<td class="form-group formio-choices">
		
	</td>
</div>
<portlet:resourceURL var="elastisearchlisturl">
</portlet:resourceURL>
<script type="text/javascript">
var mode = "edit";
var dontLoadData = false;
var documents;
var namespace = "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var appointmenttType = document.getElementById(namespace + "appointmenttype");
var userId = "<%=userId%>";
var formStorageId = "<%=formStorageId%>";
var elastisearchlisturl = "<%=elastisearchlisturl%>";
var vocabularyURL = "<%=vocabularyURL%>";
var baseUrl = "<%=baseUrl%>";
var tbl = document.getElementById('DateDescription');
var tbody = tbl.getElementsByTagName('tbody')[0];
var tr_base = tbody.getElementsByTagName("tr")[0];
var unique_array = [];
var planList = [];
var tbl, tbody, tr_base;
var tr;
var appoint_data = [];
var unique_array = {};
var _emptydata = 0;
var invigilatorAppointmentModel = "InvigilatorAppointment";
var ScheduleData = {};
var briefingScheduleData = {};
var scheduleModel = "Schedule";
var notifyAppointmentModel = "NotifyAppointment";
AUI().use('event-base', function (A) {
	A.on('domready', function (thisInstance) {
		getScheduleProgramme();
		getScheduleBriefing();
	});
});
function onChecked1() {
	var obj;
	var count = 0;
	var form = document.getElementById("myform");
	for (var i = 0; i < form.elements.length; i++) {
		obj = form.elements[i];
		if (obj.type == "checkbox" && obj.checked) {
			count++;
		}
	}
	var test = document.getElementById('selected');
	test.innerText = count;
}
function getAppointDataOnInvigilator() {
	var e = document.getElementById("programmeSchedule");
	var value = e.options[e.selectedIndex].value;
	var text = e.options[e.selectedIndex].text;
	getInvigilatorsForSchedule(value);
	var res = value.split("|");
	getScheduleData(res[0]);
	
	getSchedulePriceSchemeData(res[0]);
}
var leadName = "";
function drawTable() {
	while (tbody.hasChildNodes()) {
		tbody.removeChild(tbody.lastChild);
	}
	debugger;
	var test = document.getElementById('available');
	test.innerText = planList.length;
	for (var i = 0; i < planList.length; i++) {
		tr = tr_base.cloneNode(true);
		var object = planList[i];
		var date = object.Date;
		//date = date.split('|');
		tr.getElementsByClassName("Invigilator")[0].innerHTML = object.FullName;
		tr.getElementsByClassName("appointType")[0].innerHTML = object.AppointType;
		tr.getElementsByClassName("invDate")[0].innerHTML = date;
		tr.getElementsByClassName("invSessioinType")[0].innerHTML = object.SessionType;
		tr.getElementsByClassName("checked")[0].id = object.UserId;
		tr.getElementsByClassName("checked")[0].value = JSON.stringify(object);	
		tbody.appendChild(tr);
		if(object.Lead){
			leadName = object.FullName;
		}
	}
}

function NotificationPopUpSucess(){	
	var boundingBox = "#sucess-popup";
	var contentBox = "#sucess-popup-box";
	AUI().use('aui-base', function(A) {
		 A.one(boundingBox).set('hidden', false);
      
      YUI().use('aui-modal', function(Y) {
         var modal = new Y.Modal({
                         boundingBox: boundingBox,
                         contentBox: contentBox,
                         headerContent: '',
                         centered: true,
                         destroyOnHide: false,
                         modal: true,
                         resizable: false,
                         draggable: false,
          }).render();
         
         
          Y.one('.close').on(
          	      'click',
          	      function() {          	    	  
          	        modal.hide();
          	      location.reload();
          	      }
          	    );
      });

  });
}
var checked = new Array();
var sendNotificationClicked = false;
function sendNotification(e) {
	if(!sendNotificationClicked){
		showLoadingCommon(true);
		mode = "edit";
		var _data = {};
		var _data1 = {};
		getChcked();
		var e1 = document.getElementById("programmeSchedule");
		var value = e1.options[e1.selectedIndex].value;
		var e = document.getElementById("schedule");
		var date = document.getElementById(namespace + "startDate").value;
		sendNotificationClicked = true;
		document.getElementById("sendBtn").innerHTML = "SENDING";
		_data.schedule = "";
		_data.deadlineDate = date;
		_data.appointStatus = "Pending Confirmation";
		_data.appointData = unique_array;
		_data.formType = notifyAppointmentModel;
		_data.ModelName = notifyAppointmentModel;
		_data.subPriceSchemes = subPriceSchemes;
		_data.priceSchemes = priceSchemes;
		_data.scheduleName = ScheduleData.contentJson.Name;
		_data.scheduleData = ScheduleData;
		_data.briefingScheduleData = briefingScheduleData;
		_data.leadName = leadName;
		_data.UserId = userId;
		
		ajaxCallAPI('POST', 'sendNotification', _data, function () {
			var response = this.get("responseData");
			showLoadingCommon(false);
			NotificationPopUpSucess();
			
		}, function () {});
	}
	
}
function checkAll(ele) {
	var checkboxes = document.getElementsByTagName('input');
	if (ele.checked) {
		for (var i = 0; i < checkboxes.length; i++) {
			if (checkboxes[i].type == 'checkbox') {
				checkboxes[i].checked = true;
			}
		}
	} else {
		for (var i = 0; i < checkboxes.length; i++) {
			if (checkboxes[i].type == 'checkbox') {
				checkboxes[i].checked = false;
			}
		}
	}
	onChecked1();
}
function randomString(length) {
    return Math.round((Math.pow(36, length + 1) - Math.random() * Math.pow(36, length))).toString(36).slice(1).toUpperCase();
}
function getChcked() {
	var repeat = new Array();
	var newrepeat = [];
	unique_array = {};
	var form = document.getElementById('myform'); 
	var chks = form.querySelectorAll('input[type="checkbox"]:checked');
	for (var i = 0; i < chks.length; i++) {
		if (unique_array.hasOwnProperty(chks[i].id) == false) {
			newrepeat = [];
		} else {
			newrepeat = unique_array[chks[i].id];
		}
		var parsedJSON = JSON.parse(chks[i].value);
		parsedJSON.AppointmentStatus = "Pending Confirmation";
		parsedJSON.InvigilatorGenID = "SCH"+parsedJSON.ScheduleModelId+"INV"+parsedJSON.UserId;
		newrepeat.push(parsedJSON);
		unique_array[chks[i].id] = newrepeat;
	}
	
	console.log(unique_array);
}
var invigilatorName = [];
var i = 0
function onChecked(e) {
	i = i + 1;
	var tr = e.parentElement.parentElement;
	var checkedValue = document.querySelector('.checked:checked').value;
	setTimeout(function () {
		for (var j = 0; j > i; j++) {
			invigilatorName[i] = checkedValue;
		}
	}, 0);
}
function getInvigilatorsForSchedule(scheduleId) {
	var data1 = {};
	if (_emptydata == 0) {
		document.getElementById('table_row').removeAttribute("style");
		_emptydata++;
	}
	var filterdata = [];
	data1.formStorageId = userId;
	data1.formType = invigilatorAppointmentModel;
	var itemsSelect = document.getElementById(namespace + "itemsPerPage");
	var jsonsearchparameter = {
		"modelName": invigilatorAppointmentModel,
		"formType": invigilatorAppointmentModel
	};
	jsonsearchparameter["conditions"] = "";
	var filter = {};
	filter["contentJson.ScheduleId"] = [scheduleId];
	filter["contentJson.AppointmentStatus"] = ["Pending Notification"];
	filterdata.push(filter);
	
	jsonsearchparameter["filterdata"] = filterdata;
	ajaxCall('GET', 'elastiSearchList', elastisearchlisturl, jsonsearchparameter, function () {
		var response = this.get("responseData");
		if (_.isEmpty(response)) {} else {
			planList = [];
			var s = "";
			for (var i = 0; i < response.content.length; i++) {
				var item = response.content[i].contentJson;
				item.storageId = response.content[i].storageId;
				planList.push(item);
			}
			drawTable();
		}
	}, function () {});
}
function getScheduleData(scheduleId) {
	
	data1 = {};
	data1.formStorageId = scheduleId;
	data1.formType = "Schedule";
	ajaxCall('GET', 'loadData', elastisearchlisturl, data1, function () {
		var response = this.get("responseData");
		if (_.isEmpty(response)) {} else {
			ScheduleData = response;
		}
	}, function () {});
}
function getBriefingScheduleData() {
	var briefingscheduleId =  document.getElementById("briefingschedule").value;
	if(briefingscheduleId != ""){
		data1 = {};
		data1.formStorageId = briefingscheduleId;
		data1.formType = "Schedule";
		ajaxCall('GET', 'loadData', elastisearchlisturl, data1, function () {
			var response = this.get("responseData");
			if (_.isEmpty(response)) {} else {
				briefingScheduleData = response;
			}
		}, function () {});
	}
}
var ee;
var subPriceSchemes;
var priceSchemes;
function getSchedulePriceSchemeData(scheduleId) {
	//scheduleId = "U-ACAFN";
	var data = {
		"formType" : "EntityLink",
		"linkType":"SchedulePriceSchemeEntityLink",
		"endPoint":"fetchPricing/"+scheduleId + "/SchedulePriceSchemeEntityLink",
		"formStorageId" : encodeURIComponent(scheduleId)
	};
	ajaxCall('GET', 'sendRequest', elastisearchlisturl, data, function () {
		var response = this.get("responseData");
		if (_.isEmpty(response)) {} else {
			debugger;
			subPriceSchemes = response.subPriceSchemes;
			priceSchemes = response.priceSchemes;
		}
	}, function () {});
	
}

function getScheduleBriefing() {
	var data1 = {};
	var filterdata = [];
	data1.formStorageId = userId;
	data1.formType = scheduleModel;
	var itemsSelect = document.getElementById(namespace +  "itemsPerPage");
	
	var jsonsearchparameter = {
		"modelName": scheduleModel,
		"formType": scheduleModel
	};
	jsonsearchparameter["conditions"] = "";
	var filter = {};
	filter["contentJson.Category"] = ["Briefing"];
	filterdata.push(filter);
	var options1 = '';
	jsonsearchparameter["filterdata"] = filterdata;
	ajaxCall('GET', 'elastiSearchList', elastisearchlisturl, jsonsearchparameter, function () {
		var response = this.get("responseData");
		if (_.isEmpty(response)) {} else {
			planList = [];
			var s = "";
			options1 += '<option>Please Select Schedule (Briefing)</option>';
			for (var i = 0; i < response.content.length; i++) {
						            		     		    
				options1 += '<option value="' + response.content[i].contentJson.ScheduleCode + '">' + response.content[i].contentJson.ScheduleCode + '</option>';
				
			}
			document.getElementById('briefingschedule').innerHTML = options1;
			
		}
	}, function () {});
}
//
/* Date picker */
/** ****************** Date Piker ********************* */
var d = new Date();
var m = (d.getMonth() + 1);
var t = d.getDate();
var y = d.getFullYear();
var s = m + "/" + t + "/" + y;
var today = stringToDate(s, "mm/dd/yyyy", "/");
var toDatepicker;
YUI().use('aui-datepicker', 'aui-form-validator', function (Y) {
	var toDatePicker;
	var fromDatePicker = new Y.DatePicker({
		trigger: '#' + namespace + 'startDate',
		mask: '%d/%m/%Y',
		popover: {
			zIndex: 1
		},
		calendar: {
			dateFormat: '%Y-%m-%d',
			minimumDate: today,
		},
		on: {
			selectionChange: function (event) {
				if (event.newSelection[0]) {
					toDatePicker.getCalendar().set('minimumDate', event.newSelection[0]);
				} else {
					toDatePicker.getCalendar().set('minimumDate', today);
				}
			}
		}
	});
	toDatePicker = new Y.DatePicker({
		trigger: '#' + namespace + 'endDate',
		mask: '%d/%m/%Y',
		popover: {
			zIndex: 1
		},
		calendar: {
			dateFormat: '%Y-%m-%d',
			minimumDate: today,
		},
		on: {
			selectionChange: function (event) {
				fromDatePicker.getCalendar().set('minimumDate', today);
			}
		}
	});
	new Y.DatePicker({
		trigger: '#' + namespace + 'endOn',
		mask: '%d/%m/%Y',
		popover: {
			zIndex: 1
		},
		calendar: {
			dateFormat: '%Y-%m-%d',
			minimumDate: today,
		},
		on: {
			selectionChange: function (event) {
				console.log("hello");
			}
		}
	});
});
setInterval(function () {
	//run();
}, 2000);
function stringToDate(_date, _format, _delimiter) {
	var formatLowerCase = _format.toLowerCase();
	var formatItems = formatLowerCase.split(_delimiter);
	var dateItems = _date.split(_delimiter);
	var monthIndex = formatItems.indexOf("mm");
	var dayIndex = formatItems.indexOf("dd");
	var yearIndex = formatItems.indexOf("yyyy");
	var month = parseInt(dateItems[monthIndex]);
	month -= 1;
	var formatedDate = new Date(dateItems[yearIndex], month, dateItems[dayIndex]);
	return formatedDate;
}
/* end date picker	
 */
function getScheduleProgramme() {
	var invigilatorData = {};
	invigilatorData.formStorageId = userId;
	invigilatorData.formType = "NotifyAppointment";
	var userid = '';
	var options1 = '';
	var newdata = {};
	invigilatorData.limit = "1000";
	invigilatorData.page = 0;
	invigilatorData.filterdata = [];
	ajaxCallAPI('GET', 'uniquedata', invigilatorData, 
			
		function () {
			var response = this.get("responseData");
			if (_.isEmpty(response)) {
				console.log("error");
			} else {
				options1 += '<option>Please Select Schedule (Programe)</option>';
				for (var i = 0; i < response.data.length; i++) {
							            		     		    
					options1 += '<option value="' + response.data[i].txt + '">' + response.data[i].txt + '</option>';
					
				}
				document.getElementById('programmeSchedule').innerHTML = options1;
			}
		}, 
		function () {
			
		});
}
</script>
<style type="text/css">
.aui input[type=checkbox]:checked, .aui input[type=checkbox] {
	opacity: 1 !important;
	display: block;
}
</style>
<%
	}
%>
