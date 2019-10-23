<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<portlet:defineObjects />


<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="<%=Constants.EDIT %>"></portlet:param>
</portlet:actionURL>

<form action="<%=editActionURL %>" method="post"  id="fdBack-edit-form">
<div>
<span class="aui-field-label">Submit Message</span>
<span><input type="text" id="fdBack-msg" placeholder="set the message here" name="fdBack-msg" value="${tyMsg}"></span>
</div>
<div>
<span class="aui-field-label">Vocabulary id for feedback type</span>

<select name="fdBack-type-voc" id="fdBack-type-voc">
	<c:forEach var="assetVocabulary" items="${assetVocabularies}">
		<c:if test="${typeVoc == assetVocabulary.vocabularyId}">
			<option value="${assetVocabulary.vocabularyId}" selected>${assetVocabulary.name}</option>
		</c:if>
		<c:if test="${feedSearchVocId != assetVocabulary.vocabularyId}">
			<option value="${assetVocabulary.vocabularyId}">${assetVocabulary.name}</option>
		</c:if>
	</c:forEach>
</select> 
</div>
<div>
<span class="aui-field-label">Feedback receiver email address</span>
<span><input type="text" id="fdBack-rcv-email" name="fdBack-rcv-email" placeholder="set the Receiver email" value="${rcvEmail}"></span>
</div>

<div style="padding-top:20px">
<input type="submit" value="Save">
</div>

</form>

