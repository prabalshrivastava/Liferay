<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@page import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.spservices.model.SPListType"%>
<%@page import="java.util.List"%>
<%@page import="com.fasterxml.jackson.databind.SerializationFeature"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' type="text/css"
	href='/SPFinance-portlet/css/main.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css" href='/SPFinance-portlet/css/portlet.css?minifierType=css'></link>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2"></script>
<script type="text/javascript" src="/SPFinance-portlet/js/billing.js?<%=System.currentTimeMillis()%>" language="javascript1.2"></script>
<%@ taglib	uri="/tld/sp-formio" prefix="sp-formio"%> 
<portlet:defineObjects />
<div class="newPortlets">
<% if(PermissionUtil.canAddModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
<%
ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
Long groupId = themeDisplay.getLayout().getGroupId();
long userId = themeDisplay.getUserId();
String formId = "2038";
String dashBoardLink = SambaashUtil.getDashBoard();
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:MM");
String serverCurrDate = sdf.format(new Date());
List<SPListType> claimTypeList = SPListTypeLocalServiceUtil.getByKey("finance.payment.claimType", groupId);
ObjectMapper objectMapper = new ObjectMapper();
objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
String storageId = request.getParameter("storageId");
%>
<style>
	table {
		margin-left: 0px !important;
	    margin-right: 0px !important;
	    margin-top: 16px !important;
	    width: 100% !important;
	    border: solid 2px #b1bed761;
    	border-collapse: separate !important;
	 /* display:block !important; */
	}
	table td {
		border-bottom: solid 1px #dfe3e6;
	}
	#claimTableId th {
		height : 52px
	}
	.formContainer {
	padding-top: 53px !important;
	}
	#claimTableId tr {
		border-bottom: 1px solid #dcdcdc !important;
	}

	.claim-status{
		padding: 5px 18px !important;
		border-radius: 15px;
		width: 100%;
	    padding: 2px 10px;
        text-align: center;
        background-color:#d5d5d5;
        text-overflow: ellipsis;
	    white-space: nowrap;
	    overflow: hidden;
	    display: inline-block;
    	max-width: 150px;
	}
	
	.choices__input {
	    width: 100% !important;
	}
	
	.claim-multi-select.formio-choices.form-group {
    	width: 550px !important;
	}
	
	.claim-multi-select.choices__input {
		width: 100% !important;
	}
	
	.aui .newPortlets .formContainer table tr td .formio-choices div.form-control {
	    padding-left: 0px !important;
	    padding-right: 0px !important;
	}
	.choices__input {
		margin-bottom: 0px !important;
	}
	.formio-component-claimType {
		margin-bottom: 0px !important
	}
	.zrecords {
	font-size: 32px!important;
    font-weight: 300!important;
    font-style: normal!important;
    font-stretch: normal!important;
    line-height: 1.09!important;
    letter-spacing: normal!important;
    text-align: center!important;
    color: #45769c!important;
    padding-left: 249px;
	}
	
	.claim-success-box .modal-header {
		display: none
	}
	.claim-success-box .modalpopupContent .formContainer {
		padding-top: 10px !important;
	}
	.claim-success-box .modalpopupContent h3 {
    	   line-height: 66px;
	}
	.aui .newPortlets .claim-success-box.modal .modal-content h3:before {
		margin-bottom: 100px;
		padding-top: 0;
    	margin-top: -13px;
	}
	.claim-success-box .modalpopupContent{
		height: 256px;
    	min-height: 100px;
	}
	.claim-success-box button{
		margin-top: 9px;
	}
	.alert-danger {
		margin-right: 160px;
    	margin-left: 160px;
	}
