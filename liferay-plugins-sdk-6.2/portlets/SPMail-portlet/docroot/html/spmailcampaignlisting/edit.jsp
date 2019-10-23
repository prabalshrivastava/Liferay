<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="editListingPreference"></portlet:param>
</portlet:actionURL>

<form action="<%= editActionURL %>" method="post">
<div style="padding:10px;border:1px solid #666666;width:96%;">
	<div style="width:100%;padding:10px;">
		<div style="width:20%;display:inline-block;color:#000000;font-weight:bold;"> Enable Reminder1 Template</div>
		<div style="width:80%;display:inline;"><input type="checkbox" name="<portlet:namespace />chkEnableRem1" id="chkEnableRem1" <c:if test="${chkEnableRem1 == 'on'}"><c:out value="checked=\"checked\""></c:out></c:if>/></div>
	</div>

	<div style="width:100%;padding:10px;">
		<div style="width:20%;display:inline-block;color:#000000;font-weight:bold;"> Enable Reminder2 Template</div>
		<div style="width:80%;display:inline;"><input type="checkbox" name="<portlet:namespace />chkEnableRem2" id="chkEnableRem2" <c:if test="${chkEnableRem2 == 'on'}"><c:out value="checked=\"checked\""></c:out></c:if>/></div>
	</div>

	<div style="width:100%;padding:10px;">
		<div style="width:20%;display:inline-block;color:#000000;font-weight:bold;"> Enable Reminder3 Template</div>
		<div style="width:80%;display:inline;"><input type="checkbox" name="<portlet:namespace />chkEnableRem3" id="chkEnableRem3" <c:if test="${chkEnableRem3 == 'on'}"><c:out value="checked=\"checked\""></c:out></c:if>/></div>
	</div>

	<div style="width:100%;padding:10px;">
		<div style="width:20%;display:inline-block;color:#000000;font-weight:bold;"> Enable Thank You Template</div>
		<div style="width:80%;display:inline;"><input type="checkbox" name="<portlet:namespace />chkEnableThankYou" id="chkEnableThankYou" <c:if test="${chkEnableThankYou == 'on'}"><c:out value="checked=\"checked\""></c:out></c:if>/></div>
	</div>

	<div style="width:100%;padding:10px;">
		<div style="width:20%;display:inline-block;color:#000000;font-weight:bold;"> Enable Miss You Template</div>
		<div style="width:80%;display:inline;"><input type="checkbox" name="<portlet:namespace />chkEnableMissYou" id="chkEnableMissYou" <c:if test="${chkEnableMissYou == 'on'}"><c:out value="checked=\"checked\""></c:out></c:if>/></div>
	</div>

	<div style="width:100%;padding:10px;">
		<div style="width:20%;display:inline-block;color:#000000;font-weight:bold;"> SPMailCampaign Create Page Name</div>
		<div style="width:80%;display:inline;"><input type="text" name="<portlet:namespace />createPageName" id="createPageName" value="${createPageName}" /></div>
	</div>
	
	<div style="width:100%;padding:10px;">
		<div style="width:20%;display:inline-block;color:#000000;font-weight:bold;"> Favourite Create Page Name</div>
		<div style="width:80%;display:inline;"><input type="text" name="<portlet:namespace />favCreatePageName" id="favCreatePageName" value="${favCreatePageName}" /></div>
	</div>

	<input type="submit" value="Save Changes" />
</div>
</form>