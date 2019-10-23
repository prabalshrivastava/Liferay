<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<%@ page import="java.util.*" %>

<%@ page import="javax.portlet.*" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<h1>Job Role Configurations</h1>
<br />

<script type="text/javascript">
var assetCategoriesJSONObject = ${assetCategoriesJSONObject}; // category list for functional group linked with selected vocabulary
var assetVocabulariesJSONObject = ${assetVocabulariesJSONObject}; // vocabulary list
var jobLevelJSONObject = ${jobLevelObject}; // vocabulary list for joblevel linked with selected functional group
var urlListJSONObject = ${urlListJSONObject}; // career path url List
var competencyObject = ${competencyJSONObject}; // competency list saved in preferences - linked with functional group & joblevel categories
var careerUrlJSONObject = ${careerUrlJSONObject}; // career path url saved in preferences - linked with functional group & joblevel categories
var j=true;

function populateSavedPreferences() {
	var count = 0;
	var key1;
	var e = document.getElementById("_JobRole_WAR_ExtendedProfileportlet_jobRoleVocabulary");
	var vId = e.options[e.selectedIndex].value;
	for (key in jobLevelJSONObject) {
		count=count+1;
	}
	for (key in jobLevelJSONObject) {
		var jobLevelCategories = jobLevelJSONObject[key];
		key1 = key;
		for (var i=0;i<count;i++) {
			var jLSelect = document.getElementById("jobLevelVocabulary_"+i);
			jLSelect.setAttribute("onchange","javascript:jobLevelPrefOnchange('jobLevelVocabulary_','populateJobCompetenciesInPref', " + vId + "," + i + " , 'false')");
			var jLDiv = document.getElementById("jobrole_"+i);
			if (jLDiv.value == key1) {
				for (key in jobLevelCategories) {
					for (var jl = 1; jl < jLSelect.length; jl++) {
						var optValue = jLSelect.options[jl];
						if (optValue.value == key)
							optValue.selected = true;
					}
				}
			}
			jobLevelPrefOnchange('jobLevelVocabulary_','populateJobCompetenciesInPref', vId , i,'true');
		}
	}
}

function jobRolePrefOnchange(Id,type) {

	var e = document.getElementById("_JobRole_WAR_ExtendedProfileportlet_"+Id);
	var vId = e.options[e.selectedIndex].value;
	e.setAttribute("value",vId);
	var groupDiv = document.getElementById("FuncGroup_Id");
	groupDiv.innerHTML="";
	var levelCategoryDiv = document.getElementById("FuncGroup_Values");
	levelCategoryDiv.innerHTML="";

	//levelDiv.innerHTML = "";
	var categoryJSONObject = assetCategoriesJSONObject[vId];
	var i=0;
	for (key in categoryJSONObject) {
		var category = categoryJSONObject[key];
		var competencyDiv = document.createElement("Div");
		competencyDiv.setAttribute("class","competencyDiv");
		var divElement1 = document.createElement("Div");
		var divElement2 = document.createElement("Div");
		var jobLevelDiv = document.createElement("Div");
		var levelDiv = document.createElement("Div");
		var titleDiv = document.createElement("Div");
		titleDiv.setAttribute("style","margin-bottom: 20px;");
		titleDiv.innerHTML = "<b> <span style='margin-right: 120px;'>Job Level</span> <span style='margin-right: 65px;'>Competencies</span> <span>CareerPath Url </span></b>";
		levelDiv.setAttribute("class","jobLevel_select");
		var roleDiv = document.createElement("Div");
		roleDiv.setAttribute("class","funcGroup_list");
		jobLevelDiv.setAttribute("Id","FuncGroup_JobLevelValues_"+i);
		jobLevelDiv.setAttribute("class","FuncGroup");
		var inputElement1 = document.createElement("Input");
		var inputElement2 = document.createElement("Input");
		inputElement1.type = "hidden";
		inputElement1.value = key;
		inputElement1.setAttribute("id","jobrole_"+i);
		inputElement2.type = "hidden";
		inputElement2.value = key;
		divElement1.innerHTML = category;
		divElement1.setAttribute("class","jobLevelSelect");
		divElement2.innerHTML = "<b>Functional Group</b> - " + category;
	   	divElement2.setAttribute("class","jobLevelSelect");
		divElement1.appendChild(inputElement1);
		divElement2.appendChild(inputElement2);
		roleDiv.appendChild(divElement1);
		//groupDiv.appendChild(divElement2);
		//levelCategoryDiv.appendChild(divElement1);
		competencyDiv.appendChild(divElement2);
		competencyDiv.appendChild(titleDiv);
		competencyDiv.appendChild(jobLevelDiv);
		levelCategoryDiv.appendChild(competencyDiv);
		var selectId = "jobLevelVocabulary_"+i;
		var jobLevelSelect = document.createElement("Select");
		var jobLOption = document.createElement("Option");
		jobLOption.text = "";
		jobLOption.value = "0";
		jobLevelSelect.options.add(jobLOption);
		jobLevelSelect.setAttribute("class","jobLevelSelect");
		jobLevelSelect.setAttribute("name","jobLevel_"+key);
		jobLevelSelect.setAttribute("id",selectId);
		jobLevelSelect.setAttribute("label","");
		jobLevelSelect.setAttribute("onchange","javascript:jobLevelPrefOnchange('jobLevelVocabulary_','populateJobCompetenciesInPref', " + vId + "," + i + ",'false')");

		for (vocabularyId in assetVocabulariesJSONObject) {
			var vocabulary = assetVocabulariesJSONObject[vocabularyId];
			var jobLevelOption = document.createElement("Option");
			jobLevelOption.text = vocabulary;
			jobLevelOption.value = vocabularyId;
			jobLevelSelect.options.add(jobLevelOption);
		}
		levelDiv.appendChild(jobLevelSelect);
		var mainDiv = document.createElement("Div");
		mainDiv.appendChild(roleDiv);
		mainDiv.appendChild(levelDiv);
		groupDiv.appendChild(mainDiv);
		i=i+1;
	}

}

