<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<portlet:defineObjects />

<!-- TODO fix UI -->
<div class="max-width full-width">
	<div>
		<liferay-ui:message key="label.error.msg" />
	</div>
	<div>${errorMsg}</div>
</div>

