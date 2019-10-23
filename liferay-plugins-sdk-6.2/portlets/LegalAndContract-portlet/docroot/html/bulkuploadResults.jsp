<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<c:if test="${processed}">
   <div>
   	<p class="buTitle"><%= LanguageUtil.get(pageContext,"bulk.upload.results")%>:</p>
   	<p class="buRowsAdded"><%= LanguageUtil.get(pageContext,"rows.added")%>: ${rowsAdded}</p>
   	<p class="buRowsUpdated"><%= LanguageUtil.get(pageContext,"rows.updated")%>: ${rowsUpdated}</p>
   	
     
     <c:if test="${not empty errors }">
     <div class="bulkUploadResultsTableC">
     <div class="bulkUploadResultsTable">
     
     <table>
        <tr><td class="buHead buheader1"><%= LanguageUtil.get(pageContext,"sheet.no")%></td>
        	<td class="buHead buheader2"><%= LanguageUtil.get(pageContext,"row.no")%> </td>
        	<td class="buHead buheader3"><%= LanguageUtil.get(pageContext,"field.name")%> </td>
        	<td class="buHead buheader4"><%= LanguageUtil.get(pageContext,"message")%></td>
        </tr>
        <c:forEach var="error"  items="${errors}">
          <tr><td class="buData budata1">${error.sheetNo}</td>
        	<td class="buData budata2">${error.rowNo }</td>
        	<td class="buData budata3">${error.fieldName }</td>
        	<td class="buData budata4">
        	<c:if test="${ error.msg == 'Added' || error.msg == 'Updated'}">
	        	<img src="${successImage}" alt="Success"/> ${ error.msg}
        	</c:if>
        	<c:if test="${ error.msg != 'Added' && error.msg != 'Updated'}">
	        	<img src="${failImage}" alt="Error"/>&nbsp;${error.msg }
        	</c:if></td>
        </tr>
        </c:forEach>
     </table>
     </div>
     </div>
      </c:if> 	
   </div>

</c:if>
