var modelName = "TransactionMaster";
var allMiscFees = {};
var usedMiscFees = {};
var processPaymentData = {};
hideAllButtons();
showLoading(true);
function init() {
	console.log("onload...");
	fetchDetails(formStorageId);
}
if(document.readyState == 'complete') {
	init();
} else {
	window.addEventListener('load', init);
}

function fetchDetails(formStorageId) {
	if (formStorageId != "") {
		
		//fetchMiscFees();
		fetchMiscFeeList();
		populateDetails(formStorageId);
		//populateRemarks(formStorageId);
	}
}

function confirmPayment(){
	if(doMassPaymentValidation()){
		if(showTotalAmount()>0){
			closePaymentSection();
			doInvoiceAction("pendingApproval", formStorageId);
		}else{
			recursiveProcessRecord(0, [{storageId:formStorageId}]);
		}
	}
	return;
}

function getMiscDetails(){
var transactionDetails = [];
for(var key in usedMiscFees){
	var miscFeeTable = usedMiscFees[key];
	var detail = {
	        "title":key,
	        "description":processPaymentData.Description,
	        "amountType": "Misc. Fee",
	        "currency": miscFeeTable.currency,
	        "baseCurrency": miscFeeTable.currency ? miscFeeTable.currency : "SGD",
	        "quantity": miscFeeTable.quantity,
	        "unitPrice" :miscFeeTable.unitPrice,
	        "amount":miscFeeTable.amount,
	        "organisationId": null,// processPaymentData.TransactionMasterCode,
	        "taxable": miscFeeTable.taxable,
	        "tax": miscFeeTable.tax,
	        "taxCode": null//(miscFeeTable.taxable=="Yes")?taxObj.TaxCode:null
	};
	transactionDetails.push(detail);
}
	return transactionDetails;
}

function closePaymentSection() {
	var elem = document.getElementById("paymentDiv");
	var width = 35;
	var id = setInterval(frame, 10);
	function frame() {
		if (width == 0) {
			document.getElementById("mainDiv").style.display = "none";
			clearInterval(id);
		} else if (width == 30) {
			document.getElementsByClassName("totalDiv")[0].style.display = "none";
			width--;
			elem.style.width = width + '%';
		} else {
			width--;
			elem.style.width = width + '%';
		}
	}
}

function doCalculateFee(){
	if(!doMassPaymentValidation()){
		return;
	}
	var subTotalLabel = processPaymentData.TotalAmountBaseCurrency;
	var miscFeesLabel = showTotalAmount();
	var totalPayableAmount = parseInt(subTotalLabel) - parseInt(miscFeesLabel);

	getEID("subTotalLabel").innerText = formatNumbers(subTotalLabel);
	getEID("miscFeesLabel").innerText = "- "+formatNumbers(miscFeesLabel);
	getEID("totalPayableAmount").innerText = formatNumbers(totalPayableAmount);
	if(miscFeesLabel>0){
		getEID("gstDiv").style.display = "";
		getEID("grandTotalDiv").style = "";
		getEID("previewBtn").innerText = "SUBMIT FOR APPROVAL";
		getEID("previewBtn").style= "width:215px !important";
		getEID("acceptPaymentBtn").style= "margin-left:10px !important";
		
		
	}
	else{
		document.getElementById("gstDiv").style.display = "none";
		document.getElementById("grandTotalDiv").style = "padding-top: 7px;border-top: 2px solid #b1bed7;";
		document.getElementById("previewBtn").innerText = "CONFIRM PAYMENT";
	}
	document.getElementById("mainDiv").style.display = "block";
	var elem = document.getElementById("paymentDiv");
	var width = 1;
	elem.style.width = width + '%';
	var id = setInterval(frame, 10);
	function frame() {
		if (width == 35) {
			clearInterval(id);
		} else if (width == 30) {
			document.getElementsByClassName("totalDiv")[0].style.display = "block";
			width++;
			elem.style.width = width + '%';
		} else {
			width++;
			elem.style.width = width + '%';
		}
	}
	return;
}

