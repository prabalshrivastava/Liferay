<%@ include file="init.jsp" %>

<%@ page import="sambaash.platform.srv.membershippackage.model.MembershipPackage" %>
<%@ page import="sambaash.platform.srv.membershippackage.service.MembershipPackageLocalServiceUtil" %>

<%@ page import= "sambaash.platform.srv.servicecomponent.model.ServiceComponents" %>
<%@ page import= "sambaash.platform.srv.servicecomponent.service.ServiceComponentsLocalServiceUtil" %>

<%@ page import="sambaash.platform.srv.membershippackage.service.MembershipPackageService" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil" %>

<%@ page import="java.util.*" %>
<%@ page import="com.liferay.portal.NoSuchOrganizationException" %>
<%@ page import="com.liferay.portal.NoSuchPasswordPolicyException" %>
<%@ page import="com.liferay.portal.RequiredPasswordPolicyException" %>
<%@ page import="com.liferay.portal.kernel.cache.MultiVMPoolUtil" %>

<%@ page import="java.text.DecimalFormat" %>

<%!
private static Log _log = LogFactoryUtil.getLog("html.spms.membershipsubscription_form.jsp");
%>

<%
String memberId = (String)request.getAttribute("mpId");
String cmd = (String)request.getAttribute("cmd");
_log.info("memberId and cmd from form "+memberId + "     " + cmd);

actionURL.setParameter("struts_action", "/login/create_account");
actionURL.setParameter("saveLastPath", "0");

actionURL.setParameter("struts_action", "/spms/membershipsubscription_action");
actionURL.setParameter("CMD", "process");

if (!roleId1) {
%>


<%@ page import="sambaash.platform.srv.membershippackage.model.MembershipPackagePromotionCode" %>
<%@ page import="sambaash.platform.srv.membershippackage.service.MembershipPackagePromotionCodeLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.CompanyLocalServiceUtil" %><style type="text/css">

#child-navigation {
display:none;
}

</style>

<% } %>

<script type="text/javascript">

var existingServiceComponent=new Array();
var split1="&&&&&";
var split2="***";
var globalCountForServiceComponent=0;
var rowIdSC = "serviceComponentNewRow";
var isDuplicate=false;
var subTotal1 = 0.00;
var subTotal2 = 0.00;
var total = 0.00;
var qty = 1;
var price = 0.00;
var tax = <%= taxFactor %>;

var mpAddonId = "mpAddonId";
var scName = "scName";
var scId = "scId";
var paramFrom = "paramFrom";
var paramUpto = "paramUpto";
var paramType = "paramType";
var serviceChargesCurrency = "serviceChargesCurrency";
var serviceCharges = "serviceCharges";
var serviceChargesPeriodType = "serviceChargesPeriodType";
var serviceCheckBox="serviceCheckBox";

var tableId1 = "dataTable";

function prepareData(_data) {
	var incomingData = _data.split(split1);
	for (i=1;i<incomingData.length;i++) {
		var rowData =incomingData[i].split(split2);
		for (j=0;j<existingServiceComponent.length;j++) {
			if (rowData[0]==existingServiceComponent[j]) {
					isDuplicate=true;
			}
		}
		if (!isDuplicate) {
			serviceComponentAddRow(tableId1,rowData);
			existingServiceComponent.push(rowData[0]);
		}
		isDuplicate=false;
	}
}

