var assignMarkerData = { "green":{storageId: "green", markerName: "Available Seats", markerIdentifier: "color", markerColor: "Green", status:"Active"}, "grey":{storageId: "grey", markerName: "Unavailable Seats", markerIdentifier: "color", markerColor: "Grey", status:"Active"}, "yellow":{storageId: "yellow", markerName: "First Seat", markerIdentifier: "color", markerColor: "Yellow", status:"Active"}};
var usedAssigMarkers = [];
var seatingPlanLayout = {};
var colorGreen = "green";
var greenHashCode = "#8bdb7c";
var reservedColors = {"green":true, "#8bdb7c":true, "gray":true, "grey":true, "yellow":true}
var spliIdModel = "";
var seatingPlanScreenId = "0";
var SeatPlanStatus = "Unknown";
var snd = "down", deskFormat = "001", ist = 0;
var SPInstance = {};
var subjects = {};
var subjectUsed = {};
var subNo = 1;
var subjectArr = [];
var layoutParameters = {};
var seatLayoutId;
var allAssignSeats = [];
var seatingPlanInstance = {};
var seatingPlanInstanceChanges = {};
var subjectWiseObject = {};
var subjectWiseCandidate = {};
var gAction = "";
var otherDetails = {};
//seating Assign 

var allowOverrideAutoAssign, isAutoAssignSeatToCandidate;
var userSeatAssign = {"candidate":{}, "invisilator":{}};
var subjectWiseCandidates = {};
var enrolledBySchedule = {};
var allCandidates = [];
var remainCand = [];
var assignCand =[];
var currentSeatingPlan = {};

var subjectWiseObject = {};
var subjectWiseCandidate = {};
var candidateIds = [];
var candidateDetails = {};
var currentPanel="";
var invigilatorList = {};
var popoverState = false;
var scheduleDetail = {};
//var filteredSubjectWiseCandidates = {};
var assignedInvisilators={};
var prevAssignData = {};

function cDataUserAssignSeats(UserSeatAssignId, UserId, UserType, AssignSeatId,
		SeatingPlanInstanceId, SubjectId, sessionScheduleId, enrolmentId, candidateDetail) {
	var cData = {
		UserSeatAssignId : UserSeatAssignId,
		UserId : UserId,
		UserType : UserType,
		AssignSeatId : AssignSeatId,
		SeatingPlanInstanceId : SeatingPlanInstanceId,
		SubjectId : SubjectId,
		sessionScheduleId : sessionScheduleId,
		enrolmentId : enrolmentId,
		candidateDetail : JSON.stringify(candidateDetail)
	}
	return cData;
}

function cDataAssignSeats(seatId, SeatingPlanInstanceId, SeatingPlanLayoutParameterId, SubjectId, Row, Column, DeskNo, UserAssignSeats) {
	var cData = {
		seatId : seatId,
		SeatingPlanInstanceId : SeatingPlanInstanceId,
		SeatingPlanLayoutParameterId : SeatingPlanLayoutParameterId,
		SubjectId : SubjectId,
		Row : Row,
		Column : Column,
		DeskNo : DeskNo,
		UserAssignSeats : UserAssignSeats
	}
	return cData;
}

function cDataSeatingPlanLayoutParameters(SeatingPlanLayoutParametersId, SeatingPlanInstanceId, SeatLayoutId, SubjectId, SeatsReq, NoRowGap, NoSeatGap, assignSeats) {
	var cData = {
		SeatingPlanLayoutParametersId : SeatingPlanLayoutParametersId,
		SeatingPlanInstanceId: SeatingPlanInstanceId,
		SeatLayoutId : SeatLayoutId,
		SubjectId : SubjectId,
		SeatsReq : SeatsReq,
		NoRowGap : NoRowGap,
		NoSeatGap : NoSeatGap,
		assignSeats : assignSeats
	}
	return cData;
}

function cDataSeatingPlanLayouts(SeatingPlanInstanceId, SeatingPlanLayoutId, FromRow, ToRow, FromCol, ToCol, SeatNoDirection, IsTemplate, AssignMarker, AssignMarkerContent, seatingPlanLayoutParameters) {
	var cData = {
		SeatingPlanInstanceId : SeatingPlanInstanceId,
		SeatingPlanLayoutId : SeatingPlanLayoutId,
		FromRow : FromRow,
		ToRow : ToRow,
		FromCol : FromCol,
		ToCol : ToCol,
		SeatNoDirection : SeatNoDirection,
		IsTemplate : IsTemplate,
		AssignMarker : AssignMarker,
		AssignMarkerContent : AssignMarkerContent,
		seatingPlanLayoutParameters : seatingPlanLayoutParameters
	}
	return cData;
}

function saveSeatingPlanInstance(){
	showLoading(true);
	var seatingPlanLayoutArr = [];
	for(spl in seatingPlanLayout){
		seatingPlanLayout[spl]["SeatNoDirection"] = snd;
		var s = seatingPlanLayout[spl];
		var seatingPlanLayoutParameters= [];
		if(seatingPlanLayout[spl]["SeatingPlanLayoutId"] == seatLayoutId){
			for(k in layoutParameters){
				var lp = layoutParameters[k];
				var allSeats = [];
				$("[subjectid='" + lp.SubjectId + "']").each(function() {
					var sp = $(this).parent();
					var seat = generateSeats(lp.SeatingPlanLayoutParametersId,lp.SubjectId, sp.attr("row"), sp.attr("col"), $(this).attr("deskNo"));
					var usa = [];
					if($(this).attr("candid") != undefined){
						var candId = $(this).attr("candid");
						var usaId = seat.seatId + "_" + candId + "_" + "0";
						usa.push(cDataUserAssignSeats(usaId, candId, "0", seat.seatId, seat.SeatingPlanInstanceId, lp.SubjectId, seatingPlanInstance.ScheduleId, candidateDetails[candId]["enrolmentId"], candidateDetails[candId]));
					}
					if($(this).attr("invsid") != undefined){
						var usaId = seat.seatId + "_" + $(this).attr("invsid") + "_" + "1";
						usa.push(cDataUserAssignSeats(usaId, $(this).attr("invsid"), "1", seat.seatId, seat.SeatingPlanInstanceId, lp.SubjectId, seatingPlanInstance.ScheduleId, "", {}));
					}
					seat["UserAssignSeats"] = usa;
					var prefix = seatingPlanInstance.hasOwnProperty("DeskNoFormat")?seatingPlanInstance.DeskNoFormat:"";
					allSeats.push(cDataAssignSeats(seat.seatId, seat.SeatingPlanInstanceId, seat.SeatingPlanLayoutParameterId, seat.SubjectId, seat.Row, seat.Column, (prefix+seat.DeskNo), seat.UserAssignSeats));
				});
				layoutParameters[lp.SubjectId]["assignSeats"] = allSeats;
				seatingPlanLayoutParameters.push(cDataSeatingPlanLayoutParameters(lp.SeatingPlanLayoutParametersId, s.SeatingPlanInstanceId, lp.SeatingPlanLayoutParametersId, lp.SubjectId, lp.SeatsReq, lp.NoRowGap, lp.NoSeatGap, lp.assignSeats));
			}
		}
		seatingPlanLayout[spl]["seatingPlanLayoutParameters"] = seatingPlanLayoutParameters;
		seatingPlanLayoutArr.push(cDataSeatingPlanLayouts(s.SeatingPlanInstanceId, s.SeatingPlanLayoutId, s.FromRow, s.ToRow, s.FromCol, s.ToCol, snd, s.IsTemplate, s.AssignMarker, assignMarkerData[s.AssignMarker], s.seatingPlanLayoutParameters));
	}
	seatingPlanInstance["seatingPlanLayouts"] = seatingPlanLayoutArr;
	seatingPlanInstance.formType = "seatingplaninstance";
	seatingPlanInstance.formStorageId = seatingPlanInstance.SeatingPlanInstanceId;
	seatingPlanInstance["otherDetails"] = otherDetails;
	ajaxCallAPI('POST', 'persist', seatingPlanInstance, function() {
		showLoading(false);
		var data = this.get("responseData");
		console.log(data);
		actionDialogue(gAction);
	}, function() {
		showLoading(false);
	});
}


