<%@ include file="init.jsp" %>

<%@ page import="com.liferay.portlet.PortletURLImpl" %>
<%@ page import="com.liferay.portal.util.PortletKeys" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ page import="com.liferay.portal.NoSuchPasswordPolicyException" %>
<%@ page import="java.util.*" %>

<%@ page import="com.liferay.portal.model.User" %>
<%@ page import="com.liferay.portal.util.CookieKeys" %>
<%@ page import="com.liferay.util.CookieUtil" %>
<%@ page import="com.liferay.portal.model.impl.*" %>
<%@ page import="com.liferay.portal.kernel.cache.MultiVMPoolUtil" %>
<%@ page import="sambaash.platform.hlp.*" %>
<%@ page import="com.liferay.portal.kernel.util.*" %>

<%!
private static Log _log = LogFactoryUtil.getLog("html.spms.paymentReturn.jsp");
%>

<%@ page import="sambaash.platform.srv.membershipsubscription.service.MembershipSubscriptionLocalServiceUtil" %>
<%@ page import="sambaash.platform.srv.membershipsubscription.model.MembershipSubscription" %><style type="text/css">
#child-navigation {
display:none;
}
</style>

<%

//String get(HttpServletRequest request, String name)

Cookie[] cookies = request.getCookies();

if (cookies != null) {

for (int i = 0; i < cookies.length; i++) {
	Cookie cookie = cookies[i];

	String cookieName = GetterUtil.getString(cookie.getName());

	_log.info(cookieName+" : "+cookie.getValue());

	}

}

_log.info("currUser : "+CookieUtil.get(request, "currUser"));

String emailAddress = GetterUtil.getString(CookieUtil.get(request, "currUser"));
String currentSessionId = request.getSession().getId();

_log.info("emailAddress : "+emailAddress);


_log.info("session : "+currentSessionId);

//Yan 20101213 fix for session time out issue and sending mail twice when coming back to sambaash from paypal
List<MembershipSubscription> spmsList = MembershipSubscriptionLocalServiceUtil.findByMembershipSubscriptionSessionId(currentSessionId);

String status ="";
_log.info("spmsList.size() : "+spmsList.size());

String memberPack = (String)request.getAttribute("upgrade_member");
String mpId = (String)request.getAttribute("mpId");
_log.info("memberPack" + memberPack + "mpId" + mpId);
String _58_sessionId = "";
String firstName = "";
String lastName = "";
String password = "";
String memberType = "";
String userType = "";
String roleId = "";
String cmd = "";
String openId = "";
String save = "";
String birthday_day = "";
String birthday_month = "";
String birthday_year = "";
String p_auth = "";
String p_p_auth = "";
String tx = "";
String amt = "";
String cc = "";
String cm = "";
String item_number = "";
boolean isSchedulerRunComplete = false;

String mpSubscriptionName = "";
String netTotal = "";
p_auth = AuthTokenUtil.getToken(request);
p_p_auth = AuthTokenUtil.getToken(request);
//Is session is not time out the size of spms list will have more than 0 and also scheduler is not run yet the size of spms list will have more than 0