function serviceComponentAddRow(tableID,rowData) {

	var table = document.getElementById(tableID);
	var row = table.insertRow(1);
	var serviceComponentRowId = rowIdSC+globalCountForServiceComponent;
	row.id= serviceComponentRowId;

	var element2;
	element2 = document.createElement("input");
	element2.type = "checkbox";
	element2.setAttribute("name",serviceCheckBox+globalCountForServiceComponent);
	element2.setAttribute("value",serviceComponentRowId);
	element2.setAttribute("onClick","removeService(this,'"+rowData[0]+"','"+rowData[6]+"')");

	var cell2 = row.insertCell(0);
	var element3;
	element3 = document.createElement("input");
	element3.type = "hidden";
	element3.setAttribute("name",scName+globalCountForServiceComponent);
	element3.setAttribute("value",rowData[1]);

	elementScId = document.createElement("input");
	elementScId.type = "hidden";
	elementScId.setAttribute("name",scId+globalCountForServiceComponent);
	elementScId.setAttribute("value",rowData[8]);

	var elementdiv=document.createElement("span");
	elementdiv.setAttribute("class", "ms_form_servicecomponent_addrow");
	var element4 = document.createTextNode(rowData[1]);
	elementdiv.appendChild(element4);

	var element1;
	element1 = document.createElement("input");
	element1.type = "hidden";
	element1.setAttribute("name",mpAddonId+globalCountForServiceComponent);
	element1.setAttribute("size",5);
	element1.setAttribute("value",rowData[0]);
	cell2.appendChild(elementScId);
	cell2.appendChild(element1);
	cell2.appendChild(element2);
	cell2.appendChild(element3);
	cell2.appendChild(elementdiv);

	var cell3 = row.insertCell(1);
	var elementdiv2=document.createElement("span");
	elementdiv2.setAttribute("class", "ms_form_servicecomponent_addrow_cell");
	var element5 = document.createTextNode(rowData[2]);
	elementdiv2.appendChild(element5);
	elementInput2 = document.createElement("input");
	elementInput2.type = "hidden";
	elementInput2.setAttribute("name",paramFrom+globalCountForServiceComponent);
	elementInput2.setAttribute("size",5);
	elementInput2.setAttribute("value",rowData[2]);
	cell3.appendChild(elementInput2);
	cell3.appendChild(elementdiv2);

	var cell4 = row.insertCell(2);
	var elementdiv3=document.createElement("span");
	elementdiv3.setAttribute("class", "ms_form_servicecomponent_addrow_cell");
	var element6 = document.createTextNode(rowData[3]);
	elementdiv3.appendChild(element6);
	elementInput1 = document.createElement("input");
	elementInput1.type = "hidden";
	elementInput1.setAttribute("name",paramUpto+globalCountForServiceComponent);
	elementInput1.setAttribute("size",5);
	elementInput1.setAttribute("value",rowData[3]);
	cell4.appendChild(elementInput1);
	cell4.appendChild(elementdiv3);

	var cell5 = row.insertCell(3);
	var elementdiv4=document.createElement("span");
	elementdiv4.setAttribute("class", "ms_form_servicecomponent_addrow_cell");
	var element7 = document.createTextNode(rowData[4]);
	elementdiv4.appendChild(element7);
	elementInput3 = document.createElement("input");
	elementInput3.type = "hidden";
	elementInput3.setAttribute("name",paramType+globalCountForServiceComponent);
	elementInput3.setAttribute("size",5);
	elementInput3.setAttribute("value",rowData[4]);
	cell5.appendChild(elementInput3);
	cell5.appendChild(elementdiv4);

	var cell8 = row.insertCell(4);
	var elementdiv7=document.createElement("span");
	elementdiv7.setAttribute("class", "ms_form_servicecomponent_addrow_cell");
	var element10 = document.createTextNode(rowData[7]);
	elementdiv7.appendChild(element10);

	elementInput6 = document.createElement("input");
	elementInput6.type = "hidden";
	elementInput6.setAttribute("name",serviceChargesPeriodType+globalCountForServiceComponent);
	elementInput6.setAttribute("size",5);
	elementInput6.setAttribute("value",rowData[7]);
	cell8.appendChild(elementInput6);
	cell8.appendChild(elementdiv7);

	var cell6 = row.insertCell(5);
	var elementdiv5=document.createElement("span");
	elementdiv5.setAttribute("class", "ms_form_servicecomponent_addrow_cell");
	var element8 = document.createTextNode(rowData[5]);
	elementdiv5.appendChild(element8);
	elementInput4 = document.createElement("input");
	elementInput4.type = "hidden";
	elementInput4.setAttribute("name",serviceChargesCurrency+globalCountForServiceComponent);
	elementInput4.setAttribute("size",5);
	elementInput4.setAttribute("value",rowData[5]);
	cell6.appendChild(elementInput4);
	cell6.appendChild(elementdiv5);

	var cell7 = row.insertCell(6);
	var elementdiv6=document.createElement("span");
	elementdiv6.setAttribute("class", "ms_form_servicecomponent_addrow_cell");
	var element9 = document.createTextNode(rowData[6]);
	elementdiv6.appendChild(element9);
	elementInput5 = document.createElement("input");
	elementInput5.type = "hidden";
	elementInput5.setAttribute("name",serviceCharges+globalCountForServiceComponent);
	elementInput5.setAttribute("size",5);
	elementInput5.setAttribute("value",rowData[6]);
	cell7.appendChild(elementInput5);
	cell7.appendChild(elementdiv6);

	reCalculateTotal(rowData[6],"ADD","scChange");

	globalCountForServiceComponent++;

}

