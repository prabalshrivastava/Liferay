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

<a href="#" onclick="javascript:saveOnClick(event)">Save</a>

<script type="text/javascript">

	function saveOnClick(e) {
	try{
		preventDefault(e);
	    var levelOneSelectBox = document.getElementById("levelOne_<portlet:namespace />")
	    var levelOneId = levelOneSelectBox.options[levelOneSelectBox.selectedIndex].value;

		var temp_url = '<%= editResourceURL %>';
		temp_url += "&levelOneId=" + levelOneId;
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

</script>