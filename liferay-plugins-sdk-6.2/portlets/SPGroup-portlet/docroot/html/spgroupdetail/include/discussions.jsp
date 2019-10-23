<%@page import="com.sambaash.platform.portlet.spgroup.util.Util"%>

<%
	String portraitUrl = "";
	if (themeDisplay.isSignedIn()) {
		portraitUrl = Util.getUserPortraitUrl(themeDisplay);
	}
%>
<div class="sp-gd-section" data-comment-dom-id="comment-container" data-comment-entry-id="<%= spGroup.getSpGroupId() %>">
	<div class="sp-group-pbs sp-group-ui-relative">
		<span class="sp-group-fwb sp-group-fsl" data-comment-dom-id="parent-count"><c:out value="${parentCount}"></c:out></span>&nbsp;<span class="sp-group-fwb sp-group-fsn"><liferay-ui:message key="label.discussion" /></span>
	</div>
	<c:if test="${themeDisplay.signedIn}">
		<div class="sp-gd-composer" data-comment-dom-id="add-comment-form-container">
			<div class="sp-gd-composer-inner">
				<img alt="User Image" class="avatar" data-comment-dom-id="avatar" src="<%= portraitUrl %>" style="display: none;" />
				<div data-comment-dom-id="add-comment-textarea-container">
					<form action="<%= addCommentURL %>" data-comment-dom-id="add-comment-form" method="post">
						<input name="<portlet:namespace />classPK" type="hidden" value="<%= spGroup.getSpGroupId() %>" />
						<input name="<portlet:namespace />className" type="hidden" value="<%= sambaash.platform.portlet.group.model.SPGroup.class.getName() %>" />
						<div class="sp-gd-textarea-outer">
							<textarea data-comment-dom-id="add-comment-textarea" style="height: 14px;"><liferay-ui:message key="label.add.discussion" /></textarea>
						</div>
						<div align="right" class="sp-group-mts" data-comment-dom-id="add-comment-submit" style="display: none;">
							<c:choose>
								<c:when test="${!commentServiceHasAccess}">
									<input class="sp-gd-btn small sp-group-service-access-check btn-primary" name="<portlet:namespace />${commentServiceUserStatus}&upload=false" title="Permission Denied" type="button" value="<%= LanguageUtil.get(pageContext,'label.comment') %>" />
								</c:when>
								<c:otherwise>
									<input class="sp-gd-btn small btn-primary" type="submit" value="<%= LanguageUtil.get(pageContext,'label.comment') %>" />
								</c:otherwise>
							</c:choose>
						</div>
					</form>
				</div>
			</div>
		</div>
	</c:if>

	<div data-loadmore-dom-id="loadmore-container">
		<ul class="sp-gd-entry-container" data-comment-dom-id="entry-container" data-loadmore-dom-id="items-container">
			<c:forEach items="${parentCommentBos}" var="parentCommentBo">
				<li class="sp-gd-entry level1" data-comment-id="${parentCommentBo.commentId}" data-comment-is-parent="true">
					<div class="sp-gd-entry-inner">
						<a href="/${themeDisplay.user.screenName}">
							<img alt="${themeDisplay.user.screenName}" class="avatar" src="${parentCommentBo.portraitUrl}" />
						</a>
						<div class="sp-gd-content-wrap">
							<div class="sp-gd-content">
								<a class="sp-group-fwb" href="/${parentCommentBo.screenName}">${parentCommentBo.screenName}</a> - <span class="sp-group-fcl">${parentCommentBo.displayDate} - ${parentCommentBo.createDate}</span>
								<div><a href="${parentCommentBo.viewDiscussionURL}">${parentCommentBo.content}</a></div>
								<c:if test="${themeDisplay.signedIn}">
									<div class="sp-group-fss">
										<a data-comment-dom-id="add-reply-link" href="#">Reply</a><c:if test="${themeDisplay.user.userId == parentCommentBo.userId}">&nbsp;<a href="#" data-comment-dom-id="delete-link"><liferay-ui:message key="label.delete" /></a></c:if>
									</div>
								</c:if>
							</div>

							<div class="sp-gd-reply-container" data-loadmore-dom-id="loadmore-container">
								<ul class="sp-group-child-entry-container" data-comment-dom-id="child-entry-container" data-loadmore-dom-id="items-container">
					    			<c:forEach items="${parentCommentBo.childCommentBos}" var="childCommentBo">
					    				<li data-comment-id="${childCommentBo.commentId}" data-comment-is-parent="false" class="sp-gd-entry level">
											<div class="sp-gd-entry-inner">
												<a href="/${childCommentBo.screenName}"><img alt="${childCommentBo.screenName}" src="${childCommentBo.portraitUrl}" class="avatar" /></a>
												<div class="sp-gd-content-wrap">
													<div class="sp-gd-content">
														<a class="sp-group-fwb" href="/${childCommentBo.screenName}">${childCommentBo.screenName}</a> - <span class="sp-group-fcl">${childCommentBo.displayDate} - ${parentCommentBo.createDate}</span>
														<div>${childCommentBo.content}</div>
														<c:if test="${themeDisplay.signedIn}">
															<div class="sp-group-fss">
																<a data-comment-dom-id="add-reply-link" href="#">Reply</a><c:if test="${themeDisplay.user.userId == childCommentBo.userId}">&nbsp;<a href="#" data-comment-dom-id="delete-link"><liferay-ui:message key="label.delete" /></a></c:if>
												    		</div>
											    		</c:if>
													</div>
												</div>
											</div>
										</li>
					    			</c:forEach>
								</ul>

								<div class="sp-gd-children-more" <c:if test="${parentCommentBo.childCount <= fn:length(parentCommentBo.childCommentBos)}">style="display: none;"</c:if> ><a href="${parentCommentBo.viewDiscussionURL}"><liferay-ui:message key="label.view" /> <span data-loadmore-dom-id="unshown-status">${parentCommentBo.childCount - fn:length(parentCommentBo.childCommentBos)}</span> <liferay-ui:message key="label.more" /></a></div>
								<!--
								<div class="sp-gd-children-more" data-loadmore-dom-id="view-more-link-container" <c:if test="${parentCommentBo.childCount <= fn:length(parentCommentBo.childCommentBos)}">style="display: none;"</c:if> ><a data-loadmore-dom-id="view-more-link" data-loadmore="{ &quot;retrieve_url&quot; : &quot;<%= retrieveRepliesURL %>&quot; ,&quot;retrieve_params&quot; : { &quot;parent_id&quot; : &quot;${parentCommentBo.commentId}&quot;, &quot;offset&quot; : 3, &quot;cur_showing_no&quot; : ${fn:length(parentCommentBo.childCommentBos)}, &quot;init_total&quot; : ${parentCommentBo.childCount} }, &quot;no_results_msg&quot; : &quot;&quot;, &quot;no_more_results_msg&quot; : &quot;&quot;, &quot;error_msg&quot; : &quot;This stream is unavailable at this time. Please try again soon.&quot; }" href="#">View <span data-loadmore-dom-id="unshown-status">${parentCommentBo.childCount - fn:length(parentCommentBo.childCommentBos)}</span> more</a></div>
								<div align="center" data-loadmore-dom-id="loading-status" style="display: none;"><span>Loading...</span></div>
								<div align="center" data-loadmore-dom-id="load-msg" style="display: none;"></div>
								 -->
								<c:if test="${themeDisplay.signedIn}">
									<div class="sp-gd-entry level2" data-comment-dom-id="add-reply-form-container" style="display: none;">
										<div class="sp-gd-entry-inner">
											<img alt="User Image" class="avatar" src="<%= portraitUrl %>" />
											<div style="margin: 0 0 8px 48px; min-height: 40px;">
												<form action="<%= addReplyURL %>" data-comment-dom-id="add-reply-form" method="post">
													<input name="<portlet:namespace />classPK" type="hidden" value="<%= spGroup.getSpGroupId() %>" />
													<input name="<portlet:namespace />className" type="hidden" value="<%= sambaash.platform.portlet.group.model.SPGroup.class.getName() %>" />
													<div class="sp-gd-textarea-outer">
														<textarea data-comment-dom-id="add-reply-textarea" style="height: 28px;" tabindex="-1"></textarea>
													</div>
													<div align="right" class="sp-group-mts">
														<c:choose>
															<c:when test="${!commentServiceHasAccess}">
																<input class="sp-gd-btn small sp-group-service-access-check btn-primary" name="<portlet:namespace />${commentServiceUserStatus}&upload=false" title="Permission Denied" type="button" value="<%= LanguageUtil.get(pageContext,'label.reply') %>" />
															</c:when>
															<c:otherwise>
																<input class="sp-gd-btn small btn-primary" data-comment-dom-id="add-reply-form-sumbit-btn" type="submit" value="<%= LanguageUtil.get(pageContext,'label.reply') %>" />
															</c:otherwise>
														</c:choose>
													</div>
												</form>
											</div>
										</div>
									</div>
								</c:if>
							</div>

						</div>
					</div>
				</li>
			</c:forEach>
		</ul>
		<div class="sp-gd-more sp-group-mts" data-loadmore-dom-id="view-more-link-container" <c:if test="${parentCount <= fn:length(parentCommentBos)}">style="display: none;"</c:if> align="center"><a data-loadmore-dom-id="view-more-link" href="#" data-loadmore="{ &quot;retrieve_url&quot; : &quot;<%=retrieveCommentsURL %>&quot;, &quot;retrieve_params&quot; : { &quot;class_pk&quot; : &quot;<%= spGroup.getSpGroupId() %>&quot;, &quot;url_title&quot; : &quot;<%= spGroup.getUrlTitle() %>&quot;, &quot;class_name&quot; : &quot;<%=sambaash.platform.portlet.group.model.SPGroup.class.getName() %>&quot;, &quot;offset&quot; : 5, &quot;cur_showing_no&quot; : ${fn:length(parentCommentBos)}, &quot;init_total&quot; : ${parentCount} }, &quot;no_results_msg&quot; : &quot;NO RESULTS FOUND&quot;, &quot;no_more_results_msg&quot; : &quot;NO MORE RESULTS&quot;, &quot;error_msg&quot; : &quot;This stream is unavailable at this time. Please try again soon.&quot; }"><liferay-ui:message key="label.view.more" /> (<span data-loadmore-dom-id="unshown-status">${parentCount - fn:length(parentCommentBos)}</span>)</a></div>
		<div align="center" class="sp-group-pas"  data-loadmore-dom-id="loading-status" style="display: none;"><span><liferay-ui:message key="label.loading" /></span></div>
		<div align="center" class="sp-group-pas"  data-loadmore-dom-id="load-msg" style="display: none;"></div>
	</div>
</div>
