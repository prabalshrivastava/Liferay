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
<style>
#contract-service-popup button.close-content, #contract-service-popup button.close,.formContainer+.modal-body
	{
	display: none
}

#formio {
	margin-top: 0;
}
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
	String portalURL = themeDisplay.getPortalURL();

		String formType = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME,
				"InvigilatorAppointment");
		String dashBoardLink = SambaashUtil.getDashBoard();
		String storageId = request.getParameter("storageId");
		String userId = String.valueOf(themeDisplay.getUserId());
		/* String baseUrl = portletPreferences.getValue("baseUrlPref", ""); */
		String formStorageId = request.getParameter("storageId");
		ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String countryListUrl = SambaashUtil.getParameter(SambaashConstants.API_COUNTRYLIST_URL,
				SambaashConstants.DEFAULT_GROUP_ID_LONG);
		Long groupId = td.getLayout().getGroupId();
		String vocabularyURL = SambaashUtil.getParameter(SambaashConstants.API_VOCABULARY_URL, groupId);
		String baseUrl = portletPreferences.getValue("baseUrlPref", "");
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
					<h2><span>MANAGE APPOINTMENT</span></h2>
				</aui:col>
				<aui:col span="2" cssClass="text-right">
					<a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</a>
				</aui:col>
			</aui:row>
			</div>
		</div>
	</div>

	<c:set var="formType" value='<%=formType%>' />
	<c:set var="formStorageId" value='<%=userId%>' />
	<%-- <sp-formio:FormIO modelName="${formType}"
		formId="${formId}" readOnly="false" formStorageId="${formStorageId}" /> --%>
