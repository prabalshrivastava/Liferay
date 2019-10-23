var A;
function spinbox(configObj){
	
/*	var INBOX = 'inbox';
	var ARCHIVED = 'archived';
	var DRAFTS = 'drafts';
	var SENT = 'sent'; */
	var ajaxUrl;
	
	var searchtext;
	//inbox,sent,draft..
	var category;
	// Indicates whether is is search or not.
	var isSearch;
	//invitation, alert,notificaiton ..
	var subcategory;
	// currently viewing / selected page num
	var currentPageNum;
	
	// read, unread, replied or forwarded
	var deleteSelectedDiv;
	var archievSelectedDiv;
	var filter1;
	var filters;
	var folderHeading;
	var conentHeader;
	var mailsTable;
	var contentFooter;
	var nextPage;
	var lastPage;
	var firstPage;
	var prevPage;
	var nextPageDiv;
	var lastPageDiv;
	var firstPageDiv;
	var prevPageDiv;
	var totalPageCountSpan;
	var acrhieveLink;
	var deleteLink;
	var actions;
	// to hold text like "Showing 1 - 10 of 1322 results"
	var showingMails;
	var selectAll;
	var pageNums;
	var sampleMailRowHeader;
	var sampleMailRow;
	
	var selectChkBoxId = "select";

	// it is used as an id of table rows
	var mailRowId = "mailRow";
	// it is used to hold either msgdetailid or msgId based on context ( drafts, inbox,archive ...)
	var rowId = "rowId";
	//var A;
	var inboxDiv;
	var inboxMsg;
	var unreadInbCount,unreadReqCount,unreadNotfCount,unreadInvCount,unreadGrpAlertCount,unreadJobAlertCount;
	var unreadObj;
	// Holds the json format of the messages loaded in current page
	var currentPageJsons;

	var webSockconfigObj;
	this.setInboxMsg = function(inbMsg){
		inboxMsg = inbMsg;
	}
	function initialize(configObj){
	//	A = AUI().use('aui-node','aui-base', 'aui-io-request-deprecated');
		ajaxUrl = configObj.ajaxUrl;
		category = configObj.category;
		subcategory = configObj.subcategory;
		webSockconfigObj = configObj.webSockconfigObj;
		
		initializePageElements();
		intializePageNumsChangeListener();
		intializtPageNavLinks();
		
		initializeMsgFilters();
		
		initializeArchive();
		initializeDelete();
		
		initializeWebsockets();
		//initializeSearch();
	};
	
	function initializePageElements(){
		
		//main inbox div
		inboxDiv = A.one("#inboxDiv");
		
		// Header related
		folderHeading = A.one("#folderHeading");
		filter1 = A.one("#filter1");
		filters = A.one("#filters");
		conentHeader = A.one("#contetHeaderDiv");
		deleteSelectedDiv = A.one("#deleteSelectedDiv");
		archievSelectedDiv = A.one("#archievSelectedDiv");
		
		// Mails Table
		mailsTable = A.one("#mailsTable");
		selectAll = A.one("#selectAll");
		
		// Footer related
		contentFooter = A.one("#contentFooter");
		showingMails = A.one("#showingMails");
		pageNums = A.one("#pageNums");
		totalPageCountSpan = A.one("#totalPageCountSpan");
		
		nextPage = A.one("#nextPage");
		lastPage = A.one("#lastPage");
		firstPage = A.one("#firstPage");
		prevPage = A.one("#prevPage");
		nextPageDiv = A.one("#nextPageDiv");
		lastPageDiv = A.one("#lastPageDiv");
		firstPageDiv = A.one("#firstPageDiv");
		prevPageDiv = A.one("#prevPageDiv");
		
		// Sample templates
		sampleMailRow = A.one("#sampleMailRow");
		sampleMailRowHeader = A.one("#sampleMailRowHeader");
		
		// Actions
		actions = A.one("#actions");
		acrhieveLink = A.one('#archieve');
		deleteLink = A.one('#delete');
		
		
		// Unread message counts
		unreadInbCount = A.one("#unreadInbCount");
		unreadReqCount = A.one("#unreadReqCount");
		unreadNotfCount = A.one("#unreadNotfCount");
		unreadInvCount = A.one("#unreadInvCount");
		unreadGrpAlertCount = A.one("#unreadGrpAlertCount");
		unreadJobAlertCount = A.one("#unreadJobAlertCount");
		
		searchtext = A.one("#searchtext");
	};
	
	function intializePageNumsChangeListener(){
		pageNums.on("change", function(){
			fetchDataAndRenderTable(pageNums.val());
		});
	}
	function intializtPageNavLinks(){
		nextPage.on("click", function(){
			var currentNum = parseInt(pageNums.val() );
			var next = currentNum + 1;
			fetchDataAndRenderTable(next);
		});
		prevPage.on("click", function(){
			var currentNum = parseInt(pageNums.val() );
			var prev = currentNum - 1;
			if(prev >= 1 ){
				fetchDataAndRenderTable(prev);
			}
		});
		firstPage.on("click", function(){
			fetchDataAndRenderTable(1);
		});
		lastPage.on("click", function(){
			fetchDataAndRenderTable(-1);
		});
	}
	
	function initializeMsgFilters(){
		filter1.on("change",function(){
			var dataObj = {
					source:'filter1'
			}
			fetchDataAndRenderTable(1,dataObj);
		});
	}
	
	function initializeSelectAll(){
		selectAll.on("change",function(){
			mailsTable.all("#select").set('checked',selectAll.get('checked'));
			showHideActions();
		});
	}
	
	function initializeArchive(){
		acrhieveLink.on("click",function(){
			archiveAction();
		});
	}
	function initializeDelete(){
		deleteLink.on("click",function(){
			deleteAction();
		});
	}
	
	function setSelectEvent(){
		var selectRows = A.all(".checkBoxMailRow");
		selectRows.on("change",function(event){
			setSelectedBgColor(event);
		});
	}
	
	function setSelectedBgColor(e){
		var selectAll = e.currentTarget;
		var selectAllParent = selectAll.get('parentNode').get('parentNode')
		if(selectAll.get('checked')){
			selectAllParent.addClass('msgRowSelected');
		}else{
			selectAllParent.removeClass('msgRowSelected');
		 }
	}
	
	function setAllSelectEvent(){
		var selectAll = A.one("#selectAll");
		selectAll.on("change",function(){
			setAllSelectedBgColor();
		});
	}
	
	function setAllSelectedBgColor(){
		var inboxListRow = A.all(".inboxListRow");
		var selectAll = A.one("#selectAll");
		if(selectAll.get('checked')){
			 for (var i = 0; i < inboxListRow.size(); i++) {
				 inboxListRow.addClass('msgRowSelected');
			 }
		}else{
			for (var i = 0; i < inboxListRow.size(); i++) {
				inboxListRow.removeClass('msgRowSelected');
			}	
		 }
	}
	
	function initializeWebsockets(){
		try{
			var stompClient = null;
			var username = webSockconfigObj.screenName; // '<%=themeDisplay.getUser().getScreenName()%>';
			var communityName = webSockconfigObj.communityName;// '${communityName}';
			var websocketUrl = webSockconfigObj.websocketUrl + "/connect";//'${websocketUrl}/connect';
			//var filterType = configObj.filterType; //'<%=filterType %>';
			var socket = null;
			function connect(username) {
				try{
					socket = new SockJS(websocketUrl);
				/*	websocketUrl = 'wss' + websocketUrl.slice(5);
					socket = new WebSocket(websocketUrl);
					    //websocket.onopen = function(evt) { onOpen(evt) };
					    //websocket.onmessage = function(evt) { onMessage(evt) };
					    socket.onclose = function(){
							console.log("closed");
							//connect(username);
						};
						socket.onerror = function(){
							console.log("Error");
							connect(username);
						} */
					stompClient = Stomp.over(socket);
					stompClient.connect({}, function(frame) {
						console.log('Connected: ' + frame);
						var subscribeUrl = '/user/' + username + '/' + communityName + '/inboxnotifications';
						
						stompClient.subscribe(subscribeUrl, function(activityFeed) {
							/* {"className":"com.liferay.portlet.blogs.model.BlogsEntry","classPK":1,"type":1} */
							var noteJson = JSON.parse(activityFeed.body);
							if(noteJson){
								var tempMail = {
										rowId : noteJson.msgDetailId,
										msgDetailId: noteJson.msgDetailId,
										from : noteJson.from,
										subject: noteJson.subject,
										date: noteJson.date
								};
								addMailRow(tempMail,true);
								currentPageJsons.unshift(tempMail);
								currentPageJsons.pop();
								removeLastMailRow();
							}
							
							
						});
					});
					
				}catch(err) {
					//alert(err);
					console.log(err);
				}
			}
			
			function disconnect() {
				if(stompClient){
					stompClient.disconnect();
					//setConnected(false);
					console.log("Disconnected");
				}
			}
			
			connect(username);
			window.onbeforeunload = function(e) {
				disconnect();
			};
		}catch(error){
			
		}
	}
	
	function show(node){
		if(node){
			node.addClass('show-content');
			node.removeClass('hide-content');
		}
	}
	function hide(node){
		if(node){
			node.addClass('hide-content');
			node.removeClass('show-content');
		}
	}
	
	 this.hideInbox = function(){
		hide(inboxDiv);
	}
	
	this.showInbox = function(){
		show(inboxDiv);
		inboxMsg.hideInboxMsg();
	}
	
	function hideFooterPageLinks(){
		hide(firstPageDiv);
		hide(lastPageDiv);
		hide(nextPageDiv);
		hide(prevPageDiv);
	}
	
	function showHideActions(){
		if(category != spInbCons.ARCHIVED){
			var count = getSelectedRowCount();
			if(count > 0){
				show(actions);
			}else{
				hide(actions);
			}
		}
	}
	function showHideFilters(flag){
		if(isInbox() || isArchived()){
			if(flag){
				show(filters);
			}else{
				hide(filters);
			}
		}else{
			hide(filters);
		}
	}
	
	function isInbox(){
		if(category == spInbCons.INBOX){
			return true;
		}
		else {
			return false;
		}
	}
	function isSent(){
		if(category == spInbCons.SENT){
			return true;
		}
		else {
			return false;
		}
	}
	function isDrafts(){
		if(category == spInbCons.DRAFTS){
			return true;
		}
		else {
			return false;
		}
	}
	function isArchived	(){
		if(category == spInbCons.ARCHIVED){
			return true;
		}
		else {
			return false;
		}
	}
	function isRequestType(){
		if(subcategory == spInbCons.REQUEST){
			return true;
		}
		else {
			return false;
		}
	}
	function isInvitiaitonType(){
		if(subcategory == spInbCons.INVITATION){
			return true;
		}
		else {
			return false;
		}
	}
	function isNotificationType(){
		if(subcategory == spInbCons.NOTIFICATION){
			return true;
		}
		else {
			return false;
		}
	}
	function isGroupAlertType(){
		if(subcategory == spInbCons.REPORT_ALERT){
			return true;
		}
		else {
			return false;
		}
	}
	function isJobAlertType(){
		if(subcategory == spInbCons.JOBS_ALERT){
			return true;
		}
		else {
			return false;
		}
	}
	
	initialize(configObj);
	
	function clearMailsTable(){
		mailsTable.all("tr").remove();
		var tempHeader = sampleMailRowHeader.clone();
		tempHeader.set("id","mailHeaderRow");
		selectAll = tempHeader.one("#sampleSelectAll");
		selectAll.set("id","selectAll");
		mailsTable.append(tempHeader);
		if(isArchived()){
			hide(tempHeader.one("td"));
		}
		initializeSelectAll();
		setAllSelectEvent();
	}
	
	
	function renderInboxHeader(){
		folderHeading.set('text', "Inbox");
		hide(deleteSelectedDiv);
		show(archievSelectedDiv);
		//show(filters);
		
	};
	function renderSearchHeader(){
		folderHeading.set('text', "Search");
		hide(deleteSelectedDiv);
		show(archievSelectedDiv);
		showHideFilters();
		//show(filters);
		
	};
	function renderArchivedHeader(){
		folderHeading.set('text', "Archived");
		hide(deleteSelectedDiv);
		hide(archievSelectedDiv);
		//show(filters);
	};
	function renderDraftsHeader(){
		folderHeading.set('text', "Drafts");
		show(deleteSelectedDiv);
		hide(archievSelectedDiv);
		showHideFilters();
	};
	function renderSentHeader(){
		folderHeading.set('text', "Sent");
		show(deleteSelectedDiv);
		hide(archievSelectedDiv);
		showHideFilters();
	};
	
	function renderMailsTable(mails,dataObj){
		clearMailsTable();
		currentPageJsons =  mails;
		var isEmpty = (!mails || mails.length <= 0) ? true:false;
		if(!isEmpty){
			showHideFilters(true);
			for(var i = 0 ; i < mails.length; i++){
				var mail = mails[i];
				addMailRow(mail);
			}
		}
		if(isEmpty){

			var row = A.one("#nomessagesRow").clone();
			var prefix = 'No messages in ';
			var temp = category;
			 if(isSent()){
				temp = prefix + "Sent";
			}else if(isDrafts()){
				temp = prefix +  "Drafts";
			}else if(isArchived()){
				temp = prefix +  "Archived";
			}else if(isRequestType()){
				temp = prefix +  "Requests" ;
			}else if(isInvitiaitonType()){
				temp = prefix +  "Invitations" ;
			}else if(isNotificationType()){
				temp = prefix +  "Notifications" ;
			}else if(isGroupAlertType()){
				temp = prefix +  "Group Alerts" ;
			}else if(isJobAlertType()){
				temp = prefix +  "Job Alerts";
			}else{
				temp = prefix +  "Inbox";
			}
			
			row.one("td").set('text',  temp);
			mailsTable.append(row);
			if(dataObj.source == 'filter1'){
				showHideFilters(true);
			}else{
				showHideFilters(false);
			}
		
		}
		showHideActions();
	};
	
	function addMailRow(mail,insertASFirstRow){
		if(mail){
			var row = sampleMailRow.clone();
			row.set("id", mailRowId);
			row.one("#sampleSelect").set("id",selectChkBoxId);
			setSelectEvent();
			row.one("#sampleRowId").set("id",rowId);
			
			row.one("#"+selectChkBoxId).on("click",function(e){
				 showHideActions();
				 e.stopPropagation();
			});
			
			row.one("#"+rowId).val(mail["rowId"]);
			row.one("#from").set('text',mail["from"]);
			row.one("#subject").set('text',mail["subject"]);
			row.one("#date").set('text',mail["date"]);
			row.on("click",function(event){
				showMessageDetails(this.one("#"+rowId).val());
				markRowAsRead(row);
			})
			var rowClass = "msgRead inboxListRow";
			if(category == spInbCons.INBOX || category == spInbCons.ARCHIVED){
				if(mail["unread"] == true){
					rowClass = "msgUnread inboxListRow";
				}
			}
			if(isArchived()){
				//hide(row.one("#selectAllTd"));
				hide(row.one("td"));
			}
			row.addClass(rowClass);
			if(insertASFirstRow){
				mailsTable.insert(row,2);
			}else{
				mailsTable.append(row);
			}
		}
	}
	
	function markRowAsRead(row){
		row.removeClass("msgUnread");
		row.addClass("msgRead");
	}
	
	function markRowASUnRead(row){
		row.addClass("msgUnread");
		row.removeClass("msgRead");
	}
	
	function getJsonForRowId(rowId){
		var temp = null;
		if(currentPageJsons && currentPageJsons.length > 0){
			for(var i = 0 ; i < currentPageJsons.length; i++){
				var mail = currentPageJsons[i];
				if(mail["rowId"] == rowId){
					temp = mail;
					break;
				}
			}
		}
		
		return temp;
	}
	
	function showMessageDetails(rowId){
		if(currentPageJsons && currentPageJsons.length > 0){
			var temp = getJsonForRowId(rowId);
		/*	for(var i = 0 ; i < currentPageJsons.length; i++){
				var mail = currentPageJsons[i];
				if(mail["rowId"] == rowId){
					temp = mail;
					break;
				}
			} */
			if(temp){
				if(isDrafts()){
					inboxMsg.setCategory(spInbCons.DRAFT);
				}else{
					inboxMsg.setCategory(spInbCons.VIEW_MSG);
				}
				inboxMsg.render(temp);
				if(temp.msgDetailId){
					updateMsgStatus(temp.msgDetailId);
				}
				setUnreadCountAfteRowClick();
			}
		}
	}
	function renderFooter(fdata){
		if(fdata){
			show(contentFooter);
			if(fdata.totalMails){
				if(fdata.totalMails <= 1){
					showingMails.set('text','Showing ' +  fdata.totalMails + ' result');
				}else{
					showingMails.set('text', 'Showing ' + fdata.start + " - " + fdata.end + ' of ' + fdata.totalMails + " results");
				}
			}else{
				showingMails.set('text','');
			}

			pageNums.all("option").remove();
			
			if(fdata.totalPageCount && fdata.totalPageCount > 0){
				show(contentFooter);
				for(var i = 1 ; i <= fdata.totalPageCount; i++){
					var option = A.Node.create("<option></option>");
					option.set("value", i);
					option.set("text",i);
					pageNums.append(option);
				}
				pageNums.val(fdata.currentPage);
				totalPageCountSpan.set('text',' ');
				totalPageCountSpan.set('text',' of ' + fdata.totalPageCount);
			}else{
				hide(contentFooter);
			}

			hideFooterPageLinks();
			if(fdata.currentPage >= 2 ){
				show(firstPageDiv);
			}
			if(fdata.currentPage > 1 ){
				show(prevPageDiv);
			}
			if(fdata.currentPage < fdata.totalPageCount ){
				show(nextPageDiv);
			}
			if(fdata.currentPage < (fdata.totalPageCount) ){
				show(lastPageDiv);
			}
		}else{
			hide(contentFooter);
		}
	};
	
	function removeLastMailRow(){
		if(mailsTable.all("tr").size() > 10){
			mailsTable.one("tr:last-child").remove();
		}
	}
	this.render= function(){
		if(category == spInbCons.INBOX){
			renderInboxHeader();	
		}else if(category == spInbCons.ARCHIVED){
			renderArchivedHeader();
		}else if(category == spInbCons.DRAFTS){
			renderDraftsHeader();
		}else if(category == spInbCons.SENT){
			renderSentHeader();
		}
		var dataObj = {
			getUnreadCounts: true
		};
		fetchDataAndRenderTable(1,dataObj);
		//renderFooter();
		this.showInbox();
	};
	
	function setUnreadCount(){
		if(unreadObj){
			setUnreadCountForNode(unreadInbCount,unreadObj.unreadInbCount);
			setUnreadCountForNode(unreadReqCount,unreadObj.unreadReqCount);
			setUnreadCountForNode(unreadInvCount,unreadObj.unreadInvCount);
			setUnreadCountForNode(unreadNotfCount,unreadObj.unreadNotfCount);
			setUnreadCountForNode(unreadGrpAlertCount,unreadObj.unreadGrpAlertCount);
			setUnreadCountForNode(unreadJobAlertCount,unreadObj.unreadJobAlertCount);
		}
	}
	
	function setUnreadCountForNode(nodeObj,count){

		if(nodeObj ){
			if( count && count > 0){
				show(nodeObj);
				nodeObj.set('text',  count);
			}else{
				hide(nodeObj);
				nodeObj.set('text', "");
				
			}
		}
	
	}
	
	function setUnreadCountAfteRowClick(mailObj){
		if(category == spInbCons.INBOX && unreadObj){
			reduceUnreadeCountByOne("unreadInbCount");
			if(subcategory == ""){
			}else if(subcategory == spInbCons.REQUEST){
				reduceUnreadeCountByOne("unreadReqCount");
			}else if(subcategory == spInbCons.NOTIFICATION){
				reduceUnreadeCountByOne("unreadNotfCount");
			}else if(subcategory == spInbCons.INVITATION){
				reduceUnreadeCountByOne("unreadInvCount");
			}else if(subcategory == spInbCons.REPORT_ALERT){
				reduceUnreadeCountByOne("unreadGrpAlertCount");
			}else if(subcategory == spInbCons.JOBS_ALERT){
				reduceUnreadeCountByOne("unreadJobAlertCount");
			}
			
			setUnreadCount();
		}
	}
	
	function reduceUnreadeCountByOne(prop){
		if(unreadObj && prop){
			if(unreadObj[prop] && unreadObj[prop] > 0){
				unreadObj[prop] = unreadObj[prop] - 1;
			}
		}
	}
	
	function archiveAction(){
		var dataObj = { };
		dataObj["action"] = "archieveAndfetchData";
		dataObj["msgDetailIds"] = getSelectedIds();
		dataObj["getUnreadCounts"]= true
		fetchDataAndRenderTable(pageNums.val(),dataObj);
	}
	function deleteAction(){
		var dataObj = { };
		dataObj["action"] = "deleteAndfetchData";
		dataObj["msgDetailIds"] = getSelectedIds();
		dataObj["getUnreadCounts"]= true
		fetchDataAndRenderTable(pageNums.val(),dataObj);
		//showHideActions();
	}
	
	function getSelectedIds(){
		var rows = mailsTable.all("#" + mailRowId);
		var msgDetailIds = "";
		for(var i = 0; i < rows.size(); i++){
			var row = rows.item(i);
			if(row.one("#" + selectChkBoxId).get('checked')){
				msgDetailIds = msgDetailIds + "," + row.one("#" + rowId).val();
			}
		}
		return msgDetailIds;
	}
	function getSelectedRowCount(){
		var rows = mailsTable.all("#" + mailRowId);
		var cnt = 0;
		for(var i = 0; i < rows.size(); i++){
			var row = rows.item(i);
			if(row.one("#" + selectChkBoxId).get('checked')){
				cnt = cnt + 1 ;
			}
		}
		return cnt;
	}
	
	this.setCategory =function(catg){
		category = catg;
	};
	this.getCategory =function(){
		return category ;
	};
	this.setSubcategory =function(catg){
		subcategory= catg;
	};
	this.getSubcategory =function(){
		return subcategory;
	};
	
	this.setSearchFlag = function(flag){
		isSearch = flag;
	};
	this.isSearch = function(){
		return isSearch;
	}
	
	
	
	function fetchDataAndRenderTable(pageNum,dataObj){
		if(!dataObj){
			dataObj = { };
		}
		if(!pageNum){
			pageNum=1;
		}
		dataObj["pageNum"] = pageNum;
		dataObj["category"] = category;
		dataObj["subcategory"] = subcategory;
		
		if(isSearch){
			dataObj["action"] = "search";	
			dataObj["searchText"] = searchtext.val();	
		}
		
		if(!dataObj["action"]){
			dataObj["action"] = "getMails";
		}
		
		if(filter1){
			dataObj["filter"] = filter1.val();
		}
		
		A.io.request(ajaxUrl,{
			dataType : 'json',
			method : 'POST',
			data : dataObj,
			on : {
				success : function() {
					var data = this.get('responseData');
					if(data && data.errorMsg){
						alert(data.errorMsg);
					}else{
						var mails = data ? data.mails:null;
						renderMailsTable(mails,dataObj);
						renderFooter(data);
						if(dataObj.getUnreadCounts){
							unreadObj = data.unreadObj;
							setUnreadCount(data.unreadObj);
						}
					}
				},
				failure : function(){
					var data = this.get('responseData');
					if(data && data.errorMsg){
						alert(data.errorMsg);
					}else{
						alert("Error");
					}
				}
			}
		});
	}
	function updateMsgStatus(msgDetailId,dataObj){
		if(!dataObj){
			dataObj = { };
		}
		if(!dataObj["action"]){
			dataObj["action"] = "updateMsgStatusRead";
		}
		dataObj["msgDetailId"] = msgDetailId;
		
		A.io.request(ajaxUrl,{
			dataType : 'json',
			method : 'POST',
			data : dataObj,
			on : {
				success : function() {
					var data = this.get('responseData');
					if(data && data.errorMsg){
					}else{
					}
				},
				failure : function(){
				}
			}
		});
	}
	
	function resetFilter1(){
		filter1.val("All");
	}
	
	this.renderInbox = function(){
		this.setCategory(spInbCons.INBOX);
		this.setSubcategory("");
		this.setSearchFlag( false);
		resetFilter1();
		this.render();
	}
	
	this.renderSearch = function(){
		//this.setCategory(spInbCons.SEARCH);
		//this.setSubcategory(spInbCons.SEARCH);
		var flag = false;
		if(isSearch){
			var searchVal = searchtext.val() ;
			searchVal = searchVal ? searchVal :"";
			searchVal = searchVal.trim();
			if(searchtext.val() == ""){
				this.setSearchFlag( false);
				resetFilter1();
				this.render();
			}else{
				flag = true;
			}
		}else{
			flag = true;
		}
		if(flag){
			if(searchtext.val() != ""){
				this.setSearchFlag( true);
				resetFilter1();
				this.render();
			}
		}
	}
	
	this.renderRequests = function(){
		this.setCategory(spInbCons.INBOX);
		this.setSubcategory(spInbCons.REQUEST);
		this.setSearchFlag( false);
		resetFilter1();
		this.render();
	}
	
	this.renderInvitations = function(){
		this.setCategory(spInbCons.INBOX);
		this.setSubcategory(spInbCons.INVITATION);
		this.setSearchFlag( false);
		resetFilter1();
		this.render();
	}
	
	this.renderNotifications = function(){
		this.setCategory(spInbCons.INBOX);
		this.setSubcategory(spInbCons.NOTIFICATION);
		this.setSearchFlag( false);
		resetFilter1();
		this.render();
	}
	
	this.renderGroupAlerts = function(){
		this.setCategory(spInbCons.INBOX);
		this.setSubcategory(spInbCons.REPORT_ALERT);
		this.setSearchFlag( false);
		resetFilter1();
		this.render();
	}
	
	this.renderJobAlerts = function(){
		this.setCategory(spInbCons.INBOX);
		this.setSubcategory(spInbCons.JOBS_ALERT);
		this.setSearchFlag( false);
		resetFilter1();
		this.render();
	}
	
	this.renderArhived = function(){
		this.setCategory(spInbCons.ARCHIVED);
		this.setSubcategory("");
		this.setSearchFlag( false);
		resetFilter1();
		this.render();
	}
	
	this.renderDrafts = function(){
		this.setCategory(spInbCons.DRAFTS);
		this.setSubcategory("");
		this.setSearchFlag( false);
		this.render();
	}
	
	this.renderSent = function(){
		this.setCategory(spInbCons.SENT);
		this.setSubcategory("");
		this.setSearchFlag( false);
		this.render();
	}
	
};
function initialize(ajaxUrl,initialView,webSockconfigObj){
	var inbox = null;
	var archivedMsgs = null;
	var draftMsgs = null;
	var sentMsgs = null;
	var inboxMsg = null;
	

	AUI().use('aui-node','aui-base', 'aui-io-request-deprecated',function(A1){
		A = A1;
		inboxMsg = new spInboxMsg({
			ajaxUrl: ajaxUrl
		});
		inboxMsg.hideInboxMsg();
		
		inbox = new spinbox({
			category: 'inbox',
			ajaxUrl: ajaxUrl,
			webSockconfigObj:webSockconfigObj
		});
		
		inboxMsg.setInbox(inbox);
		inbox.setInboxMsg(inboxMsg);
		
		if(initialView == spInbCons.INBOX){
			inbox.renderInbox();
		}else if(initialView == spInbCons.REQUEST){
			inbox.renderRequests();
		}else if(initialView == spInbCons.INVITATION){
			inbox.renderInvitations();
		}else if(initialView == spInbCons.NOTIFICATION){
			inbox.renderNotifications();
		}else if(initialView == spInbCons.REPORT_ALERT){
			inbox.renderGroupAlerts();
		}else if(initialView == spInbCons.JOBS_ALERT){
			inbox.renderJobAlerts();
		}else if(initialView == spInbCons.ARCHIVED){
			inbox.renderArhived();
		}else if(initialView == spInbCons.DRAFTS){
			inbox.renderDrafts();
		}else if(initialView == spInbCons.SENT){
			inbox.renderSent();
		}else if(initialView == spInbCons.NEW_MSG){
			inboxMsg.setCategory(spInbCons.NEW_MSG);
			inboxMsg.render(null);
		}else{
			inbox.renderInbox();
		}
		
//		inbox.renderInbox();
		A.one("#inbox").on("click", function(){
			inbox.renderInbox();
		});
		A.one("#searchtext").on("keypress",function(ev){
			// on pressing enter
			if(ev.keyCode == 13){
				inbox.renderSearch();
			}
		});
		
		A.one("#searchB").on("click",function(ev){
			inbox.renderSearch();
		});
		A.one("#requests").on("click", function(){
			inbox.renderRequests();
		});
		A.one("#invitations").on("click", function(){
			inbox.renderInvitations();
		});
		A.one("#notifications").on("click", function(){
			inbox.renderNotifications();
		});
		A.one("#groupAlerts").on("click", function(){
			inbox.renderGroupAlerts();
		});
		A.one("#jobAlerts").on("click", function(){
			inbox.renderJobAlerts();
		});
		A.one("#archivedMsgs").on("click", function(){
			inbox.renderArhived();
		});
		A.one("#draftMsgs").on("click", function(){
			inbox.renderDrafts();
		}); 
		A.one("#sentMsgs").on("click", function(){
			inbox.renderSent();
		}); 
		
		A.one('#compose').on("click",function(){
			inboxMsg.setCategory(spInbCons.NEW_MSG);
			inboxMsg.render(null);
		});
		
	});
}


