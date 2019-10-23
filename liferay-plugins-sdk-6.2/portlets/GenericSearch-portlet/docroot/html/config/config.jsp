
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>

<style>
.cta-links {
	text-align: right;
	height: 16px;
}
.portlet-configuration.generic-search-portlet .archived-setups {
    margin-bottom: 0px;
    margin-right: 1.5em;
}
</style>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationURL" />

<aui:form action="<%=configurationURL%>" method="post" name="fm" 
	cssClass="margin-left-half margin-right-one">
	<div class="cta-links">
		<aui:button-row cssClass="inline-block">
			<aui:button type="submit" />
		</aui:button-row>
		<aui:button-row cssClass="inline-block">
			<aui:button type="cancel" />
		</aui:button-row>
	</div>
	<aui:input name="<%=Constants.CMD%>" type="hidden"
		value="<%=Constants.UPDATE%>" cssClass="margin-bottom-half" />
	<liferay-ui:tabs names="Components,Filters,Results,Exports,Favourites" refresh="false"
		tabsValues="Components,Filters,Results,Exports,Favourites">
		<liferay-ui:section>
			<%@ include file="/html/config/components.jsp"%>
		</liferay-ui:section>
		<liferay-ui:section>
			<%@ include file="/html/config/filters.jsp"%>
		</liferay-ui:section>
		<liferay-ui:section>
			<%@ include file="/html/config/results.jsp"%>
		</liferay-ui:section>
		<liferay-ui:section>
			<%@ include file="/html/config/exports.jsp"%>
		</liferay-ui:section>
		<liferay-ui:section>
			<%@ include file="/html/config/favourites.jsp"%>
		</liferay-ui:section>
	</liferay-ui:tabs>
</aui:form>

<aui:script
	use="aui-node,aui-base,aui-io-request-deprecated,liferay-util-window,aui-io-plugin-deprecated">
	var form = A.one('#<portlet:namespace/>fm');
	form.on('submit', function(event) {
		event.halt();
		if (!validate(A)) {
			return false;
		}
		this.submit();
	});
	
	function validate(A) {
		return validateFilters(A); //check filters.jsp
	}
</aui:script>