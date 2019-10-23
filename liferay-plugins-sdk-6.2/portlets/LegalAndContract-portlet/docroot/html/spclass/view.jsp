<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<liferay-ui:error key="unauthorized.class.edit" message="You are not authorized to update Class details" />
<liferay-ui:error key="unauthorized.class.add" message="You are not authorized to Class" />

<portlet:actionURL var="displayAddClassURL" name="displayAddCLass">
</portlet:actionURL>
<portlet:actionURL var="searchClassURL" name="searchClass">
</portlet:actionURL>
<portlet:actionURL var="uploadURL" name="upload">
  <portlet:param name="upload" value="classes"/>
</portlet:actionURL>
<%@ include file="/html/bulkuploadResults.jsp" %>

<div class="esn_addClass_wrap">

	
	<div class="esn_addClass">
		<aui:form name="classForm" action="<%=displayAddClassURL%>" >
	
			<aui:fieldset>
			      <c:if test="${addClassPermission}">
			      	
				     <aui:button type="submit" name="addClass" id="addClass"
						value="Add Class" label="" />
					
			      </c:if>
			</aui:fieldset>
		</aui:form>
	</div>
	
	<div class="esn_multiUpClass">
		<aui:form name="classForm" action="<%=uploadURL%>" enctype="multipart/form-data">
	
			<aui:fieldset>
			      <aui:input label="Select excel file" name="filesToUpload"
								id="filesToUpload" type="file"
								accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" />
				  <div class="form_CTA_submit">
				  	<aui:button type="submit" name="uploadClass" id="uploadClass" 
						value="Bulk Upload Class Master" label="" /><br>
				  </div>
			</aui:fieldset>
		</aui:form>
	</div>

</div>

<%@ include file="/html/search.jsp" %>

<div>
<liferay-ui:search-iterator searchContainer="${searchContainer}" />
</div>