</style>
<div class="subHeader">
	<div class="container">
		<div class="inner-container">
		<aui:row>
			<aui:col span="10" cssClass="text-center"><h2><span>PREPARE CLAIMS</span></h2></aui:col>
			<aui:col span="2" cssClass="text-right"><a href="<%= dashBoardLink %>" title="Back to Home">Back to Home</a></aui:col>
		</aui:row>
		</div>
		<div style="display: none; margin-top:25px;" class="alert alert-danger"
							role="showAlert" id="alert_msg_pId">Select Facility Type.</div>
	</div>
	<div id="sucess-popup" hidden="true" class="claim-success-box modalpopupBox" style="margin-top: 150px !important;">
		<div id="sucess-popup-box" class="modalpopupContent">
			<form class="formContainer" action="">
				<aui:row>
					<aui:col span="12">
						<h3 id="success-msg">Claim Prepared Successfully</h3>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12">
						<button type="button"
							class="btn btn-primary popup-confirm-archive pull-left"
							onClick="reloadPage()">Start Again</button>
						<button type="button"
							class="btn btn-default pull-right"
							onClick="goBack()">Go Back</button>
					</aui:col>
				</aui:row>
			</form>
		</div>
	</div>
	<div id="notification-sucess-popup" hidden="true" class="claim-success-box modalpopupBox" style="margin-top: 150px !important;">
		<div id="notification-sucess-popup-box" class="modalpopupContent">
			<form class="formContainer" action="">
				<aui:row>
					<aui:col span="12">
						<h3 id="success-msg">Notification(s) sent successfully !!</h3>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12">
						<button type="button"
							class="btn btn-primary popup-confirm-archive pull-left"
							onClick="reloadPage()">Start Again</button>
						<button type="button"
							class="btn btn-default pull-right"
							onClick="goBack()">Go Back</button>
					</aui:col>
				</aui:row>
			</form>
		</div>
	</div>
</div>
<div class="loadingDiv" id="loadingDiv">
	<div class="m-blockui"
		style="position: fixed; z-index: 1031; left: 50%; top: 50%; ">
		<span>Please Wait</span> <span>
			<div class="m-loader m-loader--brand"></div>
		</span>
	</div>
</div>
<c:set var="formId" value="<%= formId %>"/>
<c:set var="formType" value='<%= request.getParameter("formTypeName") %>' />
<sp-formio:FormIO cssClass="formContainer formPadding"  modelName ="${formType}" 
	formId="${formId}" readOnly="false" formStorageId="0" />
</div>

<script type="text/javascript">
var selInvigilatorId = "<%=storageId%>";
var formInstance;
var table;
var tableHead;
var tableBody; 
var mode = "view";
var formFor = "FINANCE";
var claimMap = {};
var dbClaimRecordMap = {};
var modelName = "PreparedClaim";
var claimTypeList = <%=objectMapper.writeValueAsString(claimTypeList)%>;
var claimTypeMap = {};

function afterFormLoadedFormIOForm(thisInstance){
	formInstance = thisInstance;
	/* setInterval(function() {
		checkCPForm(thisInstance);
	}, 1); */
	initForm(thisInstance);
	formInstance.on('partial', function(changePayload) {
		if (changePayload.changed.component.key === "invigilatorId") {
			showLoading(true);
			var invigilatorId = formInstance.form.submission.data.invigilatorId;
			rmvRow();
			onChangeInvigilator(invigilatorId);
		}
	});
	document.getElementsByClassName("prepare-claim-btn")[0]
	.addEventListener("click",function() {
		console.log("checkIsValide() : "+checkIsValide());
		if(checkIsValide()){
			var claims = getSelectedData(thisInstance.form.submission.data.invigilatorId);
			console.log("1");
			console.log(claims);
			saveClaimFn(claims, function(){
				console.log("dbClaimRecordMap");
				console.log(dbClaimRecordMap);
				for(var key in dbClaimRecordMap){
					var claimMap = dbClaimRecordMap[key];
					for(var k in claimMap){
						if(claimMap[k] && isScheduleSelected(key)){
							var data = {"formType":modelName,"formStorageId": k };
							console.log("data");
							console.log(data);
							ajaxCallAPI('GET', 'archive',data, function() {
								showLoading(false);
							}, function() {
								showLoading(false);
							});
						}
					}
				}
				_afterFormSubmissionFormIOForm({});
				
			});
		}
	});
	document.getElementsByClassName("notifyInvigilator")[0].addEventListener("click", function(e) {
		notifyInvigilator();
	});
}

