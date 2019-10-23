var processRefundTableId = document.getElementById('processRefundTableId');
var processRefundContainerRow = document.getElementById('processRefundContainerRow');

var miscRefundTableId = document.getElementById('miscRefundTableId');
var miscRefundContainerRow = document.getElementById('miscRefundContainerRow');
var miscRefundTotalContainerRow = document.getElementById('miscRefundTotalContainerRow');
var miscRefundMap = {};

var feeSchemeTableId = document.getElementById('feeSchemeTableId');
var feeSchemeContainerRow = document.getElementById('feeSchemeContainerRow');
var feeSchemeTotalContainerRow = document.getElementById('feeSchemeTotalContainerRow');

var feeSchemeTotal = 0;
var feeSchemeMap = {};
var feeSchemeList = [];
var mafLoaded = false;

function initProcessRefund(){
	getRefundMiscFees();
	loadDefaultData(function() {
		fetchById(formStorageId);
	});
}

function getRefundMiscFees(){
	var data = {};
	data.formType = 'CreditBalance';
	ajaxCallAPI('GET','getRefundMiscFees',data,
	 	function(){
		  	var miscRecordMap = this.get("responseData");
		  	if(miscRecordMap != null && Object.keys(miscRecordMap).length > 0){
		  		miscRefundMap = miscRecordMap;
		  		drawMiscRecord();
		  	}else{
		  		document.getElementById("miscRefundDivId").style.display = "none";
		  	}
		  	
          },
          function() {
   		});
}

function drawMiscRecord(){
	var rows =  miscRefundTableId.rows;
	var len = rows.length;
	for( var i=len-1;i>0; i--){
		miscRefundTableId.deleteRow(i);
	}
	var amountMiscTotal = 0;
	for(var key in miscRefundMap){
		var subSchemeList = miscRefundMap[key];
		if(subSchemeList){
			for(var j=0; j<subSchemeList.length; j++){
				var node = miscRefundContainerRow.cloneNode(true);
				var miscRefundTable = subSchemeList[j];
				node.cells[0].innerHTML = miscRefundTable.title;
				node.cells[1].innerHTML = miscRefundTable.taxable;
				node.cells[2].innerHTML = miscRefundTable.currency;
				node.cells[3].innerHTML = miscRefundTable.amount;
				miscRefundTableId.appendChild(node);
				amountMiscTotal = amountMiscTotal + parseFloat(miscRefundTable.amount);
			}
		}
	}
	var nodeRow =  miscRefundTotalContainerRow.cloneNode(true);
	nodeRow.cells[3].innerHTML = amountMiscTotal;
	miscRefundTableId.appendChild(nodeRow);
}

function loadDefaultData(callback) {
	getFeeSchemeList(function(){
		if(mafLoaded == true){
			showLoading(false);
			drawFeeSchemeRow();
			callback();
		}
	});
	
}

function getFeeSchemeList(callback){
	getMiscFeeSchemeList(globalPriceScheme, function(dataList){
		feeSchemeMap =  dataList;
		var elementDrpDwn = getEID(namespace + "feeSchemeId");
		var opt = null;
		for(var key in dataList){
			opt = new Option(key, key);
			elementDrpDwn.options[elementDrpDwn.options.length] = opt;
		}
		mafLoaded = true;
		callback();
	});
}

function getMiscFeeSchemeList(priceSchemeId, callback){
	var data = {};
	data.formType = 'PriceScheme';
	data.priceSchemeId = priceSchemeId;
	ajaxCallAPI('GET','fetchMiscFeeSchemeList',data,
	 	function(){
		  var map = this.get("responseData");
			  callback(map);
          },
          function() {
   		});
}

function TransactionDetail(title, currency, taxable, unitPrice, quantity, amount, tax,deleteStatus) {
	this.title = title;
	this.taxable = taxable;
	this.unitPrice = unitPrice;
	this.quantity = quantity;
	this.amount = amount;
	this.tax = tax;
	this.deleteStatus = deleteStatus;
	this.currency = currency;
}

function removeFeeSchemeRow(e){
	var elem = e.parentElement.parentElement;
	var removeTitle = elem.getElementsByClassName("title")[0].innerHTML;
	for(var j=0; j<feeSchemeList.length; j++){
		var currFeeSchemeList = feeSchemeMap[feeSchemeList[j]];
		for(var k=0;k<currFeeSchemeList.length; k++) {
			var feeScheme = currFeeSchemeList[k];
			if(feeScheme.title == removeTitle) {
				feeScheme.deleteStatus = "Removed";
				feeScheme.quantity = 1;
			}
		}
	}
	drawFeeSchemeRow();
	var schemeTable = document.getElementById("feeSchemeTableId");
	var schemeDD = document.getElementById(namespace+"feeSchemeId");
	var rows =  schemeTable.rows;
	var len = rows.length;
	if(len==2) {
		schemeDD.selectedIndex = 0;
		schemeTable.style.display = "none";
		feeSchemeList = [];
	}
}

