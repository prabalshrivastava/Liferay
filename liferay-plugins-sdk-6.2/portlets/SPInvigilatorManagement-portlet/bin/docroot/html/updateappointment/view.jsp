<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sambaash.platform.srv.spservices.model.SPListType"%>
<%@page import="java.util.List"%>
<%@page
	import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil"%>
<%@page
	import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalService"%>
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
	//String formId = portletPreferences.getValue(SystemSetupConstants.PREF_HTML_FORM_ID, "1720");
		String formType = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME,
				"InvigilatorAppointment");
		String dashBoardLink = SambaashUtil.getDashBoard();
		String storageId = request.getParameter("storageId");
		String userId = String.valueOf(themeDisplay.getUserId());
		String baseUrl = portletPreferences.getValue("baseUrlPref", "");
		String formStorageId = request.getParameter("storageId");
		ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
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
					<h2><span>UPDATE APPOINTMENT</span></h2>
				</aui:col>
				<aui:col span="2" cssClass="text-right">
					<a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</a>
				</aui:col>
			</aui:row>
			</div>
		</div>
	</div>

	<%-- <c:set var="formId" value="<%= formId %>"/> --%>
	<c:set var="formType" value='<%=formType%>' />
	<c:set var="formStorageId" value='<%=userId%>' />
	<div class="formRoot">
		<div class="innerFormRoot">
	<sp-formio:FormIO cssClass="formContainer" modelName="${formType}"
		formId="${formId}" readOnly="false" formStorageId="${formStorageId}" />
	
		<div class="formContainer container formio-form">
			<div class="formSection">

				<div class="row">
					<div class="col col-sm-9 col-sm-push-1">
						<div class="choices form-group formio-choices">
							<label class="control-label">Invigilator</label>
							<select id="invigilaotrdata" class="form-control"
							onChange=test()></select>
						</div>
						 
					</div>
				</div>
				<div class="row">
					<div class="col col-sm-12 timelineList">
						<table id="DateDescription" class="aui">
							<thead>
								<tr>
									<th>Date</th>
									<th>Session</th>
									<th>Appointment Type</th>
									<th>Venue</th>
									<th>Status</th>
									<th>Appointment Staus</th>

								</tr>
							</thead>
							<tbody>
								<tr id="table_row" style="display: none">
									<td><label class="date">12-12-2018</label></td>
									<td><label class="session">AM</label></td>
									<td><select class="appointmentype" id="appointmentype"
										onChange=onChecked(this)><option selected disabled hidden>Choose
													a type</option>
												<%
													List<SPListType> appointmentTypeList = SPListTypeLocalServiceUtil
																.getByKey("invigilators.appointment.type", groupId);
														for (SPListType type : appointmentTypeList) {
												%><option value="<%=type.getItemValue()%>"><%=type.getDisplayName()%></option>
												<%
													}
												%>
										</select></td>
									<td><label class="venue">8:00-12:00</label></td>
									<td><label class="status">12-12-2018</label></td>
									<td><select class="appointmentstatus" id="appointmentstatus" onChange=onChecked(this)>
										<option value="">Select Option</option>
										<option value="Accepted">Accepted</option>
										<option value="Pending Notification">Pending Notification</option>
										<option value="Pending Confirmation">Pending Confirmation</option>
										<option value="Rejected">Rejected</option>
										<option value="Confirmed">Confirmed</option>
									</select><label class="tvlID" style="display: none;"></label></td>
								</tr>
							</tbody>
						</table>

					</div>
					
		<div class="row">
			<div class="col col-sm-12 userAction" id="sub" style="display: none">
				<button type="button" id="bt_submit" onclick="submitForm(this)"
					class="btn btn-primary">Save</button>
				<button type="button" onclick="goBack();" class="btn btn-default">Cancel</button>
			</div>

		</div>
				</div>
			</div>
		</div>

		<!--  submit confirmation success -->
		<div class="yui3-skin-sam">
			<div id="sucess-popup1" hidden="true" class="modalpopupBox">
				<div id="sucess-popup-box1" class="modalpopupContent">

					<aui:row>
						<aui:col span="12">
							<h3 id="success-msg">Updated Sucessfully!</h3>
						</aui:col>

					</aui:row>
					<aui:row>
						<aui:col span="12" cssClass="text-center userAction">
							<button class="btn btn-default popup-confirm-archive pull-left"
										type="button" onClick="reloadPage()">Start Again</button>
							<button class="btn cancel btn-primary popup-cancel pull-right"
								type="button" onClick="goToDashboard()">Go Back</button>
						</aui:col>
					</aui:row>


				</div>
			</div>
		</div>

		<!-- ------------end---------------- -->

	<portlet:resourceURL var="elastisearchlisturl">
		<portlet:param name="action" value="elastiSearchList" />
	</portlet:resourceURL>
