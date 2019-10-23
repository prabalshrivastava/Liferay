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
<%@ page import="org.apache.commons.codec.binary.Hex" %>
<style type="text/css">

#child-navigation {
display:none;
}

</style>

<%!
private static Log _log = LogFactoryUtil.getLog("html.spms.payment.jsp");
String instructionToBuyer = "After the payment Please click Return to sambaash PTE LTD's Test Store.";
%>

<%
	String firstName = "";
	String lastName = "";
	String emailAddress = "";
	String password = "";
	String memberType = "";
	String userType = "";
	String _58_sessionId = "";
	String p_p_auth = "";
	String p_auth = "";

	String terms = "";
	String roleId = "";
	String cmd = "";
	String openId = "";
	String save = "";
	String birthday_day = "";
	String birthday_month = "";
	String birthday_year = "";

	String mpSubscriptionName = communityName;
	String netTotal = "";
	String memberPack = (String)request.getAttribute("memberPack");
	String mpId = (String)request.getAttribute("mpId");
	_log.info("memberPack" + memberPack);
	if ((memberPack != null) && (memberPack.equals("true"))) {
		cancelReturnUrl =PortalUtil.getPortalURL(request)+"/web/$defaultCommunityName/membershipsubscription?p_p_id=Spms_WAR_Spmsportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_Spms_WAR_Spmsportlet_struts_action=/spms/upgrade&CMD=upgrade";
		paymentReturnUrl = paymentReturnUrl+"&upgrade_member=true" + "&mpId=" + mpId;
	}
	_log.info("paymentReturnUrl" + paymentReturnUrl);
	PortletURL portletURL = new PortletURLImpl(request, PortletKeys.LOGIN, Long.parseLong(PortletKeys.LOGIN), PortletRequest.RENDER_PHASE);

		portletURL.setWindowState(WindowState.MAXIMIZED);
		portletURL.setPortletMode(PortletMode.VIEW);

		portletURL.setParameter("saveLastPath", "/login/create_account");
		portletURL.setParameter("struts_action", "/login/create_account");

		Object err = request.getAttribute("pwdError");

		//String errorClass = err.getClass().getName();

		firstName = request.getParameter("_58_firstName");
		lastName = request.getParameter("_58_lastName");
		emailAddress = request.getParameter("_58_emailAddress");
		password = request.getParameter("_58_password1");
		memberType = request.getParameter("memberType");
		userType = request.getParameter("userType");
		roleId = request.getParameter("mpExtra1_1");
		cmd = request.getParameter("_58_cmd");
		openId = request.getParameter("_58_openId");
		save = request.getParameter("save");
		terms = request.getParameter("terms");
		_58_sessionId = request.getParameter("_58_sessionId");
		p_p_auth = AuthTokenUtil.getToken(request);
		p_auth = AuthTokenUtil.getToken(request);
		_log.info("Payment p_auth : "+p_auth);
		_log.info("Payment p_p_auth : "+p_p_auth);

		birthday_day = request.getParameter("_58_birthdayDay");
		birthday_month =request.getParameter("_58_birthdayMonth");
		birthday_year =request.getParameter("_58_birthdayYear");

		mpSubscriptionName += "   " + request.getParameter("mpName_1") + " - " + firstName+lastName;
		netTotal = request.getParameter("netTotal");
		_log.info("mpSubscriptionName : "+mpSubscriptionName);
		_log.info("Session Id From Payment : "+_58_sessionId);

		User payuser = new UserImpl();
		payuser.setFirstName(firstName );
		payuser.setLastName(lastName );
		payuser.setPassword(password);
		payuser.setEmailAddress(emailAddress);
		payuser.setReminderQueryAnswer(userType);
		payuser.setReminderQueryQuestion(memberType);
		payuser.setOpenId(openId);
		//set roleId
		payuser.setComments(roleId);
		//set cmd
		payuser.setGreeting(cmd);
		//set save
		payuser.setLanguageId(save);
		//set birthday_day
		payuser.setLastLoginIP(birthday_day);
		//set birthday_month
		payuser.setLoginIP(birthday_month);
		//set birthday_year
		payuser.setScreenName(birthday_year);
		//set sessionId
		payuser.setTimeZoneId(_58_sessionId);
		//set p_auth
		payuser.setUuid(p_auth);
		//set p_p_auth
		payuser.setJobTitle(p_p_auth);

		_log.info("putting into MultiVMPoolUtil session : "+request.getSession().getId());
		MultiVMPoolUtil.put(PaymentUtil._cache, request.getSession().getId(), payuser);

