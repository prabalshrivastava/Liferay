<%@page import="com.fasterxml.jackson.databind.SerializationFeature"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil"%>
<%@page import="java.util.Map"%>
<%@ page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@ page import="com.sambaash.platform.util.SambaashUtil"%>
<%@ page import="javax.portlet.PortletRequest"%>
<%@ page import="com.sambaash.platform.util.PermissionUtil"%>
<%@ page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@ page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
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
<%@ page import="com.liferay.portal.util.PortalUtil" %>
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

<portlet:resourceURL var="ajaxUrl"> </portlet:resourceURL>

<%
HttpServletRequest r = PortalUtil.getHttpServletRequest(renderRequest);
String programme_code =  PortalUtil.getOriginalServletRequest(r).getParameter("programme_code");
String schedule_code =  PortalUtil.getOriginalServletRequest(r).getParameter("schedule_code");
String enrolmentId  = PortalUtil.getOriginalServletRequest(r).getParameter("enrolmentId");
String enrolmentIdsKey = PortalUtil.getOriginalServletRequest(r).getParameter("enrolmentIdsKey");
String dashBoardLink = SambaashUtil.getDashBoard();

Map<String, String> categoryMap = SPFinanceLocalServiceUtil.getSpListTypeMap("finance.referencenumber.categorytype",request);
Map<String, String> transactionTypeMap = SPFinanceLocalServiceUtil.getSpListTypeMap("finance.accountingtable.transactiontype",request);
Map<String, String> clientTypeMap = SPFinanceLocalServiceUtil.getSpListTypeMap("finance.accountingtable.clienttype",request);
Map<String, String> functionalComponentMap = SPFinanceLocalServiceUtil
		.getFunctionalComponentDisplayMap(request);
Map<String, String> productMap = SPFinanceLocalServiceUtil.getSpListTypeMap("finance.accountingtable.productype",request);
Map<String, String> productSubtypeMap = SPFinanceLocalServiceUtil.getProductSubTypeMap(request);
Map<String, String> sourceTypeMap = SPFinanceLocalServiceUtil.getSpListTypeMap("finance.transaction.sourcetype",request);
String subProduct = themeDisplay.getLayout().getTypeSettingsProperty("subProduct");
ObjectMapper objectMapper = new ObjectMapper();
objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
%>

<div class="newPortlets enrolment-body enrolment-center-align">
    <div class="subHeader">
        <div class="container">
        	<div class="inner-container">
	            <aui:row>
	                <aui:col span="10" cssClass="text-center ">
	                    <h2><span>PROCESS BATCH ENROLMENT</span></h2>
	                </aui:col>
	                <aui:col span="2" cssClass="text-right header-home-link">
	                    <a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</a>
	                </aui:col>
	            </aui:row>
            </div>
        </div>
    </div>

    <div class="container fee-container">
        <div>
            <div class="data-lising fees-container container">
                <aui:row>
                    <div class="text-center enrolmentFor">
                        You are doing a batch enrolment for 100 Candidates
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
                                            <th>Subject Code & Name</th>
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
                                  
                                    <td><label id="lProgrammeCode">BSBF001</label></td>
                                    <td><label id="lProgrammeTitle">B.Sc in Banking</label></td>
                                    <td><label id="lStandardFee">818.00</label></td>
                                    <td><label id="lMiscFee">0.00</label></td>
                                    <td><label id="lGST">0.53</label></td>
                                    <td><label id="lTotalFee">0</label></td>
                                    <td><label id="lTotalPayable">0.00</label></td>
                                </tr>

                            </tbody>
                        </table>
                         <div class="text-center enrolmentFor">
	                        You are doing a batch enrolment for 100 Candidates
	                    </div>
                    </div>
                </aui:row>
                <div class="enrolment-center-align py-5">
                    <aui:button-row cssClass="text-center">
                        
                        <aui:button cssClass="btn-primary" onclick="updateEnrolment('Verified')" value="MARK AS VERIFIED" />
                        <aui:button type="button" onclick="updateEnrolment('Pending')" value="SAVE" />
                        <aui:button type="button" onclick="goBack()" value="CANCEL" />
                    </aui:button-row>
                </div>
            </div>
        </div>
		<div class="yui3-skin-sam">
			<div id="process-enrolment-popup" hidden="true" class="modalpopupBox">
				<div id="process-enrolment-popup-box" class="modalpopupContent">
					<form class="formContainer" action="">
						<aui:row>
							<aui:col span="12">
								<h3>Enrolment(s) are processed successfully!</h3>
							</aui:col>
						</aui:row>
						<br/>
						<aui:row>
							<aui:col span="12" style="display:flex">
								<button type="button" style="margin: 0 auto;"
									class="btn btn-primary popup-confirm-deactivate pull-left"
									onclick="goBack();">Go Back</button>
							</aui:col>
						</aui:row>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
