<%@page import="java.sql.Date"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@page import="com.sambaash.platform.srv.processbuilder.service.PERuleLocalServiceUtil"%>
<%@page import="com.sambaash.platform.pe.helpers.PEHelper"%>
<%@page import="com.liferay.portal.kernel.util.*"%>

<script src="/SPProcessEngine-portlet/js/rulesrepo/jquery.js"></script>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<!-- Resource URL for AJAX -->
<portlet:resourceURL id="addNewRuleTable" var="fromUpdateResourceURL"></portlet:resourceURL>

<!-- Resource URL for AJAX -->
<portlet:resourceURL id="updateFormID" var="updateResourceURL"></portlet:resourceURL>

<!-- Resource URL to delete the rule set from table -->
<portlet:resourceURL id="deleteRulesSetID" var="deleteResourceURL"></portlet:resourceURL>

<!-- Resource URL to delete the rule set from table -->
<portlet:resourceURL id="publishRuleSetId" var="publishRuleSetURL"></portlet:resourceURL>

<!-- Resource URL to publish the rule set -->
<portlet:resourceURL id="searchRuleSetId" var="searchRuleSetURL"></portlet:resourceURL>


<!--***PROCESS TOP HEADER-->
<section class="SectionHeader">
	<div class="HeaderContainer">
		<div class="HeaderRow">
			<div class="ProcessHeader">
				<div class="ProcessBack">
					<a href="" title=""> <img alt="Go Back"
						src="/SPProcessEngine-portlet/images/left-arrow.svg">
						<p>Back</p>
					</a>
				</div>
				<div class="ProcessTitle">
					<img alt="Build"
						src="/SPProcessEngine-portlet/images/setting-header.svg">
					<h2>Build</h2>
				</div>
				<div class="ProcessLink">
					<div class="ProcessNotify">
						<a href="" title=""><img
							src="/SPProcessEngine-portlet/images/icon-notify.svg" alt="Notify"></a>
					</div>
					<div class="ProcessDropdown">
						<a href="" title=""><img
							src="/SPProcessEngine-portlet/images/icon-tools.svg" alt="Process Options"></a>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!--***PROCESS TOP HEADER END-->

<!--PROCESS NAVIGATION-->
<section class="Section-ProcessNav">
	<div class="ProcessNav-Container">
		<div class="ProcessNavRow">
			<div class="ProcessNav-Notes">
				<h2>Rules</h2>
				<p>Create Rules to execute conditions and to construct the
					Process.</p>
			</div>
			<div class="ProcessNav-Link">
				<ul>
					<li><a href="/forms"><img
							src="/SPProcessEngine-portlet/images/icon-certificates.svg"
							alt="Forms">
							<p>Forms</p></a></li>
					<li><a class="active" href="/rules"><img
							src="/SPProcessEngine-portlet/images/flow-chart-interface-symbol.svg"
							alt="Rules">
							<p>Rules</p></a></li>
					<li><a href="/process-builder"><img
							src="/SPProcessEngine-portlet/images/data-analytics-interface.svg"
							alt="Process">
							<p>Process</p></a></li>
				</ul>
			</div>
		</div>
	</div>

</section>

<!--PROCESS NAVIGATION END-->