function getEID(element) {
	return document.getElementById(element);
}

function showLoading(show) {
	if(show) {
		getEID("loadingDiv").style.display = "block";
	} else {
		getEID("loadingDiv").style.display = "none";
	}
}

function loadAssignMarkers() {
	var filter = {};
	filter.conditions = [ "contentJson.Status=Active", "size="+2147483647 ];
	filter.formType = "assignmarker";
	ajaxCallAPI('GET', "searchList", filter, function() {
		var AMData = this.get("responseData");
		if (AMData.error) {
			displayMessage('danger', AMData.error, 3000);
		} else {
			for (var i = 0; i < AMData.content.length; i++) {
				var am = AMData.content[i];
				if(typeof am == "object" && am.hasOwnProperty("storageId") && !assignMarkerData.hasOwnProperty(am.storageId)){
					prepareAssignMarkers(am);
				}
			}
		}
	}, function() {
		displayMessage('danger', "System unable to load layout markers", 3000);
	});
}

function prepareAssignMarkers(am){
		if(am.hasOwnProperty("createdDate")){
			delete am.createdDate;
		}
		if(am.hasOwnProperty("lastModifiedDate")){
			delete am.lastModifiedDate;
		}
		var htmlOptions = "";
		var styleMarker = "<style id='style-tag-"+am.storageId+"'>";
		if(am.markerIdentifier == "color" && !reservedColors.hasOwnProperty( am.markerColor.toLowerCase())){
			htmlOptions = htmlOptions + "<option value='" + (am.storageId) + "'>" + am.markerName + "</option>";
			styleMarker = styleMarker + " span[assignmarker='"+am.storageId+"']{ background-color: "+am.markerColor.toLowerCase()+";} ";
			assignMarkerData[am.storageId] = am;
		}
		else if(am.markerIdentifier == "icon" && am.hasOwnProperty("storageId")){
			htmlOptions = htmlOptions + "<option value='" + (am.storageId) + "'>" + am.markerName + "</option>";
			var imageURL = "";
			if(am.hasOwnProperty("contentJson") && am.contentJson.hasOwnProperty("UploadImage") && am.contentJson.UploadImage.length >0){
				imageURL = am.contentJson.UploadImage[0].url;
			}
			styleMarker = styleMarker + " span[assignmarker='"+am.storageId+"']{ background-image: url('"+imageURL+"');} ";
			assignMarkerData[am.storageId] = am;
		}
		styleMarker = styleMarker + "</style>";
		$("#assignMarker").append(htmlOptions);
		if(!reservedColors.hasOwnProperty( am.markerColor.toLowerCase())){
			$("#load-assign-marker-style-tag").prepend(styleMarker);
		}
}

function showAllAssignMarkers() {
	var htmlContent = "<div class='row-fluid assign-marker-row'>";
	var htmlBottom = '';
	for (var i = 0; i < usedAssigMarkers.length; i++) {
		htmlContent = htmlContent
				+ "<div class='assign-marker-label span6'><div style='display:inline-block;width:80%;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;'><div class='assign-marker-round' style='background:"
				+ assignMarkerData[usedAssigMarkers[i]].markerColor.toLowerCase() + "'></div>"
				+ assignMarkerData[usedAssigMarkers[i]].markerName + "</div><div align='right' style='display:inline-block;width:15%;top: -5px;position: relative;' onclick=\"removeAssignMarker('"+usedAssigMarkers[i]+"')\" ><i class='fa fa-times'></i></div></div>";
		if (i % 2 != 0 && i < (usedAssigMarkers.length - 1)) {
			htmlContent = htmlContent
					+ "</div><div class='row-fluid assign-marker-row'>";
		}
		htmlBottom = htmlBottom
				+ '<div class="assignmarker-label-bottom"><div class="assign-marker-round" style="background:'
				+ assignMarkerData[usedAssigMarkers[i]].markerColor.toLowerCase() + '" ></div>'
				+ assignMarkerData[usedAssigMarkers[i]].markerName + ' </div>';
	}
	htmlContent = htmlContent + "</div>";
	$("#viewAllAssignMarkers").html(htmlContent);
	$("#totalAvailableSeats").html($("[assignmarker="+colorGreen+"]").length);
	$("#assignMarkerBottom").html(htmlBottom);
}

function loadAssignMarkerToSeat(fRow, tRow, fCol, tCol, markerStorageId) {

	fRow = parseInt(fRow);
	tRow = parseInt(tRow);
	fCol = parseInt(fCol);
	tCol = parseInt(tCol);
	for (var i = fCol; i <= tCol; i++) {
		for (var j = fRow; j <= tRow; j++) {
			$("#seatTD_" + i + "_" + j + " .actualSeat").attr("assignmarker",
					markerStorageId)
		}
	}

	if (usedAssigMarkers.indexOf(markerStorageId) == -1) {
		usedAssigMarkers.push(markerStorageId);
		showAllAssignMarkers();
	}

	$("#totalAvailableSeats").html($("[assignmarker="+colorGreen+"]").length);
}

function removeAssignMarker(markerStorageId){
	if (usedAssigMarkers.indexOf(markerStorageId) > -1) {
		usedAssigMarkers.splice(usedAssigMarkers.indexOf(markerStorageId), 1);
	}
	$("span[assignmarker='"+markerStorageId+"']").removeAttr("assignmarker");
	showAllAssignMarkers();
	for(var k in seatingPlanLayout){
		var sl = seatingPlanLayout[k];
		if(sl.hasOwnProperty("AssignMarker") && sl.AssignMarker==markerStorageId){
			delete seatingPlanLayout[k];
		}
	}
	if(assignMarkerData[markerStorageId].markerColor.toLowerCase()==colorGreen){
		$(".deskNo").each(function(){  $(this).html("R"+$(this).parent().attr("row")+" C"+$(this).parent().attr("col")) });
		$("#totalAvailableSeats").html(0);
	}
}

function changeAssignMarker(element) {
	if ($(".ui-selected").length <= 0) {
		return false;
	}
	assignMarkerToSeat(element.value);
	if (usedAssigMarkers.indexOf(element.value) == -1) {
		usedAssigMarkers.push(element.value);
		showAllAssignMarkers();
	}
	element.value = "";
	$("#totalAvailableSeats").html($("[assignmarker="+colorGreen+"]").length);
}

function assignMarkerToSeat(color) {

	var fRow = $("#seatingSetup .ui-selected:first").parent().attr("row");
	var tRow = $("#seatingSetup .ui-selected:last").parent().attr("row");
	var fCol = $("#seatingSetup .ui-selected:first").parent().attr("col");
	var tCol = $("#seatingSetup .ui-selected:last").parent().attr("col");
	var selectedEle = $(".ui-selected").length;
	var rowDiff = (tRow - fRow) + 1;
	var colDiff = (tCol - fCol) + 1;
	var mulColRow = rowDiff * colDiff;

	if (selectedEle < mulColRow) {
		$(".ui-selected").each(
				function() {
					$(this).attr("assignMarker", color);
					var seat = $(this).parent();
					addSeatingPlanLayout(seat.attr("row"), seat.attr("row"),
							seat.attr("col"), seat.attr("col"), color);
				});
	} else {
		$(".ui-selected").each(function() {
			$(this).attr("assignmarker", color);
		});
		addSeatingPlanLayout(fRow, tRow, fCol, tCol, color);
	}
	unselectAll();
	$("#totalAvailableSeats").html($("[assignmarker="+colorGreen+"]").length);
}

