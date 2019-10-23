<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
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
<portlet:resourceURL var="elastisearchlisturl">
	<portlet:param name="action" value="elastiSearchList" />
</portlet:resourceURL>

<% 
String dashBoardLink = SambaashUtil.getDashBoard();
HttpServletRequest r = PortalUtil.getHttpServletRequest(renderRequest);
String programme_code =  PortalUtil.getOriginalServletRequest(r).getParameter("programme_code");
String schedule_code =  PortalUtil.getOriginalServletRequest(r).getParameter("schedule_code");
String enrolmentId  = PortalUtil.getOriginalServletRequest(r).getParameter("enrolmentId");
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
String listingPageUrl = renderRequest.getPreferences().getValue("baseUrlPref","");
%>
<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center">
						<h2>
							<span>Enrolment - Switch Subjects</span>
						</h2>
					</aui:col>
					<aui:col span="2" cssClass="text-right">
						<aui:a href="<%= dashBoardLink %>" title="Back to Home">Back to Home</aui:a>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>
	<div class="w-95 mx-auto enrolment-body">
		<div class="sambaashContent fee-container">
			<div class="title-container pt-5">
				<div class="">
					<img src="<%=request.getContextPath()%>/img/subject.png"
						srcset="<%=request.getContextPath()%>/img/subject@2x.png 2x, img/subject@3x.png 3x"
						class="title-icon" /> <span class="title">CHOOSE SUBJECT(S)</span>
				</div>
				<div class="horizontal-line"></div>
			</div>
			<form class="formContainer" id="mappingform">
				<div class="container entitylink subBox">
					<aui:row cssClass=" mt-5 d-flex justify-content-between">
						<aui:col span="4" cssClass="text-center">
							<label class="title mb-3">Selected Subjects</label>
							<div class="entitySearch shadow-md">
								<aui:row>
									<aui:col span="12">
										<ul id="selectedSubjects">
										</ul>
									</aui:col>
								</aui:row>
							</div>
						</aui:col>
						<aui:col span="2" cssClass="text-center">
							<ul class="addRemoveaction">
								<li><button type="button"
										class="btn btn-default remove-btn">REMOVE</button></li>
								<li><button type="button" class="btn btn-default add-btn">ADD</button></li>
							</ul>
						</aui:col>
						<aui:col span="4" cssClass="text-center">
							<label class="title mb-3">Available Subjects</label>
							<div class="entitySearch shadow-md">
								<aui:row>
									<aui:col span="12">
										<ul id="availableSubjects">
										</ul>
									</aui:col>
								</aui:row>
							</div>
						</aui:col>
					</aui:row>
					<div class="mx-auto mt-5 text-center">
						<aui:button type="button" cssClass="btn-default"
							onclick="getFeePricing()" value="VERIFY FEES" />
					</div>
				</div>
			</form>
			<div class="title-container">
				<div class="">
					<img src="<%=request.getContextPath()%>/img/fee.png"
						srcset="<%=request.getContextPath()%>/img/fee@2x.png 2x,img/fee@3x.png 3x"
						class="title-icon">
					<span class="title">FEE STRUCTURE</span>
				</div>
				<div class="horizontal-line"></div>
			</div>
			<div id="fee-container" class="mt-5">
				<div id="standardFeeToggler">
					<h4 class="standardFeeHeader fee-toggler-header toggler-header-expanded">
						<span>STANDARD FEE</span>
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
							<tbody id="standardFeeData">

							</tbody>
						</table>
					</div>
				</div>
				<div id="miscellaneousFeesToggler">
					<h4
						class="miscellaneousFeesHeader fee-toggler-header toggler-header-expanded">
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
				<div id="creditCheckboxRow">
					<div class="mx-auto w-33 credit-fees d-flex justify-content-around">
						<div class="form-group">
							<div class="form-check">
								<label class="control-label form-check-label"> <input
									onchange="changeRefundAmount()" type="checkbox"
									name="creditexamFees" value="exam" id="creditExamFees"
									checked="true" /> <span class="listSpanTitleDefault">Credit
										Exam Fees</span></label>
							</div>
						</div>
						<div class="form-group">
							<div class="form-check">
								<label class="control-label form-check-label"> <input
									onchange="changeRefundAmount()" type="checkbox"
									name="creditLocalFees" id="creditLocalFees" value="local" /> <span
									class="listSpanTitleDefault">Credit Local Fees</span></label>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="title-container">
				<span class=""> 
					<img src="<%=request.getContextPath()%>/img/fee.png"
						 srcset="<%=request.getContextPath()%>/img/fee@2x.png 2x,img/fee@3x.png 3x" class="title-icon">
					<span class="title">TOTAL FEE PAYABLE / RECEIVABLE</span>
				</span>
				<div class="horizontal-line"></div>
			</div>
			<div id="">
				<div class="miscellaneousFeesContent  toggler-content-expanded">
					<div id="miscFeesMultiSelect"></div>
					<div id="miscFeesSelectedItemsGrid">
						<table id="total-fees-table">
							<tr class="Heading">
								<th style="width:45%"></th>
								<th class="text-right"><b>Standard Fee<br/>(incl GST)</b></th>
								<th class="text-right"><b>Total Misc Fee<br/>(incl GST)</b></th>
								<th class="text-right small-col"><b>GST</b></th>
								<th class="text-right"><b>Total Fee<br/>(excl GST)</b></th>
								<th class="text-right" style="width:150px; padding-right: 10px"><b>Total Fee Payable<br/>(SGD)</b></th>
							</tr>
							<tr>
								<td><b>CURRENT SUBJECT(S)</b><span class="badge-success">Amount
										Paid</span></td>
								<td id="cpTotalStandardFee" class="text-right">0.00</td>
								<td id="cpTotalMiscFee" class="text-right small-col">0.00</td>
								<td id="cpTotalGST" class="text-right">0.00</td>
								<td id="cpTotalFeeExclGST" class="text-right">0.00</td>
								<td id="cpTotalFeeInclGST" class="text-right right-padding" style="width:150px; padding-right: 10px">0.00</td>
							</tr>
							<tr>
								<td><b>NEW SUBJECT(S)</b></td>
								<td class="text-right" id="lStandardFee">0.00</td>
								<td class="text-right" id="lMiscFee">0.00</td>
								<td class="text-right small-col" id="lGST">0.00</td>
								<td class="text-right" id="lTotalFee">0.00</td>
								<td class="text-right right-padding" id="lTotalPayable" style="width:150px; padding-right: 10px">0.00</td>
							</tr>
							<tr>
								<td class="text-right text-bolder text-right" colspan="5" id="totalRefundLabel">TOTAL
									REFUND</td>
								<td class="text-right text-bolder right-padding" id="totalRefund">0.00</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="enrolment-center-align py-5 ">
				<div class="button-holder userAction text-center"> 
				  <button class="btn btn-default verifyBtn hidden" type="button" onclick="markVerified('Pending')" disabled="true"> SAVE </button> 
				  <button class="btn btn-primary verifyBtn" type="button" onclick="markVerified('Verified','Subject switch successful !')" disabled="true"> MARK AS VERIFIED </button> 
				  <button class="btn btn-default" type="button" onclick="goBack()"> CANCEL </button> 
				  <button class="btn btn-primary submitApprovalBtn" type="button" onclick="updateApprovalStatus('Pending Switch Subject')" style="display:none"> Submit For Approval </button> 
				  <button class="btn btn-primary approvedBtn" type="button" onclick="updateApprovalStatus('Approved Switch Subject')"  style="display:none"> Approve </button> 
				  <button class="btn btn-primary rejectBtn" type="button" onclick="updateApprovalStatus('Reject Switch Subject')"  style="display:none"> Reject </button> 
		</div>
			</div>
			<div class="yui3-skin-sam">
				<div id="payment-record" hidden="true" class="modalpopupBox">
					<div id="payment-record-box" class="modalpopupContent">
						<form class="formContainer" action="">
							<aui:row>
								<aui:col span="12">
									<h3 class="success-msg">Enrolment Successful</h3>
								</aui:col>

							</aui:row>
							<aui:row>
								<aui:col span="12">
									<button type="button"
												class="btn btn-primary popup-confirm-deactivate pull-left proceedToPay" onclick="switchProceedToPay();">Proceed to Pay</button>
									<button type="button"
										class="btn btn-default popup-cancel-deactivate pull-right startAgain"
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

