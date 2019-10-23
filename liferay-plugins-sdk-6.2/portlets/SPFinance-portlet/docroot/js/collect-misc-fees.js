var adhocFeesContainerRow = document.getElementById('adhocFeesContainerRow');
var adhocTotalContainerRow = document.getElementById('adhocTotalContainerRow');
var feeSchemeContainerRow = document.getElementById('feeSchemeContainerRow');
var feeSchemeTotalContainerRow = document.getElementById('feeSchemeTotalContainerRow');

var candidateList = false;
var pssList = false;
var mafLoaded = false;
var taxObj = {};
var candidateMap = {};
var invoiceList = [];

var feeSchemeMap = {};
var feeSchemeTotal = 0;
var feeSchemeTaxTotal = 0;
var feeSchemeList = [];

var adhocFeeMap = {};
var adhocFeeTotal = 0;
var adhocFeeTaxTotal = 0;
var adhocFeeList = [];

showLoading(true);
if(document.readyState == 'complete') {
	init();
} else {
	window.addEventListener('load', init);
}

function init() {
	getTaxDetail();
	loadDefaultData(function() {
		/*setInterval(function() {
			//checkForm();
		}, 1000);*/
		receiptChange("Anonymous");
	});
}

function receiptChange(value){
	if(value == "Anonymous"){
		document.getElementById(namespace + "candidateDivId").style.display = "none";
	}else{
		document.getElementById(namespace + "candidateDivId").style.display = "";
	}
}

function getTaxDetail(){
	var c = country? country : 'Singapore'
	var datas = {};
	datas.formStorageId = formStorageId;
	datas.formType = "taxcode";
	datas.conditions = [ "contentJson.DefaultGST=yes",
	         			"contentJson.Status=Active", "contentJson.Country=" + c,
	         			"size=" + 2147483647, "sort=created_date,desc" ];
	ajaxCallAPI(
			'GET',
			"searchList",
			datas,
			function(response) {
				datas = this.get("responseData").content[0];
				if(datas){
					taxObj = datas.contentJson;
				}
			}, function() {
				showLoading(false);
			});
}

function checkForm() {
	console.log('check form');
}

function loadDefaultData(callback) {
	loadDropdowns(function() {
		if(candidateList == true && pssList == true && mafLoaded == true) {
			drawAdhocFeeRow();
			drawFeeSchemeRow();
			showLoading(false);
			callback();
		}
			
	});
}

// adhoc fee table
function adhocFeeDDChange(selectElmt, value){
    var adhocFeeDD = document.getElementById(namespace+"miscAdhocFeesId");
	var subSchemeList = adhocFeeMap[adhocFeeDD.value];
	if(subSchemeList) {
		for(var k=0;k<subSchemeList.length; k++) {
			var subScheme = subSchemeList[k];
			subScheme.deleteStatus = "";
		}
	}
	drawAdhocFeeRow();
}

function removeAdhocFeeRow(e){
	var elem = e.parentElement.parentElement;
	var removeTitle = elem.getElementsByClassName("title")[0].innerHTML;
	for(var j=0; j<adhocFeeList.length; j++){
		var currAdhocFeeList = adhocFeeMap[adhocFeeList[j]];
		for(var k=0;k<currAdhocFeeList.length; k++) {
			var adhocFee = currAdhocFeeList[k];
			if(adhocFee.title == removeTitle) {
				adhocFee.deleteStatus = "Removed";
				adhocFee.quantity = 1;
				adhocFee.description = "";
				adhocFee.taxable = "Yes";
				adhocFee.unitPrice = 0;
			}
		}
	}
	drawAdhocFeeRow();
	var adhocFeeTable = document.getElementById("adhocFeesTableId");
	var adhocFeeDD = document.getElementById(namespace+"miscAdhocFeesId");
	var rows =  adhocFeeTable.rows;
	var len = rows.length;
	if(len==2) {
		adhocFeeDD.selectedIndex = 0;
		adhocFeeTable.style.display = "none";
		adhocFeeList = [];
	}
}