function provideDeskNo(len){
	var curDeskNo = 1;
	for(var i=1; i<=len; i++){
		if($("span[cur_deskno='"+i+"']").attr("assignmarker")==colorGreen){
			var prefix = seatingPlanInstance.hasOwnProperty("DeskNoFormat")?seatingPlanInstance.DeskNoFormat:"";
			$("span[cur_deskno='"+i+"']").parent().children(".deskNo").html(prefix+curDeskNo);
			$("span[cur_deskno='"+i+"']").attr("deskno",curDeskNo);
			curDeskNo++;
		}
		else{
			$("span[cur_deskno='"+i+"']").parent().children(".deskNo").html("");
			$("span[cur_deskno='"+i+"']").removeAttr("deskno");
		}
	}
}

function unselectAll() {

	$(".ui-selected").each(function() {
		$(this).removeClass("ui-selected");
	});
	$(".ui-selecting").each(function() {
		$(this).removeClass("ui-selecting");
	});
}

function selectSeatByRowColumnRange(fromRow, toRow, fromCol, toCol) {
	for (var i = fromCol; i <= toCol; i++) {
		for (var j = fromRow; j <= toRow; j++) {
			$("#seatTD_" + i + "_" + j + " .actualSeat")
					.addClass("ui-selected");
		}
	}
	$("#assignMarker").attr('disabled', false);
}

function populateSeatSelectDropdown(no, id) {
	var htmlOptions = "<option value=''>Choose one</option>";
	for (var i = 1; i <= no; i++) {
		htmlOptions = htmlOptions + "<option value='" + i + "'>" + i
				+ "</option>";
	}
	$("#" + id).html(htmlOptions);
}

function selectSeats() {
	$("#columnRangeErrorText").html("");
	$("#rowRangeErrorText").html("");
	unselectAll();
	var fromRow = parseInt($("#fromRow").val());
	var toRow = parseInt($("#toRow").val());
	var fromCol = parseInt($("#fromColumn").val());
	var toCol = parseInt($("#toColumn").val());
	var isError = false;
	if (toCol < fromCol) {
		// alert("Column range is incorrect!");
		$("#columnRangeErrorText").html("Incorrect range of columns.");
		isError = true;
	}
	if (toRow < fromRow) {
		// alert("Row range is incorrect!");
		$("#rowRangeErrorText").html("Incorrect range of rows.");
		isError = true;
	}
	if (isError) {
		return false;
	}
	selectSeatByRowColumnRange(fromRow, toRow, fromCol, toCol)
}

function resetSeats(t) {
	$("#columnRangeErrorText").html("");
	$("#rowRangeErrorText").html("");
	$(".seatSelectByInput").val("");
	unselectAll();
}

function directionSeatNoUP(fromRow, toRow, fromCol, toCol, prefix) {
	var count = 1;
	var diff = toCol - (fromCol - 1);
	for (var i = fromCol; i <= toCol; i++) {
		var currentNo = count;
		for (var j = fromRow; j <= toRow; j++) {
			//$("#seatTD_" + i + "_" + j + " .deskNo").html(prefix + "" + currentNo);
			$("#seatTD_" + i + "_" + j + " .actualSeat").attr("cur_deskno",
					prefix + "" + currentNo);
			currentNo = currentNo + diff;
		}
		count++;
	}
}

function directionSeatNoUpward(fromRow, toRow, fromCol, toCol, prefix) {
	var count = 1;
	var diff = toCol - (fromCol - 1);
	var currentNo = diff;
	for (var i = fromCol; i <= toCol; i++) {
		for (var j = fromRow; j <= toRow; j++) {
			//$("#seatTD_" + i + "_" + j + " .deskNo").html(prefix + "" + currentNo);
			$("#seatTD_" + i + "_" + j + " .actualSeat").attr("cur_deskno",
					prefix + "" + currentNo);
			currentNo = currentNo + diff;
		}
		currentNo = diff - count;
		count++;
	}
}

function directionSeatNoLeft(fromRow, toRow, fromCol, toCol, prefix) {
	var count = 1;
	var diff = toCol - (fromCol - 1);
	for (var i = fromCol; i <= toCol; i++) {
		var currentNo = count;
		for (var j = fromRow; j <= toRow; j++) {
			//$("#seatTD_" + i + "_" + j + " .deskNo").html(prefix + "" + currentNo);
			$("#seatTD_" + i + "_" + j + " .actualSeat").attr("cur_deskno",
					prefix + "" + currentNo);
			currentNo++;
			count++;
		}
	}
}

function directionSeatNoRight(fromRow, toRow, fromCol, toCol, prefix) {
	var count = 1;
	var diff = toRow - (fromRow - 1);
	for (var i = fromCol; i <= toCol; i++) {
		var currentNo = diff*count;
		for (var j = fromRow; j <= toRow; j++) {
			//$("#seatTD_" + i + "_" + j + " .deskNo").html(prefix + "" + currentNo);
			$("#seatTD_" + i + "_" + j + " .actualSeat").attr("cur_deskno",
					prefix + "" + currentNo);
			currentNo--;
		}
		count++;
	}
}

function directionSeatNoLeftSnake(fromRow, toRow, fromCol, toCol, prefix) {
	var countL = 1;
	var countR = 1;
	var flagRev = true;
	var diff = toRow - (fromRow - 1);
	for (var i = fromCol; i <= toCol; i++) {
		if(flagRev){
			var currentNo = countL;
			for (var j = fromRow; j <= toRow; j++) {
				//$("#seatTD_" + i + "_" + j + " .deskNo").html(prefix + "" + currentNo);
				$("#seatTD_" + i + "_" + j + " .actualSeat").attr("cur_deskno",
					prefix + "" + currentNo);
				currentNo++;
				countL++;
			}
			flagRev=false;
		}
		else{
			var currentNo = diff*countR;
			for (var j = fromRow; j <= toRow; j++) {
				flagRev=false;
				//$("#seatTD_" + i + "_" + j + " .deskNo").html(prefix + "" + currentNo);
				$("#seatTD_" + i + "_" + j + " .actualSeat").attr("cur_deskno",
					prefix + "" + currentNo);
				currentNo--;
				countL++;
			}
			flagRev=true;
		}
		countR++;
	}
}

function directionSeatNoRightSnake(fromRow, toRow, fromCol, toCol, prefix) {
	var countL = 1;
	var countR = 1;
	var flagRev = false;
	var diff = toRow - (fromRow - 1);
	for (var i = fromCol; i <= toCol; i++) {
		if(flagRev){
			var currentNo = countL;
			for (var j = fromRow; j <= toRow; j++) {
				//$("#seatTD_" + i + "_" + j + " .deskNo").html(prefix + "" + currentNo);
				$("#seatTD_" + i + "_" + j + " .actualSeat").attr("cur_deskno",
					prefix + "" + currentNo);
				currentNo++;
				countL++;
			}
			flagRev=false;
		}
		else{
			var currentNo = diff*countR;
			for (var j = fromRow; j <= toRow; j++) {
				//$("#seatTD_" + i + "_" + j + " .deskNo").html(prefix + "" + currentNo);
				$("#seatTD_" + i + "_" + j + " .actualSeat").attr("cur_deskno",
					prefix + "" + currentNo);
				currentNo--;
				countL++;
			}
			flagRev=true;
		}
		countR++;
	}
}