<aui:script use="liferay-upload">
function getFeesForEnrolment(enrolmentId, callback) {
    var inputData = {storageId: enrolmentId};
    console.log("inputData----");
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
						   			console.log(enrolment, data);
						   			console.log("----------------");
						   			if (!isPaid) {
						   				AUI().one('.badge-success').hide();
						   			}
						   			renderCurrentAmounts(data, enrolment.MiscFees);
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
var ajaxurl = "<%= ajaxUrl.toString()%>";
var namespace = "<portlet:namespace/>";
var elastisearchlisturl="<%=elastisearchlisturl%>";
var selectedSubjects = [];
var availableSubjects = [];
var newProgramme = "<%=  programme_code %>";
var schedule_code = "<%=  schedule_code %>";
var clientTypeMap = <%=objectMapper.writeValueAsString(clientTypeMap)%>;
var miscFees = [];
var selectedMiscFees = [];
var assetsPath = "<%=request.getContextPath()%>";
var pricingScheme = "";
var PricingType = "";
var _SCOPE_GROUP_ID = <%=SambaashUtil.getScopeGroupId(themeDisplay.getScopeGroupId())%>;

// To store total misc fees
var standardFee = 0;
var standardFeeBeforeGST = 0;
var standardTaxAmount = 0;
var totalMiscFeesAmount = 0;
var GST = 0;
var totalFee = 0;
var totalPayable = 0;

var totalStandartFee = 0;
var totalMiscFee = 0;
var totalGst = 0;
var totalFeeExclGst = 0;
var totalFeeInclGst = 0;

var enrolmentIds ;
var enrolmentId = "<%= enrolmentId %>";
var categoryMap = <%=objectMapper.writeValueAsString(categoryMap)%>;
var transactionTypeMap = <%=objectMapper.writeValueAsString(transactionTypeMap)%>;
var clientTypeMap = <%=objectMapper.writeValueAsString(clientTypeMap)%>;
var functionalComponentMap = <%=objectMapper.writeValueAsString(functionalComponentMap)%>;
var productMap = <%=objectMapper.writeValueAsString(productMap)%>;
var productSubtypeMap = <%=objectMapper.writeValueAsString(productSubtypeMap)%>;
var sourceTypeMap = <%=objectMapper.writeValueAsString(sourceTypeMap)%>;
var subProduct = <%=subProduct%>;
var isPaid = false;
var collectPaymentUrl = "<%=collectPaymentUrl%>";
var listingPageUrl = "<%=listingPageUrl%>";

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
	var e = getCookie("enrolmentIds");
	if(e != "")
		enrolmentIds = JSON.parse(e);
	else
		enrolmentIds = [];
	if(enrolmentId != "" && enrolmentId != "null"){
		enrolmentIds = [];
		enrolmentIds[0] = enrolmentId;
	}
	if(enrolmentIds.length > 0)
		getPricingSchemeSubject(newProgramme);
	
}); 

