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
<portlet:resourceURL var="refundURL">
	<portlet:param name="action" value="refund" />
    <portlet:param name="provider" value="stripe" />
	<portlet:param name="sp_p_auth" value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>

<label>Refund</label>
<div>
	<form action="<%=refundURL%>" method="POST">
<%-- 	  <input type="hidden" value="${charge_ref_code}" name="charge_ref_code" /> --%>
<%-- 	  <input type="hidden" value="${pay_amount}" name="pay_amount" /> --%>
<%-- 	  <input type="hidden" value="${pay_currency}" name="pay_currency" /> --%>
<%-- 	  <input type="hidden" value="${pay_description}" name="pay_description" /> --%>
<input type="hidden" value="stripe" name="pay_provider" />
	  <aui:input name="charge_ref_code" label="Charge Reference ID" value="${charge_ref_code}" readonly="true">
		<aui:validator name="mandatory"></aui:validator>
	  </aui:input>
	  <aui:input name="pay_refund_amount" label="Refund Amount">
		<aui:validator name="number"></aui:validator>
	  </aui:input>
	  <aui:button-row>
		<aui:button name="refundButton" type="submit" value="Refund" />
	  </aui:button-row>
	</form>
	
</div>