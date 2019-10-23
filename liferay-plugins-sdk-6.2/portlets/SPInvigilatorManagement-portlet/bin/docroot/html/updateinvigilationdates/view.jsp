<%@page import="com.sambaash.platform.util.LabelUtil"%>
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
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<%@ taglib	uri="/tld/sp-formio" prefix="sp-formio"%>  
<portlet:defineObjects />
<liferay-theme:defineObjects />
<% if(PermissionUtil.canEditModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
<%
String formId = portletPreferences.getValue(SystemSetupConstants.PREF_HTML_FORM_ID, "1996");
String formType = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME, "UpdateInvigilationsDatesModel");
String dashBoardLink = SambaashUtil.getDashBoard();
String storageId = request.getParameter("storageId");

String baseUrl = portletPreferences.getValue("baseUrlPref", "");
String toDate = portletPreferences.getValue("toDate", "");
//String formStorageId  = request.getParameter("storageId");

ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
String userId = String.valueOf(td.getUserId());
String formStorageId  = userId;
String countryListUrl = SambaashUtil.getParameter(SambaashConstants.API_COUNTRYLIST_URL,SambaashConstants.DEFAULT_GROUP_ID_LONG);
Long groupId = td.getLayout().getGroupId();
String vocabularyURL = SambaashUtil.getParameter(SambaashConstants.API_VOCABULARY_URL, groupId);

if(storageId != null && !storageId.equalsIgnoreCase("")){
	userId = storageId;
}
%>
<portlet:resourceURL var="resourceURL" >
	<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
</portlet:resourceURL>
<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center">
						<h2>
							<span><%=LabelUtil.getLabel(pageContext, themeDisplay, "invigilator.updatedates.title")%></span>
						</h2>
					</aui:col>
					<aui:col span="2" cssClass="text-right">
						<a href="<%=dashBoardLink%>" title="Back to Home">Back to
							Home</a>
					</aui:col>
				</aui:row>
			</div>
		</div>
		<div>
			<label class="text-center" style="margin-top: 30px">Enter
				only the periods you are available from <span id="currentdate"
				class="currentdate"> &nbsp; </span> To <span id="todate"></span>
			</label>
		</div>
	</div>
	<c:set var="formId" value="<%=formId%>" />
	<c:set var="formType" value='<%=formType%>' />
	<c:set var="formStorageId" value='<%=userId%>' />
	<div class="formRoot">
		<div class="innerFormRoot">
			<sp-formio:FormIO cssClass="formContainer updateInvigi"
				modelName="${formType}" formId="${formId}" readOnly="false"
				formStorageId="${formStorageId}" />
			<div class="yui3-skin-sam">
				<div id="sucess-popup12" hidden="true" class="modalpopupBox">
					<div id="sucess-popup-box12" class="modalpopupContent">
						<aui:row>
							<aui:col span="12" cssClass="text-center">

								<h3>
									<br />Duplicate date range is not allowed.
								</h3>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" cssClass="userAction">
								<button type="button" class="btn btn-primary close1">Ok</button>
							</aui:col>
						</aui:row>

					</div>
				</div>
			</div>
			<div class="yui3-skin-sam">
				<div id="invg-sucess-popup" hidden="true" class="modalpopupBox">
					<div id="invg-sucess-popup-box" class="modalpopupContent">
						<form class="formContainer">
							<aui:row>
								<aui:col span="12">
									<h3 id="invg-success-msg">
									</h3>
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col span="12">
									<button class="btn btn-default popup-confirm-archive pull-left"
										type="button" onClick="reloadPage()">Start Again</button>
									<button class="btn cancel btn-primary popup-cancel pull-right"
										type="button" onClick="goToDashboard()">Go Back</button>
								</aui:col>
							</aui:row>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
