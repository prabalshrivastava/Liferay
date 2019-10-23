<%@page import="com.sambaash.platform.sppayment.provider.PaymentProviderUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<portlet:resourceURL var="paymentURL">
	<portlet:param name="action" value="createPayment" />
    <portlet:param name="provider" value="stripe" />
	<portlet:param name="sp_p_auth" value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>

<div>
	<form action="<%=paymentURL%>" method="POST">
	  <input type="hidden" value="stripe" name="pay_provider" />
	  <input type="hidden" value="${pay_amount}" name="pay_amount" />
	  <input type="hidden" value="${pay_currency}" name="pay_currency" />
	  <input type="hidden" value="${pay_description}" name="pay_description" />
	  
	  <script
	    src="https://checkout.stripe.com/checkout.js" class="stripe-button"
	    data-key="<%= PaymentProviderUtil.getPublicKey(themeDisplay.getScopeGroupId(), "stripe") %>"
	    data-amount="${stripe_checkout_amount}"
	    data-currency="${pay_currency}"
	    data-name="${pay_site_name}"
	    data-description="${pay_description}"
	    data-image="${pay_logo}"
	    data-locale="${pay_locale}"
	    data-email="${pay_email}">
	  </script>
	</form>
</div>