function directionSeatNoDownward(fromRow, toRow, fromCol, toCol, prefix) {
	var count = 1;
	var diff = toCol - (fromCol - 1);
	for (var i = fromCol; i <= toCol; i++) {
		var currentNo = count;
		for (var j = fromRow; j <= toRow; j++) {
			//$("#seatTD_" + i + "_" + j + " .deskNo").html(prefix + "" + currentNo);
			$("#seatTD_" + i + "_" + j + " .actualSeat").attr("cur_deskno",
					prefix + "" + currentNo);
			currentNo = currentNo + diff;
		}
		count++;
	}
}

function directionSeatNoUpwardSnake(fromRow, toRow, fromCol, toCol, prefix) {
	var diff = toCol - (fromCol - 1);
	var countIn = 1;
	var countDec = (2 * diff) - 1;
	var currentNo = diff;
	var count = 1;
	for (var i = fromCol; i <= toCol; i++) {
		var switchFlag = true;
		for (var j = fromRow; j <= toRow; j++) {
			//$("#seatTD_" + i + "_" + j + " .deskNo").html(prefix + "" + currentNo);
			$("#seatTD_" + i + "_" + j + " .actualSeat").attr("cur_deskno",
					prefix + "" + currentNo);
			if (switchFlag) {
				currentNo = currentNo + countIn;
			} else {
				currentNo = currentNo + countDec;
			}
			switchFlag = (!switchFlag);

		}
		countIn = countIn + 2;
		countDec = countDec - 2;
		currentNo = diff - count;
		count++;
	}
}

function directionSeatNoDownwardSnake(fromRow, toRow, fromCol, toCol, prefix) {
	var diff = toCol - (fromCol - 1);
	var countIn = 1;
	var countDec = (2 * diff) - 1;
	var currentNo = 1;
	var count = 1;
	for (var i = fromCol; i <= toCol; i++) {
		var switchFlag = false;
		for (var j = fromRow; j <= toRow; j++) {
			//$("#seatTD_" + i + "_" + j + " .deskNo").html(prefix + "" + currentNo);
			$("#seatTD_" + i + "_" + j + " .actualSeat").attr("cur_deskno",
					prefix + "" + currentNo);
			if (switchFlag) {
				currentNo = currentNo + countIn;
			} else {
				currentNo = currentNo + countDec;
			}
			switchFlag = (!switchFlag);

		}
		countIn = countIn + 2;
		countDec = countDec - 2;
		count++;
		currentNo = count;
	}
}


function changeSeatNoDirection(t) {
	//$(".deskNo").html("");
	var prefix = "";
	
	var fromRow = 1;
	var toRow = parseInt(SPInstance.NoOfRows);
	var fromCol = 1;
	var toCol = parseInt(SPInstance.NoOfColumns);
	if (t.value == "down" || t.value == "upright") {
		directionSeatNoDownward(fromRow, toRow, fromCol, toCol, prefix);
	} else if (t.value == "downsnake" ) {
		if($($("[assignmarker='"+colorGreen+"']")[0]).parent().attr("row")%2==0){
			directionSeatNoUpwardSnake(fromRow, toRow, fromCol, toCol, prefix);
		}else{
			directionSeatNoDownwardSnake(fromRow, toRow, fromCol, toCol, prefix);
		}
	} else if ( t.value == "downsnakeright") {
		if($($("[assignmarker='"+colorGreen+"']")[$("[assignmarker='"+colorGreen+"']").length-1]).parent().attr("row")%2==0){
			directionSeatNoDownwardSnake(fromRow, toRow, fromCol, toCol, prefix);
		}else{
			directionSeatNoUpwardSnake(fromRow, toRow, fromCol, toCol, prefix);
		}
	} else if (t.value == "up" || t.value == "downright") {
		directionSeatNoUpward(fromRow, toRow, fromCol, toCol, prefix);
	} else if (t.value == "upsnake" ) {

		if($($("[assignmarker='"+colorGreen+"']")[0]).parent().attr("row")%2==0){
			directionSeatNoDownwardSnake(fromRow, toRow, fromCol, toCol, prefix);
		}else{
			directionSeatNoUpwardSnake(fromRow, toRow, fromCol, toCol, prefix);
		}
	} else if ( t.value == "upsnakeright") {

		if($($("[assignmarker='"+colorGreen+"']")[$("[assignmarker='"+colorGreen+"']").length-1]).parent().attr("row")%2==0){
			directionSeatNoUpwardSnake(fromRow, toRow, fromCol, toCol, prefix);
		}else{
			directionSeatNoDownwardSnake(fromRow, toRow, fromCol, toCol, prefix);
		}
	}
	else if (t.value == "left" || t.value == "rightdown") {
		directionSeatNoLeft(fromRow, toRow, fromCol, toCol, prefix);
	}
	else if (t.value == "right" || t.value == "leftdown") {
		directionSeatNoRight(fromRow, toRow, fromCol, toCol, prefix);
	}
	else if (t.value == "leftsnake" ) {
		if($($("[assignmarker='"+colorGreen+"']")[0]).parent().attr("col")%2==0){
			directionSeatNoRightSnake(fromRow, toRow, fromCol, toCol, prefix);
		}else{
			directionSeatNoLeftSnake(fromRow, toRow, fromCol, toCol, prefix);
		}
	}
	else if (t.value == "leftsnakedown") {
		if($($("[assignmarker='"+colorGreen+"']")[$("[assignmarker='"+colorGreen+"']").length-1]).parent().attr("col")%2==0){
			directionSeatNoLeftSnake(fromRow, toRow, fromCol, toCol, prefix);
		}else{
			directionSeatNoRightSnake(fromRow, toRow, fromCol, toCol, prefix);
		}
	}
	else if (t.value == "rightsnake" ) {
		if($($("[assignmarker='"+colorGreen+"']")[0]).parent().attr("col")%2==0){
			directionSeatNoLeftSnake(fromRow, toRow, fromCol, toCol, prefix);
		}else{
			directionSeatNoRightSnake(fromRow, toRow, fromCol, toCol, prefix);
		}
	}
	else if (t.value == "rightsnakedown") {
		if($($("[assignmarker='"+colorGreen+"']")[$("[assignmarker='"+colorGreen+"']").length-1]).parent().attr("col")%2==0){
			directionSeatNoRightSnake(fromRow, toRow, fromCol, toCol, prefix);
		}else{
			directionSeatNoLeftSnake(fromRow, toRow, fromCol, toCol, prefix);
		}
	}
	snd = t.value;
	
}

function generateSeats(splpId, subId, row, col, deskNo) {
	var thisSeat = {
		"SeatingPlanInstanceId" : spliId,
		"SeatingPlanLayoutParameterId" : splpId,
		"SubjectId" : subId
	};
	thisSeat["seatId"] = splpId + "_" + row + "_" + col + "_" + deskNo;
	thisSeat["Row"] = row
	thisSeat["Column"] = col
	thisSeat["DeskNo"] = deskNo;
	thisSeat.formType = "assignseat";
	return thisSeat;
}

function generateSeatsModel(splpId, subId, row, col, deskNo) {
	var thisSeat = {
		"seatingPlanInstanceId" : spliId,
		"seatingPlanLayoutParameterId" : splpId,
		"subjectId" : subId
	};
	thisSeat["seatId"] = spliId + "_" + splpId + "_" + row + "_" + col;
	thisSeat["noRow"] = row
	thisSeat["noColumn"] = col
	thisSeat["deskNo"] = deskNo;
	thisSeat.formType = "assignseat";
	return thisSeat;
}

