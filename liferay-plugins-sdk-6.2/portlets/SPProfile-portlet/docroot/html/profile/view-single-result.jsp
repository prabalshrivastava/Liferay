
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page
	import="com.sambaash.platform.portlet.profile.ProfileConstants"%>
<%@page
	import="com.sambaash.platform.portlet.profile.action.ProfileAction"%>
<%@page import="java.util.ArrayList"%>
<%@page
	import="com.liferay.portlet.portletdisplaytemplate.util.PortletDisplayTemplateUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />

<div class="cm-profileView-single-result">
	<%=PortletDisplayTemplateUtil.renderDDMTemplate(
						pageContext,
						(Long) renderRequest
								.getAttribute(ProfileConstants.ATTRIB_RESULT_TEMPLATE_ID),
						(List) renderRequest
								.getAttribute(ProfileConstants.ATTRIB_RESULT_LIST),
						(HashMap) renderRequest
								.getAttribute(ProfileConstants.ATTRIB_RESULT_MAP))%>
</div>