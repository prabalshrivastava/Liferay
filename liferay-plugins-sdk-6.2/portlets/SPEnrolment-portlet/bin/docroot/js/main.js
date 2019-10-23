var examFeesAmount = 0;
var localFeesAmount = 0;
var differenceFinal = 0;

function reloadProgrammeListing(data) {
    data.forEach(function(item) {
        var programmeObject = {};
        programmeObject.key = item.ProgrammeCode;
        programmeObject.value = item.ProgrammeTitle;
        selectedProgramme.push(programmeObject);
        availableProgrammes.push(programmeObject);
    });

    fillSelectedProgrammes();
    fillAvailableProgrammes();
}

function fillSelectedProgrammes() {
    var select = document.getElementById("selectedProgrammes");
    selectedProgramme.forEach(function(programme) {
        var option = document.createElement("option");
        option.setAttribute("id", "custom_id" + programme.key + "_programme");
        option.setAttribute("value", programme.key);
        var proc = "[" + programme.key + "]  " + programme.value;
        option.innerHTML = "<label class='m-0 p-0 w-90'>" + proc + "</label>";
        if (programme_code == programme.key) {
            option.selected = "selected";
        }
        select.appendChild(option);
    });
}

function fillAvailableProgrammes() {
    var select = document.getElementById("availableProgrammes");
    selectedProgramme.forEach(function(programme) {
    	if (programme_code != programme.key) {
	        var option = document.createElement("option");
	        option.setAttribute("id", "custom_id" + programme.key + "_programme");
	        option.setAttribute("value", programme.key);
	        var proc = "[" + programme.key + "]  " + programme.value;
	        option.innerHTML = "<label class='m-0 p-0 w-90'>" + proc + "</label>";
	        select.appendChild(option);
    	}
    });
}

function reloadListing(data) {
    var count = 0;
    data.forEach(function(item) {
        var obj = {};
        obj.SubjectCode = item.SubjectCode;
        obj.SubjectTitle = item.SubjectTitle;
        obj.SubjectType = item.SubjectType;
        obj.seq = count++;
        availableSubjects.push(obj);
    });
    fillAvailableSubjects();
    fillSelectedSubjects1();

}

function clearSubjectsFilers() {
    document.getElementById("selectedSubjects").innerHTML = "";
    document.getElementById("availableSubjects").innerHTML = "";
}

function fillAvailableSubjects() {
    var ul = document.getElementById("availableSubjects");
    var count = 0;
    availableSubjects.forEach(subject => createSubjectItem(ul, subject, count++));

}

function fillSelectedSubjects() {

    selectedSubjects = selectedSubjects.filter(el =>
        availableSubjects.find(elx => elx.SubjectCode === el.SubjectCode) ? false : true
    );
    var ul = document.getElementById("selectedSubjects");
    var count = 0;
    selectedSubjects.forEach(subject => createSubjectItem(ul, subject, count++));

}
function fillSelectedSubjects1() {
    var ul = document.getElementById("selectedSubjects");
    var count = 0;
    selectedSubjects.forEach(subject => createSubjectItem(ul, subject, count++));
}
function createSubjectItem(parent, item, count) {
    var li = document.createElement("li");
    li.setAttribute("class", "li-bg d-flex");
    li.setAttribute("id", "custom_id" + item.SubjectCode + "_subject");

    var itag = document.createElement("i");
    itag.setAttribute("class", "pull-right icon-arrow-right");
    itag.setAttribute("id", "custom_id" + item.SubjectCode);
    itag.setAttribute("seq", count);
    itag.addEventListener("click", function() {
        switchItem(this, parent, item);
    });
    var proc = "[" + item.SubjectCode + "]  " + item.SubjectTitle;
    li.innerHTML = "<label class='m-0 p-0 w-90'>" + proc + "</label>";
    li.appendChild(itag);
    parent.appendChild(li);
}



function switchItem(position, parent, subject) {

    if (parent.id === "availableSubjects") {
        selectedSubjects.push(subject);
        availableSubjects.splice(position.getAttribute("seq"), 1);
    } else {
        availableSubjects.push(subject);
        selectedSubjects.splice(position.getAttribute("seq"), 1);
    }

    clearSubjectsFilers();
    fillAvailableSubjects();
    fillSelectedSubjects();
}

