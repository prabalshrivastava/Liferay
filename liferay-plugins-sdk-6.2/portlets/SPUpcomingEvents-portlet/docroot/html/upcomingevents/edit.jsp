<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%-- <portlet:resourceURL var="saveSearchCriterias">
	<portlet:param name="action" value="saveSearchCriterias"></portlet:param>
</portlet:resourceURL> --%>


<div class="searchCriterias">
	<div class="searchCriteriaLabel">Search Recommended Training Programs based on : </div>
	
	<input type="radio" name="<portlet:namespace/>eventsListCriteria" value="Functional Group" <c:if test="${eventsListCriteria=='Functional Group' }">checked</c:if> onchange="javascript:showVocabularyList()">Functional Group
	<input type="radio" name="<portlet:namespace/>eventsListCriteria" value="Domain Names" <c:if test="${eventsListCriteria=='Domain Names' }">checked</c:if> onchange="javascript:showVocabularyList()"="javascript:showVocabularyList()">Domain Names
</div>

<div class="vocSelect" id="<portlet:namespace/>searchCriteriasVocabulary">

<select id="<portlet:namespace/>searchCriteriasVocabularySelect" multiple="multiple" name="searchCriteriasVocabularySelect" style="margin: 10px 0 10px 0;">
                                           <c:forEach items="${assetVocabularyList}" var="assetVocList">
												<option value="${assetVocList.vocabularyId }">${assetVocList.name }</option>
											</c:forEach>
                                    </select>
                              
<div>Process Id : <input type="text" placeholder="ProcessId" id="<portlet:namespace/>processId" value="${processId }"></div>
</div>
<input type="button" value="Save Changes" onclick="javascript:saveSearchCriterias()"/>

<script>
var eventsListCriteria = "${eventsListCriteria}";
AUI().ready(function(A) {
	var searchCriteriaVoc = "${searchCriteriaVoc}";
	var selectElm = document.getElementById("<portlet:namespace/>searchCriteriasVocabularySelect");
	if(selectElm)
	if (searchCriteriaVoc != '' && searchCriteriaVoc != 'undefined' && searchCriteriaVoc != 'null') {
		for (i = 0; i < selectElm.length; i++) {
			var rstat = searchCriteriaVoc.split(",");
			for(var k=0;k<rstat.length;k++){
		        if(rstat[k] != selectElm.options[i].value){
		        }else{
		        	selectElm.options[i].selected = i;
		        }
			}    
	    }
	}
	showVocabularyList();
});

function showVocabularyList(){
	var radios = document.getElementsByName('<portlet:namespace/>eventsListCriteria');

	if(eventsListCriteria == 'Functional Group'){
		document.getElementById("<portlet:namespace/>searchCriteriasVocabulary").style.display = "none";
	}else{
		document.getElementById("<portlet:namespace/>searchCriteriasVocabulary").style.display = "block";
		for (var i = 0;i < radios.length; i++) {
		    if (radios[i].checked){
		    	if(radios[i].value == 'Functional Group') {
		    		document.getElementById("<portlet:namespace/>searchCriteriasVocabulary").style.display = "none";
				}else{
					document.getElementById("<portlet:namespace/>searchCriteriasVocabulary").style.display = "block";
			    }
			}
		}
	}
}

function saveSearchCriterias(){
	var A=AUI();
	var items = null;
	var saveSearchCriterias = '${saveSearchCriterias}';
	var processIdValue;
	if(document.getElementById("<portlet:namespace/>processId")){
		processIdValue = document.getElementById("<portlet:namespace/>processId").value;
	}
	var radioBtns = document.getElementsByName('<portlet:namespace/>eventsListCriteria');
	var radioBtnsvalue;
	for(var i = 0; i < radioBtns.length; i++){
	    if(radioBtns[i].checked){
	    	radioBtnsvalue = radioBtns[i].value;
	    }
	}
	var searchCriteriasVocabulary = getMultiSelectValues("<portlet:namespace/>searchCriteriasVocabularySelect");
	var reqUrl = '<portlet:resourceURL id="" />'+'&action=saveSearchCriterias';
	A.io
	.request(
			reqUrl,
			{
				cache : false,
				sync : true,
				timeout : 1000,
				dataType : 'json',
				method : 'post',
				data : {
					eventsListCriteria : radioBtnsvalue,
					searchCriteriasVocabularySelect : searchCriteriasVocabulary,
					processId : processIdValue
				},
				on : {
					success : function() {
						items = this.get('responseData');
						if (items) {
						} else {

						}

					},
					failure : function() {

					}
				}

			});
}

function getMultiSelectValues(elementId) {
    var selectList = document.getElementById(elementId);
    var selectedItems = [];
    for (var i = 0; i < selectList.length; i++) {
        if (selectList.options[i].selected) selectedItems.push(selectList.options[i].value);
    }
    return selectedItems;
}
</script>