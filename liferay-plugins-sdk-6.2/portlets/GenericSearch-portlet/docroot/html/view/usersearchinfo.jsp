<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page import="com.sambaash.platform.genericsearch.GenericSearchConstants"%>
<%@page import="com.sambaash.platform.genericsearch.helper.GSUserProfileHelper.GSUserPESearchResponse"%>
<portlet:defineObjects />
<%
GSUserPESearchResponse usrSearchResponse = (GSUserPESearchResponse) renderRequest.getAttribute(GenericSearchConstants.ATTRIB_USER_SEARCH_RESPONSE);
%>
<div id="usrsearchinfo">
<%
  if(usrSearchResponse != null){
%>
	<input type="hidden" value="<%=usrSearchResponse.getStartIndex() %>" id ="usrStartIndex" />
	<input type="hidden" value="<%=usrSearchResponse.getProcessesdUserIds() %>" id ="processesdUserIds" />
<%
  }
%>	
</div>