int rowCount = 0;
ArrayList<String> codeNumberArr = new ArrayList<String>();
Enumeration enu = request.getParameterNames();
while (enu.hasMoreElements()) {

	String temp = (String)enu.nextElement();
	_log.info(temp+" *** "+request.getParameter(temp));
	if (temp.contains("scName")) {
		codeNumberArr.add(temp.substring(6));
		rowCount++;
	}

}
%>

<form action="<%= paypalurl %>" method="post" name="paypalpaymentform">
<input name="<portlet:namespace />cmd" type="hidden" value="_xclick">
<input name="<portlet:namespace />business" type="hidden" value="<%= paypalid %>">
<input name="<portlet:namespace />lc" type="hidden" value="US">
<input name="<portlet:namespace />item_name" type="hidden" value="<%= mpSubscriptionName %>">
<input name="<portlet:namespace />item_number" type="hidden" value="<%= roleId %>">
<input name="<portlet:namespace />amount" type="hidden" value="<%= netTotal %>">
<input name="<portlet:namespace />currency_code" type="hidden" value="SGD">
<input name="<portlet:namespace />button_subtype" type="hidden" value="services">
<input name="<portlet:namespace />no_shipping" type="hidden" value="1">
<input name="<portlet:namespace />quantity" type="hidden" value="1">
<input name="<portlet:namespace />rm" type="hidden" value="1">
<input name="<portlet:namespace />return" type="hidden" value="<%= paymentReturnUrl %>">
<input name="<portlet:namespace />cancel_return" type="hidden" value="<%= cancelReturnUrl %>">
<input name="<portlet:namespace />tax_rate" type="hidden" value="0.00">
<input name="<portlet:namespace />shipping" type="hidden" value="0.00">
<input name="<portlet:namespace />bn" type="hidden" value="<%= bnImgUrl %>">
<input alt="PayPal - The safer, easier way to pay online!" border="0" name="<portlet:namespace />submit" src="<%= imgUrl1 %>" type="image">
<img alt="PayPal Image" border="0" height="1" src="<%= imgUrl2 %>" width="1" />

<input name="<portlet:namespace />notify_url" type="hidden" value="<%= paypal_notifyUrl.toString() %>" />

<input name="<portlet:namespace />on0" type="hidden" value="<%= communityName %>" />
<input name="<portlet:namespace />custom" type="hidden" value="<%= emailAddress %>" />

<input name="<portlet:namespace />cn" type="hidden" value="<%= instructionToBuyer %>">

<!--includedServiceNames-->

<%
	Iterator<String> codeNumberItr = codeNumberArr.iterator();
ArrayList<String> scForPayPal = new ArrayList<String>();
int countPayPal = 1;
scForPayPal.add(request.getParameter("mpName_1"));
countPayPal++;
int countInput =1;
boolean firstTimePrint=true;
_log.info("rowCount " + rowCount);
for (int i = 0; i < rowCount; i++) {
	String code = codeNumberItr.next();
	_log.info("scName" + code);
	String scname = request.getParameter("scName" + code);
	scForPayPal.add(scname);
	_log.info("rowCount Before if " + rowCount);
	if (countPayPal==3) {
	%>

		<input name="<portlet:namespace />on<%= countInput %>" type="hidden" value="<%= scForPayPal.get(0) %>,<%= scForPayPal.get(1) %>,<%= scForPayPal.get(2) %>">

	<%
	_log.info("countInput : "+countInput);
		countInput++;
		scForPayPal = new ArrayList<String>();
	}countPayPal++;

}
int scForPayPalArrSize = scForPayPal.size();
_log.info("countInput : "+countInput);
_log.info("scForPayPalArrSize : "+scForPayPalArrSize);
if (scForPayPalArrSize>0) {
%>

<input name="<portlet:namespace />on<%= countInput %>" type="hidden" value="<%
	for (int i=0;i<scForPayPalArrSize;i++) {
	%>

		<%= scForPayPal.get(i)+',' %>

	<%
	}
 %>">

<%
}
%>

</form>

<form action="<%= paypalurl %>" method="post" name="paypalpaymentformXXXX">
<input name="<portlet:namespace />cmd" type="hidden" value="_s-xclick">
<input name="<portlet:namespace />hosted_button_id" type="hidden" value="<%= paypalid %>">

<input name="<portlet:namespace />currency_code" type="hidden" value="SGD">
<input name="<portlet:namespace />item_name" type="hidden" value="<%= mpSubscriptionName %>">
<input name="<portlet:namespace />amount" type="hidden" value="<%= netTotal %>">

</form>
loading ... please wait...

<script type="text/javascript">
	document.paypalpaymentform.submit();
</script>
