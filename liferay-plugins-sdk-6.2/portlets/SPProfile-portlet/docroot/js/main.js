var ajaxUrl;
var pageNo = 0;
var closeTagMap = {};
var portletNamespace;
var ajax;
var ajaxResourceUrl;
var navConfig;
var ns;
var profileElementInnerHTMLSeemore;
function initializeFilters(A, ajax,resourceUrl, ns,navConfig) {
	this.ajaxUrl = ajax;
	this.ajaxResourceUrl = resourceUrl;
	this.navConfig = navConfig;
	this.ns = ns;
	forceSendRequest(A);
	setTimeout(function(){ 
		initializeView(ns,navConfig);
	}, 3000);
}

function forceSendRequest(A) {
	fireRequest(A, true);
}

function fireRequest(A, clearResultsContainer) {

	if (clearResultsContainer) {
		startPreLoader('cm-profileView');
		var container = A.one(".cm-profileView");
		container.empty();
	} 
	
	A.io.request(ajaxUrl,
		{
			dataType : 'json',
			method : 'POST',
			on : {
				success : function() {
					onSuccess(this.get("responseData"), A);
					stopPreLoader('cm-profileView');
				},
				failure : function() {
					alert('Error occured while fetching results! Kindly reload the page and try again. If the issue persists, kindly contact the admin team.');
					stopPreLoader('cm-profileView');
				}
			}
		});
}

// TODO handle this properly
function onSuccess(respObj, A) {
	if (respObj) {
		var newNode = new A.Node('div');
		// ignore unwanted text
		newNode.setHTML(respObj.substring(16));
		
		var container = A.one(".cm-profileView");
		if(!A.one("#generic-search-no-more-results")) {
			var nodes = newNode.all('.cm-profileView-single-result');
			if (nodes.size() > 0) {
				pageNo = pageNo + 1;
				container.all('#gsf-bottom-preloader').remove();
				container.append(nodes);
				container.append('<div id="gsf-bottom-preloader">&nbsp;</div>')
			}
		} else {
			container.append("<div class='text-center gray margin-half'>No profile information found for this user</div>")
		}
	}
}

function showSubMenu(comp, show) {
	if (show) {
		AUI().one(comp).one('.ps-dropdown .ps-dropdown-content').show();
	} else {
		AUI().one(comp).one('.ps-dropdown .ps-dropdown-content').hide();
	}
}

