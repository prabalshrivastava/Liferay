<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<style type="text/css">

	.spblogs-box-sizing input[type="text"], .spblogs-box-sizing textarea {
	    -moz-box-sizing: border-box;
	   	-webkit-box-sizing: border-box;
	    box-sizing: border-box;
	    width: 100%;
		display: block;
	}
	.spblogs-box-sizing textarea {
	    height: 75px;
	}

	.spblogs-full-width {
		width: 100%;
		-moz-box-sizing: border-box;
	   	-webkit-box-sizing: border-box;
	    box-sizing: border-box;
	}

	.spblogs-textarea-height {
		height: 50px;
	}

</style>

<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="<%= Constants.EDIT %>"></portlet:param>
</portlet:actionURL>

<%
String selectedAssetVocabularyIds = portletPreferences.getValue("selectedAssetVocabularyIds", StringPool.BLANK);
String itermsPerPage = portletPreferences.getValue("itermsPerPage", "8");
String topAlign = portletPreferences.getValue("topAlign", "0");
boolean enableDisqus = Boolean.valueOf(portletPreferences.getValue("enableDisqus", StringPool.TRUE));
boolean enableComments = Boolean.valueOf(portletPreferences.getValue("enableComments", StringPool.FALSE));
String disqusShortname = portletPreferences.getValue("disqusShortname", "thestartup-blogs");
%>

<h1 style="padding-bottom: 15px; border-bottom: 1px solid #DDDDDD; margin: 0;">Configurations</h1>

<aui:form action="<%= editActionURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault();" %>'>

	<div style="padding: 20px;">
		<aui:input type="textarea" name="selectedAssetVocabularyIds" label="&nbsp;" placeholder="Enter vocabulary ids(See below section), separate with comma." value="<%=selectedAssetVocabularyIds %>" inputCssClass="spblogs-full-width spblogs-textarea-height" />
		<br />
		<aui:input name="itermsPerPage" label="Iterms per page" placeholder="Iterms per page" value="<%=itermsPerPage %>" inputCssClass="spblogs-full-width" />
		<aui:input name="topAlign" lable="Top Align" placeholder="Top Align" value="<%=topAlign %>" inputCssClass="spblogs-full-width" />
		<aui:input name="enableComments" type="checkbox" inlineLabel="right" label="Enable Comments" inlineField="<%= true %>" value="<%=enableComments %>" />
		<aui:input name="enableDisqus" type="checkbox" inlineLabel="right" label="Enable Disqus" inlineField="<%= true %>" value="<%=enableDisqus %>" />
		<aui:input name="disqusShortname" label="Disqus Shortname" placeholder="Disqus Shortname" value="<%=disqusShortname %>" inputCssClass="spblogs-full-width" />
	</div>

	<aui:button name="saveButton" onClick='<%= renderResponse.getNamespace() + "saveConfigurations();" %>' type="submit" value="Save" />

</aui:form>

<br />
<br />
<div style="font-size: 15px; padding-bottom: 10px; border-bottom: 1px solid #DDDDDD;">Asset Vocabularies ( name: id )</div>
<div style="padding: 20px;">
	<c:out value="${assetVocabulariesString}"></c:out>
</div>
<br />

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
