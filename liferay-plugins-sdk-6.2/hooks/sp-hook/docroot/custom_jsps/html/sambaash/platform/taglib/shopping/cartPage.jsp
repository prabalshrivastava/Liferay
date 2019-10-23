<%@page import="com.sambaash.platform.srv.spshopping.service.SPSellingPriceLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.spshopping.model.SPSellingPrice"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.sambaash.platform.srv.spshopping.service.SPSellingPackageLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.spshopping.model.SPPackageItems"%>
<%@page import="com.sambaash.platform.srv.spshopping.model.SPSellingPackage"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<liferay-portlet:resourceURL
	portletName="shoppingcart_WAR_SPShoppingportlet" var="cartResourceUrl">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</liferay-portlet:resourceURL>

<%
 String packageIds  = (String) request.getAttribute("sp-shopping:packageIds");
 Boolean expanded  = (Boolean) request.getAttribute("sp-shopping:expanded");
 Boolean updatable  = (Boolean) request.getAttribute("sp-shopping:updatable");
 String orderPage  = (String) request.getAttribute("sp-shopping:orderPage");
%>

<div>
	<aui:form>
		<aui:input name="packageIds" type="hidden" value="<%=packageIds%>"></aui:input>
		<aui:input name="updatable" type="hidden" value="<%=updatable%>"></aui:input>
		<aui:input name="expanded" type="hidden" value="<%=expanded%>"></aui:input>
		<aui:input name="orderPage" type="hidden" value="<%=orderPage%>"></aui:input>
	</aui:form>
</div>
<div class="package-row-left-title inline-block h3 strong">Shopping Cart</div>
<div class="inline-block package-row-right-title h5">Price</div>
<div class="shopping-package-container text-center" id="shopping-package-container">

	<div>
		<%
			String[] pkgIds = packageIds.split(",");
			for (String pkgId : pkgIds) {
				SPSellingPackage pkg = SPSellingPackageLocalServiceUtil
						.fetchSPSellingPackage(GetterUtil.getLong(pkgId));
				SPSellingPrice price = SPSellingPriceLocalServiceUtil.findPriceByPackageId(GetterUtil.getLong(pkgId));
				boolean hasPromoCode = SPSellingPackageLocalServiceUtil.hasPromoCode(pkg.getSpSellingPackageId());
		%>
			<div class="pkgId hidden"><%=pkg.getSpSellingPackageId() %></div>
			<%@ include file="/html/sambaash/platform/taglib/shopping/package-record.jsp" %>
		<%
			}
		%>
		<div class="cart-total">
			<div id="cart-discount" class="cart-discount inline-block">
				<span class="h3">Total</span>
			</div>
			<div class="price-box inline-block">
				<div id="cart-total-price">20</div>
			</div>
		</div>
	</div>
	<div class="portlet-msg-error animate" style="display:none" id="errorMsg">
		Error : 
	</div>
	<div class="portlet-msg-success animate" style="display:none" id="successMsg">
		
	</div>
