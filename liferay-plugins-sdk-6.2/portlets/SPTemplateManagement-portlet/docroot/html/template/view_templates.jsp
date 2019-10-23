<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.sambaash.platform.srv.template.model.SPComponentTemplate"%>
<%@page import="com.sambaash.platform.srv.template.model.SPTemplate"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.helper.TemplatePermissionHelper"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@include file="/html/template/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<portlet:defineObjects />

<portlet:renderURL var="addTemplateURL">
	<portlet:param name="jspPage" value="/html/template/view.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="addTemplateDetailsURL">
	<portlet:param name="jspPage" value="/html/template/view_template_detail.jsp"/>
</portlet:renderURL>
<portlet:actionURL name="createTemplate"  var="createTemplateURL" >
	
</portlet:actionURL>
<portlet:resourceURL var="testAjaxResourceUrl" >
	<portlet:param name="action" value="deleteTemplate"/> 
</portlet:resourceURL>

 <% 
	 String currentURL = PortalUtil.getCurrentURL(request);
	 PortletURL portletURL = renderResponse.createRenderURL();
	 HashMap<Long,String> formList =  (HashMap) request.getAttribute("formList");
	 List<SPTemplate> templates = (List<SPTemplate>) request.getAttribute("templates");
	 Integer templatescount = (Integer)request.getAttribute("templatescount") ;
	 //SPTemplateLocalServiceUtil.getSPTemplatesCount();
	 SPTemplate template=null;
	 SPComponentTemplate componentTemplate = null;
	 SearchContainer<SPTemplate> employeeContainer= new SearchContainer<SPTemplate>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 4, portletURL, null, null);
	 String cur = Integer.toString(employeeContainer.getCur());
	 String delta = Integer.toString(employeeContainer.getDelta());
	 int totalSize = templatescount;	
%>

<div class="template-heading" style="margin-top:12px;">
	<h2><span>Component Template Listing</span></h2>
</div>
<div class="container" style="width:89%; margin-top: 0px; box-shadow: 0 0 30px 0 #e1e6eb;">

	<% if(TemplatePermissionHelper.canAddTemplate( (PortletRequest) request.getAttribute("javax.portlet.request"))){ %>
	<div class="template-link">
	<a href="<%=createTemplateURL.toString()%>" class='add-template'>Add Template</a>
	</div>
<% } %>	
	
	<div class="content new-content">
	<input type ="hidden" id="apiUrl" value = "${testAjaxResourceUrl}" > 
	<input type ="hidden" id="namespace" value = "<portlet:namespace/>" > 
		<div class="comp-listing template-listing">
			<liferay-ui:search-container delta="4">
				<liferay-ui:search-container-results
					results="<%= templates %>"
					total="<%= totalSize %>"
				/>
			
				<liferay-ui:search-container-row
					className="java.lang.Object"
					modelVar="search"
				>
				<% 	Object[] arrayobject=(Object[])search; 
					template=(SPTemplate)arrayobject[0];
					componentTemplate=(SPComponentTemplate)arrayobject[1];
					String parentComponent = "";
					if(componentTemplate != null){
						parentComponent = formList.get( componentTemplate.getLevel0FormId()); 
					}
				%>
				
				     <liferay-ui:search-container-column-text name="Name of Template" value='<%= template.getTemplateName() %>' />
					<liferay-ui:search-container-column-text name="Parent Component" value='<%= parentComponent %>' />
					<liferay-ui:search-container-column-jsp name="Actions" path="/html/template/action.jsp" align="right"  />
			
				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
			
			
		</div>
		
		
	</div>
	

</div>
<style>
</style>