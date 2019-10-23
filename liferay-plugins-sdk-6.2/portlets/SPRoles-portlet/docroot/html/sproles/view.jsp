<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:actionURL var="viewActionURL">
	<portlet:param name="action" value="<%= Constants.VIEW %>"></portlet:param>
</portlet:actionURL>

<portlet:actionURL var="mapActionURL">
	<portlet:param name="action" value="mapping"></portlet:param>
</portlet:actionURL>

<%
String success= (String) request.getAttribute("success");
String subCategoryList= (String) request.getAttribute("subCategoryList");
String catergoryName= (String) request.getAttribute("catergoryName");
%>

<div id="RoleMapping_contents" style="margin:40px;border:1px solid black;">
	<div class="maindiv" id="catgMappingMainDiv" style="padding: 20px;display:none;">
		<%@ include file="/html/sproles/categoriesMappingView.jsp" %>
	</div>

	<div class="maindiv" id="roleMappingMainDiv" style="padding: 20px;display:none;">
		<%@ include file="/html/sproles/mappingFiltersView.jsp" %>
	</div>

	<div id="listMainDiv" style="padding: 20px;">
		<%@ include file="/html/sproles/categoriesMappingListView.jsp" %>
		<%@ include file="/html/sproles/roleMappingListView.jsp" %>
	</div>

</div>

<script type="text/javascript">
var removedValues =0;
var removedNames =0;
var mainCatgChanged = false;
function getRemovedCategories(catgChk,catgList,f) {
	var removedCtg = document.getElementById(catgChk+f);
	if (removedCtg.checked == false) {
		removedValues = removedValues + "#" + removedCtg.value;
		removedNames = removedNames + "#" + removedCtg.nextSibling.innerHTML;
	}
	var removedCtgList = document.getElementById(catgList);
	removedCtgList.value = removedValues;
	var removedCtgNames = document.getElementById(catgList+"Names");
	if (removedCtgNames != null)
	removedCtgNames.value = removedNames;
	var removedmainCtgName = document.getElementById("removedmainCatgName");
	var selMainCatgName = document.getElementById("mainCategory_sel_list");
	if (removedmainCtgName != null)
		removedmainCtgName.value = selMainCatgName.options[selMainCatgName.selectedIndex].innerHTML;
}

function getRemovedCategories2(g) {
	var removedCtg = document.getElementById("categories2_"+g);
	if (removedCtg.checked == false) {
		removedValues = removedValues + "#" + removedCtg.value;
	}
	var removedCtgList = document.getElementById("removedCatg2");
	removedCtgList.value = removedValues;
}

function resetValues(dropDownSel,chk1Sel,chk2Sel,mappingType) {
	var catgs1 = document.getElementsByName(chk1Sel);
	for ( var i = 0; i < catgs1.length; i++) {
		catgs1[i].checked = false;
	}
	if (chk2Sel!='') {
		var catgs2 = document.getElementsByName(chk2Sel);
		for ( var i = 0; i < catgs2.length; i++) {
			catgs2[i].checked = false;
		}
	}
	populateExistingMapping(dropDownSel,chk1Sel,chk2Sel,mappingType);
}

