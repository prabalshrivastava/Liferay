<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page
	import="com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.spservices.model.SPParameter"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<portlet:defineObjects />
<liferay-ui:error key="error.key1" message="URL not provided for Page Configurations"></liferay-ui:error>
<liferay-ui:error key="error.key2" message="URL not provided for Action Configurations"></liferay-ui:error>
<liferay-ui:error key="error.key3" message="Parameters Parameters in Action Configurations"></liferay-ui:error>

<%
Group liveGroup = (Group) request.getAttribute("site.liveGroup");
Long liveGroupId = (Long) request.getAttribute("site.liveGroupId");

List<Layout> layouts = LayoutLocalServiceUtil.getLayouts(liveGroupId, false);
JSONArray array = JSONFactoryUtil.createJSONArray();
for (Layout layout : layouts) {
	JSONObject obj = JSONFactoryUtil.createJSONObject();
	obj.put("pageName", layout.getFriendlyURL().substring(1));
	array.put(obj);
}
String pagesJSON = JSONFactoryUtil.looseSerialize(array);

%>

<style>
	.hide-content {
		display: none;
	}
	.width-90 {	
		width: 90% !important;
	}
</style>
<aui:form>
	<h3>Page URLs</h3>
	<label class="control-label">
		Specify page URLs for which the system will redirect, incase the user closes the browser and logs back in on a later point of time
	</label>
	<aui:row cssClass="text-right">
		<liferay-ui:icon image="add" url="javascript:addPage()" cssClass="text-right" message="Add new Page"/>
	</aui:row>
	<div class="pg-rows">
<%
	JSONArray arr = null;
	try {
		String loginRedirectPages = GetterUtil
				.getString(SambaashUtil.getParameter(
						SambaashConstants.SITE_SETTINGS.LOGIN_REDIRECT_PAGES,
						liveGroupId));
		arr = JSONFactoryUtil.createJSONArray(loginRedirectPages);
	} catch (Exception e) {
	}

	if (Validator.isNotNull(arr) && arr.length() > 0) {
		for (int i = 1; i <= arr.length(); i++) {
			JSONObject obj = arr.getJSONObject(i - 1);
			String url = obj.getString(SambaashConstants.SITE_SETTINGS.ATTR_PG_REDIRECT_ACTION_PAGE);
			boolean loginRequired = GetterUtil.getBoolean(obj.getString(SambaashConstants.SITE_SETTINGS.ATTR_PG_LOGIN_REQUIRED));
			boolean forgetAfterProcess = GetterUtil.getBoolean(obj.getString(SambaashConstants.SITE_SETTINGS.ATTR_PG_REDIRECT_FORGET));
			String cssClass = (i == 1)? "hide-content" : "";
			String paramInputName =  SambaashConstants.SITE_SETTINGS.ATTR_PG_REDIRECT_ACTION_PAGE + "-" + i;
			String paramInputName1 =  SambaashConstants.SITE_SETTINGS.ATTR_PG_LOGIN_REQUIRED + "-" + i;
			String paramInputName2 =  SambaashConstants.SITE_SETTINGS.ATTR_PG_REDIRECT_FORGET + "-" + i;
			String func = "javascript:removeRow('" + paramInputName + "')";
			%>
		<div class="page-row">
			<aui:row
				cssClass="<%=\"text-right login-redirect-pg-page-\" + i%>">
				<liferay-ui:icon image="delete" cssClass="<%=cssClass%>" url="<%= func%>" />
			</aui:row>
			<aui:row cssClass="sp-row">
				<aui:col width="50">
					<aui:input name="<%=paramInputName%>" placeholder="URL" label=""
						cssClass="width-90" value="<%=url%>" required="true" />
				</aui:col>
				<aui:col width="25">
					<aui:input name="<%=paramInputName1%>" type="checkbox" 
						label="Requires Login" checked="<%=loginRequired%>" value="<%=loginRequired%>"/>
				</aui:col>
				<aui:col width="25">
				<aui:input name="<%=paramInputName2%>" type="checkbox"
					checked="<%=forgetAfterProcess%>" label="Forget after processing?" value="<%=forgetAfterProcess%>"/>
				</aui:col>
			</aui:row>
		</div>
			<%
		}
	} else {
		String paramInputName = SambaashConstants.SITE_SETTINGS.ATTR_PG_REDIRECT_ACTION_PAGE + "-" + 1;
		String paramInputName1 = SambaashConstants.SITE_SETTINGS.ATTR_PG_LOGIN_REQUIRED + "-" + 1; 
		String paramInputName2 = SambaashConstants.SITE_SETTINGS.ATTR_PG_REDIRECT_FORGET + "-" + 1; 
		String func = "javascript:removeRow('" + paramInputName + "')";
	 %>
	<div class="page-row">
		<aui:row cssClass="text-right login-redirect-pg-page-1">
			<liferay-ui:icon image="delete" cssClass="hide-content"
				url="<%=func%>" />
		</aui:row>
		<aui:row cssClass="sp-row">
			<aui:col width="50">
				<aui:input name="<%=paramInputName%>" cssClass="width-90"
					placeholder="URL" label="" required="true" />
			</aui:col>
			<aui:col width="25">
				<aui:input name="<%=paramInputName1%>" type="checkbox"
					label="Requires Login" checked="false" value="true"/>
			</aui:col>
			<aui:col width="25">
				<aui:input name="<%=paramInputName2%>" type="checkbox"
					label="Forget after processing?" checked = "false" value="true"/>
			</aui:col>
		</aui:row>
	</div>
	<%
	}