function updateApprovalStatus(status){
	markVerifiedSwitching("Confirmed", "Switching is initiated", status);
}

function markVerifiedSwitching(status, customMsg, approvalStatus){
	 //selectedSubjects

    var data = {
        "enrolmentIds": enrolmentIds,
        "formType": "enrolment",
        "endPoint": "switch",
        "EnrolmentStatus": status,
        "ApprovalStatus": approvalStatus,
        "subjects": selectedSubjects,
        "programmeCode": newProgramme,
        "programmeId": newProgramme,
        "programmeName": newProgramme,
        "semesterCode": schedule_code,
        "routeCode": "2222",
        "MiscFees": miscFeesArray,
        "fee": subjectFees,
        "difference": differenceFinal,
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
        "switch",
        ajaxurl,
        data,
        function() {
            var data = this.get("responseData");
            if (_.isEmpty(data)) {
                alert("Failed to mark enrolment as " + status);
            } else {
            	showSuccessPopup(customMsg, enrolmentIds.length > 1);
            }
        },
        function() {

        });
}

function markVerified(status, customMsg) {
	markVerifiedSwitching(status, customMsg, null);
}
function showSuccessPopup(customMsg,noDirectPayment){
	var popupdiv = "#payment-record";
	var popupdivbox = "#payment-record-box";
	AUI().use('aui-base', function(A) {

		A.one(popupdiv).set('hidden', false);
		if (customMsg) {
			AUI().one("#payment-record .success-msg")._node.innerText=customMsg;
		} else {
			AUI().one("#payment-record .success-msg")._node.innerText='Enrolment Successful';
		}
		YUI().use('aui-modal', function(Y) {
			var modal = new Y.Modal({
				boundingBox: popupdiv,
				contentBox: popupdivbox,
				headerContent: '',
				centered: true,
				destroyOnHide: false,
				modal: true,
				resizable: false,
				draggable: false,
			}).render();
		});
		var newAmount = standardFee + totalMiscFeesAmount;
		if (noDirectPayment || (isPaid && newAmount<totalFeeInclGst)) { // refund
			AUI().one("#payment-record .proceedToPay").hide();
			AUI().one("#payment-record .startAgain").removeClass("pull-right");
			AUI().one("#payment-record .startAgain").ancestor()._node.style.textAlign = "center";
		} else {
			AUI().one("#payment-record .proceedToPay").show();
			AUI().one("#payment-record .startAgain").addClass("pull-right");
			AUI().one("#payment-record .startAgain").ancestor()._node.style.textAlign = "";
		}
		if (enrolment.SponsorshipType && enrolment.SponsorshipType === "Corporate") {
			A.one(".proceedToPay").setAttribute("title","This function is not applicable for Corporate sponsored.");
			A.one(".proceedToPay").setAttribute("disabled","true");
		}
		A.one('.close').on('click', function() {
			backToListing();
		});
	});

}
var miscFeesArray = [];