function populateLayoutParameters(){
	for(var s in seatingPlanLayout){
		if(s != undefined && s !=""){
			var spl = seatingPlanLayout[s];
			if(spl.hasOwnProperty("seatingPlanLayoutParameters") && spl.seatingPlanLayoutParameters.length>0){
				for(var k=0;k<spl.seatingPlanLayoutParameters.length;k++){
					addNewSubject();
					$("#subjectDrop"+(k+1)).val(spl.seatingPlanLayoutParameters[k]["SubjectId"]);
					$("#seatsRequired"+(k+1)).val(spl.seatingPlanLayoutParameters[k]["SeatsReq"]);
					changeSubject(document.getElementById("subjectDrop"+(k+1)));
					//$("#noEnrolled" + (k+1)).val(spl.seatingPlanLayoutParameters[k]["assignSeats"].length);
					if(parseInt(spl.seatingPlanLayoutParameters[k]["NoRowGap"]) > parseInt(spl.seatingPlanLayoutParameters[k]["NoSeatGap"])){
						$("#subjectGap"+(k+1)).val("rowgap");
						$("#noSeatOrRowGap"+(k+1)).val(spl.seatingPlanLayoutParameters[k]["NoRowGap"]);
					}else if(parseInt(spl.seatingPlanLayoutParameters[k]["NoSeatGap"]) > parseInt(spl.seatingPlanLayoutParameters[k]["NoRowGap"])){
						$("#subjectGap"+(k+1)).val("seatgap");
						$("#noSeatOrRowGap"+(k+1)).val(spl.seatingPlanLayoutParameters[k]["NoSeatGap"]);
					}
					subjectUsed[spl.seatingPlanLayoutParameters[k]["SubjectId"]] = subjects[spl.seatingPlanLayoutParameters[k]["SubjectId"]];
					$("#subjectSave").attr("disabled", false);
				}
			}
		}
	}
}

/*
function postLayoutParameters(lp) {
	showLoading(true);
	var formData = lp;
	formData.formType = "seatingplanlayoutparameters";
	var allSeats = [];
	$("[subjectid='" + lp.SubjectId + "']").each(
			function() {
				var sp = $(this).parent();
				allSeats.push(generateSeats(lp.SeatingPlanLayoutParametersId,
						lp.SubjectId, sp.attr("row"), sp.attr("col"), $(this)
								.attr("deskNo")));
			});
	allAssignSeats = allAssignSeats.concat(allSeats);
	formData["assignSeats"] = allSeats;
	layoutParameters[lp.SubjectId]["allseats"] = allSeats;
	ajaxCallAPI('POST', 'persist', formData, function() {
		var data = this.get("responseData");
		console.log(data);
		// postSeatRecursively(0);
		actionDialogue('submit');
		showLoading(false);
	}, function() {
		showLoading(false);
	});
}
function postSeatRecursively(i) {
	if (i == allAssignSeats.length) {
		actionDialogue('submit');
		return;
	}
	ajaxCallAPI('POST', 'persist', allAssignSeats[i], function() {
		var data = this.get("responseData");
		console.log(data);
		i++;
		postSeatRecursively(i);
	}, function() {
	});
}
*/

function addLayoutParameters() {
	showLoading(true);
	$("span").removeAttr("subjectid");
	var seatNo = 1;
	for (var i = 1; i <= subjectArr.length; i++) {
		var subId = $("#subjectDrop" + i).val();
		if(subId!=undefined){
		var SPLPId = seatLayoutId + "_" + subId;
		var rowGap = 0;
		var seatGap = 0;

		if ($("#subjectGap" + i).val() == "rowgap") {
			rowGap = $("#noSeatOrRowGap" + i).val();
			seatNo = addSubjectByRowGap(seatNo, rowGap, $("#seatsRequired" + i)
					.val(), subId);
		} else if ($("#subjectGap" + i).val() == "seatgap") {
			seatGap = $("#noSeatOrRowGap" + i).val();
			seatNo = addSubjectBySeatGap(seatNo, seatGap, $(
					"#seatsRequired" + i).val(), subId);
		} else {
			seatNo = addSubjectBySeatGap(seatNo, seatGap, $(
					"#seatsRequired" + i).val(), subId);
		}
		var lp = {
			"SeatingPlanLayoutParametersId" : SPLPId,
			"SeatLayoutId" : seatLayoutId,
			"SubjectId" : subId,
			"SeatsReq" : $("#seatsRequired" + i).val(),
			"NoRowGap" : rowGap,
			"NoSeatGap" : seatGap
		};
		layoutParameters[subId] = lp;
		//postLayoutParameters(lp);
		}
	}
	showLoading(false);
	gAction = "submit";
	removeSPLByInstanceId(spliId);
}

function addSubjectBySeatGap(seatNo, seatGap, seatsRequired, subId) {
	for (var i = 1; i <= seatsRequired; i++) {
		$("[deskno=" + seatNo + "]").attr("subjectid", subId);
		seatNo++;
	}
	for (var j = 1; j <= seatGap; j++) {
		$("[deskno=" + seatNo + "]").attr("subjectid", "gap");
		seatNo++;
	}
	return seatNo;
}

function addSubjectByRowGap(seatNo, rowGap, seatsRequired, subId) {
	var sel = "";
	for (var i = 1; i <= seatsRequired; i++) {
		$("[deskno=" + seatNo + "]").attr("subjectid", subId);
		seatNo++;
	}
	if(snd == "down" || snd == "downsnake" || snd == "up" || snd == "upsnake" ){
		sel = "[row=" + (parseInt($("[deskno=" + (seatNo - 1) + "]").parent().attr("row")) + parseInt(rowGap)) + "]" ;
	}
	else if(snd == "left" || snd == "leftsnake" || snd == "right" || snd == "rightsnake" ){
		sel = "[col=" + (parseInt($("[deskno=" + (seatNo - 1) + "]").parent().attr("col")) + parseInt(rowGap)) + "]";
	}
	var till = parseInt(parseInt($($(sel+" [deskno]")[$(sel+" [deskno]").length-1]).attr("deskno")) > parseInt($($(sel+" [deskno]")[0]).attr("deskno"))?$($(sel+" [deskno]")[$(sel+" [deskno]").length-1]).attr("deskno"):$($(sel+" [deskno]")[0]).attr("deskno"));
	for(var t=seatNo; t<=till;t++){
		$("[deskno=" + seatNo + "]").attr("subjectid", "gap");
		seatNo++;
	}
	return seatNo;
}

function addSeatingPlanLayout(fRow, tRow, fCol, tCol, color) {
	var splId = spliId + "_" + fRow + "_" + tRow + "_" + fCol + "_" + tCol;
	seatingPlanLayout[splId] = {
		"SeatingPlanLayoutId" : splId + "_" + color,
		"SeatingPlanInstanceId" : spliId,
		"FromRow" : fRow,
		"ToRow" : tRow,
		"FromCol" : fCol,
		"ToCol" : tCol,
		"SeatNoDirection" : snd,
		"IsTemplate" : ist,
		"AssignMarker" : color
	};
	if (color == colorGreen || color == greenHashCode) {
		seatLayoutId = splId + "_" + color;
	}
}