function drawFeeSchemeRow(){
	var schemeDD = document.getElementById(namespace+"feeSchemeId");
	var schemeTable = document.getElementById("feeSchemeTableId");
	var rows =  schemeTable.rows;
	var len = rows.length;
	for(var i=len-1;i>0; i--){
		schemeTable.deleteRow(i);
	}
	if(schemeDD.value=="") {
		schemeTable.style.display = "none";
		feeSchemeList = [];
	} else {
		console.log("feeSchemeList : "+feeSchemeList);
		console.log("feeSchemeList : "+feeSchemeList.indexOf(schemeDD.value));
		if(feeSchemeList.indexOf(schemeDD.value)==-1) {
			feeSchemeList.push(schemeDD.value);
		}
		for(var j=0; j<feeSchemeList.length; j++){
			var feeSubSchemeList = feeSchemeMap[feeSchemeList[j]];
			for(var k=0;k<feeSubSchemeList.length; k++) {
				var node = feeSchemeContainerRow.cloneNode(true);
				var feeSubScheme = feeSubSchemeList[k];
				if(feeSubScheme.deleteStatus!="Removed") {
					node.cells[0].innerHTML = feeSubScheme.title;
					node.cells[1].innerHTML = feeSubScheme.taxable;
					node.cells[2].innerHTML = feeSubScheme.currency;
					node.cells[3].innerHTML = parseFloat(feeSubScheme.unitPrice).toFixed(2);
					node.cells[4].getElementsByTagName("input")[0].value = feeSubScheme.quantity;
					node.cells[5].getElementsByTagName("input")[0].value = parseFloat(feeSubScheme.amount).toFixed(2);
					//node.cells[5].getElementsByClassName("unitTax")[0].value = parseFloat(feeSubScheme.tax);
					schemeTable.appendChild(node);
					changePriceQnty(node.cells[4].getElementsByTagName("input")[0]);
				}
			}
		}
		
		var nodeRow = feeSchemeTotalContainerRow.cloneNode(true);
		nodeRow.cells[5].innerHTML = parseFloat(feeSchemeTotal).toFixed(2);
		schemeTable.appendChild(nodeRow);
		schemeTable.style.display = "block";
	}
}

function changePriceQnty(element){
	var mainDiv = element.parentElement.parentElement;
	console.log(mainDiv);
	var title = mainDiv.getElementsByClassName("title")[0].innerHTML;
	var quantity = mainDiv.getElementsByClassName("quantity")[0].value;
	var unitPrice = mainDiv.getElementsByClassName("unit-price")[0].innerHTML;
	console.log("unitPrice : "+unitPrice);
	console.log("quantity : "+quantity);
	if(unitPrice && quantity){
		mainDiv.getElementsByClassName("amount")[0].value = (parseFloat(unitPrice) * quantity).toFixed(2);
	}
	
	for(var j=0; j<feeSchemeList.length; j++){
		var currFeeSchemeList = feeSchemeMap[feeSchemeList[j]];
		for(var k=0;k<currFeeSchemeList.length; k++) {
			var feeScheme = currFeeSchemeList[k];
			if(feeScheme.title == title) {
				feeScheme.quantity = quantity;
			}
		}
	}
	
	changeTotalValue();
}

function changeTotalValue(){
	feeSchemeTotal = 0;
	var schemeTable = document.getElementById("feeSchemeTableId");
	
	var amountFields = schemeTable.getElementsByClassName("amount");
	for(var amountI=0; amountI<amountFields.length; amountI++) {
		var amountField = amountFields[amountI];
		console.log(amountField);
		feeSchemeTotal = feeSchemeTotal + parseFloat(amountField.value);
		console.log("feeSchemeTotal : "+feeSchemeTotal);
	}
	
	var totalNodes = schemeTable.getElementsByClassName("totalContainer");
	if(totalNodes.length>0) {
		var totalNode = schemeTable.getElementsByClassName("totalContainer")[0];
		totalNode.cells[5].innerHTML = parseFloat(feeSchemeTotal).toFixed(2);
	}
}

function feeSchemeDDChange() {
	var schemeDD = document.getElementById(namespace+"feeSchemeId");
	var subSchemeList = feeSchemeMap[schemeDD.value];
	if(subSchemeList) {
		for(var k=0;k<subSchemeList.length; k++) {
			var subScheme = subSchemeList[k];
			subScheme.deleteStatus = "";
		}
	}
	drawFeeSchemeRow();
}

