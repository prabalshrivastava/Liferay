/*
 * Extend this class if you want to have more control over the
 * validation and saving process just like when you code a portlet.
 * Meaning you should retrieve/save/delete the data into your 
 * portlet model explicitly.
 * Unlike, DynamicForm class from the SPDynamicForms-portlet,
 * the data will NOT be saved into SPFormStorage.
 * 
 * Refer to methods that can be custom implemented from SPForm.
 * Here are the examples of such methods:
 *      afterFormLoaded()
 *      afterSaved(submission)
 *      customValidation(submission, next)
 *      customSubmission(submission)
 *      handleLoadingFailure(error)
 *      handleFormError(errorArray)
 *      previousPage(page)
 *      nextPage(page)
 */
class SPPortletForm extends SPForm {

    constructor(apiUrl, formContainerId, formId, ajaxUrl, namespace) {
        super(apiUrl, formContainerId, formId, ajaxUrl, namespace);
        this.formStorageId = formStorageId;
    };

}