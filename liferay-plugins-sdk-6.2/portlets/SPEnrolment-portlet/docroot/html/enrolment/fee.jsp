<%@page import="com.sambaash.platform.enrolement.EnrolmentConstants"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="java.util.Map"%>
<%@ page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@ page import="com.sambaash.platform.util.SambaashUtil"%>
<%@ page import="javax.portlet.PortletRequest"%>
<%@ page import="com.sambaash.platform.util.PermissionUtil"%>
<%@ page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@ page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@ page import="com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil"%>
<%@page import="com.fasterxml.jackson.databind.SerializationFeature"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tld/sp-formio" prefix="sp-formio"%>

<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='<%=request.getContextPath()%>/css/main.css?c=<%=System.currentTimeMillis()%>'>
<link rel='stylesheet' href='<%=request.getContextPath()%>/css/switchsubjects.css?c=<%=System.currentTimeMillis()%>'>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/main.js?c=sdllsdds"></script>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2"></script>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:renderURL var="programme">
	<portlet:param name="jspPage" value="/html/enrolment/program.jsp" />
</portlet:renderURL>

<portlet:renderURL var="homePage">
  <portlet:param name="jspPage" value="/html/enrolment/view.jsp" />
</portlet:renderURL>

<portlet:resourceURL var="resourceURL" >
	<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
</portlet:resourceURL>

<portlet:resourceURL var="ajaxUrl">
	<portlet:param name="p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
</portlet:resourceURL>

<%
   String enrolmentId  = request.getParameter("enrolmentId"); 
	String sponsorshipType = request.getParameter("sponsorshiptype");
	String corporateName = request.getParameter("corporatename");
	String corporateCode = request.getParameter("corporatecode");
	String dashBoardLink = SambaashUtil.getDashBoard();
	Map<String, String> categoryMap = SPFinanceLocalServiceUtil.getSpListTypeMap("finance.referencenumber.categorytype",request);
	Map<String, String> transactionTypeMap = SPFinanceLocalServiceUtil.getSpListTypeMap("finance.accountingtable.transactiontype",request);
	Map<String, String> clientTypeMap = SPFinanceLocalServiceUtil.getSpListTypeMap("finance.accountingtable.clienttype",request);
	Map<String, String> functionalComponentMap = SPFinanceLocalServiceUtil
			.getFunctionalComponentDisplayMap(request);
	Map<String, String> productMap = SPFinanceLocalServiceUtil.getSpListTypeMap("finance.accountingtable.productype",request);
	Map<String, String> productSubtypeMap = SPFinanceLocalServiceUtil.getProductSubTypeMap(request);
	Map<String, String> sourceTypeMap = SPFinanceLocalServiceUtil.getSpListTypeMap("finance.transaction.sourcetype",request);
	ObjectMapper objectMapper = new ObjectMapper();
	objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	String subProduct = themeDisplay.getLayout().getTypeSettingsProperty("subProduct");
	String collectPaymentUrl = renderRequest.getPreferences().getValue("collectPaymentBaseUrlPref","");
	String cancelUrl = portletPreferences.getValue(EnrolmentConstants.PREF_ENROLMENT_CANCEL_URL, EnrolmentConstants.DEFAULT_ENROLMENT_CANCEL_URL);
	if (StringUtils.isEmpty(cancelUrl)) {
		cancelUrl = EnrolmentConstants.DEFAULT_ENROLMENT_CANCEL_URL;
	}
	String vm = (String) request.getParameter(EnrolmentConstants.VIEW_MODE_PARAM);
	String listingPageUrl = renderRequest.getPreferences().getValue("baseUrlPref","");
%>

