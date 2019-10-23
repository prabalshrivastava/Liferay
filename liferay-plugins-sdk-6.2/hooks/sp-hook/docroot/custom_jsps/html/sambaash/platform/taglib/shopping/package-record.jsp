<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<div class="package-row">
	<div class="package-row-left inline-block">
	<div class="inline-block packageTitle strong"><%=pkg.getTitle()%></div>
	<% if(Validator.isNotNull(pkg.getPkgCode())) { %>
		<div class="inline-block">(<%=pkg.getPkgCode()%>)</div>
	<% } %>
	<span class="taglib-icon-help">
		<img alt="Package description help" onblur="Liferay.Portal.ToolTip.hide();" onfocus="Liferay.Portal.ToolTip.show(this);" onmouseover="Liferay.Portal.ToolTip.show(this);" src="/Menarini-theme/images/portlet/help.png">
		<span class="hide-accessible tooltip-text" id="pack-tooltip">Package description help text</span>
	</span>
	<% //if (hasPromoCode) { %>
		<div id="promoCode">
			<div>
				<div id="applyPromo" class="applyPromo"><a href="#">Apply Promo</a></div>
				<div id="removePromo" class="removePromo hidden"><a href="#">Remove Promo</a></div>
			</div>
			<div id="promoButtonDiv" class="promoButtonDiv hidden">
				<input class="promoCodeInput"/><br/>
				<div class="cancelPromoButton inline-block"><a href="#"><liferay-ui:message key="Cancel" /></a></div>
			</div>
		</div>
	<% //} %>
	</div>
	<div class="price-box inline-block package-row-right">
		<div class="total-price"><%=price.getTotalPrice()%></div>
		<% //if (Validator.isNotNull(price.getTaxName())) { %>
			<%-- <div> ( includes <%=price.getTaxValue()%> % <%=price.getTaxName()%>)</div> --%>
			<div> Tax value</div>
		<% //} %>
	</div>
	
	<div class="hide">
		<div class="short-desc">
			<%=pkg.getShortDescription()%>
		</div>
		<div class="full-desc">
			<%=pkg.getLongDescription()%>
		</div>
	</div>
</div>
