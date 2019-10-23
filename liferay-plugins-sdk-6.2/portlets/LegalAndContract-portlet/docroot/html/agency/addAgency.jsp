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

<portlet:actionURL var="addAgencyActionURL" name="addAgency">

</portlet:actionURL>
<portlet:renderURL portletMode="view" var="viewURL" />
<link rel="stylesheet" type="text/css" media="all" href="/LegalAndContract-portlet/css/styles.css" />
<portlet:resourceURL var="resourceURL" id="myResourceID01" />

<liferay-ui:error key="agency.duplicate" message='<%= LanguageUtil.get(pageContext,"law.firm.already.exists")%>' />
<liferay-ui:error key="agency.add.failed" message='<%= LanguageUtil.get(pageContext,"error.adding.agency")%>' />
<liferay-ui:error key="agency.number.required" message='<%= LanguageUtil.get(pageContext,"company.registration.number.is.required")%>' />
<liferay-ui:error key="agency.country.required" message='<%= LanguageUtil.get(pageContext,"agency.country.required")%>' />
<liferay-ui:error key="agency.type.required" message='<%= LanguageUtil.get(pageContext,"agency.type.required")%>' />
<liferay-ui:error key="agency.name.required" message='<%= LanguageUtil.get(pageContext,"agency.name.required")%>' />
<liferay-ui:error key="agency.reference.required" message='<%= LanguageUtil.get(pageContext,"agency.reference.required")%>' />
<liferay-ui:error key="agency.address.required" message='<%= LanguageUtil.get(pageContext,"agency.address.required")%>' />
<liferay-ui:error key="agency.remarks.required" message='<%= LanguageUtil.get(pageContext,"agency.remarks.required")%>' />
<liferay-ui:error key="agency.status.required" message='<%= LanguageUtil.get(pageContext,"agency.status.required")%>' />
<liferay-ui:error key="unauthorized.agency.country.add" message='<%= LanguageUtil.get(pageContext,"not.authorized.to.add.agency")%>' />
<liferay-ui:error key="agency.custom.date1" message='<%= LanguageUtil.get(pageContext,"custom.date1.not.valid")%>' />
<liferay-ui:error key="agency.custom.date2" message='<%= LanguageUtil.get(pageContext,"custom.date2.not.valid")%>' />
<liferay-ui:error key="agency.custom.date3" message='<%= LanguageUtil.get(pageContext,"custom.date3.not.valid")%>' />

<%
	Calendar curValueDate = com.liferay.portal.kernel.util.CalendarFactoryUtil
			.getCalendar(timeZone, locale);
