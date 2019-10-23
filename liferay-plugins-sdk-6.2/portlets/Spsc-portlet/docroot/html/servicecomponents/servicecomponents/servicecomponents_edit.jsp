<%@ include file="init.jsp" %>
<script src="/html/js/rgbmultiselect-1.0" type="text/javascript"></script>
<%@ page import="sambaash.platform.srv.servicecomponent.model.ServiceComponents" %>
<%@ page import="sambaash.platform.srv.servicecomponent.service.ServiceComponentsLocalServiceUtil" %>

<%
	String recId = (String) request.getParameter("recId");

		String defaultValue = "Click to Update";
	ServiceComponents record = ServiceComponentsLocalServiceUtil.getServiceComponents(Long.parseLong(recId));

	actionURL.setParameter("struts_action", "/spsc/servicecomponents_action");
	actionURL.setParameter("CMD", "edit");

	actionURL.setParameter("recId", recId);

	renderURL.setParameter("struts_action", "/spsc/servicecomponents_action");
%>

<portlet:actionURL name="componentAction" var="actionURLs">
	<portlet:param name="CMD" value="edit" />
	<portlet:param name="recId" value="<%= recId %>" />
</portlet:actionURL>

<portlet:actionURL name="componentAction" var="cancelUrls" />

<script type="text/javascript">
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

/*jQuery('#cloneName').editable(function(value, settings) {
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
});*/

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
submit : 'Update',
cssclass: 'formEdit'
});

