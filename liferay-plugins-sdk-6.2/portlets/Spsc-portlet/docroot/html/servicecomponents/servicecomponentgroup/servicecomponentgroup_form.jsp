<%@ include file="init.jsp" %>
<%@ page import="sambaash.platform.srv.servicecomponent.model.ServiceComponentGroup" %>
<%@ page import="sambaash.platform.srv.servicecomponent.model.ServiceComponents" %>
<%@ page import="sambaash.platform.srv.servicecomponent.service.ServiceComponentGroupLocalServiceUtil" %>
<%@ page import="sambaash.platform.srv.servicecomponent.service.ServiceComponentsLocalServiceUtil" %>

<%
	Log log = LogFactoryUtil.getLog("servicecomponentgroup_edit.jsp");
	String sgName = "";
	int sgcount = ServiceComponentGroupLocalServiceUtil.getServiceComponentGroupsCount();
	List<ServiceComponentGroup> sgitems = ServiceComponentGroupLocalServiceUtil.getServiceComponentGroups(0,sgcount);
	Iterator<ServiceComponentGroup> sgitr = sgitems.iterator();
	 while (sgitr.hasNext()) {
		 ServiceComponentGroup sg = sgitr.next();
		 sgName = sgName + sg.getName() + ",";
	 }
	int count = ServiceComponentsLocalServiceUtil.getServiceComponentsesCount();
	List<ServiceComponents> items = ServiceComponentsLocalServiceUtil.getServiceComponentses(0, count);

	String serviceComponents[] = null;
	   java.util.List serviceComponentList = null;
%>

<portlet:actionURL name="componentGroupAction" var="actionURLs">
	<portlet:param name="CMD" value="process" />
</portlet:actionURL>

<portlet:actionURL name="componentGroupAction" var="cancelUrls" />

<script type="text/javascript">
	    jQuery(document).ready(function() {
		      jQuery("#fm").validate();
	    });

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

<form action="<%= actionURLs %>" id="fm" method="POST" name="<portlet:namespace/>fm">
		<div id="scgtable"> Service Groups </div>
	<table class="taglib-search-iterator" width="90%">
		<tr class="portlet-section-body results-row">
			<td width="30%">
			<label for="name_label_1"><b>Name</b><font color="red">*</font></label></td>
			<td><input name="<portlet:namespace/>name" type="text"   id = "serviceName" maxlength="75" class="required" onblur="if (!uniqueName('<%= sgName %>')){this.value='';}" /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>
			<label for="description_label_1"><b>Description</b></label></td>
			<td><textarea cols="18" maxlength="200" name="<portlet:namespace/>description"  rows="5"></textarea></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td><label for="phase_label_1"><b>Phase</b><font color="red">*</font></label></td>
			<td>
			<select class="required" name="<portlet:namespace/>phase">
			<option></option>
			<option value="Planned">Planned</option>
			<option value="Development">Development</option>
			<option value="Production">Production</option>
			<option value="Maintance">Maintance</option>
			<option value="Decommissioned">Decommissioned</option>
			</select>
			</td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td><label for="status_label_1"><b>Status</b><font color="red">*</font></label></td>
			<td>
			<select class="required" name="<portlet:namespace/>status">
			<option></option>
			<option value="Enable">Enable</option>
			<option value="Disable">Disable</option>
			</select>
			</td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>
			<label for="version_label_1"><b>Version</b><font color="red">*</font></label></td>
			<td><input class="required" maxlength="75"  name="<portlet:namespace/>version" type="text" /></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td><label for="deployment_cluster_label_1"><b>Deployment Cluster</b></label></td>
			<td><input maxlength="75" name="<portlet:namespace/>deploymentCluster"  type="text"  /></td>
		</tr>
		<tr class="portlet-section-body results-row">
			<td><label for="community_label_1"><b>Community</b></label></td>
			<td>
			<select name="<portlet:namespace/>community">
			<option></option>
			<option value="Platform">Platform</option>
			<option value="SixDegrees">SixDegrees</option>
			<option value="InvestorClub">InvestorClub</option>
			<option value="Community3">Community3</option>
			<option value="Community4">Community4</option>
			</select>
			</td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td><label for="extra1_label_1"><b>Service Components</b><font color="red">*</font></label></td>
			<td><select class="required" multiple="yes" name="<portlet:namespace/>extra1" style="width:255px">

			<%
			for (ServiceComponents item: items) {
			%>

				   <option value="<%= item.getScId() %>"><%= item.getName() %></option>

			<%
			}
			%>

			</select></td>

		</tr>

	</table>

	<br />

	<table width="90%">
		<tr><c:if test="<%= roleId1 %>">
			<td width="6%"><input type="submit" value="Save"></td></c:if>
			<td>&nbsp;<input onClick="location.href='<%= cancelUrls.toString() %>'" type="button" value="Cancel"></td>
		</tr>
	</table>
</form>