<div class="enrollmentContainer screen-max-width ">
	<div class="enrollmentRow margin-top-40">

		<div class="mainContentContainer roundedborder">
			<!--FILTER SEARCH-->
			<div class="SearchBar-Container">
				<div class="Searchdiv Span-width-30">
					<div class=" Icon-Search ">
						<img
							src="/SPProcessEngine-portlet/images/ios-search-ion-icons.png"
							alt="Search" onclick="searchCriteriaChange()">
					</div>
					<input id="searchText" name="searchText" placeholder="search"
						type="text" value="" onkeypress="initialiseSearch(event)" />
				</div>
				<div class="btn-process">
					<a id="createNew" href="#" onclick="displayMessage1()">Add a
						Rule Set</a>

				</div>
			</div>
			<!--FILTER SEARCH END-->
			<div class="Table-Layout" id="tableId">
				<div class="Heading">
					<div class="Cell Span-width-5">
						<p>ID</p>
					</div>
					<div class="Cell Span-width-40">
						<p>Rule Set</p>
					</div>
					<div class="Cell">
						<p>Component Type</p>
					</div>
					<div class="Cell">
						<p>Component ID</p>
					</div>
					<div class="Cell">
						<p>No. of Rules</p>
					</div>

					<div class="Cell Span-width-10">
						<p>Date Created</p>
					</div>
					<div class="Cell">
						<p>Actions</p>
					</div>
				</div>

				<c:forEach items="${rules}" var="tableContent">

					<div class="Row">
						<div class="Cell Span-width-5">
							<p id="ruleSetId" contenteditable="true">${tableContent.spPERuleSetId}</p>
						</div>

						<div class="Cell Span-width-40">
							<p>${tableContent.name}</p>
						</div>

						<div class="Cell">
							<p>${tableContent.componentType}</p>
						</div>
						
						<div class="Cell">
							<p>${tableContent.componentId}</p>
						</div>
						
						<div class="Cell">
						
							
						<c:set var="ruleSetId" value="${tableContent.spPERuleSetId}" scope="request"/>
						<%
						 Object ruleSetId = request.getAttribute("ruleSetId");
						 long count = PERuleLocalServiceUtil.findByRuleSetId(GetterUtil.getLong(ruleSetId)).size();
						%>
							 <p ><%= count %> </p> 
						</div>

						<div class="Cell Span-width-10">
						<c:set var="createDate" value="${tableContent.createDate}" scope="request"/>
						<%
						 	Object createDate = request.getAttribute("createDate");
						 	String createDateFormatted = PEHelper.getDateStrddMMYYYYHMS(GetterUtil.getDate(createDate, DateFormatFactoryUtil.getSimpleDateFormat("yyyyMMddHHmmss")));
						%>
							<p><%= createDateFormatted %></p>
						</div>

						<div class="Cell">
						
							<a href="#" class="threedot addInfo" id="threedot"></a>
							<div id="popoverId" class="Pop-Action hide">
								<ul>
									<li><img
										src="/SPProcessEngine-portlet/images/icon-update.svg" alt="Update"><a
										href="#" onclick=updateRule(this,"${tableContent.formVersion}");>Update</a></li>
									<li><img
										src="/SPProcessEngine-portlet/images/icon-publish.svg" alt="Publish"><a
										href="#" onclick=publishRule(this);>Publish</a></li>
									<li><img
										src="/SPProcessEngine-portlet/images/icon-cancel.svg" alt="Delete"><a
										href="#" onclick=deleteRule(this);>Delete</a></li>
								</ul>
							</div>
						</div>
					</div>

				</c:forEach>

			</div>
		</div>

	</div>
</div>

<aui:script use="liferay-portlet-url">
// DONT REMOVE THIS SCRIPTLET: just to make sure Liferay.PortletURL is loaded
</aui:script>




<script type="text/javascript">

	//var baseURL = 'https://api.forms.sambaash.com';
	var hideVar = null;

