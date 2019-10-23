<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="org.apache.commons.io.IOUtils"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="java.io.InputStream"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ include file="init.jsp" %>

<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>

<%
JSONObject data;
try {
	InputStream is = this.getClass().getResourceAsStream("/programmePath.json");
	data = JSONFactoryUtil.createJSONObject(IOUtils.toString(is));
} catch (Exception e) {
	data = JSONFactoryUtil.createJSONObject();
}

long configStorageId = GetterUtil.getLong(portletPreferences.getValue("configStorageId", "0"));
long _scopeGroupId = SambaashUtil.getScopeGroupId(themeDisplay.getScopeGroupId());
long _currentUser = themeDisplay.getUserId();
%>

<div class="ptpContainer">
	<div class="enrolExamContainer program-path-accordianheader toggler-header-expanded" style="display: none;">Enrol For Examinations</div>
	<div class="enrolExamContainer program-path-content toggler-content-expanded" style="display: none;">
	</div>

	<div id="programmePathContainerTitle" class="program-path-accordianheader toggler-header-collapsed">Programme Tracker</div>
	<div id="programmePathContainer" class="program-path-content toggler-content-collapsed"></div>
</div>

<aui:script use="aui-base,aui-node,aui-io-request">
	Formio.setPlatformAuth("<%= AuthTokenUtil.getToken(request) %>");
	var scopeGroupId = <%= SambaashUtil.getScopeGroupId(themeDisplay.getScopeGroupId()) %>;
	var userId = <%= themeDisplay.getUserId() %>;
	var DEFAULT_HEADERS = { "X-SCOPEGROUP-ID": scopeGroupId ? scopeGroupId : 21424,
			"X-USER-ID": userId ? userId : 1
		  }

	var ProgrammePathContoller = function(A, container) {
		var root = container;
		
		var showMenuLinkValidation = function showMenuLinkValidation(showMenuApiUrl, callback, method) {		
			SambaashUtils.ajax(showMenuApiUrl, method || "get", null, function(){callback(this.get('responseData'))}, null, DEFAULT_HEADERS);
		}
		
		var createNewPanel = function(panelConfig, data) {
			var isEmptyPanel = true;
			data.forEach(function (schedData) {
				if (schedData.ScheduleData.length > 0) {
					isEmptyPanel = false;
				}
			});
			if (panelConfig.hidePanelWhenEmpty && isEmptyPanel) {
				return;
			}
			var panelHeader = document.createElement("DIV");
			root.append(panelHeader);
			var panelTitle = panelConfig.title;
			panelHeader.classList.add("program-path-accordianheader");
			panelHeader.classList.add("toggler-header-collapsed");
			var spformUtil = new SPFormController();
			panelConfig.panelLinks.forEach(function (panelLink) {
				var interpolationSource = {userId: userId, scopeGroupId: scopeGroupId};
				if (panelConfig.programme && panelConfig.programme.length >0) {
					interpolationSource.ProgrammeCode = panelConfig.programme[0].ProgrammeCode;
				}
				var interpolatedActionUrl = panelLink.menuLink;
				try {
					interpolatedActionUrl = spformUtil.replaceTokens(interpolationSource, interpolatedActionUrl);
				} catch (e) {
					console.log("error interpolating menu link url", e);
				}
				console.log("interpolatedActionUrl", interpolatedActionUrl);
				var clickAction;
				if (panelLink.target && panelLink.target == '_blank') {
					clickAction = 'SambaashUtils.loadLink( '+"'"+interpolatedActionUrl+"'"+', true)';
				} else {
					clickAction = 'window.location='+"'"+interpolatedActionUrl+"'";
				}
				if (panelLink.showMenuValidationApi) {
					var interpolatedApiUrl = panelLink.showMenuValidationApi;
					try {
						interpolatedApiUrl = spformUtil.replaceTokens(interpolationSource, interpolatedApiUrl);
					} catch (e) {
						console.log("error interpolating API url", e);
					}
					console.log("interpolatedApiUrl", interpolatedApiUrl);
					showMenuLinkValidation(interpolatedApiUrl, function(data) {
						if (data) {
							if (SambaashUtils.isObject(data) && data.exception) {
								console.log("Validation API call failed", data)
							} else {
								console.log("show menu link", panelLink.menuText, data)
								panelTitle += '<a onclick="'+clickAction+'" class="rpecSummary">'+panelLink.menuText+'</a>';
								panelHeader.innerHTML = panelTitle;								
							}
						}
					});
				} else {
					panelTitle += '<a onclick="'+clickAction+'" class="rpecSummary">'+panelLink.menuText+'</a>';
				}
			});
			panelHeader.innerHTML = panelTitle;
			var schedContainer = document.createElement("DIV");
			schedContainer.classList.add("program-path-content");
			schedContainer.classList.add("toggler-content-collapsed");
			root.append(schedContainer);
			data.forEach(function (schedData) {
				if (panelConfig.hidePanelWhenEmpty && schedData.ScheduleData.length <=0 ) {
					return;
				}
				if (schedData.Name && schedData.Name != "_NA_") {
					var schedHeader = document.createElement("h4");
					schedHeader.innerText = schedData.Name;
					schedContainer.append(schedHeader);					
				}
				var table = document.createElement("table");
				schedContainer.append(table);
				var tableHeader = document.createElement("thead");
				table.append(tableHeader);
				
				// remove empty displayField columns
				var emptyFields = JSON.parse(JSON.stringify(panelConfig.displayFields));
				for (var x=0; x<schedData.ScheduleData.length; x++) {
					var rowData = schedData.ScheduleData[x];
					for (var i=emptyFields.length-1; i>=0; i--) {
						var field = emptyFields[i];
						// data found, remove from empty field list
						if (rowData[field.fieldName]) {
							emptyFields.splice(i, 1);
						}
					}
					if (emptyFields.length == 0) {
						break;
					}
				}
				if (panelConfig.hideColumnWhenEmpty) {
					// remove empty fields from field list
					emptyFields.forEach(function (emptyField) {
						for (var i=panelConfig.displayFields.length-1; i>=0; i--) {
							var field = panelConfig.displayFields[i];
							// data found, remove from empty field list
							if (emptyField.fieldName == field.fieldName) {
								panelConfig.displayFields.splice(i, 1);
							}
						}					
					});					
				}
				
				var tableHeaderInnerHTML = "<tr>";
				panelConfig.displayFields.forEach(function (field) {
					if ("__POPUP_MENU__" === field.fieldName) {
						tableHeaderInnerHTML += "<th></th>";
					} else {
						tableHeaderInnerHTML += "<th>"+field.label+"</th>";
					}
				});
				tableHeaderInnerHTML += "</tr>";
				tableHeader.innerHTML = tableHeaderInnerHTML;
	
				var tableBody = document.createElement("tbody");
				table.append(tableBody);
				var tableBodyContent = "";
				schedData.ScheduleData.forEach(function (rowData) {
					var dataRow = "<tr>";
					panelConfig.displayFields.forEach(function (field) {
						dataRow += "<td>";
						if ("__POPUP_MENU__" === field.fieldName) {
							dataRow += '<a href="#" class="threedot" id="threedot" title="Edit"></a>';
						} else {
							dataRow += rowData.hasOwnProperty(field.fieldName)?rowData[field.fieldName]:"";
						}
						dataRow += "</td>";
					});
					dataRow += "</tr>";
					tableBodyContent += dataRow;				
				});
				
				tableBody.innerHTML = tableBodyContent;
				
			});
		}
		
		var _init = function _init(_config, _studenData) {
			if (_studenData) {
				for (var i=0; i<_config.panels.length; i++) {
					if (!_config.panels[i].hidePanelWhenEmpty ||  (_studenData.programmePath[i] && _studenData.programmePath[i].data.length > 0)) {
						createNewPanel(_config.panels[i], _studenData.programmePath[i].data);
					}
				}
			}
		}
		
		return {
			init : _init
		}
		
	};

	AUI().on('domready', function () {
		var storageId = <%= configStorageId %>;
		console.log("Got config id", storageId);
		if (storageId > 0 ) {
	    	Liferay.Service(
			  '/SPDynamicForms-portlet.spdynamicforms/get-form-storage',
			  {formStorageId: storageId},
			  function(config) {
				  var mainTitle = config.hasOwnProperty("mainHeader") ? config.mainHeader : "Programme Tracker";
				  document.querySelector("#programmePathContainerTitle").innerText = mainTitle;
				  if (config.enableEnrolment) {
					  AUI().all(".enrolExamContainer").show();
					  document.querySelector(".enrolExamContainer.program-path-content").innerHTML = config.enrolmentPanelContent || "";
				  }
				  console.log("Got config", JSON.stringify(config));
				  console.log("Retrieving Student Record", <%= themeDisplay.getUserId() %>);
// 				  sample user 164121 - hhhdwdhg@gmail.com
				  Liferay.Service(
					  '/SPMicroservice-portlet.spmicroservice/retrieve-candidate-programme-path',
					  {
					    scopeGroupId: scopeGroupId,
					    candidateId: '<%= themeDisplay.getUserId() %>',
					    configJson: JSON.stringify(config)
					  },
					  function(studentData) {
						  var controller = new ProgrammePathContoller(AUI(), document.querySelector('#programmePathContainer'));
						  controller.init(config, studentData);
					  }
					);
		  	});
	    }
	    YUI().use(
	        'aui-toggler',
	        function(Y) {
	            new Y.TogglerDelegate({
	                animated: true,
	                closeAllOnExpand: true,
	                content: '.program-path-content',
	                expanded: false,
	                header: '.program-path-accordianheader',
	            });
	        }
        );		
	});	
</aui:script>
