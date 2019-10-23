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
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
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
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/Evaluation.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<%@ taglib	uri="/tld/sp-formio" prefix="sp-formio"%>  
<portlet:defineObjects />
<liferay-theme:defineObjects />

<% if(PermissionUtil.canCopyModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
<%
String formType = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME, "ManageEvaluation");
String dashBoardLink = SambaashUtil.getDashBoard();
String storageId = request.getParameter("storageId");
String userId = String.valueOf(themeDisplay.getUserId());
String baseUrl = portletPreferences.getValue("baseUrlPref", "");
String formStorageId  = request.getParameter("storageId");
int start =1;
int end = 10;
ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
String countryListUrl = SambaashUtil.getParameter(SambaashConstants.API_COUNTRYLIST_URL,SambaashConstants.DEFAULT_GROUP_ID_LONG);
Long groupId = td.getLayout().getGroupId();
String vocabularyURL = SambaashUtil.getParameter(SambaashConstants.API_VOCABULARY_URL, groupId);
List<Role> roles= RoleLocalServiceUtil.getUserRoles(themeDisplay.getUserId(), start, end);
JSONArray listofroles = JSONFactoryUtil.createJSONArray();
for(int i =0; i < roles.size(); i++){
	listofroles.put(roles.get(i).getName());
}
%>

<portlet:resourceURL var="resourceURL" >
	<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
</portlet:resourceURL>
<portlet:resourceURL var="elastisearchlisturl">
	<portlet:param name="action" value="elastiSearchList" />
</portlet:resourceURL>
<portlet:renderURL var="successFacility">
	<portlet:param name="jspPage"
		value="/html/facility/success.jsp" />
</portlet:renderURL>
<style>
.aui table td input[type=radio] {
    opacity: 8;
}
.aui input[type=checkbox]:checked {
    opacity: 1;
}

</style>
<div class="newPortlets">
<div class="subHeader">
	<div class="container">
		<div class="inner-container">
		<aui:row>
			<aui:col span="10" cssClass="text-center"><h2><span>Invigilator Evaluation</span></h2></aui:col>
			<aui:col span="2" cssClass="text-right"><a href="<%= dashBoardLink %>" title="Back to Home">Back to Home</a></aui:col>
		</aui:row>
		</div>
	</div>
</div>


