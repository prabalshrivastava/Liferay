
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.sambaash.platform.spdashboard.model.SPDashboardRow"%>
<%@page import="java.util.Collection"%>
<%@page import="com.sambaash.platform.spdashboard.SPDashboardConstants"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.sambaash.platform.spdashboard.helper.SPDashboardHelper"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>
	
<portlet:defineObjects />
<liferay-theme:defineObjects />

<style>
.dialog-iframe-root-node {
	width: 98% !important;
}
.cta-links {
	text-align: right;
	height: 16px;
}

input {
    background-color: white!important;
}

.portlet-configuration.sp-dashboard-search-portlet .archived-setups {
	margin-bottom: 0px;
	margin-right: 1.5em;
}

</style>

<%
	List<Role> userRoles = RoleLocalServiceUtil.getRoles(themeDisplay.getCompanyId());
    Map<String, String> apps = SPDashboardHelper.getDeployedApps();
    SPDashboardHelper helper = new SPDashboardHelper();
	Collection<SPDashboardRow> rows = helper.readConfig(renderRequest);
	String configJson = JSONFactoryUtil.looseSerialize(rows, "children", "roleIds");
%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationURL" />

<aui:form action="<%=configurationURL%>" method="post" name="fm"
	cssClass="margin-left-half margin-right-one">

	<div class="cta-links">
		<aui:button-row cssClass="inline-block">
			<aui:button type="submit" label="Save"></aui:button>
			<aui:button type="cancel" />
		</aui:button-row>
	</div>

	<aui:input name="<%=Constants.CMD%>" type="hidden"
		value="<%=Constants.UPDATE%>" cssClass="margin-bottom-half" />

	<div class="border-all bg-white padding-half margin-top-one" style="border-radius: 6px">
		<div>
			<h4>
				<liferay-ui:message key="configure-dashboard-tabs" /><aui:button style="float:right" class="add-btn" type="button" value="+" onclick="addNewRow();"/>
			</h4>
		</div>
		
		<div class="input-container border-all padding-half bg-custom-color-4 margin-top-half" style="border-radius: 6px">
			<div class="form-row row-line bg-white border-all margin-bottom-half padding-half" id="row-1">
				<div class="form-el inline-block">
					<aui:input class="input-small" style="height: 11px; width: 100px;" label="" name="preferences--label_row-1--" type="text" placeholder="label"></aui:input>
				</div>
				
				<div class="form-el inline-block">
					<aui:input class="input-small" style="height: 11px;" label="" name="preferences--url_row-1--" type="text" placeholder="url"></aui:input>
				</div>
				
				<div class="form-el inline-block">
					<aui:select label="" name="preferences--portlet_row-1--" cssClass="portlet-select">
						<aui:option disabled="true" label="Select Portlet" value=''></aui:option>
						<% for(Entry<String, String> entry : apps.entrySet()) { %>
							<aui:option value="<%=entry.getKey() %>" label="<%=entry.getValue() %>"/>
						<%}%>
					</aui:select>
				</div>
				
				<div class="form-el inline-block">
					<aui:select label="" name="preferences--role_row-1--" multiple="true">
						<aui:option value="" disabled="true">Select roles</aui:option>
						<% for (Role userRole : userRoles) { %>
							<aui:option label="<%=userRole.getName() %>" value="<%=userRole.getRoleId() %>"/>
						<% } %>
					</aui:select>
				</div>
				
				<div class="form-el inline-block">
					<aui:input placeholder="icon-url" label="" name="preferences--icon_row-1--" style="height:11px;"></aui:input>
				</div>
				
				<div class="form-el inline-block">
					<aui:input placeholder="position" label="" name="preferences--position_row-1--" style="height:11px; width:70px"></aui:input>
				</div>
				
				<div class="form-el inline-block" style="float: right">
					<aui:button id="btn-row-1" class="add-btn" value="+" type="button"  onclick="addNewChildRow(this);"></aui:button>
					<aui:button class="rem-btn" value="-" type="button"  onclick="removeRow(this);"></aui:button>
				</div>
				
				<div class="child-container border-all bg-custom-color-4 padding-half hide" style="border-radius: 6px">
					
				</div>
			</div>
		</div>
	</div>
</aui:form>


<div class="form-child-row row-line hide dummy-div" id="row-1" >
	<div class="form-el inline-block"><aui:input class="input-small" style="height: 11px;" label="" name="preferences--cfglabel_row-1--" placeholder="label"></aui:input></div>
	<div class="form-el inline-block"><aui:input class="input-small" style="height: 11px;" label="" name="preferences--cfgurl_row-1--" placeholder="url"></aui:input></div>
	<div class="form-el inline-block">
		<aui:select label="" name="preferences--cfgtype_row-1--" onChange="populateAnalyticsDropDown(this);" showEmptyOption="true">
			<aui:option value="<%=SPDashboardConstants.ANALYTICS_TYPE_CHART %>" label="label.chart"/>
			<aui:option value="<%=SPDashboardConstants.ANALYTICS_TYPE_NUMERIC %>" label="label.numeric"/>
		</aui:select>
	</div>
	<div class="form-el inline-block">
		<aui:select label="" cssClass="analytics-select" name="preferences--cfganalytics_row-1--" >
			<aui:option disabled="true" label="select-analytics"></aui:option>
		</aui:select>
	</div>
	
	<div class="form-el inline-block" style="float: right">
		<aui:button class="rem-btn" value="-" type="button"  onclick="removeRow(this);"></aui:button>
	</div>