function populateExistingMapping(drpSel,chk1Sel,chk2Sel,mappingType) {
	try {
		var type = mappingType;
		var catg1 = document.getElementById(drpSel).value;
					var A = AUI();
					var reqUrl = '<portlet:resourceURL id="" />';
					var successSave = true;
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
											catg1 : catg1,
											type : type
										},
										on : {
											success : function() {
												items = this.get('responseData');
												 if (type == "populateCatgMap") {
													var catg2 = document.getElementsByName(chk1Sel);
													if (items) {
														var splitcatg1Exist = items.split("##");
														for (var t=0; t<splitcatg1Exist.length-1;t++) {
															for ( var i = 0; i < catg2.length; i++) {
																if (splitcatg1Exist[t] == catg2[i].value) {
																	catg2[i].checked = true;
																}
															}
														}
													}
												}
												 if (type == "populateRoleCatg") {
														var catg2 = document.getElementsByName(chk1Sel);
														var splitcatg1Exist = "";
														var splitcatg2Exist = "";
														var catgs1 = items;
														var catgs2 = "";
														if (items) {
															if (items.contains("@@")) {
																var catgs1catgs2 = items.split("@@");
																catgs1 = catgs1catgs2[0];
																catgs2 = catgs1catgs2[1];
																splitcatg2Exist = catgs2.split("##");
															}
															splitcatg1Exist = catgs1.split("##");
															for (var t=0; t<splitcatg1Exist.length-1;t++) {
																for ( var i = 0; i < catg2.length; i++) {
																	if (splitcatg1Exist[t] == catg2[i].value) {
																		catg2[i].checked = true;
																	}
																}
															}
															if (splitcatg2Exist.length > 1) {
																var catgs2 = document.getElementsByName(chk2Sel);
																for (var t=0; t<splitcatg2Exist.length-1;t++) {
																	for ( var i = 0; i < catgs2.length; i++) {
																		if (splitcatg2Exist[t] == catgs2[i].value) {
																			catgs2[i].checked = true;
																		}
																	}
																}
															}
														}
													}
											},
											failure : function() {
											}
										}
									});
		// return true;
	} catch (err) {
		alert("getExistingmapping: " + err);
	}
}

function toggleView(vw) {
	if (vw == 'list') {
		document.getElementById("listMainDiv").style.display = "block";
		document.getElementById("roleMappingMainDiv").style.display = "none";
		document.getElementById("catgMappingMainDiv").style.display = "none";
	}
	if (vw == 'roleMap') {
		//resetValues();
		document.getElementById("listMainDiv").style.display = "none";
		document.getElementById("roleMappingMainDiv").style.display = "block";
		document.getElementById("catgMappingMainDiv").style.display = "none";
		var saveorupdate = document.getElementById("saveorupdate");
		saveorupdate.value = "";
		var saveButton = document.getElementById("saveButton");
		saveButton.value = "Save";
	}
	if (vw == 'catgMap') {
		//resetValues();
		document.getElementById("listMainDiv").style.display = "none";
		document.getElementById("roleMappingMainDiv").style.display = "none";
		document.getElementById("catgMappingMainDiv").style.display = "block";
		var saveorupdate = document.getElementById("saveorupdateVoc");
		saveorupdate.value = "";
		var saveButton = document.getElementById("saveVocabularyButton");
		saveButton.value = "Save";
	}
}

function editInfo(k) {

	document.getElementById("listMainDiv").style.display = "none";

	document.getElementById("roleMappingMainDiv").style.display = "block";
	document.getElementById("catgMappingMainDiv").style.display = "none";
	var saveorupdate = document.getElementById("saveorupdate");
	saveorupdate.value = "update";
	var saveButton = document.getElementById("saveButton");
	saveButton.value = "Update";
	var usrRoleEdit = document.getElementById("selMappingRole_"+k).value;
	var rols1 = document.getElementById("current_role_list");
	rols1.value = usrRoleEdit;
	//rols1.disabled=true;
	var catg1Edit = document.getElementById("selMappingCatg1_"+k).value;
	var splitcatg1Edit = catg1Edit.split("##");
	var catgs1 = document.getElementsByName('categories1');
	for ( var i = 0; i < catgs1.length; i++) {
		catgs1[i].checked = false;
	}

	for (var t=0; t<splitcatg1Edit.length-1;t++) {
		//if (splitcatg1Edit.indexOf("-") != -1) {
			var splitcatg1 = splitcatg1Edit[t].split("-");
			var Cntrycatgs1 = document.getElementById('categories1_'+ splitcatg1[0]);
				if ((Cntrycatgs1.value == splitcatg1[0])) {
					Cntrycatgs1.checked = true;
					//catgs1[i].disabled = true;
				}

			for ( var i = 0; i < catgs1.length; i++) {
				//alert("splitcatg1[1] " + splitcatg1[1] + " catgs1[i].value " + catgs1[i].value);
				if ((catgs1[i].value == splitcatg1[1])) {
					catgs1[i].checked = true;
					//catgs1[i].disabled = true;
				}
			}
		/*}else {
			for ( var i = 0; i < catgs1.length; i++) {
				alert("catgs1[i].value " + catgs1[i].value + " dd " + splitcatg1Edit[t]);
				if ((catgs1[i].value == splitcatg1Edit[t])) {
					catgs1[i].checked = true;
					//catgs1[i].disabled = true;
				}
			}
		}*/
	}
	var catg2Edit = document.getElementById("selMappingCatg2_"+k).value;
	var splitcatg2Edit = catg2Edit.split("##");
	var catgs2 = document.getElementsByName('categories2');
	for ( var i = 0; i < catgs2.length; i++) {
		catgs2[i].checked = false;
	}
	for (var t=0; t<splitcatg2Edit.length-1;t++) {

		for ( var i = 0; i < catgs2.length; i++) {
			if (catgs2[i].value == splitcatg2Edit[t]) {
				catgs2[i].checked = true;
			}
		}
	}
}

