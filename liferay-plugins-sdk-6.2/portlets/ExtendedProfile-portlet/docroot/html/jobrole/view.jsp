<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<script type="text/javascript">

var competencyObject = ${competencyJSONObject}; // list of competency vocabulary Ids linked with joblevl & functional group
var jobLevelObject = ${jobLevelObject}; // vocabulary list for joblevel linked with selected functional group
var compListJSONObject = ${compListJSONObject};
var competecySPListJSONObject = ${competecySPListJSONObject};
var careerJSONObject = ${careerUrlJSONObject};
var competecyPublicViewJSONObject = ${competecyPublicViewJSONObject};

function populateCompetencyLevel() {
try{
	var checkboxes = document.getElementsByName("competencyLabelName");
	var competencyId = "";
	var competencyLevelId = "";
	if (checkboxes.length > 0) {
		for (i=0;i<checkboxes.length;i++) {
			var compLabel = document.getElementById("competencyLabel_"+checkboxes[i].getAttribute("competency_categoryId"));
			var SPListJSONObject = competecySPListJSONObject[checkboxes[i].getAttribute("competency_categoryId")];
			var compPublicView = competecyPublicViewJSONObject[checkboxes[i].getAttribute("competency_categoryId")];
			var compSelect1 = document.getElementById("competencyLevel_"+checkboxes[i].getAttribute("competency_categoryId"));
			compSelect1.innerHTML = "";
			for (key in compListJSONObject) {
				var compOption1 = document.createElement("Option");
				compOption1.text = compListJSONObject[key];
				compOption1.value = key;
				compSelect1.options.add(compOption1);
			}
			for (key in SPListJSONObject) {
				var selKey = key;
				var selValue = SPListJSONObject[key];
				for (key in compListJSONObject) {
					var compSelect = document.getElementById("competencyLevel_"+checkboxes[i].getAttribute("competency_categoryId"));
					var compTitle = document.getElementById("competencyTitle_"+checkboxes[i].getAttribute("competency_categoryId"));
					var compLevel = document.getElementById("competency_"+checkboxes[i].getAttribute("competency_categoryId"));
					if (compSelect) {
						if (selKey == key || selKey == "") {
							for (k=0;k<compSelect.length;k++) {
								var compOption = compSelect.options[k];
								if (compOption.value == selKey)
									compOption.selected = true;
							}
							selKey="";
							if (compLevel) {
								compLevel.innerHTML = selValue;
							}
							if (compTitle) {
								compTitle.style.display = "block";
							}
						}
					}
				}
			}
			var competencyPubliclyViewCheckbox = document.getElementById("competencyPubliclyViewCheckbox_"+checkboxes[i].getAttribute("competency_categoryId"));
			var competencyPubliclyViewMark = document.getElementById("competencyPubliclyViewMark_"+checkboxes[i].getAttribute("competency_categoryId"));
			if (compPublicView) {
				if (competencyPubliclyViewCheckbox) {
					competencyPubliclyViewCheckbox.checked = true;
				}
				if (competencyPubliclyViewMark) {
					competencyPubliclyViewMark.innerHTML = "*";
				}
			}else {
				if (competencyPubliclyViewCheckbox) {
					competencyPubliclyViewCheckbox.checked = false;
				}
				if (competencyPubliclyViewMark) {
					competencyPubliclyViewMark.innerHTML = "";
				}
			}
		}
	}
}catch(err) {
	//alert("populateCompetencyLevel: " + err);
}
}