function drawAdhocFeeRow(){
	var adhocFeeTable = document.getElementById("adhocFeesTableId");
	var adhocFeeDD = document.getElementById(namespace+"miscAdhocFeesId");
	var rows =  adhocFeeTable.rows;
	var len = rows.length;
	for(var i=len-1;i>0; i--){
		adhocFeeTable.deleteRow(i);
	}
	if(adhocFeeDD.value=="") {
		adhocFeeTable.style.display = "none";
		adhocFeeList = [];
	} else {
		console.log("adhocFeeList : "+adhocFeeList);
		console.log("adhocFeeList : "+adhocFeeList.indexOf(adhocFeeDD.value));
		if(adhocFeeList.indexOf(adhocFeeDD.value)==-1) {
			adhocFeeList.push(adhocFeeDD.value);
		}
		for(var j=0; j<adhocFeeList.length; j++){
			var subSchemeList = adhocFeeMap[adhocFeeList[j]];
			for(var k=0;k<subSchemeList.length; k++) {
				var node = adhocFeesContainerRow.cloneNode(true);
				var subScheme = subSchemeList[k];
				if(subScheme.deleteStatus!="Removed") {
					node.cells[0].innerHTML = subScheme.title;
					node.cells[1].getElementsByTagName("input")[0].value = subScheme.description;
					node.cells[2].getElementsByTagName("select")[0].value = subScheme.taxable==true?"Yes":"No";
					node.cells[3].getElementsByTagName("input")[0].value = parseFloat(subScheme.unitPrice).toFixed(2);
					node.cells[4].getElementsByTagName("input")[0].value = subScheme.quantity;
					node.cells[5].getElementsByTagName("input")[0].value = parseFloat(subScheme.amount).toFixed(2);
					adhocFeeTable.appendChild(node);
					changeAdhocFee(node.cells[4].getElementsByTagName("input")[0]);
				} else {
					changeAdhocFee(node.cells[4].getElementsByTagName("input")[0]);
				}
			}
		}
		
		var nodeRow = adhocTotalContainerRow.cloneNode(true);
		nodeRow.cells[5].innerHTML = parseFloat(adhocFeeTable).toFixed(2);
		adhocFeeTable.appendChild(nodeRow);
		adhocFeeTable.style.display = "block";
		changeAdhocFeeTotalValue();
	}
}

function changeAdhocFee(element){
	var mainDiv = element.parentElement.parentElement;
	console.log(mainDiv);
	var title = mainDiv.getElementsByClassName("title")[0].innerHTML;
	var description = mainDiv.getElementsByClassName("description")[0].value;
	var taxable = mainDiv.getElementsByClassName("taxable")[0].value;
	var unitPrice = mainDiv.getElementsByClassName("unitPrice")[0].value;
	var quantity = mainDiv.getElementsByClassName("quantity")[0].value;
	var totalTaxEle = mainDiv.getElementsByClassName("totalTax")[0];
	console.log("unitPrice : "+unitPrice);
	console.log("quantity : "+quantity);
	if(unitPrice && quantity){
		mainDiv.getElementsByClassName("amount")[0].value = (parseFloat(unitPrice) * quantity).toFixed(2);
		console.log("taxable : "+taxable);
		if(taxable=="Yes"){
			console.log("--"+(parseFloat(unitPrice) * quantity * taxObj.Percentage/100));
			totalTaxEle.value = (parseFloat(unitPrice) * quantity * taxObj.Percentage/100).toFixed(2);
		} else {
			console.log("--0--");
			totalTaxEle.value = 0;
		}
	}
	
	for(var j=0; j<adhocFeeList.length; j++){
		var currSubSchemeList = adhocFeeMap[adhocFeeList[j]];
		for(var k=0;k<currSubSchemeList.length; k++) {
			var subScheme = currSubSchemeList[k];
			if(subScheme.title == title) {
				subScheme.description = description;
				subScheme.taxable = taxable;
				subScheme.unitPrice = unitPrice;
				subScheme.quantity = quantity;
				subScheme.tax = totalTaxEle.value;
			}
		}
	}
	
	changeAdhocFeeTotalValue();
}

function changeAdhocFeeTotalValue(){
	adhocFeeTaxTotal = 0;
	adhocFeeTotal = 0;
	var adhocFeeTable = document.getElementById("adhocFeesTableId");
	
	var amountFields = adhocFeeTable.getElementsByClassName("amount");
	for(var amountI=0; amountI<amountFields.length; amountI++) {
		var amountField = amountFields[amountI];
		console.log(amountField);
		adhocFeeTotal = adhocFeeTotal + parseFloat(amountField.value);
		console.log("adhocFeeTotal : "+adhocFeeTotal);
	}
	var totalTaxFields = adhocFeeTable.getElementsByClassName("totalTax");
	for(var totalTaxI=0;totalTaxI<totalTaxFields.length;totalTaxI++) {
		var totalTaxField = totalTaxFields[totalTaxI];
		console.log("totalTaxField.value : "+totalTaxField.value);
		adhocFeeTaxTotal = adhocFeeTaxTotal + parseFloat(totalTaxField.value);
	}
	
	var totalNodes = adhocFeeTable.getElementsByClassName("totalContainer");
	console.log("totalNodes.length : "+totalNodes.length);
	if(totalNodes.length>0) {
		var totalNode = adhocFeeTable.getElementsByClassName("totalContainer")[0];
		console.log("parseFloat(adhocFeeTotal) : "+parseFloat(adhocFeeTotal));
		console.log("parseFloat(adhocFeeTotal) : "+parseFloat(adhocFeeTotal).toFixed(2));
		totalNode.cells[5].innerHTML = parseFloat(adhocFeeTotal).toFixed(2);
	}
	
}

