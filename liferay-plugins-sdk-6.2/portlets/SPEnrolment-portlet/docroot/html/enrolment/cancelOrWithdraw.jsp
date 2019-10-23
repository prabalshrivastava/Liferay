<%@page import="com.sambaash.platform.enrolement.EnrolmentConstants"%>
<%@page import="com.fasterxml.jackson.databind.SerializationFeature"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.Map"%>
<%@page import="com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil"%>
<%@ page import="com.sambaash.platform.util.SambaashUtil"%>
<%@ page import="com.sambaash.platform.util.PermissionUtil"%>
<%@ page import="javax.portlet.PortletRequest"%>

<%@ page import="com.liferay.portal.util.PortalUtil"%>

<%@ include file="/html/init.jsp" %>

<link rel="stylesheet" href="/html/css/hook.css?minifierType=css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css?<%=System.currentTimeMillis()%>" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/switchsubjects.css?<%=System.currentTimeMillis()%>" />
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2"></script>
<portlet:resourceURL var="ajaxUrl">
</portlet:resourceURL>

<%
String dashBoardLink = SambaashUtil.getDashBoard();
HttpServletRequest r = PortalUtil.getHttpServletRequest(renderRequest);
String programme_code = PortalUtil.getOriginalServletRequest(r).getParameter("programme_code");
String schedule_code = PortalUtil.getOriginalServletRequest(r).getParameter("schedule_code");
String enrolmentId = PortalUtil.getOriginalServletRequest(r).getParameter("enrolmentId");
String enrolmentIdsKey = PortalUtil.getOriginalServletRequest(r).getParameter("enrolmentIdsKey");
Map<String, String> categoryMap = SPFinanceLocalServiceUtil.getSpListTypeMap("finance.referencenumber.categorytype", request);
Map<String, String> transactionTypeMap = SPFinanceLocalServiceUtil.getSpListTypeMap("finance.accountingtable.transactiontype", request);
Map<String, String> clientTypeMap = SPFinanceLocalServiceUtil.getSpListTypeMap("finance.accountingtable.clienttype", request);
Map<String, String> functionalComponentMap = SPFinanceLocalServiceUtil.getFunctionalComponentDisplayMap(request);
Map<String, String> productMap = SPFinanceLocalServiceUtil.getSpListTypeMap("finance.accountingtable.productype", request);
Map<String, String> productSubtypeMap = SPFinanceLocalServiceUtil.getProductSubTypeMap(request);
Map<String, String> sourceTypeMap = SPFinanceLocalServiceUtil.getSpListTypeMap("finance.transaction.sourcetype", request);
ObjectMapper objectMapper = new ObjectMapper();
objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
String subProduct = themeDisplay.getLayout().getTypeSettingsProperty("subProduct");
String collectPaymentUrl = renderRequest.getPreferences().getValue("collectPaymentBaseUrlPref","");
String listingPageUrl = renderRequest.getPreferences().getValue("baseUrlPref","");