function fetchById(id){
	showLoading(true);
	if (formStorageId != "") {
		var data = {};
		data.formStorageId = formStorageId;
		data.formType = modelName;
		ajaxCallAPI(
			'GET',
			"loadData",
			data,
			function() {
				data = this.get("responseData");
				if (data.error) {
					displayMessage('danger', data.error, 3000);
				} else {
					getEID(namespace + "UserType").value = data.contentJson.UserType;
					getEID(namespace + "UserId").value = data.contentJson.UserId;
					processRefundContainerRow.cells[0].innerHTML = getIdFromIdName(data.contentJson.IdAndName);
					processRefundContainerRow.cells[1].innerHTML = data.contentJson.UserName
					processRefundContainerRow.cells[2].innerHTML = parseFloat(data.contentJson.CreditBalanceAmt).toFixed(2);
					processRefundContainerRow.cells[4].getElementsByTagName("input")[0].va0lue = parseFloat(data.contentJson.Amount).toFixed(2);
					if(data.contentJson.Notes){
						getEID(namespace + "notes").value = data.contentJson.Notes;
					}else{
						getEID(namespace + "notes").value = "";
					}
				}
				showLoading(false);
			}, function() {
				displayMessage('danger',
						"Error in persisting dynamic form data.", 3000);
				showLoading(false);
			});
	}
}

function calculateAmount(){
	if(checkIsValide()){
		var processedAmt = processRefundContainerRow.cells[4].getElementsByTagName("input")[0].value
		var feeSchemeAmt = getTotalFeeMiscAmt();
		var miscAmt = getTotalRefundAmt();
		if(isNaN(getTotalFeeMiscAmt())) {
			feeSchemeAmt = 0;
		}
		var msicFeeTotal = parseFloat(feeSchemeAmt) + parseFloat(miscAmt);
		document.getElementById("subTotalLabel").value = parseFloat(processedAmt) + parseFloat(msicFeeTotal);
		document.getElementById("subTotalLabel").innerHTML = formatNumbers(parseFloat(processedAmt) + parseFloat(msicFeeTotal));
		
		document.getElementById("miscTotalLabel").value = -msicFeeTotal;
		document.getElementById("miscTotalLabel").innerHTML = formatNumbers(-msicFeeTotal);
		
		var a = parseFloat(processedAmt);
		
		document.getElementById("totalReceivableAmount").value = a;
		document.getElementById("totalReceivableAmount").innerHTML = formatNumbers(a);
		if(a <= 0){
			document.getElementById("submit_refund_Btn").disabled=true;
		} else {
			document.getElementById("submit_refund_Btn").disabled=false;
		}
		openRefundSection();
	}
}

function getTotalFeeMiscAmt(){
	var l = feeSchemeTableId.rows.length;
	var nodeRow = feeSchemeTableId.rows[l-1];
	var feeSchemeAmt = nodeRow.cells[5].innerHTML;
	return feeSchemeAmt ?  parseFloat(feeSchemeAmt).toFixed(2): 0 ;
}

function getTotalRefundAmt(){
	var miscAmt = 0
	var rows = miscRefundTableId.rows;
	for( var i=1;i<rows.length; i++){
		if(rows[i].className.includes("miscRefundContainerRow")){
			var nodeRow = rows[i];
			var waive = nodeRow.cells[4].getElementsByTagName("input")[0].checked;
			var value = nodeRow.cells[3].innerHTML;
			if(!waive && value && value != undefined){
				miscAmt = miscAmt + parseFloat(nodeRow.cells[3].innerHTML);
			}
		}
	}
	
	return parseFloat(miscAmt).toFixed(2);
	
}

