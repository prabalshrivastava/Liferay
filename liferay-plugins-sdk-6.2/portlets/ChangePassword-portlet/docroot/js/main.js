var responseData;

function submitUpdatePassword() {
	AUI().use('aui-io-request', function(A) {
		// var form = document.getElementById(namespace +"updatepassword");

		var liferayForm = Liferay.Form.get(namespace + "updatepassword");

		if (liferayForm) {
			var validator = liferayForm.formValidator;

			if (A.instanceOf(validator, A.FormValidator)) {
				validator.validate();

				hasErrors = validator.hasErrors();
				if (hasErrors) {
					validator.focusInvalidField();
				} else {
					submit();
				}
			}
		}
	});
}

function clearFields() {
	document.getElementById(namespace + "current").value = "";
	document.getElementById(namespace + "password1").value = "";
	document.getElementById(namespace + "password2").value = "";

}
function submit() {
	console.log("getFomrsList");
	AUI().use(
			'aui-io-request',
			function(A) {

				var api_url = formsUrl;
				var _data = {};
				// _data[namespace + 'api_url'] = _url;
				_data[namespace + 'action'] = "update";
				_data[namespace + 'current'] = document
						.getElementById(namespace + "current").value;
				_data[namespace + 'password1'] = document
						.getElementById(namespace + "password1").value;
				_data[namespace + 'password2'] = document
						.getElementById(namespace + "password2").value;

				A.io.request(api_url,
						{
							method : 'GET',
							data : _data,
							on : {
								success : function() {

									responseData = JSON.parse(this
											.get('responseData'));

									if (responseData.status == true) {
										displayMessage('alert_msg_password','success',
												responseData.msg.toString(),
												50000)
									} else {
										displayMessage('alert_msg_password','error',
												responseData.msg.toString(),
												50000)
									}

								},
								failure : function() {
									displayMessage('alert_msg_password','error',
											'bad request',
											5000)  
								}
							}
						});
			});
}
