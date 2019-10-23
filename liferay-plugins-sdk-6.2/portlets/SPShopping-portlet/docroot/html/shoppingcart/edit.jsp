<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="java.util.Set"%>
<%@page import="com.sambaash.platform.spshopping.SPShoppingConstants"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<portlet:defineObjects />

<portlet:renderURL var="renderURL" windowState="<%=WindowState.NORMAL.toString() %>" portletMode="<%=PortletMode.VIEW.toString() %>">
</portlet:renderURL>

<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
</portlet:resourceURL>

<%

String selectedPkgs = renderRequest.getPreferences().getValue("selectedPackages", "");
List<String> selectedList = Arrays.asList(selectedPkgs.split(","));
%>
<div class="container">
	<div class="h3 margin-top-one">Select packages to include</div>
	<div class="content margin-top-one" id="pref-form">
		<aui:form action="savePreferences" name="prefForm">
			
			<aui:input name="filter" label="" placeholder="Filter Pacakges"/>
			
			<div class="packageContainer">
			<%
				List<String> selectedPkgsList = Arrays.asList(GetterUtil.getString(portletPreferences.getValue("selectedPackages", "")).split(","));
				Map<String, String> dataMap = (Map<String, String>) renderRequest.getAttribute(SPShoppingConstants.ATTRIB_ALL_PACKAGE_MAP);
				Set<Map.Entry<String, String>> entrySet = dataMap.entrySet();
				for (Map.Entry<String, String> entry: entrySet) {
					%>
						<div class="package-row">
							<aui:input name="selectedPkg" type="checkbox"
								value="<%=entry.getKey()%>" label="<%=entry.getValue()%>"
								checked="<%=selectedPkgsList.contains(entry.getKey())%>"></aui:input>
						</div>
					<%
				}
				boolean updatable = GetterUtil.getBoolean(portletPreferences.getValue("updatable", "false"));
				boolean expandable =  GetterUtil.getBoolean(portletPreferences.getValue("expandable", "false"));
				String orderPage = portletPreferences.getValue("orderPage", "");
				
			%>
			</div>
			<aui:input name="updatable" type="checkbox" checked="<%=updatable %>" label="Enable Updates"></aui:input>
			<aui:input name="expandable" type="checkbox" checked="<%= expandable%>" label="Render Expand/Collapse"></aui:input>
			<aui:input name="orderPage" label="Results Page URL" value="<%=orderPage %>"></aui:input>
			<div class="portlet-msg-error animate" style="display:none" id="errorMsg">
			</div>
			<div class="portlet-msg-success animate" style="display:none" id="successMsg">
				<liferay-ui:message key="successfully-saved-preferences" />
			</div>
			
			<button  type="button" id="prefSubmitButton">Save</button>
			<aui:form></aui:form>
		</aui:form>
	</div>
</div>

<script type="text/javascript">
	var namespace = '<portlet:namespace/>';
	var resourceURL = '<%=resourceURL%>';
	var renderURL = '<%=renderURL%>';
	AUI().ready('aui-node', 'aui-base', 'aui-io-request-deprecated',function(A) {
		A.one('#prefSubmitButton').on('click', function(e){
			var obj = {};
			obj.action = "savePreferences";
			obj.updatable = A.one("#" + namespace + 'updatable').val();
			obj.expandable = A.one("#" + namespace + 'expandable').val();
			obj.orderPage = A.one("#" + namespace + 'orderPage').val();
			obj.selectedPackages = A.all('#' + namespace + 'prefForm #' + namespace + 'selectedPkgCheckbox:checked').val().toString();
			startPreLoader('pref-form');
			A.io.request(resourceURL, {
				dataType : 'json',
				method : 'POST',
				data : obj,
				on : {
					success : function() {
						stopPreLoader('pref-form');
						var success = true;
						try {
							if (this.get("responseData").status == 'success') {
								showSuccessMessage();
								// although we set the state to normal it still stays as pop_up
								// temp fix
								renderURL = renderURL.replace('pop_up', 'normal');
								
								Liferay.Util.getOpener().window.location.href=renderURL;
							} else {
								showFailedMessage(this.get("responseData").errorMsg);
							}
						} catch (e) {
							showFailedMessage(e);
						}
					},
					failure : function() {
						showFailedMessage('Error occured while saving information. Please contact development team');
						stopPreLoader('pref-form');
					}
				}
			});
		});
	});
</script>
