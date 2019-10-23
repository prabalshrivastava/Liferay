<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@ taglib uri="http://java.sun.com/jstl/xml_rt" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jstl/sql_rt" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page import="com.liferay.portal.kernel.dao.orm.DynamicQuery" %><%@
page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil" %><%@
page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil" %><%@
page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil" %><%@
page import="com.liferay.portal.kernel.dao.search.ResultRow" %><%@
page import="com.liferay.portal.kernel.log.Log" %><%@
page import="com.liferay.portal.kernel.log.LogFactoryUtil" %><%@
page import="com.liferay.portal.kernel.servlet.SessionMessages" %><%@
page import="com.liferay.portal.kernel.util.ListUtil" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.PropsUtil" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %><%@
page import="com.liferay.portal.model.User" %><%@
page import="com.liferay.portal.security.auth.CompanyThreadLocal" %><%@
page import="com.liferay.portal.service.RoleServiceUtil" %><%@
page import="com.liferay.portal.service.UserLocalServiceUtil" %><%@
page import="com.liferay.portal.theme.ThemeDisplay" %><%@
page import="com.liferay.portal.util.PortalUtil" %><%@
page import="com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil" %>

<%@ page import="com.sambaash.platform.constant.SambaashConstants" %><%@
page import="com.sambaash.platform.srv.NoSuchSPParameterException" %><%@
page import="com.sambaash.platform.srv.model.SPParameter" %><%@
page import="com.sambaash.platform.srv.service.SPParameterLocalServiceUtil" %><%@
page import="com.sambaash.platform.util.SambaashUtil" %>

<%@ page import="java.text.SimpleDateFormat" %>

<%@ page import="java.util.ArrayList" %><%@
page import="java.util.Arrays" %><%@
page import="java.util.Calendar" %><%@
page import="java.util.Collection" %><%@
page import="java.util.Collections" %><%@
page import="java.util.Currency" %><%@
page import="java.util.Date" %><%@
page import="java.util.Enumeration" %><%@
page import="java.util.GregorianCalendar" %><%@
page import="java.util.HashMap" %><%@
page import="java.util.HashSet" %><%@
page import="java.util.Iterator" %><%@
page import="java.util.LinkedHashMap" %><%@
page import="java.util.LinkedHashSet" %><%@
page import="java.util.List" %><%@
page import="java.util.Locale" %><%@
page import="java.util.Map" %><%@
page import="java.util.Properties" %><%@
page import="java.util.ResourceBundle" %><%@
page import="java.util.Set" %><%@
page import="java.util.Stack" %><%@
page import="java.util.TimeZone" %><%@
page import="java.util.TreeMap" %><%@
page import="java.util.TreeSet" %>

<%@ page import="javax.portlet.PortletConfig" %><%@
page import="javax.portlet.PortletContext" %><%@
page import="javax.portlet.PortletException" %><%@
page import="javax.portlet.PortletMode" %><%@
page import="javax.portlet.PortletPreferences" %><%@
page import="javax.portlet.PortletRequest" %><%@
page import="javax.portlet.PortletResponse" %><%@
page import="javax.portlet.PortletSession" %><%@
page import="javax.portlet.PortletURL" %><%@
page import="javax.portlet.RenderRequest" %><%@
page import="javax.portlet.RenderResponse" %><%@
page import="javax.portlet.ResourceURL" %><%@
page import="javax.portlet.UnavailableException" %><%@
page import="javax.portlet.ValidatorException" %><%@
page import="javax.portlet.WindowState" %>

<%-- <%@ page import="sambaash.platform.srv.membershippackage.model.MembershipPackage" %>

<%@ page import="sambaash.platform.srv.membershippackage.model.MembershipPackageServices_Roles" %><%@
page import="sambaash.platform.srv.membershippackage.service.MembershipPackageLocalServiceUtil" %> --%><%@
page import="sambaash.platform.srv.membershippackage.service.MembershipPackageServices_RolesLocalServiceUtil" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<%
String communityName = SambaashUtil.getCommunityName(themeDisplay.getScopeGroupId());

Log _log = LogFactoryUtil.getLog(this.getClass().getName());
_log.info("communityName "+communityName);

