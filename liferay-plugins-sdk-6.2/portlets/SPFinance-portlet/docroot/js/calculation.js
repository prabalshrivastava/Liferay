function calculateFeeFnct(isDetailRequired, miscFeeSelectedMap){
	calculateFeeFnct(isDetailRequired, miscFeeSelectedMap, 1);
}

function calculateFeeFnct(isDetailRequired, miscFeeSelectedMap, exchRate) {
	var amount = 0;
	var gst = 0;
	for(var key in miscFeeSelectedMap){
		if(key && miscFeeSelectedMap[key] && (miscFeeSelectedMap[key] != null)){
			var miscFeeTable = miscFeeSelectedMap[key];
			  if (miscFeeTable.deleteStatus != "Remove") {
				  miscFeeTable.gst = 0;
				  if(miscFeeTable.amount){
					  amount = amount + parseFloat(miscFeeTable.amount);
					  if(miscFeeTable.taxable == 'Yes'){
						  miscFeeTable.tax = calculateGst(miscFeeTable.amount);
						  gst = gst + (miscFeeTable.tax * exchRate);
					  }
				  }
			  }
			  miscFeeSelectedMap[key] = miscFeeTable;
		}
	}
	console.log("amount : "+amount);
	console.log("gst : "+gst);
	if(isDetailRequired){
		setDetail((amount*exchRate),gst);		
		document.getElementById("previewBtnId").disabled = false;
		document.getElementById("generateInvoiceBtnId").disabled = false;
	}
}

function setDetail(amount, gst){
	var total = round((parseFloat(amount) + parseFloat(gst)),2);
	document.getElementById('totalFee').textContent  = "";
	document.getElementById('totalFee').textContent = "$" + round(parseFloat(amount),2).toFixed(2);
	
	document.getElementById('totalGST').textContent  = "";
	document.getElementById('totalGST').textContent = "$" + round(parseFloat(gst),2).toFixed(2);
	
	document.getElementById('totalInvoiceAmount').textContent  = "";
	document.getElementById('totalInvoiceAmount').textContent = "$" + round(total,2).toFixed(2);
}

function calculateGst(unitPrice) {
	var taxRate = 0
	if(!taxObj || taxObj != null){
		taxRate = parseFloat(taxObj.Percentage);
	}
	var p =(unitPrice * taxRate)/100;
	return p;
}
