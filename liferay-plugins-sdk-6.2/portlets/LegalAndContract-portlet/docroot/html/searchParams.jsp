<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<portlet:actionURL var="searchActionURL" name="search">
</portlet:actionURL>
<aui:form name="search" action="<%=searchActionURL%>">
<%

	Map<String,String>requestMap = SambaashUtil.getParameterMap(renderRequest);
	String input = "<input type='hidden' name='%s' value='%s' />";
	for(String key :requestMap.keySet()){
		 if(key.startsWith("searchParam_")){
			 String temp = renderResponse.getNamespace() + key.substring("searchParam_".length());
			 out.write(String.format(input, temp, requestMap.get(key)));
		 }
	}
	
	 String temp = renderResponse.getNamespace() + "fromPage";
	out.write(String.format(input, temp, "search"));
	
%>
</aui:form>
<script>
var portletNs = "<portlet:namespace/>";
try{
	cancelHandler(portletNs);
}catch(error){
	
}
function cancelHandler(){
	try{
		AUI().use('aui-node','aui-base', 'aui-io-request-deprecated', function (A){
			A.one("#cancel").on('click',function(){
				var searcForm  = document.getElementById(portletNs + "search");
				searcForm.submit();
			});
		});
		
	}catch(error){
		
	}

}
</script>