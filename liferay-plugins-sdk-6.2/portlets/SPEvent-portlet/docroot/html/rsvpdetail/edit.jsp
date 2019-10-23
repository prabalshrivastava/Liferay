<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.model.Group" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="dynamicFields"></portlet:param>
</portlet:actionURL>

<form action="<%=editActionURL %>" method="post" >
<div style="padding:10px;border:1px solid #666666;width:96%;">
	<div style="width:100%;padding:10px;">
		<div style="width:20%;display:inline-block;color:#000000;font-weight:bold;"> Mobile Number Id</div>
		<div style="width:80%;display:inline;"><input type="text" name="<portlet:namespace />mobileNumberId" id="mobileNumberId" value="${mobileNumberId}"/></div>
	</div>
	<div style="width:100%;padding:10px;">
		<div style="width:20%;display:inline-block;color:#000000;font-weight:bold;">Registration UserInfo form name</div>
		<div style="width:80%;display:inline;"><input type="text" name="<portlet:namespace />pageName" id="pageName" value="${pageName}"/></div>
	</div>	
	<div style="width:100%;padding:10px;">
		<div style="width:20%;display:inline-block;color:#000000;font-weight:bold;">Page name of Co-Participants Detail</div>
		<div style="width:80%;display:inline;"><input type="text" name="<portlet:namespace />pageNameOfCoParticipantsDetail" id="pageNameOfCoParticipantsDetail" value="${pageNameOfCoParticipantsDetail}"/></div>
	</div>	
	<input type="submit" value="Save Changes"/>	
</div>		
</form>
