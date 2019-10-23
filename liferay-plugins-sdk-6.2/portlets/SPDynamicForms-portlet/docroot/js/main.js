/*
 * The DynamicForm javascript class is written in ES6.
 * As of writing, ES6 is not yet fully supported by most browsers.
 * Hence, we need to separate the script so we can use Babel to translate it to ES5.
 */
function initializeView(apiUrl, userInfo, formContainerId, formId, formStorageId, namespace, ajaxUrl, readOnly) {
	var form = new SPDynamicForm(apiUrl, formContainerId, formId, formStorageId, ajaxUrl, namespace);
	form.userInfo = userInfo;
	form.load({readOnly : readOnly});
}
