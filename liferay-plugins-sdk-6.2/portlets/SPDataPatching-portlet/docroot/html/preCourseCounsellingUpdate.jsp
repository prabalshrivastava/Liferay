<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:actionURL var="updatePreCourseCounselling" name="updatePreCourseCounselling">
</portlet:actionURL>
<b>
	Errors
</b><br/>

<%
	List<String>errors = (List<String>)request.getAttribute("errors");
    if(errors != null){
		for(String error: errors){
			out.println(error + "<br>");
		}
    	
    }

%>

<b>
	Messages
</b><br/>˙

<%
	List<String>msgs = (List<String>)request.getAttribute("msgs");
	if(msgs != null){
		for(String msg: msgs){
			out.println(msg + "<br>");
		}
		
	}

%>

Updating the Pre Course Counselling form of Applications
<aui:form name="fm" action="<%=updatePreCourseCounselling%>" enctype="multipart/form-data">
		 	
			<aui:fieldset>
		
				<aui:button type="Submit" value="Do It !!"></aui:button>
				
			</aui:fieldset>
</aui:form>
<div>
	${log }
</div>