function isScheduleSelected(scheduleId) {
	console.log("scheduleId : "+scheduleId);
	var rows = tableBody.rows;
	var len = rows.length;
	for(var i=0;i<len;i++){
		var row = rows[i];
		var claimStatus = row.cells[2].getElementsByTagName("p")[0].innerHTML;
		var schId = row.cells[0].innerHTML;
		var isChecked = row.cells[3].getElementsByTagName("input")[0].checked;
		if(isChecked && schId==scheduleId){
			return true;
		}
	}
	return false;
}

function _afterFormSubmissionFormIOForm(data) {
	console.log("data : " + JSON.stringify(data));
	console.log("data.formStorageId : " + data.formStorageId);
	var status = data.Status;
	var formType = "Prepared Claim";
	console.log("status : " + status);
	var msg = "";
	var boundingBox = "#sucess-popup";
	var contentBox = "#sucess-popup-box";
	if (data.formStorageId == "0" || data.formStorageId == ""
			|| data.formStorageId == null
			|| typeof data.formStorageId === 'undefined') {
		msg = formType + " Created!";
	} else if (status == "Active" && data.reactive) {
		msg = formType + " Updated!";
		boundingBox = "#activation-success";
		contentBox = "#active-success-box";
	} else if (status == "Active") {
		msg = formType + " Updated!";
	} else if (status == "Inactive") {
		msg = formType + " Updated!";
		boundingBox = "#deactivation-success";
		contentBox = "#inactive-success-box";
	} 
	if (status == "Notified") {
		boundingBox = "#notification-sucess-popup";
		contentBox = "#notification-sucess-popup-box";
		msg = "Notification(s) sent successfully !!";
	}
	console.log("formType : "+formType);
	document.getElementById('success-msg').innerHTML = msg;
	AUI().use('aui-base', function(A) {
		A.one(boundingBox).set('hidden', false);
		YUI().use('aui-modal', function(Y) {
			new Y.Modal({
				boundingBox : boundingBox,
				contentBox : contentBox,
				headerContent : '',
				centered : true,
				destroyOnHide : false,
				modal : true,
				resizable : false,
				draggable : false,
			}).render();
			Y.one('.close').hide();
		});
	});
}

function saveClaimFn(claims, callback){
	if(claims.length==0) {
		callback();
		return;
	}
	var count = 0;
	for(var l=0;l<claims.length;l++){
		claims[l].formType = "preparedclaim";
		console.log("inside persist ");
		console.log(claims[l]);
		console.log(dbClaimRecordMap);
		console.log(dbClaimRecordMap[claims[l].ScheduleID]);
		if(!claims[i].formStorageId) {
			claims[l].ClaimStatus = "PENDING NOTIFICATION";
		}
		if(dbClaimRecordMap[claims[l].ScheduleID]){
			var map = dbClaimRecordMap[claims[l].ScheduleID]
			if(map[claims[l].PreparedClaimCode]){
				console.log("inside edit : "+claims[l].ScheduleID);
				map[claims[l].PreparedClaimCode] = false;
				dbClaimRecordMap[claims[l].ScheduleID] = map;
				claims[l].formStorageId = claims[l].PreparedClaimCode;
			}
		}
		showLoading(true);
		console.log("claims");
		console.log(claims);
		ajaxCallAPI('POST', 'persist', claims[l], function() {
			console.log("Save sucessfully");
			if(count == (claims.length-1)){
				callback();
			}
			count++;
			showLoading(false);
		}, function() {
			console.log("Error here");
			showLoading(false);
		});
	}
}

function PreparedClaim(PreparedClaimCode, ClaimType, Status, ClaimStatus, InvigilatorID, ScheduleID){
	 this.PreparedClaimCode = PreparedClaimCode;
	 this.ClaimType = ClaimType;
	 this.Status = Status;
	 this.ClaimStatus = ClaimStatus;
	 this.InvigilatorID = InvigilatorID;
	 this.ScheduleID = ScheduleID;
}

