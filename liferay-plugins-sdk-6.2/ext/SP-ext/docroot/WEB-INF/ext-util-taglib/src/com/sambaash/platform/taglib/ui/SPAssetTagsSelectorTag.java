package com.sambaash.platform.taglib.ui;

import javax.servlet.http.HttpServletRequest;

import com.liferay.taglib.util.IncludeTag;

/**
 * @author Clark Cui Jian Jun
 */
public class SPAssetTagsSelectorTag extends IncludeTag {

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
			"sp-ui:asset-tags-selector:className", _className);
		request.setAttribute(
			"sp-ui:asset-tags-selector:classPK", String.valueOf(_classPK));
	}

	private static final String _PAGE =
		"/html/sambaash/platform/taglib/sp-ui/asset_tags_selector/page.jsp";

	private String _className;
	private long _classPK;

}