<div class="yui3-skin-sam">
		<div id="activation-success" hidden="true" class="modalpopupBox">
		 <div id="active-success-box" class="modalpopupContent">
		   <form class="formContainer" >
		     <aui:row>
		         <aui:col span="12">
		       	  <h3 id="success-msg">Record updated successfully!</h3>
		       	  </aui:col>
		       
		     </aui:row>
		     <aui:row>
		      	<aui:col span="12">
		      		<button class="btn btn-default popup-confirm-archive pull-left" type="button" onClick="reloadPage()">Start Again</button>
		      		<button class="btn cancel btn-primary popup-cancel pull-right"onClick="goBack()">Go Back</button>
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
	<div class="formSection">
	<div class="row">
		<div class="col-sm-12">
			<div class="row">
				<div class="col-sm-6">
				<div class="form-group has-error">
					<div class="form-group choices formio-choices">
						<label class="control-label">Schedule</label>
						<select class="form-control facilityType" id="schedule">
							<option>Pick one</option>
						</select>
					</div>
						<div class="formio-errors invalid-feedback hide"><p class="help-block">Please select the schedule</p></div>
				 </div>
				</div>
				<div class="col-sm-6">
				 <div class="form-group has-error">
					<div class="form-group choices formio-choices">
						<label class="control-label">Invigilator</label>
						<select class="form-control facilityType" id="invigilator">
							<option>Pick one</option>
						</select>
					</div>
					<div class="formio-errors invalid-feedback hide"><p class="help-block">Please select the Invigilator</p></div>
				</div>
			 </div>
			</div>
			<div class="row">
				<div class="col-sm-6">
				  <div class="form-group has-error">
					<div class="form-group choices formio-choices">
						<label class="control-label">Appointment Type <span style="color: red;">*</span></label>
												 <select class="form-control facilityCategory"
													id="appointmentType">
													<option selected disabled hidden>Pick one</option>
													<%
														List<SPListType> appointmentTypeList = SPListTypeLocalServiceUtil
																	.getByKey("invigilators.appointment.type", groupId);
															for (SPListType type : appointmentTypeList) {
													%><option value="<%=type.getItemValue()%>"><%=type.getDisplayName()%></option>
													<%
														}
													%>
												</select>
											</div>
					<div class="formio-errors invalid-feedback hide"><p class="help-block">Please select the Appointment Type</p></div>
				  </div>
				</div>
				<div class="col-sm-6" id="hidepoten">
					<div class="form-group">
					<label style="margin-top:33px"></label>
						<input type="checkbox" class="form-control potentialtobeLeadRole" id="potentialtobeLeadRole">Potential to be Lead Role<br>
					</div>
				</div>
			</div>
			<div class="row" id="hidelead">
				<div class="col-sm-6">
					<div class="form-group choices formio-choices">
						<label class="control-label">Lead Role Name</label>
						<select class="form-control facilityCategory" id="leadRoleName" disabled="disabled">
							<option>Pick one</option>
						</select>
					</div>
				</div>
			</div>
			 <div class="row">
							<div class="col col-sm-12">
								<table id="evaluationcriteria"  class="aui">
							            <thead>
							               <tr>
							                  <th>Criteria</th>
							                  <th>Poor</th>
							                  <th>Satisfactory</th>
							                  <th>Good</th>
							                  <th>Excellence</th>							                  
							                  
							               </tr>
							            </thead>
							            <tbody>
							               <tr id="eval">
							                  <td><label class="criteria">Leadership</label></td>
							                  <td><label><input type="radio" class="poor" id="poor" name="leadership" value="1"></label></td>
							                  <td><label><input type="radio" class="satisfactory" id="satisfactory" name="leadership" value="2"></label></td>
							                  <td><label><input type="radio" class="good" id="good" name="leadership" value="3"></label></td>
							                  <td><label><input type="radio" class="excellence" id="excellence" name="leadership" value="4"></label></td>
							               </tr>
							            </tbody>
			        			</table>
							</div>
			</div>
			
			<div class="row">
				<div class="col-sm-4">
				<div class="form-group formio-component-textfield">
				 <label class="control-label">Total Score</label>
				 <input type="text" name="totalscore" id="totalscore" class="form-control">
				 </div>
				 </div>
		   </div>
		    <div class="row" id="hiderem">
		   <div class="col-sm-12">
		   	<div class="form-group formio-component-textarea">
			 <label class="control-label">Remarks (By Lead Role)</label>
			 <textarea  rows="2" cols="50" id="remarks1" class="form-control">
			 </textarea>
			 </div>
			 </div>
		   </div>
		   <div class="row" style="display:none" id="showrem">
		   <div class="col-sm-12">
		   	<div class="form-group formio-component-textarea">
			 <label class="control-label">Remarks (By RELC)</label>
			 <textarea  rows="2" cols="50" id="remarks2" class="form-control">
			 </textarea>
			 </div>
			 </div>
		   </div>
			<div class="row userAction">
				
					<button type="button"  id="bt_submit" onclick="submitForm(this)"  class="btn btn-primary">Submit</button>
				
					<button type="button" onclick="goBack();" class="btn btn-default">Cancel</button>
			
			</div>
		</div>
	</div>
	</div>
</div>
</div></div>
</div>
</div>

<script>
var namespace = "<portlet:namespace/>";
</script>

