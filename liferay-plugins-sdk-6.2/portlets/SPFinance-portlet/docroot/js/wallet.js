var pageRequested = 1;

var totalPages = 2;

var type = "pending";

var sortbyArray = [];
var sortBy = {};
var eee;

function makePaging(totalPages, pageIndex, type) {
	console.log("totalPages : "+totalPages);
	console.log("pageIndex : "+pageIndex);
	var oPaging, i, j, k;
	totalPages = parseInt(totalPages);
	pageIndex++;
	i = pageIndex;
	j = pageIndex - 1;
	k = pageIndex + 1;
	var oBefore = "", oAfter = "";
	var disable = false;
	if (i <= 1) {
		disable = true;
	}
	while (j != 0 && j != i - 6 && j > 0) {
		oBefore = "<li id1='" + j + "'><a  href='javascript:showPage(" + j
				+ ",\"" + type + "\")' data-index='" + (j - 1) + "'>" + j
				+ "</a></li>" + oBefore;
		j--;
	}
	if (disable) {
		oBefore = "<li id2='" + (i - 1)
				+ "'><a class='prev' href='javascript:void(0)' data-index='"
				+ (i - 2) + "'>  </a></li>" + oBefore;
		oBefore = "<li id3='1'><a class='first' href='javascript:void(0)' data-index='1'>  </a></li>"
				+ oBefore;
	} else {
		oBefore = "<li id4='" + (i - 1)
				+ "'><a class='prev' href='javascript:showPage(" + (i - 1)
				+ ",\"" + type + "\")' data-index='" + (i - 2)
				+ "'>  </a></li>" + oBefore;
		oBefore = "<li id5='1'><a class='first' href='javascript:showPage(1,\""
				+ type + "\")' data-index='1'>  </a></li>" + oBefore;
	}
	for (; k <= totalPages && k < (i + 6) && k > 0; k++) {
		oAfter += "<li id6='" + k + "'><a  href='javascript:showPage(" + k
				+ ",\"" + type + "\")' data-index='" + (k - 1) + "'>" + k
				+ "</a></li>";
	}
	disable = false;
	if (i >= totalPages) {
		disable = true;
	}
	if (disable) {
		oAfter += "<li id2='" + (i + 1)
				+ "'><a class='next' href='javascript:void(0)' data-index='"
				+ (i) + "'>  </a></li>";
		oAfter += "<li id2='" + (k - 1)
				+ "'><a class='last' href='javascript:void(0)' data-index='"
				+ (k - 2) + "'>  </a></li>";
	} else {
		oAfter += "<li id2='" + (i + 1)
				+ "'><a class='next' href='javascript:showPage(" + (i + 1)
				+ ",\"" + type + "\")' data-index='" + (i) + "'>  </a></li>";
		oAfter += "<li id2='" + (totalPages - 1)
				+ "'><a class='last' href='javascript:showPage(" + totalPages
				+ ",\"" + type + "\")' data-index='" + (totalPages - 2)
				+ "'>  </a></li>";
	}

	oPaging = "<ul  class='pagination-content'>" + oBefore + "<li id3='" + i
			+ "'><a class='selectedPage' href='javascript:showPage(" + i
			+ ",\"" + type + "\")'>" + i.toString() + "</a></li>" + oAfter
			+ "</ul>";
	document.getElementById("jslarge").innerHTML = oPaging;
}

function pagination(c, m) {
	var current = c, last = m, delta = 2, left = current - delta, right = current
			+ delta + 1, range = [], rangeWithDots = [], l;

	for (var i = 1; i <= last; i++) {
		if (i == 1 || i == last || i >= left && i < right) {
			range.push(i);
		}
	}

	for ( var i in range) {
		if (l) {
			if (i - l === 2) {
				rangeWithDots.push(l + 1);
			} else if (i - l !== 1) {
				rangeWithDots.push('...');
			}
		}
		rangeWithDots.push(i);
		l = i;
	}
	console.log(rangeWithDots);
	return rangeWithDots;
}

function drawPagination(pageRequested, type) {
	document.getElementById("jslarge").innerHTML = "";
	pageRequested = 0;
	makePaging(totalPages, pageRequested, type);
	pagination(pageRequested, totalPages);
}

