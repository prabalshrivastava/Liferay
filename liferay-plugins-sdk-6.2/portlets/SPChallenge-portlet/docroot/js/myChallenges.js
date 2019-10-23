var ajax;
var pageNo = 0;

function initializeMyChallenges(ajaxUrl) {
	setAjaxUrl(ajaxUrl);
	sendRequest(pageNo);
}

function initChallengeApplicants(ajaxUrl) {
	setAjaxUrl(ajaxUrl);
	sendApplicantsRequest(pageNo)
}

function sendRequest(pageNum) {
	AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated', function(A) {
		var container = A.one("#resultsContainer");
		container.all("li").remove();
		startPreLoader('latestChallengesSlider');
		A.io.request(ajax, {
			dataType : 'json',
			method : 'POST',
			sync : true,
			data : {
				pageNo : pageNum,
			},
			on : {
				success : function() {
					stopPreLoader('latestChallengesSlider');
					onSuccess(this, A);
				},
				failure : function() {
					stopPreLoader('latestChallengesSlider');
					alert(errorFetchingResult);
				}
			}
		});
		function onSuccess(obj, A) {
			var data = obj.get("responseData");
			var container = A.one("#resultsContainer");
				if(data && data.items && data.items.length > 0) {
				    var sampleSection = A.one("#challengeSectionListItem");
				    var noChalls = A.one(".noChalls");
				    if(noChalls)
				    	noChalls.remove();
				    for(var i = 0, tol = data.items.length; i < tol; i++){
						try {
							var item = data.items[i];
							var dup = sampleSection.clone();
							dup.set("id","challengeSectionListItem"+i);
							var section = dup.one("#challengeSection"); 
							section.set("id","challengeSection_" + (i+1));
							section.addClass("result_item_" + (i+1));
							dup.one("#challengeImage").setAttribute('src', item.logoUrl);
							dup.one("#challengeName").setContent(shorten(item.name, 55));
							dup.one("#challengeApplyDate").setContent(item.endDate);
							dup.one("#challengeViewUrl").setAttribute('href', item.friendlyUrl);
							dup.one("#description").setContent(item.description);
					/*		if(item.editfriendlyUrl) {
								dup.one("#challengeEditUrl").setAttribute('href', item.editfriendlyUrl);
								dup.one("#challengeEditUrl").removeAttribute("style");
							} */
							dup.appendTo(container);
						} catch(error) {
							console.log(error);
						}
					}
				} else {
					container.get('parentNode').html('<div class="section_box_content latestChallenges"><span class="noChalls" style="font-size: 12pt">'+ noActiveBrief + '</span></div>');
				}
			if(data){
				if(data.pageNo){
					pageNo = data.pageNo;
				}
			/*	var loadMoreButton = A.one("#loadMore");
				var loadprevButton = A.one("#loadPrev");
				var prevStyle = "none";
				var moreStyle = "none";
				if(!data.items.length == 0) {
					if (data.moreDocsAvailable) {
						moreStyle = "inline-block";
					}
					if (pageNo > 1) {
						prevStyle = "inline-block";
					}
				}
				loadprevButton.setStyle("display" , prevStyle);
				loadMoreButton.setStyle("display" , moreStyle); */
			}
			
		}
	});
}


function sendApplicantsRequest(pageNum) {
	AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated', function(A) {
		var container = A.one("#applicantResultsContainer");
		container.all("li").remove();
		A.io.request(ajax, {
			dataType : 'json',
			method : 'POST',
			sync : true,
			data : {
				pageNo : pageNum,
			},
			on : {
				success : function() {
					onSuccess(this, A);
				},
				failure : function() {
					alert(errorFetchingResult);
				}
			}
		});
		function onSuccess(obj, A) {
			var data = obj.get("responseData");
			var container = A.one("#applicantResultsContainer");
				if(data && data.items && data.items.length > 0) {
				    var sampleSection = A.one("#applicantSectionListItem");
				    var noChalls = A.one(".noChalls");
				    if(noChalls)
				    	noChalls.remove();
				    for(var i = 0, tol = data.items.length; i < tol; i++){
						try {
							var item = data.items[i];
							var dup = sampleSection.clone();
							dup.set("id","applicantSectionListItem" + i);
							var section = dup.one("#applicantSection"); 
							section.set("id","applicantSection_" + (i+1));
							section.addClass("result_item_" + (i+1));
							dup.one("#applicantImage").setAttribute('src', item.logoUrl);
							dup.one("#challengeImage").setAttribute('src', item.challengeLogoUrl);
							dup.one("#applicantName").setContent(item.orgName);
							dup.one("#challengeName").setContent(item.challengeName);
							dup.one("#applicantViewUrl").setAttribute('href', item.friendlyUrl);
							dup.one("#challengeUrl").setAttribute('href', item.challengeUrl);
							dup.one("#startupUrl").setAttribute('href', item.startupUrl);
							dup.appendTo(container);
						} catch(error) {
							console.log(error);
						}
					}
				} else {
					container.html('<span class="noChalls" style="font-size: 12pt">' + noApplReceived + '</span>');
				}
			if(data){
				if(data.pageNo){
					pageNo = data.pageNo;
				}
			}
			
		}
	});
}