String vm = PortalUtil.getOriginalServletRequest(r).getParameter(EnrolmentConstants.VIEW_MODE_PARAM);
%>
<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center">
						<h2>
							<span>Enrolment</span>
						</h2>
					</aui:col>
					<aui:col span="2" cssClass="text-right">
						<aui:a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</aui:a>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>
	<div class="formRoot">
		<div class="innerFormRoot">
			<div class="enrolment-body mx-auto">
				<div class="w-95 mx-auto">
					<div class="title-container">
						<div class="">
							<img src="<%=request.getContextPath()%>/img/fee.png"
								srcset="<%=request.getContextPath()%>/img/fee@2x.png 2x,img/fee@3x.png"
								class="title-icon" /> <span class="title">FEE STRUCTURE</span>
						</div>
						<div class="horizontal-line"></div>
					</div>
					<div id="fee-container" class="mt-5">
						<div id="standardFeeToggler">
							<h4
								class="standardFeeHeader fee-toggler-header toggler-header-expanded">
								<span class="text-bolder">STANDARD FEE</span>
							</h4>
							<div class="standardFeeContent toggler-content-expanded ">
								<table id="fees" class="aui">
									<thead>
										<tr class="Heading">
											<th>Subject Name & Code</th>
											<th>Pricing SubType</th>
											<th>Subject Type</th>
											<th>CCY</th>
											<th>Amount (Incl GST)</th>
											<th>Amount in SGD (Incl GST)</th>
										</tr>
									</thead>
									<tbody id="standardFeeData"></tbody>
								</table>
							</div>
						</div>
						<div id="miscellaneousFeesToggler">
							<h4
								class="miscellaneousFeesHeader fee-toggler-header toggler-header-expanded">
								<span class="text-bolder">MISCELLANEOUS FEE</span>
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
										<tbody id="miscFeeTableData"></tbody>
									</table>
								</div>
							</div>
						</div>
						<div id="creditCheckboxRow">
							<div class="mx-auto w-33 credit-fees d-flex justify-content-around">
								<div class="form-group">
									<div class="form-check">
										<label class="control-label form-check-label"> <input onchange="changeRefundAmount()"
											type="checkbox" name="creditexamFees" value="exam" id="creditExamFees" checked="true" /> <span
											class="listSpanTitleDefault">Credit Exam Fees</span></label>
									</div>
								</div>
								<div class="form-group">
									<div class="form-check">
										<label class="control-label form-check-label"> <input onchange="changeRefundAmount()"
											type="checkbox" name="creditLocalFees" id="creditLocalFees"  value="local" /> <span
											class="listSpanTitleDefault">Credit Local Fees</span></label>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="title-container">
						<span class=""> <img
							src="<%=request.getContextPath()%>/img/fee.png"
							srcset="<%=request.getContextPath()%>/img/fee@2x.png 2x,img/fee@3x.png 3x"
							class="title-icon" /> <span class="title">TOTAL FEE
								PAYABLE / RECEIVABLE</span>
						</span>
						<div class="horizontal-line"></div>
					</div>
					<div id="">
						<div class="miscellaneousFeesContent  toggler-content-expanded">
							<div id="miscFeesMultiSelect"></div>
							<div id="miscFeesSelectedItemsGrid">
								<table class="total-fees-table">
									<tr class="Heading">
										<th style="width: 45%"></th>
										<th class="text-right"><b>Standard Fee<br />(incl
												GST)
										</b></th>
										<th class="text-right"><b>Total Misc Fee<br />(incl
												GST)
										</b></th>
										<th class="text-right small-col"><b>GST</b></th>
										<th class="text-right"><b>Total Fee<br />(excl GST)
										</b></th>
										<th class="text-right"
											style="width: 150px; padding-right: 10px"><b>Total
												Fee Payable<br />(SGD)
										</b></th>
									</tr>
									<tr>
										<td><b>CURRENT PROGRAMME</b><span class="badge-success">Amount
												Paid</span></td>
										<td id="cpTotalStandardFee" class="text-right">0.00</td>
										<td id="cpTotalMiscFee" class="text-right small-col">0.00</td>
										<td id="cpTotalGST" class="text-right">0.00</td>
										<td id="cpTotalFeeExclGST" class="text-right">0.00</td>
										<td id="cpTotalFeeInclGST" class="text-right right-padding"
											style="width: 150px; padding-right: 10px">0.00</td>
									</tr>
									<tr>
										<td><b>NEW CHANGES</b></td>
										<td class="text-right" id="lStandardFee">0.00</td>
										<td class="text-right" id="lMiscFee">0.00</td>
										<td class="text-right small-col" id="lGST">0.00</td>
										<td class="text-right" id="lTotalFee">0.00</td>
										<td class="text-right right-padding" id="lTotalPayable"
											style="width: 150px; padding-right: 10px">0.00</td>
									</tr>
									<tr>
										<td class="text-right text-bolder text-right" colspan="5"
											id="totalRefundLabel">TOTAL REFUND</td>
										<td class="text-right text-bolder right-padding"
											id="totalRefund">0.00</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
			  		<div class="enrolment-center-align py-5">
				      <label id="reasonLabel" class='title'>Reason for Cancellation</label>
				      <textarea id="reason" placeholder="Enter the reason..." class="reason-textarea"></textarea>
			      	</div>
					<div class="enrolment-center-align py-5">
						<div class="button-holder userAction text-center"> 
	                        <aui:button type="button" cssClass="draftBtn" onclick="saveDraft()" value="SAVE DRAFT" style="display:none;"/>
	                        <aui:button cssClass="btn-primary approvalBtn" onclick="submitForApproval()" value="SUBMIT FOR APPROVAL" />
	                        <aui:button type="button" onclick="goBack()" value="CANCEL" />						  
						</div>
					</div>
					<div class="yui3-skin-sam">
						<div id="sucess-popup" hidden="true" class="modalpopupBox">
							<div id="sucess-popup-box" class="modalpopupContent progSwitch">
								<form class="formContainer" action="">
									<aui:row>
										<aui:col span="12">
											<h3>Successful!</h3>
										</aui:col>
									</aui:row>
									<aui:row>
										<aui:col span="12">
											<button type="button" style="width: auto;"
												class="btn btn-primary"
												onclick="backToListing();">Back To Listing</button>
										</aui:col>
									</aui:row>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<aui:script use="liferay-upload">
