<%@ include file="/html/sambaash/platform/taglib/sp-ui/like/init.jsp" %>

<%@ page import="com.sambaash.platform.srv.graph.service.SPNeoforjLocalServiceUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<style type="text/css">

/* ------------------------------ like ------------------------------ */

.splike-like .text-unlike, .splike-liking .text-like {
    display: none;
}

</style>


<c:choose>
	<c:when test="${themeDisplay.signedIn}">
		
		<%
		
		String communityName = (String)request.getAttribute("sp-ui:like:communityName");
		String className = (String)request.getAttribute("sp-ui:like:className");
		long classPK = GetterUtil.getLong((String)request.getAttribute("sp-ui:like:classPK"));
		
		boolean isSignedIn = themeDisplay.isSignedIn();
		
		long userId = themeDisplay.getUserId();

		int usersWhoLikeCount = SPNeoforjLocalServiceUtil.findUsersWhoLikeCount(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), themeDisplay.getLayoutSet().getLayoutSetId(), className, classPK);
		
		boolean isLiking = false;
		
		String action = "like";
		if(isSignedIn) {
			isLiking = SPNeoforjLocalServiceUtil.isLiking(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), themeDisplay.getLayoutSet().getLayoutSetId(), userId, className, classPK);
		}
		if(isLiking) {
			action = "unlike";
		}
		
		String likeData = "{ &quot;companyId&quot; : &quot;" + themeDisplay.getCompanyId() + "&quot;,&quot;groupId&quot; : &quot;" + themeDisplay.getScopeGroupId()+ "&quot;,&quot;layoutSetId&quot; : &quot;" + themeDisplay.getLayoutSet().getLayoutSetId() + "&quot;,&quot;action&quot; : &quot;" + action + "&quot;,&quot;startUserId&quot; : " + userId + ", &quot;endEntityClassName&quot; : &quot;" + className + "&quot;, &quot;endEntityId&quot; : " + classPK + "}";
		
		%>
		
		<b class="sp-lc"><%=usersWhoLikeCount %></b><span> like(s)</span><span style="margin: 0 5px;"> · </span><a href="javascript:;" data-like="<%=likeData %>" class="splike-link-like <c:choose><c:when test="<%=isLiking %>">splike-liking</c:when><c:otherwise>splike-like</c:otherwise></c:choose>"><span class="text-like">Like</span><span class="text-unlike">Unlike</span></a>
		
		<aui:script>
		
			AUI().use('event', 'node', function(A) {
				
			   	// Your code goes here
			   	
			   	var allLikeLinkObjects = A.all('.splike-link-like');
			   	
			   	allLikeLinkObjects.on('click', function(event) {
					<%-- http://stackoverflow.com/questions/10435481/how-do-i-get-the-dom-node-within-a-yui-event-handler --%>
					var likeNode = event.currentTarget;
					<portlet:namespace />like(likeNode);
				   	
				});
			   
			});
				
			Liferay.provide(
				window,
				'<portlet:namespace />like', 
				function(likeNode) {
				   	var likeData = JSON.parse(likeNode.getAttribute('data-like'));
					document.title += " -likeData: " + likeData;
					var A = AUI('aui-node','aui-base','aui-io-request-deprecated');
					var ajaxUrl = "/api/jsonws/SPNeo4j-portlet.spneoforj/like?p_auth=" + Liferay.authToken;
					A.io.request(ajaxUrl,{
						dataType : 'json',
						method : 'POST',
						data : {
							companyId : likeData.companyId,
							groupId: likeData.groupId,
							layoutSetId: likeData.layoutSetId,
							action : likeData.action,
							startUserId : likeData.startUserId,
							endEntityClassName : likeData.endEntityClassName,
							endEntityId : likeData.endEntityId
						},
						on : {
							success : function() {
								var data = this.get('responseData');
								var exception = data.exception;
								if(!exception) {
									var action = likeData.action;
				
									if (action === "like") {
										action = "unlike";
									} else if (action === "unlike") {
										action = "like";
									}
									likeData["action"] = action;
									likeNode.setAttribute("data-like", JSON.stringify(likeData, "", ""));
				
									var likeCountElem = likeNode.ancestor().one('> .sp-lc');
									var likeCount = parseInt(likeCountElem.text());
				
									if (action === "like") {
										likeNode.removeClass("splike-liking");
										likeNode.addClass("splike-like");
										likeCountElem.text(likeCount - 1);
									} else if (action === "unlike") {
										likeNode.removeClass("splike-like");
										likeNode.addClass("splike-liking");
										likeCountElem.text(likeCount + 1);
									}
								}
							},
							failure : function() {
								alert("Oops! An error occurred while processing your request.");
							} 
						}
					});
				},
				['aui-base']
			);
		
		</aui:script>
		
	</c:when>
	<c:otherwise>
		<a href="javascript:;">Like</a>
	</c:otherwise>
</c:choose>

