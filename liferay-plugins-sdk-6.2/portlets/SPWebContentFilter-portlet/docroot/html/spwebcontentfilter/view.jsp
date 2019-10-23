<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="javax.portlet.*" %>

<%@ page import="java.util.*" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<script type="text/javascript">
var solutionsJSONObject = ${solutionsJSONObject};
var backsolutionsJSONObject;

function populateTitle(jsonObject){
	
	if(jsonObject == "back"){
		jsonObject = backsolutionsJSONObject;
	}
	var divElement = document.getElementById("solutionsList");
	divElement.innerHTML="";
	divElement.style.display = "block";
	
	var divContentElement = document.getElementById("selectedContent");
	divContentElement.style.display = "none";
	//alert("jsonObject " + jsonObject[key]);
	
	for(key in jsonObject){
		//alert("key" + key);
		var solutionsObject = jsonObject[key];
		var divTitle = document.createElement("Div");
		divTitle.setAttribute("class","panelcollapsed solutionsearch");
		var linkTitle = document.createElement("a");
		//alert("key " +key);
		linkTitle.setAttribute("href","#");
		linkTitle.setAttribute("onClick","javascript:showSelectedContent(" + key +")");
		for(key in solutionsObject){
			divTitle.innerHTML = key;
		}
		linkTitle.appendChild(divTitle);
		divElement.appendChild(linkTitle);
	}
	if(divElement.innerHTML==""){
		noResults()
	}
	backsolutionsJSONObject = jsonObject;
}

function showSelectedContent(aId){
	var divElementList = document.getElementById("solutionsList");
	divElementList.style.display="none";
	var divElement = document.getElementById("selectedContent");
	divElement.innerHTML="";
	divElement.style.display="block";
	//alert("divElement " +divElement);
		var solutionsObject = solutionsJSONObject[aId];
		var backDiv = document.createElement("Div");
		backDiv.setAttribute("style","float:right;margin-right: 10px;");
		var aBack = document.createElement("a");
		aBack.setAttribute("href","#");
		aBack.setAttribute("onclick","javascript:populateTitle('back');");
		aBack.innerHTML="« Back";
		backDiv.appendChild(aBack);
		/* var divTitle = document.createElement("Div");
		divTitle.setAttribute("class","panelcollapsed");
		divTitle.setAttribute("style","padding:5px;width: 97%;display: inline-block;"); */
		var divContent = document.createElement("div");
		divContent.setAttribute("style","padding:10px;text-align:justify");
	
		for(key in solutionsObject){
			//divTitle.innerHTML = key;
			var p = escapeHtml(solutionsObject[key]);
			divContent.innerHTML = p;
		}
		divElement.appendChild(backDiv);
		//divElement.appendChild(divTitle);
		divElement.appendChild(divContent);
		
		
}

function escapeHtml(str) {
	var div = document.createElement('div');
	div.innerHTML = str;
	str = div.textContent;
	return str;
	}
	
function searchByCategory(){
	var category1 = document.getElementById("_WebContentFilter_WAR_WebContentFilterportlet_industryVocabulary");
	var cId1 = category1.options[category1.selectedIndex].value;
	var category2 = document.getElementById("_WebContentFilter_WAR_WebContentFilterportlet_functionVocabulary");
	var cId2 = category2.options[category2.selectedIndex].value;
	var category3 = document.getElementById("_WebContentFilter_WAR_WebContentFilterportlet_serviceVocabulary");
	var cId3 = category3.options[category3.selectedIndex].value;
	var categoryIds = cId1 + "/" + cId2 +"/"+cId3;
	
	var A=AUI();
	var reqUrl = '<portlet:resourceURL id="" />';
	
	A.io.request(reqUrl, {
	    cache: false,
	    sync: true,
	    timeout: 1000,
	    dataType: 'json',
	    method: 'post',
	    data:{
	    	categoryIds:categoryIds,
	    },
	    on: {
	        success: function() {
	
	       	 items = this.get('responseData');
	       	 if(items){
	       		//for(key in items) 
	       			populateTitle(items);
	       		
	       		//noResults();
	       	}
	        },
	        failure: function() {
	        	alert("Failure");
	        }
	    }
	});
 	return items;
	
}

function noResults(){
	var divElement = document.getElementById("solutionsList");
	divElement.innerHTML="";
	divElement.style.display = "block";
	divElement.innerHTML="No solutions found for the selected category"; 
}
</script>

<aui:layout cssClass="pref-row-content">
	<aui:column cssClass="pref-label" first="true">
		<div class="box-title-style solutions-title">Case Studies</div>
		<div class="seperatedline"></div>
	</aui:column>
	<aui:column>
		<div class="solutions-category">Industry</div>
		<aui:select name="industry" id="industryVocabulary" value="13497" label="" onChange="javascript:searchByCategory()">
			<aui:option label="All" value="0"></aui:option>
			<c:forEach items="${industryAssetCategories}" var="industryAssetCategories">
				<aui:option label="${industryAssetCategories.name}" value="${industryAssetCategories.categoryId}"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:column>
	<aui:column>	
		<div class="solutions-category">Function</div>
		<aui:select name="function" id="functionVocabulary" value="13512" label="" onChange="javascript:searchByCategory()">
			<aui:option label="All" value="0"></aui:option>
			<c:forEach items="${functionAssetCategories}" var="functionAssetCategories">
				<aui:option label="${functionAssetCategories.name}" value="${functionAssetCategories.categoryId}"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:column>
	<aui:column>	
		<div class="solutions-category">Line of Service</div>
		<aui:select name="service" id="serviceVocabulary" value="13526" label="" onChange="javascript:searchByCategory()">
			<aui:option label="All" value="0"></aui:option>
			<c:forEach items="${serviceAssetCategories}" var="serviceAssetCategories">
				<aui:option label="${serviceAssetCategories.name}" value="${serviceAssetCategories.categoryId}"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:column>
</aui:layout>
<div id="solutionsList">

</div>

<div id="selectedContent">

</div>


<script type="text/javascript">

populateTitle(solutionsJSONObject);
</script>