function calculateTotalMiscFees() {
    totalMiscFeesAmount = 0;
    totalMiscFeesGST = 0;
    var dataAmount = document.querySelectorAll('[data-amount]');
    miscFeesArray = [];
    dataAmount.forEach(function(amount) {
    	var amt = Number(amount.innerHTML.replace(/[^0-9.-]+/g,""));
    	totalMiscFeesAmount = parseFloat(totalMiscFeesAmount) + parseFloat(amt);
        var quantity = amount.parentElement.parentElement.querySelector("input").value;
        totalMiscFeesGST = parseFloat(totalMiscFeesGST) + parseFloat(quantity * amount.getAttribute("data-tax"));
        var miscfeeObj = {};
        miscfeeObj.priceSubType = amount.getAttribute("data-sub-type");
        miscfeeObj.amount = amount.getAttribute("data-amount");
        
        miscfeeObj.subjectTitle = amount.getAttribute("data-subjectTitle");
        miscfeeObj.currency = amount.getAttribute("data-currency");
        miscfeeObj.baseCurrency = amount.getAttribute("data-baseCurrency");
        miscfeeObj.roundingAdjustment = amount.getAttribute("data-roundingAdjustment");
        miscfeeObj.taxAmount = amount.getAttribute("data-tax");
        miscfeeObj.taxCode = amount.getAttribute("data-taxCode");
        miscfeeObj.taxInclude = amount.getAttribute("data-taxInclude");
        miscfeeObj.taxAmountByBaseCurrency = amount.getAttribute("data-taxAmountByBaseCurrency");
        miscfeeObj.amountByBaseCurrency = amount.getAttribute("data-amountByBaseCurrency");
        miscfeeObj.amountBeforeGST = amount.getAttribute("data-amountBeforeGST");
        miscfeeObj.subSchemeDetailModelId = amount.getAttribute("data-scheme-id");
        miscfeeObj.subSchemeName = amount.getAttribute("data-subSchemeName");
        
        miscfeeObj.quantity = quantity;
        miscFeesArray.push(miscfeeObj);
    });

    var totalMiscFeesAmountBeforeGST = totalMiscFeesAmount - totalMiscFeesGST;
    document.getElementById("lTotalFee").innerHTML = formatMoney(standardFeeBeforeGST + totalMiscFeesAmountBeforeGST);
    document.getElementById("lTotalPayable").innerHTML = formatMoney(standardFee + totalMiscFeesAmount);
    document.getElementById("lMiscFee").innerHTML = formatMoney(totalMiscFeesAmount);
    document.getElementById("lGST").innerHTML = formatMoney((standardFee + totalMiscFeesAmount)
    		- (standardFeeBeforeGST + totalMiscFeesAmountBeforeGST));
    if (typeof changeRefundAmount !== 'undefined' && typeof changeRefundAmount === 'function') {
    	changeRefundAmount();
    }
}

function onChangeFeeQuantity(subSchemeDetailModelId) {
    var quantity = document.getElementById("quantity_" + subSchemeDetailModelId).value;
    var amount = document.getElementById("amount_" + subSchemeDetailModelId);
    console.log(parseFloat(quantity));
    console.log(parseFloat(amount.dataset.amount));
    console.log(parseFloat(quantity) * parseFloat(amount.dataset.amount));
    
    amount.innerHTML = formatMoney(parseFloat(quantity) * parseFloat(amount.dataset.amount));

    for (var i = 0; i < selectedMiscFees.length; i++) {
        if (selectedMiscFees[i].subSchemeDetailModelId == subSchemeDetailModelId) {
            selectedMiscFees[i].quantity = quantity;
        }
    }
    calculateTotalMiscFees();
}

function onRemovemiscFeeElement(subSchemeDetailModelId) {
    var fee = selectedMiscFees.filter(function(fee) {
        return subSchemeDetailModelId == fee.subSchemeDetailModelId;
    });

    selectedMiscFees = selectedMiscFees.filter(function(fee) {
        return subSchemeDetailModelId != fee.subSchemeDetailModelId;
    });

    var row = document.getElementById("miscFee_" + subSchemeDetailModelId);

    row.parentNode.removeChild(row);

    miscFees.push(fee[0]);

    appendMiscFees(fee[0]);
    calculateTotalMiscFees();
}

function renderMiscFeesTable(event) {
    var miscFeesEvent = document.getElementById("miscFeesSelect");
    var selectedMiscFeesSelect = miscFeesEvent.options[miscFeesEvent.selectedIndex].value;

    renderMiscFeeStructureTableData(selectedMiscFeesSelect);
}