function closeRefundSection() {
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

function formatNumbers(num) {
	num = parseFloat(num).toFixed(2);
	return addCommas(num);
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

function openRefundSection(){
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
}

function checkIsValide() {
	var eValid = true;
	var amtProcessed = processRefundContainerRow.cells[4]
			.getElementsByTagName("input")[0].value;
	amtProcessed = parseFloat(amtProcessed);
	var creditBalance = processRefundContainerRow.cells[2].innerHTML;
	var feeSchemeAmt = parseFloat(getTotalFeeMiscAmt());
	var miscAmt = parseFloat(getTotalRefundAmt());
	creditBalance = parseFloat(parseFloat(creditBalance));
	
	if (amtProcessed == null) {
		eValid = false;
		displayMessage('danger', "Amount Processed is Mandatory", 3000);
	} else if (amtProcessed <= 0) {
		eValid = false;
		displayMessage('danger',
				"Please enter the correct amount to be refunded.", 3000);
	} else if ((amtProcessed + feeSchemeAmt + miscAmt) > creditBalance) {
		eValid = false;
		displayMessage(
				'danger',
				"Amount must not more than the amount available in the credit balance",
				3000);
	} else {
		var rows = feeSchemeTableId.rows;
		for (var ctr = 1; ctr < rows.length; ctr++) {
			if (rows[ctr].className.includes("feeSchemeContainerRow")) {
				var qty = rows[ctr].cells[4].getElementsByTagName("input")[0].value;
				if (!qty || qty.trim() == '') {
					eValid = false;
					displayMessage('danger', "Quantity is Mandatory", 3000);
					break;
				} else if (qty <= 0) {
					eValid = false;
					displayMessage('danger',
							"Quantity can not be 0 or less than 0", 3000);
					break;
				}
			}
		}

		rows = miscRefundTableId.rows;
		for (var i = 1; i < rows.length; i++) {
			if (rows[i].className.includes("miscRefundContainerRow")) {
				var waive = rows[i].cells[4].getElementsByTagName("input")[0].checked;
				var waiveReason = rows[i].cells[5]
						.getElementsByTagName("input")[0].value;
				if (waive && !waiveReason && waiveReason.trim() == "") {
					eValid = false;
					displayMessage('danger', "Waive Reason is Mandatory", 3000);
					break;
				}
			}
		}

	}

	return eValid;
}

function submitCollectPayment(){
	
	document.getElementById("credit_action_reason").value = "";
	document.getElementById("action_title").innerHTML = "Submit for Verification ?";
	openDialogNew("credit-action", function(modal) {
		modal.hide();
		var processedAmt = processRefundContainerRow.cells[4].getElementsByTagName("input")[0].value;
		var creditBalance = processRefundContainerRow.cells[2].innerHTML;
		var feeSchemeAmt = getTotalFeeMiscAmt();
		var miscAmt = getTotalRefundAmt();
		var totalMisc = parseFloat(feeSchemeAmt) + parseFloat(miscAmt);
		var payableAmt = parseFloat(processedAmt) + parseFloat(totalMisc);
		
		var userId = getEID(namespace + "UserId").value;
		var userName = processRefundContainerRow.cells[1].innerHTML;
		var paymentMode = processRefundContainerRow.cells[3].getElementsByTagName("select")[0].value;
		var userType = getEID(namespace + "UserType").value;
		var notes = getEID(namespace + "notes").value;
		closeRefundSection();
		showLoading(true);
		saveCreditBalance("Pending Verification", "Submit For Verification", userId, userName, userType, 
				creditBalance, "Refund", processedAmt, null, notes,getFeeSchemeListDetail(), 
				getRefundMiscDetails(), totalMisc, document.getElementById("credit_action_reason").value, paymentMode)
		}, null);
		

}

function getRefundMiscDetails(){
	var refundMiscDetails = [];
	
	var rows = miscRefundTableId.rows;
	for( var i=1;i<rows.length; i++){
		if(rows[i].className.includes("miscRefundContainerRow")){
			var nodeRow = rows[i];
			rm = {
				"title" : nodeRow.cells[0].innerHTML,
				"taxable" : nodeRow.cells[1].innerHTML,
				"currency" : nodeRow.cells[2].innerHTML,
				"amount" : nodeRow.cells[3].innerHTML,
				"waive" : nodeRow.cells[4].getElementsByTagName("input")[0].checked,
				"waiveReason" : nodeRow.cells[5].getElementsByTagName("input")[0].value,
			}
			refundMiscDetails.push(rm);
		}
	}
	
	return refundMiscDetails;
}

function getFeeSchemeListDetail(){
	
	var miscFeesDetails = [];
	var rows =  feeSchemeTableId.rows;
	for( var ctr=1;ctr<rows.length; ctr++){
		if(rows[ctr].className.includes("feeSchemeContainerRow")){
			var node = rows[ctr];
			 var dt = {
				        "title":node.cells[0].innerHTML,
				        "taxable":node.cells[1].innerHTML,
				        "amountType": getEID(namespace + "feeSchemeId").value,
				        "currency":  node.cells[2].innerHTML,
				        "baseCurrency": "SGD",
				        "quantity": node.cells[4].getElementsByTagName("input")[0].value,
				        "unitPrice" :node.cells[3].innerHTML,
				        "amount":node.cells[5].getElementsByTagName("input")[0].value,
				  };
			 miscFeesDetails.push(dt);
		}
	}
	
	return miscFeesDetails;
}