function jobRoleOnchange(Id,type,jobRolecId) {
try{
	var e = document.getElementById("_JobRole_WAR_ExtendedProfileportlet_"+Id);
	var categoryId = e.options[e.selectedIndex].value;
	if (jobRolecId != 0) {
		categoryId = jobRolecId;
		for (k=0;k<e.length;k++) {
			var compOption = e.options[k];
			if (compOption.value == categoryId)
				compOption.selected = true;
		}
	}

	var setError = document.getElementById("jobrole_error_icon");
	setError.innerHTML = "";
	var setError = document.getElementById("joblevel_error_icon");
	setError.innerHTML = "";
	//jobLevelCategoryId = categoryId;
	var jobLevelDiv = document.getElementById("jobLevelView");
	jobLevelDiv.innerHTML="";
	/* var careerDiv = document.getElementById("careerPath_view");
	careerDiv.innerHTML=""; */
	var jobLevelSelect = document.createElement("Select");
	jobLevelSelect.setAttribute("name","current_jobLevel_Id");
	jobLevelSelect.setAttribute("id","_JobRole_WAR_ExtendedProfileportlet_current_jobLevel_list");
	jobLevelSelect.setAttribute("onchange","javascript:jobLevelOnchange('current_jobLevel_list','populateCompetencies',0)");
	var jobLOption = document.createElement("Option");
	jobLOption.text = "";
	jobLOption.value = "";
	jobLevelSelect.options.add(jobLOption);
	var A=AUI();
	var items = null;
	var reqUrl = '<portlet:resourceURL id="" />';
	var jobLevelVocabularyId;
	var jobLevelJSONObject = jobLevelObject[categoryId];
	var i=0;

	for (key in jobLevelJSONObject) {
		var category = jobLevelJSONObject[key];
		jobLevelVocabularyId = key;
	}

	A.io.request(reqUrl, {
	    cache: false,
	    sync: true,
	    timeout: 1000,
	    dataType: 'json',
	    method: 'post',
	    data:{
	   	 jobLevelVocabularyId:jobLevelVocabularyId,
	   	 type:type,
	    },
	    on: {
	        success: function() {

	       	 items = this.get('responseData');
	       	 if (items) {
				for (key in items) {
					var jobLevelOption = document.createElement("Option");
	       			jobLevelOption.text = items[key];
	       	       	jobLevelOption.value = key;
	       	        jobLevelSelect.options.add(jobLevelOption);
	       		 }
				jobLevelDiv.appendChild(jobLevelSelect);
	       	}

	        },
	        failure: function() {
	        }
	    }
	});
	return items;

}catch(err) {
	//alert("jobRoleOnchange: " + err);
}
}

function jobLevelOnchange(Id,type,jobLevelcId) {
try{
	var e1 = document.getElementById("_JobRole_WAR_ExtendedProfileportlet_current_jobrole_list");
	var jobLevelCategoryId = e1.options[e1.selectedIndex].value;
	var setError = document.getElementById("joblevel_error_icon");
	setError.innerHTML = "";
	var e = document.getElementById("_JobRole_WAR_ExtendedProfileportlet_" + Id);
	var categoryId = e.options[e.selectedIndex].value;
	if (jobLevelcId != 0) {
		categoryId = jobLevelcId;
		for (k=0;k<e.length;k++) {
			var compOption = e.options[k];
			if (compOption.value == categoryId)
				compOption.selected = true;
		}
	}
	var competencyDiv = document.getElementById("competencyView");

	var A=AUI();
	var items = null;
	var reqUrl = '<portlet:resourceURL id="" />';
	var jobLevelVocabularyId;
	var competencyLevelObject = competencyObject[jobLevelCategoryId];
	var cPath = includeCareerPathUrl(jobLevelCategoryId,categoryId);
	var i=0;

	var careerUrl = "";
	var carerUrlId = "";

	for (key in competencyLevelObject) {
		var category = competencyLevelObject[categoryId];
		competencyVocabularyId = category;
	}

	A.io.request(reqUrl, {
	    cache: false,
	    sync: true,
	    timeout: 1000,
	    dataType: 'json',
	    method: 'post',
	    data:{
	   	 competencyVocabularyId:competencyVocabularyId,
	   	 type:type,
	    },
	    on: {
	        success: function() {
	       	 items = this.get('responseData');
	       	 if (items) {
	       		 competencyDiv.innerHTML="";
				for (key in items) {
					var compCategoryId = key;
					var cDiv = document.createElement("Div");
					cDiv.setAttribute("style","margin-bottom:10px");
					var compDiv = document.createElement("Div");
					compDiv.setAttribute("class","competencyLabel");
					var competencyLabel = document.createElement("label");
					competencyLabel.setAttribute("id","competencyLabel_"+key);
					competencyLabel.setAttribute("competency_categoryId",key);
					competencyLabel.setAttribute("class","jobRole_label");
					competencyLabel.setAttribute("name","competencyLabelName");
					competencyLabel.appendChild(document.createTextNode(items[key]));
					var competencySelect = document.createElement("select");
					competencySelect.setAttribute("style","margin-left:40px");
					competencySelect.setAttribute("id","competencyLevel_"+key);
					for (key in compListJSONObject) {
						var competencyOption = document.createElement("Option");
						competencyOption.text = compListJSONObject[key];
						competencyOption.value = key;
						competencySelect.options.add(competencyOption);
						if (compListJSONObject[key] == "Basic Understanding")
							competencyOption.selected = true
					}

					var intervalSpan = document.createElement("Span");
					intervalSpan.innerHTML = "&nbsp;&nbsp;";

					var competencyPubliclyViewCheckbox = document.createElement("Input");
					competencyPubliclyViewCheckbox.setAttribute("id","competencyPubliclyViewCheckbox_"+compCategoryId);
					competencyPubliclyViewCheckbox.type = "checkbox";
					competencyPubliclyViewCheckbox.checked = false;

					compDiv.appendChild(competencyLabel);
					cDiv.appendChild(compDiv);
					cDiv.appendChild(competencySelect);
					cDiv.appendChild(intervalSpan);
					cDiv.appendChild(competencyPubliclyViewCheckbox);
					competencyDiv.appendChild(cDiv);
	       		 }
	       	}

	        },
	        failure: function() {
	        }
	    }
	});

	return items;
}catch(err) {
	//alert("jobLevelOnchange: " + err);
}
}