<script>
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var mode = "copy";
var userId = "<%= userId %>";
var roles = '<%= listofroles.toString() %>';
var formStorageId = "<%= formStorageId %>";
var vocabularyURL = "<%= vocabularyURL %>";
var baseUrl = "<%= baseUrl %>";
var elastisearchlisturl="<%=elastisearchlisturl%>";
var counter = 1;
tbl = document.getElementById('evaluationcriteria');
tbody = tbl.getElementsByTagName('tbody')[0];
tr_base = tbody.getElementsByTagName("tr")[0];
var planList = [];
var object = [];
var tbl, tbody, tr_base;
var criteria = [];
var score;
var selected_1 = 0;
var selected_2 = 0;
var selected_3 = 0;
var ratings=[];
var scores=[];
var totalscore=0;
var jsondata;

function getSchedule(){
	
	   var scheduleData = {};  
	   scheduleData.formStorageId = userId;
	   scheduleData.formType = "ManageEvaluation";
	   var userid = '';
	   var options1 = ''
	   var newdata = {};
	   scheduleData.limit = "1000";
	   scheduleData.page = 0;
	   scheduleData.filterdata = [];
		ajaxCallAPI('GET','scheduleData',scheduleData,
			 function() {
	           var response = this.get("responseData");            
	           if (_.isEmpty(response)) {
	               console.log("error");                   
	           } else {	
	        	   options1 += '<option value="Pick one">' + 'Pick one' + '</option>'
	        	 
	        	     for(var i=0;i<response.data.length;i++)
	      		     {
	      		      options1 += '<option value="' + response.data[i].ScheduleCode + '">' + response.data[i].Name + '</option>'
	      		      }            	      
	      	          document.getElementById('schedule').innerHTML = options1;
	            }

	       },
	       function() {
	           
			});		
	 }
	    
		
		
		function getInvigilator(code){
			var invigilatorData = {};
			invigilatorData.limit = 10;
			invigilatorData.modelName = "invigilatorappointment"
			invigilatorData.formStorageId = userId;
			invigilatorData.page = 0;
			invigilatorData.formType = "InvigilatorAppointment";
			var filter = {};
			var filterdata=[];
			var options1 = ''
		    filter["contentJson.ScheduleId"] = [code];		 
			filterdata.push(filter);
			invigilatorData.filterdata = filterdata;
			ajaxCallAPI('GET','elastiSearchList',invigilatorData,
				 function() {
		               var response = this.get("responseData");
		               
		               if (_.isEmpty(response)) {
		                   console.log("error");
		                   
		               } else {	
		            	  options1 += '<option value="Pick one">' + 'Pick one' + '</option>'
		            	  for(var i=0;i<response.content.length;i++)
		            		 { 		            		  
		            		
		            		  options1 += '<option value="' + response.content[i].contentJson.UserId + '">'
		  					  + response.content[i].contentJson.FullName + "( "+response.content[i].contentJson.NRICNumberID +" )"+'</option>'; 
		  					 }            	      
		            	     document.getElementById('invigilator').innerHTML = options1;
			               }
			
		           },
		           function() {
		    	
		           });
			
			
		    }
		
		function getInvigilatorLeadRoleName(code){
			var leadrolenameData = {};
			leadrolenameData.limit = 10;
			leadrolenameData.modelName = "InvigilatorAppointment"
			leadrolenameData.formStorageId = userId;
			leadrolenameData.page = 0;
			leadrolenameData.formType = "InvigilatorAppointment";
			var filter = {};
			var filterdata=[];
			var options1 = ''
			
		    //Set filter parameters
			filter["contentJson.ScheduleId"] = code;
			//filter["contentJson.Lead"] = true;
			filterdata.push(filter);		
			leadrolenameData["filterdata"] = filterdata;
			var options1 = ''	 
			ajaxCallAPI('GET','elastiSearchList',leadrolenameData,
				 function() {
		               var response = this.get("responseData");
		               
		               if (_.isEmpty(response)) {
		                   console.log("error");
		                   
		               } else {
		            	  for(var i=0;i<response.content.length;i++)
		            		 {	
		            		    if(response.content[i].contentJson.Lead==true){
		            		      options1 += '<option value="' + response.content[i].contentJson.ScheduleId + '">' + response.content[i].contentJson.FullName + '</option>'
		            		    }
		            		  }            	      
		            	     document.getElementById('leadRoleName').innerHTML = options1;
			               }
			
		           },
		           function() {
		               
		    	   });
			
			
		    }
		
		
		function getEvaluationMatrixCriteria(){
			var EvaluationData = {};
			EvaluationData.limit = 10;
			EvaluationData.modelName = "EvaluationMatrixSetup"
			EvaluationData.formStorageId = userId;
			EvaluationData.page = 0;
			EvaluationData.formType = "EvaluationMatrixSetup";
			EvaluationData.filterdata = [];
			var userid = '';
			var options1 = ''	 
			ajaxCallAPI('GET','elastiSearchList',EvaluationData,
				 function() {
		               var response = this.get("responseData");
		               
		               if (_.isEmpty(response)) {
		                   console.log("error");
		                   
		               } else {		            	  
		            	   planList=[];  
		            	  for(var i=0;i<response.content.length;i++){ 		            		  
		            		   planList.push(response.content[i].contentJson);	            		  
			               }
		            	 drawTable();
		 				 loadDefaultData();
		            	 
		               }
			
		           },
		           function() {
		             
		    	   });
			
			
		    }
		


		AUI().use('aui-base', function (A) {
			
			A.on('domready', function (thisInstance) {
				
				role = JSON.parse(roles);
				for(j=0;j<role.length;j++){
					if(role[j]=="invigilator admin"){
						//hide field potential to lead role
						document.getElementById("hidepoten").style.display = 'none';
					    // hide lead role name
					    document.getElementById("hidelead").style.display = 'none';
					    // hide remarks by lead
					    document.getElementById("hiderem").style.display = 'none';
					    // show RELC remarks
					    document.getElementById("showrem").style.display = 'block';	
				 }
				}
				getSchedule();
				getEvaluationMatrixCriteria();
				
			});
			

			setTimeout(function(){ 
				 A.all('input[type="radio"]').on('change', function(e) {
					 // get the current score
					 totalscore = parseFloat(document.getElementById('totalscore').value);
					 // Extract the values
					  for(j=0;j<criteria.length;j++){				
						  if(e.currentTarget.get('name')==criteria[j]){
							  score = parseFloat(e.currentTarget.get('value'));
							  
						  }
					 }		 
					
					 //Evaluate score
					 totalscore += (score/(criteria.length*parseFloat(document.getElementsByClassName("excellence")[0].value)))*100; 
					 document.getElementById('totalscore').value = Math.round(totalscore,2);
					//reset totalscore
					  totalscore = 0;
				 });
			}, 2000);
			
			 A.all('#schedule').on('change', function(e) {
				 
				var schedulecode = e.currentTarget.get('value');
				 getInvigilator(schedulecode);
				 getInvigilatorLeadRoleName(schedulecode);
					if(schedulecode!="Pick one"){
				        selected_1 = hide("schedule");
					}
				
			 });
			 
			 A.all('#invigilator').on('change', function(e) {		 
				 var value = e.currentTarget.get('value');
					if(value!="Pick one"){
						selected_2 = hide("invigilator");
					}
			 });
			 
			 A.all('#appointmentType').on('change', function(e) {
				 var value = e.currentTarget.get('value');
				 if(value!="Pick one"){			 
					 selected_3 = hide("appointmentType");
				 }
			 });
			
		})



		var tr;
		function drawTable() {
			while (tbody.hasChildNodes()) {
				tbody.removeChild(tbody.lastChild);
			}
			
			

			for (var i = 0; i < planList.length; i++) {
				tr = tr_base.cloneNode(true);
				var object = planList[i];
				tr.getElementsByClassName("criteria")[0].innerHTML = object.Criteria;
				tr.getElementsByClassName("poor")[0].name = object.Criteria;
				tr.getElementsByClassName("poor")[0].value = object.Poor;
				tr.getElementsByClassName("satisfactory")[0].name = object.Criteria;
				tr.getElementsByClassName("satisfactory")[0].value = object.Satisfactory;
				tr.getElementsByClassName("good")[0].name = object.Criteria;
				tr.getElementsByClassName("good")[0].value = object.Good;
				tr.getElementsByClassName("excellence")[0].name = object.Criteria;
				tr.getElementsByClassName("excellence")[0].value = object.Excellence;	
				// write into js array criteria
				criteria[i]	= tr.getElementsByClassName("criteria")[0].innerHTML = object.Criteria;
				tbody.appendChild(tr);
			}
		}

		function hide(id){
			var e = document.getElementById(id);
			var r = e.parentElement.parentElement;
			r.children[1].classList.add('hide');
			return 1
		}

		function unhide(id){
			var e = document.getElementById(id);
			var r = e.parentElement.parentElement;
			r.children[1].classList.remove('hide');
			return 0
		}