</div>
</div></div>


<script type="text/javascript">
var mode = "view";
var dontLoadData = true;
var documents;
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var appointmenttType = document.getElementById(namespace+"appointmenttype");
var userId = "<%=userId%>";
var formStorageId = "<%=formStorageId%>";
var vocabularyURL = "<%=vocabularyURL%>";
var baseUrl = "<%=baseUrl%>";
var elastisearchlisturl="<%=elastisearchlisturl%>";
var counter = 1;
tbl = document.getElementById('DateDescription');
tbody = tbl.getElementsByTagName('tbody')[0];
tr_base = tbody.getElementsByTagName("tr")[0];
var planList = [];
//var object = [];
var tbl, tbody, tr_base;

var subjectProgrammeList = [];

var table = document.getElementById("myTable");
    
	function test(){	 
	 var show = document.getElementById("table_row");
	  var dat = document.getElementById("DateDescription");
	  var e = document.getElementById("invigilaotrdata");
	  var value = e.options[e.selectedIndex].value;
	  var text = e.options[e.selectedIndex].text;
	  getDocumentId(null,value);  	
	}
			
	function getInvigilator(){
	var invigilatorData = {};
	invigilatorData.formStorageId = userId;
	invigilatorData.formType = "Invigilator";
	invigilatorData.limit = 2147483647;	
	invigilatorData.page = 0;	invigilatorData.filterdata = [];
	var userid = '';
	var options1 = '';
	ajaxCallAPI('GET','elastiSearchList',invigilatorData,
		 function() {				
               var response = this.get("responseData");               
               if (_.isEmpty(response)) {
                   console.log("error");                   
               } else {	
            	   options1 += '<option>Please Select Invigilator</option>'; 
            	  for(var i=0;i<response.content.length;i++)
            		 { 		            		              		 		            		     		    
            		  options1 += '<option value="' + response.content[i].contentJson.UserId + '">'
  					              + response.content[i].contentJson.FullName + "( "+response.content[i].contentJson.NRICNumberID +" )"+'</option>'; 
  					              userid = response.content[i].contentJson.UserId;
            		 }            	      
            	     document.getElementById('invigilaotrdata').innerHTML = options1;
	               }
	
           },
           function() {
               
    		});		
    }
			
AUI().use('event-base', function (A) {
	A.on('domready', function (thisInstance) {
		
		document.getElementById('formio').setAttribute("disabled","disabled");		
		getInvigilator();				
	});
		
})


var tr;
function drawTable() {
	debugger;
	while (tbody.hasChildNodes()) {
		tbody.removeChild(tbody.lastChild);
	}
	for (var i = 0; i < planList.length; i++) {
		tr = tr_base.cloneNode(true);		
		var object = planList[i];
		tr.getElementsByClassName("date")[0].innerHTML = object.Date;
		tr.getElementsByClassName("session")[0].innerHTML = object.Session;
		tr.getElementsByClassName("appointmentype")[0].value = object.AppointType;
		var venue = "";
		if(object.FacilityName){
			 venue = object.FacilityName + "  " + object.SUBFacilityName;
		}
		tr.getElementsByClassName("venue")[0].innerHTML = venue;
		if(object.AppointmentStatus == "Accepted")
			{
			 tr.getElementsByClassName("status")[0].innerHTML = '<button class="btn btn-success">'
				+ object.AppointmentStatus + '</button>';
			}
		 if(object.AppointmentStatus =="Rejected")
			 {
			 tr.getElementsByClassName("status")[0].innerHTML = '<button class="btn btn-incative">'
					+ object.AppointmentStatus + '</button>'
			 }
		 else{
			 tr.getElementsByClassName("status")[0].innerHTML = object.AppointmentStatus;
		 }
			 
			 
		tr.getElementsByClassName("tvlID")[0].innerHTML = object.storageId;
		if(object.AppointmentStatus == "Accepted")
		{
		  tr.getElementsByClassName("appointmentstatus")[0].innerHTML = "<select><option value='"+object.AppointmentStatus+"'>No Action</option><option value='Rejected after acceptence'>Rejected After Acceptence</option></select>";
		}else if(object.AppointmentStatus == "Rejected"){
			tr.getElementsByClassName("appointmentstatus")[0].innerHTML = "<select><option value='"+object.AppointmentStatus+"'>No Action</option><option value='Pending confirmation'>Pending Confirmation</option></select>";		
		}else
		{
			tr.getElementsByClassName("appointmentstatus")[0].innerHTML = "<select><option value='"+object.AppointmentStatus+"'>No Action</option><option value='Rejected after cofirmed'>Rejected After Confirmed</option></select>";
		}		
		tbody.appendChild(tr); 
	}

	//Vallidate the bank information for Invigilator
	if(planList.length>=1)
	 {
		 document.getElementById('sub').removeAttribute("style");
     }else
    	 { 
    	  document.getElementById('sub').style.display = "none";
    	 }

}


