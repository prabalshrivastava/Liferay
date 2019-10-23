var ajax;
var pageNo = 0;
var challengeId = 0;
function getApplyPopupURL() {
	return (location.href+"").match(/#$/) ? location.href+"apply_popup"
			: location.href+"#apply_popup";
}

function shorten(text, maximumLen) {
	
	var ret = text ? text : "" ;
	var maxLength = maximumLen ? maximumLen : 200 ;
	if (ret.length > maxLength) {
		ret = ret.substr(0, maxLength - 3) + "...";
	}
	return ret;
}

function initializeFilters(ajaxUrl) {
	ajax = ajaxUrl;
	fireRequest();
	AUI().use('aui-node', 'aui-base', function(A) {
		var buttons = A.all(".toggleButton");
		buttons.each(function(butt) {
			butt.on('click', function() {
				if (butt.hasClass("active")) {
					butt.removeClass("active");
				} else {
					butt.addClass("active");
				}
				handleClearButton();
				clearChallengeResults();
				fireRequest();
			});
		});
		
		A.one("#loadMore").on("click",function(){
			fireRequest();
		});
		
		A.one("#clearChallengeFilters").on("click", function(){
			var buttons = A.all(".toggleButton.active");
			buttons.removeClass("active");
			fireRequest();
			A.one("#clearChallengeFilters").hide();
		});
	});
}
function handleClearButton() {
	AUI().use('aui-node', 'aui-base', function(A) {
		var buttons = A.all(".toggleButton.active");
		if (buttons.size() > 0)
			A.one("#clearChallengeFilters").show();
		else 
			A.one("#clearChallengeFilters").hide();
	});
}
function clearChallengeResults(){
	pageNo = 0;
	AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated', function(A) {
		var container = A.one("#resultsContainer");
		container.all("section").remove();
	});
}
function fireRequest() {
	startPreLoader('sp-challenges-listing');
	AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated', function(A) {
		var searchButtons = A.all("button.active");
		var obj = "";
		searchButtons.each(function(button){
			obj = obj + "," + button.get('id');
		});
		A.io.request(ajax, {
			dataType : 'json',
			method : 'POST',
			data : {
				searchItems: obj,
				action: 'filterResults',
				pageNo : pageNo,
				searchType : "challenge"
			},
			on : {
				success : function() {
					onSuccess(this, A);
					stopPreLoader('sp-challenges-listing');
				},
				failure : function() {
					alert(errorFetchingResult);
					stopPreLoader('sp-challenges-listing');
				}
			}
		});
	});
}

function onSuccess(obj, A) {
	var data = obj.get("responseData");
	var container = A.one("#resultsContainer");
		if(data && data.items && data.items.length > 0){
		    var sampleSection = A.one("#challengeSection");
		    var noChalls = A.one(".noChalls");
		    if(noChalls)
		    	noChalls.remove();
		    for(var i = 0, tol = data.items.length; i < tol; i++){
				try{
					var item = data.items[i];
					if (item.spChallengeId == challengeId)
						continue;
					var dup = sampleSection.clone();
					dup.addClass('result-item-'+(i+1));
					dup.setAttribute('data-link', item.friendlyUrl);
					dup.one("#challengeImage").setAttribute('src', item.logoUrl);
					dup.one("#challengeName").setContent(shorten(item.name, 55));
					dup.one("#challengeAuthor").setContent(item.userName);
					dup.one("#challengeViewUrl").setAttribute('href', item.friendlyUrl);
					if(item.editfriendlyUrl) {
						dup.one("#challengeEditUrl").setAttribute('href', item.editfriendlyUrl);
						dup.one("#challengeEditUrl").removeAttribute("style");
					}
					dup.appendTo(container);
				} catch(error) {
					console.log(error);
				}
			}
		} else {
			container.html('<span class="noChalls" style="font-size: 12pt">' + noChallengeFound + '</span>');
		}
	if(data){
		if(data.pageNo){
			pageNo = data.pageNo;
		}
		var loadMoreDiv = A.one("#loadMoreDiv");
		if (loadMoreDiv) {
			if (data.moreDocsAvailable) {
				loadMoreDiv.removeClass("hide-content");
			} else {
				loadMoreDiv.addClass("hide-content");
			}
		}
	}
	
}

