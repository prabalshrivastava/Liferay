<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@ include file="init.jsp" %>

<portlet:resourceURL id="approveReject" var="ajaxUrl">
</portlet:resourceURL>
<div id="approveRejectmsg">
</div>
<div class="btn-div">
<aui:button id="approve" name="approve"  value="approve.button.text"></aui:button>
<aui:button id="reject" name="reject"  value="reject.button.text"></aui:button>
</div>

<script src="/SPProcessEngine-portlet/js/processstate/approveReject.js?t=<%=DateUtil.newTime() %>">
</script>

<script>
var A;
var pns ="<portlet:namespace/>";
AUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated',function(A1) {
	A = A1;
	var ajaxUrl = "<%= ajaxUrl %>";
	var obj = new approveReject({pns:pns, ajaxUrl:ajaxUrl});
});
</script>