function ajaxCallAPI(method, action, data, successHandler, failHandler) {

	AUI().use(
			'aui-io-request-deprecated',
			'aui-base',
			function(A) {
				var _data = {};
				_data[namespace + 'formId'] = data.formId;
				if (mode == "view" || mode == "edit"
						|| (mode == "copy" && method == "GET")) {
					_data[namespace + 'formStorageId'] = data.formStorageId;
				} else {
					_data[namespace + 'formStorageId'] = "0";
				}
				_data[namespace + 'formType'] = data.formType;
				_data[namespace + 'action'] = action;
				if (data) {
					_data[namespace + 'data'] = JSON.stringify(data);

				}
				A.io.request(ajaxUrl, {
					dataType : 'json',
					method : method,
					data : _data,
					on : {
						success : successHandler,
						failure : failHandler || function() {

						}
					}
				});
			});
}
function ajaxCall(method, action, ajaxUrl, data, successHandler, failHandler) {
	var thisInstance = this;

	thisInstance.namespace = namespace;
	AUI()
			.use(
					'aui-base',
					'aui-io-request-deprecated',
					function(A) {
						var _data = {};
						_data[thisInstance.namespace + 'formStorageId'] = "";
						if (action == "update" || action == "loadData"
								|| action == "loadList" || action == "archive") {
							_data[thisInstance.namespace + 'formStorageId'] = data.formStorageId;
						}
						_data[thisInstance.namespace + 'formType'] = data.formType;
						_data[thisInstance.namespace + 'action'] = action;
						if (action == "update")
							_data[thisInstance.namespace + 'action'] = "persist";
						if (data) {
							_data[thisInstance.namespace + 'data'] = JSON
									.stringify(data);
						}
						A.io
								.request(
										ajaxUrl,
										{
											dataType : 'json',
											method : method,
											data : _data,
											on : {
												success : successHandler,
												failure : failHandler
														|| function() {
															thisInstance
																	.debug("Error in the ajax call.");
														}
											}
										});
					});
}
function displayMessage(type, message, duration) {
	scrollToTop();
	var alert_div = document.getElementById("alert_msg");
	alert_div.innerHTML = message;
	alert_div.classList.add("alert-" + type);
	alert_div.style.display = "block";
	setTimeout(function() {
		alert_div.style.display = "none";
	}, duration);
	console.log(message);
}
var timeOut;
function scrollToTop() {
	if (document.body.scrollTop != 0 || document.documentElement.scrollTop != 0) {
		window.scrollBy(0, -50);
		timeOut = setTimeout('scrollToTop()', 10);
	} else {
		clearTimeout(timeOut);
	}
}
function reloadPage() {
	window.location.reload();
}
function findAncestor(el, cls) {
	while ((el = el.parentElement) && !el.classList.contains(cls))
		;
	return el;
}