function ChangeSubTotal1Text() {

var subTotal1Text = document.getElementById("subTotal1Text");
subTotal1Text.firstChild.nodeValue="Sub Total : "+subTotal1.toFixed(2);
}

function ChangeSubTotal2Text() {
	var subTotal2Text = document.getElementById("subTotal2Text");
	//subTotal2Text.firstChild.nodeValue ="Sub Total : "+ subTotal2.toFixed(2);
	subTotal2Text.firstChild.nodeValue = "" + subTotal2.toFixed(2);
}

function ChangeTotalText() {
	var totalText = document.getElementById("totalText");
	//totalText.firstChild.nodeValue ="Net Total : "+ total.toFixed(2);
	totalText.firstChild.nodeValue = "" + total.toFixed(2);
}

function reCalculateTotal(data,addOrSub,position) {
	var netAmt= parseFloat(data)+(parseFloat(data)*(tax/100));
	if (addOrSub=="qtyChange") {
		var tempSubTotal1 = parseFloat(subTotal1)-(parseFloat(subTotal1)*(tax/100));
		total = parseFloat(total) - parseFloat(tempSubTotal1);
		subTotal1 = data;
		tempSubTotal1 = parseFloat(subTotal1)-(parseFloat(subTotal1)*(tax/100));
		total = parseFloat(total) + parseFloat(tempSubTotal1);
		ChangeSubTotal1Text();
		ChangeTotalText();
	}else {

		if (addOrSub=="ADD") {
			if (position=="subscription") {
				subTotal1= parseFloat(subTotal1)+ parseFloat(data);
				total = parseFloat(total) + parseFloat(netAmt);

				document.getElementById("subscriptionTotal").value=subTotal1.toFixed(3);
				document.getElementById("total").value=total.toFixed(2);

				ChangeSubTotal1Text();
				ChangeTotalText();

			}else if (position=="scChange") {
				subTotal2 = parseFloat(subTotal2)+ parseFloat(data);
				total = parseFloat(total) + parseFloat(netAmt);
				document.getElementById("scSubTotal").value=subTotal2.toFixed(3);
				document.getElementById("total").value=total.toFixed(2);

				ChangeSubTotal2Text();
				ChangeTotalText();
			}
		}else if (addOrSub=="SUB") {
			if (position=="subscription") {
				subTotal1= parseFloat(subTotal1)- parseFloat(data);
				total = parseFloat(total) - parseFloat(netAmt);
				document.getElementById("subscriptionTotal").value=subTotal1.toFixed(3);
				document.getElementById("total").value=total.toFixed(2);

				ChangeSubTotal1Text();
				ChangeTotalText();

			}else if (position=="scChange") {
				subTotal2 = parseFloat(subTotal2)- parseFloat(data);
				total = parseFloat(total) - parseFloat(netAmt);
				document.getElementById("scSubTotal").value=subTotal2.toFixed(3);
				document.getElementById("total").value=total.toFixed(2);

				ChangeSubTotal2Text();
				ChangeTotalText();
			}
		}
	}
}

function removeService(_this,rowData,removeData) {
	if (_this.checked) {

		jConfirm('Are you sure to remove this?', 'Confirmation!', function(r) {

		    removeRowService(r,_this,rowData,removeData);
		});

	}
}

function removeRowService(r,_this,rowData,removeData) {

	if (r) {
		var temp = _this.value;
		removeRow(temp);
		var indexForRemoveData;
		for (i=0;i<existingServiceComponent.length;i++) {
			if (existingServiceComponent[i]==rowData) {
				indexForRemoveData=i;
			}
		}

		existingServiceComponent.splice(indexForRemoveData, 1);
		reCalculateTotal(removeData, "SUB", "scChange");
	}else {

		_this.checked=false;
	}
}

