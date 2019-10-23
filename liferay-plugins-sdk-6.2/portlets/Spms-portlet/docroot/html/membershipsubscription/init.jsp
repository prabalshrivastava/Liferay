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

<%@ page import="java.util.Set" %><%@
page import="java.util.Map" %><%@
page import="java.util.List" %><%@
page import="java.util.Date" %><%@
page import="java.util.Stack" %><%@
page import="java.util.Arrays" %><%@
page import="java.util.Locale" %><%@
page import="java.util.HashMap" %><%@
page import="java.util.TreeSet" %><%@
page import="java.util.TreeMap" %><%@
page import="java.util.HashSet" %><%@
page import="java.util.TimeZone" %><%@
page import="java.util.Iterator" %><%@
page import="java.util.Currency" %><%@
page import="java.util.Calendar" %><%@
page import="java.util.ArrayList" %><%@
page import="java.util.Properties" %><%@
page import="java.util.Collection" %><%@
page import="java.util.Collections" %><%@
page import="java.util.Enumeration" %><%@
page import="java.util.LinkedHashMap" %><%@
page import="java.util.LinkedHashSet" %><%@
page import="java.util.ResourceBundle" %><%@
page import="java.text.SimpleDateFormat" %><%@
page import="java.util.GregorianCalendar" %>

<%@ page import="javax.portlet.PortletURL" %><%@
page import="javax.portlet.ResourceURL" %><%@
page import="javax.portlet.WindowState" %><%@
page import="javax.portlet.PortletMode" %><%@
page import="javax.portlet.PortletConfig" %><%@
page import="javax.portlet.RenderRequest" %><%@
page import="javax.portlet.RenderResponse" %><%@
page import="javax.portlet.PortletContext" %><%@
page import="javax.portlet.PortletRequest" %><%@
page import="javax.portlet.PortletSession" %><%@
page import="javax.portlet.PortletResponse" %><%@
page import="javax.portlet.PortletException" %><%@
page import="javax.portlet.PortletPreferences" %><%@
page import="javax.portlet.ValidatorException" %><%@
page import="javax.portlet.UnavailableException" %>

<%@ page import="com.liferay.portal.kernel.util.WebKeys" %><%@
page import="com.liferay.portal.kernel.util.ListUtil" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.dao.search.ResultRow" %><%@
page import="com.liferay.portal.kernel.servlet.SessionMessages" %><%@
page import="com.liferay.portal.kernel.log.Log" %><%@
page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>

<%@ page import= "com.liferay.portal.service.RoleLocalServiceUtil" %><%@
page import="com.liferay.portal.service.UserLocalServiceUtil" %><%@
page import="com.liferay.portal.security.auth.CompanyThreadLocal" %><%@
page import="com.liferay.portal.util.PortalUtil" %><%@
page import="com.liferay.portal.model.User" %>

<%@ page import="sambaash.platform.hlp.UIHelper" %>

<%@ page import="com.liferay.portal.kernel.log.Log" %><%@
page import="com.liferay.portal.kernel.log.LogFactoryUtil" %><%@
page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil" %><%@
page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil" %>

<%@ page import="sambaash.platform.srv.membershippackage.model.MembershipPackage" %><%@
page import="sambaash.platform.srv.membershippackage.service.MembershipPackageLocalServiceUtil" %><%@ page import="sambaash.platform.srv.socialprofile.model.SocialProfile" %><%@
page import="sambaash.platform.srv.socialprofile.service.SocialProfileLocalServiceUtil" %>

<%@ page import="sambaash.platform.srv.socialprofile.NoSuchSocialProfileException" %>

<%@ page import="com.liferay.portal.security.auth.*" %><%@
page import="sambaash.platform.hlp.*" %><%@
page import="sambaash.platform.srv.spparameter.service.SPParametersLocalServiceUtil" %><%@
page import="sambaash.platform.srv.spparameter.model.SPParameters" %>

<%@ page import="com.liferay.portal.theme.ThemeDisplay" %><%@
page import="sambaash.platform.util.SambaashConstants" %><%@
page import="sambaash.platform.srv.spparameter.NoSuchSPParametersException" %>