</script>
<script type="text/javascript">

	function setFormOptions(element) {		
		var optionSrc;
		var optionSrcUrl;
		document.getElementById('formOptionGrp').innerHTML = '';
		if (element.value === '2') {
			optionSrc = 'formV2List';
// 			optionSrcUrl = 'https://forms.localsambaash.com/v2/forms/list?idp=relc.localsambaash.com';	
			optionSrcUrl = '/SPProcessEngine-portlet.formbuilder/get-v2-forms-list';	
		} else {
			optionSrc = 'formV1List';
			optionSrcUrl = '/SPProcessEngine-portlet.formbuilder/get-forms-list';
		}

		if (document.getElementById(optionSrc).innerHTML) { 
			document.getElementById('formOptionGrp').innerHTML = document.getElementById(optionSrc).innerHTML;
		} else {
			try {
				getFormOptions(optionSrcUrl,
					function(formOption){
						document.getElementById(optionSrc).innerHTML = formOption;
						document.getElementById('formOptionGrp').innerHTML = formOption;
					}
				);
			} catch(e) {
				console.log(e)
			}
		}

	}

	function setJSPFieldDisplay(element) {
		if (element.value === 'JSP') {
			document.getElementById('jspName').style.display = "block";

		} else {
			document.getElementById('jspName').style.display = "none";
		}

	}

	function showCreateFormDialog(formOptions) {
		console.log(">>>>> inside showCreateFormDialog");
		AUI()
		.use(
				'aui-node',
				'aui-base',
				'aui-dialog',
				'liferay-util-window',
				'aui-overlay-manager-deprecated',
				'dd-constrain',
				'aui-aria',
				function(A) {
					titleMsg = "Rule-Set Details";
					var dialog = Liferay.Util.Window
							.getWindow({
								title : titleMsg,
								dialog : {
									bodyContent : '<form id = "formData" action="">Name<br>' +

												  '<input type = "text" name = "<portlet:namespace />formName" />'+
													'<select id="formV1List" style="display:none">'+formOptions+'</select>' +
													'<select id="formV2List" style="display:none"></select>' +
													'<select id="formVersion" name="<portlet:namespace />formVersion" onchange="setFormOptions(this)"><option value="1" onclick="">Form Version 1</option><option value="2" onclick="">Form Version 2</option></select>' +
												   '<select id = "componenets" name = "<portlet:namespace />selectOption" onchange="setJSPFieldDisplay(this)">'+
												   	   '<optgroup label="Forms" id="formOptionGrp">' +
												   	    formOptions +
													   '<optgroup label="Process">'+
													   '<option value = "PROCESS">Process</option>' +
													   '<optgroup label="Custom Logic (only for developers)">' +
													   '<option value = "JSP" onclick="">Java Server Pages</option>' +
												   '</select><br>'+

												   '<input id = "jspName" type = "text" style = "display : none" name = "<portlet:namespace />jspName" placeholder="Enter The JSP name" />' +

												   '<input type = "text" style = "display : none" name = "<portlet:namespace />status" />'+
												   '</form>',
									centered : true,
									//cache: false,
									destroyOnClose : true,
									destroyOnHide : true,
									height : 400,
									width : 300,
									stack : true,
									modal : false,
									constrain2view : true,
									toolbars : {
										footer : [ {
											label : 'Cancel',
											on : {
												click : function() {
													dialog.hide();
												}
											}
										}, {
											label : 'Save',
											on : {
												click : function() {
													addRuleSetAjax();
												}
											}
										} ]
									}

								}
							})
					hideVar = dialog;
					dialog.render();

				});

	}
	function displayMessage1() {

		Liferay.Service(
				  '/SPProcessEngine-portlet.formbuilder/get-forms-list',
				  {
				    userId: Liferay.ThemeDisplay.getUserId()
				  },
				  function(data) {
				    //console.log(data);
				    data =  JSON.parse(data);
				    
				    var formOption = '';
					  for (var i=0;i< data.length;i++) {
						  formOption = formOption + '<option value="'+ data[i].htmlFormId +'">' + data[i].htmlFormId + ' - ' 
						  + data[i].formName + '</option>';
					  }

					  showCreateFormDialog(formOption);

				  }
				);

	}

	function getFormOptions(srcUrl, callback) {
		Liferay.Service(
				  srcUrl,
				  {
				    userId: Liferay.ThemeDisplay.getUserId()
				  },
				  function(data) {
				    data =  JSON.parse(data);
				    var formOption = '';
					  for (var i=0;i< data.length;i++) {
						  formOption = formOption + '<option value="'+ data[i].htmlFormId +'">' + data[i].htmlFormId + ' - ' 
						  + data[i].formName + '</option>';
					  }
					  callback(formOption);
				  }
		);
		/*
		AUI().use('aui.io.request','liferay-portlet-url', function(A) {
			A.io.request('http://localhost:4000/forms/list', {
				method : 'get',
				headers: {
				      'Authorization':'Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJzZXJ2ZXIiXSwiZXhwIjoxNTM0NTYzOTgwLCJhdXRob3JpdGllcyI6WyJST0xFX1RSVVNURURfQ0xJRU5UIiwiUk9MRV9DTElFTlQiXSwianRpIjoiODRjODc1YjQtOTA2Ny00YWNhLTlmYTMtYzgxYTIwNzJhZWY1IiwiY2xpZW50X2lkIjoiZm9ybS1zZXJ2aWNlIn0.dPwgpLA5-LivxPg3CWjWbLZM1PO_hI7a_GQUZKD9L_s'
				   },
				on : {
					success : function() {
						var data=JSON.parse(this.get('responseData'));
						var formOption = '';
					  for (var i=0;i< data.length;i++) {
						  formOption = formOption + '<option value="'+ data[i].htmlFormId +'">' + data[i].htmlFormId + ' - ' 
						  + data[i].formName + '</option>';
					  }
					  callback(formOption);
					}
				}
			});
		});*/
	}

	/**
	   opens the RuleSet Detail page for update
	*/

	function updateRule(element, formVersion) {
		   
		var ancestor = findAncestor (element, "Row");
		var values = [];
		for (var i=0; i < ancestor.childElementCount; i++){
			values.push(ancestor.children[i].textContent.trim());
		}

		var renderURL = Liferay.PortletURL.createRenderURL();
		renderURL.setParameter("mvcPath", "/html/rulesrepo/addRuleSet.jsp");
		renderURL.setParameter("ruleSetId",values[0]);
		renderURL.setParameter("ruleSetName",values[1]);
		renderURL.setParameter("ComponentType",values[2]);
		renderURL.setParameter("ComponentId",values[3]);
		renderURL.setParameter("isUpdate",true);
		renderURL.setParameter("formVersion",formVersion);
		renderURL.setPortletId("rulesrepository_WAR_SPProcessEngineportlet");
		renderURL.setWindowState("<%=LiferayWindowState.NORMAL.toString()%>");

		window.location.href = renderURL.toString();
		
		document.getElementById("searchText").value = null;

	}

	function findAncestor (el, cls) {
	    while ((el = el.parentElement) && !el.classList.contains(cls));
	    return el;
	}
	
