<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<label>${charge_ref_code}</label>

<c:if test="${charge_ref_code != null}">
</c:if>

<c:choose>
    <c:when test="${charge_ref_code != null}">
		<%@ include file="/html/provider/stripe/refund.jsp" %>
    </c:when>    
    <c:otherwise>
    	<c:if test="${refund_ref_code != null}">
    		<label>Refund successful with reference code: ${refund_ref_code}</label>
    	</c:if>
		<%@ include file="/html/spcartpayment/cartCheckout.jspf" %>
		<%@ include file="/html/provider/stripe/checkout.jsp" %>
    </c:otherwise>
</c:choose>