function removeThisRow(t, id){
	delete usedMiscFees[id];
	t.parentElement.parentElement.remove();
	populateMiscFees();
	showTotalAmount();
}

function showTotalAmount(){
	var totalAmount=0;
	var tAmtData = document.getElementsByClassName("miscRowTotalAmount");
	for(var i=0; i<tAmtData.length;i++){
		totalAmount = totalAmount + parseInt(tAmtData[i].getAttribute("value"));
	}
	getEID("totalAmount").innerText = formatNumbers(totalAmount);
	return totalAmount;
}

function calculateTotalAmount(t,k){
	var qty = parseInt(t.value);
	var price = parseInt(t.parentElement.parentElement.childNodes[3].innerText);
	var total = parseInt(qty * price);
	if(total!="NaN"){
		t.parentElement.parentElement.childNodes[5].innerText = formatNumbers(total);
		t.parentElement.parentElement.childNodes[5].setAttribute("value", total);
		if(usedMiscFees.hasOwnProperty(k)){
			usedMiscFees[k]["quantity"] = qty;
			usedMiscFees[k]["amount"] = total;
		}
		showTotalAmount();
	}else{
		t.parentElement.parentElement.childNodes[5].innerText = "";
	}
}


function changeMiscFees(t){
	if(t.value==""){
		return;
	}
	//showLoading(true);
	var rowDetails = getEID("miscFeesDetails").innerHTML;
	var curencyCode = allMiscFees[t.value].hasOwnProperty("currency")?allMiscFees[t.value].currency:"SGD";
	var isTax = allMiscFees[t.value].hasOwnProperty("taxable")?allMiscFees[t.value].taxable:"No";
	var amount= allMiscFees[t.value].hasOwnProperty("unitPrice")?allMiscFees[t.value].unitPrice:100;
	rowDetails = rowDetails + "<td>"+allMiscFees[t.value]["priceSubSchemeName"]+"</td><td>"+isTax+"</td><td>"+curencyCode+"</td><td class='amount'>"+formatNumbers(amount)+"</td><td><input onkeyup=\"calculateTotalAmount(this,'"+t.value+"')\" type='text' value='1' /></td><td style='text-align:right;' value='"+amount+"' class='miscRowTotalAmount'>"+formatNumbers(amount)+"</td><td><img onclick=\"removeThisRow(this,'"+t.value+"')\" src='"+closePng+"' alt='Close'></td>"
	getEID("miscFeesDetails").innerHTML = rowDetails;
	usedMiscFees[t.value] = allMiscFees[t.value];
	usedMiscFees[t.value]["quantity"] = 1;
	populateMiscFees();
	showTotalAmount();
}
function populateMiscFees(){
	var optHTML = "<option value=''>Choose a Miscellaneous fee...</option>";
	for(var key in allMiscFees){
		if(key != undefined && !usedMiscFees.hasOwnProperty(key)){
			var mf = usedMiscFees[key];
			optHTML = optHTML + "<option value='"+key+"'>"+allMiscFees[key]["priceSubSchemeName"]+"</option>";
		}
	}
	getEID(namespace+"miscFees").innerHTML = optHTML;
}

function fetchMiscFeeList(){
	var data = {};
	data.formType = 'PriceScheme';
	data.priceSchemeId = globalPriceScheme;
	ajaxCallAPI('GET','fetchMiscFeeSchemeList',data,
	 	function(){
		  var map = this.get("responseData");
		  for(var k in map){
			  for(var i=0;i<map[k].length;i++){
				  allMiscFees[map[k][i].title] = map[k][i];
				  allMiscFees[map[k][i].title]["priceSubSchemeName"] = map[k][i].title;
			  }
		  }
		  console.log(map);
		  populateMiscFees();
          },
          function() {
   		});
}

