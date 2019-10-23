
function deleteJob(jobId, portletId) {
	sendRequest('actionDeleteJob', jobId, portletId);
}

function pauseJob(jobId, portletId) {
	sendRequest('actionPauseJob', jobId, portletId);
}

function resumeJob(jobId, portletId) {
	sendRequest('actionResumeJob', jobId, portletId);
}

function rescheduleJob(jobId, portletId) {
	
}

function sendRequest(requestType, jobId, portletId) {
	AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated','liferay-util-window', function(A) {
		var schedData = {};
		schedData["_" + portletId + "_action"] = requestType;
		schedData["_" + portletId + "_jobId"] = jobId;
		A.io.request(schedulerAjaxUrl, {
			dataType : 'json',
			method : 'POST',
			sync : true,
			data : schedData,
			on : {
				success : function() {
					var message = '';
					var titleMsg = '';
					if (this.get("responseData") == true) {
						message = '<p>Request processed successfully</p>';
						titleMsg = 'Success';
					} else if (this.get("responseData").errorMsg) {
						message = this.get("responseData").errorMsg;
						titleMsg = "Error!";
					} else {
						message = '<p>Error processing request!</p>';
						titleMsg = "Error!";
					}

					Liferay.Util.Window.getWindow({
								dialog : {
									bodyContent : message,
									centered : true,
									destroyOnClose : true,
									height : 155,
									width : 380,
									modal : true,
									constrain2view : true
								},
								title : titleMsg
					}).render();
				},
				failure : function() {
					alert('Failed to save information for the challenge');
				}
			}
		});
	});
}