var dashBoardLink = "<%=dashBoardLink%>"
var mode = "edit";
var dontLoadData = false;
var documents;
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var appointmenttType = document.getElementById(namespace+"appointmenttype");
var userId = "<%= userId %>";
var formStorageId = "<%= formStorageId %>";
var vocabularyURL = "<%= vocabularyURL %>";
var baseUrl = "<%= baseUrl %>";
var toDate = "<%= toDate %>";
var counter = 1;
var table = document.getElementById("myTable");
AUI().use('event-base', function (A) {
	A.on('domready', function (thisInstance) {
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth()+1; //January is 0!
		var yyyy = today.getFullYear();
		if(dd<10) {dd = '0'+dd} 
		if(mm<10) {mm = '0'+mm}
		if(toDate == "")
		  {
			toDate = 0;
		  }
        var addDate = parseInt(toDate);
		var myNewDate = new Date(today);		
		myNewDate.setDate(myNewDate.getDate() + addDate);
		var dd1 = myNewDate.getDate();
		var mm1 = myNewDate.getMonth()+1; //January is 0!
		var yyyy1 = myNewDate.getFullYear();
		if(dd1<10) {dd1 =  dd1} 
		if(mm1<10) {mm1 = '0'+mm1} 		
		myNewDate = dd1 + '/' + mm1 + '/' + yyyy1;
		today = dd + '/' + mm + '/' + yyyy;
		var theDiv = document.getElementById("currentdate");
		 theDiv.innerHTML += today;
		 var theDiv1 = document.getElementById("todate");
		 theDiv1.innerHTML += myNewDate;		 			 		
	});
	
		
})

     
function afterFormLoadedFormIOForm(thisInstance){
	
	thisInstance.components["UserId"].setValue(userId.toString());
	thisInstance.formStorageId = userId;
	document.getElementsByClassName("cancelBtn")[0].addEventListener("click",goToDashboard);
}
var dublicate = true;
function validateFormIOForm(thisInstance){	
	checkAvalibiityDate1();
	if(dublicate == true) {
	    duplicateDateRangeError();	
	    document.getElementsByClassName("alert-success")[0].style.display="none";
	}else{
		 thisInstance.customSubmission(thisInstance.form.submission);
	}
}
 function checkAvalibiityDate(thisInstance)
 {
    var data = form1.form.data.AvailabilityList;
    var data2 = {};
    data2 = data;
   
    for(var i = 0; i<data.length;i++)
    	{
           for (var k=i+1;k<data.length;k++ )
        	   {
        	      if(form1.form.data.AvailabilityList[i].FromDate == form1.form.data.AvailabilityList[k].FromDate
        	    		  && form1.form.data.AvailabilityList[i].ToDate == form1.form.data.AvailabilityList[k].ToDate)
        	    	  {        	    	   
        	    	    dublicate = true;
        	    	  }else
        	    		  {
        	    		   dublicate = false;
        	    		  }
        	   }
    	
       }return dublicate;

 }
 
 function checkAvalibiityDate1(){
    var data = form1.form.data.AvailabilityList;
    dublicate = false;
    for(var i = 0; i<data.length;i++){
    	var fromDate1 =new Date(data[i].FromDate);
    	var toDate1 =new Date(data[i].ToDate);
    	for (var j=i+1;j<data.length;j++ ){
    		var fromDate2 =new Date(data[j].FromDate);
        	var toDate2 =new Date(data[j].ToDate);
    		if(fromDate1 <= fromDate2  && toDate1 >= fromDate2){
    			if(data[i].SessionType==data[j].SessionType){
        			
    			}
    			dublicate = true;
    			break;
    		}else if(fromDate1 <= toDate2  && toDate1 >= toDate2){
    			if(data[i].SessionType==data[j].SessionType){
        			
    			}
    			dublicate = true;
    			break;
    		}
 	   	}
    	if(dublicate){
    		break;
    	}
    }
    return dublicate;
 }

 function duplicateDateRangeError(){	
		var boundingBox = "#sucess-popup12";
		var contentBox = "#sucess-popup-box12";
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
	            	    	modal.hide();
	            	      }
	            	    );
	        });

	    });
	} 
 
 function afterFormSubmissionFormIOForm(thisInstance){
		var status = thisInstance.form.submission.data.Status;
		var msg = "";
		var boundingBox = "#invg-sucess-popup";
		var contentBox = "#invg-sucess-popup-box";
		var formTypeStr = thisInstance.formType.replace(/([a-zA-Z])(?=[A-Z])/g, '$1 ');
		if(actionPerformed == "Draft"){
			msg = "Record is saved in draft";
		}else if(formStorageId == "0"){
			msg = formTypeStr + " Created!";
		}
		 else if(actionPerformed == "Activated"){  //rajjan
			msg = formTypeStr + " Activated!";
			boundingBox = "#activation-success";
	    	contentBox = "#active-success-box";
		} 
		else if(actionPerformed == "Deactivated" ){
			msg = formTypeStr + " Deactivated!";
			boundingBox = "#deactivation-success";
	    	contentBox = "#inactive-success-box";
		}
		else {
			msg = "Invigilator Availability Period(s) successfully updated!";
		}
		document.getElementById('invg-success-msg').innerHTML = msg;  
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
	           Y.all('.close').on(
		         	      'click',
		         	      function() {
		         	    	reload();
		         	        modal.hide();
		         	      }
		         	    );
	        });

	    });
	}
</script>
<% } %>