<div class="formRoot">
		<div class="innerFormRoot">
	<aui:form cssClass="formContainer">

		<div class="">
			<div class="col col-sm-12">
				<div class="DateDescription" style="display: none">
					<div class="alert-bg">
						<div class="col col-sm-8">
							<strong>Important: </strong>To accept the invigilation dates
							listed below, please review & agree to the <strong>'Terms
								of Service'</strong> , to confirm your acceptance of this appointment
							arrangement.
						</div>
						<div class="col col-sm-4  text-right">
							<aui:button id="bt_submit" type="button" value="Review & Agree"
								cssClass="btn-primary" onclick="review(this)"></aui:button>
						</div>
					</div>


					<div class="data-lising" style="background:#fff;">
						<div class="container formio-form">
							<div class="formSection">

								<div class="row">
									<div class="col col-sm-12 timelineList">
										<table id="DateDescription">
											<thead>
												<tr>
													<th>Date</th>
													<th>Session</th>
													<th>Appointment</th>
													<th>Venue</th>
													<th>Appointment Staus</th>

												</tr>
											</thead>
											<tbody>
												<tr id="table_row">
													<td><label class="date"></label></td>
													<td><label class="session"></label></td>
													<td><label class="appointmentype"></label></td>
													<td><label class="venue"></label></td>
													<td><select class="appointmentstatus"
														id="appointmentstatus" onchange="onChecked(this)"></select>
														<label class="tvlID" style="display: none;"></label></td>
												</tr>
											</tbody>
										</table>
										<div class="row">
											<div class="col col-sm-10 col-sm-push-1">
												<div>
													<label class="control-label">Remarks</label>
													<textarea name="remarks" type="text" class="form-control"
														rows="3" id="remarks"></textarea>
												</div>
											</div>
										</div>
										
									</div>
								</div>
							</div>
							<div class="row">
											<div class="col userAction col-sm-10 col-sm-push-1">
												<div class="form-group  subbtn" style="display: none">
													<aui:button id="bt_submit" type="button"
														onclick='submitForm1(this)' value="Save"
														cssClass="btn-primary"></aui:button>
													<aui:button id="bt_clear" type="button" value="Cancel"
														cssClass="btn-default" onclick="goBack();"></aui:button>
												</div>
											</div>
										</div>
						</div>




					</div>

				</div>

				<!--  submit confirmation success -->
				<div class="yui3-skin-sam">
					<div id="sucess-popup" hidden="true" class="modalpopupBox">
						<div id="sucess-popup-box" class="modalpopupContent">
							<aui:row>
								<aui:col span="12" cssClass="text-center">

									<h3>
										<br />Data saved successfully.
									</h3>
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="12" cssClass="userAction">									
									<button class="btn btn-primary"
										type="button" onClick="reloadPage()">Start Again</button>
									<button class="btn btn-default"
										type="button" onClick="goBack()">GO BACK</button>
								</aui:col>
							</aui:row>

						</div>
					</div>
				</div>

				<!-- ------------end---------------- -->

				<div class="yui3-skin-sam">
					<div id="deactivation-success" hidden="true" class="modalpopupBox">
						<div id="inactive-success-box" class="modalpopupContent smilly-icon">
							<form class="formContainer ">
								<aui:row>
									<aui:col span="12" cssClass="text-center">

										<h3>
											Oops!<br />Your bank information is missing
										</h3>
										<p>Your bank information is required for transactional
											purpose. So please key in the detail soon. .</p>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="12" cssClass="userAction">
										<button type="button" class="btn btn-primary"
											onclick="addNewRecord1(this)">Add Details</button>
									</aui:col>
								</aui:row>
							</form>
						</div>
					</div>
				</div>

				<!-- contract for service popup -->


				<div class="yui3-skin-sam">
					<div id="contract-service-popup" hidden="true"
						class="modalpopupBox">
						<div id="inactive-success-box-popup" class="modalpopupContent">
							<form class="formContainer">
								<aui:row>
									<aui:col span="12" cssClass="text-center">
										<div class="boxPadding" style="height:600px;overflow-y: scroll;">
											<h2>CONTRACT FOR SERVICE</h2>
											<p id="contractservice">THIS Contract for Service ("Contract") dated CurrentDate is entered into by and between the Regional Language Centre Examinations Bureau 
											(hereinafter referred to as "RELC EB" and having its registered office at 30 Orange Grove Road, Singapore 258352 and 
											InvigilatorFullName (NRIC NRICNo) of HouseBlockNo, StreetName, UnitNo, BuildingName, Country PostalCode  
											("the Exam Personnel").</p>

											<p>IT IS AGREED AS FOLLOWS:-</p>
											<ul>
												<li>RELC EB agrees to engage the services of the Exam
													Personnel to serve as an Exam Personnel subject to and in
													accordance with the terms of this Contract.</li>
												<li>The period of the engagement as stated on the
													Letter of Appointment.</li>
												<li>RELC EB shall pay the Exam Personnel fee as stated
													on the Letter of Appointment.</li>
												
												<li>The Exam Personnel shall be solely responsible for payment of his/her personal income tax to IRAS for the fees received from RELC EB.</li>
												<li>The Exam Personnel agrees to use reasonable skill and care in the provision of his/her Services (described in the Letter of Appointment) and agrees to comply with all instructions given by RELC EB in relation to the Services. Failure by the Exam Personnel to comply herewith shall entitle RELC EB to terminate this Contract with immediate effect and without compensation. </li>
												<li> The Exam Personnel shall not at any time or thereafter after the engagement, divulge or disclose to any third party any information or knowledge obtained during his engagement with RELC EB relating to processes, policies, examination materials or confidential information of RELC EB. Upon termination or expiry of his Contract, the Exam Personnel shall promptly return all items belonging to RELC EB, including all files or documents related to business of RELC EB or its clients (without retaining any copies) which have been provided to the Exam Personnel, on his last day of engagement.</li>
													
												<li>The Exam Personnel acknowledges and agrees that ownership of all intellectual property rights arising from any materials, inventions or developments made by the Exam Personnel during the course of his engagement shall at all times belong to and remain vested in RELC EB. The Exam Personnel hereby agrees to do all such things and execute all such documents as may be required to register such rights or otherwise secure their protection in the name of RELC EB.</li>
												<li>Any notice under this Contract may be served upon the Exam Personnel in writing and shall be sent by registered post at his last known address in Singapore and any such notice given by letter shall be deemed to have been given at the time at which the letter would be delivered in the ordinary course of post.</li>
												<li>This Contract may be terminated by either party by given one (1) week's written notice to the other party. Notwithstanding the aforesaid, this Contract may be terminated at any time by RELC EB without notice or compensation if the Exam Personnel
													<ul>
														<li>Breaches any of the terms of this Contract; or  </li>
														<li>neglects or fails to perform the Services to the reasonable satisfaction of RELC EB; or </li>
														<li>due to the Exam Personnel's negligence or misconduct; or</li>
														<li>if any criminal charge is brought against the Exam Personnel or if the Exam Personnel is adjudged a bankrupt. 
														
														<p>Such termination shall not prejudice RELC EB's right and remedies in respect of any outstanding breaches of this Contract by the Exam Personnel prior to the termination.  
 </p></li>
													
													</ul>
												
												
												
												</li>
												
												<li> This Contract shall be governed by and construed in accordance with Singapore laws and the parties agree to submit to the exclusive jurisdiction of the Singapore Courts.</li>
												
												<p>
												<input type = "checkbox" name = "acceptterms" id = "acceptterms" style="display:block;opacity: 6;" />
												I hereby acknowledge that I have read and understood the above specified terms and conditions. I confirm that I will comply with and be fully bound by these terms and conditions upon my submission when I click the "Accept" button below. I agree that RELC EB reserves the right to change the terms and conditions without prior notice.  
 
												
												</p>
											</ul>
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="12" cssClass="userAction">
										<!-- <button type="button" class="btn btn-primary close1" onclick="review1()" >Accept</button> -->
										<button type="button" class="btn btn-primary close2">Accept</button>
										<button class="btn btn-default" type="button"
											onclick="reload()">Reject</button>
									</aui:col>
								</aui:row>
							</form>
						</div>
					</div>
				</div>

				<!-- end -->
				<div class="yui3-skin-sam">
					<div class="no-data-listing" style="display: none">
						<div class="sambaashContent">
							<div class="container nodates">
								<aui:row>
									<aui:col span="12" cssClass="text-center">
										<h3 id="h3message" class="no-data-listing-message">
											No dates assigned yet
											<%-- <%= modelName %> --%>
										</h3>
										<a id="ahrefmessage" onclick="moveToDashboard()"
											title="BACK TO DASHBOARD" class="btn lightbluebtn">BACK
											TO DASHBOARD</a>
									</aui:col>
								</aui:row>
							</div>
						</div>
					</div>
				</div>
				
				<!-- submit sucess data -->
				<%-- 			<div class="yui3-skin-sam">
				<div class="data-submit" style="display: none">
					<div class="sambaashContent">
						<div class="container nodates">
						 <form class="formContainer" >
							<aui:row>
								<aui:col span="12" cssClass="text-center">
									<h3 id="h3message" class="no-data-listing-message">
										Data Saved successfully
										<%= modelName %>
									</h3>
									<a id="ahrefmessage" href="#link" title="BACK TO DASHBOARD"
										class="btn lightbluebtn">BACK TO DASHBOARD</a>
								</aui:col>
							</aui:row>
						 </form>	
						</div>
					</div>
				</div>				
			</div> --%>
			</div>
		</div>

	</aui:form>
	</div>
	</div>
	<portlet:resourceURL var="elastisearchlisturl">
		<portlet:param name="action" value="elastiSearchList" />
	</portlet:resourceURL>
	<portlet:renderURL var="CreateNewURL">
		<portlet:param name="jspPage" value="wwww" />
	</portlet:renderURL>
</div>


<script type="text/javascript">
var mode = "view";
var dashBoardLink = "<%=dashBoardLink%>";
var dontLoadData = true;
var documents;
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var userId = "<%=userId%>";
var formType = "<%=formType%>";  
var formStorageId = "<%=formStorageId%>";
var modelName = formType;
var vocabularyURL = "<%=vocabularyURL%>";
<%-- var baseUrl = "<%= baseUrl %>"; --%>
var baseUrl = "<%=portalURL + baseUrl%>";
var elastisearchlisturl="<%=elastisearchlisturl%>";
var counter = 1;
tbl = document.getElementById('DateDescription');
tbody = tbl.getElementsByTagName('tbody')[0];
tr_base = tbody.getElementsByTagName("tr")[0];
var planList = [];
//var object = [];
var tbl, tbody, tr_base;
var userid = '';
var subjectProgrammeList = [];
var bankList = [];
var table = document.getElementById("myTable");
    
	function test(){	  
	  var e = document.getElementById("invigilaotrdata");
	  var value = e.options[e.selectedIndex].value;
	  var text = e.options[e.selectedIndex].text;
	  getDocumentId(null,value);  	
	}
		
	var _instance;
AUI().use('event-base', function (A) {
	A.on('domready', function (thisInstance) {		
		getUserAppointmentsList(thisInstance,userId);
		getBankDataFroInvigilator();
		_instance = thisInstance;
		
	});
		
})
// Contract service reject button
		function reject()
		{
			window.location.href = dashBoardLink;
		}
//

    var bankdata = false;
   function getBankDataFroInvigilator()
      {
	   debugger;
		var filterdata=[];
		 var itemsSelect = document.getElementById("<portlet:namespace/>itemsPerPage");
		 var jsonsearchparameter = {"modelName":"Invigilator","formType":"Invigilator"};
		 jsonsearchparameter["conditions"]="";
		 var filter = {};
		 filter["contentJson.UserId"] ="["+ userId + "]";
		 
		 filterdata.push(filter);
		 jsonsearchparameter["filterdata"]=filterdata;
		
		 var obj = "";
			 ajaxCall('GET','elastiSearchList',elastisearchlisturl,jsonsearchparameter,
			 function() {				
	               var response = this.get("responseData");               
	               if (_.isEmpty(response)) {
	                   console.log("error");  
	                   displayMessage('danger', "Error in persisting dynamic form data.");
	               } else {	
	            	    obj = response.content[0].contentJson;
	            	    if(obj.hasOwnProperty("BankName")) {
	            			bankdata = true;
	            		} else if(obj!="") {
                        	bankdata = true;	            			  
	            		} else {
	            			bankdata = false;	
	            		}
	            	    var contractParagraph = document.getElementById("contractservice");
	            	    var currentDate = new Date();
	            	    var formatedDate =  currentDate.getDate() + "/" + (currentDate.getMonth() + 1) + "/" + currentDate.getFullYear();
	            	    contractParagraph.innerHTML = contractParagraph.innerHTML.replace('CurrentDate', formatedDate);
	            	    contractParagraph.innerHTML = contractParagraph.innerHTML.replace('InvigilatorFullName', response.content[0].contentJson.FullName);
	            	    contractParagraph.innerHTML = contractParagraph.innerHTML.replace('NRICNo', response.content[0].contentJson.NRICNumberID);
	            	    contractParagraph.innerHTML = contractParagraph.innerHTML.replace('HouseBlockNo', response.content[0].contentJson.HouseBlockNo);
	            	    contractParagraph.innerHTML = contractParagraph.innerHTML.replace('StreetName', response.content[0].contentJson.StreetName);
	            	    contractParagraph.innerHTML = contractParagraph.innerHTML.replace('UnitNo', response.content[0].contentJson.UnitNo);
	            	    contractParagraph.innerHTML = contractParagraph.innerHTML.replace('BuildingName', response.content[0].contentJson.BuildingName);
	            	    contractParagraph.innerHTML = contractParagraph.innerHTML.replace('Country', response.content[0].contentJson.Country);
	            	    contractParagraph.innerHTML = contractParagraph.innerHTML.replace('PostalCode', response.content[0].contentJson.PostalCode);
	            	    console.log(response.content);
	            	    console.log(obj);
	            		
		       		}
		           
	           },
	           function() {
	        	   displayMessage('danger', "Error in persisting dynamic form data.");
	    		});
	  }



var tr;
var bankDetail = [];
var review_data = 0;
//for review the data

function StatusActive()
 {
	 review_data == 1;
	 var dataa = document.getElementsByClassName("accept");
	 for(var s=0; s<dataa.length;s++)
		{
	   	  dataa[s].removeAttribute('disabled');
	   	  
		}	
	 var boundingBox = "#contract-service-popup";
	 var contentBox = "#inactive-success-box-popup";
	 
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
         
         
          Y.one('.close2').on(
          	      'click',
          	      function() {
          	    	  var agreeBox = document.getElementById("acceptterms");
          	    	  if(agreeBox.checked){
          	    		modal.hide();
          	    	  }else{
          	    		  alert("Please Agree to the Contract to Continue.");
          	    		  return;
          	    	  }
          	        
          	      }
          	    );
      });
	 
 }

