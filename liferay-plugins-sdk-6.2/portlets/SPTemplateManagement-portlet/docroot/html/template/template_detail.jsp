<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.sambaash.platform.srv.template.model.SPComponentTemplate"%> 
<%@page import="com.sambaash.platform.srv.template.model.SPTemplate"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@include file="/html/template/init.jsp"%>


<portlet:renderURL var="addTemplateURL">
	<portlet:param name="jspPage" value="/html/template/view.jsp" />
</portlet:renderURL>

<portlet:renderURL var="addTemplateDetailsURL">
	<portlet:param name="jspPage"
		value="/html/template/view_template_detail.jsp" />
</portlet:renderURL>


<%
    HashMap<Long,String> formList =  (HashMap) request.getAttribute("formList");
	SPTemplate template = null;
	List<SPComponentTemplate> componentTemplates = new ArrayList();

	template = (SPTemplate) request.getAttribute("template");
	componentTemplates = (List<SPComponentTemplate>) request.getAttribute("componentTemplates");
%>

<div class="container" style="width:89%">
<a class="view-template" href="<%=addTemplateURL.toString()%>">Add Template</a>
	<h2>Template Detail</h2>
	<div class="content">
		<div class="template-listing">
			<table class="aui">
				<tr>
					<th colspan="6"><%=template.getTemplateName()%></th>
				</tr>
				<tr>
					<td>Template Name</td>
					<td colspan="4"><%=template.getTemplateName()%></td>
				</tr>
				<tr>
					<td>Parent Template</td>
					<td><%=formList.get(componentTemplates.get(0).getLevel0FormId())%></td>
					<td><strong>System template Form ID</strong></td>
					<td><%=componentTemplates.get(0).getLevel0FormId()%></td>
					<td><a href="#view" class="">View Form</a><a href="#edit"
						class="">Edit Form</a></td>

				</tr>
				<%
					long formId;
					for (int i = 0; i < componentTemplates.size(); i++) {
				%>


				<%
					for (int j = 1; j < 11; j++) {
							formId = 0;
							if (j == 1)
								formId = componentTemplates.get(i).getLevel1FormId();
							else if (j == 2)
								formId = componentTemplates.get(i).getLevel2FormId();
							else if (j == 3)
								formId = componentTemplates.get(i).getLevel3FormId();
							else if (j == 4)
								formId = componentTemplates.get(i).getLevel4FormId();
							else if (j == 5)
								formId = componentTemplates.get(i).getLevel5FormId();
							else if (j == 6)
								formId = componentTemplates.get(i).getLevel6FormId();
							else if (j == 7)
								formId = componentTemplates.get(i).getLevel7FormId();
							else if (j == 8)
								formId = componentTemplates.get(i).getLevel8FormId();
							else if (j == 9)
								formId = componentTemplates.get(i).getLevel9FormId();
							else if (j == 10)
								formId = componentTemplates.get(i).getLevel10FormId();

							if (formId > 0) {
				%>
				<tr>
					<td>Level <%=j%></td>
					<td><%=formList.get(formId)%></td>
					<td><strong>System template Form ID</strong></td>
					<td><%=formId%></td>
					<td><a href="#view" class="">View Form</a><a href="#edit"
						class="">Edit Form</a></td>
				</tr>


				<%
					}
				%>
				<%
					}
				%>
				<%
					}
				%>

			</table>
		</div>
	</div>


</div>