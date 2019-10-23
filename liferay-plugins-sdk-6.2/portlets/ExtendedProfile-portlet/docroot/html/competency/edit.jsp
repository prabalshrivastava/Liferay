<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<portlet:resourceURL var="editResourceURL">
	<portlet:param name="action" value="<%= Constants.EDIT %>"></portlet:param>
</portlet:resourceURL>

<div class="portlet-msg-success hide" id="msg_success_<portlet:namespace />"> Your request completed successfully. </div>

<b>Configuration Settings</b>

<br />
<br />

<select id="levelOne_<portlet:namespace />" name="levelOneId" onchange="javascript:levelOneOnChange(this.options[this.selectedIndex].value)">
	<option value=""></option>
	<c:forEach items="${assetVocabularies}" var="av">
		<option <c:if test="${savedLevelOneId == av.vocabularyId}">selected="selected"</c:if> value="${av.vocabularyId}">${av.name}</option>
	</c:forEach>
</select>

<br />
<br />

<table id="levelTwoAndLevelThree_<portlet:namespace />" style="width: 100%;"></table>

<br />

<a href="#" onclick="javascript:saveOnClickCompetency(event)">Save</a>

<script type="text/javascript">

	function initLevelTwoAndLevelThree() {
	try{
		var savedLevelOneId = '${savedLevelOneId}';
		var savedLevelTwoIdAndLevelThreeIdJSONObject = ${savedLevelTwoIdAndLevelThreeIdJSONObject};
		if (savedLevelOneId.length > 0) {
			generateLevelTwoAndLevelThree(savedLevelOneId, true, savedLevelTwoIdAndLevelThreeIdJSONObject);
		}
	}catch(err) {
		alert(err);
	}
	}

	function levelOneOnChange(levelOneId) {
	try{
		var savedLevelOneId = '${savedLevelOneId}';
		if ((savedLevelOneId.length > 0) && (levelOneId == savedLevelOneId)) {
			var savedLevelTwoIdAndLevelThreeIdJSONObject = ${savedLevelTwoIdAndLevelThreeIdJSONObject};
			generateLevelTwoAndLevelThree(savedLevelOneId, true, savedLevelTwoIdAndLevelThreeIdJSONObject);
		}else {
			generateLevelTwoAndLevelThree(levelOneId, false, null);
		}
	}catch(err) {
		alert(err);
	}
	}

	function generateLevelTwoAndLevelThree(levelOneId, initDefaultValue, levelTwoIdAndLevelThreeIdJSONObject) {
	try{
	    var levelTwoAndLevelThreeTable = document.getElementById("levelTwoAndLevelThree_<portlet:namespace />");
	    var rowCount = levelTwoAndLevelThreeTable.rows.length;

	    for (var i=0; i<rowCount; i++) {
	    	levelTwoAndLevelThreeTable.deleteRow(i);
	        rowCount--;
	        i--;
	    }

		var vocabulariesJSONObject = ${vocabulariesJSONObject};
		var vocabulariesOnlyJSONObject = ${vocabulariesOnlyJSONObject};
		var categoriesJSONObject = vocabulariesJSONObject[levelOneId];

		for (levelTwoId in categoriesJSONObject) {
			var rowCount = levelTwoAndLevelThreeTable.rows.length;
			var row = levelTwoAndLevelThreeTable.insertRow(rowCount);

			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);

		    var levelTwoSpan = document.createElement("SPAN");
		    levelTwoSpan.appendChild(document.createTextNode(categoriesJSONObject[levelTwoId]));
		    levelTwoSpan.setAttribute("data-level-two-id", levelTwoId);

	        var levelThreeSelectBox = document.createElement("Select");
	        levelThreeSelectBox.name = "levelThreeSelectBox";
	        var levelThreeSelectBoxEmptyOption = document.createElement("OPTION");
	        levelThreeSelectBoxEmptyOption.text = "";
	        levelThreeSelectBoxEmptyOption.value = "";
	        levelThreeSelectBox.options.add(levelThreeSelectBoxEmptyOption);
	        for (levelThreeId in vocabulariesOnlyJSONObject) {
		        var levelThreeSelectBoxOption = document.createElement("OPTION");
		        levelThreeSelectBoxOption.text = vocabulariesOnlyJSONObject[levelThreeId];
		        levelThreeSelectBoxOption.value = levelThreeId;
		        if (initDefaultValue) {
			        if (levelThreeId == levelTwoIdAndLevelThreeIdJSONObject[levelTwoId]) {
				        levelThreeSelectBoxOption.selected = true;
			        }
		        }
		        levelThreeSelectBox.options.add(levelThreeSelectBoxOption);
	        }

	        cell1.appendChild(levelTwoSpan);
	        cell2.appendChild(levelThreeSelectBox);

		}

	}catch(err) {
		alert(err);
	}
	}

	function saveOnClickCompetency(e) {
		try{
			preventDefault(e);
		    var levelTwoAndLevelThreeTable = document.getElementById("levelTwoAndLevelThree_<portlet:namespace />");
		    var levelOneSelectBox = document.getElementById("levelOne_<portlet:namespace />")
		    var levelOneId = levelOneSelectBox.options[levelOneSelectBox.selectedIndex].value;

		    //document.title += "-levelOneId: " + levelOneId;

		    var rows = levelTwoAndLevelThreeTable.rows;
		    var levelTwoAndLevelThreeParams = "";
		    for (var i=0; i<rows.length; i++) {
		    	var row = rows[i];
		    	var levelTwoSpan = row.cells[0].childNodes[0];
		    	var levelTwoText = levelTwoSpan.innerHTML;
		    	var levelTwoId = levelTwoSpan.getAttribute("data-level-two-id");
			    //document.title += "-levelTwoId: " + levelTwoId;
		    	var levelThreeSelectBox = row.cells[1].childNodes[0];
			    var levelThreeId = levelThreeSelectBox.options[levelThreeSelectBox.selectedIndex].value;
			    //document.title += "-levelThreeId: " + levelThreeId;
			    if (levelThreeId.length >0) {
		    	 	if (levelTwoAndLevelThreeParams.length > 0) {
						levelTwoAndLevelThreeParams += ",";
				    }
				    levelTwoAndLevelThreeParams += levelTwoId + "-" + levelThreeId;
			    }
		    }

			var temp_url = '<%= editResourceURL %>';
			temp_url += "&levelOneId=" + levelOneId + "&levelTwoAndLevelThreeParams=" + levelTwoAndLevelThreeParams;
			AjaxGet(temp_url, editSuccess, editError);

		}catch(err) {
			alert(err);
		}
	}

	function editSuccess() {
	try{
		//document.title += "-editSuccess";
	    var msg_success = document.getElementById("msg_success_<portlet:namespace />");
	    removeClass(msg_success, "aui-helper-hidden");

	}catch(err) {
		alert(err);
	}
	}

	function editError() {
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

	AUI().ready(function(A) {
		initLevelTwoAndLevelThree();
	});

</script>