function initSeatingLayout(noOfRow, noOfColumn, divId) {
	$("#" + divId).html("");
	var thisContent = "<table align='center' ><tbody><tr>";
	for (var r = 1; r <= noOfRow; r++) {
		thisContent = thisContent + "<td align='center'><label> Row " + r
				+ "</label></td>";
	}
	thisContent = thisContent
			+ "</tr></tbody><tbody id='seatPlan' class='seatPlan'>";
	for (var i = 1; i <= noOfColumn; i++) {
		thisContent = thisContent + "<tr col='" + i + "' id='seatTR" + i + "'>";
		for (var j = 1; j <= noOfRow; j++) {
			thisContent = thisContent + "<td col='" + i + "' row='" + j
					+ "'  align='center' id='seatTD_" + i + "_" + j
					+ "'><label class='deskNo'>R" + j + " C" + i
					+ "</label><span class='actualSeat' ></span></td>";
		}
		thisContent = thisContent + "</tr>";
	}
	thisContent = thisContent + "</tbody></table><div></div>";
	$("#" + divId).html(thisContent);
	$("#seatPlan")
			.selectable(
					{
						filter : "span",
						selecting : function(a, b, c) {
							/*
							 * console.log("start selecting()"); if
							 * ($(b.selecting).attr("assignmarker") !=
							 * undefined) { $(document).trigger("mouseup");
							 * unselectAll(); return false;
							 *  }
							 */
							console.log("stop selecting()");
							$("#assignMarker").attr('disabled', false);
						},
						selected : function(a, b, c) {

							if ($(b.selected).attr("userassignseat") != undefined) {
								$("#candidateDeskNo").val(
										$(b.selected).attr("deskno"));
								if ($(b.selected).attr("subjectid") != undefined
										&& $(b.selected).attr("candid") != undefined) {
									populateCandidatesBySubject($(b.selected)
											.attr("subjectid"), $(b.selected)
											.attr("candid"));
								} else if ($(b.selected).attr("subjectid") != undefined) {
									populateCandidatesBySubject($(b.selected)
											.attr("subjectid"), "");
								}
								else{
									populateCandidatesBySubject("##nosubject##", "");
								}
							}
							else if($("#candidateName").length > 0){
								populateCandidatesBySubject("##nosubject##", "");
							}
							
							if($("#invalidSeatError") != undefined){
								$("#invalidSeatError").css("display","none");
							}
						}
					});
}

// customise seat start

function validateData(action){
	var isValid = true;
	for(var i=1;i<subNo;i++){
		var seatReq = $("#seatsRequired"+i).val();
		var noEnroll = $("#noEnrolled"+i).val();
		$("#showErrorMessage"+i).html('');
		$("#showErrorMessage"+i).css('display','none');
		$("#seatsRequired"+i).removeClass("input-border-error");
		if(seatReq==""){
			$("#seatsRequired"+i).val("0");
		}
		if(noEnroll!="" && seatReq!="" && parseInt(seatReq) > parseInt(noEnroll)){
			isValid = false;
			$("#showErrorMessage"+i).html('<i class="fa fa-exclamation-circle "></i>No. of seats entered is more than the seats available. Please key in a smaller number.');
			$("#seatsRequired"+i).addClass("input-border-error");
			$("#showErrorMessage"+i).css('display','');
		}

	}
	if(isValid){
		seatingPlanInstance.SeatPlanStatus = action;
		addLayoutParameters();
	}
}

function backToMainScreen(){
	window.location = homeUrl;
}

function backToCustomizeSeats() {
	layoutParameters = {};
	subjectUsed = {};
	$(".seatingConfiguration").css("display", "none");
	$(".customiseSeats").css("display", "");
	$("#customiseLayout").css("display", "");
	$("#generateSeatNo").css("display", "");
	$("#customiseSeatsButton").css("display", "none");
	$("#subjectSave").css("display", "none");
	$("#saveAsDraft").css("display", "");
	$("#assignMarkerBottom").css("display", "none");
	$("#panelTitleNo").html("2");
	$("#panelTitleText").html("CUSTOMISE SEATS");	
	seatingPlanScreenId = "0";
	$(".addNewSubject").html("");
	subNo = 1;
	for(var i=1; i<=SPInstance.NoOfRows; i++){
		for(var j=1; j<=SPInstance.NoOfColumns; j++){
			$("#seatTD_"+j+"_"+i).children(".deskNo").html("R"+i+" C"+j);
		}
	}
}

function showAssignSubjectScreen() {
	populateLayoutParameters();
	$(".seatingConfiguration").css("display", "");
	$(".customiseSeats").css("display", "none");
	$("#customiseLayout").css("display", "none");
	$("#generateSeatNo").css("display", "none");
	$("#customiseSeatsButton").css("display", "");
	$("#subjectSave").css("display", "");
	$("#assignMarkerBottom").css("display", "inline-block");
	$("#panelTitleNo").html("3");
	$("#panelTitleText").html("ASSIGN SUBJECTS");
	seatingPlanScreenId = "1";
}

function loadSPLayout(id) {
	var filter = {};
	filter.conditions = [ "contentJson.SeatingPlanInstanceId=" + id,
			"size=" + 2147483647 ];
	filter.formType = "seatingplanlayout";
	ajaxCallAPI('GET', "searchList", filter, function() {

		var SPLData = this.get("responseData");
		contentdata = this.get("responseData");
		console.log("contentdata : " + JSON.stringify(contentdata));

		if (SPLData.error) {
			displayMessage('danger', SPLData.error, 3000);
		} else {
			var showSeatNo = false;
			for (var i = 0; i < SPLData.content.length; i++) {
				var spl = SPLData.content[i];
				loadAssignMarkerToSeat(spl.fromRow, spl.toRow, spl.fromCol, spl.toCol, spl.assignMarker);
				var arr = spl.storageId.split("_");
				arr.pop();
				var splayoutid = arr.join("_");
				seatingPlanLayout[splayoutid] = spl.contentJson;
				if (spl.assignMarker == "green"
						|| spl.assignMarker == "#8bdb7c") {
					snd = spl.seatNoDirection;
					seatLayoutId = spl.storageId;
					showSeatNo = true;
				}
			}
			if (showSeatNo) {
				changeSeatNoDirection({
					value : snd
				});
				$("[id$='searNoDirection']").val(snd);
			}

			if (seatingPlanScreenId == "1") {
				showAssignSubjectScreen();
			}
		}
	}, function() {

	});

}

function loadSubjectsBySchedule(sch) {
	var filter = {};
	filter.conditions = [ "contentJson.ScheduleStorageID=" + sch,
			"size=" + 2147483647 ];
	filter.formType = "subschedule";
	ajaxCallAPI('GET', "searchList", filter, function() {

		var subData = this.get("responseData");
		contentdata = this.get("responseData");
		console.log("contentdata : " + JSON.stringify(contentdata));

		if (subData.error) {
			displayMessage('danger', subData.error, 3000);
		} else {
			subjectArr = subData.content;
			for (var i = 0; i < subData.content.length; i++) {
				var sub = subData.content[i];
				subjects[sub.contentJson.Subject] = sub.contentJson;
			}
		}
		loadProgrammeSchedule(sch);
	}, function() {

	});
}

function filterSubjectWiseCandidate(){
	for(var c in prevAssignData){
		for(var i=0;i<prevAssignData[c].length;i++){
			if(subjectWiseCandidate.hasOwnProperty(c) && subjectWiseCandidate[c].indexOf(prevAssignData[c][i])>=0){
				subjectWiseCandidate[c].splice(subjectWiseCandidate[c].indexOf(prevAssignData[c][i]), 1);
			}
		}
	}
}