function loadDefaultData() {
	if (mode == "edit" || mode == "copy" || mode == "view") {
		fetchDetails(formStorageId);
	}
}

function getEID(element) {
	return document.getElementById(element);
}

function getEvaluationResults() {
	 tbl=document.getElementById("evaluationcriteria");
	    tr=tbl.getElementsByTagName('tbody')[0];
	    var len = document.getElementsByClassName("criteria").length;
	    for (var i = 0; i < len; i++) {
	    	td=tr.getElementsByTagName('tr')[i];
		  for(var j in jsondata){
		    var key = j;
		    var val = jsondata[key];
		        if(key==document.getElementsByClassName("criteria")[i].innerText.replace(/\s+/g, '')){
		        	td.getElementsByClassName(val)[0].checked=true;
		        }
		    }
		
	    }
}


function evaluateScore(){	
	 // Evaluate score
	totalscore = 0;
	if(scores.length >= criteria.length){ 			
	  for(i=0;i<scores.length;i++){
		totalscore += parseFloat(scores[i]);
	  }
	  totalscore = (totalscore/(criteria.length*parseFloat(document.getElementsByClassName("excellence")[0].value)))*100; 
	  document.getElementById('totalscore').value = Math.round(totalscore,2);
	  //reset totalscore
	  totalscore = 0;
	}
}

