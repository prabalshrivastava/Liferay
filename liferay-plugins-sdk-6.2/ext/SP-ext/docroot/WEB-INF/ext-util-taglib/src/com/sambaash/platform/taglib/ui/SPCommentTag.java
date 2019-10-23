package com.sambaash.platform.taglib.ui;

import javax.servlet.http.HttpServletRequest;

import com.liferay.taglib.util.IncludeTag;


public class SPCommentTag extends IncludeTag {

	public void setClassName(String className) {
		_className = className;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	@Override
	protected void cleanUp() {
		_className = null;
		_classPK = 0;
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute(
			"sp-ui:comment:className", _className);
		request.setAttribute(
			"sp-ui:comment:classPK", String.valueOf(_classPK));

		request.setAttribute(
				"sp-ui:comment:ajaxUrl", String.valueOf(_ajaxUrl));
		request.setAttribute(
				"sp-ui:comment:prefix", prefix);
	}

	private static final String _PAGE =
		"/html/sambaash/platform/taglib/sp-ui/comment/comments.jsp";

	private String _className;
	private long _classPK;
	private String _ajaxUrl;
	private String prefix;
	
	public String getAjaxUrl() {
		return _ajaxUrl;
	}

	public void setAjaxUrl(String _ajaxUrl) {
		this._ajaxUrl = _ajaxUrl;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

}