function generateClaimCode() {
	var date = new Date();
	var now_utc =  Date.UTC(date.getUTCFullYear(), date.getUTCMonth(), date.getUTCDate(),
			 date.getUTCHours(), date.getUTCMinutes(), date.getUTCSeconds());
	return "C-"+now_utc;
}

function onChangeInvigilator(invigilatorId){
	getScheduleListByInvigilator(invigilatorId);
};

function getScheduleListByInvigilator(id){
	var datas = {};
	datas.formType = "invigilatorappointment";
	datas.conditions = ["contentJson.UserId="+id,"size="+2147483647,"sort=created_date,desc"];
	ajaxCallAPI(
			'GET',
			"searchList",
			datas,
			function(response) {
				var list = this.get("responseData").content;
				console.log(list);
				setClaimModel(list, id);
			}, function() {
				showLoading(false);
			});
}

function setClaimModel(list, id){
	claimMap = {};
	dbClaimRecordMap = {};
	if(list && list.length > 0){
		getClaimMapDetail(list, id, function(map){
			setDataInTable(map);	
		});
	}else{
		setDataInTable(claimMap);
		addNoRecordRow();
	}
}

function getClaimMapDetail(list, invigilatorId, callback){
	var count = 0;
	for(var i=0;i<list.length ;i++){
		var c= list[i];
		getPreparedClaimBySchdIdInvigId(c.scheduleId, invigilatorId, function(pcList, schId){
			var lst = [];
			console.log("pcList");
			console.log(pcList);
			if(pcList && pcList.length > 0){
				for(var key=0;key<pcList.length;key++){
					if(claimMap[schId] == null){
						lst = [];
					}else{
						lst = claimMap[schId];
					}
					lst.push(pcList[key].contentJson);
					claimMap[schId] = lst;
					var map = {}
					if(dbClaimRecordMap[schId] == null){
						dbClaimRecordMap[schId] = {};
					}else{
						map = dbClaimRecordMap[schId];
					}
					map[pcList[key].contentJson.PreparedClaimCode] = true;
					console.log("schId : "+schId);
					dbClaimRecordMap[schId] = map;
				}
				
			}else{
				lst = [];
				lst.push(new PreparedClaim(generateCode("IC-"), "", "Active", "New",invigilatorId, schId));
				console.log("--"+schId);
				claimMap[schId] = lst;
			}
			if(count == list.length - 1) {
				callback(claimMap);
	        }
			count++;
			
		});
	}
}


function getPreparedClaimBySchdIdInvigId(schdId, invigId, callback){
	var datas = {};
	datas.formType = "preparedclaim";
	datas.conditions = ["contentJson.InvigilatorID="+encodeURI(invigId),"contentJson.ScheduleID="+encodeURI(schdId),"size="+2147483647,"sort=created_date,desc"];
	ajaxCallAPI(
			'GET',
			"searchList",
			datas,
			function(response) {
				if(this.get("responseData")) {
					var list = this.get("responseData").content;
					callback(list, schdId);
				} else {
					callback([], schdId);
				}
			}, function() {
				showLoading(false);
			});
}

function initForm(thisInstance){
	createTableHeader();
	thisInstance.components.SaveDraft.buttonElement.style.display = "none" ;
	claimTypeMap = {};
	for(var ct=0;ct<claimTypeList.length;ct++){
		claimTypeMap[claimTypeList[ct].displayName] = claimTypeList[ct].spListTypeId;
	}
	console.log("selInvigilatorId : "+selInvigilatorId);
	if(selInvigilatorId) {
		formInstance.components.invigilatorId.setValue(selInvigilatorId);
		formInstance.components.invigilatorId.disabled = true;
	}
}

