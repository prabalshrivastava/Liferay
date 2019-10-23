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

	.vnc-box-sizing input[type="text"], .vnc-box-sizing textarea {
	    -moz-box-sizing: border-box;
	   	-webkit-box-sizing: border-box;
	    box-sizing: border-box;
	    width: 100%;
		display: block;
	}
	.vnc-box-sizing textarea {
	    height: 75px;
	}
	
	.vnc-full-width {
		width: 100%;
		-moz-box-sizing: border-box;
	   	-webkit-box-sizing: border-box;
	    box-sizing: border-box;
	}
	
	.vnc-textarea-height {
		height: 50px;
	}
	
	#vnc .choice-label, .field-input-choice {
	    float: none;
	}

</style>

<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="<%=Constants.EDIT %>"></portlet:param>
</portlet:actionURL>

<%

String itermsPerPage = portletPreferences.getValue("itermsPerPage", "8");

boolean enableVoting = Boolean.valueOf(portletPreferences.getValue("enableVoting", StringPool.FALSE));
boolean enableComment = Boolean.valueOf(portletPreferences.getValue("enableComment", StringPool.FALSE));
boolean commentToVote = Boolean.valueOf(portletPreferences.getValue("commentToVote", StringPool.FALSE));
boolean showComments = Boolean.valueOf(portletPreferences.getValue("showComments", StringPool.TRUE));
boolean enableContextRegistration = Boolean.valueOf(portletPreferences.getValue("enableContextRegistration", StringPool.FALSE));

String blogAlias = portletPreferences.getValue("blogAlias", "blog");

%>

<h1 style="padding-bottom: 15px; border-bottom: 1px solid #DDDDDD; margin: 0;">Configurations</h1>

<div id="vnc">
	<aui:form action="<%= editActionURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault();" %>'>
	
		<div style="padding: 20px;">
			<aui:input name="itermsPerPage" label="Iterms Per Page" placeholder="Iterms Per Page" value="<%=itermsPerPage %>" inputCssClass="vnc-full-width" />
			<br/>
			<aui:input name="enableVoting" type="checkbox" inlineLabel="right" label="Enable Voting" inlineField="<%= true %>" value="<%=enableVoting %>" />
			<br/>
			<aui:input name="enableComment" type="checkbox" inlineLabel="right" label="Enable Comment" inlineField="<%= true %>" value="<%=enableComment %>" />
			<br/>
			<aui:input name="commentToVote" type="checkbox" inlineLabel="right" label="Comment to vote" inlineField="<%= true %>" value="<%=commentToVote %>" />
			<br/>
			<aui:input name="showComments" type="checkbox" inlineLabel="right" label="Show comments" inlineField="<%= true %>" value="<%=showComments %>" />
			<br/>
			<aui:select label="SpAsset Type" id="selectedSPAssetTypeId" name="selectedSPAssetTypeId" value="${selectedSPAssetTypeId}">
			<c:forEach var="spAssetType" items="${assetTypes}">
				<option value="${spAssetType.spAssetTypeId}"  <c:if test="${spAssetType.spAssetTypeId == selectedSPAssetTypeId}">selected="selected"</c:if>  >${spAssetType.spAssetType}</option>
			</c:forEach>
			</aui:select>
			<br/>
			<aui:input name="enableContextRegistration" type="checkbox" inlineLabel="right" label="Enable Context Registration" inlineField="<%= true %>" value="<%=enableContextRegistration %>" />
			<br/>
			<br/>
			<aui:input name="blogAlias" label="Blog Alias" placeholder="Blog Alias" value="<%=blogAlias %>" inputCssClass="vnc-full-width" />
		</div>
		
		<aui:button name="saveButton" onClick='<%= renderResponse.getNamespace() + "saveConfigurations();" %>' type="submit" value="Save" />
	
	</aui:form>
</div>

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