%>
</div>
<br />
<h3>Actions</h3>

<label class="control-label"> Specify page URLs &amp; corresponding url parameters. Use the <liferay-ui:icon image="add" url="javascript:" message=""/> <liferay-ui:icon image="delete" url="javascript:" message=""/> icons to add/remove multiple entries</label>
<label class="control-label">Use Format <code>&lt;key1&gt;=&lt;value1&gt;&&lt;key2&gt;=&lt;value2&gt;</code> for parameters</label>

<br/> 
<aui:row cssClass="text-right">
<liferay-ui:icon image="add" url="javascript:addAction()" cssClass="text-right" message="Add new Action"/>
</aui:row>
<div class="action-rows">
	<%
	String loginRedirectActions = GetterUtil.getString(SambaashUtil.getParameter(SambaashConstants.SITE_SETTINGS.LOGIN_REDIRECT_ACTIONS, liveGroupId));
	try {
		arr = JSONFactoryUtil.createJSONArray(loginRedirectActions);
	} catch (Exception e) {
	}
	
	if (Validator.isNotNull(arr) && arr.length() > 0) {
		for (int i= 1; i <= arr.length(); i++) {
			JSONObject obj = arr.getJSONObject(i-1);
			String url = obj.getString(SambaashConstants.SITE_SETTINGS.ATTR_ACT_REDIRECT_ACTION_PAGE); 
			String params = obj.getString(SambaashConstants.SITE_SETTINGS.ATTR_ACT_REDIRECT_ACTION_PARAMS);
			boolean loginRequired = GetterUtil.getBoolean(obj.getString(SambaashConstants.SITE_SETTINGS.ATTR_ACT_LOGIN_REQUIRED));
			boolean forgetAfterProcess = GetterUtil.getBoolean(obj.getString(SambaashConstants.SITE_SETTINGS.ATTR_ACT_REDIRECT_FORGET));
			String cssClass = (i == 1)? "hide-content" : "";
			String paramInputName =  SambaashConstants.SITE_SETTINGS.ATTR_ACT_REDIRECT_ACTION_PAGE + "-" + i;
			String paramInputName1 =  SambaashConstants.SITE_SETTINGS.ATTR_ACT_REDIRECT_ACTION_PARAMS + "-" + i;
			String paramInputName2 =  SambaashConstants.SITE_SETTINGS.ATTR_ACT_LOGIN_REQUIRED + "-" + i;
			String paramInputName3 =  SambaashConstants.SITE_SETTINGS.ATTR_ACT_REDIRECT_FORGET + "-" + i;
			String func = "javascript:removeRow('" + paramInputName + "')";
			%>
	<div class="action-row">
		<aui:row
			cssClass="<%=\"text-right login-redirect-action-page-\" + i%>">
			<liferay-ui:icon image="delete" cssClass="<%=cssClass%>" url="<%= func%>" />
		</aui:row>
		<aui:row cssClass="sp-row">
			<aui:col width="25">
				<aui:input name="<%=paramInputName%>" placeholder="URL" label=""
					cssClass="width-90" value="<%=url%>" required="true"  />
			</aui:col>
			<aui:col width="25">
				<aui:input name="<%=paramInputName1%>" placeholder="Parameters"  label=""
					cssClass="width-90" value="<%=params%>" type="textarea" rows="4" required="true" />
			</aui:col>
			<aui:col width="25">
				<aui:input name="<%=paramInputName2%>" type="checkbox" 
					label="Requires Login" disabled="true" checked="<%=loginRequired%>" value="<%=loginRequired%>"/>
			</aui:col>
			<aui:col width="25">
			<aui:input name="<%=paramInputName3%>" type="checkbox"
				checked="<%=forgetAfterProcess%>" label="Forget after processing?" value="<%=forgetAfterProcess%>"/>
			</aui:col>
		</aui:row>
	</div>
			<%
			}	
	} else {
		String paramInputName =  SambaashConstants.SITE_SETTINGS.ATTR_ACT_REDIRECT_ACTION_PAGE + "-" + 1;
		String paramInputName1 =  SambaashConstants.SITE_SETTINGS.ATTR_ACT_REDIRECT_ACTION_PARAMS + "-" + 1;
		String paramInputName2 =  SambaashConstants.SITE_SETTINGS.ATTR_ACT_LOGIN_REQUIRED + "-" + 1;
		String paramInputName3 =  SambaashConstants.SITE_SETTINGS.ATTR_ACT_REDIRECT_FORGET + "-" + 1;
		String func = "javascript:removeRow('" + paramInputName + "')";
			%>
			<div class="action-row">
				<aui:row cssClass="text-right login-redirect-action-page-1">
					<liferay-ui:icon image="delete" cssClass="hide-content" url="<%= func%>"/>
				</aui:row>
				<aui:row cssClass="sp-row">
					<aui:col width="25">
						<aui:input name="<%=paramInputName%>" cssClass="width-90"
							placeholder="URL" label="" required="true" />
					</aui:col>
					<aui:col width="25">
						<aui:input name="<%=paramInputName1%>" cssClass="width-90"
							placeholder="Parameters" label=""  type="textarea" rows="4" required="true" />
					</aui:col>
					<aui:col width="25">
						<aui:input name="<%=paramInputName2%>" type="checkbox"
							label="Requires Login" disabled="true" checked="true" value="true"/>
					</aui:col>
					<aui:col width="25">
						<aui:input name="<%=paramInputName3%>" type="checkbox"
							label="Forget after processing?" checked="false" value="true"/>
					</aui:col>
				</aui:row>
			</div>
			<%
	}
	%>
	</div>