var _SCOPE_GROUP_ID = <%=SambaashUtil.getScopeGroupId(themeDisplay.getScopeGroupId())%>;
var mode = "view";
var mode1 = "view";
var programmeUrl = "<%=programme%>";
var miscFees;
var namespace = "<portlet:namespace/>";
var miscFees = [];
var selectedMiscFees = [];
var assetsPath = "<%=request.getContextPath()%>";
var enrolmentId = "<%= enrolmentId %>";
var enrolmentIdsKey = "<%=enrolmentIdsKey != null ? enrolmentIdsKey : ""%>";
var ajaxurl = "<%= ajaxUrl.toString()%>";


// To store total misc fees  
var totalMiscFeesAmount = 0;
var priceSchemeCode = [];
var programmeScheduleCode;
var subjects = [];
var enrolment;
var enrolmentIds = [];

var categoryMap = <%=objectMapper.writeValueAsString(categoryMap)%>;
var transactionTypeMap = <%=objectMapper.writeValueAsString(transactionTypeMap)%>;
var clientTypeMap = <%=objectMapper.writeValueAsString(clientTypeMap)%>;
var functionalComponentMap = <%=objectMapper.writeValueAsString(functionalComponentMap)%>;
var productMap = <%=objectMapper.writeValueAsString(productMap)%>;
var productSubtypeMap = <%=objectMapper.writeValueAsString(productSubtypeMap)%>;
var sourceTypeMap = <%=objectMapper.writeValueAsString(sourceTypeMap)%>;
var subProduct = <%=subProduct%>;

AUI().ready(function(A) {
	if(enrolmentId != "" && enrolmentId != "null"){
		enrolmentIds = [];
		enrolmentIds[0] = enrolmentId;
	} else {
		enrolmentIds = JSON.parse(getSessionData(enrolmentIdsKey));
	}
	//document.getElementById("enrolmentFor").innerHTML = 
	divs = document.getElementsByClassName( 'enrolmentFor' );

	[].slice.call( divs ).forEach(function ( div ) {
	    div.innerHTML = "You are doing a batch enrolment for "+ enrolmentIds.length +" Candidates";
	});
	retrieveAllFees();
}); 


function updateEnrolment(status){
	if(standardFee > 0){
		var data = {
				  "programmeCode" : enrolment.programSemester.ProgrammeCode,
				  "programmeId": enrolment.programSemester.ProgrammeCode,
				  "programmeName" : enrolment.programSemester.ProgrammeTitle,
				  "semesterCode" : enrolment.programSemester.ScheduleCode,
		  		  "enrolmentIds" : enrolmentIds,
		  		  "formType":"enrolment",
		  		  "fees":subjectFees,
		  		  "subjects":subjects,
		  		  "MiscFees":miscFeesArray,
		  		  "endPoint":"processbatch",
		  		  "EnrolmentStatus":status,
			  		"clientType":clientTypeMap["Individual"],
			        "categoryMap":JSON.stringify(categoryMap),
			        "ProductType":productMap["Exam"],
			  		"ProductSubType":subProduct,
			  		"CategoryType":categoryMap["IN"],
			  		"ClientType":clientTypeMap["Individual"],
			  		"FunctionalComponent":functionalComponentMap["Finance"],
			  		"SourceType":sourceTypeMap["EN"],
			  		"TxnType":transactionTypeMap["Invoice"],
			  		"purposeForExchangeRate": 'Pricing Engine'
		  };

		  ajaxCall(
		      "POST",
		      "sendRequest",
		      ajaxurl,
		      data,
		      function () {
		          var data = this.get("responseData");
		          if (_.isEmpty(data)) {
		              console.log("error");
		          } else {
		        	  showCustomPopup("#process-enrolment-popup", "#process-enrolment-popup-box");
		          }
		      },
		      function () {

		   });
		
	}else{
		alert("Unable to enroll");
	}
	
}

    
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
    	var qbe = {storageId: enrolmentIds[0]};
    	console.log(qbe);
    	Liferay.Service("/SystemModelSetup-portlet.system/get-model-list",
		  {
		    modelName: 'enrolment',
		    fieldList: '',
		    groupId: <%=SambaashUtil.getScopeGroupId(themeDisplay.getScopeGroupId())%>,
		    matchJsonString: JSON.stringify(qbe),
		    sortString: ''
		  },
		  function(enrolmentList) {
		 
			if (enrolmentList.length > 0 && enrolmentList[0]) {
				enrolment = enrolmentList[0];
			 	console.log(enrolment);
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
			 		console.log(subject);
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
	 			    groupId: <%=SambaashUtil.getScopeGroupId(themeDisplay.getScopeGroupId())%>,
	 			    queryByExampleJsonString: JSON.stringify(qbe),
	 			    returnFieldList: '',
	 			    retrieveModelDetails: 'ModelRight',
	 			    flatten: true
	 			  },
	 			 
	 			  function(pricingSchemeList) {
				  	if (pricingSchemeList.length > 0 && pricingSchemeList[0]) {
				  		pricingSchemeList.forEach(function(priceScheme) {
				  			console.log(priceScheme);
				  			if (priceScheme.PricingType === 'MiscFees') {
				  				miscFees = getMiscFeesData(enrolment, priceScheme);
				  			} else {
								var programmeType =  enrolment.programSemester.RegulationType;
								if(programmeType == 'Modular')programmeType = 'ExamModular';
								var isModular = programmeType === 'ExamModular';
								programmeScheduleCode = enrolment.programSemester.storageId;
								priceSchemeCode =  priceScheme.PricingSchemeCode;
								// retrieve standard fees
								var inputJson = {
										scopeGroupId: <%=SambaashUtil.getScopeGroupId(themeDisplay.getScopeGroupId())%>,
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
						   			renderMiscFees(enrolment.MiscFees);
								  }
								);				  				
				  			}
				  		});
			  		} // if		    
	 			}); 
			  } // if 	
			});

    }
    