function showPage(page, type) {
	console.log("showPage...");
	pageRequested = page;
	initTable(type);
}

function stringToDate(_date, _format, _delimiter) {
	var formatLowerCase = _format.toLowerCase();
	var formatItems = formatLowerCase.split(_delimiter);
	var dateItems = _date.split(_delimiter);
	var monthIndex = formatItems.indexOf("mm");
	var dayIndex = formatItems.indexOf("dd");
	var yearIndex = formatItems.indexOf("yyyy");
	var month = parseInt(dateItems[monthIndex]);
	month -= 1;
	var formatedDate = new Date(dateItems[yearIndex], month,
			dateItems[dayIndex]);
	return formatedDate;
}

function getDateByFormat(d) {
	var m = (d.getMonth() + 1);
	var t = d.getDate();
	var y = d.getFullYear();
	var s = t + "/" + m + "/" + y;
	return s;
}

function dateInitialization() {
	/** ****************** Date Piker ********************* */
	var today1 = stringToDate(getDateByFormat(new Date()), "dd/mm/yyyy", "/");
	YUI().use('aui-datepicker', 'aui-form-validator', function(Y) {
		new Y.DatePicker({
			trigger : '#' + namespace + 'toDate',
			mask : '%d/%m/%Y',
			popover : {
				zIndex : 1
			},
			calendar : {
				dateFormat : '%Y-%m-%d'
			}
		});
	});

	var today2 = stringToDate(getDateByFormat(new Date()), "dd/mm/yyyy", "/");
	YUI().use('aui-datepicker', 'aui-form-validator', function(Y) {
		new Y.DatePicker({
			trigger : '#' + namespace + 'fromDate',
			mask : '%d/%m/%Y',
			popover : {
				zIndex : 1
			},
			calendar : {
				dateFormat : '%Y-%m-%d'
			}
		});
	});

}

var pendingTransColumns = [ "Title", "Due Date & Time", "Reference ID",
		"Amount(SGD)", "Actions" ];
var historyTransColumns = [ "Title", "Date & Time", "Reference ID",
		"Amount(SGD)", "Actions" ];

function clearTableData() {
	var heading = document.getElementById("tableId").getElementsByClassName(
			"Heading")[0];
	heading.innerHTML = "";
	var body = document.getElementById("tableId")
			.getElementsByClassName("Body")[0];
	body.innerHTML = "";
}

var oldFromDate;
var oldToDate;
setInterval(function() {
	var currFd = document.getElementById(namespace + "fromDate").value;
	var currTd = document.getElementById(namespace + "toDate").value;
	var reload = false;
	if (oldFromDate && currFd != oldFromDate) {
		reload = true;
	}
	if (oldToDate && currTd != oldToDate) {
		reload = true;
	}
	if (reload) {
		reloadTable();
	}
	oldFromDate = currFd;
	oldToDate = currTd;
}, 1000);

