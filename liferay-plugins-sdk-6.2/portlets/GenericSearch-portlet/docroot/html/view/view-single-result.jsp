<%@page
	import="com.sambaash.platform.genericsearch.helper.GenericSearchHelper"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page
	import="com.sambaash.platform.genericsearch.GenericSearchConstants"%>
<%@page
	import="com.sambaash.platform.genericsearch.action.GenericSearchAction"%>
<%@page import="java.util.ArrayList"%>
<%@page
	import="com.liferay.portlet.portletdisplaytemplate.util.PortletDisplayTemplateUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />

<div class="generic-search-single-result">
	<%=PortletDisplayTemplateUtil.renderDDMTemplate(
						pageContext,
						(Long) renderRequest
								.getAttribute(GenericSearchConstants.ATTRIB_RESULT_TEMPLATE_ID),
						(List) renderRequest
								.getAttribute(GenericSearchConstants.ATTRIB_RESULT_LIST),
						(HashMap) renderRequest
								.getAttribute(GenericSearchConstants.ATTRIB_RESULT_MAP))%>
</div>