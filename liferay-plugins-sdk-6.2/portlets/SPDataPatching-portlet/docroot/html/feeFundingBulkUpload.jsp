<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:actionURL var="bulkUploadFeeFunding" name="bulkUploadFeeFunding">
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

Bulk Uploading Fee & Fundings of various Courses (Product App) 
<aui:form name="fm" action="<%=bulkUploadFeeFunding%>" enctype="multipart/form-data">
		Upload the file and click submit. 	
			<aui:fieldset>
				<aui:input name="file"
								id="file" type="file"
								accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" />
	
				<aui:button type="Submit" value="Do It !!"></aui:button>
				
			</aui:fieldset>
</aui:form>
<div>
	${log }
</div>