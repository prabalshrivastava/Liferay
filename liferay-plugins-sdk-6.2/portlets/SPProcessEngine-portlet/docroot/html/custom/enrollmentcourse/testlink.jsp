<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.sambaash.platform.srv.model.Course"%>
<%@page import="com.sambaash.platform.srv.service.CourseLocalServiceUtil"%>
<%@ page import="com.sambaash.platform.srv.model.Product" %>
<%@ page import="com.sambaash.platform.srv.processbuilder.model.PEProcessState" %>
<%@ page import="com.sambaash.platform.srv.service.ProductLocalServiceUtil" %>

<%@ include file="/html/init.jsp" %>

<%
PEOutput output =(PEOutput) request.getAttribute(PEConstants.ATTR_OUTPUT);
PEProcessState processState = output.getProcessState();
Product product = null;
String testLink = StringPool.BLANK;
try{
	   product = ProductLocalServiceUtil.getProduct(processState.getEntityId());
	   Course course = CourseLocalServiceUtil.getCourse(product.getSpCourseId());
	   testLink = course.getTestLink();
}catch(Exception ex) {
	_log.error(ex.getMessage());
}

// completed stuff
if(output.isFromAudit()){
%>

<div class="msg"> The entrance test has been completed</div>

<%	
}else if (Validator.isNull(product)) {
	  out.write("OOps. Error occured. Please contact support team");
}else if(Validator.isNotNull(testLink)){
%>
<div class="msg">
	<span> Please share this <a href="<%= testLink %>" target="_blank">Entrance Test Link</a> to the learner </span>
</div>

<%
}else{

%>
	<div class="msg">The Test Link is not defined for this course. Please contact Product team</div>
<%
}
%>

<%!
private static Log _log = LogFactoryUtil.getLog("html.custom.enrollmentcourse.testlink_jsp");
%> 