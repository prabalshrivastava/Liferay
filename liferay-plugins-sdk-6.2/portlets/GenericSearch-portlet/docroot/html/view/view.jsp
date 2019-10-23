<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="com.sambaash.platform.genericsearch.helper.GenericSearchFavouriteHelper"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.liferay.compat.portal.kernel.util.ListUtil"%>
<%@page import="com.sambaash.platform.genericsearch.model.GenericSearchConfig"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.sambaash.platform.genericsearch.GenericSearchConstants"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'> 
<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:renderURL var="renderURL">
	<portlet:param name="<%=GenericSearchConstants.PARAM_LOAD_OBJECTS%>"
		value="<%=GenericSearchConstants.PARAM_LOAD_OBJECTS%>" />
</portlet:renderURL>
<portlet:resourceURL id="resourceUrl" var ="resourceUrl">
	<portlet:param name="sp_p_auth" value="<%= AuthTokenUtil.getToken(request) %>"/>
</portlet:resourceURL>
<script src="/GenericSearch-portlet/js/modernizr.custom.js"></script>

<%
	Object obj = renderRequest.getAttribute(GenericSearchConstants.ATTRIB_CONFIG_OBJ);
	
	if (Validator.isNotNull(obj)) {
		GenericSearchConfig configObj = (GenericSearchConfig) obj;
%>
<div class="newPortlets">
<div class="generic-search-container max-width" id="generic-search-wrapper">
	<div class="generic-search-row">
		<div class="gs-listingsection <%=configObj.getLeftFilterPlacement()?"left":"top" %>">
			<% 
				String resultsclass = "full-width";
				String shouldHide = "hide";
				if(!configObj.getHideFitlers()) {
					if(ListUtil.isNotEmpty(configObj.getFilters())) {
			%>
			<div class="generic-search-filters " id="generic-search-filters">
			    <div class="outer">
  					<div class="inner" onclick="hide('generic-search-filters')">
  						<img alt="Close" src="/GenericSearch-portlet/images/close.svg">
	  				</div>
				</div>
				<%@include file="/html/view/filters.jsp" %>
			</div>
			<% resultsclass = ""; 
			   shouldHide = "";
					}
			   }
			%>
			<div class="generic-search-results-wrapper <%=resultsclass%>">
				<div class="gs-sort-filter">
		               <div class="gs-sort-filterwrap gs-margin-bottom10">
		                <% if(configObj.getDateFitlers()) { %> 
		               	<div class="gs-sort-datediv lfr-input-date" id="startDateContainer">
 							<div class="gs-text-date-icon"><img src="/GenericSearch-portlet/images/calendar-ion-icons.png" alt="Start Date"></div>
 							    <input type="text" name="startDate" id="startDate" placeholder='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.start.date")%>' onchange="dateSelectionChange()"/>
						</div>
						<div class="gs-sort-datediv lfr-input-date"  id="endDateContainer">

							<div class="gs-text-date-icon"><img src="/GenericSearch-portlet/images/calendar-ion-icons.png" alt="End Date"></div>
 							    <input type="text" name="endDate" id="endDate" placeholder='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.end.date")%>' onchange="dateSelectionChange()"/>
 						
 							
						</div>
						
                            
					 <% } %> 
		               	<% if(configObj.getSortFitlers()) { %> 	
		                   <div class="gs-sort-sortingdiv">
		                       <label>Sort by</label>
		                       <%@include file="/html/view/sort.jsp" %>
		                   </div>
		                 <% } %> 
		                  
							<% 
							boolean showExportButton = !configObj.getHideExports();
							if (configObj.getAdminOnlyExports()) {
								boolean isAdmin = SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())
										|| SambaashUtil.isFoundryAdmin(themeDisplay.getUser())
										|| SambaashUtil.isSupportRole(themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
								showExportButton = showExportButton && isAdmin;
							}
							if(showExportButton) { 
							%>
								<div class="gs-export progress-button">
									<button><span><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.export")%>'/></span></button>
										<svg class="progress-circle" width="40" height="40"><path d="M36.217,19.468c0,9.285-7.527,16.812-16.811,16.812c-9.285,0-16.811-7.526-16.811-16.812
										c0-9.284,7.526-16.811,16.811-16.811C28.689,2.657,36.217,10.184,36.217,19.468z"/></svg>
                    					</svg>
                    					<svg class="checkmark" width="40" height="40">
                        				<path d="m16.25,30.5l15.3,-23.2" />
                        				<path d="m16.25,30.5l-8.5,-7.1" />
                    					</svg>
                    					<svg class="export-cross" width="40" height="40">
                        				<path d="m17.5,17.5l-9.3,-9.3" />
                        				<path d="m17.5,17.5l9.3,9.3" />
                        				<path d="m17.5,17.5l-9.3,9.3" />
                        				<path d="m17.5,17.5l9.3,-9.3" />
                    					</svg>
								</div>
							 <% } %>
							 <div class="gs-mobile-filtericon <%=shouldHide%>">
		                   		<a href="#" title="" class="filterIcon" onclick="show('generic-search-filters')">
		                   			<img src="/GenericSearch-portlet/images/filter-tool.svg" alt="Search">
		                   		</a>
		                   </div>
		                     <!-- MY FAVOURITES -->
		                   <% if (!configObj.getHideFavourites()) { %>
		                    <div class='adfDropdown' id='addtofav-adfDropdown'>
							 <%@include file="/html/view/add-to-favourite.jsp" %>
							</div>
							<% } %>
		               </div>
		               <div class="gs-sort-filterwrap">
		               <%if(!configObj.getDisableTextSearch()) { %>
			                   <div class="gs-sort-searchdiv">
			                    <div class="gs-text-search-icon"><img src="/GenericSearch-portlet/images/searchFilter.svg" alt="search"></div>
			                     <div class="genericTags" style="display: none;">
			                    	 <ul> </ul>
			                     </div>
			                      <input type="text" name="user-text-search" id="user-text-search" value="" placeholder='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.search")%>'>

			                      
			                   </div>
		                   <%} %>
		               </div>
		           </div>
		           <div class="pre-loader-div">
		           <div class="container content">
		           <div class="topExam">
		           <% if(!configObj.getTitleForResultsList().isEmpty()){ %>
		            	<h6><%=configObj.getTitleForResultsList() %></h6>
		            	<%} %>
   						<div class="examList">
		           		
	           	   		<div class="<%="generic-search-results gsf-orientation-" + configObj.getTitleForResultsList().toLowerCase()%>" id="generic-search-results">
	           	   		</div>
		           	   	
	           	   </div>
	           	   <aui:row>
							<aui:col span="12" cssClass="text-center moreExams" id="moreExams">
								<a href="#link" title="" >
								<% if(!configObj.getLoadMoreText().isEmpty()){ %>
								<%=configObj.getLoadMoreText()%>
								<%}else{ %>
								MORE RECORDS
								<%} %>
								</a>
							</aui:col>
						</aui:row>
	           	   </div>
	           	   </div>
	           	   </div>
			</div>
		</div>
	</div>
</div>
</div>

<div id="createFavouritePopup" class="hide">
       <div id="createFavouritePopupContainer">
			<div id="createFavouriteDeatilsContainer">
				<aui:input name="favouriteId" type="hidden"></aui:input>
				<aui:input label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"favourite-name")%>' style="background-color: white;border: 1px solid #E0E7EE;" required="true" 
 						type="text" maxlength="70" name="favouriteName" id="favouriteName" placeholder='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.type.a.name")%>'/>
			</div>
			<% 
				boolean hasGlobalFavPermmission = false;
				String globalFavRoles[] = configObj.getFavouritesRoles().split(StringPool.COMMA);
				for (String roleId : globalFavRoles) {
					if (UserLocalServiceUtil.hasRoleUser(GetterUtil.getLong(roleId), themeDisplay.getUserId())) {
						hasGlobalFavPermmission = true; 
						break;
					}
				}
				if (hasGlobalFavPermmission) { %>

			<div class="swithAd2fav">
				<p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.private")%></p>
				<div class="adPvtgGbl">

					<label class="adFavswitch"> <input type="checkbox" id="permissionType" style="margin-left:20px;">
						<span class="adFavslider round"></span>
					</label>

				</div>
				<p><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.global")%></p>
			</div>
			<% } %>
       </div>
