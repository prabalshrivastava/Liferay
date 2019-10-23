package com.sambaash.platform.taglib.ui;

import javax.servlet.http.HttpServletRequest;

import com.liferay.taglib.util.IncludeTag;

public class ListingTag extends IncludeTag {

	public void setModelName(String modelName) {
		_modelName = modelName;
	}
	public void setCssClass(String cssClass) {
		_cssClass = cssClass;
	}

	@Override
	protected void cleanUp() {
		_modelName = null;
		_cssClass = null;
	}
	@Override
	protected String getPage() {
		return _PAGE;
	}
	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute(
			"sp-formio:Listing:modelName", _modelName);
		
		request.setAttribute(
			"sp-formio:Listing:cssClass", _cssClass);
	}
	private static final String _PAGE =
		"/html/taglib/ui/common-listing/page.jsp";

	private String _modelName;
	private String _cssClass;

}