function checkPreviousData(sch){
	var filter = {};
	filter.conditions = ["userType=0", "contentJson.sessionScheduleId=" + sch, "size=" + 2147483647 ];
	filter.formType = "userseatassign";
	ajaxCallAPI('GET', "searchList", filter, function() {
		var usaData = this.get("responseData");
		console.log("contentdata : " + JSON.stringify(usaData));
		if (usaData.error || !usaData.hasOwnProperty("content")) {
			displayMessage('danger', subData.error, 3000);
		} else {
			for (var i = 0; i < usaData.content.length; i++) {
				var usa = usaData.content[i].contentJson;
				if(seatingPlanInstance.SeatingPlanInstanceId!=usa.SeatingPlanInstanceId){
					if(prevAssignData.hasOwnProperty(usa.SubjectId)){
						if(prevAssignData[usa.SubjectId].indexOf(usa.UserId) == -1){
							prevAssignData[usa.SubjectId].push(usa.UserId);
						}
					}
					else{
						prevAssignData[usa.SubjectId] = [usa.UserId];
					}
				}
			}
			filterSubjectWiseCandidate();
		}
	}, function() {

	});
}


function transformation(data) {
	var dataArray = data.content;
	for (var i = 0; i < dataArray.length; i++) {
		var obj = dataArray[i];
		var contentJson = obj.contentJson;

		if (obj.hasOwnProperty("enrolmentStatus")
			&& (obj.enrolmentStatus.toLocaleLowerCase() == "confirmed"
				|| obj.enrolmentStatus.toLocaleLowerCase() == "notified" 
				|| obj.enrolmentStatus.toLocaleLowerCase() == "verified")
			&& contentJson.hasOwnProperty("subjects")) {
			for (var j = 0; j < contentJson.subjects.length; j++) {
				var sub = contentJson.subjects[j];
				if (subjects.hasOwnProperty(sub.SubjectCode)) {
	                 subjects[sub.SubjectCode]["SubjectCode"] = sub.SubjectCode;
	                 subjects[sub.SubjectCode]["SubjectTitle"] = sub.SubjectTitle;
	                 subjects[sub.SubjectCode]["SubjectType"] = sub.SubjectType;
					// subjectArr.push(sub);
					if (subjectWiseObject.hasOwnProperty(sub.SubjectCode)) {
						subjectWiseObject[sub.SubjectCode].push(obj);
					} else {
						subjectWiseObject[sub.SubjectCode] = [ obj ];
					}
					if (obj.hasOwnProperty("candidateId")
							&& obj.candidateId != "") {
						if (subjectWiseCandidate
								.hasOwnProperty(sub.SubjectCode)) {
							if (subjectWiseCandidate[sub.SubjectCode]
									.indexOf(obj.candidateId) == -1) {
								subjectWiseCandidate[sub.SubjectCode]
										.push(obj.candidateId);
							}
						} else {
							subjectWiseCandidate[sub.SubjectCode] = [ obj.candidateId ];
						}
					}
				}
			}
		}
	}
}

function loadProgrammeSchedule(subjectSchedule) {
	var filter = {};
	filter.conditions = [
			"linkType=ProgrammeScheduleSubjectScheduleEntityLink",
			"storageIdRight=" + subjectSchedule, "size=" + 2147483647 ];
	filter.formType = "entityLink";
	ajaxCallAPI(
	'GET',
	"searchList",
	filter,
	function() {
		var subData = this.get("responseData");
		if (subData.error) {
			displayMessage('danger', data.error, 3000);
		} else {
			if (subData && subData.hasOwnProperty("content")) {
				var ps = {};
				for (var i = 0; i < subData.content.length; i++) {
					if (!ps.hasOwnProperty(subData.content[i].storageIdLeft)) {
						ps[subData.content[i].storageIdLeft] = subData.content[i].storageIdLeft;
						loadEnrolmentsBySchedule(subData.content[i].storageIdLeft);
					}
				}
			}
		}
		console.log("subData : " + JSON.stringify(subData));

		console.log("contentdata : " + JSON.stringify(contentdata));
	}, function() {

	});
}

function loadEnrolmentsBySchedule(sch) {
	var filter = {};
	filter.conditions = [ "scheduleCode=" + sch, "size=" + 2147483647 ];
	filter.formType = "enrolment";
	ajaxCallAPI('GET', "searchList", filter, function() {
		var subData = this.get("responseData");
		if (subData.error) {
			displayMessage('danger', data.error, 3000);
		} else {
			if (subData && subData.hasOwnProperty("content")) {
				transformation(subData);
			}
		}
		console.log("subData : " + JSON.stringify(subData));
	}, function() {

	});
}
function saveAsDraftTemplate(){
	gAction = "draftTemplate";
	seatingPlanInstance.SeatPlanStatus = "Draft";
	removeSPLByInstanceId(spliId);
	
}
function saveAsDraft() {
	gAction = "draft";
	seatingPlanInstance.SeatPlanStatus = "Draft";
	if (seatingPlanScreenId == "1") {
		validateData('Draft');
	} else {
		removeSPLByInstanceId(spliId);
	}
}

function removeSPLByInstanceId(instanceId) {
	var modelName = "seatingplanlayout";
	var data = {};
	data.formType = modelName;
	data.seatingPlanInstace = instanceId;
	data.actionType = "removedbyinstanceid";
	ajaxCall('GET', 'removeUserAssignedSeat', ajaxUrl, data, function() {
		var postData = [];
		for ( var k in seatingPlanLayout) {
			var formData = seatingPlanLayout[k];
			formData.formType = "seatingplanlayout";
			formData.SeatNoDirection = snd;
			postData.push(formData);
		}
		saveSeatingPlanInstance();
		//recursivelyPostSeatingPlanLayout(0, postData);
	}, function() {
		showLoading(false);
	});

}

/*
function recursivelyPostSeatingPlanLayout(no, arr) {
	if (no == arr.length) {
		showLoading(false);
		return;
	}
	ajaxCallAPI('POST', 'persist', arr[no], function() {
		var data = this.get("responseData");
		console.log(data);
		setTimeout(function() {
			no++;
			recursivelyPostSeatingPlanLayout(no, arr)
		}, 1000);
	}, function() {
	});
}
*/

function postSeatingPlanLayout(action) {
	showLoading(true);
	changeSeatNoDirection({value : snd});
	provideDeskNo(parseInt(SPInstance.NoOfRows)*parseInt(SPInstance.NoOfColumns));
	if(snd == "downright" || snd == "downsnakeright" || snd == "upright" || snd == "upsnakeright" || snd == "leftdown" || snd == "leftsnakedown" || snd == "rightdown" || snd == "rightsnakedown"){
		for(var i=1;i<=$("[deskno]").length;i++){
			var prefix = seatingPlanInstance.hasOwnProperty("DeskNoFormat")?seatingPlanInstance.DeskNoFormat:"";
			$("[deskno="+i+"]").parent().children(".deskNo").html(prefix+($("[deskno]").length-(i-1)));
			$("[deskno="+i+"]").attr("udeskno", ($("[deskno]").length-(i-1)));
		}
		for(var i=1;i<=$("[udeskno]").length;i++){
			$("[udeskno="+i+"]").attr("deskno", i);
		}
	}
	if (action == "submit") {
		gAction="";
		showAssignSubjectScreen();
	} else if (action == "publish") {
		seatingPlanInstance.SeatPlanStatus = "Active";
		gAction = "publish";
		//actionDialogue('publish');
	} else if (action == "draft") {
		gAction = "draft";
		//actionDialogue('draft');
	}
	removeSPLByInstanceId(spliId);
}

