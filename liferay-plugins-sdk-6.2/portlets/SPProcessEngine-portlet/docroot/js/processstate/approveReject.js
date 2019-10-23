var approveReject = function(config) {
	var AArray = A.Array;
	this.init = function(config) {
		this.pns = config.pns;
		this.ajaxUrl = config.ajaxUrl;
		this.approveNode = A.one("#" + pns + "approve");
		this.rejectNode = A.one("#" + pns + "reject");
		//processStateObj defined in process.jsp
		this.processStateId = processStateObj.processStateId;
		this.currentStatusTypeId = processStateObj.currentStatusTypeId;
		this.initApprove();
		this.initReject();
	}

	this.initApprove = function() {
		var instance = this;
		instance.approveNode.on("click", function() {
			instance.approveAction();
		});
	}
	this.initReject = function() {
		var instance = this;
		instance.rejectNode.on("click", function() {
			instance.rejectAction();
		});
	}

	this.approveAction = function() {
		var instance = this;
		var data = {};
		data.action = "approve";
		instance.serverCall(data);
	}
	this.rejectAction = function() {
		var instance = this;
		var data = {};
		data.action = "reject";
		instance.serverCall(data);
	}

	this.serverCall = function(data) {
		var instance = this;
		data = data ? data :{};
		//processStateId variable defined in process.jsp
		data.processStateId = instance.processStateId;
		data.currentStatusTypeId = instance.currentStatusTypeId;
		var contentId = "mainContainer";
		startPreLoader(contentId);
		A.io.request(instance.ajaxUrl,{
			dataType: 'json',
			method: 'POST',
			data: data,
			on: {
	            complete: function() {
	            	// this is called before success and failure methods. So right place for any post processing of request.
	            	stopPreLoader(contentId);
	            },
	            success: function() {
	                var data = this.get('responseData');
	                instance.handleResponse(data);
	              },
			    failure : function() {
			    }
			}
		});
	}

	this.handleResponse = function(data) {
		var instance = this;
		if (data) {
			if (data.error) {
				instance.displayError(data.error);
			}
			if (data.validations && data.validations.length > 0) {
				//alert(data.validations);
				instance.displayError(data.validations);
			}
			if (data.msg) {
				// Success case
				instance.disableButtons();
				instance.displaySuccessMsg(data.msg);
				//TODO: disable approve/reject buttons
			}
		}else {
			//TODO: instead of alert. declare error div and keep filling with error msg
			//handle due to some reason data is null
			instance.displayError("Error while processing your request");
		}
	}

	this.displayError = function(error) {
		var msgNode = A.one("#approveRejectmsg");
		if (msgNode) {
			msgNode.set('text',error);
			msgNode.addClass('alert');
			msgNode.addClass('alert-error');
			msgNode.removeClass('alert-success');
		}
	}
	this.displaySuccessMsg = function(msg) {
		var msgNode = A.one("#approveRejectmsg");
		if (msgNode) {
			msgNode.set('text',msg);
			msgNode.removeClass('alert-error');
			msgNode.addClass('alert');
			msgNode.addClass('alert-success');
		}
	}

	this.disableButtons = function() {
		var instance = this;
		instance.approveNode.set("disabled",true);
		instance.rejectNode.set("disabled",true);
	}

	this.init(config);
}