<%@ page import="sambaash.platform.srv.spparameter.service.SPParametersLocalServiceUtil" %><%@
page import="sambaash.platform.srv.spparameter.model.SPParameters" %><%@
page import="sambaash.platform.util.SambaashUtil" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
Log _log = LogFactoryUtil.getLog(this.getClass().getName());

String host = PortalUtil.getHost(request);

String communityNameKey = SambaashConstants.CURRENT_COMMUNITY_NAME;

String communityName = SambaashUtil.getCommunityName(themeDisplay.getScopeGroupId());

long groupId = themeDisplay.getScopeGroupId();

int port = PortalUtil.getPortalPort();
//+host+":"+port+

//out.println("==getPortalURL=>"+PortalUtil.getPortalURL(request)+"<==getPortalURL=");

String[] rolenames={"sambaashUser","Administrator","admin","MediCafeUserRole"};

String p_p_auth_init = request.getParameter("authen_p_p");
String p_auth_init = request.getParameter("authen_p");

String paymentReturnUrl = PortalUtil.getPortalURL(request)+SambaashUtil.getCommunityPath(groupId) + "/membershipsubscription?CMD=pay&p_p_id=Spms_WAR_Spmsportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_Spms_WAR_Spmsportlet_struts_action=/spms/payment_return";
String cancelReturnUrl = PortalUtil.getPortalURL(request)+SambaashUtil.getCommunityPath(groupId) + "/home?p_p_id=58&p_p_lifecycle=1&p_p_state=maximized&p_p_mode=view&_58_struts_action=/login/create_account&p_p_auth="+p_p_auth_init+"&p_auth="+p_auth_init;

String paypalGatewayUrl =  "";// https://www.paypal.com and https://www.sandbox.paypal.com/

String bnImgUrl = "";//"PP-BuyNowBF:btn_buynowCC_LG.gif:NonHosted";

String mppopup = "/widget" + SambaashUtil.getCommunityPath(groupId) + "/membershippackages/-/Spmp_WAR_Spmpportlet?p_p_id=Spmp_WAR_Spmpportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&struts_action=%2Fspmp%2Fmembershippackageaddonservices_action&_Spmp_WAR_Spmpportlet_CMD=lookup','popuppage','width=850,location=no,toolbar=no,menubar=no,status=no,resizable=1,scrollbars=yes,height=700,top=100,left=100";
String createAccountFormurl = SambaashUtil.getCommunityPath(groupId) + "/home?p_p_id=58&amp;p_p_lifecycle=1&amp;p_p_url_type=0&amp;p_p_state=maximized&amp;p_p_mode=view&amp;saveLastPath=0&amp;_58_struts_action=/login/create_account";
String upgradeFormurl = SambaashUtil.getCommunityPath(groupId) + "/membershipsubscription?CMD=upgrade_member&p_p_id=Spms_WAR_Spmsportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_Spms_WAR_Spmsportlet_struts_action=/spms/upgrade_membership";
String createAccountErrUrl = SambaashUtil.getCommunityPath(groupId) + "/home?p_p_id=58&p_p_lifecycle=1&p_p_state=maximized&p_p_mode=view&saveLastPath=0&_58_struts_action=%2Flogin%2Fcreate_account";
String createAccountTriUrl = SambaashUtil.getCommunityPath(groupId) + "/home?p_p_id=58&amp;p_p_lifecycle=1&amp;p_p_url_type=0&amp;p_p_state=maximized&amp;p_p_mode=view&amp;saveLastPath=0&amp;_58_struts_action=/login/create_account&CMD=process";
String cancleBtnLocation =SambaashUtil.getCommunityPath(groupId) + "/welcome?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&_58_struts_action=%2Flogin%2Fcreate_account";
String createAccountHomeUrl = SambaashUtil.getCommunityPath(groupId) + "/welcome";