</script>

<script type="text/javascript">

var ruleSetIdOfClickedRow = null;
var ruleSetNameOfClickedRow = null;
var componentTypeOfClickRow = null;
var buttonForClickedRow = null;
var componentIdOfClickRow = null;

</script>

<script type="text/javascript">

function publishRule(element) {
	
	var ancestor = findAncestor (element, "Row");
	var ruleSetIdOfClickedRow = ancestor.children[0].textContent.trim();
	
	AUI().use('aui.io.request', function(A) {
		A.io.request('${publishRuleSetURL}', {
			method : 'post',

			data : {
				<portlet:namespace />tableRowId : ruleSetIdOfClickedRow,
			},
			
			on : {
				success : function() {
					
					//show success message...
					var dialog1 = Liferay.Util.openWindow({
						dialog: { 
							centered: true, 
							height: 160, 
							modal: false, 
							width: 300,
							/* toolbars : {
								footer : [ {
									label : 'Ok',
									on : {
										click : function() {
											dialog1.hide();
										}
									}
								} ]
							}, */
				 			bodyContent : 'Ruleset is published sucessfully.'
						},
					});
				}
			}
		});
	});
	location.reload(true);
}

function deleteRule(element) {
	
	var ancestor = findAncestor (element, "Row");
	var ruleSetIdOfClickedRow = ancestor.children[0].textContent.trim();
		
 	Liferay.Util.openWindow({
		dialog: { 
			centered: true, 
			height: 200, 
			modal: false, 
			width: 300,
			
			toolbars : {
				footer : [ {
					label : 'No',
					on : {
						click : function() {
							location.reload(true);
						}
					}
				}, {
					label : 'Yes',
					on : {
						click : function() {
							deleteRulesSet(ruleSetIdOfClickedRow);
							location.reload(true);
						}
					}
				} ]
			},
			
 			bodyContent : 'Do you want to delete RuleSet?'
		},
	});
}

