package com.sambaash.platform.taglib.ui;

import javax.servlet.http.HttpServletRequest;

import com.liferay.taglib.util.IncludeTag;

public class MakeCopyTag extends IncludeTag {

	public void setFormId(String formId) {
		_formId = formId;
	}

	public void setModelName(String modelName) {
		_modelName = modelName;
	}
	
	public void setClassName(String className) {
		_className = className;
	}
	public void setClassPK(long classPK) {
		_classPK = classPK;
	}
	public void setReadOnly(String readOnly) {
		_readOnly = readOnly;
	}
	public void setFormStorageId(String formStorageId) {
		_formStorageId = formStorageId;
	}
	public void setCssClass(String cssClass) {
		_cssClass = cssClass;
	}

	@Override
	protected void cleanUp() {
		_formId = null;
		_className = null;
		_modelName = null;
		_classPK = 0;
		_readOnly = null;
		_formStorageId = null;
		_cssClass = null;
	}

	@Override
	protected String getPage() {
		
		return _PAGE;
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute(
			"sp-formio:CopyFormIO:formId", _formId);
		request.setAttribute(
			"sp-formio:CopyFormIO:modelName", _modelName);
		request.setAttribute(
			"sp-formio:CopyFormIO:className", _className);
		request.setAttribute(
			"sp-formio:CopyFormIO:classPK", String.valueOf(_classPK));
		request.setAttribute(
			"sp-formio:CopyFormIO:readOnly", _readOnly);
		request.setAttribute(
			"sp-formio:CopyFormIO:cssClass", _cssClass);
		request.setAttribute(
			"sp-formio:CopyFormIO:formStorageId", _formStorageId);
	}

	private static final String _PAGE =
		"/html/taglib/ui/makecopy/page.jsp";

	private String _formId;
	private String _className;
	private long _classPK;
	private String _readOnly;
	private String _cssClass;
	private String _formStorageId;
	private String _modelName;
}