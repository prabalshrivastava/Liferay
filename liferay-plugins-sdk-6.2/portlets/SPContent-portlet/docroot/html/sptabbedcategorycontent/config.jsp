<%@ include file="/html/sptabbedcategorycontent/init.jsp"%>
<%@page import="com.liferay.portal.kernel.portlet.DefaultConfigurationAction"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>


<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationURL" />
	
<aui:form action="<%=configurationURL%>" method="post" name="fm" 
	cssClass="margin-left-half margin-right-one">
	<aui:input name="<%=Constants.CMD%>" type="hidden"
		value="<%=Constants.UPDATE%>" cssClass="margin-bottom-half" />

<%
	String tabConfigName = ActionUtil.generatePreferenceName(Constant.TAB_CONFIGURATION);
	String tabConfig = ActionUtil.getPreferenceValue(portletPreferences, Constant.TAB_CONFIGURATION, "");

	if(tabConfig==null || "".equals(tabConfig)) {
		// display example config
        tabConfig="{\n" +
		"	'tabs' : [\n" +
		"		{ \n" +
		"		   'title': 'Tab Title',\n" +
		"		   'vocabulary': 'vocabulary-name',\n" +
		"		   'category': 'category-name',\n" +
		"		   'type': 'Journal | Blog | Event | User | Challenge'\n" +
		"		},\n" +
		"	]\n" +
		"}	";
	}

%>
	
	<%@ include file="/html/sptabbedcategorycontent/config-lov.jspf"%>
	
	<aui:row>
		<aui:col span="12">
			<aui:input name="<%=tabConfigName%>"
			label="<%=Constant.TAB_CONFIGURATION%>" type="textarea" rows="20"
			required="true" value="<%=tabConfig%>" style="width:65%;" />
		</aui:col>	
	</aui:row>

	<aui:button-row>
		<aui:button type="submit" cssClass="btn btn-primary"/>
		<aui:button type="cancel" cssClass="btn btn-cancel"/>
	</aui:button-row>
</aui:form>
