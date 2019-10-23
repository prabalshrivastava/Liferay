<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page import="java.util.List" %>
<%@ page import="com.liferay.calendar.model.CalendarBooking" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.model.Theme" %>
<%@ page import="com.liferay.portal.service.ThemeLocalServiceUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portlet.asset.model.AssetCategory" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>

<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="javax.portlet.*" %>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="javax.portlet.PortletSession" %>
<%@ page import="com.liferay.portal.kernel.captcha.CaptchaUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.PropsKeys" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>

<%@ page import="com.liferay.calendar.service.CalendarBookingLocalServiceUtil" %>
<%@ page import="com.sambaash.platform.portlet.spevent.util.CalUtil" %>

<%@ page import="com.sambaash.platform.util.SambaashUtil" %>
<%@ page import="com.sambaash.platform.util.PermissionUtil" %>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %>
<%@ page import="com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil" %>
<%@ page import="com.liferay.portlet.expando.model.ExpandoBridge" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.liferay.counter.service.CounterLocalServiceUtil" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>

<portlet:defineObjects />
<%


String eventid =(String)renderRequest.getAttribute("eventid");
/* if (actionRequest.getAttribute("eventId") != null) {
	eventid = (String)actionRequest.getAttribute("eventId");
} */

HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
String flagDetail = httpReq.getParameter("flagDetail");//"58560";
if(Validator.isNotNull(flagDetail)){
%>

<c:set var="eventId" scope="request" value="${eventid}"/>


<liferay-portlet:runtime portletName="1_WAR_calendarportlet" queryString="&eventId=${eventId}" >
<jsp:forward page="/1_WAR_calendarportlet/sp_view_event.jsp/"></jsp:forward>
</liferay-portlet:runtime>
<%-- <%@ include file="/html/spevent/sp_view_event.jsp" %> --%>
	
<%
}else{
%>
<%@ include file="/html/spevent/view_events_landingPage.jsp" %>
<%
}
%>