</script>

<script type="text/javascript">

	function deleteRulesSet(ruleSetIdOfClickedRow) {

		AUI().use('aui.io.request', function(A) {
			A.io.request('${deleteResourceURL}', {
				method : 'post',

				data : {
					<portlet:namespace />tableRowId : ruleSetIdOfClickedRow,
				},

				on : {
					success : function() {
						Liferay.Util.openWindow({
							dialog: { 
								centered: true, 
								height: 200, 
								modal: false, 
								width: 300,
								bodyContent : 'RuleSet deleted sucessfully'	
							}
						})
					}
				}
			});
		});

	}
</script>

<script type="text/javascript">
	function updateFormID() {

		AUI().use('aui.io.request', function(A) {
			A.io.request('${updateResourceURL}', {
				method : 'post',

				data : {
					<portlet:namespace />updateformIDView : "",
				},

				on : {
					success : function() {
						//hideVar.hide();
						createRenderURL();
						window.location.href = '${addEntryURL}';

					}
				}
			});
		});

	}
</script>

<script type="text/javascript">

	var myURL;

	function createRenderURL(formId, formName) {

		AUI().use('liferay-portlet-url', function(A) {

			var renderURL = Liferay.PortletURL.createRenderURL();
			renderURL.setParameter("mvcPath", "/html/rulesrepo/addRuleSet.jsp?FormId="+ formId +"&formName="+formName);
			renderURL.setWindowState("<%=LiferayWindowState.NORMAL.toString()%>");
			renderURL.setParameter("FormId",formId);
			renderURL.setParameter("FormName",formName);
			renderURL.setPortletId("helloworld_WAR_helloworldportlet");
			myURL = renderURL;
		});
	}
</script>

<script type="text/javascript">
	function jspField() {
		document.getElementById('jspTextField').style.display = "block";
	}
</script>

<script type="text/javascript">

	function addRuleSetAjax() {

		AUI().use('aui.io.request','liferay-portlet-url', function(A) {
			A.io.request('${fromUpdateResourceURL}', {
				method : 'post',

				form : {
					id : 'formData'
				},

				on : {
					success : function() {
						//alert('data recieved : ' + (JSON.parse(this.get('responseData'))).formId);
						var newFormID = JSON.parse(this.get('responseData')).ruleSetId;
						var formName = JSON.parse(this.get('responseData')).ruleSetName;
						var componentID = JSON.parse(this.get('responseData')).componentId;
						var componentType = JSON.parse(this.get('responseData')).componentType;
						var formVersion = "1";
						try {
							formVersion = JSON.parse(this.get('responseData')).formVersion;
						} catch (e) {
							console.log('unable to get form version, defaulting to version 1');
						}

						var renderURL = Liferay.PortletURL.createRenderURL();

						renderURL.setParameter("mvcPath", "/html/rulesrepo/addRuleSet.jsp");
						renderURL.setParameter("ruleSetId",newFormID);
						renderURL.setParameter("ruleSetName",formName);
						renderURL.setParameter("ComponentId",componentID);
						renderURL.setParameter("ComponentType",componentType);
						renderURL.setParameter("isUpdate",false);
						renderURL.setParameter("formVersion",formVersion);
						renderURL.setPortletId("rulesrepository_WAR_SPProcessEngineportlet");
						renderURL.setWindowState("<%=LiferayWindowState.NORMAL.toString()%>");

						window.location.href = renderURL.toString();

					}
				}
			});
		});

	}
