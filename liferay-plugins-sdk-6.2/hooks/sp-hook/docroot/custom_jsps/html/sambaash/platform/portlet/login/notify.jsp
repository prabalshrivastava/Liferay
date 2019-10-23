<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
AUI().ready(function(A) {
	A.one("#paypalReturnURL").submit();
});
</script>
<form method="post" action="${return_url}" id="paypalReturnURL" name="paypalReturnURL">
	<input type="hidden" name="<portlet:namespace />action" value="${return_action}"/>
</form>
<div>Payment was successful. Redirecting to thank you page...</div>
