<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@ include file="init.jsp" %>

<%
PEOutput output =(PEOutput) request.getAttribute(PEConstants.ATTR_OUTPUT);
%>

<div class="ProgressTracker">
</div>
<script src="/SPProcessEngine-portlet/js/processstate/progressTracker.js?t=<%=DateUtil.newTime() %>">
</script>
	<script type="text/javascript">
	var steps = <%= output.getStatusTypes().toString() %>;
	console.log(steps);
	drawSteps(steps);
	</script>