<%@ include file="init.jsp" %>

<%@ page import="java.util.*" %>
<%@ page import="java.net.*" %>
<%@ page import="java.io.*" %>
<%@ page import="sambaash.platform.srv.membershipsubscription.model.MembershipSubscription" %>
<%@ page import="sambaash.platform.srv.membershipsubscription.service.MembershipSubscriptionLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil" %>

<center><h1>Notify.Jsp</h1></center>

<%
final String PAYMENT_STATUS_COMPLETED="Completed";
final String CHANGE_TO_STATUS = "Done";

	Log log = LogFactoryUtil.getLog("html.spms.notify.jsp");
log.info("Notify.Jsp ");
// read post from PayPal system and add 'cmd'

Enumeration en = request.getParameterNames();
String str = "cmd=_notify-validate";
while (en.hasMoreElements()) {
String paramName = (String)en.nextElement();
String paramValue = request.getParameter(paramName);

str = str + "&" + paramName + "=" + URLEncoder.encode(paramValue);
}
log.info("str after enumerated "+str);
// post back to PayPal system to validate
// NOTE: change http: to https: in the following URL to verify using SSL (for increased security).

// using HTTPS requires either Java 1.4 or greater, or Java Secure Socket Extension (JSSE)
// and configured for older versions.

URL u = new URL(paypalurl);

URLConnection uc = u.openConnection();
uc.setDoOutput(true);
uc.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
PrintWriter pw = new PrintWriter(uc.getOutputStream());

pw.println(str);
pw.close();
log.info("PrintWriter Close ");
BufferedReader in = new BufferedReader(
new InputStreamReader(uc.getInputStream()));
String res = in.readLine();
in.close();

// assign posted variables to local variables
log.info("Inputstreamreader close ");
String itemName = request.getParameter("item_name");				//sdPremiumpayuser1
String itemNumber = request.getParameter("item_number");		//12013 (roldId)
String paymentStatus = request.getParameter("payment_status");	//Completed
String paymentAmount = request.getParameter("mc_gross");			//1.07

String txnId = request.getParameter("txn_id");						//8CR568087K537651N
String receiverEmail = request.getParameter("receiver_email");//to PpReceiverEmail	sambaa_1272342149_biz%40sambaash.com
String payerEmail = request.getParameter("payer_email");//to BillingEmailAddress	yan.paing%40sambaash.com

String emailAddress = request.getParameter("custom");
String billingFirstName = request.getParameter("first_name");//to billingFirstName	yan
String billingLastName = request.getParameter("last_name");//to billingLastName	paing
String residence_country = request.getParameter("residence_country");//to ShippingCountry	US
String verify_sign = request.getParameter("verify_sign"); 				//ABMqJbTOsXN2K7Z.OIQY5bRBsXw1AwR9dVhTV7O7maJlAGRQhJsM8cf5
String business = request.getParameter("business"); 					//sambaa_1272342149_biz%40sambaash.com
String transaction_subject = request.getParameter("transaction_subject");//to MpName_2	sdPremiumpayuser1
String protection_eligibility = request.getParameter("protection_eligibility");				//Ineligible
String payer_id = request.getParameter("payer_id");					//7QFC24VF4HZEU
String shipping = request.getParameter("shipping");						//0.00
String mc_fee = request.getParameter("mc_fee");						//0.53
String txn_id = request.getParameter("txn_id");//to ppTxnId	8CR568087K537651N
String receiver_email = request.getParameter("receiver_email");	//sambaa_1272342149_biz%40sambaash.com
String quantity = request.getParameter("quantity");						//1
String notify_version = request.getParameter("notify_version");	//3.0
String txn_type = request.getParameter("txn_type");					//web_accept
String mc_currency = request.getParameter("mc_currency");//to CcName	SGD
String test_ipn = request.getParameter("test_ipn");						//1
String payer_status = request.getParameter("payer_status");//to ShippingState	unverified
String custom = request.getParameter("custom");						//for custom input field
String payment_date = request.getParameter("payment_date");	//22%3A58%3A47+Aug+18%2C+2010+PDT
String option_selection1 = request.getParameter("option_selection1");	//
String option_selection2 = request.getParameter("option_selection2");	//
String payment_fee = request.getParameter("payment_fee"); 		//
String option_name1 = request.getParameter("option_name2");	//sd
String option_name2 = request.getParameter("option_name3");	//+Premium%2C
String charset = request.getParameter("charset");						//windows-1252
String payment_gross = request.getParameter("payment_gross");	//
String receipt_id = request.getParameter("receipt_id");// to MpId_2	1500-7501-8777-7597
String handling_amount = request.getParameter("handling_amount");	//0.00
String tax = request.getParameter("tax");						//0.00
String payment_type = request.getParameter("payment_type");	//instant
String receiver_id = request.getParameter("receiver_id");				//SUKE5X2GA2XNY

if (payerEmail!=null) {
	payerEmail = payerEmail.replace("%40","@");
}

if (emailAddress!=null) {
	emailAddress = emailAddress.replace("%40","@");
}

if (receiver_email!=null) {
	receiver_email = receiver_email.replace("%40","@");
}

//check notification validation
if (res.equals("VERIFIED")) {
// check that paymentStatus=Completed
// check that txnId has not been previously processed
// check that receiverEmail is your Primary PayPal email

// check that paymentAmount/paymentCurrency are correct
// process payment
}
else if (res.equals("INVALID")) {
// log for investigation
}
else {
// error
}
log.info("paymentStatus : "+paymentStatus);
log.info("PAYMENT_STATUS_COMPLETED : "+PAYMENT_STATUS_COMPLETED);
log.info("paymentAmount : "+paymentAmount);
log.info("emailAddress : "+emailAddress);
log.info("if (paymentStatus !=null && paymentStatus.trim().equals(PAYMENT_STATUS_COMPLETED)) "+paymentStatus !=null && paymentStatus.trim().equals(PAYMENT_STATUS_COMPLETED));
log.info("Query : SELECT * from membershipSubscription where shippingEmailAddress= "+payerEmail+" nettotal= "+paymentAmount);
if (paymentStatus !=null && paymentStatus.trim().equals(PAYMENT_STATUS_COMPLETED)) {
float paymentAmountFloat = 0.0f;
	try{
	paymentAmountFloat = Float.parseFloat(paymentAmount.trim());
	}catch(Exception paymentException) {
		log.info("paymentException ::: "+paymentException.getMessage());
	}
		List<MembershipSubscription> msList = MembershipSubscriptionLocalServiceUtil.findByMembershipSubscriptionShippingEmailAddressAndNettotal(emailAddress,paymentAmountFloat);

		log.info("msLIst size : "+msList.size());
		Iterator<MembershipSubscription> msItr = msList.iterator();
		while (msItr.hasNext()) {
			MembershipSubscription ms = msItr.next();
			ms.setBillingFirstName(billingFirstName);
			ms.setBillingLastName(billingLastName);
			ms.setBillingEmailAddress(payerEmail);
			ms.setPpTxnId(txn_id);
			ms.setPpReceiverEmail(receiverEmail);
			ms.setCcName(mc_currency);
			ms.setShippingCountry(residence_country);
			ms.setMpName_2(transaction_subject);
			ms.setMpId_2(receipt_id);
			ms.setShippingState(payer_status);
			ms.setPpPaymentStatus(CHANGE_TO_STATUS);

			MembershipSubscriptionLocalServiceUtil.updateMembershipSubscription(ms);
		}
}
%>