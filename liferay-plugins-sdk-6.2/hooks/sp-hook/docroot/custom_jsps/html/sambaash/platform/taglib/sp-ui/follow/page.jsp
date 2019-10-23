<%@ include file="/html/sambaash/platform/taglib/sp-ui/follow/init.jsp" %>

<%@ page import="com.sambaash.platform.srv.graph.service.SPNeoforjLocalServiceUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%-- http://yuilibrary.com/yui/docs/event/ --%>
<%-- http://yuilibrary.com/yui/docs/node/ --%>

<%-- http://www.liferay.com/community/forums/-/message_boards/message/7014901 --%>

<%-- http://alloyui.com/rosetta-stone/ --%>
<%-- http://alloyui.com/versions/1.0.x/api/Node.html#method_removeClass --%>

<style type="text/css">

	/* ------------------------------ follow ------------------------------ */
	
	.spfollow-btn-follow {
	    text-transform: uppercase;
	}
	
	a.spfollow-btn-follow:hover {
		text-decoration: none;
	}
	a.spfollow-btn-follow {
		color: #333333;
	}
	.spfollow-btn-follow span {
	    display: none;
	}
	.spfollow-btn-follow.spfollow-following span {
	}
	.spfollow-btn-follow.spfollow-follow:hover .spfollow-text-follow {
	    text-decoration: none;
	}
	.spfollow-btn-follow.spfollow-unfollow span, .spfollow-btn-follow.spfollow-following:hover span {
	}
	.spfollow-btn-follow.spfollow-follow .spfollow-text-follow, .spfollow-btn-follow.spfollow-following .spfollow-text-following, .spfollow-btn-follow.spfollow-following:hover .spfollow-text-unfollow, .spfollow-btn-follow.spfollow-unfollow .spfollow-text-unfollow, .spfollow-btn-follow.spfollow-unfollow:hover .spfollow-text-follow {
	    display: inline;
	}
	.spfollow-btn-follow.spfollow-following:hover .spfollow-text-following, .spfollow-btn-follow.spfollow-unfollow:hover .spfollow-text-unfollow {
	    display: none;
	}

</style>

<c:choose>
	<c:when test="${themeDisplay.signedIn}">
		
		<%
		String communityName = (String)request.getAttribute("sp-ui:follow:communityName");
		String className = (String)request.getAttribute("sp-ui:follow:className");
		long classPK = GetterUtil.getLong((String)request.getAttribute("sp-ui:follow:classPK"));
		String linkOrBtn = (String)request.getAttribute("sp-ui:follow:linkOrBtn");
		
		boolean isLink = false;
		if(com.liferay.portal.kernel.util.Validator.isNotNull(linkOrBtn)) {
			if("link".equalsIgnoreCase(linkOrBtn.toLowerCase())) {
				isLink = true;
			}
		}
		
		long userId = themeDisplay.getUserId();
		
		String action = "follow";
		boolean isFollowing = SPNeoforjLocalServiceUtil.isFollowing(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), themeDisplay.getLayoutSet().getLayoutSetId(), userId, com.liferay.portal.model.User.class.getName(), classPK);
		if(isFollowing) {
			action = "unfollow";
		}
		
		String followData = "{ &quot;companyId&quot; : &quot;" + themeDisplay.getCompanyId() + "&quot;,&quot;groupId&quot; : &quot;" + themeDisplay.getScopeGroupId()+ "&quot;,&quot;layoutSetId&quot; : &quot;" + themeDisplay.getLayoutSet().getLayoutSetId() + "&quot;,&quot;action&quot; : &quot;" + action + "&quot;,&quot;startUserId&quot; : " + userId + ", &quot;endEntityClassName&quot; : &quot;" + className + "&quot;, &quot;endEntityId&quot; : " + classPK + "}";
		
		%>
		
		<a href="javascript:;" data-follow="<%=followData %>" class="<c:if test="<%=!isLink %>">lfr-actions aui-button-input</c:if> spfollow-btn-follow <c:choose><c:when test="<%=isFollowing %>">spfollow-following btn-remove</c:when><c:otherwise>spfollow-follow</c:otherwise></c:choose>" ><span class="spfollow-text-follow">+ Follow</span><span class="spfollow-text-following">Following</span><span class="spfollow-text-unfollow">unfollow</span></a>
		<%-- style="<c:choose><c:when test="<%=!isLink %>">padding: 5px;</c:when><c:otherwise></c:otherwise> </c:choose>" --%>
		<aui:script>
		
			AUI().use('event', 'node', function(A) {
				
			   	// Your code goes here
			   	
			   	var allFollowBtnObjects = A.all('.spfollow-btn-follow');
			   	
			   	allFollowBtnObjects.on('click', function(event) {
					<%-- http://stackoverflow.com/questions/10435481/how-do-i-get-the-dom-node-within-a-yui-event-handler --%>
					var followNode = event.currentTarget;
					<portlet:namespace />follow(followNode);
				   	
				});
			   
			});
				
			Liferay.provide(
				window,
				'<portlet:namespace />follow', 
				function(followNode) {
				   	var followData = JSON.parse(followNode.getAttribute('data-follow'));
					var A = AUI('aui-node','aui-base','aui-io-request-deprecated');
					var ajaxUrl = "/api/jsonws/SPNeo4j-portlet.spneoforj/follow?p_auth=" + Liferay.authToken;
					A.io.request(ajaxUrl,{
							dataType : 'json',
							method : 'POST',
							data : {
								companyId : followData.companyId,
								groupId: followData.groupId,
								layoutSetId: followData.layoutSetId,
								action : followData.action, 
								startUserId : followData.startUserId, 
								endEntityClassName : followData.endEntityClassName, 
								endEntityId : followData.endEntityId
							},
							on : {
								success : function() {
									var data = this.get('responseData');
									var exception = data.exception;
							        if (!exception) {
					       	     		// Process Success
					       	     		
					       	     		var action = followData.action;
					       	     		
										if(action === "follow") {
											action = "unfollow";
										}else if(action === "unfollow") {
											action = "follow";
										}
										
										followData["action"] = action;
										followNode.setAttribute("data-follow", JSON.stringify(followData, "", ""));
										
										if(action === "follow") {
											followNode.removeClass("spfollow-following");
											followNode.addClass("spfollow-follow");
										}else if(action === "unfollow") {
											followNode.removeClass("spfollow-follow");
											followNode.addClass("spfollow-following");
										}
									} else {
						            	// Process Exception
										alert("Oops! An error occurred while processing your request.");
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
		<a href="javascript:;" class="lfr-actions button-input" style="padding: 5px;">Follow</a>
	</c:otherwise>
</c:choose>