function spInboxMsg(configObj){
//	var A;
	// Indicates the type of message being opened.
	var category;
	this.setCategory = function(catg){
		category = catg;
	}
	var inbox;
	this.setInbox = function(inb){
		inbox = inb;
	}
	var cmpMsgActionsDiv;
	var cmpMsgCancelDiv;
	var cmpMsgSaveDraftDiv;
	var cmpMsgSendDiv;
	
	var cmpMsgCancel;
	var cmpMsgSaveDraft;
	var cmpMsgSend;
	var cmpMsgToValue;
	var cmpMsgSubjectValue;
	var cmpMsgAllowOpen;
	var cmpMsgSendCopy;
	
	var viewMsgReply;
	var viewMsgReplyAll;
	var viewMsgCancel;
	var viewMsgForward;
	
	var reply;
	var forward;
	var draft;
	var msgJson;
	var viewMsgDiv;
	var cmpseMsgDiv;
	var ckeditor ;
	var autoCompleteObj = null;
	var samples;
	var msgConversation;
	function initialize(configObj){
	//	A = AUI().use('aui-base','aui-node', 'aui-io-request-deprecated');
		ajaxUrl = configObj.ajaxUrl;
		category = configObj.category;
		
		initializeMsgElements();
		initializeButtons();
		initializeCkEditor();
		initializeAutoComplete();
	}
	
	function initializeCkEditor(){
		ckeditor = CKEDITOR.replace("cmpMsgContent",
				{
					resize_enabled: false,
					removePlugins : 'elementspath',
					toolbar :
					[
					['Bold','Italic','NumberedList','BulletedList','Underline' ]
					]
				}); 
	}
	
	function initializeMsgElements(){
		samples = A.one("#samples");
		msgConversation = A.one("#msgConversation");
		cmpMsgActionsDiv = A.one("#cmpMsgActionsDiv");
		cmpMsgCancelDiv = A.one("#cmpMsgCancelDiv");
		cmpMsgSaveDraftDiv = A.one("#cmpMsgSaveDraftDiv");
		cmpMsgSendDiv = A.one("#cmpMsgSendDiv");

		cmpMsgCancel = A.one("#cmpMsgCancel");
		cmpMsgSaveDraft = A.one("#cmpMsgSaveDraft");
		cmpMsgSend = A.one("#cmpMsgSend");
		
		viewMsgReply = A.one("#viewMsgReply");
		viewMsgReplyAll = A.one("#viewMsgReplyAll");
		viewMsgForward = A.one("#viewMsgForward");
		viewMsgCancel = A.one("#viewMsgCancel");
		
		//cmpMsgFromValue = A.one("#cmpMsgFromValue");
		cmpMsgToValue = A.one("#cmpMsgToValue");
		cmpMsgSubjectValue = A.one("#cmpMsgSubjectValue");
		cmpMsgAllowOpen = A.one("#cmpMsgAllowOpen");
		cmpMsgSendCopy = A.one("#cmpMsgSendCopy");
		
		viewMsgDiv = msgConversation;//A.one("#viewMsgDiv");
		cmpseMsgDiv = A.one("#cmpseMsgDiv");
		
	}
	function initializeButtons(){
		
		viewMsgReply.on("click",function(){
			if(msgJson){
				msgJson.parentMsgStatus = "replied";
			}
			renderReplyMsg();
		});
		viewMsgReplyAll.on("click",function(){
			if(msgJson){
				msgJson.parentMsgStatus = "replied";
			}
			renderReplyMsg(true);
		});
		viewMsgForward.on("click",function(){
			if(msgJson){
				msgJson.parentMsgStatus = "forwarded";
			}
			renderForwardMsg();
		});
		
		cmpMsgSaveDraft.on("click",function(){
			var dataObj = {
					
			};
			dataObj["action"] = "saveAsDraft";
			submitMessage(dataObj);
		});
		cmpMsgSend.on("click",function(){
			var dataObj = {
					
			};
			dataObj["action"] = "sendMsg";
			submitMessage(dataObj);
		});
		
		viewMsgCancel.on("click",function(){
			inbox.showInbox();
		})
		cmpMsgCancel.on("click",function(){
			inbox.showInbox();
		})
	}
	function initializeAutoComplete(){
		try{
			var j_ip_form = document.getElementById("cmpMsgToInnerDiv");
			var notefToHiden = document.getElementById("cmpMsgToValue");
			var j_autocomplete_sis_holder = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "sis-holder");
			var j_autocomplete_input = getFirstElementsByAttribute(document, "input", "data-autocomplete-dom-id", "input");
			var j_autocomplete_suggestions_board = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "suggestions-board");
			var j_autocomplete_close_btn = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "close-btn");
			var j_autocomplete_options = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "options");
			var j_autocomplete_selected_items = getFirstElementsByAttribute(document, "ul", "data-autocomplete-dom-id", "selected-items");
			
			autoCompleteObj =	new AutoComplete({
				'j_ip_form' : j_ip_form,
				'j_autocomplete_sis_holder' : j_autocomplete_sis_holder,
				'j_autocomplete_input' : j_autocomplete_input,
				'j_autocomplete_suggestions_board' : j_autocomplete_suggestions_board,
				'j_autocomplete_close_btn' : j_autocomplete_close_btn,
				'j_autocomplete_options' : j_autocomplete_options,
				'j_autocomplete_selected_items' : j_autocomplete_selected_items,
				'_duration_list' : '',
				'_find_suggestions_url' : ajaxUrl,
				'action' : 'getMailSuggestions',
				'shareEmailList' : []
			});
		}catch(error){
			console.log(error);
		}
	}
	this.render = function(tempMailJson){
		msgJson = tempMailJson;
		if(category == spInbCons.NEW_MSG){
			renderComposeMsg();
		}else if(category == spInbCons.VIEW_MSG){
			renderMessageView();
		}else if(category == spInbCons.DRAFT){
			renderDraftMsg();
		}else{
			renderMessageView();
		}
	}
	function renderComposeMsg(){
		showComposeMsg();
		clearCmpMsgValues();
	}
	function renderDraftMsg(){
		showComposeMsg();
		fillComposeMsg();
	}
	function fillComposeMsg(){
		if(msgJson){
			cmpMsgSubjectValue.val(msgJson["subject"]);
			//cmpMsgToValue.val(msgJson["to"]);
			autoCompleteObj.createMailIds(msgJson["to"]);
			cmpMsgAllowOpen.set('checked', msgJson["allowOpen"]);
			cmpMsgSendCopy.set('checked', msgJson["sentMeCopy"]);
			setCKEditorData(msgJson["content"]);
		}else{
			clearCmpMsgValues();
		} 
	}
	function renderForwardMsg(){
		showComposeMsg();
		fillForwardMsg();
	}
	function fillForwardMsg(){
		if(msgJson){
			//cmpMsgToValue.val('');
			autoCompleteObj.createMailIds('');
			var subject = "FW: " + msgJson["subject"];
			var contentFormat = "<br/><br/><br/>---------- Forwarded message ---------- <br/>" + 
								"From: <$FROM> <br/>" +
								"Date: $DATE <br/>" +
								"Subject: $SUBJECT <br/>" +
								"To: $TO <br/> $CONTENT " ;
			var content =  strReplace(contentFormat, ["$FROM","$DATE","$SUBJECT","$TO","$CONTENT"], [msgJson.from, msgJson.date, msgJson.subject,msgJson.to, msgJson.content]);

			cmpMsgSubjectValue.val( subject);
			setCKEditorData(content);
			cmpMsgAllowOpen.set('checked', msgJson.allowOpen);
			cmpMsgSendCopy.set('checked', msgJson.sentMeCopy);
		}else{
			clearCmpMsgValues();
		}
	}
	function renderReplyMsg(isReplyAll){
		showComposeMsg();
		fillReplyMsg(isReplyAll);
	}
	function fillReplyMsg(isReplyAll){
		if(msgJson){
			var to = msgJson.fromEmail;
			if(isReplyAll){
				if(msgJson.to){
					if(msgJson.to.indexOf(msgJson.fromEmail) == -1){
						to = msgJson.fromEmail + "," + msgJson.to;
					}else{
						to = msgJson.to;
					}
				}
			}
			var subject = "Re: " + msgJson.subject;
			var contentFormat = "<br/><br/><br/> On $DATE, <$FROM> wrote: <br/>$CONTENT"
			var content =  strReplace(contentFormat, ["$FROM","$DATE","$CONTENT"], [msgJson.from, msgJson.date,msgJson.content]);

			//cmpMsgToValue.val(to);
			autoCompleteObj.createMailIds(to);
			cmpMsgSubjectValue.val( subject);
			setCKEditorData(content);
			cmpMsgAllowOpen.set('checked', msgJson.allowOpen);
			cmpMsgSendCopy.set('checked', msgJson.sentMeCopy);
			//ckeditor.focus();
			
		}else{
			clearCmpMsgValues();
		}
	}
	function strReplace(str,params,paramValues){
		var result = "";
		var temp = str;
		if(str){
			if(params && paramValues){
				for(var i = 0; i < params.length; i++){
					var replaceStr = paramValues[i]; 
					if(replaceStr == null || replaceStr == undefined){
						replaceStr  = "";
					}
					temp = temp.replace(params[i],paramValues[i]);
				}
				result = temp;
			}
		}
		return result;
	}
	function setCKEditorData(content){
		ckeditor.setData(content);
		//ckeditor.focus();
		//var focusManager = new CKEDITOR.focusManager( ckeditor );
//		ckeditor.focusManage.focus(ckeditor.editable());
	}
	
	function clearCmpMsgValues(){
		cmpMsgSubjectValue.val('');
		//cmpMsgToValue.set('text', '');
		autoCompleteObj.removeAllEmails();
		cmpMsgAllowOpen.set('checked', false);
		cmpMsgSendCopy.set('checked', false);
		setCKEditorData('');
	}
	function renderMessageView(){
		showViewMsg();
		//if(inbox.getCategory() == spInbCons.INBOX){
		if(false){
			var dataObj = {
					successCallback:fillViewMsgConversation
			}
			getMsgConversation(dataObj);
		}else{
			clearMsgConversation();
			var viewMsg = samples.one("#viewMsgDiv").clone();
			createViewMsg(msgJson,viewMsg);	
		}
	};
	function clearMsgConversation(){
		msgConversation.all("#viewMsgDiv").remove();
	}
	function fillViewMsgConversation(msgJsons){
		if(msgJsons){
			clearMsgConversation();
			for(var i= 0; i < msgJsons.length ; i++){
				var tempJson = msgJsons[i];
				createViewMsg(tempJson);
			}
		}
		
	
/*		if(msgJson){
			
			A.one("#viewMsgSubjectValue").set('text', msgJson["subject"]);
			A.one("#viewMsgFromValue").set('text', msgJson["from"]);
			A.one("#viewMsgDateValue").set('text', msgJson["date"]);
			A.one("#viewMsgToValue").set('text', msgJson["to"]);
			A.one("#viewMsgContentDiv").html(msgJson["content"]);
		}else{
			// This case must not be happen
			A.one("#viewMsgSubjectValue").set('text', "");
			A.one("#viewMsgFromValue").set('text', "");
			A.one("#viewMsgDateValue").set('text', "");
			A.one("#viewMsgToValue").set('text', "");
			A.one("#viewMsgContentDiv").html("");
		} */
	}
	function createViewMsg(tempJson){
		var viewMsg = samples.one("#viewMsgDiv").clone();
		viewMsg.one("#viewMsgSubjectValue").set('text', tempJson["subject"]);
		viewMsg.one("#viewMsgFromValue").set('text', tempJson["from"]);
		viewMsg.one("#viewMsgDateValue").set('text', tempJson["date"]);
		viewMsg.one("#viewMsgToValue").set('text', tempJson["to"]);
		viewMsg.one("#viewMsgContentDiv").html(tempJson["content"]);
		msgConversation.insert(viewMsg, 1);
	}
	function getMsgConversation(dataObj){
		dataObj = dataObj ? dataObj : {};
		if(!dataObj["action"]){
			dataObj["action"] = "getMsgConversation";
		}
		if(msgJson){
			dataObj["msgDetailId"] = msgJson.msgDetailId;
		}
		A.io.request(ajaxUrl,{
			dataType : 'json',
			method : 'POST',
			data : dataObj,
			on : {
				success : function() {
					var data = this.get('responseData');
					if(data && data.errorMsg){
						alert(data.errorMsg);
					}else{
						dataObj.successCallback(data.msgs);
					}
				},
				failure : function(){
					var data = this.get('responseData');
					if(data && data.errorMsg){
						alert(data.errorMsg);
					}else{
						alert("Error");
					}
				}
			}
		});
	}
	function submitMessage(dataObj){

		if(!dataObj){
			dataObj = { };
		}
		
		dataObj["category"] = "";
		dataObj["to"] = autoCompleteObj.getSelectedIds();
		dataObj["subject"] = cmpMsgSubjectValue.val();
		dataObj["content"] = ckeditor.getData();
		dataObj["allowOpen"] = cmpMsgAllowOpen.get('checked');
		dataObj["sentMeCopy"] = cmpMsgSendCopy.get('checked');
		dataObj["reply"] = reply;
		dataObj["forward"] = forward;
		
		if(category == spInbCons.DRAFT){
			if(msgJson){
				dataObj["msgId"] =  msgJson.msgId;
			}
		}else{
			if(msgJson){
				dataObj["parentMsgId"] =  msgJson.msgId;
				dataObj["parentMsgDetailId"] =  msgJson.msgDetailId;
				// parentMsgStatus set by forward or reply button event listener
				dataObj["parentMsgStatus"] =  msgJson.parentMsgStatus;
			}
		}
		
		if(!dataObj["action"]){
			dataObj["action"] = "sendMsg";
		}
		
		A.io.request(ajaxUrl,{
			dataType : 'json',
			method : 'POST',
			data : dataObj,
			on : {
				success : function() {
					var data = this.get('responseData');
					if(data && data.errorMsg){
						alert(data.errorMsg);
					}else{
						inbox.render();
					}
				},
				failure : function(){
					var data = this.get('responseData');
					if(data && data.errorMsg){
						alert(data.errorMsg);
					}else{
						alert("Error");
					}
				}
			}
		});
	}
	
	function show(node){
		if(node){
			node.addClass('show-content');
			node.removeClass('hide-content');
		}
	}
	function hide(node){
		if(node){
			node.addClass('hide-content');
			node.removeClass('show-content');
		}
	}
	
	function showComposeMsg(){
		inbox.hideInbox();
		hide(viewMsgDiv);
		show(cmpseMsgDiv);
	}
	function hideComposeMsg(){
		hide(cmpseMsgDiv);
	}
	function showViewMsg(){
		inbox.hideInbox();
		show(viewMsgDiv);
		hide(cmpseMsgDiv);
	}
	function hideViewMsg(){
		hide(viewMsgDiv);
	}
	
	this.hideInboxMsg = function(){
		hide(viewMsgDiv);
		hide(cmpseMsgDiv);
	}
	
	
	initialize(configObj);
	
}


//AUI().ready(function(A) {
//	var selectAll = A.one("#selectAll");
//	alert("selectAll " + selectAll);
//	selectAll.on("select",function(){
//		alert("onselct");
//		setSelectedBgColor();
//	});
//
//	function setSelectedBgColor(){
//		alert("slect change");
//		var inboxListRow = A.all(".inboxListRow");
//		 for (var i = 0; i < inboxListRow.size(); i++) {
//			 var classNames = inboxListRow.getAttribute("class");
//			 alert("classNames " +classNames);
//			 inboxListRow.addClass('msgRowSelected');
//	        }
//	}
//});

