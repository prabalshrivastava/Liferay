<%@page import="com.sambaash.platform.tag.handlers.CommentTagProcess"%>
<%@ include file="/html/taglib/init.jsp" %>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.model.User"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
 User loggedInuser = themeDisplay.getUser();
 String selfImg = loggedInuser.getPortraitURL(themeDisplay);
 String classPK  = (String)request.getAttribute("sp-ui:comment:classPK");
 String className  = (String)request.getAttribute("sp-ui:comment:className");
 String ajaxUrl  = (String)request.getAttribute("sp-ui:comment:ajaxUrl");
 String prefix  = (String)request.getAttribute("sp-ui:comment:prefix");
 namespace = namespace + prefix;
 boolean canViewComment = CommentTagProcess.hasCommentPermissionAttribute(renderRequest, CommentTagProcess.ACTION_VIEW_COMMENTS_PERMISSION);
 boolean canAddComment = CommentTagProcess.hasCommentPermissionAttribute(renderRequest, CommentTagProcess.ACTION_ADD_COMMENT_PERMISSION);
 boolean canUpdateComment = CommentTagProcess.hasCommentPermissionAttribute(renderRequest, CommentTagProcess.ACTION_UPDATE_COMMENT_PERMISSION);
 boolean canDeleteComment = CommentTagProcess.hasCommentPermissionAttribute(renderRequest, CommentTagProcess.ACTION_DELETE_COMMENT_PERMISSION);
 String viewCommentClass = canViewComment ? "" : "hide";
 String addCommentEnabled = canAddComment ? "true" : "false";
 String addCommentDisabled = canAddComment ? "" : "disabled";
 String updateCommentClass = canUpdateComment ? "" : "disabled";
 String deleteCommentDisabled = canDeleteComment ? "" : "disabled";
%>

<div id="<%=namespace%>commentsMainContainer" class="<%=viewCommentClass%>">
	<div><a class="btn btn-primary" id="<%=namespace%>refreshLink">Refresh</a>
	</div>

	<div id="<%=namespace %>noCommentMsg" class="noCommentMsg hide"><span><%= LanguageUtil.get(pageContext,"no-comments-yet")%></span> <span class="vr"></span> <span><%= LanguageUtil.get(pageContext,"be-the-first")%></span> </div>
    <input type="hidden" value="<%=namespace %>" id="<%=namespace %>namespace" />
    <input type="hidden" value="<%= classPK %>" id="<%=namespace %>classPK" />
    <input type="hidden" value="<%= className %>" id="<%=namespace %>className" />
    <input type="hidden" value="<%= themeDisplay.getUser().getFullName() %>" id="<%=namespace %>fullName" />
    <input type="hidden" value="<%= selfImg %>" id="<%=namespace %>selfImg" />

	<div>
		<div></div>
		<div class="commentsContainer">
			<div id="<%=namespace%>commentDefaultParent">
			</div>
				
			<div id="<%=namespace%>writeCommentDiv" class="writeCommentMainDiv">
					<img src="<%= selfImg %>" id="<%=namespace%>selfImgCB" class="selfImgCB" />
					<div class="writeCommentsubDiv">
						<span id="<%=namespace%>mainCommentBox" contenteditable="<%=addCommentEnabled%>" class="commentBox" ></span>
						<div class="replyCommentButton">
							<a class="btn btn-primary" href="javascript:;" id="<%=namespace%>writeCommentButton" <%= addCommentDisabled%>><%= LanguageUtil.get(pageContext,"post")%></a>
						</div>
					</div>
			</div>		
		</div>
	</div>
</div>

<div id="<%=namespace%>commentTemplate" class="hide commentTemplate" >
	   <input type="hidden" id="<%=namespace %>commentId" />
	   <input type="hidden" id="<%=namespace %>parentId" />
	   <input type="hidden" id="<%=namespace %>type" />
	   <input type="hidden" id="<%=namespace %>userId" />
	   <input type="hidden" id="<%=namespace %>origCommentText" />
	  <div id="<%=namespace%>userImgDiv" class="userImgDiv">
	  	  <img src="" id="<%=namespace%>userImg" class="userImg"/>
	  </div>
	  <div id="<%=namespace%>commentDeleteIcon" class="commentDeleteIconDiv" <%=deleteCommentDisabled%>><a href="javascript:;">X</a></div>
	  <div class="commentTextDiv">
	  	 <div>
	  	 	<a id="<%=namespace%>userName"></a>
	  	 	<span id="<%=namespace%>commentText"> </span>
	  	 </div>
	  	 <div id="<%=namespace%>commentFooterDiv">
	  	   <span id="<%=namespace%>postedDate"></span>
	  	 </div>
	  </div>
	  <div class="commentActionsDiv">
	  		<ul>
	  			<li class="hide"><a class="btn btn-primary" href="javascript:;" id="<%=namespace %>update"><%= LanguageUtil.get(pageContext,"update")%></a></li>
	  			<li class="hide"><a class="btn btn-primary" href="javascript:;" id="<%=namespace %>cancelUpdate"><%= LanguageUtil.get(pageContext,"cancel-update")%></a></li>
	  			<li><a class="btn btn-primary" href="javascript:;" id="<%=namespace %>reply"><%= LanguageUtil.get(pageContext,"reply")%></a></li>
	  			<li id="<%=namespace %>viewRepliesLi"><a class="btn btn-primary" href="javascript:;" id="<%=namespace %>viewReplies"><%= LanguageUtil.get(pageContext,"view-replies")%></a></li>
	  		</ul>
	  </div>
	  <div id="<%=namespace %>childs">
	  </div>
</div>
<div id="<%=namespace%>replyCommentTemplate" class="hide replyCommentMainDiv">
		<img src="<%= selfImg %>" id="<%=namespace%>selfImgCB"  class="selfImgCB"/>
		<div class="replyCommentSubDiv">
			<span  id="<%=namespace%>replyCommentBox" contenteditable="<%=addCommentEnabled%>" class="commentBox"></span>
			<div class="replyCommentButton">
			<a class="btn btn-primary" href="javascript:;" id="<%=namespace%>replyCommentButton" <%= addCommentDisabled%>><%= LanguageUtil.get(pageContext,"post")%></a>
		</div>
		</div>
</div>

<script type="text/javascript" src="/html/js/sp/comments.js" ></script>

</script>
<script>
var config  = {
		ajaxUrl: "<%=ajaxUrl %>",
		namespace: "<%= namespace %>",
		loggedInUserId: <%=loggedInuser.getUserId()%>,
		canViewComment: <%=canViewComment%>,
		canAddComment: <%=canAddComment%>,
		canUpdateComment: <%=canUpdateComment%>,
		canDeleteComment: <%=canDeleteComment%>
};
Liferay["<%= namespace %>" + "comment"] = new Comments(config);
</script>