// price scheme table
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
					node.cells[5].getElementsByClassName("unitTax")[0].value = parseFloat(feeSubScheme.tax);
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
	var unitPrice = mainDiv.getElementsByClassName("unitPrice")[0].innerHTML;
	var unitTax = mainDiv.getElementsByClassName("unitTax")[0].value;
	var totalTaxEle = mainDiv.getElementsByClassName("totalTax")[0];
	console.log("unitPrice : "+unitPrice);
	console.log("quantity : "+quantity);
	console.log("unitTax : "+unitTax);
	if(unitPrice && quantity){
		mainDiv.getElementsByClassName("amount")[0].value = (parseFloat(unitPrice) * quantity).toFixed(2);
		if(unitTax && unitTax!="") {
			totalTaxEle.value = parseFloat(unitTax) * quantity;
			console.log("no");
		} else {
			mainDiv.getElementsByClassName("unitTax")[0].value = 0;
			totalTaxEle.value = 0;
		}
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
	feeSchemeTaxTotal = 0;
	feeSchemeTotal = 0;
	var schemeTable = document.getElementById("feeSchemeTableId");
	
	var amountFields = schemeTable.getElementsByClassName("amount");
	for(var amountI=0; amountI<amountFields.length; amountI++) {
		var amountField = amountFields[amountI];
		console.log(amountField);
		feeSchemeTotal = feeSchemeTotal + parseFloat(amountField.value);
		console.log("feeSchemeTotal : "+feeSchemeTotal);
	}
	var totalTaxFields = schemeTable.getElementsByClassName("totalTax");
	for(var totalTaxI=0;totalTaxI<totalTaxFields.length;totalTaxI++) {
		var totalTaxField = totalTaxFields[totalTaxI];
		feeSchemeTaxTotal = feeSchemeTaxTotal + parseFloat(totalTaxField.value);
	}
	
	var totalNodes = schemeTable.getElementsByClassName("totalContainer");
	if(totalNodes.length>0) {
		var totalNode = schemeTable.getElementsByClassName("totalContainer")[0];
		totalNode.cells[5].innerHTML = parseFloat(feeSchemeTotal).toFixed(2);
	}
	
}

function getDateByFormat(d){
	var m = (d.getMonth() + 1);
	var t = d.getDate();
	var y = d.getFullYear();
	var s = t + "/" + m + "/" + y;
	return s;
}

function validateFields(){
	if(checkIsValide()){
		//calculateFeeFnct(false, adhocFeeSelectedMap);
		var receiptFor = document.querySelector('input[name="receiptFor"]:checked').value;
		invoiceList = [];
		var invData = {};
		var genInv = getInvoiceModel(receiptFor);
		invData.contentJson = JSON.stringify(genInv.contentJson);
		invoiceList.push(invData);
		var nameList = [];
		if(receiptFor == "Candidate"){
			var candidate = document.getElementById(namespace + "candidateId").value;
			 nameList.push({ "FullName" : candidateMap[candidate],"UserId" : document.getElementById(namespace + "candidateId").value});
		}else{
			 nameList.push({ "FullName" : ""});
		}
		var total = parseFloat(feeSchemeTotal) + parseFloat(adhocFeeTotal);
		var totalTax = parseFloat(feeSchemeTaxTotal) + parseFloat(adhocFeeTaxTotal);
		showPaymentSection(null, "SGD", total, totalTax, "misc", receiptFor,nameList,document.getElementById("notes").value);	
	}
}

function _displayMessage(type, message, duration) {
	scrollToTop();
	var alert_div = document.getElementById("alert_msg_id");
	alert_div.innerHTML = message;
	alert_div.classList.add("alert-" + type);
	alert_div.style.display = "block";
	setTimeout(function() {
		alert_div.style.display = "none";
	}, duration);
	console.log(message);
}