</div>

<script>

var A = AUI().use('aui-node', 'aui-base','aui-io-request-deprecated','liferay-util-window','aui-io-plugin-deprecated');
var rows = 0;
var errorOption = 'NO CONFIG FOUND';
var configJsonString = '<%=configJson%>'; 

function addNewRow () {
	var container = A.one('.input-container');
	rows = A.all('.input-container .form-row').size();

	var newId = 'row-' + (rows + 1);
	var newRow = A.one('.input-container .form-row').clone();
	if (newRow.all('.child-container .form-child-row')) {
		newRow.all('.child-container .form-child-row').remove();
	} 

	var htmlRow = newRow.get('outerHTML');
	htmlRow = htmlRow.replace(/(row-)\d/g, newId);
	container.append(htmlRow);
	return newId;
}


function populateAnalyticsDropDown(objectId) {
	var obj = {};
	var node = A.one(objectId);
	obj['action']  = 'getAnalyticsOptions';
	console.log('test');
	obj.warId = node.ancestor('.form-row').one('.portlet-select').val();
	obj.type = node.val();
	var url = Liferay.PortletURL.createResourceURL();
	url.setResourceId('id');
	url.setPortletId('spdashboard_WAR_SPDashboardportlet');
	url.setParameter('sp_p_auth',  '<%= AuthTokenUtil.getToken(request) %>');
	A.io.request(url.toString(), {
		dataType : 'json',
		method : 'POST',
		sync: true,
		data : obj,
		on : {
			success : function(response) {
				var resp = this.get("responseData");
				var selectObj = node.ancestor('.form-child-row').one('.analytics-select');
				if(resp.options) {
					selectObj.html(resp.options)
				} else {
					alert('No analytics configured for this portlet. Please contact administrator!');
				}
			},
			failure: function () {
				alert('Error getting field options');
			}
		}
	});
}

function addNewChildRow (component) {
	var newChildRow;
	var newChildId;
	var htmlChildRow;
	var childContainer;
	var rows;

	if (A.one(component).ancestor('.form-row') != null) {
		var formRowId = A.one(component).ancestor('.form-row').get('id');
		childContainer = A.one('#' + formRowId + ' .child-container');
		rows = A.all('#' + formRowId + ' .child-container .form-child-row')
				.size();

		newChildId = formRowId + '_child-' + (rows + 1);

		newChildRow = A.one('.dummy-div').clone();
		newChildRow.removeClass('dummy-div');
		newChildRow.removeClass('hide');
		childContainer.removeClass('hide');
		htmlChildRow = newChildRow.get('outerHTML');
		htmlChildRow = htmlChildRow.replace(/(row-)\d/g, newChildId);
		childContainer.append(htmlChildRow);
		return newChildId;
	}
	return -1;
}

function removeRow(component) {
	var row = A.one(component).ancestor('.row-line');
	if (row != null) {
		if (A.all('.input-container .row-line').size() > 1)
			row.remove();
	}
}

A.ready(function () {
	setTimeout(function(){ 
		try {
			var configObj = A.JSON.parse(configJsonString);
			if (!configObj)
				return;
			for (i = 0 ; i< configObj.length; i++) {
				var curr = configObj[i];
				var rowId = 'row-1';
				if (i != 0) {
					var rowId = addNewRow();
				}
				var row = A.one('.input-container #' + rowId);
				row.one('#<portlet:namespace/>label_' + rowId).val(curr.label);
				row.one('#<portlet:namespace/>url_' + rowId).val(curr.url);
				row.one('#<portlet:namespace/>portlet_' + rowId).val(curr.portletWarName);
				row.one('#<portlet:namespace/>position_' + rowId).val(curr.position);
				row.one('#<portlet:namespace/>icon_' + rowId).val(curr.iconUrl);
				row.one('#<portlet:namespace/>role_' + rowId).val(curr.roleIds);
				if (curr.children && curr.children.length > 0) {
					for (j = 0 ; j< curr.children.length; j++) {
						var child = curr.children[j];
						var childRowId = addNewChildRow(row.one('div'));
						var childRow = row.one('#' + childRowId);
						var typeField = childRow.one('#<portlet:namespace/>cfgtype_' + childRowId);
						typeField.val(child.chartType);
						populateAnalyticsDropDown(typeField);
						childRow.one('#<portlet:namespace/>cfglabel_' + childRowId).val(child.label);
						childRow.one('#<portlet:namespace/>cfgurl_' + childRowId).val(child.url);
						childRow.one('#<portlet:namespace/>cfganalytics_' + childRowId).val(child.analyticsId);
					}
				}
			}
		} catch (err) {
			console.log(err);
		}
	}, 1000);
});

</script>