function getPricingSchemeSubject(programme) {
	  AUI().use('aui-io-request-deprecated', 'aui-base', function(A) {
			var _data = {};
			var qq = "/api/jsonws/SystemModelSetup-portlet.system/get-entity-link/group-id/" + globalMicroserviceGroupId + "/query-by-example-json-string/{   ModelLeft:'Schedule', ModelLeft1:'Programme',   ModelRight:'PriceScheme', StorageIdLeft:'"+ schedule_code +"', StorageIdLeft1:'"+ programme +"'}/-return-field-list/retrieve-model-details/ModelRight/flatten/true";
			// need to add p_auth since not using Liferay.Service() instead
			qq += "?p_auth="+p_auth_global;

			A.io.request(qq, {
				dataType : 'json',
				method : "GET",
				data : _data,
				on : {
					success : function() {
					      var data = this.get("responseData");
					      if (_.isEmpty(data)) {
					        console.log("error");
					      } else {
					    	 getEnrolledSubjects();
					    	  for(var i =0; i < data.length; i++ ){
					    		  
					    		  if( data[i].PricingType == "MiscFees"){
					    			  miscPricingScheme = data[i].PricingSchemeCode;
							    	  miscPricingType =  data[i].PricingType;
					    			  //getMiscFeesData(miscPricingScheme);
					    		  }else{
					    			  pricingScheme = data[i].PricingSchemeCode;
							    	  PricingType =  data[i].PricingType;
					    		  }
					    	  }
					    	  
					    	  
					      }
					    },
					failure : function() {

					}
				}
			});
		});
	}
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


