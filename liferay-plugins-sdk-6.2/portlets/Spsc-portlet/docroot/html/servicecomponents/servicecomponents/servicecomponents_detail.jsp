<%@ include file="init.jsp" %>

<%@ page import="sambaash.platform.srv.servicecomponent.model.ServiceComponents" %>
<%@ page import="sambaash.platform.srv.servicecomponent.service.ServiceComponentsLocalServiceUtil" %>

<%
String recId = (String) request.getParameter("recId");
	ServiceComponents record = ServiceComponentsLocalServiceUtil.getServiceComponents(Long.parseLong(recId));

	PortletURL renderURL2 = renderResponse.createRenderURL();
	renderURL2.setParameter("struts_action", "/spsc/servicecomponents_action");
%>

<portlet:actionURL name="componentAction" var="actionURLs">
	<portlet:param name="CMD" value="delete" />
	<portlet:param name="deleteItem" value="<%= recId %>" />
</portlet:actionURL>

<portlet:actionURL name="componentAction" var="editURLs">
	<portlet:param name="CMD" value="edit" />
	<portlet:param name="deleteItem" value="<%= recId %>" />
</portlet:actionURL>

<portlet:actionURL name="componentAction" var="cancelUrls" />

<script type="text/javascript">
	var currentVisibleDetailBlock = null;
		jQuery(document).ready(function() {
jQuery('.pplDetail').hide();
jQuery('span.linkDetail a').click(function() {
var blockDetail = jQuery(this).parent().siblings(".pplDetail");
var visible = blockDetail.css("display") == "block";
if (visible) { blockDetail.slideUp('slow'); currentVisibleDetailBlock = null; }
else {
if (currentVisibleDetailBlock != null) { currentVisibleDetailBlock.slideUp('slow', function() {
blockDetail.slideDown('slow');}) }
else { blockDetail.slideDown('slow'); }
currentVisibleDetailBlock = blockDetail; } });

});

</script>
<div style="clear:both;"></div>

<form action="<%= actionURL %>" method="post" name="<portlet:namespace/>fm">
	<div id="scgtable"> Service Component </div>
	<div>
	<table class="taglib-search-iterator" width="90%">
		<tr class="portlet-section-body results-row alt">
			<td width="30%">
			<label for="name_label_1"><b>Name</b></label></td>
			<td><div class="textalign"><%= record.getName() %></div></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>
			<label for="description_label_1"><b>Description</b></label></td>
			<td><div class="textalign"><%= record.getDescription() %></div></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="technology_component_label_1"><b>Technology Component</b></label></td>
			<td><div class="textalign"><%= record.getTechnologyComponent() %></div></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>
			<label for="phase_label_1"><b>Phase</b></label></td>
			<td><%= record.getPhase() %></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="status_label_1"><b>Status</b></label></td>
			<td><%= record.getStatus() %></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="version_label_1"><b>Version</b></label></td>
			<td><div class="textalign"><%= record.getVersion() %></div></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>
			<label for="service_type_label_1"><b>Service Type</b></label></td>
			<td><%= record.getServiceType() %></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>
			<label for="service_exposure_type_label_1"><b>Service Exposure Type</b></label></td>
			<td><%= record.getServiceExposureType() %></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="user_type_label_1"><b>User Type</b></label></td>
			<td><%= record.getUserType() %></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>
			<label for="platform_type_label_1"><b>Platform Type</b></label></td>
			<td><%= record.getPlatformType() %></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td><label for="isla_carte_service_label_1"><b>Is Add Service?</b></label></td>
			<td><%= record.getIslaCarteService() %></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td><label for="is_external_label_1"><b>Is Sub Service?</b></label></td>
			<td><%= record.getIsExternal() %></td>
		</tr>
		</table></div>

		<br><div><span class="linkDetail"><a href="javascript:;" class="membership_font_size"><b><img src="/Spsc-portlet/html/image/rightarrow.png" />&nbsp;Details</b></a></span>

		<div class="pplDetail" style="display:none">
		<table class="taglib-search-iterator" width="90%">
		<tr class="portlet-section-body results-row alt">
			<td width="30%">
			<label for="channe_i_d_label_1"><b>Tag</b></label></td>
			<td><div class="textalign"><%= record.getTag() %></div></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>
			<label for="channe_i_d_label_1"><b>Usage Statistics</b></label></td>
			<td><div class="textalign"><%= record.getUsageStatistics() %></div></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="channel_i_d_label_1"><b>Channel ID</b></label></td>
			<td><div class="textalign"><%= record.getChannelID() %></div></td>
		</tr>
		</table></div></div>

		<br><div><span class="linkDetail"><a href="javascript:;" class="membership_font_size"><b><img src="/Spsc-portlet/html/image/rightarrow.png" />&nbsp;Deployment</b></a></span>

		<div class="pplDetail" style="display:none">
		<table class="taglib-search-iterator" width="90%">
		<tr class="portlet-section-body results-row">
			<td width="30%">
			<label for="webservice_u_r_l_label_1"><b>Webservice URL</b></label></td>
			<td><div class="textalign"><%= record.getWebserviceURL() %></div></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="deployment_cluster_label_1"><b>Deployment Cluster</b></label></td>
			<td><div class="textalign"><%= record.getDeploymentCluster() %></div></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>
			<label for="deployment_location_label_1"><b>Deployment Location</b></label></td>
			<td><div class="textalign"><%= record.getDeploymentLocation() %></div></td>
		</tr>
		</table></div></div>

		<br><div><span class="linkDetail"><a href="javascript:;" class="membership_font_size"><b><img src="/Spsc-portlet/html/image/rightarrow.png" />&nbsp;Testing</b></a></span>

		<div class="pplDetail" style="display:none">
		<table class="taglib-search-iterator" width="90%">
		<tr class="portlet-section-body results-row">
			<td width="30%">
			<label for="test_plan_label_1"><b>Test Plan</b></label></td>
			<td><div class="textalign"><%= record.getTestPlan() %></div></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="performance_profile_label_1"><b>Performance Profile</b></label></td>
			<td><div class="textalign"><%= record.getPerformanceProfile() %></div></td>
		</tr>
		</table>
	</div></div>

	<br><div><span class="linkDetail"><a href="javascript:;" class="membership_font_size"><b><img src="/Spsc-portlet/html/image/rightarrow.png" />&nbsp;Audit</b></a></span>

	<div class="pplDetail" style="display:none">
		<table class="taglib-search-iterator" width="90%">
		<tr class="portlet-section-body results-row alt">
			<td width="30%">
			<label for="author_label_1"><b>Author</b></label></td>
			<td><%= record.getAuthor() %></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>
			<label for="date_added_label_1"><b>Date Added</b></label></td>
			<td><%= record.getDateAdded() %></td>
		</tr><tr class="portlet-section-body results-row alt">
			<td>
			<label for="date_modified_label_1"><b>Date Modified</b></label></td>
			<td><%= record.getDateModified() %></td>
		</tr>
		</table>
	</div></div>
	<br />

	<%

//PortletURL backURL = renderResponse.createRenderURL();
String backURL = ParamUtil.getString(request, "backURL");
	%>

	<table width="90%">
		<tr>
		<c:if test="<%= roleId1 %>">
		    <td width="6%"><input type="button" value="Edit" onClick="location.href='<%= editURLs.toString() %>'"></td>
		</c:if>
			<td><a href="javascript:history.go(-1)"><input type="button" value="Back"></a></td>
		</tr>
	</table>
</form>