//String paypalid = PropsUtil.get("spms.paypal.paypalid");//"SUKE5X2GA2XNY";//"HD784YA7GNMF4";//"VJXL9KL9XPUGW";
String paypalid="";
float taxFactor = 0.00f;//Float.parseFloat(MembershipSubscriptionConfigurValue.PAYPAL_TAXFACTOR.toString());//7.0f;
try{
SPParameters spparam =SPParametersLocalServiceUtil.findBySPParametersGroupIdAndName(groupId,
		SambaashConstants.PAYPAL_PAYPALID);
paypalid = spparam.getValue();//MembershipSubscriptionConfigurValue.PAYPAL_PAYPALID.toString();//"SUKE5X2GA2XNY";//"HD784YA7GNMF4";//"VJXL9KL9XPUGW";

SPParameters spparamTax =SPParametersLocalServiceUtil.findBySPParametersGroupIdAndName(groupId,
		SambaashConstants.PAYPAL_TAXFACTOR);
taxFactor = Float.parseFloat(spparamTax.getValue());

SPParameters spparamPamentGateWayUrl = SPParametersLocalServiceUtil.findBySPParametersGroupIdAndName(groupId,SambaashConstants.PAYMENTGATEWAY.PAYMENT_GATEWAY_URL);
paypalGatewayUrl = spparamPamentGateWayUrl.getValue();

SPParameters spparamPamentGateWayBtnUrl = SPParametersLocalServiceUtil.findBySPParametersGroupIdAndName(groupId,SambaashConstants.PAYMENTGATEWAY.PAYMENT_GATEWAY_BUTTON_URL);
bnImgUrl = spparamPamentGateWayBtnUrl.getValue();

}catch(Exception exe) {
	_log.error("exe.getMessage ::: "+exe.getMessage());
}
//paypalid = "VJXL9KL9XPUGW" ;
String imgUrl1 = paypalGatewayUrl+"/en_US/i/btn/btn_buynowCC_LG.gif";
String imgUrl2 = paypalGatewayUrl+"/en_US/i/scr/pixel.gif";
String paypalurl =paypalGatewayUrl+"/cgi-bin/webscr";

_log.info("paypalGatewayUrl : "+paypalGatewayUrl);
_log.info("imgUrl2 : "+imgUrl2);
_log.info("paypalid : "+paypalid);
_log.info("taxFactor : "+taxFactor);
_log.info("paypalurl : "+paypalurl);

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

<%@ page import="sambaash.platform.hlp.MembershipSubscriptionConfigurValue" %><%@
page import="sambaash.platform.util.SambaashConstants" %><script type="text/javascript">
	<%@ include file="/html/js/jquery-1.3.2.js" %>
</script>

<script type="text/javascript">
	<%@ include file="/html/js/jquery.alerts.js" %>
</script>

<script type="text/javascript">
	<%@ include file="/html/js/jquery.ui.draggable.js" %>
</script>

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

	//String paypal_notify = "http://ec2-175-41-133-100.ap-southeast-1.compute.amazonaws.com:9110/web/ic/membershipsubscription?p_p_id=Spms_WAR_Spmsportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_Spms_WAR_Spmsportlet_struts_action=%2Fspms%2Fpaypal_notify&_Spms_WAR_Spmsportlet_CMD=notify";

	//String paypal_notify = "http://"+request.getServerName()+":"+request.getServerPort()+"/web/"+communityName+"/membershipsubscription?p_p_id=Spms_WAR_Spmsportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_Spms_WAR_Spmsportlet_struts_action=%2Fspms%2Fpaypal_notify&_Spms_WAR_Spmsportlet_CMD=notify";

	PortletURL paypal_notifyUrl = renderResponse.createRenderURL();
	paypal_notifyUrl.setWindowState(WindowState.NORMAL);
	paypal_notifyUrl.setParameter("struts_action","/spms/paypal_notify");
	paypal_notifyUrl.setParameter("CMD","notify");

	_log.info("paypal_notifyUrl : "+paypal_notifyUrl);

	PortletURL renderURL = renderResponse.createRenderURL();
	renderURL.setWindowState(WindowState.NORMAL);

	PortletURL actionURL = renderResponse.createActionURL();
	actionURL.setWindowState(WindowState.NORMAL);

	String plns = "";
	if (renderRequest != null) {
		plns = renderResponse.getNamespace();
	}
%>

<%@ include file="js/portlet_js.jsp" %>
<%@ include file="css/portlet_css.jsp" %>