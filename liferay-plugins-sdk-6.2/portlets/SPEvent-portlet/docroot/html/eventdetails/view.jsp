<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.sambaash.platform.portlet.spevent.SPEventConstants"%>
<%@page
	import="com.liferay.portlet.portletdisplaytemplate.util.PortletDisplayTemplateUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<portlet:defineObjects />
<%
	Long selectedTemplateId = GetterUtil.getLong(portletPreferences.getValue("displayStyle", null));
	Map map = (Map) renderRequest.getAttribute(SPEventConstants.ATTRIB_RESULT_MAP);
	if (Validator.isNotNull(selectedTemplateId)) {
		if (Validator.isNull(map)) {
			out.println("<div class='event-error text-center margin-top-one h3'>Event not found!</div>");
		} else {
%>
<div>
	<%=PortletDisplayTemplateUtil.renderDDMTemplate(pageContext, selectedTemplateId, new ArrayList(), map)%>
</div>
<%
		}
	} else {
		out.println("<div class='missing-config text-center margin-top-one h3'>Missing Configuration</div>");
	}
%>


<aui:script
	use="aui-node,aui-base,aui-io-request-deprecated,liferay-util-window,aui-io-plugin-deprecated">
	if (A.one('.missing-config')) {
		displayPopupMessage("Please use the 'configuration' menu-item to add configure the portlet");
	}
	function displayPopupMessage(msg, titleMsg) {
		titleMsg = titleMsg ? titleMsg : "Warning";
		var dialog = Liferay.Util.Window.getWindow({
			title : titleMsg,
			dialog : {
				bodyContent : msg,
				centered : true,
				cache : false,
				destroyOnClose : true,
				destroyOnHide : true,
				height : 250,
				width : 400,
				modal : true,
				constrain2view : true,
				toolbars : {
					footer : [ {
						label : 'Ok',
						on : {
							click : function() {
								dialog.hide();
							}
						}
					} ]
				}
			}
		}).render();
	}

		
	</aui:script>