function initTable(type) {
	showLoading(true);
	clearTableData();
	this.type = type;
	var columnsToShow;
	if (type == "pending")
		columnsToShow = pendingTransColumns;
	else
		columnsToShow = historyTransColumns;

	var table = document.getElementById("tableId");
	var tbody = document.querySelector("#tableId tbody");
	var allheadings = document.querySelectorAll("#tableId .Heading")[0];
	var allrows = document.querySelectorAll("#tableId .Body")[0];

	var a;

	var itemsSelect = document.getElementById(namespace + "itemsPerPage");
	itemsPerPage = itemsSelect.options[itemsSelect.selectedIndex].value;

	var datas = {};
	datas.fromDate = document.getElementById(namespace + "toDate").value;
	datas.toDate = document.getElementById(namespace + "fromDate").value;
	if (type == "pending") {
		datas.status = "Pending";
		var dropEle = document.getElementById(namespace + "dispFilter");
		var selText = dropEle.options[dropEle.selectedIndex].text;
		if (selText == "All") {
			datas.categoryList = categoryMap["IN"] + ',' + categoryMap["CN"];
		} else if (selText == "Receive Payments") {
			datas.categoryList = categoryMap["CN"];
		} else {
			datas.categoryList = categoryMap["IN"];
		}
	} else {
		datas.status = "Confirmed";
		var dropEle1 = document.getElementById(namespace + "dispFilter1");
		var selText1 = dropEle1.options[dropEle1.selectedIndex].text;
		if (selText1 == "All") {
			datas.categoryList = categoryMap["RE"] + ',' + categoryMap["CN"];
		} else if (selText1 == "Receipts") {
			datas.categoryList = categoryMap["CN"];
		} else {
			datas.categoryList = categoryMap["RE"];
		}
	}
	datas.sortBy = "txn_date,desc";
	datas.page = (pageRequested - 1);
	datas.size = itemsPerPage;
	datas.formType = "transactionmaster";
	console.log("data : " + JSON.stringify(datas));
	ajaxCallAPI(
			'GET',
			"walletlist",
			datas,
			function(response) {
				var data = this.get("responseData");
				if (typeof data !== "undefined") {
					
					totalRecords = data.totalElements;
					totalPages = data.totalPages;
					if(pageRequested == 1){
						drawPagination(pageRequested, type)
					} else {
						console.log("type : "+type);
						makePaging(totalPages, pageRequested-1, type);
						pagination(pageRequested, totalPages);
					}
					
					var a = data.content;
					if (a.length > 0) {

						for (var j = 0; j < columnsToShow.length; j++) {
							var th = document.createElement('th');
							var italic = document.createElement('i');
							var text = document
									.createTextNode(columnsToShow[j]);
							th.appendChild(text);
							th.appendChild(italic);
							if (sortbyArray.length > 0
									&& sortbyArray.field == columnsToShow[j]) {
								th.classList.add("listsort"
										+ sortbyArray.direction);
							}
							// if(j == 0) th.style.display = "none";
							allheadings.appendChild(th);
						}
					}
					for (var c = 0; c < a.length; c++) {
						var tr = document.createElement('tr');

						// title
						var td = document.createElement('td');
						var tdElement = document.createTextNode(a[c][1]);
						td.appendChild(tdElement);
						tr.appendChild(td);

						// due date
						td = document.createElement('td');
						tdElement = document.createTextNode(a[c][2]);
						td.appendChild(tdElement);
						tr.appendChild(td);

						// refid
						var contentJson = JSON.parse(a[c][5]);
						td = document.createElement('td');
						tdElement = document
								.createTextNode(contentJson.ExtRefNumber);
						td.appendChild(tdElement);
						tr.appendChild(td);

						// amount
						var para = document.createElement('p');
						td = document.createElement('td');
						if (categoryMap["IN"] == a[c][6]
								|| categoryMap["RE"] == a[c][6]) {
							para.innerHTML = "&rarr;" + " " + a[c][4];
							para.classList.add("IconArrow");
						} else {
							para.innerHTML = "&larr;" + " " + a[c][4];
							para.classList.add("IconArrow2");
						}
						td.appendChild(para);
						tr.appendChild(td);

						// actions
						td = document.createElement('td');
						if (categoryMap["IN"] == a[c][6]) {
							tdElement = '<button class="btn btn-default" onclick="payOnline(\''+contentJson.TransactionMasterCode+'\')">PAY ONLINE</button>';
						} else if (categoryMap["CN"] != a[c][6]) {
							tdElement = '<button class="btn btn-default" onclick="viewDetails(\''+contentJson.TransactionMasterCode+'\')">VIEW DETAILS</button>';
						}
						td.innerHTML = tdElement;
						tr.appendChild(td);
						allrows.appendChild(tr);
					}
				}
				showLoading(false);
			}, function() {
				showLoading(false);
			});
}

function payOnline(storageId) {
	window.open(payOnlineBaseUrl+"?id="+(storageId.toUpperCase().trim()));
}

function viewDetails(storageId) {
	window.open(receiptBaseUrl+"?p_p_id=transaction_WAR_SPFinanceportlet&p_p_lifecycle=0&p_p_state=normal&_transaction_WAR_SPFinanceportlet_jspPage=%2Fhtml%2Ftransaction%2Fview.jsp&_transaction_WAR_SPFinanceportlet_formTypeName=TransactionMaster&_transaction_WAR_SPFinanceportlet_storageId="+(storageId.toUpperCase().trim()));
}


