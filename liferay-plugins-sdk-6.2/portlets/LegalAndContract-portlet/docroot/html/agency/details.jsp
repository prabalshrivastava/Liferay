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
<portlet:renderURL portletMode="view" var="viewURL" />
<portlet:resourceURL var="resourceURL" id="myResourceID01" />

<div class="form_details form_details_desktop">
	<span class="form_Title"><%= LanguageUtil.get(pageContext,"law.firm.details")%></span>
	
	<table class='agencyDetailTable'>
		  <tr><td><%= LanguageUtil.get(pageContext,"name")%></td><td><c:out value="${agency.name }"></c:out></td></tr>
		  <tr><td><%= LanguageUtil.get(pageContext,"company.registration.number")%></td><td><c:out value="${agency.number }"></c:out></td></tr>
		  <tr><td><%= LanguageUtil.get(pageContext,"country")%></td><td><c:out value="${agency.country }"></c:out></td></tr>
		  <tr><td><%= LanguageUtil.get(pageContext,"address")%></td><td><c:out value="${agency.address }" escapeXml="false"></c:out></td></tr>
		  <tr><td><%= LanguageUtil.get(pageContext,"status")%></td><td><c:out value="${agency.status }"></c:out></td></tr>
		  <tr><td><%= LanguageUtil.get(pageContext,"version")%></td><td><c:out value="${agency.version }"></c:out></td></tr>
		  <tr><td><%= LanguageUtil.get(pageContext,"agreement.reference")%></td><td><c:out value="${agency.reference }"></c:out></td></tr>
		  <tr><td><%= LanguageUtil.get(pageContext,"agreement.start.date")%></td><td><c:out value="${agency.startDate }"></c:out></td></tr>
		  <tr><td><%= LanguageUtil.get(pageContext,"agreement.end.date")%></td><td><c:out value="${agency.endDate }"></c:out></td></tr>
		  <tr><td><%= LanguageUtil.get(pageContext,"type")%></td><td><c:out value="${agency.classificationType }"></c:out></td></tr>
		  <tr><td><%= LanguageUtil.get(pageContext,"update.by")%></td><td><c:out value="${agency.userName }"></c:out></td></tr>
		  <tr><td><%= LanguageUtil.get(pageContext,"last.updated.date")%></td><td><c:out value="${agency.modifiedDate }"></c:out></td></tr>
	</table>
 <div class="classDescription">
		<div class="classDescriptionLabel">
			<%= LanguageUtil.get(pageContext,"remarks")%>
		</div>
		<div class="classDescriptionContent">
			<c:out value="${agency.remarks }" escapeXml="false"></c:out>
		</div>
	
	</div>	
	
</div>

<div class="form_details form_details_mobile">
	<span class="form_Title"><%= LanguageUtil.get(pageContext,"law.firm.details")%></span>
	
	<table >
		  <tr><td><%= LanguageUtil.get(pageContext,"name")%></td><td><c:out value="${agency.name }"></c:out></td></tr>
		  <tr><td><%= LanguageUtil.get(pageContext,"company.registration.number")%></td><td><c:out value="${agency.number }"></c:out></td></tr>
		  <tr><td><%= LanguageUtil.get(pageContext,"country")%></td><td><c:out value="${agency.country }"></c:out></td></tr>
		  <tr><td><%= LanguageUtil.get(pageContext,"address")%></td><td><c:out value="${agency.address }"></c:out></td></tr>
		  <tr><td><%= LanguageUtil.get(pageContext,"status")%></td><td><c:out value="${agency.status }"></c:out></td></tr>
		  <tr><td><%= LanguageUtil.get(pageContext,"version")%></td><td><c:out value="${agency.version }"></c:out></td></tr>
		  <tr><td><%= LanguageUtil.get(pageContext,"agreement.reference")%></td><td><c:out value="${agency.reference }"></c:out></td></tr>
		  <tr><td><%= LanguageUtil.get(pageContext,"agreement.start.date")%></td><td><c:out value="${agency.startDate }"></c:out></td></tr>
		  <tr><td><%= LanguageUtil.get(pageContext,"agreement.end.date")%></td><td><c:out value="${agency.endDate }"></c:out></td></tr>
		  <tr><td><%= LanguageUtil.get(pageContext,"type")%></td><td><c:out value="${agency.classificationType }"></c:out></td></tr>
		  <tr><td><%= LanguageUtil.get(pageContext,"update.by")%></td><td><c:out value="${agency.userName }"></c:out></td></tr>
		  <tr><td><%= LanguageUtil.get(pageContext,"last.updated.date")%></td><td><c:out value="${agency.modifiedDate }"></c:out></td></tr>
		  
	</table>
	 <div class="classDescription">
		<div class="classDescriptionLabel">
			<%= LanguageUtil.get(pageContext,"remarks")%>
		</div>
		<div class="classDescriptionContent">
			<c:out value="${agency.remarks }" escapeXml="false"></c:out>
		</div>
	
	</div>
	