function initializeViewChallenge(ajaxUrl, view) {
	viewUrl = view;
	ajax = ajaxUrl;
	AUI().use('aui-node', 'aui-base', function(A) {
		if (challenge) {
			populateData(A);
		}
		registerAllTextAreaListener();
	});
	initTabs();
}

function initTabs() {
	AUI().use('aui-node', 'aui-base', function(A) {
		var tabs = A.all(".navBar nav li");
		tabs.on('click' , function (selected) {
			var id = selected.currentTarget.get('id');
			tabs.removeClass('active');
			selected.currentTarget.addClass('active');
			var tab = A.one('.display_view .' + id);
			A.all('.display_view .tab').removeClass('active');
			tab.addClass('active');
		});
	});
}

// display challenge page
function initializeSimilarChallenges() {
	startPreLoader('resultsContainer')
	AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated', function(A) {
		A.io.request(ajax, {
			dataType : 'json',
			method : 'POST',
			data : {
				action: 'getSimilarChallenges',
				spChallengeId: challengeId
			},
			on : {
				success : function() {
					onSuccess(this, A);
					stopPreLoader('resultsContainer');
				},
				failure : function() {
					alert(errorFetchingResult);
					stopPreLoader('resultsContainer');
				}
			}
		});
	});
}

function disableAllFields(formclass) {
	AUI().use('aui-node', 'aui-base', function(A) {
		var inputs = A.all("." + formclass +" .field");
		inputs.setAttribute('readonly', 'true');
		inputs = A.all("." + formclass +" select");
		inputs.setAttribute('disabled', 'true');
	});
}

function initializeApply(ajaxUrl, applyInternal, applyExternal) {
	ajax = ajaxUrl;
	AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated', 'aui-aria', 'liferay-util-window', 'aui-overlay-manager-deprecated', 'dd-constrain',
		function(A) {
			var applyButton = A.one('#applyChallenge_CTA');
			if(applyButton) {
				applyButton.on('click', applyChallengeCallback);				
			}
			if(applyInternal) {
				setTimeout(function(){ applyChallengeCallback(true); }, 100);
			}
			
			var applyOpenButton = A.one('#applyOpenChallenge_CTA');
			if(applyOpenButton) {
				var url = A.one("#"+namespace + "challenge_extras").val()
				if(url.length == 0) {
					applyOpenButton.addClass("hide-content");
				} else {
					if(url.indexOf('http') != 0) {
						url = 'http://' + url;
					}
					applyOpenButton.setAttribute("href" , url);
				}
			}
			if(applyExternal) {
				applyOpenButton.simulate('click');
			}
		});
}


function applyChallengeCallback(apply) {
	if(!Liferay.ThemeDisplay.isSignedIn()){
		location.href = '/signin';
		return;
	}
	AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated', 'aui-aria', 'liferay-util-window', 'aui-overlay-manager-deprecated', 'dd-constrain',
		function(A) {
			A.io.request(
				ajax,
				{
					dataType : 'json',
					method : 'POST',
					data : {
						action : 'getChallengeApplyInfos',
						spChallengeId: challengeId
					},
					on : {
						success : function() {
							var data = this.get("responseData");
							// The content in data is used to determine what action needs to be taken
							// 1. Organization name - either with 'InComplete' 'Already Applied'
							// 2. friendlyUrl - if complete profile apply url if incomplete profile edit org url 
							// if no profile then create profile url
							var content = preparePopupContent(data, A);
							A.one('#apply_popup').show();
							if(!content) {
								if (apply) {
									applyAction();
								}
								return;								
							}
							A.one('#apply_popup .signin-container .box').html(content);
							location.href=getApplyPopupURL();
							A.one("#popupApplyButton").on('click', applyAction);
						},
						failure : function() {
							alert(errorFetchingResult);
						}
					}
				});
	});
}