function review()
{ 
	   if(bankdata == true)
		{		  
		    showPopupContract();
		    StatusActive();
		}else
			{				
			 showBankError();			 
			}
}



function drawTable() {
	while (tbody.hasChildNodes()) {
		tbody.removeChild(tbody.lastChild);
	}

	for (var i = 0; i < planList.length; i++) {		
		tr = tr_base.cloneNode(true);
		//tr.style.display="block";
		var object = planList[i];
		var date = object.Date;
		var ds = date;
		if(date.includes("-")){
			var de = new Date(date);
			var day = de.getDate();
			if(day < 10){
				day = "0" + day;
			}
			var month = de.getMonth() + 1;
			if(month < 10){
				month = "0" + month;
			}
			ds = day + "/" + month + "/" + de.getFullYear();
		}
		tr.getElementsByClassName("date")[0].innerHTML = ds;
		var session = "";
		if(object.Session){
			session = object.Session;
		}else if(object.SessionType){
			session = object.SessionType;
		}
		tr.getElementsByClassName("session")[0].innerHTML = session;
		tr.getElementsByClassName("appointmentype")[0].innerHTML = object.AppointType;
		var venue = "";
		if(object.FacilityName){
			 venue = object.FacilityName + "  " + object.SUBFacilityName;
		}
		tr.getElementsByClassName("venue")[0].innerHTML = venue;
		tr.getElementsByClassName("tvlID")[0].innerHTML = object.storageId;
        if(object.AppointmentStatus=="Pending" || object.AppointmentStatus=="Pending Confirmation" || object.AppointmentStatus=="Pending Notification" || object.AppointmentStatus=="rejected after acceptence")
        	{        	 
	         tr.getElementsByClassName("appointmentstatus")[0].innerHTML = "<select onmouseover='OnMouseIn(this)'><option value='Pending Confirmation' >Pending Confirmation</option><option value='Accepted' class='accept' disabled >Accept</option><option value='Rejected'  onmouseover='OnMouseIn(this)' >Reject</option></select>";					//tr.getElementsByClassName("appointmentstatus")[0].innerHTML =  "<option>"+object.AppointmentStatus+"</option>";	
        	}
        else if(object.AppointmentStatus == "Accepted")
        	{
        	 tr.getElementsByClassName("appointmentstatus")[0].innerHTML = "<select disabled> <option value='Accepted' class='Accepted' disabled selected>Accept</option></select>";
        	}
        else if(object.AppointmentStatus == "Rejected"){
        	 tr.getElementsByClassName("appointmentstatus")[0].innerHTML = "<select disabled><option value='Rejected' class='Rejected' disabled selected>Rejected</option></select>";
        }
        else if(object.AppointmentStatus == "Confirmed"){
       	 	 tr.getElementsByClassName("appointmentstatus")[0].innerHTML = "<select disabled><option value='Confirmed' class='Confirmed' disabled selected>Confirmed</option></select>";
       }
		
		
		tbody.appendChild(tr);
	}	
}

