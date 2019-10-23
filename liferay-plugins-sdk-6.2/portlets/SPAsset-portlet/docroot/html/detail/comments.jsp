<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.model.User"%>

<portlet:resourceURL var="ajaxUrl">
	<portlet:param name="action" value=""></portlet:param>
</portlet:resourceURL>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
 String namespace = renderResponse.getNamespace();
// String selfImg = "/image/user_male_portrait?img_id=" + themeDisplay.getUser().getPortraitId();
 User loggedInuser = themeDisplay.getUser();
 String selfImg = loggedInuser.getPortraitURL(themeDisplay);
 
%>

<div id="<%=namespace%>commentsMainContainer">
    <input type="hidden" value="<%=namespace %>" id="<%=namespace %>namespace" />
    <input type="hidden" value="${classPK }" id="<%=namespace %>classPK" />
    <input type="hidden" value="${className }" id="<%=namespace %>className" />
    <input type="hidden" value="<%= themeDisplay.getUser().getFullName() %>" id="<%=namespace %>fullName" />
    <input type="hidden" value="<%= selfImg %>" id="<%=namespace %>selfImg" />
<!-- 	<div id="<%=namespace%>actions">
		 <ul>
		 	<li id="<%=namespace%>likeLi"> <a href="javascript:;" id="<%=namespace%>like">Like</a></li>
		 	<li id="<%=namespace%>commentLi"> <a href="javascript:;" id="<%=namespace%>like">Comment</a></li>
		 </ul>
	</div> -->
	<div>
		<div></div>
		<div>
			<div id="<%=namespace%>commentDefaultParent">
			</div>
				
			<div id="<%=namespace%>writeCommentDiv">
				<div>
					<img src ="<%= selfImg %>" id="<%=namespace%>selfImgCB" alt="Image"/>
				</div>
				<div>
					<textarea rows="2" cols="100" id="<%=namespace%>mainCommentBox"></textarea>
				</div>
			</div>		
		</div>
	</div>
</div>

<div id="<%=namespace%>commentTemplate" class="hide">
	   <input type="hidden" id="<%=namespace %>commentId" />
	   <input type="hidden" id="<%=namespace %>parentId" />
	   <input type="hidden" id="<%=namespace %>type" />
	  <div id="<%=namespace%>commentDeleteIcon"><a href="javascript:;">X</a></div>
	  <div id="<%=namespace%>userImgDiv">
	  	  <img src="" id="<%=namespace%>userImg" alt="User Image"/>
	  </div>
	  <div id="<%=namespace%>commentMainDiv">
	  	 <div id="<%=namespace%>commentDiv">
	  	 	<a id="<%=namespace%>userName"></a>
	  	 	<span id="<%=namespace%>commentText"> </span>
	  	 </div>
	  	 <div id="<%=namespace%>commentFooterDiv">
	  	   <span id="<%=namespace%>postedDate"></span>
	  	 </div>
	  </div>
	  <div>
	  		<ul>
	  			<li><a href="javascript:;" id="<%=namespace %>reply">Reply</a></li>
	  			<li id="<%=namespace %>viewRepliesLi"><a href="javascript:;" id="<%=namespace %>viewReplies">View Replies</a></li>
	  			
	  		</ul>
	  </div>
	  <div id="<%=namespace %>childs">
	  </div>
</div>
<div id="<%=namespace%>writeCommentTemplate" class="hide">
	<div>
		<img src="<%= selfImg %>" id="<%=namespace%>selfImgCB" alt="Image"/>
	</div>
	<div>
		<textarea rows="2" cols="100" id="<%=namespace%>replyCommentBox"></textarea>
	</div>
</div>

<script src="/SPAsset-portlet/js/comments.js">

</script>
<script>
var config  = {
		ajaxUrl: "<%=ajaxUrl %>",
		namespace: "<%= namespace %>"
};
Liferay["<%= namespace %>" + "comment"] = new Comments(config);
</script>
