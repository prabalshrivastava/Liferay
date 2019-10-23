<%@page import="com.liferay.compat.portal.kernel.util.StringUtil"%>
<%@page import="com.sambaash.platform.model.SPGroupType"%>
<div class="sp-group-clearfix">
	<div class="sp-group-lfloat sp-group-mrm" style="line-height: 1;"><img alt="Group Image" src="/image/image_gallery?img_id=<%= spGroup.getImageId() %>&t=<%= now.getTime() %>" style="width: 100px; height: 100px;" /></div>
	<div class="sp-group-ui-oh">
		<div class="sp-group-ui-dib">
			<div class="sp-group-ui-dib sp-group-ui-vatp" style="min-height:85px;"></div><div class="sp-group-ui-dib sp-group-ui-vam">
				<h3><%= spGroup.getTitle() %></h3>
				<%
				String grpDesc = StringUtil.shorten(spGroup.getDescription(), 100);
				grpDesc = grpDesc.replaceAll("[\r\n]", "<br>");
				%>
				<p><%= grpDesc %> <c:if test="<%= spGroup.getDescription().length() > 100 %>"><a href="<%= viewAboutTabURL %>"><liferay-ui:message key="label.more" /></a></c:if></p>
			</div><div class="sp-group-ui-vam">
					<c:if test="<%= themeDisplay.isSignedIn() %>">
						<c:choose>
							<c:when test="${isOwner}">
								<span class="sp-group-fcl">( <liferay-ui:message key="label.owner.of.group" /> )</span> &gt; <a href="<%= quitSPGroupURL %>"><liferay-ui:message key="label.quit" /></a><c:if test="${!isCommunityAdmin}"> &gt; <a href="<%= editSPGroupURL %>"><liferay-ui:message key="label.edit" /></a></c:if>
							</c:when>
							<c:when test="${isAdmin}">
								<span class="sp-group-fcl">( <liferay-ui:message key="label.admin.of.group" /> )</span> &gt; <a href="<%= quitSPGroupURL %>"><liferay-ui:message key="label.quit" /></a>
							</c:when>
							<c:when test="${isMember}">
								<span class="sp-group-fcl">( <liferay-ui:message key="label.member.of.group" /> )</span> &gt; <a href="<%= quitSPGroupURL %>"><liferay-ui:message key="label.quit" /></a>
							</c:when>
							<c:when test="${isWaitingForApproval}">
								<span class="sp-group-fcl">( <liferay-ui:message key="label.notify.from.admin" /> )</span> &gt; <a href="<%= cancelJoinSPGroupRequestURL %>"><liferay-ui:message key="label.cancel.join.request" /></a>
							</c:when>
							<c:when test="${isInvited}">
								<span class="sp-group-fcl">( <liferay-ui:message key="label.invite.to.join" /> )</span> &gt; <a href="<%= acceptJoinSPGroupRequestURL %>"><liferay-ui:message key="label.accept.invitation" /></a>
							</c:when>
							<c:when test="<%= spGroup.getType() == SPGroupType.PUBLIC.getValue() || spGroup.getType() == SPGroupType.MEMBERS_ONLY.getValue() %>">
								&gt; <a href="<%= joinSPGroupURL %>"><liferay-ui:message key="label.join.group" /></a>
							</c:when>
							<c:otherwise>

							</c:otherwise>
						</c:choose>
						<c:if test="${isCommunityAdmin}">
							&nbsp;&gt; <a href="<%= editSPGroupURL %>"><liferay-ui:message key="label.edit" /></a>&nbsp;&gt; <a href="<%= closeSPGroupURL %>">Close</a>
						</c:if>
					</c:if>
			</div>
		</div>
	</div>
</div>
