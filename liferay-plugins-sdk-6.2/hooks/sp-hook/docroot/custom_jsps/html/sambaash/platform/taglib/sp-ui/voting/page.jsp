<%@ include file="/html/sambaash/platform/taglib/sp-ui/voting/init.jsp" %>

<%@ page import="com.sambaash.platform.srv.spvoting.service.SPVotingLocalServiceUtil" %>
<%@ page import="com.sambaash.platform.srv.spvoting.model.SPVoting" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%-- http://yuilibrary.com/yui/docs/event/ --%>
<%-- http://yuilibrary.com/yui/docs/node/ --%>

<%

String className = (String)request.getAttribute("sp-ui:voting:className");
long classPK = GetterUtil.getLong((String)request.getAttribute("sp-ui:voting:classPK"));

boolean isSignedIn = themeDisplay.isSignedIn();

long userId = themeDisplay.getUserId();

String ip = PortalUtil.getHttpServletRequest(renderRequest).getRemoteAddr();

//HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
//HttpServletRequest originalServletRequest = PortalUtil.getOriginalServletRequest(httpServletRequest);
//String ip = originalServletRequest.getRemoteAddr();

boolean voted = false;
if(isSignedIn) {
	try{
		SPVotingLocalServiceUtil.findByEntryAndUserId(className, classPK, userId);
		voted = true;
	}catch(Exception e) {
		// do nothing
	}
}else {
	try{
		SPVotingLocalServiceUtil.findByEntryAndIp(className, classPK, ip);
		voted = true;
	}catch(Exception e) {
		// do nothing
	}
}

int count = SPVotingLocalServiceUtil.countByEntry(className, classPK);

String voteUpData = "{ &quot;className&quot; : &quot;" + className + "&quot;,&quot;classPK&quot; : " + classPK + ", &quot;userId&quot; : " + userId + ", &quot;ip&quot; : &quot;" + ip + "&quot;, &quot;isSignedIn&quot; : " + isSignedIn + "}";

%>

<span class="voting-container">
	<c:choose>
		<c:when test="<%=voted %>">
			<span>VOTED!</span>
		</c:when>
		<c:otherwise>
			<span style="display: none;"></span>
			<a class="vote-up-link" href="javascript:;" data-voteup="<%=voteUpData %>" >VOTE ME!</a>
			
			<aui:script>
			
				AUI().use('event', 'node', function(A) {
					
				   	// Your code goes here
				   	
				   	var allVoteUpLinkObjects = A.all('.vote-up-link');
				   	
				   	allVoteUpLinkObjects.on('click', function(event) {
					   	
						<%-- http://stackoverflow.com/questions/10435481/how-do-i-get-the-dom-node-within-a-yui-event-handler --%>
						var voteUpNode = event.currentTarget;
					   	var voteUpData = JSON.parse(voteUpNode.getAttribute('data-voteup'));
						<portlet:namespace />voteUp(voteUpNode, voteUpData);
					   
					});
				   
				});
					
				Liferay.provide(
					window,
					'<portlet:namespace />voteUp', 
					function(voteUpNode, voteUpData) {
						var A = AUI('aui-node','aui-base','aui-io-request-deprecated');
						var ajaxUrl = "/api/jsonws/SPNeo4j-portlet.spneoforj/voteUp?p_auth=" + Liferay.authToken;
						A.io.request(ajaxUrl,{
							dataType : 'json',
							method : 'POST',
							data : {
									className : voteUpData.className, 
									classPK : voteUpData.classPK, 
									userId : voteUpData.userId, 
									ip : voteUpData.ip, 
									isSignedIn : voteUpData.isSignedIn
								},
							on : {
								success : function() {
									var data = this.get('responseData');
									var exception = data.exception;
							        if (!exception) {
					       	     		// Process Success
										var textMsgSpan = voteUpNode.previous();
										var newTextMsg = "VOTED!";
						              	voteUpNode.remove();
										textMsgSpan.text(newTextMsg).setStyle("display", "inline");
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
		</c:otherwise>
	</c:choose>
</span>
