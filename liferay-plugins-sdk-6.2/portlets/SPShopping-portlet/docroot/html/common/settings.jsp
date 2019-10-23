<%@page import="com.sambaash.platform.srv.spshopping.model.SPTax"%>
<%@page import="java.util.List"%>
<%@page import="com.sambaash.platform.srv.spshopping.service.SPTaxLocalServiceUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<portlet:defineObjects />
<liferay-portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</liferay-portlet:resourceURL>

<div class="max-width">
	<div class="inline-block margin-top-one width-15"><%@ include
			file="/html/common/menu.jsp"%></div>
	<div class="inline-block width-80 align-top">
		<div class="font-up text-center h2">
				<liferay-ui:message key="label.settings" />
		</div>
		<div class="form padding-left-three padding-right-three margin-top-one margin-bottom-one">
			<span class="h3"><liferay-ui:message key="label.tax.settings" /></span>

			<div class="taxes-list">
				<%
					List<SPTax> list = SPTaxLocalServiceUtil.getSPTaxs(-1, -1);
					for (SPTax tax : list) {
				%>
				<div class="inline-block"><%=tax.getCurrencyCode()%></div>
				<div class="inline-block"><%=tax.getTaxName()%></div>
				<div class="inline-block"><%=tax.getTaxValue()%></div>
				<%
					}
				%>
			</div>

			<div class="addTax">
				<aui:form cssClass="form addTaxForm"  name="addTaxForm">
					<div class="form-row-three">
						<aui:input name="tax_currencyCode" label="label.currency.code" cssClass="currencyCode" id="currencyCode">
							<aui:validator name="maxLength">3</aui:validator>
							<aui:validator name="required" />
						</aui:input>
						<aui:input name="tax_taxName" label="label.tax.type" id="taxName">
							<aui:validator name="required" />
						</aui:input>
						<aui:input name="tax_taxValue" label= "label.tax.value" id="taxValue">
							<aui:validator name="required" />
							<aui:validator name="number" />
							<aui:validator name="min">0</aui:validator>
						</aui:input>
					</div>
					<div class="portlet-msg-error animate" style="display:none" id="errorMsg">
						<liferay-ui:message key="failed-to-created-item" />
					</div>
					<div class="portlet-msg-success animate" style="display:none" id="successMsg">
						<liferay-ui:message key="successfully-created-item" />
					</div>
					<button class="submit" type="button">
						<liferay-ui:message key="label.add.tax" />
					</button>
				</aui:form>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	var namespace = '<portlet:namespace/>';
	var resourceURL = '<%=resourceURL%>';
	var tax = {};
	var homeLocation = '/shopping/-/spshopping/settings';
	var currencyCodesJSON = ${currencyCodes};
	initialize('settings');
</script>