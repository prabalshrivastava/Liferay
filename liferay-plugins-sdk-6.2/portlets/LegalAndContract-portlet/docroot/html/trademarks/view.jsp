<%@page import="com.sambaash.platform.portlet.legalandcontract.util.Utils"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.portlet.WindowState"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>

<c:if test="${not prefsAvailable}">
    <span>Preferences are not set for this portlet. Please ask your administrator to set the preferences.</span>
 </c:if>
<c:if test="${prefsAvailable}">

<portlet:defineObjects />
<liferay-theme:defineObjects />
<liferay-ui:error key="unauthorized.trademarks.update" message='<%= LanguageUtil.get(pageContext,"not.authorized.to.update.trademark.details")%>' />
<liferay-ui:error key="unauthorized.trademarks.add" message='<%= LanguageUtil.get(pageContext,"not.authorized.to.add.trademarks")%>' />
<liferay-ui:error key="unauthorized.trademarks.bulkupload" message='<%= LanguageUtil.get(pageContext,"not.authorized.to.bulkupload.trademarks")%>' />
<portlet:actionURL var="uploadURL" name="upload">
</portlet:actionURL>

<span class="form_Title"><%= LanguageUtil.get(pageContext,"trademarks")%></span><br>

<%@ include file="/html/bulkuploadResults.jsp" %>

<div class="esn_addTrademark_wrap">

	<div class="esn_addTrademark">
	
		<%-- <aui:form name="trademarkForm" action="<%=displayAddTrademarkURL%>"> --%>
			<aui:fieldset>
			      <c:if test="${addTrademarksPermission}">
					 <a href='${displayAddTrademarkURL}' title="Add Trademark">+</a>
				</c:if>
			</aui:fieldset>
		<%-- </aui:form> --%>
	</div>
  <c:if test="${bulkuploadTrademarksPermission}">
	<div class="esn_multiUpTrademark">
		<aui:form name="trademarkForm" action="<%=uploadURL%>" enctype="multipart/form-data">
	
			<aui:fieldset>
				 <aui:input label='<%= LanguageUtil.get(pageContext,"select.excel.file")%>' name="filesToUpload"
								id="filesToUpload" type="file"
								accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" />
				  <div class="form_CTA_submit">
					  <aui:button type="submit" name="uploadTrademarks" id="uploadTrademarks" 
							value='<%= LanguageUtil.get(pageContext,"bulk.upload")%>' label="" />
				  </div>	
			</aui:fieldset>
		</aui:form>
	</div>
  </c:if>
</div>

<c:if test="${empty statusMsg}">

<%@ include file="/html/search.jsp" %>

<div>
<liferay-ui:search-iterator searchContainer="${searchContainer}" />
</div>

</c:if>
</c:if>


<script type="text/javascript" src="/LegalAndContract-portlet/js/misc.js" ></script>
<script>
var pns = '<portlet:namespace/>';
var fupId = "#" + pns + "filesToUpload";
var uploadBId ="#" + pns + "uploadTrademarks";
initializeUploadButton(pns,fupId,uploadBId);
</script>
