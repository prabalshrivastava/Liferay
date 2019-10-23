var filterdata = [];
var columnTitles = {};
var columnlist;
var currentList = [];


var psPending = "Pending";
var psConfirmed = "Confirmed";
var psPendingAmendment = "Pending Amendment";
var psPendingApproval = "Pending Approval";

function getFormFields(){
	if(modelName == "" || modelName == undefined){
		console.log("modelName Missing");
	}else{
		searchBox = document.getElementById(namespace +"searchtextbox");
		ajaxCall('GET','loadData',ajaxurl,{"formType":"configuration","formStorageId":categoryType},
				function() {
			var data = this.get("responseData");
			if (_.isEmpty(data)) {
				console.log("error");
			} else {
				var jsonfilterparameter = {"modelName":modelName,"formType":modelName,"CategoryType":categoryType};
				ajaxCall('GET','filterColumnList',filtercolumnlisturl,jsonfilterparameter,
						function() {
		            var titleData = this.get("responseData");
					if (_.isEmpty(titleData)) {
						console.log("error");
					} else {
						if(!titleData.distinct.hasOwnProperty('contentJson')){
							var c={}
							c.Status=["Active","Inactive","Draft"];
							titleData.distinct.contentJson=c;
						}
						titleData.distinct.contentJson.Status=["Active","Inactive","Draft"];
						console.log("columns : "+JSON.stringify(titleData));
						
						columnTitles = titleData.titles;
						populateSearchFields(data);  
					}
				},
				function() {
					console.log("No such microservicemodel name"+modelName);
				}); 
			}
		},
		function() {

		});
	}

}
function getFilterFields(){
	if(modelName == "" || modelName == undefined){
		console.log("modelName Missing");
	}else{
		var jsonfilterparameter = {"modelName":modelName,"formType":modelName,"CategoryType":categoryType};
		ajaxCall('GET','filterColumnList',filtercolumnlisturl,jsonfilterparameter,
				function() {
            var data = this.get("responseData");
			if (_.isEmpty(data)) {
				console.log("error");
				jsFilterColumnList();
			} else {
				if(!data.distinct.hasOwnProperty('contentJson')){
					var c={}
					c.Status=["Active","Inactive","Draft"];
					data.distinct.contentJson=c;
				}
				data.distinct.contentJson.Status=["Active","Inactive","Draft"];
				renameFilterFields(data);
				jsFilterColumnList();
			}
		},
		function() {
			console.log("No such microservicemodel name"+modelName);
			jsFilterColumnList();
		});
	}
	return null;
}

