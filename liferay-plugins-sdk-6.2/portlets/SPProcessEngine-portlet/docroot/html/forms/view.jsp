<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.sambaash.platform.srv.processbuilder.service.FormBuilderLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="java.sql.Date"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%@page import="com.sambaash.platform.srv.processbuilder.service.PERuleLocalServiceUtil"%>
<%@page import="com.sambaash.platform.pe.helpers.PEHelper"%>
<%@page import="com.liferay.portal.kernel.util.*"%>

<script src="/SPProcessEngine-portlet/js/rulesrepo/jquery.js"></script>

<portlet:defineObjects />


<!-- Resource URL for AJAX -->
<portlet:resourceURL id="unlockHtmlForm" var="unlockHtmlFormResourceURL"></portlet:resourceURL>

<!-- Resource URL for AJAX -->
<portlet:resourceURL id="lockHtmlForm" var="lockHtmlFormResourceURL"></portlet:resourceURL>



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
					<li><a class="active" href="/forms"><img
							src="/SPProcessEngine-portlet/images/icon-certificates.svg"
							alt="Forms">
							<p>Forms</p></a></li>
					<li><a href="/rules"><img
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
			
			<!--FILTER SEARCH END-->
			<div class="Table-Layout" id="tableId">
				<div class="Heading">
					<div class="Cell Span-width-20">
						<p>HTML Form Id</p>
					</div>
					<div class="Cell Span-width-40">
						<p>Form Name</p>
					</div>
					<div class="Cell">
						<p>Locked</p>
					</div>
					<div class="Cell">
						<p>Actions</p>
					</div>
				</div>
			<% 
				ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				JSONArray jsonArray = FormBuilderLocalServiceUtil.getFormsList(themeDisplay.getUserId());
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject step2JsonObject = jsonArray.getJSONObject(i);
					%>
					<div class="Row">
						<div class="Cell Span-width-20">
							<p id="ruleSetId" contenteditable="true"><%= step2JsonObject.getString("htmlFormId") %></p>
						</div>

						<div class="Cell Span-width-40">
							<p><%= step2JsonObject.getString("formName")%></p>
						</div>

						<div class="Cell">
							<p><%= step2JsonObject.getBoolean("locked")== true?"Yes":"No"%></p>
						</div>
						<div class="Cell">
						
							<a href="#" class="threedot addInfo" id="threedot"></a>
							<div id="popoverId" class="Pop-Action hide">
								<ul>
									<li><img
										src="/SPProcessEngine-portlet/images/icon-update.svg" alt="Update"><a target="_blank" 
										href="https://forms.sambaash.com/formbuilder/index.html?formId=<%= step2JsonObject.getString("htmlFormId")%>" >Update</a></li>
									<li><img
										src="/SPProcessEngine-portlet/images/icon-publish.svg" alt="Lock/Unlock"><a
										href="#" onclick=unlockHtmlForm('<%= step2JsonObject.getString("htmlFormId")%>','<%= !step2JsonObject.getBoolean("locked")%>');>Lock/Unlock</a></li>
								</ul>
							</div>
						</div>
					</div>
					<%
				}
			%>

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

	function setJSPFieldDisplay(element) {
		if (element.value === 'JSP') {
			document.getElementById('jspName').style.display = "block";

		} else {
			document.getElementById('jspName').style.display = "none";
		}

	}
	

	function findAncestor (el, cls) {
	    while ((el = el.parentElement) && !el.classList.contains(cls));
	    return el;
	}
	
</script>


<script type="text/javascript">

function unlockHtmlForm(htmlFormId, lock) {
	
	
	
	AUI().use('aui.io.request', function(A) {
		A.io.request('${unlockHtmlFormResourceURL}', {
			method : 'post',

			data : {
				<portlet:namespace />htmlFormId : htmlFormId,
				<portlet:namespace />lock : lock,
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
				 			bodyContent : 'HTML Form is updated sucessfully.'
						},
					});
				}
			}
		});
	});
	location.reload(true);
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

