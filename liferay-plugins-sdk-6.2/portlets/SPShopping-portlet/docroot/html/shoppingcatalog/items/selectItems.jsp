<%@page import="java.util.Set"%>
<%@page import="com.sambaash.platform.spshopping.SPShoppingConstants"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="com.sambaash.platform.srv.spshopping.model.SPSellingItem"%>
<%@page import="com.sambaash.platform.srv.spshopping.service.SPSellingItemLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<liferay-portlet:renderURL var="portletURL" />

<div class="max-width">
	<aui:form name="selectItemsForPackage">
		<%
			List<String> selectedItemsList = Arrays.asList(GetterUtil.getString(portletPreferences.getValue("selectedItems", "")).split(","));
			Map<String, String> dataMap = (Map<String, String>) renderRequest.getAttribute(SPShoppingConstants.ATTRIB_ALL_ITEM_MAP);
			List<SPSellingItem> items = SPSellingItemLocalServiceUtil.getSPSellingItems(-1, -1);
			Set<Map.Entry<String, String>> entrySet = dataMap.entrySet();
			for (Map.Entry<String, String> entry: entrySet) {
				%>
					<div class="item-row">
						<aui:input name="selectedItem" type="checkbox"
							value="<%=entry.getKey()%>" label="<%=entry.getValue()%>"
							checked="<%=selectedItemsList.contains(entry.getKey())%>"></aui:input>
					</div>
				<%
			}
		%>
		<div class="portlet-msg-error animate" style="display: none"
			id="errorMsg"></div>
		<div class="portlet-msg-success animate" style="display: none"
			id="successMsg">
			<liferay-ui:message key="successfully-saved-preferences" />
		</div>
		<button  type="button" id="selItems_okButton">OK</button>
		<button  type="button" id="selItems_cancelButton">Cancel</button>
	</aui:form>
</div>