</div>


<div class="form_filesTable form_filesTable_details ">
	 			<label class="field-label"><%= LanguageUtil.get(pageContext,"files.associated.with.law.firm")%></label>
	 			
			    <c:if test="${empty files}">
			    	<br><span style='font-weight:bold'><%= LanguageUtil.get(pageContext,"zero.files")%>  </span>
			    </c:if>
			    <c:if test="${not empty files}">
				    <table id="filesTable">
				    	<tr class="filesTable_head">
				    	  <td><%= LanguageUtil.get(pageContext,"file.name")%></td>
				    	  <td><%= LanguageUtil.get(pageContext,"version")%></td>
				    	  <td ><%= LanguageUtil.get(pageContext,"description")%></td>
				    	  <c:if test="${canDownloadFile }">
					    	  <td ><%= LanguageUtil.get(pageContext,"download")%></td>
				    	  </c:if>
				    	</tr>
					    <c:forEach var="file" items="${files}">
					      <tr id="row${file.fileEntryId}"> 
					      	<td >
				     		  <div style='font-weight:bold'><c:out value="${file.title}"></c:out> </div>
				   		   </td>
				   		   <td>
				   		     <c:out value="${file.version }"></c:out> 
				   		   </td>
				   		  <td>
				   		      <c:out value=" ${file.description }" escapeXml="false"></c:out>
				   		   </td>
				   		   <c:if test="${canDownloadFile }">
					   		  <td>
					   		     <a href="/FileSharing-portlet/download?fileEntryId=${file.fileEntryId}"><%= LanguageUtil.get(pageContext,"download")%></a>
					   		   </td>
				    	  </c:if>
					        </tr>
					    </c:forEach>
				    </table>
			    </c:if>
	</div>
 <aui:button type="cancel" id='cancel'/>
<aui:button type="button" name="export" id="export"
								value='<%= LanguageUtil.get(pageContext,"export.pdf")%>' label="" />
<aui:button type="button" name="exportXls" id="exportXls"
								value='<%= LanguageUtil.get(pageContext,"export.xls")%>' label="" />
<%@ include file="/html/searchParams.jsp" %>								
<script>
var portletNs = "<portlet:namespace/>";
var ajaxUrl = "<%=resourceURL%>";
var agencyId = "${agencyId}";


initializeExport(portletNs,ajaxUrl);
function initializeExport(portletNs,ajaxUrl){
	
	var func = function(){
		AUI().use('aui-node','aui-base', 'aui-io-request-deprecated', function (A){
			var exptype = '';
			if(event.target.id == portletNs + "export")
				exptype = 'exportDetailsPdf';
			else 
				exptype = 'exportDetailsXls';
			
			A.io.request(ajaxUrl,{
				dataType : 'json',
				method : 'POST',
				data : {
					action: exptype,
					agencyId : agencyId
				},
				on : {
					success : function() {
						//var data = this.get('responseData');
						//var result = data.result;
						var data = this.get('responseData');
						if(data && data.errorMsg){
							alert(data.errorMsg);
						}else{
							document.location.href = "/LegalAndContract-portlet/download?fileName=" + data.fileName ;
						}
					},
					failure : function(){
						var data = this.get('responseData');
						if(data && data.errorMsg){
							alert(data.errorMsg);
						}else{
							alert("Error while generating the report");
						}
					}
				}
			});
			
		});
		
	};
	
	AUI().use('aui-node','aui-base',function(A){
		var buttonId = "#" + portletNs + "export";
		var buttonXlsId = "#" + portletNs + "exportXls";
		
		var exportObj = A.one(buttonId);
		var exportXlsObj = A.one(buttonXlsId);
		
		if(exportObj){
			exportObj.on("click", func);
		}
		if(exportXlsObj){
			exportXlsObj.on("click", func);
		}
		
	});
	

}

</script>