</div>


<script>
	var initialSearchText = "";
	try{
		initialSearchText = "${searchText}";
	}catch(err){initialSearchText = "";}

	var initialSearchVocabulary = null, initialSearchCategory=null;
	try{
		initialSearchVocabulary = "${vocName}";
		initialSearchCategory = "${catName}";
	}catch(err){ }
	
	var clearFiltersOnTextSearch = <%=configObj.getClearFiltersOnTextSearch()%>;
	var dateFilter = <%=configObj.getDateFitlers()%>;
	
	var A;
	var instance = this;
	var gsFavs = [];
	var hasGlobalFavPermmission = <%=hasGlobalFavPermmission%>;
	var ajaxUrlSR = '<%=resourceUrl%>';
	var pns ="<portlet:namespace/>";
	AUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated',
			'stylesheet','aui-datepicker','overlay','event', 'widget-anim','liferay-portlet-url', function(A1) {
		A = A1;
			if (dateFilter){
				datePicker("startDateContainer","startDate");
				datePicker("endDateContainer","endDate");	
				initializeEnterKeySearch();
			}
		

		try{
			gsFavs = <%=GenericSearchFavouriteHelper.getFavourites(themeDisplay).toString() %>;
			if (gsFavs.length > 0){
				A.one(".adfSearchList").removeClass('hide');
				addFavs(gsFavs);
			}else{
				if(A.one(".adfSearchList")){
					A.one(".adfSearchList").addClass('hide');
				}
				
			}
			
		}catch(err){console.log(err);}
		

	});

</script>
<%
	} else {
		out.println("<div class='missing-config text-center margin-top-one h3'>Missing Configuration</div>");
	}
