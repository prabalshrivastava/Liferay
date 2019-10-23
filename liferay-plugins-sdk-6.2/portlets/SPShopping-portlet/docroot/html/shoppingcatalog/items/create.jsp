<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<portlet:defineObjects />
<liferay-portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
</liferay-portlet:resourceURL>

<div class="max-width">
	<div class="inline-block margin-top-one width-20"><%@ include
			file="/html/common/menu.jsp"%></div>
	<div class="inline-block width-75 align-top">
		<div class="full-width">
			<div class="font-up text-center h2">
				<liferay-ui:message key="label.create.product" />
			</div>
			<div
				class="form padding-left-three padding-right-three margin-top-one margin-bottom-one" id="form">
				<aui:form cssClass="createItemForm" name="createItemForm">
					<div class="form-row-one">
					<aui:input name="item_title" label="label.name">
						<aui:validator name="required" />
						<aui:validator name="maxLength">300</aui:validator>
					</aui:input>
					</div>
					<div class="form-row-one">
					<aui:input name="item_itemCode" label="label.item.code">
						<aui:validator name="maxLength">5</aui:validator>
						<aui:validator name="maxLength">20</aui:validator>
					</aui:input>
					</div>
					<div class="form-row-three">
						<aui:input name="price_currencyCode" cssClass="currencyCode" label="label.currency.code">
							<aui:validator name="maxLength">3</aui:validator>
							<aui:validator name="required" />
						</aui:input>
						
						<aui:input name="price_priceRefTypeId" type = "hidden" value="2" />
						
						<aui:input name="price_taxName" label="label.tax.type">
							<aui:validator name="maxLength">25</aui:validator>
						</aui:input>
						
						<aui:input name="price_taxValue" label="label.tax.value">
							<aui:validator name="maxLength">6</aui:validator>
							<aui:validator name="number"></aui:validator>
						</aui:input>
					</div>
					
					<div class="form-row-two">
						<aui:input name="price_basePrice" label="label.base.price">
							<aui:validator name="maxLength">10</aui:validator>
							<aui:validator name="required" />
							<aui:validator name="number" />
						</aui:input>
						
						<aui:input name="totalPrice" label="label.total.price"
							disabled="true">
						</aui:input>
						
						<aui:input name="price_totalPrice" label="label.total.price"
							type="hidden">
						</aui:input>
					</div>
					
					<aui:input name="item_shortDescription" type="textarea"
						label="label.short.desc" rows="3">
						<aui:validator name="maxLength">500</aui:validator>
					</aui:input>

					<aui:input name="item_longDescription" type="textarea"
						label="label.long.desc" rows="7">
						<aui:validator name="maxLength">5000</aui:validator>
					</aui:input>

					<div class="portlet-msg-error animate" style="display:none" id="errorMsg">
					</div>
					<div class="portlet-msg-success animate" style="display:none" id="successMsg">
						<liferay-ui:message key="successfully-created-item" />
					</div>

					<div class="text-center">
						<button type="button" class="submit">
							<liferay-ui:message key="label.submit" />
						</button>
						<button type="button" class="cancel" onclick="window.location.href=homeLocation" >
							<liferay-ui:message key="label.cancel" />
						</button>
					</div>
				</aui:form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	var namespace = '<portlet:namespace/>';
	var resourceURL = '<%=resourceURL%>';
	var item = {};
	var homeLocation = '/shopping/-/spshopping/items';
	var currencyCodesJSON = ${currencyCodes};
	initialize('create-item');
</script>
<!-- TODO.. 1. currency autocomplete, review validations, check if total price saved in db-->