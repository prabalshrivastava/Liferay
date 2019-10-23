<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${socialBookmarksDisplayStyle == 'false'}">
	<liferay-ui:social-bookmarks
		displayStyle="${socialBookmarksDisplayPosition}"
		target="_blank"
		title="${title}"
		url="${bookmarkUrl}"
	/>
</c:if>