%>
<script>
var configPortletMsg = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.use.configuration.configure.portlet")%>';
var warningLbl = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.warning")%>';
var okLbl = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ok")%>';
var errorGenReport = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.generating.report")%>';
var errorFetchResult = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.fetching.result")%>';
var noMoreResult = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.no.more.results")%>';
var errorGetFieldMsg = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.getting.field.options.errorMsg")%>';
var errorGetField = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.getting.field.options")%>';
var errorGetFilters = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.getting.filters")%>';
var errorGetSorts = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.getting.sorts")%>';
var errorCreateFav = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.create.favourites")%>';
var errorDelFav = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.server.error.delete.favourite")%>';
var errorUpdateFav = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.update.favourite")%>';
var favDetailLbl = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.favourite.details")%>';
var cancelLbl = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.cancel")%>';
var saveLbl = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.save")%>';
</script>
<script src="/GenericSearch-portlet/js/nouislider.min.js"></script>
<link href="/GenericSearch-portlet/css/nouislider.min.css" rel="stylesheet">

<script src="/GenericSearch-portlet/js/classie.js"></script>
<script src="/GenericSearch-portlet/js/uiProgressButton.js"></script>

<aui:script
	use="aui-node,aui-node-base,node-event-simulate,aui-base,aui-io-request-deprecated,liferay-util-window,aui-io-plugin-deprecated,liferay-portlet-url">
	var ajaxRenderUrl = '<%=renderURL%>';
	
	if (A.one('.missing-config')) {
		displayPopupMessage(configPortletMsg);
	} else {
		initializeFilters(A, ajaxRenderUrl, <%=portletPreferences.getValue(GenericSearchConstants.PREF_CUSTOM_COLOR_MAP, "{}")%>);
		hideFavouritesPopup();
	}
	
	try {
		var exportButton = A.one('.gs-export');
		new UIProgressButton( exportButton.getDOMNode(), {
			callback : function( instance ) {
				var progress = 0,
				
				interval = setInterval( function() {
					progress = Math.min( progress + Math.random() * 0.1, 1 );
					instance.setProgress( progress );
	
					if( progress === 1 ) {
						clearInterval( interval );
					}
				}, 700 );
				exportResults(A,'<%= AuthTokenUtil.getToken(request) %>', instance);
			}
		});
	} catch (e){
	}
	function displayPopupMessage(msg,titleMsg){
		titleMsg = titleMsg ? titleMsg : warningLbl;
		var dialog =	Liferay.Util.Window.getWindow({
				title : titleMsg,	
				dialog: {
						bodyContent : msg,
						centered : true,
						cache: false,
						destroyOnClose: true,
						destroyOnHide: true,
						height : 250,
						width : 400,
						modal : true,
						constrain2view : true,
						toolbars:{ footer:[{label:okLbl, on: { click:function() {dialog.hide();}}}]}
					}}).render();
			
	}
	
</aui:script>

<script>
	function show(target) {  
	  var footerContain = document.querySelector('.footer-section');
	  document.getElementById(target).classList.add('block','slideInRight');
	  document.getElementById(target).classList.remove('hide','slideOutRight');
	  document.body.style.overflow = 'hidden';
	  if (footerContain) {
		  footerContain.style.display = 'none';
	  }
	  
	  
	}

	function hide(target) {
		var footerContain = document.querySelector('.footer-section');
	    document.getElementById(target).classList.add('hide','slideOutRight');
	    document.getElementById(target).classList.remove('block','slideInRight');
	    document.body.style.overflow = 'scroll';
	    if (footerContain) {
	    	footerContain.style.display = 'none';
	    }
	  
	}
	
	function initializeEnterKeySearch(){
		var nodes = [instance.startDate,instance.endDate];
		var nodeList = new A.NodeList(nodes);
		nodeList.on("keypress",function(ev){
			// click on enter
			if(ev.keyCode ==  13){
				instance.dateSelectionChange();
			}
		});
	}
	function datePicker(containerId,triggerId){
		var psInstance = instance;
		var datePicker = new A.DatePicker(
				{
					container: '#' + containerId,
					mask: '%d/%m/%Y',
					popover: {
						zIndex: Liferay.zIndex.TOOLTIP
					},
					trigger: '#' + triggerId
				}
			);
			var calendar = datePicker.getCalendar();
			calendar.after('dateClick', psInstance.dateSelectionChange, datePicker);
			instance[triggerId+"Dp"] = datePicker;
	}
	
	function dateSelectionChange(){
		var fav = document.getElementById("adfDropdown-favText");
		var selectedFavId = fav.getAttribute("data-fav-id");
		if (selectedFavId){
			A.one("#update1[data-fav-id="+selectedFavId+"]").removeClass('hide');
			A.one("#update2[data-fav-id="+selectedFavId+"]").removeClass('hide');
		}
		     sendDateSearch(A);
	}
	
	
	function hideFavouritesPopup(){
		var container = A.one('body');
		container.on('click', function(e){
			if (e.target._node.id != "adfDropdown-favText"){
				var adfDropdownSelection = document.getElementById('adfDropdown-selection-id');
				  if((adfDropdownSelection) && (adfDropdownSelection.classList.contains('active'))){
					  adfDropdownSelection.classList.remove('active');
				  }
			}
		});
	
	
	}
		
	
</script>