function initializeView(ns,navConfig){
	portletNamespace = ns;
	AUI().ready(function(A){
		var navContainer = A.one('.sideTabnav');
		var firstSection = "";
		if (navConfig) {
			 var navContainer = A.one('.spNav-sidebar-heading');
			  if (navConfig.navTitle && navContainer != null) {
				  navContainer.one('h2').html(navConfig.navTitle);
			  }
			  for (var i=0; i<navConfig.menus.length; i++) {
				  var menu = navConfig.menus[i];
				  console.log(menu);
				  
				  var updateLinkHtml = "";
				  var statusLabelHtml = "";
				  if(menu.updateUrl) {
					  updateLinkHtml = '<a class="edit-link" target="_blank" href="'+menu.updateUrl+'"><img src="/SPProfile-portlet/images/icon-export.svg" alt=""></a>';
				  }
				  if(menu.statusLabel) {
					  statusLabelHtml = '<span id="invigilatorStatusLabel" class="status-label"></span>';
				  }
				  var menuHtmlStr = '<div class="spNav-sidebarnav">'+
					'<h3>'+menu.menuName+statusLabelHtml+updateLinkHtml+'</h3><ul class="sideTabnav">';
				 
				  for (var j=0; j<menu.menuItems.length; j++) {
					  var menuItem = menu.menuItems[j];
					  var menuItemHasLink = menuItem.dashboardId;
					  var hasSubMenus = menuItem.subMenuItems && menuItem.subMenuItems.length > 0;
					  var hashTag = menuItem.menuItem;
					  //alert("menuHtmlStr " + menuHtmlStr);
					  hashTag = hashTag.replace("&", "");
					  hashTag = hashTag.trim().toLowerCase().replace(" ", "-");
					  hashTag = hashTag.replace(" ", "");
					  if(i == 0 && j == 0){
						  firstSection = hashTag;
					  }
					  var mobileMenuWrap = document.getElementById(hashTag + "-mob");
					  var mobileMenu = '<h4 class="cmAccordionHeader toggler-header toggler-header-collapsed fromjs"><a href="#">' + menuItem.menuItem +'</a> </h4>';
					  if(hashTag.indexOf("profile") != -1 || hashTag.indexOf("personal") != -1 ){
						  mobileMenu = '<h4 class="cmAccordionHeader toggler-header toggler-header-expanded fromjs"><a href="#">' + menuItem.menuItem +'</a> </h4>';
					  }
					  if(mobileMenuWrap) {
						  mobileMenuWrap.innerHTML = mobileMenu +  mobileMenuWrap.innerHTML;
					  }
					  menuHtmlStr += "<li onClick= 'fetchTemplate(" + '"' + hashTag + '"' + ",null,null)'";
					  if (hasSubMenus) {
						  menuHtmlStr += ' onmouseover="showSubMenu(this, true)" onmouseout="showSubMenu(this, false)" ';
					  }
					 
					  menuHtmlStr +=  '><a id="menu-' + hashTag +'" href="#' + hashTag +'"';
					  if (menuItemHasLink) {
						  menuHtmlStr += " class='d"+menuItem.dashboardId+")' ";	
						  //menuHtmlStr += ' onClick="fetchTemplate("' + A + '","' + hashTag + '")" ';
					  }				  
					  menuHtmlStr += '><img src="/SPProfile-portlet/images/sidebar-icons'+menuItem.menuItemIcon+'" alt=""><span>'+menuItem.menuItem+'</span>';
					  if (hasSubMenus) {
						  menuHtmlStr += '<div class="ps-dropdown"><div class="ps-dropdown-content" style="display:none;">';
						  for (var k=0; k<menuItem.subMenuItems.length; k++) {
							  var subMenuItem = menuItem.subMenuItems[k];
							  var subMenuItemHasLink = subMenuItem.dashboardId;
							  menuHtmlStr += '<a ';
							  if (subMenuItemHasLink) {
								  menuHtmlStr += " class='d"+subMenuItem.dashboardId+"' ";								  
							  }
							  menuHtmlStr += ' class="drpsp">'+subMenuItem.subMenuItem+'</a>';
						  }
						  menuHtmlStr += '</div></div>';
					  }
					  menuHtmlStr += '</a></li>';
				  }
				  menuHtmlStr += '</ul></div>';
				  navContainer.append(menuHtmlStr);
			  }
			  fetchTemplate(firstSection,null,null);
			  if(document.getElementById(firstSection)) {
				  document.getElementById(firstSection).style.display = "block";
			  }
 			  }	  
		
		var sidetabLinks = document.querySelectorAll('ul.sideTabnav  li  a');

		for (var i = 0; i < sidetabLinks.length; i++) {
		    sidetabLinks[i].onclick = function() {
		        var sidetarget = this.getAttribute('href').replace('#', '');
		        var sidesections = document.querySelectorAll('div.cmSideContent');
		        for (var j = 0; j < sidesections.length; j++) {
		            sidesections[j].style.display = 'none';
		        }
		        document.getElementById(sidetarget).style.display = 'block';

		        for (var k = 0; k < sidetabLinks.length; k++) {
		            /*tabLinks[k].remove('class');*/
		            sidetabLinks[k].classList.remove("is-active");
		        }

		        /*this.setAttribute('class', 'is-active');*/
		        this.classList.add("is-active");

		        return false;
		    }
		};

		YUI().use(
  			'aui-toggler',
  			function(Y) {
  				
  			
    			new Y.TogglerDelegate(
    			
     			 {
        			animated: false,
       				closeAllOnExpand: true,
        			container: '#cmAccordion',
        			content: '.cmContentAccordion',
        			expanded: false,
       				header: '.cmAccordionHeader',
      				}
    			  );
  				}
			);
		    YUI().use('node','event', 'anim', 'transition', function(Y) {
				if (Y.one('.cmAccordionHeader')) {
		        var accItem = Y.all('.cmAccordionHeader');
		        accItem.on('click', accItemClick);
		
		    }
				
				function accItemClick(m) {
					var scrollTargetId = m.target.get('parentNode').get('parentNode').getAttribute('id');
			    	 if(scrollTargetId.indexOf("mob") > -1){
			    		 scrollTargetId = m.target.get('parentNode').get('parentNode').get('parentNode').getAttribute('id');
			    	 }
			    	 //alert("scrollTargetId " + scrollTargetId);
			    	 fetchTemplate(scrollTargetId,null,null);
           	        var accBody = Y.one('body');
		     	    accBody.on('click', function(m) {
		            smoothScrolls(m);
		            
		        }, '#cmAccordion'); 

		     }

		    function smoothScrolls(m) {
		        //Prevent default on-click behavior
		       // m.preventDefault();
		        var scrollTarget = m.target.getAttribute('id');
		       
		            var scrollTargetY = m.target.get('parentNode').getY(),
		            //Set YUI animation and its properties
		            scrollAnim = new Y.Anim({
		
		                //Set duration in seconds
		                duration: 0.3,
		                node: 'win',
		                to: {
		                    scroll: [0, scrollTargetY-63]
		                }
		            });
		        scrollAnim.run();
		       }

			});
		
	});	
	
}

