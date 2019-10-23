<%@page import="com.sambaash.platform.srv.template.model.SPTemplate"%> 
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.helper.TemplatePermissionHelper"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ include file="/html/template/init.jsp"%>

<%@page import="com.liferay.portal.security.permission.PermissionChecker"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW); 
		Object[] arrayobject=(Object[])row.getObject(); 
		SPTemplate template=(SPTemplate)arrayobject[0];
%>
	<portlet:actionURL name="deleteTemplate" var="deleteURL">
		<portlet:param name="templateId"
			value="<%=String.valueOf(template.getSpTemplateId())%>" />
	</portlet:actionURL>
	
	<portlet:actionURL name="editTemplate"  var="editTemplateURL" >
		<portlet:param name="templateId"	value="<%=String.valueOf(template.getSpTemplateId())%>" />
	</portlet:actionURL>
	
	<portlet:actionURL name="viewTemplateDetail"  var="viewTemplateURL" >
		<portlet:param name="templateId"	value="<%=String.valueOf(template.getSpTemplateId())%>" />
	</portlet:actionURL>

<% if(TemplatePermissionHelper.canViewTemplate( (PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
	<a image="view" message="View" href="<%=viewTemplateURL.toString()%>" >View</a>
<% } %>	
<% if(TemplatePermissionHelper.canEditTemplate( (PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
	<a image="edit" message="Edit" href="<%=editTemplateURL.toString()%>">Edit</a>
<% } %>	
<% if(TemplatePermissionHelper.canDeleteTemplate( (PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
	<a image="delete" onclick="deleteTemplate(<%=String.valueOf(template.getSpTemplateId())%>)" message="Delete" href="javascript:void(0);">Delete</a>
<% } %>
	 
	






