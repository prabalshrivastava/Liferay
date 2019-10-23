/**
 * Javascript for comment Tag :  sp-ui:comment
 * 
 * Files: 
 * comments.jsp   - Html for comments
 * comments.js - data fetching/sending to server,rendering in browser
 * CommentTag.java - Tag handler class
 * 
 * CommentTagProcess.java - Java class which handles all resource actions ( adding comment,deleting,fetching ) at server end.
 * 
 * comments.js sends http parameter "source" ( value is commentsTag ) with each ajax call it made.this flag can be used at server side to know the 
 * request is from comment tag
 * In your Action class serverResource method, check the http parameter "source", if it is 'commentsTag' then dispatch the request processing to 
 * CommentTagProcess.java
 * 
 * Example:
	  Client side :  <sp-ui:comment classPK="${classPK }" className="${className }" ajaxUrl="<%= resourceURL %>"></sp-ui:comment>
	  server side: 
	  public void serveResource(ResourceRequest resourceRequest,
		        ResourceResponse resourceResponse)
		    throws  IOException, PortletException {
				String action = ParamUtil.getString(resourceRequest, "action");
				String source = ParamUtil.getString(resourceRequest, "source");
				if (CommentTagProcess.SOURCE_COMMENTS_TAG.equalsIgnoreCase(source)) {
					CommentTagProcess ctp  = new CommentTagProcess();
					ctp.serveResource(resourceRequest, resourceResponse);
				}else if("getFiles".equals(action)){
				 // Usual your request processing
				}
		}
		
			 
 *  At client side, if you want to load comments for different entity then call reinitailze method in comments.js by passing new entity id and className
 *  Example:
 *  commentObj = Liferay[namespace + "comment"]; // fetch the comment object. by default comment tag put's the object in Liferay
 *  commentObj.reinitailze(2345,'com.liferay.portlet.documentlibrary.model.DLFileEntry');
 * 
 * 
 */