function fetchTemplate(profileModule,stages,seemore){
	console.log(profileModule);
	var profileElementWrap = document.getElementById(profileModule.trim()+"-wrapper");
	var profileElementWrapCnt = document.getElementById(profileModule.trim()+"-wrapperCnt");
	//var parentTable = document.getElementById(profileModule.trim()+"-wrapper-table");
	if(profileElementWrap){
		profileElementWrap.innerHTML = "";
		//alert("profileElementWrap.innerHTML if " + profileElementWrap.innerHTML);
		var profileElement = document.getElementById(profileModule.trim());
		var profileElementInnerHtml = profileElementWrapCnt.innerHTML;
		if(seemore == null){
		profileElementInnerHTMLSeemore = profileElementWrapCnt.innerHTML;
		}

		var reqUrl = ajaxResourceUrl + "&" + portletNamespace + "action=" + profileModule.trim();
		if(stages != null){
			reqUrl = reqUrl + "&" + portletNamespace + "stages=" + stages.trim();
		}
		if(seemore != null){
			reqUrl = reqUrl + "&" + portletNamespace + "seemore=seemore";
			profileElementInnerHtml = profileElementInnerHTMLSeemore;
			profileElementWrap.innerHTML = "";
		}
		var data1 = {};
		data1[namespace + "profileModule"] = profileModule.trim();
		data1[namespace + "formStorageId"] = userId;
		data1[namespace + "formType"] ="persona/profile";
		if(profileModule == "documents"){
			data1[namespace + "formType"] ="CandidateDocument";
		}else if(profileModule == "sponsor-details"){
			data1[namespace + "formType"] ="persona/profile";
		}
		else if(profileModule == "bank-details" || profileModule == "invigilation-experience"){
			data1[namespace + "formType"] ="persona/profile";
		}
		console.log("data1");
		console.log(data1);
		console.log(reqUrl);
		//alert("profileModule " + reqUrl);
		var A = AUI();
		AUI().use('aui-io-request', function (A) {
	        startPreLoader("cm-profileView");
	        
	        A.io.request(reqUrl,
	                {
	        	dataType : 'json',
				method : 'POST',
	                    data: data1,
	                    on: {
	                        complete: function () {
	                            stopPreLoader("cm-profileView");
	                        },
	                        success: function () {
	                            var data = this.get('responseData');
	                            console.log("----module form submit success ");
	                            console.log(data);
	                            console.log(data.contentJson);
	                            if (data) {
	                            	var invigStatusLabel = document.getElementById("invigilatorStatusLabel");
	                            	if(invigStatusLabel && invigStatusLabel.innerHTML=="") {
	                            		if(data.contentJson.contentJson.Status) {
	                            			invigStatusLabel.innerHTML = data.contentJson.contentJson.Status;
	                            		} else {
	                            			invigStatusLabel.innerHTML = data.contentJson.contentJson.CandidatureStatus;
	                            		}
	                            		if(invigStatusLabel.innerHTML=="Active") {
	                            			invigStatusLabel.classList.add("active-background");
	                            		} else {
	                            			invigStatusLabel.classList.add("deactive-background");
	                            		}
	                            	}
	                                if (typeof data == "string") {
	                                    // dont know, somehow response is in string format
	                                    data = JSON.parse(data);
	                                }
	                                if (data.error) {
	                                    displayError(data.error);
	                                } else{
	                                	var profileElementActualValues ="";
	                                	var sortedbyKeyJSONArray = sortByKey(data);
	                                	for (i=0;i<sortedbyKeyJSONArray.length;i++) {
	                                		//alert("key " + key);
	                                		var jsonDetail = JSON.parse(JSON.stringify(sortedbyKeyJSONArray[i][1]));
	                                		var key = sortedbyKeyJSONArray[i][0];
	                                		if(profileModule.trim() == "work-experience"){
	                                			if(profileElementInnerHtml.indexOf("WorkHistoryValue1") != -1){
	                                				populateWorkHistoryValues(jsonDetail,profileElementActualValues,profileElementInnerHtml,profileElementWrap);
	                                			}	
	                                			if(key == "noresult"){
	                                				displayError("No results found",profileElementWrap);
	                                			}
		                                	}else if(profileModule.trim() == "transaction-history"){
	                                			if(profileElementInnerHtml){
	                                				populateTransactionHistoryValues(jsonDetail,profileElementActualValues,profileElementInnerHtml,profileElementWrap);
	                                			}	
	                                			if(key == "noresult"){
	                                				displayError("No results found",profileElementWrap);
	                                			}
		                                	}else if(profileModule.trim() == "documents" ||  profileModule.trim() == "invigilation-experience"){
	                                			if(profileElementInnerHtml){
	                                				populateDocumentValues(jsonDetail,profileElementActualValues,profileElementInnerHtml,profileElementWrap);
	                                			}	
	                                			if(key == "noresult"){
	                                				displayError("No results found",profileElementWrap);
	                                			}
		                                	}
		                                	else if(profileModule.trim() == "sponsor-details" || profileModule.trim() == "bank-details" || profileModule.trim() == "profile-info" || profileModule.trim() == "personal-info"){
	                                			if(profileElementInnerHtml){
	                                				populateTransactionHistoryValues(jsonDetail,profileElementActualValues,profileElementInnerHtml,profileElementWrap);
	                                			}	
	                                			if(key == "noresult"){
	                                				displayError("No results found",profileElementWrap);
	                                			}
		                                	}
		                                	else{
			                                		if(profileModule.trim() == "leads" || profileModule.trim().indexOf("opportunities") != -1){
			                                			if(key == "Stage0"){//to update the stage count value in the opportunity tabs
			                                				poputaleStageFilters("OpportunityTab1","OpportunityTab2","OpportunityTab3",jsonDetail);
			                                			}else if(key == "Stage1"){//to update the stage id values in the link of opportunity tabs
			                                				poputaleStageFilters("StageId1","StageId2","StageId3",jsonDetail);
			                                			}else if(key == "TotalCount0"){//to hide and show see more options
			                                				//alert("seeMore " + jsonDetail);
			                                				var seeMoreElm = document.getElementById(profileModule+"-seeMoreWrap");
			                                				if(seeMoreElm){
			                                					if(jsonDetail > 2 && profileElementInnerHtml.indexOf("LeadsValue2") != -1){
			                                						seeMoreElm.classList.remove("hide");
			                                					}else if(jsonDetail == 0){
			   			                                			 displayError("No results found",profileElementWrap);
			   			                                			viewTabs(profileModule);
			                                					}
			                                					if(seemore != null || seemore == "undefined"){
			                                						seeMoreElm.classList.add("hide");
			                                					}
			                                				}
			                                			}else{
			                                				//alert("key " + key);
				                                			if(profileElementInnerHtml.indexOf("LeadsValue2") != -1){
				                                				//alert("jsonDetail.productName " + jsonDetail.productName);
				                                				populateLeadsOpportunitiesValues(jsonDetail,profileElementActualValues,profileElementInnerHtml,profileElementWrap);
				                                			}
				                                			viewTabs(profileModule);
			                                			}	
			                                		}else if(profileModule.trim() == "current-learner" || profileModule.trim() == "alumni"){
			                                			var seeMoreElm = document.getElementById(profileModule+"-seeMoreWrap");
			                                			if(key == "noresult"){
			                                				displayError("No results found",profileElementWrap);
			                                				seeMoreElm.classList.add("hide");
			                                			}else if(key == "TotalCount"){
				                                			if(jsonDetail > 3 && profileElementInnerHtml.indexOf("LeadsValue1") != -1){
		                                						seeMoreElm.classList.remove("hide");
		                                					}else{
		                                						seeMoreElm.classList.add("hide");
		                                					}
				                                			if(seemore != null || seemore == "undefined"){
		                                						seeMoreElm.classList.add("hide");
		                                					}
			                                			}else{
			                                				if(profileElementInnerHtml.indexOf("LeadsValue2") != -1){
				                                				populateLearnerValues(jsonDetail,profileElementActualValues,profileElementInnerHtml,profileElementWrap);
				                                			}
			                                			}	
			                                		}else if(profileModule.trim() == "campaigns"){
			                                			if(key == "OpenedMailCount"){//to update the count values of opened mail in campaign tabs
			                                				var campaignFiltersElm = document.getElementById("campaign-FilterWrap");
			                                				if(campaignFiltersElm){
			                                					campaignFiltersElm.innerHTML =  campaignFiltersElm.innerHTML.replace("CampaignFilter1",jsonDetail);
			                                				}
			                                			}else if(key == "linkInteractionCount"){//to update the count values of number of interactions in campaign tabs
			                                				var campaignFiltersElm = document.getElementById("campaign-FilterWrap");
			                                				if(campaignFiltersElm){
			                                					campaignFiltersElm.innerHTML =  campaignFiltersElm.innerHTML.replace("CampaignFilter2",jsonDetail);
			                                				}
			                                			}else if(key == "TotalCount"){
			                                				var seeMoreElm = document.getElementById(profileModule+"-seeMoreWrap");
				                                			if(jsonDetail > 3 && profileElementInnerHtml.indexOf("CampaignValue1") != -1){
		                                						seeMoreElm.classList.remove("hide");
		                                					}else{
		                                						seeMoreElm.classList.add("hide");
		                                					}
				                                			if(seemore != null || seemore == "undefined"){
		                                						seeMoreElm.classList.add("hide");
		                                					}
			                                			}else if(key.indexOf("CampaignValues") != -1){
				                                			if(profileElementInnerHtml.indexOf("CampaignValue1") != -1){
				                                				profileElementWrap.classList.remove("noResultMsg");
				                                				populateCampaignValues(jsonDetail,profileElementActualValues,profileElementInnerHtml,profileModule,profileElementWrap);
				                                			}
			                                			}
			                                			if(key == "noresult"){//when empty result is returned
			                                				profileElementWrap.classList.add("noResultMsg");
			                                				displayError("<td style='padding-left:20px!important;'>No results found</td>",profileElementWrap);
			                                			}
			                                		}
		                                		}
	                                	}
	                                	profileElementActualValues = "";
	                                } 
	                            } else {
	                                displayError("Error while retrieving Data",profileElementWrap);
	                            }
	                        },
	                        failure: function () {
	                            displayError("Error while retrieving Data",profileElementWrap);
	                        }
	                    }
	                });
	    });
		
	}	
}

