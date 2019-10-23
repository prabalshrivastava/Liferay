<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>

<liferay-theme:defineObjects />
<br/>
<br/>
<br/>
<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.no.permission.perform.operation")%>