function populateSearchFields(data){
	var availableColumns = [];
	columnsToShow=[];
	masterColumns = [];
	var allcolumns = data.contentJson.columnlist + "," + auditFields ;
	masterColumns = allcolumns.split(',');
	if(data.storageId != "null") columnsToShow.push("storageId");
	if(!isnull(data.contentJson.column1)) columnsToShow.push(data.contentJson.column1);
	if(!isnull(data.contentJson.column2)) columnsToShow.push(data.contentJson.column2);
	if(!isnull(data.contentJson.column3)) columnsToShow.push(data.contentJson.column3);
	if(!isnull(data.contentJson.column4)) columnsToShow.push(data.contentJson.column4);
	if(!isnull(data.contentJson.column5)) columnsToShow.push(data.contentJson.column5);
	if(!isnull(data.contentJson.column6)) columnsToShow.push(data.contentJson.column6);
	if(!isnull(data.contentJson.column7)) columnsToShow.push(data.contentJson.column7);
	if(data.contentJson.columnlist != "null") columnlist = data.contentJson.columnlist;
	columnsToShow.push("");
	[].forEach.call(  document.querySelectorAll('.form-fields-select :checked')  , function(elm){
		if(elm.value !=  0){
			exForm[elm.value] = elm.value;
		}
	})
	Object.keys(masterColumns).forEach(function(entry,key) {
		if(!exForm.hasOwnProperty(key)){
			availableColumns.push(masterColumns[key]);
		}
	});
	var selectBoxNumber = 0,selectValue,selectText;
	[].forEach.call(  document.querySelectorAll('.form-fields-select')  , function(elm){
		
		if(elm.options[elm.selectedIndex] != undefined){
			for(var j = elm.options.length; j >= 0 ;j--){
				elm.remove(j);
			}
		}

		selectText = "Select";
		selectValue = "";

		var o = document.createElement("option");
		o.value = selectValue;
		o.text = selectText;
		elm.appendChild(o);

		var opt = document.createElement("option");

		if(selectBoxNumber == 0) {
			selectValue = data.contentJson.column1; 
		} else if(selectBoxNumber == 1 && data.contentJson.column2 !=null) {
			selectValue = data.contentJson.column2;
		} else if(selectBoxNumber == 2 && data.contentJson.column3 !=null) {
			selectValue = data.contentJson.column3;
		} else if(selectBoxNumber == 3 && data.contentJson.column4 !=null) {
			selectValue = data.contentJson.column4;
		} else if(selectBoxNumber == 4 && data.contentJson.column5 !=null) {
			selectValue = data.contentJson.column5;
		} else if(selectBoxNumber == 5 && data.contentJson.column6 !=null) {
			selectValue = data.contentJson.column6;
		} else if(selectBoxNumber == 6 && data.contentJson.column7 !=null) {
			selectValue = data.contentJson.column7;
		}
		selectBoxNumber++;
		opt.value = selectValue;

		if(isnull(selectValue)){ 
			selectText = "Select";
		}else{
			selectText = selectValue;
		}
		console.log("selectText : "+selectText);
		opt.text = getDisplayHeadingName(selectText);
		opt.selected ='selected';
		elm.appendChild(opt);

		for (var i = 0; i < availableColumns.length; i++) {
			var opn = document.createElement("option");
			console.log("availableColumns[i] : "+availableColumns[i]);
			opn.value = availableColumns[i];
			opn.text = getDisplayHeadingName(availableColumns[i]);
			elm.appendChild(opn);
		}
	})
	getFilterFields();

}

function getDisplayHeadingName(col) {
	var headingText = columnTitles["contentJson."+col];
	var text;
	if(typeof headingText === "undefined") {
		text = col; 
	} else {
		text = getTitleLabel(col); 
	}
	return text;
}

function getTitleLabel(key) {
	console.log("key : "+key);
	for(var cti=0;cti<columnTitles.length;cti++) {
		var titleObj = columnTitles[cti];
		console.log(titleObj);
		if((typeof titleObj !== "undefined") && titleObj.key == ("contentJson."+key)) {
			return titleObj.value;
		}
	}
	return key;
}

function getTitleKey(label) {
	console.log("label : "+label);
	for(var cti=0;cti<columnTitles.length;cti++) {
		var titleObj = columnTitles[cti];
		console.log(titleObj);
		if((typeof titleObj !== "undefined") && titleObj.value == label) {
			return titleObj.key.split(".")[1];
		}
	}
	return label;
}

function dateBeutify(dateS) {
	var ee = new Date(Date.parse(dateS));
	var day = ee.getDate()<10?"0"+ee.getDate():ee.getDate();
	var month = ee.getMonth() + 1;
	month = month<10?"0"+month:month;
	var date = (day  + '/' + month +  '/' +  ee.getFullYear());
	return date;
}