Object obj = MultiVMPoolUtil.get(PaymentUtil._cache, request.getSession().getId());
User payuser = (User) obj;
_log.info("payuser " + payuser);
if (payuser !=null) {
try{

	tx =  request.getParameter("tx"); //pptxnid
	status =  request.getParameter("st");  //pppaymentstatus
	amt =  request.getParameter("amt");  //pppaymentgross
	cc =  request.getParameter("cc"); //ccname
	cm =  request.getParameter("cm");// //cctype
	item_number = request.getParameter("item_number");

	PortletURL portletURL = new PortletURLImpl(request, PortletKeys.LOGIN, Long.parseLong(PortletKeys.LOGIN), PortletRequest.RENDER_PHASE);

		portletURL.setWindowState(WindowState.MAXIMIZED);
		portletURL.setPortletMode(PortletMode.VIEW);

		portletURL.setParameter("saveLastPath", "/login/create_account");
		portletURL.setParameter("struts_action", "/login/create_account");

		Object err = request.getAttribute("pwdError");

		firstName = payuser.getFirstName();
		lastName = payuser.getLastName();
		emailAddress = payuser.getEmailAddress();
		password = payuser.getPassword();
		memberType = payuser.getReminderQueryQuestion();
		userType = payuser.getReminderQueryAnswer();
		//get p authen
		//p_auth = payuser.getUuid();
		//get p_p_authen
		//_p_auth = payuser.getJobTitle();

		openId = payuser.getOpenId();
		//get roleId
		roleId = payuser.getComments();
		//get cmd
		cmd = payuser.getGreeting();
		//get save
		save = payuser.getLanguageId();
		//get birthday_day
		birthday_day = payuser.getLastLoginIP();
		//get birthday_month
		birthday_month = payuser.getLoginIP();
		//get birthday_year
		birthday_year = payuser.getScreenName();
		//get sessionId

		_log.info("p_auth Return : "+p_auth);
		_log.info("p_p_auth Return : "+p_p_auth);
		_log.info("emailAddress Return : "+emailAddress);

		_58_sessionId = payuser.getTimeZoneId();

		mpSubscriptionName = request.getParameter("mpName_1");
		netTotal = request.getParameter("netTotal");
		_log.info("Payment Return sessionId : "+_58_sessionId);
}catch(Exception e){_log.error("paypal session timeout");}
		if ((memberPack != null) && (memberPack.equals("true"))) {
			upgradeFormurl = upgradeFormurl + "&userId=" + userID + "&upgrade_member=true" + "&mpId=" + mpId + "&payment=true";
			/*if ((status != "") || (status.equalsIgnoreCase("completed"))) {
				createAccountFormurl = createAccountHomeUrl;
			}else {*/
				createAccountFormurl = upgradeFormurl;
			//}
			 %>

	<% }else {
		/*if ((status != "") || (status.equalsIgnoreCase("completed"))) {
			createAccountFormurl = createAccountHomeUrl;
		}else {*/
			createAccountFormurl+="&p_p_auth="+p_p_auth+"&p_auth="+p_auth;
		//}
		}
%>

<script>
//window.location = "str";
</script>
<form action="<%= createAccountFormurl %>" class="uni-form" method="post" name="createAccountForm">

				<input name="<portlet:namespace />save" type="hidden" value="<%= save %>" />
				<input name="<portlet:namespace />_58_cmd" type="hidden" value="<%= cmd %>" />
				<input name="<portlet:namespace />_58_openId" type="hidden" value="<%= openId %>" />
				<input name="<portlet:namespace />_58_firstName" type="hidden" value="<%= firstName %>" />
				<input name="<portlet:namespace />terms" type="hidden" value="<%= lastName %>" />
				<input name="<portlet:namespace />memberType" type="hidden" value="<%= memberType %>" />
				<input name="<portlet:namespace />_58_emailAddress" type="hidden" value="<%= emailAddress %>" />
				<input name="<portlet:namespace />userType" type="hidden" value="<%= userType %>" />
				<input name="<portlet:namespace />_58_lastName" type="hidden" value="<%= lastName %>" />
				<input name="<portlet:namespace />_58_password1" type="hidden" value="<%= password %>" />
				<input name="<portlet:namespace />_58_birthdayDay" type="hidden" value="<%= birthday_day %>" />
				<input name="<portlet:namespace />_58_birthdayMonth" type="hidden" value="<%= birthday_month %>" />
				<input name="<portlet:namespace />_58_birthdayYear" type="hidden" value="<%= birthday_year %>" />
				<input name="<portlet:namespace />_58_sessionId" type="hidden" value="<%= _58_sessionId %>" />
				<input name="<portlet:namespace />mySessionId" type="hidden" value="<%= _58_sessionId %>" />
				<input name="<portlet:namespace />_spms_WAR_spms5231_mpExtra1_1" type="hidden" value="<%= roleId %>" />
				<input name="<portlet:namespace/>mpName_1" type="hidden" value="<%= memberType %>" />
				<input name="<portlet:namespace/>mpOrder_1" type="hidden" value="MPOrder" />
				<input name="<portlet:namespace/>mpId_1" type="hidden" value="<%= mpId %>" />
				<input name="<portlet:namespace />pay_complete" type="hidden" value="true" />

				<input name="<portlet:namespace />tx" type="hidden" value="<%= tx %>" />
				<input name="<portlet:namespace />status" type="hidden" value="<%= status %>" />
				<input name="<portlet:namespace />amt" type="hidden" value="<%= amt %>" />
				<input name="<portlet:namespace />cc" type="hidden" value="<%= cc %>" />
				<input name="<portlet:namespace />cm" type="hidden" value="<%= cm %>" />

<!-- <td width="5%"><input type="submit" value="Save"></td> -->

</form>

<%
	}
else {
		_log.info("^^^ memberPack ^^^ "+memberPack);
		if ((memberPack != null) && (memberPack.equals("true"))) {
//			status="Completed";

//			upgradeFormurl = 	upgradeFormurl + "&userId=" + userID + "&upgrade_member=true" + "&mpId=" + mpId + "&payment=true&isSchedulerRun=true";
//			createAccountFormurl = upgradeFormurl;
//			_log.info("^^^ createAccountFormurl ^^^ "+createAccountFormurl);
		String membershipPackageType = "";
		try{
			membershipPackageType = MembershipPackageLocalServiceUtil.getMembershipPackage(Long.parseLong(mpId)).getName();
		}catch(Exception ex) {
			_log.error("MembershipPackageLocalServiceUtil.getMembershipPackage(Long.parseLong(mpId)) Exception :"+ex.getMessage());
		}
		upgradeFormurl = upgradeFormurl + "&userId=" + userID + "&upgrade_member=true" + "&mpId=" + membershipPackageType + "&payment=true";

		 createAccountHomeUrl = upgradeFormurl;

	}else {
		createAccountHomeUrl = SambaashUtil.getCommunityPath(groupId)+"/home?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized"+
		"&p_p_mode=view&saveLastPath=0&_58_struts_action=/login/login&sessiontimeout=true";
	}
	}
	//MembershipSubscriptionLocalServiceUtil.findByMembershipSubscriptionPpPaymentStatus(status);
%>

<script type="text/javascript">
//	document.paypalpaymentform.submit();
var sta = "<%= status %>";
if ( sta == "Pending" || sta == "Completed") {
	document.createAccountForm.submit();
	}
	else {
		window.location ="<%= createAccountHomeUrl %>";
	}
</script>