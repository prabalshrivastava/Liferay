var bankNameList = [];
var currencyList = [];
var bankLoaded = false;
var currencyLoaded = false;
var taxLoaded = false;
var baseCurrency = "SGD";
var taxRate = 0;
var screen;
var clientType;
var selectedNames;
var formStorageId;
var notes;
var holdReceipt;
function showPaymentSection(formStorageId) {
	if(modelName === "invigilatorAttendance"){
		document.getElementById(namespace + "eligibility").style.display = "inline";
		document.getElementById("isEligible").style.display = "inline";
		document.getElementById("isEligible").style.opacity = "1";
	}
	filter = {};
	Object.keys(filterStoreData).forEach(function(key){
		debugger
		if (filterStoreData[key] != "" && typeof( filterStoreData[key]) == "object" && filterStoreData[key].length > 0){
			filter[key] = filterStoreData[key];
		}
   });
	filterData = encodeURI(JSON.stringify(filter));
  console.log(filterData);
	storageId = formStorageId;
	this.screen = screen;
	loadDropdownData(function() {
		document.getElementById("slider").style.display = "inherit";
		setTimeout(function(){ document.getElementById("slider").style.height = "200px" }, 100);
		
		document.getElementById("loadingDiv").style.display = "inline";
		
		document.getElementById("updateButton").style.display = "none";
		document.getElementById("cancelButton").style.display = "none";
		document.getElementById("saveButton").style.display = "none";
		document.getElementById("saveSuccess").style.display = 'none';
		document.getElementById("saveError").style.display = 'none';
		
		document.getElementById("timeInHHErr").innerHTML = "";
		document.getElementById("timeOutHHErr").innerHTML = "";
		document.getElementById("timeInMMErr").innerHTML = "";
		document.getElementById("timeOutMMErr").innerHTML = "";
		
		debugger;
		document.getElementById(namespace + "timeInHH").style.borderColor = '#b1bed7';
		document.getElementById(namespace + "timeInMM").style.borderColor = '#b1bed7';
		document.getElementById(namespace + "timeOutHH").style.borderColor = '#b1bed7';
		document.getElementById(namespace + "timeOutMM").style.borderColor = '#b1bed7';

		
		document.getElementById(namespace + "timeOutMM").value = "";
		document.getElementById(namespace + "timeOutHH").value = "";
		document.getElementById(namespace + "timeInMM").value = "";
		document.getElementById(namespace + "timeInHH").value = "";
		
		debugger;
		if(formStorageId == null){
			document.getElementById("cancelButton").style.display = "inline";
			document.getElementById("saveButton").style.display = "inline";
			document.getElementById("loadingDiv").style.display = "none";
		}else{
		ajaxCallAPI(
				'GET',
				'fetchById',
				formStorageId,
				function() {
					debugger;
					var data = this.get("responseData");
					if (data != null) {
						if(document.getElementById("isEligible")){
						document.getElementById("isEligible").checked = (data.contentJson.IsPaymentEligible) ? false
								: true;}
						if (data.timeIn != null) {
							var timeIn = data.timeIn;
							var inTime = timeIn.split(":");
							document.getElementById(namespace + "timeInHH").value = inTime[0];
							document.getElementById(namespace + "timeInMM").value = inTime[1];
							document.getElementById(namespace + "timeInHH").disabled = document
									.getElementById(namespace + "timeInHH").value ? true
									: false;

							document.getElementById(namespace + "timeInMM").disabled = document
									.getElementById(namespace + "timeInMM").value ? true
									: false;
						}

						if (data.timeOut) {
							var timeOut = data.timeOut;
							var outTime = timeOut.split(":");
							document.getElementById(namespace + "timeOutHH").value = outTime[0];
							document.getElementById(namespace + "timeOutMM").value = outTime[1];

							document.getElementById(namespace + "timeOutHH").disabled = document
									.getElementById(namespace + "timeOutHH").value ? true
									: false;

							document.getElementById(namespace + "timeOutMM").disabled = document
									.getElementById(namespace + "timeOutMM").value ? true
									: false;
						}
						document.getElementById("remarks").value = data.remark
						if (data.error) {
							displayMessage('danger', data.error, 3000);
						}
						timeInHH=document.getElementById(namespace + "timeInHH").value;
						timeInMM=document.getElementById(namespace + "timeInMM").value;
						timeOutHH=document.getElementById(namespace + "timeOutHH").value;
						timeOutMM=document.getElementById(namespace + "timeOutMM").value;
						var remarks=document.getElementById("remarks").value;
						if(timeInHH !="" && timeInMM != "" && timeOutHH != "" && timeOutMM != ""){
							document.getElementById("remarks").disabled = true;
							document.getElementById("saveButton").style.display = 'inline';
							document.getElementById("cancelButton").style.display = 'inline';
							document.getElementById("saveButton").disabled = true;
						}else if(timeInHH =="" && timeInMM == "" && timeOutHH == "" && timeOutMM == "" && remarks == ""){
							document.getElementById("saveButton").style.display = 'inline';
							document.getElementById("cancelButton").style.display = 'inline';
						}else{
							document.getElementById("updateButton").style.display = 'inline';
							document.getElementById("cancelButton").style.display = 'inline';
						}
						document.getElementById("loadingDiv").style.display = "none";
					}
				}, function() {
				});
		}
	});
}
function closeSlider()
{
    if(savedSuccessfully){
    	window.location.reload();
    }
	setTimeout(function(){ document.getElementById("slider").style.height = "0px" }, 100);
	setTimeout(function(){ document.getElementById("slider").style.display = "none"; }, 600);
 
}

function loadDropdownData(callback) {
	callback();

}