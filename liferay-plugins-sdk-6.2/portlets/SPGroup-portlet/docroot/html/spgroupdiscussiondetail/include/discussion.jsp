<%@page import="com.sambaash.platform.portlet.spgroup.util.Util"%>
<%@page import="com.sambaash.platform.portlet.spgroup.wrapper.CommentBo"%>
<%@page import="com.sambaash.platform.srv.spgroup.model.SPGroup"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.sambaash.platform.util.SPHtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<liferay-theme:defineObjects />
<%
	String portraitUrl = "";
	if (themeDisplay.isSignedIn()) {
		portraitUrl = Util.getUserPortraitUrl(themeDisplay);
	}
%>

<div class="sp-gd-section" data-comment-dom-id="comment-container" data-comment-entry-id="<%= spGroup.getSpGroupId() %>">
	<div data-loadmore-dom-id="loadmore-container">
		<ul class="sp-gd-entry-container" data-comment-dom-id="entry-container" data-loadmore-dom-id="items-container">
			<li class="sp-gd-entry level1" data-comment-id="${parentCommentBo.commentId}" data-comment-is-parent="true">
				<div class="sp-gd-entry-inner">
					<div class="avatar-wrap">
						<a href="/${themeDisplay.user.screenName}"><img alt="${themeDisplay.user.screenName}" src="${parentCommentBo.portraitUrl}" class="avatar" /><span class="sp-group-mvm" style="display: block; height: 32px;">${parentCommentBo.fullName}</span></a>
					</div>
					<div class="sp-gd-content-wrap">
						<div class="sp-gd-content">
							<div class="sp-group-fsxl sp-group-mbs">${parentCommentBo.title}</div>
							<c:set var="commentDetails" value="${parentCommentBo.content}" />
							<% String commentDetails = (String) pageContext.getAttribute("commentDetails");
							if(Validator.isNotNull(commentDetails) && !commentDetails.isEmpty()){
								commentDetails = SPHtmlUtil.changeNewLineToBR(SPHtmlUtil.shortenHtmlTextWithLink(commentDetails,commentDetails.length()));
							}
							%>
							<div class="comment-details"><%=commentDetails %></div>
							<div class="sp-group-fss"><span class="sp-group-fcl"><liferay-ui:message key="label.posted" /> ${parentCommentBo.displayDate} - ${parentCommentBo.createDate}</span>
								<c:if test="${themeDisplay.signedIn && isMember}">
									<span> - </span><a href="#" data-comment-dom-id="add-reply-link" /><liferay-ui:message key="label.comment" /></a>
									<%--<a href="${parentCommentBo.viewDiscussionURL}"><span>(</span>" + ${parentCommentBo.childCount()} + "<span>)</span></a>"; --%>
									<c:if test="${themeDisplay.user.userId == parentCommentBo.userId}"><span> - </span><a href="#" data-comment-dom-id="delete-link"><liferay-ui:message key="label.delete" /></a></c:if>
								</c:if>
							</div>
						</div>

						<div class="sp-gd-reply-container" data-loadmore-dom-id="loadmore-container">
							<ul class="sp-group-child-entry-container" data-comment-dom-id="child-entry-container" data-loadmore-dom-id="items-container">
				    			<c:forEach items="${parentCommentBo.childCommentBos}" var="childCommentBo">
				    				<li data-comment-id="${childCommentBo.commentId}" data-comment-is-parent="false" class="sp-gd-entry level22">
										<div class="sp-gd-entry-inner">
											<div class="avatar-wrap"><a href="/${childCommentBo.screenName}"><img alt="${childCommentBo.screenName}" src="${childCommentBo.portraitUrl}" class="avatar" /></a></div>
											<div class="sp-gd-content-wrap">
												<div class="sp-gd-content">
													<a class="sp-group-fwb" href="/${childCommentBo.screenName}">${childCommentBo.fullName}</a> - <span>${childCommentBo.content}</span>
													<div class="sp-group-fss">
														<span class="sp-group-fcl">${childCommentBo.displayDate} - ${childCommentBo.createDate}</span>
														<c:if test="${themeDisplay.signedIn && isMember}">
															<span> - </span><a data-comment-dom-id="add-reply-link" href="#">Reply</a><c:if test="${themeDisplay.user.userId == childCommentBo.userId}"><span> - </span><a href="#" data-comment-dom-id="delete-link"><liferay-ui:message key="label.delete" /></a></c:if>
											    		</c:if>
										    		</div>
												</div>
											</div>
										</div>
									</li>
				    			</c:forEach>
							</ul>
							<div class="sp-gd-children-more" data-loadmore-dom-id="view-more-link-container" <c:if test="${parentCommentBo.childCount <= fn:length(parentCommentBo.childCommentBos)}">style="display: none;"</c:if> ><a data-loadmore-dom-id="view-more-link" data-loadmore="{ &quot;retrieve_url&quot; : &quot;<%=retrieveRepliesURL %>&quot; ,&quot;retrieve_params&quot; : { &quot;sp_group_id&quot; : &quot;<%= spGroup.getSpGroupId() %>&quot;, &quot;parent_id&quot; : &quot;${parentCommentBo.commentId}&quot;, &quot;offset&quot; : 3, &quot;cur_showing_no&quot; : ${fn:length(parentCommentBo.childCommentBos)}, &quot;init_total&quot; : ${parentCommentBo.childCount} }, &quot;no_results_msg&quot; : &quot;&quot;, &quot;no_more_results_msg&quot; : &quot;&quot;, &quot;error_msg&quot; : &quot;This stream is unavailable at this time. Please try again soon.&quot; }" href="#">View <span data-loadmore-dom-id="unshown-status">${parentCommentBo.childCount - fn:length(parentCommentBo.childCommentBos)}</span> more</a></div>
							<div align="center" data-loadmore-dom-id="loading-status" style="display: none;"><span><liferay-ui:message key="label.loading" /></span></div>
							<div align="center" data-loadmore-dom-id="load-msg" style="display: none;"></div>
							<c:if test="${themeDisplay.signedIn}">
								<div class="sp-gd-entry level22" data-comment-dom-id="add-reply-form-container" id="discCommentBox" style="display: none;">
									<div class="sp-gd-entry-inner">
										<div class="avatar-wrap"><img alt="User Image" src="<%= portraitUrl %>" class="avatar" /></div>
										<div style="margin: 0 0 15px 60px; min-height: 85px;">
											<form action="<%= addReplyURL %>" data-comment-dom-id="add-reply-form" method="post">
												<input name="<portlet:namespace />classPK" type="hidden" value="<%= spGroup.getSpGroupId() %>" />
												<input name="<portlet:namespace />className" type="hidden" value="<%= SPGroup.class.getName() %>" />
												<input name="<portlet:namespace />urlTitle" type="hidden" value="<%= spGroup.getUrlTitle() %>" />
												<div class="sp-gd-textarea-outer">
													<textarea data-comment-dom-id="add-reply-textarea" tabindex="-1"></textarea>
												</div>
												<div align="right" class="sp-group-mts">
													<c:choose>
														<c:when test="${!commentServiceHasAccess}">
															<input class="sp-gd-btn small sp-group-comment-service-access-check btn-primary" name="<portlet:namespace />${commentServiceUserStatus}&upload=false" title='<%= LanguageUtil.get(pageContext,"label.permission.denied") %>' type="button" value='<%= LanguageUtil.get(pageContext,"label.reply") %>' />
														</c:when>
														<c:otherwise>
															<input class="sp-gd-btn small btn-primary" data-comment-dom-id="add-reply-form-sumbit-btn" type="submit" value='<%= LanguageUtil.get(pageContext,"label.reply") %>' />
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
		</ul>
	</div>
</div>