function renderMiscFeeStructureTableData(selectedFee, qty) {
    fee = miscFees.filter(function(fee) {
        return selectedFee == fee.subSchemeDetailModelId;
    });
    selectedMiscFees.push(fee[0]);
    selectedMiscFees = selectedMiscFees.filter(function(x, i, a) {
        return a.indexOf(x) == i;
    });

    var tbody = document.getElementById("miscFeeTableData");
    var currentFee = fee[0];
    var tr = document.createElement("tr");
    tr.setAttribute("id", "miscFee_" + currentFee.subSchemeDetailModelId);
    var totalFee = formatMoney(formatNumber(currentFee.amountByBaseCurrency));
    var totalTax = formatMoney(currentFee.taxAmountByBaseCurrency);
    
    var subjectTitle = currentFee.subjectTitle;
    var currency = currentFee.currency;
    var baseCurrency = currentFee.baseCurrency;
    var roundingAdjustment = formatMoney(currentFee.roundingAdjustment);
    var taxCode = currentFee.taxCode;
    var amountBeforeGST = formatMoney(currentFee.amountBeforeGST);
    var amountByBaseCurrency = formatMoney(currentFee.amountByBaseCurrency);
    var taxInclude = currentFee.taxInclude;
    var taxAmountByBaseCurrency = formatMoney(currentFee.taxAmountByBaseCurrency);
    var quantity = 1;
    if(qty) {
    	quantity = qty;
    }
    tr.innerHTML =
        "<td>" +
        currentFee.subSchemeName +
        "</td>" +
        "<td>" +
        totalFee +
        "</td>" +
        '<td><input type="text" value="'+quantity+'" name="quantity" id="quantity_' +
        currentFee.subSchemeDetailModelId +
        '" onkeyup="onChangeFeeQuantity(\'' +
        currentFee.subSchemeDetailModelId +
        "')\"></td>" +
        '<td><span data-amount="' +
        totalFee +
        '"data-tax="' +
        totalTax +
        '"data-subjectTitle="' +
        subjectTitle +
        
        '"data-currency="' +
        currency +
        '"data-baseCurrency="' +
        baseCurrency +
        '"data-roundingAdjustment="' +
        roundingAdjustment +
        '"data-taxCode="' +
        taxCode +
        '"data-amountBeforeGST="' +
        amountBeforeGST +
        '"data-amountByBaseCurrency="' +
        amountByBaseCurrency +
        '"data-taxInclude="' +
        taxInclude +
        '"data-taxAmountByBaseCurrency="' +
        taxAmountByBaseCurrency +
        '"data-scheme-id="'+
        currentFee.subSchemeDetailModelId +
        '"data-subSchemeName="'+
        currentFee.subSchemeName +
        '"data-sub-type="' +
        currentFee.priceSubType +
        '" id="amount_' +
        currentFee.subSchemeDetailModelId +
        '">' +
        totalFee +
        "</span></td>" +
        '<td><img src="' +
        assetsPath +
        '/img/close.png" alt="remove" height="20" width="20" onclick="onRemovemiscFeeElement(\'' +
        currentFee.subSchemeDetailModelId +
        "')\"></td>";
    tbody.appendChild(tr);


    // remove element from misc fees
    miscFees = miscFees.filter(function(fee) {
        return selectedFee != fee.subSchemeDetailModelId;
    });

    feelupMiscFees();
    onChangeFeeQuantity(currentFee.subSchemeDetailModelId);
}
var subjectFees;

function renderFeeStructureTableData(data) {
	var totalStandardTaxByBaseCurrency = 0;
    subjectFees = data;
    standardFee = data[0].totalResult.amountByBaseCurrency;
    standardTaxAmount = data[0].totalResult.taxAmount;
    
    
    document.getElementById("lStandardFee").innerHTML = formatMoney(standardFee);
    document.getElementById("lGST").innerHTML = formatMoney(standardTaxAmount);

    var tbody = document.getElementById("standardFeeData");
    tbody.innerHTML = "";
    data[0].resutlBySubject.forEach(function(fee) {
    	if(fee.amountByCurrency > 0){
    		totalStandardTaxByBaseCurrency += fee.taxAmountByBaseCurrency;
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
    standardFeeBeforeGST = data[0].totalResult.amountByBaseCurrency - totalStandardTaxByBaseCurrency;
    calculateTotalMiscFees();
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
    option.text = fee.subSchemeName;
    option.value = fee.subSchemeDetailModelId;

    var select = document.getElementById("miscFeesSelect");
    select.appendChild(option);
}

function onSelectProgramme() {
	miscFees = [];
	miscFeesArray = [];
	document.getElementById("miscFeeTableData").innerHTML = "";
	feelupMiscFees();
    var availableProgrammes = document.getElementById("availableProgrammes");
    newProgramme = availableProgrammes.options[availableProgrammes.selectedIndex].value;
    loadSubjects(newProgramme);
}

function getPricingScheme(programme) {
    AUI().use('aui-io-request-deprecated', 'aui-base', function(A) {
        var _data = {};
        var qq = "/api/jsonws/SystemModelSetup-portlet.system/get-entity-link/group-id/" + globalMicroserviceGroupId + "/query-by-example-json-string/{   ModelLeft:'Schedule', ModelLeft1:'Programme',   ModelRight:'PriceScheme', StorageIdLeft:'" + schedule_code + "', StorageIdLeft1:'" + programme + "'}/-return-field-list/retrieve-model-details/ModelRight/flatten/true";
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
                        for (var i = 0; i < data.length; i++) {
                        	if (data[i].PricingType == "MiscFees") {
                                miscPricingScheme = data[i].PricingSchemeCode;
                                miscPricingType = data[i].PricingType;
                                getMiscFeesData(enrolment, data[i]);
                            } else {
                                pricingScheme = data[i].PricingSchemeCode;
                                PricingType = data[i].PricingType;
                            }
                        }
                    }
                },
                failure: function() {

                }
            }
        });
    });
}

