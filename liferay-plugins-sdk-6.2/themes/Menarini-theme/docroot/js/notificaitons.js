
function notificationClick(){
	AUI().use('aui-node','aui-base',function(A){
		
		var noteLink = A.one("#notficaitonsLink");
		var noteDiv = A.one('.notificationsDiv');
		noteLink.on("click",function(){
			var links = A.one("#notificationsList").all("li a");
			if(links.size() > 0){
				if(noteDiv){
					noteDiv.setStyle('display','block');
					noteLink.toggleClass('activeN');
				}
			}
		});
		
		if(noteDiv){
			noteDiv.on("clickoutside",function(event){
			//	var etarget  = event.currentTarget;
			//	var attrVal = etarget.getAttribute("id")
				var clickedNode = event.target;
				var isNoteLink = getClosestParentByAttribute(clickedNode.getDOMNode(),"id","notificationsLinkDiv")
				if(!isNoteLink && !(clickedNode.get('id') == "notificationsLinkDiv")){
					noteDiv.setStyle('display','none');
					noteLink.removeClass('activeN');
				}
			});
		}

		
	});
}


function initializeNoteItemClick(){
	AUI().use('aui-node','aui-base',function(A){
		var links = A.one("#notificationsList").all("li a");
		links.each(function(link){
			notificationItemClick(this.get('id'));
		});
	});
}


function notificationItemClick(noteLinkId){
	AUI().use('aui-node','aui-base',function(A){
		A.one("#"+noteLinkId).on("click", function(){
			// "noteDetailsLink_<msgdetailid>"
			var linkId = this.get('id');
			var msgDetailsId = linkId.substring(16); 
			A.use('aui-io-request', function (){
//				var ajaxurl = "/login/notify.do";
				var ajaxurl = "/c/portal/spnotify";
				A.io.request(ajaxurl,{
					//dataType : 'json',
					method : 'POST',
					data : {
						action: 'removeFile',
						msgDetailId: msgDetailsId
					},
					on : {
					complete : function() {
							var data = this.get('responseData');
							var result = data.result;
							}
					}
				});
				
			});
		});
	});
}
		

function initalizeNotificaitons(configObj){
	AUI().ready('aui-carousel','aui-node','aui-base',  function(A) {
		
		var realtime_activity_feed_count = 0;
		if(configObj.noteCount && configObj.noteCount > 0){
			realtime_activity_feed_count = configObj.noteCount;
		}
		var realtime_activity_feed = {
				activities: []
		};
		var realtime_activity_feed_notification_btn = A.one("#notficaitonsLink");
		var realtime_activity_feed_count_span = getFirstElementsByAttribute(realtime_activity_feed_notification_btn.getDOMNode(), "span", "data-activity-feed-dom-id", "realtime-activity-feed-count");
		var retrieve_attempts_limit = 5;
		var retrieve_attempts = 0;
		
		var realtime_activity_feed_container = getFirstElementsByAttribute(document, "ul", "data-activity-feed-dom-id", "container");
		
		function showRealtimeActivityFeedNotification() {
			try{
				realtime_activity_feed_notification_btn.style.display = "block";
			}catch(err) {
				alert(err);
			}
		}
		
		var stompClient = null;
		var username = configObj.screenName; // '<%=themeDisplay.getUser().getScreenName()%>';
		var communityName = configObj.communityName;// '${communityName}';
		var websocketUrl = configObj.websocketUrl;//'${websocketUrl}/connect';
		//var filterType = configObj.filterType; //'<%=filterType %>';
		var socket = null;
		var noteList = A.one('#notificationsList');
		function connect(username) {
			try{
				socket = new SockJS(websocketUrl,'xhr-streaming');
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
					var subscribeUrl = '/user/' + username + '/' + communityName + '/notifications/groups';
					
					stompClient.subscribe(subscribeUrl, function(activityFeed) {
						/* {"className":"com.liferay.portlet.blogs.model.BlogsEntry","classPK":1,"type":1} */
						var noteJson = JSON.parse(activityFeed.body);
						realtime_activity_feed.activities.push(noteJson);
						realtime_activity_feed_count += 1;
						realtime_activity_feed_count_span.innerHTML = realtime_activity_feed_count;
						var linkId = "noteDetailsLink_" + noteJson.msgDetailId; 
						var newNote = A.Node.create("<li> <a href='" + noteJson.detailLink + "' id='" + linkId +  "'>" + noteJson.content + "</a></li>");
						
						var firstNote = noteList.one("li");
						if(firstNote && firstNote.getDOMNode()){
							newNote.insertBefore(newNote,firstNote);
						}else{
							noteList.append(newNote);
						}
						
						notificationItemClick(linkId);
						
					});
				});
				
			}catch(err) {
				alert(err);
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
		
	});
	
}
