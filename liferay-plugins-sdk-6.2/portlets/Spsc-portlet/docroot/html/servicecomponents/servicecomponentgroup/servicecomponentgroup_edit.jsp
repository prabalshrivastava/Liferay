<%@ include file="init.jsp" %>
<link href="<%= ctxPath %>/html/css/rgbmultiselect.css" rel="stylesheet" type="text/css" />
<script src="<%= ctxPath %>/html/js/rgbmultiselect-1.0.js" type="text/javascript"></script>

<%@ page import="sambaash.platform.srv.servicecomponent.model.ServiceComponentGroup" %>
<%@ page import="sambaash.platform.srv.servicecomponent.model.ServiceComponents" %>
<%@ page import="sambaash.platform.srv.servicecomponent.service.ServiceComponentGroupLocalServiceUtil" %>
<%@ page import="sambaash.platform.srv.servicecomponent.service.ServiceComponentsLocalServiceUtil" %>

<%

//String recId = (String) request.getAttribute("recId");
String recId = (String) request.getParameter("recId");
String cloned = (String)request.getAttribute("clone");

String sgName = "";
int sgcount = ServiceComponentGroupLocalServiceUtil.getServiceComponentGroupsCount();
List<ServiceComponentGroup> sgitems = ServiceComponentGroupLocalServiceUtil.getServiceComponentGroups(0,sgcount);
Iterator<ServiceComponentGroup> sgitr = sgitems.iterator();
while (sgitr.hasNext()) {
	 ServiceComponentGroup sg = sgitr.next();
	 sgName = sgName + sg.getName() + ",";
}
	String defaultValue = "Click to Update";
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

<portlet:actionURL name="componentGroupAction" var="actionURLs">
	<portlet:param name="CMD" value="edit" />
	<portlet:param name="recId" value="<%= recId %>" />
</portlet:actionURL>

<portlet:actionURL name="componentGroupAction" var="cancelUrls" />

<script type="text/javascript">