function sortByKey(jsObj){
  	var sortedArray = [];

  	// Push each JSON Object entry in array by [key, value]
  	for(var i in jsObj)
  	{
  			sortedArray.push([i, jsObj[i]]);
	}

	// Run native sort function and returns sorted array.
	return sortedArray.sort();
}


function populateWorkHistoryValues(jsonDetail,profileElementActualValues,profileElementInnerHtml,profileElementWrap){
	profileElementActualValues = profileElementInnerHtml.replace("WorkHistoryValue1", jsonDetail.jobTitle);
	profileElementActualValues = profileElementActualValues.replace("WorkHistoryValue2", jsonDetail.companyName);
	profileElementActualValues = profileElementActualValues.replace("WorkHistoryValue3", jsonDetail.companyType);
	profileElementActualValues = profileElementActualValues.replace("WorkHistoryValue4", jsonDetail.industryType);
	profileElementActualValues = profileElementActualValues.replace("WorkHistoryValue5", jsonDetail.startDate);
	profileElementActualValues = profileElementActualValues.replace("WorkHistoryValue6", jsonDetail.endDate);
	profileElementActualValues = profileElementActualValues.replace("WorkHistoryValue7", jsonDetail.workExperience);
	profileElementActualValues = profileElementActualValues.replace("WorkHistoryValue8", jsonDetail.workDescription);
	profileElementWrap.innerHTML += profileElementActualValues;
}

