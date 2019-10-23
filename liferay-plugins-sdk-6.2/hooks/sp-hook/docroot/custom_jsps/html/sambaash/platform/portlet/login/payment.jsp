<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<script type="text/javascript">
AUI().ready(function(A) {
	A.one("#paypalForm").submit();
});
</script>

<form method="post" action="${paypal.paypalGatewayURL}" id="paypalForm" name="paypalForm">
  <input name="<portlet:namespace />cmd" type="hidden" value="_xclick" />
  <input name="<portlet:namespace />business" type="hidden" value="${paypal.paypalId}" />
  <input name="<portlet:namespace />lc" type="hidden" value="${paypal.location}" />
  <input name="<portlet:namespace />item_name" type="hidden" value="${paypal.itemName}" />
  <input name="<portlet:namespace />item_number" type="hidden" value="${paypal.itemNumber}" />
  <input name="<portlet:namespace />amount" type="hidden" value="${paypal.total}" />
  <input name="<portlet:namespace />currency_code" type="hidden" value="${paypal.currencyCode}" />
  <input name="<portlet:namespace />button_subtype" type="hidden" value="${paypal.subType}" />
  <input name="<portlet:namespace />no_shipping" type="hidden" value="${paypal.shippingFlag}" />
  <input name="<portlet:namespace />quantity" type="hidden" value="${paypal.quantity}" />
  <input name="<portlet:namespace />rm" type="hidden" value="${paypal.returnMethod}" />
  <input name="<portlet:namespace />return" type="hidden" value="${paypal.returnURL}" />
  <input name="<portlet:namespace />cancel_return" type="hidden" value="${paypal.cancelURL}" />
  <input name="<portlet:namespace />tax_rate" type="hidden" value="${paypal.taxRate}" />
  <input name="<portlet:namespace />shipping" type="hidden" value="${paypal.shippingRate}" />
  <input name="<portlet:namespace />bn" type="hidden" value="${paypal.paypalButtonURL}" />
  <input name="<portlet:namespace />notify_url" type="hidden" value="${paypal.notificationURL}" />
  <input name="<portlet:namespace />custom" type="hidden" value="${paypal.emailAddress}" />
  <input type="image" src="${paypal.imgURL1}" name="<portlet:namespace />submit" alt="PayPal - The safer, easier way to pay online!">
  <img alt="PayPal Image" border="0" src="${paypal.imgURL2}" width="1" height="1" />
</form>
<div>Redirecting to Paypal... please wait...</div>