String rolepopup = "";
String[] rolenames={"sambaashUser","Administrator","admin","Six Degrees Admin","TechAdmin"};
String sgpopup = "/widget/web/"+communityName+"/serviceregistry?p_p_id=Spsc_WAR_Spscportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_Spsc_WAR_Spscportlet_struts_action=%2Fspsc%2Fservicecomponentgroup_action&_Spsc_WAR_Spscportlet_CMD=lookup','popuppage','width=850,toolbar=no,location=0,menubar=no,status=no,resizable=1,scrollbars=yes,height=700,top=100,left=100";
String scpopup = "/widget/web/"+communityName+"/serviceregistry?p_p_id=Spsc_WAR_Spscportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_Spsc_WAR_Spscportlet_struts_action=%2Fspsc%2Fservicecomponents_action&_Spsc_WAR_Spscportlet_CMD=sclookup','popuppage','width=850,location=no,toolbar=no,menubar=no,status=no,resizable=1,scrollbars=yes,height=700,top=100,left=100";

sgpopup = "/widget/web/"+communityName+"/serviceregistry?p_p_id=Spsc_WAR_Spscportlet&p_p_lifecycle=0&_Spsc_WAR_Spscportlet_jspPage=/html/servicecomponentgroup_lookup.jsp&_Spsc_WAR_Spscportlet_CMD=sglookup','popuppage','width=850,toolbar=no,location=0,menubar=no,status=no,resizable=1,scrollbars=yes,height=700,top=100,left=100";
scpopup = "/widget/web/"+communityName+"/serviceregistry?p_p_id=Spsc_WAR_Spscportlet&p_p_lifecycle=0&_Spsc_WAR_Spscportlet_jspPage=/html/servicecomponents_lookup.jsp&_Spsc_WAR_Spscportlet_CMD=sclookup','popuppage','width=850,toolbar=no,location=0,menubar=no,status=no,resizable=1,scrollbars=yes,height=700,top=100,left=100";
rolepopup = "/widget/web/"+communityName+"/membershippackages?p_p_id=Spmp_WAR_Spmpportlet&p_p_lifecycle=0&_Spmp_WAR_Spmpportlet=/html/membershippackageRoles_lookup.jsp&_Spmp_WAR_Spmpportlet_CMD=lookup";
String defaultValue = "Click to Update";
%>

<%
	String ctxPath = request.getContextPath();
	if (ctxPath != null && ctxPath.length()==1) {
		ctxPath = "";
	}

	PortletSession pSession = renderRequest.getPortletSession();

	//boolean isGuest = (user==null);
	//boolean isAdmin = !isGuest && CommonUtil.isAdmin(user);
	//boolean isPowerUser = !isAdmin &&  CommonUtil.isPowerUser(user);
	//boolean isUser = !isPowerUser && CommonUtil.isUser(user);
	PortletURL renderURL = renderResponse.createRenderURL();
	renderURL.setWindowState(WindowState.NORMAL);

	PortletURL roleURL = renderResponse.createRenderURL();
	roleURL.setWindowState(WindowState.NORMAL);
	roleURL.setParameter("struts_action", "/spmp/membershippackage_action");
	roleURL.setParameter("CMD", "lookup");

	PortletURL actionURL = renderResponse.createActionURL();
	actionURL.setWindowState(WindowState.NORMAL);

	String plns = "";
	if (renderRequest != null) {
		plns = renderResponse.getNamespace();
	}
%>

<%
String user1;
int a,b;
long companyID=0,roleID=0,userID=0;
boolean roleId1=false;
companyID=CompanyThreadLocal.getCompanyId();
user1=request.getRemoteUser();
for (a=0;a<rolenames.length;a++) {
	for (b=0;b<=a;b++) {
	   try{
		roleID= RoleLocalServiceUtil.getRole(companyID, rolenames[b]).getRoleId();
		if (user1!=null) {
			userID=Long.valueOf(user1).longValue();
				if (UserLocalServiceUtil.hasRoleUser(roleID,userID))
					{ roleId1=true; }
		 } } catch(Exception e) { }
} }
%>

<%@ include file="/html/common/portlet_js.jsp" %>
<%@ include file="/html/common/portlet_css.jsp" %>
<script type="text/javascript">
	<%@ include file="/js/jquery.alerts.js" %>
</script>

<script type="text/javascript">
	<%@ include file="/js/jquery.ui.draggable.js" %>
</script>