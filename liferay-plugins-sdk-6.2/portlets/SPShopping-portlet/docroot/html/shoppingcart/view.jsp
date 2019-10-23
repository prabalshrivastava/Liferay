<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="/tld/sp-shopping" prefix="shopping"%>

<portlet:defineObjects />

<liferay-portlet:renderURL var="prefURL" portletMode="edit" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
</liferay-portlet:renderURL>

<div class="max-width">
	<shopping:cart
		packageIds='<%=portletPreferences.getValue("selectedPackages", "")%>'
		updatable='<%=GetterUtil.getBoolean(portletPreferences.getValue("updatable", ""))%>'
		expandable='<%=GetterUtil.getBoolean(portletPreferences.getValue("expandable", ""))%>'
		orderPage='<%=portletPreferences.getValue("orderPage", "")%>'></shopping:cart>
</div>

<%
	if (portletPreferences.getMap().size() == 0) {
%>
<aui:script>
 AUI().use('aui-base','liferay-util-window','aui-io-plugin-deprecated',function(A){
	var popupWidth = window.innerWidth - (window.innerWidth * .2);
    var login_popup= Liferay.Util.Window.getWindow(
                {
                    dialog: {
                        centered: true,
                        constrain2view: true,
                          modal: true,
                        resizable: false,
                        width: popupWidth
                    }
                }).plug(A.Plugin.DialogIframe,
                     {
                     autoLoad: true,
                     iframeCssClass: 'dialog-iframe',
                     uri:'<%=prefURL.toString()%>'
                     }).render();
             		login_popup.show();
                     login_popup.titleNode.html("Preferences");
 });
 </aui:script>
 <%
 }
 %>