function reloadTable(a,isSearchList) {
	var table = document.getElementById("tableId");
	var tbody = document.querySelector("#tableId tbody");
	var allheadings = document.querySelectorAll("#tableId .Heading")[0];

	if(a.length > 0){
		while (allheadings.firstChild) {
			allheadings.removeChild(allheadings.firstChild);
		}
		for (var j = 0; j < columnsToShow.length; j++) {
			var th = document.createElement('th');
			var italic = document.createElement('i');
			var headingText = getTitleLabel(columnsToShow[j]);
			var text;
			if(typeof headingText === "undefined") {
				text = document.createTextNode(columnsToShow[j]); 
			} else {
				text = document.createTextNode(getTitleLabel(columnsToShow[j])); 
			}
			th.appendChild(text);
			th.appendChild(italic);
			if(sortbyArray.length > 0 && sortbyArray[0].field == columnsToShow[j]){
				th.classList.add("listsort" + sortbyArray[0].direction);
			}
			if(j == 0) th.style.display = "none";
			
			if(columnsToShow[j]=="TotalAmountBaseCurrency"){
				th.style.cssText = "text-align:right; padding-right:30px !important";
			}
			
			allheadings.appendChild(th);
		}
		var tr = document.createElement('tr');
		var td = document.createElement('td'); 
		var aaa = document.createTextNode("aaa"); 
		td.appendChild(aaa);
		td.style.display= "none";
		tr.appendChild(td);
		for (var idx = 1; idx < columnsToShow.length-1; idx++) {
			var tbld = document.createElement('td'); 
			var txt = document.createTextNode("aaa");
			tbld.appendChild(txt);
			tr.appendChild(tbld);
		}
		var tbldt = document.createElement('td'); 
		tbldt.appendChild(threedot);
		tr.appendChild(tbldt);
		tr.className += " Row ";
		tbody.appendChild(tr);
		var f = document.querySelector("#tableId .Row").cloneNode(true);

//		for (var g = 0; g < th.length; g++) {
//			th[g].innerHTML = "<span>" + columnsToShow[g].replace(/([a-z0-9])([A-Z])/g, '$1 $2') + "</span><i></i>";
//		}
		clearTableData();
		var e;
		var disableApproverMenus = true;
		var disableProcessMenu = true;
		var massProcessPaymentMenu = false;
		for (var c = 0; c < a.length; c++) {
			var rowclone = f.cloneNode(true);
			e = rowclone.querySelectorAll("td");
			e[0].innerHTML = a[c][columnsToShow[0]];
			for(var i = 1; i < columnsToShow.length - 1; i++){ 
				if(typeof a[c].contentJson[columnsToShow[i]] === "undefined") {
					if(columnsToShow[i] == "createdDate" || columnsToShow[i] == "lastModifiedDate"){
						e[i].innerHTML = dateBeutify( a[c][columnsToShow[i]]);
					}else if(columnsToShow[i] == "createdBy" || columnsToShow[i] == "lastModifiedBy"){
						e[i].innerHTML = a[c][columnsToShow[i]];
						if(typeof userArray[a[c][columnsToShow[i]]] !== "undefined"){
							e[i].innerHTML = userArray[a[c][columnsToShow[i]]];
						}
					}
					else{
						e[i].innerHTML = (a[c].contentJson[columnsToShow[i]] === undefined ? "" : a[c].contentJson[columnsToShow[i]]);
					}

				} else {
					e[i].innerHTML = (a[c].contentJson[columnsToShow[i]] === undefined ? "" : a[c].contentJson[columnsToShow[i]]);
					if(columnsToShow[i]=="TotalAmountBaseCurrency"){
						if(Number(Number(e[i].innerHTML).toFixed(2)).toString() != "NaN"){
							e[i].innerHTML = Number(e[i].innerHTML).toFixed(2);
						}
						e[i].style.cssText = "text-align:right; padding-right:30px !important";
					}
				}
			}

			if(a[c].contentJson.Status == "Active" && e[columnsToShow.length - 1].getElementsByClassName("activate").length  > 0){
				e[columnsToShow.length - 1].getElementsByClassName("activate")[0].style.display = "none";	
			}else if(a[c].contentJson.Status == "Inactive" && e[columnsToShow.length - 1].getElementsByClassName("deactivate").length  > 0){
				e[columnsToShow.length - 1].getElementsByClassName("deactivate")[0].style.display = "none";	
			}else if(a[c].contentJson.Status == "Draft"){
				e[columnsToShow.length - 1].getElementsByClassName("deactivate")[0].style.display = "none";	
				e[columnsToShow.length - 1].getElementsByClassName("activate")[0].style.display = "none";
			}
			
			var as = a[c].contentJson.ApprovalStatus;
			var ts = a[c].contentJson.TransactionStatus;
			var type = a[c].contentJson.Type;
			var rt = a[c].contentJson.RequestType;
			var ct = a[c].contentJson.CategoryType;
			var txnd = a[c].contentJson.TxnDate;
			console.log("as : "+as);
			console.log("type : "+type);
			console.log("rt : "+rt);
			console.log("ct : "+ct);
			console.log("txnd : "+txnd);
			
			var newPopover = e[columnsToShow.length - 1];
			console.log("newPopover : "+newPopover.id);
			
			if (ct == "Invoice") {
				if ((as == "Pending" || as == "Return for Amendments")) {
					showHideElement(
							newPopover.getElementsByClassName("submit")[0],
							"block");
				} else {
					showHideElement(
							newPopover.getElementsByClassName("submit")[0],
							"none");
				}
				if (as == "Pending Approval"
						&& (rt == "Cancel" || rt == "New Invoice")) {
					showHideElement(newPopover
							.getElementsByClassName("approve")[0], "block");
				} else {
					showHideElement(newPopover
							.getElementsByClassName("approve")[0], "none");
				}
				if (as == "Pending Approval"
						&& (rt == "Cancel" || rt == "New Invoice")) {
					showHideElement(
							newPopover.getElementsByClassName("reject")[0],
							"block");
				} else {
					showHideElement(
							newPopover.getElementsByClassName("reject")[0],
							"none");
				}
				if (as == "Pending Approval" && rt != "Cancel" && rt != "Void") {
					showHideElement(
							newPopover.getElementsByClassName("return")[0],
							"block");
				} else {
					showHideElement(
							newPopover.getElementsByClassName("return")[0],
							"none");
				}
				if (rt == "New Invoice"
						&& (as == "Pending" || as == "Pending Approval" || as == "Return for Amendments")) {
					showHideElement(
							newPopover.getElementsByClassName("void")[0],
							"block");
				} else {
					showHideElement(
							newPopover.getElementsByClassName("void")[0],
							"none");
				}
				if ( rt == "New Invoice"
						&& as == "Approved") {
					showHideElement(
							newPopover.getElementsByClassName("cancel")[0],
							"block");
				} else {
					showHideElement(
							newPopover.getElementsByClassName("cancel")[0],
							"none");
				}
				

				if(as == "Pending Approval"){
					showHideElement(
							newPopover.getElementsByClassName("void")[0],
							"none");
				}
				
				if(as == "Approved" && ts == "Pending" && rt == "New Invoice") {
					showHideElement(
							newPopover.getElementsByClassName("cancel")[0],
							"none");
					showHideElement(
							newPopover.getElementsByClassName("void")[0],
							"none");
				}
			} else if (ct == "Receipt") {
				if (as == "Pending Approval") {
					showHideElement(newPopover
							.getElementsByClassName("approve")[0], "block");
					showHideElement(
							newPopover.getElementsByClassName("reject")[0],
							"block");
					showHideElement(
							newPopover.getElementsByClassName("return")[0],
							"block");
				} else {
					showHideElement(newPopover
							.getElementsByClassName("approve")[0], "none");
					showHideElement(
							newPopover.getElementsByClassName("reject")[0],
							"none");
					showHideElement(
							newPopover.getElementsByClassName("return")[0],
							"none");
				}

				console.log("serverCurrDate : " + serverCurrDate);
				console.log("td : " + txnd);
				if ((as == "Approved" && (rt == "New Invoice" || rt == "New Receipt"))
						|| as == "Return for Amendments") {
					if (serverCurrDate == txnd) {
						showHideElement(newPopover
								.getElementsByClassName("void")[0], "block");
						showHideElement(newPopover
								.getElementsByClassName("cancel")[0], "none");
					} else {
						showHideElement(newPopover
								.getElementsByClassName("void")[0], "none");
						showHideElement(newPopover
								.getElementsByClassName("cancel")[0], "block");
					}
				} else {
					showHideElement(
							newPopover.getElementsByClassName("void")[0],
							"none");
					showHideElement(
							newPopover.getElementsByClassName("cancel")[0],
							"none");
				}
			}
			else if(ct == "Payment Advice"){
				if(ts == psPending){
					massProcessPaymentMenu = true;
					newPopover.getElementsByClassName("processPaymentLabel")[0].innerHTML = (palabelprocesspayment==undefined)?"Process Payment":palabelprocesspayment;
				}
				else if(ts == psConfirmed){
					newPopover.getElementsByClassName("processPaymentLabel")[0].innerHTML = (palabelreprocesspayment==undefined)?"Re-Process Payment":palabelreprocesspayment;
				}
				else if(ts == psPendingAmendment){
					newPopover.getElementsByClassName("processPaymentLabel")[0].innerHTML = (palabelreprocesspayment==undefined)?"Re-Process Payment":palabelreprocesspayment;
				}
				else if(ts == psPendingApproval){
					newPopover.getElementsByClassName("processPaymentLabel")[0].innerHTML = (palabelapprove==undefined)?"Approve":palabelapprove;
				}
				
				if(as.toUpperCase() == "PENDING APPROVAL") {
					disableApproverMenus = false;
					showHideElement(newPopover.getElementsByClassName("approve")[0] ,"block");
					showHideElement(newPopover.getElementsByClassName("reject")[0] ,"block");
					showHideElement(newPopover.getElementsByClassName("samendments")[0] ,"block");
					showHideElement(newPopover.getElementsByClassName("vamendments")[0] ,"block");
				} else {
					showHideElement(newPopover.getElementsByClassName("approve")[0] ,"none");
					showHideElement(newPopover.getElementsByClassName("reject")[0] ,"none");
					showHideElement(newPopover.getElementsByClassName("samendments")[0] ,"none");
					showHideElement(newPopover.getElementsByClassName("vamendments")[0] ,"none");
				}
				if(as.toUpperCase() == "APPROVED" || as.toUpperCase() == "PENDING AMENDMENTS" || as.toUpperCase()=="PENDING") {
					disableProcessMenu = false;
					showHideElement(newPopover.getElementsByClassName("processPayment")[0] ,"block");
				} else {
					showHideElement(newPopover.getElementsByClassName("processPayment")[0] ,"none");
				}
			}
			table.appendChild(rowclone);

		}
		
		if(disableProcessMenu) {
			showHideElement(document.getElementById("massProcessPaymentMenu") ,"none");
		} else {
			showHideElement(document.getElementById("massProcessPaymentMenu") ,"block");
		}
		if(disableApproverMenus) {
			showHideElement(document.getElementById("gapprove") ,"none");
			showHideElement(document.getElementById("greject") ,"none");
			showHideElement(document.getElementById("gsamendments") ,"none");
			showHideElement(document.getElementById("gvamendments"),"none");
		} else {
			showHideElement(document.getElementById("gapprove"),"block");
			showHideElement(document.getElementById("greject"),"block");
			showHideElement(document.getElementById("gsamendments") ,"block");
			showHideElement(document.getElementById("gvamendments") ,"block");
		}
		
		YUI().use("node", "event", function(A) {
			var j = A.all(".threedot");
			j.on("click", function(o) {
				o.preventDefault();
				o.stopPropagation();
				var p = document.getElementsByClassName("Pop-Action");
				for (var l = 0; l < p.length; l++) {
					p[l].classList.add("hide")
				}
				var m = o.currentTarget;
				var n = m.next();
				if(n){
					n.removeClass("hide");
				}
				
			})

			var k = A.all("th");
			k.on("click", function(o) {
				eee = o;
				
				var node = eee.currentTarget._node;
				var nodeHtml = eee.currentTarget._node.innerHTML.replace(/\s/g,'');
				var nodeTxt  = eee.currentTarget._node.innerText;
				var popupcontainer= A.all("th");
				popupcontainer.removeClass("sortField");
				sortbyArray = [];
				console.log("nodeTxt : "+nodeTxt);
				if(sortBy.field == getTitleKey(nodeTxt)){
					if(sortBy.direction == "asc"){
						sortBy.direction = "desc";
					}else{
						sortBy.direction = "asc";
					} 
				}else{
					sortBy.direction = "asc";
				}
				console.log("node.firstElementChild.innerHTML : "+node.innerText);
				sortBy.field = getTitleKey(node.innerText);

				if(auditFields.indexOf(getTitleKey(nodeTxt)) != -1){
					sortBy.contentJSON = "false";
				}else{
					sortBy.contentJSON = "true";
				}
				sortbyArray.push(sortBy);
				console.log(sortbyArray);
				jsFilterColumnList();
			})

		})
		YUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated',
				'stylesheet','aui-datepicker','overlay','event', 'widget-anim', function(A){

			var container = A.one('body');
			container.on('click', function(e){
				var actionsBox = document.getElementsByClassName('Pop-Action');
				for(var k = 0;k< actionsBox.length;k++){
					actionsBox[k].classList.add('hide');
				}
			});

		});
		document.getElementsByClassName('data-lising')[0].style.display = "block";
		document.getElementsByClassName('pagination')[0].style.display = "block";
		document.getElementsByClassName('no-data-listing')[0].style.display = "none";
	}else{
		document.getElementsByClassName('data-lising')[0].style.display = "none";
		document.getElementsByClassName('pagination')[0].style.display = "none";
		document.getElementsByClassName('no-data-listing')[0].style.display = "block";
		if(!isSearchList) {	
			document.querySelector("h3.no-data-listing-message").innerHTML="No " + modelName  + " record present.";
			document.querySelector("p.no-data-listing-message").innerHTML="There aren't any records of existing "+modelName+"'s as of now.\nIf you would like to create a new one, please click on the 'ADD NEW' button.";
		}
		else {
			document.querySelector("h3.no-data-listing-message").innerHTML="Search Results for " + modelName;
			document.querySelector("p.no-data-listing-message").innerHTML="No search results were found for your query"; 		
		}    	
	}
	if(categoryType=="RE") {
		document.getElementById("gcancel").getElementsByTagName("a")[0].style.pointerEvents = "all";
		document.getElementById("gcancel").classList.remove("custom-tooltip");
		document.getElementById("gcancel").style.opacity = 1;
		document.getElementById("voidcanceltooltip").style.display = "none";
		var disableLorMenu = false;
		var disableGVoidMenu = false;
		var disableGCancelMenu = false;
		var disableGApproveMenu = false;
		var disableGRejectMenu = false;
		var disableGReturnMenu = false;
		var jsonfilterparameter = {"limit":2147483647,"modelName":modelName,"page":0,"formType":modelName};
		jsonfilterparameter["filterdata"]=filterdata;
		jsonfilterparameter["conditions"]= freeTextArray;
		jsonfilterparameter["sortby"]= [{direction: "asc", field: "ExtRefNumber", contentJSON: "true"}];
		ajaxCall('GET','elastiSearchList',ajaxurl,jsonfilterparameter,
				function() {
			showLoading(false); 
			var data = this.get("responseData");
			console.log(data);
			console.log(data.content.length);
			var allReceipts = data.content;
			currentList = allReceipts;
			var olddates = false;
			var currdates = false;
			for(var cin in allReceipts) {
				var rcpt = allReceipts[cin];
				if(rcpt.contentJson.ApprovalStatus.toUpperCase()!="APPROVED") {
					disableLorMenu = true;
				}
				var currDate = new Date();
				currDate.setHours(0,0,0,0);
				var dateComps = rcpt.contentJson.TxnDate.split("/");
				var txnDate = new Date(dateComps[1]+"/"+dateComps[0]+"/"+dateComps[2]);
				txnDate.setHours(0,0,0,0);
				console.log(currDate+" | "+txnDate);
				if(!((rcpt.contentJson.ApprovalStatus.toUpperCase()=="APPROVED"
					&& rcpt.contentJson.TransactionStatus.toUpperCase()=="CONFIRMED")
						|| rcpt.contentJson.ApprovalStatus.toUpperCase()=="RETURN FOR AMENDMENTS")) {
					disableGVoidMenu = true;
					disableGCancelMenu = true;
				}
				if(currDate.getTime()!=txnDate.getTime()) {
					disableGVoidMenu = true;
					olddates = true;
				}
				if(currDate.getTime()==txnDate.getTime()) {
					disableGCancelMenu = true;
					currdates = true;
				}
				if(rcpt.contentJson.ApprovalStatus.toUpperCase()!="PENDING APPROVAL") {
					disableGApproveMenu = true;
					disableGRejectMenu = true;
					disableGReturnMenu = true;
				}
			}
			var generateLOR = document.getElementById("generateLORMenu");
			if(generateLOR) {
				if(disableLorMenu) {
					generateLOR.style.display="none";
				} else {
					generateLOR.style.display="block";
				}
			}
			if(disableGVoidMenu) {
				showHideElement(document.getElementById("gvoid"), "none");
			} else {
				showHideElement(document.getElementById("gvoid"), "block");
			}
			if(disableGCancelMenu) {
				showHideElement(document.getElementById("gcancel"), "none");
			} else {
				showHideElement(document.getElementById("gcancel"), "block");
			}
			console.log(currdates+" "+olddates);
			if(olddates && currdates) {
				showHideElement(document.getElementById("gcancel"), "block");
				document.getElementById("voidcanceltooltip").style.display = "block";
				document.getElementById("gcancel").getElementsByTagName("a")[0].style.pointerEvents = "none";
				document.getElementById("gcancel").classList.add("custom-tooltip");
				document.getElementById("gcancel").style.opacity = 0.6;
			}
			if(disableGApproveMenu) {
				showHideElement(document.getElementById("gapprove"), "none");
			} else {
				showHideElement(document.getElementById("gapprove"), "block");
			}
			if(disableGRejectMenu) {
				showHideElement(document.getElementById("greject"), "none");
			} else {
				showHideElement(document.getElementById("greject"), "block");
			}
			if(disableGReturnMenu) {
				showHideElement(document.getElementById("greturn"), "none");
			} else {
				showHideElement(document.getElementById("greturn"), "block");
			}
		},
		function() {

		});
	}
	
}

function updateFormFields(){
	var data = {"formStorageId":categoryType,"configurationModelName":categoryType,"formType":"configuration"};
	data.column1 = document.getElementById(portletns + 'select1').value;
	data.column2 = document.getElementById(portletns + 'select2').value;
	data.column3 = document.getElementById(portletns + 'select3').value;
	data.column4 = document.getElementById(portletns + 'select4').value;
	data.column5 = document.getElementById(portletns + 'select5').value;
	data.column6 = document.getElementById(portletns + 'select6').value;
	data.column7 = document.getElementById(portletns + 'select7').value;
	data.columnlist = columnlist;


	ajaxCall('POST','update',ajaxurl,data,
			function() {
		var data = this.get("responseData");
		if (data.error) {
			console.log("error");
		} else {    
			getFormFields(); 
		}
	},
	function() {

	});
}
