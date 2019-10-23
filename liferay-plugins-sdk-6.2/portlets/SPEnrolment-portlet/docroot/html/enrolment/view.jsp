<%@ page import="com.sambaash.platform.util.PermissionUtil"%>
<%@ page import="com.sambaash.platform.util.SambaashUtil"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="javax.portlet.PortletRequest"%>
<%@ page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="/tld/sp-formio" prefix="sp-formio"%>

<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='<%=request.getContextPath()%>/css/main.css?<%=System.currentTimeMillis()%>'>

<portlet:defineObjects />
<theme:defineObjects/>

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

<%
String dashBoardLink = SambaashUtil.getDashBoard();
%>
<style>
#searchComponent .formio-form{padding:0;}
</style>



<div class="newPortlets">

    <div class="subHeader">
        <div class="container">
        	<div class="inner-container">
	            <aui:row cssClass='d-flex justify-content-between'>
	            	<aui:col span="2" cssClass="text-left header-home-link position-relative">
	                	<aui:a href="<%=batchEnrolement%>" title="Enrolment Batch upload">Batch Enrolment</aui:a>
	                </aui:col>
	                <aui:col span="8" cssClass="text-center header-title view-header">
	                    <h2><span>PROCESS ENROLMENT</span></h2>
	                </aui:col>
	                <aui:col span="2" cssClass="text-right header-home-link">
	                    <a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</a>
	                </aui:col>
	            </aui:row>
	        </div>
        </div>
    </div>
    <div class="enrolment-body enrolment-center-align">

	    <div class="container">
			<div class="inner-container">
	        <aui:row>
	            <aui:col span="12" cssClass="text-center pt-100">
	                <img src="<%=request.getContextPath()%>/img/image-enrol.jpg">
	            </aui:col>
	        </aui:row>
	
	        <div class="text-center enrolment-ready-enroll-text">Ready to Enroll a Candidate?</div>
	
	        <aui:row>
	            <aui:col span="12" cssClass="text-center">
	                <div id="panel" class="enrolment-panel" onclick="onHidePanel()">
	                    <img src="<%=request.getContextPath()%>/img/icons-8-pen-96.jpg">
	                    <label class="text-blue">Search Existing Candidate</label>
	                </div>
	                <div id="createstudent" class="enrolment-panel" onclick="onShowPanel()">
	                    <img src="<%=request.getContextPath()%>/img/icon-manual-create.png">
	                    <label class="text-blue">Create New Candidate</label>
	                </div>
	            </aui:col>
	        </aui:row>
	
	        <div id="searchComponent" class="formComponent enrolment-center-align mt-50 hide">
	            <sp-formio:FormIO cssClass="formContainer" formId="1950" readOnly="false" formStorageId="0" />
	        </div>
	
	        <div class="enrolment-center-align ">
	            <aui:button-row cssClass="text-center">
	            <% if(PermissionUtil.canEditModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
	                <aui:button cssClass="btn-primary" name="saveButton" value="PROCEED" onClick="proceedToSponsors()" />
	                
	            <%  } %>
	                <aui:button type="button" onClick="cancelSelection()" value="CANCEL" />
	            </aui:button-row>
	        </div>
	    </div>
	   </div>
</div>
</div>

<script type="text/javascript">
    var mode = "view";
    var namespace = "<portlet:namespace/>";
    var formInstance;
    var sponsorUrl = "<%=sponsorshipLink%>";

    function afterFormLoadedFormIOForm(thisInstance) {
        formInstance = thisInstance;
    }

    function proceedToSponsors() {
    	formInstance.form.submitForm().then(result => {
            var dataValue = result.submission;
            var selectedCandidate = formInstance.components.candidate.data.candidate;
            if (selectedCandidate) {
                var userId = selectedCandidate.UserId;
                var candidateSponsor = selectedCandidate.SponsorshipType;
                var corporateCode = selectedCandidate.CorporateCode;
                var corporateName = selectedCandidate.CorporateName;
                sponsorUrl += "&" + namespace + "userId=" + userId;
                sponsorUrl += "&" + namespace + "sponsorshiptype="+encodeURIComponent(candidateSponsor);
               	if (corporateCode && corporateCode !== 'null') {
               		sponsorUrl += "&" + namespace + "corporatecode=" + encodeURIComponent(corporateCode);
               		sponsorUrl += "&" + namespace + "corporatename=" + encodeURIComponent(corporateName);               		
               	}
                location.href = sponsorUrl;
            }
            return Promise.resolve(dataValue);
          }).catch(err => {
       	    formInstance.form.onSubmissionError(err);
            return Promise.reject(err);
          });
    }

    function proceedToCreateNewCandidate() {
        location.href = sponsorUrl + "&" + namespace + "formStorageId=" + 0;
    }

    function proceedToListing() {
        location.href = "<%=listLink%>";
    }

    function onHidePanel() {
        var searhComponent = document.getElementById("searchComponent");
        searhComponent.classList.remove('hide');

        var panel = document.getElementById("panel");
        panel.style.border = "solid 1px #0f349f";

        var studentpanel = document.getElementById("createstudent");
        studentpanel.style.border = "solid 0px";
    }

    function onShowPanel(redirect) {
        var searhComponent = document.getElementById("searchComponent");
        searhComponent.classList.add('hide');

        var panel = document.getElementById("panel");
        panel.style.border = "solid 0px";

        var studentpanel = document.getElementById("createstudent");
        studentpanel.style.border = "solid 1px #0f349f";

        //temporary... may need to remove from here
        proceedToCreateNewCandidate();
    }

    function cancelSelection() {
        var searhComponent = document.getElementById("searchComponent");
        searhComponent.classList.add('hide');

        var panel = document.getElementById("panel");
        panel.style.border = "solid 0px";
    }
</script>