function renderMiscFees(enrolmentMiscFees) {
	for(var emf in enrolmentMiscFees) {
		renderMiscFeeStructureTableData(enrolmentMiscFees[emf].priceSubType, enrolmentMiscFees[emf].quantity);
	}
}
</script>

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
function markVerified(){
	var data = {
  		  "enrolmentId" : enrolmentId,
  		  "formType":"enrolment",
  		  "endPoint":"verify",
  		  "EnrolmentStatus":"Verified",
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
              console.log("error");
          } else {
        	  showCustomPopup("#process-enrolment-popup", "#process-enrolment-popup-box");
          }
      },
      function () {

   });
}

// todo - Remove this and replace it with actual API
function getTotalStandardFeesAmount()
{
	return 32165;	
}
function setMiscFeeOptions()
{
	document.getElementById("miscFeesSelect").options.length = 0;
	
	var option = document.createElement("option");
    option.text = "Select Fees";
    option.value = "Select Fees";
    
    var select = document.getElementById("miscFeesSelect");
    select.appendChild(option);

	miscFees.forEach(function (fee) {
		appendMiscFees(fee);           
    });  
}

function appendMiscFees(fee)
{
	  var option = document.createElement("option");
      option.text = fee.priceSubType;
      option.value = fee.priceSubType;
      
      var select = document.getElementById("miscFeesSelect");
      select.appendChild(option);
}
var fees = [];

function onRemovemiscFeeElement(priceSubType)
{
	 var fee = selectedMiscFees.filter(function(fee) {
 		return priceSubType == fee.priceSubType
 	 });
	 
	 selectedMiscFees = selectedMiscFees.filter(function(fee) {
  		return priceSubType != fee.priceSubType
  	 });
	 
	 var row = document.getElementById("miscFee_"+priceSubType);
	 
	 row.parentNode.removeChild(row);  
	 
	 miscFees.push(fee[0]);
	 
	 appendMiscFees(fee[0]);
	 
}

function onChangeFeeQuantity(priceSubType)
{
	var quantity = document.getElementById("quantity_"+priceSubType).value;
	var amount = document.getElementById("amount_"+priceSubType);
	amount.innerHTML = parseFloat(quantity) * parseFloat(amount.dataset.amount);
	
	for(var i = 0; i < selectedMiscFees.length; i++){
		if(selectedMiscFees[i].priceSubType == priceSubType){
			selectedMiscFees[i].quantity = quantity;
		}
	}
	calculateTotalMiscFees();
}

function calculateTotalMiscFees()
{
	var dataAmount = document.querySelectorAll('[data-amount]');
	dataAmount.forEach(function (amount) {
		totalMiscFeesAmount = parseFloat(totalMiscFeesAmount) +  parseFloat(amount.innerHTML);
    });
	document.getElementById("lTotalFee").innerHTML = fees[0].totalResult.amountBeforeGST + (selectedMiscFees[0].quantity * selectedMiscFees[0].amountBeforeGST);
	document.getElementById("lTotalPayable").innerHTML = fees[0].totalResult.amountTotal + (selectedMiscFees[0].quantity * selectedMiscFees[0].amount);
    document.getElementById("lMiscFee").innerHTML = totalMiscFeesAmount;
    document.getElementById("lGST").innerHTML = fees[0].totalResult.taxAmount + (selectedMiscFees[0].quantity * selectedMiscFees[0].taxAmount);
    
}
function backToProgramme() {
    location.href = programmeUrl;
}

function renderMiscFeesTable(event) {
    var miscFeesEvent = document.getElementById("miscFeesSelect");
    var selectedMiscFeesSelect = miscFeesEvent.options[miscFeesEvent.selectedIndex].value;
    renderMiscFeeStructureTableData(selectedMiscFeesSelect);
}

function getSessionData(_sessionKey) {
	if (sessionStorage) {
		return sessionStorage.getItem(_sessionKey);
	} else { // if web storage not supported by browser, fallback to cookie (no choice)
		return getCookie(_sessionKey);
	}
}	

</script>