var data, contentdata;
function fetchDetails(formStorageId) {
	var fCode = "";
	if (formStorageId != "") {
		data = {};

		data.formStorageId = encodeURIComponent(formStorageId);
		data.formType = "ManageEvaluation";
		console.log(data);
		ajaxCallAPI(
				'GET',
				"loadData",
				data,
				function() {
					data = this.get("responseData");
					contentdata = this.get("responseData");
					if (data.error) {
						displayMessage('danger', data.error);
					} else {
						jsondata = contentdata.contentJson;
						document.getElementById("schedule").value = contentdata.contentJson.ScheduleCode;
						
						document.getElementById("invigilator").value = contentdata.contentJson.Invigilator;
						document.getElementById("appointmentType").value = contentdata.contentJson.AppointmentType;
						document.querySelector('#potentialtobeLeadRole').checked = contentdata.contentJson.PotentialtobeLeadRole;
					    
						//Evaluation
					     getEvaluationResults();
					    
						document.getElementById("totalscore").value = contentdata.contentJson.TotalScore;
						document.getElementById("remarks1").value = contentdata.contentJson.Remarks1;
						document.getElementById("remarks2").value = contentdata.contentJson.Remarks2;
						
						
					}
				}, function() {
					displayMessage('danger',
							"Error in persisting dynamic form data.");
				});
	}

}