function checkIsValide() {
	var eValid = true;
	var receiptFor = document.querySelector('input[name="receiptFor"]:checked').value;
	if (getEID(namespace + 'miscAdhocFeesId').value.trim() == ""
		 && getEID(namespace + 'feeSchemeId').value.trim() == "") {
		eValid = false;
		_displayMessage('danger', "No misc fees added", 3000);
	} else if (receiptFor == "Candidate" && getEID(namespace + 'candidateId').value.trim() == "") {
		eValid = false;
		_displayMessage('danger', "Candidate is Mandatory", 3000);
	} else {
		var adhocFeeTable = document.getElementById("adhocFeesTableId");
		if(adhocFeeTable.offsetParent !== null) {
		var rows =  adhocFeeTable.rows;
		for( var i=1;i<rows.length-1; i++){
			if(rows[i].className.includes("adhocFeesContainerRow")){
				var description = rows[i].cells[1].getElementsByTagName("input")[0].value;
				var taxable = rows[i].cells[2].getElementsByTagName("select")[0].value;
				var unitPrice = rows[i].cells[3].getElementsByTagName("input")[0].value;
				var quantity = rows[i].cells[4].getElementsByTagName("input")[0].value;
				var amount = rows[i].cells[5].getElementsByTagName("input")[0].value;
				if (!description || description.trim() == '') {
					eValid = false;
					_displayMessage('danger', "Description is Mandatory", 3000);
					break;
				}
				if (!taxable || taxable.trim() == '') {
					eValid = false;
					_displayMessage('danger', "Taxable is Mandatory", 3000);
					break;
				}
				if (!unitPrice || unitPrice.trim() == '') {
					eValid = false;
					_displayMessage('danger', "Unit Price is Mandatory", 3000);
					break;
				}
				if (!quantity || quantity.trim() == '') {
					eValid = false;
					_displayMessage('danger', "Quantity is Mandatory", 3000);
					break;
				}
				if (!amount || amount.trim() == '') {
					eValid = false;
					_displayMessage('danger', "Amount is Mandatory", 3000);
					break;
				}else if(amount <= 0){
					eValid = false;
					_displayMessage('danger', "Amount can not be 0 or less than 0", 3000);
					break;
				}
			}
		}
		}
		
		var schemeTable = document.getElementById("feeSchemeTableId");
		if(schemeTable.offsetParent !== null) {
			rows =  schemeTable.rows;
			for( var ctr=1;ctr<rows.length; ctr++){
				if(rows[ctr].className.includes("feeSchemeContainerRow")){
					var qty = rows[ctr].cells[4].getElementsByTagName("input")[0].value;
					if (!qty || qty.trim() == '') {
						eValid = false;
						_displayMessage('danger', "Quantity is Mandatory", 3000);
						break;
					}else if(qty <=0){
						eValid = false;
						_displayMessage('danger', "Quantity can not be 0 or less than 0", 3000);
						break;
					}
				}
			}
		}
	}
	
	return eValid;
}