function submitForm(e) { 
	mode = "edit"
	var _data = {};
	if (e.value == "Save") {
		_data.Status = "Active";
	} else {
		_data.Status = "Draft";
	}
	_data.formStorageId = userId;
	_data.formType = "UpdateAppointments";
	//_data.ModelName = "InvigilatorAppointment";
	_data.ModelName = "UpdateAppointments";
	_data.UserId = userId;
	_data.Appointment = planList;      
	ajaxCallAPI('POST', 'updateAppointment', _data, function() {
		var response = this.get("responseData");
		//var cont = response.content;
		if(response)
		{
		 Sucessfulldata();
		}else
			{
			 console.log("error");
			}
	}, function() {

	});

}



//for submit confir
function Sucessfulldata(){	
	var boundingBox = "#sucess-popup1";
	var contentBox = "#sucess-popup-box1";
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

//changed plain list value

function onChecked(e) {	
	var tr = e.parentElement.parentElement;
	//setTimeout(
			//function() {
				for (var i = 0; i < planList.length; i++) {
					if (tr.getElementsByClassName("tvlID")[0].innerHTML == planList[i].storageId) {
						planList[i].AppointType = tr.getElementsByClassName("appointmentype")[0].value;
						planList[i].AppointmentStatus = tr.getElementsByClassName("appointmentstatus")[0].value;					
					}
				}
}

var _emptydata = 0;
function getDocumentId(thisInstance,userid){
	var data1 = {};
	if(_emptydata == 0)
	{
	 	 document.getElementById('table_row').removeAttribute("style");
	 	 //document.getElementById('sub').removeAttribute("style");
	 	_emptydata++;
	}
	var filterdata=[];			
	data1.formStorageId = userid;
	data1.formType = "UpdateAppointmentsModel";			
	var itemsSelect = document.getElementById("<portlet:namespace/>itemsPerPage");			
	var jsonsearchparameter = {"modelName":modelName,"formType":modelName};
	jsonsearchparameter["conditions"]="";
	var filter = {};
	filter["contentJson.UserId"] =  [userid] ;	
	filterdata.push(filter);
	var filter = {};
	filter["contentJson.AppointmentStatus"] =  ["Accepted" , "Rejected" , "Confirmed"];
	filterdata.push(filter);
	jsonsearchparameter["filterdata"]=filterdata;	
	console.log(jsonsearchparameter);
	ajaxCall('GET','elastiSearchList',elastisearchlisturl,jsonsearchparameter,
		 function() {						
               var response = this.get("responseData");
               if (_.isEmpty(response)) {
                   console.log("error");
                   
               } else {		            	  
            	   planList=[];   		            	   
            	  for(var i=0;i<response.content.length;i++)
            	  { 	
	            	 var item=response.content[i].contentJson;
	            	 item.storageId=response.content[i].storageId;
	            	 item.PrevAppointType = item.AppointType;
            		 planList.push(item);		            
            	  }		            	  
            	  drawTable();
            	 
               }
	
           },
           function() {
               
    		});
	
	
}
	
var responseData = [];
function loadDropdownList(strSubURI, elementDrpDwn) {    	 
	var ajax = vocabularyURL.replace("$VCNAME", strSubURI);                
	AUI().use('aui-io-request-deprecated',function(A) {
		var _data = {};
		A.io.request(ajax,
		{
			dataType : 'json',
			method : "GET",
			data : _data,
			on : {
				success : function()
				 {
				 	responseData = this.get('responseData');
					for (var i = 0; i < responseData.length; i++) {
						var opt = new Option(
						responseData[i].name,
						responseData[i].name);
						elementDrpDwn.options[elementDrpDwn.options.length] = opt;
					}
				},
				failure : function() {
					console.log("Error in the ajax call.");
				}
			}
        });
	});
}
	

</script>

<% } %>