function removeRow(id) {
	  var tr = document.getElementById(id);
	  if (tr) {
	    if (tr.nodeName == 'TR') {
	      var tbl = tr;
	      while (tbl != document && tbl.nodeName != 'TABLE') {
	        tbl = tbl.parentNode;
	      }

	      if (tbl && tbl.nodeName == 'TABLE') {
	        while (tr.hasChildNodes()) {
	          tr.removeChild( tr.lastChild );
	        }
	      tr.parentNode.removeChild( tr );
	      }
	    } else {
	      alert( 'Specified document element is not a TR. id=' + id );
	    }
	  } else {
	    alert( 'Specified document element is not found. id=' + id );
	  }
}

function addQutality(qtyFromInput) {
	qty = qtyFromInput;
	var tempData = qty*price;
	reCalculateTotal(tempData,"qtyChange","");
}

function checknroute(_form) {

	if (total > 0)
	{

	return true;
	}
	else
	{

		document.forms["createAccountForm"].submit();
		return false;
	}
}
</script>

<%
	actionURL.setParameter("struts_action", "/spms/membershipsubscription_action");
	actionURL.setParameter("CMD", "process");

	MembershipPackage mp=null;
	String memberTypeId = request.getParameter("memberType");
	if (memberTypeId==null || memberTypeId.trim().equals("")) {
			   memberTypeId=(String)request.getAttribute("memberType");
	}
	boolean withPromotionCode = false;
	String memberType="testMemberType";
	long mpId = 99999;
	String extra1 = "";
	String costCurrency ="SGD";
	float cost = 0.0f;
	float originalCost = 0.0f;
	String firstName = "";
	String lastName="";
	String emailAdr="";
	String usrType="";

	String discount = "";
	String promotionCode = request.getParameter("_58_promotion_code");;
	if (promotionCode==null || promotionCode.trim().equals("")) {
		promotionCode = (String)request.getAttribute("_58_promotion_code");
	}
	try {

		mp = MembershipPackageLocalServiceUtil.getMembershipPackage(Long.parseLong(memberTypeId));

		memberType = mp.getName();
		extra1 = mp.getExtra1();

		List<MembershipPackagePromotionCode> mpPromotionCodeList = MembershipPackagePromotionCodeLocalServiceUtil.findBymembershipPackage_Id(Long.parseLong(memberTypeId));
		Iterator<MembershipPackagePromotionCode> mpPromotionCodeItr = mpPromotionCodeList.iterator();
		getDiscountLoop :
		while (mpPromotionCodeItr.hasNext()) {

			MembershipPackagePromotionCode mpPromotionCode = mpPromotionCodeItr.next();

			if (promotionCode.equals(mpPromotionCode.getPromotionCode())) {
				discount = mpPromotionCode.getDiscount();
				break getDiscountLoop;
			}
		}

		_log.info("*** discount *** "+discount);
}catch (Exception e) {
	_log.error(e);
}
session = request.getSession(false);
_log.info("Session Id is : "+session.getId());

String p_p_auth = AuthTokenUtil.getToken(request);
String p_auth = AuthTokenUtil.getToken(request);

_log.info("p_p_auth : "+p_p_auth);
_log.info("p_auth : "+p_auth);

createAccountTriUrl+="&p_auth="+p_auth+"&p_p_auth="+p_p_auth;
createAccountFormurl+="&p_auth="+p_auth+"&p_p_auth="+p_p_auth;
createAccountErrUrl+="&p_auth="+p_auth+"&p_p_auth="+p_p_auth;
_log.info("createAccountTriUrl : "+createAccountTriUrl);

