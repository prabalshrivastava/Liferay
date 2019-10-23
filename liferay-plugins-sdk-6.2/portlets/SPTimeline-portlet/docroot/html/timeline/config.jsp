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
	long SpecialRequestProcessId = GetterUtil.getLong(portletPreferences.getValue("SpecialRequestProcessId", "0"));
	long EnquiryProcessId = GetterUtil.getLong(portletPreferences.getValue("EnquiryProcessId", "0"));
	long FeedbackProcessId = GetterUtil.getLong(portletPreferences.getValue("FeedbackProcessId", "0"));
	
	long RoleSize = GetterUtil.getLong(portletPreferences.getValue("RoleSize", "0"));
	long[] RoleList = new long[(int) RoleSize];
	for (int i = 0; i < RoleList.length; i++) {
		RoleList[i] = GetterUtil.getLong(portletPreferences.getValue("RoleID_" + i, ""));
	}
%>

<aui:row cssClass="ps-pref-container newPortlets" style="margin-left:auto;margin-right:auto; max-width:640px">
	<aui:col span="12">
		<aui:form name="editPreferences" action="<%=savePreferencesActionURL%>">
		
		<% String OPTION = "<option value='%s' %s>%s</option>"; %>
			<aui:select name="SpecialRequestProcessId" label="Select Special Request" data-id="SpecialRequestProcessId">
			<%
			  	  List<PEProcess> processes = PEProcessLocalServiceUtil.getPEProcesses(-1, -1);
			      out.println(String.format(OPTION, StringPool.BLANK, StringPool.BLANK, StringPool.BLANK));
			  	  for (PEProcess process :processes) {
			  		 String selected = "";
		     		 if (SpecialRequestProcessId == process.getSpPEProcessId()) {
		     			 selected = "selected";
		     		 }
			  		out.println(String.format(OPTION, process.getSpPEProcessId(),selected,process.getName()));
			  	  }
			  %>
			</aui:select>
			<aui:select name="EnquiryProcessId" label="Select Enquiry" data-id="EnquiryProcessId">
			<%
			  	  List<PEProcess> processes = PEProcessLocalServiceUtil.getPEProcesses(-1, -1);
			      out.println(String.format(OPTION, StringPool.BLANK, StringPool.BLANK, StringPool.BLANK));
			  	  for (PEProcess process :processes) {
			  		 String selected = "";
		     		 if (EnquiryProcessId == process.getSpPEProcessId()) {
		     			 selected = "selected";
		     		 }
			  		out.println(String.format(OPTION, process.getSpPEProcessId(),selected,process.getName()));
			  	  }
			  %>
			</aui:select>
			<aui:select name="FeedbackProcessId" label="Select Feedback" data-id="FeedbackProcessId">
			<%
			  	  List<PEProcess> processes = PEProcessLocalServiceUtil.getPEProcesses(-1, -1);
			      out.println(String.format(OPTION, StringPool.BLANK, StringPool.BLANK, StringPool.BLANK));
			  	  for (PEProcess process :processes) {
			  		 String selected = "";
		     		 if (FeedbackProcessId == process.getSpPEProcessId()) {
		     			 selected = "selected";
		     		 }
			  		out.println(String.format(OPTION, process.getSpPEProcessId(),selected,process.getName()));
			  	  }
			  %>
			</aui:select>
			
			<aui:input label="Enter Model Name"  name="modelName" id="modelName" value='' />
		
		
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
				<aui:button name="saveButton" type="submit" value="label.save" />
				<aui:button type="cancel" onClick="<%=viewURL%>" />
			</aui:button-row>
		</aui:form>
	</aui:col>
</aui:row>