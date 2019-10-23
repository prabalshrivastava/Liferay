<%@ include file="init.jsp" %>
<%@ page import="sambaash.platform.srv.servicecomponent.model.ServiceComponents" %>
<%@ page import="sambaash.platform.srv.servicecomponent.service.ServiceComponentsLocalServiceUtil" %>

<%
	actionURL.setParameter("struts_action", "/spsc/servicecomponents_action");
	actionURL.setParameter("CMD", "process");

	renderURL.setParameter("struts_action", "/spsc/servicecomponents_action");
	String scgId = request.getParameter("scgId");

	String sgName = "";
	int sgcount = ServiceComponentsLocalServiceUtil.getServiceComponentsesCount();
	List<ServiceComponents> sgitems = ServiceComponentsLocalServiceUtil.getServiceComponentses(0, sgcount);
	Iterator<ServiceComponents> sgitr = sgitems.iterator();
	 while (sgitr.hasNext()) {
		 ServiceComponents sg = sgitr.next();
		 sgName = sgName + sg.getName() + ",";
	 }
%>

<portlet:actionURL name="componentAction" var="actionURLs">
	<portlet:param name="CMD" value="process" />
</portlet:actionURL>

<portlet:actionURL name="componentAction" var="cancelUrls" />

<script type="text/javascript">
	var currentVisibleDetailBlock = null;
		jQuery(document).ready(function() {
			 jQuery("#fm").validate();
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

		function uniqueName(sgName) {
		    var currentName = document.getElementById("serviceCName").value;
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

<form action="<%= actionURLs %>" id="fm" method="POST" name="<portlet:namespace/>fm">
<input class="required" maxlength="75"  name="<portlet:namespace/>scgId" type="hidden" value="<%= scgId %>" />
		<div id="scgtable"> Service Component</div>

		<div>
	<table class="taglib-search-iterator" width="90%">
		<tr class="portlet-section-body results-row">
			<td width="30%">
			<label for="name_label_1"><b>Name</b><font color="red">*</font></label></td>
			<td><input name="<portlet:namespace/>name" type="text" id = "serviceCName"  maxlength="75" class="required" onblur="if (!uniqueName('<%= sgName %>')){this.value='';}" /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="description_label_1"><b>Description</b></label></td>
			<td><textarea cols="18" maxlength="200" name="<portlet:namespace/>description"  rows="5"></textarea></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>
			<label for="extra1_label_1"><b>Portlet ID</b><font color="red">*</font></label></td>
			<td><input class="required" maxlength="75"  name="<portlet:namespace/>extra1" type="text" /></td>
		</tr>

		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="technology_component_label_1"><b>Technology Component</b><font color="red">*</font></label></td>
			<td><input class="required" maxlength="75"  name="<portlet:namespace/>technologyComponent" type="text" /></td>
		</tr>

			<tr class="portlet-section-body results-row">
			<td>
			<label for="extra2_label_1"><b>Additional Param</b></label></td>
			<td><input maxlength="75" name="<portlet:namespace/>extra2"  type="text" /></td>
		</tr>

		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="phase_label_1"><b>Phase</b><font color="red">*</font></label></td>
			<td>
			<select class="required" name="<portlet:namespace/>phase">
			<option></option>
			<option value="Planned">Planned</option>
			<option value="Development">Development</option>
			<option value="Production">Production</option>
			<option value="Maintenance">Maintenance</option>
			<option value="Decommissioned">Decommissioned</option>
			</select>
			</td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>
			<label for="status_label_1"><b>Status</b><font color="red">*</font></label></td>
			<td>
			<select class="required" name="<portlet:namespace/>status">
			<option></option>
			<option value="Enable">Enable</option>
			<option value="Disable">Disable</option>
			</select>
			</td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="version_label_1"><b>Version</b><font color="red">*</font></label></td>
			<td><input class="required" maxlength="75"  name="<portlet:namespace/>version" type="text" /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>
			<label for="service_type_label_1"><b>Service Type</b><font color="red">*</font></label></td>
			<td>
			<select class="required" name="<portlet:namespace/>serviceType">
			<option></option>
			<option value="Online">Online</option>
			<option value="Offline">Offline</option>
			</select>
			</td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="service_exposure_type_label_1"><b>Service Exposure Type</b><font color="red">*</font></label></td>
			<td>
			<select class="required" name="<portlet:namespace/>ServiceExposureType">
			<option></option>
			<option value="External">External</option>
			<option value="Internal">Internal</option>
			</select>
			</td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>
			<label for="user_type_label_1"><b>User Type</b><font color="red">*</font></label></td>
			<td>
			<select class="required" name="<portlet:namespace/>userType">
			<option></option>
			<option value="Individual">Individual</option>
			<option value="Company">Company</option>
			<option value="Partner">Partner</option>
			<option value="All">All</option>
			</select>
			</td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="platform_type_label_1"><b>Platform Type</b><font color="red">*</font></label></td>
			<td>
			<select class="required" name="<portlet:namespace/>platformType">
			<option></option>
			<option value="PlatformCore">PlatformCore</option>
			<option value="BizCore">BizCore</option>
			<option value="BizCustom">BizCustom</option>
			</select>
			</td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>
			<label for="isla_carte_service_label_1"><b>Is Add Service?</b><font color="red">*</font></label></td>
			<td>
			<select class="required" name="<portlet:namespace/>islaCarteService">
			<option></option>
			<option onClick="<portlet:namespace />callLaCarteService();" value="true">Yes</option>
			<option onClick="<portlet:namespace />callLaCarteService();" value="false">No</option>
			</select>
			</td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="is_external_label_1"><b>Is Sub Service?</b><font color="red">*</font></label></td>
			<td><select class="required" name="<portlet:namespace/>isExternal">
			<option></option>
			<option onClick="<portlet:namespace />callExternal();" value="true">Yes</option>
			<option onClick="<portlet:namespace />callExternal();" value="false">No</option>
			</select>
			</td>
		</tr>
		</table></div>

		<br><div><span class="linkDetail"><a href="javascript:;" class="membership_font_size"><b><img src="/Spsc-portlet/html/image/rightarrow.png" />&nbsp;Details</b></a></span>

		<div class="pplDetail" style="display:none">
		<table class="taglib-search-iterator" width="90%">
		<tr class="portlet-section-body results-row">
			<td width="30%">
			<label for="channe_i_d_label_1"><b>Tag</b></label></td>
			<td><input maxlength="200" name="<portlet:namespace/>tag"  type="text"  /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="channe_i_d_label_1"><b>Usage Statistics</b></label></td>
			<td><input maxlength="75" name="<portlet:namespace/>usageStatistics"  type="text"  /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>
			<label for="channel_i_d_label_1"><b>Channel I D</b></label></td>
			<td><input maxlength="75" name="<portlet:namespace/>channelID"  type="text"  /></td>
		</tr>
		</table></div></div>

		<br><div><span class="linkDetail"><a href="javascript:;" class="membership_font_size"><b><img src="/Spsc-portlet/html/image/rightarrow.png" />&nbsp;Deployment</b></a></span>

		<div class="pplDetail" style="display:none">
		<table class="taglib-search-iterator" width="90%">
		<tr class="portlet-section-body results-row alt">
			<td width="30%">
			<label for="webservice_u_r_l_label_1"><b>Webservice U R L</b></label></td>
			<td><input maxlength="75" name="<portlet:namespace/>webserviceURL"  type="text"  /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>
			<label for="deployment_cluster_label_1"><b>Deployment Cluster</b></label></td>
			<td><input maxlength="75" name="<portlet:namespace/>deploymentCluster"  type="text"  /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="deployment_location_label_1"><b>Deployment Location</b></label></td>
			<td><input maxlength="75" name="<portlet:namespace/>deploymentLocation"  type="text"  /></td>
		</tr>
		</table></div></div>

		<br><div><span class="linkDetail"><a href="javascript:;" class="membership_font_size"><b><img src="/Spsc-portlet/html/image/rightarrow.png" />&nbsp;Testing</b></a></span>

		<div class="pplDetail" style="display:none">
		<table class="taglib-search-iterator" width="90%">
		<tr class="portlet-section-body results-row alt">
			<td width="30%">
			<label for="test_plan_label_1"><b>Test Plan</b></label></td>
			<td><input maxlength="75" name="<portlet:namespace/>testPlan"  type="text"  /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>
			<label for="performance_profile_label_1"><b>Performance Profile</b></label></td>
			<td><input maxlength="75" name="<portlet:namespace/>performanceProfile"  type="text"  /></td>
		</tr>
		</table>
	</div></div>

	<br />

	<table width="90%">
		<tr><c:if test="<%= roleId1 %>">
			<td width="6%"><input type="submit" value="Save"></td></c:if>
			<td>&nbsp;<input onClick="location.href='<%= cancelUrls.toString() %>'" type="button" value="Cancel"></td>
		</tr>
	</table>
</form>