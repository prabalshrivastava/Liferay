<%@ include file="/html/init.jsp"%>

<portlet:actionURL var="saveAssetPreferenceActionURL"
	windowState="normal" name="saveAssetPreference" />
	
<aui:form action='<%=saveAssetPreferenceActionURL%>'>
	
	<aui:button type="submit" value='<%=LanguageUtil.get(pageContext,"label.save") %>' onClick="submitForm();" />
</aui:form>
