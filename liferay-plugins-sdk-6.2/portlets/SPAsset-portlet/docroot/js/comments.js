function Comments(configObj){
	var namespace;
	var config;
	var classPK;
	var className;
	var commentTemplate;
	var writeCommentTemplate;
	var pageSize = 10;
	var start  = 0;
	var end = 0;
	var commentDefaultParent;
	var fullName;
	var selfImg;
	
	var idCommentText;
	var idUserName ;
	var idPostedDatetId ;
	var idUserImg ;
	var idComment ;
	var idParent ;
	var idType;
	var idReply;
	var idSelfImg;
	var idChilds;
	var idViewReplies;
	var TYPE_COMMENT ="comment";
	var TYPE_REPLY ="reply";
	var SOURCE_COMMENTS_TAG ="commentsTag";
	var eventHandlers = [];
	function initialzie(configObj){
		config = configObj;
		namespace = configObj.namespace;
		classPK = A.one('#' + namespace + "classPK");
		className = A.one('#' + namespace + "className");
		fullName = A.one('#' + namespace + "fullName");
		selfImg = A.one('#' + namespace + "selfImg");
		commentTemplate = A.one('#' + namespace + "commentTemplate");
		writeCommentTemplate = A.one('#' + namespace + "writeCommentTemplate");
		commentDefaultParent = A.one('#' + namespace + "commentDefaultParent");
		
		/** START ids used inside single comment section */
		idCommentText = "#" + namespace + "commentText";
		idUserName = "#" + namespace + "userName";
		idPostedDatetId = "#" + namespace + "postedDate";
		idUserImg = "#" + namespace + "userImg";
		idComment = "#" + namespace + "commentId";
		idParent = "#" + namespace + "parentId";
		idType = "#" + namespace + "type";
		idReply = "#" + namespace + "reply";
		idSelfImg = "#" + namespace + "selfImg";
		idChilds = "#" + namespace + "childs";
		idViewReplies = "#" + namespace + "viewReplies";
		/** END */
		fetchData();
		initializeAdd();
	}
	
	function initializeAdd(){
		var handler = A.one("#" + namespace + "mainCommentBox").on("keypress",function(ev){
			
			if(ev.keyCode ==  13){
				var comment = {
						thumbnailImg: selfImg.val(),
						fullName: fullName.val(),
						content: this.val(), 
						displayDate: "0 seconds ago"
				};
				var newNode  = renderComment(comment, commentDefaultParent);
				this.val('');
				comment.newNode =  newNode;
				storeComment(null,comment);
			}
		});
		eventHandlers.push(handler);
	}
	
	function storeComment(dataObj,comment){
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
		}else{
			//TODO:
		}
		
	}
	function deleteComment(dataObj,comment){
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
		var comments = data.items;
		if(data && comments){
			for(var i = 0; i < comments.length; i++){
				var comment = comments[i];
				renderComment(comment,parentNode);
			}
		}else{
			//TODO:
		}
	}
	
	function renderComment(comment,parentNode){
		parentNode = parentNode ? parentNode : commentDefaultParent;
		var commentNode = commentTemplate.clone();
		commentNode.removeClass("hide");
		
		commentNode.one(idUserImg).set("src",comment["thumbnailImg"]);
		commentNode.one(idUserName).set("text",comment["fullName"]);
		commentNode.one(idCommentText).set("text",comment["content"]);
		commentNode.one(idPostedDatetId).set("text",comment["displayDate"]);
		commentNode.one(idComment).val(comment["messageId"]);
		commentNode.one(idParent).val(comment["parentMessageId"]);
		commentNode.one(idType).val(comment["type"]);
		
		parentNode.append(commentNode);
		
		displayWriteCommentDiv(commentNode);
	
		initializeViewReplies(commentNode,comment);
		
		initializeDelete(commentNode);
		
		return commentNode;
	}
	
	function displayWriteCommentDiv(commentNode){
		commentNode.one(idReply).on("click",function(){
			var type = commentNode.one(idType).val();
			var targetNode = null;
			//Incase reply clicked in root comment
			if(type == TYPE_COMMENT){
				var writeDiv  = commentNode.one(writeCommentTemplate.get('id'));
				if(!writeDiv){
					writeDiv  = writeCommentTemplate.clone();
					writeDiv.removeClass("hide");
					writeDiv.one(idSelfImg).set('src',selfImg.val());
					commentNode.append(writeDiv);
					initializeReply(commentNode);
				}
			}else if( type == TYPE_REPLY){
				//Incase reply clicked in child comment
			}
		});
		
	}
	
	function initializeReply(commentNode){
		commentNode.one("#" + namespace + "replyCommentBox").on("keypress",function(ev){
			//Enter key
			if(ev.keyCode ==  13){
				var comment = {
						thumbnailImg: selfImg.val(),
						fullName: fullName.val(),
						content: this.val(), 
						displayDate: "0 seconds ago"
				};
				var newNode  = renderComment(comment, commentNode.one(idChilds));
				this.val('');
				comment.newNode =  newNode;
				var dataObj = {
					action : "addReply",
					// parent id required for storing reply,
					parentId : 	commentNode.one(idComment).val()
				};
				storeComment(dataObj,comment);
			}
		});
	}
	
	function initializeViewReplies(commentNode,comment){
		var childCount = comment["childCount"];
		var viewRepliesLi = commentNode.one("#" + namespace + "viewRepliesLi");
		if(childCount && childCount > 0){
			commentNode.one(idViewReplies).set('text', childCount + " Replies");
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
	function hide(node){
		if(node){
			node.addClass("hide");
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