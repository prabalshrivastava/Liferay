<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ taglib uri="/tld/sp-ui" prefix="sp-ui" %>

<%@ page import="com.sambaash.platform.srv.model.SPAssetEntry" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

This is the <b>Voting</b> portlet.

<sp-ui:voting className="<%= SPAssetEntry.class.getName() %>" classPK="108" />