</div>
<script type="text/javascript">
	var cart = {};
	var cartResourceUrl = '<%=cartResourceUrl%>';
	AUI().ready('aui-node', 'aui-base', 'aui-io-request-deprecated', function(A) {
		var obj = {};
		obj['action'] = 'validateCart';
		obj['packageIds'] = '<%=packageIds%>';
		obj['orderPage'] = '<%=orderPage%>';
		startPreLoader('shopping-package-container');
		A.io.request(cartResourceUrl, {
			dataType : 'json',
			method : 'POST',
			data : obj,
			on : {
				success : function() {
					stopPreLoader('shopping-package-container');
					if (this.get("responseData").status == 'success') {
						console.log('success');
						calculateCart();
					} else {
						try {
							console.log(this.get("responseData"));
							showFailedMessage(this.get("responseData"));
						} catch(ee){console.log(ee);}
					}
				},
				failure : function() {
					showFailedMessage('Error while validating the cart. Please contact administrator!');
					stopPreLoader('shopping-package-container');
				}
			}
		});
		
		var applyPromos = A.all(".applyPromo");
		var removePromos = A.all(".removePromo");
		var cancelPromoButtons = A.all(".cancelPromoButton");
		applyPromos.each(function(applyPromo) {
			applyPromo.on('click', function(e) {
				var parent = applyPromo.get('parentNode.parentNode');
				
				var promoIps =A.all(".promoButtonDiv");
				for(var i=0; i<promoIps.size(); i++){
					promoIps.toggleClass("hidden");
	            }
				
				var selIP = parent.one("#promoButtonDiv");
				selIP.removeClass("hidden");
				applyPromo.toggleClass("hidden");
				var removePromo = parent.one("#removePromo");
				removePromo.removeClass("hidden");
			});
		});
		
		removePromos.each(function(removePromo) {
			removePromo.on('click', function(e) {
				var parent = removePromo.get('parentNode.parentNode');
				
				var selIP = parent.one("#promoButtonDiv");
				selIP.addClass("hidden");
				removePromo.toggleClass("hidden");
				var applyPromo = parent.one("#applyPromo");
				applyPromo.removeClass("hidden");
			});
		});
		
		cancelPromoButtons.each(function(cancelPromoButton) {
			cancelPromoButton.on('click', function(e) {
				var parent = cancelPromoButton.get('parentNode.parentNode');
				
				var selIP = parent.one("#promoButtonDiv");
				selIP.addClass("hidden");
				var removePromo = parent.one("#removePromo");
				removePromo.toggleClass("hidden");
				var applyPromo = parent.one("#applyPromo");
				applyPromo.removeClass("hidden");
			});
		});
		
		
		var inps = A.all(".promoCodeInput");
		inps.each(function(inp) {
			inp.on('change', function(e) {
				var obj = {};
				obj.action = 'applyPromo';
				obj.cartPackageId = 1;
				obj.cartId = cart.spCartId;
				obj.couponCode = inp.val();
				startPreLoader('shopping-package-container');
				A.io.request(cartResourceUrl, {
					dataType : 'json',
					method : 'POST',
					data : obj,
					on : {
						success : function() {
							stopPreLoader('shopping-package-container');
							try {
								if (this.get("responseData").status == 'success') {
									console.log('success');
								} else {
									try {
										console.log(this.get("responseData").errorMsg);
										showFailedMessage(this.get("responseData").errorMsg);
									} catch(ee){}
								}
							} catch (e) {
							}
						},
						failure : function() {
							stopPreLoader('shopping-package-container');
							showFailedMessage('Error while applying promocode. Please contact administrator!');
						}
					}
				});
			});
		});
		
		function calculateCart() {
			startPreLoader('shopping-package-container');
			var obj = {};
			obj.action = "calculateCart";
			if (cart.cartId)
				obj.cartId = cart.cartId;
			obj.packageIds = '<%=packageIds%>';
			obj.orderPage = '<%=orderPage%>';
			A.io.request(cartResourceUrl, {
				dataType : 'json',
				method : 'POST',
				data : obj,
				on : {
					success : function() {
						stopPreLoader('shopping-package-container');
						try{
						  cart = JSON.parse(this.get("responseData").object);
						} catch (e) {
							showFailedMessage('Cart not initialized properly. Please contact administrator!');
						}
					}
				}
			});
		}
		
	});
	
	function showSuccessMessage(msg) {
		var successNode = document.getElementById("successMsg");
		successNode.style.display = "block";
		window.setTimeout(function() {
			successNode.innerHTML = msg;
			successNode.style.display = "none";
		}, 2000);
	}

	function showFailedMessage(msg) {
		var errorNode = document.getElementById("errorMsg");
		errorNode.innerHTML = msg;
		errorNode.style.display = "block";
	}
</script>