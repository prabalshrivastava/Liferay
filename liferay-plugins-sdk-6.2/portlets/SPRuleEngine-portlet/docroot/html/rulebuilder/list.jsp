<%@ include file="/html/init.jsp" %>

<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>

<portlet:resourceURL var="resourceURL" >
<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
</portlet:resourceURL>

<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center"><h2><span>RULES LISTING</span></h2></aui:col>
					<aui:col span="2" cssClass="text-right"><aui:a href="#link" title="Back to Dashboard">Back to Home</aui:a></aui:col>
				</aui:row>
			</div>
		</div>
	</div>
	<div id='formio1' class="social-share margin-top-half text-center container" >
	
			
			<div class="dataListing">
				<div id="searchContainer" class="search-container container">
					<div class="inner-container">
						<aui:row>
		   					 <aui:col span="9">
		   					 	<aui:input cssClass="search-icon" type="text" name="text-code" placeholder="Search ${modelName}" onKeyPress="jsElasticSearchList(event,this.value);"/>
		   					 </aui:col>
		   					 <aui:col span="3" cssClass="text-right">
		   					 	<button id="oreder" Class="order"></button>
		   					 	<button id="setting" Class="setting header toggler-header-collapsed"></button>
		   					 	<button id="more" Class="more"></button>
		   					 	<button id="addnew" Class="addNew" onclick="RuleBuilderListController.onAddRecord(this)">ADD NEW</button>
		   					 </aui:col>
		   					</aui:row>
		   					<aui:row id="columns" cssClass="content toggler-content-collapsed">
		   					 <div class="column-list">
		   					 
		   					 </div>
		   				</aui:row>
	   				</div>
		   				
				</div>
				<div class="data-lising">
					<table id ="tableId" class="aui">
					    <thead>
					        <tr class="Heading" >
					        <th>ID</th>
							<th>Rule Set</th>
							<th>Component Type</th>
							<th>Component ID</th>
							<th>No. of Rules</th>
							<th>Date Created</th>
							<th style="text-align: center;">Actions</th>
					        </tr>
					    </thead>
					    <tbody>
					       	<tr id="rules_table_row" class="rules_table_row Row">
						        <td><label id="rul_id" class="rul_id">ID</label></td>
								<td><label id="rul_set" class="rul_set">Rule Set</label></td>
								<td><label id="rul_CompType" class="rul_CompType">Component Type</label></td>
								<td><label id="rul_CompId" class="rul_CompId">Component ID</label></td>
								<td><label id="rul_No" class="rul_No">No. of Rules</label></td>
								<td><label id="rul_Date" class="rul_Date">Date Created</label></td>
								<td> </td>
							</tr>
					        
					    </tbody>
					</table>
					
				</div>
				<div class="pagination">
						<aui:row>
							<aui:col span="6" cssClass="text-left">
								<aui:select cssClass="itemsPerPage" name="itemsPerPage" label="Items per page:">
									<aui:option value="5">5</aui:option>
									<aui:option value="10" selected="true">10</aui:option>
									<aui:option value="20">20</aui:option>
									<aui:option value="50">50</aui:option>
									<aui:option value="100">100</aui:option>
								</aui:select>
								
							</aui:col>
							<aui:col span="6" cssClass="text-right myPagination aui-pagination">
								<div id="jslarge" class="pagination myPagination pagination-large"></div>
							</aui:col>
						</aui:row>
					</div>
				<div class="no-data-listing" style="display:none">
					
					<div class="sambaashContent">
						<div class="container nodates">
							<aui:row>
								<aui:col span="12" cssClass="text-center">
									<h3 id="h3message" class="no-data-listing-message">No Rule Sets</h3>
									<p id="pmessage" class="no-data-listing-message">There aren't any records of existing Rule Sets as of now.
	If you would like to create a new one, please click on the 'ADD NEW' button.</p>
									<a id="ahrefmessage" href="#link" title="BACK TO DASHBOARD" class="btn lightbluebtn">BACK TO DASHBOARD</a>
								</aui:col>
							</aui:row>
						</div>
					</div>
				</div>
				
			</div>
			<div id="threedot" >
				<a href="#" class="threedot addInfo" ><img src="/html/images/big.png" alt="Details"></a> 
				<div id="popoverId" class="Pop-Action hide"> 
					<ul> 
						<li><img src="/html/images/edit.png" alt="Edit"><a href="javascript:void(0);" onclick="RuleBuilderListController.trigger('edit',this);">Edit</a></li> 
						<li class="activate"><img src="/html/images/de-active.png" alt="Delete"><a href="javascript:void(0);" onclick="RuleBuilderListController.trigger('delete',this);">Delete</a></li>
					</ul> 
				</div> 
			</div>
	</div>
</div>

