
<%@ include file="/html/taglib/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.parsers.bbcode.BBCodeTranslatorUtil" %>
<%@ page import="com.liferay.portlet.messageboards.model.MBCategory" %>
<%@ page import="com.liferay.portlet.messageboards.model.MBDiscussion" %>
<%@ page import="com.liferay.portlet.messageboards.model.MBMessage" %>
<%@ page import="com.liferay.portlet.messageboards.model.MBMessageDisplay" %>
<%@ page import="com.liferay.portlet.messageboards.model.MBThread" %>
<%@ page import="com.liferay.portlet.messageboards.model.MBThreadConstants" %>
<%@ page import="com.liferay.portlet.messageboards.model.MBTreeWalker" %>
<%@ page import="com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.messageboards.service.permission.MBDiscussionPermission" %>
<%@ page import="com.liferay.portlet.messageboards.util.comparator.MessageCreateDateComparator" %>
<%@ page import="com.liferay.portlet.ratings.model.RatingsEntry" %>
<%@ page import="com.liferay.portlet.ratings.model.RatingsStats" %>
<%@ page import="com.liferay.portlet.ratings.service.RatingsEntryLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.ratings.service.RatingsStatsLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.ratings.service.persistence.RatingsEntryUtil" %>
<%@ page import="com.liferay.portlet.ratings.service.persistence.RatingsStatsUtil" %>
<%@ page import="sambaash.platform.util.SambaashUtil" %>

<portlet:defineObjects />
<%
String randomNamespace = PwdGenerator.getPassword(PwdGenerator.KEY3, 4) + StringPool.UNDERLINE;
String portletId = PortalUtil.getPortletId(request);
String isPortfolioPortlet = "false";
boolean isAdmin=false;
if(portletId.equalsIgnoreCase("portfolio_WAR_Portfolioportlet"))
	isPortfolioPortlet = "true";
String className = (String)request.getAttribute("liferay-ui:discussion:className");
long classPK = GetterUtil.getLong((String)request.getAttribute("liferay-ui:discussion:classPK"));
String formAction = (String)request.getAttribute("liferay-ui:discussion:formAction");
String formName = (String)request.getAttribute("liferay-ui:discussion:formName");
boolean hideControls = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:discussion:hideControls"));
String permissionClassName = (String)request.getAttribute("liferay-ui:discussion:permissionClassName");
long permissionClassPK = GetterUtil.getLong((String)request.getAttribute("liferay-ui:discussion:permissionClassPK"));
boolean ratingsEnabled = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:discussion:ratingsEnabled"));
String redirect = (String)request.getAttribute("liferay-ui:discussion:redirect");
long userId = GetterUtil.getLong((String)request.getAttribute("liferay-ui:discussion:userId"));
String urlTitle = (String)request.getAttribute("liferay-ui:discussion:urlTitle");
String title = (String)request.getAttribute("liferay-ui:discussion:subject");


String strutsAction = ParamUtil.getString(request, "struts_action");

String threadView = PropsValues.DISCUSSION_THREAD_VIEW;

MBMessageDisplay messageDisplay = MBMessageLocalServiceUtil.getDiscussionMessageDisplay(userId, scopeGroupId, className, classPK, WorkflowConstants.STATUS_ANY, threadView);

MBCategory category = messageDisplay.getCategory();
MBThread thread = messageDisplay.getThread();
MBTreeWalker treeWalker = messageDisplay.getTreeWalker();
MBMessage rootMessage = null;
List<MBMessage> messages = null;
int messagesCount = 0;
SearchContainer searchContainer = null;
isAdmin = SambaashUtil.isAdmin(scopeGroupId,themeDisplay.getUserId());
if (treeWalker != null) {
	rootMessage = treeWalker.getRoot();
	messages = treeWalker.getMessages();
	messagesCount = messages.size();
}
else {
	rootMessage = MBMessageLocalServiceUtil.getMessage(thread.getRootMessageId());
	messagesCount = MBMessageLocalServiceUtil.getThreadMessagesCount(rootMessage.getThreadId(), WorkflowConstants.STATUS_ANY);
}
Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);
%>