if ((cmd != null) && (cmd.equals("upgrade_additem"))) {

	MembershipPackage mpDetails = MembershipPackageLocalServiceUtil.getMembershipPackage(Long.parseLong(memberId));
	//UserProfileBasic mpack = UserProfileBasicLocalServiceUtil.getUserProfileBasic(userID);
	SocialProfile mpack = SocialProfileLocalServiceUtil.getSocialProfile(userID);
	if (mpDetails != null) {
		mpId = mpDetails.getMpId();
		costCurrency = mpDetails.getCostCurrency();
		originalCost = cost = mpDetails.getCost();
		memberType = mpDetails.getName();
		extra1 = mpDetails.getExtra1();
		firstName = user.getFirstName();
		lastName = user.getLastName();
		//emailAdr = mpack.getEmailAddress();
		emailAdr = user.getEmailAddress();
		usrType = mpack.getUserType();
		cancleBtnLocation = SambaashUtil.getCommunityPath(groupId) + "/membershipupgrade?p_p_id=Spms_WAR_Spmsportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_Spms_WAR_Spmsportlet_struts_action=/spms/upgrade&CMD=upgrade";
		upgradeFormurl = upgradeFormurl + "&userId=" + userID + "&upgrade_member=true" + "&mpId=" + memberId;
		createAccountTriUrl = upgradeFormurl;
		_log.info("createAccountTriUrl for upgrade: "+createAccountTriUrl);
	}

	//Yan add promotion code for discount
	if (!promotionCode.trim().equals("")) {
		try{
			_log.info("discount "+discount);
			float floatDiscount = Float.parseFloat(discount);

			cost = cost - (cost* (floatDiscount/100));
			withPromotionCode = true;
		}catch(NumberFormatException nfe) {
			_log.info("no discount : ");
		}
	}
	//End Yan
}
else {
	_log.info("CreateACCOUNT :::: ");
	String corporateName = (String)MultiVMPoolUtil.get("corporateName", "corporate" + request.getRequestedSessionId());
				if (mp!=null) {
					mpId = mp.getMpId();
					costCurrency = mp.getCostCurrency();
					originalCost = cost = mp.getCost();

					//Yan add promotion code for discount
					if (promotionCode!=null) {
						if (!promotionCode.trim().equals("")) {
							try{
								float floatDiscount = Float.parseFloat(discount);
								cost = cost - (cost* (floatDiscount/100));
								withPromotionCode = true;
							}catch(NumberFormatException nfe) {
								_log.info("no discount : ");
							}
						}
					}
					//End Yan
					firstName = request.getParameter("_58_firstName");
					lastName = request.getParameter("_58_lastName");
					emailAdr = request.getParameter("_58_emailAddress");
					usrType = request.getParameter("userType");
					if (corporateName!=null) {
						usrType="Corporate";
					}else {
						usrType = request.getParameter("userType");
					}
				}
}

String compnayName = CompanyLocalServiceUtil.getCompany(_themeDisplay.getCompanyId()).getName();
%>

<div id="mptable"><%= compnayName %> Membership Subscription</div>

<!-- <form name="_58_fm" method="post" class="uni-form" action="formUrl">
-->
<form action="<%= actionURL %>" id="fm" method="POST" name="<portlet:namespace/>fm" onsubmit="return checknroute(this);">