function getFeesForEnrolment(enrolmentId, callback) {
    var inputData = {storageId: enrolmentId};
    console.log(inputData);
    Liferay.Service("/SystemModelSetup-portlet.system/get-model-list",
		  {
		    modelName: 'enrolment',
		    fieldList: '',
		    groupId: _SCOPE_GROUP_ID,
		    matchJsonString: JSON.stringify(inputData),
		    sortString: ''
		  },
		  function(enrolmentList) {
			if (enrolmentList.length > 0 && enrolmentList[0]) {
				enrolment = enrolmentList[0];
			 	var subjectCodes = [];
			 	var subjectTypes = [];
			 	var fullUnits = 0;
			 	var halfUnits = 0;
			 	var lawUnits = 0;
			 	var subjectMap = {};
			 	var subjects = enrolment.subjects;
			 	if (enrolment.InvoiceCode) {
			 		Liferay.Service(
		 				  '/SPMicroservice-portlet.spmicroservice/is-paid-invoice',
		 				  {
		 				    scopeGroupId: _SCOPE_GROUP_ID,
		 				    invoiceNumbers: enrolment.InvoiceCode
		 				  },
		 				  function(_result) {
		 					 isPaid = _result;
		 				  }
	 				);
			 	} else if (enrolment.EnrolmentStatus) {
			 		isPaid = (enrolment.EnrolmentStatus.toLocaleLowerCase() === "confirmed");
			 	}
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
			 	var linkingInputData = { ModelLeft:"Schedule", ModelLeft1:"Programme", ModelRight:"PriceScheme", 
						StorageIdLeft: enrolment.programSemester.ScheduleCode,
						StorageIdLeft1: enrolment.programSemester.ProgrammeCode
			 		  };
			 	Liferay.Service("/SystemModelSetup-portlet.system/get-entity-link",
	 			  {
	 			    groupId: _SCOPE_GROUP_ID,
	 			    queryByExampleJsonString: JSON.stringify(linkingInputData),
	 			    returnFieldList: '',
	 			    retrieveModelDetails: 'ModelRight',
	 			    flatten: true
	 			  },
	 			  function(pricingSchemeList) {
				  	if (pricingSchemeList.length > 0 && pricingSchemeList[0]) {
				  		pricingSchemeList.forEach(function(priceScheme) {
				  			console.log(priceScheme);
				  			if (priceScheme.PricingType === 'MiscFees') {
				  				//miscFees = getMiscFeesData(priceScheme);
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
						   			console.log("----------------");
						   			console.log(data);
						   			console.log("----------------");
						   			if (!isPaid) {
						   				AUI().one('.badge-success').hide();
						   			}
						   			renderCurrentAmounts(data, enrolment.MiscFees);
						   			renderCurrentSubjectFees(data);
						   			getPricingScheme(programme_code);
								  }
								);				  				
				  			}
				  		});
			  		} else{
			  			alert("No Pricing Scheme linked");
			  		}	    
	 			}); 
			 } // if 	
		});
}