function submitForm(e) { 
	
	// Validate form
	
	//Schedule
	  var e = document.getElementById("schedule");
	  var value = e.options[e.selectedIndex].value;
	if(value=="Pick one"){
		selected_1 = unhide("schedule");
	}else{
		selected_1 = hide("schedule");
	}
	
	//Invigilator
	  var e = document.getElementById("invigilator");
	  var value = e.options[e.selectedIndex].value;
	if(value=="Pick one"){
		selected_2 = unhide("invigilator");
	}else{
		selected_2 = hide("invigilator");
	}
	
	//Appointment Type
	  var e = document.getElementById("appointmentType");
	  var value = e.options[e.selectedIndex].value;
	if(value=="Pick one"){
		selected_3 = unhide("appointmentType");
	}else{
		selected_3 = hide("appointmentType");
	}
	
	
	
if( selected_1 >= 1 && selected_2 >= 1 && selected_3 >= 1 ) {
	mode = "copy"
	var _data = {};
	_data.formStorageId = 0;
	_data.formType = "ManageEvaluation";
	_data.ModelName = "ManageEvaluation";
	_data.UserId = userId;
	//Schedule
	var e = document.getElementById("schedule");
	  var value = e.options[e.selectedIndex].value;
	  var text = e.options[e.selectedIndex].text;
	_data.ScheduleCode = value;
	_data.Schedule = text;
	// Invigilator
	var e = document.getElementById("invigilator");
	  var value = e.options[e.selectedIndex].value;
	  var text = e.options[e.selectedIndex].text;
	_data.Invigilator = text;
	//Appointment Type
	var e = document.getElementById("appointmentType");
	  var value = e.options[e.selectedIndex].value;
	  var text = e.options[e.selectedIndex].text;
	_data.AppointmentType = value;
	//Potential to be Lead Role
	 var e = document.querySelector('#potentialtobeLeadRole').checked;
	 var value = e;
	_data.PotentialtobeLeadRole = value;
	//Lead Role Name
	 var e = document.getElementById("leadRoleName");
	 var value = e.value;
	_data.LeadRoleName = value;
	//Evaluation criteria
	tbl=document.getElementById("evaluationcriteria");
    tr=tbl.getElementsByTagName('tbody')[0];
    for (var i = 0; i < criteria.length; i++) {
	  td=tr.getElementsByTagName('tr')[i];
	  var cr = document.getElementsByClassName("criteria")[i].innerText;
	  var str="input[name=" + "\"" + cr + "\"" +  "]:checked";
	  ratings[i]= td.querySelector(str).id;
	  scores[i]= parseFloat(td.querySelector(str).value);
    }
	
	 for(j=0;j<criteria.length;j++){		
		 _data[criteria[j].replace(/\s+/g, '')] = ratings[j];
	 }
	 //Evalute score and write into Total score
	 evaluateScore();
	//total score
	var e = document.getElementById("totalscore");
	var value = e.value;
	_data.TotalScore = value;
	//remarks by Lead Role
	var e = document.getElementById("remarks1");
	var value = e.value;
	_data.Remarks1 = value;
	//remarks by RELC
	var e = document.getElementById("remarks2");
	var value = e.value;
	_data.Remarks2 = value;
	
	ajaxCallAPI('POST', 'persist', _data, function() {
		var response = this.get("responseData");
			showPopupSuccess();
	}, function() {

	});
	
	}
	
}

//for submit confir
function showPopupSuccess(){
	var boundingBox = "#activation-success";
	var contentBox = "#active-success-box";
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
            	      }
            	    );
        });

    });
}

var responseData = [];

function loadDropdownList(strSubURI, elementDrpDwn) {
	var ajax = vocabularyURL.replace("$VCNAME", strSubURI);
	AUI()
			.use(
					'aui-io-request-deprecated',
					function(A) {
						var _data = {};
						A.io
								.request(
										ajax,
										{
											dataType : 'json',
											method : "GET",
											data : _data,
											on : {
												success : function() {
													responseData = this
															.get('responseData');
													for (var i = 0; i < responseData.length; i++) {
														var opt = new Option(
																responseData[i].name,
																responseData[i].name);
														elementDrpDwn.options[elementDrpDwn.options.length] = opt;
													}
												},
												failure : function() {
													console
															.log("Error in the ajax call.");
												}
											}
										});
					});
}

 
</script>
<% } %>