function formatNumber(num) {
	console.log(num);
	num = round(parseFloat(num),2).toFixed(2);
	return parseFloat(num);
}

function formatMoney(num){
	num = round(parseFloat(num),2).toFixed(2);
	return addCommas(num);
}

function round(value, decimals) {
	return Number(Math.round(value+'e'+decimals)+'e-'+decimals);
}

function addCommas(nStr) {
	nStr += '';
	var x = nStr.split('.');
	var x1 = x[0];
	var x2 = x.length > 1 ? '.' + x[1] : '';
	var rgx = /(\d+)(\d{3})/;
	while (rgx.test(x1)) {
		x1 = x1.replace(rgx, '$1' + ',' + '$2');
	}
	return x1 + x2;
}

function showCustomPopup(popupdiv, popupdivbox) {
	AUI().use('aui-base', function(A) {
		A.one(popupdiv).set('hidden', false);
		YUI().use('aui-modal', function(Y) {
			var modal = new Y.Modal({
				boundingBox: popupdiv,
				contentBox: popupdivbox,
				headerContent: '',
				centered: true,
				destroyOnHide: false,
				modal: true,
				resizable: false,
				draggable: false,
			}).render();
		});
	});
}

function renderCurrentAmounts(feesData, miscFees) {
	totalStandartFee = 0;
	totalMiscFee = 0;
	totalGst = 0;
	totalFeeExclGst = 0;
	totalFeeInclGst = 0;
	examFeesAmount = 0;
	localFeesAmount = 0;
	for(var feesi in feesData) {
		var currentFeesData = feesData[feesi];
		currentFeesData.resutlBySubject.forEach(function(feeData) {
			console.log(feeData.priceSubType);
			if(feeData.priceSubType=="ExamFees") {
				totalStandartFee = totalStandartFee + feeData.amountByBaseCurrency;
				examFeesAmount = examFeesAmount + feeData.amountByBaseCurrency;
			} else if(feeData.priceSubType=="LocalFees") {
				totalStandartFee = totalStandartFee + feeData.amountByBaseCurrency;
				localFeesAmount = localFeesAmount + feeData.amountByBaseCurrency;
			} else {
				totalMiscFee = totalMiscFee + feeData.amountByBaseCurrency;
			}
			totalGst = totalGst + feeData.taxAmountByBaseCurrency;
		});
	}
	
	for(var mfi in miscFees) {
		var currentMiscFees = miscFees[mfi];
		totalGst = totalGst + (formatNumber(currentMiscFees.taxAmount) * formatNumber(currentMiscFees.quantity));
		totalMiscFee = totalMiscFee + (formatNumber(currentMiscFees.amount) * formatNumber(currentMiscFees.quantity));
	}
	
	try {
		totalStandartFee = feesData[0].totalResult.amountByBaseCurrency;
	} catch (e) {
		console.log(e);
	}
	
	totalFeeExclGst = (totalStandartFee + totalMiscFee) - totalGst;
	totalFeeInclGst = totalStandartFee + totalMiscFee;
	
	console.log("totalStandartFee : "+totalStandartFee);
	console.log("totalMiscFee : "+totalMiscFee);
	console.log("totalGst : "+totalGst);
	console.log("totalFeeExclGst : "+totalFeeExclGst);
	console.log("totalFeeInclGst : "+totalFeeInclGst);
	
	document.getElementById("cpTotalStandardFee").innerHTML = formatMoney(totalStandartFee);
	document.getElementById("cpTotalMiscFee").innerHTML = formatMoney(totalMiscFee);
	document.getElementById("cpTotalGST").innerHTML = formatMoney(totalGst);
	document.getElementById("cpTotalFeeExclGST").innerHTML = formatMoney(totalFeeExclGst);
	document.getElementById("cpTotalFeeInclGST").innerHTML = formatMoney(totalFeeInclGst);
	
}

