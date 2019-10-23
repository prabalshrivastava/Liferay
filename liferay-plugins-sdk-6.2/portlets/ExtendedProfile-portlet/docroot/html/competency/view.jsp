<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<portlet:resourceURL var="saveOneResourceURL">
	<portlet:param name="action" value="saveOne"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="deleteOneResourceURL">
	<portlet:param name="action" value="deleteOne"></portlet:param>
</portlet:resourceURL>

<div>
	<span class="panel-hd-text">
		<font class="header-pretitle">Other </font>
		<font class="header-posttitle">
			Competencies
		</font>
		</span>
</div>
<div class="showdowheader-profile"></div>
<div><font class="header-pretitle" style="padding-left: 0;">based on</font><a href="http://www.nicf.sg" target="blank" class="header-posttitle"> National Infocomm Competency framework.</a></div>
<c:if test="${editable}"><div class="workhistory_editAlignExt"><a href="#" title="add" onclick="javascript:addOtherCompetenciesContainer(event)" class="userprofile-add-link">&nbsp;</a></div></c:if>
<br />
<br />

<div id="all_other_competencies_container_<portlet:namespace />" style="clear: both;">
	<span class="hide">dummy text</span>
	<c:forEach items="${otherCompetenciesWrappers}" var="otherCompetenciesWrapper">
		<div data-category-id="${otherCompetenciesWrapper.categoryId}" data-competency-dom-id="other-competencies-container">
			<div>
				<c:if test="${editable}"><div class="workhistory_editAlignExt"><a href="#" title="edit" onclick="javascript:editOneOnClick(event)" data-competencies="${otherCompetenciesWrapper.competenciesJSONData}" class="userprofile-edit-linkExt">&nbsp;</a> <a href="#" title="delete" onclick="javascript:deleteOneOnClick(event)" class="userprofile-delete-link">&nbsp;</a></div></c:if>
				<div class="maindivpersonalInfo">
					<div class="content-title">
						Category
						<div class="seperatedline"></div>
					</div>
					<div class="left-align-content basicinfo-textedit">
						${otherCompetenciesWrapper.categoryName}
					</div>
				</div>
				<div class="maindivpersonalInfo">
					<div class="content-title">
						Competencies
						<div class="seperatedline"></div>
					</div>
					<div class="left-align-content basicinfo-textedit">
						<table style="width: 100%;">
							<c:forEach items="${otherCompetenciesWrapper.competencyLevelWrappers}" var="competencyLevelWrapper">
								<tr><td style="width: 70%;"><p>${competencyLevelWrapper.competencyName}</p></td><td style="width: 30%;">${competencyLevelWrapper.levelName}</td></tr>
							</c:forEach>
						</table>
						<br />
					</div>
				</div>
			</div>
		</div>
		<div class="hide" data-competency-dom-id="other-competencies-container-edit" data-edit-category-id="${otherCompetenciesWrapper.categoryId}">
			<div>
				<c:if test="${editable}"><div class="workhistory_editAlignExt"><a href="#" title="edit" onclick="javascript:editOneOnClick(event)" data-competencies="${otherCompetenciesWrapper.competenciesJSONData}" class="userprofile-edit-linkExt">&nbsp;</a> <a href="#" title="delete" onclick="javascript:deleteOneOnClick(event)" class="userprofile-delete-link">&nbsp;</a></div></c:if>
				<div class="maindivpersonalInfo">
					<div class="content-title">
						Category
						<div class="seperatedline"></div>
					</div>
					<div class="left-align-content basicinfo-textedit">
						${otherCompetenciesWrapper.categoryName}
					</div>
				</div>
				<div class="maindivpersonalInfo">
					<div class="content-title">
						Competencies
						<div class="seperatedline"></div>
					</div>
					<div class="left-align-content basicinfo-textedit">
						<table style="width: 100%;">
							<c:forEach items="${otherCompetenciesWrapper.competencyLevelWrappers}" var="competencyLevelWrapper">
								<tr><td style="width: 70%;"><p>${competencyLevelWrapper.competencyName}</p></td><td style="width: 30%;">${competencyLevelWrapper.levelName}</td></tr>
							</c:forEach>
						</table>
						<br />
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<div class="hide" id="other_competencies_container_template_box_<portlet:namespace />">
	<div data-competency-dom-id="other-competencies-container">
		<div>
			<div class="workhistory_editAlignExt"><a class="undo-button" href="#" onclick="javascript:cancelOneOnClick(event)" title="cancel">&nbsp;</a><a class="update-button" href="#" onclick="javascript:saveOneOnClick(event)" title="save">&nbsp;</a></div>
			<div class="maindivpersonalInfo">
				<div class="content-title">
					Category
					<div class="seperatedline"></div>
				</div>
				<div class="left-align-content basicinfo-textedit">
					<select data-competency-dom-id="category-select-box" onchange="javascript:categoryOnChange(event, this.options[this.selectedIndex].value)">
						<option value=""></option>
						<c:forEach items="${assetCategories}" var="ac">
							<option value="${ac.categoryId}">${ac.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="maindivpersonalInfo">
				<div class="hide" data-competency-dom-id="competencies-levels-container">
					<div class="content-title">
						Competencies
						<div class="seperatedline"></div>
					</div>
					<div class="left-align-content basicinfo-textedit">
						<table data-competency-dom-id="competencies-levels" style="width: 100%;"></table>
					</div>
				</div>
			</div>
			<br />
		</div>
	</div>
</div>

<script type="text/javascript">

	var xhr;

	function categoryOnChange(e, categoryId) {
	try{
		if (categoryId.length > 0) {
			var target = getEventTarget(e);
			var otherCompetenciesContainer = getClosestParentByAttribute(target, "data-competency-dom-id", "other-competencies-container");
		    var competenciesLevelsContainer = getFirstElementsByAttribute(otherCompetenciesContainer, "div", "data-competency-dom-id", "competencies-levels-container");
		    var allOtherCompetenciesContainer = document.getElementById("all_other_competencies_container_<portlet:namespace />");
		    var existingOtherCompetenciesContainer = getFirstElementsByAttribute(allOtherCompetenciesContainer, "div", "data-category-id", categoryId);

		    var alertMsg = getFirstElementsByAttribute(otherCompetenciesContainer, "span", "data-competency-dom-id", "alert-msg");
		    if (alertMsg) {
			    alertMsg.parentNode.removeChild(alertMsg);
		    }
		    if (existingOtherCompetenciesContainer) {
		    	addClass(competenciesLevelsContainer, "hide");
		        var alertSpan = document.createElement("SPAN");
		        alertSpan.setAttribute("data-competency-dom-id", "alert-msg");
		        alertSpan.appendChild(document.createTextNode("The category you selected already exists!"));
		        getLastChild(getPreviousSibling(competenciesLevelsContainer.parentNode)).appendChild(alertSpan);
		    }else {
				removeClass(competenciesLevelsContainer, "hide");
				generateCompetencies(otherCompetenciesContainer, categoryId, false, null);
		    }
		}

	}catch(err) {
		alert(err);
	}
	}

	function generateCompetencies(otherCompetenciesContainer, categoryId, initDefaultValue, selectedCompetenciesJSONObject) {
	try{
		//document.title += "-categoryId: " + categoryId;
		//document.title += "-selectedCompetenciesJSONObject: " + selectedCompetenciesJSONObject;
	    var competenciesLevelsTable = getFirstElementsByAttribute(otherCompetenciesContainer, "table", "data-competency-dom-id", "competencies-levels");

		//document.title += "-competenciesLevelsTable: " + competenciesLevelsTable;

	    var rowCount = competenciesLevelsTable.rows.length;

	    for (var i=0; i<rowCount; i++) {
	    	competenciesLevelsTable.deleteRow(i);
	        rowCount--;
	        i--;
	    }

		var savedLevelTwoIdAndLevelThreeIdJSONObject = ${savedLevelTwoIdAndLevelThreeIdJSONObject};
		var vocabulariesJSONObject = ${vocabulariesJSONObject};

		var savedLevelThreeId = savedLevelTwoIdAndLevelThreeIdJSONObject[categoryId];
		//document.title += "-savedLevelThreeId: " + savedLevelThreeId;

		var competenciesJSONObject = vocabulariesJSONObject[savedLevelThreeId];
		var levelJSONObject = ${levelJSONObject};

		for (levelTwoId in competenciesJSONObject) {
			var rowCount = competenciesLevelsTable.rows.length;
			var row = competenciesLevelsTable.insertRow(rowCount);

			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);

		    var competencySpan = document.createElement("SPAN");
		    competencySpan.appendChild(document.createTextNode(competenciesJSONObject[levelTwoId]));
		    competencySpan.setAttribute("data-competency-id", levelTwoId);

	        var levelSelectBox = document.createElement("Select");
	        levelSelectBox.name = "levelSelectBox";
	        var levelSelectBoxEmptyOption = document.createElement("OPTION");
	        levelSelectBoxEmptyOption.text = "";
	        levelSelectBoxEmptyOption.value = "";
	        levelSelectBox.options.add(levelSelectBoxEmptyOption);

	        for (key in levelJSONObject) {
		        var levelSelectBoxOption = document.createElement("OPTION");
		        levelSelectBoxOption.text = levelJSONObject[key];
		        levelSelectBoxOption.value = key;
		        if (initDefaultValue) {
			        if (key == selectedCompetenciesJSONObject[levelTwoId]) {
			        	levelSelectBoxOption.selected = true;
			        }
		        }
		        levelSelectBox.options.add(levelSelectBoxOption);
	        }

	        cell1.appendChild(competencySpan);
	        cell2.appendChild(levelSelectBox);
		}

	}catch(err) {
		alert(err);
	}
	}

	function addOtherCompetenciesContainer(e) {
	try{
		preventDefault(e);
	    var otherCompetenciesContainerTemplateBox = document.getElementById("other_competencies_container_template_box_<portlet:namespace />");
	    var allOtherCompetenciesContainer = document.getElementById("all_other_competencies_container_<portlet:namespace />");

	    var otherCompetenciesContainerTemplate = getFirstChild(otherCompetenciesContainerTemplateBox);
		//document.title += "-otherCompetenciesContainerTemplate: " + otherCompetenciesContainerTemplate;
		//document.title += "-allOtherCompetenciesContainer.firstChild: " + allOtherCompetenciesContainer.firstChild;

	    allOtherCompetenciesContainer.insertBefore(otherCompetenciesContainerTemplate.cloneNode(true), getFirstChild(allOtherCompetenciesContainer));
	    //allOtherCompetenciesContainer.appendChild(otherCompetenciesContainerTemplate.cloneNode(true));

	}catch(err) {
		alert(err);
	}
	}

	function cancelOneOnClick(e) {
	try{
		preventDefault(e);

		var target = getEventTarget(e);
		var otherCompetenciesContainer = getClosestParentByAttribute(target, "data-competency-dom-id", "other-competencies-container");

		var categoryId = otherCompetenciesContainer.getAttribute("data-category-id");

		if (categoryId) {
		    var allOtherCompetenciesContainer = document.getElementById("all_other_competencies_container_<portlet:namespace />");
		    var otherCompetenciesContainerEdit = getFirstElementsByAttribute(allOtherCompetenciesContainer, "div", "data-edit-category-id", categoryId);

		    otherCompetenciesContainer.innerHTML = "";
		    otherCompetenciesContainer.appendChild(getFirstChild(otherCompetenciesContainerEdit).cloneNode(true));
		}else {
			otherCompetenciesContainer.parentNode.removeChild(otherCompetenciesContainer);
		}
	}catch(err) {
		alert(err);
	}
	}

	function saveOneOnClick(e) {
	try{
		preventDefault(e);

		var target = getEventTarget(e);
		var otherCompetenciesContainer = getClosestParentByAttribute(target, "data-competency-dom-id", "other-competencies-container");
	    var competenciesLevelsTable = getFirstElementsByAttribute(otherCompetenciesContainer, "table", "data-competency-dom-id", "competencies-levels");
	    var categorySelectBox = getFirstElementsByAttribute(otherCompetenciesContainer, "select", "data-competency-dom-id", "category-select-box");

	    var categoryId = categorySelectBox.options[categorySelectBox.selectedIndex].value;

	    //document.title += "-categoryId: " + categoryId;
	    otherCompetenciesContainer.setAttribute("data-category-id", categoryId);

	    var rows = competenciesLevelsTable.rows;
	    var competencyAndLevelParams = "";
	    for (var i=0; i<rows.length; i++) {
	    	var row = rows[i];
	    	var competencySpan = row.cells[0].childNodes[0];
	    	var competencyText = competencySpan.innerHTML;
	    	var competencyId = competencySpan.getAttribute("data-competency-id");
		    //document.title += "-competencyId: " + competencyId;
	    	var levelSelectBox = row.cells[1].childNodes[0];
		    var levelId = levelSelectBox.options[levelSelectBox.selectedIndex].value;
		    //document.title += "-levelId: " + levelId;
		    if (levelId.length >0) {
	    	 	if (competencyAndLevelParams.length > 0) {
	    	 		competencyAndLevelParams += ",";
			    }
	    	 	competencyAndLevelParams += competencyId + "-" + levelId;
		    }
	    }

		var temp_url = '<%= saveOneResourceURL %>';
		temp_url += "&categoryId=" + categoryId + "&competencyAndLevelParams=" + competencyAndLevelParams;
		AjaxGet(temp_url, saveOneSuccess, saveOneError);

	}catch(err) {
		alert(err);
	}
	}

	function saveOneSuccess() {
	try{
		var responseText = trimStr(xhr.responseText);
		if (responseText.length > 0) {
			var data = JSON.parse(xhr.responseText);
			//document.title += "-data.categoryId: " + data.categoryId;
		    var allOtherCompetenciesContainer = document.getElementById("all_other_competencies_container_<portlet:namespace />");
		    var otherCompetenciesContainer = getFirstElementsByAttribute(allOtherCompetenciesContainer, "div", "data-category-id", data.categoryId);

		    var dataHtml = trimStr(data.html);
		    if (dataHtml.length > 0) {
				var temp_div1 = document.createElement("DIV");
				temp_div1.innerHTML = dataHtml;
				var temp_div2 = document.createElement("DIV");
				temp_div2.innerHTML = dataHtml;
				var otherCompetenciesContainerEdit = null;
			    if (data.edit) {
			    	otherCompetenciesContainerEdit = getFirstElementsByAttribute(allOtherCompetenciesContainer, "div", "data-edit-category-id", data.categoryId);
			    }else {
			    	otherCompetenciesContainerEdit = document.createElement("DIV");
			    	addClass(otherCompetenciesContainerEdit, "aui-helper-hidden");
			    	otherCompetenciesContainerEdit.setAttribute("data-edit-category-id", data.categoryId);
			    	otherCompetenciesContainerEdit.setAttribute("data-competency-dom-id", "other-competencies-container-edit");
			    }
			    otherCompetenciesContainerEdit.innerHTML = "";
			    otherCompetenciesContainerEdit.appendChild(getFirstChild(getFirstChild(temp_div2)));
			    allOtherCompetenciesContainer.insertBefore(getFirstChild(temp_div1), otherCompetenciesContainer);
			    allOtherCompetenciesContainer.insertBefore(otherCompetenciesContainerEdit, otherCompetenciesContainer);
		    }
		    otherCompetenciesContainer.parentNode.removeChild(otherCompetenciesContainer);
		}

	}catch(err) {
		alert(err);
	}
	}

	function saveOneError() {
		alert("Oops! An unexpected error occurred while processing your request.");
	}

	function editOneOnClick(e) {
	try{
		preventDefault(e);
		var target = getEventTarget(e);
		var competenciesData = JSON.parse(target.getAttribute("data-competencies"), "");
		addClass(target, "hide");
		var otherCompetenciesContainer = getClosestParentByAttribute(target, "data-competency-dom-id", "other-competencies-container");
		//var categoryId = otherCompetenciesContainer.getAttribute("data-category-id");
		var categoryId = competenciesData.categoryId;

		var otherCompetenciesContainerTemplateBox = document.getElementById("other_competencies_container_template_box_<portlet:namespace />");
	    var otherCompetenciesContainerTemplate = getFirstChild(otherCompetenciesContainerTemplateBox);
	    var otherCompetenciesContainerEdit = otherCompetenciesContainerTemplate.cloneNode(true);

	    otherCompetenciesContainerEdit.setAttribute("data-category-id", categoryId);
	    var competenciesLevelsContainer = getFirstElementsByAttribute(otherCompetenciesContainerEdit, "div", "data-competency-dom-id", "competencies-levels-container");
	    removeClass(competenciesLevelsContainer, "hide");
	    var competenciesLevelsTable = getFirstElementsByAttribute(otherCompetenciesContainerEdit, "table", "data-competency-dom-id", "competencies-levels");

	    var categorySelectBox = getFirstElementsByAttribute(otherCompetenciesContainerEdit, "select", "data-competency-dom-id", "category-select-box");
	    for (var i=0; i<categorySelectBox.options.length; i++) {
	    	var categorySelectBoxOption = categorySelectBox.options[i];
	    	if (categorySelectBoxOption.value == categoryId) {
	    		categorySelectBoxOption.selected = true;
	    	}
	    }
	    var selectedCompetenciesJSONObject = competenciesData.competencies;

		generateCompetencies(otherCompetenciesContainerEdit, categoryId, true, selectedCompetenciesJSONObject);

		addClass(otherCompetenciesContainer, "hide");
	    var allOtherCompetenciesContainer = document.getElementById("all_other_competencies_container_<portlet:namespace />");

	    allOtherCompetenciesContainer.insertBefore(otherCompetenciesContainerEdit, otherCompetenciesContainer);
	    otherCompetenciesContainer.parentNode.removeChild(otherCompetenciesContainer);

	}catch(err) {
		alert(err);
	}
	}

	function deleteOneOnClick(e) {
	try{
		preventDefault(e);
		if (confirm("Are you sure to delete these competencies?")) {
			var target = getEventTarget(e);
			var otherCompetenciesContainer = getClosestParentByAttribute(target, "data-competency-dom-id", "other-competencies-container");
			var categoryId = otherCompetenciesContainer.getAttribute("data-category-id");

			var temp_url = '<%= deleteOneResourceURL %>';
			temp_url += "&categoryId=" + categoryId;
			AjaxGet(temp_url, deleteOneSuccess, deleteOneError);
		}

	}catch(err) {
		alert(err);
	}
	}

	function deleteOneSuccess() {
	try{
		var data = JSON.parse(xhr.responseText);
		//document.title += "-data.categoryId: " + data.categoryId;
	    var allOtherCompetenciesContainer = document.getElementById("all_other_competencies_container_<portlet:namespace />");
	    var otherCompetenciesContainer = getFirstElementsByAttribute(allOtherCompetenciesContainer, "div", "data-category-id", data.categoryId);

	    allOtherCompetenciesContainer.removeChild(otherCompetenciesContainer);

	}catch(err) {
		alert(err);
	}
	}

	function deleteOneError() {
		alert("Oops! An unexpected error occurred while processing your request.");
	}

	/**
	* Ajax Get
	*/
	function AjaxGet(url, successFunc, errorFunc) {
	try{
		if (window.XMLHttpRequest) {
			// code for IE7+, Firefox, Chrome, Opera, Safari
		  	xhr = new XMLHttpRequest();
		}
		else {
			// code for IE6, IE5
		 	xhr = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
			    if (xhr.status == 200) {
			    	successFunc();
			    }
			    else {
			    	errorFunc();
			    }
			}
		};

	   xhr.open("GET", url, true);
	   xhr.send(null);

	}catch(err) {
		alert(err);
	}
	}

</script>