jQuery(document).ready(function() {
	var currentVisibleDetailBlock = null;
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

jQuery("#extra1").rgbmultiselect();

	 jQuery('#description').editable(function(value, settings) {
			jQuery('[name=<portlet:namespace />description]').val(value);
			return(value);
				},
		{
	 type : 'textarea',
	 height : '80px',
	 onsubmit: function(settings, td) {
		 var input = $(td).find('textarea');
		 var original = input.val();
		 if (charLimit(original)) {
			 return true;
		 } else {
			 jAlert("Please do not enter morethan 200 characters");
			 return false;
		 }
	 },
	 submit: 'Update',
	 fname : 'eform',
	 cssclass: 'formEdit'
		});

	 jQuery('#cloneName').editable(function(value, settings) {

			jQuery('[name=<portlet:namespace />name]').val(value);
			return(value);
				},
		{
	 type : 'textarea',
	 onsubmit: function(settings, td) {
		 var input = $(td).find('textarea');
		 var original = input.val();
		 if (charLimiter(original)) {
			 return true;
		 } else {
			 jAlert("Please do not enter morethan 75 characters");
			 return false;
		 }
	 },
	 submit : 'Update',
	 cssclass: 'formEdit'
		});

	 jQuery('#phase').editable(function(value, settings) {
			jQuery('[name=<portlet:namespace />phase]').val(value);
			return(value);
				},
		{
	 type : 'select',
	 submit : 'Update',
	 cssclass: 'formEdit',
	 data : " {'Planned':'Planned','Development':'Development','Production':'Production','Maintenance':'Maintenance','Decomissioned':'Decomissioned','selected':'<%= (record != null) ? record.getPhase() : "" %>'}"
		});

	 jQuery('#status').editable(function(value, settings) {
			jQuery('[name=<portlet:namespace />status]').val(value);
			return(value);
				},
		{
	 type : 'select',
	 submit : 'Update',
	 cssclass: 'formEdit',
	 data : " {'Enable':'Enable','Disable':'Disable','selected':'<%= (record != null) ? record.getStatus() : "" %>'}"
		});

	 jQuery('#version').editable(function(value, settings) {
			jQuery('[name=<portlet:namespace />version]').val(value);
			return(value);
				},
		{
	 type : 'textarea',
	 onsubmit: function(settings, td) {
		 var input = $(td).find('textarea');
		 var original = input.val();
		 if (charLimiter(original)) {
			 return true;
		 } else {
			 jAlert("Please do not enter morethan 75 characters");
			 return false;
		 }
	 },
	 submit : 'Update',
	 cssclass: 'formEdit'
		});

	 jQuery('#deploymentCluster').editable(function(value, settings) {
			jQuery('[name=<portlet:namespace />deploymentCluster]').val(value);
			return(value);
				},
		{
	 type : 'textarea',
	 onsubmit: function(settings, td) {
		 var input = $(td).find('textarea');
		 var original = input.val();
		 if (charLimiter(original)) {
			 return true;
		 } else {
			 jAlert("Please do not enter morethan 75 characters");
			 return false;
		 }
	 },
	 submit : 'Update',
	 cssclass: 'formEdit'
		});

	 jQuery('#community').editable(function(value, settings) {
			jQuery('[name=<portlet:namespace />community]').val(value);
			return(value);
				},
		{
	 type : 'select',
	 submit : 'Update',
	 cssclass: 'formEdit',
	 data : " {'Platform':'Platform','SixDegrees':'SixDegrees','InvestorClub':'InvestorClub', 'Community3': 'Community3', 'Community4': 'Community4', 'selected':'<%= (record != null) ? record.getCommunity() : "" %>'}"
		});

		var currentVisibleDetailBlock = null;

jQuery('.pplDetail').hide();
jQuery('span.linkDetail a').mouseover(function() {
var blockDetail = jQuery(this).parent().siblings(".pplDetail");
var visible = blockDetail.css("display") == "block";
if (visible) { blockDetail.slideUp('slow'); currentVisibleDetailBlock = null; }
else {
if (currentVisibleDetailBlock != null) { currentVisibleDetailBlock.slideUp('slow', function() {
blockDetail.slideDown('slow');}) }
else { blockDetail.slideDown('slow'); }
currentVisibleDetailBlock = blockDetail; } });
});

function charLimit(value) {
	 if (value.length > 200) return false;
		  return true;
	}

function charLimiter(value) {
	 if (value.length > 75) return false;
		  return true;
	}

function uniqueName(sgName) {

	var currentName = document.getElementById("serviceName").value;
	var sglist=new Array();
	sglist=sgName.split(",");
	for (var i=0;i<sglist.length-1;i++) {
	if (sglist[i].toLowerCase() == currentName.toLowerCase()) {
	jAlert(currentName + " already exists. Choose a different name.");
	return false;
	}
	}
	return true;
	}

</script>

<div style="clear:both;"></div>
<liferay-ui:success key="cloned" message="Cloned Successfully" />

