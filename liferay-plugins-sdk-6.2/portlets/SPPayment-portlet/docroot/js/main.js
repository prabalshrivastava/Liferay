AUI().ready('aui-node', 'aui-base', 'aui-io-request-deprecated', function(A) {
	A.one('#payButton').on('click', function() {
		//
		// //validations
		// var validator = eval('Liferay.Form._INSTANCES.' + namespace +
		// formName + '.formValidator');
		// validator.validate();
		// if (validator.hasErrors()) {
		// validator.focusInvalidField();
		// return;
		// }
		var obj = {};
		// startPreLoader('form');

		// remove namespace and send as part of request
		var ele = A.all(".form input");
		var len = namespace.length;
		ele.each(function() {
			var name = this.get("name");
			name = name.substring(len);
			var val = this.val();
			if (val != null)
				obj[name] = val;
		});

		obj['action'] = 'createPayment';

		A.io.request(resourceURL, {
			dataType : 'json',
			method : 'POST',
			data : obj,
			on : {
				success : function() {
				},
				failure : function() {
				}
			}
		});

	});
});