function populateTransactionHistoryValues(jsonDetail,profileElementActualValues,profileElementInnerHtml,profileElementWrap){
	profileElementActualValues = profileElementInnerHtml;
	console.log(jsonDetail);
	var val = "";
	for (var key in jsonDetail) {
		console.log(key);
		  if (jsonDetail.hasOwnProperty(key)) {
		    val = jsonDetail[key];
		    if(!isNaN(Date.parse(val))) {
		    	profileElementActualValues = profileElementActualValues.replace("[$"+key+"$]", formatDate(new Date(val)));
		    } else {
		    	profileElementActualValues = profileElementActualValues.replace("[$"+key+"$]", val);
		    }
		  }
	}
	for (key in jsonDetail.contentJson) {
		console.log(key);
		  if (jsonDetail.contentJson.hasOwnProperty(key)) {
		    val = jsonDetail.contentJson[key];
		    if(!isNaN(Date.parse(val))) {
		    	profileElementActualValues = profileElementActualValues.replace("[$"+key+"$]", formatDate(new Date(val)));
		    } else {
		    	profileElementActualValues = profileElementActualValues.replace("[$"+key+"$]", val);
		    }
		  }
	}
	profileElementWrap.innerHTML += profileElementActualValues;
}

function populateDocumentValues(jsonDetail,profileElementActualValues,profileElementInnerHtml,profileElementWrap){
	for (var i = 0; i < jsonDetail.length; i++ ) {
		profileElementActualValues = profileElementInnerHtml;
		for (var key in jsonDetail[i]) {
			  if (jsonDetail[i].hasOwnProperty(key)) {
			    var val = jsonDetail[i][key];
			    profileElementActualValues = profileElementActualValues.replace("[$"+key+"$]", val);
			  }
		}
		profileElementWrap.innerHTML = profileElementWrap.innerHTML + profileElementActualValues;
	}
	
}