function submitForm1(e) { 
	mode = "edit"
	showLoadingCommon(true);
	var _data = {};
	if (e.value == "Save") {
		_data.Status = "Active";
	} else {
		_data.Status = "Draft";
	}
	_data.formStorageId = userId;
	_data.formType = formType;
	_data.ModelName = formType;
	_data.UserId = userId;
	_data.Appointment = planList; 
	_data.Remarks = document.getElementById("remarks").value;
	ajaxCallAPI('POST', 'persist', _data, function() {		
		var response = this.get("responseData");
		showLoadingCommon(false);
		if(response)
			{
			  Sucessfulldata();
			}else
				{
				displayMessage('danger', "Error in persisting dynamic form data.");
				}
	}, function() {
		displayMessage('danger', "Error in persisting dynamic form data.");
	});

}

var config = {
		createPage: "/html/invigilatorapplication/create.jsp",
	    editPage: "/html/invigilatorapplication/edit.jsp",
	    detailPage: "/html/invigilatorapplication/view.jsp",
	    copyPage: "/html/invigilatorapplication/copy.jsp"
	};


function addNewRecord1(d){	
	AUI().use('liferay-portlet-url', function(A) {
	    var e =  Liferay.PortletURL.createRenderURL();
	    e.options.basePortletURL = baseUrl;
	    jspPage = config.editPage;
	    e.setParameter("formTypeName", modelName);
	    e.setParameter("jspPage", jspPage);
	    e.setPortletId(namespace.replace(/(^\_+|\_+$)/mg, ''));
	    e.setWindowState("normal");
	    //window.location.href = e.toString();
	    var pattern = /__/g;
	   // var dd = e.toString();
	    var dd = baseUrl;
	    //window.location.href = "www.google.com";
	    window.location.href = dd.replace(pattern,"_");
	 });
}