function setDataInTable(listMap){
	for(var listKey in listMap){
		 var list = listMap[listKey];
		var  ctList = [];
		for(var i=0;i<list.length;i++){
			if(list[i].ClaimType && list[i].ClaimType != ""){
				 ctList.push(list[i].ClaimType);
			}
		}
		addRow(list[0], ctList);
	}
	showLoading(false);
}

function addNoRecordRow() {
	var newRow = tableBody.insertRow(tableBody.rows.length);
	var newCell  = newRow.insertCell(0);
	newCell.style.textAlign = "center";
	newCell.colSpan=3;
	newCell.style.padding = "50px";;
	newCell.innerHTML = "<img src='<%=request.getContextPath()%>/images/no-record.png' /><label class='zrecords'>0 Records</label>";
}

function addRow(data,  ctList){
	var newRow = tableBody.insertRow(tableBody.rows.length);
	// Insert a cell in the row at index 0
	var newCell  = newRow.insertCell(0);
	newCell.appendChild(document.createTextNode(data.ScheduleID));
	
	newCell  = newRow.insertCell(1);
	newCell.appendChild(createSelect(data.ScheduleID,  ctList));
	
	newCell  = newRow.insertCell(2);
	newCell.style.textAlign = "center";
	newCell.style.color = "black";
	newCell.appendChild(createStatusElm(data.ClaimStatus));
	
	newCell  = newRow.insertCell(3);
	newCell.appendChild(createCheckBox(data.ScheduleID, data.InvigilatorID));
}

function getSelectedData(invigilatorId){
	var claimList = [];
	var rows = tableBody.rows;
	var len = rows.length;
	for(var i=0;i<len;i++){
		var row = rows[i];
		var claimStatus = row.cells[2].getElementsByTagName("p")[0].innerHTML;
		var scheduleId = row.cells[0].innerHTML;
		var isChecked = row.cells[3].getElementsByTagName("input")[0].checked;
		if(isChecked){
			var sel = row.cells[1].getElementsByTagName("select")[0];
			var selLen = sel.options.length;
			 for ( var j = 0; j < selLen; j++ ) {
	            opt = sel.options[j];
	            if ( opt.selected === true ) {
	            	var claimObjList =  claimMap[scheduleId];
	            	var claimObject = null;
	            	var div = opt;
	            	var value = div.getElementsByClassName("calim-class")[0].innerHTML;
	            	for(var index = 0; index<claimObjList.length; index++){
	            		if(claimObjList[index].ClaimType == claimTypeMap[value]){
	            			claimObject = {};
	            			claimObject = claimObjList[index];
	            		}
	            	}
	            	console.log("claimObject");
	            	console.log(claimObject);
	            	if(claimObject == null){
	            		claimObject = {};
	            		console.log("new...");
	            		claimObject = new PreparedClaim(generateCode("IC-")+""+i+""+j,claimTypeMap[value], "Active", claimStatus, invigilatorId, scheduleId);
	            		console.log("new..."+claimObject.PreparedClaimCode);
	            	}
	            	claimList.push(claimObject); 
	            }
	        }
		}
	}
	
	return claimList;
}

function createSelectFn(elm, ctList){
	var mlist = [];
	var sltList = [];
	for(var i=0;i<claimTypeList.length;i++){
		 if(ctList.includes(claimTypeList[i].spListTypeId)){
			 sltList.push(claimTypeList[i])
		 }else{
			 mlist.push(claimTypeList[i]);
		 }
	}
	
	Formio.createForm(elm, {
		  components: [
		    {
		    	autofocus: false,
	    	  	input: true,
	    	  	tableView: true,
	    	  	label: "",
	    	  	key: "claimType",
	    	  	placeholder: "Search and add a Claim Type",
				data: {
					json: JSON.stringify(mlist)
				},
				dataSrc: "json",
				template: "<span class=" + "calim-class" + ">{{ item.displayName }}</span>",
				defaultValue: sltList,
				multiple: true,
				type: "select",
				labelPosition: "top",
				tags: [
				  
				]
		    }
		  ]
		});
	elm.setAttribute('class', 'claim-multi-select');
}