function getSubjects(){
	var data = { limit: 100, modelName: "Subject", page: 0, formType: "Subject" };
	ajaxCall(
	  "GET",
	  "loadList",
	  ajaxurl,
	  data,
	  function() {
	    var data = this.get("responseData");
	    if (_.isEmpty(data)) {
	      console.log("error");
	    } else {
	      reloadListing1(data.content);
	    }
	  },
	  function() {}
	);
}
var enrolledSubjectList = [];
function getEnrolledSubjects(){
	var data = {"limit":1000,"modelName":"Enrolment","page":0,"formType":"Enrolment"};
	var filter = {};
	var filterdata = [];
	filter["contentJson.enrolmentId"] = [enrolmentIds[0]];	
	filterdata.push(filter);
	data["filterdata"]=filterdata;
	ajaxCall('GET','elastiSearchList',elastisearchlisturl,data,
	 function() {
	         var data = this.get("responseData");
	         if (_.isEmpty(data)) {
	             console.log("error");
	         } else {
	        	 console.log(data);
	         	var subjects = data.content[0].contentJson.subjects;
	         	var count = 0;
	         	subjects.forEach(function(item1) {
	         		  var item = item1;
	         	    var obj = {};
	         	    obj.SubjectCode = item.SubjectCode;
	         	    obj.SubjectTitle = item.SubjectTitle;
	         	    obj.SubjectType = item.SubjectType;
	         	    obj.seq = count++;
	         	    selectedSubjects.push(obj);
	         	   enrolledSubjectList.push(item.SubjectCode);
	         	  });
	         	//getSubjects();
	         	loadSubjects1(newProgramme);
	         	changeRefundAmount();
	         	//fillSelectedSubjects1();
	         }
	     },
	     function() {
	         
	});
}
function loadSubjects1(programme) {
    if (newProgramme != "") {
        AUI().use('aui-io-request-deprecated', 'aui-base', function(A) {
            var _data = {};
            var qq = "/api/jsonws/SystemModelSetup-portlet.system/get-entity-link/group-id/" + globalMicroserviceGroupId + "/query-by-example-json-string/{   ModelLeft:'Programme',   ModelRight:'Subject', StorageIdLeft:'" + programme + "'}/return-field-list/ModelRightDetails.SubjectCode,ModelRightDetails.SubjectTitle,ModelRightDetails.SubjectType/retrieve-model-details/ModelRight/flatten/true";
			// need to add p_auth since not using Liferay.Service() instead
			qq += "?p_auth="+p_auth_global;
            A.io.request(qq, {
                dataType: 'json',
                method: "GET",
                data: _data,
                on: {
                    success: function() {
                        var data = this.get("responseData");
                        if (_.isEmpty(data)) {
                            console.log("error");
                        } else {
                            reloadListing1(data);
                            getPricingScheme(programme);
                        }
                    },
                    failure: function() {

                    }
                }
            });
        });
    }

}
function reloadListing1(data) {
    var count = 0;
    data.forEach(function(item) {
    	if(!enrolledSubjectList.includes(item.SubjectCode)){
    		var obj = {};
            obj.SubjectCode = item.SubjectCode;
            obj.SubjectTitle = item.SubjectTitle;
            obj.SubjectType = item.SubjectType;
            obj.seq = count++;
            availableSubjects.push(obj);
    	}
        
    });
    fillAvailableSubjects();
    fillSelectedSubjects1();

}

