<%@ include file="init.jsp" %>

<%@ page import="com.liferay.portlet.PortletURLImpl" %>
<%@ page import="com.liferay.portal.util.PortletKeys" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ page import="com.liferay.portal.NoSuchPasswordPolicyException;" %>

<%
	String firstName = request.getParameter("_58_firstName");
	String lastName = request.getParameter("_58_lastName");
	String emailAddress = request.getParameter("_58_emailAddress");
	String password = request.getParameter("_58_password1");
	String memberType = request.getParameter("memberType");
	String userType = request.getParameter("userType");
	String promotionCode = request.getParameter("_58_promotion_code");
	Object err = request.getAttribute("pwdError");
	String errorClass = err.getClass().getName();
	String corporateName=null;
	if (request.getAttribute("corporateName")!=null) {
		corporateName=(String)request.getAttribute("corporateName");
	}

	String str= SambaashUtil.getCommunityPath(groupId) + "/home?p_l_id=58&p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&saveLastPath=%2Flogin%2Fcreate_account&_58_struts_action=%2Flogin%2Fcreate_account";
	str +="&ERRORCLASS="+errorClass;

	if (corporateName!=null) {
		str=str+"&corporateName="+corporateName;
	}

	PortletURL portletURL = new PortletURLImpl(request, PortletKeys.LOGIN, Long.parseLong(PortletKeys.LOGIN), PortletRequest.RENDER_PHASE);

		portletURL.setWindowState(WindowState.MAXIMIZED);
		portletURL.setPortletMode(PortletMode.VIEW);

		portletURL.setParameter("saveLastPath", "/login/create_account");
		portletURL.setParameter("struts_action", "/login/create_account");
%>

<script>
window.location = "<%= str %>";
</script>