<%@page import="com.sambaash.platform.enrolement.EnrolmentConstants"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@ include file="/html/init.jsp" %>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%
	String sponsortype = request.getParameter("sponsorshiptype");
    if(Validator.isNull(sponsortype)) {
    	sponsortype = "";
    }
	String userId = request.getParameter("userId");
    if(Validator.isNull(userId)) {
    	userId = "0";
    }
    String dashBoardLink = SambaashUtil.getDashBoard();
	String corporateName = request.getParameter("corporatename");
	String corporateCode = request.getParameter("corporatecode");
	String enrolmentIdParam = request.getParameter("enrolmentId");
	
	String cancelUrl = portletPreferences.getValue(EnrolmentConstants.PREF_ENROLMENT_CANCEL_URL, EnrolmentConstants.DEFAULT_ENROLMENT_CANCEL_URL);
	if (StringUtils.isEmpty(cancelUrl)) {
		cancelUrl = EnrolmentConstants.DEFAULT_ENROLMENT_CANCEL_URL;
	}
	String vm = (String) request.getParameter(EnrolmentConstants.VIEW_MODE_PARAM);
%>

<portlet:renderURL var="candidate" >
	<portlet:param name="jspPage" value="/html/enrolment/candidate.jsp" />
	<portlet:param name="userId" value="<%= userId %>" />
</portlet:renderURL>

<portlet:renderURL var="homePage">
  <portlet:param name="jspPage" value="/html/enrolment/view.jsp" />
</portlet:renderURL>

<portlet:renderURL var="enrol" >
	<portlet:param name="jspPage" value="/html/enrolment/view.jsp" />
</portlet:renderURL>


<div class=" newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center header-title">
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
		<div class="text-center">
			<div class="enrolment-center-align tabs mt-50">
				<div class="tab tab-selected">SPONSORSHIP</div>

				<div class="tab">CANDIDATE</div>

				<div class="tab">PROGRAMME & SUBJECTS</div>

				<div class="tab">FEE</div>
			</div>
		</div>
	<div class="formComponent enrolment-center-align">
		<sp-formio:FormIO cssClass="formContainer" formId="1903"
			readOnly="false" formStorageId="0" />
	</div>
		


		<div class="text-center">
			<aui:button-row>
				<% if(EnrolmentConstants.VIEW_MODE.equals(vm) || EnrolmentConstants.EDIT_MODE.equals(vm)) {%>
				<aui:button onClick="proceedToCandidate()" cssClass="btn-primary"
					type="button" value="NEXT" />
				<aui:button cssClass="btn-primary hidden" disabled="true" type="button"
					value="SAVE" />
				<% } else {%>
				<aui:button onClick="backToEnrol()" type="button" cssClass="btn-default" value="PREVIOUS" />
				<aui:button onClick="proceedToCandidate()" cssClass="btn-primary"
					type="button" value="NEXT" />
				<aui:button cssClass="btn-primary hidden" disabled="true" type="button"
					value="SAVE" />
				<% }%>
				<aui:button type="button" onClick="onCancelProcess()" cssClass="btn-default" value="CANCEL" />
			</aui:button-row>
		</div>

	</div>
</div>

</div>

<script type="text/javascript">
var vm = "<%=vm%>";
var isViewMode = vm === "000";
var mode = "view";
var enrolUrl = "<%=enrol%>";
var candidateUrl = "<%=candidate%>";
var homeUrl = "<%=cancelUrl%>";
var enrolmentIdParam = '<%= enrolmentIdParam == null ? "" : enrolmentIdParam %>';
var sponsortype = "<%=sponsortype == null ? "" : sponsortype %>";
var corporateName = "<%=corporateName == null ? "" : corporateName %>";
var corporateCode = "<%=corporateCode == null ? "" : corporateCode %>";

var formInstance;

	function afterFormLoadedFormIOForm(thisInstance) {
	    formInstance = thisInstance;
	    if (sponsortype) {
		    formInstance.components.sponsortype.setValue(sponsortype);
   			var selectedCorporate = null; 
   			formInstance.components.corporateSponsor.dataReady.then( items => {
   	   			formInstance.components.corporateSponsor.selectOptions.forEach(
   	    				function(option) {
   	    					if (option.value.organizationId == corporateCode) {
   	    						formInstance.components.corporateSponsor.setValue(option.value);
   	    						return;
   	    					}
   	  			});
   			});   			
	    }
// 		console.log("isViewMode",isViewMode, vm);
	    if (isViewMode) {
	    	SPFormControl.disable("sponsortype", true);
	    }
	}

	function proceedToCandidate() {
		if (isViewMode) {
			loadCandidateTab();
		} else {
	        formInstance.form.submitForm().then(result => {
	        	loadCandidateTab();
	        });			
		}
    }

	function loadCandidateTab() {
        var sponsorshipType = formInstance.form.data.sponsortype;
        var corporateName = formInstance.form.data.CorporateName;
        var corporateCode = formInstance.form.data.CorporateCode;
        if(sponsorshipType!=null && sponsorshipType!="") {
	        var link;
	        link = candidateUrl + 
	          "&" + namespace + "sponsorshiptype=" + sponsorshipType ;
	        if(corporateName)
	        {
	            link += "&" + namespace + "corporatecode=" + corporateCode;
	            link += "&" + namespace + "corporatename=" + corporateName;
	        }
	        if (isViewMode) {
	        	link += "&" + namespace + "_vm=000";
	        }
	        if (enrolmentIdParam) {
	        	link += "&" + namespace + "enrolmentId=" + enrolmentIdParam;
	        }
	        location.href = link;
        } 		
	}
	
	function backToEnrol() {
		location.href = enrolUrl;
	}
	
	function onCancelProcess() {
		location.href = homeUrl;
	}
	

</script>