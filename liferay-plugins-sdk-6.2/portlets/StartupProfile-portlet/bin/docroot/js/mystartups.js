function initializeMyStartups(userId, isScreenName, ajax,pathImage,namespace1,failRetrieveMsg,failDeleteMsg,confirmDelete) {
	namespace = namespace1;
	startPreLoader('myStartups');
	AUI().use('aui-base', 'aui-node', 'aui-io-request-deprecated', function(A) {
		A.io.request(ajax,{
			dataType : 'json',
			method : 'POST',
			sync : true,
			data : {
				userId :  userId,
				sp_p_auth: Liferay.authToken
			},
			on : {
				success : function() {
					var resp = this.get('responseData');
					var container = A.one('#mystartupsContainer');
					if(resp.length < 1) {
						stopPreLoader('myStartups');
						return;
					}
					
					var menuItems = A.one(".mystartup_content ul");
					for (i = 0; i < (resp.length); i++) {
						var data = resp[i];
						
						var liNode = A.Node.create("<li></li>");
						var logoNode = A.Node.create("<span class='startup_logo'><img alt='logo' src='" + data.logoUrl + "'/></span>");
						var nameNode = null;
						if (!isScreenName) {
							nameNode = A.Node.create("<span class='startup_name'><a href='" + data.friendlyUrl + "'>" + data.name + "</a></span>");
						} else {
							nameNode = A.Node.create("<span class='startup_name'>" + data.name + "</span>");
						}
						var actionsNode =  A.Node.create("<span class='myStartupActionIcons'></span>");
						liNode.set("id", "org_" + data.orgId);
						if(!data.profileComplete){
							liNode.addClass("incompleteProfile");
						} else {
							liNode.addClass("completeProfile");
						}
						if (!isScreenName) {
							var actionNode = A.Node.create("<a href="+ data.friendlyUrl+ "><img alt='View' src='" + pathImage +"/header-footer/view.svg'></img></a>");
							actionNode.appendTo(actionsNode);
							actionNode = A.Node.create("<a href="+ data.editFriendlyUrl+ "><img alt='Edit' src='" + pathImage +"/header-footer/edit.svg'></img></a>");
							actionNode.appendTo(actionsNode);
							actionNode = A.Node.create("<a href='javascript:;'><img alt='Delete' src='" + pathImage +"/content/delete-icon.png'></img> </a>");
							actionNode.setAttribute('data-id',data.orgId);
							actionNode.on("click",function(){
								deleteOrg(this.getAttribute('data-id'),ajax,failDeleteMsg,confirmDelete);
							});
							actionNode.appendTo(actionsNode);
						}
						logoNode.appendTo(liNode);
						nameNode.appendTo(liNode);
						if (!isScreenName) {
							actionsNode.appendTo(liNode);
						}
						
						liNode.appendTo(menuItems);
					}
					A.one("#noStartups").remove();
					stopPreLoader('myStartups');
				},
				failure : function() {
					stopPreLoader('myStartups');
					alert(failRetrieveMsg);
				}
			}
		});
	});
}

function deleteOrg(orgId, ajax,failDeleteMsg,confirmDelete) {
	if(!confirm(confirmDelete))
		return;
	AUI().use('aui-base', 'aui-node', 'aui-io-request-deprecated', function(A) {
		A.io.request(ajax, {
			dataType : 'json',
			method : 'POST',
			data : {
				action: 'deleteProfile',
				orgId: orgId,
				sp_p_auth: Liferay.authToken
			},
			on : {
				success : function() {
					if(this.get('responseData') == 'SUCCESS');
						A.one("#mystartupsContainer #org_" + orgId).remove();
				},
				failure : function() {
					alert(failDeleteMsg);
				}
			}
		});
	});
}