function subjectOptions() {
	var optHTML = '';
	for ( var sub in subjects) {
		if (!subjectUsed.hasOwnProperty(sub)) {
			optHTML = optHTML
					+ '<option value="'
					+ sub
					+ '" >'
					+ (subjects[sub].hasOwnProperty("SubjectTitle") ? subjects[sub].SubjectTitle
							: sub) + '</option>';
		}
	}
	return optHTML;
}

function removeSubject(index){
	$("#subjectRow"+index).remove();
	var manageData = [];
	$(".subjectDropDown").each(function(){
		var mData = {};
		var subNo = $(this).attr("no");
		mData["SubjectId"] = $(this).val();
		mData["SeatsReq"] = $("#seatsRequired"+subNo).val();
		mData["gap"] = $("#subjectGap"+subNo).val();
		mData["gapValue"] = $("#noSeatOrRowGap"+subNo).val();
		manageData.push(mData);
	});
	$(".addNewSubject").html("");
	subNo = 1;
	subjectUsed = {};
	for(var k=0;k<manageData.length;k++){
		var mData = manageData[k];
		addNewSubject();
		$("#subjectDrop"+(k+1)).val(mData["SubjectId"]);
		$("#seatsRequired"+(k+1)).val(mData["SeatsReq"]);
		$("#subjectGap"+(k+1)).val(mData["gap"]);
		$("#noSeatOrRowGap"+(k+1)).val(mData["gapValue"]);
		changeSubject(document.getElementById("subjectDrop"+(k+1)));
	}
}

function addNewSubject() {
	if (subNo > subjectArr.length) {
		return false;
	}
	if ($("#subjectDrop" + (subNo - 1)).val() == "") {
		return false;
	}
	var newSubjectHTML = '<div class="row-fluid " id="subjectRow'
			+ subNo
			+ '" > <div class="span12 " ><div class="row-fluid "> <div class="span12 " > <div class="form-group" > <label class="control-label">&nbsp;&nbsp;SUBJECT '
			+ subNo
			+ ' <span onclick="removeSubject('+subNo+')" style="float: right; background: red; height: 18px; width: 18px; border-radius: 50%; text-align: center; font-size: 15px; "><i class="fa fa-times"></i></span></label> <div class="control-group" id="subject'
			+ subNo
			+ '">  <select onchange="changeSubject(this)" class="aui-field-select form-control subjectDropDown" id="subjectDrop'
			+ subNo
			+ '" no="'
			+ subNo
			+ '" placeholder="Choose a subject..."> <option class="" value="" hidden="true"> Choose a subject</option> '
			+ subjectOptions()
			+ ' </select>  </div> </div> </div> </div><div class="row-fluid "><div class="span4 " > <div class="form-group" > <label class="control-label">SEATS <br />REQUIRED</label>  <input type="text" value="0" class="seatsRequired" name="seatsRequired'
			+ subNo
			+ '" id="seatsRequired'
			+ subNo
			+ '" no="'
			+ subNo
			+ '" /> </div> </div> <div class="span4 " > <div class="form-group" > <label class="control-label"># <br />Enrolled</label>  <input type="text" disabled class="noEnrolled" name="noEnrolled'
			+ subNo
			+ '" id="noEnrolled'
			+ subNo
			+ '"  no="'
			+ subNo
			+ '"/> </div> </div> <div class="span4 " > <div class="form-group" > <label class="control-label">No. of Special Arrangement</label>  <input type="text" class="specialArrangement" name="specialArrangement'
			+ subNo
			+ '" disabled id="specialArrangement'
			+ subNo
			+ '" no="'
			+ subNo
			+ '" /> </div> </div><span class="seat-error-span" style="display:none;" id="showErrorMessage'
			+ subNo
			+ '"></span> </div> <div class="row-fluid "><div class="span12 " id=""> <div class="form-group"> <div class="control-group"> <select class="aui-field-select form-control subjectGap" id="subjectGap'
			+ subNo
			+ '" no="'
			+ subNo
			+ '" > <option class="" value="">Choose an option</option> <option class="" value="rowgap"> No. of rows in between each subject</option> <option class="" value="seatgap"> No. of empty seats in between each subject</option> </select> </div> </div> </div> </div><div class="row-fluid "><div class="span4 " > <div class="form-group" > <input type="text" class="noSeatOrRowGap" name="noSeatOrRowGap'
			+ subNo + '" id="noSeatOrRowGap' + subNo + '" no="' + subNo
			+ '" /> </div> </div> </div> </div></div><br/>';
	$(".addNewSubject").append(newSubjectHTML);
	if (subjectArr.length == 1) {
		$(".subjectGap").attr("disabled", true);
		$(".noSeatOrRowGap").attr("disabled", true);
	}
	subNo++;
}

function changeSubject(t) {
	calculateNoOfEnrolment();
	subjectUsed[t.value] = subjects[t.value];
	$("#subjectSave").attr("disabled", false);
	$(t).attr("disabled", true);
}

function TimeDifference(FromTime,ToTime){
	 var time1Seconds = toSeconds(FromTime.substr(0,2), FromTime.substr(3));
    var time2Seconds = toSeconds(ToTime.substr(0,2), ToTime.substr(3));

    if (!time1Seconds || !time2Seconds){
        return false;
    }
    var difference = time2Seconds-time1Seconds;
    return difference;
}

function toSeconds(hours, minutes){
    var seconds = 0;
    if ( (hours >= 0 && hours < 24) && (minutes >= 0 && minutes < 60)){
        seconds += (parseInt(hours)*3600) + (parseInt(minutes)*60);
        return seconds
    } else {
        return false;
    }
}


function calculateNoOfEnrolment(){
	var subjectWiseCandidateCount = {};
	subjectUsed = {};
	for(var c in subjectWiseCandidate){
		if(c!=undefined && c!=""){
			var arr = [];
			for(var j=0;j<subjectWiseCandidate[c].length;j++){
				arr.push(subjectWiseCandidate[c][j]);
				subjectWiseCandidateCount[c] = arr;
			}
		}
	}
	$(".subjectDropDown").each(function(){
	var sub = $(this).val();
	if(!subjectWiseCandidateCount.hasOwnProperty(sub)){
		subjectWiseCandidateCount[sub]=[];
	}
	var count = subjectWiseCandidateCount[sub].length;
	var eValid = false;
	var iFTime = subjects[sub]["FTime"];
	var iTTime = subjects[sub]["TTime"];
	for(var sub1 in subjectUsed){
		if(sub1!=undefined){
			var jFTime = subjects[sub1]["FTime"];
			var jTTime = subjects[sub1]["TTime"];
			if(TimeDifference(iFTime,jFTime)>=0&&TimeDifference(iTTime,jFTime)<=0){
				eValid = true;
			}else if(TimeDifference(iFTime,jTTime)>=0&&TimeDifference(iTTime,jTTime)<=0){
				eValid = true;
			}else{
				eValid = false;
			}
			if(eValid){
				var removedArr = [];
				for(var c=0; c<subjectWiseCandidateCount[sub].length;c++){
					if(subjectWiseCandidateCount[sub1].indexOf(subjectWiseCandidateCount[sub][c])>=0){
						removedArr.push(subjectWiseCandidateCount[sub][c]);
						count--;
					}
				}
				for(var a=0;a<removedArr.length;a++){
					var c = subjectWiseCandidateCount[sub].indexOf(removedArr[a]);
					subjectWiseCandidateCount[sub].splice(c, 1);
				}
			}
		}
	}
	subjectUsed[sub] = subjects[sub];
	$("#noEnrolled" + $(this).attr("no")).val(count);
	});
}




//popup



// customise seat end
//