function includeCareerPathUrl(jobLevelCategoryId,Id ) {
try{
	var A=AUI();
	var items = null;
	var reqUrl = '<portlet:resourceURL id="" />';
	var type="populateCareerPathUrl";
	var careerPathJSONObject = careerJSONObject[jobLevelCategoryId];
	var i=0;

	var careerUrl = "";
	var carerUrlId = "";

	for (key in careerPathJSONObject) {
		careerUrlId = careerPathJSONObject[key];
		if (key == Id) {
		break;
		}
	}
	var careerDiv = document.getElementById("careerPath_view");
	careerDiv.innerHTML="";
	A.io.request(reqUrl, {
	    cache: false,
	    sync: true,
	    timeout: 1000,
	    dataType: 'json',
	    method: 'post',
	    data:{
	   	 careerUrlId:careerUrlId,
	   	 type:type,
	    },
	    on: {
	        success: function() {

	       	 items = this.get('responseData');
	       	 if (items) {
				for (key in items) {
					var careerLabel = document.createElement("Div");
					careerLabel.setAttribute("class","div_linkColor nicf_url");
					careerLabel.setAttribute("onClick","window.open('" + items[key] + "','StatusBar','width=850,menubar=no,toolbar=no,resizable=yes,scrollbars=yes,location=0,height=700,top=100,left=100');");
					careerLabel.setAttribute("id","careerPath_url");
					careerLabel.setAttribute("career_path_url",items[key]);
					careerLabel.innerHTML ="<font style='font-size: 15px;font-weight: bold;padding-left: 5px;'> >> Upgrade myself to acquire these competencies</font>";
					var careerInput = document.createElement("input");
					careerInput.type="hidden";
					careerInput.value = key;
					careerInput.setAttribute("id","career_urlPath");
					var contactLabel = document.createElement("Div");
					var contactHref = document.createElement("a");
					contactHref.setAttribute("class","nicf_url");
					contactHref.setAttribute("style","margin-left: 33px;");
					contactHref.setAttribute("href","/contact-us");
					contactHref.innerHTML = "<font>Can't find your Job Role? Contact us now.</font>";
					contactLabel.appendChild(contactHref);
	       		 }
				careerDiv.appendChild(careerLabel);
				careerDiv.appendChild(careerInput);
				careerDiv.appendChild(contactLabel);
	       	}

	        },
	        failure: function() {
	        }
	    }
	});

	return true;
}catch(err) {
	//alert("includeCareerPathUrl: " + err);
}
}