function setAjaxUrl(ajaxUrl) {
	ajax = ajaxUrl;
}

function updateCustomStatus(obj, operation, applicantId) {
	AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated', function(A) {
		var status = A.one(obj).attr('checked');
		A.io.request(ajax, {
			dataType : 'json',
			method : 'POST',
			sync : true,
			data : {
				spChallengeApplicantId: applicantId,
				statusType: operation,
				active: status,
				action: 'setApplicantStatus'
			},
			on : {
				success : function() {
					var resp = this.get("responseData");
				},
				failure : function() {
					if(isActiveUser()) {
						alert(saveInfoFailed);
					} else {
						alert(sessionTimeout);
						window.location.href= "/signin";
					}
				}
			}
		});
	});
}

function updateApplicationStatus(obj, applicantId) {

	AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated', function(A) {
		var op = A.one(obj).attr('op');
		var status = op ==='reject' ? -1 :
					 op ==='approve' ? 1 : 
					 op	==='maybe' ? 2 : 0;
		A.io.request(ajax, {
			dataType : 'json',
			method : 'POST',
			sync : true,
			data : {
				spChallengeApplicantId: applicantId,
				applicationStatus: status,
				action: 'setApplicationStatus'
			},
			on : {
				success : function() {
					var resp = this.get("responseData");
					if (status === 1) {
						var clickedDiv = A.one(obj).ancestor('div');
						clickedDiv.removeClass('statuspending');
						clickedDiv.addClass('Sucess');
						var theOtherDiv = A.one(obj).ancestor('td').next('td').one('div.statusSec');
						theOtherDiv.removeClass('statuspending');
						theOtherDiv.removeClass('Sucess');
						var theOtherDiv1 = A.one(obj).ancestor('td').next('td').next('td').one('div.statusSec');
						theOtherDiv1.removeClass('statuspending');
						theOtherDiv1.removeClass('Sucess');
					} else if (status === 2) {
						var clickedDiv = A.one(obj).ancestor('div');
						clickedDiv.removeClass('statuspending');
						clickedDiv.addClass('Sucess');
						var thebeforeDiv = A.one(obj).ancestor('td').previous('td').one('div.statusSec');
						thebeforeDiv.removeClass('statuspending');
						thebeforeDiv.removeClass('Sucess');
						var theOtherDiv = A.one(obj).ancestor('td').next('td').one('div.statusSec');
						theOtherDiv.removeClass('statuspending');
						theOtherDiv.removeClass('Sucess');
					} else if (status === -1) {
						var clickedDiv = A.one(obj).ancestor('div');
						clickedDiv.removeClass('statuspending');
						clickedDiv.addClass('Sucess');
						var theOtherDiv = A.one(obj).ancestor('td').previous('td').one('div.statusSec');
						theOtherDiv.removeClass('statuspending');
						theOtherDiv.removeClass('Sucess');
						var theOtherDiv1 = A.one(obj).ancestor('td').previous('td').previous('td').one('div.statusSec');
						theOtherDiv1.removeClass('statuspending');
						theOtherDiv1.removeClass('Sucess');
					} else if (status === 0) {
						var theOtherDiv = A.one('#successColumn_'+applicantId).ancestor('td').one('div.statusSec');
						theOtherDiv.addClass('statusPending');
						theOtherDiv.removeClass('Sucess');
						var theOtherDiv1 = A.one('#mayBeColumn_'+applicantId).ancestor('td').one('div.statusSec');
						theOtherDiv1.addClass('statusPending');
						theOtherDiv1.removeClass('Sucess');
						var theOtherDiv2 = A.one('#unsuccessColumn_'+applicantId).ancestor('td').one('div.statusSec');
						theOtherDiv2.addClass('statusPending');
						theOtherDiv2.removeClass('Sucess');
					} else {
						A.one(obj).ancestor('tr').all('div.statusSec').addClass('statusPending');
						A.one(obj).ancestor('tr').all('div.statusSec').removeClass('Sucess');
					}
				},
				failure : function() {
					if(isActiveUser()) {
						alert(saveInfoFailed);
					} else {
						alert(sessionTimeout);
						window.location.href= "/signin";
					}
				}
			}
		});
	});
}

function sendBriefApplicationResponse(obj, challengeId) {
	AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated', function(A) {
		A.one('.cmi-button-wrap').hide();
		var op = A.one(obj).attr('op');
		var status = op ==='reject' ? -1 :
					 op ==='approve' ? 1 : 0;
		A.io.request(ajax, {
			dataType : 'json',
			method : 'POST',
			sync : true,
			data : {
				searchChallenge: challengeId,
				applicationStatus: status,
				action: 'sendApplicationResponse'
			},
			on : {
				success : function() {
					var resp = this.get("responseData");
					A.one('.challenge_applicants').insert('<div class="alert alert-info" > Response emails sent! </div>',A.one('.inline-block.margin-left-half'));
					A.one('.inline-block.margin-left-half').hide();
				},
				failure : function() {
					if(isActiveUser()) {
						alert(emailSendFailed);
					} else {
						alert(sessionTimeout);
						window.location.href= "/signin";
					}
				}
			}
		});
	});
}
