<%@page import="com.sambaash.platform.srv.spshopping.service.SPDiscountLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.spshopping.model.SPDiscount"%>
<%@page import="com.sambaash.platform.srv.spshopping.model.SPSellingPrice"%>
<%@page import="com.sambaash.platform.srv.spshopping.service.SPSellingPriceLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.sambaash.platform.srv.spshopping.model.SPSellingPackage"%>
<%@page import="java.util.List"%>
<%@page import="com.sambaash.platform.srv.spshopping.service.SPSellingPackageLocalServiceUtil"%>
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
				<liferay-ui:message key="label.create.discount" />
			</div>
			<div
				class="form padding-left-three padding-right-three margin-top-one margin-bottom-one" id="form">
				<aui:form cssClass="createDiscountForm" name="createDiscountForm">
					<div class="form-row-one">
						<aui:select name="discount_packageId" cssClass="full-width" label="select-package-to-configure-discounts">
							<%
								List<SPSellingPackage> list = SPSellingPackageLocalServiceUtil.getSPSellingPackages(-1, -1);
								for(SPSellingPackage pkg : list) {
									String label = pkg.getTitle();
									if (Validator.isNotNull(pkg.getPkgCode()))
										label = label + " (" + pkg.getPkgCode() + ") ";
									SPSellingPrice price = null;
									try {
										price = SPSellingPriceLocalServiceUtil.findPriceByPackageId(pkg.getSpSellingPackageId());
									} catch (Exception e) {
										continue;
									}
									label = label + "  -  " + price.getTotalPrice() + price.getCurrencyCode(); 
							%>
									<option value="<%= pkg.getSpSellingPackageId() %>" label="<%=label%>" ></option>
							<% } %>
						</aui:select>
					</div>
					
					<div class="form-row-one margin-bottom-half">
						<div class="h4 discount-title hidden"><liferay-ui:message key="existing-discount-configurations" /></div>
						<div class="sample-disc-row hidden" id="sample-disc-row">
							<div class="inline-block disc-title"></div>
							<div class="inline-block disc-dates"></div>
							<div class="inline-block disc-quantities"></div>
							<div class="inline-block disc-couponcodes"></div>
							<div class="inline-block disc-value"></div>
						</div>
						<div class="discount-list">
						</div>
					</div>
					
					<div class="form-row-one">
						<aui:input name="discount_title" label="label.name">
							<aui:validator name="required" />
							<aui:validator name="maxLength">300</aui:validator>
						</aui:input>
					</div>
					
					<div class="form-row-one">
						<aui:input name="discount_shortDescription" type="textarea"
						label="label.short.desc" rows="3">
							<aui:validator name="maxLength">500</aui:validator>
						</aui:input>
					</div>
					
					<div class="form-row-two">
						<aui:input name="discount_startDate" label="label.start.date" >
							<aui:validator name="date"></aui:validator>
						</aui:input>
						<aui:input name="discount_endDate" label="label.end.date">
							<aui:validator name="date"></aui:validator>
						</aui:input>
					</div>
					
					<div class="form-row-two">
						<aui:input name="discount_minQuantity" label="label.min.quantity" >
							<aui:validator name="number"></aui:validator>
							<aui:validator name="min">1</aui:validator>
						</aui:input>
						<aui:input name="discount_maxQuantity" label="label.max.quantity">
							<aui:validator name="number"></aui:validator>
							<aui:validator name="date">1</aui:validator>
						</aui:input>
					</div>
					
					<div class="form-row-two">
						<aui:input name="discount_hasPromoCode" type="checkbox" label="label.need.coupon" >
						</aui:input>
						<aui:input name="discount_percent" type="checkbox" label="label.is.percent" >
						</aui:input>
					</div>
					
					<div class="form-row-one hidden">
						<aui:input name="discount_couponCode" label="label.coupon.code">
						</aui:input>
					</div>
					
					<div class="form-row-one">
						<aui:input name="discount_value" label="discount-value">
						 	<aui:validator name="number"></aui:validator>
							<aui:validator name="min">1</aui:validator>
              				<aui:validator name="max">100</aui:validator>
						</aui:input>
					</div>
					
					<div class="portlet-msg-error animate" style="display:none" id="errorMsg">
					</div>
					<div class="portlet-msg-success animate" style="display:none" id="successMsg">
						<liferay-ui:message key="successfully-created-discount" />
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
	var discount = {};
	var homeLocation = '/shopping/-/spshopping/discounts';
	var currencyCodesJSON = null; 
	initialize('create-discounts');
</script>