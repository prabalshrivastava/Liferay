<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<c:if test="${not prefsAvailable}">
    <span><%= LanguageUtil.get(pageContext,"preference.not.set")%></span>
 </c:if>
<c:if test="${prefsAvailable}">
<portlet:defineObjects />
<liferay-theme:defineObjects />
<liferay-ui:error key="unauthorized.litigation.edit" message='<%= LanguageUtil.get(pageContext,"not.authorized.to.update.litigation")%>' />
<liferay-ui:error key="unauthorized.litigation.add" message='<%= LanguageUtil.get(pageContext,"not.authorized.to.litigation")%>' />
<liferay-ui:error key="unauthorized.litigation.bulkupload" message='<%= LanguageUtil.get(pageContext,"not.authorized.to.bulkupload")%>' />


<portlet:actionURL var="uploadURL" name="upload">
</portlet:actionURL>
<span class="form_Title"><%= LanguageUtil.get(pageContext,"contentious.proceedings")%></span><br>
<%@ include file="/html/bulkuploadResults.jsp" %>

<div class="esn_addLitigation_wrap">
	<div class="esn_addLitigation">
		<aui:form name="litigationForm">
			<aui:fieldset>
			      <c:if test="${addLitigaitonPermission}">
				   <!--    <aui:button type="submit" name="addLitigation" id="addLitigation"
						value="Add Litigation" label="" />  -->
						<a href='${displayAddLitigationURL}' title="Add Contentious Proceeding">+</a>
			      </c:if>
			</aui:fieldset>
		</aui:form>
	</div>
  <c:if test="${bulkuploadLitigaitonPermission}">
	<div class="esn_multiUpLitigation">
		<aui:form name="litigationForm" action="<%=uploadURL%>" enctype="multipart/form-data">
	
			<aui:fieldset>
			      <aui:input label='<%= LanguageUtil.get(pageContext,"select.excel.file")%>' name="filesToUpload"
								id="filesToUpload" type="file"
								accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" />
				  <div class="form_CTA_submit">
					  <aui:button type="submit" name="uploadLitigation" id="uploadLitigation" 
							value='<%= LanguageUtil.get(pageContext,"bulk.upload")%>' label="" />
				  </div>
			</aui:fieldset>
		</aui:form>
	</div>
	</c:if>
</div>

<%@ include file="/html/search.jsp" %>
<div>
<liferay-ui:search-iterator searchContainer="${searchContainer}" />
</div>
</c:if>

<script type="text/javascript" src="/LegalAndContract-portlet/js/misc.js" ></script>
<script>
var pns = '<portlet:namespace/>';
var fupId = "#" + pns + "filesToUpload";
var uploadBId ="#" + pns + "uploadLitigation";
initializeUploadButton(pns,fupId,uploadBId);
</script>