function reloadTable() {
	console.log("reloadTable...");
	pageRequested = 1;
	initTable(this.type);
	/*
	 * else { makePaging(totalPages, pageRequested-1,this.type);
	 * pagination(pageRequested, totalPages); }
	 */
}

function ajaxCall(method, action, ajaxUrl, data, successHandler, failHandler) {
	var thisInstance = this;

	thisInstance.namespace = namespace;
	AUI()
			.use(
					'aui-base',
					'aui-io-request-deprecated',
					function(A) {
						var _data = {};
						_data[thisInstance.namespace + 'formStorageId'] = "";
						if (action == "update" || action == "loadData"
								|| action == "loadList" || action == "archive"
								|| action == "exportRow") {
							_data[thisInstance.namespace + 'formStorageId'] = data.formStorageId;
						}
						_data[thisInstance.namespace + 'formType'] = data.formType;
						_data[thisInstance.namespace + 'action'] = action;
						if (action == "update")
							_data[thisInstance.namespace + 'action'] = "persist";
						if (data) {
							_data[thisInstance.namespace + 'data'] = JSON
									.stringify(data);
						}
						A.io
								.request(
										ajaxUrl,
										{
											dataType : 'json',
											method : method,
											data : _data,
											on : {
												success : successHandler,
												failure : failHandler
														|| function() {
															thisInstance
																	.debug("Error in the ajax call.");
														}
											}
										});
					});
}

function getPendingPaymets() {
	document.getElementById("btnPendingPmnts").classList.remove("btnPmt");
	document.getElementById("btnPendingPmnts").classList.add("btnSel");

	document.getElementById("btnHistPmnts").classList.remove("btnSel");
	document.getElementById("btnHistPmnts").classList.add("btnPmt");

	document.getElementById("dispFilterDiv").classList.remove("dispFilter1");
	document.getElementById("dispFilterDiv").classList.add("dispFilter");

	document.getElementById("dispFilterDiv1").classList.remove("dispFilter");
	document.getElementById("dispFilterDiv1").classList.add("dispFilter1");

	pageRequested = 1;

	initTable("pending");

	if (pageRequested == 1) {
		drawPagination(pageRequested, "pending");
	} else {
		makePaging(totalPages, pageRequested - 1, "pending");
		pagination(pageRequested, totalPages);
	}
}

function getHistoryPaymets() {
	document.getElementById("btnPendingPmnts").classList.remove("btnSel");
	document.getElementById("btnPendingPmnts").classList.add("btnPmt");

	document.getElementById("btnHistPmnts").classList.remove("btnPmt");
	document.getElementById("btnHistPmnts").classList.add("btnSel");

	document.getElementById("dispFilterDiv").classList.remove("dispFilter");
	document.getElementById("dispFilterDiv").classList.add("dispFilter1");

	document.getElementById("dispFilterDiv1").classList.remove("dispFilter1");
	document.getElementById("dispFilterDiv1").classList.add("dispFilter");

	pageRequested = 1;

	initTable("history");

	if (pageRequested == 1) {
		drawPagination(pageRequested, "history");
	} else {
		makePaging(totalPages, pageRequested - 1, "history");
		pagination(pageRequested, totalPages);
	}
}

var walletAmountLoaded = false;
var walletListLoaded = false;
function init() {
	dateInitialization();
	populateCommonDropdownData("dispFilter", pendingDisplayFilterList,
			function() {
			});
	populateCommonDropdownData("dispFilter1", historyDisplayFilterList,
			function() {
			});
	initTable("pending");
	if (pageRequested == 1) {
		drawPagination(pageRequested, "pending");
	}
	getWalletAmount(
			"candidate",
			function(credit) {
				walletAmountLoaded = true;
				document.getElementsByClassName("balAmtVal")[0].innerHTML = formatNumbers(credit);
			});
}

if (document.readyState == 'complete') {
	init();
} else {
	window.addEventListener('load', init);
}
