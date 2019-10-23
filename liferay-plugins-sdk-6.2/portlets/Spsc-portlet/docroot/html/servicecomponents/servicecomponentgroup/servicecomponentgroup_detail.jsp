<%@ include file="init.jsp" %>

<%@ page import="sambaash.platform.srv.servicecomponent.model.ServiceComponentGroup" %>
<%@ page import="sambaash.platform.srv.servicecomponent.model.ServiceComponents" %>
<%@ page import="sambaash.platform.srv.servicecomponent.service.ServiceComponentGroupLocalServiceUtil" %>
<%@ page import="sambaash.platform.srv.servicecomponent.service.ServiceComponentsLocalServiceUtil" %>

<%
	String recId = (String) request.getAttribute("recId");
	ServiceComponentGroup record = ServiceComponentGroupLocalServiceUtil.getServiceComponentGroup(Long.parseLong(recId));

	Log log = LogFactoryUtil.getLog("servicecomponentgroup_edit.jsp");
	int count = ServiceComponentsLocalServiceUtil.getServiceComponentsesCount();
	List<ServiceComponents> items = ServiceComponentsLocalServiceUtil.getServiceComponentses(0, count);

	String serviceComponents[] = null;
	   java.util.List serviceComponentList = null;
	   log.info("DB:"+record.getExtra1());
	   if (record.getExtra1() != null ) {
	   serviceComponents = record.getExtra1().split(",");
	   //List l = new List serviceComponents.
	   log.info("serviceComponents:"+serviceComponents);
	   serviceComponentList = Arrays.asList(serviceComponents);
	   log.info("serviceComponentList:"+serviceComponentList);

	   }
%>

<portlet:actionURL name="componentAction" var="actionURLs">
	<portlet:param name="CMD" value="delete" />
	<portlet:param name="deleteItem" value="<%= recId %>" />
</portlet:actionURL>

<portlet:actionURL name="componentAction" var="editUrl">
	<portlet:param name="CMD" value="edit" />
	<portlet:param name="recId" value="<%= recId %>" />
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

<form action="<%= actionURLs %>" method="post" name="<portlet:namespace/>fm">
	<div id="scgtable"> Service Groups </div>
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
			<label for="phase_label_1"><b>Phase</b></label></td>
			<td><%= record.getPhase() %></td>
		</tr>
		<tr class="portlet-section-body results-row">
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
			<label for="deployment_cluster_label_1"><b>Deployment Cluster</b></label></td>
			<td><div class="textalign"><%= record.getDeploymentCluster() %></div></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="community_label_1"><b>Community</b></label></td>
			<td><%= record.getCommunity() %></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td><label for="extra1_label_1"><b>Service Components</b></label></td>
			<td>
			<div class="divtext">

		   <%
			for (ServiceComponents item: items) {

				//log.info("ServiceComponents: matching"+item.getScId() +"<>"+serviceComponentList);
				if ( serviceComponentList.contains(String.valueOf(item.getScId())))

						{
					log.info("ServiceComponents: matching"+item.getScId() +"<>"+serviceComponentList);
			%>

			<div value="<%= item.getScId() %>"><%= item.getName() %></div>

			<%
			} } %>
			</div>

		   </td>

		</tr>
		</table>

		<br><div><span class="linkDetail"><a href="javascript:;" class="membership_font_size"><b><img src="/Spsc-portlet/html/image/rightarrow.png" />&nbsp;Audit</b></a></span>

	<div class="pplDetail" style="display:none">
		<table class="taglib-search-iterator" width="90%">
	<tr class="portlet-section-body results-row">
			<td width="30%">
			<label for="author_label_1"><b>Author</b></label></td>
			<td><%= record.getAuthor() %></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="date_added_label_1"><b>Date Added</b></label></td>
			<td><%= record.getDateAdded() %></td>
		</tr><tr class="portlet-section-body results-row">
			<td>
			<label for="date_modified_label_1"><b>Date Modified</b></label></td>
			<td><%= record.getDateModified() %></td>
		</tr>
		</table>
	</div></div>
	<br>

	<%
PortletURL backURL = renderResponse.createRenderURL();
	%>

	<table width="90%">
		<tr>
		<c:if test="<%= roleId1 %>">
		    <td width="6%"><input type="button" value="Edit" onClick="location.href='<%= editUrl.toString() %>'"></td>
		</c:if>
			<td><a href="javascript:history.go(-1)"><input type="button" value="Back"></a></td>
		</tr>
	</table>
</form>