function getInvoiceModel(receiptFor){
	var mainInv = {};
	var invoicing = {};
	invoicing.CreditTerm=0;
	invoicing.DueDate= getDateByFormat(new Date());
	invoicing.Currency="SGD";
	invoicing.Description="misc fees";
	invoicing.TransactionDetails = [];
	invoicing.SourceType=sourceTypeMap['MS'];
	if(mode=="edit") {
		invoicing.formStorageId = formStorageId;
	} else {
		invoicing.ProductType=productMap['Exam'];
		invoicing.ProductSubType= productSubtypeMap['SAC'];
		invoicing.FunctionalComponent="F";
		invoicing.Currency="SGD";
		invoicing.CategoryType=categoryMap['IN'];
		invoicing.Type=clientTypeMap['Individual'];
		var idt = getDateByFormat(new Date());
		invoicing.TxnDate=idt;
		invoicing.Source="MiscFee";
		invoicing.TxnType=transactionTypeMap['Invoice'];
		invoicing.Title="Title";
		invoicing.ApprovalStatus="Approved";
		invoicing.RequestType="New Invoice";
		invoicing.TransactionStatus="Confirmed";
	}
	
	var user_id = userId;
	if(receiptFor == 'Candidate'){
		var candidate = document.getElementById(namespace + "candidateId").value;
		user_id = candidate;
	} else {
		user_id = 0;
	}
	
	for(var adhocKey in adhocFeeList){
		var adhocSubSchemeList = adhocFeeMap[adhocFeeList[adhocKey]];
		for(var adhocSubSchemeKey in adhocSubSchemeList){
			var adhocFee = adhocSubSchemeList[adhocSubSchemeKey];
			if(adhocFee.deleteStatus != "Removed") {
				var adhocDetail = {
				        "title":adhocFee.title,
				        "description":adhocFee.description,
				        "amountType": adhocFeeList[adhocKey],
				        "currency": invoicing.Currency,
				        "baseCurrency": baseCurrency ? baseCurrency : "SGD",
				        "quantity": adhocFee.quantity,
				        "unitPrice" :adhocFee.unitPrice,
				        "amount": (parseFloat(adhocFee.unitPrice) * parseFloat(adhocFee.quantity)),
				        "userId": user_id,
				        "taxable": adhocFee.taxable,
				        "tax": adhocFee.tax,
				        "taxCode": taxObj.TaxCode
				};
				invoicing.TransactionDetails.push(adhocDetail);
			}
		}
	}
	
	for(var schemeKey in feeSchemeList){
		var feeSubSchemeList = feeSchemeMap[feeSchemeList[schemeKey]];
		for(var subSchemeKey in feeSubSchemeList){
			var feeScheme = feeSubSchemeList[subSchemeKey];
			if(feeScheme.deleteStatus != "Removed") {
				var schemeDetail = {
				        "title":feeScheme.title,
				        "description":feeScheme.description,
				        "amountType": feeSchemeList[schemeKey],
				        "currency": invoicing.Currency,
				        "baseCurrency": baseCurrency ? baseCurrency : "SGD",
				        "quantity": feeScheme.quantity,
				        "unitPrice" :feeScheme.unitPrice,
				        "amount": (parseFloat(feeScheme.unitPrice) * parseFloat(feeScheme.quantity)),
				        "userId": user_id,
				        "taxable": feeScheme.taxable,
				        "tax": feeScheme.tax,
				        "taxCode": taxObj.TaxCode
				};
				invoicing.TransactionDetails.push(schemeDetail);
			}
		}
	}
	mainInv.contentJson = invoicing;
	return mainInv;
}

function loadDropdowns(callback) {
	getCandidateList(function(){
		candidateList = true;
		callback();
	});
	
	getFeeSchemeList(function(){
		pssList = true;
		callback();
	});
	
	loadCommonDropdownData("miscAdhocFeesId", miscFeeList, function(){
		mafLoaded = true;
		callback();
	});
}


function getCandidateList(callback){
	var datas = {};
	datas.formStorageId = formStorageId;
	datas.formType = "candidate";
	datas.conditions = ["contentJson.Status=Active","size="+2147483647];
	ajaxCallAPI(
			'GET',
			"searchList",
			datas,
			function(response) {
				datas = this.get("responseData").content;
				loadCommonDropdownData("candidateId", datas, function(){
					callback();
				});
			}, function() {
				showLoading(false);
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

function loadCommonDropdownData(dropdownId, valueList, callback) {
	var elementDrpDwn = getEID(namespace + dropdownId);
	loadCommonDropdownDataToElement(dropdownId, elementDrpDwn, valueList, callback);
}

function loadCommonDropdownDataToElement(dropdownId, elementDrpDwn, valueList, callback) {
	for(var i=0; i<valueList.length; i++) {
		var val = valueList[i];
		var opt = null;
		if(dropdownId == 'candidateId'){
			opt = new Option(val.firstName +' '+ val.lastName, val.storageId);
			candidateMap[val.storageId] = val.firstName +' '+ val.lastName;
		}
		if(dropdownId == 'miscAdhocFeesId'){
			opt = new Option(val.displayName, val.itemValue);
			var subSchemeList = [{
				title: val.displayName,
				description: "",
				taxable: true,
				unitPrice: 0,
				quantity: 1,
				amount: 0,
				deleteStatus: ""
			}];
			adhocFeeMap[val.itemValue] = subSchemeList;
		}
		elementDrpDwn.options[elementDrpDwn.options.length] = opt;
	}
	callback();
}

function setMiscFees(){
	var selectElmt = adhocFeesDiv;
	 for (var i = 0; i < selectElmt.length; i++) {
    	var val = selectElmt.options[i].value;
    	if(adhocFeeSelectedMap[val]){
    		selectElmt.options[i].selected = true;
    	}
    }
}

function getEID(id) {
	return document.getElementById(id);
}

function showLoading(show) {
	if(show) {
		getEID("loadingDiv").style.display = "block";
	} else {
		getEID("loadingDiv").style.display = "none";
	}
}
