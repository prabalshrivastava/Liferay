<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<portlet:resourceURL var="saveResourceURL">
	<portlet:param name="action" value="save"></portlet:param>
</portlet:resourceURL>

<div id="certification_container">
	<span class="panel-hd-text"><font class="header-pretitle">Certification</font></span>
</div>

<div class="showdowheader-profile"></div>

<br />

<div class="panel-bd" id="certifications_container_<portlet:namespace />">
	<div>
		<c:if test="${editable}">
			<div class="workhistory_editAlignExt"><a href="#" title="edit" onclick="javascript:editCertificationOnClick(event)" data-mycertifications="${certificationIdsStr}" class="userprofile-edit-linkExt">&nbsp;</a></div>
		</c:if>
		<c:forEach items="${myCertificationCategories}" var="myCertificationCategory">
		<div style="display: list-item; list-style: disc inside none;">
			${myCertificationCategory.name}
		</div>
			<br />
		</c:forEach>
	</div>
</div>

<div class="hide" id="edit_certifications_container_<portlet:namespace />">
	<div>
		<c:if test="${editable}">
			<div class="workhistory_editAlignExt"><a href="#" title="edit" onclick="javascript:editCertificationOnClick(event)" data-mycertifications="${certificationIdsStr}" class="userprofile-edit-linkExt">&nbsp;</a></div>
		</c:if>
		<c:forEach items="${myCertificationCategories}" var="myCertificationCategory">
		<div style="display: list-item; list-style: disc inside none;">
			${myCertificationCategory.name}
		</div>
			<br />
		</c:forEach>
	</div>
</div>

<style type="text/css">

	.sp-certification-selector {
		overflow-y: scroll;
		max-height: 200px;
		width:100%;
		margin-top:10px;
	}

</style>

<script type="text/javascript">

	function cancelCertificationOnClick(e) {
	try{
		preventDefault(e);
		var certificationsContainer = document.getElementById("certifications_container_<portlet:namespace />");
		var editCertificationsContainer = document.getElementById("edit_certifications_container_<portlet:namespace />");
		certificationsContainer.removeChild(getFirstChild(certificationsContainer));
		certificationsContainer.removeChild(getLastChild(certificationsContainer));
		certificationsContainer.appendChild(getFirstChild(editCertificationsContainer).cloneNode(true));

	}catch(err) {
		alert(err);
	}
	}

	function editCertificationOnClick(e) {
	try{
		preventDefault(e);
		var target = getEventTarget(e);
		var certificationIdsStr = target.getAttribute("data-mycertifications");

		var certificationsContainer = document.getElementById("certifications_container_<portlet:namespace />");

		certificationsContainer.removeChild(getFirstChild(certificationsContainer));

		var certificationSelector = document.createElement("FORM");
		certificationSelector.name = "certificationSelector";

		addClass(certificationSelector, "sp-certification-selector");

		var actionLinksDiv = document.createElement("div");
		addClass(actionLinksDiv, "workhistory_editAlignExt");
		actionLinksDiv.setAttribute("style","margin-top: -16px;");

		var cancelLink = document.createElement("a");
		addClass(cancelLink, "undo-button");
		cancelLink.setAttribute("href", "#");
		cancelLink.setAttribute("onclick", "javascript:cancelCertificationOnClick(event)");
		cancelLink.title = "cancel";
		cancelLink.innerHTML = "&nbsp;";
		actionLinksDiv.appendChild(cancelLink);
		certificationsContainer.appendChild(actionLinksDiv);

		var saveLink = document.createElement("a");
		addClass(saveLink, "update-button");
		saveLink.setAttribute("href", "#");
		saveLink.setAttribute("onclick", "javascript:saveCertificationOnClick(event)");
		saveLink.title = "save";
		saveLink.innerHTML = "&nbsp;";
		actionLinksDiv.appendChild(saveLink);
		certificationsContainer.appendChild(actionLinksDiv);

		var allCertificationCategoryJSONObject = ${allCertificationCategoryJSONObject};

		for (key in allCertificationCategoryJSONObject) {
			var name = allCertificationCategoryJSONObject[key];
			var checkbox = document.createElement("INPUT");
			checkbox.type = "checkbox";
			checkbox.name = "certification";
			checkbox.value = key;

			var certificationIds = certificationIdsStr.split(",");
			for (index in certificationIds) {
				var myCertificationId = certificationIds[index];
				if (myCertificationId == key) {
					checkbox.checked = true;
					break;
				}
			}

			certificationSelector.appendChild(checkbox);
			certificationSelector.appendChild(document.createTextNode(name));
			certificationSelector.appendChild(document.createElement("br"));
		}

		certificationSelector.appendChild(document.createElement("br"));

		certificationsContainer.appendChild(certificationSelector);

	}catch(err) {
		alert(err);
	}
	}

	function saveCertificationOnClick(e) {
	try{
		preventDefault(e);
		var target = getEventTarget(e);
		var opt = target.parentNode.nextSibling.certification;
		var certificationIdsStr = "";
		for (var intLoop = 0; intLoop < opt.length; intLoop++) {
			if ((opt[intLoop].selected) || (opt[intLoop].checked)) {
				if (certificationIdsStr.length > 0) {
					certificationIdsStr += ",";
				}
			   	certificationIdsStr += opt[intLoop].value;
			}
		 }

		var temp_url = '<%= saveResourceURL %>';
		temp_url += "&certificationIdsStr=" + certificationIdsStr;
		AjaxGet(temp_url, saveSuccess, saveError);

	}catch(err) {
		alert(err);
	}
	}

	function saveSuccess() {
	try{
		var certificationsContainer = document.getElementById("certifications_container_<portlet:namespace />");
		var editCertificationsContainer = document.getElementById("edit_certifications_container_<portlet:namespace />");

		certificationsContainer.removeChild(getFirstChild(certificationsContainer));
		certificationsContainer.removeChild(getLastChild(certificationsContainer));
		editCertificationsContainer.removeChild(getFirstChild(editCertificationsContainer));

		var responseText = trimStr(xhr.responseText);
		if (responseText.length > 0) {
			var data = JSON.parse(xhr.responseText);

		    var dataHtml = trimStr(data.html);
		    if (dataHtml.length > 0) {
				var temp_div1 = document.createElement("DIV");
				temp_div1.innerHTML = dataHtml;
				var temp_div2 = document.createElement("DIV");
				temp_div2.innerHTML = dataHtml;
				certificationsContainer.appendChild(temp_div1);
				editCertificationsContainer.appendChild(temp_div2);
		    }
		}

	}catch(err) {
		alert(err);
	}
	}

	function saveError() {
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