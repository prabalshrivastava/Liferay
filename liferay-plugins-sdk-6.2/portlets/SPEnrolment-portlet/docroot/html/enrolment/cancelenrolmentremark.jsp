<%@ page import="com.sambaash.platform.util.PermissionUtil"%>
<%@ page import="com.sambaash.platform.util.SambaashUtil"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="javax.portlet.PortletRequest"%>
<%@ page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="/tld/sp-formio" prefix="sp-formio"%>

<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/switchsubjects.css?<%=System.currentTimeMillis()%>"/>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='<%=request.getContextPath()%>/css/main.css?<%=System.currentTimeMillis()%>'>
<script
  type="text/javascript"
  src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
  language="javascript1.2"
></script>
<portlet:defineObjects />
<portlet:resourceURL var="ajaxUrl"> </portlet:resourceURL>
<portlet:renderURL var="sponsorshipLink">
  <portlet:param name="jspPage" value="/html/enrolment/sponsorship.jsp" />
</portlet:renderURL>

<portlet:renderURL var="batchEnrolement">
  <portlet:param name="jspPage" value="/html/enrolment/batch/upload.jsp" />
</portlet:renderURL>

<portlet:renderURL var="homePage">
  <portlet:param name="jspPage" value="/html/enrolment/view.jsp" />
</portlet:renderURL>

<portlet:renderURL var="listLink">
  <portlet:param name="jspPage" value="/html/enrolment/candidatelist.jsp" />
</portlet:renderURL>

<portlet:renderURL var="uploadLink">
  <portlet:param name="jspPage" value="/html/enrolment/batch/upload.jsp" />
</portlet:renderURL>


<div class="newPortlets">
  <div class="subHeader">
    <div class="container">
    	<div class="inner-container">
      <aui:row>
        <aui:col span="10" cssClass="text-center"><h2><span>Cancel Enrolment</span></h2></aui:col
        >
        <aui:col span="2" cssClass="text-right"
          ><aui:a href="<%= homePage %>" title="Back to Home">Back to Home
            </aui:a>
          </aui:col>
      </aui:row>
      </div>
    </div>
  </div>
<div class="w-95 mx-auto">
  <div class="enrolment-center-align py-5">
      <label class='title'>Reasons for Cancellation</label>
      <textarea id="cancelreason" placeholder="Enter the reason..." class="reason-textarea"></textarea>
      </div>
      <div class="enrolment-center-align py-5">
            <aui:button-row cssClass="text-center">
                <aui:button cssClass="btn-primary" type="button" value="Yes" onclick="cancelEnrolment(this);"/>
                <aui:button type="button" value="No" onclick="backToListing()" />
            </aui:button-row>
       </div>
   </div>
   	<div class="yui3-skin-sam">
		<div id="cancelenrolment-success" hidden="true" class="modalpopupBox">
			<div id="active-success-box" class="modalpopupContent">

				<aui:row>
					<aui:col span="12">
						<h3>Enrolment Cancelled Successfully</h3>
					</aui:col>
				</aui:row>
				<aui:button-row cssClass="text-center">
					<aui:col span="12">
						<button class="btn-primary" onclick="backToListing()" style="width: auto;">BACK TO LISTING</button>
					</aui:col>
				</aui:button-row>
			</div>
		</div>
	</div>
	<% String formStorageId;
	if(request.getParameter("formStorageId")!="null"){
		formStorageId = request.getParameter("formStorageId");
	}else{
		formStorageId = "0";
	} %>
</div>

<script>
var listLinkURL = "<%=listLink%>";
var ajaxUrl = "<%= ajaxUrl.toString()%>";
var data = {};
data.formStorageId = "163375";
var namespace = "<portlet:namespace/>";
data.formType = "Candidate";
loadCandidate();
var instance;
var candidate;
function afterFormLoadedFormIOForm(thisInstance) {
	instance = thisInstance;
}
function loadCandidate()
{
	ajaxCall('GET', 'loadData', ajaxUrl, data, function() {
		candidate = this.get("responseData");
		if (candidate == null || candidate == "" || candidate==undefined) {
			console.log("error");
		} else {
		
		}
	}, function() {
		showLoading(false);
	});

}
function cancelEnrolment(d)
{
	var reason = document.getElementById('cancelreason').value;
	console.log(candidate);
	var status = candidate.contentJson.EnrolmentStatus;
	candidate.contentJson['cancelreason']  = reason;
	candidate.contentJson.EnrolmentStatus = "Cancelled";
	ajaxCallAPI('POST', "loadData", candidate, function() {
		var	data = this.get("responseData");
		if (data.error) {
			console.log('error . . . ');
			//displayMessage('danger', data.error);
		} else { 
			console.log(data);
console.log('success')
		}
	}, function() {
		//displayMessage('danger',"Error in persisting dynamic form data.");
	});	
	showPopupSuccess('active',d);
}
function showPopupSuccess(status,d){
	
	AUI().use('aui-base', function(A) {
        if(status.toLowerCase() == 'inactive'){
        	var boundingBox = "#cancelenrolment-success";
        }
        if(status.toLowerCase() == 'active'){
        	var boundingBox = "#cancelenrolment-success";
        	var contentBox = "#active-success-box";
        }
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
function backToListing()
{
	location.href = listLinkURL;
}
</script>