function saveJobRoleInfo() {
try{
	var type = "saveJobRoleInfo";
	var setError = document.getElementById("joblevel_error_icon");
	setError.innerHTML = "";
	var setError = document.getElementById("jobrole_error_icon");
	setError.innerHTML = "";
	var jobRoleSelect = document.getElementById("_JobRole_WAR_ExtendedProfileportlet_current_jobrole_list");
	var jobRoleId = jobRoleSelect.options[jobRoleSelect.selectedIndex].value;
	if (jobRoleId !=0) {
		var jobRoleValue = jobRoleSelect.options[jobRoleSelect.selectedIndex].text;
		var jobLevelSelect = document.getElementById("_JobRole_WAR_ExtendedProfileportlet_current_jobLevel_list");
		if (jobLevelSelect != null) {
			var jobLevelId = jobLevelSelect.options[jobLevelSelect.selectedIndex].value;
		}else {
			var jobLevelId = 0;
		}
		if (jobLevelId !=0) {
			var jobLevelValue = jobLevelSelect.options[jobLevelSelect.selectedIndex].text;
			var checkboxes = document.getElementsByName("competencyLabelName");
			var careerPath = document.getElementById("career_urlPath").value;
			var careerPathElement = document.getElementById("careerPath_url");
			var careerPathUrl = "";
			if (careerPathElement != undefined) {
				careerPathUrl = careerPathElement.getAttribute("career_path_url");
			}
			var competencyId = "";
			var competencyLevelId = "";
			var compLabelValue = "";
			var compSelect = "";
			var cSelectValue="";
			var compPubliclyViewCheckbox = "";
			var compPubliclyView = "";
			for (i=0;i<checkboxes.length;i++) {
					var compCId = checkboxes[i].getAttribute("competency_categoryId");
					competencyId = compCId + "," + competencyId;
					var compLabel = document.getElementById("competencyLabel_"+compCId);
					compLabelValue = compLabel.innerHTML + "#" + compLabelValue;
					compSelect = document.getElementById("competencyLevel_"+compCId);
					compPubliclyViewCheckbox = document.getElementById("competencyPubliclyViewCheckbox_"+compCId);

					var compSelectValue = compSelect.options[compSelect.selectedIndex].value;
					if (compSelectValue == "") {
						compSelectValue = "0";
					}
					competencyLevelId = compSelectValue + "," + competencyLevelId;
					compPubliclyView = compPubliclyViewCheckbox.checked + "," + compPubliclyView;
					cSelectValue = compSelect.options[compSelect.selectedIndex].innerHTML+ "##" +cSelectValue;
			}
			var A=AUI();
			var reqUrl = '<portlet:resourceURL id="" />';
			var successSave = true;
			 A.io.request(reqUrl, {
		     cache: false,
		     sync: true,
		     timeout: 1000,
		     dataType: 'json',
		     method: 'post',

		     data:{
		    	 jobRoleId:jobRoleId,
		    	 jobLevelId:jobLevelId,
		    	 competencyId:competencyId,
		    	 competencyLevelId:competencyLevelId,
		    	 compPubliclyView:compPubliclyView,
		    	 careerPath:careerPath,
		    	 type:type
		     },
		     on: {
		         success: function() {
		        	 items = this.get('responseData');
		        	 var status = items.status;
			         var msg = items.message;
			            if (status == "200") {
			            	if (msg == null) {
					           msg = "Unexpected server error occured.";
					        }
			            	var editDocument = document.getElementById("viewJobRole");
			            	loadJobRoleViewMode(jobRoleValue,jobLevelValue,compLabelValue,careerPathUrl,cSelectValue, compPubliclyView,jobLevelId,jobRoleId);
			            	editDocument.setAttribute("style","display:block");
			            	document.getElementById("editJobRole").setAttribute("style","display:none");
			           		successSave = false;
			            }else {
							successSave = true;
			            }
		         },
		         failure: function() {
		         }
		     }
		 });
		}else {
			var setError = document.getElementById("joblevel_error_icon");
			setError.innerHTML = "";
			var errorDiv = document.createElement("Div");
			errorDiv.setAttribute("class","cross");
			setError.appendChild(errorDiv);
		}
	}else {
		var setError = document.getElementById("jobrole_error_icon");
		setError.innerHTML = "";
		var errorDiv = document.createElement("Div");
		errorDiv.setAttribute("class","cross");
		setError.appendChild(errorDiv);
	}

// return true;
}catch(err) {
	//alert("saveJobRoleInfo: " + err);
}
}