getFeesForEnrolment(enrolmentId, function(feesData){});
</aui:script>
<script type="text/javascript">
const VIEW_MODE = "<%=EnrolmentConstants.VIEW_MODE%>";
const EDIT_MODE = "<%=EnrolmentConstants.EDIT_MODE%>";
const CANCEL_MODE = "<%=EnrolmentConstants.CANCEL_MODE%>";
const WITHDRAW_MODE = "<%=EnrolmentConstants.WITHDRAW_MODE%>";
var ajaxurl = "<%=ajaxUrl.toString()%>";
var namespace = "<portlet:namespace/>";
var selectedSubjects = [];
var availableSubjects = [];
var selectedProgramme = [];
var availableProgrammes = [];
var feeStructureData = [];
var newProgramme = "<%=programme_code%>";
var programme_code = "<%=programme_code%>";
var schedule_code = "<%=schedule_code%>";
var priceScheme;

var _SCOPE_GROUP_ID = <%=SambaashUtil.getScopeGroupId(themeDisplay.getScopeGroupId())%>;
var namespace = "<portlet:namespace/>";
var miscFees = [];
var selectedMiscFees = [];
var assetsPath = "<%=request.getContextPath()%>";
var enrolmentId = "<%=enrolmentId%>";
var enrolmentIdsKey = "<%=enrolmentIdsKey != null ? enrolmentIdsKey : ""%>";
var categoryMap = <%=objectMapper.writeValueAsString(categoryMap)%>;
var transactionTypeMap = <%=objectMapper.writeValueAsString(transactionTypeMap)%>;
var clientTypeMap = <%=objectMapper.writeValueAsString(clientTypeMap)%>;
var functionalComponentMap = <%=objectMapper.writeValueAsString(functionalComponentMap)%>;
var productMap = <%=objectMapper.writeValueAsString(productMap)%>;
var productSubtypeMap = <%=objectMapper.writeValueAsString(productSubtypeMap)%>;
var sourceTypeMap = <%=objectMapper.writeValueAsString(sourceTypeMap)%>;
var subProduct = <%=subProduct%>;
var enrolmentIds ;

var standardFee = 0;
var standardTaxAmount = 0;
var standardFeeBeforeGST = 0;
var totalMiscFeesAmount = 0;
var GST = 0;
var totalFee = 0;
var totalPayable = 0;

var totalStandartFee = 0;
var totalMiscFee = 0;
var totalGst = 0;
var totalFeeExclGst = 0;
var totalFeeInclGst = 0;
var isPaid = false;
var collectPaymentUrl = "<%=collectPaymentUrl%>";
var listingPageUrl = "<%=listingPageUrl%>";

var vm = "<%=vm%>";
var isViewMode = [VIEW_MODE,CANCEL_MODE,WITHDRAW_MODE].indexOf(vm) != -1;
var isCancelMode = [CANCEL_MODE].indexOf(vm) != -1;
var isWithdrawMode = [WITHDRAW_MODE].indexOf(vm) != -1;

if(enrolmentId != "" && enrolmentId && enrolmentId!="null"){
	enrolmentIds = [];
	enrolmentIds[0] = enrolmentId;
} else {
	enrolmentIds = JSON.parse(getSessionData(enrolmentIdsKey));
}

function changeRefundAmount() {
	document.getElementById("creditCheckboxRow").style.display = "none";
	var newAmount = standardFee + totalMiscFeesAmount;
	if (!isPaid) {
		// not yet paid, so what ever selected will be the total payable
		differenceFinal = newAmount;
		document.getElementById("totalRefundLabel").innerHTML = "TOTAL PAYABLE";
		document.getElementById("totalRefund").innerHTML = formatMoney(newAmount);
		// reset amount used in verification, otherwise this will get difference of old and new subject fees
		totalFeeInclGst = 0;
	}else if(newAmount>totalFeeInclGst) {
		differenceFinal = newAmount - totalFeeInclGst;
		document.getElementById("totalRefundLabel").innerHTML = "TOTAL PAYABLE";
		document.getElementById("totalRefund").innerHTML = formatMoney(newAmount - totalFeeInclGst);
	} else {
		document.getElementById("creditCheckboxRow").style.display = "block";
		document.getElementById("totalRefundLabel").innerHTML = "TOTAL REFUND";
		var nonCreditAmount = 0;
		if(document.getElementById("creditExamFees") && !document.getElementById("creditExamFees").checked) {
			nonCreditAmount = nonCreditAmount + examFeesAmount;
		}
		if(document.getElementById("creditLocalFees") && !document.getElementById("creditLocalFees").checked) {
			nonCreditAmount = nonCreditAmount + localFeesAmount;
		}
		differenceFinal = -(totalFeeInclGst - newAmount - nonCreditAmount);
		if(differenceFinal>0) {
			differenceFinal = 0;
		}
		document.getElementById("totalRefund").innerHTML = formatMoney(Math.abs(differenceFinal));
	}
}

