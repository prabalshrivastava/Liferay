<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ include file="/html/common/init-ext.jsp" %>
<portlet:defineObjects/>

<liferay-theme:defineObjects/>

<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="editPreferences"></portlet:param>
</portlet:actionURL>

<form action="<%= editActionURL %>" id="fm1" method="post" name="fm1">
	<div style="width:100%;padding:10px;">
		<div class="rsvp-preference-label">Create RSVP Ticket Page</div>
		<div style="width:70%;display:inline;margin-bottom:5px;"><input type="text" name="<portlet:namespace />pageName" id="pageName" value="${pageName}" style="width:220px;" required="required"/></div>
	</div>
	<div>
		<input type="submit" value="Save" />
	</div>

</form>
