package com.sambaash.platform.constant;

// Contains the constants, to represent names/labels, properties used in response from form builder (or) request to form builder
public interface FormConstants {

	// labels used in form schema response json 
	String KEY_HTML_FORM_ID = "htmlFormId";
	String KEY_HTML_FORM_SCHEMA = "htmlFormSchema";
	String KEY_ID = "id";
	String KEY_COMPONENT = "component";
	String KEY_LABEL = "label";
	String KEY_OPTIONS = "options";
	String KEY_VALUE_BIGV = "Value";
	String KEY_TEXT_BIGT = "Text";
	String KEY_TEXT = "text";
	String kEY_OUTPUT = "output";
	
	// labels used in storage response json
	
	String KEY_FORM_STORAGE_ID = "formStorageId";
	String KEY_STEP_1 = "step1";
	String KEY_STEP_FORMAT = "step%S";
	String KEY_STEP = "step";
	String KEY_VALUE = "value";
	String KEY_OPTION_LIST = "optionlist";
	String KEY_CONTENT = "content";
	String KEY_ATTACHMENTS = "attachments";
	String KEY_STORAGE_ID = "formStorageId";
	String KEY_ATTACHMENT_NAME = "attachmentName";
	String KEY_URL = "url";
	String KEY_FIELD_ID = "fieldId";
	
	
	
	// COMPONENTS
	String COMPONENT_MULTI_SELECT_ = "multipleselect";
	String COMPONENT_SELECT = "select";
	String COMPONENT_CHECKBOX = "checkbox";
	String COMPONENT_TEXT_INPUT = "textInput";
	String COMPONENT_NAME_INPUT = "nameInput";
	String COMPONENT_FILE_UPLOAD = "fileupload";
}