function fetchMiscFees(){
	var data = {};
	data.formType = "PriceSubScheme";
	data.conditions = ["contentJson.PriceType=MiscFees","contentJson.Status=Active","size="+2147483647,"sort=created_date,desc"];
	ajaxCallAPI(
			'GET',
			"searchList",
			data,
			function() {
				data = this.get("responseData");
				var contentdata = this.get("responseData");
				var responseData = [];
				if (data.error) {
					displayMessage('danger', data.error, 3000);
				} else {
					responseData = contentdata.content;
					for(var i=0;i<responseData.length;i++){
						allMiscFees[responseData[i].storageId] = responseData[i];
					}
					populateMiscFees();
				}
			}, function() {
				displayMessage('danger',
						"Error in populating remarks.", 3000);
			});
}
function populateRemarks(formStorageId) {
	var data = {};
	data.formType = "InvoiceRemarks";
	data.conditions = ["contentJson.ReferenceId="+formStorageId,"size="+2147483647,"sort=created_date,desc"];
	ajaxCallAPI(
			'GET',
			"searchList",
			data,
			function() {
				data = this.get("responseData");
				var contentdata = this.get("responseData");
				var responseData = [];
				if (data.error) {
					displayMessage('danger', data.error, 3000);
				} else {
					responseData = contentdata.content;
					console.log("responseData : "+responseData);
					var olderAdded = false;
					var todayAdded = false;
					for(var i=0;i<responseData.length;i++) {
						var remark = responseData[i];
						var remarkTemplate = getEID(namespace+"remarkTemplate").cloneNode(true);
						var remarksAction = remarkTemplate.getElementsByClassName("remarksAction")[0];
						var remarksTime = remarkTemplate.getElementsByClassName("remarksTime")[0];
						var remarksText = remarkTemplate.getElementsByClassName("remarksText")[0];
						var dayRow = remarkTemplate.getElementsByClassName("dayRow")[0];
						var dayText = remarkTemplate.getElementsByClassName("dayText")[0];
						
						if(remark.contentJson.ApprovalStatus == "Pending Approval") {
							remarksAction.innerHTML = "<b>"+remark.createdBy+"</b> submitted for approval";
						} else if(remark.contentJson.ApprovalStatus == "Approved") {
							remarksAction.innerHTML = "<b>"+remark.createdBy+"</b> approved";
						} else if(remark.contentJson.ApprovalStatus == "Rejected") {
							remarksAction.innerHTML = "<b>"+remark.createdBy+"</b> rejected";
						} else if(remark.contentJson.ApprovalStatus == "Return for Amendments") {
							remarksAction.innerHTML = "<b>"+remark.createdBy+"</b> returned for amendments";
						} else if(remark.contentJson.ApprovalStatus == "Void") {
							remarksAction.innerHTML = "<b>"+remark.createdBy+"</b> voided";
						} else {
							remarksAction.innerHTML = "<b>"+remark.createdBy+"</b> created";
						}
						var dt = new Date(Date.parse(remark.createdDate));
						if(isToday(dt)) {
							if(todayAdded) {
								dayRow.style.display = "none";
							} else {
								dayRow.style.display = "block";
								dayText.innerHTML = "<b>Today</b>";
								todayAdded = true;
							}
							remarksTime.innerHTML = formatNumber(dt.getHours())+":"+formatNumber(dt.getMinutes());
						} else {
							if(olderAdded) {
								dayRow.style.display = "none";
							} else {
								olderAdded = true;
								dayRow.style.display = "block";
								dayText.innerHTML = "<b>Older</b>";
							}
							remarksTime.innerHTML = formatNumber(dt.getDate())+"/"+formatNumber(dt.getMonth()+1)
							+"/"+formatNumber(dt.getFullYear())+" "+formatNumber(dt.getHours())+":"+formatNumber(dt.getMinutes());
						}
						remarksText.innerHTML = remark.contentJson.Remark;
						remarkTemplate.style.display = "block";
						getEID("invoiceRemarksContainer").appendChild(remarkTemplate);
					}
					getEID("totalRemarks").innerHTML = "(Total: "+responseData.length+" Remarks)";
				}
			}, function() {
				displayMessage('danger',
						"Error in populating remarks.", 3000);
			});
}

