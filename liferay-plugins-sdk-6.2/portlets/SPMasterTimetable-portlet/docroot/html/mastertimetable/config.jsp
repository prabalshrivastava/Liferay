<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'><link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/portlet.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/main.css?minifierType=css'></link>
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>



<portlet:defineObjects />
<liferay-theme:defineObjects />
<portlet:resourceURL var="ajaxUrl">

</portlet:resourceURL>

<portlet:actionURL var="savePreferencesActionURL" name="savePreferences">
</portlet:actionURL>
<portlet:renderURL portletMode="view" var="viewURL" />

<%
	String formId = renderRequest.getPreferences().getValue(
	"htmlFormIdPref", "");
	String cStyle = renderRequest.getPreferences().getValue(
	"containerStylePref", "");
	String baseUrl = renderRequest.getPreferences().getValue(
	"baseUrlPref", "");
	String modelName = renderRequest.getPreferences().getValue(
	"modelNamePref", "");
	String waiveFeeListURL = SambaashUtil
	.getVocabularyUrl("Schedule Category");
	String categories = renderRequest.getPreferences().getValue(
	"selectedCategory", "");
%>

<aui:row cssClass="ps-pref-container"
	style="margin:10px auto; max-width:640px">
	<aui:col span="12">
		<aui:form name="editPreferences"
			action="<%=savePreferencesActionURL%>">

			<aui:input name="modelNamePref"
				label="Load the Listing for this Model" value='<%=modelName%>'></aui:input>
			<aui:input name="containerStylePref"
				label="Form Container Inline Style" value='<%=cStyle%>'></aui:input>
			<aui:input name="baseUrlPref" label="Base URL" value='<%=baseUrl%>'></aui:input>

			<%-- 			<aui:row> --%>
			<!-- 				<div class="categoryDiv"> -->
			<%-- 					<aui:col span="12"> --%>
			<!-- 						<ul> -->
			<!-- 							<li><label>Choose Category for Schedule </label></li> -->
			<!-- 							<li><label>  -->
			<%-- 								<aui:input type="checkbox" name="subject" id="subject" value="subject"></aui:input> --%>
			<!-- 								<span>Subject</span>  -->

			<!-- 							</label></li> -->
			<!-- 							<li><label> <input type="checkbox" name="programme" -->
			<!-- 									id="programme"> <span>Programme</span> -->
			<!-- 							</label></li> -->
			<!-- 						</ul> -->
			<%-- 					</aui:col> --%>
			<!-- 				</div> -->
			<%-- 			</aui:row> --%>
			<div class="programmeDiv">
				<li><label>Choose Category for Schedule </label></li>


				<li id="listElement" style="display: none"><label> <input
						type="checkbox" name="programm" class="listCheckBox"
						onChange="modifyList(this)" /> <span class="listSpanTitle">PP</span>
						<span class="listSpanCode" style="display: none">CC</span>
				</label></li>
			</div>
			<aui:input type="hidden" name="selectedCategory"
				id="selectedCategory"></aui:input>
			<aui:button-row>
				<aui:button name="saveButton" type="submit" value="label.save" />
				<aui:button type="cancel" onClick="<%=viewURL%>" />
			</aui:button-row>


		</aui:form>
	</aui:col>






</aui:row>

<script type="text/javascript">
var namespace = "<portlet:namespace/>";
var waiveFeeListURL = "<%=waiveFeeListURL%>";
var leftSideList = [];
var listElement = document.getElementById("listElement");
var selectedCategory = "";
//var categories = "";
var categories = "<%=categories%>";
console.log("selected Categories :: " + categories);
var assetCategoriesJSONOArray = ${assetCategoriesJSONOArray};
var selectedCategory = [];


function modifyList(elem) {
	debugger
	var value = elem.parentElement.getElementsByClassName("listSpanTitle")[0].innerHTML;
	if (elem.checked == true) {
		selectedCategory.push(value);
	} else {
		for (var i = 0; i < selectedCategory.length; i++) {
			if (selectedCategory[i] === value) {
				selectedCategory.splice(i, 1);
			}
		}
	}
	categories = "";
	for (var i = 0; i < selectedCategory.length; i++) {
		if(i !== selectedCategory.length-1)
		categories = categories + selectedCategory[i] + ",";
		else
		categories = categories + selectedCategory[i];	
	}
	var selectedCategoryList = document.getElementById(namespace + "selectedCategory");
	selectedCategoryList.value = categories;
}

function getScheduleCategories(){
	   var obj = {};
	   if(categories !== undefined && categories !== null && categories !== "") {
	     selectedCategory = categories.split(',');
	   }
		for(var i = 0; i <  assetCategoriesJSONOArray.length; i++) {
			obj.key = assetCategoriesJSONOArray[i];
			obj.value = assetCategoriesJSONOArray[i];
			leftSideList.push(obj);
			
			var clone = listElement.cloneNode(true);
			clone.style.display = "flex";
			clone.getElementsByClassName("listCheckBox")[0].setAttribute("onChange","modifyList(this);");
			for (var j = 0; j < selectedCategory.length; j++) {
			  if(obj.value === selectedCategory[j]) {
				  clone.getElementsByClassName("listCheckBox")[0].setAttribute("checked",true);  
			  }
			}	
			clone.getElementsByClassName("listSpanTitle")[0].innerHTML = obj.value;
			clone.getElementsByClassName("listSpanCode")[0].innerHTML = obj.key;
			document.getElementsByClassName("programmeDiv")[0].appendChild(clone);
		}
}
getScheduleCategories();


</script>