</aui:form>

<script>
var pagesJSON = '<%=pagesJSON%>';
function addPage()  {
	addNewSection('.page-row', 'pg');
}
function addAction()  {
	addNewSection('.action-row', 'action');
}
function addNewSection(rowInput, type)  {
	AUI().use('aui-node', 'aui-base', function(A) {
		var row = A.one(rowInput);
		var index = 1;
		while (true) {
			index = index + 1;
			if (A.one('#<portlet:namespace/>login-redirect-' + type + '-page-' + index) == null)
				break;
		}
		var newRow = row.getHTML();
		newRow = newRow.split('login-redirect-' + type + '-page-1').join('login-redirect-' + type + '-page-' + index);
		newRow = newRow.split('login-redirect-' + type + '-params-1').join('login-redirect-' + type + '-params-' + index);
		newRow = newRow.split('login-redirect-' + type + '-required-1').join('login-redirect-' + type + '-required-' + index);
		newRow = newRow.split('login-redirect-' + type + '-forget-after-process-1').join('login-redirect-' + type + '-forget-after-process-' + index);
		newRow = newRow.split('hide-content').join('');
		
		newRow = A.Node.create(newRow);
		newRow.all("input[type='text'],textarea").val('');
		newRow.appendTo(A.one('.' + type + '-rows'));
		enableAutoList( '#<portlet:namespace/>login-redirect-' + type + '-page-' + index);
	});
}
function removeRow(loc)  {
	AUI().use('aui-node', 'aui-base', function(A) {
		var row = A.one('#<portlet:namespace/>' + loc);
		row = row.ancestor('.sp-row');
		row.remove();
		row = A.one('.' + loc);
		row.remove();
	});
}
function enableAutoList(inputNode) {
	AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated',
			'autocomplete-list', 'aui-io-request', 'autocomplete-filters',
			'autocomplete-highlighters', function(A){
			try {
				new A.AutoCompleteList({
					allowBrowserAutocomplete : false,
					inputNode : inputNode,
					activateFirstItem : true,
					source : JSON.parse(pagesJSON),
					resultTextLocator : 'pageName',
					resultHighlighter : 'phraseMatch',
					resultFilters : 'phraseMatch',
					render : true,
				}).render();
				return true;
			} catch (err) {
				return false;
			}
	});
}
AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated',
			'autocomplete-list', 'aui-io-request', 'autocomplete-filters',
			'autocomplete-highlighters', function(A) {
	try {
		if (pagesJSON) {
			for (count = 1; count <= 100; count++) {
				var val = enableAutoList('#<portlet:namespace/>login-redirect-pg-page-'
						+ count);
				if (!val)
					break;
			}

			for (count = 1; count <= 100; count++) {
				var val = enableAutoList('#<portlet:namespace/>login-redirect-action-page-'
						+ count);
				if (!val)
					break;
			}
		}
	} catch (err) {
		console.log(err);
	}
	
});
</script>