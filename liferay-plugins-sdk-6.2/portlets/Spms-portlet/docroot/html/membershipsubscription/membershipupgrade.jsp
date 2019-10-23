<%@ include file="init.jsp" %>

<%@ page import="sambaash.platform.srv.membershipsubscription.model.MembershipSubscription" %>
<%@ page import="sambaash.platform.srv.membershipsubscription.service.MembershipSubscriptionLocalServiceUtil" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.util.*" %>

<%@ page import="sambaash.platform.srv.membershippackage.model.MembershipPackagePromotionCode" %>
<%@ page import="sambaash.platform.srv.membershippackage.service.MembershipPackagePromotionCodeLocalServiceUtil" %><div id="scgtable"> Membership Package Upgrade</div>
<%!
private static Log _log = LogFactoryUtil.getLog("html.membershipupgrade.jsp");
%>

<%
String isNotPromotionCode = "not_promotion_code";
String isNotPromotionPeriod = "not_promotion_period";
String has_PromotionCode = "not_having_promotion_code";

String promotionCode = (String)request.getParameter("is_promotion_code");
String promotionPeriod = (String)request.getParameter("is_promotion_period");
String hasPromotionCode = (String)request.getParameter("has_promotion_code");

_log.info("promotionCode : "+promotionCode);
_log.info("promotionPeriod : "+promotionPeriod);
_log.info("hasPromotionCode : "+hasPromotionCode);

//String is_promotion_period =
String upgrade_status = (String)request.getAttribute("upgrade");
//if ((upgrade_status != null) && (upgrade_status.equals("true"))) {

if (!roleId1) {
%>

<style type="text/css">

#child-navigation {
display:none;
}

</style>

<%
}
int count = 0;
List<MembershipPackage> items = null;
List indList =null;
List<MembershipPackage> mpList = new ArrayList<MembershipPackage>();
String mpName = "";
String mpDescription ="";
long mpId = 0;
float mpPrice = 0;
float yrPrice = 0;
String mpValidity = "";
String mpValid = "";
long mUserId = 0;
String mpCurrency = "";
float usrPrice = 0;
int i =0;
String mType = "";
Iterator<MembershipPackage> mpItr = null;
Iterator<MembershipPackage> mpItrMsg = null;
try{
	//UserProfileBasic mpack = UserProfileBasicLocalServiceUtil.getUserProfileBasic(userID);
	SocialProfile mpack = SocialProfileLocalServiceUtil.getSocialProfile(userID);
	mUserId = mpack.getMemberPackage();
	mType = mpack.getUserType();

	_log.info("mType is : "+mType);
	count = MembershipPackageLocalServiceUtil.getMembershipPackagesCount();

			items = MembershipPackageLocalServiceUtil.findByMembershipPackageType(mType);
			mpItr = items.iterator();
			mpItrMsg=items.iterator();
}catch(Exception e) {

}

	Date promotionTo = null;
	Date promotionFrom = null;

	PortletURL renderURL2 = renderResponse.createActionURL();
	renderURL2.setParameter("struts_action", "/spms/upgrade");

	/*PortletURL actionFormUrl = renderResponse.createActionURL();
	actionFormUrl.setParameter("struts_action", "/spms/addItem");
	actionFormUrl.setParameter("CMD", "upgrade_additem");*/
	String p_auth = AuthTokenUtil.getToken(request);
	String actionFormUrl = SambaashUtil.getCommunityPath(groupId) +"/membershipsubscription?p_auth=" + p_auth + "&p_p_id=Spms_WAR_Spmsportlet&p_p_lifecycle=1&p_p_state=normal&p_p_mode=view&p_p_col_id=column1&p_p_col_pos=1&p_p_col_count=2&_Spms_WAR_Spmsportlet_struts_action=%2Fspms%2FaddItem&_Spms_WAR_Spmsportlet_CMD=upgrade_additem";

	try{

		MembershipPackage usrPack = MembershipPackageLocalServiceUtil.getMembershipPackage(mUserId);
		usrPrice = usrPack.getCost();
		mpValidity = usrPack.getCostPeriodType();

		if ((mpValidity != "") && (mpValidity.equalsIgnoreCase("weekly"))) {
		usrPrice = usrPrice * 56;
		}
		if ((mpValidity != "") && (mpValidity.equalsIgnoreCase("monthly"))) {
		usrPrice = usrPrice * 12;
		}
		if ((mpValidity != "") && (mpValidity.equalsIgnoreCase("yearly"))) {
			usrPrice = usrPrice;
			}
	}catch(Exception e){}
	%>

<%

//while (mpItrMsg.hasNext()) {

	//MembershipPackage mpDetailsMsg = (MembershipPackage)mpItrMsg.next();
//	promotionFrom = mpDetailsMsg.getPromotionFrom();
//	promotionTo = mpDetailsMsg.getPromotionTo();
//}

