function SPResourcePerms(configObj){
	var A = null;
	var modifiedRoles = [];
	var pns;
	var isFolder;
	function init(configObj){
		AUI().use('aui-node','aui-base','aui-dialog','liferay-util-window',  'aui-overlay-manager-deprecated','dd-constrain','aui-aria',function(innerA){
			A = innerA;
			pns = configObj.pns;
			isFolder = configObj.isFolder;
			intializePermChangeListener();
			initializeSubmit();
		})
	}
	function intializePermChangeListener(){
		var allPerms = A.one("#" + pns + "rolesSearchContainerSearchContainer").all("input[type=checkbox]");
		allPerms.on("change",function(ev){
			var chkBox = ev.target;
			var name = chkBox.get('name');
			var roleId = name.split("_")[2];
			var found = false;
			for(var i = 0 ; i < modifiedRoles.length; i++){
				if(modifiedRoles[i] ==  roleId){
					found = true;
				}
			}
			if(!found){
				modifiedRoles.push(roleId);
			}
		});
	}
	function initializeSubmit(){
		A.one("#" + pns + "fm").on("submit",function(ev){
			ev.preventDefault();
			if(isFolder){
				if(modifiedRoles.length > 0){
					
				var dialog = 	Liferay.Util.Window.getWindow(
							{
							title : 'Message',
							dialog: {
							bodyContent : "<h5>You have modified the permissions for some roles.Do you want to apply these changes to subfolder and files ?</h5>",
							centered : true,
							cache: false,
							close:false,
							destroyOnClose: true,
							destroyOnHide: true,
							height : 250,
							width : 400,
							modal : true,
							constrain2view : true,
							toolbars:{ footer:[{label:'Ok', on: { click:function() {

				        	   	A.one("#"+pns + "propagateToChilds").val(true);
				        	    A.one("#" + pns + "modifiedRoleIds").val( modifiedRoles.toString());
				        	    dialog.hide();
				        	    A.one("#" + pns + "fm").submit();
				        	    
								}}},
								 {
							           label:'Do Not Apply', 
							           on: {click: function() {
							        	   A.one("#"+pns + "propagateToChilds").val(false);
							        	   A.one("#" + pns + "modifiedRoleIds").val("");
							        	   dialog.hide();
							        	    A.one("#" + pns + "fm").submit();
							        	    }
							           }
							        }
							]}
						}}).render();
					
			/*		Liferay.Util.Window.getWindow({
								bodyContent : "<h5>You have modified the permissions for some roles.Do you want to apply these changes to subfolder and files ?</h5>",
								centered : true,
								close:false,
								title : 'Message',
								height : 150,
								width : 400,
								modal : true,
								id: 'fsPreviewDialog',
								//constrain2view : true,
								buttons: [
								          {
								           label:'Apply', 
								           on:{click:function() {
								        	   	A.one("#"+pns + "propagateToChilds").val(true);
								        	    A.one("#" + pns + "modifiedRoleIds").val( modifiedRoles.toString());
								        	    this.close();
								        	    A.one("#" + pns + "fm").submit();
								        	    }
								           	}
								          },
								          {
									           label:'Do Not Apply', 
									           on: {click: function() {
									        	   A.one("#"+pns + "propagateToChilds").val(false);
									        	   A.one("#" + pns + "modifiedRoleIds").val("");
									        	    this.close();
									        	    A.one("#" + pns + "fm").submit();
									        	    }
									           }
									        }
									]
							}).render().show(); */
					return false;
					
				/*	var propgate = window.confirm("You have modified the permissions for some roles." +
							"\n Press Ok to apply the changes to subfolders and files. Press Cancel to stop applying changes to subfolder and files");
					if(propgate){
						A.one("#"+pns + "propagateToChilds").val(propgate);
						A.one("#" + pns + "modifiedRoleIds").val( modifiedRoles.toString());
					}*/
				}else{
					
					A.one("#" + pns + "fm").submit();
				}
			}
			
			
		});
	}
	init(configObj);
}