function Comments(configObj){
	var namespace;
	var config;
	var classPK;
	var className;
	var commentTemplate;
	var replyCommentTemplate;
	var pageSize = 10;
	var start  = 0;
	var end = 0;
	var commentDefaultParent;
	var fullName;
	var selfImg;
	
	var idCommentText;
	var idOrigCommentText;
	var idUserName ;
	var idPostedDatetId ;
	var idUserImg ;
	var idComment ;
	var idParent ;
	var idType;
	var idUserId;
	var idReply;
	var idSelfImg;
	var idChilds;
	var idViewReplies;
	var TYPE_COMMENT ="comment";
	var TYPE_REPLY ="reply";
	var SOURCE_COMMENTS_TAG ="commentsTag";
	var eventHandlers = [];
	var noCommentMsg;
	var notAllowedToAddMsg = "Sorry, you are not allowed to add a comment.";
	var notAllowedToDeleteMsg = "Sorry, you are not allowed to delete a comment.";
	function initialzie(configObj){
		config = configObj;
		namespace = configObj.namespace;
		classPK = A.one('#' + namespace + "classPK");
		className = A.one('#' + namespace + "className");
		fullName = A.one('#' + namespace + "fullName");
		selfImg = A.one('#' + namespace + "selfImg");
		commentTemplate = A.one('#' + namespace + "commentTemplate");
		replyCommentTemplate = A.one('#' + namespace + "replyCommentTemplate");
		commentDefaultParent = A.one('#' + namespace + "commentDefaultParent");
		noCommentMsg = A.one('#' + namespace + "noCommentMsg");
		
		/** START ids used inside single comment section */
		idCommentText = "#" + namespace + "commentText";
		idOrigCommentText = "#" + namespace + "origCommentText";
		idUserName = "#" + namespace + "userName";
		idUserId = "#" + namespace + "userId";
		idPostedDatetId = "#" + namespace + "postedDate";
		idUserImg = "#" + namespace + "userImg";
		idComment = "#" + namespace + "commentId";
		idParent = "#" + namespace + "parentId";
		idType = "#" + namespace + "type";
		idReply = "#" + namespace + "reply";
		idSelfImg = "#" + namespace + "selfImgCB";
		idChilds = "#" + namespace + "childs";
		idViewReplies = "#" + namespace + "viewReplies";
		/** END */
		fetchData();
		initializeAdd();
		
//		console.log('loggedInUserId='+config.loggedInUserId);
//		console.log('canViewComment='+config.canViewComment);
//		console.log('canAddComment='+config.canAddComment);
//		console.log('canUpdateComment='+config.canUpdateComment);
//		console.log('canDeleteComment='+config.canDeleteComment);
	}
	
	function initializeAdd(){
		var handler = A.one("#" + namespace + "mainCommentBox").on("keypress",function(ev){
			if(ev.keyCode ==  13){
				addComment(ev);
			}
		});
		eventHandlers.push(handler);
		var handler1 = A.one("#" + namespace + "writeCommentButton").on("click",function(ev){
			addComment(ev);
		});
		eventHandlers.push(handler1);
		
		var handler2 = A.one('#' + namespace + "refreshLink").on("click",function(ev){
			refresh(ev);
		});		
		eventHandlers.push(handler2);
	}
	
	
	function addComment(ev){
		if (!config.canAddComment) {
			alert(notAllowedToAddMsg);
			return;
		}
		var content =  A.one("#" + namespace + "mainCommentBox");
		var commentText = content.get('text');;
		if(isNullOrEmpty(commentText)){
			if(ev){
				ev.preventDefault();
			}
			return;
		}
			var comment = {
					thumbnailImg: selfImg.val(),
					fullName: fullName.val(),
					content: content.get('text'), 
					displayDate: "0 seconds ago",
					type : TYPE_COMMENT
			};
			var newNode  = renderComment(comment, commentDefaultParent);
			content.set('text','');
			comment.newNode =  newNode;
			storeComment(null,comment);
	}
	function addReply(commentNode,ev){
		if (!config.canAddComment) {
			alert(notAllowedToAddMsg);
			return;
		}
		var replyCommentBox = commentNode.one("#" + namespace + "replyCommentBox");
		var commentText = replyCommentBox.get('text');
		if(isNullOrEmpty(commentText)){
			if(ev){
				ev.preventDefault();
			}
			return;
		}
		//Enter key
			var comment = {
					thumbnailImg: selfImg.val(),
					fullName: fullName.val(),
					content: commentText, 
					displayDate: "0 seconds ago",
					type:TYPE_REPLY
			};
			var newNode  = renderComment(comment, commentNode.one(idChilds));
			replyCommentBox.set('text','');
			comment.newNode =  newNode;
			var dataObj = {
				action : "addReply",
				// parent id required for storing reply,
				parentId : 	commentNode.one(idComment).val()
			};
			storeComment(dataObj,comment);
	}
	
	function isNullOrEmpty(text){
		if(!text || text.trim() == ''){
			return true
		}
		return false;
	}
	
	function storeComment(dataObj,comment){
		if (!config.canAddComment) {
			alert(notAllowedToAddMsg);
			return;
		}
		if(!dataObj){
			dataObj = { };
		}
		if(!dataObj["action"]){
			dataObj["action"] = "addComment";
		}
		if(dataObj["sync"] == undefined){
			dataObj["sync"] = false;
		}
		
		dataObj["classPK"] = classPK.val();
		dataObj["className"] = className.val();
		dataObj["content"] =  comment.content;
		dataObj["source"] =  SOURCE_COMMENTS_TAG;
		
		A.io.request(config.ajaxUrl,{
			dataType : 'json',
			method : 'POST',
			data : dataObj,
			sync: dataObj.sync,
			on : {
				success : function() {
					var data = this.get('responseData');
					if(data && data.msg){
						handleAddCommentResponse(dataObj,comment,data);
					}else{
					}
				},
				failure : function(){
				}
			}
		});
	}
	function handleAddCommentResponse(dataObj,comment,data){
		if( data && data.messageId ){
			var newNode = comment.newNode;
			newNode.one(idComment).val(data.messageId );
			newNode.one(idParent).val(data.parentMessageId );
			newNode.one(idType).val(data.type );
			newNode.one(idPostedDatetId).set("text",data.displayDate);
			hide(noCommentMsg);
			refresh();
		}else{
			//TODO:
		}
		
	}
	function deleteComment(dataObj,comment){
		var notAllowed = true;
		try {
			var commentOwner = comment.deleteNode.one(idUserId).val();
			var commentUserId = commentOwner && commentOwner !== "" ? Number(commentOwner) : config.loggedInUserId;
			notAllowed = !config.canDeleteComment && config.loggedInUserId !== commentUserId
		}catch(e) {};
		if (notAllowed) {
			alert(notAllowedToDeleteMsg);
			return;
		}
		if(!dataObj){
			dataObj = { };
		}
		if(!dataObj["action"]){
			dataObj["action"] = "deleteComment";
		}
		if(dataObj["sync"] == undefined){
			dataObj["sync"] = false;
		}
		
		dataObj["classPK"] = classPK.val();
		dataObj["className"] = className.val();
		dataObj["messageId"] =  comment.messageId;
		dataObj["source"] =  SOURCE_COMMENTS_TAG;
		
		A.io.request(config.ajaxUrl,{
			dataType : 'json',
			method : 'POST',
			data : dataObj,
			sync: dataObj.sync,
			on : {
				success : function() {
					var data = this.get('responseData');
					handleDeleteCommentResponse(dataObj,comment,data);
				},
				failure : function(){
				}
			}
		});
	}
	function handleDeleteCommentResponse(dataObj,comment,data){
		if( data && data.deleted ){
			if(comment.deleteNode){
				comment.deleteNode.remove();
			}
			refresh();
		}else{
			//TODO:
		}
		
	}
	function fetchData(dataObj){
		if(!dataObj){
			dataObj = { };
		}
		if(!dataObj["action"]){
			dataObj["action"] = "retrieveComments";
		}
		if(dataObj["sync"] == undefined){
			dataObj["sync"] = false;
		}
		
		dataObj["classPK"] = classPK.val();
		dataObj["className"] = className.val();
		dataObj["start"] = start;
		dataObj["end"] = end + pageSize;
		dataObj["offset"] =  pageSize;
		dataObj["source"] =  SOURCE_COMMENTS_TAG;
		//dataObj["assetEntryId"] = assetEntryId.val();
		
		A.io.request(config.ajaxUrl,{
			dataType : 'json',
			method : 'POST',
			data : dataObj,
			sync: dataObj.sync,
			on : {
				success : function() {
					var data = this.get('responseData');
					if(data && data.msg){
						if(data.msg != 'error'){
							handleResponse(dataObj,data);
						}
					}else{
					}
				},
				failure : function(){
				}
			}
		});
	}
	
	function handleResponse(dataObj,data){
		var parentNode = dataObj.parentNode ? dataObj.parentNode : commentDefaultParent;
		if (!dataObj.parentNode) {
			commentDefaultParent.empty();
		}
		var comments = data.items;
		if(comments.length > 0){
//			noCommentMsg.toggleClass("hide");
			for(var i = 0; i < comments.length; i++){
				var comment = comments[i];
				renderComment(comment,parentNode);
			}
			noCommentMsg.addClass("hide");
		}else{
			//TODO:
			noCommentMsg.removeClass("hide");
		}
	}
	
	function renderComment(comment,parentNode){
		parentNode = parentNode ? parentNode : commentDefaultParent;
		var commentNode = commentTemplate.clone();
		commentNode.removeClass("hide");
//		noCommentMsg.toggleClass("hide");
		commentNode.one(idUserImg).set("src",comment["thumbnailImg"]);
		commentNode.one(idUserName).set("text",comment["fullName"]);
		commentNode.one(idCommentText).set("text",comment["content"]);
		commentNode.one(idPostedDatetId).set("text",comment["displayDate"]);
		commentNode.one(idComment).val(comment["messageId"]);
		commentNode.one(idParent).val(comment["parentMessageId"]);
		commentNode.one(idType).val(comment["type"]);
		commentNode.one(idUserId).val(comment["userId"]);
		commentNode.one(idOrigCommentText).val(comment["content"]);
		
		parentNode.append(commentNode);
		
		displayWriteCommentDiv(commentNode);
	
		initializeViewReplies(commentNode,comment);
		
		initializeDelete(commentNode);
		
		var canUpdateComment = false;
		try {
			var commentOwner = commentNode.one(idUserId).val();
			var commentUserId = commentOwner && commentOwner !== "" ? Number(commentOwner) : config.loggedInUserId;
			canUpdateComment = config.canUpdateComment || config.loggedInUserId == commentUserId;
		}catch(e) {};
		
		if (canUpdateComment) {
			initializeUpdate(commentNode);
		}
		
		return commentNode;
	}
	
	function displayWriteCommentDiv(commentNode){
		commentNode.one(idReply).on("click",function(){
			if (!config.canAddComment) {
				alert(notAllowedToAddMsg);
				return;
			}
			var type = commentNode.one(idType).val();
			var targetNode = null;
			var writeDiv = null;
			var parentNode =  commentNode;
			//Incase reply clicked in root comment
			if(type == TYPE_COMMENT){
				// just feth the commenting div 
				// writeDiv  = commentNode.one("#" + replyCommentTemplate.get('id'));
			}else if( type == TYPE_REPLY){
				//Incase reply clicked in child comment
				// both parent and child have same id..lets fetch parent and get comment write div
				 parentNode  = commentNode.ancestor("#" + commentNode.get('id'));
			}
			
			 writeDiv  = parentNode.one("#" + replyCommentTemplate.get('id'));
			if(!writeDiv){
				writeDiv  = replyCommentTemplate.clone();
				writeDiv.removeClass("hide");
				//writeDiv.one(idSelfImg).set('src',selfImg.val());
				parentNode.append(writeDiv);
				initializeReply(parentNode);
			}
		});
		
	}
	function initializeReply(commentNode){
		commentNode.one("#" + namespace + "replyCommentBox").on("keypress",function(ev){
			//Enter key
			if(ev.keyCode ==  13){
				addReply(commentNode,ev);
			}
		});
		commentNode.one("#" + namespace + "replyCommentButton").on("click",function(ev){
			addReply(commentNode,ev);
		});
	}
	
	function initializeViewReplies(commentNode,comment){
		var childCount = comment["childCount"];
		var viewRepliesLi = commentNode.one("#" + namespace + "viewRepliesLi");
		if(childCount && childCount > 0){
			commentNode.one(idViewReplies).set('text', childCount + (childCount>1?" Replies":" Reply"));
			commentNode.one(idViewReplies).on("click",function(){
				var dataObj = {
						action : "retrieveReplies",
						// parent id required for fetch replies,
						parentId : 	commentNode.one(idComment).val(),
						// specifiy target node to which retrieved commens will be appended
						parentNode:  commentNode.one(idChilds)
					};
				fetchData(dataObj);
				
				//once it's clicked, then hide the link
				hide(viewRepliesLi)
			});
		}else{
			viewRepliesLi.addClass("hide");
		}
	}
	
	function initializeDelete(commentNode){
		commentNode.one("#" + namespace + "commentDeleteIcon").on("click",function(){
			var comment = {
					messageId : commentNode.one(idComment).val(),
					deleteNode:  commentNode
			}
			
			deleteComment(null, comment);
		});
	}
	
	function initializeUpdate(commentNode){
		var commentTextNode = commentNode.one(idCommentText);
		var origTxt = commentNode.one(idOrigCommentText).val();
		var origViewRepliesClass = commentNode.one('#'+namespace+'viewRepliesLi').attr('class');
		var toggleCommentUpdateDisplay = function(enable) {
			if (enable) {
				commentTextNode.addClass('commentBox');
				commentTextNode._node.style.cursor = 'text';
				commentNode.one('#'+namespace+'update').ancestor('li').removeClass('hide');
				commentNode.one('#'+namespace+'cancelUpdate').ancestor('li').removeClass('hide');	
				commentNode.one('#'+namespace+'cancelUpdate').ancestor('li').removeClass('hide');
			} else {
				commentTextNode.removeClass('commentBox');
				commentTextNode._node.style.cursor = 'pointer';
				commentNode.one('#'+namespace+'update').ancestor('li').addClass('hide');
				commentNode.one('#'+namespace+'cancelUpdate').ancestor('li').addClass('hide');	
				commentNode.one('#'+namespace+'viewRepliesLi').attr('class', origViewRepliesClass);
			}
		};
		
		commentTextNode.attr('contenteditable','true');
		commentTextNode.on("keyup",function(ev){
			//Enter key
			if(ev.keyCode ==  13){
				updateComment(commentNode);
//				console.log('insert update code here');
			} else {
				if (commentTextNode.text() !== origTxt) {
					toggleCommentUpdateDisplay(true);
				} else {
					toggleCommentUpdateDisplay(false);
				}				
			}
		});
		commentNode.one("#" + namespace + "update").on("click",function(){
			updateComment(commentNode);
//			console.log('insert update code here');
			commentNode.one(idOrigCommentText).val(commentTextNode.text());
			origTxt = commentNode.one(idOrigCommentText).val();
			toggleCommentUpdateDisplay(false);
		});
		commentNode.one("#" + namespace + "cancelUpdate").on("click",function(){
			commentTextNode.text(origTxt);
			toggleCommentUpdateDisplay(false);
		});		
	}
	
	function updateComment (commentNode) {
		var dataObj = {
				action : "updateComment",
				messageId: commentNode.one(idComment).val()
			};
		storeComment(dataObj,{ messageId: commentNode.one(idComment).val(), content: commentNode.one(idCommentText).text()});
		refresh();
	}
	
	function hide(node){
		if(node){
			node.addClass("hide");
		}
	}
	
	function refresh (ev) {
		if (classPK.val() && className.val()) {
			Liferay[namespace+"comment"].reinitailze(classPK.val(),className.val());			
		}
	}
	
	this.reinitailze = function(classPKVal,classNameVal){
		classPK.val(classPKVal);
		className.val(classNameVal);
		
		//clear all comments
		A.one("#" + namespace + "commentsMainContainer").all("#" + commentTemplate.get('id')).remove();
		for(var i = 0 ; i < eventHandlers.length ; i++){
			eventHandlers[i].detach();
		}
		eventHandlers = [];
		initialzie(config);
	}
	var A ;
	AUI().use('aui-node','aui-base', 'aui-io-request-deprecated',function(A1){
		A = A1;
		initialzie(configObj);
	});
}