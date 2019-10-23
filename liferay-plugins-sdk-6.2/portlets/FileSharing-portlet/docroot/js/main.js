
function buildTree(ajaxUrl) {
					AUI().use('aui-node','aui-base' , 'aui-io-request-deprecated','aui-tree-view',
							'aui-aria',
							  'liferay-util-window',
							  'aui-overlay-manager-deprecated',
							  'dd-constrain',
							  function(A) {
						var items;
						A.io.request(ajaxUrl,{
							dataType : 'json',
							method : 'POST',
							data : {
								action: 'getAllShares'
							},
							on : {
								success : function() {
									var data = this.get('responseData');
									items =  data.items;
									if (items) {
										var treeobj=new A.TreeView(
											{
												boundingBox: '#treeContainer',
												children: items,
												on: {
													lastSelectedChange:
														function(event) {
//														   var classPk = event.newVal._conf.data.value.cssClass;
														   var classPk = event.newVal.get('id');
														   folderObj.currentName = event.newVal.get('label');
														   if (classPk) {
														    var url = '';
														    var imgUrl = '';
														    if (classPk.indexOf('fd') != -1) {
														    	var folderId = classPk.substring(classPk.indexOf('fd')+2);
																url = "/FileSharing-portlet/download?folderIdTest=" + folderId;
																folderObj.currentFolderId = folderId;
																folderObj.currentType = 'folder';
															}else {
																url = "/FileSharing-portlet/download?fileEntryId=" + classPk.substring(2);
																imgUrl = '<img alt="Download" src="' + url + '"/>';
																folderObj.currentType = 'file';
															}
														    if (folderObj.currentType == 'file' && (folderObj.currentName.indexOf('<a') < 0 )) {
														       var dialog = Liferay.Util.Window.getWindow(
{
dialog: {
														            bodyContent: imgUrl,
														            height: '50%',
														            width: '70%',
														            modal: true,
														            centered: true,
														            id: 'fsPreviewDialog',
														            buttons:[
															            {label:'Download',on: {click:function() {
															            	document.location.href = url;
															                this.close();
															               }}
															            },
															            {
															             label:'Close', on: { click:function() {
															            	 this.close();
															             }}
															            }]
														          }}
														        ).render();
															  }
														   }
														   refreshLabel(ajaxUrl, classPk);
													   }
												}
											});
										treeobj.render();
									}

									if (items.length == 0) {
										AUI().use('aui-node','aui-base',function(A) {
												A.one("#errorMsgBox").html('<div class="portlet-msg-info">There are no files/folder shared with you</div>');
										});
									}
								}
							}});

					});
}


//1. refreshes the label in the share container
//2. disables upload if the parentfolderid has no write permissions
function refreshLabel(ajaxUrl, parentfolderId) {
	AUI().use('aui-node', 'aui-base', function(A) {
		if (folderObj.currentType == 'folder') {
			A.one("#folderLabel").html(getLabel(folderObj.currentName));
		}
	});

	if (folderObj.currentType == 'folder') {
		AUI().use('aui-io-request-deprecated', function(A) {
			A.io.request(ajaxUrl, {
				dataType : 'json',
				method : 'POST',
				data : {
					action : 'checkPermission',
					folderId : parentfolderId
				},
				on : {
					success : function() {
						var data = this.get('responseData');
						var container = A.one(".sp_dragdrop");
						if (data.canWrite == true) {
							container.setAttribute('id', 'hide-content1');
							document.getElementById("drop-text1").innerHTML = 'Drag & Drop Your Files Here';
							document.getElementById("drop-text1").removeAttribute('style');
						} else {
							container.setAttribute('id', 'hide-content');
							document.getElementById("drop-text1").innerHTML = 'You do not have write access to this folder';
							document.getElementById("drop-text1").setAttribute("style", "color:red");
						}
					}
				}
			});
		});
	}
}

function getLabel(str) {
	if (str.indexOf('<a') > 0 )
		return str.substring(0, str.indexOf('<a'));
	else
		return str;
}
