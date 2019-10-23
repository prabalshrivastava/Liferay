<%@ include file="init.jsp" %>
<tiles:useAttribute classname="java.lang.String" id="tilesPortletContent" ignore="true" name="portlet_content" />

<div>
	<jsp:include flush="true" page='<%= "/html" + tilesPortletContent %>' />
</div>