<input name="<portlet:namespace />cmd" type="hidden" value="add" />
<% if ((cmd != null) && (cmd.equals("upgrade_additem"))){ %>
<input name="<portlet:namespace />upgrade_memberyType" type="hidden" value="<%= memberId %>"></input>
<input name="<portlet:namespace />upgrade_memberPack" type="hidden" value="true"></input>
<% } %>

	<table class="taglib-search-iterator" width="90%">
		<tr class="portlet-section-body results-row">
			<td width="30%">First Name</td>
				<td><%= firstName %>

				<input name="<portlet:namespace />save" type="hidden" value="<%= request.getParameter("save") %>" />
				<input name="<portlet:namespace />authen_p_p" type="hidden" value="<%= p_p_auth %>" />
				<input name="<portlet:namespace />authen_p" type="hidden" value="<%= p_auth %>" />
				<input name="<portlet:namespace />_58_firstName" type="hidden" value="<%= firstName %>" />
				<input name="<portlet:namespace />terms" type="hidden" value="<%= request.getParameter("terms") %>" />
				<input name="<portlet:namespace />memberType" type="hidden" value="<%= request.getParameter("memberType") %>" />
				<input name="<portlet:namespace />_58_birthdayDay" type="hidden" value="<%= request.getParameter("_58_birthdayDay") %>" />
				<input name="<portlet:namespace />_58_birthdayMonth" type="hidden" value="<%= request.getParameter("_58_birthdayMonth") %>" />
				<input name="<portlet:namespace />_58_emailAddress" type="hidden" value="<%= emailAdr %>" />
				<input name="<portlet:namespace />userType" type="hidden" value="<%= usrType %>" />
				<input name="<portlet:namespace />_58_lastName" type="hidden" value="<%= lastName %>" />
				<input name="<portlet:namespace />_58_password1" type="hidden" value="<%= request.getParameter("_58_password1") %>" />
				<input name="<portlet:namespace />_58_birthdayYear" type="hidden" value="<%= request.getParameter("_58_birthdayYear") %>" />
				<input name="<portlet:namespace />_58_openId" type="hidden" value="<%= request.getParameter("_58_openId") %>" />
				<input name="<portlet:namespace />_58_cmd" type="hidden" value="<%= request.getParameter("_58_cmd") %>" />
				<input name="<portlet:namespace />membershipsubscription_status" type="hidden" value="<%= request.getParameter("membershipsubscription_status") %>" />
				<input name="<portlet:namespace />_58_promotion_code" type="hidden" value="<%= promotionCode %>" />
				<!-- YS - C&O Codes to store passed in Corporate Name info from User Registration -->
				<input name="<portlet:namespace />claimFlow" type="hidden" value="<%= request.getParameter("claimFlow") %>" />
				<%if ((request.getParameter("claimFlow") != null) && (request.getParameter("claimFlow").equals("claimFlow"))){ %>
				<input name="<portlet:namespace />corporateName" type="hidden" value="<%= request.getParameter("corporateNames") %>" />
				<input name="<portlet:namespace />corporateId" type="hidden" value="<%= request.getParameter("corporateId") %>" />
				<%}else { %>
				<input name="<portlet:namespace />corporateName" type="hidden" value="<%= request.getParameter("corporateName") %>" />
				<%} %>
				<!-- YS - END -->
			</td>

		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>Last Name</td>
			<td><%= lastName %></td>
		</tr>
		</tr>
		<tr class="portlet-section-body results-row">
			<td>Email Address</td>
			<td><%= emailAdr %></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td>User Type</td>
			<td><%= usrType %></td>
		</tr>
		<%if ("Corporate".equalsIgnoreCase((String)request.getParameter("userType"))){ %>
			<tr class="portlet-section-body results-row alt">
				<td>Corporate Name</td>
				<td><%= request.getParameter("corporateName") %></td>
		<%} %>
		</table>
		<br></br>

		<table class="taglib-search-iterator" width="90%">
		<tr class="portlet-section-header results-header">

		<%
			if (memberType.length()<10) {
		%>

			<td style="width:120px"><b><span style="padding-left: 120px;"> Item</span></b></td>
			<% }else { %>
			<td style="width:90px"><b><span style="padding-left: 90px;"> Item</span></b></td>
			<% } %>
			<td align="center" style="width:150px"><b>Quantity</b></td>
			<td align="center" style="width:120px"><b>Currency</b></td>
			<td align="center" style="width:10px"><b>Price</b></td>
		</tr>
		<tr class="portlet-section-body results-row alt">
			<td width="30%"><%