function rmvRow(){
	var rows =  tableBody.rows;
	var len = rows.length;
	for( var i=len-1;i>=0; i--){
		tableBody.deleteRow(i);
	}
}

function createStatusElm(status){
	var p = document.createElement("p");
	p.setAttribute("id", "claim-status");
	p.setAttribute("class", "claim-status");
	p.style.padding = "2px 0px;"
	if(status.toLowerCase() == "New".toLowerCase()){
		p.style.backgroundColor = "#d5d5d5"
	}
	if(status.toLowerCase() == "Notified".toLowerCase()){
		p.style.backgroundColor = "#ffd724"	
	}
	if(status.toLowerCase() == "Pending Notification".toLowerCase()){
		p.style.backgroundColor = "#ffc48b"
	}
	p.appendChild(document.createTextNode(status));
	return p;
}

function createSelect(id, claimTypeList){
	var select = document.createElement("div");
	select.setAttribute('id', id);
	createSelectFn(select, claimTypeList);
	return select;
}

function createCheckBox(id, name) {
	var label = document.createElement('label');
	label.setAttribute('for', name);
	label.setAttribute('id', id + name);
	
	var input = document.createElement('input');
	input.type = 'checkbox';
	input.setAttribute('class', 'form-control input-sm');
	input.setAttribute('id', id);
	label.appendChild(input);
	
	var span = document.createElement('span');
	span.innerHTML = "";
	span.addEventListener('click', function(event) {
		if(input.checked) {
			input.checked = false;
		} else {
			input.checked = true;
		}
		if(id == "selectAllId"){
			checkAllCheckbox(input.checked);
		}else{
			checkUncheckMain();
		}
	});
	label.appendChild(span);
	return label;
}

function checkAllCheckbox(value){
	var rows = tableBody.rows;
	for(var i=0;i<rows.length;i++){
		var row = rows[i];
		row.cells[3].getElementsByTagName("input")[0].checked = value;
	}
}

function checkUncheckMain(){
	var rows = tableBody.rows;
	var count = 0;
	for(var i=0;i<rows.length;i++){
		var row = rows[i];
		var isChecked = row.cells[3].getElementsByTagName("input")[0].checked;
		if(isChecked){
			count = count + 1;
		}
	}
	if(count == rows.length){
		document.getElementById("selectAllId").checked = true;
	}else{
		document.getElementById("selectAllId").checked = false;
	}
}

function checkCPForm(thisInstance) {
	/* if(checkIsValide(thisInstance)) {
		thisInstance.components.Submit.disabled = false;
	} else {
		thisInstance.components.Submit.disabled = true;
	} */
}


function checkIsValide(thisInstance) {
	var eValid = true;
	 var invigilatorId = formInstance.form.submission.data.invigilatorId;
	 if(invigilatorId == ""){
		 eValid = false;
		 _displayMessageHere('danger', "Invigilatory is Mandatory", 3000);
	 }else{
		 eValid =  checkIfAllChecked();
	 }
	 
	 var claims = getSelectedData(formInstance.form.submission.data.invigilatorId)
	 for(var l=0;l<claims.length;l++){
		 console.log("claims[l].ClaimStatus.toLowerCase() : "+claims[l].ClaimStatus.toLowerCase());
		 if(claims[l].ClaimStatus.toLowerCase() == "notified") {
			 eValid = false;
			 _displayMessageHere('danger', "Claim with NOTIFIED status can not be updated.", 3000);
			 break;
		 }
	 }
	 
	 return eValid;
}

function checkIfAllChecked(){
	var rows = tableBody.rows;
	var len = rows.length;
	var count = 0;
	var claimTypeCount = 0;
	for(var i=0;i<len;i++){
		var row = rows[i];
		var isChecked = row.cells[3].getElementsByTagName("input")[0].checked;
		if(isChecked){ 
			count++;
			var sel = row.cells[1].getElementsByTagName("select")[0];
			var selLen = sel.options.length;
			var sCount = 0;
			for ( var j = 0; j < selLen; j++ ) {
	            opt = sel.options[j];
	            if ( opt.selected === true ) {
	            	sCount++;
	            }
	        }
			 if(sCount > 0){
				 claimTypeCount++;
			 }
		}
	}
	if(count == 0){
		_displayMessageHere('danger', "Select atleast One Schedule", 3000);
		return false;
	}
	return true;
}
			