function loadJobRoleViewMode(jobRoleValue,jobLevelValue,compLabelValue,careerPathUrl,cSelectValue,compPubliclyView,jobLevelId,jobRoleId) {
try{
	var temp = compLabelValue.split("#");
	var tempComp = cSelectValue.split("##");
	var tempPublicView = compPubliclyView.split(",");
	var comp = document.getElementById("competencyValue");
	comp.innerHTML = "";
	var publicViewSum = 0;
	for (i=0;i<temp.length-1;i++) {
		var compDiv = document.createElement("Div");
		compDiv.setAttribute("class","competencyLabel");
		var cLabel = document.createElement("label");
		cLabel.setAttribute("class","jobRole_label");
		cLabel.appendChild(document.createTextNode(temp[i]));
		cLabel.setAttribute("name","competencyLabelNameView");
		compDiv.appendChild(cLabel);

		var cLevelDiv = document.createElement("Div");
		cLevelDiv.setAttribute("style","display: inline-block; margin-left: 2%; width: 28%;");
		cLevelDiv.appendChild(document.createTextNode(tempComp[i]));

		var compPublicView = tempPublicView[i];

		var compPublicViewMark = document.createElement("Span");
		compPublicViewMark.setAttribute("style", "margin-left: 2%;");
		/*
		if (compPublicView == "true") {
			compPublicViewMark.innerHTML = "*";
		}else {
			compPublicViewMark.innerHTML = "";
		}
		*/

		compPublicViewMark.innerHTML = "";

		var cBreak = document.createElement("br");
		if (compPublicView == "true") {
			comp.appendChild(compDiv);
			comp.appendChild(cLevelDiv);
			comp.appendChild(compPublicViewMark);
			comp.appendChild(cBreak);
			publicViewSum = publicViewSum + 1;
		}
	}
	if (publicViewSum == 0) {
		var noCompetenciesSelectedDiv = document.createElement("Div");
		noCompetenciesSelectedDiv.appendChild(document.createTextNode("No Competencies Selected."));
		comp.appendChild(noCompetenciesSelectedDiv);
	}
	document.getElementById("jobRoleValue").innerHTML = jobRoleValue;
	if (document.getElementById("jobRoleValue_Id") != null)
	document.getElementById("jobRoleValue_Id").value = jobRoleId;
	document.getElementById("jobLevelValue").innerHTML = jobLevelValue;
	if (document.getElementById("jobLevelValue_Id") != null)
	document.getElementById("jobLevelValue_Id").value = jobLevelId;
	var careerA = document.getElementById("careerPathUrl_view");
	careerA.innerHTML = "<font style='font-size: 15px;font-weight: bold;padding-left: 5px;'> >> Upgrade myself to acquire these competencies</font>";
	careerA.setAttribute("class","div_linkColor nicf_url");
	careerA.setAttribute("onclick","window.open('" + careerPathUrl + "','StatusBar','width=850,menubar=no,toolbar=no,resizable=yes,scrollbars=yes,location=0,height=700,top=100,left=100');");
	var jRSelect = document.getElementById("_JobRole_WAR_ExtendedProfileportlet_current_jobrole_list");
	for (k=0;k<jRSelect.length;k++) {
		var jRSelectOption = jRSelect.options[k];
		if (jRSelectOption.value == jobRoleId)
			jRSelectOption.selected = true;
	}
}catch(err) {
	//alert("loadJobRoleViewMode: " + err);
}
}

function editJobRoleDetails() {
try{
	document.getElementById("viewJobRole").setAttribute("style","display:none");
	document.getElementById("editJobRole").setAttribute("style","display:block");
}catch(err) {
	//alert("editJobRoleDetails: " + err);
}
}

function cancelJobRoleInfo() {
try{
	document.getElementById("viewJobRole").setAttribute("style","display:block");
	document.getElementById("editJobRole").setAttribute("style","display:none");
	//document.getElementById("jobRoleValue").innerHTML = jobRoleValue;
	 var jobRoleId = document.getElementById("jobRoleValue_Id").value;
	 var jobLevelId = document.getElementById("jobLevelValue_Id").value;
	jobRoleOnchange('current_jobrole_list','populateJobLevels',jobRoleId);
	jobLevelOnchange('current_jobLevel_list','populateCompetencies',jobLevelId);
	populateCompetencyLevel();
}catch(err) {
	//alert("cancelJobRoleInfo: " + err);
}
}
</script>