<div class="hide lfr-message-response" id="<portlet:namespace />discussion-status-messages"></div>

<c:if test="<%= (messagesCount > 1) || MBDiscussionPermission.contains(permissionChecker, company.getCompanyId(), scopeGroupId, permissionClassName, permissionClassPK, userId, ActionKeys.VIEW) %>">
	<div class="taglib-discussion">
		<aui:form action="<%= formAction %>" method="post" name="<%= formName %>">
			<aui:input name="randomNamespace" type="hidden" value="<%= randomNamespace %>" />
			<aui:input name="<%= Constants.CMD %>" type="hidden" />
			<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
			<aui:input name="className" type="hidden" value="<%= className %>" />
			<aui:input name="classPK" type="hidden" value="<%= classPK %>" />
			<aui:input name="permissionClassName" type="hidden" value="<%= permissionClassName %>" />
			<aui:input name="permissionClassPK" type="hidden" value="<%= permissionClassPK %>" />
			<aui:input name="permissionOwnerId" type="hidden" value="<%= String.valueOf(userId) %>" />
			<aui:input name="messageId" type="hidden" />
			<aui:input name="threadId" type="hidden" value="<%= thread.getThreadId() %>" />
			<aui:input name="parentMessageId" type="hidden" />
			<aui:input name="body" type="hidden" />
			<aui:input name="workflowAction" type="hidden" value="<%= String.valueOf(WorkflowConstants.ACTION_PUBLISH) %>" />

			<%
			int i = 0;

			MBMessage message = rootMessage;
			%>
			<c:if test="<%= !hideControls && MBDiscussionPermission.contains(permissionChecker, company.getCompanyId(), scopeGroupId, permissionClassName, permissionClassPK, userId, ActionKeys.ADD_DISCUSSION) %>">
				<aui:fieldset cssClass="add-comment" id='<%= randomNamespace + "messageScroll0" %>'>
					<div id="<%= randomNamespace %>messageScroll<%= message.getMessageId() %>">
						<aui:input name='<%= "messageId" + i %>' type="hidden" value="<%= message.getMessageId() %>" />
						<aui:input name='<%= "parentMessageId" + i %>' type="hidden" value="<%= message.getMessageId() %>" />
					</div>

					<%
					String taglibPostReplyURL = "javascript:" + randomNamespace + "showForm('" + randomNamespace + "postReplyForm" + i + "', '" + namespace + randomNamespace + "postReplyBody" + i + "');";
					%>

					<%
					boolean subscribed = SubscriptionLocalServiceUtil.isSubscribed(company.getCompanyId(), user.getUserId(), className, classPK);

					String subscriptionURL = "javascript:" + randomNamespace + "subscribeToComments(" + !subscribed + ");";
					%>

					<c:if test="<%= themeDisplay.isSignedIn() %>">
						<c:choose>
							<c:when test="<%= subscribed %>">
								<liferay-ui:icon
									cssClass="subscribe-link"
									image="unsubscribe"
									label="<%= true %>"
									message="unsubscribe-from-comments"
									url="<%= subscriptionURL %>"
								/>
							</c:when>
							<c:otherwise>
								<liferay-ui:icon
									cssClass="subscribe-link"
									image="subscribe"
									label="<%= true %>"
									message="subscribe-to-comments"
									url="<%= subscriptionURL %>"
								/>
							</c:otherwise>
						</c:choose>
					</c:if>

					<aui:input name="emailAddress" type="hidden" />

					<div id="<%= randomNamespace %>postReplyForm<%= i %>">
						<aui:input id='<%= randomNamespace + "postReplyBody" + i %>' label="comment" name='<%= "postReplyBody" + i %>' style='<%= "height: " + ModelHintsConstants.TEXTAREA_DISPLAY_HEIGHT + "px; width: 96%;" %>' type="textarea" wrap="soft" />

						<%
						String postReplyButtonLabel = LanguageUtil.get(pageContext, "reply");

						if (!themeDisplay.isSignedIn()) {
							postReplyButtonLabel = LanguageUtil.get(pageContext, "reply-as");
						}

						if (WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(), scopeGroupId, MBDiscussion.class.getName()) && !strutsAction.contains("workflow")) {
							postReplyButtonLabel = LanguageUtil.get(pageContext, "submit-for-publication");
						}
						%>

						<c:if test="<%= !subscribed && themeDisplay.isSignedIn() %>">
							<aui:input helpMessage="comments-subscribe-me-help" label="subscribe-me" name="subscribe" type="checkbox" value="<%= PropsValues.DISCUSSION_SUBSCRIBE_BY_DEFAULT %>" />
						</c:if>

						<aui:button-row>
							<aui:button id='<%= namespace + randomNamespace + "postReplyButton" + i %>' onClick='<%= randomNamespace + "postReply(" + i + ");" %>' value="<%= postReplyButtonLabel %>" />

							<%
							String taglibCancel = "document.getElementById('" + randomNamespace + "postReplyForm" + i + "').style.display = 'none'; document.getElementById('" + namespace + randomNamespace + "postReplyBody" + i + "').value = ''; void('');";
							%>
						</aui:button-row>
					</div>
				</aui:fieldset>
			</c:if>
			<%
					String viewAllCommentsURL = "javascript:" + randomNamespace + "viewAllComments();";
					%>
			<c:if test="<%= messagesCount > 1 %>">
					<c:if test="<%= messagesCount > 3 %>">
						<aui:fieldset id="<portlet:namespace />viewCommentsLink">
							<a href="<%=viewAllCommentsURL%>">View all <%= messagesCount %> comments</a>
						</aui:fieldset>
					</c:if>
				<a name="<%= randomNamespace %>messages_top"></a>
				<c:if test="<%= treeWalker != null %>">
				<table class="tree-walker">
					<tr class="portlet-section-header results-header" style="font-size: x-small; font-weight: bold;">
						<td colspan="2">
							<liferay-ui:message key="threaded-replies" />
						</td>
						<td colspan="2">
							<liferay-ui:message key="author" />
						</td>
						<td>
							<liferay-ui:message key="date" />
						</td>
					</tr>

					<%
					int[] range = treeWalker.getChildrenRange(rootMessage);
					for (i = (range[1] - 1); i > range[0]; i--) {
						message = (MBMessage)messages.get(i);
						boolean lastChildNode = false;

						if (i == range[0]) {
							lastChildNode = true;
						}

						request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER, treeWalker);
						request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_SEL_MESSAGE, rootMessage);
						request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_CUR_MESSAGE, message);
						request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_CATEGORY, category);
						request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_THREAD, thread);
						request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_LAST_NODE, Boolean.valueOf(lastChildNode));
						request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_DEPTH, new Integer(0));
					%>

						<liferay-util:include page="/html/taglib/ui/discussion/gallery_view_message_thread.jsp" />

					<%
					}
					%>

				</table>

					<br />
				</c:if>

				<aui:layout>

					<%
					if (messages != null) {
						messages = ListUtil.sort(messages, new MessageCreateDateComparator(false));

						messages = ListUtil.copy(messages);

						messages.remove(0);
					}
					else {
						PortletURL currentURLObj = PortletURLUtil.getCurrent(renderRequest, renderResponse);

						searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, currentURLObj, null, null);

						searchContainer.setTotal(messagesCount - 1);

						messages = MBMessageLocalServiceUtil.getThreadRepliesMessages(message.getThreadId(), WorkflowConstants.STATUS_ANY, searchContainer.getStart(), searchContainer.getEnd());
						messages = ListUtil.sort(messages, new MessageCreateDateComparator(false));
						
						searchContainer.setResults(messages);
					}

					List<Long> classPKs = new ArrayList<Long>();

					for (MBMessage curMessage : messages) {
						classPKs.add(curMessage.getMessageId());
					}

					List<RatingsEntry> ratingsEntries = RatingsEntryLocalServiceUtil.getEntries(themeDisplay.getUserId(), MBDiscussion.class.getName(), classPKs);
					List<RatingsStats> ratingsStatsList = RatingsStatsLocalServiceUtil.getStats(MBDiscussion.class.getName(), classPKs);

					int _visible = 3;
					String _style = "display: block;";
					
					for (i = 1; i <= messages.size(); i++) {
						message = messages.get(i - 1);

						if ((!message.isApproved() && ((message.getUserId() != user.getUserId()) || user.isDefaultUser()) && !permissionChecker.isGroupAdmin(scopeGroupId)) || !MBDiscussionPermission.contains(permissionChecker, company.getCompanyId(), scopeGroupId, permissionClassName, permissionClassPK, userId, ActionKeys.VIEW)) {
							continue;
						}

						String cssClass =  StringPool.BLANK;
						if (i > _visible) {
							_style = "display: none;";
						}
						if (i == 1) {
							cssClass = "first";
						}
						else if (i == messages.size()) {
							cssClass = "last";
						}
					%>
							
						<div class="lfr-discussion <%= cssClass %>" style="<%= _style %>">
							<div id="<%= randomNamespace %>messageScroll<%= message.getMessageId() %>">
								<a name="<%= randomNamespace %>message_<%= message.getMessageId() %>"></a>

								<aui:input name='<%= "messageId" + i %>' type="hidden" value="<%= message.getMessageId() %>" />
								<aui:input name='<%= "parentMessageId" + i %>' type="hidden" value="<%= message.getMessageId() %>" />
							</div>

							<aui:column cssClass="lfr-discussion-details">
								<liferay-ui:user-display
									userId="<%= message.getUserId() %>"
									userName="<%= HtmlUtil.escape(message.getUserName()) %>"
									displayStyle="<%= 2 %>"
								/>
							</aui:column>

							<aui:column cssClass="lfr-discussion-body">
								<c:if test="<%= (message != null) && !message.isApproved() %>">
									<aui:model-context bean="<%= message %>" model="<%= MBMessage.class %>" />

									<div>
										<aui:workflow-status model="<%= MBDiscussion.class %>" status="<%= message.getStatus() %>" />
									</div>
								</c:if>

								<div class="lfr-discussion-message">

									<%
									String msgBody = BBCodeTranslatorUtil.getHTML(message.getBody());

									msgBody = StringUtil.replace(msgBody, "@theme_images_path@/emoticons", themeDisplay.getPathThemeImages() + "/emoticons");
									msgBody = HtmlUtil.wordBreak(msgBody, 80);
									%>

									<%= msgBody %>
								</div>

								<div class="lfr-discussion-controls">
									<c:if test="<%= ratingsEnabled %>">

										<%
										RatingsEntry ratingsEntry = getRatingsEntry(ratingsEntries, message.getMessageId());
										RatingsStats ratingStats = getRatingsStats(ratingsStatsList, message.getMessageId());
										%>

										<liferay-ui:ratings
											className="<%= MBDiscussion.class.getName() %>"
											classPK="<%= message.getMessageId() %>"
											ratingsEntry="<%= ratingsEntry %>"
											ratingsStats="<%= ratingStats %>"
											type="thumbs"
										/>
									</c:if>
								
									<c:if test="<%= !hideControls %>">
										<ul class="lfr-discussion-actions" style="display: block;">
											<c:if test="<%= i > 0 %>">

												<%
												String taglibTopURL = "#" + randomNamespace + "messages_top";
												%>
												<li>
													<liferay-ui:icon
														image="top"
														label="<%= true %>"
														url="<%= taglibTopURL %>"
														/>
												</li>

												<c:if test="<%= MBDiscussionPermission.contains(permissionChecker, company.getCompanyId(), scopeGroupId, permissionClassName, permissionClassPK, message.getMessageId(), userId, ActionKeys.UPDATE_DISCUSSION) %>">

													<%
													String taglibEditURL = "javascript:" + randomNamespace + "showForm('" + randomNamespace + "editForm" + i + "', '" + namespace + randomNamespace + "editReplyBody" + i + "');";
													if ((message.getUserId() == user.getUserId()) || isAdmin){
													%>

													<li>
														<liferay-ui:icon
															image="edit"
															label="<%= true %>"
															url="<%= taglibEditURL %>"
														/>
													</li>
													<% } %>
												</c:if>

												<c:if test="<%= MBDiscussionPermission.contains(permissionChecker, company.getCompanyId(), scopeGroupId, permissionClassName, permissionClassPK, message.getMessageId(), userId, ActionKeys.DELETE_DISCUSSION) %>">

													<%
													String taglibDeleteURL = "javascript:" + randomNamespace + "deleteMessage(" + i + ");";
													if ((message.getUserId() == user.getUserId()) || isAdmin){
													%>

													<li>
														<liferay-ui:icon-delete
															label="<%= true %>"
															url="<%= taglibDeleteURL %>"
														/>
													</li>
													<% } %>
												</c:if>
											</c:if>
										</ul>
									</c:if>
								</div>
							</aui:column>

							<aui:layout cssClass="lfr-discussion-form-container">
								<div id="<%= randomNamespace %>postReplyForm<%= i %>" class="lfr-discussion-form lfr-discussion-form-reply" style="display: none;">

									<liferay-ui:user-display
										displayStyle="<%= 2 %>"
										userId="<%= user.getUserId() %>"
										userName="<%= HtmlUtil.escape(PortalUtil.getUserName(user.getUserId(), StringPool.BLANK)) %>"
									/>

									<aui:input id='<%= randomNamespace + "postReplyBody" + i %>' label="" name='<%= "postReplyBody" + i %>' style='<%= "height: " + ModelHintsConstants.TEXTAREA_DISPLAY_HEIGHT + "px; width: 96%;" %>' type="textarea" wrap="soft" />

									<aui:button-row>
										<aui:button id='<%= namespace + randomNamespace + "postReplyButton" + i %>' onClick='<%= randomNamespace + "postReply(" + i + ");" %>' value='<%= themeDisplay.isSignedIn() ? "reply" : "reply-as" %>' />

										<%
										String taglibCancel = "document.getElementById('" + randomNamespace + "postReplyForm" + i + "').style.display = 'none'; document.getElementById('" + namespace + randomNamespace + "postReplyBody" + i + "').value = ''; void('');";
										%>

										<aui:button onClick="<%= taglibCancel %>" type="cancel" />
									</aui:button-row>
								</div>

								<c:if test="<%= !hideControls && MBDiscussionPermission.contains(permissionChecker, company.getCompanyId(), scopeGroupId, permissionClassName, permissionClassPK, message.getMessageId(), userId, ActionKeys.UPDATE_DISCUSSION) %>">
									<div class="lfr-discussion-form lfr-discussion-form-edit" id="<%= randomNamespace %>editForm<%= i %>" style="display: none;">
										<aui:input id='<%= randomNamespace + "editReplyBody" + i %>' label="" name='<%= "editReplyBody" + i %>' style='<%= "height: " + ModelHintsConstants.TEXTAREA_DISPLAY_HEIGHT + "px; width: 96%;" %>' value="<%= message.getBody() %>" type="textarea" wrap="soft" />

										<%
										boolean pending = message.isPending();

										String publishButtonLabel = LanguageUtil.get(pageContext, "publish");

										if (WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(), scopeGroupId, MBDiscussion.class.getName())) {
											if (pending) {
												publishButtonLabel = "save";
											}
											else {
												publishButtonLabel = LanguageUtil.get(pageContext, "submit-for-publication");
											}
										}
										%>

										<aui:button-row>
											<aui:button name='<%= randomNamespace + "editReplyButton" + i %>' onClick='<%= randomNamespace + "updateMessage(" + i + ");" %>' value="<%= publishButtonLabel %>" />

											<%
											String taglibCancel = "document.getElementById('" + randomNamespace + "editForm" + i + "').style.display = 'none'; document.getElementById('" + namespace + randomNamespace + "editReplyBody" + i + "').value = '" + message.getBody() + "'; void('');";
											%>

											<aui:button onClick="<%= taglibCancel %>" type="cancel" />
										</aui:button-row>
									</div>
								</c:if>
							</aui:layout>
							
							<div class="lfr-discussion-posted-on">
								<c:choose>
									<c:when test="<%= message.getParentMessageId() == rootMessage.getMessageId() %>">
										<%= LanguageUtil.format(pageContext, "posted-on-x", dateFormatDateTime.format(message.getModifiedDate())) %>
									</c:when>
									<c:otherwise>

										<%
										MBMessage parentMessage = MBMessageLocalServiceUtil.getMessage(message.getParentMessageId());
										
										StringBundler sb = new StringBundler(7);

										sb.append("<a href=\"#");
										sb.append(randomNamespace);
										sb.append("message_");
										sb.append(parentMessage.getMessageId());
										sb.append("\">");
										sb.append(HtmlUtil.escape(parentMessage.getUserName()));
										sb.append("</a>");
										%>

										<%= LanguageUtil.format(pageContext, "posted-on-x-in-reply-to-x", new Object[] {dateFormatDateTime.format(message.getModifiedDate()), sb.toString()}) %>
									</c:otherwise>
								</c:choose>
						</div>
						<% String bookmarkUrl = urlTitle + "/" +  message.getMessageId();
						%>
						<div style="float: left;">
								<liferay-ui:social-bookmarks
									target="_blank"
									title="<%=title %>"
									url="<%=bookmarkUrl %>"
								/>
								</div>
								<%-- 
								<!-- Facebook Share -->
								<fb:like href="<%=bookmarkUrl%>" layout="button_count" send="false" show_faces="true"> </fb:like> 
								<!-- Twitter Share -->
								<a class="twitter-share-button" data-text="<%=title%>" data-url="<%=bookmarkUrl%>" href="https://twitter.com/share">Tweet</a> 
								<!-- Google+ Share -->
								<g:plus action="share" width="90px" annotation="bubble" href="<%=bookmarkUrl%>"></g:plus>
								<!-- LinkedIn Share -->
								<script type="IN/Share" data-url="<%=bookmarkUrl%>" data-counter="right"></script>
								--%>
							</div>

					<%
					}
					%>

				</aui:layout>

				<c:if test="<%= (searchContainer != null) && (searchContainer.getTotal() > searchContainer.getDelta()) %>">
					<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
				</c:if>
			</c:if>
		</aui:form>
	</div>

	<%
	/**
	PortletURL loginURL = PortletURLFactoryUtil.create(request, PortletKeys.FAST_LOGIN, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);

	loginURL.setWindowState(LiferayWindowState.POP_UP);
	loginURL.setPortletMode(PortletMode.VIEW);

	loginURL.setParameter("saveLastPath", "0");
	loginURL.setParameter("struts_action", "/login/login");
	*/
	
	String signinURL = sambaash.platform.util.SambaashUtil.getSignInURL(themeDisplay.getScopeGroupId(),  themeDisplay, false);
	if(Validator.isNotNull(redirect)) {
		signinURL = HttpUtil.setParameter(signinURL, "redirect", redirect);
	}
	
	%>

	<aui:script>
		function <%= randomNamespace %>afterLogin(emailAddress, anonymousAccount) {
			document.<%= namespace %><%= formName %>.<%= namespace %>emailAddress.value = emailAddress;

			if (anonymousAccount) {
				<portlet:namespace />sendMessage(document.<portlet:namespace /><%= formName %>);
			}
			else {
				<portlet:namespace />sendMessage(document.<portlet:namespace /><%= formName %>, true);
			}
		}

		function <%= randomNamespace %>deleteMessage(i) {
			eval("var messageId = document.<%= namespace %><%= formName %>.<%= namespace %>messageId" + i + ".value;");

			document.<%= namespace %><%= formName %>.<%= namespace %><%= Constants.CMD %>.value = "<%= Constants.DELETE %>";
			document.<%= namespace %><%= formName %>.<%= namespace %>messageId.value = messageId;
			<portlet:namespace />sendMessage(document.<%= namespace %><%= formName %>);
		}

		function <%= randomNamespace %>postReply(i) {
			eval("var parentMessageId = document.<%= namespace %><%= formName %>.<%= namespace %>parentMessageId" + i + ".value;");
			eval("var body = document.<%= namespace %><%= formName %>.<%= namespace %>postReplyBody" + i + ".value;");

			document.<%= namespace %><%= formName %>.<%= namespace %><%= Constants.CMD %>.value = "<%= Constants.ADD %>";
			document.<%= namespace %><%= formName %>.<%= namespace %>parentMessageId.value = parentMessageId;
			document.<%= namespace %><%= formName %>.<%= namespace %>body.value = body;

			if (!themeDisplay.isSignedIn()) {
				window.namespace = '<%= namespace %>';
				window.randomNamespace = '<%= randomNamespace %>';
				
				window.location = '<%= signinURL %>';
			}
			else {
				<portlet:namespace />sendMessage(document.<%= namespace %><%= formName %>);
			}
		}

		function <%= randomNamespace %>scrollIntoView(messageId) {
			document.getElementById("<%= randomNamespace %>messageScroll" + messageId).scrollIntoView();
		}

		function <%= randomNamespace %>showForm(rowId, textAreaId) {
			document.getElementById(rowId).style.display = "";
			document.getElementById(textAreaId).focus();
		}

		function <%= randomNamespace %>subscribeToComments(subscribe) {
			if (subscribe) {
				document.<%= namespace %><%= formName %>.<%= namespace %><%= Constants.CMD %>.value = "<%= Constants.SUBSCRIBE_TO_COMMENTS %>";
			}
			else {
				document.<%= namespace %><%= formName %>.<%= namespace %><%= Constants.CMD %>.value = "<%= Constants.UNSUBSCRIBE_FROM_COMMENTS %>";
			}

			<portlet:namespace />sendMessage(document.<%= namespace %><%= formName %>);
		}
		
		function <%= randomNamespace %>viewAllComments() {
			var A = AUI();
			var _commentSections = A.all(".lfr-discussion");
			
			_commentSections.each(function() {
    			var _section = this;
    			_section.setAttribute("style", "display: block;");
    		});
    		A.one("#<portlet:namespace />viewCommentsLink").hide();
		}

		function <%= randomNamespace %>updateMessage(i, pending) {
			eval("var messageId = document.<%= namespace %><%= formName %>.<%= namespace %>messageId" + i + ".value;");
			eval("var body = document.<%= namespace %><%= formName %>.<%= namespace %>editReplyBody" + i + ".value;");

			if (pending) {
				document.<%= namespace %><%= formName %>.<%= namespace %>workflowAction.value = <%= WorkflowConstants.ACTION_SAVE_DRAFT %>;
			}

			document.<%= namespace %><%= formName %>.<%= namespace %><%= Constants.CMD %>.value = "<%= Constants.UPDATE %>";
			document.<%= namespace %><%= formName %>.<%= namespace %>messageId.value = messageId;
			document.<%= namespace %><%= formName %>.<%= namespace %>body.value = body;

			<portlet:namespace />sendMessage(document.<%= namespace %><%= formName %>);
		}

		Liferay.provide(
			window,
			'<portlet:namespace />sendMessage',
			function(form, refreshPage) {
				var A = AUI();

				var uri = form.getAttribute('action');

				A.io.request(
					uri,
					{
						dataType: 'json',
						form: {
							id: form
						},
						on: {
							failure: function(event, id, obj) {
								<portlet:namespace />showStatusMessage('error', '<%= UnicodeLanguageUtil.get(pageContext, "your-request-failed-to-complete") %>');
							},
							success: function(event, id, obj) {
								var response = this.get('responseData');

								var exception = response.exception;

								if (!exception) {
									Liferay.after(
										'<%= portletDisplay.getId() %>:messagePosted',
										function(event) {
											<portlet:namespace />onMessagePosted(response, refreshPage);
										}
									);

									Liferay.fire('<%= portletDisplay.getId() %>:messagePosted', response);
								}
								else {
									var errorKey = '';

									if (exception.indexOf('MessageBodyException') > -1) {
										errorKey = '<%= UnicodeLanguageUtil.get(pageContext, "please-enter-a-valid-message") %>';
									}
									else if (exception.indexOf('NoSuchMessageException') > -1) {
										errorKey = '<%= UnicodeLanguageUtil.get(pageContext, "the-message-could-not-be-found") %>';
									}
									else if (exception.indexOf('PrincipalException') > -1) {
										errorKey = '<%= UnicodeLanguageUtil.get(pageContext, "you-do-not-have-the-required-permissions") %>';
									}
									else if (exception.indexOf('RequiredMessageException') > -1) {
										errorKey = '<%= UnicodeLanguageUtil.get(pageContext, "you-cannot-delete-a-root-message-that-has-more-than-one-immediate-reply") %>';
									}
									else {
										errorKey = '<%= UnicodeLanguageUtil.get(pageContext, "your-request-failed-to-complete") %>';
									}

									<portlet:namespace />showStatusMessage('error', errorKey);
								}
							}
						}
					}
				);
			},
			['aui-io-deprecated']
		);

		Liferay.provide(
			window,
			'<portlet:namespace />onMessagePosted',
			function(response, refreshPage) {
				var A = AUI();

				Liferay.after(
					'<%= portletDisplay.getId() %>:portletRefreshed',
					function(event) {
						<portlet:namespace />showStatusMessage('success', '<%= UnicodeLanguageUtil.get(pageContext, "your-request-processed-successfully") %>');
<!-- TODO : Harini : commented for unknown issue on gallery for commenting and editing (error in url undefinedmessageScrollundefined) -->
	<!--  					location.hash = '#' + response.randomNamespace + 'messageScroll' + response.messageId; -->
<!--  Till here -->
						if('<%=isPortfolioPortlet %>' == 'true')
						window.location.reload();
					}
				);

				if (refreshPage) {
					window.location.reload();
				}
				else {
					Liferay.Portlet.refresh('#p_p_id_<%= portletDisplay.getId() %>_');
				}
			},
			['aui-base']
		);

		Liferay.provide(
			window,
			'<portlet:namespace />showStatusMessage',
			function(type, message) {
				var A = AUI();

				var messageContainer = A.one('#<portlet:namespace />discussion-status-messages');

				messageContainer.removeClass('portlet-msg-error');
				messageContainer.removeClass('portlet-msg-success');

				messageContainer.addClass('portlet-msg-' + type);

				messageContainer.html(message);

				messageContainer.show();
			},
			['aui-base']
		);
	</aui:script>
</c:if>

<%!
private RatingsEntry getRatingsEntry(List<RatingsEntry> ratingEntries, long classPK) {
	for (RatingsEntry ratingsEntry : ratingEntries) {
		if (ratingsEntry.getClassPK() == classPK) {
			return ratingsEntry;
		}
	}

	return RatingsEntryUtil.create(0);
}

private RatingsStats getRatingsStats(List<RatingsStats> ratingsStatsList, long classPK) {
	for (RatingsStats ratingsStats : ratingsStatsList) {
		if (ratingsStats.getClassPK() == classPK) {
			return ratingsStats;
		}
	}

	return RatingsStatsUtil.create(0);
}
%>