if (memberType.trim().equalsIgnoreCase("") || memberType==null) {
	 %> MP Name
	<input name="<portlet:namespace/>mpName_1" type="hidden" value="<%= memberType %>" />
				<input name="<portlet:namespace/>mpExtra1_1" type="hidden" value="<%= extra1 %>" />
				<input name="<portlet:namespace/>mpOrder_1" type="hidden" value="MPOrder" />
				<input name="<portlet:namespace/>mpId_1" type="hidden" value="<%= mpId %>" />

	<%
}else {
%>

		<%
			if (memberType.length()<10) {
		%>

				<b><span style="padding-left: 120px;"><%= memberType %></span></b>
			<% }else { %>
				<b><span style="padding-left: 80px;"><%= memberType %></span></b>
			<% } %>
<% }
			%>

			<script type="text/javascript">
				price = <%= cost %>;
			</script>
			<input name="<portlet:namespace/>mpName_1" type="hidden" value="<%= memberType %>" />
				<input name="<portlet:namespace/>mpExtra1_1" type="hidden" value="<%= extra1 %>" />
				<input name="<portlet:namespace/>mpOrder_1" type="hidden" value="MPOrder" />
				<input name="<portlet:namespace/>mpId_1" type="hidden" value="<%= mpId %>" />
			</td>
			<td align="center"><%= 1 %>
				<input class="ms_form_servicecomponent_detail_info" name="<portlet:namespace/>mpQty_1" onblur="addQutality(this.value)" type="hidden" value="1" />
			</td>
			<td align="center"><%= costCurrency %>
				<input class="ms_form_servicecomponent_detail_info" name="<portlet:namespace/>mpPriceCurrency_1" readonly="readonly" type="hidden" value="<%= costCurrency %>" />
			</td>
			<td align="center">

			<%
				DecimalFormat df1 = new DecimalFormat("####.00");

			if (cost > 0 || withPromotionCode) {
			%>

			<%= df1.format(originalCost) %>

			 <%}else {
			 String dcost = "0.00"; %>
			<%= dcost %>
			<%} %>
				<input class="ms_form_servicecomponent_detail_info" name="<portlet:namespace/>mpPrice_1" type="hidden" value="<%= cost %>"  />
			</td>
		</tr>
	</table>
	<br />
	<table id="subtotal1Table" width="100%">
		<tr>
			<td>
			<input class="ms_form_servicecomponent_detail_info" id="subscriptionTotal" name="<portlet:namespace />addOnSubTotal" readonly="readonly"  type="hidden" value="0.0" />
			<input class="ms_form_servicecomponent_detail_info" id="scSubTotal" name="<portlet:namespace />mpSubtotal" readonly="readonly" type="hidden" value="0.0" />
			<input class="ms_form_servicecomponent_detail_info" id="total" name="<portlet:namespace />netTotal" readonly="readonly" type="hidden" value="0.0" />
			<input name="<portlet:namespace />_58_sessionId" type="hidden" value="<%= session.getId() %>" />
			<table id="totalTable" width="97%">
			<% if (promotionCode!=null && (!promotionCode.trim().equals(""))) { %>
			<tr>
				<td align="right">
			  		<b>
						Promotional Discount : <%= discount %>.00%

				 	</b>
					</td>
				</tr>
				<% } %>
			<tr>
				<td align="right">
					<b> <b id="subTotal1Text">
						Sub Total : 0.00
					</b>
					 </b>
				</td>
			</tr>
			</table>
			</td>
		</tr>
	</table>
	<br></br>
	<input type="button" name="<portlet:namespace />Add Additional add on Service"
	onClick="window.open('<%= mppopup %>','popuppage','width=850,location=no,toolbar=1,resizable=1,scrollbars=yes,height=700,top=100,left=100');" value="Add Additional Services" style="margin-bottom:5px">
	<br />

	<table class="taglib-search-iterator" id="dataTable" width="90%">
		<tr class="portlet-section-header results-header">
			<td style="width:220px"><b><span style="padding-left: 45px;"> Service Components</span></b></td>
			<td align="center" style="width:10px"><b>Param From</b></td>
			<td align="center" style="width:10px"><b>Param Upto</b></td>
			<td align="center" style="width:10px"><b>Param Type</b></td>
			<td align="center" style="width:10px"><b>Validity</b></td>
			<td align="center" style="width:10px"><b>Currency</b></td>
			<td align="center" style="width:10px"><b>Service Charges</b></td>
		</tr>
		</table>
		<br></br>
	<table align="right" id="totalTable" style="margin-bottom:10px;" width="128">
		<tr>
			<td align="right" width="60%">
			  	<b>
					Sub Total :&nbsp;
				</b>
			</td>
			<td align="left" width="40%">
			  	<b id="subTotal2Text">
					0.00
				</b>
			</td>
		</tr>
		<tr>
			<td align="right" width="60%">
				<b>Tax :&nbsp;
				</b>
				 <input type="hidden" name="<portlet:namespace />tax" value="<%= taxFactor %>" />
			</td>
			<td align="left" width="40%">
			  	<b>
					<%= taxFactor %>0&nbsp;%
				</b>
			</td>
		</tr>
		<tr>
			<td align="right" width="60%">
				<b>
					Net Total :&nbsp;
				</b>
			</td>
			<td align="left" width="40%">
			  	<b id="totalText">
					00.00
				</b>
			</td>
		</tr>
	</table>
	<br></br>
	<br></br>
	<script type="text/javascript">
						reCalculateTotal(<%= cost %>,'ADD','subscription');
	</script>
	<table width="100%">
		<tr align="right">

			<%

			//<td><input type="button" value="Cancel" onClick="location.href='<%= renderURL.toString() '"></td>
			%>

			<td align="right"><input type="submit" value="Submit"> &nbsp;<input type="button" value="Cancel" onClick="location.href='<%= cancleBtnLocation %>'"></td>
		</tr>
	</table>