function poputaleStageFilters(value1,value2,value3,jsonDetail,stageFiltersElm){
	var stageFiltersElm = document.getElementById("opportunities-FilterWrap");
	if(stageFiltersElm){
		stageFiltersElm.innerHTML =  stageFiltersElm.innerHTML.replace(value1,jsonDetail.Bronze);
		stageFiltersElm.innerHTML =  stageFiltersElm.innerHTML.replace(value2,jsonDetail.Silver);
		stageFiltersElm.innerHTML =  stageFiltersElm.innerHTML.replace(value3,jsonDetail.Gold);
	}	
}
function displayError(msg,profileElementWrap){
	if(profileElementWrap){
		profileElementWrap.innerHTML = msg;
	}
}

function populateCampaignValues(jsonDetail,profileElementActualValues,profileElementInnerHtml,profileModule,profileElementWrap){
	profileElementActualValues = profileElementInnerHtml.replace("CampaignValue1", jsonDetail.campaignName);
	profileElementActualValues = profileElementActualValues.replace("CampaignValue2", jsonDetail.campaignMailDate);
	profileElementActualValues = profileElementActualValues.replace("CampaignValue3", jsonDetail.campaignMailOpened);
	profileElementActualValues = profileElementActualValues.replace("CampaignValue4", jsonDetail.interactionCount);
	profileElementActualValues = profileElementActualValues.replace("CampaignValue5", jsonDetail.edmTemplateId);
	profileElementWrap.innerHTML += profileElementActualValues;
}