//for submit confir
 function Sucessfulldata(){	
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
           
           
            Y.one('.close1').on(
            	      'click',
            	      function() {
            	    	  
            	        location.reload();
            	      }
            	    );
        });

    });
} 

//




//for popup




function showBankError(){
	var boundingBox = "#deactivation-success";
	var contentBox = "#inactive-success-box";
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

//contract sevice popup

function showPopupContract(){
	var boundingBox = "#contract-service-popup";
	var contentBox = "#inactive-success-box-popup";
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
           
           
            Y.one('.close2').on(
            	      'click',
            	      function() {            	    	  
            	        modal.hide();
            	      }
            	    );
        });

    });
}


//changed plain list value

function onChecked(e) {	
			var tr = e.parentElement.parentElement;
				for (var i = 0; i < planList.length; i++) {
					 if (tr.getElementsByClassName("tvlID")[0].innerHTML == planList[i].storageId) {
						planList[i].AppointmentStatus = tr.getElementsByClassName("appointmentstatus")[0].value;						
					 } 
				}		
}

		function getUserAppointmentsList(thisInstance,userid)
		 {
			var data1 = {};
			var filterdata=[];
			data1.limit= 10;
			var filterdata = [];
			data1.modelName=formType;
			data1.page=0;
			data1.formStorageId = userId;
			data1.formType = formType;
			var jsonsearchparameter = {"modelName":modelName,"formType":modelName};
			jsonsearchparameter["condition"]="";
			var filter = {};
			filter["contentJson.UserId"] = [userId];
			//filter["contentJson.UserId"] = ["300516"];
				
				
			filterdata.push(filter);
			jsonsearchparameter["filterdata"]=filterdata;
			//
			
			var table1 = document.getElementById('invigilaotr');
			ajaxCall('GET','elastiSearchList',elastisearchlisturl,jsonsearchparameter,
			//ajaxCallAPI('GET','elastiSearchList',data1,
				 function() {
						
		               var response = this.get("responseData");
		               if (_.isEmpty(response)) {
		                   console.log("error");
		                   displayMessage('danger', "Sub-Schedule Date Range is overlapping", 3000);
		               } else {		            	  		            	   
		            	   console.log(response.content.length)
		            	   if(response.content.length==0)
		            		   {
		            		     document.getElementsByClassName('no-data-listing')[0].style.display = "block";		            		    
		            		   }
		            	   else {
		            		   debugger;
				            	  for(var i=0;i<response.content.length;i++)
				            		 { 
					            		document.getElementsByClassName('DateDescription')[0].style.display = "block";
					            		document.getElementsByClassName('subbtn')[0].style.display = "block";
				            		    var item =response.content[i].contentJson;
				            		   item.storageId=response.content[i].storageId;
				            		   var session = "";
				            		   if(item.Session && item.Session != ""){
				            			   session = item.Session;
				            		   }else if(item.SessionType && item.SessionType != ""){
				            			   session = item.SessionType;
				            		   }
				            		   //item.storageId=item.storageId;
				            		   item.SessionType = session;
				            		   //bankDetail.push = 
				            		   planList.push(item);		            		   
								       drawTable();		            		 
				            	  }
		            	       }
			               }
			
		           },
		           function() {
		               
		    		});
			
			
		}
		
		function moveToDashboard(){			
			window.location.href = dashBoardLink;
		}
		
</script>
<% } %>
