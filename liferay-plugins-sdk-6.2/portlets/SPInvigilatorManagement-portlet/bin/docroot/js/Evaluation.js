function isEvaluated(){
	document.getElementById("hidepoten").style.display= "block";
	var invigilatorCode = document.getElementById("invigilator").value;
	for(var i = 0; i < leadInvigilators.length ; i++){
		if(leadInvigilators[i].userId == invigilatorCode){
			potentialtobeLeadRole.checked = false;
			document.getElementById("hidepoten").style.display= "none";
		}
	}
	if(userId == invigilatorCode){
		alert("Cannot do evaluation for Self");
		return false;
	}
	if(mode == create){
		var invigilatorData = {};
		invigilatorData.limit = 10;
		invigilatorData.page = 0;
		invigilatorData.formType = "ManageEvaluation";
		var filter = {};
		var filterdata = [];
		var scheduleCode = document.getElementById("schedule").value;
		
		filter["contentJson.ScheduleCode"] = [scheduleCode];
		filter["contentJson.InvigilatorCode"] = [invigilatorCode];
		filterdata.push(filter);
		invigilatorData.filterdata = filterdata;
		ajaxCallAPI('GET', 'elastiSearchList', invigilatorData, function () {
			var response = this.get("responseData");
			if (_.isEmpty(response)) {
				console.log("error");
			} else {
				if(response.content.length > 0){
					alert("Already Evaluated");
					document.getElementById("invigilator").value = "Pick one";
				}
			}
			
		}, function () {});
	}
	
	
}