function populateLearnerValues(jsonDetail,profileElementActualValues,profileElementInnerHtml,profileElementWrap){
	profileElementActualValues = profileElementInnerHtml.replace("LeadsValue1", jsonDetail.courseName);
	profileElementActualValues = profileElementActualValues.replace("LeadsValue2", jsonDetail.courseStartDate);
	profileElementActualValues = profileElementActualValues.replace("LeadsValue3", jsonDetail.courseEndDate);
	profileElementWrap.innerHTML += profileElementActualValues;
}

function populateLeadsOpportunitiesValues(jsonDetail,profileElementActualValues,profileElementInnerHtml,profileElementWrap){
	var imgurl = "/SPProfile-portlet/images/Minisite-productDefaultImage.png";
	profileElementActualValues = profileElementInnerHtml.replace(imgurl, jsonDetail.productImageUrl);
	profileElementActualValues = profileElementActualValues.replace("LeadsValue2", jsonDetail.productName);
	profileElementActualValues = profileElementActualValues.replace("LeadsValue3", jsonDetail.courseName);
	profileElementActualValues = profileElementActualValues.replace("LeadsValue4", jsonDetail.leadCreateDate);
	profileElementActualValues = profileElementActualValues.replace("LeadsValue5", jsonDetail.leadModifiedDate);
	profileElementActualValues = profileElementActualValues.replace(new RegExp("LeadsValue6", "g"), jsonDetail.stageName);
	profileElementActualValues = profileElementActualValues.replace("LeadsValue7", jsonDetail.applicationUrl);
	profileElementWrap.innerHTML += profileElementActualValues;
}

function viewTabs(profileModule){
	var tabLinks = document.querySelectorAll('.ActivityTabFunc  a');
		for (var i = 0; i < tabLinks.length; i++) {
		        var sections = document.querySelectorAll('section.cmTabContent');

		        for (var j = 0; j < sections.length; j++) {
		            sections[j].style.display = 'none';
		        }
		        if(profileModule == "opportunities"){
		        	profileModule = "all-"+profileModule;
		        }
		        var targetElm = document.getElementById(profileModule);
		        targetElm.style.display = 'block';

		        for (var k = 0; k < tabLinks.length; k++) {
		            /*tabLinks[k].remove('class');*/
		            tabLinks[k].classList.remove("is-active");
		        }

		        /*this.setAttribute('class', 'is-active');*/
		        targetElm.classList.add("is-active");

		        return false;
		}
}

function loadContent(obj) {
	var AI=AUI();
	var itemis = null;
	var subject = null;
	var htmlContent = null;
	var textContent = null;
	var campaignName = null;
	var reqUrl = ajaxResourceUrl + "&" + portletNamespace + "action=getTemplate" + "&" + portletNamespace + "filterValue=" + obj;

			try{
				 AI.io.request(reqUrl,
			                {
				    cache: false,
				    sync: true,
				    timeout: 1000,
				    dataType: 'json',
				    method: 'post',
				    data:{
				   	 action:"get",
				   	 filterValue:obj,
				    },

				    on: {
				        success: function() {
				       	 itemis = this.get('responseData');
				        if (itemis) {

				       		for (key in itemis) {
				       			var cellTextValues = itemis[key];
				       			for (key in cellTextValues) {
				       				switch(key) {
					       				case "subject": subject=cellTextValues[key];break;
					       				case "htmlContent": htmlContent=cellTextValues[key];break;
					       				case "textContent": textContent=cellTextValues[key];break;
				       				}
				       			}
				       		}
				       		var myWindow = window.open("", subject,'width=680,location=no,toolbar=no,menubar=no,status=no,resizable=0,scrollbars=yes,height=700,top=100,left=100');
				       		myWindow.document.write(htmlContent);
				       	}
				        },

				        failure: function() {
				        }
				    }
				});

		 	return true;
		}catch(err) {
		}

}

function formatDate(myDate) {
	var dd = myDate.getDate();
	var mm = myDate.getMonth() + 1; //January is 0!

	var yyyy = myDate.getFullYear();
	if (dd < 10) {
	  dd = '0' + dd;
	} 
	if (mm < 10) {
	  mm = '0' + mm;
	} 
	return dd + '/' + mm + '/' + yyyy;
}
