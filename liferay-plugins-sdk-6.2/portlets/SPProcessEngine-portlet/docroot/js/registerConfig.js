var registerConfig = function(config) {
	var AArray = A.Array;
	this.init = function(config) {
		this.pns = config.pns;
		this.ajaxUrl = config.ajaxUrl;
		this.processNode = A.one("select[data-id=processId]");
		this.entityClassNode = A.one("select[data-id=classNameId]");
		this.classPKNode = A.one("select[data-id=classPK]");
		this.classPKSavedNode = A.one("#" + this.pns + "classPKSaved");
		this.modelData = config.modelData;
		this.classPKSavedCodeNode = A.one("#" + this.pns + "classPKSavedCode");
		this.initProcessChange();
	}

	this.initProcessChange = function() {
		var instance = this;
		// initially when page is loaded, load the pks as well
		instance.loadPKs();
		var selectd = instance.classPKSavedNode.val() ;
		if (selectd != '') {
			instance.classPKNode.val(selectd);
			instance.classPKSavedCodeNode.val(document.getElementById(selectd).getAttribute("code"));
		}

		instance.entityClassNode.on("change",function() {
			instance.loadPKs();
		})
	}

	// loading Entity Name dropdown
	this.loadPKs = function() {
		var instance = this;

		if (instance.entityClassNode.val() == '') {
			instance.populateClassPks(null);
			return;
		}

		var formContainerId = "formContainer";
		startPreLoader(formContainerId);
		data = {};
		data.action = "getPKs";
		data.entityClassId = instance.entityClassNode.val();
		A.io.request(instance.ajaxUrl,{
			dataType: 'json',
			method: 'POST',
			sync : true,
			data: data,
			on: {
			complete:function() {
				stopPreLoader(formContainerId);
			},
			success: function() {
				var data=this.get('responseData');
				if (data.error) {
					alert(data.error);
					instance.populateClassPks(null);
				}else {
					instance.populateClassPks(data.entities);
				}
			  },
			error :function() {
			}
			}
		});
	}
	this.populateClassPks = function(entities) {
		var instance = this;
		// empty it , irrrespective of response
		instance.classPKNode.all("*").remove();
		if (!entities) {
			return;
		}
		//Empty option
		var optionNode = A.Node.create("<option></option>");
		instance.classPKNode.appendChild(optionNode);

		AArray.each(entities,function(entity) {
			var optionNode = A.Node.create("<option>" + entity.name +  "</option>");
			optionNode.set("value",entity.id);
			optionNode.set("id",entity.id);
			if (entity.code){
				optionNode.setAttribute("code",entity.code);
			}else{
				optionNode.setAttribute("code","");
			}
			
			instance.classPKNode.appendChild(optionNode);
		});
	}
	this.init(config);
}