var createUrl = null;
var applyDialog;
function preparePopupContent(data, A) {
	var content = null;
	var cancelButton = '"#"';
	cancelButton = "<button onclick='defaultCancelHandler();'> Cancel </button>";
	if(data.noOrgs) {
		content = noStartupProfile;
		content = content + "<br><br><button id='popupApplyButton'> " + createProfile + "</button>" + cancelButton;
		createUrl = data.friendlyUrl;
	} else if (data.length == 1 && data[0].friendlyUrl && data[0].friendlyUrl.indexOf("spchallenge") > 0) {
		//has one complete startup profile
		document.location.href = data[0].friendlyUrl;
	} else if (data.length == 1 && data[0].name && data[0].name.indexOf('Already Applied') > 0) {
		content = alreadyApplied;
		content = content + "<div style='text-align:right; margin-top: 20px;'>";
		content = content + cancelButton + "</div>";
	} else {
		//has either one partial or multiple startups
		var content = selectStartup;
		content = content + "<select id='orgSelbox'>"
		for (i = 0; i < (data.length); i++) {
			var org = data[i];
			content = content +  '<option value="'+ org.orgId +'" link="'+ org.friendlyUrl +'">' + org.name + '</option>';
		}
		content = content + "</select>";
		content = content + "<div style='text-align:right; margin-top: 20px;'>";
		content = content + "<button id='popupApplyButton'>" + okLbl + "</button>" + cancelButton + "</div>";
	}
	return content;
}

function applyAction() {
	AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated', function(A) {
		try {
			
			if (createUrl) {
				location.href = createUrl;
				return;
			}
			
			var selBox = A.one("#orgSelbox");
			var selctedOption = selBox.one("option[value='"+selBox.val()+"']"); 
			var label = selctedOption.getContent();
			var url = selctedOption.getAttribute("link");
			if (label.indexOf('Incomplete') >= 0) {
				if(applyDialog){
					applyDialog.hide();
				}
				AUI().one('#apply_popup').hide();
				var content = startupIncomplete;
				var buttons = [
				                 {
				                   on: {
				                   click: function() {
				                	   showChallengePage();
				                	   dialog.hide();
				                   }},
				                   label: cancelLbl
				                 },
				                 {
				                   on: {
				                   click: function() {
				                	   location.href = url;
				                   }},
				                   label: okLbl
				                 }
				               ];
				
				var dialog = Liferay.Util.Window.getWindow(
						{
							title : profileIncomp,
							dialog: {
							bodyContent : content,
							centered : true,
							height : 250,
							width : 550,
							modal : true,
							constrain2view : true,
							toolbars: {footer:buttons}
						}}).render();
				
			} else if (label.indexOf('Already') >= 0) {
				if(applyDialog){
					applyDialog.hide();
				}
				var content = alreadyApplied;
				A.one('#apply_popup .signin-container .box').html(content);
				location.href=getApplyPopupURL();
			} else {
				location.href = url;// TODO check!! not required
			}
		} catch(err) {
		}
	});
}
function displayPopupMessage(msg,titleMsg){
	AUI().use('aui-node','aui-base','liferay-util-window',function(A){
		titleMsg = titleMsg ? titleMsg : messageLbl;
	 var dialog =	Liferay.Util.Window.getWindow(
{
	title : titleMsg,	
dialog: {
					bodyContent : msg,
					centered : true,
					//title : titleMsg,
					cache: false,
					destroyOnClose: true,
					destroyOnHide: true,
					height : 250,
					width : 400,
					modal : true,
					constrain2view : true,
					toolbars:{ footer:[{label:okLbl, on: { click:function() {showChallengePage(); dialog.hide();}}}]}
				}}).render();
		
	});
}
