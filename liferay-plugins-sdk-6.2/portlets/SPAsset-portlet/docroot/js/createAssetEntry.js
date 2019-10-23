var createSPAssetEntry = function(config){
	
	this.init = function(config){
		this.config = config;
		this.uploadConfig = config.uploadConfig;
		this.pns = config.pns;
		this.ajaxUrl = config.ajaxUrl;
		
		this.titleNode = A.one("#" + this.pns + "title");
		this.assetEntryIdNode =  A.one("#" + this.pns + "spAssetEntryId");
		
		this.titleChangeListener();
		this.initializeUploader();
		this.submitListener();
	};
	
	
	this.initializeUploader = function(){
		var instance = this;
		var titleNode = instance.titleNode;
		var assetEntryIdNode = this.assetEntryIdNode;
		var uploadConfig = instance.uploadConfig;
		var assetEntryIdNode = this.assetEntryIdNode;
		uploadConfig.hook_beforeStartupload = function(uploader,file,params){
			params.spAssetEntryId =  assetEntryIdNode.val();
			console.log("in " + uploadConfig.beforeStartupload +  "  " + params.spAssetEntryId );
		};
		uploadConfig.hook_beforeFileUploadProcess = function(uploader,event,fileList){
			if(titleNode.val().trim() == ''){
				alert("Please provide title before uploading any files");
				titleNode.focus();
				return [];
			}
			if(assetEntryIdNode.val() == ''){
				console.log("error. assetentryid is null");
				return [];
			}
			return fileList;
		};
		uploadConfig.hook_onDeleteClick = function(uploaer,data){
			data = data ? data:{};
			data.spAssetEntryId = assetEntryIdNode.val(); 
		}
		instance.uploader = new Liferay.Upload(instance.uploadConfig);
	};
	
	this.titleChangeListener = function(){
		var instance = this;
		var titleNode = instance.titleNode;
		titleNode.on('change',function(eve){
			if(titleNode.val().trim() != ''){
				instance.saveTitle();
			}	
		});
	};
	this.saveTitle = function(){
		var instance = this;
		var titleNode = instance.titleNode;
		var assetEntryIdNode = instance.assetEntryIdNode; 
		var spAssetEntryId = assetEntryIdNode.val();
        A.io.request(instance.ajaxUrl,{
            dataType: 'json',
            method: 'POST',
            sync : true,
            data: { 
            		action: 'saveTitle',
            		title: titleNode.val(),
           	 		spAssetEntryId:spAssetEntryId },
            on: {
            success: function() {
                var data=this.get('responseData');
                if(data.error){
                	alert(data.error);
                }else{
                	assetEntryIdNode.val(data.entryId);
                }
              }
            }
        });
	}
	
	this.submitListener = function(){
		var instance = this;
		A.one("#confirmButton").on("click",function(){
			var titleNode = instance.titleNode;
			var pns = instance.pns;
			if(titleNode.val().trim() != ''){
				instance.removeErrorClass(titleNode);
				A.one("#" + pns+ "fm").submit();
			}else{
				titleNode.focus();
				instance.addErrorClass(titleNode);
			}
		});
	}
	
	this.addErrorClass = function(node){
		if(node){
			node.addClass("error");
		}
	}
	this.removeErrorClass = function(node){
		if(node){
			node.removeClass("error");
		}
	}

	this.init(config);
}