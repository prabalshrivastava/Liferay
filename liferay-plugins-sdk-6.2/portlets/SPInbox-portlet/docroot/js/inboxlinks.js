function inboxlinks(ajax,inbox){
	var ajaxUrl;
	var inboxUrl;
	var A;
	var unreadInbCount,unreadReqCount,unreadNotfCount,unreadInvCount,unreadGrpAlertCount,unreadJobAlertCount;
	function intialize(ajax,inbox){
		ajaxUrl = ajax;
		inboxUrl = inbox;
		initializeLinks();

		unreadInbCount = A.one("#unreadInbCount");
		unreadReqCount = A.one("#unreadReqCount");
		unreadNotfCount = A.one("#unreadNotfCount");
		unreadInvCount = A.one("# unreadInvCount");
		unreadGrpAlertCount = A.one("#unreadGrpAlertCount");
		unreadJobAlertCount = A.one("#unreadJobAlertCount");
		
		fetchUnreadCounts();
	}
	
	function openInboxView(view){
		window.location.href = inboxUrl + "?view=" + view;
	}
	
	function initializeLinks(){
		A.one("#inbox").on("click", function(){
			openInboxView(spInbCons.INBOX)
		});
		A.one("#requests").on("click", function(){
			openInboxView(spInbCons.REQUEST)
		});
		A.one("#invitations").on("click", function(){
			openInboxView(spInbCons.INVITATION);
		});
		A.one("#notifications").on("click", function(){
			openInboxView(spInbCons.NOTIFICATION);
		});
		A.one("#groupAlerts").on("click", function(){
			openInboxView(spInbCons.REPORT_ALERT);
		});
		A.one("#jobAlerts").on("click", function(){
			openInboxView(spInbCons.JOBS_ALERT);
		});
		A.one("#archivedMsgs").on("click", function(){
			openInboxView(spInbCons.ARCHIVED);
		});
		A.one("#draftMsgs").on("click", function(){
			openInboxView(spInbCons.DRAFTS);
		}); 
		A.one("#sentMsgs").on("click", function(){
			openInboxView(spInbCons.SENT);
		});
		A.one('#compose').on("click",function(){
			openInboxView(spInbCons.NEW_MSG);
		});
	}
	
	function fetchUnreadCounts(dataObj){
		if(!dataObj){
			dataObj = { };
		}
		if(!dataObj["action"]){
			dataObj["action"] = "unreadCounts";
		}
		A.io.request(ajaxUrl,{
			dataType : 'json',
			method : 'POST',
			data : dataObj,
			on : {
				success : function() {
					var data = this.get('responseData');
					if(data && data.errorMsg){
					}else{
						if(data.unreadObj){
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
	
	function setUnreadCount(unreadObj){
		if(unreadObj){
			setUnreadCountForNode(unreadInbCount,unreadObj.unreadInbCount);
			setUnreadCountForNode(unreadReqCount,unreadObj.unreadReqCount);
			setUnreadCountForNode(unreadNotfCount,unreadObj.unreadNotfCount);
			setUnreadCountForNode(unreadInvCount,unreadObj.unreadInvCount);
			setUnreadCountForNode(unreadGrpAlertCount,unreadObj.unreadGrpAlertCount);
			setUnreadCountForNode(unreadJobAlertCount,unreadObj.unreadJobAlertCount);
		}
	}
	
	function setUnreadCountForNode(nodeObj,count){

		if(nodeObj ){
			if( count && count > 0){
				nodeObj.set('text', "(" + count + ")");
			}else{
				nodeObj.set('text', "");
				
			}
		}
	
	}
	
	AUI().use('aui-node','aui-base', 'aui-io-request-deprecated',function(A1){
		A = A1;
		intialize(ajax, inbox);
	});
}