function getFeePricing() {
	console.log("getFeePricing...");
	var subjects1 = [];
	for(var i =0; i < selectedSubjects.length; i++){
		var subject = {"subjectCode":selectedSubjects[i].SubjectCode,"subjectType":selectedSubjects[i].SubjectType.replace(/\s/g,'')}
		subjects1.push(subject);
	}
  var data = {
    programmeScheduleCode: newProgramme,
    programmeType: PricingType,
    fullUnitNumber: "",
    halfUnitNumber: "",
    lawUnitNumber: "",
    date: SambaashUtils.todayFormat(),
    dateFormat: 'dd/MM/yyyy',
    priceSchemeCode: [pricingScheme],
    action: "",
    promoCode: "",
    roundingScale: '2',
    roundingMode: 'HALF_UP',
    quantity: "",
    baseCurrency: "SGD",
    subjects:subjects1,
    purposeForExchangeRate: 'Pricing Engine'
  };

  var ajaxurl = "<%= ajaxUrl.toString()%>";

  // API to get standard fees
  ajaxCall(
    "GET",
    "pricing",
    ajaxurl,
    data,
    function() {
      var data = this.get("responseData");
      if (_.isEmpty(data)) {
    	console.log("Error getting Price Schemes");
        AUI().all('.userAction .verifyBtn').each( (btn) => btn.setAttribute("disabled","true") );
      } else {
        renderFeeStructureTableData(data);
        AUI().all('.userAction .verifyBtn').each( (btn) => btn.removeAttribute("disabled") );
      }
      changeRefundAmount();
    },
    function() {}
  );
}

// todo - Remove this and replace it with actual API
function getTotalStandardFeesAmount() {
  return 32165;
}

// todo -replace this with actual API
function getMiscFeesData(priceScheme)
    {    	
		var miscFeesInput = {
				scopeGroupId: <%=SambaashUtil.getScopeGroupId(themeDisplay.getScopeGroupId())%>,
			    programmeScheduleCode: newProgramme,
			    programmeType: 'MiscFees',
	   		    fullUnitNumber: '',
	   		    halfUnitNumber: '',
	   		    lawUnitNumber: '',
	   		    dateString: SambaashUtils.today(),
	   		    priceSchemeCode: priceScheme,
	   		    promoCode: '',
	   		    subjectCodes: '',
	   		    subjectTypes: '',
	   			roundingScale: '2',
		        roundingMode: 'HALF_UP',
		        dateFormat: 'MM/dd/yyyy',
		        baseCurrency: 'SGD',	// set base currency accordingly, not sure where to get
		        baseCurrencyCode: 'SGD',
		        priceCategory: '',
		        action: 'MiscFees',
		        purposeForExchangeRate: 'Pricing Engine'					    
			  };
		console.log(miscFeesInput);
		Liferay.Service("/SPPricingEngine-portlet.sppricingengine/get-pricing",
		  miscFeesInput,
		  function(data) {
			console.log(data);
 		    	miscFees = data[0].resutlByPriceType;
 		    	feelupMiscFees();
 		    	applyLateFee(enrolment.programSemester.ScheduleCode);
		  }
		);
    }
    
function feelupMiscFees() {
  document.getElementById("miscFeesSelect").options.length = 0;

  var option = document.createElement("option");
  option.text = "Select Fees";
  option.value = "Select Fees";

  var select = document.getElementById("miscFeesSelect");
  select.appendChild(option);

  miscFees.forEach(function(fee) {
    appendMiscFees(fee);
  });
  calculateTotalMiscFees();
}

function appendMiscFees(fee) {
  var option = document.createElement("option");
  option.text = fee.priceSubType;
  option.value = fee.priceSubType;

  var select = document.getElementById("miscFeesSelect");
  select.appendChild(option);
}


function removeSelectedMiscFees() {}



</script>