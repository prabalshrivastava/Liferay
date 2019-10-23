<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%@ page import="java.util.*" %>

<%@ page import="com.sambaash.platform.srv.spgroup.model.SPGroup" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<script src="<c:url value="/js/json2.js" />" type="text/javascript"></script>
<script src="<c:url value="/js/load_more.js" />" type="text/javascript"></script>
<script src="<c:url value="/js/discussions.js" />" type="text/javascript"></script>

<style type="text/css">

</style>

<%
String redirect = ParamUtil.getString(request, "redirect");
String currentURL = themeDisplay.getURLCurrent();

SPGroup spGroup = (SPGroup)request.getAttribute("SP_GROUP");

String groupDetailPageName = portletPreferences.getValue("groupDetailPageName", "group-detail");
%>

<%
String viewSPGroupDetailURL = PortalUtil.getPortalURL(renderRequest) + "/" + groupDetailPageName;
try {
	com.liferay.portal.model.Layout viewSPGroupDetailLayout = com.liferay.portal.service.LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false, "/" + groupDetailPageName);
	long viewSPGroupDetailPlid = viewSPGroupDetailLayout.getPlid();

	javax.portlet.PortletURL viewSPGroupDetailPortletURL = com.liferay.portlet.PortletURLFactoryUtil.create(renderRequest, "SPGroupDetail_WAR_SPGroupportlet", viewSPGroupDetailPlid, javax.portlet.PortletRequest.RENDER_PHASE);

	viewSPGroupDetailPortletURL.setWindowState(javax.portlet.WindowState.NORMAL);
	viewSPGroupDetailPortletURL.setPortletMode(javax.portlet.PortletMode.VIEW);
	viewSPGroupDetailPortletURL.setParameter("struts_action", "/groups/view_entry");
	if (spGroup != null) {
		viewSPGroupDetailPortletURL.setParameter("urlTitle", spGroup.getUrlTitle());
		viewSPGroupDetailPortletURL.setParameter("spGroupId", String.valueOf(spGroup.getSpGroupId()));
	}

	viewSPGroupDetailURL = viewSPGroupDetailPortletURL.toString();

}catch (com.liferay.portal.NoSuchLayoutException e) {
	// do nothing
}
%>

<div align="right" class="header-back">
	<a href="<%= viewSPGroupDetailURL %>">&laquo; Back</a>
</div>

<%
if (spGroup != null) {
%>

	<c:set value="${pageContext.request.contextPath}" var="ctx" />

	<portlet:resourceURL var="retrieveRepliesURL">
		<portlet:param name="action" value="retrieveReplies"></portlet:param>
	</portlet:resourceURL>

	<portlet:resourceURL var="addReplyURL">
		<portlet:param name="action" value="addReply"></portlet:param>
	</portlet:resourceURL>

	<portlet:resourceURL var="deleteCommentURL">
		<portlet:param name="action" value="deleteComment"></portlet:param>
	</portlet:resourceURL>

	<%@ include file="include/discussion.jsp" %>

	<script type="text/javascript">
	
		var namespace= '<portlet:namespace/>';

		window.onload = function() {

			var comment_container = getFirstElementsByAttribute(document, "div", "data-comment-dom-id", "comment-container");
			var commentBox = document.getElementById('discCommentBox');
			var view_more_link = getElementsByAttribute(document, "a", "data-loadmore-dom-id", "view-more-link");

			var load_more_obj = new LoadMore({
				'j_load_more_delegation' : comment_container,
				'j_view_more_link' : view_more_link
			});

			var comment_add_form = getElementsByAttribute(document, "form", "data-comment-dom-id", "add-comment-form");
			var comment_add_textarea = getElementsByAttribute(document, "textarea", "data-comment-dom-id", "add-comment-textarea");
			var comment_add_textarea_detail = getElementsByAttribute(document, "textarea", "data-comment-dom-id", "add-comment-textarea-detail");
			new CommentWithReply({
				'j_comment_container' : comment_container,
				'j_comment_add_form' : comment_add_form,
				'j_comment_add_textarea' : comment_add_textarea,
				'j_comment_add_textarea_detail' : comment_add_textarea_detail,
				'_delete_comment_url' : '<%= deleteCommentURL %>'
			});

			commentBox.style.display = "block";

		}

	</script>

	<aui:script>
		AUI().use('aui-base', function(A) {

			var documentBody = A.one('document.body')
			if (documentBody) {
				documentBody.delegate(
					'click',
					function(event) {
						var name = this.get('name');
						var title = this.get('title');
						_callPopup(name,title);
					},
					'.sp-group-comment-service-access-check'
				);
			}

			function _callPopup(name, title) {
				var popup = Liferay.Util.Window.getWindow(
{
dialog: {
						centered: true,
						destroyOnClose: true,
						title: title,
						modal: true,
						height: 219,
						width: 515
					}}
				).render();

				popup.plug(
					A.Plugin.IO, {
						uri: name
					}
				);
			}

		});
	</aui:script>

<%
}else {
%>

	<div class="portlet-msg-error"><liferay-ui:message key="label.no.entry" /></div>

<%
}
%>