function jobLevelPrefOnchange(Id,type,cId,order,selectOption) {

	 	var e = document.getElementById(Id + order);
		var vId = e.options[e.selectedIndex].value;
		//alert("vID " + vId);
		var categoryJSONObject = assetCategoriesJSONObject[vId];
		var i=0;
		var levelDiv = document.getElementById("FuncGroup_JobLevelValues_"+order);
		//alert("levelDiv " + levelDiv);
		//var levelDivSelect = document.getElementById("Competencies_voc");
		//if (j)
			levelDiv.innerHTML = "";
			//levelDivSelect.innerHTML = "";

		j=false;
		if (selectOption == 'true') {
			var e1 = document.getElementById("Competency_FuncGroup_" + order);
			var cId = e1.value;
			var competencyLevelObject = competencyObject[cId];
			var careerUrlObject = careerUrlJSONObject[cId];
		}
		for (key in categoryJSONObject) {
	        var category = categoryJSONObject[key];
	        var categoryKey = key;
	        //alert("category key " + key);
	        var jobLevelMainDiv = document.createElement("Div");
	        var competencyDiv = document.createElement("Div");
	        competencyDiv.setAttribute("class","competencyDiv");
	        jobLevelMainDiv.setAttribute("class","JobLevel_Main");
	        var divElement1 = document.createElement("Div");
	        var inputElement = document.createElement("Input");
	        inputElement.type = "hidden";
	        divElement1.innerHTML = category;
	        divElement1.setAttribute("class","jobLevelSelect funcGroup_list");
	        inputElement.value = key;
	        divElement1.appendChild(inputElement);
	        var jobLevelSelect = document.createElement("Select");
	        var jobLOption = document.createElement("Option");
	        jobLOption.text = "";
	        jobLOption.value = "0";
			jobLevelSelect.options.add(jobLOption);
	        jobLevelSelect.setAttribute("name","competency_"+key);
	        jobLevelSelect.setAttribute("class","select_width");
	        var urlSelect = document.createElement("Select");
	        urlSelect.setAttribute("class","jobLevelSelect select_width");
	        urlSelect.setAttribute("name","url_"+key);
	        jobLevelMainDiv.appendChild(divElement1);
	        for (vocabularyId in assetVocabulariesJSONObject) {
	        	var vocabulary = assetVocabulariesJSONObject[vocabularyId];
	        	var jobLevelOption = document.createElement("Option");
	        	jobLevelOption.text = vocabulary;
	        	jobLevelOption.value = vocabularyId;
	        	jobLevelSelect.options.add(jobLevelOption);
	        	if (selectOption == 'true') {
		        	for (key in competencyLevelObject) {
		        		//alert("key " + key);
		                var comp = competencyLevelObject[categoryKey];
		                //alert("comp " + comp);
		                if (comp == vocabularyId)
		                	jobLevelOption.selected = true;
		        	}
	        	}
	        }
	        jobLevelMainDiv.appendChild(jobLevelSelect);
	        //levelDiv.appendChild(jobLevelMainDiv);

	        // select for careerUrl path

	        for (key in urlListJSONObject) {
				var urlOption = document.createElement("Option");
		        urlOption.text = urlListJSONObject[key];
		        var urlOptionId = key;
		        urlOption.value = key;
		        urlSelect.options.add(urlOption);
		        if (selectOption == 'true') {
			        for (key in careerUrlObject) {
		        		//alert("key " + key);
		                var url = careerUrlObject[categoryKey];
		                //alert("comp " + comp);
		                if (url == urlOptionId)
		                	urlOption.selected = true;
		        	}
		        }
			}
	        jobLevelMainDiv.appendChild(urlSelect);
	        levelDiv.appendChild(jobLevelMainDiv);

		}

	}