%>
<div>
	<span class="form_Title" ><%= LanguageUtil.get(pageContext,"create.law.firm")%></span>
	
	<aui:form name="createAgency" action="<%=addAgencyActionURL%>">
		<aui:fieldset>
		 	<c:if test="${empty countryList}"><%= LanguageUtil.get(pageContext,"no.countries.available.for.role")%></c:if>
			<div class="form_fieldset_wrap">
			<c:if test="${not empty countryList}">
				<div class="form_field">
					<aui:input type="text" name="number" id="number" label='<%= LanguageUtil.get(pageContext,"company.registration.number")%>' size="100">
						  <aui:validator name="required" errorMessage='<%= LanguageUtil.get(pageContext,"company.registration.number.is.required")%>'></aui:validator>
						  <aui:validator name="rangeLength">[1,100]</aui:validator>
				    </aui:input>
			    </div>
			    <div class="form_dropD">
					<aui:select name="countryList" label='<%= LanguageUtil.get(pageContext,"country")%>'>
						<c:forEach var="countries" items="${countryList}">
							<aui:option value="${countries.categoryId}" label="${countries.name}" />
						</c:forEach>
					</aui:select>
				</div>
			    <div class="form_field">
					<aui:input type="text" name="name" id="name" label='<%= LanguageUtil.get(pageContext,"name")%>' size="100">
					<aui:validator name="rangeLength">[1,100]</aui:validator>
				    </aui:input>
			    </div>
			    <div class="form_field">
					<aui:input type="text" name="reference" id="reference"
						label='<%= LanguageUtil.get(pageContext,"agreement.reference")%>' size="100" >
						<aui:validator name="rangeLength">[1,100]</aui:validator>
						 <%-- <aui:validator name="required" errorMessage="Agency Reference is required"></aui:validator> --%>
					</aui:input>
				</div>
			    <div class="form_field">
					<aui:input type="text" name="startDate" id="startDate"
						label='<%= LanguageUtil.get(pageContext,"agreement.start.date")%>' size="100" >
						<aui:validator name="rangeLength">[1,100]</aui:validator>
					</aui:input>
				</div>
			    <div class="form_field">
					<aui:input type="text" name="endDate" id="endDate"
						label='<%= LanguageUtil.get(pageContext,"agreement.end.date")%>' size="100" >
						<aui:validator name="rangeLength">[1,100]</aui:validator>
					</aui:input>
				</div>
		
				<div class="form_dropD">
					<aui:select name="classificationType" label='<%= LanguageUtil.get(pageContext,"type")%>'>
						<c:forEach var="classifications" items="${classificationTypeList}">
							<aui:option value="${classifications.categoryId}"
								label="${classifications.name}" />
						</c:forEach>
					</aui:select>
				</div>
				<div class="form_field">
					<aui:input type="textarea" name="address" id="address" label='<%= LanguageUtil.get(pageContext,"address")%>' rows="8" cols="30">
						  <%-- <aui:validator name="required" errorMessage="Agency Address is required"></aui:validator> --%>
				    </aui:input>
			    </div>
			    <div class="form_field">
				    <aui:input type="textarea" name="remarks" id="remarks" label='<%= LanguageUtil.get(pageContext,"remarks")%>' rows="8" cols="30" >
						  <%-- <aui:validator name="required" errorMessage="Remarks is required"></aui:validator> --%>
				    </aui:input>
			    </div>
			    <div class="form_field">
				    <aui:input type="text" name="status" id="status" label='<%= LanguageUtil.get(pageContext,"status")%>' size="100">
						  <%-- <aui:validator name="required" errorMessage="Agency Status is required"></aui:validator> --%>
						  <aui:validator name="rangeLength">[1,100]</aui:validator>
				    </aui:input>
			    </div>
			   
				<div class="forms_fileDrag_wrap">
					<label class="field-label"><%= LanguageUtil.get(pageContext,"file.attachments")%></label>
				    <input type="file" name="<portlet:namespace/>files" id="<portlet:namespace/>files" multiple>
				    <div id="filedrag1" class="form_fileDrag"><%= LanguageUtil.get(pageContext,"drop.files.here")%></div>
				   
				    <table id="filesTab1" class="form_filesTab">
				    </table>
					
					<c:if test="${empty previousfiles}">
				    </c:if>
				    <c:if test="${not empty previousfiles}">
					    	<span class="field-label"><%= LanguageUtil.get(pageContext,"uploaded.earlier.but.transaction.not.complete")%>  </span>
						    <table id="previousAttachmentsTable" style='font-size:20px'>
						    	<tr>
						    	  <td style='font-weight:bold;margin-left:20px'><%= LanguageUtil.get(pageContext,"file.name")%></td>
						    	  <td style='font-weight:bold;margin-left:20px'><%= LanguageUtil.get(pageContext,"title")%></td>
						    	  <td style='font-weight:bold;margin-left:20px'><%= LanguageUtil.get(pageContext,"description")%></td>
						    	  <td style='font-weight:bold;margin-left:20px'><%= LanguageUtil.get(pageContext,"delete")%> </td>
						    	</tr>
							    <c:forEach var="file" items="${previousfiles}">
							      <tr id="row${file.fileEntryId}"> <td style='margin-left:20px'>
							     		  <div style='font-weight:bold'>${file.title}</div>
							   		   </td>
							   		    <td>
							      	      <aui:input name="title_${file.fileEntryId}" id="title_${file.fileEntryId}" type="text" size="100" value="${file.title }" label=""></aui:input>
							   		   </td>
							   		   <td>
							   			   <aui:input type="textarea" name="fileDesc_${file.fileEntryId}" id="fileDesc_${file.fileEntryId}"  value="${file.description }" rows="8" cols="30" label=""></aui:input>
							   		   </td>
							   		   <td style='margin-left:20px'>
							   		      <a id="link${file.fileEntryId}"  href="javascript:;"><%= LanguageUtil.get(pageContext,"remove")%></a>
							   		   </td>
							        </tr>
							    </c:forEach>
						    </table>
				  	  </c:if>
				</div>
				<div class="form_CTA">
					<aui:button-row>
						
						<aui:button type="submit" name="addAgency" id="<portlet:namespace/>addAgency"
							value='<%= LanguageUtil.get(pageContext,"add.law.firm")%>' label="" />
						 <aui:button type="cancel" id='cancel'/>
					</aui:button-row>
				</div>
				</c:if>
			</div>
		</aui:fieldset>
	</aui:form>

</div>
<%@ include file="/html/searchParams.jsp" %>
<script type="text/javascript" src="/LegalAndContract-portlet/js/misc.js" ></script>
<script>
var ajaxurl = "<%=resourceURL %>";
var pns = '<portlet:namespace/>';
var filesCount=0;
removeFile('previousAttachmentsTable');
</script>
<script type="text/javascript" src="/LegalAndContract-portlet/js/filedrag.js" ></script>
<script>
//call initialization file
if (window.File && window.FileList && window.FileReader) {
	var obj1 = new trademarkFileDrag();
	obj1.Init('filedrag1','filesTab1','files',ajaxurl,'draganddrop',pns);
	
	var obj3 = new trademarkFileDrag();
	obj1.Init('filedrag1','filesTab1','files',ajaxurl,'fileInput',pns);
}

</script>