</form>

<form action="<%= createAccountTriUrl %>" class="uni-form" method="post" name="createAccountForm">
<% if ((cmd != null) && (cmd.equals("upgrade_additem"))){ %>
<input name="<portlet:namespace />upgrade_memberyType" type="hidden" value="<%= memberId %>"></input>
<input name="<portlet:namespace />upgrade_memberPack" type="hidden" value="true"></input>
<input name="<portlet:namespace />upgrade_member" type="hidden" value="true" />
<% } %>

				<input name="<portlet:namespace />triOrPay" type="hidden" value="triUser" />
				<input name="<portlet:namespace />_58_sessionId" type="hidden" value="<%= session.getId() %>" />
				<input name="<portlet:namespace />openId" type="hidden" value="<%= request.getParameter("_58_openId") %>" />
				<input name="<portlet:namespace/>mpName_1" type="hidden" value="<%= memberType %>" />
				<input name="<portlet:namespace/>mpExtra1_1" type="hidden" value="<%= extra1 %>" />
				<input name="<portlet:namespace/>mpOrder_1" type="hidden" value="MpOrder" />
				<input name="<portlet:namespace/>mpId_1" type="hidden" value="<%= mpId %>" />

				<input name="<portlet:namespace />save" type="hidden" value="<%= request.getParameter("save") %>" />
				<input name="<portlet:namespace />_58_firstName" type="hidden" value="<%= firstName %>" />
				<input name="<portlet:namespace/>58_firstName" type="hidden" value="<%= firstName %>" />
				<input name="<portlet:namespace />terms" type="hidden" value="<%= request.getParameter("terms") %>" />
				<input name="<portlet:namespace />memberType" type="hidden" value="<%= request.getParameter("memberType") %>" />
				<input name="<portlet:namespace />_58_birthdayDay" type="hidden" value="<%= request.getParameter("_58_birthdayDay") %>" />
				<input name="<portlet:namespace />_58_birthdayMonth" type="hidden" value="<%= request.getParameter("_58_birthdayMonth") %>" />
				<input name="<portlet:namespace />_58_emailAddress" type="hidden" value="<%= emailAdr %>" />
				<input name="<portlet:namespace/>58_emailAddress" type="hidden" value="<%= emailAdr %>" />
				<input name="<portlet:namespace />userType" type="hidden" value="<%= request.getParameter("userType") %>" />
				<input name="<portlet:namespace />_58_lastName" type="hidden" value="<%= lastName %>" />
				<input name="<portlet:namespace/>58_lastName" type="hidden" value="<%= lastName %>" />
				<input name="<portlet:namespace />_58_password1" type="hidden" value="<%= request.getParameter("_58_password1") %>" />
				<input name="<portlet:namespace/>58_password1" type="hidden" value="<%= request.getParameter("_58_password1") %>" />
				<input name="<portlet:namespace />_58_birthdayYear" type="hidden" value="<%= request.getParameter("_58_birthdayYear") %>" />
				<input name="<portlet:namespace/>58_promotion_code" type="hidden" value="<%= promotionCode %>" />
				<input name="<portlet:namespace />_58_openId" type="hidden" value="<%= request.getParameter("_58_openId") %>" />
				<input name="<portlet:namespace />_58_cmd" type="hidden" value="<%= request.getParameter("_58_cmd") %>" />
				<input name="<portlet:namespace />upgrade_member" type="hidden" value="noPay" />

				<!-- YS - C&O Codes to store passed in Corporate Name info from User Registration -->
				<input name="<portlet:namespace />corporateName" type="hidden" value="<%= request.getParameter("corporateName") %>" />
				<!-- YS - END -->
</form>