<script>
	var RuleBuilderListController = function RuleBuilderListController() {
		var config;
		// base elements
		var table, tbody, baseRow, threedot, modelName;
		var portletId;
		var renderUrl;
		
		var _load = function _load(_config) {
			config = _config;
			_cloneBaseElements();
			_getRuleListing();
			portletId = config.namespace.replace(/(^\_+|\_+$)/mg, '');

	    	AUI().use('liferay-portlet-url', function(A) {
	    		renderUrl = Liferay.PortletURL.createRenderURL();
			    renderUrl.options.basePortletURL = window.location.pathname;
			    renderUrl.setPortletId(portletId);
			    renderUrl.setWindowState("normal");	    		
	    	});
		}
		
		var _findAncestor = function _findAncestor (el, cls) {
		    while ((el = el.parentElement) && !el.classList.contains(cls));
		    return el;
		}
		
		var _cloneBaseElements = function () {
			table=document.getElementById("tableId");
			tbody=table.getElementsByTagName("tbody")[0];
			baseRow=tbody.getElementsByClassName("rules_table_row")[0];
			threedot = document.getElementById("threedot");
			modelName="Rules";
			while (tbody.hasChildNodes()) {
				tbody.removeChild(tbody.lastChild);
			}
		}
		
		var _getRuleListing = function _getRuleListing() {
			SambaashUtils.resourceAction(config.ajaxUrl, "elastiSearchList", "GET", 
					config.namespace, null,
			  function success() {
				var data = this.get("responseData");
				console.log("listing");
				console.log(data);
				_drawListTable(data);
			});
		}

		var _drawListTable = function _drawListTable(listOfRules){
			while (tbody.hasChildNodes()) {
				tbody.removeChild(tbody.lastChild);
			}
			
			for(var i=0;i<listOfRules.length;i++){
				var cRow=baseRow.cloneNode(true);
				
				cRow.getElementsByClassName("rul_id")[0].innerHTML=listOfRules[i].id;
				cRow.getElementsByClassName("rul_set")[0].innerHTML=listOfRules[i].name;
				cRow.getElementsByClassName("rul_CompType")[0].innerHTML=listOfRules[i].type;
				cRow.getElementsByClassName("rul_CompId")[0].innerHTML=listOfRules[i].componentId;
				cRow.getElementsByClassName("rul_No")[0].innerHTML=listOfRules[i].rules.length;
				cRow.getElementsByClassName("rul_Date")[0].innerHTML=listOfRules[i].createdDate;
				
			        
		        var td = cRow.lastElementChild;  
		        var dot3=threedot.cloneNode(true);
		        td.appendChild(dot3);
				tbody.appendChild(cRow);
			}
			
			 YUI().use("node", "event", function(A) {
		         var j = A.all(".threedot");
		         j.on("click", function(o) {
		             o.preventDefault();
		             o.stopPropagation();
		             var p = document.getElementsByClassName("Pop-Action");
		             for (var l = 0; l < p.length; l++) {
		                 p[l].classList.add("hide")
		             }
		             var m = o.currentTarget;
		             var n = m.next();
		             n.removeClass("hide")
		         })
		     })
		     YUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated',
		 				'stylesheet','aui-datepicker','overlay','event', 'widget-anim', function(A){
		 			
		 			var container = A.one('body');
		 			container.on('click', function(e){
		 				var actionsBox = document.getElementsByClassName('Pop-Action');
		 				for(var k = 0;k< actionsBox.length;k++){
		 					actionsBox[k].classList.add('hide');
		 				}
		 			});
		 			
		 		});
		}
		
		var _onAddRecord = function _onAddRecord(d){
		    renderUrl.setParameter("jspPage", config.createPage);
		    window.location.href = renderUrl.toString();
		}
		
		var _doAction = function _doAction(action,d) {	 
		   var c = _findAncestor(d, "Row");
		   var a = [];
		   for (var b = 0; b < c.childElementCount; b++) {
		       a.push(c.children[b].textContent.trim())
		   }
		   switch (action) {
			case 'edit':
			   renderUrl.setParameter("jspPage", config.editPage);
			   renderUrl.setParameter("storageId", a[0]);
			   window.location.href = renderUrl.toString();				
				break;
				
			case 'delete':
				SambaashUtils.resourceAction(config.ajaxUrl, "deleteRuleSet", "GET", 
                		config.namespace, a[0],
    			  function success() {
                    alert("Rule Set "+a[0]+" deleted.");
                    window.location.href = window.location.pathname;
    			});		
				break;
	
			default:
				break;
			}
		}
		
		return {
			load : _load,
			onAddRecord: _onAddRecord,
			trigger: _doAction
		};
	}();
	
	AUI().on('domready', function () {
		var _config = {
			ajaxUrl: "<%= resourceURL.toString() %>",
			namespace: "<portlet:namespace/>",
			createPage: "/html/rulebuilder/create.jsp",
			editPage: "/html/rulebuilder/edit.jsp"
		};
		
		RuleBuilderListController.load(_config);
	});	

</script>