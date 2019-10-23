<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<liferay-ui:error key="unauthorized.agency.update" message='<%= LanguageUtil.get(pageContext,"not.authorized.to.update.agency.details")%>' />
<liferay-ui:error key="unauthorized.agency.add" message='<%= LanguageUtil.get(pageContext,"not.authorized.to.add.agency")%>' />
<liferay-ui:error key="unauthorized.agency.bulkupload" message='<%= LanguageUtil.get(pageContext,"not.authorized.to.bulkupload.agency")%>' />

 <c:if test="${not prefsAvailable}">
    <span><%= LanguageUtil.get(pageContext,"msg.preferences.not.set")%></span>
 </c:if>
<c:if test="${prefsAvailable}">

<portlet:actionURL var="uploadURL" name="upload">
  <portlet:param name="upload" value="agencies"/>
</portlet:actionURL>

<span class="form_Title"><%= LanguageUtil.get(pageContext,"law.firms")%></span><br>
<%@ include file="/html/bulkuploadResults.jsp" %>

<div class="esn_addAgency_wrap">
	
	<div class="esn_addAgency">
		<aui:form name="addAgencyForm" >
		  <aui:fieldset>
		   <c:if test="${addAgencyPermission}">
		         <a href='${displayAddAgencyURL}' title="Add Law Firm">+</a>
			</c:if>
		  </aui:fieldset>
		</aui:form>
	</div>
 <c:if test="${bulkuploadAgencyPermission}">
	<div class="esn_multiUpAgency">
		
		<aui:form name="agencyForm" action="<%=uploadURL%>" enctype="multipart/form-data">
			
			<aui:fieldset>
				 <aui:input name="filesToUpload"
								id="filesToUpload" type="file"
								accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" />
				  <div class="form_CTA_submit">
				 	 <aui:button type="submit" name="uploadAgency" id="uploadAgency"  
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
var uploadBId ="#" + pns + "uploadAgency";
initializeUploadButton(pns,fupId,uploadBId);
</script>
