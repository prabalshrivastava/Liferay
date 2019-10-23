<%@page import="com.sambaash.platform.srv.model.CourseEnrollEsignInfo"%>
<%@ include file="/html/init.jsp" %>
<%
	 CourseEnrollEsignInfo info = (CourseEnrollEsignInfo)request.getAttribute("esignInfo");
	 
%>
<div class="enrollmentContainer screen-max-width " id="mainContainer">
	<div class="enrollmentRow margin-top-40 roundedborder">	 
		<c:if test="<%= info !=null %>">
			<iframe src="<%= info.getLastGeneratedUrl()%>" width='100%' onload="stopPreLoader('mainContainer')" height="850px">
		      
		      </iframe>
		</c:if>
		<c:if test="<%= info==null %>">
		   Could not find Contract info.
		</c:if>
	</div>
</div>
