<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>


<c:if test="${!empty scheduleDetail}">
<c:forEach var="scheduleDetail" items="${scheduleDetail}">
<script>
addScheduleInstances();
</script>
</c:forEach>
</c:if>
<c:if test="${empty scheduleDetail}">
<script>
addScheduleInstances();
</script>
</c:if>