function editCategoryInfo(k) {

	document.getElementById("listMainDiv").style.display = "none";

	document.getElementById("roleMappingMainDiv").style.display = "none";
	document.getElementById("catgMappingMainDiv").style.display = "block";

	var saveorupdate = document.getElementById("saveorupdateVoc");
	saveorupdate.value = "updateVocabulary";
	var saveButton = document.getElementById("saveVocabularyButton");
	saveButton.value = "Update";
	var usrRoleEdit = document.getElementById("selCatgMappingMain_"+k).value;
	var rols1 = document.getElementById("mainCategory_sel_list");
	rols1.value = usrRoleEdit;
	//rols1.disabled=true;
	var catg1Edit = document.getElementById("selCatgMappingSub_"+k).value;
	var splitcatg1Edit = catg1Edit.split("#");
	var catgs1 = document.getElementsByName('subCategory_chk');
	for ( var i = 0; i < catgs1.length; i++) {
		catgs1[i].checked = false;
	}
	for (var t=0; t<splitcatg1Edit.length-1;t++) {

		for ( var i = 0; i < catgs1.length; i++) {
			if (catgs1[i].value == splitcatg1Edit[t]) {
				catgs1[i].checked = true;
				catgs1[i].disabled = true;
			}
		}
	}
}

function deleteInfo(k,dlType,rolsId,ctg1Id,ctg2Id) {
	try {
		var type = dlType;
		var rols1 = '';
		if (rolsId != '')
		rols1 = document.getElementById(rolsId+k).value;
		//rols1.disabled=true;
		var catg1Edit = document.getElementById(ctg1Id+k).value;
		var catg2EditSel = document.getElementById(ctg2Id+k);
		var catg2Edit = null;
		if (catg2EditSel != undefined) {
			catg2Edit = document.getElementById(ctg2Id+k).value;
		}

					var A = AUI();
					var reqUrl = '<portlet:resourceURL id="" />';
					var successSave = true;
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
											rols1 : rols1,
											catg1Edit : catg1Edit,
											catg2Edit : catg2Edit,
											type : type
										},
										on : {
											success : function() {
												items = this.get('responseData');
												location.reload();
											},
											failure : function() {
											}
										}
									});
		// return true;
	} catch (err) {
		alert("saveJobRoleInfo: " + err);
	}
}

	function saveRoleInfo() {
		try {
			var type = "saveRoleInfo";
			var setError = document.getElementById("jobrole_error_icon");
			setError.innerHTML = "";
			var roleSelect = document.getElementById("current_role_list");
			var roleId = roleSelect.options[roleSelect.selectedIndex].value;
			if (roleId != 0) {

				var catgs1 = document.getElementsByName('categories1');
				var selectedCatgs1 = [];
				for ( var i = 0; i < catgs1.length; i++) {
					if (catgs1[i].checked) {
						selectedCatgs1.push(catgs1[i].value);
					}
				}
				if (selectedCatgs1 != "") {
					var catgs2 = document.getElementsByName('categories2');
					var selectedCatgs2 = [];
					for ( var i = 0; i < catgs2.length; i++) {
						if (catgs2[i].checked) {
							selectedCatgs2.push(catgs2[i].value);
						}
					}
					if (selectedCatgs2 != "") {
						var A = AUI();
						var reqUrl = '<portlet:resourceURL id="" />';
						var successSave = true;
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
												roleId : roleId,
												selectedCatgs1 : selectedCatgs1,
												selectedCatgs2 : selectedCatgs2,
												type : type
											},
											on : {
												success : function() {
													items = this
															.get('responseData');
													var status = items.status;
													var msg = items.message;
													if (status == "200") {
														if (msg == null) {
															msg = "Unexpected server error occured.";
														}
														var mappingTableDiv = document
																.getElementById("role-category-map");

														/* var mapTable = document
																.createElement("table");
														templateTable
																.setAttribute(
																		"id",
																		"mapping-Table");
														templateTable
																.setAttribute(
																		"style",
																		"width:98%");
														var tblBody = document
																.createElement("tbody");
														var tblCRow = document
																.createElement("tr");
														tblCRow
																.setAttribute(
																		"style",
																		"height: 30px;font-weight:bold;");

														var tblCol = document
																.createElement("td");
														tblCol
																.setAttribute(
																		"class",
																		"role-category-list");
														var cellText = document
																.createTextNode("Mail Campaign List");
														tblCol
																.appendChild(cellText);
														tblCRow
																.appendChild(tblCol);
														tblBody
																.appendChild(tblCRow);
														templateTable
																.appendChild(tblBody);
														mappingTableDiv
																.appendChild(templateTable); */

														successSave = false;
													} else {
														successSave = true;
													}
												},
												failure : function() {
												}
											}
										});
					} else {
						var setError = document
								.getElementById("jobrole_error_icon");
						setError.innerHTML = "";
						var errorDiv = document.createElement("Div");
						errorDiv.setAttribute("class", "cross");
						setError.appendChild(errorDiv);
					}
				} else {
					var setError = document
							.getElementById("jobrole_error_icon");
					setError.innerHTML = "";
					var errorDiv = document.createElement("Div");
					errorDiv.setAttribute("class", "cross");
					setError.appendChild(errorDiv);
				}
			} else {
				var setError = document.getElementById("jobrole_error_icon");
				setError.innerHTML = "";
				var errorDiv = document.createElement("Div");
				errorDiv.setAttribute("class", "cross");
				setError.appendChild(errorDiv);
			}

			// return true;
		} catch (err) {
			alert("saveJobRoleInfo: " + err);
		}
	}

function selectAllSubCategories(source,mainCtgId) {
	var allElements = document.getElementsByName('categories1');
	  for (var i = 0; i < allElements.length; i++) {
		  //alert("mainCtgId " + mainCtgId);
		  //alert("mainCategory " + allElements[i].getAttribute("mainCategory"));
	    	if ((allElements[i].getAttribute("mainCategory") !== null) && (allElements[i].getAttribute("mainCategory") == mainCtgId)) {
	    		//var checkboxes = document.getElementsByAttribute('mainCategory');
	    	  	//for (var i=0;i<checkboxes.length;i++)
	    	    	allElements[i].checked = source.checked;
	    	    	if (!source.checked) {
	    	    		getRemovedCategories('categories1_','removedCatg1',allElements[i].value);
	    	    	}
	    	}

	  }
}

function showSubCategories(mainCtgId) {

	var allElements = document.getElementsByClassName('categoryList_'+mainCtgId);
	for (var i = 0; i < allElements.length; i++) {
		if (allElements[i].style.display == "none") {
			allElements[i].style.display = "block";
		}else {
			allElements[i].style.display = "none";
		}
	}

}

</script>