function applyLateFee(scheduleCode) {
	ajaxCall(
	        "GET",
	        "loadData",
	        ajaxurl,
	        {
	    		"formType" : "Schedule",
	    		"formStorageId" : encodeURIComponent(scheduleCode)
	    	},
	        function() {
	            var data = this.get("responseData");
	            if (_.isEmpty(data)) {
	                console.log("error");
	            } else {
	            	console.log(data);
	            	if(data.contentJson && data.contentJson.Running && data.contentJson.Running.toLowerCase()=="no") {
	            		renderMiscFeeStructureTableData("LateFees");
	            	}
	            }
	        },
	        function() {

	        });
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
                console.log("email notification error");
            } else if (newEnrolmentStatus) {
            	SambaashUtils.applyContentJsonPatch(_SCOPE_GROUP_ID, 'enrolment', enrolmentId, {EnrolmentStatus: newEnrolmentStatus})
            }
        }
    );
}

function switchProceedToPay() {
	sendNotification("tempcredential");
	SambaashUtils.applyContentJsonPatch(_SCOPE_GROUP_ID, 'enrolment', enrolmentId, {EnrolmentStatus: "Notified"});
	location.href = collectPaymentUrl+"&receiptFor=candidate&userId="+enrolment.CandidateId+"&idNumber="+enrolment.IDNumber+"&userName="+enrolment.FullName;
}

function backToListing() {
	location.href = listingPageUrl;
}

function getMiscFeesData(enrolment, priceScheme) {    	
	var miscFeesInput = {
			scopeGroupId: _SCOPE_GROUP_ID,
		    programmeScheduleCode: encodeURI(enrolment.programSemester.storageId),
		    programmeType: 'MiscFees',
   		    fullUnitNumber: '',
   		    halfUnitNumber: '',
   		    lawUnitNumber: '',
   		    dateString: SambaashUtils.today(),
   		    priceSchemeCode: [priceScheme.PricingSchemeCode],
   		    promoCode: '',
   		    subjectCodes: [],
   		    subjectTypes: [],
   		    date: "16/09/2019",
   		 	roundingScale: '2',
	        roundingMode: 'HALF_UP',
	        dateFormat: 'MM/dd/yyyy',
	        baseCurrency: 'SGD',	// set base currency accordingly, not sure
									// where to get
	        baseCurrencyCode: '',
	        priceCategory: '',
	        transactionFeeMap: null,
	        action: 'MiscFees',
	        purposeForExchangeRate: 'Pricing Engine',
	        endPoint: "miscfees/calculations",
	        limit: 123,
	        page: 0,
	        formType: "pricescheme"
		  };
	ajaxCall(
	        "POST",
	        "sendRequest",
	        ajaxurl,
	        miscFeesInput,
	        function () {
	        	console.log("data");
	        	var data = this.get("responseData");
	        	console.log(data);
	        	if(data.length > 0){
	  		    	miscFees = data[0].resutlByPriceType;
	  		    	console.log("miscFees");
	  		    	console.log(data[0]);
	  		    	feelupMiscFees();
	  		    	applyLateFee(enrolment.programSemester.ScheduleCode);
	  		    	var savedMiscFees = enrolment.MiscFees;
	  		    	for(var i in savedMiscFees) {
	  		    		if(savedMiscFees[i].subSchemeDetailModelId) {
	  		    			renderMiscFeeStructureTableData(savedMiscFees[i].subSchemeDetailModelId, savedMiscFees[i].quantity);
	  		    		}
	  		    	}
  		    	}
	        },
	        function () {
	        	console.log("errr");
	     });
}
	