<%if ((cloned != null) && (cloned.equals("clone"))){ %>
<form action="<%= actionURLs %>" id="fm" method="POST" name="<portlet:namespace/>fm" onSubmit="return uniqueName('<%=sgName%>')">
<% }else { %>
<form action="<%= actionURLs %>" id="fm" method="POST" name="<portlet:namespace/>fm">
<%} %>
	<div id="scgtable"> Service Groups </div>
	<table class="taglib-search-iterator" width="90%">
		<tr class="portlet-section-body results-row">
			<td width="30%">
			<label for="name_label_1"><b>Name</b><font color="red">*</font></label></td>
			<td>
			<%if ((cloned != null) && (cloned.equals("clone"))){ %>
			<div class="textalign" id="cloneName"><%= record.getName() %></div>
			<% }else { %>
			<div class="textalign" id="name"><%= record.getName() %></div>
			<%} %>
			<input id="serviceName" maxlength="75" name="<portlet:namespace />name" size="25" type="hidden" value="<%= record.getName() %>" />
			</td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="description_label_1"><b>Description</b></label></td>
			<td>
			<div class="textalign" id="description"><%= !record.getDescription().equals("") ? record.getDescription() : defaultValue %></div>
			<input maxlength="200" name="<portlet:namespace />description" size="25" type="hidden" value="<%= record.getDescription() %>" />
			</td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>
			<label for="phase_label_1"><b>Phase</b><font color="red">*</font></label></td>
			<td>
			<div id="phase"><%= record.getPhase() %></div>
			<input name="<portlet:namespace />phase" type="hidden" value="<%= record.getPhase() %>" />
			</td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="status_label_1"><b>Status</b><font color="red">*</font></label></td>
			<td>
			<div id="status"><%= record.getStatus() %></div>
			<input name="<portlet:namespace />status" type="hidden" value="<%= record.getStatus() %>" />
			</td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>
			<label for="version_label_1"><b>Version</b><font color="red">*</font></label></td>
			<td>
			<div class="textalign" id="version"><%= record.getVersion() %></div>
			<input class="required" maxlength="75" name="<portlet:namespace />version" type="hidden" value="<%= record.getVersion() %>" />
			</td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="deployment_cluster_label_1"><b>Deployment Cluster</b></label></td>
			<td>
			<div class="textalign" id="deploymentCluster"><%= !record.getDeploymentCluster().equals("") ? record.getDeploymentCluster() : defaultValue %></div>
			<input maxlength="75" name="<portlet:namespace/>deploymentCluster" type="hidden" value="<%= record.getDeploymentCluster() %>" />
			</td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>
			<label for="community_label_1"><b>Community</b></label></td>
			<td>
			<div id="community"><%= !record.getCommunity().equals("") ? record.getCommunity() : defaultValue %></div>
			<input name="<portlet:namespace />community" type="hidden" value="<%= record.getCommunity() %>" />
			</td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td><label for="extra1_label_1"><b>Service Components</b><font color="red">*</font></label></td>
			<td>
			<div class="divtext">
			<c:if test="<%= roleId1 %>">
		   <select multiple="yes" id="extra1" name="<portlet:namespace/>extra1" size="5" style="width:250px" class="required">

		   <%
			for (ServiceComponents item: items) {

				//log.info("ServiceComponents: matching"+item.getScId() +"<>"+serviceComponentList);
				if ( serviceComponentList.contains(String.valueOf(item.getScId())))

						{
					log.info("ServiceComponents: matching"+item.getScId() +"<>"+serviceComponentList);
			%>

			<option selected="selected" value="<%= item.getScId() %>"><%= item.getName() %></option>

			<% }
			else {
					log.info("ServiceComponents: NO matching"+item.getScId() +"<>"+serviceComponentList);
			%>

			<option value="<%= item.getScId() %>"><%= item.getName() %></option>

			<%
			} } %>

</select>
		   </c:if>
		   <c:if test="<%= !roleId1 %>">

		   <%
			for (ServiceComponents item: items) {

				//log.info("ServiceComponents: matching"+item.getScId() +"<>"+serviceComponentList);
				if ( serviceComponentList.contains(String.valueOf(item.getScId())))

						{
					log.info("ServiceComponents: matching"+item.getScId() +"<>"+serviceComponentList);
			%>

			<div id="servicegroups"><%= item.getName() %></div>

			<% } } %>
		   </c:if>
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

	<br />

<table width="90%">
<tr width="50%">
	<c:if test="<%= roleId1 %>">
		<td width="8%"><input type="submit" value="Update"></td>
	</c:if>

<%
String strutsPath = "/spsc/servicecomponentgroup_action";
actionURL.setParameter("struts_action", strutsPath);
actionURL.setParameter("CMD", "clone");
%>

<form action="<%= actionURL %>" method="post" name="<portlet:namespace/>fm">
<input name="<%= plns %>deleteItem" type="hidden" value="<%= recId %>" />
<c:if test="<%= roleId1 %>">
			<td width="8%"><input type="submit" value="Clone"></td></c:if>
			<td><a href="javascript:history.go(-1)"><input type="button" value="Cancel"></a></td>

		 </tr>

	</table>
</form>