</script>

<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="<%= Constants.EDIT %>"></portlet:param>
</portlet:actionURL>

<aui:form action="<%= editActionURL %>" method="post">
	<div class="reg-outer-wrap">
		<aui:layout cssClass="reg-content-wrap">
			 <c:if test="${success_update}">
				<div class="portlet-msg-success">Registration parameters successfully updated!</div>
			</c:if>
			<aui:layout cssClass="pref-row-content">
				<aui:column cssClass="left-align pref-label" first="true">
					<label>Functional Group Configuration</label>
					<div class="seperatedline"></div>
				</aui:column>
				<aui:column>
					<aui:select id="jobRoleVocabulary" label="" name="jobRole" onchange="javascript:jobRolePrefOnchange('jobRoleVocabulary','populateJobLevelInPref')" value="${jobRole}">
						<aui:option label="" value="0"></aui:option>
						<c:forEach items="${assetVocabularies}" var="assetVocabulary">
							<c:choose>
								<c:when test="${assetVocabulary.vocabularyId == jobRole}">
									<aui:option label="${assetVocabulary.name}" selected="true" value="${assetVocabulary.vocabularyId}"></aui:option>
								</c:when>
								<c:otherwise>
									<aui:option label="${assetVocabulary.name}" value="${assetVocabulary.vocabularyId}"></aui:option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</aui:select>
				</aui:column>
				</aui:layout>
				<aui:layout cssClass="pref-row-content">
					<aui:column cssClass="left-align pref-label" first="true">
						<label>Job Level Configuration</label>
						<div class="seperatedline"></div>
					</aui:column>
					<aui:column cssClass="left-align" style="width:100%">
					<div style="margin-bottom: 20px;"><b> <span style="margin-right: 99px;">Functional group</span> <span>Job Level</span></b></div>
						<div class="FuncGroup" id="FuncGroup_Id">
						<% int k=0; %>
							<c:forEach items="${assetCategory}" var="assetCategory">
								<div>
									<div class="funcGroup_list">
										<div class="jobLevelSelect">${assetCategory.name}</div>
										<div>
											<input id="jobrole_<%= k %>" type="hidden" value="${assetCategory.categoryId}">
										</div>
									</div>
									<div class="jobLevel_select" id="JobLevel_Values">
										 <select name="jobLevel_${assetCategory.categoryId}" id="jobLevelVocabulary_<%= k %>" label="" onchange="javascript:jobLevelPrefOnchange('jobLevelVocabulary_','populateJobCompetenciesInPref',${assetCategory.categoryId},<%= k %>,'false')">
											<option label="" value="0"></option>
												<c:forEach items="${assetVocabularies}" var="assetVocabulary">
													<option label="" value="${assetVocabulary.vocabularyId}">${assetVocabulary.name}</option>
												</c:forEach>
											</select>
									</div>
								</div>
								<%k=k+1; %>
							</c:forEach>
						</div>
					</aui:column>
			</aui:layout>
			<aui:layout cssClass="pref-row-content">
					<aui:column cssClass="left-align pref-label" first="true">
						<label>Competencies Configuration</label>
						<div class="seperatedline"></div>
					</aui:column>
					<aui:column cssClass="left-align" style="width:100%">
						<div class="FuncGroup_joblevel" id="FuncGroup_Values">
						<%int m=0; %>
							<c:forEach items="${assetCategory}" var="assetCategory">
								<div style="margin-bottom: 20px;">
								<div class="jobLevelSelect" id="jobLevelCategory_<%= m %>"><b>Functional Group - </b>${assetCategory.name}
									<input id="Competency_FuncGroup_<%= m %>" name="Competency_FuncGroup" type="hidden" value="${assetCategory.categoryId}">
								</div>
								<div style="margin-bottom: 20px;"><b> <span style="margin-right: 120px;">Job Level</span> <span style="margin-right: 65px;">Competencies</span> <span>CareerPath Url </span></b></div>
								<div class="FuncGroup" id="FuncGroup_JobLevelValues_<%= m %>">
									<div></div>
									<select label="" name="competency_${assetCategory.categoryId}">
									<option label="" value="0"></option>
									<c:forEach items="${assetVocabularies}" var="assetVocabulary">
										<option label="" value="${assetVocabulary.vocabularyId}">${assetVocabulary.name}</option>
									</c:forEach>
								</select>
								</div>
								</div>
							<%m=m+1; %>
							</c:forEach>
						</div>
					</aui:column>
			</aui:layout>

			<aui:layout cssClass="pref-row-content">
				<aui:column cssClass="left-align" first="true">
					<aui:button name="save" type="submit" value="Save Changes" />
				</aui:column>
			</aui:layout>
		</aui:layout>
	</div>
</aui:form>

<script type="text/javascript">
populateSavedPreferences();
</script>

<!--

//-->
</script>