function isToday(date) {
	var argDate = new Date(date);
	var todaysDate = new Date();
	if(argDate.setHours(0,0,0,0) == todaysDate.setHours(0,0,0,0)) {
	    return true;
	}
	return false;
}

function formatNumber(number) {
	return parseInt(number)<10?"0"+number:number;
}

function displayDetailsByStatus(status){
	if(status == "Pending"){
		getEID("paymentStatus").className = "payment-status pending";
		getEID("amountToBePaidRow").style = "display:none";
		getEID("miscFeeRow").style = "display:none";
		getEID("paymentModeRow").style = "display:none";
		getEID("valueDateRow").style = "display:none";
		getEID("creditDateRow").style = "display:none";
		getEID("paymentSetCodeRow").style = "display:none";
		getEID("notesRow").style = "display:none";
	}
	else if(status == "Confirmed"){
		getEID("paymentStatus").className = "payment-status confirmed";
		getEID("amountToBePaidRow").style = "display:none";
		getEID("miscFeeRow").style = "display:none";
	}
	else if(status == "Pending Approval"){
		getEID("paymentStatus").className = "payment-status confirmed";
	}
	else if(status == "Pending Approval"){
		getEID("paymentStatus").className = "payment-status pending-approval";
	}

}
	
function populateDetails(formStorageId) {
	var data = {};
	data.formStorageId = formStorageId;
	data.formType = modelName;
	data.indetail = "true";
	console.log("data : "+JSON.stringify(data));
	ajaxCallAPI(
			'GET',
			"loadData",
			data,
			function() {
				data = this.get("responseData");
				var contentdata = this.get("responseData");
				console.log("contentdata : " + JSON.stringify(contentdata));
				if (data.error) {
					displayMessage('danger', data.error, 3000);
				} else {
					processPaymentData= contentdata.contentJson;
					getEID("refNo").innerHTML = contentdata.contentJson.ExtRefNumber==undefined?"":contentdata.contentJson.ExtRefNumber;
					getEID("idAndName").innerHTML = contentdata.contentJson.IdName;
					getEID("description").innerHTML = contentdata.contentJson.Description;
					getEID(namespace+"valueDate").value = contentdata.contentJson.ValueDate==undefined?"":contentdata.contentJson.ValueDate;
					getEID(namespace+"creditDate").value = contentdata.contentJson.CreditDate==undefined?"":contentdata.contentJson.CreditDate;
					getEID(namespace+"paymentSetCode").value = contentdata.contentJson.PaymentSetCode==undefined?"":contentdata.contentJson.PaymentSetCode;
					getEID("amountPayable").innerHTML = contentdata.contentJson.TotalAmountBaseCurrency;
					getEID("notes").value = contentdata.contentJson.Notes==undefined?"":contentdata.contentJson.Notes;

					//getEID("paymentStatus").innerHTML = contentdata.contentJson.TransactionStatus;
					//getEID(namespace+"paymentMode").value = contentdata.contentJson.CreditDate;
					//getEID("productType").innerHTML = contentdata.contentJson.ProductType + " - " + contentdata.contentJson.ProductSubType;
					

					showLoading(false);
				}
			}, function() {
				displayMessage('danger',
						"Error in persisting dynamic form data.", 3000);
				showLoading(false);
			});
}

function hideAllButtons() {
	showHideElementById("submit", "none");
	showHideElementById("approve", "none");
	showHideElementById("reject", "none");
	showHideElementById("return", "none");
	showHideElementById("void", "none");
	showHideElementById("cancel", "none");
	showHideElementById("edit", "none");
}