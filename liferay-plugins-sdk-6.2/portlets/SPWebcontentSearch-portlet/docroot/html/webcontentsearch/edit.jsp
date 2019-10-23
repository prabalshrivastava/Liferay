<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.List"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@ page import="com.liferay.portlet.asset.model.AssetVocabulary"%>

<portlet:defineObjects />

<portlet:actionURL var="editActionURL">
</portlet:actionURL>


<div style="margin:40px;">
	<div style="margin-bottom:10px;font-weight:bold">
		<div style="width:30%;display:inline-block">Set number of Results per page</div><input type="text" id="totalDisplayResults" value="${totalDisplayResults}">
	</div>
	<div style="margin-bottom:10px;font-weight:bold">
		<div style="width:30%;display:inline-block">Set number of Categories to Show for each filter</div><input type="text" id="noOfCategories" value="${noOfCategories}">
	</div>		
	
		<div style="border-bottom:1px solid #efefef;">
			<div style="display: inline-block; width: 40%;font-size: 18pt;">Select
				Categories to set the Search Criteria</div>
			<div style="display: inline-block;">
				<a href="#" class="userprofile-add-links"
					onclick="javascript:addMoreSearchCriteriaVocabulary()">+ Add</a>
			</div>
		</div>
		<c:if test="${isSearchFiltersSet == 'true'}">
			<% String searchFilterWrap = (String)request.getAttribute("searchFilterWrappers");
				String[] searchFilterWrappers = searchFilterWrap.split("&&");
				int c = 0;
			%>
			<div id="searchCriteriaDiv" style='margin-top: 20px;'>
			<c:forEach items="${searchFilterWrappers}" var="searchFilterWrappers">
			<%
			//try{
			if(searchFilterWrappers[c].length() > 0){
				String[] indSearchFilter = searchFilterWrappers[c].split(",");
				request.setAttribute("indSearchFilter",indSearchFilter[1]);
			%>
					
				<div class="searchCriteriaRows" id="searchCriteriaRow<%=c %>" style="margin-bottom:15px;">
					<div style="display: inline-block;width:40%">
						<select name="searchVocId" id="searchVocId<%=c %>">
							<%List<AssetVocabulary> assetVoc = (List)request.getAttribute("assetVocabularies");  
							for(AssetVocabulary asstV : assetVoc){
								String vocId = String.valueOf(asstV.getVocabularyId());
							if(vocId.equalsIgnoreCase(indSearchFilter[0].trim())){
							%>
								<option value="<%=asstV.getVocabularyId() %>" selected><%=asstV.getName() %></option>
								<%}else{ %>
								<option value="<%=asstV.getVocabularyId() %>"><%=asstV.getName() %></option>
								<%} }%>
						</select>
					</div>
					<div class="searchSelectOptions" style="display: inline-block;width: 20%;">
					<%if(indSearchFilter[1].equalsIgnoreCase("single")){ %>
						<input type="radio" id='singleSelect<%=c %>' name="selSearchCriteria<%=c %>"
							value="single" style="margin: 0 5px 10px 15px;" checked><b>Single
							Select</b> <input type="radio" id='multiSelect<%=c %>'
							name="selSearchCriteria<%=c %>" value="multiple"
							style="margin: 0 5px 10px 15px;"><b>Multiple Select</b>
					<%} else if(indSearchFilter[1].equalsIgnoreCase("multiple")){ %>
						<input type="radio" id='singleSelect<%=c %>' name="selSearchCriteria<%=c %>"
							value="single" style="margin: 0 5px 10px 15px;"><b>Single
							Select</b> <input type="radio" id='multiSelect<%=c %>'
							name="selSearchCriteria<%=c %>" value="multiple"
							style="margin: 0 5px 10px 15px;" checked><b>Multiple Select</b>
					<%} %>
					</div>
					<div class="searchEditIcons" style="display: inline-block;">
						<div>
							<a href="#" class="userprofile-delete-links" onclick="javascript:deleteSearchCriteriaVocabulary('searchCriteriaRow<%=c %>')" id="deleteRow<%=c %>">X Delete</a>
						</div>
					</div>
				</div>
			<%} 
			c=c+1;%>
			    	</c:forEach>
			    	</div>		
		</c:if>
		<c:if test="${isSearchFiltersSet == 'false'}">
			<div id="searchCriteriaDiv" style='margin-top: 20px;'>
				<div class="searchCriteriaRows" id="searchCriteriaRow1" style="margin-bottom:15px;">
					<div style="display: inline-block;width:40%">
						<select name="searchVocId" id="searchVocId1">
							<c:forEach var="assetVocabulary" items="${assetVocabularies}">
								<option value="${assetVocabulary.vocabularyId}">${assetVocabulary.name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="searchSelectOptions" style="display: inline-block;width: 20%;">
						<input type="radio" id='singleSelect1' name="selSearchCriteria1"
							value="single" style="margin: 0 5px 10px 15px;" checked><b>Single
							Select</b> <input type="radio" id='multiSelect1'
							name="selSearchCriteria1" value="multiple"
							style="margin: 0 5px 10px 15px;"><b>Multiple Select</b>
					</div>
					<div class="searchEditIcons" style="display: inline-block;">
						<div>
							<a href="#" class="userprofile-delete-links" onclick="javascript:deleteSearchCriteriaVocabulary('searchCriteriaRow1')" id="deleteRow1">X Delete</a>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		<div>
			<input type="button" value="Save" onClick="submitForm();">
		</div>
	
	<div id="addVocabularyDiv" class="addVocabularyDiv">
		<div style="display: inline-block;width:40%">
			<select name="addsearchVocId">
				<c:forEach var="assetVocabulary" items="${assetVocabularies}">
					<option value="${assetVocabulary.vocabularyId}">${assetVocabulary.name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="searchSelectOptions" style="display: inline-block; width: 20%;">
			<input type="radio" class='addsingleSelect' 
				value="single" style="margin: 0 5px 10px 15px;"><b>Single
				Select</b> <input type="radio" class='addmultiSelect' 
				value="multiple" style="margin: 0 5px 10px 15px;" checked><b>Multiple
				Select</b>
		</div>
		<div class="searchEditIcons" style="display: inline-block;">
			<div>
				<a href="#" class="userprofile-delete-links deleteRow"> X Delete</a>
			</div>
		</div>
	</div>
</div>

<script>
	function addMoreSearchCriteriaVocabulary() {
		var mainDiv = document.getElementById('searchCriteriaDiv');
		var selectionDivs = document.getElementsByClassName('searchCriteriaRows');
		var selectionMainDiv = document.createElement("Div");
		selectionMainDiv.setAttribute('class', 'searchCriteriaRows');
		var divIdno = selectionDivs.length + 1;
		selectionMainDiv.setAttribute('id', 'searchCriteriaRow' + divIdno);
		selectionMainDiv.setAttribute('style','margin-bottom:15px;');
		var vocValues = document.getElementById('addVocabularyDiv').innerHTML;
		selectionMainDiv.innerHTML = vocValues;
		mainDiv.appendChild(selectionMainDiv);
		var newSelect = document.getElementsByName('addsearchVocId');
		newSelect[0].setAttribute('id', 'searchVocId' + divIdno);
		newSelect[0].removeAttribute('name');
		var newSingleOpt = document.getElementsByClassName('addsingleSelect');
		newSingleOpt[0].setAttribute('id', 'singleSelect' + divIdno);
		newSingleOpt[0].setAttribute('name', 'selSearchCriteria' + divIdno);
		newSingleOpt[0].removeAttribute('class');
		var newMultiOpt = document.getElementsByClassName('addmultiSelect');
		newMultiOpt[0].setAttribute('id', 'multiSelect' + divIdno);
		newMultiOpt[0].setAttribute('name', 'selSearchCriteria' + divIdno);
		newMultiOpt[0].setAttribute('checked', 'checked');
		newMultiOpt[0].removeAttribute('class');
		var newDelete = document.getElementsByClassName('deleteRow');
		newDelete[0].setAttribute('id', 'deleteRow' + divIdno);
		newDelete[0].setAttribute("onclick","javascript:deleteSearchCriteriaVocabulary('searchCriteriaRow" + divIdno + "'"+")");
		newDelete[0].removeAttribute('class');
		document.getElementById('deleteRow' + divIdno).setAttribute('class','userprofile-delete-links');
	}

	function deleteSearchCriteriaVocabulary(id) {
		var mainDiv = document.getElementById('searchCriteriaDiv');
		var rowToDelete = document.getElementById(id);
		mainDiv.removeChild(rowToDelete);
		
	}
	
	function submitForm(){
		var A=AUI();
		var items = null;
		var reqUrl = '<portlet:resourceURL id="" />';
		
		var totalDisplayResults = document.getElementById("totalDisplayResults").value;
		var noOfCategories = document.getElementById("noOfCategories").value;
		var selectionDivRows = 	document.getElementsByClassName('searchCriteriaRows');
		var searchFilterCriterias = "&&";
		for(var i=0;i<selectionDivRows.length;i++){
			var divNo = i+1;
			var selOpt = document.getElementById('searchVocId'+divNo);
			var selValue = selOpt.options[selOpt.selectedIndex].value;
			if (document.getElementById('singleSelect'+divNo).checked) {
				searchFilterCriterias = searchFilterCriterias + selValue + "," + document.getElementById('singleSelect'+divNo).value + "&&";
				}else{
					searchFilterCriterias = searchFilterCriterias + selValue + "," + document.getElementById('multiSelect'+divNo).value + "&&";
				}
		}
		
		A.io.request(reqUrl, {
		    cache: false,
		    sync: true,
		    timeout: 1000,
		    dataType: 'json',
		    method: 'post',
		    data:{
		   	 action:'edit',
		   	totalDisplayResults : totalDisplayResults,
		   	noOfCategories : noOfCategories,
		   	searchFilterCriterias: searchFilterCriterias
		    },
		    on: {
		    	success: function() {
		    		 items = this.get('responseData');
		    		window.location.href = items;
		    	}
		    },
	        failure: function() {
	        }
		
	});
		
	}
</script>