</script>

<script>
		YUI().use('node','event', function (Y) {
			var contextMenu = Y.all('.threedot');
			
			contextMenu.on('click', function(e){
				e.preventDefault();
				e.stopPropagation();
				var actionsBox = document.getElementsByClassName('Pop-Action');
				for(var k = 0;k<actionsBox.length;k++){
					actionsBox[k].classList.add('hide');
				}
							var targ = e.currentTarget;
							var next = targ.next();
							next.removeClass('hide');
			});
			
			
		
		});
		
		AUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated',
				'stylesheet','aui-datepicker','overlay','event', 'widget-anim', function(A){
			
			var container = A.one('body');
			container.on('click', function(e){
				var actionsBox = document.getElementsByClassName('Pop-Action');
				for(var k = 0;k<actionsBox.length;k++){
					actionsBox[k].classList.add('hide');
				}
			});
			
		});
</script>

<script type="text/javascript">

function initialiseSearch(event){

	if(event.keyCode ==  13){
		searchCriteriaChange();
	}
}

function searchCriteriaChange(){
	
	var searchText = document.getElementById("searchText").value;
	
	AUI().use('aui.io.request', function(A) {A.io.request('${searchRuleSetURL}', {
		method : 'get', 
		data : {<portlet:namespace />searchText : searchText},
		on : {
			success : 
				function() {
					tableData = JSON.parse(this.get('responseData')).ruleSets;
					reloadTable(tableData);
				}
		}
	});});
}


function reloadTable(tableData){
	var tableDiv = document.getElementById('tableId');
	var headingChildrenDivs = document.querySelectorAll('#tableId .Heading div');
	var tableRowDivClone = document.querySelector('#tableId .Row').cloneNode(true);
	
	var dummyEntityTableHeadings = ["ID","Rule Set","Component Type","Component ID","No. of Rules","Date Created","Actions"];
	
	
		for(var idx=0;idx<headingChildrenDivs.length;idx++){
			headingChildrenDivs[idx].querySelector('p').innerHTML = dummyEntityTableHeadings[idx];
		}
		 
		
		clearTableData();
		
		var clonedNodeDivs;
		for(var inx=0;inx<tableData.length;inx++){
			
			
			var newRow = tableRowDivClone.cloneNode(true);
			clonedNodeDivs = newRow.querySelectorAll('div');
			
			clonedNodeDivs[0].querySelector('p').innerHTML = tableData[inx].spPERuleSetId;
			clonedNodeDivs[1].querySelector('p').innerHTML = tableData[inx].name;
			clonedNodeDivs[2].querySelector('p').innerHTML = tableData[inx].componentType;
			clonedNodeDivs[3].querySelector('p').innerHTML = tableData[inx].componentId;
			clonedNodeDivs[4].querySelector('p').innerHTML = tableData[inx].ruleCount;
			clonedNodeDivs[5].querySelector('p').innerHTML = tableData[inx].createDate ? tableData[inx].createDate : '...';
			
			tableDiv.appendChild(newRow);
		}
		
		YUI().use('node','event', function (Y) {
			var contextMenu = Y.all('.threedot');
			
			contextMenu.on('click', function(e){
				e.preventDefault();
				e.stopPropagation();
				var actionsBox = document.getElementsByClassName('conextMenuDiv');
				for(var k = 0;k<actionsBox.length;k++){
					actionsBox[k].classList.add('hide');
				}
							var targ = e.currentTarget;
							var next = targ.next();
							next.removeClass('hide');
			});
		
		});
		
		
	}


function clearTableData(){
	//clear table contents 
	var elements=document.getElementById('tableId').getElementsByClassName('Row');
	   while(elements.length){
	       elements[0].parentNode.removeChild(elements[0]);
	}
}
</script>

