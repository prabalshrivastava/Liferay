<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceWrapper"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.sambaash.platform.srv.processbuilder.model.PEProcessState"%>
<%@page import="com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.sambaash.platform.srv.processbuilder.model.PEProcess"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:actionURL var="savePreferencesActionURL" name="savePreferences">
</portlet:actionURL>
<portlet:renderURL portletMode="view" var="viewURL" />

<%
	String processId = GetterUtil.getString(portletPreferences.getValue("processId", "0"));
	long layoutID = GetterUtil.getLong(portletPreferences.getValue("layout", "0"));
	String userType = GetterUtil.getString(portletPreferences.getValue("userType", ""));
	String modelName = GetterUtil.getString(portletPreferences.getValue("modelName", ""));
	String processStateUrl = GetterUtil.getString(portletPreferences.getValue("processStateUrl", ""));

	long RoleSize = GetterUtil.getLong(portletPreferences.getValue("RoleSize", "0"));
	long[] RoleList = new long[(int) RoleSize];
	for (int i = 0; i < RoleList.length; i++) {
		RoleList[i] = GetterUtil.getLong(portletPreferences.getValue("RoleID_" + i, ""));
	}
%>

<aui:row cssClass="ps-pref-container newPortlets"
	style="margin-left:auto;margin-right:auto; max-width:640px">
	<aui:col span="12">
		<aui:form name="editPreferences"
			action="<%=savePreferencesActionURL%>">


			<%
				String OPTION = "<option value='%s' %s>%s</option>";
			%>

			<aui:select name="processId" label="process"
				data-id="processId">

				<%
					List<PEProcess> processes = PEProcessLocalServiceUtil.getPEProcesses(-1, -1);
					out.println(String.format(OPTION, StringPool.BLANK, StringPool.BLANK, StringPool.BLANK));
					for (PEProcess process : processes) {
						String selected = "";
						if (processId.equalsIgnoreCase(String.valueOf(process.getSpPEProcessId()))) {
							selected = "selected";
						}
						out.println(
								String.format(OPTION, process.getSpPEProcessId(), selected, process.getName()));
					}
				%>

			</aui:select>
			<%
				boolean chkUser = false;
				if (userType.equalsIgnoreCase("User") || userType == "") {
					chkUser = true;
				}
			%>



			<aui:input id="user" label="user" name="userType"
				onclick='configUser();' type="radio" value="User"
				checked='<%=chkUser%>' />
			<aui:input id="internalUser" label="internal.user" name="userType"
				onclick='configUser();' type="radio" value="Internal User"
				checked='<%=!chkUser%>' />

			<div class="layout">
				<aui:select name="layout" label="layout" data-id="layout">

					<%
					
						List<Layout> llayouts = LayoutLocalServiceUtil.getLayouts(
												themeDisplay.getScopeGroupId(), 
												LayoutLocalServiceUtil.getLayout(themeDisplay.getPlid()).isPrivateLayout());
						out.println(String.format(OPTION, StringPool.BLANK, StringPool.BLANK, StringPool.BLANK));
						for (Layout llayout : llayouts) {
							String selected = "";
							if (layoutID == llayout.getLayoutId()) {
								selected = "selected";
							}
							out.println(String.format(OPTION, llayout.getLayoutId(), selected,
									llayout.getName() + " [ " + llayout.getFriendlyURL() + " ]"));
						}
					%>

				</aui:select>
			</div>


			<div class="roles">
				<aui:select class="roles" name="roles" label="roles" data-id="roles"
					multiple="true">

					<%
						List<Role> roles = RoleLocalServiceUtil.getRoles(-1, -1);
						out.println(String.format(OPTION, StringPool.BLANK, StringPool.BLANK, StringPool.BLANK));
						for (Role role : roles) {
							String selected = "";
							for (long rID : RoleList) {
								if (rID == role.getRoleId()) {
									selected = "selected";
								}
							}

							out.println(String.format(OPTION, role.getRoleId(), selected, role.getName()));
						}
					%>

				</aui:select>

			</div>

			<aui:button-row>
				<aui:input label="enter.model.name" name="modelName" id="modelName"
					value='<%=modelName%>' />
				<aui:input label="enter.process.state.url"
					name="processStateUrl" id="processStateUrl"
					value='<%=processStateUrl%>' />
			</aui:button-row>


			<aui:button-row>
				<aui:button name="saveButton" type="submit" value="label.save" />
				<aui:button type="cancel" onClick="<%=viewURL%>" />
			</aui:button-row>
		</aui:form>
	</aui:col>
</aui:row>


<script>


var namespace =  "<portlet:namespace/>";
var user =document.getElementById(namespace+"user");
var internalUser =document.getElementById(namespace+"internalUser");
var roles =document.getElementsByClassName("roles")[0];
var layout =document.getElementsByClassName("layout")[0];
var processStateUrl =document.getElementById(namespace+"processStateUrl");

function configUser(){
	if(user.checked){
		roles.style.display = "none";
		layout.style.display = "block";
	}else{
		roles.style.display = "block";
		layout.style.display = "none";
	}
}



AUI().use('event-base', function (A) {
	A.on('domready', function () {
		configUser();
		});    
	});


</script>