jQuery('#extra1').editable(function(value, settings) {
jQuery('[name=<portlet:namespace />extra1]').val(value);
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

jQuery('#technologyComponent').editable(function(value, settings) {
	jQuery('[name=<portlet:namespace />technologyComponent]').val(value);
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

jQuery('#extra2').editable(function(value, settings) {
jQuery('[name=<portlet:namespace />extra2]').val(value);
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
data : "{'Planned':'Planned','Development':'Development','Production':'Production','Maintenance':'Maintenance','Decomissioned':'Decomissioned','selected':'<%= (record != null) ? record.getPhase() : "" %>'}"
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

jQuery('#serviceType').editable(function(value, settings) {
	jQuery('[name=<portlet:namespace />serviceType]').val(value);
	return(value);
		},
{
type : 'select',
submit : 'Update',
cssclass: 'formEdit',
data : " {'Online':'Online','Offline':'Offline','selected':'<%= (record != null) ? record.getServiceType() : "" %>'}"
});

jQuery('#ServiceExposureType').editable(function(value, settings) {
	jQuery('[name=<portlet:namespace />ServiceExposureType]').val(value);
	return(value);
		},
{
type : 'select',
submit : 'Update',
cssclass: 'formEdit',
data : " {'External':'External','Internal':'Internal','selected':'<%= (record != null) ? record.getServiceExposureType() : "" %>'}"
});

jQuery('#userType').editable(function(value, settings) {
	jQuery('[name=<portlet:namespace />userType]').val(value);
	return(value);
		},
{
type : 'select',
submit : 'Update',
cssclass: 'formEdit',
data : " {'Individual':'Individual','Company':'Company','Partner':'Partner','All':'All','selected':'<%= (record != null) ? record.getUserType() : "" %>'}"
});

jQuery('#platformType').editable(function(value, settings) {
	jQuery('[name=<portlet:namespace />platformType]').val(value);
	return(value);
		},
{
type : 'select',
submit : 'Update',
cssclass: 'formEdit',
data : " {'PlatformCore':'PlatformCore','BizCore':'BizCore','BizCustom':'BizCustom','selected':'<%= (record != null) ? record.getPlatformType() : "" %>'}"
});

jQuery('#islaCarteService').editable(function(value, settings) {
	jQuery('[name=<portlet:namespace/>islaCarteService]').val(value);
	return( (value == "true") ? "Yes" : "No");
		},
{
type : 'select',
submit : 'Update',
cssclass: 'formEdit',
data : " {'true':'Yes','false':'No','selected':'<%= (record != null) ? record.getIslaCarteService() : "" %>'}"
});

jQuery('#isExternal').editable(function(value, settings) {
	jQuery('[name=<portlet:namespace/>isExternal]').val(value);
	return( (value == "true") ? "Yes" : "No");
		},
{
type : 'select',
submit : 'Update',
cssclass: 'formEdit',
data : " {'true':'Yes','false':'No','selected':'<%= (record != null) ? record.getIsExternal() : "" %>'}"
});

jQuery('#tag').editable(function(value, settings) {
	jQuery('[name=<portlet:namespace />tag]').val(value);
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

jQuery('#webserviceURL').editable(function(value, settings) {
	jQuery('[name=<portlet:namespace />webserviceURL]').val(value);
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

jQuery('#deploymentLocation').editable(function(value, settings) {
	jQuery('[name=<portlet:namespace />deploymentLocation]').val(value);
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

jQuery('#channelID').editable(function(value, settings) {
	jQuery('[name=<portlet:namespace />channelID]').val(value);
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

jQuery('#testPlan').editable(function(value, settings) {
	jQuery('[name=<portlet:namespace />testPlan]').val(value);
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

jQuery('#performanceProfile').editable(function(value, settings) {
	jQuery('[name=<portlet:namespace />performanceProfile]').val(value);
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

jQuery('#usageStatistics').editable(function(value, settings) {
	jQuery('[name=<portlet:namespace />usageStatistics]').val(value);
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

var currentVisibleDetailBlock = null;

});

function charLimit(value) {
if (value.length > 200) return false;
return true;
}

function charLimiter(value) {
if (value.length > 75) return false;
return true;
}
</script>

<div style="clear:both;"></div>

<form action="<%= actionURLs %>" id="fm" method="POST" name="<portlet:namespace/>fm">
	<div id="scgtable"> Service Component </div>

	<div>
	<table class="taglib-search-iterator" width="90%">
		<tr class="portlet-section-body results-row">
			<td width="30%">
			<label for="name_label_1"><b>Name</b><font color="red">*</font></label></td>
			<td><div class="textalign" id="name"><%= record.getName() %></div>
			<input maxlength="75" name="<portlet:namespace />name" type="hidden" value="<%= record.getName() %>" />
			</td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="description_label_1"><b>Description</b></label></td>
			<td><div class="textalign" id="description"><%= !record.getDescription().equals("") ? record.getDescription() : defaultValue %></div>
			<input cols="60" maxlength="200" name="<portlet:namespace />description" rows="4" type="hidden" value="<%= record.getDescription() %>" />
			</td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td width="30%">
			<label for="extra1_label_1"><b>Portlet ID</b><font color="red">*</font></label></td>
			<td><div class="textalign" id="extra1"><%= record.getExtra1() %></div>
			<input maxlength="75" name="<portlet:namespace />extra1" type="hidden" value="<%= record.getExtra1() %>" />
			</td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="technology_component_label_1"><b>Technology Component</b><font color="red">*</font></label></td>
			<td><div class="textalign" id="technologyComponent"><%= record.getTechnologyComponent() %></div>
			<input class="required" maxlength="75" name="<portlet:namespace />technologyComponent" type="hidden" value="<%= record.getTechnologyComponent() %>" />
			</td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td width="30%">
			<label for="extra2_label_1"><b>Additional Param</b></label></td>
			<td><div class="textalign" id="extra2"><%= record.getExtra2() %></div>
			<input maxlength="75" name="<portlet:namespace />extra2" type="hidden" value="<%= record.getExtra2() %>" />
			</td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="phase_label_1"><b>Phase</b><font color="red">*</font></label></td>
			<td>
			<div id="phase"><%= record.getPhase() %></div>
			<input name="<portlet:namespace />phase" type="hidden" value="<%= record.getPhase() %>" />
			</td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>
			<label for="status_label_1"><b>Status</b><font color="red">*</font></label></td>
			<td>
			<div id="status"><%= record.getStatus() %></div>
			<input name="<portlet:namespace />status" type="hidden" value="<%= record.getStatus() %>" />
			</td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="version_label_1"><b>Version</b><font color="red">*</font></label></td>
			<td>
			<div class="textalign" id="version"><%= record.getVersion() %></div>
			<input class="required" maxlength="75" name="<portlet:namespace />version" type="hidden" value="<%= record.getVersion() %>" />
			</td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td width="30%">
			<label for="service_type_label_1"><b>Service Type</b><font color="red">*</font></label></td>
			<td>
			<div id="serviceType"><%= record.getServiceType() %></div>
			<input name="<portlet:namespace />serviceType" type="hidden" value="<%= record.getServiceType() %>" />
			</td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="service_exposure_type_label_1"><b>Service Exposure Type</b><font color="red">*</font></label></td>
			<td>
			<div id="ServiceExposureType"><%= record.getServiceExposureType() %></div>
			<input name="<portlet:namespace />ServiceExposureType" type="hidden" value="<%= record.getServiceExposureType() %>" />
			</td>
		 </tr>
		 <tr class="portlet-section-body results-row">
			<td>
			<label for="user_type_label_1"><b>User Type</b><font color="red">*</font></label></td>
			<td>
			<div id="userType"><%= record.getUserType() %></div>
			<input name="<portlet:namespace />userType" type="hidden" value="<%= record.getUserType() %>" />
			</td>
		 </tr>
		 <tr class="portlet-section-body results-row alt">
			<td>
			<label for="platform_type_label_1"><b>Platform Type</b><font color="red">*</font></label></td>
			<td>
			<div id="platformType"><%= record.getPlatformType() %></div>
			<input name="<portlet:namespace />platformType" type="hidden" value="<%= record.getPlatformType() %>" />
			</td>
		  </tr>
		  <tr class="portlet-section-body results-row">
			<td width="30%">
			<label for="isla_carte_service_label_1"><b>Is Add Service?</b><font color="red">*</font></label></td>
			<td>
			<div id="islaCarteService"><%= (record.getIslaCarteService() ==true) ? "Yes" : "No" %></div>
			<input class="required" name="<portlet:namespace/>islaCarteService" onClick="<portlet:namespace />callLaCarteService();" type="hidden" value="<%= record.getIslaCarteService() %>" />
			</td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="is_external_label_1"><b>Is Sub Service?</b><font color="red">*</font></label></td>
			<td>
			<div id="isExternal"><%= (record.getIsExternal() ==true) ? "Yes" : "No" %></div>
			<input class="required" name="<portlet:namespace/>isExternal" onClick="<portlet:namespace />callExternal();" type="hidden" value="<%= record.getIsExternal() %>" />
			</td>
		</tr>

		</table></div>

		<br><div><span class="linkDetail"><a href="javascript:;" class="membership_font_size"><b><img src="/Spsc-portlet/html/image/rightarrow.png" />&nbsp;Details</b></a></span>

		<div class="pplDetail" style="display:none">
		<table class="taglib-search-iterator" width="90%">
		<tr class="portlet-section-body results-row">
			<td>
			<label for="tag_label_1"><b>Tag</b></label></td>
			<td>
			<div class="textalign" id="tag"><%= !record.getTag().equals("") ? record.getTag() : defaultValue %></div>
			<input maxlength="200" name="<portlet:namespace />tag" type="hidden" value="<%= record.getTag() %>" />
			</td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="usage_statistics_label_1"><b>Usage Statistics</b></label></td>
			<td><div class="textalign" id="usageStatistics"><%= !record.getUsageStatistics().equals("") ? record.getUsageStatistics() : defaultValue %></div>
			<input maxlength="75" name="<portlet:namespace />usageStatistics" type="hidden" value="<%= record.getUsageStatistics() %>" />
			</td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td width="30%">
			<label for="channel_i_d_label_1"><b>Channel ID</b></label></td>
			<td><div class="textalign" id="channelID"><%= !record.getChannelID().equals("") ? record.getChannelID() : defaultValue %></div>
			<input maxlength="75" name="<portlet:namespace />channelID" type="hidden" value="<%= record.getChannelID() %>" />
		</td>
		</tr>
		 </table></div></div>

		<br><div><span class="linkDetail"><a href="javascript:;" class="membership_font_size"><b><img src="/Spsc-portlet/html/image/rightarrow.png" />&nbsp;Deployment</b></a></span>

		<div class="pplDetail" style="display:none">
		<table class="taglib-search-iterator" width="90%">
		<tr class="portlet-section-body results-row ">
			<td width="30%">
			<label for="webservice_u_r_l_label_1"><b>Webservice URL</b></label></td>
			<td>
			<div class="textalign" id="webserviceURL"><%= !record.getWebserviceURL().equals("") ? record.getWebserviceURL() : defaultValue %></div>
			<input maxlength="75" name="<portlet:namespace />webserviceURL" type="hidden" value="<%= record.getWebserviceURL() %>" />
			</td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="deployment_cluster_label_1"><b>Deployment Cluster</b></label></td>
			<td><div class="textalign" id="deploymentCluster"><%= !record.getDeploymentCluster().equals("") ? record.getDeploymentCluster() : defaultValue %></div>
			<input maxlength="75" name="<portlet:namespace />deploymentCluster" type="hidden" value="<%= record.getDeploymentCluster() %>" />
			</td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>
			<label for="deployment_location_label_1"><b>Deployment Location</b></label></td>
			<td><div class="textalign" id="deploymentLocation"><%= !record.getDeploymentLocation().equals("") ? record.getDeploymentLocation() : defaultValue %></div>
			<input maxlength="75" name="<portlet:namespace />deploymentLocation" type="hidden" value="<%= record.getDeploymentLocation() %>" />
			</td>
		</tr>
		</table></div></div>

		<br><div><span class="linkDetail"><a href="javascript:;" class="membership_font_size"><b><img src="/Spsc-portlet/html/image/rightarrow.png" />&nbsp;Testing</b></a></span>

		<div class="pplDetail" style="display:none">
		<table class="taglib-search-iterator" width="90%">
		<tr class="portlet-section-body results-row">
			<td width="30%">
			<label for="test_plan_label_1"><b>Test Plan</b></label></td>
			<td><div class="textalign" id="testPlan"><%= !record.getTestPlan().equals("") ? record.getTestPlan() : defaultValue %></div>
			<input maxlength="75" name="<portlet:namespace />testPlan" type="hidden" value="<%= record.getTestPlan() %>" />
			</td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="performance_profile_label_1"><b>Performance Profile</b></label></td>
			<td><div class="textalign" id="performanceProfile"><%= !record.getPerformanceProfile().equals("") ? record.getPerformanceProfile() : defaultValue %></div>
			<input maxlength="75" name="<portlet:namespace />performanceProfile" type="hidden" value="<%= record.getPerformanceProfile() %>" />
			</td>
		</tr>
	</table>
	</div></div>

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

	<%
	String backURL = ParamUtil.getString(request, "backURL");
	%>

	<table width="90%">
		<tr><c:if test="<%= roleId1 %>">
			<td width="8%"><input type="submit" value="Update"></td></c:if>
			<td><a href="javascript:history.go(-1)"><input type="button" value="Cancel"></a></td>
		</tr>
	</table>
</form>