AUI().ready(function(A) {
	switch (vm) {
		case CANCEL_MODE:
			AUI().one('.subHeader span')._node.innerText = "CANCEL ENROLMENT";
			AUI().one('#reasonLabel')._node.innerText = "Reason for Cancellation";
			break;
		case WITHDRAW_MODE:
			AUI().one('.subHeader span')._node.innerText = "WITHDRAW ENROLMENT";
			AUI().one('#reasonLabel')._node.innerText = "Reason for Withdrawal";
			break;
	}
}); 

var obj = {};
obj.key = "dd";
obj.value = "s";
availableSubjects.push(obj);
var pricingScheme = "";
var PricingType = "";

// used to toggle components
YUI().use("aui-toggler", function(Y) {
  new Y.TogglerDelegate({
    animated: true,
    closeAllOnExpand: false,
    container: "#standardFeeToggler",
    content: ".standardFeeContent",
    expanded: true,
    header: ".standardFeeHeader",
    transition: {
      duration: 0.2,
      easing: "cubic-bezier(0, 0.1, 0, 1)"
    }
  });
});

// used to toggle components
YUI().use("aui-toggler", function(Y) {
  new Y.TogglerDelegate({
    animated: true,
    collapse: false,
    closeAllOnExpand: false,
    container: "#miscellaneousFeesToggler",
    content: ".miscellaneousFeesContent",
    expanded: true,
    header: ".miscellaneousFeesHeader",
    transition: {
      duration: 0.2,
      easing: "cubic-bezier(0, 0.1, 0, 1)"
    }
  });
});

	function submitForApproval() {
		if (!AUI().one('#reason').val()) {
			AUI().one('#reasonLabel').addClass("alert alert-error");
			return;
		} else {
			AUI().one('#reasonLabel').removeClass("alert alert-error");
		}
		switch (vm) {
			case CANCEL_MODE:
				alert("Cancel Enrolment Approval not yet implemented.");
				break;
			case WITHDRAW_MODE:
				alert("Withdraw Enrolment Approval not yet implemented.");
				break;
		}
	}

	function saveDraft() {
		switch (vm) {
			case CANCEL_MODE:
				alert("Cancel Enrolment Draft not yet implemented.");
				break;
			case WITHDRAW_MODE:
				alert("Withdraw Enrolment Draft not yet implemented.");
				break;
		}
	}	
	
	function renderCurrentSubjectFees(data) {
	    var tbody = document.getElementById("standardFeeData");
	    tbody.innerHTML = "";
	    data[0].resutlBySubject.forEach(function(fee) {
	    	if(fee.amountByCurrency > 0){
	    		var tr = document.createElement("tr");
	            tr.innerHTML =
	                "<td >" +
	                fee.subjectCode + " - " + fee.subjectTitle +
	                "</td>" +
	                "<td>" +
	                fee.priceSubType.replace(/([a-z0-9])([A-Z])/g, '$1 $2') +
	                "</td>" +
	                "<td>" +
	                fee.subjectType.replace(/([a-z0-9])([A-Z])/g, '$1 $2') +
	                "</td>" +
	                "<td>" +
	                fee.currency +
	                "</td>" +
	                "<td>" +
	                formatMoney(fee.amountByCurrency) +
	                "</td>" +
	                "<td>" +
	                formatMoney(fee.amountByBaseCurrency) +
	                "</td>";
	            tbody.appendChild(tr);
	    	}
	    });
	}
	
	function getSessionData(_sessionKey) {
		if (sessionStorage) {
			return sessionStorage.getItem(_sessionKey);
		} else { // if web storage not supported by browser, fallback to cookie (no choice)
			return getCookie(_sessionKey);
		}
	}	
	
</script>

