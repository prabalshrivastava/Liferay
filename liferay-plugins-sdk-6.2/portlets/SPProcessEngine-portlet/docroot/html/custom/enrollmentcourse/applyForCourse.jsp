<%@page import="com.sambaash.platform.pe.course.enroll.CourseEnrollEsignEngine"%>
<%@page import="com.sambaash.platform.pe.PEDataSource"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.sambaash.platform.srv.model.Course"%>
<%@page import="com.sambaash.platform.srv.service.CourseLocalServiceUtil"%>
<%@ page import="com.sambaash.platform.srv.model.Product" %>
<%@ page import="com.sambaash.platform.srv.processbuilder.model.PEProcessState" %>
<%@ page import="com.sambaash.platform.srv.service.ProductLocalServiceUtil" %>

<%@ include file="/html/init.jsp" %>

<%
   //PEDataSource dataSource = (PEDataSource)request.getAttribute(PEConstants.ATTR_DATA_SOURCE);
PEOutput output =(PEOutput) renderRequest.getAttribute(PEConstants.ATTR_OUTPUT);

%>