<div>
<div id="viewJobRole" style="display:block">

	<div>
	<div class="panel-hd-text">
		<font class="header-pretitle">
			Current
		</font>
		<font class="header-posttitle">
			Job Role
		</font>
	</div>
	<div class="showdowheader-profile"></div>
	<div>
		<font class="header-pretitle" style="padding-left: 0;">based on</font><a href="http://www.nicf.sg" target="blank" class="header-posttitle"> National Infocomm Competency framework.</a>
	</div>
	<div id="JobRole_contents">
	<div class="workhistory_editAlignExt" id="">
		<div class="dynamic-section-button-align">
			<c:if test="${editable}">
				<a class="book userprofile-edit-linkExt" href="javascript:editJobRoleDetails()" id="jobRole_view_Edit" title="Edit">&nbsp;</a>
			</c:if>
		</div>
	</div>
	<div class="maindivpersonalInfo">
	<div class="content-title">
		Functional Group
		<div class="seperatedline"></div>
	</div>
	<div class="userpersonaldetails-value-full-width">
		<div class="userpersonaldetails-value-Leftfull-width basicinfo-textedit" id="current_jobrole">
				<c:if test="${jobRoleSaved== null}">
					<div id="jobRoleValue">
						No Functional Group Selected.
					</div>
				</c:if>
				<c:if test="${jobRoleSaved != null}">
				<div id="jobRoleValue">
					${jobRoleSaved.name}
				</div>
				<input id="jobRoleValue_Id" type="hidden" value="${jobRoleSaved.categoryId}" />
				</c:if>
		</div>
	</div>
	</div>
	<div class="maindivpersonalInfo">
	<div class="content-title">
		Job Levels
		<div class="seperatedline"></div>
	</div>
	<div class="userpersonaldetails-value-full-width">
		<div class="userpersonaldetails-value-Leftfull-width basicinfo-textedit" id="current_jobrole">
			<div>
				<c:if test="${jobLevelSaved == null}">
					<div id="jobLevelValue">
						No Job Level Selected.
					</div>
					<div>
					<div class="div_linkColor" onClick="window.open('${careerPath.itemValue}','StatusBar','width=850,menubar=no,toolbar=no,resizable=yes,scrollbars=yes,location=0,height=700,top=100,left=100');">
					</div>
					</div>
				</c:if>
				<c:if test="${jobLevelSaved != null}">
				<div id="jobLevelValue">
					${jobLevelSaved.name}
				</div>
				<input id="jobLevelValue_Id" type="hidden" value="${jobLevelSaved.categoryId}" />
				</c:if>
			</div>
		</div>
	</div>
	</div>
	<div class="maindivpersonalInfo">
	<div class="content-title">
		Competencies
		<div class="seperatedline"></div>
	</div>
	<div class="userpersonaldetails-value-full-width">
		<div class="userpersonaldetails-value-Leftfull-width basicinfo-textedit" id="current_jobrole">
			<div id="competencyValue">
				 <c:if test="${not empty highlightedCompetecyLevelSaved}">
					<c:forEach items="${highlightedCompetecyLevelSaved}" var="highlightedCompetecyLevelSaved">
						<div id="competencyTitle_${highlightedCompetecyLevelSaved.categoryId}" style="display:none">
							<div class="competencyLabel">${highlightedCompetecyLevelSaved.name}</div>
							<div id="competency_${highlightedCompetecyLevelSaved.categoryId}" style="display: inline-block; margin-left: 2%; width: 28%;"></div>
							<c:if test="${false}">
								<span id="competencyPubliclyViewMark_${highlightedCompetecyLevelSaved.categoryId}" style="margin-left: 2%;"></span>
							</c:if>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty highlightedCompetecyLevelSaved}">
					<div>
						No Competencies Selected.
					</div>
				</c:if>
			</div>
			<c:if test="${editable}">
				<div class="nicf_url div_linkColor" id="careerPathUrl_view" onClick="window.open('${careerPath.itemValue}','StatusBar','width=850,menubar=no,toolbar=no,resizable=yes,scrollbars=yes,location=0,height=700,top=100,left=100');">
					<font style="font-size: 15px;font-weight: bold;padding-left: 5px;"> &#x3E;&#x3E; Upgrade myself to acquire these competencies</font>
				</div>
				<div>
					<a class="nicf_url" href="/contact-us" style="margin-left: 33px;">
						<font>Can't find your Job Role? Contact us now.</font>
					</a>
				</div>
			</c:if>
		</div>
	</div>
	</div>
</div>
</div>
</div><!-- end of viewJobRole -->

<div id="editJobRole" style="display:none">
	<%@ include file="JobRole_editValues.jsp" %>
</div><!-- end of editJobRole -->

</div>

<script type="text/javascript">
//editDetails();
populateCompetencyLevel();

</script>