function createTableHeader(){
	var title = ['Session Schedule', 'Type Of Claim(s)', 'Status'];
	table = document.querySelector('#claimTableId');
	var header = table.createTHead();
	tableHead = header;
	var row = header.insertRow(0);
	var headerCell = "";
	for (var i = 0; i < 3; i++) {
        headerCell = document.createElement("TH");
        headerCell.innerHTML = title[i];
        if(i==0){
        	headerCell.style.width = "30%";
        }
        if(i==1){
        	headerCell.style.width = "40%";
        }
        if(i==2){
        	headerCell.style.width = "20%";
        }
        row.appendChild(headerCell);
    }
	headerCell = document.createElement("TH");
	headerCell.appendChild(createCheckBox("selectAllId", "invigilator-checkbox"));
	headerCell.style.width = "10%";
	row.appendChild(headerCell);
	tableBody = table.createTBody();
}

function showLoading(show) {
	if(show) {
		getEID("loadingDiv").style.display = "block";
	} else {
		getEID("loadingDiv").style.display = "none";
	}
}

function getEID(element) {
	return document.getElementById(element);
}

function _displayMessageHere(type, message, duration) {
	scrollToTop();
	var alert_div = document.getElementById("alert_msg_pId");
	alert_div.innerHTML = message;
	alert_div.classList.add("alert-" + type);
	alert_div.style.display = "block";
	setTimeout(function() {
		alert_div.style.display = "none";
	}, duration);
}

function notifyInvigilator() {
	showLoading(true);
	var claims = getSelectedData(formInstance.form.submission.data.invigilatorId);
	var newClaims = [];
	for(var i in claims) {
		var claim = claims[i];
		if(claims[i].ClaimStatus == "PENDING NOTIFICATION") {
			newClaims.push(claim);
		}
	}
	if(newClaims.length==0) {
		_displayMessageHere('danger', "Select atleast one schedule with status pending notification.", 6000);
		showLoading(false);
		return;
	}
	
	ajaxCallAPI('POST', 'notifyInvigilator', newClaims, function() {
		var resp = this.get("responseData");
		console.log("resp : "+resp)
		if(resp=="success") {
			var count = 0;
			for(var l=0;l<newClaims.length;l++){
				newClaims[l].formType = "preparedclaim";
				if(newClaims[l].ClaimStatus == "PENDING NOTIFICATION") {
					newClaims[l].ClaimStatus = "NOTIFIED";
					if(dbClaimRecordMap[newClaims[l].ScheduleID]){
						var map = dbClaimRecordMap[newClaims[l].ScheduleID]
						if(map[newClaims[l].PreparedClaimCode]){
							console.log("inside edit : "+newClaims[l].ScheduleID);
							map[newClaims[l].PreparedClaimCode] = false;
							dbClaimRecordMap[newClaims[l].ScheduleID] = map;
							newClaims[l].formStorageId = newClaims[l].PreparedClaimCode;
						}
					}
					
					ajaxCallAPI('POST', 'persist', newClaims[l], function() {
						console.log("Save sucessfully");
						if(count == (newClaims.length-1)){
							showLoading(false);
							_afterFormSubmissionFormIOForm({Status:"Notified"});
						}
						count++;
					}, function() {
						console.log("Error here");
						showLoading(false);
					});
				}
			}
			
		} else {
			console.log("Error here");
			showLoading(false);
			_displayMessageHere('danger', "Error while sending notification(s).", 6000);
		}
	}, function() {
		console.log("Error here");
		showLoading(false);
		_displayMessageHere('danger', "Error while sending notification(s).", 6000);
	});
}
</script>
<% } %>