_log.info("request.getAttribute(mpPromotionCodeId) ::: "+request.getAttribute("mpPromotionCodeId"));
MembershipPackagePromotionCode mpPromotionCode = null;
try{
	long mpPromotionCodeId = Long.parseLong(String.valueOf(request.getAttribute("mpPromotionCodeId")));
	_log.info("PromotionCodeId ::: "+mpPromotionCodeId);
	mpPromotionCode = MembershipPackagePromotionCodeLocalServiceUtil.getMembershipPackagePromotionCode(mpPromotionCodeId);
	promotionFrom = mpPromotionCode.getPromotionFrom();
	promotionTo = mpPromotionCode.getPromotionTo();
}catch(Exception exe) {

}

if (promotionFrom==null || promotionTo==null) {
	promotionFrom = new Date();
	promotionTo = new Date();
}

String promotionPeriodDateMsg = "Promotion code is valid from "+DateFormat.getDateInstance(DateFormat.MEDIUM).format(promotionFrom)+" to "+DateFormat.getDateInstance(DateFormat.MEDIUM).format(promotionTo)+
													" UTC +8 (Asia/Singapore) Time";
if (promotionCode!=null) {
if (promotionCode.equalsIgnoreCase(isNotPromotionCode)) { %>
	<span class="portlet-msg-error">
		<liferay-ui:message key="Please enter a valid promotion code." />
</span>
<% } }
	if (promotionPeriod!=null) {
	if (promotionPeriod.equalsIgnoreCase(isNotPromotionPeriod)) { %>
	<span class="portlet-msg-error">
		<liferay-ui:message key="<%= promotionPeriodDateMsg %>" />
</span>
<% } }
	if (hasPromotionCode!=null) {
		if (hasPromotionCode.equalsIgnoreCase(has_PromotionCode)) { %>
		<span class="portlet-msg-error">
			<liferay-ui:message key="Promotion is not available for this membership package." />
	</span>

		<%
		}
	}
%>

	<form action="<%= actionFormUrl %>" method="post" name="<portlet:namespace/>fm">

	<%
	while (mpItr.hasNext()) {

		MembershipPackage mpDetails = (MembershipPackage)mpItr.next();
		mpName = mpDetails.getName();

		mpDescription = mpDetails.getDescription();
		mpId = mpDetails.getMpId();
		mpPrice = mpDetails.getCost();
		mpValidity = mpDetails.getCostPeriodType();
		mpCurrency = mpDetails.getCostCurrency();

		if ((mpValidity != "") && (mpValidity.equalsIgnoreCase("weekly"))) {
		yrPrice = mpPrice * 56;
		mpValid = "Week";
		}
		if ((mpValidity != "") && (mpValidity.equalsIgnoreCase("monthly"))) {
		yrPrice = mpPrice * 12;
		mpValid = "Month";
		}
		if ((mpValidity != "") && (mpValidity.equalsIgnoreCase("yearly"))) {
		yrPrice = mpPrice;
		mpValid = "Year";
		}
		if (mpId != mUserId) {
		if (yrPrice >= usrPrice) {
		 i++;
		 String membershipsubscription_promotionCode = "membershipsubscription_promotionCode_" + mpId;
		%>

		 <div id="registration_feature_wrap">
	  	<div id="registration_feature_left">
	  	  <h5><%= mpName %></h5>
	  	  <h5>(<%= mpCurrency%> &nbsp; <%= mpPrice %> / <%= mpValid %>)</h5>
	  	  <h5>&nbsp;</h5>
	  	  <h5><br />
	      </h5>
	  	</div>
		<div id="registration_feature_right">
		<div class="membershipupgrade_membership_description">
		  <p><%= mpDescription %></p>
		  </div>
		  <div>
		  	<span class="membershipupgrade_margin_right1"> Promotion Code </span>
		  	<input type="text" value="" name="<%= membershipsubscription_promotionCode %>" class="membershipupgrade_promotioncode_input" />
				<input name="<portlet:namespace />membershipsubscription_status" type="hidden" value="upgrade" />
			<span class="membershipupgrade_btn_1">
		  		&nbsp;&nbsp;<input type="button" value="More Details" onClick="javascript:call_moreDetails(<%= mpId %>)">
		  		&nbsp;&nbsp;<input type="submit" value="Upgrade">
		  </span>
		  <span id="input_member"></span>
				   <input type="hidden" name="<portlet:namespace />upgrade_memberyType" value="<%= mpId %>">

		  </div>
		</div>
	  </div>

	<% }
}
}

if (i == 0){ %>
<div class="message-info"> No membership package available for Upgrade </div>

<% } %>
</form>

	<script type="text/javascript">

	function call_moreDetails(recordId) {
var url="/html/registration/membership.jsp?&mpId=" + recordId;
newwindow=window.open(url,'popuppage','width=850,location=no,toolbar=0,resizable=1,scrollbars=yes,height=700,top=100,left=100');
	if (window.focus) {newwindow.focus();}
}

	function set_memberType(mpId) {
var ipt = document.createElement("input");
ipt.setAttribute("type","hidden");
ipt.setAttribute("name","upgrade_memberyType");
ipt.setAttribute("value",mpId);
var span_ipt = document.getElementById("input_member");
span_ipt.appendChild(ipt);
}
	</script>