<div class="newPortlets">
    <div class="subHeader">
        <div class="container">
        	<div class="inner-container">
	            <aui:row>
	                <aui:col span="10" cssClass="text-center ">
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
    <div class="container fee-container">
        <div>
            <div class="data-lising fees-container container">
                <aui:row>
                    <div class="text-center">
                        <div class="enrolment-center-align tabs mt-50">
                            <div class="tab">SPONSORSHIP</div>

                            <div class="tab">CANDIDATE</div>

                            <div class="tab">PROGRAMME & SUBJECTS</div>

                            <div class="tab tab-selected">FEE</div>
                        </div>
                    </div>
                    <br>
                    <div id="fee-container">
                        <div id="standardFeeToggler">
                            <h4 class="standardFeeHeader fee-toggler-header toggler-header-expanded">
                                <span>STANDARD FEE</span>
                            </h4>
                            <div class="standardFeeContent toggler-content-expanded ">
                                <table id="fees" class="aui">
                                    <thead>
                                        <tr class="Heading">
                                            <th>Subject Code & Title</th>
                                            <th>Pricing SubType</th>
                                            <th>Subject Type</th>
                                            <th>CCY</th>
                                            <th>Amount (Incl GST)</th>
                                            <th>Amount in SGD (Incl GST)</th>
                                        </tr>
                                    </thead>
                                    <tbody id="standardFeeData">

                                    </tbody>
                                </table>
                            </div>
                        </div>

                        <div id="miscellaneousFeesToggler">
                            <h4 class="miscellaneousFeesHeader fee-toggler-header toggler-header-expanded">
                                <span>MISCELLANEOUS FEE</span>
                            </h4>
                            <div class="miscellaneousFeesContent toggler-content-expanded">
                                <!-- <div id="miscFeesMultiSelect"></div> -->
                                <select id="miscFeesSelect" onchange="renderMiscFeesTable()">

                                </select>
                                <div id="miscFeesSelectedItemsGrid">
                                    <table id="misc-fees" class="aui">
                                        <thead>
                                            <tr class="Heading">
                                                <th>Misc. Fee</th>
                                                <th>Fee (incl GST)</th>
                                                <th>Quantity</th>
                                                <th>Total Fees ($)</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody id="miscFeeTableData">

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
					</div>
                    <div class="title-container mt-4">
                            <img src="<%=request.getContextPath()%>/img/fee.png" srcset="<%=request.getContextPath()%>/img/fee@2x.png 2x,
            img/fee@3x.png 3x"
                                class="title-icon">


                            <span class="title">TOTAL FEE PAYABLE</span>
                        <div class="horizontal-line"></div>
                    </div>
                    <div class=''>
                        <table id="fees-summary" class="aui">
                            <thead>
                                <tr class="Heading">
                                    <th>ID No</th>
                                    <th>Name</th>
                                    <th>Programme Code</th>
                                    <th>Programme Title</th>
                                    <th>Standard Fee (Incl GST)</th>
                                    <th>Total Misc. Fee (Incl GST)</th>
                                    <th>GST</th>
                                    <th>Total Fee (excl GST)</th>
                                    <th>Total Fee Payable</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr id="fess_data_row" class="fees_table_row Row">
                                    <td><label id="lEnrolmentId">S9087125</label></td>
                                    <td><label id="lName">Aaron Wolfe</label></td>
                                    <td><label id="lProgrammeCode">BSBF001</label></td>
                                    <td><label id="lProgrammeTitle">B.Sc in Banking</label></td>
                                    <td><label id="lStandardFee">0.00</label></td>
                                    <td><label id="lMiscFee">0.00</label></td>
                                    <td><label id="lGST">0.00</label></td>
                                    <td><label id="lTotalFee">0</label></td>
                                    <td><label id="lTotalPayable">0.00</label></td>
                                </tr>

                            </tbody>
                        </table>
                    </div>
                </aui:row>
                <div class="enrolment-center-align py-5 userAction">
                    <aui:button-row cssClass="text-center">
                        <aui:button type="button" onclick="backToProgramme()" value="PREVIOUS" />
                        <% if(PermissionUtil.canEditModel((PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
                        <aui:button cssClass="btn-primary verifyBtn" onclick="updateEnrolment('Verified', true)" value="MARK AS VERIFIED" />
                        <aui:button cssClass="saveBtn" type="button" onclick="updateEnrolment('Pending', true)" value="SAVE" />
                        <% } %>
                        <aui:button type="button" onclick="onCancelProcess()" value="CANCEL" />
                    </aui:button-row>
                </div>
            </div>
        </div>

    </div>
    
    
    <div class="yui3-skin-sam">


		<div id="payment-record" hidden="true" class="modalpopupBox">
			<div id="payment-record-box" class="modalpopupContent">
				<form class="formContainer" action="">


					<aui:row>
						<aui:col span="12">
							<h3 class="success-msg">Enrolment Successful!</h3>
						</aui:col>

					</aui:row>
					<aui:row>
						<aui:col span="12">
							<button type="button"
								class="btn btn-primary popup-confirm-deactivate pull-left proceedToPay" onclick="proceedToPay();">Proceed to Pay</button>
							<button type="button"
								class="btn btn-default popup-cancel-deactivate pull-right startAgain" onclick="backToListing();">Back To Listing</button>
						</aui:col>
					</aui:row>
				</form>

			</div>
		</div>
	</div>
	
	
    </div>
</div>
<script>

var mode = "view";
var mode1 = "view";
var programmeUrl = "<%=programme%>";
var namespace = "<portlet:namespace/>";
var selectedMiscFees = [];
var assetsPath = "<%=request.getContextPath()%>";
var enrolmentId = "<%= enrolmentId %>";
var ajaxurl = "<%= ajaxUrl.toString()%>";
var homeUrl = "<%=cancelUrl%>";

var standardFee = 0;
var standardFeeBeforeGST = 0;
var standardTaxAmount = 0;
var miscFee = 0;
var GST = 0;
var totalFee = 0;
var totalPayable = 0;

var namespace = "<portlet:namespace/>";
var miscFees = [];
var selectedMiscFees = [];


var _SCOPE_GROUP_ID = <%=SambaashUtil.getScopeGroupId(themeDisplay.getScopeGroupId())%>;


// To store total misc fees  
var totalMiscFeesAmount = 0;
var priceSchemeCode = [];
var programmeScheduleCode;
var subjects = [];
var enrolment;

var categoryMap = <%=objectMapper.writeValueAsString(categoryMap)%>;
var transactionTypeMap = <%=objectMapper.writeValueAsString(transactionTypeMap)%>;
var clientTypeMap = <%=objectMapper.writeValueAsString(clientTypeMap)%>;
var functionalComponentMap = <%=objectMapper.writeValueAsString(functionalComponentMap)%>;
var productMap = <%=objectMapper.writeValueAsString(productMap)%>;
var productSubtypeMap = <%=objectMapper.writeValueAsString(productSubtypeMap)%>;
var sourceTypeMap = <%=objectMapper.writeValueAsString(sourceTypeMap)%>;
var subProduct = <%=subProduct%>;
var collectPaymentUrl = "<%=collectPaymentUrl%>";
var vm = "<%=vm%>";
var isViewMode = vm === "000";
var sponsorshipType = "<%=sponsorshipType%>";
var listingPageUrl = "<%=listingPageUrl%>";
</script>

<aui:script use="liferay-upload">

    retrieveAllFees();
	//getMiscFeePricing();
    // used to toggle components
    YUI().use(
        'aui-toggler',
        function (Y) {
            new Y.TogglerDelegate(
                {
                    animated: true,
                    closeAllOnExpand: false,
                    container: '#standardFeeToggler',
                    content: '.standardFeeContent',
                    expanded: true,
                    header: '.standardFeeHeader',
                    transition: {
                        duration: 0.2,
                        easing: 'cubic-bezier(0, 0.1, 0, 1)'
                    }
                }
            );
        }
    );
    
 	// used to toggle components
    YUI().use(
        'aui-toggler',
        function (Y) {
            new Y.TogglerDelegate(
                {
                    animated: true,
                    collapse: false,
                    closeAllOnExpand: false,
                    container: '#miscellaneousFeesToggler',
                    content: '.miscellaneousFeesContent',
                    expanded: true,
                    header: '.miscellaneousFeesHeader',
                    transition: {
                        duration: 0.2,
                        easing: 'cubic-bezier(0, 0.1, 0, 1)'
                    }
                }
            );
        }
    );

    
    function retrieveAllFees()
    {
    	
    	var qbe = {storageId: enrolmentId};
    	console.log(qbe);
    	Liferay.Service("/SystemModelSetup-portlet.system/get-model-list",
		  {
		    modelName: 'enrolment',
		    fieldList: '',
		    groupId: _SCOPE_GROUP_ID,
		    matchJsonString: JSON.stringify(qbe),
		    sortString: ''
		  },
		  function(enrolmentList) {
			if (enrolmentList.length > 0 && enrolmentList[0]) {
				enrolment = enrolmentList[0];
			 	
			 	document.getElementById("lEnrolmentId").innerHTML = enrolment.IDNumber ;
			 	document.getElementById("lName").innerHTML = enrolment.FullName;
			 	document.getElementById("lProgrammeCode").innerHTML = enrolment.programSemester.ProgrammeCode;
			 	document.getElementById("lProgrammeTitle").innerHTML = enrolment.programSemester.ProgrammeTitle;
			 	var subjectCodes = [];
			 	var subjectTypes = [];
			 	var fullUnits = 0;
			 	var halfUnits = 0;
			 	var lawUnits = 0;
			 	var subjectMap = {};
			 	subjects = enrolment.subjects;
			 	enrolment.subjects.forEach(function(subject){
			 		
			 		subjectMap[subject.SubjectCode] = subject;
			 		var st = subject.SubjectType.replace(" ","");
			 		subjectCodes.push(subject.SubjectCode);
			 		subjectTypes.push(st);
			 		switch (st) {
					case "FullUnit":
						++fullUnits;
						break;

					case "HalfUnit":
						++halfUnits;
						break;

					case "LawUnit":
						++lawUnits;
						break;

					default:
						break;
					}
			    });

			 	// retrieve programme pricing
			 	qbe = { ModelLeft:"Schedule", ModelLeft1:"Programme", ModelRight:"PriceScheme", 
						StorageIdLeft: enrolment.programSemester.ScheduleCode,
						StorageIdLeft1: enrolment.programSemester.ProgrammeCode
			 		  };
			 	Liferay.Service("/SystemModelSetup-portlet.system/get-entity-link",
	 			  {
	 			    groupId: _SCOPE_GROUP_ID,
	 			    queryByExampleJsonString: JSON.stringify(qbe),
	 			    returnFieldList: '',
	 			    retrieveModelDetails: 'ModelRight',
	 			    flatten: true
	 			  },
	 			 
	 			  function(pricingSchemeList) {
				  	if (pricingSchemeList.length > 0 && pricingSchemeList[0]) {
				  		document.getElementsByClassName("userAction")[0].style.display = "block";
				  		pricingSchemeList.forEach(function(priceScheme) {
				  			console.log(priceScheme);
				  			if (priceScheme.PricingType === 'MiscFees') {
				  				miscFees = getMiscFeesData(enrolment, priceScheme);
				  			} else {
								var programmeType =  enrolment.programSemester.RegulationType;
								if(programmeType == 'Modular')programmeType = 'ExamModular';
								var isModular = programmeType === 'ExamModular';
								programmeScheduleCode = enrolment.programSemester.storageId;
								priceSchemeCode =  priceScheme.StorageIdRight;
								
								// retrieve standard fees
								var inputJson = {
										scopeGroupId: _SCOPE_GROUP_ID,
									    programmeScheduleCode: programmeScheduleCode,
									    scheduleCode: enrolment.programSemester.ScheduleCode,
									    programmeType: programmeType,
							   		    fullUnitNumber: !isModular && fullUnits>0?fullUnits:'',
							   		    halfUnitNumber: !isModular && halfUnits>0?halfUnits:'',
							   		    lawUnitNumber: !isModular && lawUnits>0?lawUnits:'',
							   		    dateString: SambaashUtils.today(),
							   		    priceSchemeCode:priceSchemeCode,
							   		    promoCode: priceScheme.PromoCode ? priceScheme.PromoCode : '',
							   		    subjectCodes: subjectCodes.join(),
							   		    subjectTypes: subjectTypes.join(),
								        dateFormat: 'MM/dd/yyyy',
								        roundingScale: '2',
								        roundingMode: 'HALF_UP',
								        baseCurrency: 'SGD',
								        baseCurrencyCode: '',
								        priceCategory: '',
								        action: '',
								        purposeForExchangeRate: 'Pricing Engine'
									  }
								Liferay.Service("/SPPricingEngine-portlet.sppricingengine/get-pricing",
										inputJson,
								  function(data) {
									renderFeeStructureTableData(data, subjectMap);	
								  }
								);				  				
				  			}
				  		});
			  		} else{
			  			alert("No Pricing Scheme linked");
			  			document.getElementsByClassName("userAction")[0].style.display = "none";
			  		}	    
	 			}); 
			  } // if 	
			});
		if (isViewMode) {
			AUI().one("#miscFeesSelect").setAttribute("disabled","true");
			AUI().one(".verifyBtn").hide();
			AUI().one(".saveBtn").hide();
		}
    }
</aui:script>

<script>
function getFeePricing() {
    var data = {
    		  "programmeScheduleCode" : programmeScheduleCode,
    		  "priceSchemeCode" : priceSchemeCode,
    		  "formType":"programmefee",
    		  "miscellaneousFee" : selectedMiscFees,
    		  "subjects": subjects,
    		  "programmeId":enrolment.programSemester.ProgrammeCode,
    		  "candiadteId":enrolment.candidateId,
    		  "programmeName":enrolment.programSemester.ProgrammeTitle,
    		  "fee": fees
    };

    ajaxCall(
        "POST",
        "saveFees",
        ajaxurl,
        data,
        function () {
            var data = this.get("responseData");
            if (_.isEmpty(data)) {
                console.log("error");
            } else {
               alert("Saved");
            }
        },
        function () {

     });
}
function updateEnrolment(status, _showSuccessPopup){
	if(standardFee > 0){
		var data = {
		  		  "enrolmentId" : enrolmentId,
		  		  "formType":"enrolment",
		  		  "fees":subjectFees,
		  		  "MiscFees":miscFeesArray,
		  		  "endPoint":"verify",
		  		  "EnrolmentStatus":status,
		  		  "ProductType":productMap["Exam"],
		  		"ProductSubType":subProduct,
		  		"CategoryType":categoryMap["IN"],
		  		"ClientType":clientTypeMap["Individual"],
		  		"FunctionalComponent":functionalComponentMap["Finance"],
		  		"SourceType":sourceTypeMap["EN"],
		  		"TxnType":transactionTypeMap["Invoice"],
		  		"categoryMap":JSON.stringify(categoryMap),
		  		"purposeForExchangeRate": 'Pricing Engine'
		  };

		  ajaxCall(
		      "POST",
		      "verify",
		      ajaxurl,
		      data,
		      function () {
		          var data = this.get("responseData");
		          if (_.isEmpty(data)) {
	                 alert("Error setting enrolment status to "+status);
		          } else if(status=="Pending") {
		             showSuccessPopup("Record saved successfully!", true);
		          } else {
		        	  showSuccessPopup();
		          }
		      },
		      function () {

		   });
		
	}else{
		alert("Unable to enroll");
	}
	
}

var fees = [];

function backToProgramme() {
	var link = programmeUrl + "&"+namespace+"storageId=" + enrolmentId+ "&"+namespace+"candidateId=" + enrolment.CandidateId;
    if (isViewMode) {
    	link += "&" + namespace + "_vm=000";
    }
    location.href = link;
}
function onCancelProcess() {
	location.href = homeUrl;
}

function sendNotification(notificationType, newEnrolmentStatus){
	var data = {
	        "enrolmentIds": [enrolmentId],
	        "formType": "enrolment",
	        "endPoint": "fetchEnrolments",
	        "notificationType": notificationType
	    };
	ajaxCall(
        "POST",
        "sendNotification",
        ajaxurl,
        data,
        function() {
            var data = this.get("responseData");
            if (_.isEmpty(data)) {
            	alert("Email notification error");
            } else if (newEnrolmentStatus) {
            	SambaashUtils.applyContentJsonPatch(_SCOPE_GROUP_ID, 'enrolment', enrolmentId, {EnrolmentStatus: newEnrolmentStatus})
            }
        }
    );
}

function proceedToPay() {
	sendNotification("tempcredential");
	SambaashUtils.applyContentJsonPatch(_SCOPE_GROUP_ID, 'enrolment', enrolmentId, {EnrolmentStatus: "Notified"});
	location.href = collectPaymentUrl+"&receiptFor=candidate&userId="+enrolment.CandidateId+"&idNumber="+enrolment.IDNumber+"&userName="+enrolment.FullName;
}


</script>