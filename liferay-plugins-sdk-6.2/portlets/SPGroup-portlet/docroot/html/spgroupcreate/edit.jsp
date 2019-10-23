<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="edit_preferences"></portlet:param>
</portlet:actionURL>

<portlet:resourceURL var="resourceUrl" >
	<portlet:param name="reindex" value="all"/>
</portlet:resourceURL>

<%
String spGroupImageMaxSize = portletPreferences.getValue("spGroupImageMaxSize", "307200");
String spGroupImageExtensions = portletPreferences.getValue("spGroupImageExtensions", ".gif,.jpeg,.jpg,.png");
String groupDetailPageName = portletPreferences.getValue("groupDetailPageName", "group-detail");
%>

<h1>Configurations</h1>

<aui:form action="<%= editActionURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault();" %>'>
	<aui:fieldset>
		<aui:input label="Group Image Max Size" name="spGroupImageMaxSize" value="<%= spGroupImageMaxSize %>" />
		<aui:input label="Group Image Extensions" name="spGroupImageExtensions" value="<%= spGroupImageExtensions %>" />
		<aui:input label="Name of Group Detail Page" name="groupDetailPageName" value="<%= groupDetailPageName %>" />
		<aui:button name="saveButton" onClick='<%= renderResponse.getNamespace() + "saveConfigurations();" %>' type="submit" value='<%= LanguageUtil.get(pageContext,"label.save") %>' />
	</aui:fieldset>
</aui:form>

	<aui:button-row>
		<aui:button name="reindexButton" onClick="callServeResource();" type="submit" value="Reindex" />
	</aui:button-row>

<aui:script>

	Liferay.provide(
		window,
		'<portlet:namespace />saveConfigurations',
		function() {
			var A = AUI();

			submitForm(document.<portlet:namespace />fm);
		}
	);

</aui:script>

<script type="text/javascript">
function callServeResource(){
    AUI().use('aui-io-request', function(A){
        A.io.request('${resourceUrl}', {
               method: 'post',
               data: {
               },
               on: {
                   	success: function() {
                    alert(this.get('responseData'));
                   }
              }
        });
 
    });
}
</script>